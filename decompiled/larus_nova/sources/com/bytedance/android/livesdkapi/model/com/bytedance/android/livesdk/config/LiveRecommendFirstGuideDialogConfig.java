package com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR \u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/LiveRecommendFirstGuideDialogConfig;", "", "()V", "buttonText", "", "getButtonText", "()Ljava/lang/String;", "setButtonText", "(Ljava/lang/String;)V", "descText", "getDescText", "setDescText", "imageUrl", "getImageUrl", "setImageUrl", "titleText", "getTitleText", "setTitleText", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveRecommendFirstGuideDialogConfig {

    @SerializedName("button_text")
    private String buttonText;

    @SerializedName("desc_text")
    private String descText;

    @SerializedName("image_url")
    private String imageUrl;

    @SerializedName("title_text")
    private String titleText;

    public LiveRecommendFirstGuideDialogConfig() {
    }

    public final String getButtonText() {
        return this.buttonText;
    }

    public final String getDescText() {
        return this.descText;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final String getTitleText() {
        return this.titleText;
    }

    public final void setButtonText(String r100) {
        this.buttonText = r100;
    }

    public final void setDescText(String r100) {
        this.descText = r100;
    }

    public final void setImageUrl(String r100) {
        this.imageUrl = r100;
    }

    public final void setTitleText(String r100) {
        this.titleText = r100;
    }
}
