package j9;

import k0.c1;
import o1.h0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class z extends pb.h implements xb.p {

    /* renamed from: f, reason: collision with root package name */
    public yb.u f6736f;

    /* renamed from: g, reason: collision with root package name */
    public int f6737g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f6738h;
    public final /* synthetic */ c1 i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ c1 f6739j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ o1.w f6740k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ float f6741l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ c1 f6742m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(c1 c1Var, c1 c1Var2, o1.w wVar, float f5, c1 c1Var3, nb.c cVar) {
        super(cVar);
        this.i = c1Var;
        this.f6739j = c1Var2;
        this.f6740k = wVar;
        this.f6741l = f5;
        this.f6742m = c1Var3;
    }

    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        z zVar = new z(this.i, this.f6739j, this.f6740k, this.f6741l, this.f6742m, cVar);
        zVar.f6738h = obj;
        return zVar;
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        return ((z) create((h0) obj, (nb.c) obj2)).invokeSuspend(jb.v.f6774a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0093, code lost:
    
        if (r0 == r5) goto L21;
     */
    @Override // pb.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r17) {
        /*
            r16 = this;
            r0 = r16
            k0.c1 r1 = r0.f6739j
            float r2 = r0.f6741l
            o1.w r3 = r0.f6740k
            java.lang.Object r4 = r0.f6738h
            o1.h0 r4 = (o1.h0) r4
            ob.a r5 = ob.a.f9351c
            int r6 = r0.f6737g
            r7 = 2
            r8 = 1
            k0.c1 r9 = r0.i
            k0.c1 r10 = r0.f6742m
            r11 = 0
            if (r6 == 0) goto L34
            if (r6 == r8) goto L2c
            if (r6 != r7) goto L26
            id.c.I(r17)     // Catch: java.lang.Throwable -> L23
            r0 = r17
            goto L96
        L23:
            r0 = move-exception
            goto Lb4
        L26:
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r0)
            return r11
        L2c:
            yb.u r6 = r0.f6736f
            id.c.I(r17)     // Catch: java.lang.Throwable -> L23
            r8 = r17
            goto L56
        L34:
            id.c.I(r17)
            java.util.ArrayList r6 = j9.b0.f6645n
            java.lang.Object r6 = r9.getValue()
            xb.l r6 = (xb.l) r6
            java.lang.Boolean r12 = java.lang.Boolean.TRUE
            r6.invoke(r12)
            yb.u r6 = new yb.u
            r6.<init>()
            r0.f6738h = r4     // Catch: java.lang.Throwable -> L23
            r0.f6736f = r6     // Catch: java.lang.Throwable -> L23
            r0.f6737g = r8     // Catch: java.lang.Throwable -> L23
            java.lang.Object r8 = u.l1.c(r4, r0, r7)     // Catch: java.lang.Throwable -> L23
            if (r8 != r5) goto L56
            goto L95
        L56:
            o1.s r8 = (o1.s) r8     // Catch: java.lang.Throwable -> L23
            long r12 = r8.f9073c     // Catch: java.lang.Throwable -> L23
            r14 = 4294967295(0xffffffff, double:2.1219957905E-314)
            long r12 = r12 & r14
            int r12 = (int) r12     // Catch: java.lang.Throwable -> L23
            float r12 = java.lang.Float.intBitsToFloat(r12)     // Catch: java.lang.Throwable -> L23
            j9.x r13 = new j9.x     // Catch: java.lang.Throwable -> L23
            r14 = 0
            r13.<init>(r14)     // Catch: java.lang.Throwable -> L23
            r13.f6730f = r6     // Catch: java.lang.Throwable -> L23
            r13.f6731g = r1     // Catch: java.lang.Throwable -> L23
            java.lang.invoke.VarHandle.storeStoreFence()     // Catch: java.lang.Throwable -> L23
            j9.a0.a(r3, r2, r10, r12, r13)     // Catch: java.lang.Throwable -> L23
            long r12 = r8.f9071a     // Catch: java.lang.Throwable -> L23
            j9.y r8 = new j9.y     // Catch: java.lang.Throwable -> L23
            r8.<init>()     // Catch: java.lang.Throwable -> L23
            r8.f6732c = r6     // Catch: java.lang.Throwable -> L23
            r8.f6733f = r1     // Catch: java.lang.Throwable -> L23
            r8.f6734g = r3     // Catch: java.lang.Throwable -> L23
            r8.f6735h = r2     // Catch: java.lang.Throwable -> L23
            r8.i = r10     // Catch: java.lang.Throwable -> L23
            java.lang.invoke.VarHandle.storeStoreFence()     // Catch: java.lang.Throwable -> L23
            r0.f6738h = r11     // Catch: java.lang.Throwable -> L23
            r0.f6736f = r11     // Catch: java.lang.Throwable -> L23
            r0.f6737g = r7     // Catch: java.lang.Throwable -> L23
            java.lang.Object r0 = u.u.b(r4, r12, r8, r0)     // Catch: java.lang.Throwable -> L23
            if (r0 != r5) goto L96
        L95:
            return r5
        L96:
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch: java.lang.Throwable -> L23
            r0.getClass()     // Catch: java.lang.Throwable -> L23
            java.util.ArrayList r0 = j9.b0.f6645n
            java.lang.Object r0 = r9.getValue()
            xb.l r0 = (xb.l) r0
            java.lang.Boolean r1 = java.lang.Boolean.FALSE
            r0.invoke(r1)
            java.lang.Object r0 = r10.getValue()
            xb.p r0 = (xb.p) r0
            r0.invoke(r11, r11)
            jb.v r0 = jb.v.f6774a
            return r0
        Lb4:
            java.util.ArrayList r1 = j9.b0.f6645n
            java.lang.Object r1 = r9.getValue()
            xb.l r1 = (xb.l) r1
            java.lang.Boolean r2 = java.lang.Boolean.FALSE
            r1.invoke(r2)
            java.lang.Object r1 = r10.getValue()
            xb.p r1 = (xb.p) r1
            r1.invoke(r11, r11)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: j9.z.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
