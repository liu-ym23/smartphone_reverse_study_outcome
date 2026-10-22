package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b*\u0010+R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR$\u0010\u0016\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR*\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R*\u0010!\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\u001c\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 R*\u0010$\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010\u001c\u001a\u0004\b%\u0010\u001e\"\u0004\b&\u0010 R*\u0010'\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010\u001c\u001a\u0004\b(\u0010\u001e\"\u0004\b)\u0010 ¨\u0006,"}, d2 = {"Lcom/bytedance/android/livesdk/config/i71;", "", "", "widgetLoadWithPriorityEnable", "Ljava/lang/Boolean;", "getWidgetLoadWithPriorityEnable", "()Ljava/lang/Boolean;", "setWidgetLoadWithPriorityEnable", "(Ljava/lang/Boolean;)V", "", "p0LoadTimeout", "Ljava/lang/Long;", "getP0LoadTimeout", "()Ljava/lang/Long;", "setP0LoadTimeout", "(Ljava/lang/Long;)V", "pOtherLoadTimeout", "getPOtherLoadTimeout", "setPOtherLoadTimeout", "doAfterP0LoadedTime", "getDoAfterP0LoadedTime", "setDoAfterP0LoadedTime", "doAfterPOtherLoadedTime", "getDoAfterPOtherLoadedTime", "setDoAfterPOtherLoadedTime", "", "", "p0WidgetList", "Ljava/util/List;", "getP0WidgetList", "()Ljava/util/List;", "setP0WidgetList", "(Ljava/util/List;)V", "pOtherWidgetList", "getPOtherWidgetList", "setPOtherWidgetList", "mediaP0WidgetList", "getMediaP0WidgetList", "setMediaP0WidgetList", "mediaPOtherWidgetList", "getMediaPOtherWidgetList", "setMediaPOtherWidgetList", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class i71 {

    @SerializedName("do_after_p0_loaded_time")
    private Long doAfterP0LoadedTime;

    @SerializedName("do_after_pOther_loaded_time")
    private Long doAfterPOtherLoadedTime;

    @SerializedName("media_p0_widget_list")
    private List<String> mediaP0WidgetList;

    @SerializedName("media_pOther_widget_list")
    private List<String> mediaPOtherWidgetList;

    @SerializedName("p0_load_timeout")
    private Long p0LoadTimeout;

    @SerializedName("p0_widget_list")
    private List<String> p0WidgetList;

    @SerializedName("pOther_load_timeout")
    private Long pOtherLoadTimeout;

    @SerializedName("pOther_widget_list")
    private List<String> pOtherWidgetList;

    @SerializedName("widget_load_with_priority_enable")
    private Boolean widgetLoadWithPriorityEnable;

    public i71() {
        this.widgetLoadWithPriorityEnable = Boolean.TRUE;
        this.p0LoadTimeout = 500L;
        this.pOtherLoadTimeout = 500L;
        this.doAfterP0LoadedTime = 200L;
        this.doAfterPOtherLoadedTime = 0L;
    }
}
