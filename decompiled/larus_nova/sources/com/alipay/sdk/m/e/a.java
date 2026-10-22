package com.alipay.sdk.m.e;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes28.dex */
public final class a implements i, j {
    public a() {
    }

    @Override // com.alipay.sdk.m.e.j
    public final Object a(Object r100) {
        Object[] r101 = (Object[]) r100;
        ArrayList r102 = new ArrayList();
        int r103 = r101.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L5;
        r102.add(f.b(r101[r104]));
        r104 = r104 + 1;
        goto L3
    L5:
        return r102;
    }

    @Override // com.alipay.sdk.m.e.i
    public final Object a(Object r100, Type r101) {
        if (r100.getClass().equals(org.json.alipay.a.class) == true) goto L6;
        return null;
    L6:
        org.json.alipay.a r102 = (org.json.alipay.a) r100;
        if ((r101 instanceof GenericArrayType) == true) goto L13;
        Class<?> r103 = ((Class) r101).getComponentType();
        int r104 = r102.a();
        Object r105 = Array.newInstance(r103, r104);
        int r106 = 0;
    L9:
        if (r106 >= r104) goto L11;
        Array.set(r105, r106, e.a(r102.a(r106), r103));
        r106 = r106 + 1;
        goto L9
    L11:
        return r105;
    L13:
        throw new IllegalArgumentException("Does not support generic array!");
    }

    @Override // com.alipay.sdk.m.e.i, com.alipay.sdk.m.e.j
    public final boolean a(Class<?> r100) {
        return r100.isArray();
    }
}
