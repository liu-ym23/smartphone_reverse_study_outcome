package com.bytedance.android.livehostapi.business.flavor.dylite;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.livehostapi.business.base.IBaseHostWallet;

/* JADX INFO: loaded from: classes7.dex */
public interface IHostWalletForDylite extends IService, IBaseHostWallet {
    String getCJAppId();

    String getCJMerchantId();
}
