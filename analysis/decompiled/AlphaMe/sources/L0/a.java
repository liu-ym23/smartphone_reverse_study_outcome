package L0;

import com.airbnb.lottie.v;

/* loaded from: classes.dex */
public final class a implements b {

    /* renamed from: a, reason: collision with root package name */
    public final String f1147a;

    /* renamed from: b, reason: collision with root package name */
    public final K0.d f1148b;

    /* renamed from: c, reason: collision with root package name */
    public final K0.a f1149c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f1150d;

    public a(String str, K0.d dVar, K0.a aVar, boolean z4) {
        this.f1147a = str;
        this.f1148b = dVar;
        this.f1149c = aVar;
        this.f1150d = z4;
    }

    @Override // L0.b
    public final G0.c a(v vVar, M0.b bVar) {
        return new G0.f(vVar, bVar, this);
    }
}
