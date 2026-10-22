package com.android.ttcjpaysdk.base.settings.bean;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\bB\u0005¢\u0006\u0002\u0010\u0003R\"\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/base/settings/bean/CJPayDegradeBean;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "degrade_infos", "Ljava/util/ArrayList;", "Lcom/android/ttcjpaysdk/base/settings/bean/CJPayDegradeBean$MerchantMapping;", "Lkotlin/collections/ArrayList;", "MerchantMapping", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayDegradeBean implements CJPayObject, Serializable {
    public ArrayList<MerchantMapping> degrade_infos;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/android/ttcjpaysdk/base/settings/bean/CJPayDegradeBean$MerchantMapping;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "bdpay_app_id", "", "bdpay_merchant_id", "cjpay_app_id", "cjpay_merchant_id", "is_balance_recharge_use_h5", "", "is_balance_withdraw_use_h5", "is_bdpay_use_h5", "is_card_list_use_h5", "is_pay_use_h5", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class MerchantMapping implements CJPayObject, Serializable {
        public String bdpay_app_id;
        public String bdpay_merchant_id;
        public String cjpay_app_id;
        public String cjpay_merchant_id;
        public boolean is_balance_recharge_use_h5;
        public boolean is_balance_withdraw_use_h5;
        public boolean is_bdpay_use_h5;
        public boolean is_card_list_use_h5;
        public boolean is_pay_use_h5;

        public MerchantMapping() {
        }
    }

    public CJPayDegradeBean() {
        this.degrade_infos = new ArrayList();
    }
}
