package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.os.PowerManager;
import androidx.work.impl.constraints.WorkConstraintsCallback;
import androidx.work.impl.constraints.trackers.m;
import androidx.work.impl.model.i;
import androidx.work.impl.model.o;
import androidx.work.impl.model.q;
import androidx.work.impl.t;
import androidx.work.impl.utils.WorkTimer;
import androidx.work.impl.utils.s;
import com.bytedanceos.common.ad.common.AdConstant;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class f implements WorkConstraintsCallback, WorkTimer.TimeLimitExceededListener {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f5475m = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f5476a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f5477b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i f5478c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SystemAlarmDispatcher f5479d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final androidx.work.impl.constraints.b f5480e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object f5481f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f5482g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Executor f5483h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Executor f5484i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public PowerManager.WakeLock f5485j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f5486k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final t f5487l;

    static {
        f5475m = androidx.work.i.i("DelayMetCommandHandler");
    }

    public f(Context r10, int r11, SystemAlarmDispatcher r12, t r13) {
        this.f5476a = r10;
        this.f5477b = r11;
        this.f5479d = r12;
        this.f5478c = r13.a();
        this.f5487l = r13;
        m r14 = r12.f().p();
        this.f5483h = r12.e().getSerialTaskExecutor();
        this.f5484i = r12.e().getMainThreadExecutor();
        this.f5480e = new androidx.work.impl.constraints.b(r14, this);
        this.f5486k = false;
        this.f5482g = 0;
        this.f5481f = new Object();
    }

    public static /* synthetic */ void a(f r10) {
        r10.g();
    }

    public static /* synthetic */ void b(f r10) {
        r10.f();
    }

    public final void c() {
        Object r10 = this.f5481f;
        monitor-enter(r10);
        this.f5480e.reset();     // Catch: Throwable -> L9
        this.f5479d.g().b(this.f5478c);     // Catch: Throwable -> L9
        PowerManager.WakeLock r11 = this.f5485j;     // Catch: Throwable -> L9
        if (r11 != null) goto L7;
    L11:
        monitor-exit(r10);     // Catch: Throwable -> L9
        return;
    L7:
        if (r11.isHeld() == false) goto L11;
        androidx.work.i.e().a(f5475m, "Releasing wakelock " + this.f5485j + "for WorkSpec " + this.f5478c);     // Catch: Throwable -> L9
        this.f5485j.release();     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    public void d() {
        String r10 = this.f5478c.b();
        this.f5485j = s.b(this.f5476a, r10 + " (" + this.f5477b + ")");
        androidx.work.i r11 = androidx.work.i.e();
        String r12 = f5475m;
        r11.a(r12, "Acquiring wakelock " + this.f5485j + "for WorkSpec " + r10);
        this.f5485j.acquire();
        o r13 = this.f5479d.f().q().L().getWorkSpec(r10);
        if (r13 != null) goto L6;
        this.f5483h.execute(new d(this));
        return;
    L6:
        boolean r14 = r13.f();
        this.f5486k = r14;
        if (r14 == true) goto L9;
        androidx.work.i.e().a(r12, "No constraints for " + r10);
        onAllConstraintsMet(Collections.singletonList(r13));
        return;
    L9:
        this.f5480e.replace(Collections.singletonList(r13));
    }

    public void e(boolean r10) {
        androidx.work.i.e().a(f5475m, "onExecuted " + this.f5478c + ", " + r10);
        c();
        if (r10 == false) goto L6;
        this.f5484i.execute(new SystemAlarmDispatcher.b(this.f5479d, b.d(this.f5476a, this.f5478c), this.f5477b));
    L6:
        if (this.f5486k == false) goto L9;
        this.f5484i.execute(new SystemAlarmDispatcher.b(this.f5479d, b.a(this.f5476a), this.f5477b));
        return;
    }

    public final void f() {
        if (this.f5482g != 0) goto L8;
        this.f5482g = 1;
        androidx.work.i.e().a(f5475m, "onAllConstraintsMet for " + this.f5478c);
        if (this.f5479d.d().l(this.f5487l) == false) goto L7;
        this.f5479d.g().a(this.f5478c, AdConstant.SPLASH_AD_INTERVAL, this);
        return;
    L7:
        c();
        return;
    L8:
        androidx.work.i.e().a(f5475m, "Already started work for " + this.f5478c);
    }

    public final void g() {
        String r10 = this.f5478c.b();
        if (this.f5482g >= 2) goto L8;
        this.f5482g = 2;
        androidx.work.i r11 = androidx.work.i.e();
        String r12 = f5475m;
        r11.a(r12, "Stopping work for WorkSpec " + r10);
        this.f5484i.execute(new SystemAlarmDispatcher.b(this.f5479d, b.e(this.f5476a, this.f5478c), this.f5477b));
        if (this.f5479d.d().g(this.f5478c.b()) == false) goto L7;
        androidx.work.i.e().a(r12, "WorkSpec " + r10 + " needs to be rescheduled");
        this.f5484i.execute(new SystemAlarmDispatcher.b(this.f5479d, b.d(this.f5476a, this.f5478c), this.f5477b));
        return;
    L7:
        androidx.work.i.e().a(r12, "Processor does not have WorkSpec " + r10 + ". No need to reschedule");
        return;
    L8:
        androidx.work.i.e().a(f5475m, "Already stopped work for " + r10);
    }

    @Override // androidx.work.impl.constraints.WorkConstraintsCallback
    public void onAllConstraintsMet(List r10) {
        Iterator r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L12;
        if (q.a((o) r11.next()).equals(this.f5478c) == false) goto L4;
        this.f5483h.execute(new e(this));
        return;
    }

    @Override // androidx.work.impl.constraints.WorkConstraintsCallback
    public void onAllConstraintsNotMet(List r10) {
        this.f5483h.execute(new d(this));
    }

    @Override // androidx.work.impl.utils.WorkTimer.TimeLimitExceededListener
    public void onTimeLimitExceeded(i r10) {
        androidx.work.i.e().a(f5475m, "Exceeded time limits on execution for " + r10);
        this.f5483h.execute(new d(this));
    }
}
