package y1;

import java.util.Arrays;
import k4.z;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class l implements Comparable {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f6329a;

    public l(byte[] bArr) {
        this.f6329a = Arrays.copyOf(bArr, bArr.length);
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        l lVar = (l) obj;
        byte[] bArr = this.f6329a;
        int length = bArr.length;
        byte[] bArr2 = lVar.f6329a;
        if (length != bArr2.length) {
            return bArr.length - bArr2.length;
        }
        for (int i8 = 0; i8 < bArr.length; i8++) {
            byte b9 = bArr[i8];
            byte b10 = lVar.f6329a[i8];
            if (b9 != b10) {
                return b9 - b10;
            }
        }
        return 0;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof l) {
            return Arrays.equals(this.f6329a, ((l) obj).f6329a);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f6329a);
    }

    public final String toString() {
        return z.q(this.f6329a);
    }
}
