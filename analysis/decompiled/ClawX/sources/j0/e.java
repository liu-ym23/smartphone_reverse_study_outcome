package j0;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class e extends h5.i implements p5.l {

    /* renamed from: a, reason: collision with root package name */
    public int f3339a;

    @Override // h5.a
    public final f5.c create(f5.c cVar) {
        return new e(1, cVar);
    }

    @Override // p5.l
    public final Object invoke(Object obj) {
        e eVar = (e) create((f5.c) obj);
        b5.a0 a0Var = b5.a0.f883a;
        eVar.invokeSuspend(a0Var);
        return a0Var;
    }

    @Override // h5.a
    public final Object invokeSuspend(Object obj) {
        g5.a aVar = g5.a.f2984a;
        int i8 = this.f3339a;
        if (i8 == 0) {
            a.a.c0(obj);
            this.f3339a = 1;
            throw null;
        }
        if (i8 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        a.a.c0(obj);
        return b5.a0.f883a;
    }
}
