package com.bytedance.android.sdk.bdticketguard.utils;

import kotlin.Result;

/* JADX INFO: loaded from: classes3.dex */
public final class d {
    public static final <T> c<T> a(Object r100) {
        Throwable r101 = Result.m9452exceptionOrNullimpl(r100);
        if (r101 != null) goto L5;
        int r102 = c.f164084a;
        return new c.C2503c(r100);
    L5:
        int r103 = c.f164084a;
        return new c.b(r101);
    }
}
