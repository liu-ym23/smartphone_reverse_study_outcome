package com.bytedance.android.livesdk.utils;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class o1 {
    public static final String a(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$errorMsg");
        String r101 = r100.getMessage();
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L12;
        return r100.toString();
    L12:
        return r100.getMessage();
    L5:
        if (r101.length() == 0) goto L8;
        r102 = false;
        goto L9
    }
}
