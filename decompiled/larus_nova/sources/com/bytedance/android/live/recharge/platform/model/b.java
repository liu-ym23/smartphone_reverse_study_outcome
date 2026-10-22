package com.bytedance.android.live.recharge.platform.model;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdkapi.depend.model.ChargeDeal;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes47.dex */
public final class b {
    public static final ChargeDeal a(long r100, int r101, boolean r102) {
        ChargeDeal r103 = new ChargeDeal();
        r103.setId(r100);
        r103.setPrice(r101);
        r103.setExchangePrice(r101);
        r103.setDiamondCount(r101 / 10);
        r103.setDescribe(s1.B(R.string.ttlive_live_charge_recommend));
        r103.setCustomizedDiamond(r102);
        return r103;
    }
}
