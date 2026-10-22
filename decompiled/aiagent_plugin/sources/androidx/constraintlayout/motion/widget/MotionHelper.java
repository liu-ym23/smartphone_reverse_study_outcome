package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class MotionHelper extends ConstraintHelper implements n {
    private float mProgress;
    private boolean mUseOnHide;
    private boolean mUseOnShow;
    protected View[] views;

    public boolean isDecorator() {
        return false;
    }

    public void onFinishedMotionScene(MotionLayout r1) {
    }

    public void onPostDraw(Canvas r1) {
    }

    public void onPreDraw(Canvas r1) {
    }

    public void onPreSetup(MotionLayout r1, HashMap<View, m> r2) {
    }

    public void onTransitionChange(MotionLayout r1, int r2, int r3, float r4) {
    }

    public void onTransitionCompleted(MotionLayout r1, int r2) {
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout.f
    public void onTransitionStarted(MotionLayout r1, int r2, int r3) {
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout.f
    public void onTransitionTrigger(MotionLayout r1, int r2, boolean r3, float r4) {
    }

    public void setProgress(View r1, float r2) {
    }

    public MotionHelper(Context r3) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"));
        this.mUseOnShow = false;
        this.mUseOnHide = false;
    }

    public MotionHelper(Context r3, AttributeSet r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        super(r5, r6);
        this.mUseOnShow = false;
        this.mUseOnHide = false;
        init(r6);
    }

    public MotionHelper(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        super(r6, r7, r5);
        this.mUseOnShow = false;
        this.mUseOnHide = false;
        init(r7);
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void init(AttributeSet r7) {
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r7, AttributeSet.class, "com.obric.aiagent.plugin");
        super.init(r8);
        if (r8 == null) goto L19;
        TypedArray r9 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).obtainStyledAttributes(r8, R.styleable.MotionHelper);
        int r0 = r9.getIndexCount();
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L13;
        int r2 = r9.getIndex(r1);
        if (r2 != ZeusTransformUtils.mapRes(R.styleable.MotionHelper_onShow, "styleable", "MotionHelper_onShow")) goto L10;
        this.mUseOnShow = r9.getBoolean(r2, this.mUseOnShow);
    L12:
        r1 = r1 + 1;
        goto L5
    L10:
        if (r2 != ZeusTransformUtils.mapRes(R.styleable.MotionHelper_onHide, "styleable", "MotionHelper_onHide")) goto L12;
        this.mUseOnHide = r9.getBoolean(r2, this.mUseOnHide);
        goto L12
    L13:
        r9.recycle();
        return;
    }

    public boolean isUsedOnShow() {
        return this.mUseOnShow;
    }

    public boolean isUseOnHide() {
        return this.mUseOnHide;
    }

    public float getProgress() {
        return this.mProgress;
    }

    public void setProgress(float r6) {
        this.mProgress = r6;
        int r1 = 0;
        if (this.mCount <= 0) goto L8;
        this.views = getViews((ConstraintLayout) ZeusTransformUtils.preCheckCast(getParent(), ConstraintLayout.class, "com.obric.aiagent.plugin"));
    L6:
        if (r1 >= this.mCount) goto L15;
        setProgress(this.views[r1], r6);
        r1 = r1 + 1;
        goto L6
    L15:
        return;
    L8:
        ViewGroup r0 = (ViewGroup) ZeusTransformUtils.preCheckCast(getParent(), ViewGroup.class, "com.obric.aiagent.plugin");
        int r2 = r0.getChildCount();
    L9:
        if (r1 >= r2) goto L20;
        View r3 = r0.getChildAt(r1);
        if (ZeusTransformUtils.instanceOf(r3, MotionHelper.class) == true) goto L14;
        setProgress(r3, r6);
    L14:
        r1 = r1 + 1;
        goto L9
    }
}
