package androidx.constraintlayout.helper.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.camera.video.AudioStats;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;

/* JADX INFO: loaded from: classes17.dex */
public class Layer extends ConstraintHelper {
    private static final String TAG = "Layer";
    private boolean mApplyElevationOnAttach;
    private boolean mApplyVisibilityOnAttach;
    protected float mComputedCenterX;
    protected float mComputedCenterY;
    protected float mComputedMaxX;
    protected float mComputedMaxY;
    protected float mComputedMinX;
    protected float mComputedMinY;
    ConstraintLayout mContainer;
    private float mGroupRotateAngle;
    boolean mNeedBounds;
    private float mRotationCenterX;
    private float mRotationCenterY;
    private float mScaleX;
    private float mScaleY;
    private float mShiftX;
    private float mShiftY;
    View[] mViews;

    private void reCacheViews() {
        if (this.mContainer != null) goto L5;
        return;
    L5:
        int r100 = this.mCount;
        if (r100 != 0) goto L8;
        return;
    L8:
        View[] r101 = this.mViews;
        if (r101 != null) goto L11;
    L12:
        this.mViews = new View[r100];
    L13:
        int r102 = 0;
    L15:
        if (r102 >= this.mCount) goto L17;
        int r103 = this.mIds[r102];
        this.mViews[r102] = this.mContainer.getViewById(r103);
        r102 = r102 + 1;
        goto L15
    L17:
        return;
    L11:
        if (r101.length == r100) goto L13;
        goto L12
    }

    private void transform() {
        if (this.mContainer != null) goto L6;
        return;
    L6:
        if (this.mViews != null) goto L8;
        reCacheViews();
    L8:
        calcCenters();
        if (Float.isNaN(this.mGroupRotateAngle) == false) goto L11;
        double r100 = AudioStats.AUDIO_AMPLITUDE_NONE;
    L12:
        float r101 = (float) Math.sin(r100);
        float r102 = (float) Math.cos(r100);
        float r103 = this.mScaleX;
        float r104 = r103 * r102;
        float r105 = this.mScaleY;
        float r106 = (-r105) * r101;
        float r107 = r103 * r101;
        float r108 = r105 * r102;
        int r109 = 0;
    L14:
        if (r109 >= this.mCount) goto L19;
        View r110 = this.mViews[r109];
        int r111 = (r110.getLeft() + r110.getRight()) / 2;
        int r112 = (r110.getTop() + r110.getBottom()) / 2;
        float r113 = r111 - this.mComputedCenterX;
        float r114 = r112 - this.mComputedCenterY;
        float r115 = (((r104 * r113) + (r106 * r114)) - r113) + this.mShiftX;
        float r116 = (((r113 * r107) + (r108 * r114)) - r114) + this.mShiftY;
        r110.setTranslationX(r115);
        r110.setTranslationY(r116);
        r110.setScaleY(this.mScaleY);
        r110.setScaleX(this.mScaleX);
        if (Float.isNaN(this.mGroupRotateAngle) == true) goto L18;
        r110.setRotation(this.mGroupRotateAngle);
    L18:
        r109 = r109 + 1;
        goto L14
    L19:
        return;
    L11:
        r100 = Math.toRadians(this.mGroupRotateAngle);
        goto L12
    }

    public void calcCenters() {
        if (this.mContainer != null) goto L6;
        return;
    L6:
        if (this.mNeedBounds == true) goto L13;
        if (Float.isNaN(this.mComputedCenterX) == true) goto L13;
        if (Float.isNaN(this.mComputedCenterY) == true) goto L13;
        return;
    L13:
        if (Float.isNaN(this.mRotationCenterX) == false) goto L15;
    L18:
        View[] r100 = getViews(this.mContainer);
        int r101 = 0;
        int r102 = r100[0].getLeft();
        int r103 = r100[0].getTop();
        int r104 = r100[0].getRight();
        int r105 = r100[0].getBottom();
    L20:
        if (r101 >= this.mCount) goto L22;
        View r106 = r100[r101];
        r102 = Math.min(r102, r106.getLeft());
        r103 = Math.min(r103, r106.getTop());
        r104 = Math.max(r104, r106.getRight());
        r105 = Math.max(r105, r106.getBottom());
        r101 = r101 + 1;
        goto L20
    L22:
        this.mComputedMaxX = r104;
        this.mComputedMaxY = r105;
        this.mComputedMinX = r102;
        this.mComputedMinY = r103;
        if (Float.isNaN(this.mRotationCenterX) == false) goto L25;
        this.mComputedCenterX = (r102 + r104) / 2;
    L27:
        if (Float.isNaN(this.mRotationCenterY) == false) goto L29;
        this.mComputedCenterY = (r103 + r105) / 2;
        return;
    L29:
        this.mComputedCenterY = this.mRotationCenterY;
        return;
    L25:
        this.mComputedCenterX = this.mRotationCenterX;
        goto L27
    L15:
        if (Float.isNaN(this.mRotationCenterY) == true) goto L18;
        this.mComputedCenterY = this.mRotationCenterY;
        this.mComputedCenterX = this.mRotationCenterX;
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mContainer = (ConstraintLayout) getParent();
        if (this.mApplyVisibilityOnAttach == false) goto L5;
    L6:
        int r100 = getVisibility();
        float r101 = getElevation();
        int r102 = 0;
    L8:
        if (r102 >= this.mCount) goto L26;
        int r103 = this.mIds[r102];
        View r104 = this.mContainer.getViewById(r103);
        if (r104 == null) goto L19;
        if (this.mApplyVisibilityOnAttach == false) goto L15;
        r104.setVisibility(r100);
    L15:
        if (this.mApplyElevationOnAttach == false) goto L19;
        if (r101 <= 0.0f) goto L19;
        r104.setTranslationZ(r104.getTranslationZ() + r101);
    L19:
        r102 = r102 + 1;
        goto L8
    L26:
        return;
    L5:
        if (this.mApplyElevationOnAttach == true) goto L6;
    }

    public Layer(Context r100) {
        super(r100);
        this.mRotationCenterX = Float.NaN;
        this.mRotationCenterY = Float.NaN;
        this.mGroupRotateAngle = Float.NaN;
        this.mScaleX = 1.0f;
        this.mScaleY = 1.0f;
        this.mComputedCenterX = Float.NaN;
        this.mComputedCenterY = Float.NaN;
        this.mComputedMaxX = Float.NaN;
        this.mComputedMaxY = Float.NaN;
        this.mComputedMinX = Float.NaN;
        this.mComputedMinY = Float.NaN;
        this.mNeedBounds = true;
        this.mViews = null;
        this.mShiftX = 0.0f;
        this.mShiftY = 0.0f;
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void init(AttributeSet r100) {
        super.init(r100);
        int r101 = 0;
        this.mUseViewMeasure = false;
        if (r100 == null) goto L19;
        TypedArray r102 = getContext().obtainStyledAttributes(r100, new int[]{R.attr.orientation, R.attr.padding, R.attr.paddingLeft, R.attr.paddingTop, R.attr.paddingRight, R.attr.paddingBottom, R.attr.visibility, R.attr.layout_width, R.attr.layout_height, R.attr.layout_margin, R.attr.layout_marginLeft, R.attr.layout_marginTop, R.attr.layout_marginRight, R.attr.layout_marginBottom, R.attr.maxWidth, R.attr.maxHeight, R.attr.minWidth, R.attr.minHeight, R.attr.paddingStart, R.attr.paddingEnd, R.attr.layout_marginStart, R.attr.layout_marginEnd, R.attr.elevation, R.attr.layout_marginHorizontal, R.attr.layout_marginVertical, com.larus.nova.R.attr.barrierAllowsGoneWidgets, com.larus.nova.R.attr.barrierDirection, com.larus.nova.R.attr.barrierMargin, com.larus.nova.R.attr.chainUseRtl, com.larus.nova.R.attr.circularflow_angles, com.larus.nova.R.attr.circularflow_defaultAngle, com.larus.nova.R.attr.circularflow_defaultRadius, com.larus.nova.R.attr.circularflow_radiusInDP, com.larus.nova.R.attr.circularflow_viewCenter, com.larus.nova.R.attr.constraintSet, com.larus.nova.R.attr.constraint_referenced_ids, com.larus.nova.R.attr.constraint_referenced_tags, com.larus.nova.R.attr.flow_firstHorizontalBias, com.larus.nova.R.attr.flow_firstHorizontalStyle, com.larus.nova.R.attr.flow_firstVerticalBias, com.larus.nova.R.attr.flow_firstVerticalStyle, com.larus.nova.R.attr.flow_horizontalAlign, com.larus.nova.R.attr.flow_horizontalBias, com.larus.nova.R.attr.flow_horizontalGap, com.larus.nova.R.attr.flow_horizontalStyle, com.larus.nova.R.attr.flow_lastHorizontalBias, com.larus.nova.R.attr.flow_lastHorizontalStyle, com.larus.nova.R.attr.flow_lastVerticalBias, com.larus.nova.R.attr.flow_lastVerticalStyle, com.larus.nova.R.attr.flow_maxElementsWrap, com.larus.nova.R.attr.flow_verticalAlign, com.larus.nova.R.attr.flow_verticalBias, com.larus.nova.R.attr.flow_verticalGap, com.larus.nova.R.attr.flow_verticalStyle, com.larus.nova.R.attr.flow_wrapMode, com.larus.nova.R.attr.guidelineUseRtl, com.larus.nova.R.attr.layoutDescription, com.larus.nova.R.attr.layout_constrainedHeight, com.larus.nova.R.attr.layout_constrainedWidth, com.larus.nova.R.attr.layout_constraintBaseline_creator, com.larus.nova.R.attr.layout_constraintBaseline_toBaselineOf, com.larus.nova.R.attr.layout_constraintBaseline_toBottomOf, com.larus.nova.R.attr.layout_constraintBaseline_toTopOf, com.larus.nova.R.attr.layout_constraintBottom_creator, com.larus.nova.R.attr.layout_constraintBottom_toBottomOf, com.larus.nova.R.attr.layout_constraintBottom_toTopOf, com.larus.nova.R.attr.layout_constraintCircle, com.larus.nova.R.attr.layout_constraintCircleAngle, com.larus.nova.R.attr.layout_constraintCircleRadius, com.larus.nova.R.attr.layout_constraintDimensionRatio, com.larus.nova.R.attr.layout_constraintEnd_toEndOf, com.larus.nova.R.attr.layout_constraintEnd_toStartOf, com.larus.nova.R.attr.layout_constraintGuide_begin, com.larus.nova.R.attr.layout_constraintGuide_end, com.larus.nova.R.attr.layout_constraintGuide_percent, com.larus.nova.R.attr.layout_constraintHeight, com.larus.nova.R.attr.layout_constraintHeight_default, com.larus.nova.R.attr.layout_constraintHeight_max, com.larus.nova.R.attr.layout_constraintHeight_min, com.larus.nova.R.attr.layout_constraintHeight_percent, com.larus.nova.R.attr.layout_constraintHorizontal_bias, com.larus.nova.R.attr.layout_constraintHorizontal_chainStyle, com.larus.nova.R.attr.layout_constraintHorizontal_weight, com.larus.nova.R.attr.layout_constraintLeft_creator, com.larus.nova.R.attr.layout_constraintLeft_toLeftOf, com.larus.nova.R.attr.layout_constraintLeft_toRightOf, com.larus.nova.R.attr.layout_constraintRight_creator, com.larus.nova.R.attr.layout_constraintRight_toLeftOf, com.larus.nova.R.attr.layout_constraintRight_toRightOf, com.larus.nova.R.attr.layout_constraintStart_toEndOf, com.larus.nova.R.attr.layout_constraintStart_toStartOf, com.larus.nova.R.attr.layout_constraintTag, com.larus.nova.R.attr.layout_constraintTop_creator, com.larus.nova.R.attr.layout_constraintTop_toBottomOf, com.larus.nova.R.attr.layout_constraintTop_toTopOf, com.larus.nova.R.attr.layout_constraintVertical_bias, com.larus.nova.R.attr.layout_constraintVertical_chainStyle, com.larus.nova.R.attr.layout_constraintVertical_weight, com.larus.nova.R.attr.layout_constraintWidth, com.larus.nova.R.attr.layout_constraintWidth_default, com.larus.nova.R.attr.layout_constraintWidth_max, com.larus.nova.R.attr.layout_constraintWidth_min, com.larus.nova.R.attr.layout_constraintWidth_percent, com.larus.nova.R.attr.layout_editor_absoluteX, com.larus.nova.R.attr.layout_editor_absoluteY, com.larus.nova.R.attr.layout_goneMarginBaseline, com.larus.nova.R.attr.layout_goneMarginBottom, com.larus.nova.R.attr.layout_goneMarginEnd, com.larus.nova.R.attr.layout_goneMarginLeft, com.larus.nova.R.attr.layout_goneMarginRight, com.larus.nova.R.attr.layout_goneMarginStart, com.larus.nova.R.attr.layout_goneMarginTop, com.larus.nova.R.attr.layout_marginBaseline, com.larus.nova.R.attr.layout_optimizationLevel, com.larus.nova.R.attr.layout_wrapBehaviorInParent});
        int r103 = r102.getIndexCount();
    L5:
        if (r101 >= r103) goto L13;
        int r104 = r102.getIndex(r101);
        if (r104 != 6) goto L10;
        this.mApplyVisibilityOnAttach = true;
    L12:
        r101 = r101 + 1;
        goto L5
    L10:
        if (r104 != 22) goto L12;
        this.mApplyElevationOnAttach = true;
        goto L12
    L13:
        r102.recycle();
        return;
    }

    @Override // android.view.View
    public void setElevation(float r100) {
        super.setElevation(r100);
        applyLayoutFeatures();
    }

    @Override // android.view.View
    public void setPivotX(float r100) {
        this.mRotationCenterX = r100;
        transform();
    }

    @Override // android.view.View
    public void setPivotY(float r100) {
        this.mRotationCenterY = r100;
        transform();
    }

    @Override // android.view.View
    public void setRotation(float r100) {
        this.mGroupRotateAngle = r100;
        transform();
    }

    @Override // android.view.View
    public void setScaleX(float r100) {
        this.mScaleX = r100;
        transform();
    }

    @Override // android.view.View
    public void setScaleY(float r100) {
        this.mScaleY = r100;
        transform();
    }

    @Override // android.view.View
    public void setTranslationX(float r100) {
        this.mShiftX = r100;
        transform();
    }

    @Override // android.view.View
    public void setTranslationY(float r100) {
        this.mShiftY = r100;
        transform();
    }

    @Override // android.view.View
    public void setVisibility(int r100) {
        super.setVisibility(r100);
        applyLayoutFeatures();
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void updatePostLayout(ConstraintLayout r100) {
        reCacheViews();
        this.mComputedCenterX = Float.NaN;
        this.mComputedCenterY = Float.NaN;
        ConstraintWidget r101 = ((ConstraintLayout.LayoutParams) getLayoutParams()).getConstraintWidget();
        r101.setWidth(0);
        r101.setHeight(0);
        calcCenters();
        layout(((int) this.mComputedMinX) - getPaddingLeft(), ((int) this.mComputedMinY) - getPaddingTop(), ((int) this.mComputedMaxX) + getPaddingRight(), ((int) this.mComputedMaxY) + getPaddingBottom());
        transform();
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void updatePreDraw(ConstraintLayout r100) {
        this.mContainer = r100;
        float r101 = getRotation();
        if (r101 == 0.0f) goto L5;
        this.mGroupRotateAngle = r101;
        return;
    L5:
        if (Float.isNaN(this.mGroupRotateAngle) == true) goto L9;
        this.mGroupRotateAngle = r101;
        return;
    }

    public Layer(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.mRotationCenterX = Float.NaN;
        this.mRotationCenterY = Float.NaN;
        this.mGroupRotateAngle = Float.NaN;
        this.mScaleX = 1.0f;
        this.mScaleY = 1.0f;
        this.mComputedCenterX = Float.NaN;
        this.mComputedCenterY = Float.NaN;
        this.mComputedMaxX = Float.NaN;
        this.mComputedMaxY = Float.NaN;
        this.mComputedMinX = Float.NaN;
        this.mComputedMinY = Float.NaN;
        this.mNeedBounds = true;
        this.mViews = null;
        this.mShiftX = 0.0f;
        this.mShiftY = 0.0f;
    }

    public Layer(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.mRotationCenterX = Float.NaN;
        this.mRotationCenterY = Float.NaN;
        this.mGroupRotateAngle = Float.NaN;
        this.mScaleX = 1.0f;
        this.mScaleY = 1.0f;
        this.mComputedCenterX = Float.NaN;
        this.mComputedCenterY = Float.NaN;
        this.mComputedMaxX = Float.NaN;
        this.mComputedMaxY = Float.NaN;
        this.mComputedMinX = Float.NaN;
        this.mComputedMinY = Float.NaN;
        this.mNeedBounds = true;
        this.mViews = null;
        this.mShiftX = 0.0f;
        this.mShiftY = 0.0f;
    }
}
