package w0;

import m.x;

/* loaded from: classes.dex */
public final class g extends c {

    /* renamed from: b, reason: collision with root package name */
    public final float f10636b;

    /* renamed from: c, reason: collision with root package name */
    public final int f10637c;

    public g(float f10, int i2, int i10) {
        i2 = (i10 & 4) != 0 ? 0 : i2;
        this.f10636b = f10;
        this.f10637c = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return this.f10636b == gVar.f10636b && this.f10637c == gVar.f10637c;
    }

    public final int hashCode() {
        return n.f.b(0, n.f.b(this.f10637c, x.d(4.0f, Float.hashCode(this.f10636b) * 31, 31), 31), 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("Stroke(width=");
        sb2.append(this.f10636b);
        sb2.append(", miter=4.0, cap=");
        int i2 = this.f10637c;
        sb2.append((Object) (i2 == 0 ? "Butt" : i2 == 1 ? "Round" : i2 == 2 ? "Square" : "Unknown"));
        sb2.append(", join=");
        sb2.append((Object) "Miter");
        sb2.append(", pathEffect=null)");
        return sb2.toString();
    }
}
