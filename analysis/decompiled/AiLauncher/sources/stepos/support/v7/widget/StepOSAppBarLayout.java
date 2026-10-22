package stepos.support.v7.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.R$styleable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.N;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.StepOSAppBarBehavior;
import com.stepos.common.R$bool;
import java.lang.reflect.Field;
import stepos.support.v7.appcompat.R$id;

/* loaded from: classes5.dex */
public class StepOSAppBarLayout extends AppBarLayout implements Lc.a {

    /* renamed from: C, reason: collision with root package name */
    public final String f41279C;

    /* renamed from: D, reason: collision with root package name */
    public final float f41280D;

    /* renamed from: E, reason: collision with root package name */
    public Drawable f41281E;

    /* renamed from: F, reason: collision with root package name */
    public Drawable f41282F;

    /* renamed from: G, reason: collision with root package name */
    public ViewGroup f41283G;

    /* renamed from: H, reason: collision with root package name */
    public StepOSAppBarBehavior f41284H;

    /* renamed from: I, reason: collision with root package name */
    public View f41285I;

    /* renamed from: J, reason: collision with root package name */
    public View f41286J;

    public static class a extends ValueAnimator {

        /* renamed from: a, reason: collision with root package name */
        public int[] f41287a;

        @Override // android.animation.ValueAnimator
        public void setIntValues(int... iArr) {
            this.f41287a = iArr;
            super.setIntValues(iArr);
        }
    }

    public StepOSAppBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f41279C = " [StepOSAppBarLayout] ";
        this.f41280D = 16.0f;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ActionBar);
        this.f41281E = typedArrayObtainStyledAttributes.getDrawable(R$styleable.ActionBar_background);
        this.f41282F = typedArrayObtainStyledAttributes.getDrawable(R$styleable.ActionBar_backgroundStacked);
        typedArrayObtainStyledAttributes.recycle();
        N.m0(this, this.f41281E);
        setStateListAnimator(null);
        if (getContext().getResources().getBoolean(R$bool.is_mini_square)) {
            setExpanded(false);
        }
    }

    public void O() {
        setWillNotDraw(false);
        this.f41283G = (ViewGroup) findViewById(R$id.action_bar_container);
        this.f41285I = findViewById(R$id.action_bar_spring_layout_middle);
        this.f41286J = findViewById(R$id.action_bar_spring_layout_quick);
    }

    @Override // Lc.a
    public void a(View view, int i10) {
        Log.i(" [StepOSAppBarLayout] ", "onOverScrollStateChanged: " + i10);
        if (i10 == 0) {
            this.f41284H.a(0.0f);
            ViewGroup viewGroup = this.f41283G;
            if (viewGroup != null) {
                viewGroup.postInvalidate();
            }
        }
    }

    @Override // Lc.a
    public void b(View view, float f10, float f11) {
        if (f11 >= 16.0f && this.f41284H != null) {
            this.f41285I.setTranslationY(0.1f * f11);
            this.f41286J.setTranslationY(f11 * 0.13f);
        }
    }

    @Override // com.google.android.material.appbar.AppBarLayout, androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public CoordinatorLayout.c<AppBarLayout> getBehavior() throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        Field declaredField = null;
        try {
            declaredField = getClass().getSuperclass().getDeclaredField("behavior");
            declaredField.setAccessible(true);
            Log.i(" [StepOSAppBarLayout] ", "getBehavior find success");
        } catch (Exception e10) {
            Log.e(" [StepOSAppBarLayout] ", "getBehavior:" + e10);
        }
        StepOSAppBarBehavior stepOSAppBarBehavior = new StepOSAppBarBehavior();
        if (declaredField != null) {
            try {
                declaredField.set(this, stepOSAppBarBehavior);
            } catch (Exception e11) {
                Log.e(" [StepOSAppBarLayout] ", "getBehavior field set:" + e11);
            }
        }
        this.f41284H = stepOSAppBarBehavior;
        ViewParent parent = getParent();
        if (parent != null && (parent instanceof CoordinatorLayout)) {
            stepOSAppBarBehavior.g0((CoordinatorLayout) parent, this);
        }
        return stepOSAppBarBehavior;
    }

    @Override // com.google.android.material.appbar.AppBarLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        setWillNotDraw(false);
        O();
    }

    public void setPrimaryBackground(Drawable drawable) {
        N.m0(this, drawable);
    }

    public void setStackedBackground(Drawable drawable) {
    }

    public void setTransitioning(boolean z10) {
    }

    public static class OverlayScrollingViewBehavior extends AppBarLayout.ScrollingViewBehavior {
        public OverlayScrollingViewBehavior() {
            g();
        }

        private void g() {
            setOverlayTop(90);
        }

        public OverlayScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            g();
        }
    }
}
