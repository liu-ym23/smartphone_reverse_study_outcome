package com.fasterxml.jackson.databind.ext;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.WritableTypeId;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.fasterxml.jackson.databind.ser.Serializers;
import com.fasterxml.jackson.databind.ser.std.CalendarSerializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import java.util.Calendar;
import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class CoreXMLSerializers extends Serializers.Base {

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class QNameSerializer extends StdSerializer<QName> implements ContextualSerializer {
        public static final JsonSerializer<?> instance = new QNameSerializer();
        private static final long serialVersionUID = 1;

        public QNameSerializer() {
            super(QName.class);
        }

        private void serializeProperties(QName qName, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.writeStringField("localPart", qName.getLocalPart());
            if (!qName.getNamespaceURI().isEmpty()) {
                jsonGenerator.writeStringField("namespaceURI", qName.getNamespaceURI());
            }
            if (qName.getPrefix().isEmpty()) {
                return;
            }
            jsonGenerator.writeStringField("prefix", qName.getPrefix());
        }

        @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, com.fasterxml.jackson.databind.JsonSerializer, com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitable
        public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper jsonFormatVisitorWrapper, JavaType javaType) {
            jsonFormatVisitorWrapper.expectObjectFormat(javaType);
        }

        @Override // com.fasterxml.jackson.databind.ser.ContextualSerializer
        public JsonSerializer<?> createContextual(SerializerProvider serializerProvider, BeanProperty beanProperty) {
            JsonFormat.Value valueFindFormatOverrides = findFormatOverrides(serializerProvider, beanProperty, handledType());
            return (valueFindFormatOverrides == null || valueFindFormatOverrides.getShape() != JsonFormat.Shape.OBJECT) ? ToStringSerializer.instance : this;
        }

        @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, com.fasterxml.jackson.databind.JsonSerializer
        public void serialize(QName qName, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.writeStartObject(qName);
            serializeProperties(qName, jsonGenerator, serializerProvider);
            jsonGenerator.writeEndObject();
        }

        @Override // com.fasterxml.jackson.databind.JsonSerializer
        public final void serializeWithType(QName qName, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) {
            WritableTypeId writableTypeIdWriteTypePrefix = typeSerializer.writeTypePrefix(jsonGenerator, typeSerializer.typeId(qName, JsonToken.START_OBJECT));
            serializeProperties(qName, jsonGenerator, serializerProvider);
            typeSerializer.writeTypeSuffix(jsonGenerator, writableTypeIdWriteTypePrefix);
        }
    }

    @Override // com.fasterxml.jackson.databind.ser.Serializers.Base, com.fasterxml.jackson.databind.ser.Serializers
    public JsonSerializer<?> findSerializer(SerializationConfig serializationConfig, JavaType javaType, BeanDescription beanDescription) {
        Class<?> rawClass = javaType.getRawClass();
        if (Duration.class.isAssignableFrom(rawClass)) {
            return ToStringSerializer.instance;
        }
        if (QName.class.isAssignableFrom(rawClass)) {
            return QNameSerializer.instance;
        }
        if (XMLGregorianCalendar.class.isAssignableFrom(rawClass)) {
            return XMLGregorianCalendarSerializer.instance;
        }
        return null;
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class XMLGregorianCalendarSerializer extends StdSerializer<XMLGregorianCalendar> implements ContextualSerializer {
        static final XMLGregorianCalendarSerializer instance = new XMLGregorianCalendarSerializer();
        final JsonSerializer<Object> _delegate;

        public XMLGregorianCalendarSerializer(JsonSerializer<?> jsonSerializer) {
            super(XMLGregorianCalendar.class);
            this._delegate = jsonSerializer;
        }

        public Calendar _convert(XMLGregorianCalendar xMLGregorianCalendar) {
            if (xMLGregorianCalendar == null) {
                return null;
            }
            return xMLGregorianCalendar.toGregorianCalendar();
        }

        @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, com.fasterxml.jackson.databind.JsonSerializer, com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitable
        public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper jsonFormatVisitorWrapper, JavaType javaType) {
            this._delegate.acceptJsonFormatVisitor(jsonFormatVisitorWrapper, null);
        }

        @Override // com.fasterxml.jackson.databind.ser.ContextualSerializer
        public JsonSerializer<?> createContextual(SerializerProvider serializerProvider, BeanProperty beanProperty) {
            JsonSerializer<?> jsonSerializerHandlePrimaryContextualization = serializerProvider.handlePrimaryContextualization(this._delegate, beanProperty);
            return jsonSerializerHandlePrimaryContextualization != this._delegate ? new XMLGregorianCalendarSerializer(jsonSerializerHandlePrimaryContextualization) : this;
        }

        @Override // com.fasterxml.jackson.databind.JsonSerializer
        public JsonSerializer<?> getDelegatee() {
            return this._delegate;
        }

        @Override // com.fasterxml.jackson.databind.JsonSerializer
        public boolean isEmpty(SerializerProvider serializerProvider, XMLGregorianCalendar xMLGregorianCalendar) {
            return this._delegate.isEmpty(serializerProvider, _convert(xMLGregorianCalendar));
        }

        @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, com.fasterxml.jackson.databind.JsonSerializer
        public void serialize(XMLGregorianCalendar xMLGregorianCalendar, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            this._delegate.serialize(_convert(xMLGregorianCalendar), jsonGenerator, serializerProvider);
        }

        @Override // com.fasterxml.jackson.databind.JsonSerializer
        public void serializeWithType(XMLGregorianCalendar xMLGregorianCalendar, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) {
            WritableTypeId writableTypeIdWriteTypePrefix = typeSerializer.writeTypePrefix(jsonGenerator, typeSerializer.typeId(xMLGregorianCalendar, XMLGregorianCalendar.class, JsonToken.VALUE_STRING));
            serialize(xMLGregorianCalendar, jsonGenerator, serializerProvider);
            typeSerializer.writeTypeSuffix(jsonGenerator, writableTypeIdWriteTypePrefix);
        }

        public XMLGregorianCalendarSerializer() {
            this(CalendarSerializer.instance);
        }
    }
}
