package com.bytedance.location.protobuf;

import android.hardware.tv.mediaquality.ParameterName;
import com.android.internal.util.FrameworkStatsLog;
import com.android.server.SystemService;
import com.android.server.usb.descriptors.UsbDescriptor;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
final class Utf8 {
    private static final long ASCII_MASK_LONG = -9187201950435737472L;
    static final int COMPLETE = 0;
    static final int MALFORMED = -1;
    static final int MAX_BYTES_PER_CHAR = 3;
    private static final int UNSAFE_COUNT_ASCII_THRESHOLD = 16;
    private static final Processor processor = null;

    private static class DecodeUtil {
        private DecodeUtil() {
        }

        static /* synthetic */ void access$1000(byte x0, byte x1, byte x2, byte x3, char[] x4, int x5) throws InvalidProtocolBufferException {
            handleFourBytes(x0, x1, x2, x3, x4, x5);
        }

        static /* synthetic */ boolean access$400(byte x0) {
            return isOneByte(x0);
        }

        static /* synthetic */ void access$500(byte x0, char[] x1, int x2) {
            handleOneByte(x0, x1, x2);
        }

        static /* synthetic */ boolean access$600(byte x0) {
            return isTwoBytes(x0);
        }

        static /* synthetic */ void access$700(byte x0, byte x1, char[] x2, int x3) throws InvalidProtocolBufferException {
            handleTwoBytes(x0, x1, x2, x3);
        }

        static /* synthetic */ boolean access$800(byte x0) {
            return isThreeBytes(x0);
        }

        static /* synthetic */ void access$900(byte x0, byte x1, byte x2, char[] x3, int x4) throws InvalidProtocolBufferException {
            handleThreeBytes(x0, x1, x2, x3, x4);
        }

        private static boolean isOneByte(byte b) {
            if (b < 0) goto L4;
            return true;
        L4:
            return false;
        }

        private static boolean isTwoBytes(byte b) {
            if (b >= (-32)) goto L5;
            return true;
        L5:
            return false;
        }

        private static boolean isThreeBytes(byte b) {
            if (b >= (-16)) goto L5;
            return true;
        L5:
            return false;
        }

        private static void handleOneByte(byte byte1, char[] resultArr, int resultPos) {
            resultArr[resultPos] = (char) byte1;
        }

        private static void handleTwoBytes(byte byte1, byte byte2, char[] resultArr, int resultPos) throws InvalidProtocolBufferException {
            if (byte1 < (-62)) goto L9;
            if (isNotTrailingByte(byte2) == true) goto L9;
            resultArr[resultPos] = (char) (((byte1 & ParameterName.VRR) << 6) | trailingByteValue(byte2));
            return;
        L9:
            throw InvalidProtocolBufferException.invalidUtf8();
        }

        private static void handleThreeBytes(byte byte1, byte byte2, byte byte3, char[] resultArr, int resultPos) throws InvalidProtocolBufferException {
            if (isNotTrailingByte(byte2) == true) goto L15;
            if (byte1 != (-32)) goto L8;
            if (byte2 < (-96)) goto L15;
        L8:
            if (byte1 != (-19)) goto L11;
            if (byte2 >= (-96)) goto L15;
        L11:
            if (isNotTrailingByte(byte3) == true) goto L15;
            resultArr[resultPos] = (char) ((((byte1 & 15) << 12) | (trailingByteValue(byte2) << 6)) | trailingByteValue(byte3));
            return;
        L15:
            throw InvalidProtocolBufferException.invalidUtf8();
        }

        private static void handleFourBytes(byte byte1, byte byte2, byte byte3, byte byte4, char[] resultArr, int resultPos) throws InvalidProtocolBufferException {
            if (isNotTrailingByte(byte2) == true) goto L13;
            if ((((byte1 << ParameterName.GAMUT_MAPPING) + (byte2 + 112)) >> 30) != 0) goto L13;
            if (isNotTrailingByte(byte3) == true) goto L13;
            if (isNotTrailingByte(byte4) == true) goto L13;
            int codepoint = ((((byte1 & 7) << 18) | (trailingByteValue(byte2) << 12)) | (trailingByteValue(byte3) << 6)) | trailingByteValue(byte4);
            resultArr[resultPos] = highSurrogate(codepoint);
            resultArr[resultPos + 1] = lowSurrogate(codepoint);
            return;
        L13:
            throw InvalidProtocolBufferException.invalidUtf8();
        }

        private static boolean isNotTrailingByte(byte b) {
            if (b <= (-65)) goto L5;
            return true;
        L5:
            return false;
        }

        private static int trailingByteValue(byte b) {
            return b & ParameterName.COLOR_TUNER_HUE_YELLOW;
        }

        private static char highSurrogate(int codePoint) {
            return (char) ((codePoint >>> 10) + 55232);
        }

        private static char lowSurrogate(int codePoint) {
            return (char) ((codePoint & 1023) + 56320);
        }
    }

    static abstract class Processor {
        abstract String decodeUtf8(byte[] r1, int r2, int r3) throws InvalidProtocolBufferException;

        abstract String decodeUtf8Direct(ByteBuffer r1, int r2, int r3) throws InvalidProtocolBufferException;

        abstract int encodeUtf8(CharSequence r1, byte[] r2, int r3, int r4);

        abstract void encodeUtf8Direct(CharSequence r1, ByteBuffer r2);

        abstract int partialIsValidUtf8(int r1, byte[] r2, int r3, int r4);

        abstract int partialIsValidUtf8Direct(int r1, ByteBuffer r2, int r3, int r4);

        Processor() {
        }

        final boolean isValidUtf8(byte[] bytes, int index, int limit) {
            if (partialIsValidUtf8(0, bytes, index, limit) != 0) goto L6;
            return true;
        L6:
            return false;
        }

        final boolean isValidUtf8(ByteBuffer buffer, int index, int limit) {
            if (partialIsValidUtf8(0, buffer, index, limit) != 0) goto L6;
            return true;
        L6:
            return false;
        }

        final int partialIsValidUtf8(int state, ByteBuffer buffer, int index, int limit) {
            if (buffer.hasArray() == false) goto L7;
            int offset = buffer.arrayOffset();
            return partialIsValidUtf8(state, buffer.array(), offset + index, offset + limit);
        L7:
            if (buffer.isDirect() == false) goto L11;
            return partialIsValidUtf8Direct(state, buffer, index, limit);
        L11:
            return partialIsValidUtf8Default(state, buffer, index, limit);
        }

        final int partialIsValidUtf8Default(int state, ByteBuffer buffer, int index, int limit) {
            if (state == 0) goto L59;
            if (index < limit) goto L5;
            return state;
        L5:
            byte byte1 = (byte) state;
            if (byte1 >= (-32)) goto L15;
            if (byte1 < (-62)) goto L13;
            int index2 = index + 1;
            if (buffer.get(index) > (-65)) goto L13;
            index = index2;
        L13:
            return -1;
        L15:
            if (byte1 >= (-16)) goto L35;
            byte byte2 = (byte) (~(state >> 8));
            if (byte2 != 0) goto L23;
            int index3 = index + 1;
            byte2 = buffer.get(index);
            if (index3 >= limit) goto L21;
            index = index3;
            goto L23
        L21:
            return Utf8.access$000(byte1, byte2);
        L23:
            if (byte2 <= (-65)) goto L25;
        L34:
            return -1;
        L25:
            if (byte1 != (-32)) goto L28;
            if (byte2 < (-96)) goto L34;
        L28:
            if (byte1 != (-19)) goto L30;
            if (byte2 >= (-96)) goto L34;
        L30:
            int index4 = index + 1;
            if (buffer.get(index) > (-65)) goto L34;
            index = index4;
            goto L59
        L35:
            byte byte3 = (byte) (~(state >> 8));
            byte byte4 = 0;
            if (byte3 != 0) goto L42;
            int index5 = index + 1;
            byte3 = buffer.get(index);
            if (index5 >= limit) goto L40;
            index = index5;
        L43:
            if (byte4 != 0) goto L49;
            int index6 = index + 1;
            byte4 = buffer.get(index);
            if (index6 >= limit) goto L47;
            index = index6;
            goto L49
        L47:
            return Utf8.access$100(byte1, byte3, byte4);
        L49:
            if (byte3 <= (-65)) goto L51;
        L57:
            return -1;
        L51:
            if ((((byte1 << ParameterName.GAMUT_MAPPING) + (byte3 + 112)) >> 30) != 0) goto L57;
            if (byte4 > (-65)) goto L57;
            int index7 = index + 1;
            if (buffer.get(index) > (-65)) goto L57;
            index = index7;
            goto L59
        L40:
            return Utf8.access$000(byte1, byte3);
        L42:
            byte4 = (byte) (state >> 16);
        L59:
            return partialIsValidUtf8(buffer, index, limit);
        }

        private static int partialIsValidUtf8(ByteBuffer buffer, int index, int limit) {
            int index2 = index + Utf8.access$200(buffer, index, limit);
        L3:
            if (index2 >= limit) goto L4;
            int index3 = index2 + 1;
            int byte1 = buffer.get(index2);
            if (byte1 < 0) goto L9;
            index2 = index3;
            goto L3
        L9:
            if (byte1 < (-32)) goto L10;
            if (byte1 < (-16)) goto L22;
            if (index3 >= (limit - 2)) goto L41;
            int index4 = index3 + 1;
            int byte2 = buffer.get(index3);
            if (byte2 > (-65)) goto L53;
            if ((((byte1 << 28) + (byte2 + 112)) >> 30) != 0) goto L53;
            int index5 = index4 + 1;
            if (buffer.get(index4) > (-65)) goto L53;
            index2 = index5 + 1;
            if (buffer.get(index5) <= (-65)) goto L3;
        L53:
            return -1;
        L41:
            return Utf8.access$300(buffer, byte1, index3, limit - index3);
        L22:
            if (index3 >= (limit - 1)) goto L24;
            int index6 = index3 + 1;
            byte byte3 = buffer.get(index3);
            if (byte3 > (-65)) goto L37;
            if (byte1 != (-32)) goto L31;
            if (byte3 < (-96)) goto L37;
        L31:
            if (byte1 != (-19)) goto L34;
            if (byte3 >= (-96)) goto L37;
        L34:
            if (buffer.get(index6) > (-65)) goto L37;
            index2 = index6 + 1;
        L37:
            return -1;
        L24:
            return Utf8.access$300(buffer, byte1, index3, limit - index3);
        L10:
            if (index3 >= limit) goto L11;
            if (byte1 < (-62)) goto L18;
            if (buffer.get(index3) > (-65)) goto L18;
            index2 = index3 + 1;
        L18:
            return -1;
        L11:
            return byte1;
        L4:
            return 0;
        }

        final String decodeUtf8(ByteBuffer buffer, int index, int size) throws InvalidProtocolBufferException {
            if (buffer.hasArray() == false) goto L7;
            int offset = buffer.arrayOffset();
            return decodeUtf8(buffer.array(), offset + index, size);
        L7:
            if (buffer.isDirect() == false) goto L11;
            return decodeUtf8Direct(buffer, index, size);
        L11:
            return decodeUtf8Default(buffer, index, size);
        }

        final String decodeUtf8Default(ByteBuffer buffer, int index, int size) throws InvalidProtocolBufferException {
            if (((index | size) | ((buffer.limit() - index) - size)) < 0) goto L43;
            int offset = index;
            int limit = offset + size;
            char[] resultArr = new char[size];
            int resultPos = 0;
        L5:
            if (offset >= limit) goto L10;
            byte b = buffer.get(offset);
            if (DecodeUtil.access$400(b) == false) goto L10;
            offset = offset + 1;
            DecodeUtil.access$500(b, resultArr, resultPos);
            resultPos = resultPos + 1;
        L10:
            int resultPos2 = resultPos;
        L11:
            if (offset >= limit) goto L41;
            int offset2 = offset + 1;
            byte byte1 = buffer.get(offset);
            if (DecodeUtil.access$400(byte1) == true) goto L14;
            if (DecodeUtil.access$600(byte1) == true) goto L23;
            if (DecodeUtil.access$800(byte1) == true) goto L30;
            if (offset2 >= (limit - 2)) goto L39;
            int offset3 = offset2 + 1;
            int offset4 = offset3 + 1;
            DecodeUtil.access$1000(byte1, buffer.get(offset2), buffer.get(offset3), buffer.get(offset4), resultArr, resultPos2);
            offset = offset4 + 1;
            resultPos2 = (resultPos2 + 1) + 1;
            goto L11
        L39:
            throw InvalidProtocolBufferException.invalidUtf8();
        L30:
            if (offset2 >= (limit - 1)) goto L33;
            int offset5 = offset2 + 1;
            DecodeUtil.access$900(byte1, buffer.get(offset2), buffer.get(offset5), resultArr, resultPos2);
            offset = offset5 + 1;
            resultPos2 = resultPos2 + 1;
            goto L11
        L33:
            throw InvalidProtocolBufferException.invalidUtf8();
        L23:
            if (offset2 >= limit) goto L26;
            offset = offset2 + 1;
            DecodeUtil.access$700(byte1, buffer.get(offset2), resultArr, resultPos2);
            resultPos2 = resultPos2 + 1;
            goto L11
        L26:
            throw InvalidProtocolBufferException.invalidUtf8();
        L14:
            int resultPos3 = resultPos2 + 1;
            DecodeUtil.access$500(byte1, resultArr, resultPos2);
        L15:
            if (offset2 >= limit) goto L20;
            byte b2 = buffer.get(offset2);
            if (DecodeUtil.access$400(b2) == false) goto L20;
            offset2 = offset2 + 1;
            DecodeUtil.access$500(b2, resultArr, resultPos3);
            resultPos3 = resultPos3 + 1;
        L20:
            resultPos2 = resultPos3;
            offset = offset2;
            goto L11
        L41:
            return new String(resultArr, 0, resultPos2);
        L43:
            throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", new Object[]{Integer.valueOf(buffer.limit()), Integer.valueOf(index), Integer.valueOf(size)}));
        }

        final void encodeUtf8(CharSequence in, ByteBuffer out) {
            if (out.hasArray() == false) goto L6;
            int offset = out.arrayOffset();
            int endIndex = Utf8.encode(in, out.array(), out.position() + offset, out.remaining());
            out.position(endIndex - offset);
            return;
        L6:
            if (out.isDirect() == false) goto L8;
            encodeUtf8Direct(in, out);
            return;
        L8:
            encodeUtf8Default(in, out);
        }

        final void encodeUtf8Default(CharSequence in, ByteBuffer out) {
            int inLength = in.length();
            int outIx = out.position();
            int inIx = 0;
        L4:
            if (inIx >= inLength) goto L10;
            char c = in.charAt(inIx);     // Catch: IndexOutOfBoundsException -> L8
            if (c >= 128) goto L10;
            out.put(outIx + inIx, (byte) c);     // Catch: IndexOutOfBoundsException -> L8
            inIx = inIx + 1;     // Catch: IndexOutOfBoundsException -> L8
        L55:
            int badWriteIndex = out.position() + Math.max(inIx, (outIx - out.position()) + 1);
            throw new ArrayIndexOutOfBoundsException("Failed writing " + in.charAt(inIx) + " at index " + badWriteIndex);
        L10:
            if (inIx != inLength) goto L13;
            out.position(outIx + inIx);     // Catch: IndexOutOfBoundsException -> L8
            return;
        L13:
            int outIx2 = outIx + inIx;     // Catch: IndexOutOfBoundsException -> L8
        L14:
            if (inIx >= inLength) goto L53;
            char c2 = in.charAt(inIx);     // Catch: IndexOutOfBoundsException -> L8
            if (c2 >= 128) goto L20;
            out.put(outIx2, (byte) c2);     // Catch: IndexOutOfBoundsException -> L8
        L52:
            inIx = inIx + 1;     // Catch: IndexOutOfBoundsException -> L8
            outIx2 = outIx2 + 1;     // Catch: IndexOutOfBoundsException -> L8
            goto L14
        L20:
            if (c2 >= 2048) goto L27;
            int outIx3 = outIx2 + 1;
            out.put(outIx2, (byte) ((c2 >>> 6) | 192));     // Catch: IndexOutOfBoundsException -> L24
            out.put(outIx3, (byte) ((c2 & '?') | 128));     // Catch: IndexOutOfBoundsException -> L24
            outIx2 = outIx3;
        L25:
            outIx = outIx3;
            goto L55
        L27:
            if (c2 >= 55296) goto L29;
        L48:
            int outIx4 = outIx2 + 1;
            out.put(outIx2, (byte) ((c2 >>> '\f') | UsbDescriptor.CLASSID_WIRELESS));     // Catch: IndexOutOfBoundsException -> L24
            outIx2 = outIx4 + 1;
            out.put(outIx4, (byte) (((c2 >>> 6) & 63) | 128));     // Catch: IndexOutOfBoundsException -> L8
            out.put(outIx2, (byte) ((c2 & '?') | 128));     // Catch: IndexOutOfBoundsException -> L8
            goto L52
        L29:
            if (57343 < c2) goto L48;
            if ((inIx + 1) == inLength) goto L47;
            inIx = inIx + 1;
            char low = in.charAt(inIx);     // Catch: IndexOutOfBoundsException -> L8
            if (Character.isSurrogatePair(c2, low) == false) goto L47;
            int codePoint = Character.toCodePoint(c2, low);     // Catch: IndexOutOfBoundsException -> L8
            int outIx5 = outIx2 + 1;
            out.put(outIx2, (byte) ((codePoint >>> 18) | FrameworkStatsLog.BOOT_TIME_EVENT_ELAPSED_TIME_REPORTED));     // Catch: IndexOutOfBoundsException -> L44
            int outIx6 = outIx5 + 1;
            out.put(outIx5, (byte) (((codePoint >>> 12) & 63) | 128));     // Catch: IndexOutOfBoundsException -> L8
            outIx5 = outIx6 + 1;
            out.put(outIx6, (byte) (((codePoint >>> 6) & 63) | 128));     // Catch: IndexOutOfBoundsException -> L44
            out.put(outIx5, (byte) ((codePoint & 63) | 128));     // Catch: IndexOutOfBoundsException -> L44
            outIx2 = outIx5;
        L45:
            outIx = outIx5;
        L47:
            throw new UnpairedSurrogateException(inIx, inLength);     // Catch: IndexOutOfBoundsException -> L8
        L53:
            out.position(outIx2);     // Catch: IndexOutOfBoundsException -> L8
        }
    }

    static final class SafeProcessor extends Processor {
        SafeProcessor() {
        }

        @Override // com.bytedance.location.protobuf.Utf8.Processor
        int partialIsValidUtf8(int state, byte[] bytes, int index, int limit) {
            if (state == 0) goto L59;
            if (index < limit) goto L5;
            return state;
        L5:
            int byte1 = (byte) state;
            if (byte1 >= (-32)) goto L15;
            if (byte1 < (-62)) goto L13;
            int index2 = index + 1;
            if (bytes[index] > (-65)) goto L13;
            index = index2;
        L13:
            return -1;
        L15:
            if (byte1 >= (-16)) goto L35;
            int byte2 = (byte) (~(state >> 8));
            if (byte2 != 0) goto L23;
            int index3 = index + 1;
            byte2 = bytes[index];
            if (index3 >= limit) goto L21;
            index = index3;
            goto L23
        L21:
            return Utf8.access$000(byte1, byte2);
        L23:
            if (byte2 <= (-65)) goto L25;
        L34:
            return -1;
        L25:
            if (byte1 != (-32)) goto L28;
            if (byte2 < (-96)) goto L34;
        L28:
            if (byte1 != (-19)) goto L30;
            if (byte2 >= (-96)) goto L34;
        L30:
            int index4 = index + 1;
            if (bytes[index] > (-65)) goto L34;
            index = index4;
            goto L59
        L35:
            int byte3 = (byte) (~(state >> 8));
            int byte4 = 0;
            if (byte3 != 0) goto L42;
            int index5 = index + 1;
            byte3 = bytes[index];
            if (index5 >= limit) goto L40;
            index = index5;
        L43:
            if (byte4 != 0) goto L49;
            int index6 = index + 1;
            byte4 = bytes[index];
            if (index6 >= limit) goto L47;
            index = index6;
            goto L49
        L47:
            return Utf8.access$100(byte1, byte3, byte4);
        L49:
            if (byte3 <= (-65)) goto L51;
        L57:
            return -1;
        L51:
            if ((((byte1 << 28) + (byte3 + 112)) >> 30) != 0) goto L57;
            if (byte4 > (-65)) goto L57;
            int index7 = index + 1;
            if (bytes[index] > (-65)) goto L57;
            index = index7;
            goto L59
        L40:
            return Utf8.access$000(byte1, byte3);
        L42:
            byte4 = (byte) (state >> 16);
        L59:
            return partialIsValidUtf8(bytes, index, limit);
        }

        @Override // com.bytedance.location.protobuf.Utf8.Processor
        int partialIsValidUtf8Direct(int state, ByteBuffer buffer, int index, int limit) {
            return partialIsValidUtf8Default(state, buffer, index, limit);
        }

        @Override // com.bytedance.location.protobuf.Utf8.Processor
        String decodeUtf8(byte[] bytes, int index, int size) throws InvalidProtocolBufferException {
            if (((index | size) | ((bytes.length - index) - size)) < 0) goto L43;
            int offset = index;
            int limit = offset + size;
            char[] resultArr = new char[size];
            int resultPos = 0;
        L5:
            if (offset >= limit) goto L10;
            byte b = bytes[offset];
            if (DecodeUtil.access$400(b) == false) goto L10;
            offset = offset + 1;
            DecodeUtil.access$500(b, resultArr, resultPos);
            resultPos = resultPos + 1;
        L10:
            int resultPos2 = resultPos;
        L11:
            if (offset >= limit) goto L41;
            int offset2 = offset + 1;
            byte byte1 = bytes[offset];
            if (DecodeUtil.access$400(byte1) == true) goto L14;
            if (DecodeUtil.access$600(byte1) == true) goto L23;
            if (DecodeUtil.access$800(byte1) == true) goto L30;
            if (offset2 >= (limit - 2)) goto L39;
            int offset3 = offset2 + 1;
            int offset4 = offset3 + 1;
            DecodeUtil.access$1000(byte1, bytes[offset2], bytes[offset3], bytes[offset4], resultArr, resultPos2);
            offset = offset4 + 1;
            resultPos2 = (resultPos2 + 1) + 1;
            goto L11
        L39:
            throw InvalidProtocolBufferException.invalidUtf8();
        L30:
            if (offset2 >= (limit - 1)) goto L33;
            int offset5 = offset2 + 1;
            DecodeUtil.access$900(byte1, bytes[offset2], bytes[offset5], resultArr, resultPos2);
            offset = offset5 + 1;
            resultPos2 = resultPos2 + 1;
            goto L11
        L33:
            throw InvalidProtocolBufferException.invalidUtf8();
        L23:
            if (offset2 >= limit) goto L26;
            offset = offset2 + 1;
            DecodeUtil.access$700(byte1, bytes[offset2], resultArr, resultPos2);
            resultPos2 = resultPos2 + 1;
            goto L11
        L26:
            throw InvalidProtocolBufferException.invalidUtf8();
        L14:
            int resultPos3 = resultPos2 + 1;
            DecodeUtil.access$500(byte1, resultArr, resultPos2);
        L15:
            if (offset2 >= limit) goto L20;
            byte b2 = bytes[offset2];
            if (DecodeUtil.access$400(b2) == false) goto L20;
            offset2 = offset2 + 1;
            DecodeUtil.access$500(b2, resultArr, resultPos3);
            resultPos3 = resultPos3 + 1;
        L20:
            resultPos2 = resultPos3;
            offset = offset2;
            goto L11
        L41:
            return new String(resultArr, 0, resultPos2);
        L43:
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", new Object[]{Integer.valueOf(bytes.length), Integer.valueOf(index), Integer.valueOf(size)}));
        }

        @Override // com.bytedance.location.protobuf.Utf8.Processor
        String decodeUtf8Direct(ByteBuffer buffer, int index, int size) throws InvalidProtocolBufferException {
            return decodeUtf8Default(buffer, index, size);
        }

        @Override // com.bytedance.location.protobuf.Utf8.Processor
        int encodeUtf8(CharSequence in, byte[] out, int offset, int length) {
            int utf16Length = in.length();
            int i = 0;
            int limit = offset + length;
        L4:
            if (i >= utf16Length) goto L10;
            if ((i + offset) >= limit) goto L10;
            char c = in.charAt(i);
            if (c >= 128) goto L10;
            out[offset + i] = (byte) c;
            i = i + 1;
        L10:
            if (i == utf16Length) goto L12;
            int j = offset + i;
        L14:
            if (i >= utf16Length) goto L50;
            char c2 = in.charAt(i);
            if (c2 >= 128) goto L20;
            if (j >= limit) goto L20;
            out[j] = (byte) c2;
            j = j + 1;
        L37:
            i = i + 1;
        L20:
            if (c2 >= 2048) goto L25;
            if (j > (limit - 2)) goto L25;
            int j2 = j + 1;
            out[j] = (byte) ((c2 >>> 6) | 960);
            j = j2 + 1;
            out[j2] = (byte) ((c2 & '?') | 128);
        L25:
            if (c2 < 55296) goto L28;
            if (57343 < c2) goto L28;
        L31:
            if (j > (limit - 4)) goto L40;
            if ((i + 1) == in.length()) goto L39;
            i = i + 1;
            char low = in.charAt(i);
            if (Character.isSurrogatePair(c2, low) == false) goto L39;
            int codePoint = Character.toCodePoint(c2, low);
            int j3 = j + 1;
            out[j] = (byte) ((codePoint >>> 18) | FrameworkStatsLog.BOOT_TIME_EVENT_ELAPSED_TIME_REPORTED);
            int j4 = j3 + 1;
            out[j3] = (byte) (((codePoint >>> 12) & 63) | 128);
            int j5 = j4 + 1;
            out[j4] = (byte) (((codePoint >>> 6) & 63) | 128);
            j = j5 + 1;
            out[j5] = (byte) ((codePoint & 63) | 128);
        L39:
            throw new UnpairedSurrogateException(i - 1, utf16Length);
        L40:
            if (55296 > c2) goto L49;
            if (c2 > 57343) goto L49;
            if ((i + 1) == in.length()) goto L47;
            if (Character.isSurrogatePair(c2, in.charAt(i + 1)) == true) goto L49;
        L47:
            throw new UnpairedSurrogateException(i, utf16Length);
        L49:
            throw new ArrayIndexOutOfBoundsException("Failed writing " + c2 + " at index " + j);
        L28:
            if (j > (limit - 3)) goto L31;
            int j6 = j + 1;
            out[j] = (byte) ((c2 >>> '\f') | SystemService.PHASE_LOCK_SETTINGS_READY);
            int j7 = j6 + 1;
            out[j6] = (byte) (((c2 >>> 6) & 63) | 128);
            out[j7] = (byte) ((c2 & '?') | 128);
            j = j7 + 1;
            goto L37
        L50:
            return j;
        L12:
            return offset + utf16Length;
        }

        @Override // com.bytedance.location.protobuf.Utf8.Processor
        void encodeUtf8Direct(CharSequence in, ByteBuffer out) {
            encodeUtf8Default(in, out);
        }

        private static int partialIsValidUtf8(byte[] bytes, int index, int limit) {
        L2:
            if (index >= limit) goto L6;
            if (bytes[index] < 0) goto L6;
            index = index + 1;
        L6:
            if (index < limit) goto L9;
            return 0;
        L9:
            return partialIsValidUtf8NonAscii(bytes, index, limit);
        }

        private static int partialIsValidUtf8NonAscii(byte[] bytes, int index, int limit) {
        L2:
            if (index >= limit) goto L3;
            int index2 = index + 1;
            int byte1 = bytes[index];
            if (byte1 < 0) goto L8;
            index = index2;
            goto L2
        L8:
            if (byte1 < (-32)) goto L9;
            if (byte1 < (-16)) goto L20;
            if (index2 >= (limit - 2)) goto L38;
            int index3 = index2 + 1;
            int byte2 = bytes[index2];
            if (byte2 > (-65)) goto L50;
            if ((((byte1 << 28) + (byte2 + 112)) >> 30) != 0) goto L50;
            int index4 = index3 + 1;
            if (bytes[index3] > (-65)) goto L50;
            index = index4 + 1;
            if (bytes[index4] <= (-65)) goto L2;
        L50:
            return -1;
        L38:
            return Utf8.access$1100(bytes, index2, limit);
        L20:
            if (index2 >= (limit - 1)) goto L22;
            int index5 = index2 + 1;
            int byte3 = bytes[index2];
            if (byte3 > (-65)) goto L34;
            if (byte1 != (-32)) goto L29;
            if (byte3 < (-96)) goto L34;
        L29:
            if (byte1 != (-19)) goto L31;
            if (byte3 >= (-96)) goto L34;
        L31:
            index = index5 + 1;
            if (bytes[index5] <= (-65)) goto L2;
        L34:
            return -1;
        L22:
            return Utf8.access$1100(bytes, index2, limit);
        L9:
            if (index2 >= limit) goto L10;
            if (byte1 < (-62)) goto L16;
            index = index2 + 1;
            if (bytes[index2] <= (-65)) goto L2;
        L16:
            return -1;
        L10:
            return byte1;
        L3:
            return 0;
        }
    }

    static class UnpairedSurrogateException extends IllegalArgumentException {
        UnpairedSurrogateException(int index, int length) {
            super("Unpaired surrogate at index " + index + " of " + length);
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

        @Override // com.bytedance.location.protobuf.Utf8.Processor
        int partialIsValidUtf8(int state, byte[] bytes, int index, int limit) {
            if (((index | limit) | (bytes.length - limit)) < 0) goto L65;
            long offset = index;
            long offsetLimit = limit;
            if (state == 0) goto L63;
            if (offset < offsetLimit) goto L9;
            return state;
        L9:
            int byte1 = (byte) state;
            if (byte1 >= (-32)) goto L19;
            if (byte1 < (-62)) goto L17;
            long offset2 = 1 + offset;
            if (UnsafeUtil.getByte(bytes, offset) > (-65)) goto L17;
            offset = offset2;
        L17:
            return -1;
        L19:
            if (byte1 >= (-16)) goto L39;
            int byte2 = (byte) (~(state >> 8));
            if (byte2 != 0) goto L27;
            long offset3 = offset + 1;
            byte2 = UnsafeUtil.getByte(bytes, offset);
            if (offset3 >= offsetLimit) goto L25;
            offset = offset3;
            goto L27
        L25:
            return Utf8.access$000(byte1, byte2);
        L27:
            if (byte2 <= (-65)) goto L29;
        L38:
            return -1;
        L29:
            if (byte1 != (-32)) goto L32;
            if (byte2 < (-96)) goto L38;
        L32:
            if (byte1 != (-19)) goto L34;
            if (byte2 >= (-96)) goto L38;
        L34:
            long offset4 = 1 + offset;
            if (UnsafeUtil.getByte(bytes, offset) > (-65)) goto L38;
            offset = offset4;
            goto L63
        L39:
            int byte3 = (byte) (~(state >> 8));
            int byte4 = 0;
            if (byte3 != 0) goto L46;
            long offset5 = offset + 1;
            byte3 = UnsafeUtil.getByte(bytes, offset);
            if (offset5 >= offsetLimit) goto L44;
            offset = offset5;
        L47:
            if (byte4 != 0) goto L53;
            long offset6 = offset + 1;
            byte4 = UnsafeUtil.getByte(bytes, offset);
            if (offset6 >= offsetLimit) goto L51;
            offset = offset6;
            goto L53
        L51:
            return Utf8.access$100(byte1, byte3, byte4);
        L53:
            if (byte3 <= (-65)) goto L55;
        L61:
            return -1;
        L55:
            if ((((byte1 << 28) + (byte3 + 112)) >> 30) != 0) goto L61;
            if (byte4 > (-65)) goto L61;
            long offset7 = 1 + offset;
            if (UnsafeUtil.getByte(bytes, offset) > (-65)) goto L61;
            offset = offset7;
            goto L63
        L44:
            return Utf8.access$000(byte1, byte3);
        L46:
            byte4 = (byte) (state >> 16);
        L63:
            return partialIsValidUtf8(bytes, offset, (int) (offsetLimit - offset));
        L65:
            throw new ArrayIndexOutOfBoundsException(String.format("Array length=%d, index=%d, limit=%d", new Object[]{Integer.valueOf(bytes.length), Integer.valueOf(index), Integer.valueOf(limit)}));
        }

        @Override // com.bytedance.location.protobuf.Utf8.Processor
        int partialIsValidUtf8Direct(int state, ByteBuffer buffer, int index, int limit) {
            if (((index | limit) | (buffer.limit() - limit)) < 0) goto L65;
            long address = UnsafeUtil.addressOffset(buffer) + ((long) index);
            long addressLimit = ((long) (limit - index)) + address;
            if (state == 0) goto L63;
            if (address < addressLimit) goto L9;
            return state;
        L9:
            int byte1 = (byte) state;
            if (byte1 >= (-32)) goto L19;
            if (byte1 < (-62)) goto L17;
            long address2 = 1 + address;
            if (UnsafeUtil.getByte(address) > (-65)) goto L17;
            address = address2;
        L17:
            return -1;
        L19:
            if (byte1 >= (-16)) goto L39;
            int byte2 = (byte) (~(state >> 8));
            if (byte2 != 0) goto L27;
            long address3 = address + 1;
            byte2 = UnsafeUtil.getByte(address);
            if (address3 >= addressLimit) goto L25;
            address = address3;
            goto L27
        L25:
            return Utf8.access$000(byte1, byte2);
        L27:
            if (byte2 <= (-65)) goto L29;
        L38:
            return -1;
        L29:
            if (byte1 != (-32)) goto L32;
            if (byte2 < (-96)) goto L38;
        L32:
            if (byte1 != (-19)) goto L34;
            if (byte2 >= (-96)) goto L38;
        L34:
            long address4 = 1 + address;
            if (UnsafeUtil.getByte(address) > (-65)) goto L38;
            address = address4;
            goto L63
        L39:
            int byte3 = (byte) (~(state >> 8));
            int byte4 = 0;
            if (byte3 != 0) goto L46;
            long address5 = address + 1;
            byte3 = UnsafeUtil.getByte(address);
            if (address5 >= addressLimit) goto L44;
            address = address5;
        L47:
            if (byte4 != 0) goto L53;
            long address6 = address + 1;
            byte4 = UnsafeUtil.getByte(address);
            if (address6 >= addressLimit) goto L51;
            address = address6;
            goto L53
        L51:
            return Utf8.access$100(byte1, byte3, byte4);
        L53:
            if (byte3 <= (-65)) goto L55;
        L61:
            return -1;
        L55:
            if ((((byte1 << 28) + (byte3 + 112)) >> 30) != 0) goto L61;
            if (byte4 > (-65)) goto L61;
            long address7 = 1 + address;
            if (UnsafeUtil.getByte(address) > (-65)) goto L61;
            address = address7;
            goto L63
        L44:
            return Utf8.access$000(byte1, byte3);
        L46:
            byte4 = (byte) (state >> 16);
        L63:
            return partialIsValidUtf8(address, (int) (addressLimit - address));
        L65:
            throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", new Object[]{Integer.valueOf(buffer.limit()), Integer.valueOf(index), Integer.valueOf(limit)}));
        }

        @Override // com.bytedance.location.protobuf.Utf8.Processor
        String decodeUtf8(byte[] bytes, int index, int size) throws InvalidProtocolBufferException {
            String s = new String(bytes, index, size, Internal.UTF_8);
            if (s.contains("�") == true) goto L6;
            return s;
        L6:
            if (Arrays.equals(s.getBytes(Internal.UTF_8), Arrays.copyOfRange(bytes, index, index + size)) == false) goto L9;
            return s;
        L9:
            throw InvalidProtocolBufferException.invalidUtf8();
        }

        @Override // com.bytedance.location.protobuf.Utf8.Processor
        String decodeUtf8Direct(ByteBuffer buffer, int index, int size) throws InvalidProtocolBufferException {
            if (((index | size) | ((buffer.limit() - index) - size)) < 0) goto L47;
            long address = UnsafeUtil.addressOffset(buffer) + ((long) index);
            long addressLimit = ((long) size) + address;
            char[] resultArr = new char[size];
            int resultPos = 0;
        L6:
            if (address >= addressLimit) goto L11;
            byte b = UnsafeUtil.getByte(address);
            if (DecodeUtil.access$400(b) == false) goto L11;
            address = address + 1;
            DecodeUtil.access$500(b, resultArr, resultPos);
            resultPos = resultPos + 1;
        L11:
            int resultPos2 = resultPos;
        L13:
            if (address >= addressLimit) goto L45;
            long address2 = address + 1;
            byte byte1 = UnsafeUtil.getByte(address);
            if (DecodeUtil.access$400(byte1) == true) goto L16;
            if (DecodeUtil.access$600(byte1) == true) goto L27;
            if (DecodeUtil.access$800(byte1) == true) goto L34;
            if (address2 >= (addressLimit - 2)) goto L43;
            long address3 = address2 + 1;
            long address4 = address3 + 1;
            DecodeUtil.access$1000(byte1, UnsafeUtil.getByte(address2), UnsafeUtil.getByte(address3), UnsafeUtil.getByte(address4), resultArr, resultPos2);
            resultPos2 = (resultPos2 + 1) + 1;
            address = address4 + 1;
            goto L13
        L43:
            throw InvalidProtocolBufferException.invalidUtf8();
        L34:
            if (address2 >= (addressLimit - 1)) goto L37;
            long address5 = address2 + 1;
            long address6 = address5 + 1;
            DecodeUtil.access$900(byte1, UnsafeUtil.getByte(address2), UnsafeUtil.getByte(address5), resultArr, resultPos2);
            resultPos2 = resultPos2 + 1;
            address = address6;
            goto L13
        L37:
            throw InvalidProtocolBufferException.invalidUtf8();
        L27:
            if (address2 >= addressLimit) goto L30;
            address = address2 + 1;
            DecodeUtil.access$700(byte1, UnsafeUtil.getByte(address2), resultArr, resultPos2);
            resultPos2 = resultPos2 + 1;
            goto L13
        L30:
            throw InvalidProtocolBufferException.invalidUtf8();
        L16:
            int resultPos3 = resultPos2 + 1;
            DecodeUtil.access$500(byte1, resultArr, resultPos2);
        L18:
            if (address2 >= addressLimit) goto L23;
            byte b2 = UnsafeUtil.getByte(address2);
            if (DecodeUtil.access$400(b2) == false) goto L23;
            address2 = address2 + 1;
            DecodeUtil.access$500(b2, resultArr, resultPos3);
            resultPos3 = resultPos3 + 1;
        L23:
            resultPos2 = resultPos3;
            address = address2;
            goto L13
        L45:
            return new String(resultArr, 0, resultPos2);
        L47:
            throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", new Object[]{Integer.valueOf(buffer.limit()), Integer.valueOf(index), Integer.valueOf(size)}));
        }

        @Override // com.bytedance.location.protobuf.Utf8.Processor
        int encodeUtf8(CharSequence in, byte[] out, int offset, int length) {
            long outIx = offset;
            long outLimit = ((long) length) + outIx;
            int inLimit = in.length();
            if (inLimit > length) goto L56;
            if ((out.length - length) < offset) goto L56;
            int inIx = 0;
        L7:
            char r12 = 128;
            long r13 = 1;
            if (inIx >= inLimit) goto L13;
            char c = in.charAt(inIx);
            if (c >= 128) goto L13;
            UnsafeUtil.putByte(out, outIx, (byte) c);
            inIx = inIx + 1;
            outIx = outIx + 1;
        L13:
            if (inIx == inLimit) goto L15;
        L16:
            if (inIx >= inLimit) goto L54;
            char c2 = in.charAt(inIx);
            if (c2 < r12) goto L20;
        L22:
            long r18 = r13;
            if (c2 >= 2048) goto L28;
            if (outIx > (outLimit - 2)) goto L28;
            long outIx2 = outIx + r18;
            UnsafeUtil.putByte(out, outIx, (byte) ((c2 >>> 6) | 960));
            outIx = outIx2 + r18;
            UnsafeUtil.putByte(out, outIx2, (byte) ((c2 & '?') | 128));
            char r3 = 128;
        L40:
            inIx = inIx + 1;
            r12 = r3;
            r13 = r18;
        L28:
            if (c2 < 55296) goto L31;
            if (57343 < c2) goto L31;
        L34:
            if (outIx > (outLimit - 4)) goto L43;
            if ((inIx + 1) == inLimit) goto L42;
            inIx = inIx + 1;
            char low = in.charAt(inIx);
            if (Character.isSurrogatePair(c2, low) == false) goto L42;
            int codePoint = Character.toCodePoint(c2, low);
            long outIx3 = outIx + r18;
            UnsafeUtil.putByte(out, outIx, (byte) ((codePoint >>> 18) | FrameworkStatsLog.BOOT_TIME_EVENT_ELAPSED_TIME_REPORTED));
            long outIx4 = outIx3 + r18;
            r3 = 128;
            UnsafeUtil.putByte(out, outIx3, (byte) (((codePoint >>> 12) & 63) | 128));
            long outIx5 = outIx4 + r18;
            UnsafeUtil.putByte(out, outIx4, (byte) (((codePoint >>> 6) & 63) | 128));
            outIx = outIx5 + r18;
            UnsafeUtil.putByte(out, outIx5, (byte) ((codePoint & 63) | 128));
        L42:
            throw new UnpairedSurrogateException(inIx - 1, inLimit);
        L43:
            if (55296 > c2) goto L52;
            if (c2 > 57343) goto L52;
            if ((inIx + 1) == inLimit) goto L50;
            if (Character.isSurrogatePair(c2, in.charAt(inIx + 1)) == true) goto L52;
        L50:
            throw new UnpairedSurrogateException(inIx, inLimit);
        L52:
            throw new ArrayIndexOutOfBoundsException("Failed writing " + c2 + " at index " + outIx);
        L31:
            if (outIx > (outLimit - 3)) goto L34;
            long outIx6 = outIx + r18;
            UnsafeUtil.putByte(out, outIx, (byte) ((c2 >>> '\f') | SystemService.PHASE_LOCK_SETTINGS_READY));
            long outIx7 = outIx6 + r18;
            UnsafeUtil.putByte(out, outIx6, (byte) (((c2 >>> 6) & 63) | 128));
            UnsafeUtil.putByte(out, outIx7, (byte) ((c2 & '?') | 128));
            outIx = outIx7 + r18;
            r3 = 128;
            goto L40
        L20:
            if (outIx >= outLimit) goto L22;
            r18 = r13;
            UnsafeUtil.putByte(out, outIx, (byte) c2);
            r3 = r12;
            outIx = outIx + r13;
            goto L40
        L54:
            return (int) outIx;
        L15:
            return (int) outIx;
        L56:
            throw new ArrayIndexOutOfBoundsException("Failed writing " + in.charAt(inLimit - 1) + " at index " + (offset + length));
        }

        @Override // com.bytedance.location.protobuf.Utf8.Processor
        void encodeUtf8Direct(CharSequence in, ByteBuffer out) {
            long address = UnsafeUtil.addressOffset(out);
            long outIx = ((long) out.position()) + address;
            long outLimit = ((long) out.limit()) + address;
            int inLimit = in.length();
            if (inLimit > (outLimit - outIx)) goto L54;
            int inIx = 0;
        L5:
            int r12 = 128;
            long r13 = 1;
            if (inIx >= inLimit) goto L11;
            char c = in.charAt(inIx);
            if (c >= 128) goto L11;
            UnsafeUtil.putByte(outIx, (byte) c);
            inIx = inIx + 1;
            outIx = outIx + 1;
        L11:
            if (inIx != inLimit) goto L14;
            out.position((int) (outIx - address));
            return;
        L14:
            if (inIx >= inLimit) goto L51;
            char c2 = in.charAt(inIx);
            if (c2 < r12) goto L18;
        L20:
            long r18 = r13;
            if (c2 < 2048) goto L23;
        L25:
            long address2 = address;
            if (c2 < 55296) goto L29;
            if (57343 < c2) goto L29;
        L32:
            if (outIx > (outLimit - 4)) goto L41;
            if ((inIx + 1) == inLimit) goto L40;
            inIx = inIx + 1;
            char low = in.charAt(inIx);
            if (Character.isSurrogatePair(c2, low) == false) goto L40;
            int codePoint = Character.toCodePoint(c2, low);
            long outIx2 = outIx + r18;
            UnsafeUtil.putByte(outIx, (byte) ((codePoint >>> 18) | FrameworkStatsLog.BOOT_TIME_EVENT_ELAPSED_TIME_REPORTED));
            long outIx3 = outIx2 + r18;
            int r14 = (codePoint >>> 12) & 63;
            int codePoint2 = 128;
            UnsafeUtil.putByte(outIx2, (byte) (r14 | 128));
            long outIx4 = outIx3 + r18;
            UnsafeUtil.putByte(outIx3, (byte) (((codePoint >>> 6) & 63) | 128));
            outIx = outIx4 + r18;
            UnsafeUtil.putByte(outIx4, (byte) ((codePoint & 63) | 128));
        L38:
            inIx = inIx + 1;
            r12 = codePoint2;
            r13 = r18;
            address = address2;
        L40:
            throw new UnpairedSurrogateException(inIx - 1, inLimit);
        L41:
            if (55296 > c2) goto L50;
            if (c2 > 57343) goto L50;
            if ((inIx + 1) == inLimit) goto L48;
            if (Character.isSurrogatePair(c2, in.charAt(inIx + 1)) == true) goto L50;
        L48:
            throw new UnpairedSurrogateException(inIx, inLimit);
        L50:
            throw new ArrayIndexOutOfBoundsException("Failed writing " + c2 + " at index " + outIx);
        L29:
            if (outIx > (outLimit - 3)) goto L32;
            long outIx5 = outIx + r18;
            UnsafeUtil.putByte(outIx, (byte) ((c2 >>> '\f') | SystemService.PHASE_LOCK_SETTINGS_READY));
            long outIx6 = outIx5 + r18;
            UnsafeUtil.putByte(outIx5, (byte) (((c2 >>> 6) & 63) | 128));
            UnsafeUtil.putByte(outIx6, (byte) ((c2 & '?') | 128));
            outIx = outIx6 + r18;
            codePoint2 = 128;
            goto L38
        L23:
            if (outIx > (outLimit - 2)) goto L25;
            long outIx7 = outIx + r18;
            UnsafeUtil.putByte(outIx, (byte) ((c2 >>> 6) | 960));
            outIx = outIx7 + r18;
            address2 = address;
            UnsafeUtil.putByte(outIx7, (byte) ((c2 & '?') | 128));
            codePoint2 = 128;
            goto L38
        L18:
            if (outIx >= outLimit) goto L20;
            r18 = r13;
            UnsafeUtil.putByte(outIx, (byte) c2);
            address2 = address;
            codePoint2 = r12;
            outIx = outIx + r13;
            goto L38
        L51:
            out.position((int) (outIx - address));
            return;
        L54:
            throw new ArrayIndexOutOfBoundsException("Failed writing " + in.charAt(inLimit - 1) + " at index " + out.limit());
        }

        private static int unsafeEstimateConsecutiveAscii(byte[] bytes, long offset, int maxChars) {
            if (maxChars >= 16) goto L6;
            return 0;
        L6:
            int unaligned = 8 - (((int) offset) & 7);
            int i = 0;
        L8:
            if (i >= unaligned) goto L14;
            long offset2 = 1 + offset;
            if (UnsafeUtil.getByte(bytes, offset) < 0) goto L11;
            i = i + 1;
            offset = offset2;
            goto L8
        L11:
            return i;
        L14:
            if ((i + 8) > maxChars) goto L19;
            if ((UnsafeUtil.getLong(bytes, UnsafeUtil.BYTE_ARRAY_BASE_OFFSET + offset) & Utf8.ASCII_MASK_LONG) != 0) goto L19;
            offset = offset + 8;
            i = i + 8;
        L19:
            if (i >= maxChars) goto L24;
            long offset3 = offset + 1;
            if (UnsafeUtil.getByte(bytes, offset) < 0) goto L22;
            i = i + 1;
            offset = offset3;
            goto L19
        L22:
            return i;
        L24:
            return maxChars;
        }

        private static int unsafeEstimateConsecutiveAscii(long address, int maxChars) {
            if (maxChars >= 16) goto L6;
            return 0;
        L6:
            int unaligned = (int) ((-address) & 7);
            int j = unaligned;
        L7:
            if (j <= 0) goto L13;
            long address2 = 1 + address;
            if (UnsafeUtil.getByte(address) < 0) goto L11;
            j = j - 1;
            address = address2;
            goto L7
        L11:
            return unaligned - j;
        L13:
            int remaining = maxChars - unaligned;
        L15:
            if (remaining < 8) goto L20;
            if ((UnsafeUtil.getLong(address) & Utf8.ASCII_MASK_LONG) != 0) goto L20;
            address = address + 8;
            remaining = remaining - 8;
        L20:
            return maxChars - remaining;
        }

        private static int partialIsValidUtf8(byte[] bytes, long offset, int remaining) {
            int skipped = unsafeEstimateConsecutiveAscii(bytes, offset, remaining);
            int remaining2 = remaining - skipped;
            long offset2 = offset + ((long) skipped);
        L3:
            int byte1 = 0;
        L5:
            if (remaining2 <= 0) goto L10;
            long offset3 = offset2 + 1;
            int r12 = UnsafeUtil.getByte(bytes, offset2);
            byte1 = r12;
            if (r12 < 0) goto L9;
            remaining2 = remaining2 - 1;
            offset2 = offset3;
            goto L5
        L9:
            offset2 = offset3;
        L10:
            if (remaining2 == 0) goto L11;
            int remaining3 = remaining2 - 1;
            if (byte1 < (-32)) goto L15;
            if (byte1 < (-16)) goto L27;
            if (remaining3 < 3) goto L46;
            remaining2 = remaining3 - 3;
            long offset4 = offset2 + 1;
            int byte2 = UnsafeUtil.getByte(bytes, offset2);
            if (byte2 > (-65)) goto L59;
            if ((((byte1 << 28) + (byte2 + 112)) >> 30) != 0) goto L59;
            long offset5 = offset4 + 1;
            if (UnsafeUtil.getByte(bytes, offset4) > (-65)) goto L59;
            long offset6 = offset5 + 1;
            if (UnsafeUtil.getByte(bytes, offset5) > (-65)) goto L59;
            offset2 = offset6;
        L59:
            return -1;
        L46:
            return unsafeIncompleteStateFor(bytes, byte1, offset2, remaining3);
        L27:
            if (remaining3 < 2) goto L29;
            remaining2 = remaining3 - 2;
            long offset7 = offset2 + 1;
            int byte3 = UnsafeUtil.getByte(bytes, offset2);
            if (byte3 > (-65)) goto L42;
            if (byte1 != (-32)) goto L36;
            if (byte3 < (-96)) goto L42;
        L36:
            if (byte1 != (-19)) goto L38;
            if (byte3 >= (-96)) goto L42;
        L38:
            long offset8 = 1 + offset7;
            if (UnsafeUtil.getByte(bytes, offset7) > (-65)) goto L42;
            offset2 = offset8;
        L42:
            return -1;
        L29:
            return unsafeIncompleteStateFor(bytes, byte1, offset2, remaining3);
        L15:
            if (remaining3 == 0) goto L16;
            remaining2 = remaining3 - 1;
            if (byte1 < (-62)) goto L23;
            long offset9 = 1 + offset2;
            if (UnsafeUtil.getByte(bytes, offset2) > (-65)) goto L23;
            offset2 = offset9;
        L23:
            return -1;
        L16:
            return byte1;
        L11:
            return 0;
        }

        private static int partialIsValidUtf8(long address, int remaining) {
            int skipped = unsafeEstimateConsecutiveAscii(address, remaining);
            long address2 = address + ((long) skipped);
            int remaining2 = remaining - skipped;
        L3:
            int byte1 = 0;
        L5:
            if (remaining2 <= 0) goto L10;
            long address3 = address2 + 1;
            int r11 = UnsafeUtil.getByte(address2);
            byte1 = r11;
            if (r11 < 0) goto L9;
            remaining2 = remaining2 - 1;
            address2 = address3;
            goto L5
        L9:
            address2 = address3;
        L10:
            if (remaining2 == 0) goto L11;
            int remaining3 = remaining2 - 1;
            if (byte1 < (-32)) goto L15;
            if (byte1 < (-16)) goto L27;
            if (remaining3 < 3) goto L46;
            remaining2 = remaining3 - 3;
            long address4 = address2 + 1;
            byte byte2 = UnsafeUtil.getByte(address2);
            if (byte2 > (-65)) goto L59;
            if ((((byte1 << 28) + (byte2 + 112)) >> 30) != 0) goto L59;
            long address5 = address4 + 1;
            if (UnsafeUtil.getByte(address4) > (-65)) goto L59;
            long address6 = address5 + 1;
            if (UnsafeUtil.getByte(address5) > (-65)) goto L59;
            address2 = address6;
        L59:
            return -1;
        L46:
            return unsafeIncompleteStateFor(address2, byte1, remaining3);
        L27:
            if (remaining3 < 2) goto L29;
            remaining2 = remaining3 - 2;
            long address7 = address2 + 1;
            byte byte3 = UnsafeUtil.getByte(address2);
            if (byte3 > (-65)) goto L42;
            if (byte1 != (-32)) goto L36;
            if (byte3 < (-96)) goto L42;
        L36:
            if (byte1 != (-19)) goto L38;
            if (byte3 >= (-96)) goto L42;
        L38:
            long address8 = 1 + address7;
            if (UnsafeUtil.getByte(address7) > (-65)) goto L42;
            address2 = address8;
        L42:
            return -1;
        L29:
            return unsafeIncompleteStateFor(address2, byte1, remaining3);
        L15:
            if (remaining3 == 0) goto L16;
            remaining2 = remaining3 - 1;
            if (byte1 < (-62)) goto L23;
            long address9 = 1 + address2;
            if (UnsafeUtil.getByte(address2) > (-65)) goto L23;
            address2 = address9;
        L23:
            return -1;
        L16:
            return byte1;
        L11:
            return 0;
        }

        private static int unsafeIncompleteStateFor(byte[] bytes, int byte1, long offset, int remaining) {
            switch(remaining) {
                case 0: goto L10;
                case 1: goto L8;
                case 2: goto L6;
                default: goto L4;
            };
        L4:
            throw new AssertionError();
        L6:
            return Utf8.access$100(byte1, UnsafeUtil.getByte(bytes, offset), UnsafeUtil.getByte(bytes, 1 + offset));
        L8:
            return Utf8.access$000(byte1, UnsafeUtil.getByte(bytes, offset));
        L10:
            return Utf8.access$1200(byte1);
        }

        private static int unsafeIncompleteStateFor(long address, int byte1, int remaining) {
            switch(remaining) {
                case 0: goto L10;
                case 1: goto L8;
                case 2: goto L6;
                default: goto L4;
            };
        L4:
            throw new AssertionError();
        L6:
            return Utf8.access$100(byte1, UnsafeUtil.getByte(address), UnsafeUtil.getByte(1 + address));
        L8:
            return Utf8.access$000(byte1, UnsafeUtil.getByte(address));
        L10:
            return Utf8.access$1200(byte1);
        }
    }

    static /* synthetic */ int access$000(int x0, int x1) {
        return incompleteStateFor(x0, x1);
    }

    static /* synthetic */ int access$100(int x0, int x1, int x2) {
        return incompleteStateFor(x0, x1, x2);
    }

    static /* synthetic */ int access$1100(byte[] x0, int x1, int x2) {
        return incompleteStateFor(x0, x1, x2);
    }

    static /* synthetic */ int access$1200(int x0) {
        return incompleteStateFor(x0);
    }

    static /* synthetic */ int access$200(ByteBuffer x0, int x1, int x2) {
        return estimateConsecutiveAscii(x0, x1, x2);
    }

    static /* synthetic */ int access$300(ByteBuffer x0, int x1, int x2, int x3) {
        return incompleteStateFor(x0, x1, x2, x3);
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

    static boolean isValidUtf8(byte[] bytes) {
        return processor.isValidUtf8(bytes, 0, bytes.length);
    }

    static boolean isValidUtf8(byte[] bytes, int index, int limit) {
        return processor.isValidUtf8(bytes, index, limit);
    }

    static int partialIsValidUtf8(int state, byte[] bytes, int index, int limit) {
        return processor.partialIsValidUtf8(state, bytes, index, limit);
    }

    private static int incompleteStateFor(int byte1) {
        if (byte1 <= (-12)) goto L6;
        return -1;
    L6:
        return byte1;
    }

    private static int incompleteStateFor(int byte1, int byte2) {
        if (byte1 <= (-12)) goto L5;
    L8:
        return -1;
    L5:
        if (byte2 > (-65)) goto L8;
        return (byte2 << 8) ^ byte1;
    }

    private static int incompleteStateFor(int byte1, int byte2, int byte3) {
        if (byte1 <= (-12)) goto L5;
    L9:
        return -1;
    L5:
        if (byte2 > (-65)) goto L9;
        if (byte3 > (-65)) goto L9;
        return ((byte2 << 8) ^ byte1) ^ (byte3 << 16);
    }

    private static int incompleteStateFor(byte[] bytes, int index, int limit) {
        int byte1 = bytes[index - 1];
        switch((limit - index)) {
            case 0: goto L11;
            case 1: goto L9;
            case 2: goto L7;
            default: goto L5;
        };
    L5:
        throw new AssertionError();
    L7:
        return incompleteStateFor(byte1, bytes[index], bytes[index + 1]);
    L9:
        return incompleteStateFor(byte1, bytes[index]);
    L11:
        return incompleteStateFor(byte1);
    }

    private static int incompleteStateFor(ByteBuffer buffer, int byte1, int index, int remaining) {
        switch(remaining) {
            case 0: goto L10;
            case 1: goto L8;
            case 2: goto L6;
            default: goto L4;
        };
    L4:
        throw new AssertionError();
    L6:
        return incompleteStateFor(byte1, buffer.get(index), buffer.get(index + 1));
    L8:
        return incompleteStateFor(byte1, buffer.get(index));
    L10:
        return incompleteStateFor(byte1);
    }

    static int encodedLength(CharSequence sequence) {
        int utf16Length = sequence.length();
        int utf8Length = utf16Length;
        int i = 0;
    L3:
        if (i >= utf16Length) goto L7;
        if (sequence.charAt(i) >= 128) goto L7;
        i = i + 1;
    L7:
        if (i >= utf16Length) goto L12;
        char c = sequence.charAt(i);
        if (c >= 2048) goto L11;
        utf8Length = utf8Length + ((127 - c) >>> 31);
        i = i + 1;
        goto L7
    L11:
        utf8Length = utf8Length + encodedLengthGeneral(sequence, i);
    L12:
        if (utf8Length < utf16Length) goto L15;
        return utf8Length;
    L15:
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) utf8Length) + 4294967296L));
    }

    private static int encodedLengthGeneral(CharSequence sequence, int start) {
        int utf16Length = sequence.length();
        int utf8Length = 0;
        int i = start;
    L3:
        if (i >= utf16Length) goto L18;
        char c = sequence.charAt(i);
        if (c >= 2048) goto L7;
        utf8Length = utf8Length + ((127 - c) >>> 31);
    L16:
        i = i + 1;
        goto L3
    L7:
        utf8Length = utf8Length + 2;
        if (55296 > c) goto L16;
        if (c > 57343) goto L16;
        int cp = Character.codePointAt(sequence, i);
        if (cp < 65536) goto L15;
        i = i + 1;
        goto L16
    L15:
        throw new UnpairedSurrogateException(i, utf16Length);
    L18:
        return utf8Length;
    }

    static int encode(CharSequence in, byte[] out, int offset, int length) {
        return processor.encodeUtf8(in, out, offset, length);
    }

    static boolean isValidUtf8(ByteBuffer buffer) {
        return processor.isValidUtf8(buffer, buffer.position(), buffer.remaining());
    }

    static int partialIsValidUtf8(int state, ByteBuffer buffer, int index, int limit) {
        return processor.partialIsValidUtf8(state, buffer, index, limit);
    }

    static String decodeUtf8(ByteBuffer buffer, int index, int size) throws InvalidProtocolBufferException {
        return processor.decodeUtf8(buffer, index, size);
    }

    static String decodeUtf8(byte[] bytes, int index, int size) throws InvalidProtocolBufferException {
        return processor.decodeUtf8(bytes, index, size);
    }

    static void encodeUtf8(CharSequence in, ByteBuffer out) {
        processor.encodeUtf8(in, out);
    }

    private static int estimateConsecutiveAscii(ByteBuffer buffer, int index, int limit) {
        int i = index;
        int lim = limit - 7;
    L3:
        if (i >= lim) goto L8;
        if ((buffer.getLong(i) & ASCII_MASK_LONG) != 0) goto L8;
        i = i + 8;
    L8:
        return i - index;
    }

    private Utf8() {
    }
}
