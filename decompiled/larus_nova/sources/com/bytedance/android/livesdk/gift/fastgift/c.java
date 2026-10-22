package com.bytedance.android.livesdk.gift.fastgift;

import com.bytedance.tools.kcp.spongepreference.runtime.SpongePreferenceManager;
import java.util.HashMap;
import java.util.HashSet;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes9.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f126128a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f126129b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f126130c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f126131d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f126132e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f126133f = null;

    static {
        f126128a = new KProperty[]{Reflection.mutableProperty0(new MutablePropertyReference0Impl(c.class, "FAST_GIFT_ERROR_CONFIRM_NEXT_CHECK", "getFAST_GIFT_ERROR_CONFIRM_NEXT_CHECK()Z", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(c.class, "FAST_GIFT_HIDE_CONFIRM_GIFT_DATE", "getFAST_GIFT_HIDE_CONFIRM_GIFT_DATE()Ljava/util/HashMap;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(c.class, "FAST_GIFT_HIDE_CONFIRM_GIFT_BY_PRICE", "getFAST_GIFT_HIDE_CONFIRM_GIFT_BY_PRICE()Ljava/util/HashSet;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(c.class, "FAST_GIFT_HIDE_CONFIRM_GIFT_BY_ID", "getFAST_GIFT_HIDE_CONFIRM_GIFT_BY_ID()Ljava/util/HashSet;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(c.class, "DAY_OF_EXCLUSIVE_POP_UP_GIFT_SHOWN", "getDAY_OF_EXCLUSIVE_POP_UP_GIFT_SHOWN()Ljava/util/HashMap;", 1))};
        f126129b = SpongePreferenceManager.a().a("fast_gift_error_confirm_next_check", Boolean.FALSE, Boolean.TYPE);
        f126130c = SpongePreferenceManager.a().a("fast_gift_hide_confirm_gift_date", new HashMap(), ql3.a.f533740J);
        f126131d = SpongePreferenceManager.a().a("fast_gift_hide_confirm_gift_by_price", new HashSet(), ql3.a.L);
        f126132e = SpongePreferenceManager.a().a("fast_gift_hide_confirm_gift_by_id", new HashSet(), ql3.a.f533763w);
        f126133f = SpongePreferenceManager.a().a("day_of_exclusive_pop_up_gift_shown", new HashMap(), ql3.a.K);
    }
}
