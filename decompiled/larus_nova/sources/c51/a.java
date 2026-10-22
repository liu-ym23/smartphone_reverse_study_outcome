package c51;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f22461a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f22462b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReadOnlyProperty f22463c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ReadOnlyProperty f22464d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ReadOnlyProperty f22465e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ReadOnlyProperty f22466f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ReadOnlyProperty f22467g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f22468h = null;

    static {
        KProperty<?>[] r100 = {Reflection.property1(new PropertyReference1Impl(a.class, "livePkPeakPeriodBeginTime", "getLivePkPeakPeriodBeginTime()Ljava/lang/String;", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "livePkPeakPeriodEndTime", "getLivePkPeakPeriodEndTime()Ljava/lang/String;", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "livePkPeakPeriodAdjustDurationTopTip", "getLivePkPeakPeriodAdjustDurationTopTip()Ljava/lang/String;", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "livePkPeakPeriodAutoAdjustDurationEnable", "getLivePkPeakPeriodAutoAdjustDurationEnable()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "livePkPeakPeriodAutoAdjustDurationOnceForAll", "getLivePkPeakPeriodAutoAdjustDurationOnceForAll()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "livePkDisconnectToastCountControl", "getLivePkDisconnectToastCountControl()I", 0))};
        f22461a = r100;
        f22468h = new a();
        com.bytedance.tools.kcp.ultrasettings.runtime.a r101 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_peak_period_begin_time", "20:00:00", String.class, false);
        f22462b = UltraSettingsManager.a().a(r101.f271017a, r101.f271018b, r101.getType(), r101.f271020d, r100[0]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r102 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_peak_period_end_time", "22:00:00", String.class, false);
        f22463c = UltraSettingsManager.a().a(r102.f271017a, r102.f271018b, r102.getType(), r102.f271020d, r100[1]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r103 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_peak_period_adjust_duration_top_tip", "20~22点仅可PK2次，默认10分钟，可手动改回", String.class, false);
        f22464d = UltraSettingsManager.a().a(r103.f271017a, r103.f271018b, r103.getType(), r103.f271020d, r100[2]);
        Boolean r104 = Boolean.TRUE;
        Class r105 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r106 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_peak_period_auto_adjust_duration_enable", r104, r105, false);
        f22465e = UltraSettingsManager.a().a(r106.f271017a, r106.f271018b, r106.getType(), r106.f271020d, r100[3]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r107 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_peak_period_auto_adjust_duration_once_for_all", Boolean.FALSE, r105, false);
        f22466f = UltraSettingsManager.a().a(r107.f271017a, r107.f271018b, r107.getType(), r107.f271020d, r100[4]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r108 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_disconnect_toast_count_control", 3, Integer.TYPE, false);
        f22467g = UltraSettingsManager.a().a(r108.f271017a, r108.f271018b, r108.getType(), r108.f271020d, r100[5]);
    }

    public a() {
    }

    public final boolean a() {
        return ((Boolean) f22466f.getValue(this, f22461a[4])).booleanValue();
    }
}
