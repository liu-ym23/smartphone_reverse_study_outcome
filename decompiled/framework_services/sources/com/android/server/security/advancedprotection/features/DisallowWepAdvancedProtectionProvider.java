package com.android.server.security.advancedprotection.features;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.security.advancedprotection.AdvancedProtectionFeature;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class DisallowWepAdvancedProtectionProvider extends AdvancedProtectionProvider {
    public DisallowWepAdvancedProtectionProvider() {
    }

    @Override // com.android.server.security.advancedprotection.features.AdvancedProtectionProvider
    public List<AdvancedProtectionFeature> getFeatures(Context context) {
        WifiManager wifiManager = (WifiManager) context.getSystemService(WifiManager.class);
        return wifiManager.getAvailableAdvancedProtectionFeatures();
    }
}
