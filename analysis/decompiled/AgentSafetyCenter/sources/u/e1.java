package u;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e1 extends pb.i implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f13450c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ i0 f13451f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e1(i0 i0Var, nb.c cVar, int i) {
        super(2, cVar);
        this.f13450c = i;
        this.f13451f = i0Var;
    }

    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        switch (this.f13450c) {
            case 0:
                return new e1(this.f13451f, cVar, 0);
            case 1:
                return new e1(this.f13451f, cVar, 1);
            case 2:
                return new e1(this.f13451f, cVar, 2);
            case 3:
                return new e1(this.f13451f, cVar, 3);
            case 4:
                return new e1(this.f13451f, cVar, 4);
            case 5:
                return new e1(this.f13451f, cVar, 5);
            case 6:
                return new e1(this.f13451f, cVar, 6);
            default:
                return new e1(this.f13451f, cVar, 7);
        }
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        kc.t tVar = (kc.t) obj;
        nb.c cVar = (nb.c) obj2;
        switch (this.f13450c) {
            case 0:
                e1 e1Var = (e1) create(tVar, cVar);
                jb.v vVar = jb.v.f6774a;
                e1Var.invokeSuspend(vVar);
                return vVar;
            case 1:
                e1 e1Var2 = (e1) create(tVar, cVar);
                jb.v vVar2 = jb.v.f6774a;
                e1Var2.invokeSuspend(vVar2);
                return vVar2;
            case 2:
                e1 e1Var3 = (e1) create(tVar, cVar);
                jb.v vVar3 = jb.v.f6774a;
                e1Var3.invokeSuspend(vVar3);
                return vVar3;
            case 3:
                e1 e1Var4 = (e1) create(tVar, cVar);
                jb.v vVar4 = jb.v.f6774a;
                e1Var4.invokeSuspend(vVar4);
                return vVar4;
            case 4:
                e1 e1Var5 = (e1) create(tVar, cVar);
                jb.v vVar5 = jb.v.f6774a;
                e1Var5.invokeSuspend(vVar5);
                return vVar5;
            case 5:
                e1 e1Var6 = (e1) create(tVar, cVar);
                jb.v vVar6 = jb.v.f6774a;
                e1Var6.invokeSuspend(vVar6);
                return vVar6;
            case 6:
                e1 e1Var7 = (e1) create(tVar, cVar);
                jb.v vVar7 = jb.v.f6774a;
                e1Var7.invokeSuspend(vVar7);
                return vVar7;
            default:
                e1 e1Var8 = (e1) create(tVar, cVar);
                jb.v vVar8 = jb.v.f6774a;
                e1Var8.invokeSuspend(vVar8);
                return vVar8;
        }
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        int i = this.f13450c;
        jb.v vVar = jb.v.f6774a;
        i0 i0Var = this.f13451f;
        switch (i) {
            case 0:
                ob.a aVar = ob.a.f9351c;
                id.c.I(obj);
                i0Var.f13489g = true;
                i0Var.f13490h.e(null);
                break;
            case 1:
                ob.a aVar2 = ob.a.f9351c;
                id.c.I(obj);
                i0Var.f13488f = true;
                i0Var.f13490h.e(null);
                break;
            case 2:
                ob.a aVar3 = ob.a.f9351c;
                id.c.I(obj);
                i0Var.f13488f = true;
                i0Var.f13490h.e(null);
                break;
            case 3:
                ob.a aVar4 = ob.a.f9351c;
                id.c.I(obj);
                i0Var.f13489g = true;
                i0Var.f13490h.e(null);
                break;
            case 4:
                ob.a aVar5 = ob.a.f9351c;
                id.c.I(obj);
                i0Var.f13488f = true;
                i0Var.f13490h.e(null);
                break;
            case 5:
                ob.a aVar6 = ob.a.f9351c;
                id.c.I(obj);
                i0Var.f13488f = true;
                i0Var.f13490h.e(null);
                break;
            case 6:
                ob.a aVar7 = ob.a.f9351c;
                id.c.I(obj);
                i0Var.f13488f = true;
                i0Var.f13490h.e(null);
                break;
            default:
                ob.a aVar8 = ob.a.f9351c;
                id.c.I(obj);
                i0Var.f13489g = true;
                i0Var.f13490h.e(null);
                break;
        }
        return vVar;
    }
}
