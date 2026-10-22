package com.stepos.ability.security;

import y4.C2130a;
import y4.b;
import y7.InterfaceC2137b;

/* loaded from: classes3.dex */
public final class SecurityManagerImpl_Factory implements InterfaceC2137b {
    public static SecurityManagerImpl_Factory create() {
        return b.f6896a;
    }

    public static C2130a newInstance() {
        return new C2130a();
    }

    @Override // javax.inject.Provider
    public C2130a get() {
        return newInstance();
    }
}
