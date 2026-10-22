package com.google.android.material.shape;

import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes2.dex */
class InterpolateOnScrollPositionChangeHelper$1 implements ViewTreeObserver.OnScrollChangedListener {
    final /* synthetic */ g this$0;

    InterpolateOnScrollPositionChangeHelper$1(g r1) {
        this.this$0 = r1;
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public void onScrollChanged() {
        this.this$0.a();
    }
}
