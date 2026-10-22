package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes17.dex */
public abstract class Utf8 {
    private static Utf8 DEFAULT;

    public static class DecodeUtil {
        public DecodeUtil() {
        }

        private static char highSurrogate(int r100) {
            return (char) ((r100 >>> 10) + 55232);
        }

        private static boolean isNotTrailingByte(byte r100) {
            if (r100 <= (-65)) goto L5;
            return true;
        L5:
            return false;
        }

        public static boolean isOneByte(byte r100) {
            if (r100 < 0) goto L4;
            return true;
        L4:
            return false;
        }

        public static boolean isThreeBytes(byte r100) {
            if (r100 >= (-16)) goto L5;
            return true;
        L5:
            return false;
        }

        public static boolean isTwoBytes(byte r100) {
            if (r100 >= (-32)) goto L5;
            return true;
        L5:
            return false;
        }

        private static char lowSurrogate(int r100) {
            return (char) ((r100 & 1023) + 56320);
        }

        private static int trailingByteValue(byte r100) {
            return r100 & 63;
        }

        public static void handleOneByte(byte r100, char[] r101, int r102) {
            r101[r102] = (char) r100;
        }

        public static void handleTwoBytes(byte r100, byte r101, char[] r102, int r103) throws IllegalArgumentException {
            if (r100 < (-62)) goto L11;
            if (isNotTrailingByte(r101) == true) goto L9;
            r102[r103] = (char) (((r100 & 31) << 6) | trailingByteValue(r101));
            return;
        L9:
            throw new IllegalArgumentException("Invalid UTF-8: Illegal trailing byte in 2 bytes utf");
        L11:
            throw new IllegalArgumentException("Invalid UTF-8: Illegal leading byte in 2 bytes utf");
        }

        public static void handleThreeBytes(byte r100, byte r101, byte r102, char[] r103, int r104) throws IllegalArgumentException {
            if (isNotTrailingByte(r101) == true) goto L15;
            if (r100 != (-32)) goto L8;
            if (r101 < (-96)) goto L15;
        L8:
            if (r100 != (-19)) goto L11;
            if (r101 >= (-96)) goto L15;
        L11:
            if (isNotTrailingByte(r102) == true) goto L15;
            r103[r104] = (char) ((((r100 & 15) << 12) | (trailingByteValue(r101) << 6)) | trailingByteValue(r102));
            return;
        L15:
            throw new IllegalArgumentException("Invalid UTF-8");
        }

        public static void handleFourBytes(byte r100, byte r101, byte r102, byte r103, char[] r104, int r105) throws IllegalArgumentException {
            if (isNotTrailingByte(r101) == true) goto L13;
            if ((((r100 << 28) + (r101 + 112)) >> 30) != 0) goto L13;
            if (isNotTrailingByte(r102) == true) goto L13;
            if (isNotTrailingByte(r103) == true) goto L13;
            int r106 = ((((r100 & 7) << 18) | (trailingByteValue(r101) << 12)) | (trailingByteValue(r102) << 6)) | trailingByteValue(r103);
            r104[r105] = highSurrogate(r106);
            r104[r105 + 1] = lowSurrogate(r106);
            return;
        L13:
            throw new IllegalArgumentException("Invalid UTF-8");
        }
    }

    public static class UnpairedSurrogateException extends IllegalArgumentException {
        public UnpairedSurrogateException(int r100, int r101) {
            super("Unpaired surrogate at index " + r100 + " of " + r101);
        }
    }

    public Utf8() {
    }

    public abstract String decodeUtf8(ByteBuffer r100, int r101, int r102);

    public abstract void encodeUtf8(CharSequence r100, ByteBuffer r101);

    public abstract int encodedLength(CharSequence r100);

    public static Utf8 getDefault() {
        if (DEFAULT != null) goto L6;
        DEFAULT = new Utf8Safe();
    L6:
        return DEFAULT;
    }

    public static void setDefault(Utf8 r100) {
        DEFAULT = r100;
    }
}
