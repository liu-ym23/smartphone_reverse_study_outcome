package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.C0195d;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.room.AbstractC0351g;
import com.stepos.alphame.R;
import java.lang.reflect.Field;
import stepos.support.v7.widget.AbstractC0901v;
import stepos.support.v7.widget.AbstractC0904y;
import stepos.support.v7.widget.J;
import stepos.support.v7.widget.T;

/* loaded from: classes.dex */
public class StepOSAppBarBehavior extends AppBarLayout$Behavior implements J {

    /* renamed from: m, reason: collision with root package name */
    public T f10274m;

    /* renamed from: n, reason: collision with root package name */
    public CoordinatorLayout f10275n;

    /* renamed from: o, reason: collision with root package name */
    public h f10276o;

    /* renamed from: p, reason: collision with root package name */
    public J f10277p;

    /* renamed from: q, reason: collision with root package name */
    public B0.c f10278q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f10279r;

    public StepOSAppBarBehavior() throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        this.f10278q = null;
        this.f10279r = false;
        o();
    }

    @Override // stepos.support.v7.widget.J
    public final void a() {
        J j4 = this.f10277p;
        if (j4 != null) {
            j4.a();
        }
    }

    @Override // stepos.support.v7.widget.J
    public final void b() {
        J j4 = this.f10277p;
        if (j4 != null) {
            j4.b();
        }
    }

    @Override // com.google.android.material.appbar.AppBarLayout$BaseBehavior, A.b
    /* renamed from: j */
    public final boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, h hVar, View view, View view2, int i4, int i5) {
        n(coordinatorLayout, hVar);
        if (coordinatorLayout.getContext().getResources().getBoolean(R.bool.is_mini_square)) {
            return false;
        }
        return super.onStartNestedScroll(coordinatorLayout, hVar, view, view2, i4, i5);
    }

    public final void n(CoordinatorLayout coordinatorLayout, h hVar) {
        AbstractC0904y abstractC0904y;
        if (this.f10275n == null) {
            this.f10275n = coordinatorLayout;
            this.f10276o = hVar;
            TextView textView = new TextView(hVar.getContext());
            int i4 = 0;
            l lVar = new l(0, this);
            B0.c cVar = new B0.c();
            W.m mVar = new W.m(textView, W.m.f1956r);
            W.n nVar = new W.n();
            nVar.a(0.92f);
            nVar.b(300.0f);
            mVar.f1974m = nVar;
            cVar.f136a = mVar;
            mVar.a(lVar);
            this.f10278q = cVar;
            int childCount = hVar.getChildCount();
            while (true) {
                if (i4 >= childCount) {
                    abstractC0904y = null;
                    break;
                }
                View childAt = hVar.getChildAt(i4);
                if (childAt instanceof AbstractC0904y) {
                    abstractC0904y = (AbstractC0904y) childAt;
                    break;
                }
                i4++;
            }
            if (abstractC0904y != null) {
                this.f10277p = abstractC0904y.getTitleScaleControl();
            }
        }
    }

    public final void o() throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        try {
            Field declaredField = getClass().getSuperclass().getSuperclass().getDeclaredField("offsetAnimator");
            declaredField.setAccessible(true);
            T t4 = this.f10274m;
            if (t4 != null) {
                t4.cancel();
            }
            T t5 = new T();
            t5.setInterpolator(AbstractC0901v.f15156c);
            t5.addUpdateListener(new k(0, this, t5));
            t5.addListener(new C0195d(3, this));
            this.f10274m = t5;
            declaredField.set(this, t5);
        } catch (Exception e4) {
            AbstractC0351g.B("initSnapAnimator: ", e4, " [StepOSAppBarBehavior] ");
        }
    }

    @Override // com.google.android.material.appbar.i, A.b
    public final boolean onTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        h hVar = (h) view;
        if (coordinatorLayout.getContext().getResources().getBoolean(R.bool.is_mini_square)) {
            return true;
        }
        return super.onTouchEvent(coordinatorLayout, hVar, motionEvent);
    }

    public StepOSAppBarBehavior(Context context, AttributeSet attributeSet) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        super(context, attributeSet);
        this.f10278q = null;
        this.f10279r = false;
        o();
    }
}
