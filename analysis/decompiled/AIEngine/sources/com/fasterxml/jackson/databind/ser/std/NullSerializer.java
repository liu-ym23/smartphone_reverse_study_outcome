package com.fasterxml.jackson.databind.ser.std;

import b3.h;
import c3.a;
import com.fasterxml.jackson.core.JsonGenerator;
import k3.e;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@a
/* loaded from: classes.dex */
public class NullSerializer extends StdSerializer<Object> {

    /* renamed from: c, reason: collision with root package name */
    public static final NullSerializer f4389c = new NullSerializer();

    private NullSerializer() {
        super(Object.class);
    }

    @Override // b3.f
    public final void f(Object obj, JsonGenerator jsonGenerator, h hVar) {
        jsonGenerator.J0();
    }

    @Override // b3.f
    public final void g(Object obj, JsonGenerator jsonGenerator, h hVar, e eVar) {
        jsonGenerator.J0();
    }
}
