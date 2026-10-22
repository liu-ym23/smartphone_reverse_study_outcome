package com.stepos.ability.mcpserver.describe;

import com.stepos.ability.api.ability.repository.IAtomicAbilityRepository;
import com.stepos.ability.commoninternal.ability.IAbilityManager;
import y7.InterfaceC2137b;

/* loaded from: classes3.dex */
public final class ToolDescribeEngine_Factory implements InterfaceC2137b {
    private final InterfaceC2137b abilityManagerProvider;
    private final InterfaceC2137b repositoryProvider;

    private ToolDescribeEngine_Factory(InterfaceC2137b interfaceC2137b, InterfaceC2137b interfaceC2137b2) {
        this.abilityManagerProvider = interfaceC2137b;
        this.repositoryProvider = interfaceC2137b2;
    }

    public static ToolDescribeEngine_Factory create(InterfaceC2137b interfaceC2137b, InterfaceC2137b interfaceC2137b2) {
        return new ToolDescribeEngine_Factory(interfaceC2137b, interfaceC2137b2);
    }

    public static a newInstance(IAbilityManager iAbilityManager, IAtomicAbilityRepository iAtomicAbilityRepository) {
        return new a(iAbilityManager, iAtomicAbilityRepository);
    }

    @Override // javax.inject.Provider
    public a get() {
        return newInstance((IAbilityManager) this.abilityManagerProvider.get(), (IAtomicAbilityRepository) this.repositoryProvider.get());
    }
}
