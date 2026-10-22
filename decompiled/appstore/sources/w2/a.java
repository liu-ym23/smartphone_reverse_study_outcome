package w2;

import com.bytedance.apm6.util.timetask.AsyncTaskManagerType;
import com.bytedance.watson.assist.api.IAssistStat;

/* JADX INFO: loaded from: classes.dex */
public abstract class a extends v2.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public u2.b f25296b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public u3.a f25297c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f25298d;

    /* JADX INFO: renamed from: w2.a$a, reason: collision with other inner class name */
    public class C0399a extends u3.a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ a f25299d;

        public C0399a(a r10, long r11, long r12) {
            this.f25299d = r10;
            super(r11, r12);
        }

        @Override // java.lang.Runnable
        public void run() {
            a.b(this.f25299d);
        }
    }

    public a(v2.d r10) {
        super(r10);
    }

    public static /* synthetic */ void b(a r10) {
        r10.c();
    }

    public final void c() {
        if (v2.b.c() == true) goto L5;
        double r10 = v2.e.a();
        IAssistStat r11 = this.f25050a.b();
        if (r11 == null) goto L13;
        boolean r12 = r11.isCpuAbnormalProcess((float) r10);
        if (r12 == false) goto L14;
        r12 = v2.b.e(this.f25296b, r10, this.f25298d);
    L14:
        a("run judge process cpu usage task, is over max threshold?: " + r12 + " speed: " + r10 + ", back max speed: " + this.f25296b.c() + ", fore max speed: " + this.f25296b.d());
        if (e(r12) == false) goto L19;
        u3.b.a(AsyncTaskManagerType.CPU).b(this.f25297c);
        return;
    L19:
        return;
    L13:
        r12 = v2.b.e(this.f25296b, r10, this.f25298d);
        goto L14
    L5:
        if (f() == false) goto L18;
        u3.b.a(AsyncTaskManagerType.CPU).b(this.f25297c);
        return;
    }

    public abstract long d();

    public abstract boolean e(boolean r10);

    public abstract boolean f();

    @Override // v2.a, com.bytedance.apm6.cpu.exception.ICpuExceptionState
    public void onEnterThisState(u2.b r10, boolean r11) {
        super.onEnterThisState(r10, r11);
        this.f25296b = r10;
        this.f25298d = r11;
        s3.a.d("APM-CPU", "enter : " + provideType() + " provideDetectInterval : " + d() + " isBack : " + r11);
        u3.a r12 = this.f25297c;
        if (r12 != null) goto L5;
        this.f25297c = new C0399a(this, d(), d());
    L6:
        u3.b.a(AsyncTaskManagerType.CPU).c(this.f25297c);
        return;
    L5:
        r12.d(d(), d());
        goto L6
    }

    @Override // v2.a, com.bytedance.apm6.cpu.exception.ICpuExceptionState
    public void onLifeCycleChange(boolean r10) {
        super.onLifeCycleChange(r10);
        u3.b.a(AsyncTaskManagerType.CPU).b(this.f25297c);
        this.f25050a.f();
    }

    @Override // v2.a, com.bytedance.apm6.cpu.exception.ICpuExceptionState
    public void onStopDetect() {
        super.onStopDetect();
        u3.b.a(AsyncTaskManagerType.CPU).b(this.f25297c);
    }
}
