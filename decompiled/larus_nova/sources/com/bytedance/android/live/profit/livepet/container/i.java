package com.bytedance.android.live.profit.livepet.container;

import io.reactivex.functions.Consumer;
import kotlin.Pair;

/* JADX INFO: loaded from: classes47.dex */
public final class i<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f87855a;

    public i(e r100) {
        this.f87855a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Pair r101 = (Pair) r100;
        n r102 = this.f87855a.f87847c;
        r102.f87867a = ((Number) r101.getFirst()).intValue();
        n r103 = this.f87855a.f87847c;
        r103.f87868b = ((Number) r101.getSecond()).intValue();
        e r104 = this.f87855a;
        e.a(r104, r104.f87847c);
        e r105 = this.f87855a;
        e.a(r105, r105.f87848d);
    }
}
