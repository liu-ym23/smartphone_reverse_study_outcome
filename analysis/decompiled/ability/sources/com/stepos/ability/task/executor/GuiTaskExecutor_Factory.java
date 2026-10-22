package com.stepos.ability.task.executor;

import com.stepos.ability.api.task.listener.ITaskListener;
import com.stepos.ability.report.IReportManager;
import y7.InterfaceC2137b;

/* loaded from: classes3.dex */
public final class GuiTaskExecutor_Factory implements InterfaceC2137b {
    private final InterfaceC2137b reportManagerProvider;
    private final InterfaceC2137b taskListenerProvider;

    private GuiTaskExecutor_Factory(InterfaceC2137b interfaceC2137b, InterfaceC2137b interfaceC2137b2) {
        this.taskListenerProvider = interfaceC2137b;
        this.reportManagerProvider = interfaceC2137b2;
    }

    public static GuiTaskExecutor_Factory create(InterfaceC2137b interfaceC2137b, InterfaceC2137b interfaceC2137b2) {
        return new GuiTaskExecutor_Factory(interfaceC2137b, interfaceC2137b2);
    }

    public static d newInstance(ITaskListener iTaskListener, IReportManager iReportManager) {
        return new d(iTaskListener, iReportManager);
    }

    @Override // javax.inject.Provider
    public d get() {
        return newInstance((ITaskListener) this.taskListenerProvider.get(), (IReportManager) this.reportManagerProvider.get());
    }
}
