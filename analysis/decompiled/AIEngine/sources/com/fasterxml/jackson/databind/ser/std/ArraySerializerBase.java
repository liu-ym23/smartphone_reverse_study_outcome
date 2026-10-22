package com.fasterxml.jackson.databind.ser.std;

import b3.f;
import b3.h;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.WritableTypeId;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ser.ContainerSerializer;
import java.util.Objects;
import k3.e;
import n3.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class ArraySerializerBase<T> extends ContainerSerializer<T> implements c {

    /* renamed from: c, reason: collision with root package name */
    public final BeanProperty f4342c;

    /* renamed from: d, reason: collision with root package name */
    public final Boolean f4343d;

    public ArraySerializerBase(Class<T> cls) {
        super(cls);
        this.f4342c = null;
        this.f4343d = null;
    }

    public f<?> a(h hVar, BeanProperty beanProperty) {
        JsonFormat.Value valueK;
        if (beanProperty == null || (valueK = StdSerializer.k(hVar, beanProperty, this.f4417a)) == null) {
            return this;
        }
        Boolean boolB = valueK.b(JsonFormat.Feature.f3436c);
        return !Objects.equals(boolB, this.f4343d) ? q(beanProperty, boolB) : this;
    }

    @Override // b3.f
    public final void g(T t8, JsonGenerator jsonGenerator, h hVar, e eVar) {
        WritableTypeId writableTypeIdE = eVar.e(jsonGenerator, eVar.d(JsonToken.START_ARRAY, t8));
        jsonGenerator.Q(t8);
        r(t8, jsonGenerator, hVar);
        eVar.f(jsonGenerator, writableTypeIdE);
    }

    public final boolean p(h hVar) {
        Boolean bool = this.f4343d;
        if (bool != null) {
            return bool.booleanValue();
        }
        return hVar.f3044a.q(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED);
    }

    public abstract f<?> q(BeanProperty beanProperty, Boolean bool);

    public abstract void r(T t8, JsonGenerator jsonGenerator, h hVar);

    public ArraySerializerBase(ArraySerializerBase<?> arraySerializerBase, BeanProperty beanProperty, Boolean bool) {
        super(arraySerializerBase.f4417a, 0);
        this.f4342c = beanProperty;
        this.f4343d = bool;
    }
}
