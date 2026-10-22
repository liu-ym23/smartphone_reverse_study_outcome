package n3;

import android.graphics.Point;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    public int f8750a;

    /* renamed from: b, reason: collision with root package name */
    public int f8751b;

    /* renamed from: c, reason: collision with root package name */
    public Point f8752c;

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof t) {
            t tVar = (t) obj;
            if (this.f8750a == tVar.f8750a && this.f8751b == tVar.f8751b && this.f8752c.equals(tVar.f8752c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f8752c.hashCode() + (((this.f8750a * 31) + this.f8751b) * 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("RoundedCornerCompat{position=");
        int i = this.f8750a;
        sb2.append(i != 0 ? i != 1 ? i != 2 ? i != 3 ? "Invalid" : "BottomLeft" : "BottomRight" : "TopRight" : "TopLeft");
        sb2.append(", radius=");
        sb2.append(this.f8751b);
        sb2.append(", center=");
        sb2.append(this.f8752c);
        sb2.append('}');
        return sb2.toString();
    }
}
