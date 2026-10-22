package com.bytedance.android.livehostapi.business.depend.share;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/share/CheckBoxConfig;", "", "()V", "imConfig", "Lcom/bytedance/android/livehostapi/business/depend/share/CheckBoxConfigParams;", "getImConfig", "()Lcom/bytedance/android/livehostapi/business/depend/share/CheckBoxConfigParams;", "tokenAlertConfig", "getTokenAlertConfig", "hostapp-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CheckBoxConfig {

    @SerializedName("im_config")
    private final CheckBoxConfigParams imConfig;

    @SerializedName("token_alert_config")
    private final CheckBoxConfigParams tokenAlertConfig;

    public CheckBoxConfig() {
    }

    public final CheckBoxConfigParams getImConfig() {
        return this.imConfig;
    }

    public final CheckBoxConfigParams getTokenAlertConfig() {
        return this.tokenAlertConfig;
    }
}
