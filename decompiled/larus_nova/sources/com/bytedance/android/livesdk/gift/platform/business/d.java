package com.bytedance.android.livesdk.gift.platform.business;

import com.bytedance.live.kmp.core.KmpEnv;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes9.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f126573a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f126574b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReadOnlyProperty f126575c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ReadOnlyProperty f126576d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ReadOnlyProperty f126577e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ReadOnlyProperty f126578f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ReadOnlyProperty f126579g = null;

    static {
        KProperty<?>[] r100 = {Reflection.property0(new PropertyReference0Impl(d.class, "LIVE_RECHARGE_PATH_OPT", "getLIVE_RECHARGE_PATH_OPT()I", 1)), Reflection.property0(new PropertyReference0Impl(d.class, "LIVE_SEND_GIFT_CHECK_DIAMOND", "getLIVE_SEND_GIFT_CHECK_DIAMOND()Z", 1)), Reflection.property0(new PropertyReference0Impl(d.class, "VS_SEND_GIFT_FAIL_DIALOG_URL", "getVS_SEND_GIFT_FAIL_DIALOG_URL()Ljava/lang/String;", 1)), Reflection.property0(new PropertyReference0Impl(d.class, "SEND_GIFT_FAIL_DIALOG_URL", "getSEND_GIFT_FAIL_DIALOG_URL()Ljava/lang/String;", 1)), Reflection.property0(new PropertyReference0Impl(d.class, "SEND_GIFT_NOTFANS_DIALOG_ISOPEN", "getSEND_GIFT_NOTFANS_DIALOG_ISOPEN()Z", 1)), Reflection.property0(new PropertyReference0Impl(d.class, "GIFT_PANEL_INCOME_TO_COIN_OPTIMIZE", "getGIFT_PANEL_INCOME_TO_COIN_OPTIMIZE()Z", 1))};
        f126573a = r100;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r101 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_recharge_path_opt", 0, Integer.TYPE, false);
        f126574b = UltraSettingsManager.a().a(r101.f271017a, r101.f271018b, r101.getType(), r101.f271020d, r100[0]);
        Boolean r102 = Boolean.FALSE;
        Class r103 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r104 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_send_gift_check_diamond", r102, r103, false);
        f126575c = UltraSettingsManager.a().a(r104.f271017a, r104.f271018b, r104.getType(), r104.f271020d, r100[1]);
        KmpEnv r105 = KmpEnv.f255139a;
        if (KmpEnv.a() == false) goto L5;
        String r106 = "https://s3.bytecdn.cn/ies/live/webcast_lynx_douyin/h5/pages/fansclub_vs/popup/index.html";
    L6:
        com.bytedance.tools.kcp.ultrasettings.runtime.a r107 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("vs_send_gift_failed_not_fans_url", r106, String.class, false);
        f126576d = UltraSettingsManager.a().a(r107.f271017a, r107.f271018b, r107.getType(), r107.f271020d, r100[2]);
        if (KmpEnv.a() == false) goto L9;
        String r108 = "https://webcast.amemv.com/falcon/webcast_douyin/page/fansclub_2020/fansclub_popup/index.html";
    L10:
        com.bytedance.tools.kcp.ultrasettings.runtime.a r109 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("send_gift_failed_not_fans_url", r108, String.class, false);
        f126577e = UltraSettingsManager.a().a(r109.f271017a, r109.f271018b, r109.getType(), r109.f271020d, r100[3]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r110 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("send_gift_notfans_dialog_isopen", Boolean.TRUE, r103, false);
        f126578f = UltraSettingsManager.a().a(r110.f271017a, r110.f271018b, r110.getType(), r110.f271020d, r100[4]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r111 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("gift_panel_income_to_coin_optimize", r102, r103, false);
        f126579g = UltraSettingsManager.a().a(r111.f271017a, r111.f271018b, r111.getType(), r111.f271020d, r100[5]);
        return;
    L9:
        r108 = "https://webcast.huoshan.com/falcon/webcast_huoshan/page/fansclub_popup/index.html";
        goto L10
    L5:
        r106 = "https://s3.bytecdn.cn/ies/live/webcast_lynx_huoshan/h5/pages/fansclub_vs/popup/index.html";
        goto L6
    }
}
