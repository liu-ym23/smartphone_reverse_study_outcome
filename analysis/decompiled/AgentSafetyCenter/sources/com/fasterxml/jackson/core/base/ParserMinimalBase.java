package com.fasterxml.jackson.core.base;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.StreamReadConstraints;
import com.fasterxml.jackson.core.exc.InputCoercionException;
import com.fasterxml.jackson.core.exc.StreamConstraintsException;
import com.fasterxml.jackson.core.io.JsonEOFException;
import com.fasterxml.jackson.core.io.NumberInput;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import com.fasterxml.jackson.core.util.VersionUtil;
import com.google.crypto.tink.shaded.protobuf.Reader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import k0.a;
import w2.c;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class ParserMinimalBase extends JsonParser {
    protected static final BigDecimal BD_MAX_INT;
    protected static final BigDecimal BD_MAX_LONG;
    protected static final BigDecimal BD_MIN_INT;
    protected static final BigDecimal BD_MIN_LONG;
    protected static final BigInteger BI_MAX_INT;
    protected static final BigInteger BI_MAX_LONG;
    protected static final BigInteger BI_MIN_INT;
    protected static final BigInteger BI_MIN_LONG;
    protected static final char CHAR_NULL = 0;
    protected static final int INT_0 = 48;
    protected static final int INT_9 = 57;
    protected static final int INT_APOS = 39;
    protected static final int INT_ASTERISK = 42;
    protected static final int INT_BACKSLASH = 92;
    protected static final int INT_COLON = 58;
    protected static final int INT_COMMA = 44;
    protected static final int INT_CR = 13;
    protected static final int INT_E = 69;
    protected static final int INT_HASH = 35;
    protected static final int INT_LBRACKET = 91;
    protected static final int INT_LCURLY = 123;
    protected static final int INT_LF = 10;
    protected static final int INT_MINUS = 45;
    protected static final int INT_PERIOD = 46;
    protected static final int INT_PLUS = 43;
    protected static final int INT_QUOTE = 34;
    protected static final int INT_RBRACKET = 93;
    protected static final int INT_RCURLY = 125;
    protected static final int INT_RS = 30;
    protected static final int INT_SLASH = 47;
    protected static final int INT_SPACE = 32;
    protected static final int INT_TAB = 9;
    protected static final int INT_e = 101;

    @Deprecated
    protected static final int MAX_ERROR_TOKEN_LENGTH = 256;
    protected static final double MAX_INT_D = 2.147483647E9d;
    protected static final long MAX_INT_L = 2147483647L;
    protected static final double MAX_LONG_D = 9.223372036854776E18d;
    protected static final double MIN_INT_D = -2.147483648E9d;
    protected static final long MIN_INT_L = -2147483648L;
    protected static final double MIN_LONG_D = -9.223372036854776E18d;
    protected static final byte[] NO_BYTES = new byte[0];
    protected static final int[] NO_INTS = new int[0];
    protected static final int NR_BIGDECIMAL = 16;
    protected static final int NR_BIGINT = 4;
    protected static final int NR_DOUBLE = 8;
    protected static final int NR_FLOAT = 32;
    protected static final int NR_INT = 1;
    protected static final int NR_LONG = 2;
    protected static final int NR_UNKNOWN = 0;
    protected JsonToken _currToken;
    protected JsonToken _lastClearedToken;
    protected final StreamReadConstraints _streamReadConstraints;
    protected long _tokenCount;
    protected final boolean _trackMaxTokenCount;

    static {
        BigInteger bigIntegerValueOf = BigInteger.valueOf(MIN_INT_L);
        BI_MIN_INT = bigIntegerValueOf;
        BigInteger bigIntegerValueOf2 = BigInteger.valueOf(MAX_INT_L);
        BI_MAX_INT = bigIntegerValueOf2;
        BigInteger bigIntegerValueOf3 = BigInteger.valueOf(Long.MIN_VALUE);
        BI_MIN_LONG = bigIntegerValueOf3;
        BigInteger bigIntegerValueOf4 = BigInteger.valueOf(Long.MAX_VALUE);
        BI_MAX_LONG = bigIntegerValueOf4;
        BD_MIN_LONG = new BigDecimal(bigIntegerValueOf3);
        BD_MAX_LONG = new BigDecimal(bigIntegerValueOf4);
        BD_MIN_INT = new BigDecimal(bigIntegerValueOf);
        BD_MAX_INT = new BigDecimal(bigIntegerValueOf2);
    }

    public ParserMinimalBase(StreamReadConstraints streamReadConstraints) {
        streamReadConstraints = streamReadConstraints == null ? StreamReadConstraints.defaults() : streamReadConstraints;
        this._streamReadConstraints = streamReadConstraints;
        this._trackMaxTokenCount = streamReadConstraints.hasMaxTokenCount();
    }

    @Deprecated
    public static String _ascii(byte[] bArr) {
        return new String(bArr, StandardCharsets.US_ASCII);
    }

    @Deprecated
    public static byte[] _asciiBytes(String str) {
        byte[] bArr = new byte[str.length()];
        int length = str.length();
        for (int i = 0; i < length; i++) {
            bArr[i] = (byte) str.charAt(i);
        }
        return bArr;
    }

    public static final String _getCharDesc(int i) {
        char c9 = (char) i;
        if (Character.isISOControl(c9)) {
            return a.k(i, "(CTRL-CHAR, code ", ")");
        }
        if (i <= 255) {
            return "'" + c9 + "' (code " + i + ")";
        }
        return "'" + c9 + "' (code " + i + " / 0x" + Integer.toHexString(i) + ")";
    }

    public final JsonParseException _constructError(String str, Throwable th) {
        return _constructReadException(str, th);
    }

    public JsonLocation _currentLocationMinusOne() {
        return currentLocation();
    }

    public void _decodeBase64(String str, ByteArrayBuilder byteArrayBuilder, Base64Variant base64Variant) {
        try {
            base64Variant.decode(str, byteArrayBuilder);
        } catch (IllegalArgumentException e10) {
            _reportError(e10.getMessage());
        }
    }

    public abstract void _handleEOF();

    public boolean _hasTextualNull(String str) {
        return "null".equals(str);
    }

    public String _longIntegerDesc(String str) {
        int length = str.length();
        if (length < 1000) {
            return str;
        }
        if (str.startsWith("-")) {
            length--;
        }
        return String.format("[Integer with %d digits]", Integer.valueOf(length));
    }

    public String _longNumberDesc(String str) {
        int length = str.length();
        if (length < 1000) {
            return str;
        }
        if (str.startsWith("-")) {
            length--;
        }
        return String.format("[number with %d characters]", Integer.valueOf(length));
    }

    public final JsonToken _nullSafeUpdateToken(JsonToken jsonToken) throws StreamConstraintsException {
        this._currToken = jsonToken;
        if (this._trackMaxTokenCount && jsonToken != null) {
            StreamReadConstraints streamReadConstraints = this._streamReadConstraints;
            long j10 = this._tokenCount + 1;
            this._tokenCount = j10;
            streamReadConstraints.validateTokenCount(j10);
        }
        return jsonToken;
    }

    public final void _reportError(String str) {
        throw _constructReadException(str);
    }

    public void _reportInputCoercion(String str, JsonToken jsonToken, Class<?> cls) throws InputCoercionException {
        throw new InputCoercionException(this, str, jsonToken, cls);
    }

    public void _reportInvalidEOF() {
        _reportInvalidEOF(" in " + this._currToken, this._currToken);
    }

    public void _reportInvalidEOFInValue(JsonToken jsonToken) {
        _reportInvalidEOF(jsonToken == JsonToken.VALUE_STRING ? " in a String value" : (jsonToken == JsonToken.VALUE_NUMBER_INT || jsonToken == JsonToken.VALUE_NUMBER_FLOAT) ? " in a Number value" : " in a value", jsonToken);
    }

    public void _reportMissingRootWS(int i) {
        _reportUnexpectedChar(i, "Expected space separating root-level values");
    }

    public void _reportUnexpectedChar(int i, String str) {
        if (i < 0) {
            _reportInvalidEOF();
        }
        String strC = a.C("Unexpected character (", _getCharDesc(i), ")");
        if (str != null) {
            strC = a.o(strC, ": ", str);
        }
        throw _constructReadException(strC, _currentLocationMinusOne());
    }

    public <T> T _reportUnexpectedNumberChar(int i, String str) {
        String strC = a.C("Unexpected character (", _getCharDesc(i), ") in numeric value");
        if (str != null) {
            strC = a.o(strC, ": ", str);
        }
        throw _constructReadException(strC, _currentLocationMinusOne());
    }

    public final void _throwInternal() {
        VersionUtil.throwInternal();
    }

    public final <T> T _throwInternalReturnAny() {
        return (T) VersionUtil.throwInternalReturnAny();
    }

    public void _throwInvalidSpace(int i) {
        String strConcat = "Illegal character (" + _getCharDesc((char) i) + "): only regular white space (\\r, \\n, \\t) is allowed between tokens";
        if (i == 30) {
            strConcat = strConcat.concat(" (consider enabling `JsonReadFeature.ALLOW_RS_CONTROL_CHAR` to allow use of Record Separators (\\u001E))");
        }
        throw _constructReadException(strConcat);
    }

    public final JsonToken _updateToken(JsonToken jsonToken) {
        this._currToken = jsonToken;
        if (this._trackMaxTokenCount) {
            StreamReadConstraints streamReadConstraints = this._streamReadConstraints;
            long j10 = this._tokenCount + 1;
            this._tokenCount = j10;
            streamReadConstraints.validateTokenCount(j10);
        }
        return jsonToken;
    }

    public final JsonToken _updateTokenToNA() {
        JsonToken jsonToken = JsonToken.NOT_AVAILABLE;
        this._currToken = jsonToken;
        return jsonToken;
    }

    public final JsonToken _updateTokenToNull() {
        this._currToken = null;
        return null;
    }

    public final void _wrapError(String str, Throwable th) throws JsonParseException {
        throw _constructReadException(str, th);
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public void clearCurrentToken() {
        JsonToken jsonToken = this._currToken;
        if (jsonToken != null) {
            this._lastClearedToken = jsonToken;
            this._currToken = null;
        }
    }

    @Override // com.fasterxml.jackson.core.JsonParser, java.io.Closeable, java.lang.AutoCloseable
    public abstract void close();

    @Override // com.fasterxml.jackson.core.JsonParser
    public JsonToken currentToken() {
        return this._currToken;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public long currentTokenCount() {
        return this._tokenCount;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public int currentTokenId() {
        JsonToken jsonToken = this._currToken;
        if (jsonToken == null) {
            return 0;
        }
        return jsonToken.id();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public abstract byte[] getBinaryValue(Base64Variant base64Variant);

    @Override // com.fasterxml.jackson.core.JsonParser
    @Deprecated
    public abstract String getCurrentName();

    @Override // com.fasterxml.jackson.core.JsonParser
    public JsonToken getCurrentToken() {
        return this._currToken;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    @Deprecated
    public int getCurrentTokenId() {
        JsonToken jsonToken = this._currToken;
        if (jsonToken == null) {
            return 0;
        }
        return jsonToken.id();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public JsonToken getLastClearedToken() {
        return this._lastClearedToken;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public abstract JsonStreamContext getParsingContext();

    @Override // com.fasterxml.jackson.core.JsonParser
    public abstract String getText();

    @Override // com.fasterxml.jackson.core.JsonParser
    public abstract char[] getTextCharacters();

    @Override // com.fasterxml.jackson.core.JsonParser
    public abstract int getTextLength();

    @Override // com.fasterxml.jackson.core.JsonParser
    public abstract int getTextOffset();

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.fasterxml.jackson.core.JsonParser
    public boolean getValueAsBoolean(boolean z10) {
        JsonToken jsonToken = this._currToken;
        if (jsonToken != null) {
            switch (jsonToken.id()) {
                case 6:
                    String strTrim = getText().trim();
                    if ("true".equals(strTrim)) {
                        return true;
                    }
                    if ("false".equals(strTrim) || _hasTextualNull(strTrim)) {
                        return false;
                    }
                    break;
                case 7:
                    return getIntValue() != 0;
                case 9:
                    return true;
                case 10:
                case 11:
                    return false;
                case 12:
                    Object embeddedObject = getEmbeddedObject();
                    if (embeddedObject instanceof Boolean) {
                        return ((Boolean) embeddedObject).booleanValue();
                    }
                    break;
            }
        }
        return z10;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public double getValueAsDouble(double d7) throws StreamConstraintsException {
        JsonToken jsonToken = this._currToken;
        if (jsonToken != null) {
            switch (jsonToken.id()) {
                case 6:
                    String text = getText();
                    if (_hasTextualNull(text)) {
                        return 0.0d;
                    }
                    this._streamReadConstraints.validateFPLength(text.length());
                    return NumberInput.parseAsDouble(text, d7);
                case 7:
                case 8:
                    return getDoubleValue();
                case 9:
                    return 1.0d;
                case 10:
                case 11:
                    return 0.0d;
                case 12:
                    Object embeddedObject = getEmbeddedObject();
                    if (embeddedObject instanceof Number) {
                        return ((Number) embeddedObject).doubleValue();
                    }
                default:
                    return d7;
            }
        }
        return d7;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public int getValueAsInt(int i) {
        JsonToken jsonToken = this._currToken;
        if (jsonToken == JsonToken.VALUE_NUMBER_INT || jsonToken == JsonToken.VALUE_NUMBER_FLOAT) {
            return getIntValue();
        }
        if (jsonToken != null) {
            int iId = jsonToken.id();
            if (iId == 6) {
                String text = getText();
                if (_hasTextualNull(text)) {
                    return 0;
                }
                return NumberInput.parseAsInt(text, i);
            }
            switch (iId) {
                case 9:
                    return 1;
                case 10:
                case 11:
                    return 0;
                case 12:
                    Object embeddedObject = getEmbeddedObject();
                    if (embeddedObject instanceof Number) {
                        return ((Number) embeddedObject).intValue();
                    }
                default:
                    return i;
            }
        }
        return i;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public long getValueAsLong(long j10) {
        JsonToken jsonToken = this._currToken;
        if (jsonToken == JsonToken.VALUE_NUMBER_INT || jsonToken == JsonToken.VALUE_NUMBER_FLOAT) {
            return getLongValue();
        }
        if (jsonToken != null) {
            int iId = jsonToken.id();
            if (iId == 6) {
                String text = getText();
                if (_hasTextualNull(text)) {
                    return 0L;
                }
                return NumberInput.parseAsLong(text, j10);
            }
            switch (iId) {
                case 9:
                    return 1L;
                case 10:
                case 11:
                    return 0L;
                case 12:
                    Object embeddedObject = getEmbeddedObject();
                    if (embeddedObject instanceof Number) {
                        return ((Number) embeddedObject).longValue();
                    }
                default:
                    return j10;
            }
        }
        return j10;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public String getValueAsString(String str) {
        JsonToken jsonToken = this._currToken;
        return jsonToken == JsonToken.VALUE_STRING ? getText() : jsonToken == JsonToken.FIELD_NAME ? currentName() : (jsonToken == null || jsonToken == JsonToken.VALUE_NULL || !jsonToken.isScalarValue()) ? str : getText();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public boolean hasCurrentToken() {
        return this._currToken != null;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public abstract boolean hasTextCharacters();

    @Override // com.fasterxml.jackson.core.JsonParser
    public boolean hasToken(JsonToken jsonToken) {
        return this._currToken == jsonToken;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public boolean hasTokenId(int i) {
        JsonToken jsonToken = this._currToken;
        return jsonToken == null ? i == 0 : jsonToken.id() == i;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public abstract boolean isClosed();

    @Override // com.fasterxml.jackson.core.JsonParser
    public boolean isExpectedNumberIntToken() {
        return this._currToken == JsonToken.VALUE_NUMBER_INT;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public boolean isExpectedStartArrayToken() {
        return this._currToken == JsonToken.START_ARRAY;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public boolean isExpectedStartObjectToken() {
        return this._currToken == JsonToken.START_OBJECT;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public abstract JsonToken nextToken();

    @Override // com.fasterxml.jackson.core.JsonParser
    public JsonToken nextValue() {
        JsonToken jsonTokenNextToken = nextToken();
        return jsonTokenNextToken == JsonToken.FIELD_NAME ? nextToken() : jsonTokenNextToken;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public abstract void overrideCurrentName(String str);

    public void reportInvalidNumber(String str) {
        throw _constructReadException("Invalid numeric value: " + str);
    }

    public void reportOverflowInt(String str, JsonToken jsonToken) throws InputCoercionException {
        _reportInputCoercion(String.format("Numeric value (%s) out of range of int (%d - %s)", _longIntegerDesc(str), Integer.MIN_VALUE, Integer.valueOf(Reader.READ_DONE)), jsonToken, Integer.TYPE);
    }

    public void reportOverflowLong(String str, JsonToken jsonToken) throws InputCoercionException {
        _reportInputCoercion(String.format("Numeric value (%s) out of range of long (%d - %s)", _longIntegerDesc(str), Long.MIN_VALUE, Long.MAX_VALUE), jsonToken, Long.TYPE);
    }

    @Deprecated
    public void reportUnexpectedNumberChar(int i, String str) {
        _reportUnexpectedNumberChar(i, str);
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public JsonParser skipChildren() {
        JsonToken jsonToken = this._currToken;
        if (jsonToken == JsonToken.START_OBJECT || jsonToken == JsonToken.START_ARRAY) {
            int i = 1;
            while (true) {
                JsonToken jsonTokenNextToken = nextToken();
                if (jsonTokenNextToken == null) {
                    _handleEOF();
                    return this;
                }
                if (jsonTokenNextToken.isStructStart()) {
                    i++;
                } else if (jsonTokenNextToken.isStructEnd()) {
                    i--;
                    if (i == 0) {
                        break;
                    }
                } else if (jsonTokenNextToken == JsonToken.NOT_AVAILABLE) {
                    _reportError("Not enough content available for `skipChildren()`: non-blocking parser? (%s)", getClass().getName());
                }
            }
        }
        return this;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public StreamReadConstraints streamReadConstraints() {
        return this._streamReadConstraints;
    }

    public final void _reportError(String str, Object obj) {
        throw _constructReadException(str, obj);
    }

    public final void _reportError(String str, Object obj, Object obj2) {
        throw _constructReadException(str, obj, obj2);
    }

    @Deprecated
    public ParserMinimalBase(int i) {
        this(i, null);
    }

    @Deprecated
    public ParserMinimalBase() {
        StreamReadConstraints streamReadConstraintsDefaults = StreamReadConstraints.defaults();
        this._streamReadConstraints = streamReadConstraintsDefaults;
        this._trackMaxTokenCount = streamReadConstraintsDefaults.hasMaxTokenCount();
    }

    public ParserMinimalBase(int i, StreamReadConstraints streamReadConstraints) {
        super(i);
        streamReadConstraints = streamReadConstraints == null ? StreamReadConstraints.defaults() : streamReadConstraints;
        this._streamReadConstraints = streamReadConstraints;
        this._trackMaxTokenCount = streamReadConstraints.hasMaxTokenCount();
    }

    public void _reportInvalidEOF(String str, JsonToken jsonToken) {
        throw new JsonEOFException(this, jsonToken, c.b("Unexpected end-of-input", str));
    }

    public void reportOverflowInt(String str) throws InputCoercionException {
        reportOverflowInt(str, currentToken());
    }

    public void reportOverflowInt() {
        reportOverflowInt(getText());
    }

    public void reportOverflowLong(String str) throws InputCoercionException {
        reportOverflowLong(str, currentToken());
    }

    public void reportOverflowLong() {
        reportOverflowLong(getText());
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public String getValueAsString() {
        return getValueAsString(null);
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public int getValueAsInt() {
        JsonToken jsonToken = this._currToken;
        if (jsonToken != JsonToken.VALUE_NUMBER_INT && jsonToken != JsonToken.VALUE_NUMBER_FLOAT) {
            return getValueAsInt(0);
        }
        return getIntValue();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public long getValueAsLong() {
        JsonToken jsonToken = this._currToken;
        if (jsonToken != JsonToken.VALUE_NUMBER_INT && jsonToken != JsonToken.VALUE_NUMBER_FLOAT) {
            return getValueAsLong(0L);
        }
        return getLongValue();
    }
}
