package com.stepos.ability.task.executor.permissionauth;

import y7.InterfaceC2137b;
import z4.m;
import z4.n;

/* loaded from: classes3.dex */
public final class PermissionAuthProcessor_Factory implements InterfaceC2137b {
    public static PermissionAuthProcessor_Factory create() {
        return n.f6969a;
    }

    public static m newInstance() {
        return new m();
    }

    @Override // javax.inject.Provider
    public m get() {
        return newInstance();
    }
}
