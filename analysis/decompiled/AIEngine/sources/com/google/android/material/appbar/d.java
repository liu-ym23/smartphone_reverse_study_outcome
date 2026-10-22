package com.google.android.material.appbar;

import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import w0.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class d extends v0.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AppBarLayout f4584a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CoordinatorLayout f4585b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AppBarLayout.BaseBehavior f4586c;

    public d(CoordinatorLayout coordinatorLayout, AppBarLayout.BaseBehavior baseBehavior, AppBarLayout appBarLayout) {
        this.f4586c = baseBehavior;
        this.f4584a = appBarLayout;
        this.f4585b = coordinatorLayout;
    }

    @Override // v0.a
    public final void onInitializeAccessibilityNodeInfo(View view, w0.b bVar) {
        super.onInitializeAccessibilityNodeInfo(view, bVar);
        bVar.h(ScrollView.class.getName());
        AppBarLayout appBarLayout = this.f4584a;
        if (appBarLayout.getTotalScrollRange() == 0) {
            return;
        }
        CoordinatorLayout coordinatorLayout = this.f4585b;
        AppBarLayout.BaseBehavior baseBehavior = this.f4586c;
        View viewN = AppBarLayout.BaseBehavior.n(baseBehavior, coordinatorLayout);
        if (viewN == null) {
            return;
        }
        int childCount = appBarLayout.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            if (((AppBarLayout.d) appBarLayout.getChildAt(i10).getLayoutParams()).f4566a != 0) {
                if (baseBehavior.g() != (-appBarLayout.getTotalScrollRange())) {
                    bVar.b(b.a.f13536f);
                    bVar.l(true);
                }
                if (baseBehavior.g() != 0) {
                    if (!viewN.canScrollVertically(-1)) {
                        bVar.b(b.a.f13537g);
                        bVar.l(true);
                        return;
                    } else {
                        if ((-appBarLayout.getDownNestedPreScrollRange()) != 0) {
                            bVar.b(b.a.f13537g);
                            bVar.l(true);
                            return;
                        }
                        return;
                    }
                }
                return;
            }
        }
    }

    @Override // v0.a
    public final boolean performAccessibilityAction(View view, int i10, Bundle bundle) {
        AppBarLayout appBarLayout = this.f4584a;
        if (i10 == 4096) {
            appBarLayout.setExpanded(false);
            return true;
        }
        if (i10 != 8192) {
            return super.performAccessibilityAction(view, i10, bundle);
        }
        AppBarLayout.BaseBehavior baseBehavior = this.f4586c;
        if (baseBehavior.g() != 0) {
            View viewN = AppBarLayout.BaseBehavior.n(baseBehavior, this.f4585b);
            if (!viewN.canScrollVertically(-1)) {
                appBarLayout.setExpanded(true);
                return true;
            }
            int i11 = -appBarLayout.getDownNestedPreScrollRange();
            if (i11 != 0) {
                baseBehavior.q(this.f4585b, this.f4584a, viewN, i11, new int[]{0, 0});
                return true;
            }
        }
        return false;
    }
}
