package com.fasterxml.jackson.databind.ser.std;

import b3.f;
import b3.h;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.ser.std.NumberSerializer;
import java.math.BigDecimal;
import n3.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class NumberSerializers$Base<T> extends StdScalarSerializer<T> implements c {
    @Override // n3.c
    public final f<?> a(h hVar, BeanProperty beanProperty) {
        Class<T> cls = this.f4417a;
        JsonFormat.Value valueK = StdSerializer.k(hVar, beanProperty, cls);
        if (valueK == null || valueK.f3451b.ordinal() != 8) {
            return this;
        }
        if (cls != BigDecimal.class) {
            return ToStringSerializer.f4418c;
        }
        NumberSerializer numberSerializer = NumberSerializer.f4390c;
        return NumberSerializer.BigDecimalAsStringSerializer.f4391c;
    }
}
