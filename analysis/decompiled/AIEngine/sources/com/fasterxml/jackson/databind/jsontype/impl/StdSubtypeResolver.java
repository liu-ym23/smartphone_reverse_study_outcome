package com.fasterxml.jackson.databind.jsontype.impl;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.b;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import java.io.Serializable;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import k3.a;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class StdSubtypeResolver extends a implements Serializable {
    public static void a(com.fasterxml.jackson.databind.introspect.a aVar, NamedType namedType, MapperConfig mapperConfig, AnnotationIntrospector annotationIntrospector, HashMap map) {
        String strX;
        if (!namedType.a() && (strX = annotationIntrospector.X(aVar)) != null) {
            namedType = new NamedType(namedType.f4235a, strX);
        }
        NamedType namedType2 = new NamedType(namedType.f4235a, null);
        if (map.containsKey(namedType2)) {
            if (!namedType.a() || ((NamedType) map.get(namedType2)).a()) {
                return;
            }
            map.put(namedType2, namedType);
            return;
        }
        map.put(namedType2, namedType);
        List<NamedType> listW = annotationIntrospector.W(aVar);
        if (listW != null) {
            ArrayList arrayList = (ArrayList) listW;
            if (arrayList.isEmpty()) {
                return;
            }
            int size = arrayList.size();
            int i10 = 0;
            while (i10 < size) {
                Object obj = arrayList.get(i10);
                i10++;
                NamedType namedType3 = (NamedType) obj;
                a(b.g(mapperConfig, namedType3.f4235a), namedType3, mapperConfig, annotationIntrospector, map);
            }
        }
    }

    public static void b(com.fasterxml.jackson.databind.introspect.a aVar, NamedType namedType, MapperConfig mapperConfig, HashSet hashSet, LinkedHashMap linkedHashMap) {
        List<NamedType> listW;
        String strX;
        AnnotationIntrospector annotationIntrospectorD = mapperConfig.d();
        if (!namedType.a() && (strX = annotationIntrospectorD.X(aVar)) != null) {
            namedType = new NamedType(namedType.f4235a, strX);
        }
        if (namedType.a()) {
            linkedHashMap.put(namedType.f4237c, namedType);
        }
        if (!hashSet.add(namedType.f4235a) || (listW = annotationIntrospectorD.W(aVar)) == null) {
            return;
        }
        ArrayList arrayList = (ArrayList) listW;
        if (arrayList.isEmpty()) {
            return;
        }
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            NamedType namedType2 = (NamedType) obj;
            b(b.g(mapperConfig, namedType2.f4235a), namedType2, mapperConfig, hashSet, linkedHashMap);
        }
    }

    public static ArrayList c(Class cls, HashSet hashSet, LinkedHashMap linkedHashMap) {
        ArrayList arrayList = new ArrayList(linkedHashMap.values());
        Iterator it = linkedHashMap.values().iterator();
        while (it.hasNext()) {
            hashSet.remove(((NamedType) it.next()).f4235a);
        }
        Iterator it2 = hashSet.iterator();
        while (it2.hasNext()) {
            Class cls2 = (Class) it2.next();
            if (cls2 != cls || !Modifier.isAbstract(cls2.getModifiers())) {
                arrayList.add(new NamedType(cls2, null));
            }
        }
        return arrayList;
    }

    public final ArrayList d(MapperConfig mapperConfig, AnnotatedMember annotatedMember, JavaType javaType) {
        List<NamedType> listW;
        AnnotationIntrospector annotationIntrospectorD = mapperConfig.d();
        Class<?> clsE = javaType == null ? annotatedMember.e() : javaType.f3690a;
        HashMap map = new HashMap();
        if (annotatedMember != null && (listW = annotationIntrospectorD.W(annotatedMember)) != null) {
            ArrayList arrayList = (ArrayList) listW;
            int size = arrayList.size();
            int i10 = 0;
            while (i10 < size) {
                Object obj = arrayList.get(i10);
                i10++;
                NamedType namedType = (NamedType) obj;
                a(b.g(mapperConfig, namedType.f4235a), namedType, mapperConfig, annotationIntrospectorD, map);
            }
        }
        a(b.g(mapperConfig, clsE), new NamedType(clsE, null), mapperConfig, annotationIntrospectorD, map);
        return new ArrayList(map.values());
    }

    public final ArrayList e(MapperConfig mapperConfig, AnnotatedMember annotatedMember, JavaType javaType) {
        List<NamedType> listW;
        AnnotationIntrospector annotationIntrospectorD = mapperConfig.d();
        Class<?> cls = javaType.f3690a;
        HashSet hashSet = new HashSet();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        b(b.g(mapperConfig, cls), new NamedType(cls, null), mapperConfig, hashSet, linkedHashMap);
        if (annotatedMember != null && (listW = annotationIntrospectorD.W(annotatedMember)) != null) {
            ArrayList arrayList = (ArrayList) listW;
            int size = arrayList.size();
            int i10 = 0;
            while (i10 < size) {
                Object obj = arrayList.get(i10);
                i10++;
                NamedType namedType = (NamedType) obj;
                b(b.g(mapperConfig, namedType.f4235a), namedType, mapperConfig, hashSet, linkedHashMap);
            }
        }
        return c(cls, hashSet, linkedHashMap);
    }
}
