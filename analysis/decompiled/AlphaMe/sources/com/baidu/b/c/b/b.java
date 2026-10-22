package com.baidu.b.c.b;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.security.GeneralSecurityException;
import java.util.Random;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f4837a = a(new byte[]{101, 120, 112, 97, 110, 100, 32, 51, 50, 45, 98, 121, 116, 101, 32, 107});

    /* renamed from: b, reason: collision with root package name */
    private final int f4838b;

    public b(int i4) {
        this.f4838b = i4;
    }

    public int a() {
        return 12;
    }

    public byte[] b(byte[] bArr) throws GeneralSecurityException {
        return a(bArr, (byte[]) null);
    }

    public byte[] c(byte[] bArr) throws GeneralSecurityException {
        return a(ByteBuffer.wrap(bArr));
    }

    private static int a(int i4, int i5) {
        return (i4 >>> (-i5)) | (i4 << i5);
    }

    public ByteBuffer a(byte[] bArr, byte[] bArr2, int i4) {
        int[] iArrA = a(a(bArr), a(bArr2), i4);
        int[] iArr = (int[]) iArrA.clone();
        a(iArr);
        for (int i5 = 0; i5 < iArrA.length; i5++) {
            iArrA[i5] = iArrA[i5] + iArr[i5];
        }
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(64).order(ByteOrder.LITTLE_ENDIAN);
        byteBufferOrder.asIntBuffer().put(iArrA, 0, 16);
        return byteBufferOrder;
    }

    public void a(ByteBuffer byteBuffer, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (byteBuffer.remaining() - a() < bArr.length) {
            throw new IllegalArgumentException("data output is too small");
        }
        if (bArr2 == null) {
            bArr2 = new byte[a()];
            new Random().nextBytes(bArr2);
        }
        byteBuffer.put(bArr2);
        a(bArr2, com.baidu.b.c.c.b.a(), byteBuffer, ByteBuffer.wrap(bArr));
    }

    private void a(byte[] bArr, byte[] bArr2, ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws GeneralSecurityException {
        int iRemaining = byteBuffer2.remaining();
        int i4 = iRemaining / 64;
        int i5 = i4 + 1;
        for (int i6 = 0; i6 < i5; i6++) {
            ByteBuffer byteBufferA = a(bArr, bArr2, this.f4838b + i6);
            int i7 = 64;
            if (i6 == i4) {
                i7 = iRemaining % 64;
            }
            a.a(byteBuffer, byteBuffer2, byteBufferA, i7);
        }
    }

    public static void a(int[] iArr) {
        for (int i4 = 0; i4 < 10; i4++) {
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

    public static void a(int[] iArr, int i4, int i5, int i6, int i7) {
        int i8 = iArr[i4] + iArr[i5];
        iArr[i4] = i8;
        int iA = a(i8 ^ iArr[i7], 16);
        iArr[i7] = iA;
        int i9 = iArr[i6] + iA;
        iArr[i6] = i9;
        int iA2 = a(iArr[i5] ^ i9, 12);
        iArr[i5] = iA2;
        int i10 = iArr[i4] + iA2;
        iArr[i4] = i10;
        int iA3 = a(iArr[i7] ^ i10, 8);
        iArr[i7] = iA3;
        int i11 = iArr[i6] + iA3;
        iArr[i6] = i11;
        iArr[i5] = a(iArr[i5] ^ i11, 7);
    }

    public static void a(int[] iArr, int[] iArr2) {
        int[] iArr3 = f4837a;
        System.arraycopy(iArr3, 0, iArr, 0, iArr3.length);
        System.arraycopy(iArr2, 0, iArr, iArr3.length, 8);
    }

    public byte[] a(ByteBuffer byteBuffer) throws GeneralSecurityException {
        if (byteBuffer.remaining() < a()) {
            throw new GeneralSecurityException("data too short");
        }
        byte[] bArr = new byte[a()];
        byteBuffer.get(bArr);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(byteBuffer.remaining());
        a(bArr, com.baidu.b.c.c.b.b(), byteBufferAllocate, byteBuffer);
        return byteBufferAllocate.array();
    }

    public byte[] a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length > Integer.MAX_VALUE - a()) {
            throw new GeneralSecurityException("data too long");
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(a() + bArr.length);
        a(byteBufferAllocate, bArr, bArr2);
        return byteBufferAllocate.array();
    }

    public static int[] a(byte[] bArr) {
        IntBuffer intBufferAsIntBuffer = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).asIntBuffer();
        int[] iArr = new int[intBufferAsIntBuffer.remaining()];
        intBufferAsIntBuffer.get(iArr);
        return iArr;
    }

    public int[] a(int[] iArr, int[] iArr2, int i4) {
        if (iArr.length != a() / 4) {
            throw new IllegalArgumentException(String.format("need 96-bit param, but got a %d-bit param", Integer.valueOf(iArr.length * 32)));
        }
        int[] iArr3 = new int[16];
        a(iArr3, iArr2);
        iArr3[12] = i4;
        System.arraycopy(iArr, 0, iArr3, 13, iArr.length);
        return iArr3;
    }
}
