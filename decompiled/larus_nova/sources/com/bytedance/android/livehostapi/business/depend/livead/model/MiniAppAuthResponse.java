package com.bytedance.android.livehostapi.business.depend.livead.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\u0016\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/livead/model/MiniAppAuthResponse;", "", "()V", "anchorType", "", "getAnchorType", "()Ljava/lang/Integer;", "setAnchorType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "authName", "", "getAuthName", "()Ljava/lang/String;", "setAuthName", "(Ljava/lang/String;)V", "canChange", "", "getCanChange", "()Z", "setCanChange", "(Z)V", "extra", "getExtra", "setExtra", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MiniAppAuthResponse {

    @SerializedName("type")
    private Integer anchorType;

    @SerializedName("auth_name")
    private String authName;

    @SerializedName("can_change")
    private boolean canChange;

    @SerializedName("extra")
    private String extra;

    public MiniAppAuthResponse() {
    }

    public final Integer getAnchorType() {
        return this.anchorType;
    }

    public final String getAuthName() {
        return this.authName;
    }

    public final boolean getCanChange() {
        return this.canChange;
    }

    public final String getExtra() {
        return this.extra;
    }

    public final void setAnchorType(Integer r100) {
        this.anchorType = r100;
    }

    public final void setAuthName(String r100) {
        this.authName = r100;
    }

    public final void setCanChange(boolean r100) {
        this.canChange = r100;
    }

    public final void setExtra(String r100) {
        this.extra = r100;
    }
}
