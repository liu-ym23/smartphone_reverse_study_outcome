package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.PrettyPrinter;
import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.io.CharacterEscapes;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.io.NumberOutput;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.math.BigInteger;

/* loaded from: classes2.dex */
public class UTF8JsonGenerator extends JsonGeneratorImpl {
    private static final byte BYTE_0 = 48;
    private static final byte BYTE_BACKSLASH = 92;
    private static final byte BYTE_COLON = 58;
    private static final byte BYTE_COMMA = 44;
    private static final byte BYTE_LBRACKET = 91;
    private static final byte BYTE_LCURLY = 123;
    private static final byte BYTE_RBRACKET = 93;
    private static final byte BYTE_RCURLY = 125;
    private static final int MAX_BYTES_TO_BUFFER = 512;
    protected boolean _bufferRecyclable;
    protected char[] _charBuffer;
    protected final int _charBufferLength;
    protected byte[] _entityBuffer;
    protected byte[] _outputBuffer;
    protected final int _outputEnd;
    protected final int _outputMaxContiguous;
    protected final OutputStream _outputStream;
    protected int _outputTail;
    protected byte _quoteChar;
    private static final byte[] HEX_BYTES_UPPER = CharTypes.copyHexBytes(true);
    private static final byte[] HEX_BYTES_LOWER = CharTypes.copyHexBytes(false);
    private static final byte BYTE_u = 117;
    private static final byte[] NULL_BYTES = {110, BYTE_u, 108, 108};
    private static final byte[] TRUE_BYTES = {116, 114, BYTE_u, 101};
    private static final byte[] FALSE_BYTES = {102, 97, 108, 115, 101};

    public UTF8JsonGenerator(IOContext iOContext, int i, ObjectCodec objectCodec, OutputStream outputStream, char c) {
        super(iOContext, i, objectCodec);
        this._outputStream = outputStream;
        this._quoteChar = (byte) c;
        boolean zIsEnabled = isEnabled(JsonWriteFeature.ESCAPE_FORWARD_SLASHES.mappedFeature());
        if (c != '\"' || zIsEnabled) {
            this._outputEscapes = CharTypes.get7BitOutputEscapes(c, zIsEnabled);
        }
        this._bufferRecyclable = true;
        byte[] bArrAllocWriteEncodingBuffer = iOContext.allocWriteEncodingBuffer();
        this._outputBuffer = bArrAllocWriteEncodingBuffer;
        int length = bArrAllocWriteEncodingBuffer.length;
        this._outputEnd = length;
        this._outputMaxContiguous = length >> 3;
        char[] cArrAllocConcatBuffer = iOContext.allocConcatBuffer();
        this._charBuffer = cArrAllocConcatBuffer;
        this._charBufferLength = cArrAllocConcatBuffer.length;
        if (isEnabled(JsonWriteFeature.ESCAPE_NON_ASCII.mappedFeature())) {
            setHighestNonEscapedChar(127);
        }
    }

    private final int _handleLongCustomEscape(byte[] bArr, int i, int i6, byte[] bArr2, int i10) throws IOException {
        int length = bArr2.length;
        if (i + length > i6) {
            this._outputTail = i;
            _flushBuffer();
            i = this._outputTail;
            if (length > bArr.length) {
                this._outputStream.write(bArr2, 0, length);
                return i;
            }
        }
        System.arraycopy(bArr2, 0, bArr, i, length);
        int i11 = i + length;
        if ((i10 * 6) + i11 <= i6) {
            return i11;
        }
        this._outputTail = i11;
        _flushBuffer();
        return this._outputTail;
    }

    private static boolean _isStartOfSurrogatePair(int i) {
        return (i & 64512) == 55296;
    }

    private final int _outputMultiByteChar(int i, int i6) throws IOException {
        byte[] hexBytes = getHexBytes();
        byte[] bArr = this._outputBuffer;
        if (i < 55296 || i > 57343) {
            bArr[i6] = (byte) ((i >> 12) | 224);
            int i10 = i6 + 2;
            bArr[i6 + 1] = (byte) (((i >> 6) & 63) | 128);
            int i11 = i6 + 3;
            bArr[i10] = (byte) ((i & 63) | 128);
            return i11;
        }
        bArr[i6] = BYTE_BACKSLASH;
        bArr[i6 + 1] = BYTE_u;
        bArr[i6 + 2] = hexBytes[(i >> 12) & 15];
        bArr[i6 + 3] = hexBytes[(i >> 8) & 15];
        int i12 = i6 + 5;
        bArr[i6 + 4] = hexBytes[(i >> 4) & 15];
        int i13 = i6 + 6;
        bArr[i12] = hexBytes[i & 15];
        return i13;
    }

    private final int _outputRawMultiByteChar(int i, char[] cArr, int i6, int i10) throws IOException {
        if (i >= 55296 && i <= 57343) {
            if (i6 >= i10 || cArr == null) {
                _reportError(String.format("Split surrogate on writeRaw() input (last character): first character 0x%4x", Integer.valueOf(i)));
            } else {
                _outputSurrogates(i, cArr[i6]);
            }
            return i6 + 1;
        }
        byte[] bArr = this._outputBuffer;
        int i11 = this._outputTail;
        int i12 = i11 + 1;
        this._outputTail = i12;
        bArr[i11] = (byte) ((i >> 12) | 224);
        int i13 = i11 + 2;
        this._outputTail = i13;
        bArr[i12] = (byte) (((i >> 6) & 63) | 128);
        this._outputTail = i11 + 3;
        bArr[i13] = (byte) ((i & 63) | 128);
        return i6;
    }

    private int _outputSurrogatePair(char c, char c2, int i) {
        int i6 = ((c & 1023) << 10) + 65536 + (c2 & 1023);
        byte[] bArr = this._outputBuffer;
        bArr[i] = (byte) (((i6 >> 18) & 7) + 240);
        bArr[i + 1] = (byte) (((i6 >> 12) & 63) + 128);
        int i10 = i + 3;
        bArr[i + 2] = (byte) (((i6 >> 6) & 63) + 128);
        int i11 = i + 4;
        bArr[i10] = (byte) ((i6 & 63) + 128);
        return i11;
    }

    private final int _readMore(InputStream inputStream, byte[] bArr, int i, int i6, int i10) throws IOException {
        int i11;
        int i12 = 0;
        while (i < i6) {
            bArr[i12] = bArr[i];
            i12++;
            i++;
        }
        int iMin = Math.min(i10, bArr.length);
        do {
            int i13 = iMin - i12;
            if (i13 == 0 || (i11 = inputStream.read(bArr, i12, i13)) < 0) {
                return i12;
            }
            i12 += i11;
        } while (i12 < 3);
        return i12;
    }

    private final void _writeBytes(byte[] bArr) throws IOException {
        int length = bArr.length;
        if (this._outputTail + length > this._outputEnd) {
            _flushBuffer();
            if (length > 512) {
                this._outputStream.write(bArr, 0, length);
                return;
            }
        }
        System.arraycopy(bArr, 0, this._outputBuffer, this._outputTail, length);
        this._outputTail += length;
    }

    private final int _writeCustomEscape(byte[] bArr, int i, SerializableString serializableString, int i6) throws IOException {
        byte[] bArrAsUnquotedUTF8 = serializableString.asUnquotedUTF8();
        int length = bArrAsUnquotedUTF8.length;
        if (length > 6) {
            return _handleLongCustomEscape(bArr, i, this._outputEnd, bArrAsUnquotedUTF8, i6);
        }
        System.arraycopy(bArrAsUnquotedUTF8, 0, bArr, i, length);
        return i + length;
    }

    private final void _writeCustomStringSegment2(char[] cArr, int i, int i6) throws IOException {
        int i_outputMultiByteChar;
        if (((i6 - i) * 6) + this._outputTail > this._outputEnd) {
            _flushBuffer();
        }
        int i_writeGenericEscape = this._outputTail;
        byte[] bArr = this._outputBuffer;
        int[] iArr = this._outputEscapes;
        int i10 = this._maximumNonEscapedChar;
        if (i10 <= 0) {
            i10 = 65535;
        }
        CharacterEscapes characterEscapes = this._characterEscapes;
        while (i < i6) {
            int i11 = i + 1;
            char c = cArr[i];
            if (c <= 127) {
                int i12 = iArr[c];
                if (i12 == 0) {
                    i_outputMultiByteChar = i_writeGenericEscape + 1;
                    bArr[i_writeGenericEscape] = (byte) c;
                    i_writeGenericEscape = i_outputMultiByteChar;
                    i = i11;
                } else {
                    if (i12 > 0) {
                        int i13 = i_writeGenericEscape + 1;
                        bArr[i_writeGenericEscape] = BYTE_BACKSLASH;
                        i_writeGenericEscape += 2;
                        bArr[i13] = (byte) i12;
                    } else if (i12 == -2) {
                        SerializableString escapeSequence = characterEscapes.getEscapeSequence(c);
                        if (escapeSequence == null) {
                            _reportError("Invalid custom escape definitions; custom escape not found for character code 0x" + Integer.toHexString(c) + ", although was supposed to have one");
                        }
                        i_writeGenericEscape = _writeCustomEscape(bArr, i_writeGenericEscape, escapeSequence, i6 - i11);
                    } else {
                        i_writeGenericEscape = _writeGenericEscape(c, i_writeGenericEscape);
                    }
                    i = i11;
                }
            } else {
                if (c > i10) {
                    i_writeGenericEscape = _writeGenericEscape(c, i_writeGenericEscape);
                } else {
                    SerializableString escapeSequence2 = characterEscapes.getEscapeSequence(c);
                    if (escapeSequence2 != null) {
                        i_writeGenericEscape = _writeCustomEscape(bArr, i_writeGenericEscape, escapeSequence2, i6 - i11);
                    } else if (c <= 2047) {
                        int i14 = i_writeGenericEscape + 1;
                        bArr[i_writeGenericEscape] = (byte) ((c >> 6) | 192);
                        i_writeGenericEscape += 2;
                        bArr[i14] = (byte) ((c & '?') | 128);
                    } else if (_isStartOfSurrogatePair(c) && JsonGenerator.Feature.COMBINE_UNICODE_SURROGATES_IN_UTF8.enabledIn(this._features) && i11 < i6) {
                        i += 2;
                        i_writeGenericEscape = _outputSurrogatePair(c, cArr[i11], i_writeGenericEscape);
                    } else {
                        i_outputMultiByteChar = _outputMultiByteChar(c, i_writeGenericEscape);
                        i_writeGenericEscape = i_outputMultiByteChar;
                    }
                }
                i = i11;
            }
        }
        this._outputTail = i_writeGenericEscape;
    }

    private int _writeGenericEscape(int i, int i6) throws IOException {
        int i10;
        byte[] bArr = this._outputBuffer;
        byte[] hexBytes = getHexBytes();
        bArr[i6] = BYTE_BACKSLASH;
        int i11 = i6 + 2;
        bArr[i6 + 1] = BYTE_u;
        if (i > 255) {
            int i12 = i >> 8;
            int i13 = i6 + 3;
            bArr[i11] = hexBytes[(i12 & 255) >> 4];
            i10 = i6 + 4;
            bArr[i13] = hexBytes[i12 & 15];
            i &= 255;
        } else {
            int i14 = i6 + 3;
            bArr[i11] = BYTE_0;
            i10 = i6 + 4;
            bArr[i14] = BYTE_0;
        }
        int i15 = i10 + 1;
        bArr[i10] = hexBytes[i >> 4];
        int i16 = i10 + 2;
        bArr[i15] = hexBytes[i & 15];
        return i16;
    }

    private final void _writeNull() throws IOException {
        if (this._outputTail + 4 >= this._outputEnd) {
            _flushBuffer();
        }
        System.arraycopy(NULL_BYTES, 0, this._outputBuffer, this._outputTail, 4);
        this._outputTail += 4;
    }

    private final void _writeQuotedInt(int i) throws IOException {
        if (this._outputTail + 13 >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i6 = this._outputTail;
        int i10 = i6 + 1;
        this._outputTail = i10;
        bArr[i6] = this._quoteChar;
        int iOutputInt = NumberOutput.outputInt(i, bArr, i10);
        byte[] bArr2 = this._outputBuffer;
        this._outputTail = iOutputInt + 1;
        bArr2[iOutputInt] = this._quoteChar;
    }

    private final void _writeQuotedLong(long j5) throws IOException {
        if (this._outputTail + 23 >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i = this._outputTail;
        int i6 = i + 1;
        this._outputTail = i6;
        bArr[i] = this._quoteChar;
        int iOutputLong = NumberOutput.outputLong(j5, bArr, i6);
        byte[] bArr2 = this._outputBuffer;
        this._outputTail = iOutputLong + 1;
        bArr2[iOutputLong] = this._quoteChar;
    }

    private final void _writeQuotedRaw(String str) throws IOException {
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        bArr[i] = this._quoteChar;
        writeRaw(str);
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr2 = this._outputBuffer;
        int i6 = this._outputTail;
        this._outputTail = i6 + 1;
        bArr2[i6] = this._quoteChar;
    }

    private final void _writeQuotedShort(short s5) throws IOException {
        if (this._outputTail + 8 >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i = this._outputTail;
        int i6 = i + 1;
        this._outputTail = i6;
        bArr[i] = this._quoteChar;
        int iOutputInt = NumberOutput.outputInt(s5, bArr, i6);
        byte[] bArr2 = this._outputBuffer;
        this._outputTail = iOutputInt + 1;
        bArr2[iOutputInt] = this._quoteChar;
    }

    private void _writeRawSegment(char[] cArr, int i, int i6) throws IOException {
        while (i < i6) {
            do {
                char c = cArr[i];
                if (c > 127) {
                    i++;
                    if (c < 2048) {
                        byte[] bArr = this._outputBuffer;
                        int i10 = this._outputTail;
                        int i11 = i10 + 1;
                        this._outputTail = i11;
                        bArr[i10] = (byte) ((c >> 6) | 192);
                        this._outputTail = i10 + 2;
                        bArr[i11] = (byte) ((c & '?') | 128);
                    } else {
                        i = _outputRawMultiByteChar(c, cArr, i, i6);
                    }
                } else {
                    byte[] bArr2 = this._outputBuffer;
                    int i12 = this._outputTail;
                    this._outputTail = i12 + 1;
                    bArr2[i12] = (byte) c;
                    i++;
                }
            } while (i < i6);
            return;
        }
    }

    private final void _writeSegmentedRaw(char[] cArr, int i, int i6) throws IOException {
        int i10 = this._outputEnd;
        byte[] bArr = this._outputBuffer;
        int i11 = i6 + i;
        while (i < i11) {
            do {
                char c = cArr[i];
                if (c > 127) {
                    if (this._outputTail + 3 >= this._outputEnd) {
                        _flushBuffer();
                    }
                    int i12 = i + 1;
                    char c2 = cArr[i];
                    if (c2 < 2048) {
                        int i13 = this._outputTail;
                        int i14 = i13 + 1;
                        this._outputTail = i14;
                        bArr[i13] = (byte) ((c2 >> 6) | 192);
                        this._outputTail = i13 + 2;
                        bArr[i14] = (byte) ((c2 & '?') | 128);
                        i = i12;
                    } else {
                        i = _outputRawMultiByteChar(c2, cArr, i12, i11);
                    }
                } else {
                    if (this._outputTail >= i10) {
                        _flushBuffer();
                    }
                    int i15 = this._outputTail;
                    this._outputTail = i15 + 1;
                    bArr[i15] = (byte) c;
                    i++;
                }
            } while (i < i11);
            return;
        }
    }

    private final void _writeStringSegment(char[] cArr, int i, int i6) throws IOException {
        int i10 = i6 + i;
        int i11 = this._outputTail;
        byte[] bArr = this._outputBuffer;
        int[] iArr = this._outputEscapes;
        while (i < i10) {
            char c = cArr[i];
            if (c > 127 || iArr[c] != 0) {
                break;
            }
            bArr[i11] = (byte) c;
            i++;
            i11++;
        }
        this._outputTail = i11;
        if (i < i10) {
            if (this._characterEscapes != null) {
                _writeCustomStringSegment2(cArr, i, i10);
            } else if (this._maximumNonEscapedChar == 0) {
                _writeStringSegment2(cArr, i, i10);
            } else {
                _writeStringSegmentASCII2(cArr, i, i10);
            }
        }
    }

    private final void _writeStringSegment2(char[] cArr, int i, int i6) throws IOException {
        int i_outputMultiByteChar;
        if (((i6 - i) * 6) + this._outputTail > this._outputEnd) {
            _flushBuffer();
        }
        int i_writeGenericEscape = this._outputTail;
        byte[] bArr = this._outputBuffer;
        int[] iArr = this._outputEscapes;
        while (i < i6) {
            int i10 = i + 1;
            char c = cArr[i];
            if (c <= 127) {
                int i11 = iArr[c];
                if (i11 == 0) {
                    i_outputMultiByteChar = i_writeGenericEscape + 1;
                    bArr[i_writeGenericEscape] = (byte) c;
                    i_writeGenericEscape = i_outputMultiByteChar;
                    i = i10;
                } else {
                    if (i11 > 0) {
                        int i12 = i_writeGenericEscape + 1;
                        bArr[i_writeGenericEscape] = BYTE_BACKSLASH;
                        i_writeGenericEscape += 2;
                        bArr[i12] = (byte) i11;
                    } else {
                        i_writeGenericEscape = _writeGenericEscape(c, i_writeGenericEscape);
                    }
                    i = i10;
                }
            } else if (c <= 2047) {
                int i13 = i_writeGenericEscape + 1;
                bArr[i_writeGenericEscape] = (byte) ((c >> 6) | 192);
                i_writeGenericEscape += 2;
                bArr[i13] = (byte) ((c & '?') | 128);
                i = i10;
            } else if (_isStartOfSurrogatePair(c) && JsonGenerator.Feature.COMBINE_UNICODE_SURROGATES_IN_UTF8.enabledIn(this._features) && i10 < i6) {
                i += 2;
                i_writeGenericEscape = _outputSurrogatePair(c, cArr[i10], i_writeGenericEscape);
            } else {
                i_outputMultiByteChar = _outputMultiByteChar(c, i_writeGenericEscape);
                i_writeGenericEscape = i_outputMultiByteChar;
                i = i10;
            }
        }
        this._outputTail = i_writeGenericEscape;
    }

    private final void _writeStringSegmentASCII2(char[] cArr, int i, int i6) throws IOException {
        if (((i6 - i) * 6) + this._outputTail > this._outputEnd) {
            _flushBuffer();
        }
        int i_outputMultiByteChar = this._outputTail;
        byte[] bArr = this._outputBuffer;
        int[] iArr = this._outputEscapes;
        int i10 = this._maximumNonEscapedChar;
        while (i < i6) {
            int i11 = i + 1;
            char c = cArr[i];
            if (c <= 127) {
                int i12 = iArr[c];
                if (i12 == 0) {
                    bArr[i_outputMultiByteChar] = (byte) c;
                    i = i11;
                    i_outputMultiByteChar++;
                } else if (i12 > 0) {
                    int i13 = i_outputMultiByteChar + 1;
                    bArr[i_outputMultiByteChar] = BYTE_BACKSLASH;
                    i_outputMultiByteChar += 2;
                    bArr[i13] = (byte) i12;
                } else {
                    i_outputMultiByteChar = _writeGenericEscape(c, i_outputMultiByteChar);
                }
            } else if (c > i10) {
                i_outputMultiByteChar = _writeGenericEscape(c, i_outputMultiByteChar);
            } else if (c <= 2047) {
                int i14 = i_outputMultiByteChar + 1;
                bArr[i_outputMultiByteChar] = (byte) ((c >> 6) | 192);
                i_outputMultiByteChar += 2;
                bArr[i14] = (byte) ((c & '?') | 128);
            } else {
                i_outputMultiByteChar = _outputMultiByteChar(c, i_outputMultiByteChar);
            }
            i = i11;
        }
        this._outputTail = i_outputMultiByteChar;
    }

    private final void _writeStringSegments(String str, boolean z10) throws IOException {
        if (z10) {
            if (this._outputTail >= this._outputEnd) {
                _flushBuffer();
            }
            byte[] bArr = this._outputBuffer;
            int i = this._outputTail;
            this._outputTail = i + 1;
            bArr[i] = this._quoteChar;
        }
        int length = str.length();
        int i6 = 0;
        while (length > 0) {
            int iMin = Math.min(this._outputMaxContiguous, length);
            if (this._outputTail + iMin > this._outputEnd) {
                _flushBuffer();
            }
            _writeStringSegment(str, i6, iMin);
            i6 += iMin;
            length -= iMin;
        }
        if (z10) {
            if (this._outputTail >= this._outputEnd) {
                _flushBuffer();
            }
            byte[] bArr2 = this._outputBuffer;
            int i10 = this._outputTail;
            this._outputTail = i10 + 1;
            bArr2[i10] = this._quoteChar;
        }
    }

    private final void _writeUTF8Segment(byte[] bArr, int i, int i6) throws IOException {
        int[] iArr = this._outputEscapes;
        int i10 = i + i6;
        int i11 = i;
        while (i11 < i10) {
            int i12 = i11 + 1;
            byte b = bArr[i11];
            if (b >= 0 && iArr[b] != 0) {
                _writeUTF8Segment2(bArr, i, i6);
                return;
            }
            i11 = i12;
        }
        if (this._outputTail + i6 > this._outputEnd) {
            _flushBuffer();
        }
        System.arraycopy(bArr, i, this._outputBuffer, this._outputTail, i6);
        this._outputTail += i6;
    }

    private final void _writeUTF8Segment2(byte[] bArr, int i, int i6) throws IOException {
        int i10;
        int i_writeGenericEscape = this._outputTail;
        if ((i6 * 6) + i_writeGenericEscape > this._outputEnd) {
            _flushBuffer();
            i_writeGenericEscape = this._outputTail;
        }
        byte[] bArr2 = this._outputBuffer;
        int[] iArr = this._outputEscapes;
        int i11 = i6 + i;
        while (i < i11) {
            int i12 = i + 1;
            byte b = bArr[i];
            if (b < 0 || (i10 = iArr[b]) == 0) {
                bArr2[i_writeGenericEscape] = b;
                i = i12;
                i_writeGenericEscape++;
            } else {
                if (i10 > 0) {
                    int i13 = i_writeGenericEscape + 1;
                    bArr2[i_writeGenericEscape] = BYTE_BACKSLASH;
                    i_writeGenericEscape += 2;
                    bArr2[i13] = (byte) i10;
                } else {
                    i_writeGenericEscape = _writeGenericEscape(b, i_writeGenericEscape);
                }
                i = i12;
            }
        }
        this._outputTail = i_writeGenericEscape;
    }

    private final void _writeUTF8Segments(byte[] bArr, int i, int i6) throws IOException {
        do {
            int iMin = Math.min(this._outputMaxContiguous, i6);
            _writeUTF8Segment(bArr, i, iMin);
            i += iMin;
            i6 -= iMin;
        } while (i6 > 0);
    }

    private final void _writeUnq(SerializableString serializableString) throws IOException {
        int iAppendQuotedUTF8 = serializableString.appendQuotedUTF8(this._outputBuffer, this._outputTail);
        if (iAppendQuotedUTF8 < 0) {
            _writeBytes(serializableString.asQuotedUTF8());
        } else {
            this._outputTail += iAppendQuotedUTF8;
        }
    }

    private byte[] getHexBytes() {
        return this._cfgWriteHexUppercase ? HEX_BYTES_UPPER : HEX_BYTES_LOWER;
    }

    public final void _flushBuffer() throws IOException {
        int i = this._outputTail;
        if (i > 0) {
            this._outputTail = 0;
            this._outputStream.write(this._outputBuffer, 0, i);
        }
    }

    public final void _outputSurrogates(int i, int i6) throws IOException {
        int i_decodeSurrogate = _decodeSurrogate(i, i6);
        if (this._outputTail + 4 > this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i10 = this._outputTail;
        int i11 = i10 + 1;
        this._outputTail = i11;
        bArr[i10] = (byte) ((i_decodeSurrogate >> 18) | 240);
        int i12 = i10 + 2;
        this._outputTail = i12;
        bArr[i11] = (byte) (((i_decodeSurrogate >> 12) & 63) | 128);
        int i13 = i10 + 3;
        this._outputTail = i13;
        bArr[i12] = (byte) (((i_decodeSurrogate >> 6) & 63) | 128);
        this._outputTail = i10 + 4;
        bArr[i13] = (byte) ((i_decodeSurrogate & 63) | 128);
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase
    public void _releaseBuffers() {
        byte[] bArr = this._outputBuffer;
        if (bArr != null && this._bufferRecyclable) {
            this._outputBuffer = null;
            this._ioContext.releaseWriteEncodingBuffer(bArr);
        }
        char[] cArr = this._charBuffer;
        if (cArr != null) {
            this._charBuffer = null;
            this._ioContext.releaseConcatBuffer(cArr);
        }
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase
    public final void _verifyValueWrite(String str) throws IOException {
        byte b;
        int iWriteValue = this._writeContext.writeValue();
        if (this._cfgPrettyPrinter != null) {
            _verifyPrettyValueWrite(str, iWriteValue);
            return;
        }
        if (iWriteValue == 1) {
            b = BYTE_COMMA;
        } else {
            if (iWriteValue != 2) {
                if (iWriteValue != 3) {
                    if (iWriteValue != 5) {
                        return;
                    }
                    _reportCantWriteValueExpectName(str);
                    return;
                }
                SerializableString serializableString = this._rootValueSeparator;
                if (serializableString != null) {
                    byte[] bArrAsUnquotedUTF8 = serializableString.asUnquotedUTF8();
                    if (bArrAsUnquotedUTF8.length > 0) {
                        _writeBytes(bArrAsUnquotedUTF8);
                        return;
                    }
                    return;
                }
                return;
            }
            b = BYTE_COLON;
        }
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        bArr[i] = b;
    }

    public final void _writeBinary(Base64Variant base64Variant, byte[] bArr, int i, int i6) throws IOException {
        int iEncodeBase64Chunk;
        int i10 = i6 - 3;
        int i11 = this._outputEnd - 6;
        int maxLineLength = base64Variant.getMaxLineLength();
        loop0: while (true) {
            int i12 = maxLineLength >> 2;
            while (i <= i10) {
                if (this._outputTail > i11) {
                    _flushBuffer();
                }
                int i13 = i + 2;
                int i14 = ((bArr[i + 1] & 255) | (bArr[i] << 8)) << 8;
                i += 3;
                iEncodeBase64Chunk = base64Variant.encodeBase64Chunk(i14 | (bArr[i13] & 255), this._outputBuffer, this._outputTail);
                this._outputTail = iEncodeBase64Chunk;
                i12--;
                if (i12 <= 0) {
                    break;
                }
            }
            byte[] bArr2 = this._outputBuffer;
            int i15 = iEncodeBase64Chunk + 1;
            this._outputTail = i15;
            bArr2[iEncodeBase64Chunk] = BYTE_BACKSLASH;
            this._outputTail = iEncodeBase64Chunk + 2;
            bArr2[i15] = 110;
            maxLineLength = base64Variant.getMaxLineLength();
        }
        int i16 = i6 - i;
        if (i16 > 0) {
            if (this._outputTail > i11) {
                _flushBuffer();
            }
            int i17 = i + 1;
            int i18 = bArr[i] << 16;
            if (i16 == 2) {
                i18 |= (bArr[i17] & 255) << 8;
            }
            this._outputTail = base64Variant.encodeBase64Partial(i18, i16, this._outputBuffer, this._outputTail);
        }
    }

    public final void _writePPFieldName(String str) throws IOException {
        int iWriteFieldName = this._writeContext.writeFieldName(str);
        if (iWriteFieldName == 4) {
            _reportError("Can not write a field name, expecting a value");
        }
        if (iWriteFieldName == 1) {
            this._cfgPrettyPrinter.writeObjectEntrySeparator(this);
        } else {
            this._cfgPrettyPrinter.beforeObjectEntries(this);
        }
        if (this._cfgUnqNames) {
            _writeStringSegments(str, false);
            return;
        }
        int length = str.length();
        if (length > this._charBufferLength) {
            _writeStringSegments(str, true);
            return;
        }
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        bArr[i] = this._quoteChar;
        str.getChars(0, length, this._charBuffer, 0);
        if (length <= this._outputMaxContiguous) {
            if (this._outputTail + length > this._outputEnd) {
                _flushBuffer();
            }
            _writeStringSegment(this._charBuffer, 0, length);
        } else {
            _writeStringSegments(this._charBuffer, 0, length);
        }
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr2 = this._outputBuffer;
        int i6 = this._outputTail;
        this._outputTail = i6 + 1;
        bArr2[i6] = this._quoteChar;
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase, com.fasterxml.jackson.core.JsonGenerator, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        super.close();
        try {
            if (this._outputBuffer != null && isEnabled(JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT)) {
                while (true) {
                    JsonStreamContext outputContext = getOutputContext();
                    if (!outputContext.inArray()) {
                        if (!outputContext.inObject()) {
                            break;
                        } else {
                            writeEndObject();
                        }
                    } else {
                        writeEndArray();
                    }
                }
            }
            _flushBuffer();
            e = null;
        } catch (IOException e) {
            e = e;
        }
        this._outputTail = 0;
        if (this._outputStream != null) {
            try {
                if (this._ioContext.isResourceManaged() || isEnabled(JsonGenerator.Feature.AUTO_CLOSE_TARGET)) {
                    this._outputStream.close();
                } else if (isEnabled(JsonGenerator.Feature.FLUSH_PASSED_TO_STREAM)) {
                    this._outputStream.flush();
                }
            } catch (IOException | RuntimeException e6) {
                if (e != null) {
                    e6.addSuppressed(e);
                }
                throw e6;
            }
        }
        _releaseBuffers();
        if (e != null) {
            throw e;
        }
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase, com.fasterxml.jackson.core.JsonGenerator, java.io.Flushable
    public void flush() throws IOException {
        _flushBuffer();
        if (this._outputStream == null || !isEnabled(JsonGenerator.Feature.FLUSH_PASSED_TO_STREAM)) {
            return;
        }
        this._outputStream.flush();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public int getOutputBuffered() {
        return this._outputTail;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public Object getOutputTarget() {
        return this._outputStream;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeBinary(Base64Variant base64Variant, byte[] bArr, int i, int i6) throws IOException {
        _checkRangeBoundsForByteArray(bArr, i, i6);
        _verifyValueWrite("write a binary value");
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr2 = this._outputBuffer;
        int i10 = this._outputTail;
        this._outputTail = i10 + 1;
        bArr2[i10] = this._quoteChar;
        _writeBinary(base64Variant, bArr, i, i6 + i);
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr3 = this._outputBuffer;
        int i11 = this._outputTail;
        this._outputTail = i11 + 1;
        bArr3[i11] = this._quoteChar;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeBoolean(boolean z10) throws IOException {
        _verifyValueWrite("write a boolean value");
        if (this._outputTail + 5 >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = z10 ? TRUE_BYTES : FALSE_BYTES;
        int length = bArr.length;
        System.arraycopy(bArr, 0, this._outputBuffer, this._outputTail, length);
        this._outputTail += length;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void writeEndArray() throws IOException {
        if (!this._writeContext.inArray()) {
            _reportError("Current context not Array but " + this._writeContext.typeDesc());
        }
        PrettyPrinter prettyPrinter = this._cfgPrettyPrinter;
        if (prettyPrinter != null) {
            prettyPrinter.writeEndArray(this, this._writeContext.getEntryCount());
        } else {
            if (this._outputTail >= this._outputEnd) {
                _flushBuffer();
            }
            byte[] bArr = this._outputBuffer;
            int i = this._outputTail;
            this._outputTail = i + 1;
            bArr[i] = BYTE_RBRACKET;
        }
        this._writeContext = this._writeContext.clearAndGetParent();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void writeEndObject() throws IOException {
        if (!this._writeContext.inObject()) {
            _reportError("Current context not Object but " + this._writeContext.typeDesc());
        }
        PrettyPrinter prettyPrinter = this._cfgPrettyPrinter;
        if (prettyPrinter != null) {
            prettyPrinter.writeEndObject(this, this._writeContext.getEntryCount());
        } else {
            if (this._outputTail >= this._outputEnd) {
                _flushBuffer();
            }
            byte[] bArr = this._outputBuffer;
            int i = this._outputTail;
            this._outputTail = i + 1;
            bArr[i] = BYTE_RCURLY;
        }
        this._writeContext = this._writeContext.clearAndGetParent();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeFieldName(String str) throws IOException {
        if (this._cfgPrettyPrinter != null) {
            _writePPFieldName(str);
            return;
        }
        int iWriteFieldName = this._writeContext.writeFieldName(str);
        if (iWriteFieldName == 4) {
            _reportError("Can not write a field name, expecting a value");
        }
        if (iWriteFieldName == 1) {
            if (this._outputTail >= this._outputEnd) {
                _flushBuffer();
            }
            byte[] bArr = this._outputBuffer;
            int i = this._outputTail;
            this._outputTail = i + 1;
            bArr[i] = BYTE_COMMA;
        }
        if (this._cfgUnqNames) {
            _writeStringSegments(str, false);
            return;
        }
        int length = str.length();
        if (length > this._charBufferLength) {
            _writeStringSegments(str, true);
            return;
        }
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr2 = this._outputBuffer;
        int i6 = this._outputTail;
        int i10 = i6 + 1;
        this._outputTail = i10;
        bArr2[i6] = this._quoteChar;
        if (length <= this._outputMaxContiguous) {
            if (i10 + length > this._outputEnd) {
                _flushBuffer();
            }
            _writeStringSegment(str, 0, length);
        } else {
            _writeStringSegments(str, 0, length);
        }
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr3 = this._outputBuffer;
        int i11 = this._outputTail;
        this._outputTail = i11 + 1;
        bArr3[i11] = this._quoteChar;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNull() throws IOException {
        _verifyValueWrite("write a null");
        _writeNull();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(short s5) throws IOException {
        _verifyValueWrite("write a number");
        if (this._outputTail + 6 >= this._outputEnd) {
            _flushBuffer();
        }
        if (this._cfgNumbersAsStrings) {
            _writeQuotedShort(s5);
        } else {
            this._outputTail = NumberOutput.outputInt(s5, this._outputBuffer, this._outputTail);
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeRaw(String str) throws IOException {
        int length = str.length();
        char[] cArr = this._charBuffer;
        if (length > cArr.length) {
            writeRaw(str, 0, length);
        } else {
            str.getChars(0, length, cArr, 0);
            writeRaw(cArr, 0, length);
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeRawUTF8String(byte[] bArr, int i, int i6) throws IOException {
        _checkRangeBoundsForByteArray(bArr, i, i6);
        _verifyValueWrite("write a string");
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr2 = this._outputBuffer;
        int i10 = this._outputTail;
        this._outputTail = i10 + 1;
        bArr2[i10] = this._quoteChar;
        _writeBytes(bArr, i, i6);
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr3 = this._outputBuffer;
        int i11 = this._outputTail;
        this._outputTail = i11 + 1;
        bArr3[i11] = this._quoteChar;
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase, com.fasterxml.jackson.core.JsonGenerator
    public void writeRawValue(SerializableString serializableString) throws IOException {
        _verifyValueWrite("write a raw (unencoded) value");
        int iAppendUnquotedUTF8 = serializableString.appendUnquotedUTF8(this._outputBuffer, this._outputTail);
        if (iAppendUnquotedUTF8 < 0) {
            _writeBytes(serializableString.asUnquotedUTF8());
        } else {
            this._outputTail += iAppendUnquotedUTF8;
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void writeStartArray() throws IOException {
        _verifyValueWrite("start an array");
        this._writeContext = this._writeContext.createChildArrayContext();
        streamWriteConstraints().validateNestingDepth(this._writeContext.getNestingDepth());
        PrettyPrinter prettyPrinter = this._cfgPrettyPrinter;
        if (prettyPrinter != null) {
            prettyPrinter.writeStartArray(this);
            return;
        }
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        bArr[i] = BYTE_LBRACKET;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void writeStartObject() throws IOException {
        _verifyValueWrite("start an object");
        this._writeContext = this._writeContext.createChildObjectContext();
        streamWriteConstraints().validateNestingDepth(this._writeContext.getNestingDepth());
        PrettyPrinter prettyPrinter = this._cfgPrettyPrinter;
        if (prettyPrinter != null) {
            prettyPrinter.writeStartObject(this);
            return;
        }
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        bArr[i] = BYTE_LCURLY;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeString(String str) throws IOException {
        _verifyValueWrite("write a string");
        if (str == null) {
            _writeNull();
            return;
        }
        int length = str.length();
        if (length > this._outputMaxContiguous) {
            _writeStringSegments(str, true);
            return;
        }
        if (this._outputTail + length >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        bArr[i] = this._quoteChar;
        _writeStringSegment(str, 0, length);
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr2 = this._outputBuffer;
        int i6 = this._outputTail;
        this._outputTail = i6 + 1;
        bArr2[i6] = this._quoteChar;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeUTF8String(byte[] bArr, int i, int i6) throws IOException {
        _checkRangeBoundsForByteArray(bArr, i, i6);
        _verifyValueWrite("write a string");
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr2 = this._outputBuffer;
        int i10 = this._outputTail;
        this._outputTail = i10 + 1;
        bArr2[i10] = this._quoteChar;
        if (i6 <= this._outputMaxContiguous) {
            _writeUTF8Segment(bArr, i, i6);
        } else {
            _writeUTF8Segments(bArr, i, i6);
        }
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr3 = this._outputBuffer;
        int i11 = this._outputTail;
        this._outputTail = i11 + 1;
        bArr3[i11] = this._quoteChar;
    }

    private final void _writeBytes(byte[] bArr, int i, int i6) throws IOException {
        if (this._outputTail + i6 > this._outputEnd) {
            _flushBuffer();
            if (i6 > 512) {
                this._outputStream.write(bArr, i, i6);
                return;
            }
        }
        System.arraycopy(bArr, i, this._outputBuffer, this._outputTail, i6);
        this._outputTail += i6;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(int i) throws IOException {
        _verifyValueWrite("write a number");
        if (this._outputTail + 11 >= this._outputEnd) {
            _flushBuffer();
        }
        if (this._cfgNumbersAsStrings) {
            _writeQuotedInt(i);
        } else {
            this._outputTail = NumberOutput.outputInt(i, this._outputBuffer, this._outputTail);
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeRaw(String str, int i, int i6) throws IOException {
        char c;
        _checkRangeBoundsForString(str, i, i6);
        char[] cArr = this._charBuffer;
        int length = cArr.length;
        if (i6 <= length) {
            str.getChars(i, i + i6, cArr, 0);
            writeRaw(cArr, 0, i6);
            return;
        }
        int i10 = this._outputEnd;
        int iMin = Math.min(length, (i10 >> 2) + (i10 >> 4));
        int i11 = iMin * 3;
        while (i6 > 0) {
            int iMin2 = Math.min(iMin, i6);
            str.getChars(i, i + iMin2, cArr, 0);
            if (this._outputTail + i11 > this._outputEnd) {
                _flushBuffer();
            }
            if (iMin2 > 1 && (c = cArr[iMin2 - 1]) >= 55296 && c <= 56319) {
                iMin2--;
            }
            _writeRawSegment(cArr, 0, iMin2);
            i += iMin2;
            i6 -= iMin2;
        }
    }

    private void _writeQuotedRaw(char[] cArr, int i, int i6) throws IOException {
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i10 = this._outputTail;
        this._outputTail = i10 + 1;
        bArr[i10] = this._quoteChar;
        writeRaw(cArr, i, i6);
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr2 = this._outputBuffer;
        int i11 = this._outputTail;
        this._outputTail = i11 + 1;
        bArr2[i11] = this._quoteChar;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void writeStartArray(Object obj) throws IOException {
        _verifyValueWrite("start an array");
        this._writeContext = this._writeContext.createChildArrayContext(obj);
        streamWriteConstraints().validateNestingDepth(this._writeContext.getNestingDepth());
        PrettyPrinter prettyPrinter = this._cfgPrettyPrinter;
        if (prettyPrinter != null) {
            prettyPrinter.writeStartArray(this);
            return;
        }
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        bArr[i] = BYTE_LBRACKET;
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase, com.fasterxml.jackson.core.JsonGenerator
    public void writeStartObject(Object obj) throws IOException {
        _verifyValueWrite("start an object");
        JsonWriteContext jsonWriteContextCreateChildObjectContext = this._writeContext.createChildObjectContext(obj);
        streamWriteConstraints().validateNestingDepth(jsonWriteContextCreateChildObjectContext.getNestingDepth());
        this._writeContext = jsonWriteContextCreateChildObjectContext;
        PrettyPrinter prettyPrinter = this._cfgPrettyPrinter;
        if (prettyPrinter != null) {
            prettyPrinter.writeStartObject(this);
            return;
        }
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        bArr[i] = BYTE_LCURLY;
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase, com.fasterxml.jackson.core.JsonGenerator
    public int writeBinary(Base64Variant base64Variant, InputStream inputStream, int i) throws IOException {
        _verifyValueWrite("write a binary value");
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i6 = this._outputTail;
        this._outputTail = i6 + 1;
        bArr[i6] = this._quoteChar;
        byte[] bArrAllocBase64Buffer = this._ioContext.allocBase64Buffer();
        try {
            if (i < 0) {
                i = _writeBinary(base64Variant, inputStream, bArrAllocBase64Buffer);
            } else {
                int i_writeBinary = _writeBinary(base64Variant, inputStream, bArrAllocBase64Buffer, i);
                if (i_writeBinary > 0) {
                    _reportError("Too few bytes available: missing " + i_writeBinary + " bytes (out of " + i + ")");
                }
            }
            this._ioContext.releaseBase64Buffer(bArrAllocBase64Buffer);
            if (this._outputTail >= this._outputEnd) {
                _flushBuffer();
            }
            byte[] bArr2 = this._outputBuffer;
            int i10 = this._outputTail;
            this._outputTail = i10 + 1;
            bArr2[i10] = this._quoteChar;
            return i;
        } catch (Throwable th) {
            this._ioContext.releaseBase64Buffer(bArrAllocBase64Buffer);
            throw th;
        }
    }

    private final void _writeStringSegments(char[] cArr, int i, int i6) throws IOException {
        do {
            int iMin = Math.min(this._outputMaxContiguous, i6);
            if (this._outputTail + iMin > this._outputEnd) {
                _flushBuffer();
            }
            _writeStringSegment(cArr, i, iMin);
            i += iMin;
            i6 -= iMin;
        } while (i6 > 0);
    }

    private final void _writeStringSegment(String str, int i, int i6) throws IOException {
        int i10 = i6 + i;
        int i11 = this._outputTail;
        byte[] bArr = this._outputBuffer;
        int[] iArr = this._outputEscapes;
        while (i < i10) {
            char cCharAt = str.charAt(i);
            if (cCharAt > 127 || iArr[cCharAt] != 0) {
                break;
            }
            bArr[i11] = (byte) cCharAt;
            i++;
            i11++;
        }
        this._outputTail = i11;
        if (i < i10) {
            if (this._characterEscapes != null) {
                _writeCustomStringSegment2(str, i, i10);
            } else if (this._maximumNonEscapedChar == 0) {
                _writeStringSegment2(str, i, i10);
            } else {
                _writeStringSegmentASCII2(str, i, i10);
            }
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(long j5) throws IOException {
        _verifyValueWrite("write a number");
        if (this._cfgNumbersAsStrings) {
            _writeQuotedLong(j5);
            return;
        }
        if (this._outputTail + 21 >= this._outputEnd) {
            _flushBuffer();
        }
        this._outputTail = NumberOutput.outputLong(j5, this._outputBuffer, this._outputTail);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeString(Reader reader, int i) throws IOException {
        _verifyValueWrite("write a string");
        if (reader == null) {
            _reportError("null reader");
            return;
        }
        int i6 = i >= 0 ? i : Integer.MAX_VALUE;
        char[] cArr = this._charBuffer;
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i10 = this._outputTail;
        this._outputTail = i10 + 1;
        bArr[i10] = this._quoteChar;
        while (i6 > 0) {
            int i11 = reader.read(cArr, 0, Math.min(i6, cArr.length));
            if (i11 <= 0) {
                break;
            }
            if (this._outputTail + i >= this._outputEnd) {
                _flushBuffer();
            }
            _writeStringSegments(cArr, 0, i11);
            i6 -= i11;
        }
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr2 = this._outputBuffer;
        int i12 = this._outputTail;
        this._outputTail = i12 + 1;
        bArr2[i12] = this._quoteChar;
        if (i6 <= 0 || i < 0) {
            return;
        }
        _reportError("Didn't read enough from reader");
    }

    public UTF8JsonGenerator(IOContext iOContext, int i, ObjectCodec objectCodec, OutputStream outputStream, char c, byte[] bArr, int i6, boolean z10) {
        super(iOContext, i, objectCodec);
        this._outputStream = outputStream;
        this._quoteChar = (byte) c;
        boolean zIsEnabled = isEnabled(JsonWriteFeature.ESCAPE_FORWARD_SLASHES.mappedFeature());
        if (c != '\"' || zIsEnabled) {
            this._outputEscapes = CharTypes.get7BitOutputEscapes(c, zIsEnabled);
        }
        this._bufferRecyclable = z10;
        this._outputTail = i6;
        this._outputBuffer = bArr;
        int length = bArr.length;
        this._outputEnd = length;
        this._outputMaxContiguous = length >> 3;
        char[] cArrAllocConcatBuffer = iOContext.allocConcatBuffer();
        this._charBuffer = cArrAllocConcatBuffer;
        this._charBufferLength = cArrAllocConcatBuffer.length;
    }

    private final void _writeStringSegments(String str, int i, int i6) throws IOException {
        do {
            int iMin = Math.min(this._outputMaxContiguous, i6);
            if (this._outputTail + iMin > this._outputEnd) {
                _flushBuffer();
            }
            _writeStringSegment(str, i, iMin);
            i += iMin;
            i6 -= iMin;
        } while (i6 > 0);
    }

    public final int _writeBinary(Base64Variant base64Variant, InputStream inputStream, byte[] bArr, int i) throws IOException {
        UTF8JsonGenerator uTF8JsonGenerator;
        InputStream inputStream2;
        byte[] bArr2;
        int i_readMore;
        int i6 = this._outputEnd - 6;
        int i10 = 2;
        int maxLineLength = base64Variant.getMaxLineLength() >> 2;
        int i11 = -3;
        int i12 = i;
        int i13 = 0;
        int i_readMore2 = 0;
        while (true) {
            if (i12 <= 2) {
                uTF8JsonGenerator = this;
                inputStream2 = inputStream;
                bArr2 = bArr;
                break;
            }
            uTF8JsonGenerator = this;
            inputStream2 = inputStream;
            bArr2 = bArr;
            if (i13 > i11) {
                i_readMore2 = uTF8JsonGenerator._readMore(inputStream2, bArr2, i13, i_readMore2, i12);
                if (i_readMore2 < 3) {
                    i13 = 0;
                    break;
                }
                i11 = i_readMore2 - 3;
                i13 = 0;
            }
            if (uTF8JsonGenerator._outputTail > i6) {
                uTF8JsonGenerator._flushBuffer();
            }
            int i14 = i13 + 2;
            int i15 = ((bArr2[i13 + 1] & 255) | (bArr2[i13] << 8)) << 8;
            i13 += 3;
            i12 -= 3;
            int iEncodeBase64Chunk = base64Variant.encodeBase64Chunk(i15 | (bArr2[i14] & 255), uTF8JsonGenerator._outputBuffer, uTF8JsonGenerator._outputTail);
            uTF8JsonGenerator._outputTail = iEncodeBase64Chunk;
            maxLineLength--;
            if (maxLineLength <= 0) {
                byte[] bArr3 = uTF8JsonGenerator._outputBuffer;
                int i16 = iEncodeBase64Chunk + 1;
                uTF8JsonGenerator._outputTail = i16;
                bArr3[iEncodeBase64Chunk] = BYTE_BACKSLASH;
                uTF8JsonGenerator._outputTail = iEncodeBase64Chunk + 2;
                bArr3[i16] = 110;
                maxLineLength = base64Variant.getMaxLineLength() >> 2;
            }
            this = uTF8JsonGenerator;
            inputStream = inputStream2;
            bArr = bArr2;
        }
        if (i12 <= 0 || (i_readMore = uTF8JsonGenerator._readMore(inputStream2, bArr2, i13, i_readMore2, i12)) <= 0) {
            return i12;
        }
        if (uTF8JsonGenerator._outputTail > i6) {
            uTF8JsonGenerator._flushBuffer();
        }
        int i17 = bArr2[0] << 16;
        if (1 < i_readMore) {
            i17 |= (bArr2[1] & 255) << 8;
        } else {
            i10 = 1;
        }
        uTF8JsonGenerator._outputTail = base64Variant.encodeBase64Partial(i17, i10, uTF8JsonGenerator._outputBuffer, uTF8JsonGenerator._outputTail);
        return i12 - i10;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeStartArray(Object obj, int i) throws IOException {
        _verifyValueWrite("start an array");
        this._writeContext = this._writeContext.createChildArrayContext(obj);
        streamWriteConstraints().validateNestingDepth(this._writeContext.getNestingDepth());
        PrettyPrinter prettyPrinter = this._cfgPrettyPrinter;
        if (prettyPrinter != null) {
            prettyPrinter.writeStartArray(this);
            return;
        }
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i6 = this._outputTail;
        this._outputTail = i6 + 1;
        bArr[i6] = BYTE_LBRACKET;
    }

    private final void _writeStringSegmentASCII2(String str, int i, int i6) throws IOException {
        if (((i6 - i) * 6) + this._outputTail > this._outputEnd) {
            _flushBuffer();
        }
        int i_outputMultiByteChar = this._outputTail;
        byte[] bArr = this._outputBuffer;
        int[] iArr = this._outputEscapes;
        int i10 = this._maximumNonEscapedChar;
        while (i < i6) {
            int i11 = i + 1;
            char cCharAt = str.charAt(i);
            if (cCharAt <= 127) {
                int i12 = iArr[cCharAt];
                if (i12 == 0) {
                    bArr[i_outputMultiByteChar] = (byte) cCharAt;
                    i = i11;
                    i_outputMultiByteChar++;
                } else if (i12 > 0) {
                    int i13 = i_outputMultiByteChar + 1;
                    bArr[i_outputMultiByteChar] = BYTE_BACKSLASH;
                    i_outputMultiByteChar += 2;
                    bArr[i13] = (byte) i12;
                } else {
                    i_outputMultiByteChar = _writeGenericEscape(cCharAt, i_outputMultiByteChar);
                }
            } else if (cCharAt > i10) {
                i_outputMultiByteChar = _writeGenericEscape(cCharAt, i_outputMultiByteChar);
            } else if (cCharAt <= 2047) {
                int i14 = i_outputMultiByteChar + 1;
                bArr[i_outputMultiByteChar] = (byte) ((cCharAt >> 6) | 192);
                i_outputMultiByteChar += 2;
                bArr[i14] = (byte) ((cCharAt & '?') | 128);
            } else {
                i_outputMultiByteChar = _outputMultiByteChar(cCharAt, i_outputMultiByteChar);
            }
            i = i11;
        }
        this._outputTail = i_outputMultiByteChar;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeStartObject(Object obj, int i) throws IOException {
        writeStartObject(obj);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(BigInteger bigInteger) throws IOException {
        _verifyValueWrite("write a number");
        if (bigInteger == null) {
            _writeNull();
        } else if (this._cfgNumbersAsStrings) {
            _writeQuotedRaw(bigInteger.toString());
        } else {
            writeRaw(bigInteger.toString());
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeRaw(SerializableString serializableString) throws IOException {
        int iAppendUnquotedUTF8 = serializableString.appendUnquotedUTF8(this._outputBuffer, this._outputTail);
        if (iAppendUnquotedUTF8 < 0) {
            _writeBytes(serializableString.asUnquotedUTF8());
        } else {
            this._outputTail += iAppendUnquotedUTF8;
        }
    }

    private final void _writeStringSegment2(String str, int i, int i6) throws IOException {
        int i_outputMultiByteChar;
        if (((i6 - i) * 6) + this._outputTail > this._outputEnd) {
            _flushBuffer();
        }
        int i_writeGenericEscape = this._outputTail;
        byte[] bArr = this._outputBuffer;
        int[] iArr = this._outputEscapes;
        while (i < i6) {
            int i10 = i + 1;
            char cCharAt = str.charAt(i);
            if (cCharAt <= 127) {
                int i11 = iArr[cCharAt];
                if (i11 == 0) {
                    i_outputMultiByteChar = i_writeGenericEscape + 1;
                    bArr[i_writeGenericEscape] = (byte) cCharAt;
                    i_writeGenericEscape = i_outputMultiByteChar;
                    i = i10;
                } else {
                    if (i11 > 0) {
                        int i12 = i_writeGenericEscape + 1;
                        bArr[i_writeGenericEscape] = BYTE_BACKSLASH;
                        i_writeGenericEscape += 2;
                        bArr[i12] = (byte) i11;
                    } else {
                        i_writeGenericEscape = _writeGenericEscape(cCharAt, i_writeGenericEscape);
                    }
                    i = i10;
                }
            } else if (cCharAt <= 2047) {
                int i13 = i_writeGenericEscape + 1;
                bArr[i_writeGenericEscape] = (byte) ((cCharAt >> 6) | 192);
                i_writeGenericEscape += 2;
                bArr[i13] = (byte) ((cCharAt & '?') | 128);
                i = i10;
            } else if (_isStartOfSurrogatePair(cCharAt) && JsonGenerator.Feature.COMBINE_UNICODE_SURROGATES_IN_UTF8.enabledIn(this._features) && i10 < i6) {
                i += 2;
                i_writeGenericEscape = _outputSurrogatePair(cCharAt, str.charAt(i10), i_writeGenericEscape);
            } else {
                i_outputMultiByteChar = _outputMultiByteChar(cCharAt, i_writeGenericEscape);
                i_writeGenericEscape = i_outputMultiByteChar;
                i = i10;
            }
        }
        this._outputTail = i_writeGenericEscape;
    }

    public final void _writePPFieldName(SerializableString serializableString) throws IOException {
        int iWriteFieldName = this._writeContext.writeFieldName(serializableString.getValue());
        if (iWriteFieldName == 4) {
            _reportError("Can not write a field name, expecting a value");
        }
        if (iWriteFieldName == 1) {
            this._cfgPrettyPrinter.writeObjectEntrySeparator(this);
        } else {
            this._cfgPrettyPrinter.beforeObjectEntries(this);
        }
        boolean z10 = this._cfgUnqNames;
        if (!z10) {
            if (this._outputTail >= this._outputEnd) {
                _flushBuffer();
            }
            byte[] bArr = this._outputBuffer;
            int i = this._outputTail;
            this._outputTail = i + 1;
            bArr[i] = this._quoteChar;
        }
        int iAppendQuotedUTF8 = serializableString.appendQuotedUTF8(this._outputBuffer, this._outputTail);
        if (iAppendQuotedUTF8 < 0) {
            _writeBytes(serializableString.asQuotedUTF8());
        } else {
            this._outputTail += iAppendQuotedUTF8;
        }
        if (z10) {
            return;
        }
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr2 = this._outputBuffer;
        int i6 = this._outputTail;
        this._outputTail = i6 + 1;
        bArr2[i6] = this._quoteChar;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void writeRaw(char[] cArr, int i, int i6) throws IOException {
        _checkRangeBoundsForCharArray(cArr, i, i6);
        int i10 = i6 + i6 + i6;
        int i11 = this._outputTail + i10;
        int i12 = this._outputEnd;
        if (i11 > i12) {
            if (i12 < i10) {
                _writeSegmentedRaw(cArr, i, i6);
                return;
            }
            _flushBuffer();
        }
        int i13 = i6 + i;
        while (i < i13) {
            do {
                char c = cArr[i];
                if (c > 127) {
                    i++;
                    if (c < 2048) {
                        byte[] bArr = this._outputBuffer;
                        int i14 = this._outputTail;
                        int i15 = i14 + 1;
                        this._outputTail = i15;
                        bArr[i14] = (byte) ((c >> 6) | 192);
                        this._outputTail = i14 + 2;
                        bArr[i15] = (byte) ((c & '?') | 128);
                    } else {
                        i = _outputRawMultiByteChar(c, cArr, i, i13);
                    }
                } else {
                    byte[] bArr2 = this._outputBuffer;
                    int i16 = this._outputTail;
                    this._outputTail = i16 + 1;
                    bArr2[i16] = (byte) c;
                    i++;
                }
            } while (i < i13);
            return;
        }
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase, com.fasterxml.jackson.core.JsonGenerator
    public void writeFieldName(SerializableString serializableString) throws IOException {
        if (this._cfgPrettyPrinter != null) {
            _writePPFieldName(serializableString);
            return;
        }
        int iWriteFieldName = this._writeContext.writeFieldName(serializableString.getValue());
        if (iWriteFieldName == 4) {
            _reportError("Can not write a field name, expecting a value");
        }
        if (iWriteFieldName == 1) {
            if (this._outputTail >= this._outputEnd) {
                _flushBuffer();
            }
            byte[] bArr = this._outputBuffer;
            int i = this._outputTail;
            this._outputTail = i + 1;
            bArr[i] = BYTE_COMMA;
        }
        if (this._cfgUnqNames) {
            _writeUnq(serializableString);
            return;
        }
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr2 = this._outputBuffer;
        int i6 = this._outputTail;
        int i10 = i6 + 1;
        this._outputTail = i10;
        bArr2[i6] = this._quoteChar;
        int iAppendQuotedUTF8 = serializableString.appendQuotedUTF8(bArr2, i10);
        if (iAppendQuotedUTF8 < 0) {
            _writeBytes(serializableString.asQuotedUTF8());
        } else {
            this._outputTail += iAppendQuotedUTF8;
        }
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr3 = this._outputBuffer;
        int i11 = this._outputTail;
        this._outputTail = i11 + 1;
        bArr3[i11] = this._quoteChar;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(double d) throws IOException {
        if (!this._cfgNumbersAsStrings && (!NumberOutput.notFinite(d) || !JsonGenerator.Feature.QUOTE_NON_NUMERIC_NUMBERS.enabledIn(this._features))) {
            _verifyValueWrite("write a number");
            writeRaw(NumberOutput.toString(d, isEnabled(JsonGenerator.Feature.USE_FAST_DOUBLE_WRITER)));
        } else {
            writeString(NumberOutput.toString(d, isEnabled(JsonGenerator.Feature.USE_FAST_DOUBLE_WRITER)));
        }
    }

    @Deprecated
    public UTF8JsonGenerator(IOContext iOContext, int i, ObjectCodec objectCodec, OutputStream outputStream) {
        this(iOContext, i, objectCodec, outputStream, JsonFactory.DEFAULT_QUOTE_CHAR);
    }

    @Deprecated
    public UTF8JsonGenerator(IOContext iOContext, int i, ObjectCodec objectCodec, OutputStream outputStream, byte[] bArr, int i6, boolean z10) {
        this(iOContext, i, objectCodec, outputStream, JsonFactory.DEFAULT_QUOTE_CHAR, bArr, i6, z10);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeString(char[] cArr, int i, int i6) throws IOException {
        _verifyValueWrite("write a string");
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i10 = this._outputTail;
        int i11 = i10 + 1;
        this._outputTail = i11;
        bArr[i10] = this._quoteChar;
        if (i6 <= this._outputMaxContiguous) {
            if (i11 + i6 > this._outputEnd) {
                _flushBuffer();
            }
            _writeStringSegment(cArr, i, i6);
        } else {
            _writeStringSegments(cArr, i, i6);
        }
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr2 = this._outputBuffer;
        int i12 = this._outputTail;
        this._outputTail = i12 + 1;
        bArr2[i12] = this._quoteChar;
    }

    private final void _writeCustomStringSegment2(String str, int i, int i6) throws IOException {
        int i_outputMultiByteChar;
        if (((i6 - i) * 6) + this._outputTail > this._outputEnd) {
            _flushBuffer();
        }
        int i_writeGenericEscape = this._outputTail;
        byte[] bArr = this._outputBuffer;
        int[] iArr = this._outputEscapes;
        int i10 = this._maximumNonEscapedChar;
        if (i10 <= 0) {
            i10 = 65535;
        }
        CharacterEscapes characterEscapes = this._characterEscapes;
        while (i < i6) {
            int i11 = i + 1;
            char cCharAt = str.charAt(i);
            if (cCharAt <= 127) {
                int i12 = iArr[cCharAt];
                if (i12 == 0) {
                    i_outputMultiByteChar = i_writeGenericEscape + 1;
                    bArr[i_writeGenericEscape] = (byte) cCharAt;
                    i_writeGenericEscape = i_outputMultiByteChar;
                    i = i11;
                } else {
                    if (i12 > 0) {
                        int i13 = i_writeGenericEscape + 1;
                        bArr[i_writeGenericEscape] = BYTE_BACKSLASH;
                        i_writeGenericEscape += 2;
                        bArr[i13] = (byte) i12;
                    } else if (i12 == -2) {
                        SerializableString escapeSequence = characterEscapes.getEscapeSequence(cCharAt);
                        if (escapeSequence == null) {
                            _reportError("Invalid custom escape definitions; custom escape not found for character code 0x" + Integer.toHexString(cCharAt) + ", although was supposed to have one");
                        }
                        i_writeGenericEscape = _writeCustomEscape(bArr, i_writeGenericEscape, escapeSequence, i6 - i11);
                    } else {
                        i_writeGenericEscape = _writeGenericEscape(cCharAt, i_writeGenericEscape);
                    }
                    i = i11;
                }
            } else {
                if (cCharAt > i10) {
                    i_writeGenericEscape = _writeGenericEscape(cCharAt, i_writeGenericEscape);
                } else {
                    SerializableString escapeSequence2 = characterEscapes.getEscapeSequence(cCharAt);
                    if (escapeSequence2 != null) {
                        i_writeGenericEscape = _writeCustomEscape(bArr, i_writeGenericEscape, escapeSequence2, i6 - i11);
                    } else if (cCharAt <= 2047) {
                        int i14 = i_writeGenericEscape + 1;
                        bArr[i_writeGenericEscape] = (byte) ((cCharAt >> 6) | 192);
                        i_writeGenericEscape += 2;
                        bArr[i14] = (byte) ((cCharAt & '?') | 128);
                    } else if (_isStartOfSurrogatePair(cCharAt) && JsonGenerator.Feature.COMBINE_UNICODE_SURROGATES_IN_UTF8.enabledIn(this._features) && i11 < i6) {
                        i += 2;
                        i_writeGenericEscape = _outputSurrogatePair(cCharAt, str.charAt(i11), i_writeGenericEscape);
                    } else {
                        i_outputMultiByteChar = _outputMultiByteChar(cCharAt, i_writeGenericEscape);
                        i_writeGenericEscape = i_outputMultiByteChar;
                    }
                }
                i = i11;
            }
        }
        this._outputTail = i_writeGenericEscape;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(float f) throws IOException {
        if (!this._cfgNumbersAsStrings && (!NumberOutput.notFinite(f) || !JsonGenerator.Feature.QUOTE_NON_NUMERIC_NUMBERS.enabledIn(this._features))) {
            _verifyValueWrite("write a number");
            writeRaw(NumberOutput.toString(f, isEnabled(JsonGenerator.Feature.USE_FAST_DOUBLE_WRITER)));
        } else {
            writeString(NumberOutput.toString(f, isEnabled(JsonGenerator.Feature.USE_FAST_DOUBLE_WRITER)));
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeRaw(char c) throws IOException {
        if (this._outputTail + 3 >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        if (c <= 127) {
            int i = this._outputTail;
            this._outputTail = i + 1;
            bArr[i] = (byte) c;
        } else {
            if (c < 2048) {
                int i6 = this._outputTail;
                int i10 = i6 + 1;
                this._outputTail = i10;
                bArr[i6] = (byte) ((c >> 6) | 192);
                this._outputTail = i6 + 2;
                bArr[i10] = (byte) ((c & '?') | 128);
                return;
            }
            _outputRawMultiByteChar(c, null, 0, 0);
        }
    }

    public final int _writeBinary(Base64Variant base64Variant, InputStream inputStream, byte[] bArr) throws IOException {
        byte[] bArr2 = bArr;
        int i = this._outputEnd - 6;
        int i6 = 2;
        int i10 = -3;
        int maxLineLength = base64Variant.getMaxLineLength() >> 2;
        int i11 = 0;
        int i_readMore = 0;
        int i12 = 0;
        while (true) {
            if (i11 > i10) {
                i_readMore = _readMore(inputStream, bArr2, i11, i_readMore, bArr2.length);
                if (i_readMore < 3) {
                    break;
                }
                i10 = i_readMore - 3;
                i11 = 0;
            }
            if (this._outputTail > i) {
                _flushBuffer();
            }
            int i13 = i11 + 2;
            int i14 = ((bArr[i11 + 1] & 255) | (bArr[i11] << 8)) << 8;
            i11 += 3;
            i12 += 3;
            int iEncodeBase64Chunk = base64Variant.encodeBase64Chunk(i14 | (bArr[i13] & 255), this._outputBuffer, this._outputTail);
            this._outputTail = iEncodeBase64Chunk;
            maxLineLength--;
            if (maxLineLength <= 0) {
                byte[] bArr3 = this._outputBuffer;
                int i15 = iEncodeBase64Chunk + 1;
                this._outputTail = i15;
                bArr3[iEncodeBase64Chunk] = BYTE_BACKSLASH;
                this._outputTail = iEncodeBase64Chunk + 2;
                bArr3[i15] = 110;
                maxLineLength = base64Variant.getMaxLineLength() >> 2;
            }
            bArr2 = bArr;
        }
        if (i_readMore <= 0) {
            return i12;
        }
        if (this._outputTail > i) {
            _flushBuffer();
        }
        int i16 = bArr[0] << 16;
        if (1 < i_readMore) {
            i16 |= (bArr[1] & 255) << 8;
        } else {
            i6 = 1;
        }
        int i17 = i12 + i6;
        this._outputTail = base64Variant.encodeBase64Partial(i16, i6, this._outputBuffer, this._outputTail);
        return i17;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(BigDecimal bigDecimal) throws IOException {
        _verifyValueWrite("write a number");
        if (bigDecimal == null) {
            _writeNull();
        } else if (this._cfgNumbersAsStrings) {
            _writeQuotedRaw(_asString(bigDecimal));
        } else {
            writeRaw(_asString(bigDecimal));
        }
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase, com.fasterxml.jackson.core.JsonGenerator
    public final void writeString(SerializableString serializableString) throws IOException {
        _verifyValueWrite("write a string");
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i = this._outputTail;
        int i6 = i + 1;
        this._outputTail = i6;
        bArr[i] = this._quoteChar;
        int iAppendQuotedUTF8 = serializableString.appendQuotedUTF8(bArr, i6);
        if (iAppendQuotedUTF8 < 0) {
            _writeBytes(serializableString.asQuotedUTF8());
        } else {
            this._outputTail += iAppendQuotedUTF8;
        }
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr2 = this._outputBuffer;
        int i10 = this._outputTail;
        this._outputTail = i10 + 1;
        bArr2[i10] = this._quoteChar;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(String str) throws IOException {
        _verifyValueWrite("write a number");
        if (str == null) {
            _writeNull();
        } else if (this._cfgNumbersAsStrings) {
            _writeQuotedRaw(str);
        } else {
            writeRaw(str);
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(char[] cArr, int i, int i6) throws IOException {
        _verifyValueWrite("write a number");
        if (this._cfgNumbersAsStrings) {
            _writeQuotedRaw(cArr, i, i6);
        } else {
            writeRaw(cArr, i, i6);
        }
    }
}
