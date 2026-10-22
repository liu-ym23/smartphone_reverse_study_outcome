package com.stepos.ability.screenops.init;

import w4.b;
import y7.InterfaceC2137b;

/* loaded from: classes3.dex */
public final class ScreenOpsInit_Factory implements InterfaceC2137b {
    public static ScreenOpsInit_Factory create() {
        return b.f6848a;
    }

    public static ScreenOpsInit newInstance() {
        return new ScreenOpsInit();
    }

    @Override // javax.inject.Provider
    public ScreenOpsInit get() {
        return newInstance();
    }
}
