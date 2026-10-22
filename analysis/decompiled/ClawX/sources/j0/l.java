package j0;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class l extends h5.i implements p5.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3388a;

    /* renamed from: b, reason: collision with root package name */
    public int f3389b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ c0 f3390c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ l(c0 c0Var, f5.c cVar, int i8) {
        super(2, cVar);
        this.f3388a = i8;
        this.f3390c = c0Var;
    }

    @Override // h5.a
    public final f5.c create(Object obj, f5.c cVar) {
        switch (this.f3388a) {
            case 0:
                return new l(this.f3390c, cVar, 0);
            case 1:
                return new l(this.f3390c, cVar, 1);
            default:
                return new l(this.f3390c, cVar, 2);
        }
    }

    @Override // p5.p
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f3388a) {
        }
        return ((l) create((a6.f0) obj, (f5.c) obj2)).invokeSuspend(b5.a0.f883a);
    }

    @Override // h5.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        int i8 = this.f3388a;
        b5.a0 a0Var = b5.a0.f883a;
        c0 c0Var = this.f3390c;
        switch (i8) {
            case 0:
                g5.a aVar = g5.a.f2984a;
                int i9 = this.f3389b;
                if (i9 == 0) {
                    a.a.c0(obj);
                    this.f3389b = 1;
                    return c0.c(c0Var, this) == aVar ? aVar : a0Var;
                }
                if (i9 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                a.a.c0(obj);
                return a0Var;
            case 1:
                g5.a aVar2 = g5.a.f2984a;
                int i10 = this.f3389b;
                if (i10 == 0) {
                    a.a.c0(obj);
                    a1.w wVar = c0Var.f3328j;
                    this.f3389b = 1;
                    Object objW = ((a6.s) wVar.f76c).w(this);
                    if (objW != aVar2) {
                        objW = a0Var;
                    }
                    if (objW != aVar2) {
                    }
                    return aVar2;
                }
                if (i10 != 1) {
                    if (i10 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    a.a.c0(obj);
                    return a0Var;
                }
                a.a.c0(obj);
                d6.b bVar = c0Var.g().f3444c;
                c6.a aVar3 = c6.a.f1102a;
                c6.a aVar4 = c6.a.f1103b;
                boolean z = bVar instanceof e6.g;
                f5.i iVar = f5.i.f2626a;
                d6.b bVarA = z ? ((e6.g) bVar).a(iVar, 0, aVar4) : new e6.e(bVar, iVar, 0, aVar4);
                d6.q qVar = new d6.q(2, c0Var);
                this.f3389b = 2;
                if (bVarA.collect(qVar, this) != aVar2) {
                    return a0Var;
                }
                return aVar2;
            default:
                androidx.emoji2.text.m mVar = c0Var.f3327h;
                g5.a aVar5 = g5.a.f2984a;
                int i11 = this.f3389b;
                try {
                    if (i11 == 0) {
                        a.a.c0(obj);
                        if (mVar.n() instanceof m0) {
                            return mVar.n();
                        }
                        this.f3389b = 1;
                        if (c0Var.h(this) == aVar5) {
                            return aVar5;
                        }
                    } else {
                        if (i11 != 1) {
                            if (i11 != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            a.a.c0(obj);
                            return (v0) obj;
                        }
                        a.a.c0(obj);
                    }
                    this.f3389b = 2;
                    obj = c0.e(c0Var, false, this);
                    if (obj == aVar5) {
                        return aVar5;
                    }
                    return (v0) obj;
                } catch (Throwable th) {
                    return new o0(th, -1);
                }
        }
    }
}
