package v3;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f10384a = c(new byte[]{101, 120, 112, 97, 110, 100, 32, 51, 50, 45, 98, 121, 116, 101, 32, 107});

    public static void a(int[] iArr, int i2, int i10, int i11, int i12) {
        int i13 = iArr[i2] + iArr[i10];
        iArr[i2] = i13;
        int i14 = i13 ^ iArr[i12];
        int i15 = (i14 >>> (-16)) | (i14 << 16);
        iArr[i12] = i15;
        int i16 = iArr[i11] + i15;
        iArr[i11] = i16;
        int i17 = iArr[i10] ^ i16;
        int i18 = (i17 >>> (-12)) | (i17 << 12);
        iArr[i10] = i18;
        int i19 = iArr[i2] + i18;
        iArr[i2] = i19;
        int i20 = iArr[i12] ^ i19;
        int i21 = (i20 >>> (-8)) | (i20 << 8);
        iArr[i12] = i21;
        int i22 = iArr[i11] + i21;
        iArr[i11] = i22;
        int i23 = iArr[i10] ^ i22;
        iArr[i10] = (i23 >>> (-7)) | (i23 << 7);
    }

    public static void b(int[] iArr) {
        for (int i2 = 0; i2 < 10; i2++) {
            a(iArr, 0, 4, 8, 12);
            a(iArr, 1, 5, 9, 13);
            a(iArr, 2, 6, 10, 14);
            a(iArr, 3, 7, 11, 15);
            a(iArr, 0, 5, 10, 15);
            a(iArr, 1, 6, 11, 12);
            a(iArr, 2, 7, 8, 13);
            a(iArr, 3, 4, 9, 14);
        }
    }

    public static int[] c(byte[] bArr) {
        IntBuffer intBufferAsIntBuffer = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).asIntBuffer();
        int[] iArr = new int[intBufferAsIntBuffer.remaining()];
        intBufferAsIntBuffer.get(iArr);
        return iArr;
    }
}
