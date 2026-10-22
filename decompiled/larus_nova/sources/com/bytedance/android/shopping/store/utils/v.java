package com.bytedance.android.shopping.store.utils;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes14.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f186985a = 0;

    static {
    }

    public static u a(Map r110, Boolean r111) {
        Object r100 = null;
        if (r110 == null) goto L9;
        String r101 = com.bytedance.android.ecom.arch.slice.render.util.b.v(r110, "index", null);
        if (r101 == null) goto L9;
        Integer r102 = StringsKt.toIntOrNull(r101);
        if (r102 == null) goto L9;
        int r103 = r102.intValue();
    L10:
        if (r110 == null) goto L12;
        String r104 = com.bytedance.android.ecom.arch.slice.render.util.b.v(r110, "btm_id", null);
    L13:
        if (r104 != null) goto L15;
        r104 = "";
    L15:
        String r105 = r104;
        if (r110 == null) goto L18;
        Object r112 = r110.get("product");
    L20:
        if ((r112 instanceof Map) == true) goto L22;
        r112 = null;
    L22:
        Map r106 = (Map) r112;
        if (r106 == null) goto L25;
        Object r113 = r106.get("log_extra");
    L27:
        if ((r113 instanceof Map) == true) goto L29;
        r113 = null;
    L29:
        Map r107 = (Map) r113;
        if (r106 == null) goto L32;
        Object r114 = r106.get("biz_extra");
    L34:
        if ((r114 instanceof Map) == true) goto L36;
        r114 = null;
    L36:
        Map r108 = (Map) r114;
        if (r106 == null) goto L39;
        Object r115 = r106.get("base_info");
    L41:
        if ((r115 instanceof Map) == true) goto L43;
        r115 = null;
    L43:
        Map r116 = (Map) r115;
        if (r116 == null) goto L48;
        Object r117 = r116.get("product_id");
        if (r117 == null) goto L48;
        String r118 = r117.toString();
    L49:
        String r109 = com.bytedance.android.shopping.extensions.k.j(r118);
        if (r106 == null) goto L52;
        Object r119 = r106.get("track_info");
    L54:
        if ((r119 instanceof Map) == true) goto L56;
        r119 = null;
    L56:
        Map r120 = (Map) r119;
        if (r120 == null) goto L59;
        Object r121 = r120.get(com.bytedance.android.ec.core.event.a.KEY_STANDARD_CHAIN_PARAM);
    L61:
        if ((r121 instanceof Map) == true) goto L63;
        r121 = null;
    L63:
        Map r122 = (Map) r121;
        if (r111 == null) goto L72;
        boolean r123 = r111.booleanValue();
        int r124 = p.f186940a;
        Intrinsics.checkNotNullParameter(r105, "rawBtm");
        if (r123 == false) goto L68;
        String r125 = r105;
    L69:
        if (r125 == null) goto L72;
        String r126 = r125;
    L73:
        if (r108 == null) goto L75;
        Object r127 = r108.get("detail_url");
    L77:
        if ((r127 instanceof String) == false) goto L81;
        r100 = r127;
    L81:
        return new u(r103, r105, r126, r106, r107, r108, r109, r122, (String) r100);
    L75:
        r127 = null;
        goto L77
    L68:
        r125 = r105 + "_i" + r103;
    L72:
        r126 = r105;
        goto L73
    L59:
        r121 = null;
        goto L61
    L52:
        r119 = null;
    L48:
        r118 = null;
        goto L49
    L39:
        r115 = null;
        goto L41
    L32:
        r114 = null;
        goto L34
    L25:
        r113 = null;
        goto L27
    L18:
        r112 = null;
        goto L20
    L12:
        r104 = null;
    L9:
        r103 = 0;
        goto L10
    }
}
