package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes17.dex */
public class MotionHelper extends ConstraintHelper implements Animatable, MotionLayout.TransitionListener {
    private float mProgress;
    private boolean mUseOnHide;
    private boolean mUseOnShow;
    protected View[] views;

    @Override // androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener
    public void onTransitionChange(MotionLayout r100, int r101, int r102, float r103) {
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener
    public void onTransitionCompleted(MotionLayout r100, int r101) {
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener
    public void onTransitionStarted(MotionLayout r100, int r101, int r102) {
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener
    public void onTransitionTrigger(MotionLayout r100, int r101, boolean r102, float r103) {
    }

    public void setProgress(View r100, float r101) {
    }

    @Override // androidx.constraintlayout.motion.widget.Animatable
    public float getProgress() {
        return this.mProgress;
    }

    public boolean isUseOnHide() {
        return this.mUseOnHide;
    }

    public boolean isUsedOnShow() {
        return this.mUseOnShow;
    }

    public MotionHelper(Context r100) {
        super(r100);
        this.mUseOnShow = false;
        this.mUseOnHide = false;
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void init(AttributeSet r100) {
        super.init(r100);
        if (r100 == null) goto L18;
        TypedArray r101 = getContext().obtainStyledAttributes(r100, new int[]{R.attr.onHide, R.attr.onShow});
        int r102 = r101.getIndexCount();
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L12;
        int r104 = r101.getIndex(r103);
        if (r104 != 1) goto L9;
        this.mUseOnShow = r101.getBoolean(r104, this.mUseOnShow);
    L11:
        r103 = r103 + 1;
        goto L5
    L9:
        if (r104 != 0) goto L11;
        this.mUseOnHide = r101.getBoolean(r104, this.mUseOnHide);
        goto L11
    L12:
        r101.recycle();
        return;
    }

    @Override // androidx.constraintlayout.motion.widget.Animatable
    public void setProgress(float r100) {
        this.mProgress = r100;
        int r101 = 0;
        if (this.mCount <= 0) goto L8;
        this.views = getViews((ConstraintLayout) getParent());
    L6:
        if (r101 >= this.mCount) goto L15;
        setProgress(this.views[r101], r100);
        r101 = r101 + 1;
        goto L6
    L15:
        return;
    L8:
        ViewGroup r102 = (ViewGroup) getParent();
        int r103 = r102.getChildCount();
    L9:
        if (r101 >= r103) goto L20;
        View r104 = r102.getChildAt(r101);
        if ((r104 instanceof MotionHelper) == true) goto L14;
        setProgress(r104, r100);
    L14:
        r101 = r101 + 1;
        goto L9
    }

    public MotionHelper(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.mUseOnShow = false;
        this.mUseOnHide = false;
        init(r101);
    }

    public MotionHelper(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.mUseOnShow = false;
        this.mUseOnHide = false;
        init(r101);
    }
}
