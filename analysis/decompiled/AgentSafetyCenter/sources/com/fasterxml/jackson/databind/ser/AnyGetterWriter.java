package com.fasterxml.jackson.databind.ser;

import androidx.activity.b;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.ser.std.MapSerializer;
import java.io.Serializable;
import java.util.Map;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class AnyGetterWriter extends BeanPropertyWriter implements Serializable {
    private static final long serialVersionUID = 1;
    protected final AnnotatedMember _accessor;
    protected MapSerializer _mapSerializer;
    protected final BeanProperty _property;
    protected JsonSerializer<Object> _serializer;

    public AnyGetterWriter(BeanPropertyWriter beanPropertyWriter, BeanProperty beanProperty, AnnotatedMember annotatedMember, JsonSerializer<?> jsonSerializer) {
        super(beanPropertyWriter);
        this._accessor = annotatedMember;
        this._property = beanProperty;
        this._serializer = jsonSerializer;
        if (jsonSerializer instanceof MapSerializer) {
            this._mapSerializer = (MapSerializer) jsonSerializer;
        }
    }

    @Override // com.fasterxml.jackson.databind.ser.BeanPropertyWriter
    public void fixAccess(SerializationConfig serializationConfig) throws SecurityException {
        this._accessor.fixAccess(serializationConfig.isEnabled(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
    }

    public void getAndFilter(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, PropertyFilter propertyFilter) throws InvalidDefinitionException {
        Object value = this._accessor.getValue(obj);
        if (value == null) {
            return;
        }
        if (!(value instanceof Map)) {
            serializerProvider.reportBadDefinition(this._property.getType(), b.j("Value returned by 'any-getter' (", this._accessor.getName(), "()) not java.util.Map but ", value.getClass().getName()));
        }
        MapSerializer mapSerializer = this._mapSerializer;
        if (mapSerializer != null) {
            mapSerializer.serializeFilteredAnyProperties(serializerProvider, jsonGenerator, obj, (Map) value, propertyFilter, null);
        } else {
            this._serializer.serialize(value, jsonGenerator, serializerProvider);
        }
    }

    public void getAndSerialize(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws InvalidDefinitionException {
        Object value = this._accessor.getValue(obj);
        if (value == null) {
            return;
        }
        if (!(value instanceof Map)) {
            serializerProvider.reportBadDefinition(this._property.getType(), b.j("Value returned by 'any-getter' ", this._accessor.getName(), "() not java.util.Map but ", value.getClass().getName()));
        }
        MapSerializer mapSerializer = this._mapSerializer;
        if (mapSerializer != null) {
            mapSerializer.serializeWithoutTypeInfo((Map) value, jsonGenerator, serializerProvider);
        } else {
            this._serializer.serialize(value, jsonGenerator, serializerProvider);
        }
    }

    public void resolve(SerializerProvider serializerProvider) {
        JsonSerializer<?> jsonSerializer = this._serializer;
        if (jsonSerializer instanceof ContextualSerializer) {
            JsonSerializer<?> jsonSerializerHandlePrimaryContextualization = serializerProvider.handlePrimaryContextualization(jsonSerializer, this._property);
            this._serializer = jsonSerializerHandlePrimaryContextualization;
            if (jsonSerializerHandlePrimaryContextualization instanceof MapSerializer) {
                this._mapSerializer = (MapSerializer) jsonSerializerHandlePrimaryContextualization;
            }
        }
    }

    @Override // com.fasterxml.jackson.databind.ser.BeanPropertyWriter, com.fasterxml.jackson.databind.ser.PropertyWriter
    public void serializeAsField(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws InvalidDefinitionException {
        getAndSerialize(obj, jsonGenerator, serializerProvider);
    }

    @Deprecated
    public AnyGetterWriter(BeanProperty beanProperty, AnnotatedMember annotatedMember, JsonSerializer<?> jsonSerializer) {
        this(null, beanProperty, annotatedMember, jsonSerializer);
    }
}
