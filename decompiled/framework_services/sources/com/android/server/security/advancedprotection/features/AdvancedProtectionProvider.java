package com.android.server.security.advancedprotection.features;

import android.content.Context;
import android.security.advancedprotection.AdvancedProtectionFeature;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AdvancedProtectionProvider {
    public abstract List<AdvancedProtectionFeature> getFeatures(Context r1);

    public AdvancedProtectionProvider() {
    }
}
