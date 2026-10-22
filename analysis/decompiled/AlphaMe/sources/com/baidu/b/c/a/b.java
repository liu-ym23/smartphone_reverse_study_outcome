package com.baidu.b.c.a;

import java.lang.reflect.Array;
import java.security.InvalidKeyException;
import kotlin.UByte;
import s.AbstractC0831a;

/* loaded from: classes.dex */
public final class b implements a {

    /* renamed from: b, reason: collision with root package name */
    private static int[] f4795b;

    /* renamed from: c, reason: collision with root package name */
    private static int[] f4796c;

    /* renamed from: d, reason: collision with root package name */
    private static final byte[] f4797d = new byte[256];

    /* renamed from: e, reason: collision with root package name */
    private static final byte[] f4798e = new byte[256];

    /* renamed from: f, reason: collision with root package name */
    private static final int[] f4799f = new int[256];

    /* renamed from: g, reason: collision with root package name */
    private static final int[] f4800g = new int[256];

    /* renamed from: h, reason: collision with root package name */
    private static final int[] f4801h = new int[256];

    /* renamed from: i, reason: collision with root package name */
    private static final int[] f4802i = new int[256];

    /* renamed from: j, reason: collision with root package name */
    private static final int[] f4803j = new int[256];

    /* renamed from: k, reason: collision with root package name */
    private static final int[] f4804k = new int[256];

    /* renamed from: l, reason: collision with root package name */
    private static final int[] f4805l = new int[256];

    /* renamed from: m, reason: collision with root package name */
    private static final int[] f4806m = new int[256];

    /* renamed from: n, reason: collision with root package name */
    private static final int[] f4807n = new int[256];

    /* renamed from: o, reason: collision with root package name */
    private static final int[] f4808o = new int[256];

    /* renamed from: p, reason: collision with root package name */
    private static final int[] f4809p = new int[256];

    /* renamed from: q, reason: collision with root package name */
    private static final int[] f4810q = new int[256];

    /* renamed from: r, reason: collision with root package name */
    private static final byte[] f4811r = new byte[30];

    /* renamed from: s, reason: collision with root package name */
    private boolean f4812s = false;

    /* renamed from: t, reason: collision with root package name */
    private boolean f4813t = false;

    /* renamed from: u, reason: collision with root package name */
    private Object[] f4814u = null;

    /* renamed from: v, reason: collision with root package name */
    private int[] f4815v = null;

    /* renamed from: w, reason: collision with root package name */
    private int f4816w = 0;

    static {
        int[] iArr = new int[256];
        f4795b = iArr;
        f4796c = new int[256];
        iArr[0] = 1;
        for (int i4 = 1; i4 < 256; i4++) {
            int[] iArr2 = f4795b;
            int i5 = iArr2[i4 - 1];
            int i6 = i5 ^ (i5 << 1);
            if ((i6 & 256) != 0) {
                i6 ^= 283;
            }
            iArr2[i4] = i6;
        }
        for (int i7 = 1; i7 < 255; i7++) {
            f4796c[f4795b[i7]] = i7;
        }
        byte[][] bArr = {new byte[]{1, 1, 1, 1, 1, 0, 0, 0}, new byte[]{0, 1, 1, 1, 1, 1, 0, 0}, new byte[]{0, 0, 1, 1, 1, 1, 1, 0}, new byte[]{0, 0, 0, 1, 1, 1, 1, 1}, new byte[]{1, 0, 0, 0, 1, 1, 1, 1}, new byte[]{1, 1, 0, 0, 0, 1, 1, 1}, new byte[]{1, 1, 1, 0, 0, 0, 1, 1}, new byte[]{1, 1, 1, 1, 0, 0, 0, 1}};
        byte[] bArr2 = {0, 1, 1, 0, 0, 0, 1, 1};
        byte[][] bArr3 = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, 256, 8);
        bArr3[1][7] = 1;
        for (int i8 = 2; i8 < 256; i8++) {
            int i9 = f4795b[255 - f4796c[i8]];
            for (int i10 = 0; i10 < 8; i10++) {
                bArr3[i8][i10] = (byte) ((i9 >>> (7 - i10)) & 1);
            }
        }
        byte[][] bArr4 = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, 256, 8);
        for (int i11 = 0; i11 < 256; i11++) {
            for (int i12 = 0; i12 < 8; i12++) {
                bArr4[i11][i12] = bArr2[i12];
                for (int i13 = 0; i13 < 8; i13++) {
                    byte[] bArr5 = bArr4[i11];
                    bArr5[i12] = (byte) (bArr5[i12] ^ (bArr[i12][i13] * bArr3[i11][i13]));
                }
            }
        }
        for (int i14 = 0; i14 < 256; i14++) {
            f4797d[i14] = (byte) (bArr4[i14][0] << 7);
            for (int i15 = 1; i15 < 8; i15++) {
                byte[] bArr6 = f4797d;
                bArr6[i14] = (byte) (bArr6[i14] ^ (bArr4[i14][i15] << (7 - i15)));
            }
            f4798e[f4797d[i14] & UByte.MAX_VALUE] = (byte) i14;
        }
        byte[][] bArr7 = {new byte[]{2, 1, 1, 3}, new byte[]{3, 2, 1, 1}, new byte[]{1, 3, 2, 1}, new byte[]{1, 1, 3, 2}};
        byte[][] bArr8 = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, 4, 8);
        for (int i16 = 0; i16 < 4; i16++) {
            for (int i17 = 0; i17 < 4; i17++) {
                bArr8[i16][i17] = bArr7[i16][i17];
            }
            bArr8[i16][i16 + 4] = 1;
        }
        byte[][] bArr9 = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, 4, 4);
        for (int i18 = 0; i18 < 4; i18++) {
            byte b4 = bArr8[i18][i18];
            if (b4 == 0) {
                int i19 = i18 + 1;
                while (bArr8[i19][i18] == 0 && i19 < 4) {
                    i19++;
                }
                if (i19 == 4) {
                    throw new RuntimeException("G matrix is not invertible");
                }
                for (int i20 = 0; i20 < 8; i20++) {
                    byte[] bArr10 = bArr8[i18];
                    byte b5 = bArr10[i20];
                    byte[] bArr11 = bArr8[i19];
                    bArr10[i20] = bArr11[i20];
                    bArr11[i20] = b5;
                }
                b4 = bArr8[i18][i18];
            }
            for (int i21 = 0; i21 < 8; i21++) {
                byte[] bArr12 = bArr8[i18];
                byte b6 = bArr12[i21];
                if (b6 != 0) {
                    int[] iArr3 = f4795b;
                    int[] iArr4 = f4796c;
                    bArr12[i21] = (byte) iArr3[((iArr4[b6 & UByte.MAX_VALUE] + 255) - iArr4[b4 & UByte.MAX_VALUE]) % 255];
                }
            }
            for (int i22 = 0; i22 < 4; i22++) {
                if (i18 != i22) {
                    for (int i23 = i18 + 1; i23 < 8; i23++) {
                        byte[] bArr13 = bArr8[i22];
                        bArr13[i23] = (byte) (bArr13[i23] ^ a(bArr8[i18][i23], bArr13[i18]));
                    }
                    bArr8[i22][i18] = 0;
                }
            }
        }
        for (int i24 = 0; i24 < 4; i24++) {
            for (int i25 = 0; i25 < 4; i25++) {
                bArr9[i24][i25] = bArr8[i24][i25 + 4];
            }
        }
        for (int i26 = 0; i26 < 256; i26++) {
            byte b7 = f4797d[i26];
            f4799f[i26] = a(b7, bArr7[0]);
            f4800g[i26] = a(b7, bArr7[1]);
            f4801h[i26] = a(b7, bArr7[2]);
            f4802i[i26] = a(b7, bArr7[3]);
            byte b8 = f4798e[i26];
            f4803j[i26] = a(b8, bArr9[0]);
            f4804k[i26] = a(b8, bArr9[1]);
            f4805l[i26] = a(b8, bArr9[2]);
            f4806m[i26] = a(b8, bArr9[3]);
            f4807n[i26] = a(i26, bArr9[0]);
            f4808o[i26] = a(i26, bArr9[1]);
            f4809p[i26] = a(i26, bArr9[2]);
            f4810q[i26] = a(i26, bArr9[3]);
        }
        f4811r[0] = 1;
        int iA = 1;
        for (int i27 = 1; i27 < 30; i27++) {
            iA = a(2, iA);
            f4811r[i27] = (byte) iA;
        }
        f4796c = null;
        f4795b = null;
    }

    private static int b(int i4) {
        return (i4 >> 2) + 6;
    }

    public int a() {
        return 16;
    }

    private static final int a(int i4, int i5) {
        if (i4 == 0 || i5 == 0) {
            return 0;
        }
        int[] iArr = f4795b;
        int[] iArr2 = f4796c;
        return iArr[(iArr2[i4 & 255] + iArr2[i5 & 255]) % 255];
    }

    public void b(byte[] bArr, int i4, byte[] bArr2, int i5) {
        int i6;
        int i7 = ((bArr[i4 + 1] & UByte.MAX_VALUE) << 16) | (bArr[i4] << 24) | ((bArr[i4 + 2] & UByte.MAX_VALUE) << 8) | (bArr[i4 + 3] & UByte.MAX_VALUE);
        int[] iArr = this.f4815v;
        int i8 = i7 ^ iArr[4];
        int i9 = ((((bArr[i4 + 4] << 24) | ((bArr[i4 + 5] & UByte.MAX_VALUE) << 16)) | ((bArr[i4 + 6] & UByte.MAX_VALUE) << 8)) | (bArr[i4 + 7] & UByte.MAX_VALUE)) ^ iArr[5];
        int i10 = (((((bArr[i4 + 9] & UByte.MAX_VALUE) << 16) | (bArr[i4 + 8] << 24)) | ((bArr[i4 + 10] & UByte.MAX_VALUE) << 8)) | (bArr[i4 + 11] & UByte.MAX_VALUE)) ^ iArr[6];
        int i11 = (((((bArr[i4 + 13] & UByte.MAX_VALUE) << 16) | (bArr[i4 + 12] << 24)) | ((bArr[i4 + 14] & UByte.MAX_VALUE) << 8)) | (bArr[i4 + 15] & UByte.MAX_VALUE)) ^ iArr[7];
        if (this.f4812s) {
            int[] iArr2 = f4803j;
            int i12 = iArr2[i8 >>> 24];
            int[] iArr3 = f4804k;
            int i13 = i12 ^ iArr3[(i11 >>> 16) & 255];
            int[] iArr4 = f4805l;
            int i14 = i13 ^ iArr4[(i10 >>> 8) & 255];
            int[] iArr5 = f4806m;
            int i15 = (i14 ^ iArr5[i9 & 255]) ^ iArr[8];
            int i16 = (((iArr3[(i8 >>> 16) & 255] ^ iArr2[i9 >>> 24]) ^ iArr4[(i11 >>> 8) & 255]) ^ iArr5[i10 & 255]) ^ iArr[9];
            int i17 = (((iArr3[(i9 >>> 16) & 255] ^ iArr2[i10 >>> 24]) ^ iArr4[(i8 >>> 8) & 255]) ^ iArr5[i11 & 255]) ^ iArr[10];
            int i18 = (iArr5[i8 & 255] ^ (iArr4[(i9 >>> 8) & 255] ^ (iArr3[(i10 >>> 16) & 255] ^ iArr2[i11 >>> 24]))) ^ iArr[11];
            int i19 = (((iArr2[i15 >>> 24] ^ iArr3[(i18 >>> 16) & 255]) ^ iArr4[(i17 >>> 8) & 255]) ^ iArr5[i16 & 255]) ^ iArr[12];
            int i20 = (((iArr2[i16 >>> 24] ^ iArr3[(i15 >>> 16) & 255]) ^ iArr4[(i18 >>> 8) & 255]) ^ iArr5[i17 & 255]) ^ iArr[13];
            int i21 = (((iArr2[i17 >>> 24] ^ iArr3[(i16 >>> 16) & 255]) ^ iArr4[(i15 >>> 8) & 255]) ^ iArr5[i18 & 255]) ^ iArr[14];
            int i22 = (((iArr2[i18 >>> 24] ^ iArr3[(i17 >>> 16) & 255]) ^ iArr4[(i16 >>> 8) & 255]) ^ iArr5[i15 & 255]) ^ iArr[15];
            if (this.f4813t) {
                int i23 = (((iArr2[i19 >>> 24] ^ iArr3[(i22 >>> 16) & 255]) ^ iArr4[(i21 >>> 8) & 255]) ^ iArr5[i20 & 255]) ^ iArr[16];
                int i24 = (((iArr2[i20 >>> 24] ^ iArr3[(i19 >>> 16) & 255]) ^ iArr4[(i22 >>> 8) & 255]) ^ iArr5[i21 & 255]) ^ iArr[17];
                int i25 = (((iArr2[i21 >>> 24] ^ iArr3[(i20 >>> 16) & 255]) ^ iArr4[(i19 >>> 8) & 255]) ^ iArr5[i22 & 255]) ^ iArr[18];
                int i26 = (((iArr2[i22 >>> 24] ^ iArr3[(i21 >>> 16) & 255]) ^ iArr4[(i20 >>> 8) & 255]) ^ iArr5[i19 & 255]) ^ iArr[19];
                int i27 = (((iArr2[i23 >>> 24] ^ iArr3[(i26 >>> 16) & 255]) ^ iArr4[(i25 >>> 8) & 255]) ^ iArr5[i24 & 255]) ^ iArr[20];
                int i28 = (((iArr2[i24 >>> 24] ^ iArr3[(i23 >>> 16) & 255]) ^ iArr4[(i26 >>> 8) & 255]) ^ iArr5[i25 & 255]) ^ iArr[21];
                int i29 = (((iArr2[i25 >>> 24] ^ iArr3[(i24 >>> 16) & 255]) ^ iArr4[(i23 >>> 8) & 255]) ^ iArr5[i26 & 255]) ^ iArr[22];
                int i30 = (iArr5[i23 & 255] ^ ((iArr2[i26 >>> 24] ^ iArr3[(i25 >>> 16) & 255]) ^ iArr4[(i24 >>> 8) & 255])) ^ iArr[23];
                i8 = i27;
                i9 = i28;
                i10 = i29;
                i11 = i30;
                i6 = 24;
            } else {
                i6 = 16;
                i11 = i22;
                i8 = i19;
                i9 = i20;
                i10 = i21;
            }
        } else {
            i6 = 8;
        }
        int[] iArr6 = f4803j;
        int i31 = iArr6[i8 >>> 24];
        int[] iArr7 = f4804k;
        int i32 = i31 ^ iArr7[(i11 >>> 16) & 255];
        int[] iArr8 = f4805l;
        int i33 = i32 ^ iArr8[(i10 >>> 8) & 255];
        int[] iArr9 = f4806m;
        int i34 = (i33 ^ iArr9[i9 & 255]) ^ iArr[i6];
        int i35 = iArr[i6 + 1] ^ (((iArr6[i9 >>> 24] ^ iArr7[(i8 >>> 16) & 255]) ^ iArr8[(i11 >>> 8) & 255]) ^ iArr9[i10 & 255]);
        int i36 = (((iArr7[(i9 >>> 16) & 255] ^ iArr6[i10 >>> 24]) ^ iArr8[(i8 >>> 8) & 255]) ^ iArr9[i11 & 255]) ^ iArr[i6 + 2];
        int i37 = (iArr9[i8 & 255] ^ (iArr8[(i9 >>> 8) & 255] ^ (iArr7[(i10 >>> 16) & 255] ^ iArr6[i11 >>> 24]))) ^ iArr[i6 + 3];
        int i38 = iArr[i6 + 4] ^ (((iArr6[i34 >>> 24] ^ iArr7[(i37 >>> 16) & 255]) ^ iArr8[(i36 >>> 8) & 255]) ^ iArr9[i35 & 255]);
        int i39 = (((iArr6[i35 >>> 24] ^ iArr7[(i34 >>> 16) & 255]) ^ iArr8[(i37 >>> 8) & 255]) ^ iArr9[i36 & 255]) ^ iArr[i6 + 5];
        int i40 = (((iArr6[i36 >>> 24] ^ iArr7[(i35 >>> 16) & 255]) ^ iArr8[(i34 >>> 8) & 255]) ^ iArr9[i37 & 255]) ^ iArr[i6 + 6];
        int i41 = (((iArr6[i37 >>> 24] ^ iArr7[(i36 >>> 16) & 255]) ^ iArr8[(i35 >>> 8) & 255]) ^ iArr9[i34 & 255]) ^ iArr[i6 + 7];
        int i42 = iArr[i6 + 8] ^ (((iArr6[i38 >>> 24] ^ iArr7[(i41 >>> 16) & 255]) ^ iArr8[(i40 >>> 8) & 255]) ^ iArr9[i39 & 255]);
        int i43 = (((iArr6[i39 >>> 24] ^ iArr7[(i38 >>> 16) & 255]) ^ iArr8[(i41 >>> 8) & 255]) ^ iArr9[i40 & 255]) ^ iArr[i6 + 9];
        int i44 = (((iArr6[i40 >>> 24] ^ iArr7[(i39 >>> 16) & 255]) ^ iArr8[(i38 >>> 8) & 255]) ^ iArr9[i41 & 255]) ^ iArr[i6 + 10];
        int i45 = (((iArr6[i41 >>> 24] ^ iArr7[(i40 >>> 16) & 255]) ^ iArr8[(i39 >>> 8) & 255]) ^ iArr9[i38 & 255]) ^ iArr[i6 + 11];
        int i46 = iArr[i6 + 12] ^ (((iArr6[i42 >>> 24] ^ iArr7[(i45 >>> 16) & 255]) ^ iArr8[(i44 >>> 8) & 255]) ^ iArr9[i43 & 255]);
        int i47 = (((iArr6[i43 >>> 24] ^ iArr7[(i42 >>> 16) & 255]) ^ iArr8[(i45 >>> 8) & 255]) ^ iArr9[i44 & 255]) ^ iArr[i6 + 13];
        int i48 = (((iArr6[i44 >>> 24] ^ iArr7[(i43 >>> 16) & 255]) ^ iArr8[(i42 >>> 8) & 255]) ^ iArr9[i45 & 255]) ^ iArr[i6 + 14];
        int i49 = (((iArr6[i45 >>> 24] ^ iArr7[(i44 >>> 16) & 255]) ^ iArr8[(i43 >>> 8) & 255]) ^ iArr9[i42 & 255]) ^ iArr[i6 + 15];
        int i50 = iArr[i6 + 16] ^ (((iArr6[i46 >>> 24] ^ iArr7[(i49 >>> 16) & 255]) ^ iArr8[(i48 >>> 8) & 255]) ^ iArr9[i47 & 255]);
        int i51 = (((iArr6[i47 >>> 24] ^ iArr7[(i46 >>> 16) & 255]) ^ iArr8[(i49 >>> 8) & 255]) ^ iArr9[i48 & 255]) ^ iArr[i6 + 17];
        int i52 = (((iArr6[i48 >>> 24] ^ iArr7[(i47 >>> 16) & 255]) ^ iArr8[(i46 >>> 8) & 255]) ^ iArr9[i49 & 255]) ^ iArr[i6 + 18];
        int i53 = (((iArr6[i49 >>> 24] ^ iArr7[(i48 >>> 16) & 255]) ^ iArr8[(i47 >>> 8) & 255]) ^ iArr9[i46 & 255]) ^ iArr[i6 + 19];
        int i54 = iArr[i6 + 20] ^ (((iArr6[i50 >>> 24] ^ iArr7[(i53 >>> 16) & 255]) ^ iArr8[(i52 >>> 8) & 255]) ^ iArr9[i51 & 255]);
        int i55 = (((iArr6[i51 >>> 24] ^ iArr7[(i50 >>> 16) & 255]) ^ iArr8[(i53 >>> 8) & 255]) ^ iArr9[i52 & 255]) ^ iArr[i6 + 21];
        int i56 = (((iArr6[i52 >>> 24] ^ iArr7[(i51 >>> 16) & 255]) ^ iArr8[(i50 >>> 8) & 255]) ^ iArr9[i53 & 255]) ^ iArr[i6 + 22];
        int i57 = (((iArr6[i53 >>> 24] ^ iArr7[(i52 >>> 16) & 255]) ^ iArr8[(i51 >>> 8) & 255]) ^ iArr9[i50 & 255]) ^ iArr[i6 + 23];
        int i58 = iArr[i6 + 24] ^ (((iArr6[i54 >>> 24] ^ iArr7[(i57 >>> 16) & 255]) ^ iArr8[(i56 >>> 8) & 255]) ^ iArr9[i55 & 255]);
        int i59 = (((iArr6[i55 >>> 24] ^ iArr7[(i54 >>> 16) & 255]) ^ iArr8[(i57 >>> 8) & 255]) ^ iArr9[i56 & 255]) ^ iArr[i6 + 25];
        int i60 = (((iArr6[i56 >>> 24] ^ iArr7[(i55 >>> 16) & 255]) ^ iArr8[(i54 >>> 8) & 255]) ^ iArr9[i57 & 255]) ^ iArr[i6 + 26];
        int i61 = (((iArr6[i57 >>> 24] ^ iArr7[(i56 >>> 16) & 255]) ^ iArr8[(i55 >>> 8) & 255]) ^ iArr9[i54 & 255]) ^ iArr[i6 + 27];
        int i62 = iArr[i6 + 28] ^ (((iArr6[i58 >>> 24] ^ iArr7[(i61 >>> 16) & 255]) ^ iArr8[(i60 >>> 8) & 255]) ^ iArr9[i59 & 255]);
        int i63 = (((iArr6[i59 >>> 24] ^ iArr7[(i58 >>> 16) & 255]) ^ iArr8[(i61 >>> 8) & 255]) ^ iArr9[i60 & 255]) ^ iArr[i6 + 29];
        int i64 = (((iArr6[i60 >>> 24] ^ iArr7[(i59 >>> 16) & 255]) ^ iArr8[(i58 >>> 8) & 255]) ^ iArr9[i61 & 255]) ^ iArr[i6 + 30];
        int i65 = (((iArr6[i61 >>> 24] ^ iArr7[(i60 >>> 16) & 255]) ^ iArr8[(i59 >>> 8) & 255]) ^ iArr9[i58 & 255]) ^ iArr[i6 + 31];
        int i66 = iArr[i6 + 32] ^ (((iArr6[i62 >>> 24] ^ iArr7[(i65 >>> 16) & 255]) ^ iArr8[(i64 >>> 8) & 255]) ^ iArr9[i63 & 255]);
        int i67 = (((iArr6[i63 >>> 24] ^ iArr7[(i62 >>> 16) & 255]) ^ iArr8[(i65 >>> 8) & 255]) ^ iArr9[i64 & 255]) ^ iArr[i6 + 33];
        int i68 = (((iArr6[i64 >>> 24] ^ iArr7[(i63 >>> 16) & 255]) ^ iArr8[(i62 >>> 8) & 255]) ^ iArr9[i65 & 255]) ^ iArr[i6 + 34];
        int i69 = iArr[i6 + 35] ^ (((iArr6[i65 >>> 24] ^ iArr7[(i64 >>> 16) & 255]) ^ iArr8[(i63 >>> 8) & 255]) ^ iArr9[i62 & 255]);
        int i70 = iArr[0];
        byte[] bArr3 = f4798e;
        bArr2[i5] = (byte) (bArr3[i66 >>> 24] ^ (i70 >>> 24));
        bArr2[i5 + 1] = (byte) (bArr3[(i69 >>> 16) & 255] ^ (i70 >>> 16));
        bArr2[i5 + 2] = (byte) (bArr3[(i68 >>> 8) & 255] ^ (i70 >>> 8));
        bArr2[i5 + 3] = (byte) (i70 ^ bArr3[i67 & 255]);
        int i71 = iArr[1];
        bArr2[i5 + 4] = (byte) (bArr3[i67 >>> 24] ^ (i71 >>> 24));
        bArr2[i5 + 5] = (byte) (bArr3[(i66 >>> 16) & 255] ^ (i71 >>> 16));
        bArr2[i5 + 6] = (byte) (bArr3[(i69 >>> 8) & 255] ^ (i71 >>> 8));
        bArr2[i5 + 7] = (byte) (i71 ^ bArr3[i68 & 255]);
        int i72 = iArr[2];
        bArr2[i5 + 8] = (byte) (bArr3[i68 >>> 24] ^ (i72 >>> 24));
        bArr2[i5 + 9] = (byte) (bArr3[(i67 >>> 16) & 255] ^ (i72 >>> 16));
        bArr2[i5 + 10] = (byte) (bArr3[(i66 >>> 8) & 255] ^ (i72 >>> 8));
        bArr2[i5 + 11] = (byte) (i72 ^ bArr3[i69 & 255]);
        int i73 = iArr[3];
        bArr2[i5 + 12] = (byte) (bArr3[i69 >>> 24] ^ (i73 >>> 24));
        bArr2[i5 + 13] = (byte) (bArr3[(i68 >>> 16) & 255] ^ (i73 >>> 16));
        bArr2[i5 + 14] = (byte) (bArr3[(i67 >>> 8) & 255] ^ (i73 >>> 8));
        bArr2[i5 + 15] = (byte) (bArr3[i66 & 255] ^ i73);
    }

    private static final int a(int i4, byte[] bArr) {
        if (i4 == 0) {
            return 0;
        }
        int[] iArr = f4796c;
        int i5 = iArr[i4 & 255];
        byte b4 = bArr[0];
        int i6 = b4 != 0 ? f4795b[(iArr[b4 & UByte.MAX_VALUE] + i5) % 255] & 255 : 0;
        byte b5 = bArr[1];
        int i7 = b5 != 0 ? f4795b[(iArr[b5 & UByte.MAX_VALUE] + i5) % 255] & 255 : 0;
        byte b6 = bArr[2];
        int i8 = b6 != 0 ? f4795b[(iArr[b6 & UByte.MAX_VALUE] + i5) % 255] & 255 : 0;
        byte b7 = bArr[3];
        return (i6 << 24) | (i7 << 16) | (i8 << 8) | (b7 != 0 ? f4795b[(i5 + iArr[b7 & UByte.MAX_VALUE]) % 255] & 255 : 0);
    }

    private void a(boolean z4) {
        int[][] iArr = (int[][]) this.f4814u[z4 ? 1 : 0];
        int length = iArr.length;
        this.f4815v = new int[length * 4];
        for (int i4 = 0; i4 < length; i4++) {
            for (int i5 = 0; i5 < 4; i5++) {
                this.f4815v[(i4 * 4) + i5] = iArr[i4][i5];
            }
        }
        if (z4) {
            int[] iArr2 = this.f4815v;
            int i6 = iArr2[iArr2.length - 4];
            int i7 = iArr2[iArr2.length - 3];
            int i8 = iArr2[iArr2.length - 2];
            int i9 = iArr2[iArr2.length - 1];
            for (int length2 = iArr2.length - 1; length2 > 3; length2--) {
                int[] iArr3 = this.f4815v;
                iArr3[length2] = iArr3[length2 - 4];
            }
            int[] iArr4 = this.f4815v;
            iArr4[0] = i6;
            iArr4[1] = i7;
            iArr4[2] = i8;
            iArr4[3] = i9;
        }
        this.f4812s = length >= 13;
        this.f4813t = length == 15;
        this.f4816w = (length - 1) * 4;
    }

    public void a(boolean z4, String str, byte[] bArr) throws InvalidKeyException {
        if (!a(bArr.length)) {
            throw new InvalidKeyException(AbstractC0831a.d(new StringBuilder("Invalid AES key length: "), bArr.length, " bytes"));
        }
        this.f4814u = a(bArr);
        a(z4);
    }

    public void a(byte[] bArr, int i4, byte[] bArr2, int i5) {
        int i6 = ((bArr[i4 + 1] & UByte.MAX_VALUE) << 16) | (bArr[i4] << 24) | ((bArr[i4 + 2] & UByte.MAX_VALUE) << 8) | (bArr[i4 + 3] & UByte.MAX_VALUE);
        int[] iArr = this.f4815v;
        int i7 = i6 ^ iArr[0];
        int i8 = ((((bArr[i4 + 4] << 24) | ((bArr[i4 + 5] & UByte.MAX_VALUE) << 16)) | ((bArr[i4 + 6] & UByte.MAX_VALUE) << 8)) | (bArr[i4 + 7] & UByte.MAX_VALUE)) ^ iArr[1];
        int i9 = (((((bArr[i4 + 9] & UByte.MAX_VALUE) << 16) | (bArr[i4 + 8] << 24)) | ((bArr[i4 + 10] & UByte.MAX_VALUE) << 8)) | (bArr[i4 + 11] & UByte.MAX_VALUE)) ^ iArr[2];
        int i10 = iArr[3] ^ (((((bArr[i4 + 13] & UByte.MAX_VALUE) << 16) | (bArr[i4 + 12] << 24)) | ((bArr[i4 + 14] & UByte.MAX_VALUE) << 8)) | (bArr[i4 + 15] & UByte.MAX_VALUE));
        int i11 = 4;
        while (i11 < this.f4816w) {
            int[] iArr2 = f4799f;
            int i12 = iArr2[i7 >>> 24];
            int[] iArr3 = f4800g;
            int i13 = i12 ^ iArr3[(i8 >>> 16) & 255];
            int[] iArr4 = f4801h;
            int i14 = i13 ^ iArr4[(i9 >>> 8) & 255];
            int[] iArr5 = f4802i;
            int i15 = i14 ^ iArr5[i10 & 255];
            int[] iArr6 = this.f4815v;
            int i16 = i15 ^ iArr6[i11];
            int i17 = iArr6[i11 + 1] ^ (((iArr2[i8 >>> 24] ^ iArr3[(i9 >>> 16) & 255]) ^ iArr4[(i10 >>> 8) & 255]) ^ iArr5[i7 & 255]);
            int i18 = ((iArr3[(i10 >>> 16) & 255] ^ iArr2[i9 >>> 24]) ^ iArr4[(i7 >>> 8) & 255]) ^ iArr5[i8 & 255];
            int i19 = i11 + 3;
            int i20 = i18 ^ iArr6[i11 + 2];
            i11 += 4;
            i10 = iArr6[i19] ^ (((iArr3[(i7 >>> 16) & 255] ^ iArr2[i10 >>> 24]) ^ iArr4[(i8 >>> 8) & 255]) ^ iArr5[i9 & 255]);
            i9 = i20;
            i7 = i16;
            i8 = i17;
        }
        int[] iArr7 = this.f4815v;
        int i21 = iArr7[i11];
        byte[] bArr3 = f4797d;
        bArr2[i5] = (byte) (bArr3[i7 >>> 24] ^ (i21 >>> 24));
        bArr2[i5 + 1] = (byte) (bArr3[(i8 >>> 16) & 255] ^ (i21 >>> 16));
        bArr2[i5 + 2] = (byte) (bArr3[(i9 >>> 8) & 255] ^ (i21 >>> 8));
        bArr2[i5 + 3] = (byte) (i21 ^ bArr3[i10 & 255]);
        int i22 = iArr7[i11 + 1];
        bArr2[i5 + 4] = (byte) (bArr3[i8 >>> 24] ^ (i22 >>> 24));
        bArr2[i5 + 5] = (byte) (bArr3[(i9 >>> 16) & 255] ^ (i22 >>> 16));
        bArr2[i5 + 6] = (byte) (bArr3[(i10 >>> 8) & 255] ^ (i22 >>> 8));
        bArr2[i5 + 7] = (byte) (i22 ^ bArr3[i7 & 255]);
        int i23 = iArr7[i11 + 2];
        bArr2[i5 + 8] = (byte) (bArr3[i9 >>> 24] ^ (i23 >>> 24));
        bArr2[i5 + 9] = (byte) (bArr3[(i10 >>> 16) & 255] ^ (i23 >>> 16));
        bArr2[i5 + 10] = (byte) (bArr3[(i7 >>> 8) & 255] ^ (i23 >>> 8));
        bArr2[i5 + 11] = (byte) (i23 ^ bArr3[i8 & 255]);
        int i24 = iArr7[i11 + 3];
        bArr2[i5 + 12] = (byte) (bArr3[i10 >>> 24] ^ (i24 >>> 24));
        bArr2[i5 + 13] = (byte) (bArr3[(i7 >>> 16) & 255] ^ (i24 >>> 16));
        bArr2[i5 + 14] = (byte) (bArr3[(i8 >>> 8) & 255] ^ (i24 >>> 8));
        bArr2[i5 + 15] = (byte) (i24 ^ bArr3[i9 & 255]);
    }

    public static final boolean a(int i4) {
        int i5 = 0;
        while (true) {
            int[] iArr = a.f4794a;
            if (i5 >= iArr.length) {
                return false;
            }
            if (i4 == iArr[i5]) {
                return true;
            }
            i5++;
        }
    }

    private static Object[] a(byte[] bArr) throws InvalidKeyException {
        int i4;
        int i5;
        if (bArr == null) {
            throw new InvalidKeyException("Empty key");
        }
        if (!a(bArr.length)) {
            throw new InvalidKeyException(AbstractC0831a.d(new StringBuilder("Invalid AES key length: "), bArr.length, " bytes"));
        }
        int iB = b(bArr.length);
        int i6 = iB + 1;
        int i7 = i6 * 4;
        Class cls = Integer.TYPE;
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) cls, i6, 4);
        int[][] iArr2 = (int[][]) Array.newInstance((Class<?>) cls, i6, 4);
        int length = bArr.length / 4;
        int[] iArr3 = new int[length];
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        while (i9 < length) {
            iArr3[i9] = ((bArr[i10 + 2] & UByte.MAX_VALUE) << 8) | (bArr[i10] << 24) | ((bArr[i10 + 1] & UByte.MAX_VALUE) << 16) | (bArr[i10 + 3] & UByte.MAX_VALUE);
            i9++;
            i10 += 4;
        }
        int i11 = 0;
        int i12 = 0;
        while (i11 < length && i12 < i7) {
            int i13 = i12 / 4;
            int i14 = i12 % 4;
            iArr[i13][i14] = iArr3[i11];
            iArr2[iB - i13][i14] = iArr3[i11];
            i11++;
            i12++;
        }
        int i15 = 0;
        while (true) {
            if (i12 >= i7) {
                break;
            }
            int i16 = iArr3[length - 1];
            int i17 = iArr3[i8];
            byte[] bArr2 = f4797d;
            int i18 = ((((bArr2[(i16 >>> 8) & 255] & UByte.MAX_VALUE) << 16) ^ (bArr2[(i16 >>> 16) & 255] << 24)) ^ ((bArr2[i16 & 255] & UByte.MAX_VALUE) << 8)) ^ (bArr2[i16 >>> 24] & UByte.MAX_VALUE);
            int i19 = i15 + 1;
            iArr3[i8] = ((f4811r[i15] << 24) ^ i18) ^ i17;
            int i20 = i8;
            int i21 = 1;
            if (length != 8) {
                while (i21 < length) {
                    iArr3[i21] = iArr3[i21] ^ iArr3[i20];
                    i21++;
                    i20++;
                }
            } else {
                while (true) {
                    i5 = length / 2;
                    if (i21 >= i5) {
                        break;
                    }
                    iArr3[i21] = iArr3[i21] ^ iArr3[i20];
                    i21++;
                    i20++;
                }
                int i22 = iArr3[i5 - 1];
                int i23 = iArr3[i5];
                byte[] bArr3 = f4797d;
                iArr3[i5] = ((bArr3[i22 >>> 24] << 24) ^ ((((bArr3[(i22 >>> 8) & 255] & UByte.MAX_VALUE) << 8) ^ (bArr3[i22 & 255] & UByte.MAX_VALUE)) ^ ((bArr3[(i22 >>> 16) & 255] & UByte.MAX_VALUE) << 16))) ^ i23;
                int i24 = i5 + 1;
                while (i24 < length) {
                    iArr3[i24] = iArr3[i24] ^ iArr3[i5];
                    i24++;
                    i5++;
                }
            }
            int i25 = 0;
            while (i25 < length && i12 < i7) {
                int i26 = i12 / 4;
                int i27 = i12 % 4;
                iArr[i26][i27] = iArr3[i25];
                iArr2[iB - i26][i27] = iArr3[i25];
                i25++;
                i12++;
            }
            i15 = i19;
            i8 = 0;
        }
        for (i4 = 1; i4 < iB; i4++) {
            for (int i28 = 0; i28 < 4; i28++) {
                int[] iArr4 = iArr2[i4];
                int i29 = iArr4[i28];
                iArr4[i28] = f4810q[i29 & 255] ^ ((f4807n[(i29 >>> 24) & 255] ^ f4808o[(i29 >>> 16) & 255]) ^ f4809p[(i29 >>> 8) & 255]);
            }
        }
        return new Object[]{iArr, iArr2};
    }
}
