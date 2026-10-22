package com.alibaba.android.vlayout.layout;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.vlayout.LayoutManagerHelper;
import com.alibaba.android.vlayout.OrientationHelperEx;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.google.common.primitives.Ints;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class OnePlusNLayoutHelperEx extends AbstractFullFillLayoutHelper {
    private static final String TAG = "OnePlusNLayoutHelper";
    private Rect mAreaRect;
    private View[] mChildrenViews;
    private float[] mColWeights;
    private float mRowWeight;

    public OnePlusNLayoutHelperEx() {
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

    private int handSeven(VirtualLayoutManager.LayoutStateWrapper r33, LayoutChunkResult r34, LayoutManagerHelper r35, boolean r36, int r37, int r38, int r39, int r40) {
        OrientationHelperEx r10 = r35.getMainOrientationHelper();
        View r11 = this.mChildrenViews[0];
        VirtualLayoutManager.LayoutParams r12 = new VirtualLayoutManager.LayoutParams((VirtualLayoutManager.LayoutParams) r11.getLayoutParams());
        if (r35.getReverseLayout() == false) goto L6;
        View r13 = this.mChildrenViews[6];
    L5:
        View r14 = r13;
        VirtualLayoutManager.LayoutParams r15 = new VirtualLayoutManager.LayoutParams((VirtualLayoutManager.LayoutParams) r14.getLayoutParams());
        if (r35.getReverseLayout() == false) goto L11;
        View r16 = this.mChildrenViews[5];
    L10:
        View r17 = r16;
        VirtualLayoutManager.LayoutParams r18 = new VirtualLayoutManager.LayoutParams((VirtualLayoutManager.LayoutParams) r17.getLayoutParams());
        if (r35.getReverseLayout() == false) goto L15;
        View r19 = this.mChildrenViews[4];
    L16:
        VirtualLayoutManager.LayoutParams r20 = new VirtualLayoutManager.LayoutParams((VirtualLayoutManager.LayoutParams) r19.getLayoutParams());
        if (r35.getReverseLayout() == false) goto L19;
        View r21 = this.mChildrenViews[3];
    L20:
        VirtualLayoutManager.LayoutParams r22 = new VirtualLayoutManager.LayoutParams((VirtualLayoutManager.LayoutParams) r21.getLayoutParams());
        if (r35.getReverseLayout() == false) goto L23;
        View r110 = this.mChildrenViews[2];
    L24:
        VirtualLayoutManager.LayoutParams r23 = new VirtualLayoutManager.LayoutParams((VirtualLayoutManager.LayoutParams) r110.getLayoutParams());
        if (r35.getReverseLayout() == false) goto L27;
        View r111 = this.mChildrenViews[1];
    L28:
        View r24 = r111;
        VirtualLayoutManager.LayoutParams r25 = new VirtualLayoutManager.LayoutParams((VirtualLayoutManager.LayoutParams) r111.getLayoutParams());
        float r26 = getViewMainWeight(r12, 0);
        float r27 = getViewMainWeight(r12, 1);
        float r28 = getViewMainWeight(r12, 2);
        float r112 = getViewMainWeight(r12, 3);
        float r29 = getViewMainWeight(r12, 4);
        View r113 = r110;
        float r114 = getViewMainWeight(r12, 5);
        float r30 = getViewMainWeight(r12, 6);
        if (r36 == false) goto L69;
        View r41 = r21;
        if (Float.isNaN(this.mAspectRatio) == true) goto L34;
        ((ViewGroup.MarginLayoutParams) r12).height = (int) ((r37 - r39) / this.mAspectRatio);
    L34:
        int r31 = ((((((r37 - r39) - ((ViewGroup.MarginLayoutParams) r12).leftMargin) - ((ViewGroup.MarginLayoutParams) r12).rightMargin) - ((ViewGroup.MarginLayoutParams) r15).leftMargin) - ((ViewGroup.MarginLayoutParams) r15).rightMargin) - ((ViewGroup.MarginLayoutParams) r18).leftMargin) - ((ViewGroup.MarginLayoutParams) r18).rightMargin;
        if (Float.isNaN(r26) == false) goto L38;
        float r32 = r31 / 3.0f;
    L37:
        int r42 = (int) (r32 + 0.5f);
        if (Float.isNaN(r27) == false) goto L42;
        int r210 = (r31 - r42) / 2;
    L44:
        if (Float.isNaN(r28) == false) goto L46;
        int r115 = r210;
    L48:
        if (Float.isNaN(r112) == false) goto L50;
        int r116 = r210;
    L52:
        if (Float.isNaN(r29) == false) goto L54;
        int r43 = r210;
    L56:
        if (Float.isNaN(r114) == false) goto L58;
        int r117 = r210;
    L60:
        if (Float.isNaN(r114) == false) goto L62;
        int r44 = r210;
    L63:
        r35.measureChildWithMargins(r11, View.MeasureSpec.makeMeasureSpec((r42 + ((ViewGroup.MarginLayoutParams) r12).leftMargin) + ((ViewGroup.MarginLayoutParams) r12).rightMargin, Ints.MAX_POWER_OF_TWO), r35.getChildMeasureSpec(r35.getContentHeight(), ((ViewGroup.MarginLayoutParams) r12).height, true));
        int r45 = r11.getMeasuredHeight();
        if (Float.isNaN(this.mRowWeight) == false) goto L67;
        float r46 = ((r45 - ((ViewGroup.MarginLayoutParams) r15).bottomMargin) - ((ViewGroup.MarginLayoutParams) r18).topMargin) / 3.0f;
    L66:
        int r47 = (int) (r46 + 0.5f);
        r35.measureChildWithMargins(r14, View.MeasureSpec.makeMeasureSpec((r210 + ((ViewGroup.MarginLayoutParams) r15).leftMargin) + ((ViewGroup.MarginLayoutParams) r15).rightMargin, Ints.MAX_POWER_OF_TWO), View.MeasureSpec.makeMeasureSpec((((ViewGroup.MarginLayoutParams) r15).topMargin + r47) + ((ViewGroup.MarginLayoutParams) r15).bottomMargin, Ints.MAX_POWER_OF_TWO));
        View r118 = r17;
        r35.measureChildWithMargins(r118, View.MeasureSpec.makeMeasureSpec((r115 + ((ViewGroup.MarginLayoutParams) r18).leftMargin) + ((ViewGroup.MarginLayoutParams) r18).rightMargin, Ints.MAX_POWER_OF_TWO), View.MeasureSpec.makeMeasureSpec((((ViewGroup.MarginLayoutParams) r18).topMargin + r47) + ((ViewGroup.MarginLayoutParams) r18).bottomMargin, Ints.MAX_POWER_OF_TWO));
        r35.measureChildWithMargins(r19, View.MeasureSpec.makeMeasureSpec((r116 + ((ViewGroup.MarginLayoutParams) r20).leftMargin) + ((ViewGroup.MarginLayoutParams) r20).rightMargin, Ints.MAX_POWER_OF_TWO), View.MeasureSpec.makeMeasureSpec((((ViewGroup.MarginLayoutParams) r20).topMargin + r47) + ((ViewGroup.MarginLayoutParams) r20).bottomMargin, Ints.MAX_POWER_OF_TWO));
        r35.measureChildWithMargins(r41, View.MeasureSpec.makeMeasureSpec((r43 + ((ViewGroup.MarginLayoutParams) r22).leftMargin) + ((ViewGroup.MarginLayoutParams) r22).rightMargin, Ints.MAX_POWER_OF_TWO), View.MeasureSpec.makeMeasureSpec((((ViewGroup.MarginLayoutParams) r22).topMargin + r47) + ((ViewGroup.MarginLayoutParams) r22).bottomMargin, Ints.MAX_POWER_OF_TWO));
        r35.measureChildWithMargins(r113, View.MeasureSpec.makeMeasureSpec((r117 + ((ViewGroup.MarginLayoutParams) r23).leftMargin) + ((ViewGroup.MarginLayoutParams) r23).rightMargin, Ints.MAX_POWER_OF_TWO), View.MeasureSpec.makeMeasureSpec((((ViewGroup.MarginLayoutParams) r23).topMargin + r47) + ((ViewGroup.MarginLayoutParams) r23).bottomMargin, Ints.MAX_POWER_OF_TWO));
        r35.measureChildWithMargins(r24, View.MeasureSpec.makeMeasureSpec((r44 + ((ViewGroup.MarginLayoutParams) r25).leftMargin) + ((ViewGroup.MarginLayoutParams) r25).rightMargin, Ints.MAX_POWER_OF_TWO), View.MeasureSpec.makeMeasureSpec((((ViewGroup.MarginLayoutParams) r25).topMargin + r47) + ((ViewGroup.MarginLayoutParams) r25).bottomMargin, Ints.MAX_POWER_OF_TWO));
        int r48 = (Math.max((r45 + ((ViewGroup.MarginLayoutParams) r12).topMargin) + ((ViewGroup.MarginLayoutParams) r12).bottomMargin, (Math.max((((ViewGroup.MarginLayoutParams) r15).topMargin + r47) + ((ViewGroup.MarginLayoutParams) r15).bottomMargin, (((ViewGroup.MarginLayoutParams) r18).topMargin + r47) + ((ViewGroup.MarginLayoutParams) r18).bottomMargin) + Math.max((((ViewGroup.MarginLayoutParams) r20).topMargin + r47) + ((ViewGroup.MarginLayoutParams) r20).bottomMargin, (((ViewGroup.MarginLayoutParams) r22).topMargin + r47) + ((ViewGroup.MarginLayoutParams) r22).bottomMargin)) + Math.max((((ViewGroup.MarginLayoutParams) r23).topMargin + r47) + ((ViewGroup.MarginLayoutParams) r23).bottomMargin, (r47 + ((ViewGroup.MarginLayoutParams) r25).topMargin) + ((ViewGroup.MarginLayoutParams) r25).bottomMargin)) + getVerticalMargin()) + getVerticalPadding();
        calculateRect((r48 - getVerticalMargin()) - getVerticalPadding(), this.mAreaRect, r33, r35);
        View r119 = r11;
        int r120 = this.mAreaRect.left + r10.getDecoratedMeasurementInOther(r119);
        Rect r49 = this.mAreaRect;
        View r50 = r41;
        layoutChildWithMargin(r119, r49.left, r49.top, r120, r49.bottom, r35);
        int r121 = r120 + r10.getDecoratedMeasurementInOther(r14);
        int r51 = this.mAreaRect.top;
        layoutChildWithMargin(r14, r120, r51, r121, r51 + r10.getDecoratedMeasurement(r14), r35);
        int r52 = r121 + r10.getDecoratedMeasurementInOther(r118);
        int r53 = this.mAreaRect.top;
        layoutChildWithMargin(r118, r121, r53, r52, r53 + r10.getDecoratedMeasurement(r118), r35);
        View r54 = r19;
        int r122 = r120 + r10.getDecoratedMeasurementInOther(r54);
        int r55 = this.mAreaRect.top + r10.getDecoratedMeasurement(r14);
        int r123 = this.mAreaRect.bottom - r10.getDecoratedMeasurement(r113);
        View r56 = r113;
        View r124 = r54;
        layoutChildWithMargin(r54, r120, r55, r122, r123, r35);
        layoutChildWithMargin(r50, r122, this.mAreaRect.top + r10.getDecoratedMeasurement(r14), r122 + r10.getDecoratedMeasurementInOther(r50), this.mAreaRect.bottom - r10.getDecoratedMeasurement(r24), r35);
        int r125 = r120 + r10.getDecoratedMeasurementInOther(r56);
        layoutChildWithMargin(r56, r120, this.mAreaRect.bottom - r10.getDecoratedMeasurement(r56), r125, this.mAreaRect.bottom, r35);
        layoutChildWithMargin(r24, r125, this.mAreaRect.bottom - r10.getDecoratedMeasurement(r24), r125 + r10.getDecoratedMeasurementInOther(r24), this.mAreaRect.bottom, r35);
        int r57 = r48;
    L70:
        handleStateOnResult(r34, new View[]{r119, r14, r118, r124, r50, r56});
        return r57;
    L67:
        r46 = (((r45 - ((ViewGroup.MarginLayoutParams) r15).bottomMargin) - ((ViewGroup.MarginLayoutParams) r18).topMargin) * this.mRowWeight) / 100.0f;
        goto L66
    L62:
        r44 = (int) (((r31 * r30) / 100.0f) + 0.5f);
        goto L63
    L58:
        r117 = (int) (((r31 * r114) / 100.0f) + 0.5f);
        goto L60
    L54:
        r43 = (int) (((r31 * r29) / 100.0f) + 0.5f);
        goto L56
    L50:
        r116 = (int) (((r31 * r112) / 100.0f) + 0.5f);
        goto L52
    L46:
        r115 = (int) (((double) ((r31 * r28) / 100.0f)) + 0.5d);
        goto L48
    L42:
        r210 = (int) (((r31 * r27) / 100.0f) + 0.5f);
        goto L44
    L38:
        r32 = (r31 * r26) / 100.0f;
        goto L37
    L69:
        r50 = r21;
        r119 = r11;
        r118 = r17;
        r56 = r113;
        r124 = r19;
        r57 = 0;
        goto L70
    L27:
        r111 = this.mChildrenViews[6];
        goto L28
    L23:
        r110 = this.mChildrenViews[5];
        goto L24
    L19:
        r21 = this.mChildrenViews[4];
        goto L20
    L15:
        r19 = this.mChildrenViews[3];
        goto L16
    L11:
        r16 = this.mChildrenViews[2];
        goto L10
    L6:
        r13 = this.mChildrenViews[1];
        goto L5
    }

    private int handSix(VirtualLayoutManager.LayoutStateWrapper r30, LayoutChunkResult r31, LayoutManagerHelper r32, boolean r33, int r34, int r35, int r36, int r37) {
        OrientationHelperEx r10 = r32.getMainOrientationHelper();
        View r11 = this.mChildrenViews[0];
        VirtualLayoutManager.LayoutParams r12 = new VirtualLayoutManager.LayoutParams((VirtualLayoutManager.LayoutParams) r11.getLayoutParams());
        if (r32.getReverseLayout() == false) goto L6;
        View r13 = this.mChildrenViews[5];
    L5:
        View r14 = r13;
        VirtualLayoutManager.LayoutParams r15 = new VirtualLayoutManager.LayoutParams((VirtualLayoutManager.LayoutParams) r14.getLayoutParams());
        if (r32.getReverseLayout() == false) goto L11;
        View r16 = this.mChildrenViews[4];
    L10:
        View r17 = r16;
        VirtualLayoutManager.LayoutParams r18 = new VirtualLayoutManager.LayoutParams((VirtualLayoutManager.LayoutParams) r17.getLayoutParams());
        if (r32.getReverseLayout() == false) goto L15;
        View r19 = this.mChildrenViews[3];
    L16:
        VirtualLayoutManager.LayoutParams r110 = new VirtualLayoutManager.LayoutParams((VirtualLayoutManager.LayoutParams) r19.getLayoutParams());
        if (r32.getReverseLayout() == false) goto L19;
        View r20 = this.mChildrenViews[2];
    L20:
        VirtualLayoutManager.LayoutParams r21 = new VirtualLayoutManager.LayoutParams((VirtualLayoutManager.LayoutParams) r20.getLayoutParams());
        if (r32.getReverseLayout() == false) goto L23;
        View r111 = this.mChildrenViews[1];
    L24:
        VirtualLayoutManager.LayoutParams r22 = new VirtualLayoutManager.LayoutParams((VirtualLayoutManager.LayoutParams) r111.getLayoutParams());
        float r112 = getViewMainWeight(r12, 0);
        float r113 = getViewMainWeight(r12, 1);
        float r23 = getViewMainWeight(r12, 2);
        float r24 = getViewMainWeight(r12, 3);
        float r25 = getViewMainWeight(r12, 4);
        View r114 = r111;
        float r115 = getViewMainWeight(r12, 5);
        if (r33 == false) goto L62;
        View r116 = r20;
        ((ViewGroup.MarginLayoutParams) r15).topMargin = ((ViewGroup.MarginLayoutParams) r12).topMargin;
        int r26 = ((ViewGroup.MarginLayoutParams) r12).bottomMargin;
        ((ViewGroup.MarginLayoutParams) r110).bottomMargin = r26;
        ((ViewGroup.MarginLayoutParams) r18).bottomMargin = r26;
        ((ViewGroup.MarginLayoutParams) r18).leftMargin = ((ViewGroup.MarginLayoutParams) r15).leftMargin;
        ((ViewGroup.MarginLayoutParams) r110).rightMargin = ((ViewGroup.MarginLayoutParams) r15).rightMargin;
        ((ViewGroup.MarginLayoutParams) r21).rightMargin = ((ViewGroup.MarginLayoutParams) r15).rightMargin;
        if (Float.isNaN(this.mAspectRatio) == true) goto L30;
        ((ViewGroup.MarginLayoutParams) r12).height = (int) ((r34 - r36) / this.mAspectRatio);
    L30:
        int r27 = r34 - r36;
        int r117 = (((r27 - ((ViewGroup.MarginLayoutParams) r12).leftMargin) - ((ViewGroup.MarginLayoutParams) r12).rightMargin) - ((ViewGroup.MarginLayoutParams) r15).leftMargin) - ((ViewGroup.MarginLayoutParams) r15).rightMargin;
        if (Float.isNaN(r112) == false) goto L34;
        float r118 = r117 / 2.0f;
    L33:
        int r119 = (int) (r118 + 0.5f);
        if (Float.isNaN(r113) == false) goto L38;
        int r120 = r117 - r119;
    L40:
        if (Float.isNaN(r23) == false) goto L42;
        int r38 = r120;
        int r121 = r38;
    L43:
        int r28 = (((((r27 - ((ViewGroup.MarginLayoutParams) r110).leftMargin) - ((ViewGroup.MarginLayoutParams) r110).rightMargin) - ((ViewGroup.MarginLayoutParams) r21).leftMargin) - ((ViewGroup.MarginLayoutParams) r21).rightMargin) - ((ViewGroup.MarginLayoutParams) r22).leftMargin) - ((ViewGroup.MarginLayoutParams) r22).rightMargin;
        if (Float.isNaN(r24) == false) goto L47;
        float r29 = r28 / 3.0f;
    L46:
        int r39 = (int) (r29 + 0.5f);
        if (Float.isNaN(r25) == false) goto L51;
        int r40 = r39;
    L53:
        if (Float.isNaN(r115) == false) goto L55;
        int r41 = r39;
    L56:
        r32.measureChildWithMargins(r11, View.MeasureSpec.makeMeasureSpec((r119 + ((ViewGroup.MarginLayoutParams) r12).leftMargin) + ((ViewGroup.MarginLayoutParams) r12).rightMargin, Ints.MAX_POWER_OF_TWO), r32.getChildMeasureSpec(r32.getContentHeight(), ((ViewGroup.MarginLayoutParams) r12).height, true));
        int r122 = r11.getMeasuredHeight();
        if (Float.isNaN(this.mRowWeight) == false) goto L60;
        float r123 = ((r122 - ((ViewGroup.MarginLayoutParams) r15).bottomMargin) - ((ViewGroup.MarginLayoutParams) r18).topMargin) / 2.0f;
    L59:
        int r124 = (int) (r123 + 0.5f);
        int r125 = ((r122 - ((ViewGroup.MarginLayoutParams) r15).bottomMargin) - ((ViewGroup.MarginLayoutParams) r18).topMargin) - r124;
        int r126 = View.MeasureSpec.makeMeasureSpec((r38 + ((ViewGroup.MarginLayoutParams) r15).leftMargin) + ((ViewGroup.MarginLayoutParams) r15).rightMargin, Ints.MAX_POWER_OF_TWO);
        int r42 = View.MeasureSpec.makeMeasureSpec((((ViewGroup.MarginLayoutParams) r15).topMargin + r124) + ((ViewGroup.MarginLayoutParams) r15).bottomMargin, Ints.MAX_POWER_OF_TWO);
        View r127 = r14;
        r32.measureChildWithMargins(r127, r126, r42);
        r17 = r17;
        r32.measureChildWithMargins(r17, View.MeasureSpec.makeMeasureSpec((r121 + ((ViewGroup.MarginLayoutParams) r18).leftMargin) + ((ViewGroup.MarginLayoutParams) r18).rightMargin, Ints.MAX_POWER_OF_TWO), View.MeasureSpec.makeMeasureSpec((((ViewGroup.MarginLayoutParams) r18).topMargin + r125) + ((ViewGroup.MarginLayoutParams) r18).bottomMargin, Ints.MAX_POWER_OF_TWO));
        View r128 = r19;
        r32.measureChildWithMargins(r128, View.MeasureSpec.makeMeasureSpec((r39 + ((ViewGroup.MarginLayoutParams) r110).leftMargin) + ((ViewGroup.MarginLayoutParams) r110).rightMargin, Ints.MAX_POWER_OF_TWO), View.MeasureSpec.makeMeasureSpec((((ViewGroup.MarginLayoutParams) r110).topMargin + r125) + ((ViewGroup.MarginLayoutParams) r110).bottomMargin, Ints.MAX_POWER_OF_TWO));
        r32.measureChildWithMargins(r116, View.MeasureSpec.makeMeasureSpec((r40 + ((ViewGroup.MarginLayoutParams) r21).leftMargin) + ((ViewGroup.MarginLayoutParams) r21).rightMargin, Ints.MAX_POWER_OF_TWO), View.MeasureSpec.makeMeasureSpec((((ViewGroup.MarginLayoutParams) r21).topMargin + r125) + ((ViewGroup.MarginLayoutParams) r21).bottomMargin, Ints.MAX_POWER_OF_TWO));
        View r43 = r114;
        r32.measureChildWithMargins(r43, View.MeasureSpec.makeMeasureSpec((r41 + ((ViewGroup.MarginLayoutParams) r22).leftMargin) + ((ViewGroup.MarginLayoutParams) r22).rightMargin, Ints.MAX_POWER_OF_TWO), View.MeasureSpec.makeMeasureSpec((((ViewGroup.MarginLayoutParams) r22).topMargin + r125) + ((ViewGroup.MarginLayoutParams) r22).bottomMargin, Ints.MAX_POWER_OF_TWO));
        int r44 = ((Math.max((r122 + ((ViewGroup.MarginLayoutParams) r12).topMargin) + ((ViewGroup.MarginLayoutParams) r12).bottomMargin, ((r124 + ((ViewGroup.MarginLayoutParams) r15).topMargin) + ((ViewGroup.MarginLayoutParams) r15).bottomMargin) * 2) + Math.max((((ViewGroup.MarginLayoutParams) r110).topMargin + r125) + ((ViewGroup.MarginLayoutParams) r110).bottomMargin, Math.max((((ViewGroup.MarginLayoutParams) r21).topMargin + r125) + ((ViewGroup.MarginLayoutParams) r21).bottomMargin, (r125 + ((ViewGroup.MarginLayoutParams) r22).topMargin) + ((ViewGroup.MarginLayoutParams) r22).bottomMargin))) + getVerticalMargin()) + getVerticalPadding();
        OnePlusNLayoutHelperEx r129 = this;
        r129.calculateRect((r44 - getVerticalMargin()) - getVerticalPadding(), r129.mAreaRect, r30, r32);
        View r130 = r11;
        int r131 = r129.mAreaRect.left + r10.getDecoratedMeasurementInOther(r130);
        Rect r45 = r129.mAreaRect;
        View r46 = r116;
        layoutChildWithMargin(r130, r45.left, r45.top, r131, r45.bottom - r10.getDecoratedMeasurement(r128), r32);
        int r47 = r131 + r10.getDecoratedMeasurementInOther(r127);
        int r48 = r129.mAreaRect.top;
        layoutChildWithMargin(r127, r131, r48, r47, r48 + r10.getDecoratedMeasurement(r127), r32);
        layoutChildWithMargin(r17, r131, r129.mAreaRect.top + r10.getDecoratedMeasurement(r17), r131 + r10.getDecoratedMeasurementInOther(r17), r129.mAreaRect.bottom - r10.getDecoratedMeasurement(r128), r32);
        int r132 = r129.mAreaRect.left + r10.getDecoratedMeasurementInOther(r128);
        Rect r49 = r129.mAreaRect;
        layoutChildWithMargin(r128, r49.left, r49.bottom - r10.getDecoratedMeasurement(r128), r132, r129.mAreaRect.bottom, r32);
        int r133 = r132 + r10.getDecoratedMeasurementInOther(r46);
        layoutChildWithMargin(r46, r132, r129.mAreaRect.bottom - r10.getDecoratedMeasurement(r46), r133, r129.mAreaRect.bottom, r32);
        layoutChildWithMargin(r43, r133, r129.mAreaRect.bottom - r10.getDecoratedMeasurement(r43), r133 + r10.getDecoratedMeasurementInOther(r43), r129.mAreaRect.bottom, r32);
        int r50 = r44;
    L63:
        r129.handleStateOnResult(r31, new View[]{r130, r127, r17, r128, r46, r43});
        return r50;
    L60:
        r123 = (((r122 - ((ViewGroup.MarginLayoutParams) r15).bottomMargin) - ((ViewGroup.MarginLayoutParams) r18).topMargin) * this.mRowWeight) / 100.0f;
        goto L59
    L55:
        r41 = (int) (((r117 * r115) / 100.0f) + 0.5f);
        goto L56
    L51:
        r40 = (int) (((r117 * r25) / 100.0f) + 0.5f);
        goto L53
    L47:
        r29 = (r117 * r24) / 100.0f;
        goto L46
    L42:
        r38 = r120;
        r121 = (int) (((double) ((r117 * r23) / 100.0f)) + 0.5d);
        goto L43
    L38:
        r120 = (int) (((r117 * r113) / 100.0f) + 0.5f);
        goto L40
    L34:
        r118 = (r117 * r112) / 100.0f;
        goto L33
    L62:
        r46 = r20;
        r130 = r11;
        r127 = r14;
        r128 = r19;
        r129 = this;
        r43 = r114;
        r50 = 0;
        goto L63
    L23:
        r111 = this.mChildrenViews[5];
        goto L24
    L19:
        r20 = this.mChildrenViews[4];
        goto L20
    L15:
        r19 = this.mChildrenViews[3];
        goto L16
    L11:
        r16 = this.mChildrenViews[2];
        goto L10
    L6:
        r13 = this.mChildrenViews[1];
        goto L5
    }

    private int handleFive(VirtualLayoutManager.LayoutStateWrapper r23, LayoutChunkResult r24, LayoutManagerHelper r25, boolean r26, int r27, int r28, int r29, int r30) {
        OrientationHelperEx r10 = r25.getMainOrientationHelper();
        View r11 = this.mChildrenViews[0];
        VirtualLayoutManager.LayoutParams r12 = new VirtualLayoutManager.LayoutParams((VirtualLayoutManager.LayoutParams) r11.getLayoutParams());
        if (r25.getReverseLayout() == false) goto L6;
        View r13 = this.mChildrenViews[4];
    L5:
        View r14 = r13;
        VirtualLayoutManager.LayoutParams r15 = new VirtualLayoutManager.LayoutParams((VirtualLayoutManager.LayoutParams) r14.getLayoutParams());
        if (r25.getReverseLayout() == false) goto L11;
        View r16 = this.mChildrenViews[3];
    L10:
        View r17 = r16;
        VirtualLayoutManager.LayoutParams r18 = new VirtualLayoutManager.LayoutParams((VirtualLayoutManager.LayoutParams) r17.getLayoutParams());
        if (r25.getReverseLayout() == false) goto L15;
        View r19 = this.mChildrenViews[2];
    L16:
        VirtualLayoutManager.LayoutParams r110 = new VirtualLayoutManager.LayoutParams((VirtualLayoutManager.LayoutParams) r19.getLayoutParams());
        if (r25.getReverseLayout() == false) goto L19;
        View r20 = this.mChildrenViews[1];
    L20:
        VirtualLayoutManager.LayoutParams r21 = new VirtualLayoutManager.LayoutParams((VirtualLayoutManager.LayoutParams) r20.getLayoutParams());
        float r111 = getViewMainWeight(r12, 0);
        float r112 = getViewMainWeight(r12, 1);
        float r113 = getViewMainWeight(r12, 2);
        float r22 = getViewMainWeight(r12, 3);
        float r31 = getViewMainWeight(r12, 4);
        if (r26 == false) goto L53;
        ((ViewGroup.MarginLayoutParams) r15).topMargin = ((ViewGroup.MarginLayoutParams) r12).topMargin;
        int r32 = ((ViewGroup.MarginLayoutParams) r12).bottomMargin;
        ((ViewGroup.MarginLayoutParams) r110).bottomMargin = r32;
        ((ViewGroup.MarginLayoutParams) r18).bottomMargin = r32;
        ((ViewGroup.MarginLayoutParams) r18).leftMargin = ((ViewGroup.MarginLayoutParams) r15).leftMargin;
        ((ViewGroup.MarginLayoutParams) r110).rightMargin = ((ViewGroup.MarginLayoutParams) r15).rightMargin;
        ((ViewGroup.MarginLayoutParams) r21).rightMargin = ((ViewGroup.MarginLayoutParams) r18).rightMargin;
        if (Float.isNaN(this.mAspectRatio) == true) goto L26;
        ((ViewGroup.MarginLayoutParams) r12).height = (int) ((r27 - r29) / this.mAspectRatio);
    L26:
        int r33 = ((((((r27 - r29) - ((ViewGroup.MarginLayoutParams) r12).leftMargin) - ((ViewGroup.MarginLayoutParams) r12).rightMargin) - ((ViewGroup.MarginLayoutParams) r15).leftMargin) - ((ViewGroup.MarginLayoutParams) r15).rightMargin) - ((ViewGroup.MarginLayoutParams) r18).leftMargin) - ((ViewGroup.MarginLayoutParams) r18).rightMargin;
        if (Float.isNaN(r111) == false) goto L30;
        float r34 = r33 / 3.0f;
    L29:
        int r35 = (int) (r34 + 0.5f);
        if (Float.isNaN(r112) == false) goto L34;
        int r114 = (r33 - r35) / 2;
    L36:
        if (Float.isNaN(r113) == false) goto L38;
        int r36 = r114;
    L40:
        if (Float.isNaN(r22) == false) goto L42;
        int r37 = r114;
    L44:
        if (Float.isNaN(r31) == false) goto L46;
        int r38 = r114;
    L47:
        r25.measureChildWithMargins(r11, View.MeasureSpec.makeMeasureSpec((r35 + ((ViewGroup.MarginLayoutParams) r12).leftMargin) + ((ViewGroup.MarginLayoutParams) r12).rightMargin, Ints.MAX_POWER_OF_TWO), r25.getChildMeasureSpec(r25.getContentHeight(), ((ViewGroup.MarginLayoutParams) r12).height, true));
        int r39 = r11.getMeasuredHeight();
        if (Float.isNaN(this.mRowWeight) == false) goto L51;
        float r40 = ((r39 - ((ViewGroup.MarginLayoutParams) r15).bottomMargin) - ((ViewGroup.MarginLayoutParams) r18).topMargin) / 2.0f;
    L50:
        int r41 = (int) (r40 + 0.5f);
        int r42 = ((r39 - ((ViewGroup.MarginLayoutParams) r15).bottomMargin) - ((ViewGroup.MarginLayoutParams) r18).topMargin) - r41;
        r25.measureChildWithMargins(r14, View.MeasureSpec.makeMeasureSpec((r114 + ((ViewGroup.MarginLayoutParams) r15).leftMargin) + ((ViewGroup.MarginLayoutParams) r15).rightMargin, Ints.MAX_POWER_OF_TWO), View.MeasureSpec.makeMeasureSpec((((ViewGroup.MarginLayoutParams) r15).topMargin + r41) + ((ViewGroup.MarginLayoutParams) r15).bottomMargin, Ints.MAX_POWER_OF_TWO));
        r25.measureChildWithMargins(r17, View.MeasureSpec.makeMeasureSpec((r36 + ((ViewGroup.MarginLayoutParams) r18).leftMargin) + ((ViewGroup.MarginLayoutParams) r18).rightMargin, Ints.MAX_POWER_OF_TWO), View.MeasureSpec.makeMeasureSpec((((ViewGroup.MarginLayoutParams) r18).topMargin + r42) + ((ViewGroup.MarginLayoutParams) r18).bottomMargin, Ints.MAX_POWER_OF_TWO));
        r19 = r19;
        r25.measureChildWithMargins(r19, View.MeasureSpec.makeMeasureSpec((r37 + ((ViewGroup.MarginLayoutParams) r110).leftMargin) + ((ViewGroup.MarginLayoutParams) r110).rightMargin, Ints.MAX_POWER_OF_TWO), View.MeasureSpec.makeMeasureSpec((((ViewGroup.MarginLayoutParams) r110).topMargin + r42) + ((ViewGroup.MarginLayoutParams) r110).bottomMargin, Ints.MAX_POWER_OF_TWO));
        View r115 = r20;
        r25.measureChildWithMargins(r115, View.MeasureSpec.makeMeasureSpec((r38 + ((ViewGroup.MarginLayoutParams) r21).leftMargin) + ((ViewGroup.MarginLayoutParams) r21).rightMargin, Ints.MAX_POWER_OF_TWO), View.MeasureSpec.makeMeasureSpec((((ViewGroup.MarginLayoutParams) r21).topMargin + r42) + ((ViewGroup.MarginLayoutParams) r21).bottomMargin, Ints.MAX_POWER_OF_TWO));
        int r43 = (Math.max((r39 + ((ViewGroup.MarginLayoutParams) r12).topMargin) + ((ViewGroup.MarginLayoutParams) r12).bottomMargin, ((r41 + ((ViewGroup.MarginLayoutParams) r15).topMargin) + ((ViewGroup.MarginLayoutParams) r15).bottomMargin) + Math.max((((ViewGroup.MarginLayoutParams) r18).topMargin + r42) + ((ViewGroup.MarginLayoutParams) r18).bottomMargin, (r42 + ((ViewGroup.MarginLayoutParams) r110).topMargin) + ((ViewGroup.MarginLayoutParams) r110).bottomMargin)) + getVerticalMargin()) + getVerticalPadding();
        calculateRect((r43 - getVerticalMargin()) - getVerticalPadding(), this.mAreaRect, r23, r25);
        View r116 = r11;
        int r117 = this.mAreaRect.left + r10.getDecoratedMeasurementInOther(r116);
        Rect r44 = this.mAreaRect;
        layoutChildWithMargin(r116, r44.left, r44.top, r117, r44.bottom, r25);
        int r118 = r117 + r10.getDecoratedMeasurementInOther(r14);
        int r45 = this.mAreaRect.top;
        layoutChildWithMargin(r14, r117, r45, r118, r45 + r10.getDecoratedMeasurement(r14), r25);
        int r46 = r118 + r10.getDecoratedMeasurementInOther(r17);
        int r47 = this.mAreaRect.top;
        layoutChildWithMargin(r17, r118, r47, r46, r47 + r10.getDecoratedMeasurement(r17), r25);
        int r119 = r117 + r10.getDecoratedMeasurementInOther(r19);
        layoutChildWithMargin(r19, r117, this.mAreaRect.bottom - r10.getDecoratedMeasurement(r19), r119, this.mAreaRect.bottom, r25);
        layoutChildWithMargin(r115, r119, this.mAreaRect.bottom - r10.getDecoratedMeasurement(r115), r119 + r10.getDecoratedMeasurementInOther(r115), this.mAreaRect.bottom, r25);
        int r48 = r43;
    L54:
        handleStateOnResult(r24, new View[]{r116, r14, r17, r19, r115});
        return r48;
    L51:
        r40 = (((r39 - ((ViewGroup.MarginLayoutParams) r15).bottomMargin) - ((ViewGroup.MarginLayoutParams) r18).topMargin) * this.mRowWeight) / 100.0f;
        goto L50
    L46:
        r38 = (int) (((r33 * r31) / 100.0f) + 0.5f);
        goto L47
    L42:
        r37 = (int) (((r33 * r22) / 100.0f) + 0.5f);
        goto L44
    L38:
        r36 = (int) (((r33 * r113) / 100.0f) + 0.5f);
        goto L40
    L34:
        r114 = (int) (((r33 * r112) / 100.0f) + 0.5f);
        goto L36
    L30:
        r34 = (r33 * r111) / 100.0f;
        goto L29
    L53:
        r116 = r11;
        r115 = r20;
        r48 = 0;
        goto L54
    L19:
        r20 = this.mChildrenViews[4];
        goto L20
    L15:
        r19 = this.mChildrenViews[3];
        goto L16
    L11:
        r16 = this.mChildrenViews[2];
        goto L10
    L6:
        r13 = this.mChildrenViews[1];
        goto L5
    }

    @Override // com.alibaba.android.vlayout.layout.AbstractFullFillLayoutHelper, com.alibaba.android.vlayout.layout.MarginLayoutHelper, com.alibaba.android.vlayout.LayoutHelper
    public int computeAlignOffset(int r10, boolean r11, boolean r12, LayoutManagerHelper r13) {
        if (getItemCount() != 3) goto L9;
        if (r10 != 1) goto L14;
        if (r11 == false) goto L14;
        Log.w(TAG, "Should not happen after adjust anchor");
        return 0;
    L14:
        if (r13.getOrientation() != 1) goto L20;
        if (r11 == false) goto L19;
        return this.mMarginBottom + this.mPaddingBottom;
    L19:
        return (-this.mMarginTop) - this.mPaddingTop;
    L20:
        if (r11 == false) goto L24;
        return this.mMarginRight + this.mPaddingRight;
    L24:
        return (-this.mMarginLeft) - this.mPaddingLeft;
    L9:
        if (getItemCount() != 4) goto L14;
        if (r10 != 1) goto L14;
        if (r11 == false) goto L14;
        return 0;
    }

    @Override // com.alibaba.android.vlayout.layout.AbstractFullFillLayoutHelper, com.alibaba.android.vlayout.layout.BaseLayoutHelper
    public void layoutViews(RecyclerView.Recycler r10, RecyclerView.State r11, VirtualLayoutManager.LayoutStateWrapper r12, LayoutChunkResult r13, LayoutManagerHelper r14) {
        if (isOutOfRange(r12.getCurrentPosition()) == false) goto L5;
        return;
    L5:
        View[] r15 = this.mChildrenViews;
        if (r15 != null) goto L8;
    L9:
        this.mChildrenViews = new View[getItemCount()];
    L10:
        int r16 = getAllChildren(this.mChildrenViews, r10, r12, r13, r14);
        if (r16 == getItemCount()) goto L13;
        Log.w(TAG, "The real number of children is not match with range of LayoutHelper");
    L13:
        int r17 = 0;
        if (r14.getOrientation() != 1) goto L16;
        boolean r18 = true;
    L17:
        int r19 = r14.getContentWidth();
        int r20 = r14.getContentHeight();
        int r21 = ((r14.getPaddingLeft() + r14.getPaddingRight()) + getHorizontalMargin()) + getHorizontalPadding();
        int r22 = ((r14.getPaddingTop() + r14.getPaddingBottom()) + getVerticalMargin()) + getVerticalPadding();
        if (r16 != 5) goto L21;
        r17 = handleFive(r12, r13, r14, r18, r19, r20, r21, r22);
    L26:
        r13.mConsumed = r17;
        Arrays.fill(this.mChildrenViews, null);
        return;
    L21:
        if (r16 != 6) goto L24;
        r17 = handSix(r12, r13, r14, r18, r19, r20, r21, r22);
        goto L26
    L24:
        if (r16 != 7) goto L26;
        r17 = handSeven(r12, r13, r14, r18, r19, r20, r21, r22);
        goto L26
    L16:
        r18 = false;
        goto L17
    L8:
        if (r15.length == getItemCount()) goto L10;
        goto L9
    }

    @Override // com.alibaba.android.vlayout.LayoutHelper
    public void onRangeChange(int r10, int r11) {
        int r12 = r11 - r10;
        if (r12 < 4) goto L10;
        if (r12 > 6) goto L8;
        return;
    L8:
        throw new IllegalArgumentException("OnePlusNLayoutHelper only supports maximum 7 children now");
    L10:
        throw new IllegalArgumentException("pls use OnePlusNLayoutHelper instead of OnePlusNLayoutHelperEx which childcount <= 5");
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

    public OnePlusNLayoutHelperEx(int r10) {
        this(r10, 0, 0, 0, 0);
    }

    public OnePlusNLayoutHelperEx(int r10, int r11, int r12, int r13, int r14) {
        this.mAreaRect = new Rect();
        this.mColWeights = new float[0];
        this.mRowWeight = Float.NaN;
        setItemCount(r10);
    }
}
