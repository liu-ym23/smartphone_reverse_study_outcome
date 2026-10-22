package c7;

import a7.AbstractC0307c;
import java.util.List;

/* renamed from: c7.c, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC0883c {
    public static final byte[] e = {13, 10};

    /* renamed from: a, reason: collision with root package name */
    public final byte f2094a;
    public final int b;
    public final int c;
    public final int d;

    public AbstractC0883c(int i) {
        List list = AbstractC0307c.f1649a;
        this.b = 3;
        this.c = 4;
        this.d = 0;
        this.f2094a = (byte) 61;
    }

    public static byte[] a(int i, C0882b c0882b) {
        byte[] bArr = c0882b.b;
        if (bArr == null) {
            c0882b.b = new byte[Math.max(i, 8192)];
            c0882b.c = 0;
            c0882b.d = 0;
        } else {
            int i6 = c0882b.c + i;
            if (i6 - bArr.length > 0) {
                int length = bArr.length * 2;
                if (Integer.compare(length - Integer.MIN_VALUE, i6 - Integer.MIN_VALUE) < 0) {
                    length = i6;
                }
                if (Integer.compare(Integer.MIN_VALUE + length, -9) > 0) {
                    if (i6 < 0) {
                        throw new OutOfMemoryError("Unable to allocate array size: " + (i6 & 4294967295L));
                    }
                    length = Math.max(i6, 2147483639);
                }
                byte[] bArr2 = new byte[length];
                byte[] bArr3 = c0882b.b;
                System.arraycopy(bArr3, 0, bArr2, 0, bArr3.length);
                c0882b.b = bArr2;
                return bArr2;
            }
        }
        return c0882b.b;
    }
}
