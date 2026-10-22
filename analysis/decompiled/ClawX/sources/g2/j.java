package g2;

import java.util.Objects;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class j extends n {

    /* renamed from: b, reason: collision with root package name */
    public final int f2938b;

    /* renamed from: c, reason: collision with root package name */
    public final int f2939c;
    public final c d;

    /* renamed from: e, reason: collision with root package name */
    public final c f2940e;

    public j(int i8, int i9, c cVar, c cVar2) {
        this.f2938b = i8;
        this.f2939c = i9;
        this.d = cVar;
        this.f2940e = cVar2;
    }

    public final int b() {
        c cVar = c.f2927o;
        int i8 = this.f2939c;
        c cVar2 = this.d;
        if (cVar2 == cVar) {
            return i8;
        }
        if (cVar2 == c.f2924l) {
            return i8 + 5;
        }
        if (cVar2 == c.f2925m) {
            return i8 + 5;
        }
        if (cVar2 == c.f2926n) {
            return i8 + 5;
        }
        throw new IllegalStateException("Unknown variant");
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return jVar.f2938b == this.f2938b && jVar.b() == b() && jVar.d == this.d && jVar.f2940e == this.f2940e;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.f2938b), Integer.valueOf(this.f2939c), this.d, this.f2940e);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("HMAC Parameters (variant: ");
        sb.append(this.d);
        sb.append(", hashType: ");
        sb.append(this.f2940e);
        sb.append(", ");
        sb.append(this.f2939c);
        sb.append("-byte tags, and ");
        return m0.f.e(sb, this.f2938b, "-byte key)");
    }
}
