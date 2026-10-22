package j5;

import ad.y;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.PowerManager;
import androidx.room.b0;
import androidx.work.impl.background.systemalarm.SystemAlarmService;
import g5.u;
import java.lang.invoke.VarHandle;
import kc.p;
import kc.z0;
import l5.k;
import p5.i;
import p5.j;
import q5.m;
import q5.n;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f implements l5.g {

    /* renamed from: s, reason: collision with root package name */
    public static final String f6571s = u.f("DelayMetCommandHandler");

    /* renamed from: c, reason: collision with root package name */
    public final Context f6572c;

    /* renamed from: f, reason: collision with root package name */
    public final int f6573f;

    /* renamed from: g, reason: collision with root package name */
    public final j f6574g;

    /* renamed from: h, reason: collision with root package name */
    public final h f6575h;
    public final ne.b i;

    /* renamed from: j, reason: collision with root package name */
    public final Object f6576j;

    /* renamed from: k, reason: collision with root package name */
    public int f6577k;

    /* renamed from: l, reason: collision with root package name */
    public final b0 f6578l;

    /* renamed from: m, reason: collision with root package name */
    public final r5.a f6579m;

    /* renamed from: n, reason: collision with root package name */
    public PowerManager.WakeLock f6580n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f6581o;

    /* renamed from: p, reason: collision with root package name */
    public final h5.j f6582p;

    /* renamed from: q, reason: collision with root package name */
    public final p f6583q;

    /* renamed from: r, reason: collision with root package name */
    public volatile z0 f6584r;

    public f(Context context, int i, h hVar, h5.j jVar) {
        this.f6572c = context;
        this.f6573f = i;
        this.f6575h = hVar;
        this.f6574g = jVar.f5348a;
        this.f6582p = jVar;
        y yVar = hVar.i.f5378j;
        i iVar = hVar.f6589f;
        this.f6578l = (b0) iVar.f9730c;
        this.f6579m = (r5.a) iVar.f9733h;
        this.f6583q = (p) iVar.f9731f;
        this.i = new ne.b(yVar);
        this.f6581o = false;
        this.f6577k = 0;
        this.f6576j = new Object();
    }

    public static void b(f fVar) {
        int i = fVar.f6573f;
        r5.a aVar = fVar.f6579m;
        Context context = fVar.f6572c;
        h hVar = fVar.f6575h;
        j jVar = fVar.f6574g;
        String str = jVar.f9734a;
        int i3 = fVar.f6577k;
        String str2 = f6571s;
        if (i3 >= 2) {
            u.d().a(str2, "Already stopped work for " + str);
            return;
        }
        fVar.f6577k = 2;
        u.d().a(str2, "Stopping work for WorkSpec " + str);
        Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent.setAction("ACTION_STOP_WORK");
        b.c(intent, jVar);
        aVar.execute(new androidx.activity.h(i, intent, hVar));
        if (!hVar.f6591h.e(jVar.f9734a)) {
            u.d().a(str2, "Processor does not have WorkSpec " + str + ". No need to reschedule");
            return;
        }
        u.d().a(str2, "WorkSpec " + str + " needs to be rescheduled");
        Intent intent2 = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent2.setAction("ACTION_SCHEDULE_WORK");
        b.c(intent2, jVar);
        aVar.execute(new androidx.activity.h(i, intent2, hVar));
    }

    public static void c(f fVar) {
        if (fVar.f6577k != 0) {
            u.d().a(f6571s, "Already started work for " + fVar.f6574g);
            return;
        }
        fVar.f6577k = 1;
        u.d().a(f6571s, "onAllConstraintsMet for " + fVar.f6574g);
        if (!fVar.f6575h.f6591h.h(fVar.f6582p, null)) {
            fVar.d();
            return;
        }
        n nVar = fVar.f6575h.f6590g;
        j jVar = fVar.f6574g;
        synchronized (nVar.f10100d) {
            u.d().a(n.f10096e, "Starting timer for " + jVar);
            nVar.a(jVar);
            m mVar = new m();
            mVar.f10094c = nVar;
            mVar.f10095f = jVar;
            VarHandle.storeStoreFence();
            nVar.f10098b.put(jVar, mVar);
            nVar.f10099c.put(jVar, fVar);
            ((Handler) nVar.f10097a.f49f).postDelayed(mVar, 600000L);
        }
    }

    @Override // l5.g
    public final void a(p5.p pVar, l5.c cVar) {
        boolean z10 = cVar instanceof l5.a;
        b0 b0Var = this.f6578l;
        if (z10) {
            e eVar = new e(1);
            eVar.f6570f = this;
            VarHandle.storeStoreFence();
            b0Var.execute(eVar);
            return;
        }
        e eVar2 = new e(0);
        eVar2.f6570f = this;
        VarHandle.storeStoreFence();
        b0Var.execute(eVar2);
    }

    public final void d() {
        synchronized (this.f6576j) {
            try {
                if (this.f6584r != null) {
                    this.f6584r.e(null);
                }
                this.f6575h.f6590g.a(this.f6574g);
                PowerManager.WakeLock wakeLock = this.f6580n;
                if (wakeLock != null && wakeLock.isHeld()) {
                    u.d().a(f6571s, "Releasing wakelock " + this.f6580n + "for WorkSpec " + this.f6574g);
                    this.f6580n.release();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void e() throws Throwable {
        String str = this.f6574g.f9734a;
        Context context = this.f6572c;
        StringBuilder sbV = k0.a.v(str, " (");
        sbV.append(this.f6573f);
        sbV.append(")");
        this.f6580n = q5.h.a(context, sbV.toString());
        u uVarD = u.d();
        String str2 = f6571s;
        uVarD.a(str2, "Acquiring wakelock " + this.f6580n + "for WorkSpec " + str);
        this.f6580n.acquire();
        p5.p pVarJ = this.f6575h.i.f5372c.C().j(str);
        if (pVarJ == null) {
            b0 b0Var = this.f6578l;
            e eVar = new e(0);
            eVar.f6570f = this;
            VarHandle.storeStoreFence();
            b0Var.execute(eVar);
            return;
        }
        boolean zB = pVarJ.b();
        this.f6581o = zB;
        if (zB) {
            this.f6584r = k.a(this.i, pVarJ, this.f6583q, this);
            return;
        }
        u.d().a(str2, "No constraints for ".concat(str));
        b0 b0Var2 = this.f6578l;
        e eVar2 = new e(1);
        eVar2.f6570f = this;
        VarHandle.storeStoreFence();
        b0Var2.execute(eVar2);
    }

    public final void f(boolean z10) {
        u uVarD = u.d();
        StringBuilder sb2 = new StringBuilder("onExecuted ");
        j jVar = this.f6574g;
        sb2.append(jVar);
        sb2.append(", ");
        sb2.append(z10);
        uVarD.a(f6571s, sb2.toString());
        d();
        int i = this.f6573f;
        h hVar = this.f6575h;
        r5.a aVar = this.f6579m;
        Context context = this.f6572c;
        if (z10) {
            Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
            intent.setAction("ACTION_SCHEDULE_WORK");
            b.c(intent, jVar);
            aVar.execute(new androidx.activity.h(i, intent, hVar));
        }
        if (this.f6581o) {
            Intent intent2 = new Intent(context, (Class<?>) SystemAlarmService.class);
            intent2.setAction("ACTION_CONSTRAINTS_CHANGED");
            aVar.execute(new androidx.activity.h(i, intent2, hVar));
        }
    }
}
