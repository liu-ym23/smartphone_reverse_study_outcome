package com.bytedance.android.shopping.abscontainer.common_biz.platform;

import com.bytedance.android.ecom.arch.slice.render.SliceRender;
import com.bytedance.android.ecom.arch.slice.render.elements.ElementTypes;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes12.dex */
public final class SliceTemplateManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicBoolean f164346a = null;

    static {
        f164346a = new AtomicBoolean(false);
    }

    public static void a() {
        if (f164346a.compareAndSet(false, true) == false) goto L6;
        SliceRender r100 = SliceRender.f50121o;
        SliceTemplateManager$injectCustomElements$1 r101 = SliceTemplateManager$injectCustomElements$1.INSTANCE;
        r100.getClass();
        ElementTypes.b("ECBuyNowCounter", r101);
        ElementTypes.b("ECBuyNowMarquee", SliceTemplateManager$injectCustomElements$2.INSTANCE);
        ElementTypes.b("ECBuyNowCountDown", SliceTemplateManager$injectCustomElements$3.INSTANCE);
        ElementTypes.b("SkuTagFlowLayout", SliceTemplateManager$injectCustomElements$4.INSTANCE);
        ElementTypes.b("CircleLoadingView", SliceTemplateManager$injectCustomElements$5.INSTANCE);
        ElementTypes.b("SkuMarqueeView", SliceTemplateManager$injectCustomElements$6.INSTANCE);
        return;
    }
}
