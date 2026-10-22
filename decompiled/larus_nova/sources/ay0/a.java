package ay0;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f16662a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f16663b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReadOnlyProperty f16664c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ReadOnlyProperty f16665d = null;

    static {
        KProperty<?>[] r100 = {Reflection.property0(new PropertyReference0Impl(a.class, "livePcAnchorInteractVideoMarginTop", "getLivePcAnchorInteractVideoMarginTop()F", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "liveSeiFrameCompare", "getLiveSeiFrameCompare()Z", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "liveVRPkCanvasRadioMode", "getLiveVRPkCanvasRadioMode()I", 1))};
        f16662a = r100;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r101 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pc_anchor_interact_video_margin_top", Float.valueOf(0.19f), Float.TYPE, false);
        f16663b = UltraSettingsManager.a().a(r101.f271017a, r101.f271018b, r101.getType(), r101.f271020d, r100[0]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r102 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_sei_frame_compare", Boolean.TRUE, Boolean.TYPE, false);
        f16664c = UltraSettingsManager.a().a(r102.f271017a, r102.f271018b, r102.getType(), r102.f271020d, r100[1]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r103 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_vr_pk_canvas_radio_mode", 0, Integer.TYPE, false);
        f16665d = UltraSettingsManager.a().a(r103.f271017a, r103.f271018b, r103.getType(), r103.f271020d, r100[2]);
    }

    public static final int a() {
        return ((Number) f16665d.getValue(null, f16662a[2])).intValue();
    }
}
