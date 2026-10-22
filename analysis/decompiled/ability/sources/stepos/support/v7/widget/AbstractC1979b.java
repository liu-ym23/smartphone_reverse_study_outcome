package stepos.support.v7.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.stepos.ability.R;

/* renamed from: stepos.support.v7.widget.b, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC1979b extends ViewGroup {

    /* renamed from: a, reason: collision with root package name */
    public final C1977a f6601a;
    public final Context b;
    public ActionMenuView c;
    public C2005u d;
    public ViewGroup e;
    public boolean f;
    public boolean g;
    public int h;
    public ViewPropertyAnimatorCompat i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f6602j;
    public boolean k;

    static {
        PathInterpolatorCompat.create(0.33f, 0.0f, 0.66f, 1.0f);
    }

    public AbstractC1979b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.steposActionModeStyleFullScreen);
        this.f6601a = new C1977a(this, 0);
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(androidx.appcompat.R.attr.actionBarPopupTheme, typedValue, true) || typedValue.resourceId == 0) {
            this.b = context;
        } else {
            this.b = new ContextThemeWrapper(context, typedValue.resourceId);
        }
    }

    public static int c(View view, int i, int i6) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE), i6);
        return Math.max(0, i - view.getMeasuredWidth());
    }

    public static int d(View view, int i, int i6, int i10, boolean z10) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i11 = ((i10 - measuredHeight) / 2) + i6;
        if (z10) {
            view.layout(i - measuredWidth, i11, i, measuredHeight + i11);
        } else {
            view.layout(i, i11, i + measuredWidth, measuredHeight + i11);
        }
        return z10 ? -measuredWidth : measuredWidth;
    }

    public final ViewPropertyAnimatorCompat e(int i, long j5) {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.i;
        if (viewPropertyAnimatorCompat != null) {
            viewPropertyAnimatorCompat.cancel();
        }
        C1977a c1977a = this.f6601a;
        if (i != 0) {
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompatAlpha = ViewCompat.animate(this).alpha(0.0f);
            viewPropertyAnimatorCompatAlpha.setDuration(j5);
            ((AbstractC1979b) c1977a.d).i = viewPropertyAnimatorCompatAlpha;
            c1977a.c = i;
            viewPropertyAnimatorCompatAlpha.setListener(c1977a);
            return viewPropertyAnimatorCompatAlpha;
        }
        if (getVisibility() != 0) {
            ViewCompat.setAlpha(this, 0.0f);
        }
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompatAlpha2 = ViewCompat.animate(this).alpha(1.0f);
        viewPropertyAnimatorCompatAlpha2.setDuration(j5);
        ((AbstractC1979b) c1977a.d).i = viewPropertyAnimatorCompatAlpha2;
        c1977a.c = i;
        viewPropertyAnimatorCompatAlpha2.setListener(c1977a);
        return viewPropertyAnimatorCompatAlpha2;
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (actionMasked == 9) {
            this.k = false;
        }
        if (!this.k) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.k = true;
            }
        }
        if (actionMasked != 10 && actionMasked != 3) {
            return true;
        }
        this.k = false;
        return true;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (actionMasked == 0) {
            this.f6602j = false;
        }
        if (!this.f6602j) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.f6602j = true;
            }
        }
        if (actionMasked != 1 && actionMasked != 3) {
            return true;
        }
        this.f6602j = false;
        return true;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (i != getVisibility()) {
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.i;
            if (viewPropertyAnimatorCompat != null) {
                viewPropertyAnimatorCompat.cancel();
            }
            super.setVisibility(i);
        }
    }
}
