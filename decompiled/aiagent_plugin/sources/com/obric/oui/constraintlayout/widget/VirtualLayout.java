package com.obric.oui.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import com.obric.aiagent.plugin.R;
import com.obric.oui.constraintlayout.a.c.m;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public abstract class VirtualLayout extends ConstraintHelper {
    private boolean mApplyElevationOnAttach;
    private boolean mApplyVisibilityOnAttach;

    public void onMeasure(m r1, int r2, int r3) {
    }

    public VirtualLayout(Context r3) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"));
    }

    public VirtualLayout(Context r3, AttributeSet r4) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin"));
    }

    public VirtualLayout(Context r3, AttributeSet r4, int r5) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin"), r5);
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintHelper
    public void init(AttributeSet r8) {
        AttributeSet r9 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r8, AttributeSet.class, "com.obric.aiagent.plugin");
        super.init(r9);
        if (r9 == null) goto L19;
        TypedArray r10 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).obtainStyledAttributes(r9, R.styleable.ConstraintLayout_Layout);
        int r0 = r10.getIndexCount();
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L13;
        int r2 = r10.getIndex(r1);
        if (r2 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_android_visibility, "styleable", "ConstraintLayout_Layout_android_visibility")) goto L10;
        this.mApplyVisibilityOnAttach = true;
    L12:
        r1 = r1 + 1;
        goto L5
    L10:
        if (r2 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_android_elevation, "styleable", "ConstraintLayout_Layout_android_elevation")) goto L12;
        this.mApplyElevationOnAttach = true;
        goto L12
    L13:
        r10.recycle();
        return;
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintHelper, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mApplyVisibilityOnAttach == false) goto L5;
    L6:
        ViewParent r0 = getParent();
        if (ZeusTransformUtils.instanceOf(r0, ConstraintLayout.class) == false) goto L28;
        ConstraintLayout r1 = (ConstraintLayout) ZeusTransformUtils.preCheckCast(r0, ConstraintLayout.class, "com.obric.aiagent.plugin");
        int r2 = getVisibility();
        float r3 = getElevation();
        int r4 = 0;
    L10:
        if (r4 >= this.mCount) goto L29;
        View r5 = r1.getViewById(this.mIds[r4]);
        if (r5 == null) goto L21;
        if (this.mApplyVisibilityOnAttach == false) goto L17;
        r5.setVisibility(r2);
    L17:
        if (this.mApplyElevationOnAttach == false) goto L21;
        if (r3 <= 0.0f) goto L21;
        r5.setTranslationZ(r5.getTranslationZ() + r3);
    L21:
        r4 = r4 + 1;
        goto L10
    L29:
        return;
    L28:
        return;
    L5:
        if (this.mApplyElevationOnAttach == true) goto L6;
    }

    @Override // android.view.View
    public void setVisibility(int r1) {
        super.setVisibility(r1);
        applyLayoutFeatures();
    }

    @Override // android.view.View
    public void setElevation(float r1) {
        super.setElevation(r1);
        applyLayoutFeatures();
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintHelper
    public void applyLayoutFeaturesInConstraintSet(ConstraintLayout r1) {
        applyLayoutFeatures(r1);
    }
}
