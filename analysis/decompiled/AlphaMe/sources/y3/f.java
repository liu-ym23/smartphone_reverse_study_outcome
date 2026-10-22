package y3;

/* loaded from: classes2.dex */
public final class f implements x3.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f16358a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ t3.h f16359b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f16360c;

    public /* synthetic */ f(t3.h hVar, Object obj, int i4) {
        this.f16358a = i4;
        this.f16359b = hVar;
        this.f16360c = obj;
    }

    @Override // x3.a
    public final void b() {
        int i4 = this.f16358a;
        Object obj = this.f16360c;
        t3.h hVar = this.f16359b;
        switch (i4) {
            case 0:
                g gVar = (g) hVar;
                if (!gVar.f16361e) {
                    gVar.f16361e = true;
                    gVar.f16363g.f((Throwable) obj);
                    gVar.f16362f.c();
                    break;
                }
                break;
            case 1:
                g gVar2 = (g) hVar;
                if (!gVar2.f16361e) {
                    gVar2.f16363g.g(obj);
                    break;
                }
                break;
            case 2:
                if (!((A3.b) hVar).a()) {
                    ((x3.a) obj).b();
                    break;
                }
                break;
            default:
                ((A3.j) hVar).f101b.d((G3.d) obj);
                break;
        }
    }
}
