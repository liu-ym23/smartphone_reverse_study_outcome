package z1;

import java.util.Objects;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class j extends g2.n {

    /* renamed from: b, reason: collision with root package name */
    public final int f6390b;

    /* renamed from: c, reason: collision with root package name */
    public final int f6391c;
    public final int d;

    /* renamed from: e, reason: collision with root package name */
    public final f f6392e;

    public j(int i8, int i9, int i10, f fVar) {
        this.f6390b = i8;
        this.f6391c = i9;
        this.d = i10;
        this.f6392e = fVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return jVar.f6390b == this.f6390b && jVar.f6391c == this.f6391c && jVar.d == this.d && jVar.f6392e == this.f6392e;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.f6390b), Integer.valueOf(this.f6391c), Integer.valueOf(this.d), this.f6392e);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("AesGcm Parameters (variant: ");
        sb.append(this.f6392e);
        sb.append(", ");
        sb.append(this.f6391c);
        sb.append("-byte IV, ");
        sb.append(this.d);
        sb.append("-byte tag, and ");
        return m0.f.e(sb, this.f6390b, "-byte key)");
    }
}
