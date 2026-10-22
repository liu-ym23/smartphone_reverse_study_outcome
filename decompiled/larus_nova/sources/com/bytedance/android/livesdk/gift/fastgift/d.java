package com.bytedance.android.livesdk.gift.fastgift;

import com.bytedance.android.livesdkapi.depend.model.LiveStartRoomOptConfig;
import com.bytedance.android.livesdkapi.depend.model.NewSendGiftConfig;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes9.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f126136a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f126137b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReadOnlyProperty f126138c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ReadOnlyProperty f126139d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ReadOnlyProperty f126140e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ReadOnlyProperty f126141f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ReadOnlyProperty f126142g = null;

    static {
        KProperty<?>[] r100 = {Reflection.property0(new PropertyReference0Impl(d.class, "LIVE_START_ROOM_OPT_SWITCH", "getLIVE_START_ROOM_OPT_SWITCH()Lcom/bytedance/android/livesdkapi/depend/model/LiveStartRoomOptConfig;", 1)), Reflection.property0(new PropertyReference0Impl(d.class, "LIVE_NEW_SEND_GIFT_BG_STYLE", "getLIVE_NEW_SEND_GIFT_BG_STYLE()Lcom/bytedance/android/livesdkapi/depend/model/NewSendGiftConfig;", 1)), Reflection.property0(new PropertyReference0Impl(d.class, "LIVE_HIDE_REMIND_WHEN_FAST_GIFT_PRICE_NOT_CHANGED", "getLIVE_HIDE_REMIND_WHEN_FAST_GIFT_PRICE_NOT_CHANGED()Z", 1)), Reflection.property0(new PropertyReference0Impl(d.class, "LIVE_GIFT_TOOLBAR_OPTIMIZE", "getLIVE_GIFT_TOOLBAR_OPTIMIZE()Z", 1)), Reflection.property0(new PropertyReference0Impl(d.class, "LIVE_FAST_GIFT_DIALOG_CONFIG", "getLIVE_FAST_GIFT_DIALOG_CONFIG()Lcom/bytedance/android/livesdk/gift/fastgift/config/FastGiftDialogConfig;", 1)), Reflection.property0(new PropertyReference0Impl(d.class, "GIFT_REPEAT_SEND_TIMEOUT", "getGIFT_REPEAT_SEND_TIMEOUT()I", 1))};
        f126136a = r100;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r101 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_start_room_opt_switch", new LiveStartRoomOptConfig(), LiveStartRoomOptConfig.class, false);
        f126137b = UltraSettingsManager.a().a(r101.f271017a, r101.f271018b, r101.getType(), r101.f271020d, r100[0]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r102 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_new_send_gift_bg_style", new NewSendGiftConfig(), NewSendGiftConfig.class, false);
        f126138c = UltraSettingsManager.a().a(r102.f271017a, r102.f271018b, r102.getType(), r102.f271020d, r100[1]);
        Boolean r103 = Boolean.FALSE;
        Class r104 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r105 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_hide_remind_when_fast_gift_price_not_changed", r103, r104, false);
        f126139d = UltraSettingsManager.a().a(r105.f271017a, r105.f271018b, r105.getType(), r105.f271020d, r100[2]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r106 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_toolbar_optimize", Boolean.TRUE, r104, false);
        f126140e = UltraSettingsManager.a().a(r106.f271017a, r106.f271018b, r106.getType(), r106.f271020d, r100[3]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r107 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_fast_gift_dialog_config", new ky1.a(), ky1.a.class, false);
        f126141f = UltraSettingsManager.a().a(r107.f271017a, r107.f271018b, r107.getType(), r107.f271020d, r100[4]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r108 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("gift_repeat_timeout", 3, Integer.TYPE, false);
        f126142g = UltraSettingsManager.a().a(r108.f271017a, r108.f271018b, r108.getType(), r108.f271020d, r100[5]);
    }

    public static final ky1.a a() {
        return (ky1.a) f126141f.getValue(null, f126136a[4]);
    }

    public static final LiveStartRoomOptConfig b() {
        return (LiveStartRoomOptConfig) f126137b.getValue(null, f126136a[0]);
    }
}
