package com.google.protobuf;

/* loaded from: classes.dex */
public final class j4 extends w7.e0 {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f2417c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ j4(int i2) {
        super(10);
        this.f2417c = i2;
    }

    public static int S(byte[] bArr, int i2, long j2, int i10) {
        if (i10 == 0) {
            w7.e0 e0Var = l4.f2432a;
            if (i2 > -12) {
                return -1;
            }
            return i2;
        }
        if (i10 == 1) {
            return l4.c(i2, i4.g(j2, bArr));
        }
        if (i10 == 2) {
            return l4.d(i2, i4.g(j2, bArr), i4.g(j2 + 1, bArr));
        }
        throw new AssertionError();
    }

    @Override // w7.e0
    public final int H(byte[] bArr, int i2, int i10) {
        int i11;
        switch (this.f2417c) {
            case 0:
                break;
            default:
                if ((i2 | i10 | (bArr.length - i10)) < 0) {
                    throw new ArrayIndexOutOfBoundsException(String.format("Array length=%d, index=%d, limit=%d", Integer.valueOf(bArr.length), Integer.valueOf(i2), Integer.valueOf(i10)));
                }
                long j2 = i2;
                int i12 = (int) (i10 - j2);
                if (i12 < 16) {
                    i11 = 0;
                } else {
                    int i13 = 8 - (((int) j2) & 7);
                    i11 = 0;
                    long j4 = j2;
                    while (true) {
                        if (i11 < i13) {
                            long j10 = j4 + 1;
                            if (i4.g(j4, bArr) >= 0) {
                                i11++;
                                j4 = j10;
                            }
                        } else {
                            while (true) {
                                int i14 = i11 + 8;
                                if (i14 <= i12) {
                                    if ((i4.f2400c.h(i4.f2403f + j4, bArr) & (-9187201950435737472L)) == 0) {
                                        j4 += 8;
                                        i11 = i14;
                                    }
                                }
                            }
                            while (true) {
                                if (i11 < i12) {
                                    long j11 = j4 + 1;
                                    if (i4.g(j4, bArr) >= 0) {
                                        i11++;
                                        j4 = j11;
                                    }
                                } else {
                                    i11 = i12;
                                }
                            }
                        }
                    }
                }
                int i15 = i12 - i11;
                long j12 = j2 + i11;
                while (true) {
                    byte bG = 0;
                    while (true) {
                        if (i15 > 0) {
                            long j13 = j12 + 1;
                            bG = i4.g(j12, bArr);
                            if (bG >= 0) {
                                i15--;
                                j12 = j13;
                            } else {
                                j12 = j13;
                            }
                        }
                    }
                    if (i15 == 0) {
                        return 0;
                    }
                    int i16 = i15 - 1;
                    if (bG < -32) {
                        if (i16 == 0) {
                            return bG;
                        }
                        i15 -= 2;
                        if (bG >= -62) {
                            long j14 = j12 + 1;
                            if (i4.g(j12, bArr) <= -65) {
                                j12 = j14;
                            }
                        }
                    } else if (bG < -16) {
                        if (i16 < 2) {
                            return S(bArr, bG, j12, i16);
                        }
                        i15 -= 3;
                        long j15 = j12 + 1;
                        byte bG2 = i4.g(j12, bArr);
                        if (bG2 <= -65 && ((bG != -32 || bG2 >= -96) && (bG != -19 || bG2 < -96))) {
                            j12 += 2;
                            if (i4.g(j15, bArr) > -65) {
                            }
                        }
                    } else {
                        if (i16 < 3) {
                            return S(bArr, bG, j12, i16);
                        }
                        i15 -= 4;
                        long j16 = j12 + 1;
                        byte bG3 = i4.g(j12, bArr);
                        if (bG3 <= -65) {
                            if ((((bG3 + 112) + (bG << 28)) >> 30) == 0) {
                                long j17 = 2 + j12;
                                if (i4.g(j16, bArr) <= -65) {
                                    j12 += 3;
                                    if (i4.g(j17, bArr) > -65) {
                                    }
                                }
                            }
                        }
                    }
                }
                return -1;
        }
        while (i2 < i10 && bArr[i2] >= 0) {
            i2++;
        }
        if (i2 < i10) {
            while (i2 < i10) {
                int i17 = i2 + 1;
                byte b10 = bArr[i2];
                if (b10 < 0) {
                    if (b10 < -32) {
                        if (i17 >= i10) {
                            return b10;
                        }
                        if (b10 >= -62) {
                            i2 += 2;
                            if (bArr[i17] > -65) {
                            }
                        }
                        return -1;
                    }
                    if (b10 < -16) {
                        if (i17 >= i10 - 1) {
                            return l4.a(bArr, i17, i10);
                        }
                        int i18 = i2 + 2;
                        byte b11 = bArr[i17];
                        if (b11 <= -65 && ((b10 != -32 || b11 >= -96) && (b10 != -19 || b11 < -96))) {
                            i2 += 3;
                            if (bArr[i18] > -65) {
                            }
                        }
                        return -1;
                    }
                    if (i17 >= i10 - 2) {
                        return l4.a(bArr, i17, i10);
                    }
                    int i19 = i2 + 2;
                    byte b12 = bArr[i17];
                    if (b12 <= -65) {
                        if ((((b12 + 112) + (b10 << 28)) >> 30) == 0) {
                            int i20 = i2 + 3;
                            if (bArr[i19] <= -65) {
                                i2 += 4;
                                if (bArr[i20] > -65) {
                                }
                            }
                        }
                    }
                    return -1;
                }
                i2 = i17;
            }
        }
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x004a  */
    @Override // w7.e0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String q(byte[] r10, int r11, int r12) throws com.google.protobuf.r2 {
        /*
            Method dump skipped, instructions count: 352
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.j4.q(byte[], int, int):java.lang.String");
    }

    @Override // w7.e0
    public final int r(int i2, int i10, String str, byte[] bArr) {
        int i11;
        int i12;
        char cCharAt;
        long j2;
        long j4;
        long j10;
        int i13;
        char cCharAt2;
        switch (this.f2417c) {
            case 0:
                int length = str.length();
                int i14 = i10 + i2;
                int i15 = 0;
                while (i15 < length && (i12 = i15 + i2) < i14 && (cCharAt = str.charAt(i15)) < 128) {
                    bArr[i12] = (byte) cCharAt;
                    i15++;
                }
                if (i15 == length) {
                    return i2 + length;
                }
                int i16 = i2 + i15;
                while (i15 < length) {
                    char cCharAt3 = str.charAt(i15);
                    if (cCharAt3 < 128 && i16 < i14) {
                        bArr[i16] = (byte) cCharAt3;
                        i16++;
                    } else if (cCharAt3 < 2048 && i16 <= i14 - 2) {
                        int i17 = i16 + 1;
                        bArr[i16] = (byte) ((cCharAt3 >>> 6) | 960);
                        i16 += 2;
                        bArr[i17] = (byte) ((cCharAt3 & '?') | 128);
                    } else {
                        if ((cCharAt3 >= 55296 && 57343 >= cCharAt3) || i16 > i14 - 3) {
                            if (i16 > i14 - 4) {
                                if (55296 <= cCharAt3 && cCharAt3 <= 57343 && ((i11 = i15 + 1) == str.length() || !Character.isSurrogatePair(cCharAt3, str.charAt(i11)))) {
                                    throw new k4(i15, length);
                                }
                                throw new ArrayIndexOutOfBoundsException("Failed writing " + cCharAt3 + " at index " + i16);
                            }
                            int i18 = i15 + 1;
                            if (i18 != str.length()) {
                                char cCharAt4 = str.charAt(i18);
                                if (Character.isSurrogatePair(cCharAt3, cCharAt4)) {
                                    int codePoint = Character.toCodePoint(cCharAt3, cCharAt4);
                                    bArr[i16] = (byte) ((codePoint >>> 18) | 240);
                                    bArr[i16 + 1] = (byte) (((codePoint >>> 12) & 63) | 128);
                                    int i19 = i16 + 3;
                                    bArr[i16 + 2] = (byte) (((codePoint >>> 6) & 63) | 128);
                                    i16 += 4;
                                    bArr[i19] = (byte) ((codePoint & 63) | 128);
                                    i15 = i18;
                                } else {
                                    i15 = i18;
                                }
                            }
                            throw new k4(i15 - 1, length);
                        }
                        bArr[i16] = (byte) ((cCharAt3 >>> '\f') | 480);
                        int i20 = i16 + 2;
                        bArr[i16 + 1] = (byte) (((cCharAt3 >>> 6) & 63) | 128);
                        i16 += 3;
                        bArr[i20] = (byte) ((cCharAt3 & '?') | 128);
                    }
                    i15++;
                }
                return i16;
            default:
                long j11 = i2;
                long j12 = i10 + j11;
                int length2 = str.length();
                if (length2 > i10 || bArr.length - i10 < i2) {
                    throw new ArrayIndexOutOfBoundsException("Failed writing " + str.charAt(length2 - 1) + " at index " + (i2 + i10));
                }
                int i21 = 0;
                while (true) {
                    j2 = 1;
                    if (i21 < length2 && (cCharAt2 = str.charAt(i21)) < 128) {
                        i4.k(bArr, j11, (byte) cCharAt2);
                        i21++;
                        j11 = 1 + j11;
                    }
                }
                if (i21 != length2) {
                    while (i21 < length2) {
                        char cCharAt5 = str.charAt(i21);
                        if (cCharAt5 < 128 && j11 < j12) {
                            i4.k(bArr, j11, (byte) cCharAt5);
                            j10 = j12;
                            j4 = j2;
                            j11 += j2;
                        } else if (cCharAt5 >= 2048 || j11 > j12 - 2) {
                            j4 = j2;
                            if ((cCharAt5 >= 55296 && 57343 >= cCharAt5) || j11 > j12 - 3) {
                                j10 = j12;
                                if (j11 > j10 - 4) {
                                    if (55296 <= cCharAt5 && cCharAt5 <= 57343 && ((i13 = i21 + 1) == length2 || !Character.isSurrogatePair(cCharAt5, str.charAt(i13)))) {
                                        throw new k4(i21, length2);
                                    }
                                    throw new ArrayIndexOutOfBoundsException("Failed writing " + cCharAt5 + " at index " + j11);
                                }
                                int i22 = i21 + 1;
                                if (i22 != length2) {
                                    char cCharAt6 = str.charAt(i22);
                                    if (Character.isSurrogatePair(cCharAt5, cCharAt6)) {
                                        int codePoint2 = Character.toCodePoint(cCharAt5, cCharAt6);
                                        i4.k(bArr, j11, (byte) ((codePoint2 >>> 18) | 240));
                                        i4.k(bArr, j11 + j4, (byte) (((codePoint2 >>> 12) & 63) | 128));
                                        long j13 = j11 + 3;
                                        i4.k(bArr, j11 + 2, (byte) (((codePoint2 >>> 6) & 63) | 128));
                                        j11 += 4;
                                        i4.k(bArr, j13, (byte) ((codePoint2 & 63) | 128));
                                        i21 = i22;
                                    } else {
                                        i21 = i22;
                                    }
                                }
                                throw new k4(i21 - 1, length2);
                            }
                            i4.k(bArr, j11, (byte) ((cCharAt5 >>> '\f') | 480));
                            long j14 = j11 + 2;
                            j10 = j12;
                            i4.k(bArr, j11 + j4, (byte) (((cCharAt5 >>> 6) & 63) | 128));
                            j11 += 3;
                            i4.k(bArr, j14, (byte) ((cCharAt5 & '?') | 128));
                        } else {
                            j4 = j2;
                            long j15 = j11 + j4;
                            i4.k(bArr, j11, (byte) ((cCharAt5 >>> 6) | 960));
                            j11 += 2;
                            i4.k(bArr, j15, (byte) ((cCharAt5 & '?') | 128));
                            j10 = j12;
                        }
                        i21++;
                        j2 = j4;
                        j12 = j10;
                    }
                }
                return (int) j11;
        }
    }
}
