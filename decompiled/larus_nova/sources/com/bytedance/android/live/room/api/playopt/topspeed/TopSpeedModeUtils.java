package com.bytedance.android.live.room.api.playopt.topspeed;

import com.bytedance.android.live.room.api.playopt.topspeed.base.LivePrefStatus;
import com.bytedance.android.live.room.api.playopt.topspeed.base.LiveRiskStatus;
import com.bytedance.android.livesdkapi.service.IPerfBalanceService;
import com.bytedance.keva.Keva;
import fv1.f;
import java.util.Arrays;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes47.dex */
public final class TopSpeedModeUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f99073a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Keva f99074b = null;

    public static f d() {
        return (f) f99073a.getValue();
    }

    static {
        f99073a = LazyKt.lazy(TopSpeedModeUtils$topSpeedConfig$2.INSTANCE);
        f99074b = Keva.getRepo("topspeed_toast_store");
    }

    public static String c() {
        TopSpeedModeManager r100 = TopSpeedModeManager.f99061l;
        int r101 = r100.f99066e.f64752a.intValue();
        int r102 = r100.f99067f.f64752a.intValue();
        if (r101 != LivePrefStatus.PREF_NORMAL.getCode()) goto L9;
        if (r102 != LiveRiskStatus.HIGH_RISK.getCode()) goto L7;
        return "risk";
    L7:
        return "good";
    L9:
        if (r101 != LivePrefStatus.PREF_MEDIUM.getCode()) goto L12;
        return "not_good";
    L12:
        if (r101 != LivePrefStatus.PREF_SERIOUS.getCode()) goto L14;
        return "poor";
    L14:
        return "";
    }

    public static void f() {
        f99074b.storeString("topspeed_has_toast", "true," + System.currentTimeMillis());
    }

    public static boolean a() {
        return d().a();
    }

    public static boolean b() {
        if (d().a() == true) goto L5;
    L7:
        return false;
    L5:
        if (d().b() == false) goto L7;
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String e(int r110) {
        StringBuilder r100 = new StringBuilder();
        if (((Boolean) com.bytedance.android.live.room.api.playopt.base.a.f99056c.f64752a).booleanValue() == true) goto L5;
    L6:
        r110 = 0;
    L7:
        if (r110 != 0) goto L9;
        r100.append("开启后，关闭部分直播间功能和后台任务，改善设备卡顿、发热、耗电问题");
    L34:
        return r100.toString();
    L9:
        if (r110 != 1) goto L11;
        r100.append("生效中，正在为你优化性能...");
        goto L34
    L11:
        if (r110 != 2) goto L34;
        IPerfBalanceService r111 = (IPerfBalanceService) k.f(IPerfBalanceService.class);
        if (r111 == null) goto L16;
        r111.getHeartEffect();
    L16:
        float r101 = -1.0f;
        if (r111 == null) goto L19;
        float r102 = r111.getTimeEffect();
    L20:
        if (r111 == null) goto L22;
        r101 = r111.getSpeedEffect();
    L22:
        float r112 = 0;
        if (r102 <= r112) goto L25;
        StringBuilder r103 = new StringBuilder("手机续航增加 ");
        StringCompanionObject r104 = StringCompanionObject.INSTANCE;
        r103.append(String.format("%.1f", Arrays.copyOf(new Object[]{Float.valueOf(r102 * 100.0f)}, 1)));
        r103.append("%，");
        r100.append(r103.toString());
    L27:
        if (r101 <= r112) goto L29;
        StringBuilder r113 = new StringBuilder("速度提升");
        StringCompanionObject r105 = StringCompanionObject.INSTANCE;
        r113.append(String.format("%.1f", Arrays.copyOf(new Object[]{Float.valueOf(r101 * 100.0f)}, 1)));
        r113.append("%，");
        r100.append(r113.toString());
    L30:
        r100.append("温度恢复正常中");
        goto L34
    L29:
        r100.append("速度提升，");
        goto L30
    L25:
        r100.append("手机续航增加，");
        goto L27
    L19:
        r102 = -1.0f;
        goto L20
    L5:
        if (d().l() == true) goto L7;
        goto L6
    }
}
