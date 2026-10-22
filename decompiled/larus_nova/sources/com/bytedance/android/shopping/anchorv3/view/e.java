package com.bytedance.android.shopping.anchorv3.view;

import android.widget.RelativeLayout;
import com.bytedance.android.shopping.widget.PriceView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes12.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AnchorV3GuessULikeLiveView f165530a;

    public e(AnchorV3GuessULikeLiveView r100) {
        this.f165530a = r100;
    }

    public final void a() {
        int r100 = ((RelativeLayout) this.f165530a.a(R.id.anchor_v3_recommend_product_container)).getWidth() - this.f165530a.getContext().getResources().getDimensionPixelOffset(R.dimen.commerce_anchor_v3_recommend_live_more_btn_size);
        this.f165530a.getContext().getResources().getDimensionPixelOffset(R.dimen.commerce_anchor_v3_recommend_product_padding_left);
        this.f165530a.getContext().getResources().getDimensionPixelOffset(R.dimen.commerce_anchor_v3_recommend_product_padding_right);
        this.f165530a.getContext().getResources().getDimensionPixelOffset(R.dimen.commerce_anchor_v3_recommend_live_price_margin_left);
        ((PriceView) this.f165530a.a(R.id.anchor_v3_tv_product_price)).setMaxWidth(r100);
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
