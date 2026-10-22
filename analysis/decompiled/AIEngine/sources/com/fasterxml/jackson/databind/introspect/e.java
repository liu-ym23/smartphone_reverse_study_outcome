package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.introspect.AnnotationCollector;
import com.fasterxml.jackson.databind.introspect.f;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class e extends i3.f {

    /* renamed from: d, reason: collision with root package name */
    public final f.a f4209d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f4210e;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public i f4211a;

        /* renamed from: b, reason: collision with root package name */
        public Method f4212b;

        /* renamed from: c, reason: collision with root package name */
        public AnnotationCollector f4213c;

        public a(i iVar, Method method, AnnotationCollector annotationCollector) {
            this.f4211a = iVar;
            this.f4212b = method;
            this.f4213c = annotationCollector;
        }
    }

    public e(AnnotationIntrospector annotationIntrospector, f.a aVar, boolean z) {
        super(annotationIntrospector);
        this.f4209d = annotationIntrospector == null ? null : aVar;
        this.f4210e = z;
    }

    public static boolean g(Method method) {
        return (Modifier.isStatic(method.getModifiers()) || method.isSynthetic() || method.isBridge() || method.getParameterTypes().length > 2) ? false : true;
    }

    public final void e(i iVar, Class cls, LinkedHashMap linkedHashMap, Class cls2) {
        AnnotationCollector annotationCollectorB;
        if (cls2 != null) {
            f(iVar, cls, linkedHashMap, cls2);
        }
        if (cls == null) {
            return;
        }
        for (Method method : com.fasterxml.jackson.databind.util.a.n(cls)) {
            if (g(method)) {
                i3.g gVar = new i3.g(method);
                a aVar = (a) linkedHashMap.get(gVar);
                if (aVar == null) {
                    if (this.f9506a == null) {
                        AnnotationCollector.NoAnnotations noAnnotations = AnnotationCollector.f4133a;
                        annotationCollectorB = AnnotationCollector.a.f4140b;
                    } else {
                        annotationCollectorB = b(method.getDeclaredAnnotations());
                    }
                    linkedHashMap.put(gVar, new a(iVar, method, annotationCollectorB));
                } else {
                    if (this.f4210e) {
                        aVar.f4213c = c(aVar.f4213c, method.getDeclaredAnnotations());
                    }
                    Method method2 = aVar.f4212b;
                    if (method2 == null) {
                        aVar.f4212b = method;
                    } else if (Modifier.isAbstract(method2.getModifiers()) && !Modifier.isAbstract(method.getModifiers())) {
                        aVar.f4212b = method;
                        aVar.f4211a = iVar;
                    }
                }
            }
        }
    }

    public final void f(i iVar, Class cls, LinkedHashMap linkedHashMap, Class cls2) {
        List list;
        if (this.f9506a == null) {
            return;
        }
        Annotation[] annotationArr = com.fasterxml.jackson.databind.util.a.f4529a;
        if (cls2 == null || cls2 == cls || cls2 == Object.class) {
            list = Collections.EMPTY_LIST;
        } else {
            ArrayList arrayList = new ArrayList(8);
            com.fasterxml.jackson.databind.util.a.a(cls2, cls, arrayList);
            list = arrayList;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            for (Method method : ((Class) it.next()).getDeclaredMethods()) {
                if (g(method)) {
                    i3.g gVar = new i3.g(method);
                    a aVar = (a) linkedHashMap.get(gVar);
                    Annotation[] declaredAnnotations = method.getDeclaredAnnotations();
                    if (aVar == null) {
                        linkedHashMap.put(gVar, new a(iVar, null, b(declaredAnnotations)));
                    } else {
                        aVar.f4213c = c(aVar.f4213c, declaredAnnotations);
                    }
                }
            }
        }
    }
}
