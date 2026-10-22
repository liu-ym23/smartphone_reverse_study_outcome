package com.android.server.wm;

import android.hardware.camera2.CameraManager;
import android.os.Handler;
import android.util.ArraySet;
import android.util.Slog;
import com.android.internal.protolog.ProtoLogImpl_798997914;
import com.android.internal.protolog.WmProtoLogGroups;
import com.android.server.ISmtResourceControl;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
class CameraStateMonitor {
    private static final int CAMERA_CLOSED_LETTERBOX_UPDATE_DELAY_MS = 2000;
    private static final int CAMERA_OPENED_LETTERBOX_UPDATE_DELAY_MS = 1000;
    private static final String TAG = "WindowManager";
    private final CameraManager.AvailabilityCallback mAvailabilityCallback;
    private final CameraIdPackageNameBiMapping mCameraIdPackageBiMapping;
    private final CameraManager mCameraManager;
    private final ArrayList<CameraCompatStateListener> mCameraStateListeners;
    private final DisplayContent mDisplayContent;
    private final Handler mHandler;
    private boolean mIsRunning;
    private final Set<String> mScheduledCompatModeUpdateCameraIdSet;
    private final Set<String> mScheduledToBeRemovedCameraIdSet;
    private final WindowManagerService mWmService;

    interface CameraCompatStateListener {
        boolean canCameraBeClosed(String r1);

        void onCameraClosed();

        void onCameraOpened(ActivityRecord r1);
    }

    public static /* synthetic */ void $r8$lambda$Sx_Pw105YKRcPHfVXUbFh0gANaw(CameraStateMonitor r0, String r1) {
        r0.lambda$scheduleRemoveCameraId$1(r1);
    }

    public static /* synthetic */ void $r8$lambda$V8nUmQymT5WLbcPRpXx3WqcGirI(CameraStateMonitor r0, String r1, String r2) {
        r0.lambda$notifyCameraOpenedWithDelay$0(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$grNRDeY7_yfA2jFaLh_oaaHYMjA(String r0, List r1, ActivityRecord r2) {
        lambda$findUniqueActivityWithPackageName$2(r0, r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmWmService, reason: not valid java name */
    static /* bridge */ /* synthetic */ WindowManagerService m9849$$Nest$fgetmWmService(CameraStateMonitor r0) {
        return r0.mWmService;
    }

    /* JADX INFO: renamed from: -$$Nest$mnotifyCameraClosedWithDelay, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9850$$Nest$mnotifyCameraClosedWithDelay(CameraStateMonitor r0, String r1) {
        r0.notifyCameraClosedWithDelay(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mnotifyCameraOpenedWithDelay, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9851$$Nest$mnotifyCameraOpenedWithDelay(CameraStateMonitor r0, String r1, String r2) {
        r0.notifyCameraOpenedWithDelay(r1, r2);
    }

    CameraStateMonitor(DisplayContent displayContent, Handler handler) {
        this.mCameraIdPackageBiMapping = new CameraIdPackageNameBiMapping();
        this.mScheduledToBeRemovedCameraIdSet = new ArraySet();
        this.mScheduledCompatModeUpdateCameraIdSet = new ArraySet();
        this.mCameraStateListeners = new ArrayList();
        this.mAvailabilityCallback = new AnonymousClass1(this);
        this.mHandler = handler;
        this.mDisplayContent = displayContent;
        this.mWmService = displayContent.mWmService;
        this.mCameraManager = (CameraManager) this.mWmService.mContext.getSystemService(CameraManager.class);
    }

    void startListeningToCameraState() {
        if (this.mCameraManager == null) goto L5;
        this.mCameraManager.registerAvailabilityCallback(this.mWmService.mContext.getMainExecutor(), this.mAvailabilityCallback);
    L5:
        this.mIsRunning = true;
    }

    void dispose() {
        if (this.mCameraManager == null) goto L5;
        this.mCameraManager.unregisterAvailabilityCallback(this.mAvailabilityCallback);
    L5:
        this.mIsRunning = false;
    }

    boolean isRunning() {
        return this.mIsRunning;
    }

    void addCameraStateListener(CameraCompatStateListener listener) {
        this.mCameraStateListeners.add(listener);
    }

    void removeCameraStateListener(CameraCompatStateListener listener) {
        this.mCameraStateListeners.remove(listener);
    }

    private void notifyCameraOpenedWithDelay(final String cameraId, final String packageName) {
        this.mScheduledToBeRemovedCameraIdSet.remove(cameraId);
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_STATES_enabled[1] == false) goto L5;
        long protoLogParam0 = this.mDisplayContent.mDisplayId;
        String protoLogParam1 = String.valueOf(cameraId);
        String protoLogParam2 = String.valueOf(packageName);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_STATES, 8116030277393789125L, 1, new Object[]{Long.valueOf(protoLogParam0), protoLogParam1, protoLogParam2});
    L5:
        this.mScheduledCompatModeUpdateCameraIdSet.add(cameraId);
        this.mHandler.postDelayed(new CameraStateMonitor$$ExternalSyntheticLambda0(this, cameraId, packageName), 1000);
    }

    private /* synthetic */ void lambda$notifyCameraOpenedWithDelay$0(String cameraId, String packageName) {
        notifyCameraOpenedInternal(cameraId, packageName);
    }

    private void notifyCameraOpenedInternal(String cameraId, String packageName) {
        WindowManagerGlobalLock r0 = this.mWmService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
    L9:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    L5:
        if (this.mScheduledCompatModeUpdateCameraIdSet.remove(cameraId) == true) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L11:
        this.mCameraIdPackageBiMapping.put(packageName, cameraId);     // Catch: Throwable -> L9
        ActivityRecord cameraActivity = findUniqueActivityWithPackageName(packageName);     // Catch: Throwable -> L9
        if (cameraActivity == null) goto L20;
        if (cameraActivity.getTask() == null) goto L20;
        notifyListenersCameraOpened(cameraActivity);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L20:
        monitor-exit(r0);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
    }

    private void notifyListenersCameraOpened(ActivityRecord cameraActivity) {
        int i = 0;
    L4:
        if (i >= this.mCameraStateListeners.size()) goto L7;
        CameraCompatStateListener listener = this.mCameraStateListeners.get(i);
        listener.onCameraOpened(cameraActivity);
        i = i + 1;
        goto L4
    }

    private void notifyCameraClosedWithDelay(String cameraId) {
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_STATES_enabled[1] == false) goto L5;
        long protoLogParam0 = this.mDisplayContent.mDisplayId;
        String protoLogParam1 = String.valueOf(cameraId);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_STATES, -3774458166471278611L, 1, new Object[]{Long.valueOf(protoLogParam0), protoLogParam1});
    L5:
        this.mScheduledToBeRemovedCameraIdSet.add(cameraId);
        this.mScheduledCompatModeUpdateCameraIdSet.remove(cameraId);
        scheduleRemoveCameraId(cameraId);
    }

    boolean isCameraRunningForActivity(ActivityRecord activity) {
        if (getCameraIdForActivity(activity) == null) goto L5;
        return true;
    L5:
        return false;
    }

    boolean isCameraWithIdRunningForActivity(ActivityRecord activity, String cameraId) {
        return cameraId.equals(getCameraIdForActivity(activity));
    }

    void rescheduleRemoveCameraActivity(String cameraId) {
        this.mScheduledToBeRemovedCameraIdSet.add(cameraId);
        scheduleRemoveCameraId(cameraId);
    }

    private String getCameraIdForActivity(ActivityRecord activity) {
        return this.mCameraIdPackageBiMapping.getCameraId(activity.packageName);
    }

    private void scheduleRemoveCameraId(final String cameraId) {
        this.mHandler.postDelayed(new CameraStateMonitor$$ExternalSyntheticLambda2(this, cameraId), ISmtResourceControl.LAUNCH_CPUSET_EFFECTIVE_TIME);
    }

    private /* synthetic */ void lambda$scheduleRemoveCameraId$1(String cameraId) {
        removeCameraId(cameraId);
    }

    private void removeCameraId(String cameraId) {
        WindowManagerGlobalLock r0 = this.mWmService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
    L9:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    L5:
        if (this.mScheduledToBeRemovedCameraIdSet.remove(cameraId) == true) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L11:
        boolean canClose = checkCanCloseForAllListeners(cameraId);     // Catch: Throwable -> L9
        if (canClose == false) goto L14;
        this.mCameraIdPackageBiMapping.removeCameraId(cameraId);     // Catch: Throwable -> L9
        notifyListenersCameraClosed();     // Catch: Throwable -> L9
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L14:
        rescheduleRemoveCameraActivity(cameraId);     // Catch: Throwable -> L9
        goto L15
    }

    private boolean checkCanCloseForAllListeners(String cameraId) {
        int i = 0;
    L4:
        if (i >= this.mCameraStateListeners.size()) goto L10;
        if (this.mCameraStateListeners.get(i).canCameraBeClosed(cameraId) == false) goto L7;
        i = i + 1;
        goto L4
    L7:
        return false;
    L10:
        return true;
    }

    private void notifyListenersCameraClosed() {
        int i = 0;
    L4:
        if (i >= this.mCameraStateListeners.size()) goto L7;
        this.mCameraStateListeners.get(i).onCameraClosed();
        i = i + 1;
        goto L4
    }

    private ActivityRecord findUniqueActivityWithPackageName(final String packageName) {
        ActivityRecord topActivity = this.mDisplayContent.topRunningActivity(true);
        if (topActivity != null) goto L5;
    L7:
        final List<ActivityRecord> activitiesOfPackageWhichOpenedCamera = new ArrayList();
        this.mDisplayContent.forAllActivities(new CameraStateMonitor$$ExternalSyntheticLambda1(packageName, activitiesOfPackageWhichOpenedCamera));
        if (activitiesOfPackageWhichOpenedCamera.isEmpty() == false) goto L12;
        Slog.w(TAG, "Cannot find camera activity.");
        return null;
    L12:
        if (activitiesOfPackageWhichOpenedCamera.size() == 1) goto L14;
        Slog.w(TAG, "Cannot determine which activity opened camera.");
        return null;
    L14:
        return (ActivityRecord) activitiesOfPackageWhichOpenedCamera.getFirst();
    L5:
        if (topActivity.packageName.equals(packageName) == false) goto L7;
        return topActivity;
    }

    private static /* synthetic */ void lambda$findUniqueActivityWithPackageName$2(String packageName, List activitiesOfPackageWhichOpenedCamera, ActivityRecord activityRecord) {
        if (activityRecord.isVisibleRequested() == true) goto L5;
        return;
    L5:
        if (activityRecord.packageName.equals(packageName) == false) goto L9;
        activitiesOfPackageWhichOpenedCamera.add(activityRecord);
        return;
    }

    String getSummary() {
        return " CameraIdPackageNameBiMapping=" + this.mCameraIdPackageBiMapping.getSummaryForDisplayRotationHistoryRecord();
    }
}
