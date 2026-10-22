package j0;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class n extends h5.i implements p5.q {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3394a = 1;

    /* renamed from: b, reason: collision with root package name */
    public int f3395b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f3396c;

    public /* synthetic */ n(int i8, f5.c cVar) {
        super(i8, cVar);
    }

    @Override // p5.q
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        switch (this.f3394a) {
            case 0:
                return new n((c0) this.f3396c, (f5.c) obj3).invokeSuspend(b5.a0.f883a);
            default:
                ((Boolean) obj2).getClass();
                n nVar = new n(3, (f5.c) obj3);
                nVar.f3396c = (e0) obj;
                return nVar.invokeSuspend(b5.a0.f883a);
        }
    }

    @Override // h5.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f3394a) {
            case 0:
                g5.a aVar = g5.a.f2984a;
                int i8 = this.f3395b;
                if (i8 == 0) {
                    a.a.c0(obj);
                    c0 c0Var = (c0) this.f3396c;
                    this.f3395b = 1;
                    if (c0.a(c0Var, this) == aVar) {
                        return aVar;
                    }
                } else {
                    if (i8 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    a.a.c0(obj);
                }
                return b5.a0.f883a;
            default:
                g5.a aVar2 = g5.a.f2984a;
                int i9 = this.f3395b;
                if (i9 != 0) {
                    if (i9 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    a.a.c0(obj);
                    return obj;
                }
                a.a.c0(obj);
                e0 e0Var = (e0) this.f3396c;
                this.f3395b = 1;
                e0Var.getClass();
                Object objA = e0.a(e0Var, this);
                return objA == aVar2 ? aVar2 : objA;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(c0 c0Var, f5.c cVar) {
        super(3, cVar);
        this.f3396c = c0Var;
    }
}
