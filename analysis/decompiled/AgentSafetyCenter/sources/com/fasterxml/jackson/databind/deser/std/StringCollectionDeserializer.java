package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.fasterxml.jackson.databind.deser.NullValueProvider;
import com.fasterxml.jackson.databind.deser.ValueInstantiator;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.type.LogicalType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
@JacksonStdImpl
/* loaded from: classes.dex */
public final class StringCollectionDeserializer extends ContainerDeserializerBase<Collection<String>> implements ContextualDeserializer {
    private static final long serialVersionUID = 1;
    private final JsonDeserializer<Object> _delegateDeserializer;
    private final JsonDeserializer<String> _valueDeserializer;
    private final ValueInstantiator _valueInstantiator;

    public StringCollectionDeserializer(JavaType javaType, JsonDeserializer<?> jsonDeserializer, ValueInstantiator valueInstantiator) {
        this(javaType, valueInstantiator, null, jsonDeserializer, jsonDeserializer, null);
    }

    private static Collection<String> castToCollection(Object obj) {
        if (obj != null) {
            if (obj.getClass() == ArrayList.class) {
                return (ArrayList) obj;
            }
            if (obj.getClass() == HashSet.class) {
                return (HashSet) obj;
            }
        }
        return (Collection) obj;
    }

    private Collection<String> deserializeUsingCustom(JsonParser jsonParser, DeserializationContext deserializationContext, Collection<String> collection, JsonDeserializer<String> jsonDeserializer) throws JsonMappingException {
        String strDeserialize;
        while (true) {
            try {
                if (jsonParser.nextTextValue() == null) {
                    JsonToken jsonTokenCurrentToken = jsonParser.currentToken();
                    if (jsonTokenCurrentToken == JsonToken.END_ARRAY) {
                        return collection;
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
                    collection.add(strDeserialize);
                }
            } catch (Exception e10) {
                throw JsonMappingException.wrapWithPath(e10, collection, collection.size());
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00ab A[Catch: Exception -> 0x00b3, TRY_ENTER, TryCatch #0 {Exception -> 0x00b3, blocks: (B:37:0x00ab, B:41:0x00b6), top: B:53:0x00a9 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b6 A[Catch: Exception -> 0x00b3, TRY_LEAVE, TryCatch #0 {Exception -> 0x00b3, blocks: (B:37:0x00ab, B:41:0x00b6), top: B:53:0x00a9 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.util.Collection<java.lang.String> handleNonArray(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12, java.util.Collection<java.lang.String> r13) throws com.fasterxml.jackson.databind.JsonMappingException {
        /*
            r10 = this;
            java.lang.Boolean r0 = r10._unwrapSingle
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            if (r0 == r1) goto L2b
            if (r0 != 0) goto L11
            com.fasterxml.jackson.databind.DeserializationFeature r0 = com.fasterxml.jackson.databind.DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY
            boolean r0 = r12.isEnabled(r0)
            if (r0 == 0) goto L11
            goto L2b
        L11:
            com.fasterxml.jackson.core.JsonToken r13 = com.fasterxml.jackson.core.JsonToken.VALUE_STRING
            boolean r13 = r11.hasToken(r13)
            if (r13 == 0) goto L20
            java.lang.Object r10 = r10._deserializeFromString(r11, r12)
            java.util.Collection r10 = (java.util.Collection) r10
            return r10
        L20:
            com.fasterxml.jackson.databind.JavaType r10 = r10._containerType
            java.lang.Object r10 = r12.handleUnexpectedToken(r10, r11)
            java.util.Collection r10 = castToCollection(r10)
            return r10
        L2b:
            com.fasterxml.jackson.databind.JsonDeserializer<java.lang.String> r0 = r10._valueDeserializer
            com.fasterxml.jackson.core.JsonToken r1 = r11.currentToken()
            com.fasterxml.jackson.core.JsonToken r2 = com.fasterxml.jackson.core.JsonToken.VALUE_NULL
            if (r1 != r2) goto L40
            boolean r11 = r10._skipNullValues
            if (r11 == 0) goto L3b
            goto Lce
        L3b:
            r11 = 0
            r0 = r10
            r2 = r12
            goto Lbd
        L40:
            com.fasterxml.jackson.core.JsonToken r1 = com.fasterxml.jackson.core.JsonToken.VALUE_STRING
            boolean r1 = r11.hasToken(r1)
            if (r1 == 0) goto L76
            java.lang.String r1 = r11.getText()
            boolean r2 = r1.isEmpty()
            if (r2 == 0) goto L7c
            com.fasterxml.jackson.databind.type.LogicalType r1 = r10.logicalType()
            java.lang.Class r2 = r10.handledType()
            com.fasterxml.jackson.databind.cfg.CoercionInputShape r3 = com.fasterxml.jackson.databind.cfg.CoercionInputShape.EmptyString
            com.fasterxml.jackson.databind.cfg.CoercionAction r7 = r12.findCoercionAction(r1, r2, r3)
            com.fasterxml.jackson.databind.cfg.CoercionAction r1 = com.fasterxml.jackson.databind.cfg.CoercionAction.Fail
            if (r7 == r1) goto L76
            java.lang.Class r8 = r10.handledType()
            java.lang.String r9 = "empty String (\"\")"
            r4 = r10
            r5 = r11
            r6 = r12
            java.lang.Object r10 = r4._deserializeFromEmptyString(r5, r6, r7, r8, r9)
            java.util.Collection r10 = castToCollection(r10)
            return r10
        L76:
            r1 = r0
            r0 = r10
            r10 = r1
            r1 = r11
            r2 = r12
            goto La9
        L7c:
            r4 = r10
            r5 = r11
            r2 = r12
            boolean r10 = com.fasterxml.jackson.databind.deser.std.StdDeserializer._isBlank(r1)
            if (r10 == 0) goto La6
            com.fasterxml.jackson.databind.type.LogicalType r10 = r4.logicalType()
            java.lang.Class r11 = r4.handledType()
            com.fasterxml.jackson.databind.cfg.CoercionAction r12 = com.fasterxml.jackson.databind.cfg.CoercionAction.Fail
            com.fasterxml.jackson.databind.cfg.CoercionAction r3 = r2.findCoercionFromBlankString(r10, r11, r12)
            if (r3 == r12) goto La6
            r0 = r4
            java.lang.Class r4 = r0.handledType()
            r1 = r5
            java.lang.String r5 = "blank String (all whitespace)"
            java.lang.Object r10 = r0._deserializeFromEmptyString(r1, r2, r3, r4, r5)
            java.util.Collection r10 = castToCollection(r10)
            return r10
        La6:
            r10 = r0
            r0 = r4
            r1 = r5
        La9:
            if (r10 != 0) goto Lb6
            com.fasterxml.jackson.databind.deser.NullValueProvider r10 = r0._nullProvider     // Catch: java.lang.Exception -> Lb3
            java.lang.String r10 = r0._parseString(r1, r2, r10)     // Catch: java.lang.Exception -> Lb3
        Lb1:
            r11 = r10
            goto Lbd
        Lb3:
            r0 = move-exception
            r10 = r0
            goto Ld3
        Lb6:
            java.lang.Object r10 = r10.deserialize(r1, r2)     // Catch: java.lang.Exception -> Lb3
            java.lang.String r10 = (java.lang.String) r10     // Catch: java.lang.Exception -> Lb3
            goto Lb1
        Lbd:
            if (r11 != 0) goto Lcf
            com.fasterxml.jackson.databind.deser.NullValueProvider r10 = r0._nullProvider
            java.lang.Object r10 = r10.getNullValue(r2)
            r11 = r10
            java.lang.String r11 = (java.lang.String) r11
            if (r11 != 0) goto Lcf
            boolean r10 = r0._skipNullValues
            if (r10 == 0) goto Lcf
        Lce:
            return r13
        Lcf:
            r13.add(r11)
            return r13
        Ld3:
            int r11 = r13.size()
            com.fasterxml.jackson.databind.JsonMappingException r10 = com.fasterxml.jackson.databind.JsonMappingException.wrapWithPath(r10, r13, r11)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.std.StringCollectionDeserializer.handleNonArray(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext, java.util.Collection):java.util.Collection");
    }

    private StringCollectionDeserializer withResolved(JsonDeserializer<?> jsonDeserializer, JsonDeserializer<?> jsonDeserializer2, NullValueProvider nullValueProvider, Boolean bool) {
        return (Objects.equals(this._unwrapSingle, bool) && this._nullProvider == nullValueProvider && this._valueDeserializer == jsonDeserializer2 && this._delegateDeserializer == jsonDeserializer) ? this : new StringCollectionDeserializer(this._containerType, this._valueInstantiator, jsonDeserializer, jsonDeserializer2, nullValueProvider, bool);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002f  */
    @Override // com.fasterxml.jackson.databind.deser.ContextualDeserializer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.fasterxml.jackson.databind.JsonDeserializer<?> createContextual(com.fasterxml.jackson.databind.DeserializationContext r6, com.fasterxml.jackson.databind.BeanProperty r7) {
        /*
            r5 = this;
            com.fasterxml.jackson.databind.deser.ValueInstantiator r0 = r5._valueInstantiator
            r1 = 0
            if (r0 == 0) goto L2f
            com.fasterxml.jackson.databind.introspect.AnnotatedWithParams r0 = r0.getArrayDelegateCreator()
            com.fasterxml.jackson.databind.deser.ValueInstantiator r2 = r5._valueInstantiator
            if (r0 == 0) goto L1a
            com.fasterxml.jackson.databind.DeserializationConfig r0 = r6.getConfig()
            com.fasterxml.jackson.databind.JavaType r0 = r2.getArrayDelegateType(r0)
            com.fasterxml.jackson.databind.JsonDeserializer r0 = r5.findDeserializer(r6, r0, r7)
            goto L30
        L1a:
            com.fasterxml.jackson.databind.introspect.AnnotatedWithParams r0 = r2.getDelegateCreator()
            if (r0 == 0) goto L2f
            com.fasterxml.jackson.databind.deser.ValueInstantiator r0 = r5._valueInstantiator
            com.fasterxml.jackson.databind.DeserializationConfig r2 = r6.getConfig()
            com.fasterxml.jackson.databind.JavaType r0 = r0.getDelegateType(r2)
            com.fasterxml.jackson.databind.JsonDeserializer r0 = r5.findDeserializer(r6, r0, r7)
            goto L30
        L2f:
            r0 = r1
        L30:
            com.fasterxml.jackson.databind.JsonDeserializer<java.lang.String> r2 = r5._valueDeserializer
            com.fasterxml.jackson.databind.JavaType r3 = r5._containerType
            com.fasterxml.jackson.databind.JavaType r3 = r3.getContentType()
            if (r2 != 0) goto L45
            com.fasterxml.jackson.databind.JsonDeserializer r2 = r5.findConvertingContentDeserializer(r6, r7, r2)
            if (r2 != 0) goto L49
            com.fasterxml.jackson.databind.JsonDeserializer r2 = r6.findContextualValueDeserializer(r3, r7)
            goto L49
        L45:
            com.fasterxml.jackson.databind.JsonDeserializer r2 = r6.handleSecondaryContextualization(r2, r7, r3)
        L49:
            java.lang.Class<java.util.Collection> r3 = java.util.Collection.class
            com.fasterxml.jackson.annotation.JsonFormat$Feature r4 = com.fasterxml.jackson.annotation.JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY
            java.lang.Boolean r3 = r5.findFormatFeature(r6, r7, r3, r4)
            com.fasterxml.jackson.databind.deser.NullValueProvider r6 = r5.findContentNullProvider(r6, r7, r2)
            boolean r7 = r5.isDefaultDeserializer(r2)
            if (r7 == 0) goto L5c
            goto L5d
        L5c:
            r1 = r2
        L5d:
            com.fasterxml.jackson.databind.deser.std.StringCollectionDeserializer r5 = r5.withResolved(r0, r1, r6, r3)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.std.StringCollectionDeserializer.createContextual(com.fasterxml.jackson.databind.DeserializationContext, com.fasterxml.jackson.databind.BeanProperty):com.fasterxml.jackson.databind.JsonDeserializer");
    }

    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    public Collection<String> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext, Collection<String> collection) throws JsonMappingException {
        if (!jsonParser.isExpectedStartArrayToken()) {
            return handleNonArray(jsonParser, deserializationContext, collection);
        }
        JsonDeserializer<String> jsonDeserializer = this._valueDeserializer;
        if (jsonDeserializer != null) {
            return deserializeUsingCustom(jsonParser, deserializationContext, collection, jsonDeserializer);
        }
        while (true) {
            try {
                String strNextTextValue = jsonParser.nextTextValue();
                if (strNextTextValue != null) {
                    collection.add(strNextTextValue);
                } else {
                    JsonToken jsonTokenCurrentToken = jsonParser.currentToken();
                    if (jsonTokenCurrentToken == JsonToken.END_ARRAY) {
                        return collection;
                    }
                    if (jsonTokenCurrentToken != JsonToken.VALUE_NULL) {
                        strNextTextValue = _parseString(jsonParser, deserializationContext, this._nullProvider);
                    } else if (this._skipNullValues) {
                    }
                    if (strNextTextValue != null || (strNextTextValue = (String) this._nullProvider.getNullValue(deserializationContext)) != null || !this._skipNullValues) {
                        collection.add(strNextTextValue);
                    }
                }
            } catch (Exception e10) {
                throw JsonMappingException.wrapWithPath(e10, collection, collection.size());
            }
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer, com.fasterxml.jackson.databind.JsonDeserializer
    public Object deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, TypeDeserializer typeDeserializer) {
        return typeDeserializer.deserializeTypedFromArray(jsonParser, deserializationContext);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.ContainerDeserializerBase
    public JsonDeserializer<Object> getContentDeserializer() {
        return this._valueDeserializer;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer, com.fasterxml.jackson.databind.deser.ValueInstantiator.Gettable
    public ValueInstantiator getValueInstantiator() {
        return this._valueInstantiator;
    }

    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    public boolean isCachable() {
        return this._valueDeserializer == null && this._delegateDeserializer == null;
    }

    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    public LogicalType logicalType() {
        return LogicalType.Collection;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private StringCollectionDeserializer(JavaType javaType, ValueInstantiator valueInstantiator, JsonDeserializer<?> jsonDeserializer, JsonDeserializer<?> jsonDeserializer2, NullValueProvider nullValueProvider, Boolean bool) {
        super(javaType, nullValueProvider, bool);
        this._valueDeserializer = jsonDeserializer2;
        this._valueInstantiator = valueInstantiator;
        this._delegateDeserializer = jsonDeserializer;
    }

    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    public Collection<String> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) {
        JsonDeserializer<Object> jsonDeserializer = this._delegateDeserializer;
        ValueInstantiator valueInstantiator = this._valueInstantiator;
        if (jsonDeserializer != null) {
            return castToCollection(valueInstantiator.createUsingDelegate(deserializationContext, jsonDeserializer.deserialize(jsonParser, deserializationContext)));
        }
        return deserialize(jsonParser, deserializationContext, castToCollection(valueInstantiator.createUsingDefault(deserializationContext)));
    }
}
