package v2;

import com.bytedance.apm6.cpu.ApmCpuManager;
import com.bytedance.apm6.cpu.exception.ICpuExceptionState;
import com.bytedance.apm6.service.lifecycle.ActivityLifecycleService;
import com.bytedance.watson.assist.api.IAssistStat;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f25061a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f25062b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f25063c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ActivityLifecycleService f25064d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public IAssistStat f25065e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ICpuExceptionState f25066f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public u2.b f25067g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ICpuExceptionState f25068h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ICpuExceptionState f25069i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ICpuExceptionState f25070j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ICpuExceptionState f25071k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ICpuExceptionState f25072l;

    public d(ActivityLifecycleService r10) {
        this.f25061a = false;
        this.f25062b = false;
        this.f25064d = r10;
    }

    public final void a(ICpuExceptionState r10) {
        if (this.f25061a == true) goto L5;
        return;
    L5:
        if (this.f25062b == false) goto L17;
        this.f25066f = r10;
        u2.b r11 = this.f25067g;
        ActivityLifecycleService r12 = this.f25064d;
        if (r12 != null) goto L10;
    L13:
        boolean r13 = true;
    L14:
        r10.onEnterThisState(r11, r13);
        d();
        return;
    L10:
        if (r12.isForeground() == false) goto L13;
        r13 = false;
        goto L14
    }

    public IAssistStat b() {
        return this.f25065e;
    }

    public void c(ICpuExceptionState r10, ICpuExceptionState r11, ICpuExceptionState r12, ICpuExceptionState r13, ICpuExceptionState r14) {
        if (this.f25062b == false) goto L5;
        return;
    L5:
        this.f25068h = r10;
        this.f25069i = r11;
        this.f25070j = r12;
        this.f25071k = r13;
        this.f25072l = r14;
        this.f25065e = t6.b.a(w0.c.g());     // Catch: Throwable -> L9
    L7:
        this.f25062b = true;
    }

    public final void d() {
        if (r3.a.c() == false) goto L6;
        s3.a.d("APM-CPU", "change cpu exception detect state: " + this.f25066f);
        return;
    }

    public synchronized void e() {
        monitor-enter(this);
        a(this.f25071k);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void f() {
        monitor-enter(this);
        a(this.f25072l);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void g(boolean r10) {
        monitor-enter(this);
        ICpuExceptionState r11 = this.f25066f;     // Catch: Throwable -> L15
        if (r11 != null) goto L6;
    L17:
        monitor-exit(this);
        return;
    L6:
        if (this.f25061a == false) goto L17;
        if (this.f25063c != r10) goto L12;
        monitor-exit(this);
        return;
    L12:
        this.f25063c = r10;     // Catch: Throwable -> L15
        r11.onLifeCycleChange(r10);     // Catch: Throwable -> L15
        monitor-exit(this);
        return;
    L15:
        th = move-exception;
        throw th;
    }

    public synchronized void h() {
        monitor-enter(this);
        a(this.f25068h);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void i() {
        monitor-enter(this);
        a(this.f25069i);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void j() {
        monitor-enter(this);
        a(this.f25070j);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void k(u2.b r10) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.f25061a == false) goto L6;
    L13:
        monitor-exit(this);
        return;
    L6:
        if (this.f25062b == false) goto L13;
        this.f25067g = r10;     // Catch: Throwable -> L11
        this.f25061a = true;     // Catch: Throwable -> L11
        b.b(ApmCpuManager.c().b());     // Catch: Throwable -> L11
        this.f25063c = true ^ this.f25064d.isForeground();     // Catch: Throwable -> L11
        h();     // Catch: Throwable -> L11
        monitor-exit(this);
    }

    public synchronized void l() {
        monitor-enter(this);
        ICpuExceptionState r10 = this.f25066f;     // Catch: Throwable -> L11
        if (r10 != null) goto L6;
    L13:
        monitor-exit(this);
        return;
    L6:
        if (this.f25061a == false) goto L13;
        r10.onStopDetect();     // Catch: Throwable -> L11
        this.f25061a = false;     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }
}
