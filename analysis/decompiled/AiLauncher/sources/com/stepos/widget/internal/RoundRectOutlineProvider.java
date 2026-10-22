package com.stepos.widget.internal;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/stepos/widget/internal/RoundRectOutlineProvider;", "Landroid/view/ViewOutlineProvider;", "", "cornerRadiusPx", "<init>", "(F)V", "Landroid/view/View;", "view", "Landroid/graphics/Outline;", "outline", "LY8/t;", "getOutline", "(Landroid/view/View;Landroid/graphics/Outline;)V", "F", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RoundRectOutlineProvider extends ViewOutlineProvider {
    private final float cornerRadiusPx;

    public RoundRectOutlineProvider(float f10) {
        this.cornerRadiusPx = f10;
    }

    @Override // android.view.ViewOutlineProvider
    public void getOutline(View view, Outline outline) {
        p.i(view, "view");
        p.i(outline, "outline");
        if (view.getWidth() <= 0 || view.getHeight() <= 0) {
            return;
        }
        float fMin = Math.min(view.getWidth(), view.getHeight()) / 2.0f;
        float f10 = this.cornerRadiusPx;
        if (f10 > 0.0f) {
            fMin = Math.min(f10, fMin);
        }
        outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), fMin);
    }
}
