package s8;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class r0 extends pb.i implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f11912c;

    /* renamed from: f, reason: collision with root package name */
    public xb.l f11913f;

    /* renamed from: g, reason: collision with root package name */
    public int f11914g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ xb.l f11915h;
    public final /* synthetic */ xb.l i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ r0(xb.l lVar, xb.l lVar2, nb.c cVar, int i) {
        super(2, cVar);
        this.f11912c = i;
        this.f11915h = lVar;
        this.i = lVar2;
    }

    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        switch (this.f11912c) {
            case 0:
                return new r0(this.f11915h, this.i, cVar, 0);
            case 1:
                return new r0(this.f11915h, this.i, cVar, 1);
            case 2:
                return new r0(this.f11915h, this.i, cVar, 2);
            case 3:
                return new r0(this.f11915h, this.i, cVar, 3);
            default:
                return new r0(this.f11915h, this.i, cVar, 4);
        }
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        kc.t tVar = (kc.t) obj;
        nb.c cVar = (nb.c) obj2;
        switch (this.f11912c) {
        }
        return ((r0) create(tVar, cVar)).invokeSuspend(jb.v.f6774a);
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        xb.l lVar;
        xb.l lVar2;
        xb.l lVar3;
        xb.l lVar4;
        xb.l lVar5;
        switch (this.f11912c) {
            case 0:
                ob.a aVar = ob.a.f9351c;
                int i = this.f11914g;
                if (i == 0) {
                    id.c.I(obj);
                    xb.l lVar6 = this.f11915h;
                    this.f11913f = lVar6;
                    this.f11914g = 1;
                    Object objInvoke = this.i.invoke(this);
                    if (objInvoke != aVar) {
                        obj = objInvoke;
                        lVar = lVar6;
                    }
                } else if (i != 1) {
                    od.f.e("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    lVar = this.f11913f;
                    id.c.I(obj);
                }
                lVar.invoke(obj);
                break;
            case 1:
                ob.a aVar2 = ob.a.f9351c;
                int i3 = this.f11914g;
                if (i3 == 0) {
                    id.c.I(obj);
                    xb.l lVar7 = this.f11915h;
                    this.f11913f = lVar7;
                    this.f11914g = 1;
                    Object objInvoke2 = this.i.invoke(this);
                    if (objInvoke2 != aVar2) {
                        obj = objInvoke2;
                        lVar2 = lVar7;
                    }
                } else if (i3 != 1) {
                    od.f.e("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    lVar2 = this.f11913f;
                    id.c.I(obj);
                }
                lVar2.invoke(obj);
                break;
            case 2:
                ob.a aVar3 = ob.a.f9351c;
                int i10 = this.f11914g;
                if (i10 == 0) {
                    id.c.I(obj);
                    xb.l lVar8 = this.f11915h;
                    this.f11913f = lVar8;
                    this.f11914g = 1;
                    Object objInvoke3 = this.i.invoke(this);
                    if (objInvoke3 != aVar3) {
                        obj = objInvoke3;
                        lVar3 = lVar8;
                    }
                } else if (i10 != 1) {
                    od.f.e("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    lVar3 = this.f11913f;
                    id.c.I(obj);
                }
                lVar3.invoke(obj);
                break;
            case 3:
                ob.a aVar4 = ob.a.f9351c;
                int i11 = this.f11914g;
                if (i11 == 0) {
                    id.c.I(obj);
                    xb.l lVar9 = this.f11915h;
                    this.f11913f = lVar9;
                    this.f11914g = 1;
                    Object objInvoke4 = this.i.invoke(this);
                    if (objInvoke4 != aVar4) {
                        obj = objInvoke4;
                        lVar4 = lVar9;
                    }
                } else if (i11 != 1) {
                    od.f.e("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    lVar4 = this.f11913f;
                    id.c.I(obj);
                }
                lVar4.invoke(obj);
                break;
            default:
                ob.a aVar5 = ob.a.f9351c;
                int i12 = this.f11914g;
                if (i12 == 0) {
                    id.c.I(obj);
                    xb.l lVar10 = this.f11915h;
                    this.f11913f = lVar10;
                    this.f11914g = 1;
                    Object objInvoke5 = this.i.invoke(this);
                    if (objInvoke5 != aVar5) {
                        obj = objInvoke5;
                        lVar5 = lVar10;
                    }
                } else if (i12 != 1) {
                    od.f.e("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    lVar5 = this.f11913f;
                    id.c.I(obj);
                }
                lVar5.invoke(obj);
                break;
        }
        return jb.v.f6774a;
    }
}
