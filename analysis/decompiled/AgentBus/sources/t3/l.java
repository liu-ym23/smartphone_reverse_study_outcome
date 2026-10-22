package t3;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class l implements Comparable {

    /* renamed from: f, reason: collision with root package name */
    public final byte[] f9725f;

    public l(byte[] bArr) {
        this.f9725f = Arrays.copyOf(bArr, bArr.length);
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        l lVar = (l) obj;
        byte[] bArr = this.f9725f;
        int length = bArr.length;
        byte[] bArr2 = lVar.f9725f;
        if (length != bArr2.length) {
            return bArr.length - bArr2.length;
        }
        for (int i2 = 0; i2 < bArr.length; i2++) {
            byte b10 = bArr[i2];
            byte b11 = lVar.f9725f[i2];
            if (b10 != b11) {
                return b10 - b11;
            }
        }
        return 0;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof l) {
            return Arrays.equals(this.f9725f, ((l) obj).f9725f);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f9725f);
    }

    public final String toString() {
        return a.a.J(this.f9725f);
    }
}
