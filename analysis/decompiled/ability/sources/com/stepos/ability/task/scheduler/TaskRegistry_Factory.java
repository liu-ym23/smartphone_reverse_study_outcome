package com.stepos.ability.task.scheduler;

import B4.b;
import B4.c;
import y7.InterfaceC2137b;

/* loaded from: classes3.dex */
public final class TaskRegistry_Factory implements InterfaceC2137b {
    public static TaskRegistry_Factory create() {
        return c.f192a;
    }

    public static b newInstance() {
        return new b();
    }

    @Override // javax.inject.Provider
    public b get() {
        return newInstance();
    }
}
