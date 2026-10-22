package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;

/* JADX INFO: loaded from: classes.dex */
public abstract class VirtualLayout extends ConstraintHelper {
    private boolean mApplyElevationOnAttach;
    private boolean mApplyVisibilityOnAttach;

    public void onMeasure(androidx.constraintlayout.core.widgets.VirtualLayout layout, int widthMeasureSpec, int heightMeasureSpec) {
    }

    public VirtualLayout(Context context) {
        super(context);
    }

    public VirtualLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VirtualLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    protected void init(AttributeSet attrs) {
        super.init(attrs);
        if (attrs == null) goto L19;
        TypedArray r6 = getContext().obtainStyledAttributes(attrs, R.styleable.ConstraintLayout_Layout);
        int r0 = r6.getIndexCount();
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L13;
        int r2 = r6.getIndex(r1);
        if (r2 != R.styleable.ConstraintLayout_Layout_android_visibility) goto L10;
        this.mApplyVisibilityOnAttach = true;
    L12:
        r1 = r1 + 1;
        goto L5
    L10:
        if (r2 != R.styleable.ConstraintLayout_Layout_android_elevation) goto L12;
        this.mApplyElevationOnAttach = true;
        goto L12
    L13:
        r6.recycle();
        return;
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mApplyVisibilityOnAttach == false) goto L5;
    L6:
        ViewParent r0 = getParent();
        if ((r0 instanceof ConstraintLayout) == false) goto L28;
        ConstraintLayout r1 = (ConstraintLayout) r0;
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
    public void setVisibility(int visibility) {
        super.setVisibility(visibility);
        applyLayoutFeatures();
    }

    @Override // android.view.View
    public void setElevation(float elevation) {
        super.setElevation(elevation);
        applyLayoutFeatures();
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    protected void applyLayoutFeaturesInConstraintSet(ConstraintLayout container) {
        applyLayoutFeatures(container);
    }
}
