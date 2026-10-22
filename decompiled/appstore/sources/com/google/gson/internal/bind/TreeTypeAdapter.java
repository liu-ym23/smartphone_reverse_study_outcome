package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.C$Gson$Preconditions;
import com.google.gson.internal.Streams;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes3.dex */
public final class TreeTypeAdapter<T> extends TypeAdapter<T> {
    private final TreeTypeAdapter<T>.GsonContextImpl context;
    private TypeAdapter<T> delegate;
    private final JsonDeserializer<T> deserializer;
    final Gson gson;
    private final JsonSerializer<T> serializer;
    private final TypeAdapterFactory skipPast;
    private final TypeToken<T> typeToken;

    /* JADX INFO: renamed from: com.google.gson.internal.bind.TreeTypeAdapter$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public final class GsonContextImpl implements JsonSerializationContext, JsonDeserializationContext {
        final /* synthetic */ TreeTypeAdapter this$0;

        private GsonContextImpl(TreeTypeAdapter r10) {
            this.this$0 = r10;
        }

        @Override // com.google.gson.JsonDeserializationContext
        public <R> R deserialize(JsonElement r10, Type r11) throws JsonParseException {
            return (R) this.this$0.gson.fromJson(r10, r11);
        }

        @Override // com.google.gson.JsonSerializationContext
        public JsonElement serialize(Object r10) {
            return this.this$0.gson.toJsonTree(r10);
        }

        public /* synthetic */ GsonContextImpl(TreeTypeAdapter r10, AnonymousClass1 r11) {
            this(r10);
        }

        @Override // com.google.gson.JsonSerializationContext
        public JsonElement serialize(Object r10, Type r11) {
            return this.this$0.gson.toJsonTree(r10, r11);
        }
    }

    public static final class SingleTypeFactory implements TypeAdapterFactory {
        private final JsonDeserializer<?> deserializer;
        private final TypeToken<?> exactType;
        private final Class<?> hierarchyType;
        private final boolean matchRawType;
        private final JsonSerializer<?> serializer;

        public SingleTypeFactory(Object r10, TypeToken<?> r11, boolean r12, Class<?> r13) {
            JsonDeserializer<?> r14 = null;
            if ((r10 instanceof JsonSerializer) == false) goto L5;
            JsonSerializer<?> r15 = (JsonSerializer) r10;
        L6:
            this.serializer = r15;
            if ((r10 instanceof JsonDeserializer) == false) goto L9;
            r14 = (JsonDeserializer) r10;
        L9:
            this.deserializer = r14;
            if (r15 != null) goto L14;
            if (r14 != null) goto L14;
            boolean r16 = false;
        L15:
            C$Gson$Preconditions.checkArgument(r16);
            this.exactType = r11;
            this.matchRawType = r12;
            this.hierarchyType = r13;
            return;
        L14:
            r16 = true;
            goto L15
        L5:
            r15 = null;
            goto L6
        }

        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson r10, TypeToken<T> r11) {
            TypeToken<?> r12 = this.exactType;
            if (r12 != null) goto L5;
            boolean r13 = this.hierarchyType.isAssignableFrom(r11.getRawType());
        L14:
            if (r13 == true) goto L18;
            return null;
        L18:
            return new TreeTypeAdapter(this.serializer, this.deserializer, r10, r11, this);
        L5:
            if (r12.equals(r11) == false) goto L7;
        L12:
            r13 = true;
            goto L14
        L7:
            if (this.matchRawType == true) goto L9;
        L11:
            r13 = false;
            goto L14
        L9:
            if (this.exactType.getType() != r11.getRawType()) goto L11;
            goto L11
        }
    }

    public TreeTypeAdapter(JsonSerializer<T> r10, JsonDeserializer<T> r11, Gson r12, TypeToken<T> r13, TypeAdapterFactory r14) {
        this.context = new GsonContextImpl(this, null);
        this.serializer = r10;
        this.deserializer = r11;
        this.gson = r12;
        this.typeToken = r13;
        this.skipPast = r14;
    }

    private TypeAdapter<T> delegate() {
        TypeAdapter<T> r10 = this.delegate;
        if (r10 != null) goto L7;
        TypeAdapter<T> r11 = this.gson.getDelegateAdapter(this.skipPast, this.typeToken);
        this.delegate = r11;
        return r11;
    L7:
        return r10;
    }

    public static TypeAdapterFactory newFactory(TypeToken<?> r10, Object r11) {
        return new SingleTypeFactory(r11, r10, false, null);
    }

    public static TypeAdapterFactory newFactoryWithMatchRawType(TypeToken<?> r10, Object r11) {
        if (r10.getType() != r10.getRawType()) goto L5;
        boolean r12 = true;
    L7:
        return new SingleTypeFactory(r11, r10, r12, null);
    L5:
        r12 = false;
        goto L7
    }

    public static TypeAdapterFactory newTypeHierarchyFactory(Class<?> r10, Object r11) {
        return new SingleTypeFactory(r11, null, false, r10);
    }

    @Override // com.google.gson.TypeAdapter
    public T read(JsonReader r10) throws IOException {
        if (this.deserializer == null) goto L5;
        JsonElement r11 = Streams.parse(r10);
        if (r11.isJsonNull() == false) goto L11;
        return null;
    L11:
        return this.deserializer.deserialize(r11, this.typeToken.getType(), this.context);
    L5:
        return delegate().read(r10);
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter r10, T r11) throws IOException {
        JsonSerializer<T> r12 = this.serializer;
        if (r12 != null) goto L6;
        delegate().write(r10, r11);
        return;
    L6:
        if (r11 != null) goto L9;
        r10.nullValue();
        return;
    L9:
        Streams.write(r12.serialize(r11, this.typeToken.getType(), this.context), r10);
    }
}
