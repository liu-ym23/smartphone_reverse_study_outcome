package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import i3.i;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final MapperConfig<?> f4214a;

    /* renamed from: b, reason: collision with root package name */
    public final DefaultAccessorNamingStrategy f4215b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f4216c;

    /* renamed from: d, reason: collision with root package name */
    public final JavaType f4217d;

    /* renamed from: e, reason: collision with root package name */
    public final a f4218e;

    /* renamed from: f, reason: collision with root package name */
    public final VisibilityChecker<?> f4219f;

    /* renamed from: g, reason: collision with root package name */
    public final AnnotationIntrospector f4220g;
    public final boolean h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f4221i;

    /* renamed from: j, reason: collision with root package name */
    public LinkedHashMap<String, i3.i> f4222j;

    /* renamed from: k, reason: collision with root package name */
    public LinkedList<i3.i> f4223k;

    /* renamed from: l, reason: collision with root package name */
    public LinkedList<AnnotatedMember> f4224l;

    /* renamed from: m, reason: collision with root package name */
    public LinkedList<AnnotatedMember> f4225m;

    /* renamed from: n, reason: collision with root package name */
    public LinkedList<AnnotatedMethod> f4226n;

    /* renamed from: o, reason: collision with root package name */
    public LinkedList<AnnotatedMember> f4227o;

    /* renamed from: p, reason: collision with root package name */
    public LinkedList<AnnotatedMember> f4228p;

    /* renamed from: q, reason: collision with root package name */
    public LinkedList<AnnotatedMember> f4229q;
    public HashSet<String> r;

    /* renamed from: s, reason: collision with root package name */
    public LinkedHashMap<Object, AnnotatedMember> f4230s;

    public h(MapperConfig mapperConfig, boolean z, JavaType javaType, a aVar, DefaultAccessorNamingStrategy defaultAccessorNamingStrategy) {
        this.f4214a = mapperConfig;
        this.f4216c = z;
        this.f4217d = javaType;
        this.f4218e = aVar;
        mapperConfig.getClass();
        if (mapperConfig.k(MapperFeature.USE_ANNOTATIONS)) {
            this.h = true;
            this.f4220g = mapperConfig.d();
        } else {
            this.h = false;
            this.f4220g = NopAnnotationIntrospector.f4165a;
        }
        this.f4219f = mapperConfig.g(javaType.f3690a, aVar);
        this.f4215b = defaultAccessorNamingStrategy;
        mapperConfig.k(MapperFeature.USE_STD_BEAN_NAMING);
    }

    public static boolean f(i3.i iVar, LinkedList linkedList) {
        if (linkedList != null) {
            String str = iVar.h.f3755a;
            int size = linkedList.size();
            for (int i10 = 0; i10 < size; i10++) {
                if (((i3.i) linkedList.get(i10)).h.f3755a.equals(str)) {
                    linkedList.set(i10, iVar);
                    return true;
                }
            }
        }
        return false;
    }

    public final void a(LinkedHashMap linkedHashMap, AnnotatedParameter annotatedParameter) {
        i3.i iVarE;
        JsonCreator.Mode modeE;
        AnnotationIntrospector annotationIntrospector = this.f4220g;
        String strO = annotationIntrospector.o(annotatedParameter);
        if (strO == null) {
            strO = "";
        }
        PropertyName propertyNameU = annotationIntrospector.u(annotatedParameter);
        boolean z = (propertyNameU == null || propertyNameU.c()) ? false : true;
        if (!z) {
            if (strO.isEmpty() || (modeE = annotationIntrospector.e(this.f4214a, annotatedParameter.f4129c)) == null || modeE == JsonCreator.Mode.f3432d) {
                return;
            } else {
                propertyNameU = PropertyName.a(strO);
            }
        }
        PropertyName propertyName = propertyNameU;
        String strB = b(strO);
        if (z && strB.isEmpty()) {
            String str = propertyName.f3755a;
            iVarE = (i3.i) linkedHashMap.get(str);
            if (iVarE == null) {
                i3.i iVar = new i3.i(this.f4214a, this.f4220g, this.f4216c, propertyName, propertyName);
                linkedHashMap.put(str, iVar);
                iVarE = iVar;
            }
        } else {
            iVarE = e(strB, linkedHashMap);
        }
        i3.i iVar2 = iVarE;
        iVar2.f9522k = new i.e<>(annotatedParameter, iVar2.f9522k, propertyName, z, true, false);
        this.f4223k.add(iVar2);
    }

    public final void c(String str) {
        if (this.f4216c || str == null) {
            return;
        }
        if (this.r == null) {
            this.r = new HashSet<>();
        }
        this.r.add(str);
    }

    public final void d(JacksonInject.Value value, AnnotatedMember annotatedMember) {
        if (value == null) {
            return;
        }
        Object obj = value.f3422a;
        if (this.f4230s == null) {
            this.f4230s = new LinkedHashMap<>();
        }
        AnnotatedMember annotatedMemberPut = this.f4230s.put(obj, annotatedMember);
        if (annotatedMemberPut == null || annotatedMemberPut.getClass() != annotatedMember.getClass()) {
            return;
        }
        throw new IllegalArgumentException("Duplicate injectable value with id '" + obj + "' (of type " + obj.getClass().getName() + ")");
    }

    public final i3.i e(String str, LinkedHashMap linkedHashMap) {
        i3.i iVar = (i3.i) linkedHashMap.get(str);
        if (iVar != null) {
            return iVar;
        }
        boolean z = this.f4216c;
        PropertyName propertyNameA = PropertyName.a(str);
        i3.i iVar2 = new i3.i(this.f4214a, this.f4220g, z, propertyNameA, propertyNameA);
        linkedHashMap.put(str, iVar2);
        return iVar2;
    }

    /* JADX WARN: Removed duplicated region for block: B:173:0x030f  */
    /* JADX WARN: Removed duplicated region for block: B:436:0x077b  */
    /* JADX WARN: Removed duplicated region for block: B:461:0x0802  */
    /* JADX WARN: Removed duplicated region for block: B:480:0x0850  */
    /* JADX WARN: Removed duplicated region for block: B:486:0x0874  */
    /* JADX WARN: Removed duplicated region for block: B:487:0x087b  */
    /* JADX WARN: Removed duplicated region for block: B:491:0x088d  */
    /* JADX WARN: Removed duplicated region for block: B:502:0x08ae  */
    /* JADX WARN: Removed duplicated region for block: B:504:0x08b4  */
    /* JADX WARN: Removed duplicated region for block: B:505:0x08ba  */
    /* JADX WARN: Removed duplicated region for block: B:509:0x08cf A[LOOP:18: B:507:0x08c9->B:509:0x08cf, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:512:0x08e5  */
    /* JADX WARN: Removed duplicated region for block: B:526:0x0920  */
    /* JADX WARN: Removed duplicated region for block: B:542:0x097a  */
    /* JADX WARN: Removed duplicated region for block: B:547:0x099e  */
    /* JADX WARN: Removed duplicated region for block: B:551:0x09aa  */
    /* JADX WARN: Removed duplicated region for block: B:705:0x089d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g() {
        /*
            Method dump skipped, instructions count: 2538
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.introspect.h.g():void");
    }

    public final void h(String str, Object... objArr) {
        if (objArr.length > 0) {
            str = String.format(str, objArr);
        }
        throw new IllegalArgumentException("Problem with definition of " + this.f4218e + ": " + str);
    }

    public final String b(String str) {
        return str;
    }
}
