package com.stepos.ability.task.listener;

import A4.a;
import com.stepos.ability.api.task.registry.ITaskRegistry;
import y7.InterfaceC2137b;

/* loaded from: classes3.dex */
public final class TaskListener_Factory implements InterfaceC2137b {
    private final InterfaceC2137b taskRegistryProvider;

    private TaskListener_Factory(InterfaceC2137b interfaceC2137b) {
        this.taskRegistryProvider = interfaceC2137b;
    }

    public static TaskListener_Factory create(InterfaceC2137b interfaceC2137b) {
        return new TaskListener_Factory(interfaceC2137b);
    }

    public static a newInstance(ITaskRegistry iTaskRegistry) {
        return new a(iTaskRegistry);
    }

    @Override // javax.inject.Provider
    public a get() {
        return newInstance((ITaskRegistry) this.taskRegistryProvider.get());
    }
}
