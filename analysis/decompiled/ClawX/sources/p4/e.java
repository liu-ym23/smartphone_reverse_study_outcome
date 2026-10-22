package p4;

import java.nio.charset.Charset;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class e implements d6.c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d6.c f4741a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ k4.g f4742b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Charset f4743c;
    public final /* synthetic */ w4.a d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f4744e;

    public e(d6.c cVar, k4.g gVar, Charset charset, w4.a aVar, Object obj) {
        this.f4741a = cVar;
        this.f4742b = gVar;
        this.f4743c = charset;
        this.d = aVar;
        this.f4744e = obj;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0092, code lost:
    
        if (r11.emit(r13, r0) == r1) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // d6.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object emit(java.lang.Object r12, f5.c r13) {
        /*
            r11 = this;
            boolean r0 = r13 instanceof p4.d
            if (r0 == 0) goto L13
            r0 = r13
            p4.d r0 = (p4.d) r0
            int r1 = r0.f4739b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f4739b = r1
            goto L18
        L13:
            p4.d r0 = new p4.d
            r0.<init>(r11, r13)
        L18:
            java.lang.Object r13 = r0.f4738a
            g5.a r1 = g5.a.f2984a
            int r2 = r0.f4739b
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L39
            if (r2 == r5) goto L33
            if (r2 != r4) goto L2b
            a.a.c0(r13)
            goto L95
        L2b:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L33:
            d6.c r11 = r0.f4740c
            a.a.c0(r13)
            goto L8a
        L39:
            a.a.c0(r13)
            r6 = r12
            q4.i r6 = (q4.i) r6
            d6.c r12 = r11.f4741a
            r0.f4740c = r12
            r0.f4739b = r5
            r6.getClass()
            java.nio.charset.Charset r13 = x5.a.f6276a
            java.nio.charset.Charset r9 = r11.f4743c
            boolean r13 = kotlin.jvm.internal.p.a(r9, r13)
            if (r13 == 0) goto L85
            w4.a r13 = r11.d
            v5.c r2 = r13.f6200a
            java.lang.Class<d6.b> r5 = d6.b.class
            kotlin.jvm.internal.h r5 = kotlin.jvm.internal.z.a(r5)
            boolean r2 = r2.equals(r5)
            if (r2 != 0) goto L63
            goto L85
        L63:
            w4.a r13 = k4.z.d(r13)
            kotlinx.serialization.json.Json r2 = r6.f4866a
            kotlinx.serialization.modules.SerializersModule r2 = r2.getSerializersModule()
            kotlinx.serialization.KSerializer r8 = k4.v.j0(r2, r13)
            n4.a r13 = new n4.a
            c4.a r5 = new c4.a
            r10 = 0
            java.lang.Object r7 = r11.f4744e
            r5.<init>(r6, r7, r8, r9, r10)
            k4.g r11 = r11.f4742b
            k4.g r11 = a.a.g0(r11, r9)
            r13.<init>(r5, r11)
            goto L86
        L85:
            r13 = r3
        L86:
            if (r13 != r1) goto L89
            goto L94
        L89:
            r11 = r12
        L8a:
            r0.f4740c = r3
            r0.f4739b = r4
            java.lang.Object r11 = r11.emit(r13, r0)
            if (r11 != r1) goto L95
        L94:
            return r1
        L95:
            b5.a0 r11 = b5.a0.f883a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: p4.e.emit(java.lang.Object, f5.c):java.lang.Object");
    }
}
