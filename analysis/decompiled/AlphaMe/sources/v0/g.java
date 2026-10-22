package v0;

import B0.k;
import B0.r;
import C0.o;
import C0.w;
import C0.y;
import Z2.C0125f0;
import Z2.r0;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import androidx.work.impl.background.systemalarm.SystemAlarmService;
import s0.t;
import t0.x;
import x0.C0979a;
import z0.l;

/* loaded from: classes.dex */
public final class g implements x0.e, w {

    /* renamed from: o, reason: collision with root package name */
    public static final String f15690o = t.f("DelayMetCommandHandler");

    /* renamed from: a, reason: collision with root package name */
    public final Context f15691a;

    /* renamed from: b, reason: collision with root package name */
    public final int f15692b;

    /* renamed from: c, reason: collision with root package name */
    public final k f15693c;

    /* renamed from: d, reason: collision with root package name */
    public final j f15694d;

    /* renamed from: e, reason: collision with root package name */
    public final stepos.support.v7.app.palette.b f15695e;

    /* renamed from: f, reason: collision with root package name */
    public final Object f15696f;

    /* renamed from: g, reason: collision with root package name */
    public int f15697g;

    /* renamed from: h, reason: collision with root package name */
    public final o f15698h;

    /* renamed from: i, reason: collision with root package name */
    public final E0.b f15699i;

    /* renamed from: j, reason: collision with root package name */
    public PowerManager.WakeLock f15700j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f15701k;

    /* renamed from: l, reason: collision with root package name */
    public final x f15702l;

    /* renamed from: m, reason: collision with root package name */
    public final C0125f0 f15703m;

    /* renamed from: n, reason: collision with root package name */
    public volatile r0 f15704n;

    public g(Context context, int i4, j jVar, x xVar) {
        this.f15691a = context;
        this.f15692b = i4;
        this.f15694d = jVar;
        this.f15693c = xVar.f15425a;
        this.f15702l = xVar;
        l lVar = jVar.f15712e.f15334k;
        E0.c cVar = (E0.c) jVar.f15709b;
        this.f15698h = cVar.f400a;
        this.f15699i = cVar.f403d;
        this.f15703m = cVar.f401b;
        this.f15695e = new stepos.support.v7.app.palette.b(lVar);
        this.f15701k = false;
        this.f15697g = 0;
        this.f15696f = new Object();
    }

    public static void a(g gVar) {
        k kVar = gVar.f15693c;
        String str = kVar.f150a;
        int i4 = gVar.f15697g;
        String str2 = f15690o;
        if (i4 >= 2) {
            t.d().a(str2, "Already stopped work for " + str);
            return;
        }
        gVar.f15697g = 2;
        t.d().a(str2, "Stopping work for WorkSpec " + str);
        Context context = gVar.f15691a;
        Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent.setAction("ACTION_STOP_WORK");
        c.d(intent, kVar);
        j jVar = gVar.f15694d;
        int i5 = gVar.f15692b;
        android.support.v4.os.a aVar = new android.support.v4.os.a(jVar, intent, i5);
        E0.b bVar = gVar.f15699i;
        bVar.execute(aVar);
        if (!jVar.f15711d.e(kVar.f150a)) {
            t.d().a(str2, "Processor does not have WorkSpec " + str + ". No need to reschedule");
            return;
        }
        t.d().a(str2, "WorkSpec " + str + " needs to be rescheduled");
        Intent intent2 = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent2.setAction("ACTION_SCHEDULE_WORK");
        c.d(intent2, kVar);
        bVar.execute(new android.support.v4.os.a(jVar, intent2, i5));
    }

    public static void c(g gVar) {
        if (gVar.f15697g != 0) {
            t.d().a(f15690o, "Already started work for " + gVar.f15693c);
            return;
        }
        gVar.f15697g = 1;
        t.d().a(f15690o, "onAllConstraintsMet for " + gVar.f15693c);
        if (!gVar.f15694d.f15711d.i(gVar.f15702l, null)) {
            gVar.d();
            return;
        }
        y yVar = gVar.f15694d.f15710c;
        k kVar = gVar.f15693c;
        synchronized (yVar.f334d) {
            t.d().a(y.f330e, "Starting timer for " + kVar);
            yVar.a(kVar);
            C0.x xVar = new C0.x(yVar, kVar);
            yVar.f332b.put(kVar, xVar);
            yVar.f333c.put(kVar, gVar);
            yVar.f331a.f15383a.postDelayed(xVar, 600000L);
        }
    }

    @Override // x0.e
    public final void b(r rVar, x0.c cVar) {
        boolean z4 = cVar instanceof C0979a;
        o oVar = this.f15698h;
        if (z4) {
            oVar.execute(new f(this, 2));
        } else {
            oVar.execute(new f(this, 3));
        }
    }

    public final void d() {
        synchronized (this.f15696f) {
            try {
                if (this.f15704n != null) {
                    this.f15704n.b(null);
                }
                this.f15694d.f15710c.a(this.f15693c);
                PowerManager.WakeLock wakeLock = this.f15700j;
                if (wakeLock != null && wakeLock.isHeld()) {
                    t.d().a(f15690o, "Releasing wakelock " + this.f15700j + "for WorkSpec " + this.f15693c);
                    this.f15700j.release();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void e() {
        String str = this.f15693c.f150a;
        Context context = this.f15691a;
        StringBuilder sbV = B0.g.v(str, " (");
        sbV.append(this.f15692b);
        sbV.append(")");
        this.f15700j = C0.r.a(context, sbV.toString());
        t tVarD = t.d();
        String str2 = f15690o;
        tVarD.a(str2, "Acquiring wakelock " + this.f15700j + "for WorkSpec " + str);
        this.f15700j.acquire();
        r rVarI = this.f15694d.f15712e.f15327d.g().i(str);
        if (rVarI == null) {
            this.f15698h.execute(new f(this, 0));
            return;
        }
        boolean zC = rVarI.c();
        this.f15701k = zC;
        if (zC) {
            this.f15704n = x0.k.a(this.f15695e, rVarI, this.f15703m, this);
            return;
        }
        t.d().a(str2, "No constraints for " + str);
        this.f15698h.execute(new f(this, 1));
    }

    public final void f(boolean z4) {
        t tVarD = t.d();
        StringBuilder sb = new StringBuilder("onExecuted ");
        k kVar = this.f15693c;
        sb.append(kVar);
        sb.append(", ");
        sb.append(z4);
        tVarD.a(f15690o, sb.toString());
        d();
        int i4 = this.f15692b;
        j jVar = this.f15694d;
        E0.b bVar = this.f15699i;
        Context context = this.f15691a;
        if (z4) {
            Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
            intent.setAction("ACTION_SCHEDULE_WORK");
            c.d(intent, kVar);
            bVar.execute(new android.support.v4.os.a(jVar, intent, i4));
        }
        if (this.f15701k) {
            Intent intent2 = new Intent(context, (Class<?>) SystemAlarmService.class);
            intent2.setAction("ACTION_CONSTRAINTS_CHANGED");
            bVar.execute(new android.support.v4.os.a(jVar, intent2, i4));
        }
    }
}
