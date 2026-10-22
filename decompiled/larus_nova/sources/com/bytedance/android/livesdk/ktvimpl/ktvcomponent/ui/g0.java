package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui;

import android.view.ViewTreeObserver;
import android.widget.TextView;

/* JADX INFO: loaded from: classes10.dex */
public final class g0 implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TextView f144471a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i0 f144472b;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        i0 r100 = this.f144472b;
        TextView r101 = this.f144471a;
        i0.a(r100, r101, r101.getWidth(), this.f144471a.getHeight());
        this.f144471a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }

    public g0(TextView r100, i0 r101) {
        this.f144471a = r100;
        this.f144472b = r101;
    }
}
