package com.bytedance.android.shopping.buynow.widgets;

import android.view.View;
import com.bytedance.android.shopping.extensions.k;
import la3.d;

/* JADX INFO: loaded from: classes13.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BuyNowErrorView f171253a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f171254b;

    public a(BuyNowErrorView r100, d r101) {
        this.f171253a = r100;
        this.f171254b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        BuyNowErrorView r101 = this.f171253a;
        String r102 = this.f171254b.a();
        Integer r103 = this.f171254b.c();
        int r104 = BuyNowErrorView.f171240d;
        r101.getClass();
        if (r102 == null) goto L43;
        int r105 = r102.hashCode();
        if (r105 == (-934396624)) goto L30;
        if (r105 == 1085444827) goto L11;
        return;
    L11:
        if (r102.equals("refresh") == true) goto L13;
        return;
    L13:
        if (k.h(r101.f171243c) > 0) goto L16;
        r101.f171243c = Long.valueOf(System.currentTimeMillis());
    L16:
        if (k.f(r103) > 0) goto L18;
        BuyNowErrorView.a r106 = r101.f171242b;
        if (r106 == null) goto L39;
        r106.a();
        return;
    L39:
        return;
    L18:
        if (k.h(Long.valueOf(System.currentTimeMillis() - k.h(r101.f171243c))) > k.f(r103)) goto L22;
        BuyNowErrorView.a r107 = r101.f171242b;
        if (r107 == null) goto L36;
        r107.b();
        return;
    L36:
        return;
    L22:
        BuyNowErrorView.a r108 = r101.f171242b;
        if (r108 == null) goto L25;
        r108.a();
    L25:
        r101.f171243c = 0L;
        return;
    L30:
        if (r102.equals("return") == false) goto L41;
        BuyNowErrorView.a r109 = r101.f171242b;
        if (r109 == null) goto L42;
        r109.onQuit();
        return;
    L42:
        return;
    L41:
        return;
    }
}
