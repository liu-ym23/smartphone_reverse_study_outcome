package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.stepos.aiengine.R;
import java.lang.reflect.Field;
import stepos.support.v7.widget.StepOSAppBarLayout;
import stepos.support.v7.widget.o;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class StepOSAppBarBehavior extends AppBarLayout.Behavior implements o {

    /* renamed from: p, reason: collision with root package name */
    public StepOSAppBarLayout.a f4570p;

    /* renamed from: q, reason: collision with root package name */
    public CoordinatorLayout f4571q;
    public AppBarLayout r;

    /* renamed from: s, reason: collision with root package name */
    public o f4572s;

    /* renamed from: t, reason: collision with root package name */
    public be.a f4573t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f4574u;

    public StepOSAppBarBehavior() throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        this.f4573t = null;
        this.f4574u = false;
        w();
    }

    @Override // stepos.support.v7.widget.o
    public final void b() {
        o oVar = this.f4572s;
        if (oVar != null) {
            oVar.b();
        }
    }

    @Override // stepos.support.v7.widget.o
    public final void d() {
        o oVar = this.f4572s;
        if (oVar != null) {
            oVar.d();
        }
    }

    @Override // com.google.android.material.appbar.e, androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final boolean onTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        AppBarLayout appBarLayout = (AppBarLayout) view;
        if (coordinatorLayout.getContext().getResources().getBoolean(R.bool.is_mini_square)) {
            return true;
        }
        return super.onTouchEvent(coordinatorLayout, appBarLayout, motionEvent);
    }

    @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
    /* renamed from: r */
    public final boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i10, int i11) {
        v(coordinatorLayout, appBarLayout);
        if (coordinatorLayout.getContext().getResources().getBoolean(R.bool.is_mini_square)) {
            return false;
        }
        return super.onStartNestedScroll(coordinatorLayout, appBarLayout, view, view2, i10, i11);
    }

    public final void v(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
        stepos.support.v7.widget.e eVar;
        if (this.f4571q == null) {
            this.f4571q = coordinatorLayout;
            this.r = appBarLayout;
            TextView textView = new TextView(appBarLayout.getContext());
            i iVar = new i(this);
            be.a aVar = new be.a();
            h1.f fVar = new h1.f(textView, h1.d.f9222n);
            h1.g gVar = new h1.g();
            gVar.a(0.92f);
            gVar.b(300.0f);
            fVar.f9241t = gVar;
            aVar.f3240a = fVar;
            fVar.a(iVar);
            this.f4573t = aVar;
            int childCount = appBarLayout.getChildCount();
            int i10 = 0;
            while (true) {
                if (i10 >= childCount) {
                    eVar = null;
                    break;
                }
                View childAt = appBarLayout.getChildAt(i10);
                if (childAt instanceof stepos.support.v7.widget.e) {
                    eVar = (stepos.support.v7.widget.e) childAt;
                    break;
                }
                i10++;
            }
            if (eVar != null) {
                this.f4572s = eVar.getTitleScaleControl();
            }
        }
    }

    public final void w() throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        try {
            Field declaredField = getClass().getSuperclass().getSuperclass().getDeclaredField("offsetAnimator");
            declaredField.setAccessible(true);
            StepOSAppBarLayout.a aVar = this.f4570p;
            if (aVar != null) {
                aVar.cancel();
            }
            StepOSAppBarLayout.a aVar2 = new StepOSAppBarLayout.a();
            aVar2.setInterpolator(stepos.support.v7.widget.c.f12708c);
            aVar2.addUpdateListener(new g(this, aVar2));
            aVar2.addListener(new h(this, 0));
            this.f4570p = aVar2;
            declaredField.set(this, aVar2);
        } catch (Exception e10) {
            Log.e(" [StepOSAppBarBehavior] ", "initSnapAnimator: " + e10);
        }
    }

    public StepOSAppBarBehavior(Context context, AttributeSet attributeSet) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        super(context, attributeSet);
        this.f4573t = null;
        this.f4574u = false;
        w();
    }
}
