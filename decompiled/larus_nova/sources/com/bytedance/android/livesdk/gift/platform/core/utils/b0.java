package com.bytedance.android.livesdk.gift.platform.core.utils;

import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes9.dex */
public final class b0 {
    @Deprecated(message = "请不要传入 scope", replaceWith = @ReplaceWith(expression = "getFacade()", imports = {}))
    public static final uz1.a a() {
        i12.d r100 = i12.m.f487958e2.a();
        if (r100 == null) goto L5;
        com.bytedance.android.scope.m.f163449e.getClass();
        com.bytedance.android.scope.o r101 = (com.bytedance.android.scope.o) com.bytedance.android.scope.m.b(r100).a(Reflection.getOrCreateKotlinClass(uz1.a.class));
    L7:
        return (uz1.a) r101;
    L5:
        r101 = null;
        goto L7
    }

    public static final uz1.a b() {
        i12.d r100 = i12.m.f487958e2.a();
        if (r100 == null) goto L5;
        com.bytedance.android.scope.m.f163449e.getClass();
        com.bytedance.android.scope.o r101 = (com.bytedance.android.scope.o) com.bytedance.android.scope.m.b(r100).a(Reflection.getOrCreateKotlinClass(uz1.a.class));
    L7:
        return (uz1.a) r101;
    L5:
        r101 = null;
        goto L7
    }
}
