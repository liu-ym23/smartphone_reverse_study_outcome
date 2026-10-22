package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* JADX INFO: loaded from: classes2.dex */
final class TypeAdapterRuntimeTypeWrapper<T> extends TypeAdapter<T> {
    private final Gson context;
    private final TypeAdapter<T> delegate;
    private final Type type;

    TypeAdapterRuntimeTypeWrapper(Gson r3, TypeAdapter<T> r4, Type r5) {
        Type r6 = (Type) ZeusTransformUtils.wrapperContextForParams(r5, Type.class, "com.obric.aiagent.plugin");
        this.context = r3;
        this.delegate = r4;
        this.type = r6;
    }

    @Override // com.google.gson.TypeAdapter
    public T read(JsonReader r1) {
        return this.delegate.read(r1);
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter r4, T r5) {
        TypeAdapter<T> r0 = this.delegate;
        Type r1 = getRuntimeTypeIfMoreSpecific(this.type, r5);
        if (r1 == this.type) goto L10;
        r0 = this.context.getAdapter(TypeToken.get(r1));
        if (ZeusTransformUtils.instanceOf(r0, ReflectiveTypeAdapterFactory.Adapter.class) == false) goto L10;
        if (isReflective(this.delegate) == true) goto L10;
        r0 = this.delegate;
    L10:
        r0.write(r4, r5);
    }

    private static boolean isReflective(TypeAdapter<?> r2) {
    L3:
        if (ZeusTransformUtils.instanceOf(r2, SerializationDelegatingTypeAdapter.class) == false) goto L9;
        TypeAdapter<?> r0 = ((SerializationDelegatingTypeAdapter) ZeusTransformUtils.preCheckCast(r2, SerializationDelegatingTypeAdapter.class, "com.obric.aiagent.plugin")).getSerializationDelegate();
        if (r0 == r2) goto L9;
        r2 = r0;
    L9:
        return ZeusTransformUtils.instanceOf(r2, ReflectiveTypeAdapterFactory.Adapter.class);
    }

    private static Type getRuntimeTypeIfMoreSpecific(Type r2, Object r3) {
        Type r4 = (Type) ZeusTransformUtils.wrapperContextForParams(r2, Type.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L5;
        return r4;
    L5:
        if (ZeusTransformUtils.instanceOf(r4, Class.class) == true) goto L9;
        if (ZeusTransformUtils.instanceOf(r4, TypeVariable.class) == true) goto L9;
        return r4;
    L9:
        return r3.getClass();
    }
}
