package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.constraintlayout.a.c.i;
import androidx.constraintlayout.a.c.j;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.HashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes.dex */
public abstract class ConstraintHelper extends View {
    protected int mCount;
    protected i mHelperWidget;
    protected int[] mIds;
    protected HashMap<Integer, String> mMap;
    protected String mReferenceIds;
    protected String mReferenceTags;
    protected boolean mUseViewMeasure;
    private View[] mViews;
    protected Context myContext;

    public static /* synthetic */ int access$000(String r0, String r1) {
        return Log.e(r0, r1);
    }

    public static /* synthetic */ int access$001(String r0, String r1) {
        return Log.w(r0, r1);
    }

    public void applyLayoutFeaturesInConstraintSet(ConstraintLayout r1) {
    }

    @Override // android.view.View
    public void onDraw(Canvas r1) {
    }

    public void resolveRtl(androidx.constraintlayout.a.c.e r1, boolean r2) {
    }

    public void updatePostConstraints(ConstraintLayout r1) {
    }

    public void updatePostLayout(ConstraintLayout r1) {
    }

    public void updatePostMeasure(ConstraintLayout r1) {
    }

    public void updatePreDraw(ConstraintLayout r1) {
    }

    public ConstraintHelper(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        super(r5);
        this.mIds = new int[32];
        this.mUseViewMeasure = false;
        this.mViews = null;
        this.mMap = new HashMap();
        this.myContext = ZeusTransformUtils.wrapperContext(r5, "com.obric.aiagent.plugin");
        init(null);
    }

    public ConstraintHelper(Context r3, AttributeSet r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        super(r5, r6);
        this.mIds = new int[32];
        this.mUseViewMeasure = false;
        this.mViews = null;
        this.mMap = new HashMap();
        this.myContext = ZeusTransformUtils.wrapperContext(r5, "com.obric.aiagent.plugin");
        init(r6);
    }

    public ConstraintHelper(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        super(r6, r7, r5);
        this.mIds = new int[32];
        this.mUseViewMeasure = false;
        this.mViews = null;
        this.mMap = new HashMap();
        this.myContext = ZeusTransformUtils.wrapperContext(r6, "com.obric.aiagent.plugin");
        init(r7);
    }

    public void init(AttributeSet r7) {
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r7, AttributeSet.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L19;
        TypedArray r9 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).obtainStyledAttributes(r8, R.styleable.ConstraintLayout_Layout);
        int r0 = r9.getIndexCount();
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L13;
        int r2 = r9.getIndex(r1);
        if (r2 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_constraint_referenced_ids, "styleable", "ConstraintLayout_Layout_constraint_referenced_ids")) goto L10;
        String r3 = r9.getString(r2);
        this.mReferenceIds = r3;
        setIds(r3);
    L12:
        r1 = r1 + 1;
        goto L5
    L10:
        if (r2 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_constraint_referenced_tags, "styleable", "ConstraintLayout_Layout_constraint_referenced_tags")) goto L12;
        String r4 = r9.getString(r2);
        this.mReferenceTags = r4;
        setReferenceTags(r4);
        goto L12
    L13:
        r9.recycle();
        return;
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
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
        INVOKESTATIC_androidx_constraintlayout_widget_ConstraintHelper_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("ConstraintHelper", "Views added to a ConstraintHelper need to have an id");
        return;
    L9:
        if (r4.getParent() != null) goto L12;
        INVOKESTATIC_androidx_constraintlayout_widget_ConstraintHelper_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("ConstraintHelper", "Views added to a ConstraintHelper need to have a parent");
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
    public void onMeasure(int r2, int r3) {
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
        if (ZeusTransformUtils.instanceOf(r0, ConstraintLayout.LayoutParams.class) == false) goto L9;
        ConstraintLayout.LayoutParams r1 = (ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r0, ConstraintLayout.LayoutParams.class, "com.obric.aiagent.plugin");
        r1.widget = (androidx.constraintlayout.a.c.e) ZeusTransformUtils.preCheckCast(this.mHelperWidget, androidx.constraintlayout.a.c.e.class, "com.obric.aiagent.plugin");
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
        if (ZeusTransformUtils.instanceOf(getParent(), ConstraintLayout.class) == false) goto L12;
        ConstraintLayout r0 = (ConstraintLayout) ZeusTransformUtils.preCheckCast(getParent(), ConstraintLayout.class, "com.obric.aiagent.plugin");
    L12:
        int r1 = findId(r5);
        if (r1 == 0) goto L15;
        this.mMap.put(Integer.valueOf(r1), r5);
        addRscID(r1);
        return;
    L15:
        INVOKESTATIC_androidx_constraintlayout_widget_ConstraintHelper_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w("ConstraintHelper", "Could not find id of \"" + r5 + "\"");
    }

    private void addTag(String r9) {
        if (r9 != null) goto L4;
        return;
    L4:
        if (r9.length() != 0) goto L7;
        return;
    L7:
        if (this.myContext != null) goto L9;
        return;
    L9:
        String r10 = r9.trim();
        ConstraintLayout r0 = null;
        if (ZeusTransformUtils.instanceOf(getParent(), ConstraintLayout.class) == false) goto L13;
        r0 = (ConstraintLayout) ZeusTransformUtils.preCheckCast(getParent(), ConstraintLayout.class, "com.obric.aiagent.plugin");
    L13:
        if (r0 != null) goto L16;
        INVOKESTATIC_androidx_constraintlayout_widget_ConstraintHelper_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w("ConstraintHelper", "Parent not a ConstraintLayout");
        return;
    L16:
        int r3 = r0.getChildCount();
        int r4 = 0;
    L17:
        if (r4 >= r3) goto L34;
        View r5 = r0.getChildAt(r4);
        ViewGroup.LayoutParams r6 = r5.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r6, ConstraintLayout.LayoutParams.class) == false) goto L26;
        if (r10.equals(((ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r6, ConstraintLayout.LayoutParams.class, "com.obric.aiagent.plugin")).constraintTag) == false) goto L26;
        if (r5.getId() != (-1)) goto L25;
        INVOKESTATIC_androidx_constraintlayout_widget_ConstraintHelper_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w("ConstraintHelper", "to use ConstraintTag view " + r5.getClass().getSimpleName() + " must have an ID");
        goto L26
    L25:
        addRscID(r5.getId());
    L26:
        r4 = r4 + 1;
        goto L17
    }

    private int findId(String r7) {
        if (ZeusTransformUtils.instanceOf(getParent(), ConstraintLayout.class) == false) goto L5;
        ConstraintLayout r0 = (ConstraintLayout) ZeusTransformUtils.preCheckCast(getParent(), ConstraintLayout.class, "com.obric.aiagent.plugin");
    L6:
        int r4 = 0;
        if (isInEditMode() == false) goto L12;
        if (r0 == null) goto L12;
        Object r3 = r0.getDesignInformation(0, r7);
        if (ZeusTransformUtils.instanceOf(r3, Integer.class) == false) goto L12;
        r4 = ((Integer) ZeusTransformUtils.preCheckCast(r3, Integer.class, "com.obric.aiagent.plugin")).intValue();
    L12:
        if (r4 != 0) goto L15;
        if (r0 == null) goto L15;
        r4 = findId(r0, r7);
    L15:
        if (r4 == 0) goto L21;
    L17:
        if (r4 == 0) goto L19;
        return r4;
    L19:
        return ZeusTransformUtils.getIdentifier(ZeusTransformUtils.getResources(this.myContext, "com.obric.aiagent.plugin"), r7, DbHelper.COL_ID, this.myContext.getPackageName(), "com.obric.aiagent.plugin");
    L21:
        r4 = R.id.class.getField(r7).getInt(null);     // Catch: Exception -> L20
        goto L17
    L5:
        r0 = null;
        goto L6
    }

    private int findId(ConstraintLayout r7, String r8) {
        if (r8 == null) goto L20;
        if (r7 == null) goto L20;
        Resources r6 = ZeusTransformUtils.getResources(this.myContext, "com.obric.aiagent.plugin");
        if (r6 != null) goto L9;
        return 0;
    L9:
        int r1 = r7.getChildCount();
        int r2 = 0;
    L10:
        if (r2 >= r1) goto L20;
        View r3 = r7.getChildAt(r2);
        if (r3.getId() == (-1)) goto L19;
        String r4 = null;
        r4 = r6.getResourceEntryName(r3.getId());     // Catch: Resources.NotFoundException -> L21
    L16:
        if (r8.equals(r4) == false) goto L19;
        return r3.getId();
    L19:
        r2 = r2 + 1;
    L20:
        return 0;
    }

    public void setIds(String r4) {
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

    public void setReferenceTags(String r4) {
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

    public void applyLayoutFeatures(ConstraintLayout r8) {
        int r0 = getVisibility();
        if (Build.VERSION.SDK_INT < 21) goto L5;
        float r1 = getElevation();
    L6:
        int r4 = 0;
    L8:
        if (r4 >= this.mCount) goto L17;
        View r5 = r8.getViewById(this.mIds[r4]);
        if (r5 == null) goto L16;
        r5.setVisibility(r0);
        if (r1 <= 0.0f) goto L16;
        if (Build.VERSION.SDK_INT < 21) goto L16;
        r5.setTranslationZ(r5.getTranslationZ() + r1);
    L16:
        r4 = r4 + 1;
        goto L8
    L17:
        return;
    L5:
        r1 = 0.0f;
        goto L6
    }

    public void applyLayoutFeatures() {
        ViewParent r0 = getParent();
        if (r0 != null) goto L5;
        return;
    L5:
        if (ZeusTransformUtils.instanceOf(r0, ConstraintLayout.class) == false) goto L9;
        applyLayoutFeatures((ConstraintLayout) ZeusTransformUtils.preCheckCast(r0, ConstraintLayout.class, "com.obric.aiagent.plugin"));
        return;
    }

    public void updatePreLayout(ConstraintLayout r6) {
        if (isInEditMode() == false) goto L5;
        setIds(this.mReferenceIds);
    L5:
        i r0 = this.mHelperWidget;
        if (r0 != null) goto L8;
        return;
    L8:
        r0.a_();
        int r1 = 0;
    L10:
        if (r1 >= this.mCount) goto L19;
        int r2 = this.mIds[r1];
        View r3 = r6.getViewById(r2);
        if (r3 != null) goto L16;
        String r4 = (String) ZeusTransformUtils.preCheckCast(this.mMap.get(Integer.valueOf(r2)), String.class, "com.obric.aiagent.plugin");
        int r5 = findId(r6, r4);
        if (r5 == 0) goto L16;
        this.mIds[r1] = r5;
        this.mMap.put(Integer.valueOf(r5), r4);
        r3 = r6.getViewById(r5);
    L16:
        if (r3 == null) goto L18;
        this.mHelperWidget.a(r6.getViewWidget(r3));
    L18:
        r1 = r1 + 1;
        goto L10
    L19:
        this.mHelperWidget.a(r6.mLayoutWidget);
    }

    public void updatePreLayout(androidx.constraintlayout.a.c.f r4, i r5, SparseArray<androidx.constraintlayout.a.c.e> r6) {
        i r7 = (i) ZeusTransformUtils.wrapperContextForParams(r5, i.class, "com.obric.aiagent.plugin");
        r7.a_();
        int r8 = 0;
    L4:
        if (r8 >= this.mCount) goto L6;
        r7.a((androidx.constraintlayout.a.c.e) ZeusTransformUtils.preCheckCast(r6.get(this.mIds[r8]), androidx.constraintlayout.a.c.e.class, "com.obric.aiagent.plugin"));
        r8 = r8 + 1;
        goto L4
    }

    public View[] getViews(ConstraintLayout r4) {
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

    public void loadParameters(c.a r3, j r4, ConstraintLayout.LayoutParams r5, SparseArray<androidx.constraintlayout.a.c.e> r6) {
        if (r3.f977e.ak == null) goto L6;
        setReferencedIds(r3.f977e.ak);
    L11:
        if (r4 == null) goto L21;
        r4.a_();
        if (r3.f977e.ak == null) goto L25;
        int r2 = 0;
    L16:
        if (r2 >= r3.f977e.ak.length) goto L26;
        androidx.constraintlayout.a.c.e r7 = (androidx.constraintlayout.a.c.e) ZeusTransformUtils.preCheckCast(r6.get(r3.f977e.ak[r2]), androidx.constraintlayout.a.c.e.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L20;
        r4.a(r7);
    L20:
        r2 = r2 + 1;
        goto L16
    L26:
        return;
    L25:
        return;
    L21:
        return;
    L6:
        if (r3.f977e.al == null) goto L11;
        if (r3.f977e.al.length() <= 0) goto L10;
        c.b r8 = r3.f977e;
        r8.ak = convertReferenceString(this, r3.f977e.al);
        goto L11
    L10:
        r3.f977e.ak = null;
        goto L11
    }

    private int[] convertReferenceString(View r5, String r6) {
        String[] r7 = r6.split(",");
        Context r8 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        int[] r9 = new int[r7.length];
        int r0 = 0;
        int r1 = 0;
    L4:
        if (r0 >= r7.length) goto L10;
        int r2 = findId(r7[r0].trim());
        if (r2 == 0) goto L8;
        r9[r1] = r2;
        r1 = r1 + 1;
    L8:
        r0 = r0 + 1;
        goto L4
    L10:
        if (r1 != r7.length) goto L12;
        return r9;
    L12:
        return Arrays.copyOf(r9, r1);
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

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_androidx_constraintlayout_widget_ConstraintHelper_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_androidx_constraintlayout_widget_ConstraintHelper_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1) {
        return Log.e(r0, r1);
    }
}
