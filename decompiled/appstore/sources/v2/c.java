package v2;

import com.bytedance.apm6.cpu.ApmCpuManager;
import com.bytedance.apm6.cpu.exception.ICpuExceptionPolicy;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f25052a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ICpuExceptionPolicy f25053b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public u2.b f25054c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f25055d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f25056e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ApmCpuManager.ICpuExceptionListener f25057f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ApmCpuManager.ICpuExceptionFilter f25058g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f25059h;

    public static /* synthetic */ class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f25060a = null;

        static {
            f25060a = new c(null);
        }

        public static /* synthetic */ c a() {
            return f25060a;
        }
    }

    public /* synthetic */ c(a r10) {
        this();
    }

    public static c c() {
        return b.a();
    }

    public ApmCpuManager.ICpuExceptionFilter a() {
        return this.f25058g;
    }

    public ApmCpuManager.ICpuExceptionListener b() {
        return this.f25057f;
    }

    public synchronized boolean d() {
        monitor-enter(this);
        boolean r10 = this.f25055d;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    L6:
        th = move-exception;
        throw th;
    }

    public void e(long r10) {
        this.f25056e = r10;
    }

    public synchronized void f(u2.b r10) {
        monitor-enter(this);
        if (r10 != null) goto L29;
        monitor-exit(this);
        return;
    L29:
    L12:
        th = move-exception;
        throw th;
    L7:
        if (d3.a.A() == false) goto L9;
    L14:
        this.f25054c = r10;     // Catch: Throwable -> L12
        if (this.f25059h == false) goto L22;
        if (this.f25052a == true) goto L19;
        this.f25052a = true;     // Catch: Throwable -> L12
        this.f25055d = r10.l();     // Catch: Throwable -> L12
        this.f25053b.startDetect(r10);     // Catch: Throwable -> L12
    L19:
        monitor-exit(this);
        return;
    L22:
        if (r10.m() == false) goto L24;
        this.f25052a = true;     // Catch: Throwable -> L12
        this.f25055d = r10.l();     // Catch: Throwable -> L12
        this.f25053b.startDetect(r10);     // Catch: Throwable -> L12
    L25:
        monitor-exit(this);
        return;
    L24:
        this.f25052a = false;     // Catch: Throwable -> L12
        this.f25053b.stopDetect();     // Catch: Throwable -> L12
        goto L25
    L9:
        if (r10.i() == true) goto L14;
        monitor-exit(this);
    }

    public c() {
        this.f25053b = new w2.d();
    }
}
