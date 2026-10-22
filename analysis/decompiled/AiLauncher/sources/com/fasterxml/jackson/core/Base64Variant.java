package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import java.io.Serializable;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class Base64Variant implements Serializable {
    public static final int BASE64_VALUE_INVALID = -1;
    public static final int BASE64_VALUE_PADDING = -2;
    private static final int INT_SPACE = 32;
    protected static final char PADDING_CHAR_NONE = 0;
    private static final long serialVersionUID = 1;
    private final transient int[] _asciiToBase64;
    private final transient byte[] _base64ToAsciiB;
    private final transient char[] _base64ToAsciiC;
    private final int _maxLineLength;
    final String _name;
    private final char _paddingChar;
    private final PaddingReadBehaviour _paddingReadBehaviour;
    private final boolean _writePadding;

    public enum PaddingReadBehaviour {
        PADDING_FORBIDDEN,
        PADDING_REQUIRED,
        PADDING_ALLOWED
    }

    public Base64Variant(String str, String str2, boolean z10, char c10, int i10) {
        int[] iArr = new int[128];
        this._asciiToBase64 = iArr;
        char[] cArr = new char[64];
        this._base64ToAsciiC = cArr;
        this._base64ToAsciiB = new byte[64];
        this._name = str;
        this._writePadding = z10;
        this._paddingChar = c10;
        this._maxLineLength = i10;
        int length = str2.length();
        if (length != 64) {
            throw new IllegalArgumentException("Base64Alphabet length must be exactly 64 (was " + length + ")");
        }
        str2.getChars(0, length, cArr, 0);
        Arrays.fill(iArr, -1);
        for (int i11 = 0; i11 < length; i11++) {
            char c11 = this._base64ToAsciiC[i11];
            this._base64ToAsciiB[i11] = (byte) c11;
            this._asciiToBase64[c11] = i11;
        }
        if (z10) {
            this._asciiToBase64[c10] = -2;
        }
        this._paddingReadBehaviour = z10 ? PaddingReadBehaviour.PADDING_REQUIRED : PaddingReadBehaviour.PADDING_FORBIDDEN;
    }

    public void _reportBase64EOF() throws IllegalArgumentException {
        throw new IllegalArgumentException(missingPaddingMessage());
    }

    public void _reportBase64UnexpectedPadding() throws IllegalArgumentException {
        throw new IllegalArgumentException(unexpectedPaddingMessage());
    }

    public void _reportInvalidBase64(char c10, int i10, String str) throws IllegalArgumentException {
        String str2;
        if (c10 <= ' ') {
            str2 = "Illegal white space character (code 0x" + Integer.toHexString(c10) + ") as character #" + (i10 + 1) + " of 4-char base64 unit: can only used between units";
        } else if (usesPaddingChar(c10)) {
            str2 = "Unexpected padding character ('" + getPaddingChar() + "') as character #" + (i10 + 1) + " of 4-char base64 unit: padding only legal as 3rd or 4th character";
        } else if (!Character.isDefined(c10) || Character.isISOControl(c10)) {
            str2 = "Illegal character (code 0x" + Integer.toHexString(c10) + ") in base64 content";
        } else {
            str2 = "Illegal character '" + c10 + "' (code 0x" + Integer.toHexString(c10) + ") in base64 content";
        }
        if (str != null) {
            str2 = str2 + ": " + str;
        }
        throw new IllegalArgumentException(str2);
    }

    public boolean acceptsPaddingOnRead() {
        return this._paddingReadBehaviour != PaddingReadBehaviour.PADDING_FORBIDDEN;
    }

    public byte[] decode(String str) throws IllegalArgumentException {
        ByteArrayBuilder byteArrayBuilder = new ByteArrayBuilder();
        decode(str, byteArrayBuilder);
        return byteArrayBuilder.toByteArray();
    }

    public int decodeBase64Byte(byte b10) {
        if (b10 < 0) {
            return -1;
        }
        return this._asciiToBase64[b10];
    }

    public int decodeBase64Char(char c10) {
        if (c10 <= 127) {
            return this._asciiToBase64[c10];
        }
        return -1;
    }

    public String encode(byte[] bArr) {
        return encode(bArr, false);
    }

    public byte encodeBase64BitsAsByte(int i10) {
        return this._base64ToAsciiB[i10];
    }

    public char encodeBase64BitsAsChar(int i10) {
        return this._base64ToAsciiC[i10];
    }

    public int encodeBase64Chunk(int i10, char[] cArr, int i11) {
        char[] cArr2 = this._base64ToAsciiC;
        cArr[i11] = cArr2[(i10 >> 18) & 63];
        cArr[i11 + 1] = cArr2[(i10 >> 12) & 63];
        int i12 = i11 + 3;
        cArr[i11 + 2] = cArr2[(i10 >> 6) & 63];
        int i13 = i11 + 4;
        cArr[i12] = cArr2[i10 & 63];
        return i13;
    }

    public int encodeBase64Partial(int i10, int i11, char[] cArr, int i12) {
        char[] cArr2 = this._base64ToAsciiC;
        cArr[i12] = cArr2[(i10 >> 18) & 63];
        int i13 = i12 + 2;
        cArr[i12 + 1] = cArr2[(i10 >> 12) & 63];
        if (usesPadding()) {
            int i14 = i12 + 3;
            cArr[i13] = i11 == 2 ? this._base64ToAsciiC[(i10 >> 6) & 63] : this._paddingChar;
            int i15 = i12 + 4;
            cArr[i14] = this._paddingChar;
            return i15;
        }
        if (i11 != 2) {
            return i13;
        }
        int i16 = i12 + 3;
        cArr[i13] = this._base64ToAsciiC[(i10 >> 6) & 63];
        return i16;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass() == Base64Variant.class) {
            Base64Variant base64Variant = (Base64Variant) obj;
            if (base64Variant._paddingChar == this._paddingChar && base64Variant._maxLineLength == this._maxLineLength && base64Variant._writePadding == this._writePadding && base64Variant._paddingReadBehaviour == this._paddingReadBehaviour && this._name.equals(base64Variant._name)) {
                return true;
            }
        }
        return false;
    }

    public int getMaxLineLength() {
        return this._maxLineLength;
    }

    public String getName() {
        return this._name;
    }

    public byte getPaddingByte() {
        return (byte) this._paddingChar;
    }

    public char getPaddingChar() {
        return this._paddingChar;
    }

    public int hashCode() {
        return this._name.hashCode();
    }

    public String missingPaddingMessage() {
        return String.format("Unexpected end of base64-encoded String: base64 variant '%s' expects padding (one or more '%c' characters) at the end. This Base64Variant might have been incorrectly configured", getName(), Character.valueOf(getPaddingChar()));
    }

    public PaddingReadBehaviour paddingReadBehaviour() {
        return this._paddingReadBehaviour;
    }

    public Object readResolve() throws IllegalArgumentException {
        Base64Variant base64VariantValueOf = Base64Variants.valueOf(this._name);
        boolean z10 = this._writePadding;
        return (z10 == base64VariantValueOf._writePadding && this._paddingChar == base64VariantValueOf._paddingChar && this._paddingReadBehaviour == base64VariantValueOf._paddingReadBehaviour && this._maxLineLength == base64VariantValueOf._maxLineLength) ? base64VariantValueOf : new Base64Variant(base64VariantValueOf, this._name, z10, this._paddingChar, this._paddingReadBehaviour, this._maxLineLength);
    }

    public boolean requiresPaddingOnRead() {
        return this._paddingReadBehaviour == PaddingReadBehaviour.PADDING_REQUIRED;
    }

    public String toString() {
        return this._name;
    }

    public String unexpectedPaddingMessage() {
        return String.format("Unexpected end of base64-encoded String: base64 variant '%s' expects no padding at the end while decoding. This Base64Variant might have been incorrectly configured", getName());
    }

    public boolean usesPadding() {
        return this._writePadding;
    }

    public boolean usesPaddingChar(char c10) {
        return c10 == this._paddingChar;
    }

    public Base64Variant withPaddingAllowed() {
        return withReadPadding(PaddingReadBehaviour.PADDING_ALLOWED);
    }

    public Base64Variant withPaddingForbidden() {
        return withReadPadding(PaddingReadBehaviour.PADDING_FORBIDDEN);
    }

    public Base64Variant withPaddingRequired() {
        return withReadPadding(PaddingReadBehaviour.PADDING_REQUIRED);
    }

    public Base64Variant withReadPadding(PaddingReadBehaviour paddingReadBehaviour) {
        return paddingReadBehaviour == this._paddingReadBehaviour ? this : new Base64Variant(this, paddingReadBehaviour);
    }

    public Base64Variant withWritePadding(boolean z10) {
        return z10 == this._writePadding ? this : new Base64Variant(this, this._name, z10, this._paddingChar, this._maxLineLength);
    }

    public int decodeBase64Char(int i10) {
        if (i10 <= 127) {
            return this._asciiToBase64[i10];
        }
        return -1;
    }

    public String encode(byte[] bArr, boolean z10) {
        int length = bArr.length;
        StringBuilder sb2 = new StringBuilder((length >> 2) + length + (length >> 3));
        if (z10) {
            sb2.append(JsonFactory.DEFAULT_QUOTE_CHAR);
        }
        int maxLineLength = getMaxLineLength() >> 2;
        int i10 = length - 3;
        int i11 = 0;
        while (i11 <= i10) {
            int i12 = i11 + 2;
            int i13 = ((bArr[i11 + 1] & 255) | (bArr[i11] << 8)) << 8;
            i11 += 3;
            encodeBase64Chunk(sb2, i13 | (bArr[i12] & 255));
            maxLineLength--;
            if (maxLineLength <= 0) {
                sb2.append('\\');
                sb2.append('n');
                maxLineLength = getMaxLineLength() >> 2;
            }
        }
        int i14 = length - i11;
        if (i14 > 0) {
            int i15 = i11 + 1;
            int i16 = bArr[i11] << 16;
            if (i14 == 2) {
                i16 |= (bArr[i15] & 255) << 8;
            }
            encodeBase64Partial(sb2, i16, i14);
        }
        if (z10) {
            sb2.append(JsonFactory.DEFAULT_QUOTE_CHAR);
        }
        return sb2.toString();
    }

    public boolean usesPaddingChar(int i10) {
        return i10 == this._paddingChar;
    }

    public void decode(String str, ByteArrayBuilder byteArrayBuilder) throws IllegalArgumentException {
        int length = str.length();
        int i10 = 0;
        while (i10 < length) {
            int i11 = i10 + 1;
            char cCharAt = str.charAt(i10);
            if (cCharAt > ' ') {
                int iDecodeBase64Char = decodeBase64Char(cCharAt);
                if (iDecodeBase64Char < 0) {
                    _reportInvalidBase64(cCharAt, 0, null);
                }
                if (i11 >= length) {
                    _reportBase64EOF();
                }
                int i12 = i10 + 2;
                char cCharAt2 = str.charAt(i11);
                int iDecodeBase64Char2 = decodeBase64Char(cCharAt2);
                if (iDecodeBase64Char2 < 0) {
                    _reportInvalidBase64(cCharAt2, 1, null);
                }
                int i13 = (iDecodeBase64Char << 6) | iDecodeBase64Char2;
                if (i12 >= length) {
                    if (!requiresPaddingOnRead()) {
                        byteArrayBuilder.append(i13 >> 4);
                        return;
                    }
                    _reportBase64EOF();
                }
                int i14 = i10 + 3;
                char cCharAt3 = str.charAt(i12);
                int iDecodeBase64Char3 = decodeBase64Char(cCharAt3);
                if (iDecodeBase64Char3 < 0) {
                    if (iDecodeBase64Char3 != -2) {
                        _reportInvalidBase64(cCharAt3, 2, null);
                    }
                    if (!acceptsPaddingOnRead()) {
                        _reportBase64UnexpectedPadding();
                    }
                    if (i14 >= length) {
                        _reportBase64EOF();
                    }
                    i10 += 4;
                    char cCharAt4 = str.charAt(i14);
                    if (!usesPaddingChar(cCharAt4)) {
                        _reportInvalidBase64(cCharAt4, 3, "expected padding character '" + getPaddingChar() + "'");
                    }
                    byteArrayBuilder.append(i13 >> 4);
                } else {
                    int i15 = (i13 << 6) | iDecodeBase64Char3;
                    if (i14 >= length) {
                        if (!requiresPaddingOnRead()) {
                            byteArrayBuilder.appendTwoBytes(i15 >> 2);
                            return;
                        }
                        _reportBase64EOF();
                    }
                    i10 += 4;
                    char cCharAt5 = str.charAt(i14);
                    int iDecodeBase64Char4 = decodeBase64Char(cCharAt5);
                    if (iDecodeBase64Char4 < 0) {
                        if (iDecodeBase64Char4 != -2) {
                            _reportInvalidBase64(cCharAt5, 3, null);
                        }
                        if (!acceptsPaddingOnRead()) {
                            _reportBase64UnexpectedPadding();
                        }
                        byteArrayBuilder.appendTwoBytes(i15 >> 2);
                    } else {
                        byteArrayBuilder.appendThreeBytes((i15 << 6) | iDecodeBase64Char4);
                    }
                }
            } else {
                i10 = i11;
            }
        }
    }

    public void encodeBase64Chunk(StringBuilder sb2, int i10) {
        sb2.append(this._base64ToAsciiC[(i10 >> 18) & 63]);
        sb2.append(this._base64ToAsciiC[(i10 >> 12) & 63]);
        sb2.append(this._base64ToAsciiC[(i10 >> 6) & 63]);
        sb2.append(this._base64ToAsciiC[i10 & 63]);
    }

    public void encodeBase64Partial(StringBuilder sb2, int i10, int i11) {
        sb2.append(this._base64ToAsciiC[(i10 >> 18) & 63]);
        sb2.append(this._base64ToAsciiC[(i10 >> 12) & 63]);
        if (usesPadding()) {
            sb2.append(i11 == 2 ? this._base64ToAsciiC[(i10 >> 6) & 63] : this._paddingChar);
            sb2.append(this._paddingChar);
        } else if (i11 == 2) {
            sb2.append(this._base64ToAsciiC[(i10 >> 6) & 63]);
        }
    }

    public int encodeBase64Chunk(int i10, byte[] bArr, int i11) {
        byte[] bArr2 = this._base64ToAsciiB;
        bArr[i11] = bArr2[(i10 >> 18) & 63];
        bArr[i11 + 1] = bArr2[(i10 >> 12) & 63];
        int i12 = i11 + 3;
        bArr[i11 + 2] = bArr2[(i10 >> 6) & 63];
        int i13 = i11 + 4;
        bArr[i12] = bArr2[i10 & 63];
        return i13;
    }

    public int encodeBase64Partial(int i10, int i11, byte[] bArr, int i12) {
        byte[] bArr2 = this._base64ToAsciiB;
        bArr[i12] = bArr2[(i10 >> 18) & 63];
        int i13 = i12 + 2;
        bArr[i12 + 1] = bArr2[(i10 >> 12) & 63];
        if (!usesPadding()) {
            if (i11 != 2) {
                return i13;
            }
            int i14 = i12 + 3;
            bArr[i13] = this._base64ToAsciiB[(i10 >> 6) & 63];
            return i14;
        }
        byte b10 = (byte) this._paddingChar;
        int i15 = i12 + 3;
        bArr[i13] = i11 == 2 ? this._base64ToAsciiB[(i10 >> 6) & 63] : b10;
        int i16 = i12 + 4;
        bArr[i15] = b10;
        return i16;
    }

    public Base64Variant(Base64Variant base64Variant, String str, int i10) {
        this(base64Variant, str, base64Variant._writePadding, base64Variant._paddingChar, i10);
    }

    public String encode(byte[] bArr, boolean z10, String str) {
        int length = bArr.length;
        StringBuilder sb2 = new StringBuilder((length >> 2) + length + (length >> 3));
        if (z10) {
            sb2.append(JsonFactory.DEFAULT_QUOTE_CHAR);
        }
        int maxLineLength = getMaxLineLength() >> 2;
        int i10 = length - 3;
        int i11 = 0;
        while (i11 <= i10) {
            int i12 = i11 + 2;
            int i13 = ((bArr[i11 + 1] & 255) | (bArr[i11] << 8)) << 8;
            i11 += 3;
            encodeBase64Chunk(sb2, i13 | (bArr[i12] & 255));
            maxLineLength--;
            if (maxLineLength <= 0) {
                sb2.append(str);
                maxLineLength = getMaxLineLength() >> 2;
            }
        }
        int i14 = length - i11;
        if (i14 > 0) {
            int i15 = i11 + 1;
            int i16 = bArr[i11] << 16;
            if (i14 == 2) {
                i16 |= (bArr[i15] & 255) << 8;
            }
            encodeBase64Partial(sb2, i16, i14);
        }
        if (z10) {
            sb2.append(JsonFactory.DEFAULT_QUOTE_CHAR);
        }
        return sb2.toString();
    }

    public Base64Variant(Base64Variant base64Variant, String str, boolean z10, char c10, int i10) {
        this(base64Variant, str, z10, c10, base64Variant._paddingReadBehaviour, i10);
    }

    private Base64Variant(Base64Variant base64Variant, String str, boolean z10, char c10, PaddingReadBehaviour paddingReadBehaviour, int i10) {
        int[] iArr = new int[128];
        this._asciiToBase64 = iArr;
        char[] cArr = new char[64];
        this._base64ToAsciiC = cArr;
        byte[] bArr = new byte[64];
        this._base64ToAsciiB = bArr;
        this._name = str;
        byte[] bArr2 = base64Variant._base64ToAsciiB;
        System.arraycopy(bArr2, 0, bArr, 0, bArr2.length);
        char[] cArr2 = base64Variant._base64ToAsciiC;
        System.arraycopy(cArr2, 0, cArr, 0, cArr2.length);
        int[] iArr2 = base64Variant._asciiToBase64;
        System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
        this._writePadding = z10;
        this._paddingChar = c10;
        this._maxLineLength = i10;
        this._paddingReadBehaviour = paddingReadBehaviour;
    }

    private Base64Variant(Base64Variant base64Variant, PaddingReadBehaviour paddingReadBehaviour) {
        this(base64Variant, base64Variant._name, base64Variant._writePadding, base64Variant._paddingChar, paddingReadBehaviour, base64Variant._maxLineLength);
    }
}
