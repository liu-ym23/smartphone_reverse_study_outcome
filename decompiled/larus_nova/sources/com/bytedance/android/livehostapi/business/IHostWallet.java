package com.bytedance.android.livehostapi.business;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.livehostapi.business.base.IBaseHostWallet;

/* JADX INFO: loaded from: classes7.dex */
public interface IHostWallet extends IService, IBaseHostWallet, IHostWalletForSaas {
    public static final String KEY_BUNDLE_REQUEST_PAGE = "KEY_REQUEST_PAGE";

    String getCJAppId();

    String getCJMerchantId();

    boolean isFinancialVisible();
}
