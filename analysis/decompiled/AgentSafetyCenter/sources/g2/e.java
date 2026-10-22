package g2;

import p5.u;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e implements d {

    /* renamed from: a, reason: collision with root package name */
    public p f4243a;

    /* renamed from: b, reason: collision with root package name */
    public u f4244b;

    /* renamed from: c, reason: collision with root package name */
    public a1.g f4245c;

    /* JADX WARN: Removed duplicated region for block: B:26:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0082 A[Catch: Exception -> 0x008a, TRY_ENTER, TryCatch #1 {Exception -> 0x008a, blocks: (B:15:0x0027, B:17:0x0036, B:20:0x003b, B:22:0x003f, B:24:0x0052, B:40:0x0082, B:41:0x0089, B:23:0x004b), top: B:49:0x0027 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final g2.s a(g2.r r7) {
        /*
            r6 = this;
            p5.u r0 = r6.f4244b
            java.lang.Object r1 = r0.f9807f
            f8.b r1 = (f8.b) r1
            monitor-enter(r1)
            java.lang.Object r2 = r0.f9808g     // Catch: java.lang.Throwable -> L24
            p.p r2 = (p.p) r2     // Catch: java.lang.Throwable -> L24
            java.lang.Object r2 = r2.b(r7)     // Catch: java.lang.Throwable -> L24
            g2.s r2 = (g2.s) r2     // Catch: java.lang.Throwable -> L24
            if (r2 == 0) goto L26
            boolean r3 = r2.f4267f     // Catch: java.lang.Throwable -> L24
            if (r3 == 0) goto L19
            monitor-exit(r1)
            return r2
        L19:
            java.lang.Object r2 = r0.f9808g     // Catch: java.lang.Throwable -> L24
            p.p r2 = (p.p) r2     // Catch: java.lang.Throwable -> L24
            java.lang.Object r2 = r2.d(r7)     // Catch: java.lang.Throwable -> L24
            g2.s r2 = (g2.s) r2     // Catch: java.lang.Throwable -> L24
            goto L26
        L24:
            r6 = move-exception
            goto L93
        L26:
            monitor-exit(r1)
            g2.q r1 = r7.f4261a     // Catch: java.lang.Exception -> L8a
            a1.g r6 = r6.f4245c     // Catch: java.lang.Exception -> L8a
            java.lang.Object r6 = r6.f19f     // Catch: java.lang.Exception -> L8a
            f8.b r6 = (f8.b) r6     // Catch: java.lang.Exception -> L8a
            int r2 = r7.f4263c     // Catch: java.lang.Exception -> L8a
            g2.k r3 = r7.f4262b     // Catch: java.lang.Exception -> L8a
            r4 = 0
            if (r1 == 0) goto L4b
            boolean r5 = r1 instanceof g2.b     // Catch: java.lang.Exception -> L8a
            if (r5 == 0) goto L3b
            goto L4b
        L3b:
            boolean r5 = r1 instanceof g2.m     // Catch: java.lang.Exception -> L8a
            if (r5 == 0) goto L5f
            g2.m r1 = (g2.m) r1     // Catch: java.lang.Exception -> L8a
            r6.getClass()     // Catch: java.lang.Exception -> L8a
            java.lang.String r6 = "sans-serif"
            android.graphics.Typeface r6 = f8.b.j(r6, r3, r2)     // Catch: java.lang.Exception -> L8a
            goto L52
        L4b:
            r6.getClass()     // Catch: java.lang.Exception -> L8a
            android.graphics.Typeface r6 = f8.b.j(r4, r3, r2)     // Catch: java.lang.Exception -> L8a
        L52:
            g2.s r4 = new g2.s     // Catch: java.lang.Exception -> L8a
            r4.<init>()     // Catch: java.lang.Exception -> L8a
            r4.f4266c = r6     // Catch: java.lang.Exception -> L8a
            r6 = 1
            r4.f4267f = r6     // Catch: java.lang.Exception -> L8a
            java.lang.invoke.VarHandle.storeStoreFence()     // Catch: java.lang.Exception -> L8a
        L5f:
            if (r4 == 0) goto L82
            java.lang.Object r6 = r0.f9807f
            f8.b r6 = (f8.b) r6
            monitor-enter(r6)
            java.lang.Object r1 = r0.f9808g     // Catch: java.lang.Throwable -> L7c
            p.p r1 = (p.p) r1     // Catch: java.lang.Throwable -> L7c
            java.lang.Object r1 = r1.b(r7)     // Catch: java.lang.Throwable -> L7c
            if (r1 != 0) goto L7e
            boolean r1 = r4.f4267f     // Catch: java.lang.Throwable -> L7c
            if (r1 == 0) goto L7e
            java.lang.Object r0 = r0.f9808g     // Catch: java.lang.Throwable -> L7c
            p.p r0 = (p.p) r0     // Catch: java.lang.Throwable -> L7c
            r0.c(r7, r4)     // Catch: java.lang.Throwable -> L7c
            goto L7e
        L7c:
            r7 = move-exception
            goto L80
        L7e:
            monitor-exit(r6)
            return r4
        L80:
            monitor-exit(r6)
            throw r7
        L82:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException     // Catch: java.lang.Exception -> L8a
            java.lang.String r7 = "Could not load font"
            r6.<init>(r7)     // Catch: java.lang.Exception -> L8a
            throw r6     // Catch: java.lang.Exception -> L8a
        L8a:
            r6 = move-exception
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "Could not load font"
            r7.<init>(r0, r6)
            throw r7
        L93:
            monitor-exit(r1)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: g2.e.a(g2.r):g2.s");
    }
}
