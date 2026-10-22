package m8;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class w extends pb.i implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f8510c = 0;

    /* renamed from: f, reason: collision with root package name */
    public int f8511f;

    /* renamed from: g, reason: collision with root package name */
    public int f8512g;

    /* renamed from: h, reason: collision with root package name */
    public Object f8513h;
    public final /* synthetic */ Object i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Object f8514j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(nc.g[] gVarArr, int i, AtomicInteger atomicInteger, mc.e eVar, nb.c cVar) {
        super(2, cVar);
        this.f8513h = gVarArr;
        this.f8512g = i;
        this.i = atomicInteger;
        this.f8514j = eVar;
    }

    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        switch (this.f8510c) {
            case 0:
                return new w((List) this.f8514j, (k0) this.i, cVar);
            default:
                return new w((nc.g[]) this.f8513h, this.f8512g, (AtomicInteger) this.i, (mc.e) this.f8514j, cVar);
        }
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        kc.t tVar = (kc.t) obj;
        nb.c cVar = (nb.c) obj2;
        switch (this.f8510c) {
        }
        return ((w) create(tVar, cVar)).invokeSuspend(jb.v.f6774a);
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00e9  */
    @Override // pb.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r38) {
        /*
            Method dump skipped, instructions count: 310
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m8.w.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(List list, k0 k0Var, nb.c cVar) {
        super(2, cVar);
        this.i = k0Var;
        this.f8514j = list;
    }
}
