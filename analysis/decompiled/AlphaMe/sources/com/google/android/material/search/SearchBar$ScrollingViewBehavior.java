package com.google.android.material.search;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout$ScrollingViewBehavior;
import com.google.android.material.appbar.h;
import com.stepos.alphame.utils.Property;

/* loaded from: classes.dex */
public class SearchBar$ScrollingViewBehavior extends AppBarLayout$ScrollingViewBehavior {

    /* renamed from: a, reason: collision with root package name */
    public boolean f10874a;

    public SearchBar$ScrollingViewBehavior() {
        this.f10874a = false;
    }

    @Override // com.google.android.material.appbar.AppBarLayout$ScrollingViewBehavior, A.b
    public final boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) throws Resources.NotFoundException {
        super.onDependentViewChanged(coordinatorLayout, view, view2);
        if (!this.f10874a && (view2 instanceof h)) {
            this.f10874a = true;
            h hVar = (h) view2;
            hVar.setBackgroundColor(0);
            hVar.setTargetElevation(Property.DEFAULT_FLOAT_VALUE);
        }
        return false;
    }

    @Override // com.google.android.material.appbar.j
    public final boolean shouldHeaderOverlapScrollingChild() {
        return true;
    }

    public SearchBar$ScrollingViewBehavior(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f10874a = false;
    }
}
