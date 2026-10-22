package com.fasterxml.jackson.databind.ser.std;

import c3.a;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@a
/* loaded from: classes.dex */
public class ToStringSerializer extends ToStringSerializerBase {

    /* renamed from: c, reason: collision with root package name */
    public static final ToStringSerializer f4418c = new ToStringSerializer();

    public ToStringSerializer() {
        super(Object.class, 0);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.ToStringSerializerBase
    public final String o(Object obj) {
        return obj.toString();
    }
}
