package ad;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a0 extends c0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f430a;

    /* renamed from: b, reason: collision with root package name */
    public s f431b;

    /* renamed from: c, reason: collision with root package name */
    public Object f432c;

    public /* synthetic */ a0(int i) {
        this.f430a = i;
    }

    @Override // ad.c0
    public final long a() {
        switch (this.f430a) {
            case 0:
                return ((od.l) this.f432c).c();
            default:
                return ((c0) this.f432c).a();
        }
    }

    @Override // ad.c0
    public final s b() {
        switch (this.f430a) {
        }
        return this.f431b;
    }

    @Override // ad.c0
    public final void c(od.j jVar) {
        switch (this.f430a) {
            case 0:
                jVar.t((od.l) this.f432c);
                break;
            default:
                ((c0) this.f432c).c(jVar);
                break;
        }
    }
}
