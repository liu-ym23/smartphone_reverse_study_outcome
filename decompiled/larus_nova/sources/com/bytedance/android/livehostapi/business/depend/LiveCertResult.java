package com.bytedance.android.livehostapi.business.depend;

import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.ControlRule;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B5\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u0006\u0010\u0015\u001a\u00020\u0016J\b\u0010\u0017\u001a\u00020\u0007H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000f¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/LiveCertResult;", "", "status", "Lcom/bytedance/android/livehostapi/business/depend/LiveCertStatus;", "errorCode", "", "errorMsg", "", "ticket", ControlRule.KEY_EXTRA_DATA, "Lorg/json/JSONObject;", "(Lcom/bytedance/android/livehostapi/business/depend/LiveCertStatus;ILjava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;)V", "getErrorCode", "()I", "getErrorMsg", "()Ljava/lang/String;", "getExtraData", "()Lorg/json/JSONObject;", "getStatus", "()Lcom/bytedance/android/livehostapi/business/depend/LiveCertStatus;", "getTicket", "isVerify", "", "toString", "hostapp-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveCertResult {
    private final int errorCode;
    private final String errorMsg;
    private final JSONObject extraData;
    private final LiveCertStatus status;
    private final String ticket;

    public final boolean isVerify() {
        LiveCertStatus r100 = this.status;
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.getCertStatus() != 1) goto L9;
        return true;
    L9:
        return false;
    }

    public String toString() {
        return "LiveCertResult(status=" + this.status + ", errorCode=" + this.errorCode + ", errorMsg=" + this.errorMsg + ", ticket=" + this.ticket + ", extraData=" + this.extraData + ')';
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorMsg() {
        return this.errorMsg;
    }

    public final JSONObject getExtraData() {
        return this.extraData;
    }

    public final LiveCertStatus getStatus() {
        return this.status;
    }

    public final String getTicket() {
        return this.ticket;
    }

    public LiveCertResult(LiveCertStatus r100, int r101, String r102, String r103, JSONObject r104) {
        this.status = r100;
        this.errorCode = r101;
        this.errorMsg = r102;
        this.ticket = r103;
        this.extraData = r104;
    }
}
