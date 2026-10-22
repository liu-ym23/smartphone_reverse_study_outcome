package com.fasterxml.jackson.databind.introspect;

import b3.c;
import b3.f;
import b3.g;
import c3.b;
import c3.e;
import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.annotation.ObjectIdGenerators$None;
import com.fasterxml.jackson.annotation.OptBoolean;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.PropertyMetadata;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.fasterxml.jackson.databind.ser.VirtualBeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.impl.AttributePropertyWriter;
import com.fasterxml.jackson.databind.ser.std.RawSerializer;
import com.fasterxml.jackson.databind.type.MapLikeType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.LRUMap;
import com.fasterxml.jackson.databind.util.NameTransformer;
import java.io.Closeable;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import q3.g;
import q3.j;
import u2.k;
import u2.l;
import u2.m;
import u2.n;
import u2.o;
import u2.p;
import u2.q;
import u2.r;
import u2.s;
import u2.t;
import u2.u;
import u2.v;
import u2.w;
import u2.x;
import u2.y;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class JacksonAnnotationIntrospector extends AnnotationIntrospector implements Serializable {

    /* renamed from: c, reason: collision with root package name */
    public static final Class<? extends Annotation>[] f4160c = {JsonSerialize.class, y.class, JsonFormat.class, JsonTypeInfo.class, r.class, w.class, u2.e.class, n.class};

    /* renamed from: d, reason: collision with root package name */
    public static final Class<? extends Annotation>[] f4161d = {c3.c.class, y.class, JsonFormat.class, JsonTypeInfo.class, w.class, u2.e.class, n.class, o.class};

    /* renamed from: e, reason: collision with root package name */
    public static final h3.c f4162e;

    /* renamed from: a, reason: collision with root package name */
    public transient LRUMap<Class<?>, Boolean> f4163a = new LRUMap<>(48, 48);

    /* renamed from: b, reason: collision with root package name */
    public final boolean f4164b = true;

    static {
        h3.c cVar;
        try {
            cVar = h3.c.f9292a;
        } catch (Throwable unused) {
            cVar = null;
        }
        f4162e = cVar;
    }

    public static Class r0(Class cls) {
        if (cls == null || com.fasterxml.jackson.databind.util.a.t(cls)) {
            return null;
        }
        return cls;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static k3.d s0(com.fasterxml.jackson.databind.cfg.MapperConfig r3, i3.a r4, com.fasterxml.jackson.databind.JavaType r5) {
        /*
            java.lang.Class<com.fasterxml.jackson.annotation.JsonTypeInfo> r5 = com.fasterxml.jackson.annotation.JsonTypeInfo.class
            java.lang.annotation.Annotation r5 = r4.c(r5)
            com.fasterxml.jackson.annotation.JsonTypeInfo r5 = (com.fasterxml.jackson.annotation.JsonTypeInfo) r5
            java.lang.Class<c3.g> r0 = c3.g.class
            java.lang.annotation.Annotation r0 = r4.c(r0)
            c3.g r0 = (c3.g) r0
            r1 = 0
            if (r0 == 0) goto L2a
            if (r5 != 0) goto L16
            goto L2c
        L16:
            java.lang.Class r0 = r0.value()
            r3.h()
            com.fasterxml.jackson.databind.MapperFeature r2 = com.fasterxml.jackson.databind.MapperFeature.CAN_OVERRIDE_ACCESS_MODIFIERS
            boolean r2 = r3.k(r2)
            java.lang.Object r0 = com.fasterxml.jackson.databind.util.a.h(r0, r2)
            k3.d r0 = (k3.d) r0
            goto L46
        L2a:
            if (r5 != 0) goto L2d
        L2c:
            return r1
        L2d:
            com.fasterxml.jackson.annotation.JsonTypeInfo$Id r0 = r5.use()
            com.fasterxml.jackson.annotation.JsonTypeInfo$Id r2 = com.fasterxml.jackson.annotation.JsonTypeInfo.Id.NONE
            if (r0 != r2) goto L41
            l3.h r3 = new l3.h
            r3.<init>()
            r3.f10204a = r2
            r3.f10209f = r1
            r3.f10206c = r1
            return r3
        L41:
            l3.h r0 = new l3.h
            r0.<init>()
        L46:
            java.lang.Class<c3.f> r2 = c3.f.class
            java.lang.annotation.Annotation r2 = r4.c(r2)
            c3.f r2 = (c3.f) r2
            if (r2 != 0) goto L51
            goto L65
        L51:
            java.lang.Class r1 = r2.value()
            r3.h()
            com.fasterxml.jackson.databind.MapperFeature r2 = com.fasterxml.jackson.databind.MapperFeature.CAN_OVERRIDE_ACCESS_MODIFIERS
            boolean r3 = r3.k(r2)
            java.lang.Object r3 = com.fasterxml.jackson.databind.util.a.h(r1, r3)
            r1 = r3
            k3.c r1 = (k3.c) r1
        L65:
            com.fasterxml.jackson.annotation.JsonTypeInfo$Id r3 = r5.use()
            l3.h r3 = r0.d(r3, r1)
            com.fasterxml.jackson.annotation.JsonTypeInfo$As r0 = r5.include()
            com.fasterxml.jackson.annotation.JsonTypeInfo$As r1 = com.fasterxml.jackson.annotation.JsonTypeInfo.As.f3484d
            if (r0 != r1) goto L7b
            boolean r4 = r4 instanceof com.fasterxml.jackson.databind.introspect.a
            if (r4 == 0) goto L7b
            com.fasterxml.jackson.annotation.JsonTypeInfo$As r0 = com.fasterxml.jackson.annotation.JsonTypeInfo.As.f3481a
        L7b:
            if (r0 == 0) goto La8
            r3.f10205b = r0
            java.lang.String r4 = r5.property()
            if (r4 == 0) goto L8b
            boolean r0 = r4.isEmpty()
            if (r0 == 0) goto L8f
        L8b:
            com.fasterxml.jackson.annotation.JsonTypeInfo$Id r4 = r3.f10204a
            java.lang.String r4 = r4.f3490a
        L8f:
            r3.f10206c = r4
            java.lang.Class r4 = r5.defaultImpl()
            java.lang.Class<com.fasterxml.jackson.annotation.JsonTypeInfo$a> r0 = com.fasterxml.jackson.annotation.JsonTypeInfo.a.class
            if (r4 == r0) goto La1
            boolean r0 = r4.isAnnotation()
            if (r0 != 0) goto La1
            r3.f10208e = r4
        La1:
            boolean r4 = r5.visible()
            r3.f10207d = r4
            return r3
        La8:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException
            java.lang.String r4 = "includeAs cannot be null"
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector.s0(com.fasterxml.jackson.databind.cfg.MapperConfig, i3.a, com.fasterxml.jackson.databind.JavaType):k3.d");
    }

    public static boolean t0(JavaType javaType, Class cls) {
        return javaType.f3690a.isPrimitive() ? javaType.u(com.fasterxml.jackson.databind.util.a.z(cls)) : cls.isPrimitive() && cls == com.fasterxml.jackson.databind.util.a.z(javaType.f3690a);
    }

    public static boolean u0(Class cls, Class cls2) {
        return cls.isPrimitive() ? cls == com.fasterxml.jackson.databind.util.a.z(cls2) : cls2.isPrimitive() && cls2 == com.fasterxml.jackson.databind.util.a.z(cls);
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public final Class<?> A(a aVar) {
        c3.c cVar = (c3.c) aVar.f4182m.a(c3.c.class);
        if (cVar == null) {
            return null;
        }
        return r0(cVar.builder());
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public final e.a B(a aVar) {
        c3.e eVar = (c3.e) aVar.f4182m.a(c3.e.class);
        if (eVar == null) {
            return null;
        }
        return new e.a(eVar);
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public final JsonProperty.Access C(i3.a aVar) {
        JsonProperty jsonProperty = (JsonProperty) aVar.c(JsonProperty.class);
        if (jsonProperty != null) {
            return jsonProperty.access();
        }
        return null;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public final List D(AnnotatedMember annotatedMember) {
        u2.b bVar = (u2.b) annotatedMember.c(u2.b.class);
        if (bVar == null) {
            return null;
        }
        String[] strArrValue = bVar.value();
        int length = strArrValue.length;
        if (length == 0) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList(length);
        for (String str : strArrValue) {
            arrayList.add(PropertyName.a(str));
        }
        return arrayList;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public final k3.d<?> E(MapperConfig<?> mapperConfig, AnnotatedMember annotatedMember, JavaType javaType) {
        if (javaType.k() != null) {
            return s0(mapperConfig, annotatedMember, javaType);
        }
        throw new IllegalArgumentException("Must call method with a container or reference type (got " + javaType + ")");
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public final String F(AnnotatedMember annotatedMember) {
        JsonProperty jsonProperty = (JsonProperty) annotatedMember.c(JsonProperty.class);
        if (jsonProperty != null) {
            String strDefaultValue = jsonProperty.defaultValue();
            if (!strDefaultValue.isEmpty()) {
                return strDefaultValue;
            }
        }
        return null;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public final String G(AnnotatedMember annotatedMember) {
        p pVar = (p) annotatedMember.c(p.class);
        if (pVar == null) {
            return null;
        }
        return pVar.value();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.Set] */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.HashSet] */
    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public final JsonIgnoreProperties.Value H(i3.a aVar) {
        ?? hashSet;
        JsonIgnoreProperties jsonIgnoreProperties = (JsonIgnoreProperties) aVar.c(JsonIgnoreProperties.class);
        if (jsonIgnoreProperties == null) {
            return JsonIgnoreProperties.Value.h;
        }
        JsonIgnoreProperties.Value value = JsonIgnoreProperties.Value.h;
        String[] strArrValue = jsonIgnoreProperties.value();
        if (strArrValue == null || strArrValue.length == 0) {
            hashSet = Collections.EMPTY_SET;
        } else {
            hashSet = new HashSet(strArrValue.length);
            for (String str : strArrValue) {
                hashSet.add(str);
            }
        }
        Set set = hashSet;
        boolean zIgnoreUnknown = jsonIgnoreProperties.ignoreUnknown();
        boolean zAllowGetters = jsonIgnoreProperties.allowGetters();
        boolean zAllowSetters = jsonIgnoreProperties.allowSetters();
        return JsonIgnoreProperties.Value.a(set, zIgnoreUnknown, zAllowGetters, zAllowSetters, false) ? JsonIgnoreProperties.Value.h : new JsonIgnoreProperties.Value(set, zIgnoreUnknown, zAllowGetters, zAllowSetters, false);
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    @Deprecated
    public final JsonIgnoreProperties.Value I(i3.a aVar) {
        return H(aVar);
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public final JsonInclude.Value J(i3.a aVar) {
        JsonInclude.Value value;
        JsonSerialize jsonSerialize;
        JsonInclude jsonInclude = (JsonInclude) aVar.c(JsonInclude.class);
        JsonInclude.Include include = JsonInclude.Include.f3468e;
        if (jsonInclude == null) {
            value = JsonInclude.Value.f3469e;
        } else {
            JsonInclude.Value value2 = JsonInclude.Value.f3469e;
            JsonInclude.Include includeValue = jsonInclude.value();
            JsonInclude.Include includeContent = jsonInclude.content();
            if (includeValue == include && includeContent == include) {
                value = value2;
            } else {
                Class<?> clsValueFilter = jsonInclude.valueFilter();
                if (clsValueFilter == Void.class) {
                    clsValueFilter = null;
                }
                Class<?> clsContentFilter = jsonInclude.contentFilter();
                value = new JsonInclude.Value(includeValue, includeContent, clsValueFilter, clsContentFilter != Void.class ? clsContentFilter : null);
            }
        }
        if (value.f3470a != include || (jsonSerialize = (JsonSerialize) aVar.c(JsonSerialize.class)) == null) {
            return value;
        }
        int iOrdinal = jsonSerialize.include().ordinal();
        return iOrdinal != 0 ? iOrdinal != 1 ? iOrdinal != 2 ? iOrdinal != 3 ? value : value.b(JsonInclude.Include.f3466c) : value.b(JsonInclude.Include.f3467d) : value.b(JsonInclude.Include.f3465b) : value.b(JsonInclude.Include.f3464a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.Set] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.Set] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.HashSet] */
    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public final JsonIncludeProperties.Value K(i3.a aVar) {
        ?? hashSet;
        JsonIncludeProperties jsonIncludeProperties = (JsonIncludeProperties) aVar.c(JsonIncludeProperties.class);
        if (jsonIncludeProperties == null) {
            return JsonIncludeProperties.Value.f3474b;
        }
        String[] strArrValue = jsonIncludeProperties.value();
        if (strArrValue == null || strArrValue.length == 0) {
            hashSet = Collections.EMPTY_SET;
        } else {
            hashSet = new HashSet(strArrValue.length);
            for (String str : strArrValue) {
                hashSet.add(str);
            }
        }
        return new JsonIncludeProperties.Value(hashSet);
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public final Integer L(AnnotatedMember annotatedMember) {
        int iIndex;
        JsonProperty jsonProperty = (JsonProperty) annotatedMember.c(JsonProperty.class);
        if (jsonProperty == null || (iIndex = jsonProperty.index()) == -1) {
            return null;
        }
        return Integer.valueOf(iIndex);
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public final k3.d<?> M(MapperConfig<?> mapperConfig, AnnotatedMember annotatedMember, JavaType javaType) {
        if (javaType.y() || javaType.d()) {
            return null;
        }
        return s0(mapperConfig, annotatedMember, javaType);
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public final AnnotationIntrospector.ReferenceProperty N(AnnotatedMember annotatedMember) {
        n nVar = (n) annotatedMember.c(n.class);
        if (nVar != null) {
            return new AnnotationIntrospector.ReferenceProperty(AnnotationIntrospector.ReferenceProperty.Type.f3649a, nVar.value());
        }
        u2.e eVar = (u2.e) annotatedMember.c(u2.e.class);
        if (eVar == null) {
            return null;
        }
        return new AnnotationIntrospector.ReferenceProperty(AnnotationIntrospector.ReferenceProperty.Type.f3650b, eVar.value());
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public final PropertyName O(a aVar) {
        s sVar = (s) aVar.f4182m.a(s.class);
        if (sVar == null) {
            return null;
        }
        String strNamespace = sVar.namespace();
        return PropertyName.b(sVar.value(), (strNamespace == null || !strNamespace.isEmpty()) ? strNamespace : null);
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public final Object P(AnnotatedMember annotatedMember) {
        Class clsR0;
        JsonSerialize jsonSerialize = (JsonSerialize) annotatedMember.c(JsonSerialize.class);
        if (jsonSerialize == null || (clsR0 = r0(jsonSerialize.contentConverter())) == null || clsR0 == g.a.class) {
            return null;
        }
        return clsR0;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public final Object Q(i3.a aVar) {
        Class clsR0;
        JsonSerialize jsonSerialize = (JsonSerialize) aVar.c(JsonSerialize.class);
        if (jsonSerialize == null || (clsR0 = r0(jsonSerialize.converter())) == null || clsR0 == g.a.class) {
            return null;
        }
        return clsR0;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public final String[] R(a aVar) {
        q qVar = (q) aVar.f4182m.a(q.class);
        if (qVar == null) {
            return null;
        }
        return qVar.value();
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public final Boolean S(i3.a aVar) {
        q qVar = (q) aVar.c(q.class);
        if (qVar == null || !qVar.alphabetic()) {
            return null;
        }
        return Boolean.TRUE;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public final JsonSerialize.Typing T(i3.a aVar) {
        JsonSerialize jsonSerialize = (JsonSerialize) aVar.c(JsonSerialize.class);
        if (jsonSerialize == null) {
            return null;
        }
        return jsonSerialize.typing();
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public final Object U(i3.a aVar) {
        Class<? extends b3.f> clsUsing;
        JsonSerialize jsonSerialize = (JsonSerialize) aVar.c(JsonSerialize.class);
        if (jsonSerialize != null && (clsUsing = jsonSerialize.using()) != f.a.class) {
            return clsUsing;
        }
        r rVar = (r) aVar.c(r.class);
        if (rVar == null || !rVar.value()) {
            return null;
        }
        return new RawSerializer(aVar.e(), 0);
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public final JsonSetter.Value V(AnnotatedMember annotatedMember) {
        JsonSetter jsonSetter = (JsonSetter) annotatedMember.c(JsonSetter.class);
        JsonSetter.Value value = JsonSetter.Value.f3478c;
        if (jsonSetter == null) {
            return value;
        }
        Nulls nulls = jsonSetter.nulls();
        Nulls nullsContentNulls = jsonSetter.contentNulls();
        Nulls nulls2 = Nulls.f3494d;
        if (nulls == null) {
            nulls = nulls2;
        }
        if (nullsContentNulls == null) {
            nullsContentNulls = nulls2;
        }
        return (nulls == nulls2 && nullsContentNulls == nulls2) ? value : new JsonSetter.Value(nulls, nullsContentNulls);
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public final List<NamedType> W(i3.a aVar) {
        t tVar = (t) aVar.c(t.class);
        if (tVar == null) {
            return null;
        }
        t.a[] aVarArrValue = tVar.value();
        ArrayList arrayList = new ArrayList(aVarArrValue.length);
        for (t.a aVar2 : aVarArrValue) {
            arrayList.add(new NamedType(aVar2.value(), aVar2.name()));
            for (String str : aVar2.names()) {
                arrayList.add(new NamedType(aVar2.value(), str));
            }
        }
        return arrayList;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public final String X(a aVar) {
        v vVar = (v) aVar.f4182m.a(v.class);
        if (vVar == null) {
            return null;
        }
        return vVar.value();
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public final k3.d Y(JavaType javaType, MapperConfig mapperConfig, a aVar) {
        return s0(mapperConfig, aVar, javaType);
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public final NameTransformer Z(AnnotatedMember annotatedMember) {
        w wVar = (w) annotatedMember.c(w.class);
        if (wVar == null || !wVar.enabled()) {
            return null;
        }
        String strPrefix = wVar.prefix();
        String strSuffix = wVar.suffix();
        NameTransformer.NopTransformer nopTransformer = NameTransformer.f4511a;
        boolean z = false;
        boolean z3 = (strPrefix == null || strPrefix.isEmpty()) ? false : true;
        if (strSuffix != null && !strSuffix.isEmpty()) {
            z = true;
        }
        return z3 ? z ? new q3.h(strPrefix, strSuffix) : new q3.i(strPrefix) : z ? new j(strSuffix) : NameTransformer.f4511a;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public final void a(MapperConfig mapperConfig, a aVar, ArrayList arrayList) {
        Annotation annotationA = aVar.f4182m.a(c3.b.class);
        Class<?> cls = aVar.f4175b;
        c3.b bVar = (c3.b) annotationA;
        if (bVar == null) {
            return;
        }
        boolean zPrepend = bVar.prepend();
        b.a[] aVarArrAttrs = bVar.attrs();
        int length = aVarArrAttrs.length;
        JavaType javaTypeC = null;
        for (int i10 = 0; i10 < length; i10++) {
            if (javaTypeC == null) {
                javaTypeC = mapperConfig.c(Object.class);
            }
            b.a aVar2 = aVarArrAttrs[i10];
            PropertyMetadata propertyMetadata = aVar2.required() ? PropertyMetadata.f3742k : PropertyMetadata.f3743l;
            String strValue = aVar2.value();
            String strPropName = aVar2.propName();
            String strPropNamespace = aVar2.propNamespace();
            PropertyName propertyNameA = strPropName.isEmpty() ? PropertyName.f3753d : (strPropNamespace == null || strPropNamespace.isEmpty()) ? PropertyName.a(strPropName) : PropertyName.b(strPropName, strPropNamespace);
            if (propertyNameA.f3755a.isEmpty()) {
                propertyNameA = PropertyName.a(strValue);
            }
            AttributePropertyWriter attributePropertyWriter = new AttributePropertyWriter(strValue, q3.o.C(mapperConfig, new VirtualAnnotatedMember(aVar, cls, strValue, javaTypeC), propertyNameA, propertyMetadata, aVar2.include()), aVar.f4182m, javaTypeC);
            if (zPrepend) {
                arrayList.add(i10, attributePropertyWriter);
            } else {
                arrayList.add(attributePropertyWriter);
            }
        }
        b.InterfaceC0029b[] interfaceC0029bArrProps = bVar.props();
        if (interfaceC0029bArrProps.length > 0) {
            b.InterfaceC0029b interfaceC0029b = interfaceC0029bArrProps[0];
            PropertyMetadata propertyMetadata2 = interfaceC0029b.required() ? PropertyMetadata.f3742k : PropertyMetadata.f3743l;
            String strName = interfaceC0029b.name();
            String strNamespace = interfaceC0029b.namespace();
            PropertyName propertyNameA2 = !strName.isEmpty() ? (strNamespace == null || strNamespace.isEmpty()) ? PropertyName.a(strName) : PropertyName.b(strName, strNamespace) : PropertyName.f3753d;
            q3.o.C(mapperConfig, new VirtualAnnotatedMember(aVar, cls, propertyNameA2.f3755a, mapperConfig.c(interfaceC0029b.type())), propertyNameA2, propertyMetadata2, interfaceC0029b.include());
            Class<? extends VirtualBeanPropertyWriter> clsValue = interfaceC0029b.value();
            mapperConfig.h();
            ((VirtualBeanPropertyWriter) com.fasterxml.jackson.databind.util.a.h(clsValue, mapperConfig.k(MapperFeature.CAN_OVERRIDE_ACCESS_MODIFIERS))).o();
            throw null;
        }
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public final Object a0(a aVar) {
        c3.h hVar = (c3.h) aVar.f4182m.a(c3.h.class);
        if (hVar == null) {
            return null;
        }
        return hVar.value();
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public final VisibilityChecker<?> b(a aVar, VisibilityChecker<?> visibilityChecker) {
        JsonAutoDetect jsonAutoDetect = (JsonAutoDetect) aVar.f4182m.a(JsonAutoDetect.class);
        if (jsonAutoDetect == null) {
            return visibilityChecker;
        }
        VisibilityChecker.Std std = (VisibilityChecker.Std) visibilityChecker;
        JsonAutoDetect.Visibility visibility = std.f4169a;
        JsonAutoDetect.Visibility visibility2 = std.f4173e;
        JsonAutoDetect.Visibility visibility3 = std.f4172d;
        JsonAutoDetect.Visibility visibility4 = std.f4171c;
        JsonAutoDetect.Visibility visibility5 = std.f4170b;
        JsonAutoDetect.Visibility visibility6 = jsonAutoDetect.getterVisibility();
        JsonAutoDetect.Visibility visibility7 = JsonAutoDetect.Visibility.f3427d;
        JsonAutoDetect.Visibility visibility8 = visibility6 == visibility7 ? visibility : visibility6;
        JsonAutoDetect.Visibility visibilityIsGetterVisibility = jsonAutoDetect.isGetterVisibility();
        JsonAutoDetect.Visibility visibility9 = visibilityIsGetterVisibility == visibility7 ? visibility5 : visibilityIsGetterVisibility;
        JsonAutoDetect.Visibility visibility10 = jsonAutoDetect.setterVisibility();
        JsonAutoDetect.Visibility visibility11 = visibility10 == visibility7 ? visibility4 : visibility10;
        JsonAutoDetect.Visibility visibilityCreatorVisibility = jsonAutoDetect.creatorVisibility();
        JsonAutoDetect.Visibility visibility12 = visibilityCreatorVisibility == visibility7 ? visibility3 : visibilityCreatorVisibility;
        JsonAutoDetect.Visibility visibilityFieldVisibility = jsonAutoDetect.fieldVisibility();
        JsonAutoDetect.Visibility visibility13 = visibilityFieldVisibility == visibility7 ? visibility2 : visibilityFieldVisibility;
        return (visibility8 == std.f4169a && visibility9 == visibility5 && visibility11 == visibility4 && visibility12 == visibility3 && visibility13 == visibility2) ? std : new VisibilityChecker.Std(visibility8, visibility9, visibility11, visibility12, visibility13);
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public final Class<?>[] b0(i3.a aVar) {
        y yVar = (y) aVar.c(y.class);
        if (yVar == null) {
            return null;
        }
        return yVar.value();
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public final Object c(i3.a aVar) {
        Class<? extends b3.c> clsContentUsing;
        c3.c cVar = (c3.c) aVar.c(c3.c.class);
        if (cVar == null || (clsContentUsing = cVar.contentUsing()) == c.a.class) {
            return null;
        }
        return clsContentUsing;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public final Boolean c0(AnnotatedMember annotatedMember) {
        u2.c cVar = (u2.c) annotatedMember.c(u2.c.class);
        if (cVar == null) {
            return null;
        }
        return Boolean.valueOf(cVar.enabled());
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public final Object d(i3.a aVar) {
        Class<? extends b3.f> clsContentUsing;
        JsonSerialize jsonSerialize = (JsonSerialize) aVar.c(JsonSerialize.class);
        if (jsonSerialize == null || (clsContentUsing = jsonSerialize.contentUsing()) == f.a.class) {
            return null;
        }
        return clsContentUsing;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    @Deprecated
    public final boolean d0(AnnotatedMethod annotatedMethod) {
        return annotatedMethod.l(u2.c.class);
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public final JsonCreator.Mode e(MapperConfig<?> mapperConfig, i3.a aVar) {
        h3.c cVar;
        Boolean boolC;
        JsonCreator jsonCreator = (JsonCreator) aVar.c(JsonCreator.class);
        if (jsonCreator != null) {
            return jsonCreator.mode();
        }
        if (this.f4164b && mapperConfig.k(MapperFeature.INFER_CREATOR_FROM_CONSTRUCTOR_PROPERTIES) && (aVar instanceof AnnotatedConstructor) && (cVar = f4162e) != null && (boolC = cVar.c(aVar)) != null && boolC.booleanValue()) {
            return JsonCreator.Mode.f3431c;
        }
        return null;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public final Boolean e0(AnnotatedMember annotatedMember) {
        u2.d dVar = (u2.d) annotatedMember.c(u2.d.class);
        if (dVar == null) {
            return null;
        }
        return Boolean.valueOf(dVar.enabled());
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    @Deprecated
    public final JsonCreator.Mode f(i3.a aVar) {
        JsonCreator jsonCreator = (JsonCreator) aVar.c(JsonCreator.class);
        if (jsonCreator == null) {
            return null;
        }
        return jsonCreator.mode();
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public final Boolean f0(AnnotatedMember annotatedMember) {
        m mVar = (m) annotatedMember.c(m.class);
        if (mVar == null) {
            return null;
        }
        return Boolean.valueOf(mVar.value());
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public final Enum<?> g(Class<Enum<?>> cls) {
        Annotation[] annotationArr = com.fasterxml.jackson.databind.util.a.f4529a;
        for (Field field : cls.getDeclaredFields()) {
            if (field.isEnumConstant() && field.getAnnotation(u2.f.class) != null) {
                String name = field.getName();
                for (Enum<?> r72 : cls.getEnumConstants()) {
                    if (name.equals(r72.name())) {
                        return r72;
                    }
                }
            }
        }
        return null;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public final Boolean g0(AnnotatedMember annotatedMember) {
        x xVar = (x) annotatedMember.c(x.class);
        if (xVar == null) {
            return null;
        }
        return Boolean.valueOf(xVar.value());
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public final Object h(AnnotatedMember annotatedMember) {
        Class clsR0;
        c3.c cVar = (c3.c) annotatedMember.c(c3.c.class);
        if (cVar == null || (clsR0 = r0(cVar.contentConverter())) == null || clsR0 == g.a.class) {
            return null;
        }
        return clsR0;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    @Deprecated
    public final boolean h0(AnnotatedMethod annotatedMethod) {
        x xVar = (x) annotatedMethod.c(x.class);
        return xVar != null && xVar.value();
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public final Object i(i3.a aVar) {
        Class clsR0;
        c3.c cVar = (c3.c) aVar.c(c3.c.class);
        if (cVar == null || (clsR0 = r0(cVar.converter())) == null || clsR0 == g.a.class) {
            return null;
        }
        return clsR0;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    @Deprecated
    public final boolean i0(i3.a aVar) {
        h3.c cVar;
        Boolean boolC;
        JsonCreator jsonCreator = (JsonCreator) aVar.c(JsonCreator.class);
        if (jsonCreator != null) {
            return jsonCreator.mode() != JsonCreator.Mode.f3432d;
        }
        if (!this.f4164b || !(aVar instanceof AnnotatedConstructor) || (cVar = f4162e) == null || (boolC = cVar.c(aVar)) == null) {
            return false;
        }
        return boolC.booleanValue();
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public final Object j(i3.a aVar) {
        Class<? extends b3.c> clsUsing;
        c3.c cVar = (c3.c) aVar.c(c3.c.class);
        if (cVar == null || (clsUsing = cVar.using()) == c.a.class) {
            return null;
        }
        return clsUsing;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public final boolean j0(AnnotatedMember annotatedMember) {
        Boolean boolB;
        k kVar = (k) annotatedMember.c(k.class);
        if (kVar != null) {
            return kVar.value();
        }
        h3.c cVar = f4162e;
        if (cVar == null || (boolB = cVar.b(annotatedMember)) == null) {
            return false;
        }
        return boolB.booleanValue();
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public final void k(Class<?> cls, Enum<?>[] enumArr, String[][] strArr) {
        u2.b bVar;
        for (Field field : cls.getDeclaredFields()) {
            if (field.isEnumConstant() && (bVar = (u2.b) field.getAnnotation(u2.b.class)) != null) {
                String[] strArrValue = bVar.value();
                if (strArrValue.length != 0) {
                    String name = field.getName();
                    int length = enumArr.length;
                    for (int i10 = 0; i10 < length; i10++) {
                        if (name.equals(enumArr[i10].name())) {
                            strArr[i10] = strArrValue;
                        }
                    }
                }
            }
        }
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public final Boolean k0(AnnotatedMember annotatedMember) {
        JsonProperty jsonProperty = (JsonProperty) annotatedMember.c(JsonProperty.class);
        if (jsonProperty != null) {
            return Boolean.valueOf(jsonProperty.required());
        }
        return null;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public final String[] l(Class<?> cls, Enum<?>[] enumArr, String[] strArr) {
        JsonProperty jsonProperty;
        HashMap map = null;
        for (Field field : cls.getDeclaredFields()) {
            if (field.isEnumConstant() && (jsonProperty = (JsonProperty) field.getAnnotation(JsonProperty.class)) != null) {
                String strValue = jsonProperty.value();
                if (!strValue.isEmpty()) {
                    if (map == null) {
                        map = new HashMap();
                    }
                    map.put(field.getName(), strValue);
                }
            }
        }
        if (map != null) {
            int length = enumArr.length;
            for (int i10 = 0; i10 < length; i10++) {
                String str = (String) map.get(enumArr[i10].name());
                if (str != null) {
                    strArr[i10] = str;
                }
            }
        }
        return strArr;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public final boolean l0(Annotation annotation) {
        Class<? extends Annotation> clsAnnotationType = annotation.annotationType();
        Boolean boolValueOf = this.f4163a.f4509b.get(clsAnnotationType);
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(clsAnnotationType.getAnnotation(u2.a.class) != null);
            this.f4163a.b(boolValueOf, clsAnnotationType);
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public final Object m(i3.a aVar) {
        u2.g gVar = (u2.g) aVar.c(u2.g.class);
        if (gVar == null) {
            return null;
        }
        String strValue = gVar.value();
        if (strValue.isEmpty()) {
            return null;
        }
        return strValue;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public final Boolean m0(a aVar) {
        l lVar = (l) aVar.f4182m.a(l.class);
        if (lVar == null) {
            return null;
        }
        return Boolean.valueOf(lVar.value());
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public final JsonFormat.Value n(i3.a aVar) {
        JsonFormat jsonFormat = (JsonFormat) aVar.c(JsonFormat.class);
        if (jsonFormat == null) {
            return null;
        }
        String strPattern = jsonFormat.pattern();
        JsonFormat.Shape shape = jsonFormat.shape();
        String strLocale = jsonFormat.locale();
        String strTimezone = jsonFormat.timezone();
        JsonFormat.Feature[] featureArrWith = jsonFormat.with();
        JsonFormat.Feature[] featureArrWithout = jsonFormat.without();
        int iOrdinal = 0;
        for (JsonFormat.Feature feature : featureArrWith) {
            iOrdinal |= 1 << feature.ordinal();
        }
        int iOrdinal2 = 0;
        for (JsonFormat.Feature feature2 : featureArrWithout) {
            iOrdinal2 |= 1 << feature2.ordinal();
        }
        JsonFormat.a aVar2 = new JsonFormat.a(iOrdinal, iOrdinal2);
        OptBoolean optBooleanLenient = jsonFormat.lenient();
        optBooleanLenient.getClass();
        return new JsonFormat.Value(strPattern, shape, strLocale, strTimezone, aVar2, optBooleanLenient != OptBoolean.f3502b ? optBooleanLenient == OptBoolean.f3501a ? Boolean.TRUE : Boolean.FALSE : null);
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public final Boolean n0(AnnotatedMember annotatedMember) {
        return Boolean.valueOf(annotatedMember.l(u.class));
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0016  */
    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String o(com.fasterxml.jackson.databind.introspect.AnnotatedMember r2) {
        /*
            r1 = this;
            boolean r1 = r2 instanceof com.fasterxml.jackson.databind.introspect.AnnotatedParameter
            r0 = 0
            if (r1 == 0) goto L16
            com.fasterxml.jackson.databind.introspect.AnnotatedParameter r2 = (com.fasterxml.jackson.databind.introspect.AnnotatedParameter) r2
            com.fasterxml.jackson.databind.introspect.AnnotatedWithParams r1 = r2.f4129c
            if (r1 == 0) goto L16
            h3.c r1 = com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector.f4162e
            if (r1 == 0) goto L16
            com.fasterxml.jackson.databind.PropertyName r1 = r1.a(r2)
            if (r1 == 0) goto L16
            goto L17
        L16:
            r1 = r0
        L17:
            if (r1 != 0) goto L1a
            return r0
        L1a:
            java.lang.String r1 = r1.f3755a
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector.o(com.fasterxml.jackson.databind.introspect.AnnotatedMember):java.lang.String");
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public final JavaType o0(MapperConfig<?> mapperConfig, i3.a aVar, JavaType javaType) throws JsonMappingException {
        TypeFactory typeFactory = mapperConfig.f3828b.f3789a;
        c3.c cVar = (c3.c) aVar.c(c3.c.class);
        Class<?> clsR0 = cVar == null ? null : r0(cVar.as());
        if (clsR0 != null && !javaType.u(clsR0) && !t0(javaType, clsR0)) {
            try {
                javaType = typeFactory.i(javaType, clsR0, false);
            } catch (IllegalArgumentException e10) {
                throw new JsonMappingException((Closeable) null, String.format("Failed to narrow type %s with annotation (value %s), from '%s': %s", javaType, clsR0.getName(), aVar.d(), e10.getMessage()), e10);
            }
        }
        if (javaType.B()) {
            JavaType javaTypeO = javaType.o();
            Class<?> clsR02 = cVar == null ? null : r0(cVar.keyAs());
            if (clsR02 != null && !t0(javaTypeO, clsR02)) {
                try {
                    javaType = ((MapLikeType) javaType).R(typeFactory.i(javaTypeO, clsR02, false));
                } catch (IllegalArgumentException e11) {
                    throw new JsonMappingException((Closeable) null, String.format("Failed to narrow key type of %s with concrete-type annotation (value %s), from '%s': %s", javaType, clsR02.getName(), aVar.d(), e11.getMessage()), e11);
                }
            }
        }
        JavaType javaTypeK = javaType.k();
        if (javaTypeK != null) {
            Class<?> clsR03 = cVar == null ? null : r0(cVar.contentAs());
            if (clsR03 != null && !t0(javaTypeK, clsR03)) {
                try {
                    return javaType.G(typeFactory.i(javaTypeK, clsR03, false));
                } catch (IllegalArgumentException e12) {
                    throw new JsonMappingException((Closeable) null, String.format("Failed to narrow value type of %s with concrete-type annotation (value %s), from '%s': %s", javaType, clsR03.getName(), aVar.d(), e12.getMessage()), e12);
                }
            }
        }
        return javaType;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public final JacksonInject.Value p(AnnotatedMember annotatedMember) {
        String name;
        JacksonInject jacksonInject = (JacksonInject) annotatedMember.c(JacksonInject.class);
        if (jacksonInject == null) {
            return null;
        }
        String strValue = jacksonInject.value();
        OptBoolean optBooleanUseInput = jacksonInject.useInput();
        optBooleanUseInput.getClass();
        Boolean bool = optBooleanUseInput == OptBoolean.f3502b ? null : optBooleanUseInput == OptBoolean.f3501a ? Boolean.TRUE : Boolean.FALSE;
        String str = "".equals(strValue) ? null : strValue;
        JacksonInject.Value value = (str == null && bool == null) ? JacksonInject.Value.f3421c : new JacksonInject.Value(str, bool);
        Object obj = value.f3422a;
        if (obj == null) {
            if (annotatedMember instanceof AnnotatedMethod) {
                AnnotatedMethod annotatedMethod = (AnnotatedMethod) annotatedMember;
                name = annotatedMethod.v().length == 0 ? annotatedMember.e().getName() : annotatedMethod.u(0).getName();
            } else {
                name = annotatedMember.e().getName();
            }
            if (!name.equals(obj)) {
                return new JacksonInject.Value(name, value.f3423b);
            }
        }
        return value;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public final JavaType p0(MapperConfig<?> mapperConfig, i3.a aVar, JavaType javaType) throws JsonMappingException {
        JavaType javaTypeK;
        JavaType javaTypeK2;
        TypeFactory typeFactory = mapperConfig.f3828b.f3789a;
        JsonSerialize jsonSerialize = (JsonSerialize) aVar.c(JsonSerialize.class);
        Class<?> clsR0 = jsonSerialize == null ? null : r0(jsonSerialize.as());
        if (clsR0 != null) {
            if (javaType.u(clsR0)) {
                javaType = javaType.K();
            } else {
                Class<?> cls = javaType.f3690a;
                try {
                    if (clsR0.isAssignableFrom(cls)) {
                        typeFactory.getClass();
                        javaType = TypeFactory.g(javaType, clsR0);
                    } else if (cls.isAssignableFrom(clsR0)) {
                        javaType = typeFactory.i(javaType, clsR0, false);
                    } else {
                        if (!u0(cls, clsR0)) {
                            throw new JsonMappingException(null, String.format("Cannot refine serialization type %s into %s; types not related", javaType, clsR0.getName()));
                        }
                        javaType = javaType.K();
                    }
                } catch (IllegalArgumentException e10) {
                    throw new JsonMappingException((Closeable) null, String.format("Failed to widen type %s with annotation (value %s), from '%s': %s", javaType, clsR0.getName(), aVar.d(), e10.getMessage()), e10);
                }
            }
        }
        if (javaType.B()) {
            JavaType javaTypeO = javaType.o();
            Class<?> clsR02 = jsonSerialize == null ? null : r0(jsonSerialize.keyAs());
            if (clsR02 != null) {
                if (javaTypeO.u(clsR02)) {
                    javaTypeK2 = javaTypeO.K();
                } else {
                    Class<?> cls2 = javaTypeO.f3690a;
                    try {
                        if (clsR02.isAssignableFrom(cls2)) {
                            typeFactory.getClass();
                            javaTypeK2 = TypeFactory.g(javaTypeO, clsR02);
                        } else if (cls2.isAssignableFrom(clsR02)) {
                            javaTypeK2 = typeFactory.i(javaTypeO, clsR02, false);
                        } else {
                            if (!u0(cls2, clsR02)) {
                                throw new JsonMappingException(null, String.format("Cannot refine serialization key type %s into %s; types not related", javaTypeO, clsR02.getName()));
                            }
                            javaTypeK2 = javaTypeO.K();
                        }
                    } catch (IllegalArgumentException e11) {
                        throw new JsonMappingException((Closeable) null, String.format("Failed to widen key type of %s with concrete-type annotation (value %s), from '%s': %s", javaType, clsR02.getName(), aVar.d(), e11.getMessage()), e11);
                    }
                }
                javaType = ((MapLikeType) javaType).R(javaTypeK2);
            }
        }
        JavaType javaTypeK3 = javaType.k();
        if (javaTypeK3 != null) {
            Class<?> clsR03 = jsonSerialize == null ? null : r0(jsonSerialize.contentAs());
            if (clsR03 != null) {
                if (javaTypeK3.u(clsR03)) {
                    javaTypeK = javaTypeK3.K();
                } else {
                    Class<?> cls3 = javaTypeK3.f3690a;
                    try {
                        if (clsR03.isAssignableFrom(cls3)) {
                            typeFactory.getClass();
                            javaTypeK = TypeFactory.g(javaTypeK3, clsR03);
                        } else if (cls3.isAssignableFrom(clsR03)) {
                            javaTypeK = typeFactory.i(javaTypeK3, clsR03, false);
                        } else {
                            if (!u0(cls3, clsR03)) {
                                throw new JsonMappingException(null, String.format("Cannot refine serialization content type %s into %s; types not related", javaTypeK3, clsR03.getName()));
                            }
                            javaTypeK = javaTypeK3.K();
                        }
                    } catch (IllegalArgumentException e12) {
                        throw new JsonMappingException((Closeable) null, String.format("Internal error: failed to refine value type of %s with concrete-type annotation (value %s), from '%s': %s", javaType, clsR03.getName(), aVar.d(), e12.getMessage()), e12);
                    }
                }
                return javaType.G(javaTypeK);
            }
        }
        return javaType;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    @Deprecated
    public final Object q(AnnotatedMember annotatedMember) {
        JacksonInject.Value valueP = p(annotatedMember);
        if (valueP == null) {
            return null;
        }
        return valueP.f3422a;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public final AnnotatedMethod q0(AnnotatedMethod annotatedMethod, AnnotatedMethod annotatedMethod2) {
        Class<?> clsU = annotatedMethod.u(0);
        Class<?> clsU2 = annotatedMethod2.u(0);
        if (clsU.isPrimitive()) {
            if (clsU2.isPrimitive()) {
            }
            return annotatedMethod;
        }
        if (!clsU2.isPrimitive()) {
        }
        return annotatedMethod2;
        if (clsU == String.class) {
            if (clsU2 != String.class) {
                return annotatedMethod;
            }
            return null;
        }
        if (clsU2 == String.class) {
            return annotatedMethod2;
        }
        return null;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public final Object r(i3.a aVar) {
        Class<? extends b3.g> clsKeyUsing;
        c3.c cVar = (c3.c) aVar.c(c3.c.class);
        if (cVar == null || (clsKeyUsing = cVar.keyUsing()) == g.a.class) {
            return null;
        }
        return clsKeyUsing;
    }

    public Object readResolve() {
        if (this.f4163a == null) {
            this.f4163a = new LRUMap<>(48, 48);
        }
        return this;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public final Object s(i3.a aVar) {
        Class<? extends b3.f> clsKeyUsing;
        JsonSerialize jsonSerialize = (JsonSerialize) aVar.c(JsonSerialize.class);
        if (jsonSerialize == null || (clsKeyUsing = jsonSerialize.keyUsing()) == f.a.class) {
            return null;
        }
        return clsKeyUsing;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public final Boolean t(AnnotatedMember annotatedMember) {
        o oVar = (o) annotatedMember.c(o.class);
        if (oVar == null) {
            return null;
        }
        OptBoolean optBooleanValue = oVar.value();
        optBooleanValue.getClass();
        if (optBooleanValue == OptBoolean.f3502b) {
            return null;
        }
        return optBooleanValue == OptBoolean.f3501a ? Boolean.TRUE : Boolean.FALSE;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public final PropertyName u(AnnotatedMember annotatedMember) {
        boolean z;
        JsonSetter jsonSetter = (JsonSetter) annotatedMember.c(JsonSetter.class);
        if (jsonSetter != null) {
            String strValue = jsonSetter.value();
            if (!strValue.isEmpty()) {
                return PropertyName.a(strValue);
            }
            z = true;
        } else {
            z = false;
        }
        JsonProperty jsonProperty = (JsonProperty) annotatedMember.c(JsonProperty.class);
        if (jsonProperty != null) {
            String strNamespace = jsonProperty.namespace();
            return PropertyName.b(jsonProperty.value(), (strNamespace == null || !strNamespace.isEmpty()) ? strNamespace : null);
        }
        if (z || annotatedMember.m(f4161d)) {
            return PropertyName.f3753d;
        }
        return null;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public final PropertyName v(AnnotatedMember annotatedMember) {
        boolean z;
        u2.h hVar = (u2.h) annotatedMember.c(u2.h.class);
        if (hVar != null) {
            String strValue = hVar.value();
            if (!strValue.isEmpty()) {
                return PropertyName.a(strValue);
            }
            z = true;
        } else {
            z = false;
        }
        JsonProperty jsonProperty = (JsonProperty) annotatedMember.c(JsonProperty.class);
        if (jsonProperty != null) {
            String strNamespace = jsonProperty.namespace();
            return PropertyName.b(jsonProperty.value(), (strNamespace == null || !strNamespace.isEmpty()) ? strNamespace : null);
        }
        if (z || annotatedMember.m(f4160c)) {
            return PropertyName.f3753d;
        }
        return null;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public final Object w(a aVar) {
        c3.d dVar = (c3.d) aVar.f4182m.a(c3.d.class);
        if (dVar == null) {
            return null;
        }
        return dVar.value();
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public final Object x(AnnotatedMember annotatedMember) {
        Class<? extends b3.f> clsNullsUsing;
        JsonSerialize jsonSerialize = (JsonSerialize) annotatedMember.c(JsonSerialize.class);
        if (jsonSerialize == null || (clsNullsUsing = jsonSerialize.nullsUsing()) == f.a.class) {
            return null;
        }
        return clsNullsUsing;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public final i3.h y(i3.a aVar) {
        u2.i iVar = (u2.i) aVar.c(u2.i.class);
        if (iVar == null || iVar.generator() == ObjectIdGenerators$None.class) {
            return null;
        }
        return new i3.h(PropertyName.a(iVar.property()), iVar.scope(), iVar.generator(), false, iVar.resolver());
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public final i3.h z(i3.a aVar, i3.h hVar) {
        u2.j jVar = (u2.j) aVar.c(u2.j.class);
        if (jVar == null) {
            return hVar;
        }
        if (hVar == null) {
            hVar = i3.h.f9510f;
        }
        boolean zAlwaysAsId = jVar.alwaysAsId();
        return hVar.f9515e == zAlwaysAsId ? hVar : new i3.h(hVar.f9511a, hVar.f9514d, hVar.f9512b, zAlwaysAsId, hVar.f9513c);
    }
}
