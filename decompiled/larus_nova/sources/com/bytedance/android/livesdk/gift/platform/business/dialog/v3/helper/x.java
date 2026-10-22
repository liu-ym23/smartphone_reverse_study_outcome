package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes9.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f127484a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f127485b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReadOnlyProperty f127486c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static w f127487d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final x f127488e = null;

    static {
        KProperty<?>[] r100 = {Reflection.property1(new PropertyReference1Impl(x.class, "LIVE_GIFT_PANEL_ANYA_OPT", "getLIVE_GIFT_PANEL_ANYA_OPT()Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/helper/GiftPanelAnyaOptConfig;", 0)), Reflection.property1(new PropertyReference1Impl(x.class, "LIVE_GIFT_PANEL_VM_DELAY_DISPOSE", "getLIVE_GIFT_PANEL_VM_DELAY_DISPOSE()Z", 0))};
        f127484a = r100;
        x r101 = new x();
        f127488e = r101;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r102 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_panel_anya_opt", new w(), w.class, false);
        ReadOnlyProperty r103 = UltraSettingsManager.a().a(r102.f271017a, r102.f271018b, r102.getType(), r102.f271020d, r100[0]);
        f127485b = r103;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r104 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_panel_vm_delay_dispose", Boolean.TRUE, Boolean.TYPE, false);
        f127486c = UltraSettingsManager.a().a(r104.f271017a, r104.f271018b, r104.getType(), r104.f271020d, r100[1]);
        f127487d = (w) r103.getValue(r101, r100[0]);
    }

    public x() {
    }

    public static boolean a() {
        return f127487d.b();
    }
}
