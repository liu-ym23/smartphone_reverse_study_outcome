package com.fasterxml.jackson.databind.deser;

import androidx.activity.b;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.cfg.CoercionAction;
import com.fasterxml.jackson.databind.deser.impl.BeanAsArrayBuilderDeserializer;
import com.fasterxml.jackson.databind.deser.impl.BeanPropertyMap;
import com.fasterxml.jackson.databind.deser.impl.ExternalTypeHandler;
import com.fasterxml.jackson.databind.deser.impl.ObjectIdReader;
import com.fasterxml.jackson.databind.deser.impl.PropertyBasedCreator;
import com.fasterxml.jackson.databind.deser.impl.PropertyValueBuffer;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.databind.util.IgnorePropertiesUtil;
import com.fasterxml.jackson.databind.util.NameTransformer;
import com.fasterxml.jackson.databind.util.TokenBuffer;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import od.f;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class BuilderBasedDeserializer extends BeanDeserializerBase {
    private static final long serialVersionUID = 1;
    protected final AnnotatedMethod _buildMethod;
    protected final JavaType _targetType;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    /* renamed from: com.fasterxml.jackson.databind.deser.BuilderBasedDeserializer$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$fasterxml$jackson$databind$cfg$CoercionAction;

        static {
            int[] iArr = new int[CoercionAction.values().length];
            $SwitchMap$com$fasterxml$jackson$databind$cfg$CoercionAction = iArr;
            try {
                iArr[CoercionAction.AsEmpty.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$databind$cfg$CoercionAction[CoercionAction.AsNull.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$databind$cfg$CoercionAction[CoercionAction.TryConvert.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public BuilderBasedDeserializer(BeanDeserializerBuilder beanDeserializerBuilder, BeanDescription beanDescription, JavaType javaType, BeanPropertyMap beanPropertyMap, Map<String, SettableBeanProperty> map, Set<String> set, boolean z10, Set<String> set2, boolean z11) {
        super(beanDeserializerBuilder, beanDescription, beanPropertyMap, map, set, z10, set2, z11);
        this._targetType = javaType;
        this._buildMethod = beanDeserializerBuilder.getBuildMethod();
        if (this._objectIdReader == null) {
            return;
        }
        f.m("Cannot use Object Id with Builder-based deserialization (type ", beanDescription.getType(), ")");
        throw null;
    }

    private final Object vanillaDeserialize(JsonParser jsonParser, DeserializationContext deserializationContext, JsonToken jsonToken) throws JsonMappingException {
        Object objCreateUsingDefault = this._valueInstantiator.createUsingDefault(deserializationContext);
        while (jsonParser.currentToken() == JsonToken.FIELD_NAME) {
            String strCurrentName = jsonParser.currentName();
            jsonParser.nextToken();
            SettableBeanProperty settableBeanPropertyFind = this._beanProperties.find(strCurrentName);
            if (settableBeanPropertyFind != null) {
                try {
                    objCreateUsingDefault = settableBeanPropertyFind.deserializeSetAndReturn(jsonParser, deserializationContext, objCreateUsingDefault);
                } catch (Exception e10) {
                    wrapAndThrow(e10, objCreateUsingDefault, strCurrentName, deserializationContext);
                }
            } else {
                handleUnknownVanilla(jsonParser, deserializationContext, objCreateUsingDefault, strCurrentName);
            }
            jsonParser.nextToken();
        }
        return objCreateUsingDefault;
    }

    public final Object _deserialize(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) throws JsonMappingException {
        Class<?> activeView;
        if (this._injectables != null) {
            injectValues(deserializationContext, obj);
        }
        if (this._unwrappedPropertyHandler != null) {
            if (jsonParser.hasToken(JsonToken.START_OBJECT)) {
                jsonParser.nextToken();
            }
            TokenBuffer tokenBufferBufferForInputBuffering = deserializationContext.bufferForInputBuffering(jsonParser);
            tokenBufferBufferForInputBuffering.writeStartObject();
            return deserializeWithUnwrapped(jsonParser, deserializationContext, obj, tokenBufferBufferForInputBuffering);
        }
        if (this._externalTypeIdHandler != null) {
            return deserializeWithExternalTypeId(jsonParser, deserializationContext, obj);
        }
        if (this._needViewProcesing && (activeView = deserializationContext.getActiveView()) != null) {
            return deserializeWithView(jsonParser, deserializationContext, obj, activeView);
        }
        JsonToken jsonTokenCurrentToken = jsonParser.currentToken();
        if (jsonTokenCurrentToken == JsonToken.START_OBJECT) {
            jsonTokenCurrentToken = jsonParser.nextToken();
        }
        while (jsonTokenCurrentToken == JsonToken.FIELD_NAME) {
            String strCurrentName = jsonParser.currentName();
            jsonParser.nextToken();
            SettableBeanProperty settableBeanPropertyFind = this._beanProperties.find(strCurrentName);
            if (settableBeanPropertyFind != null) {
                try {
                    obj = settableBeanPropertyFind.deserializeSetAndReturn(jsonParser, deserializationContext, obj);
                } catch (Exception e10) {
                    wrapAndThrow(e10, obj, strCurrentName, deserializationContext);
                }
            } else {
                handleUnknownVanilla(jsonParser, deserializationContext, obj, strCurrentName);
            }
            jsonTokenCurrentToken = jsonParser.nextToken();
        }
        return obj;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer
    public Object _deserializeFromArray(JsonParser jsonParser, DeserializationContext deserializationContext) throws JsonMappingException {
        JsonParser jsonParser2;
        DeserializationContext deserializationContext2;
        JsonDeserializer<Object> jsonDeserializer = this._arrayDelegateDeserializer;
        if (jsonDeserializer != null || (jsonDeserializer = this._delegateDeserializer) != null) {
            Object objCreateUsingArrayDelegate = this._valueInstantiator.createUsingArrayDelegate(deserializationContext, jsonDeserializer.deserialize(jsonParser, deserializationContext));
            if (this._injectables != null) {
                injectValues(deserializationContext, objCreateUsingArrayDelegate);
            }
            return finishBuild(deserializationContext, objCreateUsingArrayDelegate);
        }
        CoercionAction coercionAction_findCoercionFromEmptyArray = _findCoercionFromEmptyArray(deserializationContext);
        boolean zIsEnabled = deserializationContext.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS);
        if (zIsEnabled || coercionAction_findCoercionFromEmptyArray != CoercionAction.Fail) {
            JsonToken jsonTokenNextToken = jsonParser.nextToken();
            JsonToken jsonToken = JsonToken.END_ARRAY;
            if (jsonTokenNextToken == jsonToken) {
                int i = AnonymousClass1.$SwitchMap$com$fasterxml$jackson$databind$cfg$CoercionAction[coercionAction_findCoercionFromEmptyArray.ordinal()];
                return i != 1 ? (i == 2 || i == 3) ? getNullValue(deserializationContext) : deserializationContext.handleUnexpectedToken(getValueType(deserializationContext), JsonToken.START_ARRAY, jsonParser, (String) null, new Object[0]) : getEmptyValue(deserializationContext);
            }
            jsonParser2 = jsonParser;
            deserializationContext2 = deserializationContext;
            if (zIsEnabled) {
                Object objDeserialize = deserialize(jsonParser2, deserializationContext2);
                if (jsonParser2.nextToken() != jsonToken) {
                    handleMissingEndArrayForSingle(jsonParser2, deserializationContext2);
                }
                return objDeserialize;
            }
        } else {
            jsonParser2 = jsonParser;
            deserializationContext2 = deserializationContext;
        }
        return deserializationContext2.handleUnexpectedToken(getValueType(deserializationContext2), jsonParser2);
    }

    @Override // com.fasterxml.jackson.databind.deser.BeanDeserializerBase
    public Object _deserializeUsingPropertyBased(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        Object objWrapInstantiationProblem;
        BuilderBasedDeserializer builderBasedDeserializer;
        JsonParser jsonParser2;
        DeserializationContext deserializationContext2;
        PropertyBasedCreator propertyBasedCreator = this._propertyBasedCreator;
        PropertyValueBuffer propertyValueBufferStartBuilding = propertyBasedCreator.startBuilding(jsonParser, deserializationContext, this._objectIdReader);
        Class<?> activeView = this._needViewProcesing ? deserializationContext.getActiveView() : null;
        JsonToken jsonTokenCurrentToken = jsonParser.currentToken();
        TokenBuffer tokenBufferBufferForInputBuffering = null;
        while (jsonTokenCurrentToken == JsonToken.FIELD_NAME) {
            String strCurrentName = jsonParser.currentName();
            jsonParser.nextToken();
            SettableBeanProperty settableBeanPropertyFindCreatorProperty = propertyBasedCreator.findCreatorProperty(strCurrentName);
            if (propertyValueBufferStartBuilding.readIdProperty(strCurrentName) && settableBeanPropertyFindCreatorProperty == null) {
                builderBasedDeserializer = this;
                jsonParser2 = jsonParser;
                deserializationContext2 = deserializationContext;
            } else if (settableBeanPropertyFindCreatorProperty != null) {
                if (activeView != null && !settableBeanPropertyFindCreatorProperty.visibleInView(activeView)) {
                    jsonParser.skipChildren();
                } else if (propertyValueBufferStartBuilding.assignParameter(settableBeanPropertyFindCreatorProperty, settableBeanPropertyFindCreatorProperty.deserialize(jsonParser, deserializationContext))) {
                    jsonParser.nextToken();
                    try {
                        Object objBuild = propertyBasedCreator.build(deserializationContext, propertyValueBufferStartBuilding);
                        if (objBuild.getClass() != this._beanType.getRawClass()) {
                            return this.handlePolymorphic(jsonParser, deserializationContext, jsonParser.streamReadConstraints(), objBuild, tokenBufferBufferForInputBuffering);
                        }
                        BuilderBasedDeserializer builderBasedDeserializer2 = this;
                        JsonParser jsonParser3 = jsonParser;
                        DeserializationContext deserializationContext3 = deserializationContext;
                        if (tokenBufferBufferForInputBuffering != null) {
                            objBuild = builderBasedDeserializer2.handleUnknownProperties(deserializationContext3, objBuild, tokenBufferBufferForInputBuffering);
                        }
                        return builderBasedDeserializer2._deserialize(jsonParser3, deserializationContext3, objBuild);
                    } catch (Exception e10) {
                        builderBasedDeserializer = this;
                        jsonParser2 = jsonParser;
                        deserializationContext2 = deserializationContext;
                        builderBasedDeserializer.wrapAndThrow(e10, builderBasedDeserializer._beanType.getRawClass(), strCurrentName, deserializationContext2);
                    }
                }
                builderBasedDeserializer = this;
                jsonParser2 = jsonParser;
                deserializationContext2 = deserializationContext;
            } else {
                builderBasedDeserializer = this;
                jsonParser2 = jsonParser;
                deserializationContext2 = deserializationContext;
                SettableBeanProperty settableBeanPropertyFind = builderBasedDeserializer._beanProperties.find(strCurrentName);
                if (settableBeanPropertyFind != null) {
                    propertyValueBufferStartBuilding.bufferProperty(settableBeanPropertyFind, settableBeanPropertyFind.deserialize(jsonParser2, deserializationContext2));
                } else if (IgnorePropertiesUtil.shouldIgnore(strCurrentName, builderBasedDeserializer._ignorableProps, builderBasedDeserializer._includableProps)) {
                    builderBasedDeserializer.handleIgnoredProperty(jsonParser2, deserializationContext2, builderBasedDeserializer.handledType(), strCurrentName);
                } else {
                    SettableAnyProperty settableAnyProperty = builderBasedDeserializer._anySetter;
                    if (settableAnyProperty != null) {
                        propertyValueBufferStartBuilding.bufferAnyProperty(settableAnyProperty, strCurrentName, settableAnyProperty.deserialize(jsonParser2, deserializationContext2));
                    } else {
                        if (tokenBufferBufferForInputBuffering == null) {
                            tokenBufferBufferForInputBuffering = deserializationContext2.bufferForInputBuffering(jsonParser2);
                        }
                        tokenBufferBufferForInputBuffering.writeFieldName(strCurrentName);
                        tokenBufferBufferForInputBuffering.copyCurrentStructure(jsonParser2);
                    }
                }
            }
            jsonTokenCurrentToken = jsonParser2.nextToken();
            this = builderBasedDeserializer;
            jsonParser = jsonParser2;
            deserializationContext = deserializationContext2;
        }
        BuilderBasedDeserializer builderBasedDeserializer3 = this;
        JsonParser jsonParser4 = jsonParser;
        DeserializationContext deserializationContext4 = deserializationContext;
        try {
            objWrapInstantiationProblem = propertyBasedCreator.build(deserializationContext4, propertyValueBufferStartBuilding);
        } catch (Exception e11) {
            objWrapInstantiationProblem = builderBasedDeserializer3.wrapInstantiationProblem(e11, deserializationContext4);
        }
        Object obj = objWrapInstantiationProblem;
        return tokenBufferBufferForInputBuffering != null ? obj.getClass() != builderBasedDeserializer3._beanType.getRawClass() ? builderBasedDeserializer3.handlePolymorphic(null, deserializationContext4, jsonParser4.streamReadConstraints(), obj, tokenBufferBufferForInputBuffering) : builderBasedDeserializer3.handleUnknownProperties(deserializationContext4, obj, tokenBufferBufferForInputBuffering) : obj;
    }

    @Override // com.fasterxml.jackson.databind.deser.BeanDeserializerBase
    public BeanDeserializerBase asArrayDeserializer() {
        return new BeanAsArrayBuilderDeserializer(this, this._targetType, this._beanProperties.getPropertiesInInsertionOrder(), this._buildMethod);
    }

    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) {
        if (jsonParser.isExpectedStartObjectToken()) {
            return this._vanillaProcessing ? finishBuild(deserializationContext, vanillaDeserialize(jsonParser, deserializationContext, jsonParser.nextToken())) : finishBuild(deserializationContext, deserializeFromObject(jsonParser, deserializationContext));
        }
        switch (jsonParser.currentTokenId()) {
            case 2:
            case 5:
                return finishBuild(deserializationContext, deserializeFromObject(jsonParser, deserializationContext));
            case 3:
                return _deserializeFromArray(jsonParser, deserializationContext);
            case 4:
            case 11:
            default:
                return deserializationContext.handleUnexpectedToken(getValueType(deserializationContext), jsonParser);
            case 6:
                return finishBuild(deserializationContext, deserializeFromString(jsonParser, deserializationContext));
            case 7:
                return finishBuild(deserializationContext, deserializeFromNumber(jsonParser, deserializationContext));
            case 8:
                return finishBuild(deserializationContext, deserializeFromDouble(jsonParser, deserializationContext));
            case 9:
            case 10:
                return finishBuild(deserializationContext, deserializeFromBoolean(jsonParser, deserializationContext));
            case 12:
                return jsonParser.getEmbeddedObject();
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.BeanDeserializerBase
    public Object deserializeFromObject(JsonParser jsonParser, DeserializationContext deserializationContext) throws JsonMappingException {
        Class<?> activeView;
        if (this._nonStandardCreation) {
            return this._unwrappedPropertyHandler != null ? deserializeWithUnwrapped(jsonParser, deserializationContext) : this._externalTypeIdHandler != null ? deserializeWithExternalTypeId(jsonParser, deserializationContext) : deserializeFromObjectUsingNonDefault(jsonParser, deserializationContext);
        }
        Object objCreateUsingDefault = this._valueInstantiator.createUsingDefault(deserializationContext);
        if (this._injectables != null) {
            injectValues(deserializationContext, objCreateUsingDefault);
        }
        if (this._needViewProcesing && (activeView = deserializationContext.getActiveView()) != null) {
            return deserializeWithView(jsonParser, deserializationContext, objCreateUsingDefault, activeView);
        }
        while (jsonParser.currentToken() == JsonToken.FIELD_NAME) {
            String strCurrentName = jsonParser.currentName();
            jsonParser.nextToken();
            SettableBeanProperty settableBeanPropertyFind = this._beanProperties.find(strCurrentName);
            if (settableBeanPropertyFind != null) {
                try {
                    objCreateUsingDefault = settableBeanPropertyFind.deserializeSetAndReturn(jsonParser, deserializationContext, objCreateUsingDefault);
                } catch (Exception e10) {
                    wrapAndThrow(e10, objCreateUsingDefault, strCurrentName, deserializationContext);
                }
            } else {
                handleUnknownVanilla(jsonParser, deserializationContext, objCreateUsingDefault, strCurrentName);
            }
            jsonParser.nextToken();
        }
        return objCreateUsingDefault;
    }

    public Object deserializeUsingPropertyBasedWithExternalTypeId(JsonParser jsonParser, DeserializationContext deserializationContext) {
        JavaType javaType = this._targetType;
        return deserializationContext.reportBadDefinition(javaType, String.format("Deserialization (of %s) with Builder, External type id, @JsonCreator not yet implemented", javaType));
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object deserializeUsingPropertyBasedWithUnwrapped(com.fasterxml.jackson.core.JsonParser r10, com.fasterxml.jackson.databind.DeserializationContext r11) throws com.fasterxml.jackson.databind.JsonMappingException {
        /*
            r9 = this;
            com.fasterxml.jackson.databind.deser.impl.PropertyBasedCreator r1 = r9._propertyBasedCreator
            com.fasterxml.jackson.databind.deser.impl.ObjectIdReader r0 = r9._objectIdReader
            com.fasterxml.jackson.databind.deser.impl.PropertyValueBuffer r2 = r1.startBuilding(r10, r11, r0)
            com.fasterxml.jackson.databind.util.TokenBuffer r8 = r11.bufferForInputBuffering(r10)
            r8.writeStartObject()
            com.fasterxml.jackson.core.JsonToken r0 = r10.currentToken()
        L13:
            com.fasterxml.jackson.core.JsonToken r3 = com.fasterxml.jackson.core.JsonToken.FIELD_NAME
            if (r0 != r3) goto Lab
            java.lang.String r3 = r10.currentName()
            r10.nextToken()
            com.fasterxml.jackson.databind.deser.SettableBeanProperty r0 = r1.findCreatorProperty(r3)
            boolean r4 = r2.readIdProperty(r3)
            if (r4 == 0) goto L2e
            if (r0 != 0) goto L2e
        L2a:
            r4 = r10
            r5 = r11
            goto La3
        L2e:
            if (r0 == 0) goto L6e
            java.lang.Object r4 = r0.deserialize(r10, r11)
            boolean r0 = r2.assignParameter(r0, r4)
            if (r0 == 0) goto L2a
            r10.nextToken()
            java.lang.Object r7 = r1.build(r11, r2)     // Catch: java.lang.Exception -> L60
            java.lang.Class r0 = r7.getClass()
            com.fasterxml.jackson.databind.JavaType r1 = r9._beanType
            java.lang.Class r1 = r1.getRawClass()
            if (r0 == r1) goto L59
            com.fasterxml.jackson.core.StreamReadConstraints r6 = r10.streamReadConstraints()
            r3 = r9
            r4 = r10
            r5 = r11
            java.lang.Object r9 = r3.handlePolymorphic(r4, r5, r6, r7, r8)
            return r9
        L59:
            r4 = r10
            r5 = r11
            java.lang.Object r9 = r9.deserializeWithUnwrapped(r4, r5, r7, r8)
            return r9
        L60:
            r0 = move-exception
            r4 = r10
            r5 = r11
            r10 = r0
            com.fasterxml.jackson.databind.JavaType r11 = r9._beanType
            java.lang.Class r11 = r11.getRawClass()
            r9.wrapAndThrow(r10, r11, r3, r5)
            goto La3
        L6e:
            r4 = r10
            r5 = r11
            com.fasterxml.jackson.databind.deser.impl.BeanPropertyMap r10 = r9._beanProperties
            com.fasterxml.jackson.databind.deser.SettableBeanProperty r10 = r10.find(r3)
            if (r10 == 0) goto L80
            java.lang.Object r11 = r10.deserialize(r4, r5)
            r2.bufferProperty(r10, r11)
            goto La3
        L80:
            java.util.Set<java.lang.String> r10 = r9._ignorableProps
            java.util.Set<java.lang.String> r11 = r9._includableProps
            boolean r10 = com.fasterxml.jackson.databind.util.IgnorePropertiesUtil.shouldIgnore(r3, r10, r11)
            if (r10 == 0) goto L92
            java.lang.Class r10 = r9.handledType()
            r9.handleIgnoredProperty(r4, r5, r10, r3)
            goto La3
        L92:
            r8.writeFieldName(r3)
            r8.copyCurrentStructure(r4)
            com.fasterxml.jackson.databind.deser.SettableAnyProperty r10 = r9._anySetter
            if (r10 == 0) goto La3
            java.lang.Object r11 = r10.deserialize(r4, r5)
            r2.bufferAnyProperty(r10, r3, r11)
        La3:
            com.fasterxml.jackson.core.JsonToken r0 = r4.nextToken()
            r10 = r4
            r11 = r5
            goto L13
        Lab:
            r4 = r10
            r5 = r11
            r8.writeEndObject()
            java.lang.Object r10 = r1.build(r5, r2)     // Catch: java.lang.Exception -> Lbb
            com.fasterxml.jackson.databind.deser.impl.UnwrappedPropertyHandler r9 = r9._unwrappedPropertyHandler
            java.lang.Object r9 = r9.processUnwrapped(r4, r5, r10, r8)
            return r9
        Lbb:
            r0 = move-exception
            r10 = r0
            java.lang.Object r9 = r9.wrapInstantiationProblem(r10, r5)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.BuilderBasedDeserializer.deserializeUsingPropertyBasedWithUnwrapped(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
    }

    public Object deserializeWithExternalTypeId(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) throws JsonMappingException {
        Class<?> activeView = this._needViewProcesing ? deserializationContext.getActiveView() : null;
        ExternalTypeHandler externalTypeHandlerStart = this._externalTypeIdHandler.start();
        JsonToken jsonTokenCurrentToken = jsonParser.currentToken();
        while (jsonTokenCurrentToken == JsonToken.FIELD_NAME) {
            String strCurrentName = jsonParser.currentName();
            JsonToken jsonTokenNextToken = jsonParser.nextToken();
            SettableBeanProperty settableBeanPropertyFind = this._beanProperties.find(strCurrentName);
            if (settableBeanPropertyFind != null) {
                if (jsonTokenNextToken.isScalarValue()) {
                    externalTypeHandlerStart.handleTypePropertyValue(jsonParser, deserializationContext, strCurrentName, obj);
                }
                if (activeView == null || settableBeanPropertyFind.visibleInView(activeView)) {
                    try {
                        obj = settableBeanPropertyFind.deserializeSetAndReturn(jsonParser, deserializationContext, obj);
                    } catch (Exception e10) {
                        wrapAndThrow(e10, obj, strCurrentName, deserializationContext);
                    }
                } else {
                    jsonParser.skipChildren();
                }
            } else if (IgnorePropertiesUtil.shouldIgnore(strCurrentName, this._ignorableProps, this._includableProps)) {
                handleIgnoredProperty(jsonParser, deserializationContext, obj, strCurrentName);
            } else if (!externalTypeHandlerStart.handlePropertyValue(jsonParser, deserializationContext, strCurrentName, obj)) {
                SettableAnyProperty settableAnyProperty = this._anySetter;
                if (settableAnyProperty != null) {
                    try {
                        settableAnyProperty.deserializeAndSet(jsonParser, deserializationContext, obj, strCurrentName);
                    } catch (Exception e11) {
                        wrapAndThrow(e11, obj, strCurrentName, deserializationContext);
                    }
                } else {
                    handleUnknownProperty(jsonParser, deserializationContext, obj, strCurrentName);
                }
            }
            jsonTokenCurrentToken = jsonParser.nextToken();
        }
        return externalTypeHandlerStart.complete(jsonParser, deserializationContext, obj);
    }

    public Object deserializeWithUnwrapped(JsonParser jsonParser, DeserializationContext deserializationContext) throws JsonMappingException {
        JsonDeserializer<Object> jsonDeserializer = this._delegateDeserializer;
        if (jsonDeserializer != null) {
            return this._valueInstantiator.createUsingDelegate(deserializationContext, jsonDeserializer.deserialize(jsonParser, deserializationContext));
        }
        if (this._propertyBasedCreator != null) {
            return deserializeUsingPropertyBasedWithUnwrapped(jsonParser, deserializationContext);
        }
        TokenBuffer tokenBufferBufferForInputBuffering = deserializationContext.bufferForInputBuffering(jsonParser);
        tokenBufferBufferForInputBuffering.writeStartObject();
        Object objCreateUsingDefault = this._valueInstantiator.createUsingDefault(deserializationContext);
        if (this._injectables != null) {
            injectValues(deserializationContext, objCreateUsingDefault);
        }
        Class<?> activeView = this._needViewProcesing ? deserializationContext.getActiveView() : null;
        while (jsonParser.currentToken() == JsonToken.FIELD_NAME) {
            String strCurrentName = jsonParser.currentName();
            jsonParser.nextToken();
            SettableBeanProperty settableBeanPropertyFind = this._beanProperties.find(strCurrentName);
            if (settableBeanPropertyFind != null) {
                if (activeView == null || settableBeanPropertyFind.visibleInView(activeView)) {
                    try {
                        objCreateUsingDefault = settableBeanPropertyFind.deserializeSetAndReturn(jsonParser, deserializationContext, objCreateUsingDefault);
                    } catch (Exception e10) {
                        wrapAndThrow(e10, objCreateUsingDefault, strCurrentName, deserializationContext);
                    }
                } else {
                    jsonParser.skipChildren();
                }
            } else if (IgnorePropertiesUtil.shouldIgnore(strCurrentName, this._ignorableProps, this._includableProps)) {
                handleIgnoredProperty(jsonParser, deserializationContext, objCreateUsingDefault, strCurrentName);
            } else {
                tokenBufferBufferForInputBuffering.writeFieldName(strCurrentName);
                tokenBufferBufferForInputBuffering.copyCurrentStructure(jsonParser);
                SettableAnyProperty settableAnyProperty = this._anySetter;
                if (settableAnyProperty != null) {
                    try {
                        settableAnyProperty.deserializeAndSet(jsonParser, deserializationContext, objCreateUsingDefault, strCurrentName);
                    } catch (Exception e11) {
                        wrapAndThrow(e11, objCreateUsingDefault, strCurrentName, deserializationContext);
                    }
                }
            }
            jsonParser.nextToken();
        }
        tokenBufferBufferForInputBuffering.writeEndObject();
        return this._unwrappedPropertyHandler.processUnwrapped(jsonParser, deserializationContext, objCreateUsingDefault, tokenBufferBufferForInputBuffering);
    }

    public final Object deserializeWithView(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj, Class<?> cls) throws JsonMappingException {
        JsonToken jsonTokenCurrentToken = jsonParser.currentToken();
        while (jsonTokenCurrentToken == JsonToken.FIELD_NAME) {
            String strCurrentName = jsonParser.currentName();
            jsonParser.nextToken();
            SettableBeanProperty settableBeanPropertyFind = this._beanProperties.find(strCurrentName);
            if (settableBeanPropertyFind == null) {
                handleUnknownVanilla(jsonParser, deserializationContext, obj, strCurrentName);
            } else if (settableBeanPropertyFind.visibleInView(cls)) {
                try {
                    obj = settableBeanPropertyFind.deserializeSetAndReturn(jsonParser, deserializationContext, obj);
                } catch (Exception e10) {
                    wrapAndThrow(e10, obj, strCurrentName, deserializationContext);
                }
            } else {
                if (deserializationContext.isEnabled(DeserializationFeature.FAIL_ON_UNEXPECTED_VIEW_PROPERTIES)) {
                    Class<?> clsHandledType = handledType();
                    String strNameOf = ClassUtil.nameOf(handledType());
                    String name = settableBeanPropertyFind.getName();
                    deserializationContext.reportInputMismatch(clsHandledType, b.n(b.p("Input mismatch while deserializing ", strNameOf, ". Property '", name, "' is not part of current active view '"), cls.getName(), "' (disable 'DeserializationFeature.FAIL_ON_UNEXPECTED_VIEW_PROPERTIES' to allow)"), new Object[0]);
                }
                jsonParser.skipChildren();
            }
            jsonTokenCurrentToken = jsonParser.nextToken();
        }
        return obj;
    }

    public Object finishBuild(DeserializationContext deserializationContext, Object obj) {
        AnnotatedMethod annotatedMethod = this._buildMethod;
        if (annotatedMethod == null) {
            return obj;
        }
        try {
            return annotatedMethod.getMember().invoke(obj, null);
        } catch (Exception e10) {
            return this.wrapInstantiationProblem(e10, deserializationContext);
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.BeanDeserializerBase, com.fasterxml.jackson.databind.JsonDeserializer
    public Boolean supportsUpdate(DeserializationConfig deserializationConfig) {
        return Boolean.FALSE;
    }

    @Override // com.fasterxml.jackson.databind.deser.BeanDeserializerBase, com.fasterxml.jackson.databind.JsonDeserializer
    public JsonDeserializer<Object> unwrappingDeserializer(NameTransformer nameTransformer) {
        return new BuilderBasedDeserializer(this, nameTransformer);
    }

    @Override // com.fasterxml.jackson.databind.deser.BeanDeserializerBase
    public BeanDeserializerBase withBeanProperties(BeanPropertyMap beanPropertyMap) {
        return new BuilderBasedDeserializer(this, beanPropertyMap);
    }

    @Override // com.fasterxml.jackson.databind.deser.BeanDeserializerBase
    public BeanDeserializerBase withByNameInclusion(Set<String> set, Set<String> set2) {
        return new BuilderBasedDeserializer(this, set, set2);
    }

    @Override // com.fasterxml.jackson.databind.deser.BeanDeserializerBase
    public BeanDeserializerBase withIgnoreAllUnknown(boolean z10) {
        return new BuilderBasedDeserializer(this, z10);
    }

    @Override // com.fasterxml.jackson.databind.deser.BeanDeserializerBase
    public BeanDeserializerBase withObjectIdReader(ObjectIdReader objectIdReader) {
        return new BuilderBasedDeserializer(this, objectIdReader);
    }

    public BuilderBasedDeserializer(BeanDeserializerBuilder beanDeserializerBuilder, BeanDescription beanDescription, JavaType javaType, BeanPropertyMap beanPropertyMap, Map<String, SettableBeanProperty> map, Set<String> set, boolean z10, boolean z11) {
        this(beanDeserializerBuilder, beanDescription, javaType, beanPropertyMap, map, set, z10, null, z11);
    }

    @Deprecated
    public BuilderBasedDeserializer(BeanDeserializerBuilder beanDeserializerBuilder, BeanDescription beanDescription, BeanPropertyMap beanPropertyMap, Map<String, SettableBeanProperty> map, Set<String> set, boolean z10, boolean z11) {
        this(beanDeserializerBuilder, beanDescription, beanDescription.getType(), beanPropertyMap, map, set, z10, z11);
    }

    public BuilderBasedDeserializer(BuilderBasedDeserializer builderBasedDeserializer) {
        this(builderBasedDeserializer, builderBasedDeserializer._ignoreAllUnknown);
    }

    public BuilderBasedDeserializer(BuilderBasedDeserializer builderBasedDeserializer, boolean z10) {
        super(builderBasedDeserializer, z10);
        this._buildMethod = builderBasedDeserializer._buildMethod;
        this._targetType = builderBasedDeserializer._targetType;
    }

    public BuilderBasedDeserializer(BuilderBasedDeserializer builderBasedDeserializer, NameTransformer nameTransformer) {
        super(builderBasedDeserializer, nameTransformer);
        this._buildMethod = builderBasedDeserializer._buildMethod;
        this._targetType = builderBasedDeserializer._targetType;
    }

    public BuilderBasedDeserializer(BuilderBasedDeserializer builderBasedDeserializer, ObjectIdReader objectIdReader) {
        super(builderBasedDeserializer, objectIdReader);
        this._buildMethod = builderBasedDeserializer._buildMethod;
        this._targetType = builderBasedDeserializer._targetType;
    }

    public BuilderBasedDeserializer(BuilderBasedDeserializer builderBasedDeserializer, Set<String> set) {
        this(builderBasedDeserializer, set, builderBasedDeserializer._includableProps);
    }

    public BuilderBasedDeserializer(BuilderBasedDeserializer builderBasedDeserializer, Set<String> set, Set<String> set2) {
        super(builderBasedDeserializer, set, set2);
        this._buildMethod = builderBasedDeserializer._buildMethod;
        this._targetType = builderBasedDeserializer._targetType;
    }

    public BuilderBasedDeserializer(BuilderBasedDeserializer builderBasedDeserializer, BeanPropertyMap beanPropertyMap) {
        super(builderBasedDeserializer, beanPropertyMap);
        this._buildMethod = builderBasedDeserializer._buildMethod;
        this._targetType = builderBasedDeserializer._targetType;
    }

    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) {
        JavaType javaType = this._targetType;
        Class<?> clsHandledType = handledType();
        Class<?> cls = obj.getClass();
        if (clsHandledType.isAssignableFrom(cls)) {
            return deserializationContext.reportBadDefinition(javaType, String.format("Deserialization of %s by passing existing Builder (%s) instance not supported", javaType, clsHandledType.getName()));
        }
        return deserializationContext.reportBadDefinition(javaType, String.format("Deserialization of %s by passing existing instance (of %s) not supported", javaType, cls.getName()));
    }

    public Object deserializeWithExternalTypeId(JsonParser jsonParser, DeserializationContext deserializationContext) {
        if (this._propertyBasedCreator != null) {
            return deserializeUsingPropertyBasedWithExternalTypeId(jsonParser, deserializationContext);
        }
        return deserializeWithExternalTypeId(jsonParser, deserializationContext, this._valueInstantiator.createUsingDefault(deserializationContext));
    }

    public Object deserializeWithUnwrapped(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj, TokenBuffer tokenBuffer) throws IOException {
        Class<?> activeView = this._needViewProcesing ? deserializationContext.getActiveView() : null;
        JsonToken jsonTokenCurrentToken = jsonParser.currentToken();
        while (jsonTokenCurrentToken == JsonToken.FIELD_NAME) {
            String strCurrentName = jsonParser.currentName();
            SettableBeanProperty settableBeanPropertyFind = this._beanProperties.find(strCurrentName);
            jsonParser.nextToken();
            if (settableBeanPropertyFind != null) {
                if (activeView != null && !settableBeanPropertyFind.visibleInView(activeView)) {
                    jsonParser.skipChildren();
                } else {
                    try {
                        obj = settableBeanPropertyFind.deserializeSetAndReturn(jsonParser, deserializationContext, obj);
                    } catch (Exception e10) {
                        wrapAndThrow(e10, obj, strCurrentName, deserializationContext);
                    }
                }
            } else if (IgnorePropertiesUtil.shouldIgnore(strCurrentName, this._ignorableProps, this._includableProps)) {
                handleIgnoredProperty(jsonParser, deserializationContext, obj, strCurrentName);
            } else {
                tokenBuffer.writeFieldName(strCurrentName);
                tokenBuffer.copyCurrentStructure(jsonParser);
                SettableAnyProperty settableAnyProperty = this._anySetter;
                if (settableAnyProperty != null) {
                    settableAnyProperty.deserializeAndSet(jsonParser, deserializationContext, obj, strCurrentName);
                }
            }
            jsonTokenCurrentToken = jsonParser.nextToken();
        }
        tokenBuffer.writeEndObject();
        return this._unwrappedPropertyHandler.processUnwrapped(jsonParser, deserializationContext, obj, tokenBuffer);
    }
}
