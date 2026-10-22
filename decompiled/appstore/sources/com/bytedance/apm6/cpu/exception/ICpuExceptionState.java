package com.bytedance.apm6.cpu.exception;

import u2.b;

/* JADX INFO: loaded from: classes.dex */
public interface ICpuExceptionState {
    void onEnterThisState(b r10, boolean r11);

    void onLifeCycleChange(boolean r10);

    void onStopDetect();

    StateType provideType();
}
