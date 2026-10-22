package com.bytedance.android.live.liveinteract.awemeplay.view;

import com.bytedance.android.live.liveinteract.awemeplay.model.VideoTab;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes46.dex */
public final class g<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveVideoCommentSelectPanelAwemeListFragment f71610a;

    public g(LiveVideoCommentSelectPanelAwemeListFragment r100) {
        this.f71610a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        VideoTab r101 = (VideoTab) r100;
        LiveVideoCommentSelectPanelAwemeListFragment r102 = this.f71610a;
        if (r102.f71581p == false) goto L5;
        r102.T90(r101);
        return;
    L5:
        r102.f71582q = r101;
    }
}
