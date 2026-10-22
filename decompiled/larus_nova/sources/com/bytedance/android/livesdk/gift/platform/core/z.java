package com.bytedance.android.livesdk.gift.platform.core;

import com.bytedance.android.livesdk.config.LiveInitSettingKeys;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes9.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f132093a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f132094b = null;

    static {
        KProperty<?>[] r100 = {Reflection.property0(new PropertyReference0Impl(z.class, "ENABLE_ASSET_DOWNLOAD_INFO_LOG", "getENABLE_ASSET_DOWNLOAD_INFO_LOG()Z", 1))};
        f132093a = r100;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r101 = new com.bytedance.tools.kcp.ultrasettings.runtime.a(LiveInitSettingKeys.ENABLE_ASSET_DOWNLOAD_INFO_LOG, Boolean.FALSE, Boolean.TYPE, false);
        f132094b = UltraSettingsManager.a().a(r101.f271017a, r101.f271018b, r101.getType(), r101.f271020d, r100[0]);
    }

    public static final boolean a() {
        return ((Boolean) f132094b.getValue(null, f132093a[0])).booleanValue();
    }
}
