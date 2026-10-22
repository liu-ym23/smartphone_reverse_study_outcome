package com.android.ttcjpaysdk.thirdparty.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/data/CJPayDoubleCheckVerifyInfo;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "()V", "error_message", "", "guideUrl", "needCertSign", "verifyId", "verifyRuleID", "verifyToken", "bdpay-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayDoubleCheckVerifyInfo implements CJPayObject {
    public String error_message;
    public String guideUrl;
    public String needCertSign;
    public String verifyId;
    public String verifyRuleID;
    public String verifyToken;

    public CJPayDoubleCheckVerifyInfo() {
        this.guideUrl = "";
        this.verifyId = "";
        this.verifyToken = "";
        this.verifyRuleID = "";
        this.error_message = "";
        this.needCertSign = "";
    }
}
