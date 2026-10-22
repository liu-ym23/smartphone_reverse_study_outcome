package androidx.room;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class m0 extends pb.i implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public i[] f1576c;

    /* renamed from: f, reason: collision with root package name */
    public n0 f1577f;

    /* renamed from: g, reason: collision with root package name */
    public d0 f1578g;

    /* renamed from: h, reason: collision with root package name */
    public int f1579h;
    public int i;

    /* renamed from: j, reason: collision with root package name */
    public int f1580j;

    /* renamed from: k, reason: collision with root package name */
    public int f1581k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ i[] f1582l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ n0 f1583m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ d0 f1584n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m0(i[] iVarArr, n0 n0Var, d0 d0Var, nb.c cVar) {
        super(2, cVar);
        this.f1582l = iVarArr;
        this.f1583m = n0Var;
        this.f1584n = d0Var;
    }

    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        return new m0(this.f1582l, this.f1583m, this.f1584n, cVar);
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        return ((m0) create((o4.k) obj, (nb.c) obj2)).invokeSuspend(jb.v.f6774a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x006f, code lost:
    
        if (androidx.room.n0.c(r7, r6, r11, r10) == r0) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0057, code lost:
    
        r5 = r9;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0075  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0072 -> B:26:0x0073). Please report as a decompilation issue!!! */
    @Override // pb.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            r10 = this;
            ob.a r0 = ob.a.f9351c
            int r1 = r10.f1581k
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L23
            if (r1 == r3) goto Lc
            if (r1 != r2) goto L1c
        Lc:
            int r1 = r10.f1580j
            int r4 = r10.i
            int r5 = r10.f1579h
            androidx.room.d0 r6 = r10.f1578g
            androidx.room.n0 r7 = r10.f1577f
            androidx.room.i[] r8 = r10.f1576c
            id.c.I(r11)
            goto L57
        L1c:
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r10)
        L21:
            r10 = 0
            return r10
        L23:
            id.c.I(r11)
            androidx.room.i[] r11 = r10.f1582l
            int r1 = r11.length
            r4 = 0
            androidx.room.n0 r5 = r10.f1583m
            androidx.room.d0 r6 = r10.f1584n
            r8 = r11
            r11 = r4
            r7 = r5
        L31:
            if (r4 >= r1) goto L75
            r5 = r8[r4]
            int r9 = r11 + 1
            int r5 = r5.ordinal()
            if (r5 == 0) goto L72
            if (r5 == r3) goto L5d
            if (r5 != r2) goto L59
            r10.f1576c = r8
            r10.f1577f = r7
            r10.f1578g = r6
            r10.f1579h = r9
            r10.i = r4
            r10.f1580j = r1
            r10.f1581k = r2
            java.lang.Object r11 = androidx.room.n0.d(r7, r6, r11, r10)
            if (r11 != r0) goto L56
            goto L71
        L56:
            r5 = r9
        L57:
            r11 = r5
            goto L73
        L59:
            g5.f.a()
            goto L21
        L5d:
            r10.f1576c = r8
            r10.f1577f = r7
            r10.f1578g = r6
            r10.f1579h = r9
            r10.i = r4
            r10.f1580j = r1
            r10.f1581k = r3
            java.lang.Object r11 = androidx.room.n0.c(r7, r6, r11, r10)
            if (r11 != r0) goto L56
        L71:
            return r0
        L72:
            r11 = r9
        L73:
            int r4 = r4 + r3
            goto L31
        L75:
            jb.v r10 = jb.v.f6774a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.m0.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
