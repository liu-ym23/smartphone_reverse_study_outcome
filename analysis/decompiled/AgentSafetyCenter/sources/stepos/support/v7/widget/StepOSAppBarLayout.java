package stepos.support.v7.widget;

import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import com.google.android.material.appbar.AppBarLayout$ScrollingViewBehavior;
import com.google.android.material.appbar.StepOSAppBarBehavior;
import com.stepos.agentsafetycenter.R;
import java.lang.invoke.VarHandle;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.WeakHashMap;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public class StepOSAppBarLayout extends com.google.android.material.appbar.g implements ve.a {
    public ViewGroup F;
    public StepOSAppBarBehavior G;
    public View H;
    public View I;

    public StepOSAppBarLayout(Context context, AttributeSet attributeSet) {
        super(k7.a.a(context, attributeSet, R.attr.appBarLayoutStyle, R.style.Widget_Design_AppBarLayout, new int[0]), attributeSet, R.attr.appBarLayoutStyle);
        this.f2346f = -1;
        this.f2347g = -1;
        this.f2348h = -1;
        this.f2349j = 0;
        this.f2361v = new ArrayList();
        this.f2362w = new LinkedHashSet();
        Context context2 = getContext();
        setOrientation(1);
        if (getOutlineProvider() == ViewOutlineProvider.BACKGROUND) {
            setOutlineProvider(ViewOutlineProvider.BOUNDS);
        }
        Context context3 = getContext();
        a7.a.a(context3, attributeSet, R.attr.appBarLayoutStyle, R.style.Widget_Design_AppBarLayout);
        int[] iArr = com.google.android.material.appbar.n.f2382a;
        a7.a.b(context3, attributeSet, iArr, R.attr.appBarLayoutStyle, R.style.Widget_Design_AppBarLayout, new int[0]);
        TypedArray typedArrayObtainStyledAttributes = context3.obtainStyledAttributes(attributeSet, iArr, R.attr.appBarLayoutStyle, R.style.Widget_Design_AppBarLayout);
        try {
            if (typedArrayObtainStyledAttributes.hasValue(0)) {
                setStateListAnimator(AnimatorInflater.loadStateListAnimator(context3, typedArrayObtainStyledAttributes.getResourceId(0, 0)));
            }
            typedArrayObtainStyledAttributes.recycle();
            a7.a.a(context2, attributeSet, R.attr.appBarLayoutStyle, R.style.Widget_Design_AppBarLayout);
            int[] iArr2 = p6.a.f9809a;
            a7.a.b(context2, attributeSet, iArr2, R.attr.appBarLayoutStyle, R.style.Widget_Design_AppBarLayout, new int[0]);
            TypedArray typedArrayObtainStyledAttributes2 = context2.obtainStyledAttributes(attributeSet, iArr2, R.attr.appBarLayoutStyle, R.style.Widget_Design_AppBarLayout);
            this.f2356q = td.h.s(context2, typedArrayObtainStyledAttributes2, 6);
            this.f2363x = id.k.O(context2, R.attr.motionDurationMedium2, getResources().getInteger(R.integer.app_bar_elevation_anim_duration));
            this.f2364y = id.k.P(context2, R.attr.motionEasingStandardInterpolator, q6.a.f10101a);
            int i = 4;
            if (typedArrayObtainStyledAttributes2.hasValue(4)) {
                h(typedArrayObtainStyledAttributes2.getBoolean(4, false), false, false);
            }
            if (typedArrayObtainStyledAttributes2.hasValue(3)) {
                com.google.android.material.appbar.n.a(this, typedArrayObtainStyledAttributes2.getDimensionPixelSize(3, 0));
            }
            setBackground(typedArrayObtainStyledAttributes2.getDrawable(0));
            if (typedArrayObtainStyledAttributes2.hasValue(2)) {
                setKeyboardNavigationCluster(typedArrayObtainStyledAttributes2.getBoolean(2, false));
            }
            if (typedArrayObtainStyledAttributes2.hasValue(1)) {
                setTouchscreenBlocksFocus(typedArrayObtainStyledAttributes2.getBoolean(1, false));
            }
            this.D = getResources().getDimension(R.dimen.design_appbar_elevation);
            this.f2355p = typedArrayObtainStyledAttributes2.getBoolean(5, false);
            this.f2357r = typedArrayObtainStyledAttributes2.getResourceId(7, -1);
            setStatusBarForeground(typedArrayObtainStyledAttributes2.getDrawable(8));
            typedArrayObtainStyledAttributes2.recycle();
            a2.i iVar = new a2.i(i);
            iVar.f49f = this;
            VarHandle.storeStoreFence();
            WeakHashMap weakHashMap = n3.k0.f8724a;
            n3.e0.b(this, iVar);
            TypedArray typedArrayObtainStyledAttributes3 = context.obtainStyledAttributes(attributeSet, g.a.f4098a);
            Drawable drawable = typedArrayObtainStyledAttributes3.getDrawable(0);
            typedArrayObtainStyledAttributes3.getDrawable(2);
            typedArrayObtainStyledAttributes3.recycle();
            setBackground(drawable);
            setStateListAnimator(null);
            if (getContext().getResources().getBoolean(R.bool.is_mini_square)) {
                setExpanded(false);
            }
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    @Override // ve.a
    public final void a(float f5) {
        if (f5 >= 16.0f && this.G != null) {
            this.H.setTranslationY(0.1f * f5);
            this.I.setTranslationY(f5 * 0.13f);
        }
    }

    @Override // ve.a
    public final void b(int i) {
        Log.i(" [StepOSAppBarLayout] ", "onOverScrollStateChanged: " + i);
        if (i == 0) {
            this.G.a();
            ViewGroup viewGroup = this.F;
            if (viewGroup != null) {
                viewGroup.postInvalidate();
            }
        }
    }

    @Override // com.google.android.material.appbar.g
    public b3.a getBehavior() throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
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
        if (parent != null && (parent instanceof androidx.coordinatorlayout.widget.a)) {
            stepOSAppBarBehavior.n((androidx.coordinatorlayout.widget.a) parent, this);
        }
        return stepOSAppBarBehavior;
    }

    @Override // com.google.android.material.appbar.g, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        setWillNotDraw(false);
        setWillNotDraw(false);
        this.F = (ViewGroup) findViewById(R.id.action_bar_container);
        this.H = findViewById(R.id.action_bar_spring_layout_middle);
        this.I = findViewById(R.id.action_bar_spring_layout_quick);
    }

    public void setPrimaryBackground(Drawable drawable) {
        WeakHashMap weakHashMap = n3.k0.f8724a;
        setBackground(drawable);
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class OverlayScrollingViewBehavior extends AppBarLayout$ScrollingViewBehavior {
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

    public void setTransitioning(boolean z10) {
    }

    public StepOSAppBarLayout(Context context) {
        this(context, null);
    }
}
