package com.bytedance.android.shopping.anchorv3.view;

import android.view.View;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes12.dex */
public final class i implements View.OnLongClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AnchorV3GuessULikeLiveView f165534a;

    public i(AnchorV3GuessULikeLiveView r100) {
        this.f165534a = r100;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r100) {
        AnchorV3GuessULikeLiveView r101 = this.f165534a;
        r101.f165421d = com.bytedance.android.ec.core.event.a.VALUE_LONG_CLICK;
        AnchorV3GuessULikeFeedbackView.U5((AnchorV3GuessULikeFeedbackView) r101.a(R.id.anchor_v3_recommend_feedback_view), true, this.f165534a, null, 4);
        return true;
    }
}
