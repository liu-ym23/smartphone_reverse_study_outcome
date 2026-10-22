package androidx.room;

import androidx.lifecycle.LiveData;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public final class t0 extends LiveData {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final RoomDatabase f4652l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final k f4653m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f4654n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Callable f4655o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final m.c f4656p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final AtomicBoolean f4657q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final AtomicBoolean f4658r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final AtomicBoolean f4659s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Runnable f4660t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Runnable f4661u;

    public static final class a extends m.c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ t0 f4662b;

        public a(String[] r10, t0 r11) {
            this.f4662b = r11;
            super(r10);
        }

        @Override // androidx.room.m.c
        public void c(Set r10) {
            kotlin.jvm.internal.q.g(r10, "tables");
            h.c.h().b(this.f4662b.s());
        }
    }

    public t0(RoomDatabase r10, k r11, boolean r12, Callable r13, String[] r14) {
        kotlin.jvm.internal.q.g(r10, "database");
        kotlin.jvm.internal.q.g(r11, "container");
        kotlin.jvm.internal.q.g(r13, "computeFunction");
        kotlin.jvm.internal.q.g(r14, "tableNames");
        this.f4652l = r10;
        this.f4653m = r11;
        this.f4654n = r12;
        this.f4655o = r13;
        this.f4656p = new a(r14, this);
        this.f4657q = new AtomicBoolean(true);
        this.f4658r = new AtomicBoolean(false);
        this.f4659s = new AtomicBoolean(false);
        this.f4660t = new r0(this);
        this.f4661u = new s0(this);
    }

    public static /* synthetic */ void q(t0 r10) {
        u(r10);
    }

    public static /* synthetic */ void r(t0 r10) {
        v(r10);
    }

    public static final void u(t0 r10) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        boolean r11 = r10.g();
        if (r10.f4657q.compareAndSet(false, true) == false) goto L7;
        if (r11 == false) goto L8;
        r10.t().execute(r10.f4660t);
        return;
    L8:
        return;
    }

    public static final void v(t0 r10) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        if (r10.f4659s.compareAndSet(false, true) == false) goto L6;
        r10.f4652l.m().d(r10.f4656p);
    L6:
        if (r10.f4658r.compareAndSet(false, true) == false) goto L22;
        Object r11 = null;
        boolean r12 = false;
    L27:
    L12:
        th = move-exception;
        r10.f4658r.set(false);
        throw th;
    L9:
        if (r10.f4657q.compareAndSet(true, false) == false) goto L17;
        r11 = r10.f4655o.call();     // Catch: Throwable -> L12 Exception -> L14
        r12 = true;
        goto L27
    L14:
        e = move-exception;
        throw new RuntimeException("Exception while computing database live data.", e);     // Catch: Throwable -> L12
    L17:
        if (r12 == false) goto L19;
        r10.m(r11);     // Catch: Throwable -> L12
    L19:
        r10.f4658r.set(false);
    L23:
        if (r12 == false) goto L26;
        if (r10.f4657q.get() == true) goto L6;
        return;
    L26:
        return;
    L22:
        r12 = false;
        goto L23
    }

    @Override // androidx.lifecycle.LiveData
    public void k() {
        super.k();
        k r10 = this.f4653m;
        kotlin.jvm.internal.q.e(this, "null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.Any>");
        r10.b(this);
        t().execute(this.f4660t);
    }

    @Override // androidx.lifecycle.LiveData
    public void l() {
        super.l();
        k r10 = this.f4653m;
        kotlin.jvm.internal.q.e(this, "null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.Any>");
        r10.c(this);
    }

    public final Runnable s() {
        return this.f4661u;
    }

    public final Executor t() {
        if (this.f4654n == false) goto L6;
        return this.f4652l.s();
    L6:
        return this.f4652l.o();
    }
}
