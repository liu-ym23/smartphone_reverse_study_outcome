package com.stepos.ability.task.executor.permissionauth;

import y7.InterfaceC2137b;
import z4.AbstractC2170b;
import z4.C2169a;

/* loaded from: classes3.dex */
public final class AuthCallbackInbox_Factory implements InterfaceC2137b {
    public static AuthCallbackInbox_Factory create() {
        return AbstractC2170b.f6956a;
    }

    public static C2169a newInstance() {
        return new C2169a();
    }

    @Override // javax.inject.Provider
    public C2169a get() {
        return newInstance();
    }
}
