package sb;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f9638a;

    /* renamed from: b, reason: collision with root package name */
    public final int f9639b;

    public c(int i2, byte[] bArr) {
        this.f9638a = n7.b.c(bArr);
        this.f9639b = i2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (cVar.f9639b != this.f9639b) {
            return false;
        }
        return Arrays.equals(this.f9638a, cVar.f9638a);
    }

    public final int hashCode() {
        int i2;
        byte[] bArr = this.f9638a;
        if (bArr == null) {
            i2 = 0;
        } else {
            int length = bArr.length;
            int i10 = length + 1;
            while (true) {
                length--;
                if (length < 0) {
                    break;
                }
                i10 = (i10 * 257) ^ bArr[length];
            }
            i2 = i10;
        }
        return this.f9639b ^ i2;
    }
}
