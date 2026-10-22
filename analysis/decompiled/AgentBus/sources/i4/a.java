package i4;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f4640a;

    public a(int i2, byte[] bArr) {
        byte[] bArr2 = new byte[i2];
        this.f4640a = bArr2;
        System.arraycopy(bArr, 0, bArr2, 0, i2);
    }

    public static a a(byte[] bArr) {
        if (bArr != null) {
            return new a(bArr.length, bArr);
        }
        throw new NullPointerException("data must be non-null");
    }

    public final boolean equals(Object obj) {
        if (obj instanceof a) {
            return Arrays.equals(((a) obj).f4640a, this.f4640a);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f4640a);
    }

    public final String toString() {
        return "Bytes(" + a.a.J(this.f4640a) + ")";
    }
}
