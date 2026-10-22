package com.bytedance.android.live.profit.scoreboard;

import io.reactivex.functions.Consumer;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class c0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ v f88871a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ v.g f88872b;

    public c0(v r100, v.g r101) {
        this.f88871a = r100;
        this.f88872b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Pair r101 = (Pair) r100;
        RegionId r102 = (RegionId) r101.component1();
        j80.d r103 = (j80.d) r101.component2();
        v r104 = this.f88871a;
        v.g r105 = this.f88872b;
        j80.d r106 = v.a(r104, r105.f89003f, r105.f89000c, r102, r103);
        if ((!Intrinsics.areEqual(this.f88872b.f89001d.getPos(), r106)) == false) goto L6;
        jy0.b.d("ScoreboardBannerController", "(" + r102.getId() + ", " + r103 + ") to local pos: " + r106);
        this.f88872b.f89001d.a(r106);
        return;
    }
}
