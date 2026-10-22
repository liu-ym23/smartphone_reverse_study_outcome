package b4;

import java.util.Objects;

/* loaded from: classes.dex */
public final class g extends q {

    /* renamed from: b, reason: collision with root package name */
    public final int f1508b;

    /* renamed from: c, reason: collision with root package name */
    public final int f1509c;

    /* renamed from: d, reason: collision with root package name */
    public final f f1510d;

    public g(int i2, int i10, f fVar) {
        this.f1508b = i2;
        this.f1509c = i10;
        this.f1510d = fVar;
    }

    public final int b() {
        f fVar = f.f1496f;
        int i2 = this.f1509c;
        f fVar2 = this.f1510d;
        if (fVar2 == fVar) {
            return i2;
        }
        if (fVar2 != f.f1493c && fVar2 != f.f1494d && fVar2 != f.f1495e) {
            throw new IllegalStateException("Unknown variant");
        }
        return i2 + 5;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return gVar.f1508b == this.f1508b && gVar.b() == b() && gVar.f1510d == this.f1510d;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.f1508b), Integer.valueOf(this.f1509c), this.f1510d);
    }

    public final String toString() {
        return "AES-CMAC Parameters (variant: " + this.f1510d + ", " + this.f1509c + "-byte tags, and " + this.f1508b + "-byte key)";
    }
}
