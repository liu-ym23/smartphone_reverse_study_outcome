package com.android.settings.flags;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes3.dex */
public class CustomFeatureFlags implements FeatureFlags {
    private BiPredicate<String, Predicate<FeatureFlags>> mGetValueImpl;
    private Set<String> mReadOnlyFlagsSet;

    public CustomFeatureFlags(BiPredicate<String, Predicate<FeatureFlags>> getValueImpl) {
        this.mReadOnlyFlagsSet = new HashSet(Arrays.asList(new String[]{Flags.FLAG_ACCESSIBILITY_APPEARANCE_SETTINGS_BACKUP_ENABLED, Flags.FLAG_ACCESSIBILITY_CUSTOMIZE_TEXT_READING_PREVIEW, Flags.FLAG_ACCESSIBILITY_SHOW_APP_INFO_BUTTON, Flags.FLAG_ACTIVE_UNLOCK_FINISH_PARENT, Flags.FLAG_ADD_SECURITY_ALGORITHMS_TO_ENG_MENU, Flags.FLAG_APP_ARCHIVING, Flags.FLAG_BIOMETRIC_ONBOARDING_EDUCATION, Flags.FLAG_BIOMETRIC_SETTINGS_PROVIDER, Flags.FLAG_BIOMETRICS_ONBOARDING_EDUCATION, Flags.FLAG_CATALYST, Flags.FLAG_CATALYST_ACCESSIBILITY_COLOR_AND_MOTION, Flags.FLAG_CATALYST_ADAPTIVE_CONNECTIVITY, Flags.FLAG_CATALYST_AUTO_ROTATE, Flags.FLAG_CATALYST_BATTERY_SAVER_SCREEN, Flags.FLAG_CATALYST_BLUETOOTH_SWITCHBAR_SCREEN, Flags.FLAG_CATALYST_COLOR_MODE, Flags.FLAG_CATALYST_DARK_UI_MODE, Flags.FLAG_CATALYST_DISPLAY_SETTINGS_SCREEN, Flags.FLAG_CATALYST_DISPLAY_SETTINGS_SCREEN_25Q3, Flags.FLAG_CATALYST_FIRMWARE_VERSION, Flags.FLAG_CATALYST_GESTURE_SYSTEM_NAVIGATION_INPUT_SUMMARY, Flags.FLAG_CATALYST_INTERNET_SETTINGS, Flags.FLAG_CATALYST_LANGUAGE_SETTING, Flags.FLAG_CATALYST_LEGAL_INFORMATION, Flags.FLAG_CATALYST_LOCATION_SETTINGS, Flags.FLAG_CATALYST_LOCKSCREEN_FROM_DISPLAY_SETTINGS, Flags.FLAG_CATALYST_MEDIA_CONTROLS, Flags.FLAG_CATALYST_MOBILE_NETWORK_LIST, Flags.FLAG_CATALYST_MY_DEVICE_INFO_PREF_SCREEN, Flags.FLAG_CATALYST_NETWORK_PROVIDER_AND_INTERNET_SCREEN, Flags.FLAG_CATALYST_NIGHT_DISPLAY, Flags.FLAG_CATALYST_POWER_USAGE_SUMMARY_SCREEN, Flags.FLAG_CATALYST_RESTRICT_BACKGROUND_PARENT_ENTRY, Flags.FLAG_CATALYST_SCREEN_BRIGHTNESS_MODE, Flags.FLAG_CATALYST_SCREEN_RESOLUTION, Flags.FLAG_CATALYST_SCREEN_TIMEOUT, Flags.FLAG_CATALYST_SCREEN_TIMEOUT_25Q3, Flags.FLAG_CATALYST_SERVICE, Flags.FLAG_CATALYST_SOUND_SCREEN, Flags.FLAG_CATALYST_SOUND_SCREEN_25Q3, Flags.FLAG_CATALYST_SPATIAL_AUDIO, Flags.FLAG_CATALYST_TETHER_SETTINGS, Flags.FLAG_CATALYST_TETHER_SETTINGS_25Q3, Flags.FLAG_CATALYST_TEXT_READING_SCREEN, Flags.FLAG_CATALYST_VIBRATION_INTENSITY_SCREEN, Flags.FLAG_CATALYST_VIBRATION_SCREEN, Flags.FLAG_CATALYST_WIFI_CALLING, Flags.FLAG_DATETIME_FEEDBACK, Flags.FLAG_DEDUPE_DND_SETTINGS_CHANNELS, Flags.FLAG_DEVELOPMENT_GAME_DEFAULT_FRAME_RATE, Flags.FLAG_DEVELOPMENT_HDR_SDR_RATIO, Flags.FLAG_DISPLAY_SIZE_CONNECTED_DISPLAY_SETTING, Flags.FLAG_DISPLAY_TOPOLOGY_PANE_IN_DISPLAY_LIST, Flags.FLAG_DYNAMIC_INJECTION_CATEGORY, Flags.FLAG_ENABLE_AUTH_CHALLENGE_FOR_USB_PREFERENCES, Flags.FLAG_ENABLE_BATTERY_LEVEL_DISPLAY, Flags.FLAG_ENABLE_BLUETOOTH_DEVICE_DETAILS_POLISH, Flags.FLAG_ENABLE_BLUETOOTH_KEY_MISSING_DIALOG, Flags.FLAG_ENABLE_CONTACTS_DEFAULT_ACCOUNT_IN_SETTINGS, Flags.FLAG_ENABLE_DEVICE_DIAGNOSTICS_IN_SETTINGS, Flags.FLAG_ENABLE_HUB_MODE_SETTINGS_ON_MOBILE, Flags.FLAG_ENABLE_NEARBY_SHARE_ENTRYPOINT, Flags.FLAG_ENABLE_NESTED_TOGGLE_SWITCHES, Flags.FLAG_ENABLE_OFFLOAD_BLUETOOTH_OPERATIONS_TO_BACKGROUND_THREAD, Flags.FLAG_ENABLE_REMOVE_ASSOCIATION_BT_UNPAIR, Flags.FLAG_ENABLE_SOUND_BACKUP, Flags.FLAG_ENABLE_VOICE_ACTIVATION_APPS_IN_SETTINGS, Flags.FLAG_ENABLE_WIFI_SHARING_RUNTIME_FRAGMENT, Flags.FLAG_ENROLL_LAYOUT_TRUNCATE_IMPROVEMENT, Flags.FLAG_EXCLUDE_WEBCAM_AUTH_CHALLENGE, Flags.FLAG_EXTENDED_SCREENSHOTS_EXCLUDE_NESTED_SCROLLABLES, Flags.FLAG_FINGERPRINT_V2_ENROLLMENT, Flags.FLAG_HIDE_LE_AUDIO_TOGGLE_FOR_LE_AUDIO_ONLY_DEVICE, Flags.FLAG_HOMEPAGE_REVAMP, Flags.FLAG_IS_DUAL_SIM_ONBOARDING_ENABLED, Flags.FLAG_LOCALE_NOTIFICATION_ENABLED, Flags.FLAG_MAINLINE_MODULE_EXPLICIT_INTENT, Flags.FLAG_MOBILE_NETWORK_SECURITY_2G_TOGGLE, Flags.FLAG_NEW_APN_PAGE_ENABLED, Flags.FLAG_NEW_HEARING_DEVICE_PAIRING_PAGE, Flags.FLAG_PAGE_SIZE_APP_COMPAT_SETTING, Flags.FLAG_PROTECT_LOCK_AFTER_TIMEOUT_WITH_AUTH, Flags.FLAG_PROTECT_SCREEN_TIMEOUT_WITH_AUTH, Flags.FLAG_REFACTOR_PRINT_SETTINGS, Flags.FLAG_REGIONAL_PREFERENCES_API_ENABLED, Flags.FLAG_REMOVE_KEY_HIDE_ENABLE_2G, Flags.FLAG_RESOLUTION_AND_ENABLE_CONNECTED_DISPLAY_SETTING, Flags.FLAG_ROTATION_CONNECTED_DISPLAY_SETTING, Flags.FLAG_SATELLITE_OEM_SETTINGS_UX_MIGRATION, Flags.FLAG_SCREEN_OFF_UNLOCK_POWER_OPTIMIZATION, Flags.FLAG_SEPARATE_ACCESSIBILITY_VIBRATION_SETTINGS_FRAGMENTS, Flags.FLAG_SETTINGS_SEARCH_RESULT_DEEP_LINK_IN_SAME_TASK, Flags.FLAG_SFPS_ENROLL_REFINEMENT, Flags.FLAG_SHOW_FACTORY_RESET_CANCEL_BUTTON, Flags.FLAG_SLICES_RETIREMENT, Flags.FLAG_SUPPORT_RAW_DYNAMIC_ICONS, Flags.FLAG_TERMS_OF_ADDRESS_ENABLED, Flags.FLAG_THREAD_SETTINGS_ENABLED, Flags.FLAG_UDFPS_ENROLL_CALIBRATION, Flags.FLAG_UPDATED_SUGGESTION_CARD_AOSP, Flags.FLAG_UTILS_RETURN_USER_HANDLE_FOR_CURRENT_USER_ID, ""}));
        this.mGetValueImpl = getValueImpl;
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean accessibilityAppearanceSettingsBackupEnabled() {
        return getValue(Flags.FLAG_ACCESSIBILITY_APPEARANCE_SETTINGS_BACKUP_ENABLED, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean accessibilityCustomizeTextReadingPreview() {
        return getValue(Flags.FLAG_ACCESSIBILITY_CUSTOMIZE_TEXT_READING_PREVIEW, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean accessibilityShowAppInfoButton() {
        return getValue(Flags.FLAG_ACCESSIBILITY_SHOW_APP_INFO_BUTTON, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean activeUnlockFinishParent() {
        return getValue(Flags.FLAG_ACTIVE_UNLOCK_FINISH_PARENT, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean addSecurityAlgorithmsToEngMenu() {
        return getValue(Flags.FLAG_ADD_SECURITY_ALGORITHMS_TO_ENG_MENU, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean appArchiving() {
        return getValue(Flags.FLAG_APP_ARCHIVING, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean biometricOnboardingEducation() {
        return getValue(Flags.FLAG_BIOMETRIC_ONBOARDING_EDUCATION, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean biometricSettingsProvider() {
        return getValue(Flags.FLAG_BIOMETRIC_SETTINGS_PROVIDER, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean biometricsOnboardingEducation() {
        return getValue(Flags.FLAG_BIOMETRICS_ONBOARDING_EDUCATION, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean catalyst() {
        return getValue(Flags.FLAG_CATALYST, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean catalystAccessibilityColorAndMotion() {
        return getValue(Flags.FLAG_CATALYST_ACCESSIBILITY_COLOR_AND_MOTION, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean catalystAdaptiveConnectivity() {
        return getValue(Flags.FLAG_CATALYST_ADAPTIVE_CONNECTIVITY, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean catalystAutoRotate() {
        return getValue(Flags.FLAG_CATALYST_AUTO_ROTATE, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean catalystBatterySaverScreen() {
        return getValue(Flags.FLAG_CATALYST_BATTERY_SAVER_SCREEN, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean catalystBluetoothSwitchbarScreen() {
        return getValue(Flags.FLAG_CATALYST_BLUETOOTH_SWITCHBAR_SCREEN, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean catalystColorMode() {
        return getValue(Flags.FLAG_CATALYST_COLOR_MODE, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean catalystDarkUiMode() {
        return getValue(Flags.FLAG_CATALYST_DARK_UI_MODE, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean catalystDisplaySettingsScreen() {
        return getValue(Flags.FLAG_CATALYST_DISPLAY_SETTINGS_SCREEN, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean catalystDisplaySettingsScreen25q3() {
        return getValue(Flags.FLAG_CATALYST_DISPLAY_SETTINGS_SCREEN_25Q3, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean catalystFirmwareVersion() {
        return getValue(Flags.FLAG_CATALYST_FIRMWARE_VERSION, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean catalystGestureSystemNavigationInputSummary() {
        return getValue(Flags.FLAG_CATALYST_GESTURE_SYSTEM_NAVIGATION_INPUT_SUMMARY, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean catalystInternetSettings() {
        return getValue(Flags.FLAG_CATALYST_INTERNET_SETTINGS, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean catalystLanguageSetting() {
        return getValue(Flags.FLAG_CATALYST_LANGUAGE_SETTING, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean catalystLegalInformation() {
        return getValue(Flags.FLAG_CATALYST_LEGAL_INFORMATION, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean catalystLocationSettings() {
        return getValue(Flags.FLAG_CATALYST_LOCATION_SETTINGS, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean catalystLockscreenFromDisplaySettings() {
        return getValue(Flags.FLAG_CATALYST_LOCKSCREEN_FROM_DISPLAY_SETTINGS, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean catalystMediaControls() {
        return getValue(Flags.FLAG_CATALYST_MEDIA_CONTROLS, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean catalystMobileNetworkList() {
        return getValue(Flags.FLAG_CATALYST_MOBILE_NETWORK_LIST, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean catalystMyDeviceInfoPrefScreen() {
        return getValue(Flags.FLAG_CATALYST_MY_DEVICE_INFO_PREF_SCREEN, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean catalystNetworkProviderAndInternetScreen() {
        return getValue(Flags.FLAG_CATALYST_NETWORK_PROVIDER_AND_INTERNET_SCREEN, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean catalystNightDisplay() {
        return getValue(Flags.FLAG_CATALYST_NIGHT_DISPLAY, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean catalystPowerUsageSummaryScreen() {
        return getValue(Flags.FLAG_CATALYST_POWER_USAGE_SUMMARY_SCREEN, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean catalystRestrictBackgroundParentEntry() {
        return getValue(Flags.FLAG_CATALYST_RESTRICT_BACKGROUND_PARENT_ENTRY, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean catalystScreenBrightnessMode() {
        return getValue(Flags.FLAG_CATALYST_SCREEN_BRIGHTNESS_MODE, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean catalystScreenResolution() {
        return getValue(Flags.FLAG_CATALYST_SCREEN_RESOLUTION, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean catalystScreenTimeout() {
        return getValue(Flags.FLAG_CATALYST_SCREEN_TIMEOUT, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean catalystScreenTimeout25q3() {
        return getValue(Flags.FLAG_CATALYST_SCREEN_TIMEOUT_25Q3, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean catalystService() {
        return getValue(Flags.FLAG_CATALYST_SERVICE, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean catalystSoundScreen() {
        return getValue(Flags.FLAG_CATALYST_SOUND_SCREEN, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean catalystSoundScreen25q3() {
        return getValue(Flags.FLAG_CATALYST_SOUND_SCREEN_25Q3, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean catalystSpatialAudio() {
        return getValue(Flags.FLAG_CATALYST_SPATIAL_AUDIO, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean catalystTetherSettings() {
        return getValue(Flags.FLAG_CATALYST_TETHER_SETTINGS, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean catalystTetherSettings25q3() {
        return getValue(Flags.FLAG_CATALYST_TETHER_SETTINGS_25Q3, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean catalystTextReadingScreen() {
        return getValue(Flags.FLAG_CATALYST_TEXT_READING_SCREEN, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean catalystVibrationIntensityScreen() {
        return getValue(Flags.FLAG_CATALYST_VIBRATION_INTENSITY_SCREEN, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean catalystVibrationScreen() {
        return getValue(Flags.FLAG_CATALYST_VIBRATION_SCREEN, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean catalystWifiCalling() {
        return getValue(Flags.FLAG_CATALYST_WIFI_CALLING, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean datetimeFeedback() {
        return getValue(Flags.FLAG_DATETIME_FEEDBACK, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean dedupeDndSettingsChannels() {
        return getValue(Flags.FLAG_DEDUPE_DND_SETTINGS_CHANNELS, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean developmentGameDefaultFrameRate() {
        return getValue(Flags.FLAG_DEVELOPMENT_GAME_DEFAULT_FRAME_RATE, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean developmentHdrSdrRatio() {
        return getValue(Flags.FLAG_DEVELOPMENT_HDR_SDR_RATIO, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean displaySizeConnectedDisplaySetting() {
        return getValue(Flags.FLAG_DISPLAY_SIZE_CONNECTED_DISPLAY_SETTING, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean displayTopologyPaneInDisplayList() {
        return getValue(Flags.FLAG_DISPLAY_TOPOLOGY_PANE_IN_DISPLAY_LIST, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean dynamicInjectionCategory() {
        return getValue(Flags.FLAG_DYNAMIC_INJECTION_CATEGORY, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean enableAuthChallengeForUsbPreferences() {
        return getValue(Flags.FLAG_ENABLE_AUTH_CHALLENGE_FOR_USB_PREFERENCES, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean enableBatteryLevelDisplay() {
        return getValue(Flags.FLAG_ENABLE_BATTERY_LEVEL_DISPLAY, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean enableBluetoothDeviceDetailsPolish() {
        return getValue(Flags.FLAG_ENABLE_BLUETOOTH_DEVICE_DETAILS_POLISH, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean enableBluetoothKeyMissingDialog() {
        return getValue(Flags.FLAG_ENABLE_BLUETOOTH_KEY_MISSING_DIALOG, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean enableContactsDefaultAccountInSettings() {
        return getValue(Flags.FLAG_ENABLE_CONTACTS_DEFAULT_ACCOUNT_IN_SETTINGS, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean enableDeviceDiagnosticsInSettings() {
        return getValue(Flags.FLAG_ENABLE_DEVICE_DIAGNOSTICS_IN_SETTINGS, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean enableHubModeSettingsOnMobile() {
        return getValue(Flags.FLAG_ENABLE_HUB_MODE_SETTINGS_ON_MOBILE, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean enableNearbyShareEntrypoint() {
        return getValue(Flags.FLAG_ENABLE_NEARBY_SHARE_ENTRYPOINT, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean enableNestedToggleSwitches() {
        return getValue(Flags.FLAG_ENABLE_NESTED_TOGGLE_SWITCHES, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean enableOffloadBluetoothOperationsToBackgroundThread() {
        return getValue(Flags.FLAG_ENABLE_OFFLOAD_BLUETOOTH_OPERATIONS_TO_BACKGROUND_THREAD, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean enableRemoveAssociationBtUnpair() {
        return getValue(Flags.FLAG_ENABLE_REMOVE_ASSOCIATION_BT_UNPAIR, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean enableSoundBackup() {
        return getValue(Flags.FLAG_ENABLE_SOUND_BACKUP, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean enableVoiceActivationAppsInSettings() {
        return getValue(Flags.FLAG_ENABLE_VOICE_ACTIVATION_APPS_IN_SETTINGS, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean enableWifiSharingRuntimeFragment() {
        return getValue(Flags.FLAG_ENABLE_WIFI_SHARING_RUNTIME_FRAGMENT, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean enrollLayoutTruncateImprovement() {
        return getValue(Flags.FLAG_ENROLL_LAYOUT_TRUNCATE_IMPROVEMENT, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean excludeWebcamAuthChallenge() {
        return getValue(Flags.FLAG_EXCLUDE_WEBCAM_AUTH_CHALLENGE, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean extendedScreenshotsExcludeNestedScrollables() {
        return getValue(Flags.FLAG_EXTENDED_SCREENSHOTS_EXCLUDE_NESTED_SCROLLABLES, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean fingerprintV2Enrollment() {
        return getValue(Flags.FLAG_FINGERPRINT_V2_ENROLLMENT, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean hideLeAudioToggleForLeAudioOnlyDevice() {
        return getValue(Flags.FLAG_HIDE_LE_AUDIO_TOGGLE_FOR_LE_AUDIO_ONLY_DEVICE, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean homepageRevamp() {
        return getValue(Flags.FLAG_HOMEPAGE_REVAMP, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean isDualSimOnboardingEnabled() {
        return getValue(Flags.FLAG_IS_DUAL_SIM_ONBOARDING_ENABLED, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean localeNotificationEnabled() {
        return getValue(Flags.FLAG_LOCALE_NOTIFICATION_ENABLED, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean mainlineModuleExplicitIntent() {
        return getValue(Flags.FLAG_MAINLINE_MODULE_EXPLICIT_INTENT, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean mobileNetworkSecurity2gToggle() {
        return getValue(Flags.FLAG_MOBILE_NETWORK_SECURITY_2G_TOGGLE, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean newApnPageEnabled() {
        return getValue(Flags.FLAG_NEW_APN_PAGE_ENABLED, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean newHearingDevicePairingPage() {
        return getValue(Flags.FLAG_NEW_HEARING_DEVICE_PAIRING_PAGE, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean pageSizeAppCompatSetting() {
        return getValue(Flags.FLAG_PAGE_SIZE_APP_COMPAT_SETTING, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean protectLockAfterTimeoutWithAuth() {
        return getValue(Flags.FLAG_PROTECT_LOCK_AFTER_TIMEOUT_WITH_AUTH, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean protectScreenTimeoutWithAuth() {
        return getValue(Flags.FLAG_PROTECT_SCREEN_TIMEOUT_WITH_AUTH, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean refactorPrintSettings() {
        return getValue(Flags.FLAG_REFACTOR_PRINT_SETTINGS, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean regionalPreferencesApiEnabled() {
        return getValue(Flags.FLAG_REGIONAL_PREFERENCES_API_ENABLED, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean removeKeyHideEnable2g() {
        return getValue(Flags.FLAG_REMOVE_KEY_HIDE_ENABLE_2G, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean resolutionAndEnableConnectedDisplaySetting() {
        return getValue(Flags.FLAG_RESOLUTION_AND_ENABLE_CONNECTED_DISPLAY_SETTING, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean rotationConnectedDisplaySetting() {
        return getValue(Flags.FLAG_ROTATION_CONNECTED_DISPLAY_SETTING, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean satelliteOemSettingsUxMigration() {
        return getValue(Flags.FLAG_SATELLITE_OEM_SETTINGS_UX_MIGRATION, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean screenOffUnlockPowerOptimization() {
        return getValue(Flags.FLAG_SCREEN_OFF_UNLOCK_POWER_OPTIMIZATION, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean separateAccessibilityVibrationSettingsFragments() {
        return getValue(Flags.FLAG_SEPARATE_ACCESSIBILITY_VIBRATION_SETTINGS_FRAGMENTS, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean settingsSearchResultDeepLinkInSameTask() {
        return getValue(Flags.FLAG_SETTINGS_SEARCH_RESULT_DEEP_LINK_IN_SAME_TASK, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean sfpsEnrollRefinement() {
        return getValue(Flags.FLAG_SFPS_ENROLL_REFINEMENT, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean showFactoryResetCancelButton() {
        return getValue(Flags.FLAG_SHOW_FACTORY_RESET_CANCEL_BUTTON, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean slicesRetirement() {
        return getValue(Flags.FLAG_SLICES_RETIREMENT, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean supportRawDynamicIcons() {
        return getValue(Flags.FLAG_SUPPORT_RAW_DYNAMIC_ICONS, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean termsOfAddressEnabled() {
        return getValue(Flags.FLAG_TERMS_OF_ADDRESS_ENABLED, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean threadSettingsEnabled() {
        return getValue(Flags.FLAG_THREAD_SETTINGS_ENABLED, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean udfpsEnrollCalibration() {
        return getValue(Flags.FLAG_UDFPS_ENROLL_CALIBRATION, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean updatedSuggestionCardAosp() {
        return getValue(Flags.FLAG_UPDATED_SUGGESTION_CARD_AOSP, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.settings.flags.FeatureFlags
    public boolean utilsReturnUserHandleForCurrentUserId() {
        return getValue(Flags.FLAG_UTILS_RETURN_USER_HANDLE_FOR_CURRENT_USER_ID, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    public boolean isFlagReadOnlyOptimized(String flagName) {
        if (this.mReadOnlyFlagsSet.contains(flagName) == false) goto L6;
        return true;
    L6:
        return false;
    }

    private boolean isOptimizationEnabled() {
        return false;
    }

    protected boolean getValue(String flagName, Predicate<FeatureFlags> getter) {
        return this.mGetValueImpl.test(flagName, getter);
    }

    public List<String> getFlagNames() {
        return Arrays.asList(new String[]{Flags.FLAG_ACCESSIBILITY_APPEARANCE_SETTINGS_BACKUP_ENABLED, Flags.FLAG_ACCESSIBILITY_CUSTOMIZE_TEXT_READING_PREVIEW, Flags.FLAG_ACCESSIBILITY_SHOW_APP_INFO_BUTTON, Flags.FLAG_ACTIVE_UNLOCK_FINISH_PARENT, Flags.FLAG_ADD_SECURITY_ALGORITHMS_TO_ENG_MENU, Flags.FLAG_APP_ARCHIVING, Flags.FLAG_BIOMETRIC_ONBOARDING_EDUCATION, Flags.FLAG_BIOMETRIC_SETTINGS_PROVIDER, Flags.FLAG_BIOMETRICS_ONBOARDING_EDUCATION, Flags.FLAG_CATALYST, Flags.FLAG_CATALYST_ACCESSIBILITY_COLOR_AND_MOTION, Flags.FLAG_CATALYST_ADAPTIVE_CONNECTIVITY, Flags.FLAG_CATALYST_AUTO_ROTATE, Flags.FLAG_CATALYST_BATTERY_SAVER_SCREEN, Flags.FLAG_CATALYST_BLUETOOTH_SWITCHBAR_SCREEN, Flags.FLAG_CATALYST_COLOR_MODE, Flags.FLAG_CATALYST_DARK_UI_MODE, Flags.FLAG_CATALYST_DISPLAY_SETTINGS_SCREEN, Flags.FLAG_CATALYST_DISPLAY_SETTINGS_SCREEN_25Q3, Flags.FLAG_CATALYST_FIRMWARE_VERSION, Flags.FLAG_CATALYST_GESTURE_SYSTEM_NAVIGATION_INPUT_SUMMARY, Flags.FLAG_CATALYST_INTERNET_SETTINGS, Flags.FLAG_CATALYST_LANGUAGE_SETTING, Flags.FLAG_CATALYST_LEGAL_INFORMATION, Flags.FLAG_CATALYST_LOCATION_SETTINGS, Flags.FLAG_CATALYST_LOCKSCREEN_FROM_DISPLAY_SETTINGS, Flags.FLAG_CATALYST_MEDIA_CONTROLS, Flags.FLAG_CATALYST_MOBILE_NETWORK_LIST, Flags.FLAG_CATALYST_MY_DEVICE_INFO_PREF_SCREEN, Flags.FLAG_CATALYST_NETWORK_PROVIDER_AND_INTERNET_SCREEN, Flags.FLAG_CATALYST_NIGHT_DISPLAY, Flags.FLAG_CATALYST_POWER_USAGE_SUMMARY_SCREEN, Flags.FLAG_CATALYST_RESTRICT_BACKGROUND_PARENT_ENTRY, Flags.FLAG_CATALYST_SCREEN_BRIGHTNESS_MODE, Flags.FLAG_CATALYST_SCREEN_RESOLUTION, Flags.FLAG_CATALYST_SCREEN_TIMEOUT, Flags.FLAG_CATALYST_SCREEN_TIMEOUT_25Q3, Flags.FLAG_CATALYST_SERVICE, Flags.FLAG_CATALYST_SOUND_SCREEN, Flags.FLAG_CATALYST_SOUND_SCREEN_25Q3, Flags.FLAG_CATALYST_SPATIAL_AUDIO, Flags.FLAG_CATALYST_TETHER_SETTINGS, Flags.FLAG_CATALYST_TETHER_SETTINGS_25Q3, Flags.FLAG_CATALYST_TEXT_READING_SCREEN, Flags.FLAG_CATALYST_VIBRATION_INTENSITY_SCREEN, Flags.FLAG_CATALYST_VIBRATION_SCREEN, Flags.FLAG_CATALYST_WIFI_CALLING, Flags.FLAG_DATETIME_FEEDBACK, Flags.FLAG_DEDUPE_DND_SETTINGS_CHANNELS, Flags.FLAG_DEVELOPMENT_GAME_DEFAULT_FRAME_RATE, Flags.FLAG_DEVELOPMENT_HDR_SDR_RATIO, Flags.FLAG_DISPLAY_SIZE_CONNECTED_DISPLAY_SETTING, Flags.FLAG_DISPLAY_TOPOLOGY_PANE_IN_DISPLAY_LIST, Flags.FLAG_DYNAMIC_INJECTION_CATEGORY, Flags.FLAG_ENABLE_AUTH_CHALLENGE_FOR_USB_PREFERENCES, Flags.FLAG_ENABLE_BATTERY_LEVEL_DISPLAY, Flags.FLAG_ENABLE_BLUETOOTH_DEVICE_DETAILS_POLISH, Flags.FLAG_ENABLE_BLUETOOTH_KEY_MISSING_DIALOG, Flags.FLAG_ENABLE_CONTACTS_DEFAULT_ACCOUNT_IN_SETTINGS, Flags.FLAG_ENABLE_DEVICE_DIAGNOSTICS_IN_SETTINGS, Flags.FLAG_ENABLE_HUB_MODE_SETTINGS_ON_MOBILE, Flags.FLAG_ENABLE_NEARBY_SHARE_ENTRYPOINT, Flags.FLAG_ENABLE_NESTED_TOGGLE_SWITCHES, Flags.FLAG_ENABLE_OFFLOAD_BLUETOOTH_OPERATIONS_TO_BACKGROUND_THREAD, Flags.FLAG_ENABLE_REMOVE_ASSOCIATION_BT_UNPAIR, Flags.FLAG_ENABLE_SOUND_BACKUP, Flags.FLAG_ENABLE_VOICE_ACTIVATION_APPS_IN_SETTINGS, Flags.FLAG_ENABLE_WIFI_SHARING_RUNTIME_FRAGMENT, Flags.FLAG_ENROLL_LAYOUT_TRUNCATE_IMPROVEMENT, Flags.FLAG_EXCLUDE_WEBCAM_AUTH_CHALLENGE, Flags.FLAG_EXTENDED_SCREENSHOTS_EXCLUDE_NESTED_SCROLLABLES, Flags.FLAG_FINGERPRINT_V2_ENROLLMENT, Flags.FLAG_HIDE_LE_AUDIO_TOGGLE_FOR_LE_AUDIO_ONLY_DEVICE, Flags.FLAG_HOMEPAGE_REVAMP, Flags.FLAG_IS_DUAL_SIM_ONBOARDING_ENABLED, Flags.FLAG_LOCALE_NOTIFICATION_ENABLED, Flags.FLAG_MAINLINE_MODULE_EXPLICIT_INTENT, Flags.FLAG_MOBILE_NETWORK_SECURITY_2G_TOGGLE, Flags.FLAG_NEW_APN_PAGE_ENABLED, Flags.FLAG_NEW_HEARING_DEVICE_PAIRING_PAGE, Flags.FLAG_PAGE_SIZE_APP_COMPAT_SETTING, Flags.FLAG_PROTECT_LOCK_AFTER_TIMEOUT_WITH_AUTH, Flags.FLAG_PROTECT_SCREEN_TIMEOUT_WITH_AUTH, Flags.FLAG_REFACTOR_PRINT_SETTINGS, Flags.FLAG_REGIONAL_PREFERENCES_API_ENABLED, Flags.FLAG_REMOVE_KEY_HIDE_ENABLE_2G, Flags.FLAG_RESOLUTION_AND_ENABLE_CONNECTED_DISPLAY_SETTING, Flags.FLAG_ROTATION_CONNECTED_DISPLAY_SETTING, Flags.FLAG_SATELLITE_OEM_SETTINGS_UX_MIGRATION, Flags.FLAG_SCREEN_OFF_UNLOCK_POWER_OPTIMIZATION, Flags.FLAG_SEPARATE_ACCESSIBILITY_VIBRATION_SETTINGS_FRAGMENTS, Flags.FLAG_SETTINGS_SEARCH_RESULT_DEEP_LINK_IN_SAME_TASK, Flags.FLAG_SFPS_ENROLL_REFINEMENT, Flags.FLAG_SHOW_FACTORY_RESET_CANCEL_BUTTON, Flags.FLAG_SLICES_RETIREMENT, Flags.FLAG_SUPPORT_RAW_DYNAMIC_ICONS, Flags.FLAG_TERMS_OF_ADDRESS_ENABLED, Flags.FLAG_THREAD_SETTINGS_ENABLED, Flags.FLAG_UDFPS_ENROLL_CALIBRATION, Flags.FLAG_UPDATED_SUGGESTION_CARD_AOSP, Flags.FLAG_UTILS_RETURN_USER_HANDLE_FOR_CURRENT_USER_ID});
    }
}
