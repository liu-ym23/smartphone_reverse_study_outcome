package com.bytedance.android.shopping.inflow.view;

import android.graphics.Outline;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewOutlineProvider;

/* JADX INFO: loaded from: classes13.dex */
public final class g extends ViewOutlineProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f176385a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f176386b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f176387c;

    public g() {
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View r100, Outline r101) {
        r101.setRoundRect(new Rect(0, 0, this.f176386b, this.f176387c), this.f176385a);
    }

    public void update(float r100, int r101, int r102) {
        this.f176385a = r100;
        this.f176386b = r101;
        this.f176387c = r102;
    }
}
