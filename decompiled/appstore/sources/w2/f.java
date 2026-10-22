package w2;

import com.bytedance.apm.constant.PerfTraceConsts;
import com.bytedance.apm6.cpu.ApmCpuManager;
import com.bytedance.apm6.cpu.exception.StateType;
import com.bytedanceos.common.ad.common.AdConstant;

/* JADX INFO: loaded from: classes.dex */
public class f extends a {
    public f(v2.d r10) {
        super(r10);
    }

    @Override // w2.a
    public long d() {
        u2.b r10 = this.f25296b;
        if (r10 != null) goto L10;
        if (this.f25298d == true) goto L14;
        return PerfTraceConsts.LAUNCH_TRACE_COLLECT_INFO_TIME_MS;
    L14:
        return AdConstant.SPLASH_AD_INTERVAL;
    L10:
        if (this.f25298d == false) goto L13;
        return AdConstant.SPLASH_AD_INTERVAL;
    L13:
        return ((long) r10.g()) * 1000;
    }

    @Override // w2.a
    public boolean e(boolean r10) {
        if (r10 == false) goto L10;
        ApmCpuManager.ICpuExceptionFilter r11 = v2.c.c().a();
        if (r11 != null) goto L6;
    L9:
        this.f25050a.i();
        goto L10
    L6:
        if (r11.needFilter() == false) goto L9;
        return false;
    L10:
        return r10;
    }

    @Override // w2.a
    public boolean f() {
        return false;
    }

    @Override // com.bytedance.apm6.cpu.exception.ICpuExceptionState
    public StateType provideType() {
        return StateType.PROCESS_DETECT;
    }
}
