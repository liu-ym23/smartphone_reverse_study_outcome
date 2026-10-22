package com.android.server.wm;

import android.app.compat.CompatChanges;
import android.view.InputWindowHandle;
import android.view.SurfaceControl;

/* JADX INFO: loaded from: classes3.dex */
class ActivityRecordInputSink {
    static final long ENABLE_OVERLAY_TOUCH_PASS_THROUGH_OPT_IN_ENFORCEMENT = 358129114;
    static final long ENABLE_TOUCH_OPAQUE_ACTIVITIES = 194480991;
    private final ActivityRecord mActivityRecord;
    private InputWindowHandleWrapper mInputWindowHandleWrapper;
    private final boolean mIsCompatEnabled;
    private final String mName;
    private SurfaceControl mSurfaceControl;

    ActivityRecordInputSink(ActivityRecord activityRecord, ActivityRecord sourceRecord, boolean appOptInTouchPassThrough) {
        this.mActivityRecord = activityRecord;
        this.mIsCompatEnabled = CompatChanges.isChangeEnabled(ENABLE_TOUCH_OPAQUE_ACTIVITIES, this.mActivityRecord.getUid());
        this.mName = Integer.toHexString(System.identityHashCode(this)) + " ActivityRecordInputSink " + this.mActivityRecord.mActivityComponent.flattenToShortString();
        if (sourceRecord != null) goto L5;
        return;
    L5:
        boolean isTouchPassThroughOptInEnforced = CompatChanges.isChangeEnabled(ENABLE_OVERLAY_TOUCH_PASS_THROUGH_OPT_IN_ENFORCEMENT, sourceRecord.getUid());
        if (isTouchPassThroughOptInEnforced == false) goto L8;
        if (appOptInTouchPassThrough == true) goto L8;
        return;
    L8:
        sourceRecord.mAllowedTouchUid = this.mActivityRecord.getUid();
    }

    public void applyChangesToSurfaceIfChanged(SurfaceControl.Transaction transaction) {
        InputWindowHandleWrapper inputWindowHandleWrapper = getInputWindowHandleWrapper();
        if (this.mSurfaceControl != null) goto L6;
        this.mSurfaceControl = createSurface(transaction);
    L6:
        if (inputWindowHandleWrapper.isChanged() == false) goto L9;
        inputWindowHandleWrapper.applyChangesToSurface(transaction, this.mSurfaceControl);
        return;
    }

    private SurfaceControl createSurface(SurfaceControl.Transaction t) {
        SurfaceControl surfaceControl = this.mActivityRecord.makeChildSurface(null).setName(this.mName).setHidden(false).setCallsite("ActivityRecordInputSink.createSurface").build();
        t.setLayer(surfaceControl, Integer.MIN_VALUE);
        return surfaceControl;
    }

    private InputWindowHandleWrapper getInputWindowHandleWrapper() {
        if (this.mInputWindowHandleWrapper != null) goto L6;
        this.mInputWindowHandleWrapper = new InputWindowHandleWrapper(createInputWindowHandle());
    L6:
        if (this.mActivityRecord.getTask() == null) goto L8;
        ActivityRecord activityBelowInTask = this.mActivityRecord.getTask().getActivityBelow(this.mActivityRecord);
    L10:
        if (activityBelowInTask != null) goto L12;
    L16:
        boolean allowPassthrough = false;
    L18:
        if (allowPassthrough == false) goto L20;
    L27:
        this.mInputWindowHandleWrapper.setInputConfigMasked(8, 8);
    L28:
        this.mInputWindowHandleWrapper.setDisplayId(this.mActivityRecord.getDisplayId());
        return this.mInputWindowHandleWrapper;
    L20:
        if (this.mIsCompatEnabled == false) goto L27;
        if (this.mActivityRecord.isInTransition() == true) goto L27;
        if (this.mActivityRecord.mActivityRecordInputSinkEnabled == false) goto L27;
        this.mInputWindowHandleWrapper.setInputConfigMasked(0, 8);
        goto L28
    L12:
        if (activityBelowInTask.mAllowedTouchUid != this.mActivityRecord.getUid()) goto L14;
    L15:
        allowPassthrough = true;
        goto L18
    L14:
        if (activityBelowInTask.isUid(this.mActivityRecord.getUid()) == false) goto L16;
    L8:
        activityBelowInTask = null;
        goto L10
    }

    private InputWindowHandle createInputWindowHandle() {
        InputWindowHandle inputWindowHandle = new InputWindowHandle(null, this.mActivityRecord.getDisplayId());
        inputWindowHandle.replaceTouchableRegionWithCrop = true;
        inputWindowHandle.name = this.mName;
        inputWindowHandle.layoutParamsType = 2022;
        inputWindowHandle.ownerPid = WindowManagerService.MY_PID;
        inputWindowHandle.ownerUid = WindowManagerService.MY_UID;
        inputWindowHandle.inputConfig = 5;
        return inputWindowHandle;
    }

    void releaseSurfaceControl() {
        if (this.mSurfaceControl == null) goto L6;
        this.mSurfaceControl.release();
        this.mSurfaceControl = null;
        return;
    }
}
