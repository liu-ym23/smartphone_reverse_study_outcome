package com.stepos.ability.application;

import K3.a;
import com.stepos.ability.api.init.IInit;
import java.util.Set;
import x7.InterfaceC2117a;
import y7.InterfaceC2137b;

/* loaded from: classes3.dex */
public final class App_MembersInjector implements InterfaceC2117a {
    private final InterfaceC2137b setProvider;

    private App_MembersInjector(InterfaceC2137b interfaceC2137b) {
        this.setProvider = interfaceC2137b;
    }

    public static InterfaceC2117a create(InterfaceC2137b interfaceC2137b) {
        return new App_MembersInjector(interfaceC2137b);
    }

    public static void injectSet(a aVar, Set<IInit> set) {
        aVar.c = set;
    }

    public void injectMembers(a aVar) {
        injectSet(aVar, (Set) this.setProvider.get());
    }
}
