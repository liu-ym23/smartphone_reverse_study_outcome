package com.alipay.sdk.m.e;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes28.dex */
public final class h implements i, j {
    public h() {
    }

    public static Map<Object, Object> a(Type r100) {
    L3:
        if (r100 == Properties.class) goto L5;
        if (r100 == Hashtable.class) goto L9;
        if (r100 == IdentityHashMap.class) goto L13;
        if (r100 == SortedMap.class) goto L50;
        if (r100 == TreeMap.class) goto L50;
        if (r100 == ConcurrentMap.class) goto L48;
        if (r100 == ConcurrentHashMap.class) goto L48;
        if (r100 == Map.class) goto L46;
        if (r100 == HashMap.class) goto L46;
        if (r100 == LinkedHashMap.class) goto L32;
        if ((r100 instanceof ParameterizedType) == false) goto L36;
        r100 = ((ParameterizedType) r100).getRawType();
        goto L3
    L36:
        Class r101 = (Class) r100;
        if (r101.isInterface() == true) goto L44;
        return (Map) r101.newInstance();
    L40:
        e = move-exception;
        throw new IllegalArgumentException("unsupport type " + r100, e);
    L44:
        throw new IllegalArgumentException("unsupport type " + r100);
    L32:
        return new LinkedHashMap();
    L46:
        return new HashMap();
    L48:
        return new ConcurrentHashMap();
    L50:
        return new TreeMap();
    L13:
        return new IdentityHashMap();
    L9:
        return new Hashtable();
    L5:
        return new Properties();
    }

    @Override // com.alipay.sdk.m.e.j
    public final Object a(Object r100) {
        TreeMap r101 = new TreeMap();
        Iterator r102 = ((Map) r100).entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L10;
        Map.Entry r103 = (Map.Entry) r102.next();
        if ((r103.getKey() instanceof String) == false) goto L9;
        r101.put((String) r103.getKey(), f.b(r103.getValue()));
        goto L4
    L9:
        throw new IllegalArgumentException("Map key must be String!");
    L10:
        return r101;
    }

    @Override // com.alipay.sdk.m.e.i
    public final Object a(Object r100, Type r101) {
        if (r100.getClass().equals(org.json.alipay.b.class) == true) goto L6;
        return null;
    L6:
        org.json.alipay.b r102 = (org.json.alipay.b) r100;
        Map<Object, Object> r103 = a(r101);
        if ((r101 instanceof ParameterizedType) == false) goto L22;
        ParameterizedType r104 = (ParameterizedType) r101;
        Type r105 = r104.getActualTypeArguments()[0];
        Type r106 = r104.getActualTypeArguments()[1];
        if (String.class != r105) goto L20;
        Iterator r107 = r102.a();
    L12:
        if (r107.hasNext() == false) goto L18;
        String r108 = (String) r107.next();
        if (com.alipay.sdk.m.f.a.a((Class) r106) == false) goto L16;
        Object r109 = r102.a(r108);
    L17:
        r103.put(r108, r109);
        goto L12
    L16:
        r109 = e.a(r102.a(r108), r106);
        goto L17
    L18:
        return r103;
    L20:
        throw new IllegalArgumentException("Deserialize Map Key must be String.class");
    L22:
        throw new IllegalArgumentException("Deserialize Map must be Generics!");
    }

    @Override // com.alipay.sdk.m.e.i, com.alipay.sdk.m.e.j
    public final boolean a(Class<?> r100) {
        return Map.class.isAssignableFrom(r100);
    }
}
