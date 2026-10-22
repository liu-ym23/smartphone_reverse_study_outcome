package androidx.datastore.preferences.protobuf;

/* loaded from: classes.dex */
final class t0 {

    /* renamed from: a, reason: collision with root package name */
    private static final b f10146a;

    private static class a {
        /* JADX INFO: Access modifiers changed from: private */
        public static void h(byte b6, byte b7, byte b8, byte b9, char[] cArr, int i5) throws B {
            if (m(b7) || (((b6 << 28) + (b7 + 112)) >> 30) != 0 || m(b8) || m(b9)) {
                throw B.c();
            }
            int iR = ((b6 & 7) << 18) | (r(b7) << 12) | (r(b8) << 6) | r(b9);
            cArr[i5] = l(iR);
            cArr[i5 + 1] = q(iR);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void i(byte b6, char[] cArr, int i5) {
            cArr[i5] = (char) b6;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void j(byte b6, byte b7, byte b8, char[] cArr, int i5) throws B {
            if (m(b7) || ((b6 == -32 && b7 < -96) || ((b6 == -19 && b7 >= -96) || m(b8)))) {
                throw B.c();
            }
            cArr[i5] = (char) (((b6 & 15) << 12) | (r(b7) << 6) | r(b8));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void k(byte b6, byte b7, char[] cArr, int i5) throws B {
            if (b6 < -62 || m(b7)) {
                throw B.c();
            }
            cArr[i5] = (char) (((b6 & 31) << 6) | r(b7));
        }

        private static char l(int i5) {
            return (char) ((i5 >>> 10) + 55232);
        }

        private static boolean m(byte b6) {
            return b6 > -65;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean n(byte b6) {
            return b6 >= 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean o(byte b6) {
            return b6 < -16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean p(byte b6) {
            return b6 < -32;
        }

        private static char q(int i5) {
            return (char) ((i5 & 1023) + 56320);
        }

        private static int r(byte b6) {
            return b6 & 63;
        }
    }

    static abstract class b {
        b() {
        }

        abstract String a(byte[] bArr, int i5, int i6);

        abstract int b(CharSequence charSequence, byte[] bArr, int i5, int i6);

        final boolean c(byte[] bArr, int i5, int i6) {
            return d(0, bArr, i5, i6) == 0;
        }

        abstract int d(int i5, byte[] bArr, int i6, int i7);
    }

    static final class c extends b {
        c() {
        }

        private static int e(byte[] bArr, int i5, int i6) {
            while (i5 < i6 && bArr[i5] >= 0) {
                i5++;
            }
            if (i5 >= i6) {
                return 0;
            }
            return f(bArr, i5, i6);
        }

        private static int f(byte[] bArr, int i5, int i6) {
            while (i5 < i6) {
                int i7 = i5 + 1;
                byte b6 = bArr[i5];
                if (b6 < 0) {
                    if (b6 < -32) {
                        if (i7 >= i6) {
                            return b6;
                        }
                        if (b6 >= -62) {
                            i5 += 2;
                            if (bArr[i7] > -65) {
                            }
                        }
                        return -1;
                    }
                    if (b6 >= -16) {
                        if (i7 >= i6 - 2) {
                            return t0.l(bArr, i7, i6);
                        }
                        int i8 = i5 + 2;
                        byte b7 = bArr[i7];
                        if (b7 <= -65 && (((b6 << 28) + (b7 + 112)) >> 30) == 0) {
                            int i9 = i5 + 3;
                            if (bArr[i8] <= -65) {
                                i5 += 4;
                                if (bArr[i9] > -65) {
                                }
                            }
                        }
                        return -1;
                    }
                    if (i7 >= i6 - 1) {
                        return t0.l(bArr, i7, i6);
                    }
                    int i10 = i5 + 2;
                    byte b8 = bArr[i7];
                    if (b8 <= -65 && ((b6 != -32 || b8 >= -96) && (b6 != -19 || b8 < -96))) {
                        i5 += 3;
                        if (bArr[i10] > -65) {
                        }
                    }
                    return -1;
                }
                i5 = i7;
            }
            return 0;
        }

        @Override // androidx.datastore.preferences.protobuf.t0.b
        String a(byte[] bArr, int i5, int i6) throws B {
            if ((i5 | i6 | ((bArr.length - i5) - i6)) < 0) {
                throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i5), Integer.valueOf(i6)));
            }
            int i7 = i5 + i6;
            char[] cArr = new char[i6];
            int i8 = 0;
            while (i5 < i7) {
                byte b6 = bArr[i5];
                if (!a.n(b6)) {
                    break;
                }
                i5++;
                a.i(b6, cArr, i8);
                i8++;
            }
            int i9 = i8;
            while (i5 < i7) {
                int i10 = i5 + 1;
                byte b7 = bArr[i5];
                if (a.n(b7)) {
                    int i11 = i9 + 1;
                    a.i(b7, cArr, i9);
                    int i12 = i10;
                    while (i12 < i7) {
                        byte b8 = bArr[i12];
                        if (!a.n(b8)) {
                            break;
                        }
                        i12++;
                        a.i(b8, cArr, i11);
                        i11++;
                    }
                    i9 = i11;
                    i5 = i12;
                } else if (a.p(b7)) {
                    if (i10 >= i7) {
                        throw B.c();
                    }
                    i5 += 2;
                    a.k(b7, bArr[i10], cArr, i9);
                    i9++;
                } else if (a.o(b7)) {
                    if (i10 >= i7 - 1) {
                        throw B.c();
                    }
                    int i13 = i5 + 2;
                    i5 += 3;
                    a.j(b7, bArr[i10], bArr[i13], cArr, i9);
                    i9++;
                } else {
                    if (i10 >= i7 - 2) {
                        throw B.c();
                    }
                    byte b9 = bArr[i10];
                    int i14 = i5 + 3;
                    byte b10 = bArr[i5 + 2];
                    i5 += 4;
                    a.h(b7, b9, b10, bArr[i14], cArr, i9);
                    i9 += 2;
                }
            }
            return new String(cArr, 0, i9);
        }

        @Override // androidx.datastore.preferences.protobuf.t0.b
        int b(CharSequence charSequence, byte[] bArr, int i5, int i6) {
            int i7;
            int i8;
            char cCharAt;
            int length = charSequence.length();
            int i9 = i6 + i5;
            int i10 = 0;
            while (i10 < length && (i8 = i10 + i5) < i9 && (cCharAt = charSequence.charAt(i10)) < 128) {
                bArr[i8] = (byte) cCharAt;
                i10++;
            }
            if (i10 == length) {
                return i5 + length;
            }
            int i11 = i5 + i10;
            while (i10 < length) {
                char cCharAt2 = charSequence.charAt(i10);
                if (cCharAt2 < 128 && i11 < i9) {
                    bArr[i11] = (byte) cCharAt2;
                    i11++;
                } else if (cCharAt2 < 2048 && i11 <= i9 - 2) {
                    int i12 = i11 + 1;
                    bArr[i11] = (byte) ((cCharAt2 >>> 6) | 960);
                    i11 += 2;
                    bArr[i12] = (byte) ((cCharAt2 & '?') | 128);
                } else {
                    if ((cCharAt2 >= 55296 && 57343 >= cCharAt2) || i11 > i9 - 3) {
                        if (i11 > i9 - 4) {
                            if (55296 <= cCharAt2 && cCharAt2 <= 57343 && ((i7 = i10 + 1) == charSequence.length() || !Character.isSurrogatePair(cCharAt2, charSequence.charAt(i7)))) {
                                throw new d(i10, length);
                            }
                            throw new ArrayIndexOutOfBoundsException("Failed writing " + cCharAt2 + " at index " + i11);
                        }
                        int i13 = i10 + 1;
                        if (i13 != charSequence.length()) {
                            char cCharAt3 = charSequence.charAt(i13);
                            if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                                int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                                bArr[i11] = (byte) ((codePoint >>> 18) | 240);
                                bArr[i11 + 1] = (byte) (((codePoint >>> 12) & 63) | 128);
                                int i14 = i11 + 3;
                                bArr[i11 + 2] = (byte) (((codePoint >>> 6) & 63) | 128);
                                i11 += 4;
                                bArr[i14] = (byte) ((codePoint & 63) | 128);
                                i10 = i13;
                            } else {
                                i10 = i13;
                            }
                        }
                        throw new d(i10 - 1, length);
                    }
                    bArr[i11] = (byte) ((cCharAt2 >>> '\f') | 480);
                    int i15 = i11 + 2;
                    bArr[i11 + 1] = (byte) (((cCharAt2 >>> 6) & 63) | 128);
                    i11 += 3;
                    bArr[i15] = (byte) ((cCharAt2 & '?') | 128);
                }
                i10++;
            }
            return i11;
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0015, code lost:
        
            if (r7[r8] > (-65)) goto L13;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x0046, code lost:
        
            if (r7[r8] > (-65)) goto L32;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x0083, code lost:
        
            if (r7[r6] > (-65)) goto L53;
         */
        @Override // androidx.datastore.preferences.protobuf.t0.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        int d(int r6, byte[] r7, int r8, int r9) {
            /*
                r5 = this;
                if (r6 == 0) goto L86
                if (r8 < r9) goto L5
                return r6
            L5:
                byte r5 = (byte) r6
                r0 = -32
                r1 = -1
                r2 = -65
                if (r5 >= r0) goto L1c
                r6 = -62
                if (r5 < r6) goto L1b
                int r5 = r8 + 1
                r6 = r7[r8]
                if (r6 <= r2) goto L18
                goto L1b
            L18:
                r8 = r5
                goto L86
            L1b:
                return r1
            L1c:
                r3 = -16
                if (r5 >= r3) goto L49
                int r6 = r6 >> 8
                int r6 = ~r6
                byte r6 = (byte) r6
                if (r6 != 0) goto L34
                int r6 = r8 + 1
                r8 = r7[r8]
                if (r6 < r9) goto L31
                int r5 = androidx.datastore.preferences.protobuf.t0.a(r5, r8)
                return r5
            L31:
                r4 = r8
                r8 = r6
                r6 = r4
            L34:
                if (r6 > r2) goto L48
                r3 = -96
                if (r5 != r0) goto L3c
                if (r6 < r3) goto L48
            L3c:
                r0 = -19
                if (r5 != r0) goto L42
                if (r6 >= r3) goto L48
            L42:
                int r5 = r8 + 1
                r6 = r7[r8]
                if (r6 <= r2) goto L18
            L48:
                return r1
            L49:
                int r0 = r6 >> 8
                int r0 = ~r0
                byte r0 = (byte) r0
                if (r0 != 0) goto L5c
                int r6 = r8 + 1
                r0 = r7[r8]
                if (r6 < r9) goto L5a
                int r5 = androidx.datastore.preferences.protobuf.t0.a(r5, r0)
                return r5
            L5a:
                r8 = 0
                goto L62
            L5c:
                int r6 = r6 >> 16
                byte r6 = (byte) r6
                r4 = r8
                r8 = r6
                r6 = r4
            L62:
                if (r8 != 0) goto L72
                int r8 = r6 + 1
                r6 = r7[r6]
                if (r8 < r9) goto L6f
                int r5 = androidx.datastore.preferences.protobuf.t0.b(r5, r0, r6)
                return r5
            L6f:
                r4 = r8
                r8 = r6
                r6 = r4
            L72:
                if (r0 > r2) goto L85
                int r5 = r5 << 28
                int r0 = r0 + 112
                int r5 = r5 + r0
                int r5 = r5 >> 30
                if (r5 != 0) goto L85
                if (r8 > r2) goto L85
                int r8 = r6 + 1
                r5 = r7[r6]
                if (r5 <= r2) goto L86
            L85:
                return r1
            L86:
                int r5 = e(r7, r8, r9)
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.t0.c.d(int, byte[], int, int):int");
        }
    }

    static class d extends IllegalArgumentException {
        d(int i5, int i6) {
            super("Unpaired surrogate at index " + i5 + " of " + i6);
        }
    }

    static final class e extends b {
        e() {
        }

        static boolean e() {
            return s0.C() && s0.D();
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x0039, code lost:
        
            return -1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x0064, code lost:
        
            return -1;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private static int f(byte[] r10, long r11, int r13) {
            /*
                int r0 = g(r10, r11, r13)
                int r13 = r13 - r0
                long r0 = (long) r0
                long r11 = r11 + r0
            L7:
                r0 = 0
                r1 = r0
            L9:
                r2 = 1
                if (r13 <= 0) goto L1a
                long r4 = r11 + r2
                byte r1 = androidx.datastore.preferences.protobuf.s0.s(r10, r11)
                if (r1 < 0) goto L19
                int r13 = r13 + (-1)
                r11 = r4
                goto L9
            L19:
                r11 = r4
            L1a:
                if (r13 != 0) goto L1d
                return r0
            L1d:
                int r0 = r13 + (-1)
                r4 = -32
                r5 = -1
                r6 = -65
                if (r1 >= r4) goto L3a
                if (r0 != 0) goto L29
                return r1
            L29:
                int r13 = r13 + (-2)
                r0 = -62
                if (r1 < r0) goto L39
                long r2 = r2 + r11
                byte r11 = androidx.datastore.preferences.protobuf.s0.s(r10, r11)
                if (r11 <= r6) goto L37
                goto L39
            L37:
                r11 = r2
                goto L7
            L39:
                return r5
            L3a:
                r7 = -16
                r8 = 2
                if (r1 >= r7) goto L65
                r7 = 2
                if (r0 >= r7) goto L48
                int r10 = h(r10, r1, r11, r0)
                return r10
            L48:
                int r13 = r13 + (-3)
                long r2 = r2 + r11
                byte r0 = androidx.datastore.preferences.protobuf.s0.s(r10, r11)
                if (r0 > r6) goto L64
                r7 = -96
                if (r1 != r4) goto L57
                if (r0 < r7) goto L64
            L57:
                r4 = -19
                if (r1 != r4) goto L5d
                if (r0 >= r7) goto L64
            L5d:
                long r11 = r11 + r8
                byte r0 = androidx.datastore.preferences.protobuf.s0.s(r10, r2)
                if (r0 <= r6) goto L7
            L64:
                return r5
            L65:
                r4 = 3
                if (r0 >= r4) goto L6d
                int r10 = h(r10, r1, r11, r0)
                return r10
            L6d:
                int r13 = r13 + (-4)
                long r2 = r2 + r11
                byte r0 = androidx.datastore.preferences.protobuf.s0.s(r10, r11)
                if (r0 > r6) goto L8f
                int r1 = r1 << 28
                int r0 = r0 + 112
                int r1 = r1 + r0
                int r0 = r1 >> 30
                if (r0 != 0) goto L8f
                long r8 = r8 + r11
                byte r0 = androidx.datastore.preferences.protobuf.s0.s(r10, r2)
                if (r0 > r6) goto L8f
                r0 = 3
                long r11 = r11 + r0
                byte r0 = androidx.datastore.preferences.protobuf.s0.s(r10, r8)
                if (r0 <= r6) goto L7
            L8f:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.t0.e.f(byte[], long, int):int");
        }

        private static int g(byte[] bArr, long j5, int i5) {
            int i6 = 0;
            if (i5 < 16) {
                return 0;
            }
            while (i6 < i5) {
                long j6 = 1 + j5;
                if (s0.s(bArr, j5) < 0) {
                    return i6;
                }
                i6++;
                j5 = j6;
            }
            return i5;
        }

        private static int h(byte[] bArr, int i5, long j5, int i6) {
            if (i6 == 0) {
                return t0.i(i5);
            }
            if (i6 == 1) {
                return t0.j(i5, s0.s(bArr, j5));
            }
            if (i6 == 2) {
                return t0.k(i5, s0.s(bArr, j5), s0.s(bArr, j5 + 1));
            }
            throw new AssertionError();
        }

        @Override // androidx.datastore.preferences.protobuf.t0.b
        String a(byte[] bArr, int i5, int i6) throws B {
            if ((i5 | i6 | ((bArr.length - i5) - i6)) < 0) {
                throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i5), Integer.valueOf(i6)));
            }
            int i7 = i5 + i6;
            char[] cArr = new char[i6];
            int i8 = 0;
            while (i5 < i7) {
                byte bS = s0.s(bArr, i5);
                if (!a.n(bS)) {
                    break;
                }
                i5++;
                a.i(bS, cArr, i8);
                i8++;
            }
            int i9 = i8;
            while (i5 < i7) {
                int i10 = i5 + 1;
                byte bS2 = s0.s(bArr, i5);
                if (a.n(bS2)) {
                    int i11 = i9 + 1;
                    a.i(bS2, cArr, i9);
                    while (i10 < i7) {
                        byte bS3 = s0.s(bArr, i10);
                        if (!a.n(bS3)) {
                            break;
                        }
                        i10++;
                        a.i(bS3, cArr, i11);
                        i11++;
                    }
                    i9 = i11;
                    i5 = i10;
                } else if (a.p(bS2)) {
                    if (i10 >= i7) {
                        throw B.c();
                    }
                    i5 += 2;
                    a.k(bS2, s0.s(bArr, i10), cArr, i9);
                    i9++;
                } else if (a.o(bS2)) {
                    if (i10 >= i7 - 1) {
                        throw B.c();
                    }
                    int i12 = i5 + 2;
                    i5 += 3;
                    a.j(bS2, s0.s(bArr, i10), s0.s(bArr, i12), cArr, i9);
                    i9++;
                } else {
                    if (i10 >= i7 - 2) {
                        throw B.c();
                    }
                    byte bS4 = s0.s(bArr, i10);
                    int i13 = i5 + 3;
                    byte bS5 = s0.s(bArr, i5 + 2);
                    i5 += 4;
                    a.h(bS2, bS4, bS5, s0.s(bArr, i13), cArr, i9);
                    i9 += 2;
                }
            }
            return new String(cArr, 0, i9);
        }

        @Override // androidx.datastore.preferences.protobuf.t0.b
        int b(CharSequence charSequence, byte[] bArr, int i5, int i6) {
            long j5;
            long j6;
            long j7;
            int i7;
            char cCharAt;
            long j8 = i5;
            long j9 = i6 + j8;
            int length = charSequence.length();
            if (length > i6 || bArr.length - i6 < i5) {
                throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(length - 1) + " at index " + (i5 + i6));
            }
            int i8 = 0;
            while (true) {
                j5 = 1;
                if (i8 >= length || (cCharAt = charSequence.charAt(i8)) >= 128) {
                    break;
                }
                s0.H(bArr, j8, (byte) cCharAt);
                i8++;
                j8 = 1 + j8;
            }
            if (i8 == length) {
                return (int) j8;
            }
            while (i8 < length) {
                char cCharAt2 = charSequence.charAt(i8);
                if (cCharAt2 < 128 && j8 < j9) {
                    s0.H(bArr, j8, (byte) cCharAt2);
                    j7 = j9;
                    j6 = j5;
                    j8 += j5;
                } else if (cCharAt2 >= 2048 || j8 > j9 - 2) {
                    j6 = j5;
                    if ((cCharAt2 >= 55296 && 57343 >= cCharAt2) || j8 > j9 - 3) {
                        j7 = j9;
                        if (j8 > j7 - 4) {
                            if (55296 <= cCharAt2 && cCharAt2 <= 57343 && ((i7 = i8 + 1) == length || !Character.isSurrogatePair(cCharAt2, charSequence.charAt(i7)))) {
                                throw new d(i8, length);
                            }
                            throw new ArrayIndexOutOfBoundsException("Failed writing " + cCharAt2 + " at index " + j8);
                        }
                        int i9 = i8 + 1;
                        if (i9 != length) {
                            char cCharAt3 = charSequence.charAt(i9);
                            if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                                int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                                s0.H(bArr, j8, (byte) ((codePoint >>> 18) | 240));
                                s0.H(bArr, j8 + j6, (byte) (((codePoint >>> 12) & 63) | 128));
                                long j10 = j8 + 3;
                                s0.H(bArr, j8 + 2, (byte) (((codePoint >>> 6) & 63) | 128));
                                j8 += 4;
                                s0.H(bArr, j10, (byte) ((codePoint & 63) | 128));
                                i8 = i9;
                            } else {
                                i8 = i9;
                            }
                        }
                        throw new d(i8 - 1, length);
                    }
                    s0.H(bArr, j8, (byte) ((cCharAt2 >>> '\f') | 480));
                    long j11 = j8 + 2;
                    j7 = j9;
                    s0.H(bArr, j8 + j6, (byte) (((cCharAt2 >>> 6) & 63) | 128));
                    j8 += 3;
                    s0.H(bArr, j11, (byte) ((cCharAt2 & '?') | 128));
                } else {
                    j6 = j5;
                    long j12 = j8 + j6;
                    s0.H(bArr, j8, (byte) ((cCharAt2 >>> 6) | 960));
                    j8 += 2;
                    s0.H(bArr, j12, (byte) ((cCharAt2 & '?') | 128));
                    j7 = j9;
                }
                i8++;
                j5 = j6;
                j9 = j7;
            }
            return (int) j8;
        }

        /* JADX WARN: Code restructure failed: missing block: B:35:0x0058, code lost:
        
            if (androidx.datastore.preferences.protobuf.s0.s(r11, r0) > (-65)) goto L38;
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x009e, code lost:
        
            if (androidx.datastore.preferences.protobuf.s0.s(r11, r0) > (-65)) goto L59;
         */
        @Override // androidx.datastore.preferences.protobuf.t0.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        int d(int r10, byte[] r11, int r12, int r13) {
            /*
                Method dump skipped, instructions count: 197
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.t0.e.d(int, byte[], int, int):int");
        }
    }

    static {
        f10146a = (!e.e() || C0484d.c()) ? new c() : new e();
    }

    static String e(byte[] bArr, int i5, int i6) {
        return f10146a.a(bArr, i5, i6);
    }

    static int f(CharSequence charSequence, byte[] bArr, int i5, int i6) {
        return f10146a.b(charSequence, bArr, i5, i6);
    }

    static int g(CharSequence charSequence) {
        int length = charSequence.length();
        int i5 = 0;
        while (i5 < length && charSequence.charAt(i5) < 128) {
            i5++;
        }
        int iH = length;
        while (true) {
            if (i5 < length) {
                char cCharAt = charSequence.charAt(i5);
                if (cCharAt >= 2048) {
                    iH += h(charSequence, i5);
                    break;
                }
                iH += (127 - cCharAt) >>> 31;
                i5++;
            } else {
                break;
            }
        }
        if (iH >= length) {
            return iH;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (iH + 4294967296L));
    }

    private static int h(CharSequence charSequence, int i5) {
        int length = charSequence.length();
        int i6 = 0;
        while (i5 < length) {
            char cCharAt = charSequence.charAt(i5);
            if (cCharAt < 2048) {
                i6 += (127 - cCharAt) >>> 31;
            } else {
                i6 += 2;
                if (55296 <= cCharAt && cCharAt <= 57343) {
                    if (Character.codePointAt(charSequence, i5) < 65536) {
                        throw new d(i5, length);
                    }
                    i5++;
                }
            }
            i5++;
        }
        return i6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int i(int i5) {
        if (i5 > -12) {
            return -1;
        }
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int j(int i5, int i6) {
        if (i5 > -12 || i6 > -65) {
            return -1;
        }
        return i5 ^ (i6 << 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int k(int i5, int i6, int i7) {
        if (i5 > -12 || i6 > -65 || i7 > -65) {
            return -1;
        }
        return (i5 ^ (i6 << 8)) ^ (i7 << 16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int l(byte[] bArr, int i5, int i6) {
        byte b6 = bArr[i5 - 1];
        int i7 = i6 - i5;
        if (i7 == 0) {
            return i(b6);
        }
        if (i7 == 1) {
            return j(b6, bArr[i5]);
        }
        if (i7 == 2) {
            return k(b6, bArr[i5], bArr[i5 + 1]);
        }
        throw new AssertionError();
    }

    public static boolean m(byte[] bArr) {
        return f10146a.c(bArr, 0, bArr.length);
    }

    public static boolean n(byte[] bArr, int i5, int i6) {
        return f10146a.c(bArr, i5, i6);
    }
}
