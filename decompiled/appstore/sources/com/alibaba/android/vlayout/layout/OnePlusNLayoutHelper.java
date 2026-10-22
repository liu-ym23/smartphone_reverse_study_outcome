package com.alibaba.android.vlayout.layout;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.vlayout.LayoutManagerHelper;
import com.alibaba.android.vlayout.OrientationHelperEx;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.google.common.primitives.Ints;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class OnePlusNLayoutHelper extends AbstractFullFillLayoutHelper {
    private static final String TAG = "OnePlusNLayoutHelper";
    private Rect mAreaRect;
    private View[] mChildrenViews;
    private float[] mColWeights;
    private float mRowWeight;

    public OnePlusNLayoutHelper() {
        this.mAreaRect = new Rect();
        this.mColWeights = new float[0];
        this.mRowWeight = Float.NaN;
        setItemCount(0);
    }

    private float getViewMainWeight(ViewGroup.MarginLayoutParams r10, int r11) {
        float[] r12 = this.mColWeights;
        if (r12.length > r11) goto L5;
        return Float.NaN;
    L5:
        return r12[r11];
    }

    private int handleFive(VirtualLayoutManager.LayoutStateWrapper r24, LayoutChunkResult r25, LayoutManagerHelper r26, boolean r27, int r28, int r29, int r30, int r31) {
        OrientationHelperEx r10 = r26.getMainOrientationHelper();
        View r12 = this.mChildrenViews[0];
        VirtualLayoutManager.LayoutParams r11 = new VirtualLayoutManager.LayoutParams((VirtualLayoutManager.LayoutParams) r12.getLayoutParams());
        if (r26.getReverseLayout() == false) goto L6;
        View r13 = this.mChildrenViews[4];
    L5:
        View r14 = r13;
        VirtualLayoutManager.LayoutParams r15 = new VirtualLayoutManager.LayoutParams((VirtualLayoutManager.LayoutParams) r14.getLayoutParams());
        if (r26.getReverseLayout() == false) goto L11;
        View r16 = this.mChildrenViews[3];
    L10:
        View r17 = r16;
        VirtualLayoutManager.LayoutParams r18 = new VirtualLayoutManager.LayoutParams((VirtualLayoutManager.LayoutParams) r17.getLayoutParams());
        if (r26.getReverseLayout() == false) goto L16;
        View r19 = this.mChildrenViews[2];
    L15:
        View r110 = r19;
        VirtualLayoutManager.LayoutParams r111 = new VirtualLayoutManager.LayoutParams((VirtualLayoutManager.LayoutParams) r110.getLayoutParams());
        if (r26.getReverseLayout() == false) goto L20;
        View r20 = this.mChildrenViews[1];
    L21:
        VirtualLayoutManager.LayoutParams r21 = new VirtualLayoutManager.LayoutParams((VirtualLayoutManager.LayoutParams) r20.getLayoutParams());
        float r22 = getViewMainWeight(r11, 0);
        float r112 = getViewMainWeight(r11, 1);
        float r113 = getViewMainWeight(r11, 2);
        float r23 = getViewMainWeight(r11, 3);
        float r32 = getViewMainWeight(r11, 4);
        if (r27 == false) goto L61;
        View r33 = r20;
        ((ViewGroup.MarginLayoutParams) r15).topMargin = ((ViewGroup.MarginLayoutParams) r11).topMargin;
        int r34 = ((ViewGroup.MarginLayoutParams) r11).bottomMargin;
        ((ViewGroup.MarginLayoutParams) r111).bottomMargin = r34;
        ((ViewGroup.MarginLayoutParams) r18).bottomMargin = r34;
        ((ViewGroup.MarginLayoutParams) r18).leftMargin = ((ViewGroup.MarginLayoutParams) r15).leftMargin;
        ((ViewGroup.MarginLayoutParams) r111).rightMargin = ((ViewGroup.MarginLayoutParams) r15).rightMargin;
        ((ViewGroup.MarginLayoutParams) r21).rightMargin = ((ViewGroup.MarginLayoutParams) r15).rightMargin;
        if (Float.isNaN(this.mAspectRatio) == true) goto L27;
        ((ViewGroup.MarginLayoutParams) r11).height = (int) ((r28 - r30) / this.mAspectRatio);
    L27:
        int r35 = ((((r28 - r30) - ((ViewGroup.MarginLayoutParams) r11).leftMargin) - ((ViewGroup.MarginLayoutParams) r11).rightMargin) - ((ViewGroup.MarginLayoutParams) r15).leftMargin) - ((ViewGroup.MarginLayoutParams) r15).rightMargin;
        if (Float.isNaN(r22) == false) goto L30;
        int r36 = (int) ((r35 / 2.0f) + 0.5f);
    L32:
        if (Float.isNaN(r112) == false) goto L34;
        int r37 = r35 - r36;
    L36:
        if (Float.isNaN(r113) == false) goto L38;
        int r114 = (int) ((((r37 - ((ViewGroup.MarginLayoutParams) r18).rightMargin) - ((ViewGroup.MarginLayoutParams) r111).leftMargin) / 3.0f) + 0.5f);
    L40:
        if (Float.isNaN(r23) == false) goto L42;
        int r38 = (int) ((((r37 - ((ViewGroup.MarginLayoutParams) r18).rightMargin) - ((ViewGroup.MarginLayoutParams) r111).leftMargin) / 3.0f) + 0.5f);
    L44:
        if (Float.isNaN(r32) == false) goto L46;
        int r39 = (((r37 - ((ViewGroup.MarginLayoutParams) r18).rightMargin) - ((ViewGroup.MarginLayoutParams) r111).leftMargin) - r114) - r38;
    L47:
        r26.measureChildWithMargins(r12, View.MeasureSpec.makeMeasureSpec((r36 + ((ViewGroup.MarginLayoutParams) r11).leftMargin) + ((ViewGroup.MarginLayoutParams) r11).rightMargin, Ints.MAX_POWER_OF_TWO), r26.getChildMeasureSpec(r26.getContentHeight(), ((ViewGroup.MarginLayoutParams) r11).height, true));
        int r40 = r12.getMeasuredHeight();
        if (Float.isNaN(this.mRowWeight) == false) goto L51;
        float r41 = ((r40 - ((ViewGroup.MarginLayoutParams) r15).bottomMargin) - ((ViewGroup.MarginLayoutParams) r18).topMargin) / 2.0f;
    L50:
        int r42 = (int) (r41 + 0.5f);
        int r43 = ((r40 - ((ViewGroup.MarginLayoutParams) r15).bottomMargin) - ((ViewGroup.MarginLayoutParams) r18).topMargin) - r42;
        r26.measureChildWithMargins(r14, View.MeasureSpec.makeMeasureSpec((r37 + ((ViewGroup.MarginLayoutParams) r15).leftMargin) + ((ViewGroup.MarginLayoutParams) r15).rightMargin, Ints.MAX_POWER_OF_TWO), View.MeasureSpec.makeMeasureSpec((((ViewGroup.MarginLayoutParams) r15).topMargin + r42) + ((ViewGroup.MarginLayoutParams) r15).bottomMargin, Ints.MAX_POWER_OF_TWO));
        r26.measureChildWithMargins(r17, View.MeasureSpec.makeMeasureSpec((r114 + ((ViewGroup.MarginLayoutParams) r18).leftMargin) + ((ViewGroup.MarginLayoutParams) r18).rightMargin, Ints.MAX_POWER_OF_TWO), View.MeasureSpec.makeMeasureSpec((((ViewGroup.MarginLayoutParams) r18).topMargin + r43) + ((ViewGroup.MarginLayoutParams) r18).bottomMargin, Ints.MAX_POWER_OF_TWO));
        View r115 = r110;
        r26.measureChildWithMargins(r115, View.MeasureSpec.makeMeasureSpec((r38 + ((ViewGroup.MarginLayoutParams) r111).leftMargin) + ((ViewGroup.MarginLayoutParams) r111).rightMargin, Ints.MAX_POWER_OF_TWO), View.MeasureSpec.makeMeasureSpec((((ViewGroup.MarginLayoutParams) r111).topMargin + r43) + ((ViewGroup.MarginLayoutParams) r111).bottomMargin, Ints.MAX_POWER_OF_TWO));
        r26.measureChildWithMargins(r33, View.MeasureSpec.makeMeasureSpec((r39 + ((ViewGroup.MarginLayoutParams) r21).leftMargin) + ((ViewGroup.MarginLayoutParams) r21).rightMargin, Ints.MAX_POWER_OF_TWO), View.MeasureSpec.makeMeasureSpec((((ViewGroup.MarginLayoutParams) r21).topMargin + r43) + ((ViewGroup.MarginLayoutParams) r21).bottomMargin, Ints.MAX_POWER_OF_TWO));
        calculateRect(Math.max((r40 + ((ViewGroup.MarginLayoutParams) r11).topMargin) + ((ViewGroup.MarginLayoutParams) r11).bottomMargin, ((r42 + ((ViewGroup.MarginLayoutParams) r15).topMargin) + ((ViewGroup.MarginLayoutParams) r15).bottomMargin) + Math.max((((ViewGroup.MarginLayoutParams) r18).topMargin + r43) + ((ViewGroup.MarginLayoutParams) r18).bottomMargin, (r43 + ((ViewGroup.MarginLayoutParams) r111).topMargin) + ((ViewGroup.MarginLayoutParams) r111).bottomMargin)), this.mAreaRect, r24, r26);
        r12 = r12;
        int r116 = this.mAreaRect.left + r10.getDecoratedMeasurementInOther(r12);
        Rect r44 = this.mAreaRect;
        View r117 = r33;
        layoutChildWithMargin(r12, r44.left, r44.top, r116, r44.bottom, r26);
        int r45 = r116 + r10.getDecoratedMeasurementInOther(r14);
        int r46 = this.mAreaRect.top;
        layoutChildWithMargin(r14, r116, r46, r45, r46 + r10.getDecoratedMeasurement(r14), r26);
        int r118 = r116 + r10.getDecoratedMeasurementInOther(r17);
        layoutChildWithMargin(r17, r116, this.mAreaRect.bottom - r10.getDecoratedMeasurement(r17), r118, this.mAreaRect.bottom, r26);
        int r119 = r118 + r10.getDecoratedMeasurementInOther(r115);
        layoutChildWithMargin(r115, r118, this.mAreaRect.bottom - r10.getDecoratedMeasurement(r115), r118 + r10.getDecoratedMeasurementInOther(r115), this.mAreaRect.bottom, r26);
        layoutChildWithMargin(r117, r119, this.mAreaRect.bottom - r10.getDecoratedMeasurement(r117), r119 + r10.getDecoratedMeasurementInOther(r117), this.mAreaRect.bottom, r26);
        Rect r47 = this.mAreaRect;
        int r48 = r47.bottom - r47.top;
        if (this.hasHeader == false) goto L55;
        int r49 = 0;
    L56:
        int r50 = r48 + r49;
        if (this.hasFooter == false) goto L59;
        int r51 = 0;
    L60:
        int r52 = r51 + r50;
    L62:
        handleStateOnResult(r25, new View[]{null, r12, r14, r17, r115, r117, null});
        return r52;
    L59:
        r51 = this.mMarginBottom + this.mPaddingBottom;
        goto L60
    L55:
        r49 = this.mMarginTop + this.mPaddingTop;
        goto L56
    L51:
        r41 = (((r40 - ((ViewGroup.MarginLayoutParams) r15).bottomMargin) - ((ViewGroup.MarginLayoutParams) r18).topMargin) * this.mRowWeight) / 100.0f;
        goto L50
    L46:
        r39 = (int) (((r35 * r32) / 100.0f) + 0.5f);
        goto L47
    L42:
        r38 = (int) (((r35 * r23) / 100.0f) + 0.5f);
        goto L44
    L38:
        r114 = (int) (((r35 * r113) / 100.0f) + 0.5f);
        goto L40
    L34:
        r37 = (int) (((r35 * r112) / 100.0f) + 0.5f);
        goto L36
    L30:
        r36 = (int) (((r35 * r22) / 100.0f) + 0.5f);
        goto L32
    L61:
        r115 = r110;
        r117 = r20;
        r52 = 0;
        goto L62
    L20:
        r20 = this.mChildrenViews[4];
        goto L21
    L16:
        r19 = this.mChildrenViews[3];
        goto L15
    L11:
        r16 = this.mChildrenViews[2];
        goto L10
    L6:
        r13 = this.mChildrenViews[1];
        goto L5
    }

    private int handleFooter(View r10, VirtualLayoutManager.LayoutStateWrapper r11, LayoutChunkResult r12, LayoutManagerHelper r13, boolean r14, int r15, int r16, int r17, int r18) {
        if (r10 != null) goto L5;
        return 0;
    L5:
        OrientationHelperEx r19 = r13.getMainOrientationHelper();
        ViewGroup.MarginLayoutParams r20 = new ViewGroup.MarginLayoutParams(r10.getLayoutParams());
        int r21 = r15 - r17;
        if (r14 == false) goto L8;
        int r22 = -1;
    L9:
        int r23 = r13.getChildMeasureSpec(r21, r22, !r14);
        int r24 = r16 - r18;
        if (r14 == false) goto L12;
        int r25 = r20.height;
    L13:
        r13.measureChildWithMargins(r10, r23, r13.getChildMeasureSpec(r24, r25, r14));
        return r19.getDecoratedMeasurement(r10);
    L12:
        r25 = Ints.MAX_POWER_OF_TWO;
        goto L13
    L8:
        r22 = r20.width;
        goto L9
    }

    private int handleFour(VirtualLayoutManager.LayoutStateWrapper r22, LayoutChunkResult r23, LayoutManagerHelper r24, boolean r25, int r26, int r27, int r28, int r29) {
        OrientationHelperEx r10 = r24.getMainOrientationHelper();
        View r11 = this.mChildrenViews[0];
        VirtualLayoutManager.LayoutParams r12 = new VirtualLayoutManager.LayoutParams((VirtualLayoutManager.LayoutParams) r11.getLayoutParams());
        if (r24.getReverseLayout() == false) goto L6;
        View r13 = this.mChildrenViews[3];
    L5:
        View r14 = r13;
        VirtualLayoutManager.LayoutParams r15 = new VirtualLayoutManager.LayoutParams((VirtualLayoutManager.LayoutParams) r14.getLayoutParams());
        View r16 = this.mChildrenViews[2];
        VirtualLayoutManager.LayoutParams r17 = new VirtualLayoutManager.LayoutParams((VirtualLayoutManager.LayoutParams) r16.getLayoutParams());
        if (r24.getReverseLayout() == false) goto L11;
        View r18 = this.mChildrenViews[1];
    L10:
        View r19 = r18;
        VirtualLayoutManager.LayoutParams r20 = new VirtualLayoutManager.LayoutParams((VirtualLayoutManager.LayoutParams) r19.getLayoutParams());
        float r110 = getViewMainWeight(r12, 0);
        float r111 = getViewMainWeight(r12, 1);
        float r21 = getViewMainWeight(r12, 2);
        float r30 = getViewMainWeight(r12, 3);
        if (r25 == false) goto L48;
        ((ViewGroup.MarginLayoutParams) r15).topMargin = ((ViewGroup.MarginLayoutParams) r12).topMargin;
        int r112 = ((ViewGroup.MarginLayoutParams) r12).bottomMargin;
        ((ViewGroup.MarginLayoutParams) r20).bottomMargin = r112;
        ((ViewGroup.MarginLayoutParams) r17).bottomMargin = r112;
        ((ViewGroup.MarginLayoutParams) r17).leftMargin = ((ViewGroup.MarginLayoutParams) r15).leftMargin;
        ((ViewGroup.MarginLayoutParams) r20).rightMargin = ((ViewGroup.MarginLayoutParams) r15).rightMargin;
        if (Float.isNaN(this.mAspectRatio) == true) goto L17;
        ((ViewGroup.MarginLayoutParams) r12).height = (int) ((r26 - r28) / this.mAspectRatio);
    L17:
        int r31 = ((((r26 - r28) - ((ViewGroup.MarginLayoutParams) r12).leftMargin) - ((ViewGroup.MarginLayoutParams) r12).rightMargin) - ((ViewGroup.MarginLayoutParams) r15).leftMargin) - ((ViewGroup.MarginLayoutParams) r15).rightMargin;
        if (Float.isNaN(r110) == false) goto L21;
        float r113 = r31 / 2.0f;
    L20:
        int r114 = (int) (r113 + 0.5f);
        if (Float.isNaN(r111) == false) goto L25;
        int r115 = r31 - r114;
    L27:
        if (Float.isNaN(r21) == false) goto L29;
        int r32 = (int) ((((r115 - ((ViewGroup.MarginLayoutParams) r17).rightMargin) - ((ViewGroup.MarginLayoutParams) r20).leftMargin) / 2.0f) + 0.5f);
    L31:
        if (Float.isNaN(r30) == false) goto L33;
        int r33 = ((r115 - ((ViewGroup.MarginLayoutParams) r17).rightMargin) - ((ViewGroup.MarginLayoutParams) r20).leftMargin) - r32;
    L34:
        r24.measureChildWithMargins(r11, View.MeasureSpec.makeMeasureSpec((r114 + ((ViewGroup.MarginLayoutParams) r12).leftMargin) + ((ViewGroup.MarginLayoutParams) r12).rightMargin, Ints.MAX_POWER_OF_TWO), r24.getChildMeasureSpec(r24.getContentHeight(), ((ViewGroup.MarginLayoutParams) r12).height, true));
        int r34 = r11.getMeasuredHeight();
        if (Float.isNaN(this.mRowWeight) == false) goto L38;
        float r35 = ((r34 - ((ViewGroup.MarginLayoutParams) r15).bottomMargin) - ((ViewGroup.MarginLayoutParams) r17).topMargin) / 2.0f;
    L37:
        int r36 = (int) (r35 + 0.5f);
        int r37 = ((r34 - ((ViewGroup.MarginLayoutParams) r15).bottomMargin) - ((ViewGroup.MarginLayoutParams) r17).topMargin) - r36;
        r24.measureChildWithMargins(r14, View.MeasureSpec.makeMeasureSpec((r115 + ((ViewGroup.MarginLayoutParams) r15).leftMargin) + ((ViewGroup.MarginLayoutParams) r15).rightMargin, Ints.MAX_POWER_OF_TWO), View.MeasureSpec.makeMeasureSpec((((ViewGroup.MarginLayoutParams) r15).topMargin + r36) + ((ViewGroup.MarginLayoutParams) r15).bottomMargin, Ints.MAX_POWER_OF_TWO));
        r24.measureChildWithMargins(r16, View.MeasureSpec.makeMeasureSpec((r32 + ((ViewGroup.MarginLayoutParams) r17).leftMargin) + ((ViewGroup.MarginLayoutParams) r17).rightMargin, Ints.MAX_POWER_OF_TWO), View.MeasureSpec.makeMeasureSpec((((ViewGroup.MarginLayoutParams) r17).topMargin + r37) + ((ViewGroup.MarginLayoutParams) r17).bottomMargin, Ints.MAX_POWER_OF_TWO));
        r24.measureChildWithMargins(r19, View.MeasureSpec.makeMeasureSpec((r33 + ((ViewGroup.MarginLayoutParams) r20).leftMargin) + ((ViewGroup.MarginLayoutParams) r20).rightMargin, Ints.MAX_POWER_OF_TWO), View.MeasureSpec.makeMeasureSpec((((ViewGroup.MarginLayoutParams) r20).topMargin + r37) + ((ViewGroup.MarginLayoutParams) r20).bottomMargin, Ints.MAX_POWER_OF_TWO));
        calculateRect(Math.max((r34 + ((ViewGroup.MarginLayoutParams) r12).topMargin) + ((ViewGroup.MarginLayoutParams) r12).bottomMargin, ((r36 + ((ViewGroup.MarginLayoutParams) r15).topMargin) + ((ViewGroup.MarginLayoutParams) r15).bottomMargin) + Math.max((((ViewGroup.MarginLayoutParams) r17).topMargin + r37) + ((ViewGroup.MarginLayoutParams) r17).bottomMargin, (r37 + ((ViewGroup.MarginLayoutParams) r20).topMargin) + ((ViewGroup.MarginLayoutParams) r20).bottomMargin)), this.mAreaRect, r22, r24);
        View r116 = r11;
        int r117 = this.mAreaRect.left + r10.getDecoratedMeasurementInOther(r116);
        Rect r38 = this.mAreaRect;
        layoutChildWithMargin(r116, r38.left, r38.top, r117, r38.bottom, r24);
        int r39 = r117 + r10.getDecoratedMeasurementInOther(r14);
        int r40 = this.mAreaRect.top;
        layoutChildWithMargin(r14, r117, r40, r39, r40 + r10.getDecoratedMeasurement(r14), r24);
        int r118 = r117 + r10.getDecoratedMeasurementInOther(r16);
        layoutChildWithMargin(r16, r117, this.mAreaRect.bottom - r10.getDecoratedMeasurement(r16), r118, this.mAreaRect.bottom, r24);
        layoutChildWithMargin(r19, r118, this.mAreaRect.bottom - r10.getDecoratedMeasurement(r19), r118 + r10.getDecoratedMeasurementInOther(r19), this.mAreaRect.bottom, r24);
        Rect r41 = this.mAreaRect;
        int r42 = r41.bottom - r41.top;
        if (this.hasHeader == false) goto L42;
        int r43 = 0;
    L43:
        int r44 = r42 + r43;
        if (this.hasFooter == false) goto L46;
        int r45 = 0;
    L47:
        int r46 = r45 + r44;
    L49:
        handleStateOnResult(r23, new View[]{null, r116, r14, r16, r19, null});
        return r46;
    L46:
        r45 = this.mMarginBottom + this.mPaddingBottom;
        goto L47
    L42:
        r43 = this.mMarginTop + this.mPaddingTop;
        goto L43
    L38:
        r35 = (((r34 - ((ViewGroup.MarginLayoutParams) r15).bottomMargin) - ((ViewGroup.MarginLayoutParams) r17).topMargin) * this.mRowWeight) / 100.0f;
        goto L37
    L33:
        r33 = (int) (((r31 * r30) / 100.0f) + 0.5f);
        goto L34
    L29:
        r32 = (int) (((r31 * r21) / 100.0f) + 0.5f);
        goto L31
    L25:
        r115 = (int) (((r31 * r111) / 100.0f) + 0.5f);
        goto L27
    L21:
        r113 = (r31 * r110) / 100.0f;
        goto L20
    L48:
        r116 = r11;
        r46 = 0;
        goto L49
    L11:
        r18 = this.mChildrenViews[3];
        goto L10
    L6:
        r13 = this.mChildrenViews[1];
        goto L5
    }

    private int handleHeader(View r10, VirtualLayoutManager.LayoutStateWrapper r11, LayoutChunkResult r12, LayoutManagerHelper r13, boolean r14, int r15, int r16, int r17, int r18) {
        if (r10 != null) goto L5;
        return 0;
    L5:
        OrientationHelperEx r19 = r13.getMainOrientationHelper();
        ViewGroup.MarginLayoutParams r20 = new ViewGroup.MarginLayoutParams(r10.getLayoutParams());
        int r21 = r15 - r17;
        if (r14 == false) goto L8;
        int r22 = -1;
    L9:
        int r23 = r13.getChildMeasureSpec(r21, r22, !r14);
        int r24 = r16 - r18;
        if (r14 == false) goto L12;
        int r25 = r20.height;
    L13:
        r13.measureChildWithMargins(r10, r23, r13.getChildMeasureSpec(r24, r25, r14));
        return r19.getDecoratedMeasurement(r10);
    L12:
        r25 = Ints.MAX_POWER_OF_TWO;
        goto L13
    L8:
        r22 = r20.width;
        goto L9
    }

    private int handleOne(VirtualLayoutManager.LayoutStateWrapper r11, LayoutChunkResult r12, LayoutManagerHelper r13, boolean r14, int r15, int r16, int r17, int r18) {
        OrientationHelperEx r10 = r13.getMainOrientationHelper();
        int r19 = 0;
        View r20 = this.mChildrenViews[0];
        ViewGroup.MarginLayoutParams r21 = new ViewGroup.MarginLayoutParams((ViewGroup.MarginLayoutParams) r20.getLayoutParams());
        if (Float.isNaN(this.mAspectRatio) == true) goto L7;
        if (r14 == false) goto L6;
        r21.height = (int) ((r15 - r17) / this.mAspectRatio);
        goto L7
    L6:
        r21.width = (int) ((r16 - r18) * this.mAspectRatio);
    L7:
        float r22 = getViewMainWeight(r21, 0);
        if (Float.isNaN(r22) == false) goto L10;
        int r23 = r15 - r17;
    L11:
        if (r14 == false) goto L13;
        int r24 = -1;
    L14:
        int r25 = r13.getChildMeasureSpec(r23, r24, !r14);
        int r26 = r16 - r18;
        if (r14 == false) goto L17;
        int r27 = r21.height;
    L18:
        r13.measureChildWithMargins(r20, r25, r13.getChildMeasureSpec(r26, r27, r14));
        calculateRect(r10.getDecoratedMeasurement(r20), this.mAreaRect, r11, r13);
        Rect r28 = this.mAreaRect;
        layoutChildWithMargin(r20, r28.left, r28.top, r28.right, r28.bottom, r13);
        handleStateOnResult(r12, new View[]{null, r20, null});
        Rect r29 = this.mAreaRect;
        int r30 = r29.bottom - r29.top;
        if (this.hasHeader == false) goto L21;
        int r31 = 0;
    L22:
        int r32 = r30 + r31;
        if (this.hasFooter == true) goto L27;
        r19 = this.mMarginBottom + this.mPaddingBottom;
    L27:
        return r32 + r19;
    L21:
        r31 = this.mMarginTop + this.mPaddingTop;
        goto L22
    L17:
        r27 = Ints.MAX_POWER_OF_TWO;
        goto L18
    L13:
        r24 = r21.width;
        goto L14
    L10:
        r23 = (int) ((r15 - r17) * r22);
        goto L11
    }

    private int handleThree(VirtualLayoutManager.LayoutStateWrapper r22, LayoutChunkResult r23, LayoutManagerHelper r24, boolean r25, int r26, int r27, int r28, int r29) {
        OrientationHelperEx r10 = r24.getMainOrientationHelper();
        View r11 = this.mChildrenViews[0];
        ViewGroup.MarginLayoutParams r12 = new ViewGroup.MarginLayoutParams((ViewGroup.MarginLayoutParams) r11.getLayoutParams());
        if (r24.getReverseLayout() == false) goto L6;
        View r13 = this.mChildrenViews[2];
    L5:
        View r14 = r13;
        if (r24.getReverseLayout() == false) goto L11;
        View r15 = this.mChildrenViews[1];
    L10:
        View r16 = r15;
        ViewGroup.MarginLayoutParams r17 = new ViewGroup.MarginLayoutParams((ViewGroup.MarginLayoutParams) r14.getLayoutParams());
        ViewGroup.MarginLayoutParams r18 = new ViewGroup.MarginLayoutParams((ViewGroup.MarginLayoutParams) r16.getLayoutParams());
        float r19 = getViewMainWeight(r12, 0);
        float r20 = getViewMainWeight(r12, 1);
        float r21 = getViewMainWeight(r12, 2);
        if (r25 == true) goto L15;
        View r110 = r11;
        int r30 = 0;
    L44:
        handleStateOnResult(r23, new View[]{null, r110, r14, r16, null});
        return r30;
    L15:
        if (Float.isNaN(this.mAspectRatio) == true) goto L17;
        r12.height = (int) ((r26 - r28) / this.mAspectRatio);
    L17:
        r17.topMargin = r12.topMargin;
        r18.bottomMargin = r12.bottomMargin;
        r18.leftMargin = r17.leftMargin;
        r18.rightMargin = r17.rightMargin;
        int r31 = ((((r26 - r28) - r12.leftMargin) - r12.rightMargin) - r17.leftMargin) - r17.rightMargin;
        if (Float.isNaN(r19) == false) goto L20;
        int r32 = (int) ((r31 / 2.0f) + 0.5f);
    L22:
        if (Float.isNaN(r20) == false) goto L24;
        int r33 = r31 - r32;
    L26:
        if (Float.isNaN(r21) == false) goto L28;
        int r34 = r33;
    L29:
        r110 = r11;
        r24.measureChildWithMargins(r110, View.MeasureSpec.makeMeasureSpec((r32 + r12.leftMargin) + r12.rightMargin, Ints.MAX_POWER_OF_TWO), r24.getChildMeasureSpec(r24.getContentHeight(), r12.height, true));
        int r35 = r110.getMeasuredHeight();
        if (Float.isNaN(this.mRowWeight) == false) goto L33;
        float r36 = ((r35 - r17.bottomMargin) - r18.topMargin) / 2.0f;
    L32:
        int r37 = (int) (r36 + 0.5f);
        int r111 = ((r35 - r17.bottomMargin) - r18.topMargin) - r37;
        r24.measureChildWithMargins(r14, View.MeasureSpec.makeMeasureSpec((r33 + r17.leftMargin) + r17.rightMargin, Ints.MAX_POWER_OF_TWO), View.MeasureSpec.makeMeasureSpec((r17.topMargin + r37) + r17.bottomMargin, Ints.MAX_POWER_OF_TWO));
        r24.measureChildWithMargins(r16, View.MeasureSpec.makeMeasureSpec((r34 + r18.leftMargin) + r18.rightMargin, Ints.MAX_POWER_OF_TWO), View.MeasureSpec.makeMeasureSpec((r18.topMargin + r111) + r18.bottomMargin, Ints.MAX_POWER_OF_TWO));
        calculateRect(Math.max((r35 + r12.topMargin) + r12.bottomMargin, ((((r37 + r17.topMargin) + r17.bottomMargin) + r111) + r18.topMargin) + r18.bottomMargin), this.mAreaRect, r22, r24);
        int r112 = this.mAreaRect.left + r10.getDecoratedMeasurementInOther(r110);
        Rect r38 = this.mAreaRect;
        layoutChildWithMargin(r110, r38.left, r38.top, r112, r38.bottom, r24);
        int r39 = r112 + r10.getDecoratedMeasurementInOther(r14);
        int r40 = this.mAreaRect.top;
        layoutChildWithMargin(r14, r112, r40, r39, ((r14.getMeasuredHeight() + r40) + r17.topMargin) + r17.bottomMargin, r24);
        layoutChildWithMargin(r16, r112, this.mAreaRect.bottom - r10.getDecoratedMeasurement(r16), r112 + r10.getDecoratedMeasurementInOther(r16), this.mAreaRect.bottom, r24);
        Rect r41 = this.mAreaRect;
        int r42 = r41.bottom - r41.top;
        if (this.hasHeader == false) goto L37;
        int r43 = 0;
    L38:
        int r44 = r42 + r43;
        if (this.hasFooter == false) goto L41;
        int r45 = 0;
    L42:
        r30 = r45 + r44;
        goto L44
    L41:
        r45 = this.mMarginBottom + this.mPaddingBottom;
        goto L42
    L37:
        r43 = this.mMarginTop + this.mPaddingTop;
        goto L38
    L33:
        r36 = (((r35 - r17.bottomMargin) - r18.topMargin) * this.mRowWeight) / 100.0f;
        goto L32
    L28:
        r34 = (int) (((double) ((r31 * r21) / 100.0f)) + 0.5d);
        goto L29
    L24:
        r33 = (int) (((double) ((r31 * r20) / 100.0f)) + 0.5d);
        goto L26
    L20:
        r32 = (int) (((r31 * r19) / 100.0f) + 0.5f);
        goto L22
    L11:
        r15 = this.mChildrenViews[2];
        goto L10
    L6:
        r13 = this.mChildrenViews[1];
        goto L5
    }

    private int handleTwo(VirtualLayoutManager.LayoutStateWrapper r17, LayoutChunkResult r18, LayoutManagerHelper r19, boolean r20, int r21, int r22, int r23, int r24) {
        OrientationHelperEx r10 = r19.getMainOrientationHelper();
        View r11 = this.mChildrenViews[0];
        ViewGroup.MarginLayoutParams r12 = new ViewGroup.MarginLayoutParams((ViewGroup.MarginLayoutParams) r11.getLayoutParams());
        View r13 = this.mChildrenViews[1];
        ViewGroup.MarginLayoutParams r14 = new ViewGroup.MarginLayoutParams((ViewGroup.MarginLayoutParams) r13.getLayoutParams());
        float r15 = getViewMainWeight(r12, 0);
        float r16 = getViewMainWeight(r12, 1);
        if (r20 == false) goto L26;
        if (Float.isNaN(this.mAspectRatio) == true) goto L7;
        int r25 = (int) ((r21 - r23) / this.mAspectRatio);
        r14.height = r25;
        r12.height = r25;
    L7:
        r14.topMargin = r12.topMargin;
        r14.bottomMargin = r12.bottomMargin;
        int r26 = ((((r21 - r23) - r12.leftMargin) - r12.rightMargin) - r14.leftMargin) - r14.rightMargin;
        if (Float.isNaN(r15) == false) goto L10;
        int r27 = (int) ((r26 / 2.0f) + 0.5f);
    L12:
        if (Float.isNaN(r16) == false) goto L14;
        int r28 = r26 - r27;
    L15:
        r19.measureChildWithMargins(r11, View.MeasureSpec.makeMeasureSpec((r27 + r12.leftMargin) + r12.rightMargin, Ints.MAX_POWER_OF_TWO), r19.getChildMeasureSpec(r19.getContentHeight(), r12.height, true));
        r19.measureChildWithMargins(r13, View.MeasureSpec.makeMeasureSpec((r28 + r14.leftMargin) + r14.rightMargin, Ints.MAX_POWER_OF_TWO), r19.getChildMeasureSpec(r19.getContentHeight(), r14.height, true));
        calculateRect(Math.max(r10.getDecoratedMeasurement(r11), r10.getDecoratedMeasurement(r13)), this.mAreaRect, r17, r19);
        int r110 = this.mAreaRect.left + r10.getDecoratedMeasurementInOther(r11);
        Rect r29 = this.mAreaRect;
        layoutChildWithMargin(r11, r29.left, r29.top, r110, r29.bottom, r19);
        layoutChildWithMargin(r13, r110, this.mAreaRect.top, r110 + r10.getDecoratedMeasurementInOther(r13), this.mAreaRect.bottom, r19);
        Rect r30 = this.mAreaRect;
        int r31 = r30.bottom - r30.top;
        if (this.hasHeader == false) goto L18;
        int r32 = 0;
    L19:
        int r33 = r31 + r32;
        if (this.hasFooter == false) goto L22;
    L21:
        int r111 = 0;
    L24:
        int r34 = r33 + r111;
        handleStateOnResult(r18, new View[]{null, r11, r13, null});
        return r34;
    L22:
        int r35 = this.mMarginBottom;
        int r36 = this.mPaddingBottom;
    L23:
        r111 = r35 + r36;
        goto L24
    L18:
        r32 = this.mMarginTop + this.mPaddingTop;
        goto L19
    L14:
        r28 = (int) (((r26 * r16) / 100.0f) + 0.5f);
        goto L15
    L10:
        r27 = (int) (((r26 * r15) / 100.0f) + 0.5f);
        goto L12
    L26:
        if (Float.isNaN(this.mAspectRatio) == true) goto L28;
        int r37 = (int) ((r22 - r24) * this.mAspectRatio);
        r14.width = r37;
        r12.width = r37;
    L28:
        int r38 = ((((r22 - r24) - r12.topMargin) - r12.bottomMargin) - r14.topMargin) - r14.bottomMargin;
        if (Float.isNaN(r15) == false) goto L31;
        int r39 = (int) ((r38 / 2.0f) + 0.5f);
    L33:
        if (Float.isNaN(r16) == false) goto L35;
        int r40 = r38 - r39;
    L36:
        r19.measureChildWithMargins(r11, r19.getChildMeasureSpec(r19.getContentWidth(), r12.width, true), View.MeasureSpec.makeMeasureSpec((r39 + r12.topMargin) + r12.bottomMargin, Ints.MAX_POWER_OF_TWO));
        r19.measureChildWithMargins(r13, View.MeasureSpec.makeMeasureSpec(r11.getMeasuredWidth(), Ints.MAX_POWER_OF_TWO), View.MeasureSpec.makeMeasureSpec((r40 + r14.topMargin) + r14.bottomMargin, Ints.MAX_POWER_OF_TWO));
        calculateRect(Math.max(r10.getDecoratedMeasurement(r11), r10.getDecoratedMeasurement(r13)), this.mAreaRect, r17, r19);
        int r112 = this.mAreaRect.top + r10.getDecoratedMeasurementInOther(r11);
        Rect r41 = this.mAreaRect;
        layoutChildWithMargin(r11, r41.left, r41.top, r41.right, r112, r19);
        Rect r42 = this.mAreaRect;
        layoutChildWithMargin(r13, r42.left, r112, r42.right, r112 + r10.getDecoratedMeasurementInOther(r13), r19);
        Rect r43 = this.mAreaRect;
        int r44 = r43.right - r43.left;
        if (this.hasHeader == false) goto L39;
        int r45 = 0;
    L40:
        r33 = r44 + r45;
        if (this.hasFooter == true) goto L21;
        r35 = this.mMarginRight;
        r36 = this.mPaddingRight;
        goto L23
    L39:
        r45 = this.mMarginLeft + this.mPaddingRight;
        goto L40
    L35:
        r40 = (int) (((r38 * r16) / 100.0f) + 0.5f);
        goto L36
    L31:
        r39 = (int) (((r38 * r15) / 100.0f) + 0.5f);
        goto L33
    }

    @Override // com.alibaba.android.vlayout.layout.AbstractFullFillLayoutHelper, com.alibaba.android.vlayout.LayoutHelper
    public void checkAnchorInfo(RecyclerView.State r10, VirtualLayoutManager.AnchorInfoWrapper r11, LayoutManagerHelper r12) {
        super.checkAnchorInfo(r10, r11, r12);
        this.mLayoutWithAnchor = true;
    }

    @Override // com.alibaba.android.vlayout.layout.AbstractFullFillLayoutHelper, com.alibaba.android.vlayout.layout.MarginLayoutHelper, com.alibaba.android.vlayout.LayoutHelper
    public int computeAlignOffset(int r10, boolean r11, boolean r12, LayoutManagerHelper r13) {
        if (r13.getOrientation() != 1) goto L5;
        boolean r14 = true;
    L6:
        if (r12 == false) goto L8;
        return 0;
    L8:
        if (r11 == true) goto L10;
        if (r10 != 0) goto L22;
        if (r14 == false) goto L20;
        int r15 = -this.mMarginTop;
        int r16 = this.mPaddingTop;
    L21:
        return r15 - r16;
    L20:
        r15 = -this.mMarginLeft;
        r16 = this.mPaddingLeft;
    L22:
        return 0;
    L10:
        if (r10 != (getItemCount() - 1)) goto L22;
        if (r14 == false) goto L14;
        int r17 = this.mMarginBottom;
        int r18 = this.mPaddingBottom;
    L15:
        return r17 + r18;
    L14:
        r17 = this.mMarginRight;
        r18 = this.mPaddingRight;
        goto L15
    L5:
        r14 = false;
        goto L6
    }

    @Override // com.alibaba.android.vlayout.layout.AbstractFullFillLayoutHelper, com.alibaba.android.vlayout.layout.BaseLayoutHelper
    public void layoutViews(RecyclerView.Recycler r20, RecyclerView.State r21, VirtualLayoutManager.LayoutStateWrapper r22, LayoutChunkResult r23, LayoutManagerHelper r24) {
        if (isOutOfRange(r22.getCurrentPosition()) == false) goto L5;
        return;
    L5:
        OrientationHelperEx r14 = r24.getMainOrientationHelper();
        if (r24.getOrientation() != 1) goto L8;
        boolean r16 = true;
    L10:
        if (r22.getLayoutDirection() != (-1)) goto L12;
        boolean r17 = true;
    L13:
        int r10 = r24.getContentWidth();
        int r11 = r24.getContentHeight();
        int r12 = ((r24.getPaddingLeft() + r24.getPaddingRight()) + getHorizontalMargin()) + getHorizontalPadding();
        int r18 = ((r24.getPaddingTop() + r24.getPaddingBottom()) + getVerticalMargin()) + getVerticalPadding();
        int r13 = r22.getCurrentPosition();
        if (this.hasHeader == false) goto L39;
        if (r13 != ((Integer) getRange().getLower()).intValue()) goto L39;
        View r15 = nextView(r20, r22, r24, r23);
        int r19 = handleHeader(r15, r22, r23, r24, r16, r10, r11, r12, r18);
        if (r15 == null) goto L37;
        if (r16 == false) goto L28;
        if (r17 == false) goto L22;
        int r25 = r22.getOffset();
        int r26 = r25 - r19;
    L27:
        int r27 = (r24.getPaddingLeft() + this.mMarginLeft) + this.mPaddingLeft;
        int r28 = r25;
        int r29 = r14.getDecoratedMeasurementInOther(r15) + r27;
        int r30 = r26;
    L36:
        layoutChildWithMargin(r15, r27, r30, r29, r28, r24);
        goto L37
    L22:
        int r31 = r22.getOffset();
        if (this.mLayoutWithAnchor == false) goto L25;
        int r32 = 0;
    L26:
        r26 = r32 + r31;
        r25 = r26 + r19;
        goto L27
    L25:
        r32 = this.mMarginTop + this.mPaddingTop;
        goto L26
    L28:
        if (r17 == false) goto L30;
        int r33 = r22.getOffset();
        int r34 = r33 - r19;
    L35:
        int r35 = (r24.getPaddingTop() + this.mMarginTop) + this.mPaddingTop;
        r29 = r33;
        r28 = r14.getDecoratedMeasurementInOther(r15) + r35;
        r30 = r35;
        r27 = r34;
        goto L36
    L30:
        int r36 = r22.getOffset();
        if (this.mLayoutWithAnchor == false) goto L33;
        int r37 = 0;
    L34:
        r34 = r37 + r36;
        r33 = r34 + r19;
        goto L35
    L33:
        r37 = this.mMarginLeft + this.mPaddingLeft;
    L37:
        r23.mConsumed = r19;
        handleStateOnResult(r23, r15);
        return;
    L39:
        if (this.hasFooter == true) goto L41;
    L63:
        int r110 = (getItemCount() - (this.hasHeader ? 1 : 0)) - (this.hasFooter ? 1 : 0);
        View[] r38 = this.mChildrenViews;
        if (r38 != null) goto L66;
    L67:
        this.mChildrenViews = new View[r110];
    L68:
        int r39 = getAllChildren(this.mChildrenViews, r20, r22, r23, r24);
        if (r39 == 0) goto L91;
        if (r39 < r110) goto L92;
        if (r110 != 1) goto L75;
        int r111 = handleOne(r22, r23, r24, r16, r10, r11, r12, r18);
    L87:
        r23.mConsumed = r111;
        Arrays.fill(this.mChildrenViews, null);
        return;
    L75:
        if (r110 != 2) goto L78;
        r111 = handleTwo(r22, r23, r24, r16, r10, r11, r12, r18);
        goto L87
    L78:
        if (r110 != 3) goto L81;
        r111 = handleThree(r22, r23, r24, r16, r10, r11, r12, r18);
        goto L87
    L81:
        if (r110 != 4) goto L84;
        r111 = handleFour(r22, r23, r24, r16, r10, r11, r12, r18);
        goto L87
    L84:
        if (r110 != 5) goto L86;
        r111 = handleFive(r22, r23, r24, r16, r10, r11, r12, r18);
        goto L87
    L86:
        r111 = 0;
        goto L87
    L92:
        return;
    L91:
        return;
    L66:
        if (r38.length == r110) goto L68;
    L41:
        if (r13 != ((Integer) getRange().getUpper()).intValue()) goto L63;
        View r112 = nextView(r20, r22, r24, r23);
        int r40 = handleFooter(r112, r22, r23, r24, r16, r10, r11, r12, r18);
        if (r112 == null) goto L62;
        if (r16 == false) goto L53;
        if (r17 == false) goto L51;
        int r41 = r22.getOffset();
        if (this.mLayoutWithAnchor == false) goto L49;
        int r42 = 0;
    L50:
        int r43 = r41 - r42;
        int r44 = r43 - r40;
    L52:
        int r45 = (r24.getPaddingLeft() + this.mMarginLeft) + this.mPaddingLeft;
        int r46 = r43;
        int r47 = r14.getDecoratedMeasurementInOther(r112) + r45;
        int r48 = r44;
    L61:
        layoutChildWithMargin(r112, r45, r48, r47, r46, r24);
        goto L62
    L49:
        r42 = this.mMarginBottom + this.mPaddingBottom;
        goto L50
    L51:
        r44 = r22.getOffset();
        r43 = r44 + r40;
        goto L52
    L53:
        if (r17 == false) goto L59;
        int r49 = r22.getOffset();
        if (this.mLayoutWithAnchor == false) goto L57;
        int r50 = 0;
    L58:
        int r51 = r49 - r50;
        int r52 = r51 - r40;
    L60:
        int r53 = (r24.getPaddingTop() + this.mMarginTop) + this.mPaddingTop;
        r47 = r51;
        r46 = r14.getDecoratedMeasurementInOther(r112) + r53;
        r48 = r53;
        r45 = r52;
        goto L61
    L57:
        r50 = this.mMarginRight + this.mPaddingRight;
        goto L58
    L59:
        r52 = r22.getOffset();
        r51 = r52 + r40;
    L62:
        r23.mConsumed = r40;
        handleStateOnResult(r23, r112);
        return;
    L12:
        r17 = false;
        goto L13
    L8:
        r16 = false;
        goto L10
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper
    public void onClear(LayoutManagerHelper r10) {
        super.onClear(r10);
    }

    @Override // com.alibaba.android.vlayout.LayoutHelper
    public void onRangeChange(int r10, int r11) {
        if ((r11 - r10) > 6) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("OnePlusNLayoutHelper only supports maximum 7 children now");
    }

    public void setColWeights(float[] r10) {
        if (r10 == null) goto L4;
        this.mColWeights = Arrays.copyOf(r10, r10.length);
        return;
    L4:
        this.mColWeights = new float[0];
    }

    public void setRowWeight(float r10) {
        this.mRowWeight = r10;
    }

    public OnePlusNLayoutHelper(int r10) {
        this(r10, 0, 0, 0, 0);
    }

    public OnePlusNLayoutHelper(int r10, int r11, int r12, int r13, int r14) {
        this.mAreaRect = new Rect();
        this.mColWeights = new float[0];
        this.mRowWeight = Float.NaN;
        setItemCount(r10);
    }
}
