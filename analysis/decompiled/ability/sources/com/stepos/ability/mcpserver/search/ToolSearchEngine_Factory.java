package com.stepos.ability.mcpserver.search;

import com.stepos.ability.api.ability.repository.IAtomicAbilityRepository;
import y7.InterfaceC2137b;

/* loaded from: classes3.dex */
public final class ToolSearchEngine_Factory implements InterfaceC2137b {
    private final InterfaceC2137b repositoryProvider;

    private ToolSearchEngine_Factory(InterfaceC2137b interfaceC2137b) {
        this.repositoryProvider = interfaceC2137b;
    }

    public static ToolSearchEngine_Factory create(InterfaceC2137b interfaceC2137b) {
        return new ToolSearchEngine_Factory(interfaceC2137b);
    }

    public static b newInstance(IAtomicAbilityRepository iAtomicAbilityRepository) {
        return new b(iAtomicAbilityRepository);
    }

    @Override // javax.inject.Provider
    public b get() {
        return newInstance((IAtomicAbilityRepository) this.repositoryProvider.get());
    }
}
