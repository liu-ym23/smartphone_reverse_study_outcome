package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.animation.Positioning;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class FabTransformationSheetBehavior extends FabTransformationBehavior {

    @Nullable
    private Map<View, Integer> importantForAccessibilityMap;

    public FabTransformationSheetBehavior() {
    }

    private void updateImportantForAccessibility(@NonNull View r10, boolean r11) {
        ViewParent r12 = r10.getParent();
        if ((r12 instanceof CoordinatorLayout) == true) goto L5;
        return;
    L5:
        CoordinatorLayout r13 = (CoordinatorLayout) r12;
        int r14 = r13.getChildCount();
        if (r11 == false) goto L8;
        this.importantForAccessibilityMap = new HashMap(r14);
    L8:
        int r15 = 0;
    L9:
        if (r15 >= r14) goto L27;
        View r16 = r13.getChildAt(r15);
        if ((r16.getLayoutParams() instanceof CoordinatorLayout.c) == true) goto L13;
    L15:
        boolean r17 = false;
    L16:
        if (r16 == r10) goto L26;
        if (r17 == true) goto L26;
        if (r11 == true) goto L25;
        Map<View, Integer> r18 = this.importantForAccessibilityMap;
        if (r18 == null) goto L26;
        if (r18.containsKey(r16) == false) goto L26;
        ViewCompat.A0(r16, this.importantForAccessibilityMap.get(r16).intValue());
        goto L26
    L25:
        this.importantForAccessibilityMap.put(r16, Integer.valueOf(r16.getImportantForAccessibility()));
        ViewCompat.A0(r16, 4);
    L26:
        r15 = r15 + 1;
        goto L9
    L13:
        if ((((CoordinatorLayout.c) r16.getLayoutParams()).f() instanceof FabTransformationScrimBehavior) == false) goto L15;
        r17 = true;
        goto L16
    L27:
        if (r11 == true) goto L37;
        this.importantForAccessibilityMap = null;
        return;
    }

    @Override // com.google.android.material.transformation.FabTransformationBehavior
    @NonNull
    public FabTransformationBehavior.FabTransformationSpec onCreateMotionSpec(Context r10, boolean r11) {
        if (r11 == false) goto L4;
        int r12 = R.animator.mtrl_fab_transformation_sheet_expand_spec;
    L5:
        FabTransformationBehavior.FabTransformationSpec r13 = new FabTransformationBehavior.FabTransformationSpec();
        r13.timings = MotionSpec.createFromResource(r10, r12);
        r13.positioning = new Positioning(17, 0.0f, 0.0f);
        return r13;
    L4:
        r12 = R.animator.mtrl_fab_transformation_sheet_collapse_spec;
        goto L5
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior, com.google.android.material.transformation.ExpandableBehavior
    @CallSuper
    public boolean onExpandedStateChange(@NonNull View r10, @NonNull View r11, boolean r12, boolean r13) {
        updateImportantForAccessibility(r11, r12);
        return super.onExpandedStateChange(r10, r11, r12, r13);
    }

    public FabTransformationSheetBehavior(Context r10, AttributeSet r11) {
        super(r10, r11);
    }
}
