package la;

/* loaded from: classes.dex */
public final class o implements j {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ q6.b f5969f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ s2.l f5970g;

    public o(q6.b bVar, s2.l lVar) {
        this.f5969f = bVar;
        this.f5970g = lVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // la.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object x(la.k r10, g7.d r11) throws java.lang.Throwable {
        /*
            r9 = this;
            boolean r0 = r11 instanceof la.n
            if (r0 == 0) goto L13
            r0 = r11
            la.n r0 = (la.n) r0
            int r1 = r0.f5963g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f5963g = r1
            goto L18
        L13:
            la.n r0 = new la.n
            r0.<init>(r9, r11)
        L18:
            java.lang.Object r11 = r0.f5962f
            h7.a r1 = h7.a.f4212f
            int r2 = r0.f5963g
            c7.r r3 = c7.r.f1986a
            r4 = 3
            r5 = 2
            r6 = 1
            r7 = 0
            if (r2 == 0) goto L55
            if (r2 == r6) goto L46
            if (r2 == r5) goto L3e
            if (r2 != r4) goto L36
            java.lang.Object r9 = r0.f5965i
            ma.r r9 = (ma.r) r9
            w7.e0.N(r11)     // Catch: java.lang.Throwable -> L34
            goto L7f
        L34:
            r10 = move-exception
            goto L85
        L36:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L3e:
            java.lang.Object r9 = r0.f5965i
            java.lang.Throwable r9 = (java.lang.Throwable) r9
            w7.e0.N(r11)
            goto L9d
        L46:
            la.k r10 = r0.f5966j
            java.lang.Object r9 = r0.f5965i
            la.o r9 = (la.o) r9
            w7.e0.N(r11)     // Catch: java.lang.Throwable -> L50
            goto L67
        L50:
            r10 = move-exception
            r8 = r10
            r10 = r9
            r9 = r8
            goto L89
        L55:
            w7.e0.N(r11)
            q6.b r11 = r9.f5969f     // Catch: java.lang.Throwable -> L50
            r0.f5965i = r9     // Catch: java.lang.Throwable -> L50
            r0.f5966j = r10     // Catch: java.lang.Throwable -> L50
            r0.f5963g = r6     // Catch: java.lang.Throwable -> L50
            java.lang.Object r11 = r11.x(r10, r0)     // Catch: java.lang.Throwable -> L50
            if (r11 != r1) goto L67
            goto L9c
        L67:
            ma.r r11 = new ma.r
            g7.l r2 = r0.getContext()
            r11.<init>(r10, r2)
            s2.l r9 = r9.f5970g     // Catch: java.lang.Throwable -> L83
            r0.f5965i = r11     // Catch: java.lang.Throwable -> L83
            r0.f5966j = r7     // Catch: java.lang.Throwable -> L83
            r0.f5963g = r4     // Catch: java.lang.Throwable -> L83
            r9.j(r11, r7, r0)     // Catch: java.lang.Throwable -> L83
            if (r3 != r1) goto L7e
            goto L9c
        L7e:
            r9 = r11
        L7f:
            r9.releaseIntercepted()
            return r3
        L83:
            r10 = move-exception
            r9 = r11
        L85:
            r9.releaseIntercepted()
            throw r10
        L89:
            la.w0 r11 = new la.w0
            r11.<init>(r9)
            s2.l r10 = r10.f5970g
            r0.f5965i = r9
            r0.f5966j = r7
            r0.f5963g = r5
            java.lang.Object r10 = la.k0.d(r11, r10, r9, r0)
            if (r10 != r1) goto L9d
        L9c:
            return r1
        L9d:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: la.o.x(la.k, g7.d):java.lang.Object");
    }
}
