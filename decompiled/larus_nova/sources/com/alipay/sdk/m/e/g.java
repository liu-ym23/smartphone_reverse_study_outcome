package com.alipay.sdk.m.e;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes28.dex */
public final class g implements i, j {
    public g() {
    }

    @Override // com.alipay.sdk.m.e.j
    public final Object a(Object r100) {
        TreeMap r101 = new TreeMap();
        Class<?> r102 = r100.getClass();
    L3:
        Field[] r103 = r102.getDeclaredFields();
        if (r102.equals(Object.class) == true) goto L24;
        if (r103 == null) goto L23;
        if (r103.length <= 0) goto L23;
        int r104 = r103.length;
        int r105 = 0;
    L9:
        if (r105 >= r104) goto L23;
        Field r106 = r103[r105];
        if (r106 != null) goto L13;
    L19:
        Object r107 = null;
    L20:
        if (r107 == null) goto L22;
        r101.put(r106.getName(), r107);
    L22:
        r105 = r105 + 1;
        goto L9
    L13:
        if ("this$0".equals(r106.getName()) == true) goto L19;
        boolean r108 = r106.isAccessible();
        r106.setAccessible(true);
        Object r109 = r106.get(r100);
        if (r109 == null) goto L19;
        r106.setAccessible(r108);
        r107 = f.b(r109);
    L23:
        r102 = r102.getSuperclass();
        goto L3
    L24:
        return r101;
    }

    @Override // com.alipay.sdk.m.e.i
    public final Object a(Object r100, Type r110) {
        if (r100.getClass().equals(org.json.alipay.b.class) == true) goto L6;
        return null;
    L6:
        org.json.alipay.b r101 = (org.json.alipay.b) r100;
        Class r111 = (Class) r110;
        Object r102 = r111.newInstance();
    L8:
        if (r111.equals(Object.class) == true) goto L20;
        Field[] r103 = r111.getDeclaredFields();
        if (r103 == null) goto L19;
        if (r103.length <= 0) goto L19;
        int r104 = r103.length;
        int r105 = 0;
    L14:
        if (r105 >= r104) goto L19;
        Field r106 = r103[r105];
        String r107 = r106.getName();
        Type r108 = r106.getGenericType();
        if (r101.b(r107) == false) goto L18;
        r106.setAccessible(true);
        r106.set(r102, e.a(r101.a(r107), r108));
    L18:
        r105 = r105 + 1;
    L19:
        r111 = r111.getSuperclass();
        goto L8
    L20:
        return r102;
    }

    @Override // com.alipay.sdk.m.e.i, com.alipay.sdk.m.e.j
    public final boolean a(Class<?> r100) {
        return true;
    }
}
