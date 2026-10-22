package com.bytedance.android.ec.store.widget;

import android.graphics.Outline;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewOutlineProvider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a extends ViewOutlineProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f48992a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f48993b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f48994c;

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View r100, Outline r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "outline");
        r101.setRoundRect(new Rect(0, 0, this.f48993b, this.f48994c), this.f48992a);
    }

    public a(float r100, int r101, int r102) {
        this.f48992a = r100;
        this.f48993b = r101;
        this.f48994c = r102;
    }
}
