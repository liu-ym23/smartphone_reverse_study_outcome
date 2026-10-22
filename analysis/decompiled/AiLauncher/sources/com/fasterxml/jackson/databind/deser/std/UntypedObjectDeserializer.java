package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.StreamReadCapability;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.fasterxml.jackson.databind.deser.ResolvableDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.type.LogicalType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.databind.util.ObjectBuffer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@JacksonStdImpl
/* loaded from: classes2.dex */
public class UntypedObjectDeserializer extends StdDeserializer<Object> implements ResolvableDeserializer, ContextualDeserializer {
    protected static final Object[] NO_OBJECTS = new Object[0];
    private static final long serialVersionUID = 1;
    private KeyDeserializer _customKeyDeserializer;
    protected JsonDeserializer<Object> _listDeserializer;
    protected JavaType _listType;
    protected JsonDeserializer<Object> _mapDeserializer;
    protected JavaType _mapType;
    protected final boolean _nonMerging;
    protected JsonDeserializer<Object> _numberDeserializer;
    protected JsonDeserializer<Object> _stringDeserializer;

    @Deprecated
    public UntypedObjectDeserializer() {
        this((JavaType) null, (JavaType) null);
    }

    private final String _customDeserializeKey(String str, DeserializationContext deserializationContext) throws IOException {
        KeyDeserializer keyDeserializer = this._customKeyDeserializer;
        return keyDeserializer != null ? (String) keyDeserializer.deserializeKey(str, deserializationContext) : str;
    }

    private final String _customDeserializeNullableKey(String str, DeserializationContext deserializationContext) throws IOException {
        KeyDeserializer keyDeserializer = this._customKeyDeserializer;
        return (keyDeserializer == null || str == null) ? str : (String) keyDeserializer.deserializeKey(str, deserializationContext);
    }

    private void _squashDups(Map<String, Object> map, String str, Object obj, Object obj2) {
        if (obj instanceof List) {
            ((List) obj).add(obj2);
            map.put(str, obj);
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.add(obj);
            arrayList.add(obj2);
            map.put(str, arrayList);
        }
    }

    public JsonDeserializer<Object> _clearIfStdImpl(JsonDeserializer<Object> jsonDeserializer) {
        if (ClassUtil.isJacksonStdImpl(jsonDeserializer)) {
            return null;
        }
        return jsonDeserializer;
    }

    public Object _deserializeFP(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonParser.NumberTypeFP numberTypeFP = jsonParser.getNumberTypeFP();
        return numberTypeFP == JsonParser.NumberTypeFP.BIG_DECIMAL ? jsonParser.getDecimalValue() : (jsonParser.isNaN() || !deserializationContext.isEnabled(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS)) ? numberTypeFP == JsonParser.NumberTypeFP.FLOAT32 ? Float.valueOf(jsonParser.getFloatValue()) : Double.valueOf(jsonParser.getDoubleValue()) : jsonParser.getDecimalValue();
    }

    public JsonDeserializer<Object> _findCustomDeser(DeserializationContext deserializationContext, JavaType javaType) throws JsonMappingException {
        return deserializationContext.findNonContextualValueDeserializer(javaType);
    }

    public Object _mapObjectWithDups(JsonParser jsonParser, DeserializationContext deserializationContext, Map<String, Object> map, String str, Object obj, Object obj2, String str2) throws IOException {
        boolean zIsEnabled = deserializationContext.isEnabled(StreamReadCapability.DUPLICATE_PROPERTIES);
        if (zIsEnabled) {
            _squashDups(map, str, obj, obj2);
        }
        while (str2 != null) {
            jsonParser.nextToken();
            Object objDeserialize = deserialize(jsonParser, deserializationContext);
            Object objPut = map.put(str2, objDeserialize);
            if (objPut != null && zIsEnabled) {
                _squashDups(map, str, objPut, objDeserialize);
            }
            str2 = _customDeserializeNullableKey(jsonParser.nextFieldName(), deserializationContext);
        }
        return map;
    }

    @Override // com.fasterxml.jackson.databind.deser.ContextualDeserializer
    public JsonDeserializer<?> createContextual(DeserializationContext deserializationContext, BeanProperty beanProperty) throws JsonMappingException {
        boolean z10 = beanProperty == null && Boolean.FALSE.equals(deserializationContext.getConfig().getDefaultMergeable(Object.class));
        KeyDeserializer keyDeserializerFindKeyDeserializer = deserializationContext.findKeyDeserializer(deserializationContext.constructType(Object.class), beanProperty);
        if (keyDeserializerFindKeyDeserializer != null && ClassUtil.isJacksonStdImpl(keyDeserializerFindKeyDeserializer)) {
            keyDeserializerFindKeyDeserializer = null;
        }
        if (this._stringDeserializer == null && this._numberDeserializer == null && this._mapDeserializer == null && this._listDeserializer == null && keyDeserializerFindKeyDeserializer == null && getClass() == UntypedObjectDeserializer.class) {
            return UntypedObjectDeserializerNR.instance(z10);
        }
        if (z10 != this._nonMerging) {
            this = new UntypedObjectDeserializer(this, z10);
        }
        return keyDeserializerFindKeyDeserializer != null ? new UntypedObjectDeserializer(this, keyDeserializerFindKeyDeserializer) : this;
    }

    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        switch (jsonParser.currentTokenId()) {
            case 1:
            case 2:
            case 5:
                JsonDeserializer<Object> jsonDeserializer = this._mapDeserializer;
                return jsonDeserializer != null ? jsonDeserializer.deserialize(jsonParser, deserializationContext) : mapObject(jsonParser, deserializationContext);
            case 3:
                if (deserializationContext.isEnabled(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY)) {
                    return mapArrayToArray(jsonParser, deserializationContext);
                }
                JsonDeserializer<Object> jsonDeserializer2 = this._listDeserializer;
                return jsonDeserializer2 != null ? jsonDeserializer2.deserialize(jsonParser, deserializationContext) : mapArray(jsonParser, deserializationContext);
            case 4:
            default:
                return deserializationContext.handleUnexpectedToken(Object.class, jsonParser);
            case 6:
                JsonDeserializer<Object> jsonDeserializer3 = this._stringDeserializer;
                return jsonDeserializer3 != null ? jsonDeserializer3.deserialize(jsonParser, deserializationContext) : jsonParser.getText();
            case 7:
                JsonDeserializer<Object> jsonDeserializer4 = this._numberDeserializer;
                return jsonDeserializer4 != null ? jsonDeserializer4.deserialize(jsonParser, deserializationContext) : deserializationContext.hasSomeOfFeatures(StdDeserializer.F_MASK_INT_COERCIONS) ? _coerceIntegral(jsonParser, deserializationContext) : jsonParser.getNumberValue();
            case 8:
                JsonDeserializer<Object> jsonDeserializer5 = this._numberDeserializer;
                return jsonDeserializer5 != null ? jsonDeserializer5.deserialize(jsonParser, deserializationContext) : _deserializeFP(jsonParser, deserializationContext);
            case 9:
                return Boolean.TRUE;
            case 10:
                return Boolean.FALSE;
            case 11:
                return null;
            case 12:
                return jsonParser.getEmbeddedObject();
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer, com.fasterxml.jackson.databind.JsonDeserializer
    public Object deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, TypeDeserializer typeDeserializer) throws IOException {
        int iCurrentTokenId = jsonParser.currentTokenId();
        if (iCurrentTokenId != 1 && iCurrentTokenId != 3) {
            switch (iCurrentTokenId) {
                case 5:
                    break;
                case 6:
                    JsonDeserializer<Object> jsonDeserializer = this._stringDeserializer;
                    return jsonDeserializer != null ? jsonDeserializer.deserialize(jsonParser, deserializationContext) : jsonParser.getText();
                case 7:
                    JsonDeserializer<Object> jsonDeserializer2 = this._numberDeserializer;
                    return jsonDeserializer2 != null ? jsonDeserializer2.deserialize(jsonParser, deserializationContext) : deserializationContext.hasSomeOfFeatures(StdDeserializer.F_MASK_INT_COERCIONS) ? _coerceIntegral(jsonParser, deserializationContext) : jsonParser.getNumberValue();
                case 8:
                    JsonDeserializer<Object> jsonDeserializer3 = this._numberDeserializer;
                    return jsonDeserializer3 != null ? jsonDeserializer3.deserialize(jsonParser, deserializationContext) : _deserializeFP(jsonParser, deserializationContext);
                case 9:
                    return Boolean.TRUE;
                case 10:
                    return Boolean.FALSE;
                case 11:
                    return null;
                case 12:
                    return jsonParser.getEmbeddedObject();
                default:
                    return deserializationContext.handleUnexpectedToken(Object.class, jsonParser);
            }
        }
        return typeDeserializer.deserializeTypedFromAny(jsonParser, deserializationContext);
    }

    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    public boolean isCachable() {
        return true;
    }

    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    public LogicalType logicalType() {
        return LogicalType.Untyped;
    }

    public Object mapArray(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonToken jsonTokenNextToken = jsonParser.nextToken();
        JsonToken jsonToken = JsonToken.END_ARRAY;
        int i10 = 2;
        if (jsonTokenNextToken == jsonToken) {
            return new ArrayList(2);
        }
        Object objDeserialize = deserialize(jsonParser, deserializationContext);
        if (jsonParser.nextToken() == jsonToken) {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(objDeserialize);
            return arrayList;
        }
        Object objDeserialize2 = deserialize(jsonParser, deserializationContext);
        if (jsonParser.nextToken() == jsonToken) {
            ArrayList arrayList2 = new ArrayList(2);
            arrayList2.add(objDeserialize);
            arrayList2.add(objDeserialize2);
            return arrayList2;
        }
        ObjectBuffer objectBufferLeaseObjectBuffer = deserializationContext.leaseObjectBuffer();
        Object[] objArrResetAndStart = objectBufferLeaseObjectBuffer.resetAndStart();
        objArrResetAndStart[0] = objDeserialize;
        objArrResetAndStart[1] = objDeserialize2;
        int i11 = 2;
        while (true) {
            Object objDeserialize3 = deserialize(jsonParser, deserializationContext);
            i10++;
            if (i11 >= objArrResetAndStart.length) {
                objArrResetAndStart = objectBufferLeaseObjectBuffer.appendCompletedChunk(objArrResetAndStart);
                i11 = 0;
            }
            int i12 = i11 + 1;
            objArrResetAndStart[i11] = objDeserialize3;
            if (jsonParser.nextToken() == JsonToken.END_ARRAY) {
                ArrayList arrayList3 = new ArrayList(i10);
                objectBufferLeaseObjectBuffer.completeAndClearBuffer(objArrResetAndStart, i12, arrayList3);
                deserializationContext.returnObjectBuffer(objectBufferLeaseObjectBuffer);
                return arrayList3;
            }
            i11 = i12;
        }
    }

    public Object[] mapArrayToArray(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        if (jsonParser.nextToken() == JsonToken.END_ARRAY) {
            return NO_OBJECTS;
        }
        ObjectBuffer objectBufferLeaseObjectBuffer = deserializationContext.leaseObjectBuffer();
        Object[] objArrResetAndStart = objectBufferLeaseObjectBuffer.resetAndStart();
        int i10 = 0;
        while (true) {
            Object objDeserialize = deserialize(jsonParser, deserializationContext);
            if (i10 >= objArrResetAndStart.length) {
                objArrResetAndStart = objectBufferLeaseObjectBuffer.appendCompletedChunk(objArrResetAndStart);
                i10 = 0;
            }
            int i11 = i10 + 1;
            objArrResetAndStart[i10] = objDeserialize;
            if (jsonParser.nextToken() == JsonToken.END_ARRAY) {
                Object[] objArrCompleteAndClearBuffer = objectBufferLeaseObjectBuffer.completeAndClearBuffer(objArrResetAndStart, i11);
                deserializationContext.returnObjectBuffer(objectBufferLeaseObjectBuffer);
                return objArrCompleteAndClearBuffer;
            }
            i10 = i11;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object mapObject(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) throws java.io.IOException {
        /*
            r10 = this;
            com.fasterxml.jackson.core.JsonToken r1 = r11.currentToken()
            com.fasterxml.jackson.core.JsonToken r3 = com.fasterxml.jackson.core.JsonToken.START_OBJECT
            if (r1 != r3) goto Le
            java.lang.String r1 = r11.nextFieldName()
        Lc:
            r3 = r1
            goto L25
        Le:
            com.fasterxml.jackson.core.JsonToken r3 = com.fasterxml.jackson.core.JsonToken.FIELD_NAME
            if (r1 != r3) goto L17
            java.lang.String r1 = r11.currentName()
            goto Lc
        L17:
            com.fasterxml.jackson.core.JsonToken r3 = com.fasterxml.jackson.core.JsonToken.END_OBJECT
            if (r1 == r3) goto L24
            java.lang.Class r0 = r10.handledType()
            java.lang.Object r0 = r12.handleUnexpectedToken(r0, r11)
            return r0
        L24:
            r3 = 0
        L25:
            r4 = 2
            if (r3 != 0) goto L2e
            java.util.LinkedHashMap r0 = new java.util.LinkedHashMap
            r0.<init>(r4)
            return r0
        L2e:
            java.lang.String r3 = r10._customDeserializeKey(r3, r12)
            r11.nextToken()
            java.lang.Object r5 = r10.deserialize(r11, r12)
            java.lang.String r6 = r11.nextFieldName()
            if (r6 != 0) goto L48
            java.util.LinkedHashMap r0 = new java.util.LinkedHashMap
            r0.<init>(r4)
            r0.put(r3, r5)
            return r0
        L48:
            java.lang.String r4 = r10._customDeserializeKey(r6, r12)
            r11.nextToken()
            java.lang.Object r6 = r10.deserialize(r11, r12)
            java.lang.String r7 = r11.nextFieldName()
            if (r7 != 0) goto L74
            java.util.LinkedHashMap r8 = new java.util.LinkedHashMap
            r9 = 4
            r8.<init>(r9)
            r8.put(r3, r5)
            java.lang.Object r4 = r8.put(r4, r6)
            if (r4 == 0) goto L72
            r0 = r10
            r1 = r11
            r2 = r12
            r4 = r3
            r3 = r8
            java.lang.Object r0 = r0._mapObjectWithDups(r1, r2, r3, r4, r5, r6, r7)
            return r0
        L72:
            r3 = r8
            return r3
        L74:
            r1 = r3
            java.lang.String r7 = r10._customDeserializeKey(r7, r12)
            java.util.LinkedHashMap r3 = new java.util.LinkedHashMap
            r3.<init>()
            r3.put(r1, r5)
            java.lang.Object r4 = r3.put(r4, r6)
            if (r4 == 0) goto L90
            r0 = r10
            r2 = r12
            r4 = r1
            r1 = r11
            java.lang.Object r0 = r0._mapObjectWithDups(r1, r2, r3, r4, r5, r6, r7)
            return r0
        L90:
            r4 = r7
        L91:
            r11.nextToken()
            java.lang.Object r6 = r10.deserialize(r11, r12)
            java.lang.Object r5 = r3.put(r4, r6)
            if (r5 == 0) goto Lae
            java.lang.String r1 = r11.nextFieldName()
            java.lang.String r7 = r10._customDeserializeNullableKey(r1, r12)
            r0 = r10
            r1 = r11
            r2 = r12
            java.lang.Object r0 = r0._mapObjectWithDups(r1, r2, r3, r4, r5, r6, r7)
            return r0
        Lae:
            java.lang.String r1 = r11.nextFieldName()
            java.lang.String r4 = r10._customDeserializeNullableKey(r1, r12)
            if (r4 != 0) goto L91
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.std.UntypedObjectDeserializer.mapObject(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
    }

    @Override // com.fasterxml.jackson.databind.deser.ResolvableDeserializer
    public void resolve(DeserializationContext deserializationContext) throws JsonMappingException {
        JavaType javaTypeConstructType = deserializationContext.constructType(Object.class);
        JavaType javaTypeConstructType2 = deserializationContext.constructType(String.class);
        TypeFactory typeFactory = deserializationContext.getTypeFactory();
        JavaType javaType = this._listType;
        if (javaType == null) {
            this._listDeserializer = _clearIfStdImpl(_findCustomDeser(deserializationContext, typeFactory.constructCollectionType(List.class, javaTypeConstructType)));
        } else {
            this._listDeserializer = _findCustomDeser(deserializationContext, javaType);
        }
        JavaType javaType2 = this._mapType;
        if (javaType2 == null) {
            this._mapDeserializer = _clearIfStdImpl(_findCustomDeser(deserializationContext, typeFactory.constructMapType(Map.class, javaTypeConstructType2, javaTypeConstructType)));
        } else {
            this._mapDeserializer = _findCustomDeser(deserializationContext, javaType2);
        }
        this._stringDeserializer = _clearIfStdImpl(_findCustomDeser(deserializationContext, javaTypeConstructType2));
        this._numberDeserializer = _clearIfStdImpl(_findCustomDeser(deserializationContext, typeFactory.constructType(Number.class)));
        JavaType javaTypeUnknownType = TypeFactory.unknownType();
        this._mapDeserializer = deserializationContext.handleSecondaryContextualization(this._mapDeserializer, null, javaTypeUnknownType);
        this._listDeserializer = deserializationContext.handleSecondaryContextualization(this._listDeserializer, null, javaTypeUnknownType);
        this._stringDeserializer = deserializationContext.handleSecondaryContextualization(this._stringDeserializer, null, javaTypeUnknownType);
        this._numberDeserializer = deserializationContext.handleSecondaryContextualization(this._numberDeserializer, null, javaTypeUnknownType);
    }

    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    public Boolean supportsUpdate(DeserializationConfig deserializationConfig) {
        return null;
    }

    public UntypedObjectDeserializer(JavaType javaType, JavaType javaType2) {
        super((Class<?>) Object.class);
        this._listType = javaType;
        this._mapType = javaType2;
        this._nonMerging = false;
    }

    public UntypedObjectDeserializer(UntypedObjectDeserializer untypedObjectDeserializer, JsonDeserializer<?> jsonDeserializer, JsonDeserializer<?> jsonDeserializer2, JsonDeserializer<?> jsonDeserializer3, JsonDeserializer<?> jsonDeserializer4) {
        super((Class<?>) Object.class);
        this._mapDeserializer = jsonDeserializer;
        this._listDeserializer = jsonDeserializer2;
        this._stringDeserializer = jsonDeserializer3;
        this._numberDeserializer = jsonDeserializer4;
        this._listType = untypedObjectDeserializer._listType;
        this._mapType = untypedObjectDeserializer._mapType;
        this._customKeyDeserializer = untypedObjectDeserializer._customKeyDeserializer;
        this._nonMerging = untypedObjectDeserializer._nonMerging;
    }

    public UntypedObjectDeserializer(UntypedObjectDeserializer untypedObjectDeserializer, boolean z10) {
        super((Class<?>) Object.class);
        this._mapDeserializer = untypedObjectDeserializer._mapDeserializer;
        this._listDeserializer = untypedObjectDeserializer._listDeserializer;
        this._stringDeserializer = untypedObjectDeserializer._stringDeserializer;
        this._numberDeserializer = untypedObjectDeserializer._numberDeserializer;
        this._listType = untypedObjectDeserializer._listType;
        this._mapType = untypedObjectDeserializer._mapType;
        this._customKeyDeserializer = untypedObjectDeserializer._customKeyDeserializer;
        this._nonMerging = z10;
    }

    public UntypedObjectDeserializer(UntypedObjectDeserializer untypedObjectDeserializer, KeyDeserializer keyDeserializer) {
        super((Class<?>) Object.class);
        this._mapDeserializer = untypedObjectDeserializer._mapDeserializer;
        this._listDeserializer = untypedObjectDeserializer._listDeserializer;
        this._stringDeserializer = untypedObjectDeserializer._stringDeserializer;
        this._numberDeserializer = untypedObjectDeserializer._numberDeserializer;
        this._listType = untypedObjectDeserializer._listType;
        this._mapType = untypedObjectDeserializer._mapType;
        this._nonMerging = untypedObjectDeserializer._nonMerging;
        this._customKeyDeserializer = keyDeserializer;
    }

    public Object mapArray(JsonParser jsonParser, DeserializationContext deserializationContext, Collection<Object> collection) throws IOException {
        while (jsonParser.nextToken() != JsonToken.END_ARRAY) {
            collection.add(deserialize(jsonParser, deserializationContext));
        }
        return collection;
    }

    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) throws IOException {
        if (this._nonMerging) {
            return deserialize(jsonParser, deserializationContext);
        }
        switch (jsonParser.currentTokenId()) {
            case 1:
            case 2:
            case 5:
                JsonDeserializer<Object> jsonDeserializer = this._mapDeserializer;
                if (jsonDeserializer == null) {
                    if (!(obj instanceof Map)) {
                        break;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            case 3:
                JsonDeserializer<Object> jsonDeserializer2 = this._listDeserializer;
                if (jsonDeserializer2 == null) {
                    if (!(obj instanceof Collection)) {
                        if (!deserializationContext.isEnabled(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY)) {
                            break;
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            case 6:
                JsonDeserializer<Object> jsonDeserializer3 = this._stringDeserializer;
                if (jsonDeserializer3 == null) {
                    break;
                } else {
                    break;
                }
            case 7:
                JsonDeserializer<Object> jsonDeserializer4 = this._numberDeserializer;
                if (jsonDeserializer4 == null) {
                    if (!deserializationContext.hasSomeOfFeatures(StdDeserializer.F_MASK_INT_COERCIONS)) {
                        break;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            case 8:
                JsonDeserializer<Object> jsonDeserializer5 = this._numberDeserializer;
                if (jsonDeserializer5 == null) {
                    break;
                } else {
                    break;
                }
        }
        return deserialize(jsonParser, deserializationContext);
    }

    public Object mapObject(JsonParser jsonParser, DeserializationContext deserializationContext, Map<Object, Object> map) throws IOException {
        Object objDeserialize;
        JsonToken jsonTokenCurrentToken = jsonParser.currentToken();
        if (jsonTokenCurrentToken == JsonToken.START_OBJECT) {
            jsonTokenCurrentToken = jsonParser.nextToken();
        }
        if (jsonTokenCurrentToken == JsonToken.END_OBJECT) {
            return map;
        }
        String strCurrentName = jsonParser.currentName();
        do {
            jsonParser.nextToken();
            Object obj = map.get(strCurrentName);
            if (obj != null) {
                objDeserialize = deserialize(jsonParser, deserializationContext, obj);
            } else {
                objDeserialize = deserialize(jsonParser, deserializationContext);
            }
            if (objDeserialize != obj) {
                map.put(strCurrentName, objDeserialize);
            }
            strCurrentName = jsonParser.nextFieldName();
        } while (strCurrentName != null);
        return map;
    }
}
