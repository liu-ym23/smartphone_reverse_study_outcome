package com.stepos.settings.impl;

import android.content.ContentResolver;
import android.provider.IStepOSSettingsReadExt;
import com.stepos.settings.config.StepOSSettingsKeys;
import java.util.Set;

/* loaded from: classes.dex */
public class StepOSSettingsReadImpl implements IStepOSSettingsReadExt {
    public String onSystemGetString(ContentResolver resolver, String name) {
        return null;
    }

    public String onSecureGetString(ContentResolver resolver, String name) {
        return null;
    }

    public String onGlobalGetString(ContentResolver resolver, String name) {
        return null;
    }

    public Set<String> getPublicSettings() {
        return StepOSSettingsKeys.PUBLIC_SYSTEM_SETTINGS;
    }

    public boolean isPublicSystemSetting(String name) {
        Set<String> set = getPublicSettings();
        return set != null && set.contains(name);
    }
}
