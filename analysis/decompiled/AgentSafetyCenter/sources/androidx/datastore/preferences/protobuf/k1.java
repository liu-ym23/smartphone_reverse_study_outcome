package androidx.datastore.preferences.protobuf;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class k1 extends id.c {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f1147b;

    public /* synthetic */ k1(int i) {
        this.f1147b = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x004a  */
    @Override // id.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String o(byte[] r10, int r11, int r12) throws androidx.datastore.preferences.protobuf.z {
        /*
            Method dump skipped, instructions count: 352
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.k1.o(byte[], int, int):java.lang.String");
    }

    @Override // id.c
    public final int q(String str, byte[] bArr, int i, int i3) {
        int i10;
        int i11;
        char cCharAt;
        long j10;
        long j11;
        int i12;
        char cCharAt2;
        switch (this.f1147b) {
            case 0:
                int length = str.length();
                int i13 = i3 + i;
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
                                    throw new l1(i14, length);
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
                            throw new l1(i14 - 1, length);
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
                long j12 = i;
                long j13 = i3 + j12;
                int length2 = str.length();
                if (length2 <= i3 && bArr.length - i3 >= i) {
                    int i20 = 0;
                    while (true) {
                        j10 = 1;
                        if (i20 < length2 && (cCharAt2 = str.charAt(i20)) < 128) {
                            j1.j(bArr, j12, (byte) cCharAt2);
                            i20++;
                            j12 = 1 + j12;
                        }
                    }
                    if (i20 != length2) {
                        while (i20 < length2) {
                            char cCharAt5 = str.charAt(i20);
                            if (cCharAt5 < 128 && j12 < j13) {
                                j1.j(bArr, j12, (byte) cCharAt5);
                                j11 = j10;
                                j12 += j10;
                            } else if (cCharAt5 >= 2048 || j12 > j13 - 2) {
                                j11 = j10;
                                if ((cCharAt5 < 55296 || 57343 < cCharAt5) && j12 <= j13 - 3) {
                                    j1.j(bArr, j12, (byte) ((cCharAt5 >>> '\f') | 480));
                                    long j14 = 2 + j12;
                                    j1.j(bArr, j12 + j11, (byte) (((cCharAt5 >>> 6) & 63) | 128));
                                    j12 += 3;
                                    j1.j(bArr, j14, (byte) ((cCharAt5 & '?') | 128));
                                } else {
                                    if (j12 <= j13 - 4) {
                                        int i21 = i20 + 1;
                                        if (i21 != length2) {
                                            char cCharAt6 = str.charAt(i21);
                                            if (Character.isSurrogatePair(cCharAt5, cCharAt6)) {
                                                int codePoint2 = Character.toCodePoint(cCharAt5, cCharAt6);
                                                j1.j(bArr, j12, (byte) ((codePoint2 >>> 18) | 240));
                                                j1.j(bArr, j12 + j11, (byte) (((codePoint2 >>> 12) & 63) | 128));
                                                long j15 = j12 + 3;
                                                j1.j(bArr, 2 + j12, (byte) (((codePoint2 >>> 6) & 63) | 128));
                                                j12 += 4;
                                                j1.j(bArr, j15, (byte) ((codePoint2 & 63) | 128));
                                                i20 = i21;
                                            } else {
                                                i20 = i21;
                                            }
                                        }
                                        throw new l1(i20 - 1, length2);
                                    }
                                    if (55296 <= cCharAt5 && cCharAt5 <= 57343 && ((i12 = i20 + 1) == length2 || !Character.isSurrogatePair(cCharAt5, str.charAt(i12)))) {
                                        throw new l1(i20, length2);
                                    }
                                    b8.z.f(cCharAt5, j12);
                                }
                            } else {
                                j11 = j10;
                                long j16 = j12 + j11;
                                j1.j(bArr, j12, (byte) ((cCharAt5 >>> 6) | 960));
                                j12 += 2;
                                j1.j(bArr, j16, (byte) ((cCharAt5 & '?') | 128));
                            }
                            i20++;
                            j10 = j11;
                        }
                    }
                    return (int) j12;
                }
                b8.z.d(str.charAt(length2 - 1), i + i3);
                return 0;
        }
    }
}
