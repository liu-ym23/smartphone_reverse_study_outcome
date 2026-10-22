package com.stepos.ability.monitor;

import y7.InterfaceC2137b;

/* loaded from: classes3.dex */
public final class MonitorImpl_Factory implements InterfaceC2137b {
    public static MonitorImpl_Factory create() {
        return l4.a.f5285a;
    }

    public static a newInstance() {
        return new a();
    }

    @Override // javax.inject.Provider
    public a get() {
        return newInstance();
    }
}
