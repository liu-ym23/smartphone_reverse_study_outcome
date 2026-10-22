package com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.search;

import android.view.View;

/* JADX INFO: loaded from: classes46.dex */
public final class f implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MiniAppChooseSearchFragment f84279a;

    public f(MiniAppChooseSearchFragment r100) {
        this.f84279a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        lp0.a r101 = this.f84279a.f84257e;
        if (r101 == null) goto L8;
        com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.b r102 = r101.getContainer();
        if (r102 == null) goto L9;
        r102.Eq();
        return;
    L9:
        return;
    }
}
