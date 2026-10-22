package com.stepos.ability.application;

import K3.a;
import T3.c;
import android.content.Context;
import java.util.Set;
import y7.InterfaceC2137b;

/* loaded from: classes3.dex */
public final class App_Factory implements InterfaceC2137b {
    private final InterfaceC2137b contextProvider;
    private final InterfaceC2137b deviceIdManagerProvider;
    private final InterfaceC2137b setProvider;

    private App_Factory(InterfaceC2137b interfaceC2137b, InterfaceC2137b interfaceC2137b2, InterfaceC2137b interfaceC2137b3) {
        this.contextProvider = interfaceC2137b;
        this.deviceIdManagerProvider = interfaceC2137b2;
        this.setProvider = interfaceC2137b3;
    }

    public static App_Factory create(InterfaceC2137b interfaceC2137b, InterfaceC2137b interfaceC2137b2, InterfaceC2137b interfaceC2137b3) {
        return new App_Factory(interfaceC2137b, interfaceC2137b2, interfaceC2137b3);
    }

    public static a newInstance(Context context, c cVar) {
        return new a(context, cVar);
    }

    @Override // javax.inject.Provider
    public a get() {
        a aVarNewInstance = newInstance((Context) this.contextProvider.get(), (c) this.deviceIdManagerProvider.get());
        App_MembersInjector.injectSet(aVarNewInstance, (Set) this.setProvider.get());
        return aVarNewInstance;
    }
}
