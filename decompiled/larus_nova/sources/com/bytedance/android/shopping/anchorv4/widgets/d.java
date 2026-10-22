package com.bytedance.android.shopping.anchorv4.widgets;

import android.graphics.Outline;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewOutlineProvider;

/* JADX INFO: loaded from: classes13.dex */
public final class d extends ViewOutlineProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f170183a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f170184b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f170185c;

    public d() {
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View r100, Outline r101) {
        r101.setRoundRect(new Rect(0, 0, this.f170184b, this.f170185c), this.f170183a);
    }

    public void update(float r100, int r101, int r102) {
        this.f170183a = r100;
        this.f170184b = r101;
        this.f170185c = r102;
    }
}
