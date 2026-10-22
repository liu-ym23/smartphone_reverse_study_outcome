package w2;

import com.bytedance.apm6.cpu.exception.StateType;

/* JADX INFO: loaded from: classes.dex */
public class e extends v2.a {
    public e(v2.d r10) {
        super(r10);
    }

    @Override // v2.a, com.bytedance.apm6.cpu.exception.ICpuExceptionState
    public void onEnterThisState(u2.b r10, boolean r11) {
        super.onEnterThisState(r10, r11);
        this.f25050a.h();
    }

    @Override // v2.a, com.bytedance.apm6.cpu.exception.ICpuExceptionState
    public void onLifeCycleChange(boolean r10) {
        super.onLifeCycleChange(r10);
        a("life cycle change when state is idle, lifecycle change to back?: " + r10);
        this.f25050a.h();
    }

    @Override // v2.a, com.bytedance.apm6.cpu.exception.ICpuExceptionState
    public void onStopDetect() {
        super.onStopDetect();
    }

    @Override // com.bytedance.apm6.cpu.exception.ICpuExceptionState
    public StateType provideType() {
        return StateType.IDLE;
    }
}
