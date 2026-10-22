package com.google.android.material.progressindicator;

import U2.c;
import U2.d;
import U2.e;
import U2.f;
import U2.i;
import U2.m;
import android.content.Context;
import android.util.AttributeSet;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;

/* loaded from: classes2.dex */
public class CircularProgressIndicator extends a<f> {

    /* renamed from: q, reason: collision with root package name */
    public static final int f21188q = R$style.Widget_MaterialComponents_CircularProgressIndicator;

    public CircularProgressIndicator(Context context) {
        this(context, null);
    }

    public int getIndeterminateAnimationType() {
        return ((f) this.f21190a).f6226o;
    }

    public int getIndicatorDirection() {
        return ((f) this.f21190a).f6229r;
    }

    public int getIndicatorInset() {
        return ((f) this.f21190a).f6228q;
    }

    public int getIndicatorSize() {
        return ((f) this.f21190a).f6227p;
    }

    @Override // com.google.android.material.progressindicator.a
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public f i(Context context, AttributeSet attributeSet) {
        return new f(context, attributeSet);
    }

    public void setIndeterminateAnimationType(int i10) {
        if (((f) this.f21190a).f6226o == i10) {
            return;
        }
        if (r() && isIndeterminate()) {
            throw new IllegalStateException("Cannot change indeterminate animation type while the progress indicator is show in indeterminate mode.");
        }
        S s10 = this.f21190a;
        ((f) s10).f6226o = i10;
        ((f) s10).h();
        getIndeterminateDrawable().z(i10 == 1 ? new e(getContext(), (f) this.f21190a) : new d((f) this.f21190a));
        o();
        invalidate();
    }

    public void setIndicatorDirection(int i10) {
        ((f) this.f21190a).f6229r = i10;
        invalidate();
    }

    public void setIndicatorInset(int i10) {
        S s10 = this.f21190a;
        if (((f) s10).f6228q != i10) {
            ((f) s10).f6228q = i10;
            invalidate();
        }
    }

    public void setIndicatorSize(int i10) {
        int iMax = Math.max(i10, getTrackThickness() * 2);
        S s10 = this.f21190a;
        if (((f) s10).f6227p != iMax) {
            ((f) s10).f6227p = iMax;
            ((f) s10).h();
            requestLayout();
            invalidate();
        }
    }

    @Override // com.google.android.material.progressindicator.a
    public void setTrackThickness(int i10) {
        super.setTrackThickness(i10);
        ((f) this.f21190a).h();
    }

    public final void t() {
        c cVar = new c((f) this.f21190a);
        setIndeterminateDrawable(m.v(getContext(), (f) this.f21190a, cVar));
        setProgressDrawable(i.A(getContext(), (f) this.f21190a, cVar));
    }

    public CircularProgressIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.circularProgressIndicatorStyle);
    }

    public CircularProgressIndicator(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10, f21188q);
        t();
        this.f21200k = true;
    }
}
