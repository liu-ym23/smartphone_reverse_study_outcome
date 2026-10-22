package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.async.NonBlockingInputFeeder;
import com.fasterxml.jackson.core.exc.InputCoercionException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.JacksonFeatureSet;
import com.fasterxml.jackson.core.util.RequestPayload;
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Iterator;
import k0.a;
import od.f;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class JsonParser implements Closeable, Versioned {
    protected static final JacksonFeatureSet<StreamReadCapability> DEFAULT_READ_CAPABILITIES = JacksonFeatureSet.fromDefaults(StreamReadCapability.values());
    private static final int MAX_BYTE_I = 255;
    private static final int MAX_SHORT_I = 32767;
    private static final int MIN_BYTE_I = -128;
    private static final int MIN_SHORT_I = -32768;
    protected int _features;
    protected transient RequestPayload _requestPayload;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public enum Feature {
        AUTO_CLOSE_SOURCE(true),
        ALLOW_COMMENTS(false),
        ALLOW_YAML_COMMENTS(false),
        ALLOW_UNQUOTED_FIELD_NAMES(false),
        ALLOW_SINGLE_QUOTES(false),
        ALLOW_UNQUOTED_CONTROL_CHARS(false),
        ALLOW_RS_CONTROL_CHAR(false),
        ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER(false),
        ALLOW_NUMERIC_LEADING_ZEROS(false),
        ALLOW_LEADING_PLUS_SIGN_FOR_NUMBERS(false),
        ALLOW_LEADING_DECIMAL_POINT_FOR_NUMBERS(false),
        ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS(false),
        ALLOW_NON_NUMERIC_NUMBERS(false),
        ALLOW_MISSING_VALUES(false),
        ALLOW_TRAILING_COMMA(false),
        STRICT_DUPLICATE_DETECTION(false),
        IGNORE_UNDEFINED(false),
        INCLUDE_SOURCE_IN_LOCATION(false),
        USE_FAST_DOUBLE_PARSER(false),
        USE_FAST_BIG_NUMBER_PARSER(false);

        private final boolean _defaultState;
        private final int _mask = 1 << ordinal();

        Feature(boolean z10) {
            this._defaultState = z10;
        }

        public static int collectDefaults() {
            int mask = 0;
            for (Feature feature : values()) {
                if (feature.enabledByDefault()) {
                    mask |= feature.getMask();
                }
            }
            return mask;
        }

        public boolean enabledByDefault() {
            return this._defaultState;
        }

        public boolean enabledIn(int i) {
            return (this._mask & i) != 0;
        }

        public int getMask() {
            return this._mask;
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public enum NumberType {
        INT,
        LONG,
        BIG_INTEGER,
        FLOAT,
        DOUBLE,
        BIG_DECIMAL
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public enum NumberTypeFP {
        FLOAT16,
        FLOAT32,
        DOUBLE64,
        BIG_DECIMAL,
        UNKNOWN
    }

    public JsonParser() {
        this._features = JsonFactory.DEFAULT_PARSER_FEATURE_FLAGS;
    }

    public ObjectCodec _codec() {
        ObjectCodec codec = getCodec();
        if (codec != null) {
            return codec;
        }
        f.e("No ObjectCodec defined for parser, needed for deserialization");
        return null;
    }

    public JsonParseException _constructError(String str) {
        return new JsonParseException(this, str).withRequestPayload(this._requestPayload);
    }

    public JsonParseException _constructReadException(String str, Throwable th) {
        JsonParseException jsonParseException = new JsonParseException(this, str, th);
        RequestPayload requestPayload = this._requestPayload;
        return requestPayload != null ? jsonParseException.withRequestPayload(requestPayload) : jsonParseException;
    }

    public void _reportUnsupportedOperation() {
        throw new UnsupportedOperationException("Operation not supported by parser of type ".concat(getClass().getName()));
    }

    public void assignCurrentValue(Object obj) {
        JsonStreamContext parsingContext = getParsingContext();
        if (parsingContext != null) {
            parsingContext.setCurrentValue(obj);
        }
    }

    public boolean canParseAsync() {
        return false;
    }

    public boolean canReadObjectId() {
        return false;
    }

    public boolean canReadTypeId() {
        return false;
    }

    public boolean canUseSchema(FormatSchema formatSchema) {
        return false;
    }

    public abstract void clearCurrentToken();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public abstract void close();

    public JsonParser configure(Feature feature, boolean z10) {
        if (z10) {
            enable(feature);
            return this;
        }
        disable(feature);
        return this;
    }

    public JsonLocation currentLocation() {
        return getCurrentLocation();
    }

    public String currentName() {
        return getCurrentName();
    }

    public JsonToken currentToken() {
        return getCurrentToken();
    }

    public long currentTokenCount() {
        return -1L;
    }

    public int currentTokenId() {
        return getCurrentTokenId();
    }

    public JsonLocation currentTokenLocation() {
        return getTokenLocation();
    }

    public Object currentValue() {
        JsonStreamContext parsingContext = getParsingContext();
        if (parsingContext == null) {
            return null;
        }
        return parsingContext.getCurrentValue();
    }

    public JsonParser disable(Feature feature) {
        this._features = (~feature.getMask()) & this._features;
        return this;
    }

    public JsonParser enable(Feature feature) {
        this._features = feature.getMask() | this._features;
        return this;
    }

    public abstract BigInteger getBigIntegerValue();

    public byte[] getBinaryValue() {
        return getBinaryValue(Base64Variants.getDefaultVariant());
    }

    public abstract byte[] getBinaryValue(Base64Variant base64Variant);

    public boolean getBooleanValue() throws JsonParseException {
        JsonToken jsonTokenCurrentToken = currentToken();
        if (jsonTokenCurrentToken == JsonToken.VALUE_TRUE) {
            return true;
        }
        if (jsonTokenCurrentToken == JsonToken.VALUE_FALSE) {
            return false;
        }
        throw new JsonParseException(this, "Current token (" + jsonTokenCurrentToken + ") not of boolean type").withRequestPayload(this._requestPayload);
    }

    public byte getByteValue() throws InputCoercionException {
        int intValue = getIntValue();
        if (intValue < MIN_BYTE_I || intValue > MAX_BYTE_I) {
            throw new InputCoercionException(this, a.C("Numeric value (", getText(), ") out of range of Java byte"), JsonToken.VALUE_NUMBER_INT, Byte.TYPE);
        }
        return (byte) intValue;
    }

    public abstract ObjectCodec getCodec();

    @Deprecated
    public abstract JsonLocation getCurrentLocation();

    @Deprecated
    public abstract String getCurrentName();

    public abstract JsonToken getCurrentToken();

    @Deprecated
    public abstract int getCurrentTokenId();

    @Deprecated
    public Object getCurrentValue() {
        return currentValue();
    }

    public abstract BigDecimal getDecimalValue();

    public abstract double getDoubleValue();

    public Object getEmbeddedObject() {
        return null;
    }

    public int getFeatureMask() {
        return this._features;
    }

    public abstract float getFloatValue();

    public int getFormatFeatures() {
        return 0;
    }

    public Object getInputSource() {
        return null;
    }

    public abstract int getIntValue();

    public abstract JsonToken getLastClearedToken();

    public abstract long getLongValue();

    public NonBlockingInputFeeder getNonBlockingInputFeeder() {
        return null;
    }

    public abstract NumberType getNumberType();

    public NumberTypeFP getNumberTypeFP() {
        NumberType numberType = getNumberType();
        return numberType == NumberType.BIG_DECIMAL ? NumberTypeFP.BIG_DECIMAL : numberType == NumberType.DOUBLE ? NumberTypeFP.DOUBLE64 : numberType == NumberType.FLOAT ? NumberTypeFP.FLOAT32 : NumberTypeFP.UNKNOWN;
    }

    public abstract Number getNumberValue();

    public Object getNumberValueDeferred() {
        return getNumberValue();
    }

    public Number getNumberValueExact() {
        return getNumberValue();
    }

    public Object getObjectId() {
        return null;
    }

    public abstract JsonStreamContext getParsingContext();

    public JacksonFeatureSet<StreamReadCapability> getReadCapabilities() {
        return DEFAULT_READ_CAPABILITIES;
    }

    public FormatSchema getSchema() {
        return null;
    }

    public short getShortValue() throws InputCoercionException {
        int intValue = getIntValue();
        if (intValue < MIN_SHORT_I || intValue > MAX_SHORT_I) {
            throw new InputCoercionException(this, a.C("Numeric value (", getText(), ") out of range of Java short"), JsonToken.VALUE_NUMBER_INT, Short.TYPE);
        }
        return (short) intValue;
    }

    public int getText(Writer writer) throws IOException {
        String text = getText();
        if (text == null) {
            return 0;
        }
        writer.write(text);
        return text.length();
    }

    public abstract String getText();

    public abstract char[] getTextCharacters();

    public abstract int getTextLength();

    public abstract int getTextOffset();

    @Deprecated
    public abstract JsonLocation getTokenLocation();

    public Object getTypeId() {
        return null;
    }

    public boolean getValueAsBoolean() {
        return getValueAsBoolean(false);
    }

    public double getValueAsDouble() {
        return getValueAsDouble(0.0d);
    }

    public int getValueAsInt() {
        return getValueAsInt(0);
    }

    public long getValueAsLong() {
        return getValueAsLong(0L);
    }

    public String getValueAsString() {
        return getValueAsString(null);
    }

    public abstract String getValueAsString(String str);

    public abstract boolean hasCurrentToken();

    public abstract boolean hasTextCharacters();

    public abstract boolean hasToken(JsonToken jsonToken);

    public abstract boolean hasTokenId(int i);

    public abstract boolean isClosed();

    public boolean isEnabled(StreamReadFeature streamReadFeature) {
        return streamReadFeature.mappedFeature().enabledIn(this._features);
    }

    public boolean isExpectedNumberIntToken() {
        return currentToken() == JsonToken.VALUE_NUMBER_INT;
    }

    public boolean isExpectedStartArrayToken() {
        return currentToken() == JsonToken.START_ARRAY;
    }

    public boolean isExpectedStartObjectToken() {
        return currentToken() == JsonToken.START_OBJECT;
    }

    public boolean isNaN() {
        return false;
    }

    public Boolean nextBooleanValue() {
        JsonToken jsonTokenNextToken = nextToken();
        if (jsonTokenNextToken == JsonToken.VALUE_TRUE) {
            return Boolean.TRUE;
        }
        if (jsonTokenNextToken == JsonToken.VALUE_FALSE) {
            return Boolean.FALSE;
        }
        return null;
    }

    public boolean nextFieldName(SerializableString serializableString) {
        return nextToken() == JsonToken.FIELD_NAME && serializableString.getValue().equals(currentName());
    }

    public int nextIntValue(int i) {
        return nextToken() == JsonToken.VALUE_NUMBER_INT ? getIntValue() : i;
    }

    public long nextLongValue(long j10) {
        return nextToken() == JsonToken.VALUE_NUMBER_INT ? getLongValue() : j10;
    }

    public String nextTextValue() {
        if (nextToken() == JsonToken.VALUE_STRING) {
            return getText();
        }
        return null;
    }

    public abstract JsonToken nextToken();

    public abstract JsonToken nextValue();

    public abstract void overrideCurrentName(String str);

    public JsonParser overrideStdFeatures(int i, int i3) {
        return setFeatureMask((i & i3) | (this._features & (~i3)));
    }

    public int readBinaryValue(OutputStream outputStream) {
        return readBinaryValue(Base64Variants.getDefaultVariant(), outputStream);
    }

    public <T> T readValueAs(Class<T> cls) {
        return (T) _codec().readValue(this, cls);
    }

    public <T extends TreeNode> T readValueAsTree() {
        return (T) _codec().readTree(this);
    }

    public <T> Iterator<T> readValuesAs(Class<T> cls) {
        return _codec().readValues(this, cls);
    }

    public int releaseBuffered(OutputStream outputStream) {
        return -1;
    }

    public boolean requiresCustomCodec() {
        return false;
    }

    public abstract void setCodec(ObjectCodec objectCodec);

    @Deprecated
    public void setCurrentValue(Object obj) {
        assignCurrentValue(obj);
    }

    @Deprecated
    public JsonParser setFeatureMask(int i) {
        this._features = i;
        return this;
    }

    public void setRequestPayloadOnError(byte[] bArr, String str) {
        this._requestPayload = bArr == null ? null : new RequestPayload(bArr, str);
    }

    public void setSchema(FormatSchema formatSchema) {
        throw new UnsupportedOperationException("Parser of type " + getClass().getName() + " does not support schema of type '" + formatSchema.getSchemaType() + "'");
    }

    public abstract JsonParser skipChildren();

    public StreamReadConstraints streamReadConstraints() {
        return StreamReadConstraints.defaults();
    }

    @Override // com.fasterxml.jackson.core.Versioned
    public abstract Version version();

    public int releaseBuffered(Writer writer) {
        return -1;
    }

    public boolean getValueAsBoolean(boolean z10) {
        return z10;
    }

    public int getValueAsInt(int i) {
        return i;
    }

    public double getValueAsDouble(double d7) {
        return d7;
    }

    public long getValueAsLong(long j10) {
        return j10;
    }

    public JsonParser(int i) {
        this._features = i;
    }

    public int readBinaryValue(Base64Variant base64Variant, OutputStream outputStream) {
        _reportUnsupportedOperation();
        return 0;
    }

    public <T> T readValueAs(TypeReference<?> typeReference) {
        return (T) _codec().readValue(this, typeReference);
    }

    public <T> Iterator<T> readValuesAs(TypeReference<T> typeReference) {
        return _codec().readValues(this, typeReference);
    }

    public boolean isEnabled(Feature feature) {
        return feature.enabledIn(this._features);
    }

    public void setRequestPayloadOnError(RequestPayload requestPayload) {
        this._requestPayload = requestPayload;
    }

    public void setRequestPayloadOnError(String str) {
        this._requestPayload = str == null ? null : new RequestPayload(str);
    }

    public JsonParseException _constructReadException(String str, Object obj) {
        return _constructReadException(String.format(str, obj));
    }

    public JsonParseException _constructReadException(String str, Object obj, Object obj2) {
        return _constructReadException(String.format(str, obj, obj2));
    }

    public JsonParseException _constructReadException(String str, Object obj, Object obj2, Object obj3) {
        return _constructReadException(String.format(str, obj, obj2, obj3));
    }

    public JsonParseException _constructReadException(String str) {
        return _constructError(str);
    }

    public void finishToken() {
    }

    public JsonParseException _constructReadException(String str, JsonLocation jsonLocation) {
        JsonParseException jsonParseException = new JsonParseException(this, str, jsonLocation);
        RequestPayload requestPayload = this._requestPayload;
        return requestPayload != null ? jsonParseException.withRequestPayload(requestPayload) : jsonParseException;
    }

    public String nextFieldName() {
        if (nextToken() == JsonToken.FIELD_NAME) {
            return currentName();
        }
        return null;
    }

    public JsonParser overrideFormatFeatures(int i, int i3) {
        return this;
    }
}
