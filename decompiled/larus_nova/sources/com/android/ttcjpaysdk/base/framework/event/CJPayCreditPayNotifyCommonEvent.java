package com.android.ttcjpaysdk.base.framework.event;

import com.android.ttcjpaysdk.base.eventbus.BaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0012\u001a\u00020\u0003H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/event/CJPayCreditPayNotifyCommonEvent;", "Lcom/android/ttcjpaysdk/base/eventbus/BaseEvent;", "code", "", "payToken", "verifyInfo", "Lorg/json/JSONObject;", "(Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;)V", "getCode", "()Ljava/lang/String;", "setCode", "(Ljava/lang/String;)V", "getPayToken", "setPayToken", "getVerifyInfo", "()Lorg/json/JSONObject;", "setVerifyInfo", "(Lorg/json/JSONObject;)V", "toString", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayCreditPayNotifyCommonEvent extends BaseEvent {
    private String code;
    private String payToken;
    private JSONObject verifyInfo;

    public String toString() {
        return "CJPayCreditPayNotifyCommonEvent(code='" + this.code + "', payToken='" + this.payToken + "', verifyInfo=" + this.verifyInfo + ')';
    }

    public final String getCode() {
        return this.code;
    }

    public final String getPayToken() {
        return this.payToken;
    }

    public final JSONObject getVerifyInfo() {
        return this.verifyInfo;
    }

    public final void setCode(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.code = r100;
    }

    public final void setPayToken(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.payToken = r100;
    }

    public final void setVerifyInfo(JSONObject r100) {
        this.verifyInfo = r100;
    }

    public CJPayCreditPayNotifyCommonEvent(String r100, String r101, JSONObject r102) {
        Intrinsics.checkNotNullParameter(r100, "code");
        Intrinsics.checkNotNullParameter(r101, "payToken");
        this.code = r100;
        this.payToken = r101;
        this.verifyInfo = r102;
    }

    public /* synthetic */ CJPayCreditPayNotifyCommonEvent(String r100, String r101, JSONObject r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = "";
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = null;
    L8:
        this(r100, r101, r102);
    }
}
