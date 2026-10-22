package com.fasterxml.jackson.databind.ser.impl;

import b3.f;
import b3.h;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.WritableTypeId;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.BeanSerializer;
import com.fasterxml.jackson.databind.ser.std.BeanSerializerBase;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.fasterxml.jackson.databind.util.NameTransformer;
import java.io.IOException;
import java.util.Set;
import k3.e;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class BeanAsArraySerializer extends BeanSerializerBase {

    /* renamed from: o, reason: collision with root package name */
    public final BeanSerializerBase f4308o;

    public BeanAsArraySerializer(BeanAsArraySerializer beanAsArraySerializer, Set set, Set set2) {
        super(beanAsArraySerializer, (Set<String>) set, (Set<String>) set2);
        this.f4308o = beanAsArraySerializer;
    }

    @Override // b3.f
    public final void f(Object obj, JsonGenerator jsonGenerator, h hVar) throws IOException {
        if (hVar.f3044a.q(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED) && this.f4352d.length == 1) {
            z(obj, jsonGenerator, hVar);
            return;
        }
        jsonGenerator.a1(obj);
        z(obj, jsonGenerator, hVar);
        jsonGenerator.C0();
    }

    @Override // com.fasterxml.jackson.databind.ser.std.BeanSerializerBase, b3.f
    public final void g(Object obj, JsonGenerator jsonGenerator, h hVar, e eVar) throws IOException {
        if (this.f4356l != null) {
            o(obj, jsonGenerator, hVar, eVar);
            return;
        }
        WritableTypeId writableTypeIdQ = q(eVar, obj, JsonToken.START_ARRAY);
        eVar.e(jsonGenerator, writableTypeIdQ);
        jsonGenerator.Q(obj);
        z(obj, jsonGenerator, hVar);
        eVar.f(jsonGenerator, writableTypeIdQ);
    }

    @Override // b3.f
    public final f<Object> h(NameTransformer nameTransformer) {
        return this.f4308o.h(nameTransformer);
    }

    public final String toString() {
        return "BeanAsArraySerializer for ".concat(this.f4417a.getName());
    }

    @Override // com.fasterxml.jackson.databind.ser.std.BeanSerializerBase
    public final BeanSerializerBase v(Set set, Set set2) {
        return new BeanAsArraySerializer(this, set, set2);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.BeanSerializerBase
    public final BeanSerializerBase w(Object obj) {
        return new BeanAsArraySerializer(this, this.f4356l, obj);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.BeanSerializerBase
    public final BeanSerializerBase x(o3.a aVar) {
        return this.f4308o.x(aVar);
    }

    public final void z(Object obj, JsonGenerator jsonGenerator, h hVar) throws IOException {
        if (this.f4353e != null) {
            hVar.getClass();
        }
        BeanPropertyWriter[] beanPropertyWriterArr = this.f4352d;
        int i10 = 0;
        try {
            int length = beanPropertyWriterArr.length;
            while (i10 < length) {
                BeanPropertyWriter beanPropertyWriter = beanPropertyWriterArr[i10];
                if (beanPropertyWriter == null) {
                    jsonGenerator.J0();
                } else {
                    beanPropertyWriter.k(obj, jsonGenerator, hVar);
                }
                i10++;
            }
        } catch (Exception e10) {
            StdSerializer.n(hVar, e10, obj, i10 != beanPropertyWriterArr.length ? beanPropertyWriterArr[i10].f4290c.f3610a : "[anySetter]");
            throw null;
        } catch (StackOverflowError e11) {
            JsonMappingException jsonMappingException = new JsonMappingException(jsonGenerator, "Infinite recursion (StackOverflowError)", e11);
            jsonMappingException.f(new JsonMappingException.Reference(obj, i10 != beanPropertyWriterArr.length ? beanPropertyWriterArr[i10].f4290c.f3610a : "[anySetter]"));
            throw jsonMappingException;
        }
    }

    public BeanAsArraySerializer(BeanAsArraySerializer beanAsArraySerializer, o3.a aVar, Object obj) {
        super(beanAsArraySerializer, aVar, obj);
        this.f4308o = beanAsArraySerializer;
    }

    public BeanAsArraySerializer(BeanSerializer beanSerializer) {
        super(beanSerializer, (o3.a) null, beanSerializer.f4354j);
        this.f4308o = beanSerializer;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.BeanSerializerBase
    public final BeanSerializerBase r() {
        return this;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.BeanSerializerBase
    public final BeanSerializerBase y(BeanPropertyWriter[] beanPropertyWriterArr, BeanPropertyWriter[] beanPropertyWriterArr2) {
        return this;
    }
}
