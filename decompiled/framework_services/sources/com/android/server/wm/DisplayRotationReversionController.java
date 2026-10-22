package com.android.server.wm;

import com.android.internal.protolog.ProtoLogImpl_798997914;
import com.android.internal.protolog.WmProtoLogGroups;

/* JADX INFO: loaded from: classes3.dex */
final class DisplayRotationReversionController {
    private static final int NUM_SLOTS = 3;
    static final int REVERSION_TYPE_CAMERA_COMPAT = 1;
    static final int REVERSION_TYPE_HALF_FOLD = 2;
    static final int REVERSION_TYPE_NOSENSOR = 0;
    private final DisplayContent mDisplayContent;
    private final boolean[] mSlots;
    private int mUserRotationOverridden;

    /* JADX INFO: renamed from: $r8$lambda$04Xwpe7cEnpHVvU4iW5V-c1GVtU, reason: not valid java name */
    public static /* synthetic */ boolean m9982$r8$lambda$04Xwpe7cEnpHVvU4iW5Vc1GVtU(Task r0) {
        return lambda$isTopFullscreenActivityNoSensor$0(r0);
    }

    DisplayRotationReversionController(DisplayContent content) {
        this.mUserRotationOverridden = -1;
        this.mSlots = new boolean[3];
        this.mDisplayContent = content;
    }

    boolean isRotationReversionEnabled() {
        if (this.mDisplayContent.mAppCompatCameraPolicy.hasDisplayRotationCompatPolicy() == false) goto L5;
    L10:
        return true;
    L5:
        if (this.mDisplayContent.getDisplayRotation().mFoldController != null) goto L10;
        if (this.mDisplayContent.getIgnoreOrientationRequest() == true) goto L10;
        return false;
    }

    void beforeOverrideApplied(int slotIndex) {
        if (this.mSlots[slotIndex] == false) goto L5;
        return;
    L5:
        maybeSaveUserRotation();
        this.mSlots[slotIndex] = true;
    }

    boolean isOverrideActive(int slotIndex) {
        return this.mSlots[slotIndex];
    }

    boolean[] getSlotsCopy() {
        if (isRotationReversionEnabled() == true) goto L7;
        return null;
    L7:
        return (boolean[]) this.mSlots.clone();
    }

    void updateForNoSensorOverride() {
        if (this.mSlots[0] == true) goto L11;
        if (isTopFullscreenActivityNoSensor() == true) goto L7;
        return;
    L7:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_ORIENTATION_enabled[1] == false) goto L9;
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_ORIENTATION, -6949326633913532620L, 0, null);
    L9:
        beforeOverrideApplied(0);
        return;
    L11:
        if (isTopFullscreenActivityNoSensor() == false) goto L13;
        return;
    L13:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_ORIENTATION_enabled[1] == false) goto L15;
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_ORIENTATION, -2060428960792625366L, 0, null);
    L15:
        revertOverride(0);
    }

    boolean isAnyOverrideActive() {
        int i = 0;
    L4:
        if (i >= 3) goto L10;
        if (this.mSlots[i] == true) goto L7;
        i = i + 1;
        goto L4
    L7:
        return true;
    L10:
        return false;
    }

    boolean revertOverride(int slotIndex) {
        if (this.mSlots[slotIndex] == true) goto L5;
        return false;
    L5:
        this.mSlots[slotIndex] = false;
        if (isAnyOverrideActive() == true) goto L8;
        DisplayRotation displayRotation = this.mDisplayContent.getDisplayRotation();
        if (this.mUserRotationOverridden != (-1)) goto L14;
    L17:
        return false;
    L14:
        if (displayRotation.getUserRotationMode() != 1) goto L17;
        displayRotation.setUserRotation(1, this.mUserRotationOverridden, "DisplayRotationReversionController#revertOverride");
        this.mUserRotationOverridden = -1;
        return true;
    L8:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_ORIENTATION_enabled[1] == false) goto L10;
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_ORIENTATION, -4296736202875980050L, 0, null);
    L10:
        return false;
    }

    private void maybeSaveUserRotation() {
        DisplayRotation displayRotation = this.mDisplayContent.getDisplayRotation();
        if (isAnyOverrideActive() == false) goto L5;
        return;
    L5:
        if (displayRotation.getUserRotationMode() != 1) goto L9;
        this.mUserRotationOverridden = displayRotation.getUserRotation();
        return;
    }

    private boolean isTopFullscreenActivityNoSensor() {
        Task topFullscreenTask = this.mDisplayContent.getTask(new DisplayRotationReversionController$$ExternalSyntheticLambda0());
        if (topFullscreenTask == null) goto L10;
        ActivityRecord topActivity = topFullscreenTask.topRunningActivity();
        if (topActivity != null) goto L7;
        return false;
    L7:
        if (topActivity.getOrientation() != 5) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    private static /* synthetic */ boolean lambda$isTopFullscreenActivityNoSensor$0(Task t) {
        if (t.getWindowingMode() == 1) goto L7;
        return false;
    L7:
        return true;
    }
}
