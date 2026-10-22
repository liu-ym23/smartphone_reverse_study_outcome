package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.core.internal.shaded.fdp.v2_19_2.FastDoubleMath;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import com.fasterxml.jackson.core.util.TextBuffer;
import g5.f;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class ReaderBasedJsonParser extends JsonParserBase {
    protected boolean _bufferRecyclable;
    protected final int _hashSeed;
    protected char[] _inputBuffer;
    protected int _nameStartCol;
    protected long _nameStartOffset;
    protected int _nameStartRow;
    protected ObjectCodec _objectCodec;
    protected Reader _reader;
    protected final CharsToNameCanonicalizer _symbols;
    protected boolean _tokenIncomplete;

    public ReaderBasedJsonParser(IOContext iOContext, int i, Reader reader, ObjectCodec objectCodec, CharsToNameCanonicalizer charsToNameCanonicalizer, char[] cArr, int i3, int i10, boolean z10) {
        super(iOContext, i, objectCodec);
        this._reader = reader;
        this._inputBuffer = cArr;
        this._inputPtr = i3;
        this._inputEnd = i10;
        this._currInputRowStart = i3;
        this._currInputProcessed = -i3;
        this._symbols = charsToNameCanonicalizer;
        this._hashSeed = charsToNameCanonicalizer.hashSeed();
        this._bufferRecyclable = z10;
    }

    private final void _checkMatchEnd(String str, int i, int i3) {
        if (Character.isJavaIdentifierPart((char) i3)) {
            _reportInvalidToken(str.substring(0, i));
        }
    }

    private void _closeScope(int i) {
        if (i == 93) {
            _updateLocation();
            if (!this._parsingContext.inArray()) {
                _reportMismatchedEndMarker(i, '}');
            }
            this._parsingContext = this._parsingContext.clearAndGetParent();
            _updateToken(JsonToken.END_ARRAY);
        }
        if (i == 125) {
            _updateLocation();
            if (!this._parsingContext.inObject()) {
                _reportMismatchedEndMarker(i, ']');
            }
            this._parsingContext = this._parsingContext.clearAndGetParent();
            _updateToken(JsonToken.END_OBJECT);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0069 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0061 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String _handleOddName2(int r5, int r6, int[] r7) {
        /*
            r4 = this;
            com.fasterxml.jackson.core.util.TextBuffer r0 = r4._textBuffer
            char[] r1 = r4._inputBuffer
            int r2 = r4._inputPtr
            int r2 = r2 - r5
            r0.resetWithShared(r1, r5, r2)
            com.fasterxml.jackson.core.util.TextBuffer r5 = r4._textBuffer
            char[] r5 = r5.getCurrentSegment()
            com.fasterxml.jackson.core.util.TextBuffer r0 = r4._textBuffer
            int r0 = r0.getCurrentSegmentSize()
            int r1 = r7.length
        L17:
            int r2 = r4._inputPtr
            int r3 = r4._inputEnd
            if (r2 < r3) goto L24
            boolean r2 = r4._loadMore()
            if (r2 != 0) goto L24
            goto L37
        L24:
            char[] r2 = r4._inputBuffer
            int r3 = r4._inputPtr
            char r2 = r2[r3]
            if (r2 >= r1) goto L31
            r3 = r7[r2]
            if (r3 == 0) goto L51
            goto L37
        L31:
            boolean r3 = java.lang.Character.isJavaIdentifierPart(r2)
            if (r3 != 0) goto L51
        L37:
            com.fasterxml.jackson.core.util.TextBuffer r5 = r4._textBuffer
            r5.setCurrentLength(r0)
            com.fasterxml.jackson.core.util.TextBuffer r5 = r4._textBuffer
            char[] r7 = r5.getTextBuffer()
            int r0 = r5.getTextOffset()
            com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer r4 = r4._symbols
            int r5 = r5.size()
            java.lang.String r4 = r4.findSymbol(r7, r0, r5, r6)
            return r4
        L51:
            int r3 = r4._inputPtr
            int r3 = r3 + 1
            r4._inputPtr = r3
            int r6 = r6 * 33
            int r6 = r6 + r2
            int r3 = r0 + 1
            r5[r0] = r2
            int r0 = r5.length
            if (r3 < r0) goto L69
            com.fasterxml.jackson.core.util.TextBuffer r5 = r4._textBuffer
            char[] r5 = r5.finishCurrentSegment()
            r0 = 0
            goto L17
        L69:
            r0 = r3
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.ReaderBasedJsonParser._handleOddName2(int, int, int[]):java.lang.String");
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
                this._nextToken = _handleOddValue(i);
                return;
            }
        }
        if (i == 91) {
            this._nextToken = JsonToken.START_ARRAY;
            return;
        }
        if (i == 102) {
            _matchToken("false", 1);
            this._nextToken = JsonToken.VALUE_FALSE;
            return;
        }
        if (i == 110) {
            _matchToken("null", 1);
            this._nextToken = JsonToken.VALUE_NULL;
            return;
        }
        if (i == 116) {
            _matchToken("true", 1);
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
            this._nextToken = _parseFloatThatStartsWithPeriod(false);
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
                this._nextToken = _handleOddValue(i);
                break;
        }
    }

    private final void _matchFalse() {
        int i;
        char c9;
        int i3 = this._inputPtr;
        if (i3 + 4 < this._inputEnd) {
            char[] cArr = this._inputBuffer;
            if (cArr[i3] == 'a' && cArr[i3 + 1] == 'l' && cArr[i3 + 2] == 's' && cArr[i3 + 3] == 'e' && ((c9 = cArr[(i = i3 + 4)]) < '0' || c9 == ']' || c9 == '}')) {
                this._inputPtr = i;
                return;
            }
        }
        _matchToken("false", 1);
    }

    private final void _matchNull() {
        int i;
        char c9;
        int i3 = this._inputPtr;
        if (i3 + 3 < this._inputEnd) {
            char[] cArr = this._inputBuffer;
            if (cArr[i3] == 'u' && cArr[i3 + 1] == 'l' && cArr[i3 + 2] == 'l' && ((c9 = cArr[(i = i3 + 3)]) < '0' || c9 == ']' || c9 == '}')) {
                this._inputPtr = i;
                return;
            }
        }
        _matchToken("null", 1);
    }

    private final void _matchToken2(String str, int i) {
        int i3;
        char c9;
        int length = str.length();
        do {
            if ((this._inputPtr >= this._inputEnd && !_loadMore()) || this._inputBuffer[this._inputPtr] != str.charAt(i)) {
                _reportInvalidToken(str.substring(0, i));
            }
            i3 = this._inputPtr + 1;
            this._inputPtr = i3;
            i++;
        } while (i < length);
        if ((i3 < this._inputEnd || _loadMore()) && (c9 = this._inputBuffer[this._inputPtr]) >= '0' && c9 != ']' && c9 != '}') {
            _checkMatchEnd(str, i, c9);
        }
    }

    private final void _matchTrue() {
        int i;
        char c9;
        int i3 = this._inputPtr;
        if (i3 + 3 < this._inputEnd) {
            char[] cArr = this._inputBuffer;
            if (cArr[i3] == 'r' && cArr[i3 + 1] == 'u' && cArr[i3 + 2] == 'e' && ((c9 = cArr[(i = i3 + 3)]) < '0' || c9 == ']' || c9 == '}')) {
                this._inputPtr = i;
                return;
            }
        }
        _matchToken("true", 1);
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
        switch (i) {
            case 44:
                if (!this._parsingContext.inRoot() && (this._features & JsonParserBase.FEAT_MASK_ALLOW_MISSING) != 0) {
                    this._inputPtr--;
                    return _updateToken(JsonToken.VALUE_NULL);
                }
                break;
            case 45:
                return _updateToken(_parseSignedNumber(true));
            case 46:
                return _updateToken(_parseFloatThatStartsWithPeriod(false));
            default:
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
                }
        }
        return _updateToken(_handleOddValue(i));
    }

    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [int, char], vars: [r10v0 ??, r10v1 ??, r10v13 ??, r10v2 ??, r10v7 ??, r10v6 ??, r10v5 ??, r10v10 ??, r10v9 ??]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:107)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:83)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:57)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:45)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    private final com.fasterxml.jackson.core.JsonToken _parseFloat(
    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [int, char], vars: [r10v0 ??, r10v1 ??, r10v13 ??, r10v2 ??, r10v7 ??, r10v6 ??, r10v5 ??, r10v10 ??, r10v9 ??]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:107)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:83)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:57)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:45)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r10v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:224)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:169)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:405)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */

    private String _parseName2(int i, int i3, int i10) {
        this._textBuffer.resetWithShared(this._inputBuffer, i, this._inputPtr - i);
        char[] currentSegment = this._textBuffer.getCurrentSegment();
        int currentSegmentSize = this._textBuffer.getCurrentSegmentSize();
        while (true) {
            if (this._inputPtr >= this._inputEnd && !_loadMore()) {
                _reportInvalidEOF(" in field name", JsonToken.FIELD_NAME);
            }
            char[] cArr = this._inputBuffer;
            int i11 = this._inputPtr;
            this._inputPtr = i11 + 1;
            char c_decodeEscaped = cArr[i11];
            if (c_decodeEscaped <= '\\') {
                if (c_decodeEscaped == '\\') {
                    c_decodeEscaped = _decodeEscaped();
                } else if (c_decodeEscaped <= i10) {
                    if (c_decodeEscaped == i10) {
                        this._textBuffer.setCurrentLength(currentSegmentSize);
                        TextBuffer textBuffer = this._textBuffer;
                        return this._symbols.findSymbol(textBuffer.getTextBuffer(), textBuffer.getTextOffset(), textBuffer.size(), i3);
                    }
                    if (c_decodeEscaped < ' ') {
                        _throwUnquotedSpace(c_decodeEscaped, "name");
                    }
                }
            }
            i3 = (i3 * 33) + c_decodeEscaped;
            int i12 = currentSegmentSize + 1;
            currentSegment[currentSegmentSize] = c_decodeEscaped;
            if (i12 >= currentSegment.length) {
                currentSegment = this._textBuffer.finishCurrentSegment();
                currentSegmentSize = 0;
            } else {
                currentSegmentSize = i12;
            }
        }
    }

    private final JsonToken _parseNumber2(boolean z10, int i) {
        int i3;
        char nextChar;
        boolean z11;
        int i10;
        char nextChar2;
        if (z10) {
            i++;
        }
        this._inputPtr = i;
        char[] cArrEmptyAndGetCurrentSegment = this._textBuffer.emptyAndGetCurrentSegment();
        if (z10) {
            cArrEmptyAndGetCurrentSegment[0] = '-';
            i3 = 1;
        } else {
            i3 = 0;
        }
        int i11 = this._inputPtr;
        if (i11 < this._inputEnd) {
            char[] cArr = this._inputBuffer;
            this._inputPtr = i11 + 1;
            nextChar = cArr[i11];
        } else {
            nextChar = getNextChar("No digit following sign", JsonToken.VALUE_NUMBER_INT);
        }
        if (nextChar == '0') {
            nextChar = _verifyNoLeadingZeroes();
        }
        int i12 = 0;
        while (nextChar >= '0' && nextChar <= '9') {
            i12++;
            if (i3 >= cArrEmptyAndGetCurrentSegment.length) {
                cArrEmptyAndGetCurrentSegment = this._textBuffer.finishCurrentSegment();
                i3 = 0;
            }
            int i13 = i3 + 1;
            cArrEmptyAndGetCurrentSegment[i3] = nextChar;
            if (this._inputPtr >= this._inputEnd && !_loadMore()) {
                nextChar = 0;
                i3 = i13;
                z11 = true;
                break;
            }
            char[] cArr2 = this._inputBuffer;
            int i14 = this._inputPtr;
            this._inputPtr = i14 + 1;
            nextChar = cArr2[i14];
            i3 = i13;
        }
        z11 = false;
        if (i12 == 0 && (nextChar != '.' || !isEnabled(JsonReadFeature.ALLOW_LEADING_DECIMAL_POINT_FOR_NUMBERS.mappedFeature()))) {
            return _handleInvalidNumberStart(nextChar, z10);
        }
        int i15 = -1;
        if (nextChar == '.') {
            if (i3 >= cArrEmptyAndGetCurrentSegment.length) {
                cArrEmptyAndGetCurrentSegment = this._textBuffer.finishCurrentSegment();
                i3 = 0;
            }
            cArrEmptyAndGetCurrentSegment[i3] = nextChar;
            i3++;
            i10 = 0;
            while (true) {
                if (this._inputPtr >= this._inputEnd && !_loadMore()) {
                    z11 = true;
                    break;
                }
                char[] cArr3 = this._inputBuffer;
                int i16 = this._inputPtr;
                this._inputPtr = i16 + 1;
                nextChar = cArr3[i16];
                if (nextChar < '0' || nextChar > '9') {
                    break;
                }
                i10++;
                if (i3 >= cArrEmptyAndGetCurrentSegment.length) {
                    cArrEmptyAndGetCurrentSegment = this._textBuffer.finishCurrentSegment();
                    i3 = 0;
                }
                cArrEmptyAndGetCurrentSegment[i3] = nextChar;
                i3++;
            }
            if (i10 == 0 && !isEnabled(JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS.mappedFeature())) {
                _reportUnexpectedNumberChar(nextChar, "Decimal point not followed by a digit");
            }
        } else {
            i10 = -1;
        }
        if ((nextChar | ' ') == 101) {
            if (i3 >= cArrEmptyAndGetCurrentSegment.length) {
                cArrEmptyAndGetCurrentSegment = this._textBuffer.finishCurrentSegment();
                i3 = 0;
            }
            int i17 = i3 + 1;
            cArrEmptyAndGetCurrentSegment[i3] = nextChar;
            int i18 = this._inputPtr;
            if (i18 < this._inputEnd) {
                char[] cArr4 = this._inputBuffer;
                this._inputPtr = i18 + 1;
                nextChar2 = cArr4[i18];
            } else {
                nextChar2 = getNextChar("expected a digit for number exponent", JsonToken.VALUE_NUMBER_FLOAT);
            }
            if (nextChar2 == '-' || nextChar2 == '+') {
                if (i17 >= cArrEmptyAndGetCurrentSegment.length) {
                    cArrEmptyAndGetCurrentSegment = this._textBuffer.finishCurrentSegment();
                    i17 = 0;
                }
                int i19 = i17 + 1;
                cArrEmptyAndGetCurrentSegment[i17] = nextChar2;
                int i20 = this._inputPtr;
                if (i20 < this._inputEnd) {
                    char[] cArr5 = this._inputBuffer;
                    this._inputPtr = i20 + 1;
                    nextChar2 = cArr5[i20];
                } else {
                    nextChar2 = getNextChar("expected a digit for number exponent", JsonToken.VALUE_NUMBER_FLOAT);
                }
                i17 = i19;
            }
            int i21 = 0;
            nextChar = nextChar2;
            while (nextChar <= '9' && nextChar >= '0') {
                i21++;
                if (i17 >= cArrEmptyAndGetCurrentSegment.length) {
                    cArrEmptyAndGetCurrentSegment = this._textBuffer.finishCurrentSegment();
                    i17 = 0;
                }
                i3 = i17 + 1;
                cArrEmptyAndGetCurrentSegment[i17] = nextChar;
                if (this._inputPtr >= this._inputEnd && !_loadMore()) {
                    z11 = true;
                    break;
                }
                char[] cArr6 = this._inputBuffer;
                int i22 = this._inputPtr;
                this._inputPtr = i22 + 1;
                nextChar = cArr6[i22];
                i17 = i3;
            }
            i3 = i17;
            i15 = i21;
            if (i15 == 0) {
                _reportUnexpectedNumberChar(nextChar, "Exponent indicator not followed by a digit");
            }
        }
        if (!z11) {
            this._inputPtr--;
            if (this._parsingContext.inRoot()) {
                _verifyRootSpace(nextChar);
            }
        }
        this._textBuffer.setCurrentLength(i3);
        return (i10 >= 0 || i15 >= 0) ? resetFloat(z10, i12, i10, i15) : resetInt(z10, i12);
    }

    private final JsonToken _parseSignedNumber(boolean z10) {
        int i = this._inputPtr;
        int i3 = z10 ? i - 1 : i;
        int i10 = this._inputEnd;
        if (i >= i10) {
            return _parseNumber2(z10, i3);
        }
        int i11 = i + 1;
        char c9 = this._inputBuffer[i];
        char c10 = '9';
        int i12 = 1;
        if (c9 > '9' || c9 < '0') {
            this._inputPtr = i11;
            return c9 == '.' ? _parseFloatThatStartsWithPeriod(z10) : _handleInvalidNumberStart(c9, z10, true);
        }
        if (c9 == '0') {
            return _parseNumber2(z10, i3);
        }
        while (i11 < i10) {
            char c11 = c10;
            int i13 = i11 + 1;
            char c12 = this._inputBuffer[i11];
            if (c12 < '0' || c12 > c11) {
                if (c12 == '.' || (c12 | ' ') == 101) {
                    this._inputPtr = i13;
                    return _parseFloat(c12, i3, i13, z10, i12);
                }
                this._inputPtr = i11;
                if (this._parsingContext.inRoot()) {
                    _verifyRootSpace(c12);
                }
                this._textBuffer.resetWithShared(this._inputBuffer, i3, i11 - i3);
                return resetInt(z10, i12);
            }
            i12++;
            i11 = i13;
            c10 = c11;
        }
        return _parseNumber2(z10, i3);
    }

    private final int _skipAfterComma2() throws JsonParseException {
        char c9;
        while (true) {
            if (this._inputPtr >= this._inputEnd && !_loadMore()) {
                throw _constructError("Unexpected end-of-input within/between " + this._parsingContext.typeDesc() + " entries");
            }
            char[] cArr = this._inputBuffer;
            int i = this._inputPtr;
            int i3 = i + 1;
            this._inputPtr = i3;
            c9 = cArr[i];
            if (c9 > ' ') {
                if (c9 == '/') {
                    _skipComment();
                } else if (c9 != '#' || !_skipYAMLComment()) {
                    break;
                }
            } else if (c9 < ' ') {
                if (c9 == '\n') {
                    this._currInputRow++;
                    this._currInputRowStart = i3;
                } else if (c9 == '\r') {
                    _skipCR();
                } else if (c9 != '\t') {
                    _throwInvalidSpace(c9);
                }
            }
        }
        return c9;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0026, code lost:
    
        _reportInvalidEOF(" in a comment", null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002c, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void _skipCComment() {
        /*
            r3 = this;
        L0:
            int r0 = r3._inputPtr
            int r1 = r3._inputEnd
            if (r0 < r1) goto Lc
            boolean r0 = r3._loadMore()
            if (r0 == 0) goto L26
        Lc:
            char[] r0 = r3._inputBuffer
            int r1 = r3._inputPtr
            int r2 = r1 + 1
            r3._inputPtr = r2
            char r0 = r0[r1]
            r1 = 42
            if (r0 > r1) goto L0
            if (r0 != r1) goto L3c
            int r0 = r3._inputEnd
            if (r2 < r0) goto L2d
            boolean r0 = r3._loadMore()
            if (r0 != 0) goto L2d
        L26:
            java.lang.String r0 = " in a comment"
            r1 = 0
            r3._reportInvalidEOF(r0, r1)
            return
        L2d:
            char[] r0 = r3._inputBuffer
            int r1 = r3._inputPtr
            char r0 = r0[r1]
            r2 = 47
            if (r0 != r2) goto L0
            int r1 = r1 + 1
            r3._inputPtr = r1
            return
        L3c:
            r1 = 32
            if (r0 >= r1) goto L0
            r1 = 10
            if (r0 != r1) goto L4d
            int r0 = r3._currInputRow
            int r0 = r0 + 1
            r3._currInputRow = r0
            r3._currInputRowStart = r2
            goto L0
        L4d:
            r1 = 13
            if (r0 != r1) goto L55
            r3._skipCR()
            goto L0
        L55:
            r1 = 9
            if (r0 == r1) goto L0
            r3._throwInvalidSpace(r0)
            goto L0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.ReaderBasedJsonParser._skipCComment():void");
    }

    private final int _skipColon() {
        int i = this._inputPtr;
        if (i + 4 >= this._inputEnd) {
            return _skipColon2(false);
        }
        char[] cArr = this._inputBuffer;
        char c9 = cArr[i];
        if (c9 == ':') {
            int i3 = i + 1;
            this._inputPtr = i3;
            char c10 = cArr[i3];
            if (c10 > ' ') {
                if (c10 == '/' || c10 == '#') {
                    return _skipColon2(true);
                }
                this._inputPtr = i + 2;
                return c10;
            }
            if (c10 == ' ' || c10 == '\t') {
                int i10 = i + 2;
                this._inputPtr = i10;
                char c11 = cArr[i10];
                if (c11 > ' ') {
                    if (c11 == '/' || c11 == '#') {
                        return _skipColon2(true);
                    }
                    this._inputPtr = i + 3;
                    return c11;
                }
            }
            return _skipColon2(true);
        }
        if (c9 == ' ' || c9 == '\t') {
            int i11 = i + 1;
            this._inputPtr = i11;
            c9 = cArr[i11];
        }
        if (c9 != ':') {
            return _skipColon2(false);
        }
        int i12 = this._inputPtr;
        int i13 = i12 + 1;
        this._inputPtr = i13;
        char c12 = cArr[i13];
        if (c12 > ' ') {
            if (c12 == '/' || c12 == '#') {
                return _skipColon2(true);
            }
            this._inputPtr = i12 + 2;
            return c12;
        }
        if (c12 == ' ' || c12 == '\t') {
            int i14 = i12 + 2;
            this._inputPtr = i14;
            char c13 = cArr[i14];
            if (c13 > ' ') {
                if (c13 == '/' || c13 == '#') {
                    return _skipColon2(true);
                }
                this._inputPtr = i12 + 3;
                return c13;
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
            char[] cArr = this._inputBuffer;
            int i = this._inputPtr;
            int i3 = i + 1;
            this._inputPtr = i3;
            char c9 = cArr[i];
            if (c9 > ' ') {
                if (c9 == '/') {
                    _skipComment();
                } else if (c9 != '#' || !_skipYAMLComment()) {
                    if (z10) {
                        return c9;
                    }
                    if (c9 != ':') {
                        _reportUnexpectedChar(c9, "was expecting a colon to separate field name and value");
                    }
                    z10 = true;
                }
            } else if (c9 < ' ') {
                if (c9 == '\n') {
                    this._currInputRow++;
                    this._currInputRowStart = i3;
                } else if (c9 == '\r') {
                    _skipCR();
                } else if (c9 != '\t') {
                    _throwInvalidSpace(c9);
                }
            }
        }
    }

    private final int _skipColonFast(int i) {
        char[] cArr = this._inputBuffer;
        int i3 = i + 1;
        char c9 = cArr[i];
        if (c9 == ':') {
            int i10 = i + 2;
            char c10 = cArr[i3];
            if (c10 > ' ') {
                if (c10 != '/' && c10 != '#') {
                    this._inputPtr = i10;
                    return c10;
                }
            } else if (c10 == ' ' || c10 == '\t') {
                int i11 = i + 3;
                char c11 = cArr[i10];
                if (c11 > ' ' && c11 != '/' && c11 != '#') {
                    this._inputPtr = i11;
                    return c11;
                }
                i10 = i11;
            }
            this._inputPtr = i10 - 1;
            return _skipColon2(true);
        }
        if (c9 == ' ' || c9 == '\t') {
            c9 = cArr[i3];
            i3 = i + 2;
        }
        boolean z10 = c9 == ':';
        if (z10) {
            int i12 = i3 + 1;
            char c12 = cArr[i3];
            if (c12 > ' ') {
                if (c12 != '/' && c12 != '#') {
                    this._inputPtr = i12;
                    return c12;
                }
            } else if (c12 == ' ' || c12 == '\t') {
                i3 += 2;
                char c13 = cArr[i12];
                if (c13 > ' ' && c13 != '/' && c13 != '#') {
                    this._inputPtr = i3;
                    return c13;
                }
            }
            i3 = i12;
        }
        this._inputPtr = i3 - 1;
        return _skipColon2(z10);
    }

    private final int _skipComma(int i) {
        if (i != 44) {
            _reportUnexpectedChar(i, "was expecting comma to separate " + this._parsingContext.typeDesc() + " entries");
        }
        while (true) {
            int i3 = this._inputPtr;
            if (i3 >= this._inputEnd) {
                return _skipAfterComma2();
            }
            char[] cArr = this._inputBuffer;
            int i10 = i3 + 1;
            this._inputPtr = i10;
            char c9 = cArr[i3];
            if (c9 > ' ') {
                if (c9 != '/' && c9 != '#') {
                    return c9;
                }
                this._inputPtr = i3;
                return _skipAfterComma2();
            }
            if (c9 < ' ') {
                if (c9 == '\n') {
                    this._currInputRow++;
                    this._currInputRowStart = i10;
                } else if (c9 == '\r') {
                    _skipCR();
                } else if (c9 != '\t') {
                    _throwInvalidSpace(c9);
                }
            }
        }
    }

    private void _skipComment() {
        if ((this._features & JsonParserBase.FEAT_MASK_ALLOW_JAVA_COMMENTS) == 0) {
            _reportUnexpectedChar(47, "maybe a (non-standard) comment? (not recognized as one since Feature 'ALLOW_COMMENTS' not enabled for parser)");
        }
        if (this._inputPtr >= this._inputEnd && !_loadMore()) {
            _reportInvalidEOF(" in a comment", null);
        }
        char[] cArr = this._inputBuffer;
        int i = this._inputPtr;
        this._inputPtr = i + 1;
        char c9 = cArr[i];
        if (c9 == '/') {
            _skipLine();
        } else if (c9 == '*') {
            _skipCComment();
        } else {
            _reportUnexpectedChar(c9, "was expecting either '*' or '/' for a comment");
        }
    }

    private void _skipLine() {
        while (true) {
            if (this._inputPtr >= this._inputEnd && !_loadMore()) {
                return;
            }
            char[] cArr = this._inputBuffer;
            int i = this._inputPtr;
            int i3 = i + 1;
            this._inputPtr = i3;
            char c9 = cArr[i];
            if (c9 < ' ') {
                if (c9 == '\n') {
                    this._currInputRow++;
                    this._currInputRowStart = i3;
                    return;
                } else if (c9 == '\r') {
                    _skipCR();
                    return;
                } else if (c9 != '\t') {
                    _throwInvalidSpace(c9);
                }
            }
        }
    }

    private final int _skipWSOrEnd() {
        if (this._inputPtr >= this._inputEnd && !_loadMore()) {
            return _eofAsNextChar();
        }
        char[] cArr = this._inputBuffer;
        int i = this._inputPtr;
        int i3 = i + 1;
        this._inputPtr = i3;
        char c9 = cArr[i];
        if (c9 > ' ') {
            if (c9 != '/' && c9 != '#') {
                return c9;
            }
            this._inputPtr = i;
            return _skipWSOrEnd2();
        }
        if (c9 != ' ') {
            if (c9 == '\n') {
                this._currInputRow++;
                this._currInputRowStart = i3;
            } else if (c9 == '\r') {
                _skipCR();
            } else if (c9 != '\t' && !_isAllowedCtrlCharRS(c9)) {
                _throwInvalidSpace(c9);
            }
        }
        while (true) {
            int i10 = this._inputPtr;
            if (i10 >= this._inputEnd) {
                return _skipWSOrEnd2();
            }
            char[] cArr2 = this._inputBuffer;
            int i11 = i10 + 1;
            this._inputPtr = i11;
            char c10 = cArr2[i10];
            if (c10 > ' ') {
                if (c10 != '/' && c10 != '#') {
                    return c10;
                }
                this._inputPtr = i10;
                return _skipWSOrEnd2();
            }
            if (c10 != ' ') {
                if (c10 == '\n') {
                    this._currInputRow++;
                    this._currInputRowStart = i11;
                } else if (c10 == '\r') {
                    _skipCR();
                } else if (c10 != '\t' && !_isAllowedCtrlCharRS(c10)) {
                    _throwInvalidSpace(c10);
                }
            }
        }
    }

    private int _skipWSOrEnd2() {
        char c9;
        while (true) {
            if (this._inputPtr >= this._inputEnd && !_loadMore()) {
                return _eofAsNextChar();
            }
            char[] cArr = this._inputBuffer;
            int i = this._inputPtr;
            int i3 = i + 1;
            this._inputPtr = i3;
            c9 = cArr[i];
            if (c9 > ' ') {
                if (c9 == '/') {
                    _skipComment();
                } else if (c9 != '#' || !_skipYAMLComment()) {
                    break;
                }
            } else if (c9 != ' ') {
                if (c9 == '\n') {
                    this._currInputRow++;
                    this._currInputRowStart = i3;
                } else if (c9 == '\r') {
                    _skipCR();
                } else if (c9 != '\t') {
                    _throwInvalidSpace(c9);
                }
            }
        }
        return c9;
    }

    private boolean _skipYAMLComment() {
        if ((this._features & JsonParserBase.FEAT_MASK_ALLOW_YAML_COMMENTS) == 0) {
            return false;
        }
        _skipLine();
        return true;
    }

    private final void _updateLocation() {
        int i = this._inputPtr;
        this._tokenInputTotal = this._currInputProcessed + i;
        this._tokenInputRow = this._currInputRow;
        this._tokenInputCol = i - this._currInputRowStart;
    }

    private final void _updateNameLocation() {
        int i = this._inputPtr;
        this._nameStartOffset = i;
        this._nameStartRow = this._currInputRow;
        this._nameStartCol = i - this._currInputRowStart;
    }

    private char _verifyNLZ2() {
        char c9;
        if ((this._inputPtr >= this._inputEnd && !_loadMore()) || (c9 = this._inputBuffer[this._inputPtr]) < '0' || c9 > '9') {
            return '0';
        }
        if ((this._features & JsonParserBase.FEAT_MASK_LEADING_ZEROS) == 0) {
            reportInvalidNumber("Leading zeroes not allowed");
        }
        this._inputPtr++;
        if (c9 != '0') {
            return c9;
        }
        do {
            if (this._inputPtr >= this._inputEnd && !_loadMore()) {
                return c9;
            }
            char[] cArr = this._inputBuffer;
            int i = this._inputPtr;
            c9 = cArr[i];
            if (c9 < '0' || c9 > '9') {
                return '0';
            }
            this._inputPtr = i + 1;
        } while (c9 == '0');
        return c9;
    }

    private final char _verifyNoLeadingZeroes() {
        char c9;
        int i = this._inputPtr;
        if (i >= this._inputEnd || ((c9 = this._inputBuffer[i]) >= '0' && c9 <= '9')) {
            return _verifyNLZ2();
        }
        return '0';
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

    @Override // com.fasterxml.jackson.core.base.ParserBase
    public void _closeInput() throws IOException {
        if (this._reader != null) {
            if (this._ioContext.isResourceManaged() || isEnabled(JsonParser.Feature.AUTO_CLOSE_SOURCE)) {
                this._reader.close();
            }
            this._reader = null;
        }
    }

    @Override // com.fasterxml.jackson.core.json.JsonParserBase, com.fasterxml.jackson.core.base.ParserMinimalBase
    public JsonLocation _currentLocationMinusOne() {
        int i = this._inputPtr - 1;
        return new JsonLocation(_contentReference(), -1L, this._currInputProcessed + i, this._currInputRow, (i - this._currInputRowStart) + 1);
    }

    public byte[] _decodeBase64(Base64Variant base64Variant) {
        ByteArrayBuilder byteArrayBuilder_getByteArrayBuilder = _getByteArrayBuilder();
        while (true) {
            if (this._inputPtr >= this._inputEnd) {
                _loadMoreGuaranteed();
            }
            char[] cArr = this._inputBuffer;
            int i = this._inputPtr;
            this._inputPtr = i + 1;
            char c9 = cArr[i];
            if (c9 > ' ') {
                int iDecodeBase64Char = base64Variant.decodeBase64Char(c9);
                if (iDecodeBase64Char < 0) {
                    if (c9 == '\"') {
                        return byteArrayBuilder_getByteArrayBuilder.toByteArray();
                    }
                    iDecodeBase64Char = _decodeBase64Escape(base64Variant, c9, 0);
                    if (iDecodeBase64Char < 0) {
                        continue;
                    }
                }
                if (this._inputPtr >= this._inputEnd) {
                    _loadMoreGuaranteed();
                }
                char[] cArr2 = this._inputBuffer;
                int i3 = this._inputPtr;
                this._inputPtr = i3 + 1;
                char c10 = cArr2[i3];
                int iDecodeBase64Char2 = base64Variant.decodeBase64Char(c10);
                if (iDecodeBase64Char2 < 0) {
                    iDecodeBase64Char2 = _decodeBase64Escape(base64Variant, c10, 1);
                }
                int i10 = (iDecodeBase64Char << 6) | iDecodeBase64Char2;
                if (this._inputPtr >= this._inputEnd) {
                    _loadMoreGuaranteed();
                }
                char[] cArr3 = this._inputBuffer;
                int i11 = this._inputPtr;
                this._inputPtr = i11 + 1;
                char c11 = cArr3[i11];
                int iDecodeBase64Char3 = base64Variant.decodeBase64Char(c11);
                if (iDecodeBase64Char3 < 0) {
                    if (iDecodeBase64Char3 != -2) {
                        if (c11 == '\"') {
                            byteArrayBuilder_getByteArrayBuilder.append(i10 >> 4);
                            if (base64Variant.requiresPaddingOnRead()) {
                                this._inputPtr--;
                                _handleBase64MissingPadding(base64Variant);
                            }
                            return byteArrayBuilder_getByteArrayBuilder.toByteArray();
                        }
                        iDecodeBase64Char3 = _decodeBase64Escape(base64Variant, c11, 2);
                    }
                    if (iDecodeBase64Char3 == -2) {
                        if (this._inputPtr >= this._inputEnd) {
                            _loadMoreGuaranteed();
                        }
                        char[] cArr4 = this._inputBuffer;
                        int i12 = this._inputPtr;
                        this._inputPtr = i12 + 1;
                        char c12 = cArr4[i12];
                        if (!base64Variant.usesPaddingChar(c12) && _decodeBase64Escape(base64Variant, c12, 3) != -2) {
                            throw reportInvalidBase64Char(base64Variant, c12, 3, "expected padding character '" + base64Variant.getPaddingChar() + "'");
                        }
                        byteArrayBuilder_getByteArrayBuilder.append(i10 >> 4);
                    }
                }
                int i13 = (i10 << 6) | iDecodeBase64Char3;
                if (this._inputPtr >= this._inputEnd) {
                    _loadMoreGuaranteed();
                }
                char[] cArr5 = this._inputBuffer;
                int i14 = this._inputPtr;
                this._inputPtr = i14 + 1;
                char c13 = cArr5[i14];
                int iDecodeBase64Char4 = base64Variant.decodeBase64Char(c13);
                if (iDecodeBase64Char4 < 0) {
                    if (iDecodeBase64Char4 != -2) {
                        if (c13 == '\"') {
                            byteArrayBuilder_getByteArrayBuilder.appendTwoBytes(i13 >> 2);
                            if (base64Variant.requiresPaddingOnRead()) {
                                this._inputPtr--;
                                _handleBase64MissingPadding(base64Variant);
                            }
                            return byteArrayBuilder_getByteArrayBuilder.toByteArray();
                        }
                        iDecodeBase64Char4 = _decodeBase64Escape(base64Variant, c13, 3);
                    }
                    if (iDecodeBase64Char4 == -2) {
                        byteArrayBuilder_getByteArrayBuilder.appendTwoBytes(i13 >> 2);
                    }
                }
                byteArrayBuilder_getByteArrayBuilder.appendThreeBytes((i13 << 6) | iDecodeBase64Char4);
            }
        }
    }

    @Override // com.fasterxml.jackson.core.base.ParserBase
    public char _decodeEscaped() {
        if (this._inputPtr >= this._inputEnd && !_loadMore()) {
            _reportInvalidEOF(" in character escape sequence", JsonToken.VALUE_STRING);
        }
        char[] cArr = this._inputBuffer;
        int i = this._inputPtr;
        this._inputPtr = i + 1;
        char c9 = cArr[i];
        if (c9 == '\"' || c9 == '/' || c9 == '\\') {
            return c9;
        }
        if (c9 == 'b') {
            return '\b';
        }
        if (c9 == 'f') {
            return '\f';
        }
        if (c9 == 'n') {
            return '\n';
        }
        if (c9 == 'r') {
            return '\r';
        }
        if (c9 == 't') {
            return '\t';
        }
        if (c9 != 'u') {
            return _handleUnrecognizedCharacterEscape(c9);
        }
        int i3 = 0;
        for (int i10 = 0; i10 < 4; i10++) {
            if (this._inputPtr >= this._inputEnd && !_loadMore()) {
                _reportInvalidEOF(" in character escape sequence", JsonToken.VALUE_STRING);
            }
            char[] cArr2 = this._inputBuffer;
            int i11 = this._inputPtr;
            this._inputPtr = i11 + 1;
            char c10 = cArr2[i11];
            int iCharToHex = CharTypes.charToHex(c10);
            if (iCharToHex < 0) {
                _reportUnexpectedChar(c10, "expected a hex-digit for character escape sequence");
            }
            i3 = (i3 << 4) | iCharToHex;
        }
        return (char) i3;
    }

    @Override // com.fasterxml.jackson.core.base.ParserBase
    public final void _finishString() {
        int i = this._inputPtr;
        int i3 = this._inputEnd;
        if (i < i3) {
            int[] iArr = JsonParserBase.INPUT_CODES_LATIN1;
            int length = iArr.length;
            while (true) {
                char[] cArr = this._inputBuffer;
                char c9 = cArr[i];
                if (c9 >= length || iArr[c9] == 0) {
                    i++;
                    if (i >= i3) {
                        break;
                    }
                } else if (c9 == '\"') {
                    TextBuffer textBuffer = this._textBuffer;
                    int i10 = this._inputPtr;
                    textBuffer.resetWithShared(cArr, i10, i - i10);
                    this._inputPtr = i + 1;
                    return;
                }
            }
        }
        TextBuffer textBuffer2 = this._textBuffer;
        char[] cArr2 = this._inputBuffer;
        int i11 = this._inputPtr;
        textBuffer2.resetWithCopy(cArr2, i11, i - i11);
        this._inputPtr = i;
        _finishString2();
    }

    public void _finishString2() {
        char[] currentSegment = this._textBuffer.getCurrentSegment();
        int currentSegmentSize = this._textBuffer.getCurrentSegmentSize();
        int[] iArr = JsonParserBase.INPUT_CODES_LATIN1;
        int length = iArr.length;
        while (true) {
            if (this._inputPtr >= this._inputEnd && !_loadMore()) {
                _reportInvalidEOF(": was expecting closing quote for a string value", JsonToken.VALUE_STRING);
            }
            char[] cArr = this._inputBuffer;
            int i = this._inputPtr;
            this._inputPtr = i + 1;
            char c_decodeEscaped = cArr[i];
            if (c_decodeEscaped < length && iArr[c_decodeEscaped] != 0) {
                if (c_decodeEscaped == '\"') {
                    this._textBuffer.setCurrentLength(currentSegmentSize);
                    return;
                } else if (c_decodeEscaped == '\\') {
                    c_decodeEscaped = _decodeEscaped();
                } else if (c_decodeEscaped < ' ') {
                    _throwUnquotedSpace(c_decodeEscaped, "string value");
                }
            }
            if (currentSegmentSize >= currentSegment.length) {
                currentSegment = this._textBuffer.finishCurrentSegment();
                currentSegmentSize = 0;
            }
            currentSegment[currentSegmentSize] = c_decodeEscaped;
            currentSegmentSize++;
        }
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
        int currentSegmentSize = this._textBuffer.getCurrentSegmentSize();
        while (true) {
            if (this._inputPtr >= this._inputEnd && !_loadMore()) {
                _reportInvalidEOF(": was expecting closing quote for a string value", JsonToken.VALUE_STRING);
            }
            char[] cArr = this._inputBuffer;
            int i = this._inputPtr;
            this._inputPtr = i + 1;
            char c_decodeEscaped = cArr[i];
            if (c_decodeEscaped <= '\\') {
                if (c_decodeEscaped == '\\') {
                    c_decodeEscaped = _decodeEscaped();
                } else if (c_decodeEscaped <= '\'') {
                    if (c_decodeEscaped == '\'') {
                        this._textBuffer.setCurrentLength(currentSegmentSize);
                        return JsonToken.VALUE_STRING;
                    }
                    if (c_decodeEscaped < ' ') {
                        _throwUnquotedSpace(c_decodeEscaped, "string value");
                    }
                }
            }
            if (currentSegmentSize >= cArrEmptyAndGetCurrentSegment.length) {
                cArrEmptyAndGetCurrentSegment = this._textBuffer.finishCurrentSegment();
                currentSegmentSize = 0;
            }
            cArrEmptyAndGetCurrentSegment[currentSegmentSize] = c_decodeEscaped;
            currentSegmentSize++;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [int, char], vars: [r10v0 ??, r10v1 ??, r10v4 ??]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:107)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:83)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:57)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:45)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public com.fasterxml.jackson.core.JsonToken _handleInvalidNumberStart(
    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [int, char], vars: [r10v0 ??, r10v1 ??, r10v4 ??]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:107)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:83)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:57)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:45)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r10v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:224)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:169)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:405)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */

    public String _handleOddName(int i) {
        if (i == 39 && (this._features & JsonParserBase.FEAT_MASK_ALLOW_SINGLE_QUOTES) != 0) {
            return _parseAposName();
        }
        if ((this._features & JsonParserBase.FEAT_MASK_ALLOW_UNQUOTED_NAMES) == 0) {
            _reportUnexpectedChar(i, "was expecting double-quote to start field name");
        }
        int[] inputCodeLatin1JsNames = CharTypes.getInputCodeLatin1JsNames();
        int length = inputCodeLatin1JsNames.length;
        if (!(i < length ? inputCodeLatin1JsNames[i] == 0 : Character.isJavaIdentifierPart((char) i))) {
            _reportUnexpectedChar(i, "was expecting either valid name character (for unquoted name) or double-quote (for quoted) to start field name");
        }
        int i3 = this._inputPtr;
        int i10 = this._hashSeed;
        int i11 = this._inputEnd;
        if (i3 < i11) {
            do {
                char[] cArr = this._inputBuffer;
                char c9 = cArr[i3];
                if (c9 < length) {
                    if (inputCodeLatin1JsNames[c9] != 0) {
                        int i12 = this._inputPtr - 1;
                        this._inputPtr = i3;
                        return this._symbols.findSymbol(cArr, i12, i3 - i12, i10);
                    }
                } else if (!Character.isJavaIdentifierPart(c9)) {
                    int i13 = this._inputPtr - 1;
                    this._inputPtr = i3;
                    return this._symbols.findSymbol(this._inputBuffer, i13, i3 - i13, i10);
                }
                i10 = (i10 * 33) + c9;
                i3++;
            } while (i3 < i11);
        }
        int i14 = this._inputPtr - 1;
        this._inputPtr = i3;
        return _handleOddName2(i14, i10, inputCodeLatin1JsNames);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.fasterxml.jackson.core.JsonToken _handleOddValue(int r4) {
        /*
            r3 = this;
            r0 = 39
            if (r4 == r0) goto L8e
            r0 = 73
            r1 = 1
            if (r4 == r0) goto L75
            r0 = 78
            if (r4 == r0) goto L5c
            r0 = 93
            if (r4 == r0) goto L3c
            r0 = 43
            if (r4 == r0) goto L1b
            r0 = 44
            if (r4 == r0) goto L45
            goto L9a
        L1b:
            int r4 = r3._inputPtr
            int r0 = r3._inputEnd
            if (r4 < r0) goto L2c
            boolean r4 = r3._loadMore()
            if (r4 != 0) goto L2c
            com.fasterxml.jackson.core.JsonToken r4 = com.fasterxml.jackson.core.JsonToken.VALUE_NUMBER_INT
            r3._reportInvalidEOFInValue(r4)
        L2c:
            char[] r4 = r3._inputBuffer
            int r0 = r3._inputPtr
            int r2 = r0 + 1
            r3._inputPtr = r2
            char r4 = r4[r0]
            r0 = 0
            com.fasterxml.jackson.core.JsonToken r3 = r3._handleInvalidNumberStart(r4, r0, r1)
            return r3
        L3c:
            com.fasterxml.jackson.core.json.JsonReadContext r0 = r3._parsingContext
            boolean r0 = r0.inArray()
            if (r0 != 0) goto L45
            goto L9a
        L45:
            com.fasterxml.jackson.core.json.JsonReadContext r0 = r3._parsingContext
            boolean r0 = r0.inRoot()
            if (r0 != 0) goto L9a
            int r0 = r3._features
            int r2 = com.fasterxml.jackson.core.json.JsonParserBase.FEAT_MASK_ALLOW_MISSING
            r0 = r0 & r2
            if (r0 == 0) goto L9a
            int r4 = r3._inputPtr
            int r4 = r4 - r1
            r3._inputPtr = r4
            com.fasterxml.jackson.core.JsonToken r3 = com.fasterxml.jackson.core.JsonToken.VALUE_NULL
            return r3
        L5c:
            java.lang.String r0 = "NaN"
            r3._matchToken(r0, r1)
            int r1 = r3._features
            int r2 = com.fasterxml.jackson.core.json.JsonParserBase.FEAT_MASK_NON_NUM_NUMBERS
            r1 = r1 & r2
            if (r1 == 0) goto L6f
            r1 = 9221120237041090560(0x7ff8000000000000, double:NaN)
            com.fasterxml.jackson.core.JsonToken r3 = r3.resetAsNaN(r0, r1)
            return r3
        L6f:
            java.lang.String r0 = "Non-standard token 'NaN': enable `JsonReadFeature.ALLOW_NON_NUMERIC_NUMBERS` to allow"
            r3._reportError(r0)
            goto L9a
        L75:
            java.lang.String r0 = "Infinity"
            r3._matchToken(r0, r1)
            int r1 = r3._features
            int r2 = com.fasterxml.jackson.core.json.JsonParserBase.FEAT_MASK_NON_NUM_NUMBERS
            r1 = r1 & r2
            if (r1 == 0) goto L88
            r1 = 9218868437227405312(0x7ff0000000000000, double:Infinity)
            com.fasterxml.jackson.core.JsonToken r3 = r3.resetAsNaN(r0, r1)
            return r3
        L88:
            java.lang.String r0 = "Non-standard token 'Infinity': enable `JsonReadFeature.ALLOW_NON_NUMERIC_NUMBERS` to allow"
            r3._reportError(r0)
            goto L9a
        L8e:
            int r0 = r3._features
            int r1 = com.fasterxml.jackson.core.json.JsonParserBase.FEAT_MASK_ALLOW_SINGLE_QUOTES
            r0 = r0 & r1
            if (r0 == 0) goto L9a
            com.fasterxml.jackson.core.JsonToken r3 = r3._handleApos()
            return r3
        L9a:
            boolean r0 = java.lang.Character.isJavaIdentifierStart(r4)
            if (r0 == 0) goto Lb6
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = ""
            r0.<init>(r1)
            char r1 = (char) r4
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = r3._validJsonTokenList()
            r3._reportInvalidToken(r0, r1)
        Lb6:
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
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.ReaderBasedJsonParser._handleOddValue(int):com.fasterxml.jackson.core.JsonToken");
    }

    public boolean _isNextTokenNameMaybe(int i, String str) throws JsonParseException {
        JsonToken jsonToken_parseSignedNumber;
        String str_parseName = i == 34 ? _parseName() : _handleOddName(i);
        this._parsingContext.setCurrentName(str_parseName);
        _updateToken(JsonToken.FIELD_NAME);
        int i_skipColon = _skipColon();
        _updateLocation();
        if (i_skipColon == 34) {
            this._tokenIncomplete = true;
            this._nextToken = JsonToken.VALUE_STRING;
            return str.equals(str_parseName);
        }
        if (i_skipColon == 43) {
            jsonToken_parseSignedNumber = isEnabled(JsonReadFeature.ALLOW_LEADING_PLUS_SIGN_FOR_NUMBERS.mappedFeature()) ? _parseSignedNumber(false) : _handleOddValue(i_skipColon);
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
                    jsonToken_parseSignedNumber = _handleOddValue(i_skipColon);
                    break;
            }
        } else {
            jsonToken_parseSignedNumber = _parseFloatThatStartsWithPeriod(false);
        }
        this._nextToken = jsonToken_parseSignedNumber;
        return str.equals(str_parseName);
    }

    public boolean _loadMore() throws IOException {
        if (this._reader != null) {
            int i = this._inputEnd;
            long j10 = i;
            long j11 = this._currInputProcessed + j10;
            this._currInputProcessed = j11;
            this._currInputRowStart -= i;
            this._streamReadConstraints.validateDocumentLength(j11);
            Reader reader = this._reader;
            char[] cArr = this._inputBuffer;
            int i3 = reader.read(cArr, 0, cArr.length);
            if (i3 > 0) {
                this._nameStartOffset -= j10;
                this._inputPtr = 0;
                this._inputEnd = i3;
                return true;
            }
            this._inputEnd = 0;
            this._inputPtr = 0;
            _closeInput();
            if (i3 == 0) {
                f.e(this._inputEnd, "Reader returned 0 characters when trying to read ");
                return false;
            }
        }
        return false;
    }

    public void _loadMoreGuaranteed() {
        if (_loadMore()) {
            return;
        }
        _reportInvalidEOF();
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
        char c9 = this._inputBuffer[i3];
        if (c9 < '0' || c9 == ']' || c9 == '}') {
            return;
        }
        _checkMatchEnd(str, i, c9);
    }

    public String _parseAposName() {
        int i = this._inputPtr;
        int i3 = this._hashSeed;
        int i10 = this._inputEnd;
        if (i < i10) {
            int[] iArr = JsonParserBase.INPUT_CODES_LATIN1;
            int length = iArr.length;
            do {
                char[] cArr = this._inputBuffer;
                char c9 = cArr[i];
                if (c9 != '\'') {
                    if (c9 < length && iArr[c9] != 0) {
                        break;
                    }
                    i3 = (i3 * 33) + c9;
                    i++;
                } else {
                    int i11 = this._inputPtr;
                    this._inputPtr = i + 1;
                    return this._symbols.findSymbol(cArr, i11, i - i11, i3);
                }
            } while (i < i10);
        }
        int i12 = this._inputPtr;
        this._inputPtr = i;
        return _parseName2(i12, i3, 39);
    }

    public final JsonToken _parseFloatThatStartsWithPeriod(boolean z10) {
        if (!isEnabled(JsonReadFeature.ALLOW_LEADING_DECIMAL_POINT_FOR_NUMBERS.mappedFeature())) {
            return _handleOddValue(46);
        }
        int i = this._inputPtr;
        int i3 = i - 1;
        if (z10) {
            i3 = i - 2;
        }
        return _parseFloat(46, i3, i, z10, 0);
    }

    public final String _parseName() {
        int i = this._inputPtr;
        int i3 = this._hashSeed;
        int[] iArr = JsonParserBase.INPUT_CODES_LATIN1;
        while (true) {
            if (i >= this._inputEnd) {
                break;
            }
            char[] cArr = this._inputBuffer;
            char c9 = cArr[i];
            if (c9 >= iArr.length || iArr[c9] == 0) {
                i3 = (i3 * 33) + c9;
                i++;
            } else if (c9 == '\"') {
                int i10 = this._inputPtr;
                this._inputPtr = i + 1;
                return this._symbols.findSymbol(cArr, i10, i - i10, i3);
            }
        }
        int i11 = this._inputPtr;
        this._inputPtr = i;
        return _parseName2(i11, i3, 34);
    }

    public final JsonToken _parseUnsignedNumber(int i) {
        int i3 = this._inputPtr;
        int i10 = i3 - 1;
        int i11 = this._inputEnd;
        char c9 = '0';
        if (i == 48) {
            return _parseNumber2(false, i10);
        }
        int i12 = 1;
        while (i3 < i11) {
            char c10 = c9;
            int i13 = i3 + 1;
            char c11 = this._inputBuffer[i3];
            if (c11 < c10 || c11 > '9') {
                if (c11 == '.' || (c11 | ' ') == 101) {
                    this._inputPtr = i13;
                    return _parseFloat(c11, i10, i13, false, i12);
                }
                this._inputPtr = i3;
                if (this._parsingContext.inRoot()) {
                    _verifyRootSpace(c11);
                }
                this._textBuffer.resetWithShared(this._inputBuffer, i10, i3 - i10);
                return resetInt(false, i12);
            }
            i12++;
            i3 = i13;
            c9 = c10;
        }
        this._inputPtr = i10;
        return _parseNumber2(false, i10);
    }

    public int _readBinary(Base64Variant base64Variant, OutputStream outputStream, byte[] bArr) throws IOException {
        int length = bArr.length - 3;
        int i = 0;
        int i3 = 0;
        while (true) {
            if (this._inputPtr >= this._inputEnd) {
                _loadMoreGuaranteed();
            }
            char[] cArr = this._inputBuffer;
            int i10 = this._inputPtr;
            this._inputPtr = i10 + 1;
            char c9 = cArr[i10];
            if (c9 > ' ') {
                int iDecodeBase64Char = base64Variant.decodeBase64Char(c9);
                if (iDecodeBase64Char < 0) {
                    if (c9 == '\"') {
                        break;
                    }
                    iDecodeBase64Char = _decodeBase64Escape(base64Variant, c9, 0);
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
                char[] cArr2 = this._inputBuffer;
                int i11 = this._inputPtr;
                this._inputPtr = i11 + 1;
                char c10 = cArr2[i11];
                int iDecodeBase64Char2 = base64Variant.decodeBase64Char(c10);
                if (iDecodeBase64Char2 < 0) {
                    iDecodeBase64Char2 = _decodeBase64Escape(base64Variant, c10, 1);
                }
                int i12 = (iDecodeBase64Char << 6) | iDecodeBase64Char2;
                if (this._inputPtr >= this._inputEnd) {
                    _loadMoreGuaranteed();
                }
                char[] cArr3 = this._inputBuffer;
                int i13 = this._inputPtr;
                this._inputPtr = i13 + 1;
                char c11 = cArr3[i13];
                int iDecodeBase64Char3 = base64Variant.decodeBase64Char(c11);
                if (iDecodeBase64Char3 < 0) {
                    if (iDecodeBase64Char3 != -2) {
                        if (c11 == '\"') {
                            int i14 = i + 1;
                            bArr[i] = (byte) (i12 >> 4);
                            if (base64Variant.requiresPaddingOnRead()) {
                                this._inputPtr--;
                                _handleBase64MissingPadding(base64Variant);
                            }
                            i = i14;
                        } else {
                            iDecodeBase64Char3 = _decodeBase64Escape(base64Variant, c11, 2);
                        }
                    }
                    if (iDecodeBase64Char3 == -2) {
                        if (this._inputPtr >= this._inputEnd) {
                            _loadMoreGuaranteed();
                        }
                        char[] cArr4 = this._inputBuffer;
                        int i15 = this._inputPtr;
                        this._inputPtr = i15 + 1;
                        char c12 = cArr4[i15];
                        if (!base64Variant.usesPaddingChar(c12) && _decodeBase64Escape(base64Variant, c12, 3) != -2) {
                            throw reportInvalidBase64Char(base64Variant, c12, 3, "expected padding character '" + base64Variant.getPaddingChar() + "'");
                        }
                        bArr[i] = (byte) (i12 >> 4);
                        i++;
                    }
                }
                int i16 = (i12 << 6) | iDecodeBase64Char3;
                if (this._inputPtr >= this._inputEnd) {
                    _loadMoreGuaranteed();
                }
                char[] cArr5 = this._inputBuffer;
                int i17 = this._inputPtr;
                this._inputPtr = i17 + 1;
                char c13 = cArr5[i17];
                int iDecodeBase64Char4 = base64Variant.decodeBase64Char(c13);
                if (iDecodeBase64Char4 < 0) {
                    if (iDecodeBase64Char4 != -2) {
                        if (c13 == '\"') {
                            int i18 = i + 1;
                            bArr[i] = (byte) (i16 >> 10);
                            i += 2;
                            bArr[i18] = (byte) (i16 >> 2);
                            if (base64Variant.requiresPaddingOnRead()) {
                                this._inputPtr--;
                                _handleBase64MissingPadding(base64Variant);
                            }
                        } else {
                            iDecodeBase64Char4 = _decodeBase64Escape(base64Variant, c13, 3);
                        }
                    }
                    if (iDecodeBase64Char4 == -2) {
                        int i19 = i + 1;
                        bArr[i] = (byte) (i16 >> 10);
                        i += 2;
                        bArr[i19] = (byte) (i16 >> 2);
                    }
                }
                int i20 = (i16 << 6) | iDecodeBase64Char4;
                bArr[i] = (byte) (i20 >> 16);
                int i21 = i + 2;
                bArr[i + 1] = (byte) (i20 >> 8);
                i += 3;
                bArr[i21] = (byte) i20;
            }
        }
        this._tokenIncomplete = false;
        if (i <= 0) {
            return i3;
        }
        int i22 = i3 + i;
        outputStream.write(bArr, 0, i);
        return i22;
    }

    @Override // com.fasterxml.jackson.core.base.ParserBase
    public void _releaseBuffers() {
        char[] cArr;
        super._releaseBuffers();
        this._symbols.release();
        if (!this._bufferRecyclable || (cArr = this._inputBuffer) == null) {
            return;
        }
        this._inputBuffer = null;
        this._ioContext.releaseTokenBuffer(cArr);
    }

    public void _reportInvalidToken(String str, String str2) {
        StringBuilder sb2 = new StringBuilder(str);
        while (true) {
            if (this._inputPtr >= this._inputEnd && !_loadMore()) {
                break;
            }
            char c9 = this._inputBuffer[this._inputPtr];
            if (!Character.isJavaIdentifierPart(c9)) {
                break;
            }
            this._inputPtr++;
            sb2.append(c9);
            if (sb2.length() >= this._ioContext.errorReportConfiguration().getMaxErrorTokenLength()) {
                sb2.append("...");
                break;
            }
        }
        _reportError("Unrecognized token '%s': was expecting %s", sb2, str2);
    }

    public final void _skipCR() {
        if (this._inputPtr < this._inputEnd || _loadMore()) {
            char[] cArr = this._inputBuffer;
            int i = this._inputPtr;
            if (cArr[i] == '\n') {
                this._inputPtr = i + 1;
            }
        }
        this._currInputRow++;
        this._currInputRowStart = this._inputPtr;
    }

    public final void _skipString() {
        this._tokenIncomplete = false;
        int i = this._inputPtr;
        int i3 = this._inputEnd;
        char[] cArr = this._inputBuffer;
        while (true) {
            if (i >= i3) {
                this._inputPtr = i;
                if (!_loadMore()) {
                    _reportInvalidEOF(": was expecting closing quote for a string value", JsonToken.VALUE_STRING);
                }
                i = this._inputPtr;
                i3 = this._inputEnd;
            }
            int i10 = i + 1;
            char c9 = cArr[i];
            if (c9 <= '\\') {
                if (c9 == '\\') {
                    this._inputPtr = i10;
                    _decodeEscaped();
                    i = this._inputPtr;
                    i3 = this._inputEnd;
                } else if (c9 <= '\"') {
                    if (c9 == '\"') {
                        this._inputPtr = i10;
                        return;
                    } else if (c9 < ' ') {
                        this._inputPtr = i10;
                        _throwUnquotedSpace(c9, "string value");
                    }
                }
            }
            i = i10;
        }
    }

    @Override // com.fasterxml.jackson.core.json.JsonParserBase, com.fasterxml.jackson.core.JsonParser
    public JsonLocation currentLocation() {
        return new JsonLocation(_contentReference(), -1L, this._inputPtr + this._currInputProcessed, this._currInputRow, (this._inputPtr - this._currInputRowStart) + 1);
    }

    @Override // com.fasterxml.jackson.core.json.JsonParserBase, com.fasterxml.jackson.core.JsonParser
    public JsonLocation currentTokenLocation() {
        if (this._currToken != JsonToken.FIELD_NAME) {
            return new JsonLocation(_contentReference(), -1L, this._tokenInputTotal - 1, this._tokenInputRow, this._tokenInputCol);
        }
        return new JsonLocation(_contentReference(), -1L, (this._nameStartOffset - 1) + this._currInputProcessed, this._nameStartRow, this._nameStartCol);
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
        byte[] bArr;
        JsonToken jsonToken = this._currToken;
        if (jsonToken == JsonToken.VALUE_EMBEDDED_OBJECT && (bArr = this._binaryValue) != null) {
            return bArr;
        }
        if (jsonToken != JsonToken.VALUE_STRING) {
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
        return this._reader;
    }

    public char getNextChar(String str, JsonToken jsonToken) {
        if (this._inputPtr >= this._inputEnd && !_loadMore()) {
            _reportInvalidEOF(str, jsonToken);
        }
        char[] cArr = this._inputBuffer;
        int i = this._inputPtr;
        this._inputPtr = i + 1;
        return cArr[i];
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
    public final char[] getTextCharacters() {
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
    public final int getTextLength() {
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
    public final int getTextOffset() {
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
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.ReaderBasedJsonParser.getTextOffset():int");
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public final String getValueAsString() {
        JsonToken jsonToken = this._currToken;
        if (jsonToken != JsonToken.VALUE_STRING) {
            return jsonToken == JsonToken.FIELD_NAME ? currentName() : super.getValueAsString(null);
        }
        if (this._tokenIncomplete) {
            this._tokenIncomplete = false;
            _finishString();
        }
        return this._textBuffer.contentsAsString();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public final Boolean nextBooleanValue() throws JsonParseException {
        if (this._currToken != JsonToken.FIELD_NAME) {
            JsonToken jsonTokenNextToken = nextToken();
            if (jsonTokenNextToken != null) {
                int iId = jsonTokenNextToken.id();
                if (iId == 9) {
                    return Boolean.TRUE;
                }
                if (iId == 10) {
                    return Boolean.FALSE;
                }
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
        if ((i_skipWSOrEnd | 32) == 125) {
            _closeScope(i_skipWSOrEnd);
            return null;
        }
        if (this._parsingContext.expectComma()) {
            i_skipWSOrEnd = _skipComma(i_skipWSOrEnd);
            if ((this._features & JsonParserBase.FEAT_MASK_TRAILING_COMMA) != 0 && (i_skipWSOrEnd | 32) == 125) {
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
        String str_parseName = i_skipWSOrEnd == 34 ? _parseName() : _handleOddName(i_skipWSOrEnd);
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
            jsonToken_parseSignedNumber = isEnabled(JsonReadFeature.ALLOW_LEADING_PLUS_SIGN_FOR_NUMBERS.mappedFeature()) ? _parseSignedNumber(false) : _handleOddValue(i_skipColon);
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
                    jsonToken_parseSignedNumber = _handleOddValue(i_skipColon);
                    break;
            }
        } else {
            jsonToken_parseSignedNumber = _parseFloatThatStartsWithPeriod(false);
        }
        this._nextToken = jsonToken_parseSignedNumber;
        return str_parseName;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public final int nextIntValue(int i) {
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
    public final long nextLongValue(long j10) {
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
    public final String nextTextValue() {
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
            if (this._tokenIncomplete) {
                this._tokenIncomplete = false;
                _finishString();
            }
            return this._textBuffer.contentsAsString();
        }
        if (jsonToken == JsonToken.START_ARRAY) {
            createChildArrayContext(this._tokenInputRow, this._tokenInputCol);
        } else if (jsonToken == JsonToken.START_OBJECT) {
            createChildObjectContext(this._tokenInputRow, this._tokenInputCol);
        }
        return null;
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public final JsonToken nextToken() throws JsonParseException {
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
        if ((i_skipWSOrEnd | 32) == 125) {
            _closeScope(i_skipWSOrEnd);
            return this._currToken;
        }
        if (this._parsingContext.expectComma()) {
            i_skipWSOrEnd = _skipComma(i_skipWSOrEnd);
            if ((this._features & JsonParserBase.FEAT_MASK_TRAILING_COMMA) != 0 && (i_skipWSOrEnd | 32) == 125) {
                _closeScope(i_skipWSOrEnd);
                return this._currToken;
            }
        }
        boolean zInObject = this._parsingContext.inObject();
        if (zInObject) {
            _updateNameLocation();
            this._parsingContext.setCurrentName(i_skipWSOrEnd == 34 ? _parseName() : _handleOddName(i_skipWSOrEnd));
            _updateToken(jsonToken2);
            i_skipWSOrEnd = _skipColon();
        }
        _updateLocation();
        if (i_skipWSOrEnd == 34) {
            this._tokenIncomplete = true;
            jsonToken_parseSignedNumber = JsonToken.VALUE_STRING;
        } else if (i_skipWSOrEnd == 43) {
            jsonToken_parseSignedNumber = isEnabled(JsonReadFeature.ALLOW_LEADING_PLUS_SIGN_FOR_NUMBERS.mappedFeature()) ? _parseSignedNumber(false) : _handleOddValue(i_skipWSOrEnd);
        } else if (i_skipWSOrEnd == 91) {
            if (!zInObject) {
                createChildArrayContext(this._tokenInputRow, this._tokenInputCol);
            }
            jsonToken_parseSignedNumber = JsonToken.START_ARRAY;
        } else if (i_skipWSOrEnd == 102) {
            _matchFalse();
            jsonToken_parseSignedNumber = JsonToken.VALUE_FALSE;
        } else if (i_skipWSOrEnd == 110) {
            _matchNull();
            jsonToken_parseSignedNumber = JsonToken.VALUE_NULL;
        } else if (i_skipWSOrEnd == 116) {
            _matchTrue();
            jsonToken_parseSignedNumber = JsonToken.VALUE_TRUE;
        } else if (i_skipWSOrEnd == 123) {
            if (!zInObject) {
                createChildObjectContext(this._tokenInputRow, this._tokenInputCol);
            }
            jsonToken_parseSignedNumber = JsonToken.START_OBJECT;
        } else if (i_skipWSOrEnd == 125) {
            _reportUnexpectedChar(i_skipWSOrEnd, "expected a value");
            _matchTrue();
            jsonToken_parseSignedNumber = JsonToken.VALUE_TRUE;
        } else if (i_skipWSOrEnd == 45) {
            jsonToken_parseSignedNumber = _parseSignedNumber(true);
        } else if (i_skipWSOrEnd != 46) {
            switch (i_skipWSOrEnd) {
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
                    jsonToken_parseSignedNumber = _parseUnsignedNumber(i_skipWSOrEnd);
                    break;
                default:
                    jsonToken_parseSignedNumber = _handleOddValue(i_skipWSOrEnd);
                    break;
            }
        } else {
            jsonToken_parseSignedNumber = _parseFloatThatStartsWithPeriod(false);
        }
        if (!zInObject) {
            return _updateToken(jsonToken_parseSignedNumber);
        }
        this._nextToken = jsonToken_parseSignedNumber;
        return this._currToken;
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
    public int releaseBuffered(Writer writer) throws IOException {
        int i = this._inputEnd;
        int i3 = this._inputPtr;
        int i10 = i - i3;
        if (i10 < 1) {
            return 0;
        }
        this._inputPtr = i3 + i10;
        writer.write(this._inputBuffer, i3, i10);
        return i10;
    }

    @Deprecated
    public char getNextChar(String str) {
        return getNextChar(str, null);
    }

    public ReaderBasedJsonParser(IOContext iOContext, int i, Reader reader, ObjectCodec objectCodec, CharsToNameCanonicalizer charsToNameCanonicalizer) {
        super(iOContext, i, objectCodec);
        this._reader = reader;
        this._inputBuffer = iOContext.allocTokenBuffer();
        this._inputPtr = 0;
        this._inputEnd = 0;
        this._symbols = charsToNameCanonicalizer;
        this._hashSeed = charsToNameCanonicalizer.hashSeed();
        this._bufferRecyclable = true;
    }

    @Deprecated
    public final JsonToken _parseFloatThatStartsWithPeriod() {
        return _parseFloatThatStartsWithPeriod(false);
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public final String getValueAsString(String str) {
        JsonToken jsonToken = this._currToken;
        if (jsonToken == JsonToken.VALUE_STRING) {
            if (this._tokenIncomplete) {
                this._tokenIncomplete = false;
                _finishString();
            }
            return this._textBuffer.contentsAsString();
        }
        if (jsonToken == JsonToken.FIELD_NAME) {
            return currentName();
        }
        return super.getValueAsString(str);
    }

    public void _reportInvalidToken(String str) {
        _reportInvalidToken(str, _validJsonTokenList());
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public final String getText() {
        JsonToken jsonToken = this._currToken;
        if (jsonToken == JsonToken.VALUE_STRING) {
            if (this._tokenIncomplete) {
                this._tokenIncomplete = false;
                _finishString();
            }
            return this._textBuffer.contentsAsString();
        }
        return _getText2(jsonToken);
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
        if ((i_skipWSOrEnd | 32) == 125) {
            _closeScope(i_skipWSOrEnd);
            return false;
        }
        if (this._parsingContext.expectComma()) {
            i_skipWSOrEnd = _skipComma(i_skipWSOrEnd);
            if ((this._features & JsonParserBase.FEAT_MASK_TRAILING_COMMA) != 0 && (i_skipWSOrEnd | 32) == 125) {
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
            char[] cArrAsQuotedChars = serializableString.asQuotedChars();
            int length = cArrAsQuotedChars.length;
            int i3 = this._inputPtr;
            if (i3 + length + 4 < this._inputEnd) {
                int i10 = length + i3;
                if (this._inputBuffer[i10] == '\"') {
                    while (i3 != i10) {
                        if (cArrAsQuotedChars[i] == this._inputBuffer[i3]) {
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
        return _isNextTokenNameMaybe(i_skipWSOrEnd, serializableString.getValue());
    }
}
