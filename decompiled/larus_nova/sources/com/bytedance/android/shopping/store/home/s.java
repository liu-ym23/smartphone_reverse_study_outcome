package com.bytedance.android.shopping.store.home;

import com.bytedance.android.ec.core.monitor.ECMonitorService;
import com.bytedance.android.ec.store.common.p001const.LiveStyles;
import com.bytedance.android.shopping.store.home.api.ECStoreParam;
import com.bytedance.android.shopping.store.home.preload.data.AIPreloadType;
import com.bytedance.android.shopping.store.hybrid.StoreTabConfig;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, String> f184483a;

    public s() {
        this.f184483a = new ConcurrentHashMap();
    }

    public final void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        this.f184483a.put(r100, r101);
    }

    public final void b(JSONObject r100, StoreTabConfig r101, ECStoreParam r102) {
        String r103 = "0";
        if (r101 == null) goto L9;
        r100.put(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME, r101.getTabName());
        r100.put("tab_type", r101.getTabType());
        if (r101.getDefaultSelected() == false) goto L7;
        Object r104 = "1";
    L8:
        r100.put("flag_default_selected", r104);
        goto L9
    L7:
        r104 = "0";
    L9:
        if (r102 != null) goto L11;
    L65:
        Iterator<Map.Entry<String, String>> r105 = this.f184483a.entrySet().iterator();
    L67:
        if (r105.hasNext() == false) goto L69;
        Map.Entry<String, String> r106 = r105.next();
        r100.put(r106.getKey(), r106.getValue());
        goto L67
    L69:
        return;
    L11:
        if (r102.isPreview() == false) goto L13;
        Object r107 = "1";
    L14:
        r100.put("flag_is_preview", r107);
        if (r102.getStoreUIParam().getHasHeaderLive() == false) goto L17;
        Object r108 = "1";
    L18:
        r100.put("flag_has_header_live", r108);
        if (r102.getStoreUIParam().getHasHeaderVideo() == false) goto L21;
        Object r109 = "1";
    L22:
        r100.put("flag_has_header_video", r109);
        Integer r110 = r102.getStoreUIParam().getLiveStyle();
        int r111 = LiveStyles.FLOATWINDOW.getType();
        if (r110 == null) goto L28;
        if (r110.intValue() != r111) goto L28;
    L31:
        Object r112 = "0";
    L32:
        r100.put("live_show", r112);
        if (r102.isCroppedStyle() == false) goto L35;
        String r113 = "split";
    L36:
        r100.put("modal", r113);
        r100.put("sec_shop_id", r102.getSecShopId());
        r100.put(com.bytedance.android.ec.core.event.a.KEY_SHOP_ID, r102.getShopId());
        r100.put(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_LOCATION, r102.getEntranceLocation());
        AIPreloadType r114 = r102.getInfoAIPreloadType();
        AIPreloadType r115 = AIPreloadType.AI_PRELOAD_EXPIRED;
        if (r114 == r115) goto L39;
    L41:
        AIPreloadType r116 = r102.getInfoAIPreloadType();
        AIPreloadType r117 = AIPreloadType.AI_PRELOAD_SUCCESS;
        if (r116 == r117) goto L44;
    L46:
        r100.put("flag_api_preload_type", r102.getApiPreloadType().getValue());
        if (Intrinsics.areEqual(r102.getFlagHasActivityFloat(), Boolean.TRUE) == false) goto L50;
        r103 = "1";
    L53:
        r100.put("flag_has_activity_float", r103);
        r100.put("shop_type", r102.getShopType());
        Map<String, String> r118 = r102.getLogExtra();
        if (r118 == null) goto L59;
        Iterator<Map.Entry<String, String>> r119 = r118.entrySet().iterator();
    L57:
        if (r119.hasNext() == false) goto L59;
        Map.Entry<String, String> r120 = r119.next();
        r100.put(r120.getKey(), r120.getValue());
    L59:
        Map<String, String> r121 = r102.getTabPerfLogExtra();
        if (r121 == null) goto L65;
        Iterator<Map.Entry<String, String>> r122 = r121.entrySet().iterator();
    L63:
        if (r122.hasNext() == false) goto L65;
        Map.Entry<String, String> r123 = r122.next();
        r100.put(r123.getKey(), r123.getValue());
        goto L63
    L50:
        if (Intrinsics.areEqual(r102.getFlagHasActivityFloat(), Boolean.FALSE) == true) goto L53;
        r103 = null;
        goto L53
    L44:
        if (r102.getTabAIPreloadType() != r117) goto L46;
        r100.put("flag_hit_ai_preload", "1");
        goto L46
    L39:
        if (r102.getTabAIPreloadType() != r115) goto L41;
        r100.put("ai_preload_cache_invalid", "1");
        goto L41
    L35:
        r113 = "full";
    L28:
        if (r102.getStoreUIParam().getHasHeaderLive() == false) goto L31;
        r112 = "1";
        goto L32
    L21:
        r109 = "0";
        goto L22
    L17:
        r108 = "0";
        goto L18
    L13:
        r107 = "0";
        goto L14
    }

    public static void c(s r100, String r101, StoreTabConfig r102, ECStoreParam r103, JSONObject r104, JSONObject r105, int r106) {
        if ((r106 & 2) == 0) goto L6;
        r102 = null;
    L6:
        if ((r106 & 4) == 0) goto L9;
        r103 = null;
    L9:
        if ((r106 & 8) == 0) goto L12;
        r104 = null;
    L12:
        if ((r106 & 16) == 0) goto L14;
        r105 = null;
    L14:
        Intrinsics.checkNotNullParameter(r101, "eventName");
        int r107 = ECMonitorService.f45110b;
        if (r104 != null) goto L17;
        r104 = new JSONObject();
    L17:
        r100.b(r104, r102, r103);
        Unit r108 = Unit.INSTANCE;
        ECMonitorService.a.a(r101, r104, r105, null);
    }
}
