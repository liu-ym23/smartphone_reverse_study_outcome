package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanProperty;
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
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.type.ArrayType;
import com.fasterxml.jackson.databind.type.LogicalType;
import com.fasterxml.jackson.databind.util.AccessPattern;
import com.fasterxml.jackson.databind.util.ObjectBuffer;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;

@JacksonStdImpl
/* loaded from: classes3.dex */
public class ObjectArrayDeserializer extends ContainerDeserializerBase<Object> implements ContextualDeserializer {
    private static final long serialVersionUID = 1;
    protected final Class<?> _elementClass;
    protected JsonDeserializer<Object> _elementDeserializer;
    protected final TypeDeserializer _elementTypeDeserializer;
    protected final Object[] _emptyValue;
    protected final boolean _untyped;

    public ObjectArrayDeserializer(JavaType javaType, JsonDeserializer<Object> jsonDeserializer, TypeDeserializer typeDeserializer) {
        super(javaType, (NullValueProvider) null, (Boolean) null);
        ArrayType arrayType = (ArrayType) javaType;
        Class<?> rawClass = arrayType.getContentType().getRawClass();
        this._elementClass = rawClass;
        this._untyped = rawClass == Object.class;
        this._elementDeserializer = jsonDeserializer;
        this._elementTypeDeserializer = typeDeserializer;
        this._emptyValue = arrayType.getEmptyArray();
    }

    public Object _deserializeNoNullChecks(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        TypeDeserializer typeDeserializer = this._elementTypeDeserializer;
        return typeDeserializer == null ? this._elementDeserializer.deserialize(jsonParser, deserializationContext) : this._elementDeserializer.deserializeWithType(jsonParser, deserializationContext, typeDeserializer);
    }

    @Override // com.fasterxml.jackson.databind.deser.ContextualDeserializer
    public JsonDeserializer<?> createContextual(DeserializationContext deserializationContext, BeanProperty beanProperty) throws JsonMappingException {
        JsonDeserializer<?> jsonDeserializer = this._elementDeserializer;
        Boolean boolFindFormatFeature = findFormatFeature(deserializationContext, beanProperty, this._containerType.getRawClass(), JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        JsonDeserializer<?> jsonDeserializerFindConvertingContentDeserializer = findConvertingContentDeserializer(deserializationContext, beanProperty, jsonDeserializer);
        JavaType contentType = this._containerType.getContentType();
        JsonDeserializer<?> jsonDeserializerFindContextualValueDeserializer = jsonDeserializerFindConvertingContentDeserializer == null ? deserializationContext.findContextualValueDeserializer(contentType, beanProperty) : deserializationContext.handleSecondaryContextualization(jsonDeserializerFindConvertingContentDeserializer, beanProperty, contentType);
        TypeDeserializer typeDeserializerForProperty = this._elementTypeDeserializer;
        if (typeDeserializerForProperty != null) {
            typeDeserializerForProperty = typeDeserializerForProperty.forProperty(beanProperty);
        }
        return withResolved(typeDeserializerForProperty, jsonDeserializerFindContextualValueDeserializer, findContentNullProvider(deserializationContext, beanProperty, jsonDeserializerFindContextualValueDeserializer), boolFindFormatFeature);
    }

    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        Object obj_deserializeNoNullChecks;
        if (!jsonParser.isExpectedStartArrayToken()) {
            return handleNonArray(jsonParser, deserializationContext);
        }
        ObjectBuffer objectBufferLeaseObjectBuffer = deserializationContext.leaseObjectBuffer();
        Object[] objArrResetAndStart = objectBufferLeaseObjectBuffer.resetAndStart();
        int i = 0;
        while (true) {
            try {
                JsonToken jsonTokenNextToken = jsonParser.nextToken();
                if (jsonTokenNextToken == JsonToken.END_ARRAY) {
                    break;
                }
                if (jsonTokenNextToken != JsonToken.VALUE_NULL) {
                    obj_deserializeNoNullChecks = _deserializeNoNullChecks(jsonParser, deserializationContext);
                } else if (!this._skipNullValues) {
                    obj_deserializeNoNullChecks = null;
                }
                if (obj_deserializeNoNullChecks != null || (obj_deserializeNoNullChecks = this._nullProvider.getNullValue(deserializationContext)) != null || !this._skipNullValues) {
                    if (i >= objArrResetAndStart.length) {
                        objArrResetAndStart = objectBufferLeaseObjectBuffer.appendCompletedChunk(objArrResetAndStart);
                        i = 0;
                    }
                    int i6 = i + 1;
                    try {
                        objArrResetAndStart[i] = obj_deserializeNoNullChecks;
                        i = i6;
                    } catch (Exception e) {
                        e = e;
                        i = i6;
                        throw JsonMappingException.wrapWithPath(e, objArrResetAndStart, objectBufferLeaseObjectBuffer.bufferedSize() + i);
                    }
                }
            } catch (Exception e6) {
                e = e6;
            }
        }
        Object[] objArrCompleteAndClearBuffer = this._untyped ? objectBufferLeaseObjectBuffer.completeAndClearBuffer(objArrResetAndStart, i) : objectBufferLeaseObjectBuffer.completeAndClearBuffer(objArrResetAndStart, i, this._elementClass);
        deserializationContext.returnObjectBuffer(objectBufferLeaseObjectBuffer);
        return objArrCompleteAndClearBuffer;
    }

    public Byte[] deserializeFromBase64(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        byte[] binaryValue = jsonParser.getBinaryValue(deserializationContext.getBase64Variant());
        Byte[] bArr = new Byte[binaryValue.length];
        int length = binaryValue.length;
        for (int i = 0; i < length; i++) {
            bArr[i] = Byte.valueOf(binaryValue[i]);
        }
        return bArr;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer, com.fasterxml.jackson.databind.JsonDeserializer
    public Object deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, TypeDeserializer typeDeserializer) throws IOException {
        return (Object[]) typeDeserializer.deserializeTypedFromArray(jsonParser, deserializationContext);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.ContainerDeserializerBase
    public JsonDeserializer<Object> getContentDeserializer() {
        return this._elementDeserializer;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.ContainerDeserializerBase, com.fasterxml.jackson.databind.JsonDeserializer
    public AccessPattern getEmptyAccessPattern() {
        return AccessPattern.CONSTANT;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.ContainerDeserializerBase, com.fasterxml.jackson.databind.JsonDeserializer
    public Object getEmptyValue(DeserializationContext deserializationContext) throws JsonMappingException {
        return this._emptyValue;
    }

    public Object handleNonArray(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        ObjectArrayDeserializer objectArrayDeserializer;
        JsonParser jsonParser2;
        DeserializationContext deserializationContext2;
        Object obj_deserializeNoNullChecks;
        Boolean bool = this._unwrapSingle;
        if (bool != Boolean.TRUE && (bool != null || !deserializationContext.isEnabled(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY))) {
            return jsonParser.hasToken(JsonToken.VALUE_STRING) ? this._elementClass == Byte.class ? deserializeFromBase64(jsonParser, deserializationContext) : _deserializeFromString(jsonParser, deserializationContext) : deserializationContext.handleUnexpectedToken(this._containerType, jsonParser);
        }
        if (jsonParser.hasToken(JsonToken.VALUE_NULL)) {
            if (this._skipNullValues) {
                return this._emptyValue;
            }
            obj_deserializeNoNullChecks = null;
            objectArrayDeserializer = this;
            deserializationContext2 = deserializationContext;
        } else if (jsonParser.hasToken(JsonToken.VALUE_STRING)) {
            String text = jsonParser.getText();
            if (text.isEmpty()) {
                CoercionAction coercionActionFindCoercionAction = deserializationContext.findCoercionAction(logicalType(), handledType(), CoercionInputShape.EmptyString);
                if (coercionActionFindCoercionAction != CoercionAction.Fail) {
                    return (Object[]) _deserializeFromEmptyString(jsonParser, deserializationContext, coercionActionFindCoercionAction, handledType(), "empty String (\"\")");
                }
                objectArrayDeserializer = this;
                jsonParser2 = jsonParser;
                deserializationContext2 = deserializationContext;
                obj_deserializeNoNullChecks = objectArrayDeserializer._deserializeNoNullChecks(jsonParser2, deserializationContext2);
            } else {
                objectArrayDeserializer = this;
                jsonParser2 = jsonParser;
                deserializationContext2 = deserializationContext;
                if (StdDeserializer._isBlank(text)) {
                    LogicalType logicalType = objectArrayDeserializer.logicalType();
                    Class<?> clsHandledType = objectArrayDeserializer.handledType();
                    CoercionAction coercionAction = CoercionAction.Fail;
                    CoercionAction coercionActionFindCoercionFromBlankString = deserializationContext2.findCoercionFromBlankString(logicalType, clsHandledType, coercionAction);
                    if (coercionActionFindCoercionFromBlankString != coercionAction) {
                        return (Object[]) objectArrayDeserializer._deserializeFromEmptyString(jsonParser2, deserializationContext2, coercionActionFindCoercionFromBlankString, objectArrayDeserializer.handledType(), "blank String (all whitespace)");
                    }
                }
                obj_deserializeNoNullChecks = objectArrayDeserializer._deserializeNoNullChecks(jsonParser2, deserializationContext2);
            }
        } else {
            objectArrayDeserializer = this;
            jsonParser2 = jsonParser;
            deserializationContext2 = deserializationContext;
            obj_deserializeNoNullChecks = objectArrayDeserializer._deserializeNoNullChecks(jsonParser2, deserializationContext2);
        }
        if (obj_deserializeNoNullChecks == null && (obj_deserializeNoNullChecks = objectArrayDeserializer._nullProvider.getNullValue(deserializationContext2)) == null && objectArrayDeserializer._skipNullValues) {
            return objectArrayDeserializer._emptyValue;
        }
        Object[] objArr = objectArrayDeserializer._untyped ? new Object[1] : (Object[]) Array.newInstance(objectArrayDeserializer._elementClass, 1);
        objArr[0] = obj_deserializeNoNullChecks;
        return objArr;
    }

    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    public boolean isCachable() {
        return this._elementDeserializer == null && this._elementTypeDeserializer == null;
    }

    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    public LogicalType logicalType() {
        return LogicalType.Array;
    }

    public ObjectArrayDeserializer withDeserializer(TypeDeserializer typeDeserializer, JsonDeserializer<?> jsonDeserializer) {
        return withResolved(typeDeserializer, jsonDeserializer, this._nullProvider, this._unwrapSingle);
    }

    public ObjectArrayDeserializer withResolved(TypeDeserializer typeDeserializer, JsonDeserializer<?> jsonDeserializer, NullValueProvider nullValueProvider, Boolean bool) {
        return (Objects.equals(bool, this._unwrapSingle) && nullValueProvider == this._nullProvider && jsonDeserializer == this._elementDeserializer && typeDeserializer == this._elementTypeDeserializer) ? this : new ObjectArrayDeserializer(this, jsonDeserializer, typeDeserializer, nullValueProvider, bool);
    }

    public ObjectArrayDeserializer(ObjectArrayDeserializer objectArrayDeserializer, JsonDeserializer<Object> jsonDeserializer, TypeDeserializer typeDeserializer, NullValueProvider nullValueProvider, Boolean bool) {
        super(objectArrayDeserializer, nullValueProvider, bool);
        this._elementClass = objectArrayDeserializer._elementClass;
        this._untyped = objectArrayDeserializer._untyped;
        this._emptyValue = objectArrayDeserializer._emptyValue;
        this._elementDeserializer = jsonDeserializer;
        this._elementTypeDeserializer = typeDeserializer;
    }

    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) throws IOException {
        Object[] objArrCompleteAndClearBuffer;
        Object obj_deserializeNoNullChecks;
        Object[] objArr = (Object[]) obj;
        if (!jsonParser.isExpectedStartArrayToken()) {
            Object[] objArr2 = (Object[]) handleNonArray(jsonParser, deserializationContext);
            if (objArr2 == null) {
                return objArr;
            }
            int length = objArr.length;
            Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr2.length + length);
            System.arraycopy(objArr2, 0, objArrCopyOf, length, objArr2.length);
            return objArrCopyOf;
        }
        ObjectBuffer objectBufferLeaseObjectBuffer = deserializationContext.leaseObjectBuffer();
        int length2 = objArr.length;
        Object[] objArrResetAndStart = objectBufferLeaseObjectBuffer.resetAndStart(objArr, length2);
        while (true) {
            try {
                JsonToken jsonTokenNextToken = jsonParser.nextToken();
                if (jsonTokenNextToken == JsonToken.END_ARRAY) {
                    break;
                }
                if (jsonTokenNextToken == JsonToken.VALUE_NULL) {
                    if (!this._skipNullValues) {
                        obj_deserializeNoNullChecks = null;
                    }
                } else {
                    obj_deserializeNoNullChecks = _deserializeNoNullChecks(jsonParser, deserializationContext);
                }
                if (obj_deserializeNoNullChecks != null || (obj_deserializeNoNullChecks = this._nullProvider.getNullValue(deserializationContext)) != null || !this._skipNullValues) {
                    if (length2 >= objArrResetAndStart.length) {
                        objArrResetAndStart = objectBufferLeaseObjectBuffer.appendCompletedChunk(objArrResetAndStart);
                        length2 = 0;
                    }
                    int i = length2 + 1;
                    try {
                        objArrResetAndStart[length2] = obj_deserializeNoNullChecks;
                        length2 = i;
                    } catch (Exception e) {
                        e = e;
                        length2 = i;
                        throw JsonMappingException.wrapWithPath(e, objArrResetAndStart, objectBufferLeaseObjectBuffer.bufferedSize() + length2);
                    }
                }
            } catch (Exception e6) {
                e = e6;
            }
        }
        if (this._untyped) {
            objArrCompleteAndClearBuffer = objectBufferLeaseObjectBuffer.completeAndClearBuffer(objArrResetAndStart, length2);
        } else {
            objArrCompleteAndClearBuffer = objectBufferLeaseObjectBuffer.completeAndClearBuffer(objArrResetAndStart, length2, this._elementClass);
        }
        deserializationContext.returnObjectBuffer(objectBufferLeaseObjectBuffer);
        return objArrCompleteAndClearBuffer;
    }
}
