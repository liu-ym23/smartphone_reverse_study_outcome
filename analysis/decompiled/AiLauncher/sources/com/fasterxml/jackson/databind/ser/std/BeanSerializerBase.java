package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.WritableTypeId;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.ObjectIdInfo;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitable;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;
import com.fasterxml.jackson.databind.jsonschema.JsonSerializableSchema;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.BeanSerializerBuilder;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.fasterxml.jackson.databind.ser.PropertyFilter;
import com.fasterxml.jackson.databind.ser.PropertyWriter;
import com.fasterxml.jackson.databind.ser.ResolvableSerializer;
import com.fasterxml.jackson.databind.ser.impl.MapEntrySerializer;
import com.fasterxml.jackson.databind.ser.impl.ObjectIdWriter;
import com.fasterxml.jackson.databind.ser.impl.PropertyBasedObjectIdGenerator;
import com.fasterxml.jackson.databind.ser.impl.WritableObjectId;
import com.fasterxml.jackson.databind.util.ArrayBuilders;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.databind.util.Converter;
import com.fasterxml.jackson.databind.util.IgnorePropertiesUtil;
import com.fasterxml.jackson.databind.util.NameTransformer;
import com.networknt.schema.keyword.PropertiesValidator;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public abstract class BeanSerializerBase extends StdSerializer<Object> implements ContextualSerializer, ResolvableSerializer, JsonFormatVisitable {
    protected static final PropertyName NAME_FOR_OBJECT_REF = new PropertyName("#object-ref");
    protected static final BeanPropertyWriter[] NO_PROPS = new BeanPropertyWriter[0];
    protected final JavaType _beanType;
    protected final BeanPropertyWriter[] _filteredProps;
    protected final ObjectIdWriter _objectIdWriter;
    protected final Object _propertyFilterId;
    protected final BeanPropertyWriter[] _props;
    protected final JsonFormat.Shape _serializationShape;
    protected final AnnotatedMember _typeId;

    /* renamed from: com.fasterxml.jackson.databind.ser.std.BeanSerializerBase$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$fasterxml$jackson$annotation$JsonFormat$Shape;

        static {
            int[] iArr = new int[JsonFormat.Shape.values().length];
            $SwitchMap$com$fasterxml$jackson$annotation$JsonFormat$Shape = iArr;
            try {
                iArr[JsonFormat.Shape.STRING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$annotation$JsonFormat$Shape[JsonFormat.Shape.NUMBER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$annotation$JsonFormat$Shape[JsonFormat.Shape.NUMBER_INT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public BeanSerializerBase(JavaType javaType, BeanSerializerBuilder beanSerializerBuilder, BeanPropertyWriter[] beanPropertyWriterArr, BeanPropertyWriter[] beanPropertyWriterArr2) {
        super(javaType);
        this._beanType = javaType;
        this._props = beanPropertyWriterArr;
        this._filteredProps = beanPropertyWriterArr2;
        if (beanSerializerBuilder == null) {
            this._typeId = null;
            this._propertyFilterId = null;
            this._objectIdWriter = null;
            this._serializationShape = null;
            return;
        }
        this._typeId = beanSerializerBuilder.getTypeId();
        this._propertyFilterId = beanSerializerBuilder.getFilterId();
        this._objectIdWriter = beanSerializerBuilder.getObjectIdWriter();
        this._serializationShape = beanSerializerBuilder.getBeanDescription().findExpectedFormat().getShape();
    }

    private static final BeanPropertyWriter[] rename(BeanPropertyWriter[] beanPropertyWriterArr, NameTransformer nameTransformer) {
        if (beanPropertyWriterArr == null || beanPropertyWriterArr.length == 0 || nameTransformer == null || nameTransformer == NameTransformer.NOP) {
            return beanPropertyWriterArr;
        }
        int length = beanPropertyWriterArr.length;
        BeanPropertyWriter[] beanPropertyWriterArr2 = new BeanPropertyWriter[length];
        for (int i10 = 0; i10 < length; i10++) {
            BeanPropertyWriter beanPropertyWriter = beanPropertyWriterArr[i10];
            if (beanPropertyWriter != null) {
                beanPropertyWriterArr2[i10] = beanPropertyWriter.rename(nameTransformer);
            }
        }
        return beanPropertyWriterArr2;
    }

    @Deprecated
    public final String _customTypeId(Object obj) throws UnsupportedOperationException, IllegalArgumentException {
        Object value = this._typeId.getValue(obj);
        return value == null ? "" : value instanceof String ? (String) value : value.toString();
    }

    public void _serializeObjectId(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer, WritableObjectId writableObjectId) throws UnsupportedOperationException, IOException, IllegalArgumentException {
        ObjectIdWriter objectIdWriter = this._objectIdWriter;
        WritableTypeId writableTypeId_typeIdDef = _typeIdDef(typeSerializer, obj, JsonToken.START_OBJECT);
        typeSerializer.writeTypePrefix(jsonGenerator, writableTypeId_typeIdDef);
        jsonGenerator.assignCurrentValue(obj);
        writableObjectId.writeAsField(jsonGenerator, serializerProvider, objectIdWriter);
        if (this._propertyFilterId != null) {
            serializeFieldsFiltered(obj, jsonGenerator, serializerProvider);
        } else {
            serializeFields(obj, jsonGenerator, serializerProvider);
        }
        typeSerializer.writeTypeSuffix(jsonGenerator, writableTypeId_typeIdDef);
    }

    public final void _serializeWithObjectId(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, boolean z10) throws IOException {
        ObjectIdWriter objectIdWriter = this._objectIdWriter;
        WritableObjectId writableObjectIdFindObjectId = serializerProvider.findObjectId(obj, objectIdWriter.generator);
        if (writableObjectIdFindObjectId.writeAsId(jsonGenerator, serializerProvider, objectIdWriter)) {
            return;
        }
        Object objGenerateId = writableObjectIdFindObjectId.generateId(obj);
        if (objectIdWriter.alwaysAsId) {
            objectIdWriter.serializer.serialize(objGenerateId, jsonGenerator, serializerProvider);
            return;
        }
        if (z10) {
            jsonGenerator.writeStartObject(obj);
        }
        writableObjectIdFindObjectId.writeAsField(jsonGenerator, serializerProvider, objectIdWriter);
        if (this._propertyFilterId != null) {
            serializeFieldsFiltered(obj, jsonGenerator, serializerProvider);
        } else {
            serializeFields(obj, jsonGenerator, serializerProvider);
        }
        if (z10) {
            jsonGenerator.writeEndObject();
        }
    }

    public final WritableTypeId _typeIdDef(TypeSerializer typeSerializer, Object obj, JsonToken jsonToken) throws UnsupportedOperationException, IllegalArgumentException {
        AnnotatedMember annotatedMember = this._typeId;
        if (annotatedMember == null) {
            return typeSerializer.typeId(obj, jsonToken);
        }
        Object value = annotatedMember.getValue(obj);
        if (value == null) {
            value = "";
        }
        return typeSerializer.typeId(obj, jsonToken, value);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, com.fasterxml.jackson.databind.JsonSerializer, com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitable
    public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper jsonFormatVisitorWrapper, JavaType javaType) throws JsonMappingException {
        JsonObjectFormatVisitor jsonObjectFormatVisitorExpectObjectFormat;
        if (jsonFormatVisitorWrapper == null || (jsonObjectFormatVisitorExpectObjectFormat = jsonFormatVisitorWrapper.expectObjectFormat(javaType)) == null) {
            return;
        }
        SerializerProvider provider = jsonFormatVisitorWrapper.getProvider();
        int i10 = 0;
        Class<?> activeView = null;
        if (this._propertyFilterId != null) {
            PropertyFilter propertyFilterFindPropertyFilter = findPropertyFilter(jsonFormatVisitorWrapper.getProvider(), this._propertyFilterId, null);
            int length = this._props.length;
            while (i10 < length) {
                propertyFilterFindPropertyFilter.depositSchemaProperty(this._props[i10], jsonObjectFormatVisitorExpectObjectFormat, provider);
                i10++;
            }
            return;
        }
        if (this._filteredProps != null && provider != null) {
            activeView = provider.getActiveView();
        }
        BeanPropertyWriter[] beanPropertyWriterArr = activeView != null ? this._filteredProps : this._props;
        int length2 = beanPropertyWriterArr.length;
        while (i10 < length2) {
            BeanPropertyWriter beanPropertyWriter = beanPropertyWriterArr[i10];
            if (beanPropertyWriter != null) {
                beanPropertyWriter.depositSchemaProperty(jsonObjectFormatVisitorExpectObjectFormat, provider);
            }
            i10++;
        }
    }

    public abstract BeanSerializerBase asArraySerializer();

    @Override // com.fasterxml.jackson.databind.ser.ContextualSerializer
    public JsonSerializer<?> createContextual(SerializerProvider serializerProvider, BeanProperty beanProperty) throws JsonMappingException {
        JsonFormat.Shape shape;
        Object objFindFilterId;
        Set<String> included;
        Set<String> setFindIgnoredForSerialization;
        int i10;
        BeanSerializerBase beanSerializerBaseWithFilterId;
        ObjectIdWriter objectIdWriterWithSerializer;
        BeanPropertyWriter beanPropertyWriter;
        ObjectIdInfo objectIdInfoFindObjectReferenceInfo;
        AnnotationIntrospector annotationIntrospector = serializerProvider.getAnnotationIntrospector();
        BeanPropertyWriter[] beanPropertyWriterArr = null;
        AnnotatedMember member = (beanProperty == null || annotationIntrospector == null) ? null : beanProperty.getMember();
        SerializationConfig config = serializerProvider.getConfig();
        JsonFormat.Value valueFindFormatOverrides = findFormatOverrides(serializerProvider, beanProperty, this._handledType);
        if (valueFindFormatOverrides == null || !valueFindFormatOverrides.hasShape()) {
            shape = null;
        } else {
            shape = valueFindFormatOverrides.getShape();
            if (shape != JsonFormat.Shape.ANY && shape != this._serializationShape) {
                if (this._beanType.isEnumType()) {
                    int i11 = AnonymousClass1.$SwitchMap$com$fasterxml$jackson$annotation$JsonFormat$Shape[shape.ordinal()];
                    if (i11 == 1 || i11 == 2 || i11 == 3) {
                        return serializerProvider.handlePrimaryContextualization(EnumSerializer.construct(this._beanType.getRawClass(), serializerProvider.getConfig(), config.introspectClassAnnotations(this._beanType), valueFindFormatOverrides), beanProperty);
                    }
                } else if (shape == JsonFormat.Shape.NATURAL && ((!this._beanType.isMapLikeType() || !Map.class.isAssignableFrom(this._handledType)) && Map.Entry.class.isAssignableFrom(this._handledType))) {
                    JavaType javaTypeFindSuperType = this._beanType.findSuperType(Map.Entry.class);
                    return serializerProvider.handlePrimaryContextualization(new MapEntrySerializer(this._beanType, javaTypeFindSuperType.containedTypeOrUnknown(0), javaTypeFindSuperType.containedTypeOrUnknown(1), false, null, beanProperty), beanProperty);
                }
            }
        }
        ObjectIdWriter objectIdWriterConstruct = this._objectIdWriter;
        if (member != null) {
            setFindIgnoredForSerialization = annotationIntrospector.findPropertyIgnoralByName(config, member).findIgnoredForSerialization();
            included = annotationIntrospector.findPropertyInclusionByName(config, member).getIncluded();
            ObjectIdInfo objectIdInfoFindObjectIdInfo = annotationIntrospector.findObjectIdInfo(member);
            if (objectIdInfoFindObjectIdInfo == null) {
                if (objectIdWriterConstruct != null && (objectIdInfoFindObjectReferenceInfo = annotationIntrospector.findObjectReferenceInfo(member, null)) != null) {
                    objectIdWriterConstruct = this._objectIdWriter.withAlwaysAsId(objectIdInfoFindObjectReferenceInfo.getAlwaysAsId());
                }
                i10 = 0;
            } else {
                ObjectIdInfo objectIdInfoFindObjectReferenceInfo2 = annotationIntrospector.findObjectReferenceInfo(member, objectIdInfoFindObjectIdInfo);
                Class<? extends ObjectIdGenerator<?>> generatorType = objectIdInfoFindObjectReferenceInfo2.getGeneratorType();
                JavaType javaType = serializerProvider.getTypeFactory().findTypeParameters(serializerProvider.constructType(generatorType), ObjectIdGenerator.class)[0];
                if (generatorType == ObjectIdGenerators.PropertyGenerator.class) {
                    String simpleName = objectIdInfoFindObjectReferenceInfo2.getPropertyName().getSimpleName();
                    int length = this._props.length;
                    i10 = 0;
                    while (true) {
                        if (i10 == length) {
                            serializerProvider.reportBadDefinition(this._beanType, String.format("Invalid Object Id definition for %s: cannot find property with name %s", ClassUtil.nameOf((Class<?>) handledType()), ClassUtil.name(simpleName)));
                        }
                        beanPropertyWriter = this._props[i10];
                        if (simpleName.equals(beanPropertyWriter.getName())) {
                            break;
                        }
                        i10++;
                    }
                    objectIdWriterConstruct = ObjectIdWriter.construct(beanPropertyWriter.getType(), null, new PropertyBasedObjectIdGenerator(objectIdInfoFindObjectReferenceInfo2, beanPropertyWriter), objectIdInfoFindObjectReferenceInfo2.getAlwaysAsId());
                } else {
                    objectIdWriterConstruct = ObjectIdWriter.construct(javaType, objectIdInfoFindObjectReferenceInfo2.getPropertyName(), serializerProvider.objectIdGeneratorInstance(member, objectIdInfoFindObjectReferenceInfo2), objectIdInfoFindObjectReferenceInfo2.getAlwaysAsId());
                    i10 = 0;
                }
            }
            objFindFilterId = annotationIntrospector.findFilterId(member);
            if (objFindFilterId == null || objFindFilterId.equals(this._propertyFilterId)) {
                objFindFilterId = null;
            }
        } else {
            objFindFilterId = null;
            included = null;
            setFindIgnoredForSerialization = null;
            i10 = 0;
        }
        if (i10 > 0) {
            BeanPropertyWriter[] beanPropertyWriterArr2 = this._props;
            BeanPropertyWriter[] beanPropertyWriterArr3 = (BeanPropertyWriter[]) Arrays.copyOf(beanPropertyWriterArr2, beanPropertyWriterArr2.length);
            BeanPropertyWriter beanPropertyWriter2 = beanPropertyWriterArr3[i10];
            System.arraycopy(beanPropertyWriterArr3, 0, beanPropertyWriterArr3, 1, i10);
            beanPropertyWriterArr3[0] = beanPropertyWriter2;
            BeanPropertyWriter[] beanPropertyWriterArr4 = this._filteredProps;
            if (beanPropertyWriterArr4 != null) {
                beanPropertyWriterArr = (BeanPropertyWriter[]) Arrays.copyOf(beanPropertyWriterArr4, beanPropertyWriterArr4.length);
                BeanPropertyWriter beanPropertyWriter3 = beanPropertyWriterArr[i10];
                System.arraycopy(beanPropertyWriterArr, 0, beanPropertyWriterArr, 1, i10);
                beanPropertyWriterArr[0] = beanPropertyWriter3;
            }
            beanSerializerBaseWithFilterId = withProperties(beanPropertyWriterArr3, beanPropertyWriterArr);
        } else {
            beanSerializerBaseWithFilterId = this;
        }
        if (objectIdWriterConstruct != null && (objectIdWriterWithSerializer = objectIdWriterConstruct.withSerializer(serializerProvider.findValueSerializer(objectIdWriterConstruct.idType, beanProperty))) != this._objectIdWriter) {
            beanSerializerBaseWithFilterId = beanSerializerBaseWithFilterId.withObjectIdWriter(objectIdWriterWithSerializer);
        }
        if ((setFindIgnoredForSerialization != null && !setFindIgnoredForSerialization.isEmpty()) || included != null) {
            beanSerializerBaseWithFilterId = beanSerializerBaseWithFilterId.withByNameInclusion(setFindIgnoredForSerialization, included);
        }
        if (objFindFilterId != null) {
            beanSerializerBaseWithFilterId = beanSerializerBaseWithFilterId.withFilterId(objFindFilterId);
        }
        if (shape == null) {
            shape = this._serializationShape;
        }
        return shape == JsonFormat.Shape.ARRAY ? beanSerializerBaseWithFilterId.asArraySerializer() : beanSerializerBaseWithFilterId;
    }

    public JsonSerializer<Object> findConvertingSerializer(SerializerProvider serializerProvider, BeanPropertyWriter beanPropertyWriter) throws JsonMappingException {
        AnnotatedMember member;
        Object objFindSerializationConverter;
        AnnotationIntrospector annotationIntrospector = serializerProvider.getAnnotationIntrospector();
        if (annotationIntrospector == null || (member = beanPropertyWriter.getMember()) == null || (objFindSerializationConverter = annotationIntrospector.findSerializationConverter(member)) == null) {
            return null;
        }
        Converter<Object, Object> converterConverterInstance = serializerProvider.converterInstance(beanPropertyWriter.getMember(), objFindSerializationConverter);
        JavaType outputType = converterConverterInstance.getOutputType(serializerProvider.getTypeFactory());
        return new StdDelegatingSerializer(converterConverterInstance, outputType, outputType.isJavaLangObject() ? null : serializerProvider.findValueSerializer(outputType, beanPropertyWriter));
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, com.fasterxml.jackson.databind.jsonschema.SchemaAware
    @Deprecated
    public JsonNode getSchema(SerializerProvider serializerProvider, Type type) throws JsonMappingException {
        String strId;
        ObjectNode objectNodeCreateSchemaNode = createSchemaNode("object", true);
        JsonSerializableSchema jsonSerializableSchema = (JsonSerializableSchema) this._handledType.getAnnotation(JsonSerializableSchema.class);
        if (jsonSerializableSchema != null && (strId = jsonSerializableSchema.id()) != null && !strId.isEmpty()) {
            objectNodeCreateSchemaNode.put("id", strId);
        }
        ObjectNode objectNode = objectNodeCreateSchemaNode.objectNode();
        Object obj = this._propertyFilterId;
        PropertyFilter propertyFilterFindPropertyFilter = obj != null ? findPropertyFilter(serializerProvider, obj, null) : null;
        int i10 = 0;
        while (true) {
            BeanPropertyWriter[] beanPropertyWriterArr = this._props;
            if (i10 >= beanPropertyWriterArr.length) {
                objectNodeCreateSchemaNode.set(PropertiesValidator.PROPERTY, objectNode);
                return objectNodeCreateSchemaNode;
            }
            BeanPropertyWriter beanPropertyWriter = beanPropertyWriterArr[i10];
            if (propertyFilterFindPropertyFilter == null) {
                beanPropertyWriter.depositSchemaProperty(objectNode, serializerProvider);
            } else {
                propertyFilterFindPropertyFilter.depositSchemaProperty(beanPropertyWriter, objectNode, serializerProvider);
            }
            i10++;
        }
    }

    @Override // com.fasterxml.jackson.databind.JsonSerializer
    public Iterator<PropertyWriter> properties() {
        return Arrays.asList(this._props).iterator();
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x008d  */
    @Override // com.fasterxml.jackson.databind.ser.ResolvableSerializer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void resolve(com.fasterxml.jackson.databind.SerializerProvider r9) throws com.fasterxml.jackson.databind.JsonMappingException {
        /*
            r8 = this;
            com.fasterxml.jackson.databind.ser.BeanPropertyWriter[] r0 = r8._filteredProps
            r1 = 0
            if (r0 != 0) goto L7
            r0 = r1
            goto L8
        L7:
            int r0 = r0.length
        L8:
            com.fasterxml.jackson.databind.ser.BeanPropertyWriter[] r2 = r8._props
            int r2 = r2.length
            r3 = r1
        Lc:
            if (r3 >= r2) goto L94
            com.fasterxml.jackson.databind.ser.BeanPropertyWriter[] r4 = r8._props
            r4 = r4[r3]
            boolean r5 = r4.willSuppressNulls()
            if (r5 != 0) goto L32
            boolean r5 = r4.hasNullSerializer()
            if (r5 != 0) goto L32
            com.fasterxml.jackson.databind.JsonSerializer r5 = r9.findNullValueSerializer(r4)
            if (r5 == 0) goto L32
            r4.assignNullSerializer(r5)
            if (r3 >= r0) goto L32
            com.fasterxml.jackson.databind.ser.BeanPropertyWriter[] r6 = r8._filteredProps
            r6 = r6[r3]
            if (r6 == 0) goto L32
            r6.assignNullSerializer(r5)
        L32:
            boolean r5 = r4.hasSerializer()
            if (r5 == 0) goto L39
            goto L90
        L39:
            com.fasterxml.jackson.databind.JsonSerializer r5 = r8.findConvertingSerializer(r9, r4)
            if (r5 != 0) goto L81
            com.fasterxml.jackson.databind.JavaType r5 = r4.getSerializationType()
            if (r5 != 0) goto L5f
            com.fasterxml.jackson.databind.JavaType r5 = r4.getType()
            boolean r6 = r5.isFinal()
            if (r6 != 0) goto L5f
            boolean r6 = r5.isContainerType()
            if (r6 != 0) goto L5b
            int r6 = r5.containedTypeCount()
            if (r6 <= 0) goto L90
        L5b:
            r4.setNonTrivialBaseType(r5)
            goto L90
        L5f:
            com.fasterxml.jackson.databind.JsonSerializer r6 = r9.findValueSerializer(r5, r4)
            boolean r7 = r5.isContainerType()
            if (r7 == 0) goto L80
            com.fasterxml.jackson.databind.JavaType r5 = r5.getContentType()
            java.lang.Object r5 = r5.getTypeHandler()
            com.fasterxml.jackson.databind.jsontype.TypeSerializer r5 = (com.fasterxml.jackson.databind.jsontype.TypeSerializer) r5
            if (r5 == 0) goto L80
            boolean r7 = r6 instanceof com.fasterxml.jackson.databind.ser.ContainerSerializer
            if (r7 == 0) goto L80
            com.fasterxml.jackson.databind.ser.ContainerSerializer r6 = (com.fasterxml.jackson.databind.ser.ContainerSerializer) r6
            com.fasterxml.jackson.databind.ser.ContainerSerializer r5 = r6.withValueTypeSerializer(r5)
            goto L81
        L80:
            r5 = r6
        L81:
            if (r3 >= r0) goto L8d
            com.fasterxml.jackson.databind.ser.BeanPropertyWriter[] r6 = r8._filteredProps
            r6 = r6[r3]
            if (r6 == 0) goto L8d
            r6.assignSerializer(r5)
            goto L90
        L8d:
            r4.assignSerializer(r5)
        L90:
            int r3 = r3 + 1
            goto Lc
        L94:
            com.fasterxml.jackson.databind.ser.BeanPropertyWriter[] r0 = r8._props
            int r2 = r0.length
            if (r1 >= r2) goto La7
            r0 = r0[r1]
            boolean r2 = r0 instanceof com.fasterxml.jackson.databind.ser.AnyGetterWriter
            if (r2 == 0) goto La4
            com.fasterxml.jackson.databind.ser.AnyGetterWriter r0 = (com.fasterxml.jackson.databind.ser.AnyGetterWriter) r0
            r0.resolve(r9)
        La4:
            int r1 = r1 + 1
            goto L94
        La7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.std.BeanSerializerBase.resolve(com.fasterxml.jackson.databind.SerializerProvider):void");
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, com.fasterxml.jackson.databind.JsonSerializer
    public abstract void serialize(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException;

    public void serializeFields(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        BeanPropertyWriter[] beanPropertyWriterArr = (this._filteredProps == null || serializerProvider.getActiveView() == null) ? this._props : this._filteredProps;
        int i10 = 0;
        try {
            int length = beanPropertyWriterArr.length;
            while (i10 < length) {
                BeanPropertyWriter beanPropertyWriter = beanPropertyWriterArr[i10];
                if (beanPropertyWriter != null) {
                    beanPropertyWriter.serializeAsField(obj, jsonGenerator, serializerProvider);
                }
                i10++;
            }
        } catch (Exception e10) {
            wrapAndThrow(serializerProvider, e10, obj, i10 != beanPropertyWriterArr.length ? beanPropertyWriterArr[i10].getName() : "[anySetter]");
        } catch (StackOverflowError e11) {
            JsonMappingException jsonMappingException = new JsonMappingException(jsonGenerator, "Infinite recursion (StackOverflowError)", e11);
            jsonMappingException.prependPath(obj, i10 != beanPropertyWriterArr.length ? beanPropertyWriterArr[i10].getName() : "[anySetter]");
            throw jsonMappingException;
        }
    }

    public void serializeFieldsFiltered(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        BeanPropertyWriter[] beanPropertyWriterArr = (this._filteredProps == null || serializerProvider.getActiveView() == null) ? this._props : this._filteredProps;
        PropertyFilter propertyFilterFindPropertyFilter = findPropertyFilter(serializerProvider, this._propertyFilterId, obj);
        if (propertyFilterFindPropertyFilter == null) {
            serializeFields(obj, jsonGenerator, serializerProvider);
            return;
        }
        int i10 = 0;
        try {
            int length = beanPropertyWriterArr.length;
            while (i10 < length) {
                BeanPropertyWriter beanPropertyWriter = beanPropertyWriterArr[i10];
                if (beanPropertyWriter != null) {
                    propertyFilterFindPropertyFilter.serializeAsField(obj, jsonGenerator, serializerProvider, beanPropertyWriter);
                }
                i10++;
            }
        } catch (Exception e10) {
            wrapAndThrow(serializerProvider, e10, obj, i10 != beanPropertyWriterArr.length ? beanPropertyWriterArr[i10].getName() : "[anySetter]");
        } catch (StackOverflowError e11) {
            JsonMappingException jsonMappingException = new JsonMappingException(jsonGenerator, "Infinite recursion (StackOverflowError)", e11);
            jsonMappingException.prependPath(obj, i10 != beanPropertyWriterArr.length ? beanPropertyWriterArr[i10].getName() : "[anySetter]");
            throw jsonMappingException;
        }
    }

    @Override // com.fasterxml.jackson.databind.JsonSerializer
    public void serializeWithType(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws UnsupportedOperationException, IOException, IllegalArgumentException {
        if (this._objectIdWriter != null) {
            _serializeWithObjectId(obj, jsonGenerator, serializerProvider, typeSerializer);
            return;
        }
        WritableTypeId writableTypeId_typeIdDef = _typeIdDef(typeSerializer, obj, JsonToken.START_OBJECT);
        typeSerializer.writeTypePrefix(jsonGenerator, writableTypeId_typeIdDef);
        jsonGenerator.assignCurrentValue(obj);
        if (this._propertyFilterId != null) {
            serializeFieldsFiltered(obj, jsonGenerator, serializerProvider);
        } else {
            serializeFields(obj, jsonGenerator, serializerProvider);
        }
        typeSerializer.writeTypeSuffix(jsonGenerator, writableTypeId_typeIdDef);
    }

    @Override // com.fasterxml.jackson.databind.JsonSerializer
    public boolean usesObjectId() {
        return this._objectIdWriter != null;
    }

    public abstract BeanSerializerBase withByNameInclusion(Set<String> set, Set<String> set2);

    @Override // com.fasterxml.jackson.databind.JsonSerializer
    public abstract BeanSerializerBase withFilterId(Object obj);

    @Deprecated
    public BeanSerializerBase withIgnorals(Set<String> set) {
        return withByNameInclusion(set, null);
    }

    public abstract BeanSerializerBase withObjectIdWriter(ObjectIdWriter objectIdWriter);

    public abstract BeanSerializerBase withProperties(BeanPropertyWriter[] beanPropertyWriterArr, BeanPropertyWriter[] beanPropertyWriterArr2);

    @Deprecated
    public BeanSerializerBase withIgnorals(String[] strArr) {
        return withIgnorals(ArrayBuilders.arrayToSet(strArr));
    }

    public final void _serializeWithObjectId(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws UnsupportedOperationException, IOException, IllegalArgumentException {
        ObjectIdWriter objectIdWriter = this._objectIdWriter;
        WritableObjectId writableObjectIdFindObjectId = serializerProvider.findObjectId(obj, objectIdWriter.generator);
        if (writableObjectIdFindObjectId.writeAsId(jsonGenerator, serializerProvider, objectIdWriter)) {
            return;
        }
        Object objGenerateId = writableObjectIdFindObjectId.generateId(obj);
        if (objectIdWriter.alwaysAsId) {
            objectIdWriter.serializer.serialize(objGenerateId, jsonGenerator, serializerProvider);
        } else {
            _serializeObjectId(obj, jsonGenerator, serializerProvider, typeSerializer, writableObjectIdFindObjectId);
        }
    }

    public BeanSerializerBase(BeanSerializerBase beanSerializerBase, BeanPropertyWriter[] beanPropertyWriterArr, BeanPropertyWriter[] beanPropertyWriterArr2) {
        super(beanSerializerBase._handledType);
        this._beanType = beanSerializerBase._beanType;
        this._props = beanPropertyWriterArr;
        this._filteredProps = beanPropertyWriterArr2;
        this._typeId = beanSerializerBase._typeId;
        this._objectIdWriter = beanSerializerBase._objectIdWriter;
        this._propertyFilterId = beanSerializerBase._propertyFilterId;
        this._serializationShape = beanSerializerBase._serializationShape;
    }

    public BeanSerializerBase(BeanSerializerBase beanSerializerBase, ObjectIdWriter objectIdWriter) {
        this(beanSerializerBase, objectIdWriter, beanSerializerBase._propertyFilterId);
    }

    public BeanSerializerBase(BeanSerializerBase beanSerializerBase, ObjectIdWriter objectIdWriter, Object obj) {
        super(beanSerializerBase._handledType);
        this._beanType = beanSerializerBase._beanType;
        this._props = beanSerializerBase._props;
        this._filteredProps = beanSerializerBase._filteredProps;
        this._typeId = beanSerializerBase._typeId;
        this._objectIdWriter = objectIdWriter;
        this._propertyFilterId = obj;
        this._serializationShape = beanSerializerBase._serializationShape;
    }

    @Deprecated
    public BeanSerializerBase(BeanSerializerBase beanSerializerBase, String[] strArr) {
        this(beanSerializerBase, ArrayBuilders.arrayToSet(strArr), (Set<String>) null);
    }

    @Deprecated
    public BeanSerializerBase(BeanSerializerBase beanSerializerBase, Set<String> set) {
        this(beanSerializerBase, set, (Set<String>) null);
    }

    public BeanSerializerBase(BeanSerializerBase beanSerializerBase, Set<String> set, Set<String> set2) {
        super(beanSerializerBase._handledType);
        this._beanType = beanSerializerBase._beanType;
        BeanPropertyWriter[] beanPropertyWriterArr = beanSerializerBase._props;
        BeanPropertyWriter[] beanPropertyWriterArr2 = beanSerializerBase._filteredProps;
        int length = beanPropertyWriterArr.length;
        ArrayList arrayList = new ArrayList(length);
        ArrayList arrayList2 = beanPropertyWriterArr2 == null ? null : new ArrayList(length);
        for (int i10 = 0; i10 < length; i10++) {
            BeanPropertyWriter beanPropertyWriter = beanPropertyWriterArr[i10];
            if (!IgnorePropertiesUtil.shouldIgnore(beanPropertyWriter.getName(), set, set2)) {
                arrayList.add(beanPropertyWriter);
                if (beanPropertyWriterArr2 != null) {
                    arrayList2.add(beanPropertyWriterArr2[i10]);
                }
            }
        }
        this._props = (BeanPropertyWriter[]) arrayList.toArray(new BeanPropertyWriter[arrayList.size()]);
        this._filteredProps = arrayList2 != null ? (BeanPropertyWriter[]) arrayList2.toArray(new BeanPropertyWriter[arrayList2.size()]) : null;
        this._typeId = beanSerializerBase._typeId;
        this._objectIdWriter = beanSerializerBase._objectIdWriter;
        this._propertyFilterId = beanSerializerBase._propertyFilterId;
        this._serializationShape = beanSerializerBase._serializationShape;
    }

    public BeanSerializerBase(BeanSerializerBase beanSerializerBase) {
        this(beanSerializerBase, beanSerializerBase._props, beanSerializerBase._filteredProps);
    }

    public BeanSerializerBase(BeanSerializerBase beanSerializerBase, NameTransformer nameTransformer) {
        this(beanSerializerBase, rename(beanSerializerBase._props, nameTransformer), rename(beanSerializerBase._filteredProps, nameTransformer));
    }
}
