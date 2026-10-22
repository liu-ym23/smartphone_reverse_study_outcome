package com.bytedance.android.window.shop.product.utils;

import android.util.AndroidRuntimeException;
import android.view.View;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.bst.api.d;
import com.bytedance.android.bst.api.ext.ExtKt;
import com.bytedance.android.bst.api.f;
import com.bytedance.android.bst.api.g;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import com.bytedance.android.window.shop.home.BaseWindowTabViewModel;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import com.bytedance.android.window.shop.product.presenter.group.ECWindowProductCardGroupPresenterBase;
import com.bytedance.android.window.shop.repository.tab.entity.WindowLayoutType;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class WindowBstReport {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f189395a = 0;

    public static abstract class a implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<String, Object> f189396a;

        public abstract void b(String r100, Map<String, ? extends Object> r101);

        public a(Map<String, ? extends Object> r100) {
            Intrinsics.checkNotNullParameter(r100, "extra");
            this.f189396a = r100;
        }

        @Override // com.bytedance.android.bst.api.g
        public final void a(String r100, Map<Object, ? extends Object> r101) {
            Intrinsics.checkNotNullParameter(r100, "eventName");
            Intrinsics.checkNotNullParameter(r101, "params");
            Map<String, Object> r102 = this.f189396a;
            int r103 = WindowBstReport.f189395a;
            b(r100, MapsKt.plus(MapsKt.plus(r102, WindowBstReport.a(r101)), MapsKt.mapOf(TuplesKt.to("use_bst_v2", Boolean.TRUE))));
        }
    }

    public static final class b implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f189397a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ WindowV2ProductItemVO f189398b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f189399c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ECWindowViewModel f189400d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ BaseWindowTabViewModel f189401e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ WindowLayoutType f189402f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ Map f189403g;

        @Override // com.bytedance.android.bst.api.g
        public final void a(String r100, Map<Object, ? extends Object> r101) {
            Intrinsics.checkNotNullParameter(r100, "eventName");
            Intrinsics.checkNotNullParameter(r101, "params");
            if (this.f189399c == false) goto L5;
            r100 = this.f189397a;
        L5:
            ECWindowViewModel r102 = this.f189400d;
            ECWindowProductCardGroupPresenterBase.a r103 = ECWindowProductCardGroupPresenterBase.f189292w;
            BaseWindowTabViewModel r104 = this.f189401e;
            WindowV2ProductItemVO r105 = this.f189398b;
            WindowLayoutType r106 = this.f189402f;
            String r107 = null;
            if ((r104 instanceof BaseWindowTabViewModel) == true) goto L8;
            BaseWindowTabViewModel r108 = null;
        L9:
            if (r108 == null) goto L11;
            r107 = r108.getLastCategoryId();
        L11:
            if (r107 != null) goto L13;
            r107 = "";
        L13:
            Map r109 = MapsKt.plus(ECWindowProductCardGroupPresenterBase.a.b(r103, r102, r104, r105, r106, r107), this.f189403g);
            int r110 = WindowBstReport.f189395a;
            r102.doAnyEventAction(r100, MapsKt.plus(r109, WindowBstReport.a(r101)), new Pair[]{TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_BST_GROUP_TYPE, "product"), TuplesKt.to("bst_tag", "bst_tag"), TuplesKt.to("use_bst_v2", Boolean.TRUE)});
            return;
        L8:
            r108 = r104;
            goto L9
        }

        public b(String r100, WindowV2ProductItemVO r101, boolean r102, ECWindowViewModel r103, BaseWindowTabViewModel r104, WindowLayoutType r105, Map r106) {
            this.f189397a = r100;
            this.f189398b = r101;
            this.f189399c = r102;
            this.f189400d = r103;
            this.f189401e = r104;
            this.f189402f = r105;
            this.f189403g = r106;
        }
    }

    public WindowBstReport() {
    }

    static {
    }

    public static Map a(Map r100) {
        Intrinsics.checkNotNullParameter(r100, "input");
        LinkedHashMap r101 = new LinkedHashMap();
        Iterator r102 = ((LinkedHashMap) r100).entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        Map.Entry r103 = (Map.Entry) r102.next();
        Object r104 = r103.getKey();
        Object r105 = r103.getValue();
        if ((r104 instanceof String) == false) goto L4;
        r101.put(r104, r105);
        goto L4
    L9:
        return r101;
    }

    public static void d(View r100, String r101, WindowV2ProductItemVO r102, com.bytedance.android.window.shop.product.utils.b r103) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "btm");
        Intrinsics.checkNotNullParameter(r102, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r103, "reporter");
        String r104 = r102.f49464b;
        if (r104 != null) goto L6;
        r104 = r102.f49463a;
    L6:
        if (r101.length() != 0) goto L8;
        boolean r105 = true;
    L9:
        if (r105 == false) goto L11;
        ExtKt.b("BstItemCreate", "btm is empty!");
    L11:
        d r106 = new d(r100);
        r106.f41906a = r101;
        r106.f41907b = com.bytedance.android.ec.core.event.a.KEY_CLICK_PRODUCT;
        r106.f41908c = r104;
        r106.f41909d = "shopping";
        r106.f41910e = -1;
        r106.f41911f = r103;
        f.f41925b.getClass();
        f.c(r106);
        return;
    L8:
        r105 = false;
        goto L9
    }

    public static void e(View r100, String r101, WindowV2ProductItemVO r102, c r103) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "btm");
        Intrinsics.checkNotNullParameter(r102, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r103, "reporter");
        String r104 = r102.f49464b;
        if (r104 != null) goto L6;
        r104 = r102.f49463a;
    L6:
        if (r101.length() != 0) goto L8;
        boolean r105 = true;
    L9:
        if (r105 == false) goto L11;
        ExtKt.b("BstItemCreate", "btm is empty!");
    L11:
        d r106 = new d(r100);
        r106.f41906a = r101;
        r106.f41907b = com.bytedance.android.ec.core.event.a.KEY_SHOW_PRODUCT;
        r106.f41908c = r104;
        r106.f41909d = "shopping";
        r106.f41910e = -1;
        r106.f41911f = r103;
        f.f41925b.getClass();
        f.a(r106);
        return;
    L8:
        r105 = false;
        goto L9
    }

    public static void c(View r100, String r101, BtmItemBuilder r102, WindowV2ProductItemVO r103, a r104) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "btm");
        Intrinsics.checkNotNullParameter(r102, "btmItemBuilder");
        Intrinsics.checkNotNullParameter(r103, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r104, "reporter");
        String r105 = r103.f49464b;
        if (r105 != null) goto L6;
        r105 = r103.f49463a;
    L6:
        if (r101.length() != 0) goto L8;
        boolean r106 = true;
    L9:
        if (r106 == false) goto L12;
        if (r102 != null) goto L12;
        ExtKt.b("BstItemCreate", "btm is empty!");
    L12:
        d r107 = new d(r100);
        r107.f41906a = r101;
        r107.f41907b = com.bytedance.android.ec.core.event.a.KEY_CLICK_PRODUCT;
        r107.f41908c = r105;
        r107.f41909d = "shopping";
        r107.f41910e = -1;
        r107.f41911f = r104;
        f.f41925b.getClass();
        f.c(r107);
        return;
    L8:
        r106 = false;
        goto L9
    }

    public static /* synthetic */ void g(View r100, String r110, WindowV2ProductItemVO r111, WindowLayoutType r112, Map r113, ECWindowViewModel r114, BaseWindowTabViewModel r115) {
        f(r100, r110, r111, r112, r113, r114, r115, com.bytedance.android.ec.core.event.a.KEY_CLICK_PRODUCT, false);
    }

    public static /* synthetic */ void i(View r100, String r110, WindowV2ProductItemVO r111, WindowLayoutType r112, Map r113, ECWindowViewModel r114, BaseWindowTabViewModel r115) {
        h(r100, r110, r111, r112, r113, r114, r115, com.bytedance.android.ec.core.event.a.KEY_SHOW_PRODUCT, false);
    }

    public static void f(View r110, String r111, WindowV2ProductItemVO r112, WindowLayoutType r113, Map r114, ECWindowViewModel r115, BaseWindowTabViewModel r116, String r117, boolean r118) {
        Intrinsics.checkNotNullParameter(r110, "view");
        Intrinsics.checkNotNullParameter(r111, "btm");
        Intrinsics.checkNotNullParameter(r112, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r114, "eventParams");
        Intrinsics.checkNotNullParameter(r115, "viewModel");
        Intrinsics.checkNotNullParameter(r116, "tabViewModel");
        Intrinsics.checkNotNullParameter(r117, "eventName");
        b(r110, r117, r111, r112, r113, r114, r115, r116, r118, new WindowBstReport$reportWindowClickByBstV2$1(f.f41925b));
    }

    public static void h(View r110, String r111, WindowV2ProductItemVO r112, WindowLayoutType r113, Map r114, ECWindowViewModel r115, BaseWindowTabViewModel r116, String r117, boolean r118) {
        Intrinsics.checkNotNullParameter(r110, "view");
        Intrinsics.checkNotNullParameter(r111, "btm");
        Intrinsics.checkNotNullParameter(r112, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r114, "eventParams");
        Intrinsics.checkNotNullParameter(r115, "viewModel");
        Intrinsics.checkNotNullParameter(r116, "tabViewModel");
        Intrinsics.checkNotNullParameter(r117, "eventName");
        b(r110, r117, r111, r112, r113, r114, r115, r116, r118, new WindowBstReport$reportWindowShowByBstV2$1(f.f41925b));
    }

    public static void b(View r110, String r111, String r112, WindowV2ProductItemVO r113, WindowLayoutType r114, Map r115, ECWindowViewModel r116, BaseWindowTabViewModel r117, boolean r118, Function1 r210) {
        String r100 = r113.f49464b;
        if (r100 != null) goto L5;
        r100 = r113.f49463a;
    L5:
        String r101 = r100;
        b r119 = new b(r111, r113, r118, r116, r117, r114, r115);
        if (r112.length() != 0) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
        ExtKt.b("BstItemCreate", "btm is empty!");
    L11:
        d r103 = new d(r110);
        r103.f41906a = r112;
        if (r111 == null) goto L16;
        r103.f41907b = r111;
        r103.f41908c = r101;
        r103.f41909d = "shopping";
        r103.f41910e = -1;
        r103.f41911f = r119;
        r210.invoke(r103);
        return;
    L16:
        throw new AndroidRuntimeException("event is empty");
    L8:
        r102 = false;
        goto L9
    }
}
