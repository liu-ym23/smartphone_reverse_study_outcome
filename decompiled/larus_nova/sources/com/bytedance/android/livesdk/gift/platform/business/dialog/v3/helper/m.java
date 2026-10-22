package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper;

import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ClickGiftPanelIcon;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.LongClickGiftPanelIcon;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.LongClickGiftPanelIconContinue;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.OnClickGiftPanelIconKeyUp;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.OnComboSingleClickStart;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.OnDialogFullyShowed;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.OnGiftComboCountDownFinish;
import com.bytedance.ee.bear.sheet.filter.FilterData;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.ranges.IntRange;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes9.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f127444a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f127445b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReadOnlyProperty f127446c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ReadOnlyProperty f127447d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ReadOnlyProperty f127448e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ReadOnlyProperty f127449f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ReadOnlyProperty f127450g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ReadOnlyProperty f127451h = null;

    static {
        KProperty<?>[] r100 = {Reflection.property0(new PropertyReference0Impl(m.class, "LiveGiftPanelDiffOptimizeSwitch", "getLiveGiftPanelDiffOptimizeSwitch()Z", 1)), Reflection.property0(new PropertyReference0Impl(m.class, "LiveAnyaMemoryLeakSwitch", "getLiveAnyaMemoryLeakSwitch()Z", 1)), Reflection.property0(new PropertyReference0Impl(m.class, "LiveAnyaUseIoScheduler", "getLiveAnyaUseIoScheduler()Z", 1)), Reflection.property0(new PropertyReference0Impl(m.class, "LiveAnyaViewModelMemoryLeakSwitch", "getLiveAnyaViewModelMemoryLeakSwitch()Z", 1)), Reflection.property0(new PropertyReference0Impl(m.class, "LiveAnyaComputingLayoutCrashFix", "getLiveAnyaComputingLayoutCrashFix()Z", 1)), Reflection.property0(new PropertyReference0Impl(m.class, "LiveAnyaFrequentALogOpt", "getLiveAnyaFrequentALogOpt()Z", 1)), Reflection.property0(new PropertyReference0Impl(m.class, "LiveAnyaMutateDeadLockAnrFix", "getLiveAnyaMutateDeadLockAnrFix()Z", 1))};
        f127444a = r100;
        Boolean r101 = Boolean.FALSE;
        Class r110 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r102 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_panel_diff_optimize_switch", r101, r110, false);
        f127445b = UltraSettingsManager.a().a(r102.f271017a, r102.f271018b, r102.getType(), r102.f271020d, r100[0]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r103 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_anya_memory_leak_switch", r101, r110, false);
        f127446c = UltraSettingsManager.a().a(r103.f271017a, r103.f271018b, r103.getType(), r103.f271020d, r100[1]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r104 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_anya_use_io_scheduler", r101, r110, false);
        f127447d = UltraSettingsManager.a().a(r104.f271017a, r104.f271018b, r104.getType(), r104.f271020d, r100[2]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r105 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_anya_view_model_memory_leak_switch", r101, r110, false);
        f127448e = UltraSettingsManager.a().a(r105.f271017a, r105.f271018b, r105.getType(), r105.f271020d, r100[3]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r106 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_anya_computing_layout_crash_fix", Boolean.TRUE, r110, false);
        f127449f = UltraSettingsManager.a().a(r106.f271017a, r106.f271018b, r106.getType(), r106.f271020d, r100[4]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r107 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_anya_frequent_alog_opt", r101, r110, false);
        f127450g = UltraSettingsManager.a().a(r107.f271017a, r107.f271018b, r107.getType(), r107.f271020d, r100[5]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r108 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_anya_mutate_dead_lock_anr_fix", r101, r110, false);
        f127451h = UltraSettingsManager.a().a(r108.f271017a, r108.f271018b, r108.getType(), r108.f271020d, r100[6]);
    }

    public static final boolean c(GiftAction r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isGiftListStateMachineAction");
        if ((r100 instanceof ClickGiftPanelIcon) == false) goto L5;
    L18:
        return true;
    L5:
        if ((r100 instanceof LongClickGiftPanelIcon) == true) goto L18;
        if ((r100 instanceof OnDialogFullyShowed) == true) goto L18;
        if ((r100 instanceof LongClickGiftPanelIconContinue) == true) goto L18;
        if ((r100 instanceof OnClickGiftPanelIconKeyUp) == true) goto L18;
        if ((r100 instanceof OnComboSingleClickStart) == true) goto L18;
        if ((r100 instanceof OnGiftComboCountDownFinish) == true) goto L18;
        return false;
    }

    public static final Set<Integer> a(IntRange r100, IntRange r101) {
        Intrinsics.checkNotNullParameter(r100, FilterData.FilterOptionItem.Type.RANGE);
        Intrinsics.checkNotNullParameter(r101, "rangeB");
        LinkedHashSet r102 = new LinkedHashSet();
        int r103 = r101.getFirst();
        int r104 = r101.getLast();
        if (r103 <= r104) goto L5;
    L10:
        int r105 = r100.getFirst();
        int r106 = r100.getLast();
        if (r105 <= r106) goto L13;
    L18:
        return r102;
    L13:
        if (r101.contains(r105) == true) goto L16;
        if (r105 == (-1)) goto L16;
        r102.add(Integer.valueOf(r105));
    L16:
        if (r105 == r106) goto L18;
        r105 = r105 + 1;
    L5:
        if (r100.contains(r103) == true) goto L8;
        if (r103 == (-1)) goto L8;
        r102.add(Integer.valueOf(r103));
    L8:
        if (r103 == r104) goto L10;
        r103 = r103 + 1;
        goto L5
    }

    public static final Set<Integer> b(IntRange r100, IntRange r101) {
        Intrinsics.checkNotNullParameter(r100, FilterData.FilterOptionItem.Type.RANGE);
        Intrinsics.checkNotNullParameter(r101, "rangeB");
        LinkedHashSet r102 = new LinkedHashSet();
        int r103 = r101.getFirst();
        int r104 = r101.getLast();
        if (r103 <= r104) goto L5;
    L9:
        return r102;
    L5:
        if (r100.contains(r103) == true) goto L7;
        r102.add(Integer.valueOf(r103));
    L7:
        if (r103 == r104) goto L9;
        r103 = r103 + 1;
        goto L5
    }
}
