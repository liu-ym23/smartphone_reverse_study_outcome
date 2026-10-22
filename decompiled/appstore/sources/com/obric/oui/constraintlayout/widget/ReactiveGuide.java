package com.obric.oui.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import com.obric.oui.constraintlayout.motion.widget.MotionLayout;

/* JADX INFO: loaded from: classes4.dex */
public class ReactiveGuide extends View implements SharedValues.SharedValuesListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f14153a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f14154b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f14155c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f14156d;

    public ReactiveGuide(Context r10) {
        super(r10);
        this.f14153a = -1;
        this.f14154b = false;
        this.f14155c = 0;
        this.f14156d = true;
        super.setVisibility(8);
        b(null);
    }

    public final void a(int r10, int r11, MotionLayout r12, int r13) {
        a r14 = r12.j0(r13);
        r14.Q(r11, r10);
        r12.I0(r13, r14);
    }

    public final void b(AttributeSet r10) {
        if (r10 == null) goto L20;
        TypedArray r11 = getContext().obtainStyledAttributes(r10, R$styleable.ConstraintLayout_ReactiveGuide);
        int r12 = r11.getIndexCount();
        int r13 = 0;
    L4:
        if (r13 >= r12) goto L18;
        int r14 = r11.getIndex(r13);
        if (r14 != R$styleable.ConstraintLayout_ReactiveGuide_reactiveGuide_valueId) goto L9;
        this.f14153a = r11.getResourceId(r14, this.f14153a);
    L17:
        r13 = r13 + 1;
        goto L4
    L9:
        if (r14 != R$styleable.ConstraintLayout_ReactiveGuide_reactiveGuide_animateChange) goto L12;
        this.f14154b = r11.getBoolean(r14, this.f14154b);
        goto L17
    L12:
        if (r14 != R$styleable.ConstraintLayout_ReactiveGuide_reactiveGuide_applyToConstraintSet) goto L15;
        this.f14155c = r11.getResourceId(r14, this.f14155c);
        goto L17
    L15:
        if (r14 != R$styleable.ConstraintLayout_ReactiveGuide_reactiveGuide_applyToAllConstraintSets) goto L17;
        this.f14156d = r11.getBoolean(r14, this.f14156d);
        goto L17
    L18:
        r11.recycle();
    L20:
        if (this.f14153a == (-1)) goto L29;
        ConstraintLayout.getSharedValues().a(this.f14153a, this);
        return;
    }

    @Override // android.view.View
    public void draw(Canvas r10) {
    }

    public int getApplyToConstraintSetId() {
        return this.f14155c;
    }

    public int getAttributeId() {
        return this.f14153a;
    }

    @Override // android.view.View
    public void onMeasure(int r10, int r11) {
        setMeasuredDimension(0, 0);
    }

    @Override // com.obric.oui.constraintlayout.widget.SharedValues.SharedValuesListener
    public void onNewValue(int r10, int r11, int r12) {
        setGuidelineBegin(r11);
        int r13 = getId();
        if (r13 > 0) goto L6;
        return;
    L6:
        if ((getParent() instanceof MotionLayout) == false) goto L34;
        MotionLayout r14 = (MotionLayout) getParent();
        int r15 = r14.getCurrentState();
        int r16 = this.f14155c;
        if (r16 == 0) goto L10;
        r15 = r16;
    L10:
        int r17 = 0;
        if (this.f14154b == false) goto L23;
        if (this.f14156d == false) goto L21;
        int[] r18 = r14.getConstraintSetIds();
    L16:
        if (r17 >= r18.length) goto L21;
        int r19 = r18[r17];
        if (r19 == r15) goto L20;
        a(r11, r13, r14, r19);
    L20:
        r17 = r17 + 1;
    L21:
        a r20 = r14.Z(r15);
        r20.Q(r13, r11);
        r14.J0(r15, r20, 1000);
        return;
    L23:
        if (this.f14156d == false) goto L28;
        int[] r21 = r14.getConstraintSetIds();
    L26:
        if (r17 >= r21.length) goto L36;
        a(r11, r13, r14, r21[r17]);
        r17 = r17 + 1;
        goto L26
    L36:
        return;
    L28:
        a(r11, r13, r14, r15);
        return;
    }

    public void setAnimateChange(boolean r10) {
        this.f14154b = r10;
    }

    public void setApplyToConstraintSetId(int r10) {
        this.f14155c = r10;
    }

    public void setAttributeId(int r10) {
        SharedValues r11 = ConstraintLayout.getSharedValues();
        int r12 = this.f14153a;
        if (r12 == (-1)) goto L5;
        r11.b(r12, this);
    L5:
        this.f14153a = r10;
        if (r10 == (-1)) goto L9;
        r11.a(r10, this);
        return;
    }

    public void setGuidelineBegin(int r10) {
        ConstraintLayout.LayoutParams r11 = (ConstraintLayout.LayoutParams) getLayoutParams();
        r11.f14086a = r10;
        setLayoutParams(r11);
    }

    public void setGuidelineEnd(int r10) {
        ConstraintLayout.LayoutParams r11 = (ConstraintLayout.LayoutParams) getLayoutParams();
        r11.f14088b = r10;
        setLayoutParams(r11);
    }

    public void setGuidelinePercent(float r10) {
        ConstraintLayout.LayoutParams r11 = (ConstraintLayout.LayoutParams) getLayoutParams();
        r11.f14090c = r10;
        setLayoutParams(r11);
    }

    @Override // android.view.View
    public void setVisibility(int r10) {
    }

    public ReactiveGuide(Context r10, AttributeSet r11) {
        super(r10, r11);
        this.f14153a = -1;
        this.f14154b = false;
        this.f14155c = 0;
        this.f14156d = true;
        super.setVisibility(8);
        b(r11);
    }

    public ReactiveGuide(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.f14153a = -1;
        this.f14154b = false;
        this.f14155c = 0;
        this.f14156d = true;
        super.setVisibility(8);
        b(r11);
    }
}
