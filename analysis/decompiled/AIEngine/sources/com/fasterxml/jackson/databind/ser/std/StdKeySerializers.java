package com.fasterxml.jackson.databind.ser.std;

import b3.f;
import b3.h;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ser.impl.a;
import com.fasterxml.jackson.databind.util.EnumValues;
import java.util.Calendar;
import java.util.Date;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class StdKeySerializers {

    /* renamed from: a, reason: collision with root package name */
    public static final StringKeySerializer f4412a;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class Default extends StdSerializer<Object> {

        /* renamed from: c, reason: collision with root package name */
        public final int f4413c;

        public Default(Class cls, int i10) {
            super(cls, 0);
            this.f4413c = i10;
        }

        @Override // b3.f
        public final void f(Object obj, JsonGenerator jsonGenerator, h hVar) {
            String strValueOf;
            switch (this.f4413c) {
                case 1:
                    Date date = (Date) obj;
                    hVar.getClass();
                    if (!hVar.f3044a.q(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS)) {
                        jsonGenerator.H0(hVar.n().format(date));
                        break;
                    } else {
                        jsonGenerator.H0(String.valueOf(date.getTime()));
                        break;
                    }
                case 2:
                    long timeInMillis = ((Calendar) obj).getTimeInMillis();
                    hVar.getClass();
                    if (!hVar.f3044a.q(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS)) {
                        jsonGenerator.H0(hVar.n().format(new Date(timeInMillis)));
                        break;
                    } else {
                        jsonGenerator.H0(String.valueOf(timeInMillis));
                        break;
                    }
                case 3:
                    jsonGenerator.H0(((Class) obj).getName());
                    break;
                case 4:
                    if (hVar.f3044a.q(SerializationFeature.WRITE_ENUMS_USING_TO_STRING)) {
                        strValueOf = obj.toString();
                    } else {
                        Enum r32 = (Enum) obj;
                        strValueOf = hVar.f3044a.q(SerializationFeature.WRITE_ENUM_KEYS_USING_INDEX) ? String.valueOf(r32.ordinal()) : r32.name();
                    }
                    jsonGenerator.H0(strValueOf);
                    break;
                case 5:
                case 6:
                    long jLongValue = ((Number) obj).longValue();
                    jsonGenerator.getClass();
                    jsonGenerator.H0(Long.toString(jLongValue));
                    break;
                case 7:
                    jsonGenerator.H0(hVar.f3044a.f3828b.f3795k.e((byte[]) obj));
                    break;
                default:
                    jsonGenerator.H0(obj.toString());
                    break;
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class Dynamic extends StdSerializer<Object> {

        /* renamed from: c, reason: collision with root package name */
        public transient a f4414c;

        public Dynamic() {
            super(String.class, 0);
            this.f4414c = a.b.f4334a;
        }

        @Override // b3.f
        public final void f(Object obj, JsonGenerator jsonGenerator, h hVar) {
            Class<?> cls = obj.getClass();
            a aVar = this.f4414c;
            f<Object> fVarC = aVar.c(cls);
            if (fVarC == null) {
                if (cls == Object.class) {
                    fVarC = new Default(cls, 8);
                    this.f4414c = aVar.b(cls, fVarC);
                } else {
                    fVarC = hVar.s(hVar.f3044a.c(cls), null);
                    a aVarB = aVar.b(cls, fVarC);
                    if (aVar != aVarB) {
                        this.f4414c = aVarB;
                    }
                }
            }
            fVarC.f(obj, jsonGenerator, hVar);
        }

        public Object readResolve() {
            this.f4414c = a.b.f4334a;
            return this;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class EnumKeySerializer extends StdSerializer<Object> {

        /* renamed from: c, reason: collision with root package name */
        public final EnumValues f4415c;

        public EnumKeySerializer(Class<?> cls, EnumValues enumValues) {
            super(cls, 0);
            this.f4415c = enumValues;
        }

        @Override // b3.f
        public final void f(Object obj, JsonGenerator jsonGenerator, h hVar) {
            if (hVar.f3044a.q(SerializationFeature.WRITE_ENUMS_USING_TO_STRING)) {
                jsonGenerator.H0(obj.toString());
                return;
            }
            Enum r32 = (Enum) obj;
            if (hVar.f3044a.q(SerializationFeature.WRITE_ENUM_KEYS_USING_INDEX)) {
                jsonGenerator.H0(String.valueOf(r32.ordinal()));
            } else {
                jsonGenerator.I0(this.f4415c.f4505b[r32.ordinal()]);
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class StringKeySerializer extends StdSerializer<Object> {
        public StringKeySerializer() {
            super(String.class, 0);
        }

        @Override // b3.f
        public final void f(Object obj, JsonGenerator jsonGenerator, h hVar) {
            jsonGenerator.H0((String) obj);
        }
    }

    static {
        new StdKeySerializer();
        f4412a = new StringKeySerializer();
    }
}
