package com.google.gson.internal.bind;

import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.ReflectionAccessFilter;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.internal.Primitives;
import com.google.gson.internal.ReflectionAccessFilterHelper;
import com.google.gson.internal.TroubleshootingGuide;
import com.google.gson.internal.reflect.ReflectionHelper;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class ReflectiveTypeAdapterFactory implements TypeAdapterFactory {
    private final ConstructorConstructor constructorConstructor;
    private final Excluder excluder;
    private final FieldNamingStrategy fieldNamingPolicy;
    private final JsonAdapterAnnotationTypeAdapterFactory jsonAdapterFactory;
    private final List<ReflectionAccessFilter> reflectionFilters;

    public static abstract class Adapter<T, A> extends TypeAdapter<T> {
        private final FieldsData fieldsData;

        abstract A createAccumulator();

        abstract T finalize(A r1);

        abstract void readField(A r1, JsonReader r2, BoundField r3) throws IllegalAccessException, IOException;

        Adapter(FieldsData r1) {
            this.fieldsData = r1;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter r2, T r3) throws IOException {
            if (r3 != null) goto L5;
            r2.nullValue();
            return;
        L5:
            r2.beginObject();
            Iterator<BoundField> r1 = this.fieldsData.serializedFields.iterator();     // Catch: IllegalAccessException -> L13
        L8:
            if (r1.hasNext() == false) goto L11;
            r1.next().write(r2, r3);     // Catch: IllegalAccessException -> L13
            goto L8
        L11:
            r2.endObject();
            return;
        L13:
            e = move-exception;
            throw ReflectionHelper.createExceptionForUnexpectedIllegalAccess(e);
        }

        @Override // com.google.gson.TypeAdapter
        public T read(JsonReader r4) throws IOException {
            if (r4.peek() != JsonToken.NULL) goto L6;
            r4.nextNull();
            return null;
        L6:
            A r0 = createAccumulator();
            Map<String, BoundField> r1 = this.fieldsData.deserializedFields;
            r4.beginObject();     // Catch: IllegalAccessException -> L17 IllegalStateException -> L20
        L8:
            if (r4.hasNext() == false) goto L15;
            BoundField r2 = r1.get(r4.nextName());     // Catch: IllegalAccessException -> L17 IllegalStateException -> L20
            if (r2 == null) goto L12;
            readField(r0, r4, r2);     // Catch: IllegalAccessException -> L17 IllegalStateException -> L20
            goto L8
        L12:
            r4.skipValue();     // Catch: IllegalAccessException -> L17 IllegalStateException -> L20
            goto L8
        L15:
            r4.endObject();
            return finalize(r0);
        L17:
            e = move-exception;
            throw ReflectionHelper.createExceptionForUnexpectedIllegalAccess(e);
        L20:
            e = move-exception;
            throw new JsonSyntaxException(e);
        }
    }

    static abstract class BoundField {
        final Field field;
        final String fieldName;
        final String serializedName;

        abstract void readIntoArray(JsonReader r1, int r2, Object[] r3) throws IOException, JsonParseException;

        abstract void readIntoField(JsonReader r1, Object r2) throws IOException, IllegalAccessException;

        abstract void write(JsonWriter r1, Object r2) throws IOException, IllegalAccessException;

        protected BoundField(String r1, Field r2) {
            this.serializedName = r1;
            this.field = r2;
            this.fieldName = r2.getName();
        }
    }

    private static final class FieldReflectionAdapter<T> extends Adapter<T, T> {
        private final ObjectConstructor<T> constructor;

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        T finalize(T r1) {
            return r1;
        }

        FieldReflectionAdapter(ObjectConstructor<T> r1, FieldsData r2) {
            super(r2);
            this.constructor = r1;
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        T createAccumulator() {
            return this.constructor.construct();
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        void readField(T r1, JsonReader r2, BoundField r3) throws IllegalAccessException, IOException {
            r3.readIntoField(r2, r1);
        }
    }

    private static class FieldsData {
        public static final FieldsData EMPTY = null;
        public final Map<String, BoundField> deserializedFields;
        public final List<BoundField> serializedFields;

        static {
            EMPTY = new FieldsData(Collections.emptyMap(), Collections.emptyList());
        }

        public FieldsData(Map<String, BoundField> r1, List<BoundField> r2) {
            this.deserializedFields = r1;
            this.serializedFields = r2;
        }
    }

    private static final class RecordAdapter<T> extends Adapter<T, Object[]> {
        static final Map<Class<?>, Object> PRIMITIVE_DEFAULTS = null;
        private final Map<String, Integer> componentIndices;
        private final Constructor<T> constructor;
        private final Object[] constructorArgsDefaults;

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        /* bridge */ /* synthetic */ Object[] createAccumulator() {
            return createAccumulator2();
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        /* bridge */ /* synthetic */ Object finalize(Object[] r1) {
            return finalize2(r1);
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        /* bridge */ /* synthetic */ void readField(Object[] r1, JsonReader r2, BoundField r3) throws IllegalAccessException, IOException {
            readField2(r1, r2, r3);
        }

        static {
            PRIMITIVE_DEFAULTS = primitiveDefaults();
        }

        RecordAdapter(Class<T> r4, FieldsData r5, boolean r6) {
            super(r5);
            this.componentIndices = new HashMap();
            Constructor<T> r7 = ReflectionHelper.getCanonicalRecordConstructor(r4);
            this.constructor = r7;
            if (r6 == false) goto L5;
            ReflectiveTypeAdapterFactory.access$000(null, r7);
        L6:
            String[] r8 = ReflectionHelper.getRecordComponentNames(r4);
            int r9 = 0;
            int r10 = 0;
        L8:
            if (r10 >= r8.length) goto L10;
            this.componentIndices.put(r8[r10], Integer.valueOf(r10));
            r10 = r10 + 1;
            goto L8
        L10:
            Class<?>[] r11 = this.constructor.getParameterTypes();
            this.constructorArgsDefaults = new Object[r11.length];
        L12:
            if (r9 >= r11.length) goto L14;
            this.constructorArgsDefaults[r9] = PRIMITIVE_DEFAULTS.get(r11[r9]);
            r9 = r9 + 1;
            goto L12
        L14:
            return;
        L5:
            ReflectionHelper.makeAccessible(r7);
            goto L6
        }

        private static Map<Class<?>, Object> primitiveDefaults() {
            HashMap r0 = new HashMap();
            r0.put(Byte.TYPE, (byte) 0);
            r0.put(Short.TYPE, (short) 0);
            r0.put(Integer.TYPE, 0);
            r0.put(Long.TYPE, 0L);
            r0.put(Float.TYPE, Float.valueOf(0.0f));
            r0.put(Double.TYPE, Double.valueOf(0.0d));
            r0.put(Character.TYPE, (char) 0);
            r0.put(Boolean.TYPE, false);
            return r0;
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        /* JADX INFO: renamed from: createAccumulator, reason: avoid collision after fix types in other method */
        Object[] createAccumulator2() {
            return (Object[]) this.constructorArgsDefaults.clone();
        }

        /* JADX INFO: renamed from: readField, reason: avoid collision after fix types in other method */
        void readField2(Object[] r3, JsonReader r4, BoundField r5) throws IOException {
            Integer r0 = this.componentIndices.get(r5.fieldName);
            if (r0 == null) goto L7;
            r5.readIntoArray(r4, r0.intValue(), r3);
            return;
        L7:
            throw new IllegalStateException("Could not find the index in the constructor '" + ReflectionHelper.constructorToString(this.constructor) + "' for field with name '" + r5.fieldName + "', unable to determine which argument in the constructor the field corresponds to. This is unexpected behavior, as we expect the RecordComponents to have the same names as the fields in the Java class, and that the order of the RecordComponents is the same as the order of the canonical constructor parameters.");
        }

        /* JADX INFO: renamed from: finalize, reason: avoid collision after fix types in other method */
        T finalize2(Object[] r6) {
            return this.constructor.newInstance(r6);
        L11:
            e = move-exception;
            throw ReflectionHelper.createExceptionForUnexpectedIllegalAccess(e);
        L8:
            e = move-exception;
            throw new RuntimeException("Failed to invoke constructor '" + ReflectionHelper.constructorToString(this.constructor) + "' with args " + Arrays.toString(r6), e);
        L5:
            e = move-exception;
            throw new RuntimeException("Failed to invoke constructor '" + ReflectionHelper.constructorToString(this.constructor) + "' with args " + Arrays.toString(r6), e.getCause());
        }
    }

    static /* synthetic */ void access$000(Object r0, AccessibleObject r1) {
        checkAccessible(r0, r1);
    }

    public ReflectiveTypeAdapterFactory(ConstructorConstructor r1, FieldNamingStrategy r2, Excluder r3, JsonAdapterAnnotationTypeAdapterFactory r4, List<ReflectionAccessFilter> r5) {
        this.constructorConstructor = r1;
        this.fieldNamingPolicy = r2;
        this.excluder = r3;
        this.jsonAdapterFactory = r4;
        this.reflectionFilters = r5;
    }

    private boolean includeField(Field r1, boolean r2) {
        return !this.excluder.excludeField(r1, r2);
    }

    private List<String> getFieldNames(Field r3) {
        SerializedName r0 = (SerializedName) r3.getAnnotation(SerializedName.class);
        if (r0 == null) goto L5;
        String r2 = r0.value();
        String[] r4 = r0.alternate();
        if (r4.length == 0) goto L9;
        ArrayList r1 = new ArrayList(r4.length + 1);
        r1.add(r2);
        Collections.addAll(r1, r4);
        return r1;
    L9:
        return Collections.singletonList(r2);
    L5:
        return Collections.singletonList(this.fieldNamingPolicy.translateName(r3));
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson r11, TypeToken<T> r12) {
        Class<? super T> r6 = r12.getRawType();
        if (Object.class.isAssignableFrom(r6) == true) goto L7;
        return null;
    L7:
        if (ReflectionHelper.isAnonymousOrNonStaticLocal(r6) == true) goto L9;
        ReflectionAccessFilter.FilterResult r0 = ReflectionAccessFilterHelper.getFilterResult(this.reflectionFilters, r6);
        if (r0 == ReflectionAccessFilter.FilterResult.BLOCK_ALL) goto L23;
        if (r0 != ReflectionAccessFilter.FilterResult.BLOCK_INACCESSIBLE) goto L15;
        boolean r1 = true;
    L16:
        boolean r7 = r1;
        if (ReflectionHelper.isRecord(r6) == false) goto L21;
        return new RecordAdapter(r6, getBoundFields(r11, r12, r6, r7, true), r7);
    L21:
        return new FieldReflectionAdapter(this.constructorConstructor.get(r12), getBoundFields(r11, r12, r6, r7, false));
    L15:
        r1 = false;
        goto L16
    L23:
        throw new JsonIOException("ReflectionAccessFilter does not permit using reflection for " + r6 + ". Register a TypeAdapter for this type or adjust the access filter.");
    L9:
        return new AnonymousClass1(this);
    }

    private static <M extends AccessibleObject & Member> void checkAccessible(Object r1, M r2) {
        if (Modifier.isStatic(r2.getModifiers()) == false) goto L6;
        r1 = null;
    L6:
        if (ReflectionAccessFilterHelper.canAccess(r2, r1) == false) goto L9;
        return;
    L9:
        throw new JsonIOException(ReflectionHelper.getAccessibleObjectDescription(r2, true) + " is not accessible and ReflectionAccessFilter does not permit making it accessible. Register a TypeAdapter for the declaring type, adjust the access filter or increase the visibility of the element and its declaring type.");
    }

    private BoundField createBoundField(Gson r14, final Field r15, final Method r16, final String r17, TypeToken<?> r18, boolean r19, final boolean r20) {
        final boolean r8 = Primitives.isPrimitive(r18.getRawType());
        int r2 = r15.getModifiers();
        boolean r9 = true;
        if (Modifier.isStatic(r2) == true) goto L5;
    L7:
        boolean r11 = false;
    L8:
        JsonAdapter r6 = (JsonAdapter) r15.getAnnotation(JsonAdapter.class);
        if (r6 == null) goto L11;
        TypeAdapter<?> r3 = this.jsonAdapterFactory.getTypeAdapter(this.constructorConstructor, r14, r18, r6, false);
    L12:
        if (r3 != null) goto L16;
        r9 = false;
    L16:
        if (r3 != null) goto L18;
        r3 = r14.getAdapter(r18);
    L18:
        final TypeAdapter<?> r7 = r3;
        if (r19 == false) goto L24;
        if (r9 == false) goto L22;
        TypeAdapter<?> r4 = r7;
    L23:
        final TypeAdapter<?> r10 = r4;
    L25:
        final boolean r12 = r11;
        return new AnonymousClass2(this, r17, r15, r20, r16, r10, r7, r8, r12);
    L22:
        r4 = new TypeAdapterRuntimeTypeWrapper(r14, r7, r18.getType());
        goto L23
    L24:
        r10 = r7;
        goto L25
    L11:
        r3 = null;
        goto L12
    L5:
        if (Modifier.isFinal(r2) == false) goto L7;
        r11 = true;
        goto L8
    }

    private static IllegalArgumentException createDuplicateFieldException(Class<?> r3, String r4, Field r5, Field r6) {
        throw new IllegalArgumentException("Class " + r3.getName() + " declares multiple JSON fields named '" + r4 + "'; conflict is caused by fields " + ReflectionHelper.fieldToString(r5) + " and " + ReflectionHelper.fieldToString(r6) + "\nSee " + TroubleshootingGuide.createUrl("duplicate-fields"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r18v0 */
    /* JADX WARN: Type inference failed for: r18v1 */
    /* JADX WARN: Type inference failed for: r18v2 */
    /* JADX WARN: Type inference failed for: r22v0 */
    /* JADX WARN: Type inference failed for: r22v1 */
    /* JADX WARN: Type inference failed for: r22v2 */
    /* JADX WARN: Type inference failed for: r23v0, types: [com.google.gson.internal.bind.ReflectiveTypeAdapterFactory] */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r7v3 */
    private FieldsData getBoundFields(Gson r24, TypeToken<?> r25, Class<?> r26, boolean r27, boolean r28) {
        if (r26.isInterface() == true) goto L5;
        LinkedHashMap r10 = new LinkedHashMap();
        LinkedHashMap r11 = new LinkedHashMap();
        TypeToken<?> r12 = r25;
        boolean r0 = r27;
        Class<?> r13 = r26;
    L8:
        if (r13 == Object.class) goto L65;
        Field[] r14 = r13.getDeclaredFields();
        boolean r15 = true;
        ?? r7 = 0;
        if (r13 != r26) goto L12;
    L21:
        boolean r16 = r0;
        int r6 = r14.length;
        int r5 = 0;
    L22:
        if (r5 >= r6) goto L63;
        Field r4 = r14[r5];
        boolean r17 = includeField(r4, r15);
        boolean r1 = includeField(r4, r7);
        if (r17 == true) goto L27;
        if (r1 == true) goto L27;
        int r21 = r5;
        int r19 = r6;
        ?? r22 = r7;
    L62:
        r5 = r21 + 1;
        r6 = r19;
        r7 = r22;
        r15 = true;
    L27:
        Method r2 = null;
        if (r28 == true) goto L30;
    L42:
        ?? r18 = r1;
        Method r3 = r2;
    L43:
        if (r16 == true) goto L46;
        if (r3 != null) goto L46;
        ReflectionHelper.makeAccessible(r4);
    L46:
        Type r8 = C$Gson$Types.resolve(r12.getType(), r13, r4.getGenericType());
        List<String> r9 = getFieldNames(r4);
        String r20 = r9.get(r7);
        r21 = r5;
        r19 = r6;
        r22 = r7;
        BoundField r23 = createBoundField(r24, r4, r3, r20, TypeToken.get(r8), r17, r16);
        if (r18 == 0) goto L56;
        Iterator<String> r29 = r9.iterator();
    L50:
        if (r29.hasNext() == false) goto L56;
        String r30 = r29.next();
        BoundField r31 = (BoundField) r10.put(r30, r23);
        if (r31 == null) goto L50;
        throw createDuplicateFieldException(r26, r30, r31.field, r4);
    L56:
        if (r17 == false) goto L62;
        BoundField r32 = (BoundField) r11.put(r20, r23);
        if (r32 == null) goto L62;
        throw createDuplicateFieldException(r26, r20, r32.field, r4);
    L30:
        if (Modifier.isStatic(r4.getModifiers()) == false) goto L32;
        r3 = null;
        r18 = r7;
        goto L43
    L32:
        r2 = ReflectionHelper.getAccessor(r13, r4);
        if (r16 == true) goto L36;
        ReflectionHelper.makeAccessible(r2);
    L36:
        if (r2.getAnnotation(SerializedName.class) == null) goto L42;
        if (r4.getAnnotation(SerializedName.class) != null) goto L42;
        throw new JsonIOException("@SerializedName on " + ReflectionHelper.getAccessibleObjectDescription(r2, r7) + " is not supported");
    L63:
        r12 = TypeToken.get(C$Gson$Types.resolve(r12.getType(), r13, r13.getGenericSuperclass()));
        r13 = r12.getRawType();
        r0 = r16;
        goto L8
    L12:
        if (r14.length <= 0) goto L21;
        ReflectionAccessFilter.FilterResult r33 = ReflectionAccessFilterHelper.getFilterResult(this.reflectionFilters, r13);
        if (r33 == ReflectionAccessFilter.FilterResult.BLOCK_ALL) goto L20;
        if (r33 != ReflectionAccessFilter.FilterResult.BLOCK_INACCESSIBLE) goto L18;
        r0 = true;
        goto L21
    L18:
        r0 = false;
        goto L21
    L20:
        throw new JsonIOException("ReflectionAccessFilter does not permit using reflection for " + r13 + " (supertype of " + r26 + "). Register a TypeAdapter for this type or adjust the access filter.");
    L65:
        return new FieldsData(r10, new ArrayList(r11.values()));
    L5:
        return FieldsData.EMPTY;
    }
}
