package com.bytedance.android.ec.store.window;

import android.view.View;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.bst.api.ext.ExtKt;
import com.bytedance.android.ec.store.repository.vo.ShopSlcProductItemV2;
import com.bytedance.android.ec.store.repository.vo.StoreV2ProductItemVO;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f49004a = 0;

    public static abstract class a implements com.bytedance.android.bst.api.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<String, Object> f49005a;

        public abstract void b(String r100, Map<String, ? extends Object> r101);

        public a(Map<String, ? extends Object> r100) {
            Intrinsics.checkNotNullParameter(r100, "extra");
            this.f49005a = r100;
        }

        @Override // com.bytedance.android.bst.api.g
        public final void a(String r100, Map<Object, ? extends Object> r101) {
            Intrinsics.checkNotNullParameter(r100, "eventName");
            Intrinsics.checkNotNullParameter(r101, "params");
            Map<String, Object> r102 = this.f49005a;
            int r103 = f.f49004a;
            Intrinsics.checkNotNullParameter(r101, "input");
            LinkedHashMap r104 = new LinkedHashMap();
            Iterator r105 = ((LinkedHashMap) r101).entrySet().iterator();
        L4:
            if (r105.hasNext() == false) goto L9;
            Map.Entry r106 = (Map.Entry) r105.next();
            Object r107 = r106.getKey();
            Object r108 = r106.getValue();
            if ((r107 instanceof String) == false) goto L4;
            r104.put(r107, r108);
            goto L4
        L9:
            b(r100, MapsKt.plus(MapsKt.plus(r102, r104), MapsKt.mapOf(TuplesKt.to("use_bst_v2", Boolean.TRUE))));
        }
    }

    static {
    }

    public static g a(Map r100, com.bytedance.android.ec.core.event.c r101) {
        Intrinsics.checkNotNullParameter(r100, "eventParams");
        Intrinsics.checkNotNullParameter(r101, "reporter");
        return new g(r101, r100, r100);
    }

    public static void b(View r100, String r101, ShopSlcProductItemV2 r102, Map r103, com.bytedance.android.ec.core.event.c r104) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "btm");
        Intrinsics.checkNotNullParameter(r102, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r104, "reporter");
        g r105 = a(r103, r104);
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "btm");
        Intrinsics.checkNotNullParameter(r102, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r105, "reporter");
        String r106 = r102.f48407k;
        if (r106 != null) goto L6;
        r106 = r102.f48406j;
    L6:
        if (r101.length() != 0) goto L8;
        boolean r107 = true;
    L9:
        if (r107 == false) goto L11;
        ExtKt.b("BstItemCreate", "btm is empty!");
    L11:
        com.bytedance.android.bst.api.d r108 = new com.bytedance.android.bst.api.d(r100);
        r108.f41906a = r101;
        r108.f41907b = com.bytedance.android.ec.core.event.a.KEY_CLICK_PRODUCT;
        r108.f41908c = r106;
        r108.f41909d = "shopping";
        r108.f41910e = -1;
        r108.f41911f = r105;
        com.bytedance.android.bst.api.f.f41925b.getClass();
        com.bytedance.android.bst.api.f.c(r108);
        return;
    L8:
        r107 = false;
        goto L9
    }

    public static void c(View r100, String r101, StoreV2ProductItemVO r102, Map r103, com.bytedance.android.ec.core.event.c r104) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "btm");
        Intrinsics.checkNotNullParameter(r102, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r104, "reporter");
        g r105 = a(r103, r104);
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "btm");
        Intrinsics.checkNotNullParameter(r102, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r105, "reporter");
        String r106 = r102.f48422b;
        if (r106 != null) goto L6;
        r106 = r102.f48421a;
    L6:
        if (r101.length() != 0) goto L8;
        boolean r107 = true;
    L9:
        if (r107 == false) goto L11;
        ExtKt.b("BstItemCreate", "btm is empty!");
    L11:
        com.bytedance.android.bst.api.d r108 = new com.bytedance.android.bst.api.d(r100);
        r108.f41906a = r101;
        r108.f41907b = com.bytedance.android.ec.core.event.a.KEY_CLICK_PRODUCT;
        r108.f41908c = r106;
        r108.f41909d = "shopping";
        r108.f41910e = -1;
        r108.f41911f = r105;
        com.bytedance.android.bst.api.f.f41925b.getClass();
        com.bytedance.android.bst.api.f.c(r108);
        return;
    L8:
        r107 = false;
        goto L9
    }

    public static void d(View r100, String r101, ShopSlcProductItemV2 r102, Map r103, com.bytedance.android.ec.core.event.c r104) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "btm");
        Intrinsics.checkNotNullParameter(r102, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r104, "reporter");
        Intrinsics.checkNotNullParameter(r103, "eventParams");
        Intrinsics.checkNotNullParameter(r104, "reporter");
        h r105 = new h(r104, r103, r103);
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "btm");
        Intrinsics.checkNotNullParameter(r102, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r105, "reporter");
        String r106 = r102.f48407k;
        if (r106 != null) goto L6;
        r106 = r102.f48406j;
    L6:
        if (r101.length() != 0) goto L8;
        boolean r107 = true;
    L9:
        if (r107 == false) goto L11;
        ExtKt.b("BstItemCreate", "btm is empty!");
    L11:
        com.bytedance.android.bst.api.d r108 = new com.bytedance.android.bst.api.d(r100);
        r108.f41906a = r101;
        r108.f41907b = com.bytedance.android.ec.core.event.a.KEY_SHOW_PRODUCT;
        r108.f41908c = r106;
        r108.f41909d = "shopping";
        r108.f41910e = -1;
        r108.f41911f = r105;
        com.bytedance.android.bst.api.f.f41925b.getClass();
        com.bytedance.android.bst.api.f.a(r108);
        return;
    L8:
        r107 = false;
        goto L9
    }

    public static void e(View r100, String r101, StoreV2ProductItemVO r102, Map r103, com.bytedance.android.ec.core.event.c r104) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "btm");
        Intrinsics.checkNotNullParameter(r102, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r104, "reporter");
        Intrinsics.checkNotNullParameter(r103, "eventParams");
        Intrinsics.checkNotNullParameter(r104, "reporter");
        h r105 = new h(r104, r103, r103);
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "btm");
        Intrinsics.checkNotNullParameter(r102, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r105, "reporter");
        String r106 = r102.f48422b;
        if (r106 != null) goto L6;
        r106 = r102.f48421a;
    L6:
        if (r101.length() != 0) goto L8;
        boolean r107 = true;
    L9:
        if (r107 == false) goto L11;
        ExtKt.b("BstItemCreate", "btm is empty!");
    L11:
        com.bytedance.android.bst.api.d r108 = new com.bytedance.android.bst.api.d(r100);
        r108.f41906a = r101;
        r108.f41907b = com.bytedance.android.ec.core.event.a.KEY_SHOW_PRODUCT;
        r108.f41908c = r106;
        r108.f41909d = "shopping";
        r108.f41910e = -1;
        r108.f41911f = r105;
        com.bytedance.android.bst.api.f.f41925b.getClass();
        com.bytedance.android.bst.api.f.a(r108);
        return;
    L8:
        r107 = false;
        goto L9
    }

    public static void f(View r100, String r101, String r102, Map r103, com.bytedance.android.ec.core.event.c r104) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "btm");
        Intrinsics.checkNotNullParameter(r102, "uniqueKey");
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r104, "reporter");
        Intrinsics.checkNotNullParameter(r103, "eventParams");
        Intrinsics.checkNotNullParameter(r104, "reporter");
        h r105 = new h(r104, r103, r103);
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "btm");
        Intrinsics.checkNotNullParameter(r102, "uniqueKey");
        Intrinsics.checkNotNullParameter(r105, "reporter");
        if (r101.length() != 0) goto L5;
        boolean r106 = true;
    L6:
        if (r106 == false) goto L8;
        ExtKt.b("BstItemCreate", "btm is empty!");
    L8:
        com.bytedance.android.bst.api.d r107 = new com.bytedance.android.bst.api.d(r100);
        r107.f41906a = r101;
        r107.f41907b = com.bytedance.android.ec.core.event.a.KEY_SHOW_PRODUCT;
        r107.f41908c = r102;
        r107.f41909d = "shopping";
        r107.f41910e = -1;
        r107.f41911f = r105;
        com.bytedance.android.bst.api.f.f41925b.getClass();
        com.bytedance.android.bst.api.f.a(r107);
        return;
    L5:
        r106 = false;
        goto L6
    }
}
