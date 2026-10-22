package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/LiveChatRoomPanelBannerLynxConfig;", "", "()V", "bannerUrl", "", "getBannerUrl", "()Ljava/lang/String;", "setBannerUrl", "(Ljava/lang/String;)V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LiveChatRoomPanelBannerLynxConfig {

    @SerializedName("banner_url")
    private String bannerUrl;

    public LiveChatRoomPanelBannerLynxConfig() {
        this.bannerUrl = "";
    }

    public final String getBannerUrl() {
        return this.bannerUrl;
    }

    public final void setBannerUrl(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.bannerUrl = r100;
    }
}
