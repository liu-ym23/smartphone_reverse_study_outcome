package com.alipay.sdk.m.e;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes28.dex */
public final class k implements i {
    public k() {
    }

    @Override // com.alipay.sdk.m.e.i
    public final Object a(Object r100, Type r101) {
        if (r100.getClass().equals(org.json.alipay.a.class) == true) goto L6;
        return null;
    L6:
        org.json.alipay.a r102 = (org.json.alipay.a) r100;
        HashSet r103 = new HashSet();
        int r104 = 0;
        if ((r101 instanceof ParameterizedType) == false) goto L9;
        Type r105 = ((ParameterizedType) r101).getActualTypeArguments()[0];
    L11:
        if (r104 >= r102.a()) goto L13;
        r103.add(e.a(r102.a(r104), r105));
        r104 = r104 + 1;
        goto L11
    L13:
        return r103;
    L9:
        r105 = Object.class;
        goto L11
    }

    @Override // com.alipay.sdk.m.e.i, com.alipay.sdk.m.e.j
    public final boolean a(Class<?> r100) {
        return Set.class.isAssignableFrom(r100);
    }
}
