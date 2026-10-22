package com.bytedance.android.live.xplay.basic;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class XplayTasksDslKt {
    public static final o a(Function1<? super e, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        f r101 = new f(XplayTasksDslKt$taskGraph$1.INSTANCE);
        r100.invoke(r101);
        return r101.f102808c.invoke(r101, r101.f102806a);
    }
}
