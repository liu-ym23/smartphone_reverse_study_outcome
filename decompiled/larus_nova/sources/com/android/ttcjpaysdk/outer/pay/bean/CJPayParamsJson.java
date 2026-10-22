package com.android.ttcjpaysdk.outer.pay.bean;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.ss.android.dypay.api.DyPayConstant;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/android/ttcjpaysdk/outer/pay/bean/CJPayParamsJson;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "appid", "", DyPayConstant.K_PAY_INFO_PARAM_PARTNERID, DyPayConstant.K_PAY_INFO_PARAM_PREPAYID, "outer-pay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayParamsJson implements CJPayObject, Serializable {
    public String appid;
    public String partnerid;
    public String prepayid;

    public CJPayParamsJson() {
        this.appid = "";
        this.prepayid = "";
        this.partnerid = "";
    }
}
