package com.fasterxml.jackson.databind.jsontype;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder;
import java.util.Collection;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public interface TypeResolverBuilder<T extends TypeResolverBuilder<T>> {
    TypeDeserializer buildTypeDeserializer(DeserializationConfig deserializationConfig, JavaType javaType, Collection<NamedType> collection);

    TypeSerializer buildTypeSerializer(SerializationConfig serializationConfig, JavaType javaType, Collection<NamedType> collection);

    T defaultImpl(Class<?> cls);

    Class<?> getDefaultImpl();

    T inclusion(JsonTypeInfo.As as);

    T init(JsonTypeInfo.Id id2, TypeIdResolver typeIdResolver);

    default T init(JsonTypeInfo.Value value, TypeIdResolver typeIdResolver) {
        return (T) init(value.getIdType(), typeIdResolver);
    }

    T typeIdVisibility(boolean z10);

    T typeProperty(String str);

    default T withDefaultImpl(Class<?> cls) {
        return (T) defaultImpl(cls);
    }

    default T withSettings(JsonTypeInfo.Value value) {
        throw new IllegalStateException("TypeResolveBuilder implementation " + getClass().getName() + " must implement `withSettings()`");
    }
}
