package com.bytedance.android.live.core.utils;

import android.graphics.Outline;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewOutlineProvider;

/* JADX INFO: loaded from: classes45.dex */
public final class r2 {

    public static class a extends ViewOutlineProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f66266a;

        public a(float r100) {
            this.f66266a = r100;
        }

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View r100, Outline r101) {
            r101.setRoundRect(new Rect(r100.getPaddingLeft(), r100.getPaddingTop(), r100.getWidth() - r100.getPaddingRight(), r100.getHeight() - r100.getPaddingBottom()), this.f66266a);
        }
    }

    public static void a(View r100, int r101) {
        r100.setOutlineProvider(new a(r101));
        r100.setClipToOutline(true);
    }
}
