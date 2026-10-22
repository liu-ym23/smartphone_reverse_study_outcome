package com.bytedance.android.shopping.store.slicecard;

import com.bytedance.android.ecom.arch.slice.render.SliceRender;
import com.bytedance.android.ecom.arch.slice.render.elements.ElementTypes;
import com.bytedance.android.shopping.store.router.hybridpage.setting.HybridPageConfigSetting;

/* JADX INFO: loaded from: classes14.dex */
public final class ShopCustomElementManager {
    public static void a() {
        if (HybridPageConfigSetting.f185952d == true) goto L5;
        SliceRender r100 = SliceRender.f50121o;
        ShopCustomElementManager$registerElement$5 r101 = ShopCustomElementManager$registerElement$5.INSTANCE;
        r100.getClass();
        ElementTypes.b("ECShopTagList", r101);
        ElementTypes.b("ECShopPrice", ShopCustomElementManager$registerElement$6.INSTANCE);
        ElementTypes.b("ECShopScrollText", ShopCustomElementManager$registerElement$7.INSTANCE);
        ElementTypes.b("ECShopScrollTagList", ShopCustomElementManager$registerElement$8.INSTANCE);
    L17:
        SliceRender r102 = SliceRender.f50121o;
        ShopCustomElementManager$registerElement$9 r103 = ShopCustomElementManager$registerElement$9.INSTANCE;
        r102.getClass();
        ElementTypes.b("ECShopLivePlayer", r103);
        ElementTypes.b("ECShopMarquee", ShopCustomElementManager$registerElement$10.INSTANCE);
        ElementTypes.b("ECShopSearchBar", ShopCustomElementManager$registerElement$11.INSTANCE);
        ElementTypes.b("ECShopProductFilterButton", ShopCustomElementManager$registerElement$12.INSTANCE);
        ElementTypes.b("ECShopVideoPlayer", ShopCustomElementManager$registerElement$13.INSTANCE);
        ElementTypes.b("ECShopReplayProgressbar", ShopCustomElementManager$registerElement$14.INSTANCE);
        ElementTypes.b("ECShopTrustFloatBarContent", ShopCustomElementManager$registerElement$15.INSTANCE);
        return;
    L5:
        if (com.bytedance.android.shopping.store.router.hybridpage.view.i.a("ECShopTagList") == true) goto L8;
        com.bytedance.android.shopping.store.router.hybridpage.view.i.b("ECShopTagList");
        SliceRender r104 = SliceRender.f50121o;
        ShopCustomElementManager$registerElement$1 r105 = ShopCustomElementManager$registerElement$1.INSTANCE;
        r104.getClass();
        ElementTypes.b("ECShopTagList", r105);
    L8:
        if (com.bytedance.android.shopping.store.router.hybridpage.view.i.a("ECShopPrice") == true) goto L11;
        com.bytedance.android.shopping.store.router.hybridpage.view.i.b("ECShopPrice");
        SliceRender r106 = SliceRender.f50121o;
        ShopCustomElementManager$registerElement$2 r107 = ShopCustomElementManager$registerElement$2.INSTANCE;
        r106.getClass();
        ElementTypes.b("ECShopPrice", r107);
    L11:
        if (com.bytedance.android.shopping.store.router.hybridpage.view.i.a("ECShopScrollText") == true) goto L14;
        com.bytedance.android.shopping.store.router.hybridpage.view.i.b("ECShopScrollText");
        SliceRender r108 = SliceRender.f50121o;
        ShopCustomElementManager$registerElement$3 r109 = ShopCustomElementManager$registerElement$3.INSTANCE;
        r108.getClass();
        ElementTypes.b("ECShopScrollText", r109);
    L14:
        if (com.bytedance.android.shopping.store.router.hybridpage.view.i.a("ECShopScrollTagList") == true) goto L17;
        com.bytedance.android.shopping.store.router.hybridpage.view.i.b("ECShopScrollTagList");
        SliceRender r110 = SliceRender.f50121o;
        ShopCustomElementManager$registerElement$4 r111 = ShopCustomElementManager$registerElement$4.INSTANCE;
        r110.getClass();
        ElementTypes.b("ECShopScrollTagList", r111);
        goto L17
    }
}
