package e0;

import android.graphics.Point;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public final int f2320a;

    /* renamed from: b, reason: collision with root package name */
    public final int f2321b;

    /* renamed from: c, reason: collision with root package name */
    public final Point f2322c;

    public l(int i8, int i9, Point point) {
        int i10 = point.x;
        int i11 = point.y;
        this.f2320a = i8;
        this.f2321b = i9;
        this.f2322c = new Point(i10, i11);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof l) {
            l lVar = (l) obj;
            if (this.f2320a == lVar.f2320a && this.f2321b == lVar.f2321b && this.f2322c.equals(lVar.f2322c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f2322c.hashCode() + (((this.f2320a * 31) + this.f2321b) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("RoundedCornerCompat{position=");
        int i8 = this.f2320a;
        sb.append(i8 != 0 ? i8 != 1 ? i8 != 2 ? i8 != 3 ? "Invalid" : "BottomLeft" : "BottomRight" : "TopRight" : "TopLeft");
        sb.append(", radius=");
        sb.append(this.f2321b);
        sb.append(", center=");
        sb.append(this.f2322c);
        sb.append(AbstractJsonLexerKt.END_OBJ);
        return sb.toString();
    }
}
