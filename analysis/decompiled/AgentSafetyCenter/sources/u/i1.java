package u;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class i1 extends pb.h implements xb.p {

    /* renamed from: f, reason: collision with root package name */
    public int f13491f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f13492g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ kc.t f13493h;
    public final /* synthetic */ xb.l i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ yb.l f13494j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ yb.u f13495k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ i0 f13496l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public i1(kc.t tVar, xb.l lVar, xb.l lVar2, yb.u uVar, i0 i0Var, nb.c cVar) {
        super(cVar);
        this.f13493h = tVar;
        this.i = lVar;
        this.f13494j = (yb.l) lVar2;
        this.f13495k = uVar;
        this.f13496l = i0Var;
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [xb.l, yb.l] */
    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        i1 i1Var = new i1(this.f13493h, this.i, this.f13494j, this.f13495k, this.f13496l, cVar);
        i1Var.f13492g = obj;
        return i1Var;
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        return ((i1) create((o1.h0) obj, (nb.c) obj2)).invokeSuspend(jb.v.f6774a);
    }

    /* JADX WARN: Type inference failed for: r7v1, types: [xb.l, yb.l] */
    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        ob.a aVar = ob.a.f9351c;
        int i = this.f13491f;
        if (i == 0) {
            id.c.I(obj);
            o1.h0 h0Var = (o1.h0) this.f13492g;
            this.f13491f = 1;
            b0 b0Var = l1.f13522a;
            obj = l1.d(h0Var, o1.k.f9060f, this);
            if (obj == aVar) {
                return aVar;
            }
        } else {
            if (i != 1) {
                od.f.e("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            id.c.I(obj);
        }
        o1.s sVar = (o1.s) obj;
        kc.t tVar = this.f13493h;
        jb.v vVar = jb.v.f6774a;
        i0 i0Var = this.f13496l;
        if (sVar == null) {
            kc.w.u(tVar, null, null, new e1(i0Var, null, 7), 3);
            this.f13494j.invoke(c1.b.a(((o1.s) this.f13495k.f16098c).f9073c));
            return vVar;
        }
        sVar.a();
        kc.w.u(tVar, null, null, new e1(i0Var, null, 6), 3);
        this.i.invoke(c1.b.a(sVar.f9073c));
        return vVar;
    }
}
