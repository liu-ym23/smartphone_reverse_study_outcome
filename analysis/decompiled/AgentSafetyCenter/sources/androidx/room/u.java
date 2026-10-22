package androidx.room;

import android.os.Looper;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class u {

    /* renamed from: a, reason: collision with root package name */
    public pc.c f1628a;

    /* renamed from: b, reason: collision with root package name */
    public nb.g f1629b;

    /* renamed from: c, reason: collision with root package name */
    public Executor f1630c;

    /* renamed from: d, reason: collision with root package name */
    public b0 f1631d;

    /* renamed from: e, reason: collision with root package name */
    public q f1632e;

    /* renamed from: f, reason: collision with root package name */
    public f f1633f;

    /* renamed from: g, reason: collision with root package name */
    public final p5.c f1634g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f1635h;
    public final ThreadLocal i;

    /* renamed from: j, reason: collision with root package name */
    public final LinkedHashMap f1636j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f1637k;

    public u() {
        p5.c cVar = new p5.c(8);
        cVar.f9717f = new AtomicInteger(0);
        cVar.f9718g = new AtomicBoolean(false);
        VarHandle.storeStoreFence();
        this.f1634g = cVar;
        this.i = new ThreadLocal();
        this.f1636j = new LinkedHashMap();
        this.f1637k = true;
    }

    public final void a() {
        if (this.f1635h) {
            return;
        }
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            od.f.e("Cannot access database on the main thread since it may potentially lock the UI for a long period of time.");
        }
    }

    public final void b() {
        if (!o() || p() || this.i.get() == null) {
            return;
        }
        od.f.e("Cannot access database on a different coroutine context inherited from a suspending transaction.");
    }

    public final void c() {
        a();
        a();
        z4.c cVarW = j().w();
        if (!cVarW.r()) {
            e eVar = new e(i(), null, 0);
            Thread.interrupted();
            kc.w.y(nb.h.f8811c, new androidx.lifecycle.r(eVar, (nb.c) null));
        }
        if (cVarW.f16385c.isWriteAheadLoggingEnabled()) {
            cVarW.e();
        } else {
            cVarW.d();
        }
    }

    public List d(LinkedHashMap linkedHashMap) {
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(kb.x.L(linkedHashMap.size()));
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            yb.e eVar = (yb.e) entry.getKey();
            eVar.getClass();
            Class clsA = eVar.a();
            clsA.getClass();
            linkedHashMap2.put(clsA, entry.getValue());
        }
        return h(linkedHashMap2);
    }

    public abstract f e();

    public a4.f f() {
        throw new jb.f(0);
    }

    public y4.c g(a aVar) {
        aVar.getClass();
        throw new jb.f(0);
    }

    public List h(LinkedHashMap linkedHashMap) {
        return kb.s.f7404c;
    }

    public final f i() {
        f fVar = this.f1633f;
        if (fVar != null) {
            return fVar;
        }
        yb.k.f("internalTracker");
        throw null;
    }

    public final y4.c j() {
        q qVar = this.f1632e;
        if (qVar == null) {
            yb.k.f("connectionManager");
            throw null;
        }
        y4.c cVarC = qVar.c();
        if (cVarC != null) {
            return cVarC;
        }
        od.f.e("Cannot return a SupportSQLiteOpenHelper since no SupportSQLiteOpenHelper.Factory was configured with Room.");
        return null;
    }

    public Set k() {
        Set<Class> setL = l();
        ArrayList arrayList = new ArrayList(kb.m.m0(setL, 10));
        for (Class cls : setL) {
            cls.getClass();
            arrayList.add(yb.v.a(cls));
        }
        return kb.l.O0(arrayList);
    }

    public Set l() {
        return kb.u.f7406c;
    }

    public LinkedHashMap m() {
        Set<Map.Entry> setEntrySet = n().entrySet();
        int iL = kb.x.L(kb.m.m0(setEntrySet, 10));
        if (iL < 16) {
            iL = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iL);
        for (Map.Entry entry : setEntrySet) {
            Class cls = (Class) entry.getKey();
            List<Class> list = (List) entry.getValue();
            cls.getClass();
            yb.e eVarA = yb.v.a(cls);
            ArrayList arrayList = new ArrayList(kb.m.m0(list, 10));
            for (Class cls2 : list) {
                cls2.getClass();
                arrayList.add(yb.v.a(cls2));
            }
            linkedHashMap.put(eVarA, arrayList);
        }
        return linkedHashMap;
    }

    public Map n() {
        return kb.t.f7405c;
    }

    public final boolean o() {
        q qVar = this.f1632e;
        if (qVar != null) {
            return qVar.c() != null;
        }
        yb.k.f("connectionManager");
        throw null;
    }

    public final boolean p() {
        return s() && j().w().r();
    }

    public final void q() {
        j().w().i();
        if (p()) {
            return;
        }
        f fVarI = i();
        fVarI.f1525b.e(fVarI.f1528e, fVarI.f1529f);
    }

    public final void r(x4.a aVar) {
        aVar.getClass();
        f fVarI = i();
        n0 n0Var = fVarI.f1525b;
        n0Var.getClass();
        x4.c cVarK = aVar.K("PRAGMA query_only");
        try {
            cVarK.G();
            boolean z10 = cVarK.getLong(0) != 0;
            t2.a.h(cVarK, null);
            if (!z10) {
                t0.a.d(aVar, "PRAGMA temp_store = MEMORY");
                t0.a.d(aVar, "PRAGMA recursive_triggers = 1");
                t0.a.d(aVar, "DROP TABLE IF EXISTS room_table_modification_log");
                if (n0Var.f1588c) {
                    t0.a.d(aVar, "CREATE TEMP TABLE IF NOT EXISTS room_table_modification_log (table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)");
                } else {
                    t0.a.d(aVar, hc.o.S("CREATE TEMP TABLE IF NOT EXISTS room_table_modification_log (table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)", "TEMP", ""));
                }
                ab.c cVar = n0Var.f1592g;
                ReentrantLock reentrantLock = (ReentrantLock) cVar.f383b;
                reentrantLock.lock();
                try {
                    cVar.f382a = true;
                } finally {
                    reentrantLock.unlock();
                }
            }
            synchronized (fVarI.f1530g) {
            }
        } finally {
        }
    }

    public final boolean s() {
        q qVar = this.f1632e;
        if (qVar == null) {
            yb.k.f("connectionManager");
            throw null;
        }
        z4.c cVar = (z4.c) qVar.f1604g;
        if (cVar != null) {
            return cVar.f16385c.isOpen();
        }
        return false;
    }

    public final Object t(Callable callable) {
        c();
        try {
            Object objCall = callable.call();
            v();
            return objCall;
        } finally {
            q();
        }
    }

    public final void u(Runnable runnable) {
        c();
        try {
            runnable.run();
            v();
        } finally {
            q();
        }
    }

    public final void v() {
        j().w().F();
    }

    public final Object w(boolean z10, xb.p pVar, pb.c cVar) {
        q qVar = this.f1632e;
        if (qVar != null) {
            return ((o4.b) qVar.f1603f).m(z10, pVar, cVar);
        }
        yb.k.f("connectionManager");
        throw null;
    }
}
