package b0;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1244a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1245b;

    public /* synthetic */ n(int i2, Object obj) {
        this.f1244a = i2;
        this.f1245b = obj;
    }

    public final void a() {
        switch (this.f1244a) {
            case 0:
                p pVar = (p) this.f1245b;
                pVar.f1296z--;
                break;
            default:
                l0.s sVar = (l0.s) this.f1245b;
                sVar.f5796j--;
                break;
        }
    }

    public final void b() {
        switch (this.f1244a) {
            case 0:
                ((p) this.f1245b).f1296z++;
                break;
            default:
                ((l0.s) this.f1245b).f5796j++;
                break;
        }
    }
}
