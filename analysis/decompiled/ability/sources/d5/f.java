package d5;

import java.util.Arrays;

/* loaded from: classes3.dex */
public final class f extends l {

    /* renamed from: a, reason: collision with root package name */
    public final float[] f4296a;

    public f(float[] fArr) {
        this.f4296a = fArr;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof f) {
            return Arrays.equals(this.f4296a, ((f) obj).f4296a);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f4296a);
    }

    public final String toString() {
        return B7.a.m("FloatArrayValue(value=", Arrays.toString(this.f4296a), ")");
    }
}
