package com.stepos.taskrobot.settingsprovider.init;

import y7.InterfaceC2137b;

/* loaded from: classes3.dex */
public final class SettingsProviderInit_Factory implements InterfaceC2137b {

    public static final class InstanceHolder {
        static final SettingsProviderInit_Factory INSTANCE = new SettingsProviderInit_Factory();

        private InstanceHolder() {
        }
    }

    public static SettingsProviderInit_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static SettingsProviderInit newInstance() {
        return new SettingsProviderInit();
    }

    @Override // javax.inject.Provider
    public SettingsProviderInit get() {
        return newInstance();
    }
}
