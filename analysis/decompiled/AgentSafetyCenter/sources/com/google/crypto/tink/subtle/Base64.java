package com.google.crypto.tink.subtle;

import g5.f;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class Base64 {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int CRLF = 4;
    public static final int DEFAULT = 0;
    public static final int NO_CLOSE = 16;
    public static final int NO_PADDING = 1;
    public static final int NO_WRAP = 2;
    public static final int URL_SAFE = 8;
    private static final Charset UTF_8 = Charset.forName("UTF-8");

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static abstract class Coder {
        public int op;
        public byte[] output;

        public abstract int maxOutputSize(int i);

        public abstract boolean process(byte[] bArr, int i, int i3, boolean z10);
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class Decoder extends Coder {
        private static final int[] DECODE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        private static final int[] DECODE_WEBSAFE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        private static final int EQUALS = -2;
        private static final int SKIP = -1;
        private final int[] alphabet;
        private int state;
        private int value;

        public Decoder(int i, byte[] bArr) {
            this.output = bArr;
            this.alphabet = (i & 8) == 0 ? DECODE : DECODE_WEBSAFE;
            this.state = 0;
            this.value = 0;
        }

        @Override // com.google.crypto.tink.subtle.Base64.Coder
        public int maxOutputSize(int i) {
            return ((i * 3) / 4) + 10;
        }

        @Override // com.google.crypto.tink.subtle.Base64.Coder
        public boolean process(byte[] bArr, int i, int i3, boolean z10) {
            int i10 = this.state;
            if (i10 == 6) {
                return false;
            }
            int i11 = i3 + i;
            int i12 = this.value;
            byte[] bArr2 = this.output;
            int[] iArr = this.alphabet;
            int i13 = 0;
            int i14 = i12;
            int i15 = i10;
            int i16 = i;
            while (i16 < i11) {
                if (i15 == 0) {
                    while (true) {
                        int i17 = i16 + 4;
                        if (i17 > i11 || (i14 = (iArr[bArr[i16] & 255] << 18) | (iArr[bArr[i16 + 1] & 255] << 12) | (iArr[bArr[i16 + 2] & 255] << 6) | iArr[bArr[i16 + 3] & 255]) < 0) {
                            break;
                        }
                        bArr2[i13 + 2] = (byte) i14;
                        bArr2[i13 + 1] = (byte) (i14 >> 8);
                        bArr2[i13] = (byte) (i14 >> 16);
                        i13 += 3;
                        i16 = i17;
                    }
                    if (i16 >= i11) {
                        break;
                    }
                }
                int i18 = i16 + 1;
                int i19 = iArr[bArr[i16] & 255];
                if (i15 != 0) {
                    if (i15 == 1) {
                        if (i19 < 0) {
                            if (i19 != -1) {
                                this.state = 6;
                                return false;
                            }
                        }
                        i19 |= i14 << 6;
                    } else if (i15 == 2) {
                        if (i19 < 0) {
                            if (i19 == -2) {
                                bArr2[i13] = (byte) (i14 >> 4);
                                i13++;
                                i15 = 4;
                            } else if (i19 != -1) {
                                this.state = 6;
                                return false;
                            }
                        }
                        i19 |= i14 << 6;
                    } else if (i15 != 3) {
                        if (i15 != 4) {
                            if (i15 == 5 && i19 != -1) {
                                this.state = 6;
                                return false;
                            }
                        } else if (i19 == -2) {
                            i15++;
                        } else if (i19 != -1) {
                            this.state = 6;
                            return false;
                        }
                    } else if (i19 >= 0) {
                        int i20 = i19 | (i14 << 6);
                        bArr2[i13 + 2] = (byte) i20;
                        bArr2[i13 + 1] = (byte) (i20 >> 8);
                        bArr2[i13] = (byte) (i20 >> 16);
                        i13 += 3;
                        i14 = i20;
                        i15 = 0;
                    } else if (i19 == -2) {
                        bArr2[i13 + 1] = (byte) (i14 >> 2);
                        bArr2[i13] = (byte) (i14 >> 10);
                        i13 += 2;
                        i15 = 5;
                    } else if (i19 != -1) {
                        this.state = 6;
                        return false;
                    }
                    i15++;
                    i14 = i19;
                } else if (i19 >= 0) {
                    i15++;
                    i14 = i19;
                } else if (i19 != -1) {
                    this.state = 6;
                    return false;
                }
                i16 = i18;
            }
            if (!z10) {
                this.state = i15;
                this.value = i14;
                this.op = i13;
                return true;
            }
            if (i15 == 1) {
                this.state = 6;
                return false;
            }
            if (i15 == 2) {
                bArr2[i13] = (byte) (i14 >> 4);
                i13++;
            } else if (i15 == 3) {
                int i21 = i13 + 1;
                bArr2[i13] = (byte) (i14 >> 10);
                i13 += 2;
                bArr2[i21] = (byte) (i14 >> 2);
            } else if (i15 == 4) {
                this.state = 6;
                return false;
            }
            this.state = i15;
            this.op = i13;
            return true;
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class Encoder extends Coder {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final byte[] ENCODE = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
        private static final byte[] ENCODE_WEBSAFE = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
        public static final int LINE_GROUPS = 19;
        private final byte[] alphabet;
        private int count;
        public final boolean doCr;
        public final boolean doNewline;
        public final boolean doPadding;
        private final byte[] tail;
        int tailLen;

        public Encoder(int i, byte[] bArr) {
            this.output = bArr;
            this.doPadding = (i & 1) == 0;
            boolean z10 = (i & 2) == 0;
            this.doNewline = z10;
            this.doCr = (i & 4) != 0;
            this.alphabet = (i & 8) == 0 ? ENCODE : ENCODE_WEBSAFE;
            this.tail = new byte[2];
            this.tailLen = 0;
            this.count = z10 ? 19 : -1;
        }

        @Override // com.google.crypto.tink.subtle.Base64.Coder
        public int maxOutputSize(int i) {
            return ((i * 8) / 5) + 10;
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0050  */
        @Override // com.google.crypto.tink.subtle.Base64.Coder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean process(byte[] r18, int r19, int r20, boolean r21) {
            /*
                Method dump skipped, instructions count: 490
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.subtle.Base64.Encoder.process(byte[], int, int, boolean):boolean");
        }
    }

    private Base64() {
    }

    public static byte[] decode(byte[] bArr, int i, int i3, int i10) {
        Decoder decoder = new Decoder(i10, new byte[(i3 * 3) / 4]);
        if (!decoder.process(bArr, i, i3, true)) {
            f.s("bad base-64");
            return null;
        }
        int i11 = decoder.op;
        byte[] bArr2 = decoder.output;
        if (i11 == bArr2.length) {
            return bArr2;
        }
        byte[] bArr3 = new byte[i11];
        System.arraycopy(bArr2, 0, bArr3, 0, i11);
        return bArr3;
    }

    public static byte[] encode(byte[] bArr, int i, int i3, int i10) {
        Encoder encoder = new Encoder(i10, null);
        int i11 = (i3 / 3) * 4;
        if (!encoder.doPadding) {
            int i12 = i3 % 3;
            if (i12 == 1) {
                i11 += 2;
            } else if (i12 == 2) {
                i11 += 3;
            }
        } else if (i3 % 3 > 0) {
            i11 += 4;
        }
        if (encoder.doNewline && i3 > 0) {
            i11 += (((i3 - 1) / 57) + 1) * (encoder.doCr ? 2 : 1);
        }
        encoder.output = new byte[i11];
        encoder.process(bArr, i, i3, true);
        return encoder.output;
    }

    public static String encodeToString(byte[] bArr, int i) {
        try {
            return new String(encode(bArr, i), "US-ASCII");
        } catch (UnsupportedEncodingException e10) {
            throw new AssertionError(e10);
        }
    }

    public static byte[] urlSafeDecode(String str) {
        return decode(str, 11);
    }

    public static String urlSafeEncode(byte[] bArr) {
        return encodeToString(bArr, 11);
    }

    public static String encodeToString(byte[] bArr, int i, int i3, int i10) {
        try {
            return new String(encode(bArr, i, i3, i10), "US-ASCII");
        } catch (UnsupportedEncodingException e10) {
            throw new AssertionError(e10);
        }
    }

    public static byte[] decode(String str, int i) {
        return decode(str.getBytes(UTF_8), i);
    }

    public static byte[] decode(byte[] bArr, int i) {
        return decode(bArr, 0, bArr.length, i);
    }

    public static byte[] decode(String str) {
        return decode(str, 2);
    }

    public static byte[] encode(byte[] bArr, int i) {
        return encode(bArr, 0, bArr.length, i);
    }

    public static String encode(byte[] bArr) {
        return encodeToString(bArr, 2);
    }
}
