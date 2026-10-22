package com.stepos.ability.task.executor;

import y7.InterfaceC2137b;

/* loaded from: classes3.dex */
public final class ExecutorInit_Factory implements InterfaceC2137b {
    public static ExecutorInit_Factory create() {
        return b.f3310a;
    }

    public static ExecutorInit newInstance() {
        return new ExecutorInit();
    }

    @Override // javax.inject.Provider
    public ExecutorInit get() {
        return newInstance();
    }
}
