package com.fasterxml.jackson.databind.ser.std;

import b3.f;
import b3.h;
import c3.a;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import java.math.BigDecimal;
import java.math.BigInteger;
import n3.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@a
/* loaded from: classes.dex */
public class NumberSerializer extends StdScalarSerializer<Number> implements c {

    /* renamed from: c, reason: collision with root package name */
    public static final NumberSerializer f4390c = new NumberSerializer(Number.class);

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class BigDecimalAsStringSerializer extends ToStringSerializerBase {

        /* renamed from: c, reason: collision with root package name */
        public static final BigDecimalAsStringSerializer f4391c = new BigDecimalAsStringSerializer();

        public BigDecimalAsStringSerializer() {
            super(BigDecimal.class, 0);
        }

        @Override // com.fasterxml.jackson.databind.ser.std.ToStringSerializerBase, b3.f
        public final boolean d(h hVar, Object obj) {
            return false;
        }

        @Override // com.fasterxml.jackson.databind.ser.std.ToStringSerializerBase, b3.f
        public final void f(Object obj, JsonGenerator jsonGenerator, h hVar) throws JsonMappingException {
            String string;
            if (jsonGenerator.P(JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN)) {
                BigDecimal bigDecimal = (BigDecimal) obj;
                int iScale = bigDecimal.scale();
                if (iScale < -9999 || iScale > 9999) {
                    String str = String.format("Attempt to write plain `java.math.BigDecimal` (see JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN) with illegal scale (%d): needs to be between [-%d, %d]", Integer.valueOf(bigDecimal.scale()), 9999, 9999);
                    hVar.getClass();
                    throw new JsonMappingException(((DefaultSerializerProvider) hVar).r, str, (Throwable) null);
                }
                string = bigDecimal.toPlainString();
            } else {
                string = obj.toString();
            }
            jsonGenerator.f1(string);
        }

        @Override // com.fasterxml.jackson.databind.ser.std.ToStringSerializerBase
        public final String o(Object obj) {
            throw new IllegalStateException();
        }
    }

    @Override // n3.c
    public final f<?> a(h hVar, BeanProperty beanProperty) {
        Class<T> cls = this.f4417a;
        JsonFormat.Value valueK = StdSerializer.k(hVar, beanProperty, cls);
        return (valueK == null || valueK.f3451b.ordinal() != 8) ? this : cls == BigDecimal.class ? BigDecimalAsStringSerializer.f4391c : ToStringSerializer.f4418c;
    }

    @Override // b3.f
    public final void f(Object obj, JsonGenerator jsonGenerator, h hVar) {
        Number number = (Number) obj;
        if (number instanceof BigDecimal) {
            jsonGenerator.P0((BigDecimal) number);
            return;
        }
        if (number instanceof BigInteger) {
            jsonGenerator.Q0((BigInteger) number);
            return;
        }
        if (number instanceof Long) {
            jsonGenerator.N0(number.longValue());
            return;
        }
        if (number instanceof Double) {
            jsonGenerator.K0(number.doubleValue());
            return;
        }
        if (number instanceof Float) {
            jsonGenerator.L0(number.floatValue());
        } else if ((number instanceof Integer) || (number instanceof Byte) || (number instanceof Short)) {
            jsonGenerator.M0(number.intValue());
        } else {
            jsonGenerator.O0(number.toString());
        }
    }
}
