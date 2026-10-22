package com.alipay.sdk.m.e;

import java.lang.reflect.Type;
import java.util.Date;

/* JADX INFO: loaded from: classes28.dex */
public final class c implements i, j {
    public c() {
    }

    @Override // com.alipay.sdk.m.e.j
    public final Object a(Object r100) {
        return Long.valueOf(((Date) r100).getTime());
    }

    @Override // com.alipay.sdk.m.e.i
    public final Object a(Object r100, Type r101) {
        return new Date(((Long) r100).longValue());
    }

    @Override // com.alipay.sdk.m.e.i, com.alipay.sdk.m.e.j
    public final boolean a(Class<?> r100) {
        return Date.class.isAssignableFrom(r100);
    }
}
