package com.bytedance.android.livesdk.config;

import com.bytedance.android.shopping.slice.action.entity.SendClosePdpEventParam;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.downloadad.api.model.NativeDownloadModel;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\b¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/config/k71;", "", "", "lynxUrl", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "setLynxUrl", "(Ljava/lang/String;)V", NativeDownloadModel.JsonKey.WEB_URL, "c", "setWebUrl", "", "showDuration", "Ljava/lang/Long;", "b", "()Ljava/lang/Long;", "setShowDuration", "(Ljava/lang/Long;)V", "title", "getTitle", com.alipay.sdk.m.x.d.f25925o, "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class k71 {

    @SerializedName(SendClosePdpEventParam.KEY_LYNX_URL)
    private String lynxUrl;

    @SerializedName("show_duration")
    private Long showDuration;

    @SerializedName("title")
    private String title;

    @SerializedName("web_url")
    private String webUrl;

    public k71() {
        this.lynxUrl = "https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/mono/lynx/community_feedback_lynx_douyin/pages/live_discuss_feedback/template.js";
        this.webUrl = "";
        this.showDuration = 30L;
        this.title = "官方匿名问卷";
    }

    public final String a() {
        return this.lynxUrl;
    }

    public final Long b() {
        return this.showDuration;
    }

    public final String c() {
        return this.webUrl;
    }
}
