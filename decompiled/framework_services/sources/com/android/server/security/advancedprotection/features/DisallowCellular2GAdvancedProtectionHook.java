package com.android.server.security.advancedprotection.features;

import android.app.admin.DevicePolicyManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.security.advancedprotection.AdvancedProtectionFeature;
import android.util.Slog;

/* JADX INFO: loaded from: classes3.dex */
public final class DisallowCellular2GAdvancedProtectionHook extends AdvancedProtectionHook {
    private static final String TAG = "AdvancedProtectionDisallowCellular2G";
    private final DevicePolicyManager mDevicePolicyManager;
    private final AdvancedProtectionFeature mFeature;
    private final PackageManager mPackageManager;

    public DisallowCellular2GAdvancedProtectionHook(Context context, boolean enabled) {
        super(context, enabled);
        this.mFeature = new AdvancedProtectionFeature(0);
        this.mDevicePolicyManager = (DevicePolicyManager) context.getSystemService(DevicePolicyManager.class);
        this.mPackageManager = context.getPackageManager();
        onAdvancedProtectionChanged(enabled);
    }

    @Override // com.android.server.security.advancedprotection.features.AdvancedProtectionHook
    public AdvancedProtectionFeature getFeature() {
        return this.mFeature;
    }

    @Override // com.android.server.security.advancedprotection.features.AdvancedProtectionHook
    public boolean isAvailable() {
        return this.mPackageManager.hasSystemFeature("android.hardware.telephony");
    }

    @Override // com.android.server.security.advancedprotection.features.AdvancedProtectionHook
    public void onAdvancedProtectionChanged(boolean enabled) {
        if (enabled == false) goto L5;
        Slog.d(TAG, "Setting DISALLOW_CELLULAR_2G_GLOBALLY restriction");
        this.mDevicePolicyManager.addUserRestrictionGlobally("android.security.advancedprotection", "no_cellular_2g");
        return;
    L5:
        Slog.d(TAG, "Clearing DISALLOW_CELLULAR_2G_GLOBALLY restriction");
        this.mDevicePolicyManager.clearUserRestrictionGlobally("android.security.advancedprotection", "no_cellular_2g");
    }
}
