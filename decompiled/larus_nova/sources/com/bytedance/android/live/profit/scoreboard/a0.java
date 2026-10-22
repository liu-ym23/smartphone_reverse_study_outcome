package com.bytedance.android.live.profit.scoreboard;

import io.reactivex.functions.Consumer;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class a0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ v f88865a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ v.g f88866b;

    public a0(v r100, v.g r101) {
        this.f88865a = r100;
        this.f88866b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Unit r101 = (Unit) r100;
        if (((Boolean) this.f88865a.f88976c.d().f64752a).booleanValue() == true) goto L10;
        Pair r102 = (Pair) this.f88865a.f88976c.x().f64752a;
        v r103 = this.f88865a;
        v.g r104 = this.f88866b;
        j80.d r105 = v.a(r103, r104.f89003f, r104.f89000c, (RegionId) r102.getFirst(), (j80.d) r102.getSecond());
        if ((!Intrinsics.areEqual(j80.b.a(this.f88866b.f89000c), r105)) == false) goto L9;
        jy0.b.d("ScoreboardBannerController", "(" + ((RegionId) r102.getFirst()).getId() + ", " + ((j80.d) r102.getSecond()) + ") to local pos: " + r105);
        j80.b.e(this.f88866b.f89000c, r105);
        return;
    L9:
        return;
    }
}
