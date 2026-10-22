package com.bytedance.android.ec.store.utils;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes44.dex */
public final class f {
    public static final String a(String r100, Function0<String> r101) {
        Intrinsics.checkNotNullParameter(r101, "defaultValue");
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == true) goto L11;
        return r100;
    L11:
        return r101.invoke();
    L5:
        if (StringsKt.isBlank(r100) == true) goto L8;
        r102 = false;
        goto L9
    }
}
