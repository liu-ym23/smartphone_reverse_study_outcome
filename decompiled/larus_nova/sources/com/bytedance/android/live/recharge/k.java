package com.bytedance.android.live.recharge;

import com.bytedance.android.live.ai.api.model.RechargeCurrentCacheData;

/* JADX INFO: loaded from: classes47.dex */
public interface k extends dy0.c {

    public interface a {
        void a();

        void b(int r100, int r101, long r102);
    }

    public interface b {
    }

    void fetchAutoExchangeStatus(int r100);

    RechargeCurrentCacheData getCurrentRechargeCacheDataObject();

    Object getRechargeLynxBehavior();

    zv0.f rechargeCenter();
}
