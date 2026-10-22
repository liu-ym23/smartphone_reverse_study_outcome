package j0;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class v extends h5.i implements p5.l {

    /* renamed from: a, reason: collision with root package name */
    public Throwable f3445a;

    /* renamed from: b, reason: collision with root package name */
    public int f3446b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ c0 f3447c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(c0 c0Var, f5.c cVar) {
        super(1, cVar);
        this.f3447c = c0Var;
    }

    @Override // h5.a
    public final f5.c create(f5.c cVar) {
        return new v(this.f3447c, cVar);
    }

    @Override // p5.l
    public final Object invoke(Object obj) {
        return ((v) create((f5.c) obj)).invokeSuspend(b5.a0.f883a);
    }

    @Override // h5.a
    public final Object invokeSuspend(Object obj) {
        Throwable th;
        v0 o0Var;
        g5.a aVar = g5.a.f2984a;
        int i8 = this.f3446b;
        c0 c0Var = this.f3447c;
        try {
        } catch (Throwable th2) {
            u0 u0VarG = c0Var.g();
            this.f3445a = th2;
            this.f3446b = 2;
            Integer numA = u0VarG.a();
            if (numA != aVar) {
                obj = numA;
                th = th2;
            }
        }
        if (i8 == 0) {
            a.a.c0(obj);
            this.f3446b = 1;
            obj = c0.f(c0Var, true, this);
            if (obj == aVar) {
                return aVar;
            }
        } else {
            if (i8 != 1) {
                if (i8 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                th = this.f3445a;
                a.a.c0(obj);
                o0Var = new o0(th, ((Number) obj).intValue());
                return new b5.g(o0Var, Boolean.TRUE);
            }
            a.a.c0(obj);
        }
        o0Var = (v0) obj;
        return new b5.g(o0Var, Boolean.TRUE);
    }
}
