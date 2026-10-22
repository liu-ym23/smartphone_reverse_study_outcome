package androidx.emoji2.text.flatbuffer;

import com.google.common.base.Ascii;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public abstract class Utf8 {
    private static Utf8 DEFAULT;

    static class DecodeUtil {
        private static char highSurrogate(int r1) {
            return (char) ((r1 >>> 10) + 55232);
        }

        private static boolean isNotTrailingByte(byte r1) {
            if (r1 <= (-65)) goto L5;
            return true;
        L5:
            return false;
        }

        static boolean isOneByte(byte r0) {
            if (r0 < 0) goto L4;
            return true;
        L4:
            return false;
        }

        static boolean isThreeBytes(byte r1) {
            if (r1 >= (-16)) goto L5;
            return true;
        L5:
            return false;
        }

        static boolean isTwoBytes(byte r1) {
            if (r1 >= (-32)) goto L5;
            return true;
        L5:
            return false;
        }

        private static char lowSurrogate(int r1) {
            return (char) ((r1 & 1023) + 56320);
        }

        private static int trailingByteValue(byte r0) {
            return r0 & 63;
        }

        DecodeUtil() {
        }

        static void handleOneByte(byte r0, char[] r1, int r2) {
            r1[r2] = (char) r0;
        }

        static void handleTwoBytes(byte r1, byte r2, char[] r3, int r4) throws IllegalArgumentException {
            if (r1 < (-62)) goto L11;
            if (isNotTrailingByte(r2) == true) goto L9;
            r3[r4] = (char) (((r1 & Ascii.US) << 6) | trailingByteValue(r2));
            return;
        L9:
            throw new IllegalArgumentException("Invalid UTF-8: Illegal trailing byte in 2 bytes utf");
        L11:
            throw new IllegalArgumentException("Invalid UTF-8: Illegal leading byte in 2 bytes utf");
        }

        static void handleThreeBytes(byte r2, byte r3, byte r4, char[] r5, int r6) throws IllegalArgumentException {
            if (isNotTrailingByte(r3) == true) goto L15;
            if (r2 != (-32)) goto L8;
            if (r3 < (-96)) goto L15;
        L8:
            if (r2 != (-19)) goto L11;
            if (r3 >= (-96)) goto L15;
        L11:
            if (isNotTrailingByte(r4) == true) goto L15;
            r5[r6] = (char) ((((r2 & Ascii.SI) << 12) | (trailingByteValue(r3) << 6)) | trailingByteValue(r4));
            return;
        L15:
            throw new IllegalArgumentException("Invalid UTF-8");
        }

        static void handleFourBytes(byte r2, byte r3, byte r4, byte r5, char[] r6, int r7) throws IllegalArgumentException {
            if (isNotTrailingByte(r3) == true) goto L13;
            if ((((r2 << Ascii.FS) + (r3 + 112)) >> 30) != 0) goto L13;
            if (isNotTrailingByte(r4) == true) goto L13;
            if (isNotTrailingByte(r5) == true) goto L13;
            int r8 = ((((r2 & 7) << 18) | (trailingByteValue(r3) << 12)) | (trailingByteValue(r4) << 6)) | trailingByteValue(r5);
            r6[r7] = highSurrogate(r8);
            r6[r7 + 1] = lowSurrogate(r8);
            return;
        L13:
            throw new IllegalArgumentException("Invalid UTF-8");
        }
    }

    static class UnpairedSurrogateException extends IllegalArgumentException {
        UnpairedSurrogateException(int r3, int r4) {
            super("Unpaired surrogate at index " + r3 + " of " + r4);
        }
    }

    public abstract String decodeUtf8(ByteBuffer r1, int r2, int r3);

    public abstract void encodeUtf8(CharSequence r1, ByteBuffer r2);

    public abstract int encodedLength(CharSequence r1);

    public Utf8() {
    }

    public static Utf8 getDefault() {
        if (DEFAULT != null) goto L6;
        DEFAULT = new Utf8Safe();
    L6:
        return DEFAULT;
    }

    public static void setDefault(Utf8 r0) {
        DEFAULT = r0;
    }
}
