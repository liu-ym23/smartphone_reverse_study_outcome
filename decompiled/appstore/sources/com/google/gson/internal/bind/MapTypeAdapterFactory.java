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
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class MapTypeAdapterFactory implements TypeAdapterFactory {
    final boolean complexMapKeySerialization;
    private final ConstructorConstructor constructorConstructor;

    public final class Adapter<K, V> extends TypeAdapter<Map<K, V>> {
        private final ObjectConstructor<? extends Map<K, V>> constructor;
        private final TypeAdapter<K> keyTypeAdapter;
        final /* synthetic */ MapTypeAdapterFactory this$0;
        private final TypeAdapter<V> valueTypeAdapter;

        public Adapter(MapTypeAdapterFactory r10, Gson r11, Type r12, TypeAdapter<K> r13, Type r14, TypeAdapter<V> r15, ObjectConstructor<? extends Map<K, V>> r16) {
            this.this$0 = r10;
            this.keyTypeAdapter = new TypeAdapterRuntimeTypeWrapper(r11, r13, r12);
            this.valueTypeAdapter = new TypeAdapterRuntimeTypeWrapper(r11, r15, r14);
            this.constructor = r16;
        }

        private String keyToString(JsonElement r10) {
            if (r10.isJsonPrimitive() == false) goto L19;
            JsonPrimitive r11 = r10.getAsJsonPrimitive();
            if (r11.isNumber() == false) goto L9;
            return String.valueOf(r11.getAsNumber());
        L9:
            if (r11.isBoolean() == false) goto L13;
            return Boolean.toString(r11.getAsBoolean());
        L13:
            if (r11.isString() == false) goto L17;
            return r11.getAsString();
        L17:
            throw new AssertionError();
        L19:
            if (r10.isJsonNull() == false) goto L23;
            return "null";
        L23:
            throw new AssertionError();
        }

        @Override // com.google.gson.TypeAdapter
        public /* bridge */ /* synthetic */ Object read(JsonReader r10) throws IOException {
            return read(r10);
        }

        @Override // com.google.gson.TypeAdapter
        public /* bridge */ /* synthetic */ void write(JsonWriter r10, Object r11) throws IOException {
            write(r10, (Map) r11);
        }

        @Override // com.google.gson.TypeAdapter
        public Map<K, V> read(JsonReader r10) throws IOException {
            JsonToken r11 = r10.peek();
            if (r11 != JsonToken.NULL) goto L6;
            r10.nextNull();
            return null;
        L6:
            Map<K, V> r12 = this.constructor.construct();
            if (r11 != JsonToken.BEGIN_ARRAY) goto L17;
            r10.beginArray();
        L10:
            if (r10.hasNext() == false) goto L16;
            r10.beginArray();
            K r13 = this.keyTypeAdapter.read(r10);
            if (r12.put(r13, this.valueTypeAdapter.read(r10)) != null) goto L15;
            r10.endArray();
            goto L10
        L15:
            throw new JsonSyntaxException("duplicate key: " + r13);
        L16:
            r10.endArray();
        L26:
            return r12;
        L17:
            r10.beginObject();
        L19:
            if (r10.hasNext() == false) goto L25;
            JsonReaderInternalAccess.INSTANCE.promoteNameToValue(r10);
            K r14 = this.keyTypeAdapter.read(r10);
            if (r12.put(r14, this.valueTypeAdapter.read(r10)) == null) goto L19;
            throw new JsonSyntaxException("duplicate key: " + r14);
        L25:
            r10.endObject();
            goto L26
        }

        public void write(JsonWriter r10, Map<K, V> r11) throws IOException {
            if (r11 != null) goto L6;
            r10.nullValue();
            return;
        L6:
            if (this.this$0.complexMapKeySerialization == true) goto L13;
            r10.beginObject();
            Iterator<Map.Entry<K, V>> r12 = r11.entrySet().iterator();
        L9:
            if (r12.hasNext() == false) goto L11;
            Map.Entry<K, V> r13 = r12.next();
            r10.name(String.valueOf(r13.getKey()));
            this.valueTypeAdapter.write(r10, r13.getValue());
            goto L9
        L11:
            r10.endObject();
            return;
        L13:
            ArrayList r14 = new ArrayList(r11.size());
            ArrayList r15 = new ArrayList(r11.size());
            Iterator<Map.Entry<K, V>> r16 = r11.entrySet().iterator();
            int r17 = 0;
            boolean r18 = false;
        L15:
            if (r16.hasNext() == false) goto L24;
            Map.Entry<K, V> r19 = r16.next();
            JsonElement r20 = this.keyTypeAdapter.toJsonTree(r19.getKey());
            r14.add(r20);
            r15.add(r19.getValue());
            if (r20.isJsonArray() == false) goto L19;
        L22:
            boolean r21 = true;
        L23:
            r18 = r18 | r21;
            goto L15
        L19:
            if (r20.isJsonObject() == true) goto L22;
            r21 = false;
            goto L23
        L24:
            if (r18 == false) goto L29;
            r10.beginArray();
            int r22 = r14.size();
        L26:
            if (r17 >= r22) goto L28;
            r10.beginArray();
            Streams.write((JsonElement) r14.get(r17), r10);
            this.valueTypeAdapter.write(r10, (V) r15.get(r17));
            r10.endArray();
            r17 = r17 + 1;
            goto L26
        L28:
            r10.endArray();
            return;
        L29:
            r10.beginObject();
            int r23 = r14.size();
        L30:
            if (r17 >= r23) goto L32;
            r10.name(keyToString((JsonElement) r14.get(r17)));
            this.valueTypeAdapter.write(r10, (V) r15.get(r17));
            r17 = r17 + 1;
            goto L30
        L32:
            r10.endObject();
        }
    }

    public MapTypeAdapterFactory(ConstructorConstructor r10, boolean r11) {
        this.constructorConstructor = r10;
        this.complexMapKeySerialization = r11;
    }

    private TypeAdapter<?> getKeyAdapter(Gson r10, Type r11) {
        if (r11 == Boolean.TYPE) goto L9;
        if (r11 == Boolean.class) goto L9;
        return r10.getAdapter(TypeToken.get(r11));
    L9:
        return TypeAdapters.BOOLEAN_AS_STRING;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson r12, TypeToken<T> r13) {
        Type r10 = r13.getType();
        if (Map.class.isAssignableFrom(r13.getRawType()) == true) goto L6;
        return null;
    L6:
        Type[] r11 = C$Gson$Types.getMapKeyAndValueTypes(r10, C$Gson$Types.getRawType(r10));
        TypeAdapter<?> r14 = getKeyAdapter(r12, r11[0]);
        TypeAdapter<T> r15 = r12.getAdapter(TypeToken.get(r11[1]));
        ObjectConstructor<T> r16 = this.constructorConstructor.get(r13);
        return new Adapter(this, r12, r11[0], r14, r11[1], r15, r16);
    }
}
