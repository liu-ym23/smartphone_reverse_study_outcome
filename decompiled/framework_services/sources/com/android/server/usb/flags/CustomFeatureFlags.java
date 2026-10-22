package com.android.server.usb.flags;

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
        this.mReadOnlyFlagsSet = new HashSet(Arrays.asList(new String[]{Flags.FLAG_ALLOW_RESTRICTION_OF_OVERLAY_ACTIVITIES, Flags.FLAG_CHECK_USER_ACTION_UNLOCKED, Flags.FLAG_ENABLE_BIND_TO_MTP_SERVICE, Flags.FLAG_MAXIMIZE_USB_AUDIO_VOLUME_WHEN_CONNECTING, Flags.FLAG_WAIT_FOR_ALSA_SCAN_RESULTS_IF_HAS_AUDIO_INTERFACE, ""}));
        this.mGetValueImpl = getValueImpl;
    }

    @Override // com.android.server.usb.flags.FeatureFlags
    public boolean allowRestrictionOfOverlayActivities() {
        return getValue(Flags.FLAG_ALLOW_RESTRICTION_OF_OVERLAY_ACTIVITIES, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.server.usb.flags.FeatureFlags
    public boolean checkUserActionUnlocked() {
        return getValue(Flags.FLAG_CHECK_USER_ACTION_UNLOCKED, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.server.usb.flags.FeatureFlags
    public boolean enableBindToMtpService() {
        return getValue(Flags.FLAG_ENABLE_BIND_TO_MTP_SERVICE, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.server.usb.flags.FeatureFlags
    public boolean maximizeUsbAudioVolumeWhenConnecting() {
        return getValue(Flags.FLAG_MAXIMIZE_USB_AUDIO_VOLUME_WHEN_CONNECTING, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.server.usb.flags.FeatureFlags
    public boolean waitForAlsaScanResultsIfHasAudioInterface() {
        return getValue(Flags.FLAG_WAIT_FOR_ALSA_SCAN_RESULTS_IF_HAS_AUDIO_INTERFACE, new CustomFeatureFlags$$ExternalSyntheticLambda0());
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
        return Arrays.asList(new String[]{Flags.FLAG_ALLOW_RESTRICTION_OF_OVERLAY_ACTIVITIES, Flags.FLAG_CHECK_USER_ACTION_UNLOCKED, Flags.FLAG_ENABLE_BIND_TO_MTP_SERVICE, Flags.FLAG_MAXIMIZE_USB_AUDIO_VOLUME_WHEN_CONNECTING, Flags.FLAG_WAIT_FOR_ALSA_SCAN_RESULTS_IF_HAS_AUDIO_INTERFACE});
    }
}
