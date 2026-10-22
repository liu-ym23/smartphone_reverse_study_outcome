package u;

import java.util.concurrent.CancellationException;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class j extends pb.i implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public yb.r f13497c;

    /* renamed from: f, reason: collision with root package name */
    public s.i f13498f;

    /* renamed from: g, reason: collision with root package name */
    public int f13499g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ float f13500h;
    public final /* synthetic */ k i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ w0 f13501j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(float f5, k kVar, w0 w0Var, nb.c cVar) {
        super(2, cVar);
        this.f13500h = f5;
        this.i = kVar;
        this.f13501j = w0Var;
    }

    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        return new j(this.f13500h, this.i, this.f13501j, cVar);
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        return ((j) create((kc.t) obj, (nb.c) obj2)).invokeSuspend(jb.v.f6774a);
    }

    /* JADX WARN: Type inference failed for: r10v5, types: [xb.l, yb.l] */
    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        float f5;
        s.i iVar;
        yb.r rVar;
        s.t tVar;
        b0.r rVar2;
        ob.a aVar = ob.a.f9351c;
        int i = this.f13499g;
        if (i == 0) {
            id.c.I(obj);
            f5 = this.f13500h;
            if (Math.abs(f5) > 1.0f) {
                yb.r rVar3 = new yb.r();
                rVar3.f16095c = f5;
                yb.r rVar4 = new yb.r();
                s.i iVarB = s.d.b(f5, 28);
                try {
                    k kVar = this.i;
                    tVar = kVar.f13513a;
                    rVar2 = new b0.r(rVar4, this.f13501j, rVar3, kVar, 3);
                    this.f13497c = rVar3;
                    this.f13498f = iVarB;
                    this.f13499g = 1;
                } catch (CancellationException unused) {
                    iVar = iVarB;
                    rVar = rVar3;
                    rVar.f16095c = ((Number) ((yb.l) iVar.f11020c.f8777f).invoke(iVar.f11022g)).floatValue();
                    f5 = rVar.f16095c;
                    return new Float(f5);
                }
                if (s.d.d(iVarB, tVar, rVar2, this) == aVar) {
                    return aVar;
                }
                rVar = rVar3;
                f5 = rVar.f16095c;
            }
        } else {
            if (i != 1) {
                od.f.e("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            iVar = this.f13498f;
            rVar = this.f13497c;
            try {
                id.c.I(obj);
            } catch (CancellationException unused2) {
                rVar.f16095c = ((Number) ((yb.l) iVar.f11020c.f8777f).invoke(iVar.f11022g)).floatValue();
                f5 = rVar.f16095c;
                return new Float(f5);
            }
            f5 = rVar.f16095c;
        }
        return new Float(f5);
    }
}
