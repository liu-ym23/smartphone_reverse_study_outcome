package com.bytedance.android.live.revlink.impl.config;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d;
import com.google.gson.annotations.SerializedName;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import kotlin.Metadata;
import r11.e;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001:B\u0007¢\u0006\u0004\b8\u00109R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001a\u0010\u000f\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\u001a\u0010\u0011\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u001a\u0010\u0014\u001a\u00020\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017R\u001a\u0010\u001b\u001a\u00020\u001a8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u0015\u001a\u0004\b \u0010\u0017R\u001a\u0010!\u001a\u00020\u001a8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\u001c\u001a\u0004\b\"\u0010\u001eR\u001a\u0010#\u001a\u00020\u001a8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010\u001c\u001a\u0004\b$\u0010\u001eR\u001a\u0010%\u001a\u00020\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010\u0015\u001a\u0004\b&\u0010\u0017R\u001a\u0010'\u001a\u00020\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b'\u0010\u0015\u001a\u0004\b(\u0010\u0017R\u001a\u0010*\u001a\u00020)8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u001a\u0010/\u001a\u00020.8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u001a\u00104\u001a\u0002038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107¨\u0006;"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/config/LinkPerformanceSettingSerializableObjectImpl;", "Lr11/e;", "", "enable", "Z", "getEnable", "()Z", "degradeEnable", "V6", "isForceDegrade", DoraObricDeviceHomeViewModel.PRODUCT_CODE_G2, "basedDegradeEnable", "b3", "mixDegradeEnable", "a6", "effectDegradeEnable", "L0", "imDegradeEnable", "J7", "", "monitorDelay", "J", FaceService.neutralLabel, "()J", "foreMonitorDelay", "g9", "", "cpuThreshold", FaceService.girlLabel, "w1", "()F", "memThreshold", "Y6", "fpsThreshold", "B1", "uiFpsThreshold", ExifInterface.LONGITUDE_WEST, "reportSampleCountAudience", "W5", "reportSampleCountAnchor", "C3", "Lr11/e$c;", "residentConfig", "Lr11/e$c;", "c9", "()Lr11/e$c;", "Lr11/e$b;", "foreConConfig", "Lr11/e$b;", "m4", "()Lr11/e$b;", "Lr11/e$d;", "sceneConfig", "Lr11/e$d;", "M", "()Lr11/e$d;", "<init>", "()V", "Adapter", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkPerformanceSettingSerializableObjectImpl implements e {

    @SerializedName("base_degrade_enable")
    private final boolean basedDegradeEnable;

    @SerializedName("cpu_threshold")
    private final float cpuThreshold;

    @SerializedName("degrade_enable")
    private final boolean degradeEnable;

    @SerializedName("effect_degrade_enable")
    private final boolean effectDegradeEnable;

    @SerializedName("feature_enable")
    private final boolean enable;

    @SerializedName("fore_con_config")
    private final e.b foreConConfig;

    @SerializedName("fore_monitor_delay")
    private final long foreMonitorDelay;

    @SerializedName("fps_threshold")
    private final float fpsThreshold;

    @SerializedName("im_degrade_enable")
    private final boolean imDegradeEnable;

    @SerializedName("force_degrade_enable")
    private final boolean isForceDegrade;

    @SerializedName("mem_threshold")
    private final long memThreshold;

    @SerializedName("mix_degrade_enable")
    private final boolean mixDegradeEnable;

    @SerializedName("monitor_delay")
    private final long monitorDelay;

    @SerializedName("report_sample_count_anchor")
    private final long reportSampleCountAnchor;

    @SerializedName("report_sample_count_audience")
    private final long reportSampleCountAudience;

    @SerializedName("resident_config")
    private final e.c residentConfig;

    @SerializedName("scene_config")
    private final e.d sceneConfig;

    @SerializedName("ui_fps_threshold")
    private final float uiFpsThreshold;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/config/LinkPerformanceSettingSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(LinkPerformanceSettingSerializableObjectImpl.class);
        }
    }

    public LinkPerformanceSettingSerializableObjectImpl() {
        this.enable = false;
        this.degradeEnable = false;
        this.isForceDegrade = false;
        this.basedDegradeEnable = false;
        this.mixDegradeEnable = false;
        this.effectDegradeEnable = false;
        this.imDegradeEnable = false;
        this.monitorDelay = 1000;
        this.foreMonitorDelay = 200;
        this.cpuThreshold = 0.35f;
        this.memThreshold = 1750;
        this.fpsThreshold = 10.0f;
        this.uiFpsThreshold = 50.0f;
        this.reportSampleCountAudience = 0;
        this.reportSampleCountAnchor = 0;
        this.residentConfig = (e.c) d.c(e.c.class);
        this.foreConConfig = (e.b) d.c(e.b.class);
        this.sceneConfig = (e.d) d.c(e.d.class);
    }

    @Override // r11.e
    public final float B1() {
        return this.fpsThreshold;
    }

    @Override // r11.e
    public final long C3() {
        return this.reportSampleCountAnchor;
    }

    @Override // r11.e
    public final long H() {
        return this.monitorDelay;
    }

    @Override // r11.e
    public final boolean J7() {
        return this.imDegradeEnable;
    }

    @Override // r11.e
    public final boolean L0() {
        return this.effectDegradeEnable;
    }

    @Override // r11.e
    public final e.d M() {
        return this.sceneConfig;
    }

    @Override // r11.e
    public final boolean V6() {
        return this.degradeEnable;
    }

    @Override // r11.e
    public final float W() {
        return this.uiFpsThreshold;
    }

    @Override // r11.e
    public final long W5() {
        return this.reportSampleCountAudience;
    }

    @Override // r11.e
    public final long Y6() {
        return this.memThreshold;
    }

    @Override // r11.e
    public final boolean a6() {
        return this.mixDegradeEnable;
    }

    @Override // r11.e
    public final boolean b3() {
        return this.basedDegradeEnable;
    }

    @Override // r11.e
    public final e.c c9() {
        return this.residentConfig;
    }

    @Override // r11.e
    public final boolean g2() {
        return this.isForceDegrade;
    }

    @Override // r11.e
    public final long g9() {
        return this.foreMonitorDelay;
    }

    @Override // r11.e
    public final boolean getEnable() {
        return this.enable;
    }

    @Override // r11.e
    public final e.b m4() {
        return this.foreConConfig;
    }

    @Override // r11.e
    public final float w1() {
        return this.cpuThreshold;
    }
}
