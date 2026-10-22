package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b0\b\u0007\u0018\u00002\u00020\u0001B}\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003¢\u0006\u0002\u0010\u000fR\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00038\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u0016\u0010\u0019\u001a\u00020\u00038\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011R\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0011R\u0016\u0010\u001c\u001a\u00020\u00038\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0011R\u0016\u0010\u001e\u001a\u00020\u00038\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0011R\u0016\u0010 \u001a\u00020\u00038\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0011R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0011R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0011R\u0016\u0010$\u001a\u00020\u00038\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0011R\u0016\u0010\u000e\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0011R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0011R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0011R\u0016\u0010)\u001a\u00020\u00038\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0011R\u0016\u0010+\u001a\u00020\u00038\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0011R\u0016\u0010-\u001a\u00020\u00038\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u0011R\u0016\u0010/\u001a\u00020\u00038\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u0011R\u0016\u00101\u001a\u00020\u00038\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u0011¨\u00063"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/PlayerMonitorConfig;", "", "enableAppLog", "", "enableBlackScreenMonitor", "enableTrafficMonitor", "enableStallMonitor", "enableVqosLogger", "enableALogger", "enableExceptionLogger", "enableSpmLoggerLogger", "enableOuterLogger", "enable", "enableNpthLogger", "enableTraceLogger", "(ZZZZZZZZZZZZ)V", "getEnable", "()Z", "getEnableALogger", "getEnableAppLog", "getEnableBlackScreenMonitor", "enableDisplayModeReport", "getEnableDisplayModeReport", "getEnableExceptionLogger", "getEnableNpthLogger", "enableNpthLoggerV2", "getEnableNpthLoggerV2", "getEnableOuterLogger", "enableRenderMonitor", "getEnableRenderMonitor", "enableSeiLogger", "getEnableSeiLogger", "enableSeiParseReport", "getEnableSeiParseReport", "getEnableSpmLoggerLogger", "getEnableStallMonitor", "enableStreamInfoSlardar", "getEnableStreamInfoSlardar", "getEnableTraceLogger", "getEnableTrafficMonitor", "getEnableVqosLogger", "monitorListenersOpt", "getMonitorListenersOpt", "reportMuteCallStack", "getReportMuteCallStack", "reportMuteToTrace", "getReportMuteToTrace", "reportVideoCodec2", "getReportVideoCodec2", "vqosParamsCollect", "getVqosParamsCollect", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PlayerMonitorConfig {

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("enable_alogger")
    private final boolean enableALogger;

    @SerializedName("enable_app_log")
    private final boolean enableAppLog;

    @SerializedName("enable_black_screen_monitor")
    private final boolean enableBlackScreenMonitor;

    @SerializedName("enable_display_mode_report")
    private final boolean enableDisplayModeReport;

    @SerializedName("enable_exception_logger")
    private final boolean enableExceptionLogger;

    @SerializedName("enable_npth_logger")
    private final boolean enableNpthLogger;

    @SerializedName("enable_npth_logger_v2")
    private final boolean enableNpthLoggerV2;

    @SerializedName("enable_outer_logger")
    private final boolean enableOuterLogger;

    @SerializedName("enable_render_monitor")
    private final boolean enableRenderMonitor;

    @SerializedName("enable_sei_logger")
    private final boolean enableSeiLogger;

    @SerializedName("enable_sei_parse_report")
    private final boolean enableSeiParseReport;

    @SerializedName("enable_spmLogger_logger")
    private final boolean enableSpmLoggerLogger;

    @SerializedName("enable_stall_monitor")
    private final boolean enableStallMonitor;

    @SerializedName("enable_stream_info_for_slardar")
    private final boolean enableStreamInfoSlardar;

    @SerializedName("enable_trace_logger")
    private final boolean enableTraceLogger;

    @SerializedName("enable_traffic_monitor")
    private final boolean enableTrafficMonitor;

    @SerializedName("enable_vqos_logger")
    private final boolean enableVqosLogger;

    @SerializedName("monitor_listeners_opt")
    private final boolean monitorListenersOpt;

    @SerializedName("report_mute_call_stack")
    private final boolean reportMuteCallStack;

    @SerializedName("report_mute_to_trace")
    private final boolean reportMuteToTrace;

    @SerializedName("report_video_codec2")
    private final boolean reportVideoCodec2;

    @SerializedName("vqos_params_collect")
    private final boolean vqosParamsCollect;

    public PlayerMonitorConfig() {
        this(false, false, false, false, false, false, false, false, false, false, false, false, UnixStat.PERM_MASK, null);
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final boolean getEnableALogger() {
        return this.enableALogger;
    }

    public final boolean getEnableAppLog() {
        return this.enableAppLog;
    }

    public final boolean getEnableBlackScreenMonitor() {
        return this.enableBlackScreenMonitor;
    }

    public final boolean getEnableDisplayModeReport() {
        return this.enableDisplayModeReport;
    }

    public final boolean getEnableExceptionLogger() {
        return this.enableExceptionLogger;
    }

    public final boolean getEnableNpthLogger() {
        return this.enableNpthLogger;
    }

    public final boolean getEnableNpthLoggerV2() {
        return this.enableNpthLoggerV2;
    }

    public final boolean getEnableOuterLogger() {
        return this.enableOuterLogger;
    }

    public final boolean getEnableRenderMonitor() {
        return this.enableRenderMonitor;
    }

    public final boolean getEnableSeiLogger() {
        return this.enableSeiLogger;
    }

    public final boolean getEnableSeiParseReport() {
        return this.enableSeiParseReport;
    }

    public final boolean getEnableSpmLoggerLogger() {
        return this.enableSpmLoggerLogger;
    }

    public final boolean getEnableStallMonitor() {
        return this.enableStallMonitor;
    }

    public final boolean getEnableStreamInfoSlardar() {
        return this.enableStreamInfoSlardar;
    }

    public final boolean getEnableTraceLogger() {
        return this.enableTraceLogger;
    }

    public final boolean getEnableTrafficMonitor() {
        return this.enableTrafficMonitor;
    }

    public final boolean getEnableVqosLogger() {
        return this.enableVqosLogger;
    }

    public final boolean getMonitorListenersOpt() {
        return this.monitorListenersOpt;
    }

    public final boolean getReportMuteCallStack() {
        return this.reportMuteCallStack;
    }

    public final boolean getReportMuteToTrace() {
        return this.reportMuteToTrace;
    }

    public final boolean getReportVideoCodec2() {
        return this.reportVideoCodec2;
    }

    public final boolean getVqosParamsCollect() {
        return this.vqosParamsCollect;
    }

    public PlayerMonitorConfig(boolean r100, boolean r101, boolean r102, boolean r103, boolean r104, boolean r105, boolean r106, boolean r107, boolean r108, boolean r110, boolean r111, boolean r112) {
        this.enableAppLog = r100;
        this.enableBlackScreenMonitor = r101;
        this.enableTrafficMonitor = r102;
        this.enableStallMonitor = r103;
        this.enableVqosLogger = r104;
        this.enableALogger = r105;
        this.enableExceptionLogger = r106;
        this.enableSpmLoggerLogger = r107;
        this.enableOuterLogger = r108;
        this.enable = r110;
        this.enableNpthLogger = r111;
        this.enableTraceLogger = r112;
        this.vqosParamsCollect = true;
        this.reportMuteToTrace = true;
        this.monitorListenersOpt = true;
        this.enableSeiParseReport = true;
        this.enableDisplayModeReport = true;
    }

    public /* synthetic */ PlayerMonitorConfig(boolean r110, boolean r111, boolean r112, boolean r113, boolean r114, boolean r115, boolean r210, boolean r211, boolean r212, boolean r213, boolean r214, boolean r215, int r216, DefaultConstructorMarker r217) {
        boolean r100 = false;
        if ((r216 & 1) == 0) goto L5;
        boolean r101 = false;
    L7:
        if ((r216 & 2) == 0) goto L9;
        boolean r102 = false;
    L11:
        if ((r216 & 4) == 0) goto L13;
        boolean r103 = false;
    L15:
        if ((r216 & 8) == 0) goto L17;
        boolean r104 = false;
    L18:
        boolean r105 = true;
        if ((r216 & 16) == 0) goto L21;
        boolean r106 = true;
    L23:
        if ((r216 & 32) == 0) goto L25;
        boolean r107 = true;
    L27:
        if ((r216 & 64) == 0) goto L29;
        boolean r108 = true;
    L31:
        if ((r216 & 128) == 0) goto L33;
        boolean r116 = true;
    L35:
        if ((r216 & 256) == 0) goto L37;
        boolean r117 = true;
    L39:
        if ((r216 & 512) != 0) goto L43;
        r105 = r213;
    L43:
        if ((r216 & 1024) == 0) goto L45;
        boolean r118 = false;
    L47:
        if ((r216 & 2048) != 0) goto L50;
        r100 = r215;
    L50:
        this(r101, r102, r103, r104, r106, r107, r108, r116, r117, r105, r118, r100);
        return;
    L45:
        r118 = r214;
        goto L47
    L37:
        r117 = r212;
        goto L39
    L33:
        r116 = r211;
        goto L35
    L29:
        r108 = r210;
        goto L31
    L25:
        r107 = r115;
        goto L27
    L21:
        r106 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L18
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
