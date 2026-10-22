package com.bytedance.android.livesdk.livecommerce.utils;

import android.animation.Animator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class c {
    public static final void a(Animator r100, Function1 r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$doOnEnd");
        Intrinsics.checkNotNullParameter(r101, "callback");
        r100.addListener(new b(r101));
    }
}
