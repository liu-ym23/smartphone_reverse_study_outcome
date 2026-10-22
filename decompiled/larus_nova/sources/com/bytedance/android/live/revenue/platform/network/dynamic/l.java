package com.bytedance.android.live.revenue.platform.network.dynamic;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f91529a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f91530b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReadOnlyProperty f91531c = null;

    static {
        KProperty<?>[] r100 = {Reflection.property0(new PropertyReference0Impl(l.class, "LIVE_KMP_REGISTER_MSG_DISPOSE_OPT", "getLIVE_KMP_REGISTER_MSG_DISPOSE_OPT()Z", 1)), Reflection.property0(new PropertyReference0Impl(l.class, "LIVE_AIO_REGISTER_MESSAGE_SUPPORT_BYTELINK", "getLIVE_AIO_REGISTER_MESSAGE_SUPPORT_BYTELINK()Z", 1))};
        f91529a = r100;
        Boolean r101 = Boolean.TRUE;
        Class r102 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r103 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_kmp_register_msg_dispose_opt", r101, r102, false);
        f91530b = UltraSettingsManager.a().a(r103.f271017a, r103.f271018b, r103.getType(), r103.f271020d, r100[0]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r104 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_aio_register_message_support_bytelink", r101, r102, false);
        f91531c = UltraSettingsManager.a().a(r104.f271017a, r104.f271018b, r104.getType(), r104.f271020d, r100[1]);
    }
}
