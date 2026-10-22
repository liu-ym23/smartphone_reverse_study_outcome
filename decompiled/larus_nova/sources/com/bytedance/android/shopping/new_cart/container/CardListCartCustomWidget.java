package com.bytedance.android.shopping.new_cart.container;

import com.bytedance.android.ecom.arch.slice.render.SliceRender;
import com.bytedance.android.ecom.arch.slice.render.elements.ElementTypes;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes13.dex */
public final class CardListCartCustomWidget {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicBoolean f178851a = null;

    static {
        f178851a = new AtomicBoolean(false);
    }

    public static void a(int r100, int r101, int r102) {
        if (f178851a.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        SliceRender r103 = SliceRender.f50121o;
        CardListCartCustomWidget$injectCustomWidget$1 r104 = CardListCartCustomWidget$injectCustomWidget$1.INSTANCE;
        r103.getClass();
        ElementTypes.b("ECCartSlideContainer", r104);
        ElementTypes.b("ECCartCounter", CardListCartCustomWidget$injectCustomWidget$2.INSTANCE);
        ElementTypes.b("ECCartCountDown", CardListCartCustomWidget$injectCustomWidget$3.INSTANCE);
        ElementTypes.b("ECCartTabContainer", CardListCartCustomWidget$injectCustomWidget$4.INSTANCE);
        ElementTypes.b("ECCartLoadingCircle", CardListCartCustomWidget$injectCustomWidget$5.INSTANCE);
        ElementTypes.b("ECCartLynxPendant", CardListCartCustomWidget$injectCustomWidget$6.INSTANCE);
        ElementTypes.b("ECCartProgressView", CardListCartCustomWidget$injectCustomWidget$7.INSTANCE);
        ElementTypes.b("ECCartScrollNumber", CardListCartCustomWidget$injectCustomWidget$8.INSTANCE);
        ElementTypes.b("ECCartBottomButtonContainer", CardListCartCustomWidget$injectCustomWidget$9.INSTANCE);
        ElementTypes.c("yata_cart", CollectionsKt.listOf(new com.bytedance.android.ecom.arch.slice.render.cache.a[]{new fb3.d(), new fb3.e(), new fb3.a(r102), new fb3.c(r100), new fb3.b(r101)}));
    }
}
