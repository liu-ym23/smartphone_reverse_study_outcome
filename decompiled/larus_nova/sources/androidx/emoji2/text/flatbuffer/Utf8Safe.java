package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes17.dex */
public final class Utf8Safe extends Utf8 {

    public static class UnpairedSurrogateException extends IllegalArgumentException {
        public UnpairedSurrogateException(int r100, int r101) {
            super("Unpaired surrogate at index " + r100 + " of " + r101);
        }
    }

    public Utf8Safe() {
    }

    private static int computeEncodedLength(CharSequence r100) {
        int r101 = r100.length();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L7;
        if (r100.charAt(r102) >= 128) goto L7;
        r102 = r102 + 1;
    L7:
        int r103 = r101;
    L8:
        if (r102 >= r101) goto L13;
        char r104 = r100.charAt(r102);
        if (r104 >= 2048) goto L12;
        r103 = r103 + ((127 - r104) >>> 31);
        r102 = r102 + 1;
        goto L8
    L12:
        r103 = r103 + encodedLengthGeneral(r100, r102);
    L13:
        if (r103 < r101) goto L16;
        return r103;
    L16:
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) r103) + 4294967296L));
    }

    @Override // androidx.emoji2.text.flatbuffer.Utf8
    public int encodedLength(CharSequence r100) {
        return computeEncodedLength(r100);
    }

    private static void encodeUtf8Buffer(CharSequence r100, ByteBuffer r101) {
        int r102 = r100.length();
        int r103 = r101.position();
        int r104 = 0;
    L4:
        if (r104 >= r102) goto L8;
        char r105 = r100.charAt(r104);     // Catch: IndexOutOfBoundsException -> L55
        if (r105 >= 128) goto L8;
        r101.put(r103 + r104, (byte) r105);     // Catch: IndexOutOfBoundsException -> L55
        r104 = r104 + 1;     // Catch: IndexOutOfBoundsException -> L55
    L53:
        throw new ArrayIndexOutOfBoundsException("Failed writing " + r100.charAt(r104) + " at index " + (r101.position() + Math.max(r104, (r103 - r101.position()) + 1)));
    L8:
        if (r104 != r102) goto L11;
        r101.position(r103 + r104);     // Catch: IndexOutOfBoundsException -> L55
        return;
    L11:
        r103 = r103 + r104;     // Catch: IndexOutOfBoundsException -> L55
    L12:
        if (r104 >= r102) goto L50;
        char r106 = r100.charAt(r104);     // Catch: IndexOutOfBoundsException -> L55
        if (r106 >= 128) goto L18;
        r101.put(r103, (byte) r106);     // Catch: IndexOutOfBoundsException -> L55
    L49:
        r104 = r104 + 1;     // Catch: IndexOutOfBoundsException -> L55
        r103 = r103 + 1;     // Catch: IndexOutOfBoundsException -> L55
        goto L12
    L18:
        if (r106 >= 2048) goto L24;
        int r107 = r103 + 1;
        r101.put(r103, (byte) ((r106 >>> 6) | 192));     // Catch: IndexOutOfBoundsException -> L22
        r101.put(r107, (byte) ((r106 & '?') | 128));     // Catch: IndexOutOfBoundsException -> L22
        r103 = r107;
    L22:
        r103 = r107;
        goto L53
    L24:
        if (r106 >= 55296) goto L26;
    L45:
        int r108 = r103 + 1;
        r101.put(r103, (byte) ((r106 >>> '\f') | 224));     // Catch: IndexOutOfBoundsException -> L22
        r103 = r108 + 1;
        r101.put(r108, (byte) (((r106 >>> 6) & 63) | 128));     // Catch: IndexOutOfBoundsException -> L55
        r101.put(r103, (byte) ((r106 & '?') | 128));     // Catch: IndexOutOfBoundsException -> L55
        goto L49
    L26:
        if (57343 < r106) goto L45;
        int r109 = r104 + 1;
        if (r109 == r102) goto L44;
        char r110 = r100.charAt(r109);     // Catch: IndexOutOfBoundsException -> L54
        if (Character.isSurrogatePair(r106, r110) == false) goto L41;
        int r111 = Character.toCodePoint(r106, r110);     // Catch: IndexOutOfBoundsException -> L54
        int r112 = r103 + 1;
        r101.put(r103, (byte) ((r111 >>> 18) | 240));     // Catch: IndexOutOfBoundsException -> L40
        r103 = r112 + 1;
        r101.put(r112, (byte) (((r111 >>> 12) & 63) | 128));     // Catch: IndexOutOfBoundsException -> L54
        r112 = r103 + 1;
        r101.put(r103, (byte) (((r111 >>> 6) & 63) | 128));     // Catch: IndexOutOfBoundsException -> L40
        r101.put(r112, (byte) ((r111 & 63) | 128));     // Catch: IndexOutOfBoundsException -> L40
        r103 = r112;
        r104 = r109;
    L40:
        r103 = r112;
        goto L42
    L41:
        r104 = r109;
    L42:
        r104 = r109;
    L44:
        throw new UnpairedSurrogateException(r104, r102);     // Catch: IndexOutOfBoundsException -> L55
    L50:
        r101.position(r103);     // Catch: IndexOutOfBoundsException -> L55
    }

    private static int encodedLengthGeneral(CharSequence r100, int r101) {
        int r102 = r100.length();
        int r103 = 0;
    L3:
        if (r101 >= r102) goto L17;
        char r104 = r100.charAt(r101);
        if (r104 >= 2048) goto L7;
        r103 = r103 + ((127 - r104) >>> 31);
    L16:
        r101 = r101 + 1;
        goto L3
    L7:
        r103 = r103 + 2;
        if (55296 > r104) goto L16;
        if (r104 > 57343) goto L16;
        if (Character.codePointAt(r100, r101) < 65536) goto L15;
        r101 = r101 + 1;
        goto L16
    L15:
        throw new UnpairedSurrogateException(r101, r102);
    L17:
        return r103;
    }

    @Override // androidx.emoji2.text.flatbuffer.Utf8
    public void encodeUtf8(CharSequence r100, ByteBuffer r101) {
        if (r101.hasArray() == false) goto L5;
        int r102 = r101.arrayOffset();
        r101.position(encodeUtf8Array(r100, r101.array(), r101.position() + r102, r101.remaining()) - r102);
        return;
    L5:
        encodeUtf8Buffer(r100, r101);
    }

    public static String decodeUtf8Array(byte[] r110, int r111, int r112) {
        if (((r111 | r112) | ((r110.length - r111) - r112)) < 0) goto L42;
        int r100 = r111 + r112;
        char[] r113 = new char[r112];
        int r101 = 0;
    L5:
        if (r111 >= r100) goto L10;
        byte r102 = r110[r111];
        if (Utf8.DecodeUtil.isOneByte(r102) == false) goto L10;
        r111 = r111 + 1;
        Utf8.DecodeUtil.handleOneByte(r102, r113, r101);
        r101 = r101 + 1;
    L10:
        int r103 = r101;
    L11:
        if (r111 >= r100) goto L40;
        int r104 = r111 + 1;
        byte r114 = r110[r111];
        if (Utf8.DecodeUtil.isOneByte(r114) == true) goto L14;
        if (Utf8.DecodeUtil.isTwoBytes(r114) == true) goto L23;
        if (Utf8.DecodeUtil.isThreeBytes(r114) == true) goto L30;
        if (r104 >= (r100 - 2)) goto L38;
        int r105 = r104 + 1;
        byte r106 = r110[r104];
        int r107 = r105 + 1;
        Utf8.DecodeUtil.handleFourBytes(r114, r106, r110[r105], r110[r107], r113, r103);
        r111 = r107 + 1;
        r103 = (r103 + 1) + 1;
        goto L11
    L38:
        throw new IllegalArgumentException("Invalid UTF-8");
    L30:
        if (r104 >= (r100 - 1)) goto L33;
        int r108 = r104 + 1;
        Utf8.DecodeUtil.handleThreeBytes(r114, r110[r104], r110[r108], r113, r103);
        r111 = r108 + 1;
        r103 = r103 + 1;
        goto L11
    L33:
        throw new IllegalArgumentException("Invalid UTF-8");
    L23:
        if (r104 >= r100) goto L26;
        Utf8.DecodeUtil.handleTwoBytes(r114, r110[r104], r113, r103);
        r111 = r104 + 1;
        r103 = r103 + 1;
        goto L11
    L26:
        throw new IllegalArgumentException("Invalid UTF-8");
    L14:
        int r109 = r103 + 1;
        Utf8.DecodeUtil.handleOneByte(r114, r113, r103);
    L15:
        if (r104 >= r100) goto L20;
        byte r115 = r110[r104];
        if (Utf8.DecodeUtil.isOneByte(r115) == false) goto L20;
        r104 = r104 + 1;
        Utf8.DecodeUtil.handleOneByte(r115, r113, r109);
        r109 = r109 + 1;
    L20:
        r111 = r104;
        r103 = r109;
        goto L11
    L40:
        return new String(r113, 0, r103);
    L42:
        throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", new Object[]{Integer.valueOf(r110.length), Integer.valueOf(r111), Integer.valueOf(r112)}));
    }

    public static String decodeUtf8Buffer(ByteBuffer r110, int r111, int r112) {
        if (((r111 | r112) | ((r110.limit() - r111) - r112)) < 0) goto L42;
        int r100 = r111 + r112;
        char[] r113 = new char[r112];
        int r101 = 0;
    L5:
        if (r111 >= r100) goto L10;
        byte r102 = r110.get(r111);
        if (Utf8.DecodeUtil.isOneByte(r102) == false) goto L10;
        r111 = r111 + 1;
        Utf8.DecodeUtil.handleOneByte(r102, r113, r101);
        r101 = r101 + 1;
    L10:
        int r103 = r101;
    L11:
        if (r111 >= r100) goto L40;
        int r104 = r111 + 1;
        byte r114 = r110.get(r111);
        if (Utf8.DecodeUtil.isOneByte(r114) == true) goto L14;
        if (Utf8.DecodeUtil.isTwoBytes(r114) == true) goto L23;
        if (Utf8.DecodeUtil.isThreeBytes(r114) == true) goto L30;
        if (r104 >= (r100 - 2)) goto L38;
        int r105 = r104 + 1;
        byte r106 = r110.get(r104);
        int r107 = r105 + 1;
        Utf8.DecodeUtil.handleFourBytes(r114, r106, r110.get(r105), r110.get(r107), r113, r103);
        r111 = r107 + 1;
        r103 = (r103 + 1) + 1;
        goto L11
    L38:
        throw new IllegalArgumentException("Invalid UTF-8");
    L30:
        if (r104 >= (r100 - 1)) goto L33;
        int r108 = r104 + 1;
        Utf8.DecodeUtil.handleThreeBytes(r114, r110.get(r104), r110.get(r108), r113, r103);
        r111 = r108 + 1;
        r103 = r103 + 1;
        goto L11
    L33:
        throw new IllegalArgumentException("Invalid UTF-8");
    L23:
        if (r104 >= r100) goto L26;
        Utf8.DecodeUtil.handleTwoBytes(r114, r110.get(r104), r113, r103);
        r111 = r104 + 1;
        r103 = r103 + 1;
        goto L11
    L26:
        throw new IllegalArgumentException("Invalid UTF-8");
    L14:
        int r109 = r103 + 1;
        Utf8.DecodeUtil.handleOneByte(r114, r113, r103);
    L15:
        if (r104 >= r100) goto L20;
        byte r115 = r110.get(r104);
        if (Utf8.DecodeUtil.isOneByte(r115) == false) goto L20;
        r104 = r104 + 1;
        Utf8.DecodeUtil.handleOneByte(r115, r113, r109);
        r109 = r109 + 1;
    L20:
        r111 = r104;
        r103 = r109;
        goto L11
    L40:
        return new String(r113, 0, r103);
    L42:
        throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", new Object[]{Integer.valueOf(r110.limit()), Integer.valueOf(r111), Integer.valueOf(r112)}));
    }

    @Override // androidx.emoji2.text.flatbuffer.Utf8
    public String decodeUtf8(ByteBuffer r100, int r101, int r102) throws IllegalArgumentException {
        if (r100.hasArray() == false) goto L7;
        return decodeUtf8Array(r100.array(), r100.arrayOffset() + r101, r102);
    L7:
        return decodeUtf8Buffer(r100, r101, r102);
    }

    private static int encodeUtf8Array(CharSequence r100, byte[] r101, int r102, int r110) {
        int r103 = r100.length();
        int r111 = r110 + r102;
        int r104 = 0;
    L4:
        if (r104 >= r103) goto L10;
        int r105 = r104 + r102;
        if (r105 >= r111) goto L10;
        char r106 = r100.charAt(r104);
        if (r106 >= 128) goto L10;
        r101[r105] = (byte) r106;
        r104 = r104 + 1;
    L10:
        if (r104 == r103) goto L12;
        int r107 = r102 + r104;
    L14:
        if (r104 >= r103) goto L52;
        char r108 = r100.charAt(r104);
        if (r108 >= 128) goto L21;
        if (r107 >= r111) goto L21;
        int r109 = r107 + 1;
        r101[r107] = (byte) r108;
    L19:
        r107 = r109;
    L38:
        r104 = r104 + 1;
    L21:
        if (r108 >= 2048) goto L26;
        if (r107 > (r111 - 2)) goto L26;
        int r112 = r107 + 1;
        r101[r107] = (byte) ((r108 >>> 6) | 960);
        r107 = r112 + 1;
        r101[r112] = (byte) ((r108 & '?') | 128);
    L26:
        if (r108 < 55296) goto L29;
        if (57343 < r108) goto L29;
    L32:
        if (r107 > (r111 - 4)) goto L42;
        int r113 = r104 + 1;
        if (r113 == r100.length()) goto L41;
        char r114 = r100.charAt(r113);
        if (Character.isSurrogatePair(r108, r114) == false) goto L39;
        int r115 = Character.toCodePoint(r108, r114);
        int r116 = r107 + 1;
        r101[r107] = (byte) ((r115 >>> 18) | 240);
        int r117 = r116 + 1;
        r101[r116] = (byte) (((r115 >>> 12) & 63) | 128);
        int r118 = r117 + 1;
        r101[r117] = (byte) (((r115 >>> 6) & 63) | 128);
        r107 = r118 + 1;
        r101[r118] = (byte) ((r115 & 63) | 128);
        r104 = r113;
        goto L38
    L39:
        r104 = r113;
    L41:
        throw new UnpairedSurrogateException(r104 - 1, r103);
    L42:
        if (55296 > r108) goto L51;
        if (r108 > 57343) goto L51;
        int r119 = r104 + 1;
        if (r119 == r100.length()) goto L49;
        if (Character.isSurrogatePair(r108, r100.charAt(r119)) == true) goto L51;
    L49:
        throw new UnpairedSurrogateException(r104, r103);
    L51:
        throw new ArrayIndexOutOfBoundsException("Failed writing " + r108 + " at index " + r107);
    L29:
        if (r107 > (r111 - 3)) goto L32;
        int r120 = r107 + 1;
        r101[r107] = (byte) ((r108 >>> '\f') | 480);
        int r121 = r120 + 1;
        r101[r120] = (byte) (((r108 >>> 6) & 63) | 128);
        r109 = r121 + 1;
        r101[r121] = (byte) ((r108 & '?') | 128);
        goto L19
    L52:
        return r107;
    L12:
        return r102 + r103;
    }
}
