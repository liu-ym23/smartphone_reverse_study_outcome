package com.google.android.material.transformation;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.animation.c;
import com.google.android.material.animation.e;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class FabTransformationSheetBehavior extends FabTransformationBehavior {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<View, Integer> f13698a;

    public FabTransformationSheetBehavior() {
    }

    public FabTransformationSheetBehavior(Context r3, AttributeSet r4) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.google.android.material.transformation.FabTransformationBehavior
    public FabTransformationBehavior.a a(Context r2, boolean r3) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (r3 == false) goto L5;
        int r4 = ZeusTransformUtils.mapRes(R.animator.mtrl_fab_transformation_sheet_expand_spec, "animator", "mtrl_fab_transformation_sheet_expand_spec");
    L6:
        FabTransformationBehavior.a r5 = new FabTransformationBehavior.a();
        r5.f13694a = c.a(r1, r4);
        r5.f13695b = new e(17, 0.0f, 0.0f);
        return r5;
    L5:
        r4 = ZeusTransformUtils.mapRes(R.animator.mtrl_fab_transformation_sheet_collapse_spec, "animator", "mtrl_fab_transformation_sheet_collapse_spec");
        goto L6
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior, com.google.android.material.transformation.ExpandableBehavior
    public boolean a(View r1, View r2, boolean r3, boolean r4) {
        a(r2, r3);
        return super.a(r1, r2, r3, r4);
    }

    private void a(View r10, boolean r11) {
        ViewParent r0 = r10.getParent();
        if (ZeusTransformUtils.instanceOf(r0, CoordinatorLayout.class) == true) goto L5;
        return;
    L5:
        CoordinatorLayout r1 = (CoordinatorLayout) ZeusTransformUtils.preCheckCast(r0, CoordinatorLayout.class, "com.obric.aiagent.plugin");
        int r2 = r1.getChildCount();
        if (Build.VERSION.SDK_INT < 16) goto L9;
        if (r11 == false) goto L9;
        this.f13698a = new HashMap(r2);
    L9:
        int r5 = 0;
    L10:
        if (r5 >= r2) goto L31;
        View r6 = r1.getChildAt(r5);
        if (ZeusTransformUtils.instanceOf(r6.getLayoutParams(), CoordinatorLayout.LayoutParams.class) == true) goto L14;
    L16:
        boolean r7 = false;
    L17:
        if (r6 == r10) goto L30;
        if (r7 == true) goto L30;
        if (r11 == true) goto L27;
        Map<View, Integer> r8 = this.f13698a;
        if (r8 == null) goto L30;
        if (r8.containsKey(r6) == false) goto L30;
        ViewCompat.c(r6, ((Integer) ZeusTransformUtils.preCheckCast(this.f13698a.get(r6), Integer.class, "com.obric.aiagent.plugin")).intValue());
        goto L30
    L27:
        if (Build.VERSION.SDK_INT < 16) goto L29;
        this.f13698a.put(r6, Integer.valueOf(r6.getImportantForAccessibility()));
    L29:
        ViewCompat.c(r6, 4);
    L30:
        r5 = r5 + 1;
        goto L10
    L14:
        if (ZeusTransformUtils.instanceOf(((CoordinatorLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r6.getLayoutParams(), CoordinatorLayout.LayoutParams.class, "com.obric.aiagent.plugin")).getBehavior(), FabTransformationScrimBehavior.class) == false) goto L16;
        r7 = true;
        goto L17
    L31:
        if (r11 == true) goto L41;
        this.f13698a = null;
        return;
    }
}
