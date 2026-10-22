package com.bytedance.android.livesdk.utils;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class u4 {
    public static final void a(q4.b r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$cancelAndStart");
        r100.a();
        r100.c();
    }

    public static /* synthetic */ q4.b c(Function1 r100) {
        q4.f159129j.getClass();
        return b(q4.a.a(), r100);
    }

    public static final q4.b b(boolean r100, Function1<? super q4, Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "init");
        q4 r102 = new q4(r100);
        r101.invoke(r102);
        return new q4.b(r102);
    }
}
