package com.bytedance.android.shopping.feed.resourcecard.view;

import android.view.View;

/* JADX INFO: loaded from: classes13.dex */
public final class p implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WindowNodeView f175398a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ rd3.a f175399b;

    public p(WindowNodeView r100, rd3.a r101) {
        this.f175398a = r100;
        this.f175399b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        WindowNodeView r101 = this.f175398a;
        rd3.a r102 = this.f175399b;
        int r103 = WindowNodeView.f175344l;
        r101.a(r102, "name", null, null);
    }
}
