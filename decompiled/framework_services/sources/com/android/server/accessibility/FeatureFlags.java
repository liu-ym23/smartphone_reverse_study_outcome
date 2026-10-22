package com.android.server.accessibility;

/* JADX INFO: loaded from: classes.dex */
public interface FeatureFlags {
    boolean addWindowTokenWithoutLock();

    boolean allowSecureScreenshots();

    boolean alwaysAllowObservingTouchEvents();

    boolean cleanupA11yOverlays();

    boolean clearDefaultFromA11yShortcutTargetServiceRestore();

    boolean clearShortcutsWhenActivityUpdatesToService();

    boolean deprecatePackageListObserver();

    boolean disableContinuousShortcutOnForceStop();

    boolean doNotResetKeyEventState();

    boolean enableA11yCheckerLogging();

    boolean enableAutoclickIndicator();

    boolean enableColorCorrectionSaturation();

    boolean enableHardwareShortcutDisablesWarning();

    boolean enableLowVisionGenericFeedback();

    boolean enableLowVisionHats();

    boolean enableMagnificationFollowsMouseWithPointerMotionFilter();

    boolean enableMagnificationJoystick();

    boolean enableMagnificationKeyboardControl();

    boolean enableMagnificationMultipleFingerMultipleTapGesture();

    boolean enableMagnificationOneFingerPanningGesture();

    boolean eventDispatcherRawEvent();

    boolean fixDragPointerWhenEndingDrag();

    boolean focusClickPointWindowBoundsFromA11yWindowInfo();

    boolean fullscreenFlingGesture();

    boolean handleMultiDeviceInput();

    boolean hearingInputChangeWhenCommDevice();

    boolean magnificationEnlargePointerBugfix();

    boolean managerAvoidReceiverTimeout();

    boolean managerLifecycleUserChange();

    boolean managerPackageMonitorLogicFix();

    boolean motionEventInjectorCancelFix();

    boolean packageMonitorDedicatedThread();

    boolean pinchZoomZeroMinSpan();

    boolean pointerUpMotionEventInTouchExploration();

    boolean proxyUseAppsOnVirtualDeviceListener();

    boolean removeOnWindowInfosChangedHandler();

    boolean resetHoverEventTimerOnActionUp();

    boolean resetInputDispatcherBeforeFirstTouchExploration();

    boolean resettableDynamicProperties();

    boolean scanPackagesWithoutLock();

    boolean sendA11yEventsBasedOnState();

    boolean sendHoverEventsBasedOnEventStream();

    boolean skipPackageChangeBeforeUserSwitch();
}
