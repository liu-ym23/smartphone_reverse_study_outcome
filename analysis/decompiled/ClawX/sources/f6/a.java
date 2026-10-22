package f6;

import a6.b0;
import a6.d0;
import a6.o0;
import a6.y;
import a6.y1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final androidx.emoji2.text.r f2627a = new androidx.emoji2.text.r("CLOSED", 1);

    /* renamed from: b, reason: collision with root package name */
    public static final androidx.emoji2.text.r f2628b = new androidx.emoji2.text.r("UNDEFINED", 1);

    /* renamed from: c, reason: collision with root package name */
    public static final androidx.emoji2.text.r f2629c = new androidx.emoji2.text.r("REUSABLE_CLAIMED", 1);
    public static final androidx.emoji2.text.r d = new androidx.emoji2.text.r("NO_THREAD_ELEMENTS", 1);

    /* renamed from: e, reason: collision with root package name */
    public static final y f2630e = new y(8);

    /* renamed from: f, reason: collision with root package name */
    public static final y f2631f = new y(9);

    /* renamed from: g, reason: collision with root package name */
    public static final y f2632g = new y(10);

    public static final void a(int i8) {
        if (i8 < 1) {
            throw new IllegalArgumentException(a8.b.j(i8, "Expected positive parallelism level, but got ").toString());
        }
    }

    public static final Object b(q qVar, long j4, p5.p pVar) {
        while (true) {
            if (qVar.f2659c >= j4 && !qVar.d()) {
                return qVar;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = b.f2633a;
            Object obj = atomicReferenceFieldUpdater.get(qVar);
            androidx.emoji2.text.r rVar = f2627a;
            if (obj == rVar) {
                return rVar;
            }
            q qVar2 = (q) ((b) obj);
            if (qVar2 == null) {
                qVar2 = (q) pVar.invoke(Long.valueOf(qVar.f2659c + 1), qVar);
                while (!atomicReferenceFieldUpdater.compareAndSet(qVar, null, qVar2)) {
                    if (atomicReferenceFieldUpdater.get(qVar) != null) {
                        break;
                    }
                }
                if (qVar.d()) {
                    qVar.e();
                }
            }
            qVar = qVar2;
        }
    }

    public static final q c(Object obj) {
        if (obj != f2627a) {
            return (q) obj;
        }
        throw new IllegalStateException("Does not contain segment");
    }

    public static final void d(f5.h hVar, Throwable th) {
        Throwable runtimeException;
        Iterator it = c.f2635a.iterator();
        while (it.hasNext()) {
            try {
                ((d0) it.next()).getClass();
            } catch (Throwable th2) {
                if (th == th2) {
                    runtimeException = th;
                } else {
                    runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
                    a.a.a(runtimeException, th);
                }
                Thread threadCurrentThread = Thread.currentThread();
                threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, runtimeException);
            }
        }
        try {
            a.a.a(th, new d(hVar));
        } catch (Throwable unused) {
        }
        Thread threadCurrentThread2 = Thread.currentThread();
        threadCurrentThread2.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread2, th);
    }

    public static final boolean e(Object obj) {
        return obj == f2627a;
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

    public static final void g(f5.h hVar, Object obj) {
        if (obj == d) {
            return;
        }
        if (!(obj instanceof u)) {
            Object objZ = hVar.z(null, f2631f);
            kotlin.jvm.internal.p.c(objZ, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
            a8.b.x(objZ);
            throw null;
        }
        u uVar = (u) obj;
        y1[] y1VarArr = uVar.f2665b;
        int length = y1VarArr.length - 1;
        if (length < 0) {
            return;
        }
        y1 y1Var = y1VarArr[length];
        kotlin.jvm.internal.p.b(null);
        Object obj2 = uVar.f2664a[length];
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x008a A[Catch: all -> 0x0069, DONT_GENERATE, TryCatch #2 {all -> 0x0069, blocks: (B:16:0x0049, B:18:0x0057, B:20:0x005d, B:33:0x008d, B:23:0x006b, B:25:0x0079, B:30:0x0084, B:32:0x008a, B:38:0x009a, B:41:0x00a3, B:40:0x00a0, B:28:0x007f), top: B:54:0x0049, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void h(f5.c r9, java.lang.Object r10) throws a6.o0 {
        /*
            boolean r0 = r9 instanceof f6.e
            if (r0 == 0) goto Lae
            f6.e r9 = (f6.e) r9
            a6.b0 r0 = r9.d
            h5.c r1 = r9.f2638e
            java.lang.Throwable r2 = b5.i.a(r10)
            if (r2 != 0) goto L12
            r3 = r10
            goto L18
        L12:
            a6.v r3 = new a6.v
            r4 = 0
            r3.<init>(r2, r4)
        L18:
            f5.h r2 = r1.getContext()
            boolean r2 = j(r0, r2)
            r4 = 1
            if (r2 == 0) goto L2f
            r9.f2639f = r3
            r9.f209c = r4
            f5.h r10 = r1.getContext()
            i(r0, r10, r9)
            return
        L2f:
            a6.a1 r0 = a6.z1.a()
            long r5 = r0.f132c
            r7 = 4294967296(0x100000000, double:2.121995791E-314)
            int r2 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r2 < 0) goto L46
            r9.f2639f = r3
            r9.f209c = r4
            r0.I(r9)
            goto La8
        L46:
            r0.K(r4)
            f5.h r2 = r1.getContext()     // Catch: java.lang.Throwable -> L69
            a6.c0 r3 = a6.c0.f143b     // Catch: java.lang.Throwable -> L69
            f5.f r2 = r2.o(r3)     // Catch: java.lang.Throwable -> L69
            a6.h1 r2 = (a6.h1) r2     // Catch: java.lang.Throwable -> L69
            if (r2 == 0) goto L6b
            boolean r3 = r2.a()     // Catch: java.lang.Throwable -> L69
            if (r3 != 0) goto L6b
            java.util.concurrent.CancellationException r10 = r2.v()     // Catch: java.lang.Throwable -> L69
            b5.h r10 = a.a.o(r10)     // Catch: java.lang.Throwable -> L69
            r9.resumeWith(r10)     // Catch: java.lang.Throwable -> L69
            goto L8d
        L69:
            r10 = move-exception
            goto La4
        L6b:
            java.lang.Object r2 = r9.f2640g     // Catch: java.lang.Throwable -> L69
            f5.h r3 = r1.getContext()     // Catch: java.lang.Throwable -> L69
            java.lang.Object r2 = n(r3, r2)     // Catch: java.lang.Throwable -> L69
            androidx.emoji2.text.r r5 = f6.a.d     // Catch: java.lang.Throwable -> L69
            if (r2 == r5) goto L7e
            a6.e2 r5 = a6.i0.z(r1, r3, r2)     // Catch: java.lang.Throwable -> L69
            goto L7f
        L7e:
            r5 = 0
        L7f:
            r1.resumeWith(r10)     // Catch: java.lang.Throwable -> L97
            if (r5 == 0) goto L8a
            boolean r10 = r5.j0()     // Catch: java.lang.Throwable -> L69
            if (r10 == 0) goto L8d
        L8a:
            g(r3, r2)     // Catch: java.lang.Throwable -> L69
        L8d:
            boolean r10 = r0.M()     // Catch: java.lang.Throwable -> L69
            if (r10 != 0) goto L8d
        L93:
            r0.H(r4)
            goto La8
        L97:
            r10 = move-exception
            if (r5 == 0) goto La0
            boolean r1 = r5.j0()     // Catch: java.lang.Throwable -> L69
            if (r1 == 0) goto La3
        La0:
            g(r3, r2)     // Catch: java.lang.Throwable -> L69
        La3:
            throw r10     // Catch: java.lang.Throwable -> L69
        La4:
            r9.g(r10)     // Catch: java.lang.Throwable -> La9
            goto L93
        La8:
            return
        La9:
            r9 = move-exception
            r0.H(r4)
            throw r9
        Lae:
            r9.resumeWith(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: f6.a.h(f5.c, java.lang.Object):void");
    }

    public static final void i(b0 b0Var, f5.h hVar, Runnable runnable) throws o0 {
        try {
            b0Var.C(hVar, runnable);
        } catch (Throwable th) {
            throw new o0(th, b0Var, hVar);
        }
    }

    public static final boolean j(b0 b0Var, f5.h hVar) throws o0 {
        try {
            return b0Var.F(hVar);
        } catch (Throwable th) {
            throw new o0(th, b0Var, hVar);
        }
    }

    public static final long k(String str, long j4, long j8, long j9) {
        String property;
        int i8 = s.f2661a;
        try {
            property = System.getProperty(str);
        } catch (SecurityException unused) {
            property = null;
        }
        if (property == null) {
            return j4;
        }
        Long lF1 = x5.u.f1(property);
        if (lF1 == null) {
            throw new IllegalStateException(("System property '" + str + "' has unrecognized value '" + property + '\'').toString());
        }
        long jLongValue = lF1.longValue();
        if (j8 <= jLongValue && jLongValue <= j9) {
            return jLongValue;
        }
        throw new IllegalStateException(("System property '" + str + "' should be in range " + j8 + ".." + j9 + ", but is '" + jLongValue + '\'').toString());
    }

    public static int l(int i8, int i9, String str) {
        return (int) k(str, i8, 1, (i9 & 8) != 0 ? Integer.MAX_VALUE : 2097150);
    }

    public static final Object m(f5.h hVar) {
        Object objZ = hVar.z(0, f2630e);
        kotlin.jvm.internal.p.b(objZ);
        return objZ;
    }

    public static final Object n(f5.h hVar, Object obj) {
        if (obj == null) {
            obj = m(hVar);
        }
        if (obj == 0) {
            return d;
        }
        if (obj instanceof Integer) {
            return hVar.z(new u(((Number) obj).intValue(), hVar), f2632g);
        }
        a8.b.x(obj);
        throw null;
    }
}
