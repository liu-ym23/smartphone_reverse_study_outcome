package com.bytedance.android.live.profit.privilege.datalayer;

import com.bytedance.tools.kcp.spongepreference.runtime.SpongePreferenceManager;
import java.util.HashMap;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f88378a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f88379b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f88380c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f88381d = null;

    static {
        f88378a = new KProperty[]{Reflection.mutableProperty0(new MutablePropertyReference0Impl(c.class, "LIVE_PRIVILEGE_TOAST_TEXT", "getLIVE_PRIVILEGE_TOAST_TEXT()Ljava/util/HashMap;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(c.class, "GIFT_TOP_LYNX_TOUCH_FRE_LIST", "getGIFT_TOP_LYNX_TOUCH_FRE_LIST()Ljava/util/HashMap;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(c.class, "TOOLBAR_GIFT_OPEN_PANEL_PARAMS", "getTOOLBAR_GIFT_OPEN_PANEL_PARAMS()Ljava/util/HashMap;", 1))};
        f88379b = SpongePreferenceManager.a().a("live_privilege_toast_text", new HashMap(), pl3.a.f529756d);
        f88380c = SpongePreferenceManager.a().a("gift_top_lynx_touch_fre_list", new HashMap(), pl3.a.f529754b);
        f88381d = SpongePreferenceManager.a().a("toolbar_gift_open_panel_params", new HashMap(), pl3.a.f529757e);
    }
}
