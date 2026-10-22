package com.fasterxml.jackson.core.internal.shaded.fdp.v2_19_2;

import java.math.BigInteger;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class JavaBigIntegerParser {
    private static final JavaBigIntegerFromByteArray BYTE_ARRAY_PARSER = new JavaBigIntegerFromByteArray();
    private static final JavaBigIntegerFromCharArray CHAR_ARRAY_PARSER = new JavaBigIntegerFromCharArray();
    private static final JavaBigIntegerFromCharSequence CHAR_SEQUENCE_PARSER = new JavaBigIntegerFromCharSequence();

    private JavaBigIntegerParser() {
    }

    public static BigInteger parseBigInteger(CharSequence charSequence) {
        return CHAR_SEQUENCE_PARSER.parseBigIntegerString(charSequence, 0, charSequence.length(), 10);
    }

    public static BigInteger parseBigInteger(CharSequence charSequence, int i) {
        return CHAR_SEQUENCE_PARSER.parseBigIntegerString(charSequence, 0, charSequence.length(), i);
    }

    public static BigInteger parseBigInteger(CharSequence charSequence, int i, int i3) {
        return CHAR_SEQUENCE_PARSER.parseBigIntegerString(charSequence, i, i3, 10);
    }

    public static BigInteger parseBigInteger(CharSequence charSequence, int i, int i3, int i10) {
        return CHAR_SEQUENCE_PARSER.parseBigIntegerString(charSequence, i, i3, i10);
    }

    public static BigInteger parseBigInteger(byte[] bArr) {
        return BYTE_ARRAY_PARSER.parseBigIntegerString(bArr, 0, bArr.length, 10);
    }

    public static BigInteger parseBigInteger(byte[] bArr, int i) {
        return BYTE_ARRAY_PARSER.parseBigIntegerString(bArr, 0, bArr.length, i);
    }

    public static BigInteger parseBigInteger(byte[] bArr, int i, int i3) {
        return BYTE_ARRAY_PARSER.parseBigIntegerString(bArr, i, i3, 10);
    }

    public static BigInteger parseBigInteger(byte[] bArr, int i, int i3, int i10) {
        return BYTE_ARRAY_PARSER.parseBigIntegerString(bArr, i, i3, i10);
    }

    public static BigInteger parseBigInteger(char[] cArr) {
        return CHAR_ARRAY_PARSER.parseBigIntegerString(cArr, 0, cArr.length, 10);
    }

    public static BigInteger parseBigInteger(char[] cArr, int i) {
        return CHAR_ARRAY_PARSER.parseBigIntegerString(cArr, 0, cArr.length, i);
    }

    public static BigInteger parseBigInteger(char[] cArr, int i, int i3) {
        return CHAR_ARRAY_PARSER.parseBigIntegerString(cArr, i, i3, 10);
    }

    public static BigInteger parseBigInteger(char[] cArr, int i, int i3, int i10) {
        return CHAR_ARRAY_PARSER.parseBigIntegerString(cArr, i, i3, i10);
    }
}
