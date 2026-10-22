package com.bytedance.android.ec.sdk.helper;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class l {
    public static final void a(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "job");
        if (ECAppInfoService.f48114e.isLocalTest() == false) goto L6;
        r100.invoke();
        return;
    }
}
