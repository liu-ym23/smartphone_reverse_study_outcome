package w2;

import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.apm6.cpu.exception.StateType;

/* JADX INFO: loaded from: classes.dex */
public class g extends a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f25316e;

    public g(v2.d r10) {
        super(r10);
        this.f25316e = 0;
    }

    @Override // w2.a
    public long d() {
        if (this.f25298d == false) goto L5;
        return 300000;
    L5:
        return PerfConsts.DEFAULT_SERIOUS_BLOCK_INTERVAL_MS;
    }

    @Override // w2.a
    public boolean e(boolean r10) {
        if (r10 == false) goto L9;
        this.f25316e++;
        a("over time: " + this.f25316e + " max over time: 2");
        if (this.f25316e < 2) goto L8;
        this.f25316e = 0;
        this.f25050a.j();
        return true;
    L8:
        return false;
    L9:
        this.f25316e = 0;
        this.f25050a.h();
        return true;
    }

    @Override // w2.a
    public boolean f() {
        this.f25316e = 0;
        this.f25050a.h();
        return true;
    }

    @Override // w2.a, v2.a, com.bytedance.apm6.cpu.exception.ICpuExceptionState
    public void onLifeCycleChange(boolean r10) {
        if (r10 == false) goto L4;
        this.f25316e = 0;
    L4:
        super.onLifeCycleChange(r10);
    }

    @Override // com.bytedance.apm6.cpu.exception.ICpuExceptionState
    public StateType provideType() {
        return StateType.PROCESS_DOUBLE_DETECT;
    }
}
