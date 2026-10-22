package j0;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class q extends h5.i implements p5.l {

    /* renamed from: a, reason: collision with root package name */
    public int f3412a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ y f3413b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(y yVar, f5.c cVar) {
        super(1, cVar);
        this.f3413b = yVar;
    }

    @Override // h5.a
    public final f5.c create(f5.c cVar) {
        return new q(this.f3413b, cVar);
    }

    @Override // p5.l
    public final Object invoke(Object obj) {
        return ((q) create((f5.c) obj)).invokeSuspend(b5.a0.f883a);
    }

    @Override // h5.a
    public final Object invokeSuspend(Object obj) {
        g5.a aVar = g5.a.f2984a;
        int i8 = this.f3412a;
        if (i8 != 0) {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            a.a.c0(obj);
            return obj;
        }
        a.a.c0(obj);
        this.f3412a = 1;
        Object objInvoke = this.f3413b.invoke(this);
        return objInvoke == aVar ? aVar : objInvoke;
    }
}
