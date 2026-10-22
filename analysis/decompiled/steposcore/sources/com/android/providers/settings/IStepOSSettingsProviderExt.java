package com.android.providers.settings;

import com.stepos.framework.annotations.StepOSStubHead;
import com.stepos.framework.utils.StepOSFrameworkStubUtils;

@StepOSStubHead(manifestName = "com.stepos.framework.impl.StepOSFrameworkStubImplMap_Framework")
/* loaded from: classes.dex */
public interface IStepOSSettingsProviderExt {
    boolean isPublicSystemSetting(String str);

    String onGetGlobalSetting(String str, int i, String str2);

    String onGetSecureSetting(String str, int i, String str2);

    String onGetSystemSetting(String str, int i, String str2);

    static IStepOSSettingsProviderExt get() {
        return (IStepOSSettingsProviderExt) StepOSFrameworkStubUtils.getInstance(IStepOSSettingsProviderExt.class);
    }
}
