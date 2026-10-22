package com.android.server;

import android.app.role.RoleManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManagerInternal;
import android.media.projection.MediaProjectionInfo;
import android.media.projection.MediaProjectionManager;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.Trace;
import android.os.UserHandle;
import android.provider.Settings;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.util.ArraySet;
import android.util.Log;
import android.view.ISensitiveContentProtectionManager;
import com.android.internal.util.FrameworkStatsLog;
import com.android.server.wm.SensitiveContentPackages;
import com.android.server.wm.WindowManagerInternal;
import java.util.Random;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class SensitiveContentProtectionManagerService extends SystemService {
    private static final boolean DEBUG = false;
    private static final String TAG = "SensitiveContentProtect";
    private ArraySet<String> mExemptedPackages;
    private MediaProjectionSession mMediaProjectionSession;
    NotificationListener mNotificationListener;
    private final WindowManagerInternal.OnWindowRemovedListener mOnWindowRemovedListener;
    private PackageManagerInternal mPackageManagerInternal;
    private final ArraySet<SensitiveContentPackages.PackageInfo> mPackagesShowingSensitiveContent;
    private boolean mProjectionActive;
    private final MediaProjectionManager.Callback mProjectionCallback;
    private MediaProjectionManager mProjectionManager;
    private RoleManager mRoleManager;
    final Object mSensitiveContentProtectionLock;
    private WindowManagerInternal mWindowManager;

    private static class MediaProjectionSession {
        private final ArraySet<String> mAllSeenNotificationKeys;
        private final boolean mIsExempted;
        private final ArraySet<String> mSeenOtpNotificationKeys;
        private final long mSessionId;
        private final int mUid;

        /* JADX INFO: renamed from: -$$Nest$fgetmSessionId, reason: not valid java name */
        static /* bridge */ /* synthetic */ long m302$$Nest$fgetmSessionId(MediaProjectionSession r2) {
            return r2.mSessionId;
        }

        /* JADX INFO: renamed from: -$$Nest$maddSeenNotificationKey, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m303$$Nest$maddSeenNotificationKey(MediaProjectionSession r0, String r1) {
            r0.addSeenNotificationKey(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$maddSeenOtpNotificationKey, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m304$$Nest$maddSeenOtpNotificationKey(MediaProjectionSession r0, String r1) {
            r0.addSeenOtpNotificationKey(r1);
        }

        MediaProjectionSession(int uid, boolean isExempted, long sessionId) {
            this.mAllSeenNotificationKeys = new ArraySet();
            this.mSeenOtpNotificationKeys = new ArraySet();
            this.mUid = uid;
            this.mIsExempted = isExempted;
            this.mSessionId = sessionId;
        }

        public void logProjectionSessionStart() {
            FrameworkStatsLog.write(FrameworkStatsLog.SENSITIVE_CONTENT_MEDIA_PROJECTION_SESSION, this.mSessionId, this.mUid, this.mIsExempted, 1, 2);
        }

        public void logProjectionSessionStop() {
            FrameworkStatsLog.write(FrameworkStatsLog.SENSITIVE_CONTENT_MEDIA_PROJECTION_SESSION, this.mSessionId, this.mUid, this.mIsExempted, 2, 2);
        }

        public void logAppNotificationsProtected() {
            FrameworkStatsLog.write(FrameworkStatsLog.SENSITIVE_NOTIFICATION_APP_PROTECTION_SESSION, this.mSessionId, this.mAllSeenNotificationKeys.size(), this.mSeenOtpNotificationKeys.size());
        }

        public void logAppBlocked(int uid) {
            FrameworkStatsLog.write(FrameworkStatsLog.SENSITIVE_CONTENT_APP_PROTECTION, this.mSessionId, uid, this.mUid, 1);
        }

        public void logAppUnblocked(int uid) {
            FrameworkStatsLog.write(FrameworkStatsLog.SENSITIVE_CONTENT_APP_PROTECTION, this.mSessionId, uid, this.mUid, 2);
        }

        private void addSeenNotificationKey(String key) {
            this.mAllSeenNotificationKeys.add(key);
        }

        private void addSeenOtpNotificationKey(String key) {
            this.mAllSeenNotificationKeys.add(key);
            this.mSeenOtpNotificationKeys.add(key);
        }

        public void addSeenNotifications(StatusBarNotification[] notifications, NotificationListenerService.RankingMap rankingMap) {
            int r0 = notifications.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L12;
            StatusBarNotification sbn = notifications[r1];
            if (sbn != null) goto L8;
            Log.w(SensitiveContentProtectionManagerService.TAG, "Unable to parse null notification");
        L11:
            r1 = r1 + 1;
            goto L3
        L8:
            if (SensitiveContentProtectionManagerService.m301$$Nest$smnotificationHasSensitiveContent(sbn, rankingMap) == false) goto L10;
            addSeenOtpNotificationKey(sbn.getKey());
            goto L11
        L10:
            addSeenNotificationKey(sbn.getKey());
            goto L11
        }
    }

    class NotificationListener extends NotificationListenerService {
        final /* synthetic */ SensitiveContentProtectionManagerService this$0;

        NotificationListener(SensitiveContentProtectionManagerService this$0) {
            this.this$0 = this$0;
        }

        @Override // android.service.notification.NotificationListenerService
        public void onListenerConnected() {
            super.onListenerConnected();
            Trace.traceBegin(524288, "SensitiveContentProtectionManagerService.onListenerConnected");
            Object r0 = this.this$0.mSensitiveContentProtectionLock;     // Catch: Throwable -> L15
            monitor-enter(r0);     // Catch: Throwable -> L15
        L8:
            th = move-exception;
            throw th;     // Catch: Throwable -> L15
        L6:
            if (SensitiveContentProtectionManagerService.m294$$Nest$fgetmProjectionActive(this.this$0) == false) goto L10;
            SensitiveContentProtectionManagerService.m298$$Nest$mupdateAppsThatShouldBlockScreenCapture(this.this$0);     // Catch: Throwable -> L8
        L10:
            monitor-exit(r0);     // Catch: Throwable -> L8
            Trace.traceEnd(524288);
            return;
        L15:
            th = move-exception;
            Trace.traceEnd(524288);
            throw th;
        }

        @Override // android.service.notification.NotificationListenerService
        public void onNotificationPosted(StatusBarNotification sbn, NotificationListenerService.RankingMap rankingMap) {
            super.onNotificationPosted(sbn, rankingMap);
            Trace.traceBegin(524288, "SensitiveContentProtectionManagerService.onNotificationPosted");
            if (sbn != null) goto L9;
            Log.w(SensitiveContentProtectionManagerService.TAG, "Unable to parse null notification");     // Catch: Throwable -> L7
            Trace.traceEnd(524288);
            return;
        L9:
            if (rankingMap != null) goto L13;
            Log.w(SensitiveContentProtectionManagerService.TAG, "Ranking map not initialized.");     // Catch: Throwable -> L7
            Trace.traceEnd(524288);
            return;
        L13:
            Object r0 = this.this$0.mSensitiveContentProtectionLock;     // Catch: Throwable -> L7
            monitor-enter(r0);     // Catch: Throwable -> L7
        L20:
            th = move-exception;
            throw th;     // Catch: Throwable -> L7
        L16:
            if (SensitiveContentProtectionManagerService.m294$$Nest$fgetmProjectionActive(this.this$0) == true) goto L22;
            monitor-exit(r0);     // Catch: Throwable -> L20
            Trace.traceEnd(524288);
            return;
        L22:
            SensitiveContentPackages.PackageInfo packageInfo = SensitiveContentProtectionManagerService.m300$$Nest$smgetSensitivePackageFromNotification(sbn, rankingMap);     // Catch: Throwable -> L20
            if (packageInfo == null) goto L26;
            SensitiveContentProtectionManagerService.m295$$Nest$fgetmWindowManager(this.this$0).addBlockScreenCaptureForApps(new ArraySet(Set.of(packageInfo)));     // Catch: Throwable -> L20
        L26:
            if (SensitiveContentProtectionManagerService.m292$$Nest$fgetmMediaProjectionSession(this.this$0) == null) goto L30;
            if (packageInfo == null) goto L29;
            MediaProjectionSession.m304$$Nest$maddSeenOtpNotificationKey(SensitiveContentProtectionManagerService.m292$$Nest$fgetmMediaProjectionSession(this.this$0), sbn.getKey());     // Catch: Throwable -> L20
            goto L30
        L29:
            MediaProjectionSession.m303$$Nest$maddSeenNotificationKey(SensitiveContentProtectionManagerService.m292$$Nest$fgetmMediaProjectionSession(this.this$0), sbn.getKey());     // Catch: Throwable -> L20
        L30:
            monitor-exit(r0);     // Catch: Throwable -> L20
            Trace.traceEnd(524288);
            return;
        L7:
            th = move-exception;
            Trace.traceEnd(524288);
            throw th;
        }

        @Override // android.service.notification.NotificationListenerService
        public void onNotificationRankingUpdate(NotificationListenerService.RankingMap rankingMap) {
            super.onNotificationRankingUpdate(rankingMap);
            Trace.traceBegin(524288, "SensitiveContentProtectionManagerService.onNotificationRankingUpdate");
            if (rankingMap != null) goto L9;
            Log.w(SensitiveContentProtectionManagerService.TAG, "Ranking map not initialized.");     // Catch: Throwable -> L7
            Trace.traceEnd(524288);
            return;
        L9:
            Object r0 = this.this$0.mSensitiveContentProtectionLock;     // Catch: Throwable -> L7
            monitor-enter(r0);     // Catch: Throwable -> L7
        L14:
            th = move-exception;
            throw th;     // Catch: Throwable -> L7
        L12:
            if (SensitiveContentProtectionManagerService.m294$$Nest$fgetmProjectionActive(this.this$0) == false) goto L16;
            SensitiveContentProtectionManagerService.m299$$Nest$mupdateAppsThatShouldBlockScreenCapture(this.this$0, rankingMap);     // Catch: Throwable -> L14
        L16:
            monitor-exit(r0);     // Catch: Throwable -> L14
            Trace.traceEnd(524288);
            return;
        L7:
            th = move-exception;
            Trace.traceEnd(524288);
            throw th;
        }
    }

    private final class SensitiveContentProtectionManagerServiceBinder extends ISensitiveContentProtectionManager.Stub {
        final /* synthetic */ SensitiveContentProtectionManagerService this$0;

        /* synthetic */ SensitiveContentProtectionManagerServiceBinder(SensitiveContentProtectionManagerService r1, SensitiveContentProtectionManagerServiceIA r2) {
            this(r1);
        }

        private SensitiveContentProtectionManagerServiceBinder(SensitiveContentProtectionManagerService r1) {
            this.this$0 = r1;
        }

        public void setSensitiveContentProtection(IBinder windowToken, String packageName, boolean isShowingSensitiveContent) {
            Trace.traceBegin(524288, "SensitiveContentProtectionManagerService.setSensitiveContentProtection");
            int callingUid = Binder.getCallingUid();     // Catch: Throwable -> L11
            verifyCallingPackage(callingUid, packageName);     // Catch: Throwable -> L11
            long identity = Binder.clearCallingIdentity();     // Catch: Throwable -> L11
            if (isShowingSensitiveContent == true) goto L24;
        L15:
            this.this$0.setSensitiveContentProtection(windowToken, packageName, callingUid, isShowingSensitiveContent);     // Catch: Throwable -> L13
            Binder.restoreCallingIdentity(identity);     // Catch: Throwable -> L11
            Trace.traceEnd(524288);
            return;
        L24:
        L13:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);     // Catch: Throwable -> L11
            throw th;     // Catch: Throwable -> L11
        L6:
            if (SensitiveContentProtectionManagerService.m295$$Nest$fgetmWindowManager(this.this$0).getWindowName(windowToken) != null) goto L15;
            Log.e(SensitiveContentProtectionManagerService.TAG, "window token is not know to WMS, can't apply protection, token: " + windowToken + ", package: " + packageName);     // Catch: Throwable -> L13
            Binder.restoreCallingIdentity(identity);     // Catch: Throwable -> L11
            Trace.traceEnd(524288);
            return;
        L11:
            th = move-exception;
            Trace.traceEnd(524288);
            throw th;
        }

        private void verifyCallingPackage(int callingUid, String callingPackage) {
            if (SensitiveContentProtectionManagerService.m293$$Nest$fgetmPackageManagerInternal(this.this$0).getPackageUid(callingPackage, 0, UserHandle.getUserId(callingUid)) != callingUid) goto L6;
            return;
        L6:
            throw new SecurityException("Specified calling package [" + callingPackage + "] does not match the calling uid " + callingUid);
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$4YLG2ce-94hTLyHe6tb2T8hdSPg, reason: not valid java name */
    public static /* synthetic */ boolean m291$r8$lambda$4YLG2ce94hTLyHe6tb2T8hdSPg(IBinder r0, SensitiveContentPackages.PackageInfo r1) {
        return lambda$new$0(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$QjFN8_LtyPXP93F9fuhOTSfZons(SensitiveContentProtectionManagerService r0, IBinder r1) {
        r0.lambda$new$1(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmMediaProjectionSession, reason: not valid java name */
    static /* bridge */ /* synthetic */ MediaProjectionSession m292$$Nest$fgetmMediaProjectionSession(SensitiveContentProtectionManagerService r0) {
        return r0.mMediaProjectionSession;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPackageManagerInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ PackageManagerInternal m293$$Nest$fgetmPackageManagerInternal(SensitiveContentProtectionManagerService r0) {
        return r0.mPackageManagerInternal;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmProjectionActive, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m294$$Nest$fgetmProjectionActive(SensitiveContentProtectionManagerService r0) {
        return r0.mProjectionActive;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmWindowManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ WindowManagerInternal m295$$Nest$fgetmWindowManager(SensitiveContentProtectionManagerService r0) {
        return r0.mWindowManager;
    }

    /* JADX INFO: renamed from: -$$Nest$monProjectionEnd, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m296$$Nest$monProjectionEnd(SensitiveContentProtectionManagerService r0) {
        r0.onProjectionEnd();
    }

    /* JADX INFO: renamed from: -$$Nest$monProjectionStart, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m297$$Nest$monProjectionStart(SensitiveContentProtectionManagerService r0, MediaProjectionInfo r1) {
        r0.onProjectionStart(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateAppsThatShouldBlockScreenCapture, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m298$$Nest$mupdateAppsThatShouldBlockScreenCapture(SensitiveContentProtectionManagerService r0) {
        r0.updateAppsThatShouldBlockScreenCapture();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateAppsThatShouldBlockScreenCapture, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m299$$Nest$mupdateAppsThatShouldBlockScreenCapture(SensitiveContentProtectionManagerService r0, NotificationListenerService.RankingMap r1) {
        r0.updateAppsThatShouldBlockScreenCapture(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$smgetSensitivePackageFromNotification, reason: not valid java name */
    static /* bridge */ /* synthetic */ SensitiveContentPackages.PackageInfo m300$$Nest$smgetSensitivePackageFromNotification(StatusBarNotification r0, NotificationListenerService.RankingMap r1) {
        return getSensitivePackageFromNotification(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$smnotificationHasSensitiveContent, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m301$$Nest$smnotificationHasSensitiveContent(StatusBarNotification r0, NotificationListenerService.RankingMap r1) {
        return notificationHasSensitiveContent(r0, r1);
    }

    private /* synthetic */ void lambda$new$1(final IBinder token) {
        Object r0 = this.mSensitiveContentProtectionLock;
        monitor-enter(r0);
        this.mPackagesShowingSensitiveContent.removeIf(new SensitiveContentProtectionManagerService$$ExternalSyntheticLambda1(token));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ boolean lambda$new$0(IBinder token, SensitiveContentPackages.PackageInfo pkgInfo) {
        if (pkgInfo.getWindowToken() != token) goto L5;
        return true;
    L5:
        return false;
    }

    public SensitiveContentProtectionManagerService(Context context) {
        super(context);
        this.mExemptedPackages = null;
        this.mSensitiveContentProtectionLock = new Object();
        this.mPackagesShowingSensitiveContent = new ArraySet();
        this.mProjectionActive = false;
        this.mProjectionCallback = new AnonymousClass1(this);
        this.mOnWindowRemovedListener = new SensitiveContentProtectionManagerService$$ExternalSyntheticLambda0(this);
        this.mNotificationListener = new NotificationListener(this);
    }

    @Override // com.android.server.SystemService
    public void onStart() {
    }

    @Override // com.android.server.SystemService
    public void onBootPhase(int phase) {
        if (phase == 1000) goto L5;
        return;
    L5:
        init((MediaProjectionManager) getContext().getSystemService(MediaProjectionManager.class), (WindowManagerInternal) LocalServices.getService(WindowManagerInternal.class), (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class), (RoleManager) getContext().getSystemService(RoleManager.class), getExemptedPackages());
        publishBinderService("sensitive_content_protection_service", new SensitiveContentProtectionManagerServiceBinder(this, null));
    }

    void init(MediaProjectionManager projectionManager, WindowManagerInternal windowManager, PackageManagerInternal packageManagerInternal, RoleManager roleManager, ArraySet<String> exemptedPackages) {
        projectionManager.getClass();
        windowManager.getClass();
        this.mProjectionManager = projectionManager;
        this.mWindowManager = windowManager;
        this.mPackageManagerInternal = packageManagerInternal;
        this.mRoleManager = roleManager;
        this.mExemptedPackages = exemptedPackages;
        this.mProjectionManager.addCallback(this.mProjectionCallback, getContext().getMainThreadHandler());
        this.mNotificationListener.registerAsSystemService(getContext(), new ComponentName(getContext(), NotificationListener.class), -1);     // Catch: RemoteException -> L5
    L6:
        this.mWindowManager.registerOnWindowRemovedListener(this.mOnWindowRemovedListener);
    }

    void onDestroy() {
        if (this.mProjectionManager == null) goto L13;
        this.mProjectionManager.removeCallback(this.mProjectionCallback);
    L13:
        this.mNotificationListener.unregisterAsSystemService();     // Catch: RemoteException -> L8
    L10:
        if (this.mWindowManager == null) goto L15;
        onProjectionEnd();
        return;
    }

    private boolean canRecordSensitiveContent(String packageName) {
        if (getContext().getPackageManager().checkPermission("android.permission.RECORD_SENSITIVE_CONTENT", packageName) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    private ArraySet<String> getExemptedPackages() {
        return SystemConfig.getInstance().getBugreportWhitelistedPackages();
    }

    private void onProjectionStart(MediaProjectionInfo projectionInfo) {
        boolean r2 = false;
        if (this.mExemptedPackages == null) goto L7;
        if (this.mExemptedPackages.contains(projectionInfo.getPackageName()) == false) goto L7;
    L14:
        boolean isPackageExempted = true;
    L16:
        if (Settings.Global.getInt(getContext().getContentResolver(), "disable_screen_share_protections_for_apps_and_notifications", 0) == 0) goto L18;
        boolean isFeatureDisabled = true;
    L19:
        int uid = this.mPackageManagerInternal.getPackageUid(projectionInfo.getPackageName(), 0, projectionInfo.getUserHandle().getIdentifier());
        Object r5 = this.mSensitiveContentProtectionLock;
        monitor-enter(r5);
    L32:
        th = move-exception;
        throw th;
    L22:
        if (isPackageExempted == true) goto L24;
        if (isFeatureDisabled == true) goto L24;
    L25:
        this.mMediaProjectionSession = new MediaProjectionSession(uid, r2, new Random().nextLong());     // Catch: Throwable -> L32
        this.mMediaProjectionSession.logProjectionSessionStart();     // Catch: Throwable -> L32
        if (isPackageExempted == true) goto L36;
        if (isFeatureDisabled == true) goto L36;
        this.mProjectionActive = true;     // Catch: Throwable -> L32
        this.mWindowManager.setBlockScreenCaptureForAppsSessionId(MediaProjectionSession.m302$$Nest$fgetmSessionId(this.mMediaProjectionSession));     // Catch: Throwable -> L32
        updateAppsThatShouldBlockScreenCapture();     // Catch: Throwable -> L32
        if (this.mPackagesShowingSensitiveContent.size() <= 0) goto L34;
        this.mWindowManager.addBlockScreenCaptureForApps(this.mPackagesShowingSensitiveContent);     // Catch: Throwable -> L32
    L34:
        monitor-exit(r5);     // Catch: Throwable -> L32
        return;
    L36:
        Log.w(TAG, "projection session is exempted, package =" + projectionInfo.getPackageName() + ", isFeatureDisabled=" + isFeatureDisabled);     // Catch: Throwable -> L32
        monitor-exit(r5);     // Catch: Throwable -> L32
        return;
    L24:
        r2 = true;
        goto L25
    L18:
        isFeatureDisabled = false;
    L7:
        if (canRecordSensitiveContent(projectionInfo.getPackageName()) == true) goto L14;
        if (holdsAppStreamingRole(projectionInfo.getPackageName(), projectionInfo.getUserHandle()) == true) goto L14;
        if (isAutofillServiceRecorderPackage(projectionInfo.getUserHandle().getIdentifier(), projectionInfo.getPackageName()) == true) goto L14;
        isPackageExempted = false;
        goto L16
    }

    private boolean holdsAppStreamingRole(String packageName, UserHandle userHandle) {
        return this.mRoleManager.getRoleHoldersAsUser("android.app.role.COMPANION_DEVICE_APP_STREAMING", userHandle).contains(packageName);
    }

    private void onProjectionEnd() {
        Object r0 = this.mSensitiveContentProtectionLock;
        monitor-enter(r0);
        this.mProjectionActive = false;     // Catch: Throwable -> L8
        if (this.mMediaProjectionSession == null) goto L10;
        this.mMediaProjectionSession.logProjectionSessionStop();     // Catch: Throwable -> L8
        this.mMediaProjectionSession.logAppNotificationsProtected();     // Catch: Throwable -> L8
        this.mMediaProjectionSession = null;     // Catch: Throwable -> L8
    L10:
        this.mWindowManager.clearBlockedApps();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private void updateAppsThatShouldBlockScreenCapture() {
        NotificationListenerService.RankingMap rankingMap = this.mNotificationListener.getCurrentRanking();     // Catch: SecurityException -> L5
    L7:
        if (rankingMap != null) goto L10;
        Log.w(TAG, "Ranking map not initialized.");
        return;
    L10:
        updateAppsThatShouldBlockScreenCapture(rankingMap);
        return;
    L5:
        e = move-exception;
        Log.e(TAG, "SensitiveContentProtectionManagerService doesn't have access.", e);
        rankingMap = null;
        goto L7
    }

    private void updateAppsThatShouldBlockScreenCapture(NotificationListenerService.RankingMap rankingMap) {
        StatusBarNotification[] notifications = this.mNotificationListener.getActiveNotifications();     // Catch: SecurityException -> L4
    L7:
        if (this.mMediaProjectionSession == null) goto L9;
        this.mMediaProjectionSession.addSeenNotifications(notifications, rankingMap);
    L9:
        ArraySet<SensitiveContentPackages.PackageInfo> packageInfos = getSensitivePackagesFromNotifications(notifications, rankingMap);
        if (packageInfos.size() <= 0) goto L15;
        this.mWindowManager.addBlockScreenCaptureForApps(packageInfos);
        return;
    L15:
        return;
    L4:
        e = move-exception;
        Log.e(TAG, "SensitiveContentProtectionManagerService doesn't have access.", e);
        notifications = new StatusBarNotification[0];
        goto L7
    }

    private static ArraySet<SensitiveContentPackages.PackageInfo> getSensitivePackagesFromNotifications(StatusBarNotification[] notifications, NotificationListenerService.RankingMap rankingMap) {
        ArraySet<SensitiveContentPackages.PackageInfo> sensitivePackages = new ArraySet();
        int r1 = notifications.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L11;
        StatusBarNotification sbn = notifications[r2];
        if (sbn != null) goto L7;
        Log.w(TAG, "Unable to parse null notification");
    L10:
        r2 = r2 + 1;
        goto L3
    L7:
        SensitiveContentPackages.PackageInfo info = getSensitivePackageFromNotification(sbn, rankingMap);
        if (info == null) goto L10;
        sensitivePackages.add(info);
        goto L10
    L11:
        return sensitivePackages;
    }

    private static SensitiveContentPackages.PackageInfo getSensitivePackageFromNotification(StatusBarNotification sbn, NotificationListenerService.RankingMap rankingMap) {
        if (notificationHasSensitiveContent(sbn, rankingMap) == true) goto L5;
        return null;
    L5:
        return new SensitiveContentPackages.PackageInfo(sbn.getPackageName(), sbn.getUid());
    }

    private static boolean notificationHasSensitiveContent(StatusBarNotification sbn, NotificationListenerService.RankingMap rankingMap) {
        NotificationListenerService.Ranking ranking = rankingMap.getRawRankingObject(sbn.getKey());
        if (ranking != null) goto L5;
    L7:
        return false;
    L5:
        if (ranking.hasSensitiveContent() == false) goto L7;
        return true;
    }

    void setSensitiveContentProtection(IBinder windowToken, String packageName, int uid, boolean isShowingSensitiveContent) {
        Object r0 = this.mSensitiveContentProtectionLock;
        monitor-enter(r0);
        SensitiveContentPackages.PackageInfo packageInfo = new SensitiveContentPackages.PackageInfo(packageName, uid, windowToken);     // Catch: Throwable -> L9
        if (isShowingSensitiveContent == false) goto L11;
        this.mPackagesShowingSensitiveContent.add(packageInfo);     // Catch: Throwable -> L9
        if (this.mPackagesShowingSensitiveContent.size() <= 100) goto L13;
        Log.w(TAG, "Unexpectedly large number of sensitive windows, count: " + this.mPackagesShowingSensitiveContent.size());     // Catch: Throwable -> L9
    L13:
        if (this.mProjectionActive == true) goto L16;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L16:
        ArraySet<SensitiveContentPackages.PackageInfo> packageInfos = new ArraySet();     // Catch: Throwable -> L9
        packageInfos.add(packageInfo);     // Catch: Throwable -> L9
        if (isShowingSensitiveContent == false) goto L21;
        this.mWindowManager.addBlockScreenCaptureForApps(packageInfos);     // Catch: Throwable -> L9
        if (this.mMediaProjectionSession == null) goto L24;
        this.mMediaProjectionSession.logAppBlocked(uid);     // Catch: Throwable -> L9
    L24:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L21:
        this.mWindowManager.removeBlockScreenCaptureForApps(packageInfos);     // Catch: Throwable -> L9
        if (this.mMediaProjectionSession == null) goto L24;
        this.mMediaProjectionSession.logAppUnblocked(uid);     // Catch: Throwable -> L9
        goto L24
    L11:
        this.mPackagesShowingSensitiveContent.remove(packageInfo);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    private boolean isAutofillServiceRecorderPackage(int userId, String projectionPackage) {
        String autofillServiceName = Settings.Secure.getStringForUser(getContext().getContentResolver(), "autofill_service", userId);
        if (autofillServiceName != null) goto L5;
        return false;
    L5:
        ComponentName serviceComponent = ComponentName.unflattenFromString(autofillServiceName);
        if (serviceComponent != null) goto L8;
        return false;
    L8:
        String autofillServicePackage = serviceComponent.getPackageName();
        if (autofillServicePackage != null) goto L11;
        return false;
    L11:
        if (autofillServicePackage.equals(projectionPackage) == false) goto L16;
        return true;
    L16:
        return false;
    }
}
