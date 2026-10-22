package com.bytedance.android.live.recharge;

import com.bytedance.android.live.recharge.platform.model.DiamondExtraListResult;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class f0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a0 f89977a;

    public f0(a0 r100) {
        this.f89977a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        DiamondExtraListResult r101 = (DiamondExtraListResult) r100;
        if (r101 == null) goto L5;
        this.f89977a.I.onNext(r101);
        return;
    L5:
        int r102 = com.bytedance.android.live.revenue.common.v.f91009a;
        com.bytedance.android.live.revenue.common.v.b("ttlive_recharge", "diamond extra empty.", null);
    }
}
