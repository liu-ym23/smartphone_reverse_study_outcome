package com.bytedance.android.live.recharge.platform.service;

import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdkapi.depend.model.IChargeDeal;

/* JADX INFO: loaded from: classes47.dex */
public final class i implements com.bytedance.android.live.recharge.deal.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IChargeDeal f90311a;

    @Override // com.bytedance.android.live.recharge.deal.p
    public final IChargeDeal a() {
        return this.f90311a;
    }

    public i(ExtraResponse r100) {
        this.f90311a = ((com.bytedance.android.live.recharge.model.diamond.a) r100.extra).n();
    }
}
