package com.android.server.uri;

import android.app.ActivityManager;
import android.app.ActivityManagerInternal;
import android.app.AppGlobals;
import android.app.GrantedUriPermission;
import android.app.IUriGrantsManager;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManagerInternal;
import android.content.pm.ParceledListSlice;
import android.content.pm.PathPermission;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import android.os.BadParcelableException;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import android.os.UserHandle;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.AtomicFile;
import android.util.Slog;
import android.util.SparseArray;
import android.util.Xml;
import com.android.internal.util.ArrayUtils;
import com.android.internal.util.FrameworkStatsLog;
import com.android.internal.util.Preconditions;
import com.android.internal.util.XmlUtils;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import com.android.server.IoThread;
import com.android.server.LocalServices;
import com.android.server.SystemService;
import com.android.server.SystemServiceManager;
import com.android.server.am.ProcessList;
import com.android.server.job.controllers.JobStatus;
import com.android.server.slice.SliceClientPermissions;
import com.android.server.wm.ActivityTaskManagerInternal;
import com.google.android.collect.Lists;
import com.google.android.collect.Maps;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import libcore.io.IoUtils;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes3.dex */
public class UriGrantsManagerService extends IUriGrantsManager.Stub implements UriMetricsHelper.PersistentUriGrantsProvider {
    private static final String ATTR_CREATED_TIME = "createdTime";
    private static final String ATTR_MODE_FLAGS = "modeFlags";
    private static final String ATTR_PREFIX = "prefix";
    private static final String ATTR_SOURCE_PKG = "sourcePkg";
    private static final String ATTR_SOURCE_USER_ID = "sourceUserId";
    private static final String ATTR_TARGET_PKG = "targetPkg";
    private static final String ATTR_TARGET_USER_ID = "targetUserId";
    private static final String ATTR_URI = "uri";
    private static final String ATTR_USER_HANDLE = "userHandle";
    private static final boolean DEBUG = false;
    private static final boolean ENABLE_DYNAMIC_PERMISSIONS = true;
    private static final int MAX_PERSISTED_URI_GRANTS = 512;
    private static final String TAG = "UriGrantsManagerService";
    private static final String TAG_URI_GRANT = "uri-grant";
    private static final String TAG_URI_GRANTS = "uri-grants";
    ActivityManagerInternal mAmInternal;
    private final AtomicFile mGrantFile;
    private final SparseArray<ArrayMap<GrantUri, UriPermission>> mGrantedUriPermissions;
    private final H mH;
    private final SparseArray<ArraySet<Uri>> mLaunchToContentUrisWithoutCallerReadPermission;
    private final Object mLock;
    UriMetricsHelper mMetricsHelper;
    PackageManagerInternal mPmInternal;

    final class H extends Handler {
        static final int PERSIST_URI_GRANTS_MSG = 1;
        final /* synthetic */ UriGrantsManagerService this$0;

        public H(UriGrantsManagerService this$0, Looper looper) {
            this.this$0 = this$0;
            super(looper, null, true);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            switch(msg.what) {
                case 1: goto L5;
                default: goto L7;
            };
        L5:
            UriGrantsManagerService.m9058$$Nest$mwriteGrantedUriPermissions(this.this$0);
            return;
        }
    }

    public static final class Lifecycle extends SystemService {
        private final Context mContext;
        private final UriGrantsManagerService mService;

        public Lifecycle(Context context) {
            super(context);
            this.mContext = context;
            this.mService = new UriGrantsManagerService(null);
        }

        @Override // com.android.server.SystemService
        public void onStart() {
            publishBinderService("uri_grants", this.mService);
            UriGrantsManagerService r0 = this.mService;
            r0.mMetricsHelper = new UriMetricsHelper(this.mContext, this.mService);
            UriGrantsManagerService.m9057$$Nest$mstart(this.mService);
        }

        @Override // com.android.server.SystemService
        public void onBootPhase(int phase) {
            if (phase != 500) goto L6;
            UriGrantsManagerService r0 = this.mService;
            r0.mAmInternal = (ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class);
            UriGrantsManagerService r1 = this.mService;
            r1.mPmInternal = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
            this.mService.mMetricsHelper.registerPuller();
            return;
        }
    }

    private final class LocalService implements UriGrantsManagerInternal {
        final /* synthetic */ UriGrantsManagerService this$0;

        /* synthetic */ LocalService(UriGrantsManagerService r1, UriGrantsManagerServiceIA r2) {
            this(r1);
        }

        private LocalService(UriGrantsManagerService r1) {
            this.this$0 = r1;
        }

        @Override // com.android.server.uri.UriGrantsManagerInternal
        public void removeUriPermissionIfNeeded(UriPermission perm) {
            Object r0 = UriGrantsManagerService.m9044$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            UriGrantsManagerService.m9054$$Nest$mremoveUriPermissionIfNeededLocked(this.this$0, perm);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.uri.UriGrantsManagerInternal
        public void revokeUriPermission(String targetPackage, int callingUid, GrantUri grantUri, int modeFlags) {
            UriGrantsManagerService.m9056$$Nest$mrevokeUriPermission(this.this$0, targetPackage, callingUid, grantUri, modeFlags);
        }

        @Override // com.android.server.uri.UriGrantsManagerInternal
        public boolean checkUriPermission(GrantUri grantUri, int uid, int modeFlags, boolean isFullAccessForContentUri) {
            if (isFullAccessForContentUri == true) goto L4;
            Object r0 = UriGrantsManagerService.m9044$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            boolean r1 = UriGrantsManagerService.m9049$$Nest$mcheckUriPermissionLocked(this.this$0, grantUri, uid, modeFlags);     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r1;
        L10:
            th = move-exception;
            throw th;
        L4:
            return UriGrantsManagerService.m9046$$Nest$mcheckContentUriPermissionFullUnlocked(this.this$0, grantUri, uid, modeFlags);
        }

        @Override // com.android.server.uri.UriGrantsManagerInternal
        public int checkGrantUriPermission(int callingUid, String targetPkg, Uri uri, int modeFlags, int userId) {
            UriGrantsManagerService.m9050$$Nest$menforceNotIsolatedCaller(this.this$0, "checkGrantUriPermission");
            return UriGrantsManagerService.m9048$$Nest$mcheckGrantUriPermissionUnlocked(this.this$0, callingUid, targetPkg, uri, modeFlags, userId);
        }

        @Override // com.android.server.uri.UriGrantsManagerInternal
        public NeededUriGrants checkGrantUriPermissionFromIntent(Intent intent, int callingUid, String targetPkg, int targetUserId) {
            return internalCheckGrantUriPermissionFromIntent(intent, callingUid, targetPkg, targetUserId, null, null);
        }

        @Override // com.android.server.uri.UriGrantsManagerInternal
        public NeededUriGrants checkGrantUriPermissionFromIntent(Intent intent, int callingUid, String targetPkg, int targetUserId, int requireContentUriPermissionFromCaller, int requestHashCode) {
            return internalCheckGrantUriPermissionFromIntent(intent, callingUid, targetPkg, targetUserId, Integer.valueOf(requireContentUriPermissionFromCaller), Integer.valueOf(requestHashCode));
        }

        @Override // com.android.server.uri.UriGrantsManagerInternal
        public void notifyActivityLaunchRequestCompleted(int requestHashCode, boolean isSuccessfulLaunch, String intentAction, int callingUid, String callingActivityName, int calleeUid, String calleeActivityName, boolean isStartActivityForResult) {
            UriGrantsManagerService.m9052$$Nest$mnotifyActivityLaunchRequestCompletedUnlocked(this.this$0, Integer.valueOf(requestHashCode), isSuccessfulLaunch, intentAction, callingUid, callingActivityName, calleeUid, calleeActivityName, isStartActivityForResult);
        }

        private NeededUriGrants internalCheckGrantUriPermissionFromIntent(Intent intent, int callingUid, String targetPkg, int targetUserId, Integer requireContentUriPermissionFromCaller, Integer requestHashCode) {
            if (intent == null) goto L4;
            int r0 = intent.getFlags();
        L5:
            int mode = r0;
            return UriGrantsManagerService.m9047$$Nest$mcheckGrantUriPermissionFromIntentUnlocked(this.this$0, callingUid, targetPkg, intent, mode, null, targetUserId, requireContentUriPermissionFromCaller, requestHashCode);
        L4:
            r0 = 0;
            goto L5
        }

        @Override // com.android.server.uri.UriGrantsManagerInternal
        public void grantUriPermissionUncheckedFromIntent(NeededUriGrants needed, UriPermissionOwner owner) {
            UriGrantsManagerService.m9051$$Nest$mgrantUriPermissionUncheckedFromIntent(this.this$0, needed, owner);
        }

        @Override // com.android.server.uri.UriGrantsManagerInternal
        public void onSystemReady() {
            Object r0 = UriGrantsManagerService.m9044$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            UriGrantsManagerService.m9053$$Nest$mreadGrantedUriPermissionsLocked(this.this$0);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.uri.UriGrantsManagerInternal
        public IBinder newUriPermissionOwner(String name) {
            UriGrantsManagerService.m9050$$Nest$menforceNotIsolatedCaller(this.this$0, "newUriPermissionOwner");
            UriPermissionOwner owner = new UriPermissionOwner(this, name);
            return owner.getExternalToken();
        }

        @Override // com.android.server.uri.UriGrantsManagerInternal
        public void removeUriPermissionsForPackage(String packageName, int userHandle, boolean persistable, boolean targetOnly) {
            Object r0 = UriGrantsManagerService.m9044$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            UriGrantsManagerService.m9055$$Nest$mremoveUriPermissionsForPackageLocked(this.this$0, packageName, userHandle, persistable, targetOnly);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.uri.UriGrantsManagerInternal
        public void revokeUriPermissionFromOwner(IBinder token, Uri uri, int mode, int userId) {
            revokeUriPermissionFromOwner(token, uri, mode, userId, null, -1);
        }

        @Override // com.android.server.uri.UriGrantsManagerInternal
        public void revokeUriPermissionFromOwner(IBinder token, Uri uri, int mode, int userId, String targetPkg, int targetUserId) {
            UriPermissionOwner owner = UriPermissionOwner.fromExternalToken(token);
            if (owner == null) goto L10;
            if (uri != null) goto L6;
            GrantUri grantUri = null;
        L7:
            owner.removeUriPermission(grantUri, mode, targetPkg, targetUserId);
            return;
        L6:
            grantUri = new GrantUri(userId, uri, mode);
            goto L7
        L10:
            throw new IllegalArgumentException("Unknown owner: " + token);
        }

        @Override // com.android.server.uri.UriGrantsManagerInternal
        public boolean checkAuthorityGrants(int callingUid, ProviderInfo cpi, int userId, boolean checkUser) {
            Object r0 = UriGrantsManagerService.m9044$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            boolean r1 = UriGrantsManagerService.m9045$$Nest$mcheckAuthorityGrantsLocked(this.this$0, callingUid, cpi, userId, checkUser);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.uri.UriGrantsManagerInternal
        public void dump(PrintWriter pw, boolean dumpAll, String dumpPackage) {
            Object r0 = UriGrantsManagerService.m9044$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            boolean needSep = false;
            boolean printedAnything = false;
        L10:
            th = move-exception;
            throw th;
        L6:
            if (UriGrantsManagerService.m9043$$Nest$fgetmGrantedUriPermissions(this.this$0).size() <= 0) goto L33;
            boolean printed = false;
            int dumpUid = -2;
            if (dumpPackage == null) goto L12;
            dumpUid = this.this$0.mPmInternal.getPackageUid(dumpPackage, 4194304, 0);     // Catch: Throwable -> L10
        L12:
            int i = 0;
        L14:
            if (i >= UriGrantsManagerService.m9043$$Nest$fgetmGrantedUriPermissions(this.this$0).size()) goto L33;
            int uid = UriGrantsManagerService.m9043$$Nest$fgetmGrantedUriPermissions(this.this$0).keyAt(i);     // Catch: Throwable -> L10
            if (dumpUid >= (-1)) goto L18;
        L20:
            ArrayMap<GrantUri, UriPermission> perms = (ArrayMap) UriGrantsManagerService.m9043$$Nest$fgetmGrantedUriPermissions(this.this$0).valueAt(i);     // Catch: Throwable -> L10
            if (printed == true) goto L25;
            if (needSep == false) goto L24;
            pw.println();     // Catch: Throwable -> L10
        L24:
            needSep = true;
            pw.println("  Granted Uri Permissions:");     // Catch: Throwable -> L10
            printed = true;
            printedAnything = true;
        L25:
            pw.print("  * UID ");     // Catch: Throwable -> L10
            pw.print(uid);     // Catch: Throwable -> L10
            pw.println(" holds:");     // Catch: Throwable -> L10
            Iterator<UriPermission> r8 = perms.values().iterator();     // Catch: Throwable -> L10
        L27:
            if (r8.hasNext() == false) goto L32;
            UriPermission perm = r8.next();     // Catch: Throwable -> L10
            pw.print("    ");     // Catch: Throwable -> L10
            pw.println(perm);     // Catch: Throwable -> L10
            if (dumpAll == false) goto L27;
            perm.dump(pw, "      ");     // Catch: Throwable -> L10
        L32:
            i = i + 1;     // Catch: Throwable -> L10
            goto L14
        L18:
            if (UserHandle.getAppId(uid) == dumpUid) goto L20;
        L33:
            if (printedAnything == true) goto L35;
            pw.println("  (nothing)");     // Catch: Throwable -> L10
        L35:
            monitor-exit(r0);     // Catch: Throwable -> L10
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmGrantedUriPermissions, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseArray m9043$$Nest$fgetmGrantedUriPermissions(UriGrantsManagerService r0) {
        return r0.mGrantedUriPermissions;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m9044$$Nest$fgetmLock(UriGrantsManagerService r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$mcheckAuthorityGrantsLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m9045$$Nest$mcheckAuthorityGrantsLocked(UriGrantsManagerService r0, int r1, ProviderInfo r2, int r3, boolean r4) {
        return r0.checkAuthorityGrantsLocked(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$mcheckContentUriPermissionFullUnlocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m9046$$Nest$mcheckContentUriPermissionFullUnlocked(UriGrantsManagerService r0, GrantUri r1, int r2, int r3) {
        return r0.checkContentUriPermissionFullUnlocked(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mcheckGrantUriPermissionFromIntentUnlocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ NeededUriGrants m9047$$Nest$mcheckGrantUriPermissionFromIntentUnlocked(UriGrantsManagerService r0, int r1, String r2, Intent r3, int r4, NeededUriGrants r5, int r6, Integer r7, Integer r8) {
        return r0.checkGrantUriPermissionFromIntentUnlocked(r1, r2, r3, r4, r5, r6, r7, r8);
    }

    /* JADX INFO: renamed from: -$$Nest$mcheckGrantUriPermissionUnlocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m9048$$Nest$mcheckGrantUriPermissionUnlocked(UriGrantsManagerService r0, int r1, String r2, Uri r3, int r4, int r5) {
        return r0.checkGrantUriPermissionUnlocked(r1, r2, r3, r4, r5);
    }

    /* JADX INFO: renamed from: -$$Nest$mcheckUriPermissionLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m9049$$Nest$mcheckUriPermissionLocked(UriGrantsManagerService r0, GrantUri r1, int r2, int r3) {
        return r0.checkUriPermissionLocked(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$menforceNotIsolatedCaller, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9050$$Nest$menforceNotIsolatedCaller(UriGrantsManagerService r0, String r1) {
        r0.enforceNotIsolatedCaller(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mgrantUriPermissionUncheckedFromIntent, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9051$$Nest$mgrantUriPermissionUncheckedFromIntent(UriGrantsManagerService r0, NeededUriGrants r1, UriPermissionOwner r2) {
        r0.grantUriPermissionUncheckedFromIntent(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mnotifyActivityLaunchRequestCompletedUnlocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9052$$Nest$mnotifyActivityLaunchRequestCompletedUnlocked(UriGrantsManagerService r0, Integer r1, boolean r2, String r3, int r4, String r5, int r6, String r7, boolean r8) {
        r0.notifyActivityLaunchRequestCompletedUnlocked(r1, r2, r3, r4, r5, r6, r7, r8);
    }

    /* JADX INFO: renamed from: -$$Nest$mreadGrantedUriPermissionsLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9053$$Nest$mreadGrantedUriPermissionsLocked(UriGrantsManagerService r0) {
        r0.readGrantedUriPermissionsLocked();
    }

    /* JADX INFO: renamed from: -$$Nest$mremoveUriPermissionIfNeededLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9054$$Nest$mremoveUriPermissionIfNeededLocked(UriGrantsManagerService r0, UriPermission r1) {
        r0.removeUriPermissionIfNeededLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mremoveUriPermissionsForPackageLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9055$$Nest$mremoveUriPermissionsForPackageLocked(UriGrantsManagerService r0, String r1, int r2, boolean r3, boolean r4) {
        r0.removeUriPermissionsForPackageLocked(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$mrevokeUriPermission, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9056$$Nest$mrevokeUriPermission(UriGrantsManagerService r0, String r1, int r2, GrantUri r3, int r4) {
        r0.revokeUriPermission(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$mstart, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9057$$Nest$mstart(UriGrantsManagerService r0) {
        r0.start();
    }

    /* JADX INFO: renamed from: -$$Nest$mwriteGrantedUriPermissions, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9058$$Nest$mwriteGrantedUriPermissions(UriGrantsManagerService r0) {
        r0.writeGrantedUriPermissions();
    }

    /* synthetic */ UriGrantsManagerService(UriGrantsManagerServiceIA r1) {
        this();
    }

    /* synthetic */ UriGrantsManagerService(File r1, String r2, UriGrantsManagerServiceIA r3) {
        this(r1, r2);
    }

    private UriGrantsManagerService() {
        this(SystemServiceManager.ensureSystemDir(), TAG_URI_GRANTS);
    }

    private UriGrantsManagerService(File systemDir, String commitTag) {
        this.mLock = new Object();
        this.mGrantedUriPermissions = new SparseArray();
        this.mLaunchToContentUrisWithoutCallerReadPermission = new SparseArray();
        this.mH = new H(this, IoThread.get().getLooper());
        File file = new File(systemDir, "urigrants.xml");
        if (commitTag == null) goto L5;
        AtomicFile r1 = new AtomicFile(file, commitTag);
    L6:
        this.mGrantFile = r1;
        return;
    L5:
        r1 = new AtomicFile(file);
        goto L6
    }

    static UriGrantsManagerService createForTest(final File systemDir) {
        final String r1 = null;
        UriGrantsManagerService service = new AnonymousClass1(systemDir, r1);
        service.mAmInternal = (ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class);
        service.mPmInternal = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
        return service;
    }

    UriGrantsManagerInternal getLocalService() {
        return new LocalService(this, null);
    }

    private void start() {
        LocalServices.addService(UriGrantsManagerInternal.class, new LocalService(this, null));
    }

    protected int checkUidPermission(String permission, int uid) {
        return AppGlobals.getPackageManager().checkUidPermission(permission, uid);
    L4:
        e = move-exception;
        throw e.rethrowFromSystemServer();
    }

    protected int checkComponentPermission(String permission, int uid, int owningUid, boolean exported) {
        return ActivityManager.checkComponentPermission(permission, uid, owningUid, exported);
    }

    public void grantUriPermissionFromOwner(IBinder token, int fromUid, String targetPkg, Uri uri, int modeFlags, int sourceUserId, int targetUserId) {
        grantUriPermissionFromOwnerUnlocked(token, fromUid, targetPkg, uri, modeFlags, sourceUserId, targetUserId);
    }

    private void grantUriPermissionFromOwnerUnlocked(IBinder token, int fromUid, String targetPkg, Uri uri, int modeFlags, int sourceUserId, int targetUserId) {
        int targetUserId2 = this.mAmInternal.handleIncomingUser(Binder.getCallingPid(), Binder.getCallingUid(), targetUserId, false, 2, "grantUriPermissionFromOwner", null);
        UriPermissionOwner owner = UriPermissionOwner.fromExternalToken(token);
        if (owner == null) goto L20;
        if (fromUid != Binder.getCallingUid()) goto L7;
    L11:
        if (targetPkg == null) goto L18;
        if (uri == null) goto L16;
        grantUriPermissionUnlocked(fromUid, targetPkg, new GrantUri(sourceUserId, uri, modeFlags), modeFlags, owner, targetUserId2);
        return;
    L16:
        throw new IllegalArgumentException("null uri");
    L18:
        throw new IllegalArgumentException("null target");
    L7:
        if (Binder.getCallingUid() == Process.myUid()) goto L11;
        throw new SecurityException("nice try");
    L20:
        throw new IllegalArgumentException("Unknown owner: " + token);
    }

    public ParceledListSlice<android.content.UriPermission> getUriPermissions(String packageName, boolean incoming, boolean persistedOnly) {
        enforceNotIsolatedCaller("getUriPermissions");
        packageName.getClass();
        int callingUid = Binder.getCallingUid();
        int callingUserId = UserHandle.getUserId(callingUid);
        PackageManagerInternal pm = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
        int packageUid = pm.getPackageUid(packageName, 786432, callingUserId);
        if (packageUid != callingUid) goto L42;
        ArrayList<android.content.UriPermission> result = Lists.newArrayList();
        Object r5 = this.mLock;
        monitor-enter(r5);
        if (incoming == false) goto L23;
        ArrayMap<GrantUri, UriPermission> perms = this.mGrantedUriPermissions.get(callingUid);     // Catch: Throwable -> L10
        if (perms != null) goto L12;
        Slog.w(TAG, "No permission grants found for " + packageName);     // Catch: Throwable -> L10
    L36:
        monitor-exit(r5);     // Catch: Throwable -> L10
        return new ParceledListSlice(result);
    L12:
        int j = 0;
    L14:
        if (j >= perms.size()) goto L36;
        UriPermission perm = perms.valueAt(j);     // Catch: Throwable -> L10
        if (packageName.equals(perm.targetPkg) == false) goto L21;
        if (persistedOnly == true) goto L19;
    L20:
        result.add(perm.buildPersistedPublicApiObject());     // Catch: Throwable -> L10
        goto L21
    L19:
        if (perm.persistedModeFlags != 0) goto L20;
    L21:
        j = j + 1;     // Catch: Throwable -> L10
        goto L14
    L23:
        int size = this.mGrantedUriPermissions.size();     // Catch: Throwable -> L10
        int i = 0;
    L24:
        if (i >= size) goto L36;
        ArrayMap<GrantUri, UriPermission> perms2 = this.mGrantedUriPermissions.valueAt(i);     // Catch: Throwable -> L10
        int j2 = 0;
    L27:
        if (j2 >= perms2.size()) goto L35;
        UriPermission perm2 = perms2.valueAt(j2);     // Catch: Throwable -> L10
        if (packageName.equals(perm2.sourcePkg) == false) goto L34;
        if (persistedOnly == true) goto L32;
    L33:
        result.add(perm2.buildPersistedPublicApiObject());     // Catch: Throwable -> L10
        goto L34
    L32:
        if (perm2.persistedModeFlags != 0) goto L33;
    L34:
        j2 = j2 + 1;     // Catch: Throwable -> L10
        goto L27
    L35:
        i = i + 1;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    L42:
        throw new SecurityException("Package " + packageName + " does not belong to calling UID " + callingUid);
    }

    public ParceledListSlice<GrantedUriPermission> getGrantedUriPermissions(String packageName, int userId) {
        this.mAmInternal.enforceCallingPermission("android.permission.GET_APP_GRANTED_URI_PERMISSIONS", "getGrantedUriPermissions");
        List<GrantedUriPermission> result = new ArrayList();
        Object r1 = this.mLock;
        monitor-enter(r1);
        int size = this.mGrantedUriPermissions.size();     // Catch: Throwable -> L14
        int i = 0;
    L5:
        if (i >= size) goto L24;
        ArrayMap<GrantUri, UriPermission> perms = this.mGrantedUriPermissions.valueAt(i);     // Catch: Throwable -> L14
        int j = 0;
    L8:
        if (j >= perms.size()) goto L22;
        UriPermission perm = perms.valueAt(j);     // Catch: Throwable -> L14
        if (packageName == null) goto L17;
        if (packageName.equals(perm.targetPkg) == true) goto L17;
    L21:
        j = j + 1;     // Catch: Throwable -> L14
    L17:
        if (perm.targetUserId != userId) goto L21;
        if (perm.persistedModeFlags == 0) goto L21;
        result.add(perm.buildGrantedUriPermission());     // Catch: Throwable -> L14
        goto L21
    L22:
        i = i + 1;     // Catch: Throwable -> L14
        goto L5
    L24:
        monitor-exit(r1);     // Catch: Throwable -> L14
        return new ParceledListSlice(result);
    L14:
        th = move-exception;
        throw th;
    }

    public void takePersistableUriPermission(Uri uri, int modeFlags, String toPackage, int userId) {
        if (toPackage == null) goto L4;
        this.mAmInternal.enforceCallingPermission("android.permission.FORCE_PERSISTABLE_URI_PERMISSIONS", "takePersistableUriPermission");
        int uid = this.mPmInternal.getPackageUid(toPackage, 0, userId);
    L5:
        Preconditions.checkFlagsArgument(modeFlags, 3);
        Object r1 = this.mLock;
        monitor-enter(r1);
        boolean persistChanged = false;
        boolean prefixValid = false;
        UriPermission exactPerm = findUriPermissionLocked(uid, new GrantUri(userId, uri, 0));     // Catch: Throwable -> L13
        UriPermission prefixPerm = findUriPermissionLocked(uid, new GrantUri(userId, uri, 128));     // Catch: Throwable -> L13
        if (exactPerm != null) goto L11;
    L15:
        boolean exactValid = false;
    L17:
        if (prefixPerm != null) goto L19;
    L22:
        if (exactValid == true) goto L27;
        if (prefixValid == true) goto L27;
        throw new SecurityException("No persistable permission grants found for UID " + uid + " and Uri " + uri.toSafeString());     // Catch: Throwable -> L13
    L27:
        if (exactValid == false) goto L29;
        persistChanged = false | exactPerm.takePersistableModes(modeFlags);     // Catch: Throwable -> L13
    L29:
        if (prefixValid == false) goto L32;
        persistChanged = persistChanged | prefixPerm.takePersistableModes(modeFlags);     // Catch: Throwable -> L13
    L32:
        if ((persistChanged | maybePrunePersistedUriGrantsLocked(uid)) == false) goto L34;
        schedulePersistUriGrants();     // Catch: Throwable -> L13
    L34:
        monitor-exit(r1);     // Catch: Throwable -> L13
        return;
    L19:
        if ((prefixPerm.persistableModeFlags & modeFlags) != modeFlags) goto L22;
        prefixValid = true;
        goto L22
    L11:
        if ((exactPerm.persistableModeFlags & modeFlags) != modeFlags) goto L15;
        exactValid = true;
    L13:
        th = move-exception;
        throw th;
    L4:
        enforceNotIsolatedCaller("takePersistableUriPermission");
        uid = Binder.getCallingUid();
        goto L5
    }

    public void clearGrantedUriPermissions(String packageName, int userId) {
        this.mAmInternal.enforceCallingPermission("android.permission.CLEAR_APP_GRANTED_URI_PERMISSIONS", "clearGrantedUriPermissions");
        Object r0 = this.mLock;
        monitor-enter(r0);
        removeUriPermissionsForPackageLocked(packageName, userId, true, true);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void releasePersistableUriPermission(Uri uri, int modeFlags, String toPackage, int userId) {
        if (toPackage == null) goto L4;
        this.mAmInternal.enforceCallingPermission("android.permission.FORCE_PERSISTABLE_URI_PERMISSIONS", "releasePersistableUriPermission");
        int uid = this.mPmInternal.getPackageUid(toPackage, 0, userId);
    L5:
        Preconditions.checkFlagsArgument(modeFlags, 3);
        Object r1 = this.mLock;
        monitor-enter(r1);
        boolean persistChanged = false;
        UriPermission exactPerm = findUriPermissionLocked(uid, new GrantUri(userId, uri, 0));     // Catch: Throwable -> L15
        UriPermission prefixPerm = findUriPermissionLocked(uid, new GrantUri(userId, uri, 128));     // Catch: Throwable -> L15
        if (exactPerm != null) goto L17;
        if (prefixPerm != null) goto L17;
        if (toPackage != null) goto L17;
        throw new SecurityException("No permission grants found for UID " + uid + " and Uri " + uri.toSafeString());     // Catch: Throwable -> L15
    L17:
        if (exactPerm == null) goto L19;
        persistChanged = false | exactPerm.releasePersistableModes(modeFlags);     // Catch: Throwable -> L15
        removeUriPermissionIfNeededLocked(exactPerm);     // Catch: Throwable -> L15
    L19:
        if (prefixPerm == null) goto L21;
        persistChanged = persistChanged | prefixPerm.releasePersistableModes(modeFlags);     // Catch: Throwable -> L15
        removeUriPermissionIfNeededLocked(prefixPerm);     // Catch: Throwable -> L15
    L21:
        if (persistChanged == false) goto L23;
        schedulePersistUriGrants();     // Catch: Throwable -> L15
    L23:
        monitor-exit(r1);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    L4:
        enforceNotIsolatedCaller("releasePersistableUriPermission");
        uid = Binder.getCallingUid();
        goto L5
    }

    private void removeUriPermissionsForPackageLocked(String packageName, int userHandle, boolean persistable, boolean targetOnly) {
        if (userHandle != (-1)) goto L8;
        if (packageName != null) goto L8;
        throw new IllegalArgumentException("Must narrow by either package or user");
    L8:
        boolean persistChanged = false;
        int N = this.mGrantedUriPermissions.size();
        int i = 0;
    L9:
        if (i >= N) goto L40;
        int targetUid = this.mGrantedUriPermissions.keyAt(i);
        ArrayMap<GrantUri, UriPermission> perms = this.mGrantedUriPermissions.valueAt(i);
        if (userHandle != (-1)) goto L13;
    L14:
        Iterator<UriPermission> it = perms.values().iterator();
    L16:
        if (it.hasNext() == false) goto L36;
        UriPermission perm = it.next();
        if (packageName == null) goto L25;
        if (targetOnly == true) goto L23;
        if (perm.sourcePkg.equals(packageName) == true) goto L25;
    L23:
        if (perm.targetPkg.equals(packageName) == false) goto L16;
    L25:
        if ("downloads".equals(perm.uri.uri.getAuthority()) == false) goto L28;
        if (persistable == false) goto L16;
    L28:
        if (persistable == false) goto L30;
        int r9 = -1;
    L31:
        persistChanged = persistChanged | perm.revokeModes(r9, true);
        if (perm.modeFlags != 0) goto L16;
        it.remove();
        goto L16
    L30:
        r9 = -65;
        goto L31
    L36:
        if (perms.isEmpty() == false) goto L38;
        this.mGrantedUriPermissions.remove(targetUid);
        N = N - 1;
        i = i - 1;
    L38:
        i = i + 1;
        goto L9
    L13:
        if (userHandle != UserHandle.getUserId(targetUid)) goto L38;
    L40:
        if (persistChanged == false) goto L59;
        schedulePersistUriGrants();
        return;
    }

    private boolean checkAuthorityGrantsLocked(int callingUid, ProviderInfo cpi, int userId, boolean checkUser) {
        ArrayMap<GrantUri, UriPermission> perms = this.mGrantedUriPermissions.get(callingUid);
        if (perms == null) goto L13;
        int i = perms.size() - 1;
    L5:
        if (i < 0) goto L19;
        GrantUri grantUri = perms.keyAt(i);
        if (grantUri.sourceUserId == userId) goto L10;
        if (checkUser == false) goto L10;
    L12:
        i = i - 1;
    L10:
        if (matchesProvider(grantUri.uri, cpi) == false) goto L12;
        return true;
    L19:
        return false;
    L13:
        return false;
    }

    private boolean matchesProvider(Uri uri, ProviderInfo cpi) {
        String uriAuth = uri.getAuthority();
        String cpiAuth = cpi.authority;
        if (cpiAuth.indexOf(59) == (-1)) goto L5;
        String[] cpiAuths = cpiAuth.split(";");
        int length = cpiAuths.length;
        int i = 0;
    L7:
        if (i >= length) goto L13;
        if (cpiAuths[i].equals(uriAuth) == true) goto L10;
        i = i + 1;
        goto L7
    L10:
        return true;
    L13:
        return false;
    L5:
        return cpiAuth.equals(uriAuth);
    }

    private boolean maybePrunePersistedUriGrantsLocked(int uid) {
        ArrayMap<GrantUri, UriPermission> perms = this.mGrantedUriPermissions.get(uid);
        if (perms != null) goto L6;
        return false;
    L6:
        if (perms.size() >= 512) goto L8;
        return false;
    L8:
        ArrayList<UriPermission> persisted = Lists.newArrayList();
        Iterator<UriPermission> r4 = perms.values().iterator();
    L10:
        if (r4.hasNext() == false) goto L15;
        UriPermission perm = r4.next();
        if (perm.persistedModeFlags == 0) goto L10;
        persisted.add(perm);
        goto L10
    L15:
        int trimCount = persisted.size() - 512;
        if (trimCount > 0) goto L18;
        return false;
    L18:
        Collections.sort(persisted, new UriPermission.PersistedTimeComparator());
        int i = 0;
    L19:
        if (i >= trimCount) goto L21;
        UriPermission perm2 = persisted.get(i);
        perm2.releasePersistableModes(-1);
        removeUriPermissionIfNeededLocked(perm2);
        i = i + 1;
        goto L19
    L21:
        return true;
    }

    private NeededUriGrants checkGrantUriPermissionFromIntentUnlocked(int callingUid, String targetPkg, Intent intent, int mode, NeededUriGrants needed, int targetUserId, Integer requireContentUriPermissionFromCaller, Integer requestHashCode) {
        NeededUriGrants needed2 = needed;
        if (targetPkg == null) goto L52;
        if (intent != null) goto L7;
        return null;
    L7:
        int contentUserHint = intent.getContentUserHint();
        if (contentUserHint != (-2)) goto L10;
        int contentUserHint2 = UserHandle.getUserId(callingUid);
    L11:
        UriGrantsManagerService r0 = this;
        r0.enforceRequireContentUriPermissionFromCallerOnIntentExtraStreamUnlocked(intent, contentUserHint2, mode, callingUid, requireContentUriPermissionFromCaller, requestHashCode);
        int contentUserHint3 = contentUserHint2;
        int r1 = callingUid;
        Integer r10 = requestHashCode;
        int r4 = mode;
        Integer r6 = requireContentUriPermissionFromCaller;
        Uri data = intent.getData();
        ClipData clip = intent.getClipData();
        if (data != null) goto L15;
        if (clip != null) goto L15;
        return null;
    L15:
        if (needed2 == null) goto L17;
        int targetUid = needed2.targetUid;
    L21:
        if (data == null) goto L28;
        GrantUri grantUri = GrantUri.resolve(contentUserHint3, data, r4);
        r0.enforceRequireContentUriPermissionFromCallerUnlocked(r6, grantUri, r1, r10);
        String r2 = targetPkg;
        targetUid = r0.checkGrantUriPermissionUnlocked(r1, r2, grantUri, r4, targetUid);
        if (targetUid <= 0) goto L29;
        if (needed2 != null) goto L26;
        NeededUriGrants needed3 = new NeededUriGrants(r2, targetUid, r4);
    L27:
        needed3.uris.add(grantUri);
        needed2 = needed3;
        goto L29
    L26:
        needed3 = needed2;
    L29:
        if (clip == null) goto L50;
        int i = 0;
    L32:
        if (i >= clip.getItemCount()) goto L50;
        Uri uri = clip.getItemAt(i).getUri();
        if (uri == null) goto L41;
        GrantUri grantUri2 = GrantUri.resolve(contentUserHint3, uri, r4);
        r0.enforceRequireContentUriPermissionFromCallerUnlocked(r6, grantUri2, r1, r10);
        targetUid = r0.checkGrantUriPermissionUnlocked(r1, r2, grantUri2, r4, targetUid);
        if (targetUid <= 0) goto L48;
        if (needed2 != null) goto L39;
        needed2 = new NeededUriGrants(r2, targetUid, r4);
    L39:
        needed2.uris.add(grantUri2);
    L48:
        i = i + 1;
        r0 = this;
        r1 = callingUid;
        r2 = targetPkg;
        r4 = mode;
        r6 = requireContentUriPermissionFromCaller;
        r10 = requestHashCode;
        goto L32
    L41:
        int targetUid2 = targetUid;
        Intent clipIntent = clip.getItemAt(i).getIntent();
        if (clipIntent == null) goto L46;
        NeededUriGrants needed4 = needed2;
        NeededUriGrants newNeeded = checkGrantUriPermissionFromIntentUnlocked(callingUid, r2, clipIntent, r4, needed4, targetUserId, r6, r10);
        if (newNeeded == null) goto L47;
        needed2 = newNeeded;
        targetUid = targetUid2;
    L47:
        needed2 = needed4;
        targetUid = targetUid2;
        goto L48
    L46:
        needed4 = needed2;
    L50:
        return needed2;
    L28:
        r2 = targetPkg;
        goto L29
    L17:
        int targetUid3 = r0.mPmInternal.getPackageUid(targetPkg, 268435456, targetUserId);
        if (targetUid3 >= 0) goto L20;
        return null;
    L20:
        targetUid = targetUid3;
        goto L21
    L10:
        contentUserHint2 = contentUserHint;
        goto L11
    L52:
        throw new NullPointerException(ATTR_TARGET_PKG);
    }

    private void enforceRequireContentUriPermissionFromCallerUnlocked(Integer requireContentUriPermissionFromCaller, GrantUri grantUri, int callingUid, Integer requestHashCode) {
        if (requireContentUriPermissionFromCaller != null) goto L4;
    L13:
        tryAddingContentUriWithoutCallerReadPermissionWhenAttributeIsNoneUnlocked(requireContentUriPermissionFromCaller, grantUri, callingUid, requestHashCode);
        return;
    L4:
        if (requireContentUriPermissionFromCaller.intValue() == 0) goto L13;
        if (ActivityTaskManagerInternal.ASSIST_KEY_CONTENT.equals(grantUri.uri.getScheme()) == false) goto L13;
        boolean hasPermission = hasRequireContentUriPermissionFromCallerUnlocked(requireContentUriPermissionFromCaller, grantUri, callingUid);
        if (hasPermission == false) goto L12;
        return;
    L12:
        throw new SecurityException("You can't launch this activity because you don't have the required " + ActivityInfo.requiredContentUriPermissionToShortString(requireContentUriPermissionFromCaller.intValue()) + " access to " + grantUri.uri);
    }

    private boolean hasRequireContentUriPermissionFromCallerUnlocked(Integer requireContentUriPermissionFromCaller, GrantUri grantUri, int uid) {
        if (ActivityInfo.isRequiredContentUriPermissionRead(requireContentUriPermissionFromCaller.intValue()) == true) goto L5;
    L8:
        boolean readMet = true;
    L10:
        if (ActivityInfo.isRequiredContentUriPermissionWrite(requireContentUriPermissionFromCaller.intValue()) == true) goto L12;
    L15:
        boolean writeMet = true;
    L17:
        if (requireContentUriPermissionFromCaller.intValue() != 3) goto L21;
        if (readMet == true) goto L25;
        if (writeMet == true) goto L25;
        return false;
    L25:
        return true;
    L21:
        if (readMet == false) goto L26;
        if (writeMet == true) goto L25;
        return false;
    L26:
        return false;
    L12:
        if (checkContentUriPermissionFullUnlocked(grantUri, uid, 2) == true) goto L15;
        writeMet = false;
        goto L17
    L5:
        if (checkContentUriPermissionFullUnlocked(grantUri, uid, 1) == true) goto L8;
        readMet = false;
        goto L10
    }

    private void tryAddingContentUriWithoutCallerReadPermissionWhenAttributeIsNoneUnlocked(Integer requireContentUriPermissionFromCaller, GrantUri grantUri, int callingUid, Integer requestHashCode) {
        if (requireContentUriPermissionFromCaller != null) goto L4;
        return;
    L4:
        if (requireContentUriPermissionFromCaller.intValue() == 0) goto L6;
        return;
    L6:
        if (ActivityTaskManagerInternal.ASSIST_KEY_CONTENT.equals(grantUri.uri.getScheme()) == false) goto L29;
        if (requestHashCode != null) goto L10;
        return;
    L10:
        if (hasRequireContentUriPermissionFromCallerUnlocked(1, grantUri, callingUid) == true) goto L23;
        SparseArray<ArraySet<Uri>> r0 = this.mLaunchToContentUrisWithoutCallerReadPermission;
        monitor-enter(r0);
    L16:
        th = move-exception;
        throw th;
    L14:
        if (this.mLaunchToContentUrisWithoutCallerReadPermission.get(requestHashCode.intValue()) != null) goto L18;
        this.mLaunchToContentUrisWithoutCallerReadPermission.put(requestHashCode.intValue(), new ArraySet());     // Catch: Throwable -> L16
    L18:
        this.mLaunchToContentUrisWithoutCallerReadPermission.get(requestHashCode.intValue()).add(grantUri.uri);     // Catch: Throwable -> L16
        monitor-exit(r0);     // Catch: Throwable -> L16
        return;
    L23:
        return;
    }

    private void enforceRequireContentUriPermissionFromCallerOnIntentExtraStreamUnlocked(Intent intent, int contentUserHint, int mode, int callingUid, Integer requireContentUriPermissionFromCaller, Integer requestHashCode) {
        Uri uri = (Uri) intent.getParcelableExtra("android.intent.extra.STREAM", Uri.class);     // Catch: BadParcelableException -> L7
        if (uri == null) goto L24;
        GrantUri grantUri = GrantUri.resolve(contentUserHint, uri, mode);     // Catch: BadParcelableException -> L7
        enforceRequireContentUriPermissionFromCallerUnlocked(requireContentUriPermissionFromCaller, grantUri, callingUid, requestHashCode);     // Catch: BadParcelableException -> L7
    L24:
        ArrayList<Uri> uris = intent.getParcelableArrayListExtra("android.intent.extra.STREAM", Uri.class);     // Catch: BadParcelableException -> L17
        if (uris == null) goto L27;
        int i = uris.size() - 1;     // Catch: BadParcelableException -> L17
    L14:
        if (i < 0) goto L28;
        GrantUri grantUri2 = GrantUri.resolve(contentUserHint, uris.get(i), mode);     // Catch: BadParcelableException -> L17
        enforceRequireContentUriPermissionFromCallerUnlocked(requireContentUriPermissionFromCaller, grantUri2, callingUid, requestHashCode);     // Catch: BadParcelableException -> L17
        i = i - 1;
        goto L14
    L28:
        return;
    L27:
        return;
    L17:
        e = move-exception;
        Slog.w(TAG, "Failed to unparcel an ArrayList of URIs in EXTRA_STREAM, skipping requireContentUriPermissionFromCaller: " + e);
        return;
    L7:
        e = move-exception;
        Slog.w(TAG, "Failed to unparcel an URI in EXTRA_STREAM, skipping requireContentUriPermissionFromCaller: " + e);
        goto L24
    }

    private void notifyActivityLaunchRequestCompletedUnlocked(Integer requestHashCode, boolean isSuccessfulLaunch, String intentAction, int callingUid, String callingActivityName, int calleeUid, String calleeActivityName, boolean isStartActivityForResult) {
        SparseArray<ArraySet<Uri>> r2 = this.mLaunchToContentUrisWithoutCallerReadPermission;
        monitor-enter(r2);
        ArraySet<Uri> contentUris = this.mLaunchToContentUrisWithoutCallerReadPermission.get(requestHashCode.intValue());     // Catch: Throwable -> L15
        this.mLaunchToContentUrisWithoutCallerReadPermission.remove(requestHashCode.intValue());     // Catch: Throwable -> L15
        monitor-exit(r2);     // Catch: Throwable -> L15
        if (isSuccessfulLaunch == false) goto L14;
        if (contentUris == null) goto L21;
        String[] authorities = new String[contentUris.size()];
        String[] schemes = new String[contentUris.size()];
        int i = contentUris.size() - 1;
    L10:
        if (i < 0) goto L12;
        Uri uri = contentUris.valueAt(i);
        authorities[i] = uri.getAuthority();
        schemes[i] = uri.getScheme();
        i = i - 1;
        goto L10
    L12:
        FrameworkStatsLog.write(FrameworkStatsLog.CONTENT_OR_FILE_URI_EVENT_REPORTED, 1, intentAction, callingUid, callingActivityName, calleeUid, calleeActivityName, isStartActivityForResult, String.join(",", authorities), String.join(",", schemes), null);
        return;
    L21:
        return;
    L14:
        return;
    L15:
        th = move-exception;
        throw th;
    }

    private void readGrantedUriPermissionsLocked() {
        UriGrantsManagerService r1 = this;
        String r2 = "Failed reading Uri grants";
        String r3 = TAG;
        long now = System.currentTimeMillis();
        FileInputStream fis = null;
        fis = r1.mGrantFile.openRead();     // Catch: Throwable -> L85 XmlPullParserException -> L87 IOException -> L89 FileNotFoundException -> L91
        TypedXmlPullParser in = Xml.resolvePullParser(fis);     // Catch: Throwable -> L73 XmlPullParserException -> L75 IOException -> L77 FileNotFoundException -> L79
    L6:
        int type = in.next();     // Catch: Throwable -> L73 XmlPullParserException -> L75 IOException -> L77 FileNotFoundException -> L79
        if (type == 1) goto L84;
        String tag = in.getName();     // Catch: Throwable -> L73 XmlPullParserException -> L75 IOException -> L77 FileNotFoundException -> L79
        if (type == 2) goto L11;
        TypedXmlPullParser in2 = in;
        long now2 = now;
        FileInputStream fis2 = fis;
        String r5 = r2;
        String r4 = r3;
    L83:
        r1 = this;
        r3 = r4;
        r2 = r5;
        fis = fis2;
        in = in2;
        now = now2;
        goto L6
    L11:
        if (TAG_URI_GRANT.equals(tag) == false) goto L81;
        int userHandle = in.getAttributeInt(null, ATTR_USER_HANDLE, ProcessList.INVALID_ADJ);     // Catch: Throwable -> L73 XmlPullParserException -> L75 IOException -> L77 FileNotFoundException -> L79
        if (userHandle == (-10000)) goto L15;
        int sourceUserId = userHandle;
        int targetUserId = userHandle;
    L16:
        String sourcePkg = in.getAttributeValue(null, ATTR_SOURCE_PKG);     // Catch: Throwable -> L73 XmlPullParserException -> L75 IOException -> L77 FileNotFoundException -> L79
        String targetPkg = in.getAttributeValue(null, ATTR_TARGET_PKG);     // Catch: Throwable -> L73 XmlPullParserException -> L75 IOException -> L77 FileNotFoundException -> L79
        Uri uri = Uri.parse(in.getAttributeValue(null, ATTR_URI));     // Catch: Throwable -> L73 XmlPullParserException -> L75 IOException -> L77 FileNotFoundException -> L79
        fis2 = fis;
        boolean prefix = in.getAttributeBoolean(null, ATTR_PREFIX, false);     // Catch: Throwable -> L65 XmlPullParserException -> L67 IOException -> L69 FileNotFoundException -> L71
        int modeFlags = in.getAttributeInt(null, ATTR_MODE_FLAGS);     // Catch: Throwable -> L65 XmlPullParserException -> L67 IOException -> L69 FileNotFoundException -> L71
        long createdTime = in.getAttributeLong(null, ATTR_CREATED_TIME, now);     // Catch: Throwable -> L65 XmlPullParserException -> L67 IOException -> L69 FileNotFoundException -> L71
        in2 = in;
        now2 = now;
        ProviderInfo pi = r1.getProviderInfo(uri.getAuthority(), sourceUserId, 786432, 1000);     // Catch: Throwable -> L34 FileNotFoundException -> L40 XmlPullParserException -> L61 IOException -> L63
        if (pi != null) goto L114;
    L48:
        r5 = r2;
        String r25 = r3;
        r4 = r25;
        Slog.w(r4, "Persisted grant for " + uri + " had source " + sourcePkg + " but instead found " + pi);     // Catch: Throwable -> L34 FileNotFoundException -> L40 XmlPullParserException -> L53 IOException -> L55
    L55:
        e = e;
    L56:
        fis = fis2;
    L99:
        Slog.wtf(r4, r5, e);     // Catch: Throwable -> L96
        IoUtils.closeQuietly(fis);
    L105:
        return;
    L53:
        e = e;
    L54:
        fis = fis2;
    L94:
        Slog.wtf(r4, r5, e);     // Catch: Throwable -> L96
        IoUtils.closeQuietly(fis);
        goto L105
    L59:
        e = e;
        r4 = r25;
    L57:
        e = e;
        r4 = r25;
        goto L54
    L114:
    L46:
        e = e;
        r5 = r2;
        String r26 = r3;
    L39:
        fis = fis2;
        r4 = r26;
    L44:
        e = e;
        r5 = r2;
        r26 = r3;
    L37:
        fis = fis2;
        r4 = r26;
        goto L94
    L23:
        if (sourcePkg.equals(pi.packageName) == false) goto L48;
        r5 = r2;
        r26 = r3;
        int targetUid = r1.mPmInternal.getPackageUid(targetPkg, 8192, targetUserId);     // Catch: Throwable -> L34 XmlPullParserException -> L36 IOException -> L38 FileNotFoundException -> L40
        if (targetUid == (-1)) goto L43;
        if (prefix == false) goto L31;
        int r6 = 128;
    L32:
        GrantUri grantUri = new GrantUri(sourceUserId, uri, r6);     // Catch: Throwable -> L34 XmlPullParserException -> L36 IOException -> L38 FileNotFoundException -> L40
        UriPermission perm = r1.findOrCreateUriPermissionLocked(sourcePkg, targetPkg, targetUid, grantUri);     // Catch: Throwable -> L34 XmlPullParserException -> L36 IOException -> L38 FileNotFoundException -> L40
        perm.initPersistedModes(modeFlags, createdTime);     // Catch: Throwable -> L34 XmlPullParserException -> L36 IOException -> L38 FileNotFoundException -> L40
        r1.mPmInternal.grantImplicitAccess(targetUserId, null, UserHandle.getAppId(targetUid), pi.applicationInfo.uid, false, true);     // Catch: Throwable -> L34 XmlPullParserException -> L36 IOException -> L38 FileNotFoundException -> L40
    L31:
        r6 = 0;
    L43:
        r4 = r26;
    L38:
        e = e;
    L36:
        e = e;
        goto L37
    L34:
        th = th;
        fis = fis2;
    L101:
        IoUtils.closeQuietly(fis);
        throw th;
    L63:
        e = e;
        r5 = r2;
        r4 = r3;
    L61:
        e = e;
        r5 = r2;
        r4 = r3;
    L41:
        fis = fis2;
        goto L103
    L69:
        e = e;
        r5 = r2;
        r4 = r3;
        fis = fis2;
    L67:
        e = e;
        r5 = r2;
        r4 = r3;
        fis = fis2;
    L65:
        th = th;
        fis = fis2;
    L72:
        fis = fis2;
        goto L103
    L15:
        sourceUserId = in.getAttributeInt(null, ATTR_SOURCE_USER_ID);     // Catch: Throwable -> L73 XmlPullParserException -> L75 IOException -> L77 FileNotFoundException -> L79
        targetUserId = in.getAttributeInt(null, ATTR_TARGET_USER_ID);     // Catch: Throwable -> L73 XmlPullParserException -> L75 IOException -> L77 FileNotFoundException -> L79
        goto L16
    L81:
        in2 = in;
        now2 = now;
        fis2 = fis;
        r5 = r2;
        r4 = r3;
        goto L83
    L84:
        IoUtils.closeQuietly(fis);
        return;
    L77:
        e = e;
        r5 = r2;
        r4 = r3;
    L75:
        e = e;
        r5 = r2;
        r4 = r3;
    L73:
        th = th;
        goto L101
    L96:
        th = th;
    L89:
        e = e;
        r5 = "Failed reading Uri grants";
        r4 = TAG;
    L87:
        e = e;
        r5 = "Failed reading Uri grants";
        r4 = TAG;
    L85:
        th = th;
    L103:
        IoUtils.closeQuietly(fis);
    }

    private UriPermission findOrCreateUriPermissionLocked(String sourcePkg, String targetPkg, int targetUid, GrantUri grantUri) {
        ArrayMap<GrantUri, UriPermission> targetUris = this.mGrantedUriPermissions.get(targetUid);
        if (targetUris != null) goto L5;
        targetUris = Maps.newArrayMap();
        this.mGrantedUriPermissions.put(targetUid, targetUris);
    L5:
        UriPermission perm = targetUris.get(grantUri);
        if (perm != null) goto L9;
        UriPermission perm2 = new UriPermission(sourcePkg, targetPkg, targetUid, grantUri);
        targetUris.put(grantUri, perm2);
        return perm2;
    L9:
        return perm;
    }

    private void grantUriPermissionUnchecked(int targetUid, String targetPkg, GrantUri grantUri, int modeFlags, UriPermissionOwner owner) {
        if (Intent.isAccessUriMode(modeFlags) == true) goto L5;
        return;
    L5:
        String authority = grantUri.uri.getAuthority();
        ProviderInfo pi = getProviderInfo(authority, grantUri.sourceUserId, 268435456, 1000);
        if (pi != null) goto L9;
        Slog.w(TAG, "No content provider found for grant: " + grantUri.toSafeString());
        return;
    L9:
        Object r6 = this.mLock;
        monitor-enter(r6);
        UriPermission perm = findOrCreateUriPermissionLocked(pi.packageName, targetPkg, targetUid, grantUri);     // Catch: Throwable -> L22
        monitor-exit(r6);     // Catch: Throwable -> L22
        perm.grantModes(modeFlags, owner);
        PackageManagerInternal r10 = this.mPmInternal;
        int r11 = UserHandle.getUserId(targetUid);
        int r13 = UserHandle.getAppId(targetUid);
        int r14 = pi.applicationInfo.uid;
        if ((modeFlags & 64) == 0) goto L19;
        boolean r7 = true;
    L20:
        r10.grantImplicitAccess(r11, null, r13, r14, false, r7);
        return;
    L19:
        r7 = false;
    L22:
        th = th;
    L30:
        monitor-exit(r6);     // Catch: Throwable -> L28
        throw th;
    L28:
        th = th;
    L24:
        th = th;
        goto L30
    }

    private void grantUriPermissionUncheckedFromIntent(NeededUriGrants needed, UriPermissionOwner owner) {
        if (needed != null) goto L4;
        return;
    L4:
        int N = needed.uris.size();
        int i = 0;
    L5:
        if (i >= N) goto L8;
        grantUriPermissionUnchecked(needed.targetUid, needed.targetPkg, needed.uris.valueAt(i), needed.flags, owner);
        i = i + 1;
        goto L5
    }

    private void grantUriPermissionUnlocked(int callingUid, String targetPkg, GrantUri grantUri, int modeFlags, UriPermissionOwner owner, int targetUserId) {
        if (targetPkg == null) goto L9;
        int targetUid = checkGrantUriPermissionUnlocked(callingUid, targetPkg, grantUri, modeFlags, this.mPmInternal.getPackageUid(targetPkg, 268435456, targetUserId));
        if (targetUid >= 0) goto L6;
        return;
    L6:
        grantUriPermissionUnchecked(targetUid, targetPkg, grantUri, modeFlags, owner);
        return;
    L9:
        throw new NullPointerException(ATTR_TARGET_PKG);
    }

    private void revokeUriPermission(String targetPackage, int callingUid, GrantUri grantUri, int modeFlags) {
        String authority = grantUri.uri.getAuthority();
        ProviderInfo pi = getProviderInfo(authority, grantUri.sourceUserId, 786432, callingUid);
        if (pi != null) goto L6;
        Slog.w(TAG, "No content provider found for permission revoke: " + grantUri.toSafeString());
        return;
    L6:
        boolean callerHoldsPermissions = checkHoldingPermissionsUnlocked(pi, grantUri, callingUid, modeFlags);
        Object r3 = this.mLock;
        monitor-enter(r3);
        revokeUriPermissionLocked(targetPackage, callingUid, grantUri, modeFlags, callerHoldsPermissions);     // Catch: Throwable -> L12
        monitor-exit(r3);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    private void revokeUriPermissionLocked(String targetPackage, int callingUid, GrantUri grantUri, int modeFlags, boolean callerHoldsPermissions) {
        if (callerHoldsPermissions == true) goto L27;
        ArrayMap<GrantUri, UriPermission> perms = this.mGrantedUriPermissions.get(callingUid);
        if (perms == null) goto L71;
        boolean persistChanged = false;
        int i = perms.size() - 1;
    L7:
        if (i < 0) goto L22;
        UriPermission perm = perms.valueAt(i);
        if (targetPackage == null) goto L14;
        if (targetPackage.equals(perm.targetPkg) == true) goto L14;
    L20:
        i = i - 1;
    L14:
        if (perm.uri.sourceUserId != grantUri.sourceUserId) goto L20;
        if (perm.uri.uri.isPathPrefixMatch(grantUri.uri) == false) goto L20;
        persistChanged = persistChanged | perm.revokeModes(modeFlags | 64, false);
        if (perm.modeFlags != 0) goto L20;
        perms.removeAt(i);
        goto L20
    L22:
        if (perms.isEmpty() == false) goto L24;
        this.mGrantedUriPermissions.remove(callingUid);
    L24:
        if (persistChanged == false) goto L72;
        schedulePersistUriGrants();
        return;
    L72:
        return;
    L71:
        return;
    L27:
        boolean persistChanged2 = false;
        int i2 = this.mGrantedUriPermissions.size() - 1;
    L28:
        if (i2 < 0) goto L53;
        this.mGrantedUriPermissions.keyAt(i2);
        ArrayMap<GrantUri, UriPermission> perms2 = this.mGrantedUriPermissions.valueAt(i2);
        int j = perms2.size() - 1;
    L30:
        if (j < 0) goto L49;
        UriPermission perm2 = perms2.valueAt(j);
        if (targetPackage == null) goto L37;
        if (targetPackage.equals(perm2.targetPkg) == true) goto L37;
    L47:
        j = j - 1;
    L37:
        if (perm2.uri.sourceUserId != grantUri.sourceUserId) goto L47;
        if (perm2.uri.uri.isPathPrefixMatch(grantUri.uri) == false) goto L47;
        int r8 = modeFlags | 64;
        if (targetPackage != null) goto L43;
        boolean r9 = true;
    L44:
        persistChanged2 = persistChanged2 | perm2.revokeModes(r8, r9);
        if (perm2.modeFlags != 0) goto L47;
        perms2.removeAt(j);
        goto L47
    L43:
        r9 = false;
        goto L44
    L49:
        if (perms2.isEmpty() == false) goto L51;
        this.mGrantedUriPermissions.removeAt(i2);
    L51:
        i2 = i2 - 1;
        goto L28
    L53:
        if (persistChanged2 == false) goto L73;
        schedulePersistUriGrants();
        return;
    }

    private boolean checkHoldingPermissionsUnlocked(ProviderInfo pi, GrantUri grantUri, int uid, int modeFlags) {
        if (UserHandle.getUserId(uid) == grantUri.sourceUserId) goto L9;
        if (checkComponentPermission("android.permission.INTERACT_ACROSS_USERS", uid, -1, true) == 0) goto L9;
        return false;
    L9:
        return checkHoldingPermissionsInternalUnlocked(pi, grantUri, uid, modeFlags, true);
    }

    private boolean checkHoldingPermissionsInternalUnlocked(ProviderInfo pi, GrantUri grantUri, int uid, int modeFlags, boolean considerUidPermissions) {
        if (Thread.holdsLock(this.mLock) == true) goto L88;
        if (pi.applicationInfo.uid != uid) goto L8;
        return true;
    L8:
        if (pi.exported == true) goto L11;
        return false;
    L11:
        if ((modeFlags & 1) != 0) goto L13;
        boolean readMet = true;
    L15:
        if ((modeFlags & 2) != 0) goto L17;
        boolean writeMet = true;
    L18:
        if (readMet == false) goto L20;
    L25:
        if (writeMet == true) goto L33;
        if (pi.writePermission == null) goto L33;
        if (considerUidPermissions == false) goto L33;
        if (checkUidPermission(pi.writePermission, uid) != 0) goto L33;
        writeMet = true;
    L33:
        if (pi.readPermission != null) goto L35;
        boolean allowDefaultRead = true;
    L37:
        if (pi.writePermission != null) goto L39;
        boolean allowDefaultWrite = true;
    L40:
        PathPermission[] pps = pi.pathPermissions;
        if (pps == null) goto L65;
        String path = grantUri.uri.getPath();
        int i = pps.length;
    L43:
        if (i <= 0) goto L65;
        if (readMet == false) goto L46;
        if (writeMet == true) goto L65;
    L46:
        i = i - 1;
        PathPermission pp = pps[i];
        if (pp.match(path) == false) goto L43;
        if (readMet == true) goto L56;
        String pprperm = pp.getReadPermission();
        if (pprperm == null) goto L56;
        if (considerUidPermissions == true) goto L53;
    L55:
        allowDefaultRead = false;
        goto L56
    L53:
        if (checkUidPermission(pprperm, uid) != 0) goto L55;
        readMet = true;
    L56:
        if (writeMet == true) goto L43;
        String ppwperm = pp.getWritePermission();
        if (ppwperm == null) goto L43;
        if (considerUidPermissions == false) goto L63;
        if (checkUidPermission(ppwperm, uid) != 0) goto L63;
        writeMet = true;
    L63:
        allowDefaultWrite = false;
    L65:
        if (allowDefaultRead == false) goto L67;
        readMet = true;
    L67:
        if (allowDefaultWrite == false) goto L70;
        writeMet = true;
    L70:
        if (pi.forceUriPermissions == false) goto L80;
        int providerUserId = UserHandle.getUserId(pi.applicationInfo.uid);
        int clientUserId = UserHandle.getUserId(uid);
        if (providerUserId == clientUserId) goto L74;
        boolean forceMet = false;
    L81:
        if (readMet == false) goto L86;
        if (writeMet == false) goto L86;
        if (forceMet == false) goto L86;
        return true;
    L86:
        return false;
    L74:
        if (this.mAmInternal.checkContentProviderUriPermission(grantUri.uri, providerUserId, uid, modeFlags) != 0) goto L76;
        forceMet = true;
        goto L81
    L76:
        forceMet = false;
        goto L81
    L80:
        forceMet = true;
        goto L81
    L39:
        allowDefaultWrite = false;
        goto L40
    L35:
        allowDefaultRead = false;
        goto L37
    L20:
        if (pi.readPermission == null) goto L25;
        if (considerUidPermissions == false) goto L25;
        if (checkUidPermission(pi.readPermission, uid) != 0) goto L25;
        readMet = true;
        goto L25
    L17:
        writeMet = false;
        goto L18
    L13:
        readMet = false;
        goto L15
    L88:
        throw new IllegalStateException("Must never hold local mLock");
    }

    private void removeUriPermissionIfNeededLocked(UriPermission perm) {
        if (perm.modeFlags == 0) goto L5;
        return;
    L5:
        ArrayMap<GrantUri, UriPermission> perms = this.mGrantedUriPermissions.get(perm.targetUid);
        if (perms != null) goto L8;
        return;
    L8:
        perms.remove(perm.uri);
        if (perms.isEmpty() == false) goto L12;
        this.mGrantedUriPermissions.remove(perm.targetUid);
        return;
    }

    private UriPermission findUriPermissionLocked(int targetUid, GrantUri grantUri) {
        ArrayMap<GrantUri, UriPermission> targetUris = this.mGrantedUriPermissions.get(targetUid);
        if (targetUris != null) goto L5;
        return null;
    L5:
        return targetUris.get(grantUri);
    }

    private void schedulePersistUriGrants() {
        if (this.mH.hasMessages(1) == true) goto L6;
        this.mH.sendMessageDelayed(this.mH.obtainMessage(1), JobStatus.DEFAULT_TRIGGER_UPDATE_DELAY);
        return;
    }

    private void enforceNotIsolatedCaller(String caller) {
        if (UserHandle.isIsolated(Binder.getCallingUid()) == true) goto L6;
        return;
    L6:
        throw new SecurityException("Isolated process not allowed to call " + caller);
    }

    private ProviderInfo getProviderInfo(String authority, int userHandle, int pmFlags, int callingUid) {
        return this.mPmInternal.resolveContentProvider(authority, pmFlags | 2048, userHandle, callingUid);
    }

    private int checkGrantUriPermissionUnlocked(int callingUid, String targetPkg, GrantUri grantUri, int modeFlags, int lastTargetUid) {
        if (isContentUriWithAccessModeFlags(grantUri, modeFlags, "grant URI permission") == true) goto L5;
        return -1;
    L5:
        int callingAppId = UserHandle.getAppId(callingUid);
        if (callingAppId == 1000) goto L9;
        if (callingAppId == 0) goto L9;
    L15:
        String authority = grantUri.uri.getAuthority();
        ProviderInfo pi = getProviderInfo(authority, grantUri.sourceUserId, 268435456, callingUid);
        if (pi != null) goto L20;
        Slog.w(TAG, "No content provider found for permission check: " + grantUri.uri.toSafeString());
        return -1;
    L20:
        if (lastTargetUid >= 0) goto L26;
        if (targetPkg == null) goto L26;
        int targetUid = this.mPmInternal.getPackageUid(targetPkg, 268435456, UserHandle.getUserId(callingUid));
        if (targetUid >= 0) goto L25;
        return -1;
    L25:
        int targetUid2 = targetUid;
    L27:
        int targetUid3 = 0;
        if (targetUid2 >= 0) goto L30;
        boolean allowed = pi.exported;
        if ((modeFlags & 1) == 0) goto L38;
        if (pi.readPermission == null) goto L38;
        allowed = false;
    L38:
        if ((modeFlags & 2) == 0) goto L43;
        if (pi.writePermission == null) goto L43;
        allowed = false;
    L43:
        if (pi.pathPermissions == null) goto L61;
        int N = pi.pathPermissions.length;
        int i = 0;
    L45:
        if (i >= N) goto L61;
        if (pi.pathPermissions[i] == null) goto L60;
        if (pi.pathPermissions[i].match(grantUri.uri.getPath()) == false) goto L60;
        if ((modeFlags & 1) == 0) goto L56;
        if (pi.pathPermissions[i].getReadPermission() == null) goto L56;
        allowed = false;
    L56:
        if ((modeFlags & 2) == 0) goto L61;
        if (pi.pathPermissions[i].getWritePermission() == null) goto L61;
        allowed = false;
    L60:
        i = i + 1;
    L61:
        if (allowed == false) goto L64;
        targetUid3 = 1;
    L64:
        if (pi.forceUriPermissions == false) goto L66;
        int r11 = 0;
    L67:
        boolean specialCrossUserGrant = false;
        if ((modeFlags & 192) != 0) goto L70;
        boolean r0 = true;
    L71:
        boolean basicGrant = r0;
        if (basicGrant == false) goto L76;
        if (r11 == 0) goto L76;
        this.mPmInternal.grantImplicitAccess(UserHandle.getUserId(targetUid2), null, UserHandle.getAppId(targetUid2), pi.applicationInfo.uid, false);
        return -1;
    L76:
        if (targetUid2 >= 0) goto L78;
        ProviderInfo pi2 = pi;
    L85:
        boolean grantAllowed = pi2.grantUriPermissions;
        if (ArrayUtils.isEmpty(pi2.uriPermissionPatterns) == true) goto L97;
        int N2 = pi2.uriPermissionPatterns.length;
        boolean grantAllowed2 = false;
        int i2 = 0;
    L88:
        if (i2 >= N2) goto L96;
        if (pi2.uriPermissionPatterns[i2] == null) goto L95;
        if (pi2.uriPermissionPatterns[i2].match(grantUri.uri.getPath()) == false) goto L95;
        boolean grantAllowed3 = true;
    L98:
        if (grantAllowed3 == true) goto L107;
        if (specialCrossUserGrant == false) goto L105;
        if (basicGrant == true) goto L107;
        throw new SecurityException("Provider " + pi2.packageName + SliceClientPermissions.SliceAuthority.DELIMITER + pi2.name + " does not allow granting of advanced Uri permissions (uri " + grantUri + ")");
    L105:
        throw new SecurityException("Provider " + pi2.packageName + SliceClientPermissions.SliceAuthority.DELIMITER + pi2.name + " does not allow granting of Uri permissions (uri " + grantUri + ")");
    L107:
        if (checkHoldingPermissionsUnlocked(pi2, grantUri, callingUid, modeFlags) == true) goto L122;
        Object r6 = this.mLock;
        monitor-enter(r6);
        boolean res = checkUriPermissionLocked(grantUri, callingUid, modeFlags);     // Catch: Throwable -> L119
        monitor-exit(r6);     // Catch: Throwable -> L119
        if (res == true) goto L122;
        if ("android.permission.MANAGE_DOCUMENTS".equals(pi2.readPermission) == false) goto L118;
        throw new SecurityException("UID " + callingUid + " does not have permission to " + grantUri + "; you could obtain access using ACTION_OPEN_DOCUMENT or related APIs");
    L118:
        throw new SecurityException("UID " + callingUid + " does not have permission to " + grantUri);
    L119:
        th = move-exception;
        throw th;
    L122:
        return targetUid2;
    L95:
        i2 = i2 + 1;
        grantAllowed2 = grantAllowed2;
        goto L88
    L96:
        grantAllowed3 = grantAllowed2;
        goto L98
    L97:
        grantAllowed3 = grantAllowed;
        goto L98
    L78:
        if (UserHandle.getUserId(targetUid2) == grantUri.sourceUserId) goto L82;
        pi2 = pi;
        if (checkHoldingPermissionsInternalUnlocked(pi2, grantUri, callingUid, modeFlags, false) == false) goto L85;
        specialCrossUserGrant = true;
        goto L85
    L82:
        pi2 = pi;
        goto L85
    L70:
        r0 = false;
        goto L71
    L66:
        r11 = targetUid3;
        goto L67
    L30:
        if (checkHoldingPermissionsUnlocked(pi, grantUri, targetUid2, modeFlags) == false) goto L64;
        targetUid3 = 1;
    L26:
        targetUid2 = lastTargetUid;
    L9:
        if ("com.android.settings.files".equals(grantUri.uri.getAuthority()) == true) goto L15;
        if ("com.android.settings.module_licenses".equals(grantUri.uri.getAuthority()) == true) goto L15;
        Slog.w(TAG, "For security reasons, the system cannot issue a Uri permission grant to " + grantUri + "; use startActivityAsCaller() instead");
        return -1;
    }

    private boolean isContentUriWithAccessModeFlags(GrantUri grantUri, int modeFlags, String logAction) {
        if (Intent.isAccessUriMode(modeFlags) == true) goto L6;
        return false;
    L6:
        if (ActivityTaskManagerInternal.ASSIST_KEY_CONTENT.equals(grantUri.uri.getScheme()) == true) goto L8;
        return false;
    L8:
        return true;
    }

    private boolean checkContentUriPermissionFullUnlocked(GrantUri grantUri, int uid, int modeFlags) {
        if (uid < 0) goto L28;
        if (isContentUriWithAccessModeFlags(grantUri, modeFlags, "check content URI permission") == false) goto L26;
        int appId = UserHandle.getAppId(uid);
        if (appId == 1000) goto L24;
        if (appId == 0) goto L24;
        String authority = grantUri.uri.getAuthority();
        ProviderInfo pi = getProviderInfo(authority, grantUri.sourceUserId, 268435456, uid);
        if (pi != null) goto L14;
        Slog.w(TAG, "No content provider found for content URI permission check: " + grantUri.uri.toSafeString());
        return false;
    L14:
        if (checkHoldingPermissionsUnlocked(pi, grantUri, uid, modeFlags) == false) goto L16;
        return true;
    L16:
        Object r4 = this.mLock;
        monitor-enter(r4);
        boolean r2 = checkUriPermissionLocked(grantUri, uid, modeFlags);     // Catch: Throwable -> L21
        monitor-exit(r4);     // Catch: Throwable -> L21
        return r2;
    L21:
        th = move-exception;
        throw th;
    L24:
        return true;
    L26:
        throw new IllegalArgumentException("The URI must be a content URI and the mode flags must be at least read and/or write for the content URI permission check of " + grantUri.uri.toSafeString());
    L28:
        throw new IllegalArgumentException("Uid must be positive for the content URI permission check of " + grantUri.uri.toSafeString());
    }

    private int checkGrantUriPermissionUnlocked(int callingUid, String targetPkg, Uri uri, int modeFlags, int userId) {
        return checkGrantUriPermissionUnlocked(callingUid, targetPkg, new GrantUri(userId, uri, modeFlags), modeFlags, -1);
    }

    private boolean checkUriPermissionLocked(GrantUri grantUri, int uid, int modeFlags) {
        if ((modeFlags & 64) == 0) goto L5;
        boolean persistable = true;
    L6:
        if (persistable == false) goto L8;
        int minStrength = 3;
    L10:
        if (uid != 0) goto L12;
        return true;
    L12:
        ArrayMap<GrantUri, UriPermission> perms = this.mGrantedUriPermissions.get(uid);
        if (perms != null) goto L15;
        return false;
    L15:
        UriPermission exactPerm = perms.get(grantUri);
        if (exactPerm != null) goto L18;
    L20:
        int N = perms.size();
        int i = 0;
    L21:
        if (i >= N) goto L31;
        UriPermission perm = perms.valueAt(i);
        if (perm.uri.prefix == false) goto L29;
        if (grantUri.uri.isPathPrefixMatch(perm.uri.uri) == false) goto L29;
        if (perm.getStrength(modeFlags) < minStrength) goto L29;
        return true;
    L29:
        i = i + 1;
        goto L21
    L31:
        return false;
    L18:
        if (exactPerm.getStrength(modeFlags) < minStrength) goto L20;
        return true;
    L8:
        minStrength = 1;
        goto L10
    L5:
        persistable = false;
        goto L6
    }

    public int checkGrantUriPermission_ignoreNonSystem(int callingUid, String targetPkg, Uri uri, int modeFlags, int userId) {
        if (isCallerIsSystemOrPrivileged() == true) goto L6;
        return -1;
    L6:
        long origId = Binder.clearCallingIdentity();
        int r0 = checkGrantUriPermissionUnlocked(callingUid, targetPkg, uri, modeFlags, userId);     // Catch: Throwable -> L10
        Binder.restoreCallingIdentity(origId);
        return r0;
    L10:
        th = move-exception;
        Binder.restoreCallingIdentity(origId);
        throw th;
    }

    private boolean isCallerIsSystemOrPrivileged() {
        int uid = Binder.getCallingUid();
        if (uid == 1000) goto L11;
        if (uid == 0) goto L11;
        if (checkComponentPermission("android.permission.INTERACT_ACROSS_USERS_FULL", uid, -1, true) == 0) goto L12;
        return false;
    L12:
        return true;
    L11:
        return true;
    }

    @Override // com.android.server.uri.UriMetricsHelper.PersistentUriGrantsProvider
    public ArrayList<UriPermission> providePersistentUriGrants() {
        ArrayList<UriPermission> result = new ArrayList();
        Object r1 = this.mLock;
        monitor-enter(r1);
        int size = this.mGrantedUriPermissions.size();     // Catch: Throwable -> L11
        int i = 0;
    L5:
        if (i >= size) goto L16;
        ArrayMap<GrantUri, UriPermission> perms = this.mGrantedUriPermissions.valueAt(i);     // Catch: Throwable -> L11
        int permissionsForPackageSize = perms.size();     // Catch: Throwable -> L11
        int j = 0;
    L7:
        if (j >= permissionsForPackageSize) goto L14;
        UriPermission permission = perms.valueAt(j);     // Catch: Throwable -> L11
        if (permission.persistedModeFlags == 0) goto L13;
        result.add(permission);     // Catch: Throwable -> L11
    L13:
        j = j + 1;     // Catch: Throwable -> L11
        goto L7
    L14:
        i = i + 1;     // Catch: Throwable -> L11
        goto L5
    L16:
        monitor-exit(r1);     // Catch: Throwable -> L11
        return result;
    L11:
        th = move-exception;
        throw th;
    }

    private void writeGrantedUriPermissions() {
        long startTime = SystemClock.uptimeMillis();
        int persistentUriPermissionsCount = 0;
        ArrayList<UriPermission.Snapshot> persist = Lists.newArrayList();
        Object r4 = this.mLock;
        monitor-enter(r4);
        int size = this.mGrantedUriPermissions.size();     // Catch: Throwable -> L11
        int i = 0;
    L5:
        if (i >= size) goto L16;
        ArrayMap<GrantUri, UriPermission> perms = this.mGrantedUriPermissions.valueAt(i);     // Catch: Throwable -> L11
        int permissionsForPackageSize = perms.size();     // Catch: Throwable -> L11
        int j = 0;
    L7:
        if (j >= permissionsForPackageSize) goto L14;
        UriPermission permission = perms.valueAt(j);     // Catch: Throwable -> L11
        if (permission.persistedModeFlags == 0) goto L13;
        persistentUriPermissionsCount = persistentUriPermissionsCount + 1;     // Catch: Throwable -> L11
        persist.add(permission.snapshot());     // Catch: Throwable -> L11
    L13:
        j = j + 1;     // Catch: Throwable -> L11
        goto L7
    L14:
        i = i + 1;     // Catch: Throwable -> L11
        goto L5
    L16:
        monitor-exit(r4);     // Catch: Throwable -> L11
        FileOutputStream fos = null;
        fos = this.mGrantFile.startWrite(startTime);     // Catch: IOException -> L22
        TypedXmlSerializer out = Xml.resolveSerializer(fos);     // Catch: IOException -> L22
        out.startDocument(null, true);     // Catch: IOException -> L22
        out.startTag(null, TAG_URI_GRANTS);     // Catch: IOException -> L22
        Iterator<UriPermission.Snapshot> r6 = persist.iterator();     // Catch: IOException -> L22
    L20:
        if (r6.hasNext() == false) goto L24;
        UriPermission.Snapshot perm = r6.next();     // Catch: IOException -> L22
        out.startTag(null, TAG_URI_GRANT);     // Catch: IOException -> L22
        out.attributeInt(null, ATTR_SOURCE_USER_ID, perm.uri.sourceUserId);     // Catch: IOException -> L22
        out.attributeInt(null, ATTR_TARGET_USER_ID, perm.targetUserId);     // Catch: IOException -> L22
        out.attributeInterned(null, ATTR_SOURCE_PKG, perm.sourcePkg);     // Catch: IOException -> L22
        out.attributeInterned(null, ATTR_TARGET_PKG, perm.targetPkg);     // Catch: IOException -> L22
        out.attribute(null, ATTR_URI, String.valueOf(perm.uri.uri));     // Catch: IOException -> L22
        XmlUtils.writeBooleanAttribute(out, ATTR_PREFIX, perm.uri.prefix);     // Catch: IOException -> L22
        out.attributeInt(null, ATTR_MODE_FLAGS, perm.persistedModeFlags);     // Catch: IOException -> L22
        out.attributeLong(null, ATTR_CREATED_TIME, perm.persistedCreateTime);     // Catch: IOException -> L22
        out.endTag(null, TAG_URI_GRANT);     // Catch: IOException -> L22
        goto L20
    L24:
        out.endTag(null, TAG_URI_GRANTS);     // Catch: IOException -> L22
        out.endDocument();     // Catch: IOException -> L22
        this.mGrantFile.finishWrite(fos);     // Catch: IOException -> L22
    L29:
        this.mMetricsHelper.reportPersistentUriFlushed(persistentUriPermissionsCount);
        return;
    L27:
        if (fos == null) goto L29;
        this.mGrantFile.failWrite(fos);
    L11:
        th = move-exception;
        throw th;
    }
}
