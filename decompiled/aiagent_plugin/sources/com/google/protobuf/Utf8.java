package com.google.protobuf;

import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
final class Utf8 {
    private static final long ASCII_MASK_LONG = -9187201950435737472L;
    static final int COMPLETE = 0;
    static final int MALFORMED = -1;
    static final int MAX_BYTES_PER_CHAR = 3;
    private static final int UNSAFE_COUNT_ASCII_THRESHOLD = 16;
    private static final Processor processor = null;

    private static class DecodeUtil {
        private static char highSurrogate(int r1) {
            return (char) ((r1 >>> 10) + 55232);
        }

        private static boolean isNotTrailingByte(byte r1) {
            if (r1 <= (-65)) goto L5;
            return true;
        L5:
            return false;
        }

        private static boolean isOneByte(byte r0) {
            if (r0 < 0) goto L4;
            return true;
        L4:
            return false;
        }

        private static boolean isThreeBytes(byte r1) {
            if (r1 >= (-16)) goto L5;
            return true;
        L5:
            return false;
        }

        private static boolean isTwoBytes(byte r1) {
            if (r1 >= (-32)) goto L5;
            return true;
        L5:
            return false;
        }

        private static char lowSurrogate(int r1) {
            return (char) ((r1 & DownloadErrorCode.ERROR_IO) + 56320);
        }

        private static int trailingByteValue(byte r0) {
            return r0 & 63;
        }

        private DecodeUtil() {
        }

        static /* synthetic */ void access$1000(byte r0, byte r1, byte r2, byte r3, char[] r4, int r5) {
            handleFourBytes(r0, r1, r2, r3, r4, r5);
        }

        static /* synthetic */ boolean access$400(byte r0) {
            return isOneByte(r0);
        }

        static /* synthetic */ void access$500(byte r0, char[] r1, int r2) {
            handleOneByte(r0, r1, r2);
        }

        static /* synthetic */ boolean access$600(byte r0) {
            return isTwoBytes(r0);
        }

        static /* synthetic */ void access$700(byte r0, byte r1, char[] r2, int r3) {
            handleTwoBytes(r0, r1, r2, r3);
        }

        static /* synthetic */ boolean access$800(byte r0) {
            return isThreeBytes(r0);
        }

        static /* synthetic */ void access$900(byte r0, byte r1, byte r2, char[] r3, int r4) {
            handleThreeBytes(r0, r1, r2, r3, r4);
        }

        private static void handleOneByte(byte r0, char[] r1, int r2) {
            r1[r2] = (char) r0;
        }

        private static void handleTwoBytes(byte r1, byte r2, char[] r3, int r4) {
            if (r1 < (-62)) goto L9;
            if (isNotTrailingByte(r2) == true) goto L9;
            r3[r4] = (char) (((r1 & 31) << 6) | trailingByteValue(r2));
            return;
        L9:
            throw InvalidProtocolBufferException.invalidUtf8();
        }

        private static void handleThreeBytes(byte r2, byte r3, byte r4, char[] r5, int r6) {
            if (isNotTrailingByte(r3) == true) goto L15;
            if (r2 != (-32)) goto L8;
            if (r3 < (-96)) goto L15;
        L8:
            if (r2 != (-19)) goto L11;
            if (r3 >= (-96)) goto L15;
        L11:
            if (isNotTrailingByte(r4) == true) goto L15;
            r5[r6] = (char) ((((r2 & 15) << 12) | (trailingByteValue(r3) << 6)) | trailingByteValue(r4));
            return;
        L15:
            throw InvalidProtocolBufferException.invalidUtf8();
        }

        private static void handleFourBytes(byte r2, byte r3, byte r4, byte r5, char[] r6, int r7) {
            if (isNotTrailingByte(r3) == true) goto L13;
            if ((((r2 << 28) + (r3 + 112)) >> 30) != 0) goto L13;
            if (isNotTrailingByte(r4) == true) goto L13;
            if (isNotTrailingByte(r5) == true) goto L13;
            int r8 = ((((r2 & 7) << 18) | (trailingByteValue(r3) << 12)) | (trailingByteValue(r4) << 6)) | trailingByteValue(r5);
            r6[r7] = highSurrogate(r8);
            r6[r7 + 1] = lowSurrogate(r8);
            return;
        L13:
            throw InvalidProtocolBufferException.invalidUtf8();
        }
    }

    static abstract class Processor {
        abstract String decodeUtf8(byte[] r1, int r2, int r3);

        abstract String decodeUtf8Direct(ByteBuffer r1, int r2, int r3);

        abstract int encodeUtf8(String r1, byte[] r2, int r3, int r4);

        abstract void encodeUtf8Direct(String r1, ByteBuffer r2);

        abstract int partialIsValidUtf8(int r1, byte[] r2, int r3, int r4);

        abstract int partialIsValidUtf8Direct(int r1, ByteBuffer r2, int r3, int r4);

        Processor() {
        }

        final boolean isValidUtf8(byte[] r2, int r3, int r4) {
            if (partialIsValidUtf8(0, r2, r3, r4) != 0) goto L6;
            return true;
        L6:
            return false;
        }

        final boolean isValidUtf8(ByteBuffer r2, int r3, int r4) {
            if (partialIsValidUtf8(0, r2, r3, r4) != 0) goto L6;
            return true;
        L6:
            return false;
        }

        final int partialIsValidUtf8(int r2, ByteBuffer r3, int r4, int r5) {
            if (r3.hasArray() == false) goto L7;
            int r0 = r3.arrayOffset();
            return partialIsValidUtf8(r2, r3.array(), r4 + r0, r0 + r5);
        L7:
            if (r3.isDirect() == false) goto L11;
            return partialIsValidUtf8Direct(r2, r3, r4, r5);
        L11:
            return partialIsValidUtf8Default(r2, r3, r4, r5);
        }

        final int partialIsValidUtf8Default(int r6, ByteBuffer r7, int r8, int r9) {
            if (r6 == 0) goto L55;
            if (r8 < r9) goto L5;
            return r6;
        L5:
            byte r5 = (byte) r6;
            if (r5 >= (-32)) goto L15;
            if (r5 < (-62)) goto L13;
            int r10 = r8 + 1;
            if (r7.get(r8) > (-65)) goto L13;
        L12:
            r8 = r10;
        L13:
            return -1;
        L15:
            if (r5 >= (-16)) goto L33;
            byte r11 = (byte) (~(r6 >> 8));
            if (r11 != 0) goto L23;
            int r12 = r8 + 1;
            byte r13 = r7.get(r8);
            if (r12 >= r9) goto L21;
            r8 = r12;
            r11 = r13;
            goto L23
        L21:
            return Utf8.access$000(r5, r13);
        L23:
            if (r11 <= (-65)) goto L25;
        L32:
            return -1;
        L25:
            if (r5 != (-32)) goto L28;
            if (r11 < (-96)) goto L32;
        L28:
            if (r5 != (-19)) goto L30;
            if (r11 >= (-96)) goto L32;
        L30:
            r10 = r8 + 1;
            if (r7.get(r8) <= (-65)) goto L12;
        L33:
            byte r0 = (byte) (~(r6 >> 8));
            byte r3 = 0;
            if (r0 != 0) goto L40;
            int r14 = r8 + 1;
            r0 = r7.get(r8);
            if (r14 >= r9) goto L38;
            r8 = r14;
        L41:
            if (r3 != 0) goto L47;
            int r15 = r8 + 1;
            r3 = r7.get(r8);
            if (r15 >= r9) goto L45;
            r8 = r15;
            goto L47
        L45:
            return Utf8.access$100(r5, r0, r3);
        L47:
            if (r0 <= (-65)) goto L49;
        L53:
            return -1;
        L49:
            if ((((r5 << 28) + (r0 + 112)) >> 30) != 0) goto L53;
            if (r3 > (-65)) goto L53;
            r10 = r8 + 1;
            if (r7.get(r8) <= (-65)) goto L12;
        L38:
            return Utf8.access$000(r5, r0);
        L40:
            r3 = (byte) (r6 >> 16);
        L55:
            return partialIsValidUtf8(r7, r8, r9);
        }

        private static int partialIsValidUtf8(ByteBuffer r6, int r7, int r8) {
            int r9 = r7 + Utf8.access$200(r6, r7, r8);
        L3:
            if (r9 >= r8) goto L4;
            int r0 = r9 + 1;
            byte r10 = r6.get(r9);
            if (r10 >= 0) goto L51;
            if (r10 < (-32)) goto L10;
            if (r10 < (-16)) goto L22;
            if (r0 >= (r8 - 2)) goto L41;
            int r1 = r0 + 1;
            byte r2 = r6.get(r0);
            if (r2 > (-65)) goto L50;
            if ((((r10 << 28) + (r2 + 112)) >> 30) != 0) goto L50;
            int r11 = r1 + 1;
            if (r6.get(r1) > (-65)) goto L50;
            r0 = r11 + 1;
            if (r6.get(r11) <= (-65)) goto L51;
        L50:
            return -1;
        L41:
            return Utf8.access$300(r6, r10, r0, r8 - r0);
        L22:
            if (r0 >= (r8 - 1)) goto L24;
            int r4 = r0 + 1;
            byte r3 = r6.get(r0);
            if (r3 > (-65)) goto L37;
            if (r10 != (-32)) goto L31;
            if (r3 < (-96)) goto L37;
        L31:
            if (r10 != (-19)) goto L34;
            if (r3 >= (-96)) goto L37;
        L34:
            if (r6.get(r4) > (-65)) goto L37;
            r9 = r4 + 1;
        L37:
            return -1;
        L24:
            return Utf8.access$300(r6, r10, r0, r8 - r0);
        L10:
            if (r0 >= r8) goto L11;
            if (r10 < (-62)) goto L18;
            if (r6.get(r0) > (-65)) goto L18;
            r0 = r0 + 1;
        L18:
            return -1;
        L11:
            return r10;
        L51:
            r9 = r0;
            goto L3
        L4:
            return 0;
        }

        final String decodeUtf8(ByteBuffer r2, int r3, int r4) {
            if (r2.hasArray() == false) goto L7;
            int r0 = r2.arrayOffset();
            return decodeUtf8(r2.array(), r0 + r3, r4);
        L7:
            if (r2.isDirect() == false) goto L11;
            return decodeUtf8Direct(r2, r3, r4);
        L11:
            return decodeUtf8Default(r2, r3, r4);
        }

        final String decodeUtf8Default(ByteBuffer r11, int r12, int r13) {
            if (((r12 | r13) | ((r11.limit() - r12) - r13)) < 0) goto L42;
            int r10 = r12 + r13;
            char[] r14 = new char[r13];
            int r2 = 0;
        L5:
            if (r12 >= r10) goto L10;
            byte r3 = r11.get(r12);
            if (DecodeUtil.access$400(r3) == false) goto L10;
            r12 = r12 + 1;
            DecodeUtil.access$500(r3, r14, r2);
            r2 = r2 + 1;
        L10:
            int r7 = r2;
        L11:
            if (r12 >= r10) goto L40;
            int r4 = r12 + 1;
            byte r15 = r11.get(r12);
            if (DecodeUtil.access$400(r15) == true) goto L14;
            if (DecodeUtil.access$600(r15) == true) goto L23;
            if (DecodeUtil.access$800(r15) == true) goto L30;
            if (r4 >= (r10 - 2)) goto L38;
            int r5 = r4 + 1;
            byte r6 = r11.get(r4);
            int r8 = r5 + 1;
            DecodeUtil.access$1000(r15, r6, r11.get(r5), r11.get(r8), r14, r7);
            r12 = r8 + 1;
            r7 = (r7 + 1) + 1;
            goto L11
        L38:
            throw InvalidProtocolBufferException.invalidUtf8();
        L30:
            if (r4 >= (r10 - 1)) goto L33;
            int r9 = r4 + 1;
            DecodeUtil.access$900(r15, r11.get(r4), r11.get(r9), r14, r7);
            r12 = r9 + 1;
            r7 = r7 + 1;
            goto L11
        L33:
            throw InvalidProtocolBufferException.invalidUtf8();
        L23:
            if (r4 >= r10) goto L26;
            DecodeUtil.access$700(r15, r11.get(r4), r14, r7);
            r12 = r4 + 1;
            r7 = r7 + 1;
            goto L11
        L26:
            throw InvalidProtocolBufferException.invalidUtf8();
        L14:
            int r16 = r7 + 1;
            DecodeUtil.access$500(r15, r14, r7);
        L15:
            if (r4 >= r10) goto L20;
            byte r17 = r11.get(r4);
            if (DecodeUtil.access$400(r17) == false) goto L20;
            r4 = r4 + 1;
            DecodeUtil.access$500(r17, r14, r16);
            r16 = r16 + 1;
        L20:
            r12 = r4;
            r7 = r16;
            goto L11
        L40:
            return new String(r14, 0, r7);
        L42:
            throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", new Object[]{Integer.valueOf(r11.limit()), Integer.valueOf(r12), Integer.valueOf(r13)}));
        }

        final void encodeUtf8(String r4, ByteBuffer r5) {
            if (r5.hasArray() == false) goto L6;
            int r3 = r5.arrayOffset();
            Java8Compatibility.position(r5, Utf8.encode(r4, r5.array(), r5.position() + r3, r5.remaining()) - r3);
            return;
        L6:
            if (r5.isDirect() == false) goto L8;
            encodeUtf8Direct(r4, r5);
            return;
        L8:
            encodeUtf8Default(r4, r5);
        }

        final void encodeUtf8Default(String r7, ByteBuffer r8) {
            int r6 = r7.length();
            int r0 = r8.position();
            int r1 = 0;
        L4:
            if (r1 >= r6) goto L8;
            char r3 = r7.charAt(r1);     // Catch: IndexOutOfBoundsException -> L55
            if (r3 >= 128) goto L8;
            r8.put(r0 + r1, (byte) r3);     // Catch: IndexOutOfBoundsException -> L55
            r1 = r1 + 1;     // Catch: IndexOutOfBoundsException -> L55
        L53:
            throw new ArrayIndexOutOfBoundsException("Failed writing " + r7.charAt(r1) + " at index " + (r8.position() + Math.max(r1, (r0 - r8.position()) + 1)));
        L8:
            if (r1 != r6) goto L11;
            Java8Compatibility.position(r8, r0 + r1);     // Catch: IndexOutOfBoundsException -> L55
            return;
        L11:
            r0 = r0 + r1;     // Catch: IndexOutOfBoundsException -> L55
        L12:
            if (r1 >= r6) goto L50;
            char r4 = r7.charAt(r1);     // Catch: IndexOutOfBoundsException -> L55
            if (r4 >= 128) goto L18;
            r8.put(r0, (byte) r4);     // Catch: IndexOutOfBoundsException -> L55
        L49:
            r1 = r1 + 1;     // Catch: IndexOutOfBoundsException -> L55
            r0 = r0 + 1;     // Catch: IndexOutOfBoundsException -> L55
            goto L12
        L18:
            if (r4 >= 2048) goto L24;
            int r5 = r0 + 1;
            r8.put(r0, (byte) ((r4 >>> 6) | 192));     // Catch: IndexOutOfBoundsException -> L22
            r8.put(r5, (byte) ((r4 & '?') | 128));     // Catch: IndexOutOfBoundsException -> L22
            r0 = r5;
        L22:
            r0 = r5;
            goto L53
        L24:
            if (r4 >= 55296) goto L26;
        L45:
            int r9 = r0 + 1;
            r8.put(r0, (byte) ((r4 >>> '\f') | 224));     // Catch: IndexOutOfBoundsException -> L22
            r0 = r9 + 1;
            r8.put(r9, (byte) (((r4 >>> 6) & 63) | 128));     // Catch: IndexOutOfBoundsException -> L55
            r8.put(r0, (byte) ((r4 & '?') | 128));     // Catch: IndexOutOfBoundsException -> L55
            goto L49
        L26:
            if (57343 < r4) goto L45;
            int r10 = r1 + 1;
            if (r10 == r6) goto L44;
            char r2 = r7.charAt(r10);     // Catch: IndexOutOfBoundsException -> L54
            if (Character.isSurrogatePair(r4, r2) == false) goto L41;
            int r11 = Character.toCodePoint(r4, r2);     // Catch: IndexOutOfBoundsException -> L54
            int r12 = r0 + 1;
            r8.put(r0, (byte) ((r11 >>> 18) | 240));     // Catch: IndexOutOfBoundsException -> L40
            r0 = r12 + 1;
            r8.put(r12, (byte) (((r11 >>> 12) & 63) | 128));     // Catch: IndexOutOfBoundsException -> L54
            r12 = r0 + 1;
            r8.put(r0, (byte) (((r11 >>> 6) & 63) | 128));     // Catch: IndexOutOfBoundsException -> L40
            r8.put(r12, (byte) ((r11 & 63) | 128));     // Catch: IndexOutOfBoundsException -> L40
            r0 = r12;
            r1 = r10;
        L40:
            r0 = r12;
            goto L42
        L41:
            r1 = r10;
        L42:
            r1 = r10;
        L44:
            throw new UnpairedSurrogateException(r1, r6);     // Catch: IndexOutOfBoundsException -> L55
        L50:
            Java8Compatibility.position(r8, r0);     // Catch: IndexOutOfBoundsException -> L55
        }
    }

    static final class SafeProcessor extends Processor {
        SafeProcessor() {
        }

        @Override // com.google.protobuf.Utf8.Processor
        int partialIsValidUtf8(int r6, byte[] r7, int r8, int r9) {
            if (r6 == 0) goto L55;
            if (r8 < r9) goto L5;
            return r6;
        L5:
            byte r5 = (byte) r6;
            if (r5 >= (-32)) goto L15;
            if (r5 < (-62)) goto L13;
            int r10 = r8 + 1;
            if (r7[r8] > (-65)) goto L13;
        L12:
            r8 = r10;
        L13:
            return -1;
        L15:
            if (r5 >= (-16)) goto L33;
            byte r11 = (byte) (~(r6 >> 8));
            if (r11 != 0) goto L23;
            int r12 = r8 + 1;
            byte r13 = r7[r8];
            if (r12 >= r9) goto L21;
            r8 = r12;
            r11 = r13;
            goto L23
        L21:
            return Utf8.access$000(r5, r13);
        L23:
            if (r11 <= (-65)) goto L25;
        L32:
            return -1;
        L25:
            if (r5 != (-32)) goto L28;
            if (r11 < (-96)) goto L32;
        L28:
            if (r5 != (-19)) goto L30;
            if (r11 >= (-96)) goto L32;
        L30:
            r10 = r8 + 1;
            if (r7[r8] <= (-65)) goto L12;
        L33:
            byte r0 = (byte) (~(r6 >> 8));
            byte r3 = 0;
            if (r0 != 0) goto L40;
            int r14 = r8 + 1;
            r0 = r7[r8];
            if (r14 >= r9) goto L38;
            r8 = r14;
        L41:
            if (r3 != 0) goto L47;
            int r15 = r8 + 1;
            r3 = r7[r8];
            if (r15 >= r9) goto L45;
            r8 = r15;
            goto L47
        L45:
            return Utf8.access$100(r5, r0, r3);
        L47:
            if (r0 <= (-65)) goto L49;
        L53:
            return -1;
        L49:
            if ((((r5 << 28) + (r0 + 112)) >> 30) != 0) goto L53;
            if (r3 > (-65)) goto L53;
            r10 = r8 + 1;
            if (r7[r8] <= (-65)) goto L12;
        L38:
            return Utf8.access$000(r5, r0);
        L40:
            r3 = (byte) (r6 >> 16);
        L55:
            return partialIsValidUtf8(r7, r8, r9);
        }

        @Override // com.google.protobuf.Utf8.Processor
        int partialIsValidUtf8Direct(int r1, ByteBuffer r2, int r3, int r4) {
            return partialIsValidUtf8Default(r1, r2, r3, r4);
        }

        @Override // com.google.protobuf.Utf8.Processor
        String decodeUtf8(byte[] r11, int r12, int r13) {
            if (((r12 | r13) | ((r11.length - r12) - r13)) < 0) goto L42;
            int r10 = r12 + r13;
            char[] r14 = new char[r13];
            int r2 = 0;
        L5:
            if (r12 >= r10) goto L10;
            byte r3 = r11[r12];
            if (DecodeUtil.access$400(r3) == false) goto L10;
            r12 = r12 + 1;
            DecodeUtil.access$500(r3, r14, r2);
            r2 = r2 + 1;
        L10:
            int r7 = r2;
        L11:
            if (r12 >= r10) goto L40;
            int r4 = r12 + 1;
            byte r15 = r11[r12];
            if (DecodeUtil.access$400(r15) == true) goto L14;
            if (DecodeUtil.access$600(r15) == true) goto L23;
            if (DecodeUtil.access$800(r15) == true) goto L30;
            if (r4 >= (r10 - 2)) goto L38;
            int r5 = r4 + 1;
            byte r6 = r11[r4];
            int r8 = r5 + 1;
            DecodeUtil.access$1000(r15, r6, r11[r5], r11[r8], r14, r7);
            r12 = r8 + 1;
            r7 = (r7 + 1) + 1;
            goto L11
        L38:
            throw InvalidProtocolBufferException.invalidUtf8();
        L30:
            if (r4 >= (r10 - 1)) goto L33;
            int r9 = r4 + 1;
            DecodeUtil.access$900(r15, r11[r4], r11[r9], r14, r7);
            r12 = r9 + 1;
            r7 = r7 + 1;
            goto L11
        L33:
            throw InvalidProtocolBufferException.invalidUtf8();
        L23:
            if (r4 >= r10) goto L26;
            DecodeUtil.access$700(r15, r11[r4], r14, r7);
            r12 = r4 + 1;
            r7 = r7 + 1;
            goto L11
        L26:
            throw InvalidProtocolBufferException.invalidUtf8();
        L14:
            int r16 = r7 + 1;
            DecodeUtil.access$500(r15, r14, r7);
        L15:
            if (r4 >= r10) goto L20;
            byte r17 = r11[r4];
            if (DecodeUtil.access$400(r17) == false) goto L20;
            r4 = r4 + 1;
            DecodeUtil.access$500(r17, r14, r16);
            r16 = r16 + 1;
        L20:
            r12 = r4;
            r7 = r16;
            goto L11
        L40:
            return new String(r14, 0, r7);
        L42:
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", new Object[]{Integer.valueOf(r11.length), Integer.valueOf(r12), Integer.valueOf(r13)}));
        }

        @Override // com.google.protobuf.Utf8.Processor
        String decodeUtf8Direct(ByteBuffer r1, int r2, int r3) {
            return decodeUtf8Default(r1, r2, r3);
        }

        @Override // com.google.protobuf.Utf8.Processor
        int encodeUtf8(String r7, byte[] r8, int r9, int r10) {
            int r6 = r7.length();
            int r11 = r10 + r9;
            int r0 = 0;
        L4:
            if (r0 >= r6) goto L10;
            int r2 = r0 + r9;
            if (r2 >= r11) goto L10;
            char r3 = r7.charAt(r0);
            if (r3 >= 128) goto L10;
            r8[r2] = (byte) r3;
            r0 = r0 + 1;
        L10:
            if (r0 == r6) goto L12;
            int r12 = r9 + r0;
        L14:
            if (r0 >= r6) goto L52;
            char r4 = r7.charAt(r0);
            if (r4 >= 128) goto L21;
            if (r12 >= r11) goto L21;
            int r5 = r12 + 1;
            r8[r12] = (byte) r4;
        L19:
            r12 = r5;
        L38:
            r0 = r0 + 1;
        L21:
            if (r4 >= 2048) goto L26;
            if (r12 > (r11 - 2)) goto L26;
            int r13 = r12 + 1;
            r8[r12] = (byte) ((r4 >>> 6) | 960);
            r12 = r13 + 1;
            r8[r13] = (byte) ((r4 & '?') | 128);
        L26:
            if (r4 < 55296) goto L29;
            if (57343 < r4) goto L29;
        L32:
            if (r12 > (r11 - 4)) goto L42;
            int r14 = r0 + 1;
            if (r14 == r7.length()) goto L41;
            char r1 = r7.charAt(r14);
            if (Character.isSurrogatePair(r4, r1) == false) goto L39;
            int r15 = Character.toCodePoint(r4, r1);
            int r16 = r12 + 1;
            r8[r12] = (byte) ((r15 >>> 18) | 240);
            int r17 = r16 + 1;
            r8[r16] = (byte) (((r15 >>> 12) & 63) | 128);
            int r18 = r17 + 1;
            r8[r17] = (byte) (((r15 >>> 6) & 63) | 128);
            r12 = r18 + 1;
            r8[r18] = (byte) ((r15 & 63) | 128);
            r0 = r14;
            goto L38
        L39:
            r0 = r14;
        L41:
            throw new UnpairedSurrogateException(r0 - 1, r6);
        L42:
            if (55296 > r4) goto L51;
            if (r4 > 57343) goto L51;
            int r19 = r0 + 1;
            if (r19 == r7.length()) goto L49;
            if (Character.isSurrogatePair(r4, r7.charAt(r19)) == true) goto L51;
        L49:
            throw new UnpairedSurrogateException(r0, r6);
        L51:
            throw new ArrayIndexOutOfBoundsException("Failed writing " + r4 + " at index " + r12);
        L29:
            if (r12 > (r11 - 3)) goto L32;
            int r20 = r12 + 1;
            r8[r12] = (byte) ((r4 >>> '\f') | 480);
            int r21 = r20 + 1;
            r8[r20] = (byte) (((r4 >>> 6) & 63) | 128);
            r5 = r21 + 1;
            r8[r21] = (byte) ((r4 & '?') | 128);
            goto L19
        L52:
            return r12;
        L12:
            return r9 + r6;
        }

        @Override // com.google.protobuf.Utf8.Processor
        void encodeUtf8Direct(String r1, ByteBuffer r2) {
            encodeUtf8Default(r1, r2);
        }

        private static int partialIsValidUtf8(byte[] r1, int r2, int r3) {
        L2:
            if (r2 >= r3) goto L6;
            if (r1[r2] < 0) goto L6;
            r2 = r2 + 1;
        L6:
            if (r2 < r3) goto L9;
            return 0;
        L9:
            return partialIsValidUtf8NonAscii(r1, r2, r3);
        }

        private static int partialIsValidUtf8NonAscii(byte[] r6, int r7, int r8) {
        L2:
            if (r7 >= r8) goto L3;
            int r0 = r7 + 1;
            byte r9 = r6[r7];
            if (r9 >= 0) goto L46;
            if (r9 < (-32)) goto L9;
            if (r9 < (-16)) goto L19;
            if (r0 >= (r8 - 2)) goto L36;
            int r1 = r0 + 1;
            byte r2 = r6[r0];
            if (r2 > (-65)) goto L45;
            if ((((r9 << 28) + (r2 + 112)) >> 30) != 0) goto L45;
            int r10 = r1 + 1;
            if (r6[r1] > (-65)) goto L45;
            r0 = r10 + 1;
            if (r6[r10] <= (-65)) goto L46;
        L45:
            return -1;
        L36:
            return Utf8.access$1100(r6, r0, r8);
        L19:
            if (r0 >= (r8 - 1)) goto L21;
            int r4 = r0 + 1;
            byte r3 = r6[r0];
            if (r3 > (-65)) goto L32;
            if (r9 != (-32)) goto L28;
            if (r3 < (-96)) goto L32;
        L28:
            if (r9 != (-19)) goto L30;
            if (r3 >= (-96)) goto L32;
        L30:
            r7 = r4 + 1;
            if (r6[r4] <= (-65)) goto L2;
        L32:
            return -1;
        L21:
            return Utf8.access$1100(r6, r0, r8);
        L9:
            if (r0 >= r8) goto L10;
            if (r9 < (-62)) goto L15;
            r7 = r0 + 1;
            if (r6[r0] <= (-65)) goto L2;
        L15:
            return -1;
        L10:
            return r9;
        L46:
            r7 = r0;
            goto L2
        L3:
            return 0;
        }
    }

    static class UnpairedSurrogateException extends IllegalArgumentException {
        UnpairedSurrogateException(int r3, int r4) {
            super("Unpaired surrogate at index " + r3 + " of " + r4);
        }
    }

    static final class UnsafeProcessor extends Processor {
        UnsafeProcessor() {
        }

        static boolean isAvailable() {
            if (UnsafeUtil.hasUnsafeArrayOperations() == true) goto L5;
        L7:
            return false;
        L5:
            if (UnsafeUtil.hasUnsafeByteBufferOperations() == false) goto L7;
            return true;
        }

        @Override // com.google.protobuf.Utf8.Processor
        int partialIsValidUtf8(int r11, byte[] r12, int r13, int r14) {
            byte r0 = 0;
            if (((r13 | r14) | (r12.length - r14)) < 0) goto L63;
            long r1 = r13;
            long r15 = r14;
            if (r11 == 0) goto L61;
            if (r1 < r15) goto L9;
            return r11;
        L9:
            byte r10 = (byte) r11;
            if (r10 >= (-32)) goto L19;
            if (r10 < (-62)) goto L17;
            long r6 = 1 + r1;
            if (UnsafeUtil.getByte(r12, r1) > (-65)) goto L17;
            r1 = r6;
        L17:
            return -1;
        L19:
            if (r10 >= (-16)) goto L39;
            byte r16 = (byte) (~(r11 >> 8));
            if (r16 != 0) goto L27;
            long r8 = r1 + 1;
            r16 = UnsafeUtil.getByte(r12, r1);
            if (r8 >= r15) goto L25;
            r1 = r8;
            goto L27
        L25:
            return Utf8.access$000(r10, r16);
        L27:
            if (r16 <= (-65)) goto L29;
        L38:
            return -1;
        L29:
            if (r10 != (-32)) goto L32;
            if (r16 < (-96)) goto L38;
        L32:
            if (r10 != (-19)) goto L34;
            if (r16 >= (-96)) goto L38;
        L34:
            long r17 = r1 + 1;
            if (UnsafeUtil.getByte(r12, r1) > (-65)) goto L38;
        L37:
            r1 = r17;
            goto L61
        L39:
            byte r3 = (byte) (~(r11 >> 8));
            if (r3 != 0) goto L46;
            long r9 = r1 + 1;
            r3 = UnsafeUtil.getByte(r12, r1);
            if (r9 >= r15) goto L44;
            r1 = r9;
        L47:
            if (r0 != 0) goto L53;
            long r18 = r1 + 1;
            r0 = UnsafeUtil.getByte(r12, r1);
            if (r18 >= r15) goto L51;
            r1 = r18;
            goto L53
        L51:
            return Utf8.access$100(r10, r3, r0);
        L53:
            if (r3 <= (-65)) goto L55;
        L59:
            return -1;
        L55:
            if ((((r10 << 28) + (r3 + 112)) >> 30) != 0) goto L59;
            if (r0 > (-65)) goto L59;
            r17 = r1 + 1;
            if (UnsafeUtil.getByte(r12, r1) <= (-65)) goto L37;
        L44:
            return Utf8.access$000(r10, r3);
        L46:
            r0 = (byte) (r11 >> 16);
        L61:
            return partialIsValidUtf8(r12, r1, (int) (r15 - r1));
        L63:
            throw new ArrayIndexOutOfBoundsException(String.format("Array length=%d, index=%d, limit=%d", new Object[]{Integer.valueOf(r12.length), Integer.valueOf(r13), Integer.valueOf(r14)}));
        }

        @Override // com.google.protobuf.Utf8.Processor
        int partialIsValidUtf8Direct(int r10, ByteBuffer r11, int r12, int r13) {
            byte r0 = 0;
            if (((r12 | r13) | (r11.limit() - r13)) < 0) goto L63;
            long r1 = UnsafeUtil.addressOffset(r11) + ((long) r12);
            long r14 = ((long) (r13 - r12)) + r1;
            if (r10 == 0) goto L61;
            if (r1 < r14) goto L9;
            return r10;
        L9:
            byte r9 = (byte) r10;
            if (r9 >= (-32)) goto L19;
            if (r9 < (-62)) goto L17;
            long r5 = 1 + r1;
            if (UnsafeUtil.getByte(r1) > (-65)) goto L17;
            r1 = r5;
        L17:
            return -1;
        L19:
            if (r9 >= (-16)) goto L39;
            byte r15 = (byte) (~(r10 >> 8));
            if (r15 != 0) goto L27;
            long r7 = r1 + 1;
            r15 = UnsafeUtil.getByte(r1);
            if (r7 >= r14) goto L25;
            r1 = r7;
            goto L27
        L25:
            return Utf8.access$000(r9, r15);
        L27:
            if (r15 <= (-65)) goto L29;
        L38:
            return -1;
        L29:
            if (r9 != (-32)) goto L32;
            if (r15 < (-96)) goto L38;
        L32:
            if (r9 != (-19)) goto L34;
            if (r15 >= (-96)) goto L38;
        L34:
            long r16 = r1 + 1;
            if (UnsafeUtil.getByte(r1) > (-65)) goto L38;
        L37:
            r1 = r16;
            goto L61
        L39:
            byte r17 = (byte) (~(r10 >> 8));
            if (r17 != 0) goto L46;
            long r8 = r1 + 1;
            r17 = UnsafeUtil.getByte(r1);
            if (r8 >= r14) goto L44;
            r1 = r8;
        L47:
            if (r0 != 0) goto L53;
            long r18 = r1 + 1;
            r0 = UnsafeUtil.getByte(r1);
            if (r18 >= r14) goto L51;
            r1 = r18;
            goto L53
        L51:
            return Utf8.access$100(r9, r17, r0);
        L53:
            if (r17 <= (-65)) goto L55;
        L59:
            return -1;
        L55:
            if ((((r9 << 28) + (r17 + 112)) >> 30) != 0) goto L59;
            if (r0 > (-65)) goto L59;
            r16 = r1 + 1;
            if (UnsafeUtil.getByte(r1) <= (-65)) goto L37;
        L44:
            return Utf8.access$000(r9, r17);
        L46:
            r0 = (byte) (r10 >> 16);
        L61:
            return partialIsValidUtf8(r1, (int) (r14 - r1));
        L63:
            throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", new Object[]{Integer.valueOf(r11.limit()), Integer.valueOf(r12), Integer.valueOf(r13)}));
        }

        @Override // com.google.protobuf.Utf8.Processor
        String decodeUtf8(byte[] r2, int r3, int r4) {
            String r1 = new String(r2, r3, r4, Internal.UTF_8);
            if (r1.indexOf(65533) >= 0) goto L6;
            return r1;
        L6:
            if (Arrays.equals(r1.getBytes(Internal.UTF_8), Arrays.copyOfRange(r2, r3, r4 + r3)) == false) goto L9;
            return r1;
        L9:
            throw InvalidProtocolBufferException.invalidUtf8();
        }

        @Override // com.google.protobuf.Utf8.Processor
        String decodeUtf8Direct(ByteBuffer r18, int r19, int r20) {
            if (((r19 | r20) | ((r18.limit() - r19) - r20)) < 0) goto L46;
            long r5 = UnsafeUtil.addressOffset(r18) + ((long) r19);
            long r7 = ((long) r20) + r5;
            char[] r0 = new char[r20];
            int r1 = 0;
        L6:
            if (r5 >= r7) goto L11;
            byte r2 = UnsafeUtil.getByte(r5);
            if (DecodeUtil.access$400(r2) == false) goto L11;
            r5 = r5 + 1;
            DecodeUtil.access$500(r2, r0, r1);
            r1 = r1 + 1;
        L11:
            int r14 = r1;
        L13:
            if (r5 >= r7) goto L44;
            long r3 = r5 + 1;
            byte r9 = UnsafeUtil.getByte(r5);
            if (DecodeUtil.access$400(r9) == true) goto L16;
            if (DecodeUtil.access$600(r9) == true) goto L27;
            if (DecodeUtil.access$800(r9) == false) goto L39;
            if (r3 >= (r7 - 1)) goto L37;
            long r6 = r3 + 1;
            DecodeUtil.access$900(r9, UnsafeUtil.getByte(r3), UnsafeUtil.getByte(r6), r0, r14);
            r14 = r14 + 1;
            r5 = r6 + 1;
            goto L13
        L37:
            throw InvalidProtocolBufferException.invalidUtf8();
        L39:
            if (r3 >= (r7 - 2)) goto L42;
            long r8 = r3 + 1;
            byte r10 = UnsafeUtil.getByte(r3);
            long r4 = r8 + 1;
            byte r11 = UnsafeUtil.getByte(r8);
            r5 = r4 + 1;
            DecodeUtil.access$1000(r9, r10, r11, UnsafeUtil.getByte(r4), r0, r14);
            r1 = (r14 + 1) + 1;
            goto L11
        L42:
            throw InvalidProtocolBufferException.invalidUtf8();
        L27:
            if (r3 >= r7) goto L30;
            r5 = r3 + 1;
            DecodeUtil.access$700(r9, UnsafeUtil.getByte(r3), r0, r14);
            r14 = r14 + 1;
            goto L13
        L30:
            throw InvalidProtocolBufferException.invalidUtf8();
        L16:
            int r12 = r14 + 1;
            DecodeUtil.access$500(r9, r0, r14);
        L18:
            if (r3 >= r7) goto L23;
            byte r13 = UnsafeUtil.getByte(r3);
            if (DecodeUtil.access$400(r13) == false) goto L23;
            r3 = r3 + 1;
            DecodeUtil.access$500(r13, r0, r12);
            r12 = r12 + 1;
        L23:
            r14 = r12;
            r5 = r3;
            goto L13
        L44:
            return new String(r0, 0, r14);
        L46:
            throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", new Object[]{Integer.valueOf(r18.limit()), Integer.valueOf(r19), Integer.valueOf(r20)}));
        }

        @Override // com.google.protobuf.Utf8.Processor
        int encodeUtf8(String r21, byte[] r22, int r23, int r24) {
            long r4 = r23;
            long r6 = ((long) r24) + r4;
            int r8 = r21.length();
            if (r8 > r24) goto L56;
            if ((r22.length - r24) < r23) goto L56;
            int r2 = 0;
        L7:
            char r3 = 128;
            long r11 = 1;
            if (r2 >= r8) goto L12;
            char r13 = r21.charAt(r2);
            if (r13 >= 128) goto L12;
            UnsafeUtil.putByte(r22, r4, (byte) r13);
            r2 = r2 + 1;
            r4 = 1 + r4;
        L12:
            if (r2 == r8) goto L14;
        L15:
            if (r2 >= r8) goto L54;
            char r14 = r21.charAt(r2);
            if (r14 >= r3) goto L22;
            if (r4 >= r6) goto L22;
            long r15 = r4 + r11;
            UnsafeUtil.putByte(r22, r4, (byte) r14);
            long r5 = r11;
            long r12 = r15;
            char r16 = r3;
        L39:
            r2 = r2 + 1;
            r3 = r16;
            long r18 = r5;
            r4 = r12;
            r11 = r18;
        L22:
            if (r14 >= 2048) goto L27;
            if (r4 > (r6 - 2)) goto L27;
            long r17 = r4 + r11;
            UnsafeUtil.putByte(r22, r4, (byte) ((r14 >>> 6) | 960));
            long r7 = r17 + r11;
            UnsafeUtil.putByte(r22, r17, (byte) ((r14 & '?') | 128));
            long r19 = r11;
            r16 = 128;
            r12 = r7;
            r5 = r19;
        L27:
            if (r14 < 55296) goto L30;
            if (57343 < r14) goto L30;
        L33:
            if (r4 > (r6 - 4)) goto L43;
            int r9 = r2 + 1;
            if (r9 == r8) goto L42;
            char r10 = r21.charAt(r9);
            if (Character.isSurrogatePair(r14, r10) == false) goto L40;
            int r20 = Character.toCodePoint(r14, r10);
            long r110 = r4 + 1;
            UnsafeUtil.putByte(r22, r4, (byte) ((r20 >>> 18) | 240));
            long r25 = r110 + 1;
            r16 = 128;
            UnsafeUtil.putByte(r22, r110, (byte) (((r20 >>> 12) & 63) | 128));
            long r111 = r25 + 1;
            UnsafeUtil.putByte(r22, r25, (byte) (((r20 >>> 6) & 63) | 128));
            r5 = 1;
            r12 = r111 + 1;
            UnsafeUtil.putByte(r22, r111, (byte) ((r20 & 63) | 128));
            r2 = r9;
            goto L39
        L40:
            r2 = r9;
        L42:
            throw new UnpairedSurrogateException(r2 - 1, r8);
        L43:
            if (55296 > r14) goto L52;
            if (r14 > 57343) goto L52;
            int r1 = r2 + 1;
            if (r1 == r8) goto L50;
            if (Character.isSurrogatePair(r14, r21.charAt(r1)) == true) goto L52;
        L50:
            throw new UnpairedSurrogateException(r2, r8);
        L52:
            throw new ArrayIndexOutOfBoundsException("Failed writing " + r14 + " at index " + r4);
        L30:
            if (r4 > (r6 - 3)) goto L33;
            long r112 = r4 + r11;
            UnsafeUtil.putByte(r22, r4, (byte) ((r14 >>> '\f') | 480));
            long r26 = r112 + r11;
            UnsafeUtil.putByte(r22, r112, (byte) (((r14 >>> 6) & 63) | 128));
            UnsafeUtil.putByte(r22, r26, (byte) ((r14 & '?') | 128));
            r12 = r26 + 1;
            r5 = 1;
            r16 = 128;
            goto L39
        L54:
            return (int) r4;
        L14:
            return (int) r4;
        L56:
            throw new ArrayIndexOutOfBoundsException("Failed writing " + r21.charAt(r8 - 1) + " at index " + (r23 + r24));
        }

        @Override // com.google.protobuf.Utf8.Processor
        void encodeUtf8Direct(String r21, ByteBuffer r22) {
            long r2 = UnsafeUtil.addressOffset(r22);
            long r4 = ((long) r22.position()) + r2;
            long r6 = ((long) r22.limit()) + r2;
            int r8 = r21.length();
            if (r8 > (r6 - r4)) goto L55;
            int r9 = 0;
        L5:
            char r12 = 128;
            if (r9 >= r8) goto L10;
            char r15 = r21.charAt(r9);
            if (r15 >= 128) goto L10;
            UnsafeUtil.putByte(r4, (byte) r15);
            r9 = r9 + 1;
            r4 = r4 + 1;
        L10:
            if (r9 != r8) goto L13;
            Java8Compatibility.position(r22, (int) (r4 - r2));
            return;
        L13:
            if (r9 >= r8) goto L52;
            char r16 = r21.charAt(r9);
            if (r16 >= r12) goto L20;
            if (r4 >= r6) goto L20;
            UnsafeUtil.putByte(r4, (byte) r16);
            int r1 = r9;
            char r10 = r12;
            r4 = r4 + 1;
            long r17 = r2;
        L38:
            r12 = r10;
            r2 = r17;
            r6 = r6;
            r9 = r1 + 1;
        L20:
            if (r16 < 2048) goto L22;
        L25:
            r17 = r2;
            if (r16 < 55296) goto L29;
            if (57343 < r16) goto L29;
        L32:
            if (r4 > (r6 - 4)) goto L42;
            r1 = r9 + 1;
            if (r1 == r8) goto L41;
            char r3 = r21.charAt(r1);
            if (Character.isSurrogatePair(r16, r3) == false) goto L39;
            int r5 = Character.toCodePoint(r16, r3);
            long r7 = r4 + 1;
            UnsafeUtil.putByte(r4, (byte) ((r5 >>> 18) | 240));
            long r11 = r7 + 1;
            r10 = 128;
            UnsafeUtil.putByte(r7, (byte) (((r5 >>> 12) & 63) | 128));
            long r13 = r11 + 1;
            UnsafeUtil.putByte(r11, (byte) (((r5 >>> 6) & 63) | 128));
            UnsafeUtil.putByte(r13, (byte) ((r5 & 63) | 128));
            r4 = r13 + 1;
            goto L38
        L39:
            r9 = r1;
        L41:
            throw new UnpairedSurrogateException(r9 - 1, r8);
        L42:
            if (55296 > r16) goto L51;
            if (r16 > 57343) goto L51;
            int r14 = r9 + 1;
            if (r14 == r8) goto L49;
            if (Character.isSurrogatePair(r16, r21.charAt(r14)) == true) goto L51;
        L49:
            throw new UnpairedSurrogateException(r9, r8);
        L51:
            throw new ArrayIndexOutOfBoundsException("Failed writing " + r16 + " at index " + r4);
        L29:
            if (r4 > (r6 - 3)) goto L32;
            long r18 = r4 + 1;
            UnsafeUtil.putByte(r4, (byte) ((r16 >>> '\f') | 480));
            long r19 = r18 + 1;
            UnsafeUtil.putByte(r18, (byte) (((r16 >>> 6) & 63) | 128));
            UnsafeUtil.putByte(r19, (byte) ((r16 & '?') | 128));
            r4 = r19 + 1;
        L24:
            r1 = r9;
            r10 = 128;
            goto L38
        L22:
            if (r4 > (r6 - 2)) goto L25;
            r17 = r2;
            long r20 = r4 + 1;
            UnsafeUtil.putByte(r4, (byte) ((r16 >>> 6) | 960));
            UnsafeUtil.putByte(r20, (byte) ((r16 & '?') | 128));
            r4 = r20 + 1;
            goto L24
        L52:
            Java8Compatibility.position(r22, (int) (r4 - r2));
            return;
        L55:
            throw new ArrayIndexOutOfBoundsException("Failed writing " + r21.charAt(r8 - 1) + " at index " + r22.limit());
        }

        private static int unsafeEstimateConsecutiveAscii(byte[] r8, long r9, int r11) {
            int r0 = 0;
            if (r11 >= 16) goto L5;
            return 0;
        L5:
            int r1 = 8 - (((int) r9) & 7);
        L7:
            if (r0 >= r1) goto L12;
            long r2 = 1 + r9;
            if (UnsafeUtil.getByte(r8, r9) < 0) goto L10;
            r0 = r0 + 1;
            r9 = r2;
            goto L7
        L10:
            return r0;
        L12:
            int r3 = r0 + 8;
            if (r3 > r11) goto L18;
            if ((UnsafeUtil.getLong(r8, UnsafeUtil.BYTE_ARRAY_BASE_OFFSET + r9) & Utf8.ASCII_MASK_LONG) != 0) goto L18;
            r9 = r9 + 8;
            r0 = r3;
        L18:
            if (r0 >= r11) goto L23;
            long r4 = r9 + 1;
            if (UnsafeUtil.getByte(r8, r9) < 0) goto L21;
            r0 = r0 + 1;
            r9 = r4;
            goto L18
        L21:
            return r0;
        L23:
            return r11;
        }

        private static int unsafeEstimateConsecutiveAscii(long r5, int r7) {
            if (r7 >= 16) goto L6;
            return 0;
        L6:
            int r0 = (int) ((-r5) & 7);
            int r1 = r0;
        L7:
            if (r1 <= 0) goto L13;
            long r2 = 1 + r5;
            if (UnsafeUtil.getByte(r5) < 0) goto L11;
            r1 = r1 - 1;
            r5 = r2;
            goto L7
        L11:
            return r0 - r1;
        L13:
            int r3 = r7 - r0;
        L15:
            if (r3 < 8) goto L20;
            if ((UnsafeUtil.getLong(r5) & Utf8.ASCII_MASK_LONG) != 0) goto L20;
            r5 = r5 + 8;
            r3 = r3 - 8;
        L20:
            return r7 - r3;
        }

        private static int partialIsValidUtf8(byte[] r8, long r9, int r11) {
            int r0 = unsafeEstimateConsecutiveAscii(r8, r9, r11);
            int r12 = r11 - r0;
            long r10 = r9 + ((long) r0);
        L3:
            byte r1 = 0;
        L5:
            if (r12 <= 0) goto L10;
            long r4 = r10 + 1;
            r1 = UnsafeUtil.getByte(r8, r10);
            if (r1 < 0) goto L9;
            r12 = r12 - 1;
            r10 = r4;
            goto L5
        L9:
            r10 = r4;
        L10:
            if (r12 == 0) goto L11;
            int r13 = r12 - 1;
            if (r1 >= (-32)) goto L24;
            if (r13 == 0) goto L15;
            r12 = r13 - 1;
            if (r1 < (-62)) goto L22;
            long r2 = 1 + r10;
            if (UnsafeUtil.getByte(r8, r10) > (-65)) goto L22;
        L21:
            r10 = r2;
        L22:
            return -1;
        L15:
            return r1;
        L24:
            if (r1 >= (-16)) goto L41;
            if (r13 < 2) goto L28;
            r12 = r13 - 2;
            long r6 = r10 + 1;
            byte r14 = UnsafeUtil.getByte(r8, r10);
            if (r14 > (-65)) goto L39;
            if (r1 != (-32)) goto L35;
            if (r14 < (-96)) goto L39;
        L35:
            if (r1 != (-19)) goto L37;
            if (r14 >= (-96)) goto L39;
        L37:
            r2 = 1 + r6;
            if (UnsafeUtil.getByte(r8, r6) <= (-65)) goto L21;
        L39:
            return -1;
        L28:
            return unsafeIncompleteStateFor(r8, r1, r10, r13);
        L41:
            if (r13 < 3) goto L43;
            r12 = r13 - 3;
            long r7 = r10 + 1;
            byte r15 = UnsafeUtil.getByte(r8, r10);
            if (r15 > (-65)) goto L52;
            if ((((r1 << 28) + (r15 + 112)) >> 30) != 0) goto L52;
            long r16 = r7 + 1;
            if (UnsafeUtil.getByte(r8, r7) > (-65)) goto L52;
            r2 = 1 + r16;
            if (UnsafeUtil.getByte(r8, r16) <= (-65)) goto L21;
        L52:
            return -1;
        L43:
            return unsafeIncompleteStateFor(r8, r1, r10, r13);
        L11:
            return 0;
        }

        private static int partialIsValidUtf8(long r8, int r10) {
            int r0 = unsafeEstimateConsecutiveAscii(r8, r10);
            long r9 = r8 + ((long) r0);
            int r11 = r10 - r0;
        L3:
            byte r1 = 0;
        L5:
            if (r11 <= 0) goto L10;
            long r4 = r9 + 1;
            r1 = UnsafeUtil.getByte(r9);
            if (r1 < 0) goto L9;
            r11 = r11 - 1;
            r9 = r4;
            goto L5
        L9:
            r9 = r4;
        L10:
            if (r11 == 0) goto L11;
            int r12 = r11 - 1;
            if (r1 >= (-32)) goto L24;
            if (r12 == 0) goto L15;
            r11 = r12 - 1;
            if (r1 < (-62)) goto L22;
            long r2 = 1 + r9;
            if (UnsafeUtil.getByte(r9) > (-65)) goto L22;
        L21:
            r9 = r2;
        L22:
            return -1;
        L15:
            return r1;
        L24:
            if (r1 >= (-16)) goto L41;
            if (r12 < 2) goto L28;
            r11 = r12 - 2;
            long r6 = r9 + 1;
            byte r13 = UnsafeUtil.getByte(r9);
            if (r13 > (-65)) goto L39;
            if (r1 != (-32)) goto L35;
            if (r13 < (-96)) goto L39;
        L35:
            if (r1 != (-19)) goto L37;
            if (r13 >= (-96)) goto L39;
        L37:
            r2 = 1 + r6;
            if (UnsafeUtil.getByte(r6) <= (-65)) goto L21;
        L39:
            return -1;
        L28:
            return unsafeIncompleteStateFor(r9, r1, r12);
        L41:
            if (r12 < 3) goto L43;
            r11 = r12 - 3;
            long r7 = r9 + 1;
            byte r14 = UnsafeUtil.getByte(r9);
            if (r14 > (-65)) goto L52;
            if ((((r1 << 28) + (r14 + 112)) >> 30) != 0) goto L52;
            long r15 = r7 + 1;
            if (UnsafeUtil.getByte(r7) > (-65)) goto L52;
            r2 = 1 + r15;
            if (UnsafeUtil.getByte(r15) <= (-65)) goto L21;
        L52:
            return -1;
        L43:
            return unsafeIncompleteStateFor(r9, r1, r12);
        L11:
            return 0;
        }

        private static int unsafeIncompleteStateFor(byte[] r2, int r3, long r4, int r6) {
            if (r6 == 0) goto L14;
            if (r6 == 1) goto L12;
            if (r6 != 2) goto L10;
            return Utf8.access$100(r3, UnsafeUtil.getByte(r2, r4), UnsafeUtil.getByte(r2, r4 + 1));
        L10:
            throw new AssertionError();
        L12:
            return Utf8.access$000(r3, UnsafeUtil.getByte(r2, r4));
        L14:
            return Utf8.access$1200(r3);
        }

        private static int unsafeIncompleteStateFor(long r2, int r4, int r5) {
            if (r5 == 0) goto L14;
            if (r5 == 1) goto L12;
            if (r5 != 2) goto L10;
            return Utf8.access$100(r4, UnsafeUtil.getByte(r2), UnsafeUtil.getByte(r2 + 1));
        L10:
            throw new AssertionError();
        L12:
            return Utf8.access$000(r4, UnsafeUtil.getByte(r2));
        L14:
            return Utf8.access$1200(r4);
        }
    }

    private static int incompleteStateFor(int r1) {
        if (r1 <= (-12)) goto L6;
        return -1;
    L6:
        return r1;
    }

    private static int incompleteStateFor(int r1, int r2) {
        if (r1 <= (-12)) goto L5;
    L8:
        return -1;
    L5:
        if (r2 > (-65)) goto L8;
        return r1 ^ (r2 << 8);
    }

    private static int incompleteStateFor(int r1, int r2, int r3) {
        if (r1 <= (-12)) goto L5;
    L9:
        return -1;
    L5:
        if (r2 > (-65)) goto L9;
        if (r3 > (-65)) goto L9;
        return (r1 ^ (r2 << 8)) ^ (r3 << 16);
    }

    static /* synthetic */ int access$000(int r0, int r1) {
        return incompleteStateFor(r0, r1);
    }

    static /* synthetic */ int access$100(int r0, int r1, int r2) {
        return incompleteStateFor(r0, r1, r2);
    }

    static /* synthetic */ int access$1100(byte[] r0, int r1, int r2) {
        return incompleteStateFor(r0, r1, r2);
    }

    static /* synthetic */ int access$1200(int r0) {
        return incompleteStateFor(r0);
    }

    static /* synthetic */ int access$200(ByteBuffer r0, int r1, int r2) {
        return estimateConsecutiveAscii(r0, r1, r2);
    }

    static /* synthetic */ int access$300(ByteBuffer r0, int r1, int r2, int r3) {
        return incompleteStateFor(r0, r1, r2, r3);
    }

    static {
        if (UnsafeProcessor.isAvailable() == true) goto L5;
    L7:
        Processor r0 = new SafeProcessor();
    L8:
        processor = r0;
        return;
    L5:
        if (Android.isOnAndroidDevice() == true) goto L7;
        r0 = new UnsafeProcessor();
        goto L8
    }

    static boolean isValidUtf8(byte[] r3) {
        return processor.isValidUtf8(r3, 0, r3.length);
    }

    static boolean isValidUtf8(byte[] r1, int r2, int r3) {
        return processor.isValidUtf8(r1, r2, r3);
    }

    static int partialIsValidUtf8(int r1, byte[] r2, int r3, int r4) {
        return processor.partialIsValidUtf8(r1, r2, r3, r4);
    }

    private static int incompleteStateFor(byte[] r3, int r4, int r5) {
        byte r0 = r3[r4 - 1];
        int r6 = r5 - r4;
        if (r6 == 0) goto L15;
        if (r6 == 1) goto L13;
        if (r6 != 2) goto L11;
        return incompleteStateFor(r0, r3[r4], r3[r4 + 1]);
    L11:
        throw new AssertionError();
    L13:
        return incompleteStateFor(r0, r3[r4]);
    L15:
        return incompleteStateFor(r0);
    }

    private static int incompleteStateFor(ByteBuffer r2, int r3, int r4, int r5) {
        if (r5 == 0) goto L14;
        if (r5 == 1) goto L12;
        if (r5 != 2) goto L10;
        return incompleteStateFor(r3, r2.get(r4), r2.get(r4 + 1));
    L10:
        throw new AssertionError();
    L12:
        return incompleteStateFor(r3, r2.get(r4));
    L14:
        return incompleteStateFor(r3);
    }

    static int encodedLength(String r5) {
        int r0 = r5.length();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L7;
        if (r5.charAt(r1) >= 128) goto L7;
        r1 = r1 + 1;
    L7:
        int r2 = r0;
    L8:
        if (r1 >= r0) goto L13;
        char r3 = r5.charAt(r1);
        if (r3 >= 2048) goto L12;
        r2 = r2 + ((127 - r3) >>> 31);
        r1 = r1 + 1;
        goto L8
    L12:
        r2 = r2 + encodedLengthGeneral(r5, r1);
    L13:
        if (r2 < r0) goto L16;
        return r2;
    L16:
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) r2) + 4294967296L));
    }

    private static int encodedLengthGeneral(String r4, int r5) {
        int r0 = r4.length();
        int r1 = 0;
    L3:
        if (r5 >= r0) goto L17;
        char r2 = r4.charAt(r5);
        if (r2 >= 2048) goto L7;
        r1 = r1 + ((127 - r2) >>> 31);
    L16:
        r5 = r5 + 1;
        goto L3
    L7:
        r1 = r1 + 2;
        if (55296 > r2) goto L16;
        if (r2 > 57343) goto L16;
        if (Character.codePointAt(r4, r5) < 65536) goto L15;
        r5 = r5 + 1;
        goto L16
    L15:
        throw new UnpairedSurrogateException(r5, r0);
    L17:
        return r1;
    }

    static int encode(String r1, byte[] r2, int r3, int r4) {
        return processor.encodeUtf8(r1, r2, r3, r4);
    }

    static boolean isValidUtf8(ByteBuffer r3) {
        return processor.isValidUtf8(r3, r3.position(), r3.remaining());
    }

    static int partialIsValidUtf8(int r1, ByteBuffer r2, int r3, int r4) {
        return processor.partialIsValidUtf8(r1, r2, r3, r4);
    }

    static String decodeUtf8(ByteBuffer r1, int r2, int r3) {
        return processor.decodeUtf8(r1, r2, r3);
    }

    static String decodeUtf8(byte[] r1, int r2, int r3) {
        return processor.decodeUtf8(r1, r2, r3);
    }

    static void encodeUtf8(String r1, ByteBuffer r2) {
        processor.encodeUtf8(r1, r2);
    }

    private static int estimateConsecutiveAscii(ByteBuffer r5, int r6, int r7) {
        int r8 = r7 - 7;
        int r0 = r6;
    L3:
        if (r0 >= r8) goto L8;
        if ((r5.getLong(r0) & ASCII_MASK_LONG) != 0) goto L8;
        r0 = r0 + 8;
    L8:
        return r0 - r6;
    }

    private Utf8() {
    }
}
