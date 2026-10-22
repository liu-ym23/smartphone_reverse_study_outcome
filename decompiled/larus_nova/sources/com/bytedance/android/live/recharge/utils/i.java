package com.bytedance.android.live.recharge.utils;

import com.bytedance.tools.kcp.spongepreference.runtime.SpongePreferenceManager;
import java.util.HashMap;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f90460a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f90461b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f90462c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f90463d = null;

    static {
        f90460a = new KProperty[]{Reflection.mutableProperty0(new MutablePropertyReference0Impl(i.class, "RECHARGE_APP_ASYNC_NOTICE", "getRECHARGE_APP_ASYNC_NOTICE()J", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(i.class, "LIVE_RECHARGE_SELECT_COMBINE_PAY", "getLIVE_RECHARGE_SELECT_COMBINE_PAY()Z", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(i.class, "LIVE_LAST_CUSTOM_RECHARGE_PRICE", "getLIVE_LAST_CUSTOM_RECHARGE_PRICE()Ljava/util/HashMap;", 1))};
        f90461b = SpongePreferenceManager.a().a("recharge_app_async_notice", 0L, Long.TYPE);
        f90462c = SpongePreferenceManager.a().a("live_recharge_select_combine_pay", Boolean.FALSE, Boolean.TYPE);
        f90463d = SpongePreferenceManager.a().a("live_last_custom_recharge_price", new HashMap(), tl3.a.f546615b);
    }
}
