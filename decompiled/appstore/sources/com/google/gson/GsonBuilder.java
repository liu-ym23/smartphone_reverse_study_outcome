package com.google.gson;

import com.google.gson.internal.C$Gson$Preconditions;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.bind.TreeTypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class GsonBuilder {
    private boolean complexMapKeySerialization;
    private String datePattern;
    private int dateStyle;
    private boolean escapeHtmlChars;
    private Excluder excluder;
    private final List<TypeAdapterFactory> factories;
    private FieldNamingStrategy fieldNamingPolicy;
    private boolean generateNonExecutableJson;
    private final List<TypeAdapterFactory> hierarchyFactories;
    private final Map<Type, InstanceCreator<?>> instanceCreators;
    private boolean lenient;
    private LongSerializationPolicy longSerializationPolicy;
    private boolean prettyPrinting;
    private boolean serializeNulls;
    private boolean serializeSpecialFloatingPointValues;
    private int timeStyle;

    public GsonBuilder() {
        this.excluder = Excluder.DEFAULT;
        this.longSerializationPolicy = LongSerializationPolicy.DEFAULT;
        this.fieldNamingPolicy = FieldNamingPolicy.IDENTITY;
        this.instanceCreators = new HashMap();
        this.factories = new ArrayList();
        this.hierarchyFactories = new ArrayList();
        this.serializeNulls = false;
        this.dateStyle = 2;
        this.timeStyle = 2;
        this.complexMapKeySerialization = false;
        this.serializeSpecialFloatingPointValues = false;
        this.escapeHtmlChars = true;
        this.prettyPrinting = false;
        this.generateNonExecutableJson = false;
        this.lenient = false;
    }

    private void addTypeAdaptersForDate(String r10, int r11, int r12, List<TypeAdapterFactory> r13) {
        if (r10 == null) goto L8;
        if ("".equals(r10.trim()) == true) goto L8;
        DefaultDateTypeAdapter r14 = new DefaultDateTypeAdapter(Date.class, r10);
        DefaultDateTypeAdapter r15 = new DefaultDateTypeAdapter(Timestamp.class, r10);
        DefaultDateTypeAdapter r16 = new DefaultDateTypeAdapter(java.sql.Date.class, r10);
    L11:
        r13.add(TypeAdapters.newFactory(Date.class, r14));
        r13.add(TypeAdapters.newFactory(Timestamp.class, r15));
        r13.add(TypeAdapters.newFactory(java.sql.Date.class, r16));
        return;
    L8:
        if (r11 == 2) goto L13;
        if (r12 == 2) goto L14;
        DefaultDateTypeAdapter r17 = new DefaultDateTypeAdapter(Date.class, r11, r12);
        DefaultDateTypeAdapter r18 = new DefaultDateTypeAdapter(Timestamp.class, r11, r12);
        DefaultDateTypeAdapter r19 = new DefaultDateTypeAdapter(java.sql.Date.class, r11, r12);
        r14 = r17;
        r15 = r18;
        r16 = r19;
        goto L11
    L14:
        return;
    }

    public GsonBuilder addDeserializationExclusionStrategy(ExclusionStrategy r10) {
        this.excluder = this.excluder.withExclusionStrategy(r10, false, true);
        return this;
    }

    public GsonBuilder addSerializationExclusionStrategy(ExclusionStrategy r10) {
        this.excluder = this.excluder.withExclusionStrategy(r10, true, false);
        return this;
    }

    public Gson create() {
        List<TypeAdapterFactory> r10 = new ArrayList((this.factories.size() + this.hierarchyFactories.size()) + 3);
        r10.addAll(this.factories);
        Collections.reverse(r10);
        ArrayList r11 = new ArrayList(this.hierarchyFactories);
        Collections.reverse(r11);
        r10.addAll(r11);
        addTypeAdaptersForDate(this.datePattern, this.dateStyle, this.timeStyle, r10);
        return new Gson(this.excluder, this.fieldNamingPolicy, this.instanceCreators, this.serializeNulls, this.complexMapKeySerialization, this.generateNonExecutableJson, this.escapeHtmlChars, this.prettyPrinting, this.lenient, this.serializeSpecialFloatingPointValues, this.longSerializationPolicy, this.datePattern, this.dateStyle, this.timeStyle, this.factories, this.hierarchyFactories, r10);
    }

    public GsonBuilder disableHtmlEscaping() {
        this.escapeHtmlChars = false;
        return this;
    }

    public GsonBuilder disableInnerClassSerialization() {
        this.excluder = this.excluder.disableInnerClassSerialization();
        return this;
    }

    public GsonBuilder enableComplexMapKeySerialization() {
        this.complexMapKeySerialization = true;
        return this;
    }

    public GsonBuilder excludeFieldsWithModifiers(int... r10) {
        this.excluder = this.excluder.withModifiers(r10);
        return this;
    }

    public GsonBuilder excludeFieldsWithoutExposeAnnotation() {
        this.excluder = this.excluder.excludeFieldsWithoutExposeAnnotation();
        return this;
    }

    public GsonBuilder generateNonExecutableJson() {
        this.generateNonExecutableJson = true;
        return this;
    }

    public GsonBuilder registerTypeAdapter(Type r10, Object r11) {
        boolean r12 = r11 instanceof JsonSerializer;
        if (r12 == false) goto L5;
    L12:
        boolean r13 = true;
    L13:
        C$Gson$Preconditions.checkArgument(r13);
        if ((r11 instanceof InstanceCreator) == false) goto L16;
        this.instanceCreators.put(r10, (InstanceCreator) r11);
    L16:
        if (r12 == false) goto L18;
    L19:
        TypeToken<?> r14 = TypeToken.get(r10);
        this.factories.add(TreeTypeAdapter.newFactoryWithMatchRawType(r14, r11));
    L21:
        if ((r11 instanceof TypeAdapter) == false) goto L23;
        this.factories.add(TypeAdapters.newFactory(TypeToken.get(r10), (TypeAdapter) r11));
    L23:
        return this;
    L18:
        if ((r11 instanceof JsonDeserializer) == false) goto L21;
    L5:
        if ((r11 instanceof JsonDeserializer) == true) goto L12;
        if ((r11 instanceof InstanceCreator) == true) goto L12;
        if ((r11 instanceof TypeAdapter) == true) goto L12;
        r13 = false;
        goto L13
    }

    public GsonBuilder registerTypeAdapterFactory(TypeAdapterFactory r10) {
        this.factories.add(r10);
        return this;
    }

    public GsonBuilder registerTypeHierarchyAdapter(Class<?> r10, Object r11) {
        boolean r12 = r11 instanceof JsonSerializer;
        if (r12 == false) goto L5;
    L10:
        boolean r13 = true;
    L11:
        C$Gson$Preconditions.checkArgument(r13);
        if ((r11 instanceof JsonDeserializer) == true) goto L14;
        if (r12 == true) goto L14;
    L16:
        if ((r11 instanceof TypeAdapter) == false) goto L18;
        this.factories.add(TypeAdapters.newTypeHierarchyFactory(r10, (TypeAdapter) r11));
    L18:
        return this;
    L14:
        this.hierarchyFactories.add(TreeTypeAdapter.newTypeHierarchyFactory(r10, r11));
        goto L16
    L5:
        if ((r11 instanceof JsonDeserializer) == true) goto L10;
        if ((r11 instanceof TypeAdapter) == true) goto L10;
        r13 = false;
        goto L11
    }

    public GsonBuilder serializeNulls() {
        this.serializeNulls = true;
        return this;
    }

    public GsonBuilder serializeSpecialFloatingPointValues() {
        this.serializeSpecialFloatingPointValues = true;
        return this;
    }

    public GsonBuilder setDateFormat(String r10) {
        this.datePattern = r10;
        return this;
    }

    public GsonBuilder setExclusionStrategies(ExclusionStrategy... r10) {
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        ExclusionStrategy r13 = r10[r12];
        this.excluder = this.excluder.withExclusionStrategy(r13, true, true);
        r12 = r12 + 1;
        goto L3
    L5:
        return this;
    }

    public GsonBuilder setFieldNamingPolicy(FieldNamingPolicy r10) {
        this.fieldNamingPolicy = r10;
        return this;
    }

    public GsonBuilder setFieldNamingStrategy(FieldNamingStrategy r10) {
        this.fieldNamingPolicy = r10;
        return this;
    }

    public GsonBuilder setLenient() {
        this.lenient = true;
        return this;
    }

    public GsonBuilder setLongSerializationPolicy(LongSerializationPolicy r10) {
        this.longSerializationPolicy = r10;
        return this;
    }

    public GsonBuilder setPrettyPrinting() {
        this.prettyPrinting = true;
        return this;
    }

    public GsonBuilder setVersion(double r10) {
        this.excluder = this.excluder.withVersion(r10);
        return this;
    }

    public GsonBuilder setDateFormat(int r10) {
        this.dateStyle = r10;
        this.datePattern = null;
        return this;
    }

    public GsonBuilder setDateFormat(int r10, int r11) {
        this.dateStyle = r10;
        this.timeStyle = r11;
        this.datePattern = null;
        return this;
    }

    public GsonBuilder(Gson r10) {
        this.excluder = Excluder.DEFAULT;
        this.longSerializationPolicy = LongSerializationPolicy.DEFAULT;
        this.fieldNamingPolicy = FieldNamingPolicy.IDENTITY;
        HashMap r11 = new HashMap();
        this.instanceCreators = r11;
        ArrayList r12 = new ArrayList();
        this.factories = r12;
        ArrayList r13 = new ArrayList();
        this.hierarchyFactories = r13;
        this.serializeNulls = false;
        this.dateStyle = 2;
        this.timeStyle = 2;
        this.complexMapKeySerialization = false;
        this.serializeSpecialFloatingPointValues = false;
        this.escapeHtmlChars = true;
        this.prettyPrinting = false;
        this.generateNonExecutableJson = false;
        this.lenient = false;
        this.excluder = r10.excluder;
        this.fieldNamingPolicy = r10.fieldNamingStrategy;
        r11.putAll(r10.instanceCreators);
        this.serializeNulls = r10.serializeNulls;
        this.complexMapKeySerialization = r10.complexMapKeySerialization;
        this.generateNonExecutableJson = r10.generateNonExecutableJson;
        this.escapeHtmlChars = r10.htmlSafe;
        this.prettyPrinting = r10.prettyPrinting;
        this.lenient = r10.lenient;
        this.serializeSpecialFloatingPointValues = r10.serializeSpecialFloatingPointValues;
        this.longSerializationPolicy = r10.longSerializationPolicy;
        this.datePattern = r10.datePattern;
        this.dateStyle = r10.dateStyle;
        this.timeStyle = r10.timeStyle;
        r12.addAll(r10.builderFactories);
        r13.addAll(r10.builderHierarchyFactories);
    }
}
