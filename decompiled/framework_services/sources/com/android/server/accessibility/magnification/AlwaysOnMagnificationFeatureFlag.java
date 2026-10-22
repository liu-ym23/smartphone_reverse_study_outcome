package com.android.server.accessibility.magnification;

import android.R;
import android.content.Context;
import android.provider.DeviceConfig;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class AlwaysOnMagnificationFeatureFlag extends MagnificationFeatureFlagBase {
    private static final String FEATURE_NAME_ENABLE_ALWAYS_ON_MAGNIFICATION = "AlwaysOnMagnifier__enable_always_on_magnifier";
    private static final String NAMESPACE = "window_manager";
    private Context mContext;

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

    AlwaysOnMagnificationFeatureFlag(Context context) {
        this.mContext = context;
    }

    @Override // com.android.server.accessibility.magnification.MagnificationFeatureFlagBase
    String getNamespace() {
        return NAMESPACE;
    }

    @Override // com.android.server.accessibility.magnification.MagnificationFeatureFlagBase
    String getFeatureName() {
        return FEATURE_NAME_ENABLE_ALWAYS_ON_MAGNIFICATION;
    }

    @Override // com.android.server.accessibility.magnification.MagnificationFeatureFlagBase
    boolean getDefaultValue() {
        return this.mContext.getResources().getBoolean(R.bool.config_mms_content_disposition_support);
    }
}
