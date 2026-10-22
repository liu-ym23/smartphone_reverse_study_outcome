package T1;

/* loaded from: classes.dex */
public class a {

    /* renamed from: T1.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC0102a {

        /* renamed from: a, reason: collision with root package name */
        public byte[] f5837a;

        /* renamed from: b, reason: collision with root package name */
        public int f5838b;
    }

    public static class b extends AbstractC0102a {

        /* renamed from: f, reason: collision with root package name */
        public static final int[] f5839f = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

        /* renamed from: g, reason: collision with root package name */
        public static final int[] f5840g = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

        /* renamed from: c, reason: collision with root package name */
        public int f5841c;

        /* renamed from: d, reason: collision with root package name */
        public int f5842d;

        /* renamed from: e, reason: collision with root package name */
        public final int[] f5843e;

        public b(int i10, byte[] bArr) {
            this.f5837a = bArr;
            this.f5843e = (i10 & 8) == 0 ? f5839f : f5840g;
            this.f5841c = 0;
            this.f5842d = 0;
        }

        public boolean a(byte[] bArr, int i10, int i11, boolean z10) {
            int i12 = this.f5841c;
            if (i12 == 6) {
                return false;
            }
            int i13 = i11 + i10;
            int i14 = this.f5842d;
            byte[] bArr2 = this.f5837a;
            int[] iArr = this.f5843e;
            int i15 = 0;
            int i16 = i14;
            int i17 = i12;
            int i18 = i10;
            while (i18 < i13) {
                if (i17 == 0) {
                    while (true) {
                        int i19 = i18 + 4;
                        if (i19 > i13 || (i16 = (iArr[bArr[i18] & 255] << 18) | (iArr[bArr[i18 + 1] & 255] << 12) | (iArr[bArr[i18 + 2] & 255] << 6) | iArr[bArr[i18 + 3] & 255]) < 0) {
                            break;
                        }
                        bArr2[i15 + 2] = (byte) i16;
                        bArr2[i15 + 1] = (byte) (i16 >> 8);
                        bArr2[i15] = (byte) (i16 >> 16);
                        i15 += 3;
                        i18 = i19;
                    }
                    if (i18 >= i13) {
                        break;
                    }
                }
                int i20 = i18 + 1;
                int i21 = iArr[bArr[i18] & 255];
                if (i17 != 0) {
                    if (i17 == 1) {
                        if (i21 < 0) {
                            if (i21 != -1) {
                                this.f5841c = 6;
                                return false;
                            }
                        }
                        i21 |= i16 << 6;
                    } else if (i17 == 2) {
                        if (i21 < 0) {
                            if (i21 == -2) {
                                bArr2[i15] = (byte) (i16 >> 4);
                                i15++;
                                i17 = 4;
                            } else if (i21 != -1) {
                                this.f5841c = 6;
                                return false;
                            }
                        }
                        i21 |= i16 << 6;
                    } else if (i17 != 3) {
                        if (i17 != 4) {
                            if (i17 == 5 && i21 != -1) {
                                this.f5841c = 6;
                                return false;
                            }
                        } else if (i21 == -2) {
                            i17++;
                        } else if (i21 != -1) {
                            this.f5841c = 6;
                            return false;
                        }
                    } else if (i21 >= 0) {
                        int i22 = i21 | (i16 << 6);
                        bArr2[i15 + 2] = (byte) i22;
                        bArr2[i15 + 1] = (byte) (i22 >> 8);
                        bArr2[i15] = (byte) (i22 >> 16);
                        i15 += 3;
                        i16 = i22;
                        i17 = 0;
                    } else if (i21 == -2) {
                        bArr2[i15 + 1] = (byte) (i16 >> 2);
                        bArr2[i15] = (byte) (i16 >> 10);
                        i15 += 2;
                        i17 = 5;
                    } else if (i21 != -1) {
                        this.f5841c = 6;
                        return false;
                    }
                    i17++;
                    i16 = i21;
                } else if (i21 >= 0) {
                    i17++;
                    i16 = i21;
                } else if (i21 != -1) {
                    this.f5841c = 6;
                    return false;
                }
                i18 = i20;
            }
            if (!z10) {
                this.f5841c = i17;
                this.f5842d = i16;
                this.f5838b = i15;
                return true;
            }
            if (i17 == 1) {
                this.f5841c = 6;
                return false;
            }
            if (i17 == 2) {
                bArr2[i15] = (byte) (i16 >> 4);
                i15++;
            } else if (i17 == 3) {
                int i23 = i15 + 1;
                bArr2[i15] = (byte) (i16 >> 10);
                i15 += 2;
                bArr2[i23] = (byte) (i16 >> 2);
            } else if (i17 == 4) {
                this.f5841c = 6;
                return false;
            }
            this.f5841c = i17;
            this.f5838b = i15;
            return true;
        }
    }

    public static byte[] a(byte[] bArr, int i10) {
        return b(bArr, 0, bArr.length, i10);
    }

    public static byte[] b(byte[] bArr, int i10, int i11, int i12) {
        b bVar = new b(i12, new byte[(i11 * 3) / 4]);
        if (!bVar.a(bArr, i10, i11, true)) {
            throw new IllegalArgumentException("bad base-64");
        }
        int i13 = bVar.f5838b;
        byte[] bArr2 = bVar.f5837a;
        if (i13 == bArr2.length) {
            return bArr2;
        }
        byte[] bArr3 = new byte[i13];
        System.arraycopy(bArr2, 0, bArr3, 0, i13);
        return bArr3;
    }
}
