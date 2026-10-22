package com.fasterxml.jackson.databind.ser.std;

import b3.f;
import b3.h;
import c3.a;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.EnumValues;
import java.util.Objects;
import n3.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@a
/* loaded from: classes.dex */
public class EnumSerializer extends StdScalarSerializer<Enum<?>> implements c {

    /* renamed from: c, reason: collision with root package name */
    public final EnumValues f4363c;

    /* renamed from: d, reason: collision with root package name */
    public final Boolean f4364d;

    public EnumSerializer(EnumValues enumValues, Boolean bool) {
        super(enumValues.f4504a);
        this.f4363c = enumValues;
        this.f4364d = bool;
    }

    public static Boolean o(Class<?> cls, JsonFormat.Value value, boolean z, Boolean bool) {
        JsonFormat.Shape shape = value.f3451b;
        if (shape == null || shape == JsonFormat.Shape.f3439a || shape == JsonFormat.Shape.f3441c) {
            return bool;
        }
        if (shape == JsonFormat.Shape.f3446l || shape == JsonFormat.Shape.f3440b) {
            return Boolean.FALSE;
        }
        if (shape.a() || shape == JsonFormat.Shape.f3442d) {
            return Boolean.TRUE;
        }
        String name = cls.getName();
        String str = z ? "class" : "property";
        StringBuilder sb2 = new StringBuilder("Unsupported serialization shape (");
        sb2.append(shape);
        sb2.append(") for Enum ");
        sb2.append(name);
        sb2.append(", not supported as ");
        throw new IllegalArgumentException(ai.onnxruntime.a.o(sb2, str, " annotation"));
    }

    @Override // n3.c
    public final f<?> a(h hVar, BeanProperty beanProperty) {
        Class<T> cls = this.f4417a;
        JsonFormat.Value valueK = StdSerializer.k(hVar, beanProperty, cls);
        if (valueK != null) {
            Boolean bool = this.f4364d;
            Boolean boolO = o(cls, valueK, false, bool);
            if (!Objects.equals(boolO, bool)) {
                return new EnumSerializer(this.f4363c, boolO);
            }
        }
        return this;
    }

    @Override // b3.f
    public final void f(Object obj, JsonGenerator jsonGenerator, h hVar) {
        boolean zQ;
        Enum r32 = (Enum) obj;
        Boolean bool = this.f4364d;
        if (bool != null) {
            zQ = bool.booleanValue();
        } else {
            zQ = hVar.f3044a.q(SerializationFeature.WRITE_ENUMS_USING_INDEX);
        }
        if (zQ) {
            jsonGenerator.M0(r32.ordinal());
            return;
        }
        if (hVar.f3044a.q(SerializationFeature.WRITE_ENUMS_USING_TO_STRING)) {
            jsonGenerator.f1(r32.toString());
        } else {
            jsonGenerator.g1(this.f4363c.f4505b[r32.ordinal()]);
        }
    }
}
