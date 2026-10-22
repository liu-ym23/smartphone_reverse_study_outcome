package com.fasterxml.jackson.databind.util;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.core.StreamReadCapability;
import com.fasterxml.jackson.core.StreamReadConstraints;
import com.fasterxml.jackson.core.StreamReadFeature;
import com.fasterxml.jackson.core.StreamWriteCapability;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.base.ParserMinimalBase;
import com.fasterxml.jackson.core.io.JsonEOFException;
import com.fasterxml.jackson.core.io.NumberInput;
import com.fasterxml.jackson.core.json.JsonWriteContext;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import com.fasterxml.jackson.core.util.JacksonFeatureSet;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.cfg.PackageVersion;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.TreeMap;

/* loaded from: classes2.dex */
public class TokenBuffer extends JsonGenerator {
    protected static final int DEFAULT_GENERATOR_FEATURES = JsonGenerator.Feature.collectDefaults();
    protected int _appendAt;
    protected boolean _closed;
    protected Segment _first;
    protected boolean _forceBigDecimal;
    protected int _generatorFeatures;
    protected boolean _hasNativeId;
    protected boolean _hasNativeObjectIds;
    protected boolean _hasNativeTypeIds;
    protected Segment _last;
    protected boolean _mayHaveNativeIds;
    protected ObjectCodec _objectCodec;
    protected Object _objectId;
    protected JsonStreamContext _parentContext;
    protected StreamReadConstraints _streamReadConstraints;
    protected Object _typeId;
    protected JsonWriteContext _writeContext;

    /* renamed from: com.fasterxml.jackson.databind.util.TokenBuffer$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$fasterxml$jackson$core$JsonParser$NumberType;
        static final /* synthetic */ int[] $SwitchMap$com$fasterxml$jackson$core$JsonToken;

        static {
            int[] iArr = new int[JsonParser.NumberType.values().length];
            $SwitchMap$com$fasterxml$jackson$core$JsonParser$NumberType = iArr;
            try {
                iArr[JsonParser.NumberType.INT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$core$JsonParser$NumberType[JsonParser.NumberType.BIG_INTEGER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[JsonToken.values().length];
            $SwitchMap$com$fasterxml$jackson$core$JsonToken = iArr2;
            try {
                iArr2[JsonToken.START_OBJECT.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$core$JsonToken[JsonToken.END_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$core$JsonToken[JsonToken.START_ARRAY.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$core$JsonToken[JsonToken.END_ARRAY.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$core$JsonToken[JsonToken.FIELD_NAME.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$core$JsonToken[JsonToken.VALUE_STRING.ordinal()] = 6;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$core$JsonToken[JsonToken.VALUE_NUMBER_INT.ordinal()] = 7;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$core$JsonToken[JsonToken.VALUE_NUMBER_FLOAT.ordinal()] = 8;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$core$JsonToken[JsonToken.VALUE_TRUE.ordinal()] = 9;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$core$JsonToken[JsonToken.VALUE_FALSE.ordinal()] = 10;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$core$JsonToken[JsonToken.VALUE_NULL.ordinal()] = 11;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$core$JsonToken[JsonToken.VALUE_EMBEDDED_OBJECT.ordinal()] = 12;
            } catch (NoSuchFieldError unused14) {
            }
        }
    }

    public static final class Parser extends ParserMinimalBase {
        protected transient ByteArrayBuilder _byteBuilder;
        protected boolean _closed;
        protected ObjectCodec _codec;
        protected final boolean _hasNativeIds;
        protected final boolean _hasNativeObjectIds;
        protected final boolean _hasNativeTypeIds;
        protected JsonLocation _location;
        protected TokenBufferReadContext _parsingContext;
        protected Segment _segment;
        protected int _segmentPtr;

        @Deprecated
        public Parser(Segment segment, ObjectCodec objectCodec, boolean z10, boolean z11) {
            this(segment, objectCodec, z10, z11, null);
        }

        private final boolean _smallerThanInt(Number number) {
            return (number instanceof Short) || (number instanceof Byte);
        }

        private final boolean _smallerThanLong(Number number) {
            return (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
        }

        public final void _checkIsNumber() throws JacksonException {
            JsonToken jsonToken = this._currToken;
            if (jsonToken == null || !jsonToken.isNumeric()) {
                throw _constructError("Current token (" + this._currToken + ") not numeric, cannot use numeric value accessors");
            }
        }

        public int _convertNumberToInt(Number number) throws IOException {
            if (number instanceof Long) {
                long jLongValue = number.longValue();
                int i10 = (int) jLongValue;
                if (i10 != jLongValue) {
                    reportOverflowInt();
                }
                return i10;
            }
            if (number instanceof BigInteger) {
                BigInteger bigInteger = (BigInteger) number;
                if (ParserMinimalBase.BI_MIN_INT.compareTo(bigInteger) > 0 || ParserMinimalBase.BI_MAX_INT.compareTo(bigInteger) < 0) {
                    reportOverflowInt();
                }
            } else {
                if ((number instanceof Double) || (number instanceof Float)) {
                    double dDoubleValue = number.doubleValue();
                    if (dDoubleValue < -2.147483648E9d || dDoubleValue > 2.147483647E9d) {
                        reportOverflowInt();
                    }
                    return (int) dDoubleValue;
                }
                if (number instanceof BigDecimal) {
                    BigDecimal bigDecimal = (BigDecimal) number;
                    if (ParserMinimalBase.BD_MIN_INT.compareTo(bigDecimal) > 0 || ParserMinimalBase.BD_MAX_INT.compareTo(bigDecimal) < 0) {
                        reportOverflowInt();
                    }
                } else {
                    _throwInternal();
                }
            }
            return number.intValue();
        }

        public long _convertNumberToLong(Number number) throws IOException {
            if (number instanceof BigInteger) {
                BigInteger bigInteger = (BigInteger) number;
                if (ParserMinimalBase.BI_MIN_LONG.compareTo(bigInteger) > 0 || ParserMinimalBase.BI_MAX_LONG.compareTo(bigInteger) < 0) {
                    reportOverflowLong();
                }
            } else {
                if ((number instanceof Double) || (number instanceof Float)) {
                    double dDoubleValue = number.doubleValue();
                    if (dDoubleValue < -9.223372036854776E18d || dDoubleValue > 9.223372036854776E18d) {
                        reportOverflowLong();
                    }
                    return (long) dDoubleValue;
                }
                if (number instanceof BigDecimal) {
                    BigDecimal bigDecimal = (BigDecimal) number;
                    if (ParserMinimalBase.BD_MIN_LONG.compareTo(bigDecimal) > 0 || ParserMinimalBase.BD_MAX_LONG.compareTo(bigDecimal) < 0) {
                        reportOverflowLong();
                    }
                } else {
                    _throwInternal();
                }
            }
            return number.longValue();
        }

        public final Object _currentObject() {
            return this._segment.get(this._segmentPtr);
        }

        @Override // com.fasterxml.jackson.core.base.ParserMinimalBase
        public void _handleEOF() {
            _throwInternal();
        }

        @Override // com.fasterxml.jackson.core.JsonParser
        public boolean canReadObjectId() {
            return this._hasNativeObjectIds;
        }

        @Override // com.fasterxml.jackson.core.JsonParser
        public boolean canReadTypeId() {
            return this._hasNativeTypeIds;
        }

        @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this._closed) {
                return;
            }
            this._closed = true;
        }

        @Override // com.fasterxml.jackson.core.JsonParser
        public JsonLocation currentLocation() {
            JsonLocation jsonLocation = this._location;
            return jsonLocation == null ? JsonLocation.NA : jsonLocation;
        }

        @Override // com.fasterxml.jackson.core.JsonParser
        public String currentName() {
            JsonToken jsonToken = this._currToken;
            return (jsonToken == JsonToken.START_OBJECT || jsonToken == JsonToken.START_ARRAY) ? this._parsingContext.getParent().getCurrentName() : this._parsingContext.getCurrentName();
        }

        @Override // com.fasterxml.jackson.core.JsonParser
        public JsonLocation currentTokenLocation() {
            return currentLocation();
        }

        @Override // com.fasterxml.jackson.core.JsonParser
        public BigInteger getBigIntegerValue() throws NumberFormatException, IOException {
            Number numberValue = getNumberValue(true);
            if (numberValue instanceof BigInteger) {
                return (BigInteger) numberValue;
            }
            if (!(numberValue instanceof BigDecimal)) {
                return BigInteger.valueOf(numberValue.longValue());
            }
            BigDecimal bigDecimal = (BigDecimal) numberValue;
            streamReadConstraints().validateBigIntegerScale(bigDecimal.scale());
            return bigDecimal.toBigInteger();
        }

        @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
        public byte[] getBinaryValue(Base64Variant base64Variant) throws IOException {
            if (this._currToken == JsonToken.VALUE_EMBEDDED_OBJECT) {
                Object obj_currentObject = _currentObject();
                if (obj_currentObject instanceof byte[]) {
                    return (byte[]) obj_currentObject;
                }
            }
            if (this._currToken != JsonToken.VALUE_STRING) {
                throw _constructError("Current token (" + this._currToken + ") not VALUE_STRING (or VALUE_EMBEDDED_OBJECT with byte[]), cannot access as binary");
            }
            String text = getText();
            if (text == null) {
                return null;
            }
            ByteArrayBuilder byteArrayBuilder = this._byteBuilder;
            if (byteArrayBuilder == null) {
                byteArrayBuilder = new ByteArrayBuilder(100);
                this._byteBuilder = byteArrayBuilder;
            } else {
                byteArrayBuilder.reset();
            }
            _decodeBase64(text, byteArrayBuilder, base64Variant);
            return byteArrayBuilder.toByteArray();
        }

        @Override // com.fasterxml.jackson.core.JsonParser
        public ObjectCodec getCodec() {
            return this._codec;
        }

        @Override // com.fasterxml.jackson.core.JsonParser
        @Deprecated
        public JsonLocation getCurrentLocation() {
            return currentLocation();
        }

        @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
        @Deprecated
        public String getCurrentName() {
            return currentName();
        }

        @Override // com.fasterxml.jackson.core.JsonParser
        public BigDecimal getDecimalValue() throws NumberFormatException, IOException {
            Number numberValue = getNumberValue(true);
            return numberValue instanceof BigDecimal ? (BigDecimal) numberValue : numberValue instanceof Integer ? BigDecimal.valueOf(numberValue.intValue()) : numberValue instanceof Long ? BigDecimal.valueOf(numberValue.longValue()) : numberValue instanceof BigInteger ? new BigDecimal((BigInteger) numberValue) : BigDecimal.valueOf(numberValue.doubleValue());
        }

        @Override // com.fasterxml.jackson.core.JsonParser
        public double getDoubleValue() throws IOException {
            return getNumberValue().doubleValue();
        }

        @Override // com.fasterxml.jackson.core.JsonParser
        public Object getEmbeddedObject() {
            if (this._currToken == JsonToken.VALUE_EMBEDDED_OBJECT) {
                return _currentObject();
            }
            return null;
        }

        @Override // com.fasterxml.jackson.core.JsonParser
        public float getFloatValue() throws IOException {
            return getNumberValue().floatValue();
        }

        @Override // com.fasterxml.jackson.core.JsonParser
        public int getIntValue() throws NumberFormatException, IOException {
            Number numberValue = getNumberValue(false);
            return ((numberValue instanceof Integer) || _smallerThanInt(numberValue)) ? numberValue.intValue() : _convertNumberToInt(numberValue);
        }

        @Override // com.fasterxml.jackson.core.JsonParser
        public long getLongValue() throws NumberFormatException, IOException {
            Number numberValue = getNumberValue(false);
            return ((numberValue instanceof Long) || _smallerThanLong(numberValue)) ? numberValue.longValue() : _convertNumberToLong(numberValue);
        }

        @Override // com.fasterxml.jackson.core.JsonParser
        public JsonParser.NumberType getNumberType() throws IOException {
            Object numberValueDeferred = getNumberValueDeferred();
            if (numberValueDeferred instanceof Integer) {
                return JsonParser.NumberType.INT;
            }
            if (numberValueDeferred instanceof Long) {
                return JsonParser.NumberType.LONG;
            }
            if (numberValueDeferred instanceof Double) {
                return JsonParser.NumberType.DOUBLE;
            }
            if (numberValueDeferred instanceof BigDecimal) {
                return JsonParser.NumberType.BIG_DECIMAL;
            }
            if (numberValueDeferred instanceof BigInteger) {
                return JsonParser.NumberType.BIG_INTEGER;
            }
            if (numberValueDeferred instanceof Float) {
                return JsonParser.NumberType.FLOAT;
            }
            if (numberValueDeferred instanceof Short) {
                return JsonParser.NumberType.INT;
            }
            if (numberValueDeferred instanceof String) {
                return this._currToken == JsonToken.VALUE_NUMBER_FLOAT ? JsonParser.NumberType.BIG_DECIMAL : JsonParser.NumberType.BIG_INTEGER;
            }
            return null;
        }

        @Override // com.fasterxml.jackson.core.JsonParser
        public JsonParser.NumberTypeFP getNumberTypeFP() throws IOException {
            if (this._currToken == JsonToken.VALUE_NUMBER_FLOAT) {
                Object obj_currentObject = _currentObject();
                if (obj_currentObject instanceof Double) {
                    return JsonParser.NumberTypeFP.DOUBLE64;
                }
                if (obj_currentObject instanceof BigDecimal) {
                    return JsonParser.NumberTypeFP.BIG_DECIMAL;
                }
                if (obj_currentObject instanceof Float) {
                    return JsonParser.NumberTypeFP.FLOAT32;
                }
            }
            return JsonParser.NumberTypeFP.UNKNOWN;
        }

        @Override // com.fasterxml.jackson.core.JsonParser
        public final Number getNumberValue() throws IOException {
            return getNumberValue(false);
        }

        @Override // com.fasterxml.jackson.core.JsonParser
        public Object getNumberValueDeferred() throws IOException {
            _checkIsNumber();
            return _currentObject();
        }

        @Override // com.fasterxml.jackson.core.JsonParser
        public Object getObjectId() {
            return this._segment.findObjectId(this._segmentPtr);
        }

        @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
        public JsonStreamContext getParsingContext() {
            return this._parsingContext;
        }

        @Override // com.fasterxml.jackson.core.JsonParser
        public JacksonFeatureSet<StreamReadCapability> getReadCapabilities() {
            return JsonParser.DEFAULT_READ_CAPABILITIES;
        }

        @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
        public String getText() {
            JsonToken jsonToken = this._currToken;
            if (jsonToken == JsonToken.VALUE_STRING || jsonToken == JsonToken.FIELD_NAME) {
                Object obj_currentObject = _currentObject();
                return obj_currentObject instanceof String ? (String) obj_currentObject : ClassUtil.nullOrToString(obj_currentObject);
            }
            if (jsonToken == null) {
                return null;
            }
            int i10 = AnonymousClass1.$SwitchMap$com$fasterxml$jackson$core$JsonToken[jsonToken.ordinal()];
            return (i10 == 7 || i10 == 8) ? ClassUtil.nullOrToString(_currentObject()) : this._currToken.asString();
        }

        @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
        public char[] getTextCharacters() {
            String text = getText();
            if (text == null) {
                return null;
            }
            return text.toCharArray();
        }

        @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
        public int getTextLength() {
            String text = getText();
            if (text == null) {
                return 0;
            }
            return text.length();
        }

        @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
        public int getTextOffset() {
            return 0;
        }

        @Override // com.fasterxml.jackson.core.JsonParser
        @Deprecated
        public JsonLocation getTokenLocation() {
            return currentTokenLocation();
        }

        @Override // com.fasterxml.jackson.core.JsonParser
        public Object getTypeId() {
            return this._segment.findTypeId(this._segmentPtr);
        }

        @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
        public boolean hasTextCharacters() {
            return false;
        }

        @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
        public boolean isClosed() {
            return this._closed;
        }

        @Override // com.fasterxml.jackson.core.JsonParser
        public boolean isNaN() {
            boolean zIsFinite;
            if (this._currToken != JsonToken.VALUE_NUMBER_FLOAT) {
                return false;
            }
            Object obj_currentObject = _currentObject();
            if (obj_currentObject instanceof Double) {
                zIsFinite = Double.isFinite(((Double) obj_currentObject).doubleValue());
            } else {
                if (!(obj_currentObject instanceof Float)) {
                    return false;
                }
                zIsFinite = Double.isFinite(((Float) obj_currentObject).floatValue());
            }
            return !zIsFinite;
        }

        @Override // com.fasterxml.jackson.core.JsonParser
        public String nextFieldName() throws IOException {
            Segment segment;
            if (!this._closed && (segment = this._segment) != null) {
                int i10 = this._segmentPtr + 1;
                if (i10 < 16) {
                    JsonToken jsonTokenType = segment.type(i10);
                    JsonToken jsonToken = JsonToken.FIELD_NAME;
                    if (jsonTokenType == jsonToken) {
                        this._segmentPtr = i10;
                        _updateToken(jsonToken);
                        Object obj = this._segment.get(i10);
                        String string = obj instanceof String ? (String) obj : obj.toString();
                        this._parsingContext.setCurrentName(string);
                        return string;
                    }
                }
                if (nextToken() == JsonToken.FIELD_NAME) {
                    return currentName();
                }
            }
            return null;
        }

        @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
        public JsonToken nextToken() throws IOException {
            Segment segment;
            if (this._closed || (segment = this._segment) == null) {
                return null;
            }
            int i10 = this._segmentPtr + 1;
            this._segmentPtr = i10;
            if (i10 >= 16) {
                this._segmentPtr = 0;
                Segment next = segment.next();
                this._segment = next;
                if (next == null) {
                    return null;
                }
            }
            _updateToken(this._segment.type(this._segmentPtr));
            JsonToken jsonToken = this._currToken;
            if (jsonToken == JsonToken.FIELD_NAME) {
                Object obj_currentObject = _currentObject();
                this._parsingContext.setCurrentName(obj_currentObject instanceof String ? (String) obj_currentObject : obj_currentObject.toString());
            } else if (jsonToken == JsonToken.START_OBJECT) {
                this._parsingContext = this._parsingContext.createChildObjectContext();
            } else if (jsonToken == JsonToken.START_ARRAY) {
                this._parsingContext = this._parsingContext.createChildArrayContext();
            } else if (jsonToken == JsonToken.END_OBJECT || jsonToken == JsonToken.END_ARRAY) {
                this._parsingContext = this._parsingContext.parentOrCopy();
            } else {
                this._parsingContext.updateForValue();
            }
            return this._currToken;
        }

        @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
        public void overrideCurrentName(String str) {
            JsonStreamContext parent = this._parsingContext;
            JsonToken jsonToken = this._currToken;
            if (jsonToken == JsonToken.START_OBJECT || jsonToken == JsonToken.START_ARRAY) {
                parent = parent.getParent();
            }
            if (parent instanceof TokenBufferReadContext) {
                try {
                    ((TokenBufferReadContext) parent).setCurrentName(str);
                } catch (IOException e10) {
                    throw new RuntimeException(e10);
                }
            }
        }

        public JsonToken peekNextToken() throws IOException {
            if (this._closed) {
                return null;
            }
            Segment next = this._segment;
            int i10 = this._segmentPtr + 1;
            if (i10 >= 16) {
                next = next == null ? null : next.next();
                i10 = 0;
            }
            if (next == null) {
                return null;
            }
            return next.type(i10);
        }

        @Override // com.fasterxml.jackson.core.JsonParser
        public int readBinaryValue(Base64Variant base64Variant, OutputStream outputStream) throws IOException {
            byte[] binaryValue = getBinaryValue(base64Variant);
            if (binaryValue == null) {
                return 0;
            }
            outputStream.write(binaryValue, 0, binaryValue.length);
            return binaryValue.length;
        }

        @Override // com.fasterxml.jackson.core.JsonParser
        public void setCodec(ObjectCodec objectCodec) {
            this._codec = objectCodec;
        }

        public void setLocation(JsonLocation jsonLocation) {
            this._location = jsonLocation;
        }

        @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
        public StreamReadConstraints streamReadConstraints() {
            return this._streamReadConstraints;
        }

        @Override // com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.core.Versioned
        public Version version() {
            return PackageVersion.VERSION;
        }

        @Deprecated
        public Parser(Segment segment, ObjectCodec objectCodec, boolean z10, boolean z11, JsonStreamContext jsonStreamContext) {
            this(segment, objectCodec, z10, z11, jsonStreamContext, StreamReadConstraints.defaults());
        }

        private Number getNumberValue(boolean z10) throws NumberFormatException, IOException {
            _checkIsNumber();
            Object obj_currentObject = _currentObject();
            if (obj_currentObject instanceof Number) {
                return (Number) obj_currentObject;
            }
            if (!(obj_currentObject instanceof String)) {
                throw new IllegalStateException("Internal error: entry should be a Number, but is of type " + ClassUtil.classNameOf(obj_currentObject));
            }
            String str = (String) obj_currentObject;
            int length = str.length();
            if (this._currToken == JsonToken.VALUE_NUMBER_INT) {
                return (z10 || length >= 19) ? NumberInput.parseBigInteger(str, isEnabled(StreamReadFeature.USE_FAST_BIG_NUMBER_PARSER)) : length >= 10 ? Long.valueOf(NumberInput.parseLong(str)) : Integer.valueOf(NumberInput.parseInt(str));
            }
            if (!z10) {
                return Double.valueOf(NumberInput.parseDouble(str, isEnabled(StreamReadFeature.USE_FAST_DOUBLE_PARSER)));
            }
            BigDecimal bigDecimal = NumberInput.parseBigDecimal(str, isEnabled(StreamReadFeature.USE_FAST_BIG_NUMBER_PARSER));
            if (bigDecimal != null) {
                return bigDecimal;
            }
            throw new IllegalStateException("Internal error: failed to parse number '" + str + "'");
        }

        public Parser(Segment segment, ObjectCodec objectCodec, boolean z10, boolean z11, JsonStreamContext jsonStreamContext, StreamReadConstraints streamReadConstraints) {
            super(streamReadConstraints);
            this._location = null;
            this._segment = segment;
            this._segmentPtr = -1;
            this._codec = objectCodec;
            this._parsingContext = TokenBufferReadContext.createRootContext(jsonStreamContext);
            this._hasNativeTypeIds = z10;
            this._hasNativeObjectIds = z11;
            this._hasNativeIds = z10 || z11;
        }
    }

    public TokenBuffer(ObjectCodec objectCodec, boolean z10) {
        this._streamReadConstraints = StreamReadConstraints.defaults();
        this._hasNativeId = false;
        this._objectCodec = objectCodec;
        this._generatorFeatures = DEFAULT_GENERATOR_FEATURES;
        this._writeContext = JsonWriteContext.createRootContext(null);
        Segment segment = new Segment();
        this._last = segment;
        this._first = segment;
        this._appendAt = 0;
        this._hasNativeTypeIds = z10;
        this._hasNativeObjectIds = z10;
        this._mayHaveNativeIds = z10 || z10;
    }

    private final void _appendNativeIds(StringBuilder sb2) {
        Object objFindObjectId = this._last.findObjectId(this._appendAt - 1);
        if (objFindObjectId != null) {
            sb2.append("[objectId=");
            sb2.append(String.valueOf(objFindObjectId));
            sb2.append(']');
        }
        Object objFindTypeId = this._last.findTypeId(this._appendAt - 1);
        if (objFindTypeId != null) {
            sb2.append("[typeId=");
            sb2.append(String.valueOf(objFindTypeId));
            sb2.append(']');
        }
    }

    private final void _checkNativeIds(JsonParser jsonParser) throws IOException {
        Object typeId = jsonParser.getTypeId();
        this._typeId = typeId;
        if (typeId != null) {
            this._hasNativeId = true;
        }
        Object objectId = jsonParser.getObjectId();
        this._objectId = objectId;
        if (objectId != null) {
            this._hasNativeId = true;
        }
    }

    private void _copyBufferValue(JsonParser jsonParser, JsonToken jsonToken) throws IOException {
        if (this._mayHaveNativeIds) {
            _checkNativeIds(jsonParser);
        }
        switch (AnonymousClass1.$SwitchMap$com$fasterxml$jackson$core$JsonToken[jsonToken.ordinal()]) {
            case 6:
                if (jsonParser.hasTextCharacters()) {
                    writeString(jsonParser.getTextCharacters(), jsonParser.getTextOffset(), jsonParser.getTextLength());
                    return;
                } else {
                    writeString(jsonParser.getText());
                    return;
                }
            case 7:
                int i10 = AnonymousClass1.$SwitchMap$com$fasterxml$jackson$core$JsonParser$NumberType[jsonParser.getNumberType().ordinal()];
                if (i10 == 1) {
                    writeNumber(jsonParser.getIntValue());
                    return;
                } else if (i10 != 2) {
                    writeNumber(jsonParser.getLongValue());
                    return;
                } else {
                    writeLazyInteger(jsonParser.getNumberValueDeferred());
                    return;
                }
            case 8:
                writeLazyDecimal(jsonParser.getNumberValueDeferred());
                return;
            case 9:
                writeBoolean(true);
                return;
            case 10:
                writeBoolean(false);
                return;
            case 11:
                writeNull();
                return;
            case 12:
                writeObject(jsonParser.getEmbeddedObject());
                return;
            default:
                throw new RuntimeException("Internal error: unexpected token: " + jsonToken);
        }
    }

    @Deprecated
    public static TokenBuffer asCopyOfValue(JsonParser jsonParser) throws IOException {
        TokenBuffer tokenBuffer = new TokenBuffer(jsonParser);
        tokenBuffer.copyCurrentStructure(jsonParser);
        return tokenBuffer;
    }

    private void writeLazyDecimal(Object obj) throws IOException {
        _appendValue(JsonToken.VALUE_NUMBER_FLOAT, obj);
    }

    private void writeLazyInteger(Object obj) throws IOException {
        _appendValue(JsonToken.VALUE_NUMBER_INT, obj);
    }

    public final void _appendEndMarker(JsonToken jsonToken) {
        Segment segmentAppend = this._last.append(this._appendAt, jsonToken);
        if (segmentAppend == null) {
            this._appendAt++;
        } else {
            this._last = segmentAppend;
            this._appendAt = 1;
        }
    }

    public final void _appendFieldName(Object obj) {
        Segment segmentAppend = this._hasNativeId ? this._last.append(this._appendAt, JsonToken.FIELD_NAME, obj, this._objectId, this._typeId) : this._last.append(this._appendAt, JsonToken.FIELD_NAME, obj);
        if (segmentAppend == null) {
            this._appendAt++;
        } else {
            this._last = segmentAppend;
            this._appendAt = 1;
        }
    }

    public final void _appendStartMarker(JsonToken jsonToken) {
        Segment segmentAppend = this._hasNativeId ? this._last.append(this._appendAt, jsonToken, this._objectId, this._typeId) : this._last.append(this._appendAt, jsonToken);
        if (segmentAppend == null) {
            this._appendAt++;
        } else {
            this._last = segmentAppend;
            this._appendAt = 1;
        }
    }

    public final void _appendValue(JsonToken jsonToken) {
        this._writeContext.writeValue();
        Segment segmentAppend = this._hasNativeId ? this._last.append(this._appendAt, jsonToken, this._objectId, this._typeId) : this._last.append(this._appendAt, jsonToken);
        if (segmentAppend == null) {
            this._appendAt++;
        } else {
            this._last = segmentAppend;
            this._appendAt = 1;
        }
    }

    public void _copyBufferContents(JsonParser jsonParser) throws IOException {
        int i10 = 1;
        while (true) {
            JsonToken jsonTokenNextToken = jsonParser.nextToken();
            if (jsonTokenNextToken == null) {
                return;
            }
            int i11 = AnonymousClass1.$SwitchMap$com$fasterxml$jackson$core$JsonToken[jsonTokenNextToken.ordinal()];
            if (i11 == 1) {
                if (this._mayHaveNativeIds) {
                    _checkNativeIds(jsonParser);
                }
                writeStartObject();
            } else if (i11 == 2) {
                writeEndObject();
                i10--;
                if (i10 == 0) {
                    return;
                }
            } else if (i11 == 3) {
                if (this._mayHaveNativeIds) {
                    _checkNativeIds(jsonParser);
                }
                writeStartArray();
            } else if (i11 == 4) {
                writeEndArray();
                i10--;
                if (i10 == 0) {
                    return;
                }
            } else if (i11 != 5) {
                _copyBufferValue(jsonParser, jsonTokenNextToken);
            } else {
                if (this._mayHaveNativeIds) {
                    _checkNativeIds(jsonParser);
                }
                writeFieldName(jsonParser.currentName());
            }
            i10++;
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void _reportUnsupportedOperation() {
        throw new UnsupportedOperationException("Called operation not supported for TokenBuffer");
    }

    public TokenBuffer append(TokenBuffer tokenBuffer) throws IOException {
        if (!this._hasNativeTypeIds) {
            this._hasNativeTypeIds = tokenBuffer.canWriteTypeId();
        }
        if (!this._hasNativeObjectIds) {
            this._hasNativeObjectIds = tokenBuffer.canWriteObjectId();
        }
        this._mayHaveNativeIds = this._hasNativeTypeIds || this._hasNativeObjectIds;
        JsonParser jsonParserAsParser = tokenBuffer.asParser();
        while (jsonParserAsParser.nextToken() != null) {
            copyCurrentStructure(jsonParserAsParser);
        }
        return this;
    }

    public JsonParser asParser() {
        return asParser(this._objectCodec);
    }

    public JsonParser asParserOnFirstToken() throws IOException {
        JsonParser jsonParserAsParser = asParser(this._objectCodec);
        jsonParserAsParser.nextToken();
        return jsonParserAsParser;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public boolean canWriteBinaryNatively() {
        return true;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public boolean canWriteObjectId() {
        return this._hasNativeObjectIds;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public boolean canWriteTypeId() {
        return this._hasNativeTypeIds;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this._closed = true;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void copyCurrentEvent(JsonParser jsonParser) throws IOException {
        if (this._mayHaveNativeIds) {
            _checkNativeIds(jsonParser);
        }
        switch (AnonymousClass1.$SwitchMap$com$fasterxml$jackson$core$JsonToken[jsonParser.currentToken().ordinal()]) {
            case 1:
                writeStartObject();
                return;
            case 2:
                writeEndObject();
                return;
            case 3:
                writeStartArray();
                return;
            case 4:
                writeEndArray();
                return;
            case 5:
                writeFieldName(jsonParser.currentName());
                return;
            case 6:
                if (jsonParser.hasTextCharacters()) {
                    writeString(jsonParser.getTextCharacters(), jsonParser.getTextOffset(), jsonParser.getTextLength());
                    return;
                } else {
                    writeString(jsonParser.getText());
                    return;
                }
            case 7:
                int i10 = AnonymousClass1.$SwitchMap$com$fasterxml$jackson$core$JsonParser$NumberType[jsonParser.getNumberType().ordinal()];
                if (i10 == 1) {
                    writeNumber(jsonParser.getIntValue());
                    return;
                } else if (i10 != 2) {
                    writeNumber(jsonParser.getLongValue());
                    return;
                } else {
                    writeLazyInteger(jsonParser.getNumberValueDeferred());
                    return;
                }
            case 8:
                writeLazyDecimal(jsonParser.getNumberValueDeferred());
                return;
            case 9:
                writeBoolean(true);
                return;
            case 10:
                writeBoolean(false);
                return;
            case 11:
                writeNull();
                return;
            case 12:
                writeObject(jsonParser.getEmbeddedObject());
                return;
            default:
                throw new RuntimeException("Internal error: unexpected token: " + jsonParser.currentToken());
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void copyCurrentStructure(JsonParser jsonParser) throws IOException {
        JsonToken jsonTokenCurrentToken = jsonParser.currentToken();
        if (jsonTokenCurrentToken == JsonToken.FIELD_NAME) {
            if (this._mayHaveNativeIds) {
                _checkNativeIds(jsonParser);
            }
            writeFieldName(jsonParser.currentName());
            jsonTokenCurrentToken = jsonParser.nextToken();
        } else if (jsonTokenCurrentToken == null) {
            throw new JsonEOFException(jsonParser, null, "Unexpected end-of-input");
        }
        int i10 = AnonymousClass1.$SwitchMap$com$fasterxml$jackson$core$JsonToken[jsonTokenCurrentToken.ordinal()];
        if (i10 == 1) {
            if (this._mayHaveNativeIds) {
                _checkNativeIds(jsonParser);
            }
            writeStartObject();
            _copyBufferContents(jsonParser);
            return;
        }
        if (i10 == 2) {
            writeEndObject();
            return;
        }
        if (i10 != 3) {
            if (i10 != 4) {
                _copyBufferValue(jsonParser, jsonTokenCurrentToken);
                return;
            } else {
                writeEndArray();
                return;
            }
        }
        if (this._mayHaveNativeIds) {
            _checkNativeIds(jsonParser);
        }
        writeStartArray();
        _copyBufferContents(jsonParser);
    }

    public TokenBuffer deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonToken jsonTokenNextToken;
        if (!jsonParser.hasToken(JsonToken.FIELD_NAME)) {
            copyCurrentStructure(jsonParser);
            return this;
        }
        writeStartObject();
        do {
            copyCurrentStructure(jsonParser);
            jsonTokenNextToken = jsonParser.nextToken();
        } while (jsonTokenNextToken == JsonToken.FIELD_NAME);
        JsonToken jsonToken = JsonToken.END_OBJECT;
        if (jsonTokenNextToken != jsonToken) {
            deserializationContext.reportWrongTokenException(TokenBuffer.class, jsonToken, "Expected END_OBJECT after copying contents of a JsonParser into TokenBuffer, got " + jsonTokenNextToken, new Object[0]);
        }
        writeEndObject();
        return this;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public JsonGenerator disable(JsonGenerator.Feature feature) {
        this._generatorFeatures = (~feature.getMask()) & this._generatorFeatures;
        return this;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public JsonGenerator enable(JsonGenerator.Feature feature) {
        this._generatorFeatures = feature.getMask() | this._generatorFeatures;
        return this;
    }

    public JsonToken firstToken() {
        return this._first.type(0);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator, java.io.Flushable
    public void flush() throws IOException {
    }

    public TokenBuffer forceUseOfBigDecimal(boolean z10) {
        this._forceBigDecimal = z10;
        return this;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public ObjectCodec getCodec() {
        return this._objectCodec;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public int getFeatureMask() {
        return this._generatorFeatures;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public JacksonFeatureSet<StreamWriteCapability> getWriteCapabilities() {
        return JsonGenerator.DEFAULT_WRITE_CAPABILITIES;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public boolean isClosed() {
        return this._closed;
    }

    public boolean isEmpty() {
        return this._appendAt == 0 && this._first == this._last;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public boolean isEnabled(JsonGenerator.Feature feature) {
        return (this._generatorFeatures & feature.getMask()) != 0;
    }

    public TokenBuffer overrideParentContext(JsonStreamContext jsonStreamContext) {
        this._parentContext = jsonStreamContext;
        return this;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public JsonGenerator overrideStdFeatures(int i10, int i11) {
        this._generatorFeatures = (i10 & i11) | (getFeatureMask() & (~i11));
        return this;
    }

    public void serialize(JsonGenerator jsonGenerator) throws IOException {
        Segment next = this._first;
        boolean z10 = this._mayHaveNativeIds;
        boolean z11 = z10 && next.hasIds();
        int i10 = -1;
        while (true) {
            i10++;
            if (i10 >= 16) {
                next = next.next();
                if (next == null) {
                    return;
                }
                z11 = z10 && next.hasIds();
                i10 = 0;
            }
            JsonToken jsonTokenType = next.type(i10);
            if (jsonTokenType == null) {
                return;
            }
            if (z11) {
                Object objFindObjectId = next.findObjectId(i10);
                if (objFindObjectId != null) {
                    jsonGenerator.writeObjectId(objFindObjectId);
                }
                Object objFindTypeId = next.findTypeId(i10);
                if (objFindTypeId != null) {
                    jsonGenerator.writeTypeId(objFindTypeId);
                }
            }
            switch (AnonymousClass1.$SwitchMap$com$fasterxml$jackson$core$JsonToken[jsonTokenType.ordinal()]) {
                case 1:
                    jsonGenerator.writeStartObject();
                    break;
                case 2:
                    jsonGenerator.writeEndObject();
                    break;
                case 3:
                    jsonGenerator.writeStartArray();
                    break;
                case 4:
                    jsonGenerator.writeEndArray();
                    break;
                case 5:
                    Object obj = next.get(i10);
                    if (!(obj instanceof SerializableString)) {
                        jsonGenerator.writeFieldName((String) obj);
                        break;
                    } else {
                        jsonGenerator.writeFieldName((SerializableString) obj);
                        break;
                    }
                case 6:
                    Object obj2 = next.get(i10);
                    if (!(obj2 instanceof SerializableString)) {
                        jsonGenerator.writeString((String) obj2);
                        break;
                    } else {
                        jsonGenerator.writeString((SerializableString) obj2);
                        break;
                    }
                case 7:
                    Object obj3 = next.get(i10);
                    if (!(obj3 instanceof Integer)) {
                        if (!(obj3 instanceof BigInteger)) {
                            if (!(obj3 instanceof Long)) {
                                if (!(obj3 instanceof Short)) {
                                    jsonGenerator.writeNumber(((Number) obj3).intValue());
                                    break;
                                } else {
                                    jsonGenerator.writeNumber(((Short) obj3).shortValue());
                                    break;
                                }
                            } else {
                                jsonGenerator.writeNumber(((Long) obj3).longValue());
                                break;
                            }
                        } else {
                            jsonGenerator.writeNumber((BigInteger) obj3);
                            break;
                        }
                    } else {
                        jsonGenerator.writeNumber(((Integer) obj3).intValue());
                        break;
                    }
                case 8:
                    Object obj4 = next.get(i10);
                    if (!(obj4 instanceof Double)) {
                        if (!(obj4 instanceof BigDecimal)) {
                            if (!(obj4 instanceof Float)) {
                                if (obj4 != null) {
                                    if (!(obj4 instanceof String)) {
                                        _reportError(String.format("Unrecognized value type for VALUE_NUMBER_FLOAT: %s, cannot serialize", obj4.getClass().getName()));
                                        break;
                                    } else {
                                        jsonGenerator.writeNumber((String) obj4);
                                        break;
                                    }
                                } else {
                                    jsonGenerator.writeNull();
                                    break;
                                }
                            } else {
                                jsonGenerator.writeNumber(((Float) obj4).floatValue());
                                break;
                            }
                        } else {
                            jsonGenerator.writeNumber((BigDecimal) obj4);
                            break;
                        }
                    } else {
                        jsonGenerator.writeNumber(((Double) obj4).doubleValue());
                        break;
                    }
                case 9:
                    jsonGenerator.writeBoolean(true);
                    break;
                case 10:
                    jsonGenerator.writeBoolean(false);
                    break;
                case 11:
                    jsonGenerator.writeNull();
                    break;
                case 12:
                    Object obj5 = next.get(i10);
                    if (!(obj5 instanceof RawValue)) {
                        if (!(obj5 instanceof JsonSerializable)) {
                            jsonGenerator.writeEmbeddedObject(obj5);
                            break;
                        } else {
                            jsonGenerator.writeObject(obj5);
                            break;
                        }
                    } else {
                        ((RawValue) obj5).serialize(jsonGenerator);
                        break;
                    }
                default:
                    throw new RuntimeException("Internal error: should never end up through this code path");
            }
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public JsonGenerator setCodec(ObjectCodec objectCodec) {
        this._objectCodec = objectCodec;
        return this;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    @Deprecated
    public JsonGenerator setFeatureMask(int i10) {
        this._generatorFeatures = i10;
        return this;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[TokenBuffer: ");
        JsonParser jsonParserAsParser = asParser();
        int i10 = 0;
        boolean z10 = this._hasNativeTypeIds || this._hasNativeObjectIds;
        while (true) {
            try {
                JsonToken jsonTokenNextToken = jsonParserAsParser.nextToken();
                if (jsonTokenNextToken == null) {
                    break;
                }
                if (z10) {
                    _appendNativeIds(sb2);
                }
                if (i10 < 100) {
                    if (i10 > 0) {
                        sb2.append(", ");
                    }
                    sb2.append(jsonTokenNextToken.toString());
                    if (jsonTokenNextToken == JsonToken.FIELD_NAME) {
                        sb2.append('(');
                        sb2.append(jsonParserAsParser.currentName());
                        sb2.append(')');
                    }
                }
                i10++;
            } catch (IOException e10) {
                throw new IllegalStateException(e10);
            }
        }
        if (i10 >= 100) {
            sb2.append(" ... (truncated ");
            sb2.append(i10 - 100);
            sb2.append(" entries)");
        }
        sb2.append(']');
        return sb2.toString();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public JsonGenerator useDefaultPrettyPrinter() {
        return this;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.core.Versioned
    public Version version() {
        return PackageVersion.VERSION;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeBinary(Base64Variant base64Variant, byte[] bArr, int i10, int i11) throws IOException {
        byte[] bArr2 = new byte[i11];
        System.arraycopy(bArr, i10, bArr2, 0, i11);
        writeObject(bArr2);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeBoolean(boolean z10) throws IOException {
        _appendValue(z10 ? JsonToken.VALUE_TRUE : JsonToken.VALUE_FALSE);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeEmbeddedObject(Object obj) throws IOException {
        _appendValue(JsonToken.VALUE_EMBEDDED_OBJECT, obj);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void writeEndArray() throws IOException {
        _appendEndMarker(JsonToken.END_ARRAY);
        JsonWriteContext parent = this._writeContext.getParent();
        if (parent != null) {
            this._writeContext = parent;
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void writeEndObject() throws IOException {
        _appendEndMarker(JsonToken.END_OBJECT);
        JsonWriteContext parent = this._writeContext.getParent();
        if (parent != null) {
            this._writeContext = parent;
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void writeFieldName(String str) throws IOException {
        this._writeContext.writeFieldName(str);
        _appendFieldName(str);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNull() throws IOException {
        _appendValue(JsonToken.VALUE_NULL);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(short s10) throws IOException {
        _appendValue(JsonToken.VALUE_NUMBER_INT, Short.valueOf(s10));
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeObject(Object obj) throws IOException {
        if (obj == null) {
            writeNull();
            return;
        }
        if (obj.getClass() == byte[].class || (obj instanceof RawValue)) {
            _appendValue(JsonToken.VALUE_EMBEDDED_OBJECT, obj);
            return;
        }
        ObjectCodec objectCodec = this._objectCodec;
        if (objectCodec == null) {
            _appendValue(JsonToken.VALUE_EMBEDDED_OBJECT, obj);
        } else {
            objectCodec.writeValue(this, obj);
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeObjectId(Object obj) {
        this._objectId = obj;
        this._hasNativeId = true;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeRaw(String str) throws IOException {
        _reportUnsupportedOperation();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeRawUTF8String(byte[] bArr, int i10, int i11) throws IOException {
        _reportUnsupportedOperation();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeRawValue(String str) throws IOException {
        _appendValue(JsonToken.VALUE_EMBEDDED_OBJECT, new RawValue(str));
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void writeStartArray() throws IOException {
        this._writeContext.writeValue();
        _appendStartMarker(JsonToken.START_ARRAY);
        this._writeContext = this._writeContext.createChildArrayContext();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void writeStartObject() throws IOException {
        this._writeContext.writeValue();
        _appendStartMarker(JsonToken.START_OBJECT);
        this._writeContext = this._writeContext.createChildObjectContext();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeString(String str) throws IOException {
        if (str == null) {
            writeNull();
        } else {
            _appendValue(JsonToken.VALUE_STRING, str);
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeTree(TreeNode treeNode) throws IOException {
        if (treeNode == null) {
            writeNull();
            return;
        }
        ObjectCodec objectCodec = this._objectCodec;
        if (objectCodec == null) {
            _appendValue(JsonToken.VALUE_EMBEDDED_OBJECT, treeNode);
        } else {
            objectCodec.writeTree(this, treeNode);
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeTypeId(Object obj) {
        this._typeId = obj;
        this._hasNativeId = true;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeUTF8String(byte[] bArr, int i10, int i11) throws IOException {
        _reportUnsupportedOperation();
    }

    public static final class Segment {
        public static final int TOKENS_PER_SEGMENT = 16;
        private static final JsonToken[] TOKEN_TYPES_BY_INDEX;
        protected TreeMap<Integer, Object> _nativeIds;
        protected Segment _next;
        protected long _tokenTypes;
        protected final Object[] _tokens = new Object[16];

        static {
            JsonToken[] jsonTokenArr = new JsonToken[16];
            TOKEN_TYPES_BY_INDEX = jsonTokenArr;
            JsonToken[] jsonTokenArrValues = JsonToken.values();
            System.arraycopy(jsonTokenArrValues, 1, jsonTokenArr, 1, Math.min(15, jsonTokenArrValues.length - 1));
        }

        private final int _objectIdIndex(int i10) {
            return i10 + i10 + 1;
        }

        private final int _typeIdIndex(int i10) {
            return i10 + i10;
        }

        private final void assignNativeIds(int i10, Object obj, Object obj2) {
            if (this._nativeIds == null) {
                this._nativeIds = new TreeMap<>();
            }
            if (obj != null) {
                this._nativeIds.put(Integer.valueOf(_objectIdIndex(i10)), obj);
            }
            if (obj2 != null) {
                this._nativeIds.put(Integer.valueOf(_typeIdIndex(i10)), obj2);
            }
        }

        private void set(int i10, JsonToken jsonToken) {
            long jOrdinal = jsonToken.ordinal();
            if (i10 > 0) {
                jOrdinal <<= i10 << 2;
            }
            this._tokenTypes |= jOrdinal;
        }

        public Segment append(int i10, JsonToken jsonToken) {
            if (i10 < 16) {
                set(i10, jsonToken);
                return null;
            }
            Segment segment = new Segment();
            this._next = segment;
            segment.set(0, jsonToken);
            return this._next;
        }

        public Object findObjectId(int i10) {
            TreeMap<Integer, Object> treeMap = this._nativeIds;
            if (treeMap == null) {
                return null;
            }
            return treeMap.get(Integer.valueOf(_objectIdIndex(i10)));
        }

        public Object findTypeId(int i10) {
            TreeMap<Integer, Object> treeMap = this._nativeIds;
            if (treeMap == null) {
                return null;
            }
            return treeMap.get(Integer.valueOf(_typeIdIndex(i10)));
        }

        public Object get(int i10) {
            return this._tokens[i10];
        }

        public boolean hasIds() {
            return this._nativeIds != null;
        }

        public Segment next() {
            return this._next;
        }

        public int rawType(int i10) {
            long j10 = this._tokenTypes;
            if (i10 > 0) {
                j10 >>= i10 << 2;
            }
            return ((int) j10) & 15;
        }

        public JsonToken type(int i10) {
            long j10 = this._tokenTypes;
            if (i10 > 0) {
                j10 >>= i10 << 2;
            }
            return TOKEN_TYPES_BY_INDEX[((int) j10) & 15];
        }

        private void set(int i10, JsonToken jsonToken, Object obj, Object obj2) {
            long jOrdinal = jsonToken.ordinal();
            if (i10 > 0) {
                jOrdinal <<= i10 << 2;
            }
            this._tokenTypes = jOrdinal | this._tokenTypes;
            assignNativeIds(i10, obj, obj2);
        }

        public Segment append(int i10, JsonToken jsonToken, Object obj, Object obj2) {
            if (i10 < 16) {
                set(i10, jsonToken, obj, obj2);
                return null;
            }
            Segment segment = new Segment();
            this._next = segment;
            segment.set(0, jsonToken, obj, obj2);
            return this._next;
        }

        private void set(int i10, JsonToken jsonToken, Object obj) {
            this._tokens[i10] = obj;
            long jOrdinal = jsonToken.ordinal();
            if (i10 > 0) {
                jOrdinal <<= i10 << 2;
            }
            this._tokenTypes |= jOrdinal;
        }

        private void set(int i10, JsonToken jsonToken, Object obj, Object obj2, Object obj3) {
            this._tokens[i10] = obj;
            long jOrdinal = jsonToken.ordinal();
            if (i10 > 0) {
                jOrdinal <<= i10 << 2;
            }
            this._tokenTypes = jOrdinal | this._tokenTypes;
            assignNativeIds(i10, obj2, obj3);
        }

        public Segment append(int i10, JsonToken jsonToken, Object obj) {
            if (i10 < 16) {
                set(i10, jsonToken, obj);
                return null;
            }
            Segment segment = new Segment();
            this._next = segment;
            segment.set(0, jsonToken, obj);
            return this._next;
        }

        public Segment append(int i10, JsonToken jsonToken, Object obj, Object obj2, Object obj3) {
            if (i10 < 16) {
                set(i10, jsonToken, obj, obj2, obj3);
                return null;
            }
            Segment segment = new Segment();
            this._next = segment;
            segment.set(0, jsonToken, obj, obj2, obj3);
            return this._next;
        }
    }

    public JsonParser asParser(ObjectCodec objectCodec) {
        return new Parser(this._first, objectCodec, this._hasNativeTypeIds, this._hasNativeObjectIds, this._parentContext, this._streamReadConstraints);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final JsonWriteContext getOutputContext() {
        return this._writeContext;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(int i10) throws IOException {
        _appendValue(JsonToken.VALUE_NUMBER_INT, Integer.valueOf(i10));
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeRaw(String str, int i10, int i11) throws IOException {
        _reportUnsupportedOperation();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeRawValue(String str, int i10, int i11) throws IOException {
        if (i10 > 0 || i11 != str.length()) {
            str = str.substring(i10, i11 + i10);
        }
        _appendValue(JsonToken.VALUE_EMBEDDED_OBJECT, new RawValue(str));
    }

    public JsonParser asParser(StreamReadConstraints streamReadConstraints) {
        return new Parser(this._first, this._objectCodec, this._hasNativeTypeIds, this._hasNativeObjectIds, this._parentContext, streamReadConstraints);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeFieldName(SerializableString serializableString) throws IOException {
        this._writeContext.writeFieldName(serializableString.getValue());
        _appendFieldName(serializableString);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(long j10) throws IOException {
        _appendValue(JsonToken.VALUE_NUMBER_INT, Long.valueOf(j10));
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeRaw(SerializableString serializableString) throws IOException {
        _reportUnsupportedOperation();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeString(char[] cArr, int i10, int i11) throws IOException {
        writeString(new String(cArr, i10, i11));
    }

    public JsonParser asParser(JsonParser jsonParser) {
        Parser parser = new Parser(this._first, jsonParser.getCodec(), this._hasNativeTypeIds, this._hasNativeObjectIds, this._parentContext, jsonParser.streamReadConstraints());
        parser.setLocation(jsonParser.currentTokenLocation());
        return parser;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public int writeBinary(Base64Variant base64Variant, InputStream inputStream, int i10) {
        throw new UnsupportedOperationException();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(double d10) throws IOException {
        _appendValue(JsonToken.VALUE_NUMBER_FLOAT, Double.valueOf(d10));
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeRaw(char[] cArr, int i10, int i11) throws IOException {
        _reportUnsupportedOperation();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeStartArray(Object obj) throws IOException {
        this._writeContext.writeValue();
        _appendStartMarker(JsonToken.START_ARRAY);
        this._writeContext = this._writeContext.createChildArrayContext(obj);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeStartObject(Object obj) throws IOException {
        this._writeContext.writeValue();
        _appendStartMarker(JsonToken.START_OBJECT);
        this._writeContext = this._writeContext.createChildObjectContext(obj);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeString(SerializableString serializableString) throws IOException {
        if (serializableString == null) {
            writeNull();
        } else {
            _appendValue(JsonToken.VALUE_STRING, serializableString);
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(float f10) throws IOException {
        _appendValue(JsonToken.VALUE_NUMBER_FLOAT, Float.valueOf(f10));
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeRaw(char c10) throws IOException {
        _reportUnsupportedOperation();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeRawValue(char[] cArr, int i10, int i11) throws IOException {
        _appendValue(JsonToken.VALUE_EMBEDDED_OBJECT, new String(cArr, i10, i11));
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(BigDecimal bigDecimal) throws IOException {
        if (bigDecimal == null) {
            writeNull();
        } else {
            _appendValue(JsonToken.VALUE_NUMBER_FLOAT, bigDecimal);
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeString(Reader reader, int i10) throws IOException {
        if (reader == null) {
            _reportError("null reader");
        }
        int i11 = i10 >= 0 ? i10 : Integer.MAX_VALUE;
        char[] cArr = new char[1000];
        StringBuilder sb2 = new StringBuilder(1000);
        while (i11 > 0) {
            int i12 = reader.read(cArr, 0, Math.min(i11, 1000));
            if (i12 <= 0) {
                break;
            }
            sb2.append(cArr, 0, i12);
            i11 -= i12;
        }
        if (i11 > 0 && i10 >= 0) {
            _reportError("Was not able to read enough from reader");
        }
        _appendValue(JsonToken.VALUE_STRING, sb2.toString());
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeStartArray(Object obj, int i10) throws IOException {
        this._writeContext.writeValue();
        _appendStartMarker(JsonToken.START_ARRAY);
        this._writeContext = this._writeContext.createChildArrayContext(obj);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeStartObject(Object obj, int i10) throws IOException {
        this._writeContext.writeValue();
        _appendStartMarker(JsonToken.START_OBJECT);
        this._writeContext = this._writeContext.createChildObjectContext(obj);
    }

    public final void _appendValue(JsonToken jsonToken, Object obj) {
        Segment segmentAppend;
        this._writeContext.writeValue();
        if (this._hasNativeId) {
            segmentAppend = this._last.append(this._appendAt, jsonToken, obj, this._objectId, this._typeId);
        } else {
            segmentAppend = this._last.append(this._appendAt, jsonToken, obj);
        }
        if (segmentAppend == null) {
            this._appendAt++;
        } else {
            this._last = segmentAppend;
            this._appendAt = 1;
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(BigInteger bigInteger) throws IOException {
        if (bigInteger == null) {
            writeNull();
        } else {
            _appendValue(JsonToken.VALUE_NUMBER_INT, bigInteger);
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(String str) throws IOException {
        _appendValue(JsonToken.VALUE_NUMBER_FLOAT, str);
    }

    public void writeNumber(String str, boolean z10) throws IOException {
        _appendValue(z10 ? JsonToken.VALUE_NUMBER_INT : JsonToken.VALUE_NUMBER_FLOAT, str);
    }

    public TokenBuffer(JsonParser jsonParser) {
        this(jsonParser, (DeserializationContext) null);
    }

    public TokenBuffer(JsonParser jsonParser, DeserializationContext deserializationContext) {
        this._streamReadConstraints = StreamReadConstraints.defaults();
        this._hasNativeId = false;
        this._objectCodec = jsonParser.getCodec();
        this._streamReadConstraints = jsonParser.streamReadConstraints();
        this._parentContext = jsonParser.getParsingContext();
        this._generatorFeatures = DEFAULT_GENERATOR_FEATURES;
        this._writeContext = JsonWriteContext.createRootContext(null);
        Segment segment = new Segment();
        this._last = segment;
        this._first = segment;
        this._appendAt = 0;
        this._hasNativeTypeIds = jsonParser.canReadTypeId();
        boolean zCanReadObjectId = jsonParser.canReadObjectId();
        this._hasNativeObjectIds = zCanReadObjectId;
        this._mayHaveNativeIds = this._hasNativeTypeIds || zCanReadObjectId;
        this._forceBigDecimal = deserializationContext != null ? deserializationContext.isEnabled(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS) : false;
    }
}
