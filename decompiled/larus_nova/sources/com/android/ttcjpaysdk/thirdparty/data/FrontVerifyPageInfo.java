package com.android.ttcjpaysdk.thirdparty.data;

import com.android.ttcjpaysdk.base.json.CJPayJsonParser;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.settings.bean.CJPayOptimizeSwitch;
import com.android.ttcjpaysdk.base.ui.data.CJPayNoPwdPayInfo;
import com.android.ttcjpaysdk.base.ui.data.PayNewCardReconfirmInfo;
import java.io.Serializable;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\t\u001a\u0004\u0018\u00010\nR\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/data/FrontVerifyPageInfo;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "code", "", "msg", "verify_page_info", "Lcom/android/ttcjpaysdk/thirdparty/data/VerifyPageInfo;", "toCheckoutResponseBeanJO", "Lorg/json/JSONObject;", "bdpay-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FrontVerifyPageInfo implements CJPayObject, Serializable {
    public String code;
    public String msg;
    public VerifyPageInfo verify_page_info;

    public final JSONObject toCheckoutResponseBeanJO() {
        CJPayCheckoutCounterResponseBean r100 = new CJPayCheckoutCounterResponseBean();
        r100.code = this.code;
        r100.msg = this.msg;
        VerifyPageInfo r101 = this.verify_page_info;
        r100.merchant_info = r101.merchant_info;
        r100.trade_info = r101.trade_info;
        r100.user_info = r101.user_info;
        r100.cashdesk_show_conf = r101.cashdesk_show_conf;
        r100.result_page_show_conf = r101.result_page_show_conf;
        r100.process_info = r101.process_info;
        r100.nopwd_guide_info = r101.nopwd_guide_info;
        r100.need_resign_card = r101.need_resign_card;
        r100.show_no_pwd_confirm_page = r101.show_no_pwd_confirm_page;
        r100.pay_info = r101.pay_info;
        r100.pre_bio_guide_info = r101.pre_bio_guide;
        r100.top_right_btn_info = r101.top_right_btn_info;
        r100.back_top_right_btn_info = r101.back_top_right_btn_info;
        r100.skip_bio_confirm_page = r101.skip_bio_confirm_page;
        r100.used_paytype_info = r101.used_paytype_info;
        r100.paytype_info = r101.paytype_info;
        r100.sdk_show_info = r101.sdk_show_info;
        CJPayNoPwdPayInfo r102 = r101.secondary_confirm_info;
        if (r102 == null) goto L5;
        r100.secondary_confirm_info = r102;
    L5:
        PayNewCardReconfirmInfo r103 = r101.pay_new_card_reconfirm_info;
        if (r103 == null) goto L8;
        r100.pay_new_card_reconfirm_info = r103;
    L8:
        r100.next_page = r101.next_page;
        r100.used_asset_info = r101.used_asset_info;
        r100.smart_info = r101.smart_info;
        if (CJPayOptimizeSwitch.Companion.get().fixPayAgainResultPageTeaParam == false) goto L12;
        r100.grey_func_map = r101.grey_func_map;
    L12:
        return CJPayJsonParser.toJsonObject(r100);
    }

    public FrontVerifyPageInfo() {
        this.code = "";
        this.msg = "";
        this.verify_page_info = new VerifyPageInfo();
    }
}
