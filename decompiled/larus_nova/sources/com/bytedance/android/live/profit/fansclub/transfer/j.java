package com.bytedance.android.live.profit.fansclub.transfer;

import com.bytedance.android.live.profit.fansclub.r;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class j<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.live.revenue.common.g f87393a;

    public j(com.bytedance.android.live.revenue.common.g r100) {
        this.f87393a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        r r101 = (r) r100;
        this.f87393a.a("success");
    }
}
