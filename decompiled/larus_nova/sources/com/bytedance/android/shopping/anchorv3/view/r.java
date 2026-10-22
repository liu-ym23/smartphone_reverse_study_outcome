package com.bytedance.android.shopping.anchorv3.view;

import android.widget.TextView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes12.dex */
public final class r implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f165553a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AnchorV3GuessULikeProductView f165554b;

    public r(Ref.IntRef r100, AnchorV3GuessULikeProductView r101) {
        this.f165553a = r100;
        this.f165554b = r101;
    }

    public final void a() {
        int r100 = (((this.f165554b.a(R.id.anchor_v3_recommend_reason_info).getWidth() - this.f165554b.getContext().getResources().getDimensionPixelOffset(R.dimen.commerce_anchor_v3_recommend_reason_layout_padding)) - this.f165554b.getContext().getResources().getDimensionPixelOffset(R.dimen.commerce_anchor_v3_recommend_more_btn_size)) - this.f165554b.getContext().getResources().getDimensionPixelOffset(R.dimen.commerce_anchor_v3_recommend_reason_icon_margin)) - this.f165553a.element;
        ((TextView) this.f165554b.a(R.id.anchor_v3_sv_recommend_content)).setMaxWidth(r100);
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
