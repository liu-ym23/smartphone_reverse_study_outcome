package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes9.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f127286a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f127287b = null;

    static {
        KProperty<?>[] r100 = {Reflection.property0(new PropertyReference0Impl(e.class, "giftTabSelectStateCacheOptimize", "getGiftTabSelectStateCacheOptimize()Z", 1))};
        f127286a = r100;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r101 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("gift_tab_select_state_cache_optimize", Boolean.TRUE, Boolean.TYPE, false);
        f127287b = UltraSettingsManager.a().a(r101.f271017a, r101.f271018b, r101.getType(), r101.f271020d, r100[0]);
    }
}
