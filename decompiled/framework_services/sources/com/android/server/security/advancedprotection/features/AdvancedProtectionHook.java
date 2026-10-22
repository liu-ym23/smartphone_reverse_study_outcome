package com.android.server.security.advancedprotection.features;

import android.content.Context;
import android.security.advancedprotection.AdvancedProtectionFeature;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AdvancedProtectionHook {
    public abstract AdvancedProtectionFeature getFeature();

    public abstract boolean isAvailable();

    public AdvancedProtectionHook(Context context, boolean enabled) {
    }

    public void onAdvancedProtectionChanged(boolean enabled) {
    }
}
