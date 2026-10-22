package com.bytedance.android.openlive.wrapper;

import com.bytedance.android.livehostapi.wrap.AbsHostWallet;
import ry.h;

/* JADX INFO: loaded from: classes12.dex */
public class LiveHostWalletWrapper extends AbsHostWallet {
    private h param;

    @Override // com.bytedance.android.livehostapi.wrap.AbsHostWallet, com.bytedance.android.livehostapi.business.IHostWallet
    public String getCJAppId() {
        return this.param.getCJAppId();
    }

    @Override // com.bytedance.android.livehostapi.wrap.AbsHostWallet, com.bytedance.android.livehostapi.business.IHostWallet
    public String getCJMerchantId() {
        return this.param.getCJMerchantId();
    }

    public LiveHostWalletWrapper(h r100) {
        this.param = r100;
    }
}
