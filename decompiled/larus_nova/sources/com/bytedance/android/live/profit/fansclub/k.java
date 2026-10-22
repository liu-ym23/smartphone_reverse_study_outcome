package com.bytedance.android.live.profit.fansclub;

import com.bytedance.live.kmp.core.KmpEnv;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f87321a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f87322b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReadOnlyProperty f87323c = null;

    static {
        KProperty<?>[] r100 = {Reflection.property0(new PropertyReference0Impl(k.class, "DH_LIVE_FANS_GROUP_URL", "getDH_LIVE_FANS_GROUP_URL()Ljava/lang/String;", 1)), Reflection.property0(new PropertyReference0Impl(k.class, "DH_LIVE_FANS_GROUP_ANCHOR_URL", "getDH_LIVE_FANS_GROUP_ANCHOR_URL()Ljava/lang/String;", 1))};
        f87321a = r100;
        KmpEnv r101 = KmpEnv.f255139a;
        if (KmpEnv.a() == false) goto L5;
        String r102 = "https://webcast.amemv.com/falcon/webcast_douyin/page/fansclub_2020/fansclub_user/index.html";
    L6:
        com.bytedance.tools.kcp.ultrasettings.runtime.a r103 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_fans_group_url", r102, String.class, false);
        f87322b = UltraSettingsManager.a().a(r103.f271017a, r103.f271018b, r103.getType(), r103.f271020d, r100[0]);
        if (KmpEnv.a() == false) goto L9;
        String r104 = "https://webcast.amemv.com/falcon/webcast_douyin/page/fansclub_2020/fansclub_anchor/index.html";
    L10:
        com.bytedance.tools.kcp.ultrasettings.runtime.a r105 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_fans_group_anchor_url", r104, String.class, false);
        f87323c = UltraSettingsManager.a().a(r105.f271017a, r105.f271018b, r105.getType(), r105.f271020d, r100[1]);
        return;
    L9:
        r104 = "https://webcast.huoshan.com/falcon/webcast_huoshan/page/fansclub_2020/fansclub_anchor/index.html";
        goto L10
    L5:
        r102 = "https://webcast.huoshan.com/falcon/webcast_huoshan/page/fansclub_2020/fansclub_user/index.html";
        goto L6
    }
}
