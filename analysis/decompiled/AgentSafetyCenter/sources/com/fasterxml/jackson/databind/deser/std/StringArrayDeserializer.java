package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.cfg.CoercionAction;
import com.fasterxml.jackson.databind.cfg.CoercionInputShape;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.fasterxml.jackson.databind.deser.NullValueProvider;
import com.fasterxml.jackson.databind.deser.impl.NullsConstantProvider;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.type.LogicalType;
import com.fasterxml.jackson.databind.util.AccessPattern;
import com.fasterxml.jackson.databind.util.ObjectBuffer;
import java.util.Objects;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
@JacksonStdImpl
/* loaded from: classes.dex */
public final class StringArrayDeserializer extends StdDeserializer<String[]> implements ContextualDeserializer {
    private static final String[] NO_STRINGS = new String[0];
    public static final StringArrayDeserializer instance = new StringArrayDeserializer();
    private static final long serialVersionUID = 2;
    private final JsonDeserializer<String> _elementDeserializer;
    private final NullValueProvider _nullProvider;
    private final boolean _skipNullValues;
    private final Boolean _unwrapSingle;

    /* JADX WARN: Multi-variable type inference failed */
    private StringArrayDeserializer(JsonDeserializer<?> jsonDeserializer, NullValueProvider nullValueProvider, Boolean bool) {
        super((Class<?>) String[].class);
        this._elementDeserializer = jsonDeserializer;
        this._nullProvider = nullValueProvider;
        this._unwrapSingle = bool;
        this._skipNullValues = NullsConstantProvider.isSkipper(nullValueProvider);
    }

    private String[] _deserializeCustom(JsonParser jsonParser, DeserializationContext deserializationContext, String[] strArr) throws JsonMappingException {
        int length;
        Object[] objArrResetAndStart;
        String strDeserialize;
        ObjectBuffer objectBufferLeaseObjectBuffer = deserializationContext.leaseObjectBuffer();
        if (strArr == null) {
            objArrResetAndStart = objectBufferLeaseObjectBuffer.resetAndStart();
            length = 0;
        } else {
            length = strArr.length;
            objArrResetAndStart = objectBufferLeaseObjectBuffer.resetAndStart(strArr, length);
        }
        JsonDeserializer<String> jsonDeserializer = this._elementDeserializer;
        while (true) {
            try {
                if (jsonParser.nextTextValue() == null) {
                    JsonToken jsonTokenCurrentToken = jsonParser.currentToken();
                    if (jsonTokenCurrentToken == JsonToken.END_ARRAY) {
                        String[] strArr2 = (String[]) objectBufferLeaseObjectBuffer.completeAndClearBuffer(objArrResetAndStart, length, String.class);
                        deserializationContext.returnObjectBuffer(objectBufferLeaseObjectBuffer);
                        return strArr2;
                    }
                    if (jsonTokenCurrentToken != JsonToken.VALUE_NULL) {
                        strDeserialize = jsonDeserializer.deserialize(jsonParser, deserializationContext);
                    } else if (!this._skipNullValues) {
                        strDeserialize = null;
                    }
                } else {
                    strDeserialize = jsonDeserializer.deserialize(jsonParser, deserializationContext);
                }
                if (strDeserialize != null || (strDeserialize = (String) this._nullProvider.getNullValue(deserializationContext)) != null || !this._skipNullValues) {
                    if (length >= objArrResetAndStart.length) {
                        objArrResetAndStart = objectBufferLeaseObjectBuffer.appendCompletedChunk(objArrResetAndStart);
                        length = 0;
                    }
                    int i = length + 1;
                    try {
                        objArrResetAndStart[length] = strDeserialize;
                        length = i;
                    } catch (Exception e10) {
                        e = e10;
                        length = i;
                        throw JsonMappingException.wrapWithPath(e, String.class, length);
                    }
                }
            } catch (Exception e11) {
                e = e11;
            }
        }
    }

    private final String[] handleNonArray(JsonParser jsonParser, DeserializationContext deserializationContext) {
        StringArrayDeserializer stringArrayDeserializer;
        JsonParser jsonParser2;
        DeserializationContext deserializationContext2;
        String str_parseString;
        Boolean bool = this._unwrapSingle;
        if (bool != Boolean.TRUE && (bool != null || !deserializationContext.isEnabled(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY))) {
            return jsonParser.hasToken(JsonToken.VALUE_STRING) ? _deserializeFromString(jsonParser, deserializationContext) : (String[]) deserializationContext.handleUnexpectedToken(this._valueClass, jsonParser);
        }
        if (jsonParser.hasToken(JsonToken.VALUE_NULL)) {
            str_parseString = (String) this._nullProvider.getNullValue(deserializationContext);
        } else if (jsonParser.hasToken(JsonToken.VALUE_STRING)) {
            String text = jsonParser.getText();
            if (text.isEmpty()) {
                CoercionAction coercionActionFindCoercionAction = deserializationContext.findCoercionAction(logicalType(), handledType(), CoercionInputShape.EmptyString);
                if (coercionActionFindCoercionAction != CoercionAction.Fail) {
                    return (String[]) _deserializeFromEmptyString(jsonParser, deserializationContext, coercionActionFindCoercionAction, handledType(), "empty String (\"\")");
                }
                stringArrayDeserializer = this;
                jsonParser2 = jsonParser;
                deserializationContext2 = deserializationContext;
                str_parseString = stringArrayDeserializer._parseString(jsonParser2, deserializationContext2, stringArrayDeserializer._nullProvider);
            } else {
                stringArrayDeserializer = this;
                jsonParser2 = jsonParser;
                deserializationContext2 = deserializationContext;
                if (StdDeserializer._isBlank(text)) {
                    LogicalType logicalType = stringArrayDeserializer.logicalType();
                    Class<?> clsHandledType = stringArrayDeserializer.handledType();
                    CoercionAction coercionAction = CoercionAction.Fail;
                    CoercionAction coercionActionFindCoercionFromBlankString = deserializationContext2.findCoercionFromBlankString(logicalType, clsHandledType, coercionAction);
                    if (coercionActionFindCoercionFromBlankString != coercionAction) {
                        return (String[]) stringArrayDeserializer._deserializeFromEmptyString(jsonParser2, deserializationContext2, coercionActionFindCoercionFromBlankString, stringArrayDeserializer.handledType(), "blank String (all whitespace)");
                    }
                }
                str_parseString = stringArrayDeserializer._parseString(jsonParser2, deserializationContext2, stringArrayDeserializer._nullProvider);
            }
        } else {
            stringArrayDeserializer = this;
            jsonParser2 = jsonParser;
            deserializationContext2 = deserializationContext;
            str_parseString = stringArrayDeserializer._parseString(jsonParser2, deserializationContext2, stringArrayDeserializer._nullProvider);
        }
        return new String[]{str_parseString};
    }

    @Override // com.fasterxml.jackson.databind.deser.ContextualDeserializer
    public JsonDeserializer<?> createContextual(DeserializationContext deserializationContext, BeanProperty beanProperty) {
        JsonDeserializer<?> jsonDeserializerFindConvertingContentDeserializer = findConvertingContentDeserializer(deserializationContext, beanProperty, this._elementDeserializer);
        JavaType javaTypeConstructType = deserializationContext.constructType(String.class);
        JsonDeserializer<?> jsonDeserializerFindContextualValueDeserializer = jsonDeserializerFindConvertingContentDeserializer == null ? deserializationContext.findContextualValueDeserializer(javaTypeConstructType, beanProperty) : deserializationContext.handleSecondaryContextualization(jsonDeserializerFindConvertingContentDeserializer, beanProperty, javaTypeConstructType);
        Boolean boolFindFormatFeature = findFormatFeature(deserializationContext, beanProperty, String[].class, JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        NullValueProvider nullValueProviderFindContentNullProvider = findContentNullProvider(deserializationContext, beanProperty, jsonDeserializerFindContextualValueDeserializer);
        if (jsonDeserializerFindContextualValueDeserializer != null && isDefaultDeserializer(jsonDeserializerFindContextualValueDeserializer)) {
            jsonDeserializerFindContextualValueDeserializer = null;
        }
        return (this._elementDeserializer == jsonDeserializerFindContextualValueDeserializer && Objects.equals(this._unwrapSingle, boolFindFormatFeature) && this._nullProvider == nullValueProviderFindContentNullProvider) ? this : new StringArrayDeserializer(jsonDeserializerFindContextualValueDeserializer, nullValueProviderFindContentNullProvider, boolFindFormatFeature);
    }

    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    public String[] deserialize(JsonParser jsonParser, DeserializationContext deserializationContext, String[] strArr) throws JsonMappingException {
        int i;
        if (!jsonParser.isExpectedStartArrayToken()) {
            String[] strArrHandleNonArray = handleNonArray(jsonParser, deserializationContext);
            if (strArrHandleNonArray == null) {
                return strArr;
            }
            int length = strArr.length;
            String[] strArr2 = new String[strArrHandleNonArray.length + length];
            System.arraycopy(strArr, 0, strArr2, 0, length);
            System.arraycopy(strArrHandleNonArray, 0, strArr2, length, strArrHandleNonArray.length);
            return strArr2;
        }
        if (this._elementDeserializer != null) {
            return _deserializeCustom(jsonParser, deserializationContext, strArr);
        }
        ObjectBuffer objectBufferLeaseObjectBuffer = deserializationContext.leaseObjectBuffer();
        int length2 = strArr.length;
        Object[] objArrResetAndStart = objectBufferLeaseObjectBuffer.resetAndStart(strArr, length2);
        while (true) {
            try {
                String strNextTextValue = jsonParser.nextTextValue();
                try {
                    if (strNextTextValue == null) {
                        JsonToken jsonTokenCurrentToken = jsonParser.currentToken();
                        if (jsonTokenCurrentToken == JsonToken.END_ARRAY) {
                            String[] strArr3 = (String[]) objectBufferLeaseObjectBuffer.completeAndClearBuffer(objArrResetAndStart, length2, String.class);
                            deserializationContext.returnObjectBuffer(objectBufferLeaseObjectBuffer);
                            return strArr3;
                        }
                        if (jsonTokenCurrentToken != JsonToken.VALUE_NULL) {
                            strNextTextValue = _parseString(jsonParser, deserializationContext, this._nullProvider);
                        } else if (this._skipNullValues) {
                            return NO_STRINGS;
                        }
                        if (strNextTextValue != null || (strNextTextValue = (String) this._nullProvider.getNullValue(deserializationContext)) != null || !this._skipNullValues) {
                        }
                    }
                    objArrResetAndStart[length2] = strNextTextValue;
                    length2 = i;
                } catch (Exception e10) {
                    e = e10;
                    length2 = i;
                    throw JsonMappingException.wrapWithPath(e, objArrResetAndStart, objectBufferLeaseObjectBuffer.bufferedSize() + length2);
                }
                if (length2 >= objArrResetAndStart.length) {
                    objArrResetAndStart = objectBufferLeaseObjectBuffer.appendCompletedChunk(objArrResetAndStart);
                    length2 = 0;
                }
                i = length2 + 1;
            } catch (Exception e11) {
                e = e11;
            }
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer, com.fasterxml.jackson.databind.JsonDeserializer
    public Object deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, TypeDeserializer typeDeserializer) {
        return typeDeserializer.deserializeTypedFromArray(jsonParser, deserializationContext);
    }

    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    public AccessPattern getEmptyAccessPattern() {
        return AccessPattern.CONSTANT;
    }

    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    public Object getEmptyValue(DeserializationContext deserializationContext) {
        return NO_STRINGS;
    }

    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    public LogicalType logicalType() {
        return LogicalType.Array;
    }

    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    public Boolean supportsUpdate(DeserializationConfig deserializationConfig) {
        return Boolean.TRUE;
    }

    public StringArrayDeserializer() {
        this(null, null, null);
    }

    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    public String[] deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws JsonMappingException {
        int i;
        if (!jsonParser.isExpectedStartArrayToken()) {
            return handleNonArray(jsonParser, deserializationContext);
        }
        if (this._elementDeserializer != null) {
            return _deserializeCustom(jsonParser, deserializationContext, null);
        }
        ObjectBuffer objectBufferLeaseObjectBuffer = deserializationContext.leaseObjectBuffer();
        Object[] objArrResetAndStart = objectBufferLeaseObjectBuffer.resetAndStart();
        int i3 = 0;
        while (true) {
            try {
                String strNextTextValue = jsonParser.nextTextValue();
                try {
                    if (strNextTextValue == null) {
                        JsonToken jsonTokenCurrentToken = jsonParser.currentToken();
                        if (jsonTokenCurrentToken == JsonToken.END_ARRAY) {
                            String[] strArr = (String[]) objectBufferLeaseObjectBuffer.completeAndClearBuffer(objArrResetAndStart, i3, String.class);
                            deserializationContext.returnObjectBuffer(objectBufferLeaseObjectBuffer);
                            return strArr;
                        }
                        if (jsonTokenCurrentToken == JsonToken.VALUE_NULL) {
                            if (this._skipNullValues) {
                            }
                        } else {
                            strNextTextValue = _parseString(jsonParser, deserializationContext, this._nullProvider);
                        }
                        if (strNextTextValue != null || (strNextTextValue = (String) this._nullProvider.getNullValue(deserializationContext)) != null || !this._skipNullValues) {
                        }
                    }
                    objArrResetAndStart[i3] = strNextTextValue;
                    i3 = i;
                } catch (Exception e10) {
                    e = e10;
                    i3 = i;
                    throw JsonMappingException.wrapWithPath(e, objArrResetAndStart, objectBufferLeaseObjectBuffer.bufferedSize() + i3);
                }
                if (i3 >= objArrResetAndStart.length) {
                    objArrResetAndStart = objectBufferLeaseObjectBuffer.appendCompletedChunk(objArrResetAndStart);
                    i3 = 0;
                }
                i = i3 + 1;
            } catch (Exception e11) {
                e = e11;
            }
        }
    }
}
