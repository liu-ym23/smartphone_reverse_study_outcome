package x6;

import com.stepos.motionkit.fx.material.GlassEffect;
import kotlin.jvm.internal.k;

/* renamed from: x6.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2116a {

    /* renamed from: a, reason: collision with root package name */
    public final int f6882a;
    public final int b;
    public final float c;
    public final GlassEffect d;

    public C2116a(int i, int i6, float f, GlassEffect effect) {
        k.f(effect, "effect");
        this.f6882a = i;
        this.b = i6;
        this.c = f;
        this.d = effect;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2116a)) {
            return false;
        }
        C2116a c2116a = (C2116a) obj;
        return this.f6882a == c2116a.f6882a && this.b == c2116a.b && Float.compare(this.c, c2116a.c) == 0 && k.b(this.d, c2116a.d);
    }

    public final int hashCode() {
        return (this.d.hashCode() + androidx.appfunctions.metadata.a.b(this.c, androidx.constraintlayout.core.dsl.a.a(this.b, Integer.hashCode(this.f6882a) * 31, 31), 31)) * 31;
    }

    public final String toString() {
        StringBuilder sbS = androidx.appfunctions.metadata.a.s(this.f6882a, "GlassRequest(width=", this.b, ", height=", ", radius=");
        sbS.append(this.c);
        sbS.append(", effect=");
        sbS.append(this.d);
        sbS.append(", customizer=null)");
        return sbS.toString();
    }
}
