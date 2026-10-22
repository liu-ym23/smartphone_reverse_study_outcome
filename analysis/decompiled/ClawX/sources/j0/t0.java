package j0;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class t0 extends h5.i implements p5.p {
    @Override // h5.a
    public final f5.c create(Object obj, f5.c cVar) {
        return new t0(2, cVar);
    }

    @Override // p5.p
    public final Object invoke(Object obj, Object obj2) {
        t0 t0Var = (t0) create((d6.c) obj, (f5.c) obj2);
        b5.a0 a0Var = b5.a0.f883a;
        t0Var.invokeSuspend(a0Var);
        return a0Var;
    }

    @Override // h5.a
    public final Object invokeSuspend(Object obj) {
        g5.a aVar = g5.a.f2984a;
        a.a.c0(obj);
        return b5.a0.f883a;
    }
}
