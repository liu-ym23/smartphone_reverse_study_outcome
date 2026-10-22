package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class ReactiveGuide extends View implements e.a {
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

    public ReactiveGuide(Context r3) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"));
        this.mAttributeId = -1;
        this.mAnimateChange = false;
        this.mApplyToConstraintSetId = 0;
        this.mApplyToAllConstraintSets = true;
        super.setVisibility(8);
        init(null);
    }

    public ReactiveGuide(Context r3, AttributeSet r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        super(r5, r6);
        this.mAttributeId = -1;
        this.mAnimateChange = false;
        this.mApplyToConstraintSetId = 0;
        this.mApplyToAllConstraintSets = true;
        super.setVisibility(8);
        init(r6);
    }

    public ReactiveGuide(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        super(r6, r7, r5);
        this.mAttributeId = -1;
        this.mAnimateChange = false;
        this.mApplyToConstraintSetId = 0;
        this.mApplyToAllConstraintSets = true;
        super.setVisibility(8);
        init(r7);
    }

    public ReactiveGuide(Context r2, AttributeSet r3, int r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        super(r6, r7, r4);
        this.mAttributeId = -1;
        this.mAnimateChange = false;
        this.mApplyToConstraintSetId = 0;
        this.mApplyToAllConstraintSets = true;
        super.setVisibility(8);
        init(r7);
    }

    private void init(AttributeSet r7) {
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r7, AttributeSet.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L21;
        TypedArray r9 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).obtainStyledAttributes(r8, R.styleable.ConstraintLayout_ReactiveGuide);
        int r0 = r9.getIndexCount();
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L19;
        int r2 = r9.getIndex(r1);
        if (r2 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_ReactiveGuide_reactiveGuide_valueId, "styleable", "ConstraintLayout_ReactiveGuide_reactiveGuide_valueId")) goto L10;
        this.mAttributeId = r9.getResourceId(r2, this.mAttributeId);
    L18:
        r1 = r1 + 1;
        goto L5
    L10:
        if (r2 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_ReactiveGuide_reactiveGuide_animateChange, "styleable", "ConstraintLayout_ReactiveGuide_reactiveGuide_animateChange")) goto L13;
        this.mAnimateChange = r9.getBoolean(r2, this.mAnimateChange);
        goto L18
    L13:
        if (r2 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_ReactiveGuide_reactiveGuide_applyToConstraintSet, "styleable", "ConstraintLayout_ReactiveGuide_reactiveGuide_applyToConstraintSet")) goto L16;
        this.mApplyToConstraintSetId = r9.getResourceId(r2, this.mApplyToConstraintSetId);
        goto L18
    L16:
        if (r2 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_ReactiveGuide_reactiveGuide_applyToAllConstraintSets, "styleable", "ConstraintLayout_ReactiveGuide_reactiveGuide_applyToAllConstraintSets")) goto L18;
        this.mApplyToAllConstraintSets = r9.getBoolean(r2, this.mApplyToAllConstraintSets);
        goto L18
    L19:
        r9.recycle();
    L21:
        if (this.mAttributeId == (-1)) goto L30;
        ConstraintLayout.getSharedValues().a(this.mAttributeId, this);
        return;
    }

    public int getAttributeId() {
        return this.mAttributeId;
    }

    public void setAttributeId(int r4) {
        e r0 = ConstraintLayout.getSharedValues();
        int r1 = this.mAttributeId;
        if (r1 == (-1)) goto L5;
        r0.b(r1, this);
    L5:
        this.mAttributeId = r4;
        if (r4 == (-1)) goto L9;
        r0.a(r4, this);
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
    public void onMeasure(int r1, int r2) {
        setMeasuredDimension(0, 0);
    }

    public void setGuidelineBegin(int r4) {
        ConstraintLayout.LayoutParams r0 = (ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(getLayoutParams(), ConstraintLayout.LayoutParams.class, "com.obric.aiagent.plugin");
        r0.guideBegin = r4;
        setLayoutParams(r0);
    }

    public void setGuidelineEnd(int r4) {
        ConstraintLayout.LayoutParams r0 = (ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(getLayoutParams(), ConstraintLayout.LayoutParams.class, "com.obric.aiagent.plugin");
        r0.guideEnd = r4;
        setLayoutParams(r0);
    }

    public void setGuidelinePercent(float r4) {
        ConstraintLayout.LayoutParams r0 = (ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(getLayoutParams(), ConstraintLayout.LayoutParams.class, "com.obric.aiagent.plugin");
        r0.guidePercent = r4;
        setLayoutParams(r0);
    }

    public void onNewValue(int r5, int r6, int r7) {
        setGuidelineBegin(r6);
        int r8 = getId();
        if (r8 > 0) goto L6;
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(getParent(), MotionLayout.class) == false) goto L34;
        MotionLayout r9 = (MotionLayout) ZeusTransformUtils.preCheckCast(getParent(), MotionLayout.class, "com.obric.aiagent.plugin");
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
        c r10 = r9.cloneConstraintSet(r0);
        r10.e(r8, r6);
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
        c r0 = r3.getConstraintSet(r4);
        r0.e(r2, r1);
        r3.updateState(r4, r0);
    }
}
