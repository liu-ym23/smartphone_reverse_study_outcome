package y6;

import com.stepos.motionkit.fx.material.GlassEffect;
import kotlin.jvm.internal.k;

/* renamed from: y6.c, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2135c {

    /* renamed from: a, reason: collision with root package name */
    public final int f6908a;
    public final int b;
    public final float c;
    public final boolean d;
    public final GlassEffect e;
    public final D6.a f;

    public C2135c(int i, int i6, float f, boolean z10, GlassEffect effect, D6.a aVar) {
        k.f(effect, "effect");
        this.f6908a = i;
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
        if (!(obj instanceof C2135c)) {
            return false;
        }
        C2135c c2135c = (C2135c) obj;
        return this.f6908a == c2135c.f6908a && this.b == c2135c.b && Float.compare(this.c, c2135c.c) == 0 && this.d == c2135c.d && k.b(this.e, c2135c.e) && k.b(this.f, c2135c.f);
    }

    public final int hashCode() {
        int iHashCode = (this.e.hashCode() + androidx.appfunctions.metadata.a.d(androidx.appfunctions.metadata.a.b(this.c, androidx.constraintlayout.core.dsl.a.a(this.b, Integer.hashCode(this.f6908a) * 31, 31), 31), 31, this.d)) * 31;
        D6.a aVar = this.f;
        return iHashCode + (aVar == null ? 0 : aVar.hashCode());
    }

    public final String toString() {
        StringBuilder sbS = androidx.appfunctions.metadata.a.s(this.f6908a, "GlassRequest(width=", this.b, ", height=", ", radius=");
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
