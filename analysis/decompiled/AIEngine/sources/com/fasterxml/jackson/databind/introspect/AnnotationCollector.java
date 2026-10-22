package com.fasterxml.jackson.databind.introspect;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class AnnotationCollector {

    /* renamed from: a, reason: collision with root package name */
    public static final NoAnnotations f4133a = new NoAnnotations();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class NoAnnotations implements q3.a, Serializable {
        @Override // q3.a
        public final <A extends Annotation> A a(Class<A> cls) {
            return null;
        }

        @Override // q3.a
        public final int size() {
            return 0;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class OneAnnotation implements q3.a, Serializable {

        /* renamed from: a, reason: collision with root package name */
        public final Class<?> f4134a;

        /* renamed from: b, reason: collision with root package name */
        public final Annotation f4135b;

        public OneAnnotation(Class<?> cls, Annotation annotation) {
            this.f4134a = cls;
            this.f4135b = annotation;
        }

        @Override // q3.a
        public final <A extends Annotation> A a(Class<A> cls) {
            if (this.f4134a == cls) {
                return (A) this.f4135b;
            }
            return null;
        }

        @Override // q3.a
        public final int size() {
            return 1;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class TwoAnnotations implements q3.a, Serializable {

        /* renamed from: a, reason: collision with root package name */
        public final Class<?> f4136a;

        /* renamed from: b, reason: collision with root package name */
        public final Class<?> f4137b;

        /* renamed from: c, reason: collision with root package name */
        public final Annotation f4138c;

        /* renamed from: d, reason: collision with root package name */
        public final Annotation f4139d;

        public TwoAnnotations(Class<?> cls, Annotation annotation, Class<?> cls2, Annotation annotation2) {
            this.f4136a = cls;
            this.f4138c = annotation;
            this.f4137b = cls2;
            this.f4139d = annotation2;
        }

        @Override // q3.a
        public final <A extends Annotation> A a(Class<A> cls) {
            if (this.f4136a == cls) {
                return (A) this.f4138c;
            }
            if (this.f4137b == cls) {
                return (A) this.f4139d;
            }
            return null;
        }

        @Override // q3.a
        public final int size() {
            return 2;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a extends AnnotationCollector {

        /* renamed from: b, reason: collision with root package name */
        public static final a f4140b = new a();

        @Override // com.fasterxml.jackson.databind.introspect.AnnotationCollector
        public final AnnotationCollector a(Annotation annotation) {
            Class<? extends Annotation> clsAnnotationType = annotation.annotationType();
            c cVar = new c();
            cVar.f4142b = clsAnnotationType;
            cVar.f4143c = annotation;
            return cVar;
        }

        @Override // com.fasterxml.jackson.databind.introspect.AnnotationCollector
        public final i3.c b() {
            return new i3.c(0);
        }

        @Override // com.fasterxml.jackson.databind.introspect.AnnotationCollector
        public final q3.a c() {
            return AnnotationCollector.f4133a;
        }

        @Override // com.fasterxml.jackson.databind.introspect.AnnotationCollector
        public final boolean d(Annotation annotation) {
            return false;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class b extends AnnotationCollector {

        /* renamed from: b, reason: collision with root package name */
        public final HashMap<Class<?>, Annotation> f4141b;

        public b(Class cls, Annotation annotation, Class cls2, Annotation annotation2) {
            HashMap<Class<?>, Annotation> map = new HashMap<>();
            this.f4141b = map;
            map.put(cls, annotation);
            map.put(cls2, annotation2);
        }

        @Override // com.fasterxml.jackson.databind.introspect.AnnotationCollector
        public final AnnotationCollector a(Annotation annotation) {
            this.f4141b.put(annotation.annotationType(), annotation);
            return this;
        }

        @Override // com.fasterxml.jackson.databind.introspect.AnnotationCollector
        public final i3.c b() {
            i3.c cVar = new i3.c(0);
            for (Annotation annotation : this.f4141b.values()) {
                if (cVar.f9494b == null) {
                    cVar.f9494b = new HashMap();
                }
                Annotation annotation2 = (Annotation) cVar.f9494b.put(annotation.annotationType(), annotation);
                if (annotation2 != null) {
                    annotation2.equals(annotation);
                }
            }
            return cVar;
        }

        @Override // com.fasterxml.jackson.databind.introspect.AnnotationCollector
        public final q3.a c() {
            HashMap<Class<?>, Annotation> map = this.f4141b;
            if (map.size() != 2) {
                return new i3.c(map);
            }
            Iterator<Map.Entry<Class<?>, Annotation>> it = map.entrySet().iterator();
            Map.Entry<Class<?>, Annotation> next = it.next();
            Map.Entry<Class<?>, Annotation> next2 = it.next();
            return new TwoAnnotations(next.getKey(), next.getValue(), next2.getKey(), next2.getValue());
        }

        @Override // com.fasterxml.jackson.databind.introspect.AnnotationCollector
        public final boolean d(Annotation annotation) {
            return this.f4141b.containsKey(annotation.annotationType());
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class c extends AnnotationCollector {

        /* renamed from: b, reason: collision with root package name */
        public Class<?> f4142b;

        /* renamed from: c, reason: collision with root package name */
        public Annotation f4143c;

        @Override // com.fasterxml.jackson.databind.introspect.AnnotationCollector
        public final AnnotationCollector a(Annotation annotation) {
            Class<? extends Annotation> clsAnnotationType = annotation.annotationType();
            Class<?> cls = this.f4142b;
            if (cls != clsAnnotationType) {
                return new b(cls, this.f4143c, clsAnnotationType, annotation);
            }
            this.f4143c = annotation;
            return this;
        }

        @Override // com.fasterxml.jackson.databind.introspect.AnnotationCollector
        public final i3.c b() {
            Class<?> cls = this.f4142b;
            Annotation annotation = this.f4143c;
            HashMap map = new HashMap(4);
            map.put(cls, annotation);
            return new i3.c(map);
        }

        @Override // com.fasterxml.jackson.databind.introspect.AnnotationCollector
        public final q3.a c() {
            return new OneAnnotation(this.f4142b, this.f4143c);
        }

        @Override // com.fasterxml.jackson.databind.introspect.AnnotationCollector
        public final boolean d(Annotation annotation) {
            return annotation.annotationType() == this.f4142b;
        }
    }

    public abstract AnnotationCollector a(Annotation annotation);

    public abstract i3.c b();

    public abstract q3.a c();

    public abstract boolean d(Annotation annotation);
}
