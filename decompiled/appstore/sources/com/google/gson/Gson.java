package com.google.gson;

import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.Primitives;
import com.google.gson.internal.Streams;
import com.google.gson.internal.bind.ArrayTypeAdapter;
import com.google.gson.internal.bind.CollectionTypeAdapterFactory;
import com.google.gson.internal.bind.DateTypeAdapter;
import com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory;
import com.google.gson.internal.bind.JsonTreeReader;
import com.google.gson.internal.bind.JsonTreeWriter;
import com.google.gson.internal.bind.MapTypeAdapterFactory;
import com.google.gson.internal.bind.ObjectTypeAdapter;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gson.internal.bind.SqlDateTypeAdapter;
import com.google.gson.internal.bind.TimeTypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.MalformedJsonException;
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
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

/* JADX INFO: loaded from: classes3.dex */
public final class Gson {
    static final boolean DEFAULT_COMPLEX_MAP_KEYS = false;
    static final boolean DEFAULT_ESCAPE_HTML = true;
    static final boolean DEFAULT_JSON_NON_EXECUTABLE = false;
    static final boolean DEFAULT_LENIENT = false;
    static final boolean DEFAULT_PRETTY_PRINT = false;
    static final boolean DEFAULT_SERIALIZE_NULLS = false;
    static final boolean DEFAULT_SPECIALIZE_FLOAT_VALUES = false;
    private static final String JSON_NON_EXECUTABLE_PREFIX = ")]}'\n";
    private static final TypeToken<?> NULL_KEY_SURROGATE = null;
    final List<TypeAdapterFactory> builderFactories;
    final List<TypeAdapterFactory> builderHierarchyFactories;
    private final ThreadLocal<Map<TypeToken<?>, FutureTypeAdapter<?>>> calls;
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
    final boolean prettyPrinting;
    final boolean serializeNulls;
    final boolean serializeSpecialFloatingPointValues;
    final int timeStyle;
    private final Map<TypeToken<?>, TypeAdapter<?>> typeTokenCache;

    public static class FutureTypeAdapter<T> extends TypeAdapter<T> {
        private TypeAdapter<T> delegate;

        public FutureTypeAdapter() {
        }

        @Override // com.google.gson.TypeAdapter
        public T read(JsonReader r10) throws IOException {
            TypeAdapter<T> r11 = this.delegate;
            if (r11 == null) goto L7;
            return r11.read(r10);
        L7:
            throw new IllegalStateException();
        }

        public void setDelegate(TypeAdapter<T> r10) {
            if (this.delegate != null) goto L7;
            this.delegate = r10;
            return;
        L7:
            throw new AssertionError();
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter r10, T r11) throws IOException {
            TypeAdapter<T> r12 = this.delegate;
            if (r12 == null) goto L7;
            r12.write(r10, r11);
            return;
        L7:
            throw new IllegalStateException();
        }
    }

    static {
        NULL_KEY_SURROGATE = TypeToken.get(Object.class);
    }

    public Gson() {
        this(Excluder.DEFAULT, FieldNamingPolicy.IDENTITY, Collections.emptyMap(), false, false, false, true, false, false, false, LongSerializationPolicy.DEFAULT, null, 2, 2, Collections.emptyList(), Collections.emptyList(), Collections.emptyList());
    }

    private static void assertFullConsumption(Object r10, JsonReader r11) {
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
            if (r0 == 0) goto L23
            com.google.gson.stream.JsonToken r0 = r1.peek()     // Catch: java.io.IOException -> L13 com.google.gson.stream.MalformedJsonException -> L15
            com.google.gson.stream.JsonToken r1 = com.google.gson.stream.JsonToken.END_DOCUMENT     // Catch: java.io.IOException -> L13 com.google.gson.stream.MalformedJsonException -> L15
            if (r0 != r1) goto Lb
            goto L23
        Lb:
            com.google.gson.JsonIOException r0 = new com.google.gson.JsonIOException     // Catch: java.io.IOException -> L13 com.google.gson.stream.MalformedJsonException -> L15
            java.lang.String r1 = "JSON document was not fully consumed."
            r0.<init>(r1)     // Catch: java.io.IOException -> L13 com.google.gson.stream.MalformedJsonException -> L15
            throw r0     // Catch: java.io.IOException -> L13 com.google.gson.stream.MalformedJsonException -> L15
        L13:
            r0 = move-exception
            goto L17
        L15:
            r0 = move-exception
            goto L1d
        L17:
            com.google.gson.JsonIOException r1 = new com.google.gson.JsonIOException
            r1.<init>(r0)
            throw r1
        L1d:
            com.google.gson.JsonSyntaxException r1 = new com.google.gson.JsonSyntaxException
            r1.<init>(r0)
            throw r1
        L23:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.Gson.assertFullConsumption(java.lang.Object, com.google.gson.stream.JsonReader):void");
    }

    private static TypeAdapter<AtomicLong> atomicLongAdapter(final TypeAdapter<Number> r10) {
        return new AnonymousClass4(r10).nullSafe();
    }

    private static TypeAdapter<AtomicLongArray> atomicLongArrayAdapter(final TypeAdapter<Number> r10) {
        return new AnonymousClass5(r10).nullSafe();
    }

    public static void checkValidFloatingPoint(double r10) {
        if (Double.isNaN(r10) == true) goto L8;
        if (Double.isInfinite(r10) == true) goto L8;
        return;
    L8:
        throw new IllegalArgumentException(r10 + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
    }

    private TypeAdapter<Number> doubleAdapter(boolean r10) {
        if (r10 == false) goto L6;
        return TypeAdapters.DOUBLE;
    L6:
        return new AnonymousClass1(this);
    }

    private TypeAdapter<Number> floatAdapter(boolean r10) {
        if (r10 == false) goto L6;
        return TypeAdapters.FLOAT;
    L6:
        return new AnonymousClass2(this);
    }

    private static TypeAdapter<Number> longAdapter(LongSerializationPolicy r10) {
        if (r10 != LongSerializationPolicy.DEFAULT) goto L7;
        return TypeAdapters.LONG;
    L7:
        return new AnonymousClass3();
    }

    public Excluder excluder() {
        return this.excluder;
    }

    public FieldNamingStrategy fieldNamingStrategy() {
        return this.fieldNamingStrategy;
    }

    public <T> T fromJson(String r10, Class<T> r11) throws JsonSyntaxException {
        Object r12 = fromJson(r10, r11);
        return (T) Primitives.wrap(r11).cast(r12);
    }

    public <T> TypeAdapter<T> getAdapter(TypeToken<T> r10) {
        Map<TypeToken<?>, TypeAdapter<?>> r11 = this.typeTokenCache;
        if (r10 != null) goto L5;
        Object r12 = NULL_KEY_SURROGATE;
    L6:
        TypeAdapter<T> r13 = (TypeAdapter) r11.get(r12);
        if (r13 == null) goto L9;
        return r13;
    L9:
        Map<TypeToken<?>, FutureTypeAdapter<?>> r14 = this.calls.get();
        if (r14 != null) goto L12;
        r14 = new HashMap();
        this.calls.set(r14);
        boolean r15 = true;
    L13:
        FutureTypeAdapter<?> r16 = r14.get(r10);
        if (r16 == null) goto L34;
        return r16;
    L34:
        FutureTypeAdapter<?> r17 = new FutureTypeAdapter();     // Catch: Throwable -> L26
        r14.put(r10, r17);     // Catch: Throwable -> L26
        Iterator<TypeAdapterFactory> r18 = this.factories.iterator();     // Catch: Throwable -> L26
    L18:
        if (r18.hasNext() == false) goto L29;
        TypeAdapter<T> r19 = r18.next().create(this, r10);     // Catch: Throwable -> L26
        if (r19 == null) goto L18;
        r17.setDelegate(r19);     // Catch: Throwable -> L26
        this.typeTokenCache.put(r10, r19);     // Catch: Throwable -> L26
        r14.remove(r10);
        if (r15 == false) goto L25;
        this.calls.remove();
    L25:
        return r19;
    L29:
        throw new IllegalArgumentException("GSON (2.8.6) cannot handle " + r10);     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        r14.remove(r10);
        if (r15 == false) goto L33;
        this.calls.remove();
    L33:
        throw th;
    L12:
        r15 = false;
        goto L13
    L5:
        r12 = r10;
        goto L6
    }

    public <T> TypeAdapter<T> getDelegateAdapter(TypeAdapterFactory r10, TypeToken<T> r11) {
        if (this.factories.contains(r10) == true) goto L5;
        r10 = this.jsonAdapterFactory;
    L5:
        Iterator<TypeAdapterFactory> r12 = this.factories.iterator();
        boolean r13 = false;
    L7:
        if (r12.hasNext() == false) goto L16;
        TypeAdapterFactory r14 = r12.next();
        if (r13 == false) goto L10;
        TypeAdapter<T> r15 = r14.create(this, r11);
        if (r15 == null) goto L7;
        return r15;
    L10:
        if (r14 != r10) goto L7;
        r13 = true;
        goto L7
    L16:
        throw new IllegalArgumentException("GSON cannot serialize " + r11);
    }

    public boolean htmlSafe() {
        return this.htmlSafe;
    }

    public GsonBuilder newBuilder() {
        return new GsonBuilder(this);
    }

    public JsonReader newJsonReader(Reader r10) {
        JsonReader r11 = new JsonReader(r10);
        r11.setLenient(this.lenient);
        return r11;
    }

    public JsonWriter newJsonWriter(Writer r10) throws IOException {
        if (this.generateNonExecutableJson == false) goto L5;
        r10.write(JSON_NON_EXECUTABLE_PREFIX);
    L5:
        JsonWriter r11 = new JsonWriter(r10);
        if (this.prettyPrinting == false) goto L8;
        r11.setIndent("  ");
    L8:
        r11.setSerializeNulls(this.serializeNulls);
        return r11;
    }

    public boolean serializeNulls() {
        return this.serializeNulls;
    }

    public String toJson(Object r10) {
        if (r10 != null) goto L6;
        return toJson(JsonNull.INSTANCE);
    L6:
        return toJson(r10, r10.getClass());
    }

    public JsonElement toJsonTree(Object r10) {
        if (r10 != null) goto L6;
        return JsonNull.INSTANCE;
    L6:
        return toJsonTree(r10, r10.getClass());
    }

    public String toString() {
        return "{serializeNulls:" + this.serializeNulls + ",factories:" + this.factories + ",instanceCreators:" + this.constructorConstructor + "}";
    }

    public <T> T fromJson(String r10, Type r11) throws JsonSyntaxException {
        if (r10 != null) goto L6;
        return null;
    L6:
        return (T) fromJson(new StringReader(r10), r11);
    }

    public String toJson(Object r10, Type r11) {
        StringWriter r12 = new StringWriter();
        toJson(r10, r11, r12);
        return r12.toString();
    }

    public JsonElement toJsonTree(Object r10, Type r11) {
        JsonTreeWriter r12 = new JsonTreeWriter();
        toJson(r10, r11, r12);
        return r12.get();
    }

    public <T> T fromJson(Reader r10, Class<T> r11) throws JsonSyntaxException, JsonIOException {
        JsonReader r12 = newJsonReader(r10);
        Object r13 = fromJson(r12, r11);
        assertFullConsumption(r13, r12);
        return (T) Primitives.wrap(r11).cast(r13);
    }

    public Gson(Excluder r12, FieldNamingStrategy r13, Map<Type, InstanceCreator<?>> r14, boolean r15, boolean r16, boolean r17, boolean r18, boolean r19, boolean r20, boolean r21, LongSerializationPolicy r22, String r23, int r24, int r25, List<TypeAdapterFactory> r26, List<TypeAdapterFactory> r27, List<TypeAdapterFactory> r28) {
        this.calls = new ThreadLocal();
        this.typeTokenCache = new ConcurrentHashMap();
        this.excluder = r12;
        this.fieldNamingStrategy = r13;
        this.instanceCreators = r14;
        ConstructorConstructor r10 = new ConstructorConstructor(r14);
        this.constructorConstructor = r10;
        this.serializeNulls = r15;
        this.complexMapKeySerialization = r16;
        this.generateNonExecutableJson = r17;
        this.htmlSafe = r18;
        this.prettyPrinting = r19;
        this.lenient = r20;
        this.serializeSpecialFloatingPointValues = r21;
        this.longSerializationPolicy = r22;
        this.datePattern = r23;
        this.dateStyle = r24;
        this.timeStyle = r25;
        this.builderFactories = r26;
        this.builderHierarchyFactories = r27;
        ArrayList r11 = new ArrayList();
        r11.add(TypeAdapters.JSON_ELEMENT_FACTORY);
        r11.add(ObjectTypeAdapter.FACTORY);
        r11.add(r12);
        r11.addAll(r28);
        r11.add(TypeAdapters.STRING_FACTORY);
        r11.add(TypeAdapters.INTEGER_FACTORY);
        r11.add(TypeAdapters.BOOLEAN_FACTORY);
        r11.add(TypeAdapters.BYTE_FACTORY);
        r11.add(TypeAdapters.SHORT_FACTORY);
        TypeAdapter<Number> r29 = longAdapter(r22);
        r11.add(TypeAdapters.newFactory(Long.TYPE, Long.class, r29));
        r11.add(TypeAdapters.newFactory(Double.TYPE, Double.class, doubleAdapter(r21)));
        r11.add(TypeAdapters.newFactory(Float.TYPE, Float.class, floatAdapter(r21)));
        r11.add(TypeAdapters.NUMBER_FACTORY);
        r11.add(TypeAdapters.ATOMIC_INTEGER_FACTORY);
        r11.add(TypeAdapters.ATOMIC_BOOLEAN_FACTORY);
        r11.add(TypeAdapters.newFactory(AtomicLong.class, atomicLongAdapter(r29)));
        r11.add(TypeAdapters.newFactory(AtomicLongArray.class, atomicLongArrayAdapter(r29)));
        r11.add(TypeAdapters.ATOMIC_INTEGER_ARRAY_FACTORY);
        r11.add(TypeAdapters.CHARACTER_FACTORY);
        r11.add(TypeAdapters.STRING_BUILDER_FACTORY);
        r11.add(TypeAdapters.STRING_BUFFER_FACTORY);
        r11.add(TypeAdapters.newFactory(BigDecimal.class, TypeAdapters.BIG_DECIMAL));
        r11.add(TypeAdapters.newFactory(BigInteger.class, TypeAdapters.BIG_INTEGER));
        r11.add(TypeAdapters.URL_FACTORY);
        r11.add(TypeAdapters.URI_FACTORY);
        r11.add(TypeAdapters.UUID_FACTORY);
        r11.add(TypeAdapters.CURRENCY_FACTORY);
        r11.add(TypeAdapters.LOCALE_FACTORY);
        r11.add(TypeAdapters.INET_ADDRESS_FACTORY);
        r11.add(TypeAdapters.BIT_SET_FACTORY);
        r11.add(DateTypeAdapter.FACTORY);
        r11.add(TypeAdapters.CALENDAR_FACTORY);
        r11.add(TimeTypeAdapter.FACTORY);
        r11.add(SqlDateTypeAdapter.FACTORY);
        r11.add(TypeAdapters.TIMESTAMP_FACTORY);
        r11.add(ArrayTypeAdapter.FACTORY);
        r11.add(TypeAdapters.CLASS_FACTORY);
        r11.add(new CollectionTypeAdapterFactory(r10));
        r11.add(new MapTypeAdapterFactory(r10, r16));
        JsonAdapterAnnotationTypeAdapterFactory r30 = new JsonAdapterAnnotationTypeAdapterFactory(r10);
        this.jsonAdapterFactory = r30;
        r11.add(r30);
        r11.add(TypeAdapters.ENUM_FACTORY);
        r11.add(new ReflectiveTypeAdapterFactory(r10, r13, r12, r30));
        this.factories = Collections.unmodifiableList(r11);
    }

    public void toJson(Object r10, Appendable r11) throws JsonIOException {
        if (r10 == null) goto L4;
        toJson(r10, r10.getClass(), r11);
        return;
    L4:
        toJson(JsonNull.INSTANCE, r11);
    }

    public void toJson(Object r10, Type r11, Appendable r12) throws JsonIOException {
        toJson(r10, r11, newJsonWriter(Streams.writerForAppendable(r12)));     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        throw new JsonIOException(e);
    }

    public <T> T fromJson(Reader r10, Type r11) throws JsonIOException, JsonSyntaxException {
        JsonReader r12 = newJsonReader(r10);
        T r13 = (T) fromJson(r12, r11);
        assertFullConsumption(r13, r12);
        return r13;
    }

    public void toJson(Object r10, Type r11, JsonWriter r12) throws JsonIOException {
        TypeAdapter r13 = getAdapter(TypeToken.get(r11));
        boolean r14 = r12.isLenient();
        r12.setLenient(true);
        boolean r15 = r12.isHtmlSafe();
        r12.setHtmlSafe(this.htmlSafe);
        boolean r16 = r12.getSerializeNulls();
        r12.setSerializeNulls(this.serializeNulls);
        r13.write(r12, r10);     // Catch: Throwable -> L6 AssertionError -> L8 IOException -> L11
        r12.setLenient(r14);
        r12.setHtmlSafe(r15);
        r12.setSerializeNulls(r16);
        return;
    L6:
        th = move-exception;
        r12.setLenient(r14);
        r12.setHtmlSafe(r15);
        r12.setSerializeNulls(r16);
        throw th;
    L11:
        e = move-exception;
        throw new JsonIOException(e);     // Catch: Throwable -> L6
    L8:
        e = move-exception;
        AssertionError r17 = new AssertionError("AssertionError (GSON 2.8.6): " + e.getMessage());     // Catch: Throwable -> L6
        r17.initCause(e);     // Catch: Throwable -> L6
        throw r17;     // Catch: Throwable -> L6
    }

    public <T> T fromJson(JsonReader r10, Type r11) throws JsonIOException, JsonSyntaxException {
        boolean r12 = r10.isLenient();
        boolean r13 = true;
        r10.setLenient(true);
        r10.peek();     // Catch: Throwable -> L6 AssertionError -> L8 IOException -> L10 IllegalStateException -> L12 EOFException -> L14
        r13 = false;
        T r14 = getAdapter(TypeToken.get(r11)).read(r10);     // Catch: Throwable -> L6 AssertionError -> L8 IOException -> L10 IllegalStateException -> L12 EOFException -> L14
        r10.setLenient(r12);
        return r14;
    L6:
        th = move-exception;
        r10.setLenient(r12);
        throw th;
    L14:
        e = move-exception;
        if (r13 == false) goto L26;
        r10.setLenient(r12);
        return null;
    L26:
        throw new JsonSyntaxException(e);     // Catch: Throwable -> L6
    L12:
        e = move-exception;
        throw new JsonSyntaxException(e);     // Catch: Throwable -> L6
    L10:
        e = move-exception;
        throw new JsonSyntaxException(e);     // Catch: Throwable -> L6
    L8:
        e = move-exception;
        AssertionError r15 = new AssertionError("AssertionError (GSON 2.8.6): " + e.getMessage());     // Catch: Throwable -> L6
        r15.initCause(e);     // Catch: Throwable -> L6
        throw r15;     // Catch: Throwable -> L6
    }

    public <T> TypeAdapter<T> getAdapter(Class<T> r10) {
        return getAdapter(TypeToken.get(r10));
    }

    public <T> T fromJson(JsonElement r10, Class<T> r11) throws JsonSyntaxException {
        Object r12 = fromJson(r10, r11);
        return (T) Primitives.wrap(r11).cast(r12);
    }

    public <T> T fromJson(JsonElement r10, Type r11) throws JsonSyntaxException {
        if (r10 != null) goto L6;
        return null;
    L6:
        return (T) fromJson(new JsonTreeReader(r10), r11);
    }

    public String toJson(JsonElement r10) {
        StringWriter r11 = new StringWriter();
        toJson(r10, r11);
        return r11.toString();
    }

    public void toJson(JsonElement r10, Appendable r11) throws JsonIOException {
        toJson(r10, newJsonWriter(Streams.writerForAppendable(r11)));     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        throw new JsonIOException(e);
    }

    public void toJson(JsonElement r10, JsonWriter r11) throws JsonIOException {
        boolean r12 = r11.isLenient();
        r11.setLenient(true);
        boolean r13 = r11.isHtmlSafe();
        r11.setHtmlSafe(this.htmlSafe);
        boolean r14 = r11.getSerializeNulls();
        r11.setSerializeNulls(this.serializeNulls);
        Streams.write(r10, r11);     // Catch: Throwable -> L6 AssertionError -> L8 IOException -> L11
        r11.setLenient(r12);
        r11.setHtmlSafe(r13);
        r11.setSerializeNulls(r14);
        return;
    L6:
        th = move-exception;
        r11.setLenient(r12);
        r11.setHtmlSafe(r13);
        r11.setSerializeNulls(r14);
        throw th;
    L11:
        e = move-exception;
        throw new JsonIOException(e);     // Catch: Throwable -> L6
    L8:
        e = move-exception;
        AssertionError r15 = new AssertionError("AssertionError (GSON 2.8.6): " + e.getMessage());     // Catch: Throwable -> L6
        r15.initCause(e);     // Catch: Throwable -> L6
        throw r15;     // Catch: Throwable -> L6
    }
}
