package com.bytedance.android.shopping.feed.resourcecard.view;

import android.view.View;

/* JADX INFO: loaded from: classes13.dex */
public final class q implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WindowNodeView f175400a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ rd3.a f175401b;

    public q(WindowNodeView r100, rd3.a r101) {
        this.f175400a = r100;
        this.f175401b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        WindowNodeView r101 = this.f175400a;
        rd3.a r102 = this.f175401b;
        int r103 = WindowNodeView.f175344l;
        r101.a(r102, "window_pic", null, null);
    }
}
