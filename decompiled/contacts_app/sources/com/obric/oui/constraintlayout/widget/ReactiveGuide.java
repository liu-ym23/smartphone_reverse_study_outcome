package com.obric.oui.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import com.obric.oui.constraintlayout.motion.widget.MotionLayout;

/* JADX INFO: loaded from: classes3.dex */
public class ReactiveGuide extends View implements SharedValues.SharedValuesListener {
    private boolean mAnimateChange;
    private boolean mApplyToAllConstraintSets;
    private int mApplyToConstraintSetId;
    private int mAttributeId;

    @Override // android.view.View
    public void draw(Canvas r1) {
    }

    @Override // android.view.View
    public void setVisibility(int r1) {
    }

    public ReactiveGuide(Context r1) {
        super(r1);
        this.mAttributeId = -1;
        this.mAnimateChange = false;
        this.mApplyToConstraintSetId = 0;
        this.mApplyToAllConstraintSets = true;
        super.setVisibility(8);
        init(null);
    }

    public ReactiveGuide(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.mAttributeId = -1;
        this.mAnimateChange = false;
        this.mApplyToConstraintSetId = 0;
        this.mApplyToAllConstraintSets = true;
        super.setVisibility(8);
        init(r2);
    }

    public ReactiveGuide(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.mAttributeId = -1;
        this.mAnimateChange = false;
        this.mApplyToConstraintSetId = 0;
        this.mApplyToAllConstraintSets = true;
        super.setVisibility(8);
        init(r2);
    }

    public ReactiveGuide(Context r1, AttributeSet r2, int r3, int r4) {
        super(r1, r2, r3);
        this.mAttributeId = -1;
        this.mAnimateChange = false;
        this.mApplyToConstraintSetId = 0;
        this.mApplyToAllConstraintSets = true;
        super.setVisibility(8);
        init(r2);
    }

    private void init(AttributeSet r5) {
        if (r5 == null) goto L20;
        TypedArray r6 = getContext().obtainStyledAttributes(r5, R.styleable.ConstraintLayout_ReactiveGuide);
        int r0 = r6.getIndexCount();
        int r1 = 0;
    L4:
        if (r1 >= r0) goto L18;
        int r2 = r6.getIndex(r1);
        if (r2 != R.styleable.ConstraintLayout_ReactiveGuide_reactiveGuide_valueId) goto L9;
        this.mAttributeId = r6.getResourceId(r2, this.mAttributeId);
    L17:
        r1 = r1 + 1;
        goto L4
    L9:
        if (r2 != R.styleable.ConstraintLayout_ReactiveGuide_reactiveGuide_animateChange) goto L12;
        this.mAnimateChange = r6.getBoolean(r2, this.mAnimateChange);
        goto L17
    L12:
        if (r2 != R.styleable.ConstraintLayout_ReactiveGuide_reactiveGuide_applyToConstraintSet) goto L15;
        this.mApplyToConstraintSetId = r6.getResourceId(r2, this.mApplyToConstraintSetId);
        goto L17
    L15:
        if (r2 != R.styleable.ConstraintLayout_ReactiveGuide_reactiveGuide_applyToAllConstraintSets) goto L17;
        this.mApplyToAllConstraintSets = r6.getBoolean(r2, this.mApplyToAllConstraintSets);
        goto L17
    L18:
        r6.recycle();
    L20:
        if (this.mAttributeId == (-1)) goto L29;
        ConstraintLayout.getSharedValues().addListener(this.mAttributeId, this);
        return;
    }

    public int getAttributeId() {
        return this.mAttributeId;
    }

    public void setAttributeId(int r4) {
        SharedValues r0 = ConstraintLayout.getSharedValues();
        int r1 = this.mAttributeId;
        if (r1 == (-1)) goto L5;
        r0.removeListener(r1, this);
    L5:
        this.mAttributeId = r4;
        if (r4 == (-1)) goto L9;
        r0.addListener(r4, this);
        return;
    }

    public int getApplyToConstraintSetId() {
        return this.mApplyToConstraintSetId;
    }

    public void setApplyToConstraintSetId(int r1) {
        this.mApplyToConstraintSetId = r1;
    }

    public boolean isAnimatingChange() {
        return this.mAnimateChange;
    }

    public void setAnimateChange(boolean r1) {
        this.mAnimateChange = r1;
    }

    @Override // android.view.View
    protected void onMeasure(int r1, int r2) {
        setMeasuredDimension(0, 0);
    }

    public void setGuidelineBegin(int r2) {
        ConstraintLayout.LayoutParams r0 = (ConstraintLayout.LayoutParams) getLayoutParams();
        r0.guideBegin = r2;
        setLayoutParams(r0);
    }

    public void setGuidelineEnd(int r2) {
        ConstraintLayout.LayoutParams r0 = (ConstraintLayout.LayoutParams) getLayoutParams();
        r0.guideEnd = r2;
        setLayoutParams(r0);
    }

    public void setGuidelinePercent(float r2) {
        ConstraintLayout.LayoutParams r0 = (ConstraintLayout.LayoutParams) getLayoutParams();
        r0.guidePercent = r2;
        setLayoutParams(r0);
    }

    @Override // com.obric.oui.constraintlayout.widget.SharedValues.SharedValuesListener
    public void onNewValue(int r5, int r6, int r7) {
        setGuidelineBegin(r6);
        int r8 = getId();
        if (r8 > 0) goto L6;
        return;
    L6:
        if ((getParent() instanceof MotionLayout) == false) goto L34;
        MotionLayout r9 = (MotionLayout) getParent();
        int r0 = r9.getCurrentState();
        int r1 = this.mApplyToConstraintSetId;
        if (r1 == 0) goto L10;
        r0 = r1;
    L10:
        int r2 = 0;
        if (this.mAnimateChange == false) goto L23;
        if (this.mApplyToAllConstraintSets == false) goto L21;
        int[] r3 = r9.getConstraintSetIds();
    L16:
        if (r2 >= r3.length) goto L21;
        int r4 = r3[r2];
        if (r4 == r0) goto L20;
        changeValue(r6, r8, r9, r4);
    L20:
        r2 = r2 + 1;
    L21:
        ConstraintSet r10 = r9.cloneConstraintSet(r0);
        r10.setGuidelineEnd(r8, r6);
        r9.updateStateAnimate(r0, r10, 1000);
        return;
    L23:
        if (this.mApplyToAllConstraintSets == false) goto L28;
        int[] r11 = r9.getConstraintSetIds();
    L26:
        if (r2 >= r11.length) goto L36;
        changeValue(r6, r8, r9, r11[r2]);
        r2 = r2 + 1;
        goto L26
    L36:
        return;
    L28:
        changeValue(r6, r8, r9, r0);
        return;
    }

    private void changeValue(int r1, int r2, MotionLayout r3, int r4) {
        ConstraintSet r0 = r3.getConstraintSet(r4);
        r0.setGuidelineEnd(r2, r1);
        r3.updateState(r4, r0);
    }
}
