package com.bytedance.android.live.wallet.model;

import com.bytedance.android.live.base.model.Extra;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.cert.manager.constants.EventConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u001aR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/live/wallet/model/MinorExtraJson;", "Lcom/bytedance/android/live/base/model/Extra;", "", "scene", "Ljava/lang/String;", "getScene", "()Ljava/lang/String;", "setScene", "(Ljava/lang/String;)V", BytedCertConstant.CertKey.FLOW, "getFlow", "setFlow", "ticket", "getTicket", "setTicket", "twoFactorAuthInfo", "getTwoFactorAuthInfo", "setTwoFactorAuthInfo", "Lcom/bytedance/android/live/wallet/model/j;", EventConstant.Key.RETAIN_PROMPT, "Lcom/bytedance/android/live/wallet/model/j;", "getPrompt", "()Lcom/bytedance/android/live/wallet/model/j;", "setPrompt", "(Lcom/bytedance/android/live/wallet/model/j;)V", "<init>", "()V", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MinorExtraJson extends Extra {

    @SerializedName(BytedCertConstant.CertKey.FLOW)
    private String flow;

    @SerializedName(EventConstant.Key.RETAIN_PROMPT)
    private j prompt;

    @SerializedName("scene")
    private String scene;

    @SerializedName("ticket")
    private String ticket;

    @SerializedName("two_factory_auth_info")
    private String twoFactorAuthInfo;

    public MinorExtraJson() {
    }

    public final String getFlow() {
        return this.flow;
    }

    public final j getPrompt() {
        return this.prompt;
    }

    public final String getScene() {
        return this.scene;
    }

    public final String getTicket() {
        return this.ticket;
    }

    public final String getTwoFactorAuthInfo() {
        return this.twoFactorAuthInfo;
    }

    public final void setFlow(String r100) {
        this.flow = r100;
    }

    public final void setPrompt(j r100) {
        this.prompt = r100;
    }

    public final void setScene(String r100) {
        this.scene = r100;
    }

    public final void setTicket(String r100) {
        this.ticket = r100;
    }

    public final void setTwoFactorAuthInfo(String r100) {
        this.twoFactorAuthInfo = r100;
    }
}
