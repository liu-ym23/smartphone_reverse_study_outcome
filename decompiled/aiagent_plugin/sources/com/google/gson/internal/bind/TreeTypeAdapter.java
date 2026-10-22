package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.C$Gson$Preconditions;
import com.google.gson.internal.Streams;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes2.dex */
public final class TreeTypeAdapter<T> extends SerializationDelegatingTypeAdapter<T> {
    private final TreeTypeAdapter<T>.GsonContextImpl context;
    private volatile TypeAdapter<T> delegate;
    private final JsonDeserializer<T> deserializer;
    final Gson gson;
    private final boolean nullSafe;
    private final JsonSerializer<T> serializer;
    private final TypeAdapterFactory skipPast;
    private final TypeToken<T> typeToken;

    /* JADX INFO: renamed from: com.google.gson.internal.bind.TreeTypeAdapter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private final class GsonContextImpl implements JsonDeserializationContext, JsonSerializationContext {
        final /* synthetic */ TreeTypeAdapter this$0;

        private GsonContextImpl(TreeTypeAdapter r1) {
            this.this$0 = r1;
        }

        /* synthetic */ GsonContextImpl(TreeTypeAdapter r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.google.gson.JsonSerializationContext
        public JsonElement serialize(Object r1) {
            return this.this$0.gson.toJsonTree(r1);
        }

        @Override // com.google.gson.JsonSerializationContext
        public JsonElement serialize(Object r3, Type r4) {
            Type r5 = (Type) ZeusTransformUtils.wrapperContextForParams(r4, Type.class, "com.obric.aiagent.plugin");
            return this.this$0.gson.toJsonTree(r3, r5);
        }

        @Override // com.google.gson.JsonDeserializationContext
        public <R> R deserialize(JsonElement r3, Type r4) {
            Type r5 = (Type) ZeusTransformUtils.wrapperContextForParams(r4, Type.class, "com.obric.aiagent.plugin");
            return (R) this.this$0.gson.fromJson(r3, r5);
        }
    }

    private static final class SingleTypeFactory implements TypeAdapterFactory {
        private final JsonDeserializer<?> deserializer;
        private final TypeToken<?> exactType;
        private final Class<?> hierarchyType;
        private final boolean matchRawType;
        private final JsonSerializer<?> serializer;

        SingleTypeFactory(Object r5, TypeToken<?> r6, boolean r7, Class<?> r8) {
            JsonDeserializer<?> r2 = null;
            if (ZeusTransformUtils.instanceOf(r5, JsonSerializer.class) == false) goto L5;
            JsonSerializer<?> r0 = (JsonSerializer) ZeusTransformUtils.preCheckCast(r5, JsonSerializer.class, "com.obric.aiagent.plugin");
        L6:
            this.serializer = r0;
            if (ZeusTransformUtils.instanceOf(r5, JsonDeserializer.class) == false) goto L9;
            r2 = (JsonDeserializer) ZeusTransformUtils.preCheckCast(r5, JsonDeserializer.class, "com.obric.aiagent.plugin");
        L9:
            this.deserializer = r2;
            if (r0 != null) goto L14;
            if (r2 != null) goto L14;
            boolean r9 = false;
        L15:
            C$Gson$Preconditions.checkArgument(r9);
            this.exactType = r6;
            this.matchRawType = r7;
            this.hierarchyType = r8;
            return;
        L14:
            r9 = true;
            goto L15
        L5:
            r0 = null;
            goto L6
        }

        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson r8, TypeToken<T> r9) {
            TypeToken<?> r0 = this.exactType;
            if (r0 != null) goto L5;
            boolean r1 = this.hierarchyType.isAssignableFrom(r9.getRawType());
        L14:
            if (r1 == true) goto L18;
            return null;
        L18:
            return new TreeTypeAdapter(this.serializer, this.deserializer, r8, r9, this);
        L5:
            if (r0.equals(r9) == false) goto L7;
        L12:
            r1 = true;
            goto L14
        L7:
            if (this.matchRawType == true) goto L9;
        L11:
            r1 = false;
            goto L14
        L9:
            if (this.exactType.getType() != r9.getRawType()) goto L11;
            goto L11
        }
    }

    public TreeTypeAdapter(JsonSerializer<T> r3, JsonDeserializer<T> r4, Gson r5, TypeToken<T> r6, TypeAdapterFactory r7, boolean r8) {
        JsonSerializer<T> r9 = (JsonSerializer) ZeusTransformUtils.wrapperContextForParams(r3, JsonSerializer.class, "com.obric.aiagent.plugin");
        JsonDeserializer<T> r10 = (JsonDeserializer) ZeusTransformUtils.wrapperContextForParams(r4, JsonDeserializer.class, "com.obric.aiagent.plugin");
        TypeAdapterFactory r11 = (TypeAdapterFactory) ZeusTransformUtils.wrapperContextForParams(r7, TypeAdapterFactory.class, "com.obric.aiagent.plugin");
        this.context = new GsonContextImpl(this, null);
        this.serializer = r9;
        this.deserializer = r10;
        this.gson = r5;
        this.typeToken = r6;
        this.skipPast = r11;
        this.nullSafe = r8;
    }

    public TreeTypeAdapter(JsonSerializer<T> r10, JsonDeserializer<T> r11, Gson r12, TypeToken<T> r13, TypeAdapterFactory r14) {
        this((JsonSerializer) ZeusTransformUtils.wrapperContextForParams(r10, JsonSerializer.class, "com.obric.aiagent.plugin"), (JsonDeserializer) ZeusTransformUtils.wrapperContextForParams(r11, JsonDeserializer.class, "com.obric.aiagent.plugin"), r12, r13, (TypeAdapterFactory) ZeusTransformUtils.wrapperContextForParams(r14, TypeAdapterFactory.class, "com.obric.aiagent.plugin"), true);
    }

    @Override // com.google.gson.TypeAdapter
    public T read(JsonReader r3) {
        if (this.deserializer == null) goto L5;
        JsonElement r4 = Streams.parse(r3);
        if (this.nullSafe == false) goto L13;
        if (r4.isJsonNull() == false) goto L13;
        return null;
    L13:
        return this.deserializer.deserialize(r4, this.typeToken.getType(), this.context);
    L5:
        return delegate().read(r3);
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter r3, T r4) {
        JsonSerializer<T> r0 = this.serializer;
        if (r0 != null) goto L7;
        delegate().write(r3, r4);
        return;
    L7:
        if (this.nullSafe == false) goto L11;
        if (r4 != null) goto L11;
        r3.nullValue();
        return;
    L11:
        Streams.write(r0.serialize(r4, this.typeToken.getType(), this.context), r3);
    }

    private TypeAdapter<T> delegate() {
        TypeAdapter<T> r0 = this.delegate;
        if (r0 != null) goto L7;
        TypeAdapter<T> r1 = this.gson.getDelegateAdapter(this.skipPast, this.typeToken);
        this.delegate = r1;
        return r1;
    L7:
        return r0;
    }

    @Override // com.google.gson.internal.bind.SerializationDelegatingTypeAdapter
    public TypeAdapter<T> getSerializationDelegate() {
        if (this.serializer == null) goto L6;
        return this;
    L6:
        return delegate();
    }

    public static TypeAdapterFactory newFactory(TypeToken<?> r3, Object r4) {
        return new SingleTypeFactory(r4, r3, false, null);
    }

    public static TypeAdapterFactory newFactoryWithMatchRawType(TypeToken<?> r3, Object r4) {
        if (r3.getType() != r3.getRawType()) goto L5;
        boolean r0 = true;
    L7:
        return new SingleTypeFactory(r4, r3, r0, null);
    L5:
        r0 = false;
        goto L7
    }

    public static TypeAdapterFactory newTypeHierarchyFactory(Class<?> r3, Object r4) {
        return new SingleTypeFactory(r4, null, false, r3);
    }
}
