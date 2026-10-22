package com.google.android.material.transformation;

import a1.C0408a;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import b1.h;
import b1.j;
import com.google.android.material.transformation.FabTransformationBehavior;
import java.util.HashMap;
import java.util.Map;

@Deprecated
/* loaded from: classes.dex */
public class FabTransformationSheetBehavior extends FabTransformationBehavior {

    /* renamed from: i, reason: collision with root package name */
    private Map<View, Integer> f13536i;

    public FabTransformationSheetBehavior() {
    }

    private void E(View view, boolean z5) {
        ViewParent parent = view.getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (z5) {
                this.f13536i = new HashMap(childCount);
            }
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = coordinatorLayout.getChildAt(i5);
                boolean z6 = (childAt.getLayoutParams() instanceof CoordinatorLayout.f) && (((CoordinatorLayout.f) childAt.getLayoutParams()).f() instanceof FabTransformationScrimBehavior);
                if (childAt != view && !z6) {
                    if (z5) {
                        this.f13536i.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                        childAt.setImportantForAccessibility(4);
                    } else {
                        Map<View, Integer> map = this.f13536i;
                        if (map != null && map.containsKey(childAt)) {
                            childAt.setImportantForAccessibility(this.f13536i.get(childAt).intValue());
                        }
                    }
                }
            }
            if (z5) {
                return;
            }
            this.f13536i = null;
        }
    }

    @Override // com.google.android.material.transformation.FabTransformationBehavior
    protected FabTransformationBehavior.e C(Context context, boolean z5) {
        int i5 = z5 ? C0408a.f6690d : C0408a.f6689c;
        FabTransformationBehavior.e eVar = new FabTransformationBehavior.e();
        eVar.f13529a = h.c(context, i5);
        eVar.f13530b = new j(17, 0.0f, 0.0f);
        return eVar;
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior, com.google.android.material.transformation.ExpandableBehavior
    protected boolean f(View view, View view2, boolean z5, boolean z6) {
        E(view2, z5);
        return super.f(view, view2, z5, z6);
    }

    public FabTransformationSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
