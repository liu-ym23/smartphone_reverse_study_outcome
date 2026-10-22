package u3;

import java.util.Objects;

/* loaded from: classes.dex */
public final class m extends b4.q {

    /* renamed from: b, reason: collision with root package name */
    public final int f10040b;

    /* renamed from: c, reason: collision with root package name */
    public final f f10041c;

    public m(int i2, f fVar) {
        this.f10040b = i2;
        this.f10041c = fVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return mVar.f10040b == this.f10040b && mVar.f10041c == this.f10041c;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.f10040b), this.f10041c);
    }

    public final String toString() {
        return "AesGcmSiv Parameters (variant: " + this.f10041c + ", " + this.f10040b + "-byte key)";
    }
}
