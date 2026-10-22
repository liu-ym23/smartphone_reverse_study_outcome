package com.fasterxml.jackson.databind;

import c3.e;
import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.databind.introspect.a;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.fasterxml.jackson.databind.util.NameTransformer;
import i3.h;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import k3.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class AnnotationIntrospector implements Serializable {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class ReferenceProperty {

        /* renamed from: a, reason: collision with root package name */
        public final Type f3647a;

        /* renamed from: b, reason: collision with root package name */
        public final String f3648b;

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public static final class Type {

            /* renamed from: a, reason: collision with root package name */
            public static final Type f3649a;

            /* renamed from: b, reason: collision with root package name */
            public static final Type f3650b;

            /* renamed from: c, reason: collision with root package name */
            public static final /* synthetic */ Type[] f3651c;

            static {
                Type type = new Type("MANAGED_REFERENCE", 0);
                f3649a = type;
                Type type2 = new Type("BACK_REFERENCE", 1);
                f3650b = type2;
                f3651c = new Type[]{type, type2};
            }

            public Type() {
                throw null;
            }

            public static Type valueOf(String str) {
                return (Type) Enum.valueOf(Type.class, str);
            }

            public static Type[] values() {
                return (Type[]) f3651c.clone();
            }
        }

        public ReferenceProperty(Type type, String str) {
            this.f3647a = type;
            this.f3648b = str;
        }
    }

    public Class<?> A(a aVar) {
        return null;
    }

    public e.a B(a aVar) {
        return null;
    }

    public JsonProperty.Access C(i3.a aVar) {
        return null;
    }

    public List D(AnnotatedMember annotatedMember) {
        return null;
    }

    public d<?> E(MapperConfig<?> mapperConfig, AnnotatedMember annotatedMember, JavaType javaType) {
        return null;
    }

    public String F(AnnotatedMember annotatedMember) {
        return null;
    }

    public String G(AnnotatedMember annotatedMember) {
        return null;
    }

    public JsonIgnoreProperties.Value H(i3.a aVar) {
        return I(aVar);
    }

    @Deprecated
    public JsonIgnoreProperties.Value I(i3.a aVar) {
        return JsonIgnoreProperties.Value.h;
    }

    public JsonInclude.Value J(i3.a aVar) {
        return JsonInclude.Value.f3469e;
    }

    public JsonIncludeProperties.Value K(i3.a aVar) {
        return JsonIncludeProperties.Value.f3474b;
    }

    public Integer L(AnnotatedMember annotatedMember) {
        return null;
    }

    public d<?> M(MapperConfig<?> mapperConfig, AnnotatedMember annotatedMember, JavaType javaType) {
        return null;
    }

    public ReferenceProperty N(AnnotatedMember annotatedMember) {
        return null;
    }

    public PropertyName O(a aVar) {
        return null;
    }

    public Object P(AnnotatedMember annotatedMember) {
        return null;
    }

    public Object Q(i3.a aVar) {
        return null;
    }

    public String[] R(a aVar) {
        return null;
    }

    public Boolean S(i3.a aVar) {
        return null;
    }

    public JsonSerialize.Typing T(i3.a aVar) {
        return null;
    }

    public Object U(i3.a aVar) {
        return null;
    }

    public JsonSetter.Value V(AnnotatedMember annotatedMember) {
        return JsonSetter.Value.f3478c;
    }

    public List<NamedType> W(i3.a aVar) {
        return null;
    }

    public String X(a aVar) {
        return null;
    }

    public d Y(JavaType javaType, MapperConfig mapperConfig, a aVar) {
        return null;
    }

    public NameTransformer Z(AnnotatedMember annotatedMember) {
        return null;
    }

    public Object a0(a aVar) {
        return null;
    }

    public Class<?>[] b0(i3.a aVar) {
        return null;
    }

    public Object c(i3.a aVar) {
        return null;
    }

    public Boolean c0(AnnotatedMember annotatedMember) {
        if ((annotatedMember instanceof AnnotatedMethod) && d0((AnnotatedMethod) annotatedMember)) {
            return Boolean.TRUE;
        }
        return null;
    }

    public Object d(i3.a aVar) {
        return null;
    }

    @Deprecated
    public boolean d0(AnnotatedMethod annotatedMethod) {
        return false;
    }

    public JsonCreator.Mode e(MapperConfig<?> mapperConfig, i3.a aVar) {
        if (!i0(aVar)) {
            return null;
        }
        JsonCreator.Mode modeF = f(aVar);
        return modeF == null ? JsonCreator.Mode.f3429a : modeF;
    }

    public Boolean e0(AnnotatedMember annotatedMember) {
        return null;
    }

    @Deprecated
    public JsonCreator.Mode f(i3.a aVar) {
        return null;
    }

    public Boolean f0(AnnotatedMember annotatedMember) {
        return null;
    }

    public Enum<?> g(Class<Enum<?>> cls) {
        return null;
    }

    public Boolean g0(AnnotatedMember annotatedMember) {
        if ((annotatedMember instanceof AnnotatedMethod) && h0((AnnotatedMethod) annotatedMember)) {
            return Boolean.TRUE;
        }
        return null;
    }

    public Object h(AnnotatedMember annotatedMember) {
        return null;
    }

    @Deprecated
    public boolean h0(AnnotatedMethod annotatedMethod) {
        return false;
    }

    public Object i(i3.a aVar) {
        return null;
    }

    @Deprecated
    public boolean i0(i3.a aVar) {
        return false;
    }

    public Object j(i3.a aVar) {
        return null;
    }

    public boolean j0(AnnotatedMember annotatedMember) {
        return false;
    }

    public Boolean k0(AnnotatedMember annotatedMember) {
        return null;
    }

    public boolean l0(Annotation annotation) {
        return false;
    }

    public Object m(i3.a aVar) {
        return null;
    }

    public Boolean m0(a aVar) {
        return null;
    }

    public JsonFormat.Value n(i3.a aVar) {
        return JsonFormat.Value.f3449k;
    }

    public Boolean n0(AnnotatedMember annotatedMember) {
        return null;
    }

    public String o(AnnotatedMember annotatedMember) {
        return null;
    }

    public JacksonInject.Value p(AnnotatedMember annotatedMember) {
        Object objQ = q(annotatedMember);
        if (objQ == null) {
            return null;
        }
        if ("".equals(objQ)) {
            objQ = null;
        }
        return objQ == null ? JacksonInject.Value.f3421c : new JacksonInject.Value(objQ, null);
    }

    @Deprecated
    public Object q(AnnotatedMember annotatedMember) {
        return null;
    }

    public AnnotatedMethod q0(AnnotatedMethod annotatedMethod, AnnotatedMethod annotatedMethod2) {
        return null;
    }

    public Object r(i3.a aVar) {
        return null;
    }

    public Object s(i3.a aVar) {
        return null;
    }

    public Boolean t(AnnotatedMember annotatedMember) {
        return null;
    }

    public PropertyName u(AnnotatedMember annotatedMember) {
        return null;
    }

    public PropertyName v(AnnotatedMember annotatedMember) {
        return null;
    }

    public Object w(a aVar) {
        return null;
    }

    public Object x(AnnotatedMember annotatedMember) {
        return null;
    }

    public h y(i3.a aVar) {
        return null;
    }

    public VisibilityChecker<?> b(a aVar, VisibilityChecker<?> visibilityChecker) {
        return visibilityChecker;
    }

    public h z(i3.a aVar, h hVar) {
        return hVar;
    }

    public void a(MapperConfig mapperConfig, a aVar, ArrayList arrayList) {
    }

    public void k(Class<?> cls, Enum<?>[] enumArr, String[][] strArr) {
    }

    public String[] l(Class<?> cls, Enum<?>[] enumArr, String[] strArr) {
        return strArr;
    }

    public JavaType o0(MapperConfig<?> mapperConfig, i3.a aVar, JavaType javaType) {
        return javaType;
    }

    public JavaType p0(MapperConfig<?> mapperConfig, i3.a aVar, JavaType javaType) {
        return javaType;
    }
}
