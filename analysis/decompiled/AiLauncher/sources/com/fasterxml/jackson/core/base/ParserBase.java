package com.fasterxml.jackson.core.base;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.StreamReadCapability;
import com.fasterxml.jackson.core.StreamReadFeature;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.exc.StreamConstraintsException;
import com.fasterxml.jackson.core.io.ContentReference;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.io.NumberInput;
import com.fasterxml.jackson.core.json.DupDetector;
import com.fasterxml.jackson.core.json.JsonReadContext;
import com.fasterxml.jackson.core.json.PackageVersion;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import com.fasterxml.jackson.core.util.JacksonFeatureSet;
import com.fasterxml.jackson.core.util.TextBuffer;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;

/* loaded from: classes.dex */
public abstract class ParserBase extends ParserMinimalBase {
    protected static final JacksonFeatureSet<StreamReadCapability> JSON_READ_CAPABILITIES = JsonParser.DEFAULT_READ_CAPABILITIES;
    protected byte[] _binaryValue;
    protected ByteArrayBuilder _byteArrayBuilder;
    protected boolean _closed;
    protected long _currInputProcessed;
    protected int _currInputRow;
    protected int _currInputRowStart;
    protected int _expLength;
    protected int _fractLength;
    protected int _inputEnd;
    protected int _inputPtr;
    protected int _intLength;
    protected final IOContext _ioContext;
    protected boolean _nameCopied;
    protected char[] _nameCopyBuffer;
    protected JsonToken _nextToken;
    protected int _numTypesValid;
    protected BigDecimal _numberBigDecimal;
    protected BigInteger _numberBigInt;
    protected double _numberDouble;
    protected float _numberFloat;
    protected int _numberInt;
    protected boolean _numberIsNaN;
    protected long _numberLong;
    protected boolean _numberNegative;
    protected String _numberString;
    protected JsonReadContext _parsingContext;
    protected final TextBuffer _textBuffer;
    protected int _tokenInputCol;
    protected int _tokenInputRow;
    protected long _tokenInputTotal;

    public ParserBase(IOContext iOContext, int i10) {
        super(i10, iOContext.streamReadConstraints());
        this._currInputRow = 1;
        this._tokenInputRow = 1;
        this._numTypesValid = 0;
        this._ioContext = iOContext;
        this._textBuffer = iOContext.constructReadConstrainedTextBuffer();
        this._parsingContext = JsonReadContext.createRootContext(JsonParser.Feature.STRICT_DUPLICATE_DETECTION.enabledIn(i10) ? DupDetector.rootDetector(this) : null);
    }

    private void _parseSlowFloat(int i10) throws IOException {
        if (i10 == 16) {
            this._numberBigDecimal = this._textBuffer.contentsAsDecimal(isEnabled(StreamReadFeature.USE_FAST_BIG_NUMBER_PARSER));
            this._numTypesValid = 16;
            return;
        }
        if (i10 == 8) {
            this._numberDouble = this._textBuffer.contentsAsDouble(isEnabled(StreamReadFeature.USE_FAST_DOUBLE_PARSER));
            this._numTypesValid = 8;
        } else if (i10 == 32) {
            this._numberFloat = this._textBuffer.contentsAsFloat(isEnabled(StreamReadFeature.USE_FAST_DOUBLE_PARSER));
            this._numTypesValid = 32;
        } else {
            this._numberDouble = 0.0d;
            this._numberString = this._textBuffer.contentsAsString();
            this._numTypesValid = 8;
        }
    }

    private void _parseSlowInt(int i10) throws IOException {
        String strContentsAsString = this._textBuffer.contentsAsString();
        if (i10 == 1 || i10 == 2) {
            _reportTooLongIntegral(i10, strContentsAsString);
        }
        if (i10 == 8 || i10 == 32) {
            this._numberString = strContentsAsString;
            this._numTypesValid = 8;
        } else {
            this._numberBigInt = null;
            this._numberString = strContentsAsString;
            this._numTypesValid = 4;
        }
    }

    public static int[] growArrayBy(int[] iArr, int i10) throws IllegalArgumentException {
        if (iArr == null) {
            return new int[i10];
        }
        int length = iArr.length + i10;
        if (length >= 0) {
            return Arrays.copyOf(iArr, length);
        }
        throw new IllegalArgumentException("Unable to grow array to longer than `Integer.MAX_VALUE`");
    }

    public void _checkStdFeatureChanges(int i10, int i11) {
        int mask = JsonParser.Feature.STRICT_DUPLICATE_DETECTION.getMask();
        if ((i11 & mask) == 0 || (i10 & mask) == 0) {
            return;
        }
        if (this._parsingContext.getDupDetector() == null) {
            this._parsingContext = this._parsingContext.withDupDetector(DupDetector.rootDetector(this));
        } else {
            this._parsingContext = this._parsingContext.withDupDetector(null);
        }
    }

    public abstract void _closeInput() throws IOException;

    public ContentReference _contentReference() {
        return JsonParser.Feature.INCLUDE_SOURCE_IN_LOCATION.enabledIn(this._features) ? this._ioContext.contentReference() : _contentReferenceRedacted();
    }

    public ContentReference _contentReferenceRedacted() {
        return ContentReference.redacted();
    }

    public BigInteger _convertBigDecimalToBigInteger(BigDecimal bigDecimal) throws IOException {
        this._streamReadConstraints.validateBigIntegerScale(bigDecimal.scale());
        return bigDecimal.toBigInteger();
    }

    public final int _decodeBase64Escape(Base64Variant base64Variant, int i10, int i11) throws IOException {
        if (i10 != 92) {
            throw reportInvalidBase64Char(base64Variant, i10, i11);
        }
        char c_decodeEscaped = _decodeEscaped();
        if (c_decodeEscaped <= ' ' && i11 == 0) {
            return -1;
        }
        int iDecodeBase64Char = base64Variant.decodeBase64Char((int) c_decodeEscaped);
        if (iDecodeBase64Char >= 0 || iDecodeBase64Char == -2) {
            return iDecodeBase64Char;
        }
        throw reportInvalidBase64Char(base64Variant, c_decodeEscaped, i11);
    }

    public char _decodeEscaped() throws IOException {
        throw new UnsupportedOperationException();
    }

    public final int _eofAsNextChar() throws JsonParseException {
        _handleEOF();
        return -1;
    }

    public void _finishString() throws IOException {
    }

    public BigDecimal _getBigDecimal() throws JsonParseException {
        BigDecimal bigDecimal = this._numberBigDecimal;
        if (bigDecimal != null) {
            return bigDecimal;
        }
        String str = this._numberString;
        if (str == null) {
            throw new IllegalStateException("cannot get BigDecimal from current parser state");
        }
        try {
            this._numberBigDecimal = NumberInput.parseBigDecimal(str, isEnabled(StreamReadFeature.USE_FAST_BIG_NUMBER_PARSER));
        } catch (NumberFormatException e10) {
            _wrapError("Malformed numeric value (" + _longNumberDesc(this._numberString) + ")", e10);
        }
        this._numberString = null;
        return this._numberBigDecimal;
    }

    public BigInteger _getBigInteger() throws JsonParseException {
        BigInteger bigInteger = this._numberBigInt;
        if (bigInteger != null) {
            return bigInteger;
        }
        String str = this._numberString;
        if (str == null) {
            throw new IllegalStateException("cannot get BigInteger from current parser state");
        }
        try {
            this._numberBigInt = NumberInput.parseBigInteger(str, isEnabled(StreamReadFeature.USE_FAST_BIG_NUMBER_PARSER));
        } catch (NumberFormatException e10) {
            _wrapError("Malformed numeric value (" + _longNumberDesc(this._numberString) + ")", e10);
        }
        this._numberString = null;
        return this._numberBigInt;
    }

    public ByteArrayBuilder _getByteArrayBuilder() {
        ByteArrayBuilder byteArrayBuilder = this._byteArrayBuilder;
        if (byteArrayBuilder == null) {
            this._byteArrayBuilder = new ByteArrayBuilder();
        } else {
            byteArrayBuilder.reset();
        }
        return this._byteArrayBuilder;
    }

    public double _getNumberDouble() throws JsonParseException {
        String str = this._numberString;
        if (str != null) {
            try {
                this._numberDouble = NumberInput.parseDouble(str, isEnabled(StreamReadFeature.USE_FAST_DOUBLE_PARSER));
            } catch (NumberFormatException e10) {
                _wrapError("Malformed numeric value (" + _longNumberDesc(this._numberString) + ")", e10);
            }
            this._numberString = null;
        }
        return this._numberDouble;
    }

    public float _getNumberFloat() throws JsonParseException {
        String str = this._numberString;
        if (str != null) {
            try {
                this._numberFloat = NumberInput.parseFloat(str, isEnabled(StreamReadFeature.USE_FAST_DOUBLE_PARSER));
            } catch (NumberFormatException e10) {
                _wrapError("Malformed numeric value (" + _longNumberDesc(this._numberString) + ")", e10);
            }
            this._numberString = null;
        }
        return this._numberFloat;
    }

    @Deprecated
    public Object _getSourceReference() {
        if (JsonParser.Feature.INCLUDE_SOURCE_IN_LOCATION.enabledIn(this._features)) {
            return this._ioContext.contentReference().getRawContent();
        }
        return null;
    }

    public int[] _growNameDecodeBuffer(int[] iArr, int i10) throws StreamConstraintsException {
        this._streamReadConstraints.validateNameLength(iArr.length << 2);
        return growArrayBy(iArr, i10);
    }

    public void _handleBase64MissingPadding(Base64Variant base64Variant) throws IOException {
        _reportError(base64Variant.missingPaddingMessage());
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase
    public void _handleEOF() throws JsonParseException {
        if (this._parsingContext.inRoot()) {
            return;
        }
        _reportInvalidEOF(String.format(": expected close marker for %s (start marker at %s)", this._parsingContext.inArray() ? "Array" : "Object", this._parsingContext.startLocation(_contentReference())), null);
    }

    public char _handleUnrecognizedCharacterEscape(char c10) throws JsonProcessingException {
        if (isEnabled(JsonParser.Feature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER) || (c10 == '\'' && isEnabled(JsonParser.Feature.ALLOW_SINGLE_QUOTES))) {
            return c10;
        }
        throw _constructReadException("Unrecognized character escape " + ParserMinimalBase._getCharDesc(c10), _currentLocationMinusOne());
    }

    public int _parseIntValue() throws IOException {
        if (this._closed) {
            _reportError("Internal error: _parseNumericValue called when parser instance closed");
        }
        if (this._currToken != JsonToken.VALUE_NUMBER_INT || this._intLength > 9) {
            _parseNumericValue(1);
            if ((this._numTypesValid & 1) == 0) {
                convertNumberToInt();
            }
            return this._numberInt;
        }
        int iContentsAsInt = this._textBuffer.contentsAsInt(this._numberNegative);
        this._numberInt = iContentsAsInt;
        this._numTypesValid = 1;
        return iContentsAsInt;
    }

    public void _parseNumericValue(int i10) throws IOException {
        if (this._closed) {
            _reportError("Internal error: _parseNumericValue called when parser instance closed");
        }
        JsonToken jsonToken = this._currToken;
        if (jsonToken != JsonToken.VALUE_NUMBER_INT) {
            if (jsonToken == JsonToken.VALUE_NUMBER_FLOAT) {
                _parseSlowFloat(i10);
                return;
            } else {
                _reportError("Current token (%s) not numeric, can not use numeric value accessors", jsonToken);
                return;
            }
        }
        int i11 = this._intLength;
        if (i11 <= 9) {
            this._numberInt = this._textBuffer.contentsAsInt(this._numberNegative);
            this._numTypesValid = 1;
            return;
        }
        if (i11 > 18) {
            if (i11 == 19) {
                char[] textBuffer = this._textBuffer.getTextBuffer();
                int textOffset = this._textBuffer.getTextOffset();
                boolean z10 = this._numberNegative;
                if (z10) {
                    textOffset++;
                }
                if (NumberInput.inLongRange(textBuffer, textOffset, i11, z10)) {
                    this._numberLong = NumberInput.parseLong19(textBuffer, textOffset, this._numberNegative);
                    this._numTypesValid = 2;
                    return;
                }
            }
            _parseSlowInt(i10);
            return;
        }
        long jContentsAsLong = this._textBuffer.contentsAsLong(this._numberNegative);
        if (i11 == 10) {
            if (this._numberNegative) {
                if (jContentsAsLong >= -2147483648L) {
                    this._numberInt = (int) jContentsAsLong;
                    this._numTypesValid = 1;
                    return;
                }
            } else if (jContentsAsLong <= 2147483647L) {
                this._numberInt = (int) jContentsAsLong;
                this._numTypesValid = 1;
                return;
            }
        }
        this._numberLong = jContentsAsLong;
        this._numTypesValid = 2;
    }

    public void _releaseBuffers() throws IOException {
        this._textBuffer.releaseBuffers();
        char[] cArr = this._nameCopyBuffer;
        if (cArr != null) {
            this._nameCopyBuffer = null;
            this._ioContext.releaseNameCopyBuffer(cArr);
        }
    }

    public void _reportExtraEndMarker(int i10) throws JsonParseException {
        throw _constructReadException(String.format("Unexpected close marker '%s': no open %s to close", Character.valueOf((char) i10), i10 == 125 ? "Object" : "Array"), _currentLocationMinusOne());
    }

    public void _reportMismatchedEndMarker(int i10, char c10) throws JsonParseException {
        JsonReadContext parsingContext = getParsingContext();
        if (!parsingContext.inRoot()) {
            throw _constructReadException(String.format("Unexpected close marker '%s': expected '%c' (for %s starting at %s)", Character.valueOf((char) i10), Character.valueOf(c10), parsingContext.typeDesc(), parsingContext.startLocation(_contentReference())), _currentLocationMinusOne());
        }
        _reportExtraEndMarker(i10);
    }

    public void _reportTooLongIntegral(int i10, String str) throws IOException {
        if (i10 == 1) {
            reportOverflowInt(str);
        } else {
            reportOverflowLong(str);
        }
    }

    public void _throwUnquotedSpace(int i10, String str) throws JsonParseException {
        if (!isEnabled(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS) || i10 > 32) {
            throw _constructReadException("Illegal unquoted character (" + ParserMinimalBase._getCharDesc((char) i10) + "): has to be escaped using backslash to be included in " + str, _currentLocationMinusOne());
        }
    }

    public String _validJsonTokenList() throws IOException {
        return _validJsonValueList();
    }

    public String _validJsonValueList() throws IOException {
        return isEnabled(JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS) ? "(JSON String, Number (or 'NaN'/'+INF'/'-INF'), Array, Object or token 'null', 'true' or 'false')" : "(JSON String, Number, Array, Object or token 'null', 'true' or 'false')";
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public void assignCurrentValue(Object obj) {
        this._parsingContext.setCurrentValue(obj);
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this._closed) {
            return;
        }
        this._inputPtr = Math.max(this._inputPtr, this._inputEnd);
        this._closed = true;
        try {
            _closeInput();
        } finally {
            _releaseBuffers();
            this._ioContext.close();
        }
    }

    public void convertNumberToBigDecimal() throws IOException {
        int i10 = this._numTypesValid;
        if ((i10 & 8) != 0) {
            String text = this._numberString;
            if (text == null) {
                text = getText();
            }
            this._numberBigDecimal = NumberInput.parseBigDecimal(text, isEnabled(StreamReadFeature.USE_FAST_BIG_NUMBER_PARSER));
        } else if ((i10 & 4) != 0) {
            this._numberBigDecimal = new BigDecimal(_getBigInteger());
        } else if ((i10 & 2) != 0) {
            this._numberBigDecimal = BigDecimal.valueOf(this._numberLong);
        } else if ((i10 & 1) != 0) {
            this._numberBigDecimal = BigDecimal.valueOf(this._numberInt);
        } else {
            _throwInternal();
        }
        this._numTypesValid |= 16;
    }

    public void convertNumberToBigInteger() throws IOException {
        int i10 = this._numTypesValid;
        if ((i10 & 16) != 0) {
            this._numberBigInt = _convertBigDecimalToBigInteger(_getBigDecimal());
        } else if ((i10 & 2) != 0) {
            this._numberBigInt = BigInteger.valueOf(this._numberLong);
        } else if ((i10 & 1) != 0) {
            this._numberBigInt = BigInteger.valueOf(this._numberInt);
        } else if ((i10 & 8) == 0) {
            _throwInternal();
        } else if (this._numberString != null) {
            this._numberBigInt = _convertBigDecimalToBigInteger(_getBigDecimal());
        } else {
            this._numberBigInt = _convertBigDecimalToBigInteger(BigDecimal.valueOf(_getNumberDouble()));
        }
        this._numTypesValid |= 4;
    }

    public void convertNumberToDouble() throws IOException {
        int i10 = this._numTypesValid;
        if ((i10 & 16) != 0) {
            if (this._numberString != null) {
                this._numberDouble = _getNumberDouble();
            } else {
                this._numberDouble = _getBigDecimal().doubleValue();
            }
        } else if ((i10 & 4) != 0) {
            if (this._numberString != null) {
                this._numberDouble = _getNumberDouble();
            } else {
                this._numberDouble = _getBigInteger().doubleValue();
            }
        } else if ((i10 & 2) != 0) {
            this._numberDouble = this._numberLong;
        } else if ((i10 & 1) != 0) {
            this._numberDouble = this._numberInt;
        } else if ((i10 & 32) == 0) {
            _throwInternal();
        } else if (this._numberString != null) {
            this._numberDouble = _getNumberDouble();
        } else {
            this._numberDouble = _getNumberFloat();
        }
        this._numTypesValid |= 8;
    }

    public void convertNumberToFloat() throws IOException {
        int i10 = this._numTypesValid;
        if ((i10 & 16) != 0) {
            if (this._numberString != null) {
                this._numberFloat = _getNumberFloat();
            } else {
                this._numberFloat = _getBigDecimal().floatValue();
            }
        } else if ((i10 & 4) != 0) {
            if (this._numberString != null) {
                this._numberFloat = _getNumberFloat();
            } else {
                this._numberFloat = _getBigInteger().floatValue();
            }
        } else if ((i10 & 2) != 0) {
            this._numberFloat = this._numberLong;
        } else if ((i10 & 1) != 0) {
            this._numberFloat = this._numberInt;
        } else if ((i10 & 8) == 0) {
            _throwInternal();
        } else if (this._numberString != null) {
            this._numberFloat = _getNumberFloat();
        } else {
            this._numberFloat = (float) _getNumberDouble();
        }
        this._numTypesValid |= 32;
    }

    public void convertNumberToInt() throws IOException {
        int i10 = this._numTypesValid;
        if ((i10 & 2) != 0) {
            long j10 = this._numberLong;
            int i11 = (int) j10;
            if (i11 != j10) {
                reportOverflowInt(getText(), currentToken());
            }
            this._numberInt = i11;
        } else if ((i10 & 4) != 0) {
            BigInteger bigInteger_getBigInteger = _getBigInteger();
            if (ParserMinimalBase.BI_MIN_INT.compareTo(bigInteger_getBigInteger) > 0 || ParserMinimalBase.BI_MAX_INT.compareTo(bigInteger_getBigInteger) < 0) {
                reportOverflowInt();
            }
            this._numberInt = bigInteger_getBigInteger.intValue();
        } else if ((i10 & 8) != 0) {
            double d_getNumberDouble = _getNumberDouble();
            if (d_getNumberDouble < -2.147483648E9d || d_getNumberDouble > 2.147483647E9d) {
                reportOverflowInt();
            }
            this._numberInt = (int) d_getNumberDouble;
        } else if ((i10 & 16) != 0) {
            BigDecimal bigDecimal_getBigDecimal = _getBigDecimal();
            if (ParserMinimalBase.BD_MIN_INT.compareTo(bigDecimal_getBigDecimal) > 0 || ParserMinimalBase.BD_MAX_INT.compareTo(bigDecimal_getBigDecimal) < 0) {
                reportOverflowInt();
            }
            this._numberInt = bigDecimal_getBigDecimal.intValue();
        } else {
            _throwInternal();
        }
        this._numTypesValid |= 1;
    }

    public void convertNumberToLong() throws IOException {
        int i10 = this._numTypesValid;
        if ((i10 & 1) != 0) {
            this._numberLong = this._numberInt;
        } else if ((i10 & 4) != 0) {
            BigInteger bigInteger_getBigInteger = _getBigInteger();
            if (ParserMinimalBase.BI_MIN_LONG.compareTo(bigInteger_getBigInteger) > 0 || ParserMinimalBase.BI_MAX_LONG.compareTo(bigInteger_getBigInteger) < 0) {
                reportOverflowLong();
            }
            this._numberLong = bigInteger_getBigInteger.longValue();
        } else if ((i10 & 8) != 0) {
            double d_getNumberDouble = _getNumberDouble();
            if (d_getNumberDouble < -9.223372036854776E18d || d_getNumberDouble > 9.223372036854776E18d) {
                reportOverflowLong();
            }
            this._numberLong = (long) d_getNumberDouble;
        } else if ((i10 & 16) != 0) {
            BigDecimal bigDecimal_getBigDecimal = _getBigDecimal();
            if (ParserMinimalBase.BD_MIN_LONG.compareTo(bigDecimal_getBigDecimal) > 0 || ParserMinimalBase.BD_MAX_LONG.compareTo(bigDecimal_getBigDecimal) < 0) {
                reportOverflowLong();
            }
            this._numberLong = bigDecimal_getBigDecimal.longValue();
        } else {
            _throwInternal();
        }
        this._numTypesValid |= 2;
    }

    public void createChildArrayContext(int i10, int i11) throws IOException {
        JsonReadContext jsonReadContextCreateChildArrayContext = this._parsingContext.createChildArrayContext(i10, i11);
        this._parsingContext = jsonReadContextCreateChildArrayContext;
        this._streamReadConstraints.validateNestingDepth(jsonReadContextCreateChildArrayContext.getNestingDepth());
    }

    public void createChildObjectContext(int i10, int i11) throws IOException {
        JsonReadContext jsonReadContextCreateChildObjectContext = this._parsingContext.createChildObjectContext(i10, i11);
        this._parsingContext = jsonReadContextCreateChildObjectContext;
        this._streamReadConstraints.validateNestingDepth(jsonReadContextCreateChildObjectContext.getNestingDepth());
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public Object currentValue() {
        return this._parsingContext.getCurrentValue();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public JsonParser disable(JsonParser.Feature feature) {
        this._features &= ~feature.getMask();
        if (feature == JsonParser.Feature.STRICT_DUPLICATE_DETECTION) {
            this._parsingContext = this._parsingContext.withDupDetector(null);
        }
        return this;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public JsonParser enable(JsonParser.Feature feature) {
        this._features |= feature.getMask();
        if (feature == JsonParser.Feature.STRICT_DUPLICATE_DETECTION && this._parsingContext.getDupDetector() == null) {
            this._parsingContext = this._parsingContext.withDupDetector(DupDetector.rootDetector(this));
        }
        return this;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public BigInteger getBigIntegerValue() throws IOException {
        int i10 = this._numTypesValid;
        if ((i10 & 4) == 0) {
            if (i10 == 0) {
                _parseNumericValue(4);
            }
            if ((this._numTypesValid & 4) == 0) {
                convertNumberToBigInteger();
                return this._numberBigInt;
            }
        }
        return _getBigInteger();
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public byte[] getBinaryValue(Base64Variant base64Variant) throws IOException {
        if (this._binaryValue == null) {
            if (this._currToken != JsonToken.VALUE_STRING) {
                _reportError("Current token (" + this._currToken + ") not VALUE_STRING, can not access as binary");
            }
            ByteArrayBuilder byteArrayBuilder_getByteArrayBuilder = _getByteArrayBuilder();
            _decodeBase64(getText(), byteArrayBuilder_getByteArrayBuilder, base64Variant);
            this._binaryValue = byteArrayBuilder_getByteArrayBuilder.toByteArray();
        }
        return this._binaryValue;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    @Deprecated
    public JsonLocation getCurrentLocation() {
        return new JsonLocation(_contentReference(), -1L, this._inputPtr + this._currInputProcessed, this._currInputRow, (this._inputPtr - this._currInputRowStart) + 1);
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    @Deprecated
    public String getCurrentName() throws IOException {
        JsonReadContext parent;
        JsonToken jsonToken = this._currToken;
        return ((jsonToken == JsonToken.START_OBJECT || jsonToken == JsonToken.START_ARRAY) && (parent = this._parsingContext.getParent()) != null) ? parent.getCurrentName() : this._parsingContext.getCurrentName();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public BigDecimal getDecimalValue() throws IOException {
        int i10 = this._numTypesValid;
        if ((i10 & 16) == 0) {
            if (i10 == 0) {
                _parseNumericValue(16);
            }
            if ((this._numTypesValid & 16) == 0) {
                convertNumberToBigDecimal();
                return this._numberBigDecimal;
            }
        }
        return _getBigDecimal();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public double getDoubleValue() throws IOException {
        int i10 = this._numTypesValid;
        if ((i10 & 8) == 0) {
            if (i10 == 0) {
                _parseNumericValue(8);
            }
            if ((this._numTypesValid & 8) == 0) {
                convertNumberToDouble();
                return this._numberDouble;
            }
        }
        return _getNumberDouble();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public float getFloatValue() throws IOException {
        int i10 = this._numTypesValid;
        if ((i10 & 32) == 0) {
            if (i10 == 0) {
                _parseNumericValue(32);
            }
            if ((this._numTypesValid & 32) == 0) {
                convertNumberToFloat();
                return this._numberFloat;
            }
        }
        return _getNumberFloat();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public int getIntValue() throws IOException {
        int i10 = this._numTypesValid;
        if ((i10 & 1) == 0) {
            if (i10 == 0) {
                return _parseIntValue();
            }
            if ((i10 & 1) == 0) {
                convertNumberToInt();
            }
        }
        return this._numberInt;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public long getLongValue() throws IOException {
        int i10 = this._numTypesValid;
        if ((i10 & 2) == 0) {
            if (i10 == 0) {
                _parseNumericValue(2);
            }
            if ((this._numTypesValid & 2) == 0) {
                convertNumberToLong();
            }
        }
        return this._numberLong;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public JsonParser.NumberType getNumberType() throws IOException {
        if (this._numTypesValid == 0) {
            _parseNumericValue(0);
        }
        if (this._currToken == JsonToken.VALUE_NUMBER_INT) {
            int i10 = this._numTypesValid;
            return (i10 & 1) != 0 ? JsonParser.NumberType.INT : (i10 & 2) != 0 ? JsonParser.NumberType.LONG : JsonParser.NumberType.BIG_INTEGER;
        }
        int i11 = this._numTypesValid;
        return (i11 & 16) != 0 ? JsonParser.NumberType.BIG_DECIMAL : (i11 & 32) != 0 ? JsonParser.NumberType.FLOAT : JsonParser.NumberType.DOUBLE;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public Number getNumberValue() throws IOException {
        if (this._numTypesValid == 0) {
            _parseNumericValue(0);
        }
        if (this._currToken == JsonToken.VALUE_NUMBER_INT) {
            int i10 = this._numTypesValid;
            if ((i10 & 1) != 0) {
                return Integer.valueOf(this._numberInt);
            }
            if ((i10 & 2) != 0) {
                return Long.valueOf(this._numberLong);
            }
            if ((i10 & 4) != 0) {
                return _getBigInteger();
            }
            _throwInternal();
        }
        int i11 = this._numTypesValid;
        if ((i11 & 16) != 0) {
            return _getBigDecimal();
        }
        if ((i11 & 32) != 0) {
            return Float.valueOf(_getNumberFloat());
        }
        if ((i11 & 8) == 0) {
            _throwInternal();
        }
        return Double.valueOf(_getNumberDouble());
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public Object getNumberValueDeferred() throws IOException {
        if (this._currToken == JsonToken.VALUE_NUMBER_INT) {
            if (this._numTypesValid == 0) {
                _parseNumericValue(0);
            }
            int i10 = this._numTypesValid;
            if ((i10 & 1) != 0) {
                return Integer.valueOf(this._numberInt);
            }
            if ((i10 & 2) != 0) {
                return Long.valueOf(this._numberLong);
            }
            if ((i10 & 4) != 0) {
                BigInteger bigInteger = this._numberBigInt;
                if (bigInteger != null) {
                    return bigInteger;
                }
                String str = this._numberString;
                return str != null ? str : _getBigInteger();
            }
            _throwInternal();
        }
        if (this._currToken != JsonToken.VALUE_NUMBER_FLOAT) {
            return getNumberValue();
        }
        int i11 = this._numTypesValid;
        return (i11 & 16) != 0 ? _getBigDecimal() : (i11 & 8) != 0 ? Double.valueOf(_getNumberDouble()) : (i11 & 32) != 0 ? Float.valueOf(_getNumberFloat()) : this._textBuffer.contentsAsString();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public Number getNumberValueExact() throws IOException {
        if (this._currToken == JsonToken.VALUE_NUMBER_INT) {
            if (this._numTypesValid == 0) {
                _parseNumericValue(0);
            }
            int i10 = this._numTypesValid;
            if ((i10 & 1) != 0) {
                return Integer.valueOf(this._numberInt);
            }
            if ((i10 & 2) != 0) {
                return Long.valueOf(this._numberLong);
            }
            if ((i10 & 4) != 0) {
                return _getBigInteger();
            }
            _throwInternal();
        }
        if (this._numTypesValid == 0) {
            _parseNumericValue(16);
        }
        int i11 = this._numTypesValid;
        if ((i11 & 16) != 0) {
            return _getBigDecimal();
        }
        if ((i11 & 32) != 0) {
            return Float.valueOf(_getNumberFloat());
        }
        if ((i11 & 8) == 0) {
            _throwInternal();
        }
        return Double.valueOf(_getNumberDouble());
    }

    public long getTokenCharacterOffset() {
        return this._tokenInputTotal;
    }

    public int getTokenColumnNr() {
        int i10 = this._tokenInputCol;
        return i10 < 0 ? i10 : i10 + 1;
    }

    public int getTokenLineNr() {
        return this._tokenInputRow;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    @Deprecated
    public JsonLocation getTokenLocation() {
        return new JsonLocation(_contentReference(), -1L, getTokenCharacterOffset(), getTokenLineNr(), getTokenColumnNr());
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public boolean hasTextCharacters() {
        JsonToken jsonToken = this._currToken;
        if (jsonToken == JsonToken.VALUE_STRING) {
            return true;
        }
        if (jsonToken == JsonToken.FIELD_NAME) {
            return this._nameCopied;
        }
        return false;
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public boolean isClosed() {
        return this._closed;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public boolean isNaN() throws IOException {
        return this._currToken == JsonToken.VALUE_NUMBER_FLOAT && this._numberIsNaN;
    }

    @Deprecated
    public boolean loadMore() throws IOException {
        return false;
    }

    @Deprecated
    public void loadMoreGuaranteed() throws IOException {
        if (loadMore()) {
            return;
        }
        _reportInvalidEOF();
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public void overrideCurrentName(String str) {
        JsonReadContext parent = this._parsingContext;
        JsonToken jsonToken = this._currToken;
        if (jsonToken == JsonToken.START_OBJECT || jsonToken == JsonToken.START_ARRAY) {
            parent = parent.getParent();
        }
        try {
            parent.setCurrentName(str);
        } catch (IOException e10) {
            throw new IllegalStateException(e10);
        }
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public JsonParser overrideStdFeatures(int i10, int i11) {
        int i12 = this._features;
        int i13 = (i10 & i11) | ((~i11) & i12);
        int i14 = i12 ^ i13;
        if (i14 != 0) {
            this._features = i13;
            _checkStdFeatureChanges(i13, i14);
        }
        return this;
    }

    public IllegalArgumentException reportInvalidBase64Char(Base64Variant base64Variant, int i10, int i11) throws IllegalArgumentException {
        return reportInvalidBase64Char(base64Variant, i10, i11, null);
    }

    public final JsonToken reset(boolean z10, int i10, int i11, int i12) throws IOException {
        return (i11 >= 1 || i12 >= 1) ? resetFloat(z10, i10, i11, i12) : resetInt(z10, i10);
    }

    public final JsonToken resetAsNaN(String str, double d10) throws IOException {
        this._textBuffer.resetWithString(str);
        this._numberDouble = d10;
        this._numTypesValid = 8;
        this._numberIsNaN = true;
        this._numberString = null;
        return JsonToken.VALUE_NUMBER_FLOAT;
    }

    public final JsonToken resetFloat(boolean z10, int i10, int i11, int i12) throws IOException {
        this._streamReadConstraints.validateFPLength(i10 + i11 + i12);
        this._numberNegative = z10;
        this._numberIsNaN = false;
        this._intLength = i10;
        this._fractLength = i11;
        this._expLength = i12;
        this._numTypesValid = 0;
        this._numberString = null;
        return JsonToken.VALUE_NUMBER_FLOAT;
    }

    public final JsonToken resetInt(boolean z10, int i10) throws IOException {
        this._streamReadConstraints.validateIntegerLength(i10);
        this._numberNegative = z10;
        this._numberIsNaN = false;
        this._intLength = i10;
        this._fractLength = 0;
        this._expLength = 0;
        this._numTypesValid = 0;
        this._numberString = null;
        return JsonToken.VALUE_NUMBER_INT;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    @Deprecated
    public JsonParser setFeatureMask(int i10) {
        int i11 = this._features ^ i10;
        if (i11 != 0) {
            this._features = i10;
            _checkStdFeatureChanges(i10, i11);
        }
        return this;
    }

    @Override // com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.core.Versioned
    public Version version() {
        return PackageVersion.VERSION;
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public JsonReadContext getParsingContext() {
        return this._parsingContext;
    }

    public IllegalArgumentException reportInvalidBase64Char(Base64Variant base64Variant, int i10, int i11, String str) throws IllegalArgumentException {
        String str2;
        if (i10 <= 32) {
            str2 = String.format("Illegal white space character (code 0x%s) as character #%d of 4-char base64 unit: can only used between units", Integer.toHexString(i10), Integer.valueOf(i11 + 1));
        } else if (base64Variant.usesPaddingChar(i10)) {
            str2 = "Unexpected padding character ('" + base64Variant.getPaddingChar() + "') as character #" + (i11 + 1) + " of 4-char base64 unit: padding only legal as 3rd or 4th character";
        } else if (!Character.isDefined(i10) || Character.isISOControl(i10)) {
            str2 = "Illegal character (code 0x" + Integer.toHexString(i10) + ") in base64 content";
        } else {
            str2 = "Illegal character '" + ((char) i10) + "' (code 0x" + Integer.toHexString(i10) + ") in base64 content";
        }
        if (str != null) {
            str2 = str2 + ": " + str;
        }
        return new IllegalArgumentException(str2);
    }

    public final int _decodeBase64Escape(Base64Variant base64Variant, char c10, int i10) throws IOException {
        if (c10 == '\\') {
            char c_decodeEscaped = _decodeEscaped();
            if (c_decodeEscaped <= ' ' && i10 == 0) {
                return -1;
            }
            int iDecodeBase64Char = base64Variant.decodeBase64Char(c_decodeEscaped);
            if (iDecodeBase64Char >= 0 || (iDecodeBase64Char == -2 && i10 >= 2)) {
                return iDecodeBase64Char;
            }
            throw reportInvalidBase64Char(base64Variant, c_decodeEscaped, i10);
        }
        throw reportInvalidBase64Char(base64Variant, c10, i10);
    }
}
