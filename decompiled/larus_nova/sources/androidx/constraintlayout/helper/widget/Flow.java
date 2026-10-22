package androidx.constraintlayout.helper.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.HelperWidget;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.VirtualLayout;

/* JADX INFO: loaded from: classes17.dex */
public class Flow extends VirtualLayout {
    public static final int CHAIN_PACKED = 2;
    public static final int CHAIN_SPREAD = 0;
    public static final int CHAIN_SPREAD_INSIDE = 1;
    public static final int HORIZONTAL = 0;
    public static final int HORIZONTAL_ALIGN_CENTER = 2;
    public static final int HORIZONTAL_ALIGN_END = 1;
    public static final int HORIZONTAL_ALIGN_START = 0;
    private static final String TAG = "Flow";
    public static final int VERTICAL = 1;
    public static final int VERTICAL_ALIGN_BASELINE = 3;
    public static final int VERTICAL_ALIGN_BOTTOM = 1;
    public static final int VERTICAL_ALIGN_CENTER = 2;
    public static final int VERTICAL_ALIGN_TOP = 0;
    public static final int WRAP_ALIGNED = 2;
    public static final int WRAP_CHAIN = 1;
    public static final int WRAP_NONE = 0;
    private androidx.constraintlayout.solver.widgets.Flow mFlow;

    public Flow(Context r100) {
        super(r100);
    }

    @Override // androidx.constraintlayout.widget.VirtualLayout, androidx.constraintlayout.widget.ConstraintHelper
    public void init(AttributeSet r100) {
        super.init(r100);
        this.mFlow = new androidx.constraintlayout.solver.widgets.Flow();
        if (r100 == null) goto L86;
        TypedArray r101 = getContext().obtainStyledAttributes(r100, new int[]{R.attr.orientation, R.attr.padding, R.attr.paddingLeft, R.attr.paddingTop, R.attr.paddingRight, R.attr.paddingBottom, R.attr.visibility, R.attr.layout_width, R.attr.layout_height, R.attr.layout_margin, R.attr.layout_marginLeft, R.attr.layout_marginTop, R.attr.layout_marginRight, R.attr.layout_marginBottom, R.attr.maxWidth, R.attr.maxHeight, R.attr.minWidth, R.attr.minHeight, R.attr.paddingStart, R.attr.paddingEnd, R.attr.layout_marginStart, R.attr.layout_marginEnd, R.attr.elevation, R.attr.layout_marginHorizontal, R.attr.layout_marginVertical, com.larus.nova.R.attr.barrierAllowsGoneWidgets, com.larus.nova.R.attr.barrierDirection, com.larus.nova.R.attr.barrierMargin, com.larus.nova.R.attr.chainUseRtl, com.larus.nova.R.attr.circularflow_angles, com.larus.nova.R.attr.circularflow_defaultAngle, com.larus.nova.R.attr.circularflow_defaultRadius, com.larus.nova.R.attr.circularflow_radiusInDP, com.larus.nova.R.attr.circularflow_viewCenter, com.larus.nova.R.attr.constraintSet, com.larus.nova.R.attr.constraint_referenced_ids, com.larus.nova.R.attr.constraint_referenced_tags, com.larus.nova.R.attr.flow_firstHorizontalBias, com.larus.nova.R.attr.flow_firstHorizontalStyle, com.larus.nova.R.attr.flow_firstVerticalBias, com.larus.nova.R.attr.flow_firstVerticalStyle, com.larus.nova.R.attr.flow_horizontalAlign, com.larus.nova.R.attr.flow_horizontalBias, com.larus.nova.R.attr.flow_horizontalGap, com.larus.nova.R.attr.flow_horizontalStyle, com.larus.nova.R.attr.flow_lastHorizontalBias, com.larus.nova.R.attr.flow_lastHorizontalStyle, com.larus.nova.R.attr.flow_lastVerticalBias, com.larus.nova.R.attr.flow_lastVerticalStyle, com.larus.nova.R.attr.flow_maxElementsWrap, com.larus.nova.R.attr.flow_verticalAlign, com.larus.nova.R.attr.flow_verticalBias, com.larus.nova.R.attr.flow_verticalGap, com.larus.nova.R.attr.flow_verticalStyle, com.larus.nova.R.attr.flow_wrapMode, com.larus.nova.R.attr.guidelineUseRtl, com.larus.nova.R.attr.layoutDescription, com.larus.nova.R.attr.layout_constrainedHeight, com.larus.nova.R.attr.layout_constrainedWidth, com.larus.nova.R.attr.layout_constraintBaseline_creator, com.larus.nova.R.attr.layout_constraintBaseline_toBaselineOf, com.larus.nova.R.attr.layout_constraintBaseline_toBottomOf, com.larus.nova.R.attr.layout_constraintBaseline_toTopOf, com.larus.nova.R.attr.layout_constraintBottom_creator, com.larus.nova.R.attr.layout_constraintBottom_toBottomOf, com.larus.nova.R.attr.layout_constraintBottom_toTopOf, com.larus.nova.R.attr.layout_constraintCircle, com.larus.nova.R.attr.layout_constraintCircleAngle, com.larus.nova.R.attr.layout_constraintCircleRadius, com.larus.nova.R.attr.layout_constraintDimensionRatio, com.larus.nova.R.attr.layout_constraintEnd_toEndOf, com.larus.nova.R.attr.layout_constraintEnd_toStartOf, com.larus.nova.R.attr.layout_constraintGuide_begin, com.larus.nova.R.attr.layout_constraintGuide_end, com.larus.nova.R.attr.layout_constraintGuide_percent, com.larus.nova.R.attr.layout_constraintHeight, com.larus.nova.R.attr.layout_constraintHeight_default, com.larus.nova.R.attr.layout_constraintHeight_max, com.larus.nova.R.attr.layout_constraintHeight_min, com.larus.nova.R.attr.layout_constraintHeight_percent, com.larus.nova.R.attr.layout_constraintHorizontal_bias, com.larus.nova.R.attr.layout_constraintHorizontal_chainStyle, com.larus.nova.R.attr.layout_constraintHorizontal_weight, com.larus.nova.R.attr.layout_constraintLeft_creator, com.larus.nova.R.attr.layout_constraintLeft_toLeftOf, com.larus.nova.R.attr.layout_constraintLeft_toRightOf, com.larus.nova.R.attr.layout_constraintRight_creator, com.larus.nova.R.attr.layout_constraintRight_toLeftOf, com.larus.nova.R.attr.layout_constraintRight_toRightOf, com.larus.nova.R.attr.layout_constraintStart_toEndOf, com.larus.nova.R.attr.layout_constraintStart_toStartOf, com.larus.nova.R.attr.layout_constraintTag, com.larus.nova.R.attr.layout_constraintTop_creator, com.larus.nova.R.attr.layout_constraintTop_toBottomOf, com.larus.nova.R.attr.layout_constraintTop_toTopOf, com.larus.nova.R.attr.layout_constraintVertical_bias, com.larus.nova.R.attr.layout_constraintVertical_chainStyle, com.larus.nova.R.attr.layout_constraintVertical_weight, com.larus.nova.R.attr.layout_constraintWidth, com.larus.nova.R.attr.layout_constraintWidth_default, com.larus.nova.R.attr.layout_constraintWidth_max, com.larus.nova.R.attr.layout_constraintWidth_min, com.larus.nova.R.attr.layout_constraintWidth_percent, com.larus.nova.R.attr.layout_editor_absoluteX, com.larus.nova.R.attr.layout_editor_absoluteY, com.larus.nova.R.attr.layout_goneMarginBaseline, com.larus.nova.R.attr.layout_goneMarginBottom, com.larus.nova.R.attr.layout_goneMarginEnd, com.larus.nova.R.attr.layout_goneMarginLeft, com.larus.nova.R.attr.layout_goneMarginRight, com.larus.nova.R.attr.layout_goneMarginStart, com.larus.nova.R.attr.layout_goneMarginTop, com.larus.nova.R.attr.layout_marginBaseline, com.larus.nova.R.attr.layout_optimizationLevel, com.larus.nova.R.attr.layout_wrapBehaviorInParent});
        int r102 = r101.getIndexCount();
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L85;
        int r104 = r101.getIndex(r103);
        if (r104 != 0) goto L10;
        this.mFlow.setOrientation(r101.getInt(r104, 0));
    L84:
        r103 = r103 + 1;
        goto L5
    L10:
        if (r104 != 1) goto L13;
        this.mFlow.setPadding(r101.getDimensionPixelSize(r104, 0));
        goto L84
    L13:
        if (r104 != 18) goto L16;
        this.mFlow.setPaddingStart(r101.getDimensionPixelSize(r104, 0));
        goto L84
    L16:
        if (r104 != 19) goto L19;
        this.mFlow.setPaddingEnd(r101.getDimensionPixelSize(r104, 0));
        goto L84
    L19:
        if (r104 != 2) goto L22;
        this.mFlow.setPaddingLeft(r101.getDimensionPixelSize(r104, 0));
        goto L84
    L22:
        if (r104 != 3) goto L25;
        this.mFlow.setPaddingTop(r101.getDimensionPixelSize(r104, 0));
        goto L84
    L25:
        if (r104 != 4) goto L28;
        this.mFlow.setPaddingRight(r101.getDimensionPixelSize(r104, 0));
        goto L84
    L28:
        if (r104 != 5) goto L31;
        this.mFlow.setPaddingBottom(r101.getDimensionPixelSize(r104, 0));
        goto L84
    L31:
        if (r104 != 54) goto L34;
        this.mFlow.setWrapMode(r101.getInt(r104, 0));
        goto L84
    L34:
        if (r104 != 44) goto L37;
        this.mFlow.setHorizontalStyle(r101.getInt(r104, 0));
        goto L84
    L37:
        if (r104 != 53) goto L40;
        this.mFlow.setVerticalStyle(r101.getInt(r104, 0));
        goto L84
    L40:
        if (r104 != 38) goto L43;
        this.mFlow.setFirstHorizontalStyle(r101.getInt(r104, 0));
        goto L84
    L43:
        if (r104 != 46) goto L46;
        this.mFlow.setLastHorizontalStyle(r101.getInt(r104, 0));
        goto L84
    L46:
        if (r104 != 40) goto L49;
        this.mFlow.setFirstVerticalStyle(r101.getInt(r104, 0));
        goto L84
    L49:
        if (r104 != 48) goto L52;
        this.mFlow.setLastVerticalStyle(r101.getInt(r104, 0));
        goto L84
    L52:
        if (r104 != 42) goto L55;
        this.mFlow.setHorizontalBias(r101.getFloat(r104, 0.5f));
        goto L84
    L55:
        if (r104 != 37) goto L58;
        this.mFlow.setFirstHorizontalBias(r101.getFloat(r104, 0.5f));
        goto L84
    L58:
        if (r104 != 45) goto L61;
        this.mFlow.setLastHorizontalBias(r101.getFloat(r104, 0.5f));
        goto L84
    L61:
        if (r104 != 39) goto L64;
        this.mFlow.setFirstVerticalBias(r101.getFloat(r104, 0.5f));
        goto L84
    L64:
        if (r104 != 47) goto L67;
        this.mFlow.setLastVerticalBias(r101.getFloat(r104, 0.5f));
        goto L84
    L67:
        if (r104 != 51) goto L70;
        this.mFlow.setVerticalBias(r101.getFloat(r104, 0.5f));
        goto L84
    L70:
        if (r104 != 41) goto L73;
        this.mFlow.setHorizontalAlign(r101.getInt(r104, 2));
        goto L84
    L73:
        if (r104 != 50) goto L76;
        this.mFlow.setVerticalAlign(r101.getInt(r104, 2));
        goto L84
    L76:
        if (r104 != 43) goto L79;
        this.mFlow.setHorizontalGap(r101.getDimensionPixelSize(r104, 0));
        goto L84
    L79:
        if (r104 != 52) goto L82;
        this.mFlow.setVerticalGap(r101.getDimensionPixelSize(r104, 0));
        goto L84
    L82:
        if (r104 != 49) goto L84;
        this.mFlow.setMaxElementsWrap(r101.getInt(r104, -1));
        goto L84
    L85:
        r101.recycle();
    L86:
        this.mHelperWidget = this.mFlow;
        validateParams();
    }

    public void setFirstHorizontalBias(float r100) {
        this.mFlow.setFirstHorizontalBias(r100);
        requestLayout();
    }

    public void setFirstHorizontalStyle(int r100) {
        this.mFlow.setFirstHorizontalStyle(r100);
        requestLayout();
    }

    public void setFirstVerticalBias(float r100) {
        this.mFlow.setFirstVerticalBias(r100);
        requestLayout();
    }

    public void setFirstVerticalStyle(int r100) {
        this.mFlow.setFirstVerticalStyle(r100);
        requestLayout();
    }

    public void setHorizontalAlign(int r100) {
        this.mFlow.setHorizontalAlign(r100);
        requestLayout();
    }

    public void setHorizontalBias(float r100) {
        this.mFlow.setHorizontalBias(r100);
        requestLayout();
    }

    public void setHorizontalGap(int r100) {
        this.mFlow.setHorizontalGap(r100);
        requestLayout();
    }

    public void setHorizontalStyle(int r100) {
        this.mFlow.setHorizontalStyle(r100);
        requestLayout();
    }

    public void setMaxElementsWrap(int r100) {
        this.mFlow.setMaxElementsWrap(r100);
        requestLayout();
    }

    public void setOrientation(int r100) {
        this.mFlow.setOrientation(r100);
        requestLayout();
    }

    public void setPadding(int r100) {
        this.mFlow.setPadding(r100);
        requestLayout();
    }

    public void setPaddingBottom(int r100) {
        this.mFlow.setPaddingBottom(r100);
        requestLayout();
    }

    public void setPaddingLeft(int r100) {
        this.mFlow.setPaddingLeft(r100);
        requestLayout();
    }

    public void setPaddingRight(int r100) {
        this.mFlow.setPaddingRight(r100);
        requestLayout();
    }

    public void setPaddingTop(int r100) {
        this.mFlow.setPaddingTop(r100);
        requestLayout();
    }

    public void setVerticalAlign(int r100) {
        this.mFlow.setVerticalAlign(r100);
        requestLayout();
    }

    public void setVerticalBias(float r100) {
        this.mFlow.setVerticalBias(r100);
        requestLayout();
    }

    public void setVerticalGap(int r100) {
        this.mFlow.setVerticalGap(r100);
        requestLayout();
    }

    public void setVerticalStyle(int r100) {
        this.mFlow.setVerticalStyle(r100);
        requestLayout();
    }

    public void setWrapMode(int r100) {
        this.mFlow.setWrapMode(r100);
        requestLayout();
    }

    public Flow(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    public void onMeasure(int r100, int r101) {
        onMeasure(this.mFlow, r100, r101);
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void resolveRtl(ConstraintWidget r100, boolean r101) {
        this.mFlow.applyRtl(r101);
    }

    public Flow(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }

    @Override // androidx.constraintlayout.widget.VirtualLayout
    public void onMeasure(androidx.constraintlayout.solver.widgets.VirtualLayout r100, int r101, int r102) {
        int r103 = View.MeasureSpec.getMode(r101);
        int r104 = View.MeasureSpec.getSize(r101);
        int r105 = View.MeasureSpec.getMode(r102);
        int r106 = View.MeasureSpec.getSize(r102);
        if (r100 == null) goto L5;
        r100.measure(r103, r104, r105, r106);
        setMeasuredDimension(r100.getMeasuredWidth(), r100.getMeasuredHeight());
        return;
    L5:
        setMeasuredDimension(0, 0);
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void loadParameters(ConstraintSet.Constraint r100, HelperWidget r101, ConstraintLayout.LayoutParams r102, SparseArray<ConstraintWidget> r103) {
        super.loadParameters(r100, r101, r102, r103);
        if ((r101 instanceof androidx.constraintlayout.solver.widgets.Flow) == false) goto L8;
        androidx.constraintlayout.solver.widgets.Flow r104 = (androidx.constraintlayout.solver.widgets.Flow) r101;
        int r105 = r102.orientation;
        if (r105 == (-1)) goto L9;
        r104.setOrientation(r105);
        return;
    L9:
        return;
    }
}
