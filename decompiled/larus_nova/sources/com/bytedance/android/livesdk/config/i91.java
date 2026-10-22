package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b'\u0010(R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR2\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00190\u0018j\b\u0012\u0004\u0012\u00020\u0019`\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010!\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\u0004\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\"\u0010$\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010\u0004\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\b¨\u0006)"}, d2 = {"Lcom/bytedance/android/livesdk/config/i91;", "", "", "enable", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "setEnable", "(Z)V", "enableWidgetMonitor", "h", "setEnableWidgetMonitor", "enableInteractionMonitor", "c", "setEnableInteractionMonitor", "enableLog", "d", "setEnableLog", "enableAsyncLog", "b", "setEnableAsyncLog", "enableMetrics", "e", "setEnableMetrics", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "support_widget_metrics_list", "Ljava/util/ArrayList;", RXScreenCaptureService.KEY_INDEX, "()Ljava/util/ArrayList;", "setSupport_widget_metrics_list", "(Ljava/util/ArrayList;)V", "enableWidgetLifeCycleObserver", "f", "setEnableWidgetLifeCycleObserver", "enableWidgetLoadStateObserver", com.amap.api.col.s.ce.f26391f, "setEnableWidgetLoadStateObserver", "<init>", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class i91 {

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("enable_async_log")
    private boolean enableAsyncLog;

    @SerializedName("enable_interaction_monitor")
    private boolean enableInteractionMonitor;

    @SerializedName("enable_log")
    private boolean enableLog;

    @SerializedName("enable_metrics")
    private boolean enableMetrics;

    @SerializedName("enable_widget_lifecycle_observer")
    private boolean enableWidgetLifeCycleObserver;

    @SerializedName("enable_widget_load_state_observer")
    private boolean enableWidgetLoadStateObserver;

    @SerializedName("enable_widget_monitor")
    private boolean enableWidgetMonitor;

    @SerializedName("support_widget_metrics_list")
    private ArrayList<String> support_widget_metrics_list;

    public i91() {
        this.support_widget_metrics_list = new ArrayList();
    }

    public final boolean a() {
        return this.enable;
    }

    public final boolean b() {
        return this.enableAsyncLog;
    }

    public final boolean c() {
        return this.enableInteractionMonitor;
    }

    public final boolean d() {
        return this.enableLog;
    }

    public final boolean e() {
        return this.enableMetrics;
    }

    public final boolean f() {
        return this.enableWidgetLifeCycleObserver;
    }

    public final boolean g() {
        return this.enableWidgetLoadStateObserver;
    }

    public final boolean h() {
        return this.enableWidgetMonitor;
    }

    public final ArrayList<String> i() {
        return this.support_widget_metrics_list;
    }
}
