package androidx.emoji2.text.flatbuffer;

import com.bytedance.apm.battery.config.BatteryDetectConfig;
import com.obric.oui.sheet.v2.OSheetBaseKt;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class Utf8Safe extends Utf8 {

    static class UnpairedSurrogateException extends IllegalArgumentException {
        UnpairedSurrogateException(int r3, int r4) {
            super("Unpaired surrogate at index " + r3 + " of " + r4);
        }
    }

    public Utf8Safe() {
    }

    private static int computeEncodedLength(CharSequence r5) {
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

    private static int encodedLengthGeneral(CharSequence r4, int r5) {
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

    public static String decodeUtf8Array(byte[] r11, int r12, int r13) {
        if (((r12 | r13) | ((r11.length - r12) - r13)) < 0) goto L42;
        int r0 = r12 + r13;
        char[] r14 = new char[r13];
        int r3 = 0;
    L5:
        if (r12 >= r0) goto L10;
        byte r4 = r11[r12];
        if (Utf8.DecodeUtil.isOneByte(r4) == false) goto L10;
        r12 = r12 + 1;
        Utf8.DecodeUtil.handleOneByte(r4, r14, r3);
        r3 = r3 + 1;
    L10:
        int r8 = r3;
    L11:
        if (r12 >= r0) goto L40;
        int r5 = r12 + 1;
        byte r15 = r11[r12];
        if (Utf8.DecodeUtil.isOneByte(r15) == true) goto L14;
        if (Utf8.DecodeUtil.isTwoBytes(r15) == true) goto L23;
        if (Utf8.DecodeUtil.isThreeBytes(r15) == true) goto L30;
        if (r5 >= (r0 - 2)) goto L38;
        int r6 = r5 + 1;
        byte r7 = r11[r5];
        int r9 = r6 + 1;
        Utf8.DecodeUtil.handleFourBytes(r15, r7, r11[r6], r11[r9], r14, r8);
        r12 = r9 + 1;
        r8 = (r8 + 1) + 1;
        goto L11
    L38:
        throw new IllegalArgumentException("Invalid UTF-8");
    L30:
        if (r5 >= (r0 - 1)) goto L33;
        int r10 = r5 + 1;
        Utf8.DecodeUtil.handleThreeBytes(r15, r11[r5], r11[r10], r14, r8);
        r12 = r10 + 1;
        r8 = r8 + 1;
        goto L11
    L33:
        throw new IllegalArgumentException("Invalid UTF-8");
    L23:
        if (r5 >= r0) goto L26;
        Utf8.DecodeUtil.handleTwoBytes(r15, r11[r5], r14, r8);
        r12 = r5 + 1;
        r8 = r8 + 1;
        goto L11
    L26:
        throw new IllegalArgumentException("Invalid UTF-8");
    L14:
        int r16 = r8 + 1;
        Utf8.DecodeUtil.handleOneByte(r15, r14, r8);
    L15:
        if (r5 >= r0) goto L20;
        byte r17 = r11[r5];
        if (Utf8.DecodeUtil.isOneByte(r17) == false) goto L20;
        r5 = r5 + 1;
        Utf8.DecodeUtil.handleOneByte(r17, r14, r16);
        r16 = r16 + 1;
    L20:
        r12 = r5;
        r8 = r16;
        goto L11
    L40:
        return new String(r14, 0, r8);
    L42:
        throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", new Object[]{Integer.valueOf(r11.length), Integer.valueOf(r12), Integer.valueOf(r13)}));
    }

    public static String decodeUtf8Buffer(ByteBuffer r11, int r12, int r13) {
        if (((r12 | r13) | ((r11.limit() - r12) - r13)) < 0) goto L42;
        int r0 = r12 + r13;
        char[] r14 = new char[r13];
        int r3 = 0;
    L5:
        if (r12 >= r0) goto L10;
        byte r4 = r11.get(r12);
        if (Utf8.DecodeUtil.isOneByte(r4) == false) goto L10;
        r12 = r12 + 1;
        Utf8.DecodeUtil.handleOneByte(r4, r14, r3);
        r3 = r3 + 1;
    L10:
        int r8 = r3;
    L11:
        if (r12 >= r0) goto L40;
        int r5 = r12 + 1;
        byte r15 = r11.get(r12);
        if (Utf8.DecodeUtil.isOneByte(r15) == true) goto L14;
        if (Utf8.DecodeUtil.isTwoBytes(r15) == true) goto L23;
        if (Utf8.DecodeUtil.isThreeBytes(r15) == true) goto L30;
        if (r5 >= (r0 - 2)) goto L38;
        int r6 = r5 + 1;
        byte r7 = r11.get(r5);
        int r9 = r6 + 1;
        Utf8.DecodeUtil.handleFourBytes(r15, r7, r11.get(r6), r11.get(r9), r14, r8);
        r12 = r9 + 1;
        r8 = (r8 + 1) + 1;
        goto L11
    L38:
        throw new IllegalArgumentException("Invalid UTF-8");
    L30:
        if (r5 >= (r0 - 1)) goto L33;
        int r10 = r5 + 1;
        Utf8.DecodeUtil.handleThreeBytes(r15, r11.get(r5), r11.get(r10), r14, r8);
        r12 = r10 + 1;
        r8 = r8 + 1;
        goto L11
    L33:
        throw new IllegalArgumentException("Invalid UTF-8");
    L23:
        if (r5 >= r0) goto L26;
        Utf8.DecodeUtil.handleTwoBytes(r15, r11.get(r5), r14, r8);
        r12 = r5 + 1;
        r8 = r8 + 1;
        goto L11
    L26:
        throw new IllegalArgumentException("Invalid UTF-8");
    L14:
        int r16 = r8 + 1;
        Utf8.DecodeUtil.handleOneByte(r15, r14, r8);
    L15:
        if (r5 >= r0) goto L20;
        byte r17 = r11.get(r5);
        if (Utf8.DecodeUtil.isOneByte(r17) == false) goto L20;
        r5 = r5 + 1;
        Utf8.DecodeUtil.handleOneByte(r17, r14, r16);
        r16 = r16 + 1;
    L20:
        r12 = r5;
        r8 = r16;
        goto L11
    L40:
        return new String(r14, 0, r8);
    L42:
        throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", new Object[]{Integer.valueOf(r11.limit()), Integer.valueOf(r12), Integer.valueOf(r13)}));
    }

    @Override // androidx.emoji2.text.flatbuffer.Utf8
    public int encodedLength(CharSequence r1) {
        return computeEncodedLength(r1);
    }

    @Override // androidx.emoji2.text.flatbuffer.Utf8
    public String decodeUtf8(ByteBuffer r1, int r2, int r3) throws IllegalArgumentException {
        if (r1.hasArray() == false) goto L7;
        return decodeUtf8Array(r1.array(), r1.arrayOffset() + r2, r3);
    L7:
        return decodeUtf8Buffer(r1, r2, r3);
    }

    private static void encodeUtf8Buffer(CharSequence r7, ByteBuffer r8) {
        int r0 = r7.length();
        int r1 = r8.position();
        int r2 = 0;
    L4:
        if (r2 >= r0) goto L8;
        char r4 = r7.charAt(r2);     // Catch: IndexOutOfBoundsException -> L55
        if (r4 >= 128) goto L8;
        r8.put(r1 + r2, (byte) r4);     // Catch: IndexOutOfBoundsException -> L55
        r2 = r2 + 1;     // Catch: IndexOutOfBoundsException -> L55
    L53:
        throw new ArrayIndexOutOfBoundsException("Failed writing " + r7.charAt(r2) + " at index " + (r8.position() + Math.max(r2, (r1 - r8.position()) + 1)));
    L8:
        if (r2 != r0) goto L11;
        r8.position(r1 + r2);     // Catch: IndexOutOfBoundsException -> L55
        return;
    L11:
        r1 = r1 + r2;     // Catch: IndexOutOfBoundsException -> L55
    L12:
        if (r2 >= r0) goto L50;
        char r5 = r7.charAt(r2);     // Catch: IndexOutOfBoundsException -> L55
        if (r5 >= 128) goto L18;
        r8.put(r1, (byte) r5);     // Catch: IndexOutOfBoundsException -> L55
    L49:
        r2 = r2 + 1;     // Catch: IndexOutOfBoundsException -> L55
        r1 = r1 + 1;     // Catch: IndexOutOfBoundsException -> L55
        goto L12
    L18:
        if (r5 >= 2048) goto L24;
        int r6 = r1 + 1;
        r8.put(r1, (byte) ((r5 >>> 6) | 192));     // Catch: IndexOutOfBoundsException -> L22
        r8.put(r6, (byte) ((r5 & '?') | 128));     // Catch: IndexOutOfBoundsException -> L22
        r1 = r6;
    L22:
        r1 = r6;
        goto L53
    L24:
        if (r5 >= 55296) goto L26;
    L45:
        int r9 = r1 + 1;
        r8.put(r1, (byte) ((r5 >>> '\f') | 224));     // Catch: IndexOutOfBoundsException -> L22
        r1 = r9 + 1;
        r8.put(r9, (byte) (((r5 >>> 6) & 63) | 128));     // Catch: IndexOutOfBoundsException -> L55
        r8.put(r1, (byte) ((r5 & '?') | 128));     // Catch: IndexOutOfBoundsException -> L55
        goto L49
    L26:
        if (57343 < r5) goto L45;
        int r10 = r2 + 1;
        if (r10 == r0) goto L44;
        char r3 = r7.charAt(r10);     // Catch: IndexOutOfBoundsException -> L54
        if (Character.isSurrogatePair(r5, r3) == false) goto L41;
        int r11 = Character.toCodePoint(r5, r3);     // Catch: IndexOutOfBoundsException -> L54
        int r12 = r1 + 1;
        r8.put(r1, (byte) ((r11 >>> 18) | BatteryDetectConfig.MAX_TOTAL_LOC_REQUEST_TIME_10_MINS_SECOND));     // Catch: IndexOutOfBoundsException -> L40
        r1 = r12 + 1;
        r8.put(r12, (byte) (((r11 >>> 12) & 63) | 128));     // Catch: IndexOutOfBoundsException -> L54
        r12 = r1 + 1;
        r8.put(r1, (byte) (((r11 >>> 6) & 63) | 128));     // Catch: IndexOutOfBoundsException -> L40
        r8.put(r12, (byte) ((r11 & 63) | 128));     // Catch: IndexOutOfBoundsException -> L40
        r1 = r12;
        r2 = r10;
    L40:
        r1 = r12;
        goto L42
    L41:
        r2 = r10;
    L42:
        r2 = r10;
    L44:
        throw new UnpairedSurrogateException(r2, r0);     // Catch: IndexOutOfBoundsException -> L55
    L50:
        r8.position(r1);     // Catch: IndexOutOfBoundsException -> L55
    }

    private static int encodeUtf8Array(CharSequence r7, byte[] r8, int r9, int r10) {
        int r0 = r7.length();
        int r11 = r10 + r9;
        int r1 = 0;
    L4:
        if (r1 >= r0) goto L10;
        int r3 = r1 + r9;
        if (r3 >= r11) goto L10;
        char r4 = r7.charAt(r1);
        if (r4 >= 128) goto L10;
        r8[r3] = (byte) r4;
        r1 = r1 + 1;
    L10:
        if (r1 == r0) goto L12;
        int r12 = r9 + r1;
    L14:
        if (r1 >= r0) goto L52;
        char r5 = r7.charAt(r1);
        if (r5 >= 128) goto L21;
        if (r12 >= r11) goto L21;
        int r6 = r12 + 1;
        r8[r12] = (byte) r5;
    L19:
        r12 = r6;
    L38:
        r1 = r1 + 1;
    L21:
        if (r5 >= 2048) goto L26;
        if (r12 > (r11 - 2)) goto L26;
        int r13 = r12 + 1;
        r8[r12] = (byte) ((r5 >>> 6) | 960);
        r12 = r13 + 1;
        r8[r13] = (byte) ((r5 & '?') | 128);
    L26:
        if (r5 < 55296) goto L29;
        if (57343 < r5) goto L29;
    L32:
        if (r12 > (r11 - 4)) goto L42;
        int r14 = r1 + 1;
        if (r14 == r7.length()) goto L41;
        char r2 = r7.charAt(r14);
        if (Character.isSurrogatePair(r5, r2) == false) goto L39;
        int r15 = Character.toCodePoint(r5, r2);
        int r16 = r12 + 1;
        r8[r12] = (byte) ((r15 >>> 18) | BatteryDetectConfig.MAX_TOTAL_LOC_REQUEST_TIME_10_MINS_SECOND);
        int r17 = r16 + 1;
        r8[r16] = (byte) (((r15 >>> 12) & 63) | 128);
        int r18 = r17 + 1;
        r8[r17] = (byte) (((r15 >>> 6) & 63) | 128);
        r12 = r18 + 1;
        r8[r18] = (byte) ((r15 & 63) | 128);
        r1 = r14;
        goto L38
    L39:
        r1 = r14;
    L41:
        throw new UnpairedSurrogateException(r1 - 1, r0);
    L42:
        if (55296 > r5) goto L51;
        if (r5 > 57343) goto L51;
        int r19 = r1 + 1;
        if (r19 == r7.length()) goto L49;
        if (Character.isSurrogatePair(r5, r7.charAt(r19)) == true) goto L51;
    L49:
        throw new UnpairedSurrogateException(r1, r0);
    L51:
        throw new ArrayIndexOutOfBoundsException("Failed writing " + r5 + " at index " + r12);
    L29:
        if (r12 > (r11 - 3)) goto L32;
        int r20 = r12 + 1;
        r8[r12] = (byte) ((r5 >>> '\f') | OSheetBaseKt.SHEET_LANDSCAPE_MAX_WIDTH);
        int r21 = r20 + 1;
        r8[r20] = (byte) (((r5 >>> 6) & 63) | 128);
        r6 = r21 + 1;
        r8[r21] = (byte) ((r5 & '?') | 128);
        goto L19
    L52:
        return r12;
    L12:
        return r9 + r0;
    }

    @Override // androidx.emoji2.text.flatbuffer.Utf8
    public void encodeUtf8(CharSequence r4, ByteBuffer r5) {
        if (r5.hasArray() == false) goto L5;
        int r3 = r5.arrayOffset();
        r5.position(encodeUtf8Array(r4, r5.array(), r5.position() + r3, r5.remaining()) - r3);
        return;
    L5:
        encodeUtf8Buffer(r4, r5);
    }
}
