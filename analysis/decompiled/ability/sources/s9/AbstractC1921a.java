package s9;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.internal.DiagnosticCoroutineContextException;
import m9.InterfaceC1731x;
import m9.s0;

/* renamed from: s9.a, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC1921a {

    /* renamed from: a, reason: collision with root package name */
    public static final a5.d f5995a;
    public static final a5.d b;
    public static final a5.d c;
    public static final a5.d d;
    public static final com.stepos.core.a e = new com.stepos.core.a(15);
    public static final com.stepos.core.a f = new com.stepos.core.a(16);
    public static final com.stepos.core.a g = new com.stepos.core.a(17);

    static {
        int i = 6;
        f5995a = new a5.d("CLOSED", i);
        b = new a5.d("UNDEFINED", i);
        c = new a5.d("REUSABLE_CLAIMED", i);
        d = new a5.d("NO_THREAD_ELEMENTS", i);
    }

    public static final void a(int i) {
        if (i < 1) {
            throw new IllegalArgumentException(B7.a.h(i, "Expected positive parallelism level, but got ").toString());
        }
    }

    public static final Object b(p pVar, long j5, S7.n nVar) {
        while (true) {
            if (pVar.c >= j5 && !pVar.d()) {
                return pVar;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = AbstractC1922b.f5996a;
            Object obj = atomicReferenceFieldUpdater.get(pVar);
            a5.d dVar = f5995a;
            if (obj == dVar) {
                return dVar;
            }
            p pVar2 = (p) ((AbstractC1922b) obj);
            if (pVar2 == null) {
                pVar2 = (p) nVar.invoke(Long.valueOf(pVar.c + 1), pVar);
                if (atomicReferenceFieldUpdater.compareAndSet(pVar, null, pVar2)) {
                    if (pVar.d()) {
                        pVar.e();
                    }
                }
            }
            pVar = pVar2;
        }
    }

    public static final p c(Object obj) {
        if (obj != f5995a) {
            return (p) obj;
        }
        throw new IllegalStateException("Does not contain segment");
    }

    public static final void d(H7.h hVar, Throwable th) {
        Throwable runtimeException;
        Iterator it = AbstractC1924d.f5998a.iterator();
        while (it.hasNext()) {
            try {
                ((InterfaceC1731x) it.next()).handleException(hVar, th);
            } catch (Throwable th2) {
                if (th == th2) {
                    runtimeException = th;
                } else {
                    runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
                    S0.b.e0(runtimeException, th);
                }
                Thread threadCurrentThread = Thread.currentThread();
                threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, runtimeException);
            }
        }
        try {
            S0.b.e0(th, new DiagnosticCoroutineContextException(hVar));
        } catch (Throwable unused) {
        }
        Thread threadCurrentThread2 = Thread.currentThread();
        threadCurrentThread2.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread2, th);
    }

    public static final boolean e(Object obj) {
        return obj == f5995a;
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

    public static final void g(H7.h hVar, Object obj) {
        if (obj == d) {
            return;
        }
        if (!(obj instanceof v)) {
            Object objFold = hVar.fold(null, f);
            kotlin.jvm.internal.k.d(objFold, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
            ((s0) objFold).restoreThreadContext(hVar, obj);
            return;
        }
        v vVar = (v) obj;
        s0[] s0VarArr = vVar.c;
        int length = s0VarArr.length - 1;
        if (length < 0) {
            return;
        }
        while (true) {
            int i = length - 1;
            s0 s0Var = s0VarArr[length];
            kotlin.jvm.internal.k.c(s0Var);
            s0Var.restoreThreadContext(hVar, vVar.b[length]);
            if (i < 0) {
                return;
            } else {
                length = i;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x008a A[Catch: all -> 0x0069, DONT_GENERATE, TryCatch #2 {all -> 0x0069, blocks: (B:16:0x0049, B:18:0x0057, B:20:0x005d, B:33:0x008d, B:23:0x006b, B:25:0x0079, B:30:0x0084, B:32:0x008a, B:38:0x009a, B:41:0x00a3, B:40:0x00a0, B:28:0x007f), top: B:54:0x0049, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void h(H7.c r9, java.lang.Object r10) {
        /*
            boolean r0 = r9 instanceof s9.C1925e
            if (r0 == 0) goto Lae
            s9.e r9 = (s9.C1925e) r9
            m9.v r0 = r9.d
            java.lang.Throwable r1 = kotlin.Result.a(r10)
            if (r1 != 0) goto L10
            r2 = r10
            goto L16
        L10:
            m9.t r2 = new m9.t
            r3 = 0
            r2.<init>(r1, r3)
        L16:
            H7.c r1 = r9.e
            H7.h r3 = r1.getContext()
            boolean r3 = r0.isDispatchNeeded(r3)
            r4 = 1
            if (r3 == 0) goto L2f
            r9.f = r2
            r9.c = r4
            H7.h r10 = r1.getContext()
            r0.dispatch(r10, r9)
            return
        L2f:
            m9.T r0 = m9.t0.a()
            long r5 = r0.f5319a
            r7 = 4294967296(0x100000000, double:2.121995791E-314)
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 < 0) goto L46
            r9.f = r2
            r9.c = r4
            r0.F(r9)
            goto La8
        L46:
            r0.H(r4)
            H7.h r2 = r1.getContext()     // Catch: java.lang.Throwable -> L69
            m9.b0 r3 = m9.b0.f5325a     // Catch: java.lang.Throwable -> L69
            H7.f r2 = r2.get(r3)     // Catch: java.lang.Throwable -> L69
            m9.c0 r2 = (m9.c0) r2     // Catch: java.lang.Throwable -> L69
            if (r2 == 0) goto L6b
            boolean r3 = r2.isActive()     // Catch: java.lang.Throwable -> L69
            if (r3 != 0) goto L6b
            java.util.concurrent.CancellationException r10 = r2.i()     // Catch: java.lang.Throwable -> L69
            kotlin.Result$Failure r10 = kotlin.b.a(r10)     // Catch: java.lang.Throwable -> L69
            r9.resumeWith(r10)     // Catch: java.lang.Throwable -> L69
            goto L8d
        L69:
            r10 = move-exception
            goto La4
        L6b:
            java.lang.Object r2 = r9.g     // Catch: java.lang.Throwable -> L69
            H7.h r3 = r1.getContext()     // Catch: java.lang.Throwable -> L69
            java.lang.Object r2 = l(r3, r2)     // Catch: java.lang.Throwable -> L69
            a5.d r5 = s9.AbstractC1921a.d     // Catch: java.lang.Throwable -> L69
            if (r2 == r5) goto L7e
            m9.w0 r5 = m9.AbstractC1683A.v(r1, r3, r2)     // Catch: java.lang.Throwable -> L69
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
            boolean r10 = r0.J()     // Catch: java.lang.Throwable -> L69
            if (r10 != 0) goto L8d
        L93:
            r0.E(r4)
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
            r9.o(r10)     // Catch: java.lang.Throwable -> La9
            goto L93
        La8:
            return
        La9:
            r9 = move-exception
            r0.E(r4)
            throw r9
        Lae:
            r9.resumeWith(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: s9.AbstractC1921a.h(H7.c, java.lang.Object):void");
    }

    public static final long i(String str, long j5, long j6, long j10) {
        String property;
        int i = r.f6007a;
        try {
            property = System.getProperty(str);
        } catch (SecurityException unused) {
            property = null;
        }
        if (property == null) {
            return j5;
        }
        Long lG0 = j9.t.g0(property);
        if (lG0 == null) {
            throw new IllegalStateException(("System property '" + str + "' has unrecognized value '" + property + '\'').toString());
        }
        long jLongValue = lG0.longValue();
        if (j6 <= jLongValue && jLongValue <= j10) {
            return jLongValue;
        }
        StringBuilder sb = new StringBuilder("System property '");
        sb.append(str);
        sb.append("' should be in range ");
        sb.append(j6);
        androidx.compose.foundation.b.y(j10, "..", ", but is '", sb);
        sb.append(jLongValue);
        sb.append('\'');
        throw new IllegalStateException(sb.toString().toString());
    }

    public static int j(int i, int i6, String str) {
        return (int) i(str, i, 1, (i6 & 8) != 0 ? Integer.MAX_VALUE : 2097150);
    }

    public static final Object k(H7.h hVar) {
        Object objFold = hVar.fold(0, e);
        kotlin.jvm.internal.k.c(objFold);
        return objFold;
    }

    public static final Object l(H7.h hVar, Object obj) {
        if (obj == null) {
            obj = k(hVar);
        }
        return obj == 0 ? d : obj instanceof Integer ? hVar.fold(new v(((Number) obj).intValue(), hVar), g) : ((s0) obj).updateThreadContext(hVar);
    }
}
