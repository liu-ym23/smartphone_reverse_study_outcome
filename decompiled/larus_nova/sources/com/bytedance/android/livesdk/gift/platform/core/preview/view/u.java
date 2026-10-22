package com.bytedance.android.livesdk.gift.platform.core.preview.view;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes9.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f131114a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f131115b = null;

    static {
        KProperty<?>[] r100 = {Reflection.property0(new PropertyReference0Impl(u.class, "LIVE_UGC_GIFT_TOP_NOTICE", "getLIVE_UGC_GIFT_TOP_NOTICE()Ljava/lang/String;", 1))};
        f131114a = r100;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r101 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_ugc_gift_top_notice", "点击“置顶”，可置顶你喜欢的礼物", String.class, false);
        f131115b = UltraSettingsManager.a().a(r101.f271017a, r101.f271018b, r101.getType(), r101.f271020d, r100[0]);
    }
}
