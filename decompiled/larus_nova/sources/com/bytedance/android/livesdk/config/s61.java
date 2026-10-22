package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/config/s61;", "", "", "titleBindText", "Ljava/lang/String;", "getTitleBindText", "()Ljava/lang/String;", "titleUnBindText", "getTitleUnBindText", "subTitleBindText", "getSubTitleBindText", "subTitleUnBindText", "getSubTitleUnBindText", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class s61 {

    @SerializedName("sub_title_bind_text")
    private final String subTitleBindText;

    @SerializedName("sub_title_unbind_text")
    private final String subTitleUnBindText;

    @SerializedName("title_bind_text")
    private final String titleBindText;

    @SerializedName("title_unbind_text")
    private final String titleUnBindText;

    public s61() {
        this.titleBindText = "付费可看";
        this.titleUnBindText = "付费可看";
        this.subTitleBindText = "已绑定门票，本场直播观众需付费观看";
        this.subTitleUnBindText = "支持观众可试看，付费可观看完整直播";
    }
}
