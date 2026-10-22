package com.bytedance.android.shopping.anchorv4.voavhs.detailhead;

import android.view.View;

/* JADX INFO: loaded from: classes13.dex */
public final class s implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f168253a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ExpandableLinearLayoutV4 f168254b;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r100) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r100) {
        this.f168253a.removeOnAttachStateChangeListener(this);
        this.f168254b.getOnBottomViewAttachListener();
    }

    public s(View r100, ExpandableLinearLayoutV4 r101) {
        this.f168253a = r100;
        this.f168254b = r101;
    }
}
