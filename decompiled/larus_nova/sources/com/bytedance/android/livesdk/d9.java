package com.bytedance.android.livesdk;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: classes7.dex */
public final class d9 {
    public static final String a(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L8:
        if (r101 == true) goto L10;
        return r100;
    L10:
        return null;
    L4:
        if (r100.length() == 0) goto L7;
        r101 = false;
        goto L8
    }

    public static final String c(Long r100, String r101) {
        com.bytedance.android.live.base.model.user.o0.f58946a.getClass();
        return com.bytedance.android.live.base.model.user.o0.a.g(r100, r101);
    }

    public static final void b(String r100, MutablePropertyReference0Impl r101, MutablePropertyReference0Impl r102) {
        Intrinsics.checkNotNullParameter(r100, "value");
        Intrinsics.checkNotNullParameter(r101, "uid");
        Intrinsics.checkNotNullParameter(r102, "uidString");
        r101.set(Long.valueOf(com.bytedance.android.livesdk.utils.d5.c(r100)));
        r102.set(r100);
    }
}
