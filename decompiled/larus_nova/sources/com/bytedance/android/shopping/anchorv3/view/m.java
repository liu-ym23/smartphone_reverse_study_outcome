package com.bytedance.android.shopping.anchorv3.view;

import android.view.View;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes12.dex */
public final class m implements View.OnLongClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AnchorV3GuessULikeProductView f165538a;

    public m(AnchorV3GuessULikeProductView r100) {
        this.f165538a = r100;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r100) {
        AnchorV3GuessULikeProductView r101 = this.f165538a;
        r101.f165440d = com.bytedance.android.ec.core.event.a.VALUE_LONG_CLICK;
        AnchorV3GuessULikeFeedbackView.U5((AnchorV3GuessULikeFeedbackView) r101.a(R.id.anchor_v3_recommend_feedback_view), true, this.f165538a, null, 4);
        return true;
    }
}
