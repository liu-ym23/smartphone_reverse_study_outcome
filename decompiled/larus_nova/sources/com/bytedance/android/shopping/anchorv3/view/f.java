package com.bytedance.android.shopping.anchorv3.view;

import android.view.View;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes12.dex */
public final class f implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AnchorV3GuessULikeLiveView f165531a;

    public f(AnchorV3GuessULikeLiveView r100) {
        this.f165531a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        AnchorV3GuessULikeLiveView r101 = this.f165531a;
        r101.f165421d = "click";
        AnchorV3GuessULikeFeedbackView.U5((AnchorV3GuessULikeFeedbackView) r101.a(R.id.anchor_v3_recommend_feedback_view), true, this.f165531a, null, 4);
    }
}
