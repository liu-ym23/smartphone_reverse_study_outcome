package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001b\u0010\u001cR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR(\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdk/config/u2;", "", "", "enable", "Z", "b", "()Z", "setEnable", "(Z)V", "", "watchTimeThreshold", "J", "getWatchTimeThreshold", "()J", "setWatchTimeThreshold", "(J)V", "popupFrequency", "getPopupFrequency", "setPopupFrequency", "", "", "desktopWidgetEnterPatterns", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "setDesktopWidgetEnterPatterns", "(Ljava/util/List;)V", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class u2 {

    @SerializedName("desktop_widget_enter_patterns")
    private List<String> desktopWidgetEnterPatterns;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("guide_popup_frequency")
    private long popupFrequency;

    @SerializedName("guide_popup_watch_time_threshold")
    private long watchTimeThreshold;

    public u2() {
        this.watchTimeThreshold = 600;
        this.popupFrequency = 7;
        this.desktopWidgetEnterPatterns = CollectionsKt.listOf("click_desktop_widget+live_cover");
    }

    public final List<String> a() {
        return this.desktopWidgetEnterPatterns;
    }

    public final boolean b() {
        return this.enable;
    }
}
