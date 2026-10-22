package com.google.crypto.tink.shaded.protobuf;

import androidx.activity.b;
import b8.z;
import com.fasterxml.jackson.core.base.GeneratorBase;
import com.fasterxml.jackson.core.internal.shaded.fdp.v2_19_2.FastDoubleMath;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
final class Utf8 {
    private static final long ASCII_MASK_LONG = -9187201950435737472L;
    static final int COMPLETE = 0;
    static final int MALFORMED = -1;
    static final int MAX_BYTES_PER_CHAR = 3;
    private static final int UNSAFE_COUNT_ASCII_THRESHOLD = 16;
    private static final Processor processor;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class DecodeUtil {
        private DecodeUtil() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void handleFourBytes(byte b10, byte b11, byte b12, byte b13, char[] cArr, int i) throws InvalidProtocolBufferException {
            if (!isNotTrailingByte(b11)) {
                if ((((b11 + 112) + (b10 << 28)) >> 30) == 0 && !isNotTrailingByte(b12) && !isNotTrailingByte(b13)) {
                    int iTrailingByteValue = ((b10 & 7) << 18) | (trailingByteValue(b11) << 12) | (trailingByteValue(b12) << 6) | trailingByteValue(b13);
                    cArr[i] = highSurrogate(iTrailingByteValue);
                    cArr[i + 1] = lowSurrogate(iTrailingByteValue);
                    return;
                }
            }
            throw InvalidProtocolBufferException.invalidUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void handleOneByte(byte b10, char[] cArr, int i) {
            cArr[i] = (char) b10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void handleThreeBytes(byte b10, byte b11, byte b12, char[] cArr, int i) throws InvalidProtocolBufferException {
            if (isNotTrailingByte(b11) || ((b10 == -32 && b11 < -96) || ((b10 == -19 && b11 >= -96) || isNotTrailingByte(b12)))) {
                throw InvalidProtocolBufferException.invalidUtf8();
            }
            cArr[i] = (char) (((b10 & 15) << 12) | (trailingByteValue(b11) << 6) | trailingByteValue(b12));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void handleTwoBytes(byte b10, byte b11, char[] cArr, int i) throws InvalidProtocolBufferException {
            if (b10 < -62 || isNotTrailingByte(b11)) {
                throw InvalidProtocolBufferException.invalidUtf8();
            }
            cArr[i] = (char) (((b10 & 31) << 6) | trailingByteValue(b11));
        }

        private static char highSurrogate(int i) {
            return (char) ((i >>> 10) + 55232);
        }

        private static boolean isNotTrailingByte(byte b10) {
            return b10 > -65;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean isOneByte(byte b10) {
            return b10 >= 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean isThreeBytes(byte b10) {
            return b10 < -16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean isTwoBytes(byte b10) {
            return b10 < -32;
        }

        private static char lowSurrogate(int i) {
            return (char) ((i & FastDoubleMath.DOUBLE_EXPONENT_BIAS) + GeneratorBase.SURR2_FIRST);
        }

        private static int trailingByteValue(byte b10) {
            return b10 & 63;
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class UnpairedSurrogateException extends IllegalArgumentException {
        public UnpairedSurrogateException(int i, int i3) {
            super(b.i("Unpaired surrogate at index ", i, " of ", i3));
        }
    }

    static {
        processor = (!UnsafeProcessor.isAvailable() || Android.isOnAndroidDevice()) ? new SafeProcessor() : new UnsafeProcessor();
    }

    private Utf8() {
    }

    public static String decodeUtf8(ByteBuffer byteBuffer, int i, int i3) {
        return processor.decodeUtf8(byteBuffer, i, i3);
    }

    public static int encode(CharSequence charSequence, byte[] bArr, int i, int i3) {
        return processor.encodeUtf8(charSequence, bArr, i, i3);
    }

    public static void encodeUtf8(CharSequence charSequence, ByteBuffer byteBuffer) {
        processor.encodeUtf8(charSequence, byteBuffer);
    }

    public static int encodedLength(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        while (i < length && charSequence.charAt(i) < 128) {
            i++;
        }
        int iEncodedLengthGeneral = length;
        while (true) {
            if (i < length) {
                char cCharAt = charSequence.charAt(i);
                if (cCharAt >= 2048) {
                    iEncodedLengthGeneral += encodedLengthGeneral(charSequence, i);
                    break;
                }
                iEncodedLengthGeneral += (127 - cCharAt) >>> 31;
                i++;
            } else {
                break;
            }
        }
        if (iEncodedLengthGeneral >= length) {
            return iEncodedLengthGeneral;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (iEncodedLengthGeneral + 4294967296L));
    }

    private static int encodedLengthGeneral(CharSequence charSequence, int i) {
        int length = charSequence.length();
        int i3 = 0;
        while (i < length) {
            char cCharAt = charSequence.charAt(i);
            if (cCharAt < 2048) {
                i3 += (127 - cCharAt) >>> 31;
            } else {
                i3 += 2;
                if (55296 <= cCharAt && cCharAt <= 57343) {
                    if (Character.codePointAt(charSequence, i) < 65536) {
                        throw new UnpairedSurrogateException(i, length);
                    }
                    i++;
                }
            }
            i++;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int estimateConsecutiveAscii(ByteBuffer byteBuffer, int i, int i3) {
        int i10 = i3 - 7;
        int i11 = i;
        while (i11 < i10 && (byteBuffer.getLong(i11) & ASCII_MASK_LONG) == 0) {
            i11 += 8;
        }
        return i11 - i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int incompleteStateFor(ByteBuffer byteBuffer, int i, int i3, int i10) {
        if (i10 == 0) {
            return incompleteStateFor(i);
        }
        if (i10 == 1) {
            return incompleteStateFor(i, byteBuffer.get(i3));
        }
        if (i10 == 2) {
            return incompleteStateFor(i, byteBuffer.get(i3), byteBuffer.get(i3 + 1));
        }
        throw new AssertionError();
    }

    public static boolean isValidUtf8(ByteBuffer byteBuffer) {
        return processor.isValidUtf8(byteBuffer, byteBuffer.position(), byteBuffer.remaining());
    }

    public static int partialIsValidUtf8(int i, byte[] bArr, int i3, int i10) {
        return processor.partialIsValidUtf8(i, bArr, i3, i10);
    }

    public static String decodeUtf8(byte[] bArr, int i, int i3) {
        return processor.decodeUtf8(bArr, i, i3);
    }

    public static int partialIsValidUtf8(int i, ByteBuffer byteBuffer, int i3, int i10) {
        return processor.partialIsValidUtf8(i, byteBuffer, i3, i10);
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static abstract class Processor {
        private static int partialIsValidUtf8(ByteBuffer byteBuffer, int i, int i3) {
            int iEstimateConsecutiveAscii = i + Utf8.estimateConsecutiveAscii(byteBuffer, i, i3);
            while (iEstimateConsecutiveAscii < i3) {
                int i10 = iEstimateConsecutiveAscii + 1;
                byte b10 = byteBuffer.get(iEstimateConsecutiveAscii);
                if (b10 >= 0) {
                    iEstimateConsecutiveAscii = i10;
                } else if (b10 < -32) {
                    if (i10 >= i3) {
                        return b10;
                    }
                    if (b10 < -62 || byteBuffer.get(i10) > -65) {
                        return -1;
                    }
                    iEstimateConsecutiveAscii += 2;
                } else {
                    if (b10 >= -16) {
                        if (i10 >= i3 - 2) {
                            return Utf8.incompleteStateFor(byteBuffer, b10, i10, i3 - i10);
                        }
                        int i11 = iEstimateConsecutiveAscii + 2;
                        byte b11 = byteBuffer.get(i10);
                        if (b11 <= -65) {
                            if ((((b11 + 112) + (b10 << 28)) >> 30) == 0) {
                                int i12 = iEstimateConsecutiveAscii + 3;
                                if (byteBuffer.get(i11) <= -65) {
                                    iEstimateConsecutiveAscii += 4;
                                    if (byteBuffer.get(i12) > -65) {
                                    }
                                }
                            }
                        }
                        return -1;
                    }
                    if (i10 >= i3 - 1) {
                        return Utf8.incompleteStateFor(byteBuffer, b10, i10, i3 - i10);
                    }
                    int i13 = iEstimateConsecutiveAscii + 2;
                    byte b12 = byteBuffer.get(i10);
                    if (b12 > -65 || ((b10 == -32 && b12 < -96) || ((b10 == -19 && b12 >= -96) || byteBuffer.get(i13) > -65))) {
                        return -1;
                    }
                    iEstimateConsecutiveAscii += 3;
                }
            }
            return 0;
        }

        public final String decodeUtf8(ByteBuffer byteBuffer, int i, int i3) {
            if (byteBuffer.hasArray()) {
                return decodeUtf8(byteBuffer.array(), byteBuffer.arrayOffset() + i, i3);
            }
            return byteBuffer.isDirect() ? decodeUtf8Direct(byteBuffer, i, i3) : decodeUtf8Default(byteBuffer, i, i3);
        }

        public abstract String decodeUtf8(byte[] bArr, int i, int i3);

        public final String decodeUtf8Default(ByteBuffer byteBuffer, int i, int i3) throws InvalidProtocolBufferException {
            if ((i | i3 | ((byteBuffer.limit() - i) - i3)) < 0) {
                throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i), Integer.valueOf(i3)));
            }
            int i10 = i + i3;
            char[] cArr = new char[i3];
            int i11 = 0;
            while (i < i10) {
                byte b10 = byteBuffer.get(i);
                if (!DecodeUtil.isOneByte(b10)) {
                    break;
                }
                i++;
                DecodeUtil.handleOneByte(b10, cArr, i11);
                i11++;
            }
            int i12 = i11;
            while (i < i10) {
                int i13 = i + 1;
                byte b11 = byteBuffer.get(i);
                if (DecodeUtil.isOneByte(b11)) {
                    int i14 = i12 + 1;
                    DecodeUtil.handleOneByte(b11, cArr, i12);
                    int i15 = i13;
                    while (i15 < i10) {
                        byte b12 = byteBuffer.get(i15);
                        if (!DecodeUtil.isOneByte(b12)) {
                            break;
                        }
                        i15++;
                        DecodeUtil.handleOneByte(b12, cArr, i14);
                        i14++;
                    }
                    i12 = i14;
                    i = i15;
                } else if (DecodeUtil.isTwoBytes(b11)) {
                    if (i13 >= i10) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    i += 2;
                    DecodeUtil.handleTwoBytes(b11, byteBuffer.get(i13), cArr, i12);
                    i12++;
                } else if (DecodeUtil.isThreeBytes(b11)) {
                    if (i13 >= i10 - 1) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    int i16 = i + 2;
                    i += 3;
                    DecodeUtil.handleThreeBytes(b11, byteBuffer.get(i13), byteBuffer.get(i16), cArr, i12);
                    i12++;
                } else {
                    if (i13 >= i10 - 2) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    byte b13 = byteBuffer.get(i13);
                    int i17 = i + 3;
                    byte b14 = byteBuffer.get(i + 2);
                    i += 4;
                    DecodeUtil.handleFourBytes(b11, b13, b14, byteBuffer.get(i17), cArr, i12);
                    i12 += 2;
                }
            }
            return new String(cArr, 0, i12);
        }

        public abstract String decodeUtf8Direct(ByteBuffer byteBuffer, int i, int i3);

        public abstract int encodeUtf8(CharSequence charSequence, byte[] bArr, int i, int i3);

        public final void encodeUtf8(CharSequence charSequence, ByteBuffer byteBuffer) {
            if (byteBuffer.hasArray()) {
                int iArrayOffset = byteBuffer.arrayOffset();
                byteBuffer.position(Utf8.encode(charSequence, byteBuffer.array(), byteBuffer.position() + iArrayOffset, byteBuffer.remaining()) - iArrayOffset);
            } else if (byteBuffer.isDirect()) {
                encodeUtf8Direct(charSequence, byteBuffer);
            } else {
                encodeUtf8Default(charSequence, byteBuffer);
            }
        }

        public final void encodeUtf8Default(CharSequence charSequence, ByteBuffer byteBuffer) {
            int i;
            int length = charSequence.length();
            int iPosition = byteBuffer.position();
            int i3 = 0;
            while (i3 < length) {
                try {
                    char cCharAt = charSequence.charAt(i3);
                    if (cCharAt >= 128) {
                        break;
                    }
                    byteBuffer.put(iPosition + i3, (byte) cCharAt);
                    i3++;
                } catch (IndexOutOfBoundsException unused) {
                    z.d(charSequence.charAt(i3), Math.max(i3, (iPosition - byteBuffer.position()) + 1) + byteBuffer.position());
                    return;
                }
            }
            if (i3 == length) {
                byteBuffer.position(iPosition + i3);
                return;
            }
            iPosition += i3;
            while (i3 < length) {
                char cCharAt2 = charSequence.charAt(i3);
                if (cCharAt2 < 128) {
                    byteBuffer.put(iPosition, (byte) cCharAt2);
                } else if (cCharAt2 < 2048) {
                    int i10 = iPosition + 1;
                    try {
                        byteBuffer.put(iPosition, (byte) ((cCharAt2 >>> 6) | 192));
                        byteBuffer.put(i10, (byte) ((cCharAt2 & '?') | 128));
                        iPosition = i10;
                    } catch (IndexOutOfBoundsException unused2) {
                        iPosition = i10;
                        z.d(charSequence.charAt(i3), Math.max(i3, (iPosition - byteBuffer.position()) + 1) + byteBuffer.position());
                        return;
                    }
                } else {
                    if (cCharAt2 >= 55296 && 57343 >= cCharAt2) {
                        int i11 = i3 + 1;
                        if (i11 != length) {
                            try {
                                char cCharAt3 = charSequence.charAt(i11);
                                if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                                    int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                                    int i12 = iPosition + 1;
                                    try {
                                        byteBuffer.put(iPosition, (byte) ((codePoint >>> 18) | 240));
                                        i = iPosition + 2;
                                    } catch (IndexOutOfBoundsException unused3) {
                                        iPosition = i12;
                                        i3 = i11;
                                        z.d(charSequence.charAt(i3), Math.max(i3, (iPosition - byteBuffer.position()) + 1) + byteBuffer.position());
                                        return;
                                    }
                                    try {
                                        byteBuffer.put(i12, (byte) (((codePoint >>> 12) & 63) | 128));
                                        iPosition += 3;
                                        byteBuffer.put(i, (byte) (((codePoint >>> 6) & 63) | 128));
                                        byteBuffer.put(iPosition, (byte) ((codePoint & 63) | 128));
                                        i3 = i11;
                                    } catch (IndexOutOfBoundsException unused4) {
                                        i3 = i11;
                                        iPosition = i;
                                        z.d(charSequence.charAt(i3), Math.max(i3, (iPosition - byteBuffer.position()) + 1) + byteBuffer.position());
                                        return;
                                    }
                                } else {
                                    i3 = i11;
                                }
                            } catch (IndexOutOfBoundsException unused5) {
                            }
                        }
                        throw new UnpairedSurrogateException(i3, length);
                    }
                    int i13 = iPosition + 1;
                    byteBuffer.put(iPosition, (byte) ((cCharAt2 >>> '\f') | 224));
                    iPosition += 2;
                    byteBuffer.put(i13, (byte) (((cCharAt2 >>> 6) & 63) | 128));
                    byteBuffer.put(iPosition, (byte) ((cCharAt2 & '?') | 128));
                }
                i3++;
                iPosition++;
            }
            byteBuffer.position(iPosition);
        }

        public abstract void encodeUtf8Direct(CharSequence charSequence, ByteBuffer byteBuffer);

        public final boolean isValidUtf8(byte[] bArr, int i, int i3) {
            return partialIsValidUtf8(0, bArr, i, i3) == 0;
        }

        public abstract int partialIsValidUtf8(int i, byte[] bArr, int i3, int i10);

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0017, code lost:
        
            if (r7.get(r8) > (-65)) goto L13;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x004c, code lost:
        
            if (r7.get(r8) > (-65)) goto L32;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x008f, code lost:
        
            if (r7.get(r6) > (-65)) goto L53;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final int partialIsValidUtf8Default(int r6, java.nio.ByteBuffer r7, int r8, int r9) {
            /*
                r5 = this;
                if (r6 == 0) goto L92
                if (r8 < r9) goto L5
                return r6
            L5:
                byte r5 = (byte) r6
                r0 = -32
                r1 = -1
                r2 = -65
                if (r5 >= r0) goto L1e
                r6 = -62
                if (r5 < r6) goto L1d
                int r5 = r8 + 1
                byte r6 = r7.get(r8)
                if (r6 <= r2) goto L1a
                goto L1d
            L1a:
                r8 = r5
                goto L92
            L1d:
                return r1
            L1e:
                r3 = -16
                if (r5 >= r3) goto L4f
                int r6 = r6 >> 8
                int r6 = ~r6
                byte r6 = (byte) r6
                if (r6 != 0) goto L38
                int r6 = r8 + 1
                byte r8 = r7.get(r8)
                if (r6 < r9) goto L35
                int r5 = com.google.crypto.tink.shaded.protobuf.Utf8.access$000(r5, r8)
                return r5
            L35:
                r4 = r8
                r8 = r6
                r6 = r4
            L38:
                if (r6 > r2) goto L4e
                r3 = -96
                if (r5 != r0) goto L40
                if (r6 < r3) goto L4e
            L40:
                r0 = -19
                if (r5 != r0) goto L46
                if (r6 >= r3) goto L4e
            L46:
                int r5 = r8 + 1
                byte r6 = r7.get(r8)
                if (r6 <= r2) goto L1a
            L4e:
                return r1
            L4f:
                int r0 = r6 >> 8
                int r0 = ~r0
                byte r0 = (byte) r0
                if (r0 != 0) goto L64
                int r6 = r8 + 1
                byte r0 = r7.get(r8)
                if (r6 < r9) goto L62
                int r5 = com.google.crypto.tink.shaded.protobuf.Utf8.access$000(r5, r0)
                return r5
            L62:
                r8 = 0
                goto L6a
            L64:
                int r6 = r6 >> 16
                byte r6 = (byte) r6
                r4 = r8
                r8 = r6
                r6 = r4
            L6a:
                if (r8 != 0) goto L7c
                int r8 = r6 + 1
                byte r6 = r7.get(r6)
                if (r8 < r9) goto L79
                int r5 = com.google.crypto.tink.shaded.protobuf.Utf8.access$100(r5, r0, r6)
                return r5
            L79:
                r4 = r8
                r8 = r6
                r6 = r4
            L7c:
                if (r0 > r2) goto L91
                int r5 = r5 << 28
                int r0 = r0 + 112
                int r0 = r0 + r5
                int r5 = r0 >> 30
                if (r5 != 0) goto L91
                if (r8 > r2) goto L91
                int r8 = r6 + 1
                byte r5 = r7.get(r6)
                if (r5 <= r2) goto L92
            L91:
                return r1
            L92:
                int r5 = partialIsValidUtf8(r7, r8, r9)
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.Utf8.Processor.partialIsValidUtf8Default(int, java.nio.ByteBuffer, int, int):int");
        }

        public abstract int partialIsValidUtf8Direct(int i, ByteBuffer byteBuffer, int i3, int i10);

        public final boolean isValidUtf8(ByteBuffer byteBuffer, int i, int i3) {
            return partialIsValidUtf8(0, byteBuffer, i, i3) == 0;
        }

        public final int partialIsValidUtf8(int i, ByteBuffer byteBuffer, int i3, int i10) {
            if (byteBuffer.hasArray()) {
                int iArrayOffset = byteBuffer.arrayOffset();
                return partialIsValidUtf8(i, byteBuffer.array(), i3 + iArrayOffset, iArrayOffset + i10);
            }
            if (byteBuffer.isDirect()) {
                return partialIsValidUtf8Direct(i, byteBuffer, i3, i10);
            }
            return partialIsValidUtf8Default(i, byteBuffer, i3, i10);
        }
    }

    public static boolean isValidUtf8(byte[] bArr, int i, int i3) {
        return processor.isValidUtf8(bArr, i, i3);
    }

    public static boolean isValidUtf8(byte[] bArr) {
        return processor.isValidUtf8(bArr, 0, bArr.length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int incompleteStateFor(int i, int i3) {
        if (i > -12 || i3 > -65) {
            return -1;
        }
        return i ^ (i3 << 8);
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class UnsafeProcessor extends Processor {
        public static boolean isAvailable() {
            return UnsafeUtil.hasUnsafeArrayOperations() && UnsafeUtil.hasUnsafeByteBufferOperations();
        }

        private static int unsafeEstimateConsecutiveAscii(byte[] bArr, long j10, int i) {
            int i3 = 0;
            if (i < 16) {
                return 0;
            }
            int i10 = 8 - (((int) j10) & 7);
            while (i3 < i10) {
                long j11 = 1 + j10;
                if (UnsafeUtil.getByte(bArr, j10) < 0) {
                    return i3;
                }
                i3++;
                j10 = j11;
            }
            while (true) {
                int i11 = i3 + 8;
                if (i11 > i || (UnsafeUtil.getLong((Object) bArr, UnsafeUtil.BYTE_ARRAY_BASE_OFFSET + j10) & Utf8.ASCII_MASK_LONG) != 0) {
                    break;
                }
                j10 += 8;
                i3 = i11;
            }
            while (i3 < i) {
                long j12 = j10 + 1;
                if (UnsafeUtil.getByte(bArr, j10) < 0) {
                    return i3;
                }
                i3++;
                j10 = j12;
            }
            return i;
        }

        private static int unsafeIncompleteStateFor(byte[] bArr, int i, long j10, int i3) {
            if (i3 == 0) {
                return Utf8.incompleteStateFor(i);
            }
            if (i3 == 1) {
                return Utf8.incompleteStateFor(i, UnsafeUtil.getByte(bArr, j10));
            }
            if (i3 == 2) {
                return Utf8.incompleteStateFor(i, UnsafeUtil.getByte(bArr, j10), UnsafeUtil.getByte(bArr, j10 + 1));
            }
            throw new AssertionError();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Utf8.Processor
        public String decodeUtf8(byte[] bArr, int i, int i3) throws InvalidProtocolBufferException {
            Charset charset = Internal.UTF_8;
            String str = new String(bArr, i, i3, charset);
            if (str.contains("�") && !Arrays.equals(str.getBytes(charset), Arrays.copyOfRange(bArr, i, i3 + i))) {
                throw InvalidProtocolBufferException.invalidUtf8();
            }
            return str;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Utf8.Processor
        public String decodeUtf8Direct(ByteBuffer byteBuffer, int i, int i3) throws InvalidProtocolBufferException {
            if ((i | i3 | ((byteBuffer.limit() - i) - i3)) < 0) {
                throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i), Integer.valueOf(i3)));
            }
            long jAddressOffset = UnsafeUtil.addressOffset(byteBuffer) + i;
            long j10 = i3 + jAddressOffset;
            char[] cArr = new char[i3];
            int i10 = 0;
            while (jAddressOffset < j10) {
                byte b10 = UnsafeUtil.getByte(jAddressOffset);
                if (!DecodeUtil.isOneByte(b10)) {
                    break;
                }
                jAddressOffset++;
                DecodeUtil.handleOneByte(b10, cArr, i10);
                i10++;
            }
            int i11 = i10;
            while (jAddressOffset < j10) {
                long j11 = jAddressOffset + 1;
                byte b11 = UnsafeUtil.getByte(jAddressOffset);
                if (DecodeUtil.isOneByte(b11)) {
                    int i12 = i11 + 1;
                    DecodeUtil.handleOneByte(b11, cArr, i11);
                    long j12 = j11;
                    while (j12 < j10) {
                        byte b12 = UnsafeUtil.getByte(j12);
                        if (!DecodeUtil.isOneByte(b12)) {
                            break;
                        }
                        j12++;
                        DecodeUtil.handleOneByte(b12, cArr, i12);
                        i12++;
                    }
                    i11 = i12;
                    jAddressOffset = j12;
                } else if (DecodeUtil.isTwoBytes(b11)) {
                    if (j11 >= j10) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    jAddressOffset += 2;
                    DecodeUtil.handleTwoBytes(b11, UnsafeUtil.getByte(j11), cArr, i11);
                    i11++;
                } else if (DecodeUtil.isThreeBytes(b11)) {
                    if (j11 >= j10 - 1) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    long j13 = 2 + jAddressOffset;
                    jAddressOffset += 3;
                    DecodeUtil.handleThreeBytes(b11, UnsafeUtil.getByte(j11), UnsafeUtil.getByte(j13), cArr, i11);
                    i11++;
                } else {
                    if (j11 >= j10 - 2) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    byte b13 = UnsafeUtil.getByte(j11);
                    long j14 = jAddressOffset + 3;
                    byte b14 = UnsafeUtil.getByte(2 + jAddressOffset);
                    jAddressOffset += 4;
                    DecodeUtil.handleFourBytes(b11, b13, b14, UnsafeUtil.getByte(j14), cArr, i11);
                    i11 += 2;
                }
            }
            return new String(cArr, 0, i11);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Utf8.Processor
        public int encodeUtf8(CharSequence charSequence, byte[] bArr, int i, int i3) {
            long j10;
            long j11;
            int i10;
            char cCharAt;
            long j12 = i;
            long j13 = i3 + j12;
            int length = charSequence.length();
            if (length > i3 || bArr.length - i3 < i) {
                z.d(charSequence.charAt(length - 1), i + i3);
                return 0;
            }
            int i11 = 0;
            while (true) {
                j10 = 1;
                if (i11 >= length || (cCharAt = charSequence.charAt(i11)) >= 128) {
                    break;
                }
                UnsafeUtil.putByte(bArr, j12, (byte) cCharAt);
                i11++;
                j12 = 1 + j12;
            }
            if (i11 == length) {
                return (int) j12;
            }
            while (i11 < length) {
                char cCharAt2 = charSequence.charAt(i11);
                if (cCharAt2 < 128 && j12 < j13) {
                    UnsafeUtil.putByte(bArr, j12, (byte) cCharAt2);
                    j11 = j10;
                    j12 += j10;
                } else if (cCharAt2 >= 2048 || j12 > j13 - 2) {
                    j11 = j10;
                    if ((cCharAt2 >= 55296 && 57343 >= cCharAt2) || j12 > j13 - 3) {
                        if (j12 > j13 - 4) {
                            if (55296 <= cCharAt2 && cCharAt2 <= 57343 && ((i10 = i11 + 1) == length || !Character.isSurrogatePair(cCharAt2, charSequence.charAt(i10)))) {
                                throw new UnpairedSurrogateException(i11, length);
                            }
                            z.f(cCharAt2, j12);
                            return 0;
                        }
                        int i12 = i11 + 1;
                        if (i12 != length) {
                            char cCharAt3 = charSequence.charAt(i12);
                            if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                                int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                                UnsafeUtil.putByte(bArr, j12, (byte) ((codePoint >>> 18) | 240));
                                UnsafeUtil.putByte(bArr, j12 + j11, (byte) (((codePoint >>> 12) & 63) | 128));
                                long j14 = j12 + 3;
                                UnsafeUtil.putByte(bArr, 2 + j12, (byte) (((codePoint >>> 6) & 63) | 128));
                                j12 += 4;
                                UnsafeUtil.putByte(bArr, j14, (byte) ((codePoint & 63) | 128));
                                i11 = i12;
                            } else {
                                i11 = i12;
                            }
                        }
                        throw new UnpairedSurrogateException(i11 - 1, length);
                    }
                    UnsafeUtil.putByte(bArr, j12, (byte) ((cCharAt2 >>> '\f') | 480));
                    long j15 = 2 + j12;
                    UnsafeUtil.putByte(bArr, j12 + j11, (byte) (((cCharAt2 >>> 6) & 63) | 128));
                    j12 += 3;
                    UnsafeUtil.putByte(bArr, j15, (byte) ((cCharAt2 & '?') | 128));
                } else {
                    j11 = j10;
                    long j16 = j12 + j11;
                    UnsafeUtil.putByte(bArr, j12, (byte) ((cCharAt2 >>> 6) | 960));
                    j12 += 2;
                    UnsafeUtil.putByte(bArr, j16, (byte) ((cCharAt2 & '?') | 128));
                }
                i11++;
                j10 = j11;
            }
            return (int) j12;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Utf8.Processor
        public void encodeUtf8Direct(CharSequence charSequence, ByteBuffer byteBuffer) {
            long j10;
            long j11;
            long j12;
            int i;
            char cCharAt;
            long jAddressOffset = UnsafeUtil.addressOffset(byteBuffer);
            long jPosition = byteBuffer.position() + jAddressOffset;
            long jLimit = byteBuffer.limit() + jAddressOffset;
            int length = charSequence.length();
            if (length > jLimit - jPosition) {
                z.d(charSequence.charAt(length - 1), byteBuffer.limit());
                return;
            }
            int i3 = 0;
            while (true) {
                j10 = 1;
                if (i3 >= length || (cCharAt = charSequence.charAt(i3)) >= 128) {
                    break;
                }
                UnsafeUtil.putByte(jPosition, (byte) cCharAt);
                i3++;
                jPosition = 1 + jPosition;
            }
            if (i3 == length) {
                byteBuffer.position((int) (jPosition - jAddressOffset));
                return;
            }
            while (i3 < length) {
                char cCharAt2 = charSequence.charAt(i3);
                if (cCharAt2 < 128 && jPosition < jLimit) {
                    UnsafeUtil.putByte(jPosition, (byte) cCharAt2);
                    j12 = jAddressOffset;
                    j11 = j10;
                    jPosition += j10;
                } else if (cCharAt2 >= 2048 || jPosition > jLimit - 2) {
                    j11 = j10;
                    if ((cCharAt2 >= 55296 && 57343 >= cCharAt2) || jPosition > jLimit - 3) {
                        j12 = jAddressOffset;
                        if (jPosition > jLimit - 4) {
                            if (55296 <= cCharAt2 && cCharAt2 <= 57343 && ((i = i3 + 1) == length || !Character.isSurrogatePair(cCharAt2, charSequence.charAt(i)))) {
                                throw new UnpairedSurrogateException(i3, length);
                            }
                            z.f(cCharAt2, jPosition);
                            return;
                        }
                        int i10 = i3 + 1;
                        if (i10 != length) {
                            char cCharAt3 = charSequence.charAt(i10);
                            if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                                int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                                UnsafeUtil.putByte(jPosition, (byte) ((codePoint >>> 18) | 240));
                                UnsafeUtil.putByte(jPosition + j11, (byte) (((codePoint >>> 12) & 63) | 128));
                                long j13 = jPosition + 3;
                                UnsafeUtil.putByte(jPosition + 2, (byte) (((codePoint >>> 6) & 63) | 128));
                                jPosition += 4;
                                UnsafeUtil.putByte(j13, (byte) ((codePoint & 63) | 128));
                                i3 = i10;
                            } else {
                                i3 = i10;
                            }
                        }
                        throw new UnpairedSurrogateException(i3 - 1, length);
                    }
                    UnsafeUtil.putByte(jPosition, (byte) ((cCharAt2 >>> '\f') | 480));
                    long j14 = jPosition + 2;
                    j12 = jAddressOffset;
                    UnsafeUtil.putByte(jPosition + j11, (byte) (((cCharAt2 >>> 6) & 63) | 128));
                    jPosition += 3;
                    UnsafeUtil.putByte(j14, (byte) ((cCharAt2 & '?') | 128));
                } else {
                    j11 = j10;
                    long j15 = jPosition + j11;
                    UnsafeUtil.putByte(jPosition, (byte) ((cCharAt2 >>> 6) | 960));
                    jPosition += 2;
                    UnsafeUtil.putByte(j15, (byte) ((cCharAt2 & '?') | 128));
                    j12 = jAddressOffset;
                }
                i3++;
                j10 = j11;
                jAddressOffset = j12;
            }
            byteBuffer.position((int) (jPosition - jAddressOffset));
        }

        /* JADX WARN: Code restructure failed: missing block: B:35:0x0058, code lost:
        
            if (com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getByte(r11, r0) > (-65)) goto L38;
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x009e, code lost:
        
            if (com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getByte(r11, r0) > (-65)) goto L59;
         */
        @Override // com.google.crypto.tink.shaded.protobuf.Utf8.Processor
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public int partialIsValidUtf8(int r10, byte[] r11, int r12, int r13) {
            /*
                Method dump skipped, instructions count: 197
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.Utf8.UnsafeProcessor.partialIsValidUtf8(int, byte[], int, int):int");
        }

        /* JADX WARN: Code restructure failed: missing block: B:35:0x0062, code lost:
        
            if (com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getByte(r0) > (-65)) goto L38;
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x00a8, code lost:
        
            if (com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getByte(r0) > (-65)) goto L59;
         */
        @Override // com.google.crypto.tink.shaded.protobuf.Utf8.Processor
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public int partialIsValidUtf8Direct(int r9, java.nio.ByteBuffer r10, int r11, int r12) {
            /*
                Method dump skipped, instructions count: 210
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.Utf8.UnsafeProcessor.partialIsValidUtf8Direct(int, java.nio.ByteBuffer, int, int):int");
        }

        private static int unsafeIncompleteStateFor(long j10, int i, int i3) {
            if (i3 == 0) {
                return Utf8.incompleteStateFor(i);
            }
            if (i3 == 1) {
                return Utf8.incompleteStateFor(i, UnsafeUtil.getByte(j10));
            }
            if (i3 == 2) {
                return Utf8.incompleteStateFor(i, UnsafeUtil.getByte(j10), UnsafeUtil.getByte(j10 + 1));
            }
            throw new AssertionError();
        }

        private static int unsafeEstimateConsecutiveAscii(long j10, int i) {
            if (i < 16) {
                return 0;
            }
            int i3 = (int) ((-j10) & 7);
            int i10 = i3;
            while (i10 > 0) {
                long j11 = 1 + j10;
                if (UnsafeUtil.getByte(j10) < 0) {
                    return i3 - i10;
                }
                i10--;
                j10 = j11;
            }
            int i11 = i - i3;
            while (i11 >= 8 && (UnsafeUtil.getLong(j10) & Utf8.ASCII_MASK_LONG) == 0) {
                j10 += 8;
                i11 -= 8;
            }
            return i - i11;
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
        private static int partialIsValidUtf8(byte[] r10, long r11, int r13) {
            /*
                int r0 = unsafeEstimateConsecutiveAscii(r10, r11, r13)
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
                byte r1 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getByte(r10, r11)
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
                byte r11 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getByte(r10, r11)
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
                int r10 = unsafeIncompleteStateFor(r10, r1, r11, r0)
                return r10
            L48:
                int r13 = r13 + (-3)
                long r2 = r2 + r11
                byte r0 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getByte(r10, r11)
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
                byte r0 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getByte(r10, r2)
                if (r0 <= r6) goto L7
            L64:
                return r5
            L65:
                r4 = 3
                if (r0 >= r4) goto L6d
                int r10 = unsafeIncompleteStateFor(r10, r1, r11, r0)
                return r10
            L6d:
                int r13 = r13 + (-4)
                long r2 = r2 + r11
                byte r0 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getByte(r10, r11)
                if (r0 > r6) goto L8f
                int r1 = r1 << 28
                int r0 = r0 + 112
                int r0 = r0 + r1
                int r0 = r0 >> 30
                if (r0 != 0) goto L8f
                long r8 = r8 + r11
                byte r0 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getByte(r10, r2)
                if (r0 > r6) goto L8f
                r0 = 3
                long r11 = r11 + r0
                byte r0 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getByte(r10, r8)
                if (r0 <= r6) goto L7
            L8f:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.Utf8.UnsafeProcessor.partialIsValidUtf8(byte[], long, int):int");
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
        private static int partialIsValidUtf8(long r10, int r12) {
            /*
                int r0 = unsafeEstimateConsecutiveAscii(r10, r12)
                long r1 = (long) r0
                long r10 = r10 + r1
                int r12 = r12 - r0
            L7:
                r0 = 0
                r1 = r0
            L9:
                r2 = 1
                if (r12 <= 0) goto L1a
                long r4 = r10 + r2
                byte r1 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getByte(r10)
                if (r1 < 0) goto L19
                int r12 = r12 + (-1)
                r10 = r4
                goto L9
            L19:
                r10 = r4
            L1a:
                if (r12 != 0) goto L1d
                return r0
            L1d:
                int r0 = r12 + (-1)
                r4 = -32
                r5 = -1
                r6 = -65
                if (r1 >= r4) goto L3a
                if (r0 != 0) goto L29
                return r1
            L29:
                int r12 = r12 + (-2)
                r0 = -62
                if (r1 < r0) goto L39
                long r2 = r2 + r10
                byte r10 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getByte(r10)
                if (r10 <= r6) goto L37
                goto L39
            L37:
                r10 = r2
                goto L7
            L39:
                return r5
            L3a:
                r7 = -16
                r8 = 2
                if (r1 >= r7) goto L65
                r7 = 2
                if (r0 >= r7) goto L48
                int r10 = unsafeIncompleteStateFor(r10, r1, r0)
                return r10
            L48:
                int r12 = r12 + (-3)
                long r2 = r2 + r10
                byte r0 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getByte(r10)
                if (r0 > r6) goto L64
                r7 = -96
                if (r1 != r4) goto L57
                if (r0 < r7) goto L64
            L57:
                r4 = -19
                if (r1 != r4) goto L5d
                if (r0 >= r7) goto L64
            L5d:
                long r10 = r10 + r8
                byte r0 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getByte(r2)
                if (r0 <= r6) goto L7
            L64:
                return r5
            L65:
                r4 = 3
                if (r0 >= r4) goto L6d
                int r10 = unsafeIncompleteStateFor(r10, r1, r0)
                return r10
            L6d:
                int r12 = r12 + (-4)
                long r2 = r2 + r10
                byte r0 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getByte(r10)
                if (r0 > r6) goto L8f
                int r1 = r1 << 28
                int r0 = r0 + 112
                int r0 = r0 + r1
                int r0 = r0 >> 30
                if (r0 != 0) goto L8f
                long r8 = r8 + r10
                byte r0 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getByte(r2)
                if (r0 > r6) goto L8f
                r0 = 3
                long r10 = r10 + r0
                byte r0 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getByte(r8)
                if (r0 <= r6) goto L7
            L8f:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.Utf8.UnsafeProcessor.partialIsValidUtf8(long, int):int");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int incompleteStateFor(int i, int i3, int i10) {
        if (i > -12 || i3 > -65 || i10 > -65) {
            return -1;
        }
        return (i ^ (i3 << 8)) ^ (i10 << 16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int incompleteStateFor(byte[] bArr, int i, int i3) {
        byte b10 = bArr[i - 1];
        int i10 = i3 - i;
        if (i10 == 0) {
            return incompleteStateFor(b10);
        }
        if (i10 == 1) {
            return incompleteStateFor(b10, bArr[i]);
        }
        if (i10 == 2) {
            return incompleteStateFor(b10, bArr[i], bArr[i + 1]);
        }
        throw new AssertionError();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int incompleteStateFor(int i) {
        if (i > -12) {
            return -1;
        }
        return i;
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class SafeProcessor extends Processor {
        private static int partialIsValidUtf8NonAscii(byte[] bArr, int i, int i3) {
            while (i < i3) {
                int i10 = i + 1;
                byte b10 = bArr[i];
                if (b10 < 0) {
                    if (b10 < -32) {
                        if (i10 >= i3) {
                            return b10;
                        }
                        if (b10 >= -62) {
                            i += 2;
                            if (bArr[i10] > -65) {
                            }
                        }
                        return -1;
                    }
                    if (b10 < -16) {
                        if (i10 >= i3 - 1) {
                            return Utf8.incompleteStateFor(bArr, i10, i3);
                        }
                        int i11 = i + 2;
                        byte b11 = bArr[i10];
                        if (b11 <= -65 && ((b10 != -32 || b11 >= -96) && (b10 != -19 || b11 < -96))) {
                            i += 3;
                            if (bArr[i11] > -65) {
                            }
                        }
                        return -1;
                    }
                    if (i10 >= i3 - 2) {
                        return Utf8.incompleteStateFor(bArr, i10, i3);
                    }
                    int i12 = i + 2;
                    byte b12 = bArr[i10];
                    if (b12 <= -65) {
                        if ((((b12 + 112) + (b10 << 28)) >> 30) == 0) {
                            int i13 = i + 3;
                            if (bArr[i12] <= -65) {
                                i += 4;
                                if (bArr[i13] > -65) {
                                }
                            }
                        }
                    }
                    return -1;
                }
                i = i10;
            }
            return 0;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Utf8.Processor
        public String decodeUtf8(byte[] bArr, int i, int i3) throws InvalidProtocolBufferException {
            if ((i | i3 | ((bArr.length - i) - i3)) < 0) {
                throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i3)));
            }
            int i10 = i + i3;
            char[] cArr = new char[i3];
            int i11 = 0;
            while (i < i10) {
                byte b10 = bArr[i];
                if (!DecodeUtil.isOneByte(b10)) {
                    break;
                }
                i++;
                DecodeUtil.handleOneByte(b10, cArr, i11);
                i11++;
            }
            int i12 = i11;
            while (i < i10) {
                int i13 = i + 1;
                byte b11 = bArr[i];
                if (DecodeUtil.isOneByte(b11)) {
                    int i14 = i12 + 1;
                    DecodeUtil.handleOneByte(b11, cArr, i12);
                    int i15 = i13;
                    while (i15 < i10) {
                        byte b12 = bArr[i15];
                        if (!DecodeUtil.isOneByte(b12)) {
                            break;
                        }
                        i15++;
                        DecodeUtil.handleOneByte(b12, cArr, i14);
                        i14++;
                    }
                    i12 = i14;
                    i = i15;
                } else if (DecodeUtil.isTwoBytes(b11)) {
                    if (i13 >= i10) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    i += 2;
                    DecodeUtil.handleTwoBytes(b11, bArr[i13], cArr, i12);
                    i12++;
                } else if (DecodeUtil.isThreeBytes(b11)) {
                    if (i13 >= i10 - 1) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    int i16 = i + 2;
                    i += 3;
                    DecodeUtil.handleThreeBytes(b11, bArr[i13], bArr[i16], cArr, i12);
                    i12++;
                } else {
                    if (i13 >= i10 - 2) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    byte b13 = bArr[i13];
                    int i17 = i + 3;
                    byte b14 = bArr[i + 2];
                    i += 4;
                    DecodeUtil.handleFourBytes(b11, b13, b14, bArr[i17], cArr, i12);
                    i12 += 2;
                }
            }
            return new String(cArr, 0, i12);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Utf8.Processor
        public String decodeUtf8Direct(ByteBuffer byteBuffer, int i, int i3) {
            return decodeUtf8Default(byteBuffer, i, i3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Utf8.Processor
        public int encodeUtf8(CharSequence charSequence, byte[] bArr, int i, int i3) {
            int i10;
            int i11;
            char cCharAt;
            int length = charSequence.length();
            int i12 = i3 + i;
            int i13 = 0;
            while (i13 < length && (i11 = i13 + i) < i12 && (cCharAt = charSequence.charAt(i13)) < 128) {
                bArr[i11] = (byte) cCharAt;
                i13++;
            }
            if (i13 == length) {
                return i + length;
            }
            int i14 = i + i13;
            while (i13 < length) {
                char cCharAt2 = charSequence.charAt(i13);
                if (cCharAt2 < 128 && i14 < i12) {
                    bArr[i14] = (byte) cCharAt2;
                    i14++;
                } else if (cCharAt2 < 2048 && i14 <= i12 - 2) {
                    int i15 = i14 + 1;
                    bArr[i14] = (byte) ((cCharAt2 >>> 6) | 960);
                    i14 += 2;
                    bArr[i15] = (byte) ((cCharAt2 & '?') | 128);
                } else {
                    if ((cCharAt2 >= 55296 && 57343 >= cCharAt2) || i14 > i12 - 3) {
                        if (i14 > i12 - 4) {
                            if (55296 <= cCharAt2 && cCharAt2 <= 57343 && ((i10 = i13 + 1) == charSequence.length() || !Character.isSurrogatePair(cCharAt2, charSequence.charAt(i10)))) {
                                throw new UnpairedSurrogateException(i13, length);
                            }
                            throw new ArrayIndexOutOfBoundsException("Failed writing " + cCharAt2 + " at index " + i14);
                        }
                        int i16 = i13 + 1;
                        if (i16 != charSequence.length()) {
                            char cCharAt3 = charSequence.charAt(i16);
                            if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                                int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                                bArr[i14] = (byte) ((codePoint >>> 18) | 240);
                                bArr[i14 + 1] = (byte) (((codePoint >>> 12) & 63) | 128);
                                int i17 = i14 + 3;
                                bArr[i14 + 2] = (byte) (((codePoint >>> 6) & 63) | 128);
                                i14 += 4;
                                bArr[i17] = (byte) ((codePoint & 63) | 128);
                                i13 = i16;
                            } else {
                                i13 = i16;
                            }
                        }
                        throw new UnpairedSurrogateException(i13 - 1, length);
                    }
                    bArr[i14] = (byte) ((cCharAt2 >>> '\f') | 480);
                    int i18 = i14 + 2;
                    bArr[i14 + 1] = (byte) (((cCharAt2 >>> 6) & 63) | 128);
                    i14 += 3;
                    bArr[i18] = (byte) ((cCharAt2 & '?') | 128);
                }
                i13++;
            }
            return i14;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Utf8.Processor
        public void encodeUtf8Direct(CharSequence charSequence, ByteBuffer byteBuffer) {
            encodeUtf8Default(charSequence, byteBuffer);
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
        @Override // com.google.crypto.tink.shaded.protobuf.Utf8.Processor
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public int partialIsValidUtf8(int r6, byte[] r7, int r8, int r9) {
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
                int r5 = com.google.crypto.tink.shaded.protobuf.Utf8.access$000(r5, r8)
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
                int r5 = com.google.crypto.tink.shaded.protobuf.Utf8.access$000(r5, r0)
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
                int r5 = com.google.crypto.tink.shaded.protobuf.Utf8.access$100(r5, r0, r6)
                return r5
            L6f:
                r4 = r8
                r8 = r6
                r6 = r4
            L72:
                if (r0 > r2) goto L85
                int r5 = r5 << 28
                int r0 = r0 + 112
                int r0 = r0 + r5
                int r5 = r0 >> 30
                if (r5 != 0) goto L85
                if (r8 > r2) goto L85
                int r8 = r6 + 1
                r5 = r7[r6]
                if (r5 <= r2) goto L86
            L85:
                return r1
            L86:
                int r5 = partialIsValidUtf8(r7, r8, r9)
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.Utf8.SafeProcessor.partialIsValidUtf8(int, byte[], int, int):int");
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Utf8.Processor
        public int partialIsValidUtf8Direct(int i, ByteBuffer byteBuffer, int i3, int i10) {
            return partialIsValidUtf8Default(i, byteBuffer, i3, i10);
        }

        private static int partialIsValidUtf8(byte[] bArr, int i, int i3) {
            while (i < i3 && bArr[i] >= 0) {
                i++;
            }
            if (i >= i3) {
                return 0;
            }
            return partialIsValidUtf8NonAscii(bArr, i, i3);
        }
    }
}
