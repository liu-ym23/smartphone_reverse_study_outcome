package com.bytedance.android.livesdk.drawer.relax;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<? super Boolean, Unit> f122713a;

    public o(Function1<? super Boolean, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "handleRetry");
        this.f122713a = r100;
    }
}
