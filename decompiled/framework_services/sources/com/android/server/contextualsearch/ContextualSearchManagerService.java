package com.android.server.contextualsearch;

import android.R;
import android.app.ActivityManagerInternal;
import android.app.ActivityOptions;
import android.app.AppOpsManager;
import android.app.contextualsearch.CallbackToken;
import android.app.contextualsearch.ContextualSearchState;
import android.app.contextualsearch.IContextualSearchCallback;
import android.app.contextualsearch.IContextualSearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManagerInternal;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.ParcelableException;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.ServiceManager;
import android.os.ShellCallback;
import android.os.SystemClock;
import android.os.UserManager;
import android.provider.Settings;
import android.util.Log;
import android.view.IWindowManager;
import android.window.ScreenCapture;
import com.android.server.LocalServices;
import com.android.server.SystemService;
import com.android.server.am.AssistDataRequester;
import com.android.server.wm.ActivityAssistInfo;
import com.android.server.wm.ActivityTaskManagerInternal;
import com.android.server.wm.WindowManagerInternal;
import java.io.FileDescriptor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ContextualSearchManagerService extends SystemService {
    private static final boolean DEBUG = false;
    private static final int INTERNAL_ENTRYPOINT_APP = -1;
    private static final int MAX_TEMP_PACKAGE_DURATION_MS = 120000;
    private static final int MAX_TOKEN_VALID_DURATION_MS = 600000;
    private static final int MSG_INVALIDATE_TOKEN = 1;
    private static final int MSG_RESET_TEMPORARY_PACKAGE = 0;
    private static final String TAG = null;
    private final ActivityManagerInternal mActivityManagerInternal;
    private final AssistDataRequester.AssistDataRequesterCallbacks mAssistDataCallbacks;
    private final AssistDataRequester mAssistDataRequester;
    private final ActivityTaskManagerInternal mAtmInternal;
    private final AudioManager mAudioManager;
    private final Context mContext;
    private final Object mLock;
    private final PackageManagerInternal mPackageManager;
    private IContextualSearchCallback mStateCallback;
    private Handler mTemporaryHandler;
    private String mTemporaryPackage;
    private long mTokenValidDurationMs;
    private final UserManager mUserManager;
    private final WindowManagerInternal mWmInternal;

    private class ContextualSearchManagerStub extends IContextualSearchManager.Stub {
        private CallbackToken mToken;
        private Handler mTokenHandler;
        final /* synthetic */ ContextualSearchManagerService this$0;

        public static /* synthetic */ void $r8$lambda$6UC9nHPJPVkwqjSGuame_A2_HQE(ContextualSearchManagerStub r0, int r1, int r2, String r3) {
            r0.lambda$startContextualSearchInternal$0(r1, r2, r3);
        }

        /* JADX INFO: renamed from: -$$Nest$minvalidateToken, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m3257$$Nest$minvalidateToken(ContextualSearchManagerStub r0) {
            r0.invalidateToken();
        }

        /* synthetic */ ContextualSearchManagerStub(ContextualSearchManagerService r1, ContextualSearchManagerServiceIA r2) {
            this(r1);
        }

        private ContextualSearchManagerStub(ContextualSearchManagerService r1) {
            this.this$0 = r1;
        }

        private void invalidateToken() {
            monitor-enter(this);
        L6:
            th = move-exception;
            throw th;
        L4:
            if (this.mTokenHandler == null) goto L8;
            this.mTokenHandler.removeMessages(1);     // Catch: Throwable -> L6
            this.mTokenHandler = null;     // Catch: Throwable -> L6
        L8:
            this.mToken = null;     // Catch: Throwable -> L6
            monitor-exit(this);     // Catch: Throwable -> L6
        }

        private void issueToken() {
            monitor-enter(this);
            this.mToken = new CallbackToken();     // Catch: Throwable -> L6
            final boolean r1 = true;
            if (this.mTokenHandler != null) goto L8;
            final Looper r2 = Looper.getMainLooper();     // Catch: Throwable -> L6
            final Handler.Callback r3 = null;
            this.mTokenHandler = new AnonymousClass1(this, r2, r3, r1);     // Catch: Throwable -> L6
        L9:
            this.mTokenHandler.sendEmptyMessageDelayed(1, ContextualSearchManagerService.m3254$$Nest$mgetTokenValidDurationMs(this.this$0));     // Catch: Throwable -> L6
            monitor-exit(this);     // Catch: Throwable -> L6
            return;
        L8:
            this.mTokenHandler.removeMessages(1);     // Catch: Throwable -> L6
        L6:
            th = move-exception;
            throw th;
        }

        public void startContextualSearchForForegroundApp() {
            monitor-enter(this);
            ContextualSearchManagerService.m3251$$Nest$menforceForegroundApp(this.this$0, "startContextualSearchForForegroundApp");     // Catch: Throwable -> L6
            startContextualSearchInternal(-1);     // Catch: Throwable -> L6
            monitor-exit(this);     // Catch: Throwable -> L6
            return;
        L6:
            th = move-exception;
            throw th;
        }

        public void startContextualSearch(int entrypoint) {
            monitor-enter(this);
            ContextualSearchManagerService.m3252$$Nest$menforcePermission(this.this$0, "startContextualSearch");     // Catch: Throwable -> L6
            startContextualSearchInternal(entrypoint);     // Catch: Throwable -> L6
            monitor-exit(this);     // Catch: Throwable -> L6
            return;
        L6:
            th = move-exception;
            throw th;
        }

        private void startContextualSearchInternal(final int entrypoint) {
            final String callingPackage = ContextualSearchManagerService.m3247$$Nest$fgetmPackageManager(this.this$0).getNameForUid(Binder.getCallingUid());
            final int callingUserId = Binder.getCallingUserHandle().getIdentifier();
            ContextualSearchManagerService.m3245$$Nest$fgetmAssistDataRequester(this.this$0).cancel();
            issueToken();
            Binder.withCleanCallingIdentity(new ContextualSearchManagerService$ContextualSearchManagerStub$$ExternalSyntheticLambda0(this, entrypoint, callingUserId, callingPackage));
        }

        private /* synthetic */ void lambda$startContextualSearchInternal$0(int entrypoint, int callingUserId, String callingPackage) throws Exception {
            Intent launchIntent = ContextualSearchManagerService.m3253$$Nest$mgetContextualSearchIntent(this.this$0, entrypoint, callingUserId, callingPackage, this.mToken);
            if (launchIntent == null) goto L6;
            ContextualSearchManagerService.m3255$$Nest$minvokeContextualSearchIntent(this.this$0, launchIntent, callingUserId);
            return;
        }

        public void getContextualSearchState(IBinder token, IContextualSearchCallback callback) {
            if (this.mToken != null) goto L5;
        L21:
            callback.onError(new ParcelableException(new IllegalArgumentException("Invalid token")));     // Catch: RemoteException -> L18
            return;
        L18:
            e = move-exception;
            Log.e(ContextualSearchManagerService.m3256$$Nest$sfgetTAG(), "Could not invoke onError callback", e);
            return;
        L5:
            if (this.mToken.getToken().equals(token) == false) goto L21;
            invalidateToken();
            Object r0 = ContextualSearchManagerService.m3246$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            ContextualSearchManagerService.m3250$$Nest$fputmStateCallback(this.this$0, callback);     // Catch: Throwable -> L13
            monitor-exit(r0);     // Catch: Throwable -> L13
            ContextualSearchManagerService.m3245$$Nest$fgetmAssistDataRequester(this.this$0).processPendingAssistData();
            return;
        L13:
            th = move-exception;
            throw th;
        }

        private /* synthetic */ void lambda$getContextualSearchState$1(int callingUid, Bundle bundle, IContextualSearchCallback callback) throws Exception {
            ScreenCapture.ScreenshotHardwareBuffer shb = ContextualSearchManagerService.m3249$$Nest$fgetmWmInternal(this.this$0).takeContextualSearchScreenshot(callingUid);
            if (shb == null) goto L5;
            Bitmap bm = shb.asBitmap();
        L6:
            if (bm == null) goto L13;
            bundle.putParcelable("android.app.contextualsearch.extra.SCREENSHOT", bm.asShared());
            bundle.putBoolean("android.app.contextualsearch.extra.FLAG_SECURE_FOUND", shb.containsSecureLayers());
        L13:
            callback.onResult(new ContextualSearchState(null, null, bundle));     // Catch: RemoteException -> L10
            return;
        L10:
            e = move-exception;
            Log.e(ContextualSearchManagerService.m3256$$Nest$sfgetTAG(), "Error invoking ContextualSearchCallback", e);
            return;
        L5:
            bm = null;
            goto L6
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void onShellCommand(FileDescriptor in, FileDescriptor out, FileDescriptor err, String[] args, ShellCallback callback, ResultReceiver resultReceiver) {
            new ContextualSearchManagerShellCommand(this.this$0).exec(this, in, out, err, args, callback, resultReceiver);
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAssistDataRequester, reason: not valid java name */
    static /* bridge */ /* synthetic */ AssistDataRequester m3245$$Nest$fgetmAssistDataRequester(ContextualSearchManagerService r0) {
        return r0.mAssistDataRequester;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m3246$$Nest$fgetmLock(ContextualSearchManagerService r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPackageManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ PackageManagerInternal m3247$$Nest$fgetmPackageManager(ContextualSearchManagerService r0) {
        return r0.mPackageManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmStateCallback, reason: not valid java name */
    static /* bridge */ /* synthetic */ IContextualSearchCallback m3248$$Nest$fgetmStateCallback(ContextualSearchManagerService r0) {
        return r0.mStateCallback;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmWmInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ WindowManagerInternal m3249$$Nest$fgetmWmInternal(ContextualSearchManagerService r0) {
        return r0.mWmInternal;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmStateCallback, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3250$$Nest$fputmStateCallback(ContextualSearchManagerService r0, IContextualSearchCallback r1) {
        r0.mStateCallback = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$menforceForegroundApp, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3251$$Nest$menforceForegroundApp(ContextualSearchManagerService r0, String r1) {
        r0.enforceForegroundApp(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$menforcePermission, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3252$$Nest$menforcePermission(ContextualSearchManagerService r0, String r1) {
        r0.enforcePermission(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetContextualSearchIntent, reason: not valid java name */
    static /* bridge */ /* synthetic */ Intent m3253$$Nest$mgetContextualSearchIntent(ContextualSearchManagerService r0, int r1, int r2, String r3, CallbackToken r4) {
        return r0.getContextualSearchIntent(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetTokenValidDurationMs, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m3254$$Nest$mgetTokenValidDurationMs(ContextualSearchManagerService r2) {
        return r2.getTokenValidDurationMs();
    }

    /* JADX INFO: renamed from: -$$Nest$minvokeContextualSearchIntent, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m3255$$Nest$minvokeContextualSearchIntent(ContextualSearchManagerService r0, Intent r1, int r2) {
        return r0.invokeContextualSearchIntent(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetTAG, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m3256$$Nest$sfgetTAG() {
        return TAG;
    }

    static {
        TAG = ContextualSearchManagerService.class.getSimpleName();
    }

    public ContextualSearchManagerService(Context context) {
        super(context);
        this.mLock = new Object();
        this.mAssistDataCallbacks = new AnonymousClass1(this);
        this.mTemporaryPackage = null;
        this.mTokenValidDurationMs = 600000;
        this.mContext = context;
        ActivityManagerInternal r0 = (ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class);
        r0.getClass();
        this.mActivityManagerInternal = r0;
        ActivityTaskManagerInternal r1 = (ActivityTaskManagerInternal) LocalServices.getService(ActivityTaskManagerInternal.class);
        r1.getClass();
        this.mAtmInternal = r1;
        this.mPackageManager = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
        this.mAudioManager = (AudioManager) context.getSystemService(AudioManager.class);
        this.mUserManager = (UserManager) context.getSystemService(UserManager.class);
        WindowManagerInternal r2 = (WindowManagerInternal) LocalServices.getService(WindowManagerInternal.class);
        r2.getClass();
        this.mWmInternal = r2;
        this.mAssistDataRequester = new AssistDataRequester(this.mContext, IWindowManager.Stub.asInterface(ServiceManager.getService("window")), (AppOpsManager) this.mContext.getSystemService(AppOpsManager.class), this.mAssistDataCallbacks, this.mLock, 49, 50);
        updateSecureSetting();
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        publishBinderService("contextual_search", new ContextualSearchManagerStub(this, null));
    }

    private void updateSecureSetting() {
        Settings.Secure.putString(this.mContext.getContentResolver(), "contextual_search_package", getContextualSearchPackageName());
    }

    private String getContextualSearchPackageName() {
        monitor-enter(this);
    L6:
        th = move-exception;
        throw th;
    L4:
        if (this.mTemporaryPackage == null) goto L8;
        String r0 = this.mTemporaryPackage;     // Catch: Throwable -> L6
    L9:
        monitor-exit(this);     // Catch: Throwable -> L6
        return r0;
    L8:
        r0 = this.mContext.getResources().getString(R.string.config_dozeDoubleTapSensorType);     // Catch: Throwable -> L6
        goto L9
    }

    void resetTemporaryPackage() {
        monitor-enter(this);
        enforceOverridingPermission("resetTemporaryPackage");     // Catch: Throwable -> L6
        if (this.mTemporaryHandler == null) goto L8;
        this.mTemporaryHandler.removeMessages(0);     // Catch: Throwable -> L6
        this.mTemporaryHandler = null;     // Catch: Throwable -> L6
    L8:
        this.mTemporaryPackage = null;     // Catch: Throwable -> L6
        updateSecureSetting();     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    void setTemporaryPackage(String temporaryPackage, int durationMs) {
        monitor-enter(this);
        enforceOverridingPermission("setTemporaryPackage");     // Catch: Throwable -> L8
        if (durationMs > MAX_TEMP_PACKAGE_DURATION_MS) goto L15;
        if (this.mTemporaryHandler != null) goto L10;
        final Looper r3 = Looper.getMainLooper();     // Catch: Throwable -> L8
        final Handler.Callback r4 = null;
        final boolean r5 = true;
        this.mTemporaryHandler = new AnonymousClass2(this, r3, r4, r5);     // Catch: Throwable -> L8
    L11:
        this.mTemporaryPackage = temporaryPackage;     // Catch: Throwable -> L8
        updateSecureSetting();     // Catch: Throwable -> L8
        this.mTemporaryHandler.sendEmptyMessageDelayed(0, durationMs);     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L10:
        this.mTemporaryHandler.removeMessages(0);     // Catch: Throwable -> L8
        goto L11
    L15:
        throw new IllegalArgumentException("Max duration is 120000 (called with " + durationMs + ")");     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    void resetTokenValidDurationMs() {
        setTokenValidDurationMs(600000);
    }

    void setTokenValidDurationMs(int durationMs) {
        monitor-enter(this);
        enforceOverridingPermission("setTokenValidDurationMs");     // Catch: Throwable -> L8
        if (durationMs > 600000) goto L11;
        this.mTokenValidDurationMs = durationMs;     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L11:
        throw new IllegalArgumentException("Token max duration is 600000 (called with " + durationMs + ")");     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    private long getTokenValidDurationMs() {
        monitor-enter(this);
        long r0 = this.mTokenValidDurationMs;     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    private Intent getResolvedLaunchIntent(int userId) {
        monitor-enter(this);
        String csPkgName = getContextualSearchPackageName();     // Catch: Throwable -> L7
        if (csPkgName.isEmpty() == false) goto L9;
        monitor-exit(this);     // Catch: Throwable -> L7
        return null;
    L9:
        Intent launchIntent = new Intent("android.app.contextualsearch.action.LAUNCH_CONTEXTUAL_SEARCH");     // Catch: Throwable -> L7
        launchIntent.setPackage(csPkgName);     // Catch: Throwable -> L7
        ResolveInfo resolveInfo = this.mContext.getPackageManager().resolveActivityAsUser(launchIntent, 786432, userId);     // Catch: Throwable -> L7
        if (resolveInfo != null) goto L13;
        monitor-exit(this);     // Catch: Throwable -> L7
        return null;
    L13:
        ComponentName componentName = resolveInfo.getComponentInfo().getComponentName();     // Catch: Throwable -> L7
        if (componentName != null) goto L17;
        monitor-exit(this);     // Catch: Throwable -> L7
        return null;
    L17:
        launchIntent.setComponent(componentName);     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        return launchIntent;
    L7:
        th = move-exception;
        throw th;
    }

    private Intent getContextualSearchIntent(int entrypoint, int userId, String callingPackage, CallbackToken mToken) {
        Intent launchIntent = getResolvedLaunchIntent(userId);
        if (launchIntent != null) goto L5;
        return null;
    L5:
        launchIntent.addFlags(268795904);
        launchIntent.putExtra("android.app.contextualsearch.extra.INVOCATION_TIME_MS", SystemClock.uptimeMillis());
        launchIntent.putExtra("android.app.contextualsearch.extra.ENTRYPOINT", entrypoint);
        launchIntent.putExtra("android.app.contextualsearch.extra.TOKEN", mToken);
        boolean isAssistDataAllowed = this.mAtmInternal.isAssistDataAllowed();
        List<ActivityAssistInfo> records = this.mAtmInternal.getTopVisibleActivities();
        List<IBinder> activityTokens = new ArrayList(records.size());
        ArrayList<String> visiblePackageNames = new ArrayList();
        Iterator<ActivityAssistInfo> r10 = records.iterator();
        boolean isManagedProfileVisible = false;
    L6:
        boolean isManagedProfileVisible2 = r10.hasNext();
        if (isManagedProfileVisible2 == false) goto L15;
        ActivityAssistInfo record = r10.next();
        if (isAssistDataAllowed == false) goto L12;
        visiblePackageNames.add(record.getComponentName().getPackageName());
        activityTokens.add(record.getActivityToken());
    L12:
        if (this.mUserManager.isManagedProfile(record.getUserId()) == false) goto L6;
        isManagedProfileVisible = true;
        goto L6
    L15:
        String csPackage = launchIntent.getPackage();
        csPackage.getClass();
        int csUid = this.mPackageManager.getPackageUid(csPackage, 0, userId);
        if (isAssistDataAllowed == true) goto L40;
        boolean isManagedProfileVisible3 = isManagedProfileVisible;
        csUid = csUid;
    L28:
        ScreenCapture.ScreenshotHardwareBuffer shb = this.mWmInternal.takeContextualSearchScreenshot(csUid);
        if (shb == null) goto L31;
        Bitmap bm = shb.asBitmap();
    L32:
        if (bm == null) goto L36;
        launchIntent.putExtra("android.app.contextualsearch.extra.FLAG_SECURE_FOUND", shb.containsSecureLayers());
        if (isAssistDataAllowed == false) goto L36;
        launchIntent.putExtra("android.app.contextualsearch.extra.SCREENSHOT", bm.asShared());
    L36:
        launchIntent.putExtra("android.app.contextualsearch.extra.IS_MANAGED_PROFILE_VISIBLE", isManagedProfileVisible3);
        if (isAssistDataAllowed == false) goto L39;
        launchIntent.putExtra("android.app.contextualsearch.extra.VISIBLE_PACKAGE_NAMES", visiblePackageNames);
    L39:
        return launchIntent;
    L31:
        bm = null;
        goto L32
    L40:
        isManagedProfileVisible3 = isManagedProfileVisible;
        this.mAssistDataRequester.requestAssistData(activityTokens, true, false, true, false, csUid, csPackage, null);     // Catch: Exception -> L22
        csUid = csUid;
    L22:
        e = e;
    L26:
        Log.e(TAG, "Could not request assist data", e);
    L24:
        e = e;
        isManagedProfileVisible3 = isManagedProfileVisible;
        goto L26
    }

    private int invokeContextualSearchIntent(Intent launchIntent, int userId) {
        ActivityOptions opts = ActivityOptions.makeCustomTaskAnimation(this.mContext, 0, 0, null, null, null);
        opts.setDisableStartingWindow(true);
        return this.mAtmInternal.startActivityWithScreenshot(launchIntent, this.mContext.getPackageName(), Binder.getCallingUid(), Binder.getCallingPid(), null, opts.toBundle(), userId);
    }

    private void enforcePermission(String func) {
        Context ctx = getContext();
        if (ctx.checkCallingPermission("android.permission.ACCESS_CONTEXTUAL_SEARCH") != 0) goto L5;
        return;
    L5:
        if (isCallerTemporary() == true) goto L10;
        String msg = "Permission Denial: Cannot call " + func + " from pid=" + Binder.getCallingPid() + ", uid=" + Binder.getCallingUid();
        throw new SecurityException(msg);
    }

    private void enforceForegroundApp(String func) {
        int callingUid = Binder.getCallingUid();
        String callingPackage = this.mPackageManager.getNameForUid(Binder.getCallingUid());
        if (this.mActivityManagerInternal.getUidProcessState(callingUid) > 2) goto L5;
        return;
    L5:
        String msg = "Permission Denial: Cannot call " + func + " from pid=" + Binder.getCallingPid() + ", uid=" + callingUid + ", package=" + callingPackage + " without a foreground activity.";
        throw new SecurityException(msg);
    }

    private void enforceOverridingPermission(String func) {
        if (Binder.getCallingUid() != 2000) goto L5;
        return;
    L5:
        if (Binder.getCallingUid() != 0) goto L7;
        return;
    L7:
        if (Binder.getCallingUid() == 1000) goto L13;
        String msg = "Permission Denial: Cannot override Contextual Search. Called " + func + " from pid=" + Binder.getCallingPid() + ", uid=" + Binder.getCallingUid();
        throw new SecurityException(msg);
    }

    private boolean isCallerTemporary() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.mTemporaryPackage != null) goto L6;
    L10:
        boolean r0 = false;
    L11:
        monitor-exit(this);     // Catch: Throwable -> L8
        return r0;
    L6:
        if (this.mTemporaryPackage.equals(getContext().getPackageManager().getNameForUid(Binder.getCallingUid())) == false) goto L10;
        r0 = true;
        goto L11
    }
}
