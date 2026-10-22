package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product;

import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes13.dex */
public final class a implements ViewTreeObserver.OnPreDrawListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseInfoServiceSnapshotTransitionController f181702a;

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        BaseInfoServiceSnapshotTransitionController r100 = this.f181702a;
        BaseInfoServiceSnapshotTransitionController.f r101 = r100.f181598b;
        if (r101 == null) goto L7;
        r100.m(r101);
        return true;
    L7:
        return true;
    }

    public a(BaseInfoServiceSnapshotTransitionController r100) {
        this.f181702a = r100;
    }
}
