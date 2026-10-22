package B1;

import java.util.Arrays;

/* loaded from: classes2.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f181a;

    public e(byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        this.f181a = bArr2;
        System.arraycopy(bArr, 0, bArr2, 0, length);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof e)) {
            return false;
        }
        return Arrays.equals(this.f181a, ((e) obj).f181a);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f181a);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("0x");
        for (byte b : this.f181a) {
            sb.append(Integer.toHexString(b & 255));
        }
        return sb.toString();
    }
}
