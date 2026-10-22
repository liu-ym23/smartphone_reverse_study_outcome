package com.bytedance.android.live.openplatform.api.utils;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class f {
    /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.Object] */
    public static final void a(kjc.c r100, Function0 r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$onSaaS");
        Intrinsics.checkNotNullParameter(r101, "block");
        kjc.b<T> r102 = r100.f503730a;
        r102.f503729a = r101.invoke();
        r100.f503731b = true;
    }
}
