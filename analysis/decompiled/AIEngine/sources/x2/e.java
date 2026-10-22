package x2;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final String f13727a = String.valueOf(Integer.MIN_VALUE);

    /* renamed from: b, reason: collision with root package name */
    public static final String f13728b = String.valueOf(Long.MIN_VALUE);

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f13729c = new int[1000];

    static {
        int i10 = 0;
        for (int i11 = 0; i11 < 10; i11++) {
            for (int i12 = 0; i12 < 10; i12++) {
                int i13 = 0;
                while (i13 < 10) {
                    f13729c[i10] = ((i11 + 48) << 16) | ((i12 + 48) << 8) | (i13 + 48);
                    i13++;
                    i10++;
                }
            }
        }
    }

    public static int a(byte[] bArr, int i10, int i11) {
        int i12 = f13729c[i10];
        bArr[i11] = (byte) (i12 >> 16);
        int i13 = i11 + 2;
        bArr[i11 + 1] = (byte) (i12 >> 8);
        int i14 = i11 + 3;
        bArr[i13] = (byte) i12;
        return i14;
    }

    public static int b(char[] cArr, int i10, int i11) {
        int i12 = f13729c[i10];
        cArr[i11] = (char) (i12 >> 16);
        int i13 = i11 + 2;
        cArr[i11 + 1] = (char) ((i12 >> 8) & 127);
        int i14 = i11 + 3;
        cArr[i13] = (char) (i12 & 127);
        return i14;
    }

    public static int c(byte[] bArr, int i10, int i11) {
        int i12 = f13729c[i10];
        if (i10 > 9) {
            if (i10 > 99) {
                bArr[i11] = (byte) (i12 >> 16);
                i11++;
            }
            bArr[i11] = (byte) (i12 >> 8);
            i11++;
        }
        int i13 = i11 + 1;
        bArr[i11] = (byte) i12;
        return i13;
    }

    public static int d(char[] cArr, int i10, int i11) {
        int i12 = f13729c[i10];
        if (i10 > 9) {
            if (i10 > 99) {
                cArr[i11] = (char) (i12 >> 16);
                i11++;
            }
            cArr[i11] = (char) ((i12 >> 8) & 127);
            i11++;
        }
        int i13 = i11 + 1;
        cArr[i11] = (char) (i12 & 127);
        return i13;
    }

    public static int e(byte[] bArr, int i10, int i11) {
        int i12 = i10 / 1000;
        int i13 = i10 - (i12 * 1000);
        int i14 = i12 / 1000;
        int i15 = i12 - (i14 * 1000);
        int[] iArr = f13729c;
        int i16 = iArr[i14];
        bArr[i11] = (byte) (i16 >> 16);
        bArr[i11 + 1] = (byte) (i16 >> 8);
        bArr[i11 + 2] = (byte) i16;
        int i17 = iArr[i15];
        bArr[i11 + 3] = (byte) (i17 >> 16);
        bArr[i11 + 4] = (byte) (i17 >> 8);
        bArr[i11 + 5] = (byte) i17;
        int i18 = iArr[i13];
        bArr[i11 + 6] = (byte) (i18 >> 16);
        int i19 = i11 + 8;
        bArr[i11 + 7] = (byte) (i18 >> 8);
        int i20 = i11 + 9;
        bArr[i19] = (byte) i18;
        return i20;
    }

    public static int f(char[] cArr, int i10, int i11) {
        int i12 = i10 / 1000;
        int i13 = i10 - (i12 * 1000);
        int i14 = i12 / 1000;
        int[] iArr = f13729c;
        int i15 = iArr[i14];
        cArr[i11] = (char) (i15 >> 16);
        cArr[i11 + 1] = (char) ((i15 >> 8) & 127);
        cArr[i11 + 2] = (char) (i15 & 127);
        int i16 = iArr[i12 - (i14 * 1000)];
        cArr[i11 + 3] = (char) (i16 >> 16);
        cArr[i11 + 4] = (char) ((i16 >> 8) & 127);
        cArr[i11 + 5] = (char) (i16 & 127);
        int i17 = iArr[i13];
        cArr[i11 + 6] = (char) (i17 >> 16);
        int i18 = i11 + 8;
        cArr[i11 + 7] = (char) ((i17 >> 8) & 127);
        int i19 = i11 + 9;
        cArr[i18] = (char) (i17 & 127);
        return i19;
    }

    public static int g(byte[] bArr, int i10, int i11) {
        int i12;
        if (i10 < 0) {
            if (i10 == Integer.MIN_VALUE) {
                String str = f13727a;
                int length = str.length();
                int i13 = 0;
                while (i13 < length) {
                    bArr[i11] = (byte) str.charAt(i13);
                    i13++;
                    i11++;
                }
                return i11;
            }
            bArr[i11] = 45;
            i10 = -i10;
            i11++;
        }
        if (i10 < 1000000) {
            if (i10 >= 1000) {
                int i14 = i10 / 1000;
                return a(bArr, i10 - (i14 * 1000), c(bArr, i14, i11));
            }
            if (i10 >= 10) {
                return c(bArr, i10, i11);
            }
            int i15 = i11 + 1;
            bArr[i11] = (byte) (i10 + 48);
            return i15;
        }
        if (i10 < 1000000000) {
            int i16 = i10 / 1000;
            int i17 = i16 / 1000;
            return a(bArr, i10 - (i16 * 1000), a(bArr, i16 - (i17 * 1000), c(bArr, i17, i11)));
        }
        int i18 = i10 - 1000000000;
        if (i18 >= 1000000000) {
            i18 = i10 - 2000000000;
            i12 = i11 + 1;
            bArr[i11] = 50;
        } else {
            i12 = i11 + 1;
            bArr[i11] = 49;
        }
        return e(bArr, i18, i12);
    }

    public static int h(char[] cArr, int i10, int i11) {
        int i12;
        if (i10 < 0) {
            if (i10 == Integer.MIN_VALUE) {
                String str = f13727a;
                int length = str.length();
                str.getChars(0, length, cArr, i11);
                return length + i11;
            }
            cArr[i11] = '-';
            i10 = -i10;
            i11++;
        }
        if (i10 < 1000000) {
            if (i10 >= 1000) {
                int i13 = i10 / 1000;
                return b(cArr, i10 - (i13 * 1000), d(cArr, i13, i11));
            }
            if (i10 >= 10) {
                return d(cArr, i10, i11);
            }
            cArr[i11] = (char) (i10 + 48);
            return i11 + 1;
        }
        if (i10 < 1000000000) {
            int i14 = i10 / 1000;
            int i15 = i14 / 1000;
            return b(cArr, i10 - (i14 * 1000), b(cArr, i14 - (i15 * 1000), d(cArr, i15, i11)));
        }
        int i16 = i10 - 1000000000;
        if (i16 >= 1000000000) {
            i16 = i10 - 2000000000;
            i12 = i11 + 1;
            cArr[i11] = '2';
        } else {
            i12 = i11 + 1;
            cArr[i11] = '1';
        }
        return f(cArr, i16, i12);
    }

    public static int i(long j10, byte[] bArr, int i10) {
        int iE;
        if (j10 < 0) {
            if (j10 > -2147483648L) {
                return g(bArr, (int) j10, i10);
            }
            if (j10 == Long.MIN_VALUE) {
                String str = f13728b;
                int length = str.length();
                int i11 = 0;
                while (i11 < length) {
                    bArr[i10] = (byte) str.charAt(i11);
                    i11++;
                    i10++;
                }
                return i10;
            }
            bArr[i10] = 45;
            j10 = -j10;
            i10++;
        } else if (j10 <= 2147483647L) {
            return g(bArr, (int) j10, i10);
        }
        long j11 = j10 / 1000000000;
        long j12 = j10 - (j11 * 1000000000);
        if (j11 < 1000000000) {
            int i12 = (int) j11;
            int[] iArr = f13729c;
            if (i12 >= 1000000) {
                int i13 = i12 / 1000;
                int i14 = i12 - (i13 * 1000);
                int i15 = i13 / 1000;
                int iC = c(bArr, i15, i10);
                int i16 = iArr[i13 - (i15 * 1000)];
                bArr[iC] = (byte) (i16 >> 16);
                bArr[iC + 1] = (byte) (i16 >> 8);
                bArr[iC + 2] = (byte) i16;
                int i17 = iArr[i14];
                bArr[iC + 3] = (byte) (i17 >> 16);
                int i18 = iC + 5;
                bArr[iC + 4] = (byte) (i17 >> 8);
                iE = iC + 6;
                bArr[i18] = (byte) i17;
            } else if (i12 < 1000) {
                iE = c(bArr, i12, i10);
            } else {
                int i19 = i12 / 1000;
                int i20 = i12 - (i19 * 1000);
                int i21 = iArr[i19];
                if (i19 > 9) {
                    if (i19 > 99) {
                        bArr[i10] = (byte) (i21 >> 16);
                        i10++;
                    }
                    bArr[i10] = (byte) (i21 >> 8);
                    i10++;
                }
                bArr[i10] = (byte) i21;
                int i22 = iArr[i20];
                bArr[i10 + 1] = (byte) (i22 >> 16);
                int i23 = i10 + 3;
                bArr[i10 + 2] = (byte) (i22 >> 8);
                iE = i10 + 4;
                bArr[i23] = (byte) i22;
            }
        } else {
            long j13 = j11 / 1000000000;
            int iC2 = c(bArr, (int) j13, i10);
            iE = e(bArr, (int) (j11 - (1000000000 * j13)), iC2);
        }
        return e(bArr, (int) j12, iE);
    }

    public static int j(long j10, char[] cArr, int i10) {
        int iF;
        if (j10 < 0) {
            if (j10 > -2147483648L) {
                return h(cArr, (int) j10, i10);
            }
            if (j10 == Long.MIN_VALUE) {
                String str = f13728b;
                int length = str.length();
                str.getChars(0, length, cArr, i10);
                return length + i10;
            }
            cArr[i10] = '-';
            j10 = -j10;
            i10++;
        } else if (j10 <= 2147483647L) {
            return h(cArr, (int) j10, i10);
        }
        long j11 = j10 / 1000000000;
        long j12 = j10 - (j11 * 1000000000);
        if (j11 < 1000000000) {
            int i11 = (int) j11;
            int[] iArr = f13729c;
            if (i11 >= 1000000) {
                int i12 = i11 / 1000;
                int i13 = i11 - (i12 * 1000);
                int i14 = i12 / 1000;
                int iD = d(cArr, i14, i10);
                int i15 = iArr[i12 - (i14 * 1000)];
                cArr[iD] = (char) (i15 >> 16);
                cArr[iD + 1] = (char) ((i15 >> 8) & 127);
                cArr[iD + 2] = (char) (i15 & 127);
                int i16 = iArr[i13];
                cArr[iD + 3] = (char) (i16 >> 16);
                int i17 = iD + 5;
                cArr[iD + 4] = (char) ((i16 >> 8) & 127);
                iF = iD + 6;
                cArr[i17] = (char) (i16 & 127);
            } else if (i11 < 1000) {
                iF = d(cArr, i11, i10);
            } else {
                int i18 = i11 / 1000;
                int i19 = i11 - (i18 * 1000);
                int i20 = iArr[i18];
                if (i18 > 9) {
                    if (i18 > 99) {
                        cArr[i10] = (char) (i20 >> 16);
                        i10++;
                    }
                    cArr[i10] = (char) ((i20 >> 8) & 127);
                    i10++;
                }
                cArr[i10] = (char) (i20 & 127);
                int i21 = iArr[i19];
                cArr[i10 + 1] = (char) (i21 >> 16);
                int i22 = i10 + 3;
                cArr[i10 + 2] = (char) ((i21 >> 8) & 127);
                iF = i10 + 4;
                cArr[i22] = (char) (i21 & 127);
            }
        } else {
            long j13 = j11 / 1000000000;
            int iD2 = d(cArr, (int) j13, i10);
            iF = f(cArr, (int) (j11 - (1000000000 * j13)), iD2);
        }
        return f(cArr, (int) j12, iF);
    }
}
