package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.PropertyMetadata;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.deser.CreatorProperty;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.deser.ValueInstantiator;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class JsonLocationInstantiator extends ValueInstantiator.Base {
    public JsonLocationInstantiator() {
        super((Class<?>) JsonLocation.class);
    }

    public static CreatorProperty E(String str, JavaType javaType, int i10) {
        return new CreatorProperty(PropertyName.a(str), javaType, null, null, null, i10, null, PropertyMetadata.f3742k);
    }

    @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
    public final SettableBeanProperty[] C(DeserializationConfig deserializationConfig) {
        JavaType javaTypeC = deserializationConfig.c(Integer.TYPE);
        JavaType javaTypeC2 = deserializationConfig.c(Long.TYPE);
        return new SettableBeanProperty[]{E("sourceRef", deserializationConfig.c(Object.class), 0), E("byteOffset", javaTypeC2, 1), E("charOffset", javaTypeC2, 2), E("lineNr", javaTypeC, 3), E("columnNr", javaTypeC, 4)};
    }

    @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
    public final Object s(DeserializationContext deserializationContext, Object[] objArr) {
        Object obj = objArr[0];
        Object obj2 = objArr[1];
        long jLongValue = obj2 == null ? 0L : ((Number) obj2).longValue();
        Object obj3 = objArr[2];
        long jLongValue2 = obj3 != null ? ((Number) obj3).longValue() : 0L;
        Object obj4 = objArr[3];
        int iIntValue = obj4 == null ? 0 : ((Number) obj4).intValue();
        Object obj5 = objArr[4];
        return new JsonLocation(iIntValue, jLongValue, jLongValue2, obj5 != null ? ((Number) obj5).intValue() : 0, obj);
    }
}
