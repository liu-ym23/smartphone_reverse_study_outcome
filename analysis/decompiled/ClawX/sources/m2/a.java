package m2;

import java.util.Arrays;
import k4.z;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f3894a;

    public a(byte[] bArr, int i8) {
        byte[] bArr2 = new byte[i8];
        this.f3894a = bArr2;
        System.arraycopy(bArr, 0, bArr2, 0, i8);
    }

    public static a a(byte[] bArr) {
        if (bArr != null) {
            return new a(bArr, bArr.length);
        }
        throw new NullPointerException("data must be non-null");
    }

    public final boolean equals(Object obj) {
        if (obj instanceof a) {
            return Arrays.equals(((a) obj).f3894a, this.f3894a);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f3894a);
    }

    public final String toString() {
        return "Bytes(" + z.q(this.f3894a) + ")";
    }
}
