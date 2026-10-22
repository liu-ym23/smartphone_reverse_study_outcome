package com.bytedance.android.live.liveinteract.awemeplay.view;

import android.view.View;
import gd0.r;

/* JADX INFO: loaded from: classes46.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveVideoCommentSelectAwemePanelView f71606a;

    public c(LiveVideoCommentSelectAwemePanelView r100) {
        this.f71606a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        r r101 = this.f71606a.f71556m;
        if (r101 == null) goto L6;
        r101.d();
        return;
    }
}
