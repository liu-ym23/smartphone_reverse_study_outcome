package L4;

import L4.h;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static final byte[] f3923a;

    /* renamed from: b, reason: collision with root package name */
    private static final byte[] f3924b;

    static {
        h.a aVar = h.f3943e;
        f3923a = aVar.b("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/").j();
        f3924b = aVar.b("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_").j();
    }

    public static final String a(byte[] bArr, byte[] bArr2) {
        j4.k.h(bArr, "$receiver");
        j4.k.h(bArr2, "map");
        byte[] bArr3 = new byte[((bArr.length + 2) / 3) * 4];
        int length = bArr.length - (bArr.length % 3);
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            byte b6 = bArr[i5];
            int i7 = i5 + 2;
            byte b7 = bArr[i5 + 1];
            i5 += 3;
            byte b8 = bArr[i7];
            bArr3[i6] = bArr2[(b6 & 255) >> 2];
            bArr3[i6 + 1] = bArr2[((b6 & 3) << 4) | ((b7 & 255) >> 4)];
            int i8 = i6 + 3;
            bArr3[i6 + 2] = bArr2[((b7 & 15) << 2) | ((b8 & 255) >> 6)];
            i6 += 4;
            bArr3[i8] = bArr2[b8 & 63];
        }
        int length2 = bArr.length - length;
        if (length2 == 1) {
            byte b9 = bArr[i5];
            bArr3[i6] = bArr2[(b9 & 255) >> 2];
            bArr3[i6 + 1] = bArr2[(b9 & 3) << 4];
            byte b10 = (byte) 61;
            bArr3[i6 + 2] = b10;
            bArr3[i6 + 3] = b10;
        } else if (length2 == 2) {
            int i9 = i5 + 1;
            byte b11 = bArr[i5];
            byte b12 = bArr[i9];
            bArr3[i6] = bArr2[(b11 & 255) >> 2];
            bArr3[i6 + 1] = bArr2[((b11 & 3) << 4) | ((b12 & 255) >> 4)];
            bArr3[i6 + 2] = bArr2[(b12 & 15) << 2];
            bArr3[i6 + 3] = (byte) 61;
        }
        return b.c(bArr3);
    }

    public static /* bridge */ /* synthetic */ String b(byte[] bArr, byte[] bArr2, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            bArr2 = f3923a;
        }
        return a(bArr, bArr2);
    }
}
