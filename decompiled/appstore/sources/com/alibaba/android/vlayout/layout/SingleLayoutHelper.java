package com.alibaba.android.vlayout.layout;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.vlayout.LayoutManagerHelper;
import com.alibaba.android.vlayout.OrientationHelperEx;
import com.alibaba.android.vlayout.VirtualLayoutManager;

/* JADX INFO: loaded from: classes.dex */
public class SingleLayoutHelper extends ColumnLayoutHelper {
    private static final String TAG = "SingleLayoutHelper";
    private int mPos;

    public SingleLayoutHelper() {
        this.mPos = -1;
        setItemCount(1);
    }

    @Override // com.alibaba.android.vlayout.layout.ColumnLayoutHelper, com.alibaba.android.vlayout.layout.AbstractFullFillLayoutHelper, com.alibaba.android.vlayout.layout.BaseLayoutHelper
    public void layoutViews(RecyclerView.Recycler r10, RecyclerView.State r11, VirtualLayoutManager.LayoutStateWrapper r12, LayoutChunkResult r13, LayoutManagerHelper r14) {
        if (isOutOfRange(r12.getCurrentPosition()) == false) goto L5;
        return;
    L5:
        View r15 = r12.next(r10);
        boolean r16 = true;
        if (r15 != null) goto L9;
        r13.mFinished = true;
        return;
    L9:
        r14.addChildView(r12, r15);
        VirtualLayoutManager.LayoutParams r17 = (VirtualLayoutManager.LayoutParams) r15.getLayoutParams();
        int r18 = 0;
        if (r14.getOrientation() != 1) goto L12;
        boolean r19 = true;
    L13:
        int r20 = (((r14.getContentWidth() - r14.getPaddingLeft()) - r14.getPaddingRight()) - getHorizontalMargin()) - getHorizontalPadding();
        int r21 = (((r14.getContentHeight() - r14.getPaddingTop()) - r14.getPaddingBottom()) - getVerticalMargin()) - getVerticalPadding();
        if (Float.isNaN(this.mAspectRatio) == true) goto L18;
        if (r19 == false) goto L17;
        r21 = (int) ((r20 / this.mAspectRatio) + 0.5f);
        goto L18
    L17:
        r20 = (int) ((r21 * this.mAspectRatio) + 0.5f);
    L18:
        if (r19 == false) goto L42;
        if (Float.isNaN(this.mAspectRatio) == false) goto L22;
        int r22 = ((ViewGroup.MarginLayoutParams) r17).width;
    L23:
        if (r19 == false) goto L25;
    L27:
        boolean r23 = false;
    L28:
        int r24 = r14.getChildMeasureSpec(r20, r22, r23);
        if (Float.isNaN(r17.mAspectRatio) == true) goto L31;
        int r110 = (int) ((r20 / r17.mAspectRatio) + 0.5f);
    L35:
        if (r19 == true) goto L37;
    L39:
        r16 = false;
    L40:
        r14.measureChildWithMargins(r15, r24, r14.getChildMeasureSpec(r21, r110, r16));
    L63:
        OrientationHelperEx r25 = r14.getMainOrientationHelper();
        r13.mConsumed = r25.getDecoratedMeasurement(r15);
        if (r19 == false) goto L74;
        int r26 = r20 - r25.getDecoratedMeasurementInOther(r15);
        if (r26 < 0) goto L69;
        r18 = r26;
    L69:
        int r27 = r18 / 2;
        int r28 = ((this.mMarginLeft + this.mPaddingLeft) + r14.getPaddingLeft()) + r27;
        int r29 = (((r14.getContentWidth() - this.mMarginRight) - this.mPaddingRight) - r14.getPaddingRight()) - r27;
        if (r12.getLayoutDirection() != (-1)) goto L72;
        int r111 = (r12.getOffset() - this.mMarginBottom) - this.mPaddingBottom;
        int r112 = r111 - r13.mConsumed;
    L73:
        int r30 = r28;
        int r31 = r111;
        int r32 = r29;
        int r33 = r112;
    L83:
        if (r19 == false) goto L85;
        r13.mConsumed += getVerticalMargin() + getVerticalPadding();
    L86:
        layoutChildWithMargin(r15, r30, r33, r32, r31, r14);
        return;
    L85:
        r13.mConsumed += getHorizontalMargin() + getHorizontalPadding();
        goto L86
    L72:
        r112 = this.mPaddingTop + (r12.getOffset() + this.mMarginTop);
        r111 = r13.mConsumed + r112;
        goto L73
    L74:
        int r34 = r21 - r25.getDecoratedMeasurementInOther(r15);
        if (r34 < 0) goto L78;
        r18 = r34;
    L78:
        int r35 = r18 / 2;
        int r36 = ((r14.getPaddingTop() + this.mMarginTop) + this.mPaddingTop) + r35;
        int r37 = (((r14.getContentHeight() - (-this.mMarginBottom)) - this.mPaddingBottom) - r14.getPaddingBottom()) - r35;
        if (r12.getLayoutDirection() != (-1)) goto L82;
        int r113 = (r12.getOffset() - this.mMarginRight) - this.mPaddingRight;
        r32 = r113;
        r30 = r113 - r13.mConsumed;
    L81:
        r31 = r37;
        r33 = r36;
        goto L83
    L82:
        int r114 = (r12.getOffset() + this.mMarginLeft) + this.mPaddingLeft;
        r30 = r114;
        r32 = r13.mConsumed + r114;
        goto L81
    L37:
        if (Float.isNaN(this.mAspectRatio) == false) goto L39;
    L31:
        if (Float.isNaN(this.mAspectRatio) == false) goto L33;
        r110 = ((ViewGroup.MarginLayoutParams) r17).height;
        goto L35
    L33:
        r110 = r21;
        goto L35
    L25:
        if (Float.isNaN(this.mAspectRatio) == false) goto L27;
        r23 = true;
        goto L28
    L22:
        r22 = r20;
        goto L23
    L42:
        if (Float.isNaN(r17.mAspectRatio) == true) goto L44;
        int r38 = (int) ((r21 * r17.mAspectRatio) + 0.5f);
    L48:
        if (r19 == false) goto L50;
    L52:
        boolean r39 = false;
    L53:
        int r40 = r14.getChildMeasureSpec(r20, r38, r39);
        if (Float.isNaN(this.mAspectRatio) == false) goto L56;
        int r115 = ((ViewGroup.MarginLayoutParams) r17).height;
    L57:
        if (r19 == true) goto L59;
    L61:
        r16 = false;
    L62:
        r14.measureChildWithMargins(r15, r40, r14.getChildMeasureSpec(r21, r115, r16));
        goto L63
    L59:
        if (Float.isNaN(this.mAspectRatio) == false) goto L61;
    L56:
        r115 = r21;
        goto L57
    L50:
        if (Float.isNaN(this.mAspectRatio) == false) goto L52;
        r39 = true;
        goto L53
    L44:
        if (Float.isNaN(this.mAspectRatio) == false) goto L46;
        r38 = ((ViewGroup.MarginLayoutParams) r17).width;
        goto L48
    L46:
        r38 = r20;
        goto L48
    L12:
        r19 = false;
        goto L13
    }

    @Override // com.alibaba.android.vlayout.LayoutHelper
    public void onRangeChange(int r10, int r11) {
        this.mPos = r10;
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper, com.alibaba.android.vlayout.LayoutHelper
    public void setItemCount(int r10) {
        if (r10 <= 0) goto L4;
        super.setItemCount(1);
        return;
    L4:
        super.setItemCount(0);
    }
}
