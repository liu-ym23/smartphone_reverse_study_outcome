package com.bytedance.android.shopping.dto;

import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.google.gson.annotations.SerializedName;
import com.ss.android.downloadad.api.model.NativeDownloadModel;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR&\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR \u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\b¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/shopping/dto/CommerceButton;", "Ljava/io/Serializable;", "()V", "openAppUrl", "", "getOpenAppUrl", "()Ljava/lang/String;", "setOpenAppUrl", "(Ljava/lang/String;)V", "smallAppUrl", "getSmallAppUrl", "setSmallAppUrl", "text", "", "getText", "()Ljava/util/List;", "setText", "(Ljava/util/List;)V", "toast", "getToast", "setToast", NativeDownloadModel.JsonKey.WEB_URL, "getWebUrl", "setWebUrl", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommerceButton implements Serializable {

    @SerializedName(PdpOpenThirdParam.KEY_OPEN_APP_URL)
    private String openAppUrl;

    @SerializedName("small_app_url")
    private String smallAppUrl;

    @SerializedName("text")
    private List<String> text;

    @SerializedName("toast")
    private String toast;

    @SerializedName("h5_url")
    private String webUrl;

    public CommerceButton() {
    }

    public final String getOpenAppUrl() {
        return this.openAppUrl;
    }

    public final String getSmallAppUrl() {
        return this.smallAppUrl;
    }

    public final List<String> getText() {
        return this.text;
    }

    public final String getToast() {
        return this.toast;
    }

    public final String getWebUrl() {
        return this.webUrl;
    }

    public final void setOpenAppUrl(String r100) {
        this.openAppUrl = r100;
    }

    public final void setSmallAppUrl(String r100) {
        this.smallAppUrl = r100;
    }

    public final void setText(List<String> r100) {
        this.text = r100;
    }

    public final void setToast(String r100) {
        this.toast = r100;
    }

    public final void setWebUrl(String r100) {
        this.webUrl = r100;
    }
}
