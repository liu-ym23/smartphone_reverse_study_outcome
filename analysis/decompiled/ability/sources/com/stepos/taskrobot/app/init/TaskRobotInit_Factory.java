package com.stepos.taskrobot.app.init;

import f6.C1438c;
import y7.InterfaceC2137b;

/* loaded from: classes3.dex */
public final class TaskRobotInit_Factory implements InterfaceC2137b {
    private final InterfaceC2137b taskRobotAccountUtilProvider;

    private TaskRobotInit_Factory(InterfaceC2137b interfaceC2137b) {
        this.taskRobotAccountUtilProvider = interfaceC2137b;
    }

    public static TaskRobotInit_Factory create(InterfaceC2137b interfaceC2137b) {
        return new TaskRobotInit_Factory(interfaceC2137b);
    }

    public static TaskRobotInit newInstance(C1438c c1438c) {
        return new TaskRobotInit(c1438c);
    }

    @Override // javax.inject.Provider
    public TaskRobotInit get() {
        return newInstance((C1438c) this.taskRobotAccountUtilProvider.get());
    }
}
