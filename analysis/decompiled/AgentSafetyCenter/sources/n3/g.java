package n3;

import java.util.Objects;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public String f8714a;

    /* renamed from: b, reason: collision with root package name */
    public int f8715b;

    /* renamed from: c, reason: collision with root package name */
    public int f8716c;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return this.f8714a.equals(gVar.f8714a) && this.f8715b == gVar.f8715b && this.f8716c == gVar.f8716c;
    }

    public final int hashCode() {
        String str = this.f8714a;
        Integer numValueOf = Integer.valueOf(this.f8715b);
        Integer numValueOf2 = Integer.valueOf(this.f8716c);
        Float fValueOf = Float.valueOf(1.0f);
        return Objects.hash(str, numValueOf, numValueOf2, fValueOf, 0, 0, 0, fValueOf);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("DisplayShapeCompat{ spec=");
        sb2.append(Integer.valueOf(this.f8714a.hashCode()));
        sb2.append(" displayWidth=");
        sb2.append(this.f8715b);
        sb2.append(" displayHeight=");
        return k0.a.r(sb2, this.f8716c, " physicalPixelDisplaySizeRatio=1.0 rotation=0 offsetX=0 offsetY=0 scale=1.0}");
    }
}
