package com.bytedance.android.shopping.anchorv3.view;

import android.view.View;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes12.dex */
public final class o implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AnchorV3GuessULikeProductView f165541a;

    public o(AnchorV3GuessULikeProductView r100) {
        this.f165541a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        AnchorV3GuessULikeProductView r101 = this.f165541a;
        r101.f165440d = "click";
        AnchorV3GuessULikeFeedbackView.U5((AnchorV3GuessULikeFeedbackView) r101.a(R.id.anchor_v3_recommend_feedback_view), true, this.f165541a, null, 4);
    }
}
