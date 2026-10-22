package com.fasterxml.jackson.databind.ser;

import b3.f;
import b3.h;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ser.impl.BeanAsArraySerializer;
import com.fasterxml.jackson.databind.ser.impl.UnwrappingBeanSerializer;
import com.fasterxml.jackson.databind.ser.std.BeanSerializerBase;
import com.fasterxml.jackson.databind.util.NameTransformer;
import java.util.Set;
import o3.a;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class BeanSerializer extends BeanSerializerBase {
    @Override // b3.f
    public final void f(Object obj, JsonGenerator jsonGenerator, h hVar) {
        if (this.f4356l != null) {
            jsonGenerator.Q(obj);
            p(obj, jsonGenerator, hVar, true);
            return;
        }
        jsonGenerator.d1(obj);
        if (this.f4354j != null) {
            u(hVar);
            throw null;
        }
        t(obj, jsonGenerator, hVar);
        jsonGenerator.G0();
    }

    @Override // b3.f
    public final f<Object> h(NameTransformer nameTransformer) {
        return new UnwrappingBeanSerializer(this, nameTransformer);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.BeanSerializerBase
    public final BeanSerializerBase r() {
        return (this.f4356l == null && this.h == null && this.f4354j == null) ? new BeanAsArraySerializer(this) : this;
    }

    public final String toString() {
        return "BeanSerializer for ".concat(this.f4417a.getName());
    }

    @Override // com.fasterxml.jackson.databind.ser.std.BeanSerializerBase
    public final BeanSerializerBase v(Set<String> set, Set<String> set2) {
        return new BeanSerializer(this, set, set2);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.BeanSerializerBase
    public final BeanSerializerBase w(Object obj) {
        return new BeanSerializer(this, this.f4356l, obj);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.BeanSerializerBase
    public final BeanSerializerBase x(a aVar) {
        return new BeanSerializer(this, aVar, this.f4354j);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.BeanSerializerBase
    public final BeanSerializerBase y(BeanPropertyWriter[] beanPropertyWriterArr, BeanPropertyWriter[] beanPropertyWriterArr2) {
        return new BeanSerializer(this, beanPropertyWriterArr, beanPropertyWriterArr2);
    }
}
