package com.android.systemui;

/* JADX INFO: loaded from: classes3.dex */
public final class FeatureFlagsImpl implements FeatureFlags {
    public FeatureFlagsImpl() {
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean activityTransitionUseLargestWindow() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean addBlackBackgroundForWindowMagnifier() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean alwaysComposeQsUiFragment() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean ambientTouchMonitorListenToDisplayChanges() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean appClipsBacklinks() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean appShortcutRemovalFix() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean avalancheReplaceHunWhenCritical() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean bindKeyguardMediaVisibility() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean bouncerUiRevamp() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean bouncerUiRevamp2() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean bpColors() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean brightnessSliderFocusState() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean checkLockscreenGoneTransition() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean classicFlagsMultiUser() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean clipboardImageTimeout() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean clipboardNoninteractiveOnLockscreen() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean clipboardOverlayMultiuser() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean clipboardSharedTransitions() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean clipboardUseDescriptionMimetype() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean clockFidgetAnimation() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean communalBouncerDoNotModifyPluginOpen() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean communalEditWidgetsActivityFinishFix() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean communalHub() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean communalHubUseThreadPoolForWidgets() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean communalResponsiveGrid() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean communalSceneKtfRefactor() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean communalStandaloneSupport() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean communalTimerFlickerFix() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean communalWidgetResizing() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean communalWidgetTrampolineFix() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean composeBouncer() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean confineNotificationTouchToViewWidth() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean contAuthPlugin() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean contextualTipsAssistantDismissFix() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean coroutineTracing() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean createWindowlessWindowMagnifier() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean debugLiveUpdatesPromoteAll() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean decoupleViewControllerInAnimlib() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean delayShowMagnificationButton() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean desktopEffectsQsTile() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean deviceEntryUdfpsRefactor() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean disableBlurredShadeVisible() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean disableContextualTipsFrequencyCheck() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean disableContextualTipsIosSwitcherCheck() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean disableShadeTrackpadTwoFingerSwipe() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean doubleTapToSleep() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean dreamInputSessionPilferOnce() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean dreamOverlayBouncerSwipeDirectionFiltering() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean dreamOverlayUpdatedFont() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean edgeBackGestureHandlerThread() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean edgebackGestureHandlerGetRunningTasksBackground() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean enableBackgroundKeyguardOndrawnCallback() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean enableContextualTipForMuteVolume() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean enableContextualTipForPowerOff() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean enableContextualTipForTakeScreenshot() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean enableContextualTips() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean enableEfficientDisplayRepository() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean enableLayoutTracing() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean enableUnderlay() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean enableViewCaptureTracing() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean enforceBrightnessBaseUserRestriction() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean exampleFlag() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean expandCollapsePrivacyDialog() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean expandHeadsUpOnInlineReply() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean expandedPrivacyIndicatorsOnLargeScreen() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean extendedAppsShortcutCategory() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean faceMessageDeferUpdate() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean faceScanningAnimationNpeFix() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean fasterUnlockTransition() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean fetchBookmarksXmlKeyboardShortcuts() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean fixImageWallpaperCrashSurfaceAlreadyReleased() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean fixScreenshotActionDismissSystemWindows() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean floatingMenuAnimatedTuck() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean floatingMenuDisplayCutoutSupport() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean floatingMenuDragToEdit() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean floatingMenuDragToHide() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean floatingMenuHearingDeviceStatusIcon() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean floatingMenuImeDisplacementAnimation() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean floatingMenuNarrowTargetContentObserver() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean floatingMenuNotifyTargetsChangedOnStrictDiff() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean floatingMenuOverlapsNavBarsFlag() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean floatingMenuRadiiAnimation() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean getConnectedDeviceNameUnsynchronized() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean glanceableHubAllowKeyguardWhenDreaming() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean glanceableHubBlurredBackground() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean glanceableHubDirectEditMode() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean glanceableHubV2() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean glanceableHubV2Resources() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean hapticsForComposeSliders() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean hardwareColorStyles() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean hearingAidsQsTileDialog() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean hearingDevicesDialogRelatedTools() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean hideRingerButtonInSingleVolumeMode() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean homeControlsDreamHsum() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean hubEditModeTouchAdjustments() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean hubmodeFullscreenVerticalSwipe() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean hubmodeFullscreenVerticalSwipeFix() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean iconRefresh2025() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean ignoreTouchesNextToNotificationShelf() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean indicationTextA11yFix() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean keyboardDockingIndicator() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean keyboardShortcutHelperRewrite() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean keyboardShortcutHelperShortcutCustomizer() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean keyboardTouchpadContextualEducation() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean keyguardTransitionForceFinishOnScreenOff() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean keyguardWmReorderAtmsCalls() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean keyguardWmStateRefactor() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean lockscreenFont() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean lowLightClockDream() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean magneticNotificationSwipes() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean mediaControlsA11yColors() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean mediaControlsButtonMedia3() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean mediaControlsButtonMedia3Placement() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean mediaControlsDeviceManagerBackgroundExecution() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean mediaControlsDrawablesReuseBugfix() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean mediaControlsLockscreenShadeBugFix() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean mediaControlsUiUpdate() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean mediaControlsUmoInflationInBackground() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean mediaControlsUserInitiatedDeleteintent() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean mediaLoadMetadataViaMediaDataLoader() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean mediaLockscreenLaunchAnimation() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean mediaProjectionDialogBehindLockscreen() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean mediaProjectionGreyErrorText() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean mediaProjectionRequestAttributionFix() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean modesUiDialogPaging() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean moveTransitionAnimationLayer() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean msdlFeedback() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean multiuserWifiPickerTrackerSupport() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean newAodTransition() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean newVolumePanel() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean nonTouchscreenDevicesBypassFalsing() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean notesRoleQsTile() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean notificationAddXOnHoverToDismiss() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean notificationAmbientSuppressionAfterInflation() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean notificationAnimatedActionsTreatment() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean notificationAppearNonlinear() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean notificationAsyncGroupHeaderInflation() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean notificationAsyncHybridViewInflation() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean notificationAvalancheSuppression() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean notificationAvalancheThrottleHun() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean notificationBackgroundTintOptimization() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean notificationBundleUi() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean notificationColorUpdateLogger() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean notificationContentAlphaOptimization() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean notificationFooterBackgroundTintOptimization() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean notificationOverExpansionClippingFix() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean notificationReentrantDismiss() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean notificationRowAccessibilityExpanded() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean notificationRowContentBinderRefactor() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean notificationRowTransparency() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean notificationRowUserContext() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean notificationShadeBlur() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean notificationShadeUiThread() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean notificationSkipSilentUpdates() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean notificationTransparentHeaderFix() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean notificationViewFlipperPausingV2() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean notificationsBackgroundIcons() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean notificationsFooterVisibilityFix() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean notificationsHideOnDisplaySwitch() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean notificationsHunSharedAnimationValues() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean notificationsIconContainerRefactor() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean notificationsLaunchRadius() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean notificationsLiveDataStoreRefactor() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean notificationsPinnedHunInShade() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean notificationsRedesignFooterView() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean notificationsRedesignGuts() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean notifyPasswordTextViewUserActivityInBackground() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean notifyPowerManagerUserActivityBackground() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean onlyShowMediaStreamSliderInSingleVolumeMode() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean outputSwitcherRedesign() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean overrideSuppressOverlayCondition() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean permissionHelperInlineUiRichOngoing() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean permissionHelperUiRichOngoing() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean physicalNotificationMovement() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean pinInputFieldStyledFocusState() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean predictiveBackAnimateShade() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean predictiveBackDelayWmTransition() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean priorityPeopleSection() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean promoteNotificationsAutomatically() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean pssAppSelectorRecentsSplitScreen() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean pssTaskSwitcher() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean qsCustomTileClickGuaranteedBugFix() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean qsNewTiles() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean qsNewTilesFuture() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean qsQuickRebindActiveTiles() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean qsRegisterSettingObserverOnBgThread() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean qsTileDetailedView() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean qsTileFocusState() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean qsUiRefactor() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean qsUiRefactorComposeFragment() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean recordIssueQsTile() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean redesignMagnificationWindowSize() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean refactorGetCurrentUser() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean registerBatteryControllerReceiversInCorestartable() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean registerContentObserversAsync() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean registerNewWalletCardInBackground() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean registerWallpaperNotifierBackground() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean relockWithPowerButtonImmediately() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean removeDreamOverlayHideOnTouch() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean removeUpdateListenerInQsIconViewImpl() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean restToUnlock() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean restartDreamOnUnocclude() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean revampedBouncerMessages() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean runFingerprintDetectOnDismissibleKeyguard() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean saveAndRestoreMagnificationSettingsButtons() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean sceneContainer() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean screenshareNotificationHidingBugFix() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean screenshotActionDismissSystemWindows() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean screenshotMultidisplayFocusChange() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean screenshotPolicySplitAndDesktopMode() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean screenshotScrollCropViewCrashFix() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean screenshotUiControllerRefactor() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean secondaryUserWidgetHost() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean settingsExtRegisterContentObserverOnBgThread() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean shadeExpandsOnStatusBarLongPress() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean shadeHeaderFontUpdate() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean shadeLaunchAccessibility() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean shadeWindowGoesAround() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean shaderlibLoadingEffectRefactor() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean shortcutHelperKeyGlyph() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean showAudioSharingSliderInVolumePanel() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean showClipboardIndication() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean showLockedByYourWatchKeyguardIndicator() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean showToastWhenAppControlBrightness() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean simPinBouncerReset() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean simPinRaceConditionOnRestart() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean simPinUseSlotId() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean skipHideSensitiveNotifAnimation() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean sliceBroadcastRelayInBackground() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean sliceManagerBinderCallBackground() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean smartspaceLockscreenViewmodel() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean smartspaceRelocateToBottom() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean smartspaceRemoteviewsRenderingFix() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean smartspaceSwipeEventLoggingFix() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean smartspaceViewpager2() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean sounddoseCustomization() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean spatialModelAppPushback() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean stabilizeHeadsUpGroupV2() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean statusBarAlwaysCheckUnderlyingNetworks() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean statusBarAutoStartScreenRecordChip() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean statusBarChipsModernization() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean statusBarChipsReturnAnimations() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean statusBarFontUpdates() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean statusBarMobileIconKairos() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean statusBarMonochromeIconsFix() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean statusBarNoHunBehavior() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean statusBarPopupChips() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean statusBarRootModernization() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean statusBarShowAudioOnlyProjectionChip() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean statusBarSignalPolicyRefactor() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean statusBarSignalPolicyRefactorEthernet() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean statusBarStaticInoutIndicators() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean statusBarStopUpdatingWindowHeight() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean statusBarSwipeOverChip() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean statusBarSwitchToSpnFromDataSpn() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean statusBarUiThread() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean statusBarWindowNoCustomTouch() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean stoppableFgsSystemApp() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean switchUserOnBg() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean sysuiTeamfood() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean themeOverlayControllerWakefulnessDeprecation() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean transitionRaceCondition() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean translucentOccludingActivityFix() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean tvGlobalActionsFocus() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean udfpsViewPerformance() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean unfoldAnimationBackgroundProgress() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean unfoldLatencyTrackingFix() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean updateCornerRadiusOnDisplayChanged() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean updateUserSwitcherBackground() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean updateWindowMagnifierBottomBoundary() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean useAadProxSensor() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean useNotifInflationThreadForFooter() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean useNotifInflationThreadForRow() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean useTransitionsForKeyguardOccluded() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean useVolumeController() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean userAwareSettingsRepositories() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean userEncryptedSource() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean userSwitcherAddSignOutOption() {
        return false;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean visualInterruptionsRefactor() {
        return true;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean volumeRedesign() {
        return false;
    }
}
