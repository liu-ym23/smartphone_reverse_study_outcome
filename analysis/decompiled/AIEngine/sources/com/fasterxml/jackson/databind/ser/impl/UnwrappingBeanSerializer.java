package com.fasterxml.jackson.databind.ser.impl;

import b3.f;
import b3.h;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.std.BeanSerializerBase;
import com.fasterxml.jackson.databind.util.NameTransformer;
import java.io.Serializable;
import java.util.Set;
import k3.e;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class UnwrappingBeanSerializer extends BeanSerializerBase implements Serializable {

    /* renamed from: o, reason: collision with root package name */
    public final NameTransformer f4329o;

    public UnwrappingBeanSerializer(UnwrappingBeanSerializer unwrappingBeanSerializer, o3.a aVar, Object obj) {
        super(unwrappingBeanSerializer, aVar, obj);
        this.f4329o = unwrappingBeanSerializer.f4329o;
    }

    @Override // b3.f
    public final void f(Object obj, JsonGenerator jsonGenerator, h hVar) {
        jsonGenerator.Q(obj);
        if (this.f4356l != null) {
            p(obj, jsonGenerator, hVar, false);
        } else if (this.f4354j == null) {
            t(obj, jsonGenerator, hVar);
        } else {
            u(hVar);
            throw null;
        }
    }

    @Override // com.fasterxml.jackson.databind.ser.std.BeanSerializerBase, b3.f
    public final void g(Object obj, JsonGenerator jsonGenerator, h hVar, e eVar) {
        if (hVar.f3044a.q(SerializationFeature.FAIL_ON_UNWRAPPED_TYPE_IDENTIFIERS)) {
            hVar.i(this.f4417a, "Unwrapped property requires use of type information: cannot serialize without disabling `SerializationFeature.FAIL_ON_UNWRAPPED_TYPE_IDENTIFIERS`");
            throw null;
        }
        jsonGenerator.Q(obj);
        if (this.f4356l != null) {
            o(obj, jsonGenerator, hVar, eVar);
        } else if (this.f4354j == null) {
            t(obj, jsonGenerator, hVar);
        } else {
            u(hVar);
            throw null;
        }
    }

    @Override // b3.f
    public final f<Object> h(NameTransformer nameTransformer) {
        return new UnwrappingBeanSerializer(this, nameTransformer);
    }

    public final String toString() {
        return "UnwrappingBeanSerializer for ".concat(this.f4417a.getName());
    }

    @Override // com.fasterxml.jackson.databind.ser.std.BeanSerializerBase
    public final BeanSerializerBase v(Set<String> set, Set<String> set2) {
        return new UnwrappingBeanSerializer(this, set, set2);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.BeanSerializerBase
    public final BeanSerializerBase w(Object obj) {
        return new UnwrappingBeanSerializer(this, this.f4356l, obj);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.BeanSerializerBase
    public final BeanSerializerBase x(o3.a aVar) {
        return new UnwrappingBeanSerializer(this, aVar);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.BeanSerializerBase
    public final BeanSerializerBase y(BeanPropertyWriter[] beanPropertyWriterArr, BeanPropertyWriter[] beanPropertyWriterArr2) {
        return new UnwrappingBeanSerializer(this, beanPropertyWriterArr, beanPropertyWriterArr2);
    }

    public UnwrappingBeanSerializer(UnwrappingBeanSerializer unwrappingBeanSerializer, Set<String> set, Set<String> set2) {
        super(unwrappingBeanSerializer, set, set2);
        this.f4329o = unwrappingBeanSerializer.f4329o;
    }

    public UnwrappingBeanSerializer(UnwrappingBeanSerializer unwrappingBeanSerializer, BeanPropertyWriter[] beanPropertyWriterArr, BeanPropertyWriter[] beanPropertyWriterArr2) {
        super(unwrappingBeanSerializer, beanPropertyWriterArr, beanPropertyWriterArr2);
        this.f4329o = unwrappingBeanSerializer.f4329o;
    }

    public UnwrappingBeanSerializer(UnwrappingBeanSerializer unwrappingBeanSerializer, o3.a aVar) {
        super(unwrappingBeanSerializer, aVar, unwrappingBeanSerializer.f4354j);
        this.f4329o = unwrappingBeanSerializer.f4329o;
    }

    public UnwrappingBeanSerializer(BeanSerializerBase beanSerializerBase, NameTransformer nameTransformer) {
        super(beanSerializerBase, BeanSerializerBase.s(beanSerializerBase.f4352d, nameTransformer), BeanSerializerBase.s(beanSerializerBase.f4353e, nameTransformer));
        this.f4329o = nameTransformer;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.BeanSerializerBase
    public final BeanSerializerBase r() {
        return this;
    }
}
