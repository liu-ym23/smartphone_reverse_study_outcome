package com.bytedance.android.shopping.store.router.hybridpage.view;

import com.bytedance.android.ecom.arch.slice.render.SliceRender;
import com.bytedance.android.ecom.arch.slice.render.elements.ElementTypes;

/* JADX INFO: loaded from: classes14.dex */
public final class HybridPageCustomElementManager {
    public static void a() {
        if (i.a("ECShopTagList") == true) goto L6;
        i.b("ECShopTagList");
        SliceRender r100 = SliceRender.f50121o;
        HybridPageCustomElementManager$registerElement$1 r101 = HybridPageCustomElementManager$registerElement$1.INSTANCE;
        r100.getClass();
        ElementTypes.b("ECShopTagList", r101);
    L6:
        if (i.a("ECShopPrice") == true) goto L9;
        i.b("ECShopPrice");
        SliceRender r102 = SliceRender.f50121o;
        HybridPageCustomElementManager$registerElement$2 r103 = HybridPageCustomElementManager$registerElement$2.INSTANCE;
        r102.getClass();
        ElementTypes.b("ECShopPrice", r103);
    L9:
        if (i.a("ECShopScrollText") == true) goto L12;
        i.b("ECShopScrollText");
        SliceRender r104 = SliceRender.f50121o;
        HybridPageCustomElementManager$registerElement$3 r105 = HybridPageCustomElementManager$registerElement$3.INSTANCE;
        r104.getClass();
        ElementTypes.b("ECShopScrollText", r105);
    L12:
        if (i.a("ECShopScrollTagList") == true) goto L14;
        i.b("ECShopScrollTagList");
        SliceRender r106 = SliceRender.f50121o;
        HybridPageCustomElementManager$registerElement$4 r107 = HybridPageCustomElementManager$registerElement$4.INSTANCE;
        r106.getClass();
        ElementTypes.b("ECShopScrollTagList", r107);
    L14:
        SliceRender r108 = SliceRender.f50121o;
        HybridPageCustomElementManager$registerElement$5 r109 = HybridPageCustomElementManager$registerElement$5.INSTANCE;
        r108.getClass();
        ElementTypes.b("ECShopHybridList", r109);
        ElementTypes.b("ECShopUILoading", HybridPageCustomElementManager$registerElement$6.INSTANCE);
    }
}
