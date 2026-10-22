package com.bytedance.android.livehostapi.wrap;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.livehostapi.business.IHostWallet;
import com.bytedance.android.livehostapi.business.IHostWalletForSaas;
import com.bytedance.android.livesdkapi.depend.model.OrderInfo;

/* JADX INFO: loaded from: classes7.dex */
public abstract class AbsHostWallet implements IHostWallet {
    public AbsHostWallet() {
    }

    @Override // com.bytedance.android.livehostapi.business.IHostWalletForSaas
    public IHostWalletForSaas.BillingClientProxy getBillingClient(IHostWalletForSaas.PurchasesUpdatedListener r100) {
        return null;
    }

    @Override // com.bytedance.android.livehostapi.business.IHostWallet
    public String getCJAppId() {
        return "";
    }

    @Override // com.bytedance.android.livehostapi.business.IHostWallet
    public String getCJMerchantId() {
        return "";
    }

    @Override // com.bytedance.android.livehostapi.business.IHostWallet
    public boolean isFinancialVisible() {
        return false;
    }

    @Override // com.bytedance.android.livehostapi.business.IHostWalletForSaas
    public void openBillingProxyActivity(Context r100, Bundle r101) {
    }

    @Override // com.bytedance.android.livehostapi.business.IHostWalletForSaas
    public void payWithAli(Activity r100, OrderInfo r101, IHostWalletForSaas.IWalletPayResult r102) {
    }

    @Override // com.bytedance.android.livehostapi.business.IHostWalletForSaas
    public void payWithWX(Context r100, OrderInfo r101, IHostWalletForSaas.IWalletPayResult r102) {
    }

    @Override // com.bytedance.android.livehostapi.business.IHostWalletForSaas
    public void verifyWithAli(Activity r100, String r101, IHostWalletForSaas.IVerifyResult r102) {
    }
}
