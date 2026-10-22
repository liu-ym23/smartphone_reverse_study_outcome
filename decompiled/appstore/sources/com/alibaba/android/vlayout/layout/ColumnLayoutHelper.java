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
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: loaded from: classes.dex */
public class ColumnLayoutHelper extends AbstractFullFillLayoutHelper {
    private View[] mEqViews;
    private Rect mTempArea;
    private View[] mViews;
    private float[] mWeights;

    public ColumnLayoutHelper() {
        this.mTempArea = new Rect();
        this.mWeights = new float[0];
    }

    @Override // com.alibaba.android.vlayout.layout.AbstractFullFillLayoutHelper, com.alibaba.android.vlayout.LayoutHelper
    public void checkAnchorInfo(RecyclerView.State r10, VirtualLayoutManager.AnchorInfoWrapper r11, LayoutManagerHelper r12) {
        if (r11.layoutFromEnd == false) goto L5;
        r11.position = ((Integer) getRange().getUpper()).intValue();
        return;
    L5:
        r11.position = ((Integer) getRange().getLower()).intValue();
    }

    @Override // com.alibaba.android.vlayout.layout.AbstractFullFillLayoutHelper, com.alibaba.android.vlayout.layout.BaseLayoutHelper
    public void layoutViews(RecyclerView.Recycler r20, RecyclerView.State r21, VirtualLayoutManager.LayoutStateWrapper r22, LayoutChunkResult r23, LayoutManagerHelper r24) {
        if (isOutOfRange(r22.getCurrentPosition()) == false) goto L5;
        return;
    L5:
        boolean r10 = true;
        if (r24.getOrientation() != 1) goto L8;
        boolean r11 = true;
    L9:
        OrientationHelperEx r12 = r24.getMainOrientationHelper();
        int r13 = getItemCount();
        View[] r14 = this.mViews;
        if (r14 != null) goto L12;
    L13:
        this.mViews = new View[r13];
    L14:
        View[] r15 = this.mEqViews;
        if (r15 != null) goto L17;
    L20:
        this.mEqViews = new View[r13];
    L21:
        int r16 = getAllChildren(this.mViews, r20, r22, r23, r24);
        if (r11 == false) goto L80;
        int r17 = 0;
        int r18 = 0;
        int r19 = 0;
        int r25 = 0;
    L24:
        if (r17 >= r16) goto L33;
        ViewGroup.LayoutParams r26 = this.mViews[r17].getLayoutParams();
        if ((r26 instanceof RecyclerView.LayoutParams) == false) goto L32;
        RecyclerView.LayoutParams r27 = (RecyclerView.LayoutParams) r26;
        int r28 = Math.max(r19, ((ViewGroup.MarginLayoutParams) r27).leftMargin);
        ((ViewGroup.MarginLayoutParams) r27).leftMargin = r28;
        r18 = r18 + r28;
        if (r17 == (r16 - 1)) goto L30;
        r19 = ((ViewGroup.MarginLayoutParams) r27).rightMargin;
        ((ViewGroup.MarginLayoutParams) r27).rightMargin = 0;
    L31:
        r25 = Math.max(r25, ((ViewGroup.MarginLayoutParams) r27).topMargin + ((ViewGroup.MarginLayoutParams) r27).bottomMargin);
        goto L32
    L30:
        r18 = r18 + ((ViewGroup.MarginLayoutParams) r27).rightMargin;
    L32:
        r17 = r17 + 1;
        goto L24
    L33:
        int r29 = (((r24.getContentWidth() - r24.getPaddingLeft()) - r24.getPaddingRight()) - getHorizontalMargin()) - getHorizontalPadding();
        int r30 = r29 - r18;
        if (Float.isNaN(this.mAspectRatio) == true) goto L36;
        int r31 = (int) ((r29 / this.mAspectRatio) + 0.5f);
    L37:
        int r32 = Channel.UNLIMITED;
        int r33 = 0;
        int r110 = 0;
        int r111 = 0;
    L38:
        if (r33 >= r16) goto L58;
        View r112 = this.mViews[r33];
        VirtualLayoutManager.LayoutParams r34 = (VirtualLayoutManager.LayoutParams) r112.getLayoutParams();
        int r35 = (r24.getContentHeight() - r24.getPaddingTop()) - r24.getPaddingBottom();
        if (r31 <= 0) goto L42;
        int r113 = r31;
    L43:
        int r36 = r24.getChildMeasureSpec(r35, r113, r10);
        float[] r114 = this.mWeights;
        if (r114 != null) goto L46;
    L56:
        this.mEqViews[r110] = r112;
        r110 = r110 + 1;
    L57:
        r33 = r33 + 1;
        r10 = true;
        goto L38
    L46:
        if (r33 >= r114.length) goto L56;
        if (Float.isNaN(r114[r33]) == true) goto L56;
        float r37 = this.mWeights[r33];
        if (r37 < 0.0f) goto L56;
        int r38 = (int) ((((r37 * 1.0f) / 100.0f) * r30) + 0.5f);
        if (Float.isNaN(r34.mAspectRatio) == true) goto L54;
        int r39 = (int) ((r38 / r34.mAspectRatio) + 0.5f);
        int r40 = Ints.MAX_POWER_OF_TWO;
        r36 = View.MeasureSpec.makeMeasureSpec(r39, Ints.MAX_POWER_OF_TWO);
    L55:
        r24.measureChildWithMargins(r112, View.MeasureSpec.makeMeasureSpec(r38, r40), r36);
        r111 = r111 + r38;
        r32 = Math.min(r32, r112.getMeasuredHeight());
        goto L57
    L54:
        r40 = Ints.MAX_POWER_OF_TWO;
        goto L55
    L42:
        r113 = ((ViewGroup.MarginLayoutParams) r34).height;
        goto L43
    L58:
        int r41 = 0;
    L59:
        if (r41 >= r110) goto L70;
        View r42 = this.mEqViews[r41];
        VirtualLayoutManager.LayoutParams r43 = (VirtualLayoutManager.LayoutParams) r42.getLayoutParams();
        int r44 = (int) ((((r30 - r111) * 1.0f) / r110) + 0.5f);
        if (Float.isNaN(r43.mAspectRatio) == true) goto L63;
        int r45 = (int) ((r44 / r43.mAspectRatio) + 0.5f);
        int r115 = Ints.MAX_POWER_OF_TWO;
        int r46 = View.MeasureSpec.makeMeasureSpec(r45, Ints.MAX_POWER_OF_TWO);
    L69:
        r24.measureChildWithMargins(r42, View.MeasureSpec.makeMeasureSpec(r44, r115), r46);
        r32 = Math.min(r32, r42.getMeasuredHeight());
        r41 = r41 + 1;
        goto L59
    L63:
        int r116 = (r24.getContentHeight() - r24.getPaddingTop()) - r24.getPaddingBottom();
        if (r31 <= 0) goto L67;
        int r47 = r31;
    L68:
        r46 = r24.getChildMeasureSpec(r116, r47, true);
        r115 = Ints.MAX_POWER_OF_TWO;
        goto L69
    L67:
        r47 = ((ViewGroup.MarginLayoutParams) r43).height;
        goto L68
    L70:
        int r48 = 0;
    L71:
        if (r48 >= r16) goto L77;
        View r49 = this.mViews[r48];
        if (r49.getMeasuredHeight() == r32) goto L76;
        r24.measureChildWithMargins(r49, View.MeasureSpec.makeMeasureSpec(r49.getMeasuredWidth(), Ints.MAX_POWER_OF_TWO), View.MeasureSpec.makeMeasureSpec(r32, Ints.MAX_POWER_OF_TWO));
    L76:
        r48 = r48 + 1;
        goto L71
    L77:
        int r50 = r32 + r25;
        r23.mConsumed = (getVerticalMargin() + r50) + getVerticalPadding();
        calculateRect(r50, this.mTempArea, r22, r24);
        int r51 = this.mTempArea.left;
        int r52 = 0;
    L78:
        if (r52 >= r16) goto L80;
        View r53 = this.mViews[r52];
        Rect r54 = this.mTempArea;
        int r55 = r54.top;
        int r56 = r54.bottom;
        int r117 = r51 + r12.getDecoratedMeasurementInOther(r53);
        layoutChildWithMargin(r53, r51, r55, r117, r56, r24);
        r52 = r52 + 1;
        r51 = r117;
        goto L78
    L36:
        r31 = -1;
    L80:
        Arrays.fill(this.mViews, null);
        Arrays.fill(this.mEqViews, null);
        return;
    L17:
        if (r15.length != r13) goto L20;
        Arrays.fill(r15, null);
        goto L21
    L12:
        if (r14.length == r13) goto L14;
    L8:
        r11 = false;
        goto L9
    }

    public void setWeights(float[] r10) {
        if (r10 == null) goto L4;
        this.mWeights = Arrays.copyOf(r10, r10.length);
        return;
    L4:
        this.mWeights = new float[0];
    }
}
