package androidx.datastore.preferences.protobuf;

/* loaded from: classes.dex */
public final class A0 extends X {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f3394c;

    public static int n(int i4, int i5, long j4, byte[] bArr) {
        if (i5 == 0) {
            A0 a02 = C0.f3395a;
            if (i4 > -12) {
                return -1;
            }
            return i4;
        }
        if (i5 == 1) {
            return C0.c(i4, z0.f(j4, bArr));
        }
        if (i5 == 2) {
            return C0.d(i4, z0.f(j4, bArr), z0.f(j4 + 1, bArr));
        }
        throw new AssertionError();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0103  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String k(int r11, int r12, byte[] r13) throws androidx.datastore.preferences.protobuf.F {
        /*
            Method dump skipped, instructions count: 414
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.A0.k(int, int, byte[]):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x018e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int l(java.lang.CharSequence r25, byte[] r26, int r27, int r28) {
        /*
            Method dump skipped, instructions count: 642
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.A0.l(java.lang.CharSequence, byte[], int, int):int");
    }

    public final int m(byte[] bArr, int i4, int i5) {
        int i6;
        int i7 = i4;
        switch (this.f3394c) {
            case 0:
                break;
            default:
                if ((i7 | i5 | (bArr.length - i5)) < 0) {
                    throw new ArrayIndexOutOfBoundsException(String.format("Array length=%d, index=%d, limit=%d", Integer.valueOf(bArr.length), Integer.valueOf(i4), Integer.valueOf(i5)));
                }
                long j4 = i7;
                int i8 = (int) (i5 - j4);
                long j5 = 1;
                if (i8 < 16) {
                    i6 = 0;
                } else {
                    long j6 = j4;
                    i6 = 0;
                    while (true) {
                        if (i6 < i8) {
                            long j7 = j6 + 1;
                            if (z0.f(j6, bArr) >= 0) {
                                i6++;
                                j6 = j7;
                            }
                        } else {
                            i6 = i8;
                        }
                    }
                }
                int i9 = i8 - i6;
                long j8 = j4 + i6;
                while (true) {
                    byte b4 = 0;
                    while (true) {
                        if (i9 > 0) {
                            long j9 = j8 + j5;
                            byte bF = z0.f(j8, bArr);
                            if (bF >= 0) {
                                i9--;
                                b4 = bF;
                                j8 = j9;
                            } else {
                                b4 = bF;
                                j8 = j9;
                            }
                        }
                    }
                    if (i9 == 0) {
                        return 0;
                    }
                    int i10 = i9 - 1;
                    if (b4 < -32) {
                        if (i10 == 0) {
                            return b4;
                        }
                        i9 -= 2;
                        if (b4 >= -62) {
                            long j10 = j8 + j5;
                            if (z0.f(j8, bArr) <= -65) {
                                j8 = j10;
                                j5 = 1;
                            }
                        }
                    } else if (b4 < -16) {
                        if (i10 < 2) {
                            return n(b4, i10, j8, bArr);
                        }
                        i9 -= 3;
                        long j11 = j8 + j5;
                        byte bF2 = z0.f(j8, bArr);
                        if (bF2 <= -65 && ((b4 != -32 || bF2 >= -96) && (b4 != -19 || bF2 < -96))) {
                            j8 += 2;
                            if (z0.f(j11, bArr) <= -65) {
                                j5 = 1;
                            }
                        }
                    } else {
                        if (i10 < 3) {
                            return n(b4, i10, j8, bArr);
                        }
                        i9 -= 4;
                        long j12 = j8 + j5;
                        byte bF3 = z0.f(j8, bArr);
                        if (bF3 <= -65) {
                            if ((((bF3 + 112) + (b4 << 28)) >> 30) == 0) {
                                long j13 = j8 + 2;
                                if (z0.f(j12, bArr) <= -65) {
                                    j8 += 3;
                                    if (z0.f(j13, bArr) <= -65) {
                                        j5 = 1;
                                    }
                                }
                            }
                        }
                    }
                }
                return -1;
        }
        while (i7 < i5 && bArr[i7] >= 0) {
            i7++;
        }
        if (i7 < i5) {
            while (i7 < i5) {
                int i11 = i7 + 1;
                byte b5 = bArr[i7];
                if (b5 < 0) {
                    if (b5 < -32) {
                        if (i11 >= i5) {
                            return b5;
                        }
                        if (b5 >= -62) {
                            i7 += 2;
                            if (bArr[i11] > -65) {
                            }
                        }
                        return -1;
                    }
                    if (b5 < -16) {
                        if (i11 >= i5 - 1) {
                            return C0.a(i11, i5, bArr);
                        }
                        int i12 = i7 + 2;
                        byte b6 = bArr[i11];
                        if (b6 <= -65 && ((b5 != -32 || b6 >= -96) && (b5 != -19 || b6 < -96))) {
                            i7 += 3;
                            if (bArr[i12] > -65) {
                            }
                        }
                        return -1;
                    }
                    if (i11 >= i5 - 2) {
                        return C0.a(i11, i5, bArr);
                    }
                    int i13 = i7 + 2;
                    byte b7 = bArr[i11];
                    if (b7 <= -65) {
                        if ((((b7 + 112) + (b5 << 28)) >> 30) == 0) {
                            int i14 = i7 + 3;
                            if (bArr[i13] <= -65) {
                                i7 += 4;
                                if (bArr[i14] > -65) {
                                }
                            }
                        }
                    }
                    return -1;
                }
                i7 = i11;
            }
        }
        return 0;
    }
}
