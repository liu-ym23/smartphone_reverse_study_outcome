package com.android.server.security.advancedprotection.features;

import android.app.admin.DevicePolicyManager;
import android.content.Context;
import android.security.advancedprotection.AdvancedProtectionFeature;
import android.util.Slog;

/* JADX INFO: loaded from: classes3.dex */
public final class DisallowInstallUnknownSourcesAdvancedProtectionHook extends AdvancedProtectionHook {
    private static final String TAG = "AdvancedProtectionDisallowInstallUnknown";
    private final DevicePolicyManager mDevicePolicyManager;
    private final AdvancedProtectionFeature mFeature;

    public DisallowInstallUnknownSourcesAdvancedProtectionHook(Context context, boolean enabled) {
        super(context, enabled);
        this.mFeature = new AdvancedProtectionFeature(1);
        this.mDevicePolicyManager = (DevicePolicyManager) context.getSystemService(DevicePolicyManager.class);
        onAdvancedProtectionChanged(enabled);
    }

    @Override // com.android.server.security.advancedprotection.features.AdvancedProtectionHook
    public AdvancedProtectionFeature getFeature() {
        return this.mFeature;
    }

    @Override // com.android.server.security.advancedprotection.features.AdvancedProtectionHook
    public boolean isAvailable() {
        return true;
    }

    @Override // com.android.server.security.advancedprotection.features.AdvancedProtectionHook
    public void onAdvancedProtectionChanged(boolean enabled) {
        if (enabled == false) goto L5;
        Slog.d(TAG, "Setting DISALLOW_INSTALL_UNKNOWN_SOURCES_GLOBALLY restriction");
        this.mDevicePolicyManager.addUserRestrictionGlobally("android.security.advancedprotection", "no_install_unknown_sources_globally");
        return;
    L5:
        Slog.d(TAG, "Clearing DISALLOW_INSTALL_UNKNOWN_SOURCES_GLOBALLY restriction");
        this.mDevicePolicyManager.clearUserRestrictionGlobally("android.security.advancedprotection", "no_install_unknown_sources_globally");
    }
}
