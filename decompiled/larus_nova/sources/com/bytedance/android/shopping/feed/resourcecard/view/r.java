package com.bytedance.android.shopping.feed.resourcecard.view;

import android.view.View;

/* JADX INFO: loaded from: classes13.dex */
public final class r implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WindowNodeView f175402a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ rd3.a f175403b;

    public r(WindowNodeView r100, rd3.a r101) {
        this.f175402a = r100;
        this.f175403b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        WindowNodeView r101 = this.f175402a;
        rd3.a r102 = this.f175403b;
        int r103 = WindowNodeView.f175344l;
        r101.a(r102, "entry", null, null);
    }
}
