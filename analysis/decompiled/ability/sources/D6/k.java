package D6;

import com.stepos.motionkit.fx.material.GlassEffect;

/* loaded from: classes3.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public final int f387a;
    public final int b;
    public final float c;
    public final boolean d;
    public final GlassEffect e;
    public final a f;

    public k(int i, int i6, float f, boolean z10, GlassEffect effect, a aVar) {
        kotlin.jvm.internal.k.f(effect, "effect");
        this.f387a = i;
        this.b = i6;
        this.c = f;
        this.d = z10;
        this.e = effect;
        this.f = aVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return this.f387a == kVar.f387a && this.b == kVar.b && Float.compare(this.c, kVar.c) == 0 && this.d == kVar.d && kotlin.jvm.internal.k.b(this.e, kVar.e) && kotlin.jvm.internal.k.b(this.f, kVar.f);
    }

    public final int hashCode() {
        int iHashCode = (this.e.hashCode() + androidx.appfunctions.metadata.a.d(androidx.appfunctions.metadata.a.b(this.c, androidx.constraintlayout.core.dsl.a.a(this.b, Integer.hashCode(this.f387a) * 31, 31), 31), 31, this.d)) * 31;
        a aVar = this.f;
        return iHashCode + (aVar == null ? 0 : aVar.hashCode());
    }

    public final String toString() {
        StringBuilder sbS = androidx.appfunctions.metadata.a.s(this.f387a, "GlassRequest(width=", this.b, ", height=", ", radius=");
        sbS.append(this.c);
        sbS.append(", crossWindow=");
        sbS.append(this.d);
        sbS.append(", effect=");
        sbS.append(this.e);
        sbS.append(", customizer=");
        sbS.append(this.f);
        sbS.append(")");
        return sbS.toString();
    }
}
