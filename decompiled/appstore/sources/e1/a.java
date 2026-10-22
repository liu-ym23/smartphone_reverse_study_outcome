package e1;

import android.os.SystemClock;
import com.bytedance.apm.battery.config.Constants;
import com.bytedance.apm.battery.stats.IBatteryStats;
import com.bytedance.apm.thread.AsyncEventManager;

/* JADX INFO: loaded from: classes.dex */
public abstract class a extends c implements IBatteryStats {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Object f19230j = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile int f19231f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile long f19232g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f19233h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f19234i;

    /* JADX INFO: renamed from: e1.a$a, reason: collision with other inner class name */
    public class RunnableC0237a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f19235a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f19236b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ a f19237c;

        public RunnableC0237a(a r10, long r11, boolean r12) {
            this.f19237c = r10;
            this.f19235a = r11;
            this.f19236b = r12;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.d(this.f19237c, this.f19235a, this.f19236b, y0.a.E().D());
        }
    }

    static {
        f19230j = new Object();
    }

    public a(String r10) {
        super(r10);
        this.f19231f = 0;
    }

    public static /* synthetic */ void d(a r10, long r11, boolean r12, String r13) {
        r10.g(r11, r12, r13);
    }

    @Override // e1.c
    public void a(f1.b r10, long r11, long r12) {
        this.f19234i++;
        long r13 = r10.f19438a;
        if (r13 < r11) goto L6;
        r11 = r13;
    L6:
        long r14 = r10.f19439b;
        if (r14 > 0) goto L9;
    L12:
        j(r10, r12 - r13);
        long r15 = r12 - r11;
        if (r15 <= 0) goto L16;
        this.f19233h += r15;
        return;
    L16:
        return;
    L9:
        if (r12 < r14) goto L12;
        r12 = r14;
        goto L12
    }

    @Override // e1.c
    public void c(long r10, long r11, boolean r13) {
        this.f19234i = 0;
        this.f19233h = 0;
        f(r13);
        super.c(r10, r11, r13);
        long r12 = System.currentTimeMillis();
        i(((this.f19233h / (r12 - this.f19243b)) * 60000.0d) * 10.0d, ((((double) this.f19234i) / (r12 - this.f19243b)) * 60000.0d) * 10.0d);
    }

    public void e() {
        Object r10 = f19230j;
        monitor-enter(r10);
        s1.a.d(Constants.TAG_BATTERY, "addHolderCount:" + this.f19231f + " type:" + b());     // Catch: Throwable -> L7
        this.f19231f = this.f19231f + 1;     // Catch: Throwable -> L7
        if (this.f19231f != 1) goto L9;
        this.f19232g = SystemClock.elapsedRealtime();     // Catch: Throwable -> L7
    L9:
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void f(boolean r10) {
        Object r11 = f19230j;
        monitor-enter(r11);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.f19231f > 0) goto L7;
    L14:
        monitor-exit(r11);     // Catch: Throwable -> L11
        return;
    L7:
        if (this.f19232g <= 0) goto L14;
        long r12 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L11
        if (r10 == false) goto L13;
        g(r12 - this.f19232g, this.f19244c, y0.a.E().D());     // Catch: Throwable -> L11
    L13:
        this.f19232g = r12;     // Catch: Throwable -> L11
        goto L14
    }

    public final void g(long r11, boolean r13, String r14) {
        p1.a r10 = new p1.a(r13, System.currentTimeMillis(), b(), this.f19245d, r11, r14);
        d1.a.h().l(r10);
    }

    public void h() {
        Object r10 = f19230j;
        monitor-enter(r10);
        s1.a.d(Constants.TAG_BATTERY, "reduceHolderCount:" + this.f19231f + " type:" + b());     // Catch: Throwable -> L8
        if (this.f19231f != 0) goto L10;
        monitor-exit(r10);     // Catch: Throwable -> L8
        return;
    L10:
        this.f19231f--;     // Catch: Throwable -> L8
        if (this.f19231f != 0) goto L13;
        boolean r11 = this.f19244c;     // Catch: Throwable -> L8
        AsyncEventManager.e().h(new RunnableC0237a(this, SystemClock.elapsedRealtime() - this.f19232g, r11));     // Catch: Throwable -> L8
        this.f19232g = -1;     // Catch: Throwable -> L8
    L13:
        monitor-exit(r10);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public abstract void i(double r10, double r11);

    public abstract void j(f1.b r10, long r11);

    @Override // e1.c, com.bytedance.apm.battery.stats.IBatteryStats
    public void onBack(boolean r10) {
        f(r10);
        super.onBack(r10);
    }

    @Override // com.bytedance.apm.battery.stats.IBatteryStats
    public void onChargeStatusChange(boolean r10, boolean r11) {
        f(r11);
        this.f19245d = r10;
    }

    @Override // e1.c, com.bytedance.apm.battery.stats.IBatteryStats
    public void onFront(boolean r10) {
        f(r10);
        super.onFront(r10);
    }

    @Override // com.bytedance.apm.battery.stats.IBatteryStats
    public void startSceneMonitor(String r10, boolean r11) {
        f(r11);
    }

    @Override // com.bytedance.apm.battery.stats.IBatteryStats
    public void stopSceneMonitor(String r10, boolean r11) {
        f(r11);
    }
}
