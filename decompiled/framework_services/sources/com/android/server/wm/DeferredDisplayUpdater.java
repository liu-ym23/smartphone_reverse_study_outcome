package com.android.server.wm;

import android.graphics.Rect;
import android.os.Message;
import android.os.Trace;
import android.util.Slog;
import android.view.DisplayInfo;
import android.window.DisplayAreaInfo;
import android.window.TransitionRequestInfo;
import android.window.WindowContainerTransaction;
import com.android.internal.display.BrightnessSynchronizer;
import com.android.internal.protolog.ProtoLogImpl_798997914;
import com.android.internal.protolog.WmProtoLogGroups;
import com.android.server.wm.utils.DisplayInfoOverrides;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
class DeferredDisplayUpdater {
    static final DisplayInfoOverrides.DisplayInfoFieldsUpdater DEFERRABLE_FIELDS = null;
    static final int DIFF_EVERYTHING = -1;
    static final int DIFF_NONE = 0;
    static final int DIFF_NOT_WM_DEFERRABLE = 2;
    static final int DIFF_WM_DEFERRABLE = 1;
    private static final String TAG = "DeferredDisplayUpdater";
    private static final String TRACE_TAG_WAIT_FOR_TRANSITION = "Screen unblock: wait for transition";
    private static final int WAIT_FOR_TRANSITION_TIMEOUT = 1000;
    private final DisplayContent mDisplayContent;
    private DisplayInfo mLastDisplayInfo;
    private DisplayInfo mLastWmDisplayInfo;
    private final DisplayInfo mNonOverrideDisplayInfo;
    private final DisplayInfo mOutputDisplayInfo;
    private final Runnable mScreenUnblockTimeoutRunnable;
    private Message mScreenUnblocker;
    private boolean mShouldWaitForTransitionWhenScreenOn;

    /* JADX INFO: renamed from: $r8$lambda$--t3mf11gpWn1Uw3-b-B1MpXHHQ, reason: not valid java name */
    public static /* synthetic */ void m9853$r8$lambda$t3mf11gpWn1Uw3bB1MpXHHQ(DisplayInfo r0, DisplayInfo r1) {
        lambda$static$0(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$CHPXMqT23O4nJOObP4bPI3REhts(DeferredDisplayUpdater r0, DisplayInfo r1, Runnable r2) {
        r0.lambda$updateDisplayInfo$2(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$D0ELwfiuq9oc1hihTzVJZBd7ViI(DeferredDisplayUpdater r0) {
        r0.continueScreenUnblocking();
    }

    public static /* synthetic */ void $r8$lambda$MvfO9JOt_Q3AS3XjgHDwFBPeCFo(DeferredDisplayUpdater r0, boolean r1, Runnable r2, Transition r3, boolean r4) {
        r0.lambda$requestDisplayChangeTransition$3(r1, r2, r3, r4);
    }

    public static /* synthetic */ void $r8$lambda$VN74qy4h8i8d2Gvzo67y7zTLuLY(DeferredDisplayUpdater r0, Transition r1, WindowContainerTransaction r2) {
        r0.lambda$onDisplayUpdated$4(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$wDFFq-H-LkC1KuXNimg4MoHXCCI, reason: not valid java name */
    public static /* synthetic */ void m9854$r8$lambda$wDFFqHLkC1KuXNimg4MoHXCCI(DeferredDisplayUpdater r0) {
        r0.lambda$new$1();
    }

    static {
        DEFERRABLE_FIELDS = new DeferredDisplayUpdater$$ExternalSyntheticLambda0();
    }

    private static /* synthetic */ void lambda$static$0(DisplayInfo out, DisplayInfo override) {
        out.uniqueId = override.uniqueId;
        out.address = override.address;
        out.canHostTasks = override.canHostTasks;
        DisplayInfoOverrides.WM_OVERRIDE_FIELDS.setFields(out, override);
    }

    private /* synthetic */ void lambda$new$1() {
        Slog.e(TAG, "Timeout waiting for the display switch transition to start");
        continueScreenUnblocking();
    }

    DeferredDisplayUpdater(DisplayContent displayContent) {
        this.mNonOverrideDisplayInfo = new DisplayInfo();
        this.mOutputDisplayInfo = new DisplayInfo();
        this.mScreenUnblockTimeoutRunnable = new DeferredDisplayUpdater$$ExternalSyntheticLambda3(this);
        this.mDisplayContent = displayContent;
        this.mNonOverrideDisplayInfo.copyFrom(this.mDisplayContent.getDisplayInfo());
    }

    void updateDisplayInfo(final Runnable finishCallback) {
        final DisplayInfo displayInfo = getCurrentDisplayInfo();
        int displayInfoDiff = calculateDisplayInfoDiff(this.mLastDisplayInfo, displayInfo);
        boolean physicalDisplayUpdated = isPhysicalDisplayUpdated(this.mLastDisplayInfo, displayInfo);
        if (this.mLastDisplayInfo != null) goto L5;
    L12:
        this.mLastDisplayInfo = displayInfo;
        if (displayInfoDiff == (-1)) goto L36;
        if (this.mDisplayContent.getLastHasContent() == false) goto L36;
        if (this.mDisplayContent.mWmService.getExt().isFreezingDisplayForSwitchResolution() == true) goto L36;
        if (this.mDisplayContent.mTransitionController.isShellTransitionsEnabled() == false) goto L36;
        if ((displayInfoDiff & 2) <= 0) goto L28;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_TRANSITIONS_MIN_enabled[0] == false) goto L26;
        long protoLogParam0 = displayInfo.logicalWidth;
        long protoLogParam1 = displayInfo.logicalHeight;
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_WINDOW_TRANSITIONS_MIN, -2231222821217880368L, 5, new Object[]{Long.valueOf(protoLogParam0), Long.valueOf(protoLogParam1)});
    L26:
        applyLatestDisplayInfo();
    L28:
        if ((displayInfoDiff & 1) > 0) goto L30;
        finishCallback.run();
        return;
    L30:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_TRANSITIONS_MIN_enabled[0] == false) goto L32;
        long protoLogParam2 = displayInfo.logicalWidth;
        long protoLogParam3 = displayInfo.logicalHeight;
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_WINDOW_TRANSITIONS_MIN, -6847793917085795163L, 5, new Object[]{Long.valueOf(protoLogParam2), Long.valueOf(protoLogParam3)});
    L32:
        requestDisplayChangeTransition(physicalDisplayUpdated, new DeferredDisplayUpdater$$ExternalSyntheticLambda2(this, displayInfo, finishCallback));
        return;
    L36:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_TRANSITIONS_MIN_enabled[0] == false) goto L38;
        long protoLogParam4 = displayInfo.logicalWidth;
        long protoLogParam5 = displayInfo.logicalHeight;
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_WINDOW_TRANSITIONS_MIN, -7429522233080137611L, 5, new Object[]{Long.valueOf(protoLogParam4), Long.valueOf(protoLogParam5)});
    L38:
        this.mLastWmDisplayInfo = displayInfo;
        applyLatestDisplayInfo();
        finishCallback.run();
        return;
    L5:
        if (Objects.equals(this.mLastDisplayInfo.roundedCorners, displayInfo.roundedCorners) == true) goto L12;
        if (this.mLastDisplayInfo.logicalWidth != displayInfo.logicalWidth) goto L12;
        if (this.mLastDisplayInfo.logicalHeight != displayInfo.logicalHeight) goto L12;
        Slog.d(TAG, "skip transition for roundedCorners changed");
        this.mLastWmDisplayInfo = displayInfo;
        this.mLastDisplayInfo = displayInfo;
        applyLatestDisplayInfo();
        finishCallback.run();
    }

    private /* synthetic */ void lambda$updateDisplayInfo$2(DisplayInfo displayInfo, Runnable finishCallback) {
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_TRANSITIONS_MIN_enabled[0] == false) goto L5;
        long protoLogParam0 = displayInfo.logicalWidth;
        long protoLogParam1 = displayInfo.logicalHeight;
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_WINDOW_TRANSITIONS_MIN, 8832378194695959375L, 5, new Object[]{Long.valueOf(protoLogParam0), Long.valueOf(protoLogParam1)});
    L5:
        this.mLastWmDisplayInfo = displayInfo;
        applyLatestDisplayInfo();
        finishCallback.run();
    }

    private void requestDisplayChangeTransition(final boolean physicalDisplayUpdated, final Runnable onStartCollect) {
        final Transition transition = new Transition(6, 0, this.mDisplayContent.mTransitionController, this.mDisplayContent.mTransitionController.mSyncEngine);
        this.mDisplayContent.mAtmService.startPowerMode(2);
        this.mDisplayContent.mTransitionController.startCollectOrQueue(transition, new DeferredDisplayUpdater$$ExternalSyntheticLambda1(this, physicalDisplayUpdated, onStartCollect, transition));
    }

    private /* synthetic */ void lambda$requestDisplayChangeTransition$3(boolean physicalDisplayUpdated, Runnable onStartCollect, Transition transition, boolean deferred) {
        Rect startBounds = new Rect(0, 0, this.mDisplayContent.mInitialDisplayWidth, this.mDisplayContent.mInitialDisplayHeight);
        int fromRotation = this.mDisplayContent.getRotation();
        if (physicalDisplayUpdated == false) goto L11;
        WindowState notificationShade = this.mDisplayContent.getDisplayPolicy().getNotificationShade();
        if (notificationShade == null) goto L11;
        if (notificationShade.isVisible() == false) goto L11;
        if (this.mDisplayContent.mAtmService.mKeyguardController.isKeyguardOrAodShowing(this.mDisplayContent.mDisplayId) == false) goto L11;
        Slog.i(TAG, notificationShade + " uses blast for display switch");
        notificationShade.mSyncMethodOverride = 1;
    L11:
        this.mDisplayContent.mAtmService.deferWindowLayout();
        onStartCollect.run();     // Catch: Throwable -> L15
        if (physicalDisplayUpdated == false) goto L17;
        onDisplayUpdated(transition, fromRotation, startBounds);     // Catch: Throwable -> L15
    L18:
        this.mDisplayContent.mAtmService.continueWindowLayout();
        return;
    L17:
        TransitionRequestInfo.DisplayChange displayChange = getCurrentDisplayChange(fromRotation, startBounds);     // Catch: Throwable -> L15
        this.mDisplayContent.mTransitionController.requestStartTransition(transition, null, null, displayChange);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        this.mDisplayContent.mAtmService.continueWindowLayout();
        throw th;
    }

    private void applyLatestDisplayInfo() {
        DisplayInfoOverrides.copyDisplayInfoFields(this.mOutputDisplayInfo, this.mLastDisplayInfo, this.mLastWmDisplayInfo, DEFERRABLE_FIELDS);
        this.mDisplayContent.onDisplayInfoUpdated(this.mOutputDisplayInfo);
    }

    private DisplayInfo getCurrentDisplayInfo() {
        this.mDisplayContent.mWmService.mDisplayManagerInternal.getNonOverrideDisplayInfo(this.mDisplayContent.mDisplayId, this.mNonOverrideDisplayInfo);
        return new DisplayInfo(this.mNonOverrideDisplayInfo);
    }

    private TransitionRequestInfo.DisplayChange getCurrentDisplayChange(int fromRotation, Rect startBounds) {
        Rect endBounds = new Rect(0, 0, this.mDisplayContent.mInitialDisplayWidth, this.mDisplayContent.mInitialDisplayHeight);
        int toRotation = this.mDisplayContent.getRotation();
        TransitionRequestInfo.DisplayChange displayChange = new TransitionRequestInfo.DisplayChange(this.mDisplayContent.getDisplayId());
        displayChange.setStartAbsBounds(startBounds);
        displayChange.setEndAbsBounds(endBounds);
        displayChange.setStartRotation(fromRotation);
        displayChange.setEndRotation(toRotation);
        return displayChange;
    }

    private void onDisplayUpdated(final Transition transition, int fromRotation, Rect startBounds) {
        int toRotation = this.mDisplayContent.getRotation();
        TransitionRequestInfo.DisplayChange displayChange = getCurrentDisplayChange(fromRotation, startBounds);
        displayChange.setPhysicalDisplayChanged(true);
        transition.addTransactionCompletedListener(new DeferredDisplayUpdater$$ExternalSyntheticLambda4(this));
        this.mDisplayContent.mTransitionController.requestStartTransition(transition, null, null, displayChange);
        DisplayAreaInfo newDisplayAreaInfo = this.mDisplayContent.getDisplayAreaInfo();
        boolean startedRemoteChange = this.mDisplayContent.mRemoteDisplayChangeController.performRemoteDisplayChange(fromRotation, toRotation, newDisplayAreaInfo, new DeferredDisplayUpdater$$ExternalSyntheticLambda5(this, transition));
        if (startedRemoteChange == true) goto L6;
        finishDisplayUpdate(null, transition);
        return;
    }

    private /* synthetic */ void lambda$onDisplayUpdated$4(Transition transition, WindowContainerTransaction transaction) {
        finishDisplayUpdate(transaction, transition);
    }

    private void finishDisplayUpdate(WindowContainerTransaction wct, Transition transition) {
        if (wct == null) goto L4;
        this.mDisplayContent.mAtmService.mWindowOrganizerController.applyTransaction(wct);
    L4:
        transition.setAllReady();
    }

    private boolean isPhysicalDisplayUpdated(DisplayInfo first, DisplayInfo second) {
        if (first == null) goto L8;
        if (second == null) goto L8;
        return true ^ Objects.equals(first.uniqueId, second.uniqueId);
    L8:
        return true;
    }

    void onDisplayContentDisplayPropertiesPostChanged() {
        if (this.mScreenUnblocker != null) goto L5;
        return;
    L5:
        if (this.mDisplayContent.mTransitionController.inTransition() == true) goto L9;
        this.mScreenUnblocker.sendToTarget();
        this.mScreenUnblocker = null;
        return;
    }

    void onDisplaySwitching(boolean switching) {
        this.mShouldWaitForTransitionWhenScreenOn = switching;
    }

    boolean waitForTransition(Message screenUnblocker) {
        if (this.mShouldWaitForTransitionWhenScreenOn == true) goto L6;
        return false;
    L6:
        this.mScreenUnblocker = screenUnblocker;
        if (Trace.isTagEnabled(32) == false) goto L9;
        Trace.beginAsyncSection(TRACE_TAG_WAIT_FOR_TRANSITION, screenUnblocker.hashCode());
    L9:
        this.mDisplayContent.mWmService.mH.removeCallbacks(this.mScreenUnblockTimeoutRunnable);
        this.mDisplayContent.mWmService.mH.postDelayed(this.mScreenUnblockTimeoutRunnable, 1000);
        return true;
    }

    private void continueScreenUnblocking() {
        WindowManagerGlobalLock r0 = this.mDisplayContent.mWmService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        this.mShouldWaitForTransitionWhenScreenOn = false;     // Catch: Throwable -> L10
        this.mDisplayContent.mWmService.mH.removeCallbacks(this.mScreenUnblockTimeoutRunnable);     // Catch: Throwable -> L10
        if (this.mScreenUnblocker != null) goto L12;
        monitor-exit(r0);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L12:
        this.mScreenUnblocker.sendToTarget();     // Catch: Throwable -> L10
        if (Trace.isTagEnabled(32) == false) goto L15;
        Trace.endAsyncSection(TRACE_TAG_WAIT_FOR_TRANSITION, this.mScreenUnblocker.hashCode());     // Catch: Throwable -> L10
    L15:
        this.mScreenUnblocker = null;     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L10:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    static int calculateDisplayInfoDiff(DisplayInfo first, DisplayInfo second) {
        int diff = 0;
        if (Objects.equals(first, second) == false) goto L5;
        return 0;
    L5:
        if (first == null) goto L123;
        if (second != null) goto L9;
        return -1;
    L9:
        if (first.layerStack == second.layerStack) goto L11;
    L84:
        diff = 0 | 2;
    L86:
        if (first.appWidth != second.appWidth) goto L122;
        if (first.appHeight != second.appHeight) goto L122;
        if (first.smallestNominalAppWidth != second.smallestNominalAppWidth) goto L122;
        if (first.smallestNominalAppHeight != second.smallestNominalAppHeight) goto L122;
        if (first.largestNominalAppWidth != second.largestNominalAppWidth) goto L122;
        if (first.largestNominalAppHeight != second.largestNominalAppHeight) goto L122;
        if (first.logicalWidth != second.logicalWidth) goto L122;
        if (first.logicalHeight != second.logicalHeight) goto L122;
        if (first.physicalXDpi != second.physicalXDpi) goto L122;
        if (first.physicalYDpi != second.physicalYDpi) goto L122;
        if (first.rotation != second.rotation) goto L122;
        if (Objects.equals(first.displayCutout, second.displayCutout) == false) goto L122;
        if (first.logicalDensityDpi != second.logicalDensityDpi) goto L122;
        if (Objects.equals(first.roundedCorners, second.roundedCorners) == false) goto L122;
        if (Objects.equals(first.displayShape, second.displayShape) == false) goto L122;
        if (Objects.equals(first.uniqueId, second.uniqueId) == false) goto L122;
        if (Objects.equals(first.address, second.address) == false) goto L122;
        if (first.canHostTasks != second.canHostTasks) goto L122;
        return diff;
    L122:
        return diff | 1;
    L11:
        if (first.flags != second.flags) goto L84;
        if (first.type != second.type) goto L84;
        if (first.displayId != second.displayId) goto L84;
        if (first.displayGroupId != second.displayGroupId) goto L84;
        if (Objects.equals(first.deviceProductInfo, second.deviceProductInfo) == false) goto L84;
        if (first.modeId != second.modeId) goto L84;
        if (first.renderFrameRate != second.renderFrameRate) goto L84;
        if (first.hasArrSupport != second.hasArrSupport) goto L84;
        if (Objects.equals(first.frameRateCategoryRate, second.frameRateCategoryRate) == false) goto L84;
        if (Arrays.equals(first.supportedRefreshRates, second.supportedRefreshRates) == false) goto L84;
        if (first.defaultModeId != second.defaultModeId) goto L84;
        if (first.userPreferredModeId != second.userPreferredModeId) goto L84;
        if (Arrays.equals(first.supportedModes, second.supportedModes) == false) goto L84;
        if (Arrays.equals(first.appsSupportedModes, second.appsSupportedModes) == false) goto L84;
        if (first.colorMode != second.colorMode) goto L84;
        if (Arrays.equals(first.supportedColorModes, second.supportedColorModes) == false) goto L84;
        if (Objects.equals(first.hdrCapabilities, second.hdrCapabilities) == false) goto L84;
        if (Arrays.equals(first.userDisabledHdrTypes, second.userDisabledHdrTypes) == false) goto L84;
        if (first.minimalPostProcessingSupported != second.minimalPostProcessingSupported) goto L84;
        if (first.appVsyncOffsetNanos != second.appVsyncOffsetNanos) goto L84;
        if (first.presentationDeadlineNanos != second.presentationDeadlineNanos) goto L84;
        if (first.state != second.state) goto L84;
        if (first.committedState != second.committedState) goto L84;
        if (first.ownerUid != second.ownerUid) goto L84;
        if (Objects.equals(first.ownerPackageName, second.ownerPackageName) == false) goto L84;
        if (first.removeMode != second.removeMode) goto L84;
        if (first.getRefreshRate() != second.getRefreshRate()) goto L84;
        if (first.brightnessMinimum != second.brightnessMinimum) goto L84;
        if (first.brightnessMaximum != second.brightnessMaximum) goto L84;
        if (first.brightnessDefault != second.brightnessDefault) goto L84;
        if (first.brightnessDim != second.brightnessDim) goto L84;
        if (first.installOrientation != second.installOrientation) goto L84;
        if (first.isForceSdr != second.isForceSdr) goto L84;
        if (Objects.equals(first.layoutLimitedRefreshRate, second.layoutLimitedRefreshRate) == false) goto L84;
        if (BrightnessSynchronizer.floatEquals(first.hdrSdrRatio, second.hdrSdrRatio) == false) goto L84;
        if (first.thermalRefreshRateThrottling.contentEquals(second.thermalRefreshRateThrottling) == false) goto L84;
        if (Objects.equals(first.thermalBrightnessThrottlingDataId, second.thermalBrightnessThrottlingDataId) == true) goto L86;
    L123:
        return -1;
    }
}
