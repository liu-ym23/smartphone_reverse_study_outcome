package com.stepos.ability.agentbusclient;

import android.content.Context;
import y7.InterfaceC2137b;

/* loaded from: classes3.dex */
public final class AbilityCallExecutor_Factory implements InterfaceC2137b {
    private final InterfaceC2137b contextProvider;

    private AbilityCallExecutor_Factory(InterfaceC2137b interfaceC2137b) {
        this.contextProvider = interfaceC2137b;
    }

    public static AbilityCallExecutor_Factory create(InterfaceC2137b interfaceC2137b) {
        return new AbilityCallExecutor_Factory(interfaceC2137b);
    }

    public static AbilityCallExecutor newInstance(Context context) {
        return new AbilityCallExecutor(context);
    }

    @Override // javax.inject.Provider
    public AbilityCallExecutor get() {
        return newInstance((Context) this.contextProvider.get());
    }
}
