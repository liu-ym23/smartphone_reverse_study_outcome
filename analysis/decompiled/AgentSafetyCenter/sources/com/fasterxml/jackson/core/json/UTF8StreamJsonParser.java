package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.core.base.GeneratorBase;
import com.fasterxml.jackson.core.base.ParserMinimalBase;
import com.fasterxml.jackson.core.exc.StreamConstraintsException;
import com.fasterxml.jackson.core.internal.shaded.fdp.v2_19_2.FastDoubleMath;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import com.fasterxml.jackson.core.util.InternalJacksonUtil;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import k0.a;
import od.f;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class UTF8StreamJsonParser extends JsonParserBase {
    protected static final byte BYTE_LF = 10;
    protected boolean _bufferRecyclable;
    protected byte[] _inputBuffer;
    protected InputStream _inputStream;
    protected int _nameStartCol;
    protected int _nameStartOffset;
    protected int _nameStartRow;
    private int _quad1;
    protected int[] _quadBuffer;
    protected final ByteQuadsCanonicalizer _symbols;
    protected boolean _tokenIncomplete;

    public UTF8StreamJsonParser(IOContext iOContext, int i, InputStream inputStream, ObjectCodec objectCodec, ByteQuadsCanonicalizer byteQuadsCanonicalizer, byte[] bArr, int i3, int i10, int i11, boolean z10) {
        super(iOContext, i, objectCodec);
        this._quadBuffer = new int[16];
        this._inputStream = inputStream;
        this._symbols = byteQuadsCanonicalizer;
        this._inputBuffer = bArr;
        this._inputPtr = i3;
        this._inputEnd = i10;
        this._currInputRowStart = i3 - i11;
        this._currInputProcessed = (-i3) + i11;
        this._bufferRecyclable = z10;
    }

    private final void _checkMatchEnd(String str, int i, int i3) {
        if (Character.isJavaIdentifierPart((char) _decodeCharForError(i3))) {
            _reportInvalidToken(str.substring(0, i));
        }
    }

    private final void _closeArrayScope() {
        _updateLocation();
        if (!this._parsingContext.inArray()) {
            _reportMismatchedEndMarker(93, '}');
        }
        this._parsingContext = this._parsingContext.clearAndGetParent();
    }

    private final void _closeObjectScope() {
        _updateLocation();
        if (!this._parsingContext.inObject()) {
            _reportMismatchedEndMarker(125, ']');
        }
        this._parsingContext = this._parsingContext.clearAndGetParent();
    }

    private final JsonToken _closeScope(int i) {
        if (i == 125) {
            _closeObjectScope();
            return _updateToken(JsonToken.END_OBJECT);
        }
        _closeArrayScope();
        return _updateToken(JsonToken.END_ARRAY);
    }

    private final int _decodeUtf8_2(int i) {
        if (this._inputPtr >= this._inputEnd) {
            _loadMoreGuaranteed();
        }
        byte[] bArr = this._inputBuffer;
        int i3 = this._inputPtr;
        int i10 = i3 + 1;
        this._inputPtr = i10;
        byte b10 = bArr[i3];
        if ((b10 & 192) != 128) {
            _reportInvalidOther(b10 & 255, i10);
        }
        return ((i & 31) << 6) | (b10 & 63);
    }

    private final int _decodeUtf8_3(int i) {
        if (this._inputPtr >= this._inputEnd) {
            _loadMoreGuaranteed();
        }
        int i3 = i & 15;
        byte[] bArr = this._inputBuffer;
        int i10 = this._inputPtr;
        int i11 = i10 + 1;
        this._inputPtr = i11;
        byte b10 = bArr[i10];
        if ((b10 & 192) != 128) {
            _reportInvalidOther(b10 & 255, i11);
        }
        int i12 = (i3 << 6) | (b10 & 63);
        if (this._inputPtr >= this._inputEnd) {
            _loadMoreGuaranteed();
        }
        byte[] bArr2 = this._inputBuffer;
        int i13 = this._inputPtr;
        int i14 = i13 + 1;
        this._inputPtr = i14;
        byte b11 = bArr2[i13];
        if ((b11 & 192) != 128) {
            _reportInvalidOther(b11 & 255, i14);
        }
        return (i12 << 6) | (b11 & 63);
    }

    private final int _decodeUtf8_3fast(int i) {
        int i3 = i & 15;
        byte[] bArr = this._inputBuffer;
        int i10 = this._inputPtr;
        int i11 = i10 + 1;
        this._inputPtr = i11;
        byte b10 = bArr[i10];
        if ((b10 & 192) != 128) {
            _reportInvalidOther(b10 & 255, i11);
        }
        int i12 = (i3 << 6) | (b10 & 63);
        byte[] bArr2 = this._inputBuffer;
        int i13 = this._inputPtr;
        int i14 = i13 + 1;
        this._inputPtr = i14;
        byte b11 = bArr2[i13];
        if ((b11 & 192) != 128) {
            _reportInvalidOther(b11 & 255, i14);
        }
        return (i12 << 6) | (b11 & 63);
    }

    private final int _decodeUtf8_4(int i) {
        if (this._inputPtr >= this._inputEnd) {
            _loadMoreGuaranteed();
        }
        byte[] bArr = this._inputBuffer;
        int i3 = this._inputPtr;
        int i10 = i3 + 1;
        this._inputPtr = i10;
        byte b10 = bArr[i3];
        if ((b10 & 192) != 128) {
            _reportInvalidOther(b10 & 255, i10);
        }
        int i11 = ((i & 7) << 6) | (b10 & 63);
        if (this._inputPtr >= this._inputEnd) {
            _loadMoreGuaranteed();
        }
        byte[] bArr2 = this._inputBuffer;
        int i12 = this._inputPtr;
        int i13 = i12 + 1;
        this._inputPtr = i13;
        byte b11 = bArr2[i12];
        if ((b11 & 192) != 128) {
            _reportInvalidOther(b11 & 255, i13);
        }
        int i14 = (i11 << 6) | (b11 & 63);
        if (this._inputPtr >= this._inputEnd) {
            _loadMoreGuaranteed();
        }
        byte[] bArr3 = this._inputBuffer;
        int i15 = this._inputPtr;
        int i16 = i15 + 1;
        this._inputPtr = i16;
        byte b12 = bArr3[i15];
        if ((b12 & 192) != 128) {
            _reportInvalidOther(b12 & 255, i16);
        }
        return ((i14 << 6) | (b12 & 63)) - 65536;
    }

    private final void _finishString2(char[] cArr, int i) {
        int[] iArr = JsonParserBase.INPUT_CODES_UTF8;
        byte[] bArr = this._inputBuffer;
        while (true) {
            int i3 = this._inputPtr;
            if (i3 >= this._inputEnd) {
                _loadMoreGuaranteed();
                i3 = this._inputPtr;
            }
            int i10 = 0;
            if (i >= cArr.length) {
                cArr = this._textBuffer.finishCurrentSegment();
                i = 0;
            }
            int iMin = Math.min(this._inputEnd, InternalJacksonUtil.addOverflowSafe(i3, cArr.length - i));
            while (true) {
                if (i3 >= iMin) {
                    this._inputPtr = i3;
                    break;
                }
                int i11 = i3 + 1;
                int i_decodeEscaped = bArr[i3] & 255;
                int i12 = iArr[i_decodeEscaped];
                if (i12 != 0) {
                    this._inputPtr = i11;
                    if (i_decodeEscaped == 34) {
                        this._textBuffer.setCurrentLength(i);
                        return;
                    }
                    if (i12 == 1) {
                        i_decodeEscaped = _decodeEscaped();
                    } else if (i12 == 2) {
                        i_decodeEscaped = _decodeUtf8_2(i_decodeEscaped);
                    } else if (i12 == 3) {
                        i_decodeEscaped = this._inputEnd - i11 >= 2 ? _decodeUtf8_3fast(i_decodeEscaped) : _decodeUtf8_3(i_decodeEscaped);
                    } else if (i12 == 4) {
                        int i_decodeUtf8_4 = _decodeUtf8_4(i_decodeEscaped);
                        int i13 = i + 1;
                        cArr[i] = (char) ((i_decodeUtf8_4 >> 10) | GeneratorBase.SURR1_FIRST);
                        if (i13 >= cArr.length) {
                            cArr = this._textBuffer.finishCurrentSegment();
                            i = 0;
                        } else {
                            i = i13;
                        }
                        i_decodeEscaped = (i_decodeUtf8_4 & FastDoubleMath.DOUBLE_EXPONENT_BIAS) | GeneratorBase.SURR2_FIRST;
                    } else if (i_decodeEscaped < 32) {
                        _throwUnquotedSpace(i_decodeEscaped, "string value");
                    } else {
                        _reportInvalidChar(i_decodeEscaped);
                    }
                    if (i >= cArr.length) {
                        cArr = this._textBuffer.finishCurrentSegment();
                    } else {
                        i10 = i;
                    }
                    i = i10 + 1;
                    cArr[i10] = (char) i_decodeEscaped;
                } else {
                    cArr[i] = (char) i_decodeEscaped;
                    i3 = i11;
                    i++;
                }
            }
        }
    }

    private final boolean _isNextTokenNameMaybe(int i, SerializableString serializableString) throws JsonParseException {
        JsonToken jsonToken_parseSignedNumber;
        String str_parseName = _parseName(i);
        this._parsingContext.setCurrentName(str_parseName);
        boolean zEquals = str_parseName.equals(serializableString.getValue());
        _updateToken(JsonToken.FIELD_NAME);
        int i_skipColon = _skipColon();
        _updateLocation();
        if (i_skipColon == 34) {
            this._tokenIncomplete = true;
            this._nextToken = JsonToken.VALUE_STRING;
            return zEquals;
        }
        if (i_skipColon == 43) {
            jsonToken_parseSignedNumber = isEnabled(JsonReadFeature.ALLOW_LEADING_PLUS_SIGN_FOR_NUMBERS.mappedFeature()) ? _parseSignedNumber(false) : _handleUnexpectedValue(i_skipColon);
        } else if (i_skipColon == 91) {
            jsonToken_parseSignedNumber = JsonToken.START_ARRAY;
        } else if (i_skipColon == 102) {
            _matchFalse();
            jsonToken_parseSignedNumber = JsonToken.VALUE_FALSE;
        } else if (i_skipColon == 110) {
            _matchNull();
            jsonToken_parseSignedNumber = JsonToken.VALUE_NULL;
        } else if (i_skipColon == 116) {
            _matchTrue();
            jsonToken_parseSignedNumber = JsonToken.VALUE_TRUE;
        } else if (i_skipColon == 123) {
            jsonToken_parseSignedNumber = JsonToken.START_OBJECT;
        } else if (i_skipColon == 45) {
            jsonToken_parseSignedNumber = _parseSignedNumber(true);
        } else if (i_skipColon != 46) {
            switch (i_skipColon) {
                case 48:
                case 49:
                case 50:
                case 51:
                case 52:
                case FastDoubleMath.DOUBLE_SIGNIFICAND_WIDTH /* 53 */:
                case 54:
                case 55:
                case 56:
                case 57:
                    jsonToken_parseSignedNumber = _parseUnsignedNumber(i_skipColon);
                    break;
                default:
                    jsonToken_parseSignedNumber = _handleUnexpectedValue(i_skipColon);
                    break;
            }
        } else {
            jsonToken_parseSignedNumber = _parseFloatThatStartsWithPeriod(false, false);
        }
        this._nextToken = jsonToken_parseSignedNumber;
        return zEquals;
    }

    private final void _isNextTokenNameYes(int i) {
        _updateToken(JsonToken.FIELD_NAME);
        _updateLocation();
        if (i == 34) {
            this._tokenIncomplete = true;
            this._nextToken = JsonToken.VALUE_STRING;
            return;
        }
        if (i == 43) {
            if (isEnabled(JsonReadFeature.ALLOW_LEADING_PLUS_SIGN_FOR_NUMBERS.mappedFeature())) {
                this._nextToken = _parseSignedNumber(false);
                return;
            } else {
                this._nextToken = _handleUnexpectedValue(i);
                return;
            }
        }
        if (i == 91) {
            this._nextToken = JsonToken.START_ARRAY;
            return;
        }
        if (i == 102) {
            _matchFalse();
            this._nextToken = JsonToken.VALUE_FALSE;
            return;
        }
        if (i == 110) {
            _matchNull();
            this._nextToken = JsonToken.VALUE_NULL;
            return;
        }
        if (i == 116) {
            _matchTrue();
            this._nextToken = JsonToken.VALUE_TRUE;
            return;
        }
        if (i == 123) {
            this._nextToken = JsonToken.START_OBJECT;
            return;
        }
        if (i == 45) {
            this._nextToken = _parseSignedNumber(true);
            return;
        }
        if (i == 46) {
            this._nextToken = _parseFloatThatStartsWithPeriod(false, false);
            return;
        }
        switch (i) {
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case FastDoubleMath.DOUBLE_SIGNIFICAND_WIDTH /* 53 */:
            case 54:
            case 55:
            case 56:
            case 57:
                this._nextToken = _parseUnsignedNumber(i);
                break;
            default:
                this._nextToken = _handleUnexpectedValue(i);
                break;
        }
    }

    private final void _matchToken2(String str, int i) {
        int i3;
        int i10;
        int length = str.length();
        do {
            if ((this._inputPtr >= this._inputEnd && !_loadMore()) || this._inputBuffer[this._inputPtr] != str.charAt(i)) {
                _reportInvalidToken(str.substring(0, i));
            }
            i3 = this._inputPtr + 1;
            this._inputPtr = i3;
            i++;
        } while (i < length);
        if ((i3 < this._inputEnd || _loadMore()) && (i10 = this._inputBuffer[this._inputPtr] & 255) >= 48 && i10 != 93 && i10 != 125) {
            _checkMatchEnd(str, i, i10);
        }
    }

    private final JsonToken _nextAfterName() {
        this._nameCopied = false;
        JsonToken jsonToken = this._nextToken;
        this._nextToken = null;
        if (jsonToken == JsonToken.START_ARRAY) {
            createChildArrayContext(this._tokenInputRow, this._tokenInputCol);
        } else if (jsonToken == JsonToken.START_OBJECT) {
            createChildObjectContext(this._tokenInputRow, this._tokenInputCol);
        }
        return _updateToken(jsonToken);
    }

    private final JsonToken _nextTokenNotInObject(int i) {
        if (i == 34) {
            this._tokenIncomplete = true;
            return _updateToken(JsonToken.VALUE_STRING);
        }
        if (i == 43) {
            return !isEnabled(JsonReadFeature.ALLOW_LEADING_PLUS_SIGN_FOR_NUMBERS.mappedFeature()) ? _updateToken(_handleUnexpectedValue(i)) : _updateToken(_parseSignedNumber(false));
        }
        if (i == 91) {
            createChildArrayContext(this._tokenInputRow, this._tokenInputCol);
            return _updateToken(JsonToken.START_ARRAY);
        }
        if (i == 102) {
            _matchFalse();
            return _updateToken(JsonToken.VALUE_FALSE);
        }
        if (i == 110) {
            _matchNull();
            return _updateToken(JsonToken.VALUE_NULL);
        }
        if (i == 116) {
            _matchTrue();
            return _updateToken(JsonToken.VALUE_TRUE);
        }
        if (i == 123) {
            createChildObjectContext(this._tokenInputRow, this._tokenInputCol);
            return _updateToken(JsonToken.START_OBJECT);
        }
        if (i == 45) {
            return _updateToken(_parseSignedNumber(true));
        }
        if (i == 46) {
            return _updateToken(_parseFloatThatStartsWithPeriod(false, false));
        }
        switch (i) {
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case FastDoubleMath.DOUBLE_SIGNIFICAND_WIDTH /* 53 */:
            case 54:
            case 55:
            case 56:
            case 57:
                return _updateToken(_parseUnsignedNumber(i));
            default:
                return _updateToken(_handleUnexpectedValue(i));
        }
    }

    private static final int _padLastQuad(int i, int i3) {
        return i3 == 4 ? i : i | ((-1) << (i3 << 3));
    }

    private final JsonToken _parseFloat(char[] cArr, int i, int i3, boolean z10, int i10) {
        int i11;
        boolean z11;
        int i12 = 0;
        if (i3 == 46) {
            if (i >= cArr.length) {
                cArr = this._textBuffer.finishCurrentSegment();
                i = 0;
            }
            cArr[i] = (char) i3;
            i++;
            i11 = 0;
            while (true) {
                if (this._inputPtr >= this._inputEnd && !_loadMore()) {
                    z11 = true;
                    break;
                }
                byte[] bArr = this._inputBuffer;
                int i13 = this._inputPtr;
                this._inputPtr = i13 + 1;
                i3 = bArr[i13] & 255;
                if (i3 < 48 || i3 > 57) {
                    break;
                }
                i11++;
                if (i >= cArr.length) {
                    cArr = this._textBuffer.finishCurrentSegment();
                    i = 0;
                }
                cArr[i] = (char) i3;
                i++;
            }
            z11 = false;
            if (i11 == 0 && !isEnabled(JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS.mappedFeature())) {
                _reportUnexpectedNumberChar(i3, "Decimal point not followed by a digit");
            }
        } else {
            i11 = 0;
            z11 = false;
        }
        if ((i3 | 32) == 101) {
            if (i >= cArr.length) {
                cArr = this._textBuffer.finishCurrentSegment();
                i = 0;
            }
            int i14 = i + 1;
            cArr[i] = (char) i3;
            if (this._inputPtr >= this._inputEnd) {
                _loadMoreGuaranteed();
            }
            byte[] bArr2 = this._inputBuffer;
            int i15 = this._inputPtr;
            this._inputPtr = i15 + 1;
            int i16 = bArr2[i15] & 255;
            if (i16 == 45 || i16 == 43) {
                if (i14 >= cArr.length) {
                    cArr = this._textBuffer.finishCurrentSegment();
                    i14 = 0;
                }
                int i17 = i14 + 1;
                cArr[i14] = (char) i16;
                if (this._inputPtr >= this._inputEnd) {
                    _loadMoreGuaranteed();
                }
                byte[] bArr3 = this._inputBuffer;
                int i18 = this._inputPtr;
                this._inputPtr = i18 + 1;
                i16 = bArr3[i18] & 255;
                i14 = i17;
            }
            i3 = i16;
            int i19 = 0;
            while (i3 >= 48 && i3 <= 57) {
                i19++;
                if (i14 >= cArr.length) {
                    cArr = this._textBuffer.finishCurrentSegment();
                    i14 = 0;
                }
                int i20 = i14 + 1;
                cArr[i14] = (char) i3;
                if (this._inputPtr >= this._inputEnd && !_loadMore()) {
                    i12 = i19;
                    z11 = true;
                    i = i20;
                    break;
                }
                byte[] bArr4 = this._inputBuffer;
                int i21 = this._inputPtr;
                this._inputPtr = i21 + 1;
                i3 = bArr4[i21] & 255;
                i14 = i20;
            }
            i12 = i19;
            i = i14;
            if (i12 == 0) {
                _reportUnexpectedNumberChar(i3, "Exponent indicator not followed by a digit");
            }
        }
        if (!z11) {
            this._inputPtr--;
            if (this._parsingContext.inRoot()) {
                _verifyRootSpace(i3);
            }
        }
        this._textBuffer.setCurrentLength(i);
        return resetFloat(z10, i10, i11, i12);
    }

    private final JsonToken _parseNumber2(char[] cArr, int i, boolean z10, int i3) {
        int i10;
        int i11;
        char[] cArrFinishCurrentSegment = cArr;
        int i12 = i;
        int i13 = i3;
        while (true) {
            if (this._inputPtr >= this._inputEnd && !_loadMore()) {
                this._textBuffer.setCurrentLength(i12);
                return resetInt(z10, i13);
            }
            byte[] bArr = this._inputBuffer;
            i10 = this._inputPtr;
            this._inputPtr = i10 + 1;
            i11 = bArr[i10] & 255;
            if (i11 > 57 || i11 < 48) {
                break;
            }
            if (i12 >= cArrFinishCurrentSegment.length) {
                i12 = 0;
                cArrFinishCurrentSegment = this._textBuffer.finishCurrentSegment();
            }
            cArrFinishCurrentSegment[i12] = (char) i11;
            i13++;
            i12++;
        }
        if (i11 == 46 || (i11 | 32) == 101) {
            return _parseFloat(cArrFinishCurrentSegment, i12, i11, z10, i13);
        }
        this._inputPtr = i10;
        this._textBuffer.setCurrentLength(i12);
        if (this._parsingContext.inRoot()) {
            _verifyRootSpace(this._inputBuffer[this._inputPtr] & 255);
        }
        return resetInt(z10, i13);
    }

    private final JsonToken _parseSignedNumber(boolean z10) {
        int i;
        int i3;
        int i10;
        char[] cArrEmptyAndGetCurrentSegment = this._textBuffer.emptyAndGetCurrentSegment();
        int i11 = 1;
        int i12 = 0;
        if (z10) {
            cArrEmptyAndGetCurrentSegment[0] = '-';
            i12 = 1;
        }
        if (this._inputPtr >= this._inputEnd) {
            _loadMoreGuaranteed();
        }
        byte[] bArr = this._inputBuffer;
        int i13 = this._inputPtr;
        this._inputPtr = i13 + 1;
        int i_verifyNoLeadingZeroes = bArr[i13] & 255;
        if (i_verifyNoLeadingZeroes <= 48) {
            if (i_verifyNoLeadingZeroes != 48) {
                return i_verifyNoLeadingZeroes == 46 ? _parseFloatThatStartsWithPeriod(z10, true) : _handleInvalidNumberStart(i_verifyNoLeadingZeroes, z10, true);
            }
            i_verifyNoLeadingZeroes = _verifyNoLeadingZeroes();
        } else if (i_verifyNoLeadingZeroes > 57) {
            return _handleInvalidNumberStart(i_verifyNoLeadingZeroes, z10, true);
        }
        int i14 = i12 + 1;
        cArrEmptyAndGetCurrentSegment[i12] = (char) i_verifyNoLeadingZeroes;
        int iMin = Math.min(this._inputEnd, (this._inputPtr + cArrEmptyAndGetCurrentSegment.length) - i14);
        while (true) {
            i = i14;
            i3 = this._inputPtr;
            if (i3 >= iMin) {
                return _parseNumber2(cArrEmptyAndGetCurrentSegment, i, z10, i11);
            }
            byte[] bArr2 = this._inputBuffer;
            this._inputPtr = i3 + 1;
            i10 = bArr2[i3] & 255;
            if (i10 < 48 || i10 > 57) {
                break;
            }
            i11++;
            i14 = i + 1;
            cArrEmptyAndGetCurrentSegment[i] = (char) i10;
        }
        if (i10 == 46 || (i10 | 32) == 101) {
            return _parseFloat(cArrEmptyAndGetCurrentSegment, i, i10, z10, i11);
        }
        this._inputPtr = i3;
        this._textBuffer.setCurrentLength(i);
        if (this._parsingContext.inRoot()) {
            _verifyRootSpace(i10);
        }
        return resetInt(z10, i11);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0043, code lost:
    
        _reportInvalidEOF(" in a comment", null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0049, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void _skipCComment() {
        /*
            r5 = this;
            int[] r0 = com.fasterxml.jackson.core.io.CharTypes.getInputCodeComment()
        L4:
            int r1 = r5._inputPtr
            int r2 = r5._inputEnd
            if (r1 < r2) goto L10
            boolean r1 = r5._loadMore()
            if (r1 == 0) goto L43
        L10:
            byte[] r1 = r5._inputBuffer
            int r2 = r5._inputPtr
            int r3 = r2 + 1
            r5._inputPtr = r3
            r1 = r1[r2]
            r1 = r1 & 255(0xff, float:3.57E-43)
            r2 = r0[r1]
            if (r2 == 0) goto L4
            r4 = 2
            if (r2 == r4) goto L6e
            r4 = 3
            if (r2 == r4) goto L6a
            r4 = 4
            if (r2 == r4) goto L66
            r4 = 10
            if (r2 == r4) goto L5d
            r4 = 13
            if (r2 == r4) goto L59
            r4 = 42
            if (r2 == r4) goto L39
            r5._reportInvalidChar(r1)
            goto L4
        L39:
            int r1 = r5._inputEnd
            if (r3 < r1) goto L4a
            boolean r1 = r5._loadMore()
            if (r1 != 0) goto L4a
        L43:
            java.lang.String r0 = " in a comment"
            r1 = 0
            r5._reportInvalidEOF(r0, r1)
            return
        L4a:
            byte[] r1 = r5._inputBuffer
            int r2 = r5._inputPtr
            r1 = r1[r2]
            r3 = 47
            if (r1 != r3) goto L4
            int r2 = r2 + 1
            r5._inputPtr = r2
            return
        L59:
            r5._skipCR()
            goto L4
        L5d:
            int r1 = r5._currInputRow
            int r1 = r1 + 1
            r5._currInputRow = r1
            r5._currInputRowStart = r3
            goto L4
        L66:
            r5._skipUtf8_4(r1)
            goto L4
        L6a:
            r5._skipUtf8_3()
            goto L4
        L6e:
            r5._skipUtf8_2()
            goto L4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.UTF8StreamJsonParser._skipCComment():void");
    }

    private final int _skipColon() {
        int i = this._inputPtr;
        if (i + 4 >= this._inputEnd) {
            return _skipColon2(false);
        }
        byte[] bArr = this._inputBuffer;
        byte b10 = bArr[i];
        if (b10 == 58) {
            int i3 = i + 1;
            this._inputPtr = i3;
            byte b11 = bArr[i3];
            if (b11 > 32) {
                if (b11 == 47 || b11 == 35) {
                    return _skipColon2(true);
                }
                this._inputPtr = i + 2;
                return b11;
            }
            if (b11 == 32 || b11 == 9) {
                int i10 = i + 2;
                this._inputPtr = i10;
                byte b12 = bArr[i10];
                if (b12 > 32) {
                    if (b12 == 47 || b12 == 35) {
                        return _skipColon2(true);
                    }
                    this._inputPtr = i + 3;
                    return b12;
                }
            }
            return _skipColon2(true);
        }
        if (b10 == 32 || b10 == 9) {
            int i11 = i + 1;
            this._inputPtr = i11;
            b10 = bArr[i11];
        }
        if (b10 != 58) {
            return _skipColon2(false);
        }
        int i12 = this._inputPtr;
        int i13 = i12 + 1;
        this._inputPtr = i13;
        byte b13 = bArr[i13];
        if (b13 > 32) {
            if (b13 == 47 || b13 == 35) {
                return _skipColon2(true);
            }
            this._inputPtr = i12 + 2;
            return b13;
        }
        if (b13 == 32 || b13 == 9) {
            int i14 = i12 + 2;
            this._inputPtr = i14;
            byte b14 = bArr[i14];
            if (b14 > 32) {
                if (b14 == 47 || b14 == 35) {
                    return _skipColon2(true);
                }
                this._inputPtr = i12 + 3;
                return b14;
            }
        }
        return _skipColon2(true);
    }

    private final int _skipColon2(boolean z10) {
        while (true) {
            if (this._inputPtr >= this._inputEnd && !_loadMore()) {
                _reportInvalidEOF(" within/between " + this._parsingContext.typeDesc() + " entries", null);
                return -1;
            }
            byte[] bArr = this._inputBuffer;
            int i = this._inputPtr;
            int i3 = i + 1;
            this._inputPtr = i3;
            int i10 = bArr[i] & 255;
            if (i10 > 32) {
                if (i10 == 47) {
                    _skipComment();
                } else if (i10 != 35 || !_skipYAMLComment()) {
                    if (z10) {
                        return i10;
                    }
                    if (i10 != 58) {
                        _reportUnexpectedChar(i10, "was expecting a colon to separate field name and value");
                    }
                    z10 = true;
                }
            } else if (i10 != 32) {
                if (i10 == 10) {
                    this._currInputRow++;
                    this._currInputRowStart = i3;
                } else if (i10 == 13) {
                    _skipCR();
                } else if (i10 != 9) {
                    _throwInvalidSpace(i10);
                }
            }
        }
    }

    private final int _skipColonFast(int i) {
        byte[] bArr = this._inputBuffer;
        int i3 = i + 1;
        byte b10 = bArr[i];
        if (b10 == 58) {
            int i10 = i + 2;
            byte b11 = bArr[i3];
            if (b11 > 32) {
                if (b11 != 47 && b11 != 35) {
                    this._inputPtr = i10;
                    return b11;
                }
            } else if (b11 == 32 || b11 == 9) {
                int i11 = i + 3;
                byte b12 = bArr[i10];
                if (b12 > 32 && b12 != 47 && b12 != 35) {
                    this._inputPtr = i11;
                    return b12;
                }
                i10 = i11;
            }
            this._inputPtr = i10 - 1;
            return _skipColon2(true);
        }
        if (b10 == 32 || b10 == 9) {
            b10 = bArr[i3];
            i3 = i + 2;
        }
        if (b10 != 58) {
            this._inputPtr = i3 - 1;
            return _skipColon2(false);
        }
        int i12 = i3 + 1;
        byte b13 = bArr[i3];
        if (b13 > 32) {
            if (b13 != 47 && b13 != 35) {
                this._inputPtr = i12;
                return b13;
            }
        } else if (b13 == 32 || b13 == 9) {
            int i13 = i3 + 2;
            byte b14 = bArr[i12];
            if (b14 > 32 && b14 != 47 && b14 != 35) {
                this._inputPtr = i13;
                return b14;
            }
            i12 = i13;
        }
        this._inputPtr = i12 - 1;
        return _skipColon2(true);
    }

    private final void _skipComment() {
        if ((this._features & JsonParserBase.FEAT_MASK_ALLOW_JAVA_COMMENTS) == 0) {
            _reportUnexpectedChar(47, "maybe a (non-standard) comment? (not recognized as one since Feature 'ALLOW_COMMENTS' not enabled for parser)");
        }
        if (this._inputPtr >= this._inputEnd && !_loadMore()) {
            _reportInvalidEOF(" in a comment", null);
        }
        byte[] bArr = this._inputBuffer;
        int i = this._inputPtr;
        this._inputPtr = i + 1;
        int i3 = bArr[i] & 255;
        if (i3 == 47) {
            _skipLine();
        } else if (i3 == 42) {
            _skipCComment();
        } else {
            _reportUnexpectedChar(i3, "was expecting either '*' or '/' for a comment");
        }
    }

    private final void _skipLine() {
        int[] inputCodeComment = CharTypes.getInputCodeComment();
        while (true) {
            if (this._inputPtr >= this._inputEnd && !_loadMore()) {
                return;
            }
            byte[] bArr = this._inputBuffer;
            int i = this._inputPtr;
            int i3 = i + 1;
            this._inputPtr = i3;
            int i10 = bArr[i] & 255;
            int i11 = inputCodeComment[i10];
            if (i11 != 0) {
                if (i11 == 2) {
                    _skipUtf8_2();
                } else if (i11 == 3) {
                    _skipUtf8_3();
                } else if (i11 == 4) {
                    _skipUtf8_4(i10);
                } else if (i11 == 10) {
                    this._currInputRow++;
                    this._currInputRowStart = i3;
                    return;
                } else if (i11 == 13) {
                    _skipCR();
                    return;
                } else if (i11 != 42 && i11 < 0) {
                    _reportInvalidChar(i10);
                }
            }
        }
    }

    private final void _skipUtf8_2() {
        if (this._inputPtr >= this._inputEnd) {
            _loadMoreGuaranteed();
        }
        byte[] bArr = this._inputBuffer;
        int i = this._inputPtr;
        int i3 = i + 1;
        this._inputPtr = i3;
        byte b10 = bArr[i];
        if ((b10 & 192) != 128) {
            _reportInvalidOther(b10 & 255, i3);
        }
    }

    private final void _skipUtf8_3() {
        if (this._inputPtr >= this._inputEnd) {
            _loadMoreGuaranteed();
        }
        byte[] bArr = this._inputBuffer;
        int i = this._inputPtr;
        int i3 = i + 1;
        this._inputPtr = i3;
        byte b10 = bArr[i];
        if ((b10 & 192) != 128) {
            _reportInvalidOther(b10 & 255, i3);
        }
        if (this._inputPtr >= this._inputEnd) {
            _loadMoreGuaranteed();
        }
        byte[] bArr2 = this._inputBuffer;
        int i10 = this._inputPtr;
        int i11 = i10 + 1;
        this._inputPtr = i11;
        byte b11 = bArr2[i10];
        if ((b11 & 192) != 128) {
            _reportInvalidOther(b11 & 255, i11);
        }
    }

    private final void _skipUtf8_4(int i) {
        if (this._inputPtr >= this._inputEnd) {
            _loadMoreGuaranteed();
        }
        byte[] bArr = this._inputBuffer;
        int i3 = this._inputPtr;
        int i10 = i3 + 1;
        this._inputPtr = i10;
        byte b10 = bArr[i3];
        if ((b10 & 192) != 128) {
            _reportInvalidOther(b10 & 255, i10);
        }
        if (this._inputPtr >= this._inputEnd) {
            _loadMoreGuaranteed();
        }
        byte[] bArr2 = this._inputBuffer;
        int i11 = this._inputPtr;
        int i12 = i11 + 1;
        this._inputPtr = i12;
        byte b11 = bArr2[i11];
        if ((b11 & 192) != 128) {
            _reportInvalidOther(b11 & 255, i12);
        }
        if (this._inputPtr >= this._inputEnd) {
            _loadMoreGuaranteed();
        }
        byte[] bArr3 = this._inputBuffer;
        int i13 = this._inputPtr;
        int i14 = i13 + 1;
        this._inputPtr = i14;
        byte b12 = bArr3[i13];
        if ((b12 & 192) != 128) {
            _reportInvalidOther(b12 & 255, i14);
        }
    }

    private final int _skipWS() {
        while (true) {
            int i = this._inputPtr;
            if (i >= this._inputEnd) {
                return _skipWS2();
            }
            byte[] bArr = this._inputBuffer;
            int i3 = i + 1;
            this._inputPtr = i3;
            int i10 = bArr[i] & 255;
            if (i10 > 32) {
                if (i10 != 47 && i10 != 35) {
                    return i10;
                }
                this._inputPtr = i;
                return _skipWS2();
            }
            if (i10 != 32) {
                if (i10 == 10) {
                    this._currInputRow++;
                    this._currInputRowStart = i3;
                } else if (i10 == 13) {
                    _skipCR();
                } else if (i10 != 9) {
                    _throwInvalidSpace(i10);
                }
            }
        }
    }

    private final int _skipWS2() throws JsonParseException {
        int i;
        while (true) {
            if (this._inputPtr >= this._inputEnd && !_loadMore()) {
                throw _constructError("Unexpected end-of-input within/between " + this._parsingContext.typeDesc() + " entries");
            }
            byte[] bArr = this._inputBuffer;
            int i3 = this._inputPtr;
            int i10 = i3 + 1;
            this._inputPtr = i10;
            i = bArr[i3] & 255;
            if (i > 32) {
                if (i == 47) {
                    _skipComment();
                } else if (i != 35 || !_skipYAMLComment()) {
                    break;
                }
            } else if (i != 32) {
                if (i == 10) {
                    this._currInputRow++;
                    this._currInputRowStart = i10;
                } else if (i == 13) {
                    _skipCR();
                } else if (i != 9) {
                    _throwInvalidSpace(i);
                }
            }
        }
        return i;
    }

    private final int _skipWSOrEnd() {
        if (this._inputPtr >= this._inputEnd && !_loadMore()) {
            return _eofAsNextChar();
        }
        byte[] bArr = this._inputBuffer;
        int i = this._inputPtr;
        int i3 = i + 1;
        this._inputPtr = i3;
        int i10 = bArr[i] & 255;
        if (i10 > 32) {
            if (i10 != 47 && i10 != 35) {
                return i10;
            }
            this._inputPtr = i;
            return _skipWSOrEnd2();
        }
        if (i10 != 32) {
            if (i10 == 10) {
                this._currInputRow++;
                this._currInputRowStart = i3;
            } else if (i10 == 13) {
                _skipCR();
            } else if (i10 != 9 && !_isAllowedCtrlCharRS(i10)) {
                _throwInvalidSpace(i10);
            }
        }
        while (true) {
            int i11 = this._inputPtr;
            if (i11 >= this._inputEnd) {
                return _skipWSOrEnd2();
            }
            byte[] bArr2 = this._inputBuffer;
            int i12 = i11 + 1;
            this._inputPtr = i12;
            int i13 = bArr2[i11] & 255;
            if (i13 > 32) {
                if (i13 != 47 && i13 != 35) {
                    return i13;
                }
                this._inputPtr = i11;
                return _skipWSOrEnd2();
            }
            if (i13 != 32) {
                if (i13 == 10) {
                    this._currInputRow++;
                    this._currInputRowStart = i12;
                } else if (i13 == 13) {
                    _skipCR();
                } else if (i13 != 9 && !_isAllowedCtrlCharRS(i13)) {
                    _throwInvalidSpace(i13);
                }
            }
        }
    }

    private final int _skipWSOrEnd2() {
        int i;
        while (true) {
            if (this._inputPtr >= this._inputEnd && !_loadMore()) {
                return _eofAsNextChar();
            }
            byte[] bArr = this._inputBuffer;
            int i3 = this._inputPtr;
            int i10 = i3 + 1;
            this._inputPtr = i10;
            i = bArr[i3] & 255;
            if (i > 32) {
                if (i == 47) {
                    _skipComment();
                } else if (i != 35 || !_skipYAMLComment()) {
                    break;
                }
            } else if (i != 32) {
                if (i == 10) {
                    this._currInputRow++;
                    this._currInputRowStart = i10;
                } else if (i == 13) {
                    _skipCR();
                } else if (i != 9) {
                    _throwInvalidSpace(i);
                }
            }
        }
        return i;
    }

    private final boolean _skipYAMLComment() {
        if ((this._features & JsonParserBase.FEAT_MASK_ALLOW_YAML_COMMENTS) == 0) {
            return false;
        }
        _skipLine();
        return true;
    }

    private final void _updateLocation() {
        this._tokenInputRow = this._currInputRow;
        int i = this._inputPtr;
        this._tokenInputTotal = this._currInputProcessed + i;
        this._tokenInputCol = i - this._currInputRowStart;
    }

    private final void _updateNameLocation() {
        this._nameStartRow = this._currInputRow;
        int i = this._inputPtr;
        this._nameStartOffset = i;
        this._nameStartCol = i - this._currInputRowStart;
    }

    private final int _verifyNoLeadingZeroes() {
        int i;
        if ((this._inputPtr >= this._inputEnd && !_loadMore()) || (i = this._inputBuffer[this._inputPtr] & 255) < 48 || i > 57) {
            return 48;
        }
        if ((this._features & JsonParserBase.FEAT_MASK_LEADING_ZEROS) == 0) {
            reportInvalidNumber("Leading zeroes not allowed");
        }
        this._inputPtr++;
        if (i != 48) {
            return i;
        }
        do {
            if (this._inputPtr >= this._inputEnd && !_loadMore()) {
                return i;
            }
            byte[] bArr = this._inputBuffer;
            int i3 = this._inputPtr;
            i = bArr[i3] & 255;
            if (i < 48 || i > 57) {
                return 48;
            }
            this._inputPtr = i3 + 1;
        } while (i == 48);
        return i;
    }

    private final void _verifyRootSpace(int i) {
        int i3 = this._inputPtr;
        int i10 = i3 + 1;
        this._inputPtr = i10;
        if (i != 9) {
            if (i == 10) {
                this._currInputRow++;
                this._currInputRowStart = i10;
            } else if (i == 13) {
                this._inputPtr = i3;
            } else if (i != 32) {
                _reportMissingRootWS(i);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00cd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.String addName(int[] r18, int r19, int r20) throws com.fasterxml.jackson.core.exc.StreamConstraintsException {
        /*
            Method dump skipped, instructions count: 282
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.UTF8StreamJsonParser.addName(int[], int, int):java.lang.String");
    }

    private final String findName(int i, int i3, int i10, int i11) {
        int i_padLastQuad = _padLastQuad(i10, i11);
        String strFindName = this._symbols.findName(i, i3, i_padLastQuad);
        if (strFindName != null) {
            return strFindName;
        }
        int[] iArr = this._quadBuffer;
        iArr[0] = i;
        iArr[1] = i3;
        iArr[2] = _padLastQuad(i_padLastQuad, i11);
        return addName(iArr, 3, i11);
    }

    private int nextByte() {
        if (this._inputPtr >= this._inputEnd) {
            _loadMoreGuaranteed();
        }
        byte[] bArr = this._inputBuffer;
        int i = this._inputPtr;
        this._inputPtr = i + 1;
        return bArr[i] & 255;
    }

    private final String parseName(int i, int i3, int i10, int i11) {
        int[] iArr = this._quadBuffer;
        iArr[0] = i;
        return parseEscapedName(iArr, 1, i3, i10, i11);
    }

    @Override // com.fasterxml.jackson.core.base.ParserBase
    public void _closeInput() throws IOException {
        if (this._inputStream != null) {
            if (this._ioContext.isResourceManaged() || isEnabled(JsonParser.Feature.AUTO_CLOSE_SOURCE)) {
                this._inputStream.close();
            }
            this._inputStream = null;
        }
    }

    @Override // com.fasterxml.jackson.core.json.JsonParserBase, com.fasterxml.jackson.core.base.ParserMinimalBase
    public JsonLocation _currentLocationMinusOne() {
        int i = this._inputPtr - 1;
        return new JsonLocation(_contentReference(), this._currInputProcessed + i, -1L, this._currInputRow, (i - this._currInputRowStart) + 1);
    }

    public final byte[] _decodeBase64(Base64Variant base64Variant) {
        ByteArrayBuilder byteArrayBuilder_getByteArrayBuilder = _getByteArrayBuilder();
        while (true) {
            if (this._inputPtr >= this._inputEnd) {
                _loadMoreGuaranteed();
            }
            byte[] bArr = this._inputBuffer;
            int i = this._inputPtr;
            this._inputPtr = i + 1;
            int i3 = bArr[i] & 255;
            if (i3 > 32) {
                int iDecodeBase64Char = base64Variant.decodeBase64Char(i3);
                if (iDecodeBase64Char < 0) {
                    if (i3 == 34) {
                        return byteArrayBuilder_getByteArrayBuilder.toByteArray();
                    }
                    iDecodeBase64Char = _decodeBase64Escape(base64Variant, i3, 0);
                    if (iDecodeBase64Char < 0) {
                        continue;
                    }
                }
                if (this._inputPtr >= this._inputEnd) {
                    _loadMoreGuaranteed();
                }
                byte[] bArr2 = this._inputBuffer;
                int i10 = this._inputPtr;
                this._inputPtr = i10 + 1;
                int i11 = bArr2[i10] & 255;
                int iDecodeBase64Char2 = base64Variant.decodeBase64Char(i11);
                if (iDecodeBase64Char2 < 0) {
                    iDecodeBase64Char2 = _decodeBase64Escape(base64Variant, i11, 1);
                }
                int i12 = (iDecodeBase64Char << 6) | iDecodeBase64Char2;
                if (this._inputPtr >= this._inputEnd) {
                    _loadMoreGuaranteed();
                }
                byte[] bArr3 = this._inputBuffer;
                int i13 = this._inputPtr;
                this._inputPtr = i13 + 1;
                int i14 = bArr3[i13] & 255;
                int iDecodeBase64Char3 = base64Variant.decodeBase64Char(i14);
                if (iDecodeBase64Char3 < 0) {
                    if (iDecodeBase64Char3 != -2) {
                        if (i14 == 34) {
                            byteArrayBuilder_getByteArrayBuilder.append(i12 >> 4);
                            if (base64Variant.requiresPaddingOnRead()) {
                                this._inputPtr--;
                                _handleBase64MissingPadding(base64Variant);
                            }
                            return byteArrayBuilder_getByteArrayBuilder.toByteArray();
                        }
                        iDecodeBase64Char3 = _decodeBase64Escape(base64Variant, i14, 2);
                    }
                    if (iDecodeBase64Char3 == -2) {
                        if (this._inputPtr >= this._inputEnd) {
                            _loadMoreGuaranteed();
                        }
                        byte[] bArr4 = this._inputBuffer;
                        int i15 = this._inputPtr;
                        this._inputPtr = i15 + 1;
                        int i16 = bArr4[i15] & 255;
                        if (!base64Variant.usesPaddingChar(i16) && _decodeBase64Escape(base64Variant, i16, 3) != -2) {
                            throw reportInvalidBase64Char(base64Variant, i16, 3, "expected padding character '" + base64Variant.getPaddingChar() + "'");
                        }
                        byteArrayBuilder_getByteArrayBuilder.append(i12 >> 4);
                    }
                }
                int i17 = (i12 << 6) | iDecodeBase64Char3;
                if (this._inputPtr >= this._inputEnd) {
                    _loadMoreGuaranteed();
                }
                byte[] bArr5 = this._inputBuffer;
                int i18 = this._inputPtr;
                this._inputPtr = i18 + 1;
                int i19 = bArr5[i18] & 255;
                int iDecodeBase64Char4 = base64Variant.decodeBase64Char(i19);
                if (iDecodeBase64Char4 < 0) {
                    if (iDecodeBase64Char4 != -2) {
                        if (i19 == 34) {
                            byteArrayBuilder_getByteArrayBuilder.appendTwoBytes(i17 >> 2);
                            if (base64Variant.requiresPaddingOnRead()) {
                                this._inputPtr--;
                                _handleBase64MissingPadding(base64Variant);
                            }
                            return byteArrayBuilder_getByteArrayBuilder.toByteArray();
                        }
                        iDecodeBase64Char4 = _decodeBase64Escape(base64Variant, i19, 3);
                    }
                    if (iDecodeBase64Char4 == -2) {
                        byteArrayBuilder_getByteArrayBuilder.appendTwoBytes(i17 >> 2);
                    }
                }
                byteArrayBuilder_getByteArrayBuilder.appendThreeBytes((i17 << 6) | iDecodeBase64Char4);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int _decodeCharForError(int r7) {
        /*
            r6 = this;
            r0 = r7 & 255(0xff, float:3.57E-43)
            r1 = 127(0x7f, float:1.78E-43)
            if (r0 <= r1) goto L69
            r1 = r7 & 224(0xe0, float:3.14E-43)
            r2 = 2
            r3 = 1
            r4 = 192(0xc0, float:2.69E-43)
            if (r1 != r4) goto L12
            r0 = r7 & 31
        L10:
            r7 = r3
            goto L2c
        L12:
            r1 = r7 & 240(0xf0, float:3.36E-43)
            r4 = 224(0xe0, float:3.14E-43)
            if (r1 != r4) goto L1c
            r0 = r7 & 15
            r7 = r2
            goto L2c
        L1c:
            r1 = r7 & 248(0xf8, float:3.48E-43)
            r4 = 240(0xf0, float:3.36E-43)
            if (r1 != r4) goto L26
            r0 = r7 & 7
            r7 = 3
            goto L2c
        L26:
            r7 = r7 & 255(0xff, float:3.57E-43)
            r6._reportInvalidInitial(r7)
            goto L10
        L2c:
            int r1 = r6.nextByte()
            r4 = r1 & 192(0xc0, float:2.69E-43)
            r5 = 128(0x80, float:1.8E-43)
            if (r4 == r5) goto L3b
            r4 = r1 & 255(0xff, float:3.57E-43)
            r6._reportInvalidOther(r4)
        L3b:
            int r0 = r0 << 6
            r1 = r1 & 63
            r0 = r0 | r1
            if (r7 <= r3) goto L69
            int r1 = r6.nextByte()
            r3 = r1 & 192(0xc0, float:2.69E-43)
            if (r3 == r5) goto L4f
            r3 = r1 & 255(0xff, float:3.57E-43)
            r6._reportInvalidOther(r3)
        L4f:
            int r0 = r0 << 6
            r1 = r1 & 63
            r0 = r0 | r1
            if (r7 <= r2) goto L69
            int r7 = r6.nextByte()
            r1 = r7 & 192(0xc0, float:2.69E-43)
            if (r1 == r5) goto L63
            r1 = r7 & 255(0xff, float:3.57E-43)
            r6._reportInvalidOther(r1)
        L63:
            int r6 = r0 << 6
            r7 = r7 & 63
            r6 = r6 | r7
            return r6
        L69:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.UTF8StreamJsonParser._decodeCharForError(int):int");
    }

    @Override // com.fasterxml.jackson.core.base.ParserBase
    public char _decodeEscaped() {
        if (this._inputPtr >= this._inputEnd && !_loadMore()) {
            _reportInvalidEOF(" in character escape sequence", JsonToken.VALUE_STRING);
        }
        byte[] bArr = this._inputBuffer;
        int i = this._inputPtr;
        this._inputPtr = i + 1;
        byte b10 = bArr[i];
        if (b10 == 34 || b10 == 47 || b10 == 92) {
            return (char) b10;
        }
        if (b10 == 98) {
            return '\b';
        }
        if (b10 == 102) {
            return '\f';
        }
        if (b10 == 110) {
            return '\n';
        }
        if (b10 == 114) {
            return '\r';
        }
        if (b10 == 116) {
            return '\t';
        }
        if (b10 != 117) {
            return _handleUnrecognizedCharacterEscape((char) _decodeCharForError(b10));
        }
        int i3 = 0;
        for (int i10 = 0; i10 < 4; i10++) {
            if (this._inputPtr >= this._inputEnd && !_loadMore()) {
                _reportInvalidEOF(" in character escape sequence", JsonToken.VALUE_STRING);
            }
            byte[] bArr2 = this._inputBuffer;
            int i11 = this._inputPtr;
            this._inputPtr = i11 + 1;
            byte b11 = bArr2[i11];
            int iCharToHex = CharTypes.charToHex(b11);
            if (iCharToHex < 0) {
                _reportUnexpectedChar(b11 & 255, "expected a hex-digit for character escape sequence");
            }
            i3 = (i3 << 4) | iCharToHex;
        }
        return (char) i3;
    }

    public String _finishAndReturnString() {
        int i = this._inputPtr;
        if (i >= this._inputEnd) {
            _loadMoreGuaranteed();
            i = this._inputPtr;
        }
        char[] cArrEmptyAndGetCurrentSegment = this._textBuffer.emptyAndGetCurrentSegment();
        int[] iArr = JsonParserBase.INPUT_CODES_UTF8;
        int iMin = Math.min(this._inputEnd, cArrEmptyAndGetCurrentSegment.length + i);
        byte[] bArr = this._inputBuffer;
        int i3 = 0;
        while (true) {
            if (i >= iMin) {
                break;
            }
            int i10 = bArr[i] & 255;
            if (iArr[i10] == 0) {
                i++;
                cArrEmptyAndGetCurrentSegment[i3] = (char) i10;
                i3++;
            } else if (i10 == 34) {
                this._inputPtr = i + 1;
                return this._textBuffer.setCurrentAndReturn(i3);
            }
        }
        this._inputPtr = i;
        _finishString2(cArrEmptyAndGetCurrentSegment, i3);
        return this._textBuffer.contentsAsString();
    }

    @Override // com.fasterxml.jackson.core.base.ParserBase
    public void _finishString() {
        int i = this._inputPtr;
        if (i >= this._inputEnd) {
            _loadMoreGuaranteed();
            i = this._inputPtr;
        }
        char[] cArrEmptyAndGetCurrentSegment = this._textBuffer.emptyAndGetCurrentSegment();
        int[] iArr = JsonParserBase.INPUT_CODES_UTF8;
        int iMin = Math.min(this._inputEnd, cArrEmptyAndGetCurrentSegment.length + i);
        byte[] bArr = this._inputBuffer;
        int i3 = 0;
        while (true) {
            if (i >= iMin) {
                break;
            }
            int i10 = bArr[i] & 255;
            if (iArr[i10] == 0) {
                i++;
                cArrEmptyAndGetCurrentSegment[i3] = (char) i10;
                i3++;
            } else if (i10 == 34) {
                this._inputPtr = i + 1;
                this._textBuffer.setCurrentLength(i3);
                return;
            }
        }
        this._inputPtr = i;
        _finishString2(cArrEmptyAndGetCurrentSegment, i3);
    }

    public final String _getText2(JsonToken jsonToken) {
        if (jsonToken == null) {
            return null;
        }
        int iId = jsonToken.id();
        return iId != 5 ? (iId == 6 || iId == 7 || iId == 8) ? this._textBuffer.contentsAsString() : jsonToken.asString() : this._parsingContext.getCurrentName();
    }

    public JsonToken _handleApos() {
        char[] cArrEmptyAndGetCurrentSegment = this._textBuffer.emptyAndGetCurrentSegment();
        int[] iArr = JsonParserBase.INPUT_CODES_UTF8;
        byte[] bArr = this._inputBuffer;
        int i = 0;
        while (true) {
            if (this._inputPtr >= this._inputEnd) {
                _loadMoreGuaranteed();
            }
            if (i >= cArrEmptyAndGetCurrentSegment.length) {
                cArrEmptyAndGetCurrentSegment = this._textBuffer.finishCurrentSegment();
                i = 0;
            }
            int i3 = this._inputEnd;
            int iAddOverflowSafe = InternalJacksonUtil.addOverflowSafe(this._inputPtr, cArrEmptyAndGetCurrentSegment.length - i);
            if (iAddOverflowSafe < i3) {
                i3 = iAddOverflowSafe;
            }
            while (true) {
                int i10 = this._inputPtr;
                if (i10 < i3) {
                    int i11 = i10 + 1;
                    this._inputPtr = i11;
                    int i_decodeEscaped = bArr[i10] & 255;
                    if (i_decodeEscaped == 39) {
                        this._textBuffer.setCurrentLength(i);
                        return JsonToken.VALUE_STRING;
                    }
                    int i12 = iArr[i_decodeEscaped];
                    if (i12 == 0 || i_decodeEscaped == 34) {
                        cArrEmptyAndGetCurrentSegment[i] = (char) i_decodeEscaped;
                        i++;
                    } else {
                        if (i12 == 1) {
                            i_decodeEscaped = _decodeEscaped();
                        } else if (i12 == 2) {
                            i_decodeEscaped = _decodeUtf8_2(i_decodeEscaped);
                        } else if (i12 == 3) {
                            i_decodeEscaped = this._inputEnd - i11 >= 2 ? _decodeUtf8_3fast(i_decodeEscaped) : _decodeUtf8_3(i_decodeEscaped);
                        } else if (i12 != 4) {
                            if (i_decodeEscaped < 32) {
                                _throwUnquotedSpace(i_decodeEscaped, "string value");
                            }
                            _reportInvalidChar(i_decodeEscaped);
                        } else {
                            int i_decodeUtf8_4 = _decodeUtf8_4(i_decodeEscaped);
                            int i13 = i + 1;
                            cArrEmptyAndGetCurrentSegment[i] = (char) ((i_decodeUtf8_4 >> 10) | GeneratorBase.SURR1_FIRST);
                            if (i13 >= cArrEmptyAndGetCurrentSegment.length) {
                                cArrEmptyAndGetCurrentSegment = this._textBuffer.finishCurrentSegment();
                                i = 0;
                            } else {
                                i = i13;
                            }
                            i_decodeEscaped = 56320 | (i_decodeUtf8_4 & FastDoubleMath.DOUBLE_EXPONENT_BIAS);
                        }
                        if (i >= cArrEmptyAndGetCurrentSegment.length) {
                            cArrEmptyAndGetCurrentSegment = this._textBuffer.finishCurrentSegment();
                            i = 0;
                        }
                        cArrEmptyAndGetCurrentSegment[i] = (char) i_decodeEscaped;
                        i++;
                    }
                }
            }
        }
    }

    public JsonToken _handleInvalidNumberStart(int i, boolean z10, boolean z11) {
        String str;
        while (i == 73) {
            if (this._inputPtr >= this._inputEnd && !_loadMore()) {
                _reportInvalidEOFInValue(JsonToken.VALUE_NUMBER_FLOAT);
            }
            byte[] bArr = this._inputBuffer;
            int i3 = this._inputPtr;
            this._inputPtr = i3 + 1;
            i = bArr[i3];
            if (i != 78) {
                if (i != 110) {
                    break;
                }
                str = z10 ? "-Infinity" : "+Infinity";
            } else {
                str = z10 ? "-INF" : "+INF";
            }
            _matchToken(str, 3);
            if ((this._features & JsonParserBase.FEAT_MASK_NON_NUM_NUMBERS) != 0) {
                return resetAsNaN(str, z10 ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY);
            }
            _reportError("Non-standard token '%s': enable `JsonReadFeature.ALLOW_NON_NUMERIC_NUMBERS` to allow", str);
        }
        if (!isEnabled(JsonReadFeature.ALLOW_LEADING_PLUS_SIGN_FOR_NUMBERS.mappedFeature()) && z11 && !z10) {
            _reportUnexpectedNumberChar(43, "JSON spec does not allow numbers to have plus signs: enable `JsonReadFeature.ALLOW_LEADING_PLUS_SIGN_FOR_NUMBERS` to allow");
        }
        _reportUnexpectedNumberChar(i, z10 ? "expected digit (0-9) to follow minus sign, for valid numeric value" : "expected digit (0-9) for valid numeric value");
        return null;
    }

    public String _handleOddName(int i) throws StreamConstraintsException {
        if (i == 39 && (this._features & JsonParserBase.FEAT_MASK_ALLOW_SINGLE_QUOTES) != 0) {
            return _parseAposName();
        }
        if ((this._features & JsonParserBase.FEAT_MASK_ALLOW_UNQUOTED_NAMES) == 0) {
            _reportUnexpectedChar((char) _decodeCharForError(i), "was expecting double-quote to start field name");
        }
        int[] inputCodeUtf8JsNames = CharTypes.getInputCodeUtf8JsNames();
        if (inputCodeUtf8JsNames[i] != 0) {
            _reportUnexpectedChar(i, "was expecting either valid name character (for unquoted name) or double-quote (for quoted) to start field name");
        }
        int[] iArr_growNameDecodeBuffer = this._quadBuffer;
        int i3 = 0;
        int i10 = 0;
        int i11 = 0;
        while (true) {
            if (i3 < 4) {
                i3++;
                i |= i11 << 8;
            } else {
                if (i10 >= iArr_growNameDecodeBuffer.length) {
                    iArr_growNameDecodeBuffer = _growNameDecodeBuffer(iArr_growNameDecodeBuffer, iArr_growNameDecodeBuffer.length);
                    this._quadBuffer = iArr_growNameDecodeBuffer;
                }
                iArr_growNameDecodeBuffer[i10] = i11;
                i10++;
                i3 = 1;
            }
            i11 = i;
            if (this._inputPtr >= this._inputEnd && !_loadMore()) {
                _reportInvalidEOF(" in field name", JsonToken.FIELD_NAME);
            }
            byte[] bArr = this._inputBuffer;
            int i12 = this._inputPtr;
            i = bArr[i12] & 255;
            if (inputCodeUtf8JsNames[i] != 0) {
                break;
            }
            this._inputPtr = i12 + 1;
        }
        if (i3 > 0) {
            if (i10 >= iArr_growNameDecodeBuffer.length) {
                iArr_growNameDecodeBuffer = _growNameDecodeBuffer(iArr_growNameDecodeBuffer, iArr_growNameDecodeBuffer.length);
                this._quadBuffer = iArr_growNameDecodeBuffer;
            }
            iArr_growNameDecodeBuffer[i10] = i11;
            i10++;
        }
        String strFindName = this._symbols.findName(iArr_growNameDecodeBuffer, i10);
        return strFindName == null ? addName(iArr_growNameDecodeBuffer, i10, i3) : strFindName;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x001b, code lost:
    
        if (r4 != 44) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0048, code lost:
    
        if (r3._parsingContext.inArray() == false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0051, code lost:
    
        if (r3._parsingContext.inRoot() != false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0058, code lost:
    
        if ((r3._features & com.fasterxml.jackson.core.json.JsonParserBase.FEAT_MASK_ALLOW_MISSING) == 0) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x005a, code lost:
    
        r3._inputPtr--;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0061, code lost:
    
        return com.fasterxml.jackson.core.JsonToken.VALUE_NULL;
     */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00a1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.fasterxml.jackson.core.JsonToken _handleUnexpectedValue(int r4) {
        /*
            r3 = this;
            r0 = 39
            if (r4 == r0) goto L9a
            r0 = 73
            r1 = 1
            if (r4 == r0) goto L81
            r0 = 78
            if (r4 == r0) goto L68
            r0 = 93
            if (r4 == r0) goto L42
            r0 = 125(0x7d, float:1.75E-43)
            if (r4 == r0) goto L62
            r0 = 43
            if (r4 == r0) goto L1f
            r0 = 44
            if (r4 == r0) goto L4b
            goto La6
        L1f:
            int r4 = r3._inputPtr
            int r0 = r3._inputEnd
            if (r4 < r0) goto L30
            boolean r4 = r3._loadMore()
            if (r4 != 0) goto L30
            com.fasterxml.jackson.core.JsonToken r4 = com.fasterxml.jackson.core.JsonToken.VALUE_NUMBER_INT
            r3._reportInvalidEOFInValue(r4)
        L30:
            byte[] r4 = r3._inputBuffer
            int r0 = r3._inputPtr
            int r2 = r0 + 1
            r3._inputPtr = r2
            r4 = r4[r0]
            r4 = r4 & 255(0xff, float:3.57E-43)
            r0 = 0
            com.fasterxml.jackson.core.JsonToken r3 = r3._handleInvalidNumberStart(r4, r0, r1)
            return r3
        L42:
            com.fasterxml.jackson.core.json.JsonReadContext r0 = r3._parsingContext
            boolean r0 = r0.inArray()
            if (r0 != 0) goto L4b
            goto La6
        L4b:
            com.fasterxml.jackson.core.json.JsonReadContext r0 = r3._parsingContext
            boolean r0 = r0.inRoot()
            if (r0 != 0) goto L62
            int r0 = r3._features
            int r2 = com.fasterxml.jackson.core.json.JsonParserBase.FEAT_MASK_ALLOW_MISSING
            r0 = r0 & r2
            if (r0 == 0) goto L62
            int r4 = r3._inputPtr
            int r4 = r4 - r1
            r3._inputPtr = r4
            com.fasterxml.jackson.core.JsonToken r3 = com.fasterxml.jackson.core.JsonToken.VALUE_NULL
            return r3
        L62:
            java.lang.String r0 = "expected a value"
            r3._reportUnexpectedChar(r4, r0)
            goto L9a
        L68:
            java.lang.String r0 = "NaN"
            r3._matchToken(r0, r1)
            int r1 = r3._features
            int r2 = com.fasterxml.jackson.core.json.JsonParserBase.FEAT_MASK_NON_NUM_NUMBERS
            r1 = r1 & r2
            if (r1 == 0) goto L7b
            r1 = 9221120237041090560(0x7ff8000000000000, double:NaN)
            com.fasterxml.jackson.core.JsonToken r3 = r3.resetAsNaN(r0, r1)
            return r3
        L7b:
            java.lang.String r0 = "Non-standard token 'NaN': enable `JsonReadFeature.ALLOW_NON_NUMERIC_NUMBERS` to allow"
            r3._reportError(r0)
            goto La6
        L81:
            java.lang.String r0 = "Infinity"
            r3._matchToken(r0, r1)
            int r1 = r3._features
            int r2 = com.fasterxml.jackson.core.json.JsonParserBase.FEAT_MASK_NON_NUM_NUMBERS
            r1 = r1 & r2
            if (r1 == 0) goto L94
            r1 = 9218868437227405312(0x7ff0000000000000, double:Infinity)
            com.fasterxml.jackson.core.JsonToken r3 = r3.resetAsNaN(r0, r1)
            return r3
        L94:
            java.lang.String r0 = "Non-standard token 'Infinity': enable `JsonReadFeature.ALLOW_NON_NUMERIC_NUMBERS` to allow"
            r3._reportError(r0)
            goto La6
        L9a:
            int r0 = r3._features
            int r1 = com.fasterxml.jackson.core.json.JsonParserBase.FEAT_MASK_ALLOW_SINGLE_QUOTES
            r0 = r0 & r1
            if (r0 == 0) goto La6
            com.fasterxml.jackson.core.JsonToken r3 = r3._handleApos()
            return r3
        La6:
            boolean r0 = java.lang.Character.isJavaIdentifierStart(r4)
            if (r0 == 0) goto Lc2
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = ""
            r0.<init>(r1)
            char r1 = (char) r4
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = r3._validJsonTokenList()
            r3._reportInvalidToken(r0, r1)
        Lc2:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "expected a valid value "
            r0.<init>(r1)
            java.lang.String r1 = r3._validJsonValueList()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r3._reportUnexpectedChar(r4, r0)
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.UTF8StreamJsonParser._handleUnexpectedValue(int):com.fasterxml.jackson.core.JsonToken");
    }

    public final boolean _loadMore() throws IOException {
        int length;
        if (this._inputStream == null || (length = this._inputBuffer.length) == 0) {
            return false;
        }
        int i = this._inputEnd;
        long j10 = this._currInputProcessed + i;
        this._currInputProcessed = j10;
        this._currInputRowStart -= i;
        this._streamReadConstraints.validateDocumentLength(j10);
        int i3 = this._inputStream.read(this._inputBuffer, 0, length);
        if (i3 > 0) {
            this._nameStartOffset -= i;
            this._inputPtr = 0;
            this._inputEnd = i3;
            return true;
        }
        this._inputEnd = 0;
        this._inputPtr = 0;
        _closeInput();
        if (i3 == 0) {
            f.l(a.r(new StringBuilder("InputStream.read() returned 0 characters when trying to read "), this._inputBuffer.length, " bytes"));
            return false;
        }
        return false;
    }

    public void _loadMoreGuaranteed() {
        if (_loadMore()) {
            return;
        }
        _reportInvalidEOF();
    }

    public final void _matchFalse() {
        int i;
        int i3 = this._inputPtr;
        if (i3 + 4 < this._inputEnd) {
            byte[] bArr = this._inputBuffer;
            int i10 = i3 + 1;
            if (bArr[i3] == 97) {
                int i11 = i3 + 2;
                if (bArr[i10] == 108) {
                    int i12 = i3 + 3;
                    if (bArr[i11] == 115) {
                        int i13 = i3 + 4;
                        if (bArr[i12] == 101 && ((i = bArr[i13] & 255) < 48 || (i | 32) == 125)) {
                            this._inputPtr = i13;
                            return;
                        }
                    }
                }
            }
        }
        _matchToken2("false", 1);
    }

    public final void _matchNull() {
        int i;
        int i3 = this._inputPtr;
        if (i3 + 3 < this._inputEnd) {
            byte[] bArr = this._inputBuffer;
            int i10 = i3 + 1;
            if (bArr[i3] == 117) {
                int i11 = i3 + 2;
                if (bArr[i10] == 108) {
                    int i12 = i3 + 3;
                    if (bArr[i11] == 108 && ((i = bArr[i12] & 255) < 48 || (i | 32) == 125)) {
                        this._inputPtr = i12;
                        return;
                    }
                }
            }
        }
        _matchToken2("null", 1);
    }

    public final void _matchToken(String str, int i) {
        int i3;
        int length = str.length();
        if (this._inputPtr + length >= this._inputEnd) {
            _matchToken2(str, i);
            return;
        }
        do {
            if (this._inputBuffer[this._inputPtr] != str.charAt(i)) {
                _reportInvalidToken(str.substring(0, i));
            }
            i3 = this._inputPtr + 1;
            this._inputPtr = i3;
            i++;
        } while (i < length);
        int i10 = this._inputBuffer[i3] & 255;
        if (i10 < 48 || i10 == 93 || i10 == 125) {
            return;
        }
        _checkMatchEnd(str, i, i10);
    }

    public final void _matchTrue() {
        int i;
        int i3 = this._inputPtr;
        if (i3 + 3 < this._inputEnd) {
            byte[] bArr = this._inputBuffer;
            int i10 = i3 + 1;
            if (bArr[i3] == 114) {
                int i11 = i3 + 2;
                if (bArr[i10] == 117) {
                    int i12 = i3 + 3;
                    if (bArr[i11] == 101 && ((i = bArr[i12] & 255) < 48 || (i | 32) == 125)) {
                        this._inputPtr = i12;
                        return;
                    }
                }
            }
        }
        _matchToken2("true", 1);
    }

    public String _parseAposName() throws StreamConstraintsException {
        if (this._inputPtr >= this._inputEnd && !_loadMore()) {
            _reportInvalidEOF(": was expecting closing ''' for field name", JsonToken.FIELD_NAME);
        }
        byte[] bArr = this._inputBuffer;
        int i = this._inputPtr;
        this._inputPtr = i + 1;
        int i_decodeEscaped = bArr[i] & 255;
        if (i_decodeEscaped == 39) {
            return "";
        }
        int[] iArr_growNameDecodeBuffer = this._quadBuffer;
        int[] iArr = JsonParserBase.INPUT_CODES_LATIN1;
        int i3 = 0;
        int i10 = 0;
        int i11 = 0;
        while (i_decodeEscaped != 39) {
            if (iArr[i_decodeEscaped] != 0 && i_decodeEscaped != 34) {
                if (i_decodeEscaped != 92) {
                    _throwUnquotedSpace(i_decodeEscaped, "name");
                } else {
                    i_decodeEscaped = _decodeEscaped();
                }
                if (i_decodeEscaped > 127) {
                    if (i3 >= 4) {
                        if (i10 >= iArr_growNameDecodeBuffer.length) {
                            iArr_growNameDecodeBuffer = _growNameDecodeBuffer(iArr_growNameDecodeBuffer, iArr_growNameDecodeBuffer.length);
                            this._quadBuffer = iArr_growNameDecodeBuffer;
                        }
                        iArr_growNameDecodeBuffer[i10] = i11;
                        i11 = 0;
                        i10++;
                        i3 = 0;
                    }
                    if (i_decodeEscaped < 2048) {
                        i11 = (i11 << 8) | (i_decodeEscaped >> 6) | 192;
                        i3++;
                    } else {
                        int i12 = (i11 << 8) | (i_decodeEscaped >> 12) | 224;
                        int i13 = i3 + 1;
                        if (i13 >= 4) {
                            if (i10 >= iArr_growNameDecodeBuffer.length) {
                                iArr_growNameDecodeBuffer = _growNameDecodeBuffer(iArr_growNameDecodeBuffer, iArr_growNameDecodeBuffer.length);
                                this._quadBuffer = iArr_growNameDecodeBuffer;
                            }
                            iArr_growNameDecodeBuffer[i10] = i12;
                            i12 = 0;
                            i10++;
                            i13 = 0;
                        }
                        i11 = (i12 << 8) | ((i_decodeEscaped >> 6) & 63) | 128;
                        i3 = i13 + 1;
                    }
                    i_decodeEscaped = (i_decodeEscaped & 63) | 128;
                }
            }
            if (i3 < 4) {
                i3++;
                i_decodeEscaped |= i11 << 8;
            } else {
                if (i10 >= iArr_growNameDecodeBuffer.length) {
                    iArr_growNameDecodeBuffer = _growNameDecodeBuffer(iArr_growNameDecodeBuffer, iArr_growNameDecodeBuffer.length);
                    this._quadBuffer = iArr_growNameDecodeBuffer;
                }
                iArr_growNameDecodeBuffer[i10] = i11;
                i10++;
                i3 = 1;
            }
            i11 = i_decodeEscaped;
            if (this._inputPtr >= this._inputEnd && !_loadMore()) {
                _reportInvalidEOF(" in field name", JsonToken.FIELD_NAME);
            }
            byte[] bArr2 = this._inputBuffer;
            int i14 = this._inputPtr;
            this._inputPtr = i14 + 1;
            i_decodeEscaped = bArr2[i14] & 255;
        }
        if (i3 > 0) {
            if (i10 >= iArr_growNameDecodeBuffer.length) {
                iArr_growNameDecodeBuffer = _growNameDecodeBuffer(iArr_growNameDecodeBuffer, iArr_growNameDecodeBuffer.length);
                this._quadBuffer = iArr_growNameDecodeBuffer;
            }
            iArr_growNameDecodeBuffer[i10] = _padLastQuad(i11, i3);
            i10++;
        }
        String strFindName = this._symbols.findName(iArr_growNameDecodeBuffer, i10);
        return strFindName == null ? addName(iArr_growNameDecodeBuffer, i10, i3) : strFindName;
    }

    public final JsonToken _parseFloatThatStartsWithPeriod(boolean z10, boolean z11) {
        if (!isEnabled(JsonReadFeature.ALLOW_LEADING_DECIMAL_POINT_FOR_NUMBERS.mappedFeature())) {
            return _handleUnexpectedValue(46);
        }
        char[] cArrEmptyAndGetCurrentSegment = this._textBuffer.emptyAndGetCurrentSegment();
        int i = 0;
        if (z10) {
            cArrEmptyAndGetCurrentSegment[0] = '-';
            i = 1;
        }
        return _parseFloat(cArrEmptyAndGetCurrentSegment, i, 46, z10, 0);
    }

    public final String _parseName(int i) {
        if (i != 34) {
            return _handleOddName(i);
        }
        int i3 = this._inputPtr;
        if (i3 + 13 > this._inputEnd) {
            return slowParseName();
        }
        byte[] bArr = this._inputBuffer;
        int[] iArr = JsonParserBase.INPUT_CODES_LATIN1;
        int i10 = i3 + 1;
        this._inputPtr = i10;
        int i11 = bArr[i3] & 255;
        if (iArr[i11] != 0) {
            return i11 == 34 ? "" : parseName(0, i11, 0);
        }
        int i12 = i3 + 2;
        this._inputPtr = i12;
        int i13 = bArr[i10] & 255;
        if (iArr[i13] != 0) {
            return i13 == 34 ? findName(i11, 1) : parseName(i11, i13, 1);
        }
        int i14 = i13 | (i11 << 8);
        int i15 = i3 + 3;
        this._inputPtr = i15;
        int i16 = bArr[i12] & 255;
        if (iArr[i16] != 0) {
            return i16 == 34 ? findName(i14, 2) : parseName(i14, i16, 2);
        }
        int i17 = (i14 << 8) | i16;
        int i18 = i3 + 4;
        this._inputPtr = i18;
        int i19 = bArr[i15] & 255;
        if (iArr[i19] != 0) {
            return i19 == 34 ? findName(i17, 3) : parseName(i17, i19, 3);
        }
        int i20 = (i17 << 8) | i19;
        this._inputPtr = i3 + 5;
        int i21 = bArr[i18] & 255;
        if (iArr[i21] != 0) {
            return i21 == 34 ? findName(i20, 4) : parseName(i20, i21, 4);
        }
        this._quad1 = i20;
        return parseMediumName(i21);
    }

    public JsonToken _parseUnsignedNumber(int i) {
        int i3;
        int i10;
        char[] cArrEmptyAndGetCurrentSegment = this._textBuffer.emptyAndGetCurrentSegment();
        if (i == 48) {
            i = _verifyNoLeadingZeroes();
        }
        cArrEmptyAndGetCurrentSegment[0] = (char) i;
        int iMin = Math.min(this._inputEnd, (this._inputPtr + cArrEmptyAndGetCurrentSegment.length) - 1);
        int i11 = 1;
        int i12 = 1;
        while (true) {
            i3 = this._inputPtr;
            if (i3 >= iMin) {
                return _parseNumber2(cArrEmptyAndGetCurrentSegment, i11, false, i12);
            }
            byte[] bArr = this._inputBuffer;
            this._inputPtr = i3 + 1;
            i10 = bArr[i3] & 255;
            if (i10 < 48 || i10 > 57) {
                break;
            }
            i12++;
            cArrEmptyAndGetCurrentSegment[i11] = (char) i10;
            i11++;
        }
        if (i10 == 46 || (i10 | 32) == 101) {
            return _parseFloat(cArrEmptyAndGetCurrentSegment, i11, i10, false, i12);
        }
        this._inputPtr = i3;
        this._textBuffer.setCurrentLength(i11);
        if (this._parsingContext.inRoot()) {
            _verifyRootSpace(i10);
        }
        return resetInt(false, i12);
    }

    public int _readBinary(Base64Variant base64Variant, OutputStream outputStream, byte[] bArr) throws IOException {
        int length = bArr.length - 3;
        int i = 0;
        int i3 = 0;
        while (true) {
            if (this._inputPtr >= this._inputEnd) {
                _loadMoreGuaranteed();
            }
            byte[] bArr2 = this._inputBuffer;
            int i10 = this._inputPtr;
            this._inputPtr = i10 + 1;
            int i11 = bArr2[i10] & 255;
            if (i11 > 32) {
                int iDecodeBase64Char = base64Variant.decodeBase64Char(i11);
                if (iDecodeBase64Char < 0) {
                    if (i11 == 34) {
                        break;
                    }
                    iDecodeBase64Char = _decodeBase64Escape(base64Variant, i11, 0);
                    if (iDecodeBase64Char < 0) {
                        continue;
                    }
                }
                if (i > length) {
                    i3 += i;
                    outputStream.write(bArr, 0, i);
                    i = 0;
                }
                if (this._inputPtr >= this._inputEnd) {
                    _loadMoreGuaranteed();
                }
                byte[] bArr3 = this._inputBuffer;
                int i12 = this._inputPtr;
                this._inputPtr = i12 + 1;
                int i13 = bArr3[i12] & 255;
                int iDecodeBase64Char2 = base64Variant.decodeBase64Char(i13);
                if (iDecodeBase64Char2 < 0) {
                    iDecodeBase64Char2 = _decodeBase64Escape(base64Variant, i13, 1);
                }
                int i14 = (iDecodeBase64Char << 6) | iDecodeBase64Char2;
                if (this._inputPtr >= this._inputEnd) {
                    _loadMoreGuaranteed();
                }
                byte[] bArr4 = this._inputBuffer;
                int i15 = this._inputPtr;
                this._inputPtr = i15 + 1;
                int i16 = bArr4[i15] & 255;
                int iDecodeBase64Char3 = base64Variant.decodeBase64Char(i16);
                if (iDecodeBase64Char3 < 0) {
                    if (iDecodeBase64Char3 != -2) {
                        if (i16 == 34) {
                            int i17 = i + 1;
                            bArr[i] = (byte) (i14 >> 4);
                            if (base64Variant.requiresPaddingOnRead()) {
                                this._inputPtr--;
                                _handleBase64MissingPadding(base64Variant);
                            }
                            i = i17;
                        } else {
                            iDecodeBase64Char3 = _decodeBase64Escape(base64Variant, i16, 2);
                        }
                    }
                    if (iDecodeBase64Char3 == -2) {
                        if (this._inputPtr >= this._inputEnd) {
                            _loadMoreGuaranteed();
                        }
                        byte[] bArr5 = this._inputBuffer;
                        int i18 = this._inputPtr;
                        this._inputPtr = i18 + 1;
                        int i19 = bArr5[i18] & 255;
                        if (!base64Variant.usesPaddingChar(i19) && _decodeBase64Escape(base64Variant, i19, 3) != -2) {
                            throw reportInvalidBase64Char(base64Variant, i19, 3, "expected padding character '" + base64Variant.getPaddingChar() + "'");
                        }
                        bArr[i] = (byte) (i14 >> 4);
                        i++;
                    }
                }
                int i20 = (i14 << 6) | iDecodeBase64Char3;
                if (this._inputPtr >= this._inputEnd) {
                    _loadMoreGuaranteed();
                }
                byte[] bArr6 = this._inputBuffer;
                int i21 = this._inputPtr;
                this._inputPtr = i21 + 1;
                int i22 = bArr6[i21] & 255;
                int iDecodeBase64Char4 = base64Variant.decodeBase64Char(i22);
                if (iDecodeBase64Char4 < 0) {
                    if (iDecodeBase64Char4 != -2) {
                        if (i22 == 34) {
                            int i23 = i + 1;
                            bArr[i] = (byte) (i20 >> 10);
                            i += 2;
                            bArr[i23] = (byte) (i20 >> 2);
                            if (base64Variant.requiresPaddingOnRead()) {
                                this._inputPtr--;
                                _handleBase64MissingPadding(base64Variant);
                            }
                        } else {
                            iDecodeBase64Char4 = _decodeBase64Escape(base64Variant, i22, 3);
                        }
                    }
                    if (iDecodeBase64Char4 == -2) {
                        int i24 = i + 1;
                        bArr[i] = (byte) (i20 >> 10);
                        i += 2;
                        bArr[i24] = (byte) (i20 >> 2);
                    }
                }
                int i25 = (i20 << 6) | iDecodeBase64Char4;
                bArr[i] = (byte) (i25 >> 16);
                int i26 = i + 2;
                bArr[i + 1] = (byte) (i25 >> 8);
                i += 3;
                bArr[i26] = (byte) i25;
            }
        }
        this._tokenIncomplete = false;
        if (i <= 0) {
            return i3;
        }
        int i27 = i3 + i;
        outputStream.write(bArr, 0, i);
        return i27;
    }

    @Override // com.fasterxml.jackson.core.base.ParserBase
    public void _releaseBuffers() {
        byte[] bArr;
        byte[] bArr2;
        super._releaseBuffers();
        this._symbols.release();
        if (!this._bufferRecyclable || (bArr = this._inputBuffer) == null || bArr == (bArr2 = ParserMinimalBase.NO_BYTES)) {
            return;
        }
        this._inputBuffer = bArr2;
        this._ioContext.releaseReadIOBuffer(bArr);
    }

    public void _reportInvalidChar(int i) {
        if (i < 32) {
            _throwInvalidSpace(i);
        }
        _reportInvalidInitial(i);
    }

    public void _reportInvalidInitial(int i) {
        _reportError("Invalid UTF-8 start byte 0x" + Integer.toHexString(i));
    }

    public void _reportInvalidOther(int i) {
        _reportError("Invalid UTF-8 middle byte 0x" + Integer.toHexString(i));
    }

    public void _reportInvalidToken(String str, String str2) {
        StringBuilder sb2 = new StringBuilder(str);
        while (true) {
            if (this._inputPtr >= this._inputEnd && !_loadMore()) {
                break;
            }
            byte[] bArr = this._inputBuffer;
            int i = this._inputPtr;
            this._inputPtr = i + 1;
            char c_decodeCharForError = (char) _decodeCharForError(bArr[i]);
            if (!Character.isJavaIdentifierPart(c_decodeCharForError)) {
                break;
            }
            sb2.append(c_decodeCharForError);
            if (sb2.length() >= this._ioContext.errorReportConfiguration().getMaxErrorTokenLength()) {
                sb2.append("...");
                break;
            }
        }
        _reportError("Unrecognized token '%s': was expecting %s", sb2, str2);
    }

    public final void _skipCR() {
        if (this._inputPtr < this._inputEnd || _loadMore()) {
            byte[] bArr = this._inputBuffer;
            int i = this._inputPtr;
            if (bArr[i] == 10) {
                this._inputPtr = i + 1;
            }
        }
        this._currInputRow++;
        this._currInputRowStart = this._inputPtr;
    }

    public void _skipString() {
        this._tokenIncomplete = false;
        int[] iArr = JsonParserBase.INPUT_CODES_UTF8;
        byte[] bArr = this._inputBuffer;
        while (true) {
            int i = this._inputPtr;
            int i3 = this._inputEnd;
            if (i >= i3) {
                _loadMoreGuaranteed();
                i = this._inputPtr;
                i3 = this._inputEnd;
            }
            while (true) {
                if (i >= i3) {
                    this._inputPtr = i;
                    break;
                }
                int i10 = i + 1;
                int i11 = bArr[i] & 255;
                int i12 = iArr[i11];
                if (i12 != 0) {
                    this._inputPtr = i10;
                    if (i11 == 34) {
                        return;
                    }
                    if (i12 == 1) {
                        _decodeEscaped();
                    } else if (i12 == 2) {
                        _skipUtf8_2();
                    } else if (i12 == 3) {
                        _skipUtf8_3();
                    } else if (i12 == 4) {
                        _skipUtf8_4(i11);
                    } else if (i11 < 32) {
                        _throwUnquotedSpace(i11, "string value");
                    } else {
                        _reportInvalidChar(i11);
                    }
                } else {
                    i = i10;
                }
            }
        }
    }

    @Override // com.fasterxml.jackson.core.json.JsonParserBase, com.fasterxml.jackson.core.JsonParser
    public JsonLocation currentLocation() {
        return new JsonLocation(_contentReference(), this._currInputProcessed + this._inputPtr, -1L, this._currInputRow, (this._inputPtr - this._currInputRowStart) + 1);
    }

    @Override // com.fasterxml.jackson.core.json.JsonParserBase, com.fasterxml.jackson.core.JsonParser
    public JsonLocation currentTokenLocation() {
        if (this._currToken != JsonToken.FIELD_NAME) {
            return new JsonLocation(_contentReference(), this._tokenInputTotal - 1, -1L, this._tokenInputRow, this._tokenInputCol);
        }
        return new JsonLocation(_contentReference(), this._currInputProcessed + (this._nameStartOffset - 1), -1L, this._nameStartRow, this._nameStartCol);
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public void finishToken() {
        if (this._tokenIncomplete) {
            this._tokenIncomplete = false;
            _finishString();
        }
    }

    @Override // com.fasterxml.jackson.core.base.ParserBase, com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public byte[] getBinaryValue(Base64Variant base64Variant) throws JsonParseException {
        JsonToken jsonToken = this._currToken;
        if (jsonToken != JsonToken.VALUE_STRING && (jsonToken != JsonToken.VALUE_EMBEDDED_OBJECT || this._binaryValue == null)) {
            _reportError("Current token (" + this._currToken + ") not VALUE_STRING or VALUE_EMBEDDED_OBJECT, can not access as binary");
        }
        if (this._tokenIncomplete) {
            try {
                this._binaryValue = _decodeBase64(base64Variant);
                this._tokenIncomplete = false;
            } catch (IllegalArgumentException e10) {
                throw _constructError("Failed to decode VALUE_STRING as base64 (" + base64Variant + "): " + e10.getMessage());
            }
        } else if (this._binaryValue == null) {
            ByteArrayBuilder byteArrayBuilder_getByteArrayBuilder = _getByteArrayBuilder();
            _decodeBase64(getText(), byteArrayBuilder_getByteArrayBuilder, base64Variant);
            this._binaryValue = byteArrayBuilder_getByteArrayBuilder.toByteArray();
        }
        return this._binaryValue;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public Object getInputSource() {
        return this._inputStream;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public int getText(Writer writer) throws IOException {
        JsonToken jsonToken = this._currToken;
        if (jsonToken == JsonToken.VALUE_STRING) {
            if (this._tokenIncomplete) {
                this._tokenIncomplete = false;
                _finishString();
            }
            return this._textBuffer.contentsToWriter(writer);
        }
        if (jsonToken == JsonToken.FIELD_NAME) {
            String currentName = this._parsingContext.getCurrentName();
            writer.write(currentName);
            return currentName.length();
        }
        if (jsonToken == null) {
            return 0;
        }
        if (jsonToken.isNumeric()) {
            return this._textBuffer.contentsToWriter(writer);
        }
        char[] cArrAsCharArray = jsonToken.asCharArray();
        writer.write(cArrAsCharArray);
        return cArrAsCharArray.length;
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public char[] getTextCharacters() {
        JsonToken jsonToken = this._currToken;
        if (jsonToken == null) {
            return null;
        }
        int iId = jsonToken.id();
        if (iId != 5) {
            if (iId != 6) {
                if (iId != 7 && iId != 8) {
                    return this._currToken.asCharArray();
                }
            } else if (this._tokenIncomplete) {
                this._tokenIncomplete = false;
                _finishString();
            }
            return this._textBuffer.getTextBuffer();
        }
        if (!this._nameCopied) {
            String currentName = this._parsingContext.getCurrentName();
            int length = currentName.length();
            char[] cArr = this._nameCopyBuffer;
            if (cArr == null) {
                this._nameCopyBuffer = this._ioContext.allocNameCopyBuffer(length);
            } else if (cArr.length < length) {
                this._nameCopyBuffer = new char[length];
            }
            currentName.getChars(0, length, this._nameCopyBuffer, 0);
            this._nameCopied = true;
        }
        return this._nameCopyBuffer;
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public int getTextLength() {
        JsonToken jsonToken = this._currToken;
        if (jsonToken == null) {
            return 0;
        }
        int iId = jsonToken.id();
        if (iId == 5) {
            return this._parsingContext.getCurrentName().length();
        }
        if (iId != 6) {
            if (iId != 7 && iId != 8) {
                return this._currToken.asCharArray().length;
            }
        } else if (this._tokenIncomplete) {
            this._tokenIncomplete = false;
            _finishString();
        }
        return this._textBuffer.size();
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0011, code lost:
    
        if (r0 != 8) goto L16;
     */
    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int getTextOffset() {
        /*
            r3 = this;
            com.fasterxml.jackson.core.JsonToken r0 = r3._currToken
            r1 = 0
            if (r0 == 0) goto L24
            int r0 = r0.id()
            r2 = 6
            if (r0 == r2) goto L14
            r2 = 7
            if (r0 == r2) goto L1d
            r2 = 8
            if (r0 == r2) goto L1d
            goto L24
        L14:
            boolean r0 = r3._tokenIncomplete
            if (r0 == 0) goto L1d
            r3._tokenIncomplete = r1
            r3._finishString()
        L1d:
            com.fasterxml.jackson.core.util.TextBuffer r3 = r3._textBuffer
            int r3 = r3.getTextOffset()
            return r3
        L24:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.UTF8StreamJsonParser.getTextOffset():int");
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public int getValueAsInt() {
        JsonToken jsonToken = this._currToken;
        if (jsonToken != JsonToken.VALUE_NUMBER_INT && jsonToken != JsonToken.VALUE_NUMBER_FLOAT) {
            return super.getValueAsInt(0);
        }
        int i = this._numTypesValid;
        if ((i & 1) == 0) {
            if (i == 0) {
                return _parseIntValue();
            }
            if ((i & 1) == 0) {
                convertNumberToInt();
            }
        }
        return this._numberInt;
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public String getValueAsString() {
        JsonToken jsonToken = this._currToken;
        if (jsonToken != JsonToken.VALUE_STRING) {
            return jsonToken == JsonToken.FIELD_NAME ? currentName() : super.getValueAsString(null);
        }
        if (!this._tokenIncomplete) {
            return this._textBuffer.contentsAsString();
        }
        this._tokenIncomplete = false;
        return _finishAndReturnString();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public Boolean nextBooleanValue() throws JsonParseException {
        if (this._currToken != JsonToken.FIELD_NAME) {
            JsonToken jsonTokenNextToken = nextToken();
            if (jsonTokenNextToken == JsonToken.VALUE_TRUE) {
                return Boolean.TRUE;
            }
            if (jsonTokenNextToken == JsonToken.VALUE_FALSE) {
                return Boolean.FALSE;
            }
            return null;
        }
        this._nameCopied = false;
        JsonToken jsonToken = this._nextToken;
        this._nextToken = null;
        _updateToken(jsonToken);
        if (jsonToken == JsonToken.VALUE_TRUE) {
            return Boolean.TRUE;
        }
        if (jsonToken == JsonToken.VALUE_FALSE) {
            return Boolean.FALSE;
        }
        if (jsonToken == JsonToken.START_ARRAY) {
            createChildArrayContext(this._tokenInputRow, this._tokenInputCol);
        } else if (jsonToken == JsonToken.START_OBJECT) {
            createChildObjectContext(this._tokenInputRow, this._tokenInputCol);
        }
        return null;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public String nextFieldName() throws JsonParseException {
        JsonToken jsonToken_parseSignedNumber;
        this._numTypesValid = 0;
        JsonToken jsonToken = this._currToken;
        JsonToken jsonToken2 = JsonToken.FIELD_NAME;
        if (jsonToken == jsonToken2) {
            _nextAfterName();
            return null;
        }
        if (this._tokenIncomplete) {
            _skipString();
        }
        int i_skipWSOrEnd = _skipWSOrEnd();
        if (i_skipWSOrEnd < 0) {
            close();
            _updateTokenToNull();
            return null;
        }
        this._binaryValue = null;
        if (i_skipWSOrEnd == 93) {
            _closeArrayScope();
            _updateToken(JsonToken.END_ARRAY);
            return null;
        }
        if (i_skipWSOrEnd == 125) {
            _closeObjectScope();
            _updateToken(JsonToken.END_OBJECT);
            return null;
        }
        if (this._parsingContext.expectComma()) {
            if (i_skipWSOrEnd != 44) {
                _reportUnexpectedChar(i_skipWSOrEnd, "was expecting comma to separate " + this._parsingContext.typeDesc() + " entries");
            }
            i_skipWSOrEnd = _skipWS();
            if ((this._features & JsonParserBase.FEAT_MASK_TRAILING_COMMA) != 0 && (i_skipWSOrEnd == 93 || i_skipWSOrEnd == 125)) {
                _closeScope(i_skipWSOrEnd);
                return null;
            }
        }
        if (!this._parsingContext.inObject()) {
            _updateLocation();
            _nextTokenNotInObject(i_skipWSOrEnd);
            return null;
        }
        _updateNameLocation();
        String str_parseName = _parseName(i_skipWSOrEnd);
        this._parsingContext.setCurrentName(str_parseName);
        _updateToken(jsonToken2);
        int i_skipColon = _skipColon();
        _updateLocation();
        if (i_skipColon == 34) {
            this._tokenIncomplete = true;
            this._nextToken = JsonToken.VALUE_STRING;
            return str_parseName;
        }
        if (i_skipColon == 43) {
            jsonToken_parseSignedNumber = isEnabled(JsonReadFeature.ALLOW_LEADING_PLUS_SIGN_FOR_NUMBERS.mappedFeature()) ? _parseSignedNumber(false) : _handleUnexpectedValue(i_skipColon);
        } else if (i_skipColon == 91) {
            jsonToken_parseSignedNumber = JsonToken.START_ARRAY;
        } else if (i_skipColon == 102) {
            _matchFalse();
            jsonToken_parseSignedNumber = JsonToken.VALUE_FALSE;
        } else if (i_skipColon == 110) {
            _matchNull();
            jsonToken_parseSignedNumber = JsonToken.VALUE_NULL;
        } else if (i_skipColon == 116) {
            _matchTrue();
            jsonToken_parseSignedNumber = JsonToken.VALUE_TRUE;
        } else if (i_skipColon == 123) {
            jsonToken_parseSignedNumber = JsonToken.START_OBJECT;
        } else if (i_skipColon == 45) {
            jsonToken_parseSignedNumber = _parseSignedNumber(true);
        } else if (i_skipColon != 46) {
            switch (i_skipColon) {
                case 48:
                case 49:
                case 50:
                case 51:
                case 52:
                case FastDoubleMath.DOUBLE_SIGNIFICAND_WIDTH /* 53 */:
                case 54:
                case 55:
                case 56:
                case 57:
                    jsonToken_parseSignedNumber = _parseUnsignedNumber(i_skipColon);
                    break;
                default:
                    jsonToken_parseSignedNumber = _handleUnexpectedValue(i_skipColon);
                    break;
            }
        } else {
            jsonToken_parseSignedNumber = _parseFloatThatStartsWithPeriod(false, false);
        }
        this._nextToken = jsonToken_parseSignedNumber;
        return str_parseName;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public int nextIntValue(int i) {
        if (this._currToken == JsonToken.FIELD_NAME) {
            this._nameCopied = false;
            JsonToken jsonToken = this._nextToken;
            this._nextToken = null;
            _updateToken(jsonToken);
            if (jsonToken == JsonToken.VALUE_NUMBER_INT) {
                return getIntValue();
            }
            if (jsonToken == JsonToken.START_ARRAY) {
                createChildArrayContext(this._tokenInputRow, this._tokenInputCol);
                return i;
            }
            if (jsonToken == JsonToken.START_OBJECT) {
                createChildObjectContext(this._tokenInputRow, this._tokenInputCol);
                return i;
            }
        } else if (nextToken() == JsonToken.VALUE_NUMBER_INT) {
            return getIntValue();
        }
        return i;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public long nextLongValue(long j10) {
        if (this._currToken == JsonToken.FIELD_NAME) {
            this._nameCopied = false;
            JsonToken jsonToken = this._nextToken;
            this._nextToken = null;
            _updateToken(jsonToken);
            if (jsonToken == JsonToken.VALUE_NUMBER_INT) {
                return getLongValue();
            }
            if (jsonToken == JsonToken.START_ARRAY) {
                createChildArrayContext(this._tokenInputRow, this._tokenInputCol);
                return j10;
            }
            if (jsonToken == JsonToken.START_OBJECT) {
                createChildObjectContext(this._tokenInputRow, this._tokenInputCol);
                return j10;
            }
        } else if (nextToken() == JsonToken.VALUE_NUMBER_INT) {
            return getLongValue();
        }
        return j10;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public String nextTextValue() {
        if (this._currToken != JsonToken.FIELD_NAME) {
            if (nextToken() == JsonToken.VALUE_STRING) {
                return getText();
            }
            return null;
        }
        this._nameCopied = false;
        JsonToken jsonToken = this._nextToken;
        this._nextToken = null;
        _updateToken(jsonToken);
        if (jsonToken == JsonToken.VALUE_STRING) {
            if (!this._tokenIncomplete) {
                return this._textBuffer.contentsAsString();
            }
            this._tokenIncomplete = false;
            return _finishAndReturnString();
        }
        if (jsonToken == JsonToken.START_ARRAY) {
            createChildArrayContext(this._tokenInputRow, this._tokenInputCol);
        } else if (jsonToken == JsonToken.START_OBJECT) {
            createChildObjectContext(this._tokenInputRow, this._tokenInputCol);
        }
        return null;
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public JsonToken nextToken() throws JsonParseException {
        JsonToken jsonToken_parseSignedNumber;
        JsonToken jsonToken = this._currToken;
        JsonToken jsonToken2 = JsonToken.FIELD_NAME;
        if (jsonToken == jsonToken2) {
            return _nextAfterName();
        }
        this._numTypesValid = 0;
        if (this._tokenIncomplete) {
            _skipString();
        }
        int i_skipWSOrEnd = _skipWSOrEnd();
        if (i_skipWSOrEnd < 0) {
            close();
            return _updateTokenToNull();
        }
        this._binaryValue = null;
        if (i_skipWSOrEnd == 93) {
            _closeArrayScope();
            return _updateToken(JsonToken.END_ARRAY);
        }
        if (i_skipWSOrEnd == 125) {
            _closeObjectScope();
            return _updateToken(JsonToken.END_OBJECT);
        }
        if (this._parsingContext.expectComma()) {
            if (i_skipWSOrEnd != 44) {
                _reportUnexpectedChar(i_skipWSOrEnd, "was expecting comma to separate " + this._parsingContext.typeDesc() + " entries");
            }
            i_skipWSOrEnd = _skipWS();
            if ((this._features & JsonParserBase.FEAT_MASK_TRAILING_COMMA) != 0 && (i_skipWSOrEnd == 93 || i_skipWSOrEnd == 125)) {
                return _closeScope(i_skipWSOrEnd);
            }
        }
        if (!this._parsingContext.inObject()) {
            _updateLocation();
            return _nextTokenNotInObject(i_skipWSOrEnd);
        }
        _updateNameLocation();
        this._parsingContext.setCurrentName(_parseName(i_skipWSOrEnd));
        _updateToken(jsonToken2);
        int i_skipColon = _skipColon();
        _updateLocation();
        if (i_skipColon == 34) {
            this._tokenIncomplete = true;
            this._nextToken = JsonToken.VALUE_STRING;
            return this._currToken;
        }
        if (i_skipColon == 43) {
            jsonToken_parseSignedNumber = isEnabled(JsonReadFeature.ALLOW_LEADING_PLUS_SIGN_FOR_NUMBERS.mappedFeature()) ? _parseSignedNumber(false) : _handleUnexpectedValue(i_skipColon);
        } else if (i_skipColon == 91) {
            jsonToken_parseSignedNumber = JsonToken.START_ARRAY;
        } else if (i_skipColon == 102) {
            _matchFalse();
            jsonToken_parseSignedNumber = JsonToken.VALUE_FALSE;
        } else if (i_skipColon == 110) {
            _matchNull();
            jsonToken_parseSignedNumber = JsonToken.VALUE_NULL;
        } else if (i_skipColon == 116) {
            _matchTrue();
            jsonToken_parseSignedNumber = JsonToken.VALUE_TRUE;
        } else if (i_skipColon == 123) {
            jsonToken_parseSignedNumber = JsonToken.START_OBJECT;
        } else if (i_skipColon == 45) {
            jsonToken_parseSignedNumber = _parseSignedNumber(true);
        } else if (i_skipColon != 46) {
            switch (i_skipColon) {
                case 48:
                case 49:
                case 50:
                case 51:
                case 52:
                case FastDoubleMath.DOUBLE_SIGNIFICAND_WIDTH /* 53 */:
                case 54:
                case 55:
                case 56:
                case 57:
                    jsonToken_parseSignedNumber = _parseUnsignedNumber(i_skipColon);
                    break;
                default:
                    jsonToken_parseSignedNumber = _handleUnexpectedValue(i_skipColon);
                    break;
            }
        } else {
            jsonToken_parseSignedNumber = _parseFloatThatStartsWithPeriod(false, false);
        }
        this._nextToken = jsonToken_parseSignedNumber;
        return this._currToken;
    }

    public final String parseEscapedName(int[] iArr, int i, int i3, int i10, int i11) throws StreamConstraintsException {
        int[] iArr2 = JsonParserBase.INPUT_CODES_LATIN1;
        while (true) {
            if (iArr2[i10] != 0) {
                if (i10 == 34) {
                    break;
                }
                if (i10 != 92) {
                    _throwUnquotedSpace(i10, "name");
                } else {
                    i10 = _decodeEscaped();
                }
                if (i10 > 127) {
                    int i12 = 0;
                    if (i11 >= 4) {
                        if (i >= iArr.length) {
                            iArr = _growNameDecodeBuffer(iArr, iArr.length);
                            this._quadBuffer = iArr;
                        }
                        iArr[i] = i3;
                        i++;
                        i3 = 0;
                        i11 = 0;
                    }
                    if (i10 < 2048) {
                        i3 = (i3 << 8) | (i10 >> 6) | 192;
                        i11++;
                    } else {
                        int i13 = (i3 << 8) | (i10 >> 12) | 224;
                        int i14 = i11 + 1;
                        if (i14 >= 4) {
                            if (i >= iArr.length) {
                                iArr = _growNameDecodeBuffer(iArr, iArr.length);
                                this._quadBuffer = iArr;
                            }
                            iArr[i] = i13;
                            i++;
                            i14 = 0;
                        } else {
                            i12 = i13;
                        }
                        i3 = (i12 << 8) | ((i10 >> 6) & 63) | 128;
                        i11 = i14 + 1;
                    }
                    i10 = (i10 & 63) | 128;
                }
            }
            if (i11 < 4) {
                i11++;
                i3 = (i3 << 8) | i10;
            } else {
                if (i >= iArr.length) {
                    iArr = _growNameDecodeBuffer(iArr, iArr.length);
                    this._quadBuffer = iArr;
                }
                iArr[i] = i3;
                i3 = i10;
                i++;
                i11 = 1;
            }
            if (this._inputPtr >= this._inputEnd && !_loadMore()) {
                _reportInvalidEOF(" in field name", JsonToken.FIELD_NAME);
            }
            byte[] bArr = this._inputBuffer;
            int i15 = this._inputPtr;
            this._inputPtr = i15 + 1;
            i10 = bArr[i15] & 255;
        }
        if (i11 > 0) {
            if (i >= iArr.length) {
                iArr = _growNameDecodeBuffer(iArr, iArr.length);
                this._quadBuffer = iArr;
            }
            iArr[i] = _padLastQuad(i3, i11);
            i++;
        }
        String strFindName = this._symbols.findName(iArr, i);
        return strFindName == null ? addName(iArr, i, i11) : strFindName;
    }

    public final String parseLongName(int i, int i3, int i10) {
        int[] iArr = this._quadBuffer;
        iArr[0] = this._quad1;
        int i11 = 1;
        iArr[1] = i3;
        iArr[2] = i10;
        byte[] bArr = this._inputBuffer;
        int[] iArr2 = JsonParserBase.INPUT_CODES_LATIN1;
        int i12 = i;
        int i13 = 3;
        while (true) {
            int i14 = this._inputPtr;
            if (i14 + 4 > this._inputEnd) {
                return parseEscapedName(this._quadBuffer, i13, 0, i12, 0);
            }
            int i15 = i14 + 1;
            this._inputPtr = i15;
            int i16 = bArr[i14] & 255;
            if (iArr2[i16] != 0) {
                int[] iArr3 = this._quadBuffer;
                if (i16 == 34) {
                    return findName(iArr3, i13, i12, i11);
                }
                return parseEscapedName(iArr3, i13, i12, i16, 1);
            }
            int i17 = i11;
            int i18 = i13;
            int i19 = i12;
            int[] iArr4 = iArr2;
            int i20 = (i19 << 8) | i16;
            int i21 = i14 + 2;
            this._inputPtr = i21;
            int i22 = bArr[i15] & 255;
            if (iArr4[i22] != 0) {
                int[] iArr5 = this._quadBuffer;
                return i22 == 34 ? findName(iArr5, i18, i20, 2) : parseEscapedName(iArr5, i18, i20, i22, 2);
            }
            int i23 = (i20 << 8) | i22;
            int i24 = i14 + 3;
            this._inputPtr = i24;
            int i25 = bArr[i21] & 255;
            if (iArr4[i25] != 0) {
                int[] iArr6 = this._quadBuffer;
                return i25 == 34 ? findName(iArr6, i18, i23, 3) : parseEscapedName(iArr6, i18, i23, i25, 3);
            }
            int i26 = (i23 << 8) | i25;
            this._inputPtr = i14 + 4;
            int i27 = bArr[i24] & 255;
            if (iArr4[i27] != 0) {
                int[] iArr7 = this._quadBuffer;
                return i27 == 34 ? findName(iArr7, i18, i26, 4) : parseEscapedName(iArr7, i18, i26, i27, 4);
            }
            int[] iArr8 = this._quadBuffer;
            if (i18 >= iArr8.length) {
                this._quadBuffer = _growNameDecodeBuffer(iArr8, i18);
            }
            this._quadBuffer[i18] = i26;
            i12 = i27;
            iArr2 = iArr4;
            i13 = i18 + 1;
            i11 = i17;
        }
    }

    public final String parseMediumName(int i) {
        byte[] bArr = this._inputBuffer;
        int[] iArr = JsonParserBase.INPUT_CODES_LATIN1;
        int i3 = this._inputPtr;
        int i10 = i3 + 1;
        this._inputPtr = i10;
        int i11 = bArr[i3] & 255;
        if (iArr[i11] != 0) {
            int i12 = this._quad1;
            return i11 == 34 ? findName(i12, i, 1) : parseName(i12, i, i11, 1);
        }
        int i13 = (i << 8) | i11;
        int i14 = i3 + 2;
        this._inputPtr = i14;
        int i15 = bArr[i10] & 255;
        if (iArr[i15] != 0) {
            int i16 = this._quad1;
            return i15 == 34 ? findName(i16, i13, 2) : parseName(i16, i13, i15, 2);
        }
        int i17 = (i13 << 8) | i15;
        int i18 = i3 + 3;
        this._inputPtr = i18;
        int i19 = bArr[i14] & 255;
        if (iArr[i19] != 0) {
            int i20 = this._quad1;
            return i19 == 34 ? findName(i20, i17, 3) : parseName(i20, i17, i19, 3);
        }
        int i21 = (i17 << 8) | i19;
        this._inputPtr = i3 + 4;
        int i22 = bArr[i18] & 255;
        if (iArr[i22] == 0) {
            return parseMediumName2(i22, i21);
        }
        int i23 = this._quad1;
        return i22 == 34 ? findName(i23, i21, 4) : parseName(i23, i21, i22, 4);
    }

    public final String parseMediumName2(int i, int i3) {
        byte[] bArr = this._inputBuffer;
        int[] iArr = JsonParserBase.INPUT_CODES_LATIN1;
        int i10 = this._inputPtr;
        int i11 = i10 + 1;
        this._inputPtr = i11;
        int i12 = bArr[i10] & 255;
        if (iArr[i12] != 0) {
            int i13 = this._quad1;
            return i12 == 34 ? findName(i13, i3, i, 1) : parseName(i13, i3, i, i12, 1);
        }
        int i14 = (i << 8) | i12;
        int i15 = i10 + 2;
        this._inputPtr = i15;
        int i16 = bArr[i11] & 255;
        if (iArr[i16] != 0) {
            int i17 = this._quad1;
            return i16 == 34 ? findName(i17, i3, i14, 2) : parseName(i17, i3, i14, i16, 2);
        }
        int i18 = (i14 << 8) | i16;
        int i19 = i10 + 3;
        this._inputPtr = i19;
        int i20 = bArr[i15] & 255;
        if (iArr[i20] != 0) {
            int i21 = this._quad1;
            return i20 == 34 ? findName(i21, i3, i18, 3) : parseName(i21, i3, i18, i20, 3);
        }
        int i22 = (i18 << 8) | i20;
        this._inputPtr = i10 + 4;
        int i23 = bArr[i19] & 255;
        if (iArr[i23] == 0) {
            return parseLongName(i23, i3, i22);
        }
        int i24 = this._quad1;
        return i23 == 34 ? findName(i24, i3, i22, 4) : parseName(i24, i3, i22, i23, 4);
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public int readBinaryValue(Base64Variant base64Variant, OutputStream outputStream) throws IOException {
        if (!this._tokenIncomplete || this._currToken != JsonToken.VALUE_STRING) {
            byte[] binaryValue = getBinaryValue(base64Variant);
            outputStream.write(binaryValue);
            return binaryValue.length;
        }
        byte[] bArrAllocBase64Buffer = this._ioContext.allocBase64Buffer();
        try {
            return _readBinary(base64Variant, outputStream, bArrAllocBase64Buffer);
        } finally {
            this._ioContext.releaseBase64Buffer(bArrAllocBase64Buffer);
        }
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public int releaseBuffered(OutputStream outputStream) throws IOException {
        int i = this._inputEnd;
        int i3 = this._inputPtr;
        int i10 = i - i3;
        if (i10 < 1) {
            return 0;
        }
        this._inputPtr = i3 + i10;
        outputStream.write(this._inputBuffer, i3, i10);
        return i10;
    }

    public String slowParseName() {
        if (this._inputPtr >= this._inputEnd && !_loadMore()) {
            _reportInvalidEOF(": was expecting closing '\"' for name", JsonToken.FIELD_NAME);
        }
        byte[] bArr = this._inputBuffer;
        int i = this._inputPtr;
        this._inputPtr = i + 1;
        int i3 = bArr[i] & 255;
        return i3 == 34 ? "" : parseEscapedName(this._quadBuffer, 0, 0, i3, 0);
    }

    private final String parseName(int i, int i3, int i10) {
        return parseEscapedName(this._quadBuffer, 0, i, i3, i10);
    }

    private final String parseName(int i, int i3, int i10, int i11, int i12) {
        int[] iArr = this._quadBuffer;
        iArr[0] = i;
        iArr[1] = i3;
        return parseEscapedName(iArr, 2, i10, i11, i12);
    }

    public void _reportInvalidOther(int i, int i3) {
        this._inputPtr = i3;
        _reportInvalidOther(i);
    }

    @Deprecated
    public UTF8StreamJsonParser(IOContext iOContext, int i, InputStream inputStream, ObjectCodec objectCodec, ByteQuadsCanonicalizer byteQuadsCanonicalizer, byte[] bArr, int i3, int i10, boolean z10) {
        this(iOContext, i, inputStream, objectCodec, byteQuadsCanonicalizer, bArr, i3, i10, 0, z10);
    }

    private final String findName(int i, int i3, int i10) {
        int i_padLastQuad = _padLastQuad(i3, i10);
        String strFindName = this._symbols.findName(i, i_padLastQuad);
        if (strFindName != null) {
            return strFindName;
        }
        int[] iArr = this._quadBuffer;
        iArr[0] = i;
        iArr[1] = i_padLastQuad;
        return addName(iArr, 2, i10);
    }

    private final String findName(int i, int i3) {
        int i_padLastQuad = _padLastQuad(i, i3);
        String strFindName = this._symbols.findName(i_padLastQuad);
        if (strFindName != null) {
            return strFindName;
        }
        int[] iArr = this._quadBuffer;
        iArr[0] = i_padLastQuad;
        return addName(iArr, 1, i3);
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public int getValueAsInt(int i) {
        JsonToken jsonToken = this._currToken;
        if (jsonToken != JsonToken.VALUE_NUMBER_INT && jsonToken != JsonToken.VALUE_NUMBER_FLOAT) {
            return super.getValueAsInt(i);
        }
        int i3 = this._numTypesValid;
        if ((i3 & 1) == 0) {
            if (i3 == 0) {
                return _parseIntValue();
            }
            if ((i3 & 1) == 0) {
                convertNumberToInt();
            }
        }
        return this._numberInt;
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public String getValueAsString(String str) {
        JsonToken jsonToken = this._currToken;
        if (jsonToken == JsonToken.VALUE_STRING) {
            if (this._tokenIncomplete) {
                this._tokenIncomplete = false;
                return _finishAndReturnString();
            }
            return this._textBuffer.contentsAsString();
        }
        if (jsonToken == JsonToken.FIELD_NAME) {
            return currentName();
        }
        return super.getValueAsString(str);
    }

    private final String findName(int[] iArr, int i, int i3, int i10) throws StreamConstraintsException {
        if (i >= iArr.length) {
            iArr = _growNameDecodeBuffer(iArr, iArr.length);
            this._quadBuffer = iArr;
        }
        int i11 = i + 1;
        iArr[i] = _padLastQuad(i3, i10);
        String strFindName = this._symbols.findName(iArr, i11);
        return strFindName == null ? addName(iArr, i11, i10) : strFindName;
    }

    @Deprecated
    public final JsonToken _parseFloatThatStartsWithPeriod() {
        return _parseFloatThatStartsWithPeriod(false, false);
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public String getText() {
        JsonToken jsonToken = this._currToken;
        if (jsonToken == JsonToken.VALUE_STRING) {
            if (this._tokenIncomplete) {
                this._tokenIncomplete = false;
                return _finishAndReturnString();
            }
            return this._textBuffer.contentsAsString();
        }
        return _getText2(jsonToken);
    }

    public void _reportInvalidToken(String str) {
        _reportInvalidToken(str, _validJsonTokenList());
    }

    public void _reportInvalidToken(String str, int i) {
        this._inputPtr = i;
        _reportInvalidToken(str, _validJsonTokenList());
    }

    public JsonToken _handleInvalidNumberStart(int i, boolean z10) {
        return _handleInvalidNumberStart(i, z10, false);
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public boolean nextFieldName(SerializableString serializableString) throws JsonParseException {
        int i = 0;
        this._numTypesValid = 0;
        if (this._currToken == JsonToken.FIELD_NAME) {
            _nextAfterName();
            return false;
        }
        if (this._tokenIncomplete) {
            _skipString();
        }
        int i_skipWSOrEnd = _skipWSOrEnd();
        if (i_skipWSOrEnd < 0) {
            close();
            _updateTokenToNull();
            return false;
        }
        this._binaryValue = null;
        if (i_skipWSOrEnd == 93) {
            _closeArrayScope();
            _updateToken(JsonToken.END_ARRAY);
            return false;
        }
        if (i_skipWSOrEnd == 125) {
            _closeObjectScope();
            _updateToken(JsonToken.END_OBJECT);
            return false;
        }
        if (this._parsingContext.expectComma()) {
            if (i_skipWSOrEnd != 44) {
                _reportUnexpectedChar(i_skipWSOrEnd, "was expecting comma to separate " + this._parsingContext.typeDesc() + " entries");
            }
            i_skipWSOrEnd = _skipWS();
            if ((this._features & JsonParserBase.FEAT_MASK_TRAILING_COMMA) != 0 && (i_skipWSOrEnd == 93 || i_skipWSOrEnd == 125)) {
                _closeScope(i_skipWSOrEnd);
                return false;
            }
        }
        if (!this._parsingContext.inObject()) {
            _updateLocation();
            _nextTokenNotInObject(i_skipWSOrEnd);
            return false;
        }
        _updateNameLocation();
        if (i_skipWSOrEnd == 34) {
            byte[] bArrAsQuotedUTF8 = serializableString.asQuotedUTF8();
            int length = bArrAsQuotedUTF8.length;
            int i3 = this._inputPtr;
            if (i3 + length + 4 < this._inputEnd) {
                int i10 = length + i3;
                if (this._inputBuffer[i10] == 34) {
                    while (i3 != i10) {
                        if (bArrAsQuotedUTF8[i] == this._inputBuffer[i3]) {
                            i++;
                            i3++;
                        }
                    }
                    this._parsingContext.setCurrentName(serializableString.getValue());
                    _isNextTokenNameYes(_skipColonFast(i3 + 1));
                    return true;
                }
            }
        }
        return _isNextTokenNameMaybe(i_skipWSOrEnd, serializableString);
    }
}
