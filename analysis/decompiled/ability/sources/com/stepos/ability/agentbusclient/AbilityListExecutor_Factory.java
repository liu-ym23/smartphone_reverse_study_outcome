package com.stepos.ability.agentbusclient;

import android.content.Context;
import com.stepos.ability.api.agentbus.IAbilityCatalog;
import y7.InterfaceC2137b;

/* loaded from: classes3.dex */
public final class AbilityListExecutor_Factory implements InterfaceC2137b {
    private final InterfaceC2137b abilityCatalogProvider;
    private final InterfaceC2137b contextProvider;

    private AbilityListExecutor_Factory(InterfaceC2137b interfaceC2137b, InterfaceC2137b interfaceC2137b2) {
        this.contextProvider = interfaceC2137b;
        this.abilityCatalogProvider = interfaceC2137b2;
    }

    public static AbilityListExecutor_Factory create(InterfaceC2137b interfaceC2137b, InterfaceC2137b interfaceC2137b2) {
        return new AbilityListExecutor_Factory(interfaceC2137b, interfaceC2137b2);
    }

    public static AbilityListExecutor newInstance(Context context, IAbilityCatalog iAbilityCatalog) {
        return new AbilityListExecutor(context, iAbilityCatalog);
    }

    @Override // javax.inject.Provider
    public AbilityListExecutor get() {
        return newInstance((Context) this.contextProvider.get(), (IAbilityCatalog) this.abilityCatalogProvider.get());
    }
}
