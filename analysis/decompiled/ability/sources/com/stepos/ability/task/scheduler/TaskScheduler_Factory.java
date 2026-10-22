package com.stepos.ability.task.scheduler;

import com.stepos.ability.api.task.executor.ITaskExecutor;
import y7.InterfaceC2137b;

/* loaded from: classes3.dex */
public final class TaskScheduler_Factory implements InterfaceC2137b {
    private final InterfaceC2137b taskExecutorProvider;

    private TaskScheduler_Factory(InterfaceC2137b interfaceC2137b) {
        this.taskExecutorProvider = interfaceC2137b;
    }

    public static TaskScheduler_Factory create(InterfaceC2137b interfaceC2137b) {
        return new TaskScheduler_Factory(interfaceC2137b);
    }

    public static a newInstance(ITaskExecutor iTaskExecutor) {
        return new a(iTaskExecutor);
    }

    @Override // javax.inject.Provider
    public a get() {
        return newInstance((ITaskExecutor) this.taskExecutorProvider.get());
    }
}
