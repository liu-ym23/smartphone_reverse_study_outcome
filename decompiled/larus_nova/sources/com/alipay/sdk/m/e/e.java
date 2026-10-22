package com.alipay.sdk.m.e;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static List<i> f25276a;

    static {
        ArrayList r100 = new ArrayList();
        f25276a = r100;
        r100.add(new l());
        f25276a.add(new d());
        f25276a.add(new c());
        f25276a.add(new h());
        f25276a.add(new k());
        f25276a.add(new b());
        f25276a.add(new a());
        f25276a.add(new g());
    }

    public static final <T> T a(Object r100, Type r101) {
        Iterator<i> r102 = f25276a.iterator();
    L4:
        if (r102.hasNext() == false) goto L10;
        i r103 = r102.next();
        if (r103.a(com.alipay.sdk.m.f.a.a(r101)) == false) goto L4;
        T r104 = (T) r103.a(r100, r101);
        if (r104 == null) goto L4;
        return r104;
    L10:
        return null;
    }

    public static final Object a(String r100, Type r101) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.length() == 0) goto L22;
        String r102 = r100.trim();
        if (r102.startsWith("[") == false) goto L14;
        if (r102.endsWith("]") == false) goto L14;
        Object r103 = new org.json.alipay.a(r102);
    L12:
        return a(r103, r101);
    L14:
        if (r102.startsWith("{") == false) goto L19;
        if (r102.endsWith(com.alipay.sdk.m.u.i.f25855d) == false) goto L19;
        r103 = new org.json.alipay.b(r102);
    L19:
        return a(r102, r101);
    L22:
        return null;
    }
}
