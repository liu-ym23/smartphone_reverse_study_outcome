package com.stepos.taskrobot.base.util;

import android.content.Context;
import f6.C1438c;
import y7.InterfaceC2137b;

/* loaded from: classes3.dex */
public final class TaskRobotAccountUtil_Factory implements InterfaceC2137b {
    private final InterfaceC2137b contextProvider;

    private TaskRobotAccountUtil_Factory(InterfaceC2137b interfaceC2137b) {
        this.contextProvider = interfaceC2137b;
    }

    public static TaskRobotAccountUtil_Factory create(InterfaceC2137b interfaceC2137b) {
        return new TaskRobotAccountUtil_Factory(interfaceC2137b);
    }

    public static C1438c newInstance(Context context) {
        return new C1438c(context);
    }

    @Override // javax.inject.Provider
    public C1438c get() {
        return newInstance((Context) this.contextProvider.get());
    }
}
