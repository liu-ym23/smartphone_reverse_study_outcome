package bs3;

import android.os.SystemClock;
import com.larus.apm.impl.protector.RunnableProtector;
import cs3.b;

/* JADX INFO: loaded from: classes14.dex */
public abstract class a<T extends cs3.b> extends c<T> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Object f20226j = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile int f20227f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile long f20228g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f20229h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f20230i;

    /* JADX INFO: renamed from: bs3.a$a, reason: collision with other inner class name */
    public class RunnableC0353a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f20231a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f20232b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ a f20233c;

        @Override // java.lang.Runnable
        public final void run() {
            a r100 = this.f20233c;     // Catch: Throwable -> L4
            long r101 = this.f20231a;     // Catch: Throwable -> L4
            boolean r102 = this.f20232b;     // Catch: Throwable -> L4
            Object r103 = vr3.b.C;     // Catch: Throwable -> L4
            String r104 = vr3.b.e.f556835a.f556824u;     // Catch: Throwable -> L4
            r100.getClass();     // Catch: Throwable -> L4
            ms3.a r110 = new ms3.a(r102, System.currentTimeMillis(), r100.getType(), r100.f20241d, r101, r104);     // Catch: Throwable -> L4
            as3.b.a.f16095a.g(r110);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public RunnableC0353a(a r100, long r101, boolean r102) {
            this.f20233c = r100;
            this.f20231a = r101;
            this.f20232b = r102;
        }
    }

    public abstract void o(double r100, double r101);

    public abstract void p(T r100, long r101);

    static {
        f20226j = new Object();
    }

    public final void l() {
        Object r100 = f20226j;
        monitor-enter(r100);
        getType();     // Catch: Throwable -> L9
        this.f20227f++;     // Catch: Throwable -> L9
        if (this.f20227f != 1) goto L7;
        this.f20228g = SystemClock.elapsedRealtime();     // Catch: Throwable -> L9
    L7:
        monitor-exit(r100);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public final void n() {
        Object r100 = f20226j;
        monitor-enter(r100);
        getType();     // Catch: Throwable -> L13
        if (this.f20227f != 0) goto L8;
        monitor-exit(r100);     // Catch: Throwable -> L13
        return;
    L8:
        this.f20227f--;     // Catch: Throwable -> L13
        if (this.f20227f != 0) goto L11;
        boolean r101 = this.f20240c;     // Catch: Throwable -> L13
        bt3.b.d.f20539a.e(new RunnableC0353a(this, SystemClock.elapsedRealtime() - this.f20228g, r101));     // Catch: Throwable -> L13
        this.f20228g = -1;     // Catch: Throwable -> L13
    L11:
        monitor-exit(r100);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public a(String r100) {
        super(r100);
        this.f20227f = 0;
    }

    @Override // bs3.l
    public final void d(boolean r100) {
        m(r100);
    }

    @Override // bs3.c, bs3.l
    public final void f(boolean r100) {
        m(r100);
        this.f20240c = false;
    }

    @Override // bs3.c, bs3.l
    public final void h(boolean r100) {
        m(r100);
        this.f20240c = true;
    }

    @Override // bs3.l
    public final void i(boolean r100) {
        m(r100);
    }

    public final void m(boolean r110) {
        Object r100 = f20226j;
        monitor-enter(r100);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.f20227f > 0) goto L7;
    L12:
        monitor-exit(r100);     // Catch: Throwable -> L14
        return;
    L7:
        if (this.f20228g <= 0) goto L12;
        long r101 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L14
        if (r110 == false) goto L11;
        long r111 = r101 - this.f20228g;     // Catch: Throwable -> L14
        boolean r102 = this.f20240c;     // Catch: Throwable -> L14
        Object r112 = vr3.b.C;     // Catch: Throwable -> L14
        String r113 = vr3.b.e.f556835a.f556824u;     // Catch: Throwable -> L14
        ms3.a r114 = new ms3.a(r102, System.currentTimeMillis(), getType(), this.f20241d, r111, r113);     // Catch: Throwable -> L14
        as3.b.a.f16095a.g(r114);     // Catch: Throwable -> L14
    L11:
        this.f20228g = r101;     // Catch: Throwable -> L14
        goto L12
    }

    @Override // bs3.l
    public final void c(boolean r100, boolean r101) {
        m(r101);
        this.f20241d = r100;
    }

    @Override // bs3.c
    public final void j(T r100, long r101, long r110) {
        this.f20230i++;
        long r102 = r100.f465171a;
        if (r102 < r101) goto L6;
        r101 = r102;
    L6:
        long r103 = r100.f465172b;
        if (r103 > 0) goto L9;
    L12:
        p(r100, r110 - r102);
        long r111 = r110 - r101;
        if (r111 <= 0) goto L16;
        this.f20229h += r111;
        return;
    L16:
        return;
    L9:
        if (r110 < r103) goto L12;
        r110 = r103;
        goto L12
    }

    @Override // bs3.c
    public final void k(long r100, long r110, boolean r111) {
        this.f20230i = 0;
        this.f20229h = 0;
        m(r111);
        super.k(r100, r110, r111);
        long r101 = System.currentTimeMillis();
        o(((this.f20229h / (r101 - this.f20239b)) * 60000.0d) * 10.0d, ((((double) this.f20230i) / (r101 - this.f20239b)) * 60000.0d) * 10.0d);
    }
}
