package com.stepos.ability.manager;

import android.content.Context;
import com.stepos.ability.commoninternal.ability.IAbilityManager;
import y7.InterfaceC2137b;

/* loaded from: classes3.dex */
public final class AbilityCatalogImpl_Factory implements InterfaceC2137b {
    private final InterfaceC2137b abilityManagerProvider;
    private final InterfaceC2137b appContextProvider;

    private AbilityCatalogImpl_Factory(InterfaceC2137b interfaceC2137b, InterfaceC2137b interfaceC2137b2) {
        this.appContextProvider = interfaceC2137b;
        this.abilityManagerProvider = interfaceC2137b2;
    }

    public static AbilityCatalogImpl_Factory create(InterfaceC2137b interfaceC2137b, InterfaceC2137b interfaceC2137b2) {
        return new AbilityCatalogImpl_Factory(interfaceC2137b, interfaceC2137b2);
    }

    public static a newInstance(Context context, IAbilityManager iAbilityManager) {
        return new a(context, iAbilityManager);
    }

    @Override // javax.inject.Provider
    public a get() {
        return newInstance((Context) this.appContextProvider.get(), (IAbilityManager) this.abilityManagerProvider.get());
    }
}
