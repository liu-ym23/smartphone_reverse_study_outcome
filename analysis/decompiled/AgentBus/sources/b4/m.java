package b4;

import java.util.Objects;

/* loaded from: classes.dex */
public final class m extends q {

    /* renamed from: b, reason: collision with root package name */
    public final int f1518b;

    /* renamed from: c, reason: collision with root package name */
    public final int f1519c;

    /* renamed from: d, reason: collision with root package name */
    public final f f1520d;

    /* renamed from: e, reason: collision with root package name */
    public final f f1521e;

    public m(int i2, int i10, f fVar, f fVar2) {
        this.f1518b = i2;
        this.f1519c = i10;
        this.f1520d = fVar;
        this.f1521e = fVar2;
    }

    public final int b() {
        f fVar = f.f1505o;
        int i2 = this.f1519c;
        f fVar2 = this.f1520d;
        if (fVar2 == fVar) {
            return i2;
        }
        if (fVar2 != f.f1502l && fVar2 != f.f1503m && fVar2 != f.f1504n) {
            throw new IllegalStateException("Unknown variant");
        }
        return i2 + 5;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return mVar.f1518b == this.f1518b && mVar.b() == b() && mVar.f1520d == this.f1520d && mVar.f1521e == this.f1521e;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.f1518b), Integer.valueOf(this.f1519c), this.f1520d, this.f1521e);
    }

    public final String toString() {
        return "HMAC Parameters (variant: " + this.f1520d + ", hashType: " + this.f1521e + ", " + this.f1519c + "-byte tags, and " + this.f1518b + "-byte key)";
    }
}
