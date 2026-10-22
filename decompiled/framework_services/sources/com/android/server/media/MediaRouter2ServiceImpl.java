package com.android.server.media;

import android.app.ActivityManager;
import android.app.AppOpsManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.PermissionChecker;
import android.content.pm.PackageManager;
import android.media.IMediaRouter2;
import android.media.IMediaRouter2Manager;
import android.media.MediaRoute2Info;
import android.media.MediaRoute2ProviderInfo;
import android.media.MediaRouter2Utils;
import android.media.RouteDiscoveryPreference;
import android.media.RouteListingPreference;
import android.media.RoutingSessionInfo;
import android.media.SuggestedDeviceInfo;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.PowerManager;
import android.os.RemoteException;
import android.os.UserHandle;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import android.util.Slog;
import android.util.SparseArray;
import com.android.internal.util.function.pooled.PooledLambda;
import com.android.server.LocalServices;
import com.android.server.pm.UserManagerInternal;
import com.android.server.statusbar.StatusBarManagerInternal;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/* JADX INFO: loaded from: classes2.dex */
class MediaRouter2ServiceImpl {
    private static final String[] BLUETOOTH_PERMISSIONS_FOR_SYSTEM_ROUTING = null;
    private static final boolean DEBUG = false;
    private static final long DUMMY_REQUEST_ID = -1;
    private static final int REQUIRED_PACKAGE_IMPORTANCE_FOR_SCANNING = 100;
    private static final String TAG = "MR2ServiceImpl";
    private static final MediaRouterMetricLogger mMediaRouterMetricLogger = null;
    final ActivityManager mActivityManager;
    private final ArrayMap<IBinder, ManagerRecord> mAllManagerRecords;
    private final ArrayMap<IBinder, RouterRecord> mAllRouterRecords;
    private final AppOpsManager mAppOpsManager;
    private final Context mContext;
    private int mCurrentActiveUserId;
    private final IMediaRouterServiceExt mExt;
    private final Object mLock;
    private final Looper mLooper;
    final AtomicInteger mNextRouterOrManagerId;
    private final AppOpsManager.OnOpChangedListener mOnOpChangedListener;
    private final ActivityManager.OnUidImportanceListener mOnUidImportanceListener;
    final PowerManager mPowerManager;
    private final BroadcastReceiver mScreenOnOffReceiver;
    private final StatusBarManagerInternal mStatusBarManagerInternal;
    private final UserManagerInternal mUserManagerInternal;
    private final SparseArray<UserRecord> mUserRecords;

    /* JADX INFO: renamed from: com.android.server.media.MediaRouter2ServiceImpl$1, reason: invalid class name */
    class AnonymousClass1 extends BroadcastReceiver {
        final /* synthetic */ MediaRouter2ServiceImpl this$0;

        public static /* synthetic */ void $r8$lambda$qAWYHpsEJf192Tfv_KOCmVmOo6k(UserHandler r0) {
            UserHandler.m5602$$Nest$mupdateDiscoveryPreferenceOnHandler(r0);
        }

        AnonymousClass1(MediaRouter2ServiceImpl this$0) {
            this.this$0 = this$0;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Object r0 = MediaRouter2ServiceImpl.m5573$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            int count = MediaRouter2ServiceImpl.m5574$$Nest$fgetmUserRecords(this.this$0).size();     // Catch: Throwable -> L7
            int i = 0;
        L5:
            if (i >= count) goto L10;
            UserHandler userHandler = ((UserRecord) MediaRouter2ServiceImpl.m5574$$Nest$fgetmUserRecords(this.this$0).valueAt(i)).mHandler;     // Catch: Throwable -> L7
            userHandler.sendMessage(PooledLambda.obtainMessage(new MediaRouter2ServiceImpl$1$$ExternalSyntheticLambda0(), userHandler));     // Catch: Throwable -> L7
            i = i + 1;     // Catch: Throwable -> L7
            goto L5
        L10:
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    final class ManagerRecord implements IBinder.DeathRecipient {
        public final boolean mHasMediaContentControl;
        public final boolean mHasMediaRoutingControl;
        public SessionCreationRequest mLastSessionCreationRequest;
        public final IMediaRouter2Manager mManager;
        public final int mManagerId;
        public final String mOwnerPackageName;
        public final int mOwnerPid;
        public final int mOwnerUid;
        public int mScanningState;
        public final String mTargetPackageName;
        public final UserRecord mUserRecord;
        final /* synthetic */ MediaRouter2ServiceImpl this$0;

        public static /* synthetic */ void $r8$lambda$qAWYHpsEJf192Tfv_KOCmVmOo6k(UserHandler r0) {
            UserHandler.m5602$$Nest$mupdateDiscoveryPreferenceOnHandler(r0);
        }

        /* JADX INFO: renamed from: -$$Nest$mlogRemoteException, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m5579$$Nest$mlogRemoteException(ManagerRecord r0, String r1, RemoteException r2) {
            r0.logRemoteException(r1, r2);
        }

        /* JADX INFO: renamed from: -$$Nest$mupdateScanningState, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m5580$$Nest$mupdateScanningState(ManagerRecord r0, int r1) {
            r0.updateScanningState(r1);
        }

        ManagerRecord(MediaRouter2ServiceImpl this$0, UserRecord userRecord, IMediaRouter2Manager manager, int ownerUid, int ownerPid, String ownerPackageName, String targetPackageName, boolean hasMediaRoutingControl, boolean hasMediaContentControl) {
            this.this$0 = this$0;
            this.mScanningState = 0;
            this.mUserRecord = userRecord;
            this.mManager = manager;
            this.mOwnerUid = ownerUid;
            this.mOwnerPid = ownerPid;
            this.mOwnerPackageName = ownerPackageName;
            this.mTargetPackageName = targetPackageName;
            this.mManagerId = this$0.mNextRouterOrManagerId.getAndIncrement();
            this.mHasMediaRoutingControl = hasMediaRoutingControl;
            this.mHasMediaContentControl = hasMediaContentControl;
        }

        public void dispose() {
            this.mManager.asBinder().unlinkToDeath(this, 0);
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            this.this$0.managerDied(this);
        }

        public void dump(PrintWriter pw, String prefix) {
            pw.println(prefix + "ManagerRecord");
            String indent = prefix + "  ";
            pw.println(indent + "mOwnerPackageName=" + this.mOwnerPackageName);
            pw.println(indent + "mTargetPackageName=" + this.mTargetPackageName);
            pw.println(indent + "mManagerId=" + this.mManagerId);
            pw.println(indent + "mOwnerUid=" + this.mOwnerUid);
            pw.println(indent + "mOwnerPid=" + this.mOwnerPid);
            pw.println(indent + "mScanningState=" + MediaRouter2ServiceImpl.m5578$$Nest$smgetScanningStateString(this.mScanningState));
            if (this.mLastSessionCreationRequest == null) goto L6;
            this.mLastSessionCreationRequest.dump(pw, indent);
            return;
        }

        public void notifyRequestFailed(int requestId, int reason) {
            this.mManager.notifyRequestFailed(requestId, reason);     // Catch: RemoteException -> L4
            return;
        L4:
            ex = move-exception;
            logRemoteException("notifyRequestFailed", ex);
        }

        public void notifyRoutesUpdated(List<MediaRoute2Info> routes) {
            this.mManager.notifyRoutesUpdated(routes);     // Catch: RemoteException -> L4
            return;
        L4:
            ex = move-exception;
            logRemoteException("notifyRoutesUpdated", ex);
        }

        public void notifySessionUpdated(RoutingSessionInfo sessionInfo) {
            this.mManager.notifySessionUpdated(sessionInfo);     // Catch: RemoteException -> L4
            return;
        L4:
            ex = move-exception;
            logRemoteException("notifySessionUpdated", ex);
        }

        public void notifySessionReleased(RoutingSessionInfo sessionInfo) {
            this.mManager.notifySessionReleased(sessionInfo);     // Catch: RemoteException -> L4
            return;
        L4:
            ex = move-exception;
            logRemoteException("notifySessionReleased", ex);
        }

        private void logRemoteException(String operation, RemoteException exception) {
            String message = TextUtils.formatSimple("%s failed for %s due to %s", new Object[]{operation, getDebugString(), exception.toString()});
            Slog.w(MediaRouter2ServiceImpl.TAG, message);
        }

        private void updateScanningState(int scanningState) {
            if (this.mScanningState != scanningState) goto L5;
            return;
        L5:
            this.mScanningState = scanningState;
            this.mUserRecord.mHandler.sendMessage(PooledLambda.obtainMessage(new MediaRouter2ServiceImpl$ManagerRecord$$ExternalSyntheticLambda0(), this.mUserRecord.mHandler));
        }

        public String getDebugString() {
            return TextUtils.formatSimple("Manager %s (id=%d,pid=%d,userId=%d,uid=%d,targetPkg=%s)", new Object[]{this.mOwnerPackageName, Integer.valueOf(this.mManagerId), Integer.valueOf(this.mOwnerPid), Integer.valueOf(this.mUserRecord.mUserId), Integer.valueOf(this.mOwnerUid), this.mTargetPackageName});
        }
    }

    final class RouterRecord implements IBinder.DeathRecipient {
        public final Context mContext;
        public RouteDiscoveryPreference mDiscoveryPreference;
        public final AtomicBoolean mHasBluetoothRoutingPermission;
        public final boolean mHasConfigureWifiDisplayPermission;
        public final boolean mHasMediaContentControlPermission;
        public final boolean mHasMediaRoutingControl;
        public final boolean mHasModifyAudioRoutingPermission;
        public final String mPackageName;
        public final int mPid;
        public RouteListingPreference mRouteListingPreference;
        public final IMediaRouter2 mRouter;
        public final int mRouterId;
        public int mScanningState;
        public final List<Integer> mSelectRouteSequenceNumbers;
        public final int mUid;
        public final UserRecord mUserRecord;
        final /* synthetic */ MediaRouter2ServiceImpl this$0;

        public static /* synthetic */ void $r8$lambda$qAWYHpsEJf192Tfv_KOCmVmOo6k(UserHandler r0) {
            UserHandler.m5602$$Nest$mupdateDiscoveryPreferenceOnHandler(r0);
        }

        RouterRecord(MediaRouter2ServiceImpl this$0, Context context, UserRecord userRecord, IMediaRouter2 router, int uid, int pid, String packageName, boolean hasConfigureWifiDisplayPermission, boolean hasModifyAudioRoutingPermission, boolean hasMediaContentControlPermission, boolean hasMediaRoutingControl) {
            this.this$0 = this$0;
            this.mScanningState = 0;
            this.mContext = context;
            this.mUserRecord = userRecord;
            this.mPackageName = packageName;
            this.mSelectRouteSequenceNumbers = new ArrayList();
            this.mDiscoveryPreference = RouteDiscoveryPreference.EMPTY;
            this.mRouter = router;
            this.mUid = uid;
            this.mPid = pid;
            this.mHasConfigureWifiDisplayPermission = hasConfigureWifiDisplayPermission;
            this.mHasModifyAudioRoutingPermission = hasModifyAudioRoutingPermission;
            this.mHasMediaContentControlPermission = hasMediaContentControlPermission;
            this.mHasMediaRoutingControl = hasMediaRoutingControl;
            this.mHasBluetoothRoutingPermission = new AtomicBoolean(MediaRouter2ServiceImpl.m5575$$Nest$mcheckCallerHasBluetoothPermissions(this$0, this.mPid, this.mUid));
            this.mRouterId = this$0.mNextRouterOrManagerId.getAndIncrement();
        }

        public boolean hasSystemRoutingPermission() {
            if (this.mHasModifyAudioRoutingPermission == false) goto L5;
        L8:
            return true;
        L5:
            if (this.mHasBluetoothRoutingPermission.get() == true) goto L8;
            return false;
        }

        public boolean isActivelyScanning() {
            if (this.mScanningState != 1) goto L5;
            return true;
        L5:
            if (this.mScanningState != 2) goto L7;
            return true;
        L7:
            if (this.mDiscoveryPreference.shouldPerformActiveScan() == true) goto L14;
            return false;
        L14:
            return true;
        }

        public void maybeUpdateSystemRoutingPermissionLocked() {
            boolean oldSystemRoutingPermissionValue = hasSystemRoutingPermission();
            this.mHasBluetoothRoutingPermission.set(MediaRouter2ServiceImpl.m5575$$Nest$mcheckCallerHasBluetoothPermissions(this.this$0, this.mPid, this.mUid));
            boolean newSystemRoutingPermissionValue = hasSystemRoutingPermission();
            if (oldSystemRoutingPermissionValue == newSystemRoutingPermissionValue) goto L15;
            if (newSystemRoutingPermissionValue == false) goto L6;
            Map<String, MediaRoute2Info> routesToReport = UserHandler.m5585$$Nest$fgetmLastNotifiedRoutesToPrivilegedRouters(this.mUserRecord.mHandler);
        L7:
            notifyRoutesUpdated(routesToReport.values().stream().toList());
            List<RoutingSessionInfo> sessionInfos = UserHandler.m5588$$Nest$mgetSystemProvider(this.mUserRecord.mHandler).getSessionInfos();
            if (newSystemRoutingPermissionValue == true) goto L10;
        L12:
            RoutingSessionInfo systemSessionToReport = UserHandler.m5588$$Nest$mgetSystemProvider(this.mUserRecord.mHandler).getDefaultSessionInfo();
        L13:
            notifySessionInfoChanged(systemSessionToReport);
            return;
        L10:
            if (sessionInfos.isEmpty() == true) goto L12;
            systemSessionToReport = sessionInfos.get(0);
            goto L13
        L6:
            routesToReport = UserHandler.m5584$$Nest$fgetmLastNotifiedRoutesToNonPrivilegedRouters(this.mUserRecord.mHandler);
            goto L7
        }

        public void dispose() {
            this.mRouter.asBinder().unlinkToDeath(this, 0);
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            this.this$0.routerDied(this);
        }

        public void updateScanningState(int scanningState) {
            if (this.mScanningState != scanningState) goto L5;
            return;
        L5:
            this.mScanningState = scanningState;
            this.mUserRecord.mHandler.sendMessage(PooledLambda.obtainMessage(new MediaRouter2ServiceImpl$RouterRecord$$ExternalSyntheticLambda0(), this.mUserRecord.mHandler));
        }

        public void dump(PrintWriter pw, String prefix) {
            pw.println(prefix + "RouterRecord");
            String indent = prefix + "  ";
            pw.println(indent + "mPackageName=" + this.mPackageName);
            pw.println(indent + "mSelectRouteSequenceNumbers=" + this.mSelectRouteSequenceNumbers);
            pw.println(indent + "mUid=" + this.mUid);
            pw.println(indent + "mPid=" + this.mPid);
            pw.println(indent + "mHasConfigureWifiDisplayPermission=" + this.mHasConfigureWifiDisplayPermission);
            pw.println(indent + "mHasModifyAudioRoutingPermission=" + this.mHasModifyAudioRoutingPermission);
            pw.println(indent + "mHasBluetoothRoutingPermission=" + this.mHasBluetoothRoutingPermission.get());
            pw.println(indent + "hasSystemRoutingPermission=" + hasSystemRoutingPermission());
            pw.println(indent + "mRouterId=" + this.mRouterId);
            this.mDiscoveryPreference.dump(pw, indent);
        }

        public void notifyRegistered(List<MediaRoute2Info> currentRoutes, RoutingSessionInfo currentSystemSessionInfo) {
            this.mRouter.notifyRouterRegistered(getVisibleRoutes(currentRoutes), currentSystemSessionInfo);     // Catch: RemoteException -> L4
            return;
        L4:
            ex = move-exception;
            logRemoteException("notifyRegistered", ex);
        }

        public void notifyRoutesUpdated(List<MediaRoute2Info> routes) {
            this.mRouter.notifyRoutesUpdated(getVisibleRoutes(routes));     // Catch: RemoteException -> L4
            return;
        L4:
            ex = move-exception;
            logRemoteException("notifyRoutesUpdated", ex);
        }

        public void notifySessionCreated(int requestId, RoutingSessionInfo sessionInfo) {
            this.mRouter.notifySessionCreated(requestId, maybeClearTransferInitiatorIdentity(sessionInfo));     // Catch: RemoteException -> L4
            return;
        L4:
            ex = move-exception;
            logRemoteException("notifySessionCreated", ex);
        }

        public void notifySessionCreationFailed(int requestId) {
            this.mRouter.notifySessionCreated(requestId, null);     // Catch: RemoteException -> L4
            return;
        L4:
            ex = move-exception;
            logRemoteException("notifySessionCreationFailed", ex);
        }

        public void notifySessionReleased(RoutingSessionInfo sessionInfo) {
            this.mRouter.notifySessionReleased(sessionInfo);     // Catch: RemoteException -> L4
            return;
        L4:
            ex = move-exception;
            logRemoteException("notifySessionReleased", ex);
        }

        public void notifyDeviceSuggestionsUpdated(String suggestingPackageName, List<SuggestedDeviceInfo> suggestedDeviceInfo) {
            this.mRouter.notifyDeviceSuggestionsUpdated(suggestingPackageName, suggestedDeviceInfo);     // Catch: RemoteException -> L4
            return;
        L4:
            ex = move-exception;
            logRemoteException("notifyDeviceSuggestionsUpdated", ex);
        }

        public void requestCreateSessionByManager(ManagerRecord managerRecord, long uniqueRequestId, RoutingSessionInfo oldSession, MediaRoute2Info route) {
        L7:
            ex = move-exception;
            logRemoteException("requestCreateSessionByManager", ex);
            managerRecord.notifyRequestFailed(MediaRouter2ServiceImpl.toOriginalRequestId(uniqueRequestId), 0);
            return;
        L3:
            if (route.isSystemRoute() == true) goto L5;
        L9:
            this.mRouter.requestCreateSessionByManager(uniqueRequestId, oldSession, route);     // Catch: RemoteException -> L7
            return;
        L5:
            if (hasSystemRoutingPermission() == true) goto L9;
            route = UserHandler.m5588$$Nest$mgetSystemProvider(this.mUserRecord.mHandler).getDefaultRoute();     // Catch: RemoteException -> L7
            goto L9
        }

        public void notifySessionInfoChanged(RoutingSessionInfo sessionInfo) {
            this.mRouter.notifySessionInfoChanged(maybeClearTransferInitiatorIdentity(sessionInfo));     // Catch: RemoteException -> L4
            return;
        L4:
            ex = move-exception;
            logRemoteException("notifySessionInfoChanged", ex);
        }

        private RoutingSessionInfo maybeClearTransferInitiatorIdentity(RoutingSessionInfo sessionInfo) {
            UserHandle transferInitiatorUserHandle = sessionInfo.getTransferInitiatorUserHandle();
            String transferInitiatorPackageName = sessionInfo.getTransferInitiatorPackageName();
            if (Objects.equals(UserHandle.of(this.mUserRecord.mUserId), transferInitiatorUserHandle) == false) goto L9;
            if (Objects.equals(this.mPackageName, transferInitiatorPackageName) == false) goto L9;
            return sessionInfo;
        L9:
            return new RoutingSessionInfo.Builder(sessionInfo).setTransferInitiator(null, null).build();
        }

        private List<MediaRoute2Info> getVisibleRoutes(List<MediaRoute2Info> routes) {
            List<MediaRoute2Info> filteredRoutes = new ArrayList();
            Iterator<MediaRoute2Info> r1 = routes.iterator();
        L4:
            if (r1.hasNext() == false) goto L11;
            MediaRoute2Info route = r1.next();
            if (route.isVisibleTo(this.mPackageName) == false) goto L4;
            if (hasPermissionsToSeeRoute(route) == false) goto L4;
            filteredRoutes.add(route);
            goto L4
        L11:
            return filteredRoutes;
        }

        private boolean hasPermissionsToSeeRoute(MediaRoute2Info route) {
            return true;
        }

        private void logRemoteException(String operation, RemoteException exception) {
            String message = TextUtils.formatSimple("%s failed for %s due to %s", new Object[]{operation, getDebugString(), exception.toString()});
            Slog.w(MediaRouter2ServiceImpl.TAG, message);
        }

        private String getDebugString() {
            return TextUtils.formatSimple("Router %s (id=%d,pid=%d,userId=%d,uid=%d)", new Object[]{this.mPackageName, Integer.valueOf(this.mRouterId), Integer.valueOf(this.mPid), Integer.valueOf(this.mUserRecord.mUserId), Integer.valueOf(this.mUid)});
        }
    }

    static final class SessionCreationRequest {
        public final long mManagerRequestId;
        public final RoutingSessionInfo mOldSession;
        public final MediaRoute2Info mRoute;
        public final RouterRecord mRouterRecord;
        public final long mUniqueRequestId;

        SessionCreationRequest(RouterRecord routerRecord, long uniqueRequestId, long managerRequestId, RoutingSessionInfo oldSession, MediaRoute2Info route) {
            this.mRouterRecord = routerRecord;
            this.mUniqueRequestId = uniqueRequestId;
            this.mManagerRequestId = managerRequestId;
            this.mOldSession = oldSession;
            this.mRoute = route;
        }

        public void dump(PrintWriter pw, String prefix) {
            pw.println(prefix + "SessionCreationRequest");
            String indent = prefix + "  ";
            pw.println(indent + "mUniqueRequestId=" + this.mUniqueRequestId);
            pw.println(indent + "mManagerRequestId=" + this.mManagerRequestId);
            this.mOldSession.dump(pw, indent);
            this.mRoute.dump(pw, prefix);
        }
    }

    static final class UserHandler extends Handler implements MediaRoute2ProviderWatcher.Callback, MediaRoute2Provider.Callback {
        private final Map<String, MediaRoute2Info> mLastNotifiedRoutesToNonPrivilegedRouters;
        private final Map<String, MediaRoute2Info> mLastNotifiedRoutesToPrivilegedRouters;
        private final List<MediaRoute2ProviderInfo> mLastProviderInfos;
        private final ArrayList<MediaRoute2Provider> mRouteProviders;
        private boolean mRunning;
        private final WeakReference<MediaRouter2ServiceImpl> mServiceRef;
        private final CopyOnWriteArrayList<SessionCreationRequest> mSessionCreationRequests;
        private final Map<String, RouterRecord> mSessionToRouterMap;
        private final SystemMediaRoute2Provider mSystemProvider;
        private final UserRecord mUserRecord;
        private final MediaRoute2ProviderWatcher mWatcher;

        /* JADX INFO: renamed from: $r8$lambda$4GeMTgT2EqUI14uXT1g_GxGk-uo, reason: not valid java name */
        public static /* synthetic */ void m5581$r8$lambda$4GeMTgT2EqUI14uXT1g_GxGkuo(UserHandler r0, MediaRoute2Provider r1, long r2, int r4) {
            r0.onRequestFailedOnHandler(r1, r2, r4);
        }

        public static /* synthetic */ boolean $r8$lambda$AH0WCyAzXPIQOCJfESXPqSmE8ZM(MediaRouter2ServiceImpl r0, ManagerRecord r1) {
            return lambda$areManagersScanning$5(r0, r1);
        }

        public static /* synthetic */ void $r8$lambda$N5oY2Ppa7qwRk5Tejc0FdDPh5ko(UserHandler r0, MediaRoute2Provider r1, long r2, RoutingSessionInfo r4) {
            r0.onSessionCreatedOnHandler(r1, r2, r4);
        }

        public static /* synthetic */ boolean $r8$lambda$OQ3pQlN5GmMu2MYsaA20twqsFl0(int r0, ManagerRecord r1) {
            return lambda$maybeUpdateDiscoveryPreferenceForUid$1(r0, r1);
        }

        public static /* synthetic */ boolean $r8$lambda$aIl8fM0XKWBgICPJfosAbmzw5gY(int r0, RouterRecord r1) {
            return lambda$maybeUpdateDiscoveryPreferenceForUid$0(r0, r1);
        }

        public static /* synthetic */ void $r8$lambda$amz3rnI4Xz6tg4rO_S4o_ibcqmU(UserHandler r0, MediaRoute2Provider r1, RoutingSessionInfo r2) {
            r0.onSessionReleasedOnHandler(r1, r2);
        }

        /* JADX INFO: renamed from: $r8$lambda$eOBJ-1pfE8vzA48h7Uqon61T65c, reason: not valid java name */
        public static /* synthetic */ String m5582$r8$lambda$eOBJ1pfE8vzA48h7Uqon61T65c(MediaRoute2Info r0) {
            return lambda$toLoggingMessage$3(r0);
        }

        public static /* synthetic */ void $r8$lambda$f4GzqvmtHHBH6ePjCBGy1DckMYs(UserHandler r0, MediaRoute2Provider r1) {
            r0.onProviderStateChangedOnHandler(r1);
        }

        /* JADX INFO: renamed from: $r8$lambda$fvJJXOSdU_LKl-DxaYjJIZtQEmo, reason: not valid java name */
        public static /* synthetic */ void m5583$r8$lambda$fvJJXOSdU_LKlDxaYjJIZtQEmo(UserHandler r0, MediaRoute2Provider r1, RoutingSessionInfo r2, Set r3) {
            r0.onSessionInfoChangedOnHandler(r1, r2, r3);
        }

        public static /* synthetic */ boolean $r8$lambda$oF_PbIkkuCxkptzSdph2RIKaxlU(MediaRouter2ServiceImpl r0, RouterRecord r1) {
            return lambda$getIndividuallyActiveRouters$4(r0, r1);
        }

        public static /* synthetic */ void $r8$lambda$qAWYHpsEJf192Tfv_KOCmVmOo6k(UserHandler r0) {
            r0.updateDiscoveryPreferenceOnHandler();
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmLastNotifiedRoutesToNonPrivilegedRouters, reason: not valid java name */
        static /* bridge */ /* synthetic */ Map m5584$$Nest$fgetmLastNotifiedRoutesToNonPrivilegedRouters(UserHandler r0) {
            return r0.mLastNotifiedRoutesToNonPrivilegedRouters;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmLastNotifiedRoutesToPrivilegedRouters, reason: not valid java name */
        static /* bridge */ /* synthetic */ Map m5585$$Nest$fgetmLastNotifiedRoutesToPrivilegedRouters(UserHandler r0) {
            return r0.mLastNotifiedRoutesToPrivilegedRouters;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmRouteProviders, reason: not valid java name */
        static /* bridge */ /* synthetic */ ArrayList m5586$$Nest$fgetmRouteProviders(UserHandler r0) {
            return r0.mRouteProviders;
        }

        /* JADX INFO: renamed from: -$$Nest$mdeselectRouteOnHandler, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m5587$$Nest$mdeselectRouteOnHandler(UserHandler r0, long r1, RouterRecord r3, String r4, MediaRoute2Info r5) {
            r0.deselectRouteOnHandler(r1, r3, r4, r5);
        }

        /* JADX INFO: renamed from: -$$Nest$mgetSystemProvider, reason: not valid java name */
        static /* bridge */ /* synthetic */ SystemMediaRoute2Provider m5588$$Nest$mgetSystemProvider(UserHandler r0) {
            return r0.getSystemProvider();
        }

        /* JADX INFO: renamed from: -$$Nest$mnotifyDeviceSuggestionsUpdatedOnHandler, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m5589$$Nest$mnotifyDeviceSuggestionsUpdatedOnHandler(UserHandler r0, String r1, String r2, List r3) {
            r0.notifyDeviceSuggestionsUpdatedOnHandler(r1, r2, r3);
        }

        /* JADX INFO: renamed from: -$$Nest$mnotifyDiscoveryPreferenceChangedToManager, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m5590$$Nest$mnotifyDiscoveryPreferenceChangedToManager(UserHandler r0, RouterRecord r1, IMediaRouter2Manager r2) {
            r0.notifyDiscoveryPreferenceChangedToManager(r1, r2);
        }

        /* JADX INFO: renamed from: -$$Nest$mnotifyDiscoveryPreferenceChangedToManagers, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m5591$$Nest$mnotifyDiscoveryPreferenceChangedToManagers(UserHandler r0, String r1, RouteDiscoveryPreference r2) {
            r0.notifyDiscoveryPreferenceChangedToManagers(r1, r2);
        }

        /* JADX INFO: renamed from: -$$Nest$mnotifyRouteListingPreferenceChangeToManagers, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m5592$$Nest$mnotifyRouteListingPreferenceChangeToManagers(UserHandler r0, String r1, RouteListingPreference r2) {
            r0.notifyRouteListingPreferenceChangeToManagers(r1, r2);
        }

        /* JADX INFO: renamed from: -$$Nest$mnotifyRouterRegistered, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m5593$$Nest$mnotifyRouterRegistered(UserHandler r0, RouterRecord r1) {
            r0.notifyRouterRegistered(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$mreleaseSessionOnHandler, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m5594$$Nest$mreleaseSessionOnHandler(UserHandler r0, long r1, RouterRecord r3, String r4) {
            r0.releaseSessionOnHandler(r1, r3, r4);
        }

        /* JADX INFO: renamed from: -$$Nest$mrequestCreateSessionWithRouter2OnHandler, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m5595$$Nest$mrequestCreateSessionWithRouter2OnHandler(UserHandler r0, long r1, long r3, RouterRecord r5, RoutingSessionInfo r6, MediaRoute2Info r7, Bundle r8) {
            r0.requestCreateSessionWithRouter2OnHandler(r1, r3, r5, r6, r7, r8);
        }

        /* JADX INFO: renamed from: -$$Nest$mselectRouteOnHandler, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m5596$$Nest$mselectRouteOnHandler(UserHandler r0, long r1, RouterRecord r3, String r4, MediaRoute2Info r5) {
            r0.selectRouteOnHandler(r1, r3, r4, r5);
        }

        /* JADX INFO: renamed from: -$$Nest$msetRouteVolumeOnHandler, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m5597$$Nest$msetRouteVolumeOnHandler(UserHandler r0, long r1, MediaRoute2Info r3, int r4) {
            r0.setRouteVolumeOnHandler(r1, r3, r4);
        }

        /* JADX INFO: renamed from: -$$Nest$msetSessionVolumeOnHandler, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m5598$$Nest$msetSessionVolumeOnHandler(UserHandler r0, long r1, String r3, int r4) {
            r0.setSessionVolumeOnHandler(r1, r3, r4);
        }

        /* JADX INFO: renamed from: -$$Nest$mstart, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m5599$$Nest$mstart(UserHandler r0) {
            r0.start();
        }

        /* JADX INFO: renamed from: -$$Nest$mstop, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m5600$$Nest$mstop(UserHandler r0) {
            r0.stop();
        }

        /* JADX INFO: renamed from: -$$Nest$mtransferToRouteOnHandler, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m5601$$Nest$mtransferToRouteOnHandler(UserHandler r0, long r1, UserHandle r3, String r4, RouterRecord r5, String r6, MediaRoute2Info r7, int r8) {
            r0.transferToRouteOnHandler(r1, r3, r4, r5, r6, r7, r8);
        }

        /* JADX INFO: renamed from: -$$Nest$mupdateDiscoveryPreferenceOnHandler, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m5602$$Nest$mupdateDiscoveryPreferenceOnHandler(UserHandler r0) {
            r0.updateDiscoveryPreferenceOnHandler();
        }

        private SystemMediaRoute2Provider getSystemProvider() {
            return this.mSystemProvider;
        }

        UserHandler(MediaRouter2ServiceImpl service, UserRecord userRecord, Looper looper) {
            super(looper, null, true);
            this.mRouteProviders = new ArrayList();
            this.mLastProviderInfos = new ArrayList();
            this.mSessionCreationRequests = new CopyOnWriteArrayList();
            this.mSessionToRouterMap = new ArrayMap();
            this.mLastNotifiedRoutesToPrivilegedRouters = new ArrayMap();
            this.mLastNotifiedRoutesToNonPrivilegedRouters = new ArrayMap();
            this.mServiceRef = new WeakReference(service);
            this.mUserRecord = userRecord;
            this.mSystemProvider = SystemMediaRoute2Provider.create(MediaRouter2ServiceImpl.m5572$$Nest$fgetmContext(service), UserHandle.of(userRecord.mUserId), looper);
            this.mRouteProviders.add(getSystemProvider());
            this.mWatcher = new MediaRoute2ProviderWatcher(MediaRouter2ServiceImpl.m5572$$Nest$fgetmContext(service), this, this, this.mUserRecord.mUserId);
        }

        void init() {
            getSystemProvider().setCallback(this);
        }

        private void start() {
            if (this.mRunning == true) goto L6;
            this.mRunning = true;
            getSystemProvider().start();
            this.mWatcher.start();
            return;
        }

        private void stop() {
            if (this.mRunning == false) goto L6;
            this.mRunning = false;
            this.mWatcher.stop();
            getSystemProvider().stop();
            return;
        }

        @Override // com.android.server.media.MediaRoute2ProviderWatcher.Callback
        public void onAddProviderService(MediaRoute2ProviderServiceProxy proxy) {
            proxy.setCallback(this);
            this.mRouteProviders.add(proxy);
            proxy.updateDiscoveryPreference(this.mUserRecord.mActivelyScanningPackages, this.mUserRecord.mCompositeDiscoveryPreference);
        }

        @Override // com.android.server.media.MediaRoute2ProviderWatcher.Callback
        public void onRemoveProviderService(MediaRoute2ProviderServiceProxy proxy) {
            this.mRouteProviders.remove(proxy);
        }

        @Override // com.android.server.media.MediaRoute2Provider.Callback
        public void onProviderStateChanged(MediaRoute2Provider provider) {
            sendMessage(PooledLambda.obtainMessage(new MediaRouter2ServiceImpl$UserHandler$$ExternalSyntheticLambda5(), this, provider));
        }

        @Override // com.android.server.media.MediaRoute2Provider.Callback
        public void onSessionCreated(MediaRoute2Provider provider, long uniqueRequestId, RoutingSessionInfo sessionInfo) {
            sendMessage(PooledLambda.obtainMessage(new MediaRouter2ServiceImpl$UserHandler$$ExternalSyntheticLambda1(), this, provider, Long.valueOf(uniqueRequestId), sessionInfo));
        }

        @Override // com.android.server.media.MediaRoute2Provider.Callback
        public void onSessionUpdated(MediaRoute2Provider provider, RoutingSessionInfo sessionInfo, Set<String> packageNamesWithRoutingSessionOverrides) {
            sendMessage(PooledLambda.obtainMessage(new MediaRouter2ServiceImpl$UserHandler$$ExternalSyntheticLambda10(), this, provider, sessionInfo, packageNamesWithRoutingSessionOverrides));
        }

        @Override // com.android.server.media.MediaRoute2Provider.Callback
        public void onSessionReleased(MediaRoute2Provider provider, RoutingSessionInfo sessionInfo) {
            sendMessage(PooledLambda.obtainMessage(new MediaRouter2ServiceImpl$UserHandler$$ExternalSyntheticLambda4(), this, provider, sessionInfo));
        }

        @Override // com.android.server.media.MediaRoute2Provider.Callback
        public void onRequestFailed(MediaRoute2Provider provider, long uniqueRequestId, int reason) {
            sendMessage(PooledLambda.obtainMessage(new MediaRouter2ServiceImpl$UserHandler$$ExternalSyntheticLambda9(), this, provider, Long.valueOf(uniqueRequestId), Integer.valueOf(reason)));
        }

        public RouterRecord findRouterWithSessionLocked(String uniqueSessionId) {
            return this.mSessionToRouterMap.get(uniqueSessionId);
        }

        public ManagerRecord findManagerWithId(int managerId) {
            Iterator<ManagerRecord> r0 = getManagerRecords().iterator();
        L4:
            if (r0.hasNext() == false) goto L9;
            ManagerRecord manager = r0.next();
            if (manager.mManagerId != managerId) goto L4;
            return manager;
        L9:
            return null;
        }

        public void maybeUpdateDiscoveryPreferenceForUid(final int uid) {
            MediaRouter2ServiceImpl service = this.mServiceRef.get();
            if (service != null) goto L5;
            return;
        L5:
            Object r1 = MediaRouter2ServiceImpl.m5573$$Nest$fgetmLock(service);
            monitor-enter(r1);
            boolean isUidRelevant = this.mUserRecord.mRouterRecords.stream().anyMatch(new MediaRouter2ServiceImpl$UserHandler$$ExternalSyntheticLambda6(uid)) | this.mUserRecord.mManagerRecords.stream().anyMatch(new MediaRouter2ServiceImpl$UserHandler$$ExternalSyntheticLambda7(uid));     // Catch: Throwable -> L12
            monitor-exit(r1);     // Catch: Throwable -> L12
            if (isUidRelevant == false) goto L17;
            sendMessage(PooledLambda.obtainMessage(new MediaRouter2ServiceImpl$UserHandler$$ExternalSyntheticLambda8(), this));
            return;
        L17:
            return;
        L12:
            th = move-exception;
            throw th;
        }

        private static /* synthetic */ boolean lambda$maybeUpdateDiscoveryPreferenceForUid$0(int uid, RouterRecord router) {
            if (router.mUid != uid) goto L5;
            return true;
        L5:
            return false;
        }

        private static /* synthetic */ boolean lambda$maybeUpdateDiscoveryPreferenceForUid$1(int uid, ManagerRecord manager) {
            if (manager.mOwnerUid != uid) goto L5;
            return true;
        L5:
            return false;
        }

        public void dump(PrintWriter pw, String prefix) {
            pw.println(prefix + "UserHandler");
            String indent = prefix + "  ";
            pw.println(indent + "mRunning=" + this.mRunning);
            getSystemProvider().dump(pw, prefix);
            this.mWatcher.dump(pw, prefix);
        }

        private void onProviderStateChangedOnHandler(MediaRoute2Provider provider) {
            MediaRoute2ProviderInfo newInfo = provider.getProviderInfo();
            int providerInfoIndex = indexOfRouteProviderInfoByUniqueId(provider.getUniqueId(), this.mLastProviderInfos);
            if (providerInfoIndex != (-1)) goto L5;
            MediaRoute2ProviderInfo oldInfo = null;
        L6:
            if (oldInfo != newInfo) goto L8;
            return;
        L8:
            if (newInfo == null) goto L13;
            Collection<MediaRoute2Info> newRoutes = newInfo.getRoutes();
            Set<String> newRouteIds = (Set) newRoutes.stream().map(new MediaRouter2ServiceImpl$UserHandler$$ExternalSyntheticLambda2()).collect(Collectors.toSet());
            if (providerInfoIndex < 0) goto L12;
            this.mLastProviderInfos.set(providerInfoIndex, newInfo);
        L14:
            ArrayList<MediaRoute2Info> addedRoutes = new ArrayList();
            boolean hasAddedOrModifiedRoutes = false;
            Iterator<MediaRoute2Info> r9 = newRoutes.iterator();
        L16:
            if (r9.hasNext() == false) goto L27;
            MediaRoute2Info newRouteInfo = r9.next();
            if (newRouteInfo.isValid() == false) goto L19;
            if (provider.mIsSystemRouteProvider == true) goto L23;
            this.mLastNotifiedRoutesToNonPrivilegedRouters.put(newRouteInfo.getId(), newRouteInfo);
        L23:
            MediaRoute2Info oldRouteInfo = this.mLastNotifiedRoutesToPrivilegedRouters.put(newRouteInfo.getId(), newRouteInfo);
            hasAddedOrModifiedRoutes = hasAddedOrModifiedRoutes | (!newRouteInfo.equals(oldRouteInfo));
            if (oldRouteInfo != null) goto L16;
            addedRoutes.add(newRouteInfo);
            goto L16
        L19:
            Slog.w(MediaRouter2ServiceImpl.TAG, "onProviderStateChangedOnHandler: Ignoring invalid route : " + newRouteInfo);
            goto L16
        L27:
            ArrayList<MediaRoute2Info> removedRoutes = new ArrayList();
            if (oldInfo != null) goto L30;
            Collection<MediaRoute2Info> oldRoutes = Collections.emptyList();
        L31:
            boolean hasRemovedRoutes = false;
            Iterator<MediaRoute2Info> r13 = oldRoutes.iterator();
        L33:
            if (r13.hasNext() == false) goto L39;
            MediaRoute2Info oldRoute = r13.next();
            String oldRouteId = oldRoute.getId();
            if (newRouteIds.contains(oldRouteId) == true) goto L38;
            hasRemovedRoutes = true;
            this.mLastNotifiedRoutesToPrivilegedRouters.remove(oldRouteId);
            this.mLastNotifiedRoutesToNonPrivilegedRouters.remove(oldRouteId);
            removedRoutes.add(oldRoute);
        L38:
            newInfo = newInfo;
            goto L33
        L39:
            MediaRoute2ProviderInfo newInfo2 = newInfo;
            if (addedRoutes.isEmpty() == true) goto L43;
            Slog.i(MediaRouter2ServiceImpl.TAG, toLoggingMessage("addProviderRoutes", newInfo2.getUniqueId(), addedRoutes));
        L43:
            if (removedRoutes.isEmpty() == true) goto L45;
            Slog.i(MediaRouter2ServiceImpl.TAG, toLoggingMessage("removeProviderRoutes", oldInfo.getUniqueId(), removedRoutes));
        L45:
            dispatchUpdatesOnHandler(hasAddedOrModifiedRoutes, hasRemovedRoutes, provider.mIsSystemRouteProvider, getSystemProvider().getDefaultRoute());
            return;
        L30:
            oldRoutes = oldInfo.getRoutes();
            goto L31
        L12:
            this.mLastProviderInfos.add(newInfo);
            goto L14
        L13:
            this.mLastProviderInfos.remove(oldInfo);
            newRouteIds = Collections.emptySet();
            newRoutes = Collections.emptySet();
            goto L14
        L5:
            oldInfo = this.mLastProviderInfos.get(providerInfoIndex);
            goto L6
        }

        private static /* synthetic */ boolean lambda$onProviderStateChangedOnHandler$2(MediaRoute2Info it) {
            return !it.supportsRemoteRouting();
        }

        private static String getPackageNameFromNullableRecord(RouterRecord routerRecord) {
            if (routerRecord != null) goto L6;
            return "<null router record>";
        L6:
            return routerRecord.mPackageName;
        }

        private static String toLoggingMessage(String source, String providerId, ArrayList<MediaRoute2Info> routes) {
            String routesString = (String) routes.stream().map(new MediaRouter2ServiceImpl$UserHandler$$ExternalSyntheticLambda3()).collect(Collectors.joining(", "));
            return TextUtils.formatSimple("%s | provider: %s, routes: [%s]", new Object[]{source, providerId, routesString});
        }

        private static /* synthetic */ String lambda$toLoggingMessage$3(MediaRoute2Info it) {
            return String.format("%s | %s", new Object[]{it.getOriginalId(), it.getName()});
        }

        public void dispatchRoutesToManagerOnHandler(ManagerRecord managerRecord) {
            List<MediaRoute2Info> routes = this.mLastNotifiedRoutesToPrivilegedRouters.values().stream().toList();
            managerRecord.notifyRoutesUpdated(routes);
        }

        private void dispatchUpdatesOnHandler(boolean hasAddedOrModifiedRoutes, boolean hasRemovedRoutes, boolean isSystemProvider, MediaRoute2Info defaultRoute) {
            if (hasAddedOrModifiedRoutes == true) goto L5;
            if (hasRemovedRoutes == true) goto L5;
            return;
        L5:
            List<RouterRecord> routerRecordsWithSystemRoutingPermission = getRouterRecords(true);
            List<RouterRecord> routerRecordsWithoutSystemRoutingPermission = getRouterRecords(false);
            List<ManagerRecord> managers = getManagerRecords();
            List<MediaRoute2Info> routesForPrivilegedRouters = this.mLastNotifiedRoutesToPrivilegedRouters.values().stream().toList();
            Iterator<ManagerRecord> r4 = managers.iterator();
        L7:
            if (r4.hasNext() == false) goto L9;
            ManagerRecord manager = r4.next();
            manager.notifyRoutesUpdated(routesForPrivilegedRouters);
            goto L7
        L9:
            notifyRoutesUpdatedToRouterRecords(routerRecordsWithSystemRoutingPermission, routesForPrivilegedRouters);
            if (isSystemProvider == true) goto L12;
            notifyRoutesUpdatedToRouterRecords(routerRecordsWithoutSystemRoutingPermission, new ArrayList(this.mLastNotifiedRoutesToNonPrivilegedRouters.values()));
            return;
        L12:
            if (hasAddedOrModifiedRoutes == false) goto L17;
            this.mLastNotifiedRoutesToNonPrivilegedRouters.put(defaultRoute.getId(), defaultRoute);
            notifyRoutesUpdatedToRouterRecords(routerRecordsWithoutSystemRoutingPermission, new ArrayList(this.mLastNotifiedRoutesToNonPrivilegedRouters.values()));
            return;
        }

        private static int indexOfRouteProviderInfoByUniqueId(String uniqueId, List<MediaRoute2ProviderInfo> lastProviderInfos) {
            int i = 0;
        L4:
            if (i >= lastProviderInfos.size()) goto L9;
            MediaRoute2ProviderInfo providerInfo = lastProviderInfos.get(i);
            if (TextUtils.equals(providerInfo.getUniqueId(), uniqueId) == true) goto L7;
            i = i + 1;
            goto L4
        L7:
            return i;
        L9:
            return -1;
        }

        private void requestCreateSessionWithRouter2OnHandler(long uniqueRequestId, long managerRequestId, RouterRecord routerRecord, RoutingSessionInfo oldSession, MediaRoute2Info route, Bundle sessionHints) {
            MediaRoute2Provider provider = findProvider(route.getProviderId());
            if (provider != null) goto L6;
            Slog.w(MediaRouter2ServiceImpl.TAG, "requestCreateSessionWithRouter2OnHandler: Ignoring session creation request since no provider found for given route=" + route);
            routerRecord.notifySessionCreationFailed(MediaRouter2ServiceImpl.toOriginalRequestId(uniqueRequestId));
            return;
        L6:
            SessionCreationRequest request = new SessionCreationRequest(routerRecord, uniqueRequestId, managerRequestId, oldSession, route);
            this.mSessionCreationRequests.add(request);
            if (managerRequestId == 0) goto L9;
            int transferReason = 1;
        L10:
            provider.requestCreateSession(uniqueRequestId, routerRecord.mPackageName, route.getOriginalId(), sessionHints, transferReason, UserHandle.of(routerRecord.mUserRecord.mUserId), routerRecord.mPackageName);
            return;
        L9:
            transferReason = 2;
            goto L10
        }

        private void selectRouteOnHandler(long uniqueRequestId, RouterRecord routerRecord, String uniqueSessionId, MediaRoute2Info route) {
            if (checkArgumentsForSessionControl(routerRecord, uniqueSessionId, route, "selecting", uniqueRequestId) == true) goto L5;
            return;
        L5:
            String providerId = route.getProviderId();
            MediaRoute2Provider provider = findProvider(providerId);
            if (provider != null) goto L8;
            return;
        L8:
            provider.selectRoute(uniqueRequestId, MediaRouter2Utils.getOriginalId(uniqueSessionId), route.getOriginalId());
            MediaRouter2ServiceImpl.m5577$$Nest$sfgetmMediaRouterMetricLogger().logRequestResult(uniqueRequestId, 1);
        }

        private void deselectRouteOnHandler(long uniqueRequestId, RouterRecord routerRecord, String uniqueSessionId, MediaRoute2Info route) {
            if (checkArgumentsForSessionControl(routerRecord, uniqueSessionId, route, "deselecting", uniqueRequestId) == true) goto L5;
            return;
        L5:
            String providerId = route.getProviderId();
            MediaRoute2Provider provider = findProvider(providerId);
            if (provider != null) goto L8;
            return;
        L8:
            provider.deselectRoute(uniqueRequestId, MediaRouter2Utils.getOriginalId(uniqueSessionId), route.getOriginalId());
            MediaRouter2ServiceImpl.m5577$$Nest$sfgetmMediaRouterMetricLogger().logRequestResult(uniqueRequestId, 1);
        }

        private void transferToRouteOnHandler(long uniqueRequestId, UserHandle transferInitiatorUserHandle, String transferInitiatorPackageName, RouterRecord routerRecord, String uniqueSessionId, MediaRoute2Info route, int transferReason) {
            if (checkArgumentsForSessionControl(routerRecord, uniqueSessionId, route, "transferring to", uniqueRequestId) == true) goto L5;
            return;
        L5:
            String providerId = route.getProviderId();
            MediaRoute2Provider provider = findProvider(providerId);
            if (provider != null) goto L9;
            Slog.w(MediaRouter2ServiceImpl.TAG, "Ignoring transferToRoute due to lack of matching provider for target: " + route);
            return;
        L9:
            provider.transferToRoute(uniqueRequestId, transferInitiatorUserHandle, transferInitiatorPackageName, MediaRouter2Utils.getOriginalId(uniqueSessionId), route.getOriginalId(), transferReason);
            MediaRouter2ServiceImpl.m5577$$Nest$sfgetmMediaRouterMetricLogger().logRequestResult(uniqueRequestId, 1);
        }

        private boolean checkArgumentsForSessionControl(RouterRecord routerRecord, String uniqueSessionId, MediaRoute2Info route, String description, long uniqueRequestId) {
            String providerId = route.getProviderId();
            MediaRoute2Provider provider = findProvider(providerId);
            if (provider != null) goto L7;
            Slog.w(MediaRouter2ServiceImpl.TAG, "Ignoring " + description + " route since no provider found for given route=" + route);
            MediaRouter2ServiceImpl.m5577$$Nest$sfgetmMediaRouterMetricLogger().logRequestResult(uniqueRequestId, 6);
            return false;
        L7:
            if (TextUtils.equals(MediaRouter2Utils.getProviderId(uniqueSessionId), getSystemProvider().getUniqueId()) == false) goto L9;
            return true;
        L9:
            RouterRecord matchingRecord = this.mSessionToRouterMap.get(uniqueSessionId);
            if (matchingRecord == routerRecord) goto L13;
            Slog.w(MediaRouter2ServiceImpl.TAG, "Ignoring " + description + " route from non-matching router. routerRecordPackageName=" + getPackageNameFromNullableRecord(routerRecord) + " matchingRecordPackageName=" + getPackageNameFromNullableRecord(matchingRecord) + " route=" + route);
            MediaRouter2ServiceImpl.m5577$$Nest$sfgetmMediaRouterMetricLogger().logRequestResult(uniqueRequestId, 17);
            return false;
        L13:
            String sessionId = MediaRouter2Utils.getOriginalId(uniqueSessionId);
            if (sessionId != null) goto L17;
            Slog.w(MediaRouter2ServiceImpl.TAG, "Failed to get original session id from unique session id. uniqueSessionId=" + uniqueSessionId);
            MediaRouter2ServiceImpl.m5577$$Nest$sfgetmMediaRouterMetricLogger().logRequestResult(uniqueRequestId, 11);
            return false;
        L17:
            return true;
        }

        private void setRouteVolumeOnHandler(long uniqueRequestId, MediaRoute2Info route, int volume) {
            MediaRoute2Provider provider = findProvider(route.getProviderId());
            if (provider != null) goto L6;
            Slog.w(MediaRouter2ServiceImpl.TAG, "setRouteVolumeOnHandler: Couldn't find provider for route=" + route);
            return;
        L6:
            provider.setRouteVolume(uniqueRequestId, route.getOriginalId(), volume);
        }

        private void setSessionVolumeOnHandler(long uniqueRequestId, String uniqueSessionId, int volume) {
            MediaRoute2Provider provider = findProvider(MediaRouter2Utils.getProviderId(uniqueSessionId));
            if (provider != null) goto L6;
            Slog.w(MediaRouter2ServiceImpl.TAG, "setSessionVolumeOnHandler: Couldn't find provider for session id=" + uniqueSessionId);
            return;
        L6:
            provider.setSessionVolume(uniqueRequestId, MediaRouter2Utils.getOriginalId(uniqueSessionId), volume);
        }

        private void releaseSessionOnHandler(long uniqueRequestId, RouterRecord routerRecord, String uniqueSessionId) {
            RouterRecord matchingRecord = this.mSessionToRouterMap.get(uniqueSessionId);
            if (matchingRecord == routerRecord) goto L6;
            Slog.w(MediaRouter2ServiceImpl.TAG, "Ignoring releasing session from non-matching router. routerRecordPackageName=" + getPackageNameFromNullableRecord(routerRecord) + " matchingRecordPackageName=" + getPackageNameFromNullableRecord(matchingRecord) + " uniqueSessionId=" + uniqueSessionId);
            return;
        L6:
            String providerId = MediaRouter2Utils.getProviderId(uniqueSessionId);
            if (providerId != null) goto L10;
            Slog.w(MediaRouter2ServiceImpl.TAG, "Ignoring releasing session with invalid unique session ID. uniqueSessionId=" + uniqueSessionId);
            return;
        L10:
            String sessionId = MediaRouter2Utils.getOriginalId(uniqueSessionId);
            if (sessionId != null) goto L14;
            Slog.w(MediaRouter2ServiceImpl.TAG, "Ignoring releasing session with invalid unique session ID. uniqueSessionId=" + uniqueSessionId + " providerId=" + providerId);
            return;
        L14:
            MediaRoute2Provider provider = findProvider(providerId);
            if (provider != null) goto L18;
            Slog.w(MediaRouter2ServiceImpl.TAG, "Ignoring releasing session since no provider found for given providerId=" + providerId);
            return;
        L18:
            provider.releaseSession(uniqueRequestId, sessionId);
        }

        private void onSessionCreatedOnHandler(MediaRoute2Provider provider, long uniqueRequestId, RoutingSessionInfo sessionInfo) {
            SessionCreationRequest matchingRequest = null;
            Iterator<SessionCreationRequest> r1 = this.mSessionCreationRequests.iterator();
        L4:
            if (r1.hasNext() == false) goto L11;
            SessionCreationRequest request = r1.next();
            if (request.mUniqueRequestId != uniqueRequestId) goto L4;
            if (TextUtils.equals(request.mRoute.getProviderId(), provider.getUniqueId()) == false) goto L4;
            matchingRequest = request;
        L11:
            if (matchingRequest != null) goto L13;
            long managerRequestId = 0;
        L14:
            notifySessionCreatedToManagers(managerRequestId, sessionInfo);
            if (matchingRequest != null) goto L18;
            Slog.w(MediaRouter2ServiceImpl.TAG, "Ignoring session creation result for unknown request. uniqueRequestId=" + uniqueRequestId + ", sessionInfo=" + sessionInfo);
            return;
        L18:
            this.mSessionCreationRequests.remove(matchingRequest);
            MediaRoute2Provider oldProvider = findProvider(matchingRequest.mOldSession.getProviderId());
            if (oldProvider == null) goto L21;
            oldProvider.prepareReleaseSession(matchingRequest.mOldSession.getId());
        L22:
            this.mSessionToRouterMap.put(sessionInfo.getId(), matchingRequest.mRouterRecord);
            if (sessionInfo.isSystemSession() == true) goto L25;
        L27:
            matchingRequest.mRouterRecord.notifySessionCreated(MediaRouter2ServiceImpl.toOriginalRequestId(uniqueRequestId), sessionInfo);
            MediaRouter2ServiceImpl.m5577$$Nest$sfgetmMediaRouterMetricLogger().logRequestResult(uniqueRequestId, 1);
            return;
        L25:
            if (matchingRequest.mRouterRecord.hasSystemRoutingPermission() == true) goto L27;
            sessionInfo = getSystemProvider().getDefaultSessionInfo();
            goto L27
        L21:
            Slog.w(MediaRouter2ServiceImpl.TAG, "onSessionCreatedOnHandler: Can't find provider for an old session. session=" + matchingRequest.mOldSession);
            goto L22
        L13:
            managerRequestId = matchingRequest.mManagerRequestId;
            goto L14
        }

        private void onSessionInfoChangedOnHandler(MediaRoute2Provider provider, RoutingSessionInfo sessionInfo, Set<String> packageNamesWithRoutingSessionOverrides) {
            List<ManagerRecord> managers = getManagerRecords();
            Iterator<ManagerRecord> r1 = managers.iterator();
        L4:
            if (r1.hasNext() == false) goto L7;
            ManagerRecord manager = r1.next();
            manager.notifySessionUpdated(sessionInfo);
            goto L4
        L7:
            if (provider == getSystemProvider()) goto L9;
            RouterRecord routerRecord = this.mSessionToRouterMap.get(sessionInfo.getId());
            if (routerRecord != null) goto L17;
            Slog.w(MediaRouter2ServiceImpl.TAG, "onSessionInfoChangedOnHandler: No matching router found for session=" + sessionInfo);
            return;
        L17:
            notifySessionInfoChangedToRouters(Arrays.asList(new RouterRecord[]{routerRecord}), sessionInfo);
            return;
        L9:
            if (this.mServiceRef.get() != null) goto L11;
            return;
        L11:
            notifySessionInfoChangedToRouters(getRouterRecords(true), sessionInfo);
            notifySessionInfoChangedToRouters(getRouterRecords(false), getSystemProvider().getDefaultSessionInfo());
        }

        private void onSessionReleasedOnHandler(MediaRoute2Provider provider, RoutingSessionInfo sessionInfo) {
            List<ManagerRecord> managers = getManagerRecords();
            Iterator<ManagerRecord> r1 = managers.iterator();
        L4:
            if (r1.hasNext() == false) goto L6;
            ManagerRecord manager = r1.next();
            manager.notifySessionReleased(sessionInfo);
            goto L4
        L6:
            RouterRecord routerRecord = this.mSessionToRouterMap.get(sessionInfo.getId());
            if (routerRecord != null) goto L10;
            Slog.w(MediaRouter2ServiceImpl.TAG, "onSessionReleasedOnHandler: No matching router found for session=" + sessionInfo);
            return;
        L10:
            routerRecord.notifySessionReleased(sessionInfo);
        }

        private void onRequestFailedOnHandler(MediaRoute2Provider provider, long uniqueRequestId, int reason) {
            if (handleSessionCreationRequestFailed(provider, uniqueRequestId, reason) == false) goto L6;
            Slog.w(MediaRouter2ServiceImpl.TAG, TextUtils.formatSimple("onRequestFailedOnHandler | Finished handling session creation request failed for provider: %s, uniqueRequestId: %d, reason: %d", new Object[]{provider.getUniqueId(), Long.valueOf(uniqueRequestId), Integer.valueOf(reason)}));
            return;
        L6:
            int requesterId = MediaRouter2ServiceImpl.toRequesterId(uniqueRequestId);
            ManagerRecord manager = findManagerWithId(requesterId);
            if (manager == null) goto L9;
            manager.notifyRequestFailed(MediaRouter2ServiceImpl.toOriginalRequestId(uniqueRequestId), reason);
        L9:
            MediaRouter2ServiceImpl.m5577$$Nest$sfgetmMediaRouterMetricLogger().logRequestResult(uniqueRequestId, MediaRouterMetricLogger.convertResultFromReason(reason));
        }

        private boolean handleSessionCreationRequestFailed(MediaRoute2Provider provider, long uniqueRequestId, int reason) {
            SessionCreationRequest matchingRequest = null;
            Iterator<SessionCreationRequest> r1 = this.mSessionCreationRequests.iterator();
        L4:
            if (r1.hasNext() == false) goto L11;
            SessionCreationRequest request = r1.next();
            if (request.mUniqueRequestId != uniqueRequestId) goto L4;
            if (TextUtils.equals(request.mRoute.getProviderId(), provider.getUniqueId()) == false) goto L4;
            matchingRequest = request;
        L11:
            if (matchingRequest != null) goto L14;
            Slog.w(MediaRouter2ServiceImpl.TAG, TextUtils.formatSimple("handleSessionCreationRequestFailed | No matching request found for provider: %s, uniqueRequestId: %d, reason: %d", new Object[]{provider.getUniqueId(), Long.valueOf(uniqueRequestId), Integer.valueOf(reason)}));
            return false;
        L14:
            this.mSessionCreationRequests.remove(matchingRequest);
            if (matchingRequest.mManagerRequestId != 0) goto L17;
            matchingRequest.mRouterRecord.notifySessionCreationFailed(MediaRouter2ServiceImpl.toOriginalRequestId(uniqueRequestId));
            return true;
        L17:
            int requesterId = MediaRouter2ServiceImpl.toRequesterId(matchingRequest.mManagerRequestId);
            ManagerRecord manager = findManagerWithId(requesterId);
            if (manager == null) goto L29;
            manager.notifyRequestFailed(MediaRouter2ServiceImpl.toOriginalRequestId(matchingRequest.mManagerRequestId), reason);
            return true;
        L29:
            return true;
        }

        private List<RouterRecord> getRouterRecords() {
            MediaRouter2ServiceImpl service = this.mServiceRef.get();
            if (service == null) goto L5;
            Object r1 = MediaRouter2ServiceImpl.m5573$$Nest$fgetmLock(service);
            monitor-enter(r1);
            ArrayList r2 = new ArrayList(this.mUserRecord.mRouterRecords);     // Catch: Throwable -> L11
            monitor-exit(r1);     // Catch: Throwable -> L11
            return r2;
        L11:
            th = move-exception;
            throw th;
        L5:
            return Collections.emptyList();
        }

        private List<RouterRecord> getRouterRecords(boolean hasSystemRoutingPermission) {
            MediaRouter2ServiceImpl service = this.mServiceRef.get();
            List<RouterRecord> routerRecords = new ArrayList();
            if (service != null) goto L5;
            return routerRecords;
        L5:
            Object r2 = MediaRouter2ServiceImpl.m5573$$Nest$fgetmLock(service);
            monitor-enter(r2);
            Iterator<RouterRecord> r3 = this.mUserRecord.mRouterRecords.iterator();     // Catch: Throwable -> L13
        L9:
            if (r3.hasNext() == false) goto L16;
            RouterRecord routerRecord = r3.next();     // Catch: Throwable -> L13
            if (hasSystemRoutingPermission != routerRecord.hasSystemRoutingPermission()) goto L9;
            routerRecords.add(routerRecord);     // Catch: Throwable -> L13
            goto L9
        L16:
            monitor-exit(r2);     // Catch: Throwable -> L13
            return routerRecords;
        L13:
            th = move-exception;
            throw th;
        }

        private List<ManagerRecord> getManagerRecords() {
            MediaRouter2ServiceImpl service = this.mServiceRef.get();
            if (service == null) goto L5;
            Object r1 = MediaRouter2ServiceImpl.m5573$$Nest$fgetmLock(service);
            monitor-enter(r1);
            ArrayList r2 = new ArrayList(this.mUserRecord.mManagerRecords);     // Catch: Throwable -> L11
            monitor-exit(r1);     // Catch: Throwable -> L11
            return r2;
        L11:
            th = move-exception;
            throw th;
        L5:
            return Collections.emptyList();
        }

        private void notifyRouterRegistered(RouterRecord routerRecord) {
            List<MediaRoute2Info> currentRoutes = new ArrayList();
            MediaRoute2ProviderInfo systemProviderInfo = null;
            Iterator<MediaRoute2ProviderInfo> r2 = this.mLastProviderInfos.iterator();
        L4:
            if (r2.hasNext() == false) goto L10;
            MediaRoute2ProviderInfo providerInfo = r2.next();
            if (TextUtils.equals(providerInfo.getUniqueId(), getSystemProvider().getUniqueId()) == true) goto L7;
            currentRoutes.addAll(providerInfo.getRoutes());
            goto L4
        L7:
            systemProviderInfo = providerInfo;
            goto L4
        L10:
            if (routerRecord.hasSystemRoutingPermission() == false) goto L15;
            if (systemProviderInfo == null) goto L13;
            currentRoutes.addAll(systemProviderInfo.getRoutes());
        L14:
            RoutingSessionInfo currentSystemSessionInfo = getSystemProvider().getSessionInfos().get(0);
        L17:
            if (currentRoutes.isEmpty() == true) goto L26;
            routerRecord.notifyRegistered(currentRoutes, currentSystemSessionInfo);
            return;
        L26:
            return;
        L13:
            Slog.wtf(MediaRouter2ServiceImpl.TAG, "System route provider not found.");
            goto L14
        L15:
            currentRoutes.add(getSystemProvider().getDefaultRoute());
            currentSystemSessionInfo = getSystemProvider().getDefaultSessionInfo();
            goto L17
        }

        private static void notifyRoutesUpdatedToRouterRecords(List<RouterRecord> routerRecords, List<MediaRoute2Info> routes) {
            Iterator<RouterRecord> r0 = routerRecords.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            RouterRecord routerRecord = r0.next();
            routerRecord.notifyRoutesUpdated(routes);
            goto L4
        }

        private void notifySessionInfoChangedToRouters(List<RouterRecord> routerRecords, RoutingSessionInfo sessionInfo) {
            Iterator<RouterRecord> r0 = routerRecords.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            RouterRecord routerRecord = r0.next();
            routerRecord.notifySessionInfoChanged(sessionInfo);
            goto L4
        }

        private void notifySessionCreatedToManagers(long managerRequestId, RoutingSessionInfo session) {
            int requesterId = MediaRouter2ServiceImpl.toRequesterId(managerRequestId);
            int originalRequestId = MediaRouter2ServiceImpl.toOriginalRequestId(managerRequestId);
            Iterator<ManagerRecord> r2 = getManagerRecords().iterator();
        L4:
            if (r2.hasNext() == false) goto L15;
            ManagerRecord manager = r2.next();
            IMediaRouter2Manager r4 = manager.mManager;     // Catch: RemoteException -> L12
            if (manager.mManagerId != requesterId) goto L9;
            int r5 = originalRequestId;
        L10:
            r4.notifySessionCreated(r5, session);     // Catch: RemoteException -> L12
            goto L4
        L9:
            r5 = 0;
        L12:
            ex = move-exception;
            Slog.w(MediaRouter2ServiceImpl.TAG, "notifySessionCreatedToManagers: Failed to notify. Manager probably died.", ex);
            goto L4
        }

        private void notifyDiscoveryPreferenceChangedToManager(RouterRecord routerRecord, IMediaRouter2Manager manager) {
            manager.notifyDiscoveryPreferenceChanged(routerRecord.mPackageName, routerRecord.mDiscoveryPreference);     // Catch: RemoteException -> L4
            return;
        L4:
            ex = move-exception;
            Slog.w(MediaRouter2ServiceImpl.TAG, "Failed to notify preferred features changed. Manager probably died.", ex);
        }

        private void notifyDiscoveryPreferenceChangedToManagers(String routerPackageName, RouteDiscoveryPreference discoveryPreference) {
            MediaRouter2ServiceImpl service = this.mServiceRef.get();
            if (service != null) goto L5;
            return;
        L5:
            List<IMediaRouter2Manager> managers = new ArrayList();
            Object r2 = MediaRouter2ServiceImpl.m5573$$Nest$fgetmLock(service);
            monitor-enter(r2);
            Iterator<ManagerRecord> r3 = this.mUserRecord.mManagerRecords.iterator();     // Catch: Throwable -> L11
        L9:
            if (r3.hasNext() == false) goto L13;
            ManagerRecord managerRecord = r3.next();     // Catch: Throwable -> L11
            managers.add(managerRecord.mManager);     // Catch: Throwable -> L11
            goto L9
        L13:
            monitor-exit(r2);     // Catch: Throwable -> L11
            Iterator<IMediaRouter2Manager> r4 = managers.iterator();
        L16:
            if (r4.hasNext() == false) goto L23;
            IMediaRouter2Manager manager = r4.next();
            manager.notifyDiscoveryPreferenceChanged(routerPackageName, discoveryPreference);     // Catch: RemoteException -> L20
        L20:
            ex = move-exception;
            Slog.w(MediaRouter2ServiceImpl.TAG, "Failed to notify preferred features changed. Manager probably died.", ex);
            goto L16
        L23:
            return;
        L11:
            th = move-exception;
            throw th;
        }

        private void notifyRouteListingPreferenceChangeToManagers(String routerPackageName, RouteListingPreference routeListingPreference) {
            MediaRouter2ServiceImpl service = this.mServiceRef.get();
            if (service != null) goto L5;
            return;
        L5:
            List<IMediaRouter2Manager> managers = new ArrayList();
            Object r2 = MediaRouter2ServiceImpl.m5573$$Nest$fgetmLock(service);
            monitor-enter(r2);
            Iterator<ManagerRecord> r3 = this.mUserRecord.mManagerRecords.iterator();     // Catch: Throwable -> L11
        L9:
            if (r3.hasNext() == false) goto L13;
            ManagerRecord managerRecord = r3.next();     // Catch: Throwable -> L11
            managers.add(managerRecord.mManager);     // Catch: Throwable -> L11
            goto L9
        L13:
            monitor-exit(r2);     // Catch: Throwable -> L11
            Iterator<IMediaRouter2Manager> r4 = managers.iterator();
        L16:
            if (r4.hasNext() == false) goto L23;
            IMediaRouter2Manager manager = r4.next();
            manager.notifyRouteListingPreferenceChange(routerPackageName, routeListingPreference);     // Catch: RemoteException -> L20
        L20:
            ex = move-exception;
            Slog.w(MediaRouter2ServiceImpl.TAG, "Failed to notify preferred features changed. Manager probably died.", ex);
            goto L16
        L23:
            return;
        L11:
            th = move-exception;
            throw th;
        }

        private void notifyDeviceSuggestionsUpdatedOnHandler(String routerPackageName, String suggestingPackageName, List<SuggestedDeviceInfo> suggestedDeviceInfo) {
            MediaRouter2ServiceImpl service = this.mServiceRef.get();
            if (service != null) goto L5;
            return;
        L5:
            List<IMediaRouter2Manager> managers = new ArrayList();
            Object r2 = MediaRouter2ServiceImpl.m5573$$Nest$fgetmLock(service);
            monitor-enter(r2);
            Iterator<ManagerRecord> r3 = this.mUserRecord.mManagerRecords.iterator();     // Catch: Throwable -> L13
        L9:
            if (r3.hasNext() == false) goto L16;
            ManagerRecord managerRecord = r3.next();     // Catch: Throwable -> L13
            if (TextUtils.equals(managerRecord.mTargetPackageName, routerPackageName) == false) goto L9;
            managers.add(managerRecord.mManager);     // Catch: Throwable -> L13
            goto L9
        L16:
            Iterator<IMediaRouter2Manager> r4 = managers.iterator();     // Catch: Throwable -> L13
        L18:
            if (r4.hasNext() == false) goto L25;
            IMediaRouter2Manager manager = r4.next();     // Catch: Throwable -> L13
            manager.notifyDeviceSuggestionsUpdated(routerPackageName, suggestingPackageName, suggestedDeviceInfo);     // Catch: Throwable -> L13 RemoteException -> L22
        L22:
            ex = move-exception;
            Slog.w(MediaRouter2ServiceImpl.TAG, "Failed to notify suggesteion changed. Manager probably died.", ex);     // Catch: Throwable -> L13
            goto L18
        L25:
            Iterator<RouterRecord> r5 = this.mUserRecord.mRouterRecords.iterator();     // Catch: Throwable -> L13
        L27:
            if (r5.hasNext() == false) goto L32;
            RouterRecord routerRecord = r5.next();     // Catch: Throwable -> L13
            if (TextUtils.equals(routerRecord.mPackageName, routerPackageName) == false) goto L27;
            routerRecord.notifyDeviceSuggestionsUpdated(suggestingPackageName, suggestedDeviceInfo);     // Catch: Throwable -> L13
            goto L27
        L32:
            monitor-exit(r2);     // Catch: Throwable -> L13
            return;
        L13:
            th = move-exception;
            throw th;
        }

        private void updateDiscoveryPreferenceOnHandler() {
            MediaRouter2ServiceImpl service = this.mServiceRef.get();
            if (service != null) goto L5;
            return;
        L5:
            List<RouterRecord> allRouterRecords = getRouterRecords();
            boolean areManagersScanning = areManagersScanning(service, getManagerRecords());
            if (areManagersScanning == false) goto L8;
            List<RouterRecord> activeRouterRecords = allRouterRecords;
        L9:
            updateManagerScanningForProviders(areManagersScanning);
            Set<String> activelyScanningPackages = new HashSet();
            RouteDiscoveryPreference newPreference = buildCompositeDiscoveryPreference(activeRouterRecords, areManagersScanning, activelyScanningPackages);
            Slog.i(MediaRouter2ServiceImpl.TAG, TextUtils.formatSimple("Updating composite discovery preference | preference: %s, active routers: %s", new Object[]{newPreference, activelyScanningPackages}));
            if (updateScanningOnUserRecord(service, activelyScanningPackages, newPreference) == false) goto L13;
            updateDiscoveryPreferenceForProviders(activelyScanningPackages);
            return;
        L13:
            return;
        L8:
            activeRouterRecords = getIndividuallyActiveRouters(service, allRouterRecords);
            goto L9
        }

        private void updateDiscoveryPreferenceForProviders(Set<String> activelyScanningPackages) {
            Iterator<MediaRoute2Provider> r0 = this.mRouteProviders.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            MediaRoute2Provider provider = r0.next();
            provider.updateDiscoveryPreference(activelyScanningPackages, this.mUserRecord.mCompositeDiscoveryPreference);
            goto L4
        }

        private boolean updateScanningOnUserRecord(MediaRouter2ServiceImpl service, Set<String> activelyScanningPackages, RouteDiscoveryPreference newPreference) {
            Object r0 = MediaRouter2ServiceImpl.m5573$$Nest$fgetmLock(service);
            monitor-enter(r0);
        L11:
            th = move-exception;
            throw th;
        L5:
            if (newPreference.equals(this.mUserRecord.mCompositeDiscoveryPreference) == true) goto L7;
        L13:
            boolean oldShouldPerformActiveScan = this.mUserRecord.mCompositeDiscoveryPreference.shouldPerformActiveScan();     // Catch: Throwable -> L11
            boolean newShouldPerformActiveScan = newPreference.shouldPerformActiveScan();     // Catch: Throwable -> L11
            if (oldShouldPerformActiveScan == newShouldPerformActiveScan) goto L16;
            MediaRouter2ServiceImpl.m5577$$Nest$sfgetmMediaRouterMetricLogger().updateScanningState(newShouldPerformActiveScan);     // Catch: Throwable -> L11
        L16:
            this.mUserRecord.mCompositeDiscoveryPreference = newPreference;     // Catch: Throwable -> L11
            this.mUserRecord.mActivelyScanningPackages = activelyScanningPackages;     // Catch: Throwable -> L11
            monitor-exit(r0);     // Catch: Throwable -> L11
            return true;
        L7:
            if (activelyScanningPackages.equals(this.mUserRecord.mActivelyScanningPackages) == false) goto L13;
            monitor-exit(r0);     // Catch: Throwable -> L11
            return false;
        }

        private static RouteDiscoveryPreference buildCompositeDiscoveryPreference(List<RouterRecord> activeRouterRecords, boolean shouldForceActiveScan, Set<String> activelyScanningPackages) {
            Set<String> preferredFeatures = new HashSet();
            boolean activeScan = false;
            Iterator<RouterRecord> r2 = activeRouterRecords.iterator();
        L3:
            boolean isRouterRecordActivelyScanning = false;
            if (r2.hasNext() == false) goto L16;
            RouterRecord activeRouterRecord = r2.next();
            RouteDiscoveryPreference preference = activeRouterRecord.mDiscoveryPreference;
            preferredFeatures.addAll(preference.getPreferredFeatures());
            if (activeRouterRecord.isActivelyScanning() == true) goto L9;
            if (shouldForceActiveScan == true) goto L9;
        L13:
            if (isRouterRecordActivelyScanning == false) goto L3;
            activeScan = true;
            activelyScanningPackages.add(activeRouterRecord.mPackageName);
        L9:
            if (preference.getPreferredFeatures().isEmpty() == true) goto L13;
            isRouterRecordActivelyScanning = true;
            goto L13
        L16:
            List r3 = List.copyOf(preferredFeatures);
            if (activeScan == true) goto L19;
            if (shouldForceActiveScan == true) goto L19;
        L21:
            return new RouteDiscoveryPreference.Builder(r3, isRouterRecordActivelyScanning).build();
        L19:
            isRouterRecordActivelyScanning = true;
            goto L21
        }

        private void updateManagerScanningForProviders(boolean isManagerScanning) {
            Iterator<MediaRoute2Provider> r0 = this.mRouteProviders.iterator();
        L4:
            if (r0.hasNext() == false) goto L9;
            MediaRoute2Provider provider = r0.next();
            if ((provider instanceof MediaRoute2ProviderServiceProxy) == false) goto L4;
            ((MediaRoute2ProviderServiceProxy) provider).setManagerScanning(isManagerScanning);
            goto L4
        }

        private static List<RouterRecord> getIndividuallyActiveRouters(final MediaRouter2ServiceImpl service, List<RouterRecord> allRouterRecords) {
            service.mPowerManager.isInteractive();
            return (List) allRouterRecords.stream().filter(new MediaRouter2ServiceImpl$UserHandler$$ExternalSyntheticLambda11(service)).collect(Collectors.toList());
        }

        private static /* synthetic */ boolean lambda$getIndividuallyActiveRouters$4(MediaRouter2ServiceImpl service, RouterRecord record) {
            if (isPackageImportanceSufficientForScanning(service, record.mPackageName) == false) goto L5;
        L8:
            return true;
        L5:
            if (record.mScanningState == 2) goto L8;
            return false;
        }

        private static boolean areManagersScanning(final MediaRouter2ServiceImpl service, List<ManagerRecord> managerRecords) {
            service.mPowerManager.isInteractive();
            return managerRecords.stream().anyMatch(new MediaRouter2ServiceImpl$UserHandler$$ExternalSyntheticLambda0(service));
        }

        private static /* synthetic */ boolean lambda$areManagersScanning$5(MediaRouter2ServiceImpl service, ManagerRecord manager) {
            if (manager.mScanningState != 1) goto L7;
            if (isPackageImportanceSufficientForScanning(service, manager.mOwnerPackageName) == false) goto L7;
            return true;
        L7:
            if (manager.mScanningState == 2) goto L12;
            return false;
        L12:
            return true;
        }

        private static boolean isPackageImportanceSufficientForScanning(MediaRouter2ServiceImpl service, String packageName) {
            if (service.mActivityManager.getPackageImportance(packageName) > 100) goto L5;
            return true;
        L5:
            return false;
        }

        private MediaRoute2Provider findProvider(String providerId) {
            Iterator<MediaRoute2Provider> r0 = this.mRouteProviders.iterator();
        L4:
            if (r0.hasNext() == false) goto L9;
            MediaRoute2Provider provider = r0.next();
            if (TextUtils.equals(provider.getUniqueId(), providerId) == false) goto L4;
            return provider;
        L9:
            return null;
        }
    }

    final class UserRecord {
        Set<String> mActivelyScanningPackages;
        RouteDiscoveryPreference mCompositeDiscoveryPreference;
        private final Map<String, Map<String, List<SuggestedDeviceInfo>>> mDeviceSuggestions;
        final UserHandler mHandler;
        final ArrayList<ManagerRecord> mManagerRecords;
        final ArrayList<RouterRecord> mRouterRecords;
        public final int mUserId;

        public static /* synthetic */ void $r8$lambda$Bz8kWBR3vEpdbMm5KaUxuYtLtTU(UserRecord r0, PrintWriter r1, String r2) {
            r0.lambda$dump$0(r1, r2);
        }

        UserRecord(MediaRouter2ServiceImpl this$0, int userId, Looper looper) {
            this.mRouterRecords = new ArrayList();
            this.mManagerRecords = new ArrayList();
            this.mDeviceSuggestions = new HashMap();
            this.mCompositeDiscoveryPreference = RouteDiscoveryPreference.EMPTY;
            this.mActivelyScanningPackages = Set.of();
            this.mUserId = userId;
            this.mHandler = new UserHandler(this$0, this, looper);
        }

        void init() {
            this.mHandler.init();
        }

        RouterRecord findRouterRecordLocked(String packageName) {
            Iterator<RouterRecord> r0 = this.mRouterRecords.iterator();
        L4:
            if (r0.hasNext() == false) goto L9;
            RouterRecord routerRecord = r0.next();
            if (TextUtils.equals(routerRecord.mPackageName, packageName) == false) goto L4;
            return routerRecord;
        L9:
            return null;
        }

        public void updateDeviceSuggestionsLocked(String packageName, String suggestingPackageName, List<SuggestedDeviceInfo> deviceSuggestions) {
            this.mDeviceSuggestions.putIfAbsent(packageName, new HashMap());
            Map<String, List<SuggestedDeviceInfo>> suggestions = this.mDeviceSuggestions.get(packageName);
            suggestions.put(suggestingPackageName, deviceSuggestions);
        }

        public Map<String, List<SuggestedDeviceInfo>> getDeviceSuggestionsLocked(String packageName) {
            return this.mDeviceSuggestions.get(packageName);
        }

        public void dump(final PrintWriter pw, String prefix) {
            pw.println(prefix + "UserRecord");
            final String indent = prefix + "  ";
            pw.println(indent + "mUserId=" + this.mUserId);
            StringBuilder r2 = new StringBuilder();
            r2.append(indent);
            r2.append("Router Records:");
            pw.println(r2.toString());
            if (this.mRouterRecords.isEmpty() == true) goto L9;
            Iterator<RouterRecord> r3 = this.mRouterRecords.iterator();
        L6:
            if (r3.hasNext() == false) goto L10;
            RouterRecord routerRecord = r3.next();
            routerRecord.dump(pw, indent + "  ");
        L10:
            pw.println(indent + "Manager Records:");
            if (this.mManagerRecords.isEmpty() == true) goto L17;
            Iterator<ManagerRecord> r4 = this.mManagerRecords.iterator();
        L14:
            if (r4.hasNext() == false) goto L18;
            ManagerRecord managerRecord = r4.next();
            managerRecord.dump(pw, indent + "  ");
        L18:
            pw.println(indent + "Composite discovery preference:");
            this.mCompositeDiscoveryPreference.dump(pw, indent + "  ");
            pw.println(indent + "Packages actively scanning: " + String.join(", ", this.mActivelyScanningPackages));
            if (this.mHandler.runWithScissors(new MediaRouter2ServiceImpl$UserRecord$$ExternalSyntheticLambda0(this, pw, indent), 1000) == true) goto L24;
            pw.println(indent + "<could not dump handler state>");
            return;
        L24:
            return;
        L17:
            pw.println(indent + "<no manager records>");
            goto L18
        L9:
            pw.println(indent + "<no router records>");
            goto L10
        }

        private /* synthetic */ void lambda$dump$0(PrintWriter pw, String indent) {
            this.mHandler.dump(pw, indent);
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$A1MNNkzrqX_54ykA9-Q6a4EZXOw, reason: not valid java name */
    public static /* synthetic */ void m5567$r8$lambda$A1MNNkzrqX_54ykA9Q6a4EZXOw(UserHandler r0, long r1, RouterRecord r3, String r4, MediaRoute2Info r5) {
        UserHandler.m5596$$Nest$mselectRouteOnHandler(r0, r1, r3, r4, r5);
    }

    public static /* synthetic */ void $r8$lambda$GGBfbFoPy3as7MvDGLYf1Hb5q34(MediaRouter2ServiceImpl r0, int r1) {
        r0.onPermissionsChanged(r1);
    }

    public static /* synthetic */ void $r8$lambda$Hh0KZX_PuDMjIdbl_7PSRKW15T4(UserHandler r0, long r1, RouterRecord r3, String r4, MediaRoute2Info r5) {
        UserHandler.m5587$$Nest$mdeselectRouteOnHandler(r0, r1, r3, r4, r5);
    }

    public static /* synthetic */ void $r8$lambda$PPVAQClEZyqe3qHCp2frh9stJeI(UserHandler r0, RouterRecord r1) {
        UserHandler.m5593$$Nest$mnotifyRouterRegistered(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$QUOfWBbs9bzeEoCNqoDrNBPHovk(UserHandler r0) {
        UserHandler.m5600$$Nest$mstop(r0);
    }

    public static /* synthetic */ void $r8$lambda$VwOkF_wuq7S_wu2mL143qz8S5B4(UserHandler r0, long r1, UserHandle r3, String r4, RouterRecord r5, String r6, MediaRoute2Info r7, int r8) {
        UserHandler.m5601$$Nest$mtransferToRouteOnHandler(r0, r1, r3, r4, r5, r6, r7, r8);
    }

    public static /* synthetic */ boolean $r8$lambda$WkJWXwn6WISrheyU9pm0Enuu3UM(int r0, RouterRecord r1) {
        return lambda$onPermissionsChanged$1(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$Zu0IjdDoujp3O6XUDZ9uKZp7Er4(UserHandler r0, RouterRecord r1, IMediaRouter2Manager r2) {
        UserHandler.m5590$$Nest$mnotifyDiscoveryPreferenceChangedToManager(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$_KlJMldyh-EHjCtdEMZwMuezeUQ, reason: not valid java name */
    public static /* synthetic */ void m5568$r8$lambda$_KlJMldyhEHjCtdEMZwMuezeUQ(UserHandler r0) {
        UserHandler.m5599$$Nest$mstart(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$ataqgynQFVsOBE3vUnQ_-XD3XQg, reason: not valid java name */
    public static /* synthetic */ void m5569$r8$lambda$ataqgynQFVsOBE3vUnQ_XD3XQg(MediaRouter2ServiceImpl r0, int r1, int r2) {
        r0.lambda$new$0(r1, r2);
    }

    public static /* synthetic */ boolean $r8$lambda$dD5DzbeDE3G6MbaYEfDLezH6a1Y(ManagerRecord r0) {
        return lambda$revokeManagerRecordAccessIfNeededLocked$2(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$e9Sk6TFecCbShGZjiI_FsGfvE-s, reason: not valid java name */
    public static /* synthetic */ void m5570$r8$lambda$e9Sk6TFecCbShGZjiI_FsGfvEs(UserHandler r0, long r1, MediaRoute2Info r3, int r4) {
        UserHandler.m5597$$Nest$msetRouteVolumeOnHandler(r0, r1, r3, r4);
    }

    public static /* synthetic */ void $r8$lambda$fFTtstVLACy5dqiCA6mMwECkaiQ(UserHandler r0, long r1, RouterRecord r3, String r4) {
        UserHandler.m5594$$Nest$mreleaseSessionOnHandler(r0, r1, r3, r4);
    }

    public static /* synthetic */ void $r8$lambda$gfBNjj_qEN5gYbuwjbOFgMrSMpU(UserHandler r0, long r1, String r3, int r4) {
        UserHandler.m5598$$Nest$msetSessionVolumeOnHandler(r0, r1, r3, r4);
    }

    public static /* synthetic */ void $r8$lambda$heOK_4zIzngS8WMr61qD_midgrQ(UserHandler r0, String r1, RouteListingPreference r2) {
        UserHandler.m5592$$Nest$mnotifyRouteListingPreferenceChangeToManagers(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$l439RW2gb6MOGyg-suamHEVj0Rk, reason: not valid java name */
    public static /* synthetic */ void m5571$r8$lambda$l439RW2gb6MOGygsuamHEVj0Rk(UserHandler r0, String r1, RouteDiscoveryPreference r2) {
        UserHandler.m5591$$Nest$mnotifyDiscoveryPreferenceChangedToManagers(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$nXuPds3k0jio2D7WuuvE5DDYAcw(UserHandler r0, String r1, String r2, List r3) {
        UserHandler.m5589$$Nest$mnotifyDeviceSuggestionsUpdatedOnHandler(r0, r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$qAWYHpsEJf192Tfv_KOCmVmOo6k(UserHandler r0) {
        UserHandler.m5602$$Nest$mupdateDiscoveryPreferenceOnHandler(r0);
    }

    public static /* synthetic */ boolean $r8$lambda$qbz3LYndmY0iEsz0iRO0lcgd08k(String r0, ManagerRecord r1) {
        return lambda$revokeManagerRecordAccessIfNeededLocked$3(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$rJFyE42AlNSC9f1Q478dCOSFiVE(UserHandler r0, long r1, long r3, RouterRecord r5, RoutingSessionInfo r6, MediaRoute2Info r7, Bundle r8) {
        UserHandler.m5595$$Nest$mrequestCreateSessionWithRouter2OnHandler(r0, r1, r3, r5, r6, r7, r8);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m5572$$Nest$fgetmContext(MediaRouter2ServiceImpl r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m5573$$Nest$fgetmLock(MediaRouter2ServiceImpl r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUserRecords, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseArray m5574$$Nest$fgetmUserRecords(MediaRouter2ServiceImpl r0) {
        return r0.mUserRecords;
    }

    /* JADX INFO: renamed from: -$$Nest$mcheckCallerHasBluetoothPermissions, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m5575$$Nest$mcheckCallerHasBluetoothPermissions(MediaRouter2ServiceImpl r0, int r1, int r2) {
        return r0.checkCallerHasBluetoothPermissions(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mrevokeManagerRecordAccessIfNeededLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5576$$Nest$mrevokeManagerRecordAccessIfNeededLocked(MediaRouter2ServiceImpl r0, String r1, int r2) {
        r0.revokeManagerRecordAccessIfNeededLocked(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetmMediaRouterMetricLogger, reason: not valid java name */
    static /* bridge */ /* synthetic */ MediaRouterMetricLogger m5577$$Nest$sfgetmMediaRouterMetricLogger() {
        return mMediaRouterMetricLogger;
    }

    /* JADX INFO: renamed from: -$$Nest$smgetScanningStateString, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m5578$$Nest$smgetScanningStateString(int r0) {
        return getScanningStateString(r0);
    }

    static {
        DEBUG = Log.isLoggable(TAG, 3);
        BLUETOOTH_PERMISSIONS_FOR_SYSTEM_ROUTING = new String[]{"android.permission.BLUETOOTH_CONNECT", "android.permission.BLUETOOTH_SCAN"};
        mMediaRouterMetricLogger = new MediaRouterMetricLogger();
    }

    private /* synthetic */ void lambda$new$0(int uid, int importance) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int count = this.mUserRecords.size();     // Catch: Throwable -> L7
        int i = 0;
    L5:
        if (i >= count) goto L10;
        this.mUserRecords.valueAt(i).mHandler.maybeUpdateDiscoveryPreferenceForUid(uid);     // Catch: Throwable -> L7
        i = i + 1;     // Catch: Throwable -> L7
        goto L5
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    MediaRouter2ServiceImpl(Context context, Looper looper) {
        this.mExt = IMediaRouterServiceExt.get(this);
        this.mLock = new Object();
        this.mNextRouterOrManagerId = new AtomicInteger(1);
        this.mUserRecords = new SparseArray();
        this.mAllRouterRecords = new ArrayMap();
        this.mAllManagerRecords = new ArrayMap();
        this.mCurrentActiveUserId = -1;
        this.mOnUidImportanceListener = new MediaRouter2ServiceImpl$$ExternalSyntheticLambda11(this);
        this.mScreenOnOffReceiver = new AnonymousClass1(this);
        this.mOnOpChangedListener = new AnonymousClass2(this);
        this.mContext = context;
        this.mLooper = looper;
        this.mActivityManager = (ActivityManager) this.mContext.getSystemService(ActivityManager.class);
        this.mActivityManager.addOnUidImportanceListener(this.mOnUidImportanceListener, 100);
        this.mPowerManager = (PowerManager) this.mContext.getSystemService(PowerManager.class);
        this.mUserManagerInternal = (UserManagerInternal) LocalServices.getService(UserManagerInternal.class);
        this.mAppOpsManager = (AppOpsManager) this.mContext.getSystemService(AppOpsManager.class);
        this.mStatusBarManagerInternal = (StatusBarManagerInternal) LocalServices.getService(StatusBarManagerInternal.class);
        IntentFilter screenOnOffIntentFilter = new IntentFilter();
        screenOnOffIntentFilter.addAction("android.intent.action.SCREEN_ON");
        screenOnOffIntentFilter.addAction("android.intent.action.SCREEN_OFF");
        this.mContext.registerReceiver(this.mScreenOnOffReceiver, screenOnOffIntentFilter);
        this.mAppOpsManager.startWatchingMode(139, null, this.mOnOpChangedListener);
        this.mContext.getPackageManager().addOnPermissionsChangeListener(new MediaRouter2ServiceImpl$$ExternalSyntheticLambda12(this));
    }

    private void onPermissionsChanged(final int uid) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Optional<RouterRecord> affectedRouter = this.mAllRouterRecords.values().stream().filter(new MediaRouter2ServiceImpl$$ExternalSyntheticLambda23(uid)).findFirst();     // Catch: Throwable -> L7
        if (affectedRouter.isPresent() == false) goto L9;
        affectedRouter.get().maybeUpdateSystemRoutingPermissionLocked();     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ boolean lambda$onPermissionsChanged$1(int uid, RouterRecord it) {
        if (it.mUid != uid) goto L5;
        return true;
    L5:
        return false;
    }

    public List<MediaRoute2Info> getSystemRoutes(String callerPackageName, boolean isProxyRouter) {
        int uid = Binder.getCallingUid();
        int pid = Binder.getCallingPid();
        int userId = UserHandle.getUserHandleForUid(uid).getIdentifier();
        if (isProxyRouter == true) goto L5;
        boolean hasSystemRoutingPermissions = checkCallerHasSystemRoutingPermissions(pid, uid);
    L6:
        long token = Binder.clearCallingIdentity();
        Object r6 = this.mLock;     // Catch: Throwable -> L23
        monitor-enter(r6);     // Catch: Throwable -> L23
        UserRecord userRecord = getOrCreateUserRecordLocked(userId);     // Catch: Throwable -> L14
        if (hasSystemRoutingPermissions == false) goto L18;
        MediaRoute2ProviderInfo providerInfo = UserHandler.m5588$$Nest$mgetSystemProvider(userRecord.mHandler).getProviderInfo();     // Catch: Throwable -> L14
        if (providerInfo == null) goto L16;
        Collection<MediaRoute2Info> systemRoutes = providerInfo.getRoutes();     // Catch: Throwable -> L14
    L19:
        monitor-exit(r6);     // Catch: Throwable -> L14
        ArrayList r7 = new ArrayList(systemRoutes);     // Catch: Throwable -> L23
        Binder.restoreCallingIdentity(token);
        return r7;
    L16:
        systemRoutes = Collections.emptyList();     // Catch: Throwable -> L14
        Slog.e(TAG, "Returning empty system routes list because system provider has null providerInfo.");     // Catch: Throwable -> L14
        goto L19
    L18:
        systemRoutes = new ArrayList();     // Catch: Throwable -> L14
        systemRoutes.add(UserHandler.m5588$$Nest$mgetSystemProvider(userRecord.mHandler).getDefaultRoute());     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    L5:
        hasSystemRoutingPermissions = checkCallerHasPrivilegedRoutingPermissions(pid, uid, callerPackageName);
        goto L6
    }

    public boolean showMediaOutputSwitcherWithRouter2(String packageName) {
        UserHandle userHandle = Binder.getCallingUserHandle();
        long token = Binder.clearCallingIdentity();
        boolean r3 = showOutputSwitcher(packageName, userHandle);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(token);
        return r3;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    public void registerRouter2(IMediaRouter2 router, String packageName) {
        router.getClass();
        if (TextUtils.isEmpty(packageName) == true) goto L24;
        int uid = Binder.getCallingUid();
        int pid = Binder.getCallingPid();
        int userId = UserHandle.getUserHandleForUid(uid).getIdentifier();
        if (this.mContext.checkCallingOrSelfPermission("android.permission.CONFIGURE_WIFI_DISPLAY") != 0) goto L8;
        boolean r0 = true;
    L7:
        boolean hasConfigureWifiDisplayPermission = r0;
        boolean hasModifyAudioRoutingPermission = checkCallerHasModifyAudioRoutingPermission(pid, uid);
        boolean hasMediaContentControlPermission = checkMediaContentControlPermission(uid, pid);
        boolean hasMediaRoutingControlPermission = checkMediaRoutingControlPermission(uid, pid, packageName);
        long token = Binder.clearCallingIdentity();
        Object r13 = this.mLock;     // Catch: Throwable -> L20
        monitor-enter(r13);     // Catch: Throwable -> L20
        registerRouter2Locked(router, uid, pid, packageName, userId, hasConfigureWifiDisplayPermission, hasModifyAudioRoutingPermission, hasMediaContentControlPermission, hasMediaRoutingControlPermission);     // Catch: Throwable -> L17
        monitor-exit(r13);     // Catch: Throwable -> L17
        Binder.restoreCallingIdentity(token);
        return;
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    L8:
        r0 = false;
        goto L7
    L24:
        throw new IllegalArgumentException("packageName must not be empty");
    }

    public void unregisterRouter2(IMediaRouter2 router) {
        router.getClass();
        long token = Binder.clearCallingIdentity();
        Object r2 = this.mLock;     // Catch: Throwable -> L13
        monitor-enter(r2);     // Catch: Throwable -> L13
        unregisterRouter2Locked(router, false);     // Catch: Throwable -> L10
        monitor-exit(r2);     // Catch: Throwable -> L10
        Binder.restoreCallingIdentity(token);
        return;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    public void updateScanningState(IMediaRouter2 router, int scanningState) {
        router.getClass();
        validateScanningStateValue(scanningState);
        long token = Binder.clearCallingIdentity();
        Object r2 = this.mLock;     // Catch: Throwable -> L12
        monitor-enter(r2);     // Catch: Throwable -> L12
        updateScanningStateLocked(router, scanningState);     // Catch: Throwable -> L9
        monitor-exit(r2);     // Catch: Throwable -> L9
        Binder.restoreCallingIdentity(token);
        return;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    public void setDiscoveryRequestWithRouter2(IMediaRouter2 router, RouteDiscoveryPreference preference) {
        router.getClass();
        preference.getClass();
        long token = Binder.clearCallingIdentity();
        Object r2 = this.mLock;     // Catch: Throwable -> L19
        monitor-enter(r2);     // Catch: Throwable -> L19
        RouterRecord routerRecord = this.mAllRouterRecords.get(router.asBinder());     // Catch: Throwable -> L11
        if (routerRecord != null) goto L13;
        Slog.w(TAG, "Ignoring updating discoveryRequest of null routerRecord.");     // Catch: Throwable -> L11
        monitor-exit(r2);     // Catch: Throwable -> L11
        Binder.restoreCallingIdentity(token);
        return;
    L13:
        setDiscoveryRequestWithRouter2Locked(routerRecord, preference);     // Catch: Throwable -> L11
        monitor-exit(r2);     // Catch: Throwable -> L11
        Binder.restoreCallingIdentity(token);
        return;
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    public void setRouteListingPreference(IMediaRouter2 router, RouteListingPreference routeListingPreference) {
        if (routeListingPreference == null) goto L4;
        ComponentName linkedItemLandingComponent = routeListingPreference.getLinkedItemComponentName();
    L6:
        if (linkedItemLandingComponent == null) goto L12;
        int callingUid = Binder.getCallingUid();
        MediaServerUtils.enforcePackageName(this.mContext, linkedItemLandingComponent.getPackageName(), callingUid);
        if (MediaServerUtils.isValidActivityComponentName(this.mContext, linkedItemLandingComponent, "android.media.action.TRANSFER_MEDIA", Binder.getCallingUserHandle()) == true) goto L12;
        throw new IllegalArgumentException("Unable to resolve " + linkedItemLandingComponent + " to a valid activity for android.media.action.TRANSFER_MEDIA");
    L12:
        long token = Binder.clearCallingIdentity();
        Object r3 = this.mLock;     // Catch: Throwable -> L29
        monitor-enter(r3);     // Catch: Throwable -> L29
        RouterRecord routerRecord = this.mAllRouterRecords.get(router.asBinder());     // Catch: Throwable -> L21
        if (routerRecord != null) goto L23;
        Slog.w(TAG, "Ignoring updating route listing of null routerRecord.");     // Catch: Throwable -> L21
        monitor-exit(r3);     // Catch: Throwable -> L21
        Binder.restoreCallingIdentity(token);
        return;
    L23:
        setRouteListingPreferenceLocked(routerRecord, routeListingPreference);     // Catch: Throwable -> L21
        monitor-exit(r3);     // Catch: Throwable -> L21
        Binder.restoreCallingIdentity(token);
        return;
    L21:
        th = move-exception;
        throw th;     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    L4:
        linkedItemLandingComponent = null;
        goto L6
    }

    public void setRouteVolumeWithRouter2(IMediaRouter2 router, MediaRoute2Info route, int volume) {
        router.getClass();
        route.getClass();
        long token = Binder.clearCallingIdentity();
        Object r2 = this.mLock;     // Catch: Throwable -> L12
        monitor-enter(r2);     // Catch: Throwable -> L12
        setRouteVolumeWithRouter2Locked(router, route, volume);     // Catch: Throwable -> L9
        monitor-exit(r2);     // Catch: Throwable -> L9
        Binder.restoreCallingIdentity(token);
        return;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    public void requestCreateSessionWithRouter2(IMediaRouter2 router, int requestId, long managerRequestId, RoutingSessionInfo oldSession, MediaRoute2Info route, Bundle sessionHints) {
        router.getClass();
        oldSession.getClass();
        route.getClass();
        long token = Binder.clearCallingIdentity();
        Object r3 = this.mLock;     // Catch: Throwable -> L13
        monitor-enter(r3);     // Catch: Throwable -> L13
        requestCreateSessionWithRouter2Locked(requestId, managerRequestId, router, oldSession, route, sessionHints);     // Catch: Throwable -> L10
        monitor-exit(r3);     // Catch: Throwable -> L10
        Binder.restoreCallingIdentity(token);
        return;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    public void selectRouteWithRouter2(IMediaRouter2 router, String uniqueSessionId, MediaRoute2Info route) {
        router.getClass();
        route.getClass();
        if (TextUtils.isEmpty(uniqueSessionId) == true) goto L18;
        long token = Binder.clearCallingIdentity();
        Object r2 = this.mLock;     // Catch: Throwable -> L14
        monitor-enter(r2);     // Catch: Throwable -> L14
        selectRouteWithRouter2Locked(router, uniqueSessionId, route);     // Catch: Throwable -> L11
        monitor-exit(r2);     // Catch: Throwable -> L11
        Binder.restoreCallingIdentity(token);
        return;
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    L18:
        throw new IllegalArgumentException("uniqueSessionId must not be empty");
    }

    public void deselectRouteWithRouter2(IMediaRouter2 router, String uniqueSessionId, MediaRoute2Info route) {
        router.getClass();
        route.getClass();
        if (TextUtils.isEmpty(uniqueSessionId) == true) goto L18;
        long token = Binder.clearCallingIdentity();
        Object r2 = this.mLock;     // Catch: Throwable -> L14
        monitor-enter(r2);     // Catch: Throwable -> L14
        deselectRouteWithRouter2Locked(router, uniqueSessionId, route);     // Catch: Throwable -> L11
        monitor-exit(r2);     // Catch: Throwable -> L11
        Binder.restoreCallingIdentity(token);
        return;
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    L18:
        throw new IllegalArgumentException("uniqueSessionId must not be empty");
    }

    public void transferToRouteWithRouter2(IMediaRouter2 router, String uniqueSessionId, MediaRoute2Info route) {
        router.getClass();
        route.getClass();
        if (TextUtils.isEmpty(uniqueSessionId) == true) goto L18;
        UserHandle userHandle = Binder.getCallingUserHandle();
        long token = Binder.clearCallingIdentity();
        Object r3 = this.mLock;     // Catch: Throwable -> L14
        monitor-enter(r3);     // Catch: Throwable -> L14
        transferToRouteWithRouter2Locked(router, userHandle, uniqueSessionId, route);     // Catch: Throwable -> L11
        monitor-exit(r3);     // Catch: Throwable -> L11
        Binder.restoreCallingIdentity(token);
        return;
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    L18:
        throw new IllegalArgumentException("uniqueSessionId must not be empty");
    }

    public void setSessionVolumeWithRouter2(IMediaRouter2 router, String uniqueSessionId, int volume) {
        router.getClass();
        uniqueSessionId.getClass();
        if (TextUtils.isEmpty(uniqueSessionId) == true) goto L18;
        long token = Binder.clearCallingIdentity();
        Object r2 = this.mLock;     // Catch: Throwable -> L14
        monitor-enter(r2);     // Catch: Throwable -> L14
        setSessionVolumeWithRouter2Locked(router, uniqueSessionId, volume);     // Catch: Throwable -> L11
        monitor-exit(r2);     // Catch: Throwable -> L11
        Binder.restoreCallingIdentity(token);
        return;
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    L18:
        throw new IllegalArgumentException("uniqueSessionId must not be empty");
    }

    public void releaseSessionWithRouter2(IMediaRouter2 router, String uniqueSessionId) {
        router.getClass();
        if (TextUtils.isEmpty(uniqueSessionId) == true) goto L18;
        long token = Binder.clearCallingIdentity();
        Object r2 = this.mLock;     // Catch: Throwable -> L14
        monitor-enter(r2);     // Catch: Throwable -> L14
        releaseSessionWithRouter2Locked(router, uniqueSessionId);     // Catch: Throwable -> L11
        monitor-exit(r2);     // Catch: Throwable -> L11
        Binder.restoreCallingIdentity(token);
        return;
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    L18:
        throw new IllegalArgumentException("uniqueSessionId must not be empty");
    }

    public void setDeviceSuggestionsWithRouter2(IMediaRouter2 router, List<SuggestedDeviceInfo> suggestedDeviceInfo) {
        router.getClass();
        long token = Binder.clearCallingIdentity();
        Object r2 = this.mLock;     // Catch: Throwable -> L12
        monitor-enter(r2);     // Catch: Throwable -> L12
        setDeviceSuggestionsWithRouter2Locked(router, suggestedDeviceInfo);     // Catch: Throwable -> L9
        monitor-exit(r2);     // Catch: Throwable -> L9
        Binder.restoreCallingIdentity(token);
        return;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    public Map<String, List<SuggestedDeviceInfo>> getDeviceSuggestionsWithRouter2(IMediaRouter2 router) {
        router.getClass();
        long token = Binder.clearCallingIdentity();
        Object r2 = this.mLock;     // Catch: Throwable -> L12
        monitor-enter(r2);     // Catch: Throwable -> L12
        Map<String, List<SuggestedDeviceInfo>> r3 = getDeviceSuggestionsWithRouter2Locked(router);     // Catch: Throwable -> L9
        monitor-exit(r2);     // Catch: Throwable -> L9
        Binder.restoreCallingIdentity(token);
        return r3;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    public List<RoutingSessionInfo> getRemoteSessions(IMediaRouter2Manager manager) {
        manager.getClass();
        long token = Binder.clearCallingIdentity();
        Object r2 = this.mLock;     // Catch: Throwable -> L12
        monitor-enter(r2);     // Catch: Throwable -> L12
        List<RoutingSessionInfo> r3 = getRemoteSessionsLocked(manager);     // Catch: Throwable -> L9
        monitor-exit(r2);     // Catch: Throwable -> L9
        Binder.restoreCallingIdentity(token);
        return r3;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    public void registerManager(IMediaRouter2Manager manager, String callerPackageName) {
        manager.getClass();
        if (TextUtils.isEmpty(callerPackageName) == true) goto L23;
        int callerUid = Binder.getCallingUid();
        int callerPid = Binder.getCallingPid();
        UserHandle callerUser = Binder.getCallingUserHandle();
        enforcePrivilegedRoutingPermissions(callerUid, callerPid, callerPackageName);
        long token = Binder.clearCallingIdentity();
        Object r10 = this.mLock;     // Catch: Throwable -> L18
        monitor-enter(r10);     // Catch: Throwable -> L18
        registerManagerLocked(manager, callerUid, callerPid, callerPackageName, null, callerUser);     // Catch: Throwable -> L12
        monitor-exit(r10);     // Catch: Throwable -> L12
        Binder.restoreCallingIdentity(token);
        return;
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        Throwable r12 = th;
    L20:
        Binder.restoreCallingIdentity(token);
        throw r12;
    L18:
        th = move-exception;
        r12 = th;
        goto L20
    L23:
        throw new IllegalArgumentException("callerPackageName must not be empty");
    }

    public void registerProxyRouter(IMediaRouter2Manager manager, String callerPackageName, String targetPackageName, UserHandle targetUser) {
        manager.getClass();
        targetUser.getClass();
        if (TextUtils.isEmpty(targetPackageName) == true) goto L27;
        int callerUid = Binder.getCallingUid();
        int callerPid = Binder.getCallingPid();
        long token = Binder.clearCallingIdentity();
        enforcePrivilegedRoutingPermissions(callerUid, callerPid, callerPackageName);     // Catch: Throwable -> L20
        enforceCrossUserPermissions(callerUid, callerPid, targetUser);     // Catch: Throwable -> L20
        if (verifyPackageExistsForUser(targetPackageName, targetUser) == false) goto L23;
        Object r10 = this.mLock;     // Catch: Throwable -> L20
        monitor-enter(r10);     // Catch: Throwable -> L20
        registerManagerLocked(manager, callerUid, callerPid, callerPackageName, targetPackageName, targetUser);     // Catch: Throwable -> L14
        monitor-exit(r10);     // Catch: Throwable -> L14
        Binder.restoreCallingIdentity(token);
        return;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L23:
        throw new IllegalArgumentException("targetPackageName does not exist: " + targetPackageName);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        Throwable r12 = th;
    L24:
        Binder.restoreCallingIdentity(token);
        throw r12;
    L20:
        th = move-exception;
        r12 = th;
        goto L24
    L27:
        throw new IllegalArgumentException("targetPackageName must not be empty");
    }

    public void unregisterManager(IMediaRouter2Manager manager) {
        manager.getClass();
        long token = Binder.clearCallingIdentity();
        Object r2 = this.mLock;     // Catch: Throwable -> L13
        monitor-enter(r2);     // Catch: Throwable -> L13
        unregisterManagerLocked(manager, false);     // Catch: Throwable -> L10
        monitor-exit(r2);     // Catch: Throwable -> L10
        Binder.restoreCallingIdentity(token);
        return;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    public void updateScanningState(IMediaRouter2Manager manager, int scanningState) {
        manager.getClass();
        validateScanningStateValue(scanningState);
        long token = Binder.clearCallingIdentity();
        Object r2 = this.mLock;     // Catch: Throwable -> L12
        monitor-enter(r2);     // Catch: Throwable -> L12
        updateScanningStateLocked(manager, scanningState);     // Catch: Throwable -> L9
        monitor-exit(r2);     // Catch: Throwable -> L9
        Binder.restoreCallingIdentity(token);
        return;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    public void setRouteVolumeWithManager(IMediaRouter2Manager manager, int requestId, MediaRoute2Info route, int volume) {
        manager.getClass();
        route.getClass();
        long token = Binder.clearCallingIdentity();
        Object r2 = this.mLock;     // Catch: Throwable -> L12
        monitor-enter(r2);     // Catch: Throwable -> L12
        setRouteVolumeWithManagerLocked(requestId, manager, route, volume);     // Catch: Throwable -> L9
        monitor-exit(r2);     // Catch: Throwable -> L9
        Binder.restoreCallingIdentity(token);
        return;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    public void requestCreateSessionWithManager(IMediaRouter2Manager manager, int requestId, RoutingSessionInfo oldSession, MediaRoute2Info route) {
        manager.getClass();
        oldSession.getClass();
        route.getClass();
        long token = Binder.clearCallingIdentity();
        Object r2 = this.mLock;     // Catch: Throwable -> L12
        monitor-enter(r2);     // Catch: Throwable -> L12
        requestCreateSessionWithManagerLocked(requestId, manager, oldSession, route);     // Catch: Throwable -> L9
        monitor-exit(r2);     // Catch: Throwable -> L9
        Binder.restoreCallingIdentity(token);
        return;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    public void selectRouteWithManager(IMediaRouter2Manager manager, int requestId, String uniqueSessionId, MediaRoute2Info route) {
        manager.getClass();
        if (TextUtils.isEmpty(uniqueSessionId) == true) goto L18;
        route.getClass();
        long token = Binder.clearCallingIdentity();
        Object r2 = this.mLock;     // Catch: Throwable -> L14
        monitor-enter(r2);     // Catch: Throwable -> L14
        selectRouteWithManagerLocked(requestId, manager, uniqueSessionId, route);     // Catch: Throwable -> L11
        monitor-exit(r2);     // Catch: Throwable -> L11
        Binder.restoreCallingIdentity(token);
        return;
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    L18:
        throw new IllegalArgumentException("uniqueSessionId must not be empty");
    }

    public void deselectRouteWithManager(IMediaRouter2Manager manager, int requestId, String uniqueSessionId, MediaRoute2Info route) {
        manager.getClass();
        if (TextUtils.isEmpty(uniqueSessionId) == true) goto L18;
        route.getClass();
        long token = Binder.clearCallingIdentity();
        Object r2 = this.mLock;     // Catch: Throwable -> L14
        monitor-enter(r2);     // Catch: Throwable -> L14
        deselectRouteWithManagerLocked(requestId, manager, uniqueSessionId, route);     // Catch: Throwable -> L11
        monitor-exit(r2);     // Catch: Throwable -> L11
        Binder.restoreCallingIdentity(token);
        return;
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    L18:
        throw new IllegalArgumentException("uniqueSessionId must not be empty");
    }

    public void transferToRouteWithManager(IMediaRouter2Manager manager, int requestId, String uniqueSessionId, MediaRoute2Info route, UserHandle transferInitiatorUserHandle, String transferInitiatorPackageName) {
        manager.getClass();
        if (TextUtils.isEmpty(uniqueSessionId) == true) goto L19;
        route.getClass();
        transferInitiatorUserHandle.getClass();
        transferInitiatorPackageName.getClass();
        long token = Binder.clearCallingIdentity();
        Object r3 = this.mLock;     // Catch: Throwable -> L15
        monitor-enter(r3);     // Catch: Throwable -> L15
        transferToRouteWithManagerLocked(requestId, manager, uniqueSessionId, route, 1, transferInitiatorUserHandle, transferInitiatorPackageName);     // Catch: Throwable -> L12
        monitor-exit(r3);     // Catch: Throwable -> L12
        Binder.restoreCallingIdentity(token);
        return;
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    L19:
        throw new IllegalArgumentException("uniqueSessionId must not be empty");
    }

    public void setSessionVolumeWithManager(IMediaRouter2Manager manager, int requestId, String uniqueSessionId, int volume) {
        manager.getClass();
        if (TextUtils.isEmpty(uniqueSessionId) == true) goto L18;
        long token = Binder.clearCallingIdentity();
        Object r2 = this.mLock;     // Catch: Throwable -> L14
        monitor-enter(r2);     // Catch: Throwable -> L14
        setSessionVolumeWithManagerLocked(requestId, manager, uniqueSessionId, volume);     // Catch: Throwable -> L11
        monitor-exit(r2);     // Catch: Throwable -> L11
        Binder.restoreCallingIdentity(token);
        return;
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    L18:
        throw new IllegalArgumentException("uniqueSessionId must not be empty");
    }

    public void releaseSessionWithManager(IMediaRouter2Manager manager, int requestId, String uniqueSessionId) {
        manager.getClass();
        if (TextUtils.isEmpty(uniqueSessionId) == true) goto L18;
        long token = Binder.clearCallingIdentity();
        Object r2 = this.mLock;     // Catch: Throwable -> L14
        monitor-enter(r2);     // Catch: Throwable -> L14
        releaseSessionWithManagerLocked(requestId, manager, uniqueSessionId);     // Catch: Throwable -> L11
        monitor-exit(r2);     // Catch: Throwable -> L11
        Binder.restoreCallingIdentity(token);
        return;
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    L18:
        throw new IllegalArgumentException("uniqueSessionId must not be empty");
    }

    public void setDeviceSuggestionsWithManager(IMediaRouter2Manager manager, List<SuggestedDeviceInfo> suggestedDeviceInfo) {
        manager.getClass();
        long token = Binder.clearCallingIdentity();
        Object r2 = this.mLock;     // Catch: Throwable -> L12
        monitor-enter(r2);     // Catch: Throwable -> L12
        setDeviceSuggestionsWithManagerLocked(manager, suggestedDeviceInfo);     // Catch: Throwable -> L9
        monitor-exit(r2);     // Catch: Throwable -> L9
        Binder.restoreCallingIdentity(token);
        return;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    public Map<String, List<SuggestedDeviceInfo>> getDeviceSuggestionsWithManager(IMediaRouter2Manager manager) {
        manager.getClass();
        long token = Binder.clearCallingIdentity();
        Object r2 = this.mLock;     // Catch: Throwable -> L12
        monitor-enter(r2);     // Catch: Throwable -> L12
        Map<String, List<SuggestedDeviceInfo>> r3 = getDeviceSuggestionsWithManagerLocked(manager);     // Catch: Throwable -> L9
        monitor-exit(r2);     // Catch: Throwable -> L9
        Binder.restoreCallingIdentity(token);
        return r3;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    public boolean showMediaOutputSwitcherWithProxyRouter(IMediaRouter2Manager proxyRouter) {
        proxyRouter.getClass();
        long token = Binder.clearCallingIdentity();
        Object r2 = this.mLock;     // Catch: Throwable -> L17
        monitor-enter(r2);     // Catch: Throwable -> L17
        IBinder binder = proxyRouter.asBinder();     // Catch: Throwable -> L11
        ManagerRecord proxyRouterRecord = this.mAllManagerRecords.get(binder);     // Catch: Throwable -> L11
        if (proxyRouterRecord.mTargetPackageName == null) goto L14;
        boolean r5 = showOutputSwitcher(proxyRouterRecord.mTargetPackageName, UserHandle.of(proxyRouterRecord.mUserRecord.mUserId));     // Catch: Throwable -> L11
        monitor-exit(r2);     // Catch: Throwable -> L11
        Binder.restoreCallingIdentity(token);
        return r5;
    L14:
        throw new UnsupportedOperationException("Only proxy routers can show the Output Switcher.");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    public RoutingSessionInfo getSystemSessionInfo(String callerPackageName, String targetPackageName, boolean setDeviceRouteSelected) {
        int uid = Binder.getCallingUid();
        int pid = Binder.getCallingPid();
        int userId = UserHandle.getUserHandleForUid(uid).getIdentifier();
        if (targetPackageName != null) goto L5;
        boolean hasSystemRoutingPermissions = checkCallerHasSystemRoutingPermissions(pid, uid);
    L6:
        long token = Binder.clearCallingIdentity();
        Object r6 = this.mLock;     // Catch: Throwable -> L34
        monitor-enter(r6);     // Catch: Throwable -> L34
        UserRecord userRecord = getOrCreateUserRecordLocked(userId);     // Catch: Throwable -> L16
        SystemMediaRoute2Provider systemProvider = UserHandler.m5588$$Nest$mgetSystemProvider(userRecord.mHandler);     // Catch: Throwable -> L16
        if (hasSystemRoutingPermissions == false) goto L28;
        if (setDeviceRouteSelected == false) goto L19;
        RoutingSessionInfo r9 = systemProvider.generateDeviceRouteSelectedSessionInfo(targetPackageName);     // Catch: Throwable -> L16
        monitor-exit(r6);     // Catch: Throwable -> L16
        Binder.restoreCallingIdentity(token);
        return r9;
    L19:
        RoutingSessionInfo session = systemProvider.getSessionForPackage(targetPackageName);     // Catch: Throwable -> L16
        if (session == null) goto L24;
        monitor-exit(r6);     // Catch: Throwable -> L16
        Binder.restoreCallingIdentity(token);
        return session;
    L24:
        Slog.w(TAG, "System provider does not have any session info.");     // Catch: Throwable -> L16
        monitor-exit(r6);     // Catch: Throwable -> L16
        Binder.restoreCallingIdentity(token);
        return null;
    L28:
        RoutingSessionInfo r10 = new RoutingSessionInfo.Builder(systemProvider.getDefaultSessionInfo()).setClientPackageName(targetPackageName).build();     // Catch: Throwable -> L16
        monitor-exit(r6);     // Catch: Throwable -> L16
        Binder.restoreCallingIdentity(token);
        return r10;
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    L5:
        hasSystemRoutingPermissions = checkCallerHasPrivilegedRoutingPermissions(pid, uid, callerPackageName);
        goto L6
    }

    private boolean checkCallerHasSystemRoutingPermissions(int pid, int uid) {
        if (checkCallerHasModifyAudioRoutingPermission(pid, uid) == false) goto L5;
    L8:
        return true;
    L5:
        if (checkCallerHasBluetoothPermissions(pid, uid) == true) goto L8;
        return false;
    }

    private boolean checkCallerHasPrivilegedRoutingPermissions(int pid, int uid, String callerPackageName) {
        if (checkMediaContentControlPermission(uid, pid) == false) goto L5;
    L8:
        return true;
    L5:
        if (checkMediaRoutingControlPermission(uid, pid, callerPackageName) == true) goto L8;
        return false;
    }

    private boolean checkCallerHasModifyAudioRoutingPermission(int pid, int uid) {
        if (this.mContext.checkPermission("android.permission.MODIFY_AUDIO_ROUTING", pid, uid) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean checkCallerHasBluetoothPermissions(int pid, int uid) {
        boolean hasBluetoothRoutingPermission = true;
        String[] r1 = BLUETOOTH_PERMISSIONS_FOR_SYSTEM_ROUTING;
        int r2 = r1.length;
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L9;
        String permission = r1[r4];
        if (this.mContext.checkPermission(permission, pid, uid) != 0) goto L7;
        boolean r6 = true;
    L8:
        hasBluetoothRoutingPermission = hasBluetoothRoutingPermission & r6;
        r4 = r4 + 1;
        goto L3
    L7:
        r6 = false;
        goto L8
    L9:
        return hasBluetoothRoutingPermission;
    }

    private void enforcePrivilegedRoutingPermissions(int callerUid, int callerPid, String callerPackageName) {
        if (checkMediaContentControlPermission(callerUid, callerPid) == false) goto L6;
        return;
    L6:
        if (checkMediaRoutingControlPermission(callerUid, callerPid, callerPackageName) == false) goto L9;
        return;
    L9:
        throw new SecurityException("Must hold MEDIA_CONTENT_CONTROL or MEDIA_ROUTING_CONTROL permissions.");
    }

    private boolean checkMediaContentControlPermission(int callerUid, int callerPid) {
        if (this.mContext.checkPermission("android.permission.MEDIA_CONTENT_CONTROL", callerPid, callerUid) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean checkMediaRoutingControlPermission(int callerUid, int callerPid, String callerPackageName) {
        if (PermissionChecker.checkPermissionForDataDelivery(this.mContext, "android.permission.MEDIA_ROUTING_CONTROL", callerPid, callerUid, callerPackageName, null, "Checking permissions for registering manager in MediaRouter2ServiceImpl.") != 0) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean verifyPackageExistsForUser(String clientPackageName, UserHandle user) {
        PackageManager pm = this.mContext.getPackageManager();     // Catch: PackageManager.NameNotFoundException -> L5
        pm.getPackageInfoAsUser(clientPackageName, PackageManager.PackageInfoFlags.of(0), user.getIdentifier());     // Catch: PackageManager.NameNotFoundException -> L5
        return true;
    L6:
        return false;
    }

    private void enforceCrossUserPermissions(int callerUid, int callerPid, UserHandle targetUser) {
        int callerUserId = UserHandle.getUserId(callerUid);
        if (targetUser.getIdentifier() == callerUserId) goto L6;
        this.mContext.enforcePermission("android.permission.INTERACT_ACROSS_USERS_FULL", callerPid, callerUid, "Must hold INTERACT_ACROSS_USERS_FULL to control an app in a different userId.");
        return;
    }

    private boolean showOutputSwitcher(String packageName, UserHandle userHandle) {
        if (this.mActivityManager.getPackageImportance(packageName) <= 100) goto L6;
        Slog.w(TAG, "showMediaOutputSwitcher only works when called from foreground");
        return false;
    L6:
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mStatusBarManagerInternal.showMediaOutputSwitcher(packageName, userHandle);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return true;
    L12:
        th = move-exception;
        throw th;
    }

    public void dump(PrintWriter pw, String prefix) {
        pw.println(prefix + "MediaRouter2ServiceImpl");
        String indent = prefix + "  ";
        Object r1 = this.mLock;
        monitor-enter(r1);
        pw.println(indent + "mNextRouterOrManagerId=" + this.mNextRouterOrManagerId.get());     // Catch: Throwable -> L10
        pw.println(indent + "mCurrentActiveUserId=" + this.mCurrentActiveUserId);     // Catch: Throwable -> L10
        StringBuilder r2 = new StringBuilder();     // Catch: Throwable -> L10
        r2.append(indent);     // Catch: Throwable -> L10
        r2.append("UserRecords:");     // Catch: Throwable -> L10
        pw.println(r2.toString());     // Catch: Throwable -> L10
        if (this.mUserRecords.size() <= 0) goto L13;
        int i = 0;
    L8:
        if (i >= this.mUserRecords.size()) goto L14;
        this.mUserRecords.valueAt(i).dump(pw, indent + "  ");     // Catch: Throwable -> L10
        i = i + 1;     // Catch: Throwable -> L10
    L14:
        monitor-exit(r1);     // Catch: Throwable -> L10
        return;
    L13:
        pw.println(indent + "  <no user records>");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    void updateRunningUserAndProfiles(int newActiveUserId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.mCurrentActiveUserId == newActiveUserId) goto L16;
        Slog.i(TAG, TextUtils.formatSimple("switchUser | user: %d", new Object[]{Integer.valueOf(newActiveUserId)}));     // Catch: Throwable -> L12
        this.mCurrentActiveUserId = newActiveUserId;     // Catch: Throwable -> L12
        SparseArray<UserRecord> userRecords = this.mUserRecords.clone();     // Catch: Throwable -> L12
        int i = 0;
    L8:
        if (i >= userRecords.size()) goto L16;
        int userId = userRecords.keyAt(i);     // Catch: Throwable -> L12
        UserRecord userRecord = userRecords.valueAt(i);     // Catch: Throwable -> L12
        if (isUserActiveLocked(userId) == false) goto L14;
        userRecord.mHandler.sendMessage(PooledLambda.obtainMessage(new MediaRouter2ServiceImpl$$ExternalSyntheticLambda22(), userRecord.mHandler));     // Catch: Throwable -> L12
    L15:
        i = i + 1;     // Catch: Throwable -> L12
        goto L8
    L14:
        userRecord.mHandler.sendMessage(PooledLambda.obtainMessage(new MediaRouter2ServiceImpl$$ExternalSyntheticLambda21(), userRecord.mHandler));     // Catch: Throwable -> L12
        disposeUserIfNeededLocked(userRecord);     // Catch: Throwable -> L12
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L12
    }

    void routerDied(RouterRecord routerRecord) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        unregisterRouter2Locked(routerRecord.mRouter, true);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void managerDied(ManagerRecord managerRecord) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        unregisterManagerLocked(managerRecord.mManager, true);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private boolean isUserActiveLocked(int userId) {
        if (this.mUserManagerInternal.getProfileParentId(userId) != this.mCurrentActiveUserId) goto L5;
        return true;
    L5:
        return false;
    }

    private void revokeManagerRecordAccessIfNeededLocked(final String packageName, int userId) {
        UserRecord userRecord = this.mUserRecords.get(userId);
        if (userRecord != null) goto L5;
        return;
    L5:
        List<ManagerRecord> managers = (List) userRecord.mManagerRecords.stream().filter(new MediaRouter2ServiceImpl$$ExternalSyntheticLambda17()).filter(new MediaRouter2ServiceImpl$$ExternalSyntheticLambda18(packageName)).collect(Collectors.toList());
        if (managers.isEmpty() == false) goto L8;
        return;
    L8:
        ManagerRecord record = (ManagerRecord) managers.getFirst();
        if (this.mAppOpsManager.unsafeCheckOpNoThrow("android:media_routing_control", record.mOwnerUid, record.mOwnerPackageName) != 0) goto L11;
        boolean isAppOpAllowed = true;
    L12:
        if (isAppOpAllowed == false) goto L14;
        return;
    L14:
        Iterator<ManagerRecord> r6 = managers.iterator();
    L16:
        if (r6.hasNext() == false) goto L29;
        ManagerRecord manager = r6.next();
        if (this.mContext.checkPermission("android.permission.MEDIA_ROUTING_CONTROL", manager.mOwnerPid, manager.mOwnerUid) != 0) goto L20;
        boolean isRegularPermission = true;
    L21:
        if (isRegularPermission == true) goto L16;
        Slog.w(TAG, "Revoking access for " + manager.getDebugString());
        unregisterManagerLocked(manager.mManager, false);
        manager.mManager.invalidateInstance();     // Catch: RemoteException -> L26
    L26:
        ex = move-exception;
        ManagerRecord.m5579$$Nest$mlogRemoteException(manager, "invalidateInstance", ex);
        goto L16
    L20:
        isRegularPermission = false;
        goto L21
    L29:
        return;
    L11:
        isAppOpAllowed = false;
        goto L12
    }

    private static /* synthetic */ boolean lambda$revokeManagerRecordAccessIfNeededLocked$2(ManagerRecord r) {
        return !r.mHasMediaContentControl;
    }

    private static /* synthetic */ boolean lambda$revokeManagerRecordAccessIfNeededLocked$3(String packageName, ManagerRecord r) {
        return TextUtils.equals(r.mOwnerPackageName, packageName);
    }

    private void registerRouter2Locked(IMediaRouter2 router, int uid, int pid, String packageName, int userId, boolean hasConfigureWifiDisplayPermission, boolean hasModifyAudioRoutingPermission, boolean hasMediaContentControlPermission, boolean hasMediaRoutingControlPermission) {
        IBinder binder = router.asBinder();
        if (this.mAllRouterRecords.get(binder) == null) goto L6;
        Slog.w(TAG, "registerRouter2Locked: Same router already exists. packageName=" + packageName);
        return;
    L6:
        UserRecord userRecord = getOrCreateUserRecordLocked(userId);
        RouterRecord routerRecord = new RouterRecord(this, this.mContext, userRecord, router, uid, pid, packageName, hasConfigureWifiDisplayPermission, hasModifyAudioRoutingPermission, hasMediaContentControlPermission, hasMediaRoutingControlPermission);
        binder.linkToDeath(routerRecord, 0);     // Catch: RemoteException -> L10
        userRecord.mRouterRecords.add(routerRecord);
        this.mAllRouterRecords.put(binder, routerRecord);
        userRecord.mHandler.sendMessage(PooledLambda.obtainMessage(new MediaRouter2ServiceImpl$$ExternalSyntheticLambda9(), userRecord.mHandler, routerRecord));
        Slog.i(TAG, TextUtils.formatSimple("registerRouter2 | package: %s, uid: %d, pid: %d, router id: %d, hasMediaRoutingControl: %b", new Object[]{packageName, Integer.valueOf(uid), Integer.valueOf(pid), Integer.valueOf(routerRecord.mRouterId), Boolean.valueOf(hasMediaRoutingControlPermission)}));
        return;
    L10:
        ex = move-exception;
        throw new RuntimeException("MediaRouter2 died prematurely.", ex);
    }

    private void unregisterRouter2Locked(IMediaRouter2 router, boolean died) {
        RouterRecord routerRecord = this.mAllRouterRecords.remove(router.asBinder());
        if (routerRecord != null) goto L6;
        Slog.w(TAG, TextUtils.formatSimple("Ignoring unregistering unknown router: %s, died: %b", new Object[]{router, Boolean.valueOf(died)}));
        return;
    L6:
        Slog.i(TAG, TextUtils.formatSimple("unregisterRouter2 | package: %s, router id: %d, died: %b", new Object[]{routerRecord.mPackageName, Integer.valueOf(routerRecord.mRouterId), Boolean.valueOf(died)}));
        UserRecord userRecord = routerRecord.mUserRecord;
        userRecord.mRouterRecords.remove(routerRecord);
        routerRecord.mUserRecord.mHandler.sendMessage(PooledLambda.obtainMessage(new MediaRouter2ServiceImpl$$ExternalSyntheticLambda4(), routerRecord.mUserRecord.mHandler, routerRecord.mPackageName, null));
        routerRecord.mUserRecord.mHandler.sendMessage(PooledLambda.obtainMessage(new MediaRouter2ServiceImpl$$ExternalSyntheticLambda5(), routerRecord.mUserRecord.mHandler, routerRecord.mPackageName, null));
        userRecord.mHandler.sendMessage(PooledLambda.obtainMessage(new MediaRouter2ServiceImpl$$ExternalSyntheticLambda6(), userRecord.mHandler));
        routerRecord.dispose();
        disposeUserIfNeededLocked(userRecord);
    }

    private void updateScanningStateLocked(IMediaRouter2 router, int scanningState) {
        IBinder binder = router.asBinder();
        RouterRecord routerRecord = this.mAllRouterRecords.get(binder);
        if (routerRecord != null) goto L7;
        Slog.w(TAG, "Router record not found. Ignoring updateScanningState call.");
        return;
    L7:
        if (routerRecord.mHasMediaContentControlPermission == false) goto L9;
        boolean enableScanViaMediaContentControl = true;
    L11:
        if (scanningState != 2) goto L18;
        if (enableScanViaMediaContentControl == true) goto L18;
        if (routerRecord.mHasMediaRoutingControl == true) goto L18;
        throw new SecurityException("Screen off scan requires MEDIA_ROUTING_CONTROL");
    L18:
        Slog.i(TAG, TextUtils.formatSimple("updateScanningStateLocked | router: %d, packageName: %s, scanningState: %d", new Object[]{Integer.valueOf(routerRecord.mRouterId), routerRecord.mPackageName, getScanningStateString(scanningState)}));
        routerRecord.updateScanningState(scanningState);
        return;
    L9:
        enableScanViaMediaContentControl = false;
        goto L11
    }

    private void setDiscoveryRequestWithRouter2Locked(RouterRecord routerRecord, RouteDiscoveryPreference discoveryRequest) {
        if (routerRecord.mDiscoveryPreference.equals(discoveryRequest) == false) goto L5;
        return;
    L5:
        Slog.i(TAG, TextUtils.formatSimple("setDiscoveryRequestWithRouter2 | router: %s(id: %d), discovery request: %s", new Object[]{routerRecord.mPackageName, Integer.valueOf(routerRecord.mRouterId), discoveryRequest.toString()}));
        routerRecord.mDiscoveryPreference = discoveryRequest;
        routerRecord.mUserRecord.mHandler.sendMessage(PooledLambda.obtainMessage(new MediaRouter2ServiceImpl$$ExternalSyntheticLambda4(), routerRecord.mUserRecord.mHandler, routerRecord.mPackageName, routerRecord.mDiscoveryPreference));
        routerRecord.mUserRecord.mHandler.sendMessage(PooledLambda.obtainMessage(new MediaRouter2ServiceImpl$$ExternalSyntheticLambda6(), routerRecord.mUserRecord.mHandler));
    }

    private void setRouteListingPreferenceLocked(RouterRecord routerRecord, RouteListingPreference routeListingPreference) {
        routerRecord.mRouteListingPreference = routeListingPreference;
        if (routeListingPreference == null) goto L5;
        String routeListingAsString = (String) routeListingPreference.getItems().stream().map(new MediaRouter2ServiceImpl$$ExternalSyntheticLambda16()).collect(Collectors.joining(","));
    L6:
        Slog.i(TAG, TextUtils.formatSimple("setRouteListingPreference | router: %s(id: %d), route listing preference: [%s]", new Object[]{routerRecord.mPackageName, Integer.valueOf(routerRecord.mRouterId), routeListingAsString}));
        routerRecord.mUserRecord.mHandler.sendMessage(PooledLambda.obtainMessage(new MediaRouter2ServiceImpl$$ExternalSyntheticLambda5(), routerRecord.mUserRecord.mHandler, routerRecord.mPackageName, routeListingPreference));
        return;
    L5:
        routeListingAsString = null;
        goto L6
    }

    private void setRouteVolumeWithRouter2Locked(IMediaRouter2 router, MediaRoute2Info route, int volume) {
        IBinder binder = router.asBinder();
        RouterRecord routerRecord = this.mAllRouterRecords.get(binder);
        if (routerRecord == null) goto L6;
        Slog.i(TAG, TextUtils.formatSimple("setRouteVolumeWithRouter2 | router: %s(id: %d), volume: %d", new Object[]{routerRecord.mPackageName, Integer.valueOf(routerRecord.mRouterId), Integer.valueOf(volume)}));
        routerRecord.mUserRecord.mHandler.sendMessage(PooledLambda.obtainMessage(new MediaRouter2ServiceImpl$$ExternalSyntheticLambda2(), routerRecord.mUserRecord.mHandler, -1L, route, Integer.valueOf(volume)));
        return;
    }

    private void requestCreateSessionWithRouter2Locked(int requestId, long managerRequestId, IMediaRouter2 router, RoutingSessionInfo oldSession, MediaRoute2Info route, Bundle sessionHints) {
        MediaRouter2ServiceImpl r0 = this;
        IBinder binder = router.asBinder();
        RouterRecord routerRecord = r0.mAllRouterRecords.get(binder);
        if (routerRecord != null) goto L6;
        mMediaRouterMetricLogger.logOperationFailure(1, 17);
        r0.mExt.requestCreateSessionWithRouter2Locked_onStart(0, Binder.getCallingUid(), r0.mCurrentActiveUserId, "", -1, route.getId(), requestId, -1, managerRequestId, false, IMediaRouterServiceExt.ERROR_ROUTER_RECORD_NOT_FOUND);
        return;
    L6:
        Slog.i(TAG, TextUtils.formatSimple("requestCreateSessionWithRouter2 | router: %s(id: %d), old session id: %s, new session's route id: %s, request id: %d", new Object[]{routerRecord.mPackageName, Integer.valueOf(routerRecord.mRouterId), oldSession.getId(), route.getId(), Integer.valueOf(requestId)}));
        UserHandler userHandler = routerRecord.mUserRecord.mHandler;
        long uniqueRequestId = toUniqueRequestId(routerRecord.mRouterId, requestId);
        if (managerRequestId == 0) goto L33;
        ManagerRecord manager = userHandler.findManagerWithId(toRequesterId(managerRequestId));
        if (manager == null) goto L31;
        if (manager.mLastSessionCreationRequest == null) goto L31;
        if (TextUtils.equals(manager.mLastSessionCreationRequest.mOldSession.getId(), oldSession.getId()) == true) goto L17;
        Slog.w(TAG, "requestCreateSessionWithRouter2Locked: Ignoring unmatched routing session.");
        mMediaRouterMetricLogger.logOperationFailure(1, 11);
        r0.mExt.requestCreateSessionWithRouter2Locked_onStart(0, Binder.getCallingUid(), r0.mCurrentActiveUserId, routerRecord.mPackageName, routerRecord.mRouterId, route.getId(), requestId, uniqueRequestId, managerRequestId, false, IMediaRouterServiceExt.ERROR_INVALID_SESSION_ID);
        routerRecord.notifySessionCreationFailed(requestId);
        return;
    L17:
        UserHandler userHandler2 = userHandler;
        if (TextUtils.equals(manager.mLastSessionCreationRequest.mRoute.getId(), route.getId()) == false) goto L20;
        MediaRoute2Info route2 = route;
    L29:
        manager.mLastSessionCreationRequest = null;
        r0 = this;
        MediaRoute2Info route3 = route2;
    L45:
        r0.mExt.requestCreateSessionWithRouter2Locked_onStart(1, Binder.getCallingUid(), r0.mCurrentActiveUserId, routerRecord.mPackageName, routerRecord.mRouterId, route3.getId(), requestId, uniqueRequestId, managerRequestId, true, null);
        mMediaRouterMetricLogger.addRequestInfo(uniqueRequestId, 1);
        UserHandler userHandler3 = userHandler2;
        userHandler3.sendMessage(PooledLambda.obtainMessage(new MediaRouter2ServiceImpl$$ExternalSyntheticLambda15(), userHandler3, Long.valueOf(uniqueRequestId), Long.valueOf(managerRequestId), routerRecord, oldSession, route3, sessionHints));
        return;
    L20:
        if (routerRecord.hasSystemRoutingPermission() == false) goto L22;
    L26:
        Slog.w(TAG, "requestCreateSessionWithRouter2Locked: Ignoring unmatched route.");
        mMediaRouterMetricLogger.logOperationFailure(1, 10);
        this.mExt.requestCreateSessionWithRouter2Locked_onStart(0, Binder.getCallingUid(), this.mCurrentActiveUserId, routerRecord.mPackageName, routerRecord.mRouterId, route.getId(), requestId, uniqueRequestId, managerRequestId, false, IMediaRouterServiceExt.ERROR_INVALID_ROUTE_ID);
        routerRecord.notifySessionCreationFailed(requestId);
        return;
    L22:
        if (manager.mLastSessionCreationRequest.mRoute.isSystemRoute() == false) goto L26;
        if (route.isSystemRoute() == false) goto L26;
        route2 = manager.mLastSessionCreationRequest.mRoute;
    L31:
        Slog.w(TAG, "requestCreateSessionWithRouter2Locked: Ignoring unknown request.");
        mMediaRouterMetricLogger.logOperationFailure(1, 16);
        this.mExt.requestCreateSessionWithRouter2Locked_onStart(0, Binder.getCallingUid(), this.mCurrentActiveUserId, routerRecord.mPackageName, routerRecord.mRouterId, route.getId(), requestId, uniqueRequestId, managerRequestId, false, IMediaRouterServiceExt.ERROR_MANAGER_RECORD_NOT_FOUND);
        routerRecord.notifySessionCreationFailed(requestId);
        return;
    L33:
        userHandler2 = userHandler;
        String defaultRouteId = UserHandler.m5588$$Nest$mgetSystemProvider(userHandler2).getDefaultRoute().getId();
        if (route.isSystemRoute() == false) goto L44;
        if (routerRecord.hasSystemRoutingPermission() == true) goto L44;
        if (TextUtils.equals(route.getId(), defaultRouteId) == true) goto L44;
        Slog.w(TAG, "MODIFY_AUDIO_ROUTING permission is required to transfer to" + route);
        mMediaRouterMetricLogger.logOperationFailure(1, 9);
        r0.mExt.requestCreateSessionWithRouter2Locked_onStart(0, Binder.getCallingUid(), r0.mCurrentActiveUserId, routerRecord.mPackageName, routerRecord.mRouterId, route.getId(), requestId, uniqueRequestId, managerRequestId, false, IMediaRouterServiceExt.ERROR_PERMISSION_DENIED);
        routerRecord.notifySessionCreationFailed(requestId);
        return;
    L44:
        route3 = route;
        goto L45
    }

    private void selectRouteWithRouter2Locked(IMediaRouter2 router, String uniqueSessionId, MediaRoute2Info route) {
        IBinder binder = router.asBinder();
        RouterRecord routerRecord = this.mAllRouterRecords.get(binder);
        if (routerRecord != null) goto L6;
        mMediaRouterMetricLogger.logOperationFailure(4, 17);
        this.mExt.selectRouteWithRouter2Locked_onStart(0, Binder.getCallingUid(), this.mCurrentActiveUserId, "", uniqueSessionId, route.getId(), -1, false, IMediaRouterServiceExt.ERROR_ROUTER_RECORD_NOT_FOUND);
        return;
    L6:
        Slog.i(TAG, TextUtils.formatSimple("selectRouteWithRouter2 | router: %s(id: %d), route: %s", new Object[]{routerRecord.mPackageName, Integer.valueOf(routerRecord.mRouterId), route.getId()}));
        this.mExt.selectRouteWithRouter2Locked_onStart(2, Binder.getCallingUid(), this.mCurrentActiveUserId, routerRecord.mPackageName, uniqueSessionId, route.getId(), routerRecord.mRouterId, true, null);
        mMediaRouterMetricLogger.logOperationTriggered(4, 0);
        routerRecord.mUserRecord.mHandler.sendMessage(PooledLambda.obtainMessage(new MediaRouter2ServiceImpl$$ExternalSyntheticLambda0(), routerRecord.mUserRecord.mHandler, -1L, routerRecord, uniqueSessionId, route));
    }

    private void deselectRouteWithRouter2Locked(IMediaRouter2 router, String uniqueSessionId, MediaRoute2Info route) {
        IBinder binder = router.asBinder();
        RouterRecord routerRecord = this.mAllRouterRecords.get(binder);
        if (routerRecord != null) goto L6;
        mMediaRouterMetricLogger.logOperationFailure(5, 17);
        this.mExt.deselectRouteWithRouter2Locked_onStart(0, Binder.getCallingUid(), this.mCurrentActiveUserId, "", uniqueSessionId, route.getId(), -1, false, IMediaRouterServiceExt.ERROR_ROUTER_RECORD_NOT_FOUND);
        return;
    L6:
        Slog.i(TAG, TextUtils.formatSimple("deselectRouteWithRouter2 | router: %s(id: %d), route: %s", new Object[]{routerRecord.mPackageName, Integer.valueOf(routerRecord.mRouterId), route.getId()}));
        this.mExt.deselectRouteWithRouter2Locked_onStart(2, Binder.getCallingUid(), this.mCurrentActiveUserId, routerRecord.mPackageName, uniqueSessionId, route.getId(), routerRecord.mRouterId, true, null);
        mMediaRouterMetricLogger.logOperationTriggered(5, 0);
        routerRecord.mUserRecord.mHandler.sendMessage(PooledLambda.obtainMessage(new MediaRouter2ServiceImpl$$ExternalSyntheticLambda3(), routerRecord.mUserRecord.mHandler, -1L, routerRecord, uniqueSessionId, route));
    }

    private void transferToRouteWithRouter2Locked(IMediaRouter2 router, UserHandle transferInitiatorUserHandle, String uniqueSessionId, MediaRoute2Info route) {
        IBinder binder = router.asBinder();
        RouterRecord routerRecord = this.mAllRouterRecords.get(binder);
        if (routerRecord != null) goto L6;
        mMediaRouterMetricLogger.logOperationFailure(6, 17);
        this.mExt.transferToRouteWithRouter2Locked_onStart(0, Binder.getCallingUid(), this.mCurrentActiveUserId, "", uniqueSessionId, route.getId(), -1, false, IMediaRouterServiceExt.ERROR_ROUTER_RECORD_NOT_FOUND);
        return;
    L6:
        Slog.i(TAG, TextUtils.formatSimple("transferToRouteWithRouter2 | router: %s(id: %d), route: %s", new Object[]{routerRecord.mPackageName, Integer.valueOf(routerRecord.mRouterId), route.getId()}));
        mMediaRouterMetricLogger.logOperationTriggered(6, 0);
        UserHandler userHandler = routerRecord.mUserRecord.mHandler;
        String defaultRouteId = UserHandler.m5588$$Nest$mgetSystemProvider(userHandler).getDefaultRoute().getId();
        if (route.isSystemRoute() == true) goto L9;
    L13:
        this.mExt.transferToRouteWithRouter2Locked_onStart(2, Binder.getCallingUid(), this.mCurrentActiveUserId, routerRecord.mPackageName, uniqueSessionId, route.getId(), routerRecord.mRouterId, true, null);
        userHandler.sendMessage(PooledLambda.obtainMessage(new MediaRouter2ServiceImpl$$ExternalSyntheticLambda14(), userHandler, -1L, transferInitiatorUserHandle, routerRecord.mPackageName, routerRecord, uniqueSessionId, route, 2));
        return;
    L9:
        if (routerRecord.hasSystemRoutingPermission() == true) goto L13;
        if (TextUtils.equals(route.getId(), defaultRouteId) == true) goto L13;
        this.mExt.transferToRouteWithRouter2Locked_onStart(2, Binder.getCallingUid(), this.mCurrentActiveUserId, routerRecord.mPackageName, uniqueSessionId, route.getId(), routerRecord.mRouterId, false, IMediaRouterServiceExt.ERROR_PERMISSION_DENIED);
        userHandler.sendMessage(PooledLambda.obtainMessage(new MediaRouter2ServiceImpl$$ExternalSyntheticLambda13(), routerRecord, Integer.valueOf(toOriginalRequestId(-1))));
    }

    private void setSessionVolumeWithRouter2Locked(IMediaRouter2 router, String uniqueSessionId, int volume) {
        IBinder binder = router.asBinder();
        RouterRecord routerRecord = this.mAllRouterRecords.get(binder);
        if (routerRecord != null) goto L5;
        return;
    L5:
        Slog.i(TAG, TextUtils.formatSimple("setSessionVolumeWithRouter2 | router: %s(id: %d), session: %s, volume: %d", new Object[]{routerRecord.mPackageName, Integer.valueOf(routerRecord.mRouterId), uniqueSessionId, Integer.valueOf(volume)}));
        routerRecord.mUserRecord.mHandler.sendMessage(PooledLambda.obtainMessage(new MediaRouter2ServiceImpl$$ExternalSyntheticLambda10(), routerRecord.mUserRecord.mHandler, -1L, uniqueSessionId, Integer.valueOf(volume)));
    }

    private void releaseSessionWithRouter2Locked(IMediaRouter2 router, String uniqueSessionId) {
        IBinder binder = router.asBinder();
        RouterRecord routerRecord = this.mAllRouterRecords.get(binder);
        if (routerRecord != null) goto L6;
        mMediaRouterMetricLogger.logOperationFailure(3, 17);
        this.mExt.releaseSessionWithRouter2Locked_onStart(0, Binder.getCallingUid(), this.mCurrentActiveUserId, "", uniqueSessionId, -1, false, IMediaRouterServiceExt.ERROR_ROUTER_RECORD_NOT_FOUND);
        return;
    L6:
        Slog.i(TAG, TextUtils.formatSimple("releaseSessionWithRouter2 | router: %s(id: %d), session: %s", new Object[]{routerRecord.mPackageName, Integer.valueOf(routerRecord.mRouterId), uniqueSessionId}));
        this.mExt.releaseSessionWithRouter2Locked_onStart(3, Binder.getCallingUid(), this.mCurrentActiveUserId, routerRecord.mPackageName, uniqueSessionId, routerRecord.mRouterId, true, null);
        routerRecord.mUserRecord.mHandler.sendMessage(PooledLambda.obtainMessage(new MediaRouter2ServiceImpl$$ExternalSyntheticLambda7(), routerRecord.mUserRecord.mHandler, -1L, routerRecord, uniqueSessionId));
    }

    private void setDeviceSuggestionsWithRouter2Locked(IMediaRouter2 router, List<SuggestedDeviceInfo> suggestedDeviceInfo) {
        IBinder binder = router.asBinder();
        RouterRecord routerRecord = this.mAllRouterRecords.get(binder);
        if (routerRecord != null) goto L6;
        Slog.w(TAG, TextUtils.formatSimple("Ignoring set device suggestion for unknown router: %s", new Object[]{router}));
        return;
    L6:
        Slog.i(TAG, TextUtils.formatSimple("setDeviceSuggestions | router: %d suggestion: %d", new Object[]{routerRecord.mPackageName, suggestedDeviceInfo}));
        routerRecord.mUserRecord.updateDeviceSuggestionsLocked(routerRecord.mPackageName, routerRecord.mPackageName, suggestedDeviceInfo);
        routerRecord.mUserRecord.mHandler.sendMessage(PooledLambda.obtainMessage(new MediaRouter2ServiceImpl$$ExternalSyntheticLambda8(), routerRecord.mUserRecord.mHandler, routerRecord.mPackageName, routerRecord.mPackageName, suggestedDeviceInfo));
    }

    private Map<String, List<SuggestedDeviceInfo>> getDeviceSuggestionsWithRouter2Locked(IMediaRouter2 router) {
        IBinder binder = router.asBinder();
        RouterRecord routerRecord = this.mAllRouterRecords.get(binder);
        if (routerRecord != null) goto L6;
        Slog.w(TAG, TextUtils.formatSimple("Attempted to get device suggestion for unknown router: %s", new Object[]{router}));
        return null;
    L6:
        Slog.i(TAG, TextUtils.formatSimple("getDeviceSuggestions | router: %d", new Object[]{routerRecord.mPackageName}));
        return routerRecord.mUserRecord.getDeviceSuggestionsLocked(routerRecord.mPackageName);
    }

    private List<RoutingSessionInfo> getRemoteSessionsLocked(IMediaRouter2Manager manager) {
        IBinder binder = manager.asBinder();
        ManagerRecord managerRecord = this.mAllManagerRecords.get(binder);
        if (managerRecord != null) goto L6;
        Slog.w(TAG, "getRemoteSessionLocked: Ignoring unknown manager");
        return Collections.emptyList();
    L6:
        List<RoutingSessionInfo> sessionInfos = new ArrayList();
        Iterator r3 = UserHandler.m5586$$Nest$fgetmRouteProviders(managerRecord.mUserRecord.mHandler).iterator();
    L8:
        if (r3.hasNext() == false) goto L13;
        MediaRoute2Provider provider = (MediaRoute2Provider) r3.next();
        if (provider.mIsSystemRouteProvider == true) goto L8;
        sessionInfos.addAll(provider.getSessionInfos());
        goto L8
    L13:
        return sessionInfos;
    }

    private void registerManagerLocked(IMediaRouter2Manager manager, int callerUid, int callerPid, String callerPackageName, String targetPackageName, UserHandle targetUser) {
        IBinder binder = manager.asBinder();
        if (this.mAllManagerRecords.get(binder) == null) goto L6;
        Slog.w(TAG, "registerManagerLocked: Same manager already exists. callerPackageName=" + callerPackageName);
        return;
    L6:
        boolean hasMediaRoutingControl = checkMediaRoutingControlPermission(callerUid, callerPid, callerPackageName);
        boolean hasMediaContentControl = checkMediaContentControlPermission(callerUid, callerPid);
        Slog.i(TAG, TextUtils.formatSimple("registerManager | callerUid: %d, callerPid: %d, callerPackage: %s, targetPackageName: %s, targetUserId: %d, hasMediaRoutingControl: %b", new Object[]{Integer.valueOf(callerUid), Integer.valueOf(callerPid), callerPackageName, targetPackageName, targetUser, Boolean.valueOf(hasMediaRoutingControl)}));
        UserRecord userRecord = getOrCreateUserRecordLocked(targetUser.getIdentifier());
        ManagerRecord managerRecord = new ManagerRecord(this, userRecord, manager, callerUid, callerPid, callerPackageName, targetPackageName, hasMediaRoutingControl, hasMediaContentControl);
        binder.linkToDeath(managerRecord, 0);     // Catch: RemoteException -> L14
        userRecord.mManagerRecords.add(managerRecord);
        this.mAllManagerRecords.put(binder, managerRecord);
        Iterator<RouterRecord> r0 = userRecord.mRouterRecords.iterator();
    L10:
        if (r0.hasNext() == false) goto L12;
        RouterRecord routerRecord = r0.next();
        userRecord.mHandler.sendMessage(PooledLambda.obtainMessage(new MediaRouter2ServiceImpl$$ExternalSyntheticLambda5(), routerRecord.mUserRecord.mHandler, routerRecord.mPackageName, routerRecord.mRouteListingPreference));
        routerRecord.mUserRecord.mHandler.sendMessage(PooledLambda.obtainMessage(new MediaRouter2ServiceImpl$$ExternalSyntheticLambda19(), routerRecord.mUserRecord.mHandler, routerRecord, manager));
        goto L10
    L12:
        userRecord.mHandler.sendMessage(PooledLambda.obtainMessage(new MediaRouter2ServiceImpl$$ExternalSyntheticLambda20(), userRecord.mHandler, managerRecord));
        return;
    L14:
        ex = move-exception;
        throw new RuntimeException("Media router manager died prematurely.", ex);
    }

    private void unregisterManagerLocked(IMediaRouter2Manager manager, boolean died) {
        ManagerRecord managerRecord = this.mAllManagerRecords.remove(manager.asBinder());
        if (managerRecord != null) goto L6;
        Slog.w(TAG, TextUtils.formatSimple("Ignoring unregistering unknown manager: %s, died: %b", new Object[]{manager, Boolean.valueOf(died)}));
        return;
    L6:
        UserRecord userRecord = managerRecord.mUserRecord;
        Slog.i(TAG, TextUtils.formatSimple("unregisterManager | package: %s, user: %d, manager: %d, died: %b", new Object[]{managerRecord.mOwnerPackageName, Integer.valueOf(userRecord.mUserId), Integer.valueOf(managerRecord.mManagerId), Boolean.valueOf(died)}));
        userRecord.mManagerRecords.remove(managerRecord);
        managerRecord.dispose();
        disposeUserIfNeededLocked(userRecord);
    }

    private void updateScanningStateLocked(IMediaRouter2Manager manager, int scanningState) {
        IBinder binder = manager.asBinder();
        ManagerRecord managerRecord = this.mAllManagerRecords.get(binder);
        if (managerRecord != null) goto L7;
        Slog.w(TAG, "Manager record not found. Ignoring updateScanningState call.");
        return;
    L7:
        if (managerRecord.mHasMediaContentControl == false) goto L9;
        boolean enableScanViaMediaContentControl = true;
    L11:
        if (managerRecord.mHasMediaRoutingControl == true) goto L18;
        if (enableScanViaMediaContentControl == true) goto L18;
        if (scanningState != 2) goto L18;
        throw new SecurityException("Screen off scan requires MEDIA_ROUTING_CONTROL");
    L18:
        Slog.i(TAG, TextUtils.formatSimple("updateScanningState | manager: %d, ownerPackageName: %s, targetPackageName: %s, scanningState: %d", new Object[]{Integer.valueOf(managerRecord.mManagerId), managerRecord.mOwnerPackageName, managerRecord.mTargetPackageName, getScanningStateString(scanningState)}));
        ManagerRecord.m5580$$Nest$mupdateScanningState(managerRecord, scanningState);
        return;
    L9:
        enableScanViaMediaContentControl = false;
        goto L11
    }

    private void setRouteVolumeWithManagerLocked(int requestId, IMediaRouter2Manager manager, MediaRoute2Info route, int volume) {
        IBinder binder = manager.asBinder();
        ManagerRecord managerRecord = this.mAllManagerRecords.get(binder);
        if (managerRecord != null) goto L5;
        return;
    L5:
        Slog.i(TAG, TextUtils.formatSimple("setRouteVolumeWithManager | manager: %d, route: %s, volume: %d", new Object[]{Integer.valueOf(managerRecord.mManagerId), route.getId(), Integer.valueOf(volume)}));
        long uniqueRequestId = toUniqueRequestId(managerRecord.mManagerId, requestId);
        managerRecord.mUserRecord.mHandler.sendMessage(PooledLambda.obtainMessage(new MediaRouter2ServiceImpl$$ExternalSyntheticLambda2(), managerRecord.mUserRecord.mHandler, Long.valueOf(uniqueRequestId), route, Integer.valueOf(volume)));
    }

    private void requestCreateSessionWithManagerLocked(int requestId, IMediaRouter2Manager manager, RoutingSessionInfo oldSession, MediaRoute2Info route) {
        ManagerRecord managerRecord = this.mAllManagerRecords.get(manager.asBinder());
        if (managerRecord != null) goto L5;
        return;
    L5:
        Slog.i(TAG, TextUtils.formatSimple("requestCreateSessionWithManager | manager: %d, route: %s", new Object[]{Integer.valueOf(managerRecord.mManagerId), route.getId()}));
        String packageName = oldSession.getClientPackageName();
        RouterRecord routerRecord = managerRecord.mUserRecord.findRouterRecordLocked(packageName);
        if (routerRecord != null) goto L9;
        Slog.w(TAG, "requestCreateSessionWithManagerLocked: Ignoring session creation for unknown router.");
        managerRecord.notifyRequestFailed(requestId, 0);
        return;
    L9:
        long uniqueRequestId = toUniqueRequestId(managerRecord.mManagerId, requestId);
        SessionCreationRequest lastRequest = managerRecord.mLastSessionCreationRequest;
        if (lastRequest == null) goto L12;
        Slog.i(TAG, TextUtils.formatSimple("requestCreateSessionWithManagerLocked: Notifying failure for pending session creation request - oldSession: %s, route: %s", new Object[]{lastRequest.mOldSession, lastRequest.mRoute}));
        managerRecord.notifyRequestFailed(toOriginalRequestId(lastRequest.mManagerRequestId), 0);
    L12:
        managerRecord.mLastSessionCreationRequest = new SessionCreationRequest(routerRecord, 0, uniqueRequestId, oldSession, route);
        routerRecord.mUserRecord.mHandler.sendMessage(PooledLambda.obtainMessage(new MediaRouter2ServiceImpl$$ExternalSyntheticLambda1(), routerRecord, managerRecord, Long.valueOf(uniqueRequestId), oldSession, route));
    }

    private void selectRouteWithManagerLocked(int requestId, IMediaRouter2Manager manager, String uniqueSessionId, MediaRoute2Info route) {
        IBinder binder = manager.asBinder();
        ManagerRecord managerRecord = this.mAllManagerRecords.get(binder);
        if (managerRecord != null) goto L5;
        return;
    L5:
        Slog.i(TAG, TextUtils.formatSimple("selectRouteWithManager | manager: %d, session: %s, route: %s", new Object[]{Integer.valueOf(managerRecord.mManagerId), uniqueSessionId, route.getId()}));
        RouterRecord routerRecord = managerRecord.mUserRecord.mHandler.findRouterWithSessionLocked(uniqueSessionId);
        long uniqueRequestId = toUniqueRequestId(managerRecord.mManagerId, requestId);
        mMediaRouterMetricLogger.addRequestInfo(uniqueRequestId, 4);
        managerRecord.mUserRecord.mHandler.sendMessage(PooledLambda.obtainMessage(new MediaRouter2ServiceImpl$$ExternalSyntheticLambda0(), managerRecord.mUserRecord.mHandler, Long.valueOf(uniqueRequestId), routerRecord, uniqueSessionId, route));
    }

    private void deselectRouteWithManagerLocked(int requestId, IMediaRouter2Manager manager, String uniqueSessionId, MediaRoute2Info route) {
        IBinder binder = manager.asBinder();
        ManagerRecord managerRecord = this.mAllManagerRecords.get(binder);
        if (managerRecord != null) goto L5;
        return;
    L5:
        Slog.i(TAG, TextUtils.formatSimple("deselectRouteWithManager | manager: %d, session: %s, route: %s", new Object[]{Integer.valueOf(managerRecord.mManagerId), uniqueSessionId, route.getId()}));
        RouterRecord routerRecord = managerRecord.mUserRecord.mHandler.findRouterWithSessionLocked(uniqueSessionId);
        long uniqueRequestId = toUniqueRequestId(managerRecord.mManagerId, requestId);
        mMediaRouterMetricLogger.addRequestInfo(uniqueRequestId, 5);
        managerRecord.mUserRecord.mHandler.sendMessage(PooledLambda.obtainMessage(new MediaRouter2ServiceImpl$$ExternalSyntheticLambda3(), managerRecord.mUserRecord.mHandler, Long.valueOf(uniqueRequestId), routerRecord, uniqueSessionId, route));
    }

    private void transferToRouteWithManagerLocked(int requestId, IMediaRouter2Manager manager, String uniqueSessionId, MediaRoute2Info route, int transferReason, UserHandle transferInitiatorUserHandle, String transferInitiatorPackageName) {
        IBinder binder = manager.asBinder();
        ManagerRecord managerRecord = this.mAllManagerRecords.get(binder);
        if (managerRecord != null) goto L5;
        return;
    L5:
        Slog.i(TAG, TextUtils.formatSimple("transferToRouteWithManager | manager: %d, session: %s, route: %s", new Object[]{Integer.valueOf(managerRecord.mManagerId), uniqueSessionId, route.getId()}));
        RouterRecord routerRecord = managerRecord.mUserRecord.mHandler.findRouterWithSessionLocked(uniqueSessionId);
        long uniqueRequestId = toUniqueRequestId(managerRecord.mManagerId, requestId);
        mMediaRouterMetricLogger.addRequestInfo(uniqueRequestId, 6);
        managerRecord.mUserRecord.mHandler.sendMessage(PooledLambda.obtainMessage(new MediaRouter2ServiceImpl$$ExternalSyntheticLambda14(), managerRecord.mUserRecord.mHandler, Long.valueOf(uniqueRequestId), transferInitiatorUserHandle, transferInitiatorPackageName, routerRecord, uniqueSessionId, route, Integer.valueOf(transferReason)));
    }

    private void setSessionVolumeWithManagerLocked(int requestId, IMediaRouter2Manager manager, String uniqueSessionId, int volume) {
        IBinder binder = manager.asBinder();
        ManagerRecord managerRecord = this.mAllManagerRecords.get(binder);
        if (managerRecord != null) goto L5;
        return;
    L5:
        Slog.i(TAG, TextUtils.formatSimple("setSessionVolumeWithManager | manager: %d, session: %s, volume: %d", new Object[]{Integer.valueOf(managerRecord.mManagerId), uniqueSessionId, Integer.valueOf(volume)}));
        long uniqueRequestId = toUniqueRequestId(managerRecord.mManagerId, requestId);
        managerRecord.mUserRecord.mHandler.sendMessage(PooledLambda.obtainMessage(new MediaRouter2ServiceImpl$$ExternalSyntheticLambda10(), managerRecord.mUserRecord.mHandler, Long.valueOf(uniqueRequestId), uniqueSessionId, Integer.valueOf(volume)));
    }

    private void releaseSessionWithManagerLocked(int requestId, IMediaRouter2Manager manager, String uniqueSessionId) {
        IBinder binder = manager.asBinder();
        ManagerRecord managerRecord = this.mAllManagerRecords.get(binder);
        if (managerRecord != null) goto L5;
        return;
    L5:
        Slog.i(TAG, TextUtils.formatSimple("releaseSessionWithManager | manager: %d, session: %s", new Object[]{Integer.valueOf(managerRecord.mManagerId), uniqueSessionId}));
        RouterRecord routerRecord = managerRecord.mUserRecord.mHandler.findRouterWithSessionLocked(uniqueSessionId);
        long uniqueRequestId = toUniqueRequestId(managerRecord.mManagerId, requestId);
        managerRecord.mUserRecord.mHandler.sendMessage(PooledLambda.obtainMessage(new MediaRouter2ServiceImpl$$ExternalSyntheticLambda7(), managerRecord.mUserRecord.mHandler, Long.valueOf(uniqueRequestId), routerRecord, uniqueSessionId));
    }

    private void setDeviceSuggestionsWithManagerLocked(IMediaRouter2Manager manager, List<SuggestedDeviceInfo> suggestedDeviceInfo) {
        IBinder binder = manager.asBinder();
        ManagerRecord managerRecord = this.mAllManagerRecords.get(binder);
        if (managerRecord != null) goto L5;
    L9:
        Slog.w(TAG, TextUtils.formatSimple("Ignoring set device suggestion for unknown manager: %s", new Object[]{manager}));
        return;
    L5:
        if (managerRecord.mTargetPackageName == null) goto L9;
        Slog.i(TAG, TextUtils.formatSimple("setDeviceSuggestions | manager: %d, suggestingPackageName: %d suggestion: %d", new Object[]{Integer.valueOf(managerRecord.mManagerId), managerRecord.mOwnerPackageName, suggestedDeviceInfo}));
        managerRecord.mUserRecord.updateDeviceSuggestionsLocked(managerRecord.mTargetPackageName, managerRecord.mOwnerPackageName, suggestedDeviceInfo);
        managerRecord.mUserRecord.mHandler.sendMessage(PooledLambda.obtainMessage(new MediaRouter2ServiceImpl$$ExternalSyntheticLambda8(), managerRecord.mUserRecord.mHandler, managerRecord.mTargetPackageName, managerRecord.mOwnerPackageName, suggestedDeviceInfo));
    }

    private Map<String, List<SuggestedDeviceInfo>> getDeviceSuggestionsWithManagerLocked(IMediaRouter2Manager manager) {
        IBinder binder = manager.asBinder();
        ManagerRecord managerRecord = this.mAllManagerRecords.get(binder);
        if (managerRecord != null) goto L5;
    L9:
        Slog.w(TAG, TextUtils.formatSimple("Attempted to get device suggestion for unknown manager: %s", new Object[]{manager}));
        return null;
    L5:
        if (managerRecord.mTargetPackageName == null) goto L9;
        Slog.i(TAG, TextUtils.formatSimple("getDeviceSuggestionsWithManagerLocked | manager: %d", new Object[]{Integer.valueOf(managerRecord.mManagerId)}));
        return managerRecord.mUserRecord.getDeviceSuggestionsLocked(managerRecord.mTargetPackageName);
    }

    private UserRecord getOrCreateUserRecordLocked(int userId) {
        UserRecord userRecord = this.mUserRecords.get(userId);
        if (userRecord != null) goto L7;
        userRecord = new UserRecord(this, userId, this.mLooper);
        this.mUserRecords.put(userId, userRecord);
        userRecord.init();
        if (isUserActiveLocked(userId) == false) goto L7;
        userRecord.mHandler.sendMessage(PooledLambda.obtainMessage(new MediaRouter2ServiceImpl$$ExternalSyntheticLambda22(), userRecord.mHandler));
    L7:
        return userRecord;
    }

    private void disposeUserIfNeededLocked(UserRecord userRecord) {
        if (isUserActiveLocked(userRecord.mUserId) == false) goto L5;
        return;
    L5:
        if (userRecord.mRouterRecords.isEmpty() == true) goto L7;
        return;
    L7:
        if (userRecord.mManagerRecords.isEmpty() == true) goto L9;
        return;
    L9:
        if (DEBUG == false) goto L11;
        Slog.d(TAG, userRecord + ": Disposed");
    L11:
        userRecord.mHandler.sendMessage(PooledLambda.obtainMessage(new MediaRouter2ServiceImpl$$ExternalSyntheticLambda21(), userRecord.mHandler));
        this.mUserRecords.remove(userRecord.mUserId);
    }

    static long toUniqueRequestId(int requesterId, int originalRequestId) {
        return (((long) requesterId) << 32) | ((long) originalRequestId);
    }

    static int toRequesterId(long uniqueRequestId) {
        return (int) (uniqueRequestId >> 32);
    }

    static int toOriginalRequestId(long uniqueRequestId) {
        return (int) uniqueRequestId;
    }

    private static String getScanningStateString(int scanningState) {
        switch(scanningState) {
            case 0: goto L6;
            case 1: goto L5;
            case 2: goto L4;
            default: goto L8;
        };
    L4:
        return "FULL";
    L5:
        return "SCREEN_ON_ONLY";
    L6:
        return "NOT_SCANNING";
    L8:
        return "Invalid scanning state: " + scanningState;
    }

    private static void validateScanningStateValue(int scanningState) {
        if (scanningState != 0) goto L4;
        return;
    L4:
        if (scanningState != 1) goto L6;
        return;
    L6:
        if (scanningState != 2) goto L9;
        return;
    L9:
        throw new IllegalArgumentException(TextUtils.formatSimple("Scanning state %d is not valid.", new Object[]{Integer.valueOf(scanningState)}));
    }
}
