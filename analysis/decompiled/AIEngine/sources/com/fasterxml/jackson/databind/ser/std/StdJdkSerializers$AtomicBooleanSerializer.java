package com.fasterxml.jackson.databind.ser.std;

import b3.h;
import com.fasterxml.jackson.core.JsonGenerator;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class StdJdkSerializers$AtomicBooleanSerializer extends StdScalarSerializer<AtomicBoolean> {
    public StdJdkSerializers$AtomicBooleanSerializer() {
        super(AtomicBoolean.class);
    }

    @Override // b3.f
    public final void f(Object obj, JsonGenerator jsonGenerator, h hVar) {
        jsonGenerator.g0(((AtomicBoolean) obj).get());
    }
}
