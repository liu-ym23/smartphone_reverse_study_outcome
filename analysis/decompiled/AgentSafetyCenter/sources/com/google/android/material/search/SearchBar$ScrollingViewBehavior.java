package com.google.android.material.search;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.a;
import com.google.android.material.appbar.AppBarLayout$ScrollingViewBehavior;
import com.google.android.material.appbar.g;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class SearchBar$ScrollingViewBehavior extends AppBarLayout$ScrollingViewBehavior {

    /* renamed from: a, reason: collision with root package name */
    public boolean f2442a;

    public SearchBar$ScrollingViewBehavior() {
        this.f2442a = false;
    }

    @Override // com.google.android.material.appbar.AppBarLayout$ScrollingViewBehavior, b3.a
    public final boolean onDependentViewChanged(a aVar, View view, View view2) {
        super.onDependentViewChanged(aVar, view, view2);
        if (!this.f2442a && (view2 instanceof g)) {
            this.f2442a = true;
            g gVar = (g) view2;
            gVar.setBackgroundColor(0);
            gVar.setTargetElevation(0.0f);
        }
        return false;
    }

    @Override // com.google.android.material.appbar.i
    public final boolean shouldHeaderOverlapScrollingChild() {
        return true;
    }

    public SearchBar$ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2442a = false;
    }
}
