package com.bytedance.android.live.liveinteract.awemeplay.view;

import android.widget.ImageView;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import gd0.r;

/* JADX INFO: loaded from: classes46.dex */
public final class b<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveVideoCommentSelectAwemePanelView f71605a;

    public b(LiveVideoCommentSelectAwemePanelView r100) {
        this.f71605a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r110) {
        sd0.a r111 = (sd0.a) r110;
        LiveVideoCommentSelectAwemePanelView r100 = this.f71605a;
        if (r100.f71564u == false) goto L8;
        if (r111 == null) goto L15;
        r r101 = r100.f71556m;
        if (r101 == null) goto L16;
        r101.f(new gd0.b(r111.b(), r111.c(), r111.a(), r111.d(), r111.e(), Integer.valueOf(LiveVideoCommentSelectAwemePanelView.R5(this.f71605a))));
        return;
    L16:
        return;
    L15:
        return;
    L8:
        if (r111 != null) goto L10;
        int r112 = R.drawable.ttlive_video_comment_panel_key_board_ic;
    L11:
        ImageView r102 = r100.f71554k;
        if (r102 == null) goto L18;
        r102.setBackgroundResource(r112);
        return;
    L18:
        return;
    L10:
        r112 = R.drawable.ttlive_video_comment_panel_send_ic;
        goto L11
    }
}
