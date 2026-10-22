package com.bytedance.android.gamecp.business.gamedetail.view.comment;

import android.view.View;
import com.bytedance.android.gamecp.business.comment.adapter.GamePromoteCommentDetailViewHolder;

/* JADX INFO: loaded from: classes44.dex */
public final class t implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GamePromoteCommentDetailAdapterV2 f55865a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ GamePromoteCommentDetailViewHolder f55866b;

    public t(GamePromoteCommentDetailAdapterV2 r100, GamePromoteCommentDetailViewHolder r101) {
        this.f55865a = r100;
        this.f55866b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        GamePromoteCommentDetailAdapterV2 r101 = this.f55865a;
        int r102 = this.f55866b.getAdapterPosition();
        int r103 = this.f55866b.getPosition();
        int r104 = GamePromoteCommentDetailAdapterV2.f55764x;
        r101.E2(r102, r103, false);
    }
}
