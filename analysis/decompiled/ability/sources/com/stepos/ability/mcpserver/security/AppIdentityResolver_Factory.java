package com.stepos.ability.mcpserver.security;

import android.content.Context;
import k4.d;
import y7.InterfaceC2137b;

/* loaded from: classes3.dex */
public final class AppIdentityResolver_Factory implements InterfaceC2137b {
    private final InterfaceC2137b contextProvider;

    private AppIdentityResolver_Factory(InterfaceC2137b interfaceC2137b) {
        this.contextProvider = interfaceC2137b;
    }

    public static AppIdentityResolver_Factory create(InterfaceC2137b interfaceC2137b) {
        return new AppIdentityResolver_Factory(interfaceC2137b);
    }

    public static d newInstance(Context context) {
        return new d(context);
    }

    @Override // javax.inject.Provider
    public d get() {
        return newInstance((Context) this.contextProvider.get());
    }
}
