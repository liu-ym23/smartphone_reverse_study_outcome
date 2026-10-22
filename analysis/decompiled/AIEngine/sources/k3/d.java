package k3;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.jsontype.impl.TypeDeserializerBase;
import java.util.ArrayList;
import k3.d;
import l3.h;
import l3.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface d<T extends d<T>> {
    h a(Class cls);

    l b(SerializationConfig serializationConfig, JavaType javaType, ArrayList arrayList);

    TypeDeserializerBase c(DeserializationConfig deserializationConfig, JavaType javaType, ArrayList arrayList);

    h d(JsonTypeInfo.Id id2, c cVar);

    Class<?> e();
}
