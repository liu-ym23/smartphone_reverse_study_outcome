package com.google.crypto.tink.shaded.protobuf;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class o1 extends a.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1507a;

    public /* synthetic */ o1(int i8) {
        this.f1507a = i8;
    }

    public static int j0(long j4, byte[] bArr, int i8, int i9) {
        if (i9 == 0) {
            a.a aVar = q1.f1510a;
            if (i8 > -12) {
                return -1;
            }
            return i8;
        }
        if (i9 == 1) {
            return q1.c(i8, n1.g(j4, bArr));
        }
        if (i9 == 2) {
            return q1.d(i8, n1.g(j4, bArr), n1.g(j4 + 1, bArr));
        }
        throw new AssertionError();
    }

    @Override // a.a
    public final int E(String str, byte[] bArr, int i8, int i9) {
        int i10;
        int i11;
        char cCharAt;
        long j4;
        long j8;
        long j9;
        int i12;
        char cCharAt2;
        switch (this.f1507a) {
            case 0:
                int length = str.length();
                int i13 = i9 + i8;
                int i14 = 0;
                while (i14 < length && (i11 = i14 + i8) < i13 && (cCharAt = str.charAt(i14)) < 128) {
                    bArr[i11] = (byte) cCharAt;
                    i14++;
                }
                if (i14 == length) {
                    return i8 + length;
                }
                int i15 = i8 + i14;
                while (i14 < length) {
                    char cCharAt3 = str.charAt(i14);
                    if (cCharAt3 < 128 && i15 < i13) {
                        bArr[i15] = (byte) cCharAt3;
                        i15++;
                    } else if (cCharAt3 < 2048 && i15 <= i13 - 2) {
                        int i16 = i15 + 1;
                        bArr[i15] = (byte) ((cCharAt3 >>> 6) | 960);
                        i15 += 2;
                        bArr[i16] = (byte) ((cCharAt3 & '?') | 128);
                    } else {
                        if ((cCharAt3 >= 55296 && 57343 >= cCharAt3) || i15 > i13 - 3) {
                            if (i15 > i13 - 4) {
                                if (55296 <= cCharAt3 && cCharAt3 <= 57343 && ((i10 = i14 + 1) == str.length() || !Character.isSurrogatePair(cCharAt3, str.charAt(i10)))) {
                                    throw new p1(i14, length);
                                }
                                throw new ArrayIndexOutOfBoundsException("Failed writing " + cCharAt3 + " at index " + i15);
                            }
                            int i17 = i14 + 1;
                            if (i17 != str.length()) {
                                char cCharAt4 = str.charAt(i17);
                                if (Character.isSurrogatePair(cCharAt3, cCharAt4)) {
                                    int codePoint = Character.toCodePoint(cCharAt3, cCharAt4);
                                    bArr[i15] = (byte) ((codePoint >>> 18) | 240);
                                    bArr[i15 + 1] = (byte) (((codePoint >>> 12) & 63) | 128);
                                    int i18 = i15 + 3;
                                    bArr[i15 + 2] = (byte) (((codePoint >>> 6) & 63) | 128);
                                    i15 += 4;
                                    bArr[i18] = (byte) ((codePoint & 63) | 128);
                                    i14 = i17;
                                } else {
                                    i14 = i17;
                                }
                            }
                            throw new p1(i14 - 1, length);
                        }
                        bArr[i15] = (byte) ((cCharAt3 >>> '\f') | 480);
                        int i19 = i15 + 2;
                        bArr[i15 + 1] = (byte) (((cCharAt3 >>> 6) & 63) | 128);
                        i15 += 3;
                        bArr[i19] = (byte) ((cCharAt3 & '?') | 128);
                    }
                    i14++;
                }
                return i15;
            default:
                long j10 = i8;
                long j11 = i9 + j10;
                int length2 = str.length();
                if (length2 > i9 || bArr.length - i9 < i8) {
                    throw new ArrayIndexOutOfBoundsException("Failed writing " + str.charAt(length2 - 1) + " at index " + (i8 + i9));
                }
                int i20 = 0;
                while (true) {
                    j4 = 1;
                    if (i20 < length2 && (cCharAt2 = str.charAt(i20)) < 128) {
                        n1.k(bArr, j10, (byte) cCharAt2);
                        i20++;
                        j10 = 1 + j10;
                    }
                }
                if (i20 != length2) {
                    while (i20 < length2) {
                        char cCharAt5 = str.charAt(i20);
                        if (cCharAt5 < 128 && j10 < j11) {
                            n1.k(bArr, j10, (byte) cCharAt5);
                            j9 = j11;
                            j8 = j4;
                            j10 += j4;
                        } else if (cCharAt5 >= 2048 || j10 > j11 - 2) {
                            j8 = j4;
                            if ((cCharAt5 >= 55296 && 57343 >= cCharAt5) || j10 > j11 - 3) {
                                j9 = j11;
                                if (j10 > j9 - 4) {
                                    if (55296 <= cCharAt5 && cCharAt5 <= 57343 && ((i12 = i20 + 1) == length2 || !Character.isSurrogatePair(cCharAt5, str.charAt(i12)))) {
                                        throw new p1(i20, length2);
                                    }
                                    throw new ArrayIndexOutOfBoundsException("Failed writing " + cCharAt5 + " at index " + j10);
                                }
                                int i21 = i20 + 1;
                                if (i21 != length2) {
                                    char cCharAt6 = str.charAt(i21);
                                    if (Character.isSurrogatePair(cCharAt5, cCharAt6)) {
                                        int codePoint2 = Character.toCodePoint(cCharAt5, cCharAt6);
                                        n1.k(bArr, j10, (byte) ((codePoint2 >>> 18) | 240));
                                        n1.k(bArr, j10 + j8, (byte) (((codePoint2 >>> 12) & 63) | 128));
                                        long j12 = j10 + 3;
                                        n1.k(bArr, j10 + 2, (byte) (((codePoint2 >>> 6) & 63) | 128));
                                        j10 += 4;
                                        n1.k(bArr, j12, (byte) ((codePoint2 & 63) | 128));
                                        i20 = i21;
                                    } else {
                                        i20 = i21;
                                    }
                                }
                                throw new p1(i20 - 1, length2);
                            }
                            n1.k(bArr, j10, (byte) ((cCharAt5 >>> '\f') | 480));
                            long j13 = j10 + 2;
                            j9 = j11;
                            n1.k(bArr, j10 + j8, (byte) (((cCharAt5 >>> 6) & 63) | 128));
                            j10 += 3;
                            n1.k(bArr, j13, (byte) ((cCharAt5 & '?') | 128));
                        } else {
                            j8 = j4;
                            long j14 = j10 + j8;
                            n1.k(bArr, j10, (byte) ((cCharAt5 >>> 6) | 960));
                            j10 += 2;
                            n1.k(bArr, j14, (byte) ((cCharAt5 & '?') | 128));
                            j9 = j11;
                        }
                        i20++;
                        j4 = j8;
                        j11 = j9;
                    }
                }
                return (int) j10;
        }
    }

    @Override // a.a
    public final int Y(int i8, int i9, byte[] bArr) {
        int i10;
        switch (this.f1507a) {
            case 0:
                break;
            default:
                if ((i8 | i9 | (bArr.length - i9)) < 0) {
                    throw new ArrayIndexOutOfBoundsException(String.format("Array length=%d, index=%d, limit=%d", Integer.valueOf(bArr.length), Integer.valueOf(i8), Integer.valueOf(i9)));
                }
                long j4 = i8;
                int i11 = (int) (i9 - j4);
                if (i11 < 16) {
                    i10 = 0;
                } else {
                    int i12 = 8 - (((int) j4) & 7);
                    long j8 = j4;
                    i10 = 0;
                    while (true) {
                        if (i10 < i12) {
                            long j9 = j8 + 1;
                            if (n1.g(j8, bArr) >= 0) {
                                i10++;
                                j8 = j9;
                            }
                        } else {
                            while (true) {
                                int i13 = i10 + 8;
                                if (i13 <= i11) {
                                    if ((n1.f1499c.h(bArr, n1.f1501f + j8) & (-9187201950435737472L)) == 0) {
                                        j8 += 8;
                                        i10 = i13;
                                    }
                                }
                            }
                            while (true) {
                                if (i10 < i11) {
                                    long j10 = j8 + 1;
                                    if (n1.g(j8, bArr) >= 0) {
                                        i10++;
                                        j8 = j10;
                                    }
                                } else {
                                    i10 = i11;
                                }
                            }
                        }
                    }
                }
                int i14 = i11 - i10;
                long j11 = j4 + i10;
                while (true) {
                    byte bG = 0;
                    while (true) {
                        if (i14 > 0) {
                            long j12 = j11 + 1;
                            bG = n1.g(j11, bArr);
                            if (bG >= 0) {
                                i14--;
                                j11 = j12;
                            } else {
                                j11 = j12;
                            }
                        }
                    }
                    if (i14 == 0) {
                        return 0;
                    }
                    int i15 = i14 - 1;
                    if (bG < -32) {
                        if (i15 == 0) {
                            return bG;
                        }
                        i14 -= 2;
                        if (bG >= -62) {
                            long j13 = j11 + 1;
                            if (n1.g(j11, bArr) <= -65) {
                                j11 = j13;
                            }
                        }
                    } else if (bG < -16) {
                        if (i15 < 2) {
                            return j0(j11, bArr, bG, i15);
                        }
                        i14 -= 3;
                        long j14 = j11 + 1;
                        byte bG2 = n1.g(j11, bArr);
                        if (bG2 <= -65 && ((bG != -32 || bG2 >= -96) && (bG != -19 || bG2 < -96))) {
                            j11 += 2;
                            if (n1.g(j14, bArr) > -65) {
                            }
                        }
                    } else {
                        if (i15 < 3) {
                            return j0(j11, bArr, bG, i15);
                        }
                        i14 -= 4;
                        long j15 = j11 + 1;
                        byte bG3 = n1.g(j11, bArr);
                        if (bG3 <= -65) {
                            if ((((bG3 + 112) + (bG << 28)) >> 30) == 0) {
                                long j16 = 2 + j11;
                                if (n1.g(j15, bArr) <= -65) {
                                    j11 += 3;
                                    if (n1.g(j16, bArr) > -65) {
                                    }
                                }
                            }
                        }
                    }
                }
                return -1;
        }
        while (i8 < i9 && bArr[i8] >= 0) {
            i8++;
        }
        if (i8 < i9) {
            while (i8 < i9) {
                int i16 = i8 + 1;
                byte b9 = bArr[i8];
                if (b9 < 0) {
                    if (b9 < -32) {
                        if (i16 >= i9) {
                            return b9;
                        }
                        if (b9 >= -62) {
                            i8 += 2;
                            if (bArr[i16] > -65) {
                            }
                        }
                        return -1;
                    }
                    if (b9 < -16) {
                        if (i16 >= i9 - 1) {
                            return q1.a(i16, i9, bArr);
                        }
                        int i17 = i8 + 2;
                        byte b10 = bArr[i16];
                        if (b10 <= -65 && ((b9 != -32 || b10 >= -96) && (b9 != -19 || b10 < -96))) {
                            i8 += 3;
                            if (bArr[i17] > -65) {
                            }
                        }
                        return -1;
                    }
                    if (i16 >= i9 - 2) {
                        return q1.a(i16, i9, bArr);
                    }
                    int i18 = i8 + 2;
                    byte b11 = bArr[i16];
                    if (b11 <= -65) {
                        if ((((b11 + 112) + (b9 << 28)) >> 30) == 0) {
                            int i19 = i8 + 3;
                            if (bArr[i18] <= -65) {
                                i8 += 4;
                                if (bArr[i19] > -65) {
                                }
                            }
                        }
                    }
                    return -1;
                }
                i8 = i16;
            }
        }
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0049  */
    @Override // a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String y(int r10, int r11, byte[] r12) throws com.google.crypto.tink.shaded.protobuf.c0 {
        /*
            Method dump skipped, instructions count: 352
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.o1.y(int, int, byte[]):java.lang.String");
    }
}
