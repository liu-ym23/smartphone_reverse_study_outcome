package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.cfg.MapperConfigBase;
import com.fasterxml.jackson.databind.introspect.AnnotationCollector;
import com.fasterxml.jackson.databind.introspect.f;
import com.fasterxml.jackson.databind.type.TypeBindings;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: g, reason: collision with root package name */
    public static final AnnotationCollector.NoAnnotations f4190g = AnnotationCollector.f4133a;
    public static final Class<?> h = Object.class;

    /* renamed from: i, reason: collision with root package name */
    public static final Class<?> f4191i = Enum.class;

    /* renamed from: j, reason: collision with root package name */
    public static final Class<?> f4192j = List.class;

    /* renamed from: k, reason: collision with root package name */
    public static final Class<?> f4193k = Map.class;

    /* renamed from: a, reason: collision with root package name */
    public final AnnotationIntrospector f4194a;

    /* renamed from: b, reason: collision with root package name */
    public final f.a f4195b;

    /* renamed from: c, reason: collision with root package name */
    public final TypeBindings f4196c;

    /* renamed from: d, reason: collision with root package name */
    public final Class<?> f4197d;

    /* renamed from: e, reason: collision with root package name */
    public final Class<?> f4198e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f4199f;

    public b(MapperConfig<?> mapperConfig, JavaType javaType, f.a aVar) {
        Class<?> cls = javaType.f3690a;
        this.f4197d = cls;
        this.f4195b = aVar;
        this.f4196c = javaType.j();
        mapperConfig.getClass();
        AnnotationIntrospector annotationIntrospectorD = mapperConfig.k(MapperFeature.USE_ANNOTATIONS) ? mapperConfig.d() : null;
        this.f4194a = annotationIntrospectorD;
        this.f4198e = aVar != null ? aVar.a(cls) : null;
        this.f4199f = (annotationIntrospectorD == null || (com.fasterxml.jackson.databind.util.a.u(cls) && javaType.y())) ? false : true;
    }

    public static void d(JavaType javaType, ArrayList arrayList, boolean z) {
        Class<?> cls = javaType.f3690a;
        if (z) {
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                if (((JavaType) arrayList.get(i10)).f3690a == cls) {
                    return;
                }
            }
            arrayList.add(javaType);
            if (cls == f4192j || cls == f4193k) {
                return;
            }
        }
        Iterator<JavaType> it = javaType.n().iterator();
        while (it.hasNext()) {
            d(it.next(), arrayList, true);
        }
    }

    public static void e(JavaType javaType, ArrayList arrayList, boolean z) {
        Class<?> cls = javaType.f3690a;
        if (cls == h || cls == f4191i) {
            return;
        }
        if (z) {
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                if (((JavaType) arrayList.get(i10)).f3690a == cls) {
                    return;
                }
            }
            arrayList.add(javaType);
        }
        Iterator<JavaType> it = javaType.n().iterator();
        while (it.hasNext()) {
            d(it.next(), arrayList, true);
        }
        JavaType javaTypeQ = javaType.q();
        if (javaTypeQ != null) {
            e(javaTypeQ, arrayList, true);
        }
    }

    public static a g(MapperConfig<?> mapperConfig, Class<?> cls) {
        if (cls.isArray()) {
            if (mapperConfig != null) {
                ((MapperConfigBase) mapperConfig).f3832c.getClass();
            }
            return new a(cls);
        }
        b bVar = new b(mapperConfig, cls, mapperConfig);
        List<JavaType> list = Collections.EMPTY_LIST;
        return new a(null, cls, list, bVar.f4198e, bVar.f(list), bVar.f4196c, bVar.f4194a, mapperConfig, mapperConfig.f3828b.f3789a, bVar.f4199f);
    }

    public final AnnotationCollector a(AnnotationCollector annotationCollector, Annotation[] annotationArr) {
        if (annotationArr != null) {
            for (Annotation annotation : annotationArr) {
                if (!annotationCollector.d(annotation)) {
                    annotationCollector = annotationCollector.a(annotation);
                    if (this.f4194a.l0(annotation)) {
                        annotationCollector = c(annotationCollector, annotation);
                    }
                }
            }
        }
        return annotationCollector;
    }

    public final AnnotationCollector b(AnnotationCollector annotationCollector, Class<?> cls, Class<?> cls2) {
        if (cls2 != null) {
            annotationCollector = a(annotationCollector, com.fasterxml.jackson.databind.util.a.j(cls2));
            int i10 = 0;
            ArrayList arrayListL = com.fasterxml.jackson.databind.util.a.l(cls2, cls, false);
            int size = arrayListL.size();
            while (i10 < size) {
                Object obj = arrayListL.get(i10);
                i10++;
                annotationCollector = a(annotationCollector, com.fasterxml.jackson.databind.util.a.j((Class) obj));
            }
        }
        return annotationCollector;
    }

    public final AnnotationCollector c(AnnotationCollector annotationCollector, Annotation annotation) {
        for (Annotation annotation2 : com.fasterxml.jackson.databind.util.a.j(annotation.annotationType())) {
            if (!(annotation2 instanceof Target) && !(annotation2 instanceof Retention) && !annotationCollector.d(annotation2)) {
                annotationCollector = annotationCollector.a(annotation2);
                if (this.f4194a.l0(annotation2)) {
                    annotationCollector = c(annotationCollector, annotation2);
                }
            }
        }
        return annotationCollector;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0018 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final q3.a f(java.util.List<com.fasterxml.jackson.databind.JavaType> r8) {
        /*
            r7 = this;
            com.fasterxml.jackson.databind.AnnotationIntrospector r0 = r7.f4194a
            if (r0 != 0) goto L5
            goto L1a
        L5:
            com.fasterxml.jackson.databind.introspect.f$a r0 = r7.f4195b
            if (r0 == 0) goto L13
            boolean r1 = r0 instanceof com.fasterxml.jackson.databind.introspect.SimpleMixInResolver
            if (r1 == 0) goto L11
            r1 = r0
            com.fasterxml.jackson.databind.introspect.SimpleMixInResolver r1 = (com.fasterxml.jackson.databind.introspect.SimpleMixInResolver) r1
            goto L13
        L11:
            r1 = 1
            goto L14
        L13:
            r1 = 0
        L14:
            boolean r2 = r7.f4199f
            if (r1 != 0) goto L1d
            if (r2 != 0) goto L1d
        L1a:
            com.fasterxml.jackson.databind.introspect.AnnotationCollector$NoAnnotations r7 = com.fasterxml.jackson.databind.introspect.b.f4190g
            return r7
        L1d:
            com.fasterxml.jackson.databind.introspect.AnnotationCollector$NoAnnotations r3 = com.fasterxml.jackson.databind.introspect.AnnotationCollector.f4133a
            com.fasterxml.jackson.databind.introspect.AnnotationCollector$a r3 = com.fasterxml.jackson.databind.introspect.AnnotationCollector.a.f4140b
            java.lang.Class<?> r4 = r7.f4197d
            java.lang.Class<?> r5 = r7.f4198e
            if (r5 == 0) goto L2b
            com.fasterxml.jackson.databind.introspect.AnnotationCollector r3 = r7.b(r3, r4, r5)
        L2b:
            if (r2 == 0) goto L35
            java.lang.annotation.Annotation[] r4 = com.fasterxml.jackson.databind.util.a.j(r4)
            com.fasterxml.jackson.databind.introspect.AnnotationCollector r3 = r7.a(r3, r4)
        L35:
            java.util.Iterator r8 = r8.iterator()
        L39:
            boolean r4 = r8.hasNext()
            if (r4 == 0) goto L5e
            java.lang.Object r4 = r8.next()
            com.fasterxml.jackson.databind.JavaType r4 = (com.fasterxml.jackson.databind.JavaType) r4
            if (r1 == 0) goto L51
            java.lang.Class<?> r5 = r4.f3690a
            java.lang.Class r6 = r0.a(r5)
            com.fasterxml.jackson.databind.introspect.AnnotationCollector r3 = r7.b(r3, r5, r6)
        L51:
            if (r2 == 0) goto L39
            java.lang.Class<?> r4 = r4.f3690a
            java.lang.annotation.Annotation[] r4 = com.fasterxml.jackson.databind.util.a.j(r4)
            com.fasterxml.jackson.databind.introspect.AnnotationCollector r3 = r7.a(r3, r4)
            goto L39
        L5e:
            if (r1 == 0) goto L6a
            java.lang.Class<java.lang.Object> r8 = java.lang.Object.class
            java.lang.Class r0 = r0.a(r8)
            com.fasterxml.jackson.databind.introspect.AnnotationCollector r3 = r7.b(r3, r8, r0)
        L6a:
            q3.a r7 = r3.c()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.introspect.b.f(java.util.List):q3.a");
    }

    public b(MapperConfig mapperConfig, Class cls, MapperConfig mapperConfig2) {
        this.f4197d = cls;
        this.f4195b = mapperConfig2;
        this.f4196c = TypeBindings.f4452j;
        if (mapperConfig == null) {
            this.f4194a = null;
            this.f4198e = null;
        } else {
            this.f4194a = mapperConfig.k(MapperFeature.USE_ANNOTATIONS) ? mapperConfig.d() : null;
            if (mapperConfig2 != null) {
                ((MapperConfigBase) mapperConfig2).a(cls);
            }
            this.f4198e = null;
        }
        this.f4199f = this.f4194a != null;
    }
}
