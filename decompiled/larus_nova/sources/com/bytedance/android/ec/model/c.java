package com.bytedance.android.ec.model;

import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class c {
    public static final SingleClickParam a(ClickButtonParam r110, int r111) {
        Intrinsics.checkNotNullParameter(r110, "$this$getSingleButtonParam");
        SingleClickParam r112 = (SingleClickParam) CollectionsKt.getOrNull(r110.getSingleClickParams(), r111);
        if (r112 == null) goto L5;
        return r112;
    L5:
        return new SingleClickParam(false, false, false, 0, null, null, null, null, false, null, 1023, null);
    }
}
