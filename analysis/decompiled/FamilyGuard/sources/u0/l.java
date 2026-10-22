package u0;

import java.lang.reflect.Array;
import java.math.BigInteger;
import org.libpag.BuildConfig;

/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    private static final int[][] f22798a;

    /* renamed from: b, reason: collision with root package name */
    private static final int[][] f22799b;

    static {
        Class cls = Integer.TYPE;
        f22798a = (int[][]) Array.newInstance((Class<?>) cls, 326, 4);
        f22799b = (int[][]) Array.newInstance((Class<?>) cls, 291, 4);
        BigInteger bigInteger = BigInteger.ONE;
        BigInteger bigIntegerSubtract = bigInteger.shiftLeft(31).subtract(bigInteger);
        BigInteger bigIntegerSubtract2 = bigInteger.shiftLeft(31).subtract(bigInteger);
        int i5 = 0;
        while (i5 < 326) {
            BigInteger bigIntegerPow = BigInteger.valueOf(5L).pow(i5);
            int iBitLength = bigIntegerPow.bitLength();
            int i6 = i5 == 0 ? 1 : (int) (((i5 * 23219280) + 9999999) / 10000000);
            if (i6 != iBitLength) {
                throw new IllegalStateException(iBitLength + " != " + i6);
            }
            if (i5 < f22798a.length) {
                for (int i7 = 0; i7 < 4; i7++) {
                    f22798a[i5][i7] = bigIntegerPow.shiftRight((iBitLength - 121) + ((3 - i7) * 31)).and(bigIntegerSubtract).intValue();
                }
            }
            if (i5 < f22799b.length) {
                BigInteger bigInteger2 = BigInteger.ONE;
                BigInteger bigIntegerAdd = bigInteger2.shiftLeft(iBitLength + 121).divide(bigIntegerPow).add(bigInteger2);
                for (int i8 = 0; i8 < 4; i8++) {
                    if (i8 == 0) {
                        f22799b[i5][i8] = bigIntegerAdd.shiftRight((3 - i8) * 31).intValue();
                    } else {
                        f22799b[i5][i8] = bigIntegerAdd.shiftRight((3 - i8) * 31).and(bigIntegerSubtract2).intValue();
                    }
                }
            }
            i5++;
        }
    }

    public static int a(double d6, char[] cArr, int i5) {
        int i6;
        char c6;
        char c7;
        boolean z5;
        long j5;
        int i7;
        boolean z6;
        long j6;
        long j7;
        boolean z7;
        int i8;
        long j8;
        boolean z8;
        long j9;
        int i9;
        int i10;
        int i11;
        int i12;
        boolean z9;
        int i13;
        int i14;
        int i15;
        int i16;
        if (Double.isNaN(d6)) {
            cArr[i5] = 'N';
            cArr[i5 + 1] = 'a';
            i16 = i5 + 3;
            cArr[i5 + 2] = 'N';
        } else {
            if (d6 == Double.POSITIVE_INFINITY) {
                cArr[i5] = 'I';
                cArr[i5 + 1] = 'n';
                cArr[i5 + 2] = 'f';
                cArr[i5 + 3] = 'i';
                cArr[i5 + 4] = 'n';
                cArr[i5 + 5] = 'i';
                cArr[i5 + 6] = 't';
                cArr[i5 + 7] = 'y';
                return (i5 + 8) - i5;
            }
            if (d6 == Double.NEGATIVE_INFINITY) {
                cArr[i5] = '-';
                cArr[i5 + 1] = 'I';
                cArr[i5 + 2] = 'n';
                cArr[i5 + 3] = 'f';
                cArr[i5 + 4] = 'i';
                cArr[i5 + 5] = 'n';
                cArr[i5 + 6] = 'i';
                cArr[i5 + 7] = 't';
                i16 = i5 + 9;
                cArr[i5 + 8] = 'y';
            } else {
                long jDoubleToLongBits = Double.doubleToLongBits(d6);
                if (jDoubleToLongBits != 0) {
                    if (jDoubleToLongBits == Long.MIN_VALUE) {
                        cArr[i5] = '-';
                        cArr[i5 + 1] = '0';
                        cArr[i5 + 2] = '.';
                        i12 = i5 + 4;
                        cArr[i5 + 3] = '0';
                    } else {
                        int i17 = (int) ((jDoubleToLongBits >>> 52) & 2047);
                        long j10 = jDoubleToLongBits & 4503599627370495L;
                        if (i17 == 0) {
                            i6 = -1074;
                        } else {
                            i6 = i17 - 1075;
                            j10 |= 4503599627370496L;
                        }
                        boolean z10 = jDoubleToLongBits < 0;
                        boolean z11 = (j10 & 1) == 0;
                        long j11 = 4 * j10;
                        long j12 = j11 + 2;
                        int i18 = (j10 != 4503599627370496L || i17 <= 1) ? 1 : 0;
                        long j13 = (j11 - 1) - i18;
                        int i19 = i6 - 2;
                        int i20 = 3;
                        if (i19 >= 0) {
                            j5 = 10000000;
                            int iMax = Math.max(0, ((int) ((i19 * 3010299) / 10000000)) - 1);
                            int i21 = (((-i19) + iMax) + ((iMax == 0 ? 1 : (int) (((iMax * 23219280) + 9999999) / 10000000)) + 121)) - 114;
                            if (i21 < 0) {
                                throw new IllegalArgumentException(BuildConfig.FLAVOR + i21);
                            }
                            int[] iArr = f22799b[iMax];
                            long j14 = j11 >>> 31;
                            long j15 = j11 & 2147483647L;
                            int i22 = iArr[0];
                            c6 = '.';
                            c7 = '0';
                            int i23 = iArr[1];
                            int i24 = iArr[2];
                            z5 = z11;
                            i7 = 10;
                            int i25 = iArr[3];
                            long j16 = ((((((((((((j15 * i25) >>> 31) + (i24 * j15)) + (j14 * i25)) >>> 31) + (i23 * j15)) + (i24 * j14)) >>> 31) + (i22 * j15)) + (i23 * j14)) >>> 21) + ((i22 * j14) << 10)) >>> i21;
                            long j17 = j12 >>> 31;
                            long j18 = j12 & 2147483647L;
                            z6 = z10;
                            long j19 = ((((((((((((j18 * i25) >>> 31) + (i24 * j18)) + (j17 * i25)) >>> 31) + (i23 * j18)) + (i24 * j17)) >>> 31) + (i22 * j18)) + (i23 * j17)) >>> 21) + ((i22 * j17) << 10)) >>> i21;
                            long j20 = j13 >>> 31;
                            long j21 = j13 & 2147483647L;
                            j7 = j19;
                            j8 = ((((((((((((j21 * i25) >>> 31) + (i24 * j21)) + (j20 * i25)) >>> 31) + (i23 * j21)) + (i24 * j20)) >>> 31) + (i22 * j21)) + (i23 * j20)) >>> 21) + ((i22 * j20) << 10)) >>> i21;
                            i8 = iMax;
                            if (i8 <= 21) {
                                long j22 = j11 % 5;
                                if (j22 == 0) {
                                    if (j22 != 0) {
                                        i15 = 0;
                                    } else if (j11 % 25 != 0) {
                                        i15 = 1;
                                    } else if (j11 % 125 != 0) {
                                        i15 = 2;
                                    } else if (j11 % 625 != 0) {
                                        i15 = 3;
                                    } else {
                                        long j23 = j11 / 625;
                                        i15 = 4;
                                        while (j23 > 0 && j23 % 5 == 0) {
                                            j23 /= 5;
                                            i15++;
                                        }
                                    }
                                    z9 = i15 >= i8;
                                    z8 = false;
                                    z7 = z9;
                                    j6 = j16;
                                } else if (z5) {
                                    if (j13 % 5 != 0) {
                                        i14 = 0;
                                    } else if (j13 % 25 != 0) {
                                        i14 = 1;
                                    } else if (j13 % 125 != 0) {
                                        i14 = 2;
                                    } else if (j13 % 625 != 0) {
                                        i14 = 3;
                                    } else {
                                        long j24 = j13 / 625;
                                        i14 = 4;
                                        while (j24 > 0 && j24 % 5 == 0) {
                                            j24 /= 5;
                                            i14++;
                                        }
                                    }
                                    z8 = i14 >= i8;
                                    z9 = false;
                                    z7 = z9;
                                    j6 = j16;
                                } else {
                                    if (j12 % 5 != 0) {
                                        i13 = 0;
                                    } else if (j12 % 25 != 0) {
                                        i13 = 1;
                                    } else if (j12 % 125 != 0) {
                                        i13 = 2;
                                    } else if (j12 % 625 != 0) {
                                        i13 = 3;
                                    } else {
                                        long j25 = j12 / 625;
                                        i13 = 4;
                                        while (j25 > 0 && j25 % 5 == 0) {
                                            j25 /= 5;
                                            i13++;
                                        }
                                    }
                                    if (i13 >= i8) {
                                        j7--;
                                    }
                                }
                                z8 = false;
                                z7 = z9;
                                j6 = j16;
                            } else {
                                z8 = false;
                                z7 = z9;
                                j6 = j16;
                            }
                        } else {
                            c6 = '.';
                            c7 = '0';
                            z5 = z11;
                            j5 = 10000000;
                            i7 = 10;
                            z6 = z10;
                            int iMax2 = Math.max(0, ((int) ((r0 * 6989700) / 10000000)) - 1);
                            int i26 = (-i19) - iMax2;
                            int i27 = (iMax2 - ((i26 == 0 ? 1 : (int) (((i26 * 23219280) + 9999999) / 10000000)) - 121)) - 114;
                            if (i27 < 0) {
                                throw new IllegalArgumentException(BuildConfig.FLAVOR + i27);
                            }
                            int[] iArr2 = f22798a[i26];
                            long j26 = j11 >>> 31;
                            long j27 = j11 & 2147483647L;
                            int i28 = iArr2[0];
                            int i29 = iArr2[1];
                            int i30 = iArr2[2];
                            int i31 = iArr2[3];
                            long j28 = ((((((((((((j27 * i31) >>> 31) + (i30 * j27)) + (i31 * j26)) >>> 31) + (i29 * j27)) + (i30 * j26)) >>> 31) + (i28 * j27)) + (i29 * j26)) >>> 21) + ((i28 * j26) << 10)) >>> i27;
                            long j29 = j12 >>> 31;
                            long j30 = j12 & 2147483647L;
                            j6 = j28;
                            j7 = ((((((((((((j30 * i31) >>> 31) + (i30 * j30)) + (j29 * i31)) >>> 31) + (i29 * j30)) + (i30 * j29)) >>> 31) + (i28 * j30)) + (i29 * j29)) >>> 21) + ((i28 * j29) << 10)) >>> i27;
                            long j31 = j13 >>> 31;
                            long j32 = j13 & 2147483647L;
                            long j33 = ((((((((((((j32 * i31) >>> 31) + (i30 * j32)) + (i31 * j31)) >>> 31) + (i29 * j32)) + (i30 * j31)) >>> 31) + (i28 * j32)) + (i29 * j31)) >>> 21) + ((i28 * j31) << 10)) >>> i27;
                            int i32 = iMax2 + i19;
                            z7 = true;
                            if (iMax2 <= 1) {
                                if (z5) {
                                    boolean z12 = i18 == 1;
                                    i8 = i32;
                                    j8 = j33;
                                    z8 = z12;
                                } else {
                                    j7--;
                                    i8 = i32;
                                }
                            } else if (iMax2 < 63) {
                                i8 = i32;
                                z7 = (((1 << (iMax2 - 1)) - 1) & j11) == 0;
                            } else {
                                i8 = i32;
                                j8 = j33;
                                z7 = false;
                                z8 = false;
                            }
                            j8 = j33;
                            z8 = false;
                        }
                        if (j7 >= 1000000000000000000L) {
                            i20 = 19;
                        } else if (j7 >= 100000000000000000L) {
                            i20 = 18;
                        } else if (j7 >= 10000000000000000L) {
                            i20 = 17;
                        } else if (j7 >= 1000000000000000L) {
                            i20 = 16;
                        } else if (j7 >= 100000000000000L) {
                            i20 = 15;
                        } else if (j7 >= 10000000000000L) {
                            i20 = 14;
                        } else if (j7 >= 1000000000000L) {
                            i20 = 13;
                        } else if (j7 >= 100000000000L) {
                            i20 = 12;
                        } else if (j7 >= 10000000000L) {
                            i20 = 11;
                        } else if (j7 >= 1000000000) {
                            i20 = i7;
                        } else if (j7 >= 100000000) {
                            i20 = 9;
                        } else if (j7 >= j5) {
                            i20 = 8;
                        } else if (j7 >= 1000000) {
                            i20 = 7;
                        } else if (j7 >= 100000) {
                            i20 = 6;
                        } else if (j7 >= 10000) {
                            i20 = 5;
                        } else if (j7 >= 1000) {
                            i20 = 4;
                        } else if (j7 < 100) {
                            i20 = j7 >= 10 ? 2 : 1;
                        }
                        int i33 = i8 + i20;
                        int i34 = i33 - 1;
                        boolean z13 = i34 < -3 || i34 >= 7;
                        if (z8 || z7) {
                            int i35 = 0;
                            int i36 = 0;
                            while (true) {
                                long j34 = j7 / 10;
                                long j35 = j8 / 10;
                                if (j34 <= j35 || (j7 < 100 && z13)) {
                                    break;
                                }
                                z8 &= j8 % 10 == 0;
                                z7 &= i35 == 0;
                                i35 = (int) (j6 % 10);
                                j6 /= 10;
                                i36++;
                                j7 = j34;
                                j8 = j35;
                            }
                            if (z8 && z5) {
                                while (j8 % 10 == 0 && (j7 >= 100 || !z13)) {
                                    z7 &= i35 == 0;
                                    i35 = (int) (j6 % 10);
                                    j7 /= 10;
                                    j6 /= 10;
                                    j8 /= 10;
                                    i36++;
                                }
                            }
                            if (z7 && i35 == 5 && j6 % 2 == 0) {
                                i35 = 4;
                            }
                            j9 = j6 + (((j6 != j8 || (z8 && z5)) && i35 < 5) ? 0 : 1);
                            i9 = i36;
                        } else {
                            i9 = 0;
                            int i37 = 0;
                            while (true) {
                                long j36 = j7 / 10;
                                long j37 = j8 / 10;
                                if (j36 <= j37 || (j7 < 100 && z13)) {
                                    break;
                                }
                                i37 = (int) (j6 % 10);
                                j6 /= 10;
                                i9++;
                                j7 = j36;
                                j8 = j37;
                            }
                            j9 = j6 + ((j6 == j8 || i37 >= 5) ? 1 : 0);
                        }
                        int i38 = i20 - i9;
                        if (z6) {
                            i10 = i5 + 1;
                            cArr[i5] = '-';
                        } else {
                            i10 = i5;
                        }
                        if (!z13) {
                            if (i34 < 0) {
                                int i39 = i10 + 1;
                                cArr[i10] = c7;
                                int i40 = i10 + 2;
                                cArr[i39] = c6;
                                int i41 = -1;
                                while (i41 > i34) {
                                    cArr[i40] = c7;
                                    i41--;
                                    i40++;
                                }
                                i11 = i40;
                                for (int i42 = 0; i42 < i38; i42++) {
                                    cArr[((i40 + i38) - i42) - 1] = (char) ((j9 % 10) + 48);
                                    j9 /= 10;
                                    i11++;
                                }
                            } else if (i33 >= i38) {
                                for (int i43 = 0; i43 < i38; i43++) {
                                    cArr[((i10 + i38) - i43) - 1] = (char) ((j9 % 10) + 48);
                                    j9 /= 10;
                                }
                                int i44 = i10 + i38;
                                while (i38 < i33) {
                                    cArr[i44] = c7;
                                    i38++;
                                    i44++;
                                }
                                cArr[i44] = c6;
                                i11 = i44 + 2;
                                cArr[i44 + 1] = c7;
                            } else {
                                int i45 = i10 + 1;
                                for (int i46 = 0; i46 < i38; i46++) {
                                    if ((i38 - i46) - 1 == i34) {
                                        cArr[((i45 + i38) - i46) - 1] = c6;
                                        i45--;
                                    }
                                    cArr[((i45 + i38) - i46) - 1] = (char) ((j9 % 10) + 48);
                                    j9 /= 10;
                                }
                                i11 = i10 + i38 + 1;
                            }
                            return i11 - i5;
                        }
                        for (int i47 = 0; i47 < i38 - 1; i47++) {
                            int i48 = (int) (j9 % 10);
                            j9 /= 10;
                            cArr[(i10 + i38) - i47] = (char) (i48 + 48);
                        }
                        cArr[i10] = (char) ((j9 % 10) + 48);
                        cArr[i10 + 1] = c6;
                        int i49 = i10 + i38 + 1;
                        if (i38 == 1) {
                            cArr[i49] = c7;
                            i49++;
                        }
                        int i50 = i49 + 1;
                        cArr[i49] = 'E';
                        if (i34 < 0) {
                            cArr[i50] = '-';
                            i34 = -i34;
                            i50 = i49 + 2;
                        }
                        if (i34 >= 100) {
                            int i51 = i50 + 1;
                            cArr[i50] = (char) ((i34 / 100) + 48);
                            i34 %= 100;
                            i50 += 2;
                            cArr[i51] = (char) ((i34 / 10) + 48);
                        } else if (i34 >= i7) {
                            cArr[i50] = (char) ((i34 / 10) + 48);
                            i50++;
                        }
                        i12 = i50 + 1;
                        cArr[i50] = (char) ((i34 % 10) + 48);
                    }
                    return i12 - i5;
                }
                cArr[i5] = '0';
                cArr[i5 + 1] = '.';
                i16 = i5 + 3;
                cArr[i5 + 2] = '0';
            }
        }
        return i16 - i5;
    }

    public static String b(double d6) {
        char[] cArr = new char[24];
        return new String(cArr, 0, a(d6, cArr, 0));
    }
}
