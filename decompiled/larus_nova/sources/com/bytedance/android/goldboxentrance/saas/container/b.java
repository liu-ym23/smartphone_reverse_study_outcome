package com.bytedance.android.goldboxentrance.saas.container;

import com.bytedance.android.goldboxentrance.saas.firstguide.NewBoxGuider;
import cq2.d;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes44.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GoldCoinEntranceWidget f58114a;

    public b(GoldCoinEntranceWidget r100) {
        this.f58114a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        d r101 = (d) r100;
        NewBoxGuider r102 = this.f58114a.f58107f;
        if (r102 != null) goto L5;
        return;
    L5:
        if (r102.f58147j != true) goto L9;
        r102.a();
        return;
    }
}
