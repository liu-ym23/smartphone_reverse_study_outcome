package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR \u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/LiveRadioGiftCommentWallConfig;", "", "()V", "launchSchema", "", "getLaunchSchema", "()Ljava/lang/String;", "setLaunchSchema", "(Ljava/lang/String;)V", "launchUrl", "getLaunchUrl", "setLaunchUrl", "textContainerSchema", "getTextContainerSchema", "setTextContainerSchema", "textContainerUrl", "getTextContainerUrl", "setTextContainerUrl", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LiveRadioGiftCommentWallConfig {

    @SerializedName("launch_schema")
    private String launchSchema;

    @SerializedName("launch_url")
    private String launchUrl;

    @SerializedName("text_container_schema")
    private String textContainerSchema;

    @SerializedName("text_container_url")
    private String textContainerUrl;

    public LiveRadioGiftCommentWallConfig() {
    }

    public final String getLaunchSchema() {
        return this.launchSchema;
    }

    public final String getLaunchUrl() {
        return this.launchUrl;
    }

    public final String getTextContainerSchema() {
        return this.textContainerSchema;
    }

    public final String getTextContainerUrl() {
        return this.textContainerUrl;
    }

    public final void setLaunchSchema(String r100) {
        this.launchSchema = r100;
    }

    public final void setLaunchUrl(String r100) {
        this.launchUrl = r100;
    }

    public final void setTextContainerSchema(String r100) {
        this.textContainerSchema = r100;
    }

    public final void setTextContainerUrl(String r100) {
        this.textContainerUrl = r100;
    }
}
