package com.google.gson.internal.bind;

import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.internal.Primitives;
import com.google.gson.internal.reflect.ReflectionAccessor;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class ReflectiveTypeAdapterFactory implements TypeAdapterFactory {
    private final ReflectionAccessor accessor;
    private final ConstructorConstructor constructorConstructor;
    private final Excluder excluder;
    private final FieldNamingStrategy fieldNamingPolicy;
    private final JsonAdapterAnnotationTypeAdapterFactory jsonAdapterFactory;

    public static final class Adapter<T> extends TypeAdapter<T> {
        private final Map<String, BoundField> boundFields;
        private final ObjectConstructor<T> constructor;

        public Adapter(ObjectConstructor<T> r10, Map<String, BoundField> r11) {
            this.constructor = r10;
            this.boundFields = r11;
        }

        @Override // com.google.gson.TypeAdapter
        public T read(JsonReader r10) throws IOException {
            if (r10.peek() != JsonToken.NULL) goto L6;
            r10.nextNull();
            return null;
        L6:
            T r11 = this.constructor.construct();
            r10.beginObject();     // Catch: IllegalAccessException -> L16 IllegalStateException -> L18
        L8:
            if (r10.hasNext() == false) goto L22;
            String r12 = r10.nextName();     // Catch: IllegalAccessException -> L16 IllegalStateException -> L18
            BoundField r13 = this.boundFields.get(r12);     // Catch: IllegalAccessException -> L16 IllegalStateException -> L18
            if (r13 == null) goto L20;
            if (r13.deserialized == false) goto L20;
            r13.read(r10, r11);     // Catch: IllegalAccessException -> L16 IllegalStateException -> L18
        L20:
            r10.skipValue();     // Catch: IllegalAccessException -> L16 IllegalStateException -> L18
            goto L8
        L22:
            r10.endObject();
            return r11;
        L16:
            e = move-exception;
            throw new AssertionError(e);
        L18:
            e = move-exception;
            throw new JsonSyntaxException(e);
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter r10, T r11) throws IOException {
            if (r11 != null) goto L5;
            r10.nullValue();
            return;
        L5:
            r10.beginObject();
            Iterator<BoundField> r12 = this.boundFields.values().iterator();     // Catch: IllegalAccessException -> L13
        L8:
            if (r12.hasNext() == false) goto L15;
            BoundField r13 = r12.next();     // Catch: IllegalAccessException -> L13
            if (r13.writeField(r11) == false) goto L8;
            r10.name(r13.name);     // Catch: IllegalAccessException -> L13
            r13.write(r10, r11);     // Catch: IllegalAccessException -> L13
            goto L8
        L15:
            r10.endObject();
            return;
        L13:
            e = move-exception;
            throw new AssertionError(e);
        }
    }

    public static abstract class BoundField {
        final boolean deserialized;
        final String name;
        final boolean serialized;

        public BoundField(String r10, boolean r11, boolean r12) {
            this.name = r10;
            this.serialized = r11;
            this.deserialized = r12;
        }

        public abstract void read(JsonReader r10, Object r11) throws IOException, IllegalAccessException;

        public abstract void write(JsonWriter r10, Object r11) throws IOException, IllegalAccessException;

        public abstract boolean writeField(Object r10) throws IOException, IllegalAccessException;
    }

    public ReflectiveTypeAdapterFactory(ConstructorConstructor r10, FieldNamingStrategy r11, Excluder r12, JsonAdapterAnnotationTypeAdapterFactory r13) {
        this.accessor = ReflectionAccessor.getInstance();
        this.constructorConstructor = r10;
        this.fieldNamingPolicy = r11;
        this.excluder = r12;
        this.jsonAdapterFactory = r13;
    }

    private BoundField createBoundField(final Gson r13, final Field r14, final String r15, final TypeToken<?> r16, final boolean r17, final boolean r18) {
        final boolean r10 = Primitives.isPrimitive(r16.getRawType());
        JsonAdapter r11 = (JsonAdapter) r14.getAnnotation(JsonAdapter.class);
        if (r11 == null) goto L5;
        TypeAdapter<?> r12 = this.jsonAdapterFactory.getTypeAdapter(this.constructorConstructor, r13, r16, r11);
    L6:
        if (r12 == null) goto L9;
        boolean r19 = true;
    L8:
        final boolean r20 = r19;
        if (r12 != null) goto L12;
        r12 = r13.getAdapter(r16);
    L12:
        final TypeAdapter<?> r21 = r12;
        return new AnonymousClass1(this, r15, r17, r18, r14, r20, r21, r13, r16, r10);
    L9:
        r19 = false;
        goto L8
    L5:
        r12 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r20v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7 */
    private Map<String, BoundField> getBoundFields(Gson r24, TypeToken<?> r25, Class<?> r26) {
        LinkedHashMap r10 = new LinkedHashMap();
        if (r26.isInterface() == false) goto L5;
        return r10;
    L5:
        Type r11 = r25.getType();
        TypeToken<?> r12 = r25;
        Class<?> r13 = r26;
    L7:
        if (r13 == Object.class) goto L31;
        Field[] r14 = r13.getDeclaredFields();
        int r15 = r14.length;
        boolean r16 = false;
        int r17 = 0;
    L9:
        if (r17 >= r15) goto L30;
        Field r18 = r14[r17];
        boolean r19 = excludeField(r18, true);
        boolean r110 = excludeField(r18, r16);
        if (r19 == true) goto L14;
        if (r110 == true) goto L14;
    L27:
        r17 = r17 + 1;
        r16 = false;
    L14:
        this.accessor.makeAccessible(r18);
        Type r111 = C$Gson$Types.resolve(r12.getType(), r13, r18.getGenericType());
        List<String> r20 = getFieldNames(r18);
        int r21 = r20.size();
        BoundField r22 = null;
        ?? r23 = r16;
    L15:
        if (r23 >= r21) goto L25;
        String r27 = r20.get(r23);
        if (r23 == 0) goto L19;
        boolean r112 = r16;
    L20:
        ?? r28 = r23;
        BoundField r113 = r22;
        int r29 = r21;
        List<String> r114 = r20;
        Field r210 = r18;
        BoundField r30 = (BoundField) r10.put(r27, createBoundField(r24, r18, r27, TypeToken.get(r111), r112, r110));
        if (r113 != null) goto L23;
        r22 = r30;
    L24:
        r19 = r112;
        r20 = r114;
        r21 = r29;
        r18 = r210;
        r16 = false;
        r23 = (r28 == true ? 1 : 0) + 1;
        goto L15
    L23:
        r22 = r113;
        goto L24
    L19:
        r112 = r19;
        goto L20
    L25:
        BoundField r115 = r22;
        if (r115 == null) goto L27;
        throw new IllegalArgumentException(r11 + " declares multiple JSON fields named " + r115.name);
    L30:
        r12 = TypeToken.get(C$Gson$Types.resolve(r12.getType(), r13, r13.getGenericSuperclass()));
        r13 = r12.getRawType();
        goto L7
    L31:
        return r10;
    }

    private List<String> getFieldNames(Field r10) {
        SerializedName r11 = (SerializedName) r10.getAnnotation(SerializedName.class);
        if (r11 == null) goto L5;
        String r12 = r11.value();
        String[] r13 = r11.alternate();
        if (r13.length == 0) goto L9;
        ArrayList r14 = new ArrayList(r13.length + 1);
        r14.add(r12);
        int r15 = r13.length;
        int r16 = 0;
    L11:
        if (r16 >= r15) goto L13;
        r14.add(r13[r16]);
        r16 = r16 + 1;
        goto L11
    L13:
        return r14;
    L9:
        return Collections.singletonList(r12);
    L5:
        return Collections.singletonList(this.fieldNamingPolicy.translateName(r10));
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson r10, TypeToken<T> r11) {
        Class<? super T> r12 = r11.getRawType();
        if (Object.class.isAssignableFrom(r12) == true) goto L7;
        return null;
    L7:
        return new Adapter(this.constructorConstructor.get(r11), getBoundFields(r10, r11, r12));
    }

    public boolean excludeField(Field r10, boolean r11) {
        return excludeField(r10, r11, this.excluder);
    }

    public static boolean excludeField(Field r10, boolean r11, Excluder r12) {
        if (r12.excludeClass(r10.getType(), r11) == false) goto L5;
    L7:
        return false;
    L5:
        if (r12.excludeField(r10, r11) == true) goto L7;
        return true;
    }
}
