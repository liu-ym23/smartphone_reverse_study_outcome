package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import com.google.android.material.appbar.AppBarLayout;
import com.stepos.ability.R;
import java.lang.reflect.Field;
import stepos.support.v7.widget.AbstractC2010z;
import stepos.support.v7.widget.C1978a0;
import stepos.support.v7.widget.D;
import stepos.support.v7.widget.O;

/* loaded from: classes3.dex */
public class StepOSAppBarBehavior extends AppBarLayout.Behavior implements O {
    public C1978a0 m;
    public CoordinatorLayout n;
    public AppBarLayout o;
    public O p;

    /* renamed from: q, reason: collision with root package name */
    public Qa.a f2285q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f2286r;

    public StepOSAppBarBehavior() throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        this.f2285q = null;
        this.f2286r = false;
        o();
    }

    @Override // stepos.support.v7.widget.O
    public final void a() {
        O o = this.p;
        if (o != null) {
            o.a();
        }
    }

    @Override // stepos.support.v7.widget.O
    public final void b() {
        O o = this.p;
        if (o != null) {
            o.b();
        }
    }

    @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /* renamed from: j */
    public final boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i, int i6) {
        n(coordinatorLayout, appBarLayout);
        if (coordinatorLayout.getContext().getResources().getBoolean(R.bool.is_mini_square)) {
            return false;
        }
        return super.onStartNestedScroll(coordinatorLayout, appBarLayout, view, view2, i, i6);
    }

    public final void n(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
        D d;
        if (this.n == null) {
            this.n = coordinatorLayout;
            this.o = appBarLayout;
            TextView textView = new TextView(appBarLayout.getContext());
            j jVar = new j(this);
            Qa.a aVar = new Qa.a();
            SpringAnimation springAnimation = new SpringAnimation(textView, DynamicAnimation.SCALE_X);
            SpringForce springForce = new SpringForce();
            springForce.setDampingRatio(0.92f);
            springForce.setStiffness(300.0f);
            SpringAnimation spring = springAnimation.setSpring(springForce);
            aVar.f1131a = spring;
            spring.addEndListener(jVar);
            this.f2285q = aVar;
            int childCount = appBarLayout.getChildCount();
            int i = 0;
            while (true) {
                if (i >= childCount) {
                    d = null;
                    break;
                }
                View childAt = appBarLayout.getChildAt(i);
                if (childAt instanceof D) {
                    d = (D) childAt;
                    break;
                }
                i++;
            }
            if (d != null) {
                this.p = d.getTitleScaleControl();
            }
        }
    }

    public final void o() throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        try {
            Field declaredField = getClass().getSuperclass().getSuperclass().getDeclaredField("offsetAnimator");
            declaredField.setAccessible(true);
            C1978a0 c1978a0 = this.m;
            if (c1978a0 != null) {
                c1978a0.cancel();
            }
            C1978a0 c1978a02 = new C1978a0();
            c1978a02.setInterpolator(AbstractC2010z.c);
            c1978a02.addUpdateListener(new i(0, this, c1978a02));
            c1978a02.addListener(new A6.m(this, 5));
            this.m = c1978a02;
            declaredField.set(this, c1978a02);
        } catch (Exception e) {
            Log.e(" [StepOSAppBarBehavior] ", "initSnapAnimator: " + e);
        }
    }

    @Override // com.google.android.material.appbar.g, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        AppBarLayout appBarLayout = (AppBarLayout) view;
        if (coordinatorLayout.getContext().getResources().getBoolean(R.bool.is_mini_square)) {
            return true;
        }
        return super.onTouchEvent(coordinatorLayout, appBarLayout, motionEvent);
    }

    public StepOSAppBarBehavior(Context context, AttributeSet attributeSet) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        super(context, attributeSet);
        this.f2285q = null;
        this.f2286r = false;
        o();
    }
}
