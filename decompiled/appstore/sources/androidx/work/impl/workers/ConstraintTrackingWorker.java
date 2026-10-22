package androidx.work.impl.workers;

import android.content.Context;
import androidx.annotation.RestrictTo;
import androidx.work.WorkerParameters;
import androidx.work.h;
import androidx.work.i;
import androidx.work.impl.c0;
import androidx.work.impl.constraints.WorkConstraintsCallback;
import androidx.work.impl.constraints.b;
import androidx.work.impl.constraints.trackers.m;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.o;
import androidx.work.impl.utils.futures.a;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.s;
import kotlin.jvm.internal.q;
import m0.c;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0013\u001a\u00020\r2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0015\u001a\u00020\r2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016¢\u0006\u0004\b\u0015\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0016\u0010\u000fR\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR8\u0010%\u001a&\u0012\f\u0012\n \"*\u0004\u0018\u00010\n0\n \"*\u0012\u0012\f\u0012\n \"*\u0004\u0018\u00010\n0\n\u0018\u00010!0!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R(\u0010+\u001a\u0004\u0018\u00010\u00012\b\u0010&\u001a\u0004\u0018\u00010\u00018G@BX\u0086\u000e¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*¨\u0006,"}, d2 = {"Landroidx/work/impl/workers/ConstraintTrackingWorker;", "Landroidx/work/h;", "Landroidx/work/impl/constraints/WorkConstraintsCallback;", "Landroid/content/Context;", "appContext", "Landroidx/work/WorkerParameters;", "workerParameters", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "Lcom/google/common/util/concurrent/ListenableFuture;", "Landroidx/work/h$a;", "l", "()Lcom/google/common/util/concurrent/ListenableFuture;", "", "j", "()V", "", "Landroidx/work/impl/model/o;", "workSpecs", "onAllConstraintsMet", "(Ljava/util/List;)V", "onAllConstraintsNotMet", "p", "e", "Landroidx/work/WorkerParameters;", "", "f", "Ljava/lang/Object;", "lock", "", "g", "Z", "areConstraintsUnmet", "Landroidx/work/impl/utils/futures/a;", "kotlin.jvm.PlatformType", "h", "Landroidx/work/impl/utils/futures/a;", "future", "<set-?>", "i", "Landroidx/work/h;", "getDelegate", "()Landroidx/work/h;", "delegate", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class ConstraintTrackingWorker extends h implements WorkConstraintsCallback {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final WorkerParameters f5894e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object f5895f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile boolean f5896g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final a f5897h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public h f5898i;

    public ConstraintTrackingWorker(@NotNull Context r10, @NotNull WorkerParameters r11) {
        q.g(r10, "appContext");
        q.g(r11, "workerParameters");
        super(r10, r11);
        this.f5894e = r11;
        this.f5895f = new Object();
        this.f5897h = a.t();
    }

    public static /* synthetic */ void n(ConstraintTrackingWorker r10) {
        r(r10);
    }

    public static /* synthetic */ void o(ConstraintTrackingWorker r10, ListenableFuture r11) {
        q(r10, r11);
    }

    public static final void q(ConstraintTrackingWorker r10, ListenableFuture r11) {
        q.g(r10, "this$0");
        q.g(r11, "$innerFuture");
        Object r12 = r10.f5895f;
        monitor-enter(r12);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (r10.f5896g == false) goto L9;
        a r13 = r10.f5897h;     // Catch: Throwable -> L7
        q.f(r13, "future");     // Catch: Throwable -> L7
        c.c(r13);     // Catch: Throwable -> L7
    L10:
        Unit r14 = Unit.f21064a;     // Catch: Throwable -> L7
        monitor-exit(r12);
        return;
    L9:
        r10.f5897h.r(r11);     // Catch: Throwable -> L7
        goto L10
    }

    public static final void r(ConstraintTrackingWorker r10) {
        q.g(r10, "this$0");
        r10.p();
    }

    @Override // androidx.work.h
    public void j() {
        super.j();
        h r10 = this.f5898i;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.h() == true) goto L9;
        r10.m();
        return;
    }

    @Override // androidx.work.h
    public ListenableFuture l() {
        b().execute(new m0.a(this));
        a r10 = this.f5897h;
        q.f(r10, "future");
        return r10;
    }

    @Override // androidx.work.impl.constraints.WorkConstraintsCallback
    public void onAllConstraintsMet(List r10) {
        q.g(r10, "workSpecs");
    }

    @Override // androidx.work.impl.constraints.WorkConstraintsCallback
    public void onAllConstraintsNotMet(List r10) {
        q.g(r10, "workSpecs");
        i.e().a(c.a(), "Constraints changed for " + r10);
        Object r11 = this.f5895f;
        monitor-enter(r11);
        this.f5896g = true;     // Catch: Throwable -> L8
        Unit r12 = Unit.f21064a;     // Catch: Throwable -> L8
        monitor-exit(r11);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public final void p() {
        if (this.f5897h.isCancelled() == false) goto L5;
        return;
    L5:
        String r10 = e().i("androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME");
        i r11 = i.e();
        q.f(r11, "get()");
        if (r10 != null) goto L8;
    L38:
        r11.c(c.a(), "No worker to delegate to.");
        a r12 = this.f5897h;
        q.f(r12, "future");
        c.b(r12);
        return;
    L8:
        if (r10.length() == 0) goto L38;
        h r13 = g().b(a(), r10, this.f5894e);
        this.f5898i = r13;
        if (r13 != null) goto L14;
        r11.a(c.a(), "No worker to delegate to.");
        a r14 = this.f5897h;
        q.f(r14, "future");
        c.b(r14);
        return;
    L14:
        c0 r15 = c0.l(a());
        q.f(r15, "getInstance(applicationContext)");
        WorkSpecDao r16 = r15.q().L();
        String r17 = d().toString();
        q.f(r17, "id.toString()");
        o r18 = r16.getWorkSpec(r17);
        if (r18 != null) goto L18;
        a r19 = this.f5897h;
        q.f(r19, "future");
        c.b(r19);
        return;
    L18:
        m r20 = r15.p();
        q.f(r20, "workManagerImpl.trackers");
        b r21 = new b(r20, this);
        r21.replace(s.e(r18));
        String r22 = d().toString();
        q.f(r22, "id.toString()");
        if (r21.a(r22) == false) goto L36;
        r11.a(c.a(), "Constraints met for delegate " + r10);
        h r23 = this.f5898i;     // Catch: Throwable -> L23
        q.d(r23);     // Catch: Throwable -> L23
        final ListenableFuture r24 = r23.l();     // Catch: Throwable -> L23
        q.f(r24, "delegate!!.startWork()");     // Catch: Throwable -> L23
        r24.addListener(new m0.b(this, r24), b());     // Catch: Throwable -> L23
        return;
    L23:
        th = move-exception;
        r11.b(c.a(), "Delegated worker " + r10 + " threw exception in startWork.", th);
        monitor-enter(this.f5895f);
    L29:
        th = move-exception;
        throw th;
    L27:
        if (this.f5896g == false) goto L31;
        r11.a(c.a(), "Constraints were unmet, Retrying.");     // Catch: Throwable -> L29
        a r25 = this.f5897h;     // Catch: Throwable -> L29
        q.f(r25, "future");     // Catch: Throwable -> L29
        c.c(r25);     // Catch: Throwable -> L29
        return;
    L31:
        a r26 = this.f5897h;     // Catch: Throwable -> L29
        q.f(r26, "future");     // Catch: Throwable -> L29
        c.b(r26);     // Catch: Throwable -> L29
        return;
    L36:
        r11.a(c.a(), "Constraints not met for delegate " + r10 + ". Requesting retry.");
        a r27 = this.f5897h;
        q.f(r27, "future");
        c.c(r27);
    }
}
