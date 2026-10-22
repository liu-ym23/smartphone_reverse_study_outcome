package com.android.server.wm;

import com.android.server.wm.utils.OptPropFactory;
import java.util.function.BooleanSupplier;
import java.util.function.LongSupplier;

/* JADX INFO: loaded from: classes3.dex */
class AppCompatOrientationOverrides {
    private static final String TAG = "ActivityTaskManager";
    private final ActivityRecord mActivityRecord;
    private final OptPropFactory.OptProp mAllowDisplayOrientationOverrideOptProp;
    private final OptPropFactory.OptProp mAllowIgnoringOrientationRequestWhenLoopDetectedOptProp;
    private final OptPropFactory.OptProp mAllowOrientationOverrideOptProp;
    private final AppCompatCameraOverrides mAppCompatCameraOverrides;
    private final OptPropFactory.OptProp mIgnoreRequestedOrientationOptProp;
    final OrientationOverridesState mOrientationOverridesState;

    static class OrientationOverridesState {
        static final int MIN_COUNT_TO_IGNORE_REQUEST_IN_LOOP = 2;
        static final int SET_ORIENTATION_REQUEST_COUNTER_TIMEOUT_MS = 1000;
        LongSupplier mCurrentTimeMillisSupplier;
        final boolean mIsOverrideAnyOrientationEnabled;
        final boolean mIsOverrideToNosensorOrientationEnabled;
        final boolean mIsOverrideToPortraitOrientationEnabled;
        final boolean mIsOverrideToReverseLandscapeOrientationEnabled;
        private boolean mIsRelaunchingAfterRequestedOrientationChanged;
        private int mSetOrientationRequestCounter;
        private long mTimeMsLastSetOrientationRequest;

        /* JADX INFO: renamed from: -$$Nest$fgetmIsRelaunchingAfterRequestedOrientationChanged, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m9721$$Nest$fgetmIsRelaunchingAfterRequestedOrientationChanged(OrientationOverridesState r0) {
            return r0.mIsRelaunchingAfterRequestedOrientationChanged;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmSetOrientationRequestCounter, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m9722$$Nest$fgetmSetOrientationRequestCounter(OrientationOverridesState r0) {
            return r0.mSetOrientationRequestCounter;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmIsRelaunchingAfterRequestedOrientationChanged, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m9723$$Nest$fputmIsRelaunchingAfterRequestedOrientationChanged(OrientationOverridesState r0, boolean r1) {
            r0.mIsRelaunchingAfterRequestedOrientationChanged = r1;
        }

        OrientationOverridesState(ActivityRecord activityRecord, LongSupplier currentTimeMillisSupplier) {
            this.mTimeMsLastSetOrientationRequest = 0;
            this.mSetOrientationRequestCounter = 0;
            this.mCurrentTimeMillisSupplier = currentTimeMillisSupplier;
            this.mIsOverrideToNosensorOrientationEnabled = activityRecord.info.isChangeEnabled(265451093);
            this.mIsOverrideToPortraitOrientationEnabled = activityRecord.info.isChangeEnabled(265452344);
            this.mIsOverrideAnyOrientationEnabled = activityRecord.info.isChangeEnabled(265464455);
            this.mIsOverrideToReverseLandscapeOrientationEnabled = activityRecord.info.isChangeEnabled(266124927);
        }

        boolean shouldIgnoreRequestInLoop() {
            if (this.mSetOrientationRequestCounter < 2) goto L5;
            return true;
        L5:
            return false;
        }

        void updateOrientationRequestLoopState() {
            long currTimeMs = this.mCurrentTimeMillisSupplier.getAsLong();
            long elapsedTime = currTimeMs - this.mTimeMsLastSetOrientationRequest;
            if (elapsedTime >= 1000) goto L5;
            this.mSetOrientationRequestCounter++;
        L6:
            this.mTimeMsLastSetOrientationRequest = currTimeMs;
            return;
        L5:
            this.mSetOrientationRequestCounter = 0;
            goto L6
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$Wa-GLtYJmEGTkRKIFl9k0PzylQs, reason: not valid java name */
    public static /* synthetic */ boolean m9720$r8$lambda$WaGLtYJmEGTkRKIFl9k0PzylQs(AppCompatOrientationOverrides r0) {
        return r0.lambda$new$0();
    }

    AppCompatOrientationOverrides(ActivityRecord activityRecord, final AppCompatConfiguration appCompatConfiguration, OptPropFactory optPropBuilder, AppCompatCameraOverrides appCompatCameraOverrides) {
        this.mActivityRecord = activityRecord;
        this.mAppCompatCameraOverrides = appCompatCameraOverrides;
        this.mOrientationOverridesState = new OrientationOverridesState(this.mActivityRecord, new AppCompatOrientationOverrides$$ExternalSyntheticLambda0());
        appCompatConfiguration.getClass();
        BooleanSupplier isPolicyForIgnoringRequestedOrientationEnabled = AppCompatUtils.asLazy(new AppCompatOrientationOverrides$$ExternalSyntheticLambda1(appCompatConfiguration));
        this.mIgnoreRequestedOrientationOptProp = optPropBuilder.create("android.window.PROPERTY_COMPAT_IGNORE_REQUESTED_ORIENTATION", isPolicyForIgnoringRequestedOrientationEnabled);
        this.mAllowIgnoringOrientationRequestWhenLoopDetectedOptProp = optPropBuilder.create("android.window.PROPERTY_COMPAT_ALLOW_IGNORING_ORIENTATION_REQUEST_WHEN_LOOP_DETECTED", isPolicyForIgnoringRequestedOrientationEnabled);
        this.mAllowOrientationOverrideOptProp = optPropBuilder.create("android.window.PROPERTY_COMPAT_ALLOW_ORIENTATION_OVERRIDE");
        this.mAllowDisplayOrientationOverrideOptProp = optPropBuilder.create("android.window.PROPERTY_COMPAT_ALLOW_DISPLAY_ORIENTATION_OVERRIDE", new AppCompatOrientationOverrides$$ExternalSyntheticLambda2(this));
    }

    private /* synthetic */ boolean lambda$new$0() {
        if (this.mActivityRecord.mDisplayContent != null) goto L5;
    L13:
        return false;
    L5:
        if (this.mActivityRecord.getTask() == null) goto L13;
        if (this.mActivityRecord.mDisplayContent.getIgnoreOrientationRequest() == false) goto L13;
        if (this.mActivityRecord.getTask().inMultiWindowMode() == true) goto L13;
        if (this.mActivityRecord.mDisplayContent.getNaturalOrientation() != 2) goto L13;
        return true;
    }

    boolean shouldEnableIgnoreOrientationRequest() {
        return this.mIgnoreRequestedOrientationOptProp.shouldEnableWithOverrideAndProperty(isCompatChangeEnabled(254631730));
    }

    boolean isOverrideRespectRequestedOrientationEnabled() {
        return AppCompatUtils.isChangeEnabled(this.mActivityRecord, 236283604);
    }

    boolean shouldRespectRequestedOrientationDueToOverride() {
        if (this.mActivityRecord.isVisibleRequested() == true) goto L5;
    L11:
        return false;
    L5:
        if (this.mActivityRecord.getTaskFragment() == null) goto L11;
        if (this.mActivityRecord.getTaskFragment().getWindowingMode() != 1) goto L11;
        if (this.mActivityRecord.mAppCompatController.getOrientationOverrides().isOverrideRespectRequestedOrientationEnabled() == false) goto L11;
        return true;
    }

    boolean shouldIgnoreOrientationRequestLoop() {
        boolean loopDetectionEnabled = isCompatChangeEnabled(273509367);
        if (this.mAllowIgnoringOrientationRequestWhenLoopDetectedOptProp.shouldEnableWithOptInOverrideAndOptOutProperty(loopDetectionEnabled) == true) goto L5;
        return false;
    L5:
        this.mOrientationOverridesState.updateOrientationRequestLoopState();
        if (this.mOrientationOverridesState.shouldIgnoreRequestInLoop() == true) goto L8;
        return false;
    L8:
        if (this.mActivityRecord.mAppCompatController.getAspectRatioPolicy().isLetterboxedForFixedOrientationAndAspectRatio() == true) goto L13;
        return true;
    L13:
        return false;
    }

    boolean shouldUseDisplayLandscapeNaturalOrientation() {
        return this.mAllowDisplayOrientationOverrideOptProp.shouldEnableWithOptInOverrideAndOptOutProperty(AppCompatUtils.isChangeEnabled(this.mActivityRecord, 255940284));
    }

    void setRelaunchingAfterRequestedOrientationChanged(boolean isRelaunching) {
        OrientationOverridesState.m9723$$Nest$fputmIsRelaunchingAfterRequestedOrientationChanged(this.mOrientationOverridesState, isRelaunching);
    }

    boolean getIsRelaunchingAfterRequestedOrientationChanged() {
        return OrientationOverridesState.m9721$$Nest$fgetmIsRelaunchingAfterRequestedOrientationChanged(this.mOrientationOverridesState);
    }

    boolean isAllowOrientationOverrideOptOut() {
        return this.mAllowOrientationOverrideOptProp.isFalse();
    }

    int getSetOrientationRequestCounter() {
        return OrientationOverridesState.m9722$$Nest$fgetmSetOrientationRequestCounter(this.mOrientationOverridesState);
    }

    private boolean isCompatChangeEnabled(long overrideChangeId) {
        return this.mActivityRecord.info.isChangeEnabled(overrideChangeId);
    }
}
