package com.google.protobuf;

import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public final class X2 extends AbstractC1002v2 {
    public final /* synthetic */ int c;

    public /* synthetic */ X2(int i) {
        this.c = i;
    }

    public static int J(byte[] bArr, int i, long j5, int i6) {
        if (i6 == 0) {
            AbstractC1002v2 abstractC1002v2 = Y2.f2904a;
            if (i > -12) {
                return -1;
            }
            return i;
        }
        if (i6 == 1) {
            return Y2.c(i, W2.g(bArr, j5));
        }
        if (i6 == 2) {
            return Y2.d(i, W2.g(bArr, j5), W2.g(bArr, j5 + 1));
        }
        throw new AssertionError();
    }

    @Override // com.google.protobuf.AbstractC1002v2
    public final int F(byte[] bArr, int i, int i6) {
        int i10;
        switch (this.c) {
            case 0:
                break;
            default:
                if ((i | i6 | (bArr.length - i6)) < 0) {
                    throw new ArrayIndexOutOfBoundsException(String.format("Array length=%d, index=%d, limit=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i6)));
                }
                long j5 = i;
                int i11 = (int) (i6 - j5);
                if (i11 < 16) {
                    i10 = 0;
                } else {
                    int i12 = 8 - (((int) j5) & 7);
                    i10 = 0;
                    long j6 = j5;
                    while (true) {
                        if (i10 < i12) {
                            long j10 = j6 + 1;
                            if (W2.g(bArr, j6) >= 0) {
                                i10++;
                                j6 = j10;
                            }
                        } else {
                            while (true) {
                                int i13 = i10 + 8;
                                if (i13 <= i11) {
                                    if ((W2.c.j(bArr, W2.f + j6) & (-9187201950435737472L)) == 0) {
                                        j6 += 8;
                                        i10 = i13;
                                    }
                                }
                            }
                            while (true) {
                                if (i10 < i11) {
                                    long j11 = j6 + 1;
                                    if (W2.g(bArr, j6) >= 0) {
                                        i10++;
                                        j6 = j11;
                                    }
                                } else {
                                    i10 = i11;
                                }
                            }
                        }
                    }
                }
                int i14 = i11 - i10;
                long j12 = j5 + i10;
                while (true) {
                    byte bG = 0;
                    while (true) {
                        if (i14 > 0) {
                            long j13 = j12 + 1;
                            bG = W2.g(bArr, j12);
                            if (bG >= 0) {
                                i14--;
                                j12 = j13;
                            } else {
                                j12 = j13;
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
                            long j14 = j12 + 1;
                            if (W2.g(bArr, j12) <= -65) {
                                j12 = j14;
                            }
                        }
                    } else if (bG < -16) {
                        if (i15 < 2) {
                            return J(bArr, bG, j12, i15);
                        }
                        i14 -= 3;
                        long j15 = j12 + 1;
                        byte bG2 = W2.g(bArr, j12);
                        if (bG2 <= -65 && ((bG != -32 || bG2 >= -96) && (bG != -19 || bG2 < -96))) {
                            j12 += 2;
                            if (W2.g(bArr, j15) > -65) {
                            }
                        }
                    } else {
                        if (i15 < 3) {
                            return J(bArr, bG, j12, i15);
                        }
                        i14 -= 4;
                        long j16 = j12 + 1;
                        byte bG3 = W2.g(bArr, j12);
                        if (bG3 <= -65) {
                            if ((((bG3 + 112) + (bG << 28)) >> 30) == 0) {
                                long j17 = 2 + j12;
                                if (W2.g(bArr, j16) <= -65) {
                                    j12 += 3;
                                    if (W2.g(bArr, j17) > -65) {
                                    }
                                }
                            }
                        }
                    }
                }
                return -1;
        }
        while (i < i6 && bArr[i] >= 0) {
            i++;
        }
        if (i < i6) {
            while (i < i6) {
                int i16 = i + 1;
                byte b = bArr[i];
                if (b < 0) {
                    if (b < -32) {
                        if (i16 >= i6) {
                            return b;
                        }
                        if (b >= -62) {
                            i += 2;
                            if (bArr[i16] > -65) {
                            }
                        }
                        return -1;
                    }
                    if (b < -16) {
                        if (i16 >= i6 - 1) {
                            return Y2.a(bArr, i16, i6);
                        }
                        int i17 = i + 2;
                        byte b5 = bArr[i16];
                        if (b5 <= -65 && ((b != -32 || b5 >= -96) && (b != -19 || b5 < -96))) {
                            i += 3;
                            if (bArr[i17] > -65) {
                            }
                        }
                        return -1;
                    }
                    if (i16 >= i6 - 2) {
                        return Y2.a(bArr, i16, i6);
                    }
                    int i18 = i + 2;
                    byte b10 = bArr[i16];
                    if (b10 <= -65) {
                        if ((((b10 + 112) + (b << 28)) >> 30) == 0) {
                            int i19 = i + 3;
                            if (bArr[i18] <= -65) {
                                i += 4;
                                if (bArr[i19] > -65) {
                                }
                            }
                        }
                    }
                    return -1;
                }
                i = i16;
            }
        }
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004a  */
    @Override // com.google.protobuf.AbstractC1002v2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String m(byte[] r7, int r8, int r9) throws com.google.protobuf.InvalidProtocolBufferException {
        /*
            Method dump skipped, instructions count: 224
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.X2.m(byte[], int, int):java.lang.String");
    }

    @Override // com.google.protobuf.AbstractC1002v2
    public final String o(ByteBuffer byteBuffer, int i, int i6) throws InvalidProtocolBufferException {
        long j5;
        byte bE;
        byte bE2;
        switch (this.c) {
            case 0:
                return AbstractC1002v2.n(byteBuffer, i, i6);
            default:
                if ((i | i6 | ((byteBuffer.limit() - i) - i6)) < 0) {
                    throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i), Integer.valueOf(i6)));
                }
                long j6 = W2.c.j(byteBuffer, W2.g) + i;
                long j10 = i6 + j6;
                char[] cArr = new char[i6];
                int i10 = 0;
                while (true) {
                    j5 = 1;
                    if (j6 < j10 && (bE2 = W2.c.e(j6)) >= 0) {
                        j6++;
                        cArr[i10] = (char) bE2;
                        i10++;
                    }
                }
                int i11 = i10;
                while (j6 < j10) {
                    long j11 = j6 + j5;
                    V2 v22 = W2.c;
                    byte bE3 = v22.e(j6);
                    if (bE3 >= 0) {
                        int i12 = i11 + 1;
                        cArr[i11] = (char) bE3;
                        while (j11 < j10 && (bE = W2.c.e(j11)) >= 0) {
                            j11 += j5;
                            cArr[i12] = (char) bE;
                            i12++;
                        }
                        i11 = i12;
                        j6 = j11;
                    } else if (bE3 < -32) {
                        if (j11 >= j10) {
                            throw InvalidProtocolBufferException.b();
                        }
                        j6 += 2;
                        AbstractC1002v2.b(bE3, v22.e(j11), cArr, i11);
                        i11++;
                    } else if (bE3 < -16) {
                        if (j11 >= j10 - j5) {
                            throw InvalidProtocolBufferException.b();
                        }
                        long j12 = 2 + j6;
                        j6 += 3;
                        AbstractC1002v2.c(bE3, v22.e(j11), v22.e(j12), cArr, i11);
                        i11++;
                    } else {
                        if (j11 >= j10 - 2) {
                            throw InvalidProtocolBufferException.b();
                        }
                        byte bE4 = v22.e(j11);
                        long j13 = j6 + 3;
                        byte bE5 = v22.e(2 + j6);
                        j6 += 4;
                        AbstractC1002v2.a(bE3, bE4, bE5, v22.e(j13), cArr, i11);
                        i11 += 2;
                    }
                    j5 = 1;
                }
                return new String(cArr, 0, i11);
        }
    }

    @Override // com.google.protobuf.AbstractC1002v2
    public final int t(String str, byte[] bArr, int i, int i6) {
        int i10;
        int i11;
        char cCharAt;
        long j5;
        long j6;
        long j10;
        int i12;
        char cCharAt2;
        switch (this.c) {
            case 0:
                int length = str.length();
                int i13 = i6 + i;
                int i14 = 0;
                while (i14 < length && (i11 = i14 + i) < i13 && (cCharAt = str.charAt(i14)) < 128) {
                    bArr[i11] = (byte) cCharAt;
                    i14++;
                }
                if (i14 == length) {
                    return i + length;
                }
                int i15 = i + i14;
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
                                    throw new Utf8$UnpairedSurrogateException(i14, length);
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
                            throw new Utf8$UnpairedSurrogateException(i14 - 1, length);
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
                long j11 = i;
                long j12 = i6 + j11;
                int length2 = str.length();
                if (length2 > i6 || bArr.length - i6 < i) {
                    throw new ArrayIndexOutOfBoundsException("Failed writing " + str.charAt(length2 - 1) + " at index " + (i + i6));
                }
                int i20 = 0;
                while (true) {
                    j5 = 1;
                    if (i20 < length2 && (cCharAt2 = str.charAt(i20)) < 128) {
                        W2.k(bArr, j11, (byte) cCharAt2);
                        i20++;
                        j11 = 1 + j11;
                    }
                }
                if (i20 != length2) {
                    while (i20 < length2) {
                        char cCharAt5 = str.charAt(i20);
                        if (cCharAt5 < 128 && j11 < j12) {
                            W2.k(bArr, j11, (byte) cCharAt5);
                            j10 = j12;
                            j6 = j5;
                            j11 += j5;
                        } else if (cCharAt5 >= 2048 || j11 > j12 - 2) {
                            j6 = j5;
                            if ((cCharAt5 >= 55296 && 57343 >= cCharAt5) || j11 > j12 - 3) {
                                j10 = j12;
                                if (j11 > j10 - 4) {
                                    if (55296 <= cCharAt5 && cCharAt5 <= 57343 && ((i12 = i20 + 1) == length2 || !Character.isSurrogatePair(cCharAt5, str.charAt(i12)))) {
                                        throw new Utf8$UnpairedSurrogateException(i20, length2);
                                    }
                                    throw new ArrayIndexOutOfBoundsException("Failed writing " + cCharAt5 + " at index " + j11);
                                }
                                int i21 = i20 + 1;
                                if (i21 != length2) {
                                    char cCharAt6 = str.charAt(i21);
                                    if (Character.isSurrogatePair(cCharAt5, cCharAt6)) {
                                        int codePoint2 = Character.toCodePoint(cCharAt5, cCharAt6);
                                        W2.k(bArr, j11, (byte) ((codePoint2 >>> 18) | 240));
                                        W2.k(bArr, j11 + j6, (byte) (((codePoint2 >>> 12) & 63) | 128));
                                        long j13 = j11 + 3;
                                        W2.k(bArr, j11 + 2, (byte) (((codePoint2 >>> 6) & 63) | 128));
                                        j11 += 4;
                                        W2.k(bArr, j13, (byte) ((codePoint2 & 63) | 128));
                                        i20 = i21;
                                    } else {
                                        i20 = i21;
                                    }
                                }
                                throw new Utf8$UnpairedSurrogateException(i20 - 1, length2);
                            }
                            W2.k(bArr, j11, (byte) ((cCharAt5 >>> '\f') | 480));
                            long j14 = j11 + 2;
                            j10 = j12;
                            W2.k(bArr, j11 + j6, (byte) (((cCharAt5 >>> 6) & 63) | 128));
                            j11 += 3;
                            W2.k(bArr, j14, (byte) ((cCharAt5 & '?') | 128));
                        } else {
                            j6 = j5;
                            long j15 = j11 + j6;
                            W2.k(bArr, j11, (byte) ((cCharAt5 >>> 6) | 960));
                            j11 += 2;
                            W2.k(bArr, j15, (byte) ((cCharAt5 & '?') | 128));
                            j10 = j12;
                        }
                        i20++;
                        j5 = j6;
                        j12 = j10;
                    }
                }
                return (int) j11;
        }
    }
}
