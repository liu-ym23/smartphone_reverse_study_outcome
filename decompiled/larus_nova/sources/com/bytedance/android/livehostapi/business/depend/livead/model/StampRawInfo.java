package com.bytedance.android.livehostapi.business.depend.livead.model;

import com.alipay.sdk.m.x.d;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001e\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001e\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001e\u0010\u0015\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/livead/model/StampRawInfo;", "", "()V", "customizeCoverUri", "", "getCustomizeCoverUri", "()Ljava/lang/String;", "setCustomizeCoverUri", "(Ljava/lang/String;)V", "id", "getId", "setId", "screenShotUri", "getScreenShotUri", "setScreenShotUri", "startPageUrl", "getStartPageUrl", "setStartPageUrl", "title", "getTitle", d.f25925o, "type", "", "getType", "()J", "setType", "(J)V", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class StampRawInfo {

    @SerializedName("customized_cover_uri")
    private String customizeCoverUri;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private String f102930id;

    @SerializedName("screen_shot_uri")
    private String screenShotUri;

    @SerializedName("start_page_url")
    private String startPageUrl;

    @SerializedName("title")
    private String title;

    @SerializedName("type")
    private long type;

    public StampRawInfo() {
        this.f102930id = "";
        this.title = "";
        this.screenShotUri = "";
        this.startPageUrl = "";
        this.customizeCoverUri = "";
    }

    public final String getCustomizeCoverUri() {
        return this.customizeCoverUri;
    }

    public final String getId() {
        return this.f102930id;
    }

    public final String getScreenShotUri() {
        return this.screenShotUri;
    }

    public final String getStartPageUrl() {
        return this.startPageUrl;
    }

    public final String getTitle() {
        return this.title;
    }

    public final long getType() {
        return this.type;
    }

    public final void setCustomizeCoverUri(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.customizeCoverUri = r100;
    }

    public final void setId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f102930id = r100;
    }

    public final void setScreenShotUri(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.screenShotUri = r100;
    }

    public final void setStartPageUrl(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.startPageUrl = r100;
    }

    public final void setTitle(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.title = r100;
    }

    public final void setType(long r100) {
        this.type = r100;
    }
}
