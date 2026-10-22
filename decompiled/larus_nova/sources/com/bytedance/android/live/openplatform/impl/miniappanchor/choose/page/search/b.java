package com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.search;

import android.view.KeyEvent;
import android.widget.TextView;

/* JADX INFO: loaded from: classes46.dex */
public final class b implements TextView.OnEditorActionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MiniAppChooseSearchFragment f84275a;

    public b(MiniAppChooseSearchFragment r100) {
        this.f84275a = r100;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView r100, int r101, KeyEvent r102) {
        if (r101 != 3) goto L5;
        MiniAppChooseSearchFragment.T90(this.f84275a);
    L5:
        return true;
    }
}
