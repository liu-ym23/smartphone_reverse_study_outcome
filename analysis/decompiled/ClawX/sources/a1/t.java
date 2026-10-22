package a1;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class t extends p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f69a = 1;

    /* renamed from: b, reason: collision with root package name */
    public o f70b;

    public /* synthetic */ t() {
    }

    @Override // a1.p, a1.m
    public void e(o oVar) {
        switch (this.f69a) {
            case 1:
                a aVar = (a) this.f70b;
                if (!aVar.E) {
                    aVar.G();
                    aVar.E = true;
                    break;
                }
                break;
        }
    }

    @Override // a1.m
    public final void f(o oVar) {
        switch (this.f69a) {
            case 0:
                this.f70b.z();
                oVar.x(this);
                break;
            default:
                a aVar = (a) this.f70b;
                int i8 = aVar.D - 1;
                aVar.D = i8;
                if (i8 == 0) {
                    aVar.E = false;
                    aVar.m();
                }
                oVar.x(this);
                break;
        }
    }

    public t(o oVar) {
        this.f70b = oVar;
    }
}
