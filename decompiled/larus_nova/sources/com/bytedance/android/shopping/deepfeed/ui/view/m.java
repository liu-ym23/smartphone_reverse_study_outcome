package com.bytedance.android.shopping.deepfeed.ui.view;

import android.view.View;

/* JADX INFO: loaded from: classes13.dex */
public final class m implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DeepFeedTopBarManager f173959a;

    public m(DeepFeedTopBarManager r100) {
        this.f173959a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        DeepFeedTopBarManager.a(this.f173959a);
    }
}
