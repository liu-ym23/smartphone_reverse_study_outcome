package com.stepos.settings.impl;

import com.android.providers.settings.IStepOSSettingsProviderExt;
import com.stepos.settings.config.StepOSSettingsKeys;

/* loaded from: classes.dex */
public class StepOSSettingsProviderExtImpl implements IStepOSSettingsProviderExt {
    @Override // com.android.providers.settings.IStepOSSettingsProviderExt
    public String onGetSystemSetting(String name, int userId, String defaultValue) {
        return null;
    }

    @Override // com.android.providers.settings.IStepOSSettingsProviderExt
    public String onGetSecureSetting(String name, int userId, String defaultValue) {
        return null;
    }

    @Override // com.android.providers.settings.IStepOSSettingsProviderExt
    public String onGetGlobalSetting(String name, int userId, String defaultValue) {
        return null;
    }

    @Override // com.android.providers.settings.IStepOSSettingsProviderExt
    public boolean isPublicSystemSetting(String name) {
        return StepOSSettingsKeys.PUBLIC_SYSTEM_SETTINGS.contains(name);
    }
}
