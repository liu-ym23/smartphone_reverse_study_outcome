package com.bytedance.apm6.cpu.exception;

import com.bytedance.apm6.cpu.config.CpuExceptionConfig;

/* JADX INFO: loaded from: classes2.dex */
public interface ICpuExceptionState {
    void onEnterThisState(CpuExceptionConfig r1, boolean r2);

    void onLifeCycleChange(boolean r1);

    void onStopDetect();

    StateType provideType();
}
