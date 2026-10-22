package com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.search;

import android.view.View;

/* JADX INFO: loaded from: classes46.dex */
public final class g implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MiniAppChooseSearchFragment f84280a;

    public g(MiniAppChooseSearchFragment r100) {
        this.f84280a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        MiniAppChooseSearchViewModel r101 = this.f84280a.f84258f;
        if (r101 == null) goto L6;
        r101.deleteAllHistory();
        return;
    }
}
