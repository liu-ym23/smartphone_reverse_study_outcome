package com.bytedance.android.shopping.store.settings;

import com.bytedance.android.ec.ab.opt.HostExperimentKey;
import com.bytedance.android.ec.ab.opt.OptSetting;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.base.settings.d;
import com.bytedance.android.ec.core.opt.ab.n;
import com.bytedance.android.ec.core.opt.ab.p;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.services.apm.api.EnsureManager;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\bA\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\bB\u0010\nR\u0011\u0010\u0005\u001a\u00020\u00028G¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0011\u0010\u0007\u001a\u00020\u00028G¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004R\u001a\u0010\u000b\u001a\u00020\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\b\t\u0010\n\u001a\u0004\b\b\u0010\u0004R\u001a\u0010\u000e\u001a\u00020\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\b\r\u0010\n\u001a\u0004\b\f\u0010\u0004R\u001a\u0010\u0011\u001a\u00020\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\n\u001a\u0004\b\u000f\u0010\u0004R\u001a\u0010\u0014\u001a\u00020\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\n\u001a\u0004\b\u0012\u0010\u0004R\u001a\u0010\u0017\u001a\u00020\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\n\u001a\u0004\b\u0015\u0010\u0004R\u001a\u0010\u001a\u001a\u00020\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\n\u001a\u0004\b\u0018\u0010\u0004R\u001a\u0010\u001d\u001a\u00020\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010\n\u001a\u0004\b\u001b\u0010\u0004R\u001a\u0010 \u001a\u00020\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\n\u001a\u0004\b\u001e\u0010\u0004R\u001a\u0010#\u001a\u00020\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\b\"\u0010\n\u001a\u0004\b!\u0010\u0004R\u001a\u0010&\u001a\u00020\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\b%\u0010\n\u001a\u0004\b$\u0010\u0004R\u001a\u0010)\u001a\u00020\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\b(\u0010\n\u001a\u0004\b'\u0010\u0004R\u001a\u0010,\u001a\u00020\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\b+\u0010\n\u001a\u0004\b*\u0010\u0004R\u001a\u0010/\u001a\u00020\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\b.\u0010\n\u001a\u0004\b-\u0010\u0004R\u001a\u00102\u001a\u00020\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\b1\u0010\n\u001a\u0004\b0\u0010\u0004R\u001a\u00105\u001a\u00020\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\b4\u0010\n\u001a\u0004\b3\u0010\u0004R\u001a\u00108\u001a\u00020\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\b7\u0010\n\u001a\u0004\b6\u0010\u0004R\u001a\u0010;\u001a\u00020\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\b:\u0010\n\u001a\u0004\b9\u0010\u0004R\u001a\u0010>\u001a\u00020\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\b=\u0010\n\u001a\u0004\b<\u0010\u0004R\u001a\u0010A\u001a\u00020\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\b@\u0010\n\u001a\u0004\b?\u0010\u0004¨\u0006C"}, d2 = {"Lcom/bytedance/android/shopping/store/settings/ECShopABSettings;", "", "", "getEC_SHOP_HEADER_UI_OPT", "()I", "EC_SHOP_HEADER_UI_OPT", "getEC_SHOP_POPUP_LAYOUT_INFO", "EC_SHOP_POPUP_LAYOUT_INFO", "getEC_SHOP_SLICE_HEADER", "getEC_SHOP_SLICE_HEADER$annotations", "()V", "EC_SHOP_SLICE_HEADER", "getEC_SHOP_SELL_POINT_OPTIMIZE", "getEC_SHOP_SELL_POINT_OPTIMIZE$annotations", "EC_SHOP_SELL_POINT_OPTIMIZE", "getSHOP_SWITCH_TOP_SEARCH_INFO", "getSHOP_SWITCH_TOP_SEARCH_INFO$annotations", "SHOP_SWITCH_TOP_SEARCH_INFO", "getEC_SHOP_ACTIVITY_CHANGE", "getEC_SHOP_ACTIVITY_CHANGE$annotations", "EC_SHOP_ACTIVITY_CHANGE", "getEC_SHOP_CARD_PACK", "getEC_SHOP_CARD_PACK$annotations", "EC_SHOP_CARD_PACK", "getEC_SHOP_PRODUCT_BOTTOM_CARDPACK", "getEC_SHOP_PRODUCT_BOTTOM_CARDPACK$annotations", "EC_SHOP_PRODUCT_BOTTOM_CARDPACK", "getEC_SHOP_CARD_PACK_FORCE_LOCAL", "getEC_SHOP_CARD_PACK_FORCE_LOCAL$annotations", "EC_SHOP_CARD_PACK_FORCE_LOCAL", "getEC_SHOP_SEARCH_HOT_WORD_SCROLL", "getEC_SHOP_SEARCH_HOT_WORD_SCROLL$annotations", "EC_SHOP_SEARCH_HOT_WORD_SCROLL", "getEC_SHOP_SEARCH_GUIDE_STYLE", "getEC_SHOP_SEARCH_GUIDE_STYLE$annotations", "EC_SHOP_SEARCH_GUIDE_STYLE", "getEC_SHOP_SEARCH_BAR_UI_OPTIMIZE", "getEC_SHOP_SEARCH_BAR_UI_OPTIMIZE$annotations", "EC_SHOP_SEARCH_BAR_UI_OPTIMIZE", "getEC_SHOP_MIDDLE_TAB_FRAMEWORK_OPT", "getEC_SHOP_MIDDLE_TAB_FRAMEWORK_OPT$annotations", "EC_SHOP_MIDDLE_TAB_FRAMEWORK_OPT", "getEC_SHOP_FRAMEWORK_OPT_V2", "getEC_SHOP_FRAMEWORK_OPT_V2$annotations", "EC_SHOP_FRAMEWORK_OPT_V2", "getEC_SHOP_CLASSIFY_FILTER_TAB", "getEC_SHOP_CLASSIFY_FILTER_TAB$annotations", "EC_SHOP_CLASSIFY_FILTER_TAB", "getEC_SHOP_SEARCH_HINT_GRADIENT", "getEC_SHOP_SEARCH_HINT_GRADIENT$annotations", "EC_SHOP_SEARCH_HINT_GRADIENT", "getEC_SHOP_SLICE_PRODUCT_FILTER", "getEC_SHOP_SLICE_PRODUCT_FILTER$annotations", "EC_SHOP_SLICE_PRODUCT_FILTER", "getEC_SHOP_BRAND_SHOP_UI_UPGRADE", "getEC_SHOP_BRAND_SHOP_UI_UPGRADE$annotations", "EC_SHOP_BRAND_SHOP_UI_UPGRADE", "getEC_SHOP_MINI_WINDOW_ANIM_OPT", "getEC_SHOP_MINI_WINDOW_ANIM_OPT$annotations", "EC_SHOP_MINI_WINDOW_ANIM_OPT", "getEC_SHOP_RECOMMEND_PAGE_OPT", "getEC_SHOP_RECOMMEND_PAGE_OPT$annotations", "EC_SHOP_RECOMMEND_PAGE_OPT", "getEC_SHOP_TAB_INTERACTION_OPT", "getEC_SHOP_TAB_INTERACTION_OPT$annotations", "EC_SHOP_TAB_INTERACTION_OPT", "<init>", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
@OptSetting(business = "店铺AB实验参数")
public final class ECShopABSettings {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Object> f186138a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Integer f186139b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile boolean f186140c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f186141d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f186142e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy f186143f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Lazy f186144g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Lazy f186145h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Lazy f186146i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Lazy f186147j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final ECShopABSettings f186148k = null;

    public ECShopABSettings() {
    }

    @HostExperimentKey(author = "zhengjiali", desc = "券体验优化")
    @SettingReport
    public static final int a() {
        Object r100 = 0;
        Object r101 = null;
        if (Intrinsics.areEqual("ec_shop_coupon_style", "ec_shop_launch_opt_common_2") == false) goto L179;
        if (f186139b != null) goto L173;
        int r102 = n.f45241a;
        int r103 = com.bytedance.android.ec.base.settings.a.f42813a;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L163
        Object r105 = d.f42818c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L57
        if (r105 != null) goto L12;
    L54:
        Object r106 = null;
    L55:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L57
    L59:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);     // Catch: Throwable -> L163
        if (r108 == null) goto L63;
        EnsureManager.ensureNotReachHere(r108);     // Catch: Throwable -> L163
    L63:
        if (Result.m9455isFailureimpl(r107) == false) goto L66;
        r107 = null;
    L66:
        if ((r107 instanceof Integer) == true) goto L68;
        r107 = null;
    L68:
        Object r109 = (Integer) r107;     // Catch: Throwable -> L163
        if (r109 != null) goto L75;
        Object r110 = d.f42816a.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L163
        if ((r110 instanceof Integer) == true) goto L74;
        r110 = null;
    L74:
        r109 = (Integer) r110;     // Catch: Throwable -> L163
    L75:
        if (r109 != null) goto L172;
        int r111 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L163
        Object r112 = d.f42818c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L127
        if (r112 != null) goto L82;
    L124:
        Object r113 = null;
    L125:
        Object r114 = Result.m9449constructorimpl(r113);     // Catch: Throwable -> L127
    L129:
        Throwable r115 = Result.m9452exceptionOrNullimpl(r114);     // Catch: Throwable -> L154
        if (r115 == null) goto L133;
        EnsureManager.ensureNotReachHere(r115);     // Catch: Throwable -> L154
    L133:
        if (Result.m9455isFailureimpl(r114) == false) goto L136;
        r114 = null;
    L136:
        if ((r114 instanceof Integer) == true) goto L138;
        r114 = null;
    L138:
        r109 = (Integer) r114;     // Catch: Throwable -> L154
        if (r109 != null) goto L161;
        IHybridHostService r116 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L154
        if (r116 == null) goto L144;
        Object r117 = r116.getHostABValue("ec_shop_launch_opt_common_2", r100);     // Catch: Throwable -> L154
    L145:
        if (r117 != null) goto L147;
    L160:
        r109 = r100;
        goto L161
    L147:
        if ((r117 instanceof Integer) == false) goto L150;
        r101 = r117;
    L150:
        Integer r118 = (Integer) r101;     // Catch: Throwable -> L154
        if (r118 == null) goto L160;
        r109 = r118;
        goto L161
    L154:
        th = move-exception;
        Result.Companion r119 = Result.Companion;     // Catch: Throwable -> L163
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
        Throwable r120 = Result.m9452exceptionOrNullimpl(r109);     // Catch: Throwable -> L163
        if (r120 == null) goto L159;
        EnsureManager.ensureNotReachHere(r120);     // Catch: Throwable -> L163
    L159:
        if (Result.m9455isFailureimpl(r109) == false) goto L161;
    L144:
        r117 = null;
    L161:
        d.d("ec_shop_launch_opt_common_2", r109);     // Catch: Throwable -> L163
        goto L172
    L82:
        if ((r112 instanceof Integer) == true) goto L84;
        Object r121 = null;
    L85:
        r113 = (Integer) r121;     // Catch: Throwable -> L127
        if (r113 != null) goto L125;
        if ((r112 instanceof Number) == false) goto L112;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r122 = Float.valueOf(((Number) r112).floatValue());     // Catch: Throwable -> L127
        if ((r122 instanceof Integer) == true) goto L95;
        r122 = null;
    L95:
        r113 = (Integer) r122;     // Catch: Throwable -> L127
        goto L125
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r123 = Double.valueOf(((Number) r112).doubleValue());     // Catch: Throwable -> L127
        if ((r123 instanceof Integer) == true) goto L101;
        r123 = null;
    L101:
        r113 = (Integer) r123;     // Catch: Throwable -> L127
        goto L125
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L106;
        r113 = Integer.valueOf(((Number) r112).intValue());     // Catch: Throwable -> L127
        goto L125
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L112;
        Long r124 = Long.valueOf(((Number) r112).longValue());     // Catch: Throwable -> L127
        if ((r124 instanceof Integer) == true) goto L110;
        r124 = null;
    L110:
        r113 = (Integer) r124;     // Catch: Throwable -> L127
    L112:
        if ((r112 instanceof JSONObject) == false) goto L114;
    L366:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L120
        Object r125 = SDKSettingsCacheManager.a().fromJson(r112.toString(), Integer.class);     // Catch: Throwable -> L120
        if ((r125 instanceof Integer) == true) goto L118;
        r125 = null;
    L118:
        Object r126 = Result.m9449constructorimpl((Integer) r125);     // Catch: Throwable -> L120
    L122:
        r113 = r126;
        if (Result.m9455isFailureimpl(r113) == false) goto L125;
    L120:
        th = move-exception;
        Result.Companion r127 = Result.Companion;     // Catch: Throwable -> L127
        r126 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L127
        goto L122
    L114:
        if ((r112 instanceof JSONArray) == false) goto L124;
    L84:
        r121 = r112;
    L127:
        th = move-exception;
        Result.Companion r128 = Result.Companion;     // Catch: Throwable -> L154
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L154
    L172:
        f186139b = (Integer) r109;
        goto L173
    L12:
        if ((r105 instanceof Integer) == true) goto L14;
        Object r129 = null;
    L15:
        r106 = (Integer) r129;     // Catch: Throwable -> L57
        if (r106 != null) goto L55;
        if ((r105 instanceof Number) == false) goto L42;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L27;
        Float r130 = Float.valueOf(((Number) r105).floatValue());     // Catch: Throwable -> L57
        if ((r130 instanceof Integer) == true) goto L25;
        r130 = null;
    L25:
        r106 = (Integer) r130;     // Catch: Throwable -> L57
        goto L55
    L27:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L33;
        Double r131 = Double.valueOf(((Number) r105).doubleValue());     // Catch: Throwable -> L57
        if ((r131 instanceof Integer) == true) goto L31;
        r131 = null;
    L31:
        r106 = (Integer) r131;     // Catch: Throwable -> L57
        goto L55
    L33:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L36;
        r106 = Integer.valueOf(((Number) r105).intValue());     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L42;
        Long r132 = Long.valueOf(((Number) r105).longValue());     // Catch: Throwable -> L57
        if ((r132 instanceof Integer) == true) goto L40;
        r132 = null;
    L40:
        r106 = (Integer) r132;     // Catch: Throwable -> L57
    L42:
        if ((r105 instanceof JSONObject) == false) goto L44;
    L364:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L50
        Object r133 = SDKSettingsCacheManager.a().fromJson(r105.toString(), Integer.class);     // Catch: Throwable -> L50
        if ((r133 instanceof Integer) == true) goto L48;
        r133 = null;
    L48:
        Object r134 = Result.m9449constructorimpl((Integer) r133);     // Catch: Throwable -> L50
    L52:
        r106 = r134;
        if (Result.m9455isFailureimpl(r106) == false) goto L55;
    L50:
        th = move-exception;
        Result.Companion r135 = Result.Companion;     // Catch: Throwable -> L57
        r134 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L52
    L44:
        if ((r105 instanceof JSONArray) == false) goto L54;
    L14:
        r129 = r105;
    L57:
        th = move-exception;
        Result.Companion r136 = Result.Companion;     // Catch: Throwable -> L163
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
    L163:
        th = move-exception;
        Result.Companion r137 = Result.Companion;
        Object r138 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r139 = Result.m9452exceptionOrNullimpl(r138);
        if (r139 == null) goto L168;
        EnsureManager.ensureNotReachHere(r139);
    L168:
        if (Result.m9455isFailureimpl(r138) == true) goto L171;
        r100 = r138;
    L171:
        r109 = r100;
    L173:
        Object r140 = f186139b;
        if (r140 == null) goto L177;
    L354:
        f186138a.put("ec_shop_coupon_style", r140);
        return ((Number) r140).intValue();
    L177:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L179:
        if (Intrinsics.areEqual("HostExperiment", "ShopSetting") == false) goto L190;
        int r141 = p.f45243a;
        Result.Companion r142 = Result.Companion;     // Catch: Throwable -> L185
        jj4.b r143 = jj4.b.f499326b;     // Catch: Throwable -> L185
        r140 = jj4.a.a("ec_shop_coupon_style", Integer.class, r100, false);     // Catch: Throwable -> L185
        if (r140 != null) goto L354;
        Intrinsics.throwNpe();     // Catch: Throwable -> L185
    L185:
        th = move-exception;
        Result.Companion r144 = Result.Companion;
        Object r145 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r145) == true) goto L353;
    L189:
        r100 = r145;
    L353:
        r140 = r100;
        goto L354
    L190:
        int r146 = n.f45241a;
        int r147 = com.bytedance.android.ec.base.settings.a.f42813a;
        Result.Companion r148 = Result.Companion;     // Catch: Throwable -> L347
        Object r149 = d.f42818c.get("ec_shop_coupon_style");     // Catch: Throwable -> L241
        if (r149 != null) goto L196;
    L238:
        Object r150 = null;
    L239:
        Object r151 = Result.m9449constructorimpl(r150);     // Catch: Throwable -> L241
    L243:
        Throwable r152 = Result.m9452exceptionOrNullimpl(r151);     // Catch: Throwable -> L347
        if (r152 == null) goto L247;
        EnsureManager.ensureNotReachHere(r152);     // Catch: Throwable -> L347
    L247:
        if (Result.m9455isFailureimpl(r151) == false) goto L250;
        r151 = null;
    L250:
        if ((r151 instanceof Integer) == true) goto L252;
        r151 = null;
    L252:
        r140 = (Integer) r151;     // Catch: Throwable -> L347
        if (r140 != null) goto L259;
        Object r153 = d.f42816a.get("ec_shop_coupon_style");     // Catch: Throwable -> L347
        if ((r153 instanceof Integer) == true) goto L258;
        r153 = null;
    L258:
        r140 = (Integer) r153;     // Catch: Throwable -> L347
    L259:
        if (r140 != null) goto L354;
        int r154 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L347
        Object r155 = d.f42818c.get("ec_shop_coupon_style");     // Catch: Throwable -> L311
        if (r155 != null) goto L266;
    L308:
        Object r156 = null;
    L309:
        Object r157 = Result.m9449constructorimpl(r156);     // Catch: Throwable -> L311
    L313:
        Throwable r158 = Result.m9452exceptionOrNullimpl(r157);     // Catch: Throwable -> L338
        if (r158 == null) goto L317;
        EnsureManager.ensureNotReachHere(r158);     // Catch: Throwable -> L338
    L317:
        if (Result.m9455isFailureimpl(r157) == false) goto L320;
        r157 = null;
    L320:
        if ((r157 instanceof Integer) == true) goto L322;
        r157 = null;
    L322:
        r140 = (Integer) r157;     // Catch: Throwable -> L338
        if (r140 != null) goto L345;
        IHybridHostService r159 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L338
        if (r159 == null) goto L328;
        Object r160 = r159.getHostABValue("ec_shop_coupon_style", r100);     // Catch: Throwable -> L338
    L329:
        if (r160 != null) goto L331;
    L344:
        r140 = r100;
        goto L345
    L331:
        if ((r160 instanceof Integer) == false) goto L334;
        r101 = r160;
    L334:
        Integer r161 = (Integer) r101;     // Catch: Throwable -> L338
        if (r161 == null) goto L344;
        r140 = r161;
        goto L345
    L338:
        th = move-exception;
        Result.Companion r162 = Result.Companion;     // Catch: Throwable -> L347
        r140 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L347
        Throwable r163 = Result.m9452exceptionOrNullimpl(r140);     // Catch: Throwable -> L347
        if (r163 == null) goto L343;
        EnsureManager.ensureNotReachHere(r163);     // Catch: Throwable -> L347
    L343:
        if (Result.m9455isFailureimpl(r140) == false) goto L345;
    L328:
        r160 = null;
    L345:
        d.d("ec_shop_coupon_style", r140);     // Catch: Throwable -> L347
        goto L354
    L266:
        if ((r155 instanceof Integer) == true) goto L268;
        Object r164 = null;
    L269:
        r156 = (Integer) r164;     // Catch: Throwable -> L311
        if (r156 != null) goto L309;
        if ((r155 instanceof Number) == false) goto L296;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L281;
        Float r165 = Float.valueOf(((Number) r155).floatValue());     // Catch: Throwable -> L311
        if ((r165 instanceof Integer) == true) goto L279;
        r165 = null;
    L279:
        r156 = (Integer) r165;     // Catch: Throwable -> L311
        goto L309
    L281:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L287;
        Double r166 = Double.valueOf(((Number) r155).doubleValue());     // Catch: Throwable -> L311
        if ((r166 instanceof Integer) == true) goto L285;
        r166 = null;
    L285:
        r156 = (Integer) r166;     // Catch: Throwable -> L311
        goto L309
    L287:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L290;
        r156 = Integer.valueOf(((Number) r155).intValue());     // Catch: Throwable -> L311
        goto L309
    L290:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L296;
        Long r167 = Long.valueOf(((Number) r155).longValue());     // Catch: Throwable -> L311
        if ((r167 instanceof Integer) == true) goto L294;
        r167 = null;
    L294:
        r156 = (Integer) r167;     // Catch: Throwable -> L311
    L296:
        if ((r155 instanceof JSONObject) == false) goto L298;
    L380:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L304
        Object r168 = SDKSettingsCacheManager.a().fromJson(r155.toString(), Integer.class);     // Catch: Throwable -> L304
        if ((r168 instanceof Integer) == true) goto L302;
        r168 = null;
    L302:
        Object r169 = Result.m9449constructorimpl((Integer) r168);     // Catch: Throwable -> L304
    L306:
        r156 = r169;
        if (Result.m9455isFailureimpl(r156) == false) goto L309;
    L304:
        th = move-exception;
        Result.Companion r170 = Result.Companion;     // Catch: Throwable -> L311
        r169 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L311
        goto L306
    L298:
        if ((r155 instanceof JSONArray) == false) goto L308;
    L268:
        r164 = r155;
    L311:
        th = move-exception;
        Result.Companion r171 = Result.Companion;     // Catch: Throwable -> L338
        r157 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L338
        goto L313
    L196:
        if ((r149 instanceof Integer) == true) goto L198;
        Object r172 = null;
    L199:
        r150 = (Integer) r172;     // Catch: Throwable -> L241
        if (r150 != null) goto L239;
        if ((r149 instanceof Number) == false) goto L226;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L211;
        Float r173 = Float.valueOf(((Number) r149).floatValue());     // Catch: Throwable -> L241
        if ((r173 instanceof Integer) == true) goto L209;
        r173 = null;
    L209:
        r150 = (Integer) r173;     // Catch: Throwable -> L241
        goto L239
    L211:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L217;
        Double r174 = Double.valueOf(((Number) r149).doubleValue());     // Catch: Throwable -> L241
        if ((r174 instanceof Integer) == true) goto L215;
        r174 = null;
    L215:
        r150 = (Integer) r174;     // Catch: Throwable -> L241
        goto L239
    L217:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L220;
        r150 = Integer.valueOf(((Number) r149).intValue());     // Catch: Throwable -> L241
        goto L239
    L220:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L226;
        Long r175 = Long.valueOf(((Number) r149).longValue());     // Catch: Throwable -> L241
        if ((r175 instanceof Integer) == true) goto L224;
        r175 = null;
    L224:
        r150 = (Integer) r175;     // Catch: Throwable -> L241
    L226:
        if ((r149 instanceof JSONObject) == false) goto L228;
    L378:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L234
        Object r176 = SDKSettingsCacheManager.a().fromJson(r149.toString(), Integer.class);     // Catch: Throwable -> L234
        if ((r176 instanceof Integer) == true) goto L232;
        r176 = null;
    L232:
        Object r177 = Result.m9449constructorimpl((Integer) r176);     // Catch: Throwable -> L234
    L236:
        r150 = r177;
        if (Result.m9455isFailureimpl(r150) == false) goto L239;
    L234:
        th = move-exception;
        Result.Companion r178 = Result.Companion;     // Catch: Throwable -> L241
        r177 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L241
        goto L236
    L228:
        if ((r149 instanceof JSONArray) == false) goto L238;
    L198:
        r172 = r149;
    L241:
        th = move-exception;
        Result.Companion r179 = Result.Companion;     // Catch: Throwable -> L347
        r151 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L347
    L347:
        th = move-exception;
        Result.Companion r180 = Result.Companion;
        r145 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r181 = Result.m9452exceptionOrNullimpl(r145);
        if (r181 == null) goto L352;
        EnsureManager.ensureNotReachHere(r181);
    L352:
        if (Result.m9455isFailureimpl(r145) == false) goto L189;
        goto L189
    }

    public static boolean c() {
        return ((Boolean) f186141d.getValue()).booleanValue();
    }

    @HostExperimentKey(author = "chenlong,hz", desc = "店铺大字适配")
    public static final int d() {
        Object r100 = 1;
        Object r101 = null;
        if (Intrinsics.areEqual("ec_shop_adapt_font_size", "ec_shop_launch_opt_common_2") == false) goto L179;
        if (f186139b != null) goto L173;
        int r102 = n.f45241a;
        Object r103 = 0;
        int r104 = com.bytedance.android.ec.base.settings.a.f42813a;
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L163
        Object r106 = d.f42818c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L57
        if (r106 != null) goto L12;
    L54:
        Object r107 = null;
    L55:
        Object r108 = Result.m9449constructorimpl(r107);     // Catch: Throwable -> L57
    L59:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);     // Catch: Throwable -> L163
        if (r109 == null) goto L63;
        EnsureManager.ensureNotReachHere(r109);     // Catch: Throwable -> L163
    L63:
        if (Result.m9455isFailureimpl(r108) == false) goto L66;
        r108 = null;
    L66:
        if ((r108 instanceof Integer) == true) goto L68;
        r108 = null;
    L68:
        Object r110 = (Integer) r108;     // Catch: Throwable -> L163
        if (r110 != null) goto L75;
        Object r111 = d.f42816a.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L163
        if ((r111 instanceof Integer) == true) goto L74;
        r111 = null;
    L74:
        r110 = (Integer) r111;     // Catch: Throwable -> L163
    L75:
        if (r110 != null) goto L172;
        int r112 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L163
        Object r113 = d.f42818c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L127
        if (r113 != null) goto L82;
    L124:
        Object r114 = null;
    L125:
        Object r115 = Result.m9449constructorimpl(r114);     // Catch: Throwable -> L127
    L129:
        Throwable r116 = Result.m9452exceptionOrNullimpl(r115);     // Catch: Throwable -> L154
        if (r116 == null) goto L133;
        EnsureManager.ensureNotReachHere(r116);     // Catch: Throwable -> L154
    L133:
        if (Result.m9455isFailureimpl(r115) == false) goto L136;
        r115 = null;
    L136:
        if ((r115 instanceof Integer) == true) goto L138;
        r115 = null;
    L138:
        r110 = (Integer) r115;     // Catch: Throwable -> L154
        if (r110 != null) goto L161;
        IHybridHostService r117 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L154
        if (r117 == null) goto L144;
        Object r118 = r117.getHostABValue("ec_shop_launch_opt_common_2", r103);     // Catch: Throwable -> L154
    L145:
        if (r118 != null) goto L147;
    L160:
        r110 = r103;
        goto L161
    L147:
        if ((r118 instanceof Integer) == false) goto L150;
        r101 = r118;
    L150:
        Integer r119 = (Integer) r101;     // Catch: Throwable -> L154
        if (r119 == null) goto L160;
        r110 = r119;
        goto L161
    L154:
        th = move-exception;
        Result.Companion r120 = Result.Companion;     // Catch: Throwable -> L163
        r110 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
        Throwable r121 = Result.m9452exceptionOrNullimpl(r110);     // Catch: Throwable -> L163
        if (r121 == null) goto L159;
        EnsureManager.ensureNotReachHere(r121);     // Catch: Throwable -> L163
    L159:
        if (Result.m9455isFailureimpl(r110) == false) goto L161;
    L144:
        r118 = null;
    L161:
        d.d("ec_shop_launch_opt_common_2", r110);     // Catch: Throwable -> L163
        goto L172
    L82:
        if ((r113 instanceof Integer) == true) goto L84;
        Object r122 = null;
    L85:
        r114 = (Integer) r122;     // Catch: Throwable -> L127
        if (r114 != null) goto L125;
        if ((r113 instanceof Number) == false) goto L112;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r123 = Float.valueOf(((Number) r113).floatValue());     // Catch: Throwable -> L127
        if ((r123 instanceof Integer) == true) goto L95;
        r123 = null;
    L95:
        r114 = (Integer) r123;     // Catch: Throwable -> L127
        goto L125
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r124 = Double.valueOf(((Number) r113).doubleValue());     // Catch: Throwable -> L127
        if ((r124 instanceof Integer) == true) goto L101;
        r124 = null;
    L101:
        r114 = (Integer) r124;     // Catch: Throwable -> L127
        goto L125
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L106;
        r114 = Integer.valueOf(((Number) r113).intValue());     // Catch: Throwable -> L127
        goto L125
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L112;
        Long r125 = Long.valueOf(((Number) r113).longValue());     // Catch: Throwable -> L127
        if ((r125 instanceof Integer) == true) goto L110;
        r125 = null;
    L110:
        r114 = (Integer) r125;     // Catch: Throwable -> L127
    L112:
        if ((r113 instanceof JSONObject) == false) goto L114;
    L364:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L120
        Object r126 = SDKSettingsCacheManager.a().fromJson(r113.toString(), Integer.class);     // Catch: Throwable -> L120
        if ((r126 instanceof Integer) == true) goto L118;
        r126 = null;
    L118:
        Object r127 = Result.m9449constructorimpl((Integer) r126);     // Catch: Throwable -> L120
    L122:
        r114 = r127;
        if (Result.m9455isFailureimpl(r114) == false) goto L125;
    L120:
        th = move-exception;
        Result.Companion r128 = Result.Companion;     // Catch: Throwable -> L127
        r127 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L127
        goto L122
    L114:
        if ((r113 instanceof JSONArray) == false) goto L124;
    L84:
        r122 = r113;
    L127:
        th = move-exception;
        Result.Companion r129 = Result.Companion;     // Catch: Throwable -> L154
        r115 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L154
    L172:
        f186139b = (Integer) r110;
        goto L173
    L12:
        if ((r106 instanceof Integer) == true) goto L14;
        Object r130 = null;
    L15:
        r107 = (Integer) r130;     // Catch: Throwable -> L57
        if (r107 != null) goto L55;
        if ((r106 instanceof Number) == false) goto L42;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L27;
        Float r131 = Float.valueOf(((Number) r106).floatValue());     // Catch: Throwable -> L57
        if ((r131 instanceof Integer) == true) goto L25;
        r131 = null;
    L25:
        r107 = (Integer) r131;     // Catch: Throwable -> L57
        goto L55
    L27:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L33;
        Double r132 = Double.valueOf(((Number) r106).doubleValue());     // Catch: Throwable -> L57
        if ((r132 instanceof Integer) == true) goto L31;
        r132 = null;
    L31:
        r107 = (Integer) r132;     // Catch: Throwable -> L57
        goto L55
    L33:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L36;
        r107 = Integer.valueOf(((Number) r106).intValue());     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L42;
        Long r133 = Long.valueOf(((Number) r106).longValue());     // Catch: Throwable -> L57
        if ((r133 instanceof Integer) == true) goto L40;
        r133 = null;
    L40:
        r107 = (Integer) r133;     // Catch: Throwable -> L57
    L42:
        if ((r106 instanceof JSONObject) == false) goto L44;
    L362:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L50
        Object r134 = SDKSettingsCacheManager.a().fromJson(r106.toString(), Integer.class);     // Catch: Throwable -> L50
        if ((r134 instanceof Integer) == true) goto L48;
        r134 = null;
    L48:
        Object r135 = Result.m9449constructorimpl((Integer) r134);     // Catch: Throwable -> L50
    L52:
        r107 = r135;
        if (Result.m9455isFailureimpl(r107) == false) goto L55;
    L50:
        th = move-exception;
        Result.Companion r136 = Result.Companion;     // Catch: Throwable -> L57
        r135 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L52
    L44:
        if ((r106 instanceof JSONArray) == false) goto L54;
    L14:
        r130 = r106;
    L57:
        th = move-exception;
        Result.Companion r137 = Result.Companion;     // Catch: Throwable -> L163
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
    L163:
        th = move-exception;
        Result.Companion r138 = Result.Companion;
        Object r139 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r140 = Result.m9452exceptionOrNullimpl(r139);
        if (r140 == null) goto L168;
        EnsureManager.ensureNotReachHere(r140);
    L168:
        if (Result.m9455isFailureimpl(r139) == true) goto L171;
        r103 = r139;
    L171:
        r110 = r103;
    L173:
        r100 = f186139b;
        if (r100 == null) goto L177;
    L352:
        f186138a.put("ec_shop_adapt_font_size", r100);
        return ((Number) r100).intValue();
    L177:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L179:
        if (Intrinsics.areEqual("HostExperiment", "ShopSetting") == false) goto L190;
        int r141 = p.f45243a;
        Result.Companion r142 = Result.Companion;     // Catch: Throwable -> L185
        jj4.b r143 = jj4.b.f499326b;     // Catch: Throwable -> L185
        Object r144 = jj4.a.a("ec_shop_adapt_font_size", Integer.class, r100, false);     // Catch: Throwable -> L185
        if (r144 != null) goto L189;
        Intrinsics.throwNpe();     // Catch: Throwable -> L185
    L189:
        r100 = r144;
    L185:
        th = move-exception;
        Result.Companion r145 = Result.Companion;
        r144 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r144) == false) goto L189;
    L190:
        int r146 = n.f45241a;
        int r147 = com.bytedance.android.ec.base.settings.a.f42813a;
        Result.Companion r148 = Result.Companion;     // Catch: Throwable -> L346
        Object r149 = d.f42818c.get("ec_shop_adapt_font_size");     // Catch: Throwable -> L241
        if (r149 != null) goto L196;
    L238:
        Object r150 = null;
    L239:
        Object r151 = Result.m9449constructorimpl(r150);     // Catch: Throwable -> L241
    L243:
        Throwable r152 = Result.m9452exceptionOrNullimpl(r151);     // Catch: Throwable -> L346
        if (r152 == null) goto L247;
        EnsureManager.ensureNotReachHere(r152);     // Catch: Throwable -> L346
    L247:
        if (Result.m9455isFailureimpl(r151) == false) goto L250;
        r151 = null;
    L250:
        if ((r151 instanceof Integer) == true) goto L252;
        r151 = null;
    L252:
        r144 = (Integer) r151;     // Catch: Throwable -> L346
        if (r144 != null) goto L259;
        Object r153 = d.f42816a.get("ec_shop_adapt_font_size");     // Catch: Throwable -> L346
        if ((r153 instanceof Integer) == true) goto L258;
        r153 = null;
    L258:
        r144 = (Integer) r153;     // Catch: Throwable -> L346
    L259:
        if (r144 != null) goto L189;
        int r154 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L346
        Object r155 = d.f42818c.get("ec_shop_adapt_font_size");     // Catch: Throwable -> L311
        if (r155 != null) goto L266;
    L308:
        Object r156 = null;
    L309:
        Object r157 = Result.m9449constructorimpl(r156);     // Catch: Throwable -> L311
    L313:
        Throwable r158 = Result.m9452exceptionOrNullimpl(r157);     // Catch: Throwable -> L337
        if (r158 == null) goto L317;
        EnsureManager.ensureNotReachHere(r158);     // Catch: Throwable -> L337
    L317:
        if (Result.m9455isFailureimpl(r157) == false) goto L320;
        r157 = null;
    L320:
        if ((r157 instanceof Integer) == true) goto L322;
        r157 = null;
    L322:
        r144 = (Integer) r157;     // Catch: Throwable -> L337
        if (r144 != null) goto L344;
        IHybridHostService r159 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L337
        if (r159 == null) goto L328;
        Object r160 = r159.getHostABValue("ec_shop_adapt_font_size", r100);     // Catch: Throwable -> L337
    L329:
        if (r160 != null) goto L331;
    L343:
        r144 = r100;
        goto L344
    L331:
        if ((r160 instanceof Integer) == false) goto L334;
        r101 = r160;
    L334:
        r144 = (Integer) r101;     // Catch: Throwable -> L337
        if (r144 != null) goto L344;
    L328:
        r160 = null;
    L344:
        d.d("ec_shop_adapt_font_size", r144);     // Catch: Throwable -> L346
        goto L189
    L266:
        if ((r155 instanceof Integer) == true) goto L268;
        Object r161 = null;
    L269:
        r156 = (Integer) r161;     // Catch: Throwable -> L311
        if (r156 != null) goto L309;
        if ((r155 instanceof Number) == false) goto L296;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L281;
        Float r162 = Float.valueOf(((Number) r155).floatValue());     // Catch: Throwable -> L311
        if ((r162 instanceof Integer) == true) goto L279;
        r162 = null;
    L279:
        r156 = (Integer) r162;     // Catch: Throwable -> L311
        goto L309
    L281:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L287;
        Double r163 = Double.valueOf(((Number) r155).doubleValue());     // Catch: Throwable -> L311
        if ((r163 instanceof Integer) == true) goto L285;
        r163 = null;
    L285:
        r156 = (Integer) r163;     // Catch: Throwable -> L311
        goto L309
    L287:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L290;
        r156 = Integer.valueOf(((Number) r155).intValue());     // Catch: Throwable -> L311
        goto L309
    L290:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L296;
        Long r164 = Long.valueOf(((Number) r155).longValue());     // Catch: Throwable -> L311
        if ((r164 instanceof Integer) == true) goto L294;
        r164 = null;
    L294:
        r156 = (Integer) r164;     // Catch: Throwable -> L311
    L296:
        if ((r155 instanceof JSONObject) == false) goto L298;
    L377:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L304
        Object r165 = SDKSettingsCacheManager.a().fromJson(r155.toString(), Integer.class);     // Catch: Throwable -> L304
        if ((r165 instanceof Integer) == true) goto L302;
        r165 = null;
    L302:
        Object r166 = Result.m9449constructorimpl((Integer) r165);     // Catch: Throwable -> L304
    L306:
        r156 = r166;
        if (Result.m9455isFailureimpl(r156) == false) goto L309;
    L304:
        th = move-exception;
        Result.Companion r167 = Result.Companion;     // Catch: Throwable -> L311
        r166 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L311
        goto L306
    L298:
        if ((r155 instanceof JSONArray) == false) goto L308;
    L268:
        r161 = r155;
    L337:
        th = move-exception;
        Result.Companion r168 = Result.Companion;     // Catch: Throwable -> L346
        r144 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L346
        Throwable r169 = Result.m9452exceptionOrNullimpl(r144);     // Catch: Throwable -> L346
        if (r169 == null) goto L342;
        EnsureManager.ensureNotReachHere(r169);     // Catch: Throwable -> L346
    L342:
        if (Result.m9455isFailureimpl(r144) == false) goto L344;
    L311:
        th = move-exception;
        Result.Companion r170 = Result.Companion;     // Catch: Throwable -> L337
        r157 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L337
        goto L313
    L196:
        if ((r149 instanceof Integer) == true) goto L198;
        Object r171 = null;
    L199:
        r150 = (Integer) r171;     // Catch: Throwable -> L241
        if (r150 != null) goto L239;
        if ((r149 instanceof Number) == false) goto L226;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L211;
        Float r172 = Float.valueOf(((Number) r149).floatValue());     // Catch: Throwable -> L241
        if ((r172 instanceof Integer) == true) goto L209;
        r172 = null;
    L209:
        r150 = (Integer) r172;     // Catch: Throwable -> L241
        goto L239
    L211:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L217;
        Double r173 = Double.valueOf(((Number) r149).doubleValue());     // Catch: Throwable -> L241
        if ((r173 instanceof Integer) == true) goto L215;
        r173 = null;
    L215:
        r150 = (Integer) r173;     // Catch: Throwable -> L241
        goto L239
    L217:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L220;
        r150 = Integer.valueOf(((Number) r149).intValue());     // Catch: Throwable -> L241
        goto L239
    L220:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L226;
        Long r174 = Long.valueOf(((Number) r149).longValue());     // Catch: Throwable -> L241
        if ((r174 instanceof Integer) == true) goto L224;
        r174 = null;
    L224:
        r150 = (Integer) r174;     // Catch: Throwable -> L241
    L226:
        if ((r149 instanceof JSONObject) == false) goto L228;
    L375:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L234
        Object r175 = SDKSettingsCacheManager.a().fromJson(r149.toString(), Integer.class);     // Catch: Throwable -> L234
        if ((r175 instanceof Integer) == true) goto L232;
        r175 = null;
    L232:
        Object r176 = Result.m9449constructorimpl((Integer) r175);     // Catch: Throwable -> L234
    L236:
        r150 = r176;
        if (Result.m9455isFailureimpl(r150) == false) goto L239;
    L234:
        th = move-exception;
        Result.Companion r177 = Result.Companion;     // Catch: Throwable -> L241
        r176 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L241
        goto L236
    L228:
        if ((r149 instanceof JSONArray) == false) goto L238;
    L198:
        r171 = r149;
    L241:
        th = move-exception;
        Result.Companion r178 = Result.Companion;     // Catch: Throwable -> L346
        r151 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L346
    L346:
        th = move-exception;
        Result.Companion r179 = Result.Companion;
        r144 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r180 = Result.m9452exceptionOrNullimpl(r144);
        if (r180 == null) goto L351;
        EnsureManager.ensureNotReachHere(r180);
    L351:
        if (Result.m9455isFailureimpl(r144) == false) goto L189;
        goto L189
    }

    @HostExperimentKey(author = "chenlong,hz", desc = "店铺大屏适配")
    public static final int e() {
        Object r100 = 0;
        Object r101 = null;
        if (Intrinsics.areEqual("ec_shop_big_screen_adapt", "ec_shop_launch_opt_common_2") == false) goto L179;
        if (f186139b != null) goto L173;
        int r102 = n.f45241a;
        int r103 = com.bytedance.android.ec.base.settings.a.f42813a;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L163
        Object r105 = d.f42818c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L57
        if (r105 != null) goto L12;
    L54:
        Object r106 = null;
    L55:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L57
    L59:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);     // Catch: Throwable -> L163
        if (r108 == null) goto L63;
        EnsureManager.ensureNotReachHere(r108);     // Catch: Throwable -> L163
    L63:
        if (Result.m9455isFailureimpl(r107) == false) goto L66;
        r107 = null;
    L66:
        if ((r107 instanceof Integer) == true) goto L68;
        r107 = null;
    L68:
        Object r109 = (Integer) r107;     // Catch: Throwable -> L163
        if (r109 != null) goto L75;
        Object r110 = d.f42816a.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L163
        if ((r110 instanceof Integer) == true) goto L74;
        r110 = null;
    L74:
        r109 = (Integer) r110;     // Catch: Throwable -> L163
    L75:
        if (r109 != null) goto L172;
        int r111 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L163
        Object r112 = d.f42818c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L127
        if (r112 != null) goto L82;
    L124:
        Object r113 = null;
    L125:
        Object r114 = Result.m9449constructorimpl(r113);     // Catch: Throwable -> L127
    L129:
        Throwable r115 = Result.m9452exceptionOrNullimpl(r114);     // Catch: Throwable -> L154
        if (r115 == null) goto L133;
        EnsureManager.ensureNotReachHere(r115);     // Catch: Throwable -> L154
    L133:
        if (Result.m9455isFailureimpl(r114) == false) goto L136;
        r114 = null;
    L136:
        if ((r114 instanceof Integer) == true) goto L138;
        r114 = null;
    L138:
        r109 = (Integer) r114;     // Catch: Throwable -> L154
        if (r109 != null) goto L161;
        IHybridHostService r116 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L154
        if (r116 == null) goto L144;
        Object r117 = r116.getHostABValue("ec_shop_launch_opt_common_2", r100);     // Catch: Throwable -> L154
    L145:
        if (r117 != null) goto L147;
    L160:
        r109 = r100;
        goto L161
    L147:
        if ((r117 instanceof Integer) == false) goto L150;
        r101 = r117;
    L150:
        Integer r118 = (Integer) r101;     // Catch: Throwable -> L154
        if (r118 == null) goto L160;
        r109 = r118;
        goto L161
    L154:
        th = move-exception;
        Result.Companion r119 = Result.Companion;     // Catch: Throwable -> L163
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
        Throwable r120 = Result.m9452exceptionOrNullimpl(r109);     // Catch: Throwable -> L163
        if (r120 == null) goto L159;
        EnsureManager.ensureNotReachHere(r120);     // Catch: Throwable -> L163
    L159:
        if (Result.m9455isFailureimpl(r109) == false) goto L161;
    L144:
        r117 = null;
    L161:
        d.d("ec_shop_launch_opt_common_2", r109);     // Catch: Throwable -> L163
        goto L172
    L82:
        if ((r112 instanceof Integer) == true) goto L84;
        Object r121 = null;
    L85:
        r113 = (Integer) r121;     // Catch: Throwable -> L127
        if (r113 != null) goto L125;
        if ((r112 instanceof Number) == false) goto L112;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r122 = Float.valueOf(((Number) r112).floatValue());     // Catch: Throwable -> L127
        if ((r122 instanceof Integer) == true) goto L95;
        r122 = null;
    L95:
        r113 = (Integer) r122;     // Catch: Throwable -> L127
        goto L125
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r123 = Double.valueOf(((Number) r112).doubleValue());     // Catch: Throwable -> L127
        if ((r123 instanceof Integer) == true) goto L101;
        r123 = null;
    L101:
        r113 = (Integer) r123;     // Catch: Throwable -> L127
        goto L125
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L106;
        r113 = Integer.valueOf(((Number) r112).intValue());     // Catch: Throwable -> L127
        goto L125
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L112;
        Long r124 = Long.valueOf(((Number) r112).longValue());     // Catch: Throwable -> L127
        if ((r124 instanceof Integer) == true) goto L110;
        r124 = null;
    L110:
        r113 = (Integer) r124;     // Catch: Throwable -> L127
    L112:
        if ((r112 instanceof JSONObject) == false) goto L114;
    L366:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L120
        Object r125 = SDKSettingsCacheManager.a().fromJson(r112.toString(), Integer.class);     // Catch: Throwable -> L120
        if ((r125 instanceof Integer) == true) goto L118;
        r125 = null;
    L118:
        Object r126 = Result.m9449constructorimpl((Integer) r125);     // Catch: Throwable -> L120
    L122:
        r113 = r126;
        if (Result.m9455isFailureimpl(r113) == false) goto L125;
    L120:
        th = move-exception;
        Result.Companion r127 = Result.Companion;     // Catch: Throwable -> L127
        r126 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L127
        goto L122
    L114:
        if ((r112 instanceof JSONArray) == false) goto L124;
    L84:
        r121 = r112;
    L127:
        th = move-exception;
        Result.Companion r128 = Result.Companion;     // Catch: Throwable -> L154
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L154
    L172:
        f186139b = (Integer) r109;
        goto L173
    L12:
        if ((r105 instanceof Integer) == true) goto L14;
        Object r129 = null;
    L15:
        r106 = (Integer) r129;     // Catch: Throwable -> L57
        if (r106 != null) goto L55;
        if ((r105 instanceof Number) == false) goto L42;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L27;
        Float r130 = Float.valueOf(((Number) r105).floatValue());     // Catch: Throwable -> L57
        if ((r130 instanceof Integer) == true) goto L25;
        r130 = null;
    L25:
        r106 = (Integer) r130;     // Catch: Throwable -> L57
        goto L55
    L27:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L33;
        Double r131 = Double.valueOf(((Number) r105).doubleValue());     // Catch: Throwable -> L57
        if ((r131 instanceof Integer) == true) goto L31;
        r131 = null;
    L31:
        r106 = (Integer) r131;     // Catch: Throwable -> L57
        goto L55
    L33:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L36;
        r106 = Integer.valueOf(((Number) r105).intValue());     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L42;
        Long r132 = Long.valueOf(((Number) r105).longValue());     // Catch: Throwable -> L57
        if ((r132 instanceof Integer) == true) goto L40;
        r132 = null;
    L40:
        r106 = (Integer) r132;     // Catch: Throwable -> L57
    L42:
        if ((r105 instanceof JSONObject) == false) goto L44;
    L364:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L50
        Object r133 = SDKSettingsCacheManager.a().fromJson(r105.toString(), Integer.class);     // Catch: Throwable -> L50
        if ((r133 instanceof Integer) == true) goto L48;
        r133 = null;
    L48:
        Object r134 = Result.m9449constructorimpl((Integer) r133);     // Catch: Throwable -> L50
    L52:
        r106 = r134;
        if (Result.m9455isFailureimpl(r106) == false) goto L55;
    L50:
        th = move-exception;
        Result.Companion r135 = Result.Companion;     // Catch: Throwable -> L57
        r134 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L52
    L44:
        if ((r105 instanceof JSONArray) == false) goto L54;
    L14:
        r129 = r105;
    L57:
        th = move-exception;
        Result.Companion r136 = Result.Companion;     // Catch: Throwable -> L163
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
    L163:
        th = move-exception;
        Result.Companion r137 = Result.Companion;
        Object r138 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r139 = Result.m9452exceptionOrNullimpl(r138);
        if (r139 == null) goto L168;
        EnsureManager.ensureNotReachHere(r139);
    L168:
        if (Result.m9455isFailureimpl(r138) == true) goto L171;
        r100 = r138;
    L171:
        r109 = r100;
    L173:
        Object r140 = f186139b;
        if (r140 == null) goto L177;
    L354:
        f186138a.put("ec_shop_big_screen_adapt", r140);
        return ((Number) r140).intValue();
    L177:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L179:
        if (Intrinsics.areEqual("HostExperiment", "ShopSetting") == false) goto L190;
        int r141 = p.f45243a;
        Result.Companion r142 = Result.Companion;     // Catch: Throwable -> L185
        jj4.b r143 = jj4.b.f499326b;     // Catch: Throwable -> L185
        r140 = jj4.a.a("ec_shop_big_screen_adapt", Integer.class, r100, false);     // Catch: Throwable -> L185
        if (r140 != null) goto L354;
        Intrinsics.throwNpe();     // Catch: Throwable -> L185
    L185:
        th = move-exception;
        Result.Companion r144 = Result.Companion;
        Object r145 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r145) == true) goto L353;
    L189:
        r100 = r145;
    L353:
        r140 = r100;
        goto L354
    L190:
        int r146 = n.f45241a;
        int r147 = com.bytedance.android.ec.base.settings.a.f42813a;
        Result.Companion r148 = Result.Companion;     // Catch: Throwable -> L347
        Object r149 = d.f42818c.get("ec_shop_big_screen_adapt");     // Catch: Throwable -> L241
        if (r149 != null) goto L196;
    L238:
        Object r150 = null;
    L239:
        Object r151 = Result.m9449constructorimpl(r150);     // Catch: Throwable -> L241
    L243:
        Throwable r152 = Result.m9452exceptionOrNullimpl(r151);     // Catch: Throwable -> L347
        if (r152 == null) goto L247;
        EnsureManager.ensureNotReachHere(r152);     // Catch: Throwable -> L347
    L247:
        if (Result.m9455isFailureimpl(r151) == false) goto L250;
        r151 = null;
    L250:
        if ((r151 instanceof Integer) == true) goto L252;
        r151 = null;
    L252:
        r140 = (Integer) r151;     // Catch: Throwable -> L347
        if (r140 != null) goto L259;
        Object r153 = d.f42816a.get("ec_shop_big_screen_adapt");     // Catch: Throwable -> L347
        if ((r153 instanceof Integer) == true) goto L258;
        r153 = null;
    L258:
        r140 = (Integer) r153;     // Catch: Throwable -> L347
    L259:
        if (r140 != null) goto L354;
        int r154 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L347
        Object r155 = d.f42818c.get("ec_shop_big_screen_adapt");     // Catch: Throwable -> L311
        if (r155 != null) goto L266;
    L308:
        Object r156 = null;
    L309:
        Object r157 = Result.m9449constructorimpl(r156);     // Catch: Throwable -> L311
    L313:
        Throwable r158 = Result.m9452exceptionOrNullimpl(r157);     // Catch: Throwable -> L338
        if (r158 == null) goto L317;
        EnsureManager.ensureNotReachHere(r158);     // Catch: Throwable -> L338
    L317:
        if (Result.m9455isFailureimpl(r157) == false) goto L320;
        r157 = null;
    L320:
        if ((r157 instanceof Integer) == true) goto L322;
        r157 = null;
    L322:
        r140 = (Integer) r157;     // Catch: Throwable -> L338
        if (r140 != null) goto L345;
        IHybridHostService r159 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L338
        if (r159 == null) goto L328;
        Object r160 = r159.getHostABValue("ec_shop_big_screen_adapt", r100);     // Catch: Throwable -> L338
    L329:
        if (r160 != null) goto L331;
    L344:
        r140 = r100;
        goto L345
    L331:
        if ((r160 instanceof Integer) == false) goto L334;
        r101 = r160;
    L334:
        Integer r161 = (Integer) r101;     // Catch: Throwable -> L338
        if (r161 == null) goto L344;
        r140 = r161;
        goto L345
    L338:
        th = move-exception;
        Result.Companion r162 = Result.Companion;     // Catch: Throwable -> L347
        r140 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L347
        Throwable r163 = Result.m9452exceptionOrNullimpl(r140);     // Catch: Throwable -> L347
        if (r163 == null) goto L343;
        EnsureManager.ensureNotReachHere(r163);     // Catch: Throwable -> L347
    L343:
        if (Result.m9455isFailureimpl(r140) == false) goto L345;
    L328:
        r160 = null;
    L345:
        d.d("ec_shop_big_screen_adapt", r140);     // Catch: Throwable -> L347
        goto L354
    L266:
        if ((r155 instanceof Integer) == true) goto L268;
        Object r164 = null;
    L269:
        r156 = (Integer) r164;     // Catch: Throwable -> L311
        if (r156 != null) goto L309;
        if ((r155 instanceof Number) == false) goto L296;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L281;
        Float r165 = Float.valueOf(((Number) r155).floatValue());     // Catch: Throwable -> L311
        if ((r165 instanceof Integer) == true) goto L279;
        r165 = null;
    L279:
        r156 = (Integer) r165;     // Catch: Throwable -> L311
        goto L309
    L281:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L287;
        Double r166 = Double.valueOf(((Number) r155).doubleValue());     // Catch: Throwable -> L311
        if ((r166 instanceof Integer) == true) goto L285;
        r166 = null;
    L285:
        r156 = (Integer) r166;     // Catch: Throwable -> L311
        goto L309
    L287:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L290;
        r156 = Integer.valueOf(((Number) r155).intValue());     // Catch: Throwable -> L311
        goto L309
    L290:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L296;
        Long r167 = Long.valueOf(((Number) r155).longValue());     // Catch: Throwable -> L311
        if ((r167 instanceof Integer) == true) goto L294;
        r167 = null;
    L294:
        r156 = (Integer) r167;     // Catch: Throwable -> L311
    L296:
        if ((r155 instanceof JSONObject) == false) goto L298;
    L380:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L304
        Object r168 = SDKSettingsCacheManager.a().fromJson(r155.toString(), Integer.class);     // Catch: Throwable -> L304
        if ((r168 instanceof Integer) == true) goto L302;
        r168 = null;
    L302:
        Object r169 = Result.m9449constructorimpl((Integer) r168);     // Catch: Throwable -> L304
    L306:
        r156 = r169;
        if (Result.m9455isFailureimpl(r156) == false) goto L309;
    L304:
        th = move-exception;
        Result.Companion r170 = Result.Companion;     // Catch: Throwable -> L311
        r169 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L311
        goto L306
    L298:
        if ((r155 instanceof JSONArray) == false) goto L308;
    L268:
        r164 = r155;
    L311:
        th = move-exception;
        Result.Companion r171 = Result.Companion;     // Catch: Throwable -> L338
        r157 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L338
        goto L313
    L196:
        if ((r149 instanceof Integer) == true) goto L198;
        Object r172 = null;
    L199:
        r150 = (Integer) r172;     // Catch: Throwable -> L241
        if (r150 != null) goto L239;
        if ((r149 instanceof Number) == false) goto L226;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L211;
        Float r173 = Float.valueOf(((Number) r149).floatValue());     // Catch: Throwable -> L241
        if ((r173 instanceof Integer) == true) goto L209;
        r173 = null;
    L209:
        r150 = (Integer) r173;     // Catch: Throwable -> L241
        goto L239
    L211:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L217;
        Double r174 = Double.valueOf(((Number) r149).doubleValue());     // Catch: Throwable -> L241
        if ((r174 instanceof Integer) == true) goto L215;
        r174 = null;
    L215:
        r150 = (Integer) r174;     // Catch: Throwable -> L241
        goto L239
    L217:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L220;
        r150 = Integer.valueOf(((Number) r149).intValue());     // Catch: Throwable -> L241
        goto L239
    L220:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L226;
        Long r175 = Long.valueOf(((Number) r149).longValue());     // Catch: Throwable -> L241
        if ((r175 instanceof Integer) == true) goto L224;
        r175 = null;
    L224:
        r150 = (Integer) r175;     // Catch: Throwable -> L241
    L226:
        if ((r149 instanceof JSONObject) == false) goto L228;
    L378:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L234
        Object r176 = SDKSettingsCacheManager.a().fromJson(r149.toString(), Integer.class);     // Catch: Throwable -> L234
        if ((r176 instanceof Integer) == true) goto L232;
        r176 = null;
    L232:
        Object r177 = Result.m9449constructorimpl((Integer) r176);     // Catch: Throwable -> L234
    L236:
        r150 = r177;
        if (Result.m9455isFailureimpl(r150) == false) goto L239;
    L234:
        th = move-exception;
        Result.Companion r178 = Result.Companion;     // Catch: Throwable -> L241
        r177 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L241
        goto L236
    L228:
        if ((r149 instanceof JSONArray) == false) goto L238;
    L198:
        r172 = r149;
    L241:
        th = move-exception;
        Result.Companion r179 = Result.Companion;     // Catch: Throwable -> L347
        r151 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L347
    L347:
        th = move-exception;
        Result.Companion r180 = Result.Companion;
        r145 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r181 = Result.m9452exceptionOrNullimpl(r145);
        if (r181 == null) goto L352;
        EnsureManager.ensureNotReachHere(r181);
    L352:
        if (Result.m9455isFailureimpl(r145) == false) goto L189;
        goto L189
    }

    @SettingReport
    public static boolean f() {
        Object r100 = 0;
        Object r101 = null;
        if (Intrinsics.areEqual("ec_shop_biz_extra_no_transfer", "ec_shop_launch_opt_common_2") == false) goto L179;
        if (f186139b != null) goto L173;
        int r102 = n.f45241a;
        int r103 = com.bytedance.android.ec.base.settings.a.f42813a;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L163
        Object r105 = d.f42818c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L57
        if (r105 != null) goto L12;
    L54:
        Object r106 = null;
    L55:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L57
    L59:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);     // Catch: Throwable -> L163
        if (r108 == null) goto L63;
        EnsureManager.ensureNotReachHere(r108);     // Catch: Throwable -> L163
    L63:
        if (Result.m9455isFailureimpl(r107) == false) goto L66;
        r107 = null;
    L66:
        if ((r107 instanceof Integer) == true) goto L68;
        r107 = null;
    L68:
        Object r109 = (Integer) r107;     // Catch: Throwable -> L163
        if (r109 != null) goto L75;
        Object r110 = d.f42816a.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L163
        if ((r110 instanceof Integer) == true) goto L74;
        r110 = null;
    L74:
        r109 = (Integer) r110;     // Catch: Throwable -> L163
    L75:
        if (r109 != null) goto L172;
        int r111 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L163
        Object r112 = d.f42818c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L127
        if (r112 != null) goto L82;
    L124:
        Object r113 = null;
    L125:
        Object r114 = Result.m9449constructorimpl(r113);     // Catch: Throwable -> L127
    L129:
        Throwable r115 = Result.m9452exceptionOrNullimpl(r114);     // Catch: Throwable -> L154
        if (r115 == null) goto L133;
        EnsureManager.ensureNotReachHere(r115);     // Catch: Throwable -> L154
    L133:
        if (Result.m9455isFailureimpl(r114) == false) goto L136;
        r114 = null;
    L136:
        if ((r114 instanceof Integer) == true) goto L138;
        r114 = null;
    L138:
        r109 = (Integer) r114;     // Catch: Throwable -> L154
        if (r109 != null) goto L161;
        IHybridHostService r116 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L154
        if (r116 == null) goto L144;
        Object r117 = r116.getHostABValue("ec_shop_launch_opt_common_2", r100);     // Catch: Throwable -> L154
    L145:
        if (r117 != null) goto L147;
    L160:
        r109 = r100;
        goto L161
    L147:
        if ((r117 instanceof Integer) == false) goto L150;
        r101 = r117;
    L150:
        Integer r118 = (Integer) r101;     // Catch: Throwable -> L154
        if (r118 == null) goto L160;
        r109 = r118;
        goto L161
    L154:
        th = move-exception;
        Result.Companion r119 = Result.Companion;     // Catch: Throwable -> L163
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
        Throwable r120 = Result.m9452exceptionOrNullimpl(r109);     // Catch: Throwable -> L163
        if (r120 == null) goto L159;
        EnsureManager.ensureNotReachHere(r120);     // Catch: Throwable -> L163
    L159:
        if (Result.m9455isFailureimpl(r109) == false) goto L161;
    L144:
        r117 = null;
    L161:
        d.d("ec_shop_launch_opt_common_2", r109);     // Catch: Throwable -> L163
        goto L172
    L82:
        if ((r112 instanceof Integer) == true) goto L84;
        Object r121 = null;
    L85:
        r113 = (Integer) r121;     // Catch: Throwable -> L127
        if (r113 != null) goto L125;
        if ((r112 instanceof Number) == false) goto L112;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r122 = Float.valueOf(((Number) r112).floatValue());     // Catch: Throwable -> L127
        if ((r122 instanceof Integer) == true) goto L95;
        r122 = null;
    L95:
        r113 = (Integer) r122;     // Catch: Throwable -> L127
        goto L125
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r123 = Double.valueOf(((Number) r112).doubleValue());     // Catch: Throwable -> L127
        if ((r123 instanceof Integer) == true) goto L101;
        r123 = null;
    L101:
        r113 = (Integer) r123;     // Catch: Throwable -> L127
        goto L125
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L106;
        r113 = Integer.valueOf(((Number) r112).intValue());     // Catch: Throwable -> L127
        goto L125
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L112;
        Long r124 = Long.valueOf(((Number) r112).longValue());     // Catch: Throwable -> L127
        if ((r124 instanceof Integer) == true) goto L110;
        r124 = null;
    L110:
        r113 = (Integer) r124;     // Catch: Throwable -> L127
    L112:
        if ((r112 instanceof JSONObject) == false) goto L114;
    L368:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L120
        Object r125 = SDKSettingsCacheManager.a().fromJson(r112.toString(), Integer.class);     // Catch: Throwable -> L120
        if ((r125 instanceof Integer) == true) goto L118;
        r125 = null;
    L118:
        Object r126 = Result.m9449constructorimpl((Integer) r125);     // Catch: Throwable -> L120
    L122:
        r113 = r126;
        if (Result.m9455isFailureimpl(r113) == false) goto L125;
    L120:
        th = move-exception;
        Result.Companion r127 = Result.Companion;     // Catch: Throwable -> L127
        r126 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L127
        goto L122
    L114:
        if ((r112 instanceof JSONArray) == false) goto L124;
    L84:
        r121 = r112;
    L127:
        th = move-exception;
        Result.Companion r128 = Result.Companion;     // Catch: Throwable -> L154
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L154
    L172:
        f186139b = (Integer) r109;
        goto L173
    L12:
        if ((r105 instanceof Integer) == true) goto L14;
        Object r129 = null;
    L15:
        r106 = (Integer) r129;     // Catch: Throwable -> L57
        if (r106 != null) goto L55;
        if ((r105 instanceof Number) == false) goto L42;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L27;
        Float r130 = Float.valueOf(((Number) r105).floatValue());     // Catch: Throwable -> L57
        if ((r130 instanceof Integer) == true) goto L25;
        r130 = null;
    L25:
        r106 = (Integer) r130;     // Catch: Throwable -> L57
        goto L55
    L27:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L33;
        Double r131 = Double.valueOf(((Number) r105).doubleValue());     // Catch: Throwable -> L57
        if ((r131 instanceof Integer) == true) goto L31;
        r131 = null;
    L31:
        r106 = (Integer) r131;     // Catch: Throwable -> L57
        goto L55
    L33:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L36;
        r106 = Integer.valueOf(((Number) r105).intValue());     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L42;
        Long r132 = Long.valueOf(((Number) r105).longValue());     // Catch: Throwable -> L57
        if ((r132 instanceof Integer) == true) goto L40;
        r132 = null;
    L40:
        r106 = (Integer) r132;     // Catch: Throwable -> L57
    L42:
        if ((r105 instanceof JSONObject) == false) goto L44;
    L366:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L50
        Object r133 = SDKSettingsCacheManager.a().fromJson(r105.toString(), Integer.class);     // Catch: Throwable -> L50
        if ((r133 instanceof Integer) == true) goto L48;
        r133 = null;
    L48:
        Object r134 = Result.m9449constructorimpl((Integer) r133);     // Catch: Throwable -> L50
    L52:
        r106 = r134;
        if (Result.m9455isFailureimpl(r106) == false) goto L55;
    L50:
        th = move-exception;
        Result.Companion r135 = Result.Companion;     // Catch: Throwable -> L57
        r134 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L52
    L44:
        if ((r105 instanceof JSONArray) == false) goto L54;
    L14:
        r129 = r105;
    L57:
        th = move-exception;
        Result.Companion r136 = Result.Companion;     // Catch: Throwable -> L163
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
    L163:
        th = move-exception;
        Result.Companion r137 = Result.Companion;
        Object r138 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r139 = Result.m9452exceptionOrNullimpl(r138);
        if (r139 == null) goto L168;
        EnsureManager.ensureNotReachHere(r139);
    L168:
        if (Result.m9455isFailureimpl(r138) == true) goto L171;
        r100 = r138;
    L171:
        r109 = r100;
    L173:
        r100 = f186139b;
        if (r100 == null) goto L177;
    L352:
        f186138a.put("ec_shop_biz_extra_no_transfer", r100);
        if (((Number) r100).intValue() != 1) goto L355;
    L356:
        return true;
    L355:
        if (h() == true) goto L356;
        return false;
    L177:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L179:
        if (Intrinsics.areEqual("HostExperiment", "ShopSetting") == false) goto L190;
        int r140 = p.f45243a;
        Result.Companion r141 = Result.Companion;     // Catch: Throwable -> L185
        jj4.b r142 = jj4.b.f499326b;     // Catch: Throwable -> L185
        Object r143 = jj4.a.a("ec_shop_biz_extra_no_transfer", Integer.class, r100, false);     // Catch: Throwable -> L185
        if (r143 != null) goto L189;
        Intrinsics.throwNpe();     // Catch: Throwable -> L185
    L189:
        r100 = r143;
    L185:
        th = move-exception;
        Result.Companion r144 = Result.Companion;
        r143 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r143) == false) goto L189;
    L190:
        int r145 = n.f45241a;
        int r146 = com.bytedance.android.ec.base.settings.a.f42813a;
        Result.Companion r147 = Result.Companion;     // Catch: Throwable -> L346
        Object r148 = d.f42818c.get("ec_shop_biz_extra_no_transfer");     // Catch: Throwable -> L241
        if (r148 != null) goto L196;
    L238:
        Object r149 = null;
    L239:
        Object r150 = Result.m9449constructorimpl(r149);     // Catch: Throwable -> L241
    L243:
        Throwable r151 = Result.m9452exceptionOrNullimpl(r150);     // Catch: Throwable -> L346
        if (r151 == null) goto L247;
        EnsureManager.ensureNotReachHere(r151);     // Catch: Throwable -> L346
    L247:
        if (Result.m9455isFailureimpl(r150) == false) goto L250;
        r150 = null;
    L250:
        if ((r150 instanceof Integer) == true) goto L252;
        r150 = null;
    L252:
        r143 = (Integer) r150;     // Catch: Throwable -> L346
        if (r143 != null) goto L259;
        Object r152 = d.f42816a.get("ec_shop_biz_extra_no_transfer");     // Catch: Throwable -> L346
        if ((r152 instanceof Integer) == true) goto L258;
        r152 = null;
    L258:
        r143 = (Integer) r152;     // Catch: Throwable -> L346
    L259:
        if (r143 != null) goto L189;
        int r153 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L346
        Object r154 = d.f42818c.get("ec_shop_biz_extra_no_transfer");     // Catch: Throwable -> L311
        if (r154 != null) goto L266;
    L308:
        Object r155 = null;
    L309:
        Object r156 = Result.m9449constructorimpl(r155);     // Catch: Throwable -> L311
    L313:
        Throwable r157 = Result.m9452exceptionOrNullimpl(r156);     // Catch: Throwable -> L337
        if (r157 == null) goto L317;
        EnsureManager.ensureNotReachHere(r157);     // Catch: Throwable -> L337
    L317:
        if (Result.m9455isFailureimpl(r156) == false) goto L320;
        r156 = null;
    L320:
        if ((r156 instanceof Integer) == true) goto L322;
        r156 = null;
    L322:
        r143 = (Integer) r156;     // Catch: Throwable -> L337
        if (r143 != null) goto L344;
        IHybridHostService r158 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L337
        if (r158 == null) goto L328;
        Object r159 = r158.getHostABValue("ec_shop_biz_extra_no_transfer", r100);     // Catch: Throwable -> L337
    L329:
        if (r159 != null) goto L331;
    L343:
        r143 = r100;
        goto L344
    L331:
        if ((r159 instanceof Integer) == false) goto L334;
        r101 = r159;
    L334:
        r143 = (Integer) r101;     // Catch: Throwable -> L337
        if (r143 != null) goto L344;
    L328:
        r159 = null;
    L344:
        d.d("ec_shop_biz_extra_no_transfer", r143);     // Catch: Throwable -> L346
        goto L189
    L266:
        if ((r154 instanceof Integer) == true) goto L268;
        Object r160 = null;
    L269:
        r155 = (Integer) r160;     // Catch: Throwable -> L311
        if (r155 != null) goto L309;
        if ((r154 instanceof Number) == false) goto L296;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L281;
        Float r161 = Float.valueOf(((Number) r154).floatValue());     // Catch: Throwable -> L311
        if ((r161 instanceof Integer) == true) goto L279;
        r161 = null;
    L279:
        r155 = (Integer) r161;     // Catch: Throwable -> L311
        goto L309
    L281:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L287;
        Double r162 = Double.valueOf(((Number) r154).doubleValue());     // Catch: Throwable -> L311
        if ((r162 instanceof Integer) == true) goto L285;
        r162 = null;
    L285:
        r155 = (Integer) r162;     // Catch: Throwable -> L311
        goto L309
    L287:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L290;
        r155 = Integer.valueOf(((Number) r154).intValue());     // Catch: Throwable -> L311
        goto L309
    L290:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L296;
        Long r163 = Long.valueOf(((Number) r154).longValue());     // Catch: Throwable -> L311
        if ((r163 instanceof Integer) == true) goto L294;
        r163 = null;
    L294:
        r155 = (Integer) r163;     // Catch: Throwable -> L311
    L296:
        if ((r154 instanceof JSONObject) == false) goto L298;
    L381:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L304
        Object r164 = SDKSettingsCacheManager.a().fromJson(r154.toString(), Integer.class);     // Catch: Throwable -> L304
        if ((r164 instanceof Integer) == true) goto L302;
        r164 = null;
    L302:
        Object r165 = Result.m9449constructorimpl((Integer) r164);     // Catch: Throwable -> L304
    L306:
        r155 = r165;
        if (Result.m9455isFailureimpl(r155) == false) goto L309;
    L304:
        th = move-exception;
        Result.Companion r166 = Result.Companion;     // Catch: Throwable -> L311
        r165 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L311
        goto L306
    L298:
        if ((r154 instanceof JSONArray) == false) goto L308;
    L268:
        r160 = r154;
    L337:
        th = move-exception;
        Result.Companion r167 = Result.Companion;     // Catch: Throwable -> L346
        r143 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L346
        Throwable r168 = Result.m9452exceptionOrNullimpl(r143);     // Catch: Throwable -> L346
        if (r168 == null) goto L342;
        EnsureManager.ensureNotReachHere(r168);     // Catch: Throwable -> L346
    L342:
        if (Result.m9455isFailureimpl(r143) == false) goto L344;
    L311:
        th = move-exception;
        Result.Companion r169 = Result.Companion;     // Catch: Throwable -> L337
        r156 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L337
        goto L313
    L196:
        if ((r148 instanceof Integer) == true) goto L198;
        Object r170 = null;
    L199:
        r149 = (Integer) r170;     // Catch: Throwable -> L241
        if (r149 != null) goto L239;
        if ((r148 instanceof Number) == false) goto L226;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L211;
        Float r171 = Float.valueOf(((Number) r148).floatValue());     // Catch: Throwable -> L241
        if ((r171 instanceof Integer) == true) goto L209;
        r171 = null;
    L209:
        r149 = (Integer) r171;     // Catch: Throwable -> L241
        goto L239
    L211:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L217;
        Double r172 = Double.valueOf(((Number) r148).doubleValue());     // Catch: Throwable -> L241
        if ((r172 instanceof Integer) == true) goto L215;
        r172 = null;
    L215:
        r149 = (Integer) r172;     // Catch: Throwable -> L241
        goto L239
    L217:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L220;
        r149 = Integer.valueOf(((Number) r148).intValue());     // Catch: Throwable -> L241
        goto L239
    L220:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L226;
        Long r173 = Long.valueOf(((Number) r148).longValue());     // Catch: Throwable -> L241
        if ((r173 instanceof Integer) == true) goto L224;
        r173 = null;
    L224:
        r149 = (Integer) r173;     // Catch: Throwable -> L241
    L226:
        if ((r148 instanceof JSONObject) == false) goto L228;
    L379:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L234
        Object r174 = SDKSettingsCacheManager.a().fromJson(r148.toString(), Integer.class);     // Catch: Throwable -> L234
        if ((r174 instanceof Integer) == true) goto L232;
        r174 = null;
    L232:
        Object r175 = Result.m9449constructorimpl((Integer) r174);     // Catch: Throwable -> L234
    L236:
        r149 = r175;
        if (Result.m9455isFailureimpl(r149) == false) goto L239;
    L234:
        th = move-exception;
        Result.Companion r176 = Result.Companion;     // Catch: Throwable -> L241
        r175 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L241
        goto L236
    L228:
        if ((r148 instanceof JSONArray) == false) goto L238;
    L198:
        r170 = r148;
    L241:
        th = move-exception;
        Result.Companion r177 = Result.Companion;     // Catch: Throwable -> L346
        r150 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L346
    L346:
        th = move-exception;
        Result.Companion r178 = Result.Companion;
        r143 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r179 = Result.m9452exceptionOrNullimpl(r143);
        if (r179 == null) goto L351;
        EnsureManager.ensureNotReachHere(r179);
    L351:
        if (Result.m9455isFailureimpl(r143) == false) goto L189;
        goto L189
    }

    public static boolean g() {
        return ((Boolean) f186144g.getValue()).booleanValue();
    }

    @HostExperimentKey(author = "chenlong.hz", desc = "营销接口迁移开关")
    @SettingReport
    public static final int getEC_SHOP_ACTIVITY_CHANGE() {
        Object r100 = 1;
        Object r101 = null;
        if (Intrinsics.areEqual("ec_shop_activity_api_change", "ec_shop_launch_opt_common_2") == false) goto L179;
        if (f186139b != null) goto L173;
        int r102 = n.f45241a;
        Object r103 = 0;
        int r104 = com.bytedance.android.ec.base.settings.a.f42813a;
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L163
        Object r106 = d.f42818c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L57
        if (r106 != null) goto L12;
    L54:
        Object r107 = null;
    L55:
        Object r108 = Result.m9449constructorimpl(r107);     // Catch: Throwable -> L57
    L59:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);     // Catch: Throwable -> L163
        if (r109 == null) goto L63;
        EnsureManager.ensureNotReachHere(r109);     // Catch: Throwable -> L163
    L63:
        if (Result.m9455isFailureimpl(r108) == false) goto L66;
        r108 = null;
    L66:
        if ((r108 instanceof Integer) == true) goto L68;
        r108 = null;
    L68:
        Object r110 = (Integer) r108;     // Catch: Throwable -> L163
        if (r110 != null) goto L75;
        Object r111 = d.f42816a.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L163
        if ((r111 instanceof Integer) == true) goto L74;
        r111 = null;
    L74:
        r110 = (Integer) r111;     // Catch: Throwable -> L163
    L75:
        if (r110 != null) goto L172;
        int r112 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L163
        Object r113 = d.f42818c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L127
        if (r113 != null) goto L82;
    L124:
        Object r114 = null;
    L125:
        Object r115 = Result.m9449constructorimpl(r114);     // Catch: Throwable -> L127
    L129:
        Throwable r116 = Result.m9452exceptionOrNullimpl(r115);     // Catch: Throwable -> L154
        if (r116 == null) goto L133;
        EnsureManager.ensureNotReachHere(r116);     // Catch: Throwable -> L154
    L133:
        if (Result.m9455isFailureimpl(r115) == false) goto L136;
        r115 = null;
    L136:
        if ((r115 instanceof Integer) == true) goto L138;
        r115 = null;
    L138:
        r110 = (Integer) r115;     // Catch: Throwable -> L154
        if (r110 != null) goto L161;
        IHybridHostService r117 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L154
        if (r117 == null) goto L144;
        Object r118 = r117.getHostABValue("ec_shop_launch_opt_common_2", r103);     // Catch: Throwable -> L154
    L145:
        if (r118 != null) goto L147;
    L160:
        r110 = r103;
        goto L161
    L147:
        if ((r118 instanceof Integer) == false) goto L150;
        r101 = r118;
    L150:
        Integer r119 = (Integer) r101;     // Catch: Throwable -> L154
        if (r119 == null) goto L160;
        r110 = r119;
        goto L161
    L154:
        th = move-exception;
        Result.Companion r120 = Result.Companion;     // Catch: Throwable -> L163
        r110 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
        Throwable r121 = Result.m9452exceptionOrNullimpl(r110);     // Catch: Throwable -> L163
        if (r121 == null) goto L159;
        EnsureManager.ensureNotReachHere(r121);     // Catch: Throwable -> L163
    L159:
        if (Result.m9455isFailureimpl(r110) == false) goto L161;
    L144:
        r118 = null;
    L161:
        d.d("ec_shop_launch_opt_common_2", r110);     // Catch: Throwable -> L163
        goto L172
    L82:
        if ((r113 instanceof Integer) == true) goto L84;
        Object r122 = null;
    L85:
        r114 = (Integer) r122;     // Catch: Throwable -> L127
        if (r114 != null) goto L125;
        if ((r113 instanceof Number) == false) goto L112;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r123 = Float.valueOf(((Number) r113).floatValue());     // Catch: Throwable -> L127
        if ((r123 instanceof Integer) == true) goto L95;
        r123 = null;
    L95:
        r114 = (Integer) r123;     // Catch: Throwable -> L127
        goto L125
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r124 = Double.valueOf(((Number) r113).doubleValue());     // Catch: Throwable -> L127
        if ((r124 instanceof Integer) == true) goto L101;
        r124 = null;
    L101:
        r114 = (Integer) r124;     // Catch: Throwable -> L127
        goto L125
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L106;
        r114 = Integer.valueOf(((Number) r113).intValue());     // Catch: Throwable -> L127
        goto L125
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L112;
        Long r125 = Long.valueOf(((Number) r113).longValue());     // Catch: Throwable -> L127
        if ((r125 instanceof Integer) == true) goto L110;
        r125 = null;
    L110:
        r114 = (Integer) r125;     // Catch: Throwable -> L127
    L112:
        if ((r113 instanceof JSONObject) == false) goto L114;
    L364:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L120
        Object r126 = SDKSettingsCacheManager.a().fromJson(r113.toString(), Integer.class);     // Catch: Throwable -> L120
        if ((r126 instanceof Integer) == true) goto L118;
        r126 = null;
    L118:
        Object r127 = Result.m9449constructorimpl((Integer) r126);     // Catch: Throwable -> L120
    L122:
        r114 = r127;
        if (Result.m9455isFailureimpl(r114) == false) goto L125;
    L120:
        th = move-exception;
        Result.Companion r128 = Result.Companion;     // Catch: Throwable -> L127
        r127 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L127
        goto L122
    L114:
        if ((r113 instanceof JSONArray) == false) goto L124;
    L84:
        r122 = r113;
    L127:
        th = move-exception;
        Result.Companion r129 = Result.Companion;     // Catch: Throwable -> L154
        r115 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L154
    L172:
        f186139b = (Integer) r110;
        goto L173
    L12:
        if ((r106 instanceof Integer) == true) goto L14;
        Object r130 = null;
    L15:
        r107 = (Integer) r130;     // Catch: Throwable -> L57
        if (r107 != null) goto L55;
        if ((r106 instanceof Number) == false) goto L42;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L27;
        Float r131 = Float.valueOf(((Number) r106).floatValue());     // Catch: Throwable -> L57
        if ((r131 instanceof Integer) == true) goto L25;
        r131 = null;
    L25:
        r107 = (Integer) r131;     // Catch: Throwable -> L57
        goto L55
    L27:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L33;
        Double r132 = Double.valueOf(((Number) r106).doubleValue());     // Catch: Throwable -> L57
        if ((r132 instanceof Integer) == true) goto L31;
        r132 = null;
    L31:
        r107 = (Integer) r132;     // Catch: Throwable -> L57
        goto L55
    L33:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L36;
        r107 = Integer.valueOf(((Number) r106).intValue());     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L42;
        Long r133 = Long.valueOf(((Number) r106).longValue());     // Catch: Throwable -> L57
        if ((r133 instanceof Integer) == true) goto L40;
        r133 = null;
    L40:
        r107 = (Integer) r133;     // Catch: Throwable -> L57
    L42:
        if ((r106 instanceof JSONObject) == false) goto L44;
    L362:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L50
        Object r134 = SDKSettingsCacheManager.a().fromJson(r106.toString(), Integer.class);     // Catch: Throwable -> L50
        if ((r134 instanceof Integer) == true) goto L48;
        r134 = null;
    L48:
        Object r135 = Result.m9449constructorimpl((Integer) r134);     // Catch: Throwable -> L50
    L52:
        r107 = r135;
        if (Result.m9455isFailureimpl(r107) == false) goto L55;
    L50:
        th = move-exception;
        Result.Companion r136 = Result.Companion;     // Catch: Throwable -> L57
        r135 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L52
    L44:
        if ((r106 instanceof JSONArray) == false) goto L54;
    L14:
        r130 = r106;
    L57:
        th = move-exception;
        Result.Companion r137 = Result.Companion;     // Catch: Throwable -> L163
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
    L163:
        th = move-exception;
        Result.Companion r138 = Result.Companion;
        Object r139 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r140 = Result.m9452exceptionOrNullimpl(r139);
        if (r140 == null) goto L168;
        EnsureManager.ensureNotReachHere(r140);
    L168:
        if (Result.m9455isFailureimpl(r139) == true) goto L171;
        r103 = r139;
    L171:
        r110 = r103;
    L173:
        r100 = f186139b;
        if (r100 == null) goto L177;
    L352:
        f186138a.put("ec_shop_activity_api_change", r100);
        return ((Number) r100).intValue();
    L177:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L179:
        if (Intrinsics.areEqual("HostExperiment", "ShopSetting") == false) goto L190;
        int r141 = p.f45243a;
        Result.Companion r142 = Result.Companion;     // Catch: Throwable -> L185
        jj4.b r143 = jj4.b.f499326b;     // Catch: Throwable -> L185
        Object r144 = jj4.a.a("ec_shop_activity_api_change", Integer.class, r100, false);     // Catch: Throwable -> L185
        if (r144 != null) goto L189;
        Intrinsics.throwNpe();     // Catch: Throwable -> L185
    L189:
        r100 = r144;
    L185:
        th = move-exception;
        Result.Companion r145 = Result.Companion;
        r144 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r144) == false) goto L189;
    L190:
        int r146 = n.f45241a;
        int r147 = com.bytedance.android.ec.base.settings.a.f42813a;
        Result.Companion r148 = Result.Companion;     // Catch: Throwable -> L346
        Object r149 = d.f42818c.get("ec_shop_activity_api_change");     // Catch: Throwable -> L241
        if (r149 != null) goto L196;
    L238:
        Object r150 = null;
    L239:
        Object r151 = Result.m9449constructorimpl(r150);     // Catch: Throwable -> L241
    L243:
        Throwable r152 = Result.m9452exceptionOrNullimpl(r151);     // Catch: Throwable -> L346
        if (r152 == null) goto L247;
        EnsureManager.ensureNotReachHere(r152);     // Catch: Throwable -> L346
    L247:
        if (Result.m9455isFailureimpl(r151) == false) goto L250;
        r151 = null;
    L250:
        if ((r151 instanceof Integer) == true) goto L252;
        r151 = null;
    L252:
        r144 = (Integer) r151;     // Catch: Throwable -> L346
        if (r144 != null) goto L259;
        Object r153 = d.f42816a.get("ec_shop_activity_api_change");     // Catch: Throwable -> L346
        if ((r153 instanceof Integer) == true) goto L258;
        r153 = null;
    L258:
        r144 = (Integer) r153;     // Catch: Throwable -> L346
    L259:
        if (r144 != null) goto L189;
        int r154 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L346
        Object r155 = d.f42818c.get("ec_shop_activity_api_change");     // Catch: Throwable -> L311
        if (r155 != null) goto L266;
    L308:
        Object r156 = null;
    L309:
        Object r157 = Result.m9449constructorimpl(r156);     // Catch: Throwable -> L311
    L313:
        Throwable r158 = Result.m9452exceptionOrNullimpl(r157);     // Catch: Throwable -> L337
        if (r158 == null) goto L317;
        EnsureManager.ensureNotReachHere(r158);     // Catch: Throwable -> L337
    L317:
        if (Result.m9455isFailureimpl(r157) == false) goto L320;
        r157 = null;
    L320:
        if ((r157 instanceof Integer) == true) goto L322;
        r157 = null;
    L322:
        r144 = (Integer) r157;     // Catch: Throwable -> L337
        if (r144 != null) goto L344;
        IHybridHostService r159 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L337
        if (r159 == null) goto L328;
        Object r160 = r159.getHostABValue("ec_shop_activity_api_change", r100);     // Catch: Throwable -> L337
    L329:
        if (r160 != null) goto L331;
    L343:
        r144 = r100;
        goto L344
    L331:
        if ((r160 instanceof Integer) == false) goto L334;
        r101 = r160;
    L334:
        r144 = (Integer) r101;     // Catch: Throwable -> L337
        if (r144 != null) goto L344;
    L328:
        r160 = null;
    L344:
        d.d("ec_shop_activity_api_change", r144);     // Catch: Throwable -> L346
        goto L189
    L266:
        if ((r155 instanceof Integer) == true) goto L268;
        Object r161 = null;
    L269:
        r156 = (Integer) r161;     // Catch: Throwable -> L311
        if (r156 != null) goto L309;
        if ((r155 instanceof Number) == false) goto L296;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L281;
        Float r162 = Float.valueOf(((Number) r155).floatValue());     // Catch: Throwable -> L311
        if ((r162 instanceof Integer) == true) goto L279;
        r162 = null;
    L279:
        r156 = (Integer) r162;     // Catch: Throwable -> L311
        goto L309
    L281:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L287;
        Double r163 = Double.valueOf(((Number) r155).doubleValue());     // Catch: Throwable -> L311
        if ((r163 instanceof Integer) == true) goto L285;
        r163 = null;
    L285:
        r156 = (Integer) r163;     // Catch: Throwable -> L311
        goto L309
    L287:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L290;
        r156 = Integer.valueOf(((Number) r155).intValue());     // Catch: Throwable -> L311
        goto L309
    L290:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L296;
        Long r164 = Long.valueOf(((Number) r155).longValue());     // Catch: Throwable -> L311
        if ((r164 instanceof Integer) == true) goto L294;
        r164 = null;
    L294:
        r156 = (Integer) r164;     // Catch: Throwable -> L311
    L296:
        if ((r155 instanceof JSONObject) == false) goto L298;
    L377:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L304
        Object r165 = SDKSettingsCacheManager.a().fromJson(r155.toString(), Integer.class);     // Catch: Throwable -> L304
        if ((r165 instanceof Integer) == true) goto L302;
        r165 = null;
    L302:
        Object r166 = Result.m9449constructorimpl((Integer) r165);     // Catch: Throwable -> L304
    L306:
        r156 = r166;
        if (Result.m9455isFailureimpl(r156) == false) goto L309;
    L304:
        th = move-exception;
        Result.Companion r167 = Result.Companion;     // Catch: Throwable -> L311
        r166 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L311
        goto L306
    L298:
        if ((r155 instanceof JSONArray) == false) goto L308;
    L268:
        r161 = r155;
    L337:
        th = move-exception;
        Result.Companion r168 = Result.Companion;     // Catch: Throwable -> L346
        r144 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L346
        Throwable r169 = Result.m9452exceptionOrNullimpl(r144);     // Catch: Throwable -> L346
        if (r169 == null) goto L342;
        EnsureManager.ensureNotReachHere(r169);     // Catch: Throwable -> L346
    L342:
        if (Result.m9455isFailureimpl(r144) == false) goto L344;
    L311:
        th = move-exception;
        Result.Companion r170 = Result.Companion;     // Catch: Throwable -> L337
        r157 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L337
        goto L313
    L196:
        if ((r149 instanceof Integer) == true) goto L198;
        Object r171 = null;
    L199:
        r150 = (Integer) r171;     // Catch: Throwable -> L241
        if (r150 != null) goto L239;
        if ((r149 instanceof Number) == false) goto L226;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L211;
        Float r172 = Float.valueOf(((Number) r149).floatValue());     // Catch: Throwable -> L241
        if ((r172 instanceof Integer) == true) goto L209;
        r172 = null;
    L209:
        r150 = (Integer) r172;     // Catch: Throwable -> L241
        goto L239
    L211:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L217;
        Double r173 = Double.valueOf(((Number) r149).doubleValue());     // Catch: Throwable -> L241
        if ((r173 instanceof Integer) == true) goto L215;
        r173 = null;
    L215:
        r150 = (Integer) r173;     // Catch: Throwable -> L241
        goto L239
    L217:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L220;
        r150 = Integer.valueOf(((Number) r149).intValue());     // Catch: Throwable -> L241
        goto L239
    L220:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L226;
        Long r174 = Long.valueOf(((Number) r149).longValue());     // Catch: Throwable -> L241
        if ((r174 instanceof Integer) == true) goto L224;
        r174 = null;
    L224:
        r150 = (Integer) r174;     // Catch: Throwable -> L241
    L226:
        if ((r149 instanceof JSONObject) == false) goto L228;
    L375:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L234
        Object r175 = SDKSettingsCacheManager.a().fromJson(r149.toString(), Integer.class);     // Catch: Throwable -> L234
        if ((r175 instanceof Integer) == true) goto L232;
        r175 = null;
    L232:
        Object r176 = Result.m9449constructorimpl((Integer) r175);     // Catch: Throwable -> L234
    L236:
        r150 = r176;
        if (Result.m9455isFailureimpl(r150) == false) goto L239;
    L234:
        th = move-exception;
        Result.Companion r177 = Result.Companion;     // Catch: Throwable -> L241
        r176 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L241
        goto L236
    L228:
        if ((r149 instanceof JSONArray) == false) goto L238;
    L198:
        r171 = r149;
    L241:
        th = move-exception;
        Result.Companion r178 = Result.Companion;     // Catch: Throwable -> L346
        r151 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L346
    L346:
        th = move-exception;
        Result.Companion r179 = Result.Companion;
        r144 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r180 = Result.m9452exceptionOrNullimpl(r144);
        if (r180 == null) goto L351;
        EnsureManager.ensureNotReachHere(r180);
    L351:
        if (Result.m9455isFailureimpl(r144) == false) goto L189;
        goto L189
    }

    @HostExperimentKey(author = "chenlong.hz", desc = "店铺UI升级")
    @SettingReport
    public static final int getEC_SHOP_BRAND_SHOP_UI_UPGRADE() {
        Object r100 = 0;
        Object r101 = null;
        if (Intrinsics.areEqual("brand_shop_ui_upgrade", "ec_shop_launch_opt_common_2") == false) goto L179;
        if (f186139b != null) goto L173;
        int r102 = n.f45241a;
        int r103 = com.bytedance.android.ec.base.settings.a.f42813a;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L163
        Object r105 = d.f42818c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L57
        if (r105 != null) goto L12;
    L54:
        Object r106 = null;
    L55:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L57
    L59:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);     // Catch: Throwable -> L163
        if (r108 == null) goto L63;
        EnsureManager.ensureNotReachHere(r108);     // Catch: Throwable -> L163
    L63:
        if (Result.m9455isFailureimpl(r107) == false) goto L66;
        r107 = null;
    L66:
        if ((r107 instanceof Integer) == true) goto L68;
        r107 = null;
    L68:
        Object r109 = (Integer) r107;     // Catch: Throwable -> L163
        if (r109 != null) goto L75;
        Object r110 = d.f42816a.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L163
        if ((r110 instanceof Integer) == true) goto L74;
        r110 = null;
    L74:
        r109 = (Integer) r110;     // Catch: Throwable -> L163
    L75:
        if (r109 != null) goto L172;
        int r111 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L163
        Object r112 = d.f42818c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L127
        if (r112 != null) goto L82;
    L124:
        Object r113 = null;
    L125:
        Object r114 = Result.m9449constructorimpl(r113);     // Catch: Throwable -> L127
    L129:
        Throwable r115 = Result.m9452exceptionOrNullimpl(r114);     // Catch: Throwable -> L154
        if (r115 == null) goto L133;
        EnsureManager.ensureNotReachHere(r115);     // Catch: Throwable -> L154
    L133:
        if (Result.m9455isFailureimpl(r114) == false) goto L136;
        r114 = null;
    L136:
        if ((r114 instanceof Integer) == true) goto L138;
        r114 = null;
    L138:
        r109 = (Integer) r114;     // Catch: Throwable -> L154
        if (r109 != null) goto L161;
        IHybridHostService r116 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L154
        if (r116 == null) goto L144;
        Object r117 = r116.getHostABValue("ec_shop_launch_opt_common_2", r100);     // Catch: Throwable -> L154
    L145:
        if (r117 != null) goto L147;
    L160:
        r109 = r100;
        goto L161
    L147:
        if ((r117 instanceof Integer) == false) goto L150;
        r101 = r117;
    L150:
        Integer r118 = (Integer) r101;     // Catch: Throwable -> L154
        if (r118 == null) goto L160;
        r109 = r118;
        goto L161
    L154:
        th = move-exception;
        Result.Companion r119 = Result.Companion;     // Catch: Throwable -> L163
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
        Throwable r120 = Result.m9452exceptionOrNullimpl(r109);     // Catch: Throwable -> L163
        if (r120 == null) goto L159;
        EnsureManager.ensureNotReachHere(r120);     // Catch: Throwable -> L163
    L159:
        if (Result.m9455isFailureimpl(r109) == false) goto L161;
    L144:
        r117 = null;
    L161:
        d.d("ec_shop_launch_opt_common_2", r109);     // Catch: Throwable -> L163
        goto L172
    L82:
        if ((r112 instanceof Integer) == true) goto L84;
        Object r121 = null;
    L85:
        r113 = (Integer) r121;     // Catch: Throwable -> L127
        if (r113 != null) goto L125;
        if ((r112 instanceof Number) == false) goto L112;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r122 = Float.valueOf(((Number) r112).floatValue());     // Catch: Throwable -> L127
        if ((r122 instanceof Integer) == true) goto L95;
        r122 = null;
    L95:
        r113 = (Integer) r122;     // Catch: Throwable -> L127
        goto L125
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r123 = Double.valueOf(((Number) r112).doubleValue());     // Catch: Throwable -> L127
        if ((r123 instanceof Integer) == true) goto L101;
        r123 = null;
    L101:
        r113 = (Integer) r123;     // Catch: Throwable -> L127
        goto L125
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L106;
        r113 = Integer.valueOf(((Number) r112).intValue());     // Catch: Throwable -> L127
        goto L125
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L112;
        Long r124 = Long.valueOf(((Number) r112).longValue());     // Catch: Throwable -> L127
        if ((r124 instanceof Integer) == true) goto L110;
        r124 = null;
    L110:
        r113 = (Integer) r124;     // Catch: Throwable -> L127
    L112:
        if ((r112 instanceof JSONObject) == false) goto L114;
    L366:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L120
        Object r125 = SDKSettingsCacheManager.a().fromJson(r112.toString(), Integer.class);     // Catch: Throwable -> L120
        if ((r125 instanceof Integer) == true) goto L118;
        r125 = null;
    L118:
        Object r126 = Result.m9449constructorimpl((Integer) r125);     // Catch: Throwable -> L120
    L122:
        r113 = r126;
        if (Result.m9455isFailureimpl(r113) == false) goto L125;
    L120:
        th = move-exception;
        Result.Companion r127 = Result.Companion;     // Catch: Throwable -> L127
        r126 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L127
        goto L122
    L114:
        if ((r112 instanceof JSONArray) == false) goto L124;
    L84:
        r121 = r112;
    L127:
        th = move-exception;
        Result.Companion r128 = Result.Companion;     // Catch: Throwable -> L154
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L154
    L172:
        f186139b = (Integer) r109;
        goto L173
    L12:
        if ((r105 instanceof Integer) == true) goto L14;
        Object r129 = null;
    L15:
        r106 = (Integer) r129;     // Catch: Throwable -> L57
        if (r106 != null) goto L55;
        if ((r105 instanceof Number) == false) goto L42;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L27;
        Float r130 = Float.valueOf(((Number) r105).floatValue());     // Catch: Throwable -> L57
        if ((r130 instanceof Integer) == true) goto L25;
        r130 = null;
    L25:
        r106 = (Integer) r130;     // Catch: Throwable -> L57
        goto L55
    L27:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L33;
        Double r131 = Double.valueOf(((Number) r105).doubleValue());     // Catch: Throwable -> L57
        if ((r131 instanceof Integer) == true) goto L31;
        r131 = null;
    L31:
        r106 = (Integer) r131;     // Catch: Throwable -> L57
        goto L55
    L33:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L36;
        r106 = Integer.valueOf(((Number) r105).intValue());     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L42;
        Long r132 = Long.valueOf(((Number) r105).longValue());     // Catch: Throwable -> L57
        if ((r132 instanceof Integer) == true) goto L40;
        r132 = null;
    L40:
        r106 = (Integer) r132;     // Catch: Throwable -> L57
    L42:
        if ((r105 instanceof JSONObject) == false) goto L44;
    L364:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L50
        Object r133 = SDKSettingsCacheManager.a().fromJson(r105.toString(), Integer.class);     // Catch: Throwable -> L50
        if ((r133 instanceof Integer) == true) goto L48;
        r133 = null;
    L48:
        Object r134 = Result.m9449constructorimpl((Integer) r133);     // Catch: Throwable -> L50
    L52:
        r106 = r134;
        if (Result.m9455isFailureimpl(r106) == false) goto L55;
    L50:
        th = move-exception;
        Result.Companion r135 = Result.Companion;     // Catch: Throwable -> L57
        r134 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L52
    L44:
        if ((r105 instanceof JSONArray) == false) goto L54;
    L14:
        r129 = r105;
    L57:
        th = move-exception;
        Result.Companion r136 = Result.Companion;     // Catch: Throwable -> L163
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
    L163:
        th = move-exception;
        Result.Companion r137 = Result.Companion;
        Object r138 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r139 = Result.m9452exceptionOrNullimpl(r138);
        if (r139 == null) goto L168;
        EnsureManager.ensureNotReachHere(r139);
    L168:
        if (Result.m9455isFailureimpl(r138) == true) goto L171;
        r100 = r138;
    L171:
        r109 = r100;
    L173:
        Object r140 = f186139b;
        if (r140 == null) goto L177;
    L354:
        f186138a.put("brand_shop_ui_upgrade", r140);
        return ((Number) r140).intValue();
    L177:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L179:
        if (Intrinsics.areEqual("HostExperiment", "ShopSetting") == false) goto L190;
        int r141 = p.f45243a;
        Result.Companion r142 = Result.Companion;     // Catch: Throwable -> L185
        jj4.b r143 = jj4.b.f499326b;     // Catch: Throwable -> L185
        r140 = jj4.a.a("brand_shop_ui_upgrade", Integer.class, r100, false);     // Catch: Throwable -> L185
        if (r140 != null) goto L354;
        Intrinsics.throwNpe();     // Catch: Throwable -> L185
    L185:
        th = move-exception;
        Result.Companion r144 = Result.Companion;
        Object r145 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r145) == true) goto L353;
    L189:
        r100 = r145;
    L353:
        r140 = r100;
        goto L354
    L190:
        int r146 = n.f45241a;
        int r147 = com.bytedance.android.ec.base.settings.a.f42813a;
        Result.Companion r148 = Result.Companion;     // Catch: Throwable -> L347
        Object r149 = d.f42818c.get("brand_shop_ui_upgrade");     // Catch: Throwable -> L241
        if (r149 != null) goto L196;
    L238:
        Object r150 = null;
    L239:
        Object r151 = Result.m9449constructorimpl(r150);     // Catch: Throwable -> L241
    L243:
        Throwable r152 = Result.m9452exceptionOrNullimpl(r151);     // Catch: Throwable -> L347
        if (r152 == null) goto L247;
        EnsureManager.ensureNotReachHere(r152);     // Catch: Throwable -> L347
    L247:
        if (Result.m9455isFailureimpl(r151) == false) goto L250;
        r151 = null;
    L250:
        if ((r151 instanceof Integer) == true) goto L252;
        r151 = null;
    L252:
        r140 = (Integer) r151;     // Catch: Throwable -> L347
        if (r140 != null) goto L259;
        Object r153 = d.f42816a.get("brand_shop_ui_upgrade");     // Catch: Throwable -> L347
        if ((r153 instanceof Integer) == true) goto L258;
        r153 = null;
    L258:
        r140 = (Integer) r153;     // Catch: Throwable -> L347
    L259:
        if (r140 != null) goto L354;
        int r154 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L347
        Object r155 = d.f42818c.get("brand_shop_ui_upgrade");     // Catch: Throwable -> L311
        if (r155 != null) goto L266;
    L308:
        Object r156 = null;
    L309:
        Object r157 = Result.m9449constructorimpl(r156);     // Catch: Throwable -> L311
    L313:
        Throwable r158 = Result.m9452exceptionOrNullimpl(r157);     // Catch: Throwable -> L338
        if (r158 == null) goto L317;
        EnsureManager.ensureNotReachHere(r158);     // Catch: Throwable -> L338
    L317:
        if (Result.m9455isFailureimpl(r157) == false) goto L320;
        r157 = null;
    L320:
        if ((r157 instanceof Integer) == true) goto L322;
        r157 = null;
    L322:
        r140 = (Integer) r157;     // Catch: Throwable -> L338
        if (r140 != null) goto L345;
        IHybridHostService r159 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L338
        if (r159 == null) goto L328;
        Object r160 = r159.getHostABValue("brand_shop_ui_upgrade", r100);     // Catch: Throwable -> L338
    L329:
        if (r160 != null) goto L331;
    L344:
        r140 = r100;
        goto L345
    L331:
        if ((r160 instanceof Integer) == false) goto L334;
        r101 = r160;
    L334:
        Integer r161 = (Integer) r101;     // Catch: Throwable -> L338
        if (r161 == null) goto L344;
        r140 = r161;
        goto L345
    L338:
        th = move-exception;
        Result.Companion r162 = Result.Companion;     // Catch: Throwable -> L347
        r140 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L347
        Throwable r163 = Result.m9452exceptionOrNullimpl(r140);     // Catch: Throwable -> L347
        if (r163 == null) goto L343;
        EnsureManager.ensureNotReachHere(r163);     // Catch: Throwable -> L347
    L343:
        if (Result.m9455isFailureimpl(r140) == false) goto L345;
    L328:
        r160 = null;
    L345:
        d.d("brand_shop_ui_upgrade", r140);     // Catch: Throwable -> L347
        goto L354
    L266:
        if ((r155 instanceof Integer) == true) goto L268;
        Object r164 = null;
    L269:
        r156 = (Integer) r164;     // Catch: Throwable -> L311
        if (r156 != null) goto L309;
        if ((r155 instanceof Number) == false) goto L296;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L281;
        Float r165 = Float.valueOf(((Number) r155).floatValue());     // Catch: Throwable -> L311
        if ((r165 instanceof Integer) == true) goto L279;
        r165 = null;
    L279:
        r156 = (Integer) r165;     // Catch: Throwable -> L311
        goto L309
    L281:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L287;
        Double r166 = Double.valueOf(((Number) r155).doubleValue());     // Catch: Throwable -> L311
        if ((r166 instanceof Integer) == true) goto L285;
        r166 = null;
    L285:
        r156 = (Integer) r166;     // Catch: Throwable -> L311
        goto L309
    L287:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L290;
        r156 = Integer.valueOf(((Number) r155).intValue());     // Catch: Throwable -> L311
        goto L309
    L290:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L296;
        Long r167 = Long.valueOf(((Number) r155).longValue());     // Catch: Throwable -> L311
        if ((r167 instanceof Integer) == true) goto L294;
        r167 = null;
    L294:
        r156 = (Integer) r167;     // Catch: Throwable -> L311
    L296:
        if ((r155 instanceof JSONObject) == false) goto L298;
    L380:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L304
        Object r168 = SDKSettingsCacheManager.a().fromJson(r155.toString(), Integer.class);     // Catch: Throwable -> L304
        if ((r168 instanceof Integer) == true) goto L302;
        r168 = null;
    L302:
        Object r169 = Result.m9449constructorimpl((Integer) r168);     // Catch: Throwable -> L304
    L306:
        r156 = r169;
        if (Result.m9455isFailureimpl(r156) == false) goto L309;
    L304:
        th = move-exception;
        Result.Companion r170 = Result.Companion;     // Catch: Throwable -> L311
        r169 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L311
        goto L306
    L298:
        if ((r155 instanceof JSONArray) == false) goto L308;
    L268:
        r164 = r155;
    L311:
        th = move-exception;
        Result.Companion r171 = Result.Companion;     // Catch: Throwable -> L338
        r157 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L338
        goto L313
    L196:
        if ((r149 instanceof Integer) == true) goto L198;
        Object r172 = null;
    L199:
        r150 = (Integer) r172;     // Catch: Throwable -> L241
        if (r150 != null) goto L239;
        if ((r149 instanceof Number) == false) goto L226;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L211;
        Float r173 = Float.valueOf(((Number) r149).floatValue());     // Catch: Throwable -> L241
        if ((r173 instanceof Integer) == true) goto L209;
        r173 = null;
    L209:
        r150 = (Integer) r173;     // Catch: Throwable -> L241
        goto L239
    L211:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L217;
        Double r174 = Double.valueOf(((Number) r149).doubleValue());     // Catch: Throwable -> L241
        if ((r174 instanceof Integer) == true) goto L215;
        r174 = null;
    L215:
        r150 = (Integer) r174;     // Catch: Throwable -> L241
        goto L239
    L217:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L220;
        r150 = Integer.valueOf(((Number) r149).intValue());     // Catch: Throwable -> L241
        goto L239
    L220:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L226;
        Long r175 = Long.valueOf(((Number) r149).longValue());     // Catch: Throwable -> L241
        if ((r175 instanceof Integer) == true) goto L224;
        r175 = null;
    L224:
        r150 = (Integer) r175;     // Catch: Throwable -> L241
    L226:
        if ((r149 instanceof JSONObject) == false) goto L228;
    L378:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L234
        Object r176 = SDKSettingsCacheManager.a().fromJson(r149.toString(), Integer.class);     // Catch: Throwable -> L234
        if ((r176 instanceof Integer) == true) goto L232;
        r176 = null;
    L232:
        Object r177 = Result.m9449constructorimpl((Integer) r176);     // Catch: Throwable -> L234
    L236:
        r150 = r177;
        if (Result.m9455isFailureimpl(r150) == false) goto L239;
    L234:
        th = move-exception;
        Result.Companion r178 = Result.Companion;     // Catch: Throwable -> L241
        r177 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L241
        goto L236
    L228:
        if ((r149 instanceof JSONArray) == false) goto L238;
    L198:
        r172 = r149;
    L241:
        th = move-exception;
        Result.Companion r179 = Result.Companion;     // Catch: Throwable -> L347
        r151 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L347
    L347:
        th = move-exception;
        Result.Companion r180 = Result.Companion;
        r145 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r181 = Result.m9452exceptionOrNullimpl(r145);
        if (r181 == null) goto L352;
        EnsureManager.ensureNotReachHere(r181);
    L352:
        if (Result.m9455isFailureimpl(r145) == false) goto L189;
        goto L189
    }

    @HostExperimentKey(author = "chenlong.hz", desc = "商列接cardpack")
    @SettingReport
    public static final int getEC_SHOP_CARD_PACK() {
        Object r100 = 0;
        Object r101 = null;
        if (Intrinsics.areEqual("ec_shop_product_cardpack", "ec_shop_launch_opt_common_2") == false) goto L179;
        if (f186139b != null) goto L173;
        int r102 = n.f45241a;
        int r103 = com.bytedance.android.ec.base.settings.a.f42813a;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L163
        Object r105 = d.f42818c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L57
        if (r105 != null) goto L12;
    L54:
        Object r106 = null;
    L55:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L57
    L59:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);     // Catch: Throwable -> L163
        if (r108 == null) goto L63;
        EnsureManager.ensureNotReachHere(r108);     // Catch: Throwable -> L163
    L63:
        if (Result.m9455isFailureimpl(r107) == false) goto L66;
        r107 = null;
    L66:
        if ((r107 instanceof Integer) == true) goto L68;
        r107 = null;
    L68:
        Object r109 = (Integer) r107;     // Catch: Throwable -> L163
        if (r109 != null) goto L75;
        Object r110 = d.f42816a.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L163
        if ((r110 instanceof Integer) == true) goto L74;
        r110 = null;
    L74:
        r109 = (Integer) r110;     // Catch: Throwable -> L163
    L75:
        if (r109 != null) goto L172;
        int r111 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L163
        Object r112 = d.f42818c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L127
        if (r112 != null) goto L82;
    L124:
        Object r113 = null;
    L125:
        Object r114 = Result.m9449constructorimpl(r113);     // Catch: Throwable -> L127
    L129:
        Throwable r115 = Result.m9452exceptionOrNullimpl(r114);     // Catch: Throwable -> L154
        if (r115 == null) goto L133;
        EnsureManager.ensureNotReachHere(r115);     // Catch: Throwable -> L154
    L133:
        if (Result.m9455isFailureimpl(r114) == false) goto L136;
        r114 = null;
    L136:
        if ((r114 instanceof Integer) == true) goto L138;
        r114 = null;
    L138:
        r109 = (Integer) r114;     // Catch: Throwable -> L154
        if (r109 != null) goto L161;
        IHybridHostService r116 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L154
        if (r116 == null) goto L144;
        Object r117 = r116.getHostABValue("ec_shop_launch_opt_common_2", r100);     // Catch: Throwable -> L154
    L145:
        if (r117 != null) goto L147;
    L160:
        r109 = r100;
        goto L161
    L147:
        if ((r117 instanceof Integer) == false) goto L150;
        r101 = r117;
    L150:
        Integer r118 = (Integer) r101;     // Catch: Throwable -> L154
        if (r118 == null) goto L160;
        r109 = r118;
        goto L161
    L154:
        th = move-exception;
        Result.Companion r119 = Result.Companion;     // Catch: Throwable -> L163
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
        Throwable r120 = Result.m9452exceptionOrNullimpl(r109);     // Catch: Throwable -> L163
        if (r120 == null) goto L159;
        EnsureManager.ensureNotReachHere(r120);     // Catch: Throwable -> L163
    L159:
        if (Result.m9455isFailureimpl(r109) == false) goto L161;
    L144:
        r117 = null;
    L161:
        d.d("ec_shop_launch_opt_common_2", r109);     // Catch: Throwable -> L163
        goto L172
    L82:
        if ((r112 instanceof Integer) == true) goto L84;
        Object r121 = null;
    L85:
        r113 = (Integer) r121;     // Catch: Throwable -> L127
        if (r113 != null) goto L125;
        if ((r112 instanceof Number) == false) goto L112;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r122 = Float.valueOf(((Number) r112).floatValue());     // Catch: Throwable -> L127
        if ((r122 instanceof Integer) == true) goto L95;
        r122 = null;
    L95:
        r113 = (Integer) r122;     // Catch: Throwable -> L127
        goto L125
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r123 = Double.valueOf(((Number) r112).doubleValue());     // Catch: Throwable -> L127
        if ((r123 instanceof Integer) == true) goto L101;
        r123 = null;
    L101:
        r113 = (Integer) r123;     // Catch: Throwable -> L127
        goto L125
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L106;
        r113 = Integer.valueOf(((Number) r112).intValue());     // Catch: Throwable -> L127
        goto L125
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L112;
        Long r124 = Long.valueOf(((Number) r112).longValue());     // Catch: Throwable -> L127
        if ((r124 instanceof Integer) == true) goto L110;
        r124 = null;
    L110:
        r113 = (Integer) r124;     // Catch: Throwable -> L127
    L112:
        if ((r112 instanceof JSONObject) == false) goto L114;
    L366:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L120
        Object r125 = SDKSettingsCacheManager.a().fromJson(r112.toString(), Integer.class);     // Catch: Throwable -> L120
        if ((r125 instanceof Integer) == true) goto L118;
        r125 = null;
    L118:
        Object r126 = Result.m9449constructorimpl((Integer) r125);     // Catch: Throwable -> L120
    L122:
        r113 = r126;
        if (Result.m9455isFailureimpl(r113) == false) goto L125;
    L120:
        th = move-exception;
        Result.Companion r127 = Result.Companion;     // Catch: Throwable -> L127
        r126 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L127
        goto L122
    L114:
        if ((r112 instanceof JSONArray) == false) goto L124;
    L84:
        r121 = r112;
    L127:
        th = move-exception;
        Result.Companion r128 = Result.Companion;     // Catch: Throwable -> L154
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L154
    L172:
        f186139b = (Integer) r109;
        goto L173
    L12:
        if ((r105 instanceof Integer) == true) goto L14;
        Object r129 = null;
    L15:
        r106 = (Integer) r129;     // Catch: Throwable -> L57
        if (r106 != null) goto L55;
        if ((r105 instanceof Number) == false) goto L42;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L27;
        Float r130 = Float.valueOf(((Number) r105).floatValue());     // Catch: Throwable -> L57
        if ((r130 instanceof Integer) == true) goto L25;
        r130 = null;
    L25:
        r106 = (Integer) r130;     // Catch: Throwable -> L57
        goto L55
    L27:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L33;
        Double r131 = Double.valueOf(((Number) r105).doubleValue());     // Catch: Throwable -> L57
        if ((r131 instanceof Integer) == true) goto L31;
        r131 = null;
    L31:
        r106 = (Integer) r131;     // Catch: Throwable -> L57
        goto L55
    L33:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L36;
        r106 = Integer.valueOf(((Number) r105).intValue());     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L42;
        Long r132 = Long.valueOf(((Number) r105).longValue());     // Catch: Throwable -> L57
        if ((r132 instanceof Integer) == true) goto L40;
        r132 = null;
    L40:
        r106 = (Integer) r132;     // Catch: Throwable -> L57
    L42:
        if ((r105 instanceof JSONObject) == false) goto L44;
    L364:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L50
        Object r133 = SDKSettingsCacheManager.a().fromJson(r105.toString(), Integer.class);     // Catch: Throwable -> L50
        if ((r133 instanceof Integer) == true) goto L48;
        r133 = null;
    L48:
        Object r134 = Result.m9449constructorimpl((Integer) r133);     // Catch: Throwable -> L50
    L52:
        r106 = r134;
        if (Result.m9455isFailureimpl(r106) == false) goto L55;
    L50:
        th = move-exception;
        Result.Companion r135 = Result.Companion;     // Catch: Throwable -> L57
        r134 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L52
    L44:
        if ((r105 instanceof JSONArray) == false) goto L54;
    L14:
        r129 = r105;
    L57:
        th = move-exception;
        Result.Companion r136 = Result.Companion;     // Catch: Throwable -> L163
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
    L163:
        th = move-exception;
        Result.Companion r137 = Result.Companion;
        Object r138 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r139 = Result.m9452exceptionOrNullimpl(r138);
        if (r139 == null) goto L168;
        EnsureManager.ensureNotReachHere(r139);
    L168:
        if (Result.m9455isFailureimpl(r138) == true) goto L171;
        r100 = r138;
    L171:
        r109 = r100;
    L173:
        Object r140 = f186139b;
        if (r140 == null) goto L177;
    L354:
        f186138a.put("ec_shop_product_cardpack", r140);
        return ((Number) r140).intValue();
    L177:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L179:
        if (Intrinsics.areEqual("HostExperiment", "ShopSetting") == false) goto L190;
        int r141 = p.f45243a;
        Result.Companion r142 = Result.Companion;     // Catch: Throwable -> L185
        jj4.b r143 = jj4.b.f499326b;     // Catch: Throwable -> L185
        r140 = jj4.a.a("ec_shop_product_cardpack", Integer.class, r100, false);     // Catch: Throwable -> L185
        if (r140 != null) goto L354;
        Intrinsics.throwNpe();     // Catch: Throwable -> L185
    L185:
        th = move-exception;
        Result.Companion r144 = Result.Companion;
        Object r145 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r145) == true) goto L353;
    L189:
        r100 = r145;
    L353:
        r140 = r100;
        goto L354
    L190:
        int r146 = n.f45241a;
        int r147 = com.bytedance.android.ec.base.settings.a.f42813a;
        Result.Companion r148 = Result.Companion;     // Catch: Throwable -> L347
        Object r149 = d.f42818c.get("ec_shop_product_cardpack");     // Catch: Throwable -> L241
        if (r149 != null) goto L196;
    L238:
        Object r150 = null;
    L239:
        Object r151 = Result.m9449constructorimpl(r150);     // Catch: Throwable -> L241
    L243:
        Throwable r152 = Result.m9452exceptionOrNullimpl(r151);     // Catch: Throwable -> L347
        if (r152 == null) goto L247;
        EnsureManager.ensureNotReachHere(r152);     // Catch: Throwable -> L347
    L247:
        if (Result.m9455isFailureimpl(r151) == false) goto L250;
        r151 = null;
    L250:
        if ((r151 instanceof Integer) == true) goto L252;
        r151 = null;
    L252:
        r140 = (Integer) r151;     // Catch: Throwable -> L347
        if (r140 != null) goto L259;
        Object r153 = d.f42816a.get("ec_shop_product_cardpack");     // Catch: Throwable -> L347
        if ((r153 instanceof Integer) == true) goto L258;
        r153 = null;
    L258:
        r140 = (Integer) r153;     // Catch: Throwable -> L347
    L259:
        if (r140 != null) goto L354;
        int r154 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L347
        Object r155 = d.f42818c.get("ec_shop_product_cardpack");     // Catch: Throwable -> L311
        if (r155 != null) goto L266;
    L308:
        Object r156 = null;
    L309:
        Object r157 = Result.m9449constructorimpl(r156);     // Catch: Throwable -> L311
    L313:
        Throwable r158 = Result.m9452exceptionOrNullimpl(r157);     // Catch: Throwable -> L338
        if (r158 == null) goto L317;
        EnsureManager.ensureNotReachHere(r158);     // Catch: Throwable -> L338
    L317:
        if (Result.m9455isFailureimpl(r157) == false) goto L320;
        r157 = null;
    L320:
        if ((r157 instanceof Integer) == true) goto L322;
        r157 = null;
    L322:
        r140 = (Integer) r157;     // Catch: Throwable -> L338
        if (r140 != null) goto L345;
        IHybridHostService r159 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L338
        if (r159 == null) goto L328;
        Object r160 = r159.getHostABValue("ec_shop_product_cardpack", r100);     // Catch: Throwable -> L338
    L329:
        if (r160 != null) goto L331;
    L344:
        r140 = r100;
        goto L345
    L331:
        if ((r160 instanceof Integer) == false) goto L334;
        r101 = r160;
    L334:
        Integer r161 = (Integer) r101;     // Catch: Throwable -> L338
        if (r161 == null) goto L344;
        r140 = r161;
        goto L345
    L338:
        th = move-exception;
        Result.Companion r162 = Result.Companion;     // Catch: Throwable -> L347
        r140 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L347
        Throwable r163 = Result.m9452exceptionOrNullimpl(r140);     // Catch: Throwable -> L347
        if (r163 == null) goto L343;
        EnsureManager.ensureNotReachHere(r163);     // Catch: Throwable -> L347
    L343:
        if (Result.m9455isFailureimpl(r140) == false) goto L345;
    L328:
        r160 = null;
    L345:
        d.d("ec_shop_product_cardpack", r140);     // Catch: Throwable -> L347
        goto L354
    L266:
        if ((r155 instanceof Integer) == true) goto L268;
        Object r164 = null;
    L269:
        r156 = (Integer) r164;     // Catch: Throwable -> L311
        if (r156 != null) goto L309;
        if ((r155 instanceof Number) == false) goto L296;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L281;
        Float r165 = Float.valueOf(((Number) r155).floatValue());     // Catch: Throwable -> L311
        if ((r165 instanceof Integer) == true) goto L279;
        r165 = null;
    L279:
        r156 = (Integer) r165;     // Catch: Throwable -> L311
        goto L309
    L281:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L287;
        Double r166 = Double.valueOf(((Number) r155).doubleValue());     // Catch: Throwable -> L311
        if ((r166 instanceof Integer) == true) goto L285;
        r166 = null;
    L285:
        r156 = (Integer) r166;     // Catch: Throwable -> L311
        goto L309
    L287:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L290;
        r156 = Integer.valueOf(((Number) r155).intValue());     // Catch: Throwable -> L311
        goto L309
    L290:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L296;
        Long r167 = Long.valueOf(((Number) r155).longValue());     // Catch: Throwable -> L311
        if ((r167 instanceof Integer) == true) goto L294;
        r167 = null;
    L294:
        r156 = (Integer) r167;     // Catch: Throwable -> L311
    L296:
        if ((r155 instanceof JSONObject) == false) goto L298;
    L380:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L304
        Object r168 = SDKSettingsCacheManager.a().fromJson(r155.toString(), Integer.class);     // Catch: Throwable -> L304
        if ((r168 instanceof Integer) == true) goto L302;
        r168 = null;
    L302:
        Object r169 = Result.m9449constructorimpl((Integer) r168);     // Catch: Throwable -> L304
    L306:
        r156 = r169;
        if (Result.m9455isFailureimpl(r156) == false) goto L309;
    L304:
        th = move-exception;
        Result.Companion r170 = Result.Companion;     // Catch: Throwable -> L311
        r169 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L311
        goto L306
    L298:
        if ((r155 instanceof JSONArray) == false) goto L308;
    L268:
        r164 = r155;
    L311:
        th = move-exception;
        Result.Companion r171 = Result.Companion;     // Catch: Throwable -> L338
        r157 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L338
        goto L313
    L196:
        if ((r149 instanceof Integer) == true) goto L198;
        Object r172 = null;
    L199:
        r150 = (Integer) r172;     // Catch: Throwable -> L241
        if (r150 != null) goto L239;
        if ((r149 instanceof Number) == false) goto L226;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L211;
        Float r173 = Float.valueOf(((Number) r149).floatValue());     // Catch: Throwable -> L241
        if ((r173 instanceof Integer) == true) goto L209;
        r173 = null;
    L209:
        r150 = (Integer) r173;     // Catch: Throwable -> L241
        goto L239
    L211:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L217;
        Double r174 = Double.valueOf(((Number) r149).doubleValue());     // Catch: Throwable -> L241
        if ((r174 instanceof Integer) == true) goto L215;
        r174 = null;
    L215:
        r150 = (Integer) r174;     // Catch: Throwable -> L241
        goto L239
    L217:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L220;
        r150 = Integer.valueOf(((Number) r149).intValue());     // Catch: Throwable -> L241
        goto L239
    L220:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L226;
        Long r175 = Long.valueOf(((Number) r149).longValue());     // Catch: Throwable -> L241
        if ((r175 instanceof Integer) == true) goto L224;
        r175 = null;
    L224:
        r150 = (Integer) r175;     // Catch: Throwable -> L241
    L226:
        if ((r149 instanceof JSONObject) == false) goto L228;
    L378:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L234
        Object r176 = SDKSettingsCacheManager.a().fromJson(r149.toString(), Integer.class);     // Catch: Throwable -> L234
        if ((r176 instanceof Integer) == true) goto L232;
        r176 = null;
    L232:
        Object r177 = Result.m9449constructorimpl((Integer) r176);     // Catch: Throwable -> L234
    L236:
        r150 = r177;
        if (Result.m9455isFailureimpl(r150) == false) goto L239;
    L234:
        th = move-exception;
        Result.Companion r178 = Result.Companion;     // Catch: Throwable -> L241
        r177 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L241
        goto L236
    L228:
        if ((r149 instanceof JSONArray) == false) goto L238;
    L198:
        r172 = r149;
    L241:
        th = move-exception;
        Result.Companion r179 = Result.Companion;     // Catch: Throwable -> L347
        r151 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L347
    L347:
        th = move-exception;
        Result.Companion r180 = Result.Companion;
        r145 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r181 = Result.m9452exceptionOrNullimpl(r145);
        if (r181 == null) goto L352;
        EnsureManager.ensureNotReachHere(r181);
    L352:
        if (Result.m9455isFailureimpl(r145) == false) goto L189;
        goto L189
    }

    @HostExperimentKey(author = "chenlong.hz", desc = "cardpack强制走本地")
    @SettingReport
    public static final int getEC_SHOP_CARD_PACK_FORCE_LOCAL() {
        Object r100 = 0;
        Object r101 = null;
        if (Intrinsics.areEqual("ec_shop_product_cardpack_force_local", "ec_shop_launch_opt_common_2") == false) goto L179;
        if (f186139b != null) goto L173;
        int r102 = n.f45241a;
        int r103 = com.bytedance.android.ec.base.settings.a.f42813a;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L163
        Object r105 = d.f42818c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L57
        if (r105 != null) goto L12;
    L54:
        Object r106 = null;
    L55:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L57
    L59:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);     // Catch: Throwable -> L163
        if (r108 == null) goto L63;
        EnsureManager.ensureNotReachHere(r108);     // Catch: Throwable -> L163
    L63:
        if (Result.m9455isFailureimpl(r107) == false) goto L66;
        r107 = null;
    L66:
        if ((r107 instanceof Integer) == true) goto L68;
        r107 = null;
    L68:
        Object r109 = (Integer) r107;     // Catch: Throwable -> L163
        if (r109 != null) goto L75;
        Object r110 = d.f42816a.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L163
        if ((r110 instanceof Integer) == true) goto L74;
        r110 = null;
    L74:
        r109 = (Integer) r110;     // Catch: Throwable -> L163
    L75:
        if (r109 != null) goto L172;
        int r111 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L163
        Object r112 = d.f42818c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L127
        if (r112 != null) goto L82;
    L124:
        Object r113 = null;
    L125:
        Object r114 = Result.m9449constructorimpl(r113);     // Catch: Throwable -> L127
    L129:
        Throwable r115 = Result.m9452exceptionOrNullimpl(r114);     // Catch: Throwable -> L154
        if (r115 == null) goto L133;
        EnsureManager.ensureNotReachHere(r115);     // Catch: Throwable -> L154
    L133:
        if (Result.m9455isFailureimpl(r114) == false) goto L136;
        r114 = null;
    L136:
        if ((r114 instanceof Integer) == true) goto L138;
        r114 = null;
    L138:
        r109 = (Integer) r114;     // Catch: Throwable -> L154
        if (r109 != null) goto L161;
        IHybridHostService r116 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L154
        if (r116 == null) goto L144;
        Object r117 = r116.getHostABValue("ec_shop_launch_opt_common_2", r100);     // Catch: Throwable -> L154
    L145:
        if (r117 != null) goto L147;
    L160:
        r109 = r100;
        goto L161
    L147:
        if ((r117 instanceof Integer) == false) goto L150;
        r101 = r117;
    L150:
        Integer r118 = (Integer) r101;     // Catch: Throwable -> L154
        if (r118 == null) goto L160;
        r109 = r118;
        goto L161
    L154:
        th = move-exception;
        Result.Companion r119 = Result.Companion;     // Catch: Throwable -> L163
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
        Throwable r120 = Result.m9452exceptionOrNullimpl(r109);     // Catch: Throwable -> L163
        if (r120 == null) goto L159;
        EnsureManager.ensureNotReachHere(r120);     // Catch: Throwable -> L163
    L159:
        if (Result.m9455isFailureimpl(r109) == false) goto L161;
    L144:
        r117 = null;
    L161:
        d.d("ec_shop_launch_opt_common_2", r109);     // Catch: Throwable -> L163
        goto L172
    L82:
        if ((r112 instanceof Integer) == true) goto L84;
        Object r121 = null;
    L85:
        r113 = (Integer) r121;     // Catch: Throwable -> L127
        if (r113 != null) goto L125;
        if ((r112 instanceof Number) == false) goto L112;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r122 = Float.valueOf(((Number) r112).floatValue());     // Catch: Throwable -> L127
        if ((r122 instanceof Integer) == true) goto L95;
        r122 = null;
    L95:
        r113 = (Integer) r122;     // Catch: Throwable -> L127
        goto L125
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r123 = Double.valueOf(((Number) r112).doubleValue());     // Catch: Throwable -> L127
        if ((r123 instanceof Integer) == true) goto L101;
        r123 = null;
    L101:
        r113 = (Integer) r123;     // Catch: Throwable -> L127
        goto L125
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L106;
        r113 = Integer.valueOf(((Number) r112).intValue());     // Catch: Throwable -> L127
        goto L125
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L112;
        Long r124 = Long.valueOf(((Number) r112).longValue());     // Catch: Throwable -> L127
        if ((r124 instanceof Integer) == true) goto L110;
        r124 = null;
    L110:
        r113 = (Integer) r124;     // Catch: Throwable -> L127
    L112:
        if ((r112 instanceof JSONObject) == false) goto L114;
    L366:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L120
        Object r125 = SDKSettingsCacheManager.a().fromJson(r112.toString(), Integer.class);     // Catch: Throwable -> L120
        if ((r125 instanceof Integer) == true) goto L118;
        r125 = null;
    L118:
        Object r126 = Result.m9449constructorimpl((Integer) r125);     // Catch: Throwable -> L120
    L122:
        r113 = r126;
        if (Result.m9455isFailureimpl(r113) == false) goto L125;
    L120:
        th = move-exception;
        Result.Companion r127 = Result.Companion;     // Catch: Throwable -> L127
        r126 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L127
        goto L122
    L114:
        if ((r112 instanceof JSONArray) == false) goto L124;
    L84:
        r121 = r112;
    L127:
        th = move-exception;
        Result.Companion r128 = Result.Companion;     // Catch: Throwable -> L154
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L154
    L172:
        f186139b = (Integer) r109;
        goto L173
    L12:
        if ((r105 instanceof Integer) == true) goto L14;
        Object r129 = null;
    L15:
        r106 = (Integer) r129;     // Catch: Throwable -> L57
        if (r106 != null) goto L55;
        if ((r105 instanceof Number) == false) goto L42;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L27;
        Float r130 = Float.valueOf(((Number) r105).floatValue());     // Catch: Throwable -> L57
        if ((r130 instanceof Integer) == true) goto L25;
        r130 = null;
    L25:
        r106 = (Integer) r130;     // Catch: Throwable -> L57
        goto L55
    L27:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L33;
        Double r131 = Double.valueOf(((Number) r105).doubleValue());     // Catch: Throwable -> L57
        if ((r131 instanceof Integer) == true) goto L31;
        r131 = null;
    L31:
        r106 = (Integer) r131;     // Catch: Throwable -> L57
        goto L55
    L33:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L36;
        r106 = Integer.valueOf(((Number) r105).intValue());     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L42;
        Long r132 = Long.valueOf(((Number) r105).longValue());     // Catch: Throwable -> L57
        if ((r132 instanceof Integer) == true) goto L40;
        r132 = null;
    L40:
        r106 = (Integer) r132;     // Catch: Throwable -> L57
    L42:
        if ((r105 instanceof JSONObject) == false) goto L44;
    L364:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L50
        Object r133 = SDKSettingsCacheManager.a().fromJson(r105.toString(), Integer.class);     // Catch: Throwable -> L50
        if ((r133 instanceof Integer) == true) goto L48;
        r133 = null;
    L48:
        Object r134 = Result.m9449constructorimpl((Integer) r133);     // Catch: Throwable -> L50
    L52:
        r106 = r134;
        if (Result.m9455isFailureimpl(r106) == false) goto L55;
    L50:
        th = move-exception;
        Result.Companion r135 = Result.Companion;     // Catch: Throwable -> L57
        r134 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L52
    L44:
        if ((r105 instanceof JSONArray) == false) goto L54;
    L14:
        r129 = r105;
    L57:
        th = move-exception;
        Result.Companion r136 = Result.Companion;     // Catch: Throwable -> L163
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
    L163:
        th = move-exception;
        Result.Companion r137 = Result.Companion;
        Object r138 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r139 = Result.m9452exceptionOrNullimpl(r138);
        if (r139 == null) goto L168;
        EnsureManager.ensureNotReachHere(r139);
    L168:
        if (Result.m9455isFailureimpl(r138) == true) goto L171;
        r100 = r138;
    L171:
        r109 = r100;
    L173:
        Object r140 = f186139b;
        if (r140 == null) goto L177;
    L354:
        f186138a.put("ec_shop_product_cardpack_force_local", r140);
        return ((Number) r140).intValue();
    L177:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L179:
        if (Intrinsics.areEqual("HostExperiment", "ShopSetting") == false) goto L190;
        int r141 = p.f45243a;
        Result.Companion r142 = Result.Companion;     // Catch: Throwable -> L185
        jj4.b r143 = jj4.b.f499326b;     // Catch: Throwable -> L185
        r140 = jj4.a.a("ec_shop_product_cardpack_force_local", Integer.class, r100, false);     // Catch: Throwable -> L185
        if (r140 != null) goto L354;
        Intrinsics.throwNpe();     // Catch: Throwable -> L185
    L185:
        th = move-exception;
        Result.Companion r144 = Result.Companion;
        Object r145 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r145) == true) goto L353;
    L189:
        r100 = r145;
    L353:
        r140 = r100;
        goto L354
    L190:
        int r146 = n.f45241a;
        int r147 = com.bytedance.android.ec.base.settings.a.f42813a;
        Result.Companion r148 = Result.Companion;     // Catch: Throwable -> L347
        Object r149 = d.f42818c.get("ec_shop_product_cardpack_force_local");     // Catch: Throwable -> L241
        if (r149 != null) goto L196;
    L238:
        Object r150 = null;
    L239:
        Object r151 = Result.m9449constructorimpl(r150);     // Catch: Throwable -> L241
    L243:
        Throwable r152 = Result.m9452exceptionOrNullimpl(r151);     // Catch: Throwable -> L347
        if (r152 == null) goto L247;
        EnsureManager.ensureNotReachHere(r152);     // Catch: Throwable -> L347
    L247:
        if (Result.m9455isFailureimpl(r151) == false) goto L250;
        r151 = null;
    L250:
        if ((r151 instanceof Integer) == true) goto L252;
        r151 = null;
    L252:
        r140 = (Integer) r151;     // Catch: Throwable -> L347
        if (r140 != null) goto L259;
        Object r153 = d.f42816a.get("ec_shop_product_cardpack_force_local");     // Catch: Throwable -> L347
        if ((r153 instanceof Integer) == true) goto L258;
        r153 = null;
    L258:
        r140 = (Integer) r153;     // Catch: Throwable -> L347
    L259:
        if (r140 != null) goto L354;
        int r154 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L347
        Object r155 = d.f42818c.get("ec_shop_product_cardpack_force_local");     // Catch: Throwable -> L311
        if (r155 != null) goto L266;
    L308:
        Object r156 = null;
    L309:
        Object r157 = Result.m9449constructorimpl(r156);     // Catch: Throwable -> L311
    L313:
        Throwable r158 = Result.m9452exceptionOrNullimpl(r157);     // Catch: Throwable -> L338
        if (r158 == null) goto L317;
        EnsureManager.ensureNotReachHere(r158);     // Catch: Throwable -> L338
    L317:
        if (Result.m9455isFailureimpl(r157) == false) goto L320;
        r157 = null;
    L320:
        if ((r157 instanceof Integer) == true) goto L322;
        r157 = null;
    L322:
        r140 = (Integer) r157;     // Catch: Throwable -> L338
        if (r140 != null) goto L345;
        IHybridHostService r159 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L338
        if (r159 == null) goto L328;
        Object r160 = r159.getHostABValue("ec_shop_product_cardpack_force_local", r100);     // Catch: Throwable -> L338
    L329:
        if (r160 != null) goto L331;
    L344:
        r140 = r100;
        goto L345
    L331:
        if ((r160 instanceof Integer) == false) goto L334;
        r101 = r160;
    L334:
        Integer r161 = (Integer) r101;     // Catch: Throwable -> L338
        if (r161 == null) goto L344;
        r140 = r161;
        goto L345
    L338:
        th = move-exception;
        Result.Companion r162 = Result.Companion;     // Catch: Throwable -> L347
        r140 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L347
        Throwable r163 = Result.m9452exceptionOrNullimpl(r140);     // Catch: Throwable -> L347
        if (r163 == null) goto L343;
        EnsureManager.ensureNotReachHere(r163);     // Catch: Throwable -> L347
    L343:
        if (Result.m9455isFailureimpl(r140) == false) goto L345;
    L328:
        r160 = null;
    L345:
        d.d("ec_shop_product_cardpack_force_local", r140);     // Catch: Throwable -> L347
        goto L354
    L266:
        if ((r155 instanceof Integer) == true) goto L268;
        Object r164 = null;
    L269:
        r156 = (Integer) r164;     // Catch: Throwable -> L311
        if (r156 != null) goto L309;
        if ((r155 instanceof Number) == false) goto L296;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L281;
        Float r165 = Float.valueOf(((Number) r155).floatValue());     // Catch: Throwable -> L311
        if ((r165 instanceof Integer) == true) goto L279;
        r165 = null;
    L279:
        r156 = (Integer) r165;     // Catch: Throwable -> L311
        goto L309
    L281:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L287;
        Double r166 = Double.valueOf(((Number) r155).doubleValue());     // Catch: Throwable -> L311
        if ((r166 instanceof Integer) == true) goto L285;
        r166 = null;
    L285:
        r156 = (Integer) r166;     // Catch: Throwable -> L311
        goto L309
    L287:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L290;
        r156 = Integer.valueOf(((Number) r155).intValue());     // Catch: Throwable -> L311
        goto L309
    L290:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L296;
        Long r167 = Long.valueOf(((Number) r155).longValue());     // Catch: Throwable -> L311
        if ((r167 instanceof Integer) == true) goto L294;
        r167 = null;
    L294:
        r156 = (Integer) r167;     // Catch: Throwable -> L311
    L296:
        if ((r155 instanceof JSONObject) == false) goto L298;
    L380:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L304
        Object r168 = SDKSettingsCacheManager.a().fromJson(r155.toString(), Integer.class);     // Catch: Throwable -> L304
        if ((r168 instanceof Integer) == true) goto L302;
        r168 = null;
    L302:
        Object r169 = Result.m9449constructorimpl((Integer) r168);     // Catch: Throwable -> L304
    L306:
        r156 = r169;
        if (Result.m9455isFailureimpl(r156) == false) goto L309;
    L304:
        th = move-exception;
        Result.Companion r170 = Result.Companion;     // Catch: Throwable -> L311
        r169 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L311
        goto L306
    L298:
        if ((r155 instanceof JSONArray) == false) goto L308;
    L268:
        r164 = r155;
    L311:
        th = move-exception;
        Result.Companion r171 = Result.Companion;     // Catch: Throwable -> L338
        r157 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L338
        goto L313
    L196:
        if ((r149 instanceof Integer) == true) goto L198;
        Object r172 = null;
    L199:
        r150 = (Integer) r172;     // Catch: Throwable -> L241
        if (r150 != null) goto L239;
        if ((r149 instanceof Number) == false) goto L226;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L211;
        Float r173 = Float.valueOf(((Number) r149).floatValue());     // Catch: Throwable -> L241
        if ((r173 instanceof Integer) == true) goto L209;
        r173 = null;
    L209:
        r150 = (Integer) r173;     // Catch: Throwable -> L241
        goto L239
    L211:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L217;
        Double r174 = Double.valueOf(((Number) r149).doubleValue());     // Catch: Throwable -> L241
        if ((r174 instanceof Integer) == true) goto L215;
        r174 = null;
    L215:
        r150 = (Integer) r174;     // Catch: Throwable -> L241
        goto L239
    L217:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L220;
        r150 = Integer.valueOf(((Number) r149).intValue());     // Catch: Throwable -> L241
        goto L239
    L220:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L226;
        Long r175 = Long.valueOf(((Number) r149).longValue());     // Catch: Throwable -> L241
        if ((r175 instanceof Integer) == true) goto L224;
        r175 = null;
    L224:
        r150 = (Integer) r175;     // Catch: Throwable -> L241
    L226:
        if ((r149 instanceof JSONObject) == false) goto L228;
    L378:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L234
        Object r176 = SDKSettingsCacheManager.a().fromJson(r149.toString(), Integer.class);     // Catch: Throwable -> L234
        if ((r176 instanceof Integer) == true) goto L232;
        r176 = null;
    L232:
        Object r177 = Result.m9449constructorimpl((Integer) r176);     // Catch: Throwable -> L234
    L236:
        r150 = r177;
        if (Result.m9455isFailureimpl(r150) == false) goto L239;
    L234:
        th = move-exception;
        Result.Companion r178 = Result.Companion;     // Catch: Throwable -> L241
        r177 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L241
        goto L236
    L228:
        if ((r149 instanceof JSONArray) == false) goto L238;
    L198:
        r172 = r149;
    L241:
        th = move-exception;
        Result.Companion r179 = Result.Companion;     // Catch: Throwable -> L347
        r151 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L347
    L347:
        th = move-exception;
        Result.Companion r180 = Result.Companion;
        r145 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r181 = Result.m9452exceptionOrNullimpl(r145);
        if (r181 == null) goto L352;
        EnsureManager.ensureNotReachHere(r181);
    L352:
        if (Result.m9455isFailureimpl(r145) == false) goto L189;
        goto L189
    }

    @HostExperimentKey(author = "zhengsai.2022", desc = "分类页筛选Tab")
    @SettingReport
    public static final int getEC_SHOP_CLASSIFY_FILTER_TAB() {
        Object r100 = 0;
        Object r101 = null;
        if (Intrinsics.areEqual("ec_shop_classify_filter_tab", "ec_shop_launch_opt_common_2") == false) goto L179;
        if (f186139b != null) goto L173;
        int r102 = n.f45241a;
        int r103 = com.bytedance.android.ec.base.settings.a.f42813a;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L163
        Object r105 = d.f42818c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L57
        if (r105 != null) goto L12;
    L54:
        Object r106 = null;
    L55:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L57
    L59:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);     // Catch: Throwable -> L163
        if (r108 == null) goto L63;
        EnsureManager.ensureNotReachHere(r108);     // Catch: Throwable -> L163
    L63:
        if (Result.m9455isFailureimpl(r107) == false) goto L66;
        r107 = null;
    L66:
        if ((r107 instanceof Integer) == true) goto L68;
        r107 = null;
    L68:
        Object r109 = (Integer) r107;     // Catch: Throwable -> L163
        if (r109 != null) goto L75;
        Object r110 = d.f42816a.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L163
        if ((r110 instanceof Integer) == true) goto L74;
        r110 = null;
    L74:
        r109 = (Integer) r110;     // Catch: Throwable -> L163
    L75:
        if (r109 != null) goto L172;
        int r111 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L163
        Object r112 = d.f42818c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L127
        if (r112 != null) goto L82;
    L124:
        Object r113 = null;
    L125:
        Object r114 = Result.m9449constructorimpl(r113);     // Catch: Throwable -> L127
    L129:
        Throwable r115 = Result.m9452exceptionOrNullimpl(r114);     // Catch: Throwable -> L154
        if (r115 == null) goto L133;
        EnsureManager.ensureNotReachHere(r115);     // Catch: Throwable -> L154
    L133:
        if (Result.m9455isFailureimpl(r114) == false) goto L136;
        r114 = null;
    L136:
        if ((r114 instanceof Integer) == true) goto L138;
        r114 = null;
    L138:
        r109 = (Integer) r114;     // Catch: Throwable -> L154
        if (r109 != null) goto L161;
        IHybridHostService r116 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L154
        if (r116 == null) goto L144;
        Object r117 = r116.getHostABValue("ec_shop_launch_opt_common_2", r100);     // Catch: Throwable -> L154
    L145:
        if (r117 != null) goto L147;
    L160:
        r109 = r100;
        goto L161
    L147:
        if ((r117 instanceof Integer) == false) goto L150;
        r101 = r117;
    L150:
        Integer r118 = (Integer) r101;     // Catch: Throwable -> L154
        if (r118 == null) goto L160;
        r109 = r118;
        goto L161
    L154:
        th = move-exception;
        Result.Companion r119 = Result.Companion;     // Catch: Throwable -> L163
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
        Throwable r120 = Result.m9452exceptionOrNullimpl(r109);     // Catch: Throwable -> L163
        if (r120 == null) goto L159;
        EnsureManager.ensureNotReachHere(r120);     // Catch: Throwable -> L163
    L159:
        if (Result.m9455isFailureimpl(r109) == false) goto L161;
    L144:
        r117 = null;
    L161:
        d.d("ec_shop_launch_opt_common_2", r109);     // Catch: Throwable -> L163
        goto L172
    L82:
        if ((r112 instanceof Integer) == true) goto L84;
        Object r121 = null;
    L85:
        r113 = (Integer) r121;     // Catch: Throwable -> L127
        if (r113 != null) goto L125;
        if ((r112 instanceof Number) == false) goto L112;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r122 = Float.valueOf(((Number) r112).floatValue());     // Catch: Throwable -> L127
        if ((r122 instanceof Integer) == true) goto L95;
        r122 = null;
    L95:
        r113 = (Integer) r122;     // Catch: Throwable -> L127
        goto L125
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r123 = Double.valueOf(((Number) r112).doubleValue());     // Catch: Throwable -> L127
        if ((r123 instanceof Integer) == true) goto L101;
        r123 = null;
    L101:
        r113 = (Integer) r123;     // Catch: Throwable -> L127
        goto L125
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L106;
        r113 = Integer.valueOf(((Number) r112).intValue());     // Catch: Throwable -> L127
        goto L125
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L112;
        Long r124 = Long.valueOf(((Number) r112).longValue());     // Catch: Throwable -> L127
        if ((r124 instanceof Integer) == true) goto L110;
        r124 = null;
    L110:
        r113 = (Integer) r124;     // Catch: Throwable -> L127
    L112:
        if ((r112 instanceof JSONObject) == false) goto L114;
    L366:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L120
        Object r125 = SDKSettingsCacheManager.a().fromJson(r112.toString(), Integer.class);     // Catch: Throwable -> L120
        if ((r125 instanceof Integer) == true) goto L118;
        r125 = null;
    L118:
        Object r126 = Result.m9449constructorimpl((Integer) r125);     // Catch: Throwable -> L120
    L122:
        r113 = r126;
        if (Result.m9455isFailureimpl(r113) == false) goto L125;
    L120:
        th = move-exception;
        Result.Companion r127 = Result.Companion;     // Catch: Throwable -> L127
        r126 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L127
        goto L122
    L114:
        if ((r112 instanceof JSONArray) == false) goto L124;
    L84:
        r121 = r112;
    L127:
        th = move-exception;
        Result.Companion r128 = Result.Companion;     // Catch: Throwable -> L154
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L154
    L172:
        f186139b = (Integer) r109;
        goto L173
    L12:
        if ((r105 instanceof Integer) == true) goto L14;
        Object r129 = null;
    L15:
        r106 = (Integer) r129;     // Catch: Throwable -> L57
        if (r106 != null) goto L55;
        if ((r105 instanceof Number) == false) goto L42;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L27;
        Float r130 = Float.valueOf(((Number) r105).floatValue());     // Catch: Throwable -> L57
        if ((r130 instanceof Integer) == true) goto L25;
        r130 = null;
    L25:
        r106 = (Integer) r130;     // Catch: Throwable -> L57
        goto L55
    L27:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L33;
        Double r131 = Double.valueOf(((Number) r105).doubleValue());     // Catch: Throwable -> L57
        if ((r131 instanceof Integer) == true) goto L31;
        r131 = null;
    L31:
        r106 = (Integer) r131;     // Catch: Throwable -> L57
        goto L55
    L33:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L36;
        r106 = Integer.valueOf(((Number) r105).intValue());     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L42;
        Long r132 = Long.valueOf(((Number) r105).longValue());     // Catch: Throwable -> L57
        if ((r132 instanceof Integer) == true) goto L40;
        r132 = null;
    L40:
        r106 = (Integer) r132;     // Catch: Throwable -> L57
    L42:
        if ((r105 instanceof JSONObject) == false) goto L44;
    L364:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L50
        Object r133 = SDKSettingsCacheManager.a().fromJson(r105.toString(), Integer.class);     // Catch: Throwable -> L50
        if ((r133 instanceof Integer) == true) goto L48;
        r133 = null;
    L48:
        Object r134 = Result.m9449constructorimpl((Integer) r133);     // Catch: Throwable -> L50
    L52:
        r106 = r134;
        if (Result.m9455isFailureimpl(r106) == false) goto L55;
    L50:
        th = move-exception;
        Result.Companion r135 = Result.Companion;     // Catch: Throwable -> L57
        r134 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L52
    L44:
        if ((r105 instanceof JSONArray) == false) goto L54;
    L14:
        r129 = r105;
    L57:
        th = move-exception;
        Result.Companion r136 = Result.Companion;     // Catch: Throwable -> L163
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
    L163:
        th = move-exception;
        Result.Companion r137 = Result.Companion;
        Object r138 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r139 = Result.m9452exceptionOrNullimpl(r138);
        if (r139 == null) goto L168;
        EnsureManager.ensureNotReachHere(r139);
    L168:
        if (Result.m9455isFailureimpl(r138) == true) goto L171;
        r100 = r138;
    L171:
        r109 = r100;
    L173:
        Object r140 = f186139b;
        if (r140 == null) goto L177;
    L354:
        f186138a.put("ec_shop_classify_filter_tab", r140);
        return ((Number) r140).intValue();
    L177:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L179:
        if (Intrinsics.areEqual("HostExperiment", "ShopSetting") == false) goto L190;
        int r141 = p.f45243a;
        Result.Companion r142 = Result.Companion;     // Catch: Throwable -> L185
        jj4.b r143 = jj4.b.f499326b;     // Catch: Throwable -> L185
        r140 = jj4.a.a("ec_shop_classify_filter_tab", Integer.class, r100, false);     // Catch: Throwable -> L185
        if (r140 != null) goto L354;
        Intrinsics.throwNpe();     // Catch: Throwable -> L185
    L185:
        th = move-exception;
        Result.Companion r144 = Result.Companion;
        Object r145 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r145) == true) goto L353;
    L189:
        r100 = r145;
    L353:
        r140 = r100;
        goto L354
    L190:
        int r146 = n.f45241a;
        int r147 = com.bytedance.android.ec.base.settings.a.f42813a;
        Result.Companion r148 = Result.Companion;     // Catch: Throwable -> L347
        Object r149 = d.f42818c.get("ec_shop_classify_filter_tab");     // Catch: Throwable -> L241
        if (r149 != null) goto L196;
    L238:
        Object r150 = null;
    L239:
        Object r151 = Result.m9449constructorimpl(r150);     // Catch: Throwable -> L241
    L243:
        Throwable r152 = Result.m9452exceptionOrNullimpl(r151);     // Catch: Throwable -> L347
        if (r152 == null) goto L247;
        EnsureManager.ensureNotReachHere(r152);     // Catch: Throwable -> L347
    L247:
        if (Result.m9455isFailureimpl(r151) == false) goto L250;
        r151 = null;
    L250:
        if ((r151 instanceof Integer) == true) goto L252;
        r151 = null;
    L252:
        r140 = (Integer) r151;     // Catch: Throwable -> L347
        if (r140 != null) goto L259;
        Object r153 = d.f42816a.get("ec_shop_classify_filter_tab");     // Catch: Throwable -> L347
        if ((r153 instanceof Integer) == true) goto L258;
        r153 = null;
    L258:
        r140 = (Integer) r153;     // Catch: Throwable -> L347
    L259:
        if (r140 != null) goto L354;
        int r154 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L347
        Object r155 = d.f42818c.get("ec_shop_classify_filter_tab");     // Catch: Throwable -> L311
        if (r155 != null) goto L266;
    L308:
        Object r156 = null;
    L309:
        Object r157 = Result.m9449constructorimpl(r156);     // Catch: Throwable -> L311
    L313:
        Throwable r158 = Result.m9452exceptionOrNullimpl(r157);     // Catch: Throwable -> L338
        if (r158 == null) goto L317;
        EnsureManager.ensureNotReachHere(r158);     // Catch: Throwable -> L338
    L317:
        if (Result.m9455isFailureimpl(r157) == false) goto L320;
        r157 = null;
    L320:
        if ((r157 instanceof Integer) == true) goto L322;
        r157 = null;
    L322:
        r140 = (Integer) r157;     // Catch: Throwable -> L338
        if (r140 != null) goto L345;
        IHybridHostService r159 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L338
        if (r159 == null) goto L328;
        Object r160 = r159.getHostABValue("ec_shop_classify_filter_tab", r100);     // Catch: Throwable -> L338
    L329:
        if (r160 != null) goto L331;
    L344:
        r140 = r100;
        goto L345
    L331:
        if ((r160 instanceof Integer) == false) goto L334;
        r101 = r160;
    L334:
        Integer r161 = (Integer) r101;     // Catch: Throwable -> L338
        if (r161 == null) goto L344;
        r140 = r161;
        goto L345
    L338:
        th = move-exception;
        Result.Companion r162 = Result.Companion;     // Catch: Throwable -> L347
        r140 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L347
        Throwable r163 = Result.m9452exceptionOrNullimpl(r140);     // Catch: Throwable -> L347
        if (r163 == null) goto L343;
        EnsureManager.ensureNotReachHere(r163);     // Catch: Throwable -> L347
    L343:
        if (Result.m9455isFailureimpl(r140) == false) goto L345;
    L328:
        r160 = null;
    L345:
        d.d("ec_shop_classify_filter_tab", r140);     // Catch: Throwable -> L347
        goto L354
    L266:
        if ((r155 instanceof Integer) == true) goto L268;
        Object r164 = null;
    L269:
        r156 = (Integer) r164;     // Catch: Throwable -> L311
        if (r156 != null) goto L309;
        if ((r155 instanceof Number) == false) goto L296;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L281;
        Float r165 = Float.valueOf(((Number) r155).floatValue());     // Catch: Throwable -> L311
        if ((r165 instanceof Integer) == true) goto L279;
        r165 = null;
    L279:
        r156 = (Integer) r165;     // Catch: Throwable -> L311
        goto L309
    L281:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L287;
        Double r166 = Double.valueOf(((Number) r155).doubleValue());     // Catch: Throwable -> L311
        if ((r166 instanceof Integer) == true) goto L285;
        r166 = null;
    L285:
        r156 = (Integer) r166;     // Catch: Throwable -> L311
        goto L309
    L287:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L290;
        r156 = Integer.valueOf(((Number) r155).intValue());     // Catch: Throwable -> L311
        goto L309
    L290:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L296;
        Long r167 = Long.valueOf(((Number) r155).longValue());     // Catch: Throwable -> L311
        if ((r167 instanceof Integer) == true) goto L294;
        r167 = null;
    L294:
        r156 = (Integer) r167;     // Catch: Throwable -> L311
    L296:
        if ((r155 instanceof JSONObject) == false) goto L298;
    L380:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L304
        Object r168 = SDKSettingsCacheManager.a().fromJson(r155.toString(), Integer.class);     // Catch: Throwable -> L304
        if ((r168 instanceof Integer) == true) goto L302;
        r168 = null;
    L302:
        Object r169 = Result.m9449constructorimpl((Integer) r168);     // Catch: Throwable -> L304
    L306:
        r156 = r169;
        if (Result.m9455isFailureimpl(r156) == false) goto L309;
    L304:
        th = move-exception;
        Result.Companion r170 = Result.Companion;     // Catch: Throwable -> L311
        r169 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L311
        goto L306
    L298:
        if ((r155 instanceof JSONArray) == false) goto L308;
    L268:
        r164 = r155;
    L311:
        th = move-exception;
        Result.Companion r171 = Result.Companion;     // Catch: Throwable -> L338
        r157 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L338
        goto L313
    L196:
        if ((r149 instanceof Integer) == true) goto L198;
        Object r172 = null;
    L199:
        r150 = (Integer) r172;     // Catch: Throwable -> L241
        if (r150 != null) goto L239;
        if ((r149 instanceof Number) == false) goto L226;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L211;
        Float r173 = Float.valueOf(((Number) r149).floatValue());     // Catch: Throwable -> L241
        if ((r173 instanceof Integer) == true) goto L209;
        r173 = null;
    L209:
        r150 = (Integer) r173;     // Catch: Throwable -> L241
        goto L239
    L211:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L217;
        Double r174 = Double.valueOf(((Number) r149).doubleValue());     // Catch: Throwable -> L241
        if ((r174 instanceof Integer) == true) goto L215;
        r174 = null;
    L215:
        r150 = (Integer) r174;     // Catch: Throwable -> L241
        goto L239
    L217:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L220;
        r150 = Integer.valueOf(((Number) r149).intValue());     // Catch: Throwable -> L241
        goto L239
    L220:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L226;
        Long r175 = Long.valueOf(((Number) r149).longValue());     // Catch: Throwable -> L241
        if ((r175 instanceof Integer) == true) goto L224;
        r175 = null;
    L224:
        r150 = (Integer) r175;     // Catch: Throwable -> L241
    L226:
        if ((r149 instanceof JSONObject) == false) goto L228;
    L378:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L234
        Object r176 = SDKSettingsCacheManager.a().fromJson(r149.toString(), Integer.class);     // Catch: Throwable -> L234
        if ((r176 instanceof Integer) == true) goto L232;
        r176 = null;
    L232:
        Object r177 = Result.m9449constructorimpl((Integer) r176);     // Catch: Throwable -> L234
    L236:
        r150 = r177;
        if (Result.m9455isFailureimpl(r150) == false) goto L239;
    L234:
        th = move-exception;
        Result.Companion r178 = Result.Companion;     // Catch: Throwable -> L241
        r177 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L241
        goto L236
    L228:
        if ((r149 instanceof JSONArray) == false) goto L238;
    L198:
        r172 = r149;
    L241:
        th = move-exception;
        Result.Companion r179 = Result.Companion;     // Catch: Throwable -> L347
        r151 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L347
    L347:
        th = move-exception;
        Result.Companion r180 = Result.Companion;
        r145 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r181 = Result.m9452exceptionOrNullimpl(r145);
        if (r181 == null) goto L352;
        EnsureManager.ensureNotReachHere(r181);
    L352:
        if (Result.m9455isFailureimpl(r145) == false) goto L189;
        goto L189
    }

    @HostExperimentKey(author = "qiuhongwei.hiro", desc = "店铺tab框架优化V2")
    @SettingReport
    public static final int getEC_SHOP_FRAMEWORK_OPT_V2() {
        Object r100 = 0;
        Object r101 = null;
        if (Intrinsics.areEqual("opt_tab_frame_v4", "ec_shop_launch_opt_common_2") == false) goto L179;
        if (f186139b != null) goto L173;
        int r102 = n.f45241a;
        int r103 = com.bytedance.android.ec.base.settings.a.f42813a;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L163
        Object r105 = d.f42818c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L57
        if (r105 != null) goto L12;
    L54:
        Object r106 = null;
    L55:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L57
    L59:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);     // Catch: Throwable -> L163
        if (r108 == null) goto L63;
        EnsureManager.ensureNotReachHere(r108);     // Catch: Throwable -> L163
    L63:
        if (Result.m9455isFailureimpl(r107) == false) goto L66;
        r107 = null;
    L66:
        if ((r107 instanceof Integer) == true) goto L68;
        r107 = null;
    L68:
        Object r109 = (Integer) r107;     // Catch: Throwable -> L163
        if (r109 != null) goto L75;
        Object r110 = d.f42816a.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L163
        if ((r110 instanceof Integer) == true) goto L74;
        r110 = null;
    L74:
        r109 = (Integer) r110;     // Catch: Throwable -> L163
    L75:
        if (r109 != null) goto L172;
        int r111 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L163
        Object r112 = d.f42818c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L127
        if (r112 != null) goto L82;
    L124:
        Object r113 = null;
    L125:
        Object r114 = Result.m9449constructorimpl(r113);     // Catch: Throwable -> L127
    L129:
        Throwable r115 = Result.m9452exceptionOrNullimpl(r114);     // Catch: Throwable -> L154
        if (r115 == null) goto L133;
        EnsureManager.ensureNotReachHere(r115);     // Catch: Throwable -> L154
    L133:
        if (Result.m9455isFailureimpl(r114) == false) goto L136;
        r114 = null;
    L136:
        if ((r114 instanceof Integer) == true) goto L138;
        r114 = null;
    L138:
        r109 = (Integer) r114;     // Catch: Throwable -> L154
        if (r109 != null) goto L161;
        IHybridHostService r116 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L154
        if (r116 == null) goto L144;
        Object r117 = r116.getHostABValue("ec_shop_launch_opt_common_2", r100);     // Catch: Throwable -> L154
    L145:
        if (r117 != null) goto L147;
    L160:
        r109 = r100;
        goto L161
    L147:
        if ((r117 instanceof Integer) == false) goto L150;
        r101 = r117;
    L150:
        Integer r118 = (Integer) r101;     // Catch: Throwable -> L154
        if (r118 == null) goto L160;
        r109 = r118;
        goto L161
    L154:
        th = move-exception;
        Result.Companion r119 = Result.Companion;     // Catch: Throwable -> L163
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
        Throwable r120 = Result.m9452exceptionOrNullimpl(r109);     // Catch: Throwable -> L163
        if (r120 == null) goto L159;
        EnsureManager.ensureNotReachHere(r120);     // Catch: Throwable -> L163
    L159:
        if (Result.m9455isFailureimpl(r109) == false) goto L161;
    L144:
        r117 = null;
    L161:
        d.d("ec_shop_launch_opt_common_2", r109);     // Catch: Throwable -> L163
        goto L172
    L82:
        if ((r112 instanceof Integer) == true) goto L84;
        Object r121 = null;
    L85:
        r113 = (Integer) r121;     // Catch: Throwable -> L127
        if (r113 != null) goto L125;
        if ((r112 instanceof Number) == false) goto L112;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r122 = Float.valueOf(((Number) r112).floatValue());     // Catch: Throwable -> L127
        if ((r122 instanceof Integer) == true) goto L95;
        r122 = null;
    L95:
        r113 = (Integer) r122;     // Catch: Throwable -> L127
        goto L125
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r123 = Double.valueOf(((Number) r112).doubleValue());     // Catch: Throwable -> L127
        if ((r123 instanceof Integer) == true) goto L101;
        r123 = null;
    L101:
        r113 = (Integer) r123;     // Catch: Throwable -> L127
        goto L125
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L106;
        r113 = Integer.valueOf(((Number) r112).intValue());     // Catch: Throwable -> L127
        goto L125
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L112;
        Long r124 = Long.valueOf(((Number) r112).longValue());     // Catch: Throwable -> L127
        if ((r124 instanceof Integer) == true) goto L110;
        r124 = null;
    L110:
        r113 = (Integer) r124;     // Catch: Throwable -> L127
    L112:
        if ((r112 instanceof JSONObject) == false) goto L114;
    L366:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L120
        Object r125 = SDKSettingsCacheManager.a().fromJson(r112.toString(), Integer.class);     // Catch: Throwable -> L120
        if ((r125 instanceof Integer) == true) goto L118;
        r125 = null;
    L118:
        Object r126 = Result.m9449constructorimpl((Integer) r125);     // Catch: Throwable -> L120
    L122:
        r113 = r126;
        if (Result.m9455isFailureimpl(r113) == false) goto L125;
    L120:
        th = move-exception;
        Result.Companion r127 = Result.Companion;     // Catch: Throwable -> L127
        r126 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L127
        goto L122
    L114:
        if ((r112 instanceof JSONArray) == false) goto L124;
    L84:
        r121 = r112;
    L127:
        th = move-exception;
        Result.Companion r128 = Result.Companion;     // Catch: Throwable -> L154
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L154
    L172:
        f186139b = (Integer) r109;
        goto L173
    L12:
        if ((r105 instanceof Integer) == true) goto L14;
        Object r129 = null;
    L15:
        r106 = (Integer) r129;     // Catch: Throwable -> L57
        if (r106 != null) goto L55;
        if ((r105 instanceof Number) == false) goto L42;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L27;
        Float r130 = Float.valueOf(((Number) r105).floatValue());     // Catch: Throwable -> L57
        if ((r130 instanceof Integer) == true) goto L25;
        r130 = null;
    L25:
        r106 = (Integer) r130;     // Catch: Throwable -> L57
        goto L55
    L27:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L33;
        Double r131 = Double.valueOf(((Number) r105).doubleValue());     // Catch: Throwable -> L57
        if ((r131 instanceof Integer) == true) goto L31;
        r131 = null;
    L31:
        r106 = (Integer) r131;     // Catch: Throwable -> L57
        goto L55
    L33:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L36;
        r106 = Integer.valueOf(((Number) r105).intValue());     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L42;
        Long r132 = Long.valueOf(((Number) r105).longValue());     // Catch: Throwable -> L57
        if ((r132 instanceof Integer) == true) goto L40;
        r132 = null;
    L40:
        r106 = (Integer) r132;     // Catch: Throwable -> L57
    L42:
        if ((r105 instanceof JSONObject) == false) goto L44;
    L364:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L50
        Object r133 = SDKSettingsCacheManager.a().fromJson(r105.toString(), Integer.class);     // Catch: Throwable -> L50
        if ((r133 instanceof Integer) == true) goto L48;
        r133 = null;
    L48:
        Object r134 = Result.m9449constructorimpl((Integer) r133);     // Catch: Throwable -> L50
    L52:
        r106 = r134;
        if (Result.m9455isFailureimpl(r106) == false) goto L55;
    L50:
        th = move-exception;
        Result.Companion r135 = Result.Companion;     // Catch: Throwable -> L57
        r134 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L52
    L44:
        if ((r105 instanceof JSONArray) == false) goto L54;
    L14:
        r129 = r105;
    L57:
        th = move-exception;
        Result.Companion r136 = Result.Companion;     // Catch: Throwable -> L163
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
    L163:
        th = move-exception;
        Result.Companion r137 = Result.Companion;
        Object r138 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r139 = Result.m9452exceptionOrNullimpl(r138);
        if (r139 == null) goto L168;
        EnsureManager.ensureNotReachHere(r139);
    L168:
        if (Result.m9455isFailureimpl(r138) == true) goto L171;
        r100 = r138;
    L171:
        r109 = r100;
    L173:
        Object r140 = f186139b;
        if (r140 == null) goto L177;
    L354:
        f186138a.put("opt_tab_frame_v4", r140);
        return ((Number) r140).intValue();
    L177:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L179:
        if (Intrinsics.areEqual("HostExperiment", "ShopSetting") == false) goto L190;
        int r141 = p.f45243a;
        Result.Companion r142 = Result.Companion;     // Catch: Throwable -> L185
        jj4.b r143 = jj4.b.f499326b;     // Catch: Throwable -> L185
        r140 = jj4.a.a("opt_tab_frame_v4", Integer.class, r100, false);     // Catch: Throwable -> L185
        if (r140 != null) goto L354;
        Intrinsics.throwNpe();     // Catch: Throwable -> L185
    L185:
        th = move-exception;
        Result.Companion r144 = Result.Companion;
        Object r145 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r145) == true) goto L353;
    L189:
        r100 = r145;
    L353:
        r140 = r100;
        goto L354
    L190:
        int r146 = n.f45241a;
        int r147 = com.bytedance.android.ec.base.settings.a.f42813a;
        Result.Companion r148 = Result.Companion;     // Catch: Throwable -> L347
        Object r149 = d.f42818c.get("opt_tab_frame_v4");     // Catch: Throwable -> L241
        if (r149 != null) goto L196;
    L238:
        Object r150 = null;
    L239:
        Object r151 = Result.m9449constructorimpl(r150);     // Catch: Throwable -> L241
    L243:
        Throwable r152 = Result.m9452exceptionOrNullimpl(r151);     // Catch: Throwable -> L347
        if (r152 == null) goto L247;
        EnsureManager.ensureNotReachHere(r152);     // Catch: Throwable -> L347
    L247:
        if (Result.m9455isFailureimpl(r151) == false) goto L250;
        r151 = null;
    L250:
        if ((r151 instanceof Integer) == true) goto L252;
        r151 = null;
    L252:
        r140 = (Integer) r151;     // Catch: Throwable -> L347
        if (r140 != null) goto L259;
        Object r153 = d.f42816a.get("opt_tab_frame_v4");     // Catch: Throwable -> L347
        if ((r153 instanceof Integer) == true) goto L258;
        r153 = null;
    L258:
        r140 = (Integer) r153;     // Catch: Throwable -> L347
    L259:
        if (r140 != null) goto L354;
        int r154 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L347
        Object r155 = d.f42818c.get("opt_tab_frame_v4");     // Catch: Throwable -> L311
        if (r155 != null) goto L266;
    L308:
        Object r156 = null;
    L309:
        Object r157 = Result.m9449constructorimpl(r156);     // Catch: Throwable -> L311
    L313:
        Throwable r158 = Result.m9452exceptionOrNullimpl(r157);     // Catch: Throwable -> L338
        if (r158 == null) goto L317;
        EnsureManager.ensureNotReachHere(r158);     // Catch: Throwable -> L338
    L317:
        if (Result.m9455isFailureimpl(r157) == false) goto L320;
        r157 = null;
    L320:
        if ((r157 instanceof Integer) == true) goto L322;
        r157 = null;
    L322:
        r140 = (Integer) r157;     // Catch: Throwable -> L338
        if (r140 != null) goto L345;
        IHybridHostService r159 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L338
        if (r159 == null) goto L328;
        Object r160 = r159.getHostABValue("opt_tab_frame_v4", r100);     // Catch: Throwable -> L338
    L329:
        if (r160 != null) goto L331;
    L344:
        r140 = r100;
        goto L345
    L331:
        if ((r160 instanceof Integer) == false) goto L334;
        r101 = r160;
    L334:
        Integer r161 = (Integer) r101;     // Catch: Throwable -> L338
        if (r161 == null) goto L344;
        r140 = r161;
        goto L345
    L338:
        th = move-exception;
        Result.Companion r162 = Result.Companion;     // Catch: Throwable -> L347
        r140 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L347
        Throwable r163 = Result.m9452exceptionOrNullimpl(r140);     // Catch: Throwable -> L347
        if (r163 == null) goto L343;
        EnsureManager.ensureNotReachHere(r163);     // Catch: Throwable -> L347
    L343:
        if (Result.m9455isFailureimpl(r140) == false) goto L345;
    L328:
        r160 = null;
    L345:
        d.d("opt_tab_frame_v4", r140);     // Catch: Throwable -> L347
        goto L354
    L266:
        if ((r155 instanceof Integer) == true) goto L268;
        Object r164 = null;
    L269:
        r156 = (Integer) r164;     // Catch: Throwable -> L311
        if (r156 != null) goto L309;
        if ((r155 instanceof Number) == false) goto L296;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L281;
        Float r165 = Float.valueOf(((Number) r155).floatValue());     // Catch: Throwable -> L311
        if ((r165 instanceof Integer) == true) goto L279;
        r165 = null;
    L279:
        r156 = (Integer) r165;     // Catch: Throwable -> L311
        goto L309
    L281:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L287;
        Double r166 = Double.valueOf(((Number) r155).doubleValue());     // Catch: Throwable -> L311
        if ((r166 instanceof Integer) == true) goto L285;
        r166 = null;
    L285:
        r156 = (Integer) r166;     // Catch: Throwable -> L311
        goto L309
    L287:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L290;
        r156 = Integer.valueOf(((Number) r155).intValue());     // Catch: Throwable -> L311
        goto L309
    L290:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L296;
        Long r167 = Long.valueOf(((Number) r155).longValue());     // Catch: Throwable -> L311
        if ((r167 instanceof Integer) == true) goto L294;
        r167 = null;
    L294:
        r156 = (Integer) r167;     // Catch: Throwable -> L311
    L296:
        if ((r155 instanceof JSONObject) == false) goto L298;
    L380:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L304
        Object r168 = SDKSettingsCacheManager.a().fromJson(r155.toString(), Integer.class);     // Catch: Throwable -> L304
        if ((r168 instanceof Integer) == true) goto L302;
        r168 = null;
    L302:
        Object r169 = Result.m9449constructorimpl((Integer) r168);     // Catch: Throwable -> L304
    L306:
        r156 = r169;
        if (Result.m9455isFailureimpl(r156) == false) goto L309;
    L304:
        th = move-exception;
        Result.Companion r170 = Result.Companion;     // Catch: Throwable -> L311
        r169 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L311
        goto L306
    L298:
        if ((r155 instanceof JSONArray) == false) goto L308;
    L268:
        r164 = r155;
    L311:
        th = move-exception;
        Result.Companion r171 = Result.Companion;     // Catch: Throwable -> L338
        r157 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L338
        goto L313
    L196:
        if ((r149 instanceof Integer) == true) goto L198;
        Object r172 = null;
    L199:
        r150 = (Integer) r172;     // Catch: Throwable -> L241
        if (r150 != null) goto L239;
        if ((r149 instanceof Number) == false) goto L226;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L211;
        Float r173 = Float.valueOf(((Number) r149).floatValue());     // Catch: Throwable -> L241
        if ((r173 instanceof Integer) == true) goto L209;
        r173 = null;
    L209:
        r150 = (Integer) r173;     // Catch: Throwable -> L241
        goto L239
    L211:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L217;
        Double r174 = Double.valueOf(((Number) r149).doubleValue());     // Catch: Throwable -> L241
        if ((r174 instanceof Integer) == true) goto L215;
        r174 = null;
    L215:
        r150 = (Integer) r174;     // Catch: Throwable -> L241
        goto L239
    L217:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L220;
        r150 = Integer.valueOf(((Number) r149).intValue());     // Catch: Throwable -> L241
        goto L239
    L220:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L226;
        Long r175 = Long.valueOf(((Number) r149).longValue());     // Catch: Throwable -> L241
        if ((r175 instanceof Integer) == true) goto L224;
        r175 = null;
    L224:
        r150 = (Integer) r175;     // Catch: Throwable -> L241
    L226:
        if ((r149 instanceof JSONObject) == false) goto L228;
    L378:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L234
        Object r176 = SDKSettingsCacheManager.a().fromJson(r149.toString(), Integer.class);     // Catch: Throwable -> L234
        if ((r176 instanceof Integer) == true) goto L232;
        r176 = null;
    L232:
        Object r177 = Result.m9449constructorimpl((Integer) r176);     // Catch: Throwable -> L234
    L236:
        r150 = r177;
        if (Result.m9455isFailureimpl(r150) == false) goto L239;
    L234:
        th = move-exception;
        Result.Companion r178 = Result.Companion;     // Catch: Throwable -> L241
        r177 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L241
        goto L236
    L228:
        if ((r149 instanceof JSONArray) == false) goto L238;
    L198:
        r172 = r149;
    L241:
        th = move-exception;
        Result.Companion r179 = Result.Companion;     // Catch: Throwable -> L347
        r151 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L347
    L347:
        th = move-exception;
        Result.Companion r180 = Result.Companion;
        r145 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r181 = Result.m9452exceptionOrNullimpl(r145);
        if (r181 == null) goto L352;
        EnsureManager.ensureNotReachHere(r181);
    L352:
        if (Result.m9455isFailureimpl(r145) == false) goto L189;
        goto L189
    }

    @HostExperimentKey(author = "qiuhongwei.hiro", desc = "店铺tab框架优化")
    @SettingReport
    public static final int getEC_SHOP_MIDDLE_TAB_FRAMEWORK_OPT() {
        Object r100 = 0;
        Object r101 = null;
        if (Intrinsics.areEqual("opt_tab_frame_v3", "ec_shop_launch_opt_common_2") == false) goto L179;
        if (f186139b != null) goto L173;
        int r102 = n.f45241a;
        int r103 = com.bytedance.android.ec.base.settings.a.f42813a;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L163
        Object r105 = d.f42818c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L57
        if (r105 != null) goto L12;
    L54:
        Object r106 = null;
    L55:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L57
    L59:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);     // Catch: Throwable -> L163
        if (r108 == null) goto L63;
        EnsureManager.ensureNotReachHere(r108);     // Catch: Throwable -> L163
    L63:
        if (Result.m9455isFailureimpl(r107) == false) goto L66;
        r107 = null;
    L66:
        if ((r107 instanceof Integer) == true) goto L68;
        r107 = null;
    L68:
        Object r109 = (Integer) r107;     // Catch: Throwable -> L163
        if (r109 != null) goto L75;
        Object r110 = d.f42816a.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L163
        if ((r110 instanceof Integer) == true) goto L74;
        r110 = null;
    L74:
        r109 = (Integer) r110;     // Catch: Throwable -> L163
    L75:
        if (r109 != null) goto L172;
        int r111 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L163
        Object r112 = d.f42818c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L127
        if (r112 != null) goto L82;
    L124:
        Object r113 = null;
    L125:
        Object r114 = Result.m9449constructorimpl(r113);     // Catch: Throwable -> L127
    L129:
        Throwable r115 = Result.m9452exceptionOrNullimpl(r114);     // Catch: Throwable -> L154
        if (r115 == null) goto L133;
        EnsureManager.ensureNotReachHere(r115);     // Catch: Throwable -> L154
    L133:
        if (Result.m9455isFailureimpl(r114) == false) goto L136;
        r114 = null;
    L136:
        if ((r114 instanceof Integer) == true) goto L138;
        r114 = null;
    L138:
        r109 = (Integer) r114;     // Catch: Throwable -> L154
        if (r109 != null) goto L161;
        IHybridHostService r116 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L154
        if (r116 == null) goto L144;
        Object r117 = r116.getHostABValue("ec_shop_launch_opt_common_2", r100);     // Catch: Throwable -> L154
    L145:
        if (r117 != null) goto L147;
    L160:
        r109 = r100;
        goto L161
    L147:
        if ((r117 instanceof Integer) == false) goto L150;
        r101 = r117;
    L150:
        Integer r118 = (Integer) r101;     // Catch: Throwable -> L154
        if (r118 == null) goto L160;
        r109 = r118;
        goto L161
    L154:
        th = move-exception;
        Result.Companion r119 = Result.Companion;     // Catch: Throwable -> L163
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
        Throwable r120 = Result.m9452exceptionOrNullimpl(r109);     // Catch: Throwable -> L163
        if (r120 == null) goto L159;
        EnsureManager.ensureNotReachHere(r120);     // Catch: Throwable -> L163
    L159:
        if (Result.m9455isFailureimpl(r109) == false) goto L161;
    L144:
        r117 = null;
    L161:
        d.d("ec_shop_launch_opt_common_2", r109);     // Catch: Throwable -> L163
        goto L172
    L82:
        if ((r112 instanceof Integer) == true) goto L84;
        Object r121 = null;
    L85:
        r113 = (Integer) r121;     // Catch: Throwable -> L127
        if (r113 != null) goto L125;
        if ((r112 instanceof Number) == false) goto L112;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r122 = Float.valueOf(((Number) r112).floatValue());     // Catch: Throwable -> L127
        if ((r122 instanceof Integer) == true) goto L95;
        r122 = null;
    L95:
        r113 = (Integer) r122;     // Catch: Throwable -> L127
        goto L125
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r123 = Double.valueOf(((Number) r112).doubleValue());     // Catch: Throwable -> L127
        if ((r123 instanceof Integer) == true) goto L101;
        r123 = null;
    L101:
        r113 = (Integer) r123;     // Catch: Throwable -> L127
        goto L125
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L106;
        r113 = Integer.valueOf(((Number) r112).intValue());     // Catch: Throwable -> L127
        goto L125
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L112;
        Long r124 = Long.valueOf(((Number) r112).longValue());     // Catch: Throwable -> L127
        if ((r124 instanceof Integer) == true) goto L110;
        r124 = null;
    L110:
        r113 = (Integer) r124;     // Catch: Throwable -> L127
    L112:
        if ((r112 instanceof JSONObject) == false) goto L114;
    L366:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L120
        Object r125 = SDKSettingsCacheManager.a().fromJson(r112.toString(), Integer.class);     // Catch: Throwable -> L120
        if ((r125 instanceof Integer) == true) goto L118;
        r125 = null;
    L118:
        Object r126 = Result.m9449constructorimpl((Integer) r125);     // Catch: Throwable -> L120
    L122:
        r113 = r126;
        if (Result.m9455isFailureimpl(r113) == false) goto L125;
    L120:
        th = move-exception;
        Result.Companion r127 = Result.Companion;     // Catch: Throwable -> L127
        r126 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L127
        goto L122
    L114:
        if ((r112 instanceof JSONArray) == false) goto L124;
    L84:
        r121 = r112;
    L127:
        th = move-exception;
        Result.Companion r128 = Result.Companion;     // Catch: Throwable -> L154
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L154
    L172:
        f186139b = (Integer) r109;
        goto L173
    L12:
        if ((r105 instanceof Integer) == true) goto L14;
        Object r129 = null;
    L15:
        r106 = (Integer) r129;     // Catch: Throwable -> L57
        if (r106 != null) goto L55;
        if ((r105 instanceof Number) == false) goto L42;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L27;
        Float r130 = Float.valueOf(((Number) r105).floatValue());     // Catch: Throwable -> L57
        if ((r130 instanceof Integer) == true) goto L25;
        r130 = null;
    L25:
        r106 = (Integer) r130;     // Catch: Throwable -> L57
        goto L55
    L27:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L33;
        Double r131 = Double.valueOf(((Number) r105).doubleValue());     // Catch: Throwable -> L57
        if ((r131 instanceof Integer) == true) goto L31;
        r131 = null;
    L31:
        r106 = (Integer) r131;     // Catch: Throwable -> L57
        goto L55
    L33:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L36;
        r106 = Integer.valueOf(((Number) r105).intValue());     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L42;
        Long r132 = Long.valueOf(((Number) r105).longValue());     // Catch: Throwable -> L57
        if ((r132 instanceof Integer) == true) goto L40;
        r132 = null;
    L40:
        r106 = (Integer) r132;     // Catch: Throwable -> L57
    L42:
        if ((r105 instanceof JSONObject) == false) goto L44;
    L364:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L50
        Object r133 = SDKSettingsCacheManager.a().fromJson(r105.toString(), Integer.class);     // Catch: Throwable -> L50
        if ((r133 instanceof Integer) == true) goto L48;
        r133 = null;
    L48:
        Object r134 = Result.m9449constructorimpl((Integer) r133);     // Catch: Throwable -> L50
    L52:
        r106 = r134;
        if (Result.m9455isFailureimpl(r106) == false) goto L55;
    L50:
        th = move-exception;
        Result.Companion r135 = Result.Companion;     // Catch: Throwable -> L57
        r134 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L52
    L44:
        if ((r105 instanceof JSONArray) == false) goto L54;
    L14:
        r129 = r105;
    L57:
        th = move-exception;
        Result.Companion r136 = Result.Companion;     // Catch: Throwable -> L163
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
    L163:
        th = move-exception;
        Result.Companion r137 = Result.Companion;
        Object r138 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r139 = Result.m9452exceptionOrNullimpl(r138);
        if (r139 == null) goto L168;
        EnsureManager.ensureNotReachHere(r139);
    L168:
        if (Result.m9455isFailureimpl(r138) == true) goto L171;
        r100 = r138;
    L171:
        r109 = r100;
    L173:
        Object r140 = f186139b;
        if (r140 == null) goto L177;
    L354:
        f186138a.put("opt_tab_frame_v3", r140);
        return ((Number) r140).intValue();
    L177:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L179:
        if (Intrinsics.areEqual("HostExperiment", "ShopSetting") == false) goto L190;
        int r141 = p.f45243a;
        Result.Companion r142 = Result.Companion;     // Catch: Throwable -> L185
        jj4.b r143 = jj4.b.f499326b;     // Catch: Throwable -> L185
        r140 = jj4.a.a("opt_tab_frame_v3", Integer.class, r100, false);     // Catch: Throwable -> L185
        if (r140 != null) goto L354;
        Intrinsics.throwNpe();     // Catch: Throwable -> L185
    L185:
        th = move-exception;
        Result.Companion r144 = Result.Companion;
        Object r145 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r145) == true) goto L353;
    L189:
        r100 = r145;
    L353:
        r140 = r100;
        goto L354
    L190:
        int r146 = n.f45241a;
        int r147 = com.bytedance.android.ec.base.settings.a.f42813a;
        Result.Companion r148 = Result.Companion;     // Catch: Throwable -> L347
        Object r149 = d.f42818c.get("opt_tab_frame_v3");     // Catch: Throwable -> L241
        if (r149 != null) goto L196;
    L238:
        Object r150 = null;
    L239:
        Object r151 = Result.m9449constructorimpl(r150);     // Catch: Throwable -> L241
    L243:
        Throwable r152 = Result.m9452exceptionOrNullimpl(r151);     // Catch: Throwable -> L347
        if (r152 == null) goto L247;
        EnsureManager.ensureNotReachHere(r152);     // Catch: Throwable -> L347
    L247:
        if (Result.m9455isFailureimpl(r151) == false) goto L250;
        r151 = null;
    L250:
        if ((r151 instanceof Integer) == true) goto L252;
        r151 = null;
    L252:
        r140 = (Integer) r151;     // Catch: Throwable -> L347
        if (r140 != null) goto L259;
        Object r153 = d.f42816a.get("opt_tab_frame_v3");     // Catch: Throwable -> L347
        if ((r153 instanceof Integer) == true) goto L258;
        r153 = null;
    L258:
        r140 = (Integer) r153;     // Catch: Throwable -> L347
    L259:
        if (r140 != null) goto L354;
        int r154 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L347
        Object r155 = d.f42818c.get("opt_tab_frame_v3");     // Catch: Throwable -> L311
        if (r155 != null) goto L266;
    L308:
        Object r156 = null;
    L309:
        Object r157 = Result.m9449constructorimpl(r156);     // Catch: Throwable -> L311
    L313:
        Throwable r158 = Result.m9452exceptionOrNullimpl(r157);     // Catch: Throwable -> L338
        if (r158 == null) goto L317;
        EnsureManager.ensureNotReachHere(r158);     // Catch: Throwable -> L338
    L317:
        if (Result.m9455isFailureimpl(r157) == false) goto L320;
        r157 = null;
    L320:
        if ((r157 instanceof Integer) == true) goto L322;
        r157 = null;
    L322:
        r140 = (Integer) r157;     // Catch: Throwable -> L338
        if (r140 != null) goto L345;
        IHybridHostService r159 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L338
        if (r159 == null) goto L328;
        Object r160 = r159.getHostABValue("opt_tab_frame_v3", r100);     // Catch: Throwable -> L338
    L329:
        if (r160 != null) goto L331;
    L344:
        r140 = r100;
        goto L345
    L331:
        if ((r160 instanceof Integer) == false) goto L334;
        r101 = r160;
    L334:
        Integer r161 = (Integer) r101;     // Catch: Throwable -> L338
        if (r161 == null) goto L344;
        r140 = r161;
        goto L345
    L338:
        th = move-exception;
        Result.Companion r162 = Result.Companion;     // Catch: Throwable -> L347
        r140 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L347
        Throwable r163 = Result.m9452exceptionOrNullimpl(r140);     // Catch: Throwable -> L347
        if (r163 == null) goto L343;
        EnsureManager.ensureNotReachHere(r163);     // Catch: Throwable -> L347
    L343:
        if (Result.m9455isFailureimpl(r140) == false) goto L345;
    L328:
        r160 = null;
    L345:
        d.d("opt_tab_frame_v3", r140);     // Catch: Throwable -> L347
        goto L354
    L266:
        if ((r155 instanceof Integer) == true) goto L268;
        Object r164 = null;
    L269:
        r156 = (Integer) r164;     // Catch: Throwable -> L311
        if (r156 != null) goto L309;
        if ((r155 instanceof Number) == false) goto L296;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L281;
        Float r165 = Float.valueOf(((Number) r155).floatValue());     // Catch: Throwable -> L311
        if ((r165 instanceof Integer) == true) goto L279;
        r165 = null;
    L279:
        r156 = (Integer) r165;     // Catch: Throwable -> L311
        goto L309
    L281:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L287;
        Double r166 = Double.valueOf(((Number) r155).doubleValue());     // Catch: Throwable -> L311
        if ((r166 instanceof Integer) == true) goto L285;
        r166 = null;
    L285:
        r156 = (Integer) r166;     // Catch: Throwable -> L311
        goto L309
    L287:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L290;
        r156 = Integer.valueOf(((Number) r155).intValue());     // Catch: Throwable -> L311
        goto L309
    L290:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L296;
        Long r167 = Long.valueOf(((Number) r155).longValue());     // Catch: Throwable -> L311
        if ((r167 instanceof Integer) == true) goto L294;
        r167 = null;
    L294:
        r156 = (Integer) r167;     // Catch: Throwable -> L311
    L296:
        if ((r155 instanceof JSONObject) == false) goto L298;
    L380:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L304
        Object r168 = SDKSettingsCacheManager.a().fromJson(r155.toString(), Integer.class);     // Catch: Throwable -> L304
        if ((r168 instanceof Integer) == true) goto L302;
        r168 = null;
    L302:
        Object r169 = Result.m9449constructorimpl((Integer) r168);     // Catch: Throwable -> L304
    L306:
        r156 = r169;
        if (Result.m9455isFailureimpl(r156) == false) goto L309;
    L304:
        th = move-exception;
        Result.Companion r170 = Result.Companion;     // Catch: Throwable -> L311
        r169 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L311
        goto L306
    L298:
        if ((r155 instanceof JSONArray) == false) goto L308;
    L268:
        r164 = r155;
    L311:
        th = move-exception;
        Result.Companion r171 = Result.Companion;     // Catch: Throwable -> L338
        r157 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L338
        goto L313
    L196:
        if ((r149 instanceof Integer) == true) goto L198;
        Object r172 = null;
    L199:
        r150 = (Integer) r172;     // Catch: Throwable -> L241
        if (r150 != null) goto L239;
        if ((r149 instanceof Number) == false) goto L226;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L211;
        Float r173 = Float.valueOf(((Number) r149).floatValue());     // Catch: Throwable -> L241
        if ((r173 instanceof Integer) == true) goto L209;
        r173 = null;
    L209:
        r150 = (Integer) r173;     // Catch: Throwable -> L241
        goto L239
    L211:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L217;
        Double r174 = Double.valueOf(((Number) r149).doubleValue());     // Catch: Throwable -> L241
        if ((r174 instanceof Integer) == true) goto L215;
        r174 = null;
    L215:
        r150 = (Integer) r174;     // Catch: Throwable -> L241
        goto L239
    L217:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L220;
        r150 = Integer.valueOf(((Number) r149).intValue());     // Catch: Throwable -> L241
        goto L239
    L220:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L226;
        Long r175 = Long.valueOf(((Number) r149).longValue());     // Catch: Throwable -> L241
        if ((r175 instanceof Integer) == true) goto L224;
        r175 = null;
    L224:
        r150 = (Integer) r175;     // Catch: Throwable -> L241
    L226:
        if ((r149 instanceof JSONObject) == false) goto L228;
    L378:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L234
        Object r176 = SDKSettingsCacheManager.a().fromJson(r149.toString(), Integer.class);     // Catch: Throwable -> L234
        if ((r176 instanceof Integer) == true) goto L232;
        r176 = null;
    L232:
        Object r177 = Result.m9449constructorimpl((Integer) r176);     // Catch: Throwable -> L234
    L236:
        r150 = r177;
        if (Result.m9455isFailureimpl(r150) == false) goto L239;
    L234:
        th = move-exception;
        Result.Companion r178 = Result.Companion;     // Catch: Throwable -> L241
        r177 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L241
        goto L236
    L228:
        if ((r149 instanceof JSONArray) == false) goto L238;
    L198:
        r172 = r149;
    L241:
        th = move-exception;
        Result.Companion r179 = Result.Companion;     // Catch: Throwable -> L347
        r151 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L347
    L347:
        th = move-exception;
        Result.Companion r180 = Result.Companion;
        r145 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r181 = Result.m9452exceptionOrNullimpl(r145);
        if (r181 == null) goto L352;
        EnsureManager.ensureNotReachHere(r181);
    L352:
        if (Result.m9455isFailureimpl(r145) == false) goto L189;
        goto L189
    }

    @HostExperimentKey(author = "zhengsai.2022", desc = "店铺直播小窗下滑变icon")
    @SettingReport
    public static final int getEC_SHOP_MINI_WINDOW_ANIM_OPT() {
        Object r100 = 0;
        Object r101 = null;
        if (Intrinsics.areEqual("ec_shop_mini_window_anim_opt", "ec_shop_launch_opt_common_2") == false) goto L179;
        if (f186139b != null) goto L173;
        int r102 = n.f45241a;
        int r103 = com.bytedance.android.ec.base.settings.a.f42813a;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L163
        Object r105 = d.f42818c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L57
        if (r105 != null) goto L12;
    L54:
        Object r106 = null;
    L55:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L57
    L59:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);     // Catch: Throwable -> L163
        if (r108 == null) goto L63;
        EnsureManager.ensureNotReachHere(r108);     // Catch: Throwable -> L163
    L63:
        if (Result.m9455isFailureimpl(r107) == false) goto L66;
        r107 = null;
    L66:
        if ((r107 instanceof Integer) == true) goto L68;
        r107 = null;
    L68:
        Object r109 = (Integer) r107;     // Catch: Throwable -> L163
        if (r109 != null) goto L75;
        Object r110 = d.f42816a.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L163
        if ((r110 instanceof Integer) == true) goto L74;
        r110 = null;
    L74:
        r109 = (Integer) r110;     // Catch: Throwable -> L163
    L75:
        if (r109 != null) goto L172;
        int r111 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L163
        Object r112 = d.f42818c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L127
        if (r112 != null) goto L82;
    L124:
        Object r113 = null;
    L125:
        Object r114 = Result.m9449constructorimpl(r113);     // Catch: Throwable -> L127
    L129:
        Throwable r115 = Result.m9452exceptionOrNullimpl(r114);     // Catch: Throwable -> L154
        if (r115 == null) goto L133;
        EnsureManager.ensureNotReachHere(r115);     // Catch: Throwable -> L154
    L133:
        if (Result.m9455isFailureimpl(r114) == false) goto L136;
        r114 = null;
    L136:
        if ((r114 instanceof Integer) == true) goto L138;
        r114 = null;
    L138:
        r109 = (Integer) r114;     // Catch: Throwable -> L154
        if (r109 != null) goto L161;
        IHybridHostService r116 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L154
        if (r116 == null) goto L144;
        Object r117 = r116.getHostABValue("ec_shop_launch_opt_common_2", r100);     // Catch: Throwable -> L154
    L145:
        if (r117 != null) goto L147;
    L160:
        r109 = r100;
        goto L161
    L147:
        if ((r117 instanceof Integer) == false) goto L150;
        r101 = r117;
    L150:
        Integer r118 = (Integer) r101;     // Catch: Throwable -> L154
        if (r118 == null) goto L160;
        r109 = r118;
        goto L161
    L154:
        th = move-exception;
        Result.Companion r119 = Result.Companion;     // Catch: Throwable -> L163
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
        Throwable r120 = Result.m9452exceptionOrNullimpl(r109);     // Catch: Throwable -> L163
        if (r120 == null) goto L159;
        EnsureManager.ensureNotReachHere(r120);     // Catch: Throwable -> L163
    L159:
        if (Result.m9455isFailureimpl(r109) == false) goto L161;
    L144:
        r117 = null;
    L161:
        d.d("ec_shop_launch_opt_common_2", r109);     // Catch: Throwable -> L163
        goto L172
    L82:
        if ((r112 instanceof Integer) == true) goto L84;
        Object r121 = null;
    L85:
        r113 = (Integer) r121;     // Catch: Throwable -> L127
        if (r113 != null) goto L125;
        if ((r112 instanceof Number) == false) goto L112;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r122 = Float.valueOf(((Number) r112).floatValue());     // Catch: Throwable -> L127
        if ((r122 instanceof Integer) == true) goto L95;
        r122 = null;
    L95:
        r113 = (Integer) r122;     // Catch: Throwable -> L127
        goto L125
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r123 = Double.valueOf(((Number) r112).doubleValue());     // Catch: Throwable -> L127
        if ((r123 instanceof Integer) == true) goto L101;
        r123 = null;
    L101:
        r113 = (Integer) r123;     // Catch: Throwable -> L127
        goto L125
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L106;
        r113 = Integer.valueOf(((Number) r112).intValue());     // Catch: Throwable -> L127
        goto L125
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L112;
        Long r124 = Long.valueOf(((Number) r112).longValue());     // Catch: Throwable -> L127
        if ((r124 instanceof Integer) == true) goto L110;
        r124 = null;
    L110:
        r113 = (Integer) r124;     // Catch: Throwable -> L127
    L112:
        if ((r112 instanceof JSONObject) == false) goto L114;
    L366:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L120
        Object r125 = SDKSettingsCacheManager.a().fromJson(r112.toString(), Integer.class);     // Catch: Throwable -> L120
        if ((r125 instanceof Integer) == true) goto L118;
        r125 = null;
    L118:
        Object r126 = Result.m9449constructorimpl((Integer) r125);     // Catch: Throwable -> L120
    L122:
        r113 = r126;
        if (Result.m9455isFailureimpl(r113) == false) goto L125;
    L120:
        th = move-exception;
        Result.Companion r127 = Result.Companion;     // Catch: Throwable -> L127
        r126 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L127
        goto L122
    L114:
        if ((r112 instanceof JSONArray) == false) goto L124;
    L84:
        r121 = r112;
    L127:
        th = move-exception;
        Result.Companion r128 = Result.Companion;     // Catch: Throwable -> L154
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L154
    L172:
        f186139b = (Integer) r109;
        goto L173
    L12:
        if ((r105 instanceof Integer) == true) goto L14;
        Object r129 = null;
    L15:
        r106 = (Integer) r129;     // Catch: Throwable -> L57
        if (r106 != null) goto L55;
        if ((r105 instanceof Number) == false) goto L42;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L27;
        Float r130 = Float.valueOf(((Number) r105).floatValue());     // Catch: Throwable -> L57
        if ((r130 instanceof Integer) == true) goto L25;
        r130 = null;
    L25:
        r106 = (Integer) r130;     // Catch: Throwable -> L57
        goto L55
    L27:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L33;
        Double r131 = Double.valueOf(((Number) r105).doubleValue());     // Catch: Throwable -> L57
        if ((r131 instanceof Integer) == true) goto L31;
        r131 = null;
    L31:
        r106 = (Integer) r131;     // Catch: Throwable -> L57
        goto L55
    L33:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L36;
        r106 = Integer.valueOf(((Number) r105).intValue());     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L42;
        Long r132 = Long.valueOf(((Number) r105).longValue());     // Catch: Throwable -> L57
        if ((r132 instanceof Integer) == true) goto L40;
        r132 = null;
    L40:
        r106 = (Integer) r132;     // Catch: Throwable -> L57
    L42:
        if ((r105 instanceof JSONObject) == false) goto L44;
    L364:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L50
        Object r133 = SDKSettingsCacheManager.a().fromJson(r105.toString(), Integer.class);     // Catch: Throwable -> L50
        if ((r133 instanceof Integer) == true) goto L48;
        r133 = null;
    L48:
        Object r134 = Result.m9449constructorimpl((Integer) r133);     // Catch: Throwable -> L50
    L52:
        r106 = r134;
        if (Result.m9455isFailureimpl(r106) == false) goto L55;
    L50:
        th = move-exception;
        Result.Companion r135 = Result.Companion;     // Catch: Throwable -> L57
        r134 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L52
    L44:
        if ((r105 instanceof JSONArray) == false) goto L54;
    L14:
        r129 = r105;
    L57:
        th = move-exception;
        Result.Companion r136 = Result.Companion;     // Catch: Throwable -> L163
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
    L163:
        th = move-exception;
        Result.Companion r137 = Result.Companion;
        Object r138 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r139 = Result.m9452exceptionOrNullimpl(r138);
        if (r139 == null) goto L168;
        EnsureManager.ensureNotReachHere(r139);
    L168:
        if (Result.m9455isFailureimpl(r138) == true) goto L171;
        r100 = r138;
    L171:
        r109 = r100;
    L173:
        Object r140 = f186139b;
        if (r140 == null) goto L177;
    L354:
        f186138a.put("ec_shop_mini_window_anim_opt", r140);
        return ((Number) r140).intValue();
    L177:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L179:
        if (Intrinsics.areEqual("HostExperiment", "ShopSetting") == false) goto L190;
        int r141 = p.f45243a;
        Result.Companion r142 = Result.Companion;     // Catch: Throwable -> L185
        jj4.b r143 = jj4.b.f499326b;     // Catch: Throwable -> L185
        r140 = jj4.a.a("ec_shop_mini_window_anim_opt", Integer.class, r100, false);     // Catch: Throwable -> L185
        if (r140 != null) goto L354;
        Intrinsics.throwNpe();     // Catch: Throwable -> L185
    L185:
        th = move-exception;
        Result.Companion r144 = Result.Companion;
        Object r145 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r145) == true) goto L353;
    L189:
        r100 = r145;
    L353:
        r140 = r100;
        goto L354
    L190:
        int r146 = n.f45241a;
        int r147 = com.bytedance.android.ec.base.settings.a.f42813a;
        Result.Companion r148 = Result.Companion;     // Catch: Throwable -> L347
        Object r149 = d.f42818c.get("ec_shop_mini_window_anim_opt");     // Catch: Throwable -> L241
        if (r149 != null) goto L196;
    L238:
        Object r150 = null;
    L239:
        Object r151 = Result.m9449constructorimpl(r150);     // Catch: Throwable -> L241
    L243:
        Throwable r152 = Result.m9452exceptionOrNullimpl(r151);     // Catch: Throwable -> L347
        if (r152 == null) goto L247;
        EnsureManager.ensureNotReachHere(r152);     // Catch: Throwable -> L347
    L247:
        if (Result.m9455isFailureimpl(r151) == false) goto L250;
        r151 = null;
    L250:
        if ((r151 instanceof Integer) == true) goto L252;
        r151 = null;
    L252:
        r140 = (Integer) r151;     // Catch: Throwable -> L347
        if (r140 != null) goto L259;
        Object r153 = d.f42816a.get("ec_shop_mini_window_anim_opt");     // Catch: Throwable -> L347
        if ((r153 instanceof Integer) == true) goto L258;
        r153 = null;
    L258:
        r140 = (Integer) r153;     // Catch: Throwable -> L347
    L259:
        if (r140 != null) goto L354;
        int r154 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L347
        Object r155 = d.f42818c.get("ec_shop_mini_window_anim_opt");     // Catch: Throwable -> L311
        if (r155 != null) goto L266;
    L308:
        Object r156 = null;
    L309:
        Object r157 = Result.m9449constructorimpl(r156);     // Catch: Throwable -> L311
    L313:
        Throwable r158 = Result.m9452exceptionOrNullimpl(r157);     // Catch: Throwable -> L338
        if (r158 == null) goto L317;
        EnsureManager.ensureNotReachHere(r158);     // Catch: Throwable -> L338
    L317:
        if (Result.m9455isFailureimpl(r157) == false) goto L320;
        r157 = null;
    L320:
        if ((r157 instanceof Integer) == true) goto L322;
        r157 = null;
    L322:
        r140 = (Integer) r157;     // Catch: Throwable -> L338
        if (r140 != null) goto L345;
        IHybridHostService r159 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L338
        if (r159 == null) goto L328;
        Object r160 = r159.getHostABValue("ec_shop_mini_window_anim_opt", r100);     // Catch: Throwable -> L338
    L329:
        if (r160 != null) goto L331;
    L344:
        r140 = r100;
        goto L345
    L331:
        if ((r160 instanceof Integer) == false) goto L334;
        r101 = r160;
    L334:
        Integer r161 = (Integer) r101;     // Catch: Throwable -> L338
        if (r161 == null) goto L344;
        r140 = r161;
        goto L345
    L338:
        th = move-exception;
        Result.Companion r162 = Result.Companion;     // Catch: Throwable -> L347
        r140 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L347
        Throwable r163 = Result.m9452exceptionOrNullimpl(r140);     // Catch: Throwable -> L347
        if (r163 == null) goto L343;
        EnsureManager.ensureNotReachHere(r163);     // Catch: Throwable -> L347
    L343:
        if (Result.m9455isFailureimpl(r140) == false) goto L345;
    L328:
        r160 = null;
    L345:
        d.d("ec_shop_mini_window_anim_opt", r140);     // Catch: Throwable -> L347
        goto L354
    L266:
        if ((r155 instanceof Integer) == true) goto L268;
        Object r164 = null;
    L269:
        r156 = (Integer) r164;     // Catch: Throwable -> L311
        if (r156 != null) goto L309;
        if ((r155 instanceof Number) == false) goto L296;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L281;
        Float r165 = Float.valueOf(((Number) r155).floatValue());     // Catch: Throwable -> L311
        if ((r165 instanceof Integer) == true) goto L279;
        r165 = null;
    L279:
        r156 = (Integer) r165;     // Catch: Throwable -> L311
        goto L309
    L281:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L287;
        Double r166 = Double.valueOf(((Number) r155).doubleValue());     // Catch: Throwable -> L311
        if ((r166 instanceof Integer) == true) goto L285;
        r166 = null;
    L285:
        r156 = (Integer) r166;     // Catch: Throwable -> L311
        goto L309
    L287:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L290;
        r156 = Integer.valueOf(((Number) r155).intValue());     // Catch: Throwable -> L311
        goto L309
    L290:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L296;
        Long r167 = Long.valueOf(((Number) r155).longValue());     // Catch: Throwable -> L311
        if ((r167 instanceof Integer) == true) goto L294;
        r167 = null;
    L294:
        r156 = (Integer) r167;     // Catch: Throwable -> L311
    L296:
        if ((r155 instanceof JSONObject) == false) goto L298;
    L380:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L304
        Object r168 = SDKSettingsCacheManager.a().fromJson(r155.toString(), Integer.class);     // Catch: Throwable -> L304
        if ((r168 instanceof Integer) == true) goto L302;
        r168 = null;
    L302:
        Object r169 = Result.m9449constructorimpl((Integer) r168);     // Catch: Throwable -> L304
    L306:
        r156 = r169;
        if (Result.m9455isFailureimpl(r156) == false) goto L309;
    L304:
        th = move-exception;
        Result.Companion r170 = Result.Companion;     // Catch: Throwable -> L311
        r169 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L311
        goto L306
    L298:
        if ((r155 instanceof JSONArray) == false) goto L308;
    L268:
        r164 = r155;
    L311:
        th = move-exception;
        Result.Companion r171 = Result.Companion;     // Catch: Throwable -> L338
        r157 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L338
        goto L313
    L196:
        if ((r149 instanceof Integer) == true) goto L198;
        Object r172 = null;
    L199:
        r150 = (Integer) r172;     // Catch: Throwable -> L241
        if (r150 != null) goto L239;
        if ((r149 instanceof Number) == false) goto L226;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L211;
        Float r173 = Float.valueOf(((Number) r149).floatValue());     // Catch: Throwable -> L241
        if ((r173 instanceof Integer) == true) goto L209;
        r173 = null;
    L209:
        r150 = (Integer) r173;     // Catch: Throwable -> L241
        goto L239
    L211:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L217;
        Double r174 = Double.valueOf(((Number) r149).doubleValue());     // Catch: Throwable -> L241
        if ((r174 instanceof Integer) == true) goto L215;
        r174 = null;
    L215:
        r150 = (Integer) r174;     // Catch: Throwable -> L241
        goto L239
    L217:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L220;
        r150 = Integer.valueOf(((Number) r149).intValue());     // Catch: Throwable -> L241
        goto L239
    L220:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L226;
        Long r175 = Long.valueOf(((Number) r149).longValue());     // Catch: Throwable -> L241
        if ((r175 instanceof Integer) == true) goto L224;
        r175 = null;
    L224:
        r150 = (Integer) r175;     // Catch: Throwable -> L241
    L226:
        if ((r149 instanceof JSONObject) == false) goto L228;
    L378:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L234
        Object r176 = SDKSettingsCacheManager.a().fromJson(r149.toString(), Integer.class);     // Catch: Throwable -> L234
        if ((r176 instanceof Integer) == true) goto L232;
        r176 = null;
    L232:
        Object r177 = Result.m9449constructorimpl((Integer) r176);     // Catch: Throwable -> L234
    L236:
        r150 = r177;
        if (Result.m9455isFailureimpl(r150) == false) goto L239;
    L234:
        th = move-exception;
        Result.Companion r178 = Result.Companion;     // Catch: Throwable -> L241
        r177 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L241
        goto L236
    L228:
        if ((r149 instanceof JSONArray) == false) goto L238;
    L198:
        r172 = r149;
    L241:
        th = move-exception;
        Result.Companion r179 = Result.Companion;     // Catch: Throwable -> L347
        r151 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L347
    L347:
        th = move-exception;
        Result.Companion r180 = Result.Companion;
        r145 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r181 = Result.m9452exceptionOrNullimpl(r145);
        if (r181 == null) goto L352;
        EnsureManager.ensureNotReachHere(r181);
    L352:
        if (Result.m9455isFailureimpl(r145) == false) goto L189;
        goto L189
    }

    @HostExperimentKey(author = "zhengjiali", desc = "商列跨店商卡接cardpack")
    @SettingReport
    public static final int getEC_SHOP_PRODUCT_BOTTOM_CARDPACK() {
        Object r100 = 0;
        Object r101 = null;
        if (Intrinsics.areEqual("ec_shop_product_bottom_cardpack", "ec_shop_launch_opt_common_2") == false) goto L179;
        if (f186139b != null) goto L173;
        int r102 = n.f45241a;
        int r103 = com.bytedance.android.ec.base.settings.a.f42813a;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L163
        Object r105 = d.f42818c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L57
        if (r105 != null) goto L12;
    L54:
        Object r106 = null;
    L55:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L57
    L59:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);     // Catch: Throwable -> L163
        if (r108 == null) goto L63;
        EnsureManager.ensureNotReachHere(r108);     // Catch: Throwable -> L163
    L63:
        if (Result.m9455isFailureimpl(r107) == false) goto L66;
        r107 = null;
    L66:
        if ((r107 instanceof Integer) == true) goto L68;
        r107 = null;
    L68:
        Object r109 = (Integer) r107;     // Catch: Throwable -> L163
        if (r109 != null) goto L75;
        Object r110 = d.f42816a.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L163
        if ((r110 instanceof Integer) == true) goto L74;
        r110 = null;
    L74:
        r109 = (Integer) r110;     // Catch: Throwable -> L163
    L75:
        if (r109 != null) goto L172;
        int r111 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L163
        Object r112 = d.f42818c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L127
        if (r112 != null) goto L82;
    L124:
        Object r113 = null;
    L125:
        Object r114 = Result.m9449constructorimpl(r113);     // Catch: Throwable -> L127
    L129:
        Throwable r115 = Result.m9452exceptionOrNullimpl(r114);     // Catch: Throwable -> L154
        if (r115 == null) goto L133;
        EnsureManager.ensureNotReachHere(r115);     // Catch: Throwable -> L154
    L133:
        if (Result.m9455isFailureimpl(r114) == false) goto L136;
        r114 = null;
    L136:
        if ((r114 instanceof Integer) == true) goto L138;
        r114 = null;
    L138:
        r109 = (Integer) r114;     // Catch: Throwable -> L154
        if (r109 != null) goto L161;
        IHybridHostService r116 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L154
        if (r116 == null) goto L144;
        Object r117 = r116.getHostABValue("ec_shop_launch_opt_common_2", r100);     // Catch: Throwable -> L154
    L145:
        if (r117 != null) goto L147;
    L160:
        r109 = r100;
        goto L161
    L147:
        if ((r117 instanceof Integer) == false) goto L150;
        r101 = r117;
    L150:
        Integer r118 = (Integer) r101;     // Catch: Throwable -> L154
        if (r118 == null) goto L160;
        r109 = r118;
        goto L161
    L154:
        th = move-exception;
        Result.Companion r119 = Result.Companion;     // Catch: Throwable -> L163
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
        Throwable r120 = Result.m9452exceptionOrNullimpl(r109);     // Catch: Throwable -> L163
        if (r120 == null) goto L159;
        EnsureManager.ensureNotReachHere(r120);     // Catch: Throwable -> L163
    L159:
        if (Result.m9455isFailureimpl(r109) == false) goto L161;
    L144:
        r117 = null;
    L161:
        d.d("ec_shop_launch_opt_common_2", r109);     // Catch: Throwable -> L163
        goto L172
    L82:
        if ((r112 instanceof Integer) == true) goto L84;
        Object r121 = null;
    L85:
        r113 = (Integer) r121;     // Catch: Throwable -> L127
        if (r113 != null) goto L125;
        if ((r112 instanceof Number) == false) goto L112;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r122 = Float.valueOf(((Number) r112).floatValue());     // Catch: Throwable -> L127
        if ((r122 instanceof Integer) == true) goto L95;
        r122 = null;
    L95:
        r113 = (Integer) r122;     // Catch: Throwable -> L127
        goto L125
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r123 = Double.valueOf(((Number) r112).doubleValue());     // Catch: Throwable -> L127
        if ((r123 instanceof Integer) == true) goto L101;
        r123 = null;
    L101:
        r113 = (Integer) r123;     // Catch: Throwable -> L127
        goto L125
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L106;
        r113 = Integer.valueOf(((Number) r112).intValue());     // Catch: Throwable -> L127
        goto L125
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L112;
        Long r124 = Long.valueOf(((Number) r112).longValue());     // Catch: Throwable -> L127
        if ((r124 instanceof Integer) == true) goto L110;
        r124 = null;
    L110:
        r113 = (Integer) r124;     // Catch: Throwable -> L127
    L112:
        if ((r112 instanceof JSONObject) == false) goto L114;
    L366:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L120
        Object r125 = SDKSettingsCacheManager.a().fromJson(r112.toString(), Integer.class);     // Catch: Throwable -> L120
        if ((r125 instanceof Integer) == true) goto L118;
        r125 = null;
    L118:
        Object r126 = Result.m9449constructorimpl((Integer) r125);     // Catch: Throwable -> L120
    L122:
        r113 = r126;
        if (Result.m9455isFailureimpl(r113) == false) goto L125;
    L120:
        th = move-exception;
        Result.Companion r127 = Result.Companion;     // Catch: Throwable -> L127
        r126 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L127
        goto L122
    L114:
        if ((r112 instanceof JSONArray) == false) goto L124;
    L84:
        r121 = r112;
    L127:
        th = move-exception;
        Result.Companion r128 = Result.Companion;     // Catch: Throwable -> L154
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L154
    L172:
        f186139b = (Integer) r109;
        goto L173
    L12:
        if ((r105 instanceof Integer) == true) goto L14;
        Object r129 = null;
    L15:
        r106 = (Integer) r129;     // Catch: Throwable -> L57
        if (r106 != null) goto L55;
        if ((r105 instanceof Number) == false) goto L42;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L27;
        Float r130 = Float.valueOf(((Number) r105).floatValue());     // Catch: Throwable -> L57
        if ((r130 instanceof Integer) == true) goto L25;
        r130 = null;
    L25:
        r106 = (Integer) r130;     // Catch: Throwable -> L57
        goto L55
    L27:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L33;
        Double r131 = Double.valueOf(((Number) r105).doubleValue());     // Catch: Throwable -> L57
        if ((r131 instanceof Integer) == true) goto L31;
        r131 = null;
    L31:
        r106 = (Integer) r131;     // Catch: Throwable -> L57
        goto L55
    L33:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L36;
        r106 = Integer.valueOf(((Number) r105).intValue());     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L42;
        Long r132 = Long.valueOf(((Number) r105).longValue());     // Catch: Throwable -> L57
        if ((r132 instanceof Integer) == true) goto L40;
        r132 = null;
    L40:
        r106 = (Integer) r132;     // Catch: Throwable -> L57
    L42:
        if ((r105 instanceof JSONObject) == false) goto L44;
    L364:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L50
        Object r133 = SDKSettingsCacheManager.a().fromJson(r105.toString(), Integer.class);     // Catch: Throwable -> L50
        if ((r133 instanceof Integer) == true) goto L48;
        r133 = null;
    L48:
        Object r134 = Result.m9449constructorimpl((Integer) r133);     // Catch: Throwable -> L50
    L52:
        r106 = r134;
        if (Result.m9455isFailureimpl(r106) == false) goto L55;
    L50:
        th = move-exception;
        Result.Companion r135 = Result.Companion;     // Catch: Throwable -> L57
        r134 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L52
    L44:
        if ((r105 instanceof JSONArray) == false) goto L54;
    L14:
        r129 = r105;
    L57:
        th = move-exception;
        Result.Companion r136 = Result.Companion;     // Catch: Throwable -> L163
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
    L163:
        th = move-exception;
        Result.Companion r137 = Result.Companion;
        Object r138 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r139 = Result.m9452exceptionOrNullimpl(r138);
        if (r139 == null) goto L168;
        EnsureManager.ensureNotReachHere(r139);
    L168:
        if (Result.m9455isFailureimpl(r138) == true) goto L171;
        r100 = r138;
    L171:
        r109 = r100;
    L173:
        Object r140 = f186139b;
        if (r140 == null) goto L177;
    L354:
        f186138a.put("ec_shop_product_bottom_cardpack", r140);
        return ((Number) r140).intValue();
    L177:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L179:
        if (Intrinsics.areEqual("HostExperiment", "ShopSetting") == false) goto L190;
        int r141 = p.f45243a;
        Result.Companion r142 = Result.Companion;     // Catch: Throwable -> L185
        jj4.b r143 = jj4.b.f499326b;     // Catch: Throwable -> L185
        r140 = jj4.a.a("ec_shop_product_bottom_cardpack", Integer.class, r100, false);     // Catch: Throwable -> L185
        if (r140 != null) goto L354;
        Intrinsics.throwNpe();     // Catch: Throwable -> L185
    L185:
        th = move-exception;
        Result.Companion r144 = Result.Companion;
        Object r145 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r145) == true) goto L353;
    L189:
        r100 = r145;
    L353:
        r140 = r100;
        goto L354
    L190:
        int r146 = n.f45241a;
        int r147 = com.bytedance.android.ec.base.settings.a.f42813a;
        Result.Companion r148 = Result.Companion;     // Catch: Throwable -> L347
        Object r149 = d.f42818c.get("ec_shop_product_bottom_cardpack");     // Catch: Throwable -> L241
        if (r149 != null) goto L196;
    L238:
        Object r150 = null;
    L239:
        Object r151 = Result.m9449constructorimpl(r150);     // Catch: Throwable -> L241
    L243:
        Throwable r152 = Result.m9452exceptionOrNullimpl(r151);     // Catch: Throwable -> L347
        if (r152 == null) goto L247;
        EnsureManager.ensureNotReachHere(r152);     // Catch: Throwable -> L347
    L247:
        if (Result.m9455isFailureimpl(r151) == false) goto L250;
        r151 = null;
    L250:
        if ((r151 instanceof Integer) == true) goto L252;
        r151 = null;
    L252:
        r140 = (Integer) r151;     // Catch: Throwable -> L347
        if (r140 != null) goto L259;
        Object r153 = d.f42816a.get("ec_shop_product_bottom_cardpack");     // Catch: Throwable -> L347
        if ((r153 instanceof Integer) == true) goto L258;
        r153 = null;
    L258:
        r140 = (Integer) r153;     // Catch: Throwable -> L347
    L259:
        if (r140 != null) goto L354;
        int r154 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L347
        Object r155 = d.f42818c.get("ec_shop_product_bottom_cardpack");     // Catch: Throwable -> L311
        if (r155 != null) goto L266;
    L308:
        Object r156 = null;
    L309:
        Object r157 = Result.m9449constructorimpl(r156);     // Catch: Throwable -> L311
    L313:
        Throwable r158 = Result.m9452exceptionOrNullimpl(r157);     // Catch: Throwable -> L338
        if (r158 == null) goto L317;
        EnsureManager.ensureNotReachHere(r158);     // Catch: Throwable -> L338
    L317:
        if (Result.m9455isFailureimpl(r157) == false) goto L320;
        r157 = null;
    L320:
        if ((r157 instanceof Integer) == true) goto L322;
        r157 = null;
    L322:
        r140 = (Integer) r157;     // Catch: Throwable -> L338
        if (r140 != null) goto L345;
        IHybridHostService r159 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L338
        if (r159 == null) goto L328;
        Object r160 = r159.getHostABValue("ec_shop_product_bottom_cardpack", r100);     // Catch: Throwable -> L338
    L329:
        if (r160 != null) goto L331;
    L344:
        r140 = r100;
        goto L345
    L331:
        if ((r160 instanceof Integer) == false) goto L334;
        r101 = r160;
    L334:
        Integer r161 = (Integer) r101;     // Catch: Throwable -> L338
        if (r161 == null) goto L344;
        r140 = r161;
        goto L345
    L338:
        th = move-exception;
        Result.Companion r162 = Result.Companion;     // Catch: Throwable -> L347
        r140 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L347
        Throwable r163 = Result.m9452exceptionOrNullimpl(r140);     // Catch: Throwable -> L347
        if (r163 == null) goto L343;
        EnsureManager.ensureNotReachHere(r163);     // Catch: Throwable -> L347
    L343:
        if (Result.m9455isFailureimpl(r140) == false) goto L345;
    L328:
        r160 = null;
    L345:
        d.d("ec_shop_product_bottom_cardpack", r140);     // Catch: Throwable -> L347
        goto L354
    L266:
        if ((r155 instanceof Integer) == true) goto L268;
        Object r164 = null;
    L269:
        r156 = (Integer) r164;     // Catch: Throwable -> L311
        if (r156 != null) goto L309;
        if ((r155 instanceof Number) == false) goto L296;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L281;
        Float r165 = Float.valueOf(((Number) r155).floatValue());     // Catch: Throwable -> L311
        if ((r165 instanceof Integer) == true) goto L279;
        r165 = null;
    L279:
        r156 = (Integer) r165;     // Catch: Throwable -> L311
        goto L309
    L281:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L287;
        Double r166 = Double.valueOf(((Number) r155).doubleValue());     // Catch: Throwable -> L311
        if ((r166 instanceof Integer) == true) goto L285;
        r166 = null;
    L285:
        r156 = (Integer) r166;     // Catch: Throwable -> L311
        goto L309
    L287:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L290;
        r156 = Integer.valueOf(((Number) r155).intValue());     // Catch: Throwable -> L311
        goto L309
    L290:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L296;
        Long r167 = Long.valueOf(((Number) r155).longValue());     // Catch: Throwable -> L311
        if ((r167 instanceof Integer) == true) goto L294;
        r167 = null;
    L294:
        r156 = (Integer) r167;     // Catch: Throwable -> L311
    L296:
        if ((r155 instanceof JSONObject) == false) goto L298;
    L380:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L304
        Object r168 = SDKSettingsCacheManager.a().fromJson(r155.toString(), Integer.class);     // Catch: Throwable -> L304
        if ((r168 instanceof Integer) == true) goto L302;
        r168 = null;
    L302:
        Object r169 = Result.m9449constructorimpl((Integer) r168);     // Catch: Throwable -> L304
    L306:
        r156 = r169;
        if (Result.m9455isFailureimpl(r156) == false) goto L309;
    L304:
        th = move-exception;
        Result.Companion r170 = Result.Companion;     // Catch: Throwable -> L311
        r169 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L311
        goto L306
    L298:
        if ((r155 instanceof JSONArray) == false) goto L308;
    L268:
        r164 = r155;
    L311:
        th = move-exception;
        Result.Companion r171 = Result.Companion;     // Catch: Throwable -> L338
        r157 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L338
        goto L313
    L196:
        if ((r149 instanceof Integer) == true) goto L198;
        Object r172 = null;
    L199:
        r150 = (Integer) r172;     // Catch: Throwable -> L241
        if (r150 != null) goto L239;
        if ((r149 instanceof Number) == false) goto L226;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L211;
        Float r173 = Float.valueOf(((Number) r149).floatValue());     // Catch: Throwable -> L241
        if ((r173 instanceof Integer) == true) goto L209;
        r173 = null;
    L209:
        r150 = (Integer) r173;     // Catch: Throwable -> L241
        goto L239
    L211:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L217;
        Double r174 = Double.valueOf(((Number) r149).doubleValue());     // Catch: Throwable -> L241
        if ((r174 instanceof Integer) == true) goto L215;
        r174 = null;
    L215:
        r150 = (Integer) r174;     // Catch: Throwable -> L241
        goto L239
    L217:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L220;
        r150 = Integer.valueOf(((Number) r149).intValue());     // Catch: Throwable -> L241
        goto L239
    L220:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L226;
        Long r175 = Long.valueOf(((Number) r149).longValue());     // Catch: Throwable -> L241
        if ((r175 instanceof Integer) == true) goto L224;
        r175 = null;
    L224:
        r150 = (Integer) r175;     // Catch: Throwable -> L241
    L226:
        if ((r149 instanceof JSONObject) == false) goto L228;
    L378:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L234
        Object r176 = SDKSettingsCacheManager.a().fromJson(r149.toString(), Integer.class);     // Catch: Throwable -> L234
        if ((r176 instanceof Integer) == true) goto L232;
        r176 = null;
    L232:
        Object r177 = Result.m9449constructorimpl((Integer) r176);     // Catch: Throwable -> L234
    L236:
        r150 = r177;
        if (Result.m9455isFailureimpl(r150) == false) goto L239;
    L234:
        th = move-exception;
        Result.Companion r178 = Result.Companion;     // Catch: Throwable -> L241
        r177 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L241
        goto L236
    L228:
        if ((r149 instanceof JSONArray) == false) goto L238;
    L198:
        r172 = r149;
    L241:
        th = move-exception;
        Result.Companion r179 = Result.Companion;     // Catch: Throwable -> L347
        r151 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L347
    L347:
        th = move-exception;
        Result.Companion r180 = Result.Companion;
        r145 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r181 = Result.m9452exceptionOrNullimpl(r145);
        if (r181 == null) goto L352;
        EnsureManager.ensureNotReachHere(r181);
    L352:
        if (Result.m9455isFailureimpl(r145) == false) goto L189;
        goto L189
    }

    @HostExperimentKey(author = "zhengsai.2022", desc = "推荐>精选二出一展示")
    @SettingReport
    public static final int getEC_SHOP_RECOMMEND_PAGE_OPT() {
        Object r100 = 0;
        Object r101 = null;
        if (Intrinsics.areEqual("ec_shop_recommend_page_opt", "ec_shop_launch_opt_common_2") == false) goto L179;
        if (f186139b != null) goto L173;
        int r102 = n.f45241a;
        int r103 = com.bytedance.android.ec.base.settings.a.f42813a;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L163
        Object r105 = d.f42818c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L57
        if (r105 != null) goto L12;
    L54:
        Object r106 = null;
    L55:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L57
    L59:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);     // Catch: Throwable -> L163
        if (r108 == null) goto L63;
        EnsureManager.ensureNotReachHere(r108);     // Catch: Throwable -> L163
    L63:
        if (Result.m9455isFailureimpl(r107) == false) goto L66;
        r107 = null;
    L66:
        if ((r107 instanceof Integer) == true) goto L68;
        r107 = null;
    L68:
        Object r109 = (Integer) r107;     // Catch: Throwable -> L163
        if (r109 != null) goto L75;
        Object r110 = d.f42816a.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L163
        if ((r110 instanceof Integer) == true) goto L74;
        r110 = null;
    L74:
        r109 = (Integer) r110;     // Catch: Throwable -> L163
    L75:
        if (r109 != null) goto L172;
        int r111 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L163
        Object r112 = d.f42818c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L127
        if (r112 != null) goto L82;
    L124:
        Object r113 = null;
    L125:
        Object r114 = Result.m9449constructorimpl(r113);     // Catch: Throwable -> L127
    L129:
        Throwable r115 = Result.m9452exceptionOrNullimpl(r114);     // Catch: Throwable -> L154
        if (r115 == null) goto L133;
        EnsureManager.ensureNotReachHere(r115);     // Catch: Throwable -> L154
    L133:
        if (Result.m9455isFailureimpl(r114) == false) goto L136;
        r114 = null;
    L136:
        if ((r114 instanceof Integer) == true) goto L138;
        r114 = null;
    L138:
        r109 = (Integer) r114;     // Catch: Throwable -> L154
        if (r109 != null) goto L161;
        IHybridHostService r116 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L154
        if (r116 == null) goto L144;
        Object r117 = r116.getHostABValue("ec_shop_launch_opt_common_2", r100);     // Catch: Throwable -> L154
    L145:
        if (r117 != null) goto L147;
    L160:
        r109 = r100;
        goto L161
    L147:
        if ((r117 instanceof Integer) == false) goto L150;
        r101 = r117;
    L150:
        Integer r118 = (Integer) r101;     // Catch: Throwable -> L154
        if (r118 == null) goto L160;
        r109 = r118;
        goto L161
    L154:
        th = move-exception;
        Result.Companion r119 = Result.Companion;     // Catch: Throwable -> L163
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
        Throwable r120 = Result.m9452exceptionOrNullimpl(r109);     // Catch: Throwable -> L163
        if (r120 == null) goto L159;
        EnsureManager.ensureNotReachHere(r120);     // Catch: Throwable -> L163
    L159:
        if (Result.m9455isFailureimpl(r109) == false) goto L161;
    L144:
        r117 = null;
    L161:
        d.d("ec_shop_launch_opt_common_2", r109);     // Catch: Throwable -> L163
        goto L172
    L82:
        if ((r112 instanceof Integer) == true) goto L84;
        Object r121 = null;
    L85:
        r113 = (Integer) r121;     // Catch: Throwable -> L127
        if (r113 != null) goto L125;
        if ((r112 instanceof Number) == false) goto L112;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r122 = Float.valueOf(((Number) r112).floatValue());     // Catch: Throwable -> L127
        if ((r122 instanceof Integer) == true) goto L95;
        r122 = null;
    L95:
        r113 = (Integer) r122;     // Catch: Throwable -> L127
        goto L125
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r123 = Double.valueOf(((Number) r112).doubleValue());     // Catch: Throwable -> L127
        if ((r123 instanceof Integer) == true) goto L101;
        r123 = null;
    L101:
        r113 = (Integer) r123;     // Catch: Throwable -> L127
        goto L125
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L106;
        r113 = Integer.valueOf(((Number) r112).intValue());     // Catch: Throwable -> L127
        goto L125
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L112;
        Long r124 = Long.valueOf(((Number) r112).longValue());     // Catch: Throwable -> L127
        if ((r124 instanceof Integer) == true) goto L110;
        r124 = null;
    L110:
        r113 = (Integer) r124;     // Catch: Throwable -> L127
    L112:
        if ((r112 instanceof JSONObject) == false) goto L114;
    L366:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L120
        Object r125 = SDKSettingsCacheManager.a().fromJson(r112.toString(), Integer.class);     // Catch: Throwable -> L120
        if ((r125 instanceof Integer) == true) goto L118;
        r125 = null;
    L118:
        Object r126 = Result.m9449constructorimpl((Integer) r125);     // Catch: Throwable -> L120
    L122:
        r113 = r126;
        if (Result.m9455isFailureimpl(r113) == false) goto L125;
    L120:
        th = move-exception;
        Result.Companion r127 = Result.Companion;     // Catch: Throwable -> L127
        r126 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L127
        goto L122
    L114:
        if ((r112 instanceof JSONArray) == false) goto L124;
    L84:
        r121 = r112;
    L127:
        th = move-exception;
        Result.Companion r128 = Result.Companion;     // Catch: Throwable -> L154
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L154
    L172:
        f186139b = (Integer) r109;
        goto L173
    L12:
        if ((r105 instanceof Integer) == true) goto L14;
        Object r129 = null;
    L15:
        r106 = (Integer) r129;     // Catch: Throwable -> L57
        if (r106 != null) goto L55;
        if ((r105 instanceof Number) == false) goto L42;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L27;
        Float r130 = Float.valueOf(((Number) r105).floatValue());     // Catch: Throwable -> L57
        if ((r130 instanceof Integer) == true) goto L25;
        r130 = null;
    L25:
        r106 = (Integer) r130;     // Catch: Throwable -> L57
        goto L55
    L27:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L33;
        Double r131 = Double.valueOf(((Number) r105).doubleValue());     // Catch: Throwable -> L57
        if ((r131 instanceof Integer) == true) goto L31;
        r131 = null;
    L31:
        r106 = (Integer) r131;     // Catch: Throwable -> L57
        goto L55
    L33:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L36;
        r106 = Integer.valueOf(((Number) r105).intValue());     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L42;
        Long r132 = Long.valueOf(((Number) r105).longValue());     // Catch: Throwable -> L57
        if ((r132 instanceof Integer) == true) goto L40;
        r132 = null;
    L40:
        r106 = (Integer) r132;     // Catch: Throwable -> L57
    L42:
        if ((r105 instanceof JSONObject) == false) goto L44;
    L364:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L50
        Object r133 = SDKSettingsCacheManager.a().fromJson(r105.toString(), Integer.class);     // Catch: Throwable -> L50
        if ((r133 instanceof Integer) == true) goto L48;
        r133 = null;
    L48:
        Object r134 = Result.m9449constructorimpl((Integer) r133);     // Catch: Throwable -> L50
    L52:
        r106 = r134;
        if (Result.m9455isFailureimpl(r106) == false) goto L55;
    L50:
        th = move-exception;
        Result.Companion r135 = Result.Companion;     // Catch: Throwable -> L57
        r134 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L52
    L44:
        if ((r105 instanceof JSONArray) == false) goto L54;
    L14:
        r129 = r105;
    L57:
        th = move-exception;
        Result.Companion r136 = Result.Companion;     // Catch: Throwable -> L163
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
    L163:
        th = move-exception;
        Result.Companion r137 = Result.Companion;
        Object r138 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r139 = Result.m9452exceptionOrNullimpl(r138);
        if (r139 == null) goto L168;
        EnsureManager.ensureNotReachHere(r139);
    L168:
        if (Result.m9455isFailureimpl(r138) == true) goto L171;
        r100 = r138;
    L171:
        r109 = r100;
    L173:
        Object r140 = f186139b;
        if (r140 == null) goto L177;
    L354:
        f186138a.put("ec_shop_recommend_page_opt", r140);
        return ((Number) r140).intValue();
    L177:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L179:
        if (Intrinsics.areEqual("HostExperiment", "ShopSetting") == false) goto L190;
        int r141 = p.f45243a;
        Result.Companion r142 = Result.Companion;     // Catch: Throwable -> L185
        jj4.b r143 = jj4.b.f499326b;     // Catch: Throwable -> L185
        r140 = jj4.a.a("ec_shop_recommend_page_opt", Integer.class, r100, false);     // Catch: Throwable -> L185
        if (r140 != null) goto L354;
        Intrinsics.throwNpe();     // Catch: Throwable -> L185
    L185:
        th = move-exception;
        Result.Companion r144 = Result.Companion;
        Object r145 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r145) == true) goto L353;
    L189:
        r100 = r145;
    L353:
        r140 = r100;
        goto L354
    L190:
        int r146 = n.f45241a;
        int r147 = com.bytedance.android.ec.base.settings.a.f42813a;
        Result.Companion r148 = Result.Companion;     // Catch: Throwable -> L347
        Object r149 = d.f42818c.get("ec_shop_recommend_page_opt");     // Catch: Throwable -> L241
        if (r149 != null) goto L196;
    L238:
        Object r150 = null;
    L239:
        Object r151 = Result.m9449constructorimpl(r150);     // Catch: Throwable -> L241
    L243:
        Throwable r152 = Result.m9452exceptionOrNullimpl(r151);     // Catch: Throwable -> L347
        if (r152 == null) goto L247;
        EnsureManager.ensureNotReachHere(r152);     // Catch: Throwable -> L347
    L247:
        if (Result.m9455isFailureimpl(r151) == false) goto L250;
        r151 = null;
    L250:
        if ((r151 instanceof Integer) == true) goto L252;
        r151 = null;
    L252:
        r140 = (Integer) r151;     // Catch: Throwable -> L347
        if (r140 != null) goto L259;
        Object r153 = d.f42816a.get("ec_shop_recommend_page_opt");     // Catch: Throwable -> L347
        if ((r153 instanceof Integer) == true) goto L258;
        r153 = null;
    L258:
        r140 = (Integer) r153;     // Catch: Throwable -> L347
    L259:
        if (r140 != null) goto L354;
        int r154 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L347
        Object r155 = d.f42818c.get("ec_shop_recommend_page_opt");     // Catch: Throwable -> L311
        if (r155 != null) goto L266;
    L308:
        Object r156 = null;
    L309:
        Object r157 = Result.m9449constructorimpl(r156);     // Catch: Throwable -> L311
    L313:
        Throwable r158 = Result.m9452exceptionOrNullimpl(r157);     // Catch: Throwable -> L338
        if (r158 == null) goto L317;
        EnsureManager.ensureNotReachHere(r158);     // Catch: Throwable -> L338
    L317:
        if (Result.m9455isFailureimpl(r157) == false) goto L320;
        r157 = null;
    L320:
        if ((r157 instanceof Integer) == true) goto L322;
        r157 = null;
    L322:
        r140 = (Integer) r157;     // Catch: Throwable -> L338
        if (r140 != null) goto L345;
        IHybridHostService r159 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L338
        if (r159 == null) goto L328;
        Object r160 = r159.getHostABValue("ec_shop_recommend_page_opt", r100);     // Catch: Throwable -> L338
    L329:
        if (r160 != null) goto L331;
    L344:
        r140 = r100;
        goto L345
    L331:
        if ((r160 instanceof Integer) == false) goto L334;
        r101 = r160;
    L334:
        Integer r161 = (Integer) r101;     // Catch: Throwable -> L338
        if (r161 == null) goto L344;
        r140 = r161;
        goto L345
    L338:
        th = move-exception;
        Result.Companion r162 = Result.Companion;     // Catch: Throwable -> L347
        r140 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L347
        Throwable r163 = Result.m9452exceptionOrNullimpl(r140);     // Catch: Throwable -> L347
        if (r163 == null) goto L343;
        EnsureManager.ensureNotReachHere(r163);     // Catch: Throwable -> L347
    L343:
        if (Result.m9455isFailureimpl(r140) == false) goto L345;
    L328:
        r160 = null;
    L345:
        d.d("ec_shop_recommend_page_opt", r140);     // Catch: Throwable -> L347
        goto L354
    L266:
        if ((r155 instanceof Integer) == true) goto L268;
        Object r164 = null;
    L269:
        r156 = (Integer) r164;     // Catch: Throwable -> L311
        if (r156 != null) goto L309;
        if ((r155 instanceof Number) == false) goto L296;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L281;
        Float r165 = Float.valueOf(((Number) r155).floatValue());     // Catch: Throwable -> L311
        if ((r165 instanceof Integer) == true) goto L279;
        r165 = null;
    L279:
        r156 = (Integer) r165;     // Catch: Throwable -> L311
        goto L309
    L281:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L287;
        Double r166 = Double.valueOf(((Number) r155).doubleValue());     // Catch: Throwable -> L311
        if ((r166 instanceof Integer) == true) goto L285;
        r166 = null;
    L285:
        r156 = (Integer) r166;     // Catch: Throwable -> L311
        goto L309
    L287:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L290;
        r156 = Integer.valueOf(((Number) r155).intValue());     // Catch: Throwable -> L311
        goto L309
    L290:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L296;
        Long r167 = Long.valueOf(((Number) r155).longValue());     // Catch: Throwable -> L311
        if ((r167 instanceof Integer) == true) goto L294;
        r167 = null;
    L294:
        r156 = (Integer) r167;     // Catch: Throwable -> L311
    L296:
        if ((r155 instanceof JSONObject) == false) goto L298;
    L380:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L304
        Object r168 = SDKSettingsCacheManager.a().fromJson(r155.toString(), Integer.class);     // Catch: Throwable -> L304
        if ((r168 instanceof Integer) == true) goto L302;
        r168 = null;
    L302:
        Object r169 = Result.m9449constructorimpl((Integer) r168);     // Catch: Throwable -> L304
    L306:
        r156 = r169;
        if (Result.m9455isFailureimpl(r156) == false) goto L309;
    L304:
        th = move-exception;
        Result.Companion r170 = Result.Companion;     // Catch: Throwable -> L311
        r169 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L311
        goto L306
    L298:
        if ((r155 instanceof JSONArray) == false) goto L308;
    L268:
        r164 = r155;
    L311:
        th = move-exception;
        Result.Companion r171 = Result.Companion;     // Catch: Throwable -> L338
        r157 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L338
        goto L313
    L196:
        if ((r149 instanceof Integer) == true) goto L198;
        Object r172 = null;
    L199:
        r150 = (Integer) r172;     // Catch: Throwable -> L241
        if (r150 != null) goto L239;
        if ((r149 instanceof Number) == false) goto L226;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L211;
        Float r173 = Float.valueOf(((Number) r149).floatValue());     // Catch: Throwable -> L241
        if ((r173 instanceof Integer) == true) goto L209;
        r173 = null;
    L209:
        r150 = (Integer) r173;     // Catch: Throwable -> L241
        goto L239
    L211:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L217;
        Double r174 = Double.valueOf(((Number) r149).doubleValue());     // Catch: Throwable -> L241
        if ((r174 instanceof Integer) == true) goto L215;
        r174 = null;
    L215:
        r150 = (Integer) r174;     // Catch: Throwable -> L241
        goto L239
    L217:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L220;
        r150 = Integer.valueOf(((Number) r149).intValue());     // Catch: Throwable -> L241
        goto L239
    L220:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L226;
        Long r175 = Long.valueOf(((Number) r149).longValue());     // Catch: Throwable -> L241
        if ((r175 instanceof Integer) == true) goto L224;
        r175 = null;
    L224:
        r150 = (Integer) r175;     // Catch: Throwable -> L241
    L226:
        if ((r149 instanceof JSONObject) == false) goto L228;
    L378:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L234
        Object r176 = SDKSettingsCacheManager.a().fromJson(r149.toString(), Integer.class);     // Catch: Throwable -> L234
        if ((r176 instanceof Integer) == true) goto L232;
        r176 = null;
    L232:
        Object r177 = Result.m9449constructorimpl((Integer) r176);     // Catch: Throwable -> L234
    L236:
        r150 = r177;
        if (Result.m9455isFailureimpl(r150) == false) goto L239;
    L234:
        th = move-exception;
        Result.Companion r178 = Result.Companion;     // Catch: Throwable -> L241
        r177 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L241
        goto L236
    L228:
        if ((r149 instanceof JSONArray) == false) goto L238;
    L198:
        r172 = r149;
    L241:
        th = move-exception;
        Result.Companion r179 = Result.Companion;     // Catch: Throwable -> L347
        r151 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L347
    L347:
        th = move-exception;
        Result.Companion r180 = Result.Companion;
        r145 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r181 = Result.m9452exceptionOrNullimpl(r145);
        if (r181 == null) goto L352;
        EnsureManager.ensureNotReachHere(r181);
    L352:
        if (Result.m9455isFailureimpl(r145) == false) goto L189;
        goto L189
    }

    @HostExperimentKey(author = "qiuhongwei.hiro", desc = "搜索框UI优化")
    @SettingReport
    public static final int getEC_SHOP_SEARCH_BAR_UI_OPTIMIZE() {
        Object r100 = 0;
        Object r101 = null;
        if (Intrinsics.areEqual("ec_shop_search_bar_ui_optimize", "ec_shop_launch_opt_common_2") == false) goto L179;
        if (f186139b != null) goto L173;
        int r102 = n.f45241a;
        int r103 = com.bytedance.android.ec.base.settings.a.f42813a;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L163
        Object r105 = d.f42818c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L57
        if (r105 != null) goto L12;
    L54:
        Object r106 = null;
    L55:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L57
    L59:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);     // Catch: Throwable -> L163
        if (r108 == null) goto L63;
        EnsureManager.ensureNotReachHere(r108);     // Catch: Throwable -> L163
    L63:
        if (Result.m9455isFailureimpl(r107) == false) goto L66;
        r107 = null;
    L66:
        if ((r107 instanceof Integer) == true) goto L68;
        r107 = null;
    L68:
        Object r109 = (Integer) r107;     // Catch: Throwable -> L163
        if (r109 != null) goto L75;
        Object r110 = d.f42816a.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L163
        if ((r110 instanceof Integer) == true) goto L74;
        r110 = null;
    L74:
        r109 = (Integer) r110;     // Catch: Throwable -> L163
    L75:
        if (r109 != null) goto L172;
        int r111 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L163
        Object r112 = d.f42818c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L127
        if (r112 != null) goto L82;
    L124:
        Object r113 = null;
    L125:
        Object r114 = Result.m9449constructorimpl(r113);     // Catch: Throwable -> L127
    L129:
        Throwable r115 = Result.m9452exceptionOrNullimpl(r114);     // Catch: Throwable -> L154
        if (r115 == null) goto L133;
        EnsureManager.ensureNotReachHere(r115);     // Catch: Throwable -> L154
    L133:
        if (Result.m9455isFailureimpl(r114) == false) goto L136;
        r114 = null;
    L136:
        if ((r114 instanceof Integer) == true) goto L138;
        r114 = null;
    L138:
        r109 = (Integer) r114;     // Catch: Throwable -> L154
        if (r109 != null) goto L161;
        IHybridHostService r116 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L154
        if (r116 == null) goto L144;
        Object r117 = r116.getHostABValue("ec_shop_launch_opt_common_2", r100);     // Catch: Throwable -> L154
    L145:
        if (r117 != null) goto L147;
    L160:
        r109 = r100;
        goto L161
    L147:
        if ((r117 instanceof Integer) == false) goto L150;
        r101 = r117;
    L150:
        Integer r118 = (Integer) r101;     // Catch: Throwable -> L154
        if (r118 == null) goto L160;
        r109 = r118;
        goto L161
    L154:
        th = move-exception;
        Result.Companion r119 = Result.Companion;     // Catch: Throwable -> L163
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
        Throwable r120 = Result.m9452exceptionOrNullimpl(r109);     // Catch: Throwable -> L163
        if (r120 == null) goto L159;
        EnsureManager.ensureNotReachHere(r120);     // Catch: Throwable -> L163
    L159:
        if (Result.m9455isFailureimpl(r109) == false) goto L161;
    L144:
        r117 = null;
    L161:
        d.d("ec_shop_launch_opt_common_2", r109);     // Catch: Throwable -> L163
        goto L172
    L82:
        if ((r112 instanceof Integer) == true) goto L84;
        Object r121 = null;
    L85:
        r113 = (Integer) r121;     // Catch: Throwable -> L127
        if (r113 != null) goto L125;
        if ((r112 instanceof Number) == false) goto L112;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r122 = Float.valueOf(((Number) r112).floatValue());     // Catch: Throwable -> L127
        if ((r122 instanceof Integer) == true) goto L95;
        r122 = null;
    L95:
        r113 = (Integer) r122;     // Catch: Throwable -> L127
        goto L125
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r123 = Double.valueOf(((Number) r112).doubleValue());     // Catch: Throwable -> L127
        if ((r123 instanceof Integer) == true) goto L101;
        r123 = null;
    L101:
        r113 = (Integer) r123;     // Catch: Throwable -> L127
        goto L125
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L106;
        r113 = Integer.valueOf(((Number) r112).intValue());     // Catch: Throwable -> L127
        goto L125
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L112;
        Long r124 = Long.valueOf(((Number) r112).longValue());     // Catch: Throwable -> L127
        if ((r124 instanceof Integer) == true) goto L110;
        r124 = null;
    L110:
        r113 = (Integer) r124;     // Catch: Throwable -> L127
    L112:
        if ((r112 instanceof JSONObject) == false) goto L114;
    L366:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L120
        Object r125 = SDKSettingsCacheManager.a().fromJson(r112.toString(), Integer.class);     // Catch: Throwable -> L120
        if ((r125 instanceof Integer) == true) goto L118;
        r125 = null;
    L118:
        Object r126 = Result.m9449constructorimpl((Integer) r125);     // Catch: Throwable -> L120
    L122:
        r113 = r126;
        if (Result.m9455isFailureimpl(r113) == false) goto L125;
    L120:
        th = move-exception;
        Result.Companion r127 = Result.Companion;     // Catch: Throwable -> L127
        r126 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L127
        goto L122
    L114:
        if ((r112 instanceof JSONArray) == false) goto L124;
    L84:
        r121 = r112;
    L127:
        th = move-exception;
        Result.Companion r128 = Result.Companion;     // Catch: Throwable -> L154
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L154
    L172:
        f186139b = (Integer) r109;
        goto L173
    L12:
        if ((r105 instanceof Integer) == true) goto L14;
        Object r129 = null;
    L15:
        r106 = (Integer) r129;     // Catch: Throwable -> L57
        if (r106 != null) goto L55;
        if ((r105 instanceof Number) == false) goto L42;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L27;
        Float r130 = Float.valueOf(((Number) r105).floatValue());     // Catch: Throwable -> L57
        if ((r130 instanceof Integer) == true) goto L25;
        r130 = null;
    L25:
        r106 = (Integer) r130;     // Catch: Throwable -> L57
        goto L55
    L27:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L33;
        Double r131 = Double.valueOf(((Number) r105).doubleValue());     // Catch: Throwable -> L57
        if ((r131 instanceof Integer) == true) goto L31;
        r131 = null;
    L31:
        r106 = (Integer) r131;     // Catch: Throwable -> L57
        goto L55
    L33:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L36;
        r106 = Integer.valueOf(((Number) r105).intValue());     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L42;
        Long r132 = Long.valueOf(((Number) r105).longValue());     // Catch: Throwable -> L57
        if ((r132 instanceof Integer) == true) goto L40;
        r132 = null;
    L40:
        r106 = (Integer) r132;     // Catch: Throwable -> L57
    L42:
        if ((r105 instanceof JSONObject) == false) goto L44;
    L364:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L50
        Object r133 = SDKSettingsCacheManager.a().fromJson(r105.toString(), Integer.class);     // Catch: Throwable -> L50
        if ((r133 instanceof Integer) == true) goto L48;
        r133 = null;
    L48:
        Object r134 = Result.m9449constructorimpl((Integer) r133);     // Catch: Throwable -> L50
    L52:
        r106 = r134;
        if (Result.m9455isFailureimpl(r106) == false) goto L55;
    L50:
        th = move-exception;
        Result.Companion r135 = Result.Companion;     // Catch: Throwable -> L57
        r134 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L52
    L44:
        if ((r105 instanceof JSONArray) == false) goto L54;
    L14:
        r129 = r105;
    L57:
        th = move-exception;
        Result.Companion r136 = Result.Companion;     // Catch: Throwable -> L163
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
    L163:
        th = move-exception;
        Result.Companion r137 = Result.Companion;
        Object r138 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r139 = Result.m9452exceptionOrNullimpl(r138);
        if (r139 == null) goto L168;
        EnsureManager.ensureNotReachHere(r139);
    L168:
        if (Result.m9455isFailureimpl(r138) == true) goto L171;
        r100 = r138;
    L171:
        r109 = r100;
    L173:
        Object r140 = f186139b;
        if (r140 == null) goto L177;
    L354:
        f186138a.put("ec_shop_search_bar_ui_optimize", r140);
        return ((Number) r140).intValue();
    L177:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L179:
        if (Intrinsics.areEqual("HostExperiment", "ShopSetting") == false) goto L190;
        int r141 = p.f45243a;
        Result.Companion r142 = Result.Companion;     // Catch: Throwable -> L185
        jj4.b r143 = jj4.b.f499326b;     // Catch: Throwable -> L185
        r140 = jj4.a.a("ec_shop_search_bar_ui_optimize", Integer.class, r100, false);     // Catch: Throwable -> L185
        if (r140 != null) goto L354;
        Intrinsics.throwNpe();     // Catch: Throwable -> L185
    L185:
        th = move-exception;
        Result.Companion r144 = Result.Companion;
        Object r145 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r145) == true) goto L353;
    L189:
        r100 = r145;
    L353:
        r140 = r100;
        goto L354
    L190:
        int r146 = n.f45241a;
        int r147 = com.bytedance.android.ec.base.settings.a.f42813a;
        Result.Companion r148 = Result.Companion;     // Catch: Throwable -> L347
        Object r149 = d.f42818c.get("ec_shop_search_bar_ui_optimize");     // Catch: Throwable -> L241
        if (r149 != null) goto L196;
    L238:
        Object r150 = null;
    L239:
        Object r151 = Result.m9449constructorimpl(r150);     // Catch: Throwable -> L241
    L243:
        Throwable r152 = Result.m9452exceptionOrNullimpl(r151);     // Catch: Throwable -> L347
        if (r152 == null) goto L247;
        EnsureManager.ensureNotReachHere(r152);     // Catch: Throwable -> L347
    L247:
        if (Result.m9455isFailureimpl(r151) == false) goto L250;
        r151 = null;
    L250:
        if ((r151 instanceof Integer) == true) goto L252;
        r151 = null;
    L252:
        r140 = (Integer) r151;     // Catch: Throwable -> L347
        if (r140 != null) goto L259;
        Object r153 = d.f42816a.get("ec_shop_search_bar_ui_optimize");     // Catch: Throwable -> L347
        if ((r153 instanceof Integer) == true) goto L258;
        r153 = null;
    L258:
        r140 = (Integer) r153;     // Catch: Throwable -> L347
    L259:
        if (r140 != null) goto L354;
        int r154 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L347
        Object r155 = d.f42818c.get("ec_shop_search_bar_ui_optimize");     // Catch: Throwable -> L311
        if (r155 != null) goto L266;
    L308:
        Object r156 = null;
    L309:
        Object r157 = Result.m9449constructorimpl(r156);     // Catch: Throwable -> L311
    L313:
        Throwable r158 = Result.m9452exceptionOrNullimpl(r157);     // Catch: Throwable -> L338
        if (r158 == null) goto L317;
        EnsureManager.ensureNotReachHere(r158);     // Catch: Throwable -> L338
    L317:
        if (Result.m9455isFailureimpl(r157) == false) goto L320;
        r157 = null;
    L320:
        if ((r157 instanceof Integer) == true) goto L322;
        r157 = null;
    L322:
        r140 = (Integer) r157;     // Catch: Throwable -> L338
        if (r140 != null) goto L345;
        IHybridHostService r159 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L338
        if (r159 == null) goto L328;
        Object r160 = r159.getHostABValue("ec_shop_search_bar_ui_optimize", r100);     // Catch: Throwable -> L338
    L329:
        if (r160 != null) goto L331;
    L344:
        r140 = r100;
        goto L345
    L331:
        if ((r160 instanceof Integer) == false) goto L334;
        r101 = r160;
    L334:
        Integer r161 = (Integer) r101;     // Catch: Throwable -> L338
        if (r161 == null) goto L344;
        r140 = r161;
        goto L345
    L338:
        th = move-exception;
        Result.Companion r162 = Result.Companion;     // Catch: Throwable -> L347
        r140 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L347
        Throwable r163 = Result.m9452exceptionOrNullimpl(r140);     // Catch: Throwable -> L347
        if (r163 == null) goto L343;
        EnsureManager.ensureNotReachHere(r163);     // Catch: Throwable -> L347
    L343:
        if (Result.m9455isFailureimpl(r140) == false) goto L345;
    L328:
        r160 = null;
    L345:
        d.d("ec_shop_search_bar_ui_optimize", r140);     // Catch: Throwable -> L347
        goto L354
    L266:
        if ((r155 instanceof Integer) == true) goto L268;
        Object r164 = null;
    L269:
        r156 = (Integer) r164;     // Catch: Throwable -> L311
        if (r156 != null) goto L309;
        if ((r155 instanceof Number) == false) goto L296;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L281;
        Float r165 = Float.valueOf(((Number) r155).floatValue());     // Catch: Throwable -> L311
        if ((r165 instanceof Integer) == true) goto L279;
        r165 = null;
    L279:
        r156 = (Integer) r165;     // Catch: Throwable -> L311
        goto L309
    L281:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L287;
        Double r166 = Double.valueOf(((Number) r155).doubleValue());     // Catch: Throwable -> L311
        if ((r166 instanceof Integer) == true) goto L285;
        r166 = null;
    L285:
        r156 = (Integer) r166;     // Catch: Throwable -> L311
        goto L309
    L287:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L290;
        r156 = Integer.valueOf(((Number) r155).intValue());     // Catch: Throwable -> L311
        goto L309
    L290:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L296;
        Long r167 = Long.valueOf(((Number) r155).longValue());     // Catch: Throwable -> L311
        if ((r167 instanceof Integer) == true) goto L294;
        r167 = null;
    L294:
        r156 = (Integer) r167;     // Catch: Throwable -> L311
    L296:
        if ((r155 instanceof JSONObject) == false) goto L298;
    L380:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L304
        Object r168 = SDKSettingsCacheManager.a().fromJson(r155.toString(), Integer.class);     // Catch: Throwable -> L304
        if ((r168 instanceof Integer) == true) goto L302;
        r168 = null;
    L302:
        Object r169 = Result.m9449constructorimpl((Integer) r168);     // Catch: Throwable -> L304
    L306:
        r156 = r169;
        if (Result.m9455isFailureimpl(r156) == false) goto L309;
    L304:
        th = move-exception;
        Result.Companion r170 = Result.Companion;     // Catch: Throwable -> L311
        r169 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L311
        goto L306
    L298:
        if ((r155 instanceof JSONArray) == false) goto L308;
    L268:
        r164 = r155;
    L311:
        th = move-exception;
        Result.Companion r171 = Result.Companion;     // Catch: Throwable -> L338
        r157 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L338
        goto L313
    L196:
        if ((r149 instanceof Integer) == true) goto L198;
        Object r172 = null;
    L199:
        r150 = (Integer) r172;     // Catch: Throwable -> L241
        if (r150 != null) goto L239;
        if ((r149 instanceof Number) == false) goto L226;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L211;
        Float r173 = Float.valueOf(((Number) r149).floatValue());     // Catch: Throwable -> L241
        if ((r173 instanceof Integer) == true) goto L209;
        r173 = null;
    L209:
        r150 = (Integer) r173;     // Catch: Throwable -> L241
        goto L239
    L211:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L217;
        Double r174 = Double.valueOf(((Number) r149).doubleValue());     // Catch: Throwable -> L241
        if ((r174 instanceof Integer) == true) goto L215;
        r174 = null;
    L215:
        r150 = (Integer) r174;     // Catch: Throwable -> L241
        goto L239
    L217:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L220;
        r150 = Integer.valueOf(((Number) r149).intValue());     // Catch: Throwable -> L241
        goto L239
    L220:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L226;
        Long r175 = Long.valueOf(((Number) r149).longValue());     // Catch: Throwable -> L241
        if ((r175 instanceof Integer) == true) goto L224;
        r175 = null;
    L224:
        r150 = (Integer) r175;     // Catch: Throwable -> L241
    L226:
        if ((r149 instanceof JSONObject) == false) goto L228;
    L378:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L234
        Object r176 = SDKSettingsCacheManager.a().fromJson(r149.toString(), Integer.class);     // Catch: Throwable -> L234
        if ((r176 instanceof Integer) == true) goto L232;
        r176 = null;
    L232:
        Object r177 = Result.m9449constructorimpl((Integer) r176);     // Catch: Throwable -> L234
    L236:
        r150 = r177;
        if (Result.m9455isFailureimpl(r150) == false) goto L239;
    L234:
        th = move-exception;
        Result.Companion r178 = Result.Companion;     // Catch: Throwable -> L241
        r177 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L241
        goto L236
    L228:
        if ((r149 instanceof JSONArray) == false) goto L238;
    L198:
        r172 = r149;
    L241:
        th = move-exception;
        Result.Companion r179 = Result.Companion;     // Catch: Throwable -> L347
        r151 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L347
    L347:
        th = move-exception;
        Result.Companion r180 = Result.Companion;
        r145 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r181 = Result.m9452exceptionOrNullimpl(r145);
        if (r181 == null) goto L352;
        EnsureManager.ensureNotReachHere(r181);
    L352:
        if (Result.m9455isFailureimpl(r145) == false) goto L189;
        goto L189
    }

    @HostExperimentKey(author = "qiuhongwei.hiro", desc = "搜索中间页样式实验")
    @SettingReport
    public static final int getEC_SHOP_SEARCH_GUIDE_STYLE() {
        Object r100 = 0;
        Object r101 = null;
        if (Intrinsics.areEqual("ec_shop_search_guide_style", "ec_shop_launch_opt_common_2") == false) goto L179;
        if (f186139b != null) goto L173;
        int r102 = n.f45241a;
        int r103 = com.bytedance.android.ec.base.settings.a.f42813a;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L163
        Object r105 = d.f42818c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L57
        if (r105 != null) goto L12;
    L54:
        Object r106 = null;
    L55:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L57
    L59:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);     // Catch: Throwable -> L163
        if (r108 == null) goto L63;
        EnsureManager.ensureNotReachHere(r108);     // Catch: Throwable -> L163
    L63:
        if (Result.m9455isFailureimpl(r107) == false) goto L66;
        r107 = null;
    L66:
        if ((r107 instanceof Integer) == true) goto L68;
        r107 = null;
    L68:
        Object r109 = (Integer) r107;     // Catch: Throwable -> L163
        if (r109 != null) goto L75;
        Object r110 = d.f42816a.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L163
        if ((r110 instanceof Integer) == true) goto L74;
        r110 = null;
    L74:
        r109 = (Integer) r110;     // Catch: Throwable -> L163
    L75:
        if (r109 != null) goto L172;
        int r111 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L163
        Object r112 = d.f42818c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L127
        if (r112 != null) goto L82;
    L124:
        Object r113 = null;
    L125:
        Object r114 = Result.m9449constructorimpl(r113);     // Catch: Throwable -> L127
    L129:
        Throwable r115 = Result.m9452exceptionOrNullimpl(r114);     // Catch: Throwable -> L154
        if (r115 == null) goto L133;
        EnsureManager.ensureNotReachHere(r115);     // Catch: Throwable -> L154
    L133:
        if (Result.m9455isFailureimpl(r114) == false) goto L136;
        r114 = null;
    L136:
        if ((r114 instanceof Integer) == true) goto L138;
        r114 = null;
    L138:
        r109 = (Integer) r114;     // Catch: Throwable -> L154
        if (r109 != null) goto L161;
        IHybridHostService r116 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L154
        if (r116 == null) goto L144;
        Object r117 = r116.getHostABValue("ec_shop_launch_opt_common_2", r100);     // Catch: Throwable -> L154
    L145:
        if (r117 != null) goto L147;
    L160:
        r109 = r100;
        goto L161
    L147:
        if ((r117 instanceof Integer) == false) goto L150;
        r101 = r117;
    L150:
        Integer r118 = (Integer) r101;     // Catch: Throwable -> L154
        if (r118 == null) goto L160;
        r109 = r118;
        goto L161
    L154:
        th = move-exception;
        Result.Companion r119 = Result.Companion;     // Catch: Throwable -> L163
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
        Throwable r120 = Result.m9452exceptionOrNullimpl(r109);     // Catch: Throwable -> L163
        if (r120 == null) goto L159;
        EnsureManager.ensureNotReachHere(r120);     // Catch: Throwable -> L163
    L159:
        if (Result.m9455isFailureimpl(r109) == false) goto L161;
    L144:
        r117 = null;
    L161:
        d.d("ec_shop_launch_opt_common_2", r109);     // Catch: Throwable -> L163
        goto L172
    L82:
        if ((r112 instanceof Integer) == true) goto L84;
        Object r121 = null;
    L85:
        r113 = (Integer) r121;     // Catch: Throwable -> L127
        if (r113 != null) goto L125;
        if ((r112 instanceof Number) == false) goto L112;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r122 = Float.valueOf(((Number) r112).floatValue());     // Catch: Throwable -> L127
        if ((r122 instanceof Integer) == true) goto L95;
        r122 = null;
    L95:
        r113 = (Integer) r122;     // Catch: Throwable -> L127
        goto L125
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r123 = Double.valueOf(((Number) r112).doubleValue());     // Catch: Throwable -> L127
        if ((r123 instanceof Integer) == true) goto L101;
        r123 = null;
    L101:
        r113 = (Integer) r123;     // Catch: Throwable -> L127
        goto L125
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L106;
        r113 = Integer.valueOf(((Number) r112).intValue());     // Catch: Throwable -> L127
        goto L125
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L112;
        Long r124 = Long.valueOf(((Number) r112).longValue());     // Catch: Throwable -> L127
        if ((r124 instanceof Integer) == true) goto L110;
        r124 = null;
    L110:
        r113 = (Integer) r124;     // Catch: Throwable -> L127
    L112:
        if ((r112 instanceof JSONObject) == false) goto L114;
    L366:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L120
        Object r125 = SDKSettingsCacheManager.a().fromJson(r112.toString(), Integer.class);     // Catch: Throwable -> L120
        if ((r125 instanceof Integer) == true) goto L118;
        r125 = null;
    L118:
        Object r126 = Result.m9449constructorimpl((Integer) r125);     // Catch: Throwable -> L120
    L122:
        r113 = r126;
        if (Result.m9455isFailureimpl(r113) == false) goto L125;
    L120:
        th = move-exception;
        Result.Companion r127 = Result.Companion;     // Catch: Throwable -> L127
        r126 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L127
        goto L122
    L114:
        if ((r112 instanceof JSONArray) == false) goto L124;
    L84:
        r121 = r112;
    L127:
        th = move-exception;
        Result.Companion r128 = Result.Companion;     // Catch: Throwable -> L154
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L154
    L172:
        f186139b = (Integer) r109;
        goto L173
    L12:
        if ((r105 instanceof Integer) == true) goto L14;
        Object r129 = null;
    L15:
        r106 = (Integer) r129;     // Catch: Throwable -> L57
        if (r106 != null) goto L55;
        if ((r105 instanceof Number) == false) goto L42;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L27;
        Float r130 = Float.valueOf(((Number) r105).floatValue());     // Catch: Throwable -> L57
        if ((r130 instanceof Integer) == true) goto L25;
        r130 = null;
    L25:
        r106 = (Integer) r130;     // Catch: Throwable -> L57
        goto L55
    L27:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L33;
        Double r131 = Double.valueOf(((Number) r105).doubleValue());     // Catch: Throwable -> L57
        if ((r131 instanceof Integer) == true) goto L31;
        r131 = null;
    L31:
        r106 = (Integer) r131;     // Catch: Throwable -> L57
        goto L55
    L33:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L36;
        r106 = Integer.valueOf(((Number) r105).intValue());     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L42;
        Long r132 = Long.valueOf(((Number) r105).longValue());     // Catch: Throwable -> L57
        if ((r132 instanceof Integer) == true) goto L40;
        r132 = null;
    L40:
        r106 = (Integer) r132;     // Catch: Throwable -> L57
    L42:
        if ((r105 instanceof JSONObject) == false) goto L44;
    L364:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L50
        Object r133 = SDKSettingsCacheManager.a().fromJson(r105.toString(), Integer.class);     // Catch: Throwable -> L50
        if ((r133 instanceof Integer) == true) goto L48;
        r133 = null;
    L48:
        Object r134 = Result.m9449constructorimpl((Integer) r133);     // Catch: Throwable -> L50
    L52:
        r106 = r134;
        if (Result.m9455isFailureimpl(r106) == false) goto L55;
    L50:
        th = move-exception;
        Result.Companion r135 = Result.Companion;     // Catch: Throwable -> L57
        r134 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L52
    L44:
        if ((r105 instanceof JSONArray) == false) goto L54;
    L14:
        r129 = r105;
    L57:
        th = move-exception;
        Result.Companion r136 = Result.Companion;     // Catch: Throwable -> L163
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
    L163:
        th = move-exception;
        Result.Companion r137 = Result.Companion;
        Object r138 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r139 = Result.m9452exceptionOrNullimpl(r138);
        if (r139 == null) goto L168;
        EnsureManager.ensureNotReachHere(r139);
    L168:
        if (Result.m9455isFailureimpl(r138) == true) goto L171;
        r100 = r138;
    L171:
        r109 = r100;
    L173:
        Object r140 = f186139b;
        if (r140 == null) goto L177;
    L354:
        f186138a.put("ec_shop_search_guide_style", r140);
        return ((Number) r140).intValue();
    L177:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L179:
        if (Intrinsics.areEqual("HostExperiment", "ShopSetting") == false) goto L190;
        int r141 = p.f45243a;
        Result.Companion r142 = Result.Companion;     // Catch: Throwable -> L185
        jj4.b r143 = jj4.b.f499326b;     // Catch: Throwable -> L185
        r140 = jj4.a.a("ec_shop_search_guide_style", Integer.class, r100, false);     // Catch: Throwable -> L185
        if (r140 != null) goto L354;
        Intrinsics.throwNpe();     // Catch: Throwable -> L185
    L185:
        th = move-exception;
        Result.Companion r144 = Result.Companion;
        Object r145 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r145) == true) goto L353;
    L189:
        r100 = r145;
    L353:
        r140 = r100;
        goto L354
    L190:
        int r146 = n.f45241a;
        int r147 = com.bytedance.android.ec.base.settings.a.f42813a;
        Result.Companion r148 = Result.Companion;     // Catch: Throwable -> L347
        Object r149 = d.f42818c.get("ec_shop_search_guide_style");     // Catch: Throwable -> L241
        if (r149 != null) goto L196;
    L238:
        Object r150 = null;
    L239:
        Object r151 = Result.m9449constructorimpl(r150);     // Catch: Throwable -> L241
    L243:
        Throwable r152 = Result.m9452exceptionOrNullimpl(r151);     // Catch: Throwable -> L347
        if (r152 == null) goto L247;
        EnsureManager.ensureNotReachHere(r152);     // Catch: Throwable -> L347
    L247:
        if (Result.m9455isFailureimpl(r151) == false) goto L250;
        r151 = null;
    L250:
        if ((r151 instanceof Integer) == true) goto L252;
        r151 = null;
    L252:
        r140 = (Integer) r151;     // Catch: Throwable -> L347
        if (r140 != null) goto L259;
        Object r153 = d.f42816a.get("ec_shop_search_guide_style");     // Catch: Throwable -> L347
        if ((r153 instanceof Integer) == true) goto L258;
        r153 = null;
    L258:
        r140 = (Integer) r153;     // Catch: Throwable -> L347
    L259:
        if (r140 != null) goto L354;
        int r154 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L347
        Object r155 = d.f42818c.get("ec_shop_search_guide_style");     // Catch: Throwable -> L311
        if (r155 != null) goto L266;
    L308:
        Object r156 = null;
    L309:
        Object r157 = Result.m9449constructorimpl(r156);     // Catch: Throwable -> L311
    L313:
        Throwable r158 = Result.m9452exceptionOrNullimpl(r157);     // Catch: Throwable -> L338
        if (r158 == null) goto L317;
        EnsureManager.ensureNotReachHere(r158);     // Catch: Throwable -> L338
    L317:
        if (Result.m9455isFailureimpl(r157) == false) goto L320;
        r157 = null;
    L320:
        if ((r157 instanceof Integer) == true) goto L322;
        r157 = null;
    L322:
        r140 = (Integer) r157;     // Catch: Throwable -> L338
        if (r140 != null) goto L345;
        IHybridHostService r159 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L338
        if (r159 == null) goto L328;
        Object r160 = r159.getHostABValue("ec_shop_search_guide_style", r100);     // Catch: Throwable -> L338
    L329:
        if (r160 != null) goto L331;
    L344:
        r140 = r100;
        goto L345
    L331:
        if ((r160 instanceof Integer) == false) goto L334;
        r101 = r160;
    L334:
        Integer r161 = (Integer) r101;     // Catch: Throwable -> L338
        if (r161 == null) goto L344;
        r140 = r161;
        goto L345
    L338:
        th = move-exception;
        Result.Companion r162 = Result.Companion;     // Catch: Throwable -> L347
        r140 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L347
        Throwable r163 = Result.m9452exceptionOrNullimpl(r140);     // Catch: Throwable -> L347
        if (r163 == null) goto L343;
        EnsureManager.ensureNotReachHere(r163);     // Catch: Throwable -> L347
    L343:
        if (Result.m9455isFailureimpl(r140) == false) goto L345;
    L328:
        r160 = null;
    L345:
        d.d("ec_shop_search_guide_style", r140);     // Catch: Throwable -> L347
        goto L354
    L266:
        if ((r155 instanceof Integer) == true) goto L268;
        Object r164 = null;
    L269:
        r156 = (Integer) r164;     // Catch: Throwable -> L311
        if (r156 != null) goto L309;
        if ((r155 instanceof Number) == false) goto L296;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L281;
        Float r165 = Float.valueOf(((Number) r155).floatValue());     // Catch: Throwable -> L311
        if ((r165 instanceof Integer) == true) goto L279;
        r165 = null;
    L279:
        r156 = (Integer) r165;     // Catch: Throwable -> L311
        goto L309
    L281:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L287;
        Double r166 = Double.valueOf(((Number) r155).doubleValue());     // Catch: Throwable -> L311
        if ((r166 instanceof Integer) == true) goto L285;
        r166 = null;
    L285:
        r156 = (Integer) r166;     // Catch: Throwable -> L311
        goto L309
    L287:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L290;
        r156 = Integer.valueOf(((Number) r155).intValue());     // Catch: Throwable -> L311
        goto L309
    L290:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L296;
        Long r167 = Long.valueOf(((Number) r155).longValue());     // Catch: Throwable -> L311
        if ((r167 instanceof Integer) == true) goto L294;
        r167 = null;
    L294:
        r156 = (Integer) r167;     // Catch: Throwable -> L311
    L296:
        if ((r155 instanceof JSONObject) == false) goto L298;
    L380:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L304
        Object r168 = SDKSettingsCacheManager.a().fromJson(r155.toString(), Integer.class);     // Catch: Throwable -> L304
        if ((r168 instanceof Integer) == true) goto L302;
        r168 = null;
    L302:
        Object r169 = Result.m9449constructorimpl((Integer) r168);     // Catch: Throwable -> L304
    L306:
        r156 = r169;
        if (Result.m9455isFailureimpl(r156) == false) goto L309;
    L304:
        th = move-exception;
        Result.Companion r170 = Result.Companion;     // Catch: Throwable -> L311
        r169 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L311
        goto L306
    L298:
        if ((r155 instanceof JSONArray) == false) goto L308;
    L268:
        r164 = r155;
    L311:
        th = move-exception;
        Result.Companion r171 = Result.Companion;     // Catch: Throwable -> L338
        r157 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L338
        goto L313
    L196:
        if ((r149 instanceof Integer) == true) goto L198;
        Object r172 = null;
    L199:
        r150 = (Integer) r172;     // Catch: Throwable -> L241
        if (r150 != null) goto L239;
        if ((r149 instanceof Number) == false) goto L226;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L211;
        Float r173 = Float.valueOf(((Number) r149).floatValue());     // Catch: Throwable -> L241
        if ((r173 instanceof Integer) == true) goto L209;
        r173 = null;
    L209:
        r150 = (Integer) r173;     // Catch: Throwable -> L241
        goto L239
    L211:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L217;
        Double r174 = Double.valueOf(((Number) r149).doubleValue());     // Catch: Throwable -> L241
        if ((r174 instanceof Integer) == true) goto L215;
        r174 = null;
    L215:
        r150 = (Integer) r174;     // Catch: Throwable -> L241
        goto L239
    L217:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L220;
        r150 = Integer.valueOf(((Number) r149).intValue());     // Catch: Throwable -> L241
        goto L239
    L220:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L226;
        Long r175 = Long.valueOf(((Number) r149).longValue());     // Catch: Throwable -> L241
        if ((r175 instanceof Integer) == true) goto L224;
        r175 = null;
    L224:
        r150 = (Integer) r175;     // Catch: Throwable -> L241
    L226:
        if ((r149 instanceof JSONObject) == false) goto L228;
    L378:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L234
        Object r176 = SDKSettingsCacheManager.a().fromJson(r149.toString(), Integer.class);     // Catch: Throwable -> L234
        if ((r176 instanceof Integer) == true) goto L232;
        r176 = null;
    L232:
        Object r177 = Result.m9449constructorimpl((Integer) r176);     // Catch: Throwable -> L234
    L236:
        r150 = r177;
        if (Result.m9455isFailureimpl(r150) == false) goto L239;
    L234:
        th = move-exception;
        Result.Companion r178 = Result.Companion;     // Catch: Throwable -> L241
        r177 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L241
        goto L236
    L228:
        if ((r149 instanceof JSONArray) == false) goto L238;
    L198:
        r172 = r149;
    L241:
        th = move-exception;
        Result.Companion r179 = Result.Companion;     // Catch: Throwable -> L347
        r151 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L347
    L347:
        th = move-exception;
        Result.Companion r180 = Result.Companion;
        r145 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r181 = Result.m9452exceptionOrNullimpl(r145);
        if (r181 == null) goto L352;
        EnsureManager.ensureNotReachHere(r181);
    L352:
        if (Result.m9455isFailureimpl(r145) == false) goto L189;
        goto L189
    }

    @HostExperimentKey(author = "chenlong.hz", desc = "搜索词提示词渐隐")
    @SettingReport
    public static final int getEC_SHOP_SEARCH_HINT_GRADIENT() {
        Object r100 = 0;
        Object r101 = null;
        if (Intrinsics.areEqual("ec_shop_search_hint_gradient", "ec_shop_launch_opt_common_2") == false) goto L179;
        if (f186139b != null) goto L173;
        int r102 = n.f45241a;
        int r103 = com.bytedance.android.ec.base.settings.a.f42813a;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L163
        Object r105 = d.f42818c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L57
        if (r105 != null) goto L12;
    L54:
        Object r106 = null;
    L55:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L57
    L59:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);     // Catch: Throwable -> L163
        if (r108 == null) goto L63;
        EnsureManager.ensureNotReachHere(r108);     // Catch: Throwable -> L163
    L63:
        if (Result.m9455isFailureimpl(r107) == false) goto L66;
        r107 = null;
    L66:
        if ((r107 instanceof Integer) == true) goto L68;
        r107 = null;
    L68:
        Object r109 = (Integer) r107;     // Catch: Throwable -> L163
        if (r109 != null) goto L75;
        Object r110 = d.f42816a.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L163
        if ((r110 instanceof Integer) == true) goto L74;
        r110 = null;
    L74:
        r109 = (Integer) r110;     // Catch: Throwable -> L163
    L75:
        if (r109 != null) goto L172;
        int r111 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L163
        Object r112 = d.f42818c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L127
        if (r112 != null) goto L82;
    L124:
        Object r113 = null;
    L125:
        Object r114 = Result.m9449constructorimpl(r113);     // Catch: Throwable -> L127
    L129:
        Throwable r115 = Result.m9452exceptionOrNullimpl(r114);     // Catch: Throwable -> L154
        if (r115 == null) goto L133;
        EnsureManager.ensureNotReachHere(r115);     // Catch: Throwable -> L154
    L133:
        if (Result.m9455isFailureimpl(r114) == false) goto L136;
        r114 = null;
    L136:
        if ((r114 instanceof Integer) == true) goto L138;
        r114 = null;
    L138:
        r109 = (Integer) r114;     // Catch: Throwable -> L154
        if (r109 != null) goto L161;
        IHybridHostService r116 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L154
        if (r116 == null) goto L144;
        Object r117 = r116.getHostABValue("ec_shop_launch_opt_common_2", r100);     // Catch: Throwable -> L154
    L145:
        if (r117 != null) goto L147;
    L160:
        r109 = r100;
        goto L161
    L147:
        if ((r117 instanceof Integer) == false) goto L150;
        r101 = r117;
    L150:
        Integer r118 = (Integer) r101;     // Catch: Throwable -> L154
        if (r118 == null) goto L160;
        r109 = r118;
        goto L161
    L154:
        th = move-exception;
        Result.Companion r119 = Result.Companion;     // Catch: Throwable -> L163
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
        Throwable r120 = Result.m9452exceptionOrNullimpl(r109);     // Catch: Throwable -> L163
        if (r120 == null) goto L159;
        EnsureManager.ensureNotReachHere(r120);     // Catch: Throwable -> L163
    L159:
        if (Result.m9455isFailureimpl(r109) == false) goto L161;
    L144:
        r117 = null;
    L161:
        d.d("ec_shop_launch_opt_common_2", r109);     // Catch: Throwable -> L163
        goto L172
    L82:
        if ((r112 instanceof Integer) == true) goto L84;
        Object r121 = null;
    L85:
        r113 = (Integer) r121;     // Catch: Throwable -> L127
        if (r113 != null) goto L125;
        if ((r112 instanceof Number) == false) goto L112;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r122 = Float.valueOf(((Number) r112).floatValue());     // Catch: Throwable -> L127
        if ((r122 instanceof Integer) == true) goto L95;
        r122 = null;
    L95:
        r113 = (Integer) r122;     // Catch: Throwable -> L127
        goto L125
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r123 = Double.valueOf(((Number) r112).doubleValue());     // Catch: Throwable -> L127
        if ((r123 instanceof Integer) == true) goto L101;
        r123 = null;
    L101:
        r113 = (Integer) r123;     // Catch: Throwable -> L127
        goto L125
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L106;
        r113 = Integer.valueOf(((Number) r112).intValue());     // Catch: Throwable -> L127
        goto L125
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L112;
        Long r124 = Long.valueOf(((Number) r112).longValue());     // Catch: Throwable -> L127
        if ((r124 instanceof Integer) == true) goto L110;
        r124 = null;
    L110:
        r113 = (Integer) r124;     // Catch: Throwable -> L127
    L112:
        if ((r112 instanceof JSONObject) == false) goto L114;
    L366:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L120
        Object r125 = SDKSettingsCacheManager.a().fromJson(r112.toString(), Integer.class);     // Catch: Throwable -> L120
        if ((r125 instanceof Integer) == true) goto L118;
        r125 = null;
    L118:
        Object r126 = Result.m9449constructorimpl((Integer) r125);     // Catch: Throwable -> L120
    L122:
        r113 = r126;
        if (Result.m9455isFailureimpl(r113) == false) goto L125;
    L120:
        th = move-exception;
        Result.Companion r127 = Result.Companion;     // Catch: Throwable -> L127
        r126 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L127
        goto L122
    L114:
        if ((r112 instanceof JSONArray) == false) goto L124;
    L84:
        r121 = r112;
    L127:
        th = move-exception;
        Result.Companion r128 = Result.Companion;     // Catch: Throwable -> L154
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L154
    L172:
        f186139b = (Integer) r109;
        goto L173
    L12:
        if ((r105 instanceof Integer) == true) goto L14;
        Object r129 = null;
    L15:
        r106 = (Integer) r129;     // Catch: Throwable -> L57
        if (r106 != null) goto L55;
        if ((r105 instanceof Number) == false) goto L42;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L27;
        Float r130 = Float.valueOf(((Number) r105).floatValue());     // Catch: Throwable -> L57
        if ((r130 instanceof Integer) == true) goto L25;
        r130 = null;
    L25:
        r106 = (Integer) r130;     // Catch: Throwable -> L57
        goto L55
    L27:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L33;
        Double r131 = Double.valueOf(((Number) r105).doubleValue());     // Catch: Throwable -> L57
        if ((r131 instanceof Integer) == true) goto L31;
        r131 = null;
    L31:
        r106 = (Integer) r131;     // Catch: Throwable -> L57
        goto L55
    L33:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L36;
        r106 = Integer.valueOf(((Number) r105).intValue());     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L42;
        Long r132 = Long.valueOf(((Number) r105).longValue());     // Catch: Throwable -> L57
        if ((r132 instanceof Integer) == true) goto L40;
        r132 = null;
    L40:
        r106 = (Integer) r132;     // Catch: Throwable -> L57
    L42:
        if ((r105 instanceof JSONObject) == false) goto L44;
    L364:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L50
        Object r133 = SDKSettingsCacheManager.a().fromJson(r105.toString(), Integer.class);     // Catch: Throwable -> L50
        if ((r133 instanceof Integer) == true) goto L48;
        r133 = null;
    L48:
        Object r134 = Result.m9449constructorimpl((Integer) r133);     // Catch: Throwable -> L50
    L52:
        r106 = r134;
        if (Result.m9455isFailureimpl(r106) == false) goto L55;
    L50:
        th = move-exception;
        Result.Companion r135 = Result.Companion;     // Catch: Throwable -> L57
        r134 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L52
    L44:
        if ((r105 instanceof JSONArray) == false) goto L54;
    L14:
        r129 = r105;
    L57:
        th = move-exception;
        Result.Companion r136 = Result.Companion;     // Catch: Throwable -> L163
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
    L163:
        th = move-exception;
        Result.Companion r137 = Result.Companion;
        Object r138 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r139 = Result.m9452exceptionOrNullimpl(r138);
        if (r139 == null) goto L168;
        EnsureManager.ensureNotReachHere(r139);
    L168:
        if (Result.m9455isFailureimpl(r138) == true) goto L171;
        r100 = r138;
    L171:
        r109 = r100;
    L173:
        Object r140 = f186139b;
        if (r140 == null) goto L177;
    L354:
        f186138a.put("ec_shop_search_hint_gradient", r140);
        return ((Number) r140).intValue();
    L177:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L179:
        if (Intrinsics.areEqual("HostExperiment", "ShopSetting") == false) goto L190;
        int r141 = p.f45243a;
        Result.Companion r142 = Result.Companion;     // Catch: Throwable -> L185
        jj4.b r143 = jj4.b.f499326b;     // Catch: Throwable -> L185
        r140 = jj4.a.a("ec_shop_search_hint_gradient", Integer.class, r100, false);     // Catch: Throwable -> L185
        if (r140 != null) goto L354;
        Intrinsics.throwNpe();     // Catch: Throwable -> L185
    L185:
        th = move-exception;
        Result.Companion r144 = Result.Companion;
        Object r145 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r145) == true) goto L353;
    L189:
        r100 = r145;
    L353:
        r140 = r100;
        goto L354
    L190:
        int r146 = n.f45241a;
        int r147 = com.bytedance.android.ec.base.settings.a.f42813a;
        Result.Companion r148 = Result.Companion;     // Catch: Throwable -> L347
        Object r149 = d.f42818c.get("ec_shop_search_hint_gradient");     // Catch: Throwable -> L241
        if (r149 != null) goto L196;
    L238:
        Object r150 = null;
    L239:
        Object r151 = Result.m9449constructorimpl(r150);     // Catch: Throwable -> L241
    L243:
        Throwable r152 = Result.m9452exceptionOrNullimpl(r151);     // Catch: Throwable -> L347
        if (r152 == null) goto L247;
        EnsureManager.ensureNotReachHere(r152);     // Catch: Throwable -> L347
    L247:
        if (Result.m9455isFailureimpl(r151) == false) goto L250;
        r151 = null;
    L250:
        if ((r151 instanceof Integer) == true) goto L252;
        r151 = null;
    L252:
        r140 = (Integer) r151;     // Catch: Throwable -> L347
        if (r140 != null) goto L259;
        Object r153 = d.f42816a.get("ec_shop_search_hint_gradient");     // Catch: Throwable -> L347
        if ((r153 instanceof Integer) == true) goto L258;
        r153 = null;
    L258:
        r140 = (Integer) r153;     // Catch: Throwable -> L347
    L259:
        if (r140 != null) goto L354;
        int r154 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L347
        Object r155 = d.f42818c.get("ec_shop_search_hint_gradient");     // Catch: Throwable -> L311
        if (r155 != null) goto L266;
    L308:
        Object r156 = null;
    L309:
        Object r157 = Result.m9449constructorimpl(r156);     // Catch: Throwable -> L311
    L313:
        Throwable r158 = Result.m9452exceptionOrNullimpl(r157);     // Catch: Throwable -> L338
        if (r158 == null) goto L317;
        EnsureManager.ensureNotReachHere(r158);     // Catch: Throwable -> L338
    L317:
        if (Result.m9455isFailureimpl(r157) == false) goto L320;
        r157 = null;
    L320:
        if ((r157 instanceof Integer) == true) goto L322;
        r157 = null;
    L322:
        r140 = (Integer) r157;     // Catch: Throwable -> L338
        if (r140 != null) goto L345;
        IHybridHostService r159 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L338
        if (r159 == null) goto L328;
        Object r160 = r159.getHostABValue("ec_shop_search_hint_gradient", r100);     // Catch: Throwable -> L338
    L329:
        if (r160 != null) goto L331;
    L344:
        r140 = r100;
        goto L345
    L331:
        if ((r160 instanceof Integer) == false) goto L334;
        r101 = r160;
    L334:
        Integer r161 = (Integer) r101;     // Catch: Throwable -> L338
        if (r161 == null) goto L344;
        r140 = r161;
        goto L345
    L338:
        th = move-exception;
        Result.Companion r162 = Result.Companion;     // Catch: Throwable -> L347
        r140 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L347
        Throwable r163 = Result.m9452exceptionOrNullimpl(r140);     // Catch: Throwable -> L347
        if (r163 == null) goto L343;
        EnsureManager.ensureNotReachHere(r163);     // Catch: Throwable -> L347
    L343:
        if (Result.m9455isFailureimpl(r140) == false) goto L345;
    L328:
        r160 = null;
    L345:
        d.d("ec_shop_search_hint_gradient", r140);     // Catch: Throwable -> L347
        goto L354
    L266:
        if ((r155 instanceof Integer) == true) goto L268;
        Object r164 = null;
    L269:
        r156 = (Integer) r164;     // Catch: Throwable -> L311
        if (r156 != null) goto L309;
        if ((r155 instanceof Number) == false) goto L296;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L281;
        Float r165 = Float.valueOf(((Number) r155).floatValue());     // Catch: Throwable -> L311
        if ((r165 instanceof Integer) == true) goto L279;
        r165 = null;
    L279:
        r156 = (Integer) r165;     // Catch: Throwable -> L311
        goto L309
    L281:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L287;
        Double r166 = Double.valueOf(((Number) r155).doubleValue());     // Catch: Throwable -> L311
        if ((r166 instanceof Integer) == true) goto L285;
        r166 = null;
    L285:
        r156 = (Integer) r166;     // Catch: Throwable -> L311
        goto L309
    L287:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L290;
        r156 = Integer.valueOf(((Number) r155).intValue());     // Catch: Throwable -> L311
        goto L309
    L290:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L296;
        Long r167 = Long.valueOf(((Number) r155).longValue());     // Catch: Throwable -> L311
        if ((r167 instanceof Integer) == true) goto L294;
        r167 = null;
    L294:
        r156 = (Integer) r167;     // Catch: Throwable -> L311
    L296:
        if ((r155 instanceof JSONObject) == false) goto L298;
    L380:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L304
        Object r168 = SDKSettingsCacheManager.a().fromJson(r155.toString(), Integer.class);     // Catch: Throwable -> L304
        if ((r168 instanceof Integer) == true) goto L302;
        r168 = null;
    L302:
        Object r169 = Result.m9449constructorimpl((Integer) r168);     // Catch: Throwable -> L304
    L306:
        r156 = r169;
        if (Result.m9455isFailureimpl(r156) == false) goto L309;
    L304:
        th = move-exception;
        Result.Companion r170 = Result.Companion;     // Catch: Throwable -> L311
        r169 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L311
        goto L306
    L298:
        if ((r155 instanceof JSONArray) == false) goto L308;
    L268:
        r164 = r155;
    L311:
        th = move-exception;
        Result.Companion r171 = Result.Companion;     // Catch: Throwable -> L338
        r157 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L338
        goto L313
    L196:
        if ((r149 instanceof Integer) == true) goto L198;
        Object r172 = null;
    L199:
        r150 = (Integer) r172;     // Catch: Throwable -> L241
        if (r150 != null) goto L239;
        if ((r149 instanceof Number) == false) goto L226;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L211;
        Float r173 = Float.valueOf(((Number) r149).floatValue());     // Catch: Throwable -> L241
        if ((r173 instanceof Integer) == true) goto L209;
        r173 = null;
    L209:
        r150 = (Integer) r173;     // Catch: Throwable -> L241
        goto L239
    L211:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L217;
        Double r174 = Double.valueOf(((Number) r149).doubleValue());     // Catch: Throwable -> L241
        if ((r174 instanceof Integer) == true) goto L215;
        r174 = null;
    L215:
        r150 = (Integer) r174;     // Catch: Throwable -> L241
        goto L239
    L217:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L220;
        r150 = Integer.valueOf(((Number) r149).intValue());     // Catch: Throwable -> L241
        goto L239
    L220:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L226;
        Long r175 = Long.valueOf(((Number) r149).longValue());     // Catch: Throwable -> L241
        if ((r175 instanceof Integer) == true) goto L224;
        r175 = null;
    L224:
        r150 = (Integer) r175;     // Catch: Throwable -> L241
    L226:
        if ((r149 instanceof JSONObject) == false) goto L228;
    L378:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L234
        Object r176 = SDKSettingsCacheManager.a().fromJson(r149.toString(), Integer.class);     // Catch: Throwable -> L234
        if ((r176 instanceof Integer) == true) goto L232;
        r176 = null;
    L232:
        Object r177 = Result.m9449constructorimpl((Integer) r176);     // Catch: Throwable -> L234
    L236:
        r150 = r177;
        if (Result.m9455isFailureimpl(r150) == false) goto L239;
    L234:
        th = move-exception;
        Result.Companion r178 = Result.Companion;     // Catch: Throwable -> L241
        r177 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L241
        goto L236
    L228:
        if ((r149 instanceof JSONArray) == false) goto L238;
    L198:
        r172 = r149;
    L241:
        th = move-exception;
        Result.Companion r179 = Result.Companion;     // Catch: Throwable -> L347
        r151 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L347
    L347:
        th = move-exception;
        Result.Companion r180 = Result.Companion;
        r145 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r181 = Result.m9452exceptionOrNullimpl(r145);
        if (r181 == null) goto L352;
        EnsureManager.ensureNotReachHere(r181);
    L352:
        if (Result.m9455isFailureimpl(r145) == false) goto L189;
        goto L189
    }

    @HostExperimentKey(author = "qiuhongwei.hiro", desc = "搜索底纹词轮播")
    @SettingReport
    public static final int getEC_SHOP_SEARCH_HOT_WORD_SCROLL() {
        Object r100 = 0;
        Object r101 = null;
        if (Intrinsics.areEqual("ec_shop_search_placeholder_upgrade", "ec_shop_launch_opt_common_2") == false) goto L179;
        if (f186139b != null) goto L173;
        int r102 = n.f45241a;
        int r103 = com.bytedance.android.ec.base.settings.a.f42813a;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L163
        Object r105 = d.f42818c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L57
        if (r105 != null) goto L12;
    L54:
        Object r106 = null;
    L55:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L57
    L59:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);     // Catch: Throwable -> L163
        if (r108 == null) goto L63;
        EnsureManager.ensureNotReachHere(r108);     // Catch: Throwable -> L163
    L63:
        if (Result.m9455isFailureimpl(r107) == false) goto L66;
        r107 = null;
    L66:
        if ((r107 instanceof Integer) == true) goto L68;
        r107 = null;
    L68:
        Object r109 = (Integer) r107;     // Catch: Throwable -> L163
        if (r109 != null) goto L75;
        Object r110 = d.f42816a.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L163
        if ((r110 instanceof Integer) == true) goto L74;
        r110 = null;
    L74:
        r109 = (Integer) r110;     // Catch: Throwable -> L163
    L75:
        if (r109 != null) goto L172;
        int r111 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L163
        Object r112 = d.f42818c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L127
        if (r112 != null) goto L82;
    L124:
        Object r113 = null;
    L125:
        Object r114 = Result.m9449constructorimpl(r113);     // Catch: Throwable -> L127
    L129:
        Throwable r115 = Result.m9452exceptionOrNullimpl(r114);     // Catch: Throwable -> L154
        if (r115 == null) goto L133;
        EnsureManager.ensureNotReachHere(r115);     // Catch: Throwable -> L154
    L133:
        if (Result.m9455isFailureimpl(r114) == false) goto L136;
        r114 = null;
    L136:
        if ((r114 instanceof Integer) == true) goto L138;
        r114 = null;
    L138:
        r109 = (Integer) r114;     // Catch: Throwable -> L154
        if (r109 != null) goto L161;
        IHybridHostService r116 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L154
        if (r116 == null) goto L144;
        Object r117 = r116.getHostABValue("ec_shop_launch_opt_common_2", r100);     // Catch: Throwable -> L154
    L145:
        if (r117 != null) goto L147;
    L160:
        r109 = r100;
        goto L161
    L147:
        if ((r117 instanceof Integer) == false) goto L150;
        r101 = r117;
    L150:
        Integer r118 = (Integer) r101;     // Catch: Throwable -> L154
        if (r118 == null) goto L160;
        r109 = r118;
        goto L161
    L154:
        th = move-exception;
        Result.Companion r119 = Result.Companion;     // Catch: Throwable -> L163
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
        Throwable r120 = Result.m9452exceptionOrNullimpl(r109);     // Catch: Throwable -> L163
        if (r120 == null) goto L159;
        EnsureManager.ensureNotReachHere(r120);     // Catch: Throwable -> L163
    L159:
        if (Result.m9455isFailureimpl(r109) == false) goto L161;
    L144:
        r117 = null;
    L161:
        d.d("ec_shop_launch_opt_common_2", r109);     // Catch: Throwable -> L163
        goto L172
    L82:
        if ((r112 instanceof Integer) == true) goto L84;
        Object r121 = null;
    L85:
        r113 = (Integer) r121;     // Catch: Throwable -> L127
        if (r113 != null) goto L125;
        if ((r112 instanceof Number) == false) goto L112;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r122 = Float.valueOf(((Number) r112).floatValue());     // Catch: Throwable -> L127
        if ((r122 instanceof Integer) == true) goto L95;
        r122 = null;
    L95:
        r113 = (Integer) r122;     // Catch: Throwable -> L127
        goto L125
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r123 = Double.valueOf(((Number) r112).doubleValue());     // Catch: Throwable -> L127
        if ((r123 instanceof Integer) == true) goto L101;
        r123 = null;
    L101:
        r113 = (Integer) r123;     // Catch: Throwable -> L127
        goto L125
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L106;
        r113 = Integer.valueOf(((Number) r112).intValue());     // Catch: Throwable -> L127
        goto L125
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L112;
        Long r124 = Long.valueOf(((Number) r112).longValue());     // Catch: Throwable -> L127
        if ((r124 instanceof Integer) == true) goto L110;
        r124 = null;
    L110:
        r113 = (Integer) r124;     // Catch: Throwable -> L127
    L112:
        if ((r112 instanceof JSONObject) == false) goto L114;
    L366:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L120
        Object r125 = SDKSettingsCacheManager.a().fromJson(r112.toString(), Integer.class);     // Catch: Throwable -> L120
        if ((r125 instanceof Integer) == true) goto L118;
        r125 = null;
    L118:
        Object r126 = Result.m9449constructorimpl((Integer) r125);     // Catch: Throwable -> L120
    L122:
        r113 = r126;
        if (Result.m9455isFailureimpl(r113) == false) goto L125;
    L120:
        th = move-exception;
        Result.Companion r127 = Result.Companion;     // Catch: Throwable -> L127
        r126 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L127
        goto L122
    L114:
        if ((r112 instanceof JSONArray) == false) goto L124;
    L84:
        r121 = r112;
    L127:
        th = move-exception;
        Result.Companion r128 = Result.Companion;     // Catch: Throwable -> L154
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L154
    L172:
        f186139b = (Integer) r109;
        goto L173
    L12:
        if ((r105 instanceof Integer) == true) goto L14;
        Object r129 = null;
    L15:
        r106 = (Integer) r129;     // Catch: Throwable -> L57
        if (r106 != null) goto L55;
        if ((r105 instanceof Number) == false) goto L42;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L27;
        Float r130 = Float.valueOf(((Number) r105).floatValue());     // Catch: Throwable -> L57
        if ((r130 instanceof Integer) == true) goto L25;
        r130 = null;
    L25:
        r106 = (Integer) r130;     // Catch: Throwable -> L57
        goto L55
    L27:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L33;
        Double r131 = Double.valueOf(((Number) r105).doubleValue());     // Catch: Throwable -> L57
        if ((r131 instanceof Integer) == true) goto L31;
        r131 = null;
    L31:
        r106 = (Integer) r131;     // Catch: Throwable -> L57
        goto L55
    L33:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L36;
        r106 = Integer.valueOf(((Number) r105).intValue());     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L42;
        Long r132 = Long.valueOf(((Number) r105).longValue());     // Catch: Throwable -> L57
        if ((r132 instanceof Integer) == true) goto L40;
        r132 = null;
    L40:
        r106 = (Integer) r132;     // Catch: Throwable -> L57
    L42:
        if ((r105 instanceof JSONObject) == false) goto L44;
    L364:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L50
        Object r133 = SDKSettingsCacheManager.a().fromJson(r105.toString(), Integer.class);     // Catch: Throwable -> L50
        if ((r133 instanceof Integer) == true) goto L48;
        r133 = null;
    L48:
        Object r134 = Result.m9449constructorimpl((Integer) r133);     // Catch: Throwable -> L50
    L52:
        r106 = r134;
        if (Result.m9455isFailureimpl(r106) == false) goto L55;
    L50:
        th = move-exception;
        Result.Companion r135 = Result.Companion;     // Catch: Throwable -> L57
        r134 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L52
    L44:
        if ((r105 instanceof JSONArray) == false) goto L54;
    L14:
        r129 = r105;
    L57:
        th = move-exception;
        Result.Companion r136 = Result.Companion;     // Catch: Throwable -> L163
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
    L163:
        th = move-exception;
        Result.Companion r137 = Result.Companion;
        Object r138 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r139 = Result.m9452exceptionOrNullimpl(r138);
        if (r139 == null) goto L168;
        EnsureManager.ensureNotReachHere(r139);
    L168:
        if (Result.m9455isFailureimpl(r138) == true) goto L171;
        r100 = r138;
    L171:
        r109 = r100;
    L173:
        Object r140 = f186139b;
        if (r140 == null) goto L177;
    L354:
        f186138a.put("ec_shop_search_placeholder_upgrade", r140);
        return ((Number) r140).intValue();
    L177:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L179:
        if (Intrinsics.areEqual("HostExperiment", "ShopSetting") == false) goto L190;
        int r141 = p.f45243a;
        Result.Companion r142 = Result.Companion;     // Catch: Throwable -> L185
        jj4.b r143 = jj4.b.f499326b;     // Catch: Throwable -> L185
        r140 = jj4.a.a("ec_shop_search_placeholder_upgrade", Integer.class, r100, false);     // Catch: Throwable -> L185
        if (r140 != null) goto L354;
        Intrinsics.throwNpe();     // Catch: Throwable -> L185
    L185:
        th = move-exception;
        Result.Companion r144 = Result.Companion;
        Object r145 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r145) == true) goto L353;
    L189:
        r100 = r145;
    L353:
        r140 = r100;
        goto L354
    L190:
        int r146 = n.f45241a;
        int r147 = com.bytedance.android.ec.base.settings.a.f42813a;
        Result.Companion r148 = Result.Companion;     // Catch: Throwable -> L347
        Object r149 = d.f42818c.get("ec_shop_search_placeholder_upgrade");     // Catch: Throwable -> L241
        if (r149 != null) goto L196;
    L238:
        Object r150 = null;
    L239:
        Object r151 = Result.m9449constructorimpl(r150);     // Catch: Throwable -> L241
    L243:
        Throwable r152 = Result.m9452exceptionOrNullimpl(r151);     // Catch: Throwable -> L347
        if (r152 == null) goto L247;
        EnsureManager.ensureNotReachHere(r152);     // Catch: Throwable -> L347
    L247:
        if (Result.m9455isFailureimpl(r151) == false) goto L250;
        r151 = null;
    L250:
        if ((r151 instanceof Integer) == true) goto L252;
        r151 = null;
    L252:
        r140 = (Integer) r151;     // Catch: Throwable -> L347
        if (r140 != null) goto L259;
        Object r153 = d.f42816a.get("ec_shop_search_placeholder_upgrade");     // Catch: Throwable -> L347
        if ((r153 instanceof Integer) == true) goto L258;
        r153 = null;
    L258:
        r140 = (Integer) r153;     // Catch: Throwable -> L347
    L259:
        if (r140 != null) goto L354;
        int r154 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L347
        Object r155 = d.f42818c.get("ec_shop_search_placeholder_upgrade");     // Catch: Throwable -> L311
        if (r155 != null) goto L266;
    L308:
        Object r156 = null;
    L309:
        Object r157 = Result.m9449constructorimpl(r156);     // Catch: Throwable -> L311
    L313:
        Throwable r158 = Result.m9452exceptionOrNullimpl(r157);     // Catch: Throwable -> L338
        if (r158 == null) goto L317;
        EnsureManager.ensureNotReachHere(r158);     // Catch: Throwable -> L338
    L317:
        if (Result.m9455isFailureimpl(r157) == false) goto L320;
        r157 = null;
    L320:
        if ((r157 instanceof Integer) == true) goto L322;
        r157 = null;
    L322:
        r140 = (Integer) r157;     // Catch: Throwable -> L338
        if (r140 != null) goto L345;
        IHybridHostService r159 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L338
        if (r159 == null) goto L328;
        Object r160 = r159.getHostABValue("ec_shop_search_placeholder_upgrade", r100);     // Catch: Throwable -> L338
    L329:
        if (r160 != null) goto L331;
    L344:
        r140 = r100;
        goto L345
    L331:
        if ((r160 instanceof Integer) == false) goto L334;
        r101 = r160;
    L334:
        Integer r161 = (Integer) r101;     // Catch: Throwable -> L338
        if (r161 == null) goto L344;
        r140 = r161;
        goto L345
    L338:
        th = move-exception;
        Result.Companion r162 = Result.Companion;     // Catch: Throwable -> L347
        r140 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L347
        Throwable r163 = Result.m9452exceptionOrNullimpl(r140);     // Catch: Throwable -> L347
        if (r163 == null) goto L343;
        EnsureManager.ensureNotReachHere(r163);     // Catch: Throwable -> L347
    L343:
        if (Result.m9455isFailureimpl(r140) == false) goto L345;
    L328:
        r160 = null;
    L345:
        d.d("ec_shop_search_placeholder_upgrade", r140);     // Catch: Throwable -> L347
        goto L354
    L266:
        if ((r155 instanceof Integer) == true) goto L268;
        Object r164 = null;
    L269:
        r156 = (Integer) r164;     // Catch: Throwable -> L311
        if (r156 != null) goto L309;
        if ((r155 instanceof Number) == false) goto L296;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L281;
        Float r165 = Float.valueOf(((Number) r155).floatValue());     // Catch: Throwable -> L311
        if ((r165 instanceof Integer) == true) goto L279;
        r165 = null;
    L279:
        r156 = (Integer) r165;     // Catch: Throwable -> L311
        goto L309
    L281:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L287;
        Double r166 = Double.valueOf(((Number) r155).doubleValue());     // Catch: Throwable -> L311
        if ((r166 instanceof Integer) == true) goto L285;
        r166 = null;
    L285:
        r156 = (Integer) r166;     // Catch: Throwable -> L311
        goto L309
    L287:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L290;
        r156 = Integer.valueOf(((Number) r155).intValue());     // Catch: Throwable -> L311
        goto L309
    L290:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L296;
        Long r167 = Long.valueOf(((Number) r155).longValue());     // Catch: Throwable -> L311
        if ((r167 instanceof Integer) == true) goto L294;
        r167 = null;
    L294:
        r156 = (Integer) r167;     // Catch: Throwable -> L311
    L296:
        if ((r155 instanceof JSONObject) == false) goto L298;
    L380:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L304
        Object r168 = SDKSettingsCacheManager.a().fromJson(r155.toString(), Integer.class);     // Catch: Throwable -> L304
        if ((r168 instanceof Integer) == true) goto L302;
        r168 = null;
    L302:
        Object r169 = Result.m9449constructorimpl((Integer) r168);     // Catch: Throwable -> L304
    L306:
        r156 = r169;
        if (Result.m9455isFailureimpl(r156) == false) goto L309;
    L304:
        th = move-exception;
        Result.Companion r170 = Result.Companion;     // Catch: Throwable -> L311
        r169 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L311
        goto L306
    L298:
        if ((r155 instanceof JSONArray) == false) goto L308;
    L268:
        r164 = r155;
    L311:
        th = move-exception;
        Result.Companion r171 = Result.Companion;     // Catch: Throwable -> L338
        r157 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L338
        goto L313
    L196:
        if ((r149 instanceof Integer) == true) goto L198;
        Object r172 = null;
    L199:
        r150 = (Integer) r172;     // Catch: Throwable -> L241
        if (r150 != null) goto L239;
        if ((r149 instanceof Number) == false) goto L226;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L211;
        Float r173 = Float.valueOf(((Number) r149).floatValue());     // Catch: Throwable -> L241
        if ((r173 instanceof Integer) == true) goto L209;
        r173 = null;
    L209:
        r150 = (Integer) r173;     // Catch: Throwable -> L241
        goto L239
    L211:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L217;
        Double r174 = Double.valueOf(((Number) r149).doubleValue());     // Catch: Throwable -> L241
        if ((r174 instanceof Integer) == true) goto L215;
        r174 = null;
    L215:
        r150 = (Integer) r174;     // Catch: Throwable -> L241
        goto L239
    L217:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L220;
        r150 = Integer.valueOf(((Number) r149).intValue());     // Catch: Throwable -> L241
        goto L239
    L220:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L226;
        Long r175 = Long.valueOf(((Number) r149).longValue());     // Catch: Throwable -> L241
        if ((r175 instanceof Integer) == true) goto L224;
        r175 = null;
    L224:
        r150 = (Integer) r175;     // Catch: Throwable -> L241
    L226:
        if ((r149 instanceof JSONObject) == false) goto L228;
    L378:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L234
        Object r176 = SDKSettingsCacheManager.a().fromJson(r149.toString(), Integer.class);     // Catch: Throwable -> L234
        if ((r176 instanceof Integer) == true) goto L232;
        r176 = null;
    L232:
        Object r177 = Result.m9449constructorimpl((Integer) r176);     // Catch: Throwable -> L234
    L236:
        r150 = r177;
        if (Result.m9455isFailureimpl(r150) == false) goto L239;
    L234:
        th = move-exception;
        Result.Companion r178 = Result.Companion;     // Catch: Throwable -> L241
        r177 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L241
        goto L236
    L228:
        if ((r149 instanceof JSONArray) == false) goto L238;
    L198:
        r172 = r149;
    L241:
        th = move-exception;
        Result.Companion r179 = Result.Companion;     // Catch: Throwable -> L347
        r151 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L347
    L347:
        th = move-exception;
        Result.Companion r180 = Result.Companion;
        r145 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r181 = Result.m9452exceptionOrNullimpl(r145);
        if (r181 == null) goto L352;
        EnsureManager.ensureNotReachHere(r181);
    L352:
        if (Result.m9455isFailureimpl(r145) == false) goto L189;
        goto L189
    }

    @HostExperimentKey(author = "chenlong.hz", desc = "店铺商卡埋点迭代优化")
    @SettingReport
    public static final int getEC_SHOP_SELL_POINT_OPTIMIZE() {
        Object r100 = 0;
        Object r101 = null;
        if (Intrinsics.areEqual("shop_product_sell_point_type", "ec_shop_launch_opt_common_2") == false) goto L179;
        if (f186139b != null) goto L173;
        int r102 = n.f45241a;
        int r103 = com.bytedance.android.ec.base.settings.a.f42813a;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L163
        Object r105 = d.f42818c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L57
        if (r105 != null) goto L12;
    L54:
        Object r106 = null;
    L55:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L57
    L59:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);     // Catch: Throwable -> L163
        if (r108 == null) goto L63;
        EnsureManager.ensureNotReachHere(r108);     // Catch: Throwable -> L163
    L63:
        if (Result.m9455isFailureimpl(r107) == false) goto L66;
        r107 = null;
    L66:
        if ((r107 instanceof Integer) == true) goto L68;
        r107 = null;
    L68:
        Object r109 = (Integer) r107;     // Catch: Throwable -> L163
        if (r109 != null) goto L75;
        Object r110 = d.f42816a.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L163
        if ((r110 instanceof Integer) == true) goto L74;
        r110 = null;
    L74:
        r109 = (Integer) r110;     // Catch: Throwable -> L163
    L75:
        if (r109 != null) goto L172;
        int r111 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L163
        Object r112 = d.f42818c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L127
        if (r112 != null) goto L82;
    L124:
        Object r113 = null;
    L125:
        Object r114 = Result.m9449constructorimpl(r113);     // Catch: Throwable -> L127
    L129:
        Throwable r115 = Result.m9452exceptionOrNullimpl(r114);     // Catch: Throwable -> L154
        if (r115 == null) goto L133;
        EnsureManager.ensureNotReachHere(r115);     // Catch: Throwable -> L154
    L133:
        if (Result.m9455isFailureimpl(r114) == false) goto L136;
        r114 = null;
    L136:
        if ((r114 instanceof Integer) == true) goto L138;
        r114 = null;
    L138:
        r109 = (Integer) r114;     // Catch: Throwable -> L154
        if (r109 != null) goto L161;
        IHybridHostService r116 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L154
        if (r116 == null) goto L144;
        Object r117 = r116.getHostABValue("ec_shop_launch_opt_common_2", r100);     // Catch: Throwable -> L154
    L145:
        if (r117 != null) goto L147;
    L160:
        r109 = r100;
        goto L161
    L147:
        if ((r117 instanceof Integer) == false) goto L150;
        r101 = r117;
    L150:
        Integer r118 = (Integer) r101;     // Catch: Throwable -> L154
        if (r118 == null) goto L160;
        r109 = r118;
        goto L161
    L154:
        th = move-exception;
        Result.Companion r119 = Result.Companion;     // Catch: Throwable -> L163
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
        Throwable r120 = Result.m9452exceptionOrNullimpl(r109);     // Catch: Throwable -> L163
        if (r120 == null) goto L159;
        EnsureManager.ensureNotReachHere(r120);     // Catch: Throwable -> L163
    L159:
        if (Result.m9455isFailureimpl(r109) == false) goto L161;
    L144:
        r117 = null;
    L161:
        d.d("ec_shop_launch_opt_common_2", r109);     // Catch: Throwable -> L163
        goto L172
    L82:
        if ((r112 instanceof Integer) == true) goto L84;
        Object r121 = null;
    L85:
        r113 = (Integer) r121;     // Catch: Throwable -> L127
        if (r113 != null) goto L125;
        if ((r112 instanceof Number) == false) goto L112;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r122 = Float.valueOf(((Number) r112).floatValue());     // Catch: Throwable -> L127
        if ((r122 instanceof Integer) == true) goto L95;
        r122 = null;
    L95:
        r113 = (Integer) r122;     // Catch: Throwable -> L127
        goto L125
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r123 = Double.valueOf(((Number) r112).doubleValue());     // Catch: Throwable -> L127
        if ((r123 instanceof Integer) == true) goto L101;
        r123 = null;
    L101:
        r113 = (Integer) r123;     // Catch: Throwable -> L127
        goto L125
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L106;
        r113 = Integer.valueOf(((Number) r112).intValue());     // Catch: Throwable -> L127
        goto L125
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L112;
        Long r124 = Long.valueOf(((Number) r112).longValue());     // Catch: Throwable -> L127
        if ((r124 instanceof Integer) == true) goto L110;
        r124 = null;
    L110:
        r113 = (Integer) r124;     // Catch: Throwable -> L127
    L112:
        if ((r112 instanceof JSONObject) == false) goto L114;
    L366:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L120
        Object r125 = SDKSettingsCacheManager.a().fromJson(r112.toString(), Integer.class);     // Catch: Throwable -> L120
        if ((r125 instanceof Integer) == true) goto L118;
        r125 = null;
    L118:
        Object r126 = Result.m9449constructorimpl((Integer) r125);     // Catch: Throwable -> L120
    L122:
        r113 = r126;
        if (Result.m9455isFailureimpl(r113) == false) goto L125;
    L120:
        th = move-exception;
        Result.Companion r127 = Result.Companion;     // Catch: Throwable -> L127
        r126 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L127
        goto L122
    L114:
        if ((r112 instanceof JSONArray) == false) goto L124;
    L84:
        r121 = r112;
    L127:
        th = move-exception;
        Result.Companion r128 = Result.Companion;     // Catch: Throwable -> L154
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L154
    L172:
        f186139b = (Integer) r109;
        goto L173
    L12:
        if ((r105 instanceof Integer) == true) goto L14;
        Object r129 = null;
    L15:
        r106 = (Integer) r129;     // Catch: Throwable -> L57
        if (r106 != null) goto L55;
        if ((r105 instanceof Number) == false) goto L42;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L27;
        Float r130 = Float.valueOf(((Number) r105).floatValue());     // Catch: Throwable -> L57
        if ((r130 instanceof Integer) == true) goto L25;
        r130 = null;
    L25:
        r106 = (Integer) r130;     // Catch: Throwable -> L57
        goto L55
    L27:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L33;
        Double r131 = Double.valueOf(((Number) r105).doubleValue());     // Catch: Throwable -> L57
        if ((r131 instanceof Integer) == true) goto L31;
        r131 = null;
    L31:
        r106 = (Integer) r131;     // Catch: Throwable -> L57
        goto L55
    L33:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L36;
        r106 = Integer.valueOf(((Number) r105).intValue());     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L42;
        Long r132 = Long.valueOf(((Number) r105).longValue());     // Catch: Throwable -> L57
        if ((r132 instanceof Integer) == true) goto L40;
        r132 = null;
    L40:
        r106 = (Integer) r132;     // Catch: Throwable -> L57
    L42:
        if ((r105 instanceof JSONObject) == false) goto L44;
    L364:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L50
        Object r133 = SDKSettingsCacheManager.a().fromJson(r105.toString(), Integer.class);     // Catch: Throwable -> L50
        if ((r133 instanceof Integer) == true) goto L48;
        r133 = null;
    L48:
        Object r134 = Result.m9449constructorimpl((Integer) r133);     // Catch: Throwable -> L50
    L52:
        r106 = r134;
        if (Result.m9455isFailureimpl(r106) == false) goto L55;
    L50:
        th = move-exception;
        Result.Companion r135 = Result.Companion;     // Catch: Throwable -> L57
        r134 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L52
    L44:
        if ((r105 instanceof JSONArray) == false) goto L54;
    L14:
        r129 = r105;
    L57:
        th = move-exception;
        Result.Companion r136 = Result.Companion;     // Catch: Throwable -> L163
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
    L163:
        th = move-exception;
        Result.Companion r137 = Result.Companion;
        Object r138 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r139 = Result.m9452exceptionOrNullimpl(r138);
        if (r139 == null) goto L168;
        EnsureManager.ensureNotReachHere(r139);
    L168:
        if (Result.m9455isFailureimpl(r138) == true) goto L171;
        r100 = r138;
    L171:
        r109 = r100;
    L173:
        Object r140 = f186139b;
        if (r140 == null) goto L177;
    L354:
        f186138a.put("shop_product_sell_point_type", r140);
        return ((Number) r140).intValue();
    L177:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L179:
        if (Intrinsics.areEqual("HostExperiment", "ShopSetting") == false) goto L190;
        int r141 = p.f45243a;
        Result.Companion r142 = Result.Companion;     // Catch: Throwable -> L185
        jj4.b r143 = jj4.b.f499326b;     // Catch: Throwable -> L185
        r140 = jj4.a.a("shop_product_sell_point_type", Integer.class, r100, false);     // Catch: Throwable -> L185
        if (r140 != null) goto L354;
        Intrinsics.throwNpe();     // Catch: Throwable -> L185
    L185:
        th = move-exception;
        Result.Companion r144 = Result.Companion;
        Object r145 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r145) == true) goto L353;
    L189:
        r100 = r145;
    L353:
        r140 = r100;
        goto L354
    L190:
        int r146 = n.f45241a;
        int r147 = com.bytedance.android.ec.base.settings.a.f42813a;
        Result.Companion r148 = Result.Companion;     // Catch: Throwable -> L347
        Object r149 = d.f42818c.get("shop_product_sell_point_type");     // Catch: Throwable -> L241
        if (r149 != null) goto L196;
    L238:
        Object r150 = null;
    L239:
        Object r151 = Result.m9449constructorimpl(r150);     // Catch: Throwable -> L241
    L243:
        Throwable r152 = Result.m9452exceptionOrNullimpl(r151);     // Catch: Throwable -> L347
        if (r152 == null) goto L247;
        EnsureManager.ensureNotReachHere(r152);     // Catch: Throwable -> L347
    L247:
        if (Result.m9455isFailureimpl(r151) == false) goto L250;
        r151 = null;
    L250:
        if ((r151 instanceof Integer) == true) goto L252;
        r151 = null;
    L252:
        r140 = (Integer) r151;     // Catch: Throwable -> L347
        if (r140 != null) goto L259;
        Object r153 = d.f42816a.get("shop_product_sell_point_type");     // Catch: Throwable -> L347
        if ((r153 instanceof Integer) == true) goto L258;
        r153 = null;
    L258:
        r140 = (Integer) r153;     // Catch: Throwable -> L347
    L259:
        if (r140 != null) goto L354;
        int r154 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L347
        Object r155 = d.f42818c.get("shop_product_sell_point_type");     // Catch: Throwable -> L311
        if (r155 != null) goto L266;
    L308:
        Object r156 = null;
    L309:
        Object r157 = Result.m9449constructorimpl(r156);     // Catch: Throwable -> L311
    L313:
        Throwable r158 = Result.m9452exceptionOrNullimpl(r157);     // Catch: Throwable -> L338
        if (r158 == null) goto L317;
        EnsureManager.ensureNotReachHere(r158);     // Catch: Throwable -> L338
    L317:
        if (Result.m9455isFailureimpl(r157) == false) goto L320;
        r157 = null;
    L320:
        if ((r157 instanceof Integer) == true) goto L322;
        r157 = null;
    L322:
        r140 = (Integer) r157;     // Catch: Throwable -> L338
        if (r140 != null) goto L345;
        IHybridHostService r159 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L338
        if (r159 == null) goto L328;
        Object r160 = r159.getHostABValue("shop_product_sell_point_type", r100);     // Catch: Throwable -> L338
    L329:
        if (r160 != null) goto L331;
    L344:
        r140 = r100;
        goto L345
    L331:
        if ((r160 instanceof Integer) == false) goto L334;
        r101 = r160;
    L334:
        Integer r161 = (Integer) r101;     // Catch: Throwable -> L338
        if (r161 == null) goto L344;
        r140 = r161;
        goto L345
    L338:
        th = move-exception;
        Result.Companion r162 = Result.Companion;     // Catch: Throwable -> L347
        r140 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L347
        Throwable r163 = Result.m9452exceptionOrNullimpl(r140);     // Catch: Throwable -> L347
        if (r163 == null) goto L343;
        EnsureManager.ensureNotReachHere(r163);     // Catch: Throwable -> L347
    L343:
        if (Result.m9455isFailureimpl(r140) == false) goto L345;
    L328:
        r160 = null;
    L345:
        d.d("shop_product_sell_point_type", r140);     // Catch: Throwable -> L347
        goto L354
    L266:
        if ((r155 instanceof Integer) == true) goto L268;
        Object r164 = null;
    L269:
        r156 = (Integer) r164;     // Catch: Throwable -> L311
        if (r156 != null) goto L309;
        if ((r155 instanceof Number) == false) goto L296;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L281;
        Float r165 = Float.valueOf(((Number) r155).floatValue());     // Catch: Throwable -> L311
        if ((r165 instanceof Integer) == true) goto L279;
        r165 = null;
    L279:
        r156 = (Integer) r165;     // Catch: Throwable -> L311
        goto L309
    L281:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L287;
        Double r166 = Double.valueOf(((Number) r155).doubleValue());     // Catch: Throwable -> L311
        if ((r166 instanceof Integer) == true) goto L285;
        r166 = null;
    L285:
        r156 = (Integer) r166;     // Catch: Throwable -> L311
        goto L309
    L287:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L290;
        r156 = Integer.valueOf(((Number) r155).intValue());     // Catch: Throwable -> L311
        goto L309
    L290:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L296;
        Long r167 = Long.valueOf(((Number) r155).longValue());     // Catch: Throwable -> L311
        if ((r167 instanceof Integer) == true) goto L294;
        r167 = null;
    L294:
        r156 = (Integer) r167;     // Catch: Throwable -> L311
    L296:
        if ((r155 instanceof JSONObject) == false) goto L298;
    L380:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L304
        Object r168 = SDKSettingsCacheManager.a().fromJson(r155.toString(), Integer.class);     // Catch: Throwable -> L304
        if ((r168 instanceof Integer) == true) goto L302;
        r168 = null;
    L302:
        Object r169 = Result.m9449constructorimpl((Integer) r168);     // Catch: Throwable -> L304
    L306:
        r156 = r169;
        if (Result.m9455isFailureimpl(r156) == false) goto L309;
    L304:
        th = move-exception;
        Result.Companion r170 = Result.Companion;     // Catch: Throwable -> L311
        r169 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L311
        goto L306
    L298:
        if ((r155 instanceof JSONArray) == false) goto L308;
    L268:
        r164 = r155;
    L311:
        th = move-exception;
        Result.Companion r171 = Result.Companion;     // Catch: Throwable -> L338
        r157 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L338
        goto L313
    L196:
        if ((r149 instanceof Integer) == true) goto L198;
        Object r172 = null;
    L199:
        r150 = (Integer) r172;     // Catch: Throwable -> L241
        if (r150 != null) goto L239;
        if ((r149 instanceof Number) == false) goto L226;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L211;
        Float r173 = Float.valueOf(((Number) r149).floatValue());     // Catch: Throwable -> L241
        if ((r173 instanceof Integer) == true) goto L209;
        r173 = null;
    L209:
        r150 = (Integer) r173;     // Catch: Throwable -> L241
        goto L239
    L211:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L217;
        Double r174 = Double.valueOf(((Number) r149).doubleValue());     // Catch: Throwable -> L241
        if ((r174 instanceof Integer) == true) goto L215;
        r174 = null;
    L215:
        r150 = (Integer) r174;     // Catch: Throwable -> L241
        goto L239
    L217:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L220;
        r150 = Integer.valueOf(((Number) r149).intValue());     // Catch: Throwable -> L241
        goto L239
    L220:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L226;
        Long r175 = Long.valueOf(((Number) r149).longValue());     // Catch: Throwable -> L241
        if ((r175 instanceof Integer) == true) goto L224;
        r175 = null;
    L224:
        r150 = (Integer) r175;     // Catch: Throwable -> L241
    L226:
        if ((r149 instanceof JSONObject) == false) goto L228;
    L378:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L234
        Object r176 = SDKSettingsCacheManager.a().fromJson(r149.toString(), Integer.class);     // Catch: Throwable -> L234
        if ((r176 instanceof Integer) == true) goto L232;
        r176 = null;
    L232:
        Object r177 = Result.m9449constructorimpl((Integer) r176);     // Catch: Throwable -> L234
    L236:
        r150 = r177;
        if (Result.m9455isFailureimpl(r150) == false) goto L239;
    L234:
        th = move-exception;
        Result.Companion r178 = Result.Companion;     // Catch: Throwable -> L241
        r177 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L241
        goto L236
    L228:
        if ((r149 instanceof JSONArray) == false) goto L238;
    L198:
        r172 = r149;
    L241:
        th = move-exception;
        Result.Companion r179 = Result.Companion;     // Catch: Throwable -> L347
        r151 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L347
    L347:
        th = move-exception;
        Result.Companion r180 = Result.Companion;
        r145 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r181 = Result.m9452exceptionOrNullimpl(r145);
        if (r181 == null) goto L352;
        EnsureManager.ensureNotReachHere(r181);
    L352:
        if (Result.m9455isFailureimpl(r145) == false) goto L189;
        goto L189
    }

    @HostExperimentKey(author = "zhengsai.2022", desc = "店铺店招slice实验")
    @SettingReport
    public static final int getEC_SHOP_SLICE_HEADER() {
        Object r100 = 0;
        Object r101 = null;
        if (Intrinsics.areEqual("ec_shop_slice_profile_card", "ec_shop_launch_opt_common_2") == false) goto L179;
        if (f186139b != null) goto L173;
        int r102 = n.f45241a;
        int r103 = com.bytedance.android.ec.base.settings.a.f42813a;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L163
        Object r105 = d.f42818c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L57
        if (r105 != null) goto L12;
    L54:
        Object r106 = null;
    L55:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L57
    L59:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);     // Catch: Throwable -> L163
        if (r108 == null) goto L63;
        EnsureManager.ensureNotReachHere(r108);     // Catch: Throwable -> L163
    L63:
        if (Result.m9455isFailureimpl(r107) == false) goto L66;
        r107 = null;
    L66:
        if ((r107 instanceof Integer) == true) goto L68;
        r107 = null;
    L68:
        Object r109 = (Integer) r107;     // Catch: Throwable -> L163
        if (r109 != null) goto L75;
        Object r110 = d.f42816a.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L163
        if ((r110 instanceof Integer) == true) goto L74;
        r110 = null;
    L74:
        r109 = (Integer) r110;     // Catch: Throwable -> L163
    L75:
        if (r109 != null) goto L172;
        int r111 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L163
        Object r112 = d.f42818c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L127
        if (r112 != null) goto L82;
    L124:
        Object r113 = null;
    L125:
        Object r114 = Result.m9449constructorimpl(r113);     // Catch: Throwable -> L127
    L129:
        Throwable r115 = Result.m9452exceptionOrNullimpl(r114);     // Catch: Throwable -> L154
        if (r115 == null) goto L133;
        EnsureManager.ensureNotReachHere(r115);     // Catch: Throwable -> L154
    L133:
        if (Result.m9455isFailureimpl(r114) == false) goto L136;
        r114 = null;
    L136:
        if ((r114 instanceof Integer) == true) goto L138;
        r114 = null;
    L138:
        r109 = (Integer) r114;     // Catch: Throwable -> L154
        if (r109 != null) goto L161;
        IHybridHostService r116 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L154
        if (r116 == null) goto L144;
        Object r117 = r116.getHostABValue("ec_shop_launch_opt_common_2", r100);     // Catch: Throwable -> L154
    L145:
        if (r117 != null) goto L147;
    L160:
        r109 = r100;
        goto L161
    L147:
        if ((r117 instanceof Integer) == false) goto L150;
        r101 = r117;
    L150:
        Integer r118 = (Integer) r101;     // Catch: Throwable -> L154
        if (r118 == null) goto L160;
        r109 = r118;
        goto L161
    L154:
        th = move-exception;
        Result.Companion r119 = Result.Companion;     // Catch: Throwable -> L163
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
        Throwable r120 = Result.m9452exceptionOrNullimpl(r109);     // Catch: Throwable -> L163
        if (r120 == null) goto L159;
        EnsureManager.ensureNotReachHere(r120);     // Catch: Throwable -> L163
    L159:
        if (Result.m9455isFailureimpl(r109) == false) goto L161;
    L144:
        r117 = null;
    L161:
        d.d("ec_shop_launch_opt_common_2", r109);     // Catch: Throwable -> L163
        goto L172
    L82:
        if ((r112 instanceof Integer) == true) goto L84;
        Object r121 = null;
    L85:
        r113 = (Integer) r121;     // Catch: Throwable -> L127
        if (r113 != null) goto L125;
        if ((r112 instanceof Number) == false) goto L112;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r122 = Float.valueOf(((Number) r112).floatValue());     // Catch: Throwable -> L127
        if ((r122 instanceof Integer) == true) goto L95;
        r122 = null;
    L95:
        r113 = (Integer) r122;     // Catch: Throwable -> L127
        goto L125
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r123 = Double.valueOf(((Number) r112).doubleValue());     // Catch: Throwable -> L127
        if ((r123 instanceof Integer) == true) goto L101;
        r123 = null;
    L101:
        r113 = (Integer) r123;     // Catch: Throwable -> L127
        goto L125
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L106;
        r113 = Integer.valueOf(((Number) r112).intValue());     // Catch: Throwable -> L127
        goto L125
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L112;
        Long r124 = Long.valueOf(((Number) r112).longValue());     // Catch: Throwable -> L127
        if ((r124 instanceof Integer) == true) goto L110;
        r124 = null;
    L110:
        r113 = (Integer) r124;     // Catch: Throwable -> L127
    L112:
        if ((r112 instanceof JSONObject) == false) goto L114;
    L366:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L120
        Object r125 = SDKSettingsCacheManager.a().fromJson(r112.toString(), Integer.class);     // Catch: Throwable -> L120
        if ((r125 instanceof Integer) == true) goto L118;
        r125 = null;
    L118:
        Object r126 = Result.m9449constructorimpl((Integer) r125);     // Catch: Throwable -> L120
    L122:
        r113 = r126;
        if (Result.m9455isFailureimpl(r113) == false) goto L125;
    L120:
        th = move-exception;
        Result.Companion r127 = Result.Companion;     // Catch: Throwable -> L127
        r126 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L127
        goto L122
    L114:
        if ((r112 instanceof JSONArray) == false) goto L124;
    L84:
        r121 = r112;
    L127:
        th = move-exception;
        Result.Companion r128 = Result.Companion;     // Catch: Throwable -> L154
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L154
    L172:
        f186139b = (Integer) r109;
        goto L173
    L12:
        if ((r105 instanceof Integer) == true) goto L14;
        Object r129 = null;
    L15:
        r106 = (Integer) r129;     // Catch: Throwable -> L57
        if (r106 != null) goto L55;
        if ((r105 instanceof Number) == false) goto L42;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L27;
        Float r130 = Float.valueOf(((Number) r105).floatValue());     // Catch: Throwable -> L57
        if ((r130 instanceof Integer) == true) goto L25;
        r130 = null;
    L25:
        r106 = (Integer) r130;     // Catch: Throwable -> L57
        goto L55
    L27:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L33;
        Double r131 = Double.valueOf(((Number) r105).doubleValue());     // Catch: Throwable -> L57
        if ((r131 instanceof Integer) == true) goto L31;
        r131 = null;
    L31:
        r106 = (Integer) r131;     // Catch: Throwable -> L57
        goto L55
    L33:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L36;
        r106 = Integer.valueOf(((Number) r105).intValue());     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L42;
        Long r132 = Long.valueOf(((Number) r105).longValue());     // Catch: Throwable -> L57
        if ((r132 instanceof Integer) == true) goto L40;
        r132 = null;
    L40:
        r106 = (Integer) r132;     // Catch: Throwable -> L57
    L42:
        if ((r105 instanceof JSONObject) == false) goto L44;
    L364:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L50
        Object r133 = SDKSettingsCacheManager.a().fromJson(r105.toString(), Integer.class);     // Catch: Throwable -> L50
        if ((r133 instanceof Integer) == true) goto L48;
        r133 = null;
    L48:
        Object r134 = Result.m9449constructorimpl((Integer) r133);     // Catch: Throwable -> L50
    L52:
        r106 = r134;
        if (Result.m9455isFailureimpl(r106) == false) goto L55;
    L50:
        th = move-exception;
        Result.Companion r135 = Result.Companion;     // Catch: Throwable -> L57
        r134 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L52
    L44:
        if ((r105 instanceof JSONArray) == false) goto L54;
    L14:
        r129 = r105;
    L57:
        th = move-exception;
        Result.Companion r136 = Result.Companion;     // Catch: Throwable -> L163
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
    L163:
        th = move-exception;
        Result.Companion r137 = Result.Companion;
        Object r138 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r139 = Result.m9452exceptionOrNullimpl(r138);
        if (r139 == null) goto L168;
        EnsureManager.ensureNotReachHere(r139);
    L168:
        if (Result.m9455isFailureimpl(r138) == true) goto L171;
        r100 = r138;
    L171:
        r109 = r100;
    L173:
        Object r140 = f186139b;
        if (r140 == null) goto L177;
    L354:
        f186138a.put("ec_shop_slice_profile_card", r140);
        return ((Number) r140).intValue();
    L177:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L179:
        if (Intrinsics.areEqual("HostExperiment", "ShopSetting") == false) goto L190;
        int r141 = p.f45243a;
        Result.Companion r142 = Result.Companion;     // Catch: Throwable -> L185
        jj4.b r143 = jj4.b.f499326b;     // Catch: Throwable -> L185
        r140 = jj4.a.a("ec_shop_slice_profile_card", Integer.class, r100, false);     // Catch: Throwable -> L185
        if (r140 != null) goto L354;
        Intrinsics.throwNpe();     // Catch: Throwable -> L185
    L185:
        th = move-exception;
        Result.Companion r144 = Result.Companion;
        Object r145 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r145) == true) goto L353;
    L189:
        r100 = r145;
    L353:
        r140 = r100;
        goto L354
    L190:
        int r146 = n.f45241a;
        int r147 = com.bytedance.android.ec.base.settings.a.f42813a;
        Result.Companion r148 = Result.Companion;     // Catch: Throwable -> L347
        Object r149 = d.f42818c.get("ec_shop_slice_profile_card");     // Catch: Throwable -> L241
        if (r149 != null) goto L196;
    L238:
        Object r150 = null;
    L239:
        Object r151 = Result.m9449constructorimpl(r150);     // Catch: Throwable -> L241
    L243:
        Throwable r152 = Result.m9452exceptionOrNullimpl(r151);     // Catch: Throwable -> L347
        if (r152 == null) goto L247;
        EnsureManager.ensureNotReachHere(r152);     // Catch: Throwable -> L347
    L247:
        if (Result.m9455isFailureimpl(r151) == false) goto L250;
        r151 = null;
    L250:
        if ((r151 instanceof Integer) == true) goto L252;
        r151 = null;
    L252:
        r140 = (Integer) r151;     // Catch: Throwable -> L347
        if (r140 != null) goto L259;
        Object r153 = d.f42816a.get("ec_shop_slice_profile_card");     // Catch: Throwable -> L347
        if ((r153 instanceof Integer) == true) goto L258;
        r153 = null;
    L258:
        r140 = (Integer) r153;     // Catch: Throwable -> L347
    L259:
        if (r140 != null) goto L354;
        int r154 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L347
        Object r155 = d.f42818c.get("ec_shop_slice_profile_card");     // Catch: Throwable -> L311
        if (r155 != null) goto L266;
    L308:
        Object r156 = null;
    L309:
        Object r157 = Result.m9449constructorimpl(r156);     // Catch: Throwable -> L311
    L313:
        Throwable r158 = Result.m9452exceptionOrNullimpl(r157);     // Catch: Throwable -> L338
        if (r158 == null) goto L317;
        EnsureManager.ensureNotReachHere(r158);     // Catch: Throwable -> L338
    L317:
        if (Result.m9455isFailureimpl(r157) == false) goto L320;
        r157 = null;
    L320:
        if ((r157 instanceof Integer) == true) goto L322;
        r157 = null;
    L322:
        r140 = (Integer) r157;     // Catch: Throwable -> L338
        if (r140 != null) goto L345;
        IHybridHostService r159 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L338
        if (r159 == null) goto L328;
        Object r160 = r159.getHostABValue("ec_shop_slice_profile_card", r100);     // Catch: Throwable -> L338
    L329:
        if (r160 != null) goto L331;
    L344:
        r140 = r100;
        goto L345
    L331:
        if ((r160 instanceof Integer) == false) goto L334;
        r101 = r160;
    L334:
        Integer r161 = (Integer) r101;     // Catch: Throwable -> L338
        if (r161 == null) goto L344;
        r140 = r161;
        goto L345
    L338:
        th = move-exception;
        Result.Companion r162 = Result.Companion;     // Catch: Throwable -> L347
        r140 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L347
        Throwable r163 = Result.m9452exceptionOrNullimpl(r140);     // Catch: Throwable -> L347
        if (r163 == null) goto L343;
        EnsureManager.ensureNotReachHere(r163);     // Catch: Throwable -> L347
    L343:
        if (Result.m9455isFailureimpl(r140) == false) goto L345;
    L328:
        r160 = null;
    L345:
        d.d("ec_shop_slice_profile_card", r140);     // Catch: Throwable -> L347
        goto L354
    L266:
        if ((r155 instanceof Integer) == true) goto L268;
        Object r164 = null;
    L269:
        r156 = (Integer) r164;     // Catch: Throwable -> L311
        if (r156 != null) goto L309;
        if ((r155 instanceof Number) == false) goto L296;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L281;
        Float r165 = Float.valueOf(((Number) r155).floatValue());     // Catch: Throwable -> L311
        if ((r165 instanceof Integer) == true) goto L279;
        r165 = null;
    L279:
        r156 = (Integer) r165;     // Catch: Throwable -> L311
        goto L309
    L281:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L287;
        Double r166 = Double.valueOf(((Number) r155).doubleValue());     // Catch: Throwable -> L311
        if ((r166 instanceof Integer) == true) goto L285;
        r166 = null;
    L285:
        r156 = (Integer) r166;     // Catch: Throwable -> L311
        goto L309
    L287:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L290;
        r156 = Integer.valueOf(((Number) r155).intValue());     // Catch: Throwable -> L311
        goto L309
    L290:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L296;
        Long r167 = Long.valueOf(((Number) r155).longValue());     // Catch: Throwable -> L311
        if ((r167 instanceof Integer) == true) goto L294;
        r167 = null;
    L294:
        r156 = (Integer) r167;     // Catch: Throwable -> L311
    L296:
        if ((r155 instanceof JSONObject) == false) goto L298;
    L380:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L304
        Object r168 = SDKSettingsCacheManager.a().fromJson(r155.toString(), Integer.class);     // Catch: Throwable -> L304
        if ((r168 instanceof Integer) == true) goto L302;
        r168 = null;
    L302:
        Object r169 = Result.m9449constructorimpl((Integer) r168);     // Catch: Throwable -> L304
    L306:
        r156 = r169;
        if (Result.m9455isFailureimpl(r156) == false) goto L309;
    L304:
        th = move-exception;
        Result.Companion r170 = Result.Companion;     // Catch: Throwable -> L311
        r169 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L311
        goto L306
    L298:
        if ((r155 instanceof JSONArray) == false) goto L308;
    L268:
        r164 = r155;
    L311:
        th = move-exception;
        Result.Companion r171 = Result.Companion;     // Catch: Throwable -> L338
        r157 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L338
        goto L313
    L196:
        if ((r149 instanceof Integer) == true) goto L198;
        Object r172 = null;
    L199:
        r150 = (Integer) r172;     // Catch: Throwable -> L241
        if (r150 != null) goto L239;
        if ((r149 instanceof Number) == false) goto L226;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L211;
        Float r173 = Float.valueOf(((Number) r149).floatValue());     // Catch: Throwable -> L241
        if ((r173 instanceof Integer) == true) goto L209;
        r173 = null;
    L209:
        r150 = (Integer) r173;     // Catch: Throwable -> L241
        goto L239
    L211:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L217;
        Double r174 = Double.valueOf(((Number) r149).doubleValue());     // Catch: Throwable -> L241
        if ((r174 instanceof Integer) == true) goto L215;
        r174 = null;
    L215:
        r150 = (Integer) r174;     // Catch: Throwable -> L241
        goto L239
    L217:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L220;
        r150 = Integer.valueOf(((Number) r149).intValue());     // Catch: Throwable -> L241
        goto L239
    L220:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L226;
        Long r175 = Long.valueOf(((Number) r149).longValue());     // Catch: Throwable -> L241
        if ((r175 instanceof Integer) == true) goto L224;
        r175 = null;
    L224:
        r150 = (Integer) r175;     // Catch: Throwable -> L241
    L226:
        if ((r149 instanceof JSONObject) == false) goto L228;
    L378:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L234
        Object r176 = SDKSettingsCacheManager.a().fromJson(r149.toString(), Integer.class);     // Catch: Throwable -> L234
        if ((r176 instanceof Integer) == true) goto L232;
        r176 = null;
    L232:
        Object r177 = Result.m9449constructorimpl((Integer) r176);     // Catch: Throwable -> L234
    L236:
        r150 = r177;
        if (Result.m9455isFailureimpl(r150) == false) goto L239;
    L234:
        th = move-exception;
        Result.Companion r178 = Result.Companion;     // Catch: Throwable -> L241
        r177 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L241
        goto L236
    L228:
        if ((r149 instanceof JSONArray) == false) goto L238;
    L198:
        r172 = r149;
    L241:
        th = move-exception;
        Result.Companion r179 = Result.Companion;     // Catch: Throwable -> L347
        r151 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L347
    L347:
        th = move-exception;
        Result.Companion r180 = Result.Companion;
        r145 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r181 = Result.m9452exceptionOrNullimpl(r145);
        if (r181 == null) goto L352;
        EnsureManager.ensureNotReachHere(r181);
    L352:
        if (Result.m9455isFailureimpl(r145) == false) goto L189;
        goto L189
    }

    @HostExperimentKey(author = "zhengsai.2022", desc = "商列slice筛选条")
    @SettingReport
    public static final int getEC_SHOP_SLICE_PRODUCT_FILTER() {
        Object r100 = 0;
        Object r101 = null;
        if (Intrinsics.areEqual("shop_slice_filter", "ec_shop_launch_opt_common_2") == false) goto L179;
        if (f186139b != null) goto L173;
        int r102 = n.f45241a;
        int r103 = com.bytedance.android.ec.base.settings.a.f42813a;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L163
        Object r105 = d.f42818c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L57
        if (r105 != null) goto L12;
    L54:
        Object r106 = null;
    L55:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L57
    L59:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);     // Catch: Throwable -> L163
        if (r108 == null) goto L63;
        EnsureManager.ensureNotReachHere(r108);     // Catch: Throwable -> L163
    L63:
        if (Result.m9455isFailureimpl(r107) == false) goto L66;
        r107 = null;
    L66:
        if ((r107 instanceof Integer) == true) goto L68;
        r107 = null;
    L68:
        Object r109 = (Integer) r107;     // Catch: Throwable -> L163
        if (r109 != null) goto L75;
        Object r110 = d.f42816a.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L163
        if ((r110 instanceof Integer) == true) goto L74;
        r110 = null;
    L74:
        r109 = (Integer) r110;     // Catch: Throwable -> L163
    L75:
        if (r109 != null) goto L172;
        int r111 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L163
        Object r112 = d.f42818c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L127
        if (r112 != null) goto L82;
    L124:
        Object r113 = null;
    L125:
        Object r114 = Result.m9449constructorimpl(r113);     // Catch: Throwable -> L127
    L129:
        Throwable r115 = Result.m9452exceptionOrNullimpl(r114);     // Catch: Throwable -> L154
        if (r115 == null) goto L133;
        EnsureManager.ensureNotReachHere(r115);     // Catch: Throwable -> L154
    L133:
        if (Result.m9455isFailureimpl(r114) == false) goto L136;
        r114 = null;
    L136:
        if ((r114 instanceof Integer) == true) goto L138;
        r114 = null;
    L138:
        r109 = (Integer) r114;     // Catch: Throwable -> L154
        if (r109 != null) goto L161;
        IHybridHostService r116 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L154
        if (r116 == null) goto L144;
        Object r117 = r116.getHostABValue("ec_shop_launch_opt_common_2", r100);     // Catch: Throwable -> L154
    L145:
        if (r117 != null) goto L147;
    L160:
        r109 = r100;
        goto L161
    L147:
        if ((r117 instanceof Integer) == false) goto L150;
        r101 = r117;
    L150:
        Integer r118 = (Integer) r101;     // Catch: Throwable -> L154
        if (r118 == null) goto L160;
        r109 = r118;
        goto L161
    L154:
        th = move-exception;
        Result.Companion r119 = Result.Companion;     // Catch: Throwable -> L163
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
        Throwable r120 = Result.m9452exceptionOrNullimpl(r109);     // Catch: Throwable -> L163
        if (r120 == null) goto L159;
        EnsureManager.ensureNotReachHere(r120);     // Catch: Throwable -> L163
    L159:
        if (Result.m9455isFailureimpl(r109) == false) goto L161;
    L144:
        r117 = null;
    L161:
        d.d("ec_shop_launch_opt_common_2", r109);     // Catch: Throwable -> L163
        goto L172
    L82:
        if ((r112 instanceof Integer) == true) goto L84;
        Object r121 = null;
    L85:
        r113 = (Integer) r121;     // Catch: Throwable -> L127
        if (r113 != null) goto L125;
        if ((r112 instanceof Number) == false) goto L112;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r122 = Float.valueOf(((Number) r112).floatValue());     // Catch: Throwable -> L127
        if ((r122 instanceof Integer) == true) goto L95;
        r122 = null;
    L95:
        r113 = (Integer) r122;     // Catch: Throwable -> L127
        goto L125
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r123 = Double.valueOf(((Number) r112).doubleValue());     // Catch: Throwable -> L127
        if ((r123 instanceof Integer) == true) goto L101;
        r123 = null;
    L101:
        r113 = (Integer) r123;     // Catch: Throwable -> L127
        goto L125
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L106;
        r113 = Integer.valueOf(((Number) r112).intValue());     // Catch: Throwable -> L127
        goto L125
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L112;
        Long r124 = Long.valueOf(((Number) r112).longValue());     // Catch: Throwable -> L127
        if ((r124 instanceof Integer) == true) goto L110;
        r124 = null;
    L110:
        r113 = (Integer) r124;     // Catch: Throwable -> L127
    L112:
        if ((r112 instanceof JSONObject) == false) goto L114;
    L366:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L120
        Object r125 = SDKSettingsCacheManager.a().fromJson(r112.toString(), Integer.class);     // Catch: Throwable -> L120
        if ((r125 instanceof Integer) == true) goto L118;
        r125 = null;
    L118:
        Object r126 = Result.m9449constructorimpl((Integer) r125);     // Catch: Throwable -> L120
    L122:
        r113 = r126;
        if (Result.m9455isFailureimpl(r113) == false) goto L125;
    L120:
        th = move-exception;
        Result.Companion r127 = Result.Companion;     // Catch: Throwable -> L127
        r126 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L127
        goto L122
    L114:
        if ((r112 instanceof JSONArray) == false) goto L124;
    L84:
        r121 = r112;
    L127:
        th = move-exception;
        Result.Companion r128 = Result.Companion;     // Catch: Throwable -> L154
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L154
    L172:
        f186139b = (Integer) r109;
        goto L173
    L12:
        if ((r105 instanceof Integer) == true) goto L14;
        Object r129 = null;
    L15:
        r106 = (Integer) r129;     // Catch: Throwable -> L57
        if (r106 != null) goto L55;
        if ((r105 instanceof Number) == false) goto L42;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L27;
        Float r130 = Float.valueOf(((Number) r105).floatValue());     // Catch: Throwable -> L57
        if ((r130 instanceof Integer) == true) goto L25;
        r130 = null;
    L25:
        r106 = (Integer) r130;     // Catch: Throwable -> L57
        goto L55
    L27:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L33;
        Double r131 = Double.valueOf(((Number) r105).doubleValue());     // Catch: Throwable -> L57
        if ((r131 instanceof Integer) == true) goto L31;
        r131 = null;
    L31:
        r106 = (Integer) r131;     // Catch: Throwable -> L57
        goto L55
    L33:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L36;
        r106 = Integer.valueOf(((Number) r105).intValue());     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L42;
        Long r132 = Long.valueOf(((Number) r105).longValue());     // Catch: Throwable -> L57
        if ((r132 instanceof Integer) == true) goto L40;
        r132 = null;
    L40:
        r106 = (Integer) r132;     // Catch: Throwable -> L57
    L42:
        if ((r105 instanceof JSONObject) == false) goto L44;
    L364:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L50
        Object r133 = SDKSettingsCacheManager.a().fromJson(r105.toString(), Integer.class);     // Catch: Throwable -> L50
        if ((r133 instanceof Integer) == true) goto L48;
        r133 = null;
    L48:
        Object r134 = Result.m9449constructorimpl((Integer) r133);     // Catch: Throwable -> L50
    L52:
        r106 = r134;
        if (Result.m9455isFailureimpl(r106) == false) goto L55;
    L50:
        th = move-exception;
        Result.Companion r135 = Result.Companion;     // Catch: Throwable -> L57
        r134 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L52
    L44:
        if ((r105 instanceof JSONArray) == false) goto L54;
    L14:
        r129 = r105;
    L57:
        th = move-exception;
        Result.Companion r136 = Result.Companion;     // Catch: Throwable -> L163
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
    L163:
        th = move-exception;
        Result.Companion r137 = Result.Companion;
        Object r138 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r139 = Result.m9452exceptionOrNullimpl(r138);
        if (r139 == null) goto L168;
        EnsureManager.ensureNotReachHere(r139);
    L168:
        if (Result.m9455isFailureimpl(r138) == true) goto L171;
        r100 = r138;
    L171:
        r109 = r100;
    L173:
        Object r140 = f186139b;
        if (r140 == null) goto L177;
    L354:
        f186138a.put("shop_slice_filter", r140);
        return ((Number) r140).intValue();
    L177:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L179:
        if (Intrinsics.areEqual("HostExperiment", "ShopSetting") == false) goto L190;
        int r141 = p.f45243a;
        Result.Companion r142 = Result.Companion;     // Catch: Throwable -> L185
        jj4.b r143 = jj4.b.f499326b;     // Catch: Throwable -> L185
        r140 = jj4.a.a("shop_slice_filter", Integer.class, r100, false);     // Catch: Throwable -> L185
        if (r140 != null) goto L354;
        Intrinsics.throwNpe();     // Catch: Throwable -> L185
    L185:
        th = move-exception;
        Result.Companion r144 = Result.Companion;
        Object r145 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r145) == true) goto L353;
    L189:
        r100 = r145;
    L353:
        r140 = r100;
        goto L354
    L190:
        int r146 = n.f45241a;
        int r147 = com.bytedance.android.ec.base.settings.a.f42813a;
        Result.Companion r148 = Result.Companion;     // Catch: Throwable -> L347
        Object r149 = d.f42818c.get("shop_slice_filter");     // Catch: Throwable -> L241
        if (r149 != null) goto L196;
    L238:
        Object r150 = null;
    L239:
        Object r151 = Result.m9449constructorimpl(r150);     // Catch: Throwable -> L241
    L243:
        Throwable r152 = Result.m9452exceptionOrNullimpl(r151);     // Catch: Throwable -> L347
        if (r152 == null) goto L247;
        EnsureManager.ensureNotReachHere(r152);     // Catch: Throwable -> L347
    L247:
        if (Result.m9455isFailureimpl(r151) == false) goto L250;
        r151 = null;
    L250:
        if ((r151 instanceof Integer) == true) goto L252;
        r151 = null;
    L252:
        r140 = (Integer) r151;     // Catch: Throwable -> L347
        if (r140 != null) goto L259;
        Object r153 = d.f42816a.get("shop_slice_filter");     // Catch: Throwable -> L347
        if ((r153 instanceof Integer) == true) goto L258;
        r153 = null;
    L258:
        r140 = (Integer) r153;     // Catch: Throwable -> L347
    L259:
        if (r140 != null) goto L354;
        int r154 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L347
        Object r155 = d.f42818c.get("shop_slice_filter");     // Catch: Throwable -> L311
        if (r155 != null) goto L266;
    L308:
        Object r156 = null;
    L309:
        Object r157 = Result.m9449constructorimpl(r156);     // Catch: Throwable -> L311
    L313:
        Throwable r158 = Result.m9452exceptionOrNullimpl(r157);     // Catch: Throwable -> L338
        if (r158 == null) goto L317;
        EnsureManager.ensureNotReachHere(r158);     // Catch: Throwable -> L338
    L317:
        if (Result.m9455isFailureimpl(r157) == false) goto L320;
        r157 = null;
    L320:
        if ((r157 instanceof Integer) == true) goto L322;
        r157 = null;
    L322:
        r140 = (Integer) r157;     // Catch: Throwable -> L338
        if (r140 != null) goto L345;
        IHybridHostService r159 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L338
        if (r159 == null) goto L328;
        Object r160 = r159.getHostABValue("shop_slice_filter", r100);     // Catch: Throwable -> L338
    L329:
        if (r160 != null) goto L331;
    L344:
        r140 = r100;
        goto L345
    L331:
        if ((r160 instanceof Integer) == false) goto L334;
        r101 = r160;
    L334:
        Integer r161 = (Integer) r101;     // Catch: Throwable -> L338
        if (r161 == null) goto L344;
        r140 = r161;
        goto L345
    L338:
        th = move-exception;
        Result.Companion r162 = Result.Companion;     // Catch: Throwable -> L347
        r140 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L347
        Throwable r163 = Result.m9452exceptionOrNullimpl(r140);     // Catch: Throwable -> L347
        if (r163 == null) goto L343;
        EnsureManager.ensureNotReachHere(r163);     // Catch: Throwable -> L347
    L343:
        if (Result.m9455isFailureimpl(r140) == false) goto L345;
    L328:
        r160 = null;
    L345:
        d.d("shop_slice_filter", r140);     // Catch: Throwable -> L347
        goto L354
    L266:
        if ((r155 instanceof Integer) == true) goto L268;
        Object r164 = null;
    L269:
        r156 = (Integer) r164;     // Catch: Throwable -> L311
        if (r156 != null) goto L309;
        if ((r155 instanceof Number) == false) goto L296;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L281;
        Float r165 = Float.valueOf(((Number) r155).floatValue());     // Catch: Throwable -> L311
        if ((r165 instanceof Integer) == true) goto L279;
        r165 = null;
    L279:
        r156 = (Integer) r165;     // Catch: Throwable -> L311
        goto L309
    L281:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L287;
        Double r166 = Double.valueOf(((Number) r155).doubleValue());     // Catch: Throwable -> L311
        if ((r166 instanceof Integer) == true) goto L285;
        r166 = null;
    L285:
        r156 = (Integer) r166;     // Catch: Throwable -> L311
        goto L309
    L287:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L290;
        r156 = Integer.valueOf(((Number) r155).intValue());     // Catch: Throwable -> L311
        goto L309
    L290:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L296;
        Long r167 = Long.valueOf(((Number) r155).longValue());     // Catch: Throwable -> L311
        if ((r167 instanceof Integer) == true) goto L294;
        r167 = null;
    L294:
        r156 = (Integer) r167;     // Catch: Throwable -> L311
    L296:
        if ((r155 instanceof JSONObject) == false) goto L298;
    L380:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L304
        Object r168 = SDKSettingsCacheManager.a().fromJson(r155.toString(), Integer.class);     // Catch: Throwable -> L304
        if ((r168 instanceof Integer) == true) goto L302;
        r168 = null;
    L302:
        Object r169 = Result.m9449constructorimpl((Integer) r168);     // Catch: Throwable -> L304
    L306:
        r156 = r169;
        if (Result.m9455isFailureimpl(r156) == false) goto L309;
    L304:
        th = move-exception;
        Result.Companion r170 = Result.Companion;     // Catch: Throwable -> L311
        r169 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L311
        goto L306
    L298:
        if ((r155 instanceof JSONArray) == false) goto L308;
    L268:
        r164 = r155;
    L311:
        th = move-exception;
        Result.Companion r171 = Result.Companion;     // Catch: Throwable -> L338
        r157 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L338
        goto L313
    L196:
        if ((r149 instanceof Integer) == true) goto L198;
        Object r172 = null;
    L199:
        r150 = (Integer) r172;     // Catch: Throwable -> L241
        if (r150 != null) goto L239;
        if ((r149 instanceof Number) == false) goto L226;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L211;
        Float r173 = Float.valueOf(((Number) r149).floatValue());     // Catch: Throwable -> L241
        if ((r173 instanceof Integer) == true) goto L209;
        r173 = null;
    L209:
        r150 = (Integer) r173;     // Catch: Throwable -> L241
        goto L239
    L211:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L217;
        Double r174 = Double.valueOf(((Number) r149).doubleValue());     // Catch: Throwable -> L241
        if ((r174 instanceof Integer) == true) goto L215;
        r174 = null;
    L215:
        r150 = (Integer) r174;     // Catch: Throwable -> L241
        goto L239
    L217:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L220;
        r150 = Integer.valueOf(((Number) r149).intValue());     // Catch: Throwable -> L241
        goto L239
    L220:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L226;
        Long r175 = Long.valueOf(((Number) r149).longValue());     // Catch: Throwable -> L241
        if ((r175 instanceof Integer) == true) goto L224;
        r175 = null;
    L224:
        r150 = (Integer) r175;     // Catch: Throwable -> L241
    L226:
        if ((r149 instanceof JSONObject) == false) goto L228;
    L378:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L234
        Object r176 = SDKSettingsCacheManager.a().fromJson(r149.toString(), Integer.class);     // Catch: Throwable -> L234
        if ((r176 instanceof Integer) == true) goto L232;
        r176 = null;
    L232:
        Object r177 = Result.m9449constructorimpl((Integer) r176);     // Catch: Throwable -> L234
    L236:
        r150 = r177;
        if (Result.m9455isFailureimpl(r150) == false) goto L239;
    L234:
        th = move-exception;
        Result.Companion r178 = Result.Companion;     // Catch: Throwable -> L241
        r177 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L241
        goto L236
    L228:
        if ((r149 instanceof JSONArray) == false) goto L238;
    L198:
        r172 = r149;
    L241:
        th = move-exception;
        Result.Companion r179 = Result.Companion;     // Catch: Throwable -> L347
        r151 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L347
    L347:
        th = move-exception;
        Result.Companion r180 = Result.Companion;
        r145 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r181 = Result.m9452exceptionOrNullimpl(r145);
        if (r181 == null) goto L352;
        EnsureManager.ensureNotReachHere(r181);
    L352:
        if (Result.m9455isFailureimpl(r145) == false) goto L189;
        goto L189
    }

    @HostExperimentKey(author = "chenlong.hz", desc = "品牌店商列交互优化")
    @SettingReport
    public static final int getEC_SHOP_TAB_INTERACTION_OPT() {
        Object r100 = 0;
        Object r101 = null;
        if (Intrinsics.areEqual("ec_shop_tab_interaction_opt", "ec_shop_launch_opt_common_2") == false) goto L179;
        if (f186139b != null) goto L173;
        int r102 = n.f45241a;
        int r103 = com.bytedance.android.ec.base.settings.a.f42813a;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L163
        Object r105 = d.f42818c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L57
        if (r105 != null) goto L12;
    L54:
        Object r106 = null;
    L55:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L57
    L59:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);     // Catch: Throwable -> L163
        if (r108 == null) goto L63;
        EnsureManager.ensureNotReachHere(r108);     // Catch: Throwable -> L163
    L63:
        if (Result.m9455isFailureimpl(r107) == false) goto L66;
        r107 = null;
    L66:
        if ((r107 instanceof Integer) == true) goto L68;
        r107 = null;
    L68:
        Object r109 = (Integer) r107;     // Catch: Throwable -> L163
        if (r109 != null) goto L75;
        Object r110 = d.f42816a.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L163
        if ((r110 instanceof Integer) == true) goto L74;
        r110 = null;
    L74:
        r109 = (Integer) r110;     // Catch: Throwable -> L163
    L75:
        if (r109 != null) goto L172;
        int r111 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L163
        Object r112 = d.f42818c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L127
        if (r112 != null) goto L82;
    L124:
        Object r113 = null;
    L125:
        Object r114 = Result.m9449constructorimpl(r113);     // Catch: Throwable -> L127
    L129:
        Throwable r115 = Result.m9452exceptionOrNullimpl(r114);     // Catch: Throwable -> L154
        if (r115 == null) goto L133;
        EnsureManager.ensureNotReachHere(r115);     // Catch: Throwable -> L154
    L133:
        if (Result.m9455isFailureimpl(r114) == false) goto L136;
        r114 = null;
    L136:
        if ((r114 instanceof Integer) == true) goto L138;
        r114 = null;
    L138:
        r109 = (Integer) r114;     // Catch: Throwable -> L154
        if (r109 != null) goto L161;
        IHybridHostService r116 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L154
        if (r116 == null) goto L144;
        Object r117 = r116.getHostABValue("ec_shop_launch_opt_common_2", r100);     // Catch: Throwable -> L154
    L145:
        if (r117 != null) goto L147;
    L160:
        r109 = r100;
        goto L161
    L147:
        if ((r117 instanceof Integer) == false) goto L150;
        r101 = r117;
    L150:
        Integer r118 = (Integer) r101;     // Catch: Throwable -> L154
        if (r118 == null) goto L160;
        r109 = r118;
        goto L161
    L154:
        th = move-exception;
        Result.Companion r119 = Result.Companion;     // Catch: Throwable -> L163
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
        Throwable r120 = Result.m9452exceptionOrNullimpl(r109);     // Catch: Throwable -> L163
        if (r120 == null) goto L159;
        EnsureManager.ensureNotReachHere(r120);     // Catch: Throwable -> L163
    L159:
        if (Result.m9455isFailureimpl(r109) == false) goto L161;
    L144:
        r117 = null;
    L161:
        d.d("ec_shop_launch_opt_common_2", r109);     // Catch: Throwable -> L163
        goto L172
    L82:
        if ((r112 instanceof Integer) == true) goto L84;
        Object r121 = null;
    L85:
        r113 = (Integer) r121;     // Catch: Throwable -> L127
        if (r113 != null) goto L125;
        if ((r112 instanceof Number) == false) goto L112;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r122 = Float.valueOf(((Number) r112).floatValue());     // Catch: Throwable -> L127
        if ((r122 instanceof Integer) == true) goto L95;
        r122 = null;
    L95:
        r113 = (Integer) r122;     // Catch: Throwable -> L127
        goto L125
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r123 = Double.valueOf(((Number) r112).doubleValue());     // Catch: Throwable -> L127
        if ((r123 instanceof Integer) == true) goto L101;
        r123 = null;
    L101:
        r113 = (Integer) r123;     // Catch: Throwable -> L127
        goto L125
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L106;
        r113 = Integer.valueOf(((Number) r112).intValue());     // Catch: Throwable -> L127
        goto L125
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L112;
        Long r124 = Long.valueOf(((Number) r112).longValue());     // Catch: Throwable -> L127
        if ((r124 instanceof Integer) == true) goto L110;
        r124 = null;
    L110:
        r113 = (Integer) r124;     // Catch: Throwable -> L127
    L112:
        if ((r112 instanceof JSONObject) == false) goto L114;
    L366:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L120
        Object r125 = SDKSettingsCacheManager.a().fromJson(r112.toString(), Integer.class);     // Catch: Throwable -> L120
        if ((r125 instanceof Integer) == true) goto L118;
        r125 = null;
    L118:
        Object r126 = Result.m9449constructorimpl((Integer) r125);     // Catch: Throwable -> L120
    L122:
        r113 = r126;
        if (Result.m9455isFailureimpl(r113) == false) goto L125;
    L120:
        th = move-exception;
        Result.Companion r127 = Result.Companion;     // Catch: Throwable -> L127
        r126 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L127
        goto L122
    L114:
        if ((r112 instanceof JSONArray) == false) goto L124;
    L84:
        r121 = r112;
    L127:
        th = move-exception;
        Result.Companion r128 = Result.Companion;     // Catch: Throwable -> L154
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L154
    L172:
        f186139b = (Integer) r109;
        goto L173
    L12:
        if ((r105 instanceof Integer) == true) goto L14;
        Object r129 = null;
    L15:
        r106 = (Integer) r129;     // Catch: Throwable -> L57
        if (r106 != null) goto L55;
        if ((r105 instanceof Number) == false) goto L42;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L27;
        Float r130 = Float.valueOf(((Number) r105).floatValue());     // Catch: Throwable -> L57
        if ((r130 instanceof Integer) == true) goto L25;
        r130 = null;
    L25:
        r106 = (Integer) r130;     // Catch: Throwable -> L57
        goto L55
    L27:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L33;
        Double r131 = Double.valueOf(((Number) r105).doubleValue());     // Catch: Throwable -> L57
        if ((r131 instanceof Integer) == true) goto L31;
        r131 = null;
    L31:
        r106 = (Integer) r131;     // Catch: Throwable -> L57
        goto L55
    L33:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L36;
        r106 = Integer.valueOf(((Number) r105).intValue());     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L42;
        Long r132 = Long.valueOf(((Number) r105).longValue());     // Catch: Throwable -> L57
        if ((r132 instanceof Integer) == true) goto L40;
        r132 = null;
    L40:
        r106 = (Integer) r132;     // Catch: Throwable -> L57
    L42:
        if ((r105 instanceof JSONObject) == false) goto L44;
    L364:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L50
        Object r133 = SDKSettingsCacheManager.a().fromJson(r105.toString(), Integer.class);     // Catch: Throwable -> L50
        if ((r133 instanceof Integer) == true) goto L48;
        r133 = null;
    L48:
        Object r134 = Result.m9449constructorimpl((Integer) r133);     // Catch: Throwable -> L50
    L52:
        r106 = r134;
        if (Result.m9455isFailureimpl(r106) == false) goto L55;
    L50:
        th = move-exception;
        Result.Companion r135 = Result.Companion;     // Catch: Throwable -> L57
        r134 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L52
    L44:
        if ((r105 instanceof JSONArray) == false) goto L54;
    L14:
        r129 = r105;
    L57:
        th = move-exception;
        Result.Companion r136 = Result.Companion;     // Catch: Throwable -> L163
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
    L163:
        th = move-exception;
        Result.Companion r137 = Result.Companion;
        Object r138 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r139 = Result.m9452exceptionOrNullimpl(r138);
        if (r139 == null) goto L168;
        EnsureManager.ensureNotReachHere(r139);
    L168:
        if (Result.m9455isFailureimpl(r138) == true) goto L171;
        r100 = r138;
    L171:
        r109 = r100;
    L173:
        Object r140 = f186139b;
        if (r140 == null) goto L177;
    L354:
        f186138a.put("ec_shop_tab_interaction_opt", r140);
        return ((Number) r140).intValue();
    L177:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L179:
        if (Intrinsics.areEqual("HostExperiment", "ShopSetting") == false) goto L190;
        int r141 = p.f45243a;
        Result.Companion r142 = Result.Companion;     // Catch: Throwable -> L185
        jj4.b r143 = jj4.b.f499326b;     // Catch: Throwable -> L185
        r140 = jj4.a.a("ec_shop_tab_interaction_opt", Integer.class, r100, false);     // Catch: Throwable -> L185
        if (r140 != null) goto L354;
        Intrinsics.throwNpe();     // Catch: Throwable -> L185
    L185:
        th = move-exception;
        Result.Companion r144 = Result.Companion;
        Object r145 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r145) == true) goto L353;
    L189:
        r100 = r145;
    L353:
        r140 = r100;
        goto L354
    L190:
        int r146 = n.f45241a;
        int r147 = com.bytedance.android.ec.base.settings.a.f42813a;
        Result.Companion r148 = Result.Companion;     // Catch: Throwable -> L347
        Object r149 = d.f42818c.get("ec_shop_tab_interaction_opt");     // Catch: Throwable -> L241
        if (r149 != null) goto L196;
    L238:
        Object r150 = null;
    L239:
        Object r151 = Result.m9449constructorimpl(r150);     // Catch: Throwable -> L241
    L243:
        Throwable r152 = Result.m9452exceptionOrNullimpl(r151);     // Catch: Throwable -> L347
        if (r152 == null) goto L247;
        EnsureManager.ensureNotReachHere(r152);     // Catch: Throwable -> L347
    L247:
        if (Result.m9455isFailureimpl(r151) == false) goto L250;
        r151 = null;
    L250:
        if ((r151 instanceof Integer) == true) goto L252;
        r151 = null;
    L252:
        r140 = (Integer) r151;     // Catch: Throwable -> L347
        if (r140 != null) goto L259;
        Object r153 = d.f42816a.get("ec_shop_tab_interaction_opt");     // Catch: Throwable -> L347
        if ((r153 instanceof Integer) == true) goto L258;
        r153 = null;
    L258:
        r140 = (Integer) r153;     // Catch: Throwable -> L347
    L259:
        if (r140 != null) goto L354;
        int r154 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L347
        Object r155 = d.f42818c.get("ec_shop_tab_interaction_opt");     // Catch: Throwable -> L311
        if (r155 != null) goto L266;
    L308:
        Object r156 = null;
    L309:
        Object r157 = Result.m9449constructorimpl(r156);     // Catch: Throwable -> L311
    L313:
        Throwable r158 = Result.m9452exceptionOrNullimpl(r157);     // Catch: Throwable -> L338
        if (r158 == null) goto L317;
        EnsureManager.ensureNotReachHere(r158);     // Catch: Throwable -> L338
    L317:
        if (Result.m9455isFailureimpl(r157) == false) goto L320;
        r157 = null;
    L320:
        if ((r157 instanceof Integer) == true) goto L322;
        r157 = null;
    L322:
        r140 = (Integer) r157;     // Catch: Throwable -> L338
        if (r140 != null) goto L345;
        IHybridHostService r159 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L338
        if (r159 == null) goto L328;
        Object r160 = r159.getHostABValue("ec_shop_tab_interaction_opt", r100);     // Catch: Throwable -> L338
    L329:
        if (r160 != null) goto L331;
    L344:
        r140 = r100;
        goto L345
    L331:
        if ((r160 instanceof Integer) == false) goto L334;
        r101 = r160;
    L334:
        Integer r161 = (Integer) r101;     // Catch: Throwable -> L338
        if (r161 == null) goto L344;
        r140 = r161;
        goto L345
    L338:
        th = move-exception;
        Result.Companion r162 = Result.Companion;     // Catch: Throwable -> L347
        r140 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L347
        Throwable r163 = Result.m9452exceptionOrNullimpl(r140);     // Catch: Throwable -> L347
        if (r163 == null) goto L343;
        EnsureManager.ensureNotReachHere(r163);     // Catch: Throwable -> L347
    L343:
        if (Result.m9455isFailureimpl(r140) == false) goto L345;
    L328:
        r160 = null;
    L345:
        d.d("ec_shop_tab_interaction_opt", r140);     // Catch: Throwable -> L347
        goto L354
    L266:
        if ((r155 instanceof Integer) == true) goto L268;
        Object r164 = null;
    L269:
        r156 = (Integer) r164;     // Catch: Throwable -> L311
        if (r156 != null) goto L309;
        if ((r155 instanceof Number) == false) goto L296;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L281;
        Float r165 = Float.valueOf(((Number) r155).floatValue());     // Catch: Throwable -> L311
        if ((r165 instanceof Integer) == true) goto L279;
        r165 = null;
    L279:
        r156 = (Integer) r165;     // Catch: Throwable -> L311
        goto L309
    L281:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L287;
        Double r166 = Double.valueOf(((Number) r155).doubleValue());     // Catch: Throwable -> L311
        if ((r166 instanceof Integer) == true) goto L285;
        r166 = null;
    L285:
        r156 = (Integer) r166;     // Catch: Throwable -> L311
        goto L309
    L287:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L290;
        r156 = Integer.valueOf(((Number) r155).intValue());     // Catch: Throwable -> L311
        goto L309
    L290:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L296;
        Long r167 = Long.valueOf(((Number) r155).longValue());     // Catch: Throwable -> L311
        if ((r167 instanceof Integer) == true) goto L294;
        r167 = null;
    L294:
        r156 = (Integer) r167;     // Catch: Throwable -> L311
    L296:
        if ((r155 instanceof JSONObject) == false) goto L298;
    L380:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L304
        Object r168 = SDKSettingsCacheManager.a().fromJson(r155.toString(), Integer.class);     // Catch: Throwable -> L304
        if ((r168 instanceof Integer) == true) goto L302;
        r168 = null;
    L302:
        Object r169 = Result.m9449constructorimpl((Integer) r168);     // Catch: Throwable -> L304
    L306:
        r156 = r169;
        if (Result.m9455isFailureimpl(r156) == false) goto L309;
    L304:
        th = move-exception;
        Result.Companion r170 = Result.Companion;     // Catch: Throwable -> L311
        r169 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L311
        goto L306
    L298:
        if ((r155 instanceof JSONArray) == false) goto L308;
    L268:
        r164 = r155;
    L311:
        th = move-exception;
        Result.Companion r171 = Result.Companion;     // Catch: Throwable -> L338
        r157 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L338
        goto L313
    L196:
        if ((r149 instanceof Integer) == true) goto L198;
        Object r172 = null;
    L199:
        r150 = (Integer) r172;     // Catch: Throwable -> L241
        if (r150 != null) goto L239;
        if ((r149 instanceof Number) == false) goto L226;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L211;
        Float r173 = Float.valueOf(((Number) r149).floatValue());     // Catch: Throwable -> L241
        if ((r173 instanceof Integer) == true) goto L209;
        r173 = null;
    L209:
        r150 = (Integer) r173;     // Catch: Throwable -> L241
        goto L239
    L211:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L217;
        Double r174 = Double.valueOf(((Number) r149).doubleValue());     // Catch: Throwable -> L241
        if ((r174 instanceof Integer) == true) goto L215;
        r174 = null;
    L215:
        r150 = (Integer) r174;     // Catch: Throwable -> L241
        goto L239
    L217:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L220;
        r150 = Integer.valueOf(((Number) r149).intValue());     // Catch: Throwable -> L241
        goto L239
    L220:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L226;
        Long r175 = Long.valueOf(((Number) r149).longValue());     // Catch: Throwable -> L241
        if ((r175 instanceof Integer) == true) goto L224;
        r175 = null;
    L224:
        r150 = (Integer) r175;     // Catch: Throwable -> L241
    L226:
        if ((r149 instanceof JSONObject) == false) goto L228;
    L378:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L234
        Object r176 = SDKSettingsCacheManager.a().fromJson(r149.toString(), Integer.class);     // Catch: Throwable -> L234
        if ((r176 instanceof Integer) == true) goto L232;
        r176 = null;
    L232:
        Object r177 = Result.m9449constructorimpl((Integer) r176);     // Catch: Throwable -> L234
    L236:
        r150 = r177;
        if (Result.m9455isFailureimpl(r150) == false) goto L239;
    L234:
        th = move-exception;
        Result.Companion r178 = Result.Companion;     // Catch: Throwable -> L241
        r177 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L241
        goto L236
    L228:
        if ((r149 instanceof JSONArray) == false) goto L238;
    L198:
        r172 = r149;
    L241:
        th = move-exception;
        Result.Companion r179 = Result.Companion;     // Catch: Throwable -> L347
        r151 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L347
    L347:
        th = move-exception;
        Result.Companion r180 = Result.Companion;
        r145 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r181 = Result.m9452exceptionOrNullimpl(r145);
        if (r181 == null) goto L352;
        EnsureManager.ensureNotReachHere(r181);
    L352:
        if (Result.m9455isFailureimpl(r145) == false) goto L189;
        goto L189
    }

    @HostExperimentKey(author = "chenlong,hz", desc = "热搜词切接口")
    @SettingReport
    public static final int getSHOP_SWITCH_TOP_SEARCH_INFO() {
        Object r100 = 0;
        Object r101 = null;
        if (Intrinsics.areEqual("ec_shop_switch_top_search_info", "ec_shop_launch_opt_common_2") == false) goto L179;
        if (f186139b != null) goto L173;
        int r102 = n.f45241a;
        int r103 = com.bytedance.android.ec.base.settings.a.f42813a;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L163
        Object r105 = d.f42818c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L57
        if (r105 != null) goto L12;
    L54:
        Object r106 = null;
    L55:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L57
    L59:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);     // Catch: Throwable -> L163
        if (r108 == null) goto L63;
        EnsureManager.ensureNotReachHere(r108);     // Catch: Throwable -> L163
    L63:
        if (Result.m9455isFailureimpl(r107) == false) goto L66;
        r107 = null;
    L66:
        if ((r107 instanceof Integer) == true) goto L68;
        r107 = null;
    L68:
        Object r109 = (Integer) r107;     // Catch: Throwable -> L163
        if (r109 != null) goto L75;
        Object r110 = d.f42816a.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L163
        if ((r110 instanceof Integer) == true) goto L74;
        r110 = null;
    L74:
        r109 = (Integer) r110;     // Catch: Throwable -> L163
    L75:
        if (r109 != null) goto L172;
        int r111 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L163
        Object r112 = d.f42818c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L127
        if (r112 != null) goto L82;
    L124:
        Object r113 = null;
    L125:
        Object r114 = Result.m9449constructorimpl(r113);     // Catch: Throwable -> L127
    L129:
        Throwable r115 = Result.m9452exceptionOrNullimpl(r114);     // Catch: Throwable -> L154
        if (r115 == null) goto L133;
        EnsureManager.ensureNotReachHere(r115);     // Catch: Throwable -> L154
    L133:
        if (Result.m9455isFailureimpl(r114) == false) goto L136;
        r114 = null;
    L136:
        if ((r114 instanceof Integer) == true) goto L138;
        r114 = null;
    L138:
        r109 = (Integer) r114;     // Catch: Throwable -> L154
        if (r109 != null) goto L161;
        IHybridHostService r116 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L154
        if (r116 == null) goto L144;
        Object r117 = r116.getHostABValue("ec_shop_launch_opt_common_2", r100);     // Catch: Throwable -> L154
    L145:
        if (r117 != null) goto L147;
    L160:
        r109 = r100;
        goto L161
    L147:
        if ((r117 instanceof Integer) == false) goto L150;
        r101 = r117;
    L150:
        Integer r118 = (Integer) r101;     // Catch: Throwable -> L154
        if (r118 == null) goto L160;
        r109 = r118;
        goto L161
    L154:
        th = move-exception;
        Result.Companion r119 = Result.Companion;     // Catch: Throwable -> L163
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
        Throwable r120 = Result.m9452exceptionOrNullimpl(r109);     // Catch: Throwable -> L163
        if (r120 == null) goto L159;
        EnsureManager.ensureNotReachHere(r120);     // Catch: Throwable -> L163
    L159:
        if (Result.m9455isFailureimpl(r109) == false) goto L161;
    L144:
        r117 = null;
    L161:
        d.d("ec_shop_launch_opt_common_2", r109);     // Catch: Throwable -> L163
        goto L172
    L82:
        if ((r112 instanceof Integer) == true) goto L84;
        Object r121 = null;
    L85:
        r113 = (Integer) r121;     // Catch: Throwable -> L127
        if (r113 != null) goto L125;
        if ((r112 instanceof Number) == false) goto L112;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r122 = Float.valueOf(((Number) r112).floatValue());     // Catch: Throwable -> L127
        if ((r122 instanceof Integer) == true) goto L95;
        r122 = null;
    L95:
        r113 = (Integer) r122;     // Catch: Throwable -> L127
        goto L125
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r123 = Double.valueOf(((Number) r112).doubleValue());     // Catch: Throwable -> L127
        if ((r123 instanceof Integer) == true) goto L101;
        r123 = null;
    L101:
        r113 = (Integer) r123;     // Catch: Throwable -> L127
        goto L125
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L106;
        r113 = Integer.valueOf(((Number) r112).intValue());     // Catch: Throwable -> L127
        goto L125
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L112;
        Long r124 = Long.valueOf(((Number) r112).longValue());     // Catch: Throwable -> L127
        if ((r124 instanceof Integer) == true) goto L110;
        r124 = null;
    L110:
        r113 = (Integer) r124;     // Catch: Throwable -> L127
    L112:
        if ((r112 instanceof JSONObject) == false) goto L114;
    L366:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L120
        Object r125 = SDKSettingsCacheManager.a().fromJson(r112.toString(), Integer.class);     // Catch: Throwable -> L120
        if ((r125 instanceof Integer) == true) goto L118;
        r125 = null;
    L118:
        Object r126 = Result.m9449constructorimpl((Integer) r125);     // Catch: Throwable -> L120
    L122:
        r113 = r126;
        if (Result.m9455isFailureimpl(r113) == false) goto L125;
    L120:
        th = move-exception;
        Result.Companion r127 = Result.Companion;     // Catch: Throwable -> L127
        r126 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L127
        goto L122
    L114:
        if ((r112 instanceof JSONArray) == false) goto L124;
    L84:
        r121 = r112;
    L127:
        th = move-exception;
        Result.Companion r128 = Result.Companion;     // Catch: Throwable -> L154
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L154
    L172:
        f186139b = (Integer) r109;
        goto L173
    L12:
        if ((r105 instanceof Integer) == true) goto L14;
        Object r129 = null;
    L15:
        r106 = (Integer) r129;     // Catch: Throwable -> L57
        if (r106 != null) goto L55;
        if ((r105 instanceof Number) == false) goto L42;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L27;
        Float r130 = Float.valueOf(((Number) r105).floatValue());     // Catch: Throwable -> L57
        if ((r130 instanceof Integer) == true) goto L25;
        r130 = null;
    L25:
        r106 = (Integer) r130;     // Catch: Throwable -> L57
        goto L55
    L27:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L33;
        Double r131 = Double.valueOf(((Number) r105).doubleValue());     // Catch: Throwable -> L57
        if ((r131 instanceof Integer) == true) goto L31;
        r131 = null;
    L31:
        r106 = (Integer) r131;     // Catch: Throwable -> L57
        goto L55
    L33:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L36;
        r106 = Integer.valueOf(((Number) r105).intValue());     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L42;
        Long r132 = Long.valueOf(((Number) r105).longValue());     // Catch: Throwable -> L57
        if ((r132 instanceof Integer) == true) goto L40;
        r132 = null;
    L40:
        r106 = (Integer) r132;     // Catch: Throwable -> L57
    L42:
        if ((r105 instanceof JSONObject) == false) goto L44;
    L364:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L50
        Object r133 = SDKSettingsCacheManager.a().fromJson(r105.toString(), Integer.class);     // Catch: Throwable -> L50
        if ((r133 instanceof Integer) == true) goto L48;
        r133 = null;
    L48:
        Object r134 = Result.m9449constructorimpl((Integer) r133);     // Catch: Throwable -> L50
    L52:
        r106 = r134;
        if (Result.m9455isFailureimpl(r106) == false) goto L55;
    L50:
        th = move-exception;
        Result.Companion r135 = Result.Companion;     // Catch: Throwable -> L57
        r134 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L52
    L44:
        if ((r105 instanceof JSONArray) == false) goto L54;
    L14:
        r129 = r105;
    L57:
        th = move-exception;
        Result.Companion r136 = Result.Companion;     // Catch: Throwable -> L163
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
    L163:
        th = move-exception;
        Result.Companion r137 = Result.Companion;
        Object r138 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r139 = Result.m9452exceptionOrNullimpl(r138);
        if (r139 == null) goto L168;
        EnsureManager.ensureNotReachHere(r139);
    L168:
        if (Result.m9455isFailureimpl(r138) == true) goto L171;
        r100 = r138;
    L171:
        r109 = r100;
    L173:
        Object r140 = f186139b;
        if (r140 == null) goto L177;
    L354:
        f186138a.put("ec_shop_switch_top_search_info", r140);
        return ((Number) r140).intValue();
    L177:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L179:
        if (Intrinsics.areEqual("HostExperiment", "ShopSetting") == false) goto L190;
        int r141 = p.f45243a;
        Result.Companion r142 = Result.Companion;     // Catch: Throwable -> L185
        jj4.b r143 = jj4.b.f499326b;     // Catch: Throwable -> L185
        r140 = jj4.a.a("ec_shop_switch_top_search_info", Integer.class, r100, false);     // Catch: Throwable -> L185
        if (r140 != null) goto L354;
        Intrinsics.throwNpe();     // Catch: Throwable -> L185
    L185:
        th = move-exception;
        Result.Companion r144 = Result.Companion;
        Object r145 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r145) == true) goto L353;
    L189:
        r100 = r145;
    L353:
        r140 = r100;
        goto L354
    L190:
        int r146 = n.f45241a;
        int r147 = com.bytedance.android.ec.base.settings.a.f42813a;
        Result.Companion r148 = Result.Companion;     // Catch: Throwable -> L347
        Object r149 = d.f42818c.get("ec_shop_switch_top_search_info");     // Catch: Throwable -> L241
        if (r149 != null) goto L196;
    L238:
        Object r150 = null;
    L239:
        Object r151 = Result.m9449constructorimpl(r150);     // Catch: Throwable -> L241
    L243:
        Throwable r152 = Result.m9452exceptionOrNullimpl(r151);     // Catch: Throwable -> L347
        if (r152 == null) goto L247;
        EnsureManager.ensureNotReachHere(r152);     // Catch: Throwable -> L347
    L247:
        if (Result.m9455isFailureimpl(r151) == false) goto L250;
        r151 = null;
    L250:
        if ((r151 instanceof Integer) == true) goto L252;
        r151 = null;
    L252:
        r140 = (Integer) r151;     // Catch: Throwable -> L347
        if (r140 != null) goto L259;
        Object r153 = d.f42816a.get("ec_shop_switch_top_search_info");     // Catch: Throwable -> L347
        if ((r153 instanceof Integer) == true) goto L258;
        r153 = null;
    L258:
        r140 = (Integer) r153;     // Catch: Throwable -> L347
    L259:
        if (r140 != null) goto L354;
        int r154 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L347
        Object r155 = d.f42818c.get("ec_shop_switch_top_search_info");     // Catch: Throwable -> L311
        if (r155 != null) goto L266;
    L308:
        Object r156 = null;
    L309:
        Object r157 = Result.m9449constructorimpl(r156);     // Catch: Throwable -> L311
    L313:
        Throwable r158 = Result.m9452exceptionOrNullimpl(r157);     // Catch: Throwable -> L338
        if (r158 == null) goto L317;
        EnsureManager.ensureNotReachHere(r158);     // Catch: Throwable -> L338
    L317:
        if (Result.m9455isFailureimpl(r157) == false) goto L320;
        r157 = null;
    L320:
        if ((r157 instanceof Integer) == true) goto L322;
        r157 = null;
    L322:
        r140 = (Integer) r157;     // Catch: Throwable -> L338
        if (r140 != null) goto L345;
        IHybridHostService r159 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L338
        if (r159 == null) goto L328;
        Object r160 = r159.getHostABValue("ec_shop_switch_top_search_info", r100);     // Catch: Throwable -> L338
    L329:
        if (r160 != null) goto L331;
    L344:
        r140 = r100;
        goto L345
    L331:
        if ((r160 instanceof Integer) == false) goto L334;
        r101 = r160;
    L334:
        Integer r161 = (Integer) r101;     // Catch: Throwable -> L338
        if (r161 == null) goto L344;
        r140 = r161;
        goto L345
    L338:
        th = move-exception;
        Result.Companion r162 = Result.Companion;     // Catch: Throwable -> L347
        r140 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L347
        Throwable r163 = Result.m9452exceptionOrNullimpl(r140);     // Catch: Throwable -> L347
        if (r163 == null) goto L343;
        EnsureManager.ensureNotReachHere(r163);     // Catch: Throwable -> L347
    L343:
        if (Result.m9455isFailureimpl(r140) == false) goto L345;
    L328:
        r160 = null;
    L345:
        d.d("ec_shop_switch_top_search_info", r140);     // Catch: Throwable -> L347
        goto L354
    L266:
        if ((r155 instanceof Integer) == true) goto L268;
        Object r164 = null;
    L269:
        r156 = (Integer) r164;     // Catch: Throwable -> L311
        if (r156 != null) goto L309;
        if ((r155 instanceof Number) == false) goto L296;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L281;
        Float r165 = Float.valueOf(((Number) r155).floatValue());     // Catch: Throwable -> L311
        if ((r165 instanceof Integer) == true) goto L279;
        r165 = null;
    L279:
        r156 = (Integer) r165;     // Catch: Throwable -> L311
        goto L309
    L281:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L287;
        Double r166 = Double.valueOf(((Number) r155).doubleValue());     // Catch: Throwable -> L311
        if ((r166 instanceof Integer) == true) goto L285;
        r166 = null;
    L285:
        r156 = (Integer) r166;     // Catch: Throwable -> L311
        goto L309
    L287:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L290;
        r156 = Integer.valueOf(((Number) r155).intValue());     // Catch: Throwable -> L311
        goto L309
    L290:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L296;
        Long r167 = Long.valueOf(((Number) r155).longValue());     // Catch: Throwable -> L311
        if ((r167 instanceof Integer) == true) goto L294;
        r167 = null;
    L294:
        r156 = (Integer) r167;     // Catch: Throwable -> L311
    L296:
        if ((r155 instanceof JSONObject) == false) goto L298;
    L380:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L304
        Object r168 = SDKSettingsCacheManager.a().fromJson(r155.toString(), Integer.class);     // Catch: Throwable -> L304
        if ((r168 instanceof Integer) == true) goto L302;
        r168 = null;
    L302:
        Object r169 = Result.m9449constructorimpl((Integer) r168);     // Catch: Throwable -> L304
    L306:
        r156 = r169;
        if (Result.m9455isFailureimpl(r156) == false) goto L309;
    L304:
        th = move-exception;
        Result.Companion r170 = Result.Companion;     // Catch: Throwable -> L311
        r169 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L311
        goto L306
    L298:
        if ((r155 instanceof JSONArray) == false) goto L308;
    L268:
        r164 = r155;
    L311:
        th = move-exception;
        Result.Companion r171 = Result.Companion;     // Catch: Throwable -> L338
        r157 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L338
        goto L313
    L196:
        if ((r149 instanceof Integer) == true) goto L198;
        Object r172 = null;
    L199:
        r150 = (Integer) r172;     // Catch: Throwable -> L241
        if (r150 != null) goto L239;
        if ((r149 instanceof Number) == false) goto L226;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L211;
        Float r173 = Float.valueOf(((Number) r149).floatValue());     // Catch: Throwable -> L241
        if ((r173 instanceof Integer) == true) goto L209;
        r173 = null;
    L209:
        r150 = (Integer) r173;     // Catch: Throwable -> L241
        goto L239
    L211:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L217;
        Double r174 = Double.valueOf(((Number) r149).doubleValue());     // Catch: Throwable -> L241
        if ((r174 instanceof Integer) == true) goto L215;
        r174 = null;
    L215:
        r150 = (Integer) r174;     // Catch: Throwable -> L241
        goto L239
    L217:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L220;
        r150 = Integer.valueOf(((Number) r149).intValue());     // Catch: Throwable -> L241
        goto L239
    L220:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L226;
        Long r175 = Long.valueOf(((Number) r149).longValue());     // Catch: Throwable -> L241
        if ((r175 instanceof Integer) == true) goto L224;
        r175 = null;
    L224:
        r150 = (Integer) r175;     // Catch: Throwable -> L241
    L226:
        if ((r149 instanceof JSONObject) == false) goto L228;
    L378:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L234
        Object r176 = SDKSettingsCacheManager.a().fromJson(r149.toString(), Integer.class);     // Catch: Throwable -> L234
        if ((r176 instanceof Integer) == true) goto L232;
        r176 = null;
    L232:
        Object r177 = Result.m9449constructorimpl((Integer) r176);     // Catch: Throwable -> L234
    L236:
        r150 = r177;
        if (Result.m9455isFailureimpl(r150) == false) goto L239;
    L234:
        th = move-exception;
        Result.Companion r178 = Result.Companion;     // Catch: Throwable -> L241
        r177 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L241
        goto L236
    L228:
        if ((r149 instanceof JSONArray) == false) goto L238;
    L198:
        r172 = r149;
    L241:
        th = move-exception;
        Result.Companion r179 = Result.Companion;     // Catch: Throwable -> L347
        r151 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L347
    L347:
        th = move-exception;
        Result.Companion r180 = Result.Companion;
        r145 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r181 = Result.m9452exceptionOrNullimpl(r145);
        if (r181 == null) goto L352;
        EnsureManager.ensureNotReachHere(r181);
    L352:
        if (Result.m9455isFailureimpl(r145) == false) goto L189;
        goto L189
    }

    public static boolean h() {
        Object r100 = 0;
        Object r101 = null;
        if (Intrinsics.areEqual("ec_shop_chunk", "ec_shop_launch_opt_common_2") == false) goto L179;
        if (f186139b != null) goto L173;
        int r102 = n.f45241a;
        int r103 = com.bytedance.android.ec.base.settings.a.f42813a;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L163
        Object r105 = d.f42818c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L57
        if (r105 != null) goto L12;
    L54:
        Object r106 = null;
    L55:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L57
    L59:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);     // Catch: Throwable -> L163
        if (r108 == null) goto L63;
        EnsureManager.ensureNotReachHere(r108);     // Catch: Throwable -> L163
    L63:
        if (Result.m9455isFailureimpl(r107) == false) goto L66;
        r107 = null;
    L66:
        if ((r107 instanceof Integer) == true) goto L68;
        r107 = null;
    L68:
        Object r109 = (Integer) r107;     // Catch: Throwable -> L163
        if (r109 != null) goto L75;
        Object r110 = d.f42816a.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L163
        if ((r110 instanceof Integer) == true) goto L74;
        r110 = null;
    L74:
        r109 = (Integer) r110;     // Catch: Throwable -> L163
    L75:
        if (r109 != null) goto L172;
        int r111 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L163
        Object r112 = d.f42818c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L127
        if (r112 != null) goto L82;
    L124:
        Object r113 = null;
    L125:
        Object r114 = Result.m9449constructorimpl(r113);     // Catch: Throwable -> L127
    L129:
        Throwable r115 = Result.m9452exceptionOrNullimpl(r114);     // Catch: Throwable -> L154
        if (r115 == null) goto L133;
        EnsureManager.ensureNotReachHere(r115);     // Catch: Throwable -> L154
    L133:
        if (Result.m9455isFailureimpl(r114) == false) goto L136;
        r114 = null;
    L136:
        if ((r114 instanceof Integer) == true) goto L138;
        r114 = null;
    L138:
        r109 = (Integer) r114;     // Catch: Throwable -> L154
        if (r109 != null) goto L161;
        IHybridHostService r116 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L154
        if (r116 == null) goto L144;
        Object r117 = r116.getHostABValue("ec_shop_launch_opt_common_2", r100);     // Catch: Throwable -> L154
    L145:
        if (r117 != null) goto L147;
    L160:
        r109 = r100;
        goto L161
    L147:
        if ((r117 instanceof Integer) == false) goto L150;
        r101 = r117;
    L150:
        Integer r118 = (Integer) r101;     // Catch: Throwable -> L154
        if (r118 == null) goto L160;
        r109 = r118;
        goto L161
    L154:
        th = move-exception;
        Result.Companion r119 = Result.Companion;     // Catch: Throwable -> L163
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
        Throwable r120 = Result.m9452exceptionOrNullimpl(r109);     // Catch: Throwable -> L163
        if (r120 == null) goto L159;
        EnsureManager.ensureNotReachHere(r120);     // Catch: Throwable -> L163
    L159:
        if (Result.m9455isFailureimpl(r109) == false) goto L161;
    L144:
        r117 = null;
    L161:
        d.d("ec_shop_launch_opt_common_2", r109);     // Catch: Throwable -> L163
        goto L172
    L82:
        if ((r112 instanceof Integer) == true) goto L84;
        Object r121 = null;
    L85:
        r113 = (Integer) r121;     // Catch: Throwable -> L127
        if (r113 != null) goto L125;
        if ((r112 instanceof Number) == false) goto L112;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r122 = Float.valueOf(((Number) r112).floatValue());     // Catch: Throwable -> L127
        if ((r122 instanceof Integer) == true) goto L95;
        r122 = null;
    L95:
        r113 = (Integer) r122;     // Catch: Throwable -> L127
        goto L125
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r123 = Double.valueOf(((Number) r112).doubleValue());     // Catch: Throwable -> L127
        if ((r123 instanceof Integer) == true) goto L101;
        r123 = null;
    L101:
        r113 = (Integer) r123;     // Catch: Throwable -> L127
        goto L125
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L106;
        r113 = Integer.valueOf(((Number) r112).intValue());     // Catch: Throwable -> L127
        goto L125
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L112;
        Long r124 = Long.valueOf(((Number) r112).longValue());     // Catch: Throwable -> L127
        if ((r124 instanceof Integer) == true) goto L110;
        r124 = null;
    L110:
        r113 = (Integer) r124;     // Catch: Throwable -> L127
    L112:
        if ((r112 instanceof JSONObject) == false) goto L114;
    L366:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L120
        Object r125 = SDKSettingsCacheManager.a().fromJson(r112.toString(), Integer.class);     // Catch: Throwable -> L120
        if ((r125 instanceof Integer) == true) goto L118;
        r125 = null;
    L118:
        Object r126 = Result.m9449constructorimpl((Integer) r125);     // Catch: Throwable -> L120
    L122:
        r113 = r126;
        if (Result.m9455isFailureimpl(r113) == false) goto L125;
    L120:
        th = move-exception;
        Result.Companion r127 = Result.Companion;     // Catch: Throwable -> L127
        r126 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L127
        goto L122
    L114:
        if ((r112 instanceof JSONArray) == false) goto L124;
    L84:
        r121 = r112;
    L127:
        th = move-exception;
        Result.Companion r128 = Result.Companion;     // Catch: Throwable -> L154
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L154
    L172:
        f186139b = (Integer) r109;
        goto L173
    L12:
        if ((r105 instanceof Integer) == true) goto L14;
        Object r129 = null;
    L15:
        r106 = (Integer) r129;     // Catch: Throwable -> L57
        if (r106 != null) goto L55;
        if ((r105 instanceof Number) == false) goto L42;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L27;
        Float r130 = Float.valueOf(((Number) r105).floatValue());     // Catch: Throwable -> L57
        if ((r130 instanceof Integer) == true) goto L25;
        r130 = null;
    L25:
        r106 = (Integer) r130;     // Catch: Throwable -> L57
        goto L55
    L27:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L33;
        Double r131 = Double.valueOf(((Number) r105).doubleValue());     // Catch: Throwable -> L57
        if ((r131 instanceof Integer) == true) goto L31;
        r131 = null;
    L31:
        r106 = (Integer) r131;     // Catch: Throwable -> L57
        goto L55
    L33:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L36;
        r106 = Integer.valueOf(((Number) r105).intValue());     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L42;
        Long r132 = Long.valueOf(((Number) r105).longValue());     // Catch: Throwable -> L57
        if ((r132 instanceof Integer) == true) goto L40;
        r132 = null;
    L40:
        r106 = (Integer) r132;     // Catch: Throwable -> L57
    L42:
        if ((r105 instanceof JSONObject) == false) goto L44;
    L364:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L50
        Object r133 = SDKSettingsCacheManager.a().fromJson(r105.toString(), Integer.class);     // Catch: Throwable -> L50
        if ((r133 instanceof Integer) == true) goto L48;
        r133 = null;
    L48:
        Object r134 = Result.m9449constructorimpl((Integer) r133);     // Catch: Throwable -> L50
    L52:
        r106 = r134;
        if (Result.m9455isFailureimpl(r106) == false) goto L55;
    L50:
        th = move-exception;
        Result.Companion r135 = Result.Companion;     // Catch: Throwable -> L57
        r134 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L52
    L44:
        if ((r105 instanceof JSONArray) == false) goto L54;
    L14:
        r129 = r105;
    L57:
        th = move-exception;
        Result.Companion r136 = Result.Companion;     // Catch: Throwable -> L163
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
    L163:
        th = move-exception;
        Result.Companion r137 = Result.Companion;
        Object r138 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r139 = Result.m9452exceptionOrNullimpl(r138);
        if (r139 == null) goto L168;
        EnsureManager.ensureNotReachHere(r139);
    L168:
        if (Result.m9455isFailureimpl(r138) == true) goto L171;
        r100 = r138;
    L171:
        r109 = r100;
    L173:
        r100 = f186139b;
        if (r100 == null) goto L177;
    L352:
        f186138a.put("ec_shop_chunk", r100);
        if (((Number) r100).intValue() != 1) goto L381;
        return true;
    L381:
        return false;
    L177:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L179:
        if (Intrinsics.areEqual("HostExperiment", "ShopSetting") == false) goto L190;
        int r140 = p.f45243a;
        Result.Companion r141 = Result.Companion;     // Catch: Throwable -> L185
        jj4.b r142 = jj4.b.f499326b;     // Catch: Throwable -> L185
        Object r143 = jj4.a.a("ec_shop_chunk", Integer.class, r100, false);     // Catch: Throwable -> L185
        if (r143 != null) goto L189;
        Intrinsics.throwNpe();     // Catch: Throwable -> L185
    L189:
        r100 = r143;
    L185:
        th = move-exception;
        Result.Companion r144 = Result.Companion;
        r143 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r143) == false) goto L189;
    L190:
        int r145 = n.f45241a;
        int r146 = com.bytedance.android.ec.base.settings.a.f42813a;
        Result.Companion r147 = Result.Companion;     // Catch: Throwable -> L346
        Object r148 = d.f42818c.get("ec_shop_chunk");     // Catch: Throwable -> L241
        if (r148 != null) goto L196;
    L238:
        Object r149 = null;
    L239:
        Object r150 = Result.m9449constructorimpl(r149);     // Catch: Throwable -> L241
    L243:
        Throwable r151 = Result.m9452exceptionOrNullimpl(r150);     // Catch: Throwable -> L346
        if (r151 == null) goto L247;
        EnsureManager.ensureNotReachHere(r151);     // Catch: Throwable -> L346
    L247:
        if (Result.m9455isFailureimpl(r150) == false) goto L250;
        r150 = null;
    L250:
        if ((r150 instanceof Integer) == true) goto L252;
        r150 = null;
    L252:
        r143 = (Integer) r150;     // Catch: Throwable -> L346
        if (r143 != null) goto L259;
        Object r152 = d.f42816a.get("ec_shop_chunk");     // Catch: Throwable -> L346
        if ((r152 instanceof Integer) == true) goto L258;
        r152 = null;
    L258:
        r143 = (Integer) r152;     // Catch: Throwable -> L346
    L259:
        if (r143 != null) goto L189;
        int r153 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L346
        Object r154 = d.f42818c.get("ec_shop_chunk");     // Catch: Throwable -> L311
        if (r154 != null) goto L266;
    L308:
        Object r155 = null;
    L309:
        Object r156 = Result.m9449constructorimpl(r155);     // Catch: Throwable -> L311
    L313:
        Throwable r157 = Result.m9452exceptionOrNullimpl(r156);     // Catch: Throwable -> L337
        if (r157 == null) goto L317;
        EnsureManager.ensureNotReachHere(r157);     // Catch: Throwable -> L337
    L317:
        if (Result.m9455isFailureimpl(r156) == false) goto L320;
        r156 = null;
    L320:
        if ((r156 instanceof Integer) == true) goto L322;
        r156 = null;
    L322:
        r143 = (Integer) r156;     // Catch: Throwable -> L337
        if (r143 != null) goto L344;
        IHybridHostService r158 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L337
        if (r158 == null) goto L328;
        Object r159 = r158.getHostABValue("ec_shop_chunk", r100);     // Catch: Throwable -> L337
    L329:
        if (r159 != null) goto L331;
    L343:
        r143 = r100;
        goto L344
    L331:
        if ((r159 instanceof Integer) == false) goto L334;
        r101 = r159;
    L334:
        r143 = (Integer) r101;     // Catch: Throwable -> L337
        if (r143 != null) goto L344;
    L328:
        r159 = null;
    L344:
        d.d("ec_shop_chunk", r143);     // Catch: Throwable -> L346
        goto L189
    L266:
        if ((r154 instanceof Integer) == true) goto L268;
        Object r160 = null;
    L269:
        r155 = (Integer) r160;     // Catch: Throwable -> L311
        if (r155 != null) goto L309;
        if ((r154 instanceof Number) == false) goto L296;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L281;
        Float r161 = Float.valueOf(((Number) r154).floatValue());     // Catch: Throwable -> L311
        if ((r161 instanceof Integer) == true) goto L279;
        r161 = null;
    L279:
        r155 = (Integer) r161;     // Catch: Throwable -> L311
        goto L309
    L281:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L287;
        Double r162 = Double.valueOf(((Number) r154).doubleValue());     // Catch: Throwable -> L311
        if ((r162 instanceof Integer) == true) goto L285;
        r162 = null;
    L285:
        r155 = (Integer) r162;     // Catch: Throwable -> L311
        goto L309
    L287:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L290;
        r155 = Integer.valueOf(((Number) r154).intValue());     // Catch: Throwable -> L311
        goto L309
    L290:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L296;
        Long r163 = Long.valueOf(((Number) r154).longValue());     // Catch: Throwable -> L311
        if ((r163 instanceof Integer) == true) goto L294;
        r163 = null;
    L294:
        r155 = (Integer) r163;     // Catch: Throwable -> L311
    L296:
        if ((r154 instanceof JSONObject) == false) goto L298;
    L379:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L304
        Object r164 = SDKSettingsCacheManager.a().fromJson(r154.toString(), Integer.class);     // Catch: Throwable -> L304
        if ((r164 instanceof Integer) == true) goto L302;
        r164 = null;
    L302:
        Object r165 = Result.m9449constructorimpl((Integer) r164);     // Catch: Throwable -> L304
    L306:
        r155 = r165;
        if (Result.m9455isFailureimpl(r155) == false) goto L309;
    L304:
        th = move-exception;
        Result.Companion r166 = Result.Companion;     // Catch: Throwable -> L311
        r165 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L311
        goto L306
    L298:
        if ((r154 instanceof JSONArray) == false) goto L308;
    L268:
        r160 = r154;
    L337:
        th = move-exception;
        Result.Companion r167 = Result.Companion;     // Catch: Throwable -> L346
        r143 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L346
        Throwable r168 = Result.m9452exceptionOrNullimpl(r143);     // Catch: Throwable -> L346
        if (r168 == null) goto L342;
        EnsureManager.ensureNotReachHere(r168);     // Catch: Throwable -> L346
    L342:
        if (Result.m9455isFailureimpl(r143) == false) goto L344;
    L311:
        th = move-exception;
        Result.Companion r169 = Result.Companion;     // Catch: Throwable -> L337
        r156 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L337
        goto L313
    L196:
        if ((r148 instanceof Integer) == true) goto L198;
        Object r170 = null;
    L199:
        r149 = (Integer) r170;     // Catch: Throwable -> L241
        if (r149 != null) goto L239;
        if ((r148 instanceof Number) == false) goto L226;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L211;
        Float r171 = Float.valueOf(((Number) r148).floatValue());     // Catch: Throwable -> L241
        if ((r171 instanceof Integer) == true) goto L209;
        r171 = null;
    L209:
        r149 = (Integer) r171;     // Catch: Throwable -> L241
        goto L239
    L211:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L217;
        Double r172 = Double.valueOf(((Number) r148).doubleValue());     // Catch: Throwable -> L241
        if ((r172 instanceof Integer) == true) goto L215;
        r172 = null;
    L215:
        r149 = (Integer) r172;     // Catch: Throwable -> L241
        goto L239
    L217:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L220;
        r149 = Integer.valueOf(((Number) r148).intValue());     // Catch: Throwable -> L241
        goto L239
    L220:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L226;
        Long r173 = Long.valueOf(((Number) r148).longValue());     // Catch: Throwable -> L241
        if ((r173 instanceof Integer) == true) goto L224;
        r173 = null;
    L224:
        r149 = (Integer) r173;     // Catch: Throwable -> L241
    L226:
        if ((r148 instanceof JSONObject) == false) goto L228;
    L377:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L234
        Object r174 = SDKSettingsCacheManager.a().fromJson(r148.toString(), Integer.class);     // Catch: Throwable -> L234
        if ((r174 instanceof Integer) == true) goto L232;
        r174 = null;
    L232:
        Object r175 = Result.m9449constructorimpl((Integer) r174);     // Catch: Throwable -> L234
    L236:
        r149 = r175;
        if (Result.m9455isFailureimpl(r149) == false) goto L239;
    L234:
        th = move-exception;
        Result.Companion r176 = Result.Companion;     // Catch: Throwable -> L241
        r175 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L241
        goto L236
    L228:
        if ((r148 instanceof JSONArray) == false) goto L238;
    L198:
        r170 = r148;
    L241:
        th = move-exception;
        Result.Companion r177 = Result.Companion;     // Catch: Throwable -> L346
        r150 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L346
    L346:
        th = move-exception;
        Result.Companion r178 = Result.Companion;
        r143 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r179 = Result.m9452exceptionOrNullimpl(r143);
        if (r179 == null) goto L351;
        EnsureManager.ensureNotReachHere(r179);
    L351:
        if (Result.m9455isFailureimpl(r143) == false) goto L189;
        goto L189
    }

    public static boolean i() {
        return ((Boolean) f186143f.getValue()).booleanValue();
    }

    @HostExperimentKey(author = "chenlong.hz", desc = "店铺头图UI优化")
    @SettingReport
    public final int getEC_SHOP_HEADER_UI_OPT() {
        Object r100 = 0;
        Object r101 = null;
        if (Intrinsics.areEqual("ec_shop_header_interaction_opt", "ec_shop_launch_opt_common_2") == false) goto L179;
        if (f186139b != null) goto L173;
        int r102 = n.f45241a;
        int r103 = com.bytedance.android.ec.base.settings.a.f42813a;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L163
        Object r105 = d.f42818c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L57
        if (r105 != null) goto L12;
    L54:
        Object r106 = null;
    L55:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L57
    L59:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);     // Catch: Throwable -> L163
        if (r108 == null) goto L63;
        EnsureManager.ensureNotReachHere(r108);     // Catch: Throwable -> L163
    L63:
        if (Result.m9455isFailureimpl(r107) == false) goto L66;
        r107 = null;
    L66:
        if ((r107 instanceof Integer) == true) goto L68;
        r107 = null;
    L68:
        Object r109 = (Integer) r107;     // Catch: Throwable -> L163
        if (r109 != null) goto L75;
        Object r110 = d.f42816a.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L163
        if ((r110 instanceof Integer) == true) goto L74;
        r110 = null;
    L74:
        r109 = (Integer) r110;     // Catch: Throwable -> L163
    L75:
        if (r109 != null) goto L172;
        int r111 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L163
        Object r112 = d.f42818c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L127
        if (r112 != null) goto L82;
    L124:
        Object r113 = null;
    L125:
        Object r114 = Result.m9449constructorimpl(r113);     // Catch: Throwable -> L127
    L129:
        Throwable r115 = Result.m9452exceptionOrNullimpl(r114);     // Catch: Throwable -> L154
        if (r115 == null) goto L133;
        EnsureManager.ensureNotReachHere(r115);     // Catch: Throwable -> L154
    L133:
        if (Result.m9455isFailureimpl(r114) == false) goto L136;
        r114 = null;
    L136:
        if ((r114 instanceof Integer) == true) goto L138;
        r114 = null;
    L138:
        r109 = (Integer) r114;     // Catch: Throwable -> L154
        if (r109 != null) goto L161;
        IHybridHostService r116 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L154
        if (r116 == null) goto L144;
        Object r117 = r116.getHostABValue("ec_shop_launch_opt_common_2", r100);     // Catch: Throwable -> L154
    L145:
        if (r117 != null) goto L147;
    L160:
        r109 = r100;
        goto L161
    L147:
        if ((r117 instanceof Integer) == false) goto L150;
        r101 = r117;
    L150:
        Integer r118 = (Integer) r101;     // Catch: Throwable -> L154
        if (r118 == null) goto L160;
        r109 = r118;
        goto L161
    L154:
        th = move-exception;
        Result.Companion r119 = Result.Companion;     // Catch: Throwable -> L163
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
        Throwable r120 = Result.m9452exceptionOrNullimpl(r109);     // Catch: Throwable -> L163
        if (r120 == null) goto L159;
        EnsureManager.ensureNotReachHere(r120);     // Catch: Throwable -> L163
    L159:
        if (Result.m9455isFailureimpl(r109) == false) goto L161;
    L144:
        r117 = null;
    L161:
        d.d("ec_shop_launch_opt_common_2", r109);     // Catch: Throwable -> L163
        goto L172
    L82:
        if ((r112 instanceof Integer) == true) goto L84;
        Object r121 = null;
    L85:
        r113 = (Integer) r121;     // Catch: Throwable -> L127
        if (r113 != null) goto L125;
        if ((r112 instanceof Number) == false) goto L112;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r122 = Float.valueOf(((Number) r112).floatValue());     // Catch: Throwable -> L127
        if ((r122 instanceof Integer) == true) goto L95;
        r122 = null;
    L95:
        r113 = (Integer) r122;     // Catch: Throwable -> L127
        goto L125
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r123 = Double.valueOf(((Number) r112).doubleValue());     // Catch: Throwable -> L127
        if ((r123 instanceof Integer) == true) goto L101;
        r123 = null;
    L101:
        r113 = (Integer) r123;     // Catch: Throwable -> L127
        goto L125
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L106;
        r113 = Integer.valueOf(((Number) r112).intValue());     // Catch: Throwable -> L127
        goto L125
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L112;
        Long r124 = Long.valueOf(((Number) r112).longValue());     // Catch: Throwable -> L127
        if ((r124 instanceof Integer) == true) goto L110;
        r124 = null;
    L110:
        r113 = (Integer) r124;     // Catch: Throwable -> L127
    L112:
        if ((r112 instanceof JSONObject) == false) goto L114;
    L366:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L120
        Object r125 = SDKSettingsCacheManager.a().fromJson(r112.toString(), Integer.class);     // Catch: Throwable -> L120
        if ((r125 instanceof Integer) == true) goto L118;
        r125 = null;
    L118:
        Object r126 = Result.m9449constructorimpl((Integer) r125);     // Catch: Throwable -> L120
    L122:
        r113 = r126;
        if (Result.m9455isFailureimpl(r113) == false) goto L125;
    L120:
        th = move-exception;
        Result.Companion r127 = Result.Companion;     // Catch: Throwable -> L127
        r126 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L127
        goto L122
    L114:
        if ((r112 instanceof JSONArray) == false) goto L124;
    L84:
        r121 = r112;
    L127:
        th = move-exception;
        Result.Companion r128 = Result.Companion;     // Catch: Throwable -> L154
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L154
    L172:
        f186139b = (Integer) r109;
        goto L173
    L12:
        if ((r105 instanceof Integer) == true) goto L14;
        Object r129 = null;
    L15:
        r106 = (Integer) r129;     // Catch: Throwable -> L57
        if (r106 != null) goto L55;
        if ((r105 instanceof Number) == false) goto L42;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L27;
        Float r130 = Float.valueOf(((Number) r105).floatValue());     // Catch: Throwable -> L57
        if ((r130 instanceof Integer) == true) goto L25;
        r130 = null;
    L25:
        r106 = (Integer) r130;     // Catch: Throwable -> L57
        goto L55
    L27:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L33;
        Double r131 = Double.valueOf(((Number) r105).doubleValue());     // Catch: Throwable -> L57
        if ((r131 instanceof Integer) == true) goto L31;
        r131 = null;
    L31:
        r106 = (Integer) r131;     // Catch: Throwable -> L57
        goto L55
    L33:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L36;
        r106 = Integer.valueOf(((Number) r105).intValue());     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L42;
        Long r132 = Long.valueOf(((Number) r105).longValue());     // Catch: Throwable -> L57
        if ((r132 instanceof Integer) == true) goto L40;
        r132 = null;
    L40:
        r106 = (Integer) r132;     // Catch: Throwable -> L57
    L42:
        if ((r105 instanceof JSONObject) == false) goto L44;
    L364:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L50
        Object r133 = SDKSettingsCacheManager.a().fromJson(r105.toString(), Integer.class);     // Catch: Throwable -> L50
        if ((r133 instanceof Integer) == true) goto L48;
        r133 = null;
    L48:
        Object r134 = Result.m9449constructorimpl((Integer) r133);     // Catch: Throwable -> L50
    L52:
        r106 = r134;
        if (Result.m9455isFailureimpl(r106) == false) goto L55;
    L50:
        th = move-exception;
        Result.Companion r135 = Result.Companion;     // Catch: Throwable -> L57
        r134 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L52
    L44:
        if ((r105 instanceof JSONArray) == false) goto L54;
    L14:
        r129 = r105;
    L57:
        th = move-exception;
        Result.Companion r136 = Result.Companion;     // Catch: Throwable -> L163
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
    L163:
        th = move-exception;
        Result.Companion r137 = Result.Companion;
        Object r138 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r139 = Result.m9452exceptionOrNullimpl(r138);
        if (r139 == null) goto L168;
        EnsureManager.ensureNotReachHere(r139);
    L168:
        if (Result.m9455isFailureimpl(r138) == true) goto L171;
        r100 = r138;
    L171:
        r109 = r100;
    L173:
        Object r140 = f186139b;
        if (r140 == null) goto L177;
    L354:
        f186138a.put("ec_shop_header_interaction_opt", r140);
        return ((Number) r140).intValue();
    L177:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L179:
        if (Intrinsics.areEqual("HostExperiment", "ShopSetting") == false) goto L190;
        int r141 = p.f45243a;
        Result.Companion r142 = Result.Companion;     // Catch: Throwable -> L185
        jj4.b r143 = jj4.b.f499326b;     // Catch: Throwable -> L185
        r140 = jj4.a.a("ec_shop_header_interaction_opt", Integer.class, r100, false);     // Catch: Throwable -> L185
        if (r140 != null) goto L354;
        Intrinsics.throwNpe();     // Catch: Throwable -> L185
    L185:
        th = move-exception;
        Result.Companion r144 = Result.Companion;
        Object r145 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r145) == true) goto L353;
    L189:
        r100 = r145;
    L353:
        r140 = r100;
        goto L354
    L190:
        int r146 = n.f45241a;
        int r147 = com.bytedance.android.ec.base.settings.a.f42813a;
        Result.Companion r148 = Result.Companion;     // Catch: Throwable -> L347
        Object r149 = d.f42818c.get("ec_shop_header_interaction_opt");     // Catch: Throwable -> L241
        if (r149 != null) goto L196;
    L238:
        Object r150 = null;
    L239:
        Object r151 = Result.m9449constructorimpl(r150);     // Catch: Throwable -> L241
    L243:
        Throwable r152 = Result.m9452exceptionOrNullimpl(r151);     // Catch: Throwable -> L347
        if (r152 == null) goto L247;
        EnsureManager.ensureNotReachHere(r152);     // Catch: Throwable -> L347
    L247:
        if (Result.m9455isFailureimpl(r151) == false) goto L250;
        r151 = null;
    L250:
        if ((r151 instanceof Integer) == true) goto L252;
        r151 = null;
    L252:
        r140 = (Integer) r151;     // Catch: Throwable -> L347
        if (r140 != null) goto L259;
        Object r153 = d.f42816a.get("ec_shop_header_interaction_opt");     // Catch: Throwable -> L347
        if ((r153 instanceof Integer) == true) goto L258;
        r153 = null;
    L258:
        r140 = (Integer) r153;     // Catch: Throwable -> L347
    L259:
        if (r140 != null) goto L354;
        int r154 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L347
        Object r155 = d.f42818c.get("ec_shop_header_interaction_opt");     // Catch: Throwable -> L311
        if (r155 != null) goto L266;
    L308:
        Object r156 = null;
    L309:
        Object r157 = Result.m9449constructorimpl(r156);     // Catch: Throwable -> L311
    L313:
        Throwable r158 = Result.m9452exceptionOrNullimpl(r157);     // Catch: Throwable -> L338
        if (r158 == null) goto L317;
        EnsureManager.ensureNotReachHere(r158);     // Catch: Throwable -> L338
    L317:
        if (Result.m9455isFailureimpl(r157) == false) goto L320;
        r157 = null;
    L320:
        if ((r157 instanceof Integer) == true) goto L322;
        r157 = null;
    L322:
        r140 = (Integer) r157;     // Catch: Throwable -> L338
        if (r140 != null) goto L345;
        IHybridHostService r159 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L338
        if (r159 == null) goto L328;
        Object r160 = r159.getHostABValue("ec_shop_header_interaction_opt", r100);     // Catch: Throwable -> L338
    L329:
        if (r160 != null) goto L331;
    L344:
        r140 = r100;
        goto L345
    L331:
        if ((r160 instanceof Integer) == false) goto L334;
        r101 = r160;
    L334:
        Integer r161 = (Integer) r101;     // Catch: Throwable -> L338
        if (r161 == null) goto L344;
        r140 = r161;
        goto L345
    L338:
        th = move-exception;
        Result.Companion r162 = Result.Companion;     // Catch: Throwable -> L347
        r140 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L347
        Throwable r163 = Result.m9452exceptionOrNullimpl(r140);     // Catch: Throwable -> L347
        if (r163 == null) goto L343;
        EnsureManager.ensureNotReachHere(r163);     // Catch: Throwable -> L347
    L343:
        if (Result.m9455isFailureimpl(r140) == false) goto L345;
    L328:
        r160 = null;
    L345:
        d.d("ec_shop_header_interaction_opt", r140);     // Catch: Throwable -> L347
        goto L354
    L266:
        if ((r155 instanceof Integer) == true) goto L268;
        Object r164 = null;
    L269:
        r156 = (Integer) r164;     // Catch: Throwable -> L311
        if (r156 != null) goto L309;
        if ((r155 instanceof Number) == false) goto L296;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L281;
        Float r165 = Float.valueOf(((Number) r155).floatValue());     // Catch: Throwable -> L311
        if ((r165 instanceof Integer) == true) goto L279;
        r165 = null;
    L279:
        r156 = (Integer) r165;     // Catch: Throwable -> L311
        goto L309
    L281:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L287;
        Double r166 = Double.valueOf(((Number) r155).doubleValue());     // Catch: Throwable -> L311
        if ((r166 instanceof Integer) == true) goto L285;
        r166 = null;
    L285:
        r156 = (Integer) r166;     // Catch: Throwable -> L311
        goto L309
    L287:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L290;
        r156 = Integer.valueOf(((Number) r155).intValue());     // Catch: Throwable -> L311
        goto L309
    L290:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L296;
        Long r167 = Long.valueOf(((Number) r155).longValue());     // Catch: Throwable -> L311
        if ((r167 instanceof Integer) == true) goto L294;
        r167 = null;
    L294:
        r156 = (Integer) r167;     // Catch: Throwable -> L311
    L296:
        if ((r155 instanceof JSONObject) == false) goto L298;
    L380:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L304
        Object r168 = SDKSettingsCacheManager.a().fromJson(r155.toString(), Integer.class);     // Catch: Throwable -> L304
        if ((r168 instanceof Integer) == true) goto L302;
        r168 = null;
    L302:
        Object r169 = Result.m9449constructorimpl((Integer) r168);     // Catch: Throwable -> L304
    L306:
        r156 = r169;
        if (Result.m9455isFailureimpl(r156) == false) goto L309;
    L304:
        th = move-exception;
        Result.Companion r170 = Result.Companion;     // Catch: Throwable -> L311
        r169 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L311
        goto L306
    L298:
        if ((r155 instanceof JSONArray) == false) goto L308;
    L268:
        r164 = r155;
    L311:
        th = move-exception;
        Result.Companion r171 = Result.Companion;     // Catch: Throwable -> L338
        r157 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L338
        goto L313
    L196:
        if ((r149 instanceof Integer) == true) goto L198;
        Object r172 = null;
    L199:
        r150 = (Integer) r172;     // Catch: Throwable -> L241
        if (r150 != null) goto L239;
        if ((r149 instanceof Number) == false) goto L226;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L211;
        Float r173 = Float.valueOf(((Number) r149).floatValue());     // Catch: Throwable -> L241
        if ((r173 instanceof Integer) == true) goto L209;
        r173 = null;
    L209:
        r150 = (Integer) r173;     // Catch: Throwable -> L241
        goto L239
    L211:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L217;
        Double r174 = Double.valueOf(((Number) r149).doubleValue());     // Catch: Throwable -> L241
        if ((r174 instanceof Integer) == true) goto L215;
        r174 = null;
    L215:
        r150 = (Integer) r174;     // Catch: Throwable -> L241
        goto L239
    L217:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L220;
        r150 = Integer.valueOf(((Number) r149).intValue());     // Catch: Throwable -> L241
        goto L239
    L220:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L226;
        Long r175 = Long.valueOf(((Number) r149).longValue());     // Catch: Throwable -> L241
        if ((r175 instanceof Integer) == true) goto L224;
        r175 = null;
    L224:
        r150 = (Integer) r175;     // Catch: Throwable -> L241
    L226:
        if ((r149 instanceof JSONObject) == false) goto L228;
    L378:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L234
        Object r176 = SDKSettingsCacheManager.a().fromJson(r149.toString(), Integer.class);     // Catch: Throwable -> L234
        if ((r176 instanceof Integer) == true) goto L232;
        r176 = null;
    L232:
        Object r177 = Result.m9449constructorimpl((Integer) r176);     // Catch: Throwable -> L234
    L236:
        r150 = r177;
        if (Result.m9455isFailureimpl(r150) == false) goto L239;
    L234:
        th = move-exception;
        Result.Companion r178 = Result.Companion;     // Catch: Throwable -> L241
        r177 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L241
        goto L236
    L228:
        if ((r149 instanceof JSONArray) == false) goto L238;
    L198:
        r172 = r149;
    L241:
        th = move-exception;
        Result.Companion r179 = Result.Companion;     // Catch: Throwable -> L347
        r151 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L347
    L347:
        th = move-exception;
        Result.Companion r180 = Result.Companion;
        r145 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r181 = Result.m9452exceptionOrNullimpl(r145);
        if (r181 == null) goto L352;
        EnsureManager.ensureNotReachHere(r181);
    L352:
        if (Result.m9455isFailureimpl(r145) == false) goto L189;
        goto L189
    }

    @HostExperimentKey(author = "chenlong.hz", desc = "店铺弹窗layout改动")
    @SettingReport
    public final int getEC_SHOP_POPUP_LAYOUT_INFO() {
        Object r100 = 1;
        Object r101 = null;
        if (Intrinsics.areEqual("ec_shop_popup_layout_info", "ec_shop_launch_opt_common_2") == false) goto L179;
        if (f186139b != null) goto L173;
        int r102 = n.f45241a;
        Object r103 = 0;
        int r104 = com.bytedance.android.ec.base.settings.a.f42813a;
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L163
        Object r106 = d.f42818c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L57
        if (r106 != null) goto L12;
    L54:
        Object r107 = null;
    L55:
        Object r108 = Result.m9449constructorimpl(r107);     // Catch: Throwable -> L57
    L59:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);     // Catch: Throwable -> L163
        if (r109 == null) goto L63;
        EnsureManager.ensureNotReachHere(r109);     // Catch: Throwable -> L163
    L63:
        if (Result.m9455isFailureimpl(r108) == false) goto L66;
        r108 = null;
    L66:
        if ((r108 instanceof Integer) == true) goto L68;
        r108 = null;
    L68:
        Object r110 = (Integer) r108;     // Catch: Throwable -> L163
        if (r110 != null) goto L75;
        Object r111 = d.f42816a.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L163
        if ((r111 instanceof Integer) == true) goto L74;
        r111 = null;
    L74:
        r110 = (Integer) r111;     // Catch: Throwable -> L163
    L75:
        if (r110 != null) goto L172;
        int r112 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L163
        Object r113 = d.f42818c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L127
        if (r113 != null) goto L82;
    L124:
        Object r114 = null;
    L125:
        Object r115 = Result.m9449constructorimpl(r114);     // Catch: Throwable -> L127
    L129:
        Throwable r116 = Result.m9452exceptionOrNullimpl(r115);     // Catch: Throwable -> L154
        if (r116 == null) goto L133;
        EnsureManager.ensureNotReachHere(r116);     // Catch: Throwable -> L154
    L133:
        if (Result.m9455isFailureimpl(r115) == false) goto L136;
        r115 = null;
    L136:
        if ((r115 instanceof Integer) == true) goto L138;
        r115 = null;
    L138:
        r110 = (Integer) r115;     // Catch: Throwable -> L154
        if (r110 != null) goto L161;
        IHybridHostService r117 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L154
        if (r117 == null) goto L144;
        Object r118 = r117.getHostABValue("ec_shop_launch_opt_common_2", r103);     // Catch: Throwable -> L154
    L145:
        if (r118 != null) goto L147;
    L160:
        r110 = r103;
        goto L161
    L147:
        if ((r118 instanceof Integer) == false) goto L150;
        r101 = r118;
    L150:
        Integer r119 = (Integer) r101;     // Catch: Throwable -> L154
        if (r119 == null) goto L160;
        r110 = r119;
        goto L161
    L154:
        th = move-exception;
        Result.Companion r120 = Result.Companion;     // Catch: Throwable -> L163
        r110 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
        Throwable r121 = Result.m9452exceptionOrNullimpl(r110);     // Catch: Throwable -> L163
        if (r121 == null) goto L159;
        EnsureManager.ensureNotReachHere(r121);     // Catch: Throwable -> L163
    L159:
        if (Result.m9455isFailureimpl(r110) == false) goto L161;
    L144:
        r118 = null;
    L161:
        d.d("ec_shop_launch_opt_common_2", r110);     // Catch: Throwable -> L163
        goto L172
    L82:
        if ((r113 instanceof Integer) == true) goto L84;
        Object r122 = null;
    L85:
        r114 = (Integer) r122;     // Catch: Throwable -> L127
        if (r114 != null) goto L125;
        if ((r113 instanceof Number) == false) goto L112;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r123 = Float.valueOf(((Number) r113).floatValue());     // Catch: Throwable -> L127
        if ((r123 instanceof Integer) == true) goto L95;
        r123 = null;
    L95:
        r114 = (Integer) r123;     // Catch: Throwable -> L127
        goto L125
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r124 = Double.valueOf(((Number) r113).doubleValue());     // Catch: Throwable -> L127
        if ((r124 instanceof Integer) == true) goto L101;
        r124 = null;
    L101:
        r114 = (Integer) r124;     // Catch: Throwable -> L127
        goto L125
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L106;
        r114 = Integer.valueOf(((Number) r113).intValue());     // Catch: Throwable -> L127
        goto L125
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L112;
        Long r125 = Long.valueOf(((Number) r113).longValue());     // Catch: Throwable -> L127
        if ((r125 instanceof Integer) == true) goto L110;
        r125 = null;
    L110:
        r114 = (Integer) r125;     // Catch: Throwable -> L127
    L112:
        if ((r113 instanceof JSONObject) == false) goto L114;
    L364:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L120
        Object r126 = SDKSettingsCacheManager.a().fromJson(r113.toString(), Integer.class);     // Catch: Throwable -> L120
        if ((r126 instanceof Integer) == true) goto L118;
        r126 = null;
    L118:
        Object r127 = Result.m9449constructorimpl((Integer) r126);     // Catch: Throwable -> L120
    L122:
        r114 = r127;
        if (Result.m9455isFailureimpl(r114) == false) goto L125;
    L120:
        th = move-exception;
        Result.Companion r128 = Result.Companion;     // Catch: Throwable -> L127
        r127 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L127
        goto L122
    L114:
        if ((r113 instanceof JSONArray) == false) goto L124;
    L84:
        r122 = r113;
    L127:
        th = move-exception;
        Result.Companion r129 = Result.Companion;     // Catch: Throwable -> L154
        r115 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L154
    L172:
        f186139b = (Integer) r110;
        goto L173
    L12:
        if ((r106 instanceof Integer) == true) goto L14;
        Object r130 = null;
    L15:
        r107 = (Integer) r130;     // Catch: Throwable -> L57
        if (r107 != null) goto L55;
        if ((r106 instanceof Number) == false) goto L42;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L27;
        Float r131 = Float.valueOf(((Number) r106).floatValue());     // Catch: Throwable -> L57
        if ((r131 instanceof Integer) == true) goto L25;
        r131 = null;
    L25:
        r107 = (Integer) r131;     // Catch: Throwable -> L57
        goto L55
    L27:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L33;
        Double r132 = Double.valueOf(((Number) r106).doubleValue());     // Catch: Throwable -> L57
        if ((r132 instanceof Integer) == true) goto L31;
        r132 = null;
    L31:
        r107 = (Integer) r132;     // Catch: Throwable -> L57
        goto L55
    L33:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L36;
        r107 = Integer.valueOf(((Number) r106).intValue());     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L42;
        Long r133 = Long.valueOf(((Number) r106).longValue());     // Catch: Throwable -> L57
        if ((r133 instanceof Integer) == true) goto L40;
        r133 = null;
    L40:
        r107 = (Integer) r133;     // Catch: Throwable -> L57
    L42:
        if ((r106 instanceof JSONObject) == false) goto L44;
    L362:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L50
        Object r134 = SDKSettingsCacheManager.a().fromJson(r106.toString(), Integer.class);     // Catch: Throwable -> L50
        if ((r134 instanceof Integer) == true) goto L48;
        r134 = null;
    L48:
        Object r135 = Result.m9449constructorimpl((Integer) r134);     // Catch: Throwable -> L50
    L52:
        r107 = r135;
        if (Result.m9455isFailureimpl(r107) == false) goto L55;
    L50:
        th = move-exception;
        Result.Companion r136 = Result.Companion;     // Catch: Throwable -> L57
        r135 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L52
    L44:
        if ((r106 instanceof JSONArray) == false) goto L54;
    L14:
        r130 = r106;
    L57:
        th = move-exception;
        Result.Companion r137 = Result.Companion;     // Catch: Throwable -> L163
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
    L163:
        th = move-exception;
        Result.Companion r138 = Result.Companion;
        Object r139 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r140 = Result.m9452exceptionOrNullimpl(r139);
        if (r140 == null) goto L168;
        EnsureManager.ensureNotReachHere(r140);
    L168:
        if (Result.m9455isFailureimpl(r139) == true) goto L171;
        r103 = r139;
    L171:
        r110 = r103;
    L173:
        r100 = f186139b;
        if (r100 == null) goto L177;
    L352:
        f186138a.put("ec_shop_popup_layout_info", r100);
        return ((Number) r100).intValue();
    L177:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L179:
        if (Intrinsics.areEqual("HostExperiment", "ShopSetting") == false) goto L190;
        int r141 = p.f45243a;
        Result.Companion r142 = Result.Companion;     // Catch: Throwable -> L185
        jj4.b r143 = jj4.b.f499326b;     // Catch: Throwable -> L185
        Object r144 = jj4.a.a("ec_shop_popup_layout_info", Integer.class, r100, false);     // Catch: Throwable -> L185
        if (r144 != null) goto L189;
        Intrinsics.throwNpe();     // Catch: Throwable -> L185
    L189:
        r100 = r144;
    L185:
        th = move-exception;
        Result.Companion r145 = Result.Companion;
        r144 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r144) == false) goto L189;
    L190:
        int r146 = n.f45241a;
        int r147 = com.bytedance.android.ec.base.settings.a.f42813a;
        Result.Companion r148 = Result.Companion;     // Catch: Throwable -> L346
        Object r149 = d.f42818c.get("ec_shop_popup_layout_info");     // Catch: Throwable -> L241
        if (r149 != null) goto L196;
    L238:
        Object r150 = null;
    L239:
        Object r151 = Result.m9449constructorimpl(r150);     // Catch: Throwable -> L241
    L243:
        Throwable r152 = Result.m9452exceptionOrNullimpl(r151);     // Catch: Throwable -> L346
        if (r152 == null) goto L247;
        EnsureManager.ensureNotReachHere(r152);     // Catch: Throwable -> L346
    L247:
        if (Result.m9455isFailureimpl(r151) == false) goto L250;
        r151 = null;
    L250:
        if ((r151 instanceof Integer) == true) goto L252;
        r151 = null;
    L252:
        r144 = (Integer) r151;     // Catch: Throwable -> L346
        if (r144 != null) goto L259;
        Object r153 = d.f42816a.get("ec_shop_popup_layout_info");     // Catch: Throwable -> L346
        if ((r153 instanceof Integer) == true) goto L258;
        r153 = null;
    L258:
        r144 = (Integer) r153;     // Catch: Throwable -> L346
    L259:
        if (r144 != null) goto L189;
        int r154 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L346
        Object r155 = d.f42818c.get("ec_shop_popup_layout_info");     // Catch: Throwable -> L311
        if (r155 != null) goto L266;
    L308:
        Object r156 = null;
    L309:
        Object r157 = Result.m9449constructorimpl(r156);     // Catch: Throwable -> L311
    L313:
        Throwable r158 = Result.m9452exceptionOrNullimpl(r157);     // Catch: Throwable -> L337
        if (r158 == null) goto L317;
        EnsureManager.ensureNotReachHere(r158);     // Catch: Throwable -> L337
    L317:
        if (Result.m9455isFailureimpl(r157) == false) goto L320;
        r157 = null;
    L320:
        if ((r157 instanceof Integer) == true) goto L322;
        r157 = null;
    L322:
        r144 = (Integer) r157;     // Catch: Throwable -> L337
        if (r144 != null) goto L344;
        IHybridHostService r159 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L337
        if (r159 == null) goto L328;
        Object r160 = r159.getHostABValue("ec_shop_popup_layout_info", r100);     // Catch: Throwable -> L337
    L329:
        if (r160 != null) goto L331;
    L343:
        r144 = r100;
        goto L344
    L331:
        if ((r160 instanceof Integer) == false) goto L334;
        r101 = r160;
    L334:
        r144 = (Integer) r101;     // Catch: Throwable -> L337
        if (r144 != null) goto L344;
    L328:
        r160 = null;
    L344:
        d.d("ec_shop_popup_layout_info", r144);     // Catch: Throwable -> L346
        goto L189
    L266:
        if ((r155 instanceof Integer) == true) goto L268;
        Object r161 = null;
    L269:
        r156 = (Integer) r161;     // Catch: Throwable -> L311
        if (r156 != null) goto L309;
        if ((r155 instanceof Number) == false) goto L296;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L281;
        Float r162 = Float.valueOf(((Number) r155).floatValue());     // Catch: Throwable -> L311
        if ((r162 instanceof Integer) == true) goto L279;
        r162 = null;
    L279:
        r156 = (Integer) r162;     // Catch: Throwable -> L311
        goto L309
    L281:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L287;
        Double r163 = Double.valueOf(((Number) r155).doubleValue());     // Catch: Throwable -> L311
        if ((r163 instanceof Integer) == true) goto L285;
        r163 = null;
    L285:
        r156 = (Integer) r163;     // Catch: Throwable -> L311
        goto L309
    L287:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L290;
        r156 = Integer.valueOf(((Number) r155).intValue());     // Catch: Throwable -> L311
        goto L309
    L290:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L296;
        Long r164 = Long.valueOf(((Number) r155).longValue());     // Catch: Throwable -> L311
        if ((r164 instanceof Integer) == true) goto L294;
        r164 = null;
    L294:
        r156 = (Integer) r164;     // Catch: Throwable -> L311
    L296:
        if ((r155 instanceof JSONObject) == false) goto L298;
    L377:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L304
        Object r165 = SDKSettingsCacheManager.a().fromJson(r155.toString(), Integer.class);     // Catch: Throwable -> L304
        if ((r165 instanceof Integer) == true) goto L302;
        r165 = null;
    L302:
        Object r166 = Result.m9449constructorimpl((Integer) r165);     // Catch: Throwable -> L304
    L306:
        r156 = r166;
        if (Result.m9455isFailureimpl(r156) == false) goto L309;
    L304:
        th = move-exception;
        Result.Companion r167 = Result.Companion;     // Catch: Throwable -> L311
        r166 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L311
        goto L306
    L298:
        if ((r155 instanceof JSONArray) == false) goto L308;
    L268:
        r161 = r155;
    L337:
        th = move-exception;
        Result.Companion r168 = Result.Companion;     // Catch: Throwable -> L346
        r144 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L346
        Throwable r169 = Result.m9452exceptionOrNullimpl(r144);     // Catch: Throwable -> L346
        if (r169 == null) goto L342;
        EnsureManager.ensureNotReachHere(r169);     // Catch: Throwable -> L346
    L342:
        if (Result.m9455isFailureimpl(r144) == false) goto L344;
    L311:
        th = move-exception;
        Result.Companion r170 = Result.Companion;     // Catch: Throwable -> L337
        r157 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L337
        goto L313
    L196:
        if ((r149 instanceof Integer) == true) goto L198;
        Object r171 = null;
    L199:
        r150 = (Integer) r171;     // Catch: Throwable -> L241
        if (r150 != null) goto L239;
        if ((r149 instanceof Number) == false) goto L226;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L211;
        Float r172 = Float.valueOf(((Number) r149).floatValue());     // Catch: Throwable -> L241
        if ((r172 instanceof Integer) == true) goto L209;
        r172 = null;
    L209:
        r150 = (Integer) r172;     // Catch: Throwable -> L241
        goto L239
    L211:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L217;
        Double r173 = Double.valueOf(((Number) r149).doubleValue());     // Catch: Throwable -> L241
        if ((r173 instanceof Integer) == true) goto L215;
        r173 = null;
    L215:
        r150 = (Integer) r173;     // Catch: Throwable -> L241
        goto L239
    L217:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L220;
        r150 = Integer.valueOf(((Number) r149).intValue());     // Catch: Throwable -> L241
        goto L239
    L220:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L226;
        Long r174 = Long.valueOf(((Number) r149).longValue());     // Catch: Throwable -> L241
        if ((r174 instanceof Integer) == true) goto L224;
        r174 = null;
    L224:
        r150 = (Integer) r174;     // Catch: Throwable -> L241
    L226:
        if ((r149 instanceof JSONObject) == false) goto L228;
    L375:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L234
        Object r175 = SDKSettingsCacheManager.a().fromJson(r149.toString(), Integer.class);     // Catch: Throwable -> L234
        if ((r175 instanceof Integer) == true) goto L232;
        r175 = null;
    L232:
        Object r176 = Result.m9449constructorimpl((Integer) r175);     // Catch: Throwable -> L234
    L236:
        r150 = r176;
        if (Result.m9455isFailureimpl(r150) == false) goto L239;
    L234:
        th = move-exception;
        Result.Companion r177 = Result.Companion;     // Catch: Throwable -> L241
        r176 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L241
        goto L236
    L228:
        if ((r149 instanceof JSONArray) == false) goto L238;
    L198:
        r171 = r149;
    L241:
        th = move-exception;
        Result.Companion r178 = Result.Companion;     // Catch: Throwable -> L346
        r151 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L346
    L346:
        th = move-exception;
        Result.Companion r179 = Result.Companion;
        r144 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r180 = Result.m9452exceptionOrNullimpl(r144);
        if (r180 == null) goto L351;
        EnsureManager.ensureNotReachHere(r180);
    L351:
        if (Result.m9455isFailureimpl(r144) == false) goto L189;
        goto L189
    }

    static {
        f186148k = new ECShopABSettings();
        f186138a = new ConcurrentHashMap();
        LazyThreadSafetyMode r100 = LazyThreadSafetyMode.PUBLICATION;
        f186141d = LazyKt.lazy(r100, ECShopABSettings$NEW_SHOP_FIRST_SCREEN_METRIC$2.INSTANCE);
        f186142e = LazyKt.lazy(r100, ECShopABSettings$STORE_API_NO_BLOCK$2.INSTANCE);
        f186143f = LazyKt.lazy(r100, ECShopABSettings$STORE_MULTI_VIEW_PAGER$2.INSTANCE);
        f186144g = LazyKt.lazy(r100, ECShopABSettings$SHOP_Q4_PERF_REVERT$2.INSTANCE);
        f186145h = LazyKt.lazy(r100, ECShopABSettings$FIX_VIEW_CONFIGURATION$2.INSTANCE);
        f186146i = LazyKt.lazy(r100, ECShopABSettings$SHOP_Q3_PERF_OPT$2.INSTANCE);
        f186147j = LazyKt.lazy(r100, ECShopABSettings$SHOP_SLICE_FROM_GECKO$2.INSTANCE);
    }

    public static void j() {
        Method[] r100 = ECShopABSettings.class.getDeclaredMethods();
        ArrayList r101 = new ArrayList();
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L24;
        Method r104 = r100[r103];
        if (Modifier.isPublic(r104.getModifiers()) == false) goto L20;
        Annotation[] r105 = r104.getDeclaredAnnotations();
        int r106 = r105.length;
        int r107 = 0;
    L7:
        if (r107 >= r106) goto L12;
        Annotation r108 = r105[r107];
        if (Intrinsics.areEqual(JvmClassMappingKt.getAnnotationClass(r108), Reflection.getOrCreateKotlinClass(SettingReport.class)) == true) goto L13;
        r107 = r107 + 1;
    L13:
        if (r108 == null) goto L20;
        boolean r109 = true;
        if (r104.getParameterTypes().length != 0) goto L17;
        boolean r110 = true;
    L18:
        if (r110 == false) goto L20;
    L21:
        if (r109 == false) goto L23;
        r101.add(r104);
    L23:
        r103 = r103 + 1;
        goto L3
    L17:
        r110 = false;
        goto L18
    L12:
        r108 = null;
    L20:
        r109 = false;
        goto L21
    L24:
        Iterator r111 = r101.iterator();
    L26:
        if (r111.hasNext() == false) goto L28;
        ((Method) r111.next()).invoke(f186148k, new Object[0]);
        goto L26
    }

    public final Map<String, Object> b() {
        if (f186140c == true) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (f186140c == true) goto L10;
        f186148k.getClass();     // Catch: Throwable -> L13
        j();     // Catch: Throwable -> L13
        f186140c = true;     // Catch: Throwable -> L13
    L10:
        ConcurrentHashMap<String, Object> r100 = f186138a;     // Catch: Throwable -> L13
        monitor-exit(this);
        return r100;
    L5:
        return f186138a;
    }
}
