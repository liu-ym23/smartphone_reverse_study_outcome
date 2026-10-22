package com.bytedance.android.shopping.collect.container;

import com.bytedance.android.ecom.arch.slice.render.SliceRender;
import com.bytedance.android.ecom.arch.slice.render.elements.ElementTypes;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes13.dex */
public final class CardListCollectCustomWidget {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicBoolean f172127a = null;

    static {
        f172127a = new AtomicBoolean(false);
    }

    public static void a(int r100, int r101, int r102) {
        if (f172127a.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        SliceRender r103 = SliceRender.f50121o;
        CardListCollectCustomWidget$injectCustomWidget$1 r104 = CardListCollectCustomWidget$injectCustomWidget$1.INSTANCE;
        r103.getClass();
        ElementTypes.b("ECCollectSlideContainer", r104);
        ElementTypes.c("yata_collects", CollectionsKt.listOf(new com.bytedance.android.ecom.arch.slice.render.cache.a[]{new fb3.a(r102), new fb3.c(r100), new fb3.b(r101)}));
    }
}
