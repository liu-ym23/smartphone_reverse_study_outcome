package com.fasterxml.jackson.core.json.async;

import androidx.appfunctions.metadata.a;
import androidx.autofill.HintConstants;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.base.GeneratorBase;
import com.fasterxml.jackson.core.internal.shaded.fdp.v2_19_2.FastDoubleMath;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import com.fasterxml.jackson.core.util.InternalJacksonUtil;
import com.fasterxml.jackson.core.util.VersionUtil;
import java.io.IOException;

/* loaded from: classes2.dex */
public abstract class NonBlockingUtf8JsonParserBase extends NonBlockingJsonParserBase {
    protected int _origBufferLen;
    private static final int FEAT_MASK_TRAILING_COMMA = JsonParser.Feature.ALLOW_TRAILING_COMMA.getMask();
    private static final int FEAT_MASK_LEADING_ZEROS = JsonParser.Feature.ALLOW_NUMERIC_LEADING_ZEROS.getMask();
    private static final int FEAT_MASK_ALLOW_MISSING = JsonParser.Feature.ALLOW_MISSING_VALUES.getMask();
    private static final int FEAT_MASK_ALLOW_SINGLE_QUOTES = JsonParser.Feature.ALLOW_SINGLE_QUOTES.getMask();
    private static final int FEAT_MASK_ALLOW_UNQUOTED_NAMES = JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES.getMask();
    private static final int FEAT_MASK_ALLOW_JAVA_COMMENTS = JsonParser.Feature.ALLOW_COMMENTS.getMask();
    private static final int FEAT_MASK_ALLOW_YAML_COMMENTS = JsonParser.Feature.ALLOW_YAML_COMMENTS.getMask();
    private static final int[] _icUTF8 = CharTypes.getInputCodeUtf8();
    protected static final int[] _icLatin1 = CharTypes.getInputCodeLatin1();

    public NonBlockingUtf8JsonParserBase(IOContext iOContext, int i, ByteQuadsCanonicalizer byteQuadsCanonicalizer) {
        super(iOContext, i, byteQuadsCanonicalizer);
    }

    private final int _decodeCharEscape() throws IOException {
        return this._inputEnd - this._inputPtr < 5 ? _decodeSplitEscaped(0, -1) : _decodeFastCharEscape();
    }

    private final int _decodeFastCharEscape() throws IOException {
        int iCharToHex;
        byte nextSignedByteFromBuffer = getNextSignedByteFromBuffer();
        if (nextSignedByteFromBuffer == 34 || nextSignedByteFromBuffer == 47 || nextSignedByteFromBuffer == 92) {
            return (char) nextSignedByteFromBuffer;
        }
        if (nextSignedByteFromBuffer == 98) {
            return 8;
        }
        if (nextSignedByteFromBuffer == 102) {
            return 12;
        }
        if (nextSignedByteFromBuffer == 110) {
            return 10;
        }
        if (nextSignedByteFromBuffer == 114) {
            return 13;
        }
        if (nextSignedByteFromBuffer == 116) {
            return 9;
        }
        if (nextSignedByteFromBuffer != 117) {
            return _handleUnrecognizedCharacterEscape((char) nextSignedByteFromBuffer);
        }
        byte nextSignedByteFromBuffer2 = getNextSignedByteFromBuffer();
        int iCharToHex2 = CharTypes.charToHex(nextSignedByteFromBuffer2);
        if (iCharToHex2 >= 0 && (iCharToHex = CharTypes.charToHex((nextSignedByteFromBuffer2 = getNextSignedByteFromBuffer()))) >= 0) {
            int i = (iCharToHex2 << 4) | iCharToHex;
            byte nextSignedByteFromBuffer3 = getNextSignedByteFromBuffer();
            int iCharToHex3 = CharTypes.charToHex(nextSignedByteFromBuffer3);
            if (iCharToHex3 >= 0) {
                int i6 = (i << 4) | iCharToHex3;
                nextSignedByteFromBuffer3 = getNextSignedByteFromBuffer();
                int iCharToHex4 = CharTypes.charToHex(nextSignedByteFromBuffer3);
                if (iCharToHex4 >= 0) {
                    return (i6 << 4) | iCharToHex4;
                }
            }
            nextSignedByteFromBuffer2 = nextSignedByteFromBuffer3;
        }
        _reportUnexpectedChar(nextSignedByteFromBuffer2 & 255, "expected a hex-digit for character escape sequence");
        return -1;
    }

    private int _decodeSplitEscaped(int i, int i6) throws IOException {
        if (this._inputPtr >= this._inputEnd) {
            this._quoted32 = i;
            this._quotedDigits = i6;
            return -1;
        }
        byte nextSignedByteFromBuffer = getNextSignedByteFromBuffer();
        if (i6 == -1) {
            if (nextSignedByteFromBuffer == 34 || nextSignedByteFromBuffer == 47 || nextSignedByteFromBuffer == 92) {
                return nextSignedByteFromBuffer;
            }
            if (nextSignedByteFromBuffer == 98) {
                return 8;
            }
            if (nextSignedByteFromBuffer == 102) {
                return 12;
            }
            if (nextSignedByteFromBuffer == 110) {
                return 10;
            }
            if (nextSignedByteFromBuffer == 114) {
                return 13;
            }
            if (nextSignedByteFromBuffer == 116) {
                return 9;
            }
            if (nextSignedByteFromBuffer != 117) {
                return _handleUnrecognizedCharacterEscape((char) nextSignedByteFromBuffer);
            }
            if (this._inputPtr >= this._inputEnd) {
                this._quotedDigits = 0;
                this._quoted32 = 0;
                return -1;
            }
            nextSignedByteFromBuffer = getNextSignedByteFromBuffer();
            i6 = 0;
        }
        int nextUnsignedByteFromBuffer = nextSignedByteFromBuffer & 255;
        while (true) {
            int iCharToHex = CharTypes.charToHex(nextUnsignedByteFromBuffer);
            if (iCharToHex < 0) {
                _reportUnexpectedChar(nextUnsignedByteFromBuffer & 255, "expected a hex-digit for character escape sequence");
            }
            i = (i << 4) | iCharToHex;
            i6++;
            if (i6 == 4) {
                return i;
            }
            if (this._inputPtr >= this._inputEnd) {
                this._quotedDigits = i6;
                this._quoted32 = i;
                return -1;
            }
            nextUnsignedByteFromBuffer = getNextUnsignedByteFromBuffer();
        }
    }

    private final boolean _decodeSplitMultiByte(int i, int i6, boolean z10) throws IOException {
        if (i6 == 1) {
            int i_decodeSplitEscaped = _decodeSplitEscaped(0, -1);
            if (i_decodeSplitEscaped < 0) {
                this._minorState = 41;
                return false;
            }
            this._textBuffer.append((char) i_decodeSplitEscaped);
            return true;
        }
        if (i6 == 2) {
            if (z10) {
                this._textBuffer.append((char) _decodeUTF8_2(i, getNextSignedByteFromBuffer()));
                return true;
            }
            this._minorState = 42;
            this._pending32 = i;
            return false;
        }
        if (i6 == 3) {
            int i10 = i & 15;
            if (z10) {
                return _decodeSplitUTF8_3(i10, 1, getNextSignedByteFromBuffer());
            }
            this._minorState = 43;
            this._pending32 = i10;
            this._pendingBytes = 1;
            return false;
        }
        if (i6 != 4) {
            if (i < 32) {
                _throwUnquotedSpace(i, "string value");
            } else {
                _reportInvalidChar(i);
            }
            this._textBuffer.append((char) i);
            return true;
        }
        int i11 = i & 7;
        if (z10) {
            return _decodeSplitUTF8_4(i11, 1, getNextSignedByteFromBuffer());
        }
        this._pending32 = i11;
        this._pendingBytes = 1;
        this._minorState = 44;
        return false;
    }

    private final boolean _decodeSplitUTF8_3(int i, int i6, int i10) throws IOException {
        if (i6 == 1) {
            if ((i10 & 192) != 128) {
                _reportInvalidOther(i10 & 255, this._inputPtr);
            }
            i = (i << 6) | (i10 & 63);
            if (this._inputPtr >= this._inputEnd) {
                this._minorState = 43;
                this._pending32 = i;
                this._pendingBytes = 2;
                return false;
            }
            i10 = getNextSignedByteFromBuffer();
        }
        if ((i10 & 192) != 128) {
            _reportInvalidOther(i10 & 255, this._inputPtr);
        }
        this._textBuffer.append((char) ((i << 6) | (i10 & 63)));
        return true;
    }

    private final boolean _decodeSplitUTF8_4(int i, int i6, int i10) throws IOException {
        if (i6 == 1) {
            if ((i10 & 192) != 128) {
                _reportInvalidOther(i10 & 255, this._inputPtr);
            }
            i = (i << 6) | (i10 & 63);
            if (this._inputPtr >= this._inputEnd) {
                this._minorState = 44;
                this._pending32 = i;
                this._pendingBytes = 2;
                return false;
            }
            i10 = getNextSignedByteFromBuffer();
            i6 = 2;
        }
        if (i6 == 2) {
            if ((i10 & 192) != 128) {
                _reportInvalidOther(i10 & 255, this._inputPtr);
            }
            i = (i << 6) | (i10 & 63);
            if (this._inputPtr >= this._inputEnd) {
                this._minorState = 44;
                this._pending32 = i;
                this._pendingBytes = 3;
                return false;
            }
            i10 = getNextSignedByteFromBuffer();
        }
        if ((i10 & 192) != 128) {
            _reportInvalidOther(i10 & 255, this._inputPtr);
        }
        int i11 = ((i << 6) | (i10 & 63)) - 65536;
        this._textBuffer.append((char) ((i11 >> 10) | GeneratorBase.SURR1_FIRST));
        this._textBuffer.append((char) ((i11 & FastDoubleMath.DOUBLE_EXPONENT_BIAS) | GeneratorBase.SURR2_FIRST));
        return true;
    }

    private final int _decodeUTF8_2(int i, int i6) throws IOException {
        if ((i6 & 192) != 128) {
            _reportInvalidOther(i6 & 255, this._inputPtr);
        }
        return ((i & 31) << 6) | (i6 & 63);
    }

    private final int _decodeUTF8_3(int i, int i6, int i10) throws IOException {
        int i11 = i & 15;
        if ((i6 & 192) != 128) {
            _reportInvalidOther(i6 & 255, this._inputPtr);
        }
        int i12 = (i11 << 6) | (i6 & 63);
        if ((i10 & 192) != 128) {
            _reportInvalidOther(i10 & 255, this._inputPtr);
        }
        return (i12 << 6) | (i10 & 63);
    }

    private final int _decodeUTF8_4(int i, int i6, int i10, int i11) throws IOException {
        if ((i6 & 192) != 128) {
            _reportInvalidOther(i6 & 255, this._inputPtr);
        }
        int i12 = ((i & 7) << 6) | (i6 & 63);
        if ((i10 & 192) != 128) {
            _reportInvalidOther(i10 & 255, this._inputPtr);
        }
        int i13 = (i12 << 6) | (i10 & 63);
        if ((i11 & 192) != 128) {
            _reportInvalidOther(i11 & 255, this._inputPtr);
        }
        return ((i13 << 6) | (i11 & 63)) - 65536;
    }

    private final String _fastParseName() throws IOException {
        int[] iArr = _icLatin1;
        int i = this._inputPtr;
        int i6 = i + 1;
        int byteFromBuffer = getByteFromBuffer(i) & 255;
        if (iArr[byteFromBuffer] != 0) {
            if (byteFromBuffer != 34) {
                return null;
            }
            this._inputPtr = i6;
            return "";
        }
        int i10 = i + 2;
        int byteFromBuffer2 = getByteFromBuffer(i6) & 255;
        if (iArr[byteFromBuffer2] != 0) {
            if (byteFromBuffer2 != 34) {
                return null;
            }
            this._inputPtr = i10;
            return _findName(byteFromBuffer, 1);
        }
        int i11 = byteFromBuffer2 | (byteFromBuffer << 8);
        int i12 = i + 3;
        int byteFromBuffer3 = getByteFromBuffer(i10) & 255;
        if (iArr[byteFromBuffer3] != 0) {
            if (byteFromBuffer3 != 34) {
                return null;
            }
            this._inputPtr = i12;
            return _findName(i11, 2);
        }
        int i13 = (i11 << 8) | byteFromBuffer3;
        int i14 = i + 4;
        int byteFromBuffer4 = getByteFromBuffer(i12) & 255;
        if (iArr[byteFromBuffer4] != 0) {
            if (byteFromBuffer4 != 34) {
                return null;
            }
            this._inputPtr = i14;
            return _findName(i13, 3);
        }
        int i15 = (i13 << 8) | byteFromBuffer4;
        int i16 = i + 5;
        int byteFromBuffer5 = getByteFromBuffer(i14) & 255;
        if (iArr[byteFromBuffer5] == 0) {
            this._quad1 = i15;
            return _parseMediumName(i16, byteFromBuffer5);
        }
        if (byteFromBuffer5 != 34) {
            return null;
        }
        this._inputPtr = i16;
        return _findName(i15, 4);
    }

    private JsonToken _finishAposName(int i, int i6, int i10) throws IOException {
        int[] iArr_growNameDecodeBuffer = this._quadBuffer;
        int[] iArr = _icLatin1;
        while (this._inputPtr < this._inputEnd) {
            int nextUnsignedByteFromBuffer = getNextUnsignedByteFromBuffer();
            if (nextUnsignedByteFromBuffer == 39) {
                if (i10 > 0) {
                    if (i >= iArr_growNameDecodeBuffer.length) {
                        iArr_growNameDecodeBuffer = _growNameDecodeBuffer(iArr_growNameDecodeBuffer, iArr_growNameDecodeBuffer.length);
                        this._quadBuffer = iArr_growNameDecodeBuffer;
                    }
                    iArr_growNameDecodeBuffer[i] = NonBlockingJsonParserBase._padLastQuad(i6, i10);
                    i++;
                } else if (i == 0) {
                    return _fieldComplete("");
                }
                String strFindName = this._symbols.findName(iArr_growNameDecodeBuffer, i);
                if (strFindName == null) {
                    strFindName = _addName(iArr_growNameDecodeBuffer, i, i10);
                }
                return _fieldComplete(strFindName);
            }
            if (nextUnsignedByteFromBuffer != 34 && iArr[nextUnsignedByteFromBuffer] != 0) {
                if (nextUnsignedByteFromBuffer != 92) {
                    _throwUnquotedSpace(nextUnsignedByteFromBuffer, HintConstants.AUTOFILL_HINT_NAME);
                } else {
                    nextUnsignedByteFromBuffer = _decodeCharEscape();
                    if (nextUnsignedByteFromBuffer < 0) {
                        this._minorState = 8;
                        this._minorStateAfterSplit = 9;
                        this._quadLength = i;
                        this._pending32 = i6;
                        this._pendingBytes = i10;
                        return _updateTokenToNA();
                    }
                }
                if (nextUnsignedByteFromBuffer > 127) {
                    int i11 = 0;
                    if (i10 >= 4) {
                        if (i >= iArr_growNameDecodeBuffer.length) {
                            iArr_growNameDecodeBuffer = _growNameDecodeBuffer(iArr_growNameDecodeBuffer, iArr_growNameDecodeBuffer.length);
                            this._quadBuffer = iArr_growNameDecodeBuffer;
                        }
                        iArr_growNameDecodeBuffer[i] = i6;
                        i++;
                        i6 = 0;
                        i10 = 0;
                    }
                    if (nextUnsignedByteFromBuffer < 2048) {
                        i6 = (i6 << 8) | (nextUnsignedByteFromBuffer >> 6) | 192;
                        i10++;
                    } else {
                        int i12 = (i6 << 8) | (nextUnsignedByteFromBuffer >> 12) | 224;
                        int i13 = i10 + 1;
                        if (i13 >= 4) {
                            if (i >= iArr_growNameDecodeBuffer.length) {
                                iArr_growNameDecodeBuffer = _growNameDecodeBuffer(iArr_growNameDecodeBuffer, iArr_growNameDecodeBuffer.length);
                                this._quadBuffer = iArr_growNameDecodeBuffer;
                            }
                            iArr_growNameDecodeBuffer[i] = i12;
                            i++;
                            i13 = 0;
                        } else {
                            i11 = i12;
                        }
                        i6 = (i11 << 8) | ((nextUnsignedByteFromBuffer >> 6) & 63) | 128;
                        i10 = i13 + 1;
                    }
                    nextUnsignedByteFromBuffer = (nextUnsignedByteFromBuffer & 63) | 128;
                }
            }
            if (i10 < 4) {
                i10++;
                i6 = (i6 << 8) | nextUnsignedByteFromBuffer;
            } else {
                if (i >= iArr_growNameDecodeBuffer.length) {
                    iArr_growNameDecodeBuffer = _growNameDecodeBuffer(iArr_growNameDecodeBuffer, iArr_growNameDecodeBuffer.length);
                    this._quadBuffer = iArr_growNameDecodeBuffer;
                }
                iArr_growNameDecodeBuffer[i] = i6;
                i++;
                i6 = nextUnsignedByteFromBuffer;
                i10 = 1;
            }
        }
        this._quadLength = i;
        this._pending32 = i6;
        this._pendingBytes = i10;
        this._minorState = 9;
        return _updateTokenToNA();
    }

    private final JsonToken _finishAposString() throws IOException {
        int[] iArr = _icUTF8;
        char[] bufferWithoutReset = this._textBuffer.getBufferWithoutReset();
        int currentSegmentSize = this._textBuffer.getCurrentSegmentSize();
        int i = this._inputPtr;
        int i6 = this._inputEnd - 5;
        while (i < this._inputEnd) {
            int i10 = 0;
            if (currentSegmentSize >= bufferWithoutReset.length) {
                bufferWithoutReset = this._textBuffer.finishCurrentSegment();
                currentSegmentSize = 0;
            }
            int iMin = Math.min(this._inputEnd, InternalJacksonUtil.addOverflowSafe(i, bufferWithoutReset.length - currentSegmentSize));
            while (true) {
                if (i < iMin) {
                    int i11 = i + 1;
                    int byteFromBuffer = getByteFromBuffer(i) & 255;
                    int i12 = iArr[byteFromBuffer];
                    if (i12 == 0 || byteFromBuffer == 34) {
                        if (byteFromBuffer == 39) {
                            this._inputPtr = i11;
                            this._textBuffer.setCurrentLength(currentSegmentSize);
                            return _valueComplete(JsonToken.VALUE_STRING);
                        }
                        bufferWithoutReset[currentSegmentSize] = (char) byteFromBuffer;
                        currentSegmentSize++;
                        i = i11;
                    } else if (i11 >= i6) {
                        this._inputPtr = i11;
                        this._textBuffer.setCurrentLength(currentSegmentSize);
                        if (!_decodeSplitMultiByte(byteFromBuffer, iArr[byteFromBuffer], i11 < this._inputEnd)) {
                            this._minorStateAfterSplit = 45;
                            return _updateTokenToNA();
                        }
                        bufferWithoutReset = this._textBuffer.getBufferWithoutReset();
                        currentSegmentSize = this._textBuffer.getCurrentSegmentSize();
                        i = this._inputPtr;
                    } else {
                        if (i12 == 1) {
                            this._inputPtr = i11;
                            byteFromBuffer = _decodeFastCharEscape();
                            i = this._inputPtr;
                        } else if (i12 == 2) {
                            i += 2;
                            byteFromBuffer = _decodeUTF8_2(byteFromBuffer, getByteFromBuffer(i11));
                        } else if (i12 == 3) {
                            int i13 = i + 2;
                            i += 3;
                            byteFromBuffer = _decodeUTF8_3(byteFromBuffer, getByteFromBuffer(i11), getByteFromBuffer(i13));
                        } else if (i12 != 4) {
                            if (byteFromBuffer < 32) {
                                _throwUnquotedSpace(byteFromBuffer, "string value");
                            } else {
                                _reportInvalidChar(byteFromBuffer);
                            }
                            i = i11;
                        } else {
                            byte byteFromBuffer2 = getByteFromBuffer(i11);
                            int i14 = i + 3;
                            byte byteFromBuffer3 = getByteFromBuffer(i + 2);
                            i += 4;
                            int i_decodeUTF8_4 = _decodeUTF8_4(byteFromBuffer, byteFromBuffer2, byteFromBuffer3, getByteFromBuffer(i14));
                            int i15 = currentSegmentSize + 1;
                            bufferWithoutReset[currentSegmentSize] = (char) ((i_decodeUTF8_4 >> 10) | GeneratorBase.SURR1_FIRST);
                            if (i15 >= bufferWithoutReset.length) {
                                bufferWithoutReset = this._textBuffer.finishCurrentSegment();
                                currentSegmentSize = 0;
                            } else {
                                currentSegmentSize = i15;
                            }
                            byteFromBuffer = (i_decodeUTF8_4 & FastDoubleMath.DOUBLE_EXPONENT_BIAS) | GeneratorBase.SURR2_FIRST;
                        }
                        if (currentSegmentSize >= bufferWithoutReset.length) {
                            bufferWithoutReset = this._textBuffer.finishCurrentSegment();
                        } else {
                            i10 = currentSegmentSize;
                        }
                        currentSegmentSize = i10 + 1;
                        bufferWithoutReset[i10] = (char) byteFromBuffer;
                    }
                }
            }
        }
        this._inputPtr = i;
        this._minorState = 45;
        this._textBuffer.setCurrentLength(currentSegmentSize);
        return _updateTokenToNA();
    }

    private final JsonToken _finishBOM(int i) throws IOException {
        while (this._inputPtr < this._inputEnd) {
            int nextUnsignedByteFromBuffer = getNextUnsignedByteFromBuffer();
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        this._currInputProcessed -= 3;
                        return _startDocument(nextUnsignedByteFromBuffer);
                    }
                } else if (nextUnsignedByteFromBuffer != 191) {
                    _reportError("Unexpected byte 0x%02x following 0xEF 0xBB; should get 0xBF as third byte of UTF-8 BOM", Integer.valueOf(nextUnsignedByteFromBuffer));
                }
            } else if (nextUnsignedByteFromBuffer != 187) {
                _reportError("Unexpected byte 0x%02x following 0xEF; should get 0xBB as second byte UTF-8 BOM", Integer.valueOf(nextUnsignedByteFromBuffer));
            }
            i++;
        }
        this._pending32 = i;
        this._minorState = 1;
        return _updateTokenToNA();
    }

    private final JsonToken _finishCComment(int i, boolean z10) throws IOException {
        while (this._inputPtr < this._inputEnd) {
            int nextUnsignedByteFromBuffer = getNextUnsignedByteFromBuffer();
            if (nextUnsignedByteFromBuffer < 32) {
                if (nextUnsignedByteFromBuffer == 10) {
                    this._currInputRow++;
                    this._currInputRowStart = this._inputPtr;
                } else if (nextUnsignedByteFromBuffer == 13) {
                    this._currInputRowAlt++;
                    this._currInputRowStart = this._inputPtr;
                } else if (nextUnsignedByteFromBuffer != 9) {
                    _throwInvalidSpace(nextUnsignedByteFromBuffer);
                }
            } else if (nextUnsignedByteFromBuffer == 42) {
                z10 = true;
            } else if (nextUnsignedByteFromBuffer == 47 && z10) {
                return _startAfterComment(i);
            }
            z10 = false;
        }
        this._minorState = z10 ? 52 : 53;
        this._pending32 = i;
        return _updateTokenToNA();
    }

    private final JsonToken _finishCppComment(int i) throws IOException {
        while (this._inputPtr < this._inputEnd) {
            int nextUnsignedByteFromBuffer = getNextUnsignedByteFromBuffer();
            if (nextUnsignedByteFromBuffer < 32) {
                if (nextUnsignedByteFromBuffer == 10) {
                    this._currInputRow++;
                    this._currInputRowStart = this._inputPtr;
                } else if (nextUnsignedByteFromBuffer == 13) {
                    this._currInputRowAlt++;
                    this._currInputRowStart = this._inputPtr;
                } else if (nextUnsignedByteFromBuffer != 9) {
                    _throwInvalidSpace(nextUnsignedByteFromBuffer);
                }
                return _startAfterComment(i);
            }
        }
        this._minorState = 54;
        this._pending32 = i;
        return _updateTokenToNA();
    }

    private final JsonToken _finishHashComment(int i) throws IOException {
        if ((this._features & FEAT_MASK_ALLOW_YAML_COMMENTS) == 0) {
            _reportUnexpectedChar(35, "maybe a (non-standard) comment? (not recognized as one since Feature 'ALLOW_YAML_COMMENTS' not enabled for parser)");
        }
        while (this._inputPtr < this._inputEnd) {
            int nextUnsignedByteFromBuffer = getNextUnsignedByteFromBuffer();
            if (nextUnsignedByteFromBuffer < 32) {
                if (nextUnsignedByteFromBuffer == 10) {
                    this._currInputRow++;
                    this._currInputRowStart = this._inputPtr;
                } else if (nextUnsignedByteFromBuffer == 13) {
                    this._currInputRowAlt++;
                    this._currInputRowStart = this._inputPtr;
                } else if (nextUnsignedByteFromBuffer != 9) {
                    _throwInvalidSpace(nextUnsignedByteFromBuffer);
                }
                return _startAfterComment(i);
            }
        }
        this._minorState = 55;
        this._pending32 = i;
        return _updateTokenToNA();
    }

    private final JsonToken _finishRegularString() throws IOException {
        int[] iArr = _icUTF8;
        char[] bufferWithoutReset = this._textBuffer.getBufferWithoutReset();
        int currentSegmentSize = this._textBuffer.getCurrentSegmentSize();
        int i = this._inputPtr;
        int i6 = this._inputEnd - 5;
        while (i < this._inputEnd) {
            int i10 = 0;
            if (currentSegmentSize >= bufferWithoutReset.length) {
                bufferWithoutReset = this._textBuffer.finishCurrentSegment();
                currentSegmentSize = 0;
            }
            int iMin = Math.min(this._inputEnd, InternalJacksonUtil.addOverflowSafe(i, bufferWithoutReset.length - currentSegmentSize));
            while (true) {
                if (i < iMin) {
                    int i11 = i + 1;
                    int byteFromBuffer = getByteFromBuffer(i) & 255;
                    int i12 = iArr[byteFromBuffer];
                    if (i12 == 0) {
                        bufferWithoutReset[currentSegmentSize] = (char) byteFromBuffer;
                        currentSegmentSize++;
                        i = i11;
                    } else {
                        if (byteFromBuffer == 34) {
                            this._inputPtr = i11;
                            this._textBuffer.setCurrentLength(currentSegmentSize);
                            return _valueComplete(JsonToken.VALUE_STRING);
                        }
                        if (i11 >= i6) {
                            this._inputPtr = i11;
                            this._textBuffer.setCurrentLength(currentSegmentSize);
                            if (!_decodeSplitMultiByte(byteFromBuffer, iArr[byteFromBuffer], i11 < this._inputEnd)) {
                                this._minorStateAfterSplit = 40;
                                return _updateTokenToNA();
                            }
                            bufferWithoutReset = this._textBuffer.getBufferWithoutReset();
                            currentSegmentSize = this._textBuffer.getCurrentSegmentSize();
                            i = this._inputPtr;
                        } else {
                            if (i12 == 1) {
                                this._inputPtr = i11;
                                byteFromBuffer = _decodeFastCharEscape();
                                i = this._inputPtr;
                            } else if (i12 == 2) {
                                i += 2;
                                byteFromBuffer = _decodeUTF8_2(byteFromBuffer, getByteFromBuffer(i11));
                            } else if (i12 == 3) {
                                int i13 = i + 2;
                                i += 3;
                                byteFromBuffer = _decodeUTF8_3(byteFromBuffer, getByteFromBuffer(i11), getByteFromBuffer(i13));
                            } else if (i12 != 4) {
                                if (byteFromBuffer < 32) {
                                    _throwUnquotedSpace(byteFromBuffer, "string value");
                                } else {
                                    _reportInvalidChar(byteFromBuffer);
                                }
                                i = i11;
                            } else {
                                byte byteFromBuffer2 = getByteFromBuffer(i11);
                                int i14 = i + 3;
                                byte byteFromBuffer3 = getByteFromBuffer(i + 2);
                                i += 4;
                                int i_decodeUTF8_4 = _decodeUTF8_4(byteFromBuffer, byteFromBuffer2, byteFromBuffer3, getByteFromBuffer(i14));
                                int i15 = currentSegmentSize + 1;
                                bufferWithoutReset[currentSegmentSize] = (char) ((i_decodeUTF8_4 >> 10) | GeneratorBase.SURR1_FIRST);
                                if (i15 >= bufferWithoutReset.length) {
                                    bufferWithoutReset = this._textBuffer.finishCurrentSegment();
                                    currentSegmentSize = 0;
                                } else {
                                    currentSegmentSize = i15;
                                }
                                byteFromBuffer = (i_decodeUTF8_4 & FastDoubleMath.DOUBLE_EXPONENT_BIAS) | GeneratorBase.SURR2_FIRST;
                            }
                            if (currentSegmentSize >= bufferWithoutReset.length) {
                                bufferWithoutReset = this._textBuffer.finishCurrentSegment();
                            } else {
                                i10 = currentSegmentSize;
                            }
                            currentSegmentSize = i10 + 1;
                            bufferWithoutReset[i10] = (char) byteFromBuffer;
                        }
                    }
                }
            }
        }
        this._inputPtr = i;
        this._minorState = 40;
        this._textBuffer.setCurrentLength(currentSegmentSize);
        return _updateTokenToNA();
    }

    private JsonToken _finishUnquotedName(int i, int i6, int i10) throws IOException {
        int[] iArr_growNameDecodeBuffer = this._quadBuffer;
        int[] inputCodeUtf8JsNames = CharTypes.getInputCodeUtf8JsNames();
        while (true) {
            int i11 = this._inputPtr;
            if (i11 >= this._inputEnd) {
                this._quadLength = i;
                this._pending32 = i6;
                this._pendingBytes = i10;
                this._minorState = 10;
                return _updateTokenToNA();
            }
            int byteFromBuffer = getByteFromBuffer(i11) & 255;
            if (inputCodeUtf8JsNames[byteFromBuffer] != 0) {
                if (i10 > 0) {
                    if (i >= iArr_growNameDecodeBuffer.length) {
                        iArr_growNameDecodeBuffer = _growNameDecodeBuffer(iArr_growNameDecodeBuffer, iArr_growNameDecodeBuffer.length);
                        this._quadBuffer = iArr_growNameDecodeBuffer;
                    }
                    iArr_growNameDecodeBuffer[i] = i6;
                    i++;
                }
                String strFindName = this._symbols.findName(iArr_growNameDecodeBuffer, i);
                if (strFindName == null) {
                    strFindName = _addName(iArr_growNameDecodeBuffer, i, i10);
                }
                return _fieldComplete(strFindName);
            }
            this._inputPtr++;
            if (i10 < 4) {
                i10++;
                i6 = (i6 << 8) | byteFromBuffer;
            } else {
                if (i >= iArr_growNameDecodeBuffer.length) {
                    iArr_growNameDecodeBuffer = _growNameDecodeBuffer(iArr_growNameDecodeBuffer, iArr_growNameDecodeBuffer.length);
                    this._quadBuffer = iArr_growNameDecodeBuffer;
                }
                iArr_growNameDecodeBuffer[i] = i6;
                i++;
                i6 = byteFromBuffer;
                i10 = 1;
            }
        }
    }

    private JsonToken _handleOddName(int i) throws IOException {
        if (i != 35) {
            if (i != 39) {
                if (i == 47) {
                    return _startSlashComment(4);
                }
                if (i == 93) {
                    return _closeArrayScope();
                }
            } else if ((this._features & FEAT_MASK_ALLOW_SINGLE_QUOTES) != 0) {
                return _finishAposName(0, 0, 0);
            }
        } else if ((this._features & FEAT_MASK_ALLOW_YAML_COMMENTS) != 0) {
            return _finishHashComment(4);
        }
        if ((this._features & FEAT_MASK_ALLOW_UNQUOTED_NAMES) == 0) {
            _reportUnexpectedChar((char) i, "was expecting double-quote to start field name");
        }
        if (CharTypes.getInputCodeUtf8JsNames()[i] != 0) {
            _reportUnexpectedChar(i, "was expecting either valid name character (for unquoted name) or double-quote (for quoted) to start field name");
        }
        return _finishUnquotedName(0, i, 1);
    }

    private final JsonToken _parseEscapedName(int i, int i6, int i10) throws IOException {
        int i11;
        int[] iArr_growNameDecodeBuffer = this._quadBuffer;
        int[] iArr = _icLatin1;
        while (this._inputPtr < this._inputEnd) {
            int nextUnsignedByteFromBuffer = getNextUnsignedByteFromBuffer();
            if (iArr[nextUnsignedByteFromBuffer] == 0) {
                if (i10 < 4) {
                    i10++;
                    i6 = (i6 << 8) | nextUnsignedByteFromBuffer;
                } else {
                    if (i >= iArr_growNameDecodeBuffer.length) {
                        int[] iArr_growNameDecodeBuffer2 = _growNameDecodeBuffer(iArr_growNameDecodeBuffer, iArr_growNameDecodeBuffer.length);
                        this._quadBuffer = iArr_growNameDecodeBuffer2;
                        iArr_growNameDecodeBuffer = iArr_growNameDecodeBuffer2;
                    }
                    i11 = i + 1;
                    iArr_growNameDecodeBuffer[i] = i6;
                    i = i11;
                    i6 = nextUnsignedByteFromBuffer;
                    i10 = 1;
                }
            } else {
                if (nextUnsignedByteFromBuffer == 34) {
                    if (i10 > 0) {
                        if (i >= iArr_growNameDecodeBuffer.length) {
                            iArr_growNameDecodeBuffer = _growNameDecodeBuffer(iArr_growNameDecodeBuffer, iArr_growNameDecodeBuffer.length);
                            this._quadBuffer = iArr_growNameDecodeBuffer;
                        }
                        iArr_growNameDecodeBuffer[i] = NonBlockingJsonParserBase._padLastQuad(i6, i10);
                        i++;
                    } else if (i == 0) {
                        return _fieldComplete("");
                    }
                    String strFindName = this._symbols.findName(iArr_growNameDecodeBuffer, i);
                    if (strFindName == null) {
                        strFindName = _addName(iArr_growNameDecodeBuffer, i, i10);
                    }
                    return _fieldComplete(strFindName);
                }
                if (nextUnsignedByteFromBuffer != 92) {
                    _throwUnquotedSpace(nextUnsignedByteFromBuffer, HintConstants.AUTOFILL_HINT_NAME);
                } else {
                    nextUnsignedByteFromBuffer = _decodeCharEscape();
                    if (nextUnsignedByteFromBuffer < 0) {
                        this._minorState = 8;
                        this._minorStateAfterSplit = 7;
                        this._quadLength = i;
                        this._pending32 = i6;
                        this._pendingBytes = i10;
                        return _updateTokenToNA();
                    }
                }
                if (i >= iArr_growNameDecodeBuffer.length) {
                    iArr_growNameDecodeBuffer = _growNameDecodeBuffer(iArr_growNameDecodeBuffer, iArr_growNameDecodeBuffer.length);
                    this._quadBuffer = iArr_growNameDecodeBuffer;
                }
                if (nextUnsignedByteFromBuffer > 127) {
                    int i12 = 0;
                    if (i10 >= 4) {
                        iArr_growNameDecodeBuffer[i] = i6;
                        i++;
                        i6 = 0;
                        i10 = 0;
                    }
                    if (nextUnsignedByteFromBuffer < 2048) {
                        i6 = (i6 << 8) | (nextUnsignedByteFromBuffer >> 6) | 192;
                        i10++;
                    } else {
                        int i13 = (i6 << 8) | (nextUnsignedByteFromBuffer >> 12) | 224;
                        int i14 = i10 + 1;
                        if (i14 >= 4) {
                            iArr_growNameDecodeBuffer[i] = i13;
                            i++;
                            i14 = 0;
                        } else {
                            i12 = i13;
                        }
                        i6 = (i12 << 8) | ((nextUnsignedByteFromBuffer >> 6) & 63) | 128;
                        i10 = i14 + 1;
                    }
                    nextUnsignedByteFromBuffer = (nextUnsignedByteFromBuffer & 63) | 128;
                }
                if (i10 < 4) {
                    i10++;
                    i6 = (i6 << 8) | nextUnsignedByteFromBuffer;
                } else {
                    i11 = i + 1;
                    iArr_growNameDecodeBuffer[i] = i6;
                    i = i11;
                    i6 = nextUnsignedByteFromBuffer;
                    i10 = 1;
                }
            }
        }
        this._quadLength = i;
        this._pending32 = i6;
        this._pendingBytes = i10;
        this._minorState = 7;
        return _updateTokenToNA();
    }

    private final String _parseMediumName(int i, int i6) throws IOException {
        int[] iArr = _icLatin1;
        int i10 = i + 1;
        int byteFromBuffer = getByteFromBuffer(i) & 255;
        if (iArr[byteFromBuffer] != 0) {
            if (byteFromBuffer != 34) {
                return null;
            }
            this._inputPtr = i10;
            return _findName(this._quad1, i6, 1);
        }
        int i11 = (i6 << 8) | byteFromBuffer;
        int i12 = i + 2;
        int byteFromBuffer2 = getByteFromBuffer(i10) & 255;
        if (iArr[byteFromBuffer2] != 0) {
            if (byteFromBuffer2 != 34) {
                return null;
            }
            this._inputPtr = i12;
            return _findName(this._quad1, i11, 2);
        }
        int i13 = (i11 << 8) | byteFromBuffer2;
        int i14 = i + 3;
        int byteFromBuffer3 = getByteFromBuffer(i12) & 255;
        if (iArr[byteFromBuffer3] != 0) {
            if (byteFromBuffer3 != 34) {
                return null;
            }
            this._inputPtr = i14;
            return _findName(this._quad1, i13, 3);
        }
        int i15 = (i13 << 8) | byteFromBuffer3;
        int i16 = i + 4;
        int byteFromBuffer4 = getByteFromBuffer(i14) & 255;
        if (iArr[byteFromBuffer4] == 0) {
            return _parseMediumName2(i16, byteFromBuffer4, i15);
        }
        if (byteFromBuffer4 != 34) {
            return null;
        }
        this._inputPtr = i16;
        return _findName(this._quad1, i15, 4);
    }

    private final String _parseMediumName2(int i, int i6, int i10) throws IOException {
        int[] iArr = _icLatin1;
        int i11 = i + 1;
        int byteFromBuffer = getByteFromBuffer(i) & 255;
        if (iArr[byteFromBuffer] != 0) {
            if (byteFromBuffer != 34) {
                return null;
            }
            this._inputPtr = i11;
            return _findName(this._quad1, i10, i6, 1);
        }
        int i12 = (i6 << 8) | byteFromBuffer;
        int i13 = i + 2;
        int byteFromBuffer2 = getByteFromBuffer(i11) & 255;
        if (iArr[byteFromBuffer2] != 0) {
            if (byteFromBuffer2 != 34) {
                return null;
            }
            this._inputPtr = i13;
            return _findName(this._quad1, i10, i12, 2);
        }
        int i14 = (i12 << 8) | byteFromBuffer2;
        int i15 = i + 3;
        int byteFromBuffer3 = getByteFromBuffer(i13) & 255;
        if (iArr[byteFromBuffer3] != 0) {
            if (byteFromBuffer3 != 34) {
                return null;
            }
            this._inputPtr = i15;
            return _findName(this._quad1, i10, i14, 3);
        }
        int i16 = (i14 << 8) | byteFromBuffer3;
        int i17 = i + 4;
        if ((getByteFromBuffer(i15) & 255) != 34) {
            return null;
        }
        this._inputPtr = i17;
        return _findName(this._quad1, i10, i16, 4);
    }

    private final int _skipWS(int i) throws IOException {
        do {
            if (i != 32) {
                if (i == 10) {
                    this._currInputRow++;
                    this._currInputRowStart = this._inputPtr;
                } else if (i == 13) {
                    this._currInputRowAlt++;
                    this._currInputRowStart = this._inputPtr;
                } else if (i != 9 && !_isAllowedCtrlCharRS(i)) {
                    _throwInvalidSpace(i);
                }
            }
            if (this._inputPtr >= this._inputEnd) {
                _updateTokenToNA();
                return 0;
            }
            i = getNextUnsignedByteFromBuffer();
        } while (i <= 32);
        return i;
    }

    private final JsonToken _startAfterComment(int i) throws IOException {
        if (this._inputPtr >= this._inputEnd) {
            this._minorState = i;
            return _updateTokenToNA();
        }
        int nextUnsignedByteFromBuffer = getNextUnsignedByteFromBuffer();
        if (i == 4) {
            return _startFieldName(nextUnsignedByteFromBuffer);
        }
        if (i == 5) {
            return _startFieldNameAfterComma(nextUnsignedByteFromBuffer);
        }
        switch (i) {
            case 12:
                return _startValue(nextUnsignedByteFromBuffer);
            case 13:
                return _startValueExpectComma(nextUnsignedByteFromBuffer);
            case 14:
                return _startValueExpectColon(nextUnsignedByteFromBuffer);
            case 15:
                return _startValueAfterComma(nextUnsignedByteFromBuffer);
            default:
                VersionUtil.throwInternal();
                return null;
        }
    }

    private final JsonToken _startDocument(int i) throws IOException {
        int nextUnsignedByteFromBuffer = i & 255;
        if (nextUnsignedByteFromBuffer == 239 && this._minorState != 1) {
            return _finishBOM(1);
        }
        while (nextUnsignedByteFromBuffer <= 32) {
            if (nextUnsignedByteFromBuffer != 32) {
                if (nextUnsignedByteFromBuffer == 10) {
                    this._currInputRow++;
                    this._currInputRowStart = this._inputPtr;
                } else if (nextUnsignedByteFromBuffer == 13) {
                    this._currInputRowAlt++;
                    this._currInputRowStart = this._inputPtr;
                } else if (nextUnsignedByteFromBuffer != 9) {
                    _throwInvalidSpace(nextUnsignedByteFromBuffer);
                }
            }
            if (this._inputPtr >= this._inputEnd) {
                this._minorState = 3;
                if (this._closed) {
                    return null;
                }
                return this._endOfInput ? _eofAsNextToken() : JsonToken.NOT_AVAILABLE;
            }
            nextUnsignedByteFromBuffer = getNextUnsignedByteFromBuffer();
        }
        return _startValue(nextUnsignedByteFromBuffer);
    }

    private final JsonToken _startFieldName(int i) throws IOException {
        String str_fastParseName;
        if (i > 32 || (i = _skipWS(i)) > 0) {
            _updateTokenLocation();
            return i != 34 ? i == 125 ? _closeObjectScope() : _handleOddName(i) : (this._inputPtr + 13 > this._inputEnd || (str_fastParseName = _fastParseName()) == null) ? _parseEscapedName(0, 0, 0) : _fieldComplete(str_fastParseName);
        }
        this._minorState = 4;
        return this._currToken;
    }

    private final JsonToken _startFieldNameAfterComma(int i) throws IOException {
        String str_fastParseName;
        if (i <= 32 && (i = _skipWS(i)) <= 0) {
            this._minorState = 5;
            return this._currToken;
        }
        if (i != 44) {
            if (i == 125) {
                return _closeObjectScope();
            }
            if (i == 35) {
                return _finishHashComment(5);
            }
            if (i == 47) {
                return _startSlashComment(5);
            }
            _reportUnexpectedChar(i, "was expecting comma to separate " + this._parsingContext.typeDesc() + " entries");
        }
        int i6 = this._inputPtr;
        if (i6 >= this._inputEnd) {
            this._minorState = 4;
            return _updateTokenToNA();
        }
        int byteFromBuffer = getByteFromBuffer(i6);
        this._inputPtr = i6 + 1;
        if (byteFromBuffer > 32 || (byteFromBuffer = _skipWS(byteFromBuffer)) > 0) {
            _updateTokenLocation();
            return byteFromBuffer != 34 ? (byteFromBuffer != 125 || (this._features & FEAT_MASK_TRAILING_COMMA) == 0) ? _handleOddName(byteFromBuffer) : _closeObjectScope() : (this._inputPtr + 13 > this._inputEnd || (str_fastParseName = _fastParseName()) == null) ? _parseEscapedName(0, 0, 0) : _fieldComplete(str_fastParseName);
        }
        this._minorState = 4;
        return this._currToken;
    }

    private final JsonToken _startSlashComment(int i) throws IOException {
        if ((this._features & FEAT_MASK_ALLOW_JAVA_COMMENTS) == 0) {
            _reportUnexpectedChar(47, "maybe a (non-standard) comment? (not recognized as one since Feature 'ALLOW_COMMENTS' not enabled for parser)");
        }
        if (this._inputPtr >= this._inputEnd) {
            this._pending32 = i;
            this._minorState = 51;
            return _updateTokenToNA();
        }
        byte nextSignedByteFromBuffer = getNextSignedByteFromBuffer();
        if (nextSignedByteFromBuffer == 42) {
            return _finishCComment(i, false);
        }
        if (nextSignedByteFromBuffer == 47) {
            return _finishCppComment(i);
        }
        _reportUnexpectedChar(nextSignedByteFromBuffer & 255, "was expecting either '*' or '/' for a comment");
        return null;
    }

    private final JsonToken _startValue(int i) throws IOException {
        if (i <= 32 && (i = _skipWS(i)) <= 0) {
            this._minorState = 12;
            return this._currToken;
        }
        _updateTokenLocation();
        this._parsingContext.expectComma();
        if (i == 34) {
            return _startString();
        }
        if (i == 35) {
            return _finishHashComment(12);
        }
        if (i == 43) {
            return _startPositiveNumber();
        }
        if (i == 91) {
            return _startArrayScope();
        }
        if (i == 93) {
            return _closeArrayScope();
        }
        if (i == 102) {
            return _startFalseToken();
        }
        if (i == 110) {
            return _startNullToken();
        }
        if (i == 116) {
            return _startTrueToken();
        }
        if (i == 123) {
            return _startObjectScope();
        }
        if (i == 125) {
            return _closeObjectScope();
        }
        switch (i) {
            case 45:
                return _startNegativeNumber();
            case 46:
                if (isEnabled(JsonReadFeature.ALLOW_LEADING_DECIMAL_POINT_FOR_NUMBERS.mappedFeature())) {
                    return _startFloatThatStartsWithPeriod();
                }
                break;
            case 47:
                return _startSlashComment(12);
            case 48:
                return _startNumberLeadingZero();
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
            case 56:
            case 57:
                return _startPositiveNumber(i);
        }
        return _startUnexpectedValue(false, i);
    }

    private final JsonToken _startValueAfterComma(int i) throws IOException {
        if (i <= 32 && (i = _skipWS(i)) <= 0) {
            this._minorState = 15;
            return this._currToken;
        }
        _updateTokenLocation();
        if (i == 34) {
            return _startString();
        }
        if (i == 35) {
            return _finishHashComment(15);
        }
        if (i == 43) {
            return _startPositiveNumber();
        }
        if (i == 45) {
            return _startNegativeNumber();
        }
        if (i == 91) {
            return _startArrayScope();
        }
        if (i != 93) {
            if (i == 102) {
                return _startFalseToken();
            }
            if (i == 110) {
                return _startNullToken();
            }
            if (i == 116) {
                return _startTrueToken();
            }
            if (i == 123) {
                return _startObjectScope();
            }
            if (i != 125) {
                switch (i) {
                    case 47:
                        return _startSlashComment(15);
                    case 48:
                        return _startNumberLeadingZero();
                    case 49:
                    case 50:
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                    case 56:
                    case 57:
                        return _startPositiveNumber(i);
                }
            }
            if ((this._features & FEAT_MASK_TRAILING_COMMA) != 0) {
                return _closeObjectScope();
            }
        } else if ((this._features & FEAT_MASK_TRAILING_COMMA) != 0) {
            return _closeArrayScope();
        }
        return _startUnexpectedValue(true, i);
    }

    private final JsonToken _startValueExpectColon(int i) throws IOException {
        if (i <= 32 && (i = _skipWS(i)) <= 0) {
            this._minorState = 14;
            return this._currToken;
        }
        if (i != 58) {
            if (i == 47) {
                return _startSlashComment(14);
            }
            if (i == 35) {
                return _finishHashComment(14);
            }
            _reportUnexpectedChar(i, "was expecting a colon to separate field name and value");
        }
        int i6 = this._inputPtr;
        if (i6 >= this._inputEnd) {
            this._minorState = 12;
            return _updateTokenToNA();
        }
        int byteFromBuffer = getByteFromBuffer(i6);
        this._inputPtr = i6 + 1;
        if (byteFromBuffer <= 32 && (byteFromBuffer = _skipWS(byteFromBuffer)) <= 0) {
            this._minorState = 12;
            return this._currToken;
        }
        _updateTokenLocation();
        if (byteFromBuffer == 34) {
            return _startString();
        }
        if (byteFromBuffer == 35) {
            return _finishHashComment(12);
        }
        if (byteFromBuffer == 43) {
            return _startPositiveNumber();
        }
        if (byteFromBuffer == 45) {
            return _startNegativeNumber();
        }
        if (byteFromBuffer == 91) {
            return _startArrayScope();
        }
        if (byteFromBuffer == 102) {
            return _startFalseToken();
        }
        if (byteFromBuffer == 110) {
            return _startNullToken();
        }
        if (byteFromBuffer == 116) {
            return _startTrueToken();
        }
        if (byteFromBuffer == 123) {
            return _startObjectScope();
        }
        switch (byteFromBuffer) {
            case 47:
                return _startSlashComment(12);
            case 48:
                return _startNumberLeadingZero();
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
            case 56:
            case 57:
                return _startPositiveNumber(byteFromBuffer);
            default:
                return _startUnexpectedValue(false, byteFromBuffer);
        }
    }

    private final JsonToken _startValueExpectComma(int i) throws IOException {
        if (i <= 32 && (i = _skipWS(i)) <= 0) {
            this._minorState = 13;
            return this._currToken;
        }
        if (i != 44) {
            if (i == 93) {
                return _closeArrayScope();
            }
            if (i == 125) {
                return _closeObjectScope();
            }
            if (i == 47) {
                return _startSlashComment(13);
            }
            if (i == 35) {
                return _finishHashComment(13);
            }
            _reportUnexpectedChar(i, "was expecting comma to separate " + this._parsingContext.typeDesc() + " entries");
        }
        this._parsingContext.expectComma();
        int i6 = this._inputPtr;
        if (i6 >= this._inputEnd) {
            this._minorState = 15;
            return _updateTokenToNA();
        }
        int byteFromBuffer = getByteFromBuffer(i6);
        this._inputPtr = i6 + 1;
        if (byteFromBuffer <= 32 && (byteFromBuffer = _skipWS(byteFromBuffer)) <= 0) {
            this._minorState = 15;
            return this._currToken;
        }
        _updateTokenLocation();
        if (byteFromBuffer == 34) {
            return _startString();
        }
        if (byteFromBuffer == 35) {
            return _finishHashComment(15);
        }
        if (byteFromBuffer == 43) {
            return _startPositiveNumber();
        }
        if (byteFromBuffer == 45) {
            return _startNegativeNumber();
        }
        if (byteFromBuffer == 91) {
            return _startArrayScope();
        }
        if (byteFromBuffer != 93) {
            if (byteFromBuffer == 102) {
                return _startFalseToken();
            }
            if (byteFromBuffer == 110) {
                return _startNullToken();
            }
            if (byteFromBuffer == 116) {
                return _startTrueToken();
            }
            if (byteFromBuffer == 123) {
                return _startObjectScope();
            }
            if (byteFromBuffer != 125) {
                switch (byteFromBuffer) {
                    case 47:
                        return _startSlashComment(15);
                    case 48:
                        return _startNumberLeadingZero();
                    case 49:
                    case 50:
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                    case 56:
                    case 57:
                        return _startPositiveNumber(byteFromBuffer);
                }
            }
            if ((this._features & FEAT_MASK_TRAILING_COMMA) != 0) {
                return _closeObjectScope();
            }
        } else if ((this._features & FEAT_MASK_TRAILING_COMMA) != 0) {
            return _closeArrayScope();
        }
        return _startUnexpectedValue(true, byteFromBuffer);
    }

    @Override // com.fasterxml.jackson.core.base.ParserBase
    public char _decodeEscaped() throws IOException {
        VersionUtil.throwInternal();
        return ' ';
    }

    public JsonToken _finishErrorToken() throws IOException {
        while (this._inputPtr < this._inputEnd) {
            char nextSignedByteFromBuffer = (char) getNextSignedByteFromBuffer();
            if (Character.isJavaIdentifierPart(nextSignedByteFromBuffer)) {
                this._textBuffer.append(nextSignedByteFromBuffer);
                if (this._textBuffer.size() < this._ioContext.errorReportConfiguration().getMaxErrorTokenLength()) {
                }
            }
            return _reportErrorToken(this._textBuffer.contentsAsString());
        }
        return _updateTokenToNA();
    }

    public JsonToken _finishErrorTokenWithEOF() throws IOException {
        return _reportErrorToken(this._textBuffer.contentsAsString());
    }

    public final JsonToken _finishFieldWithEscape() throws IOException {
        int i;
        int i6;
        int i_decodeSplitEscaped = _decodeSplitEscaped(this._quoted32, this._quotedDigits);
        if (i_decodeSplitEscaped < 0) {
            this._minorState = 8;
            return JsonToken.NOT_AVAILABLE;
        }
        int i10 = this._quadLength;
        int[] iArr = this._quadBuffer;
        if (i10 >= iArr.length) {
            this._quadBuffer = _growNameDecodeBuffer(iArr, 32);
        }
        int i11 = this._pending32;
        int i12 = this._pendingBytes;
        int i13 = 1;
        if (i_decodeSplitEscaped > 127) {
            int i14 = 0;
            if (i12 >= 4) {
                int[] iArr2 = this._quadBuffer;
                int i15 = this._quadLength;
                this._quadLength = i15 + 1;
                iArr2[i15] = i11;
                i11 = 0;
                i12 = 0;
            }
            if (i_decodeSplitEscaped < 2048) {
                i = i11 << 8;
                i6 = (i_decodeSplitEscaped >> 6) | 192;
            } else {
                int i16 = (i11 << 8) | (i_decodeSplitEscaped >> 12) | 224;
                i12++;
                if (i12 >= 4) {
                    int[] iArr3 = this._quadBuffer;
                    int i17 = this._quadLength;
                    this._quadLength = i17 + 1;
                    iArr3[i17] = i16;
                    i12 = 0;
                } else {
                    i14 = i16;
                }
                i = i14 << 8;
                i6 = ((i_decodeSplitEscaped >> 6) & 63) | 128;
            }
            i11 = i | i6;
            i12++;
            i_decodeSplitEscaped = (i_decodeSplitEscaped & 63) | 128;
        }
        if (i12 < 4) {
            i13 = 1 + i12;
            i_decodeSplitEscaped |= i11 << 8;
        } else {
            int[] iArr4 = this._quadBuffer;
            int i18 = this._quadLength;
            this._quadLength = i18 + 1;
            iArr4[i18] = i11;
        }
        return this._minorStateAfterSplit == 9 ? _finishAposName(this._quadLength, i_decodeSplitEscaped, i13) : _parseEscapedName(this._quadLength, i_decodeSplitEscaped, i13);
    }

    public JsonToken _finishFloatExponent(boolean z10, int i) throws IOException {
        if (z10) {
            this._minorState = 32;
            if (i == 45 || i == 43) {
                this._textBuffer.append((char) i);
                if (this._inputPtr >= this._inputEnd) {
                    this._minorState = 32;
                    this._expLength = 0;
                    return JsonToken.NOT_AVAILABLE;
                }
                i = getNextSignedByteFromBuffer();
            }
        }
        char[] bufferWithoutReset = this._textBuffer.getBufferWithoutReset();
        int currentSegmentSize = this._textBuffer.getCurrentSegmentSize();
        int i6 = this._expLength;
        while (i >= 48 && i <= 57) {
            i6++;
            if (currentSegmentSize >= bufferWithoutReset.length) {
                bufferWithoutReset = this._textBuffer.expandCurrentSegment();
            }
            int i10 = currentSegmentSize + 1;
            bufferWithoutReset[currentSegmentSize] = (char) i;
            if (this._inputPtr >= this._inputEnd) {
                this._textBuffer.setCurrentLength(i10);
                this._expLength = i6;
                return JsonToken.NOT_AVAILABLE;
            }
            i = getNextSignedByteFromBuffer();
            currentSegmentSize = i10;
        }
        int i11 = i & 255;
        if (i6 == 0) {
            _reportUnexpectedNumberChar(i11, "Exponent indicator not followed by a digit");
        }
        this._inputPtr--;
        this._textBuffer.setCurrentLength(currentSegmentSize);
        this._expLength = i6;
        return _valueComplete(JsonToken.VALUE_NUMBER_FLOAT);
    }

    public JsonToken _finishFloatFraction() throws IOException {
        int i = this._fractLength;
        char[] bufferWithoutReset = this._textBuffer.getBufferWithoutReset();
        int currentSegmentSize = this._textBuffer.getCurrentSegmentSize();
        byte nextSignedByteFromBuffer = getNextSignedByteFromBuffer();
        boolean z10 = true;
        while (z10) {
            if (nextSignedByteFromBuffer >= 48 && nextSignedByteFromBuffer <= 57) {
                i++;
                if (currentSegmentSize >= bufferWithoutReset.length) {
                    bufferWithoutReset = this._textBuffer.expandCurrentSegment();
                }
                int i6 = currentSegmentSize + 1;
                bufferWithoutReset[currentSegmentSize] = (char) nextSignedByteFromBuffer;
                if (this._inputPtr >= this._inputEnd) {
                    this._textBuffer.setCurrentLength(i6);
                    this._fractLength = i;
                    return JsonToken.NOT_AVAILABLE;
                }
                nextSignedByteFromBuffer = getNextSignedByteFromBuffer();
                currentSegmentSize = i6;
            } else if ((nextSignedByteFromBuffer | 34) == 102) {
                _reportUnexpectedNumberChar(nextSignedByteFromBuffer, "JSON does not support parsing numbers that have 'f' or 'd' suffixes");
            } else if (nextSignedByteFromBuffer == 46) {
                _reportUnexpectedNumberChar(nextSignedByteFromBuffer, "Cannot parse number with more than one decimal point");
            } else {
                z10 = false;
            }
        }
        if (i == 0 && !isEnabled(JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS.mappedFeature())) {
            _reportUnexpectedNumberChar(nextSignedByteFromBuffer, "Decimal point not followed by a digit");
        }
        this._fractLength = i;
        this._textBuffer.setCurrentLength(currentSegmentSize);
        if ((nextSignedByteFromBuffer | 32) != 101) {
            this._inputPtr--;
            this._textBuffer.setCurrentLength(currentSegmentSize);
            this._expLength = 0;
            return _valueComplete(JsonToken.VALUE_NUMBER_FLOAT);
        }
        this._textBuffer.append((char) nextSignedByteFromBuffer);
        this._expLength = 0;
        if (this._inputPtr >= this._inputEnd) {
            this._minorState = 31;
            return JsonToken.NOT_AVAILABLE;
        }
        this._minorState = 32;
        return _finishFloatExponent(true, getNextUnsignedByteFromBuffer());
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x002c, code lost:
    
        r3._minorState = 50;
        r3._textBuffer.resetWithCopy(r4, 0, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003a, code lost:
    
        return _finishErrorToken();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.fasterxml.jackson.core.JsonToken _finishKeywordToken(java.lang.String r4, int r5, com.fasterxml.jackson.core.JsonToken r6) throws java.io.IOException {
        /*
            r3 = this;
            int r0 = r4.length()
        L4:
            int r1 = r3._inputPtr
            int r2 = r3._inputEnd
            if (r1 < r2) goto L11
            r3._pending32 = r5
            com.fasterxml.jackson.core.JsonToken r3 = r3._updateTokenToNA()
            return r3
        L11:
            byte r1 = r3.getByteFromBuffer(r1)
            if (r5 != r0) goto L26
            r0 = 48
            if (r1 < r0) goto L21
            r0 = r1 | 32
            r1 = 125(0x7d, float:1.75E-43)
            if (r0 != r1) goto L2c
        L21:
            com.fasterxml.jackson.core.JsonToken r3 = r3._valueComplete(r6)
            return r3
        L26:
            char r2 = r4.charAt(r5)
            if (r1 == r2) goto L3b
        L2c:
            r6 = 50
            r3._minorState = r6
            com.fasterxml.jackson.core.util.TextBuffer r6 = r3._textBuffer
            r0 = 0
            r6.resetWithCopy(r4, r0, r5)
            com.fasterxml.jackson.core.JsonToken r3 = r3._finishErrorToken()
            return r3
        L3b:
            int r5 = r5 + 1
            int r1 = r3._inputPtr
            int r1 = r1 + 1
            r3._inputPtr = r1
            goto L4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.async.NonBlockingUtf8JsonParserBase._finishKeywordToken(java.lang.String, int, com.fasterxml.jackson.core.JsonToken):com.fasterxml.jackson.core.JsonToken");
    }

    public JsonToken _finishKeywordTokenWithEOF(String str, int i, JsonToken jsonToken) throws IOException {
        if (i == str.length()) {
            return _updateToken(jsonToken);
        }
        this._textBuffer.resetWithCopy(str, 0, i);
        return _finishErrorTokenWithEOF();
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0036, code lost:
    
        r4._minorState = 50;
        r4._textBuffer.resetWithCopy(r0, 0, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0044, code lost:
    
        return _finishErrorToken();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.fasterxml.jackson.core.JsonToken _finishNonStdToken(int r5, int r6) throws java.io.IOException {
        /*
            r4 = this;
            java.lang.String r0 = r4._nonStdToken(r5)
            int r1 = r0.length()
        L8:
            int r2 = r4._inputPtr
            int r3 = r4._inputEnd
            if (r2 < r3) goto L1b
            r4._nonStdTokenType = r5
            r4._pending32 = r6
            r5 = 19
            r4._minorState = r5
            com.fasterxml.jackson.core.JsonToken r4 = r4._updateTokenToNA()
            return r4
        L1b:
            byte r2 = r4.getByteFromBuffer(r2)
            if (r6 != r1) goto L30
            r1 = 48
            if (r2 < r1) goto L2b
            r1 = r2 | 32
            r2 = 125(0x7d, float:1.75E-43)
            if (r1 != r2) goto L36
        L2b:
            com.fasterxml.jackson.core.JsonToken r4 = r4._valueNonStdNumberComplete(r5)
            return r4
        L30:
            char r3 = r0.charAt(r6)
            if (r2 == r3) goto L45
        L36:
            r5 = 50
            r4._minorState = r5
            com.fasterxml.jackson.core.util.TextBuffer r5 = r4._textBuffer
            r1 = 0
            r5.resetWithCopy(r0, r1, r6)
            com.fasterxml.jackson.core.JsonToken r4 = r4._finishErrorToken()
            return r4
        L45:
            int r6 = r6 + 1
            int r2 = r4._inputPtr
            int r2 = r2 + 1
            r4._inputPtr = r2
            goto L8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.async.NonBlockingUtf8JsonParserBase._finishNonStdToken(int, int):com.fasterxml.jackson.core.JsonToken");
    }

    public JsonToken _finishNonStdTokenWithEOF(int i, int i6) throws IOException {
        String str_nonStdToken = _nonStdToken(i);
        if (i6 == str_nonStdToken.length()) {
            return _valueNonStdNumberComplete(i);
        }
        this._textBuffer.resetWithCopy(str_nonStdToken, 0, i6);
        return _finishErrorTokenWithEOF();
    }

    public JsonToken _finishNumberIntegralPart(char[] cArr, int i) throws IOException {
        int i6 = this._numberNegative ? -1 : 0;
        while (true) {
            int i10 = this._inputPtr;
            if (i10 >= this._inputEnd) {
                this._minorState = 26;
                this._textBuffer.setCurrentLength(i);
                return _updateTokenToNA();
            }
            int byteFromBuffer = getByteFromBuffer(i10) & 255;
            if (byteFromBuffer < 48) {
                if (byteFromBuffer == 46) {
                    this._intLength = i6 + i;
                    this._inputPtr++;
                    return _startFloat(cArr, i, byteFromBuffer);
                }
            } else if (byteFromBuffer <= 57) {
                this._inputPtr++;
                if (i >= cArr.length) {
                    cArr = this._textBuffer.expandCurrentSegment();
                }
                cArr[i] = (char) byteFromBuffer;
                i++;
            } else if ((byteFromBuffer | 32) == 101) {
                this._intLength = i6 + i;
                this._inputPtr++;
                return _startFloat(cArr, i, byteFromBuffer);
            }
        }
        this._intLength = i6 + i;
        this._textBuffer.setCurrentLength(i);
        return _valueComplete(JsonToken.VALUE_NUMBER_INT);
    }

    public JsonToken _finishNumberLeadingNegZeroes() throws IOException {
        return _finishNumberLeadingPosNegZeroes(true);
    }

    public JsonToken _finishNumberLeadingPosNegZeroes(boolean z10) throws IOException {
        while (this._inputPtr < this._inputEnd) {
            int nextUnsignedByteFromBuffer = getNextUnsignedByteFromBuffer();
            if (nextUnsignedByteFromBuffer < 48) {
                if (nextUnsignedByteFromBuffer == 46) {
                    char[] cArrEmptyAndGetCurrentSegment = this._textBuffer.emptyAndGetCurrentSegment();
                    cArrEmptyAndGetCurrentSegment[0] = z10 ? '-' : '+';
                    cArrEmptyAndGetCurrentSegment[1] = '0';
                    this._intLength = 1;
                    return _startFloat(cArrEmptyAndGetCurrentSegment, 2, nextUnsignedByteFromBuffer);
                }
            } else if (nextUnsignedByteFromBuffer > 57) {
                int i = nextUnsignedByteFromBuffer | 32;
                if (i == 101) {
                    char[] cArrEmptyAndGetCurrentSegment2 = this._textBuffer.emptyAndGetCurrentSegment();
                    cArrEmptyAndGetCurrentSegment2[0] = z10 ? '-' : '+';
                    cArrEmptyAndGetCurrentSegment2[1] = '0';
                    this._intLength = 1;
                    return _startFloat(cArrEmptyAndGetCurrentSegment2, 2, nextUnsignedByteFromBuffer);
                }
                if (i != 125) {
                    _reportUnexpectedNumberChar(nextUnsignedByteFromBuffer, "expected digit (0-9), decimal point (.) or exponent indicator (e/E) to follow '0'");
                }
            } else {
                if ((this._features & FEAT_MASK_LEADING_ZEROS) == 0) {
                    reportInvalidNumber("Leading zeroes not allowed");
                }
                if (nextUnsignedByteFromBuffer != 48) {
                    char[] cArrEmptyAndGetCurrentSegment3 = this._textBuffer.emptyAndGetCurrentSegment();
                    cArrEmptyAndGetCurrentSegment3[0] = z10 ? '-' : '+';
                    cArrEmptyAndGetCurrentSegment3[1] = (char) nextUnsignedByteFromBuffer;
                    this._intLength = 1;
                    return _finishNumberIntegralPart(cArrEmptyAndGetCurrentSegment3, 2);
                }
            }
            this._inputPtr--;
            return _valueCompleteInt(0, "0");
        }
        this._minorState = z10 ? 25 : 24;
        return _updateTokenToNA();
    }

    public JsonToken _finishNumberLeadingPosZeroes() throws IOException {
        return _finishNumberLeadingPosNegZeroes(false);
    }

    public JsonToken _finishNumberLeadingZeroes() throws IOException {
        while (this._inputPtr < this._inputEnd) {
            int nextUnsignedByteFromBuffer = getNextUnsignedByteFromBuffer();
            if (nextUnsignedByteFromBuffer < 48) {
                if (nextUnsignedByteFromBuffer == 46) {
                    char[] cArrEmptyAndGetCurrentSegment = this._textBuffer.emptyAndGetCurrentSegment();
                    cArrEmptyAndGetCurrentSegment[0] = '0';
                    this._intLength = 1;
                    return _startFloat(cArrEmptyAndGetCurrentSegment, 1, nextUnsignedByteFromBuffer);
                }
            } else if (nextUnsignedByteFromBuffer > 57) {
                int i = nextUnsignedByteFromBuffer | 32;
                if (i == 101) {
                    char[] cArrEmptyAndGetCurrentSegment2 = this._textBuffer.emptyAndGetCurrentSegment();
                    cArrEmptyAndGetCurrentSegment2[0] = '0';
                    this._intLength = 1;
                    return _startFloat(cArrEmptyAndGetCurrentSegment2, 1, nextUnsignedByteFromBuffer);
                }
                if (i != 125) {
                    _reportUnexpectedNumberChar(nextUnsignedByteFromBuffer, "expected digit (0-9), decimal point (.) or exponent indicator (e/E) to follow '0'");
                }
            } else {
                if ((this._features & FEAT_MASK_LEADING_ZEROS) == 0) {
                    reportInvalidNumber("Leading zeroes not allowed");
                }
                if (nextUnsignedByteFromBuffer != 48) {
                    char[] cArrEmptyAndGetCurrentSegment3 = this._textBuffer.emptyAndGetCurrentSegment();
                    cArrEmptyAndGetCurrentSegment3[0] = (char) nextUnsignedByteFromBuffer;
                    this._intLength = 1;
                    return _finishNumberIntegralPart(cArrEmptyAndGetCurrentSegment3, 1);
                }
            }
            this._inputPtr--;
            return _valueCompleteInt(0, "0");
        }
        this._minorState = 24;
        return _updateTokenToNA();
    }

    public JsonToken _finishNumberMinus(int i) throws IOException {
        return _finishNumberPlusMinus(i, true);
    }

    public JsonToken _finishNumberPlus(int i) throws IOException {
        return _finishNumberPlusMinus(i, false);
    }

    public JsonToken _finishNumberPlusMinus(int i, boolean z10) throws IOException {
        if (i <= 48) {
            if (i == 48) {
                if (z10) {
                    return _finishNumberLeadingNegZeroes();
                }
                if (!isEnabled(JsonReadFeature.ALLOW_LEADING_PLUS_SIGN_FOR_NUMBERS.mappedFeature())) {
                    _reportUnexpectedNumberChar(43, "JSON spec does not allow numbers to have plus signs: enable `JsonReadFeature.ALLOW_LEADING_PLUS_SIGN_FOR_NUMBERS` to allow");
                }
                return _finishNumberLeadingPosZeroes();
            }
            if (i == 46 && isEnabled(JsonReadFeature.ALLOW_LEADING_DECIMAL_POINT_FOR_NUMBERS.mappedFeature())) {
                if (z10) {
                    this._inputPtr--;
                    return _finishNumberLeadingNegZeroes();
                }
                if (!isEnabled(JsonReadFeature.ALLOW_LEADING_PLUS_SIGN_FOR_NUMBERS.mappedFeature())) {
                    _reportUnexpectedNumberChar(43, "JSON spec does not allow numbers to have plus signs: enable `JsonReadFeature.ALLOW_LEADING_PLUS_SIGN_FOR_NUMBERS` to allow");
                }
                this._inputPtr--;
                return _finishNumberLeadingPosZeroes();
            }
            _reportUnexpectedNumberChar(i, z10 ? "expected digit (0-9) to follow minus sign, for valid numeric value" : "expected digit (0-9) for valid numeric value");
        } else if (i > 57) {
            if (i == 73) {
                return _finishNonStdToken(z10 ? 3 : 2, 2);
            }
            _reportUnexpectedNumberChar(i, z10 ? "expected digit (0-9) to follow minus sign, for valid numeric value" : "expected digit (0-9) for valid numeric value");
        }
        if (!z10 && !isEnabled(JsonReadFeature.ALLOW_LEADING_PLUS_SIGN_FOR_NUMBERS.mappedFeature())) {
            _reportUnexpectedNumberChar(43, "JSON spec does not allow numbers to have plus signs: enable `JsonReadFeature.ALLOW_LEADING_PLUS_SIGN_FOR_NUMBERS` to allow");
        }
        char[] cArrEmptyAndGetCurrentSegment = this._textBuffer.emptyAndGetCurrentSegment();
        cArrEmptyAndGetCurrentSegment[0] = z10 ? '-' : '+';
        cArrEmptyAndGetCurrentSegment[1] = (char) i;
        this._intLength = 1;
        return _finishNumberIntegralPart(cArrEmptyAndGetCurrentSegment, 2);
    }

    public final JsonToken _finishToken() throws IOException {
        int i = this._minorState;
        if (i == 1) {
            return _finishBOM(this._pending32);
        }
        if (i == 4) {
            return _startFieldName(getNextUnsignedByteFromBuffer());
        }
        if (i == 5) {
            return _startFieldNameAfterComma(getNextUnsignedByteFromBuffer());
        }
        switch (i) {
            case 7:
                return _parseEscapedName(this._quadLength, this._pending32, this._pendingBytes);
            case 8:
                return _finishFieldWithEscape();
            case 9:
                return _finishAposName(this._quadLength, this._pending32, this._pendingBytes);
            case 10:
                return _finishUnquotedName(this._quadLength, this._pending32, this._pendingBytes);
            default:
                switch (i) {
                    case 12:
                        return _startValue(getNextUnsignedByteFromBuffer());
                    case 13:
                        return _startValueExpectComma(getNextUnsignedByteFromBuffer());
                    case 14:
                        return _startValueExpectColon(getNextUnsignedByteFromBuffer());
                    case 15:
                        return _startValueAfterComma(getNextUnsignedByteFromBuffer());
                    case 16:
                        return _finishKeywordToken("null", this._pending32, JsonToken.VALUE_NULL);
                    case 17:
                        return _finishKeywordToken("true", this._pending32, JsonToken.VALUE_TRUE);
                    case 18:
                        return _finishKeywordToken("false", this._pending32, JsonToken.VALUE_FALSE);
                    case 19:
                        return _finishNonStdToken(this._nonStdTokenType, this._pending32);
                    default:
                        switch (i) {
                            case 22:
                                return _finishNumberPlus(getNextUnsignedByteFromBuffer());
                            case 23:
                                return _finishNumberMinus(getNextUnsignedByteFromBuffer());
                            case 24:
                                return _finishNumberLeadingZeroes();
                            case 25:
                                return _finishNumberLeadingNegZeroes();
                            case 26:
                                return _finishNumberIntegralPart(this._textBuffer.getBufferWithoutReset(), this._textBuffer.getCurrentSegmentSize());
                            default:
                                switch (i) {
                                    case 30:
                                        return _finishFloatFraction();
                                    case 31:
                                        return _finishFloatExponent(true, getNextUnsignedByteFromBuffer());
                                    case 32:
                                        return _finishFloatExponent(false, getNextUnsignedByteFromBuffer());
                                    default:
                                        switch (i) {
                                            case 40:
                                                return _finishRegularString();
                                            case 41:
                                                int i_decodeSplitEscaped = _decodeSplitEscaped(this._quoted32, this._quotedDigits);
                                                if (i_decodeSplitEscaped < 0) {
                                                    return JsonToken.NOT_AVAILABLE;
                                                }
                                                this._textBuffer.append((char) i_decodeSplitEscaped);
                                                return this._minorStateAfterSplit == 45 ? _finishAposString() : _finishRegularString();
                                            case 42:
                                                this._textBuffer.append((char) _decodeUTF8_2(this._pending32, getNextSignedByteFromBuffer()));
                                                return this._minorStateAfterSplit == 45 ? _finishAposString() : _finishRegularString();
                                            case 43:
                                                return !_decodeSplitUTF8_3(this._pending32, this._pendingBytes, getNextSignedByteFromBuffer()) ? JsonToken.NOT_AVAILABLE : this._minorStateAfterSplit == 45 ? _finishAposString() : _finishRegularString();
                                            case 44:
                                                return !_decodeSplitUTF8_4(this._pending32, this._pendingBytes, getNextSignedByteFromBuffer()) ? JsonToken.NOT_AVAILABLE : this._minorStateAfterSplit == 45 ? _finishAposString() : _finishRegularString();
                                            case 45:
                                                return _finishAposString();
                                            default:
                                                switch (i) {
                                                    case 50:
                                                        return _finishErrorToken();
                                                    case 51:
                                                        return _startSlashComment(this._pending32);
                                                    case 52:
                                                        return _finishCComment(this._pending32, true);
                                                    case 53:
                                                        return _finishCComment(this._pending32, false);
                                                    case 54:
                                                        return _finishCppComment(this._pending32);
                                                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                                                        return _finishHashComment(this._pending32);
                                                    default:
                                                        VersionUtil.throwInternal();
                                                        return null;
                                                }
                                        }
                                }
                        }
                }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final JsonToken _finishTokenWithEOF() throws IOException {
        JsonToken jsonToken = this._currToken;
        int i = this._minorState;
        if (i != 3 && i != 12) {
            if (i == 50) {
                return _finishErrorTokenWithEOF();
            }
            switch (i) {
                case 16:
                    return _finishKeywordTokenWithEOF("null", this._pending32, JsonToken.VALUE_NULL);
                case 17:
                    return _finishKeywordTokenWithEOF("true", this._pending32, JsonToken.VALUE_TRUE);
                case 18:
                    return _finishKeywordTokenWithEOF("false", this._pending32, JsonToken.VALUE_FALSE);
                case 19:
                    return _finishNonStdTokenWithEOF(this._nonStdTokenType, this._pending32);
                default:
                    switch (i) {
                        case 24:
                        case 25:
                            return _valueCompleteInt(0, "0");
                        case 26:
                            int currentSegmentSize = this._textBuffer.getCurrentSegmentSize();
                            if (this._numberNegative) {
                                currentSegmentSize--;
                            }
                            this._intLength = currentSegmentSize;
                            return _valueComplete(JsonToken.VALUE_NUMBER_INT);
                        default:
                            switch (i) {
                                case 30:
                                    this._expLength = 0;
                                    return _valueComplete(JsonToken.VALUE_NUMBER_FLOAT);
                                case 31:
                                    _reportInvalidEOF(": was expecting fraction after exponent marker", JsonToken.VALUE_NUMBER_FLOAT);
                                    _reportInvalidEOF(": was expecting closing '*/' for comment", JsonToken.NOT_AVAILABLE);
                                    return _eofAsNextToken();
                                case 32:
                                    return _valueComplete(JsonToken.VALUE_NUMBER_FLOAT);
                                default:
                                    switch (i) {
                                        case 52:
                                        case 53:
                                            _reportInvalidEOF(": was expecting closing '*/' for comment", JsonToken.NOT_AVAILABLE);
                                            break;
                                        case 54:
                                        case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                                            break;
                                        default:
                                            _reportInvalidEOF(a.o(new StringBuilder(": was expecting rest of token (internal state: "), ")", this._minorState), this._currToken);
                                            return jsonToken;
                                    }
                                    return _eofAsNextToken();
                            }
                    }
            }
        }
        return _eofAsNextToken();
    }

    public JsonToken _reportErrorToken(String str) throws IOException {
        _reportError("Unrecognized token '%s': was expecting %s", this._textBuffer.contentsAsString(), _validJsonTokenList());
        return JsonToken.NOT_AVAILABLE;
    }

    public JsonToken _startAposString() throws IOException {
        int i = this._inputPtr;
        char[] cArrEmptyAndGetCurrentSegment = this._textBuffer.emptyAndGetCurrentSegment();
        int[] iArr = _icUTF8;
        int iMin = Math.min(this._inputEnd, cArrEmptyAndGetCurrentSegment.length + i);
        int i6 = 0;
        while (i < iMin) {
            int byteFromBuffer = getByteFromBuffer(i) & 255;
            if (byteFromBuffer == 39) {
                this._inputPtr = i + 1;
                this._textBuffer.setCurrentLength(i6);
                return _valueComplete(JsonToken.VALUE_STRING);
            }
            if (iArr[byteFromBuffer] != 0) {
                break;
            }
            i++;
            cArrEmptyAndGetCurrentSegment[i6] = (char) byteFromBuffer;
            i6++;
        }
        this._textBuffer.setCurrentLength(i6);
        this._inputPtr = i;
        return _finishAposString();
    }

    public JsonToken _startFalseToken() throws IOException {
        int byteFromBuffer;
        int i = this._inputPtr;
        if (i + 4 < this._inputEnd) {
            int i6 = i + 1;
            if (getByteFromBuffer(i) == 97) {
                int i10 = i + 2;
                if (getByteFromBuffer(i6) == 108) {
                    int i11 = i + 3;
                    if (getByteFromBuffer(i10) == 115) {
                        int i12 = i + 4;
                        if (getByteFromBuffer(i11) == 101 && ((byteFromBuffer = getByteFromBuffer(i12) & 255) < 48 || (byteFromBuffer | 32) == 125)) {
                            this._inputPtr = i12;
                            return _valueComplete(JsonToken.VALUE_FALSE);
                        }
                    }
                }
            }
        }
        this._minorState = 18;
        return _finishKeywordToken("false", 1, JsonToken.VALUE_FALSE);
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x00f5  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:58:0x00ec -> B:40:0x009c). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.fasterxml.jackson.core.JsonToken _startFloat(char[] r7, int r8, int r9) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 270
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.async.NonBlockingUtf8JsonParserBase._startFloat(char[], int, int):com.fasterxml.jackson.core.JsonToken");
    }

    public JsonToken _startFloatThatStartsWithPeriod() throws IOException {
        this._numberNegative = false;
        this._intLength = 0;
        return _startFloat(this._textBuffer.emptyAndGetCurrentSegment(), 0, 46);
    }

    public JsonToken _startNegativeNumber() throws IOException {
        this._numberNegative = true;
        if (this._inputPtr >= this._inputEnd) {
            this._minorState = 23;
            return _updateTokenToNA();
        }
        int nextUnsignedByteFromBuffer = getNextUnsignedByteFromBuffer();
        int i = 2;
        if (nextUnsignedByteFromBuffer <= 48) {
            if (nextUnsignedByteFromBuffer == 48) {
                return _finishNumberLeadingNegZeroes();
            }
            _reportUnexpectedNumberChar(nextUnsignedByteFromBuffer, "expected digit (0-9) to follow minus sign, for valid numeric value");
        } else if (nextUnsignedByteFromBuffer > 57) {
            if (nextUnsignedByteFromBuffer == 73) {
                return _finishNonStdToken(3, 2);
            }
            _reportUnexpectedNumberChar(nextUnsignedByteFromBuffer, "expected digit (0-9) to follow minus sign, for valid numeric value");
        }
        char[] cArrEmptyAndGetCurrentSegment = this._textBuffer.emptyAndGetCurrentSegment();
        cArrEmptyAndGetCurrentSegment[0] = '-';
        cArrEmptyAndGetCurrentSegment[1] = (char) nextUnsignedByteFromBuffer;
        int i6 = this._inputPtr;
        if (i6 >= this._inputEnd) {
            this._minorState = 26;
            this._textBuffer.setCurrentLength(2);
            this._intLength = 1;
            return _updateTokenToNA();
        }
        int byteFromBuffer = getByteFromBuffer(i6);
        while (true) {
            if (byteFromBuffer < 48) {
                if (byteFromBuffer == 46) {
                    this._intLength = i - 1;
                    this._inputPtr++;
                    return _startFloat(cArrEmptyAndGetCurrentSegment, i, byteFromBuffer);
                }
            } else if (byteFromBuffer <= 57) {
                if (i >= cArrEmptyAndGetCurrentSegment.length) {
                    cArrEmptyAndGetCurrentSegment = this._textBuffer.expandCurrentSegment();
                }
                int i10 = i + 1;
                cArrEmptyAndGetCurrentSegment[i] = (char) byteFromBuffer;
                int i11 = this._inputPtr + 1;
                this._inputPtr = i11;
                if (i11 >= this._inputEnd) {
                    this._minorState = 26;
                    this._textBuffer.setCurrentLength(i10);
                    return _updateTokenToNA();
                }
                byteFromBuffer = getByteFromBuffer(i11) & 255;
                i = i10;
            } else if ((byteFromBuffer | 32) == 101) {
                this._intLength = i - 1;
                this._inputPtr++;
                return _startFloat(cArrEmptyAndGetCurrentSegment, i, byteFromBuffer);
            }
        }
        this._intLength = i - 1;
        this._textBuffer.setCurrentLength(i);
        return _valueComplete(JsonToken.VALUE_NUMBER_INT);
    }

    public JsonToken _startNullToken() throws IOException {
        int byteFromBuffer;
        int i = this._inputPtr;
        if (i + 3 < this._inputEnd) {
            int i6 = i + 1;
            if (getByteFromBuffer(i) == 117) {
                int i10 = i + 2;
                if (getByteFromBuffer(i6) == 108) {
                    int i11 = i + 3;
                    if (getByteFromBuffer(i10) == 108 && ((byteFromBuffer = getByteFromBuffer(i11) & 255) < 48 || (byteFromBuffer | 32) == 125)) {
                        this._inputPtr = i11;
                        return _valueComplete(JsonToken.VALUE_NULL);
                    }
                }
            }
        }
        this._minorState = 16;
        return _finishKeywordToken("null", 1, JsonToken.VALUE_NULL);
    }

    public JsonToken _startNumberLeadingZero() throws IOException {
        int i = this._inputPtr;
        if (i >= this._inputEnd) {
            this._minorState = 24;
            return _updateTokenToNA();
        }
        int i6 = i + 1;
        int byteFromBuffer = getByteFromBuffer(i) & 255;
        if (byteFromBuffer < 48) {
            if (byteFromBuffer == 46) {
                this._inputPtr = i6;
                this._intLength = 1;
                char[] cArrEmptyAndGetCurrentSegment = this._textBuffer.emptyAndGetCurrentSegment();
                cArrEmptyAndGetCurrentSegment[0] = '0';
                return _startFloat(cArrEmptyAndGetCurrentSegment, 1, byteFromBuffer);
            }
        } else {
            if (byteFromBuffer <= 57) {
                return _finishNumberLeadingZeroes();
            }
            int i10 = byteFromBuffer | 32;
            if (i10 == 101) {
                this._inputPtr = i6;
                this._intLength = 1;
                char[] cArrEmptyAndGetCurrentSegment2 = this._textBuffer.emptyAndGetCurrentSegment();
                cArrEmptyAndGetCurrentSegment2[0] = '0';
                return _startFloat(cArrEmptyAndGetCurrentSegment2, 1, byteFromBuffer);
            }
            if (i10 != 125) {
                _reportUnexpectedNumberChar(byteFromBuffer, "expected digit (0-9), decimal point (.) or exponent indicator (e/E) to follow '0'");
            }
        }
        return _valueCompleteInt(0, "0");
    }

    public JsonToken _startPositiveNumber(int i) throws IOException {
        this._numberNegative = false;
        char[] cArrEmptyAndGetCurrentSegment = this._textBuffer.emptyAndGetCurrentSegment();
        cArrEmptyAndGetCurrentSegment[0] = (char) i;
        int i6 = this._inputPtr;
        if (i6 >= this._inputEnd) {
            this._minorState = 26;
            this._textBuffer.setCurrentLength(1);
            return _updateTokenToNA();
        }
        int byteFromBuffer = getByteFromBuffer(i6) & 255;
        int i10 = 1;
        while (true) {
            if (byteFromBuffer < 48) {
                if (byteFromBuffer == 46) {
                    this._intLength = i10;
                    this._inputPtr++;
                    return _startFloat(cArrEmptyAndGetCurrentSegment, i10, byteFromBuffer);
                }
            } else if (byteFromBuffer <= 57) {
                if (i10 >= cArrEmptyAndGetCurrentSegment.length) {
                    cArrEmptyAndGetCurrentSegment = this._textBuffer.expandCurrentSegment();
                }
                int i11 = i10 + 1;
                cArrEmptyAndGetCurrentSegment[i10] = (char) byteFromBuffer;
                int i12 = this._inputPtr + 1;
                this._inputPtr = i12;
                if (i12 >= this._inputEnd) {
                    this._minorState = 26;
                    this._textBuffer.setCurrentLength(i11);
                    return _updateTokenToNA();
                }
                byteFromBuffer = getByteFromBuffer(i12) & 255;
                i10 = i11;
            } else if ((byteFromBuffer | 32) == 101) {
                this._intLength = i10;
                this._inputPtr++;
                return _startFloat(cArrEmptyAndGetCurrentSegment, i10, byteFromBuffer);
            }
        }
        this._intLength = i10;
        this._textBuffer.setCurrentLength(i10);
        return _valueComplete(JsonToken.VALUE_NUMBER_INT);
    }

    public JsonToken _startString() throws IOException {
        int i = this._inputPtr;
        char[] cArrEmptyAndGetCurrentSegment = this._textBuffer.emptyAndGetCurrentSegment();
        int[] iArr = _icUTF8;
        int iMin = Math.min(this._inputEnd, cArrEmptyAndGetCurrentSegment.length + i);
        int i6 = 0;
        while (true) {
            if (i >= iMin) {
                break;
            }
            int byteFromBuffer = getByteFromBuffer(i) & 255;
            if (iArr[byteFromBuffer] == 0) {
                i++;
                cArrEmptyAndGetCurrentSegment[i6] = (char) byteFromBuffer;
                i6++;
            } else if (byteFromBuffer == 34) {
                this._inputPtr = i + 1;
                this._textBuffer.setCurrentLength(i6);
                return _valueComplete(JsonToken.VALUE_STRING);
            }
        }
        this._textBuffer.setCurrentLength(i6);
        this._inputPtr = i;
        return _finishRegularString();
    }

    public JsonToken _startTrueToken() throws IOException {
        int byteFromBuffer;
        int i = this._inputPtr;
        if (i + 3 < this._inputEnd) {
            int i6 = i + 1;
            if (getByteFromBuffer(i) == 114) {
                int i10 = i + 2;
                if (getByteFromBuffer(i6) == 117) {
                    int i11 = i + 3;
                    if (getByteFromBuffer(i10) == 101 && ((byteFromBuffer = getByteFromBuffer(i11) & 255) < 48 || (byteFromBuffer | 32) == 125)) {
                        this._inputPtr = i11;
                        return _valueComplete(JsonToken.VALUE_TRUE);
                    }
                }
            }
        }
        this._minorState = 17;
        return _finishKeywordToken("true", 1, JsonToken.VALUE_TRUE);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.fasterxml.jackson.core.JsonToken _startUnexpectedValue(boolean r3, int r4) throws java.io.IOException {
        /*
            r2 = this;
            r3 = 39
            if (r4 == r3) goto L53
            r3 = 73
            r0 = 1
            if (r4 == r3) goto L4e
            r3 = 78
            if (r4 == r3) goto L48
            r3 = 93
            if (r4 == r3) goto L24
            r3 = 125(0x7d, float:1.75E-43)
            if (r4 == r3) goto L5f
            r3 = 43
            if (r4 == r3) goto L1e
            r3 = 44
            if (r4 == r3) goto L2d
            goto L5f
        L1e:
            r3 = 2
            com.fasterxml.jackson.core.JsonToken r2 = r2._finishNonStdToken(r3, r0)
            return r2
        L24:
            com.fasterxml.jackson.core.json.JsonReadContext r3 = r2._parsingContext
            boolean r3 = r3.inArray()
            if (r3 != 0) goto L2d
            goto L5f
        L2d:
            com.fasterxml.jackson.core.json.JsonReadContext r3 = r2._parsingContext
            boolean r3 = r3.inRoot()
            if (r3 != 0) goto L5f
            int r3 = r2._features
            int r1 = com.fasterxml.jackson.core.json.async.NonBlockingUtf8JsonParserBase.FEAT_MASK_ALLOW_MISSING
            r3 = r3 & r1
            if (r3 == 0) goto L5f
            int r3 = r2._inputPtr
            int r3 = r3 - r0
            r2._inputPtr = r3
            com.fasterxml.jackson.core.JsonToken r3 = com.fasterxml.jackson.core.JsonToken.VALUE_NULL
            com.fasterxml.jackson.core.JsonToken r2 = r2._valueComplete(r3)
            return r2
        L48:
            r3 = 0
            com.fasterxml.jackson.core.JsonToken r2 = r2._finishNonStdToken(r3, r0)
            return r2
        L4e:
            com.fasterxml.jackson.core.JsonToken r2 = r2._finishNonStdToken(r0, r0)
            return r2
        L53:
            int r3 = r2._features
            int r0 = com.fasterxml.jackson.core.json.async.NonBlockingUtf8JsonParserBase.FEAT_MASK_ALLOW_SINGLE_QUOTES
            r3 = r3 & r0
            if (r3 == 0) goto L5f
            com.fasterxml.jackson.core.JsonToken r2 = r2._startAposString()
            return r2
        L5f:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r0 = "expected a valid value "
            r3.<init>(r0)
            java.lang.String r0 = r2._validJsonValueList()
            r3.append(r0)
            java.lang.String r3 = r3.toString()
            r2._reportUnexpectedChar(r4, r3)
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.async.NonBlockingUtf8JsonParserBase._startUnexpectedValue(boolean, int):com.fasterxml.jackson.core.JsonToken");
    }

    public void endOfInput() {
        this._endOfInput = true;
    }

    public abstract byte getByteFromBuffer(int i);

    public abstract byte getNextSignedByteFromBuffer();

    public abstract int getNextUnsignedByteFromBuffer();

    public final boolean needMoreInput() {
        return this._inputPtr >= this._inputEnd && !this._endOfInput;
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public JsonToken nextToken() throws IOException {
        if (this._inputPtr >= this._inputEnd) {
            if (this._closed) {
                return null;
            }
            return this._endOfInput ? this._currToken == JsonToken.NOT_AVAILABLE ? _finishTokenWithEOF() : _eofAsNextToken() : JsonToken.NOT_AVAILABLE;
        }
        if (this._currToken == JsonToken.NOT_AVAILABLE) {
            return _finishToken();
        }
        this._numTypesValid = 0;
        this._tokenInputTotal = this._currInputProcessed + (r0 - this._currBufferStart);
        this._binaryValue = null;
        int nextUnsignedByteFromBuffer = getNextUnsignedByteFromBuffer();
        switch (this._majorState) {
            case 0:
                return _startDocument(nextUnsignedByteFromBuffer);
            case 1:
                return _startValue(nextUnsignedByteFromBuffer);
            case 2:
                return _startFieldName(nextUnsignedByteFromBuffer);
            case 3:
                return _startFieldNameAfterComma(nextUnsignedByteFromBuffer);
            case 4:
                return _startValueExpectColon(nextUnsignedByteFromBuffer);
            case 5:
                return _startValue(nextUnsignedByteFromBuffer);
            case 6:
                return _startValueExpectComma(nextUnsignedByteFromBuffer);
            default:
                VersionUtil.throwInternal();
                return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x00aa, code lost:
    
        r9._intLength = r7 - 1;
        r9._textBuffer.setCurrentLength(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00b9, code lost:
    
        return _valueComplete(com.fasterxml.jackson.core.JsonToken.VALUE_NUMBER_INT);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.fasterxml.jackson.core.JsonToken _startPositiveNumber() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 229
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.async.NonBlockingUtf8JsonParserBase._startPositiveNumber():com.fasterxml.jackson.core.JsonToken");
    }
}
