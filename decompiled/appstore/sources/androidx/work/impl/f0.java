package androidx.work.impl;

import android.content.Context;
import androidx.work.Configuration;
import androidx.work.WorkInfo;
import androidx.work.WorkerParameters;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import androidx.work.impl.foreground.ForegroundProcessor;
import androidx.work.impl.model.DependencyDao;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.bytedance.librarian.LibrarianImpl;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes.dex */
public class f0 implements Runnable {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f5561s = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f5562a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5563b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List f5564c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public WorkerParameters.a f5565d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public androidx.work.impl.model.o f5566e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public androidx.work.h f5567f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TaskExecutor f5568g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public androidx.work.h.a f5569h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Configuration f5570i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ForegroundProcessor f5571j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public WorkDatabase f5572k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public WorkSpecDao f5573l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public DependencyDao f5574m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public List f5575n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f5576o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public androidx.work.impl.utils.futures.a f5577p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final androidx.work.impl.utils.futures.a f5578q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public volatile boolean f5579r;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ListenableFuture f5580a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ f0 f5581b;

        public a(f0 r10, ListenableFuture r11) {
            this.f5581b = r10;
            this.f5580a = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f5581b.f5578q.isCancelled() == false) goto L10;
            return;
        L10:
            this.f5580a.get();     // Catch: Throwable -> L7
            androidx.work.i.e().a(f0.f5561s, "Starting work for " + this.f5581b.f5566e.f5672c);     // Catch: Throwable -> L7
            f0 r10 = this.f5581b;     // Catch: Throwable -> L7
            r10.f5578q.r(r10.f5567f.l());     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            this.f5581b.f5578q.q(th);
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f5582a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ f0 f5583b;

        public b(f0 r10, String r11) {
            this.f5583b = r10;
            this.f5582a = r11;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v3, types: [androidx.work.impl.f0] */
        @Override // java.lang.Runnable
        public void run() {
            androidx.work.h.a r10 = (androidx.work.h.a) this.f5583b.f5578q.get();     // Catch: Throwable -> L5 Throwable -> L7 CancellationException -> L9
            if (r10 != null) goto L11;
            androidx.work.i.e().c(f0.f5561s, this.f5583b.f5566e.f5672c + " returned a null result. Treating it as a failure.");     // Catch: Throwable -> L5 Throwable -> L7 CancellationException -> L9
        L21:
        L12:
            b this = this.f5583b;
            this.j();
            return;
        L11:
            androidx.work.i.e().a(f0.f5561s, this.f5583b.f5566e.f5672c + " returned a " + r10 + LibrarianImpl.Constants.DOT);     // Catch: Throwable -> L5 Throwable -> L7 CancellationException -> L9
            this.f5583b.f5569h = r10;     // Catch: Throwable -> L5 Throwable -> L7 CancellationException -> L9
        L5:
            th = move-exception;
            this.f5583b.j();
            throw th;
        L7:
            e = move-exception;
            androidx.work.i.e().d(f0.f5561s, this.f5582a + " failed because it threw an exception/error", e);     // Catch: Throwable -> L5
        L9:
            e = move-exception;
            androidx.work.i.e().g(f0.f5561s, this.f5582a + " was cancelled", e);     // Catch: Throwable -> L5
            goto L12
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Context f5584a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public androidx.work.h f5585b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ForegroundProcessor f5586c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public TaskExecutor f5587d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Configuration f5588e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public WorkDatabase f5589f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public androidx.work.impl.model.o f5590g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public List f5591h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final List f5592i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public WorkerParameters.a f5593j;

        public c(Context r10, Configuration r11, TaskExecutor r12, ForegroundProcessor r13, WorkDatabase r14, androidx.work.impl.model.o r15, List r16) {
            this.f5593j = new WorkerParameters.a();
            this.f5584a = r10.getApplicationContext();
            this.f5587d = r12;
            this.f5586c = r13;
            this.f5588e = r11;
            this.f5589f = r14;
            this.f5590g = r15;
            this.f5592i = r16;
        }

        public static /* synthetic */ List a(c r10) {
            return r10.f5592i;
        }

        public f0 b() {
            return new f0(this);
        }

        public c c(WorkerParameters.a r10) {
            if (r10 == null) goto L4;
            this.f5593j = r10;
        L4:
            return this;
        }

        public c d(List r10) {
            this.f5591h = r10;
            return this;
        }
    }

    static {
        f5561s = androidx.work.i.i("WorkerWrapper");
    }

    public f0(c r10) {
        this.f5569h = androidx.work.h.a.a();
        this.f5577p = androidx.work.impl.utils.futures.a.t();
        this.f5578q = androidx.work.impl.utils.futures.a.t();
        this.f5562a = r10.f5584a;
        this.f5568g = r10.f5587d;
        this.f5571j = r10.f5586c;
        androidx.work.impl.model.o r11 = r10.f5590g;
        this.f5566e = r11;
        this.f5563b = r11.f5670a;
        this.f5564c = r10.f5591h;
        this.f5565d = r10.f5593j;
        this.f5567f = r10.f5585b;
        this.f5570i = r10.f5588e;
        WorkDatabase r12 = r10.f5589f;
        this.f5572k = r12;
        this.f5573l = r12.L();
        this.f5574m = this.f5572k.G();
        this.f5575n = c.a(r10);
    }

    public static /* synthetic */ void a(f0 r10, ListenableFuture r11) {
        r10.i(r11);
    }

    public final String b(List r10) {
        StringBuilder r11 = new StringBuilder("Work [ id=");
        r11.append(this.f5563b);
        r11.append(", tags={ ");
        Iterator r12 = r10.iterator();
        boolean r13 = true;
    L4:
        if (r12.hasNext() == false) goto L10;
        String r14 = (String) r12.next();
        if (r13 == false) goto L8;
        r13 = false;
    L9:
        r11.append(r14);
        goto L4
    L8:
        r11.append(", ");
        goto L9
    L10:
        r11.append(" } ]");
        return r11.toString();
    }

    public ListenableFuture c() {
        return this.f5577p;
    }

    public androidx.work.impl.model.i d() {
        return androidx.work.impl.model.q.a(this.f5566e);
    }

    public androidx.work.impl.model.o e() {
        return this.f5566e;
    }

    public final void f(androidx.work.h.a r10) {
        if ((r10 instanceof androidx.work.h.a.c) == false) goto L9;
        androidx.work.i.e().f(f5561s, "Worker result SUCCESS for " + this.f5576o);
        if (this.f5566e.h() == false) goto L7;
        l();
        return;
    L7:
        q();
        return;
    L9:
        if ((r10 instanceof androidx.work.h.a.b) == false) goto L11;
        androidx.work.i.e().f(f5561s, "Worker result RETRY for " + this.f5576o);
        k();
        return;
    L11:
        androidx.work.i.e().f(f5561s, "Worker result FAILURE for " + this.f5576o);
        if (this.f5566e.h() == false) goto L14;
        l();
        return;
    L14:
        p();
    }

    public void g() {
        this.f5579r = true;
        r();
        this.f5578q.cancel(true);
        if (this.f5567f != null) goto L5;
    L7:
        androidx.work.i.e().a(f5561s, "WorkSpec " + this.f5566e + " is already done. Not interrupting.");
        return;
    L5:
        if (this.f5578q.isCancelled() == false) goto L7;
        this.f5567f.m();
    }

    public final void h(String r10) {
        LinkedList r11 = new LinkedList();
        r11.add(r10);
    L4:
        if (r11.isEmpty() == true) goto L9;
        String r12 = (String) r11.remove();
        if (this.f5573l.getState(r12) == WorkInfo.State.CANCELLED) goto L8;
        this.f5573l.setState(WorkInfo.State.FAILED, r12);
    L8:
        r11.addAll(this.f5574m.getDependentWorkIds(r12));
        goto L4
    }

    public final /* synthetic */ void i(ListenableFuture r10) {
        if (this.f5578q.isCancelled() == false) goto L6;
        r10.cancel(true);
        return;
    }

    public void j() {
        if (r() == true) goto L20;
        this.f5572k.e();
        WorkInfo.State r10 = this.f5573l.getState(this.f5563b);     // Catch: Throwable -> L8
        this.f5572k.K().delete(this.f5563b);     // Catch: Throwable -> L8
        if (r10 != null) goto L11;
        m(false);     // Catch: Throwable -> L8
    L16:
        this.f5572k.D();     // Catch: Throwable -> L8
        this.f5572k.i();
        goto L20
    L11:
        if (r10 != WorkInfo.State.RUNNING) goto L14;
        f(this.f5569h);     // Catch: Throwable -> L8
        goto L16
    L14:
        if (r10.isFinished() == true) goto L16;
        k();     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        this.f5572k.i();
        throw th;
    L20:
        List r11 = this.f5564c;
        if (r11 == null) goto L31;
        Iterator r12 = r11.iterator();
    L24:
        if (r12.hasNext() == false) goto L26;
        ((Scheduler) r12.next()).cancel(this.f5563b);
        goto L24
    L26:
        s.b(this.f5570i, this.f5572k, this.f5564c);
        return;
    }

    public final void k() {
        this.f5572k.e();
        this.f5573l.setState(WorkInfo.State.ENQUEUED, this.f5563b);     // Catch: Throwable -> L6
        this.f5573l.setLastEnqueuedTime(this.f5563b, System.currentTimeMillis());     // Catch: Throwable -> L6
        this.f5573l.markWorkSpecScheduled(this.f5563b, -1);     // Catch: Throwable -> L6
        this.f5572k.D();     // Catch: Throwable -> L6
        this.f5572k.i();
        m(true);
        return;
    L6:
        th = move-exception;
        this.f5572k.i();
        m(true);
        throw th;
    }

    public final void l() {
        this.f5572k.e();
        this.f5573l.setLastEnqueuedTime(this.f5563b, System.currentTimeMillis());     // Catch: Throwable -> L6
        this.f5573l.setState(WorkInfo.State.ENQUEUED, this.f5563b);     // Catch: Throwable -> L6
        this.f5573l.resetWorkSpecRunAttemptCount(this.f5563b);     // Catch: Throwable -> L6
        this.f5573l.incrementPeriodCount(this.f5563b);     // Catch: Throwable -> L6
        this.f5573l.markWorkSpecScheduled(this.f5563b, -1);     // Catch: Throwable -> L6
        this.f5572k.D();     // Catch: Throwable -> L6
        this.f5572k.i();
        m(false);
        return;
    L6:
        th = move-exception;
        this.f5572k.i();
        m(false);
        throw th;
    }

    public final void m(boolean r10) {
        this.f5572k.e();
    L6:
        th = move-exception;
        this.f5572k.i();
        throw th;
    L4:
        if (this.f5572k.L().hasUnfinishedWork() == true) goto L8;
        androidx.work.impl.utils.l.a(this.f5562a, RescheduleReceiver.class, false);     // Catch: Throwable -> L6
    L8:
        if (r10 == false) goto L11;
        this.f5573l.setState(WorkInfo.State.ENQUEUED, this.f5563b);     // Catch: Throwable -> L6
        this.f5573l.markWorkSpecScheduled(this.f5563b, -1);     // Catch: Throwable -> L6
    L11:
        if (this.f5566e != null) goto L13;
    L17:
        this.f5572k.D();     // Catch: Throwable -> L6
        this.f5572k.i();
        this.f5577p.p(Boolean.valueOf(r10));
        return;
    L13:
        if (this.f5567f == null) goto L17;
        if (this.f5571j.isEnqueuedInForeground(this.f5563b) == false) goto L17;
        this.f5571j.stopForeground(this.f5563b);     // Catch: Throwable -> L6
        goto L17
    }

    public final void n() {
        WorkInfo.State r10 = this.f5573l.getState(this.f5563b);
        if (r10 != WorkInfo.State.RUNNING) goto L5;
        androidx.work.i.e().a(f5561s, "Status for " + this.f5563b + " is RUNNING; not doing any work and rescheduling for later execution");
        m(true);
        return;
    L5:
        androidx.work.i.e().a(f5561s, "Status for " + this.f5563b + " is " + r10 + " ; not doing any work");
        m(false);
    }

    public final void o() {
        if (r() == false) goto L5;
        return;
    L5:
        this.f5572k.e();
        androidx.work.impl.model.o r10 = this.f5566e;     // Catch: Throwable -> L11
        if (r10.f5671b == WorkInfo.State.ENQUEUED) goto L14;
        n();     // Catch: Throwable -> L11
        this.f5572k.D();     // Catch: Throwable -> L11
        androidx.work.i.e().a(f5561s, this.f5566e.f5672c + " is not in ENQUEUED state. Nothing more to do");     // Catch: Throwable -> L11
        this.f5572k.i();
        return;
    L14:
        if (r10.h() == true) goto L18;
        if (this.f5566e.g() == true) goto L18;
    L22:
        this.f5572k.D();     // Catch: Throwable -> L11
        this.f5572k.i();
        if (this.f5566e.h() == false) goto L27;
        androidx.work.c r11 = this.f5566e.f5674e;
    L26:
        androidx.work.c r12 = r11;
        UUID r13 = UUID.fromString(this.f5563b);
        List r14 = this.f5575n;
        WorkerParameters.a r15 = this.f5565d;
        androidx.work.impl.model.o r16 = this.f5566e;
        WorkerParameters r17 = new WorkerParameters(r13, r12, r14, r15, r16.f5680k, r16.d(), this.f5570i.d(), this.f5568g, this.f5570i.n(), new androidx.work.impl.utils.x(this.f5572k, this.f5568g), new androidx.work.impl.utils.w(this.f5572k, this.f5571j, this.f5568g));
        if (this.f5567f != null) goto L35;
        this.f5567f = this.f5570i.n().b(this.f5562a, this.f5566e.f5672c, r17);
    L35:
        androidx.work.h r18 = this.f5567f;
        if (r18 != null) goto L40;
        androidx.work.i.e().c(f5561s, "Could not create Worker " + this.f5566e.f5672c);
        p();
        return;
    L40:
        if (r18.i() == false) goto L43;
        androidx.work.i.e().c(f5561s, "Received an already-used Worker " + this.f5566e.f5672c + "; Worker Factory should return new instances");
        p();
        return;
    L43:
        this.f5567f.k();
        if (s() == true) goto L46;
        n();
        return;
    L46:
        if (r() == false) goto L48;
        return;
    L48:
        androidx.work.impl.utils.v r19 = new androidx.work.impl.utils.v(this.f5562a, this.f5566e, this.f5567f, r17.b(), this.f5568g);
        this.f5568g.getMainThreadExecutor().execute(r19);
        final ListenableFuture r20 = r19.b();
        this.f5578q.addListener(new e0(this, r20), new androidx.work.impl.utils.r());
        r20.addListener(new a(this, r20), this.f5568g.getMainThreadExecutor());
        this.f5578q.addListener(new b(this, this.f5576o), this.f5568g.getSerialTaskExecutor());
        return;
    L27:
        androidx.work.e r21 = this.f5570i.f().b(this.f5566e.f5673d);
        if (r21 != null) goto L31;
        androidx.work.i.e().c(f5561s, "Could not create Input Merger " + this.f5566e.f5673d);
        p();
        return;
    L31:
        ArrayList r22 = new ArrayList();
        r22.add(this.f5566e.f5674e);
        r22.addAll(this.f5573l.getInputsFromPrerequisites(this.f5563b));
        r11 = r21.b(r22);
    L18:
        if (System.currentTimeMillis() >= this.f5566e.c()) goto L22;
        androidx.work.i.e().a(f5561s, String.format("Delaying execution for %s because it is being executed before schedule.", new Object[]{this.f5566e.f5672c}));     // Catch: Throwable -> L11
        m(true);     // Catch: Throwable -> L11
        this.f5572k.D();     // Catch: Throwable -> L11
        this.f5572k.i();
        return;
    L11:
        th = move-exception;
        this.f5572k.i();
        throw th;
    }

    public void p() {
        this.f5572k.e();
        h(this.f5563b);     // Catch: Throwable -> L6
        androidx.work.c r10 = ((androidx.work.h.a.C0057a) this.f5569h).e();     // Catch: Throwable -> L6
        this.f5573l.setOutput(this.f5563b, r10);     // Catch: Throwable -> L6
        this.f5572k.D();     // Catch: Throwable -> L6
        this.f5572k.i();
        m(false);
        return;
    L6:
        th = move-exception;
        this.f5572k.i();
        m(false);
        throw th;
    }

    public final void q() {
        this.f5572k.e();
        this.f5573l.setState(WorkInfo.State.SUCCEEDED, this.f5563b);     // Catch: Throwable -> L11
        this.f5573l.setOutput(this.f5563b, ((androidx.work.h.a.c) this.f5569h).e());     // Catch: Throwable -> L11
        long r10 = System.currentTimeMillis();     // Catch: Throwable -> L11
        Iterator<String> r11 = this.f5574m.getDependentWorkIds(this.f5563b).iterator();     // Catch: Throwable -> L11
    L5:
        if (r11.hasNext() == false) goto L13;
        String r12 = r11.next();     // Catch: Throwable -> L11
        if (this.f5573l.getState(r12) != WorkInfo.State.BLOCKED) goto L5;
        if (this.f5574m.hasCompletedAllPrerequisites(r12) == false) goto L5;
        androidx.work.i.e().f(f5561s, "Setting status to enqueued for " + r12);     // Catch: Throwable -> L11
        this.f5573l.setState(WorkInfo.State.ENQUEUED, r12);     // Catch: Throwable -> L11
        this.f5573l.setLastEnqueuedTime(r12, r10);     // Catch: Throwable -> L11
        goto L5
    L13:
        this.f5572k.D();     // Catch: Throwable -> L11
        this.f5572k.i();
        m(false);
        return;
    L11:
        th = move-exception;
        this.f5572k.i();
        m(false);
        throw th;
    }

    public final boolean r() {
        if (this.f5579r == false) goto L9;
        androidx.work.i.e().a(f5561s, "Work interrupted for " + this.f5576o);
        WorkInfo.State r10 = this.f5573l.getState(this.f5563b);
        if (r10 != null) goto L7;
        m(false);
    L8:
        return true;
    L7:
        m(!r10.isFinished());
        goto L8
    L9:
        return false;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f5576o = b(this.f5575n);
        o();
    }

    public final boolean s() {
        this.f5572k.e();
    L6:
        th = move-exception;
        this.f5572k.i();
        throw th;
    L4:
        if (this.f5573l.getState(this.f5563b) != WorkInfo.State.ENQUEUED) goto L8;
        this.f5573l.setState(WorkInfo.State.RUNNING, this.f5563b);     // Catch: Throwable -> L6
        this.f5573l.incrementWorkSpecRunAttemptCount(this.f5563b);     // Catch: Throwable -> L6
        boolean r10 = true;
    L9:
        this.f5572k.D();     // Catch: Throwable -> L6
        this.f5572k.i();
        return r10;
    L8:
        r10 = false;
        goto L9
    }
}
