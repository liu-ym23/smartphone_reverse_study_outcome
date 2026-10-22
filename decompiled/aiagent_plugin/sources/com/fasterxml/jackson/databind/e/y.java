package com.fasterxml.jackson.databind.e;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonKey;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonMerge;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeId;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonTypeIdResolver;
import com.fasterxml.jackson.databind.annotation.JsonTypeResolver;
import com.fasterxml.jackson.databind.annotation.JsonValueInstantiator;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: JacksonAnnotationIntrospector.java */
/* JADX INFO: loaded from: classes2.dex */
public class y extends com.fasterxml.jackson.databind.b implements Serializable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Class<? extends Annotation>[] f12682c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Class<? extends Annotation>[] f12683d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final com.fasterxml.jackson.databind.d.b f12684e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected transient com.fasterxml.jackson.databind.l.n<Class<?>, Boolean> f12685a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected boolean f12686b;

    /* JADX INFO: renamed from: com.fasterxml.jackson.databind.e.y$1, reason: invalid class name */
    /* JADX INFO: compiled from: JacksonAnnotationIntrospector.java */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f12687a = null;

        static {
            int[] r0 = new int[JsonSerialize.Inclusion.values().length];
            f12687a = r0;
            r0[JsonSerialize.Inclusion.ALWAYS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            f12687a[JsonSerialize.Inclusion.NON_NULL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            f12687a[JsonSerialize.Inclusion.NON_DEFAULT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            f12687a[JsonSerialize.Inclusion.NON_EMPTY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            f12687a[JsonSerialize.Inclusion.DEFAULT_INCLUSION.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    @Override // com.fasterxml.jackson.databind.b
    public com.fasterxml.jackson.databind.x a(com.fasterxml.jackson.databind.a.m<?> r1, h r2, com.fasterxml.jackson.databind.x r3) {
        return null;
    }

    static {
        f12682c = (Class[]) ZeusTransformUtils.preCheckCast(new Class[]{JsonSerialize.class, JsonView.class, JsonFormat.class, JsonTypeInfo.class, JsonRawValue.class, JsonUnwrapped.class, JsonBackReference.class, JsonManagedReference.class}, Class[].class, "com.obric.aiagent.plugin");
        f12683d = (Class[]) ZeusTransformUtils.preCheckCast(new Class[]{JsonDeserialize.class, JsonView.class, JsonFormat.class, JsonTypeInfo.class, JsonUnwrapped.class, JsonBackReference.class, JsonManagedReference.class, JsonMerge.class}, Class[].class, "com.obric.aiagent.plugin");
        com.fasterxml.jackson.databind.d.b r0 = com.fasterxml.jackson.databind.d.b.a();     // Catch: Throwable -> L5
    L6:
        f12684e = r0;
        return;
    L5:
        r0 = null;
        goto L6
    }

    public y() {
        this.f12685a = new com.fasterxml.jackson.databind.l.n(48, 48);
        this.f12686b = true;
    }

    @Override // com.fasterxml.jackson.databind.b
    public boolean a(Annotation r4) {
        Class<? extends Annotation> r5 = ((Annotation) ZeusTransformUtils.wrapperContextForParams(r4, Annotation.class, "com.obric.aiagent.plugin")).annotationType();
        Boolean r0 = (Boolean) ZeusTransformUtils.preCheckCast(this.f12685a.a(r5), Boolean.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L10;
        if (r5.getAnnotation(JacksonAnnotationsInside.class) == null) goto L7;
        boolean r1 = true;
    L8:
        r0 = Boolean.valueOf(r1);
        this.f12685a.b(r5, r0);
        goto L10
    L7:
        r1 = false;
    L10:
        return r0.booleanValue();
    }

    @Override // com.fasterxml.jackson.databind.b
    public String[] a(Class<?> r8, Enum<?>[] r9, String[] r10) {
        Field[] r7 = r8.getDeclaredFields();
        int r11 = r7.length;
        int r0 = 0;
        HashMap r1 = null;
        int r2 = 0;
    L4:
        if (r2 >= r11) goto L18;
        Field r4 = r7[r2];
        if (r4.isEnumConstant() == false) goto L17;
        JsonProperty r3 = (JsonProperty) ZeusTransformUtils.preCheckCast(r4.getAnnotation(JsonProperty.class), JsonProperty.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L17;
        String r5 = r3.value();
        if (r5.isEmpty() == true) goto L17;
        if (r1 != null) goto L16;
        r1 = new HashMap();
    L16:
        r1.put(r4.getName(), r5);
    L17:
        r2 = r2 + 1;
        goto L4
    L18:
        if (r1 == null) goto L25;
        int r12 = r9.length;
    L20:
        if (r0 >= r12) goto L25;
        String r13 = (String) ZeusTransformUtils.preCheckCast(r1.get(r9[r0].name()), String.class, "com.obric.aiagent.plugin");
        if (r13 == null) goto L24;
        r10[r0] = r13;
    L24:
        r0 = r0 + 1;
    L25:
        return r10;
    }

    @Override // com.fasterxml.jackson.databind.b
    public void a(Class<?> r8, Enum<?>[] r9, String[][] r10) {
        Field[] r7 = r8.getDeclaredFields();
        int r11 = r7.length;
        int r1 = 0;
    L3:
        if (r1 >= r11) goto L17;
        Field r2 = r7[r1];
        if (r2.isEnumConstant() == false) goto L16;
        JsonAlias r3 = (JsonAlias) ZeusTransformUtils.preCheckCast(r2.getAnnotation(JsonAlias.class), JsonAlias.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L16;
        String[] r4 = r3.value();
        if (r4.length == 0) goto L16;
        String r5 = r2.getName();
        int r6 = r9.length;
        int r12 = 0;
    L11:
        if (r12 >= r6) goto L16;
        if (r5.equals(r9[r12].name()) == false) goto L15;
        r10[r12] = r4;
    L15:
        r12 = r12 + 1;
    L16:
        r1 = r1 + 1;
        goto L3
    }

    @Override // com.fasterxml.jackson.databind.b
    public Enum<?> a(Class<Enum<?>> r1) {
        return com.fasterxml.jackson.databind.l.h.a(r1, JsonEnumDefaultValue.class);
    }

    @Override // com.fasterxml.jackson.databind.b
    public com.fasterxml.jackson.databind.x a(d r3) {
        JsonRootName r2 = (JsonRootName) ZeusTransformUtils.preCheckCast(a(r3, JsonRootName.class), JsonRootName.class, "com.obric.aiagent.plugin");
        String r4 = null;
        if (r2 != null) goto L5;
        return null;
    L5:
        String r0 = r2.namespace();
        if (r0 != null) goto L8;
    L10:
        r4 = r0;
    L12:
        return com.fasterxml.jackson.databind.x.a(r2.value(), r4);
    L8:
        if (r0.isEmpty() == false) goto L10;
        goto L10
    }

    @Override // com.fasterxml.jackson.databind.b
    public Boolean b(d r2) {
        JsonIgnoreType r1 = (JsonIgnoreType) ZeusTransformUtils.preCheckCast(a(r2, JsonIgnoreType.class), JsonIgnoreType.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L6;
        return null;
    L6:
        return Boolean.valueOf(r1.value());
    }

    @Override // com.fasterxml.jackson.databind.b
    public JsonIgnoreProperties.Value a(com.fasterxml.jackson.databind.a.m<?> r1, b r2) {
        JsonIgnoreProperties r0 = (JsonIgnoreProperties) ZeusTransformUtils.preCheckCast(a(r2, JsonIgnoreProperties.class), JsonIgnoreProperties.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L7;
        return JsonIgnoreProperties.Value.empty();
    L7:
        return JsonIgnoreProperties.Value.from(r0);
    }

    @Override // com.fasterxml.jackson.databind.b
    @Deprecated
    public JsonIgnoreProperties.Value c(b r2) {
        return a(null, r2);
    }

    @Override // com.fasterxml.jackson.databind.b
    public JsonIncludeProperties.Value b(com.fasterxml.jackson.databind.a.m<?> r1, b r2) {
        JsonIncludeProperties r0 = (JsonIncludeProperties) ZeusTransformUtils.preCheckCast(a(r2, JsonIncludeProperties.class), JsonIncludeProperties.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L7;
        return JsonIncludeProperties.Value.all();
    L7:
        return JsonIncludeProperties.Value.from(r0);
    }

    @Override // com.fasterxml.jackson.databind.b
    public Object b(b r2) {
        JsonFilter r1 = (JsonFilter) ZeusTransformUtils.preCheckCast(a(r2, JsonFilter.class), JsonFilter.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L7;
        String r3 = r1.value();
        if (r3.isEmpty() == true) goto L9;
        return r3;
    L9:
        return null;
    L7:
        return null;
    }

    @Override // com.fasterxml.jackson.databind.b
    public Object c(d r2) {
        JsonNaming r1 = (JsonNaming) ZeusTransformUtils.preCheckCast(a(r2, JsonNaming.class), JsonNaming.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L6;
        return null;
    L6:
        return r1.value();
    }

    @Override // com.fasterxml.jackson.databind.b
    public ai<?> a(d r3, ai<?> r4) {
        ai<?> r5 = (ai) ZeusTransformUtils.wrapperContextForParams(r4, ai.class, "com.obric.aiagent.plugin");
        JsonAutoDetect r2 = (JsonAutoDetect) ZeusTransformUtils.preCheckCast(a(r3, JsonAutoDetect.class), JsonAutoDetect.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L6;
        return r5;
    L6:
        return r5.a(r2);
    }

    @Override // com.fasterxml.jackson.databind.b
    public String g(j r1) {
        com.fasterxml.jackson.databind.x r0 = I(r1);
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.b();
    }

    @Override // com.fasterxml.jackson.databind.b
    public List<com.fasterxml.jackson.databind.x> k(b r4) {
        JsonAlias r3 = (JsonAlias) ZeusTransformUtils.preCheckCast(a(r4, JsonAlias.class), JsonAlias.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L6;
        return null;
    L6:
        String[] r5 = r3.value();
        int r6 = r5.length;
        if (r6 == 0) goto L9;
        ArrayList r0 = new ArrayList(r6);
        int r1 = 0;
    L11:
        if (r1 >= r6) goto L13;
        r0.add(com.fasterxml.jackson.databind.x.a(r5[r1]));
        r1 = r1 + 1;
        goto L11
    L13:
        return r0;
    L9:
        return Collections.emptyList();
    }

    @Override // com.fasterxml.jackson.databind.b
    public boolean d(j r1) {
        return H(r1);
    }

    @Override // com.fasterxml.jackson.databind.b
    public Boolean f(j r2) {
        JsonProperty r1 = (JsonProperty) ZeusTransformUtils.preCheckCast(a(r2, JsonProperty.class), JsonProperty.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L5;
        return null;
    L5:
        return Boolean.valueOf(r1.required());
    }

    @Override // com.fasterxml.jackson.databind.b
    public JsonProperty.Access l(b r2) {
        JsonProperty r1 = (JsonProperty) ZeusTransformUtils.preCheckCast(a(r2, JsonProperty.class), JsonProperty.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L5;
        return null;
    L5:
        return r1.access();
    }

    @Override // com.fasterxml.jackson.databind.b
    public String i(b r2) {
        JsonPropertyDescription r1 = (JsonPropertyDescription) ZeusTransformUtils.preCheckCast(a(r2, JsonPropertyDescription.class), JsonPropertyDescription.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L6;
        return null;
    L6:
        return r1.value();
    }

    @Override // com.fasterxml.jackson.databind.b
    public Integer j(b r2) {
        JsonProperty r1 = (JsonProperty) ZeusTransformUtils.preCheckCast(a(r2, JsonProperty.class), JsonProperty.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L8;
        int r3 = r1.index();
        if (r3 != (-1)) goto L7;
        return null;
    L7:
        return Integer.valueOf(r3);
    L8:
        return null;
    }

    @Override // com.fasterxml.jackson.databind.b
    public String h(b r2) {
        JsonProperty r1 = (JsonProperty) ZeusTransformUtils.preCheckCast(a(r2, JsonProperty.class), JsonProperty.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L5;
        return null;
    L5:
        String r3 = r1.defaultValue();
        if (r3.isEmpty() == false) goto L9;
        return null;
    L9:
        return r3;
    }

    @Override // com.fasterxml.jackson.databind.b
    public JsonFormat.Value f(b r2) {
        JsonFormat r1 = (JsonFormat) ZeusTransformUtils.preCheckCast(a(r2, JsonFormat.class), JsonFormat.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L6;
        return null;
    L6:
        return JsonFormat.Value.from(r1);
    }

    @Override // com.fasterxml.jackson.databind.b
    public com.fasterxml.jackson.databind.b.a b(j r4) {
        JsonManagedReference r0 = (JsonManagedReference) ZeusTransformUtils.preCheckCast(a(r4, JsonManagedReference.class), JsonManagedReference.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
        JsonBackReference r3 = (JsonBackReference) ZeusTransformUtils.preCheckCast(a(r4, JsonBackReference.class), JsonBackReference.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L9;
        return null;
    L9:
        return com.fasterxml.jackson.databind.b.a.b(r3.value());
    L5:
        return com.fasterxml.jackson.databind.b.a.a(r0.value());
    }

    @Override // com.fasterxml.jackson.databind.b
    public com.fasterxml.jackson.databind.l.q c(j r2) {
        JsonUnwrapped r1 = (JsonUnwrapped) ZeusTransformUtils.preCheckCast(a(r2, JsonUnwrapped.class), JsonUnwrapped.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L5;
        return null;
    L5:
        if (r1.enabled() == true) goto L8;
        return null;
    L8:
        return com.fasterxml.jackson.databind.l.q.a(r1.prefix(), r1.suffix());
    }

    @Override // com.fasterxml.jackson.databind.b
    public JacksonInject.Value e(j r3) {
        JacksonInject r2 = (JacksonInject) ZeusTransformUtils.preCheckCast(a(r3, JacksonInject.class), JacksonInject.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L6;
        return null;
    L6:
        JacksonInject.Value r4 = JacksonInject.Value.from(r2);
        if (r4.hasId() == false) goto L9;
        return r4;
    L9:
        if (ZeusTransformUtils.instanceOf(r3, k.class) == true) goto L11;
        String r5 = r3.c().getName();
    L16:
        return r4.withId(r5);
    L11:
        k r0 = (k) ZeusTransformUtils.preCheckCast(r3, k.class, "com.obric.aiagent.plugin");
        if (r0.e() != 0) goto L14;
        r5 = r3.c().getName();
        goto L16
    L14:
        r5 = r0.a(0).getName();
        goto L16
    }

    @Override // com.fasterxml.jackson.databind.b
    @Deprecated
    public Object h(j r1) {
        JacksonInject.Value r0 = e(r1);
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.getId();
    }

    @Override // com.fasterxml.jackson.databind.b
    public Class<?>[] e(b r2) {
        JsonView r1 = (JsonView) ZeusTransformUtils.preCheckCast(a(r2, JsonView.class), JsonView.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L6;
        return null;
    L6:
        return r1.value();
    }

    @Override // com.fasterxml.jackson.databind.b
    public k a(com.fasterxml.jackson.databind.a.m<?> r3, k r4, k r5) {
        Class<?> r6 = r4.a(0);
        Class<?> r2 = r5.a(0);
        if (r6.isPrimitive() == false) goto L9;
        if (r2.isPrimitive() == true) goto L7;
        return r4;
    L7:
        return null;
    L9:
        if (r2.isPrimitive() == false) goto L12;
        return r5;
    L12:
        if (r6 != String.class) goto L17;
        if (r2 == String.class) goto L19;
        return r4;
    L19:
        return null;
    L17:
        if (r2 != String.class) goto L19;
        return r5;
    }

    @Override // com.fasterxml.jackson.databind.b
    public com.fasterxml.jackson.databind.h.g<?> a(com.fasterxml.jackson.databind.a.m<?> r1, d r2, com.fasterxml.jackson.databind.k r3) {
        return c(r1, r2, r3);
    }

    @Override // com.fasterxml.jackson.databind.b
    public com.fasterxml.jackson.databind.h.g<?> a(com.fasterxml.jackson.databind.a.m<?> r2, j r3, com.fasterxml.jackson.databind.k r4) {
        if (r4.q() == false) goto L5;
        return null;
    L5:
        if (r4.a() == false) goto L8;
        return null;
    L8:
        return c(r2, r3, r4);
    }

    @Override // com.fasterxml.jackson.databind.b
    public com.fasterxml.jackson.databind.h.g<?> b(com.fasterxml.jackson.databind.a.m<?> r2, j r3, com.fasterxml.jackson.databind.k r4) {
        if (r4.x() == null) goto L7;
        return c(r2, r3, r4);
    L7:
        throw new IllegalArgumentException("Must call method with a container or reference type (got " + r4 + ")");
    }

    @Override // com.fasterxml.jackson.databind.b
    public List<com.fasterxml.jackson.databind.h.b> d(b r11) {
        JsonSubTypes r10 = (JsonSubTypes) ZeusTransformUtils.preCheckCast(a(r11, JsonSubTypes.class), JsonSubTypes.class, "com.obric.aiagent.plugin");
        if (r10 != null) goto L6;
        return null;
    L6:
        JsonSubTypes.Type[] r12 = r10.value();
        ArrayList r13 = new ArrayList(r12.length);
        int r0 = r12.length;
        int r2 = 0;
    L7:
        if (r2 >= r0) goto L12;
        JsonSubTypes.Type r3 = r12[r2];
        r13.add(new com.fasterxml.jackson.databind.h.b(r3.value(), r3.name()));
        String[] r4 = r3.names();
        int r5 = r4.length;
        int r6 = 0;
    L9:
        if (r6 >= r5) goto L11;
        r13.add(new com.fasterxml.jackson.databind.h.b(r3.value(), r4[r6]));
        r6 = r6 + 1;
        goto L9
    L11:
        r2 = r2 + 1;
        goto L7
    L12:
        return r13;
    }

    @Override // com.fasterxml.jackson.databind.b
    public String d(d r2) {
        JsonTypeName r1 = (JsonTypeName) ZeusTransformUtils.preCheckCast(a(r2, JsonTypeName.class), JsonTypeName.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L6;
        return null;
    L6:
        return r1.value();
    }

    @Override // com.fasterxml.jackson.databind.b
    public Boolean a(j r2) {
        return Boolean.valueOf(b(r2, JsonTypeId.class));
    }

    @Override // com.fasterxml.jackson.databind.b
    public ac a(b r4) {
        JsonIdentityInfo r3 = (JsonIdentityInfo) ZeusTransformUtils.preCheckCast(a(r4, JsonIdentityInfo.class), JsonIdentityInfo.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L5;
        return null;
    L5:
        if (r3.generator() != ObjectIdGenerators.None.class) goto L8;
        return null;
    L8:
        return new ac(com.fasterxml.jackson.databind.x.a(r3.property()), r3.scope(), r3.generator(), r3.resolver());
    }

    @Override // com.fasterxml.jackson.databind.b
    public ac a(b r2, ac r3) {
        JsonIdentityReference r1 = (JsonIdentityReference) ZeusTransformUtils.preCheckCast(a(r2, JsonIdentityReference.class), JsonIdentityReference.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L5;
        return r3;
    L5:
        if (r3 != null) goto L8;
        r3 = ac.a();
    L8:
        return r3.a(r1.alwaysAsId());
    }

    @Override // com.fasterxml.jackson.databind.b
    public Object m(b r4) {
        JsonSerialize r0 = (JsonSerialize) ZeusTransformUtils.preCheckCast(a(r4, JsonSerialize.class), JsonSerialize.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L7;
        Class<? extends com.fasterxml.jackson.databind.p> r1 = r0.using();
        if (r1 == com.fasterxml.jackson.databind.p.a.class) goto L7;
        return r1;
    L7:
        JsonRawValue r3 = (JsonRawValue) ZeusTransformUtils.preCheckCast(a(r4, JsonRawValue.class), JsonRawValue.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L10;
        return null;
    L10:
        if (r3.value() == true) goto L12;
        return null;
    L12:
        return new com.fasterxml.jackson.databind.j.b.z(r4.c());
    }

    @Override // com.fasterxml.jackson.databind.b
    public Object n(b r2) {
        JsonSerialize r1 = (JsonSerialize) ZeusTransformUtils.preCheckCast(a(r2, JsonSerialize.class), JsonSerialize.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L7;
        Class<? extends com.fasterxml.jackson.databind.p> r3 = r1.keyUsing();
        if (r3 == com.fasterxml.jackson.databind.p.a.class) goto L9;
        return r3;
    L9:
        return null;
    L7:
        return null;
    }

    @Override // com.fasterxml.jackson.databind.b
    public Object o(b r2) {
        JsonSerialize r1 = (JsonSerialize) ZeusTransformUtils.preCheckCast(a(r2, JsonSerialize.class), JsonSerialize.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L7;
        Class<? extends com.fasterxml.jackson.databind.p> r3 = r1.contentUsing();
        if (r3 == com.fasterxml.jackson.databind.p.a.class) goto L9;
        return r3;
    L9:
        return null;
    L7:
        return null;
    }

    @Override // com.fasterxml.jackson.databind.b
    public Object p(b r2) {
        JsonSerialize r1 = (JsonSerialize) ZeusTransformUtils.preCheckCast(a(r2, JsonSerialize.class), JsonSerialize.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L7;
        Class<? extends com.fasterxml.jackson.databind.p> r3 = r1.nullsUsing();
        if (r3 == com.fasterxml.jackson.databind.p.a.class) goto L9;
        return r3;
    L9:
        return null;
    L7:
        return null;
    }

    @Override // com.fasterxml.jackson.databind.b
    public JsonInclude.Value s(b r4) {
        JsonInclude r0 = (JsonInclude) ZeusTransformUtils.preCheckCast(a(r4, JsonInclude.class), JsonInclude.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
        JsonInclude.Value r1 = JsonInclude.Value.empty();
    L7:
        if (r1.getValueInclusion() == JsonInclude.Include.USE_DEFAULTS) goto L9;
        return r1;
    L9:
        return a(r4, r1);
    L5:
        r1 = JsonInclude.Value.from(r0);
        goto L7
    }

    private JsonInclude.Value a(b r2, JsonInclude.Value r3) {
        JsonSerialize r1 = (JsonSerialize) ZeusTransformUtils.preCheckCast(a(r2, JsonSerialize.class), JsonSerialize.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L21;
        int r4 = AnonymousClass1.f12687a[r1.include().ordinal()];
        if (r4 == 1) goto L20;
        if (r4 == 2) goto L18;
        if (r4 == 3) goto L16;
        if (r4 != 4) goto L21;
        return r3.withValueInclusion(JsonInclude.Include.NON_EMPTY);
    L16:
        return r3.withValueInclusion(JsonInclude.Include.NON_DEFAULT);
    L18:
        return r3.withValueInclusion(JsonInclude.Include.NON_NULL);
    L20:
        return r3.withValueInclusion(JsonInclude.Include.ALWAYS);
    L21:
        return r3;
    }

    @Override // com.fasterxml.jackson.databind.b
    public JsonSerialize.Typing q(b r2) {
        JsonSerialize r1 = (JsonSerialize) ZeusTransformUtils.preCheckCast(a(r2, JsonSerialize.class), JsonSerialize.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L6;
        return null;
    L6:
        return r1.typing();
    }

    @Override // com.fasterxml.jackson.databind.b
    public Object r(b r3) {
        JsonSerialize r4 = (JsonSerialize) ZeusTransformUtils.preCheckCast(a(r3, JsonSerialize.class), JsonSerialize.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L6;
        return null;
    L6:
        return a(r4.converter(), com.fasterxml.jackson.databind.l.j.a.class);
    }

    @Override // com.fasterxml.jackson.databind.b
    public Object i(j r3) {
        JsonSerialize r4 = (JsonSerialize) ZeusTransformUtils.preCheckCast(a(r3, JsonSerialize.class), JsonSerialize.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L6;
        return null;
    L6:
        return a(r4.contentConverter(), com.fasterxml.jackson.databind.l.j.a.class);
    }

    @Override // com.fasterxml.jackson.databind.b
    public com.fasterxml.jackson.databind.k a(com.fasterxml.jackson.databind.a.m<?> r13, b r14, com.fasterxml.jackson.databind.k r15) {
        com.fasterxml.jackson.databind.k.o r16 = r13.o();
        JsonSerialize r0 = (JsonSerialize) ZeusTransformUtils.preCheckCast(a(r14, JsonSerialize.class), JsonSerialize.class, "com.obric.aiagent.plugin");
        Class<?> r1 = null;
        if (r0 != null) goto L5;
        Class<?> r3 = null;
    L7:
        if (r3 == null) goto L27;
        if (r15.a(r3) == false) goto L11;
        r15 = r15.d();
        goto L27
    L11:
        Class<?> r9 = r15.e();
    L23:
        e = move-exception;
        throw a(e, String.format("Failed to widen type %s with annotation (value %s), from '%s': %s", new Object[]{r15, r3.getName(), r14.b(), e.getMessage()}));
    L13:
        if (r3.isAssignableFrom(r9) == false) goto L16;
        r15 = r16.b(r15, r3);     // Catch: IllegalArgumentException -> L23
        goto L27
    L16:
        if (r9.isAssignableFrom(r3) == false) goto L19;
        r15 = r16.a(r15, r3);     // Catch: IllegalArgumentException -> L23
        goto L27
    L19:
        if (b(r9, r3) == false) goto L22;
        r15 = r15.d();     // Catch: IllegalArgumentException -> L23
        goto L27
    L22:
        throw a(String.format("Cannot refine serialization type %s into %s; types not related", new Object[]{r15, r3.getName()}));     // Catch: IllegalArgumentException -> L23
    L27:
        if (r15.s() == false) goto L52;
        com.fasterxml.jackson.databind.k r4 = r15.w();
        if (r0 != null) goto L31;
        Class<?> r10 = null;
    L32:
        if (r10 == null) goto L52;
        if (r4.a(r10) == false) goto L36;
        com.fasterxml.jackson.databind.k r5 = r4.d();
    L46:
        r15 = ((com.fasterxml.jackson.databind.k.g) ZeusTransformUtils.preCheckCast(r15, com.fasterxml.jackson.databind.k.g.class, "com.obric.aiagent.plugin")).c(r5);
        goto L52
    L36:
        Class<?> r11 = r4.e();
    L49:
        e = move-exception;
        throw a(e, String.format("Failed to widen key type of %s with concrete-type annotation (value %s), from '%s': %s", new Object[]{r15, r10.getName(), r14.b(), e.getMessage()}));
    L38:
        if (r10.isAssignableFrom(r11) == false) goto L41;
        r5 = r16.b(r4, r10);     // Catch: IllegalArgumentException -> L49
        goto L46
    L41:
        if (r11.isAssignableFrom(r10) == false) goto L44;
        r5 = r16.a(r4, r10);     // Catch: IllegalArgumentException -> L49
        goto L46
    L44:
        if (b(r11, r10) == false) goto L48;
        r5 = r4.d();     // Catch: IllegalArgumentException -> L49
        goto L46
    L48:
        throw a(String.format("Cannot refine serialization key type %s into %s; types not related", new Object[]{r4, r10.getName()}));     // Catch: IllegalArgumentException -> L49
    L31:
        r10 = b(r0.keyAs());
    L52:
        com.fasterxml.jackson.databind.k r2 = r15.x();
        if (r2 == null) goto L77;
        if (r0 == null) goto L57;
        r1 = b(r0.contentAs());
    L57:
        if (r1 != null) goto L59;
        return r15;
    L59:
        if (r2.a(r1) == false) goto L61;
        com.fasterxml.jackson.databind.k r12 = r2.d();
    L82:
        return r15.a(r12);
    L61:
        Class<?> r6 = r2.e();
    L74:
        e = move-exception;
        throw a(e, String.format("Internal error: failed to refine value type of %s with concrete-type annotation (value %s), from '%s': %s", new Object[]{r15, r1.getName(), r14.b(), e.getMessage()}));
    L63:
        if (r1.isAssignableFrom(r6) == false) goto L66;
        r12 = r16.b(r2, r1);     // Catch: IllegalArgumentException -> L74
        goto L82
    L66:
        if (r6.isAssignableFrom(r1) == false) goto L69;
        r12 = r16.a(r2, r1);     // Catch: IllegalArgumentException -> L74
        goto L82
    L69:
        if (b(r6, r1) == false) goto L73;
        r12 = r2.d();     // Catch: IllegalArgumentException -> L74
        goto L82
    L73:
        throw a(String.format("Cannot refine serialization content type %s into %s; types not related", new Object[]{r2, r1.getName()}));     // Catch: IllegalArgumentException -> L74
    L77:
        return r15;
    L5:
        r3 = b(r0.as());
        goto L7
    }

    @Override // com.fasterxml.jackson.databind.b
    public String[] e(d r2) {
        JsonPropertyOrder r1 = (JsonPropertyOrder) ZeusTransformUtils.preCheckCast(a(r2, JsonPropertyOrder.class), JsonPropertyOrder.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L6;
        return null;
    L6:
        return r1.value();
    }

    @Override // com.fasterxml.jackson.databind.b
    public Boolean t(b r1) {
        return J(r1);
    }

    private final Boolean J(b r2) {
        JsonPropertyOrder r1 = (JsonPropertyOrder) ZeusTransformUtils.preCheckCast(a(r2, JsonPropertyOrder.class), JsonPropertyOrder.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L5;
        return null;
    L5:
        if (r1.alphabetic() == true) goto L7;
        return null;
    L7:
        return Boolean.TRUE;
    }

    @Override // com.fasterxml.jackson.databind.b
    public void a(com.fasterxml.jackson.databind.a.m<?> r9, d r10, List<com.fasterxml.jackson.databind.j.d> r11) {
        List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
        JsonAppend r0 = (JsonAppend) ZeusTransformUtils.preCheckCast(a(r10, JsonAppend.class), JsonAppend.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
        return;
    L5:
        boolean r1 = r0.prepend();
        com.fasterxml.jackson.databind.k r2 = null;
        JsonAppend.Attr[] r3 = r0.attrs();
        int r4 = r3.length;
        int r5 = 0;
        int r6 = 0;
    L6:
        if (r6 >= r4) goto L14;
        if (r2 != null) goto L9;
        r2 = r9.b(Object.class);
    L9:
        com.fasterxml.jackson.databind.j.d r7 = a(r3[r6], r9, r10, r2);
        if (r1 == false) goto L12;
        r12.add(r6, r7);
    L13:
        r6 = r6 + 1;
        goto L6
    L12:
        r12.add(r7);
        goto L13
    L14:
        JsonAppend.Prop[] r8 = r0.props();
        int r13 = r8.length;
    L15:
        if (r5 >= r13) goto L21;
        com.fasterxml.jackson.databind.j.d r14 = a(r8[r5], r9, r10);
        if (r1 == false) goto L19;
        r12.add(r5, r14);
    L20:
        r5 = r5 + 1;
        goto L15
    L19:
        r12.add(r14);
        goto L20
    }

    public com.fasterxml.jackson.databind.j.d a(JsonAppend.Attr r5, com.fasterxml.jackson.databind.a.m<?> r6, d r7, com.fasterxml.jackson.databind.k r8) {
        JsonAppend.Attr r9 = (JsonAppend.Attr) ZeusTransformUtils.wrapperContextForParams(r5, JsonAppend.Attr.class, "com.obric.aiagent.plugin");
        if (r9.required() == false) goto L5;
        com.fasterxml.jackson.databind.w r0 = com.fasterxml.jackson.databind.w.f13125a;
    L6:
        String r1 = r9.value();
        com.fasterxml.jackson.databind.x r4 = a(r9.propName(), r9.propNamespace());
        if (r4.c() == true) goto L10;
        r4 = com.fasterxml.jackson.databind.x.a(r1);
    L10:
        return com.fasterxml.jackson.databind.j.a.a.a(r1, com.fasterxml.jackson.databind.l.w.a(r6, new ah(r7, r7.c(), r1, r8), r4, r0, r9.include()), r7.e(), r8);
    L5:
        r0 = com.fasterxml.jackson.databind.w.f13126b;
        goto L6
    }

    public com.fasterxml.jackson.databind.j.d a(JsonAppend.Prop r7, com.fasterxml.jackson.databind.a.m<?> r8, d r9) {
        JsonAppend.Prop r10 = (JsonAppend.Prop) ZeusTransformUtils.wrapperContextForParams(r7, JsonAppend.Prop.class, "com.obric.aiagent.plugin");
        if (r10.required() == false) goto L5;
        com.fasterxml.jackson.databind.w r0 = com.fasterxml.jackson.databind.w.f13125a;
    L6:
        com.fasterxml.jackson.databind.x r6 = a(r10.name(), r10.namespace());
        com.fasterxml.jackson.databind.k r2 = r8.b(r10.type());
        com.fasterxml.jackson.databind.l.w r11 = com.fasterxml.jackson.databind.l.w.a(r8, new ah(r9, r9.c(), r6.b(), r2), r6, r0, r10.include());
        Class<? extends com.fasterxml.jackson.databind.j.t> r12 = r10.value();
        com.fasterxml.jackson.databind.a.l r1 = r8.m();
        if (r1 != null) goto L9;
        com.fasterxml.jackson.databind.j.t r3 = null;
    L10:
        if (r3 != null) goto L13;
        r3 = (com.fasterxml.jackson.databind.j.t) ZeusTransformUtils.preCheckCast(com.fasterxml.jackson.databind.l.h.b(r12, r8.g()), com.fasterxml.jackson.databind.j.t.class, "com.obric.aiagent.plugin");
    L13:
        return r3.a(r8, r9, r11, r2);
    L9:
        r3 = r1.a(r8, r12);
        goto L10
    L5:
        r0 = com.fasterxml.jackson.databind.w.f13126b;
        goto L6
    }

    @Override // com.fasterxml.jackson.databind.b
    public com.fasterxml.jackson.databind.x u(b r5) {
        JsonGetter r0 = (JsonGetter) ZeusTransformUtils.preCheckCast(a(r5, JsonGetter.class), JsonGetter.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L9;
        String r1 = r0.value();
        if (r1.isEmpty() == false) goto L7;
        boolean r2 = true;
    L10:
        JsonProperty r3 = (JsonProperty) ZeusTransformUtils.preCheckCast(a(r5, JsonProperty.class), JsonProperty.class, "com.obric.aiagent.plugin");
        String r4 = null;
        if (r3 == null) goto L20;
        String r6 = r3.namespace();
        if (r6 != null) goto L15;
    L17:
        r4 = r6;
    L19:
        return com.fasterxml.jackson.databind.x.a(r3.value(), r4);
    L15:
        if (r6.isEmpty() == false) goto L17;
    L20:
        if (r2 == true) goto L26;
        if (a(r5, f12682c) == true) goto L26;
        return null;
    L26:
        return com.fasterxml.jackson.databind.x.f13132a;
    L7:
        return com.fasterxml.jackson.databind.x.a(r1);
    L9:
        r2 = false;
        goto L10
    }

    @Override // com.fasterxml.jackson.databind.b
    public Boolean c(com.fasterxml.jackson.databind.a.m<?> r1, b r2) {
        JsonKey r0 = (JsonKey) ZeusTransformUtils.preCheckCast(a(r2, JsonKey.class), JsonKey.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L7;
        return null;
    L7:
        return Boolean.valueOf(r0.value());
    }

    @Override // com.fasterxml.jackson.databind.b
    public Boolean v(b r2) {
        JsonValue r1 = (JsonValue) ZeusTransformUtils.preCheckCast(a(r2, JsonValue.class), JsonValue.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L7;
        return null;
    L7:
        return Boolean.valueOf(r1.value());
    }

    @Override // com.fasterxml.jackson.databind.b
    public Boolean w(b r2) {
        JsonAnyGetter r1 = (JsonAnyGetter) ZeusTransformUtils.preCheckCast(a(r2, JsonAnyGetter.class), JsonAnyGetter.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L7;
        return null;
    L7:
        return Boolean.valueOf(r1.enabled());
    }

    @Override // com.fasterxml.jackson.databind.b
    @Deprecated
    public boolean b(k r2) {
        return b(r2, JsonAnyGetter.class);
    }

    @Override // com.fasterxml.jackson.databind.b
    @Deprecated
    public boolean a(k r2) {
        JsonValue r1 = (JsonValue) ZeusTransformUtils.preCheckCast(a(r2, JsonValue.class), JsonValue.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L5;
    L7:
        return false;
    L5:
        if (r1.value() == false) goto L7;
        return true;
    }

    @Override // com.fasterxml.jackson.databind.b
    public Object x(b r2) {
        JsonDeserialize r1 = (JsonDeserialize) ZeusTransformUtils.preCheckCast(a(r2, JsonDeserialize.class), JsonDeserialize.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L7;
        Class<? extends com.fasterxml.jackson.databind.l> r3 = r1.using();
        if (r3 == com.fasterxml.jackson.databind.l.a.class) goto L9;
        return r3;
    L9:
        return null;
    L7:
        return null;
    }

    @Override // com.fasterxml.jackson.databind.b
    public Object y(b r2) {
        JsonDeserialize r1 = (JsonDeserialize) ZeusTransformUtils.preCheckCast(a(r2, JsonDeserialize.class), JsonDeserialize.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L7;
        Class<? extends com.fasterxml.jackson.databind.q> r3 = r1.keyUsing();
        if (r3 == com.fasterxml.jackson.databind.q.a.class) goto L9;
        return r3;
    L9:
        return null;
    L7:
        return null;
    }

    @Override // com.fasterxml.jackson.databind.b
    public Object z(b r2) {
        JsonDeserialize r1 = (JsonDeserialize) ZeusTransformUtils.preCheckCast(a(r2, JsonDeserialize.class), JsonDeserialize.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L7;
        Class<? extends com.fasterxml.jackson.databind.l> r3 = r1.contentUsing();
        if (r3 == com.fasterxml.jackson.databind.l.a.class) goto L9;
        return r3;
    L9:
        return null;
    L7:
        return null;
    }

    @Override // com.fasterxml.jackson.databind.b
    public Object A(b r3) {
        JsonDeserialize r4 = (JsonDeserialize) ZeusTransformUtils.preCheckCast(a(r3, JsonDeserialize.class), JsonDeserialize.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L6;
        return null;
    L6:
        return a(r4.converter(), com.fasterxml.jackson.databind.l.j.a.class);
    }

    @Override // com.fasterxml.jackson.databind.b
    public Object j(j r3) {
        JsonDeserialize r4 = (JsonDeserialize) ZeusTransformUtils.preCheckCast(a(r3, JsonDeserialize.class), JsonDeserialize.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L6;
        return null;
    L6:
        return a(r4.contentConverter(), com.fasterxml.jackson.databind.l.j.a.class);
    }

    @Override // com.fasterxml.jackson.databind.b
    public com.fasterxml.jackson.databind.k b(com.fasterxml.jackson.databind.a.m<?> r12, b r13, com.fasterxml.jackson.databind.k r14) {
        com.fasterxml.jackson.databind.k.o r15 = r12.o();
        JsonDeserialize r0 = (JsonDeserialize) ZeusTransformUtils.preCheckCast(a(r13, JsonDeserialize.class), JsonDeserialize.class, "com.obric.aiagent.plugin");
        Class<?> r1 = null;
        if (r0 != null) goto L5;
        Class<?> r3 = null;
    L7:
        if (r3 == null) goto L18;
        if (r14.a(r3) == true) goto L18;
        if (a(r14, r3) == true) goto L18;
        r14 = r15.a(r14, r3);     // Catch: IllegalArgumentException -> L14
    L14:
        e = move-exception;
        throw a(e, String.format("Failed to narrow type %s with annotation (value %s), from '%s': %s", new Object[]{r14, r3.getName(), r13.b(), e.getMessage()}));
    L18:
        if (r14.s() == false) goto L31;
        com.fasterxml.jackson.databind.k r4 = r14.w();
        if (r0 != null) goto L22;
        Class<?> r9 = null;
    L23:
        if (r9 == null) goto L31;
        if (a(r4, r9) == true) goto L31;
        r14 = ((com.fasterxml.jackson.databind.k.g) ZeusTransformUtils.preCheckCast(r14, com.fasterxml.jackson.databind.k.g.class, "com.obric.aiagent.plugin")).c(r15.a(r4, r9));     // Catch: IllegalArgumentException -> L28
    L28:
        e = move-exception;
        throw a(e, String.format("Failed to narrow key type of %s with concrete-type annotation (value %s), from '%s': %s", new Object[]{r14, r9.getName(), r13.b(), e.getMessage()}));
    L22:
        r9 = b(r0.keyAs());
    L31:
        com.fasterxml.jackson.databind.k r2 = r14.x();
        if (r2 == null) goto L44;
        if (r0 == null) goto L36;
        r1 = b(r0.contentAs());
    L36:
        if (r1 != null) goto L38;
        return r14;
    L38:
        if (a(r2, r1) == true) goto L52;
        return r14.a(r15.a(r2, r1));
    L41:
        e = move-exception;
        throw a(e, String.format("Failed to narrow value type of %s with concrete-type annotation (value %s), from '%s': %s", new Object[]{r14, r1.getName(), r13.b(), e.getMessage()}));
    L52:
        return r14;
    L44:
        return r14;
    L5:
        r3 = b(r0.as());
        goto L7
    }

    @Override // com.fasterxml.jackson.databind.b
    public Object f(d r2) {
        JsonValueInstantiator r1 = (JsonValueInstantiator) ZeusTransformUtils.preCheckCast(a(r2, JsonValueInstantiator.class), JsonValueInstantiator.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L6;
        return null;
    L6:
        return r1.value();
    }

    @Override // com.fasterxml.jackson.databind.b
    public Class<?> g(d r3) {
        JsonDeserialize r4 = (JsonDeserialize) ZeusTransformUtils.preCheckCast(a(r3, JsonDeserialize.class), JsonDeserialize.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L6;
        return null;
    L6:
        return b(r4.builder());
    }

    @Override // com.fasterxml.jackson.databind.b
    public JsonPOJOBuilder.Value h(d r2) {
        JsonPOJOBuilder r1 = (JsonPOJOBuilder) ZeusTransformUtils.preCheckCast(a(r2, JsonPOJOBuilder.class), JsonPOJOBuilder.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L6;
        return null;
    L6:
        return new JsonPOJOBuilder.Value(r1);
    }

    @Override // com.fasterxml.jackson.databind.b
    public com.fasterxml.jackson.databind.x B(b r5) {
        JsonSetter r0 = (JsonSetter) ZeusTransformUtils.preCheckCast(a(r5, JsonSetter.class), JsonSetter.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L9;
        String r1 = r0.value();
        if (r1.isEmpty() == false) goto L8;
        boolean r2 = true;
    L10:
        JsonProperty r3 = (JsonProperty) ZeusTransformUtils.preCheckCast(a(r5, JsonProperty.class), JsonProperty.class, "com.obric.aiagent.plugin");
        String r4 = null;
        if (r3 == null) goto L20;
        String r6 = r3.namespace();
        if (r6 != null) goto L15;
    L17:
        r4 = r6;
    L19:
        return com.fasterxml.jackson.databind.x.a(r3.value(), r4);
    L15:
        if (r6.isEmpty() == false) goto L17;
    L20:
        if (r2 == true) goto L26;
        if (a(r5, f12683d) == true) goto L26;
        return null;
    L26:
        return com.fasterxml.jackson.databind.x.f13132a;
    L8:
        return com.fasterxml.jackson.databind.x.a(r1);
    L9:
        r2 = false;
        goto L10
    }

    @Override // com.fasterxml.jackson.databind.b
    public Boolean C(b r2) {
        JsonAnySetter r1 = (JsonAnySetter) ZeusTransformUtils.preCheckCast(a(r2, JsonAnySetter.class), JsonAnySetter.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L6;
        return null;
    L6:
        return Boolean.valueOf(r1.enabled());
    }

    @Override // com.fasterxml.jackson.databind.b
    public JsonSetter.Value D(b r2) {
        return JsonSetter.Value.from((JsonSetter) ZeusTransformUtils.preCheckCast(a(r2, JsonSetter.class), JsonSetter.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.fasterxml.jackson.databind.b
    public Boolean E(b r2) {
        JsonMerge r1 = (JsonMerge) ZeusTransformUtils.preCheckCast(a(r2, JsonMerge.class), JsonMerge.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L6;
        return null;
    L6:
        return r1.value().asBoolean();
    }

    @Override // com.fasterxml.jackson.databind.b
    @Deprecated
    public boolean F(b r4) {
        JsonCreator r0 = (JsonCreator) ZeusTransformUtils.preCheckCast(a(r4, JsonCreator.class), JsonCreator.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L9;
        if (r0.mode() == JsonCreator.Mode.DISABLED) goto L19;
        return true;
    L19:
        return false;
    L9:
        if (this.f12686b == true) goto L11;
    L18:
        return false;
    L11:
        if (ZeusTransformUtils.instanceOf(r4, f.class) == false) goto L18;
        com.fasterxml.jackson.databind.d.b r3 = f12684e;
        if (r3 == null) goto L18;
        Boolean r5 = r3.b(r4);
        if (r5 == null) goto L18;
        return r5.booleanValue();
    }

    @Override // com.fasterxml.jackson.databind.b
    @Deprecated
    public JsonCreator.Mode G(b r2) {
        JsonCreator r1 = (JsonCreator) ZeusTransformUtils.preCheckCast(a(r2, JsonCreator.class), JsonCreator.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L6;
        return null;
    L6:
        return r1.mode();
    }

    @Override // com.fasterxml.jackson.databind.b
    public JsonCreator.Mode d(com.fasterxml.jackson.databind.a.m<?> r4, b r5) {
        JsonCreator r0 = (JsonCreator) ZeusTransformUtils.preCheckCast(a(r5, JsonCreator.class), JsonCreator.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L7;
        return r0.mode();
    L7:
        if (this.f12686b == true) goto L9;
        return null;
    L9:
        if (r4.a(com.fasterxml.jackson.databind.r.l) == true) goto L11;
        return null;
    L11:
        if (ZeusTransformUtils.instanceOf(r5, f.class) == false) goto L23;
        com.fasterxml.jackson.databind.d.b r3 = f12684e;
        if (r3 == null) goto L24;
        Boolean r6 = r3.b(r5);
        if (r6 != null) goto L17;
        return null;
    L17:
        if (r6.booleanValue() == true) goto L19;
        return null;
    L19:
        return JsonCreator.Mode.PROPERTIES;
    L24:
        return null;
    L23:
        return null;
    }

    public boolean H(b r3) {
        JsonIgnore r2 = (JsonIgnore) ZeusTransformUtils.preCheckCast(a(r3, JsonIgnore.class), JsonIgnore.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L5;
        com.fasterxml.jackson.databind.d.b r4 = f12684e;
        if (r4 == null) goto L12;
        Boolean r5 = r4.a(r3);
        if (r5 != null) goto L11;
        return false;
    L11:
        return r5.booleanValue();
    L12:
        return false;
    L5:
        return r2.value();
    }

    public Class<?> b(Class<?> r1) {
        if (r1 != null) goto L4;
        return null;
    L4:
        if (com.fasterxml.jackson.databind.l.h.e(r1) == true) goto L9;
        return r1;
    L9:
        return null;
    }

    public Class<?> a(Class<?> r1, Class<?> r2) {
        Class<?> r0 = b(r1);
        if (r0 == null) goto L5;
        if (r0 == r2) goto L5;
        return r0;
    L5:
        return null;
    }

    public com.fasterxml.jackson.databind.x a(String r1, String r2) {
        if (r1.isEmpty() == true) goto L5;
        if (r2 == null) goto L13;
        if (r2.isEmpty() == true) goto L13;
        return com.fasterxml.jackson.databind.x.a(r1, r2);
    L13:
        return com.fasterxml.jackson.databind.x.a(r1);
    L5:
        return com.fasterxml.jackson.databind.x.f13132a;
    }

    public com.fasterxml.jackson.databind.x I(b r2) {
        if (ZeusTransformUtils.instanceOf(r2, n.class) == false) goto L11;
        n r1 = (n) ZeusTransformUtils.preCheckCast(r2, n.class, "com.obric.aiagent.plugin");
        if (r1.d() == null) goto L13;
        com.fasterxml.jackson.databind.d.b r3 = f12684e;
        if (r3 == null) goto L14;
        com.fasterxml.jackson.databind.x r4 = r3.a(r1);
        if (r4 == null) goto L15;
        return r4;
    L15:
        return null;
    L14:
        return null;
    L13:
        return null;
    L11:
        return null;
    }

    public com.fasterxml.jackson.databind.h.g<?> c(com.fasterxml.jackson.databind.a.m<?> r6, b r7, com.fasterxml.jackson.databind.k r8) {
        JsonTypeInfo r0 = (JsonTypeInfo) ZeusTransformUtils.preCheckCast(a(r7, JsonTypeInfo.class), JsonTypeInfo.class, "com.obric.aiagent.plugin");
        JsonTypeResolver r1 = (JsonTypeResolver) ZeusTransformUtils.preCheckCast(a(r7, JsonTypeResolver.class), JsonTypeResolver.class, "com.obric.aiagent.plugin");
        com.fasterxml.jackson.databind.h.f r3 = null;
        if (r1 == null) goto L7;
        if (r0 != null) goto L6;
        return null;
    L6:
        com.fasterxml.jackson.databind.h.g<?> r2 = r6.a(r7, r1.value());
    L14:
        JsonTypeIdResolver r5 = (JsonTypeIdResolver) ZeusTransformUtils.preCheckCast(a(r7, JsonTypeIdResolver.class), JsonTypeIdResolver.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L18;
        r3 = r6.b(r7, r5.value());
    L18:
        if (r3 == null) goto L20;
        r3.a(r8);
    L20:
        com.fasterxml.jackson.databind.h.g r9 = r2.a(r0.use(), r3);
        JsonTypeInfo.As r10 = r0.include();
        if (r10 == JsonTypeInfo.As.EXTERNAL_PROPERTY) goto L23;
    L25:
        com.fasterxml.jackson.databind.h.g r11 = r9.a(r10).a(r0.property());
        Class<?> r12 = r0.defaultImpl();
        if (r12 == JsonTypeInfo.None.class) goto L31;
        if (r12.isAnnotation() == true) goto L31;
        r11 = r11.a(r12);
    L31:
        return r11.a(r0.visible());
    L23:
        if (ZeusTransformUtils.instanceOf(r7, d.class) == false) goto L25;
        r10 = JsonTypeInfo.As.PROPERTY;
        goto L25
    L7:
        if (r0 != null) goto L10;
        return null;
    L10:
        if (r0.use() == JsonTypeInfo.Id.NONE) goto L12;
        r2 = b();
        goto L14
    L12:
        return c();
    }

    public com.fasterxml.jackson.databind.h.a.o b() {
        return new com.fasterxml.jackson.databind.h.a.o();
    }

    public com.fasterxml.jackson.databind.h.a.o c() {
        return com.fasterxml.jackson.databind.h.a.o.b();
    }

    private boolean b(Class<?> r3, Class<?> r4) {
        if (r3.isPrimitive() == false) goto L10;
        if (r3 != com.fasterxml.jackson.databind.l.h.k(r4)) goto L8;
        return true;
    L8:
        return false;
    L10:
        if (r4.isPrimitive() == true) goto L12;
        return false;
    L12:
        if (r4 != com.fasterxml.jackson.databind.l.h.k(r3)) goto L15;
        return true;
    L15:
        return false;
    }

    private boolean a(com.fasterxml.jackson.databind.k r2, Class<?> r3) {
        if (r2.o() == false) goto L7;
        return r2.a(com.fasterxml.jackson.databind.l.h.k(r3));
    L7:
        if (r3.isPrimitive() == true) goto L9;
        return false;
    L9:
        if (r3 != com.fasterxml.jackson.databind.l.h.k(r2.e())) goto L13;
        return true;
    L13:
        return false;
    }

    private com.fasterxml.jackson.databind.m a(String r2) {
        return new com.fasterxml.jackson.databind.m(null, r2);
    }

    private com.fasterxml.jackson.databind.m a(Throwable r2, String r3) {
        return new com.fasterxml.jackson.databind.m(null, r3, r2);
    }
}
