package com.stepos.ability.env;

import U3.a;
import android.content.Context;
import y7.InterfaceC2137b;

/* loaded from: classes3.dex */
public final class EnvManager_Factory implements InterfaceC2137b {
    private final InterfaceC2137b contextProvider;

    private EnvManager_Factory(InterfaceC2137b interfaceC2137b) {
        this.contextProvider = interfaceC2137b;
    }

    public static EnvManager_Factory create(InterfaceC2137b interfaceC2137b) {
        return new EnvManager_Factory(interfaceC2137b);
    }

    public static a newInstance(Context context) {
        return new a(context);
    }

    @Override // javax.inject.Provider
    public a get() {
        return newInstance((Context) this.contextProvider.get());
    }
}
