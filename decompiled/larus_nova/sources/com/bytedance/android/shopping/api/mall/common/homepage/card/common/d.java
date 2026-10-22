package com.bytedance.android.shopping.api.mall.common.homepage.card.common;

import android.graphics.Outline;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewOutlineProvider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class d extends ViewOutlineProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f170307a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f170308b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f170309c;

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View r100, Outline r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "outline");
        r101.setRoundRect(new Rect(0, 0, this.f170308b, this.f170309c), this.f170307a);
    }

    public d(float r100, int r101, int r102) {
        this.f170307a = r100;
        this.f170308b = r101;
        this.f170309c = r102;
    }
}
