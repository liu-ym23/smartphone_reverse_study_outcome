package com.stepos.ability.task.executor.permissionauth;

import y7.InterfaceC2137b;
import z4.AbstractC2173e;
import z4.C2172d;

/* loaded from: classes3.dex */
public final class AuthSessionStore_Factory implements InterfaceC2137b {
    public static AuthSessionStore_Factory create() {
        return AbstractC2173e.f6959a;
    }

    public static C2172d newInstance() {
        return new C2172d();
    }

    @Override // javax.inject.Provider
    public C2172d get() {
        return newInstance();
    }
}
