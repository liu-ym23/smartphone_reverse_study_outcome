package com.bytedance.android.livehostapi.hostdefault;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.livehostapi.business.IHostWallet;
import com.bytedance.android.livehostapi.business.IHostWalletForSaas;
import com.bytedance.android.livesdkapi.depend.model.OrderInfo;

/* JADX INFO: loaded from: classes7.dex */
public class HostWalletDefault implements IHostWallet {
    public HostWalletDefault() {
    }

    @Override // com.bytedance.android.livehostapi.business.IHostWalletForSaas
    public final /* synthetic */ IHostWalletForSaas.BillingClientProxy getBillingClient(IHostWalletForSaas.PurchasesUpdatedListener r100) {
        return IHostWalletForSaas.CC.$default$getBillingClient(this, r100);
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
    public final /* synthetic */ void openBillingProxyActivity(Context r100, Bundle r101) {
        IHostWalletForSaas.CC.$default$openBillingProxyActivity(this, r100, r101);
    }

    @Override // com.bytedance.android.livehostapi.business.IHostWalletForSaas
    public final /* synthetic */ void payWithAli(Activity r100, OrderInfo r101, IHostWalletForSaas.IWalletPayResult r102) {
        IHostWalletForSaas.CC.$default$payWithAli(this, r100, r101, r102);
    }

    @Override // com.bytedance.android.livehostapi.business.IHostWalletForSaas
    public final /* synthetic */ void payWithWX(Context r100, OrderInfo r101, IHostWalletForSaas.IWalletPayResult r102) {
        IHostWalletForSaas.CC.$default$payWithWX(this, r100, r101, r102);
    }

    @Override // com.bytedance.android.livehostapi.business.IHostWalletForSaas
    public final /* synthetic */ void verifyWithAli(Activity r100, String r101, IHostWalletForSaas.IVerifyResult r102) {
        IHostWalletForSaas.CC.$default$verifyWithAli(this, r100, r101, r102);
    }
}
