package com.android.ttcjpaysdk.thirdparty.data;

import com.alipay.sdk.m.k.b;
import com.alipay.sdk.m.p.e;
import com.android.ttcjpaysdk.base.encrypt.CJPaySecureRequestParams;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.ui.data.AssetInfoBean;
import com.android.ttcjpaysdk.verify.constants.DyVerifyReqConstants;
import com.ss.android.cert.manager.constants.EventConstant;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010 \u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010!\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\"\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010$\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010%\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010&\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010'\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010(\u001a\u0004\u0018\u00010)8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010*\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\"\u0010+\u001a\u0012\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010,8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010-\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010.\u001a\u00020/8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u00100\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u00101\u001a\u0004\u0018\u0001028\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u00103\u001a\u0004\u0018\u0001048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u00105\u001a\u0004\u0018\u0001068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u00107\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u00108\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u00109\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010:\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010;\u001a\u0004\u0018\u00010<8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010=\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010>\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010?\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010@\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010A\u001a\u00020B8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010C\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010D\u001a\u00020/8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010E\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010F\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010G\u001a\u0004\u0018\u00010H8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010I\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010J\u001a\u0004\u0018\u00010K8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010L\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006M"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/data/CJPayTradeConfirmBizContentBasicParams;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "()V", "account_info", "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayAccountInfo;", "asset_meta_info_list", "Ljava/util/ArrayList;", "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$AssetMetaInfoBean;", "card_item", "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayCardItem;", EventConstant.Key.CERT_CODE, "", "cert_type", "channel_pay_type", "combine_type", "credit_item", "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayCreditItem;", "cvv", "deduct_params", "double_check_req", "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayTradeConfirmBizContentParams$DoubleCheckReq;", "expanded", "", "extension", "exts", "Lorg/json/JSONObject;", "face_pay_scene", "face_verify_params", "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayFaceVerifyParam;", "foreign_card_pay_ext", "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayTradeConfirmBizContentParams$ForeignCardPayExt;", "fund_bill_index", "hasOptionVoucher", "isFromCreditPayActiveOrUnlock", "is_click_open_bio_guide", "merchant_id", e.f25671s, "no_pwd_confirm_hide_period", "nonblock_anti_laundering_canceled", "o_server_params", "one_time_pwd", "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayOneTimePwd;", b.A0, "params", "", "pay_addi_type_list", "pay_amount", "", "pay_type", "pre_params", "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayTradeConfirmBizContentParams$PreParams;", "pre_query_withdraw_info", "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayTradeConfirmBizContentParams$PreQueryWithdrawInfo;", "process_info", "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayProcessInfo;", "promotion_scene", "pwd", "pwd_type", "req_type", DyVerifyReqConstants.Key.SECURE_REQUEST_PARAMS, "Lcom/android/ttcjpaysdk/base/encrypt/CJPaySecureRequestParams;", "selected_open_nopwd", "share_asset_id", "sign_no", "sms", "to_combine_asset_index", "", "token", "trade_amount", b.B0, "uniqueSymbol", "user_retain_info", "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayTradeQueryBizContentParams$UserRetainInfo;", "verify_id", "verify_info", "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayTradeQueryBizContentParams$VerifyInfo;", "voucher_no_list", "bdpay-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class CJPayTradeConfirmBizContentBasicParams implements CJPayObject {
    public CJPayAccountInfo account_info;
    public ArrayList<AssetInfoBean.AssetMetaInfoBean> asset_meta_info_list;
    public CJPayCardItem card_item;
    public String cert_code;
    public String cert_type;
    public String channel_pay_type;
    public String combine_type;
    public CJPayCreditItem credit_item;
    public String cvv;
    public String deduct_params;
    public CJPayTradeConfirmBizContentParams.DoubleCheckReq double_check_req;
    public boolean expanded;
    public String extension;
    public JSONObject exts;
    public String face_pay_scene;
    public CJPayFaceVerifyParam face_verify_params;
    public CJPayTradeConfirmBizContentParams.ForeignCardPayExt foreign_card_pay_ext;
    public String fund_bill_index;
    public boolean hasOptionVoucher;
    public boolean isFromCreditPayActiveOrUnlock;
    public String is_click_open_bio_guide;
    public String merchant_id;
    public String method;
    public String no_pwd_confirm_hide_period;
    public boolean nonblock_anti_laundering_canceled;
    public JSONObject o_server_params;
    public CJPayOneTimePwd one_time_pwd;
    public String out_trade_no;
    public Map<String, String> params;
    public ArrayList<String> pay_addi_type_list;
    public long pay_amount;
    public String pay_type;
    public CJPayTradeConfirmBizContentParams.PreParams pre_params;
    public CJPayTradeConfirmBizContentParams.PreQueryWithdrawInfo pre_query_withdraw_info;
    public CJPayProcessInfo process_info;
    public String promotion_scene;
    public String pwd;
    public String pwd_type;
    public String req_type;
    public CJPaySecureRequestParams secure_request_params;
    public boolean selected_open_nopwd;
    public String share_asset_id;
    public String sign_no;
    public String sms;
    public int to_combine_asset_index;
    public String token;
    public long trade_amount;
    public String trade_no;
    public String uniqueSymbol;
    public CJPayTradeQueryBizContentParams.UserRetainInfo user_retain_info;
    public String verify_id;
    public CJPayTradeQueryBizContentParams.VerifyInfo verify_info;
    public ArrayList<String> voucher_no_list;

    public CJPayTradeConfirmBizContentBasicParams() {
        this.method = "cashdesk.sdk.pay.confirm";
        this.out_trade_no = "";
        this.promotion_scene = "";
        this.no_pwd_confirm_hide_period = "";
        this.combine_type = "";
        this.token = "";
        this.is_click_open_bio_guide = "";
        this.deduct_params = "";
        this.extension = "";
        this.to_combine_asset_index = -1;
        this.double_check_req = new CJPayTradeConfirmBizContentParams.DoubleCheckReq();
    }
}
