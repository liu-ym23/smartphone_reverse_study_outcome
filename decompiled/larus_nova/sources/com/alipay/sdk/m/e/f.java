package com.alipay.sdk.m.e;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes28.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static List<j> f25277a;

    static {
        ArrayList r100 = new ArrayList();
        f25277a = r100;
        r100.add(new l());
        f25277a.add(new d());
        f25277a.add(new c());
        f25277a.add(new h());
        f25277a.add(new b());
        f25277a.add(new a());
        f25277a.add(new g());
    }

    public static String a(Object r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        Object r101 = b(r100);
        if (com.alipay.sdk.m.f.a.a(r101.getClass()) == false) goto L10;
        return org.json.alipay.b.c(r101.toString());
    L10:
        if (Collection.class.isAssignableFrom(r101.getClass()) == false) goto L14;
        return new org.json.alipay.a((List) r101).toString();
    L14:
        if (Map.class.isAssignableFrom(r101.getClass()) == false) goto L18;
        return new org.json.alipay.b((Map) r101).toString();
    L18:
        throw new IllegalArgumentException("Unsupported Class : " + r101.getClass());
    }

    public static Object b(Object r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        Iterator<j> r101 = f25277a.iterator();
    L7:
        if (r101.hasNext() == false) goto L14;
        j r102 = r101.next();
        if (r102.a(r100.getClass()) == false) goto L7;
        Object r103 = r102.a(r100);
        if (r103 == null) goto L7;
        return r103;
    L14:
        throw new IllegalArgumentException("Unsupported Class : " + r100.getClass());
    }
}
