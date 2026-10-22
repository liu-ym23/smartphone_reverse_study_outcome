package com.obric.oui.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.GlobalProxyLancet;
import com.android.contacts.common.SimContactsConstants;
import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget;
import com.obric.oui.constraintlayout.core.widgets.ConstraintWidgetContainer;
import com.obric.oui.constraintlayout.core.widgets.Helper;
import com.obric.oui.constraintlayout.core.widgets.HelperWidget;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ConstraintHelper extends View {
    protected static final String CHILD_TAG = "CONSTRAINT_LAYOUT_HELPER_CHILD";
    protected int mCount;
    protected Helper mHelperWidget;
    protected int[] mIds;
    protected HashMap<Integer, String> mMap;
    protected String mReferenceIds;
    protected String mReferenceTags;
    protected boolean mUseViewMeasure;
    private View[] mViews;
    protected Context myContext;

    public void applyHelperParams() {
    }

    protected void applyLayoutFeaturesInConstraintSet(ConstraintLayout r1) {
    }

    @Override // android.view.View
    public void onDraw(Canvas r1) {
    }

    public void resolveRtl(ConstraintWidget r1, boolean r2) {
    }

    public void updatePostConstraints(ConstraintLayout r1) {
    }

    public void updatePostLayout(ConstraintLayout r1) {
    }

    public void updatePostMeasure(ConstraintLayout r1) {
    }

    public void updatePreDraw(ConstraintLayout r1) {
    }

    public ConstraintHelper(Context r3) {
        super(r3);
        this.mIds = new int[32];
        this.mUseViewMeasure = false;
        this.mViews = null;
        this.mMap = new HashMap();
        this.myContext = r3;
        init(null);
    }

    public ConstraintHelper(Context r2, AttributeSet r3) {
        super(r2, r3);
        this.mIds = new int[32];
        this.mUseViewMeasure = false;
        this.mViews = null;
        this.mMap = new HashMap();
        this.myContext = r2;
        init(r3);
    }

    public ConstraintHelper(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.mIds = new int[32];
        this.mUseViewMeasure = false;
        this.mViews = null;
        this.mMap = new HashMap();
        this.myContext = r1;
        init(r2);
    }

    protected void init(AttributeSet r5) {
        if (r5 == null) goto L18;
        TypedArray r6 = getContext().obtainStyledAttributes(r5, R.styleable.ConstraintLayout_Layout);
        int r0 = r6.getIndexCount();
        int r1 = 0;
    L4:
        if (r1 >= r0) goto L12;
        int r2 = r6.getIndex(r1);
        if (r2 != R.styleable.ConstraintLayout_Layout_constraint_referenced_ids) goto L9;
        String r3 = r6.getString(r2);
        this.mReferenceIds = r3;
        setIds(r3);
    L11:
        r1 = r1 + 1;
        goto L4
    L9:
        if (r2 != R.styleable.ConstraintLayout_Layout_constraint_referenced_tags) goto L11;
        String r4 = r6.getString(r2);
        this.mReferenceTags = r4;
        setReferenceTags(r4);
        goto L11
    L12:
        r6.recycle();
        return;
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        String r0 = this.mReferenceIds;
        if (r0 == null) goto L5;
        setIds(r0);
    L5:
        String r1 = this.mReferenceTags;
        if (r1 == null) goto L9;
        setReferenceTags(r1);
        return;
    }

    public void addView(View r4) {
        if (r4 != this) goto L5;
        return;
    L5:
        if (r4.getId() != (-1)) goto L9;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e("ConstraintHelper", "Views added to a ConstraintHelper need to have an id");
        return;
    L9:
        if (r4.getParent() != null) goto L12;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e("ConstraintHelper", "Views added to a ConstraintHelper need to have a parent");
        return;
    L12:
        this.mReferenceIds = null;
        addRscID(r4.getId());
        requestLayout();
    }

    public int removeView(View r6) {
        int r7 = r6.getId();
        int r0 = -1;
        if (r7 != (-1)) goto L5;
        return -1;
    L5:
        this.mReferenceIds = null;
        int r2 = 0;
    L7:
        if (r2 >= this.mCount) goto L16;
        if (this.mIds[r2] == r7) goto L10;
        r2 = r2 + 1;
        goto L7
    L10:
        int r8 = r2;
    L11:
        int r1 = this.mCount;
        if (r8 >= (r1 - 1)) goto L14;
        int[] r3 = this.mIds;
        int r4 = r8 + 1;
        r3[r8] = r3[r4];
        r8 = r4;
        goto L11
    L14:
        this.mIds[r1 - 1] = 0;
        this.mCount = r1 - 1;
        r0 = r2;
    L16:
        requestLayout();
        return r0;
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.mIds, this.mCount);
    }

    public void setReferencedIds(int[] r3) {
        this.mReferenceIds = null;
        int r0 = 0;
        this.mCount = 0;
    L4:
        if (r0 >= r3.length) goto L6;
        addRscID(r3[r0]);
        r0 = r0 + 1;
        goto L4
    }

    private void addRscID(int r4) {
        if (r4 != getId()) goto L5;
        return;
    L5:
        int r0 = this.mCount + 1;
        int[] r1 = this.mIds;
        if (r0 <= r1.length) goto L8;
        this.mIds = Arrays.copyOf(r1, r1.length * 2);
    L8:
        int[] r2 = this.mIds;
        int r3 = this.mCount;
        r2[r3] = r4;
        this.mCount = r3 + 1;
    }

    @Override // android.view.View
    protected void onMeasure(int r2, int r3) {
        if (this.mUseViewMeasure == false) goto L5;
        super.onMeasure(r2, r3);
        return;
    L5:
        setMeasuredDimension(0, 0);
    }

    public void validateParams() {
        if (this.mHelperWidget != null) goto L5;
        return;
    L5:
        ViewGroup.LayoutParams r0 = getLayoutParams();
        if ((r0 instanceof ConstraintLayout.LayoutParams) == false) goto L9;
        ConstraintWidget r2 = (ConstraintWidget) this.mHelperWidget;
        ((ConstraintLayout.LayoutParams) r0).mWidget = r2;
        return;
    }

    private void addID(String r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (r4.length() != 0) goto L7;
        return;
    L7:
        if (this.myContext != null) goto L9;
        return;
    L9:
        String r5 = r4.trim();
        int r0 = findId(r5);
        if (r0 == 0) goto L12;
        this.mMap.put(Integer.valueOf(r0), r5);
        addRscID(r0);
        return;
    L12:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w("ConstraintHelper", "Could not find id of \"" + r5 + "\"");
    }

    private void addTag(String r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        if (r8.length() != 0) goto L7;
        return;
    L7:
        if (this.myContext != null) goto L9;
        return;
    L9:
        String r9 = r8.trim();
        if ((getParent() instanceof ConstraintLayout) == false) goto L12;
        ConstraintLayout r0 = (ConstraintLayout) getParent();
    L14:
        if (r0 != null) goto L17;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w("ConstraintHelper", "Parent not a ConstraintLayout");
        return;
    L17:
        int r2 = r0.getChildCount();
        int r3 = 0;
    L18:
        if (r3 >= r2) goto L35;
        View r4 = r0.getChildAt(r3);
        ViewGroup.LayoutParams r5 = r4.getLayoutParams();
        if ((r5 instanceof ConstraintLayout.LayoutParams) == false) goto L27;
        if (r9.equals(((ConstraintLayout.LayoutParams) r5).constraintTag) == false) goto L27;
        if (r4.getId() != (-1)) goto L26;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w("ConstraintHelper", "to use ConstraintTag view " + r4.getClass().getSimpleName() + " must have an ID");
        goto L27
    L26:
        addRscID(r4.getId());
    L27:
        r3 = r3 + 1;
        goto L18
    L35:
        return;
    L12:
        r0 = null;
        goto L14
    }

    private int findId(String r6) {
        if ((getParent() instanceof ConstraintLayout) == false) goto L5;
        ConstraintLayout r0 = (ConstraintLayout) getParent();
    L6:
        int r3 = 0;
        if (isInEditMode() == false) goto L12;
        if (r0 == null) goto L12;
        Object r2 = r0.getDesignInformation(0, r6);
        if ((r2 instanceof Integer) == false) goto L12;
        r3 = ((Integer) r2).intValue();
    L12:
        if (r3 != 0) goto L15;
        if (r0 == null) goto L15;
        r3 = findId(r0, r6);
    L15:
        if (r3 == 0) goto L21;
    L17:
        if (r3 == 0) goto L19;
        return r3;
    L19:
        return this.myContext.getResources().getIdentifier(r6, "id", this.myContext.getPackageName());
    L21:
        r3 = R.id.class.getField(r6).getInt(null);     // Catch: Exception -> L20
        goto L17
    L5:
        r0 = null;
        goto L6
    }

    private int findId(ConstraintLayout r7, String r8) {
        if (r8 == null) goto L21;
        if (r7 == null) goto L21;
        Resources r6 = this.myContext.getResources();
        if (r6 != null) goto L9;
        return 0;
    L9:
        int r1 = r7.getChildCount();
        int r2 = 0;
    L10:
        if (r2 >= r1) goto L21;
        View r3 = r7.getChildAt(r2);
        if (r3.getId() == (-1)) goto L20;
        String r4 = r6.getResourceEntryName(r3.getId());     // Catch: Resources.NotFoundException -> L15
    L17:
        if (r8.equals(r4) == false) goto L20;
        return r3.getId();
    L15:
        r4 = null;
    L20:
        r2 = r2 + 1;
    L21:
        return 0;
    }

    protected void setIds(String r4) {
        this.mReferenceIds = r4;
        if (r4 != null) goto L5;
        return;
    L5:
        int r0 = 0;
        this.mCount = 0;
    L6:
        int r1 = r4.indexOf(44, r0);
        if (r1 == (-1)) goto L8;
        addID(r4.substring(r0, r1));
        r0 = r1 + 1;
        goto L6
    L8:
        addID(r4.substring(r0));
    }

    protected void setReferenceTags(String r4) {
        this.mReferenceTags = r4;
        if (r4 != null) goto L5;
        return;
    L5:
        int r0 = 0;
        this.mCount = 0;
    L6:
        int r1 = r4.indexOf(44, r0);
        if (r1 == (-1)) goto L8;
        addTag(r4.substring(r0, r1));
        r0 = r1 + 1;
        goto L6
    L8:
        addTag(r4.substring(r0));
    }

    protected void applyLayoutFeatures(ConstraintLayout r6) {
        int r0 = getVisibility();
        float r1 = getElevation();
        int r2 = 0;
    L4:
        if (r2 >= this.mCount) goto L11;
        View r3 = r6.getViewById(this.mIds[r2]);
        if (r3 == null) goto L10;
        r3.setVisibility(r0);
        if (r1 <= 0.0f) goto L10;
        r3.setTranslationZ(r3.getTranslationZ() + r1);
    L10:
        r2 = r2 + 1;
        goto L4
    }

    protected void applyLayoutFeatures() {
        ViewParent r0 = getParent();
        if (r0 != null) goto L5;
        return;
    L5:
        if ((r0 instanceof ConstraintLayout) == false) goto L9;
        applyLayoutFeatures((ConstraintLayout) r0);
        return;
    }

    public void updatePreLayout(ConstraintLayout r6) {
        if (isInEditMode() == false) goto L5;
        setIds(this.mReferenceIds);
    L5:
        Helper r0 = this.mHelperWidget;
        if (r0 != null) goto L8;
        return;
    L8:
        r0.removeAllIds();
        int r1 = 0;
    L10:
        if (r1 >= this.mCount) goto L19;
        int r2 = this.mIds[r1];
        View r3 = r6.getViewById(r2);
        if (r3 != null) goto L16;
        String r4 = this.mMap.get(Integer.valueOf(r2));
        int r5 = findId(r6, r4);
        if (r5 == 0) goto L16;
        this.mIds[r1] = r5;
        this.mMap.put(Integer.valueOf(r5), r4);
        r3 = r6.getViewById(r5);
    L16:
        if (r3 == null) goto L18;
        this.mHelperWidget.add(r6.getViewWidget(r3));
    L18:
        r1 = r1 + 1;
        goto L10
    L19:
        this.mHelperWidget.updateConstraints(r6.mLayoutWidget);
    }

    public void updatePreLayout(ConstraintWidgetContainer r2, Helper r3, SparseArray<ConstraintWidget> r4) {
        r3.removeAllIds();
        int r5 = 0;
    L4:
        if (r5 >= this.mCount) goto L6;
        r3.add(r4.get(this.mIds[r5]));
        r5 = r5 + 1;
        goto L4
    }

    protected View[] getViews(ConstraintLayout r4) {
        View[] r0 = this.mViews;
        if (r0 != null) goto L5;
    L6:
        this.mViews = new View[this.mCount];
    L7:
        int r1 = 0;
    L9:
        if (r1 >= this.mCount) goto L12;
        int r2 = this.mIds[r1];
        this.mViews[r1] = r4.getViewById(r2);
        r1 = r1 + 1;
        goto L9
    L12:
        return this.mViews;
    L5:
        if (r0.length == this.mCount) goto L7;
        goto L6
    }

    public void loadParameters(ConstraintSet.Constraint r2, HelperWidget r3, ConstraintLayout.LayoutParams r4, SparseArray<ConstraintWidget> r5) {
        if (r2.layout.mReferenceIds == null) goto L6;
        setReferencedIds(r2.layout.mReferenceIds);
    L11:
        if (r3 == null) goto L21;
        r3.removeAllIds();
        if (r2.layout.mReferenceIds == null) goto L25;
        int r1 = 0;
    L16:
        if (r1 >= r2.layout.mReferenceIds.length) goto L26;
        ConstraintWidget r6 = r5.get(r2.layout.mReferenceIds[r1]);
        if (r6 == null) goto L20;
        r3.add(r6);
    L20:
        r1 = r1 + 1;
        goto L16
    L26:
        return;
    L25:
        return;
    L21:
        return;
    L6:
        if (r2.layout.mReferenceIdString == null) goto L11;
        if (r2.layout.mReferenceIdString.length() <= 0) goto L10;
        ConstraintSet.Layout r7 = r2.layout;
        r7.mReferenceIds = convertReferenceString(r2.layout.mReferenceIdString);
        goto L11
    L10:
        r2.layout.mReferenceIds = null;
        goto L11
    }

    private int[] convertReferenceString(String r6) {
        String[] r7 = r6.split(SimContactsConstants.EMAIL_SEP);
        int[] r0 = new int[r7.length];
        int r1 = 0;
        int r2 = 0;
    L4:
        if (r1 >= r7.length) goto L10;
        int r3 = findId(r7[r1].trim());
        if (r3 == 0) goto L8;
        r0[r2] = r3;
        r2 = r2 + 1;
    L8:
        r1 = r1 + 1;
        goto L4
    L10:
        if (r2 != r7.length) goto L12;
        return r0;
    L12:
        return Arrays.copyOf(r0, r2);
    }

    @Override // android.view.View
    public void setTag(int r1, Object r2) {
        super.setTag(r1, r2);
        if (r2 == null) goto L5;
        return;
    L5:
        if (this.mReferenceIds != null) goto L9;
        addRscID(r1);
        return;
    }

    public boolean containsId(int r5) {
        int[] r4 = this.mIds;
        int r0 = r4.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L11;
        if (r4[r2] == r5) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return true;
    L11:
        return false;
    }

    public int indexFromId(int r5) {
        int[] r4 = this.mIds;
        int r0 = r4.length;
        int r1 = -1;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L8;
        r1 = r1 + 1;
        if (r4[r2] == r5) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return r1;
    L8:
        return r1;
    }

    public static boolean isChildOfHelper(View r1) {
        if (CHILD_TAG != r1.getTag()) goto L5;
        return true;
    L5:
        return false;
    }
}
