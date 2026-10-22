package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;

/* JADX INFO: loaded from: classes.dex */
public class ReactiveGuide extends View implements SharedValues.SharedValuesListener {
    private boolean mAnimateChange;
    private boolean mApplyToAllConstraintSets;
    private int mApplyToConstraintSetId;
    private int mAttributeId;

    @Override // android.view.View
    public void draw(Canvas canvas) {
    }

    @Override // android.view.View
    public void setVisibility(int visibility) {
    }

    public ReactiveGuide(Context context) {
        super(context);
        this.mAttributeId = -1;
        this.mAnimateChange = false;
        this.mApplyToConstraintSetId = 0;
        this.mApplyToAllConstraintSets = true;
        super.setVisibility(8);
        init(null);
    }

    public ReactiveGuide(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mAttributeId = -1;
        this.mAnimateChange = false;
        this.mApplyToConstraintSetId = 0;
        this.mApplyToAllConstraintSets = true;
        super.setVisibility(8);
        init(attrs);
    }

    public ReactiveGuide(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mAttributeId = -1;
        this.mAnimateChange = false;
        this.mApplyToConstraintSetId = 0;
        this.mApplyToAllConstraintSets = true;
        super.setVisibility(8);
        init(attrs);
    }

    public ReactiveGuide(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr);
        this.mAttributeId = -1;
        this.mAnimateChange = false;
        this.mApplyToConstraintSetId = 0;
        this.mApplyToAllConstraintSets = true;
        super.setVisibility(8);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        if (attrs == null) goto L20;
        TypedArray r5 = getContext().obtainStyledAttributes(attrs, R.styleable.ConstraintLayout_ReactiveGuide);
        int r0 = r5.getIndexCount();
        int r1 = 0;
    L4:
        if (r1 >= r0) goto L18;
        int r2 = r5.getIndex(r1);
        if (r2 != R.styleable.ConstraintLayout_ReactiveGuide_reactiveGuide_valueId) goto L9;
        this.mAttributeId = r5.getResourceId(r2, this.mAttributeId);
    L17:
        r1 = r1 + 1;
        goto L4
    L9:
        if (r2 != R.styleable.ConstraintLayout_ReactiveGuide_reactiveGuide_animateChange) goto L12;
        this.mAnimateChange = r5.getBoolean(r2, this.mAnimateChange);
        goto L17
    L12:
        if (r2 != R.styleable.ConstraintLayout_ReactiveGuide_reactiveGuide_applyToConstraintSet) goto L15;
        this.mApplyToConstraintSetId = r5.getResourceId(r2, this.mApplyToConstraintSetId);
        goto L17
    L15:
        if (r2 != R.styleable.ConstraintLayout_ReactiveGuide_reactiveGuide_applyToAllConstraintSets) goto L17;
        this.mApplyToAllConstraintSets = r5.getBoolean(r2, this.mApplyToAllConstraintSets);
        goto L17
    L18:
        r5.recycle();
    L20:
        if (this.mAttributeId == (-1)) goto L29;
        ConstraintLayout.getSharedValues().addListener(this.mAttributeId, this);
        return;
    }

    public int getAttributeId() {
        return this.mAttributeId;
    }

    public void setAttributeId(int id) {
        SharedValues r0 = ConstraintLayout.getSharedValues();
        int r1 = this.mAttributeId;
        if (r1 == (-1)) goto L5;
        r0.removeListener(r1, this);
    L5:
        this.mAttributeId = id;
        if (id == (-1)) goto L9;
        r0.addListener(id, this);
        return;
    }

    public int getApplyToConstraintSetId() {
        return this.mApplyToConstraintSetId;
    }

    public void setApplyToConstraintSetId(int id) {
        this.mApplyToConstraintSetId = id;
    }

    public boolean isAnimatingChange() {
        return this.mAnimateChange;
    }

    public void setAnimateChange(boolean animate) {
        this.mAnimateChange = animate;
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(0, 0);
    }

    public void setGuidelineBegin(int margin) {
        ConstraintLayout.LayoutParams r0 = (ConstraintLayout.LayoutParams) getLayoutParams();
        r0.guideBegin = margin;
        setLayoutParams(r0);
    }

    public void setGuidelineEnd(int margin) {
        ConstraintLayout.LayoutParams r0 = (ConstraintLayout.LayoutParams) getLayoutParams();
        r0.guideEnd = margin;
        setLayoutParams(r0);
    }

    public void setGuidelinePercent(float ratio) {
        ConstraintLayout.LayoutParams r0 = (ConstraintLayout.LayoutParams) getLayoutParams();
        r0.guidePercent = ratio;
        setLayoutParams(r0);
    }

    @Override // androidx.constraintlayout.widget.SharedValues.SharedValuesListener
    public void onNewValue(int key, int newValue, int oldValue) {
        setGuidelineBegin(newValue);
        int r5 = getId();
        if (r5 > 0) goto L6;
        return;
    L6:
        if ((getParent() instanceof MotionLayout) == false) goto L34;
        MotionLayout r7 = (MotionLayout) getParent();
        int r0 = r7.getCurrentState();
        int r1 = this.mApplyToConstraintSetId;
        if (r1 == 0) goto L10;
        r0 = r1;
    L10:
        int r2 = 0;
        if (this.mAnimateChange == false) goto L23;
        if (this.mApplyToAllConstraintSets == false) goto L21;
        int[] r3 = r7.getConstraintSetIds();
    L16:
        if (r2 >= r3.length) goto L21;
        int r4 = r3[r2];
        if (r4 == r0) goto L20;
        changeValue(newValue, r5, r7, r4);
    L20:
        r2 = r2 + 1;
    L21:
        ConstraintSet r6 = r7.cloneConstraintSet(r0);
        r6.setGuidelineEnd(r5, newValue);
        r7.updateStateAnimate(r0, r6, 1000);
        return;
    L23:
        if (this.mApplyToAllConstraintSets == false) goto L28;
        int[] r8 = r7.getConstraintSetIds();
    L26:
        if (r2 >= r8.length) goto L36;
        changeValue(newValue, r5, r7, r8[r2]);
        r2 = r2 + 1;
        goto L26
    L36:
        return;
    L28:
        changeValue(newValue, r5, r7, r0);
        return;
    }

    private void changeValue(int newValue, int id, MotionLayout motionLayout, int currentState) {
        ConstraintSet r0 = motionLayout.getConstraintSet(currentState);
        r0.setGuidelineEnd(id, newValue);
        motionLayout.updateState(currentState, r0);
    }
}
