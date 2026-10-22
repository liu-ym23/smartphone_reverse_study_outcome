package na;

import f8.x;
import ia.k0;
import ia.y1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final x f6887a = new x("CLOSED", 3);

    /* renamed from: b, reason: collision with root package name */
    public static final x f6888b = new x("UNDEFINED", 3);

    /* renamed from: c, reason: collision with root package name */
    public static final x f6889c = new x("REUSABLE_CLAIMED", 3);

    /* renamed from: d, reason: collision with root package name */
    public static final x f6890d = new x("NO_THREAD_ELEMENTS", 3);

    /* renamed from: e, reason: collision with root package name */
    public static final g7.b f6891e = new g7.b(6);

    /* renamed from: f, reason: collision with root package name */
    public static final g7.b f6892f = new g7.b(7);

    /* renamed from: g, reason: collision with root package name */
    public static final g7.b f6893g = new g7.b(8);

    public static final void a(int i2) {
        if (i2 < 1) {
            throw new IllegalArgumentException(n.f.c(i2, "Expected positive parallelism level, but got ").toString());
        }
    }

    public static final Object b(s sVar, long j2, p7.n nVar) {
        while (true) {
            if (sVar.f6927c >= j2 && !sVar.d()) {
                return sVar;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = c.f6894a;
            Object obj = atomicReferenceFieldUpdater.get(sVar);
            x xVar = f6887a;
            if (obj == xVar) {
                return xVar;
            }
            s sVar2 = (s) ((c) obj);
            if (sVar2 == null) {
                sVar2 = (s) nVar.invoke(Long.valueOf(sVar.f6927c + 1), sVar);
                while (!atomicReferenceFieldUpdater.compareAndSet(sVar, null, sVar2)) {
                    if (atomicReferenceFieldUpdater.get(sVar) != null) {
                        break;
                    }
                }
                if (sVar.d()) {
                    sVar.e();
                }
            }
            sVar = sVar2;
        }
    }

    public static final s c(Object obj) {
        if (obj != f6887a) {
            return (s) obj;
        }
        throw new IllegalStateException("Does not contain segment");
    }

    public static final void d(g7.l lVar, Throwable th) {
        Throwable runtimeException;
        Iterator it = e.f6897a.iterator();
        while (it.hasNext()) {
            try {
                ((CoroutineExceptionHandler) it.next()).e(lVar, th);
            } catch (Throwable th2) {
                if (th == th2) {
                    runtimeException = th;
                } else {
                    runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
                    ib.k.e(runtimeException, th);
                }
                Thread threadCurrentThread = Thread.currentThread();
                threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, runtimeException);
            }
        }
        try {
            ib.k.e(th, new f(lVar));
        } catch (Throwable unused) {
        }
        Thread threadCurrentThread2 = Thread.currentThread();
        threadCurrentThread2.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread2, th);
    }

    public static final boolean e(Object obj) {
        return obj == f6887a;
    }

    public static final Object f(Object obj, Object obj2) {
        if (obj == null) {
            return obj2;
        }
        if (obj instanceof ArrayList) {
            ((ArrayList) obj).add(obj2);
            return obj;
        }
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(obj);
        arrayList.add(obj2);
        return arrayList;
    }

    public static final void g(g7.l lVar, Object obj) {
        if (obj == f6890d) {
            return;
        }
        if (!(obj instanceof w)) {
            Object objR = lVar.r(null, f6892f);
            q7.k.c(objR, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
            a1.a.t(objR);
            throw null;
        }
        w wVar = (w) obj;
        y1[] y1VarArr = wVar.f6933b;
        int length = y1VarArr.length - 1;
        if (length < 0) {
            return;
        }
        y1 y1Var = y1VarArr[length];
        q7.k.b(null);
        Object obj2 = wVar.f6932a[length];
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x008a A[Catch: all -> 0x0069, DONT_GENERATE, TryCatch #2 {all -> 0x0069, blocks: (B:16:0x0049, B:18:0x0057, B:20:0x005d, B:33:0x008d, B:23:0x006b, B:25:0x0079, B:30:0x0084, B:32:0x008a, B:38:0x009a, B:41:0x00a3, B:40:0x00a0, B:28:0x007f), top: B:54:0x0049, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void h(g7.d r9, java.lang.Object r10) throws ia.k0 {
        /*
            boolean r0 = r9 instanceof na.g
            if (r0 == 0) goto Lae
            na.g r9 = (na.g) r9
            ia.x r0 = r9.f6900i
            i7.c r1 = r9.f6901j
            java.lang.Throwable r2 = c7.m.a(r10)
            if (r2 != 0) goto L12
            r3 = r10
            goto L18
        L12:
            ia.v r3 = new ia.v
            r4 = 0
            r3.<init>(r2, r4)
        L18:
            g7.l r2 = r1.getContext()
            boolean r2 = j(r0, r2)
            r4 = 1
            if (r2 == 0) goto L2f
            r9.f6902k = r3
            r9.f4976h = r4
            g7.l r10 = r1.getContext()
            i(r0, r10, r9)
            return
        L2f:
            ia.x0 r0 = ia.z1.a()
            long r5 = r0.f5023h
            r7 = 4294967296(0x100000000, double:2.121995791E-314)
            int r2 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r2 < 0) goto L46
            r9.f6902k = r3
            r9.f4976h = r4
            r0.V(r9)
            goto La8
        L46:
            r0.X(r4)
            g7.l r2 = r1.getContext()     // Catch: java.lang.Throwable -> L69
            ia.z r3 = ia.z.f5027g     // Catch: java.lang.Throwable -> L69
            g7.j r2 = r2.o(r3)     // Catch: java.lang.Throwable -> L69
            ia.g1 r2 = (ia.g1) r2     // Catch: java.lang.Throwable -> L69
            if (r2 == 0) goto L6b
            boolean r3 = r2.b()     // Catch: java.lang.Throwable -> L69
            if (r3 != 0) goto L6b
            java.util.concurrent.CancellationException r10 = r2.E()     // Catch: java.lang.Throwable -> L69
            c7.l r10 = w7.e0.n(r10)     // Catch: java.lang.Throwable -> L69
            r9.resumeWith(r10)     // Catch: java.lang.Throwable -> L69
            goto L8d
        L69:
            r10 = move-exception
            goto La4
        L6b:
            java.lang.Object r2 = r9.f6903l     // Catch: java.lang.Throwable -> L69
            g7.l r3 = r1.getContext()     // Catch: java.lang.Throwable -> L69
            java.lang.Object r2 = n(r3, r2)     // Catch: java.lang.Throwable -> L69
            f8.x r5 = na.b.f6890d     // Catch: java.lang.Throwable -> L69
            if (r2 == r5) goto L7e
            ia.e2 r5 = ia.d0.A(r1, r3, r2)     // Catch: java.lang.Throwable -> L69
            goto L7f
        L7e:
            r5 = 0
        L7f:
            r1.resumeWith(r10)     // Catch: java.lang.Throwable -> L97
            if (r5 == 0) goto L8a
            boolean r10 = r5.p0()     // Catch: java.lang.Throwable -> L69
            if (r10 == 0) goto L8d
        L8a:
            g(r3, r2)     // Catch: java.lang.Throwable -> L69
        L8d:
            boolean r10 = r0.Z()     // Catch: java.lang.Throwable -> L69
            if (r10 != 0) goto L8d
        L93:
            r0.U(r4)
            goto La8
        L97:
            r10 = move-exception
            if (r5 == 0) goto La0
            boolean r1 = r5.p0()     // Catch: java.lang.Throwable -> L69
            if (r1 == 0) goto La3
        La0:
            g(r3, r2)     // Catch: java.lang.Throwable -> L69
        La3:
            throw r10     // Catch: java.lang.Throwable -> L69
        La4:
            r9.i(r10)     // Catch: java.lang.Throwable -> La9
            goto L93
        La8:
            return
        La9:
            r9 = move-exception
            r0.U(r4)
            throw r9
        Lae:
            r9.resumeWith(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: na.b.h(g7.d, java.lang.Object):void");
    }

    public static final void i(ia.x xVar, g7.l lVar, Runnable runnable) throws k0 {
        try {
            xVar.R(lVar, runnable);
        } catch (Throwable th) {
            throw new k0(th, xVar, lVar);
        }
    }

    public static final boolean j(ia.x xVar, g7.l lVar) throws k0 {
        try {
            return xVar.S(lVar);
        } catch (Throwable th) {
            throw new k0(th, xVar, lVar);
        }
    }

    public static final long k(String str, long j2, long j4, long j10) {
        String property;
        int i2 = u.f6929a;
        try {
            property = System.getProperty(str);
        } catch (SecurityException unused) {
            property = null;
        }
        if (property == null) {
            return j2;
        }
        Long lJ0 = ga.r.j0(property);
        if (lJ0 == null) {
            throw new IllegalStateException(("System property '" + str + "' has unrecognized value '" + property + '\'').toString());
        }
        long jLongValue = lJ0.longValue();
        if (j4 <= jLongValue && jLongValue <= j10) {
            return jLongValue;
        }
        throw new IllegalStateException(("System property '" + str + "' should be in range " + j4 + ".." + j10 + ", but is '" + jLongValue + '\'').toString());
    }

    public static int l(String str, int i2, int i10) {
        return (int) k(str, i2, 1, (i10 & 8) != 0 ? Integer.MAX_VALUE : 2097150);
    }

    public static final Object m(g7.l lVar) {
        Object objR = lVar.r(0, f6891e);
        q7.k.b(objR);
        return objR;
    }

    public static final Object n(g7.l lVar, Object obj) {
        if (obj == null) {
            obj = m(lVar);
        }
        if (obj == 0) {
            return f6890d;
        }
        if (obj instanceof Integer) {
            return lVar.r(new w(((Number) obj).intValue(), lVar), f6893g);
        }
        a1.a.t(obj);
        throw null;
    }
}
