package d4;

import java.util.Objects;
import t3.f;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final f f2838a;

    /* renamed from: b, reason: collision with root package name */
    public final int f2839b;

    /* renamed from: c, reason: collision with root package name */
    public final String f2840c;

    /* renamed from: d, reason: collision with root package name */
    public final String f2841d;

    public b(f fVar, int i2, String str, String str2) {
        this.f2838a = fVar;
        this.f2839b = i2;
        this.f2840c = str;
        this.f2841d = str2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f2838a == bVar.f2838a && this.f2839b == bVar.f2839b && this.f2840c.equals(bVar.f2840c) && this.f2841d.equals(bVar.f2841d);
    }

    public final int hashCode() {
        return Objects.hash(this.f2838a, Integer.valueOf(this.f2839b), this.f2840c, this.f2841d);
    }

    public final String toString() {
        return "(status=" + this.f2838a + ", keyId=" + this.f2839b + ", keyType='" + this.f2840c + "', keyPrefix='" + this.f2841d + "')";
    }
}
