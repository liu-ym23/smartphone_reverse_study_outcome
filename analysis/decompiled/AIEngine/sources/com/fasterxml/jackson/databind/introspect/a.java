package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.introspect.d;
import com.fasterxml.jackson.databind.introspect.e;
import com.fasterxml.jackson.databind.introspect.f;
import com.fasterxml.jackson.databind.introspect.i;
import com.fasterxml.jackson.databind.type.TypeBindings;
import com.fasterxml.jackson.databind.type.TypeFactory;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a extends i3.a implements i {
    public static final C0032a r;

    /* renamed from: a, reason: collision with root package name */
    public final JavaType f4174a;

    /* renamed from: b, reason: collision with root package name */
    public final Class<?> f4175b;

    /* renamed from: c, reason: collision with root package name */
    public final TypeBindings f4176c;

    /* renamed from: d, reason: collision with root package name */
    public final List<JavaType> f4177d;

    /* renamed from: e, reason: collision with root package name */
    public final AnnotationIntrospector f4178e;
    public final TypeFactory h;

    /* renamed from: j, reason: collision with root package name */
    public final f.a f4179j;

    /* renamed from: k, reason: collision with root package name */
    public final Class<?> f4180k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f4181l;

    /* renamed from: m, reason: collision with root package name */
    public final q3.a f4182m;

    /* renamed from: n, reason: collision with root package name */
    public C0032a f4183n;

    /* renamed from: o, reason: collision with root package name */
    public i3.b f4184o;

    /* renamed from: p, reason: collision with root package name */
    public List<AnnotatedField> f4185p;

    /* renamed from: q, reason: collision with root package name */
    public transient Boolean f4186q;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: com.fasterxml.jackson.databind.introspect.a$a, reason: collision with other inner class name */
    public static final class C0032a {

        /* renamed from: a, reason: collision with root package name */
        public final AnnotatedConstructor f4187a;

        /* renamed from: b, reason: collision with root package name */
        public final List<AnnotatedConstructor> f4188b;

        /* renamed from: c, reason: collision with root package name */
        public final List<AnnotatedMethod> f4189c;

        public C0032a(AnnotatedConstructor annotatedConstructor, List<AnnotatedConstructor> list, List<AnnotatedMethod> list2) {
            this.f4187a = annotatedConstructor;
            this.f4188b = list;
            this.f4189c = list2;
        }
    }

    static {
        List list = Collections.EMPTY_LIST;
        r = new C0032a(null, list, list);
    }

    public a(JavaType javaType, Class<?> cls, List<JavaType> list, Class<?> cls2, q3.a aVar, TypeBindings typeBindings, AnnotationIntrospector annotationIntrospector, f.a aVar2, TypeFactory typeFactory, boolean z) {
        this.f4174a = javaType;
        this.f4175b = cls;
        this.f4177d = list;
        this.f4180k = cls2;
        this.f4182m = aVar;
        this.f4176c = typeBindings;
        this.f4178e = annotationIntrospector;
        this.f4179j = aVar2;
        this.h = typeFactory;
        this.f4181l = z;
    }

    @Override // com.fasterxml.jackson.databind.introspect.i
    public final JavaType a(Type type) {
        return this.h.b(null, type, this.f4176c);
    }

    @Override // i3.a
    public final <A extends Annotation> A c(Class<A> cls) {
        return (A) this.f4182m.a(cls);
    }

    @Override // i3.a
    public final String d() {
        return this.f4175b.getName();
    }

    @Override // i3.a
    public final Class<?> e() {
        return this.f4175b;
    }

    @Override // i3.a
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return com.fasterxml.jackson.databind.util.a.s(a.class, obj) && ((a) obj).f4175b == this.f4175b;
    }

    @Override // i3.a
    public final JavaType f() {
        return this.f4174a;
    }

    /* JADX WARN: Removed duplicated region for block: B:123:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x031a  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x031d  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0342  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0175  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.fasterxml.jackson.databind.introspect.a.C0032a g() throws java.lang.SecurityException {
        /*
            Method dump skipped, instructions count: 909
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.introspect.a.g():com.fasterxml.jackson.databind.introspect.a$a");
    }

    public final i3.b h() throws NoSuchMethodException, SecurityException {
        f.a aVar;
        Class<?> clsA;
        i3.b bVar = this.f4184o;
        if (bVar == null) {
            JavaType javaType = this.f4174a;
            if (javaType == null) {
                bVar = new i3.b();
            } else {
                Class<?> cls = javaType.f3690a;
                e eVar = new e(this.f4178e, this.f4179j, this.f4181l);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                eVar.e(this, cls, linkedHashMap, this.f4180k);
                Iterator<JavaType> it = this.f4177d.iterator();
                while (true) {
                    boolean zHasNext = it.hasNext();
                    aVar = eVar.f4209d;
                    Class<?> clsA2 = null;
                    if (!zHasNext) {
                        break;
                    }
                    JavaType next = it.next();
                    if (aVar != null) {
                        clsA2 = aVar.a(next.f3690a);
                    }
                    eVar.e(new i.a(this.h, next.j()), next.f3690a, linkedHashMap, clsA2);
                }
                if (aVar != null && (clsA = aVar.a(Object.class)) != null) {
                    eVar.f(this, cls, linkedHashMap, clsA);
                    if (eVar.f9506a != null && !linkedHashMap.isEmpty()) {
                        for (Map.Entry entry : linkedHashMap.entrySet()) {
                            i3.g gVar = (i3.g) entry.getKey();
                            if ("hashCode".equals(gVar.f9508a) && gVar.f9509b.length == 0) {
                                try {
                                    Method declaredMethod = Object.class.getDeclaredMethod(gVar.f9508a, null);
                                    if (declaredMethod != null) {
                                        e.a aVar2 = (e.a) entry.getValue();
                                        aVar2.f4213c = eVar.c(aVar2.f4213c, declaredMethod.getDeclaredAnnotations());
                                        aVar2.f4212b = declaredMethod;
                                    }
                                } catch (Exception unused) {
                                }
                            }
                        }
                    }
                }
                if (linkedHashMap.isEmpty()) {
                    bVar = new i3.b();
                } else {
                    LinkedHashMap linkedHashMap2 = new LinkedHashMap(linkedHashMap.size());
                    for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                        e.a aVar3 = (e.a) entry2.getValue();
                        Method method = aVar3.f4212b;
                        AnnotatedMethod annotatedMethod = method == null ? null : new AnnotatedMethod(aVar3.f4211a, method, aVar3.f4213c.b(), null);
                        if (annotatedMethod != null) {
                            linkedHashMap2.put(entry2.getKey(), annotatedMethod);
                        }
                    }
                    i3.b bVar2 = new i3.b();
                    bVar2.f9492a = linkedHashMap2;
                    bVar = bVar2;
                }
            }
            this.f4184o = bVar;
        }
        return bVar;
    }

    @Override // i3.a
    public final int hashCode() {
        return this.f4175b.getName().hashCode();
    }

    public final List i() {
        Map mapE;
        List<AnnotatedField> list = this.f4185p;
        if (list == null) {
            JavaType javaType = this.f4174a;
            if (javaType == null || (mapE = new d(this.f4178e, this.h, this.f4179j, this.f4181l).e(this, javaType)) == null) {
                list = Collections.EMPTY_LIST;
            } else {
                ArrayList arrayList = new ArrayList(mapE.size());
                for (d.a aVar : mapE.values()) {
                    arrayList.add(new AnnotatedField(aVar.f4206a, aVar.f4207b, aVar.f4208c.b()));
                }
                list = arrayList;
            }
            this.f4185p = list;
        }
        return list;
    }

    @Override // i3.a
    public final String toString() {
        return "[AnnotedClass " + this.f4175b.getName() + "]";
    }

    public a(Class<?> cls) {
        this.f4174a = null;
        this.f4175b = cls;
        this.f4177d = Collections.EMPTY_LIST;
        this.f4180k = null;
        this.f4182m = AnnotationCollector.f4133a;
        this.f4176c = TypeBindings.f4452j;
        this.f4178e = null;
        this.f4179j = null;
        this.h = null;
        this.f4181l = false;
    }
}
