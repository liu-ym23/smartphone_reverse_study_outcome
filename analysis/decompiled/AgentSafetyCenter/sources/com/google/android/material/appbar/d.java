package com.google.android.material.appbar;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import u1.g0;
import v1.t;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d extends n3.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2334a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f2335b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f2336c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f2337d;

    public d(t tVar, g0 g0Var, t tVar2) {
        this.f2335b = tVar;
        this.f2336c = g0Var;
        this.f2337d = tVar2;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0055  */
    @Override // n3.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onInitializeAccessibilityNodeInfo(android.view.View r8, o3.e r9) {
        /*
            Method dump skipped, instructions count: 284
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.d.onInitializeAccessibilityNodeInfo(android.view.View, o3.e):void");
    }

    @Override // n3.b
    public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        switch (this.f2334a) {
            case 0:
                AppBarLayout$BaseBehavior appBarLayout$BaseBehavior = (AppBarLayout$BaseBehavior) this.f2337d;
                g gVar = (g) this.f2335b;
                if (i != 4096) {
                    if (i != 8192) {
                        break;
                    } else {
                        if (appBarLayout$BaseBehavior.f() != 0) {
                            View viewC = AppBarLayout$BaseBehavior.c(appBarLayout$BaseBehavior, (androidx.coordinatorlayout.widget.a) this.f2336c);
                            if (!viewC.canScrollVertically(-1)) {
                                gVar.setExpanded(true);
                                break;
                            } else {
                                int i3 = -gVar.getDownNestedPreScrollRange();
                                if (i3 != 0) {
                                    appBarLayout$BaseBehavior.g((androidx.coordinatorlayout.widget.a) this.f2336c, (g) this.f2335b, viewC, i3, new int[]{0, 0});
                                    break;
                                }
                            }
                        }
                        break;
                    }
                } else {
                    gVar.setExpanded(false);
                    break;
                }
        }
        return super.performAccessibilityAction(view, i, bundle);
    }

    public d(AppBarLayout$BaseBehavior appBarLayout$BaseBehavior, g gVar, androidx.coordinatorlayout.widget.a aVar) {
        this.f2337d = appBarLayout$BaseBehavior;
        this.f2335b = gVar;
        this.f2336c = aVar;
    }
}
