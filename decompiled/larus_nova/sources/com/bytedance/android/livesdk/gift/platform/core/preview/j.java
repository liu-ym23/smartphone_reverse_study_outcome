package com.bytedance.android.livesdk.gift.platform.core.preview;

import com.bytedance.tools.kcp.spongepreference.runtime.SpongePreferenceManager;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes9.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f131000a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f131001b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f131002c = null;

    static {
        f131000a = new KProperty[]{Reflection.mutableProperty0(new MutablePropertyReference0Impl(j.class, "INTERACT_GIFT_PANEL_SET_TOP_SHOW_RED_DOT", "getINTERACT_GIFT_PANEL_SET_TOP_SHOW_RED_DOT()Z", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(j.class, "INTERACT_GIFT_PANEL_SHOW_NOTICE", "getINTERACT_GIFT_PANEL_SHOW_NOTICE()Z", 1))};
        com.bytedance.tools.kcp.spongepreference.runtime.b r100 = SpongePreferenceManager.a();
        Boolean r101 = Boolean.TRUE;
        Class r102 = Boolean.TYPE;
        f131001b = r100.a("interace_gift_panel_set_top_show_red_dot", r101, r102);
        f131002c = SpongePreferenceManager.a().a("interace_gift_panel_show_notice", r101, r102);
    }
}
