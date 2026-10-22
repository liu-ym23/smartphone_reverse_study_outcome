package com.bytedance.android.shopping.prepurchase.arch.container.component;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class b {
    public static final void a(AbsComponent<?, ?> r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$logD");
        Intrinsics.checkNotNullParameter(r101, "message");
        r100.O1().w7().d(r100.getClass().getSimpleName(), r101);
    }

    public static final void c(AbsComponent<?, ?> r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$logI");
        Intrinsics.checkNotNullParameter(r101, "message");
        r100.O1().w7().i(r100.getClass().getSimpleName(), r101);
    }

    public static final void b(AbsComponent<?, ?> r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$logE");
        Intrinsics.checkNotNullParameter(r101, "message");
        r100.O1().w7().e(r100.getClass().getSimpleName(), r101, r102);
    }
}
