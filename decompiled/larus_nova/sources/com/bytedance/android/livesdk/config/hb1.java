package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/config/hb1;", "", "", "toolbarWaitingIconUrl", "Ljava/lang/String;", "getToolbarWaitingIconUrl", "()Ljava/lang/String;", "setToolbarWaitingIconUrl", "(Ljava/lang/String;)V", "toolbarCallingIconUrl", "getToolbarCallingIconUrl", "setToolbarCallingIconUrl", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class hb1 {

    @SerializedName("toolbar_calling_icon")
    private String toolbarCallingIconUrl;

    @SerializedName("toolbar_waiting_icon")
    private String toolbarWaitingIconUrl;

    public hb1() {
        this.toolbarWaitingIconUrl = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/link_toolbar_icon_waiting.webp";
        this.toolbarCallingIconUrl = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/link_toolbar_icon_matching.webp";
    }
}
