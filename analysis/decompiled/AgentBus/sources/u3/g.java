package u3;

import java.util.Objects;

/* loaded from: classes.dex */
public final class g extends b4.q {

    /* renamed from: b, reason: collision with root package name */
    public final int f10024b;

    /* renamed from: c, reason: collision with root package name */
    public final int f10025c;

    /* renamed from: d, reason: collision with root package name */
    public final int f10026d;

    /* renamed from: e, reason: collision with root package name */
    public final f f10027e;

    public g(int i2, int i10, int i11, f fVar) {
        this.f10024b = i2;
        this.f10025c = i10;
        this.f10026d = i11;
        this.f10027e = fVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return gVar.f10024b == this.f10024b && gVar.f10025c == this.f10025c && gVar.f10026d == this.f10026d && gVar.f10027e == this.f10027e;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.f10024b), Integer.valueOf(this.f10025c), Integer.valueOf(this.f10026d), this.f10027e);
    }

    public final String toString() {
        return "AesEax Parameters (variant: " + this.f10027e + ", " + this.f10025c + "-byte IV, " + this.f10026d + "-byte tag, and " + this.f10024b + "-byte key)";
    }
}
