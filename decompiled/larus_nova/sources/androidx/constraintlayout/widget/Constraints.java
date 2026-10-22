package androidx.constraintlayout.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes17.dex */
public class Constraints extends ViewGroup {
    public static final String TAG = "Constraints";
    ConstraintSet myConstraintSet;

    public static class LayoutParams extends ConstraintLayout.LayoutParams {
        public float alpha;
        public boolean applyElevation;
        public float elevation;
        public float rotation;
        public float rotationX;
        public float rotationY;
        public float scaleX;
        public float scaleY;
        public float transformPivotX;
        public float transformPivotY;
        public float translationX;
        public float translationY;
        public float translationZ;

        public LayoutParams(LayoutParams r100) {
            super(r100);
            this.alpha = 1.0f;
            this.applyElevation = false;
            this.elevation = 0.0f;
            this.rotation = 0.0f;
            this.rotationX = 0.0f;
            this.rotationY = 0.0f;
            this.scaleX = 1.0f;
            this.scaleY = 1.0f;
            this.transformPivotX = 0.0f;
            this.transformPivotY = 0.0f;
            this.translationX = 0.0f;
            this.translationY = 0.0f;
            this.translationZ = 0.0f;
        }

        public LayoutParams(Context r100, AttributeSet r101) {
            super(r100, r101);
            this.alpha = 1.0f;
            int r102 = 0;
            this.applyElevation = false;
            this.elevation = 0.0f;
            this.rotation = 0.0f;
            this.rotationX = 0.0f;
            this.rotationY = 0.0f;
            this.scaleX = 1.0f;
            this.scaleY = 1.0f;
            this.transformPivotX = 0.0f;
            this.transformPivotY = 0.0f;
            this.translationX = 0.0f;
            this.translationY = 0.0f;
            this.translationZ = 0.0f;
            TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.orientation, R.attr.id, R.attr.visibility, R.attr.layout_width, R.attr.layout_height, R.attr.layout_marginLeft, R.attr.layout_marginTop, R.attr.layout_marginRight, R.attr.layout_marginBottom, R.attr.maxWidth, R.attr.maxHeight, R.attr.minWidth, R.attr.minHeight, R.attr.pivotX, R.attr.pivotY, R.attr.alpha, R.attr.transformPivotX, R.attr.transformPivotY, R.attr.translationX, R.attr.translationY, R.attr.scaleX, R.attr.scaleY, R.attr.rotation, R.attr.rotationX, R.attr.rotationY, R.attr.layout_marginStart, R.attr.layout_marginEnd, R.attr.translationZ, R.attr.elevation, com.larus.nova.R.attr.animateCircleAngleTo, com.larus.nova.R.attr.animateRelativeTo, com.larus.nova.R.attr.animate_relativeTo, com.larus.nova.R.attr.barrierAllowsGoneWidgets, com.larus.nova.R.attr.barrierDirection, com.larus.nova.R.attr.barrierMargin, com.larus.nova.R.attr.chainUseRtl, com.larus.nova.R.attr.constraintRotate, com.larus.nova.R.attr.constraint_referenced_ids, com.larus.nova.R.attr.constraint_referenced_tags, com.larus.nova.R.attr.deriveConstraintsFrom, com.larus.nova.R.attr.drawPath, com.larus.nova.R.attr.flow_firstHorizontalBias, com.larus.nova.R.attr.flow_firstHorizontalStyle, com.larus.nova.R.attr.flow_firstVerticalBias, com.larus.nova.R.attr.flow_firstVerticalStyle, com.larus.nova.R.attr.flow_horizontalAlign, com.larus.nova.R.attr.flow_horizontalBias, com.larus.nova.R.attr.flow_horizontalGap, com.larus.nova.R.attr.flow_horizontalStyle, com.larus.nova.R.attr.flow_lastHorizontalBias, com.larus.nova.R.attr.flow_lastHorizontalStyle, com.larus.nova.R.attr.flow_lastVerticalBias, com.larus.nova.R.attr.flow_lastVerticalStyle, com.larus.nova.R.attr.flow_maxElementsWrap, com.larus.nova.R.attr.flow_verticalAlign, com.larus.nova.R.attr.flow_verticalBias, com.larus.nova.R.attr.flow_verticalGap, com.larus.nova.R.attr.flow_verticalStyle, com.larus.nova.R.attr.flow_wrapMode, com.larus.nova.R.attr.guidelineUseRtl, com.larus.nova.R.attr.layout_constrainedHeight, com.larus.nova.R.attr.layout_constrainedWidth, com.larus.nova.R.attr.layout_constraintBaseline_creator, com.larus.nova.R.attr.layout_constraintBaseline_toBaselineOf, com.larus.nova.R.attr.layout_constraintBaseline_toBottomOf, com.larus.nova.R.attr.layout_constraintBaseline_toTopOf, com.larus.nova.R.attr.layout_constraintBottom_creator, com.larus.nova.R.attr.layout_constraintBottom_toBottomOf, com.larus.nova.R.attr.layout_constraintBottom_toTopOf, com.larus.nova.R.attr.layout_constraintCircle, com.larus.nova.R.attr.layout_constraintCircleAngle, com.larus.nova.R.attr.layout_constraintCircleRadius, com.larus.nova.R.attr.layout_constraintDimensionRatio, com.larus.nova.R.attr.layout_constraintEnd_toEndOf, com.larus.nova.R.attr.layout_constraintEnd_toStartOf, com.larus.nova.R.attr.layout_constraintGuide_begin, com.larus.nova.R.attr.layout_constraintGuide_end, com.larus.nova.R.attr.layout_constraintGuide_percent, com.larus.nova.R.attr.layout_constraintHeight_default, com.larus.nova.R.attr.layout_constraintHeight_max, com.larus.nova.R.attr.layout_constraintHeight_min, com.larus.nova.R.attr.layout_constraintHeight_percent, com.larus.nova.R.attr.layout_constraintHorizontal_bias, com.larus.nova.R.attr.layout_constraintHorizontal_chainStyle, com.larus.nova.R.attr.layout_constraintHorizontal_weight, com.larus.nova.R.attr.layout_constraintLeft_creator, com.larus.nova.R.attr.layout_constraintLeft_toLeftOf, com.larus.nova.R.attr.layout_constraintLeft_toRightOf, com.larus.nova.R.attr.layout_constraintRight_creator, com.larus.nova.R.attr.layout_constraintRight_toLeftOf, com.larus.nova.R.attr.layout_constraintRight_toRightOf, com.larus.nova.R.attr.layout_constraintStart_toEndOf, com.larus.nova.R.attr.layout_constraintStart_toStartOf, com.larus.nova.R.attr.layout_constraintTag, com.larus.nova.R.attr.layout_constraintTop_creator, com.larus.nova.R.attr.layout_constraintTop_toBottomOf, com.larus.nova.R.attr.layout_constraintTop_toTopOf, com.larus.nova.R.attr.layout_constraintVertical_bias, com.larus.nova.R.attr.layout_constraintVertical_chainStyle, com.larus.nova.R.attr.layout_constraintVertical_weight, com.larus.nova.R.attr.layout_constraintWidth_default, com.larus.nova.R.attr.layout_constraintWidth_max, com.larus.nova.R.attr.layout_constraintWidth_min, com.larus.nova.R.attr.layout_constraintWidth_percent, com.larus.nova.R.attr.layout_editor_absoluteX, com.larus.nova.R.attr.layout_editor_absoluteY, com.larus.nova.R.attr.layout_goneMarginBaseline, com.larus.nova.R.attr.layout_goneMarginBottom, com.larus.nova.R.attr.layout_goneMarginEnd, com.larus.nova.R.attr.layout_goneMarginLeft, com.larus.nova.R.attr.layout_goneMarginRight, com.larus.nova.R.attr.layout_goneMarginStart, com.larus.nova.R.attr.layout_goneMarginTop, com.larus.nova.R.attr.layout_marginBaseline, com.larus.nova.R.attr.layout_wrapBehaviorInParent, com.larus.nova.R.attr.motionProgress, com.larus.nova.R.attr.motionStagger, com.larus.nova.R.attr.pathMotionArc, com.larus.nova.R.attr.pivotAnchor, com.larus.nova.R.attr.polarRelativeTo, com.larus.nova.R.attr.quantizeMotionSteps, com.larus.nova.R.attr.stateLabels, com.larus.nova.R.attr.transitionEasing, com.larus.nova.R.attr.transitionPathRotate});
            int r104 = r103.getIndexCount();
        L3:
            if (r102 >= r104) goto L41;
            int r105 = r103.getIndex(r102);
            if (r105 != 15) goto L8;
            this.alpha = r103.getFloat(r105, this.alpha);
        L40:
            r102 = r102 + 1;
            goto L3
        L8:
            if (r105 != 28) goto L11;
            this.elevation = r103.getFloat(r105, this.elevation);
            this.applyElevation = true;
            goto L40
        L11:
            if (r105 != 23) goto L14;
            this.rotationX = r103.getFloat(r105, this.rotationX);
            goto L40
        L14:
            if (r105 != 24) goto L17;
            this.rotationY = r103.getFloat(r105, this.rotationY);
            goto L40
        L17:
            if (r105 != 22) goto L20;
            this.rotation = r103.getFloat(r105, this.rotation);
            goto L40
        L20:
            if (r105 != 20) goto L23;
            this.scaleX = r103.getFloat(r105, this.scaleX);
            goto L40
        L23:
            if (r105 != 21) goto L26;
            this.scaleY = r103.getFloat(r105, this.scaleY);
            goto L40
        L26:
            if (r105 != 16) goto L29;
            this.transformPivotX = r103.getFloat(r105, this.transformPivotX);
            goto L40
        L29:
            if (r105 != 17) goto L32;
            this.transformPivotY = r103.getFloat(r105, this.transformPivotY);
            goto L40
        L32:
            if (r105 != 18) goto L35;
            this.translationX = r103.getFloat(r105, this.translationX);
            goto L40
        L35:
            if (r105 != 19) goto L38;
            this.translationY = r103.getFloat(r105, this.translationY);
            goto L40
        L38:
            if (r105 != 27) goto L40;
            this.translationZ = r103.getFloat(r105, this.translationZ);
            goto L40
        L41:
            r103.recycle();
        }

        public LayoutParams(int r100, int r101) {
            super(r100, r101);
            this.alpha = 1.0f;
            this.applyElevation = false;
            this.elevation = 0.0f;
            this.rotation = 0.0f;
            this.rotationX = 0.0f;
            this.rotationY = 0.0f;
            this.scaleX = 1.0f;
            this.scaleY = 1.0f;
            this.transformPivotX = 0.0f;
            this.transformPivotY = 0.0f;
            this.translationX = 0.0f;
            this.translationY = 0.0f;
            this.translationZ = 0.0f;
        }
    }

    private void init(AttributeSet r100) {
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    public ConstraintSet getConstraintSet() {
        if (this.myConstraintSet != null) goto L5;
        this.myConstraintSet = new ConstraintSet();
    L5:
        this.myConstraintSet.clone(this);
        return this.myConstraintSet;
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    public Constraints(Context r100) {
        super(r100);
        super.setVisibility(8);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet r100) {
        return new LayoutParams(getContext(), r100);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r100) {
        return new ConstraintLayout.LayoutParams(r100);
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r100) {
        return generateLayoutParams(r100);
    }

    public Constraints(Context r100, AttributeSet r101) {
        super(r100, r101);
        init(r101);
        super.setVisibility(8);
    }

    public Constraints(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        init(r101);
        super.setVisibility(8);
    }
}
