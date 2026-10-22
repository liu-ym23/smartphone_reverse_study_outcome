package com.bytedance.android.live.profit.lottery;

import com.bytedance.tools.kcp.spongepreference.runtime.SpongePreferenceManager;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class g1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f88076a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f88077b = null;

    static {
        f88076a = new KProperty[]{Reflection.mutableProperty0(new MutablePropertyReference0Impl(g1.class, "HAS_SHOWN_LOTTERY_RED_DOT", "getHAS_SHOWN_LOTTERY_RED_DOT()Z", 1))};
        f88077b = SpongePreferenceManager.a().a("has_shown_lottery_red_dot", Boolean.FALSE, Boolean.TYPE);
    }
}
