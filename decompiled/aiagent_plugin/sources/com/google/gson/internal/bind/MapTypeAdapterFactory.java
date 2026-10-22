package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.JsonReaderInternalAccess;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.internal.Streams;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class MapTypeAdapterFactory implements TypeAdapterFactory {
    final boolean complexMapKeySerialization;
    private final ConstructorConstructor constructorConstructor;

    private final class Adapter<K, V> extends TypeAdapter<Map<K, V>> {
        private final ObjectConstructor<? extends Map<K, V>> constructor;
        private final TypeAdapter<K> keyTypeAdapter;
        final /* synthetic */ MapTypeAdapterFactory this$0;
        private final TypeAdapter<V> valueTypeAdapter;

        @Override // com.google.gson.TypeAdapter
        public /* bridge */ /* synthetic */ Object read(JsonReader r1) {
            return read(r1);
        }

        @Override // com.google.gson.TypeAdapter
        public /* synthetic */ void write(JsonWriter r3, Object r4) {
            write(r3, (Map) ZeusTransformUtils.preCheckCast(r4, Map.class, "com.obric.aiagent.plugin"));
        }

        public Adapter(MapTypeAdapterFactory r3, Gson r4, Type r5, TypeAdapter<K> r6, Type r7, TypeAdapter<V> r8, ObjectConstructor<? extends Map<K, V>> r9) {
            Type r10 = (Type) ZeusTransformUtils.wrapperContextForParams(r5, Type.class, "com.obric.aiagent.plugin");
            Type r11 = (Type) ZeusTransformUtils.wrapperContextForParams(r7, Type.class, "com.obric.aiagent.plugin");
            ObjectConstructor<? extends Map<K, V>> r12 = (ObjectConstructor) ZeusTransformUtils.wrapperContextForParams(r9, ObjectConstructor.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            this.keyTypeAdapter = new TypeAdapterRuntimeTypeWrapper(r4, r6, r10);
            this.valueTypeAdapter = new TypeAdapterRuntimeTypeWrapper(r4, r8, r11);
            this.constructor = r12;
        }

        @Override // com.google.gson.TypeAdapter
        public Map<K, V> read(JsonReader r5) {
            JsonToken r0 = r5.peek();
            if (r0 != JsonToken.NULL) goto L6;
            r5.nextNull();
            return null;
        L6:
            Map<K, V> r1 = (Map) ZeusTransformUtils.preCheckCast(this.constructor.construct(), Map.class, "com.obric.aiagent.plugin");
            if (r0 != JsonToken.BEGIN_ARRAY) goto L17;
            r5.beginArray();
        L10:
            if (r5.hasNext() == false) goto L16;
            r5.beginArray();
            K r2 = this.keyTypeAdapter.read(r5);
            if (r1.put(r2, this.valueTypeAdapter.read(r5)) != null) goto L15;
            r5.endArray();
            goto L10
        L15:
            throw new JsonSyntaxException("duplicate key: " + r2);
        L16:
            r5.endArray();
        L26:
            return r1;
        L17:
            r5.beginObject();
        L19:
            if (r5.hasNext() == false) goto L25;
            JsonReaderInternalAccess.INSTANCE.promoteNameToValue(r5);
            K r3 = this.keyTypeAdapter.read(r5);
            if (r1.put(r3, this.valueTypeAdapter.read(r5)) == null) goto L19;
            throw new JsonSyntaxException("duplicate key: " + r3);
        L25:
            r5.endObject();
            goto L26
        }

        public void write(JsonWriter r9, Map<K, V> r10) {
            Map r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.aiagent.plugin");
            if (r11 != null) goto L7;
            r9.nullValue();
            return;
        L7:
            if (this.this$0.complexMapKeySerialization == true) goto L14;
            r9.beginObject();
            Iterator<Map.Entry<K, V>> r12 = r11.entrySet().iterator();
        L10:
            if (r12.hasNext() == false) goto L12;
            Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r12.next(), Map.Entry.class, "com.obric.aiagent.plugin");
            r9.name(String.valueOf(r0.getKey()));
            this.valueTypeAdapter.write(r9, (V) r0.getValue());
            goto L10
        L12:
            r9.endObject();
            return;
        L14:
            ArrayList r1 = new ArrayList(r11.size());
            ArrayList r2 = new ArrayList(r11.size());
            Iterator<Map.Entry<K, V>> r13 = r11.entrySet().iterator();
            int r3 = 0;
            boolean r4 = false;
        L16:
            if (r13.hasNext() == false) goto L25;
            Map.Entry r5 = (Map.Entry) ZeusTransformUtils.preCheckCast(r13.next(), Map.Entry.class, "com.obric.aiagent.plugin");
            JsonElement r6 = this.keyTypeAdapter.toJsonTree((K) r5.getKey());
            r1.add(r6);
            r2.add(r5.getValue());
            if (r6.isJsonArray() == false) goto L20;
        L23:
            boolean r7 = true;
        L24:
            r4 = r4 | r7;
            goto L16
        L20:
            if (r6.isJsonObject() == true) goto L23;
            r7 = false;
            goto L24
        L25:
            if (r4 == false) goto L30;
            r9.beginArray();
            int r14 = r1.size();
        L27:
            if (r3 >= r14) goto L29;
            r9.beginArray();
            Streams.write((JsonElement) ZeusTransformUtils.preCheckCast(r1.get(r3), JsonElement.class, "com.obric.aiagent.plugin"), r9);
            this.valueTypeAdapter.write(r9, (V) r2.get(r3));
            r9.endArray();
            r3 = r3 + 1;
            goto L27
        L29:
            r9.endArray();
            return;
        L30:
            r9.beginObject();
            int r15 = r1.size();
        L31:
            if (r3 >= r15) goto L33;
            r9.name(keyToString((JsonElement) ZeusTransformUtils.preCheckCast(r1.get(r3), JsonElement.class, "com.obric.aiagent.plugin")));
            this.valueTypeAdapter.write(r9, (V) r2.get(r3));
            r3 = r3 + 1;
            goto L31
        L33:
            r9.endObject();
        }

        private String keyToString(JsonElement r1) {
            if (r1.isJsonPrimitive() == false) goto L19;
            JsonPrimitive r0 = r1.getAsJsonPrimitive();
            if (r0.isNumber() == false) goto L9;
            return String.valueOf(r0.getAsNumber());
        L9:
            if (r0.isBoolean() == false) goto L13;
            return Boolean.toString(r0.getAsBoolean());
        L13:
            if (r0.isString() == false) goto L17;
            return r0.getAsString();
        L17:
            throw new AssertionError();
        L19:
            if (r1.isJsonNull() == false) goto L23;
            return "null";
        L23:
            throw new AssertionError();
        }
    }

    public MapTypeAdapterFactory(ConstructorConstructor r1, boolean r2) {
        this.constructorConstructor = r1;
        this.complexMapKeySerialization = r2;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson r12, TypeToken<T> r13) {
        Type r0 = r13.getType();
        Class<? super T> r1 = r13.getRawType();
        if (Map.class.isAssignableFrom(r1) == true) goto L6;
        return null;
    L6:
        Type[] r2 = C$Gson$Types.getMapKeyAndValueTypes(r0, r1);
        TypeAdapter<?> r7 = getKeyAdapter(r12, r2[0]);
        TypeAdapter<T> r9 = r12.getAdapter(TypeToken.get(r2[1]));
        ObjectConstructor<T> r10 = this.constructorConstructor.get(r13);
        return new Adapter(this, r12, r2[0], r7, r2[1], r9, r10);
    }

    private TypeAdapter<?> getKeyAdapter(Gson r2, Type r3) {
        Type r1 = (Type) ZeusTransformUtils.wrapperContextForParams(r3, Type.class, "com.obric.aiagent.plugin");
        if (r1 == Boolean.TYPE) goto L9;
        if (r1 == Boolean.class) goto L9;
        return r2.getAdapter(TypeToken.get(r1));
    L9:
        return TypeAdapters.BOOLEAN_AS_STRING;
    }
}
