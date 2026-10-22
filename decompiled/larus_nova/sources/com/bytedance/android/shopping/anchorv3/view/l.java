package com.bytedance.android.shopping.anchorv3.view;

import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.shopping.widget.PriceView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes12.dex */
public final class l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AnchorV3GuessULikeProductView f165537a;

    public l(AnchorV3GuessULikeProductView r100) {
        this.f165537a = r100;
    }

    public final void a() {
        ((PriceView) this.f165537a.a(R.id.anchorv3_recommend_guess_u_like_price)).setMaxWidth((((FrameLayout) this.f165537a.a(R.id.anchor_v3_guess_u_like_rootview)).getWidth() - ((TextView) this.f165537a.a(R.id.anchorv3_recommend_tv_guess_u_like_sales)).getWidth()) - (this.f165537a.getContext().getResources().getDimensionPixelOffset(R.dimen.commerce_anchor_v3_recommend_price_margin_left) * 3));
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
