package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/config/h11;", "", "", "pvCountIntro", "Ljava/lang/String;", "getPvCountIntro", "()Ljava/lang/String;", "setPvCountIntro", "(Ljava/lang/String;)V", "pvCountUrl", "getPvCountUrl", "setPvCountUrl", "uvCountIntro", "getUvCountIntro", "setUvCountIntro", "uvCountUrl", "getUvCountUrl", "setUvCountUrl", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class h11 {

    @SerializedName("pv_count_intro")
    private String pvCountIntro;

    @SerializedName("pv_count_url")
    private String pvCountUrl;

    @SerializedName("uv_count_intro")
    private String uvCountIntro;

    @SerializedName("uv_count_url")
    private String uvCountUrl;

    public h11() {
        this.pvCountIntro = "选择「看播人数」后，直播间右上角位置将展示本场直播间累计看播人次，主播依然可以在左上角看到实时在线人数。";
        this.pvCountUrl = "https://tosv.byted.org/obj/webcast/ttlive_preview_choose_to_show_pv_count.png";
        this.uvCountIntro = "选择「在线人数」后，直播间右上角位置将展示实时在直播间内的用户数量，直播贡献榜前三名的用户头像将展示在右上方。";
        this.uvCountUrl = "https://tosv.byted.org/obj/webcast/ttlive_preview_choose_to_show_uv_count.png";
    }
}
