package L0;

import android.graphics.Path;
import com.airbnb.lottie.v;

/* loaded from: classes.dex */
public final class l implements b {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f1193a;

    /* renamed from: b, reason: collision with root package name */
    public final Path.FillType f1194b;

    /* renamed from: c, reason: collision with root package name */
    public final String f1195c;

    /* renamed from: d, reason: collision with root package name */
    public final K0.a f1196d;

    /* renamed from: e, reason: collision with root package name */
    public final K0.a f1197e;

    public l(String str, boolean z4, Path.FillType fillType, K0.a aVar, K0.a aVar2) {
        this.f1195c = str;
        this.f1193a = z4;
        this.f1194b = fillType;
        this.f1196d = aVar;
        this.f1197e = aVar2;
    }

    @Override // L0.b
    public final G0.c a(v vVar, M0.b bVar) {
        return new G0.g(vVar, bVar, this);
    }

    public final String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.f1193a + '}';
    }
}
