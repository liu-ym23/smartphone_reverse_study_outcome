package v3;

import java.io.Serializable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class x extends pb.i implements xb.l {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f14743c = 1;

    /* renamed from: f, reason: collision with root package name */
    public int f14744f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ z f14745g;

    /* renamed from: h, reason: collision with root package name */
    public Object f14746h;
    public final /* synthetic */ Object i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Serializable f14747j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public x(z zVar, nb.g gVar, xb.p pVar, nb.c cVar) {
        super(1, cVar);
        this.f14745g = zVar;
        this.i = gVar;
        this.f14747j = (pb.i) pVar;
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [pb.i, xb.p] */
    @Override // pb.a
    public final nb.c create(nb.c cVar) {
        switch (this.f14743c) {
            case 0:
                return new x((yb.u) this.i, this.f14745g, (yb.s) this.f14747j, cVar);
            default:
                return new x(this.f14745g, (nb.g) this.i, (xb.p) this.f14747j, cVar);
        }
    }

    @Override // xb.l
    public final Object invoke(Object obj) {
        nb.c cVar = (nb.c) obj;
        switch (this.f14743c) {
        }
        return ((x) create(cVar)).invokeSuspend(jb.v.f6774a);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x007b  */
    /* JADX WARN: Type inference failed for: r7v2, types: [pb.i, xb.p] */
    @Override // pb.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 266
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: v3.x.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(yb.u uVar, z zVar, yb.s sVar, nb.c cVar) {
        super(1, cVar);
        this.i = uVar;
        this.f14745g = zVar;
        this.f14747j = sVar;
    }
}
