package L0;

import G0.q;
import com.airbnb.lottie.v;

/* loaded from: classes.dex */
public final class n implements b {

    /* renamed from: a, reason: collision with root package name */
    public final String f1200a;

    /* renamed from: b, reason: collision with root package name */
    public final int f1201b;

    /* renamed from: c, reason: collision with root package name */
    public final K0.a f1202c;

    public n(String str, int i4, K0.a aVar) {
        this.f1200a = str;
        this.f1201b = i4;
        this.f1202c = aVar;
    }

    @Override // L0.b
    public final G0.c a(v vVar, M0.b bVar) {
        return new q(vVar, bVar, this);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ShapePath{name=");
        sb.append(this.f1200a);
        sb.append(", index=");
        return B0.g.o(sb, this.f1201b, '}');
    }
}
