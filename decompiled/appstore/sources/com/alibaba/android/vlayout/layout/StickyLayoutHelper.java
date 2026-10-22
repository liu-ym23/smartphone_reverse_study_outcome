package com.alibaba.android.vlayout.layout;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.LayoutManagerHelper;
import com.alibaba.android.vlayout.OrientationHelperEx;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.google.common.primitives.Ints;

/* JADX INFO: loaded from: classes.dex */
public class StickyLayoutHelper extends FixAreaLayoutHelper {
    private static final String TAG = "StickyStartLayoutHelper";
    private boolean mDoNormalHandle;
    private View mFixView;
    private int mOffset;
    private int mPos;
    private boolean mStickyStart;

    public StickyLayoutHelper() {
        this(true);
    }

    private void doMeasure(View r12, LayoutManagerHelper r13) {
        VirtualLayoutManager.LayoutParams r10 = (VirtualLayoutManager.LayoutParams) r12.getLayoutParams();
        if (r13.getOrientation() != 1) goto L5;
        boolean r11 = true;
    L6:
        int r14 = ((r13.getContentWidth() - r13.getPaddingLeft()) - r13.getPaddingRight()) - getHorizontalMargin();
        int r15 = ((r13.getContentHeight() - r13.getPaddingTop()) - r13.getPaddingBottom()) - getVerticalMargin();
        float r16 = r10.mAspectRatio;
        if (r11 == false) goto L20;
        int r17 = r13.getChildMeasureSpec(r14, ((ViewGroup.MarginLayoutParams) r10).width, false);
        if (Float.isNaN(r16) == true) goto L14;
        if (r16 <= 0.0f) goto L14;
        int r18 = View.MeasureSpec.makeMeasureSpec((int) ((r14 / r16) + 0.5f), Ints.MAX_POWER_OF_TWO);
    L19:
        r13.measureChildWithMargins(r12, r17, r18);
        return;
    L14:
        if (Float.isNaN(this.mAspectRatio) == true) goto L18;
        float r19 = this.mAspectRatio;
        if (r19 <= 0.0f) goto L18;
        r18 = View.MeasureSpec.makeMeasureSpec((int) (((double) (r14 / r19)) + 0.5d), Ints.MAX_POWER_OF_TWO);
    L18:
        r18 = r13.getChildMeasureSpec(r15, ((ViewGroup.MarginLayoutParams) r10).height, true);
        goto L19
    L20:
        int r20 = r13.getChildMeasureSpec(r15, ((ViewGroup.MarginLayoutParams) r10).height, false);
        if (Float.isNaN(r16) == true) goto L26;
        if (r16 <= 0.0f) goto L26;
        int r110 = View.MeasureSpec.makeMeasureSpec((int) (((double) (r15 * r16)) + 0.5d), Ints.MAX_POWER_OF_TWO);
    L31:
        r13.measureChildWithMargins(r12, r110, r20);
        return;
    L26:
        if (Float.isNaN(this.mAspectRatio) == true) goto L30;
        float r111 = this.mAspectRatio;
        if (r111 <= 0.0f) goto L30;
        r110 = View.MeasureSpec.makeMeasureSpec((int) (((double) (r15 * r111)) + 0.5d), Ints.MAX_POWER_OF_TWO);
    L30:
        r110 = r13.getChildMeasureSpec(r14, ((ViewGroup.MarginLayoutParams) r10).width, true);
        goto L31
    L5:
        r11 = false;
        goto L6
    }

    private void fixLayoutStateFromAbnormal2Normal(OrientationHelperEx r10, RecyclerView.Recycler r11, int r12, int r13, LayoutManagerHelper r14) {
        Log.i(TAG, "abnormal pos: " + this.mPos + " start: " + r12 + " end: " + r13);
        if (this.mFixView != null) goto L5;
        return;
    L5:
        if (this.mStickyStart == false) goto L21;
        int r15 = r14.getChildCount() - 1;
    L7:
        if (r15 < 0) goto L46;
        View r16 = r14.getChildAt(r15);
        int r17 = r14.getPosition(r16);
        if (r17 < this.mPos) goto L10;
        r15 = r15 - 1;
        goto L7
    L10:
        int r18 = r10.getDecoratedEnd(r16);
        LayoutHelper r19 = r14.findLayoutHelperByPosition(r17);
        if ((r19 instanceof RangeGridLayoutHelper) == false) goto L15;
        int r20 = ((RangeGridLayoutHelper) r19).getBorderEndSpace(r14);
    L13:
        r18 = r18 + r20;
    L18:
        if (r18 < (this.mOffset + this.mAdjuster.top)) goto L42;
        this.mDoNormalHandle = true;
        return;
    L42:
        return;
    L15:
        if ((r19 instanceof MarginLayoutHelper) == false) goto L18;
        MarginLayoutHelper r21 = (MarginLayoutHelper) r19;
        r18 = r18 + r21.getMarginBottom();
        r20 = r21.getPaddingBottom();
        goto L13
    L46:
        return;
    L21:
        int r22 = 0;
    L23:
        if (r22 >= r14.getChildCount()) goto L47;
        View r23 = r14.getChildAt(r22);
        int r24 = r14.getPosition(r23);
        if (r24 > this.mPos) goto L26;
        r22 = r22 + 1;
        goto L23
    L26:
        int r25 = r10.getDecoratedStart(r23);
        LayoutHelper r26 = r14.findLayoutHelperByPosition(r24);
        if ((r26 instanceof RangeGridLayoutHelper) == false) goto L31;
        int r27 = ((RangeGridLayoutHelper) r26).getBorderStartSpace(r14);
    L29:
        r25 = r25 - r27;
    L34:
        if (r25 < (this.mOffset + this.mAdjuster.bottom)) goto L44;
        this.mDoNormalHandle = true;
        return;
    L44:
        return;
    L31:
        if ((r26 instanceof MarginLayoutHelper) == false) goto L34;
        MarginLayoutHelper r28 = (MarginLayoutHelper) r26;
        r25 = r25 - r28.getMarginTop();
        r27 = r28.getPaddingTop();
        goto L29
    }

    private void fixLayoutStateInCase1(OrientationHelperEx r18, RecyclerView.Recycler r19, int r20, int r21, LayoutManagerHelper r22) {
        boolean r10 = this.mStickyStart;
        if (r10 == true) goto L5;
    L6:
        if (r10 == false) goto L8;
    L114:
        r22.removeChildView(this.mFixView);
        r22.recycleView(this.mFixView);
        this.mFixView = null;
        return;
    L8:
        if (r20 > this.mPos) goto L114;
    L9:
        int r11 = r18.getDecoratedMeasurement(this.mFixView);
        int r12 = 0;
        if (r22.getOrientation() != 1) goto L12;
        boolean r13 = true;
    L13:
        FixAreaAdjuster r14 = this.mAdjuster;
        if (r13 == false) goto L16;
        int r15 = r14.top;
    L17:
        FixAreaAdjuster r16 = this.mAdjuster;
        if (r13 == false) goto L20;
        int r17 = r16.bottom;
    L21:
        int r110 = -1;
        if (r13 == true) goto L24;
        int r23 = r22.getPaddingTop();
        int r111 = r18.getDecoratedMeasurementInOther(this.mFixView) + r23;
        if (this.mDoNormalHandle == false) goto L103;
        if (this.mStickyStart == false) goto L93;
        int r24 = r22.getChildCount() - 1;
    L88:
        if (r24 < 0) goto L100;
        View r25 = r22.getChildAt(r24);
        if (r22.getPosition(r25) < this.mPos) goto L91;
        r24 = r24 - 1;
        goto L88
    L91:
        r12 = r18.getDecoratedEnd(r25);
        int r26 = r12 + r11;
    L101:
        int r27 = r23;
        int r28 = r12;
        int r29 = r111;
        int r30 = r26;
    L109:
        layoutChildWithMargin(this.mFixView, r28, r27, r30, r29, r22);
        if (this.mDoNormalHandle == false) goto L113;
        if (r110 < 0) goto L124;
        r22.addChildView(this.mFixView, r110);
        this.mFixView = null;
        return;
    L124:
        return;
    L113:
        r22.showView(this.mFixView);
        r22.addFixedView(this.mFixView);
        return;
    L100:
        r26 = 0;
        goto L101
    L93:
        int r31 = 0;
    L95:
        if (r31 >= r22.getChildCount()) goto L100;
        View r32 = r22.getChildAt(r31);
        if (r22.getPosition(r32) > this.mPos) goto L98;
        r31 = r31 + 1;
        goto L95
    L98:
        int r33 = r18.getDecoratedStart(r32);
        r12 = r33 - r11;
        r26 = r33;
        goto L101
    L103:
        if (r22.getReverseLayout() == false) goto L105;
    L108:
        int r34 = (r18.getEndAfterPadding() - this.mOffset) - r17;
        r30 = r34;
        r27 = r23;
        r29 = r111;
        r28 = r34 - r11;
        goto L109
    L105:
        if (this.mStickyStart == false) goto L108;
        int r35 = (r18.getStartAfterPadding() + this.mOffset) + r15;
        r30 = r11 + r35;
        r27 = r23;
        r29 = r111;
        r28 = r35;
        goto L109
    L24:
        if (r22.isDoLayoutRTL() == false) goto L26;
        int r36 = r22.getContentWidth() - r22.getPaddingRight();
        int r112 = r36 - r18.getDecoratedMeasurementInOther(this.mFixView);
    L28:
        if (this.mStickyStart == false) goto L42;
        int r113 = r22.getChildCount() - 1;
        View r114 = null;
    L30:
        if (r113 < 0) goto L58;
        r114 = r22.getChildAt(r113);
        int r115 = r22.getPosition(r114);
        if (r115 < this.mPos) goto L33;
        r113 = r113 - 1;
        goto L30
    L33:
        int r116 = r18.getDecoratedEnd(r114);
        LayoutHelper r117 = r22.findLayoutHelperByPosition(r115);
        if ((r117 instanceof RangeGridLayoutHelper) == false) goto L38;
        int r118 = ((RangeGridLayoutHelper) r117).getBorderEndSpace(r22);
    L36:
        r116 = r116 + r118;
    L40:
        int r119 = r116 + r11;
        this.mDoNormalHandle = true;
    L56:
        r27 = r116;
        r110 = r113;
    L59:
        if (r114 == null) goto L61;
        if (r110 < 0) goto L61;
    L63:
        if (r22.getReverseLayout() == true) goto L71;
        if (this.mStickyStart == false) goto L71;
        if (r27 >= ((r18.getStartAfterPadding() + this.mOffset) + r15)) goto L74;
        this.mDoNormalHandle = false;
    L74:
        if (this.mDoNormalHandle == false) goto L76;
    L82:
        r30 = r36;
        r28 = r112;
        r29 = r119;
        goto L109
    L76:
        if (r22.getReverseLayout() == false) goto L78;
    L81:
        r119 = (r18.getEndAfterPadding() - this.mOffset) - r17;
        r27 = r119 - r11;
        goto L82
    L78:
        if (this.mStickyStart == false) goto L81;
        r27 = (r18.getStartAfterPadding() + this.mOffset) + r15;
        r119 = r27 + r11;
    L71:
        if (r119 <= ((r18.getEndAfterPadding() - this.mOffset) - r17)) goto L74;
        this.mDoNormalHandle = false;
    L61:
        this.mDoNormalHandle = false;
        goto L63
    L38:
        if ((r117 instanceof MarginLayoutHelper) == false) goto L40;
        MarginLayoutHelper r120 = (MarginLayoutHelper) r117;
        r116 = r116 + r120.getMarginBottom();
        r118 = r120.getPaddingBottom();
    L58:
        r27 = 0;
        r119 = 0;
        goto L59
    L42:
        int r121 = 0;
        r114 = null;
    L44:
        if (r121 >= r22.getChildCount()) goto L58;
        r114 = r22.getChildAt(r121);
        int r122 = r22.getPosition(r114);
        if (r122 > this.mPos) goto L47;
        r121 = r121 + 1;
        goto L44
    L47:
        int r123 = r18.getDecoratedStart(r114);
        LayoutHelper r124 = r22.findLayoutHelperByPosition(r122);
        if ((r124 instanceof RangeGridLayoutHelper) == false) goto L53;
        int r125 = ((RangeGridLayoutHelper) r124).getBorderStartSpace(r22);
    L50:
        r123 = r123 - r125;
    L51:
        r119 = r123;
        r116 = r119 - r11;
        r113 = r121 + 1;
        this.mDoNormalHandle = true;
        goto L56
    L53:
        if ((r124 instanceof MarginLayoutHelper) == false) goto L51;
        MarginLayoutHelper r126 = (MarginLayoutHelper) r124;
        r123 = r123 - r126.getMarginTop();
        r125 = r126.getPaddingTop();
        goto L50
    L26:
        r112 = r22.getPaddingLeft();
        r36 = r18.getDecoratedMeasurementInOther(this.mFixView) + r112;
        goto L28
    L20:
        r17 = r16.right;
        goto L21
    L16:
        r15 = r14.left;
        goto L17
    L12:
        r13 = false;
        goto L13
    L5:
        if (r21 >= this.mPos) goto L9;
        goto L6
    }

    private void fixLayoutStateInCase2(OrientationHelperEx r19, RecyclerView.Recycler r20, int r21, int r22, LayoutManagerHelper r23) {
        View r10 = this.mFixView;
        if (r10 != null) goto L6;
        r10 = r23.findViewByPosition(this.mPos);
    L6:
        if (r23.getOrientation() != 1) goto L8;
        boolean r11 = true;
    L9:
        FixAreaAdjuster r12 = this.mAdjuster;
        if (r11 == false) goto L12;
        int r13 = r12.top;
    L13:
        FixAreaAdjuster r14 = this.mAdjuster;
        if (r11 == false) goto L16;
        int r15 = r14.bottom;
    L17:
        boolean r16 = this.mStickyStart;
        if (r16 == true) goto L20;
    L21:
        if (r16 == false) goto L23;
    L45:
        boolean r17 = false;
    L46:
        View r18 = this.mFixView;
        if (r18 != null) goto L49;
    L148:
        this.mDoNormalHandle = r17;
        return;
    L49:
        if (((RecyclerView.LayoutParams) r18.getLayoutParams()).isItemRemoved() == false) goto L51;
        return;
    L51:
        int r24 = r19.getDecoratedMeasurement(this.mFixView);
        int r110 = -1;
        if (r11 == true) goto L54;
        int r25 = r23.getPaddingTop();
        int r26 = r19.getDecoratedMeasurementInOther(this.mFixView) + r25;
        if (r17 == false) goto L136;
        if (this.mStickyStart == false) goto L126;
        int r27 = r23.getChildCount() - 1;
    L121:
        if (r27 < 0) goto L133;
        View r28 = r23.getChildAt(r27);
        if (r23.getPosition(r28) < this.mPos) goto L124;
        r27 = r27 - 1;
        goto L121
    L124:
        int r29 = r19.getDecoratedEnd(r28);
        int r111 = r29 + r24;
    L134:
        boolean r30 = r17;
        int r31 = r25;
        int r32 = r26;
        int r33 = r111;
        int r34 = r29;
    L142:
        layoutChildWithMargin(this.mFixView, r34, r31, r33, r32, r23);
        if (r30 == false) goto L146;
        if (r110 < 0) goto L147;
        r23.addChildView(this.mFixView, r110);
        this.mFixView = null;
    L147:
        r17 = r30;
        goto L148
    L146:
        r23.addFixedView(this.mFixView);
    L133:
        r29 = 0;
        r111 = 0;
        goto L134
    L126:
        int r35 = 0;
    L128:
        if (r35 >= r23.getChildCount()) goto L133;
        View r36 = r23.getChildAt(r35);
        if (r23.getPosition(r36) > this.mPos) goto L131;
        r35 = r35 + 1;
        goto L128
    L131:
        int r37 = r19.getDecoratedStart(r36);
        r111 = r37;
        r29 = r37 - r24;
        goto L134
    L136:
        if (r23.getReverseLayout() == false) goto L138;
    L141:
        int r38 = (r19.getEndAfterPadding() - this.mOffset) - r15;
        int r39 = r38 - r24;
        r30 = r17;
        r32 = r26;
        r33 = r38;
        r31 = r25;
        r34 = r39;
        goto L142
    L138:
        if (this.mStickyStart == false) goto L141;
        int r40 = (r19.getStartAfterPadding() + this.mOffset) + r13;
        r31 = r25;
        r32 = r26;
        r33 = r24 + r40;
        r34 = r40;
        r30 = r17;
        goto L142
    L54:
        if (r23.isDoLayoutRTL() == false) goto L56;
        int r41 = r23.getContentWidth() - r23.getPaddingRight();
        int r112 = r41 - r19.getDecoratedMeasurementInOther(this.mFixView);
    L57:
        if (r17 == true) goto L59;
        r30 = r17;
        int r42 = 0;
        int r113 = 0;
    L105:
        if (r30 == false) goto L107;
        r32 = r42;
        r31 = r113;
    L113:
        r33 = r41;
        r34 = r112;
        goto L142
    L107:
        if (r23.getReverseLayout() == false) goto L109;
    L114:
        int r43 = (r19.getEndAfterPadding() - this.mOffset) - r15;
        r32 = r43;
        r31 = r43 - r24;
        goto L113
    L109:
        if (this.mStickyStart == false) goto L114;
        int r44 = (r19.getStartAfterPadding() + this.mOffset) + r13;
        r31 = r44;
        r32 = r24 + r44;
        goto L113
    L59:
        if (this.mStickyStart == false) goto L73;
        int r114 = r23.getChildCount() - 1;
        View r115 = null;
    L61:
        if (r114 < 0) goto L88;
        r115 = r23.getChildAt(r114);
        int r116 = r23.getPosition(r115);
        if (r116 < this.mPos) goto L64;
        r114 = r114 - 1;
        goto L61
    L64:
        int r45 = r19.getDecoratedEnd(r115);
        LayoutHelper r117 = r23.findLayoutHelperByPosition(r116);
        if ((r117 instanceof RangeGridLayoutHelper) == false) goto L69;
        int r118 = ((RangeGridLayoutHelper) r117).getBorderEndSpace(r23);
    L67:
        r45 = r45 + r118;
    L71:
        int r119 = r45 + r24;
        int r46 = 1 + r114;
    L86:
        int r120 = r119;
        r110 = r46;
        r42 = r120;
    L89:
        if (r115 == null) goto L91;
        if (r110 < 0) goto L91;
    L93:
        if (r23.getReverseLayout() == true) goto L101;
        if (this.mStickyStart == false) goto L101;
        if (r45 >= ((r19.getStartAfterPadding() + this.mOffset) + r13)) goto L103;
    L99:
        r113 = r45;
        r30 = false;
    L103:
        r113 = r45;
        r30 = r17;
    L101:
        if (r42 <= ((r19.getEndAfterPadding() - this.mOffset) - r15)) goto L103;
    L91:
        r17 = false;
        goto L93
    L69:
        if ((r117 instanceof MarginLayoutHelper) == false) goto L71;
        MarginLayoutHelper r121 = (MarginLayoutHelper) r117;
        r45 = r45 + r121.getMarginBottom();
        r118 = r121.getPaddingBottom();
    L88:
        r42 = 0;
        r45 = 0;
        goto L89
    L73:
        r115 = null;
        r46 = 0;
    L75:
        if (r46 >= r23.getChildCount()) goto L88;
        r115 = r23.getChildAt(r46);
        int r47 = r23.getPosition(r115);
        if (r47 > this.mPos) goto L78;
        r46 = r46 + 1;
        goto L75
    L78:
        r119 = r19.getDecoratedStart(r115);
        LayoutHelper r48 = r23.findLayoutHelperByPosition(r47);
        if ((r48 instanceof RangeGridLayoutHelper) == false) goto L83;
        int r49 = ((RangeGridLayoutHelper) r48).getBorderStartSpace(r23);
    L81:
        r119 = r119 - r49;
    L85:
        r45 = r119 - r24;
        goto L86
    L83:
        if ((r48 instanceof MarginLayoutHelper) == false) goto L85;
        MarginLayoutHelper r50 = (MarginLayoutHelper) r48;
        r119 = r119 - r50.getMarginTop();
        r49 = r50.getPaddingTop();
        goto L81
    L56:
        r112 = r23.getPaddingLeft();
        r41 = r19.getDecoratedMeasurementInOther(this.mFixView) + r112;
        goto L57
    L23:
        if (r21 > this.mPos) goto L45;
    L24:
        if (r10 != null) goto L34;
        int r51 = this.mOffset;
        if (r16 == false) goto L28;
        int r52 = r13;
    L30:
        if ((r51 + r52) <= 0) goto L32;
        r17 = true;
    L33:
        View r53 = r20.o(this.mPos);
        this.mFixView = r53;
        doMeasure(r53, r23);
        goto L46
    L32:
        r17 = false;
        goto L33
    L28:
        r52 = r15;
        goto L30
    L34:
        if (r16 == false) goto L40;
        if (r19.getDecoratedStart(r10) < ((r19.getStartAfterPadding() + this.mOffset) + r13)) goto L40;
        this.mFixView = r10;
    L38:
        r17 = true;
    L40:
        if (this.mStickyStart == false) goto L42;
    L44:
        this.mFixView = r10;
        goto L45
    L42:
        if (r19.getDecoratedEnd(r10) > ((r19.getEndAfterPadding() - this.mOffset) - r15)) goto L44;
        this.mFixView = r10;
        goto L38
    L20:
        if (r22 >= this.mPos) goto L24;
    L16:
        r15 = r14.right;
        goto L17
    L12:
        r13 = r12.left;
        goto L13
    L8:
        r11 = false;
        goto L9
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper, com.alibaba.android.vlayout.LayoutHelper
    public void afterLayout(RecyclerView.Recycler r10, RecyclerView.State r11, int r12, int r13, int r14, LayoutManagerHelper r15) {
        super.afterLayout(r10, r11, r12, r13, r14, r15);
        if (this.mPos >= 0) goto L5;
        return;
    L5:
        OrientationHelperEx r16 = r15.getMainOrientationHelper();
        if (this.mDoNormalHandle == true) goto L12;
        int r17 = this.mPos;
        if (r17 < r12) goto L12;
        if (r17 > r13) goto L12;
        fixLayoutStateFromAbnormal2Normal(r16, r10, r12, r13, r15);
    L12:
        if (this.mDoNormalHandle == false) goto L14;
    L15:
        r11.f();
        View r18 = this.mFixView;
        if (r18 == null) goto L28;
        r15.removeChildView(r18);
    L19:
        if (this.mDoNormalHandle == true) goto L26;
        View r19 = this.mFixView;
        if (r19 == null) goto L26;
        if (r19.getParent() != null) goto L25;
        r15.addFixedView(this.mFixView);
        return;
    L25:
        fixLayoutStateInCase1(r16, r10, r12, r13, r15);
        return;
    L26:
        fixLayoutStateInCase2(r16, r10, r12, r13, r15);
        return;
    L28:
        return;
    L14:
        if (r11.f() == false) goto L19;
        goto L15
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
        goto L7
    }

    @Override // com.alibaba.android.vlayout.LayoutHelper
    @Nullable
    public View getFixedView() {
        return this.mFixView;
    }

    public boolean isStickyNow() {
        return !this.mDoNormalHandle;
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper
    public void layoutViews(RecyclerView.Recycler r17, RecyclerView.State r18, VirtualLayoutManager.LayoutStateWrapper r19, LayoutChunkResult r20, LayoutManagerHelper r21) {
        if (isOutOfRange(r19.getCurrentPosition()) == false) goto L5;
        return;
    L5:
        View r10 = this.mFixView;
        if (r10 != null) goto L9;
        r10 = r19.next(r17);
    L8:
        View r11 = r10;
        if (r11 != null) goto L14;
        r20.mFinished = true;
        return;
    L14:
        doMeasure(r11, r21);
        if (r21.getOrientation() != 1) goto L17;
        boolean r13 = true;
    L18:
        OrientationHelperEx r12 = r21.getMainOrientationHelper();
        r20.mConsumed = r12.getDecoratedMeasurement(r11);
        RecyclerView.LayoutParams r14 = (RecyclerView.LayoutParams) r11.getLayoutParams();
        this.mDoNormalHandle = true;
        int r15 = (r19.getAvailable() - r20.mConsumed) + r19.getExtra();
        if (r21.getOrientation() == 1) goto L21;
        int r16 = r21.getPaddingTop();
        int r22 = (r12.getDecoratedMeasurementInOther(r11) + r16) + this.mMarginTop;
        if (r19.getLayoutDirection() != (-1)) goto L55;
        int r23 = r19.getOffset() - this.mMarginRight;
        int r24 = r19.getOffset() - r20.mConsumed;
    L57:
        if (r21.getReverseLayout() == true) goto L65;
        if (this.mStickyStart == false) goto L65;
        if (r15 >= (this.mOffset + this.mAdjuster.left)) goto L67;
        this.mDoNormalHandle = false;
        this.mFixView = r11;
        int r25 = (r12.getStartAfterPadding() + this.mOffset) + this.mAdjuster.left;
        r23 = r20.mConsumed;
    L68:
        layoutChildWithMargin(r11, r25, r16, r23, r22, r21);
        int r26 = r20.mConsumed;
        if (r13 == false) goto L71;
        int r27 = getVerticalMargin();
    L72:
        r20.mConsumed = r26 + r27;
        if (r18.f() == false) goto L76;
        this.mDoNormalHandle = true;
    L76:
        if (this.mDoNormalHandle == false) goto L79;
        r21.addChildView(r19, r11);
        handleStateOnResult(r20, r11);
        this.mFixView = null;
        return;
    L79:
        return;
    L71:
        r27 = getHorizontalMargin();
    L67:
        r25 = r24;
    L65:
        if (r15 >= (this.mOffset + this.mAdjuster.right)) goto L67;
        this.mDoNormalHandle = false;
        this.mFixView = r11;
        int r28 = (r12.getEndAfterPadding() - this.mOffset) - this.mAdjuster.right;
        r23 = r28;
        r25 = r28 - r20.mConsumed;
        goto L68
    L55:
        r24 = this.mMarginLeft + r19.getOffset();
        r23 = r19.getOffset() + r20.mConsumed;
        goto L57
    L21:
        if (r21.isDoLayoutRTL() == false) goto L23;
        int r29 = (r21.getContentWidth() - r21.getPaddingRight()) - this.mMarginRight;
        int r30 = r29 - r12.getDecoratedMeasurementInOther(r11);
    L25:
        if (r19.getLayoutDirection() != (-1)) goto L28;
        int r31 = r19.getOffset() - this.mMarginBottom;
        int r110 = r19.getOffset() - r20.mConsumed;
    L32:
        if (r21.getReverseLayout() == true) goto L45;
        if (this.mStickyStart == false) goto L45;
        if (r15 >= (this.mOffset + this.mAdjuster.top)) goto L41;
        if (r19.getItemDirection() != (-1)) goto L41;
    L42:
        this.mDoNormalHandle = false;
        this.mFixView = r11;
        int r32 = ((r12.getStartAfterPadding() + this.mMarginTop) + this.mOffset) + this.mAdjuster.top;
        r23 = r29;
        r25 = r30;
        r16 = r32;
        r22 = r20.mConsumed + r32;
    L41:
        if (r110 < ((this.mMarginTop + this.mOffset) + this.mAdjuster.top)) goto L42;
        Log.i("Sticky", "remainingSpace: " + r15 + "    offset: " + this.mOffset);
    L51:
        r23 = r29;
        r25 = r30;
        r22 = r31;
        r16 = r110;
    L45:
        if (r15 >= (this.mOffset + this.mAdjuster.bottom)) goto L49;
        if (r19.getItemDirection() != 1) goto L49;
    L50:
        this.mDoNormalHandle = false;
        this.mFixView = r11;
        int r33 = ((r12.getEndAfterPadding() - this.mMarginBottom) - this.mOffset) - this.mAdjuster.bottom;
        r23 = r29;
        r25 = r30;
        r22 = r33;
        r16 = r33 - r20.mConsumed;
    L49:
        if (r31 <= ((this.mMarginBottom + this.mOffset) + this.mAdjuster.bottom)) goto L51;
    L28:
        if (this.mStickyStart == false) goto L30;
        r110 = this.mMarginTop + r19.getOffset();
        r31 = r19.getOffset() + r20.mConsumed;
        goto L32
    L30:
        r31 = ((r12.getEndAfterPadding() - this.mMarginBottom) - this.mOffset) - this.mAdjuster.bottom;
        r110 = r31 - r20.mConsumed;
        goto L32
    L23:
        r30 = this.mMarginLeft + r21.getPaddingLeft();
        r29 = r12.getDecoratedMeasurementInOther(r11) + r30;
        goto L25
    L17:
        r13 = false;
        goto L18
    L9:
        r19.skipCurrentPosition();
        goto L8
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper
    public void onClear(LayoutManagerHelper r10) {
        super.onClear(r10);
        View r11 = this.mFixView;
        if (r11 == null) goto L6;
        r10.removeChildView(r11);
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

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper, com.alibaba.android.vlayout.LayoutHelper
    public void setItemCount(int r10) {
        if (r10 <= 0) goto L4;
        super.setItemCount(1);
        return;
    L4:
        super.setItemCount(0);
    }

    public void setOffset(int r10) {
        this.mOffset = r10;
    }

    public void setStickyStart(boolean r10) {
        this.mStickyStart = r10;
    }

    public StickyLayoutHelper(boolean r10) {
        this.mPos = -1;
        this.mOffset = 0;
        this.mFixView = null;
        this.mDoNormalHandle = false;
        this.mStickyStart = r10;
        setItemCount(1);
    }
}
