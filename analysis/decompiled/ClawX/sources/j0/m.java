package j0;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class m extends h5.i implements p5.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3391a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f3392b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ m(int i8, f5.c cVar, int i9) {
        super(i8, cVar);
        this.f3391a = i9;
    }

    @Override // h5.a
    public final f5.c create(Object obj, f5.c cVar) {
        switch (this.f3391a) {
            case 0:
                m mVar = new m(2, cVar, 0);
                mVar.f3392b = obj;
                return mVar;
            case 1:
                m mVar2 = new m(2, cVar, 1);
                mVar2.f3392b = obj;
                return mVar2;
            default:
                m mVar3 = new m(2, cVar, 2);
                mVar3.f3392b = obj;
                return mVar3;
        }
    }

    @Override // p5.p
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f3391a) {
            case 0:
                return ((m) create((v0) obj, (f5.c) obj2)).invokeSuspend(b5.a0.f883a);
            case 1:
                return ((m) create((n4.e) obj, (f5.c) obj2)).invokeSuspend(b5.a0.f883a);
            default:
                ((m) create((h4.c) obj, (f5.c) obj2)).invokeSuspend(b5.a0.f883a);
                return null;
        }
    }

    @Override // h5.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f3391a) {
            case 0:
                g5.a aVar = g5.a.f2984a;
                a.a.c0(obj);
                return Boolean.valueOf(!(((v0) this.f3392b) instanceof m0));
            case 1:
                g5.a aVar2 = g5.a.f2984a;
                a.a.c0(obj);
                return Boolean.valueOf(((n4.e) this.f3392b) != null);
            default:
                g5.a aVar3 = g5.a.f2984a;
                a.a.c0(obj);
                if (((h4.c) this.f3392b).c().d().getAttributes().d(z3.d.f6429b) == null) {
                    return null;
                }
                throw new ClassCastException();
        }
    }
}
