package com.android.ttcjpaysdk.outer.pay.bean;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/outer/pay/bean/CJPaySignInformation;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "logo_url", "", "merchant_name", "service_name", "sign_title", ILiveRoomPlayFragmentConstant.EXTRA_ENTER_TEMPLATE_ID, "outer-pay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPaySignInformation implements CJPayObject, Serializable {
    public String logo_url;
    public String merchant_name;
    public String service_name;
    public String sign_title;
    public String template_id;

    public CJPaySignInformation() {
        this.logo_url = "";
        this.sign_title = "";
        this.service_name = "";
        this.merchant_name = "";
        this.template_id = "";
    }
}
