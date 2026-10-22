package i3;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import q3.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class d extends b3.a {

    /* renamed from: j, reason: collision with root package name */
    public static final Class<?>[] f9495j = new Class[0];

    /* renamed from: b, reason: collision with root package name */
    public final com.fasterxml.jackson.databind.introspect.h f9496b;

    /* renamed from: c, reason: collision with root package name */
    public final MapperConfig<?> f9497c;

    /* renamed from: d, reason: collision with root package name */
    public final AnnotationIntrospector f9498d;

    /* renamed from: e, reason: collision with root package name */
    public final com.fasterxml.jackson.databind.introspect.a f9499e;

    /* renamed from: f, reason: collision with root package name */
    public Class<?>[] f9500f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f9501g;
    public List<e> h;

    /* renamed from: i, reason: collision with root package name */
    public final h f9502i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(JavaType javaType, MapperConfig mapperConfig, com.fasterxml.jackson.databind.introspect.a aVar) {
        super(javaType);
        List<e> list = Collections.EMPTY_LIST;
        this.f9496b = null;
        this.f9497c = mapperConfig;
        if (mapperConfig == null) {
            this.f9498d = null;
        } else {
            this.f9498d = mapperConfig.d();
        }
        this.f9499e = aVar;
        this.h = list;
    }

    public static d g(JavaType javaType, MapperConfig mapperConfig, com.fasterxml.jackson.databind.introspect.a aVar) {
        List list = Collections.EMPTY_LIST;
        return new d(javaType, mapperConfig, aVar);
    }

    @Override // b3.a
    public final JsonFormat.Value a() {
        JsonFormat.Value valueN;
        com.fasterxml.jackson.databind.introspect.a aVar = this.f9499e;
        AnnotationIntrospector annotationIntrospector = this.f9498d;
        if (annotationIntrospector == null || (valueN = annotationIntrospector.n(aVar)) == null) {
            valueN = null;
        }
        JsonFormat.Value valueF = this.f9497c.f(aVar.f4175b);
        return valueF != null ? valueN == null ? valueF : valueN.e(valueF) : valueN;
    }

    @Override // b3.a
    public final List<AnnotatedMethod> b() {
        List<AnnotatedMethod> list = this.f9499e.g().f4189c;
        if (list.isEmpty()) {
            return list;
        }
        ArrayList arrayList = null;
        for (AnnotatedMethod annotatedMethod : list) {
            if (i(annotatedMethod)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(annotatedMethod);
            }
        }
        return arrayList == null ? Collections.EMPTY_LIST : arrayList;
    }

    public final q3.g<Object, Object> c(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof q3.g) {
            return (q3.g) obj;
        }
        if (!(obj instanceof Class)) {
            throw new IllegalStateException("AnnotationIntrospector returned Converter definition of type " + obj.getClass().getName() + "; expected type Converter or Class<Converter> instead");
        }
        Class cls = (Class) obj;
        if (cls == g.a.class || com.fasterxml.jackson.databind.util.a.t(cls)) {
            return null;
        }
        if (q3.g.class.isAssignableFrom(cls)) {
            MapperConfig<?> mapperConfig = this.f9497c;
            mapperConfig.h();
            return (q3.g) com.fasterxml.jackson.databind.util.a.h(cls, mapperConfig.k(MapperFeature.CAN_OVERRIDE_ACCESS_MODIFIERS));
        }
        throw new IllegalStateException("AnnotationIntrospector returned Class " + cls.getName() + "; expected Class<Converter>");
    }

    public final List<e> d() {
        if (this.h == null) {
            com.fasterxml.jackson.databind.introspect.h hVar = this.f9496b;
            if (!hVar.f4221i) {
                hVar.g();
            }
            this.h = new ArrayList(hVar.f4222j.values());
        }
        return this.h;
    }

    public final Class<?>[] e() {
        if (!this.f9501g) {
            this.f9501g = true;
            AnnotationIntrospector annotationIntrospector = this.f9498d;
            Class<?>[] clsArrB0 = annotationIntrospector == null ? null : annotationIntrospector.b0(this.f9499e);
            if (clsArrB0 == null && !this.f9497c.k(MapperFeature.DEFAULT_VIEW_INCLUSION)) {
                clsArrB0 = f9495j;
            }
            this.f9500f = clsArrB0;
        }
        return this.f9500f;
    }

    public final AnnotatedMember f() {
        com.fasterxml.jackson.databind.introspect.h hVar = this.f9496b;
        if (hVar != null) {
            if (!hVar.f4221i) {
                hVar.g();
            }
            LinkedList<AnnotatedMember> linkedList = hVar.f4229q;
            if (linkedList != null) {
                if (linkedList.size() <= 1) {
                    return hVar.f4229q.get(0);
                }
                hVar.h("Multiple 'as-value' properties defined (%s vs %s)", hVar.f4229q.get(0), hVar.f4229q.get(1));
                throw null;
            }
        }
        return null;
    }

    public final boolean h(PropertyName propertyName) {
        e next;
        Iterator<e> it = d().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (next.x(propertyName)) {
                break;
            }
        }
        return next != null;
    }

    public final boolean i(AnnotatedMethod annotatedMethod) {
        Class<?> clsU;
        if (!this.f3041a.f3690a.isAssignableFrom(annotatedMethod.f4124d.getReturnType())) {
            return false;
        }
        JsonCreator.Mode modeE = this.f9498d.e(this.f9497c, annotatedMethod);
        if (modeE != null && modeE != JsonCreator.Mode.f3432d) {
            return true;
        }
        String name = annotatedMethod.f4124d.getName();
        if ("valueOf".equals(name) && annotatedMethod.v().length == 1) {
            return true;
        }
        return "fromString".equals(name) && annotatedMethod.v().length == 1 && ((clsU = annotatedMethod.u(0)) == String.class || CharSequence.class.isAssignableFrom(clsU));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public d(com.fasterxml.jackson.databind.introspect.h hVar) {
        JavaType javaType = hVar.f4217d;
        com.fasterxml.jackson.databind.introspect.a aVar = hVar.f4218e;
        super(javaType);
        this.f9496b = hVar;
        MapperConfig<?> mapperConfig = hVar.f4214a;
        this.f9497c = mapperConfig;
        if (mapperConfig == null) {
            this.f9498d = null;
        } else {
            this.f9498d = mapperConfig.d();
        }
        this.f9499e = aVar;
        AnnotationIntrospector annotationIntrospector = hVar.f4220g;
        h hVarY = annotationIntrospector.y(aVar);
        this.f9502i = hVarY != null ? annotationIntrospector.z(aVar, hVarY) : hVarY;
    }
}
