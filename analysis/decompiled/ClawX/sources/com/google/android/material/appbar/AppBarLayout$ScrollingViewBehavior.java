package com.google.android.material.appbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import e0.a0;
import f1.a;
import java.util.ArrayList;
import t.d;
import x.f;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class AppBarLayout$ScrollingViewBehavior extends a {

    /* renamed from: b, reason: collision with root package name */
    public final int f1205b;

    public AppBarLayout$ScrollingViewBehavior() {
        new Rect();
        new Rect();
    }

    public static void s(ArrayList arrayList) {
        int size = arrayList.size();
        for (int i8 = 0; i8 < size; i8++) {
        }
    }

    @Override // t.a
    public boolean d(CoordinatorLayout coordinatorLayout, View view, View view2) {
        if (((d) view2.getLayoutParams()).f5389a instanceof AppBarLayout$BaseBehavior) {
            int bottom = view2.getBottom() - view.getTop();
            int i8 = this.f1205b;
            int iT = bottom - (i8 == 0 ? 0 : f.t((int) (0.0f * i8), 0, i8));
            int[] iArr = a0.f2285a;
            view.offsetTopAndBottom(iT);
        }
        return false;
    }

    @Override // t.a
    public final boolean h(CoordinatorLayout coordinatorLayout, View view, int i8, int i9, int i10) {
        int i11 = view.getLayoutParams().height;
        if (i11 != -1 && i11 != -2) {
            return false;
        }
        s(coordinatorLayout.j(view));
        return false;
    }

    @Override // t.a
    public final void l(CoordinatorLayout coordinatorLayout, View view) {
        s(coordinatorLayout.j(view));
    }

    @Override // f1.a
    public final void r(CoordinatorLayout coordinatorLayout, View view, int i8) {
        s(coordinatorLayout.j(view));
        coordinatorLayout.q(view, i8);
    }

    public AppBarLayout$ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
        new Rect();
        new Rect();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d1.a.f1776r);
        this.f1205b = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // t.a
    public final void b(View view) {
    }
}
