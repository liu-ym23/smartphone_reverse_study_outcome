package p2;

import g5.f;
import java.util.Arrays;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c implements a {

    /* renamed from: a, reason: collision with root package name */
    public final float[] f9695a;

    /* renamed from: b, reason: collision with root package name */
    public final float[] f9696b;

    public c(float[] fArr, float[] fArr2) {
        if (fArr.length != fArr2.length || fArr.length == 0) {
            f.s("Array lengths must match and be nonzero");
            throw null;
        }
        this.f9695a = fArr;
        this.f9696b = fArr2;
    }

    @Override // p2.a
    public final float a(float f5) {
        return f8.b.h(f5, this.f9696b, this.f9695a);
    }

    @Override // p2.a
    public final float b(float f5) {
        return f8.b.h(f5, this.f9695a, this.f9696b);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return Arrays.equals(this.f9695a, cVar.f9695a) && Arrays.equals(this.f9696b, cVar.f9696b);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f9696b) + (Arrays.hashCode(this.f9695a) * 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("FontScaleConverter{fromSpValues=");
        String string = Arrays.toString(this.f9695a);
        string.getClass();
        sb2.append(string);
        sb2.append(", toDpValues=");
        String string2 = Arrays.toString(this.f9696b);
        string2.getClass();
        sb2.append(string2);
        sb2.append('}');
        return sb2.toString();
    }
}
