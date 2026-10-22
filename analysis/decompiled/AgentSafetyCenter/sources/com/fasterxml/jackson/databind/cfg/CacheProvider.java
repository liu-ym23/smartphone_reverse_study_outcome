package com.fasterxml.jackson.databind.cfg;

import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.util.LookupCache;
import com.fasterxml.jackson.databind.util.TypeKey;
import java.io.Serializable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public interface CacheProvider extends Serializable {
    LookupCache<JavaType, JsonDeserializer<Object>> forDeserializerCache(DeserializationConfig deserializationConfig);

    LookupCache<TypeKey, JsonSerializer<Object>> forSerializerCache(SerializationConfig serializationConfig);

    LookupCache<Object, JavaType> forTypeFactory();
}
