package com.google.android.material.appbar;

import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.appbar.AppBarLayout;

/* loaded from: classes3.dex */
public final class d extends AccessibilityDelegateCompat {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AppBarLayout f2290a;
    public final /* synthetic */ CoordinatorLayout b;
    public final /* synthetic */ AppBarLayout.BaseBehavior c;

    public d(CoordinatorLayout coordinatorLayout, AppBarLayout.BaseBehavior baseBehavior, AppBarLayout appBarLayout) {
        this.c = baseBehavior;
        this.f2290a = appBarLayout;
        this.b = coordinatorLayout;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        accessibilityNodeInfoCompat.setClassName(ScrollView.class.getName());
        AppBarLayout appBarLayout = this.f2290a;
        if (appBarLayout.getTotalScrollRange() == 0) {
            return;
        }
        CoordinatorLayout coordinatorLayout = this.b;
        AppBarLayout.BaseBehavior baseBehavior = this.c;
        View viewF = AppBarLayout.BaseBehavior.f(baseBehavior, coordinatorLayout);
        if (viewF == null) {
            return;
        }
        baseBehavior.getClass();
        int childCount = appBarLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (((f) appBarLayout.getChildAt(i).getLayoutParams()).f2291a != 0) {
                if (baseBehavior.c() != (-appBarLayout.getTotalScrollRange())) {
                    accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
                    accessibilityNodeInfoCompat.setScrollable(true);
                }
                if (baseBehavior.c() != 0) {
                    if (!viewF.canScrollVertically(-1)) {
                        accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
                        accessibilityNodeInfoCompat.setScrollable(true);
                        return;
                    } else {
                        if ((-appBarLayout.getDownNestedPreScrollRange()) != 0) {
                            accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
                            accessibilityNodeInfoCompat.setScrollable(true);
                            return;
                        }
                        return;
                    }
                }
                return;
            }
        }
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public final boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        AppBarLayout appBarLayout = this.f2290a;
        if (i == 4096) {
            appBarLayout.setExpanded(false);
            return true;
        }
        if (i != 8192) {
            return super.performAccessibilityAction(view, i, bundle);
        }
        AppBarLayout.BaseBehavior baseBehavior = this.c;
        if (baseBehavior.c() != 0) {
            View viewF = AppBarLayout.BaseBehavior.f(baseBehavior, this.b);
            if (!viewF.canScrollVertically(-1)) {
                appBarLayout.setExpanded(true);
                return true;
            }
            int i6 = -appBarLayout.getDownNestedPreScrollRange();
            if (i6 != 0) {
                baseBehavior.i(this.b, this.f2290a, viewF, i6, new int[]{0, 0});
                return true;
            }
        }
        return false;
    }
}
