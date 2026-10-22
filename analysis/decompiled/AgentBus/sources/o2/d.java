package o2;

import java.util.Objects;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final String f7225a;

    /* renamed from: b, reason: collision with root package name */
    public final int f7226b;

    /* renamed from: c, reason: collision with root package name */
    public final int f7227c;

    public d(String str, int i2, int i10) {
        this.f7225a = str;
        this.f7226b = i2;
        this.f7227c = i10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return Objects.equals(this.f7225a, dVar.f7225a) && this.f7226b == dVar.f7226b && this.f7227c == dVar.f7227c;
    }

    public final int hashCode() {
        Integer numValueOf = Integer.valueOf(this.f7226b);
        Integer numValueOf2 = Integer.valueOf(this.f7227c);
        Float fValueOf = Float.valueOf(1.0f);
        return Objects.hash(this.f7225a, numValueOf, numValueOf2, fValueOf, 0, 0, 0, fValueOf);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("DisplayShapeCompat{ spec=");
        String str = this.f7225a;
        sb2.append(str != null ? Integer.valueOf(str.hashCode()) : "null");
        sb2.append(" displayWidth=");
        sb2.append(this.f7226b);
        sb2.append(" displayHeight=");
        sb2.append(this.f7227c);
        sb2.append(" physicalPixelDisplaySizeRatio=1.0 rotation=0 offsetX=0 offsetY=0 scale=1.0}");
        return sb2.toString();
    }
}
