package z3;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class c extends h5.i implements p5.q {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ f4.c f6424a;

    @Override // p5.q
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        c cVar = new c(3, (f5.c) obj3);
        cVar.f6424a = (f4.c) obj;
        cVar.invokeSuspend(b5.a0.f883a);
        return null;
    }

    @Override // h5.a
    public final Object invokeSuspend(Object obj) {
        g5.a aVar = g5.a.f2984a;
        a.a.c0(obj);
        if (this.f6424a.f2595f.d(d.f6428a) == null) {
            return null;
        }
        throw new ClassCastException();
    }
}
