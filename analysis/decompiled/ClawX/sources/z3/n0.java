package z3;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class n0 implements y0 {

    /* renamed from: a, reason: collision with root package name */
    public final t3.c f6483a;

    /* renamed from: b, reason: collision with root package name */
    public int f6484b;

    /* renamed from: c, reason: collision with root package name */
    public u3.c f6485c;

    public n0(t3.c client) {
        kotlin.jvm.internal.p.e(client, "client");
        this.f6483a = client;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // z3.y0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(f4.c r6, h5.c r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof z3.m0
            if (r0 == 0) goto L13
            r0 = r7
            z3.m0 r0 = (z3.m0) r0
            int r1 = r0.f6479c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f6479c = r1
            goto L18
        L13:
            z3.m0 r0 = new z3.m0
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f6477a
            g5.a r1 = g5.a.f2984a
            int r2 = r0.f6479c
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L30
            if (r2 != r4) goto L28
            a.a.c0(r7)
            goto L52
        L28:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L30:
            a.a.c0(r7)
            u3.c r7 = r5.f6485c
            if (r7 == 0) goto L3a
            a6.i0.f(r7, r3)
        L3a:
            int r7 = r5.f6484b
            r2 = 20
            if (r7 >= r2) goto L76
            int r7 = r7 + r4
            r5.f6484b = r7
            t3.c r7 = r5.f6483a
            f4.f r7 = r7.f5572g
            java.lang.Object r2 = r6.d
            r0.f6479c = r4
            java.lang.Object r7 = r7.a(r6, r2, r0)
            if (r7 != r1) goto L52
            return r1
        L52:
            boolean r6 = r7 instanceof u3.c
            if (r6 == 0) goto L59
            r3 = r7
            u3.c r3 = (u3.c) r3
        L59:
            if (r3 == 0) goto L5e
            r5.f6485c = r3
            return r3
        L5e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r0 = "Failed to execute send pipeline. Expected [HttpClientCall], but received "
            r6.<init>(r0)
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            java.lang.String r6 = r6.toString()
            r5.<init>(r6)
            throw r5
        L76:
            c6.m r5 = new c6.m
            java.lang.String r6 = "Max send count 20 exceeded. Consider increasing the property maxSendCount if more is required."
            r7 = 5
            r5.<init>(r6, r7)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: z3.n0.a(f4.c, h5.c):java.lang.Object");
    }
}
