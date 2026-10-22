package t0;

import android.content.Context;
import android.database.Cursor;
import androidx.appcompat.widget.RunnableC0209k;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import kotlin.jvm.internal.Intrinsics;
import s0.C0844b;
import s0.C0850h;

/* loaded from: classes.dex */
public final class P implements Runnable {

    /* renamed from: s, reason: collision with root package name */
    public static final String f15362s = s0.t.f("WorkerWrapper");

    /* renamed from: a, reason: collision with root package name */
    public final Context f15363a;

    /* renamed from: b, reason: collision with root package name */
    public final String f15364b;

    /* renamed from: c, reason: collision with root package name */
    public final android.support.v4.media.session.c f15365c;

    /* renamed from: d, reason: collision with root package name */
    public final B0.r f15366d;

    /* renamed from: e, reason: collision with root package name */
    public s0.s f15367e;

    /* renamed from: f, reason: collision with root package name */
    public final E0.a f15368f;

    /* renamed from: h, reason: collision with root package name */
    public final C0844b f15370h;

    /* renamed from: i, reason: collision with root package name */
    public final y1.f f15371i;

    /* renamed from: j, reason: collision with root package name */
    public final A0.a f15372j;

    /* renamed from: k, reason: collision with root package name */
    public final WorkDatabase f15373k;

    /* renamed from: l, reason: collision with root package name */
    public final B0.u f15374l;

    /* renamed from: m, reason: collision with root package name */
    public final B0.c f15375m;

    /* renamed from: n, reason: collision with root package name */
    public final List f15376n;

    /* renamed from: o, reason: collision with root package name */
    public String f15377o;

    /* renamed from: g, reason: collision with root package name */
    public s0.r f15369g = new s0.o();

    /* renamed from: p, reason: collision with root package name */
    public final D0.j f15378p = new D0.j();

    /* renamed from: q, reason: collision with root package name */
    public final D0.j f15379q = new D0.j();

    /* renamed from: r, reason: collision with root package name */
    public volatile int f15380r = -256;

    public P(O o4) {
        this.f15363a = o4.f15354a;
        this.f15368f = o4.f15356c;
        this.f15372j = o4.f15355b;
        B0.r rVar = o4.f15359f;
        this.f15366d = rVar;
        this.f15364b = rVar.f167a;
        this.f15365c = o4.f15361h;
        this.f15367e = null;
        C0844b c0844b = o4.f15357d;
        this.f15370h = c0844b;
        this.f15371i = c0844b.f14172c;
        WorkDatabase workDatabase = o4.f15358e;
        this.f15373k = workDatabase;
        this.f15374l = workDatabase.g();
        this.f15375m = workDatabase.b();
        this.f15376n = o4.f15360g;
    }

    public final void a(s0.r rVar) {
        boolean z4 = rVar instanceof s0.q;
        B0.r rVar2 = this.f15366d;
        String str = f15362s;
        if (!z4) {
            if (rVar instanceof s0.p) {
                s0.t.d().e(str, "Worker result RETRY for " + this.f15377o);
                c();
                return;
            }
            s0.t.d().e(str, "Worker result FAILURE for " + this.f15377o);
            if (rVar2.d()) {
                d();
                return;
            } else {
                g();
                return;
            }
        }
        s0.t.d().e(str, "Worker result SUCCESS for " + this.f15377o);
        if (rVar2.d()) {
            d();
            return;
        }
        B0.c cVar = this.f15375m;
        String str2 = this.f15364b;
        B0.u uVar = this.f15374l;
        WorkDatabase workDatabase = this.f15373k;
        workDatabase.beginTransaction();
        try {
            uVar.o(s0.G.f14155c, str2);
            uVar.n(str2, ((s0.q) this.f15369g).f14210a);
            this.f15371i.getClass();
            long jCurrentTimeMillis = System.currentTimeMillis();
            Iterator it = cVar.f(str2).iterator();
            while (it.hasNext()) {
                String str3 = (String) it.next();
                if (uVar.g(str3) == s0.G.f14157e && cVar.h(str3)) {
                    s0.t.d().e(str, "Setting status to enqueued for " + str3);
                    uVar.o(s0.G.f14153a, str3);
                    uVar.m(str3, jCurrentTimeMillis);
                }
            }
            workDatabase.setTransactionSuccessful();
            workDatabase.endTransaction();
            e(false);
        } catch (Throwable th) {
            workDatabase.endTransaction();
            e(false);
            throw th;
        }
    }

    public final void b() {
        if (h()) {
            return;
        }
        this.f15373k.beginTransaction();
        try {
            s0.G g4 = this.f15374l.g(this.f15364b);
            this.f15373k.f().a(this.f15364b);
            if (g4 == null) {
                e(false);
            } else if (g4 == s0.G.f14154b) {
                a(this.f15369g);
            } else if (!g4.a()) {
                this.f15380r = -512;
                c();
            }
            this.f15373k.setTransactionSuccessful();
            this.f15373k.endTransaction();
        } catch (Throwable th) {
            this.f15373k.endTransaction();
            throw th;
        }
    }

    public final void c() {
        String str = this.f15364b;
        B0.u uVar = this.f15374l;
        WorkDatabase workDatabase = this.f15373k;
        workDatabase.beginTransaction();
        try {
            uVar.o(s0.G.f14153a, str);
            this.f15371i.getClass();
            uVar.m(str, System.currentTimeMillis());
            uVar.l(this.f15366d.f188v, str);
            uVar.k(str, -1L);
            workDatabase.setTransactionSuccessful();
        } finally {
            workDatabase.endTransaction();
            e(true);
        }
    }

    public final void d() {
        String str = this.f15364b;
        B0.u uVar = this.f15374l;
        WorkDatabase workDatabase = this.f15373k;
        workDatabase.beginTransaction();
        try {
            this.f15371i.getClass();
            uVar.m(str, System.currentTimeMillis());
            androidx.room.A a4 = uVar.f191a;
            uVar.o(s0.G.f14153a, str);
            a4.assertNotSuspendingTransaction();
            B0.s sVar = uVar.f201k;
            k0.j jVarAcquire = sVar.acquire();
            if (str == null) {
                jVarAcquire.bindNull(1);
            } else {
                jVarAcquire.bindString(1, str);
            }
            a4.beginTransaction();
            try {
                jVarAcquire.executeUpdateDelete();
                a4.setTransactionSuccessful();
                a4.endTransaction();
                sVar.release(jVarAcquire);
                uVar.l(this.f15366d.f188v, str);
                a4.assertNotSuspendingTransaction();
                B0.s sVar2 = uVar.f197g;
                k0.j jVarAcquire2 = sVar2.acquire();
                if (str == null) {
                    jVarAcquire2.bindNull(1);
                } else {
                    jVarAcquire2.bindString(1, str);
                }
                a4.beginTransaction();
                try {
                    jVarAcquire2.executeUpdateDelete();
                    a4.setTransactionSuccessful();
                    a4.endTransaction();
                    sVar2.release(jVarAcquire2);
                    uVar.k(str, -1L);
                    workDatabase.setTransactionSuccessful();
                } catch (Throwable th) {
                    a4.endTransaction();
                    sVar2.release(jVarAcquire2);
                    throw th;
                }
            } catch (Throwable th2) {
                a4.endTransaction();
                sVar.release(jVarAcquire);
                throw th2;
            }
        } finally {
            workDatabase.endTransaction();
            e(false);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e(boolean r5) {
        /*
            r4 = this;
            androidx.work.impl.WorkDatabase r0 = r4.f15373k
            r0.beginTransaction()
            androidx.work.impl.WorkDatabase r0 = r4.f15373k     // Catch: java.lang.Throwable -> L3f
            B0.u r0 = r0.g()     // Catch: java.lang.Throwable -> L3f
            r0.getClass()     // Catch: java.lang.Throwable -> L3f
            java.lang.String r1 = "SELECT COUNT(*) > 0 FROM workspec WHERE state NOT IN (2, 3, 5) LIMIT 1"
            r2 = 0
            androidx.room.E r1 = androidx.room.E.d(r2, r1)     // Catch: java.lang.Throwable -> L3f
            androidx.room.A r0 = r0.f191a     // Catch: java.lang.Throwable -> L3f
            r0.assertNotSuspendingTransaction()     // Catch: java.lang.Throwable -> L3f
            android.database.Cursor r0 = t0.J.H(r0, r1)     // Catch: java.lang.Throwable -> L3f
            boolean r3 = r0.moveToFirst()     // Catch: java.lang.Throwable -> L2c
            if (r3 == 0) goto L2e
            int r3 = r0.getInt(r2)     // Catch: java.lang.Throwable -> L2c
            if (r3 == 0) goto L2e
            r3 = 1
            goto L2f
        L2c:
            r5 = move-exception
            goto L72
        L2e:
            r3 = r2
        L2f:
            r0.close()     // Catch: java.lang.Throwable -> L3f
            r1.e()     // Catch: java.lang.Throwable -> L3f
            if (r3 != 0) goto L41
            android.content.Context r0 = r4.f15363a     // Catch: java.lang.Throwable -> L3f
            java.lang.Class<androidx.work.impl.background.systemalarm.RescheduleReceiver> r1 = androidx.work.impl.background.systemalarm.RescheduleReceiver.class
            C0.m.a(r0, r1, r2)     // Catch: java.lang.Throwable -> L3f
            goto L41
        L3f:
            r5 = move-exception
            goto L79
        L41:
            if (r5 == 0) goto L5e
            B0.u r0 = r4.f15374l     // Catch: java.lang.Throwable -> L3f
            s0.G r1 = s0.G.f14153a     // Catch: java.lang.Throwable -> L3f
            java.lang.String r2 = r4.f15364b     // Catch: java.lang.Throwable -> L3f
            r0.o(r1, r2)     // Catch: java.lang.Throwable -> L3f
            B0.u r0 = r4.f15374l     // Catch: java.lang.Throwable -> L3f
            java.lang.String r1 = r4.f15364b     // Catch: java.lang.Throwable -> L3f
            int r2 = r4.f15380r     // Catch: java.lang.Throwable -> L3f
            r0.p(r2, r1)     // Catch: java.lang.Throwable -> L3f
            B0.u r0 = r4.f15374l     // Catch: java.lang.Throwable -> L3f
            java.lang.String r1 = r4.f15364b     // Catch: java.lang.Throwable -> L3f
            r2 = -1
            r0.k(r1, r2)     // Catch: java.lang.Throwable -> L3f
        L5e:
            androidx.work.impl.WorkDatabase r0 = r4.f15373k     // Catch: java.lang.Throwable -> L3f
            r0.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L3f
            androidx.work.impl.WorkDatabase r0 = r4.f15373k
            r0.endTransaction()
            D0.j r4 = r4.f15378p
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)
            r4.j(r5)
            return
        L72:
            r0.close()     // Catch: java.lang.Throwable -> L3f
            r1.e()     // Catch: java.lang.Throwable -> L3f
            throw r5     // Catch: java.lang.Throwable -> L3f
        L79:
            androidx.work.impl.WorkDatabase r4 = r4.f15373k
            r4.endTransaction()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: t0.P.e(boolean):void");
    }

    public final void f() {
        B0.u uVar = this.f15374l;
        String str = this.f15364b;
        s0.G g4 = uVar.g(str);
        s0.G g5 = s0.G.f14154b;
        String str2 = f15362s;
        if (g4 == g5) {
            s0.t.d().a(str2, "Status for " + str + " is RUNNING; not doing any work and rescheduling for later execution");
            e(true);
            return;
        }
        s0.t.d().a(str2, "Status for " + str + " is " + g4 + " ; not doing any work");
        e(false);
    }

    public final void g() {
        String str = this.f15364b;
        WorkDatabase workDatabase = this.f15373k;
        workDatabase.beginTransaction();
        try {
            LinkedList linkedList = new LinkedList();
            linkedList.add(str);
            while (true) {
                boolean zIsEmpty = linkedList.isEmpty();
                B0.u uVar = this.f15374l;
                if (zIsEmpty) {
                    C0850h c0850h = ((s0.o) this.f15369g).f14209a;
                    uVar.l(this.f15366d.f188v, str);
                    uVar.n(str, c0850h);
                    workDatabase.setTransactionSuccessful();
                    return;
                }
                String str2 = (String) linkedList.remove();
                if (uVar.g(str2) != s0.G.f14158f) {
                    uVar.o(s0.G.f14156d, str2);
                }
                linkedList.addAll(this.f15375m.f(str2));
            }
        } finally {
            workDatabase.endTransaction();
            e(false);
        }
    }

    public final boolean h() {
        if (this.f15380r == -256) {
            return false;
        }
        s0.t.d().a(f15362s, "Work interrupted for " + this.f15377o);
        if (this.f15374l.g(this.f15364b) == null) {
            e(false);
        } else {
            e(!r0.a());
        }
        return true;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
        boolean z4;
        boolean z5;
        s0.l lVar;
        StringBuilder sb = new StringBuilder("Work [ id=");
        String str = this.f15364b;
        sb.append(str);
        sb.append(", tags={ ");
        List<String> list = this.f15376n;
        boolean z6 = true;
        for (String str2 : list) {
            if (z6) {
                z6 = false;
            } else {
                sb.append(", ");
            }
            sb.append(str2);
        }
        sb.append(" } ]");
        this.f15377o = sb.toString();
        B0.r rVar = this.f15366d;
        if (h()) {
            return;
        }
        WorkDatabase workDatabase = this.f15373k;
        workDatabase.beginTransaction();
        try {
            s0.G g4 = rVar.f168b;
            s0.G g5 = s0.G.f14153a;
            String str3 = rVar.f169c;
            String str4 = f15362s;
            if (g4 == g5) {
                if (rVar.d() || (rVar.f168b == g5 && rVar.f177k > 0)) {
                    this.f15371i.getClass();
                    if (System.currentTimeMillis() < rVar.a()) {
                        s0.t.d().a(str4, "Delaying execution for " + str3 + " because it is being executed before schedule.");
                        e(true);
                        workDatabase.setTransactionSuccessful();
                    }
                }
                workDatabase.setTransactionSuccessful();
                workDatabase.endTransaction();
                boolean zD = rVar.d();
                C0850h c0850hA = rVar.f171e;
                B0.u uVar = this.f15374l;
                C0844b c0844b = this.f15370h;
                if (!zD) {
                    c0844b.f14174e.getClass();
                    String className = rVar.f170d;
                    Intrinsics.checkNotNullParameter(className, "className");
                    Intrinsics.checkNotNullParameter(className, "className");
                    String str5 = s0.m.f14207a;
                    Intrinsics.checkNotNullParameter(className, "className");
                    try {
                        Object objNewInstance = Class.forName(className).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                        Intrinsics.checkNotNull(objNewInstance, "null cannot be cast to non-null type androidx.work.InputMerger");
                        lVar = (s0.l) objNewInstance;
                    } catch (Exception e4) {
                        s0.t.d().c(s0.m.f14207a, "Trouble instantiating ".concat(className), e4);
                        lVar = null;
                    }
                    if (lVar == null) {
                        s0.t.d().b(str4, "Could not create Input Merger " + className);
                        g();
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(c0850hA);
                    uVar.getClass();
                    androidx.room.E eD = androidx.room.E.d(1, "SELECT output FROM workspec WHERE id IN\n             (SELECT prerequisite_id FROM dependency WHERE work_spec_id=?)");
                    if (str == null) {
                        eD.bindNull(1);
                    } else {
                        eD.bindString(1, str);
                    }
                    androidx.room.A a4 = uVar.f191a;
                    a4.assertNotSuspendingTransaction();
                    Cursor cursorH = J.H(a4, eD);
                    try {
                        ArrayList arrayList2 = new ArrayList(cursorH.getCount());
                        while (cursorH.moveToNext()) {
                            arrayList2.add(C0850h.a(cursorH.isNull(0) ? null : cursorH.getBlob(0)));
                        }
                        cursorH.close();
                        eD.e();
                        arrayList.addAll(arrayList2);
                        c0850hA = lVar.a(arrayList);
                    } catch (Throwable th) {
                        cursorH.close();
                        eD.e();
                        throw th;
                    }
                }
                UUID uuidFromString = UUID.fromString(str);
                ExecutorService executorService = c0844b.f14170a;
                E0.a aVar = this.f15368f;
                C0.v vVar = new C0.v(workDatabase, aVar);
                C0.u uVar2 = new C0.u(workDatabase, this.f15372j, aVar);
                WorkerParameters workerParameters = new WorkerParameters();
                workerParameters.f4312a = uuidFromString;
                workerParameters.f4313b = c0850hA;
                workerParameters.f4314c = new HashSet(list);
                workerParameters.f4315d = this.f15365c;
                workerParameters.f4316e = rVar.f177k;
                workerParameters.f4317f = executorService;
                workerParameters.f4318g = aVar;
                s0.J j4 = c0844b.f14173d;
                workerParameters.f4319h = j4;
                workerParameters.f4320i = vVar;
                workerParameters.f4321j = uVar2;
                if (this.f15367e == null) {
                    this.f15367e = j4.a(this.f15363a, str3, workerParameters);
                }
                s0.s sVar = this.f15367e;
                if (sVar == null) {
                    s0.t.d().b(str4, "Could not create Worker " + str3);
                    g();
                    return;
                }
                if (sVar.isUsed()) {
                    s0.t.d().b(str4, "Received an already-used Worker " + str3 + "; Worker Factory should return new instances");
                    g();
                    return;
                }
                this.f15367e.setUsed();
                workDatabase.beginTransaction();
                try {
                    if (uVar.g(str) == g5) {
                        uVar.o(s0.G.f14154b, str);
                        androidx.room.A a5 = uVar.f191a;
                        a5.assertNotSuspendingTransaction();
                        B0.s sVar2 = uVar.f200j;
                        k0.j jVarAcquire = sVar2.acquire();
                        if (str == null) {
                            z5 = true;
                            jVarAcquire.bindNull(1);
                        } else {
                            z5 = true;
                            jVarAcquire.bindString(1, str);
                        }
                        a5.beginTransaction();
                        try {
                            jVarAcquire.executeUpdateDelete();
                            a5.setTransactionSuccessful();
                            a5.endTransaction();
                            sVar2.release(jVarAcquire);
                            uVar.p(-256, str);
                            z4 = z5;
                        } catch (Throwable th2) {
                            a5.endTransaction();
                            sVar2.release(jVarAcquire);
                            throw th2;
                        }
                    } else {
                        z4 = false;
                    }
                    workDatabase.setTransactionSuccessful();
                    if (!z4) {
                        f();
                        return;
                    }
                    if (h()) {
                        return;
                    }
                    C0.t tVar = new C0.t(this.f15363a, this.f15366d, this.f15367e, uVar2, this.f15368f);
                    E0.c cVar = (E0.c) aVar;
                    cVar.f403d.execute(tVar);
                    int i4 = 7;
                    D0.j jVar = tVar.f320a;
                    androidx.appcompat.app.o oVar = new androidx.appcompat.app.o(i4, this, jVar);
                    C0.q qVar = new C0.q();
                    D0.j jVar2 = this.f15379q;
                    jVar2.a(oVar, qVar);
                    jVar.a(new RunnableC0209k(6, this, jVar), cVar.f403d);
                    jVar2.a(new RunnableC0209k(i4, this, this.f15377o), cVar.f400a);
                    return;
                } finally {
                }
            }
            f();
            workDatabase.setTransactionSuccessful();
            s0.t.d().a(str4, str3 + " is not in ENQUEUED state. Nothing more to do");
        } finally {
            workDatabase.endTransaction();
        }
    }
}
