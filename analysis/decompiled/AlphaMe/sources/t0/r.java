package t0;

import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.foreground.SystemForegroundService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Callable;
import s0.C0844b;
import s0.C0852j;

/* loaded from: classes.dex */
public final class r implements A0.a {

    /* renamed from: l, reason: collision with root package name */
    public static final String f15402l = s0.t.f("Processor");

    /* renamed from: b, reason: collision with root package name */
    public final Context f15404b;

    /* renamed from: c, reason: collision with root package name */
    public final C0844b f15405c;

    /* renamed from: d, reason: collision with root package name */
    public final E0.a f15406d;

    /* renamed from: e, reason: collision with root package name */
    public final WorkDatabase f15407e;

    /* renamed from: g, reason: collision with root package name */
    public final HashMap f15409g = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    public final HashMap f15408f = new HashMap();

    /* renamed from: i, reason: collision with root package name */
    public final HashSet f15411i = new HashSet();

    /* renamed from: j, reason: collision with root package name */
    public final ArrayList f15412j = new ArrayList();

    /* renamed from: a, reason: collision with root package name */
    public PowerManager.WakeLock f15403a = null;

    /* renamed from: k, reason: collision with root package name */
    public final Object f15413k = new Object();

    /* renamed from: h, reason: collision with root package name */
    public final HashMap f15410h = new HashMap();

    public r(Context context, C0844b c0844b, E0.a aVar, WorkDatabase workDatabase) {
        this.f15404b = context;
        this.f15405c = c0844b;
        this.f15406d = aVar;
        this.f15407e = workDatabase;
    }

    public static boolean d(String str, P p4, int i4) {
        if (p4 == null) {
            s0.t.d().a(f15402l, "WorkerWrapper could not be found for " + str);
            return false;
        }
        p4.f15380r = i4;
        p4.h();
        p4.f15379q.cancel(true);
        if (p4.f15367e == null || !(p4.f15379q.f390a instanceof D0.a)) {
            s0.t.d().a(P.f15362s, "WorkSpec " + p4.f15366d + " is already done. Not interrupting.");
        } else {
            p4.f15367e.stop(i4);
        }
        s0.t.d().a(f15402l, "WorkerWrapper interrupted for " + str);
        return true;
    }

    public final void a(InterfaceC0918d interfaceC0918d) {
        synchronized (this.f15413k) {
            this.f15412j.add(interfaceC0918d);
        }
    }

    public final P b(String str) {
        P p4 = (P) this.f15408f.remove(str);
        boolean z4 = p4 != null;
        if (!z4) {
            p4 = (P) this.f15409g.remove(str);
        }
        this.f15410h.remove(str);
        if (z4) {
            synchronized (this.f15413k) {
                try {
                    if (!(true ^ this.f15408f.isEmpty())) {
                        Context context = this.f15404b;
                        String str2 = A0.c.f28j;
                        Intent intent = new Intent(context, (Class<?>) SystemForegroundService.class);
                        intent.setAction("ACTION_STOP_FOREGROUND");
                        try {
                            this.f15404b.startService(intent);
                        } catch (Throwable th) {
                            s0.t.d().c(f15402l, "Unable to stop foreground service", th);
                        }
                        PowerManager.WakeLock wakeLock = this.f15403a;
                        if (wakeLock != null) {
                            wakeLock.release();
                            this.f15403a = null;
                        }
                    }
                } finally {
                }
            }
        }
        return p4;
    }

    public final P c(String str) {
        P p4 = (P) this.f15408f.get(str);
        return p4 == null ? (P) this.f15409g.get(str) : p4;
    }

    public final boolean e(String str) {
        boolean z4;
        synchronized (this.f15413k) {
            z4 = c(str) != null;
        }
        return z4;
    }

    public final void f(InterfaceC0918d interfaceC0918d) {
        synchronized (this.f15413k) {
            this.f15412j.remove(interfaceC0918d);
        }
    }

    public final void g(final B0.k kVar) {
        ((E0.c) this.f15406d).f403d.execute(new Runnable() { // from class: t0.q

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ boolean f15401c = false;

            @Override // java.lang.Runnable
            public final void run() {
                r rVar = this.f15399a;
                B0.k kVar2 = kVar;
                boolean z4 = this.f15401c;
                synchronized (rVar.f15413k) {
                    try {
                        Iterator it = rVar.f15412j.iterator();
                        while (it.hasNext()) {
                            ((InterfaceC0918d) it.next()).c(kVar2, z4);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        });
    }

    public final void h(String str, C0852j c0852j) {
        synchronized (this.f15413k) {
            try {
                s0.t.d().e(f15402l, "Moving WorkSpec (" + str + ") to the foreground");
                P p4 = (P) this.f15409g.remove(str);
                if (p4 != null) {
                    if (this.f15403a == null) {
                        PowerManager.WakeLock wakeLockA = C0.r.a(this.f15404b, "ProcessorForegroundLck");
                        this.f15403a = wakeLockA;
                        wakeLockA.acquire();
                    }
                    this.f15408f.put(str, p4);
                    androidx.core.content.c.b(this.f15404b, A0.c.d(this.f15404b, B0.f.v(p4.f15366d), c0852j));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean i(x xVar, android.support.v4.media.session.c cVar) {
        B0.k kVar = xVar.f15425a;
        final String str = kVar.f150a;
        final ArrayList arrayList = new ArrayList();
        B0.r rVar = (B0.r) this.f15407e.runInTransaction(new Callable() { // from class: t0.p
            @Override // java.util.concurrent.Callable
            public final Object call() {
                WorkDatabase workDatabase = this.f15396a.f15407e;
                android.support.v4.media.session.c cVar2 = (android.support.v4.media.session.c) workDatabase.h();
                String str2 = str;
                arrayList.addAll(cVar2.t(str2));
                return workDatabase.g().i(str2);
            }
        });
        if (rVar == null) {
            s0.t.d().g(f15402l, "Didn't find WorkSpec for id " + kVar);
            g(kVar);
            return false;
        }
        synchronized (this.f15413k) {
            try {
                if (e(str)) {
                    Set set = (Set) this.f15410h.get(str);
                    if (((x) set.iterator().next()).f15425a.f151b == kVar.f151b) {
                        set.add(xVar);
                        s0.t.d().a(f15402l, "Work " + kVar + " is already enqueued for processing");
                    } else {
                        g(kVar);
                    }
                    return false;
                }
                if (rVar.f186t != kVar.f151b) {
                    g(kVar);
                    return false;
                }
                O o4 = new O(this.f15404b, this.f15405c, this.f15406d, this, this.f15407e, rVar, arrayList);
                if (cVar != null) {
                    o4.f15361h = cVar;
                }
                P p4 = new P(o4);
                D0.j jVar = p4.f15378p;
                jVar.a(new X.l(2, this, jVar, p4), ((E0.c) this.f15406d).f403d);
                this.f15409g.put(str, p4);
                HashSet hashSet = new HashSet();
                hashSet.add(xVar);
                this.f15410h.put(str, hashSet);
                ((E0.c) this.f15406d).f400a.execute(p4);
                s0.t.d().a(f15402l, r.class.getSimpleName() + ": processing " + kVar);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
