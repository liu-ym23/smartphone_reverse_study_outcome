package z3;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class x {

    /* renamed from: a, reason: collision with root package name */
    public static final z7.b f6524a = z7.d.c("io.ktor.client.plugins.HttpCallValidator");

    /* renamed from: b, reason: collision with root package name */
    public static final a4.d f6525b = b8.h.j("HttpResponseValidator", q.f6495a, new p(0));

    /* renamed from: c, reason: collision with root package name */
    public static final r4.a f6526c;

    static {
        kotlin.jvm.internal.f0 f0VarC;
        kotlin.jvm.internal.h hVarA = kotlin.jvm.internal.z.a(Boolean.class);
        try {
            f0VarC = kotlin.jvm.internal.z.c(Boolean.TYPE);
        } catch (Throwable unused) {
            f0VarC = null;
        }
        f6526c = new r4.a("ExpectSuccessAttributeKey", new w4.a(hVarA, f0VarC));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void a(java.util.List r4, java.lang.Throwable r5, f4.b r6, h5.c r7) {
        /*
            boolean r0 = r7 instanceof z3.u
            if (r0 == 0) goto L13
            r0 = r7
            z3.u r0 = (z3.u) r0
            int r1 = r0.f6511b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f6511b = r1
            goto L18
        L13:
            z3.u r0 = new z3.u
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f6510a
            g5.a r1 = g5.a.f2984a
            int r0 = r0.f6511b
            if (r0 == 0) goto L34
            r4 = 1
            if (r0 == r4) goto L26
            r4 = 2
            if (r0 != r4) goto L2a
        L26:
            a.a.c0(r7)
            goto L32
        L2a:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L32:
            r4 = 0
            goto L5a
        L34:
            a.a.c0(r7)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r0 = "Processing exception "
            r7.<init>(r0)
            r7.append(r5)
            java.lang.String r5 = " for request "
            r7.append(r5)
            k4.h0 r5 = r6.u()
            r7.append(r5)
            java.lang.String r5 = r7.toString()
            z7.b r6 = z3.x.f6524a
            r6.h(r5)
            java.util.Iterator r4 = r4.iterator()
        L5a:
            boolean r5 = r4.hasNext()
            if (r5 != 0) goto L61
            return
        L61:
            java.lang.Object r4 = r4.next()
            if (r4 != 0) goto L6d
            a6.w r4 = new a6.w
            r4.<init>()
            throw r4
        L6d:
            java.lang.ClassCastException r4 = new java.lang.ClassCastException
            r4.<init>()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: z3.x.a(java.util.List, java.lang.Throwable, f4.b, h5.c):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object b(java.util.List r4, h4.c r5, h5.c r6) {
        /*
            boolean r0 = r6 instanceof z3.v
            if (r0 == 0) goto L13
            r0 = r6
            z3.v r0 = (z3.v) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            z3.v r0 = new z3.v
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f6517c
            g5.a r1 = g5.a.f2984a
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.util.Iterator r4 = r0.f6516b
            h4.c r5 = r0.f6515a
            a.a.c0(r6)
            goto L59
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            a.a.c0(r6)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r2 = "Validating response for request "
            r6.<init>(r2)
            u3.c r2 = r5.c()
            f4.b r2 = r2.d()
            k4.h0 r2 = r2.u()
            r6.append(r2)
            java.lang.String r6 = r6.toString()
            z7.b r2 = z3.x.f6524a
            r2.h(r6)
            java.util.Iterator r4 = r4.iterator()
        L59:
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L72
            java.lang.Object r6 = r4.next()
            p5.p r6 = (p5.p) r6
            r0.f6515a = r5
            r0.f6516b = r4
            r0.d = r3
            java.lang.Object r6 = r6.invoke(r5, r0)
            if (r6 != r1) goto L59
            return r1
        L72:
            b5.a0 r4 = b5.a0.f883a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: z3.x.b(java.util.List, h4.c, h5.c):java.lang.Object");
    }
}
