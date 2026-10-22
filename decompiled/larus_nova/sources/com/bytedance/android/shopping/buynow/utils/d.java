package com.bytedance.android.shopping.buynow.utils;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f171207a = 0;

    static {
    }

    public static Object a(nl.c r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "fieldName");
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getQueryParam(r101);
    }
}
