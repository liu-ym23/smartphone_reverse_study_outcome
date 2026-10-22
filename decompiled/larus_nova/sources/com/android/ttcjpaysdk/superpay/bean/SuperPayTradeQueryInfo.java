package com.android.ttcjpaysdk.superpay.bean;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.ss.android.downloadlib.constants.DownloadConstants;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/android/ttcjpaysdk/superpay/bean/SuperPayTradeQueryInfo;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "()V", "msg", "", "pay_again_info", "payment_info", "Lorg/json/JSONObject;", "sdk_info", DownloadConstants.KEY_TOAST, "", "status", "sub_msg", "fastpay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SuperPayTradeQueryInfo implements CJPayObject {
    public String msg;
    public String pay_again_info;
    public JSONObject payment_info;
    public String sdk_info;
    public boolean show_toast;
    public String status;
    public String sub_msg;

    public SuperPayTradeQueryInfo() {
        this.status = "";
        this.msg = "";
        this.sub_msg = "";
        this.sdk_info = "";
        this.pay_again_info = "";
    }
}
