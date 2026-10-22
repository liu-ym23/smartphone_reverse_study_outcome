package i2;

import java.util.Objects;
import y1.f;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final f f3139a;

    /* renamed from: b, reason: collision with root package name */
    public final int f3140b;

    /* renamed from: c, reason: collision with root package name */
    public final String f3141c;
    public final String d;

    public b(f fVar, int i8, String str, String str2) {
        this.f3139a = fVar;
        this.f3140b = i8;
        this.f3141c = str;
        this.d = str2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f3139a == bVar.f3139a && this.f3140b == bVar.f3140b && this.f3141c.equals(bVar.f3141c) && this.d.equals(bVar.d);
    }

    public final int hashCode() {
        return Objects.hash(this.f3139a, Integer.valueOf(this.f3140b), this.f3141c, this.d);
    }

    public final String toString() {
        return "(status=" + this.f3139a + ", keyId=" + this.f3140b + ", keyType='" + this.f3141c + "', keyPrefix='" + this.d + "')";
    }
}
