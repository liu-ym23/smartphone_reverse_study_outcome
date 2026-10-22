package com.android.server.wm;

/* JADX INFO: loaded from: classes3.dex */
class AppCompatDeviceStateQuery {
    final ActivityRecord mActivityRecord;

    AppCompatDeviceStateQuery(ActivityRecord activityRecord) {
        this.mActivityRecord = activityRecord;
    }

    boolean isDisplayFullScreenAndInPosture(boolean isTabletop) {
        Task task = this.mActivityRecord.getTask();
        DisplayContent dc = this.mActivityRecord.mDisplayContent;
        if (dc == null) goto L12;
        if (task == null) goto L12;
        if (dc.inTransition() == true) goto L12;
        if (dc.getDisplayRotation().isDeviceInPosture(DeviceStateController.DeviceState.HALF_FOLDED, isTabletop) == false) goto L12;
        if (task.getWindowingMode() != 1) goto L12;
        return true;
    L12:
        return false;
    }

    boolean isDisplayFullScreenAndSeparatingHinge() {
        Task task = this.mActivityRecord.getTask();
        if (this.mActivityRecord.mDisplayContent == null) goto L10;
        if (task == null) goto L10;
        if (this.mActivityRecord.mDisplayContent.getDisplayRotation().isDisplaySeparatingHinge() == false) goto L10;
        if (task.getWindowingMode() != 1) goto L10;
        return true;
    L10:
        return false;
    }
}
