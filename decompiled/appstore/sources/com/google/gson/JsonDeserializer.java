package com.google.gson;

import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes3.dex */
public interface JsonDeserializer<T> {
    T deserialize(JsonElement r10, Type r11, JsonDeserializationContext r12) throws JsonParseException;
}
