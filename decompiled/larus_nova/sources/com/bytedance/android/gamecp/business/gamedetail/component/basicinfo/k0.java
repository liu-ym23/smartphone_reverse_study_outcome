package com.bytedance.android.gamecp.business.gamedetail.component.basicinfo;

import android.view.View;
import com.bytedance.android.gamecp.business.comment.data.GamePromoteCommentViewModel;
import com.bytedance.live.datacontext.DataContext;

/* JADX INFO: loaded from: classes44.dex */
public final class k0 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k0 f53737a = null;

    static {
        f53737a = new k0();
    }

    public k0() {
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        DataContext r101 = com.bytedance.live.datacontext.d.d(GamePromoteCommentViewModel.class);
        if ((r101 instanceof GamePromoteCommentViewModel) == true) goto L5;
        r101 = null;
    L5:
        GamePromoteCommentViewModel r102 = (GamePromoteCommentViewModel) r101;
        if (r102 == null) goto L8;
        r102.setCommentListEnterWay("promote_detail_game_rating");
    L8:
        jv.a.a().b(new com.bytedance.android.gamecp.business.gamedetail.component.nav.q());
    }
}
