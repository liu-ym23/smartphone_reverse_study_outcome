package M0;

/* loaded from: classes.dex */
public final class a implements H0.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ H0.c f1360a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f1361b;

    public a(b bVar, H0.c cVar) {
        this.f1361b = bVar;
        this.f1360a = cVar;
    }

    @Override // H0.a
    public final void a() {
        boolean z4 = ((Float) this.f1360a.e()).floatValue() == 1.0f;
        b bVar = this.f1361b;
        if (z4 != bVar.f1382u) {
            bVar.f1382u = z4;
            bVar.f1374m.invalidateSelf();
        }
    }
}
