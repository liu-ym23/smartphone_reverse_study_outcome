package l0;

import android.content.Context;
import android.text.TextUtils;
import androidx.work.Configuration;
import androidx.work.WorkInfo;
import androidx.work.i;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.Scheduler;
import androidx.work.impl.c0;
import androidx.work.impl.constraints.WorkConstraintsCallback;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.constraints.trackers.m;
import androidx.work.impl.model.o;
import androidx.work.impl.model.q;
import androidx.work.impl.t;
import androidx.work.impl.u;
import androidx.work.impl.utils.n;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class b implements Scheduler, WorkConstraintsCallback, ExecutionListener {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f21783j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f21784a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c0 f21785b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final WorkConstraintsTracker f21786c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set f21787d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f21788e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f21789f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Object f21790g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final u f21791h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Boolean f21792i;

    static {
        f21783j = i.i("GreedyScheduler");
    }

    public b(Context r10, Configuration r11, m r12, c0 r13) {
        this.f21787d = new HashSet();
        this.f21791h = new u();
        this.f21784a = r10;
        this.f21785b = r13;
        this.f21786c = new androidx.work.impl.constraints.b(r12, this);
        this.f21788e = new a(this, r11.k());
        this.f21790g = new Object();
    }

    public final void a() {
        Configuration r10 = this.f21785b.j();
        this.f21792i = Boolean.valueOf(n.b(this.f21784a, r10));
    }

    public final void b() {
        if (this.f21789f == true) goto L6;
        this.f21785b.n().c(this);
        this.f21789f = true;
        return;
    }

    public final void c(androidx.work.impl.model.i r10) {
        Object r11 = this.f21790g;
        monitor-enter(r11);
        Iterator r12 = this.f21787d.iterator();     // Catch: Throwable -> L10
    L6:
        if (r12.hasNext() == false) goto L12;
        o r13 = (o) r12.next();     // Catch: Throwable -> L10
        if (q.a(r13).equals(r10) == false) goto L6;
        i.e().a(f21783j, "Stopping tracking for " + r10);     // Catch: Throwable -> L10
        this.f21787d.remove(r13);     // Catch: Throwable -> L10
        this.f21786c.replace(this.f21787d);     // Catch: Throwable -> L10
    L12:
        monitor-exit(r11);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // androidx.work.impl.Scheduler
    public void cancel(String r10) {
        if (this.f21792i != null) goto L6;
        a();
    L6:
        if (this.f21792i.booleanValue() == true) goto L9;
        i.e().f(f21783j, "Ignoring schedule request in non-main process");
        return;
    L9:
        b();
        i.e().a(f21783j, "Cancelling work ID " + r10);
        a r11 = this.f21788e;
        if (r11 == null) goto L12;
        r11.b(r10);
    L12:
        Iterator r12 = this.f21791h.c(r10).iterator();
    L14:
        if (r12.hasNext() == false) goto L16;
        this.f21785b.z((t) r12.next());
        goto L14
    }

    @Override // androidx.work.impl.Scheduler
    public boolean hasLimitedSchedulingSlots() {
        return false;
    }

    @Override // androidx.work.impl.constraints.WorkConstraintsCallback
    public void onAllConstraintsMet(List r10) {
        Iterator r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        androidx.work.impl.model.i r12 = q.a((o) r11.next());
        if (this.f21791h.a(r12) == true) goto L4;
        i.e().a(f21783j, "Constraints met: Scheduling work ID " + r12);
        this.f21785b.w(this.f21791h.d(r12));
        goto L4
    }

    @Override // androidx.work.impl.constraints.WorkConstraintsCallback
    public void onAllConstraintsNotMet(List r10) {
        Iterator r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        androidx.work.impl.model.i r12 = q.a((o) r11.next());
        i.e().a(f21783j, "Constraints not met: Cancelling work ID " + r12);
        t r13 = this.f21791h.b(r12);
        if (r13 == null) goto L4;
        this.f21785b.z(r13);
        goto L4
    }

    @Override // androidx.work.impl.ExecutionListener
    public void onExecuted(androidx.work.impl.model.i r10, boolean r11) {
        this.f21791h.b(r10);
        c(r10);
    }

    @Override // androidx.work.impl.Scheduler
    public void schedule(o... r12) {
        if (this.f21792i != null) goto L6;
        a();
    L6:
        if (this.f21792i.booleanValue() == true) goto L9;
        i.e().f(f21783j, "Ignoring schedule request in a secondary process");
        return;
    L9:
        b();
        HashSet r10 = new HashSet();
        HashSet r11 = new HashSet();
        int r13 = r12.length;
        int r14 = 0;
    L10:
        if (r14 >= r13) goto L34;
        o r15 = r12[r14];
        if (this.f21791h.a(q.a(r15)) == true) goto L33;
        long r16 = r15.c();
        long r17 = System.currentTimeMillis();
        if (r15.f5671b != WorkInfo.State.ENQUEUED) goto L33;
        if (r17 >= r16) goto L22;
        a r18 = this.f21788e;
        if (r18 == null) goto L33;
        r18.a(r15);
        goto L33
    L22:
        if (r15.f() == false) goto L31;
        if (r15.f5679j.h() == false) goto L27;
        i.e().a(f21783j, "Ignoring " + r15 + ". Requires device idle.");
        goto L33
    L27:
        if (r15.f5679j.e() == false) goto L29;
        i.e().a(f21783j, "Ignoring " + r15 + ". Requires ContentUri triggers.");
        goto L33
    L29:
        r10.add(r15);
        r11.add(r15.f5670a);
        goto L33
    L31:
        if (this.f21791h.a(q.a(r15)) == true) goto L33;
        i.e().a(f21783j, "Starting work for " + r15.f5670a);
        this.f21785b.w(this.f21791h.e(r15));
    L33:
        r14 = r14 + 1;
        goto L10
    L34:
        Object r19 = this.f21790g;
        monitor-enter(r19);
    L39:
        th = move-exception;
        throw th;
    L37:
        if (r10.isEmpty() == true) goto L41;
        String r20 = TextUtils.join(",", r11);     // Catch: Throwable -> L39
        i.e().a(f21783j, "Starting tracking for " + r20);     // Catch: Throwable -> L39
        this.f21787d.addAll(r10);     // Catch: Throwable -> L39
        this.f21786c.replace(this.f21787d);     // Catch: Throwable -> L39
    L41:
        monitor-exit(r19);     // Catch: Throwable -> L39
    }
}
