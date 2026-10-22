package qa;

import java.lang.reflect.InvocationHandler;

/* loaded from: classes4.dex */
public final class M implements InvocationHandler {

    /* renamed from: a, reason: collision with root package name */
    public final Object[] f5645a = new Object[0];
    public final /* synthetic */ Class b;
    public final /* synthetic */ N c;

    public M(N n, Class cls) {
        this.c = n;
        this.b = cls;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0042, code lost:
    
        r10 = qa.AbstractC1864p.b(r7, r0, r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0046, code lost:
    
        r7.f5646a.put(r9, r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x006a, code lost:
    
        r7 = (qa.AbstractC1864p) r1;
     */
    /* JADX WARN: Removed duplicated region for block: B:51:0x005d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.reflect.InvocationHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invoke(java.lang.Object r8, java.lang.reflect.Method r9, java.lang.Object[] r10) {
        /*
            r7 = this;
            java.lang.Class r0 = r7.b
            java.lang.Class r1 = r9.getDeclaringClass()
            java.lang.Class<java.lang.Object> r2 = java.lang.Object.class
            if (r1 != r2) goto Lf
            java.lang.Object r7 = r9.invoke(r7, r10)
            return r7
        Lf:
            if (r10 == 0) goto L13
        L11:
            r4 = r10
            goto L16
        L13:
            java.lang.Object[] r10 = r7.f5645a
            goto L11
        L16:
            qa.a r10 = qa.G.b
            boolean r1 = r10.e(r9)
            if (r1 == 0) goto L23
            java.lang.Object r7 = r10.d(r9, r0, r8, r4)
            return r7
        L23:
            qa.N r7 = r7.c
        L25:
            java.util.concurrent.ConcurrentHashMap r10 = r7.f5646a
            java.lang.Object r10 = r10.get(r9)
            boolean r1 = r10 instanceof qa.AbstractC1864p
            if (r1 == 0) goto L32
            qa.p r10 = (qa.AbstractC1864p) r10
            goto L6f
        L32:
            if (r10 != 0) goto L5c
            java.lang.Object r1 = new java.lang.Object
            r1.<init>()
            monitor-enter(r1)
            java.util.concurrent.ConcurrentHashMap r10 = r7.f5646a     // Catch: java.lang.Throwable -> L4d
            java.lang.Object r10 = r10.putIfAbsent(r9, r1)     // Catch: java.lang.Throwable -> L4d
            if (r10 != 0) goto L58
            qa.p r10 = qa.AbstractC1864p.b(r7, r0, r9)     // Catch: java.lang.Throwable -> L50
            java.util.concurrent.ConcurrentHashMap r7 = r7.f5646a     // Catch: java.lang.Throwable -> L4d
            r7.put(r9, r10)     // Catch: java.lang.Throwable -> L4d
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L4d
            goto L6f
        L4d:
            r0 = move-exception
            r7 = r0
            goto L5a
        L50:
            r0 = move-exception
            r8 = r0
            java.util.concurrent.ConcurrentHashMap r7 = r7.f5646a     // Catch: java.lang.Throwable -> L4d
            r7.remove(r9)     // Catch: java.lang.Throwable -> L4d
            throw r8     // Catch: java.lang.Throwable -> L4d
        L58:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L4d
            goto L5c
        L5a:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L4d
            throw r7
        L5c:
            monitor-enter(r10)
            java.util.concurrent.ConcurrentHashMap r1 = r7.f5646a     // Catch: java.lang.Throwable -> L67
            java.lang.Object r1 = r1.get(r9)     // Catch: java.lang.Throwable -> L67
            if (r1 != 0) goto L6a
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L67
            goto L25
        L67:
            r0 = move-exception
            r7 = r0
            goto L80
        L6a:
            r7 = r1
            qa.p r7 = (qa.AbstractC1864p) r7     // Catch: java.lang.Throwable -> L67
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L67
            r10 = r7
        L6f:
            qa.v r1 = new qa.v
            qa.K r2 = r10.f5657a
            F9.f r5 = r10.b
            qa.k r6 = r10.c
            r3 = r8
            r1.<init>(r2, r3, r4, r5, r6)
            java.lang.Object r7 = r10.a(r1, r4)
            return r7
        L80:
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L67
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: qa.M.invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[]):java.lang.Object");
    }
}
