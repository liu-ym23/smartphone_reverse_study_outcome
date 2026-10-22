package k2;

import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import androidx.appcompat.widget.y0;
import androidx.appcompat.widget.z0;
import androidx.work.impl.background.systemalarm.SystemAlarmService;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.constraints.WorkConstraintsTrackerKt;
import androidx.work.impl.constraints.a;
import h2.j;
import java.util.concurrent.Executor;
import k2.f;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Job;
import o2.n;
import q2.k;
import q2.p;
import r2.m;
import r2.r;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class d implements m2.c, r.a {
    public static final String r = j.f("DelayMetCommandHandler");

    /* renamed from: a, reason: collision with root package name */
    public final Context f9868a;

    /* renamed from: b, reason: collision with root package name */
    public final int f9869b;

    /* renamed from: c, reason: collision with root package name */
    public final k f9870c;

    /* renamed from: d, reason: collision with root package name */
    public final f f9871d;

    /* renamed from: e, reason: collision with root package name */
    public final WorkConstraintsTracker f9872e;
    public final Object h;

    /* renamed from: j, reason: collision with root package name */
    public int f9873j;

    /* renamed from: k, reason: collision with root package name */
    public final s2.a f9874k;

    /* renamed from: l, reason: collision with root package name */
    public final Executor f9875l;

    /* renamed from: m, reason: collision with root package name */
    public PowerManager.WakeLock f9876m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f9877n;

    /* renamed from: o, reason: collision with root package name */
    public final i2.k f9878o;

    /* renamed from: p, reason: collision with root package name */
    public final CoroutineDispatcher f9879p;

    /* renamed from: q, reason: collision with root package name */
    public volatile Job f9880q;

    public d(Context context, int i10, f fVar, i2.k kVar) {
        this.f9868a = context;
        this.f9869b = i10;
        this.f9871d = fVar;
        this.f9870c = kVar.f9470a;
        this.f9878o = kVar;
        n nVar = fVar.f9887e.f2885j;
        s2.b bVar = fVar.f9884b;
        this.f9874k = bVar.c();
        this.f9875l = bVar.a();
        this.f9879p = bVar.b();
        this.f9872e = new WorkConstraintsTracker(nVar);
        this.f9877n = false;
        this.f9873j = 0;
        this.h = new Object();
    }

    public static void c(d dVar) {
        int i10 = dVar.f9869b;
        Executor executor = dVar.f9875l;
        Context context = dVar.f9868a;
        f fVar = dVar.f9871d;
        k kVar = dVar.f9870c;
        String str = kVar.f11498a;
        int i11 = dVar.f9873j;
        String str2 = r;
        if (i11 >= 2) {
            j.d().a(str2, "Already stopped work for " + str);
            return;
        }
        dVar.f9873j = 2;
        j.d().a(str2, "Stopping work for WorkSpec " + str);
        String str3 = b.h;
        Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent.setAction("ACTION_STOP_WORK");
        b.d(intent, kVar);
        executor.execute(new f.b(i10, intent, fVar));
        if (!fVar.f9886d.e(kVar.f11498a)) {
            j.d().a(str2, "Processor does not have WorkSpec " + str + ". No need to reschedule");
            return;
        }
        j.d().a(str2, "WorkSpec " + str + " needs to be rescheduled");
        Intent intent2 = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent2.setAction("ACTION_SCHEDULE_WORK");
        b.d(intent2, kVar);
        executor.execute(new f.b(i10, intent2, fVar));
    }

    public static void d(d dVar) {
        if (dVar.f9873j != 0) {
            j.d().a(r, "Already started work for " + dVar.f9870c);
            return;
        }
        dVar.f9873j = 1;
        j.d().a(r, "onAllConstraintsMet for " + dVar.f9870c);
        if (!dVar.f9871d.f9886d.g(dVar.f9878o, null)) {
            dVar.e();
            return;
        }
        r rVar = dVar.f9871d.f9885c;
        k kVar = dVar.f9870c;
        synchronized (rVar.f11723d) {
            j.d().a(r.f11719e, "Starting timer for " + kVar);
            rVar.a(kVar);
            r.b bVar = new r.b(rVar, kVar);
            rVar.f11721b.put(kVar, bVar);
            rVar.f11722c.put(kVar, dVar);
            rVar.f11720a.h(600000L, bVar);
        }
    }

    @Override // r2.r.a
    public final void a(k kVar) {
        j.d().a(r, "Exceeded time limits on execution for " + kVar);
        ((r2.k) this.f9874k).execute(new y0(this, 11));
    }

    @Override // m2.c
    public final void b(p pVar, androidx.work.impl.constraints.a aVar) {
        boolean z = aVar instanceof a.C0024a;
        s2.a aVar2 = this.f9874k;
        if (z) {
            ((r2.k) aVar2).execute(new z0(this, 17));
        } else {
            ((r2.k) aVar2).execute(new y0(this, 11));
        }
    }

    public final void e() {
        synchronized (this.h) {
            try {
                if (this.f9880q != null) {
                    this.f9880q.cancel(null);
                }
                this.f9871d.f9885c.a(this.f9870c);
                PowerManager.WakeLock wakeLock = this.f9876m;
                if (wakeLock != null && wakeLock.isHeld()) {
                    j.d().a(r, "Releasing wakelock " + this.f9876m + "for WorkSpec " + this.f9870c);
                    this.f9876m.release();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void f() {
        String str = this.f9870c.f11498a;
        Context context = this.f9868a;
        StringBuilder sbP = a0.a.p(str, " (");
        sbP.append(this.f9869b);
        sbP.append(")");
        this.f9876m = m.a(context, sbP.toString());
        j jVarD = j.d();
        String str2 = r;
        jVarD.a(str2, "Acquiring wakelock " + this.f9876m + "for WorkSpec " + str);
        this.f9876m.acquire();
        p pVarI = this.f9871d.f9887e.f2879c.w().i(str);
        if (pVarI == null) {
            ((r2.k) this.f9874k).execute(new y0(this, 11));
            return;
        }
        boolean zB = pVarI.b();
        this.f9877n = zB;
        if (zB) {
            this.f9880q = WorkConstraintsTrackerKt.a(this.f9872e, pVarI, this.f9879p, this);
            return;
        }
        j.d().a(str2, "No constraints for ".concat(str));
        ((r2.k) this.f9874k).execute(new z0(this, 17));
    }

    public final void g(boolean z) {
        j jVarD = j.d();
        StringBuilder sb2 = new StringBuilder("onExecuted ");
        k kVar = this.f9870c;
        sb2.append(kVar);
        sb2.append(", ");
        sb2.append(z);
        jVarD.a(r, sb2.toString());
        e();
        int i10 = this.f9869b;
        f fVar = this.f9871d;
        Executor executor = this.f9875l;
        Context context = this.f9868a;
        if (z) {
            String str = b.h;
            Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
            intent.setAction("ACTION_SCHEDULE_WORK");
            b.d(intent, kVar);
            executor.execute(new f.b(i10, intent, fVar));
        }
        if (this.f9877n) {
            String str2 = b.h;
            Intent intent2 = new Intent(context, (Class<?>) SystemAlarmService.class);
            intent2.setAction("ACTION_CONSTRAINTS_CHANGED");
            executor.execute(new f.b(i10, intent2, fVar));
        }
    }
}
