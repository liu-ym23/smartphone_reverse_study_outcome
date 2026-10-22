package f;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f2421a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ k f2422b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ j f2423c;
    public final /* synthetic */ androidx.emoji2.text.m d;

    public e(androidx.emoji2.text.m mVar, f fVar, k kVar, j jVar) {
        this.d = mVar;
        this.f2421a = fVar;
        this.f2422b = kVar;
        this.f2423c = jVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        g gVar = (g) this.d.f621a;
        f fVar = this.f2421a;
        if (fVar != null) {
            gVar.A = true;
            fVar.f2425b.c(false);
            gVar.A = false;
        }
        k kVar = this.f2422b;
        if (kVar.isEnabled() && kVar.hasSubMenu()) {
            this.f2423c.p(kVar, null, 4);
        }
    }
}
