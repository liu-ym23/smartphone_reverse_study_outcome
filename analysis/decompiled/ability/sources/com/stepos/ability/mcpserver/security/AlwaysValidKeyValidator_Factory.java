package com.stepos.ability.mcpserver.security;

import k4.C1624a;
import k4.b;
import y7.InterfaceC2137b;

/* loaded from: classes3.dex */
public final class AlwaysValidKeyValidator_Factory implements InterfaceC2137b {
    public static AlwaysValidKeyValidator_Factory create() {
        return b.f4796a;
    }

    public static C1624a newInstance() {
        return new C1624a();
    }

    @Override // javax.inject.Provider
    public C1624a get() {
        return newInstance();
    }
}
