package com.bytedance.android.livesdk.gift.platform.business;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes9.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f126564a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f126565b = null;

    static {
        KProperty<?>[] r100 = {Reflection.property0(new PropertyReference0Impl(c.class, "LIVE_FORMAT_SEND_GIFT_PRE_CHECK_BALANCE", "getLIVE_FORMAT_SEND_GIFT_PRE_CHECK_BALANCE()Z", 1))};
        f126564a = r100;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r101 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_format_send_gift_pre_check_balance", Boolean.TRUE, Boolean.TYPE, false);
        f126565b = UltraSettingsManager.a().a(r101.f271017a, r101.f271018b, r101.getType(), r101.f271020d, r100[0]);
    }
}
