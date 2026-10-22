package com.alibaba.android.vlayout.layout;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.vlayout.LayoutManagerHelper;
import com.alibaba.android.vlayout.OrientationHelperEx;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.google.common.primitives.Ints;

/* JADX INFO: loaded from: classes.dex */
public class LinearLayoutHelper extends BaseLayoutHelper {
    private static final boolean DEBUG = false;
    private static final String TAG = "LinearLayoutHelper";
    private int mDividerHeight;
    private boolean mLayoutWithAnchor;

    public LinearLayoutHelper() {
        this(0);
    }

    @Override // com.alibaba.android.vlayout.LayoutHelper
    public void checkAnchorInfo(RecyclerView.State r10, VirtualLayoutManager.AnchorInfoWrapper r11, LayoutManagerHelper r12) {
        super.checkAnchorInfo(r10, r11, r12);
        this.mLayoutWithAnchor = true;
    }

    @Override // com.alibaba.android.vlayout.layout.MarginLayoutHelper, com.alibaba.android.vlayout.LayoutHelper
    public int computeAlignOffset(int r10, boolean r11, boolean r12, LayoutManagerHelper r13) {
        if (r13.getOrientation() != 1) goto L5;
        boolean r14 = true;
    L6:
        if (r11 == true) goto L8;
        if (r10 != 0) goto L21;
        if (r14 == false) goto L18;
        int r15 = -this.mMarginTop;
        int r16 = this.mPaddingTop;
    L19:
        return r15 - r16;
    L18:
        r15 = -this.mMarginLeft;
        r16 = this.mPaddingLeft;
    L21:
        return super.computeAlignOffset(r10, r11, r12, r13);
    L8:
        if (r10 != (getItemCount() - 1)) goto L21;
        if (r14 == false) goto L12;
        int r17 = this.mMarginBottom;
        int r18 = this.mPaddingBottom;
    L13:
        return r17 + r18;
    L12:
        r17 = this.mMarginRight;
        r18 = this.mPaddingRight;
        goto L13
    L5:
        r14 = false;
        goto L6
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper
    public void layoutViews(RecyclerView.Recycler r20, RecyclerView.State r21, VirtualLayoutManager.LayoutStateWrapper r22, LayoutChunkResult r23, LayoutManagerHelper r24) {
        if (isOutOfRange(r22.getCurrentPosition()) == false) goto L5;
        return;
    L5:
        int r10 = r22.getCurrentPosition();
        View r11 = nextView(r20, r22, r24, r23);
        if (r11 != null) goto L8;
        return;
    L8:
        boolean r12 = r24.isEnableMarginOverLap();
        VirtualLayoutManager.LayoutParams r13 = (VirtualLayoutManager.LayoutParams) r11.getLayoutParams();
        if (r24.getOrientation() != 1) goto L11;
        boolean r14 = true;
    L13:
        if (r22.getLayoutDirection() != 1) goto L15;
        boolean r15 = true;
    L16:
        if (r15 == false) goto L22;
        if (r10 != ((Integer) getRange().getLower()).intValue()) goto L20;
    L19:
        boolean r16 = true;
    L24:
        if (r15 == false) goto L30;
        if (r10 != ((Integer) getRange().getUpper()).intValue()) goto L28;
    L27:
        boolean r17 = true;
    L32:
        if (r16 == false) goto L34;
        int r18 = computeStartSpace(r24, r14, r15, r12);
    L35:
        if (r17 == false) goto L37;
        int r19 = computeEndSpace(r24, r14, r15, r12);
    L38:
        if (r16 == true) goto L61;
        if (r12 == false) goto L41;
        if (r15 == false) goto L53;
        int r110 = ((ViewGroup.MarginLayoutParams) r13).topMargin;
        View r25 = r24.findViewByPosition(r10 - 1);
        if (r25 == null) goto L48;
        int r26 = ((ViewGroup.MarginLayoutParams) ((VirtualLayoutManager.LayoutParams) r25.getLayoutParams())).bottomMargin;
    L49:
        if (r26 < 0) goto L52;
        if (r110 < 0) goto L52;
        int r27 = Math.max(r26, r110);
    L62:
        int r111 = (((r24.getContentWidth() - r24.getPaddingLeft()) - r24.getPaddingRight()) - getHorizontalMargin()) - getHorizontalPadding();
        int r112 = r24.getChildMeasureSpec(r111, ((ViewGroup.MarginLayoutParams) r13).width, !r14);
        float r113 = r13.mAspectRatio;
        if (Float.isNaN(r113) == true) goto L68;
        if (r113 <= 0.0f) goto L68;
        int r28 = View.MeasureSpec.makeMeasureSpec((int) ((r111 / r113) + 0.5f), Ints.MAX_POWER_OF_TWO);
    L73:
        if (r12 == true) goto L75;
        r24.measureChildWithMargins(r11, r112, r28);
    L76:
        OrientationHelperEx r29 = r24.getMainOrientationHelper();
        r23.mConsumed = ((r29.getDecoratedMeasurement(r11) + r18) + r19) + r27;
        if (r24.getOrientation() == 1) goto L79;
        int r30 = (r24.getPaddingTop() + this.mMarginTop) + this.mPaddingTop;
        int r31 = r29.getDecoratedMeasurementInOther(r11) + r30;
        if (r22.getLayoutDirection() != (-1)) goto L98;
        int r32 = r22.getOffset() - r18;
        if (r16 == false) goto L97;
        r27 = 0;
    L97:
        int r33 = r32 - r27;
        int r34 = r33;
        int r35 = r33 - r29.getDecoratedMeasurement(r11);
    L102:
        layoutChildWithMargin(r11, r35, r30, r34, r31, r24);
        handleStateOnResult(r23, r11);
        this.mLayoutWithAnchor = false;
        return;
    L98:
        int r36 = r22.getOffset() + r18;
        if (r16 == false) goto L101;
        r27 = 0;
    L101:
        r35 = r36 + r27;
        r34 = r29.getDecoratedMeasurement(r11) + r35;
        goto L102
    L79:
        if (r24.isDoLayoutRTL() == false) goto L81;
        int r37 = ((r24.getContentWidth() - r24.getPaddingRight()) - this.mMarginRight) - this.mPaddingRight;
        int r38 = r37 - r29.getDecoratedMeasurementInOther(r11);
    L83:
        if (r22.getLayoutDirection() != (-1)) goto L88;
        int r39 = r22.getOffset() - r18;
        if (r16 == false) goto L87;
        r27 = 0;
    L87:
        int r40 = r39 - r27;
        r34 = r37;
        r30 = r40 - r29.getDecoratedMeasurement(r11);
        int r114 = r38;
        r31 = r40;
        r35 = r114;
        goto L102
    L88:
        int r41 = r22.getOffset() + r18;
        if (r16 == false) goto L91;
        r27 = 0;
    L91:
        int r42 = r41 + r27;
        int r43 = r29.getDecoratedMeasurement(r11) + r42;
        r34 = r37;
        r30 = r42;
        r35 = r38;
        r31 = r43;
        goto L102
    L81:
        r38 = this.mPaddingLeft + (r24.getPaddingLeft() + this.mMarginLeft);
        r37 = r29.getDecoratedMeasurementInOther(r11) + r38;
        goto L83
    L75:
        r24.measureChild(r11, r112, r28);
    L68:
        if (Float.isNaN(this.mAspectRatio) == true) goto L72;
        float r115 = this.mAspectRatio;
        if (r115 <= 0.0f) goto L72;
        r28 = View.MeasureSpec.makeMeasureSpec((int) (((double) (r111 / r115)) + 0.5d), Ints.MAX_POWER_OF_TWO);
    L72:
        r28 = r24.getChildMeasureSpec((((r24.getContentHeight() - r24.getPaddingTop()) - r24.getPaddingBottom()) - getVerticalMargin()) - getVerticalPadding(), ((ViewGroup.MarginLayoutParams) r13).height, r14);
    L52:
        r27 = r26 + r110;
        goto L62
    L48:
        r26 = 0;
        goto L49
    L53:
        int r116 = ((ViewGroup.MarginLayoutParams) r13).bottomMargin;
        View r44 = r24.findViewByPosition(r10 + 1);
        if (r44 == null) goto L56;
        int r45 = ((ViewGroup.MarginLayoutParams) ((VirtualLayoutManager.LayoutParams) r44.getLayoutParams())).topMargin;
    L57:
        if (r116 < 0) goto L60;
        if (r45 < 0) goto L60;
        r27 = Math.max(r116, r45);
    L60:
        r27 = r45 + r116;
        goto L62
    L56:
        r45 = 0;
        goto L57
    L41:
        if (this.mLayoutWithAnchor == true) goto L61;
        r27 = this.mDividerHeight;
    L61:
        r27 = 0;
        goto L62
    L37:
        r19 = 0;
        goto L38
    L34:
        r18 = 0;
    L28:
        r17 = false;
        goto L32
    L30:
        if (r10 != ((Integer) getRange().getLower()).intValue()) goto L28;
    L20:
        r16 = false;
        goto L24
    L22:
        if (r10 != ((Integer) getRange().getUpper()).intValue()) goto L20;
    L15:
        r15 = false;
        goto L16
    L11:
        r14 = false;
        goto L13
    }

    public void setDividerHeight(int r10) {
        if (r10 >= 0) goto L4;
        r10 = 0;
    L4:
        this.mDividerHeight = r10;
    }

    public LinearLayoutHelper(int r10) {
        this(r10, 0);
    }

    public LinearLayoutHelper(int r10, int r11) {
        this.mDividerHeight = 0;
        this.mLayoutWithAnchor = false;
        setItemCount(r11);
        setDividerHeight(r10);
    }
}
