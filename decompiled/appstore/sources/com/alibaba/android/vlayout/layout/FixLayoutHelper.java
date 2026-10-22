package com.alibaba.android.vlayout.layout;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.vlayout.LayoutManagerHelper;
import com.alibaba.android.vlayout.OrientationHelperEx;
import com.alibaba.android.vlayout.VirtualLayoutManager;

/* JADX INFO: loaded from: classes.dex */
public class FixLayoutHelper extends FixAreaLayoutHelper {
    public static final int BOTTOM_LEFT = 2;
    public static final int BOTTOM_RIGHT = 3;
    private static final String TAG = "FixLayoutHelper";
    public static final int TOP_LEFT = 0;
    public static final int TOP_RIGHT = 1;
    private boolean isAddFixViewImmediately;
    private boolean isRemoveFixViewImmediately;
    private int mAlignType;
    protected boolean mDoNormalHandle;
    protected View mFixView;
    private FixViewAppearAnimatorListener mFixViewAppearAnimatorListener;
    private FixViewDisappearAnimatorListener mFixViewDisappearAnimatorListener;
    private int mPos;
    private boolean mShouldDrawn;
    private boolean mSketchMeasure;
    protected int mX;
    protected int mY;

    public static class FixViewAppearAnimatorListener extends AnimatorListenerAdapter {
        private View mFixView;
        private LayoutManagerHelper mLayoutManagerHelper;

        private FixViewAppearAnimatorListener() {
        }

        public void bindAction(LayoutManagerHelper r10, View r11) {
            this.mLayoutManagerHelper = r10;
            this.mFixView = r11;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r10) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r10) {
            this.mFixView.setVisibility(0);
        }

        public /* synthetic */ FixViewAppearAnimatorListener(AnonymousClass1 r10) {
            this();
        }
    }

    public static class FixViewDisappearAnimatorListener extends AnimatorListenerAdapter {
        private boolean isAnimating;
        private Runnable mEndAction;
        private View mFixView;
        private LayoutManagerHelper mLayoutManagerHelper;
        private RecyclerView.Recycler mRecycler;

        private FixViewDisappearAnimatorListener() {
        }

        public void bindAction(RecyclerView.Recycler r10, LayoutManagerHelper r11, View r12) {
            this.isAnimating = true;
            this.mRecycler = r10;
            this.mLayoutManagerHelper = r11;
            this.mFixView = r12;
        }

        public boolean isAnimating() {
            return this.isAnimating;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r10) {
            this.mLayoutManagerHelper.removeChildView(this.mFixView);
            this.mRecycler.G(this.mFixView);
            this.isAnimating = false;
            Runnable r11 = this.mEndAction;
            if (r11 == null) goto L6;
            r11.run();
            this.mEndAction = null;
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r10) {
        }

        public void withEndAction(Runnable r10) {
            this.mEndAction = r10;
        }

        public /* synthetic */ FixViewDisappearAnimatorListener(AnonymousClass1 r10) {
            this();
        }
    }

    public FixLayoutHelper(int r10, int r11) {
        this(0, r10, r11);
    }

    public static /* synthetic */ int access$200(FixLayoutHelper r10) {
        return r10.mPos;
    }

    public static /* synthetic */ void access$300(FixLayoutHelper r10, View r11, LayoutManagerHelper r12) {
        r10.doMeasureAndLayout(r11, r12);
    }

    public static /* synthetic */ boolean access$400(FixLayoutHelper r10) {
        return r10.isAddFixViewImmediately;
    }

    public static /* synthetic */ boolean access$502(FixLayoutHelper r10, boolean r11) {
        r10.isRemoveFixViewImmediately = r11;
        return r11;
    }

    public static /* synthetic */ void access$600(FixLayoutHelper r10, LayoutManagerHelper r11, View r12) {
        r10.addFixViewWithAnimator(r11, r12);
    }

    private void addFixViewWithAnimator(LayoutManagerHelper r10, View r11) {
        FixAreaLayoutHelper.FixViewAnimatorHelper r12 = this.mFixViewAnimatorHelper;
        if (r12 == null) goto L8;
        ViewPropertyAnimator r13 = r12.onGetFixViewAppearAnimator(r11);
        if (r13 == null) goto L7;
        r11.setVisibility(4);
        r10.addFixedView(r11);
        this.mFixViewAppearAnimatorListener.bindAction(r10, r11);
        r13.setListener(this.mFixViewAppearAnimatorListener).start();
    L9:
        this.isRemoveFixViewImmediately = false;
        return;
    L7:
        r10.addFixedView(r11);
        goto L9
    L8:
        r10.addFixedView(r11);
        goto L9
    }

    private void doMeasureAndLayout(View r13, LayoutManagerHelper r14) {
        if (r13 == null) goto L87;
        if (r14 == null) goto L88;
        VirtualLayoutManager.LayoutParams r10 = (VirtualLayoutManager.LayoutParams) r13.getLayoutParams();
        OrientationHelperEx r11 = r14.getMainOrientationHelper();
        if (r14.getOrientation() != 1) goto L8;
        boolean r12 = true;
    L9:
        int r15 = -2;
        if (r12 == false) goto L38;
        int r16 = (r14.getContentWidth() - r14.getPaddingLeft()) - r14.getPaddingRight();
        int r17 = ((ViewGroup.MarginLayoutParams) r10).width;
        if (r17 < 0) goto L15;
    L19:
        int r18 = r14.getChildMeasureSpec(r16, r17, false);
        if (Float.isNaN(r10.mAspectRatio) == true) goto L25;
        if (r10.mAspectRatio <= 0.0f) goto L25;
        int r19 = r14.getChildMeasureSpec((r14.getContentHeight() - r14.getPaddingTop()) - r14.getPaddingBottom(), (int) ((View.MeasureSpec.getSize(r18) / r10.mAspectRatio) + 0.5f), false);
    L37:
        r14.measureChildWithMargins(r13, r18, r19);
    L65:
        int r20 = this.mAlignType;
        if (r20 != 1) goto L70;
        int r21 = (r14.getPaddingTop() + this.mY) + this.mAdjuster.top;
        int r22 = ((r14.getContentWidth() - r14.getPaddingRight()) - this.mX) - this.mAdjuster.right;
        int r23 = ((r22 - ((ViewGroup.MarginLayoutParams) r10).leftMargin) - ((ViewGroup.MarginLayoutParams) r10).rightMargin) - r13.getMeasuredWidth();
        int r24 = ((((ViewGroup.MarginLayoutParams) r10).topMargin + r21) + ((ViewGroup.MarginLayoutParams) r10).bottomMargin) + r13.getMeasuredHeight();
    L68:
        int r25 = r21;
        int r26 = r22;
        int r27 = r23;
        int r110 = r24;
    L85:
        layoutChildWithMargin(r13, r27, r25, r26, r110, r14);
        return;
    L70:
        if (r20 != 2) goto L74;
        r23 = (r14.getPaddingLeft() + this.mX) + this.mAdjuster.left;
        r24 = ((r14.getContentHeight() - r14.getPaddingBottom()) - this.mY) - this.mAdjuster.bottom;
        r22 = r13.getMeasuredWidth() + ((((ViewGroup.MarginLayoutParams) r10).leftMargin + r23) + ((ViewGroup.MarginLayoutParams) r10).rightMargin);
        int r28 = (r24 - r13.getMeasuredHeight()) - ((ViewGroup.MarginLayoutParams) r10).topMargin;
        int r29 = ((ViewGroup.MarginLayoutParams) r10).bottomMargin;
    L72:
        r21 = r28 - r29;
        goto L68
    L74:
        if (r20 != 3) goto L76;
        r22 = ((r14.getContentWidth() - r14.getPaddingRight()) - this.mX) - this.mAdjuster.right;
        r24 = ((r14.getContentHeight() - r14.getPaddingBottom()) - this.mY) - this.mAdjuster.bottom;
        r23 = ((r22 - ((ViewGroup.MarginLayoutParams) r10).leftMargin) - ((ViewGroup.MarginLayoutParams) r10).rightMargin) - r13.getMeasuredWidth();
        r28 = (r24 - r13.getMeasuredHeight()) - ((ViewGroup.MarginLayoutParams) r10).topMargin;
        r29 = ((ViewGroup.MarginLayoutParams) r10).bottomMargin;
        goto L72
    L76:
        int r30 = this.mAdjuster.left + (r14.getPaddingLeft() + this.mX);
        int r31 = (r14.getPaddingTop() + this.mY) + this.mAdjuster.top;
        if (r12 == false) goto L79;
        int r32 = r11.getDecoratedMeasurementInOther(r13);
    L80:
        int r33 = r32 + r30;
        if (r12 == false) goto L83;
        int r34 = r11.getDecoratedMeasurement(r13);
    L84:
        r25 = r31;
        r110 = r34 + r31;
        r27 = r30;
        r26 = r33;
        goto L85
    L83:
        r34 = r11.getDecoratedMeasurementInOther(r13);
        goto L84
    L79:
        r32 = r11.getDecoratedMeasurement(r13);
    L25:
        if (Float.isNaN(this.mAspectRatio) == false) goto L27;
    L29:
        int r35 = (r14.getContentHeight() - r14.getPaddingTop()) - r14.getPaddingBottom();
        int r36 = ((ViewGroup.MarginLayoutParams) r10).height;
        if (r36 < 0) goto L33;
        r15 = r36;
    L36:
        r19 = r14.getChildMeasureSpec(r35, r15, false);
        goto L37
    L33:
        if (this.mSketchMeasure == false) goto L36;
        if (r12 == true) goto L36;
        r15 = -1;
        goto L36
    L27:
        if (this.mAspectRatio <= 0.0f) goto L29;
        r19 = r14.getChildMeasureSpec((r14.getContentHeight() - r14.getPaddingTop()) - r14.getPaddingBottom(), (int) ((View.MeasureSpec.getSize(r18) / this.mAspectRatio) + 0.5f), false);
        goto L37
    L15:
        if (this.mSketchMeasure == false) goto L18;
        if (r12 == false) goto L18;
        r17 = -1;
    L18:
        r17 = -2;
        goto L19
    L38:
        int r37 = (r14.getContentHeight() - r14.getPaddingTop()) - r14.getPaddingBottom();
        int r111 = ((ViewGroup.MarginLayoutParams) r10).height;
        if (r111 < 0) goto L42;
    L46:
        int r38 = r14.getChildMeasureSpec(r37, r111, false);
        if (Float.isNaN(r10.mAspectRatio) == true) goto L52;
        if (r10.mAspectRatio <= 0.0f) goto L52;
        int r39 = r14.getChildMeasureSpec((r14.getContentWidth() - r14.getPaddingLeft()) - r14.getPaddingRight(), (int) ((View.MeasureSpec.getSize(r38) * r10.mAspectRatio) + 0.5f), false);
    L64:
        r14.measureChildWithMargins(r13, r39, r38);
    L52:
        if (Float.isNaN(this.mAspectRatio) == false) goto L54;
    L56:
        int r40 = (r14.getContentWidth() - r14.getPaddingLeft()) - r14.getPaddingRight();
        int r41 = ((ViewGroup.MarginLayoutParams) r10).width;
        if (r41 < 0) goto L60;
        r15 = r41;
    L63:
        r39 = r14.getChildMeasureSpec(r40, r15, false);
        goto L64
    L60:
        if (this.mSketchMeasure == false) goto L63;
        if (r12 == false) goto L63;
        r15 = -1;
        goto L63
    L54:
        if (this.mAspectRatio <= 0.0f) goto L56;
        r39 = r14.getChildMeasureSpec((r14.getContentWidth() - r14.getPaddingLeft()) - r14.getPaddingRight(), (int) ((View.MeasureSpec.getSize(r38) * this.mAspectRatio) + 0.5f), false);
        goto L64
    L42:
        if (this.mSketchMeasure == false) goto L45;
        if (r12 == true) goto L45;
        r111 = -1;
    L45:
        r111 = -2;
        goto L46
    L8:
        r12 = false;
        goto L9
    L88:
        return;
    }

    private void removeFixViewWithAnimator(RecyclerView.Recycler r10, LayoutManagerHelper r11, View r12) {
        if (this.isRemoveFixViewImmediately == true) goto L10;
        FixAreaLayoutHelper.FixViewAnimatorHelper r13 = this.mFixViewAnimatorHelper;
        if (r13 == null) goto L10;
        ViewPropertyAnimator r14 = r13.onGetFixViewDisappearAnimator(r12);
        if (r14 == null) goto L9;
        this.mFixViewDisappearAnimatorListener.bindAction(r10, r11, r12);
        r14.setListener(this.mFixViewDisappearAnimatorListener).start();
        this.isAddFixViewImmediately = false;
        return;
    L9:
        r11.removeChildView(r12);
        r10.G(r12);
        this.isAddFixViewImmediately = false;
        return;
    L10:
        r11.removeChildView(r12);
        r10.G(r12);
        this.isAddFixViewImmediately = false;
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper, com.alibaba.android.vlayout.LayoutHelper
    public void afterLayout(final RecyclerView.Recycler r10, RecyclerView.State r11, int r12, int r13, int r14, final LayoutManagerHelper r15) {
        super.afterLayout(r10, r11, r12, r13, r14, r15);
        if (this.mPos >= 0) goto L6;
        return;
    L6:
        if (this.mDoNormalHandle == false) goto L15;
        if (r11.f() == false) goto L15;
        View r16 = this.mFixView;
        if (r16 == null) goto L12;
        r15.removeChildView(r16);
        r10.G(this.mFixView);
        this.isAddFixViewImmediately = false;
    L12:
        this.mFixView = null;
        return;
    L15:
        if (shouldBeDraw(r15, r12, r13, r14) == false) goto L26;
        this.mShouldDrawn = true;
        View r17 = this.mFixView;
        if (r17 != null) goto L19;
        Runnable r18 = new AnonymousClass1(this, r10, r15);
        if (this.mFixViewDisappearAnimatorListener.isAnimating() == false) goto L25;
        this.mFixViewDisappearAnimatorListener.withEndAction(r18);
        return;
    L25:
        r18.run();
        return;
    L19:
        if (r17.getParent() != null) goto L21;
        addFixViewWithAnimator(r15, this.mFixView);
        return;
    L21:
        r15.addFixedView(this.mFixView);
        this.isRemoveFixViewImmediately = false;
        return;
    L26:
        this.mShouldDrawn = false;
        View r19 = this.mFixView;
        if (r19 == null) goto L34;
        removeFixViewWithAnimator(r10, r15, r19);
        this.mFixView = null;
        return;
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper, com.alibaba.android.vlayout.LayoutHelper
    public void beforeLayout(RecyclerView.Recycler r10, RecyclerView.State r11, LayoutManagerHelper r12) {
        super.beforeLayout(r10, r11, r12);
        View r13 = this.mFixView;
        if (r13 != null) goto L5;
    L7:
        this.mDoNormalHandle = false;
        return;
    L5:
        if (r12.isViewHolderUpdated(r13) == false) goto L7;
        r12.removeChildView(this.mFixView);
        r10.G(this.mFixView);
        this.mFixView = null;
        this.isAddFixViewImmediately = true;
        goto L7
    }

    @Override // com.alibaba.android.vlayout.LayoutHelper
    public View getFixedView() {
        return this.mFixView;
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper
    public void layoutViews(RecyclerView.Recycler r10, RecyclerView.State r11, VirtualLayoutManager.LayoutStateWrapper r12, LayoutChunkResult r13, LayoutManagerHelper r14) {
        if (isOutOfRange(r12.getCurrentPosition()) == false) goto L6;
        return;
    L6:
        if (this.mShouldDrawn == true) goto L9;
        r12.skipCurrentPosition();
        return;
    L9:
        View r15 = this.mFixView;
        if (r15 != null) goto L12;
        r15 = r12.next(r10);
    L14:
        if (r15 != null) goto L17;
        r13.mFinished = true;
        return;
    L17:
        boolean r16 = r11.f();
        this.mDoNormalHandle = r16;
        if (r16 == false) goto L20;
        r14.addChildView(r12, r15);
    L20:
        this.mFixView = r15;
        doMeasureAndLayout(r15, r14);
        r13.mConsumed = 0;
        r13.mIgnoreConsumed = true;
        handleStateOnResult(r13, r15);
        return;
    L12:
        r12.skipCurrentPosition();
        goto L14
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper
    public void onClear(LayoutManagerHelper r10) {
        super.onClear(r10);
        View r11 = this.mFixView;
        if (r11 == null) goto L6;
        r10.removeChildView(r11);
        r10.recycleView(this.mFixView);
        this.mFixView.animate().cancel();
        this.mFixView = null;
        this.isAddFixViewImmediately = false;
        return;
    }

    @Override // com.alibaba.android.vlayout.LayoutHelper
    public void onRangeChange(int r10, int r11) {
        this.mPos = r10;
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper, com.alibaba.android.vlayout.LayoutHelper
    public boolean requireLayoutView() {
        return false;
    }

    public void setAlignType(int r10) {
        this.mAlignType = r10;
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper, com.alibaba.android.vlayout.LayoutHelper
    public void setItemCount(int r10) {
        if (r10 <= 0) goto L4;
        super.setItemCount(1);
        return;
    L4:
        super.setItemCount(0);
    }

    @Override // com.alibaba.android.vlayout.layout.MarginLayoutHelper
    public void setMargin(int r10, int r11, int r12, int r13) {
    }

    public void setSketchMeasure(boolean r10) {
        this.mSketchMeasure = r10;
    }

    public void setX(int r10) {
        this.mX = r10;
    }

    public void setY(int r10) {
        this.mY = r10;
    }

    public boolean shouldBeDraw(LayoutManagerHelper r10, int r11, int r12, int r13) {
        return true;
    }

    public FixLayoutHelper(int r10, int r11, int r12) {
        this.mPos = -1;
        this.mAlignType = 0;
        this.mX = 0;
        this.mY = 0;
        this.mSketchMeasure = false;
        AnonymousClass1 r13 = null;
        this.mFixView = null;
        this.mDoNormalHandle = false;
        this.mShouldDrawn = true;
        this.isAddFixViewImmediately = false;
        this.isRemoveFixViewImmediately = true;
        this.mFixViewAppearAnimatorListener = new FixViewAppearAnimatorListener(r13);
        this.mFixViewDisappearAnimatorListener = new FixViewDisappearAnimatorListener(r13);
        this.mAlignType = r10;
        this.mX = r11;
        this.mY = r12;
        setItemCount(1);
    }
}
