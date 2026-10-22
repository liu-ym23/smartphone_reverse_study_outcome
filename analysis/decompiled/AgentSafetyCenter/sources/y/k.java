package y;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class k extends pb.i implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public yb.q f15770c;

    /* renamed from: f, reason: collision with root package name */
    public yb.u f15771f;

    /* renamed from: g, reason: collision with root package name */
    public yb.s f15772g;

    /* renamed from: h, reason: collision with root package name */
    public float f15773h;
    public float i;

    /* renamed from: j, reason: collision with root package name */
    public float f15774j;

    /* renamed from: k, reason: collision with root package name */
    public int f15775k;

    /* renamed from: l, reason: collision with root package name */
    public int f15776l;

    /* renamed from: m, reason: collision with root package name */
    public /* synthetic */ Object f15777m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ int f15778n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ o2.c f15779o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ stepos.support.v7.app.f f15780p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(int i, o2.c cVar, stepos.support.v7.app.f fVar, nb.c cVar2) {
        super(2, cVar2);
        this.f15778n = i;
        this.f15779o = cVar;
        this.f15780p = fVar;
    }

    public static final boolean a(boolean z10, stepos.support.v7.app.f fVar, int i) {
        if (z10) {
            x.r rVar = (x.r) fVar.f12315f;
            if (rVar.g() > i) {
                return true;
            }
            return rVar.g() == i && rVar.h() > 0;
        }
        x.r rVar2 = (x.r) fVar.f12315f;
        if (rVar2.g() < i) {
            return true;
        }
        return rVar2.g() == i && rVar2.h() < 0;
    }

    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        k kVar = new k(this.f15778n, this.f15779o, this.f15780p, cVar);
        kVar.f15777m = obj;
        return kVar;
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        return ((k) create((u.j0) obj, (nb.c) obj2)).invokeSuspend(jb.v.f6774a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:68:0x01cd, code lost:
    
        if (s.d.f(r1, r3, null, !r9, r4, r28, 2) == r7) goto L69;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00a5 A[Catch: i -> 0x00cc, TryCatch #1 {i -> 0x00cc, blocks: (B:57:0x015e, B:25:0x00a1, B:27:0x00a5, B:29:0x00b1, B:31:0x00bf, B:40:0x00d6, B:44:0x0107, B:49:0x0120, B:53:0x014e), top: B:75:0x015e }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00bf A[Catch: i -> 0x00cc, TryCatch #1 {i -> 0x00cc, blocks: (B:57:0x015e, B:25:0x00a1, B:27:0x00a5, B:29:0x00b1, B:31:0x00bf, B:40:0x00d6, B:44:0x0107, B:49:0x0120, B:53:0x014e), top: B:75:0x015e }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01af  */
    /* JADX WARN: Type inference failed for: r4v2, types: [xb.l, yb.l] */
    /* JADX WARN: Type inference failed for: r8v3, types: [xb.l, yb.l] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x0156 -> B:75:0x015e). Please report as a decompilation issue!!! */
    @Override // pb.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r29) {
        /*
            Method dump skipped, instructions count: 483
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y.k.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
