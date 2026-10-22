package com.bytedance.android.shopping.orderlist.common.service;

import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.sdk.helper.g;
import com.bytedance.android.shopping.orderlist.common.monitor.error.b;
import com.bytedance.android.shopping.orderlist.common.utils.i;
import com.bytedance.android.shopping.orderlist.list.starter.NativeOrderListRouter;
import com.bytedance.android.shopping.orderlist.search.starter.NativeOrderSearchResultRouter;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import sc3.h;

/* JADX INFO: loaded from: classes13.dex */
public final class a implements h {

    /* JADX INFO: renamed from: com.bytedance.android.shopping.orderlist.common.service.a$a, reason: collision with other inner class name */
    public static final class C2682a implements b {
        public C2682a() {
        }

        @Override // com.bytedance.android.shopping.orderlist.common.monitor.error.b
        public final void b(String r100, Map<String, ? extends Object> r101) {
            Intrinsics.checkNotNullParameter("ies_ecommerce_fe_custom_log", "name");
            Intrinsics.checkNotNullParameter(r101, "params");
            g.f48122a.logV3("ies_ecommerce_fe_custom_log", new JSONObject(GsonProtectorUtils.toJson(i.a(), r101)));
        }
    }

    public a() {
        Map<String, Boolean> r100 = bf.a.f18801a;
        bf.a.a(new NativeOrderListRouter());
        bf.a.a(new NativeOrderSearchResultRouter());
    }

    @Override // sc3.h
    public final void a(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        HashMap r101 = (HashMap) z1.k(r100);
        Map r102 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("preload_tasks", r101.get("preloadTasks")), TuplesKt.to("preload_biz_scene_priority", r101.get("preloadBizScenePriority"))});
        hg3.b r103 = new hg3.b(null, new C2682a());
        Object r104 = r101.get("trackCommonParams");
        if ((r104 instanceof Map) == true) goto L5;
        r104 = null;
    L5:
        Map<? extends String, ? extends Object> r105 = (Map) r104;
        if (r105 == null) goto L9;
        r103.f485004a.putAll(r105);
    L9:
        new com.bytedance.android.shopping.orderlist.common.controller.h(r102, new com.bytedance.android.shopping.orderlist.common.controller.g(r103, null), new ArrayList()).b();
    }
}
