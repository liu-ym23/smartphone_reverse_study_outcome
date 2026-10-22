package com.fasterxml.jackson.databind.jsontype.impl;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.BeanProperty;
import k3.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class AsExternalTypeDeserializer extends AsArrayTypeDeserializer {
    @Override // com.fasterxml.jackson.databind.jsontype.impl.AsArrayTypeDeserializer, k3.b
    public final b f(BeanProperty beanProperty) {
        return beanProperty == this.f4250c ? this : new AsExternalTypeDeserializer(this, beanProperty);
    }

    @Override // com.fasterxml.jackson.databind.jsontype.impl.AsArrayTypeDeserializer, k3.b
    public final JsonTypeInfo.As j() {
        return JsonTypeInfo.As.f3484d;
    }
}
