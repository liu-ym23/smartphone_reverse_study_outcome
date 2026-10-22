package com.bytedance.android.shopping.card_list.router;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncCacheInflater;
import com.bytedance.android.ec.core.utils.j1;
import com.bytedance.android.ec.opt.asynctask.t;
import com.bytedance.android.shopping.card_list.common_params.CardListContainerConfig;
import com.bytedance.android.shopping.card_list.container.CardListDialogFragment;
import com.bytedance.android.shopping.card_list.container.CardListFragment;
import com.bytedance.android.shopping.card_list.container.init.BaseCardListContainer;
import com.bytedance.android.shopping.card_list.container.init.LauncherBizType;
import com.bytedance.android.shopping.card_list.params.CardPassThroughData;
import com.bytedance.android.shopping.card_list.params.CartPassThroughData;
import com.bytedance.android.shopping.card_list.perf.cache.CardListCacheManager;
import com.bytedance.android.shopping.card_list.utils.CardListCommonLog;
import com.bytedance.android.shopping.card_list.utils.CardListExtentionsKt;
import com.bytedance.android.shopping.card_list.utils.h;
import com.bytedance.android.shopping.card_list.utils.i;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class b implements sc3.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f171739a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f171740b = 0;

    public static final class a {
    }

    static {
    }

    public b() {
    }

    public static void c(Context r110, Uri r210, Map r211) {
        String r100 = UUID.randomUUID().toString();
        String r101 = UriProtector.getQueryParameter(r210, com.bytedance.android.ec.core.event.a.KEY_NEW_SOURCE_TYPE);
        String r102 = "";
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        Map<String, Map<String, Long>> r103 = com.bytedance.android.shopping.card_list.monitor.firstScreen.a.f171697a;
        com.bytedance.android.shopping.card_list.monitor.firstScreen.a.a(r100, r101, CardListExtentionsKt.f(r211, "page_name", ""));
        int r104 = CardListKitStarter.f171729i;
        final CardListKitStarter r105 = CardListKitStarter.a.a(r100, r211);
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r210, "uri");
        ph.a.a(r110);
        String r106 = UriProtector.getQueryParameter(r210, "history_path");
        if (r106 != null) goto L9;
        r106 = "";
    L9:
        if (((Boolean) r105.f171731b.getValue()).booleanValue() == true) goto L16;
        int r107 = k.r(UriProtector.getQueryParameter(r210, "cart_height_percent"), 0);
        if (1 > r107) goto L15;
        if (99 >= r107) goto L16;
    L15:
        String r108 = "CardListActivity";
    L17:
        r105.c(r106, r108);
        String r109 = UriProtector.getQueryParameter(r210, com.bytedance.android.ec.core.event.a.KEY_NEW_SOURCE_TYPE);
        if (r109 == null) goto L21;
        r102 = r109;
    L21:
        r105.f171730a = r102;
        if (CardListExtentionsKt.c(r105.f171737h, "opt_preload_layout", false) == false) goto L24;
        int r111 = cb3.a.f22999a;
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Map<Activity, ShoppingAsyncCacheInflater> r112 = ShoppingAsyncCacheInflater.f45261d;
        ShoppingAsyncCacheInflater.a.a(r110).a().a(R.layout.card_list_nested_container, 1).a(R.layout.card_list_container_layout, 1).commit();
    L24:
        new CardListCacheManager(r105.f171736g, r105.f171730a, r105.f171734e, r105.f171737h).a();
        com.bytedance.android.shopping.card_list.container.init.f r113 = (com.bytedance.android.shopping.card_list.container.init.f) r105.f171733d.getValue();
        if (r113 == null) goto L27;
        r113.d(r110);
    L27:
        com.bytedance.android.shopping.card_list.monitor.firstScreen.a.b(r105.f171736g, "ParseRouterUri");
        CardPassThroughData r114 = r105.b(j1.a(r210));
        com.bytedance.android.shopping.card_list.monitor.firstScreen.a.b(r105.f171736g, "LaunchCardListActivity");
        CardListContainerConfig.a r115 = CardListContainerConfig.Companion;
        Map<String, Object> r116 = r105.f171737h;
        r115.getClass();
        CardListContainerConfig r117 = CardListContainerConfig.a.a(r116);
        Boolean r118 = Boolean.FALSE;
        int r119 = h.f171921a;
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        nj.d r120 = com.bytedance.android.ec.sdk.helper.d.f48119b.getPadSplitService();
        if (r120 == null) goto L32;
        r120.l();
    L32:
        if ((!Intrinsics.areEqual(r118, Boolean.TRUE)) == false) goto L74;
        Context r121 = null;
        r114.setSplitActivityScene(null);
        CartPassThroughData r122 = r114.getCartSchemaData();
        if (r122 == null) goto L36;
        r122.setHeightPercent(k.r(UriProtector.getQueryParameter(r210, "cart_height_percent"), 0));
    L36:
        CartPassThroughData r123 = r114.getCartSchemaData();
        if (r123 != null) goto L39;
    L40:
        HashMap<String, String> r124 = r114.getSchemaParams();
        if (r124 == null) goto L48;
        CartPassThroughData r125 = r114.getCartSchemaData();
        if (r125 == null) goto L45;
        Integer r126 = Integer.valueOf(r125.getHeightPercent());
    L46:
        String r127 = r124.put("cart_height_percent", String.valueOf(r126));
        goto L48
    L45:
        r126 = null;
    L48:
        if (((Boolean) r105.f171731b.getValue()).booleanValue() == true) goto L56;
        int r128 = k.r(UriProtector.getQueryParameter(r210, "cart_height_percent"), 0);
        if (1 <= r128) goto L53;
    L55:
        r117.setPageType("CardListActivity");
        int r129 = BaseCardListContainer.f171516y;
        BaseCardListContainer.a.a(r110, r114, r105.f171736g, r117);
        goto L74
    L53:
        if (99 < r128) goto L55;
    L56:
        Lazy r130 = CardListCommonLog.f171886a;
        CardListCommonLog.a("CardListKitStarter", new CardListKitStarter$openDirectly$2(r105));
        int r131 = BaseCardListContainer.f171516y;
        CardListDialogFragment r132 = BaseCardListContainer.a.b(r114, r105.f171736g, r117);
        if ((r110 instanceof FragmentActivity) == false) goto L60;
        r121 = r110;
    L60:
        FragmentActivity r133 = (FragmentActivity) r121;
        if (r133 != null) goto L63;
        BaseCardListContainer.a.a(r110, r114, r105.f171736g, r117);
        goto L74
    L63:
        if (r133.isDestroyed() == false) goto L65;
    L72:
        r117.setPageType("CardListActivity");
        BaseCardListContainer.a.a(r110, r114, r105.f171736g, r117);
        goto L74
    L65:
        if (r133.isFinishing() == true) goto L72;
        r117.setPageType("CardListDialogFragment");
        FragmentManager r134 = r133.getSupportFragmentManager();
        r134.beginTransaction().remove(r132).commitAllowingStateLoss();
        LandscapeRestrictionOperation r135 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r132, "CardListDialogFragment", r135);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r134, r132, r135) == true) goto L74;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L84
    L71:
        r132.show(r134, "CardListDialogFragment");
        goto L74
    L39:
        if (r123.getHeightPercent() == 0) goto L48;
    L74:
        String r136 = com.bytedance.android.shopping.card_list.monitor.a.f171679a;
        ConcurrentHashMap<String, String> r137 = com.bytedance.android.shopping.base.event.a.f170704a;
        com.bytedance.android.shopping.base.event.a.d(com.bytedance.android.shopping.card_list.monitor.a.f171679a, "schema_parse", "end", null, false, null, 56);
        if (((Boolean) r105.f171732c.getValue()).booleanValue() == false) goto L79;
        Map<String, Map<String, Long>> r138 = com.bytedance.android.shopping.card_list.monitor.firstScreen.a.f171697a;
        com.bytedance.android.shopping.card_list.monitor.firstScreen.a.b(r105.f171736g, "FirstQuery");
        com.bytedance.android.shopping.card_list.container.init.f r139 = (com.bytedance.android.shopping.card_list.container.init.f) r105.f171733d.getValue();
        if (r139 == null) goto L79;
        r139.b(r114, new CardListKitStarter$queryData$1(r105, r114, r117));
    L79:
        Map<String, Map<String, Long>> r140 = com.bytedance.android.shopping.card_list.monitor.firstScreen.a.f171697a;
        com.bytedance.android.shopping.card_list.monitor.firstScreen.a.b(r105.f171736g, "OpenDirectlyEnd");
        if (CardListExtentionsKt.d(r211, "biz_type", 0) != LauncherBizType.CART.ordinal()) goto L82;
        com.bytedance.android.shopping.card_list.monitor.firstScreen.a.b(r100, "CheckParams");
        t.b(new c(r110, r210));
    L82:
        com.bytedance.android.shopping.card_list.monitor.firstScreen.a.b(r100, "RouterOpenEnd");
        return;
    L16:
        r108 = "CardListDialogFragment";
        goto L17
    }

    @Override // sc3.d
    public final CardListFragment a(Context r110, Map r111, Map r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "pageConfig");
        Intrinsics.checkNotNullParameter(r112, "params");
        Integer r100 = CardListExtentionsKt.b(((LinkedHashMap) r111).get("biz_type"));
        if (r100 == null) goto L18;
        int r101 = r100.intValue();
        LauncherBizType[] r102 = LauncherBizType.values();
        int r103 = r102.length;
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L13;
        LauncherBizType r105 = r102[r104];
        if (r105.ordinal() != r101) goto L9;
        boolean r106 = true;
    L10:
        if (r106 == true) goto L14;
        r104 = r104 + 1;
    L14:
        if (r105 == null) goto L17;
        com.bytedance.android.shopping.card_list.monitor.a.b(r105);
        goto L18
    L17:
        throw new IllegalArgumentException("Invalid enum value: " + r101);
    L9:
        r106 = false;
        goto L10
    L13:
        r105 = null;
    L18:
        LinkedHashMap r107 = (LinkedHashMap) r112;
        String r108 = (String) r107.get(com.bytedance.android.ec.core.event.a.KEY_NEW_SOURCE_TYPE);
        if (r108 != null) goto L21;
        r108 = "";
    L21:
        String r109 = UUID.randomUUID().toString();
        Map<String, Map<String, Long>> r113 = com.bytedance.android.shopping.card_list.monitor.firstScreen.a.f171697a;
        com.bytedance.android.shopping.card_list.monitor.firstScreen.a.a(r109, r108, CardListExtentionsKt.f(r111, "page_name", ""));
        com.bytedance.android.shopping.card_list.monitor.firstScreen.a.b(r109, "RouterOpenEnd");
        int r114 = CardListKitStarter.f171729i;
        CardListKitStarter r115 = CardListKitStarter.a.a(r109, r111);
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r112, "params");
        ph.a.a(r110);
        String r116 = (String) r107.get("history_path");
        if (r116 != null) goto L24;
        r116 = (String) r107.get("previous_page");
    L24:
        r115.c(r116, "CardListFragment");
        r115.f171730a = (String) r107.get(com.bytedance.android.ec.core.event.a.KEY_NEW_SOURCE_TYPE);
        new CardListCacheManager(r115.f171736g, r115.f171730a, r115.f171734e, r115.f171737h).a();
        com.bytedance.android.shopping.card_list.container.init.f r117 = (com.bytedance.android.shopping.card_list.container.init.f) r115.f171733d.getValue();
        if (r117 == null) goto L27;
        r117.d(r110);
    L27:
        HashMap<String, String> r118 = new HashMap();
        r118.putAll(r112);
        Unit r119 = Unit.INSTANCE;
        CardPassThroughData r120 = r115.b(r118);
        CardListContainerConfig.a r121 = CardListContainerConfig.Companion;
        Map<String, Object> r122 = r115.f171737h;
        r121.getClass();
        CardListContainerConfig r123 = CardListContainerConfig.a.a(r122);
        r123.setPageType("CardListFragment");
        String r124 = com.bytedance.android.shopping.card_list.monitor.a.f171679a;
        ConcurrentHashMap<String, String> r125 = com.bytedance.android.shopping.base.event.a.f170704a;
        com.bytedance.android.shopping.base.event.a.d(com.bytedance.android.shopping.card_list.monitor.a.f171679a, "schema_parse", "end", null, false, null, 56);
        if (((Boolean) r115.f171732c.getValue()).booleanValue() == false) goto L32;
        com.bytedance.android.shopping.card_list.container.init.f r126 = (com.bytedance.android.shopping.card_list.container.init.f) r115.f171733d.getValue();
        if (r126 == null) goto L32;
        r126.b(r120, new CardListKitStarter$queryData$1(r115, r120, r123));
    L32:
        int r127 = BaseCardListContainer.f171516y;
        String r128 = r115.f171736g;
        Intrinsics.checkNotNullParameter(r120, "params");
        Intrinsics.checkNotNullParameter(r128, "sessionId");
        Intrinsics.checkNotNullParameter(r123, "pageConfig");
        CardListFragment r129 = new CardListFragment();
        Bundle r130 = new Bundle();
        r130.putSerializable("pass_through_data", r120);
        r130.putString("PrefetchSessionId", r128);
        r130.putSerializable(LynxMonitorService.KEY_PAGE_CONFIG, r123);
        r129.setArguments(r130);
        return r129;
    }

    @Override // sc3.d
    public final boolean b(final Context r110, String r111, final Map<String, ? extends Object> r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "schema");
        Intrinsics.checkNotNullParameter(r112, "pageConfig");
        if ((System.currentTimeMillis() - f171739a) >= 1500) goto L6;
        return false;
    L6:
        if (r111.length() != 0) goto L8;
        boolean r100 = true;
    L9:
        if (r100 == false) goto L11;
        return false;
    L11:
        Integer r101 = CardListExtentionsKt.b(((LinkedHashMap) r112).get("biz_type"));
        Context r102 = null;
        if (r101 == null) goto L27;
        int r103 = r101.intValue();
        LauncherBizType[] r104 = LauncherBizType.values();
        int r105 = r104.length;
        int r106 = 0;
    L14:
        if (r106 >= r105) goto L22;
        LauncherBizType r113 = r104[r106];
        if (r113.ordinal() != r103) goto L18;
        boolean r114 = true;
    L19:
        if (r114 == true) goto L23;
        r106 = r106 + 1;
    L23:
        if (r113 == null) goto L26;
        com.bytedance.android.shopping.card_list.monitor.a.b(r113);
        goto L27
    L26:
        throw new IllegalArgumentException("Invalid enum value: " + r103);
    L18:
        r114 = false;
        goto L19
    L22:
        r113 = null;
    L27:
        f171739a = System.currentTimeMillis();
        final Uri r107 = UriProtector.parse(r111);
        if (CardListExtentionsKt.c(r112, "need_check_login", false) == false) goto L39;
        String r108 = UriProtector.getQueryParameter(r107, com.bytedance.android.ec.core.event.a.KEY_NEW_SOURCE_TYPE);
        if (r108 != null) goto L32;
        r108 = "";
    L32:
        final String r109 = r108;
        if ((r110 instanceof Activity) == false) goto L36;
        r102 = r110;
    L36:
        Activity r115 = (Activity) r102;
        if (r115 == null) goto L40;
        int r116 = i.f171922a;
        i.a(r115, r109, new CardListKitPublicService$checkLoginAndOpen$$inlined$let$lambda$1(this, r109, r110, r107, r112), CardListKitPublicService$checkLoginAndOpen$1$2.INSTANCE);
    L40:
        return true;
    L39:
        c(r110, r107, r112);
        goto L40
    L8:
        r100 = false;
        goto L9
    }
}
