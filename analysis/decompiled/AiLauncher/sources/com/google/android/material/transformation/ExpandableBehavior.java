package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import java.util.List;

@Deprecated
/* loaded from: classes2.dex */
public abstract class ExpandableBehavior extends CoordinatorLayout.c<View> {

    /* renamed from: a, reason: collision with root package name */
    public int f21765a;

    public class a implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f21766a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f21767b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Q2.a f21768c;

        public a(View view, int i10, Q2.a aVar) {
            this.f21766a = view;
            this.f21767b = i10;
            this.f21768c = aVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            this.f21766a.getViewTreeObserver().removeOnPreDrawListener(this);
            if (ExpandableBehavior.this.f21765a == this.f21767b) {
                ExpandableBehavior expandableBehavior = ExpandableBehavior.this;
                Q2.a aVar = this.f21768c;
                expandableBehavior.j((View) aVar, this.f21766a, aVar.a(), false);
            }
            return false;
        }
    }

    public ExpandableBehavior() {
        this.f21765a = 0;
    }

    public final boolean h(boolean z10) {
        if (!z10) {
            return this.f21765a == 1;
        }
        int i10 = this.f21765a;
        return i10 == 0 || i10 == 2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Q2.a i(CoordinatorLayout coordinatorLayout, View view) {
        List<View> listY = coordinatorLayout.y(view);
        int size = listY.size();
        for (int i10 = 0; i10 < size; i10++) {
            View view2 = listY.get(i10);
            if (layoutDependsOn(coordinatorLayout, view, view2)) {
                return (Q2.a) view2;
            }
        }
        return null;
    }

    public abstract boolean j(View view, View view2, boolean z10, boolean z11);

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public abstract boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
        Q2.a aVar = (Q2.a) view2;
        if (!h(aVar.a())) {
            return false;
        }
        this.f21765a = aVar.a() ? 1 : 2;
        return j((View) aVar, view, aVar.a(), true);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i10) {
        Q2.a aVarI;
        if (view.isLaidOut() || (aVarI = i(coordinatorLayout, view)) == null || !h(aVarI.a())) {
            return false;
        }
        int i11 = aVarI.a() ? 1 : 2;
        this.f21765a = i11;
        view.getViewTreeObserver().addOnPreDrawListener(new a(view, i11, aVarI));
        return false;
    }

    public ExpandableBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21765a = 0;
    }
}
