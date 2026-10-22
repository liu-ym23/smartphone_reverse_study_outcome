package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui;

import android.view.ViewTreeObserver;
import android.widget.TextView;

/* JADX INFO: loaded from: classes10.dex */
public final class h0 implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TextView f144474a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i0 f144475b;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        i0 r100 = this.f144475b;
        TextView r101 = this.f144474a;
        i0.a(r100, r101, r101.getWidth(), this.f144474a.getHeight());
        this.f144474a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }

    public h0(TextView r100, i0 r101) {
        this.f144474a = r100;
        this.f144475b = r101;
    }
}
