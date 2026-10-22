package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.base.GeneratorBase;
import com.fasterxml.jackson.core.base.ParserBase;
import com.fasterxml.jackson.core.internal.shaded.fdp.v2_19_2.FastDoubleMath;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import java.io.DataInput;
import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class UTF8DataInputJsonParser extends JsonParserBase {
    protected DataInput _inputData;
    protected int _nextByte;
    private int _quad1;
    protected int[] _quadBuffer;
    protected final ByteQuadsCanonicalizer _symbols;
    protected boolean _tokenIncomplete;

    public UTF8DataInputJsonParser(IOContext iOContext, int i, DataInput dataInput, ObjectCodec objectCodec, ByteQuadsCanonicalizer byteQuadsCanonicalizer, int i3) {
        super(iOContext, i, objectCodec);
        this._quadBuffer = new int[16];
        this._symbols = byteQuadsCanonicalizer;
        this._inputData = dataInput;
        this._nextByte = i3;
    }

    private final void _checkMatchEnd(String str, int i, int i3) throws IOException {
        char c_decodeCharForError = (char) _decodeCharForError(i3);
        if (Character.isJavaIdentifierPart(c_decodeCharForError)) {
            _reportInvalidToken(c_decodeCharForError, str.substring(0, i));
        }
    }

    private void _closeScope(int i) {
        if (i == 93) {
            if (!this._parsingContext.inArray()) {
                _reportMismatchedEndMarker(i, '}');
            }
            this._parsingContext = this._parsingContext.clearAndGetParent();
            _updateToken(JsonToken.END_ARRAY);
        }
        if (i == 125) {
            if (!this._parsingContext.inObject()) {
                _reportMismatchedEndMarker(i, ']');
            }
            this._parsingContext = this._parsingContext.clearAndGetParent();
            _updateToken(JsonToken.END_OBJECT);
        }
    }

    private final int _decodeUtf8_2(int i) throws IOException {
        int unsignedByte = this._inputData.readUnsignedByte();
        if ((unsignedByte & 192) != 128) {
            _reportInvalidOther(unsignedByte & 255);
        }
        return ((i & 31) << 6) | (unsignedByte & 63);
    }

    private final int _decodeUtf8_3(int i) throws IOException {
        int i3 = i & 15;
        int unsignedByte = this._inputData.readUnsignedByte();
        if ((unsignedByte & 192) != 128) {
            _reportInvalidOther(unsignedByte & 255);
        }
        int i10 = (i3 << 6) | (unsignedByte & 63);
        int unsignedByte2 = this._inputData.readUnsignedByte();
        if ((unsignedByte2 & 192) != 128) {
            _reportInvalidOther(unsignedByte2 & 255);
        }
        return (i10 << 6) | (unsignedByte2 & 63);
    }

    private final int _decodeUtf8_4(int i) throws IOException {
        int unsignedByte = this._inputData.readUnsignedByte();
        if ((unsignedByte & 192) != 128) {
            _reportInvalidOther(unsignedByte & 255);
        }
        int i3 = ((i & 7) << 6) | (unsignedByte & 63);
        int unsignedByte2 = this._inputData.readUnsignedByte();
        if ((unsignedByte2 & 192) != 128) {
            _reportInvalidOther(unsignedByte2 & 255);
        }
        int i10 = (i3 << 6) | (unsignedByte2 & 63);
        int unsignedByte3 = this._inputData.readUnsignedByte();
        if ((unsignedByte3 & 192) != 128) {
            _reportInvalidOther(unsignedByte3 & 255);
        }
        return ((i10 << 6) | (unsignedByte3 & 63)) - 65536;
    }

    private String _finishAndReturnString() throws IOException {
        char[] cArrEmptyAndGetCurrentSegment = this._textBuffer.emptyAndGetCurrentSegment();
        int[] iArr = JsonParserBase.INPUT_CODES_UTF8;
        int length = cArrEmptyAndGetCurrentSegment.length;
        int i = 0;
        while (true) {
            int unsignedByte = this._inputData.readUnsignedByte();
            if (iArr[unsignedByte] != 0) {
                if (unsignedByte == 34) {
                    return this._textBuffer.setCurrentAndReturn(i);
                }
                _finishString2(cArrEmptyAndGetCurrentSegment, i, unsignedByte);
                return this._textBuffer.contentsAsString();
            }
            int i3 = i + 1;
            cArrEmptyAndGetCurrentSegment[i] = (char) unsignedByte;
            if (i3 >= length) {
                _finishString2(cArrEmptyAndGetCurrentSegment, i3, this._inputData.readUnsignedByte());
                return this._textBuffer.contentsAsString();
            }
            i = i3;
        }
    }

    private final void _finishString2(char[] cArr, int i, int i3) throws IOException {
        int[] iArr = JsonParserBase.INPUT_CODES_UTF8;
        int length = cArr.length;
        while (true) {
            int i10 = iArr[i3];
            int i11 = 0;
            if (i10 == 0) {
                if (i >= length) {
                    cArr = this._textBuffer.finishCurrentSegment();
                    length = cArr.length;
                    i = 0;
                }
                cArr[i] = (char) i3;
                i3 = this._inputData.readUnsignedByte();
                i++;
            } else {
                if (i3 == 34) {
                    this._textBuffer.setCurrentLength(i);
                    return;
                }
                if (i10 == 1) {
                    i3 = _decodeEscaped();
                } else if (i10 == 2) {
                    i3 = _decodeUtf8_2(i3);
                } else if (i10 == 3) {
                    i3 = _decodeUtf8_3(i3);
                } else if (i10 == 4) {
                    int i_decodeUtf8_4 = _decodeUtf8_4(i3);
                    if (i >= cArr.length) {
                        cArr = this._textBuffer.finishCurrentSegment();
                        length = cArr.length;
                        i = 0;
                    }
                    cArr[i] = (char) ((i_decodeUtf8_4 >> 10) | GeneratorBase.SURR1_FIRST);
                    i3 = 56320 | (i_decodeUtf8_4 & FastDoubleMath.DOUBLE_EXPONENT_BIAS);
                    i++;
                } else if (i3 < 32) {
                    _throwUnquotedSpace(i3, "string value");
                } else {
                    _reportInvalidChar(i3);
                }
                if (i >= cArr.length) {
                    cArr = this._textBuffer.finishCurrentSegment();
                    length = cArr.length;
                } else {
                    i11 = i;
                }
                i = i11 + 1;
                cArr[i11] = (char) i3;
                i3 = this._inputData.readUnsignedByte();
            }
        }
    }

    private final int _handleLeadingZeroes() throws IOException {
        int unsignedByte = this._inputData.readUnsignedByte();
        if (unsignedByte >= 48 && unsignedByte <= 57) {
            if ((this._features & JsonParserBase.FEAT_MASK_LEADING_ZEROS) == 0) {
                reportInvalidNumber("Leading zeroes not allowed");
            }
            while (unsignedByte == 48) {
                unsignedByte = this._inputData.readUnsignedByte();
            }
        }
        return unsignedByte;
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

    private final JsonToken _nextTokenNotInObject(int i) throws IOException {
        if (i == 34) {
            this._tokenIncomplete = true;
            return _updateToken(JsonToken.VALUE_STRING);
        }
        if (i == 43) {
            return isEnabled(JsonReadFeature.ALLOW_LEADING_PLUS_SIGN_FOR_NUMBERS.mappedFeature()) ? _updateToken(_parsePosNumber()) : _updateToken(_handleUnexpectedValue(i));
        }
        if (i == 91) {
            createChildArrayContext(this._tokenInputRow, this._tokenInputCol);
            return _updateToken(JsonToken.START_ARRAY);
        }
        if (i == 102) {
            _matchToken("false", 1);
            return _updateToken(JsonToken.VALUE_FALSE);
        }
        if (i == 110) {
            _matchToken("null", 1);
            return _updateToken(JsonToken.VALUE_NULL);
        }
        if (i == 116) {
            _matchToken("true", 1);
            return _updateToken(JsonToken.VALUE_TRUE);
        }
        if (i == 123) {
            createChildObjectContext(this._tokenInputRow, this._tokenInputCol);
            return _updateToken(JsonToken.START_OBJECT);
        }
        if (i == 45) {
            return _updateToken(_parseNegNumber());
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

    private final JsonToken _parseFloat(char[] cArr, int i, int i3, boolean z10, int i10) throws IOException {
        int i11;
        int unsignedByte;
        int i12 = 0;
        if (i3 == 46) {
            if (i >= cArr.length) {
                cArr = this._textBuffer.finishCurrentSegment();
                i = 0;
            }
            cArr[i] = (char) i3;
            i++;
            int i13 = 0;
            while (true) {
                unsignedByte = this._inputData.readUnsignedByte();
                if (unsignedByte < 48 || unsignedByte > 57) {
                    break;
                }
                i13++;
                if (i >= cArr.length) {
                    cArr = this._textBuffer.finishCurrentSegment();
                    i = 0;
                }
                cArr[i] = (char) unsignedByte;
                i++;
            }
            if (i13 == 0 && !isEnabled(JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS.mappedFeature())) {
                _reportUnexpectedNumberChar(unsignedByte, "Decimal point not followed by a digit");
            }
            i11 = i13;
            i3 = unsignedByte;
        } else {
            i11 = 0;
        }
        if ((i3 | 32) == 101) {
            if (i >= cArr.length) {
                cArr = this._textBuffer.finishCurrentSegment();
                i = 0;
            }
            int i14 = i + 1;
            cArr[i] = (char) i3;
            int unsignedByte2 = this._inputData.readUnsignedByte();
            if (unsignedByte2 == 45 || unsignedByte2 == 43) {
                if (i14 >= cArr.length) {
                    cArr = this._textBuffer.finishCurrentSegment();
                    i14 = 0;
                }
                cArr[i14] = (char) unsignedByte2;
                unsignedByte2 = this._inputData.readUnsignedByte();
                i14++;
            }
            i3 = unsignedByte2;
            i = i14;
            int i15 = 0;
            while (i3 <= 57 && i3 >= 48) {
                i15++;
                if (i >= cArr.length) {
                    cArr = this._textBuffer.finishCurrentSegment();
                    i = 0;
                }
                cArr[i] = (char) i3;
                i3 = this._inputData.readUnsignedByte();
                i++;
            }
            if (i15 == 0) {
                _reportUnexpectedNumberChar(i3, "Exponent indicator not followed by a digit");
            }
            i12 = i15;
        }
        this._nextByte = i3;
        if (this._parsingContext.inRoot()) {
            _verifyRootSpace();
        }
        this._textBuffer.setCurrentLength(i);
        return resetFloat(z10, i10, i11, i12);
    }

    private final String _parseLongName(int i, int i3, int i10) throws IOException {
        int[] iArr = this._quadBuffer;
        iArr[0] = this._quad1;
        iArr[1] = i3;
        iArr[2] = i10;
        int[] iArr2 = JsonParserBase.INPUT_CODES_LATIN1;
        int i11 = i;
        int i12 = 3;
        while (true) {
            int unsignedByte = this._inputData.readUnsignedByte();
            if (iArr2[unsignedByte] != 0) {
                int[] iArr3 = this._quadBuffer;
                return unsignedByte == 34 ? findName(iArr3, i12, i11, 1) : parseEscapedName(iArr3, i12, i11, unsignedByte, 1);
            }
            int i13 = (i11 << 8) | unsignedByte;
            int unsignedByte2 = this._inputData.readUnsignedByte();
            if (iArr2[unsignedByte2] != 0) {
                int[] iArr4 = this._quadBuffer;
                return unsignedByte2 == 34 ? findName(iArr4, i12, i13, 2) : parseEscapedName(iArr4, i12, i13, unsignedByte2, 2);
            }
            int i14 = (i13 << 8) | unsignedByte2;
            int unsignedByte3 = this._inputData.readUnsignedByte();
            if (iArr2[unsignedByte3] != 0) {
                int[] iArr5 = this._quadBuffer;
                return unsignedByte3 == 34 ? findName(iArr5, i12, i14, 3) : parseEscapedName(iArr5, i12, i14, unsignedByte3, 3);
            }
            int i15 = (i14 << 8) | unsignedByte3;
            int unsignedByte4 = this._inputData.readUnsignedByte();
            if (iArr2[unsignedByte4] != 0) {
                int[] iArr6 = this._quadBuffer;
                return unsignedByte4 == 34 ? findName(iArr6, i12, i15, 4) : parseEscapedName(iArr6, i12, i15, unsignedByte4, 4);
            }
            int[] iArr7 = this._quadBuffer;
            if (i12 >= iArr7.length) {
                this._quadBuffer = ParserBase.growArrayBy(iArr7, i12);
            }
            this._quadBuffer[i12] = i15;
            i12++;
            i11 = unsignedByte4;
        }
    }

    private final String _parseMediumName(int i) throws IOException {
        int[] iArr = JsonParserBase.INPUT_CODES_LATIN1;
        int unsignedByte = this._inputData.readUnsignedByte();
        if (iArr[unsignedByte] != 0) {
            int i3 = this._quad1;
            return unsignedByte == 34 ? findName(i3, i, 1) : parseName(i3, i, unsignedByte, 1);
        }
        int i10 = (i << 8) | unsignedByte;
        int unsignedByte2 = this._inputData.readUnsignedByte();
        if (iArr[unsignedByte2] != 0) {
            int i11 = this._quad1;
            return unsignedByte2 == 34 ? findName(i11, i10, 2) : parseName(i11, i10, unsignedByte2, 2);
        }
        int i12 = (i10 << 8) | unsignedByte2;
        int unsignedByte3 = this._inputData.readUnsignedByte();
        if (iArr[unsignedByte3] != 0) {
            int i13 = this._quad1;
            return unsignedByte3 == 34 ? findName(i13, i12, 3) : parseName(i13, i12, unsignedByte3, 3);
        }
        int i14 = (i12 << 8) | unsignedByte3;
        int unsignedByte4 = this._inputData.readUnsignedByte();
        if (iArr[unsignedByte4] == 0) {
            return _parseMediumName2(unsignedByte4, i14);
        }
        int i15 = this._quad1;
        return unsignedByte4 == 34 ? findName(i15, i14, 4) : parseName(i15, i14, unsignedByte4, 4);
    }

    private final String _parseMediumName2(int i, int i3) throws IOException {
        int[] iArr = JsonParserBase.INPUT_CODES_LATIN1;
        int unsignedByte = this._inputData.readUnsignedByte();
        if (iArr[unsignedByte] != 0) {
            int i10 = this._quad1;
            return unsignedByte == 34 ? findName(i10, i3, i, 1) : parseName(i10, i3, i, unsignedByte, 1);
        }
        int i11 = (i << 8) | unsignedByte;
        int unsignedByte2 = this._inputData.readUnsignedByte();
        if (iArr[unsignedByte2] != 0) {
            int i12 = this._quad1;
            return unsignedByte2 == 34 ? findName(i12, i3, i11, 2) : parseName(i12, i3, i11, unsignedByte2, 2);
        }
        int i13 = (i11 << 8) | unsignedByte2;
        int unsignedByte3 = this._inputData.readUnsignedByte();
        if (iArr[unsignedByte3] != 0) {
            int i14 = this._quad1;
            return unsignedByte3 == 34 ? findName(i14, i3, i13, 3) : parseName(i14, i3, i13, unsignedByte3, 3);
        }
        int i15 = (i13 << 8) | unsignedByte3;
        int unsignedByte4 = this._inputData.readUnsignedByte();
        if (iArr[unsignedByte4] == 0) {
            return _parseLongName(unsignedByte4, i3, i15);
        }
        int i16 = this._quad1;
        return unsignedByte4 == 34 ? findName(i16, i3, i15, 4) : parseName(i16, i3, i15, unsignedByte4, 4);
    }

    private final JsonToken _parseSignedNumber(boolean z10) throws IOException {
        int i;
        int unsignedByte;
        char[] cArrEmptyAndGetCurrentSegment = this._textBuffer.emptyAndGetCurrentSegment();
        if (z10) {
            cArrEmptyAndGetCurrentSegment[0] = '-';
            i = 1;
        } else {
            i = 0;
        }
        int unsignedByte2 = this._inputData.readUnsignedByte();
        int i3 = i + 1;
        cArrEmptyAndGetCurrentSegment[i] = (char) unsignedByte2;
        if (unsignedByte2 <= 48) {
            if (unsignedByte2 != 48) {
                return unsignedByte2 == 46 ? _parseFloatThatStartsWithPeriod(z10, true) : _handleInvalidNumberStart(unsignedByte2, z10, true);
            }
            unsignedByte = _handleLeadingZeroes();
        } else {
            if (unsignedByte2 > 57) {
                return _handleInvalidNumberStart(unsignedByte2, z10, true);
            }
            unsignedByte = this._inputData.readUnsignedByte();
        }
        char[] cArrFinishCurrentSegment = cArrEmptyAndGetCurrentSegment;
        int i10 = 1;
        int unsignedByte3 = unsignedByte;
        int i11 = i3;
        while (unsignedByte3 <= 57 && unsignedByte3 >= 48) {
            i10++;
            if (i11 >= cArrFinishCurrentSegment.length) {
                cArrFinishCurrentSegment = this._textBuffer.finishCurrentSegment();
                i11 = 0;
            }
            cArrFinishCurrentSegment[i11] = (char) unsignedByte3;
            unsignedByte3 = this._inputData.readUnsignedByte();
            i11++;
        }
        if (unsignedByte3 == 46 || (unsignedByte3 | 32) == 101) {
            return _parseFloat(cArrFinishCurrentSegment, i11, unsignedByte3, z10, i10);
        }
        this._textBuffer.setCurrentLength(i11);
        this._nextByte = unsignedByte3;
        if (this._parsingContext.inRoot()) {
            _verifyRootSpace();
        }
        return resetInt(z10, i10);
    }

    private void _reportInvalidOther(int i) {
        _reportError("Invalid UTF-8 middle byte 0x" + Integer.toHexString(i));
    }

    private final void _skipCComment() throws IOException {
        int[] inputCodeComment = CharTypes.getInputCodeComment();
        int unsignedByte = this._inputData.readUnsignedByte();
        while (true) {
            int i = inputCodeComment[unsignedByte];
            if (i != 0) {
                if (i == 2) {
                    _skipUtf8_2();
                } else if (i == 3) {
                    _skipUtf8_3();
                } else if (i == 4) {
                    _skipUtf8_4();
                } else if (i == 10 || i == 13) {
                    this._currInputRow++;
                } else if (i != 42) {
                    _reportInvalidChar(unsignedByte);
                } else {
                    unsignedByte = this._inputData.readUnsignedByte();
                    if (unsignedByte == 47) {
                        return;
                    }
                }
            }
            unsignedByte = this._inputData.readUnsignedByte();
        }
    }

    private final int _skipColon() throws IOException {
        int unsignedByte = this._nextByte;
        if (unsignedByte < 0) {
            unsignedByte = this._inputData.readUnsignedByte();
        } else {
            this._nextByte = -1;
        }
        if (unsignedByte == 58) {
            int unsignedByte2 = this._inputData.readUnsignedByte();
            return unsignedByte2 > 32 ? (unsignedByte2 == 47 || unsignedByte2 == 35) ? _skipColon2(unsignedByte2, true) : unsignedByte2 : ((unsignedByte2 == 32 || unsignedByte2 == 9) && (unsignedByte2 = this._inputData.readUnsignedByte()) > 32) ? (unsignedByte2 == 47 || unsignedByte2 == 35) ? _skipColon2(unsignedByte2, true) : unsignedByte2 : _skipColon2(unsignedByte2, true);
        }
        if (unsignedByte == 32 || unsignedByte == 9) {
            unsignedByte = this._inputData.readUnsignedByte();
        }
        if (unsignedByte != 58) {
            return _skipColon2(unsignedByte, false);
        }
        int unsignedByte3 = this._inputData.readUnsignedByte();
        return unsignedByte3 > 32 ? (unsignedByte3 == 47 || unsignedByte3 == 35) ? _skipColon2(unsignedByte3, true) : unsignedByte3 : ((unsignedByte3 == 32 || unsignedByte3 == 9) && (unsignedByte3 = this._inputData.readUnsignedByte()) > 32) ? (unsignedByte3 == 47 || unsignedByte3 == 35) ? _skipColon2(unsignedByte3, true) : unsignedByte3 : _skipColon2(unsignedByte3, true);
    }

    private final int _skipColon2(int i, boolean z10) throws IOException {
        while (true) {
            if (i > 32) {
                if (i == 47) {
                    _skipComment();
                } else if (i != 35 || !_skipYAMLComment()) {
                    if (z10) {
                        return i;
                    }
                    if (i != 58) {
                        _reportUnexpectedChar(i, "was expecting a colon to separate field name and value");
                    }
                    z10 = true;
                }
            } else if (i == 13 || i == 10) {
                this._currInputRow++;
            }
            i = this._inputData.readUnsignedByte();
        }
    }

    private final void _skipComment() throws IOException {
        if ((this._features & JsonParserBase.FEAT_MASK_ALLOW_JAVA_COMMENTS) == 0) {
            _reportUnexpectedChar(47, "maybe a (non-standard) comment? (not recognized as one since Feature 'ALLOW_COMMENTS' not enabled for parser)");
        }
        int unsignedByte = this._inputData.readUnsignedByte();
        if (unsignedByte == 47) {
            _skipLine();
        } else if (unsignedByte == 42) {
            _skipCComment();
        } else {
            _reportUnexpectedChar(unsignedByte, "was expecting either '*' or '/' for a comment");
        }
    }

    private final void _skipLine() throws IOException {
        int[] inputCodeComment = CharTypes.getInputCodeComment();
        while (true) {
            int unsignedByte = this._inputData.readUnsignedByte();
            int i = inputCodeComment[unsignedByte];
            if (i != 0) {
                if (i == 2) {
                    _skipUtf8_2();
                } else if (i == 3) {
                    _skipUtf8_3();
                } else if (i == 4) {
                    _skipUtf8_4();
                } else if (i == 10 || i == 13) {
                    break;
                } else if (i != 42 && i < 0) {
                    _reportInvalidChar(unsignedByte);
                }
            }
        }
        this._currInputRow++;
    }

    private final void _skipUtf8_2() throws IOException {
        int unsignedByte = this._inputData.readUnsignedByte();
        if ((unsignedByte & 192) != 128) {
            _reportInvalidOther(unsignedByte & 255);
        }
    }

    private final void _skipUtf8_3() throws IOException {
        int unsignedByte = this._inputData.readUnsignedByte();
        if ((unsignedByte & 192) != 128) {
            _reportInvalidOther(unsignedByte & 255);
        }
        int unsignedByte2 = this._inputData.readUnsignedByte();
        if ((unsignedByte2 & 192) != 128) {
            _reportInvalidOther(unsignedByte2 & 255);
        }
    }

    private final void _skipUtf8_4() throws IOException {
        int unsignedByte = this._inputData.readUnsignedByte();
        if ((unsignedByte & 192) != 128) {
            _reportInvalidOther(unsignedByte & 255);
        }
        int unsignedByte2 = this._inputData.readUnsignedByte();
        if ((unsignedByte2 & 192) != 128) {
            _reportInvalidOther(unsignedByte2 & 255);
        }
        int unsignedByte3 = this._inputData.readUnsignedByte();
        if ((unsignedByte3 & 192) != 128) {
            _reportInvalidOther(unsignedByte3 & 255);
        }
    }

    private final int _skipWS() throws IOException {
        int unsignedByte = this._nextByte;
        if (unsignedByte < 0) {
            unsignedByte = this._inputData.readUnsignedByte();
        } else {
            this._nextByte = -1;
        }
        while (unsignedByte <= 32) {
            if (unsignedByte == 13 || unsignedByte == 10) {
                this._currInputRow++;
            }
            unsignedByte = this._inputData.readUnsignedByte();
        }
        return (unsignedByte == 47 || unsignedByte == 35) ? _skipWSComment(unsignedByte) : unsignedByte;
    }

    private final int _skipWSComment(int i) throws IOException {
        while (true) {
            if (i > 32) {
                if (i == 47) {
                    _skipComment();
                } else if (i != 35 || !_skipYAMLComment()) {
                    break;
                }
            } else if (i == 13 || i == 10) {
                this._currInputRow++;
            }
            i = this._inputData.readUnsignedByte();
        }
        return i;
    }

    private final int _skipWSOrEnd() throws IOException {
        int unsignedByte = this._nextByte;
        if (unsignedByte < 0) {
            try {
                unsignedByte = this._inputData.readUnsignedByte();
            } catch (EOFException unused) {
                return _eofAsNextChar();
            }
        } else {
            this._nextByte = -1;
        }
        while (unsignedByte <= 32) {
            if (unsignedByte == 13 || unsignedByte == 10) {
                this._currInputRow++;
            }
            try {
                unsignedByte = this._inputData.readUnsignedByte();
            } catch (EOFException unused2) {
                return _eofAsNextChar();
            }
        }
        return (unsignedByte == 47 || unsignedByte == 35) ? _skipWSComment(unsignedByte) : unsignedByte;
    }

    private final boolean _skipYAMLComment() throws IOException {
        if ((this._features & JsonParserBase.FEAT_MASK_ALLOW_YAML_COMMENTS) == 0) {
            return false;
        }
        _skipLine();
        return true;
    }

    private final void _verifyRootSpace() {
        int i = this._nextByte;
        if (i > 32) {
            _reportMissingRootWS(i);
            return;
        }
        this._nextByte = -1;
        if (i == 13 || i == 10) {
            this._currInputRow++;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00c8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.String addName(int[] r18, int r19, int r20) {
        /*
            Method dump skipped, instructions count: 286
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.UTF8DataInputJsonParser.addName(int[], int, int):java.lang.String");
    }

    private final String findName(int i, int i3, int i10, int i11) {
        int iPad = pad(i10, i11);
        String strFindName = this._symbols.findName(i, i3, iPad);
        if (strFindName != null) {
            return strFindName;
        }
        int[] iArr = this._quadBuffer;
        iArr[0] = i;
        iArr[1] = i3;
        iArr[2] = pad(iPad, i11);
        return addName(iArr, 3, i11);
    }

    private static final int pad(int i, int i3) {
        return i3 == 4 ? i : i | ((-1) << (i3 << 3));
    }

    private final String parseName(int i, int i3, int i10, int i11) {
        int[] iArr = this._quadBuffer;
        iArr[0] = i;
        return parseEscapedName(iArr, 1, i3, i10, i11);
    }

    @Override // com.fasterxml.jackson.core.json.JsonParserBase, com.fasterxml.jackson.core.base.ParserMinimalBase
    public JsonLocation _currentLocationMinusOne() {
        return currentLocation();
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0097, code lost:
    
        throw reportInvalidBase64Char(r9, r2, 3, "expected padding character '" + r9.getPaddingChar() + "'");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final byte[] _decodeBase64(com.fasterxml.jackson.core.Base64Variant r9) throws java.io.IOException {
        /*
            r8 = this;
            com.fasterxml.jackson.core.util.ByteArrayBuilder r0 = r8._getByteArrayBuilder()
        L4:
            java.io.DataInput r1 = r8._inputData
            int r1 = r1.readUnsignedByte()
            r2 = 32
            if (r1 <= r2) goto L4
            int r2 = r9.decodeBase64Char(r1)
            r3 = 34
            if (r2 >= 0) goto L25
            if (r1 != r3) goto L1d
            byte[] r8 = r0.toByteArray()
            return r8
        L1d:
            r2 = 0
            int r2 = r8._decodeBase64Escape(r9, r1, r2)
            if (r2 >= 0) goto L25
            goto L4
        L25:
            java.io.DataInput r1 = r8._inputData
            int r1 = r1.readUnsignedByte()
            int r4 = r9.decodeBase64Char(r1)
            if (r4 >= 0) goto L36
            r4 = 1
            int r4 = r8._decodeBase64Escape(r9, r1, r4)
        L36:
            int r1 = r2 << 6
            r1 = r1 | r4
            java.io.DataInput r2 = r8._inputData
            int r2 = r2.readUnsignedByte()
            int r4 = r9.decodeBase64Char(r2)
            r5 = 3
            r6 = 2
            r7 = -2
            if (r4 >= 0) goto L9f
            if (r4 == r7) goto L63
            if (r2 != r3) goto L5f
            int r1 = r1 >> 4
            r0.append(r1)
            boolean r1 = r9.requiresPaddingOnRead()
            if (r1 == 0) goto L5a
            r8._handleBase64MissingPadding(r9)
        L5a:
            byte[] r8 = r0.toByteArray()
            return r8
        L5f:
            int r4 = r8._decodeBase64Escape(r9, r2, r6)
        L63:
            if (r4 != r7) goto L9f
            java.io.DataInput r2 = r8._inputData
            int r2 = r2.readUnsignedByte()
            boolean r3 = r9.usesPaddingChar(r2)
            if (r3 != 0) goto L98
            r3 = 92
            if (r2 != r3) goto L7c
            int r3 = r8._decodeBase64Escape(r9, r2, r5)
            if (r3 != r7) goto L7c
            goto L98
        L7c:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "expected padding character '"
            r0.<init>(r1)
            char r1 = r9.getPaddingChar()
            r0.append(r1)
            java.lang.String r1 = "'"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalArgumentException r8 = r8.reportInvalidBase64Char(r9, r2, r5, r0)
            throw r8
        L98:
            int r1 = r1 >> 4
            r0.append(r1)
            goto L4
        L9f:
            int r1 = r1 << 6
            r1 = r1 | r4
            java.io.DataInput r2 = r8._inputData
            int r2 = r2.readUnsignedByte()
            int r4 = r9.decodeBase64Char(r2)
            if (r4 >= 0) goto Ld1
            if (r4 == r7) goto Lc8
            if (r2 != r3) goto Lc4
            int r1 = r1 >> r6
            r0.appendTwoBytes(r1)
            boolean r1 = r9.requiresPaddingOnRead()
            if (r1 == 0) goto Lbf
            r8._handleBase64MissingPadding(r9)
        Lbf:
            byte[] r8 = r0.toByteArray()
            return r8
        Lc4:
            int r4 = r8._decodeBase64Escape(r9, r2, r5)
        Lc8:
            if (r4 != r7) goto Ld1
            int r1 = r1 >> 2
            r0.appendTwoBytes(r1)
            goto L4
        Ld1:
            int r1 = r1 << 6
            r1 = r1 | r4
            r0.appendThreeBytes(r1)
            goto L4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.UTF8DataInputJsonParser._decodeBase64(com.fasterxml.jackson.core.Base64Variant):byte[]");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int _decodeCharForError(int r7) throws java.io.IOException {
        /*
            r6 = this;
            r0 = r7 & 255(0xff, float:3.57E-43)
            r1 = 127(0x7f, float:1.78E-43)
            if (r0 <= r1) goto L6f
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
            java.io.DataInput r1 = r6._inputData
            int r1 = r1.readUnsignedByte()
            r4 = r1 & 192(0xc0, float:2.69E-43)
            r5 = 128(0x80, float:1.8E-43)
            if (r4 == r5) goto L3d
            r4 = r1 & 255(0xff, float:3.57E-43)
            r6._reportInvalidOther(r4)
        L3d:
            int r0 = r0 << 6
            r1 = r1 & 63
            r0 = r0 | r1
            if (r7 <= r3) goto L6f
            java.io.DataInput r1 = r6._inputData
            int r1 = r1.readUnsignedByte()
            r3 = r1 & 192(0xc0, float:2.69E-43)
            if (r3 == r5) goto L53
            r3 = r1 & 255(0xff, float:3.57E-43)
            r6._reportInvalidOther(r3)
        L53:
            int r0 = r0 << 6
            r1 = r1 & 63
            r0 = r0 | r1
            if (r7 <= r2) goto L6f
            java.io.DataInput r7 = r6._inputData
            int r7 = r7.readUnsignedByte()
            r1 = r7 & 192(0xc0, float:2.69E-43)
            if (r1 == r5) goto L69
            r1 = r7 & 255(0xff, float:3.57E-43)
            r6._reportInvalidOther(r1)
        L69:
            int r6 = r0 << 6
            r7 = r7 & 63
            r6 = r6 | r7
            return r6
        L6f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.UTF8DataInputJsonParser._decodeCharForError(int):int");
    }

    @Override // com.fasterxml.jackson.core.base.ParserBase
    public char _decodeEscaped() throws IOException {
        int unsignedByte = this._inputData.readUnsignedByte();
        if (unsignedByte == 34 || unsignedByte == 47 || unsignedByte == 92) {
            return (char) unsignedByte;
        }
        if (unsignedByte == 98) {
            return '\b';
        }
        if (unsignedByte == 102) {
            return '\f';
        }
        if (unsignedByte == 110) {
            return '\n';
        }
        if (unsignedByte == 114) {
            return '\r';
        }
        if (unsignedByte == 116) {
            return '\t';
        }
        if (unsignedByte != 117) {
            return _handleUnrecognizedCharacterEscape((char) _decodeCharForError(unsignedByte));
        }
        int i = 0;
        for (int i3 = 0; i3 < 4; i3++) {
            int unsignedByte2 = this._inputData.readUnsignedByte();
            int iCharToHex = CharTypes.charToHex(unsignedByte2);
            if (iCharToHex < 0) {
                _reportUnexpectedChar(unsignedByte2, "expected a hex-digit for character escape sequence");
            }
            i = (i << 4) | iCharToHex;
        }
        return (char) i;
    }

    @Override // com.fasterxml.jackson.core.base.ParserBase
    public void _finishString() throws IOException {
        char[] cArrEmptyAndGetCurrentSegment = this._textBuffer.emptyAndGetCurrentSegment();
        int[] iArr = JsonParserBase.INPUT_CODES_UTF8;
        int length = cArrEmptyAndGetCurrentSegment.length;
        int i = 0;
        while (true) {
            int unsignedByte = this._inputData.readUnsignedByte();
            if (iArr[unsignedByte] != 0) {
                if (unsignedByte == 34) {
                    this._textBuffer.setCurrentLength(i);
                    return;
                } else {
                    _finishString2(cArrEmptyAndGetCurrentSegment, i, unsignedByte);
                    return;
                }
            }
            int i3 = i + 1;
            cArrEmptyAndGetCurrentSegment[i] = (char) unsignedByte;
            if (i3 >= length) {
                _finishString2(cArrEmptyAndGetCurrentSegment, i3, this._inputData.readUnsignedByte());
                return;
            }
            i = i3;
        }
    }

    public final String _getText2(JsonToken jsonToken) {
        if (jsonToken == null) {
            return null;
        }
        int iId = jsonToken.id();
        return iId != 5 ? (iId == 6 || iId == 7 || iId == 8) ? this._textBuffer.contentsAsString() : jsonToken.asString() : this._parsingContext.getCurrentName();
    }

    public JsonToken _handleApos() throws IOException {
        char[] cArrEmptyAndGetCurrentSegment = this._textBuffer.emptyAndGetCurrentSegment();
        int[] iArr = JsonParserBase.INPUT_CODES_UTF8;
        int i = 0;
        while (true) {
            int length = cArrEmptyAndGetCurrentSegment.length;
            if (i >= cArrEmptyAndGetCurrentSegment.length) {
                cArrEmptyAndGetCurrentSegment = this._textBuffer.finishCurrentSegment();
                length = cArrEmptyAndGetCurrentSegment.length;
                i = 0;
            }
            while (true) {
                int unsignedByte = this._inputData.readUnsignedByte();
                if (unsignedByte == 39) {
                    this._textBuffer.setCurrentLength(i);
                    return JsonToken.VALUE_STRING;
                }
                int i3 = iArr[unsignedByte];
                if (i3 == 0 || unsignedByte == 34) {
                    int i10 = i + 1;
                    cArrEmptyAndGetCurrentSegment[i] = (char) unsignedByte;
                    i = i10;
                    if (i10 >= length) {
                        break;
                    }
                } else {
                    if (i3 == 1) {
                        unsignedByte = _decodeEscaped();
                    } else if (i3 == 2) {
                        unsignedByte = _decodeUtf8_2(unsignedByte);
                    } else if (i3 == 3) {
                        unsignedByte = _decodeUtf8_3(unsignedByte);
                    } else if (i3 != 4) {
                        if (unsignedByte < 32) {
                            _throwUnquotedSpace(unsignedByte, "string value");
                        }
                        _reportInvalidChar(unsignedByte);
                    } else {
                        int i_decodeUtf8_4 = _decodeUtf8_4(unsignedByte);
                        int i11 = i + 1;
                        cArrEmptyAndGetCurrentSegment[i] = (char) ((i_decodeUtf8_4 >> 10) | GeneratorBase.SURR1_FIRST);
                        if (i11 >= cArrEmptyAndGetCurrentSegment.length) {
                            cArrEmptyAndGetCurrentSegment = this._textBuffer.finishCurrentSegment();
                            i = 0;
                        } else {
                            i = i11;
                        }
                        unsignedByte = 56320 | (i_decodeUtf8_4 & FastDoubleMath.DOUBLE_EXPONENT_BIAS);
                    }
                    if (i >= cArrEmptyAndGetCurrentSegment.length) {
                        cArrEmptyAndGetCurrentSegment = this._textBuffer.finishCurrentSegment();
                        i = 0;
                    }
                    cArrEmptyAndGetCurrentSegment[i] = (char) unsignedByte;
                    i++;
                }
            }
        }
    }

    public JsonToken _handleInvalidNumberStart(int i, boolean z10, boolean z11) throws IOException {
        String str;
        while (i == 73) {
            i = this._inputData.readUnsignedByte();
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
            _reportError("Non-standard token '" + str + "': enable `JsonReadFeature.ALLOW_NON_NUMERIC_NUMBERS` to allow");
        }
        if (!isEnabled(JsonReadFeature.ALLOW_LEADING_PLUS_SIGN_FOR_NUMBERS.mappedFeature()) && z11 && !z10) {
            _reportUnexpectedNumberChar(43, "JSON spec does not allow numbers to have plus signs: enable `JsonReadFeature.ALLOW_LEADING_PLUS_SIGN_FOR_NUMBERS` to allow");
        }
        _reportUnexpectedNumberChar(i, z10 ? "expected digit (0-9) to follow minus sign, for valid numeric value" : "expected digit (0-9) for valid numeric value");
        return null;
    }

    public String _handleOddName(int i) throws IOException {
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
        int[] iArrGrowArrayBy = this._quadBuffer;
        int i3 = 0;
        int i10 = 0;
        int i11 = 0;
        do {
            if (i3 < 4) {
                i3++;
                i |= i11 << 8;
            } else {
                if (i10 >= iArrGrowArrayBy.length) {
                    iArrGrowArrayBy = ParserBase.growArrayBy(iArrGrowArrayBy, iArrGrowArrayBy.length);
                    this._quadBuffer = iArrGrowArrayBy;
                }
                iArrGrowArrayBy[i10] = i11;
                i10++;
                i3 = 1;
            }
            i11 = i;
            i = this._inputData.readUnsignedByte();
        } while (inputCodeUtf8JsNames[i] == 0);
        this._nextByte = i;
        if (i3 > 0) {
            if (i10 >= iArrGrowArrayBy.length) {
                iArrGrowArrayBy = ParserBase.growArrayBy(iArrGrowArrayBy, iArrGrowArrayBy.length);
                this._quadBuffer = iArrGrowArrayBy;
            }
            iArrGrowArrayBy[i10] = i11;
            i10++;
        }
        String strFindName = this._symbols.findName(iArrGrowArrayBy, i10);
        return strFindName == null ? addName(iArrGrowArrayBy, i10, i3) : strFindName;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x001b, code lost:
    
        if (r4 != 44) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0030, code lost:
    
        if (r3._parsingContext.inArray() == false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0039, code lost:
    
        if (r3._parsingContext.inRoot() != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0040, code lost:
    
        if ((r3._features & com.fasterxml.jackson.core.json.JsonParserBase.FEAT_MASK_ALLOW_MISSING) == 0) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0042, code lost:
    
        r3._nextByte = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0046, code lost:
    
        return com.fasterxml.jackson.core.JsonToken.VALUE_NULL;
     */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0086  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.fasterxml.jackson.core.JsonToken _handleUnexpectedValue(int r4) throws java.io.IOException {
        /*
            r3 = this;
            r0 = 39
            if (r4 == r0) goto L7f
            r0 = 73
            r1 = 1
            if (r4 == r0) goto L66
            r0 = 78
            if (r4 == r0) goto L4d
            r0 = 93
            if (r4 == r0) goto L2a
            r0 = 125(0x7d, float:1.75E-43)
            if (r4 == r0) goto L47
            r0 = 43
            if (r4 == r0) goto L1e
            r0 = 44
            if (r4 == r0) goto L33
            goto L8b
        L1e:
            java.io.DataInput r4 = r3._inputData
            int r4 = r4.readUnsignedByte()
            r0 = 0
            com.fasterxml.jackson.core.JsonToken r3 = r3._handleInvalidNumberStart(r4, r0, r1)
            return r3
        L2a:
            com.fasterxml.jackson.core.json.JsonReadContext r0 = r3._parsingContext
            boolean r0 = r0.inArray()
            if (r0 != 0) goto L33
            goto L8b
        L33:
            com.fasterxml.jackson.core.json.JsonReadContext r0 = r3._parsingContext
            boolean r0 = r0.inRoot()
            if (r0 != 0) goto L47
            int r0 = r3._features
            int r1 = com.fasterxml.jackson.core.json.JsonParserBase.FEAT_MASK_ALLOW_MISSING
            r0 = r0 & r1
            if (r0 == 0) goto L47
            r3._nextByte = r4
            com.fasterxml.jackson.core.JsonToken r3 = com.fasterxml.jackson.core.JsonToken.VALUE_NULL
            return r3
        L47:
            java.lang.String r0 = "expected a value"
            r3._reportUnexpectedChar(r4, r0)
            goto L7f
        L4d:
            java.lang.String r0 = "NaN"
            r3._matchToken(r0, r1)
            int r1 = r3._features
            int r2 = com.fasterxml.jackson.core.json.JsonParserBase.FEAT_MASK_NON_NUM_NUMBERS
            r1 = r1 & r2
            if (r1 == 0) goto L60
            r1 = 9221120237041090560(0x7ff8000000000000, double:NaN)
            com.fasterxml.jackson.core.JsonToken r3 = r3.resetAsNaN(r0, r1)
            return r3
        L60:
            java.lang.String r0 = "Non-standard token 'NaN': enable `JsonReadFeature.ALLOW_NON_NUMERIC_NUMBERS` to allow"
            r3._reportError(r0)
            goto L8b
        L66:
            java.lang.String r0 = "Infinity"
            r3._matchToken(r0, r1)
            int r1 = r3._features
            int r2 = com.fasterxml.jackson.core.json.JsonParserBase.FEAT_MASK_NON_NUM_NUMBERS
            r1 = r1 & r2
            if (r1 == 0) goto L79
            r1 = 9218868437227405312(0x7ff0000000000000, double:Infinity)
            com.fasterxml.jackson.core.JsonToken r3 = r3.resetAsNaN(r0, r1)
            return r3
        L79:
            java.lang.String r0 = "Non-standard token 'Infinity': enable `JsonReadFeature.ALLOW_NON_NUMERIC_NUMBERS` to allow"
            r3._reportError(r0)
            goto L8b
        L7f:
            int r0 = r3._features
            int r1 = com.fasterxml.jackson.core.json.JsonParserBase.FEAT_MASK_ALLOW_SINGLE_QUOTES
            r0 = r0 & r1
            if (r0 == 0) goto L8b
            com.fasterxml.jackson.core.JsonToken r3 = r3._handleApos()
            return r3
        L8b:
            boolean r0 = java.lang.Character.isJavaIdentifierStart(r4)
            if (r0 == 0) goto La7
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = ""
            r0.<init>(r1)
            char r1 = (char) r4
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = r3._validJsonTokenList()
            r3._reportInvalidToken(r4, r0, r1)
        La7:
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
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.UTF8DataInputJsonParser._handleUnexpectedValue(int):com.fasterxml.jackson.core.JsonToken");
    }

    public final void _matchToken(String str, int i) throws IOException {
        int length = str.length();
        do {
            int unsignedByte = this._inputData.readUnsignedByte();
            if (unsignedByte != str.charAt(i)) {
                _reportInvalidToken(unsignedByte, str.substring(0, i));
            }
            i++;
        } while (i < length);
        int unsignedByte2 = this._inputData.readUnsignedByte();
        if (unsignedByte2 >= 48 && unsignedByte2 != 93 && unsignedByte2 != 125) {
            _checkMatchEnd(str, i, unsignedByte2);
        }
        this._nextByte = unsignedByte2;
    }

    public String _parseAposName() throws IOException {
        int unsignedByte = this._inputData.readUnsignedByte();
        if (unsignedByte == 39) {
            return "";
        }
        int[] iArrGrowArrayBy = this._quadBuffer;
        int[] iArr = JsonParserBase.INPUT_CODES_LATIN1;
        int i = 0;
        int i3 = 0;
        int i10 = 0;
        while (unsignedByte != 39) {
            if (unsignedByte != 34 && iArr[unsignedByte] != 0) {
                if (unsignedByte != 92) {
                    _throwUnquotedSpace(unsignedByte, "name");
                } else {
                    unsignedByte = _decodeEscaped();
                }
                if (unsignedByte > 127) {
                    if (i >= 4) {
                        if (i3 >= iArrGrowArrayBy.length) {
                            iArrGrowArrayBy = ParserBase.growArrayBy(iArrGrowArrayBy, iArrGrowArrayBy.length);
                            this._quadBuffer = iArrGrowArrayBy;
                        }
                        iArrGrowArrayBy[i3] = i10;
                        i10 = 0;
                        i3++;
                        i = 0;
                    }
                    if (unsignedByte < 2048) {
                        i10 = (i10 << 8) | (unsignedByte >> 6) | 192;
                        i++;
                    } else {
                        int i11 = (i10 << 8) | (unsignedByte >> 12) | 224;
                        int i12 = i + 1;
                        if (i12 >= 4) {
                            if (i3 >= iArrGrowArrayBy.length) {
                                iArrGrowArrayBy = ParserBase.growArrayBy(iArrGrowArrayBy, iArrGrowArrayBy.length);
                                this._quadBuffer = iArrGrowArrayBy;
                            }
                            iArrGrowArrayBy[i3] = i11;
                            i11 = 0;
                            i3++;
                            i12 = 0;
                        }
                        i10 = (i11 << 8) | ((unsignedByte >> 6) & 63) | 128;
                        i = i12 + 1;
                    }
                    unsignedByte = (unsignedByte & 63) | 128;
                }
            }
            if (i < 4) {
                i++;
                unsignedByte |= i10 << 8;
            } else {
                if (i3 >= iArrGrowArrayBy.length) {
                    iArrGrowArrayBy = ParserBase.growArrayBy(iArrGrowArrayBy, iArrGrowArrayBy.length);
                    this._quadBuffer = iArrGrowArrayBy;
                }
                iArrGrowArrayBy[i3] = i10;
                i3++;
                i = 1;
            }
            i10 = unsignedByte;
            unsignedByte = this._inputData.readUnsignedByte();
        }
        if (i > 0) {
            if (i3 >= iArrGrowArrayBy.length) {
                iArrGrowArrayBy = ParserBase.growArrayBy(iArrGrowArrayBy, iArrGrowArrayBy.length);
                this._quadBuffer = iArrGrowArrayBy;
            }
            iArrGrowArrayBy[i3] = pad(i10, i);
            i3++;
        }
        String strFindName = this._symbols.findName(iArrGrowArrayBy, i3);
        return strFindName == null ? addName(iArrGrowArrayBy, i3, i) : strFindName;
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

    public final String _parseName(int i) throws IOException {
        if (i != 34) {
            return _handleOddName(i);
        }
        int[] iArr = JsonParserBase.INPUT_CODES_LATIN1;
        int unsignedByte = this._inputData.readUnsignedByte();
        if (iArr[unsignedByte] != 0) {
            return unsignedByte == 34 ? "" : parseName(0, unsignedByte, 0);
        }
        int unsignedByte2 = this._inputData.readUnsignedByte();
        if (iArr[unsignedByte2] != 0) {
            return unsignedByte2 == 34 ? findName(unsignedByte, 1) : parseName(unsignedByte, unsignedByte2, 1);
        }
        int i3 = (unsignedByte << 8) | unsignedByte2;
        int unsignedByte3 = this._inputData.readUnsignedByte();
        if (iArr[unsignedByte3] != 0) {
            return unsignedByte3 == 34 ? findName(i3, 2) : parseName(i3, unsignedByte3, 2);
        }
        int i10 = (i3 << 8) | unsignedByte3;
        int unsignedByte4 = this._inputData.readUnsignedByte();
        if (iArr[unsignedByte4] != 0) {
            return unsignedByte4 == 34 ? findName(i10, 3) : parseName(i10, unsignedByte4, 3);
        }
        int i11 = (i10 << 8) | unsignedByte4;
        int unsignedByte5 = this._inputData.readUnsignedByte();
        if (iArr[unsignedByte5] != 0) {
            return unsignedByte5 == 34 ? findName(i11, 4) : parseName(i11, unsignedByte5, 4);
        }
        this._quad1 = i11;
        return _parseMediumName(unsignedByte5);
    }

    public final JsonToken _parseNegNumber() {
        return _parseSignedNumber(true);
    }

    public final JsonToken _parsePosNumber() {
        return _parseSignedNumber(false);
    }

    public JsonToken _parseUnsignedNumber(int i) throws IOException {
        int unsignedByte;
        char[] cArrEmptyAndGetCurrentSegment = this._textBuffer.emptyAndGetCurrentSegment();
        int i3 = 1;
        if (i == 48) {
            unsignedByte = _handleLeadingZeroes();
            if (unsignedByte <= 57 && unsignedByte >= 48) {
                i3 = 0;
            } else {
                if (unsignedByte == 120 || unsignedByte == 88) {
                    return _handleInvalidNumberStart(unsignedByte, false);
                }
                cArrEmptyAndGetCurrentSegment[0] = '0';
            }
        } else {
            cArrEmptyAndGetCurrentSegment[0] = (char) i;
            unsignedByte = this._inputData.readUnsignedByte();
        }
        int unsignedByte2 = unsignedByte;
        char[] cArrFinishCurrentSegment = cArrEmptyAndGetCurrentSegment;
        int i10 = i3;
        int i11 = i10;
        while (unsignedByte2 <= 57 && unsignedByte2 >= 48) {
            i11++;
            if (i10 >= cArrFinishCurrentSegment.length) {
                cArrFinishCurrentSegment = this._textBuffer.finishCurrentSegment();
                i10 = 0;
            }
            cArrFinishCurrentSegment[i10] = (char) unsignedByte2;
            unsignedByte2 = this._inputData.readUnsignedByte();
            i10++;
        }
        if (unsignedByte2 == 46 || (unsignedByte2 | 32) == 101) {
            return _parseFloat(cArrFinishCurrentSegment, i10, unsignedByte2, false, i11);
        }
        this._textBuffer.setCurrentLength(i10);
        this._nextByte = unsignedByte2;
        if (this._parsingContext.inRoot()) {
            _verifyRootSpace();
        }
        return resetInt(false, i11);
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x009a, code lost:
    
        throw reportInvalidBase64Char(r12, r6, 3, "expected padding character '" + r12.getPaddingChar() + "'");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int _readBinary(com.fasterxml.jackson.core.Base64Variant r12, java.io.OutputStream r13, byte[] r14) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 261
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.UTF8DataInputJsonParser._readBinary(com.fasterxml.jackson.core.Base64Variant, java.io.OutputStream, byte[]):int");
    }

    @Override // com.fasterxml.jackson.core.base.ParserBase
    public void _releaseBuffers() {
        super._releaseBuffers();
        this._symbols.release();
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

    public void _reportInvalidToken(int i, String str, String str2) throws IOException {
        StringBuilder sb2 = new StringBuilder(str);
        while (true) {
            char c_decodeCharForError = (char) _decodeCharForError(i);
            if (!Character.isJavaIdentifierPart(c_decodeCharForError)) {
                _reportError("Unrecognized token '" + sb2.toString() + "': was expecting " + str2);
                return;
            }
            sb2.append(c_decodeCharForError);
            i = this._inputData.readUnsignedByte();
        }
    }

    public void _skipString() throws IOException {
        this._tokenIncomplete = false;
        int[] iArr = JsonParserBase.INPUT_CODES_UTF8;
        while (true) {
            int unsignedByte = this._inputData.readUnsignedByte();
            int i = iArr[unsignedByte];
            if (i != 0) {
                if (unsignedByte == 34) {
                    return;
                }
                if (i == 1) {
                    _decodeEscaped();
                } else if (i == 2) {
                    _skipUtf8_2();
                } else if (i == 3) {
                    _skipUtf8_3();
                } else if (i == 4) {
                    _skipUtf8_4();
                } else if (unsignedByte < 32) {
                    _throwUnquotedSpace(unsignedByte, "string value");
                } else {
                    _reportInvalidChar(unsignedByte);
                }
            }
        }
    }

    @Override // com.fasterxml.jackson.core.json.JsonParserBase, com.fasterxml.jackson.core.JsonParser
    public JsonLocation currentLocation() {
        return new JsonLocation(_contentReference(), -1L, -1L, this._currInputRow, -1);
    }

    @Override // com.fasterxml.jackson.core.json.JsonParserBase, com.fasterxml.jackson.core.JsonParser
    public JsonLocation currentTokenLocation() {
        return new JsonLocation(_contentReference(), -1L, -1L, this._tokenInputRow, -1);
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public void finishToken() throws IOException {
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
        return this._inputData;
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
    public char[] getTextCharacters() throws IOException {
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
    public int getTextLength() throws IOException {
        JsonToken jsonToken = this._currToken;
        if (jsonToken == JsonToken.VALUE_STRING) {
            if (this._tokenIncomplete) {
                this._tokenIncomplete = false;
                _finishString();
            }
            return this._textBuffer.size();
        }
        if (jsonToken == JsonToken.FIELD_NAME) {
            return this._parsingContext.getCurrentName().length();
        }
        if (jsonToken != null) {
            return jsonToken.isNumeric() ? this._textBuffer.size() : this._currToken.asCharArray().length;
        }
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0011, code lost:
    
        if (r0 != 8) goto L16;
     */
    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int getTextOffset() throws java.io.IOException {
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
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.UTF8DataInputJsonParser.getTextOffset():int");
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
    public Boolean nextBooleanValue() throws IOException {
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
    public String nextFieldName() throws IOException {
        JsonToken jsonToken_parsePosNumber;
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
        int i_skipWS = _skipWS();
        this._binaryValue = null;
        this._tokenInputRow = this._currInputRow;
        if ((i_skipWS | 32) == 125) {
            _closeScope(i_skipWS);
            return null;
        }
        if (this._parsingContext.expectComma()) {
            if (i_skipWS != 44) {
                _reportUnexpectedChar(i_skipWS, "was expecting comma to separate " + this._parsingContext.typeDesc() + " entries");
            }
            i_skipWS = _skipWS();
            if ((this._features & JsonParserBase.FEAT_MASK_TRAILING_COMMA) != 0 && (i_skipWS | 32) == 125) {
                _closeScope(i_skipWS);
                return null;
            }
        }
        if (!this._parsingContext.inObject()) {
            _nextTokenNotInObject(i_skipWS);
            return null;
        }
        String str_parseName = _parseName(i_skipWS);
        this._parsingContext.setCurrentName(str_parseName);
        _updateToken(jsonToken2);
        int i_skipColon = _skipColon();
        if (i_skipColon == 34) {
            this._tokenIncomplete = true;
            this._nextToken = JsonToken.VALUE_STRING;
            return str_parseName;
        }
        if (i_skipColon == 43) {
            jsonToken_parsePosNumber = isEnabled(JsonReadFeature.ALLOW_LEADING_PLUS_SIGN_FOR_NUMBERS.mappedFeature()) ? _parsePosNumber() : _handleUnexpectedValue(i_skipColon);
        } else if (i_skipColon == 91) {
            jsonToken_parsePosNumber = JsonToken.START_ARRAY;
        } else if (i_skipColon == 102) {
            _matchToken("false", 1);
            jsonToken_parsePosNumber = JsonToken.VALUE_FALSE;
        } else if (i_skipColon == 110) {
            _matchToken("null", 1);
            jsonToken_parsePosNumber = JsonToken.VALUE_NULL;
        } else if (i_skipColon == 116) {
            _matchToken("true", 1);
            jsonToken_parsePosNumber = JsonToken.VALUE_TRUE;
        } else if (i_skipColon == 123) {
            jsonToken_parsePosNumber = JsonToken.START_OBJECT;
        } else if (i_skipColon != 45) {
            if (i_skipColon != 46) {
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
                        break;
                    default:
                        jsonToken_parsePosNumber = _handleUnexpectedValue(i_skipColon);
                        break;
                }
            } else {
                _parseFloatThatStartsWithPeriod(false, false);
            }
            jsonToken_parsePosNumber = _parseUnsignedNumber(i_skipColon);
        } else {
            jsonToken_parsePosNumber = _parseNegNumber();
        }
        this._nextToken = jsonToken_parsePosNumber;
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
    public JsonToken nextToken() throws IOException {
        JsonToken jsonToken_parsePosNumber;
        if (this._closed) {
            return null;
        }
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
        this._tokenInputRow = this._currInputRow;
        if ((i_skipWSOrEnd | 32) == 125) {
            _closeScope(i_skipWSOrEnd);
            return this._currToken;
        }
        if (this._parsingContext.expectComma()) {
            if (i_skipWSOrEnd != 44) {
                _reportUnexpectedChar(i_skipWSOrEnd, "was expecting comma to separate " + this._parsingContext.typeDesc() + " entries");
            }
            i_skipWSOrEnd = _skipWS();
            if ((this._features & JsonParserBase.FEAT_MASK_TRAILING_COMMA) != 0 && (i_skipWSOrEnd | 32) == 125) {
                _closeScope(i_skipWSOrEnd);
                return this._currToken;
            }
        }
        if (!this._parsingContext.inObject()) {
            return _nextTokenNotInObject(i_skipWSOrEnd);
        }
        this._parsingContext.setCurrentName(_parseName(i_skipWSOrEnd));
        _updateToken(jsonToken2);
        int i_skipColon = _skipColon();
        if (i_skipColon == 34) {
            this._tokenIncomplete = true;
            this._nextToken = JsonToken.VALUE_STRING;
            return this._currToken;
        }
        if (i_skipColon == 43) {
            jsonToken_parsePosNumber = isEnabled(JsonReadFeature.ALLOW_LEADING_PLUS_SIGN_FOR_NUMBERS.mappedFeature()) ? _parsePosNumber() : _handleUnexpectedValue(i_skipColon);
        } else if (i_skipColon == 91) {
            jsonToken_parsePosNumber = JsonToken.START_ARRAY;
        } else if (i_skipColon == 102) {
            _matchToken("false", 1);
            jsonToken_parsePosNumber = JsonToken.VALUE_FALSE;
        } else if (i_skipColon == 110) {
            _matchToken("null", 1);
            jsonToken_parsePosNumber = JsonToken.VALUE_NULL;
        } else if (i_skipColon == 116) {
            _matchToken("true", 1);
            jsonToken_parsePosNumber = JsonToken.VALUE_TRUE;
        } else if (i_skipColon == 123) {
            jsonToken_parsePosNumber = JsonToken.START_OBJECT;
        } else if (i_skipColon == 45) {
            jsonToken_parsePosNumber = _parseNegNumber();
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
                    jsonToken_parsePosNumber = _parseUnsignedNumber(i_skipColon);
                    break;
                default:
                    jsonToken_parsePosNumber = _handleUnexpectedValue(i_skipColon);
                    break;
            }
        } else {
            jsonToken_parsePosNumber = _parseFloatThatStartsWithPeriod(false, false);
        }
        this._nextToken = jsonToken_parsePosNumber;
        return this._currToken;
    }

    public final String parseEscapedName(int[] iArr, int i, int i3, int i10, int i11) throws IOException {
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
                            iArr = ParserBase.growArrayBy(iArr, iArr.length);
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
                                iArr = ParserBase.growArrayBy(iArr, iArr.length);
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
                    iArr = ParserBase.growArrayBy(iArr, iArr.length);
                    this._quadBuffer = iArr;
                }
                iArr[i] = i3;
                i3 = i10;
                i++;
                i11 = 1;
            }
            i10 = this._inputData.readUnsignedByte();
        }
        if (i11 > 0) {
            if (i >= iArr.length) {
                iArr = ParserBase.growArrayBy(iArr, iArr.length);
                this._quadBuffer = iArr;
            }
            iArr[i] = pad(i3, i11);
            i++;
        }
        String strFindName = this._symbols.findName(iArr, i);
        return strFindName == null ? addName(iArr, i, i11) : strFindName;
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
    public int releaseBuffered(OutputStream outputStream) {
        return 0;
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

    @Override // com.fasterxml.jackson.core.base.ParserBase
    public void _closeInput() {
    }

    private final String findName(int i, int i3, int i10) {
        int iPad = pad(i3, i10);
        String strFindName = this._symbols.findName(i, iPad);
        if (strFindName != null) {
            return strFindName;
        }
        int[] iArr = this._quadBuffer;
        iArr[0] = i;
        iArr[1] = iPad;
        return addName(iArr, 2, i10);
    }

    private final String findName(int i, int i3) {
        int iPad = pad(i, i3);
        String strFindName = this._symbols.findName(iPad);
        if (strFindName != null) {
            return strFindName;
        }
        int[] iArr = this._quadBuffer;
        iArr[0] = iPad;
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

    private final String findName(int[] iArr, int i, int i3, int i10) {
        if (i >= iArr.length) {
            iArr = ParserBase.growArrayBy(iArr, iArr.length);
            this._quadBuffer = iArr;
        }
        int i11 = i + 1;
        iArr[i] = pad(i3, i10);
        String strFindName = this._symbols.findName(iArr, i11);
        return strFindName == null ? addName(iArr, i11, i10) : strFindName;
    }

    @Deprecated
    public final JsonToken _parseFloatThatStartsWithPeriod() {
        return _parseFloatThatStartsWithPeriod(false, false);
    }

    public void _reportInvalidToken(int i, String str) throws IOException {
        _reportInvalidToken(i, str, _validJsonTokenList());
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

    public JsonToken _handleInvalidNumberStart(int i, boolean z10) {
        return _handleInvalidNumberStart(i, z10, false);
    }
}
