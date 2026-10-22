package com.android.ttcjpaysdk.thirdparty.verify.params;

import com.android.ttcjpaysdk.thirdparty.data.CJPayTradeConfirmBizContentParams;
import com.android.ttcjpaysdk.thirdparty.data.FrontSubPayTypeInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/verify/params/VerifyNewPwdParams;", "", "()V", "activityLabel", "", "getActivityLabel", "()Ljava/lang/String;", "setActivityLabel", "(Ljava/lang/String;)V", "activityShowStyle", "Lcom/android/ttcjpaysdk/thirdparty/verify/params/ActivityShowStyle;", "getActivityShowStyle", "()Lcom/android/ttcjpaysdk/thirdparty/verify/params/ActivityShowStyle;", "setActivityShowStyle", "(Lcom/android/ttcjpaysdk/thirdparty/verify/params/ActivityShowStyle;)V", "bindCardShowStyle", "Lcom/android/ttcjpaysdk/thirdparty/verify/params/BindCardShowStyle;", "getBindCardShowStyle", "()Lcom/android/ttcjpaysdk/thirdparty/verify/params/BindCardShowStyle;", "setBindCardShowStyle", "(Lcom/android/ttcjpaysdk/thirdparty/verify/params/BindCardShowStyle;)V", "subPayInfo", "Lcom/android/ttcjpaysdk/thirdparty/data/FrontSubPayTypeInfo;", "getSubPayInfo", "()Lcom/android/ttcjpaysdk/thirdparty/data/FrontSubPayTypeInfo;", "setSubPayInfo", "(Lcom/android/ttcjpaysdk/thirdparty/data/FrontSubPayTypeInfo;)V", "tradeConfirmParams", "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayTradeConfirmBizContentParams;", "getTradeConfirmParams", "()Lcom/android/ttcjpaysdk/thirdparty/data/CJPayTradeConfirmBizContentParams;", "setTradeConfirmParams", "(Lcom/android/ttcjpaysdk/thirdparty/data/CJPayTradeConfirmBizContentParams;)V", "bdpay-verify_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VerifyNewPwdParams {
    private String activityLabel;
    private ActivityShowStyle activityShowStyle;
    private BindCardShowStyle bindCardShowStyle;
    private FrontSubPayTypeInfo subPayInfo;
    private CJPayTradeConfirmBizContentParams tradeConfirmParams;

    public VerifyNewPwdParams() {
        this.bindCardShowStyle = BindCardShowStyle.OLD;
        this.activityShowStyle = ActivityShowStyle.OLD;
        this.activityLabel = "";
    }

    public final String getActivityLabel() {
        return this.activityLabel;
    }

    public final ActivityShowStyle getActivityShowStyle() {
        return this.activityShowStyle;
    }

    public final BindCardShowStyle getBindCardShowStyle() {
        return this.bindCardShowStyle;
    }

    public final FrontSubPayTypeInfo getSubPayInfo() {
        return this.subPayInfo;
    }

    public final CJPayTradeConfirmBizContentParams getTradeConfirmParams() {
        return this.tradeConfirmParams;
    }

    public final void setActivityLabel(String r100) {
        this.activityLabel = r100;
    }

    public final void setActivityShowStyle(ActivityShowStyle r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.activityShowStyle = r100;
    }

    public final void setBindCardShowStyle(BindCardShowStyle r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.bindCardShowStyle = r100;
    }

    public final void setSubPayInfo(FrontSubPayTypeInfo r100) {
        this.subPayInfo = r100;
    }

    public final void setTradeConfirmParams(CJPayTradeConfirmBizContentParams r100) {
        this.tradeConfirmParams = r100;
    }
}
