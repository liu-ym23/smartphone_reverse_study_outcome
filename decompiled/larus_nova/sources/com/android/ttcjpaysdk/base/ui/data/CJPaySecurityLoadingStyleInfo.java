package com.android.ttcjpaysdk.base.ui.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.bdpay.security.loading.data.CJPaySecurityLoadingConstant;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/data/CJPaySecurityLoadingStyleInfo;", "Ljava/io/Serializable;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "()V", "bind_card_complete_show_info", "Lcom/android/ttcjpaysdk/base/ui/data/CJPaySecurityLoadingStyleInfo$CJPaySecurityItemShowInfo;", "bind_card_confirm_paying_show_info", "bind_card_confirm_pre_show_info", "loading_style", "", "nopwd_combine_paying_show_info", "nopwd_combine_pre_show_info", "pay_verify_pre_show_info", "trade_confirm_paying_show_info", "trade_confirm_pre_show_info", "version", "CJPaySecurityItemShowInfo", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPaySecurityLoadingStyleInfo implements Serializable, CJPayObject {
    public CJPaySecurityItemShowInfo bind_card_complete_show_info;
    public CJPaySecurityItemShowInfo bind_card_confirm_paying_show_info;
    public CJPaySecurityItemShowInfo bind_card_confirm_pre_show_info;
    public String loading_style;
    public CJPaySecurityItemShowInfo nopwd_combine_paying_show_info;
    public CJPaySecurityItemShowInfo nopwd_combine_pre_show_info;
    public CJPaySecurityItemShowInfo pay_verify_pre_show_info;
    public CJPaySecurityItemShowInfo trade_confirm_paying_show_info;
    public CJPaySecurityItemShowInfo trade_confirm_pre_show_info;
    public String version;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/data/CJPaySecurityLoadingStyleInfo$CJPaySecurityItemShowInfo;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "min_time", "", "text", "url", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class CJPaySecurityItemShowInfo implements CJPayObject, Serializable {
        public String min_time;
        public String text;
        public String url;

        public CJPaySecurityItemShowInfo() {
            this.text = "";
            this.min_time = "-1";
            this.url = "";
        }
    }

    public CJPaySecurityLoadingStyleInfo() {
        this.loading_style = CJPaySecurityLoadingConstant.CJ_PAY_SECURITY_LOADING_BREATHE_STYLE;
        this.bind_card_complete_show_info = new CJPaySecurityItemShowInfo();
        this.bind_card_confirm_pre_show_info = new CJPaySecurityItemShowInfo();
        this.bind_card_confirm_paying_show_info = new CJPaySecurityItemShowInfo();
        this.trade_confirm_pre_show_info = new CJPaySecurityItemShowInfo();
        this.trade_confirm_paying_show_info = new CJPaySecurityItemShowInfo();
        this.nopwd_combine_pre_show_info = new CJPaySecurityItemShowInfo();
        this.nopwd_combine_paying_show_info = new CJPaySecurityItemShowInfo();
        this.pay_verify_pre_show_info = new CJPaySecurityItemShowInfo();
        this.version = "StandardV1";
    }
}
