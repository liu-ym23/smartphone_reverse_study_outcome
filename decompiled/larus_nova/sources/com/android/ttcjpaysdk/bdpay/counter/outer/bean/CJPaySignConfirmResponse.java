package com.android.ttcjpaysdk.bdpay.counter.outer.bean;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.bytedance.android.shopping.slice.action.entity.SendClosePdpEventParam;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u001e2\u00020\u00012\u00020\u0002:\u0001\u001eB\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010\u001d\u001a\u00020\u001cR\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001a\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/bean/CJPaySignConfirmResponse;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "action_type", "", "background_url", "button_text", "code", "common_result_page_info_str", "complete_next_action", "Lcom/android/ttcjpaysdk/bdpay/counter/outer/bean/CompleteNextAction;", "icon", SendClosePdpEventParam.KEY_LYNX_URL, "msg", "multi_sign_info", "Lcom/android/ttcjpaysdk/bdpay/counter/outer/bean/CJPayMultiSignInfo;", "next_action", "Lcom/android/ttcjpaysdk/bdpay/counter/outer/bean/ConfirmNextAction;", "servier_name", "servier_name_title", "sign_result_desc", "sign_status", "sign_status_desc", "trace_params", "Lorg/json/JSONObject;", "voucher_promotion_put_info", "isDirectCallback", "", "isResponseOK", "Companion", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPaySignConfirmResponse implements CJPayObject, Serializable {
    public static final String ACTION_TYPE_CALLBACK_MERCHANT = "callback_merchant";
    public static final Companion Companion = null;
    public String action_type;
    public String background_url;
    public String button_text;
    public String code;
    public String common_result_page_info_str;
    public CompleteNextAction complete_next_action;
    public String icon;
    public String lynx_url;
    public String msg;
    public CJPayMultiSignInfo multi_sign_info;
    public ConfirmNextAction next_action;
    public String servier_name;
    public String servier_name_title;
    public String sign_result_desc;
    public String sign_status;
    public String sign_status_desc;
    public JSONObject trace_params;
    public String voucher_promotion_put_info;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/bean/CJPaySignConfirmResponse$Companion;", "", "()V", "ACTION_TYPE_CALLBACK_MERCHANT", "", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public final boolean isDirectCallback() {
        return Intrinsics.areEqual("callback_merchant", this.action_type);
    }

    public final boolean isResponseOK() {
        if (Intrinsics.areEqual(CJPaySignInfoQueryResponse.RESPONSE_SUCCEED, this.code) == false) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(CJPaySignInfoQueryResponse.CREDIT_RESPONSE_SUCCEED, this.code) == true) goto L8;
        return false;
    }

    public CJPaySignConfirmResponse() {
        this.code = "";
        this.msg = "";
        this.sign_status = "";
        this.sign_status_desc = "";
        this.sign_result_desc = "";
        this.servier_name = "";
        this.servier_name_title = "";
        this.button_text = "";
        this.icon = "";
        this.background_url = "";
        this.lynx_url = "";
        this.action_type = "";
        this.voucher_promotion_put_info = "";
        this.common_result_page_info_str = "";
    }
}
