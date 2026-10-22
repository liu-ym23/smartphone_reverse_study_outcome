package com.bytedance.android.livesdk.drawer.relax;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Integer> f122583a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<? super Function1<? super Integer, Integer>, Unit> f122584b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function2<? super Integer, ? super Boolean, Unit> f122585c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<Integer> f122586d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function1<? super Function1<? super Integer, Integer>, Unit> f122587e;

    public b0(Function0<Integer> r100, Function1<? super Function1<? super Integer, Integer>, Unit> r101, Function2<? super Integer, ? super Boolean, Unit> r102, Function0<Integer> r103, Function1<? super Function1<? super Integer, Integer>, Unit> r104) {
        Intrinsics.checkNotNullParameter(r100, "selectedIndex");
        Intrinsics.checkNotNullParameter(r101, "setSelectedIndex");
        Intrinsics.checkNotNullParameter(r102, "handleTabChange");
        Intrinsics.checkNotNullParameter(r103, "refreshTab");
        Intrinsics.checkNotNullParameter(r104, "setRefreshTab");
        this.f122583a = r100;
        this.f122584b = r101;
        this.f122585c = r102;
        this.f122586d = r103;
        this.f122587e = r104;
    }
}
