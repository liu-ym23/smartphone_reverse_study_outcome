package ay1;

import com.bytedance.tools.kcp.spongepreference.runtime.SpongePreferenceManager;
import java.util.HashMap;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes9.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f16727a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f16728b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f16729c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f16730d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f16731e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f16732f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f16733g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final cd6.b.a f16734h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final cd6.b.c f16735i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final cd6.b.d f16736j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final cd6.b.C0435b f16737k = null;

    /* JADX WARN: Multi-variable type inference failed */
    public static final boolean a() {
        return ((Boolean) f16731e.getValue(null, f16727a[6])).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final boolean b() {
        return ((Boolean) f16730d.getValue(null, f16727a[5])).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final boolean c() {
        return ((Boolean) f16732f.getValue(null, f16727a[7])).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final boolean d() {
        return ((Boolean) f16733g.getValue(null, f16727a[8])).booleanValue();
    }

    public static final void e(boolean r100) {
        f16731e.setValue(null, f16727a[6], Boolean.valueOf(r100));
    }

    public static final void f(boolean r100) {
        f16732f.setValue(null, f16727a[7], Boolean.valueOf(r100));
    }

    public static final void g(boolean r100) {
        f16733g.setValue(null, f16727a[8], Boolean.valueOf(r100));
    }

    static {
        f16727a = new KProperty[]{Reflection.mutableProperty0(new MutablePropertyReference0Impl(d.class, "ASSETS_CACHE_LAST_CHECK_TIME", "getASSETS_CACHE_LAST_CHECK_TIME()J", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(d.class, "ASSETS_CACHE_DATA", "getASSETS_CACHE_DATA()Ljava/lang/String;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(d.class, "LIVE_GIFT_RESOURCE_USE_TIME", "getLIVE_GIFT_RESOURCE_USE_TIME()Ljava/util/HashMap;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(d.class, "LIVE_GIFT_RESOURCE_CACHE_INIT", "getLIVE_GIFT_RESOURCE_CACHE_INIT()Z", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(d.class, "REQUEST_USER_CONSUME_INFO_LEVEL", "getREQUEST_USER_CONSUME_INFO_LEVEL()I", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(d.class, "LIVE_SETTING_ANCHOR_GIFT_OPEN_VALUE", "getLIVE_SETTING_ANCHOR_GIFT_OPEN_VALUE()Z", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(d.class, "LIVE_SETTING_ANCHOR_EFFECT_GAME_VALUE", "getLIVE_SETTING_ANCHOR_EFFECT_GAME_VALUE()Z", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(d.class, "LIVE_SETTING_ANCHOR_ROLE_SKILL_EFFECT_VALUE", "getLIVE_SETTING_ANCHOR_ROLE_SKILL_EFFECT_VALUE()Z", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(d.class, "LIVE_SETTING_ANCHOR_STICKER_GIFT_OPEN_VALUE", "getLIVE_SETTING_ANCHOR_STICKER_GIFT_OPEN_VALUE()Z", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(d.class, "LIVE_GIFT_AUDIENCE_SEND_GIFT_ENABLED_ANCHOR_SWITCH", "getLIVE_GIFT_AUDIENCE_SEND_GIFT_ENABLED_ANCHOR_SWITCH()J", 1))};
        com.bytedance.tools.kcp.spongepreference.runtime.b r100 = SpongePreferenceManager.a();
        Long r101 = Long.valueOf(0);
        Class r102 = Long.TYPE;
        r100.a("assets_cache_last_check_time", r101, r102);
        SpongePreferenceManager.a().a("assets_cache_data", "", String.class);
        f16728b = SpongePreferenceManager.a().a("live_gift_resources_use_time", new HashMap(), rl3.a.f538460d);
        com.bytedance.tools.kcp.spongepreference.runtime.b r103 = SpongePreferenceManager.a();
        Boolean r104 = Boolean.FALSE;
        Class r105 = Boolean.TYPE;
        f16729c = r103.a("live_gift_resourece_cache_init", r104, r105);
        SpongePreferenceManager.a().a("request_user_consume_info_level", -1, Integer.TYPE);
        com.bytedance.tools.kcp.spongepreference.runtime.b r106 = SpongePreferenceManager.a();
        Boolean r107 = Boolean.TRUE;
        f16730d = r106.a("live_setting_anchor_gift_open_value", r107, r105);
        f16731e = SpongePreferenceManager.a().a("live_setting_anchor_effect_game_value", r107, r105);
        f16732f = SpongePreferenceManager.a().a("live_setting_anchor_character_effect_value", r107, r105);
        f16733g = SpongePreferenceManager.a().a("live_setting_sticker_gift_open_value", r107, r105);
        f16734h = cd6.b.f23402c;
        f16735i = cd6.b.f23404e;
        f16736j = cd6.b.f23406g;
        f16737k = cd6.b.f23408i;
        SpongePreferenceManager.a().a("live_gift_audience_send_gift_enabled_anchor_switch", 2L, r102);
    }
}
