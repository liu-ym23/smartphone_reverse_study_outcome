package com.bytedance.apm6.cpu.exception.normal;

import com.bytedance.apm6.cpu.config.CpuExceptionConfig;
import com.bytedance.apm6.cpu.exception.BaseCpuExceptionState;
import com.bytedance.apm6.cpu.exception.CpuExceptionStateMachine;
import com.bytedance.apm6.cpu.exception.StateType;

/* JADX INFO: loaded from: classes2.dex */
public class NormalIdleState extends BaseCpuExceptionState {
    public NormalIdleState(CpuExceptionStateMachine r1) {
        super(r1);
    }

    @Override // com.bytedance.apm6.cpu.exception.BaseCpuExceptionState, com.bytedance.apm6.cpu.exception.ICpuExceptionState
    public void onEnterThisState(CpuExceptionConfig r1, boolean r2) {
        super.onEnterThisState(r1, r2);
        this.machine.onProcessDetect();
    }

    @Override // com.bytedance.apm6.cpu.exception.BaseCpuExceptionState, com.bytedance.apm6.cpu.exception.ICpuExceptionState
    public void onStopDetect() {
        super.onStopDetect();
    }

    @Override // com.bytedance.apm6.cpu.exception.BaseCpuExceptionState, com.bytedance.apm6.cpu.exception.ICpuExceptionState
    public void onLifeCycleChange(boolean r3) {
        super.onLifeCycleChange(r3);
        cpuExceptionLog("life cycle change when state is idle, lifecycle change to back?: " + r3);
        this.machine.onProcessDetect();
    }

    @Override // com.bytedance.apm6.cpu.exception.ICpuExceptionState
    public StateType provideType() {
        return StateType.IDLE;
    }
}
