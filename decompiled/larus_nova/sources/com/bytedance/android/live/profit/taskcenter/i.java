package com.bytedance.android.live.profit.taskcenter;

import com.bytedance.tools.kcp.spongepreference.runtime.SpongePreferenceManager;
import java.util.HashMap;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f89028a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f89029b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f89030c = null;

    static {
        f89028a = new KProperty[]{Reflection.mutableProperty0(new MutablePropertyReference0Impl(i.class, "TASK_CENTER_PANEL_DAILY_LIMIT", "getTASK_CENTER_PANEL_DAILY_LIMIT()Ljava/util/HashMap;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(i.class, "TASK_CENTER_PANEL_LIFETIME_LIMIT", "getTASK_CENTER_PANEL_LIFETIME_LIMIT()Ljava/util/HashMap;", 1))};
        f89029b = SpongePreferenceManager.a().a("task_center_panel_daily_limit", new HashMap(), sl3.a.f542451a);
        f89030c = SpongePreferenceManager.a().a("task_center_panel_lifetime_limit", new HashMap(), sl3.a.f542456f);
    }
}
