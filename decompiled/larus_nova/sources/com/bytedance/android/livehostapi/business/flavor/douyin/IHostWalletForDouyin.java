package com.bytedance.android.livehostapi.business.flavor.douyin;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.livehostapi.business.base.IBaseHostWallet;

/* JADX INFO: loaded from: classes7.dex */
public interface IHostWalletForDouyin extends IService, IBaseHostWallet {
    String getCJAppId();

    String getCJMerchantId();
}
