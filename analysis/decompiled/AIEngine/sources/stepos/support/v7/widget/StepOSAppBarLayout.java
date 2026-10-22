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
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.StepOSAppBarBehavior;
import com.stepos.aiengine.R;
import java.lang.reflect.Field;
import java.util.WeakHashMap;
import v0.h0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class StepOSAppBarLayout extends AppBarLayout implements ie.a {
    public ViewGroup F;
    public StepOSAppBarBehavior G;
    public View H;
    public View I;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a extends ValueAnimator {
    }

    public StepOSAppBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.a.f8921a);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(0);
        typedArrayObtainStyledAttributes.getDrawable(2);
        typedArrayObtainStyledAttributes.recycle();
        WeakHashMap<View, h0> weakHashMap = v0.e0.f13274a;
        setBackground(drawable);
        setStateListAnimator(null);
        if (getContext().getResources().getBoolean(R.bool.is_mini_square)) {
            setExpanded(false);
        }
    }

    @Override // ie.a
    public final void a(float f8) {
        if (f8 >= 16.0f && this.G != null) {
            this.H.setTranslationY(0.1f * f8);
            this.I.setTranslationY(f8 * 0.13f);
        }
    }

    @Override // ie.a
    public final void b(int i10) {
        Log.i(" [StepOSAppBarLayout] ", "onOverScrollStateChanged: " + i10);
        if (i10 == 0) {
            this.G.d();
            ViewGroup viewGroup = this.F;
            if (viewGroup != null) {
                viewGroup.postInvalidate();
            }
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
        this.G = stepOSAppBarBehavior;
        ViewParent parent = getParent();
        if (parent != null && (parent instanceof CoordinatorLayout)) {
            stepOSAppBarBehavior.v((CoordinatorLayout) parent, this);
        }
        return stepOSAppBarBehavior;
    }

    @Override // com.google.android.material.appbar.AppBarLayout, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        setWillNotDraw(false);
        setWillNotDraw(false);
        this.F = (ViewGroup) findViewById(R.id.action_bar_container);
        this.H = findViewById(R.id.action_bar_spring_layout_middle);
        this.I = findViewById(R.id.action_bar_spring_layout_quick);
    }

    public void setPrimaryBackground(Drawable drawable) {
        WeakHashMap<View, h0> weakHashMap = v0.e0.f13274a;
        setBackground(drawable);
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class OverlayScrollingViewBehavior extends AppBarLayout.ScrollingViewBehavior {
        public OverlayScrollingViewBehavior() {
            setOverlayTop(90);
        }

        public OverlayScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            setOverlayTop(90);
        }
    }

    public void setStackedBackground(Drawable drawable) {
    }

    public void setTransitioning(boolean z) {
    }
}
