package com.fasterxml.jackson.core.internal.shaded.fdp.v2_19_2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class JavaFloatParser {
    private static final JavaFloatBitsFromByteArray BYTE_ARRAY_PARSER = new JavaFloatBitsFromByteArray();
    private static final JavaFloatBitsFromCharArray CHAR_ARRAY_PARSER = new JavaFloatBitsFromCharArray();
    private static final JavaFloatBitsFromCharSequence CHAR_SEQUENCE_PARSER = new JavaFloatBitsFromCharSequence();

    private JavaFloatParser() {
    }

    public static float parseFloat(CharSequence charSequence, int i, int i3) {
        return Float.intBitsToFloat((int) CHAR_SEQUENCE_PARSER.parseFloatingPointLiteral(charSequence, i, i3));
    }

    public static float parseFloat(CharSequence charSequence) {
        return parseFloat(charSequence, 0, charSequence.length());
    }

    public static float parseFloat(byte[] bArr) {
        return parseFloat(bArr, 0, bArr.length);
    }

    public static float parseFloat(byte[] bArr, int i, int i3) {
        return Float.intBitsToFloat((int) BYTE_ARRAY_PARSER.parseFloatingPointLiteral(bArr, i, i3));
    }

    public static float parseFloat(char[] cArr) {
        return parseFloat(cArr, 0, cArr.length);
    }

    public static float parseFloat(char[] cArr, int i, int i3) {
        return Float.intBitsToFloat((int) CHAR_ARRAY_PARSER.parseFloatingPointLiteral(cArr, i, i3));
    }
}
