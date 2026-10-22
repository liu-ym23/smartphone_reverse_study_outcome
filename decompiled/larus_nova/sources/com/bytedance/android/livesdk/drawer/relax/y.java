package com.bytedance.android.livesdk.drawer.relax;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Boolean> f122760a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<? super Function1<? super Boolean, Boolean>, Unit> f122761b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Integer> f122762c;

    public y(Function0<Boolean> r100, Function1<? super Function1<? super Boolean, Boolean>, Unit> r101, Function0<Integer> r102) {
        Intrinsics.checkNotNullParameter(r100, "show");
        Intrinsics.checkNotNullParameter(r101, "setShowOpenLive");
        Intrinsics.checkNotNullParameter(r102, "openLiveShowCount");
        this.f122760a = r100;
        this.f122761b = r101;
        this.f122762c = r102;
    }
}
