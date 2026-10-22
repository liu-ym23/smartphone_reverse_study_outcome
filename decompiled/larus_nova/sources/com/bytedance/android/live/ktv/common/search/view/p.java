package com.bytedance.android.live.ktv.common.search.view;

import android.view.KeyEvent;
import android.widget.TextView;

/* JADX INFO: loaded from: classes45.dex */
public final class p implements TextView.OnEditorActionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommonSearchEnterView f70319a;

    public p(CommonSearchEnterView r100) {
        this.f70319a = r100;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView r100, int r101, KeyEvent r102) {
        return CommonSearchEnterView.c(this.f70319a, r101);
    }
}
