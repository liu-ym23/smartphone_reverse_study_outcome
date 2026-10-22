package a6;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final /* synthetic */ class l implements p5.q {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f187a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f188b;

    public /* synthetic */ l(int i8, Object obj) {
        this.f187a = i8;
        this.f188b = obj;
    }

    @Override // p5.q
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        int i8 = this.f187a;
        Object obj4 = this.f188b;
        switch (i8) {
            case 0:
                ((c5.a) obj4).invoke((Throwable) obj);
                break;
            case 1:
                break;
            case 2:
                i6.c cVar = (i6.c) obj4;
                i6.c.f3154h.set(cVar, null);
                cVar.e(null);
                break;
            default:
                ((i6.h) obj4).b();
                break;
        }
        return b5.a0.f883a;
    }

    public /* synthetic */ l(i6.c cVar, i6.b bVar) {
        this.f187a = 2;
        this.f188b = cVar;
    }
}
