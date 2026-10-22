package com.fasterxml.jackson.core;

import androidx.appfunctions.metadata.a;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import java.io.Serializable;
import java.util.Arrays;

/* loaded from: classes2.dex */
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

    public Base64Variant(String str, String str2, boolean z10, char c, int i) {
        int[] iArr = new int[128];
        this._asciiToBase64 = iArr;
        char[] cArr = new char[64];
        this._base64ToAsciiC = cArr;
        this._base64ToAsciiB = new byte[64];
        this._name = str;
        this._writePadding = z10;
        this._paddingChar = c;
        this._maxLineLength = i;
        int length = str2.length();
        if (length != 64) {
            throw new IllegalArgumentException(a.i(length, "Base64Alphabet length must be exactly 64 (was ", ")"));
        }
        str2.getChars(0, length, cArr, 0);
        Arrays.fill(iArr, -1);
        for (int i6 = 0; i6 < length; i6++) {
            char c2 = this._base64ToAsciiC[i6];
            this._base64ToAsciiB[i6] = (byte) c2;
            this._asciiToBase64[c2] = i6;
        }
        if (z10) {
            this._asciiToBase64[c] = -2;
        }
        this._paddingReadBehaviour = z10 ? PaddingReadBehaviour.PADDING_REQUIRED : PaddingReadBehaviour.PADDING_FORBIDDEN;
    }

    public void _reportBase64EOF() throws IllegalArgumentException {
        throw new IllegalArgumentException(missingPaddingMessage());
    }

    public void _reportBase64UnexpectedPadding() throws IllegalArgumentException {
        throw new IllegalArgumentException(unexpectedPaddingMessage());
    }

    public void _reportInvalidBase64(char c, int i, String str) throws IllegalArgumentException {
        String strB;
        if (c <= ' ') {
            strB = "Illegal white space character (code 0x" + Integer.toHexString(c) + ") as character #" + (i + 1) + " of 4-char base64 unit: can only used between units";
        } else if (usesPaddingChar(c)) {
            strB = "Unexpected padding character ('" + getPaddingChar() + "') as character #" + (i + 1) + " of 4-char base64 unit: padding only legal as 3rd or 4th character";
        } else if (!Character.isDefined(c) || Character.isISOControl(c)) {
            strB = "Illegal character (code 0x" + Integer.toHexString(c) + ") in base64 content";
        } else {
            strB = "Illegal character '" + c + "' (code 0x" + Integer.toHexString(c) + ") in base64 content";
        }
        if (str != null) {
            strB = B7.a.B(strB, ": ", str);
        }
        throw new IllegalArgumentException(strB);
    }

    public boolean acceptsPaddingOnRead() {
        return this._paddingReadBehaviour != PaddingReadBehaviour.PADDING_FORBIDDEN;
    }

    public byte[] decode(String str) throws IllegalArgumentException {
        ByteArrayBuilder byteArrayBuilder = new ByteArrayBuilder();
        decode(str, byteArrayBuilder);
        return byteArrayBuilder.toByteArray();
    }

    public int decodeBase64Byte(byte b) {
        if (b < 0) {
            return -1;
        }
        return this._asciiToBase64[b];
    }

    public int decodeBase64Char(char c) {
        if (c <= 127) {
            return this._asciiToBase64[c];
        }
        return -1;
    }

    public String encode(byte[] bArr) {
        return encode(bArr, false);
    }

    public byte encodeBase64BitsAsByte(int i) {
        return this._base64ToAsciiB[i];
    }

    public char encodeBase64BitsAsChar(int i) {
        return this._base64ToAsciiC[i];
    }

    public int encodeBase64Chunk(int i, char[] cArr, int i6) {
        char[] cArr2 = this._base64ToAsciiC;
        cArr[i6] = cArr2[(i >> 18) & 63];
        cArr[i6 + 1] = cArr2[(i >> 12) & 63];
        int i10 = i6 + 3;
        cArr[i6 + 2] = cArr2[(i >> 6) & 63];
        int i11 = i6 + 4;
        cArr[i10] = cArr2[i & 63];
        return i11;
    }

    public int encodeBase64Partial(int i, int i6, char[] cArr, int i10) {
        char[] cArr2 = this._base64ToAsciiC;
        cArr[i10] = cArr2[(i >> 18) & 63];
        int i11 = i10 + 2;
        cArr[i10 + 1] = cArr2[(i >> 12) & 63];
        if (usesPadding()) {
            int i12 = i10 + 3;
            cArr[i11] = i6 == 2 ? this._base64ToAsciiC[(i >> 6) & 63] : this._paddingChar;
            int i13 = i10 + 4;
            cArr[i12] = this._paddingChar;
            return i13;
        }
        if (i6 != 2) {
            return i11;
        }
        int i14 = i10 + 3;
        cArr[i11] = this._base64ToAsciiC[(i >> 6) & 63];
        return i14;
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
        return B7.a.m("Unexpected end of base64-encoded String: base64 variant '", getName(), "' expects no padding at the end while decoding. This Base64Variant might have been incorrectly configured");
    }

    public boolean usesPadding() {
        return this._writePadding;
    }

    public boolean usesPaddingChar(char c) {
        return c == this._paddingChar;
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

    public int decodeBase64Char(int i) {
        if (i <= 127) {
            return this._asciiToBase64[i];
        }
        return -1;
    }

    public String encode(byte[] bArr, boolean z10) {
        int length = bArr.length;
        StringBuilder sb = new StringBuilder((length >> 2) + length + (length >> 3));
        if (z10) {
            sb.append(JsonFactory.DEFAULT_QUOTE_CHAR);
        }
        int maxLineLength = getMaxLineLength() >> 2;
        int i = length - 3;
        int i6 = 0;
        while (i6 <= i) {
            int i10 = i6 + 2;
            int i11 = ((bArr[i6 + 1] & 255) | (bArr[i6] << 8)) << 8;
            i6 += 3;
            encodeBase64Chunk(sb, i11 | (bArr[i10] & 255));
            maxLineLength--;
            if (maxLineLength <= 0) {
                sb.append('\\');
                sb.append('n');
                maxLineLength = getMaxLineLength() >> 2;
            }
        }
        int i12 = length - i6;
        if (i12 > 0) {
            int i13 = i6 + 1;
            int i14 = bArr[i6] << 16;
            if (i12 == 2) {
                i14 |= (bArr[i13] & 255) << 8;
            }
            encodeBase64Partial(sb, i14, i12);
        }
        if (z10) {
            sb.append(JsonFactory.DEFAULT_QUOTE_CHAR);
        }
        return sb.toString();
    }

    public boolean usesPaddingChar(int i) {
        return i == this._paddingChar;
    }

    public void decode(String str, ByteArrayBuilder byteArrayBuilder) throws IllegalArgumentException {
        int length = str.length();
        int i = 0;
        while (i < length) {
            int i6 = i + 1;
            char cCharAt = str.charAt(i);
            if (cCharAt > ' ') {
                int iDecodeBase64Char = decodeBase64Char(cCharAt);
                if (iDecodeBase64Char < 0) {
                    _reportInvalidBase64(cCharAt, 0, null);
                }
                if (i6 >= length) {
                    _reportBase64EOF();
                }
                int i10 = i + 2;
                char cCharAt2 = str.charAt(i6);
                int iDecodeBase64Char2 = decodeBase64Char(cCharAt2);
                if (iDecodeBase64Char2 < 0) {
                    _reportInvalidBase64(cCharAt2, 1, null);
                }
                int i11 = (iDecodeBase64Char << 6) | iDecodeBase64Char2;
                if (i10 >= length) {
                    if (!requiresPaddingOnRead()) {
                        byteArrayBuilder.append(i11 >> 4);
                        return;
                    }
                    _reportBase64EOF();
                }
                int i12 = i + 3;
                char cCharAt3 = str.charAt(i10);
                int iDecodeBase64Char3 = decodeBase64Char(cCharAt3);
                if (iDecodeBase64Char3 < 0) {
                    if (iDecodeBase64Char3 != -2) {
                        _reportInvalidBase64(cCharAt3, 2, null);
                    }
                    if (!acceptsPaddingOnRead()) {
                        _reportBase64UnexpectedPadding();
                    }
                    if (i12 >= length) {
                        _reportBase64EOF();
                    }
                    i += 4;
                    char cCharAt4 = str.charAt(i12);
                    if (!usesPaddingChar(cCharAt4)) {
                        _reportInvalidBase64(cCharAt4, 3, "expected padding character '" + getPaddingChar() + "'");
                    }
                    byteArrayBuilder.append(i11 >> 4);
                } else {
                    int i13 = (i11 << 6) | iDecodeBase64Char3;
                    if (i12 >= length) {
                        if (!requiresPaddingOnRead()) {
                            byteArrayBuilder.appendTwoBytes(i13 >> 2);
                            return;
                        }
                        _reportBase64EOF();
                    }
                    i += 4;
                    char cCharAt5 = str.charAt(i12);
                    int iDecodeBase64Char4 = decodeBase64Char(cCharAt5);
                    if (iDecodeBase64Char4 < 0) {
                        if (iDecodeBase64Char4 != -2) {
                            _reportInvalidBase64(cCharAt5, 3, null);
                        }
                        if (!acceptsPaddingOnRead()) {
                            _reportBase64UnexpectedPadding();
                        }
                        byteArrayBuilder.appendTwoBytes(i13 >> 2);
                    } else {
                        byteArrayBuilder.appendThreeBytes((i13 << 6) | iDecodeBase64Char4);
                    }
                }
            } else {
                i = i6;
            }
        }
    }

    public void encodeBase64Chunk(StringBuilder sb, int i) {
        sb.append(this._base64ToAsciiC[(i >> 18) & 63]);
        sb.append(this._base64ToAsciiC[(i >> 12) & 63]);
        sb.append(this._base64ToAsciiC[(i >> 6) & 63]);
        sb.append(this._base64ToAsciiC[i & 63]);
    }

    public void encodeBase64Partial(StringBuilder sb, int i, int i6) {
        sb.append(this._base64ToAsciiC[(i >> 18) & 63]);
        sb.append(this._base64ToAsciiC[(i >> 12) & 63]);
        if (usesPadding()) {
            sb.append(i6 == 2 ? this._base64ToAsciiC[(i >> 6) & 63] : this._paddingChar);
            sb.append(this._paddingChar);
        } else if (i6 == 2) {
            sb.append(this._base64ToAsciiC[(i >> 6) & 63]);
        }
    }

    public int encodeBase64Chunk(int i, byte[] bArr, int i6) {
        byte[] bArr2 = this._base64ToAsciiB;
        bArr[i6] = bArr2[(i >> 18) & 63];
        bArr[i6 + 1] = bArr2[(i >> 12) & 63];
        int i10 = i6 + 3;
        bArr[i6 + 2] = bArr2[(i >> 6) & 63];
        int i11 = i6 + 4;
        bArr[i10] = bArr2[i & 63];
        return i11;
    }

    public int encodeBase64Partial(int i, int i6, byte[] bArr, int i10) {
        byte[] bArr2 = this._base64ToAsciiB;
        bArr[i10] = bArr2[(i >> 18) & 63];
        int i11 = i10 + 2;
        bArr[i10 + 1] = bArr2[(i >> 12) & 63];
        if (!usesPadding()) {
            if (i6 != 2) {
                return i11;
            }
            int i12 = i10 + 3;
            bArr[i11] = this._base64ToAsciiB[(i >> 6) & 63];
            return i12;
        }
        byte b = (byte) this._paddingChar;
        int i13 = i10 + 3;
        bArr[i11] = i6 == 2 ? this._base64ToAsciiB[(i >> 6) & 63] : b;
        int i14 = i10 + 4;
        bArr[i13] = b;
        return i14;
    }

    public String encode(byte[] bArr, boolean z10, String str) {
        int length = bArr.length;
        StringBuilder sb = new StringBuilder((length >> 2) + length + (length >> 3));
        if (z10) {
            sb.append(JsonFactory.DEFAULT_QUOTE_CHAR);
        }
        int maxLineLength = getMaxLineLength() >> 2;
        int i = length - 3;
        int i6 = 0;
        while (i6 <= i) {
            int i10 = i6 + 2;
            int i11 = ((bArr[i6 + 1] & 255) | (bArr[i6] << 8)) << 8;
            i6 += 3;
            encodeBase64Chunk(sb, i11 | (bArr[i10] & 255));
            maxLineLength--;
            if (maxLineLength <= 0) {
                sb.append(str);
                maxLineLength = getMaxLineLength() >> 2;
            }
        }
        int i12 = length - i6;
        if (i12 > 0) {
            int i13 = i6 + 1;
            int i14 = bArr[i6] << 16;
            if (i12 == 2) {
                i14 |= (bArr[i13] & 255) << 8;
            }
            encodeBase64Partial(sb, i14, i12);
        }
        if (z10) {
            sb.append(JsonFactory.DEFAULT_QUOTE_CHAR);
        }
        return sb.toString();
    }

    public Base64Variant(Base64Variant base64Variant, String str, int i) {
        this(base64Variant, str, base64Variant._writePadding, base64Variant._paddingChar, i);
    }

    public Base64Variant(Base64Variant base64Variant, String str, boolean z10, char c, int i) {
        this(base64Variant, str, z10, c, base64Variant._paddingReadBehaviour, i);
    }

    private Base64Variant(Base64Variant base64Variant, String str, boolean z10, char c, PaddingReadBehaviour paddingReadBehaviour, int i) {
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
        this._paddingChar = c;
        this._maxLineLength = i;
        this._paddingReadBehaviour = paddingReadBehaviour;
    }

    private Base64Variant(Base64Variant base64Variant, PaddingReadBehaviour paddingReadBehaviour) {
        this(base64Variant, base64Variant._name, base64Variant._writePadding, base64Variant._paddingChar, paddingReadBehaviour, base64Variant._maxLineLength);
    }
}
