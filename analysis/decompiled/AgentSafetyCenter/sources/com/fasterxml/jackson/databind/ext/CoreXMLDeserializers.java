package com.fasterxml.jackson.databind.ext;

import ad.o;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.Deserializers;
import com.fasterxml.jackson.databind.deser.std.FromStringDeserializer;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class CoreXMLDeserializers extends Deserializers.Base {
    protected static final QName EMPTY_QNAME = QName.valueOf("");
    protected static final int TYPE_DURATION = 1;
    protected static final int TYPE_G_CALENDAR = 2;
    protected static final int TYPE_QNAME = 3;
    static final DatatypeFactory _dataTypeFactory;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class Std extends FromStringDeserializer<Object> {
        private static final long serialVersionUID = 1;
        protected final int _kind;

        public Std(Class<?> cls, int i) {
            super(cls);
            this._kind = i;
        }

        private QName _parseQNameObject(JsonParser jsonParser, DeserializationContext deserializationContext) throws MismatchedInputException {
            JsonNode tree = deserializationContext.readTree(jsonParser);
            JsonNode jsonNode = tree.get("localPart");
            if (jsonNode == null) {
                deserializationContext.reportInputMismatch(this, "Object value for `QName` is missing required property 'localPart'", new Object[0]);
            }
            if (!jsonNode.isTextual()) {
                deserializationContext.reportInputMismatch(this, "Object value property 'localPart' for `QName` must be of type STRING, not %s", jsonNode.getNodeType());
            }
            JsonNode jsonNode2 = tree.get("namespaceURI");
            if (jsonNode2 == null) {
                return new QName(jsonNode.asText());
            }
            if (!tree.has("prefix")) {
                return new QName(jsonNode2.asText(), jsonNode.asText());
            }
            return new QName(jsonNode2.asText(), jsonNode.asText(), tree.get("prefix").asText());
        }

        @Override // com.fasterxml.jackson.databind.deser.std.FromStringDeserializer
        public Object _deserialize(String str, DeserializationContext deserializationContext) {
            int i = this._kind;
            if (i == 1) {
                return CoreXMLDeserializers._dataTypeFactory.newDuration(str);
            }
            if (i == 2) {
                try {
                    return _gregorianFromDate(deserializationContext, _parseDate(str, deserializationContext));
                } catch (JsonMappingException unused) {
                    return CoreXMLDeserializers._dataTypeFactory.newXMLGregorianCalendar(str);
                }
            }
            if (i == 3) {
                return QName.valueOf(str);
            }
            throw new IllegalStateException();
        }

        @Override // com.fasterxml.jackson.databind.deser.std.FromStringDeserializer
        public Object _deserializeFromEmptyString(DeserializationContext deserializationContext) {
            return this._kind == 3 ? CoreXMLDeserializers.EMPTY_QNAME : super._deserializeFromEmptyString(deserializationContext);
        }

        public XMLGregorianCalendar _gregorianFromDate(DeserializationContext deserializationContext, Date date) {
            if (date == null) {
                return null;
            }
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            gregorianCalendar.setTime(date);
            TimeZone timeZone = deserializationContext.getTimeZone();
            if (timeZone != null) {
                gregorianCalendar.setTimeZone(timeZone);
            }
            return CoreXMLDeserializers._dataTypeFactory.newXMLGregorianCalendar(gregorianCalendar);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.FromStringDeserializer, com.fasterxml.jackson.databind.JsonDeserializer
        public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) {
            return (this._kind == 2 && jsonParser.hasToken(JsonToken.VALUE_NUMBER_INT)) ? _gregorianFromDate(deserializationContext, _parseDate(jsonParser, deserializationContext)) : (this._kind == 3 && jsonParser.hasToken(JsonToken.START_OBJECT)) ? _parseQNameObject(jsonParser, deserializationContext) : super.deserialize(jsonParser, deserializationContext);
        }
    }

    static {
        try {
            _dataTypeFactory = DatatypeFactory.newInstance();
        } catch (DatatypeConfigurationException e10) {
            o.h(e10);
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.Deserializers.Base, com.fasterxml.jackson.databind.deser.Deserializers
    public JsonDeserializer<?> findBeanDeserializer(JavaType javaType, DeserializationConfig deserializationConfig, BeanDescription beanDescription) {
        Class<?> rawClass = javaType.getRawClass();
        if (rawClass == QName.class) {
            return new Std(rawClass, 3);
        }
        if (rawClass == XMLGregorianCalendar.class) {
            return new Std(rawClass, 2);
        }
        if (rawClass == Duration.class) {
            return new Std(rawClass, 1);
        }
        return null;
    }

    @Override // com.fasterxml.jackson.databind.deser.Deserializers
    public boolean hasDeserializerFor(DeserializationConfig deserializationConfig, Class<?> cls) {
        return cls == QName.class || cls == XMLGregorianCalendar.class || cls == Duration.class;
    }
}
