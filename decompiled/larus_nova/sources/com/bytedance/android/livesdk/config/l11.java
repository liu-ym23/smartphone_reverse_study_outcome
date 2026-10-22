package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/config/l11;", "", "", "live_audience_list_title", "Ljava/lang/String;", "live_audience_list_header_title", "live_audience_list_footer_title", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class l11 {

    @SerializedName("live_audience_list_footer_title")
    public String live_audience_list_footer_title;

    @SerializedName("live_audience_list_header_title")
    public String live_audience_list_header_title;

    @SerializedName("live_audience_list_title")
    public String live_audience_list_title;

    public l11() {
        this.live_audience_list_title = "在线观众";
        this.live_audience_list_header_title = "观众信息";
        this.live_audience_list_footer_title = "最多显示200名观众哦";
    }
}
