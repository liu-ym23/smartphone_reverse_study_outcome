package stepos.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.appcompat.R;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.StepOSAppBarBehavior;
import java.lang.reflect.Field;

/* loaded from: classes4.dex */
public class StepOSAppBarLayout extends AppBarLayout implements Xa.a {

    /* renamed from: C, reason: collision with root package name */
    public ViewGroup f6502C;

    /* renamed from: D, reason: collision with root package name */
    public StepOSAppBarBehavior f6503D;
    public View E;

    /* renamed from: F, reason: collision with root package name */
    public View f6504F;

    public StepOSAppBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ActionBar);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(R.styleable.ActionBar_background);
        typedArrayObtainStyledAttributes.getDrawable(R.styleable.ActionBar_backgroundStacked);
        typedArrayObtainStyledAttributes.recycle();
        ViewCompat.setBackground(this, drawable);
        setStateListAnimator(null);
        if (getContext().getResources().getBoolean(com.stepos.ability.R.bool.is_mini_square)) {
            setExpanded(false);
        }
    }

    @Override // Xa.a
    public final void a(float f) {
        if (f >= 16.0f && this.f6503D != null) {
            this.E.setTranslationY(0.1f * f);
            this.f6504F.setTranslationY(f * 0.13f);
        }
    }

    @Override // Xa.a
    public final void b(int i) {
        Log.i(" [StepOSAppBarLayout] ", "onOverScrollStateChanged: " + i);
        if (i == 0) {
            this.f6503D.b();
            ViewGroup viewGroup = this.f6502C;
            if (viewGroup != null) {
                viewGroup.postInvalidate();
            }
        }
    }

    @Override // com.google.android.material.appbar.AppBarLayout, androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    @NonNull
    public CoordinatorLayout.Behavior<AppBarLayout> getBehavior() throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        Field declaredField = null;
        try {
            declaredField = getClass().getSuperclass().getDeclaredField("behavior");
            declaredField.setAccessible(true);
            Log.i(" [StepOSAppBarLayout] ", "getBehavior find success");
        } catch (Exception e) {
            Log.e(" [StepOSAppBarLayout] ", "getBehavior:" + e);
        }
        StepOSAppBarBehavior stepOSAppBarBehavior = new StepOSAppBarBehavior();
        if (declaredField != null) {
            try {
                declaredField.set(this, stepOSAppBarBehavior);
            } catch (Exception e6) {
                Log.e(" [StepOSAppBarLayout] ", "getBehavior field set:" + e6);
            }
        }
        this.f6503D = stepOSAppBarBehavior;
        ViewParent parent = getParent();
        if (parent != null && (parent instanceof CoordinatorLayout)) {
            stepOSAppBarBehavior.n((CoordinatorLayout) parent, this);
        }
        return stepOSAppBarBehavior;
    }

    @Override // com.google.android.material.appbar.AppBarLayout, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        setWillNotDraw(false);
        setWillNotDraw(false);
        this.f6502C = (ViewGroup) findViewById(com.stepos.ability.R.id.action_bar_container);
        this.E = findViewById(com.stepos.ability.R.id.action_bar_spring_layout_middle);
        this.f6504F = findViewById(com.stepos.ability.R.id.action_bar_spring_layout_quick);
    }

    public void setPrimaryBackground(Drawable drawable) {
        ViewCompat.setBackground(this, drawable);
    }

    public void setStackedBackground(Drawable drawable) {
    }

    public void setTransitioning(boolean z10) {
    }

    public static class OverlayScrollingViewBehavior extends AppBarLayout.ScrollingViewBehavior {
        public OverlayScrollingViewBehavior() {
            setOverlayTop(90);
        }

        public OverlayScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            setOverlayTop(90);
        }
    }
}
