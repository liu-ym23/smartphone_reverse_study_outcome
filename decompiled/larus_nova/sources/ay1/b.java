package ay1;

import com.bytedance.tools.kcp.spongepreference.runtime.SpongePreferenceManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes9.dex */
public final class b {
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a A = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a A0 = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a B = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a B0 = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a C = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a D = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a E = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a F = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a G = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a H = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a I = null;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f16674J = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a K = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a L = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a M = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a N = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a O = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a P = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a Q = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a R = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a S = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a T = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a U = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a V = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a W = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a X = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a Y = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a Z = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f16675a = null;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f16676a0 = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f16677b = null;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f16678b0 = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f16679c = null;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f16680c0 = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f16681d = null;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f16682d0 = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f16683e = null;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f16684e0 = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f16685f = null;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f16686f0 = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f16687g = null;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f16688g0 = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f16689h = null;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f16690h0 = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f16691i = null;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f16692i0 = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f16693j = null;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f16694j0 = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f16695k = null;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f16696k0 = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f16697l = null;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f16698l0 = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f16699m = null;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f16700m0 = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f16701n = null;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f16702n0 = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f16703o = null;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f16704o0 = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f16705p = null;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f16706p0 = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f16707q = null;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f16708q0 = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f16709r = null;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f16710r0 = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f16711s = null;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f16712s0 = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f16713t = null;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f16714t0 = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f16715u = null;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f16716u0 = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f16717v = null;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f16718v0 = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f16719w = null;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f16720w0 = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f16721x = null;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f16722x0 = null;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f16723y = null;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f16724y0 = null;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f16725z = null;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f16726z0 = null;

    public static final void A(boolean r100) {
        U.setValue(null, f16675a[58], Boolean.valueOf(r100));
    }

    public static final void B(boolean r100) {
        V.setValue(null, f16675a[59], Boolean.valueOf(r100));
    }

    public static final void C(boolean r100) {
        D.setValue(null, f16675a[34], Boolean.valueOf(r100));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final int a() {
        return ((Number) f16695k.getValue(null, f16675a[10])).intValue();
    }

    public static final Map<String, ArrayList<String>> b() {
        return (Map) f16723y.getValue(null, f16675a[27]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final HashMap<String, String> c() {
        return (HashMap) G.getValue(null, f16675a[37]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final HashMap<String, String> d() {
        return (HashMap) H.getValue(null, f16675a[38]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final HashMap<String, String> e() {
        return (HashMap) F.getValue(null, f16675a[36]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final HashMap<String, String> f() {
        return (HashMap) A.getValue(null, f16675a[29]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final HashMap<String, String> g() {
        return (HashMap) f16725z.getValue(null, f16675a[28]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final HashMap<String, String> h() {
        return (HashMap) B.getValue(null, f16675a[30]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final HashMap<String, Boolean> i() {
        return (HashMap) f16692i0.getValue(null, f16675a[72]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final HashSet<String> j() {
        return (HashSet) f16703o.getValue(null, f16675a[17]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final HashSet<String> k() {
        return (HashSet) f16719w.getValue(null, f16675a[25]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final HashMap<String, String> l() {
        return (HashMap) f16707q.getValue(null, f16675a[19]);
    }

    public static final Map<String, Boolean> m() {
        return (Map) f16717v.getValue(null, f16675a[24]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final boolean n() {
        return ((Boolean) f16715u.getValue(null, f16675a[23])).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final boolean o() {
        return ((Boolean) f16697l.getValue(null, f16675a[14])).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final boolean p() {
        return ((Boolean) f16678b0.getValue(null, f16675a[65])).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final boolean q() {
        return ((Boolean) f16708q0.getValue(null, f16675a[82])).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final HashMap<Long, Pair<Integer, Integer>> r() {
        return (HashMap) f16704o0.getValue(null, f16675a[79]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final HashMap<String, String> s() {
        return (HashMap) Y.getValue(null, f16675a[62]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final HashSet<Long> t() {
        return (HashSet) M.getValue(null, f16675a[46]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final int u() {
        return ((Number) f16677b.getValue(null, f16675a[0])).intValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final boolean v() {
        return ((Boolean) D.getValue(null, f16675a[34])).booleanValue();
    }

    public static final void w(long r100) {
        K.setValue(null, f16675a[42], Long.valueOf(r100));
    }

    public static final void x(HashMap<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        F.setValue(null, f16675a[36], r100);
    }

    public static final void y(HashSet<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        f16719w.setValue(null, f16675a[25], r100);
    }

    public static final void z() {
        f16680c0.setValue(null, f16675a[66], Boolean.TRUE);
    }

    static {
        f16675a = new KProperty[]{Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "REQUEST_USER_CONSUME_INFO_LEVEL", "getREQUEST_USER_CONSUME_INFO_LEVEL()I", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "GROUP_LIVE_ROOM_GUIDE_IS_SHOWED", "getGROUP_LIVE_ROOM_GUIDE_IS_SHOWED()Z", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "GIFT_PRICE_ON_GIFT_GUIDE_DIALOG", "getGIFT_PRICE_ON_GIFT_GUIDE_DIALOG()Ljava/util/HashSet;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "HAS_SHOW_GIFT_GUIDE", "getHAS_SHOW_GIFT_GUIDE()Ljava/lang/String;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "RECOMMEND_FAST_GIFT_CONFIRM_RECORD", "getRECOMMEND_FAST_GIFT_CONFIRM_RECORD()J", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "RECOMMEND_FAST_GIFT_SHOW_TIMES", "getRECOMMEND_FAST_GIFT_SHOW_TIMES()Lkotlin/Pair;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "RECOMMEND_TOPICS_DEFAULT_SHOW_RECORD", "getRECOMMEND_TOPICS_DEFAULT_SHOW_RECORD()J", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "RECOMMEND_TOPICS_LAST_SHOW_TYPE", "getRECOMMEND_TOPICS_LAST_SHOW_TYPE()Ljava/lang/String;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "COMMENT_GIFT_GUIDE_CHECK_TIME", "getCOMMENT_GIFT_GUIDE_CHECK_TIME()J", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "COMMENT_GIFT_GUIDE_DISPLAY_TIME_CURRENT_DAY", "getCOMMENT_GIFT_GUIDE_DISPLAY_TIME_CURRENT_DAY()I", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "COMMENT_GIFT_GUIDE_DISPLAY_TIME_TOTAL", "getCOMMENT_GIFT_GUIDE_DISPLAY_TIME_TOTAL()I", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "GIFT_TOOLBAR_OPEN_ALERT_DIALOG_TOTAL", "getGIFT_TOOLBAR_OPEN_ALERT_DIALOG_TOTAL()I", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "GIFT_TOOLBAR_OPEN_ALERT_DIALOG_LAST_TIME", "getGIFT_TOOLBAR_OPEN_ALERT_DIALOG_LAST_TIME()J", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "GIFT_TOOLBAR_OPEN_ALERT_DIALOG_IS_NEW_DIAMOND", "getGIFT_TOOLBAR_OPEN_ALERT_DIALOG_IS_NEW_DIAMOND()Z", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "HAS_PLAY_GIFT_FAILURE_ON_MEDIAPLAYER", "getHAS_PLAY_GIFT_FAILURE_ON_MEDIAPLAYER()Z", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "GIFT_PANEL_SHOWED_MANUAL", "getGIFT_PANEL_SHOWED_MANUAL()Ljava/util/HashSet;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "GIFT_PANEL_OPENED_GUIDE_URL", "getGIFT_PANEL_OPENED_GUIDE_URL()Ljava/util/HashSet;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "GIFT_HAS_SEND_IN_CLIENT", "getGIFT_HAS_SEND_IN_CLIENT()Ljava/util/HashSet;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "GIFT_HAS_SELECTED_BY_USER_IN_CLIENT", "getGIFT_HAS_SELECTED_BY_USER_IN_CLIENT()Ljava/util/HashSet;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "GIFT_SWEEP_LIGHT_SHOW_TIMES", "getGIFT_SWEEP_LIGHT_SHOW_TIMES()Ljava/util/HashMap;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "LIVE_GIFT_AUDIO_SWITCH_GUIDE_SHOWED", "getLIVE_GIFT_AUDIO_SWITCH_GUIDE_SHOWED()Z", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "LIVE_GIFT_VIBRATE_SWITCH_GUIDE_SHOWED", "getLIVE_GIFT_VIBRATE_SWITCH_GUIDE_SHOWED()Z", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "LIVE_BUFF_CARD_DETAIL_CLICKED", "getLIVE_BUFF_CARD_DETAIL_CLICKED()Z", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "GROUP_GIFT_HIDE_CONFIRM_GIFT", "getGROUP_GIFT_HIDE_CONFIRM_GIFT()Z", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "GROUP_GIFT_HIDE_CONFIRM_BUFF_GIFT", "getGROUP_GIFT_HIDE_CONFIRM_BUFF_GIFT()Ljava/util/Map;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "GIFT_LIST_TYPE", "getGIFT_LIST_TYPE()Ljava/util/HashSet;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "GIFT_LIST_TYPE_VS", "getGIFT_LIST_TYPE_VS()Ljava/util/HashSet;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "DIY_GIFT_TOOLBAR_CACHE", "getDIY_GIFT_TOOLBAR_CACHE()Ljava/util/Map;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "GIFT_DIY_CARD_LAST_SEND_IDS", "getGIFT_DIY_CARD_LAST_SEND_IDS()Ljava/util/HashMap;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "GIFT_DIY_CARD_LAST_SEND_CARD_NAME", "getGIFT_DIY_CARD_LAST_SEND_CARD_NAME()Ljava/util/HashMap;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "GIFT_DIY_CARD_LAST_SEND_TIME", "getGIFT_DIY_CARD_LAST_SEND_TIME()Ljava/util/HashMap;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "LIVE_GIFT_LAST_RECEIVER", "getLIVE_GIFT_LAST_RECEIVER()Lkotlin/Pair;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "SHOW_GIFT_TOOLBAR_RED_DOT", "getSHOW_GIFT_TOOLBAR_RED_DOT()Z", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "CLICK_GIFT_TOOLBAR_RED_DOT", "getCLICK_GIFT_TOOLBAR_RED_DOT()Z", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "SHOW_GIFT_DIALOG_PROP_RED_DOT", "getSHOW_GIFT_DIALOG_PROP_RED_DOT()Z", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "LIVE_SHOW_SEND_PROPS_TO_LINKER_TIPS", "getLIVE_SHOW_SEND_PROPS_TO_LINKER_TIPS()Z", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "GIFT_BUFF_CARD_SWEEP_LIGHT_SHOW_TIMES", "getGIFT_BUFF_CARD_SWEEP_LIGHT_SHOW_TIMES()Ljava/util/HashMap;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "GIFT_BUFF_CARD_LAST_SEND_IDS", "getGIFT_BUFF_CARD_LAST_SEND_IDS()Ljava/util/HashMap;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "GIFT_BUFF_CARD_LAST_SEND_TIME", "getGIFT_BUFF_CARD_LAST_SEND_TIME()Ljava/util/HashMap;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "LIVE_GIFT_CUSTOM_GIFT_CARD_HAS_REMIND", "getLIVE_GIFT_CUSTOM_GIFT_CARD_HAS_REMIND()Ljava/util/HashSet;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "GIFT_PREVIEW_IN_ROOM", "getGIFT_PREVIEW_IN_ROOM()Z", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "GIFT_ASSET_PREVIEW_IN_ROOM", "getGIFT_ASSET_PREVIEW_IN_ROOM()Z", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "ASSETS_CACHE_LAST_CHECK_TIME", "getASSETS_CACHE_LAST_CHECK_TIME()J", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "ASSETS_ROOM_DELETE_LAST_CHECK_TIME", "getASSETS_ROOM_DELETE_LAST_CHECK_TIME()J", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "ASSETS_UGC_LAST_CLEAR_CHECK_TIME", "getASSETS_UGC_LAST_CLEAR_CHECK_TIME()J", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "LIVE_GIFT_PANEL_SEND_GIFT_RELATION", "getLIVE_GIFT_PANEL_SEND_GIFT_RELATION()Ljava/util/ArrayList;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "PROP_PANEL_SHOWED_RED_POINT", "getPROP_PANEL_SHOWED_RED_POINT()Ljava/util/HashSet;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "LIVE_GESTURE_GIFT_RECOGNIZED_MAP", "getLIVE_GESTURE_GIFT_RECOGNIZED_MAP()Ljava/util/List;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "TOOLBAR_GIFT_OPEN_PANEL_PARAMS", "getTOOLBAR_GIFT_OPEN_PANEL_PARAMS()Ljava/util/Map;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "GIFT_TOP_LYNX_TOUCH_FRE_LIST", "getGIFT_TOP_LYNX_TOUCH_FRE_LIST()Ljava/util/HashMap;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "GUEST_BATTLE_SEND_GIFT_HINT_SHOWN", "getGUEST_BATTLE_SEND_GIFT_HINT_SHOWN()Z", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "MIC_ROOM_GIFT_NOTIFY", "getMIC_ROOM_GIFT_NOTIFY()Z", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "GIFT_ANIMATION_ENABLE_LANDSCAPE", "getGIFT_ANIMATION_ENABLE_LANDSCAPE()Z", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "ASSETS_DOWNLOAD_MODEL", "getASSETS_DOWNLOAD_MODEL()Ljava/util/concurrent/ConcurrentHashMap;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "LIVE_TODAY_FIRST_PLAY_TIME", "getLIVE_TODAY_FIRST_PLAY_TIME()J", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "LIVE_TODAY_ENTERROOM_MONITOR_FLAG", "getLIVE_TODAY_ENTERROOM_MONITOR_FLAG()Z", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "LIVE_REPORT_APPASSET_DIR_SIZE_TIME", "getLIVE_REPORT_APPASSET_DIR_SIZE_TIME()J", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "LIVE_SETTING_AUDIENCE_GIFT_OPEN_VALUE", "getLIVE_SETTING_AUDIENCE_GIFT_OPEN_VALUE()Z", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "LIVE_GIFT_SOUND_AND_VIBRATION_OPEN_VALUE", "getLIVE_GIFT_SOUND_AND_VIBRATION_OPEN_VALUE()Z", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "LIVE_GIFT_SOUND_AND_VIBRATION_OPEN_VALUE_FOR_ANCHOR", "getLIVE_GIFT_SOUND_AND_VIBRATION_OPEN_VALUE_FOR_ANCHOR()Z", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "LIVE_GIFT_SOUND_AND_VIBRATION_TOAST_SHOW_STATUS", "getLIVE_GIFT_SOUND_AND_VIBRATION_TOAST_SHOW_STATUS()Z", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "LIVE_PROP_EXPIRE_TIP_TIME", "getLIVE_PROP_EXPIRE_TIP_TIME()J", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "LIVE_PROP_EXPIRE_TIP_TIME_REDDOT", "getLIVE_PROP_EXPIRE_TIP_TIME_REDDOT()Ljava/util/HashMap;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "LIVE_PROP_EXPIRE_TIP_TIME_TOAST", "getLIVE_PROP_EXPIRE_TIP_TIME_TOAST()Ljava/util/HashMap;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "LIVE_IS_CLEAR_SCREEN_OPTIMIZE", "getLIVE_IS_CLEAR_SCREEN_OPTIMIZE()Z", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "IN_BYTE_CAST_SCREEN_MODE", "getIN_BYTE_CAST_SCREEN_MODE()Z", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "GROUP_GIFT_GUIDE_HINT", "getGROUP_GIFT_GUIDE_HINT()Z", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "GROUP_GIFT_PROP_GUIDE_HINT", "getGROUP_GIFT_PROP_GUIDE_HINT()Z", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "GIFT_CYCLE_RELEASE_ID", "getGIFT_CYCLE_RELEASE_ID()J", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "GIFT_CYCLE_RELEASE_GIFT_ID", "getGIFT_CYCLE_RELEASE_GIFT_ID()J", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "PRIVILEGE_PANEL_SHOWED_RED_POINT", "getPRIVILEGE_PANEL_SHOWED_RED_POINT()Ljava/util/HashSet;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "PRIVILEGE_RED_POINT_FIRST_TIME", "getPRIVILEGE_RED_POINT_FIRST_TIME()J", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "GIFT_FIRST_TIME_COMBO_HINT", "getGIFT_FIRST_TIME_COMBO_HINT()Ljava/util/HashMap;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "LIVE_GIFT_RECEIVER_NOTICED_ROOM", "getLIVE_GIFT_RECEIVER_NOTICED_ROOM()Ljava/util/ArrayList;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "LIVE_GIFT_RECEIVER_NOTICE_COUNT", "getLIVE_GIFT_RECEIVER_NOTICE_COUNT()I", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "LIVE_GIFT_RECEIVER_LAST_NOTICE_TIME", "getLIVE_GIFT_RECEIVER_LAST_NOTICE_TIME()J", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "LIVE_GIFT_MINOR_NOTICE_TEXT", "getLIVE_GIFT_MINOR_NOTICE_TEXT()Ljava/lang/String;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "LIVE_GIFT_CUSTOM_GIFT_CARD_REMIND_TIME", "getLIVE_GIFT_CUSTOM_GIFT_CARD_REMIND_TIME()Ljava/util/HashMap;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "LIVE_ANCHOR_TAG", "getLIVE_ANCHOR_TAG()Z", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "LIVE_GOLD_ROCKET_FIRST_TIME_HINT_TIMES", "getLIVE_GOLD_ROCKET_FIRST_TIME_HINT_TIMES()Ljava/util/HashMap;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "LIVE_GIFT_EXPOSURE_ANIM_FREQUENCY", "getLIVE_GIFT_EXPOSURE_ANIM_FREQUENCY()Ljava/util/HashMap;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "LIVE_GIFT_FIRST_RECEIVE_INTERACT_GIFT", "getLIVE_GIFT_FIRST_RECEIVE_INTERACT_GIFT()Z", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "LIVE_GIFT_INTERACT_GIFT_TOOLBAR_SHOW_DOT", "getLIVE_GIFT_INTERACT_GIFT_TOOLBAR_SHOW_DOT()Z", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "LIVE_INTERACT_GIFT_NOTICE_TIME", "getLIVE_INTERACT_GIFT_NOTICE_TIME()I", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "LIVE_BATTLE_PROP_LYNX_VIEW_HAS_SHOW", "getLIVE_BATTLE_PROP_LYNX_VIEW_HAS_SHOW()Ljava/util/HashMap;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "LIVE_EFFECT_DEGRADE_NOTICE_WINDOW_SWITCH", "getLIVE_EFFECT_DEGRADE_NOTICE_WINDOW_SWITCH()Z", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "LIVE_ASSETS_LRU_CACHE", "getLIVE_ASSETS_LRU_CACHE()Ljava/util/HashMap;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "LIVE_PK_PROPCARD_CACHE", "getLIVE_PK_PROPCARD_CACHE()Ljava/util/HashMap;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "MostlyUsedTabNotClicked", "getMostlyUsedTabNotClicked()Z", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "LIVE_GIFT_INTERACT_PAGE_SCROLL_GUIDE_LAST_FREQUENCY_CHECK_TIME", "getLIVE_GIFT_INTERACT_PAGE_SCROLL_GUIDE_LAST_FREQUENCY_CHECK_TIME()J", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "LIVE_GIFT_INTERACT_PAGE_SCROLL_GUIDE_SHOW_TIMES", "getLIVE_GIFT_INTERACT_PAGE_SCROLL_GUIDE_SHOW_TIMES()Ljava/util/HashMap;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "LIVE_GIFT_INTERACT_PAGE_SCROLL_GUIDE_HAS_ENTER_INTERACT_PAGE", "getLIVE_GIFT_INTERACT_PAGE_SCROLL_GUIDE_HAS_ENTER_INTERACT_PAGE()Z", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "LIVE_ASSET_CLEAN__CACHE_PUSH_SHOW_TIME", "getLIVE_ASSET_CLEAN__CACHE_PUSH_SHOW_TIME()Ljava/util/LinkedList;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "LIVE_GIFT_PRICE_OVER_LIMIT", "getLIVE_GIFT_PRICE_OVER_LIMIT()Ljava/util/HashSet;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "LIVE_GIFT_GAME_EFFECT_RED_DOT", "getLIVE_GIFT_GAME_EFFECT_RED_DOT()Z", 1))};
        com.bytedance.tools.kcp.spongepreference.runtime.b r100 = SpongePreferenceManager.a();
        Class r101 = Integer.TYPE;
        f16677b = r100.a("request_user_consume_info_level", -1, r101);
        com.bytedance.tools.kcp.spongepreference.runtime.b r102 = SpongePreferenceManager.a();
        Boolean r103 = Boolean.FALSE;
        Class r104 = Boolean.TYPE;
        r102.a("group_live_room_guide_is_showed", r103, r104);
        f16679c = SpongePreferenceManager.a().a("gift_price_on_gift_guide_dialog", new HashSet(), ql3.a.R);
        f16681d = SpongePreferenceManager.a().a("gift_guide_flag", "", String.class);
        com.bytedance.tools.kcp.spongepreference.runtime.b r105 = SpongePreferenceManager.a();
        Class r106 = Long.TYPE;
        f16683e = r105.a("recommend_fast_gift_confirm_record", 0L, r106);
        f16685f = SpongePreferenceManager.a().a("recommend_fast_gift_show_times", new Pair(0L, 0), ql3.a.S);
        f16687g = SpongePreferenceManager.a().a("recommend_topics_default_show_record", 0L, r106);
        f16689h = SpongePreferenceManager.a().a("recommend_topics_last_show_type", "", String.class);
        f16691i = SpongePreferenceManager.a().a("comment_gift_guide_check_time", 0L, r106);
        f16693j = SpongePreferenceManager.a().a("comment_gift_guide_display_time_current_day", 0, r101);
        f16695k = SpongePreferenceManager.a().a("comment_gift_guide_display_time_total", 0, r101);
        SpongePreferenceManager.a().a("gift_toolbar_open_alert_dialog_total", 0, r101);
        SpongePreferenceManager.a().a("gift_toolbar_open_alert_dialog_last_time", 0L, r106);
        SpongePreferenceManager.a().a("gift_toolbar_open_alert_dialog_is_new_diamond", r103, r104);
        f16697l = SpongePreferenceManager.a().a("has_play_gift_failure_on_mediaplayer", r103, r104);
        f16699m = SpongePreferenceManager.a().a("gift_panel_showed_manual", new HashSet(), ql3.a.f533759s);
        f16701n = SpongePreferenceManager.a().a("gift_panel_opened_guide_url", new HashSet(), ql3.a.f533754n);
        f16703o = SpongePreferenceManager.a().a("gift_has_send_in_client", new HashSet(), ql3.a.O);
        f16705p = SpongePreferenceManager.a().a("gift_has_selected_by_user_in_client_str", new HashSet(), ql3.a.f533744d);
        f16707q = SpongePreferenceManager.a().a("gift_sweep_light_show_times", new HashMap(), ql3.a.f533751k);
        f16709r = SpongePreferenceManager.a().a("live_gift_audio_switch_guide_showed", r103, r104);
        f16711s = SpongePreferenceManager.a().a("live_gift_vibrate_switch_guide_showed", r103, r104);
        f16713t = SpongePreferenceManager.a().a("live_buff_card_detail_clicked", r103, r104);
        f16715u = SpongePreferenceManager.a().a("group_gift_hide_confirm_gift", r103, r104);
        f16717v = SpongePreferenceManager.a().a("group_gift_hide_confirm_buff_gift", MapsKt.emptyMap(), ql3.a.T);
        f16719w = SpongePreferenceManager.a().a("gift_list_type", new HashSet(), ql3.a.f533765y);
        f16721x = SpongePreferenceManager.a().a("gift_list_type_vs", new HashSet(), ql3.a.f533747g);
        f16723y = SpongePreferenceManager.a().a("diy_gift_toolbar_cache", new LinkedHashMap(), ql3.a.f533752l);
        f16725z = SpongePreferenceManager.a().a("gift_diy_card_last_send_ids", new HashMap(), ql3.a.E);
        A = SpongePreferenceManager.a().a("gift_diy_card_last_send_card_name", new HashMap(), ql3.a.f533762v);
        B = SpongePreferenceManager.a().a("gift_diy_card_last_send_time", new HashMap(), ql3.a.f533756p);
        SpongePreferenceManager.a().a("live_gift_last_receiver_cache", new Pair("0", "0"), ql3.a.f533743c);
        SpongePreferenceManager.a().a("show_gift_toolbar_red_dot", r103, r104);
        C = SpongePreferenceManager.a().a("click_gift_toolbar_red_dot", r103, r104);
        D = SpongePreferenceManager.a().a("show_gift_dialog_prop_red_dot", r103, r104);
        E = SpongePreferenceManager.a().a("live_show_send_props_to_linker_tips", r103, r104);
        F = SpongePreferenceManager.a().a("gift_buff_card_sweep_light_show_times", new HashMap(), ql3.a.f533755o);
        G = SpongePreferenceManager.a().a("gift_buff_card_last_send_ids", new HashMap(), ql3.a.f533758r);
        H = SpongePreferenceManager.a().a("gift_buff_card_last_send_time", new HashMap(), ql3.a.A);
        SpongePreferenceManager.a().a("live_gift_custom_gift_card_has_remind", new HashSet(), ql3.a.N);
        I = SpongePreferenceManager.a().a("gift_preview_in_room", r103, r104);
        f16674J = SpongePreferenceManager.a().a("gift_asset_preview_in_room", r103, r104);
        K = SpongePreferenceManager.a().a("assets_cache_last_check_time", 0L, r106);
        SpongePreferenceManager.a().a("assets_room_delete_last_check_time", 0L, r106);
        SpongePreferenceManager.a().a("assets_ugc_gift_last_clear_check_time", 0L, r106);
        L = SpongePreferenceManager.a().a("live_gift_panel_send_gift_relation", new ArrayList(), ql3.a.B);
        M = SpongePreferenceManager.a().a("prop_panel_showed_red_point", new HashSet(), ql3.a.f533757q);
        SpongePreferenceManager.a().a("live_gesture_gift_recognized_map", new ArrayList(), ql3.a.Q);
        N = SpongePreferenceManager.a().a("toolbar_gift_open_panel_params", new HashMap(), ql3.a.P);
        O = SpongePreferenceManager.a().a("gift_top_lynx_touch_fre_list", new HashMap(), ql3.a.f533742b);
        SpongePreferenceManager.a().a("guest_battle_send_gift_shown", r103, r104);
        SpongePreferenceManager.a().a("mic_room_gift_notify", r103, r104);
        com.bytedance.tools.kcp.spongepreference.runtime.b r107 = SpongePreferenceManager.a();
        Boolean r108 = Boolean.TRUE;
        P = r107.a("gift_animation_enable_landscape", r108, r104);
        SpongePreferenceManager.a().a("assets_download_model", new ConcurrentHashMap(), ql3.a.f533761u);
        Q = SpongePreferenceManager.a().a("live_today_first_play_time", 0L, r106);
        R = SpongePreferenceManager.a().a("live_today_enterroom_monitor_flag", r103, r104);
        S = SpongePreferenceManager.a().a("live_report_appasset_dir_size_time", 0L, r106);
        T = SpongePreferenceManager.a().a("live_setting_audience_gift_open_value", r108, r104);
        U = SpongePreferenceManager.a().a("live_gift_sound_and_vibration_open_value", r108, r104);
        V = SpongePreferenceManager.a().a("live_gift_sound_and_vibration_open_value_for_anchor", r108, r104);
        W = SpongePreferenceManager.a().a("live_gift_soound_and_vibration_toast_show_status", r103, r104);
        X = SpongePreferenceManager.a().a("live_prop_expire_tip_time", 0L, r106);
        Y = SpongePreferenceManager.a().a("live_prop_expire_tip_time_reddot", new HashMap(), ql3.a.M);
        Z = SpongePreferenceManager.a().a("live_prop_expire_tip_time_toast", new HashMap(), ql3.a.f533749i);
        f16676a0 = SpongePreferenceManager.a().a("live_clear_screen_optimize", r103, r104);
        f16678b0 = SpongePreferenceManager.a().a("in_byte_cast_screen_mode", r103, r104);
        f16680c0 = SpongePreferenceManager.a().a("group_gift_guide_hint", r103, r104);
        f16682d0 = SpongePreferenceManager.a().a("group_gift_prop_guide_hint", r103, r104);
        f16684e0 = SpongePreferenceManager.a().a("gift_cycle_release_id", -1L, r106);
        f16686f0 = SpongePreferenceManager.a().a("gift_cycle_release_gift_id", -1L, r106);
        f16688g0 = SpongePreferenceManager.a().a("privilege_panel_lock_showed_red_point", new HashSet(), ql3.a.D);
        f16690h0 = SpongePreferenceManager.a().a("privilege_red_point_first_time", 0L, r106);
        f16692i0 = SpongePreferenceManager.a().a("gift_first_time_combo_hint", new HashMap(), ql3.a.f533745e);
        f16694j0 = SpongePreferenceManager.a().a("live_gift_receiver_notice_room", new ArrayList(), ql3.a.f533748h);
        f16696k0 = SpongePreferenceManager.a().a("live_gift_receiver_notice_count", 0, r101);
        f16698l0 = SpongePreferenceManager.a().a("live_gift_receiver_last_notice_time", 0L, r106);
        f16700m0 = SpongePreferenceManager.a().a("live_gift_minor_notice_text", "", String.class);
        f16702n0 = SpongePreferenceManager.a().a("live_gift_custom_gift_card_remind_time", new HashMap(), ql3.a.H);
        SpongePreferenceManager.a().a("live_anchor_tag", r103, r104);
        f16704o0 = SpongePreferenceManager.a().a("live_gold_rocket_first_time_hint_times", new HashMap(), ql3.a.f533746f);
        f16706p0 = SpongePreferenceManager.a().a("live_gift_exposure_anim_frequency", new HashMap(), ql3.a.f533760t);
        SpongePreferenceManager.a().a("live_gift_first_receive_interact_gift", r103, r104);
        f16708q0 = SpongePreferenceManager.a().a("live_gift_interact_gift_toolbar_show_dot", r108, r104);
        f16710r0 = SpongePreferenceManager.a().a("live_interact_gift_notice_time", 0, r101);
        f16712s0 = SpongePreferenceManager.a().a("live_battle_prop_lynx_view_has_show", new HashMap(), ql3.a.f533741a);
        SpongePreferenceManager.a().a("live_effect_degrade_notice_window_switch", r103, r104);
        f16714t0 = SpongePreferenceManager.a().a("live_assets_lru_cache", new HashMap(), ql3.a.f533753m);
        f16716u0 = SpongePreferenceManager.a().a("live_pk_propcard_cache", new HashMap(), ql3.a.f533764x);
        f16718v0 = SpongePreferenceManager.a().a("mostly_used_tab_not_clicked", r108, r104);
        f16720w0 = SpongePreferenceManager.a().a("live_gift_interact_page_scroll_guide_last_frequency_check_time", 0L, r106);
        f16722x0 = SpongePreferenceManager.a().a("live_gift_interact_page_scroll_guide_show_times", new HashMap(), ql3.a.G);
        f16724y0 = SpongePreferenceManager.a().a("live_gift_interact_page_scroll_guide_has_enter_interact_page", r103, r104);
        f16726z0 = SpongePreferenceManager.a().a("live_asset_clean_cache_push_show_time", new LinkedList(), ql3.a.C);
        A0 = SpongePreferenceManager.a().a("live_gift_price_over_limit", new HashSet(), ql3.a.F);
        B0 = SpongePreferenceManager.a().a("live_gift_game_effect_red_dot", r108, r104);
    }
}
