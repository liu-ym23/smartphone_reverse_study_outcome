package com.google.android.material.appbar;

import K.C0069b;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* loaded from: classes.dex */
public final class c extends C0069b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f10287a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CoordinatorLayout f10288b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AppBarLayout$BaseBehavior f10289c;

    public c(CoordinatorLayout coordinatorLayout, AppBarLayout$BaseBehavior appBarLayout$BaseBehavior, h hVar) {
        this.f10289c = appBarLayout$BaseBehavior;
        this.f10287a = hVar;
        this.f10288b = coordinatorLayout;
    }

    @Override // K.C0069b
    public final void onInitializeAccessibilityNodeInfo(View view, L.g gVar) {
        super.onInitializeAccessibilityNodeInfo(view, gVar);
        gVar.g(ScrollView.class.getName());
        h hVar = this.f10287a;
        if (hVar.getTotalScrollRange() == 0) {
            return;
        }
        CoordinatorLayout coordinatorLayout = this.f10288b;
        AppBarLayout$BaseBehavior appBarLayout$BaseBehavior = this.f10289c;
        View viewF = AppBarLayout$BaseBehavior.f(appBarLayout$BaseBehavior, coordinatorLayout);
        if (viewF == null) {
            return;
        }
        appBarLayout$BaseBehavior.getClass();
        int childCount = hVar.getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            if (((f) hVar.getChildAt(i4).getLayoutParams()).f10290a != 0) {
                if (appBarLayout$BaseBehavior.c() != (-hVar.getTotalScrollRange())) {
                    gVar.b(L.b.f1130f);
                    gVar.h(true);
                }
                if (appBarLayout$BaseBehavior.c() != 0) {
                    if (!viewF.canScrollVertically(-1)) {
                        gVar.b(L.b.f1131g);
                        gVar.h(true);
                        return;
                    } else {
                        if ((-hVar.getDownNestedPreScrollRange()) != 0) {
                            gVar.b(L.b.f1131g);
                            gVar.h(true);
                            return;
                        }
                        return;
                    }
                }
                return;
            }
        }
    }

    @Override // K.C0069b
    public final boolean performAccessibilityAction(View view, int i4, Bundle bundle) {
        h hVar = this.f10287a;
        if (i4 == 4096) {
            hVar.setExpanded(false);
            return true;
        }
        if (i4 != 8192) {
            return super.performAccessibilityAction(view, i4, bundle);
        }
        AppBarLayout$BaseBehavior appBarLayout$BaseBehavior = this.f10289c;
        if (appBarLayout$BaseBehavior.c() != 0) {
            View viewF = AppBarLayout$BaseBehavior.f(appBarLayout$BaseBehavior, this.f10288b);
            if (!viewF.canScrollVertically(-1)) {
                hVar.setExpanded(true);
                return true;
            }
            int i5 = -hVar.getDownNestedPreScrollRange();
            if (i5 != 0) {
                CoordinatorLayout coordinatorLayout = this.f10288b;
                h hVar2 = this.f10287a;
                this.f10289c.i(coordinatorLayout, hVar2, viewF, i5, new int[]{0, 0});
                return true;
            }
        }
        return false;
    }
}
