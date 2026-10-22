package u;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b0 extends pb.i implements xb.q {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f13426c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b0(int i, nb.c cVar, int i3) {
        super(i, cVar);
        this.f13426c = i3;
    }

    @Override // xb.q
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        switch (this.f13426c) {
            case 0:
                long j10 = ((c1.b) obj2).f2165a;
                b0 b0Var = new b0(3, (nb.c) obj3, 0);
                jb.v vVar = jb.v.f6774a;
                b0Var.invokeSuspend(vVar);
                return vVar;
            case 1:
                ((Number) obj2).floatValue();
                b0 b0Var2 = new b0(3, (nb.c) obj3, 1);
                jb.v vVar2 = jb.v.f6774a;
                b0Var2.invokeSuspend(vVar2);
                return vVar2;
            default:
                long j11 = ((c1.b) obj2).f2165a;
                b0 b0Var3 = new b0(3, (nb.c) obj3, 2);
                jb.v vVar3 = jb.v.f6774a;
                b0Var3.invokeSuspend(vVar3);
                return vVar3;
        }
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        int i = this.f13426c;
        jb.v vVar = jb.v.f6774a;
        switch (i) {
            case 0:
                ob.a aVar = ob.a.f9351c;
                id.c.I(obj);
                break;
            case 1:
                ob.a aVar2 = ob.a.f9351c;
                id.c.I(obj);
                break;
            default:
                ob.a aVar3 = ob.a.f9351c;
                id.c.I(obj);
                break;
        }
        return vVar;
    }
}
