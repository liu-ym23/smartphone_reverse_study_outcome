package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u00020\t8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0016\u0010\u000e\u001a\u00020\t8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\t8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000bR\u0016\u0010\u0012\u001a\u00020\t8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000bR\u0016\u0010\u0014\u001a\u00020\t8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000bR\u0016\u0010\u0016\u001a\u00020\t8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000bR\u0016\u0010\u0018\u001a\u00020\t8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000bR\u0016\u0010\u001a\u001a\u00020\t8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u000bR\u0016\u0010\u001c\u001a\u00020\u001d8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010 \u001a\u00020\t8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u000bR\u0016\u0010\"\u001a\u00020\t8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u000bR\u0016\u0010$\u001a\u00020%8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0016\u0010(\u001a\u00020%8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b)\u0010'R\u0016\u0010*\u001a\u00020%8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b+\u0010'¨\u0006,"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/SurfaceControlHardwareBufferConfig;", "", "()V", "createScene", "", "", "getCreateScene", "()Ljava/util/List;", "disableHuaweiInJoyRun", "", "getDisableHuaweiInJoyRun", "()Z", "enable", "getEnable", "enableAvoidStall", "getEnableAvoidStall", "enableCheckCodecInfo", "getEnableCheckCodecInfo", "enableExceptionReport", "getEnableExceptionReport", "enableGlobalSurfaceControl", "getEnableGlobalSurfaceControl", "enableHardwareBufferOutput", "getEnableHardwareBufferOutput", "enableNotSupportReport", "getEnableNotSupportReport", "fixSurfaceCallback", "getFixSurfaceCallback", "forceResetDelay", "", "getForceResetDelay", "()J", "initSurfaceControlOpt", "getInitSurfaceControlOpt", "onlySupportSDR", "getOnlySupportSDR", "renderCount", "", "getRenderCount", "()I", "smoothRenderSolution", "getSmoothRenderSolution", "surfaceControlCacheSize", "getSurfaceControlCacheSize", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SurfaceControlHardwareBufferConfig {

    @SerializedName("create_scene")
    private final List<String> createScene;

    @SerializedName("disable_huawei_in_joy_run")
    private final boolean disableHuaweiInJoyRun;

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("enable_avoid_stall")
    private final boolean enableAvoidStall;

    @SerializedName("enable_check_codec_info")
    private final boolean enableCheckCodecInfo;

    @SerializedName("enable_exception_report")
    private final boolean enableExceptionReport;

    @SerializedName("enable_global_surface_control")
    private final boolean enableGlobalSurfaceControl;

    @SerializedName("enable_hardware_buffer_output")
    private final boolean enableHardwareBufferOutput;

    @SerializedName("enable_notsupport_report")
    private final boolean enableNotSupportReport;

    @SerializedName("fix_surface_render_callback")
    private final boolean fixSurfaceCallback;

    @SerializedName("force_reset_delay")
    private final long forceResetDelay;

    @SerializedName("init_surface_control_opt")
    private final boolean initSurfaceControlOpt;

    @SerializedName("only_support_sdr")
    private final boolean onlySupportSDR;

    @SerializedName("render_count")
    private final int renderCount;

    @SerializedName("smooth_render_solution")
    private final int smoothRenderSolution;

    @SerializedName("surface_control_cache_size")
    private final int surfaceControlCacheSize;

    public SurfaceControlHardwareBufferConfig() {
        this.smoothRenderSolution = 2;
        this.createScene = CollectionsKt.listOf("feed_preview");
        this.forceResetDelay = 1000;
        this.fixSurfaceCallback = true;
        this.renderCount = 1;
        this.enableExceptionReport = true;
        this.enableNotSupportReport = true;
        this.enableAvoidStall = true;
        this.enableCheckCodecInfo = true;
        this.onlySupportSDR = true;
        this.initSurfaceControlOpt = true;
        this.surfaceControlCacheSize = 3;
    }

    public final List<String> getCreateScene() {
        return this.createScene;
    }

    public final boolean getDisableHuaweiInJoyRun() {
        return this.disableHuaweiInJoyRun;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final boolean getEnableAvoidStall() {
        return this.enableAvoidStall;
    }

    public final boolean getEnableCheckCodecInfo() {
        return this.enableCheckCodecInfo;
    }

    public final boolean getEnableExceptionReport() {
        return this.enableExceptionReport;
    }

    public final boolean getEnableGlobalSurfaceControl() {
        return this.enableGlobalSurfaceControl;
    }

    public final boolean getEnableHardwareBufferOutput() {
        return this.enableHardwareBufferOutput;
    }

    public final boolean getEnableNotSupportReport() {
        return this.enableNotSupportReport;
    }

    public final boolean getFixSurfaceCallback() {
        return this.fixSurfaceCallback;
    }

    public final long getForceResetDelay() {
        return this.forceResetDelay;
    }

    public final boolean getInitSurfaceControlOpt() {
        return this.initSurfaceControlOpt;
    }

    public final boolean getOnlySupportSDR() {
        return this.onlySupportSDR;
    }

    public final int getRenderCount() {
        return this.renderCount;
    }

    public final int getSmoothRenderSolution() {
        return this.smoothRenderSolution;
    }

    public final int getSurfaceControlCacheSize() {
        return this.surfaceControlCacheSize;
    }
}
