package com.bytedance.android.ec.core.widget;

import android.graphics.Outline;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewOutlineProvider;

/* JADX INFO: loaded from: classes43.dex */
public final class e0 extends ViewOutlineProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f46084a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f46085b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f46086c;

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View r100, Outline r101) {
        r101.setRoundRect(new Rect(0, 0, this.f46085b, this.f46086c), this.f46084a);
    }

    public e0(float r100, int r101, int r102) {
        this.f46084a = r100;
        this.f46085b = r101;
        this.f46086c = r102;
    }
}
