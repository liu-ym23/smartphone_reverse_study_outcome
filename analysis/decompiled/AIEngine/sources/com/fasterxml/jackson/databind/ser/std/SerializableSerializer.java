package com.fasterxml.jackson.databind.ser.std;

import b3.e;
import b3.h;
import c3.a;
import com.fasterxml.jackson.core.JsonGenerator;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@a
/* loaded from: classes.dex */
public class SerializableSerializer extends StdSerializer<e> {

    /* renamed from: c, reason: collision with root package name */
    public static final SerializableSerializer f4406c = new SerializableSerializer();

    public SerializableSerializer() {
        super(e.class);
    }

    @Override // b3.f
    public final boolean d(h hVar, Object obj) {
        e eVar = (e) obj;
        if (eVar instanceof e.a) {
            return ((e.a) eVar).isEmpty();
        }
        return false;
    }

    @Override // b3.f
    public final void f(Object obj, JsonGenerator jsonGenerator, h hVar) {
        ((e) obj).a(jsonGenerator, hVar);
    }

    @Override // b3.f
    public final void g(Object obj, JsonGenerator jsonGenerator, h hVar, k3.e eVar) {
        ((e) obj).b(jsonGenerator, hVar, eVar);
    }
}
