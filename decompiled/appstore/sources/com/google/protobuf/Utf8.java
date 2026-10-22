package com.google.protobuf;

import com.google.common.base.Ascii;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
final class Utf8 {
    private static final long ASCII_MASK_LONG = -9187201950435737472L;
    public static final int COMPLETE = 0;
    public static final int MALFORMED = -1;
    static final int MAX_BYTES_PER_CHAR = 3;
    private static final int UNSAFE_COUNT_ASCII_THRESHOLD = 16;
    private static final Processor processor = null;

    public static abstract class Processor {
        public Processor() {
        }

        public abstract int encodeUtf8(CharSequence r10, byte[] r11, int r12, int r13);

        public final void encodeUtf8(CharSequence r10, ByteBuffer r11) {
            if (r11.hasArray() == false) goto L6;
            int r12 = r11.arrayOffset();
            r11.position(Utf8.encode(r10, r11.array(), r11.position() + r12, r11.remaining()) - r12);
            return;
        L6:
            if (r11.isDirect() == false) goto L8;
            encodeUtf8Direct(r10, r11);
            return;
        L8:
            encodeUtf8Default(r10, r11);
        }

        public final void encodeUtf8Default(CharSequence r10, ByteBuffer r11) {
            int r12 = r10.length();
            int r13 = r11.position();
            int r14 = 0;
        L4:
            if (r14 >= r12) goto L8;
            char r15 = r10.charAt(r14);     // Catch: IndexOutOfBoundsException -> L56
            if (r15 >= 128) goto L8;
            r11.put(r13 + r14, (byte) r15);     // Catch: IndexOutOfBoundsException -> L56
            r14 = r14 + 1;     // Catch: IndexOutOfBoundsException -> L56
        L54:
            throw new ArrayIndexOutOfBoundsException("Failed writing " + r10.charAt(r14) + " at index " + (r11.position() + Math.max(r14, (r13 - r11.position()) + 1)));
        L8:
            if (r14 != r12) goto L11;
            r11.position(r13 + r14);     // Catch: IndexOutOfBoundsException -> L56
            return;
        L11:
            r13 = r13 + r14;     // Catch: IndexOutOfBoundsException -> L56
        L12:
            if (r14 >= r12) goto L51;
            char r16 = r10.charAt(r14);     // Catch: IndexOutOfBoundsException -> L56
            if (r16 >= 128) goto L18;
            r11.put(r13, (byte) r16);     // Catch: IndexOutOfBoundsException -> L56
        L50:
            r14 = r14 + 1;     // Catch: IndexOutOfBoundsException -> L56
            r13 = r13 + 1;     // Catch: IndexOutOfBoundsException -> L56
            goto L12
        L18:
            if (r16 >= 2048) goto L24;
            int r17 = r13 + 1;
            r11.put(r13, (byte) ((r16 >>> 6) | 192));     // Catch: IndexOutOfBoundsException -> L22
            r11.put(r17, (byte) ((r16 & '?') | 128));     // Catch: IndexOutOfBoundsException -> L22
            r13 = r17;
        L22:
            r13 = r17;
            goto L54
        L24:
            if (r16 >= 55296) goto L26;
        L46:
            int r18 = r13 + 1;
            r11.put(r13, (byte) ((r16 >>> '\f') | 224));     // Catch: IndexOutOfBoundsException -> L22
            r13 = r13 + 2;
            r11.put(r18, (byte) (((r16 >>> 6) & 63) | 128));     // Catch: IndexOutOfBoundsException -> L56
            r11.put(r13, (byte) ((r16 & '?') | 128));     // Catch: IndexOutOfBoundsException -> L56
            goto L50
        L26:
            if (57343 < r16) goto L46;
            int r19 = r14 + 1;
            if (r19 == r12) goto L45;
            char r20 = r10.charAt(r19);     // Catch: IndexOutOfBoundsException -> L55
            if (Character.isSurrogatePair(r16, r20) == false) goto L43;
            int r21 = Character.toCodePoint(r16, r20);     // Catch: IndexOutOfBoundsException -> L55
            int r22 = r13 + 1;
            r11.put(r13, (byte) ((r21 >>> 18) | 240));     // Catch: IndexOutOfBoundsException -> L42
            int r23 = r13 + 2;
            r11.put(r22, (byte) (((r21 >>> 12) & 63) | 128));     // Catch: IndexOutOfBoundsException -> L41
            r13 = r13 + 3;
            r11.put(r23, (byte) (((r21 >>> 6) & 63) | 128));     // Catch: IndexOutOfBoundsException -> L55
            r11.put(r13, (byte) ((r21 & 63) | 128));     // Catch: IndexOutOfBoundsException -> L55
            r14 = r19;
        L41:
            r14 = r19;
            r13 = r23;
        L42:
            r13 = r22;
            goto L40
        L43:
            r14 = r19;
        L40:
            r14 = r19;
        L45:
            throw new UnpairedSurrogateException(r14, r12);     // Catch: IndexOutOfBoundsException -> L56
        L51:
            r11.position(r13);     // Catch: IndexOutOfBoundsException -> L56
        }

        public abstract void encodeUtf8Direct(CharSequence r10, ByteBuffer r11);

        public final boolean isValidUtf8(byte[] r10, int r11, int r12) {
            if (partialIsValidUtf8(0, r10, r11, r12) != 0) goto L6;
            return true;
        L6:
            return false;
        }

        public final int partialIsValidUtf8(int r10, ByteBuffer r11, int r12, int r13) {
            if (r11.hasArray() == false) goto L7;
            int r14 = r11.arrayOffset();
            return partialIsValidUtf8(r10, r11.array(), r12 + r14, r14 + r13);
        L7:
            if (r11.isDirect() == false) goto L11;
            return partialIsValidUtf8Direct(r10, r11, r12, r13);
        L11:
            return partialIsValidUtf8Default(r10, r11, r12, r13);
        }

        public abstract int partialIsValidUtf8(int r10, byte[] r11, int r12, int r13);

        public final int partialIsValidUtf8Default(int r10, ByteBuffer r11, int r12, int r13) {
            if (r10 == 0) goto L55;
            if (r12 < r13) goto L5;
            return r10;
        L5:
            byte r14 = (byte) r10;
            if (r14 >= (-32)) goto L15;
            if (r14 < (-62)) goto L13;
            int r15 = r12 + 1;
            if (r11.get(r12) > (-65)) goto L13;
        L12:
            r12 = r15;
        L13:
            return -1;
        L15:
            if (r14 >= (-16)) goto L33;
            byte r16 = (byte) (~(r10 >> 8));
            if (r16 != 0) goto L23;
            int r17 = r12 + 1;
            byte r18 = r11.get(r12);
            if (r17 >= r13) goto L21;
            r12 = r17;
            r16 = r18;
            goto L23
        L21:
            return Utf8.access$000(r14, r18);
        L23:
            if (r16 <= (-65)) goto L25;
        L32:
            return -1;
        L25:
            if (r14 != (-32)) goto L28;
            if (r16 < (-96)) goto L32;
        L28:
            if (r14 != (-19)) goto L30;
            if (r16 >= (-96)) goto L32;
        L30:
            r15 = r12 + 1;
            if (r11.get(r12) <= (-65)) goto L12;
        L33:
            byte r19 = (byte) (~(r10 >> 8));
            if (r19 != 0) goto L40;
            int r20 = r12 + 1;
            r19 = r11.get(r12);
            if (r20 >= r13) goto L38;
            byte r21 = 0;
        L41:
            if (r21 != 0) goto L47;
            int r22 = r20 + 1;
            byte r23 = r11.get(r20);
            if (r22 >= r13) goto L45;
            r21 = r23;
            r20 = r22;
            goto L47
        L45:
            return Utf8.access$100(r14, r19, r23);
        L47:
            if (r19 <= (-65)) goto L49;
        L53:
            return -1;
        L49:
            if ((((r14 << Ascii.FS) + (r19 + 112)) >> 30) != 0) goto L53;
            if (r21 > (-65)) goto L53;
            r12 = r20 + 1;
            if (r11.get(r20) <= (-65)) goto L55;
        L38:
            return Utf8.access$000(r14, r19);
        L40:
            r21 = (byte) (r10 >> 16);
            r20 = r12;
        L55:
            return partialIsValidUtf8(r11, r12, r13);
        }

        public abstract int partialIsValidUtf8Direct(int r10, ByteBuffer r11, int r12, int r13);

        public final boolean isValidUtf8(ByteBuffer r10, int r11, int r12) {
            if (partialIsValidUtf8(0, r10, r11, r12) != 0) goto L6;
            return true;
        L6:
            return false;
        }

        private static int partialIsValidUtf8(ByteBuffer r10, int r11, int r12) {
            int r13 = r11 + Utf8.access$200(r10, r11, r12);
        L3:
            if (r13 >= r12) goto L4;
            int r14 = r13 + 1;
            byte r15 = r10.get(r13);
            if (r15 < 0) goto L9;
            r13 = r14;
            goto L3
        L9:
            if (r15 < (-32)) goto L10;
            if (r15 < (-16)) goto L22;
            if (r14 >= (r12 - 2)) goto L41;
            int r16 = r13 + 2;
            byte r17 = r10.get(r14);
            if (r17 > (-65)) goto L50;
            if ((((r15 << Ascii.FS) + (r17 + 112)) >> 30) != 0) goto L50;
            int r18 = r13 + 3;
            if (r10.get(r16) > (-65)) goto L50;
            r13 = r13 + 4;
            if (r10.get(r18) <= (-65)) goto L3;
        L50:
            return -1;
        L41:
            return Utf8.access$300(r10, r15, r14, r12 - r14);
        L22:
            if (r14 >= (r12 - 1)) goto L24;
            int r19 = r13 + 2;
            byte r20 = r10.get(r14);
            if (r20 > (-65)) goto L37;
            if (r15 != (-32)) goto L31;
            if (r20 < (-96)) goto L37;
        L31:
            if (r15 != (-19)) goto L34;
            if (r20 >= (-96)) goto L37;
        L34:
            if (r10.get(r19) > (-65)) goto L37;
            r13 = r13 + 3;
        L37:
            return -1;
        L24:
            return Utf8.access$300(r10, r15, r14, r12 - r14);
        L10:
            if (r14 >= r12) goto L11;
            if (r15 < (-62)) goto L18;
            if (r10.get(r14) > (-65)) goto L18;
            r13 = r13 + 2;
        L18:
            return -1;
        L11:
            return r15;
        L4:
            return 0;
        }
    }

    public static final class SafeProcessor extends Processor {
        public SafeProcessor() {
        }

        private static int partialIsValidUtf8NonAscii(byte[] r10, int r11, int r12) {
        L2:
            if (r11 >= r12) goto L3;
            int r13 = r11 + 1;
            byte r14 = r10[r11];
            if (r14 < 0) goto L8;
            r11 = r13;
            goto L2
        L8:
            if (r14 < (-32)) goto L9;
            if (r14 < (-16)) goto L19;
            if (r13 >= (r12 - 2)) goto L36;
            int r15 = r11 + 2;
            byte r16 = r10[r13];
            if (r16 > (-65)) goto L45;
            if ((((r14 << Ascii.FS) + (r16 + 112)) >> 30) != 0) goto L45;
            int r17 = r11 + 3;
            if (r10[r15] > (-65)) goto L45;
            r11 = r11 + 4;
            if (r10[r17] <= (-65)) goto L2;
        L45:
            return -1;
        L36:
            return Utf8.access$400(r10, r13, r12);
        L19:
            if (r13 >= (r12 - 1)) goto L21;
            int r18 = r11 + 2;
            byte r19 = r10[r13];
            if (r19 > (-65)) goto L32;
            if (r14 != (-32)) goto L28;
            if (r19 < (-96)) goto L32;
        L28:
            if (r14 != (-19)) goto L30;
            if (r19 >= (-96)) goto L32;
        L30:
            r11 = r11 + 3;
            if (r10[r18] <= (-65)) goto L2;
        L32:
            return -1;
        L21:
            return Utf8.access$400(r10, r13, r12);
        L9:
            if (r13 >= r12) goto L10;
            if (r14 < (-62)) goto L15;
            r11 = r11 + 2;
            if (r10[r13] <= (-65)) goto L2;
        L15:
            return -1;
        L10:
            return r14;
        L3:
            return 0;
        }

        @Override // com.google.protobuf.Utf8.Processor
        public int encodeUtf8(CharSequence r10, byte[] r11, int r12, int r13) {
            int r14 = r10.length();
            int r15 = r13 + r12;
            int r16 = 0;
        L4:
            if (r16 >= r14) goto L10;
            int r17 = r16 + r12;
            if (r17 >= r15) goto L10;
            char r18 = r10.charAt(r16);
            if (r18 >= 128) goto L10;
            r11[r17] = (byte) r18;
            r16 = r16 + 1;
        L10:
            if (r16 == r14) goto L12;
            int r19 = r12 + r16;
        L14:
            if (r16 >= r14) goto L51;
            char r20 = r10.charAt(r16);
            if (r20 >= 128) goto L20;
            if (r19 >= r15) goto L20;
            r11[r19] = (byte) r20;
            r19 = r19 + 1;
        L37:
            r16 = r16 + 1;
        L20:
            if (r20 >= 2048) goto L25;
            if (r19 > (r15 - 2)) goto L25;
            int r21 = r19 + 1;
            r11[r19] = (byte) ((r20 >>> 6) | 960);
            r19 = r19 + 2;
            r11[r21] = (byte) ((r20 & '?') | 128);
        L25:
            if (r20 < 55296) goto L28;
            if (57343 < r20) goto L28;
        L31:
            if (r19 > (r15 - 4)) goto L41;
            int r22 = r16 + 1;
            if (r22 == r10.length()) goto L40;
            char r23 = r10.charAt(r22);
            if (Character.isSurrogatePair(r20, r23) == false) goto L38;
            int r24 = Character.toCodePoint(r20, r23);
            r11[r19] = (byte) ((r24 >>> 18) | 240);
            r11[r19 + 1] = (byte) (((r24 >>> 12) & 63) | 128);
            int r25 = r19 + 3;
            r11[r19 + 2] = (byte) (((r24 >>> 6) & 63) | 128);
            r19 = r19 + 4;
            r11[r25] = (byte) ((r24 & 63) | 128);
            r16 = r22;
            goto L37
        L38:
            r16 = r22;
        L40:
            throw new UnpairedSurrogateException(r16 - 1, r14);
        L41:
            if (55296 > r20) goto L50;
            if (r20 > 57343) goto L50;
            int r26 = r16 + 1;
            if (r26 == r10.length()) goto L48;
            if (Character.isSurrogatePair(r20, r10.charAt(r26)) == true) goto L50;
        L48:
            throw new UnpairedSurrogateException(r16, r14);
        L50:
            throw new ArrayIndexOutOfBoundsException("Failed writing " + r20 + " at index " + r19);
        L28:
            if (r19 > (r15 - 3)) goto L31;
            r11[r19] = (byte) ((r20 >>> '\f') | 480);
            int r27 = r19 + 2;
            r11[r19 + 1] = (byte) (((r20 >>> 6) & 63) | 128);
            r19 = r19 + 3;
            r11[r27] = (byte) ((r20 & '?') | 128);
            goto L37
        L51:
            return r19;
        L12:
            return r12 + r14;
        }

        @Override // com.google.protobuf.Utf8.Processor
        public void encodeUtf8Direct(CharSequence r10, ByteBuffer r11) {
            encodeUtf8Default(r10, r11);
        }

        @Override // com.google.protobuf.Utf8.Processor
        public int partialIsValidUtf8(int r10, byte[] r11, int r12, int r13) {
            if (r10 == 0) goto L55;
            if (r12 < r13) goto L5;
            return r10;
        L5:
            byte r14 = (byte) r10;
            if (r14 >= (-32)) goto L15;
            if (r14 < (-62)) goto L13;
            int r15 = r12 + 1;
            if (r11[r12] > (-65)) goto L13;
        L12:
            r12 = r15;
        L13:
            return -1;
        L15:
            if (r14 >= (-16)) goto L33;
            byte r16 = (byte) (~(r10 >> 8));
            if (r16 != 0) goto L23;
            int r17 = r12 + 1;
            byte r18 = r11[r12];
            if (r17 >= r13) goto L21;
            r12 = r17;
            r16 = r18;
            goto L23
        L21:
            return Utf8.access$000(r14, r18);
        L23:
            if (r16 <= (-65)) goto L25;
        L32:
            return -1;
        L25:
            if (r14 != (-32)) goto L28;
            if (r16 < (-96)) goto L32;
        L28:
            if (r14 != (-19)) goto L30;
            if (r16 >= (-96)) goto L32;
        L30:
            r15 = r12 + 1;
            if (r11[r12] <= (-65)) goto L12;
        L33:
            byte r19 = (byte) (~(r10 >> 8));
            if (r19 != 0) goto L40;
            int r20 = r12 + 1;
            r19 = r11[r12];
            if (r20 >= r13) goto L38;
            byte r21 = 0;
        L41:
            if (r21 != 0) goto L47;
            int r22 = r20 + 1;
            byte r23 = r11[r20];
            if (r22 >= r13) goto L45;
            r21 = r23;
            r20 = r22;
            goto L47
        L45:
            return Utf8.access$100(r14, r19, r23);
        L47:
            if (r19 <= (-65)) goto L49;
        L53:
            return -1;
        L49:
            if ((((r14 << Ascii.FS) + (r19 + 112)) >> 30) != 0) goto L53;
            if (r21 > (-65)) goto L53;
            r12 = r20 + 1;
            if (r11[r20] <= (-65)) goto L55;
        L38:
            return Utf8.access$000(r14, r19);
        L40:
            r21 = (byte) (r10 >> 16);
            r20 = r12;
        L55:
            return partialIsValidUtf8(r11, r12, r13);
        }

        @Override // com.google.protobuf.Utf8.Processor
        public int partialIsValidUtf8Direct(int r10, ByteBuffer r11, int r12, int r13) {
            return partialIsValidUtf8Default(r10, r11, r12, r13);
        }

        private static int partialIsValidUtf8(byte[] r10, int r11, int r12) {
        L2:
            if (r11 >= r12) goto L6;
            if (r10[r11] < 0) goto L6;
            r11 = r11 + 1;
        L6:
            if (r11 < r12) goto L9;
            return 0;
        L9:
            return partialIsValidUtf8NonAscii(r10, r11, r12);
        }
    }

    public static class UnpairedSurrogateException extends IllegalArgumentException {
        public UnpairedSurrogateException(int r10, int r11) {
            super("Unpaired surrogate at index " + r10 + " of " + r11);
        }
    }

    public static final class UnsafeProcessor extends Processor {
        public UnsafeProcessor() {
        }

        public static boolean isAvailable() {
            if (UnsafeUtil.hasUnsafeArrayOperations() == true) goto L5;
        L7:
            return false;
        L5:
            if (UnsafeUtil.hasUnsafeByteBufferOperations() == false) goto L7;
            return true;
        }

        private static int unsafeEstimateConsecutiveAscii(byte[] r10, long r11, int r12) {
            if (r12 >= 16) goto L6;
            return 0;
        L6:
            int r13 = ((int) r11) & 7;
            int r14 = r13;
        L7:
            if (r14 <= 0) goto L13;
            long r15 = 1 + r11;
            if (UnsafeUtil.getByte(r10, r11) < 0) goto L11;
            r14 = r14 - 1;
            r11 = r15;
            goto L7
        L11:
            return r13 - r14;
        L13:
            int r16 = r12 - r13;
        L15:
            if (r16 < 8) goto L20;
            if ((UnsafeUtil.getLong(r10, r11) & Utf8.ASCII_MASK_LONG) != 0) goto L20;
            r11 = r11 + 8;
            r16 = r16 - 8;
        L20:
            return r12 - r16;
        }

        private static int unsafeIncompleteStateFor(byte[] r10, int r11, long r12, int r13) {
            if (r13 == 0) goto L14;
            if (r13 == 1) goto L12;
            if (r13 != 2) goto L10;
            return Utf8.access$100(r11, UnsafeUtil.getByte(r10, r12), UnsafeUtil.getByte(r10, r12 + 1));
        L10:
            throw new AssertionError();
        L12:
            return Utf8.access$000(r11, UnsafeUtil.getByte(r10, r12));
        L14:
            return Utf8.access$500(r11);
        }

        @Override // com.google.protobuf.Utf8.Processor
        public int encodeUtf8(CharSequence r24, byte[] r25, int r26, int r27) {
            long r10 = UnsafeUtil.getArrayBaseOffset() + ((long) r26);
            long r11 = ((long) r27) + r10;
            int r12 = r24.length();
            String r13 = " at index ";
            String r14 = "Failed writing ";
            if (r12 > r27) goto L57;
            if ((r25.length - r27) < r26) goto L57;
            int r15 = 0;
        L7:
            long r16 = 1;
            if (r15 >= r12) goto L12;
            char r17 = r24.charAt(r15);
            if (r17 >= 128) goto L12;
            UnsafeUtil.putByte(r25, r10, (byte) r17);
            r15 = r15 + 1;
            r10 = 1 + r10;
        L12:
            if (r15 != r12) goto L16;
            long r18 = UnsafeUtil.getArrayBaseOffset();
        L15:
            return (int) (r10 - r18);
        L16:
            if (r15 >= r12) goto L55;
            char r19 = r24.charAt(r15);
            if (r19 >= 128) goto L23;
            if (r10 >= r11) goto L23;
            UnsafeUtil.putByte(r25, r10, (byte) r19);
            String r23 = r13;
            long r110 = r16;
            r10 = r10 + r16;
            String r111 = r14;
        L41:
            r15 = r15 + 1;
            r13 = r23;
            r14 = r111;
            r16 = r110;
            r11 = r11;
        L23:
            if (r19 < 2048) goto L25;
        L28:
            r23 = r13;
            r111 = r14;
            if (r19 < 55296) goto L32;
            if (57343 < r19) goto L32;
        L35:
            if (r10 > (r11 - 4)) goto L45;
            int r20 = r15 + 1;
            if (r20 == r12) goto L44;
            char r21 = r24.charAt(r20);
            if (Character.isSurrogatePair(r19, r21) == false) goto L42;
            int r22 = Character.toCodePoint(r19, r21);
            r110 = 1;
            UnsafeUtil.putByte(r25, r10, (byte) ((r22 >>> 18) | 240));
            UnsafeUtil.putByte(r25, r10 + 1, (byte) (((r22 >>> 12) & 63) | 128));
            long r112 = r10 + 3;
            UnsafeUtil.putByte(r25, r10 + 2, (byte) (((r22 >>> 6) & 63) | 128));
            r10 = r10 + 4;
            UnsafeUtil.putByte(r25, r112, (byte) ((r22 & 63) | 128));
            r15 = r20;
            goto L41
        L42:
            r15 = r20;
        L44:
            throw new UnpairedSurrogateException(r15 - 1, r12);
        L45:
            if (55296 > r19) goto L54;
            if (r19 > 57343) goto L54;
            int r28 = r15 + 1;
            if (r28 == r12) goto L52;
            if (Character.isSurrogatePair(r19, r24.charAt(r28)) == true) goto L54;
        L52:
            throw new UnpairedSurrogateException(r15, r12);
        L54:
            throw new ArrayIndexOutOfBoundsException(r111 + r19 + r23 + r10);
        L32:
            if (r10 > (r11 - 3)) goto L35;
            UnsafeUtil.putByte(r25, r10, (byte) ((r19 >>> '\f') | 480));
            long r113 = r10 + 2;
            UnsafeUtil.putByte(r25, r10 + 1, (byte) (((r19 >>> 6) & 63) | 128));
            r10 = r10 + 3;
            UnsafeUtil.putByte(r25, r113, (byte) ((r19 & '?') | 128));
        L27:
            r110 = 1;
            goto L41
        L25:
            if (r10 > (r11 - 2)) goto L28;
            r23 = r13;
            r111 = r14;
            long r29 = r10 + r16;
            UnsafeUtil.putByte(r25, r10, (byte) ((r19 >>> 6) | 960));
            r10 = r10 + 2;
            UnsafeUtil.putByte(r25, r29, (byte) ((r19 & '?') | 128));
            goto L27
        L55:
            r18 = UnsafeUtil.getArrayBaseOffset();
        L57:
            throw new ArrayIndexOutOfBoundsException("Failed writing " + r24.charAt(r12 - 1) + " at index " + (r26 + r27));
        }

        @Override // com.google.protobuf.Utf8.Processor
        public void encodeUtf8Direct(CharSequence r27, ByteBuffer r28) {
            long r10 = UnsafeUtil.addressOffset(r28);
            long r11 = ((long) r28.position()) + r10;
            long r12 = ((long) r28.limit()) + r10;
            int r13 = r27.length();
            if (r13 > (r12 - r11)) goto L55;
            int r14 = 0;
        L5:
            long r15 = 1;
            char r16 = 128;
            if (r14 >= r13) goto L10;
            char r17 = r27.charAt(r14);
            if (r17 >= 128) goto L10;
            UnsafeUtil.putByte(r11, (byte) r17);
            r14 = r14 + 1;
            r11 = 1 + r11;
        L10:
            if (r14 != r13) goto L13;
            r28.position((int) (r11 - r10));
            return;
        L13:
            if (r14 >= r13) goto L52;
            char r18 = r27.charAt(r14);
            if (r18 >= r16) goto L20;
            if (r11 >= r12) goto L20;
            UnsafeUtil.putByte(r11, (byte) r18);
            long r19 = r10;
            int r20 = r14;
            char r21 = r16;
            r11 = r11 + r15;
        L38:
            r16 = r21;
            r10 = r19;
            r15 = 1;
            r14 = r20 + 1;
        L20:
            if (r18 < 2048) goto L22;
        L25:
            r19 = r10;
            if (r18 < 55296) goto L29;
            if (57343 < r18) goto L29;
        L32:
            if (r11 > (r12 - 4)) goto L42;
            r20 = r14 + 1;
            if (r20 == r13) goto L41;
            char r22 = r27.charAt(r20);
            if (Character.isSurrogatePair(r18, r22) == false) goto L39;
            int r23 = Character.toCodePoint(r18, r22);
            UnsafeUtil.putByte(r11, (byte) ((r23 >>> 18) | 240));
            r21 = 128;
            UnsafeUtil.putByte(r11 + 1, (byte) (((r23 >>> 12) & 63) | 128));
            long r110 = r11 + 3;
            UnsafeUtil.putByte(r11 + 2, (byte) (((r23 >>> 6) & 63) | 128));
            r11 = r11 + 4;
            UnsafeUtil.putByte(r110, (byte) ((r23 & 63) | 128));
            goto L38
        L39:
            r14 = r20;
        L41:
            throw new UnpairedSurrogateException(r14 - 1, r13);
        L42:
            if (55296 > r18) goto L51;
            if (r18 > 57343) goto L51;
            int r24 = r14 + 1;
            if (r24 == r13) goto L49;
            if (Character.isSurrogatePair(r18, r27.charAt(r24)) == true) goto L51;
        L49:
            throw new UnpairedSurrogateException(r14, r13);
        L51:
            throw new ArrayIndexOutOfBoundsException("Failed writing " + r18 + " at index " + r11);
        L29:
            if (r11 > (r12 - 3)) goto L32;
            long r25 = r11 + r15;
            UnsafeUtil.putByte(r11, (byte) ((r18 >>> '\f') | 480));
            long r111 = r11 + 2;
            UnsafeUtil.putByte(r25, (byte) (((r18 >>> 6) & 63) | 128));
            r11 = r11 + 3;
            UnsafeUtil.putByte(r111, (byte) ((r18 & '?') | 128));
        L24:
            r20 = r14;
            r21 = 128;
            goto L38
        L22:
            if (r11 > (r12 - 2)) goto L25;
            r19 = r10;
            long r26 = r11 + r15;
            UnsafeUtil.putByte(r11, (byte) ((r18 >>> 6) | 960));
            r11 = r11 + 2;
            UnsafeUtil.putByte(r26, (byte) ((r18 & '?') | 128));
            goto L24
        L52:
            r28.position((int) (r11 - r10));
            return;
        L55:
            throw new ArrayIndexOutOfBoundsException("Failed writing " + r27.charAt(r13 - 1) + " at index " + r28.limit());
        }

        @Override // com.google.protobuf.Utf8.Processor
        public int partialIsValidUtf8(int r10, byte[] r11, int r12, int r13) {
            if (((r12 | r13) | (r11.length - r13)) < 0) goto L63;
            long r14 = UnsafeUtil.getArrayBaseOffset() + ((long) r12);
            long r15 = UnsafeUtil.getArrayBaseOffset() + ((long) r13);
            if (r10 == 0) goto L61;
            if (r14 < r15) goto L9;
            return r10;
        L9:
            byte r16 = (byte) r10;
            if (r16 >= (-32)) goto L19;
            if (r16 < (-62)) goto L17;
            long r17 = 1 + r14;
            if (UnsafeUtil.getByte(r11, r14) > (-65)) goto L17;
            r14 = r17;
        L17:
            return -1;
        L19:
            if (r16 >= (-16)) goto L39;
            byte r18 = (byte) (~(r10 >> 8));
            if (r18 != 0) goto L27;
            long r19 = r14 + 1;
            r18 = UnsafeUtil.getByte(r11, r14);
            if (r19 >= r15) goto L25;
            r14 = r19;
            goto L27
        L25:
            return Utf8.access$000(r16, r18);
        L27:
            if (r18 <= (-65)) goto L29;
        L38:
            return -1;
        L29:
            if (r16 != (-32)) goto L32;
            if (r18 < (-96)) goto L38;
        L32:
            if (r16 != (-19)) goto L34;
            if (r18 >= (-96)) goto L38;
        L34:
            long r20 = r14 + 1;
            if (UnsafeUtil.getByte(r11, r14) > (-65)) goto L38;
        L37:
            r14 = r20;
            goto L61
        L39:
            byte r110 = (byte) (~(r10 >> 8));
            if (r110 != 0) goto L46;
            long r21 = r14 + 1;
            r110 = UnsafeUtil.getByte(r11, r14);
            if (r21 >= r15) goto L44;
            byte r111 = 0;
            r14 = r21;
        L47:
            if (r111 != 0) goto L53;
            long r22 = r14 + 1;
            r111 = UnsafeUtil.getByte(r11, r14);
            if (r22 >= r15) goto L51;
            r14 = r22;
            goto L53
        L51:
            return Utf8.access$100(r16, r110, r111);
        L53:
            if (r110 <= (-65)) goto L55;
        L59:
            return -1;
        L55:
            if ((((r16 << Ascii.FS) + (r110 + 112)) >> 30) != 0) goto L59;
            if (r111 > (-65)) goto L59;
            r20 = r14 + 1;
            if (UnsafeUtil.getByte(r11, r14) <= (-65)) goto L37;
        L44:
            return Utf8.access$000(r16, r110);
        L46:
            r111 = (byte) (r10 >> 16);
        L61:
            return partialIsValidUtf8(r11, r14, (int) (r15 - r14));
        L63:
            throw new ArrayIndexOutOfBoundsException(String.format("Array length=%d, index=%d, limit=%d", new Object[]{Integer.valueOf(r11.length), Integer.valueOf(r12), Integer.valueOf(r13)}));
        }

        @Override // com.google.protobuf.Utf8.Processor
        public int partialIsValidUtf8Direct(int r10, ByteBuffer r11, int r12, int r13) {
            if (((r12 | r13) | (r11.limit() - r13)) < 0) goto L63;
            long r14 = UnsafeUtil.addressOffset(r11) + ((long) r12);
            long r15 = ((long) (r13 - r12)) + r14;
            if (r10 == 0) goto L61;
            if (r14 < r15) goto L9;
            return r10;
        L9:
            byte r16 = (byte) r10;
            if (r16 >= (-32)) goto L19;
            if (r16 < (-62)) goto L17;
            long r17 = 1 + r14;
            if (UnsafeUtil.getByte(r14) > (-65)) goto L17;
            r14 = r17;
        L17:
            return -1;
        L19:
            if (r16 >= (-16)) goto L39;
            byte r18 = (byte) (~(r10 >> 8));
            if (r18 != 0) goto L27;
            long r19 = r14 + 1;
            r18 = UnsafeUtil.getByte(r14);
            if (r19 >= r15) goto L25;
            r14 = r19;
            goto L27
        L25:
            return Utf8.access$000(r16, r18);
        L27:
            if (r18 <= (-65)) goto L29;
        L38:
            return -1;
        L29:
            if (r16 != (-32)) goto L32;
            if (r18 < (-96)) goto L38;
        L32:
            if (r16 != (-19)) goto L34;
            if (r18 >= (-96)) goto L38;
        L34:
            long r20 = r14 + 1;
            if (UnsafeUtil.getByte(r14) > (-65)) goto L38;
        L37:
            r14 = r20;
            goto L61
        L39:
            byte r110 = (byte) (~(r10 >> 8));
            if (r110 != 0) goto L46;
            long r21 = r14 + 1;
            r110 = UnsafeUtil.getByte(r14);
            if (r21 >= r15) goto L44;
            byte r22 = 0;
            r14 = r21;
        L47:
            if (r22 != 0) goto L53;
            long r23 = r14 + 1;
            r22 = UnsafeUtil.getByte(r14);
            if (r23 >= r15) goto L51;
            r14 = r23;
            goto L53
        L51:
            return Utf8.access$100(r16, r110, r22);
        L53:
            if (r110 <= (-65)) goto L55;
        L59:
            return -1;
        L55:
            if ((((r16 << Ascii.FS) + (r110 + 112)) >> 30) != 0) goto L59;
            if (r22 > (-65)) goto L59;
            r20 = r14 + 1;
            if (UnsafeUtil.getByte(r14) <= (-65)) goto L37;
        L44:
            return Utf8.access$000(r16, r110);
        L46:
            r22 = (byte) (r10 >> 16);
        L61:
            return partialIsValidUtf8(r14, (int) (r15 - r14));
        L63:
            throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", new Object[]{Integer.valueOf(r11.limit()), Integer.valueOf(r12), Integer.valueOf(r13)}));
        }

        private static int unsafeEstimateConsecutiveAscii(long r10, int r11) {
            if (r11 >= 16) goto L6;
            return 0;
        L6:
            int r12 = ((int) r10) & 7;
            int r13 = r12;
        L7:
            if (r13 <= 0) goto L13;
            long r14 = 1 + r10;
            if (UnsafeUtil.getByte(r10) < 0) goto L11;
            r13 = r13 - 1;
            r10 = r14;
            goto L7
        L11:
            return r12 - r13;
        L13:
            int r15 = r11 - r12;
        L15:
            if (r15 < 8) goto L20;
            if ((UnsafeUtil.getLong(r10) & Utf8.ASCII_MASK_LONG) != 0) goto L20;
            r10 = r10 + 8;
            r15 = r15 - 8;
        L20:
            return r11 - r15;
        }

        private static int unsafeIncompleteStateFor(long r10, int r11, int r12) {
            if (r12 == 0) goto L14;
            if (r12 == 1) goto L12;
            if (r12 != 2) goto L10;
            return Utf8.access$100(r11, UnsafeUtil.getByte(r10), UnsafeUtil.getByte(r10 + 1));
        L10:
            throw new AssertionError();
        L12:
            return Utf8.access$000(r11, UnsafeUtil.getByte(r10));
        L14:
            return Utf8.access$500(r11);
        }

        private static int partialIsValidUtf8(byte[] r10, long r11, int r13) {
            int r12 = unsafeEstimateConsecutiveAscii(r10, r11, r13);
            int r14 = r13 - r12;
            long r15 = r11 + ((long) r12);
        L3:
            byte r16 = 0;
        L5:
            if (r14 <= 0) goto L10;
            long r17 = r15 + 1;
            r16 = UnsafeUtil.getByte(r10, r15);
            if (r16 < 0) goto L9;
            r14 = r14 - 1;
            r15 = r17;
            goto L5
        L9:
            r15 = r17;
        L10:
            if (r14 == 0) goto L11;
            int r18 = r14 - 1;
            if (r16 < (-32)) goto L14;
            if (r16 < (-16)) goto L26;
            if (r18 < 3) goto L43;
            r14 = r14 - 4;
            long r19 = 1 + r15;
            byte r20 = UnsafeUtil.getByte(r10, r15);
            if (r20 > (-65)) goto L52;
            if ((((r16 << Ascii.FS) + (r20 + 112)) >> 30) != 0) goto L52;
            long r21 = 2 + r15;
            if (UnsafeUtil.getByte(r10, r19) > (-65)) goto L52;
            r15 = r15 + 3;
            if (UnsafeUtil.getByte(r10, r21) <= (-65)) goto L3;
        L52:
            return -1;
        L43:
            return unsafeIncompleteStateFor(r10, r16, r15, r18);
        L26:
            if (r18 < 2) goto L28;
            r14 = r14 - 3;
            long r22 = 1 + r15;
            byte r23 = UnsafeUtil.getByte(r10, r15);
            if (r23 > (-65)) goto L39;
            if (r16 != (-32)) goto L35;
            if (r23 < (-96)) goto L39;
        L35:
            if (r16 != (-19)) goto L37;
            if (r23 >= (-96)) goto L39;
        L37:
            r15 = r15 + 2;
            if (UnsafeUtil.getByte(r10, r22) <= (-65)) goto L3;
        L39:
            return -1;
        L28:
            return unsafeIncompleteStateFor(r10, r16, r15, r18);
        L14:
            if (r18 == 0) goto L15;
            r14 = r14 - 2;
            if (r16 < (-62)) goto L22;
            long r24 = 1 + r15;
            if (UnsafeUtil.getByte(r10, r15) > (-65)) goto L22;
            r15 = r24;
        L22:
            return -1;
        L15:
            return r16;
        L11:
            return 0;
        }

        private static int partialIsValidUtf8(long r10, int r12) {
            int r11 = unsafeEstimateConsecutiveAscii(r10, r12);
            long r13 = r10 + ((long) r11);
            int r14 = r12 - r11;
        L3:
            byte r15 = 0;
        L5:
            if (r14 <= 0) goto L10;
            long r16 = r13 + 1;
            r15 = UnsafeUtil.getByte(r13);
            if (r15 < 0) goto L9;
            r14 = r14 - 1;
            r13 = r16;
            goto L5
        L9:
            r13 = r16;
        L10:
            if (r14 == 0) goto L11;
            int r17 = r14 - 1;
            if (r15 < (-32)) goto L14;
            if (r15 < (-16)) goto L26;
            if (r17 < 3) goto L43;
            r14 = r14 - 4;
            long r18 = 1 + r13;
            byte r19 = UnsafeUtil.getByte(r13);
            if (r19 > (-65)) goto L52;
            if ((((r15 << Ascii.FS) + (r19 + 112)) >> 30) != 0) goto L52;
            long r20 = 2 + r13;
            if (UnsafeUtil.getByte(r18) > (-65)) goto L52;
            r13 = r13 + 3;
            if (UnsafeUtil.getByte(r20) <= (-65)) goto L3;
        L52:
            return -1;
        L43:
            return unsafeIncompleteStateFor(r13, r15, r17);
        L26:
            if (r17 < 2) goto L28;
            r14 = r14 - 3;
            long r21 = 1 + r13;
            byte r22 = UnsafeUtil.getByte(r13);
            if (r22 > (-65)) goto L39;
            if (r15 != (-32)) goto L35;
            if (r22 < (-96)) goto L39;
        L35:
            if (r15 != (-19)) goto L37;
            if (r22 >= (-96)) goto L39;
        L37:
            r13 = r13 + 2;
            if (UnsafeUtil.getByte(r21) <= (-65)) goto L3;
        L39:
            return -1;
        L28:
            return unsafeIncompleteStateFor(r13, r15, r17);
        L14:
            if (r17 == 0) goto L15;
            r14 = r14 - 2;
            if (r15 < (-62)) goto L22;
            long r23 = 1 + r13;
            if (UnsafeUtil.getByte(r13) > (-65)) goto L22;
            r13 = r23;
        L22:
            return -1;
        L15:
            return r15;
        L11:
            return 0;
        }
    }

    static {
        if (UnsafeProcessor.isAvailable() == false) goto L5;
        Processor r10 = new UnsafeProcessor();
    L6:
        processor = r10;
        return;
    L5:
        r10 = new SafeProcessor();
        goto L6
    }

    private Utf8() {
    }

    public static /* synthetic */ int access$000(int r10, int r11) {
        return incompleteStateFor(r10, r11);
    }

    public static /* synthetic */ int access$100(int r10, int r11, int r12) {
        return incompleteStateFor(r10, r11, r12);
    }

    public static /* synthetic */ int access$200(ByteBuffer r10, int r11, int r12) {
        return estimateConsecutiveAscii(r10, r11, r12);
    }

    public static /* synthetic */ int access$300(ByteBuffer r10, int r11, int r12, int r13) {
        return incompleteStateFor(r10, r11, r12, r13);
    }

    public static /* synthetic */ int access$400(byte[] r10, int r11, int r12) {
        return incompleteStateFor(r10, r11, r12);
    }

    public static /* synthetic */ int access$500(int r10) {
        return incompleteStateFor(r10);
    }

    public static int encode(CharSequence r10, byte[] r11, int r12, int r13) {
        return processor.encodeUtf8(r10, r11, r12, r13);
    }

    public static void encodeUtf8(CharSequence r10, ByteBuffer r11) {
        processor.encodeUtf8(r10, r11);
    }

    public static int encodedLength(CharSequence r10) {
        int r11 = r10.length();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L7;
        if (r10.charAt(r12) >= 128) goto L7;
        r12 = r12 + 1;
    L7:
        int r13 = r11;
    L8:
        if (r12 >= r11) goto L13;
        char r14 = r10.charAt(r12);
        if (r14 >= 2048) goto L12;
        r13 = r13 + ((127 - r14) >>> 31);
        r12 = r12 + 1;
        goto L8
    L12:
        r13 = r13 + encodedLengthGeneral(r10, r12);
    L13:
        if (r13 < r11) goto L16;
        return r13;
    L16:
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) r13) + 4294967296L));
    }

    private static int encodedLengthGeneral(CharSequence r10, int r11) {
        int r12 = r10.length();
        int r13 = 0;
    L3:
        if (r11 >= r12) goto L17;
        char r14 = r10.charAt(r11);
        if (r14 >= 2048) goto L7;
        r13 = r13 + ((127 - r14) >>> 31);
    L16:
        r11 = r11 + 1;
        goto L3
    L7:
        r13 = r13 + 2;
        if (55296 > r14) goto L16;
        if (r14 > 57343) goto L16;
        if (Character.codePointAt(r10, r11) < 65536) goto L15;
        r11 = r11 + 1;
        goto L16
    L15:
        throw new UnpairedSurrogateException(r11, r12);
    L17:
        return r13;
    }

    private static int estimateConsecutiveAscii(ByteBuffer r10, int r11, int r12) {
        int r13 = r12 - 7;
        int r14 = r11;
    L3:
        if (r14 >= r13) goto L8;
        if ((r10.getLong(r14) & ASCII_MASK_LONG) != 0) goto L8;
        r14 = r14 + 8;
    L8:
        return r14 - r11;
    }

    private static int incompleteStateFor(int r10) {
        if (r10 <= (-12)) goto L6;
        return -1;
    L6:
        return r10;
    }

    public static boolean isValidUtf8(byte[] r10) {
        return processor.isValidUtf8(r10, 0, r10.length);
    }

    public static int partialIsValidUtf8(int r10, byte[] r11, int r12, int r13) {
        return processor.partialIsValidUtf8(r10, r11, r12, r13);
    }

    private static int incompleteStateFor(int r10, int r11) {
        if (r10 <= (-12)) goto L5;
    L8:
        return -1;
    L5:
        if (r11 > (-65)) goto L8;
        return r10 ^ (r11 << 8);
    }

    public static boolean isValidUtf8(byte[] r10, int r11, int r12) {
        return processor.isValidUtf8(r10, r11, r12);
    }

    public static int partialIsValidUtf8(int r10, ByteBuffer r11, int r12, int r13) {
        return processor.partialIsValidUtf8(r10, r11, r12, r13);
    }

    private static int incompleteStateFor(int r10, int r11, int r12) {
        if (r10 <= (-12)) goto L5;
    L9:
        return -1;
    L5:
        if (r11 > (-65)) goto L9;
        if (r12 > (-65)) goto L9;
        return (r10 ^ (r11 << 8)) ^ (r12 << 16);
    }

    public static boolean isValidUtf8(ByteBuffer r10) {
        return processor.isValidUtf8(r10, r10.position(), r10.remaining());
    }

    private static int incompleteStateFor(byte[] r10, int r11, int r12) {
        byte r13 = r10[r11 - 1];
        int r14 = r12 - r11;
        if (r14 == 0) goto L15;
        if (r14 == 1) goto L13;
        if (r14 != 2) goto L11;
        return incompleteStateFor(r13, r10[r11], r10[r11 + 1]);
    L11:
        throw new AssertionError();
    L13:
        return incompleteStateFor(r13, r10[r11]);
    L15:
        return incompleteStateFor(r13);
    }

    private static int incompleteStateFor(ByteBuffer r10, int r11, int r12, int r13) {
        if (r13 == 0) goto L14;
        if (r13 == 1) goto L12;
        if (r13 != 2) goto L10;
        return incompleteStateFor(r11, r10.get(r12), r10.get(r12 + 1));
    L10:
        throw new AssertionError();
    L12:
        return incompleteStateFor(r11, r10.get(r12));
    L14:
        return incompleteStateFor(r11);
    }
}
