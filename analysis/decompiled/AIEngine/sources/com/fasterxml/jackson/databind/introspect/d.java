package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.introspect.AnnotationCollector;
import com.fasterxml.jackson.databind.introspect.f;
import com.fasterxml.jackson.databind.introspect.i;
import com.fasterxml.jackson.databind.type.TypeFactory;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class d extends i3.f {

    /* renamed from: d, reason: collision with root package name */
    public final TypeFactory f4203d;

    /* renamed from: e, reason: collision with root package name */
    public final f.a f4204e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f4205f;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final i f4206a;

        /* renamed from: b, reason: collision with root package name */
        public final Field f4207b;

        /* renamed from: c, reason: collision with root package name */
        public AnnotationCollector f4208c;

        public a(i iVar, Field field) {
            this.f4206a = iVar;
            this.f4207b = field;
            AnnotationCollector.NoAnnotations noAnnotations = AnnotationCollector.f4133a;
            this.f4208c = AnnotationCollector.a.f4140b;
        }
    }

    public d(AnnotationIntrospector annotationIntrospector, TypeFactory typeFactory, f.a aVar, boolean z) {
        super(annotationIntrospector);
        this.f4203d = typeFactory;
        this.f4204e = annotationIntrospector == null ? null : aVar;
        this.f4205f = z;
    }

    public final Map e(i iVar, JavaType javaType) {
        f.a aVar;
        Class<?> clsA;
        a aVar2;
        JavaType javaTypeQ = javaType.q();
        if (javaTypeQ == null) {
            return null;
        }
        Class<?> cls = javaType.f3690a;
        Map mapE = e(new i.a(this.f4203d, javaTypeQ.j()), javaTypeQ);
        for (Field field : cls.getDeclaredFields()) {
            if (!field.isSynthetic() && !Modifier.isStatic(field.getModifiers())) {
                if (mapE == null) {
                    mapE = new LinkedHashMap();
                }
                a aVar3 = new a(iVar, field);
                if (this.f4205f) {
                    aVar3.f4208c = a(aVar3.f4208c, field.getDeclaredAnnotations());
                }
                mapE.put(field.getName(), aVar3);
            }
        }
        if (mapE != null && (aVar = this.f4204e) != null && (clsA = aVar.a(cls)) != null) {
            ArrayList arrayListL = com.fasterxml.jackson.databind.util.a.l(clsA, cls, true);
            int size = arrayListL.size();
            int i10 = 0;
            while (i10 < size) {
                Object obj = arrayListL.get(i10);
                i10++;
                for (Field field2 : ((Class) obj).getDeclaredFields()) {
                    if (!field2.isSynthetic() && !Modifier.isStatic(field2.getModifiers()) && (aVar2 = (a) mapE.get(field2.getName())) != null) {
                        aVar2.f4208c = a(aVar2.f4208c, field2.getDeclaredAnnotations());
                    }
                }
            }
        }
        return mapE;
    }
}
