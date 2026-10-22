package m8;

import u.y0;
import u.z0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class y extends pb.i implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f8521c;

    /* renamed from: f, reason: collision with root package name */
    public int f8522f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ long f8523g;

    /* renamed from: h, reason: collision with root package name */
    public Object f8524h;
    public Object i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Object f8525j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(k0 k0Var, long j10, String str, s8.t tVar, nb.c cVar) {
        super(2, cVar);
        this.f8521c = 0;
        this.f8524h = k0Var;
        this.f8523g = j10;
        this.i = str;
        this.f8525j = tVar;
    }

    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        switch (this.f8521c) {
            case 0:
                return new y((k0) this.f8524h, this.f8523g, (String) this.i, (s8.t) this.f8525j, cVar);
            case 1:
                return new y(1, this.f8523g, (t.d) this.i, (v.k) this.f8525j, cVar);
            case 2:
                y yVar = new y(2, this.f8523g, (z0) this.i, (yb.r) this.f8525j, cVar);
                yVar.f8524h = obj;
                return yVar;
            default:
                return new y((y8.w) this.f8524h, this.f8523g, (g9.b0) this.f8525j, cVar);
        }
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f8521c) {
            case 0:
                return ((y) create((kc.t) obj, (nb.c) obj2)).invokeSuspend(jb.v.f6774a);
            case 1:
                return ((y) create((kc.t) obj, (nb.c) obj2)).invokeSuspend(jb.v.f6774a);
            case 2:
                return ((y) create((y0) obj, (nb.c) obj2)).invokeSuspend(jb.v.f6774a);
            default:
                return ((y) create((kc.t) obj, (nb.c) obj2)).invokeSuspend(jb.v.f6774a);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:128:0x02a3, code lost:
    
        if (((v.k) r4).a(r1, r19) == r10) goto L129;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:110:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0282  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0287  */
    /* JADX WARN: Type inference failed for: r0v13, types: [xb.l, yb.l] */
    /* JADX WARN: Type inference failed for: r0v26, types: [xb.l, yb.l] */
    /* JADX WARN: Type inference failed for: r15v17 */
    /* JADX WARN: Type inference failed for: r15v6 */
    /* JADX WARN: Type inference failed for: r15v7, types: [w0.l] */
    /* JADX WARN: Type inference failed for: r1v45, types: [boolean] */
    @Override // pb.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r20) {
        /*
            Method dump skipped, instructions count: 756
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m8.y.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ y(int i, long j10, Object obj, Object obj2, nb.c cVar) {
        super(2, cVar);
        this.f8521c = i;
        this.i = obj;
        this.f8523g = j10;
        this.f8525j = obj2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(y8.w wVar, long j10, g9.b0 b0Var, nb.c cVar) {
        super(2, cVar);
        this.f8521c = 3;
        this.f8524h = wVar;
        this.f8523g = j10;
        this.f8525j = b0Var;
    }
}
