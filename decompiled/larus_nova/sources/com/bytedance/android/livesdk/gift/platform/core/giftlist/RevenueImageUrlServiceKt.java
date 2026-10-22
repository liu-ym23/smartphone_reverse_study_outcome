package com.bytedance.android.livesdk.gift.platform.core.giftlist;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes9.dex */
public final class RevenueImageUrlServiceKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f130577a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f130578b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f130579c = null;

    static {
        KProperty<?>[] r100 = {Reflection.property0(new PropertyReference0Impl(RevenueImageUrlServiceKt.class, "LIVE_REVENUE_RICH_CONTENT_IMAGE_OPT", "getLIVE_REVENUE_RICH_CONTENT_IMAGE_OPT()Lcom/bytedance/android/livesdk/gift/platform/core/giftlist/RevRichContentImageOpt;", 1))};
        f130577a = r100;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r101 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_revenue_rich_content_image_opt", new q(), q.class, false);
        f130578b = UltraSettingsManager.a().a(r101.f271017a, r101.f271018b, r101.getType(), r101.f271020d, r100[0]);
        f130579c = LazyKt.lazy(RevenueImageUrlServiceKt$richContentImageOpt$2.INSTANCE);
    }
}
