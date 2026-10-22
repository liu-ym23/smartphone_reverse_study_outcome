package com.stepos.ability.task.executor.permissionauth;

import y7.InterfaceC2137b;
import z4.AbstractC2176h;
import z4.C2175g;

/* loaded from: classes3.dex */
public final class PendingPermissionAuth_Factory implements InterfaceC2137b {
    public static PendingPermissionAuth_Factory create() {
        return AbstractC2176h.f6963a;
    }

    public static C2175g newInstance() {
        return new C2175g();
    }

    @Override // javax.inject.Provider
    public C2175g get() {
        return newInstance();
    }
}
