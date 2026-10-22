package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.reflect.TypeToken;

/* JADX INFO: loaded from: classes3.dex */
public final class JsonAdapterAnnotationTypeAdapterFactory implements TypeAdapterFactory {
    private final ConstructorConstructor constructorConstructor;

    public JsonAdapterAnnotationTypeAdapterFactory(ConstructorConstructor r10) {
        this.constructorConstructor = r10;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson r10, TypeToken<T> r11) {
        JsonAdapter r12 = (JsonAdapter) r11.getRawType().getAnnotation(JsonAdapter.class);
        if (r12 != null) goto L7;
        return null;
    L7:
        return (TypeAdapter<T>) getTypeAdapter(this.constructorConstructor, r10, r11, r12);
    }

    public TypeAdapter<?> getTypeAdapter(ConstructorConstructor r10, Gson r11, TypeToken<?> r12, JsonAdapter r13) {
        Object r14 = r10.get(TypeToken.get(r13.value())).construct();
        if ((r14 instanceof TypeAdapter) == false) goto L6;
        TypeAdapter<?> r15 = (TypeAdapter) r14;
    L23:
        if (r15 != null) goto L25;
        return r15;
    L25:
        if (r13.nullSafe() == true) goto L27;
        return r15;
    L27:
        return r15.nullSafe();
    L6:
        if ((r14 instanceof TypeAdapterFactory) == false) goto L8;
        r15 = ((TypeAdapterFactory) r14).create(r11, r12);
        goto L23
    L8:
        boolean r16 = r14 instanceof JsonSerializer;
        if (r16 == false) goto L11;
    L15:
        JsonDeserializer r17 = null;
        if (r16 == false) goto L18;
        JsonSerializer r18 = (JsonSerializer) r14;
    L20:
        if ((r14 instanceof JsonDeserializer) == false) goto L22;
        r17 = (JsonDeserializer) r14;
    L22:
        r15 = new TreeTypeAdapter(r18, r17, r11, r12, null);
        goto L23
    L18:
        r18 = null;
        goto L20
    L11:
        if ((r14 instanceof JsonDeserializer) == true) goto L15;
        throw new IllegalArgumentException("Invalid attempt to bind an instance of " + r14.getClass().getName() + " as a @JsonAdapter for " + r12.toString() + ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
    }
}
