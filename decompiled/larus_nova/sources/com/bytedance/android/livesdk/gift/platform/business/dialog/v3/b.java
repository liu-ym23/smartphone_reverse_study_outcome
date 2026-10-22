package com.bytedance.android.livesdk.gift.platform.business.dialog.v3;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes9.dex */
public final class b implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f127104a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f127105b;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        this.f127104a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        this.f127104a.setScaleX(1.0f);
        this.f127104a.setScaleY(1.0f);
        View r100 = this.f127105b;
        if (r100 == null) goto L8;
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        if (r101 == null) goto L9;
        r101.height = -1;
        return;
    L9:
        return;
    }

    public b(View r100, View r101) {
        this.f127104a = r100;
        this.f127105b = r101;
    }
}
