package com.bytedance.android.livesdk.drawer.relax;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Long f122629a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l0 f122630b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<? extends l0> f122631c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<Boolean> f122632d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function1<? super Function1<? super Boolean, Boolean>, Unit> f122633e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function0<Integer> f122634f;

    public f0(Long r100, l0 r101, Function0<? extends l0> r102, Function0<Boolean> r103, Function1<? super Function1<? super Boolean, Boolean>, Unit> r104, Function0<Integer> r105) {
        Intrinsics.checkNotNullParameter(r101, "tabItem");
        Intrinsics.checkNotNullParameter(r102, "recommendTab");
        Intrinsics.checkNotNullParameter(r103, "multiTab");
        Intrinsics.checkNotNullParameter(r104, "setShowOpenLiveComp");
        Intrinsics.checkNotNullParameter(r105, "tabIndex");
        this.f122629a = r100;
        this.f122630b = r101;
        this.f122631c = r102;
        this.f122632d = r103;
        this.f122633e = r104;
        this.f122634f = r105;
    }
}
