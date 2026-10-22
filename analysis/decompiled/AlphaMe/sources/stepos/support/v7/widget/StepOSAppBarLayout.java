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
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.room.AbstractC0351g;
import com.google.android.material.appbar.AppBarLayout$ScrollingViewBehavior;
import com.google.android.material.appbar.StepOSAppBarBehavior;
import com.stepos.alphame.R;
import g.AbstractC0560a;
import java.lang.reflect.Field;
import java.util.WeakHashMap;

/* loaded from: classes2.dex */
public class StepOSAppBarLayout extends com.google.android.material.appbar.h implements N3.a {

    /* renamed from: C, reason: collision with root package name */
    public ViewGroup f14898C;

    /* renamed from: D, reason: collision with root package name */
    public StepOSAppBarBehavior f14899D;

    /* renamed from: E, reason: collision with root package name */
    public View f14900E;

    /* renamed from: F, reason: collision with root package name */
    public View f14901F;

    public StepOSAppBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0560a.f12588a);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(0);
        typedArrayObtainStyledAttributes.getDrawable(2);
        typedArrayObtainStyledAttributes.recycle();
        WeakHashMap weakHashMap = K.S.f939a;
        setBackground(drawable);
        setStateListAnimator(null);
        if (getContext().getResources().getBoolean(R.bool.is_mini_square)) {
            setExpanded(false);
        }
    }

    @Override // N3.a
    public final void a(float f4) {
        if (f4 >= 16.0f && this.f14899D != null) {
            this.f14900E.setTranslationY(0.1f * f4);
            this.f14901F.setTranslationY(f4 * 0.13f);
        }
    }

    @Override // N3.a
    public final void b(int i4) {
        Log.i(" [StepOSAppBarLayout] ", "onOverScrollStateChanged: " + i4);
        if (i4 == 0) {
            this.f14899D.a();
            ViewGroup viewGroup = this.f14898C;
            if (viewGroup != null) {
                viewGroup.postInvalidate();
            }
        }
    }

    @Override // com.google.android.material.appbar.h, A.a
    @NonNull
    public A.b getBehavior() throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        Field declaredField = null;
        try {
            declaredField = getClass().getSuperclass().getDeclaredField("behavior");
            declaredField.setAccessible(true);
            Log.i(" [StepOSAppBarLayout] ", "getBehavior find success");
        } catch (Exception e4) {
            AbstractC0351g.B("getBehavior:", e4, " [StepOSAppBarLayout] ");
        }
        StepOSAppBarBehavior stepOSAppBarBehavior = new StepOSAppBarBehavior();
        if (declaredField != null) {
            try {
                declaredField.set(this, stepOSAppBarBehavior);
            } catch (Exception e5) {
                AbstractC0351g.B("getBehavior field set:", e5, " [StepOSAppBarLayout] ");
            }
        }
        this.f14899D = stepOSAppBarBehavior;
        ViewParent parent = getParent();
        if (parent != null && (parent instanceof CoordinatorLayout)) {
            stepOSAppBarBehavior.n((CoordinatorLayout) parent, this);
        }
        return stepOSAppBarBehavior;
    }

    @Override // com.google.android.material.appbar.h, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        setWillNotDraw(false);
        setWillNotDraw(false);
        this.f14898C = (ViewGroup) findViewById(R.id.action_bar_container);
        this.f14900E = findViewById(R.id.action_bar_spring_layout_middle);
        this.f14901F = findViewById(R.id.action_bar_spring_layout_quick);
    }

    public void setPrimaryBackground(Drawable drawable) {
        WeakHashMap weakHashMap = K.S.f939a;
        setBackground(drawable);
    }

    public void setStackedBackground(Drawable drawable) {
    }

    public void setTransitioning(boolean z4) {
    }

    public static class OverlayScrollingViewBehavior extends AppBarLayout$ScrollingViewBehavior {
        public OverlayScrollingViewBehavior() {
            setOverlayTop(90);
        }

        public OverlayScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            setOverlayTop(90);
        }
    }
}
