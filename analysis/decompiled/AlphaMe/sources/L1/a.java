package L1;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: c, reason: collision with root package name */
    public static final a f1216c = new a(new byte[0]);

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f1217a;

    /* renamed from: b, reason: collision with root package name */
    public volatile int f1218b = 0;

    public a(byte[] bArr) {
        this.f1217a = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        byte[] bArr = this.f1217a;
        int length = bArr.length;
        byte[] bArr2 = ((a) obj).f1217a;
        if (length != bArr2.length) {
            return false;
        }
        for (int i4 = 0; i4 < length; i4++) {
            if (bArr[i4] != bArr2[i4]) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i4 = this.f1218b;
        if (i4 == 0) {
            byte[] bArr = this.f1217a;
            int length = bArr.length;
            for (byte b4 : bArr) {
                length = (length * 31) + b4;
            }
            i4 = length == 0 ? 1 : length;
            this.f1218b = i4;
        }
        return i4;
    }
}
