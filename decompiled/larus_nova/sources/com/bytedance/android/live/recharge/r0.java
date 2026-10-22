package com.bytedance.android.live.recharge;

import com.bytedance.tools.kcp.spongepreference.runtime.SpongePreferenceManager;
import java.util.HashMap;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f90340a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f90341b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f90342c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f90343d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f90344e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f90345f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f90346g = null;

    static {
        f90340a = new KProperty[]{Reflection.mutableProperty0(new MutablePropertyReference0Impl(r0.class, "LIVE_RECHARGE_NOTICE_FREQUENCY", "getLIVE_RECHARGE_NOTICE_FREQUENCY()Ljava/util/HashMap;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(r0.class, "LIVE_RECHARGE_DIAMOND_API_CACHE", "getLIVE_RECHARGE_DIAMOND_API_CACHE()Ljava/util/HashMap;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(r0.class, "LIVE_RECHARGE_DIAMOND_API_CACHE_DISABLE", "getLIVE_RECHARGE_DIAMOND_API_CACHE_DISABLE()Z", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(r0.class, "LIVE_RECHARGE_PREFETCH_DIAMOND_TIME", "getLIVE_RECHARGE_PREFETCH_DIAMOND_TIME()Ljava/util/HashMap;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(r0.class, "LIVE_RECHARGE_BANNER_VALID_TIME", "getLIVE_RECHARGE_BANNER_VALID_TIME()J", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(r0.class, "LIVE_RECHARGE_BANNER_LAST_HEIGHT", "getLIVE_RECHARGE_BANNER_LAST_HEIGHT()I", 1))};
        f90341b = SpongePreferenceManager.a().a("live_recharge_notice_frequency_new", new HashMap(), tl3.a.f546614a);
        f90342c = SpongePreferenceManager.a().a("live_recharge_diamond_api_cache_map", new HashMap(), tl3.a.f546619f);
        f90343d = SpongePreferenceManager.a().a("live_recharge_diamond_api_cache_disable", Boolean.FALSE, Boolean.TYPE);
        f90344e = SpongePreferenceManager.a().a("live_recharge_prefetch_diamond_time", new HashMap(), tl3.a.f546620g);
        f90345f = SpongePreferenceManager.a().a("live_recharge_banner_valid_time", 0L, Long.TYPE);
        f90346g = SpongePreferenceManager.a().a("live_recharge_banner_last_height", 0, Integer.TYPE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final HashMap<String, String> a() {
        return (HashMap) f90342c.getValue(null, f90340a[1]);
    }
}
