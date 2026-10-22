package stepos.support.v7.widget;

import android.graphics.Matrix;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import androidx.appcompat.view.ViewPropertyAnimatorCompatSet;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.core.view.animation.PathInterpolatorCompat;

/* loaded from: classes4.dex */
public abstract class x0 extends AppCompatImageView implements ViewPropertyAnimatorListener {
    public static final Interpolator d = PathInterpolatorCompat.create(0.18f, 0.367f, 0.0f, 1.0f);

    /* renamed from: a, reason: collision with root package name */
    public boolean f6646a;
    public ViewPropertyAnimatorCompatSet b;
    public Matrix c;

    @Override // androidx.core.view.ViewPropertyAnimatorListener
    public final void onAnimationCancel(View view) {
    }

    @Override // androidx.core.view.ViewPropertyAnimatorListener
    public final void onAnimationEnd(View view) {
        if (this.f6646a) {
            ViewCompat.setRotation(this, 0.0f);
        }
    }

    @Override // androidx.core.view.ViewPropertyAnimatorListener
    public final void onAnimationStart(View view) {
    }

    @Override // android.view.View
    public final void onLayout(boolean z10, int i, int i6, int i10, int i11) {
        super.onLayout(z10, i, i6, i10, i11);
        setPivotX(getMeasuredWidth() / 2);
        setPivotY(getMeasuredHeight() / 2);
    }

    @Override // android.view.View
    public final boolean performClick() {
        if (super.performClick()) {
            return true;
        }
        playSoundEffect(0);
        return true;
    }

    public void setCollapsed(boolean z10) {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompatRotation;
        if (this.f6646a != z10) {
            this.f6646a = z10;
            ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = this.b;
            if (viewPropertyAnimatorCompatSet != null) {
                viewPropertyAnimatorCompatSet.cancel();
            }
            ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet2 = new ViewPropertyAnimatorCompatSet();
            if (z10) {
                ViewCompat.setRotation(this, 180.0f);
                viewPropertyAnimatorCompatRotation = ViewCompat.animate(this).rotation(360.0f);
            } else {
                ViewCompat.setRotation(this, 0.0f);
                viewPropertyAnimatorCompatRotation = ViewCompat.animate(this).rotation(180.0f);
            }
            viewPropertyAnimatorCompatRotation.setInterpolator(d);
            viewPropertyAnimatorCompatRotation.setDuration(350L);
            viewPropertyAnimatorCompatSet2.play(viewPropertyAnimatorCompatRotation);
            viewPropertyAnimatorCompatSet2.setListener(this);
            this.b = viewPropertyAnimatorCompatSet2;
            viewPropertyAnimatorCompatSet2.start();
        }
    }

    public void setOnTabCollapseButtonClickListener(w0 w0Var) {
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        super.setScaleType(scaleType);
        if (getScaleType() == ImageView.ScaleType.MATRIX && this.c == null) {
            this.c = new Matrix();
        }
    }
}
