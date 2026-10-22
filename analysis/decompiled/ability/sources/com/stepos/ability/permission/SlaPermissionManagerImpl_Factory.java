package com.stepos.ability.permission;

import o4.d;
import o4.e;
import y7.InterfaceC2137b;

/* loaded from: classes3.dex */
public final class SlaPermissionManagerImpl_Factory implements InterfaceC2137b {
    public static SlaPermissionManagerImpl_Factory create() {
        return e.f5431a;
    }

    public static d newInstance() {
        return new d();
    }

    @Override // javax.inject.Provider
    public d get() {
        return newInstance();
    }
}
