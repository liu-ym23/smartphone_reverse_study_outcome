package o2;

import android.graphics.Point;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final int f7230a;

    /* renamed from: b, reason: collision with root package name */
    public final int f7231b;

    /* renamed from: c, reason: collision with root package name */
    public final Point f7232c;

    public g(int i2, int i10, Point point) {
        int i11 = point.x;
        int i12 = point.y;
        this.f7230a = i2;
        this.f7231b = i10;
        this.f7232c = new Point(i11, i12);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            if (this.f7230a == gVar.f7230a && this.f7231b == gVar.f7231b && this.f7232c.equals(gVar.f7232c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f7232c.hashCode() + (((this.f7230a * 31) + this.f7231b) * 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("RoundedCornerCompat{position=");
        int i2 = this.f7230a;
        sb2.append(i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? "Invalid" : "BottomLeft" : "BottomRight" : "TopRight" : "TopLeft");
        sb2.append(", radius=");
        sb2.append(this.f7231b);
        sb2.append(", center=");
        sb2.append(this.f7232c);
        sb2.append('}');
        return sb2.toString();
    }
}
