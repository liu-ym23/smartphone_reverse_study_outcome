package g2;

import java.util.Objects;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class d extends n {

    /* renamed from: b, reason: collision with root package name */
    public final int f2930b;

    /* renamed from: c, reason: collision with root package name */
    public final int f2931c;
    public final c d;

    public d(int i8, int i9, c cVar) {
        this.f2930b = i8;
        this.f2931c = i9;
        this.d = cVar;
    }

    public final int b() {
        c cVar = c.f2918f;
        int i8 = this.f2931c;
        c cVar2 = this.d;
        if (cVar2 == cVar) {
            return i8;
        }
        if (cVar2 == c.f2916c) {
            return i8 + 5;
        }
        if (cVar2 == c.d) {
            return i8 + 5;
        }
        if (cVar2 == c.f2917e) {
            return i8 + 5;
        }
        throw new IllegalStateException("Unknown variant");
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return dVar.f2930b == this.f2930b && dVar.b() == b() && dVar.d == this.d;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.f2930b), Integer.valueOf(this.f2931c), this.d);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("AES-CMAC Parameters (variant: ");
        sb.append(this.d);
        sb.append(", ");
        sb.append(this.f2931c);
        sb.append("-byte tags, and ");
        return m0.f.e(sb, this.f2930b, "-byte key)");
    }
}
