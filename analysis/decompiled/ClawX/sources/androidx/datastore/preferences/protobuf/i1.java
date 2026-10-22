package androidx.datastore.preferences.protobuf;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class i1 extends b8.h {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f499c;

    public /* synthetic */ i1(int i8) {
        this.f499c = i8;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x004a  */
    @Override // b8.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String l(int r10, int r11, byte[] r12) throws androidx.datastore.preferences.protobuf.z {
        /*
            Method dump skipped, instructions count: 352
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.i1.l(int, int, byte[]):java.lang.String");
    }

    @Override // b8.h
    public final int m(String str, byte[] bArr, int i8, int i9) {
        int i10;
        int i11;
        char cCharAt;
        long j4;
        long j8;
        long j9;
        int i12;
        char cCharAt2;
        switch (this.f499c) {
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
                                    throw new j1(i14, length);
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
                            throw new j1(i14 - 1, length);
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
                        h1.j(bArr, j10, (byte) cCharAt2);
                        i20++;
                        j10 = 1 + j10;
                    }
                }
                if (i20 != length2) {
                    while (i20 < length2) {
                        char cCharAt5 = str.charAt(i20);
                        if (cCharAt5 < 128 && j10 < j11) {
                            h1.j(bArr, j10, (byte) cCharAt5);
                            j9 = j11;
                            j8 = j4;
                            j10 += j4;
                        } else if (cCharAt5 >= 2048 || j10 > j11 - 2) {
                            j8 = j4;
                            if ((cCharAt5 >= 55296 && 57343 >= cCharAt5) || j10 > j11 - 3) {
                                j9 = j11;
                                if (j10 > j9 - 4) {
                                    if (55296 <= cCharAt5 && cCharAt5 <= 57343 && ((i12 = i20 + 1) == length2 || !Character.isSurrogatePair(cCharAt5, str.charAt(i12)))) {
                                        throw new j1(i20, length2);
                                    }
                                    throw new ArrayIndexOutOfBoundsException("Failed writing " + cCharAt5 + " at index " + j10);
                                }
                                int i21 = i20 + 1;
                                if (i21 != length2) {
                                    char cCharAt6 = str.charAt(i21);
                                    if (Character.isSurrogatePair(cCharAt5, cCharAt6)) {
                                        int codePoint2 = Character.toCodePoint(cCharAt5, cCharAt6);
                                        h1.j(bArr, j10, (byte) ((codePoint2 >>> 18) | 240));
                                        h1.j(bArr, j10 + j8, (byte) (((codePoint2 >>> 12) & 63) | 128));
                                        long j12 = j10 + 3;
                                        h1.j(bArr, j10 + 2, (byte) (((codePoint2 >>> 6) & 63) | 128));
                                        j10 += 4;
                                        h1.j(bArr, j12, (byte) ((codePoint2 & 63) | 128));
                                        i20 = i21;
                                    } else {
                                        i20 = i21;
                                    }
                                }
                                throw new j1(i20 - 1, length2);
                            }
                            h1.j(bArr, j10, (byte) ((cCharAt5 >>> '\f') | 480));
                            long j13 = j10 + 2;
                            j9 = j11;
                            h1.j(bArr, j10 + j8, (byte) (((cCharAt5 >>> 6) & 63) | 128));
                            j10 += 3;
                            h1.j(bArr, j13, (byte) ((cCharAt5 & '?') | 128));
                        } else {
                            j8 = j4;
                            long j14 = j10 + j8;
                            h1.j(bArr, j10, (byte) ((cCharAt5 >>> 6) | 960));
                            j10 += 2;
                            h1.j(bArr, j14, (byte) ((cCharAt5 & '?') | 128));
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
}
