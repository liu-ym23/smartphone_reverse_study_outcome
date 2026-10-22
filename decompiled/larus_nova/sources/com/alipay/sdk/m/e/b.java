package com.alipay.sdk.m.e;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes28.dex */
public final class b implements i, j {
    public b() {
    }

    public static Collection<Object> a(Class<?> r100, Type r101) {
        if (r100 != AbstractCollection.class) goto L6;
        return new ArrayList();
    L6:
        if (r100.isAssignableFrom(HashSet.class) == false) goto L9;
        return new HashSet();
    L9:
        if (r100.isAssignableFrom(LinkedHashSet.class) == false) goto L12;
        return new LinkedHashSet();
    L12:
        if (r100.isAssignableFrom(TreeSet.class) == false) goto L15;
        return new TreeSet();
    L15:
        if (r100.isAssignableFrom(ArrayList.class) == false) goto L18;
        return new ArrayList();
    L18:
        if (r100.isAssignableFrom(EnumSet.class) == true) goto L20;
        return (Collection) r100.newInstance();
    L28:
        throw new IllegalArgumentException("create instane error, class ".concat(r100.getName()));
    L20:
        if ((r101 instanceof ParameterizedType) == false) goto L22;
        Type r102 = ((ParameterizedType) r101).getActualTypeArguments()[0];
    L36:
        return EnumSet.noneOf((Class) r102);
    L22:
        r102 = Object.class;
        goto L36
    }

    @Override // com.alipay.sdk.m.e.j
    public final Object a(Object r100) {
        ArrayList r101 = new ArrayList();
        Iterator r102 = ((Iterable) r100).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r101.add(f.b(r102.next()));
        goto L4
    L6:
        return r101;
    }

    @Override // com.alipay.sdk.m.e.i
    public final Object a(Object r100, Type r101) {
        if (r100.getClass().equals(org.json.alipay.a.class) == true) goto L6;
        return null;
    L6:
        org.json.alipay.a r102 = (org.json.alipay.a) r100;
        Collection<Object> r103 = a(com.alipay.sdk.m.f.a.a(r101), r101);
        if ((r101 instanceof ParameterizedType) == false) goto L14;
        int r104 = 0;
        Type r105 = ((ParameterizedType) r101).getActualTypeArguments()[0];
    L10:
        if (r104 >= r102.a()) goto L12;
        r103.add(e.a(r102.a(r104), r105));
        r104 = r104 + 1;
        goto L10
    L12:
        return r103;
    L14:
        throw new IllegalArgumentException("Does not support the implement for generics.");
    }

    @Override // com.alipay.sdk.m.e.i, com.alipay.sdk.m.e.j
    public final boolean a(Class<?> r100) {
        return Collection.class.isAssignableFrom(r100);
    }
}
