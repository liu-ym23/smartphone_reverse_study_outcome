package com.bytedance.android.livesdk.paas;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class a {
    public static final <T> kjc.b<T> a(kjc.c<T> r100, Function0<? extends T> r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$onSaaS");
        Intrinsics.checkNotNullParameter(r101, "block");
        kjc.b<T> r102 = r100.f503730a;
        r102.f503729a = r101.invoke();
        r100.f503731b = true;
        return r100.f503730a;
    }
}
