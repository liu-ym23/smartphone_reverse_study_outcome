package com.zyql.ai.selector.widget;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;

/* loaded from: classes4.dex */
public class MScroller extends Scroller {
    private static final Interpolator sInterpolator = new Interpolator() { // from class: com.zyql.ai.selector.widget.b
        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float f10) {
            return MScroller.a(f10);
        }
    };
    public boolean noDuration;

    public MScroller(Context context) {
        this(context, sInterpolator);
    }

    public static /* synthetic */ float a(float f10) {
        float f11 = f10 - 1.0f;
        return (f11 * f11 * f11 * f11 * f11) + 1.0f;
    }

    public void setNoDuration(boolean z10) {
        this.noDuration = z10;
    }

    @Override // android.widget.Scroller
    public void startScroll(int i10, int i11, int i12, int i13, int i14) {
        if (this.noDuration) {
            super.startScroll(i10, i11, i12, i13, 0);
        } else {
            super.startScroll(i10, i11, i12, i13, i14);
        }
    }

    public MScroller(Context context, Interpolator interpolator) {
        super(context, interpolator);
    }
}
