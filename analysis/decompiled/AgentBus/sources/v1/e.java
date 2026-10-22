package v1;

import ia.x1;
import o4.d0;

/* loaded from: classes.dex */
public final class e implements d {

    /* renamed from: a, reason: collision with root package name */
    public final h4.n f10348a;

    /* renamed from: b, reason: collision with root package name */
    public final a f10349b;

    /* renamed from: c, reason: collision with root package name */
    public final nb.f f10350c;

    /* renamed from: d, reason: collision with root package name */
    public final h f10351d;

    /* renamed from: e, reason: collision with root package name */
    public final d0 f10352e;

    public e(h4.n nVar, a aVar) {
        nb.f fVar = f.f10353a;
        nb.f fVar2 = f.f10353a;
        h hVar = new h();
        g gVar = h.f10354a;
        ja.d dVar = z1.h.f11782a;
        gVar.getClass();
        ia.d0.b(g7.i.plus(gVar, dVar).Q(g7.m.f3866f).Q(new x1(null)));
        d0 d0Var = new d0(12);
        this.f10348a = nVar;
        this.f10349b = aVar;
        this.f10350c = fVar;
        this.f10351d = hVar;
        this.f10352e = d0Var;
        new a5.a(21, this);
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x008f A[Catch: Exception -> 0x0097, TRY_ENTER, TryCatch #2 {Exception -> 0x0097, blocks: (B:25:0x003f, B:27:0x0051, B:30:0x0056, B:32:0x005a, B:34:0x0067, B:50:0x008f, B:51:0x0096, B:33:0x0063), top: B:61:0x003f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final v1.r a(v1.q r7) {
        /*
            r6 = this;
            nb.f r0 = r6.f10350c
            java.lang.Object r1 = r0.f6947g
            w4.a r1 = (w4.a) r1
            monitor-enter(r1)
            java.lang.Object r2 = r0.f6948h     // Catch: java.lang.Throwable -> L3a
            k.p r2 = (k.p) r2     // Catch: java.lang.Throwable -> L3a
            java.lang.Object r2 = r2.a(r7)     // Catch: java.lang.Throwable -> L3a
            v1.r r2 = (v1.r) r2     // Catch: java.lang.Throwable -> L3a
            if (r2 == 0) goto L3e
            boolean r3 = r2.f10377g     // Catch: java.lang.Throwable -> L3a
            if (r3 == 0) goto L19
            monitor-exit(r1)
            return r2
        L19:
            java.lang.Object r2 = r0.f6948h     // Catch: java.lang.Throwable -> L3a
            k.p r2 = (k.p) r2     // Catch: java.lang.Throwable -> L3a
            h4.n r3 = r2.f5515c     // Catch: java.lang.Throwable -> L3a
            monitor-enter(r3)     // Catch: java.lang.Throwable -> L3a
            androidx.lifecycle.s0 r4 = r2.f5514b     // Catch: java.lang.Throwable -> L34
            r4.getClass()     // Catch: java.lang.Throwable -> L34
            java.util.LinkedHashMap r4 = r4.f1030a     // Catch: java.lang.Throwable -> L34
            java.lang.Object r4 = r4.remove(r7)     // Catch: java.lang.Throwable -> L34
            if (r4 == 0) goto L36
            int r5 = r2.f5516d     // Catch: java.lang.Throwable -> L34
            int r5 = r5 + (-1)
            r2.f5516d = r5     // Catch: java.lang.Throwable -> L34
            goto L36
        L34:
            r6 = move-exception
            goto L3c
        L36:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L3a
            v1.r r4 = (v1.r) r4     // Catch: java.lang.Throwable -> L3a
            goto L3e
        L3a:
            r6 = move-exception
            goto La0
        L3c:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L3a
            throw r6     // Catch: java.lang.Throwable -> L3a
        L3e:
            monitor-exit(r1)
            v1.h r1 = r6.f10351d     // Catch: java.lang.Exception -> L97
            r1.getClass()     // Catch: java.lang.Exception -> L97
            v1.p r1 = r7.f10371a     // Catch: java.lang.Exception -> L97
            o4.d0 r6 = r6.f10352e     // Catch: java.lang.Exception -> L97
            java.lang.Object r6 = r6.f7326g     // Catch: java.lang.Exception -> L97
            int r6 = r7.f10373c     // Catch: java.lang.Exception -> L97
            v1.k r2 = r7.f10372b     // Catch: java.lang.Exception -> L97
            r3 = 0
            if (r1 == 0) goto L63
            boolean r4 = r1 instanceof v1.b     // Catch: java.lang.Exception -> L97
            if (r4 == 0) goto L56
            goto L63
        L56:
            boolean r4 = r1 instanceof v1.m     // Catch: java.lang.Exception -> L97
            if (r4 == 0) goto L6c
            v1.m r1 = (v1.m) r1     // Catch: java.lang.Exception -> L97
            java.lang.String r1 = r1.f10365d     // Catch: java.lang.Exception -> L97
            android.graphics.Typeface r6 = h4.n.h(r1, r2, r6)     // Catch: java.lang.Exception -> L97
            goto L67
        L63:
            android.graphics.Typeface r6 = h4.n.h(r3, r2, r6)     // Catch: java.lang.Exception -> L97
        L67:
            v1.r r3 = new v1.r     // Catch: java.lang.Exception -> L97
            r3.<init>(r6)     // Catch: java.lang.Exception -> L97
        L6c:
            if (r3 == 0) goto L8f
            java.lang.Object r6 = r0.f6947g
            w4.a r6 = (w4.a) r6
            monitor-enter(r6)
            java.lang.Object r1 = r0.f6948h     // Catch: java.lang.Throwable -> L89
            k.p r1 = (k.p) r1     // Catch: java.lang.Throwable -> L89
            java.lang.Object r1 = r1.a(r7)     // Catch: java.lang.Throwable -> L89
            if (r1 != 0) goto L8b
            boolean r1 = r3.f10377g     // Catch: java.lang.Throwable -> L89
            if (r1 == 0) goto L8b
            java.lang.Object r0 = r0.f6948h     // Catch: java.lang.Throwable -> L89
            k.p r0 = (k.p) r0     // Catch: java.lang.Throwable -> L89
            r0.b(r7, r3)     // Catch: java.lang.Throwable -> L89
            goto L8b
        L89:
            r7 = move-exception
            goto L8d
        L8b:
            monitor-exit(r6)
            return r3
        L8d:
            monitor-exit(r6)
            throw r7
        L8f:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException     // Catch: java.lang.Exception -> L97
            java.lang.String r7 = "Could not load font"
            r6.<init>(r7)     // Catch: java.lang.Exception -> L97
            throw r6     // Catch: java.lang.Exception -> L97
        L97:
            r6 = move-exception
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "Could not load font"
            r7.<init>(r0, r6)
            throw r7
        La0:
            monitor-exit(r1)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: v1.e.a(v1.q):v1.r");
    }

    public final r b(p pVar, k kVar, int i2, int i10) {
        a aVar = this.f10349b;
        aVar.getClass();
        int i11 = aVar.f10347f;
        k kVar2 = (i11 == 0 || i11 == Integer.MAX_VALUE) ? kVar : new k(nb.i.k(kVar.f10363f + i11, 1, 1000));
        this.f10348a.getClass();
        return a(new q(pVar, kVar2, i2, i10, null));
    }
}
