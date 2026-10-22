package androidx.constraintlayout.widget;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Helper;
import androidx.constraintlayout.solver.widgets.HelperWidget;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ConstraintHelper extends View {
    protected int mCount;
    protected Helper mHelperWidget;
    protected int[] mIds;
    private HashMap<Integer, String> mMap;
    protected String mReferenceIds;
    protected String mReferenceTags;
    protected boolean mUseViewMeasure;
    private View[] mViews;
    protected Context myContext;

    @Override // android.view.View
    public void onDraw(Canvas r100) {
    }

    public void resolveRtl(ConstraintWidget r100, boolean r101) {
    }

    public void updatePostConstraints(ConstraintLayout r100) {
    }

    public void updatePostLayout(ConstraintLayout r100) {
    }

    public void updatePostMeasure(ConstraintLayout r100) {
    }

    public void updatePreDraw(ConstraintLayout r100) {
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.mIds, this.mCount);
    }

    public void validateParams() {
        if (this.mHelperWidget != null) goto L5;
        return;
    L5:
        ViewGroup.LayoutParams r100 = getLayoutParams();
        if ((r100 instanceof ConstraintLayout.LayoutParams) == false) goto L9;
        ConstraintWidget r101 = (ConstraintWidget) this.mHelperWidget;
        ((ConstraintLayout.LayoutParams) r100).widget = r101;
        return;
    }

    public void applyLayoutFeatures() {
        ViewParent r100 = getParent();
        if (r100 != null) goto L5;
        return;
    L5:
        if ((r100 instanceof ConstraintLayout) == false) goto L9;
        applyLayoutFeatures((ConstraintLayout) r100);
        return;
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String r100 = this.mReferenceIds;
        if (r100 == null) goto L5;
        setIds(r100);
    L5:
        String r101 = this.mReferenceTags;
        if (r101 == null) goto L9;
        setReferenceTags(r101);
        return;
    }

    public ConstraintHelper(Context r100) {
        super(r100);
        this.mIds = new int[32];
        this.mUseViewMeasure = false;
        this.mViews = null;
        this.mMap = new HashMap();
        this.myContext = r100;
        init(null);
    }

    private void addID(String r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.length() != 0) goto L7;
        return;
    L7:
        if (this.myContext != null) goto L9;
        return;
    L9:
        String r101 = r100.trim();
        if ((getParent() instanceof ConstraintLayout) == false) goto L12;
        ConstraintLayout r102 = (ConstraintLayout) getParent();
    L12:
        int r103 = findId(r101);
        if (r103 == 0) goto L16;
        this.mMap.put(Integer.valueOf(r103), r101);
        addRscID(r103);
        return;
    }

    private void addRscID(int r100) {
        if (r100 != getId()) goto L5;
        return;
    L5:
        int r101 = this.mCount + 1;
        int[] r102 = this.mIds;
        if (r101 <= r102.length) goto L8;
        this.mIds = Arrays.copyOf(r102, r102.length * 2);
    L8:
        int[] r103 = this.mIds;
        int r104 = this.mCount;
        r103[r104] = r100;
        this.mCount = r104 + 1;
    }

    private void addTag(String r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.length() != 0) goto L7;
        return;
    L7:
        if (this.myContext != null) goto L9;
        return;
    L9:
        String r101 = r100.trim();
        if ((getParent() instanceof ConstraintLayout) == false) goto L12;
        ConstraintLayout r102 = (ConstraintLayout) getParent();
    L13:
        if (r102 != null) goto L15;
        return;
    L15:
        int r103 = r102.getChildCount();
        int r104 = 0;
    L16:
        if (r104 >= r103) goto L33;
        View r105 = r102.getChildAt(r104);
        ViewGroup.LayoutParams r106 = r105.getLayoutParams();
        if ((r106 instanceof ConstraintLayout.LayoutParams) == false) goto L25;
        if (r101.equals(((ConstraintLayout.LayoutParams) r106).constraintTag) == false) goto L25;
        if (r105.getId() == (-1)) goto L25;
        addRscID(r105.getId());
    L25:
        r104 = r104 + 1;
        goto L16
    L33:
        return;
    L12:
        r102 = null;
        goto L13
    }

    private int findId(String r100) {
        if ((getParent() instanceof ConstraintLayout) == false) goto L5;
        ConstraintLayout r101 = (ConstraintLayout) getParent();
    L6:
        int r102 = 0;
        if (isInEditMode() == false) goto L12;
        if (r101 == null) goto L12;
        Object r103 = r101.getDesignInformation(0, r100);
        if ((r103 instanceof Integer) == false) goto L12;
        r102 = ((Integer) r103).intValue();
    L12:
        if (r102 != 0) goto L15;
        if (r101 == null) goto L15;
        r102 = findId(r101, r100);
    L15:
        if (r102 == 0) goto L22;
    L19:
        if (r102 == 0) goto L21;
        return r102;
    L21:
        return this.myContext.getResources().getIdentifier(r100, "id", this.myContext.getPackageName());
    L22:
        r102 = R$id.class.getField(r100).getInt(null);     // Catch: Exception -> L18
        goto L19
    L5:
        r101 = null;
        goto L6
    }

    public void addView(View r100) {
        if (r100 != this) goto L5;
        return;
    L5:
        if (r100.getId() != (-1)) goto L8;
        return;
    L8:
        if (r100.getParent() != null) goto L10;
        return;
    L10:
        this.mReferenceIds = null;
        addRscID(r100.getId());
        requestLayout();
    }

    public void applyLayoutFeatures(ConstraintLayout r100) {
        int r101 = getVisibility();
        float r102 = getElevation();
        int r103 = 0;
    L4:
        if (r103 >= this.mCount) goto L11;
        View r104 = r100.getViewById(this.mIds[r103]);
        if (r104 == null) goto L10;
        r104.setVisibility(r101);
        if (r102 <= 0.0f) goto L10;
        r104.setTranslationZ(r104.getTranslationZ() + r102);
    L10:
        r103 = r103 + 1;
        goto L4
    }

    public View[] getViews(ConstraintLayout r100) {
        View[] r101 = this.mViews;
        if (r101 != null) goto L5;
    L6:
        this.mViews = new View[this.mCount];
    L7:
        int r102 = 0;
    L9:
        if (r102 >= this.mCount) goto L12;
        int r103 = this.mIds[r102];
        this.mViews[r102] = r100.getViewById(r103);
        r102 = r102 + 1;
        goto L9
    L12:
        return this.mViews;
    L5:
        if (r101.length == this.mCount) goto L7;
        goto L6
    }

    public void init(AttributeSet r100) {
        if (r100 == null) goto L18;
        TypedArray r101 = getContext().obtainStyledAttributes(r100, new int[]{R.attr.orientation, R.attr.padding, R.attr.paddingLeft, R.attr.paddingTop, R.attr.paddingRight, R.attr.paddingBottom, R.attr.visibility, R.attr.layout_width, R.attr.layout_height, R.attr.layout_margin, R.attr.layout_marginLeft, R.attr.layout_marginTop, R.attr.layout_marginRight, R.attr.layout_marginBottom, R.attr.maxWidth, R.attr.maxHeight, R.attr.minWidth, R.attr.minHeight, R.attr.paddingStart, R.attr.paddingEnd, R.attr.layout_marginStart, R.attr.layout_marginEnd, R.attr.elevation, R.attr.layout_marginHorizontal, R.attr.layout_marginVertical, com.larus.nova.R.attr.barrierAllowsGoneWidgets, com.larus.nova.R.attr.barrierDirection, com.larus.nova.R.attr.barrierMargin, com.larus.nova.R.attr.chainUseRtl, com.larus.nova.R.attr.circularflow_angles, com.larus.nova.R.attr.circularflow_defaultAngle, com.larus.nova.R.attr.circularflow_defaultRadius, com.larus.nova.R.attr.circularflow_radiusInDP, com.larus.nova.R.attr.circularflow_viewCenter, com.larus.nova.R.attr.constraintSet, com.larus.nova.R.attr.constraint_referenced_ids, com.larus.nova.R.attr.constraint_referenced_tags, com.larus.nova.R.attr.flow_firstHorizontalBias, com.larus.nova.R.attr.flow_firstHorizontalStyle, com.larus.nova.R.attr.flow_firstVerticalBias, com.larus.nova.R.attr.flow_firstVerticalStyle, com.larus.nova.R.attr.flow_horizontalAlign, com.larus.nova.R.attr.flow_horizontalBias, com.larus.nova.R.attr.flow_horizontalGap, com.larus.nova.R.attr.flow_horizontalStyle, com.larus.nova.R.attr.flow_lastHorizontalBias, com.larus.nova.R.attr.flow_lastHorizontalStyle, com.larus.nova.R.attr.flow_lastVerticalBias, com.larus.nova.R.attr.flow_lastVerticalStyle, com.larus.nova.R.attr.flow_maxElementsWrap, com.larus.nova.R.attr.flow_verticalAlign, com.larus.nova.R.attr.flow_verticalBias, com.larus.nova.R.attr.flow_verticalGap, com.larus.nova.R.attr.flow_verticalStyle, com.larus.nova.R.attr.flow_wrapMode, com.larus.nova.R.attr.guidelineUseRtl, com.larus.nova.R.attr.layoutDescription, com.larus.nova.R.attr.layout_constrainedHeight, com.larus.nova.R.attr.layout_constrainedWidth, com.larus.nova.R.attr.layout_constraintBaseline_creator, com.larus.nova.R.attr.layout_constraintBaseline_toBaselineOf, com.larus.nova.R.attr.layout_constraintBaseline_toBottomOf, com.larus.nova.R.attr.layout_constraintBaseline_toTopOf, com.larus.nova.R.attr.layout_constraintBottom_creator, com.larus.nova.R.attr.layout_constraintBottom_toBottomOf, com.larus.nova.R.attr.layout_constraintBottom_toTopOf, com.larus.nova.R.attr.layout_constraintCircle, com.larus.nova.R.attr.layout_constraintCircleAngle, com.larus.nova.R.attr.layout_constraintCircleRadius, com.larus.nova.R.attr.layout_constraintDimensionRatio, com.larus.nova.R.attr.layout_constraintEnd_toEndOf, com.larus.nova.R.attr.layout_constraintEnd_toStartOf, com.larus.nova.R.attr.layout_constraintGuide_begin, com.larus.nova.R.attr.layout_constraintGuide_end, com.larus.nova.R.attr.layout_constraintGuide_percent, com.larus.nova.R.attr.layout_constraintHeight, com.larus.nova.R.attr.layout_constraintHeight_default, com.larus.nova.R.attr.layout_constraintHeight_max, com.larus.nova.R.attr.layout_constraintHeight_min, com.larus.nova.R.attr.layout_constraintHeight_percent, com.larus.nova.R.attr.layout_constraintHorizontal_bias, com.larus.nova.R.attr.layout_constraintHorizontal_chainStyle, com.larus.nova.R.attr.layout_constraintHorizontal_weight, com.larus.nova.R.attr.layout_constraintLeft_creator, com.larus.nova.R.attr.layout_constraintLeft_toLeftOf, com.larus.nova.R.attr.layout_constraintLeft_toRightOf, com.larus.nova.R.attr.layout_constraintRight_creator, com.larus.nova.R.attr.layout_constraintRight_toLeftOf, com.larus.nova.R.attr.layout_constraintRight_toRightOf, com.larus.nova.R.attr.layout_constraintStart_toEndOf, com.larus.nova.R.attr.layout_constraintStart_toStartOf, com.larus.nova.R.attr.layout_constraintTag, com.larus.nova.R.attr.layout_constraintTop_creator, com.larus.nova.R.attr.layout_constraintTop_toBottomOf, com.larus.nova.R.attr.layout_constraintTop_toTopOf, com.larus.nova.R.attr.layout_constraintVertical_bias, com.larus.nova.R.attr.layout_constraintVertical_chainStyle, com.larus.nova.R.attr.layout_constraintVertical_weight, com.larus.nova.R.attr.layout_constraintWidth, com.larus.nova.R.attr.layout_constraintWidth_default, com.larus.nova.R.attr.layout_constraintWidth_max, com.larus.nova.R.attr.layout_constraintWidth_min, com.larus.nova.R.attr.layout_constraintWidth_percent, com.larus.nova.R.attr.layout_editor_absoluteX, com.larus.nova.R.attr.layout_editor_absoluteY, com.larus.nova.R.attr.layout_goneMarginBaseline, com.larus.nova.R.attr.layout_goneMarginBottom, com.larus.nova.R.attr.layout_goneMarginEnd, com.larus.nova.R.attr.layout_goneMarginLeft, com.larus.nova.R.attr.layout_goneMarginRight, com.larus.nova.R.attr.layout_goneMarginStart, com.larus.nova.R.attr.layout_goneMarginTop, com.larus.nova.R.attr.layout_marginBaseline, com.larus.nova.R.attr.layout_optimizationLevel, com.larus.nova.R.attr.layout_wrapBehaviorInParent});
        int r102 = r101.getIndexCount();
        int r103 = 0;
    L4:
        if (r103 >= r102) goto L12;
        int r104 = r101.getIndex(r103);
        if (r104 != 35) goto L9;
        String r105 = r101.getString(r104);
        this.mReferenceIds = r105;
        setIds(r105);
    L11:
        r103 = r103 + 1;
        goto L4
    L9:
        if (r104 != 36) goto L11;
        String r106 = r101.getString(r104);
        this.mReferenceTags = r106;
        setReferenceTags(r106);
        goto L11
    L12:
        r101.recycle();
        return;
    }

    public void removeView(View r100) {
        int r101 = r100.getId();
        if (r101 != (-1)) goto L5;
        return;
    L5:
        this.mReferenceIds = null;
        int r102 = 0;
    L7:
        if (r102 >= this.mCount) goto L15;
        if (this.mIds[r102] == r101) goto L10;
        r102 = r102 + 1;
    L10:
        int r103 = this.mCount;
        if (r102 >= (r103 - 1)) goto L13;
        int[] r104 = this.mIds;
        int r105 = r102 + 1;
        r104[r102] = r104[r105];
        r102 = r105;
        goto L10
    L13:
        this.mIds[r103 - 1] = 0;
        this.mCount = r103 - 1;
    L15:
        requestLayout();
    }

    public void setIds(String r100) {
        this.mReferenceIds = r100;
        if (r100 != null) goto L5;
        return;
    L5:
        int r101 = 0;
        this.mCount = 0;
    L6:
        int r102 = r100.indexOf(44, r101);
        if (r102 == (-1)) goto L8;
        addID(r100.substring(r101, r102));
        r101 = r102 + 1;
        goto L6
    L8:
        addID(r100.substring(r101));
    }

    public void setReferenceTags(String r100) {
        this.mReferenceTags = r100;
        if (r100 != null) goto L5;
        return;
    L5:
        int r101 = 0;
        this.mCount = 0;
    L6:
        int r102 = r100.indexOf(44, r101);
        if (r102 == (-1)) goto L8;
        addTag(r100.substring(r101, r102));
        r101 = r102 + 1;
        goto L6
    L8:
        addTag(r100.substring(r101));
    }

    public void setReferencedIds(int[] r100) {
        this.mReferenceIds = null;
        int r101 = 0;
        this.mCount = 0;
    L4:
        if (r101 >= r100.length) goto L6;
        addRscID(r100[r101]);
        r101 = r101 + 1;
        goto L4
    }

    public void updatePreLayout(ConstraintLayout r100) {
        if (isInEditMode() == false) goto L5;
        setIds(this.mReferenceIds);
    L5:
        Helper r101 = this.mHelperWidget;
        if (r101 != null) goto L8;
        return;
    L8:
        r101.removeAllIds();
        int r102 = 0;
    L10:
        if (r102 >= this.mCount) goto L19;
        int r103 = this.mIds[r102];
        View r104 = r100.getViewById(r103);
        if (r104 != null) goto L16;
        String r105 = this.mMap.get(Integer.valueOf(r103));
        int r106 = findId(r100, r105);
        if (r106 == 0) goto L16;
        this.mIds[r102] = r106;
        this.mMap.put(Integer.valueOf(r106), r105);
        r104 = r100.getViewById(r106);
    L16:
        if (r104 == null) goto L18;
        this.mHelperWidget.add(r100.getViewWidget(r104));
    L18:
        r102 = r102 + 1;
        goto L10
    L19:
        this.mHelperWidget.updateConstraints(r100.mLayoutWidget);
    }

    public ConstraintHelper(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.mIds = new int[32];
        this.mUseViewMeasure = false;
        this.mViews = null;
        this.mMap = new HashMap();
        this.myContext = r100;
        init(r101);
    }

    private int[] convertReferenceString(View r100, String r101) {
        String[] r102 = r101.split(",");
        r100.getContext();
        int[] r103 = new int[r102.length];
        int r104 = 0;
        int r105 = 0;
    L4:
        if (r104 >= r102.length) goto L10;
        int r106 = findId(r102[r104].trim());
        if (r106 == 0) goto L8;
        r103[r105] = r106;
        r105 = r105 + 1;
    L8:
        r104 = r104 + 1;
        goto L4
    L10:
        if (r105 != r102.length) goto L12;
        return r103;
    L12:
        return Arrays.copyOf(r103, r105);
    }

    private int findId(ConstraintLayout r100, String r101) {
        if (r101 == null) goto L21;
        if (r100 == null) goto L21;
        Resources r102 = this.myContext.getResources();
        if (r102 != null) goto L9;
        return 0;
    L9:
        int r103 = r100.getChildCount();
        int r104 = 0;
    L10:
        if (r104 >= r103) goto L21;
        View r105 = r100.getChildAt(r104);
        if (r105.getId() == (-1)) goto L20;
        String r106 = r102.getResourceEntryName(r105.getId());     // Catch: Resources.NotFoundException -> L15
    L17:
        if (r101.equals(r106) == false) goto L20;
        return r105.getId();
    L15:
        r106 = null;
    L20:
        r104 = r104 + 1;
    L21:
        return 0;
    }

    @Override // android.view.View
    public void onMeasure(int r100, int r101) {
        if (this.mUseViewMeasure == false) goto L5;
        super.onMeasure(r100, r101);
        return;
    L5:
        setMeasuredDimension(0, 0);
    }

    @Override // android.view.View
    public void setTag(int r100, Object r101) {
        super.setTag(r100, r101);
        if (r101 == null) goto L5;
        return;
    L5:
        if (this.mReferenceIds != null) goto L9;
        addRscID(r100);
        return;
    }

    public ConstraintHelper(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.mIds = new int[32];
        this.mUseViewMeasure = false;
        this.mViews = null;
        this.mMap = new HashMap();
        this.myContext = r100;
        init(r101);
    }

    public void updatePreLayout(ConstraintWidgetContainer r100, Helper r101, SparseArray<ConstraintWidget> r102) {
        r101.removeAllIds();
        int r103 = 0;
    L4:
        if (r103 >= this.mCount) goto L6;
        r101.add(r102.get(this.mIds[r103]));
        r103 = r103 + 1;
        goto L4
    }

    public void loadParameters(ConstraintSet.Constraint r100, HelperWidget r101, ConstraintLayout.LayoutParams r102, SparseArray<ConstraintWidget> r103) {
        ConstraintSet.Layout r104 = r100.layout;
        int[] r105 = r104.mReferenceIds;
        if (r105 == null) goto L5;
        setReferencedIds(r105);
    L10:
        r101.removeAllIds();
        if (r100.layout.mReferenceIds == null) goto L19;
        int r106 = 0;
    L13:
        int[] r107 = r100.layout.mReferenceIds;
        if (r106 >= r107.length) goto L23;
        ConstraintWidget r108 = r103.get(r107[r106]);
        if (r108 == null) goto L18;
        r101.add(r108);
    L18:
        r106 = r106 + 1;
        goto L13
    L23:
        return;
    L19:
        return;
    L5:
        String r109 = r104.mReferenceIdString;
        if (r109 == null) goto L10;
        if (r109.length() <= 0) goto L10;
        ConstraintSet.Layout r110 = r100.layout;
        r110.mReferenceIds = convertReferenceString(this, r110.mReferenceIdString);
        goto L10
    }
}
