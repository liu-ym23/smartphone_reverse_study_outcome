package com.android.server.accessibility.magnification;

import android.provider.DeviceConfig;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class MagnificationThumbnailFeatureFlag extends MagnificationFeatureFlagBase {
    private static final String FEATURE_NAME_ENABLE_MAGNIFIER_THUMBNAIL = "enable_magnifier_thumbnail";
    private static final String NAMESPACE = "accessibility";

    public MagnificationThumbnailFeatureFlag() {
    }

    @Override // com.android.server.accessibility.magnification.MagnificationFeatureFlagBase
    public /* bridge */ /* synthetic */ DeviceConfig.OnPropertiesChangedListener addOnChangedListener(Executor r1, Runnable r2) {
        return super.addOnChangedListener(r1, r2);
    }

    @Override // com.android.server.accessibility.magnification.MagnificationFeatureFlagBase
    public /* bridge */ /* synthetic */ boolean isFeatureFlagEnabled() {
        return super.isFeatureFlagEnabled();
    }

    @Override // com.android.server.accessibility.magnification.MagnificationFeatureFlagBase
    public /* bridge */ /* synthetic */ void removeOnChangedListener(DeviceConfig.OnPropertiesChangedListener r1) {
        super.removeOnChangedListener(r1);
    }

    @Override // com.android.server.accessibility.magnification.MagnificationFeatureFlagBase
    public /* bridge */ /* synthetic */ boolean setFeatureFlagEnabled(boolean r1) {
        return super.setFeatureFlagEnabled(r1);
    }

    @Override // com.android.server.accessibility.magnification.MagnificationFeatureFlagBase
    String getNamespace() {
        return NAMESPACE;
    }

    @Override // com.android.server.accessibility.magnification.MagnificationFeatureFlagBase
    String getFeatureName() {
        return FEATURE_NAME_ENABLE_MAGNIFIER_THUMBNAIL;
    }

    @Override // com.android.server.accessibility.magnification.MagnificationFeatureFlagBase
    boolean getDefaultValue() {
        return false;
    }
}
