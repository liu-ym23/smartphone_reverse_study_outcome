package z5;

import java.io.Serializable;
import kotlin.jvm.internal.p;
import x.e;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class b implements Comparable, Serializable {

    /* renamed from: c, reason: collision with root package name */
    public static final a f6542c = new a();
    public static final b d = new b(0, 0);

    /* renamed from: a, reason: collision with root package name */
    public final long f6543a;

    /* renamed from: b, reason: collision with root package name */
    public final long f6544b;

    public b(long j4, long j8) {
        this.f6543a = j4;
        this.f6544b = j8;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        b other = (b) obj;
        p.e(other, "other");
        long j4 = other.f6543a;
        long j8 = this.f6543a;
        return j8 != j4 ? Long.compareUnsigned(j8, j4) : Long.compareUnsigned(this.f6544b, other.f6544b);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f6543a == bVar.f6543a && this.f6544b == bVar.f6544b;
    }

    public final int hashCode() {
        return Long.hashCode(this.f6543a ^ this.f6544b);
    }

    public final String toString() {
        byte[] bArr = new byte[36];
        e.G(this.f6543a, bArr, 0, 0, 4);
        bArr[8] = 45;
        e.G(this.f6543a, bArr, 9, 4, 6);
        bArr[13] = 45;
        e.G(this.f6543a, bArr, 14, 6, 8);
        bArr[18] = 45;
        e.G(this.f6544b, bArr, 19, 0, 2);
        bArr[23] = 45;
        e.G(this.f6544b, bArr, 24, 2, 8);
        return new String(bArr, x5.a.f6276a);
    }
}
