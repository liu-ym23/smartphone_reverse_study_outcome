package com.android.server.security.advancedprotection.features;

import android.app.admin.DevicePolicyManager;
import android.content.Context;
import android.os.SystemProperties;
import android.security.advancedprotection.AdvancedProtectionFeature;
import android.util.Slog;

/* JADX INFO: loaded from: classes3.dex */
public final class MemoryTaggingExtensionHook extends AdvancedProtectionHook {
    private static final String MTE_DPM_SYSTEM_PROPERTY = "ro.arm64.memtag.bootctl_device_policy_manager";
    private static final String MTE_SETTINGS_SYSTEM_PROPERTY = "ro.arm64.memtag.bootctl_settings_toggle";
    private static final String TAG = "AdvancedProtectionMTE";
    private final DevicePolicyManager mDevicePolicyManager;
    private final AdvancedProtectionFeature mFeature;

    public MemoryTaggingExtensionHook(Context context, boolean enabled) {
        super(context, enabled);
        this.mFeature = new AdvancedProtectionFeature(4);
        this.mDevicePolicyManager = (DevicePolicyManager) context.getSystemService(DevicePolicyManager.class);
        onAdvancedProtectionChanged(enabled);
    }

    @Override // com.android.server.security.advancedprotection.features.AdvancedProtectionHook
    public AdvancedProtectionFeature getFeature() {
        return this.mFeature;
    }

    @Override // com.android.server.security.advancedprotection.features.AdvancedProtectionHook
    public boolean isAvailable() {
        return SystemProperties.getBoolean(MTE_DPM_SYSTEM_PROPERTY, SystemProperties.getBoolean(MTE_SETTINGS_SYSTEM_PROPERTY, false));
    }

    @Override // com.android.server.security.advancedprotection.features.AdvancedProtectionHook
    public void onAdvancedProtectionChanged(boolean enabled) {
        if (isAvailable() == true) goto L6;
        Slog.i(TAG, "MTE unavailable on device, skipping.");
        return;
    L6:
        if (enabled == false) goto L8;
        int mtePolicy = 1;
    L9:
        Slog.d(TAG, "Setting MTE state to " + mtePolicy);
        this.mDevicePolicyManager.setMtePolicy("android.security.advancedprotection", mtePolicy);     // Catch: UnsupportedOperationException -> L12
        return;
    L12:
        e = move-exception;
        Slog.i(TAG, "Setting MTE policy unsupported", e);
        return;
    L8:
        mtePolicy = 0;
        goto L9
    }
}
