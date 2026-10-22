package com.fasterxml.jackson.core.internal.shaded.fdp.v2_19_2;

/* loaded from: classes.dex */
public class JavaFloatParser {
    private static final JavaFloatBitsFromByteArray BYTE_ARRAY_PARSER = new JavaFloatBitsFromByteArray();
    private static final JavaFloatBitsFromCharArray CHAR_ARRAY_PARSER = new JavaFloatBitsFromCharArray();
    private static final JavaFloatBitsFromCharSequence CHAR_SEQUENCE_PARSER = new JavaFloatBitsFromCharSequence();

    private JavaFloatParser() {
    }

    public static float parseFloat(CharSequence charSequence) throws NumberFormatException {
        return parseFloat(charSequence, 0, charSequence.length());
    }

    public static float parseFloat(CharSequence charSequence, int i10, int i11) throws NumberFormatException {
        return Float.intBitsToFloat((int) CHAR_SEQUENCE_PARSER.parseFloatingPointLiteral(charSequence, i10, i11));
    }

    public static float parseFloat(byte[] bArr) throws NumberFormatException {
        return parseFloat(bArr, 0, bArr.length);
    }

    public static float parseFloat(byte[] bArr, int i10, int i11) throws NumberFormatException {
        return Float.intBitsToFloat((int) BYTE_ARRAY_PARSER.parseFloatingPointLiteral(bArr, i10, i11));
    }

    public static float parseFloat(char[] cArr) throws NumberFormatException {
        return parseFloat(cArr, 0, cArr.length);
    }

    public static float parseFloat(char[] cArr, int i10, int i11) throws NumberFormatException {
        return Float.intBitsToFloat((int) CHAR_ARRAY_PARSER.parseFloatingPointLiteral(cArr, i10, i11));
    }
}
