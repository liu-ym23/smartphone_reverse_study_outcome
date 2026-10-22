package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import g5.f;
import java.io.Serializable;
import java.util.Arrays;
import k0.a;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
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

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public enum PaddingReadBehaviour {
        PADDING_FORBIDDEN,
        PADDING_REQUIRED,
        PADDING_ALLOWED
    }

    public Base64Variant(String str, String str2, boolean z10, char c9, int i) {
        int[] iArr = new int[128];
        this._asciiToBase64 = iArr;
        char[] cArr = new char[64];
        this._base64ToAsciiC = cArr;
        this._base64ToAsciiB = new byte[64];
        this._name = str;
        this._writePadding = z10;
        this._paddingChar = c9;
        this._maxLineLength = i;
        int length = str2.length();
        if (length != 64) {
            f.s(a.k(length, "Base64Alphabet length must be exactly 64 (was ", ")"));
            throw null;
        }
        str2.getChars(0, length, cArr, 0);
        Arrays.fill(iArr, -1);
        for (int i3 = 0; i3 < length; i3++) {
            char c10 = this._base64ToAsciiC[i3];
            this._base64ToAsciiB[i3] = (byte) c10;
            this._asciiToBase64[c10] = i3;
        }
        if (z10) {
            this._asciiToBase64[c9] = -2;
        }
        this._paddingReadBehaviour = z10 ? PaddingReadBehaviour.PADDING_REQUIRED : PaddingReadBehaviour.PADDING_FORBIDDEN;
    }

    public void _reportBase64EOF() {
        throw new IllegalArgumentException(missingPaddingMessage());
    }

    public void _reportBase64UnexpectedPadding() {
        throw new IllegalArgumentException(unexpectedPaddingMessage());
    }

    public void _reportInvalidBase64(char c9, int i, String str) {
        String strO;
        if (c9 <= ' ') {
            strO = "Illegal white space character (code 0x" + Integer.toHexString(c9) + ") as character #" + (i + 1) + " of 4-char base64 unit: can only used between units";
        } else if (usesPaddingChar(c9)) {
            strO = "Unexpected padding character ('" + getPaddingChar() + "') as character #" + (i + 1) + " of 4-char base64 unit: padding only legal as 3rd or 4th character";
        } else if (!Character.isDefined(c9) || Character.isISOControl(c9)) {
            strO = "Illegal character (code 0x" + Integer.toHexString(c9) + ") in base64 content";
        } else {
            strO = "Illegal character '" + c9 + "' (code 0x" + Integer.toHexString(c9) + ") in base64 content";
        }
        if (str != null) {
            strO = a.o(strO, ": ", str);
        }
        throw new IllegalArgumentException(strO);
    }

    public boolean acceptsPaddingOnRead() {
        return this._paddingReadBehaviour != PaddingReadBehaviour.PADDING_FORBIDDEN;
    }

    public void decode(String str, ByteArrayBuilder byteArrayBuilder) {
        int length = str.length();
        int i = 0;
        while (i < length) {
            int i3 = i + 1;
            char cCharAt = str.charAt(i);
            if (cCharAt > ' ') {
                int iDecodeBase64Char = decodeBase64Char(cCharAt);
                if (iDecodeBase64Char < 0) {
                    _reportInvalidBase64(cCharAt, 0, null);
                }
                if (i3 >= length) {
                    _reportBase64EOF();
                }
                int i10 = i + 2;
                char cCharAt2 = str.charAt(i3);
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
                i = i3;
            }
        }
    }

    public int decodeBase64Byte(byte b10) {
        if (b10 < 0) {
            return -1;
        }
        return this._asciiToBase64[b10];
    }

    public int decodeBase64Char(char c9) {
        if (c9 <= 127) {
            return this._asciiToBase64[c9];
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
        int i = length - 3;
        int i3 = 0;
        while (i3 <= i) {
            int i10 = i3 + 2;
            int i11 = ((bArr[i3 + 1] & 255) | (bArr[i3] << 8)) << 8;
            i3 += 3;
            encodeBase64Chunk(sb2, i11 | (bArr[i10] & 255));
            maxLineLength--;
            if (maxLineLength <= 0) {
                sb2.append('\\');
                sb2.append('n');
                maxLineLength = getMaxLineLength() >> 2;
            }
        }
        int i12 = length - i3;
        if (i12 > 0) {
            int i13 = i3 + 1;
            int i14 = bArr[i3] << 16;
            if (i12 == 2) {
                i14 |= (bArr[i13] & 255) << 8;
            }
            encodeBase64Partial(sb2, i14, i12);
        }
        if (z10) {
            sb2.append(JsonFactory.DEFAULT_QUOTE_CHAR);
        }
        return sb2.toString();
    }

    public byte encodeBase64BitsAsByte(int i) {
        return this._base64ToAsciiB[i];
    }

    public char encodeBase64BitsAsChar(int i) {
        return this._base64ToAsciiC[i];
    }

    public void encodeBase64Chunk(StringBuilder sb2, int i) {
        sb2.append(this._base64ToAsciiC[(i >> 18) & 63]);
        sb2.append(this._base64ToAsciiC[(i >> 12) & 63]);
        sb2.append(this._base64ToAsciiC[(i >> 6) & 63]);
        sb2.append(this._base64ToAsciiC[i & 63]);
    }

    public int encodeBase64Partial(int i, int i3, char[] cArr, int i10) {
        char[] cArr2 = this._base64ToAsciiC;
        cArr[i10] = cArr2[(i >> 18) & 63];
        int i11 = i10 + 2;
        cArr[i10 + 1] = cArr2[(i >> 12) & 63];
        if (usesPadding()) {
            int i12 = i10 + 3;
            cArr[i11] = i3 == 2 ? this._base64ToAsciiC[(i >> 6) & 63] : this._paddingChar;
            int i13 = i10 + 4;
            cArr[i12] = this._paddingChar;
            return i13;
        }
        if (i3 != 2) {
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

    public Object readResolve() {
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
        return a.C("Unexpected end of base64-encoded String: base64 variant '", getName(), "' expects no padding at the end while decoding. This Base64Variant might have been incorrectly configured");
    }

    public boolean usesPadding() {
        return this._writePadding;
    }

    public boolean usesPaddingChar(char c9) {
        return c9 == this._paddingChar;
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

    public boolean usesPaddingChar(int i) {
        return i == this._paddingChar;
    }

    public int decodeBase64Char(int i) {
        if (i <= 127) {
            return this._asciiToBase64[i];
        }
        return -1;
    }

    public int encodeBase64Chunk(int i, char[] cArr, int i3) {
        char[] cArr2 = this._base64ToAsciiC;
        cArr[i3] = cArr2[(i >> 18) & 63];
        cArr[i3 + 1] = cArr2[(i >> 12) & 63];
        int i10 = i3 + 3;
        cArr[i3 + 2] = cArr2[(i >> 6) & 63];
        int i11 = i3 + 4;
        cArr[i10] = cArr2[i & 63];
        return i11;
    }

    public int encodeBase64Chunk(int i, byte[] bArr, int i3) {
        byte[] bArr2 = this._base64ToAsciiB;
        bArr[i3] = bArr2[(i >> 18) & 63];
        bArr[i3 + 1] = bArr2[(i >> 12) & 63];
        int i10 = i3 + 3;
        bArr[i3 + 2] = bArr2[(i >> 6) & 63];
        int i11 = i3 + 4;
        bArr[i10] = bArr2[i & 63];
        return i11;
    }

    public void encodeBase64Partial(StringBuilder sb2, int i, int i3) {
        sb2.append(this._base64ToAsciiC[(i >> 18) & 63]);
        sb2.append(this._base64ToAsciiC[(i >> 12) & 63]);
        if (usesPadding()) {
            sb2.append(i3 == 2 ? this._base64ToAsciiC[(i >> 6) & 63] : this._paddingChar);
            sb2.append(this._paddingChar);
        } else if (i3 == 2) {
            sb2.append(this._base64ToAsciiC[(i >> 6) & 63]);
        }
    }

    public int encodeBase64Partial(int i, int i3, byte[] bArr, int i10) {
        byte[] bArr2 = this._base64ToAsciiB;
        bArr[i10] = bArr2[(i >> 18) & 63];
        int i11 = i10 + 2;
        bArr[i10 + 1] = bArr2[(i >> 12) & 63];
        if (!usesPadding()) {
            if (i3 != 2) {
                return i11;
            }
            int i12 = i10 + 3;
            bArr[i11] = this._base64ToAsciiB[(i >> 6) & 63];
            return i12;
        }
        byte b10 = (byte) this._paddingChar;
        int i13 = i10 + 3;
        bArr[i11] = i3 == 2 ? this._base64ToAsciiB[(i >> 6) & 63] : b10;
        int i14 = i10 + 4;
        bArr[i13] = b10;
        return i14;
    }

    public Base64Variant(Base64Variant base64Variant, String str, int i) {
        this(base64Variant, str, base64Variant._writePadding, base64Variant._paddingChar, i);
    }

    public Base64Variant(Base64Variant base64Variant, String str, boolean z10, char c9, int i) {
        this(base64Variant, str, z10, c9, base64Variant._paddingReadBehaviour, i);
    }

    private Base64Variant(Base64Variant base64Variant, String str, boolean z10, char c9, PaddingReadBehaviour paddingReadBehaviour, int i) {
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
        this._paddingChar = c9;
        this._maxLineLength = i;
        this._paddingReadBehaviour = paddingReadBehaviour;
    }

    private Base64Variant(Base64Variant base64Variant, PaddingReadBehaviour paddingReadBehaviour) {
        this(base64Variant, base64Variant._name, base64Variant._writePadding, base64Variant._paddingChar, paddingReadBehaviour, base64Variant._maxLineLength);
    }

    public String encode(byte[] bArr) {
        return encode(bArr, false);
    }

    public String encode(byte[] bArr, boolean z10, String str) {
        int length = bArr.length;
        StringBuilder sb2 = new StringBuilder((length >> 2) + length + (length >> 3));
        if (z10) {
            sb2.append(JsonFactory.DEFAULT_QUOTE_CHAR);
        }
        int maxLineLength = getMaxLineLength() >> 2;
        int i = length - 3;
        int i3 = 0;
        while (i3 <= i) {
            int i10 = i3 + 2;
            int i11 = ((bArr[i3 + 1] & 255) | (bArr[i3] << 8)) << 8;
            i3 += 3;
            encodeBase64Chunk(sb2, i11 | (bArr[i10] & 255));
            maxLineLength--;
            if (maxLineLength <= 0) {
                sb2.append(str);
                maxLineLength = getMaxLineLength() >> 2;
            }
        }
        int i12 = length - i3;
        if (i12 > 0) {
            int i13 = i3 + 1;
            int i14 = bArr[i3] << 16;
            if (i12 == 2) {
                i14 |= (bArr[i13] & 255) << 8;
            }
            encodeBase64Partial(sb2, i14, i12);
        }
        if (z10) {
            sb2.append(JsonFactory.DEFAULT_QUOTE_CHAR);
        }
        return sb2.toString();
    }

    public byte[] decode(String str) {
        ByteArrayBuilder byteArrayBuilder = new ByteArrayBuilder();
        decode(str, byteArrayBuilder);
        return byteArrayBuilder.toByteArray();
    }
}
