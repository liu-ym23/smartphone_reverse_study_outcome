package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseArray;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.HelperWidget;

/* JADX INFO: loaded from: classes.dex */
public class Barrier extends ConstraintHelper {
    public static final int BOTTOM = 3;
    public static final int END = 6;
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    public static final int START = 5;
    public static final int TOP = 2;
    private androidx.constraintlayout.core.widgets.Barrier mBarrier;
    private int mIndicatedType;
    private int mResolvedType;

    public Barrier(Context context) {
        super(context);
        super.setVisibility(8);
    }

    public Barrier(Context context, AttributeSet attrs) {
        super(context, attrs);
        super.setVisibility(8);
    }

    public Barrier(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        super.setVisibility(8);
    }

    public int getType() {
        return this.mIndicatedType;
    }

    public void setType(int type) {
        this.mIndicatedType = type;
    }

    private void updateType(ConstraintWidget widget, int type, boolean isRtl) {
        this.mResolvedType = type;
        if (isRtl == false) goto L9;
        int r6 = this.mIndicatedType;
        if (r6 != 5) goto L7;
        this.mResolvedType = 1;
    L15:
        if ((widget instanceof androidx.constraintlayout.core.widgets.Barrier) == false) goto L18;
        ((androidx.constraintlayout.core.widgets.Barrier) widget).setBarrierType(this.mResolvedType);
        return;
    L18:
        return;
    L7:
        if (r6 != 6) goto L15;
        this.mResolvedType = 0;
        goto L15
    L9:
        int r7 = this.mIndicatedType;
        if (r7 != 5) goto L12;
        this.mResolvedType = 0;
        goto L15
    L12:
        if (r7 != 6) goto L15;
        this.mResolvedType = 1;
        goto L15
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void resolveRtl(ConstraintWidget widget, boolean isRtl) {
        updateType(widget, this.mIndicatedType, isRtl);
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    protected void init(AttributeSet attrs) {
        super.init(attrs);
        this.mBarrier = new androidx.constraintlayout.core.widgets.Barrier();
        if (attrs == null) goto L17;
        TypedArray r7 = getContext().obtainStyledAttributes(attrs, R.styleable.ConstraintLayout_Layout);
        int r0 = r7.getIndexCount();
        int r2 = 0;
    L5:
        if (r2 >= r0) goto L16;
        int r3 = r7.getIndex(r2);
        if (r3 != R.styleable.ConstraintLayout_Layout_barrierDirection) goto L10;
        setType(r7.getInt(r3, 0));
    L15:
        r2 = r2 + 1;
        goto L5
    L10:
        if (r3 != R.styleable.ConstraintLayout_Layout_barrierAllowsGoneWidgets) goto L13;
        this.mBarrier.setAllowsGoneWidget(r7.getBoolean(r3, true));
        goto L15
    L13:
        if (r3 != R.styleable.ConstraintLayout_Layout_barrierMargin) goto L15;
        this.mBarrier.setMargin(r7.getDimensionPixelSize(r3, 0));
        goto L15
    L16:
        r7.recycle();
    L17:
        this.mHelperWidget = this.mBarrier;
        validateParams();
    }

    public void setAllowsGoneWidget(boolean supportGone) {
        this.mBarrier.setAllowsGoneWidget(supportGone);
    }

    @Deprecated
    public boolean allowsGoneWidget() {
        return this.mBarrier.getAllowsGoneWidget();
    }

    public boolean getAllowsGoneWidget() {
        return this.mBarrier.getAllowsGoneWidget();
    }

    public void setDpMargin(int margin) {
        this.mBarrier.setMargin((int) ((margin * getResources().getDisplayMetrics().density) + 0.5f));
    }

    public int getMargin() {
        return this.mBarrier.getMargin();
    }

    public void setMargin(int margin) {
        this.mBarrier.setMargin(margin);
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void loadParameters(ConstraintSet.Constraint constraint, HelperWidget child, ConstraintLayout.LayoutParams layoutParams, SparseArray<ConstraintWidget> mapIdToWidget) {
        super.loadParameters(constraint, child, layoutParams, mapIdToWidget);
        if ((child instanceof androidx.constraintlayout.core.widgets.Barrier) == false) goto L6;
        androidx.constraintlayout.core.widgets.Barrier r3 = (androidx.constraintlayout.core.widgets.Barrier) child;
        boolean r2 = ((ConstraintWidgetContainer) child.getParent()).isRtl();
        updateType(r3, constraint.layout.mBarrierDirection, r2);
        r3.setAllowsGoneWidget(constraint.layout.mBarrierAllowsGoneWidgets);
        r3.setMargin(constraint.layout.mBarrierMargin);
        return;
    }
}
