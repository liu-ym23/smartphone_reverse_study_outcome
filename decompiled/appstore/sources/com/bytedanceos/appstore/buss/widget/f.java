package com.bytedanceos.appstore.buss.widget;

import android.graphics.Outline;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewOutlineProvider;

/* JADX INFO: loaded from: classes2.dex */
public class f extends ViewOutlineProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f9287a;

    public f(float r10) {
        this.f9287a = r10;
    }

    @Override // android.view.ViewOutlineProvider
    public void getOutline(View r10, Outline r11) {
        Rect r12 = new Rect();
        r10.getGlobalVisibleRect(r12);
        r11.setRoundRect(new Rect(0, 0, r12.right - r12.left, r12.bottom - r12.top), this.f9287a);
    }
}
