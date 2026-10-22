package com.stepos.widget.menu;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import j4.g;
import j4.k;
import l3.C0847e;

/* loaded from: classes.dex */
public final class StepOSMenuPanel extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    private float f16302a;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSMenuPanel(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        k.g(context, "context");
    }

    public final float getCornerRadius() {
        return this.f16302a;
    }

    public final void setCornerRadius(float f5) {
        if (this.f16302a == f5) {
            return;
        }
        this.f16302a = f5;
        invalidateOutline();
    }

    public /* synthetic */ StepOSMenuPanel(Context context, AttributeSet attributeSet, int i5, int i6, g gVar) {
        this(context, (i6 & 2) != 0 ? null : attributeSet, (i6 & 4) != 0 ? 0 : i5);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepOSMenuPanel(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        k.g(context, "context");
        this.f16302a = context.getResources().getDimension(C0847e.f18353d0);
    }
}
