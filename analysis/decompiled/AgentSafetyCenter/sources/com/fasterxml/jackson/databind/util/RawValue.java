package com.fasterxml.jackson.databind.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class RawValue implements JsonSerializable {
    protected Object _value;

    public RawValue(String str) {
        this._value = str;
    }

    public void _serialize(JsonGenerator jsonGenerator) {
        Object obj = this._value;
        if (obj instanceof SerializableString) {
            jsonGenerator.writeRawValue((SerializableString) obj);
        } else {
            jsonGenerator.writeRawValue(String.valueOf(obj));
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RawValue)) {
            return false;
        }
        Object obj2 = this._value;
        Object obj3 = ((RawValue) obj)._value;
        if (obj2 == obj3) {
            return true;
        }
        return obj2 != null && obj2.equals(obj3);
    }

    public int hashCode() {
        Object obj = this._value;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public Object rawValue() {
        return this._value;
    }

    @Override // com.fasterxml.jackson.databind.JsonSerializable
    public void serialize(JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        Object obj = this._value;
        if (obj instanceof JsonSerializable) {
            ((JsonSerializable) obj).serialize(jsonGenerator, serializerProvider);
        } else {
            _serialize(jsonGenerator);
        }
    }

    @Override // com.fasterxml.jackson.databind.JsonSerializable
    public void serializeWithType(JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) {
        Object obj = this._value;
        if (obj instanceof JsonSerializable) {
            ((JsonSerializable) obj).serializeWithType(jsonGenerator, serializerProvider, typeSerializer);
        } else if (obj instanceof SerializableString) {
            serialize(jsonGenerator, serializerProvider);
        }
    }

    public String toString() {
        return k0.a.C("[RawValue of type ", ClassUtil.classNameOf(this._value), "]");
    }

    public RawValue(SerializableString serializableString) {
        this._value = serializableString;
    }

    public RawValue(JsonSerializable jsonSerializable) {
        this._value = jsonSerializable;
    }

    public RawValue(Object obj, boolean z10) {
        this._value = obj;
    }

    public void serialize(JsonGenerator jsonGenerator) {
        Object obj = this._value;
        if (obj instanceof JsonSerializable) {
            jsonGenerator.writeObject(obj);
        } else {
            _serialize(jsonGenerator);
        }
    }
}
