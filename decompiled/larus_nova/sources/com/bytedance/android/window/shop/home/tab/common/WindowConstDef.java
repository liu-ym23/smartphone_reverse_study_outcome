package com.bytedance.android.window.shop.home.tab.common;

import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.opt.ab.p;
import com.bytedance.android.window.shop.repository.tab.entity.WindowLayoutType;
import com.google.gson.Gson;
import hq7.d;
import java.util.Map;
import jj4.b;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import zq3.c;
import zq3.d0;
import zq3.h0;
import zq3.i0;
import zq3.k0;
import zq3.l;
import zq3.n;
import zq3.q;
import zq3.r;

/* JADX INFO: loaded from: classes14.dex */
public final class WindowConstDef {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final fo.a<WindowLayoutType> f188713a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f188714b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f188715c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final long f188716d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final boolean f188717e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final boolean f188718f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Lazy f188719g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Lazy f188720h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Lazy f188721i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Lazy f188722j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Lazy f188723k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Lazy f188724l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Lazy f188725m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Lazy f188726n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Lazy f188727o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Lazy f188728p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Lazy f188729q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final Lazy f188730r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final boolean f188731s = false;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final boolean f188732t = false;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final boolean f188733u = false;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final Lazy f188734v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final Map<String, Integer> f188735w = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final Lazy f188736x = null;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f188737y = 0;

    public WindowConstDef() {
    }

    public static boolean a() {
        return ((Boolean) f188726n.getValue()).booleanValue();
    }

    static {
        Object r100 = 0;
        f188713a = new fo.a("product_tab_layout", new WindowLayoutType[0]);
        int r101 = l.f573304a;
        Object r102 = null;
        if (c.f573296b == false) goto L13;
        int r103 = p.f45243a;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L9
        b r105 = b.f499326b;     // Catch: Throwable -> L9
        Object r106 = jj4.a.a("window_feed_use_list_kit", Integer.class, r100, false);     // Catch: Throwable -> L9
        if (r106 != null) goto L40;
        Intrinsics.throwNpe();     // Catch: Throwable -> L9
    L40:
        if (((Number) r106).intValue() != 1) goto L42;
        boolean r107 = true;
    L43:
        f188714b = r107;
        f188715c = LazyKt.lazy(WindowConstDef$WINDOW_HYBRID_LIST_USE_ASYNC_TRANSFORM$2.INSTANCE);
        Gson r108 = c.f573295a;
        Object r109 = 0L;
        if (c.f573296b == false) goto L55;
        int r110 = p.f45243a;
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L50
        b r112 = b.f499326b;     // Catch: Throwable -> L50
        Object r113 = jj4.a.a("window_header_transition_duration", Long.class, r109, false);     // Catch: Throwable -> L50
        if (r113 != null) goto L81;
        Intrinsics.throwNpe();     // Catch: Throwable -> L50
    L81:
        f188716d = ((Number) r113).longValue();
        Lazy r114 = ECSettingKeys.f43616a;
        int r115 = p.f45243a;
        Result.Companion r116 = Result.Companion;     // Catch: Throwable -> L86
        b r117 = b.f499326b;     // Catch: Throwable -> L86
        Object r118 = jj4.a.a("ec_window_feed_scale_enable", Integer.class, r100, false);     // Catch: Throwable -> L86
        if (r118 != null) goto L91;
        Intrinsics.throwNpe();     // Catch: Throwable -> L86
    L91:
        if (((Number) r118).intValue() != 1) goto L93;
        boolean r119 = true;
    L94:
        f188717e = r119;
        int r120 = l.f573304a;
        if (c.f573296b == false) goto L105;
        int r121 = p.f45243a;
        b r122 = b.f499326b;     // Catch: Throwable -> L101
        Object r123 = jj4.a.a("window_header_use_list_kit", Integer.class, r100, false);     // Catch: Throwable -> L101
        if (r123 != null) goto L132;
        Intrinsics.throwNpe();     // Catch: Throwable -> L101
    L132:
        if (((Number) r123).intValue() != 1) goto L134;
        boolean r124 = true;
    L135:
        f188718f = r124;
        f188719g = LazyKt.lazy(WindowConstDef$WINDOW_LAUNCH_VIEW_PRECREATE$2.INSTANCE);
        f188720h = LazyKt.lazy(WindowConstDef$WINDOW_TAB_REQUEST_PAGE_SIZE$2.INSTANCE);
        f188721i = LazyKt.lazy(WindowConstDef$WINDOW_TAB_LAYOUT_SMILE_INDICATOR$2.INSTANCE);
        f188722j = LazyKt.lazy(WindowConstDef$WINDOW_LAUNCH_TASK_OPT$2.INSTANCE);
        f188723k = LazyKt.lazy(WindowConstDef$WINDOW_ROOT_XML_USE_SYNC_INFLATER$2.INSTANCE);
        f188724l = LazyKt.lazy(WindowConstDef$WINDOW_LAUNCH_VIEW_PRECREATE_CNT$2.INSTANCE);
        f188725m = LazyKt.lazy(WindowConstDef$WINDOW_DYNAMIC_RENDER_PERF_OPT$2.INSTANCE);
        f188726n = LazyKt.lazy(WindowConstDef$WINDOW_PRICE_USE_DOUYIN_NUM_ABC$2.INSTANCE);
        f188727o = LazyKt.lazy(WindowConstDef$WINDOW_LAUNCH_TAB_PRECREATE$2.INSTANCE);
        f188728p = LazyKt.lazy(WindowConstDef$WINDOW_LIVE_DATA_OPT$2.INSTANCE);
        f188729q = LazyKt.lazy(WindowConstDef$COMMON_HORIZONTAL_EDGE_MARGIN$2.INSTANCE);
        f188730r = LazyKt.lazy(WindowConstDef$WINDOW_HEADER_NICK_NAME_EMOJI_SUPPORT$2.INSTANCE);
        int r125 = l.f573304a;
        Gson r126 = c.f573295a;
        Object r127 = Boolean.TRUE;
        if (c.f573296b == false) goto L147;
        int r128 = p.f45243a;
        Result.Companion r129 = Result.Companion;     // Catch: Throwable -> L142
        b r130 = b.f499326b;     // Catch: Throwable -> L142
        Object r131 = jj4.a.a("window_dynamic_view_enable_cache", Boolean.class, r127, false);     // Catch: Throwable -> L142
        if (r131 != null) goto L173;
        Intrinsics.throwNpe();     // Catch: Throwable -> L142
    L173:
        f188731s = ((Boolean) r131).booleanValue();
        int r132 = l.f573304a;
        Gson r133 = c.f573295a;
        Object r134 = Boolean.TRUE;
        if (c.f573296b == false) goto L185;
        int r135 = p.f45243a;
        Result.Companion r136 = Result.Companion;     // Catch: Throwable -> L180
        b r137 = b.f499326b;     // Catch: Throwable -> L180
        Object r138 = jj4.a.a("window_tags_enable_cache", Boolean.class, r134, false);     // Catch: Throwable -> L180
        if (r138 != null) goto L211;
        Intrinsics.throwNpe();     // Catch: Throwable -> L180
    L211:
        f188732t = ((Boolean) r138).booleanValue();
        int r139 = l.f573304a;
        Gson r140 = c.f573295a;
        Object r141 = Boolean.TRUE;
        if (c.f573296b == false) goto L223;
        int r142 = p.f45243a;
        Result.Companion r143 = Result.Companion;     // Catch: Throwable -> L218
        b r144 = b.f499326b;     // Catch: Throwable -> L218
        Object r145 = jj4.a.a("window_search_use_new_path", Boolean.class, r141, false);     // Catch: Throwable -> L218
        if (r145 != null) goto L249;
        Intrinsics.throwNpe();     // Catch: Throwable -> L218
    L249:
        f188733u = ((Boolean) r145).booleanValue();
        f188734v = LazyKt.lazy(WindowConstDef$WINDOW_TITLE_PREFIX_ICON_BIND_OPT$2.INSTANCE);
        if (c.f573296b == false) goto L261;
        int r146 = p.f45243a;
        Result.Companion r147 = Result.Companion;     // Catch: Throwable -> L256
        b r148 = b.f499326b;     // Catch: Throwable -> L256
        Object r149 = jj4.a.a("window_tab_use_dynamic_product", Integer.class, r100, false);     // Catch: Throwable -> L256
        if (r149 != null) goto L288;
        Intrinsics.throwNpe();     // Catch: Throwable -> L256
    L288:
        if (((Number) r149).intValue() != 1) goto L290;
        int r150 = 1;
    L291:
        f188735w = MapsKt.mapOf(new Pair[]{TuplesKt.to("window_header_use_list_kit", Integer.valueOf(f188718f ? 1 : 0)), TuplesKt.to("window_tab_use_dynamic_product", Integer.valueOf(r150))});
        f188736x = LazyKt.lazy(WindowConstDef$WINDOW_FIX_LAYOUT_SWITCH$2.INSTANCE);
        int r151 = p.f45243a;
        Object r152 = 10;
        Result.Companion r153 = Result.Companion;     // Catch: Throwable -> L296
        b r154 = b.f499326b;     // Catch: Throwable -> L296
        Object r155 = jj4.a.a("window_hybrid_feed_request_preload_threshold", Integer.class, r152, false);     // Catch: Throwable -> L296
        if (r155 != null) goto L302;
        Intrinsics.throwNpe();     // Catch: Throwable -> L296
    L302:
        f188737y = RangesKt.coerceIn(((Number) r155).intValue(), 1, 100);
        return;
    L296:
        th = move-exception;
        Result.Companion r156 = Result.Companion;
        Object r157 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r157) == true) goto L301;
        r152 = r157;
    L301:
        r155 = r152;
        goto L302
    L290:
        r150 = 0;
    L256:
        th = move-exception;
        Result.Companion r158 = Result.Companion;
        Object r159 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r159) == true) goto L285;
    L260:
        r100 = r159;
    L285:
        r149 = r100;
        goto L288
    L261:
        String r160 = d.b("debug.shopping.mock.window_tab_use_dynamic_product");
        if (r160 != null) goto L264;
    L267:
        boolean r161 = true;
    L268:
        if (r161 == false) goto L338;
    L276:
        if (r102 != null) goto L286;
        int r162 = p.f45243a;
        Result.Companion r163 = Result.Companion;     // Catch: Throwable -> L282
        b r164 = b.f499326b;     // Catch: Throwable -> L282
        r149 = jj4.a.a("window_tab_use_dynamic_product", Integer.class, r100, false);     // Catch: Throwable -> L282
        if (r149 != null) goto L288;
        Intrinsics.throwNpe();     // Catch: Throwable -> L282
    L282:
        th = move-exception;
        Result.Companion r165 = Result.Companion;
        r159 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r159) == false) goto L260;
    L286:
        r149 = r102;
        goto L288
    L338:
        Object r166 = c.f573295a.fromJson(r160, new h0().getType());     // Catch: Exception -> L274
        if (r166 == null) goto L276;
        r102 = r166;
    L274:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L276
    L264:
        if (StringsKt.isBlank(r160) == true) goto L267;
        r161 = false;
    L218:
        th = move-exception;
        Result.Companion r167 = Result.Companion;
        Object r168 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r168) == true) goto L248;
    L222:
        r141 = r168;
    L248:
        r145 = r141;
        goto L249
    L223:
        String r169 = d.b("debug.shopping.mock.window_search_use_new_path");
        if (r169 != null) goto L226;
    L229:
        boolean r170 = true;
    L230:
        if (r170 == false) goto L320;
    L238:
        r145 = null;
    L239:
        if (r145 != null) goto L249;
        int r171 = p.f45243a;
        Result.Companion r172 = Result.Companion;     // Catch: Throwable -> L245
        b r173 = b.f499326b;     // Catch: Throwable -> L245
        r145 = jj4.a.a("window_search_use_new_path", Boolean.class, r141, false);     // Catch: Throwable -> L245
        if (r145 != null) goto L249;
        Intrinsics.throwNpe();     // Catch: Throwable -> L245
    L245:
        th = move-exception;
        Result.Companion r174 = Result.Companion;
        r168 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r168) == false) goto L222;
    L320:
        r145 = c.f573295a.fromJson(r169, new d0().getType());     // Catch: Exception -> L236
        if (r145 == null) goto L238;
    L236:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L238
    L226:
        if (StringsKt.isBlank(r169) == true) goto L229;
        r170 = false;
    L180:
        th = move-exception;
        Result.Companion r175 = Result.Companion;
        Object r176 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r176) == true) goto L210;
    L184:
        r134 = r176;
    L210:
        r138 = r134;
        goto L211
    L185:
        String r177 = d.b("debug.shopping.mock.window_tags_enable_cache");
        if (r177 != null) goto L188;
    L191:
        boolean r178 = true;
    L192:
        if (r178 == false) goto L340;
    L200:
        r138 = null;
    L201:
        if (r138 != null) goto L211;
        int r179 = p.f45243a;
        Result.Companion r180 = Result.Companion;     // Catch: Throwable -> L207
        b r181 = b.f499326b;     // Catch: Throwable -> L207
        r138 = jj4.a.a("window_tags_enable_cache", Boolean.class, r134, false);     // Catch: Throwable -> L207
        if (r138 != null) goto L211;
        Intrinsics.throwNpe();     // Catch: Throwable -> L207
    L207:
        th = move-exception;
        Result.Companion r182 = Result.Companion;
        r176 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r176) == false) goto L184;
    L340:
        r138 = c.f573295a.fromJson(r177, new i0().getType());     // Catch: Exception -> L198
        if (r138 == null) goto L200;
    L198:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L200
    L188:
        if (StringsKt.isBlank(r177) == true) goto L191;
        r178 = false;
    L142:
        th = move-exception;
        Result.Companion r183 = Result.Companion;
        Object r184 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r184) == true) goto L172;
    L146:
        r127 = r184;
    L172:
        r131 = r127;
        goto L173
    L147:
        String r185 = d.b("debug.shopping.mock.window_dynamic_view_enable_cache");
        if (r185 != null) goto L150;
    L153:
        boolean r186 = true;
    L154:
        if (r186 == false) goto L316;
    L162:
        r131 = null;
    L163:
        if (r131 != null) goto L173;
        int r187 = p.f45243a;
        Result.Companion r188 = Result.Companion;     // Catch: Throwable -> L169
        b r189 = b.f499326b;     // Catch: Throwable -> L169
        r131 = jj4.a.a("window_dynamic_view_enable_cache", Boolean.class, r127, false);     // Catch: Throwable -> L169
        if (r131 != null) goto L173;
        Intrinsics.throwNpe();     // Catch: Throwable -> L169
    L169:
        th = move-exception;
        Result.Companion r190 = Result.Companion;
        r184 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r184) == false) goto L146;
    L316:
        r131 = c.f573295a.fromJson(r185, new n().getType());     // Catch: Exception -> L160
        if (r131 == null) goto L162;
    L160:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L162
    L150:
        if (StringsKt.isBlank(r185) == true) goto L153;
        r186 = false;
        goto L154
    L134:
        r124 = false;
    L101:
        th = move-exception;
        Result.Companion r191 = Result.Companion;
        r123 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r123) == false) goto L132;
    L130:
        r123 = r100;
        goto L132
    L105:
        String r192 = d.b("debug.shopping.mock.window_header_use_list_kit");
        if (r192 != null) goto L108;
    L111:
        boolean r193 = true;
    L112:
        if (r193 == false) goto L346;
    L120:
        r123 = null;
    L121:
        if (r123 != null) goto L132;
        int r194 = p.f45243a;
        Result.Companion r195 = Result.Companion;     // Catch: Throwable -> L127
        b r196 = b.f499326b;     // Catch: Throwable -> L127
        r123 = jj4.a.a("window_header_use_list_kit", Integer.class, r100, false);     // Catch: Throwable -> L127
        if (r123 != null) goto L132;
        Intrinsics.throwNpe();     // Catch: Throwable -> L127
    L127:
        th = move-exception;
        Result.Companion r197 = Result.Companion;
        r123 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r123) == false) goto L132;
    L346:
        r123 = c.f573295a.fromJson(r192, new r().getType());     // Catch: Exception -> L118
        if (r123 == null) goto L120;
    L118:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L120
    L108:
        if (StringsKt.isBlank(r192) == true) goto L111;
        r193 = false;
        goto L112
    L93:
        r119 = false;
    L86:
        th = move-exception;
        Result.Companion r198 = Result.Companion;
        r118 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r118) == false) goto L91;
        r118 = r100;
    L50:
        th = move-exception;
        Result.Companion r199 = Result.Companion;
        Object r200 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r200) == true) goto L80;
    L54:
        r109 = r200;
    L80:
        r113 = r109;
        goto L81
    L55:
        String r201 = d.b("debug.shopping.mock.window_header_transition_duration");
        if (r201 != null) goto L58;
    L61:
        boolean r202 = true;
    L62:
        if (r202 == false) goto L336;
    L70:
        r113 = null;
    L71:
        if (r113 != null) goto L81;
        int r203 = p.f45243a;
        Result.Companion r204 = Result.Companion;     // Catch: Throwable -> L77
        b r205 = b.f499326b;     // Catch: Throwable -> L77
        r113 = jj4.a.a("window_header_transition_duration", Long.class, r109, false);     // Catch: Throwable -> L77
        if (r113 != null) goto L81;
        Intrinsics.throwNpe();     // Catch: Throwable -> L77
    L77:
        th = move-exception;
        Result.Companion r206 = Result.Companion;
        r200 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r200) == false) goto L54;
    L336:
        r113 = c.f573295a.fromJson(r201, new q().getType());     // Catch: Exception -> L68
        if (r113 == null) goto L70;
    L68:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L70
    L58:
        if (StringsKt.isBlank(r201) == true) goto L61;
        r202 = false;
        goto L62
    L42:
        r107 = false;
    L9:
        th = move-exception;
        Result.Companion r207 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r106) == false) goto L40;
    L38:
        r106 = r100;
        goto L40
    L13:
        String r208 = d.b("debug.shopping.mock.window_feed_use_list_kit");
        if (r208 != null) goto L16;
    L19:
        boolean r209 = true;
    L20:
        if (r209 == false) goto L314;
    L28:
        r106 = null;
    L29:
        if (r106 != null) goto L40;
        int r210 = p.f45243a;
        Result.Companion r211 = Result.Companion;     // Catch: Throwable -> L35
        b r212 = b.f499326b;     // Catch: Throwable -> L35
        r106 = jj4.a.a("window_feed_use_list_kit", Integer.class, r100, false);     // Catch: Throwable -> L35
        if (r106 != null) goto L40;
        Intrinsics.throwNpe();     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        Result.Companion r213 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r106) == false) goto L40;
    L314:
        r106 = c.f573295a.fromJson(r208, new k0().getType());     // Catch: Exception -> L26
        if (r106 == null) goto L28;
    L26:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L28
    L16:
        if (StringsKt.isBlank(r208) == true) goto L19;
        r209 = false;
        goto L20
    }

    public static boolean b(Integer r100, int r101) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        if (r100 == null) goto L10;
        if (r100.intValue() <= 100) goto L10;
        return false;
    L10:
        return f188714b;
    }
}
