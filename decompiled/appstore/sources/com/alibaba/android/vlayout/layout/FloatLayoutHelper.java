package com.alibaba.android.vlayout.layout;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.vlayout.LayoutManagerHelper;
import com.alibaba.android.vlayout.OrientationHelperEx;
import com.alibaba.android.vlayout.VirtualLayoutManager;

/* JADX INFO: loaded from: classes.dex */
public class FloatLayoutHelper extends FixAreaLayoutHelper {
    private static final String TAG = "FloatLayoutHelper";
    private boolean dragEnable;
    private int mAlignType;
    protected boolean mDoNormalHandle;
    protected View mFixView;
    private int mPos;
    private int mTransitionX;
    private int mTransitionY;
    private int mX;
    private int mY;
    private int mZIndex;
    private final View.OnTouchListener touchDragListener;

    public FloatLayoutHelper() {
        this.mTransitionX = 0;
        this.mTransitionY = 0;
        this.mZIndex = 1;
        this.mPos = -1;
        this.mFixView = null;
        this.mDoNormalHandle = false;
        this.mX = 0;
        this.mY = 0;
        this.mAlignType = 0;
        this.touchDragListener = new AnonymousClass1(this);
        this.dragEnable = true;
    }

    public static /* synthetic */ int access$002(FloatLayoutHelper r10, int r11) {
        r10.mTransitionX = r11;
        return r11;
    }

    public static /* synthetic */ int access$102(FloatLayoutHelper r10, int r11) {
        r10.mTransitionY = r11;
        return r11;
    }

    private void doMeasureAndLayout(View r13, LayoutManagerHelper r14) {
        if (r13 == null) goto L88;
        if (r14 == null) goto L89;
        VirtualLayoutManager.LayoutParams r10 = (VirtualLayoutManager.LayoutParams) r13.getLayoutParams();
        if (r14.getOrientation() != 1) goto L8;
        boolean r11 = true;
    L10:
        if (r11 == false) goto L23;
        int r12 = r14.getChildMeasureSpec((r14.getContentWidth() - r14.getPaddingLeft()) - r14.getPaddingRight(), ((ViewGroup.MarginLayoutParams) r10).width, !r11);
        if (Float.isNaN(r10.mAspectRatio) == true) goto L17;
        if (r10.mAspectRatio <= 0.0f) goto L17;
        int r15 = r14.getChildMeasureSpec((r14.getContentHeight() - r14.getPaddingTop()) - r14.getPaddingBottom(), (int) ((View.MeasureSpec.getSize(r12) / r10.mAspectRatio) + 0.5f), r11);
    L22:
        r14.measureChild(r13, r12, r15);
    L35:
        OrientationHelperEx r16 = r14.getMainOrientationHelper();
        int r17 = this.mAlignType;
        if (r17 != 1) goto L39;
        int r18 = (r14.getPaddingTop() + this.mY) + this.mAdjuster.top;
        int r19 = ((r14.getContentWidth() - r14.getPaddingRight()) - this.mX) - this.mAdjuster.right;
        int r20 = ((r19 - ((ViewGroup.MarginLayoutParams) r10).leftMargin) - ((ViewGroup.MarginLayoutParams) r10).rightMargin) - r13.getMeasuredWidth();
        int r21 = ((((ViewGroup.MarginLayoutParams) r10).topMargin + r18) + ((ViewGroup.MarginLayoutParams) r10).bottomMargin) + r13.getMeasuredHeight();
    L62:
        if (r20 >= (r14.getPaddingLeft() + this.mAdjuster.left)) goto L69;
        r20 = this.mAdjuster.left + r14.getPaddingLeft();
        if (r11 == false) goto L66;
        int r22 = r16.getDecoratedMeasurementInOther(r13);
    L67:
        r19 = r22 + r20;
        goto L69
    L66:
        r22 = r16.getDecoratedMeasurement(r13);
    L69:
        if (r19 <= ((r14.getContentWidth() - r14.getPaddingRight()) - this.mAdjuster.right)) goto L71;
        r19 = (r14.getContentWidth() - r14.getPaddingRight()) - this.mAdjuster.right;
        r20 = ((r19 - ((ViewGroup.MarginLayoutParams) r10).leftMargin) - ((ViewGroup.MarginLayoutParams) r10).rightMargin) - r13.getMeasuredWidth();
    L71:
        int r23 = r20;
        if (r18 >= (r14.getPaddingTop() + this.mAdjuster.top)) goto L79;
        r18 = r14.getPaddingTop() + this.mAdjuster.top;
        if (r11 == false) goto L76;
        int r24 = r16.getDecoratedMeasurement(r13);
    L77:
        r21 = r18 + r24;
        goto L79
    L76:
        r24 = r16.getDecoratedMeasurementInOther(r13);
    L79:
        if (r21 <= ((r14.getContentHeight() - r14.getPaddingBottom()) - this.mAdjuster.bottom)) goto L85;
        int r25 = (r14.getContentHeight() - r14.getPaddingBottom()) - this.mAdjuster.bottom;
        if (r11 == false) goto L83;
        int r26 = r16.getDecoratedMeasurement(r13);
    L84:
        int r27 = r25 - r26;
        int r28 = r25;
    L86:
        layoutChildWithMargin(r13, r23, r27, r19, r28, r14);
        return;
    L83:
        r26 = r16.getDecoratedMeasurementInOther(r13);
        goto L84
    L85:
        r27 = r18;
        r28 = r21;
        goto L86
    L39:
        if (r17 != 2) goto L42;
        r20 = (r14.getPaddingLeft() + this.mX) + this.mAdjuster.left;
        r21 = ((r14.getContentHeight() - r14.getPaddingBottom()) - this.mY) - this.mAdjuster.bottom;
        r19 = r13.getMeasuredWidth() + ((((ViewGroup.MarginLayoutParams) r10).leftMargin + r20) + ((ViewGroup.MarginLayoutParams) r10).rightMargin);
        r18 = ((r21 - r13.getMeasuredHeight()) - ((ViewGroup.MarginLayoutParams) r10).topMargin) - ((ViewGroup.MarginLayoutParams) r10).bottomMargin;
        goto L62
    L42:
        if (r17 != 3) goto L52;
        r19 = ((r14.getContentWidth() - r14.getPaddingRight()) - this.mX) - this.mAdjuster.right;
        r21 = ((r14.getContentHeight() - r14.getPaddingBottom()) - this.mY) - this.mAdjuster.bottom;
        if (r11 == false) goto L46;
        int r29 = r16.getDecoratedMeasurementInOther(r13);
    L47:
        r20 = r19 - r29;
        if (r11 == false) goto L50;
        int r30 = r16.getDecoratedMeasurement(r13);
    L51:
        r18 = r21 - r30;
        goto L62
    L50:
        r30 = r16.getDecoratedMeasurementInOther(r13);
        goto L51
    L46:
        r29 = r16.getDecoratedMeasurement(r13);
        goto L47
    L52:
        r20 = (r14.getPaddingLeft() + this.mX) + this.mAdjuster.left;
        r18 = (r14.getPaddingTop() + this.mY) + this.mAdjuster.top;
        if (r11 == false) goto L55;
        int r31 = r16.getDecoratedMeasurementInOther(r13);
    L56:
        r19 = r31 + r20;
        if (r11 == false) goto L59;
        int r32 = r16.getDecoratedMeasurement(r13);
    L60:
        r21 = r32 + r18;
        goto L62
    L59:
        r32 = r16.getDecoratedMeasurementInOther(r13);
        goto L60
    L55:
        r31 = r16.getDecoratedMeasurement(r13);
    L17:
        if (Float.isNaN(this.mAspectRatio) == false) goto L19;
    L21:
        r15 = r14.getChildMeasureSpec((r14.getContentHeight() - r14.getPaddingTop()) - r14.getPaddingBottom(), ((ViewGroup.MarginLayoutParams) r10).height, r11);
        goto L22
    L19:
        if (this.mAspectRatio <= 0.0f) goto L21;
        r15 = r14.getChildMeasureSpec((r14.getContentHeight() - r14.getPaddingTop()) - r14.getPaddingBottom(), (int) ((View.MeasureSpec.getSize(r12) / this.mAspectRatio) + 0.5f), r11);
        goto L22
    L23:
        int r33 = r14.getChildMeasureSpec((r14.getContentHeight() - r14.getPaddingTop()) - r14.getPaddingBottom(), ((ViewGroup.MarginLayoutParams) r10).height, r11);
        if (Float.isNaN(r10.mAspectRatio) == true) goto L29;
        if (r10.mAspectRatio <= 0.0f) goto L29;
        int r34 = r14.getChildMeasureSpec((r14.getContentWidth() - r14.getPaddingLeft()) - r14.getPaddingRight(), (int) ((View.MeasureSpec.getSize(r33) * r10.mAspectRatio) + 0.5f), !r11);
    L34:
        r14.measureChild(r13, r34, r33);
    L29:
        if (Float.isNaN(this.mAspectRatio) == false) goto L31;
    L33:
        r34 = r14.getChildMeasureSpec((r14.getContentWidth() - r14.getPaddingLeft()) - r14.getPaddingRight(), ((ViewGroup.MarginLayoutParams) r10).width, !r11);
        goto L34
    L31:
        if (this.mAspectRatio <= 0.0f) goto L33;
        r34 = r14.getChildMeasureSpec((r14.getContentWidth() - r14.getPaddingLeft()) - r14.getPaddingRight(), (int) ((View.MeasureSpec.getSize(r33) * this.mAspectRatio) + 0.5f), !r11);
        goto L34
    L8:
        r11 = false;
        goto L10
    L89:
        return;
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper, com.alibaba.android.vlayout.LayoutHelper
    public void afterLayout(RecyclerView.Recycler r10, RecyclerView.State r11, int r12, int r13, int r14, LayoutManagerHelper r15) {
        super.afterLayout(r10, r11, r12, r13, r14, r15);
        if (this.mPos >= 0) goto L6;
        return;
    L6:
        if (this.mDoNormalHandle == false) goto L10;
        this.mFixView = null;
        return;
    L10:
        if (shouldBeDraw(r12, r13) == false) goto L27;
        View r16 = this.mFixView;
        if (r16 != null) goto L14;
        View r17 = r10.o(this.mPos);
        this.mFixView = r17;
        r15.getChildViewHolder(r17).setIsRecyclable(false);
        doMeasureAndLayout(this.mFixView, r15);
        r15.addFixedView(this.mFixView);
        this.mFixView.setTranslationX(this.mTransitionX);
        this.mFixView.setTranslationY(this.mTransitionY);
        if (this.dragEnable == false) goto L30;
        this.mFixView.setOnTouchListener(this.touchDragListener);
        return;
    L30:
        return;
    L14:
        if (r16.getParent() != null) goto L19;
        r15.addFixedView(this.mFixView);
        if (this.dragEnable == false) goto L18;
        this.mFixView.setOnTouchListener(this.touchDragListener);
    L18:
        this.mFixView.setTranslationX(this.mTransitionX);
        this.mFixView.setTranslationY(this.mTransitionY);
        return;
    L19:
        r15.showView(this.mFixView);
        if (this.dragEnable == false) goto L22;
        this.mFixView.setOnTouchListener(this.touchDragListener);
    L22:
        r15.addFixedView(this.mFixView);
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
        r12.recycleView(this.mFixView);
        this.mFixView.setOnTouchListener(null);
        this.mFixView = null;
        goto L7
    }

    @Override // com.alibaba.android.vlayout.LayoutHelper
    @Nullable
    public View getFixedView() {
        return this.mFixView;
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper
    public void layoutViews(RecyclerView.Recycler r10, RecyclerView.State r11, VirtualLayoutManager.LayoutStateWrapper r12, LayoutChunkResult r13, LayoutManagerHelper r14) {
        if (isOutOfRange(r12.getCurrentPosition()) == false) goto L5;
        return;
    L5:
        View r15 = this.mFixView;
        if (r15 != null) goto L8;
        r15 = r12.next(r10);
    L10:
        if (r15 != null) goto L13;
        r13.mFinished = true;
        return;
    L13:
        r14.getChildViewHolder(r15).setIsRecyclable(false);
        boolean r16 = r11.f();
        this.mDoNormalHandle = r16;
        if (r16 == false) goto L16;
        r14.addChildView(r12, r15);
    L16:
        this.mFixView = r15;
        r15.setClickable(true);
        doMeasureAndLayout(r15, r14);
        r13.mConsumed = 0;
        r13.mIgnoreConsumed = true;
        handleStateOnResult(r13, r15);
        return;
    L8:
        r12.skipCurrentPosition();
        goto L10
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper
    public void onClear(LayoutManagerHelper r10) {
        super.onClear(r10);
        View r11 = this.mFixView;
        if (r11 == null) goto L6;
        r11.setOnTouchListener(null);
        r10.removeChildView(this.mFixView);
        r10.recycleView(this.mFixView);
        this.mFixView = null;
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

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper
    public void setBgColor(int r10) {
    }

    public void setDefaultLocation(int r10, int r11) {
        this.mX = r10;
        this.mY = r11;
    }

    public void setDragEnable(boolean r10) {
        this.dragEnable = r10;
        View r11 = this.mFixView;
        if (r11 == null) goto L9;
        if (r10 == false) goto L6;
        View.OnTouchListener r12 = this.touchDragListener;
    L7:
        r11.setOnTouchListener(r12);
        return;
    L6:
        r12 = null;
        goto L7
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper, com.alibaba.android.vlayout.LayoutHelper
    public void setItemCount(int r10) {
        if (r10 <= 0) goto L4;
        super.setItemCount(1);
        return;
    L4:
        super.setItemCount(0);
    }

    public void setX(int r10) {
        this.mX = r10;
    }

    public void setY(int r10) {
        this.mY = r10;
    }

    public boolean shouldBeDraw(int r10, int r11) {
        return true;
    }
}
