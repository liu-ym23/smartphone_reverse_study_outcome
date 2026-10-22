package y2;

import com.stepos.alphame.utils.Property;
import java.io.Serializable;

/* loaded from: classes.dex */
public final class g implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public float f16346a;

    /* renamed from: b, reason: collision with root package name */
    public float f16347b;

    /* renamed from: c, reason: collision with root package name */
    public float f16348c;

    static {
        new g(1.0f, Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE);
        new g(Property.DEFAULT_FLOAT_VALUE, 1.0f, Property.DEFAULT_FLOAT_VALUE);
        new g(Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE, 1.0f);
        new g(Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE);
        new c();
    }

    public g(float f4, float f5, float f6) {
        c(f4, f5, f6);
    }

    public final void a(g gVar) {
        float f4 = this.f16347b;
        float f5 = gVar.f16348c;
        float f6 = this.f16348c;
        float f7 = gVar.f16347b;
        float f8 = gVar.f16346a;
        float f9 = this.f16346a;
        c((f4 * f5) - (f6 * f7), (f6 * f8) - (f5 * f9), (f9 * f7) - (f4 * f8));
    }

    public final void b() {
        float f4 = this.f16346a;
        float f5 = this.f16347b;
        float f6 = (f5 * f5) + (f4 * f4);
        float f7 = this.f16348c;
        float f8 = (f7 * f7) + f6;
        int i4 = b.f16331a;
        if (Math.abs(f8) > 1.0E-6f && Math.abs(f8 - 1.0f) > 1.0E-6f) {
            float fSqrt = 1.0f / ((float) Math.sqrt(f8));
            c(this.f16346a * fSqrt, this.f16347b * fSqrt, this.f16348c * fSqrt);
        }
    }

    public final void c(float f4, float f5, float f6) {
        this.f16346a = f4;
        this.f16347b = f5;
        this.f16348c = f6;
    }

    public final void d(g gVar) {
        c(gVar.f16346a, gVar.f16347b, gVar.f16348c);
    }

    public final void e(g gVar) {
        c(this.f16346a - gVar.f16346a, this.f16347b - gVar.f16347b, this.f16348c - gVar.f16348c);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || g.class != obj.getClass()) {
            return false;
        }
        g gVar = (g) obj;
        return Float.floatToIntBits(this.f16346a) == Float.floatToIntBits(gVar.f16346a) && Float.floatToIntBits(this.f16347b) == Float.floatToIntBits(gVar.f16347b) && Float.floatToIntBits(this.f16348c) == Float.floatToIntBits(gVar.f16348c);
    }

    public final int hashCode() {
        return Float.floatToIntBits(this.f16348c) + ((Float.floatToIntBits(this.f16347b) + ((Float.floatToIntBits(this.f16346a) + 31) * 31)) * 31);
    }

    public final String toString() {
        return "(" + this.f16346a + "," + this.f16347b + "," + this.f16348c + ")";
    }
}
