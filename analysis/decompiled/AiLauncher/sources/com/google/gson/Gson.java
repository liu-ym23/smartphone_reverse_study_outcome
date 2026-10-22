package com.google.gson;

import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.Primitives;
import com.google.gson.internal.Streams;
import com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory;
import com.google.gson.internal.bind.JsonTreeReader;
import com.google.gson.internal.bind.JsonTreeWriter;
import com.google.gson.internal.bind.SerializationDelegatingTypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes2.dex */
public final class Gson {
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
    final FormattingStyle formattingStyle;
    final boolean generateNonExecutableJson;
    final boolean htmlSafe;
    final Map<Type, InstanceCreator<?>> instanceCreators;
    private final JsonAdapterAnnotationTypeAdapterFactory jsonAdapterFactory;
    final LongSerializationPolicy longSerializationPolicy;
    final ToNumberStrategy numberToNumberStrategy;
    final ToNumberStrategy objectToNumberStrategy;
    final List<ReflectionAccessFilter> reflectionFilters;
    final boolean serializeNulls;
    final boolean serializeSpecialFloatingPointValues;
    final Strictness strictness;
    private final ThreadLocal<Map<TypeToken<?>, TypeAdapter<?>>> threadLocalAdapterResults;
    final int timeStyle;
    private final ConcurrentMap<TypeToken<?>, TypeAdapter<?>> typeTokenCache;
    final boolean useJdkUnsafe;

    public static class FutureTypeAdapter<T> extends SerializationDelegatingTypeAdapter<T> {
        private TypeAdapter<T> delegate = null;

        private TypeAdapter<T> delegate() {
            TypeAdapter<T> typeAdapter = this.delegate;
            if (typeAdapter != null) {
                return typeAdapter;
            }
            throw new IllegalStateException("Adapter for type with cyclic dependency has been used before dependency has been resolved");
        }

        @Override // com.google.gson.internal.bind.SerializationDelegatingTypeAdapter
        public TypeAdapter<T> getSerializationDelegate() {
            return delegate();
        }

        @Override // com.google.gson.TypeAdapter
        public T read(JsonReader jsonReader) throws IOException {
            return delegate().read(jsonReader);
        }

        public void setDelegate(TypeAdapter<T> typeAdapter) {
            if (this.delegate != null) {
                throw new AssertionError("Delegate is already set");
            }
            this.delegate = typeAdapter;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, T t10) throws IOException {
            delegate().write(jsonWriter, t10);
        }
    }

    public Gson() {
        this(GsonBuilder.DEFAULT);
    }

    private static void assertFullConsumption(Object obj, JsonReader jsonReader) {
        if (obj != null) {
            try {
                if (jsonReader.peek() == JsonToken.END_DOCUMENT) {
                } else {
                    throw new JsonSyntaxException("JSON document was not fully consumed.");
                }
            } catch (MalformedJsonException e10) {
                throw new JsonSyntaxException(e10);
            } catch (IOException e11) {
                throw new JsonIOException(e11);
            }
        }
    }

    @Deprecated
    public Excluder excluder() {
        return this.excluder;
    }

    public FieldNamingStrategy fieldNamingStrategy() {
        return this.fieldNamingStrategy;
    }

    public <T> T fromJson(String str, Class<T> cls) throws JsonSyntaxException {
        return (T) fromJson(str, TypeToken.get((Class) cls));
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0051, code lost:
    
        r2.setDelegate(r4);
        r0.put(r7, r4);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public <T> com.google.gson.TypeAdapter<T> getAdapter(com.google.gson.reflect.TypeToken<T> r7) {
        /*
            r6 = this;
            java.lang.String r0 = "type must not be null"
            java.util.Objects.requireNonNull(r7, r0)
            java.util.concurrent.ConcurrentMap<com.google.gson.reflect.TypeToken<?>, com.google.gson.TypeAdapter<?>> r0 = r6.typeTokenCache
            java.lang.Object r0 = r0.get(r7)
            com.google.gson.TypeAdapter r0 = (com.google.gson.TypeAdapter) r0
            if (r0 == 0) goto L10
            return r0
        L10:
            java.lang.ThreadLocal<java.util.Map<com.google.gson.reflect.TypeToken<?>, com.google.gson.TypeAdapter<?>>> r0 = r6.threadLocalAdapterResults
            java.lang.Object r0 = r0.get()
            java.util.Map r0 = (java.util.Map) r0
            if (r0 != 0) goto L26
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.lang.ThreadLocal<java.util.Map<com.google.gson.reflect.TypeToken<?>, com.google.gson.TypeAdapter<?>>> r1 = r6.threadLocalAdapterResults
            r1.set(r0)
            r1 = 1
            goto L30
        L26:
            java.lang.Object r1 = r0.get(r7)
            com.google.gson.TypeAdapter r1 = (com.google.gson.TypeAdapter) r1
            if (r1 == 0) goto L2f
            return r1
        L2f:
            r1 = 0
        L30:
            com.google.gson.Gson$FutureTypeAdapter r2 = new com.google.gson.Gson$FutureTypeAdapter     // Catch: java.lang.Throwable -> L58
            r2.<init>()     // Catch: java.lang.Throwable -> L58
            r0.put(r7, r2)     // Catch: java.lang.Throwable -> L58
            java.util.List<com.google.gson.TypeAdapterFactory> r3 = r6.factories     // Catch: java.lang.Throwable -> L58
            java.util.Iterator r3 = r3.iterator()     // Catch: java.lang.Throwable -> L58
            r4 = 0
        L3f:
            boolean r5 = r3.hasNext()     // Catch: java.lang.Throwable -> L58
            if (r5 == 0) goto L5a
            java.lang.Object r4 = r3.next()     // Catch: java.lang.Throwable -> L58
            com.google.gson.TypeAdapterFactory r4 = (com.google.gson.TypeAdapterFactory) r4     // Catch: java.lang.Throwable -> L58
            com.google.gson.TypeAdapter r4 = r4.create(r6, r7)     // Catch: java.lang.Throwable -> L58
            if (r4 == 0) goto L3f
            r2.setDelegate(r4)     // Catch: java.lang.Throwable -> L58
            r0.put(r7, r4)     // Catch: java.lang.Throwable -> L58
            goto L5a
        L58:
            r7 = move-exception
            goto L82
        L5a:
            if (r1 == 0) goto L61
            java.lang.ThreadLocal<java.util.Map<com.google.gson.reflect.TypeToken<?>, com.google.gson.TypeAdapter<?>>> r2 = r6.threadLocalAdapterResults
            r2.remove()
        L61:
            if (r4 == 0) goto L6b
            if (r1 == 0) goto L6a
            java.util.concurrent.ConcurrentMap<com.google.gson.reflect.TypeToken<?>, com.google.gson.TypeAdapter<?>> r6 = r6.typeTokenCache
            r6.putAll(r0)
        L6a:
            return r4
        L6b:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "GSON (2.14.0) cannot handle "
            r0.append(r1)
            r0.append(r7)
            java.lang.String r7 = r0.toString()
            r6.<init>(r7)
            throw r6
        L82:
            if (r1 == 0) goto L89
            java.lang.ThreadLocal<java.util.Map<com.google.gson.reflect.TypeToken<?>, com.google.gson.TypeAdapter<?>>> r6 = r6.threadLocalAdapterResults
            r6.remove()
        L89:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.Gson.getAdapter(com.google.gson.reflect.TypeToken):com.google.gson.TypeAdapter");
    }

    public <T> TypeAdapter<T> getDelegateAdapter(TypeAdapterFactory typeAdapterFactory, TypeToken<T> typeToken) {
        Objects.requireNonNull(typeAdapterFactory, "skipPast must not be null");
        Objects.requireNonNull(typeToken, "type must not be null");
        if (this.jsonAdapterFactory.isClassJsonAdapterFactory(typeToken, typeAdapterFactory)) {
            typeAdapterFactory = this.jsonAdapterFactory;
        }
        boolean z10 = false;
        for (TypeAdapterFactory typeAdapterFactory2 : this.factories) {
            if (z10) {
                TypeAdapter<T> typeAdapterCreate = typeAdapterFactory2.create(this, typeToken);
                if (typeAdapterCreate != null) {
                    return typeAdapterCreate;
                }
            } else if (typeAdapterFactory2 == typeAdapterFactory) {
                z10 = true;
            }
        }
        if (!z10) {
            return getAdapter(typeToken);
        }
        throw new IllegalArgumentException("GSON cannot serialize or deserialize " + typeToken);
    }

    public boolean htmlSafe() {
        return this.htmlSafe;
    }

    public GsonBuilder newBuilder() {
        return new GsonBuilder(this);
    }

    public JsonReader newJsonReader(Reader reader) {
        JsonReader jsonReader = new JsonReader(reader);
        Strictness strictness = this.strictness;
        if (strictness == null) {
            strictness = Strictness.LEGACY_STRICT;
        }
        jsonReader.setStrictness(strictness);
        return jsonReader;
    }

    public JsonWriter newJsonWriter(Writer writer) throws IOException {
        if (this.generateNonExecutableJson) {
            writer.write(JSON_NON_EXECUTABLE_PREFIX);
        }
        JsonWriter jsonWriter = new JsonWriter(writer);
        jsonWriter.setFormattingStyle(this.formattingStyle);
        jsonWriter.setHtmlSafe(this.htmlSafe);
        Strictness strictness = this.strictness;
        if (strictness == null) {
            strictness = Strictness.LEGACY_STRICT;
        }
        jsonWriter.setStrictness(strictness);
        jsonWriter.setSerializeNulls(this.serializeNulls);
        return jsonWriter;
    }

    public boolean serializeNulls() {
        return this.serializeNulls;
    }

    public String toJson(Object obj) {
        return obj == null ? toJson((JsonElement) JsonNull.INSTANCE) : toJson(obj, obj.getClass());
    }

    public JsonElement toJsonTree(Object obj) {
        return obj == null ? JsonNull.INSTANCE : toJsonTree(obj, obj.getClass());
    }

    public String toString() {
        return "{serializeNulls:" + this.serializeNulls + ",factories:" + this.factories + ",instanceCreators:" + this.constructorConstructor + "}";
    }

    public Gson(GsonBuilder gsonBuilder) {
        this.threadLocalAdapterResults = new ThreadLocal<>();
        this.typeTokenCache = new ConcurrentHashMap();
        this.excluder = gsonBuilder.excluder;
        this.fieldNamingStrategy = gsonBuilder.fieldNamingPolicy;
        HashMap map = new HashMap(gsonBuilder.instanceCreators);
        this.instanceCreators = map;
        this.serializeNulls = gsonBuilder.serializeNulls;
        this.complexMapKeySerialization = gsonBuilder.complexMapKeySerialization;
        this.generateNonExecutableJson = gsonBuilder.generateNonExecutableJson;
        this.htmlSafe = gsonBuilder.escapeHtmlChars;
        this.formattingStyle = gsonBuilder.formattingStyle;
        this.strictness = gsonBuilder.strictness;
        this.serializeSpecialFloatingPointValues = gsonBuilder.serializeSpecialFloatingPointValues;
        boolean z10 = gsonBuilder.useJdkUnsafe;
        this.useJdkUnsafe = z10;
        this.longSerializationPolicy = gsonBuilder.longSerializationPolicy;
        this.datePattern = gsonBuilder.datePattern;
        this.dateStyle = gsonBuilder.dateStyle;
        this.timeStyle = gsonBuilder.timeStyle;
        this.builderFactories = GsonBuilder.newImmutableList(gsonBuilder.factories);
        this.builderHierarchyFactories = GsonBuilder.newImmutableList(gsonBuilder.hierarchyFactories);
        this.objectToNumberStrategy = gsonBuilder.objectToNumberStrategy;
        this.numberToNumberStrategy = gsonBuilder.numberToNumberStrategy;
        List<ReflectionAccessFilter> listNewImmutableList = GsonBuilder.newImmutableList(gsonBuilder.reflectionFilters);
        this.reflectionFilters = listNewImmutableList;
        if (gsonBuilder == GsonBuilder.DEFAULT) {
            this.constructorConstructor = GsonBuilder.DEFAULT_CONSTRUCTOR_CONSTRUCTOR;
            this.jsonAdapterFactory = GsonBuilder.DEFAULT_JSON_ADAPTER_ANNOTATION_TYPE_ADAPTER_FACTORY;
            this.factories = GsonBuilder.DEFAULT_TYPE_ADAPTER_FACTORIES;
        } else {
            ConstructorConstructor constructorConstructor = new ConstructorConstructor(map, z10, listNewImmutableList);
            this.constructorConstructor = constructorConstructor;
            JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory = new JsonAdapterAnnotationTypeAdapterFactory(constructorConstructor);
            this.jsonAdapterFactory = jsonAdapterAnnotationTypeAdapterFactory;
            this.factories = gsonBuilder.createFactories(constructorConstructor, jsonAdapterAnnotationTypeAdapterFactory);
        }
    }

    public <T> T fromJson(String str, Type type) throws JsonSyntaxException {
        return (T) fromJson(str, TypeToken.get(type));
    }

    public <T> T fromJson(String str, TypeToken<T> typeToken) throws JsonSyntaxException {
        if (str == null) {
            return null;
        }
        return (T) fromJson(new StringReader(str), typeToken);
    }

    public String toJson(Object obj, Type type) throws JsonIOException {
        StringBuilder sb2 = new StringBuilder();
        toJson(obj, type, sb2);
        return sb2.toString();
    }

    public JsonElement toJsonTree(Object obj, Type type) throws JsonIOException {
        JsonTreeWriter jsonTreeWriter = new JsonTreeWriter();
        toJson(obj, type, jsonTreeWriter);
        return jsonTreeWriter.get();
    }

    public <T> T fromJson(Reader reader, Class<T> cls) throws JsonSyntaxException, JsonIOException {
        return (T) fromJson(reader, TypeToken.get((Class) cls));
    }

    public <T> T fromJson(Reader reader, Type type) throws JsonSyntaxException, JsonIOException {
        return (T) fromJson(reader, TypeToken.get(type));
    }

    public void toJson(Object obj, Appendable appendable) throws JsonIOException {
        if (obj != null) {
            toJson(obj, obj.getClass(), appendable);
        } else {
            toJson((JsonElement) JsonNull.INSTANCE, appendable);
        }
    }

    public <T> T fromJson(Reader reader, TypeToken<T> typeToken) throws JsonSyntaxException, JsonIOException {
        JsonReader jsonReaderNewJsonReader = newJsonReader(reader);
        T t10 = (T) fromJson(jsonReaderNewJsonReader, typeToken);
        assertFullConsumption(t10, jsonReaderNewJsonReader);
        return t10;
    }

    public void toJson(Object obj, Type type, Appendable appendable) throws JsonIOException {
        try {
            toJson(obj, type, newJsonWriter(Streams.writerForAppendable(appendable)));
        } catch (IOException e10) {
            throw new JsonIOException(e10);
        }
    }

    public <T> T fromJson(JsonReader jsonReader, Type type) throws JsonSyntaxException, JsonIOException {
        return (T) fromJson(jsonReader, TypeToken.get(type));
    }

    public <T> T fromJson(JsonReader jsonReader, TypeToken<T> typeToken) throws JsonSyntaxException, JsonIOException {
        boolean z10;
        Strictness strictness = jsonReader.getStrictness();
        Strictness strictness2 = this.strictness;
        if (strictness2 != null) {
            jsonReader.setStrictness(strictness2);
        } else if (jsonReader.getStrictness() == Strictness.LEGACY_STRICT) {
            jsonReader.setStrictness(Strictness.LENIENT);
        }
        try {
            try {
                try {
                    try {
                        jsonReader.peek();
                        z10 = false;
                        try {
                            TypeAdapter<T> adapter = getAdapter(typeToken);
                            T t10 = adapter.read(jsonReader);
                            Class clsWrap = Primitives.wrap(typeToken.getRawType());
                            if (t10 != null && !clsWrap.isInstance(t10)) {
                                throw new ClassCastException("Type adapter '" + adapter + "' returned wrong type; requested " + typeToken.getRawType() + " but got instance of " + t10.getClass() + "\nVerify that the adapter was registered for the correct type.");
                            }
                            return t10;
                        } catch (EOFException e10) {
                            e = e10;
                            if (z10) {
                                jsonReader.setStrictness(strictness);
                                return null;
                            }
                            throw new JsonSyntaxException(e);
                        }
                    } catch (EOFException e11) {
                        e = e11;
                        z10 = true;
                    }
                } catch (IOException e12) {
                    throw new JsonSyntaxException(e12);
                }
            } catch (AssertionError e13) {
                throw new AssertionError("AssertionError (GSON 2.14.0): " + e13.getMessage(), e13);
            } catch (IllegalStateException e14) {
                throw new JsonSyntaxException(e14);
            }
        } finally {
            jsonReader.setStrictness(strictness);
        }
    }

    public void toJson(Object obj, Type type, JsonWriter jsonWriter) throws JsonIOException {
        TypeAdapter adapter = getAdapter(TypeToken.get(type));
        Strictness strictness = jsonWriter.getStrictness();
        Strictness strictness2 = this.strictness;
        if (strictness2 != null) {
            jsonWriter.setStrictness(strictness2);
        } else if (jsonWriter.getStrictness() == Strictness.LEGACY_STRICT) {
            jsonWriter.setStrictness(Strictness.LENIENT);
        }
        boolean zIsHtmlSafe = jsonWriter.isHtmlSafe();
        boolean serializeNulls = jsonWriter.getSerializeNulls();
        jsonWriter.setHtmlSafe(this.htmlSafe);
        jsonWriter.setSerializeNulls(this.serializeNulls);
        try {
            try {
                try {
                    adapter.write(jsonWriter, obj);
                } catch (AssertionError e10) {
                    throw new AssertionError("AssertionError (GSON 2.14.0): " + e10.getMessage(), e10);
                }
            } catch (IOException e11) {
                throw new JsonIOException(e11);
            }
        } finally {
            jsonWriter.setStrictness(strictness);
            jsonWriter.setHtmlSafe(zIsHtmlSafe);
            jsonWriter.setSerializeNulls(serializeNulls);
        }
    }

    public <T> TypeAdapter<T> getAdapter(Class<T> cls) {
        return getAdapter(TypeToken.get((Class) cls));
    }

    public String toJson(JsonElement jsonElement) throws JsonIOException {
        StringBuilder sb2 = new StringBuilder();
        toJson(jsonElement, (Appendable) sb2);
        return sb2.toString();
    }

    public <T> T fromJson(JsonElement jsonElement, Class<T> cls) throws JsonSyntaxException {
        return (T) fromJson(jsonElement, TypeToken.get((Class) cls));
    }

    public <T> T fromJson(JsonElement jsonElement, Type type) throws JsonSyntaxException {
        return (T) fromJson(jsonElement, TypeToken.get(type));
    }

    public <T> T fromJson(JsonElement jsonElement, TypeToken<T> typeToken) throws JsonSyntaxException {
        if (jsonElement == null) {
            return null;
        }
        return (T) fromJson(new JsonTreeReader(jsonElement), typeToken);
    }

    public void toJson(JsonElement jsonElement, Appendable appendable) throws JsonIOException {
        try {
            toJson(jsonElement, newJsonWriter(Streams.writerForAppendable(appendable)));
        } catch (IOException e10) {
            throw new JsonIOException(e10);
        }
    }

    public void toJson(JsonElement jsonElement, JsonWriter jsonWriter) throws JsonIOException {
        Strictness strictness = jsonWriter.getStrictness();
        boolean zIsHtmlSafe = jsonWriter.isHtmlSafe();
        boolean serializeNulls = jsonWriter.getSerializeNulls();
        jsonWriter.setHtmlSafe(this.htmlSafe);
        jsonWriter.setSerializeNulls(this.serializeNulls);
        Strictness strictness2 = this.strictness;
        if (strictness2 != null) {
            jsonWriter.setStrictness(strictness2);
        } else if (jsonWriter.getStrictness() == Strictness.LEGACY_STRICT) {
            jsonWriter.setStrictness(Strictness.LENIENT);
        }
        try {
            try {
                Streams.write(jsonElement, jsonWriter);
            } catch (IOException e10) {
                throw new JsonIOException(e10);
            } catch (AssertionError e11) {
                throw new AssertionError("AssertionError (GSON 2.14.0): " + e11.getMessage(), e11);
            }
        } finally {
            jsonWriter.setStrictness(strictness);
            jsonWriter.setHtmlSafe(zIsHtmlSafe);
            jsonWriter.setSerializeNulls(serializeNulls);
        }
    }
}
