package pc;

import com.google.crypto.tink.shaded.protobuf.Reader;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final t f9943a = new t("CLOSED");

    /* renamed from: b, reason: collision with root package name */
    public static final t f9944b = new t("UNDEFINED");

    /* renamed from: c, reason: collision with root package name */
    public static final t f9945c = new t("REUSABLE_CLAIMED");

    /* renamed from: d, reason: collision with root package name */
    public static final t f9946d = new t("NO_THREAD_ELEMENTS");

    /* renamed from: e, reason: collision with root package name */
    public static final k8.d f9947e = new k8.d(10);

    /* renamed from: f, reason: collision with root package name */
    public static final k8.d f9948f = new k8.d(11);

    /* renamed from: g, reason: collision with root package name */
    public static final k8.d f9949g = new k8.d(12);

    public static final void a(int i) {
        if (i >= 1) {
            return;
        }
        od.f.c(k0.a.j(i, "Expected positive parallelism level, but got "));
    }

    public static final Object b(r rVar, long j10, xb.p pVar) {
        while (true) {
            if (rVar.f9982c >= j10 && !rVar.c()) {
                return rVar;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = b.f9950a;
            Object obj = atomicReferenceFieldUpdater.get(rVar);
            t tVar = f9943a;
            if (obj == tVar) {
                return tVar;
            }
            r rVar2 = (r) ((b) obj);
            if (rVar2 == null) {
                rVar2 = (r) pVar.invoke(Long.valueOf(rVar.f9982c + 1), rVar);
                if (atomicReferenceFieldUpdater.compareAndSet(rVar, null, rVar2)) {
                    if (rVar.c()) {
                        rVar.d();
                    }
                }
            }
            rVar = rVar2;
        }
    }

    public static final r c(Object obj) {
        if (obj != f9943a) {
            return (r) obj;
        }
        od.f.e("Does not contain segment");
        return null;
    }

    public static final void d(nb.g gVar, Throwable th) {
        Throwable runtimeException;
        Iterator it = d.f9953a.iterator();
        while (it.hasNext()) {
            try {
                ((kc.r) it.next()).handleException(gVar, th);
            } catch (Throwable th2) {
                if (th == th2) {
                    runtimeException = th;
                } else {
                    runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
                    com.stepos.statsrpk.h.b(runtimeException, th);
                }
                Thread threadCurrentThread = Thread.currentThread();
                threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, runtimeException);
            }
        }
        try {
            e eVar = new e();
            eVar.f9954c = gVar;
            VarHandle.storeStoreFence();
            com.stepos.statsrpk.h.b(th, eVar);
        } catch (Throwable unused) {
        }
        Thread threadCurrentThread2 = Thread.currentThread();
        threadCurrentThread2.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread2, th);
    }

    public static final boolean e(Object obj) {
        return obj == f9943a;
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

    public static final void g(nb.g gVar, Object obj) {
        if (obj == f9946d) {
            return;
        }
        if (!(obj instanceof y)) {
            Object objFold = gVar.fold(null, f9948f);
            objFold.getClass();
            ((v) objFold).f9988f.set(obj);
            return;
        }
        y yVar = (y) obj;
        v[] vVarArr = yVar.f9995c;
        int length = vVarArr.length - 1;
        if (length < 0) {
            return;
        }
        while (true) {
            int i = length - 1;
            v vVar = vVarArr[length];
            vVar.getClass();
            vVar.f9988f.set(yVar.f9994b[length]);
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
    public static final void h(java.lang.Object r9, nb.c r10) {
        /*
            boolean r0 = r10 instanceof pc.f
            if (r0 == 0) goto Lae
            pc.f r10 = (pc.f) r10
            kc.p r0 = r10.f9956h
            pb.c r1 = r10.i
            java.lang.Throwable r2 = jb.i.b(r9)
            if (r2 != 0) goto L12
            r3 = r9
            goto L18
        L12:
            kc.n r3 = new kc.n
            r4 = 0
            r3.<init>(r2, r4)
        L18:
            nb.g r2 = r1.getContext()
            boolean r2 = r0.O(r2)
            r4 = 1
            if (r2 == 0) goto L2f
            r10.f9957j = r3
            r10.f7419g = r4
            nb.g r9 = r1.getContext()
            r0.M(r9, r10)
            return
        L2f:
            kc.j0 r0 = kc.l1.a()
            long r5 = r0.f7444f
            r7 = 4294967296(0x100000000, double:2.121995791E-314)
            int r2 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r2 < 0) goto L46
            r10.f9957j = r3
            r10.f7419g = r4
            r0.R(r10)
            goto La8
        L46:
            r0.S(r4)
            nb.g r2 = r1.getContext()     // Catch: java.lang.Throwable -> L69
            kc.w0 r3 = kc.w0.f7498c     // Catch: java.lang.Throwable -> L69
            nb.e r2 = r2.get(r3)     // Catch: java.lang.Throwable -> L69
            kc.x0 r2 = (kc.x0) r2     // Catch: java.lang.Throwable -> L69
            if (r2 == 0) goto L6b
            boolean r3 = r2.d()     // Catch: java.lang.Throwable -> L69
            if (r3 != 0) goto L6b
            java.util.concurrent.CancellationException r9 = r2.o()     // Catch: java.lang.Throwable -> L69
            jb.h r9 = id.c.l(r9)     // Catch: java.lang.Throwable -> L69
            r10.resumeWith(r9)     // Catch: java.lang.Throwable -> L69
            goto L8d
        L69:
            r9 = move-exception
            goto La4
        L6b:
            java.lang.Object r2 = r10.f9958k     // Catch: java.lang.Throwable -> L69
            nb.g r3 = r1.getContext()     // Catch: java.lang.Throwable -> L69
            java.lang.Object r2 = l(r3, r2)     // Catch: java.lang.Throwable -> L69
            pc.t r5 = pc.a.f9946d     // Catch: java.lang.Throwable -> L69
            if (r2 == r5) goto L7e
            kc.r1 r5 = kc.w.D(r1, r3, r2)     // Catch: java.lang.Throwable -> L69
            goto L7f
        L7e:
            r5 = 0
        L7f:
            r1.resumeWith(r9)     // Catch: java.lang.Throwable -> L97
            if (r5 == 0) goto L8a
            boolean r9 = r5.d0()     // Catch: java.lang.Throwable -> L69
            if (r9 == 0) goto L8d
        L8a:
            g(r3, r2)     // Catch: java.lang.Throwable -> L69
        L8d:
            boolean r9 = r0.U()     // Catch: java.lang.Throwable -> L69
            if (r9 != 0) goto L8d
        L93:
            r0.Q(r4)
            goto La8
        L97:
            r9 = move-exception
            if (r5 == 0) goto La0
            boolean r1 = r5.d0()     // Catch: java.lang.Throwable -> L69
            if (r1 == 0) goto La3
        La0:
            g(r3, r2)     // Catch: java.lang.Throwable -> L69
        La3:
            throw r9     // Catch: java.lang.Throwable -> L69
        La4:
            r10.g(r9)     // Catch: java.lang.Throwable -> La9
            goto L93
        La8:
            return
        La9:
            r9 = move-exception
            r0.Q(r4)
            throw r9
        Lae:
            r10.resumeWith(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: pc.a.h(java.lang.Object, nb.c):void");
    }

    public static final long i(String str, long j10, long j11, long j12) {
        String property;
        int i = u.f9986a;
        try {
            property = System.getProperty(str);
        } catch (SecurityException unused) {
            property = null;
        }
        if (property == null) {
            return j10;
        }
        Long lW = hc.o.W(property);
        if (lW == null) {
            throw new IllegalStateException(("System property '" + str + "' has unrecognized value '" + property + '\'').toString());
        }
        long jLongValue = lW.longValue();
        if (j11 <= jLongValue && jLongValue <= j12) {
            return jLongValue;
        }
        throw new IllegalStateException(("System property '" + str + "' should be in range " + j11 + ".." + j12 + ", but is '" + jLongValue + '\'').toString());
    }

    public static int j(int i, int i3, String str) {
        return (int) i(str, i, 1, (i3 & 8) != 0 ? Reader.READ_DONE : 2097150);
    }

    public static final Object k(nb.g gVar) {
        Object objFold = gVar.fold(0, f9947e);
        objFold.getClass();
        return objFold;
    }

    public static final Object l(nb.g gVar, Object obj) {
        if (obj == null) {
            obj = k(gVar);
        }
        if (obj == 0) {
            return f9946d;
        }
        if (!(obj instanceof Integer)) {
            v vVar = (v) obj;
            ThreadLocal threadLocal = vVar.f9988f;
            Object obj2 = threadLocal.get();
            threadLocal.set(vVar.f9987c);
            return obj2;
        }
        int iIntValue = ((Number) obj).intValue();
        y yVar = new y();
        yVar.f9993a = gVar;
        yVar.f9994b = new Object[iIntValue];
        yVar.f9995c = new v[iIntValue];
        VarHandle.storeStoreFence();
        return gVar.fold(yVar, f9949g);
    }
}
