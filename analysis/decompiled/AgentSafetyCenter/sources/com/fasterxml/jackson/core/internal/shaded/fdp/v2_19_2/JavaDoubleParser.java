package com.fasterxml.jackson.core.internal.shaded.fdp.v2_19_2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class JavaDoubleParser {
    private static final JavaDoubleBitsFromByteArray BYTE_ARRAY_PARSER = new JavaDoubleBitsFromByteArray();
    private static final JavaDoubleBitsFromCharArray CHAR_ARRAY_PARSER = new JavaDoubleBitsFromCharArray();
    private static final JavaDoubleBitsFromCharSequence CHAR_SEQUENCE_PARSER = new JavaDoubleBitsFromCharSequence();

    private JavaDoubleParser() {
    }

    public static double parseDouble(CharSequence charSequence, int i, int i3) {
        return Double.longBitsToDouble(CHAR_SEQUENCE_PARSER.parseFloatingPointLiteral(charSequence, i, i3));
    }

    public static double parseDouble(CharSequence charSequence) {
        return parseDouble(charSequence, 0, charSequence.length());
    }

    public static double parseDouble(byte[] bArr) {
        return parseDouble(bArr, 0, bArr.length);
    }

    public static double parseDouble(byte[] bArr, int i, int i3) {
        return Double.longBitsToDouble(BYTE_ARRAY_PARSER.parseFloatingPointLiteral(bArr, i, i3));
    }

    public static double parseDouble(char[] cArr) {
        return parseDouble(cArr, 0, cArr.length);
    }

    public static double parseDouble(char[] cArr, int i, int i3) {
        return Double.longBitsToDouble(CHAR_ARRAY_PARSER.parseFloatingPointLiteral(cArr, i, i3));
    }
}
