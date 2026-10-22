package com.bytedance.android.shopping.anchorv3.detail.widget;

import android.graphics.Outline;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewOutlineProvider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class g extends ViewOutlineProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f164926a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f164927b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f164928c;

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View r100, Outline r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "outline");
        r101.setRoundRect(new Rect(0, 0, this.f164927b, this.f164928c), this.f164926a);
    }

    public g(float r100, int r101, int r102) {
        this.f164926a = r100;
        this.f164927b = r101;
        this.f164928c = r102;
    }
}
