package com.google.gson;

import com.google.gson.internal.bind.TypeAdapters;

/* loaded from: classes2.dex */
public enum LongSerializationPolicy {
    DEFAULT { // from class: com.google.gson.LongSerializationPolicy.1
        @Override // com.google.gson.LongSerializationPolicy
        public JsonElement serialize(Long l10) {
            return l10 == null ? JsonNull.INSTANCE : new JsonPrimitive(l10);
        }

        @Override // com.google.gson.LongSerializationPolicy
        public TypeAdapter<Number> typeAdapter() {
            return TypeAdapters.LONG;
        }
    },
    STRING { // from class: com.google.gson.LongSerializationPolicy.2
        @Override // com.google.gson.LongSerializationPolicy
        public JsonElement serialize(Long l10) {
            return l10 == null ? JsonNull.INSTANCE : new JsonPrimitive(l10.toString());
        }

        @Override // com.google.gson.LongSerializationPolicy
        public TypeAdapter<Number> typeAdapter() {
            return TypeAdapters.LONG_AS_STRING;
        }
    };

    public abstract JsonElement serialize(Long l10);

    public abstract TypeAdapter<Number> typeAdapter();
}
