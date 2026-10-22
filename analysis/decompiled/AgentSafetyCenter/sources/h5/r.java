package h5;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Trace;
import androidx.work.impl.WorkDatabase;
import java.lang.invoke.VarHandle;
import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class r {

    /* renamed from: k, reason: collision with root package name */
    public static r f5367k;

    /* renamed from: l, reason: collision with root package name */
    public static r f5368l;

    /* renamed from: m, reason: collision with root package name */
    public static final Object f5369m;

    /* renamed from: a, reason: collision with root package name */
    public Context f5370a;

    /* renamed from: b, reason: collision with root package name */
    public g5.a f5371b;

    /* renamed from: c, reason: collision with root package name */
    public WorkDatabase f5372c;

    /* renamed from: d, reason: collision with root package name */
    public p5.i f5373d;

    /* renamed from: e, reason: collision with root package name */
    public List f5374e;

    /* renamed from: f, reason: collision with root package name */
    public d f5375f;

    /* renamed from: g, reason: collision with root package name */
    public a2.i f5376g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f5377h;
    public BroadcastReceiver.PendingResult i;

    /* renamed from: j, reason: collision with root package name */
    public ad.y f5378j;

    static {
        g5.u.f("WorkManagerImpl");
        f5367k = null;
        f5368l = null;
        f5369m = new Object();
    }

    public static r b(Context context) {
        r rVar;
        Object obj = f5369m;
        synchronized (obj) {
            try {
                synchronized (obj) {
                    rVar = f5367k;
                    if (rVar == null) {
                        rVar = f5368l;
                    }
                }
                return rVar;
            } catch (Throwable th) {
                throw th;
            } finally {
            }
        }
        if (rVar != null) {
            return rVar;
        }
        context.getApplicationContext();
        throw new IllegalStateException("WorkManager is not initialized properly.  You have explicitly disabled WorkManagerInitializer in your manifest, have not manually called WorkManager#initialize at this point, and your Application does not implement Configuration.Provider.");
    }

    public final g5.j a(String str) {
        g5.j jVar = this.f5371b.f4279m;
        String strConcat = "CancelWorkByName_".concat(str);
        androidx.room.b0 b0Var = (androidx.room.b0) this.f5373d.f9730c;
        b0Var.getClass();
        return id.c.x(jVar, strConcat, b0Var, new a1.b(8, str, this));
    }

    public final t2.m c() {
        WorkDatabase workDatabase = this.f5372c;
        p5.i iVar = this.f5373d;
        workDatabase.getClass();
        iVar.getClass();
        o1.f fVar = new o1.f(1);
        androidx.room.b0 b0Var = (androidx.room.b0) iVar.f9730c;
        b0Var.getClass();
        a1.b bVar = new a1.b(9, fVar, workDatabase);
        g5.n nVar = new g5.n(0);
        nVar.f4332b = b0Var;
        nVar.f4333c = bVar;
        VarHandle.storeStoreFence();
        return t.n.i(nVar);
    }

    public final void d() {
        synchronized (f5369m) {
            try {
                this.f5377h = true;
                BroadcastReceiver.PendingResult pendingResult = this.i;
                if (pendingResult != null) {
                    pendingResult.finish();
                    this.i = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void e() {
        g5.j jVar = this.f5371b.f4279m;
        ab.e eVar = new ab.e(5);
        eVar.f393f = this;
        VarHandle.storeStoreFence();
        jVar.getClass();
        boolean zA = c5.a.a();
        if (zA) {
            try {
                Trace.beginSection(com.stepos.statsrpk.h.J("ReschedulingWork"));
            } finally {
                if (zA) {
                    Trace.endSection();
                }
            }
        }
        eVar.invoke();
    }
}
