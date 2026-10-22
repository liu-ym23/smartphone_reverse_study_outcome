package com.google.gson;

import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.internal.Primitives;
import com.google.gson.internal.Streams;
import com.google.gson.internal.bind.ArrayTypeAdapter;
import com.google.gson.internal.bind.CollectionTypeAdapterFactory;
import com.google.gson.internal.bind.DateTypeAdapter;
import com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory;
import com.google.gson.internal.bind.JsonTreeReader;
import com.google.gson.internal.bind.JsonTreeWriter;
import com.google.gson.internal.bind.MapTypeAdapterFactory;
import com.google.gson.internal.bind.NumberTypeAdapter;
import com.google.gson.internal.bind.ObjectTypeAdapter;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gson.internal.bind.SerializationDelegatingTypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.internal.sql.SqlTypesSupport;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.MalformedJsonException;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

/* JADX INFO: loaded from: classes2.dex */
public final class Gson {
    static final boolean DEFAULT_COMPLEX_MAP_KEYS = false;
    static final String DEFAULT_DATE_PATTERN = null;
    static final boolean DEFAULT_ESCAPE_HTML = true;
    static final FieldNamingStrategy DEFAULT_FIELD_NAMING_STRATEGY = null;
    static final boolean DEFAULT_JSON_NON_EXECUTABLE = false;
    static final boolean DEFAULT_LENIENT = false;
    static final ToNumberStrategy DEFAULT_NUMBER_TO_NUMBER_STRATEGY = null;
    static final ToNumberStrategy DEFAULT_OBJECT_TO_NUMBER_STRATEGY = null;
    static final boolean DEFAULT_PRETTY_PRINT = false;
    static final boolean DEFAULT_SERIALIZE_NULLS = false;
    static final boolean DEFAULT_SPECIALIZE_FLOAT_VALUES = false;
    static final boolean DEFAULT_USE_JDK_UNSAFE = true;
    private static final String JSON_NON_EXECUTABLE_PREFIX = ")]}'\n";
    final List<TypeAdapterFactory> builderFactories;
    final List<TypeAdapterFactory> builderHierarchyFactories;
    final boolean complexMapKeySerialization;
    private final ConstructorConstructor constructorConstructor;
    final String datePattern;
    final int dateStyle;
    final Excluder excluder;
    final List<TypeAdapterFactory> factories;
    final FieldNamingStrategy fieldNamingStrategy;
    final boolean generateNonExecutableJson;
    final boolean htmlSafe;
    final Map<Type, InstanceCreator<?>> instanceCreators;
    private final JsonAdapterAnnotationTypeAdapterFactory jsonAdapterFactory;
    final boolean lenient;
    final LongSerializationPolicy longSerializationPolicy;
    final ToNumberStrategy numberToNumberStrategy;
    final ToNumberStrategy objectToNumberStrategy;
    final boolean prettyPrinting;
    final List<ReflectionAccessFilter> reflectionFilters;
    final boolean serializeNulls;
    final boolean serializeSpecialFloatingPointValues;
    private final ThreadLocal<Map<TypeToken<?>, TypeAdapter<?>>> threadLocalAdapterResults;
    final int timeStyle;
    private final ConcurrentMap<TypeToken<?>, TypeAdapter<?>> typeTokenCache;
    final boolean useJdkUnsafe;

    static class FutureTypeAdapter<T> extends SerializationDelegatingTypeAdapter<T> {
        private TypeAdapter<T> delegate;

        FutureTypeAdapter() {
            this.delegate = null;
        }

        public void setDelegate(TypeAdapter<T> r2) {
            if (this.delegate != null) goto L7;
            this.delegate = r2;
            return;
        L7:
            throw new AssertionError("Delegate is already set");
        }

        private TypeAdapter<T> delegate() {
            TypeAdapter<T> r1 = this.delegate;
            if (r1 == null) goto L6;
            return r1;
        L6:
            throw new IllegalStateException("Adapter for type with cyclic dependency has been used before dependency has been resolved");
        }

        @Override // com.google.gson.internal.bind.SerializationDelegatingTypeAdapter
        public TypeAdapter<T> getSerializationDelegate() {
            return delegate();
        }

        @Override // com.google.gson.TypeAdapter
        public T read(JsonReader r1) {
            return delegate().read(r1);
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter r1, T r2) {
            delegate().write(r1, r2);
        }
    }

    static {
        DEFAULT_FIELD_NAMING_STRATEGY = FieldNamingPolicy.IDENTITY;
        DEFAULT_OBJECT_TO_NUMBER_STRATEGY = ToNumberPolicy.DOUBLE;
        DEFAULT_NUMBER_TO_NUMBER_STRATEGY = ToNumberPolicy.LAZILY_PARSED_NUMBER;
    }

    public Gson() {
        this(Excluder.DEFAULT, DEFAULT_FIELD_NAMING_STRATEGY, Collections.emptyMap(), false, false, false, true, false, false, false, true, LongSerializationPolicy.DEFAULT, DEFAULT_DATE_PATTERN, 2, 2, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), DEFAULT_OBJECT_TO_NUMBER_STRATEGY, DEFAULT_NUMBER_TO_NUMBER_STRATEGY, Collections.emptyList());
    }

    Gson(Excluder r16, FieldNamingStrategy r17, Map<Type, InstanceCreator<?>> r18, boolean r19, boolean r20, boolean r21, boolean r22, boolean r23, boolean r24, boolean r25, boolean r26, LongSerializationPolicy r27, String r28, int r29, int r30, List<TypeAdapterFactory> r31, List<TypeAdapterFactory> r32, List<TypeAdapterFactory> r33, ToNumberStrategy r34, ToNumberStrategy r35, List<ReflectionAccessFilter> r36) {
        FieldNamingStrategy r5 = (FieldNamingStrategy) ZeusTransformUtils.wrapperContextForParams(r17, FieldNamingStrategy.class, "com.obric.aiagent.plugin");
        Map<Type, InstanceCreator<?>> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r18, Map.class, "com.obric.aiagent.plugin");
        List<TypeAdapterFactory> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r31, List.class, "com.obric.aiagent.plugin");
        List<TypeAdapterFactory> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r32, List.class, "com.obric.aiagent.plugin");
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r33, List.class, "com.obric.aiagent.plugin");
        ToNumberStrategy r11 = (ToNumberStrategy) ZeusTransformUtils.wrapperContextForParams(r34, ToNumberStrategy.class, "com.obric.aiagent.plugin");
        ToNumberStrategy r12 = (ToNumberStrategy) ZeusTransformUtils.wrapperContextForParams(r35, ToNumberStrategy.class, "com.obric.aiagent.plugin");
        List<ReflectionAccessFilter> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r36, List.class, "com.obric.aiagent.plugin");
        this.threadLocalAdapterResults = new ThreadLocal();
        this.typeTokenCache = new ConcurrentHashMap();
        this.excluder = r16;
        this.fieldNamingStrategy = r5;
        this.instanceCreators = r7;
        ConstructorConstructor r13 = new ConstructorConstructor(r7, r26, r6);
        this.constructorConstructor = r13;
        this.serializeNulls = r19;
        this.complexMapKeySerialization = r20;
        this.generateNonExecutableJson = r21;
        this.htmlSafe = r22;
        this.prettyPrinting = r23;
        this.lenient = r24;
        this.serializeSpecialFloatingPointValues = r25;
        this.useJdkUnsafe = r26;
        this.longSerializationPolicy = r27;
        this.datePattern = r28;
        this.dateStyle = r29;
        this.timeStyle = r30;
        this.builderFactories = r8;
        this.builderHierarchyFactories = r9;
        this.objectToNumberStrategy = r11;
        this.numberToNumberStrategy = r12;
        this.reflectionFilters = r6;
        ArrayList r14 = new ArrayList();
        r14.add(TypeAdapters.JSON_ELEMENT_FACTORY);
        r14.add(ObjectTypeAdapter.getFactory(r11));
        r14.add(r16);
        r14.addAll(r10);
        r14.add(TypeAdapters.STRING_FACTORY);
        r14.add(TypeAdapters.INTEGER_FACTORY);
        r14.add(TypeAdapters.BOOLEAN_FACTORY);
        r14.add(TypeAdapters.BYTE_FACTORY);
        r14.add(TypeAdapters.SHORT_FACTORY);
        TypeAdapter<Number> r4 = longAdapter(r27);
        r14.add(TypeAdapters.newFactory(Long.TYPE, Long.class, r4));
        r14.add(TypeAdapters.newFactory(Double.TYPE, Double.class, doubleAdapter(r25)));
        r14.add(TypeAdapters.newFactory(Float.TYPE, Float.class, floatAdapter(r25)));
        r14.add(NumberTypeAdapter.getFactory(r12));
        r14.add(TypeAdapters.ATOMIC_INTEGER_FACTORY);
        r14.add(TypeAdapters.ATOMIC_BOOLEAN_FACTORY);
        r14.add(TypeAdapters.newFactory(AtomicLong.class, atomicLongAdapter(r4)));
        r14.add(TypeAdapters.newFactory(AtomicLongArray.class, atomicLongArrayAdapter(r4)));
        r14.add(TypeAdapters.ATOMIC_INTEGER_ARRAY_FACTORY);
        r14.add(TypeAdapters.CHARACTER_FACTORY);
        r14.add(TypeAdapters.STRING_BUILDER_FACTORY);
        r14.add(TypeAdapters.STRING_BUFFER_FACTORY);
        r14.add(TypeAdapters.newFactory(BigDecimal.class, TypeAdapters.BIG_DECIMAL));
        r14.add(TypeAdapters.newFactory(BigInteger.class, TypeAdapters.BIG_INTEGER));
        r14.add(TypeAdapters.newFactory(LazilyParsedNumber.class, TypeAdapters.LAZILY_PARSED_NUMBER));
        r14.add(TypeAdapters.URL_FACTORY);
        r14.add(TypeAdapters.URI_FACTORY);
        r14.add(TypeAdapters.UUID_FACTORY);
        r14.add(TypeAdapters.CURRENCY_FACTORY);
        r14.add(TypeAdapters.LOCALE_FACTORY);
        r14.add(TypeAdapters.INET_ADDRESS_FACTORY);
        r14.add(TypeAdapters.BIT_SET_FACTORY);
        r14.add(DateTypeAdapter.FACTORY);
        r14.add(TypeAdapters.CALENDAR_FACTORY);
        if (SqlTypesSupport.SUPPORTS_SQL_TYPES == false) goto L5;
        r14.add(SqlTypesSupport.TIME_FACTORY);
        r14.add(SqlTypesSupport.DATE_FACTORY);
        r14.add(SqlTypesSupport.TIMESTAMP_FACTORY);
    L5:
        r14.add(ArrayTypeAdapter.FACTORY);
        r14.add(TypeAdapters.CLASS_FACTORY);
        r14.add(new CollectionTypeAdapterFactory(r13));
        r14.add(new MapTypeAdapterFactory(r13, r20));
        JsonAdapterAnnotationTypeAdapterFactory r2 = new JsonAdapterAnnotationTypeAdapterFactory(r13);
        this.jsonAdapterFactory = r2;
        r14.add(r2);
        r14.add(TypeAdapters.ENUM_FACTORY);
        r14.add(new ReflectiveTypeAdapterFactory(r13, r5, r16, r2, r6));
        this.factories = Collections.unmodifiableList(r14);
    }

    public GsonBuilder newBuilder() {
        return new GsonBuilder(this);
    }

    @Deprecated
    public Excluder excluder() {
        return this.excluder;
    }

    public FieldNamingStrategy fieldNamingStrategy() {
        return this.fieldNamingStrategy;
    }

    public boolean serializeNulls() {
        return this.serializeNulls;
    }

    public boolean htmlSafe() {
        return this.htmlSafe;
    }

    private TypeAdapter<Number> doubleAdapter(boolean r1) {
        if (r1 == false) goto L6;
        return TypeAdapters.DOUBLE;
    L6:
        return new AnonymousClass1(this);
    }

    private TypeAdapter<Number> floatAdapter(boolean r1) {
        if (r1 == false) goto L6;
        return TypeAdapters.FLOAT;
    L6:
        return new AnonymousClass2(this);
    }

    static void checkValidFloatingPoint(double r2) {
        if (Double.isNaN(r2) == true) goto L8;
        if (Double.isInfinite(r2) == true) goto L8;
        return;
    L8:
        throw new IllegalArgumentException(r2 + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
    }

    private static TypeAdapter<Number> longAdapter(LongSerializationPolicy r1) {
        if (r1 != LongSerializationPolicy.DEFAULT) goto L7;
        return TypeAdapters.LONG;
    L7:
        return new AnonymousClass3();
    }

    private static TypeAdapter<AtomicLong> atomicLongAdapter(final TypeAdapter<Number> r1) {
        return new AnonymousClass4(r1).nullSafe();
    }

    private static TypeAdapter<AtomicLongArray> atomicLongArrayAdapter(final TypeAdapter<Number> r1) {
        return new AnonymousClass5(r1).nullSafe();
    }

    public <T> TypeAdapter<T> getAdapter(TypeToken<T> r8) {
        Objects.requireNonNull(r8, "type must not be null");
        TypeAdapter<T> r0 = (TypeAdapter) ZeusTransformUtils.preCheckCast(this.typeTokenCache.get(r8), TypeAdapter.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L5;
        return r0;
    L5:
        Map<TypeToken<?>, TypeAdapter<?>> r1 = (Map) ZeusTransformUtils.preCheckCast(this.threadLocalAdapterResults.get(), Map.class, "com.obric.aiagent.plugin");
        boolean r2 = false;
        if (r1 != null) goto L8;
        r1 = new HashMap();
        this.threadLocalAdapterResults.set(r1);
        r2 = true;
    L11:
        TypeAdapter<T> r3 = null;
        FutureTypeAdapter r4 = new FutureTypeAdapter();     // Catch: Throwable -> L26
        r1.put(r8, r4);     // Catch: Throwable -> L26
        Iterator<TypeAdapterFactory> r5 = this.factories.iterator();     // Catch: Throwable -> L26
    L14:
        if (r5.hasNext() == false) goto L18;
        r3 = ((TypeAdapterFactory) ZeusTransformUtils.preCheckCast(r5.next(), TypeAdapterFactory.class, "com.obric.aiagent.plugin")).create(this, r8);     // Catch: Throwable -> L26
        if (r3 == null) goto L14;
        r4.setDelegate(r3);     // Catch: Throwable -> L26
        r1.put(r8, r3);     // Catch: Throwable -> L26
    L18:
        if (r2 == false) goto L20;
        this.threadLocalAdapterResults.remove();
    L20:
        if (r3 == null) goto L25;
        if (r2 == false) goto L23;
        this.typeTokenCache.putAll(r1);
    L23:
        return r3;
    L25:
        throw new IllegalArgumentException("GSON (2.10.1) cannot handle " + r8);
    L26:
        th = move-exception;
        if (r2 == false) goto L29;
        this.threadLocalAdapterResults.remove();
    L29:
        throw th;
    L8:
        TypeAdapter<T> r6 = (TypeAdapter) ZeusTransformUtils.preCheckCast(r1.get(r8), TypeAdapter.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L11;
        return r6;
    }

    public <T> TypeAdapter<T> getDelegateAdapter(TypeAdapterFactory r6, TypeToken<T> r7) {
        TypeAdapterFactory r8 = (TypeAdapterFactory) ZeusTransformUtils.wrapperContextForParams(r6, TypeAdapterFactory.class, "com.obric.aiagent.plugin");
        if (this.factories.contains(r8) == true) goto L5;
        r8 = this.jsonAdapterFactory;
    L5:
        boolean r0 = false;
        Iterator<TypeAdapterFactory> r2 = this.factories.iterator();
    L7:
        if (r2.hasNext() == false) goto L16;
        TypeAdapterFactory r3 = (TypeAdapterFactory) ZeusTransformUtils.preCheckCast(r2.next(), TypeAdapterFactory.class, "com.obric.aiagent.plugin");
        if (r0 == false) goto L10;
        TypeAdapter<T> r4 = r3.create(this, r7);
        if (r4 == null) goto L7;
        return r4;
    L10:
        if (r3 != r8) goto L7;
        r0 = true;
        goto L7
    L16:
        throw new IllegalArgumentException("GSON cannot serialize " + r7);
    }

    public <T> TypeAdapter<T> getAdapter(Class<T> r1) {
        return getAdapter(TypeToken.get(r1));
    }

    public JsonElement toJsonTree(Object r2) {
        if (r2 != null) goto L6;
        return JsonNull.INSTANCE;
    L6:
        return toJsonTree(r2, r2.getClass());
    }

    public JsonElement toJsonTree(Object r3, Type r4) {
        Type r5 = (Type) ZeusTransformUtils.wrapperContextForParams(r4, Type.class, "com.obric.aiagent.plugin");
        JsonTreeWriter r0 = new JsonTreeWriter();
        toJson(r3, r5, r0);
        return r0.get();
    }

    public String toJson(Object r2) {
        if (r2 != null) goto L6;
        return toJson(JsonNull.INSTANCE);
    L6:
        return toJson(r2, r2.getClass());
    }

    public String toJson(Object r3, Type r4) {
        Type r5 = (Type) ZeusTransformUtils.wrapperContextForParams(r4, Type.class, "com.obric.aiagent.plugin");
        StringWriter r0 = new StringWriter();
        toJson(r3, r5, r0);
        return r0.toString();
    }

    public void toJson(Object r3, Appendable r4) {
        Appendable r5 = (Appendable) ZeusTransformUtils.wrapperContextForParams(r4, Appendable.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L5;
        toJson(r3, r3.getClass(), r5);
        return;
    L5:
        toJson(JsonNull.INSTANCE, r5);
    }

    public void toJson(Object r3, Type r4, Appendable r5) {
        Type r6 = (Type) ZeusTransformUtils.wrapperContextForParams(r4, Type.class, "com.obric.aiagent.plugin");
        toJson(r3, r6, newJsonWriter(Streams.writerForAppendable((Appendable) ZeusTransformUtils.wrapperContextForParams(r5, Appendable.class, "com.obric.aiagent.plugin"))));     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        throw new JsonIOException(e);
    }

    public void toJson(Object r5, Type r6, JsonWriter r7) {
        TypeAdapter r8 = getAdapter(TypeToken.get((Type) ZeusTransformUtils.wrapperContextForParams(r6, Type.class, "com.obric.aiagent.plugin")));
        boolean r0 = r7.isLenient();
        r7.setLenient(true);
        boolean r1 = r7.isHtmlSafe();
        r7.setHtmlSafe(this.htmlSafe);
        boolean r2 = r7.getSerializeNulls();
        r7.setSerializeNulls(this.serializeNulls);
        r8.write(r7, r5);     // Catch: Throwable -> L6 AssertionError -> L8 IOException -> L11
        r7.setLenient(r0);
        r7.setHtmlSafe(r1);
        r7.setSerializeNulls(r2);
        return;
    L6:
        th = move-exception;
        r7.setLenient(r0);
        r7.setHtmlSafe(r1);
        r7.setSerializeNulls(r2);
        throw th;
    L11:
        e = move-exception;
        throw new JsonIOException(e);     // Catch: Throwable -> L6
    L8:
        e = move-exception;
        throw new AssertionError("AssertionError (GSON 2.10.1): " + e.getMessage(), e);     // Catch: Throwable -> L6
    }

    public String toJson(JsonElement r2) {
        StringWriter r0 = new StringWriter();
        toJson(r2, r0);
        return r0.toString();
    }

    public void toJson(JsonElement r3, Appendable r4) {
        toJson(r3, newJsonWriter(Streams.writerForAppendable((Appendable) ZeusTransformUtils.wrapperContextForParams(r4, Appendable.class, "com.obric.aiagent.plugin"))));     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        throw new JsonIOException(e);
    }

    public JsonWriter newJsonWriter(Writer r2) {
        if (this.generateNonExecutableJson == false) goto L5;
        r2.write(JSON_NON_EXECUTABLE_PREFIX);
    L5:
        JsonWriter r0 = new JsonWriter(r2);
        if (this.prettyPrinting == false) goto L8;
        r0.setIndent("  ");
    L8:
        r0.setHtmlSafe(this.htmlSafe);
        r0.setLenient(this.lenient);
        r0.setSerializeNulls(this.serializeNulls);
        return r0;
    }

    public JsonReader newJsonReader(Reader r2) {
        JsonReader r0 = new JsonReader(r2);
        r0.setLenient(this.lenient);
        return r0;
    }

    public void toJson(JsonElement r6, JsonWriter r7) {
        boolean r0 = r7.isLenient();
        r7.setLenient(true);
        boolean r1 = r7.isHtmlSafe();
        r7.setHtmlSafe(this.htmlSafe);
        boolean r2 = r7.getSerializeNulls();
        r7.setSerializeNulls(this.serializeNulls);
        Streams.write(r6, r7);     // Catch: Throwable -> L6 AssertionError -> L8 IOException -> L11
        r7.setLenient(r0);
        r7.setHtmlSafe(r1);
        r7.setSerializeNulls(r2);
        return;
    L6:
        th = move-exception;
        r7.setLenient(r0);
        r7.setHtmlSafe(r1);
        r7.setSerializeNulls(r2);
        throw th;
    L11:
        e = move-exception;
        throw new JsonIOException(e);     // Catch: Throwable -> L6
    L8:
        e = move-exception;
        throw new AssertionError("AssertionError (GSON 2.10.1): " + e.getMessage(), e);     // Catch: Throwable -> L6
    }

    public <T> T fromJson(String r2, Class<T> r3) {
        Object r1 = fromJson(r2, TypeToken.get(r3));
        return (T) Primitives.wrap(r3).cast(r1);
    }

    public <T> T fromJson(String r3, Type r4) {
        return (T) fromJson(r3, TypeToken.get((Type) ZeusTransformUtils.wrapperContextForParams(r4, Type.class, "com.obric.aiagent.plugin")));
    }

    public <T> T fromJson(String r2, TypeToken<T> r3) {
        if (r2 != null) goto L6;
        return null;
    L6:
        return (T) fromJson(new StringReader(r2), r3);
    }

    public <T> T fromJson(Reader r2, Class<T> r3) {
        Object r1 = fromJson(r2, TypeToken.get(r3));
        return (T) Primitives.wrap(r3).cast(r1);
    }

    public <T> T fromJson(Reader r3, Type r4) {
        return (T) fromJson(r3, TypeToken.get((Type) ZeusTransformUtils.wrapperContextForParams(r4, Type.class, "com.obric.aiagent.plugin")));
    }

    public <T> T fromJson(Reader r1, TypeToken<T> r2) {
        JsonReader r3 = newJsonReader(r1);
        T r0 = (T) fromJson(r3, r2);
        assertFullConsumption(r0, r3);
        return r0;
    }

    private static void assertFullConsumption(Object r0, JsonReader r1) {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            if (r0 == 0) goto L21
            com.google.gson.stream.JsonToken r0 = r1.peek()     // Catch: java.io.IOException -> L13 com.google.gson.stream.MalformedJsonException -> L1a
            com.google.gson.stream.JsonToken r1 = com.google.gson.stream.JsonToken.END_DOCUMENT     // Catch: java.io.IOException -> L13 com.google.gson.stream.MalformedJsonException -> L1a
            if (r0 != r1) goto Lb
            goto L21
        Lb:
            com.google.gson.JsonSyntaxException r0 = new com.google.gson.JsonSyntaxException     // Catch: java.io.IOException -> L13 com.google.gson.stream.MalformedJsonException -> L1a
            java.lang.String r1 = "JSON document was not fully consumed."
            r0.<init>(r1)     // Catch: java.io.IOException -> L13 com.google.gson.stream.MalformedJsonException -> L1a
            throw r0     // Catch: java.io.IOException -> L13 com.google.gson.stream.MalformedJsonException -> L1a
        L13:
            r0 = move-exception
            com.google.gson.JsonIOException r1 = new com.google.gson.JsonIOException
            r1.<init>(r0)
            throw r1
        L1a:
            r0 = move-exception
            com.google.gson.JsonSyntaxException r1 = new com.google.gson.JsonSyntaxException
            r1.<init>(r0)
            throw r1
        L21:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.Gson.assertFullConsumption(java.lang.Object, com.google.gson.stream.JsonReader):void");
    }

    public <T> T fromJson(JsonReader r3, Type r4) {
        return (T) fromJson(r3, TypeToken.get((Type) ZeusTransformUtils.wrapperContextForParams(r4, Type.class, "com.obric.aiagent.plugin")));
    }

    public <T> T fromJson(JsonReader r4, TypeToken<T> r5) {
        boolean r0 = r4.isLenient();
        boolean r1 = true;
        r4.setLenient(true);
        r4.peek();     // Catch: Throwable -> L6 AssertionError -> L8 IOException -> L11 IllegalStateException -> L14 EOFException -> L17
        r1 = false;
        T r3 = getAdapter(r5).read(r4);     // Catch: Throwable -> L6 AssertionError -> L8 IOException -> L11 IllegalStateException -> L14 EOFException -> L17
        r4.setLenient(r0);
        return r3;
    L6:
        th = move-exception;
        r4.setLenient(r0);
        throw th;
    L8:
        e = move-exception;
        throw new AssertionError("AssertionError (GSON 2.10.1): " + e.getMessage(), e);     // Catch: Throwable -> L6
    L14:
        e = move-exception;
        throw new JsonSyntaxException(e);     // Catch: Throwable -> L6
    L17:
        e = move-exception;
        if (r1 == false) goto L22;
        r4.setLenient(r0);
        return null;
    L22:
        throw new JsonSyntaxException(e);     // Catch: Throwable -> L6
    L11:
        e = move-exception;
        throw new JsonSyntaxException(e);     // Catch: Throwable -> L6
    }

    public <T> T fromJson(JsonElement r2, Class<T> r3) {
        Object r1 = fromJson(r2, TypeToken.get(r3));
        return (T) Primitives.wrap(r3).cast(r1);
    }

    public <T> T fromJson(JsonElement r3, Type r4) {
        return (T) fromJson(r3, TypeToken.get((Type) ZeusTransformUtils.wrapperContextForParams(r4, Type.class, "com.obric.aiagent.plugin")));
    }

    public <T> T fromJson(JsonElement r2, TypeToken<T> r3) {
        if (r2 != null) goto L6;
        return null;
    L6:
        return (T) fromJson(new JsonTreeReader(r2), r3);
    }

    public String toString() {
        return "{serializeNulls:" + this.serializeNulls + ",factories:" + this.factories + ",instanceCreators:" + this.constructorConstructor + "}";
    }
}
