package com.bytedance.android.live.liveinteract.awemeplay.view;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: classes46.dex */
public final class f<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveVideoCommentSelectPanelAwemeListFragment f71609a;

    public f(LiveVideoCommentSelectPanelAwemeListFragment r100) {
        this.f71609a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        sd0.a r101 = (sd0.a) r100;
        MultiTypeAdapter r102 = this.f71609a.f71579n;
        if (r102 == null) goto L6;
        r102.notifyDataSetChanged();
        return;
    }
}
