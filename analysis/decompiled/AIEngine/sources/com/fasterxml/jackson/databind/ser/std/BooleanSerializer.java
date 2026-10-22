package com.fasterxml.jackson.databind.ser.std;

import b3.f;
import b3.h;
import c3.a;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import k3.e;
import n3.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@a
/* loaded from: classes.dex */
public final class BooleanSerializer extends StdScalarSerializer<Object> implements c {

    /* renamed from: c, reason: collision with root package name */
    public final boolean f4358c;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class AsNumber extends StdScalarSerializer<Object> implements c {

        /* renamed from: c, reason: collision with root package name */
        public final boolean f4359c;

        public AsNumber(boolean z) {
            super(z ? Boolean.TYPE : Boolean.class);
            this.f4359c = z;
        }

        @Override // n3.c
        public final f<?> a(h hVar, BeanProperty beanProperty) {
            JsonFormat.Value valueK = StdSerializer.k(hVar, beanProperty, Boolean.class);
            return (valueK == null || valueK.f3451b.a()) ? this : new BooleanSerializer(this.f4359c);
        }

        @Override // b3.f
        public final void f(Object obj, JsonGenerator jsonGenerator, h hVar) {
            jsonGenerator.M0(!Boolean.FALSE.equals(obj) ? 1 : 0);
        }

        @Override // com.fasterxml.jackson.databind.ser.std.StdScalarSerializer, b3.f
        public final void g(Object obj, JsonGenerator jsonGenerator, h hVar, e eVar) {
            jsonGenerator.g0(Boolean.TRUE.equals(obj));
        }
    }

    public BooleanSerializer(boolean z) {
        super(z ? Boolean.TYPE : Boolean.class);
        this.f4358c = z;
    }

    @Override // n3.c
    public final f<?> a(h hVar, BeanProperty beanProperty) {
        JsonFormat.Value valueK = StdSerializer.k(hVar, beanProperty, Boolean.class);
        return (valueK == null || !valueK.f3451b.a()) ? this : new AsNumber(this.f4358c);
    }

    @Override // b3.f
    public final void f(Object obj, JsonGenerator jsonGenerator, h hVar) {
        jsonGenerator.g0(Boolean.TRUE.equals(obj));
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdScalarSerializer, b3.f
    public final void g(Object obj, JsonGenerator jsonGenerator, h hVar, e eVar) {
        jsonGenerator.g0(Boolean.TRUE.equals(obj));
    }
}
