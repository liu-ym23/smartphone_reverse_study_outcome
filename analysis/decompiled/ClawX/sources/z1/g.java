package z1;

import java.util.Objects;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class g extends g2.n {

    /* renamed from: b, reason: collision with root package name */
    public final int f6384b;

    /* renamed from: c, reason: collision with root package name */
    public final int f6385c;
    public final int d;

    /* renamed from: e, reason: collision with root package name */
    public final f f6386e;

    public g(int i8, int i9, int i10, f fVar) {
        this.f6384b = i8;
        this.f6385c = i9;
        this.d = i10;
        this.f6386e = fVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return gVar.f6384b == this.f6384b && gVar.f6385c == this.f6385c && gVar.d == this.d && gVar.f6386e == this.f6386e;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.f6384b), Integer.valueOf(this.f6385c), Integer.valueOf(this.d), this.f6386e);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("AesEax Parameters (variant: ");
        sb.append(this.f6386e);
        sb.append(", ");
        sb.append(this.f6385c);
        sb.append("-byte IV, ");
        sb.append(this.d);
        sb.append("-byte tag, and ");
        return m0.f.e(sb, this.f6384b, "-byte key)");
    }
}
