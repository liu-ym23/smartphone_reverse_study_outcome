package w2;

import com.bytedance.apm.constant.StoreConsts;
import com.bytedance.apm6.cpu.exception.StateType;
import com.bytedance.apm6.util.timetask.AsyncTaskManagerType;

/* JADX INFO: loaded from: classes.dex */
public class c extends v2.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public u3.a f25305b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f25306c;

    public class a extends u3.a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ v2.d f25307d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ c f25308e;

        public a(c r10, long r11, long r12, v2.d r13) {
            this.f25308e = r10;
            this.f25307d = r13;
            super(r11, r12);
        }

        @Override // java.lang.Runnable
        public void run() {
            c.c(this.f25308e, "cool down task run, is back?: " + c.b(this.f25308e));
            this.f25307d.f();
        }
    }

    public c(v2.d r10) {
        super(r10);
        this.f25306c = false;
        this.f25305b = new a(this, d(), 0, r10);
    }

    public static /* synthetic */ boolean b(c r10) {
        return r10.f25306c;
    }

    public static /* synthetic */ void c(c r10, String r11) {
        r10.a(r11);
    }

    public final long d() {
        if (this.f25306c == false) goto L5;
        return StoreConsts.CHECK_FREE_DISK_INTERVAL_MS;
    L5:
        return 120000;
    }

    @Override // v2.a, com.bytedance.apm6.cpu.exception.ICpuExceptionState
    public void onEnterThisState(u2.b r10, boolean r11) {
        super.onEnterThisState(r10, r11);
        u3.a r12 = this.f25305b;
        if (r12 == null) goto L5;
        r12.d(d(), 0);
    L5:
        u3.b.a(AsyncTaskManagerType.LIGHT_WEIGHT).c(this.f25305b);
    }

    @Override // v2.a, com.bytedance.apm6.cpu.exception.ICpuExceptionState
    public void onLifeCycleChange(boolean r10) {
        super.onLifeCycleChange(r10);
        this.f25306c = r10;
    }

    @Override // v2.a, com.bytedance.apm6.cpu.exception.ICpuExceptionState
    public void onStopDetect() {
        super.onStopDetect();
        u3.b.a(AsyncTaskManagerType.LIGHT_WEIGHT).b(this.f25305b);
    }

    @Override // com.bytedance.apm6.cpu.exception.ICpuExceptionState
    public StateType provideType() {
        return StateType.COOL_DOWN;
    }
}
