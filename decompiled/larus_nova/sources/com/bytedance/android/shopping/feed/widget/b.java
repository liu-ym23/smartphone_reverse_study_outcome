package com.bytedance.android.shopping.feed.widget;

import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes13.dex */
public final class b implements com.bytedance.android.shopping.feed.widget.gesture.b.InterfaceC2609b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FrameLayout f176010a;

    @Override // com.bytedance.android.shopping.feed.widget.gesture.b.InterfaceC2609b
    public final void onAnimationCancel() {
        this.f176010a.removeAllViews();
        this.f176010a.setVisibility(8);
    }

    @Override // com.bytedance.android.shopping.feed.widget.gesture.b.InterfaceC2609b
    public final void onAnimationEnd() {
        this.f176010a.removeAllViews();
        this.f176010a.setVisibility(8);
    }

    public b(FrameLayout r100) {
        this.f176010a = r100;
    }
}
