package T2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.util.Property;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import b.C1423c;
import com.google.android.material.R$dimen;

/* loaded from: classes2.dex */
public class g extends T2.a<View> {

    /* renamed from: g, reason: collision with root package name */
    public final float f5860g;

    /* renamed from: h, reason: collision with root package name */
    public final float f5861h;

    /* renamed from: i, reason: collision with root package name */
    public final float f5862i;

    public class a extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f5863a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f5864b;

        public a(boolean z10, int i10) {
            this.f5863a = z10;
            this.f5864b = i10;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            g.this.f5845b.setTranslationX(0.0f);
            g.this.k(0.0f, this.f5863a, this.f5864b);
        }
    }

    public g(View view) {
        super(view);
        Resources resources = view.getResources();
        this.f5860g = resources.getDimension(R$dimen.m3_back_progress_side_container_max_scale_x_distance_shrink);
        this.f5861h = resources.getDimension(R$dimen.m3_back_progress_side_container_max_scale_x_distance_grow);
        this.f5862i = resources.getDimension(R$dimen.m3_back_progress_side_container_max_scale_y_distance);
    }

    public void f() {
        if (super.b() == null) {
            return;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(this.f5845b, (Property<V, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(this.f5845b, (Property<V, Float>) View.SCALE_Y, 1.0f));
        V v10 = this.f5845b;
        if (v10 instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) v10;
            for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
                animatorSet.playTogether(ObjectAnimator.ofFloat(viewGroup.getChildAt(i10), (Property<View, Float>) View.SCALE_Y, 1.0f));
            }
        }
        animatorSet.setDuration(this.f5848e);
        animatorSet.start();
    }

    public final boolean g(int i10, int i11) {
        return (Gravity.getAbsoluteGravity(i10, this.f5845b.getLayoutDirection()) & i11) == i11;
    }

    public void h(C1423c c1423c, int i10, Animator.AnimatorListener animatorListener, ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        boolean z10 = c1423c.getSwipeEdge() == 0;
        boolean zG = g(i10, 3);
        float width = (this.f5845b.getWidth() * this.f5845b.getScaleX()) + i(zG);
        V v10 = this.f5845b;
        Property property = View.TRANSLATION_X;
        if (zG) {
            width = -width;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(v10, (Property<V, Float>) property, width);
        if (animatorUpdateListener != null) {
            objectAnimatorOfFloat.addUpdateListener(animatorUpdateListener);
        }
        objectAnimatorOfFloat.setInterpolator(new T0.b());
        objectAnimatorOfFloat.setDuration(E2.a.c(this.f5846c, this.f5847d, c1423c.getProgress()));
        objectAnimatorOfFloat.addListener(new a(z10, i10));
        if (animatorListener != null) {
            objectAnimatorOfFloat.addListener(animatorListener);
        }
        objectAnimatorOfFloat.start();
    }

    public final int i(boolean z10) {
        ViewGroup.LayoutParams layoutParams = this.f5845b.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return 0;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return z10 ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
    }

    public void j(C1423c c1423c) {
        super.d(c1423c);
    }

    public void k(float f10, boolean z10, int i10) {
        float fA = a(f10);
        boolean zG = g(i10, 3);
        boolean z11 = z10 == zG;
        int width = this.f5845b.getWidth();
        int height = this.f5845b.getHeight();
        float f11 = width;
        if (f11 > 0.0f) {
            float f12 = height;
            if (f12 <= 0.0f) {
                return;
            }
            float f13 = this.f5860g / f11;
            float f14 = this.f5861h / f11;
            float f15 = this.f5862i / f12;
            V v10 = this.f5845b;
            if (zG) {
                f11 = 0.0f;
            }
            v10.setPivotX(f11);
            if (!z11) {
                f14 = -f13;
            }
            float fA2 = E2.a.a(0.0f, f14, fA);
            float f16 = fA2 + 1.0f;
            float fA3 = 1.0f - E2.a.a(0.0f, f15, fA);
            if (Float.isNaN(f16) || Float.isNaN(fA3)) {
                return;
            }
            this.f5845b.setScaleX(f16);
            this.f5845b.setScaleY(fA3);
            V v11 = this.f5845b;
            if (v11 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) v11;
                for (int i11 = 0; i11 < viewGroup.getChildCount(); i11++) {
                    View childAt = viewGroup.getChildAt(i11);
                    childAt.setPivotX(zG ? (width - childAt.getRight()) + childAt.getWidth() : -childAt.getLeft());
                    childAt.setPivotY(-childAt.getTop());
                    float f17 = z11 ? 1.0f - fA2 : 1.0f;
                    float f18 = fA3 != 0.0f ? (f16 / fA3) * f17 : 1.0f;
                    if (!Float.isNaN(f17) && !Float.isNaN(f18)) {
                        childAt.setScaleX(f17);
                        childAt.setScaleY(f18);
                    }
                }
            }
        }
    }

    public void l(C1423c c1423c, int i10) {
        if (super.e(c1423c) == null) {
            return;
        }
        k(c1423c.getProgress(), c1423c.getSwipeEdge() == 0, i10);
    }
}
