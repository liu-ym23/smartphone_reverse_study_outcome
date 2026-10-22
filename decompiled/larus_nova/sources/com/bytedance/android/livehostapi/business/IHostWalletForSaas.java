package com.bytedance.android.livehostapi.business;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.livehostapi.business.base.IBaseHostWallet;
import com.bytedance.android.livesdkapi.depend.model.ChargeDeal;
import com.bytedance.android.livesdkapi.depend.model.OrderInfo;
import com.bytedance.android.livesdkapi.host.PayChannel;
import com.bytedance.android.livesdkapi.model.Purchase;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public interface IHostWalletForSaas extends IBaseHostWallet {
    public static final String KEY_BUNDLE_CHARGE_REASON = "KEY_CHARGE_REASON";
    public static final String KEY_BUNDLE_IS_ANCHOR = "key_bundle_is_anchor";
    public static final String KEY_BUNDLE_SOURCE = "key_bundle_source";
    public static final int WALLET_PAY_CANCEL = 2;
    public static final int WALLET_PAY_FAILED = 3;
    public static final int WALLET_PAY_QUERY_ORDER = 1;
    public static final int WALLET_PAY_SHOW_CAHISER = 2;
    public static final int WALLET_PAY_SUCCESS = 1;

    /* JADX INFO: renamed from: com.bytedance.android.livehostapi.business.IHostWalletForSaas$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static BillingClientProxy $default$getBillingClient(IHostWalletForSaas r100, PurchasesUpdatedListener r101) {
            return null;
        }

        public static void $default$openBillingProxyActivity(IHostWalletForSaas r100, Context r101, Bundle r102) {
        }

        public static void $default$payWithAli(IHostWalletForSaas r100, Activity r101, OrderInfo r102, IWalletPayResult r103) {
        }

        public static void $default$payWithWX(IHostWalletForSaas r100, Context r101, OrderInfo r102, IWalletPayResult r103) {
        }

        public static void $default$verifyWithAli(IHostWalletForSaas r100, Activity r101, String r102, IVerifyResult r103) {
        }
    }

    public interface BillingClientProxy {
        void consumeAsync(String r100, ConsumeResponseListener r101);

        void endConnection();

        int launchBillingFlow(Activity r100, String r101);

        PurchasesResult queryPurchases();

        void querySkuDetailsAsync(List<String> r100, SkuDetailsResponseListener r101);

        void startConnection(BillingClientStateListener r100);
    }

    public interface BillingClientStateListener {
        void onBillingServiceDisconnected();

        void onBillingSetupFinished(int r100);
    }

    public interface BillingResponse {
        public static final int BILLING_UNAVAILABLE = 3;
        public static final int DEVELOPER_ERROR = 5;
        public static final int ERROR = 6;
        public static final int FEATURE_NOT_SUPPORTED = -2;
        public static final int ITEM_ALREADY_OWNED = 7;
        public static final int ITEM_NOT_OWNED = 8;
        public static final int ITEM_UNAVAILABLE = 4;
        public static final int OK = 0;
        public static final int SERVICE_DISCONNECTED = -1;
        public static final int SERVICE_UNAVAILABLE = 2;
        public static final int USER_CANCELED = 1;
    }

    public interface ConsumeResponseListener {
        void onConsumeResponse(int r100, String r101);
    }

    public interface IVerifyResult {
        void onVerifyError(Throwable r100);

        void onVerifyResult(String r100);
    }

    public interface IWalletPayResult {
        void onPayError(PayChannel r100, Throwable r101);

        void onPayResult(PayChannel r100, String r101, String r102, String r103);

        void onPayStart(PayChannel r100, OrderInfo r101);
    }

    public interface PurchasesResult {
        List<Purchase> getPurchasesList();

        int getResponseCode();
    }

    public interface PurchasesUpdatedListener {
        void onPurchasesUpdated(int r100, List<Purchase> r101);
    }

    public interface SkuDetailsResponseListener {
        void onSkuDetailsResponse(int r100, List<ChargeDeal.HsSkuDetail> r101);
    }

    BillingClientProxy getBillingClient(PurchasesUpdatedListener r100);

    void openBillingProxyActivity(Context r100, Bundle r101);

    void payWithAli(Activity r100, OrderInfo r101, IWalletPayResult r102);

    void payWithWX(Context r100, OrderInfo r101, IWalletPayResult r102);

    void verifyWithAli(Activity r100, String r101, IVerifyResult r102);
}
