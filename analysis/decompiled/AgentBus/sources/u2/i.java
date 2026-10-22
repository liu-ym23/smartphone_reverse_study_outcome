package u2;

import ob.o;
import ob.z;
import s2.g0;

/* loaded from: classes.dex */
public final class i implements s2.a {

    /* renamed from: a, reason: collision with root package name */
    public final o f9990a;

    /* renamed from: b, reason: collision with root package name */
    public final z f9991b;

    /* renamed from: c, reason: collision with root package name */
    public final g0 f9992c;

    /* renamed from: d, reason: collision with root package name */
    public final e f9993d;

    /* renamed from: e, reason: collision with root package name */
    public final a f9994e;

    /* renamed from: f, reason: collision with root package name */
    public final ra.d f9995f;

    public i(o oVar, z zVar, g0 g0Var, e eVar) {
        q7.k.e(oVar, "fileSystem");
        q7.k.e(zVar, "path");
        q7.k.e(g0Var, "coordinator");
        this.f9990a = oVar;
        this.f9991b = zVar;
        this.f9992c = g0Var;
        this.f9993d = eVar;
        this.f9994e = new a();
        this.f9995f = new ra.d();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x007f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r10v8, types: [boolean] */
    /* JADX WARN: Type inference failed for: r8v11, types: [boolean] */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r9v0, types: [s2.i0] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(s2.i0 r9, i7.c r10) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r10 instanceof u2.g
            if (r0 == 0) goto L13
            r0 = r10
            u2.g r0 = (u2.g) r0
            int r1 = r0.f9982k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f9982k = r1
            goto L18
        L13:
            u2.g r0 = new u2.g
            r0.<init>(r8, r10)
        L18:
            java.lang.Object r10 = r0.f9980i
            h7.a r1 = h7.a.f4212f
            int r2 = r0.f9982k
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            boolean r8 = r0.f9979h
            u2.c r9 = r0.f9978g
            u2.i r0 = r0.f9977f
            w7.e0.N(r10)     // Catch: java.lang.Throwable -> L2e
            goto L6f
        L2e:
            r10 = move-exception
            r7 = r10
            r10 = r8
            r8 = r0
            r0 = r7
            goto L87
        L34:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3c:
            w7.e0.N(r10)
            u2.a r10 = r8.f9994e
            java.util.concurrent.atomic.AtomicBoolean r10 = r10.f9959a
            boolean r10 = r10.get()
            if (r10 != 0) goto L99
            ra.d r10 = r8.f9995f
            boolean r10 = ra.a.tryLock$default(r10, r4, r3, r4)
            u2.c r2 = new u2.c     // Catch: java.lang.Throwable -> L90
            ob.o r5 = r8.f9990a     // Catch: java.lang.Throwable -> L90
            ob.z r6 = r8.f9991b     // Catch: java.lang.Throwable -> L90
            r2.<init>(r5, r6)     // Catch: java.lang.Throwable -> L90
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r10)     // Catch: java.lang.Throwable -> L84
            r0.f9977f = r8     // Catch: java.lang.Throwable -> L84
            r0.f9978g = r2     // Catch: java.lang.Throwable -> L84
            r0.f9979h = r10     // Catch: java.lang.Throwable -> L84
            r0.f9982k = r3     // Catch: java.lang.Throwable -> L84
            java.lang.Object r9 = r9.j(r2, r5, r0)     // Catch: java.lang.Throwable -> L84
            if (r9 != r1) goto L6b
            return r1
        L6b:
            r0 = r8
            r8 = r10
            r10 = r9
            r9 = r2
        L6f:
            r9.close()     // Catch: java.lang.Throwable -> L74
            r9 = r4
            goto L75
        L74:
            r9 = move-exception
        L75:
            if (r9 != 0) goto L7f
            if (r8 == 0) goto L7e
            ra.d r8 = r0.f9995f
            ra.a.unlock$default(r8, r4, r3, r4)
        L7e:
            return r10
        L7f:
            throw r9     // Catch: java.lang.Throwable -> L80
        L80:
            r9 = move-exception
            r10 = r8
            r8 = r0
            goto L91
        L84:
            r9 = move-exception
            r0 = r9
            r9 = r2
        L87:
            r9.close()     // Catch: java.lang.Throwable -> L8b
            goto L8f
        L8b:
            r9 = move-exception
            ib.k.e(r0, r9)     // Catch: java.lang.Throwable -> L90
        L8f:
            throw r0     // Catch: java.lang.Throwable -> L90
        L90:
            r9 = move-exception
        L91:
            if (r10 == 0) goto L98
            ra.d r8 = r8.f9995f
            ra.a.unlock$default(r8, r4, r3, r4)
        L98:
            throw r9
        L99:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "StorageConnection has already been disposed."
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: u2.i.a(s2.i0, i7.c):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00f6 A[Catch: all -> 0x0106, IOException -> 0x0109, TRY_ENTER, TryCatch #9 {IOException -> 0x0109, all -> 0x0106, blocks: (B:47:0x00f6, B:49:0x00fe, B:57:0x0114, B:64:0x0122, B:63:0x011f), top: B:82:0x0021 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0114 A[Catch: all -> 0x0106, IOException -> 0x0109, TRY_ENTER, TRY_LEAVE, TryCatch #9 {IOException -> 0x0109, all -> 0x0106, blocks: (B:47:0x00f6, B:49:0x00fe, B:57:0x0114, B:64:0x0122, B:63:0x011f), top: B:82:0x0021 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(s2.y r11, i7.c r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 336
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u2.i.b(s2.y, i7.c):java.lang.Object");
    }

    @Override // s2.a
    public final void close() {
        this.f9994e.f9959a.set(true);
        this.f9993d.c();
    }
}
