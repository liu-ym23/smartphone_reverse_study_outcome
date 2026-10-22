package u3;

import java.util.Objects;

/* loaded from: classes.dex */
public final class j extends b4.q {

    /* renamed from: b, reason: collision with root package name */
    public final int f10032b;

    /* renamed from: c, reason: collision with root package name */
    public final int f10033c;

    /* renamed from: d, reason: collision with root package name */
    public final int f10034d;

    /* renamed from: e, reason: collision with root package name */
    public final f f10035e;

    public j(int i2, int i10, int i11, f fVar) {
        this.f10032b = i2;
        this.f10033c = i10;
        this.f10034d = i11;
        this.f10035e = fVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return jVar.f10032b == this.f10032b && jVar.f10033c == this.f10033c && jVar.f10034d == this.f10034d && jVar.f10035e == this.f10035e;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.f10032b), Integer.valueOf(this.f10033c), Integer.valueOf(this.f10034d), this.f10035e);
    }

    public final String toString() {
        return "AesGcm Parameters (variant: " + this.f10035e + ", " + this.f10033c + "-byte IV, " + this.f10034d + "-byte tag, and " + this.f10032b + "-byte key)";
    }
}
