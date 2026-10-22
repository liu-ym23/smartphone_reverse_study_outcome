package h5;

import android.content.Context;
import android.content.Intent;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.foreground.SystemForegroundService;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import kc.z0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: k, reason: collision with root package name */
    public static final String f5315k = g5.u.f("Processor");

    /* renamed from: a, reason: collision with root package name */
    public Context f5316a;

    /* renamed from: b, reason: collision with root package name */
    public g5.a f5317b;

    /* renamed from: c, reason: collision with root package name */
    public p5.i f5318c;

    /* renamed from: d, reason: collision with root package name */
    public WorkDatabase f5319d;

    /* renamed from: e, reason: collision with root package name */
    public HashMap f5320e;

    /* renamed from: f, reason: collision with root package name */
    public HashMap f5321f;

    /* renamed from: g, reason: collision with root package name */
    public HashMap f5322g;

    /* renamed from: h, reason: collision with root package name */
    public HashSet f5323h;
    public ArrayList i;

    /* renamed from: j, reason: collision with root package name */
    public Object f5324j;

    public static boolean d(String str, d0 d0Var, int i) {
        String str2 = f5315k;
        if (d0Var == null) {
            g5.u.d().a(str2, "WorkerWrapper could not be found for " + str);
            return false;
        }
        z0 z0Var = d0Var.f5335l;
        u uVar = new u();
        uVar.f5384c = i;
        VarHandle.storeStoreFence();
        z0Var.t(uVar);
        g5.u.d().a(str2, "WorkerWrapper interrupted for " + str);
        return true;
    }

    public final void a(a aVar) {
        synchronized (this.f5324j) {
            this.i.add(aVar);
        }
    }

    public final d0 b(String str) {
        d0 d0Var = (d0) this.f5320e.remove(str);
        boolean z10 = d0Var != null;
        if (!z10) {
            d0Var = (d0) this.f5321f.remove(str);
        }
        this.f5322g.remove(str);
        if (z10) {
            synchronized (this.f5324j) {
                try {
                    if (this.f5320e.isEmpty()) {
                        Context context = this.f5316a;
                        String str2 = o5.a.f9223n;
                        Intent intent = new Intent(context, (Class<?>) SystemForegroundService.class);
                        intent.setAction("ACTION_STOP_FOREGROUND");
                        this.f5316a.startService(intent);
                    }
                } catch (Throwable th) {
                    g5.u.d().c(f5315k, "Unable to stop foreground service", th);
                } finally {
                }
            }
        }
        return d0Var;
    }

    public final d0 c(String str) {
        d0 d0Var = (d0) this.f5320e.get(str);
        return d0Var == null ? (d0) this.f5321f.get(str) : d0Var;
    }

    public final boolean e(String str) {
        boolean z10;
        synchronized (this.f5324j) {
            z10 = c(str) != null;
        }
        return z10;
    }

    public final void f(a aVar) {
        synchronized (this.f5324j) {
            this.i.remove(aVar);
        }
    }

    public final void g(p5.j jVar) {
        r5.a aVar = (r5.a) this.f5318c.f9733h;
        androidx.room.a0 a0Var = new androidx.room.a0(3);
        a0Var.f1506f = this;
        a0Var.f1507g = jVar;
        VarHandle.storeStoreFence();
        aVar.execute(a0Var);
    }

    public final boolean h(j jVar, n6.a aVar) {
        p5.j jVar2 = jVar.f5348a;
        String str = jVar2.f9734a;
        ArrayList arrayList = new ArrayList();
        WorkDatabase workDatabase = this.f5319d;
        c cVar = new c();
        cVar.f5308c = this;
        cVar.f5309f = arrayList;
        cVar.f5310g = str;
        VarHandle.storeStoreFence();
        p5.p pVar = (p5.p) workDatabase.t(cVar);
        if (pVar == null) {
            g5.u.d().g(f5315k, "Didn't find WorkSpec for id " + jVar2);
            g(jVar2);
            return false;
        }
        synchronized (this.f5324j) {
            try {
                if (e(str)) {
                    Set set = (Set) this.f5322g.get(str);
                    if (((j) set.iterator().next()).f5348a.f9735b == jVar2.f9735b) {
                        set.add(jVar);
                        g5.u.d().a(f5315k, "Work " + jVar2 + " is already enqueued for processing");
                    } else {
                        g(jVar2);
                    }
                    return false;
                }
                if (pVar.f9782t != jVar2.f9735b) {
                    g(jVar2);
                    return false;
                }
                d0 d0VarG = new ad.z(this.f5316a, this.f5317b, this.f5318c, this, this.f5319d, pVar, arrayList).g();
                t2.m mVarW = com.stepos.statsrpk.h.w(((kc.p) d0VarG.f5328d.f9731f).plus(kc.w.b()), new a0(d0VarG, null, 1));
                a4.l lVar = new a4.l(4);
                lVar.f185f = this;
                lVar.f186g = mVarW;
                lVar.f187h = d0VarG;
                VarHandle.storeStoreFence();
                mVarW.f13165f.b(lVar, (r5.a) this.f5318c.f9733h);
                this.f5321f.put(str, d0VarG);
                HashSet hashSet = new HashSet();
                hashSet.add(jVar);
                this.f5322g.put(str, hashSet);
                g5.u.d().a(f5315k, d.class.getSimpleName() + ": processing " + jVar2);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
