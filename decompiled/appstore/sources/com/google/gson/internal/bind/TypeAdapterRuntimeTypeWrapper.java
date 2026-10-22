package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* JADX INFO: loaded from: classes3.dex */
final class TypeAdapterRuntimeTypeWrapper<T> extends TypeAdapter<T> {
    private final Gson context;
    private final TypeAdapter<T> delegate;
    private final Type type;

    public TypeAdapterRuntimeTypeWrapper(Gson r10, TypeAdapter<T> r11, Type r12) {
        this.context = r10;
        this.delegate = r11;
        this.type = r12;
    }

    private Type getRuntimeTypeIfMoreSpecific(Type r10, Object r11) {
        if (r11 != null) goto L4;
        return r10;
    L4:
        if (r10 == Object.class) goto L10;
        if ((r10 instanceof TypeVariable) == true) goto L10;
        if ((r10 instanceof Class) == true) goto L10;
        return r10;
    L10:
        return r11.getClass();
    }

    @Override // com.google.gson.TypeAdapter
    public T read(JsonReader r10) throws IOException {
        return this.delegate.read(r10);
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter r10, T r11) throws IOException {
        TypeAdapter<T> r12 = this.delegate;
        Type r13 = getRuntimeTypeIfMoreSpecific(this.type, r11);
        if (r13 == this.type) goto L10;
        r12 = this.context.getAdapter(TypeToken.get(r13));
        if ((r12 instanceof ReflectiveTypeAdapterFactory.Adapter) == false) goto L10;
        TypeAdapter<T> r14 = this.delegate;
        if ((r14 instanceof ReflectiveTypeAdapterFactory.Adapter) == true) goto L10;
        r12 = r14;
    L10:
        r12.write(r10, r11);
    }
}
