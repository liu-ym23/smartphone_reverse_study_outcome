package com.bytedance.android.shopping.anchorv3.view;

import com.bytedance.android.ec.core.widget.RoundedFrameLayout;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes12.dex */
public final class v implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AnchorV3RecInShopBoxView f165562a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List f165563b;

    public v(AnchorV3RecInShopBoxView r100, List r101) {
        this.f165562a = r100;
        this.f165563b = r101;
    }

    public final void a() {
        Iterator r100 = this.f165563b.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        AnchorV3RecInShopProductView r101 = (AnchorV3RecInShopProductView) r100.next();
        ((RoundedFrameLayout) r101.a(R.id.rec_in_shop_image_container)).getLayoutParams().height = ((RoundedFrameLayout) r101.a(R.id.rec_in_shop_image_container)).getWidth();
        goto L4
    L6:
        this.f165562a.requestLayout();
        this.f165562a.invalidate();
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
