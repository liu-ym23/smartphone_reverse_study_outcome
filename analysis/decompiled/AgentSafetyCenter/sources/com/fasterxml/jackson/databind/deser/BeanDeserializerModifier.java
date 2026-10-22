package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import com.fasterxml.jackson.databind.type.ArrayType;
import com.fasterxml.jackson.databind.type.CollectionLikeType;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.MapLikeType;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.databind.type.ReferenceType;
import java.io.Serializable;
import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class BeanDeserializerModifier implements Serializable {
    private static final long serialVersionUID = 1;

    public JsonDeserializer<?> modifyDeserializer(DeserializationConfig deserializationConfig, BeanDescription beanDescription, JsonDeserializer<?> jsonDeserializer) {
        return jsonDeserializer;
    }

    public KeyDeserializer modifyKeyDeserializer(DeserializationConfig deserializationConfig, JavaType javaType, KeyDeserializer keyDeserializer) {
        return keyDeserializer;
    }

    public BeanDeserializerBuilder updateBuilder(DeserializationConfig deserializationConfig, BeanDescription beanDescription, BeanDeserializerBuilder beanDeserializerBuilder) {
        return beanDeserializerBuilder;
    }

    public List<BeanPropertyDefinition> updateProperties(DeserializationConfig deserializationConfig, BeanDescription beanDescription, List<BeanPropertyDefinition> list) {
        return list;
    }

    public JsonDeserializer<?> modifyArrayDeserializer(DeserializationConfig deserializationConfig, ArrayType arrayType, BeanDescription beanDescription, JsonDeserializer<?> jsonDeserializer) {
        return jsonDeserializer;
    }

    public JsonDeserializer<?> modifyCollectionDeserializer(DeserializationConfig deserializationConfig, CollectionType collectionType, BeanDescription beanDescription, JsonDeserializer<?> jsonDeserializer) {
        return jsonDeserializer;
    }

    public JsonDeserializer<?> modifyCollectionLikeDeserializer(DeserializationConfig deserializationConfig, CollectionLikeType collectionLikeType, BeanDescription beanDescription, JsonDeserializer<?> jsonDeserializer) {
        return jsonDeserializer;
    }

    public JsonDeserializer<?> modifyEnumDeserializer(DeserializationConfig deserializationConfig, JavaType javaType, BeanDescription beanDescription, JsonDeserializer<?> jsonDeserializer) {
        return jsonDeserializer;
    }

    public JsonDeserializer<?> modifyMapDeserializer(DeserializationConfig deserializationConfig, MapType mapType, BeanDescription beanDescription, JsonDeserializer<?> jsonDeserializer) {
        return jsonDeserializer;
    }

    public JsonDeserializer<?> modifyMapLikeDeserializer(DeserializationConfig deserializationConfig, MapLikeType mapLikeType, BeanDescription beanDescription, JsonDeserializer<?> jsonDeserializer) {
        return jsonDeserializer;
    }

    public JsonDeserializer<?> modifyReferenceDeserializer(DeserializationConfig deserializationConfig, ReferenceType referenceType, BeanDescription beanDescription, JsonDeserializer<?> jsonDeserializer) {
        return jsonDeserializer;
    }
}
