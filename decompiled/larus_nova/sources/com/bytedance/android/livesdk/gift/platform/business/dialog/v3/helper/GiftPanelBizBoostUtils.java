package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import com.google.gson.annotations.JsonAdapter;
import java.lang.reflect.Constructor;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes9.dex */
public final class GiftPanelBizBoostUtils {
    public static d0 A;
    public static final Lazy B = null;
    public static final Lazy C = null;
    public static final Lazy D = null;
    public static final GiftPanelBizBoostUtils E = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f127346a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f127347b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReadOnlyProperty f127348c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ReadOnlyProperty f127349d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ReadOnlyProperty f127350e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ReadOnlyProperty f127351f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ReadOnlyProperty f127352g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ReadOnlyProperty f127353h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ReadOnlyProperty f127354i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ReadOnlyProperty f127355j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final ReadOnlyProperty f127356k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Lazy f127357l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Lazy f127358m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Lazy f127359n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Lazy f127360o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Lazy f127361p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Lazy f127362q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final Lazy f127363r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final Lazy f127364s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final Lazy f127365t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final Lazy f127366u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final Lazy f127367v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final Lazy f127368w = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final Lazy f127369x = null;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static boolean f127370y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final Lazy f127371z = null;

    public GiftPanelBizBoostUtils() {
    }

    public static y b() {
        return (y) f127358m.getValue();
    }

    public static boolean c() {
        return ((Boolean) f127365t.getValue()).booleanValue();
    }

    public static b0 d() {
        return (b0) f127371z.getValue();
    }

    public static boolean e() {
        return ((Boolean) f127366u.getValue()).booleanValue();
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    static {
        KProperty<?>[] r100 = {Reflection.property1(new PropertyReference1Impl(GiftPanelBizBoostUtils.class, "GIFT_PANEL_FREQUENT_CALL_OPT", "getGIFT_PANEL_FREQUENT_CALL_OPT()Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/helper/GiftPanelFrequentCallOpt;", 0)), Reflection.property1(new PropertyReference1Impl(GiftPanelBizBoostUtils.class, "GIFT_PANEL_SYNC_LOAD_WIDGET", "getGIFT_PANEL_SYNC_LOAD_WIDGET()Z", 0)), Reflection.property1(new PropertyReference1Impl(GiftPanelBizBoostUtils.class, "GIFT_PANEL_INIT_STATE_OPT_CONFIG", "getGIFT_PANEL_INIT_STATE_OPT_CONFIG()Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/helper/GiftPanelInitStateOptConfig;", 0)), Reflection.property1(new PropertyReference1Impl(GiftPanelBizBoostUtils.class, "GIFT_PANEL_ASYNC_LOAD_ANNIE_CARD", "getGIFT_PANEL_ASYNC_LOAD_ANNIE_CARD()Z", 0)), Reflection.property1(new PropertyReference1Impl(GiftPanelBizBoostUtils.class, "GIFT_PAGE_LIST_CACHE_ENABLE", "getGIFT_PAGE_LIST_CACHE_ENABLE()Z", 0)), Reflection.property1(new PropertyReference1Impl(GiftPanelBizBoostUtils.class, "RECHARGE_OPEN_GIFT_PANEL_NOT_REFRESH_LIST", "getRECHARGE_OPEN_GIFT_PANEL_NOT_REFRESH_LIST()Z", 0)), Reflection.property1(new PropertyReference1Impl(GiftPanelBizBoostUtils.class, "GIFT_PANEL_ASYNC_TASK_CONFIG", "getGIFT_PANEL_ASYNC_TASK_CONFIG()Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/helper/GiftPanelAsyncTaskConfig;", 0)), Reflection.property1(new PropertyReference1Impl(GiftPanelBizBoostUtils.class, "GIFT_PANEL_MUTATE_EXTERNAL_OPT", "getGIFT_PANEL_MUTATE_EXTERNAL_OPT()Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/helper/GiftPanelMutateOpt;", 0)), Reflection.property1(new PropertyReference1Impl(GiftPanelBizBoostUtils.class, "GIFT_PANEL_DEFAULT_SELECT_ANIMATION_OPT", "getGIFT_PANEL_DEFAULT_SELECT_ANIMATION_OPT()Z", 0)), Reflection.property1(new PropertyReference1Impl(GiftPanelBizBoostUtils.class, "GIFT_PANEL_OPEN_ANIMATION_OPT", "getGIFT_PANEL_OPEN_ANIMATION_OPT()Z", 0))};
        f127346a = r100;
        GiftPanelBizBoostUtils r101 = new GiftPanelBizBoostUtils();
        E = r101;
        Class<?> r110 = ((JsonAdapter) a0.class.getAnnotation(JsonAdapter.class)).value();
        ConcurrentHashMap<Class<?>, Constructor<? extends SerializableObjectJsonAdapterBase>> r111 = vh7.b.f554981a;
        Constructor r112 = r111.get(r110);
        if (r112 != null) goto L12;
        r112 = r110.getConstructor(new Class[0]);
        if (r112 == null) goto L11;
        Constructor<? extends SerializableObjectJsonAdapterBase> r113 = r111.putIfAbsent(r110, (Constructor<? extends SerializableObjectJsonAdapterBase>) r112);
        if (r113 == null) goto L12;
        r112 = r113;
        goto L12
    L11:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L12:
        Object r114 = ((SerializableObjectJsonAdapterBase) r112.newInstance(new Object[0])).createInstance();
        if (r114 == null) goto L59;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r115 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("gift_panel_frequent_call_opt", (a0) r114, a0.class, false);
        f127347b = UltraSettingsManager.a().a(r115.f271017a, r115.f271018b, r115.getType(), r115.f271020d, r100[0]);
        Boolean r116 = Boolean.FALSE;
        Class r117 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r118 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("gift_panel_sync_load_widget", r116, r117, false);
        ReadOnlyProperty r102 = UltraSettingsManager.a().a(r118.f271017a, r118.f271018b, r118.getType(), r118.f271020d, r100[1]);
        f127348c = r102;
        Class<?> r103 = ((JsonAdapter) b0.class.getAnnotation(JsonAdapter.class)).value();
        Constructor<? extends SerializableObjectJsonAdapterBase> r119 = r111.get(r103);
        if (r119 != null) goto L24;
        r119 = r103.getConstructor(new Class[0]);
        if (r119 == null) goto L23;
        Constructor<? extends SerializableObjectJsonAdapterBase> r104 = r111.putIfAbsent(r103, r119);
        if (r104 == null) goto L24;
        r119 = r104;
        goto L24
    L23:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L24:
        Object r105 = r119.newInstance(new Object[0]).createInstance();
        if (r105 == null) goto L57;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r120 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("gift_panel_init_state_opt_config", (b0) r105, b0.class, false);
        f127349d = UltraSettingsManager.a().a(r120.f271017a, r120.f271018b, r120.getType(), r120.f271020d, r100[2]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r106 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("gift_panel_async_load_annie_card", r116, r117, false);
        f127350e = UltraSettingsManager.a().a(r106.f271017a, r106.f271018b, r106.getType(), r106.f271020d, r100[3]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r107 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("gift_page_list_cache_enable", Boolean.TRUE, r117, false);
        f127351f = UltraSettingsManager.a().a(r107.f271017a, r107.f271018b, r107.getType(), r107.f271020d, r100[4]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r108 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("recharge_open_gift_panel_not_refresh_list", r116, r117, false);
        f127352g = UltraSettingsManager.a().a(r108.f271017a, r108.f271018b, r108.getType(), r108.f271020d, r100[5]);
        Class<?> r109 = ((JsonAdapter) y.class.getAnnotation(JsonAdapter.class)).value();
        Constructor<? extends SerializableObjectJsonAdapterBase> r121 = r111.get(r109);
        if (r121 != null) goto L36;
        r121 = r109.getConstructor(new Class[0]);
        if (r121 == null) goto L35;
        Constructor<? extends SerializableObjectJsonAdapterBase> r122 = r111.putIfAbsent(r109, r121);
        if (r122 == null) goto L36;
        r121 = r122;
        goto L36
    L35:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L36:
        Object r123 = r121.newInstance(new Object[0]).createInstance();
        if (r123 == null) goto L55;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r124 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("gift_panel_async_task_config", (y) r123, y.class, false);
        f127353h = UltraSettingsManager.a().a(r124.f271017a, r124.f271018b, r124.getType(), r124.f271020d, r100[6]);
        Class<?> r125 = ((JsonAdapter) d0.class.getAnnotation(JsonAdapter.class)).value();
        Constructor<? extends SerializableObjectJsonAdapterBase> r126 = r111.get(r125);
        if (r126 != null) goto L48;
        r126 = r125.getConstructor(new Class[0]);
        if (r126 == null) goto L47;
        Constructor<? extends SerializableObjectJsonAdapterBase> r127 = r111.putIfAbsent(r125, r126);
        if (r127 == null) goto L48;
        r126 = r127;
        goto L48
    L47:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L48:
        Object r128 = r126.newInstance(new Object[0]).createInstance();
        if (r128 == null) goto L53;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r129 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("gift_panel_mutate_external_opt", (d0) r128, d0.class, false);
        ReadOnlyProperty r130 = UltraSettingsManager.a().a(r129.f271017a, r129.f271018b, r129.getType(), r129.f271020d, r100[7]);
        f127354i = r130;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r131 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("gift_panel_default_select_animation_opt", r116, r117, false);
        f127355j = UltraSettingsManager.a().a(r131.f271017a, r131.f271018b, r131.getType(), r131.f271020d, r100[8]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r132 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("gift_panel_open_animation_opt", r116, r117, false);
        f127356k = UltraSettingsManager.a().a(r132.f271017a, r132.f271018b, r132.getType(), r132.f271020d, r100[9]);
        f127357l = LazyKt.lazy(GiftPanelBizBoostUtils$frequentCallOpt$2.INSTANCE);
        f127358m = LazyKt.lazy(GiftPanelBizBoostUtils$asyncTaskConfig$2.INSTANCE);
        f127359n = LazyKt.lazy(GiftPanelBizBoostUtils$bottomTextOpt$2.INSTANCE);
        f127360o = LazyKt.lazy(GiftPanelBizBoostUtils$logGiftShowOpt$2.INSTANCE);
        f127361p = LazyKt.lazy(GiftPanelBizBoostUtils$aLogOpt$2.INSTANCE);
        f127362q = LazyKt.lazy(GiftPanelBizBoostUtils$wrapDialogIconModelOpt$2.INSTANCE);
        f127363r = LazyKt.lazy(GiftPanelBizBoostUtils$settingReadOpt$2.INSTANCE);
        f127364s = LazyKt.lazy(GiftPanelBizBoostUtils$resourceOpt$2.INSTANCE);
        f127365t = LazyKt.lazy(GiftPanelBizBoostUtils$giftCardSpOpt$2.INSTANCE);
        f127366u = LazyKt.lazy(GiftPanelBizBoostUtils$newListOpt$2.INSTANCE);
        f127367v = LazyKt.lazy(GiftPanelBizBoostUtils$giftBuffShowNow$2.INSTANCE);
        f127368w = LazyKt.lazy(GiftPanelBizBoostUtils$giftShowNowConfig$2.INSTANCE);
        f127369x = LazyKt.lazy(GiftPanelBizBoostUtils$defaultSelectAnimationOpt$2.INSTANCE);
        f127370y = ((Boolean) r102.getValue(r101, r100[1])).booleanValue();
        f127371z = LazyKt.lazy(GiftPanelBizBoostUtils$initStateOpt$2.INSTANCE);
        A = (d0) r130.getValue(r101, r100[7]);
        B = LazyKt.lazy(GiftPanelBizBoostUtils$asyncLoadLynx$2.INSTANCE);
        C = LazyKt.lazy(GiftPanelBizBoostUtils$rechargeOpenGiftPanelNotRefreshList$2.INSTANCE);
        D = LazyKt.lazy(GiftPanelBizBoostUtils$giftPagesCache$2.INSTANCE);
        return;
    L53:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.GiftPanelMutateOpt");
    L55:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.GiftPanelAsyncTaskConfig");
    L57:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.GiftPanelInitStateOptConfig");
    L59:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.GiftPanelFrequentCallOpt");
    }

    public static final a0 a(GiftPanelBizBoostUtils r100) {
        r100.getClass();
        return (a0) f127357l.getValue();
    }
}
