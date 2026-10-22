package L0;

import com.airbnb.lottie.v;

/* loaded from: classes.dex */
public final class j implements b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1185a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final String f1186b;

    /* renamed from: c, reason: collision with root package name */
    public final K0.b f1187c;

    /* renamed from: d, reason: collision with root package name */
    public final K0.d f1188d;

    /* renamed from: e, reason: collision with root package name */
    public final Object f1189e;

    public j(String str, K0.b bVar, K0.b bVar2, K0.c cVar) {
        this.f1186b = str;
        this.f1187c = bVar;
        this.f1188d = bVar2;
        this.f1189e = cVar;
    }

    @Override // L0.b
    public final G0.c a(v vVar, M0.b bVar) {
        switch (this.f1185a) {
            case 0:
                return new G0.o(vVar, bVar, this);
            default:
                return new G0.p(vVar, bVar, this);
        }
    }

    public final String toString() {
        switch (this.f1185a) {
            case 0:
                return "RectangleShape{position=" + this.f1188d + ", size=" + ((K0.a) this.f1189e) + '}';
            default:
                return super.toString();
        }
    }

    public j(String str, K0.d dVar, K0.a aVar, K0.b bVar) {
        this.f1186b = str;
        this.f1188d = dVar;
        this.f1189e = aVar;
        this.f1187c = bVar;
    }
}
