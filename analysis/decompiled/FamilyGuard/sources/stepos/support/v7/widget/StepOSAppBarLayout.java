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
import androidx.core.view.H;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.StepOSAppBarBehavior;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
public class StepOSAppBarLayout extends AppBarLayout implements e5.a {

    /* renamed from: C, reason: collision with root package name */
    private final String f21659C;

    /* renamed from: D, reason: collision with root package name */
    private final float f21660D;

    /* renamed from: E, reason: collision with root package name */
    Drawable f21661E;

    /* renamed from: F, reason: collision with root package name */
    Drawable f21662F;

    /* renamed from: G, reason: collision with root package name */
    protected ViewGroup f21663G;

    /* renamed from: H, reason: collision with root package name */
    private StepOSAppBarBehavior f21664H;

    /* renamed from: I, reason: collision with root package name */
    protected View f21665I;

    /* renamed from: J, reason: collision with root package name */
    protected View f21666J;

    public static class a extends ValueAnimator {

        /* renamed from: a, reason: collision with root package name */
        private int[] f21667a;

        @Override // android.animation.ValueAnimator
        public void setIntValues(int... iArr) {
            this.f21667a = iArr;
            super.setIntValues(iArr);
        }
    }

    public StepOSAppBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21659C = " [StepOSAppBarLayout] ";
        this.f21660D = 16.0f;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.j.f17094a);
        this.f21661E = typedArrayObtainStyledAttributes.getDrawable(g.j.f17099b);
        this.f21662F = typedArrayObtainStyledAttributes.getDrawable(g.j.f17109d);
        typedArrayObtainStyledAttributes.recycle();
        H.o0(this, this.f21661E);
        setStateListAnimator(null);
        if (getContext().getResources().getBoolean(H1.d.f2072a)) {
            setExpanded(false);
        }
    }

    protected void O() {
        setWillNotDraw(false);
        this.f21663G = (ViewGroup) findViewById(X4.f.f5981b);
        this.f21665I = findViewById(X4.f.f5983c);
        this.f21666J = findViewById(X4.f.f5985d);
    }

    @Override // e5.a
    public void a(View view, float f5, float f6) {
        if (f6 >= 16.0f && this.f21664H != null) {
            this.f21665I.setTranslationY(0.1f * f6);
            this.f21666J.setTranslationY(f6 * 0.13f);
        }
    }

    @Override // e5.a
    public void b(View view, int i5) {
        Log.i(" [StepOSAppBarLayout] ", "onOverScrollStateChanged: " + i5);
        if (i5 == 0) {
            this.f21664H.a(0.0f);
            ViewGroup viewGroup = this.f21663G;
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
        } catch (Exception e6) {
            Log.e(" [StepOSAppBarLayout] ", "getBehavior:" + e6);
        }
        StepOSAppBarBehavior stepOSAppBarBehavior = new StepOSAppBarBehavior();
        if (declaredField != null) {
            try {
                declaredField.set(this, stepOSAppBarBehavior);
            } catch (Exception e7) {
                Log.e(" [StepOSAppBarLayout] ", "getBehavior field set:" + e7);
            }
        }
        this.f21664H = stepOSAppBarBehavior;
        ViewParent parent = getParent();
        if (parent != null && (parent instanceof CoordinatorLayout)) {
            stepOSAppBarBehavior.c0((CoordinatorLayout) parent, this);
        }
        return stepOSAppBarBehavior;
    }

    @Override // com.google.android.material.appbar.AppBarLayout, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        setWillNotDraw(false);
        O();
    }

    public void setPrimaryBackground(Drawable drawable) {
        H.o0(this, drawable);
    }

    public void setStackedBackground(Drawable drawable) {
    }

    public void setTransitioning(boolean z5) {
    }

    public static class OverlayScrollingViewBehavior extends AppBarLayout.ScrollingViewBehavior {
        public OverlayScrollingViewBehavior() {
            c();
        }

        private void c() {
            setOverlayTop(90);
        }

        public OverlayScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            c();
        }
    }
}
