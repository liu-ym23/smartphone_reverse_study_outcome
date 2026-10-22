package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.stepos.agentsafetycenter.R;
import java.lang.invoke.VarHandle;
import java.lang.reflect.Field;
import java.util.ArrayList;
import stepos.support.v7.widget.i0;
import stepos.support.v7.widget.s0;
import stepos.support.v7.widget.u;
import stepos.support.v7.widget.y;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class StepOSAppBarBehavior extends AppBarLayout$Behavior implements i0 {

    /* renamed from: m, reason: collision with root package name */
    public s0 f2319m;

    /* renamed from: n, reason: collision with root package name */
    public androidx.coordinatorlayout.widget.a f2320n;

    /* renamed from: o, reason: collision with root package name */
    public g f2321o;

    /* renamed from: p, reason: collision with root package name */
    public i0 f2322p;

    /* renamed from: q, reason: collision with root package name */
    public a1.g f2323q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f2324r;

    public StepOSAppBarBehavior() throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        this.f2323q = null;
        this.f2324r = false;
        o();
    }

    @Override // stepos.support.v7.widget.i0
    public final void a() {
        i0 i0Var = this.f2322p;
        if (i0Var != null) {
            i0Var.a();
        }
    }

    @Override // stepos.support.v7.widget.i0
    public final void b() {
        i0 i0Var = this.f2322p;
        if (i0Var != null) {
            i0Var.b();
        }
    }

    @Override // com.google.android.material.appbar.AppBarLayout$BaseBehavior, b3.a
    /* renamed from: h */
    public final boolean onStartNestedScroll(androidx.coordinatorlayout.widget.a aVar, g gVar, View view, View view2, int i, int i3) {
        n(aVar, gVar);
        if (aVar.getContext().getResources().getBoolean(R.bool.is_mini_square)) {
            return false;
        }
        return super.onStartNestedScroll(aVar, gVar, view, view2, i, i3);
    }

    public final void n(androidx.coordinatorlayout.widget.a aVar, g gVar) {
        y yVar;
        if (this.f2320n == null) {
            this.f2320n = aVar;
            this.f2321o = gVar;
            TextView textView = new TextView(gVar.getContext());
            int i = 0;
            k kVar = new k(0);
            kVar.f2374b = this;
            VarHandle.storeStoreFence();
            a1.g gVar2 = new a1.g(22, false);
            z3.g gVar3 = new z3.g(textView, z3.g.f16354p);
            z3.h hVar = new z3.h();
            hVar.a(0.92f);
            hVar.b(300.0f);
            gVar3.f16369k = hVar;
            gVar2.f19f = gVar3;
            ArrayList arrayList = gVar3.i;
            if (!arrayList.contains(kVar)) {
                arrayList.add(kVar);
            }
            this.f2323q = gVar2;
            int childCount = gVar.getChildCount();
            while (true) {
                if (i >= childCount) {
                    yVar = null;
                    break;
                }
                View childAt = gVar.getChildAt(i);
                if (childAt instanceof y) {
                    yVar = (y) childAt;
                    break;
                }
                i++;
            }
            if (yVar != null) {
                this.f2322p = yVar.getTitleScaleControl();
            }
        }
    }

    public final void o() throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        try {
            Field declaredField = getClass().getSuperclass().getSuperclass().getDeclaredField("offsetAnimator");
            declaredField.setAccessible(true);
            s0 s0Var = this.f2319m;
            if (s0Var != null) {
                s0Var.cancel();
            }
            s0 s0Var2 = new s0();
            s0Var2.setInterpolator(u.f12838c);
            j jVar = new j(0);
            jVar.f2372c = this;
            jVar.f2371b = s0Var2;
            VarHandle.storeStoreFence();
            s0Var2.addUpdateListener(jVar);
            s0Var2.addListener(new bb.d(this, 1));
            this.f2319m = s0Var2;
            declaredField.set(this, s0Var2);
        } catch (Exception e10) {
            Log.e(" [StepOSAppBarBehavior] ", "initSnapAnimator: " + e10);
        }
    }

    @Override // com.google.android.material.appbar.AppBarLayout$BaseBehavior, b3.a
    public final boolean onTouchEvent(androidx.coordinatorlayout.widget.a aVar, View view, MotionEvent motionEvent) {
        g gVar = (g) view;
        if (aVar.getContext().getResources().getBoolean(R.bool.is_mini_square)) {
            return true;
        }
        return super.onTouchEvent(aVar, gVar, motionEvent);
    }

    public StepOSAppBarBehavior(Context context, AttributeSet attributeSet) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        super(context, attributeSet);
        this.f2323q = null;
        this.f2324r = false;
        o();
    }
}
