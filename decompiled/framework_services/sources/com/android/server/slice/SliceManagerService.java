package com.android.server.slice;

import android.app.AppOpsManager;
import android.app.role.OnRoleHoldersChangedListener;
import android.app.role.RoleManager;
import android.app.slice.ISliceManager;
import android.app.slice.SliceSpec;
import android.app.usage.UsageStatsManagerInternal;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentProvider;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageManagerInternal;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.ShellCallback;
import android.os.UserHandle;
import android.util.ArrayMap;
import android.util.Slog;
import android.util.SparseArray;
import android.util.Xml;
import com.android.internal.app.AssistUtils;
import com.android.server.LocalServices;
import com.android.server.ServiceThread;
import com.android.server.SystemService;
import com.android.server.pm.Settings;
import com.android.server.wm.ActivityTaskManagerInternal;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileDescriptor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.function.Supplier;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: loaded from: classes3.dex */
public class SliceManagerService extends ISliceManager.Stub {
    private static final String TAG = "SliceManagerService";
    private final AppOpsManager mAppOps;
    private final UsageStatsManagerInternal mAppUsageStats;
    private final AssistUtils mAssistUtils;
    private final SparseArray<PackageMatchingCache> mAssistantLookup;
    private String mCachedDefaultHome;
    private final Context mContext;
    private final Handler mHandler;
    private final SparseArray<PackageMatchingCache> mHomeLookup;
    private final Object mLock;
    private final PackageManagerInternal mPackageManagerInternal;
    private final SlicePermissionManager mPermissions;
    private final ArrayMap<Uri, PinnedSliceState> mPinnedSlicesByUri;
    private final BroadcastReceiver mReceiver;
    private RoleObserver mRoleObserver;

    public static class Lifecycle extends SystemService {
        private SliceManagerService mService;

        public Lifecycle(Context context) {
            super(context);
        }

        @Override // com.android.server.SystemService
        public void onStart() {
            this.mService = new SliceManagerService(getContext());
            publishBinderService("slice", this.mService);
        }

        @Override // com.android.server.SystemService
        public void onBootPhase(int phase) {
            if (phase != 550) goto L6;
            SliceManagerService.m8156$$Nest$msystemReady(this.mService);
            return;
        }

        @Override // com.android.server.SystemService
        public void onUserUnlocking(SystemService.TargetUser user) {
            SliceManagerService.m8155$$Nest$monUnlockUser(this.mService, user.getUserIdentifier());
        }

        @Override // com.android.server.SystemService
        public void onUserStopping(SystemService.TargetUser user) {
            SliceManagerService.m8154$$Nest$monStopUser(this.mService, user.getUserIdentifier());
        }
    }

    static class PackageMatchingCache {
        private String mCurrentPkg;
        private final Supplier<String> mPkgSource;

        public PackageMatchingCache(Supplier<String> pkgSource) {
            this.mPkgSource = pkgSource;
        }

        public boolean matches(String pkgCandidate) {
            if (pkgCandidate != null) goto L6;
            return false;
        L6:
            if (Objects.equals(pkgCandidate, this.mCurrentPkg) == false) goto L9;
            return true;
        L9:
            this.mCurrentPkg = this.mPkgSource.get();
            return Objects.equals(pkgCandidate, this.mCurrentPkg);
        }
    }

    class RoleObserver implements OnRoleHoldersChangedListener {
        private final Executor mExecutor;
        private RoleManager mRm;
        final /* synthetic */ SliceManagerService this$0;

        RoleObserver(SliceManagerService this$0) {
            this.this$0 = this$0;
            this.mExecutor = SliceManagerService.m8152$$Nest$fgetmContext(this$0).getMainExecutor();
            register();
        }

        public void register() {
            this.mRm = (RoleManager) SliceManagerService.m8152$$Nest$fgetmContext(this.this$0).getSystemService(RoleManager.class);
            if (this.mRm == null) goto L6;
            this.mRm.addOnRoleHoldersChangedListenerAsUser(this.mExecutor, this, UserHandle.ALL);
            this.this$0.invalidateCachedDefaultHome();
            return;
        }

        public void onRoleHoldersChanged(String roleName, UserHandle user) {
            if ("android.app.role.HOME".equals(roleName) == false) goto L6;
            this.this$0.invalidateCachedDefaultHome();
            return;
        }
    }

    private class SliceGrant {
        private final String mPkg;
        private final Uri mUri;
        private final int mUserId;

        public SliceGrant(SliceManagerService r1, Uri uri, String pkg, int userId) {
            this.mUri = uri;
            this.mPkg = pkg;
            this.mUserId = userId;
        }

        public int hashCode() {
            return this.mUri.hashCode() + this.mPkg.hashCode();
        }

        public boolean equals(Object obj) {
            if ((obj instanceof SliceGrant) == true) goto L5;
            return false;
        L5:
            SliceGrant other = (SliceGrant) obj;
            if (Objects.equals(other.mUri, this.mUri) == true) goto L8;
            return false;
        L8:
            if (Objects.equals(other.mPkg, this.mPkg) == true) goto L10;
            return false;
        L10:
            if (other.mUserId != this.mUserId) goto L15;
            return true;
        L15:
            return false;
        }
    }

    public static /* synthetic */ boolean $r8$lambda$2i15Fi6Glc_8fvBKWNZpK9EuRI0(int r0, PinnedSliceState r1) {
        return lambda$onStopUser$0(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$Efr6zVQUVlHz-bVRKbwjlRViJzo, reason: not valid java name */
    public static /* synthetic */ String m8151$r8$lambda$Efr6zVQUVlHzbVRKbwjlRViJzo(SliceManagerService r0, int r1) {
        return r0.lambda$getHomeMatcher$3(r1);
    }

    public static /* synthetic */ void $r8$lambda$Fu7FVdBUIQCcNa5aMNzTemqiicM(SliceManagerService r0, String r1, String r2, int r3) {
        r0.lambda$pinSlice$1(r1, r2, r3);
    }

    public static /* synthetic */ String $r8$lambda$suzCoecn8jG0zjoo1aHAoxwnfmo(SliceManagerService r0, int r1) {
        return r0.lambda$getAssistantMatcher$2(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m8152$$Nest$fgetmContext(SliceManagerService r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPermissions, reason: not valid java name */
    static /* bridge */ /* synthetic */ SlicePermissionManager m8153$$Nest$fgetmPermissions(SliceManagerService r0) {
        return r0.mPermissions;
    }

    /* JADX INFO: renamed from: -$$Nest$monStopUser, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8154$$Nest$monStopUser(SliceManagerService r0, int r1) {
        r0.onStopUser(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monUnlockUser, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8155$$Nest$monUnlockUser(SliceManagerService r0, int r1) {
        r0.onUnlockUser(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$msystemReady, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8156$$Nest$msystemReady(SliceManagerService r0) {
        r0.systemReady();
    }

    public SliceManagerService(Context context) {
        this(context, createHandler().getLooper());
    }

    SliceManagerService(Context context, Looper looper) {
        this.mLock = new Object();
        this.mPinnedSlicesByUri = new ArrayMap();
        this.mAssistantLookup = new SparseArray();
        this.mHomeLookup = new SparseArray();
        this.mCachedDefaultHome = null;
        this.mReceiver = new AnonymousClass1(this);
        this.mContext = context;
        PackageManagerInternal r0 = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
        r0.getClass();
        this.mPackageManagerInternal = r0;
        this.mAppOps = (AppOpsManager) context.getSystemService(AppOpsManager.class);
        this.mAssistUtils = new AssistUtils(context);
        this.mHandler = new Handler(looper);
        this.mAppUsageStats = (UsageStatsManagerInternal) LocalServices.getService(UsageStatsManagerInternal.class);
        this.mPermissions = new SlicePermissionManager(this.mContext, looper);
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.PACKAGE_DATA_CLEARED");
        filter.addAction("android.intent.action.PACKAGE_REMOVED");
        filter.addDataScheme(Settings.ATTR_PACKAGE);
        this.mRoleObserver = new RoleObserver(this);
        this.mContext.registerReceiverAsUser(this.mReceiver, UserHandle.ALL, filter, null, this.mHandler);
    }

    private void systemReady() {
    }

    private void onUnlockUser(int userId) {
    }

    private void onStopUser(final int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mPinnedSlicesByUri.values().removeIf(new SliceManagerService$$ExternalSyntheticLambda3(userId));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ boolean lambda$onStopUser$0(int userId, PinnedSliceState s) {
        if (ContentProvider.getUserIdFromUri(s.getUri()) != userId) goto L5;
        return true;
    L5:
        return false;
    }

    public Uri[] getPinnedSlices(String pkg) {
        verifyCaller(pkg);
        int callingUser = Binder.getCallingUserHandle().getIdentifier();
        ArrayList<Uri> ret = new ArrayList();
        Object r2 = this.mLock;
        monitor-enter(r2);
        Iterator<PinnedSliceState> r3 = this.mPinnedSlicesByUri.values().iterator();     // Catch: Throwable -> L12
    L6:
        if (r3.hasNext() == false) goto L15;
        PinnedSliceState state = r3.next();     // Catch: Throwable -> L12
        if (Objects.equals(pkg, state.getPkg()) == false) goto L6;
        Uri uri = state.getUri();     // Catch: Throwable -> L12
        int userId = ContentProvider.getUserIdFromUri(uri, callingUser);     // Catch: Throwable -> L12
        if (userId != callingUser) goto L6;
        ret.add(ContentProvider.getUriWithoutUserId(uri));     // Catch: Throwable -> L12
        goto L6
    L15:
        monitor-exit(r2);     // Catch: Throwable -> L12
        return (Uri[]) ret.toArray(new Uri[ret.size()]);
    L12:
        th = move-exception;
        throw th;
    }

    public void pinSlice(final String pkg, Uri uri, SliceSpec[] specs, IBinder token) throws RemoteException {
        verifyCaller(pkg);
        enforceAccess(pkg, uri);
        final int user = Binder.getCallingUserHandle().getIdentifier();
        Uri uri2 = ContentProvider.maybeAddUserId(uri, user);
        final String slicePkg = getProviderPkg(uri2, user);
        getOrCreatePinnedSlice(uri2, slicePkg).pin(pkg, specs, token);
        this.mHandler.post(new SliceManagerService$$ExternalSyntheticLambda1(this, slicePkg, pkg, user));
    }

    private /* synthetic */ void lambda$pinSlice$1(String slicePkg, String pkg, int user) {
        if (slicePkg != null) goto L4;
        return;
    L4:
        if (Objects.equals(pkg, slicePkg) == true) goto L15;
        UsageStatsManagerInternal r0 = this.mAppUsageStats;
        if (isAssistant(pkg, user) == false) goto L8;
    L11:
        int r1 = 13;
    L12:
        r0.reportEvent(slicePkg, user, r1);
        return;
    L8:
        if (isDefaultHomeApp(pkg, user) == true) goto L11;
        r1 = 14;
        goto L12
    }

    public void unpinSlice(String pkg, Uri uri, IBinder token) throws RemoteException {
        verifyCaller(pkg);
        enforceAccess(pkg, uri);
        Uri uri2 = ContentProvider.maybeAddUserId(uri, Binder.getCallingUserHandle().getIdentifier());
        PinnedSliceState slice = getPinnedSlice(uri2);     // Catch: IllegalStateException -> L9
        if (slice != null) goto L6;
        return;
    L6:
        if (slice.unpin(pkg, token) == false) goto L17;
        removePinnedSlice(uri2);     // Catch: IllegalStateException -> L9
        return;
    L17:
        return;
    L9:
        exception = move-exception;
        Slog.w(TAG, exception.getMessage());
    }

    public boolean hasSliceAccess(String pkg) throws RemoteException {
        verifyCaller(pkg);
        return hasFullSliceAccess(pkg, Binder.getCallingUserHandle().getIdentifier());
    }

    public SliceSpec[] getPinnedSpecs(Uri uri, String pkg) throws RemoteException {
        verifyCaller(pkg);
        enforceAccess(pkg, uri);
        return getPinnedSlice(ContentProvider.maybeAddUserId(uri, Binder.getCallingUserHandle().getIdentifier())).getSpecs();
    }

    public void grantSlicePermission(String pkg, String toPkg, Uri uri) throws RemoteException {
        verifyCaller(pkg);
        int user = Binder.getCallingUserHandle().getIdentifier();
        enforceOwner(pkg, uri, user);
        this.mPermissions.grantSliceAccess(toPkg, user, pkg, user, uri);
    }

    public void revokeSlicePermission(String pkg, String toPkg, Uri uri) throws RemoteException {
        verifyCaller(pkg);
        int user = Binder.getCallingUserHandle().getIdentifier();
        enforceOwner(pkg, uri, user);
        this.mPermissions.revokeSliceAccess(toPkg, user, pkg, user, uri);
    }

    public int checkSlicePermission(Uri uri, String callingPkg, int pid, int uid, String[] autoGrantPermissions) {
        return checkSlicePermissionInternal(uri, callingPkg, null, pid, uid, autoGrantPermissions);
    }

    private int checkSlicePermissionInternal(Uri uri, String callingPkg, String pkg, int pid, int uid, String[] autoGrantPermissions) {
        SliceManagerService r0 = this;
        String r7 = pkg;
        int r5 = uid;
        int userId = UserHandle.getUserId(r5);
        if (r7 != null) goto L12;
        String[] r11 = r0.mContext.getPackageManager().getPackagesForUid(r5);
        int r12 = r11.length;
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L11;
        String p = r11[r13];
        int r14 = r0.checkSlicePermissionInternal(uri, callingPkg, p, pid, r5, autoGrantPermissions);
        SliceManagerService r6 = r0;
        int r1 = r5;
        if (r14 == 0) goto L8;
        r13 = r13 + 1;
        r5 = r1;
        r0 = r6;
        goto L5
    L8:
        return 0;
    L11:
        return -1;
    L12:
        Uri r2 = uri;
        String[] r3 = autoGrantPermissions;
        int r4 = r5;
        if (r0.hasFullSliceAccess(r7, userId) == false) goto L16;
        return 0;
    L16:
        if (r0.mPermissions.hasPermission(r7, userId, r2) == false) goto L18;
        return 0;
    L18:
        if (r3 == null) goto L29;
        if (callingPkg == null) goto L29;
        r0.enforceOwner(callingPkg, r2, userId);
        r0.verifyCaller(callingPkg);
        int r8 = r3.length;
        int r9 = 0;
    L21:
        if (r9 >= r8) goto L29;
        String perm = r3[r9];
        if (r0.mContext.checkPermission(perm, pid, r4) == 0) goto L24;
        r9 = r9 + 1;
        r2 = uri;
        r7 = pkg;
        r4 = uid;
        r3 = autoGrantPermissions;
        goto L21
    L24:
        int providerUser = ContentProvider.getUserIdFromUri(r2, userId);
        String providerPkg = r0.getProviderPkg(r2, providerUser);
        r0.mPermissions.grantSliceAccess(r7, userId, providerPkg, providerUser, r2);
        return 0;
    L29:
        return -1;
    }

    public void grantPermissionFromUser(Uri uri, String pkg, String callingPkg, boolean allSlices) {
        verifyCaller(callingPkg);
        getContext().enforceCallingOrSelfPermission("android.permission.MANAGE_SLICE_PERMISSIONS", "Slice granting requires MANAGE_SLICE_PERMISSIONS");
        int userId = Binder.getCallingUserHandle().getIdentifier();
        if (allSlices == false) goto L5;
        this.mPermissions.grantFullAccess(pkg, userId);
    L6:
        long ident = Binder.clearCallingIdentity();
        this.mContext.getContentResolver().notifyChange(uri, null);     // Catch: Throwable -> L10
        Binder.restoreCallingIdentity(ident);
        return;
    L10:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    L5:
        Uri grantUri = uri.buildUpon().path("").build();
        int providerUser = ContentProvider.getUserIdFromUri(grantUri, userId);
        String providerPkg = getProviderPkg(grantUri, providerUser);
        this.mPermissions.grantSliceAccess(pkg, userId, providerPkg, providerUser, grantUri);
        goto L6
    }

    public byte[] getBackupPayload(int user) {
        if (Binder.getCallingUid() != 1000) goto L15;
        if (user == 0) goto L8;
        Slog.w(TAG, "getBackupPayload: cannot backup policy for user " + user);
        return null;
    L8:
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        XmlSerializer out = XmlPullParserFactory.newInstance().newSerializer();     // Catch: Throwable -> L11
        out.setOutput(baos, Xml.Encoding.UTF_8.name());     // Catch: Throwable -> L11
        this.mPermissions.writeBackup(out);     // Catch: Throwable -> L11
        out.flush();     // Catch: Throwable -> L11
        return baos.toByteArray();
    L11:
        e = move-exception;
        Slog.w(TAG, "getBackupPayload: error writing payload for user " + user, e);
        return null;
    L15:
        throw new SecurityException("Caller must be system");
    }

    public void applyRestore(byte[] payload, int user) {
        if (Binder.getCallingUid() != 1000) goto L18;
        if (payload != null) goto L8;
        Slog.w(TAG, "applyRestore: no payload to restore for user " + user);
        return;
    L8:
        if (user == 0) goto L11;
        Slog.w(TAG, "applyRestore: cannot restore policy for user " + user);
        return;
    L11:
        ByteArrayInputStream bais = new ByteArrayInputStream(payload);
        XmlPullParser parser = XmlPullParserFactory.newInstance().newPullParser();     // Catch: Throwable -> L14
        parser.setInput(bais, Xml.Encoding.UTF_8.name());     // Catch: Throwable -> L14
        this.mPermissions.readRestore(parser);     // Catch: Throwable -> L14
        return;
    L14:
        e = move-exception;
        Slog.w(TAG, "applyRestore: error reading payload", e);
        return;
    L18:
        throw new SecurityException("Caller must be system");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onShellCommand(FileDescriptor in, FileDescriptor out, FileDescriptor err, String[] args, ShellCallback callback, ResultReceiver resultReceiver) {
        new SliceShellCommand(this).exec(this, in, out, err, args, callback, resultReceiver);
    }

    private void enforceOwner(String pkg, Uri uri, int user) {
        if (Objects.equals(getProviderPkg(uri, user), pkg) == false) goto L7;
        if (pkg == null) goto L7;
        return;
    L7:
        throw new SecurityException("Caller must own " + uri);
    }

    protected void removePinnedSlice(Uri uri) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mPinnedSlicesByUri.remove(uri).destroy();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private PinnedSliceState getPinnedSlice(Uri uri) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        PinnedSliceState manager = this.mPinnedSlicesByUri.get(uri);     // Catch: Throwable -> L8
        if (manager == null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return manager;
    L11:
        throw new IllegalStateException(String.format("Slice %s not pinned", new Object[]{uri.toString()}));     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    private PinnedSliceState getOrCreatePinnedSlice(Uri uri, String pkg) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        PinnedSliceState manager = this.mPinnedSlicesByUri.get(uri);     // Catch: Throwable -> L7
        if (manager != null) goto L9;
        manager = createPinnedSlice(uri, pkg);     // Catch: Throwable -> L7
        this.mPinnedSlicesByUri.put(uri, manager);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return manager;
    L7:
        th = move-exception;
        throw th;
    }

    protected PinnedSliceState createPinnedSlice(Uri uri, String pkg) {
        return new PinnedSliceState(this, uri, pkg);
    }

    public Object getLock() {
        return this.mLock;
    }

    public Context getContext() {
        return this.mContext;
    }

    public Handler getHandler() {
        return this.mHandler;
    }

    protected int checkAccess(String pkg, Uri uri, int uid, int pid) {
        return checkSlicePermissionInternal(uri, null, pkg, pid, uid, null);
    }

    private String getProviderPkg(Uri uri, int user) {
        long ident = Binder.clearCallingIdentity();
        String providerName = ContentProvider.getUriWithoutUserId(uri).getAuthority();     // Catch: Throwable -> L9
        ProviderInfo provider = this.mContext.getPackageManager().resolveContentProviderAsUser(providerName, 0, ContentProvider.getUserIdFromUri(uri, user));     // Catch: Throwable -> L9
        if (provider != null) goto L6;
        String r4 = null;
    L7:
        Binder.restoreCallingIdentity(ident);
        return r4;
    L6:
        r4 = provider.packageName;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }

    private void enforceCrossUser(String pkg, Uri uri) {
        int user = Binder.getCallingUserHandle().getIdentifier();
        if (ContentProvider.getUserIdFromUri(uri, user) == user) goto L6;
        getContext().enforceCallingOrSelfPermission("android.permission.INTERACT_ACROSS_USERS_FULL", "Slice interaction across users requires INTERACT_ACROSS_USERS_FULL");
        return;
    }

    private void enforceAccess(String pkg, Uri uri) throws RemoteException {
        if (checkAccess(pkg, uri, Binder.getCallingUid(), Binder.getCallingPid()) == 0) goto L9;
        int userId = ContentProvider.getUserIdFromUri(uri, Binder.getCallingUserHandle().getIdentifier());
        if (Objects.equals(pkg, getProviderPkg(uri, userId)) == true) goto L9;
        throw new SecurityException("Access to slice " + uri + " is required");
    L9:
        enforceCrossUser(pkg, uri);
    }

    private void verifyCaller(String pkg) {
        this.mAppOps.checkPackage(Binder.getCallingUid(), pkg);
    }

    private boolean hasFullSliceAccess(String pkg, int userId) {
        long ident = Binder.clearCallingIdentity();
    L11:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    L4:
        if (isDefaultHomeApp(pkg, userId) == false) goto L6;
    L13:
        boolean ret = true;
    L14:
        Binder.restoreCallingIdentity(ident);
        return ret;
    L6:
        if (isAssistant(pkg, userId) == true) goto L13;
        if (isGrantedFullAccess(pkg, userId) == true) goto L13;
        ret = false;
        goto L14
    }

    private boolean isAssistant(String pkg, int userId) {
        return getAssistantMatcher(userId).matches(pkg);
    }

    private boolean isDefaultHomeApp(String pkg, int userId) {
        return getHomeMatcher(userId).matches(pkg);
    }

    private PackageMatchingCache getAssistantMatcher(final int userId) {
        PackageMatchingCache matcher = this.mAssistantLookup.get(userId);
        if (matcher != null) goto L6;
        PackageMatchingCache matcher2 = new PackageMatchingCache(new SliceManagerService$$ExternalSyntheticLambda0(this, userId));
        this.mAssistantLookup.put(userId, matcher2);
        return matcher2;
    L6:
        return matcher;
    }

    private /* synthetic */ String lambda$getAssistantMatcher$2(int userId) {
        return getAssistant(userId);
    }

    private PackageMatchingCache getHomeMatcher(final int userId) {
        PackageMatchingCache matcher = this.mHomeLookup.get(userId);
        if (matcher != null) goto L6;
        PackageMatchingCache matcher2 = new PackageMatchingCache(new SliceManagerService$$ExternalSyntheticLambda2(this, userId));
        this.mHomeLookup.put(userId, matcher2);
        return matcher2;
    L6:
        return matcher;
    }

    private /* synthetic */ String lambda$getHomeMatcher$3(int userId) {
        return getDefaultHome(userId);
    }

    private String getAssistant(int userId) {
        ComponentName cn = this.mAssistUtils.getAssistComponentForUser(userId);
        if (cn != null) goto L7;
        return null;
    L7:
        return cn.getPackageName();
    }

    protected String getDefaultHome(int userId) {
        if (this.mCachedDefaultHome != null) goto L5;
        long token = Binder.clearCallingIdentity();
        List<ResolveInfo> allHomeCandidates = new ArrayList();     // Catch: Throwable -> L10
        ComponentName defaultLauncher = this.mPackageManagerInternal.getHomeActivitiesAsUser(allHomeCandidates, userId);     // Catch: Throwable -> L10
        ComponentName detected = defaultLauncher;
        String ret = null;
        if (detected == null) goto L12;
        String r7 = detected.getPackageName();     // Catch: Throwable -> L10
    L13:
        this.mCachedDefaultHome = r7;     // Catch: Throwable -> L10
        if (detected != null) goto L25;
        int size = allHomeCandidates.size();     // Catch: Throwable -> L10
        int lastPriority = Integer.MIN_VALUE;
        int i = 0;
    L16:
        if (i >= size) goto L25;
        ResolveInfo ri = allHomeCandidates.get(i);     // Catch: Throwable -> L10
        if (ri.activityInfo.applicationInfo.isSystemApp() == true) goto L21;
    L24:
        i = i + 1;     // Catch: Throwable -> L10
        goto L16
    L21:
        if (ri.priority < lastPriority) goto L24;
        ComponentName detected2 = ri.activityInfo.getComponentName();     // Catch: Throwable -> L10
        lastPriority = ri.priority;     // Catch: Throwable -> L10
        detected = detected2;
    L25:
        if (detected == null) goto L27;
        ret = detected.getPackageName();     // Catch: Throwable -> L10
    L27:
        Binder.restoreCallingIdentity(token);
        return ret;
    L12:
        r7 = null;
    L10:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    L5:
        return this.mCachedDefaultHome;
    }

    public void invalidateCachedDefaultHome() {
        this.mCachedDefaultHome = null;
    }

    private boolean isGrantedFullAccess(String pkg, int userId) {
        return this.mPermissions.hasFullAccess(pkg, userId);
    }

    private static ServiceThread createHandler() {
        ServiceThread handlerThread = new ServiceThread(TAG, 10, true);
        handlerThread.start();
        return handlerThread;
    }

    public String[] getAllPackagesGranted(String authority) {
        String pkg = getProviderPkg(new Uri.Builder().scheme(ActivityTaskManagerInternal.ASSIST_KEY_CONTENT).authority(authority).build(), 0);
        if (pkg != null) goto L6;
        return new String[0];
    L6:
        return this.mPermissions.getAllPackagesGranted(pkg);
    }
}
