package z1;

import java.util.Objects;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class m extends g2.n {

    /* renamed from: b, reason: collision with root package name */
    public final int f6396b;

    /* renamed from: c, reason: collision with root package name */
    public final f f6397c;

    public m(int i8, f fVar) {
        this.f6396b = i8;
        this.f6397c = fVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return mVar.f6396b == this.f6396b && mVar.f6397c == this.f6397c;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.f6396b), this.f6397c);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("AesGcmSiv Parameters (variant: ");
        sb.append(this.f6397c);
        sb.append(", ");
        return m0.f.e(sb, this.f6396b, "-byte key)");
    }
}
