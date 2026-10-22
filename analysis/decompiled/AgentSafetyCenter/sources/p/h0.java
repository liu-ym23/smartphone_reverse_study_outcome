package p;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class h0 extends pb.h implements xb.p {

    /* renamed from: f, reason: collision with root package name */
    public gc.j f9566f;

    /* renamed from: g, reason: collision with root package name */
    public i0 f9567g;

    /* renamed from: h, reason: collision with root package name */
    public long[] f9568h;
    public int i;

    /* renamed from: j, reason: collision with root package name */
    public int f9569j;

    /* renamed from: k, reason: collision with root package name */
    public int f9570k;

    /* renamed from: l, reason: collision with root package name */
    public int f9571l;

    /* renamed from: m, reason: collision with root package name */
    public long f9572m;

    /* renamed from: n, reason: collision with root package name */
    public int f9573n;

    /* renamed from: o, reason: collision with root package name */
    public /* synthetic */ Object f9574o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ i0 f9575p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ gc.j f9576q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h0(i0 i0Var, gc.j jVar, nb.c cVar) {
        super(cVar);
        this.f9575p = i0Var;
        this.f9576q = jVar;
    }

    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        h0 h0Var = new h0(this.f9575p, this.f9576q, cVar);
        h0Var.f9574o = obj;
        return h0Var;
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        return ((h0) create((gc.l) obj, (nb.c) obj2)).invokeSuspend(jb.v.f6774a);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00a3  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0051 -> B:22:0x00a1). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0053 -> B:14:0x0066). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x006f -> B:19:0x0096). Please report as a decompilation issue!!! */
    @Override // pb.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r22) {
        /*
            r21 = this;
            r0 = r21
            ob.a r1 = ob.a.f9351c
            int r2 = r0.f9573n
            r3 = 0
            r4 = 8
            r5 = 1
            if (r2 == 0) goto L2e
            if (r2 != r5) goto L27
            int r2 = r0.f9571l
            int r6 = r0.f9570k
            long r7 = r0.f9572m
            int r9 = r0.f9569j
            int r10 = r0.i
            long[] r11 = r0.f9568h
            p.i0 r12 = r0.f9567g
            gc.j r13 = r0.f9566f
            java.lang.Object r14 = r0.f9574o
            gc.l r14 = (gc.l) r14
            id.c.I(r22)
            goto L96
        L27:
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r0)
            r0 = 0
            return r0
        L2e:
            id.c.I(r22)
            java.lang.Object r2 = r0.f9574o
            gc.l r2 = (gc.l) r2
            p.i0 r6 = r0.f9575p
            p.g0 r7 = r6.f9579f
            long[] r7 = r7.f9560a
            int r8 = r7.length
            int r8 = r8 + (-2)
            if (r8 < 0) goto La6
            gc.j r9 = r0.f9576q
            r10 = r3
        L43:
            r11 = r7[r10]
            long r13 = ~r11
            r15 = 7
            long r13 = r13 << r15
            long r13 = r13 & r11
            r15 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r13 = r13 & r15
            int r13 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r13 == 0) goto La1
            int r13 = r10 - r8
            int r13 = ~r13
            int r13 = r13 >>> 31
            int r13 = 8 - r13
            r14 = r2
            r2 = r3
            r19 = r11
            r12 = r6
            r11 = r7
            r6 = r13
            r13 = r9
            r9 = r10
            r10 = r8
            r7 = r19
        L66:
            if (r2 >= r6) goto L99
            r15 = 255(0xff, double:1.26E-321)
            long r15 = r15 & r7
            r17 = 128(0x80, double:6.3E-322)
            int r15 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r15 >= 0) goto L96
            int r3 = r9 << 3
            int r3 = r3 + r2
            r13.f4697f = r3
            p.g0 r4 = r12.f9579f
            java.lang.Object[] r4 = r4.f9561b
            r3 = r4[r3]
            r0.f9574o = r14
            r0.f9566f = r13
            r0.f9567g = r12
            r0.f9568h = r11
            r0.i = r10
            r0.f9569j = r9
            r0.f9572m = r7
            r0.f9570k = r6
            r0.f9571l = r2
            r0.f9573n = r5
            r14.b(r3, r0)
            ob.a r0 = ob.a.f9351c
            return r1
        L96:
            long r7 = r7 >> r4
            int r2 = r2 + r5
            goto L66
        L99:
            if (r6 != r4) goto La6
            r8 = r10
            r7 = r11
            r6 = r12
            r2 = r14
            r10 = r9
            r9 = r13
        La1:
            if (r10 == r8) goto La6
            int r10 = r10 + 1
            goto L43
        La6:
            jb.v r0 = jb.v.f6774a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p.h0.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
