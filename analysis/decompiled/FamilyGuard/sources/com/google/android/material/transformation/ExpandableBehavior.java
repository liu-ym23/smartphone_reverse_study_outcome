package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import java.util.List;
import m1.InterfaceC0857a;

@Deprecated
/* loaded from: classes.dex */
public abstract class ExpandableBehavior extends CoordinatorLayout.c<View> {

    /* renamed from: a, reason: collision with root package name */
    private int f13505a;

    class a implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f13506a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f13507b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ InterfaceC0857a f13508c;

        a(View view, int i5, InterfaceC0857a interfaceC0857a) {
            this.f13506a = view;
            this.f13507b = i5;
            this.f13508c = interfaceC0857a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            this.f13506a.getViewTreeObserver().removeOnPreDrawListener(this);
            if (ExpandableBehavior.this.f13505a == this.f13507b) {
                ExpandableBehavior expandableBehavior = ExpandableBehavior.this;
                InterfaceC0857a interfaceC0857a = this.f13508c;
                expandableBehavior.f((View) interfaceC0857a, this.f13506a, interfaceC0857a.a(), false);
            }
            return false;
        }
    }

    public ExpandableBehavior() {
        this.f13505a = 0;
    }

    private boolean d(boolean z5) {
        if (!z5) {
            return this.f13505a == 1;
        }
        int i5 = this.f13505a;
        return i5 == 0 || i5 == 2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected InterfaceC0857a e(CoordinatorLayout coordinatorLayout, View view) {
        List<View> listE = coordinatorLayout.E(view);
        int size = listE.size();
        for (int i5 = 0; i5 < size; i5++) {
            View view2 = listE.get(i5);
            if (layoutDependsOn(coordinatorLayout, view, view2)) {
                return (InterfaceC0857a) view2;
            }
        }
        return null;
    }

    protected abstract boolean f(View view, View view2, boolean z5, boolean z6);

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public abstract boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
        InterfaceC0857a interfaceC0857a = (InterfaceC0857a) view2;
        if (!d(interfaceC0857a.a())) {
            return false;
        }
        this.f13505a = interfaceC0857a.a() ? 1 : 2;
        return f((View) interfaceC0857a, view, interfaceC0857a.a(), true);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i5) {
        InterfaceC0857a interfaceC0857aE;
        if (view.isLaidOut() || (interfaceC0857aE = e(coordinatorLayout, view)) == null || !d(interfaceC0857aE.a())) {
            return false;
        }
        int i6 = interfaceC0857aE.a() ? 1 : 2;
        this.f13505a = i6;
        view.getViewTreeObserver().addOnPreDrawListener(new a(view, i6, interfaceC0857aE));
        return false;
    }

    public ExpandableBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13505a = 0;
    }
}
