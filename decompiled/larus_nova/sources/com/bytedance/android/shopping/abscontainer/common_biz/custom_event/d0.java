package com.bytedance.android.shopping.abscontainer.common_biz.custom_event;

import com.bytedance.android.shopping.sku.inner.controller.SkuYataSelfSaveBizFieldsCacheController;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import t43.c;
import u33.a;
import w33.g;

/* JADX INFO: loaded from: classes12.dex */
public final class d0<STATE extends w33.g, PROPS extends u33.a & t43.c> extends m33.a<STATE, PROPS> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f164240b;

    @Override // m33.a
    public final String d() {
        return this.f164240b;
    }

    public d0(l33.b<STATE, PROPS> r100) {
        Intrinsics.checkNotNullParameter(r100, "containerContext");
        super(r100);
        this.f164240b = "selfSaveBizFields";
    }

    @Override // m33.a
    public final void e(e43.a r100) {
        Intrinsics.checkNotNullParameter(r100, "eventData");
        Map<String, Object> r101 = r100.c();
        Object r102 = null;
        if (r101 == null) goto L5;
        Object r103 = r101.get("common_self_save_biz_prefix");
    L7:
        if ((r103 instanceof String) == true) goto L9;
        r103 = null;
    L9:
        String r104 = (String) r103;
        String r105 = "";
        if (r104 != null) goto L12;
        r104 = "";
    L12:
        Map<String, Object> r106 = r100.c();
        if (r106 == null) goto L15;
        Object r107 = r106.get("common_self_save_biz_fields");
    L17:
        if ((r107 instanceof Map) == true) goto L19;
        r107 = null;
    L19:
        Map r108 = (Map) r107;
        if (r108 != null) goto L23;
        r108 = MapsKt.emptyMap();
    L23:
        if (r104.length() != 0) goto L25;
        boolean r109 = true;
    L26:
        if (r109 == false) goto L51;
        Map<String, Object> r110 = r100.a();
        if (r110 == null) goto L30;
        Object r111 = r110.get("common_self_save_biz_prefix");
    L32:
        if ((r111 instanceof String) == true) goto L34;
        r111 = null;
    L34:
        String r112 = (String) r111;
        if (r112 == null) goto L38;
        r105 = r112;
    L38:
        Map<String, Object> r113 = r100.a();
        if (r113 == null) goto L41;
        Object r114 = r113.get("common_self_save_biz_fields");
    L43:
        if ((r114 instanceof Map) == false) goto L46;
        r102 = r114;
    L46:
        Map r115 = (Map) r102;
        if (r115 != null) goto L49;
        r108 = MapsKt.emptyMap();
    L50:
        r104 = r105;
        goto L51
    L49:
        r108 = r115;
        goto L50
    L41:
        r114 = null;
        goto L43
    L30:
        r111 = null;
    L51:
        HashMap r116 = new HashMap();
        Iterator r117 = r108.entrySet().iterator();
    L53:
        if (r117.hasNext() == false) goto L58;
        Map.Entry r118 = (Map.Entry) r117.next();
        String r119 = r104 + '_' + ((String) r118.getKey());
        if (Intrinsics.areEqual((String) r118.getKey(), "time") == true) goto L56;
        r116.put(r119, r118.getValue().toString());
        goto L53
    L56:
        int r120 = j43.d.f497356a;
        r116.put(r119, String.valueOf(System.currentTimeMillis() / ((long) 1000)));
        goto L53
    L58:
        String r121 = ((t43.c) this.f511708a.f507249c).getProductID();
        int r122 = ai3.h.f3736a;
        Intrinsics.checkNotNullParameter(r121, "productId");
        Intrinsics.checkNotNullParameter(r116, "bizFields");
        SkuYataSelfSaveBizFieldsCacheController.b(r121, r116);
        return;
    L25:
        r109 = false;
        goto L26
    L15:
        r107 = null;
        goto L17
    L5:
        r103 = null;
        goto L7
    }
}
