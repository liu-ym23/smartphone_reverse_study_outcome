package e2;

import java.util.Arrays;
import q7.k;
import s9.d;

/* loaded from: classes.dex */
public final class c implements a {

    /* renamed from: a, reason: collision with root package name */
    public final float[] f3049a;

    /* renamed from: b, reason: collision with root package name */
    public final float[] f3050b;

    public c(float[] fArr, float[] fArr2) {
        if (fArr.length != fArr2.length || fArr.length == 0) {
            throw new IllegalArgumentException("Array lengths must match and be nonzero");
        }
        this.f3049a = fArr;
        this.f3050b = fArr2;
    }

    @Override // e2.a
    public final float a(float f10) {
        return d.i(f10, this.f3050b, this.f3049a);
    }

    @Override // e2.a
    public final float b(float f10) {
        return d.i(f10, this.f3049a, this.f3050b);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return Arrays.equals(this.f3049a, cVar.f3049a) && Arrays.equals(this.f3050b, cVar.f3050b);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f3050b) + (Arrays.hashCode(this.f3049a) * 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("FontScaleConverter{fromSpValues=");
        String string = Arrays.toString(this.f3049a);
        k.d(string, "toString(...)");
        sb2.append(string);
        sb2.append(", toDpValues=");
        String string2 = Arrays.toString(this.f3050b);
        k.d(string2, "toString(...)");
        sb2.append(string2);
        sb2.append('}');
        return sb2.toString();
    }
}
