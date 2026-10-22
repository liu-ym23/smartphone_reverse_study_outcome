package k0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7022a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f7023b;

    public /* synthetic */ q(int i) {
        this.f7022a = i;
    }

    public final void a() {
        switch (this.f7022a) {
            case 0:
                s sVar = (s) this.f7023b;
                sVar.A--;
                break;
            default:
                u0.s sVar2 = (u0.s) this.f7023b;
                sVar2.f13697j--;
                break;
        }
    }

    public final void b() {
        switch (this.f7022a) {
            case 0:
                ((s) this.f7023b).A++;
                break;
            default:
                ((u0.s) this.f7023b).f13697j++;
                break;
        }
    }
}
