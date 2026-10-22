package com.fasterxml.jackson.core.internal.shaded.fdp.v2_19_2;

import java.math.BigInteger;

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

    public static BigInteger parseBigInteger(CharSequence charSequence, int i10) {
        return CHAR_SEQUENCE_PARSER.parseBigIntegerString(charSequence, 0, charSequence.length(), i10);
    }

    public static BigInteger parseBigInteger(CharSequence charSequence, int i10, int i11) {
        return CHAR_SEQUENCE_PARSER.parseBigIntegerString(charSequence, i10, i11, 10);
    }

    public static BigInteger parseBigInteger(CharSequence charSequence, int i10, int i11, int i12) {
        return CHAR_SEQUENCE_PARSER.parseBigIntegerString(charSequence, i10, i11, i12);
    }

    public static BigInteger parseBigInteger(byte[] bArr) {
        return BYTE_ARRAY_PARSER.parseBigIntegerString(bArr, 0, bArr.length, 10);
    }

    public static BigInteger parseBigInteger(byte[] bArr, int i10) {
        return BYTE_ARRAY_PARSER.parseBigIntegerString(bArr, 0, bArr.length, i10);
    }

    public static BigInteger parseBigInteger(byte[] bArr, int i10, int i11) {
        return BYTE_ARRAY_PARSER.parseBigIntegerString(bArr, i10, i11, 10);
    }

    public static BigInteger parseBigInteger(byte[] bArr, int i10, int i11, int i12) {
        return BYTE_ARRAY_PARSER.parseBigIntegerString(bArr, i10, i11, i12);
    }

    public static BigInteger parseBigInteger(char[] cArr) {
        return CHAR_ARRAY_PARSER.parseBigIntegerString(cArr, 0, cArr.length, 10);
    }

    public static BigInteger parseBigInteger(char[] cArr, int i10) {
        return CHAR_ARRAY_PARSER.parseBigIntegerString(cArr, 0, cArr.length, i10);
    }

    public static BigInteger parseBigInteger(char[] cArr, int i10, int i11) {
        return CHAR_ARRAY_PARSER.parseBigIntegerString(cArr, i10, i11, 10);
    }

    public static BigInteger parseBigInteger(char[] cArr, int i10, int i11, int i12) {
        return CHAR_ARRAY_PARSER.parseBigIntegerString(cArr, i10, i11, i12);
    }
}
