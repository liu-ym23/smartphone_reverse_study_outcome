package com.alipay.sdk.m.e;

import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes28.dex */
public final class d implements i, j {
    public d() {
    }

    @Override // com.alipay.sdk.m.e.j
    public final Object a(Object r100) {
        return ((Enum) r100).name();
    }

    @Override // com.alipay.sdk.m.e.i
    public final Object a(Object r100, Type r101) {
        return r27.a.a((Class) r101, r100.toString());
    }

    @Override // com.alipay.sdk.m.e.i, com.alipay.sdk.m.e.j
    public final boolean a(Class<?> r100) {
        return Enum.class.isAssignableFrom(r100);
    }
}
