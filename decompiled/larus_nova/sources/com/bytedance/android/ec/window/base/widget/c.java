package com.bytedance.android.ec.window.base.widget;

import android.graphics.Outline;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewOutlineProvider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class c extends ViewOutlineProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f49934a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f49935b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f49936c;

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View r100, Outline r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "outline");
        r101.setRoundRect(new Rect(0, 0, this.f49935b, this.f49936c), this.f49934a);
    }

    public c(float r100, int r101, int r102) {
        this.f49934a = r100;
        this.f49935b = r101;
        this.f49936c = r102;
    }
}
