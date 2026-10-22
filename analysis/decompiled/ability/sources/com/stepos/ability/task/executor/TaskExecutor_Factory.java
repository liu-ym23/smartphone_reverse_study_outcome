package com.stepos.ability.task.executor;

import com.stepos.ability.api.task.executor.ITaskExecutor;
import com.stepos.ability.api.task.listener.ITaskListener;
import java.util.Map;
import y7.InterfaceC2137b;

/* loaded from: classes3.dex */
public final class TaskExecutor_Factory implements InterfaceC2137b {
    private final InterfaceC2137b executorMapProvider;
    private final InterfaceC2137b taskListenerProvider;

    private TaskExecutor_Factory(InterfaceC2137b interfaceC2137b, InterfaceC2137b interfaceC2137b2) {
        this.taskListenerProvider = interfaceC2137b;
        this.executorMapProvider = interfaceC2137b2;
    }

    public static TaskExecutor_Factory create(InterfaceC2137b interfaceC2137b, InterfaceC2137b interfaceC2137b2) {
        return new TaskExecutor_Factory(interfaceC2137b, interfaceC2137b2);
    }

    public static f newInstance(ITaskListener iTaskListener, Map<Integer, ITaskExecutor> map) {
        return new f(iTaskListener, map);
    }

    @Override // javax.inject.Provider
    public f get() {
        return newInstance((ITaskListener) this.taskListenerProvider.get(), (Map) this.executorMapProvider.get());
    }
}
