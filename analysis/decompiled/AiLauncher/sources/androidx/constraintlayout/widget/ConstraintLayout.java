package androidx.constraintlayout.widget;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import com.autonavi.aps.amapapi.config.Const;
import com.zyql.ai.selector.camera.CustomCameraView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import l0.C4856b;
import p0.C5034b;

/* loaded from: classes.dex */
public class ConstraintLayout extends ViewGroup {
    private static final boolean DEBUG = false;
    private static final boolean DEBUG_DRAW_CONSTRAINTS = false;
    public static final int DESIGN_INFO_ID = 0;
    private static final boolean OPTIMIZE_HEIGHT_CHANGE = false;
    private static final String TAG = "ConstraintLayout";
    private static final boolean USE_CONSTRAINTS_HELPER = true;
    public static final String VERSION = "ConstraintLayout-2.2.0-alpha04";
    private static g sSharedValues;
    SparseArray<View> mChildrenByIds;
    private ArrayList<androidx.constraintlayout.widget.a> mConstraintHelpers;
    protected androidx.constraintlayout.widget.b mConstraintLayoutSpec;
    private androidx.constraintlayout.widget.c mConstraintSet;
    private int mConstraintSetId;
    private HashMap<String, Integer> mDesignIds;
    protected boolean mDirtyHierarchy;
    private int mLastMeasureHeight;
    int mLastMeasureHeightMode;
    int mLastMeasureHeightSize;
    private int mLastMeasureWidth;
    int mLastMeasureWidthMode;
    int mLastMeasureWidthSize;
    protected androidx.constraintlayout.core.widgets.d mLayoutWidget;
    private int mMaxHeight;
    private int mMaxWidth;
    c mMeasurer;
    private C4856b mMetrics;
    private int mMinHeight;
    private int mMinWidth;
    private ArrayList<d> mModifiers;
    private int mOnMeasureHeightMeasureSpec;
    private int mOnMeasureWidthMeasureSpec;
    private int mOptimizationLevel;
    private SparseArray<ConstraintWidget> mTempMapIdToWidget;

    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f12599a;

        static {
            int[] iArr = new int[ConstraintWidget.DimensionBehaviour.values().length];
            f12599a = iArr;
            try {
                iArr[ConstraintWidget.DimensionBehaviour.FIXED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12599a[ConstraintWidget.DimensionBehaviour.WRAP_CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f12599a[ConstraintWidget.DimensionBehaviour.MATCH_PARENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f12599a[ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public class c implements C5034b.InterfaceC0492b {

        /* renamed from: a, reason: collision with root package name */
        public ConstraintLayout f12676a;

        /* renamed from: b, reason: collision with root package name */
        public int f12677b;

        /* renamed from: c, reason: collision with root package name */
        public int f12678c;

        /* renamed from: d, reason: collision with root package name */
        public int f12679d;

        /* renamed from: e, reason: collision with root package name */
        public int f12680e;

        /* renamed from: f, reason: collision with root package name */
        public int f12681f;

        /* renamed from: g, reason: collision with root package name */
        public int f12682g;

        public c(ConstraintLayout constraintLayout) {
            this.f12676a = constraintLayout;
        }

        @Override // p0.C5034b.InterfaceC0492b
        public final void a() {
            int childCount = this.f12676a.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = this.f12676a.getChildAt(i10);
                if (childAt instanceof f) {
                    ((f) childAt).a(this.f12676a);
                }
            }
            int size = this.f12676a.mConstraintHelpers.size();
            if (size > 0) {
                for (int i11 = 0; i11 < size; i11++) {
                    ((androidx.constraintlayout.widget.a) this.f12676a.mConstraintHelpers.get(i11)).s(this.f12676a);
                }
            }
        }

        @Override // p0.C5034b.InterfaceC0492b
        @SuppressLint({"WrongCall"})
        public final void b(ConstraintWidget constraintWidget, C5034b.a aVar) {
            int iMakeMeasureSpec;
            int iMakeMeasureSpec2;
            int baseline;
            int iMax;
            int iMax2;
            int i10;
            if (constraintWidget == null) {
                return;
            }
            if (constraintWidget.X() == 8 && !constraintWidget.l0()) {
                aVar.f38017e = 0;
                aVar.f38018f = 0;
                aVar.f38019g = 0;
                return;
            }
            if (constraintWidget.M() == null) {
                return;
            }
            ConstraintLayout.access$000(ConstraintLayout.this);
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = aVar.f38013a;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = aVar.f38014b;
            int i11 = aVar.f38015c;
            int i12 = aVar.f38016d;
            int i13 = this.f12677b + this.f12678c;
            int i14 = this.f12679d;
            View view = (View) constraintWidget.u();
            int[] iArr = a.f12599a;
            int i15 = iArr[dimensionBehaviour.ordinal()];
            if (i15 == 1) {
                iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i11, 1073741824);
            } else if (i15 == 2) {
                iMakeMeasureSpec = ViewGroup.getChildMeasureSpec(this.f12681f, i14, -2);
            } else if (i15 == 3) {
                iMakeMeasureSpec = ViewGroup.getChildMeasureSpec(this.f12681f, i14 + constraintWidget.D(), -1);
            } else if (i15 != 4) {
                iMakeMeasureSpec = 0;
            } else {
                iMakeMeasureSpec = ViewGroup.getChildMeasureSpec(this.f12681f, i14, -2);
                boolean z10 = constraintWidget.f12022w == 1;
                int i16 = aVar.f38022j;
                if (i16 == C5034b.a.f38011l || i16 == C5034b.a.f38012m) {
                    boolean z11 = view.getMeasuredHeight() == constraintWidget.z();
                    if (aVar.f38022j == C5034b.a.f38012m || !z10 || ((z10 && z11) || (view instanceof f) || constraintWidget.p0())) {
                        iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(constraintWidget.Y(), 1073741824);
                    }
                }
            }
            int i17 = iArr[dimensionBehaviour2.ordinal()];
            if (i17 == 1) {
                iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i12, 1073741824);
            } else if (i17 == 2) {
                iMakeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.f12682g, i13, -2);
            } else if (i17 == 3) {
                iMakeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.f12682g, i13 + constraintWidget.W(), -1);
            } else if (i17 != 4) {
                iMakeMeasureSpec2 = 0;
            } else {
                iMakeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.f12682g, i13, -2);
                boolean z12 = constraintWidget.f12024x == 1;
                int i18 = aVar.f38022j;
                if (i18 == C5034b.a.f38011l || i18 == C5034b.a.f38012m) {
                    boolean z13 = view.getMeasuredWidth() == constraintWidget.Y();
                    if (aVar.f38022j == C5034b.a.f38012m || !z12 || ((z12 && z13) || (view instanceof f) || constraintWidget.q0())) {
                        iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(constraintWidget.z(), 1073741824);
                    }
                }
            }
            androidx.constraintlayout.core.widgets.d dVar = (androidx.constraintlayout.core.widgets.d) constraintWidget.M();
            if (dVar != null && androidx.constraintlayout.core.widgets.g.b(ConstraintLayout.this.mOptimizationLevel, 256) && view.getMeasuredWidth() == constraintWidget.Y() && view.getMeasuredWidth() < dVar.Y() && view.getMeasuredHeight() == constraintWidget.z() && view.getMeasuredHeight() < dVar.z() && view.getBaseline() == constraintWidget.r() && !constraintWidget.o0() && d(constraintWidget.E(), iMakeMeasureSpec, constraintWidget.Y()) && d(constraintWidget.F(), iMakeMeasureSpec2, constraintWidget.z())) {
                aVar.f38017e = constraintWidget.Y();
                aVar.f38018f = constraintWidget.z();
                aVar.f38019g = constraintWidget.r();
                return;
            }
            ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
            boolean z14 = dimensionBehaviour == dimensionBehaviour3;
            boolean z15 = dimensionBehaviour2 == dimensionBehaviour3;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
            boolean z16 = dimensionBehaviour2 == dimensionBehaviour4 || dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.FIXED;
            boolean z17 = dimensionBehaviour == dimensionBehaviour4 || dimensionBehaviour == ConstraintWidget.DimensionBehaviour.FIXED;
            boolean z18 = z14 && constraintWidget.f11989f0 > 0.0f;
            boolean z19 = z15 && constraintWidget.f11989f0 > 0.0f;
            if (view == null) {
                return;
            }
            b bVar = (b) view.getLayoutParams();
            int i19 = aVar.f38022j;
            if (i19 != C5034b.a.f38011l && i19 != C5034b.a.f38012m && z14 && constraintWidget.f12022w == 0 && z15 && constraintWidget.f12024x == 0) {
                i10 = -1;
                iMax2 = 0;
                baseline = 0;
                iMax = 0;
            } else {
                if ((view instanceof i) && (constraintWidget instanceof androidx.constraintlayout.core.widgets.i)) {
                    ((i) view).x((androidx.constraintlayout.core.widgets.i) constraintWidget, iMakeMeasureSpec, iMakeMeasureSpec2);
                } else {
                    view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                }
                constraintWidget.a1(iMakeMeasureSpec, iMakeMeasureSpec2);
                int measuredWidth = view.getMeasuredWidth();
                int measuredHeight = view.getMeasuredHeight();
                baseline = view.getBaseline();
                int i20 = constraintWidget.f12028z;
                iMax = i20 > 0 ? Math.max(i20, measuredWidth) : measuredWidth;
                int i21 = constraintWidget.f11932A;
                if (i21 > 0) {
                    iMax = Math.min(i21, iMax);
                }
                int i22 = constraintWidget.f11936C;
                iMax2 = i22 > 0 ? Math.max(i22, measuredHeight) : measuredHeight;
                boolean z20 = z17;
                int i23 = constraintWidget.f11938D;
                if (i23 > 0) {
                    iMax2 = Math.min(i23, iMax2);
                }
                boolean z21 = z16;
                if (!androidx.constraintlayout.core.widgets.g.b(ConstraintLayout.this.mOptimizationLevel, 1)) {
                    if (z18 && z21) {
                        iMax = (int) ((iMax2 * constraintWidget.f11989f0) + 0.5f);
                    } else if (z19 && z20) {
                        iMax2 = (int) ((iMax / constraintWidget.f11989f0) + 0.5f);
                    }
                }
                if (measuredWidth != iMax || measuredHeight != iMax2) {
                    if (measuredWidth != iMax) {
                        iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iMax, 1073741824);
                    }
                    if (measuredHeight != iMax2) {
                        iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMax2, 1073741824);
                    }
                    view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                    constraintWidget.a1(iMakeMeasureSpec, iMakeMeasureSpec2);
                    iMax = view.getMeasuredWidth();
                    iMax2 = view.getMeasuredHeight();
                    baseline = view.getBaseline();
                }
                i10 = -1;
            }
            boolean z22 = baseline != i10;
            aVar.f38021i = (iMax == aVar.f38015c && iMax2 == aVar.f38016d) ? false : true;
            if (bVar.f12639g0) {
                z22 = true;
            }
            if (z22 && baseline != -1 && constraintWidget.r() != baseline) {
                aVar.f38021i = true;
            }
            aVar.f38017e = iMax;
            aVar.f38018f = iMax2;
            aVar.f38020h = z22;
            aVar.f38019g = baseline;
            ConstraintLayout.access$000(ConstraintLayout.this);
        }

        public void c(int i10, int i11, int i12, int i13, int i14, int i15) {
            this.f12677b = i12;
            this.f12678c = i13;
            this.f12679d = i14;
            this.f12680e = i15;
            this.f12681f = i10;
            this.f12682g = i11;
        }

        public final boolean d(int i10, int i11, int i12) {
            if (i10 == i11) {
                return true;
            }
            int mode = View.MeasureSpec.getMode(i10);
            int mode2 = View.MeasureSpec.getMode(i11);
            int size = View.MeasureSpec.getSize(i11);
            if (mode2 == 1073741824) {
                return (mode == Integer.MIN_VALUE || mode == 0) && i12 == size;
            }
            return false;
        }
    }

    public interface d {
        boolean a(int i10, int i11, int i12, View view, b bVar);
    }

    public ConstraintLayout(Context context) {
        super(context);
        this.mChildrenByIds = new SparseArray<>();
        this.mConstraintHelpers = new ArrayList<>(4);
        this.mLayoutWidget = new androidx.constraintlayout.core.widgets.d();
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mMaxWidth = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.mDirtyHierarchy = true;
        this.mOptimizationLevel = CustomCameraView.BUTTON_STATE_ONLY_CAPTURE;
        this.mConstraintSet = null;
        this.mConstraintLayoutSpec = null;
        this.mConstraintSetId = -1;
        this.mDesignIds = new HashMap<>();
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
        this.mTempMapIdToWidget = new SparseArray<>();
        this.mMeasurer = new c(this);
        this.mOnMeasureWidthMeasureSpec = 0;
        this.mOnMeasureHeightMeasureSpec = 0;
        init(null, 0, 0);
    }

    public static /* synthetic */ C4856b access$000(ConstraintLayout constraintLayout) {
        constraintLayout.getClass();
        return null;
    }

    private int getPaddingWidth() {
        int iMax = Math.max(0, getPaddingLeft()) + Math.max(0, getPaddingRight());
        int iMax2 = Math.max(0, getPaddingStart()) + Math.max(0, getPaddingEnd());
        return iMax2 > 0 ? iMax2 : iMax;
    }

    public static g getSharedValues() {
        if (sSharedValues == null) {
            sSharedValues = new g();
        }
        return sSharedValues;
    }

    private ConstraintWidget getTargetWidget(int i10) {
        if (i10 == 0) {
            return this.mLayoutWidget;
        }
        View viewFindViewById = this.mChildrenByIds.get(i10);
        if (viewFindViewById == null && (viewFindViewById = findViewById(i10)) != null && viewFindViewById != this && viewFindViewById.getParent() == this) {
            onViewAdded(viewFindViewById);
        }
        if (viewFindViewById == this) {
            return this.mLayoutWidget;
        }
        if (viewFindViewById == null) {
            return null;
        }
        return ((b) viewFindViewById.getLayoutParams()).f12669v0;
    }

    private void init(AttributeSet attributeSet, int i10, int i11) {
        this.mLayoutWidget.G0(this);
        this.mLayoutWidget.b2(this.mMeasurer);
        this.mChildrenByIds.put(getId(), this);
        this.mConstraintSet = null;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.ConstraintLayout_Layout, i10, i11);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i12 = 0; i12 < indexCount; i12++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i12);
                if (index == R$styleable.ConstraintLayout_Layout_android_minWidth) {
                    this.mMinWidth = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.mMinWidth);
                } else if (index == R$styleable.ConstraintLayout_Layout_android_minHeight) {
                    this.mMinHeight = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.mMinHeight);
                } else if (index == R$styleable.ConstraintLayout_Layout_android_maxWidth) {
                    this.mMaxWidth = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.mMaxWidth);
                } else if (index == R$styleable.ConstraintLayout_Layout_android_maxHeight) {
                    this.mMaxHeight = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.mMaxHeight);
                } else if (index == R$styleable.ConstraintLayout_Layout_layout_optimizationLevel) {
                    this.mOptimizationLevel = typedArrayObtainStyledAttributes.getInt(index, this.mOptimizationLevel);
                } else if (index == R$styleable.ConstraintLayout_Layout_layoutDescription) {
                    int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, 0);
                    if (resourceId != 0) {
                        try {
                            parseLayoutDescription(resourceId);
                        } catch (Resources.NotFoundException unused) {
                            this.mConstraintLayoutSpec = null;
                        }
                    }
                } else if (index == R$styleable.ConstraintLayout_Layout_constraintSet) {
                    int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(index, 0);
                    try {
                        androidx.constraintlayout.widget.c cVar = new androidx.constraintlayout.widget.c();
                        this.mConstraintSet = cVar;
                        cVar.J(getContext(), resourceId2);
                    } catch (Resources.NotFoundException unused2) {
                        this.mConstraintSet = null;
                    }
                    this.mConstraintSetId = resourceId2;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        this.mLayoutWidget.c2(this.mOptimizationLevel);
    }

    private void markHierarchyDirty() {
        this.mDirtyHierarchy = true;
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
    }

    private void setChildrenConstraints() throws Resources.NotFoundException {
        ConstraintLayout constraintLayout;
        boolean zIsInEditMode = isInEditMode();
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            ConstraintWidget viewWidget = getViewWidget(getChildAt(i10));
            if (viewWidget != null) {
                viewWidget.v0();
            }
        }
        if (zIsInEditMode) {
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = getChildAt(i11);
                try {
                    String resourceName = getResources().getResourceName(childAt.getId());
                    setDesignInformation(0, resourceName, Integer.valueOf(childAt.getId()));
                    int iIndexOf = resourceName.indexOf(47);
                    if (iIndexOf != -1) {
                        resourceName = resourceName.substring(iIndexOf + 1);
                    }
                    getTargetWidget(childAt.getId()).H0(resourceName);
                } catch (Resources.NotFoundException unused) {
                }
            }
        }
        if (this.mConstraintSetId != -1) {
            for (int i12 = 0; i12 < childCount; i12++) {
                View childAt2 = getChildAt(i12);
                if (childAt2.getId() == this.mConstraintSetId && (childAt2 instanceof androidx.constraintlayout.widget.d)) {
                    this.mConstraintSet = ((androidx.constraintlayout.widget.d) childAt2).getConstraintSet();
                }
            }
        }
        androidx.constraintlayout.widget.c cVar = this.mConstraintSet;
        if (cVar != null) {
            cVar.k(this, true);
        }
        this.mLayoutWidget.z1();
        int size = this.mConstraintHelpers.size();
        if (size > 0) {
            for (int i13 = 0; i13 < size; i13++) {
                this.mConstraintHelpers.get(i13).v(this);
            }
        }
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt3 = getChildAt(i14);
            if (childAt3 instanceof f) {
                ((f) childAt3).b(this);
            }
        }
        this.mTempMapIdToWidget.clear();
        this.mTempMapIdToWidget.put(0, this.mLayoutWidget);
        this.mTempMapIdToWidget.put(getId(), this.mLayoutWidget);
        for (int i15 = 0; i15 < childCount; i15++) {
            View childAt4 = getChildAt(i15);
            this.mTempMapIdToWidget.put(childAt4.getId(), getViewWidget(childAt4));
        }
        int i16 = 0;
        while (i16 < childCount) {
            View childAt5 = this.getChildAt(i16);
            ConstraintWidget viewWidget2 = this.getViewWidget(childAt5);
            if (viewWidget2 == null) {
                constraintLayout = this;
            } else {
                b bVar = (b) childAt5.getLayoutParams();
                this.mLayoutWidget.a(viewWidget2);
                constraintLayout = this;
                constraintLayout.applyConstraintsFromLayoutParams(zIsInEditMode, childAt5, viewWidget2, bVar, this.mTempMapIdToWidget);
            }
            i16++;
            this = constraintLayout;
        }
    }

    private void setWidgetBaseline(ConstraintWidget constraintWidget, b bVar, SparseArray<ConstraintWidget> sparseArray, int i10, ConstraintAnchor.Type type) {
        View view = this.mChildrenByIds.get(i10);
        ConstraintWidget constraintWidget2 = sparseArray.get(i10);
        if (constraintWidget2 == null || view == null || !(view.getLayoutParams() instanceof b)) {
            return;
        }
        bVar.f12639g0 = true;
        ConstraintAnchor.Type type2 = ConstraintAnchor.Type.BASELINE;
        if (type == type2) {
            b bVar2 = (b) view.getLayoutParams();
            bVar2.f12639g0 = true;
            bVar2.f12669v0.P0(true);
        }
        constraintWidget.q(type2).b(constraintWidget2.q(type), bVar.f12603D, bVar.f12602C, true);
        constraintWidget.P0(true);
        constraintWidget.q(ConstraintAnchor.Type.TOP).q();
        constraintWidget.q(ConstraintAnchor.Type.BOTTOM).q();
    }

    private boolean updateHierarchy() throws Resources.NotFoundException {
        int childCount = getChildCount();
        boolean z10 = false;
        int i10 = 0;
        while (true) {
            if (i10 >= childCount) {
                break;
            }
            if (getChildAt(i10).isLayoutRequested()) {
                z10 = true;
                break;
            }
            i10++;
        }
        if (z10) {
            setChildrenConstraints();
        }
        return z10;
    }

    public void addValueModifier(d dVar) {
        if (this.mModifiers == null) {
            this.mModifiers = new ArrayList<>();
        }
        this.mModifiers.add(dVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:75:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x017d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void applyConstraintsFromLayoutParams(boolean r15, android.view.View r16, androidx.constraintlayout.core.widgets.ConstraintWidget r17, androidx.constraintlayout.widget.ConstraintLayout.b r18, android.util.SparseArray<androidx.constraintlayout.core.widgets.ConstraintWidget> r19) {
        /*
            Method dump skipped, instructions count: 597
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.applyConstraintsFromLayoutParams(boolean, android.view.View, androidx.constraintlayout.core.widgets.ConstraintWidget, androidx.constraintlayout.widget.ConstraintLayout$b, android.util.SparseArray):void");
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Object tag;
        int size;
        ArrayList<androidx.constraintlayout.widget.a> arrayList = this.mConstraintHelpers;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            for (int i10 = 0; i10 < size; i10++) {
                this.mConstraintHelpers.get(i10).t(this);
            }
        }
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            float width = getWidth();
            float height = getHeight();
            int childCount = getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = getChildAt(i11);
                if (childAt.getVisibility() != 8 && (tag = childAt.getTag()) != null && (tag instanceof String)) {
                    String[] strArrSplit = ((String) tag).split(Const.STR_MART_COMMA);
                    if (strArrSplit.length == 4) {
                        int i12 = Integer.parseInt(strArrSplit[0]);
                        int i13 = Integer.parseInt(strArrSplit[1]);
                        int i14 = Integer.parseInt(strArrSplit[2]);
                        int i15 = (int) ((i12 / 1080.0f) * width);
                        int i16 = (int) ((i13 / 1920.0f) * height);
                        Paint paint = new Paint();
                        paint.setColor(-65536);
                        float f10 = i15;
                        float f11 = i16;
                        float f12 = i15 + ((int) ((i14 / 1080.0f) * width));
                        canvas.drawLine(f10, f11, f12, f11, paint);
                        float f13 = i16 + ((int) ((Integer.parseInt(strArrSplit[3]) / 1920.0f) * height));
                        canvas.drawLine(f12, f11, f12, f13, paint);
                        canvas.drawLine(f12, f13, f10, f13, paint);
                        canvas.drawLine(f10, f13, f10, f11, paint);
                        paint.setColor(-16711936);
                        canvas.drawLine(f10, f11, f12, f13, paint);
                        canvas.drawLine(f10, f13, f12, f11, paint);
                    }
                }
            }
        }
    }

    public boolean dynamicUpdateConstraints(int i10, int i11) {
        boolean zA = false;
        if (this.mModifiers == null) {
            return false;
        }
        int size = View.MeasureSpec.getSize(i10);
        int size2 = View.MeasureSpec.getSize(i11);
        Iterator<d> it = this.mModifiers.iterator();
        while (it.hasNext()) {
            d next = it.next();
            Iterator<ConstraintWidget> it2 = this.mLayoutWidget.w1().iterator();
            while (it2.hasNext()) {
                View view = (View) it2.next().u();
                zA |= next.a(size, size2, view.getId(), view, (b) view.getLayoutParams());
            }
        }
        return zA;
    }

    public void fillMetrics(C4856b c4856b) {
        this.mLayoutWidget.N1(c4856b);
    }

    @Override // android.view.View
    public void forceLayout() {
        markHierarchyDirty();
        super.forceLayout();
    }

    public Object getDesignInformation(int i10, Object obj) {
        if (i10 != 0 || !(obj instanceof String)) {
            return null;
        }
        String str = (String) obj;
        HashMap<String, Integer> map = this.mDesignIds;
        if (map == null || !map.containsKey(str)) {
            return null;
        }
        return this.mDesignIds.get(str);
    }

    public int getMaxHeight() {
        return this.mMaxHeight;
    }

    public int getMaxWidth() {
        return this.mMaxWidth;
    }

    public int getMinHeight() {
        return this.mMinHeight;
    }

    public int getMinWidth() {
        return this.mMinWidth;
    }

    public int getOptimizationLevel() {
        return this.mLayoutWidget.P1();
    }

    public String getSceneString() {
        int id;
        StringBuilder sb2 = new StringBuilder();
        if (this.mLayoutWidget.f12006o == null) {
            int id2 = getId();
            if (id2 != -1) {
                this.mLayoutWidget.f12006o = getContext().getResources().getResourceEntryName(id2);
            } else {
                this.mLayoutWidget.f12006o = "parent";
            }
        }
        if (this.mLayoutWidget.v() == null) {
            androidx.constraintlayout.core.widgets.d dVar = this.mLayoutWidget;
            dVar.H0(dVar.f12006o);
            Log.v(TAG, " setDebugName " + this.mLayoutWidget.v());
        }
        Iterator<ConstraintWidget> it = this.mLayoutWidget.w1().iterator();
        while (it.hasNext()) {
            ConstraintWidget next = it.next();
            View view = (View) next.u();
            if (view != null) {
                if (next.f12006o == null && (id = view.getId()) != -1) {
                    next.f12006o = getContext().getResources().getResourceEntryName(id);
                }
                if (next.v() == null) {
                    next.H0(next.f12006o);
                    Log.v(TAG, " setDebugName " + next.v());
                }
            }
        }
        this.mLayoutWidget.Q(sb2);
        return sb2.toString();
    }

    public View getViewById(int i10) {
        return this.mChildrenByIds.get(i10);
    }

    public final ConstraintWidget getViewWidget(View view) {
        if (view == this) {
            return this.mLayoutWidget;
        }
        if (view == null) {
            return null;
        }
        if (view.getLayoutParams() instanceof b) {
            return ((b) view.getLayoutParams()).f12669v0;
        }
        view.setLayoutParams(generateLayoutParams(view.getLayoutParams()));
        if (view.getLayoutParams() instanceof b) {
            return ((b) view.getLayoutParams()).f12669v0;
        }
        return null;
    }

    public boolean isRtl() {
        return (getContext().getApplicationInfo().flags & 4194304) != 0 && 1 == getLayoutDirection();
    }

    public void loadLayoutDescription(int i10) {
        if (i10 == 0) {
            this.mConstraintLayoutSpec = null;
            return;
        }
        try {
            this.mConstraintLayoutSpec = new androidx.constraintlayout.widget.b(getContext(), this, i10);
        } catch (Resources.NotFoundException unused) {
            this.mConstraintLayoutSpec = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        View content;
        int childCount = getChildCount();
        boolean zIsInEditMode = isInEditMode();
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt = getChildAt(i14);
            b bVar = (b) childAt.getLayoutParams();
            ConstraintWidget constraintWidget = bVar.f12669v0;
            if ((childAt.getVisibility() != 8 || bVar.f12641h0 || bVar.f12643i0 || bVar.f12647k0 || zIsInEditMode) && !bVar.f12645j0) {
                int iZ = constraintWidget.Z();
                int iA0 = constraintWidget.a0();
                int iY = constraintWidget.Y() + iZ;
                int iZ2 = constraintWidget.z() + iA0;
                childAt.layout(iZ, iA0, iY, iZ2);
                if ((childAt instanceof f) && (content = ((f) childAt).getContent()) != null) {
                    content.setVisibility(0);
                    content.layout(iZ, iA0, iY, iZ2);
                }
            }
        }
        int size = this.mConstraintHelpers.size();
        if (size > 0) {
            for (int i15 = 0; i15 < size; i15++) {
                this.mConstraintHelpers.get(i15).r(this);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        boolean zDynamicUpdateConstraints = this.mDirtyHierarchy | dynamicUpdateConstraints(i10, i11);
        this.mDirtyHierarchy = zDynamicUpdateConstraints;
        if (!zDynamicUpdateConstraints) {
            int childCount = getChildCount();
            int i12 = 0;
            while (true) {
                if (i12 >= childCount) {
                    break;
                }
                if (getChildAt(i12).isLayoutRequested()) {
                    this.mDirtyHierarchy = true;
                    break;
                }
                i12++;
            }
        }
        this.mOnMeasureWidthMeasureSpec = i10;
        this.mOnMeasureHeightMeasureSpec = i11;
        this.mLayoutWidget.e2(isRtl());
        if (this.mDirtyHierarchy) {
            this.mDirtyHierarchy = false;
            if (updateHierarchy()) {
                this.mLayoutWidget.g2();
            }
        }
        this.mLayoutWidget.N1(null);
        resolveSystem(this.mLayoutWidget, this.mOptimizationLevel, i10, i11);
        resolveMeasuredDimension(i10, i11, this.mLayoutWidget.Y(), this.mLayoutWidget.z(), this.mLayoutWidget.W1(), this.mLayoutWidget.U1());
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        ConstraintWidget viewWidget = getViewWidget(view);
        if ((view instanceof Guideline) && !(viewWidget instanceof androidx.constraintlayout.core.widgets.f)) {
            b bVar = (b) view.getLayoutParams();
            androidx.constraintlayout.core.widgets.f fVar = new androidx.constraintlayout.core.widgets.f();
            bVar.f12669v0 = fVar;
            bVar.f12641h0 = true;
            fVar.F1(bVar.f12625Z);
        }
        if (view instanceof androidx.constraintlayout.widget.a) {
            androidx.constraintlayout.widget.a aVar = (androidx.constraintlayout.widget.a) view;
            aVar.w();
            ((b) view.getLayoutParams()).f12643i0 = true;
            if (!this.mConstraintHelpers.contains(aVar)) {
                this.mConstraintHelpers.add(aVar);
            }
        }
        this.mChildrenByIds.put(view.getId(), view);
        this.mDirtyHierarchy = true;
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        this.mChildrenByIds.remove(view.getId());
        this.mLayoutWidget.y1(getViewWidget(view));
        this.mConstraintHelpers.remove(view);
        this.mDirtyHierarchy = true;
    }

    public void parseLayoutDescription(int i10) {
        this.mConstraintLayoutSpec = new androidx.constraintlayout.widget.b(getContext(), this, i10);
    }

    public void removeValueModifier(d dVar) {
        if (dVar == null) {
            return;
        }
        this.mModifiers.remove(dVar);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        markHierarchyDirty();
        super.requestLayout();
    }

    public void resolveMeasuredDimension(int i10, int i11, int i12, int i13, boolean z10, boolean z11) {
        c cVar = this.mMeasurer;
        int i14 = cVar.f12680e;
        int iResolveSizeAndState = View.resolveSizeAndState(i12 + cVar.f12679d, i10, 0);
        int iResolveSizeAndState2 = View.resolveSizeAndState(i13 + i14, i11, 0) & 16777215;
        int iMin = Math.min(this.mMaxWidth, iResolveSizeAndState & 16777215);
        int iMin2 = Math.min(this.mMaxHeight, iResolveSizeAndState2);
        if (z10) {
            iMin |= 16777216;
        }
        if (z11) {
            iMin2 |= 16777216;
        }
        setMeasuredDimension(iMin, iMin2);
        this.mLastMeasureWidth = iMin;
        this.mLastMeasureHeight = iMin2;
    }

    public void resolveSystem(androidx.constraintlayout.core.widgets.d dVar, int i10, int i11, int i12) {
        int i13;
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i11);
        int mode2 = View.MeasureSpec.getMode(i12);
        int size2 = View.MeasureSpec.getSize(i12);
        int iMax = Math.max(0, getPaddingTop());
        int iMax2 = Math.max(0, getPaddingBottom());
        int i14 = iMax + iMax2;
        int paddingWidth = getPaddingWidth();
        this.mMeasurer.c(i11, i12, iMax, iMax2, paddingWidth, i14);
        int iMax3 = Math.max(0, getPaddingStart());
        int iMax4 = Math.max(0, getPaddingEnd());
        if (iMax3 > 0 || iMax4 > 0) {
            if (isRtl()) {
                i13 = iMax4;
            }
            int i15 = size - paddingWidth;
            int i16 = size2 - i14;
            setSelfDimensionBehaviour(dVar, mode, i15, mode2, i16);
            dVar.X1(i10, mode, i15, mode2, i16, this.mLastMeasureWidth, this.mLastMeasureHeight, i13, iMax);
        }
        iMax3 = Math.max(0, getPaddingLeft());
        i13 = iMax3;
        int i152 = size - paddingWidth;
        int i162 = size2 - i14;
        setSelfDimensionBehaviour(dVar, mode, i152, mode2, i162);
        dVar.X1(i10, mode, i152, mode2, i162, this.mLastMeasureWidth, this.mLastMeasureHeight, i13, iMax);
    }

    public void setConstraintSet(androidx.constraintlayout.widget.c cVar) {
        this.mConstraintSet = cVar;
    }

    public void setDesignInformation(int i10, Object obj, Object obj2) {
        if (i10 == 0 && (obj instanceof String) && (obj2 instanceof Integer)) {
            if (this.mDesignIds == null) {
                this.mDesignIds = new HashMap<>();
            }
            String strSubstring = (String) obj;
            int iIndexOf = strSubstring.indexOf("/");
            if (iIndexOf != -1) {
                strSubstring = strSubstring.substring(iIndexOf + 1);
            }
            Integer num = (Integer) obj2;
            num.intValue();
            this.mDesignIds.put(strSubstring, num);
        }
    }

    @Override // android.view.View
    public void setId(int i10) {
        this.mChildrenByIds.remove(getId());
        super.setId(i10);
        this.mChildrenByIds.put(getId(), this);
    }

    public void setMaxHeight(int i10) {
        if (i10 == this.mMaxHeight) {
            return;
        }
        this.mMaxHeight = i10;
        requestLayout();
    }

    public void setMaxWidth(int i10) {
        if (i10 == this.mMaxWidth) {
            return;
        }
        this.mMaxWidth = i10;
        requestLayout();
    }

    public void setMinHeight(int i10) {
        if (i10 == this.mMinHeight) {
            return;
        }
        this.mMinHeight = i10;
        requestLayout();
    }

    public void setMinWidth(int i10) {
        if (i10 == this.mMinWidth) {
            return;
        }
        this.mMinWidth = i10;
        requestLayout();
    }

    public void setOnConstraintsChanged(e eVar) {
        androidx.constraintlayout.widget.b bVar = this.mConstraintLayoutSpec;
        if (bVar != null) {
            bVar.c(eVar);
        }
    }

    public void setOptimizationLevel(int i10) {
        this.mOptimizationLevel = i10;
        this.mLayoutWidget.c2(i10);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003e A[PHI: r2
      0x003e: PHI (r2v4 androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour) = 
      (r2v3 androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour)
      (r2v0 androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour)
     binds: [B:21:0x004a, B:17:0x003c] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setSelfDimensionBehaviour(androidx.constraintlayout.core.widgets.d r8, int r9, int r10, int r11, int r12) {
        /*
            r7 = this;
            androidx.constraintlayout.widget.ConstraintLayout$c r0 = r7.mMeasurer
            int r1 = r0.f12680e
            int r0 = r0.f12679d
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r2 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            int r3 = r7.getChildCount()
            r4 = 1073741824(0x40000000, float:2.0)
            r5 = 0
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r9 == r6) goto L2e
            if (r9 == 0) goto L23
            if (r9 == r4) goto L1a
            r9 = r2
        L18:
            r10 = r5
            goto L38
        L1a:
            int r9 = r7.mMaxWidth
            int r9 = r9 - r0
            int r10 = java.lang.Math.min(r9, r10)
            r9 = r2
            goto L38
        L23:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r9 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r3 != 0) goto L18
            int r10 = r7.mMinWidth
            int r10 = java.lang.Math.max(r5, r10)
            goto L38
        L2e:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r9 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r3 != 0) goto L38
            int r10 = r7.mMinWidth
            int r10 = java.lang.Math.max(r5, r10)
        L38:
            if (r11 == r6) goto L53
            if (r11 == 0) goto L48
            if (r11 == r4) goto L40
        L3e:
            r12 = r5
            goto L5d
        L40:
            int r11 = r7.mMaxHeight
            int r11 = r11 - r1
            int r12 = java.lang.Math.min(r11, r12)
            goto L5d
        L48:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r2 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r3 != 0) goto L3e
            int r11 = r7.mMinHeight
            int r12 = java.lang.Math.max(r5, r11)
            goto L5d
        L53:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r2 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r3 != 0) goto L5d
            int r11 = r7.mMinHeight
            int r12 = java.lang.Math.max(r5, r11)
        L5d:
            int r11 = r8.Y()
            if (r10 != r11) goto L69
            int r11 = r8.z()
            if (r12 == r11) goto L6c
        L69:
            r8.T1()
        L6c:
            r8.r1(r5)
            r8.s1(r5)
            int r11 = r7.mMaxWidth
            int r11 = r11 - r0
            r8.c1(r11)
            int r11 = r7.mMaxHeight
            int r11 = r11 - r1
            r8.b1(r11)
            r8.f1(r5)
            r8.e1(r5)
            r8.U0(r9)
            r8.p1(r10)
            r8.l1(r2)
            r8.Q0(r12)
            int r9 = r7.mMinWidth
            int r9 = r9 - r0
            r8.f1(r9)
            int r7 = r7.mMinHeight
            int r7 = r7 - r1
            r8.e1(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.setSelfDimensionBehaviour(androidx.constraintlayout.core.widgets.d, int, int, int, int):void");
    }

    public void setState(int i10, int i11, int i12) {
        androidx.constraintlayout.widget.b bVar = this.mConstraintLayoutSpec;
        if (bVar != null) {
            bVar.d(i10, i11, i12);
        }
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // android.view.ViewGroup
    public b generateDefaultLayoutParams() {
        return new b(-2, -2);
    }

    @Override // android.view.ViewGroup
    public b generateLayoutParams(AttributeSet attributeSet) {
        return new b(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new b(layoutParams);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mChildrenByIds = new SparseArray<>();
        this.mConstraintHelpers = new ArrayList<>(4);
        this.mLayoutWidget = new androidx.constraintlayout.core.widgets.d();
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mMaxWidth = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.mDirtyHierarchy = true;
        this.mOptimizationLevel = CustomCameraView.BUTTON_STATE_ONLY_CAPTURE;
        this.mConstraintSet = null;
        this.mConstraintLayoutSpec = null;
        this.mConstraintSetId = -1;
        this.mDesignIds = new HashMap<>();
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
        this.mTempMapIdToWidget = new SparseArray<>();
        this.mMeasurer = new c(this);
        this.mOnMeasureWidthMeasureSpec = 0;
        this.mOnMeasureHeightMeasureSpec = 0;
        init(attributeSet, 0, 0);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mChildrenByIds = new SparseArray<>();
        this.mConstraintHelpers = new ArrayList<>(4);
        this.mLayoutWidget = new androidx.constraintlayout.core.widgets.d();
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mMaxWidth = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.mDirtyHierarchy = true;
        this.mOptimizationLevel = CustomCameraView.BUTTON_STATE_ONLY_CAPTURE;
        this.mConstraintSet = null;
        this.mConstraintLayoutSpec = null;
        this.mConstraintSetId = -1;
        this.mDesignIds = new HashMap<>();
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
        this.mTempMapIdToWidget = new SparseArray<>();
        this.mMeasurer = new c(this);
        this.mOnMeasureWidthMeasureSpec = 0;
        this.mOnMeasureHeightMeasureSpec = 0;
        init(attributeSet, i10, 0);
    }

    @TargetApi(21)
    public ConstraintLayout(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.mChildrenByIds = new SparseArray<>();
        this.mConstraintHelpers = new ArrayList<>(4);
        this.mLayoutWidget = new androidx.constraintlayout.core.widgets.d();
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mMaxWidth = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.mDirtyHierarchy = true;
        this.mOptimizationLevel = CustomCameraView.BUTTON_STATE_ONLY_CAPTURE;
        this.mConstraintSet = null;
        this.mConstraintLayoutSpec = null;
        this.mConstraintSetId = -1;
        this.mDesignIds = new HashMap<>();
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
        this.mTempMapIdToWidget = new SparseArray<>();
        this.mMeasurer = new c(this);
        this.mOnMeasureWidthMeasureSpec = 0;
        this.mOnMeasureHeightMeasureSpec = 0;
        init(attributeSet, i10, i11);
    }

    public static class b extends ViewGroup.MarginLayoutParams {

        /* renamed from: A, reason: collision with root package name */
        public int f12600A;

        /* renamed from: B, reason: collision with root package name */
        public int f12601B;

        /* renamed from: C, reason: collision with root package name */
        public int f12602C;

        /* renamed from: D, reason: collision with root package name */
        public int f12603D;

        /* renamed from: E, reason: collision with root package name */
        public boolean f12604E;

        /* renamed from: F, reason: collision with root package name */
        public boolean f12605F;

        /* renamed from: G, reason: collision with root package name */
        public float f12606G;

        /* renamed from: H, reason: collision with root package name */
        public float f12607H;

        /* renamed from: I, reason: collision with root package name */
        public String f12608I;

        /* renamed from: J, reason: collision with root package name */
        public float f12609J;

        /* renamed from: K, reason: collision with root package name */
        public int f12610K;

        /* renamed from: L, reason: collision with root package name */
        public float f12611L;

        /* renamed from: M, reason: collision with root package name */
        public float f12612M;

        /* renamed from: N, reason: collision with root package name */
        public int f12613N;

        /* renamed from: O, reason: collision with root package name */
        public int f12614O;

        /* renamed from: P, reason: collision with root package name */
        public int f12615P;

        /* renamed from: Q, reason: collision with root package name */
        public int f12616Q;

        /* renamed from: R, reason: collision with root package name */
        public int f12617R;

        /* renamed from: S, reason: collision with root package name */
        public int f12618S;

        /* renamed from: T, reason: collision with root package name */
        public int f12619T;

        /* renamed from: U, reason: collision with root package name */
        public int f12620U;

        /* renamed from: V, reason: collision with root package name */
        public float f12621V;

        /* renamed from: W, reason: collision with root package name */
        public float f12622W;

        /* renamed from: X, reason: collision with root package name */
        public int f12623X;

        /* renamed from: Y, reason: collision with root package name */
        public int f12624Y;

        /* renamed from: Z, reason: collision with root package name */
        public int f12625Z;

        /* renamed from: a, reason: collision with root package name */
        public int f12626a;

        /* renamed from: a0, reason: collision with root package name */
        public boolean f12627a0;

        /* renamed from: b, reason: collision with root package name */
        public int f12628b;

        /* renamed from: b0, reason: collision with root package name */
        public boolean f12629b0;

        /* renamed from: c, reason: collision with root package name */
        public float f12630c;

        /* renamed from: c0, reason: collision with root package name */
        public String f12631c0;

        /* renamed from: d, reason: collision with root package name */
        public boolean f12632d;

        /* renamed from: d0, reason: collision with root package name */
        public int f12633d0;

        /* renamed from: e, reason: collision with root package name */
        public int f12634e;

        /* renamed from: e0, reason: collision with root package name */
        public boolean f12635e0;

        /* renamed from: f, reason: collision with root package name */
        public int f12636f;

        /* renamed from: f0, reason: collision with root package name */
        public boolean f12637f0;

        /* renamed from: g, reason: collision with root package name */
        public int f12638g;

        /* renamed from: g0, reason: collision with root package name */
        public boolean f12639g0;

        /* renamed from: h, reason: collision with root package name */
        public int f12640h;

        /* renamed from: h0, reason: collision with root package name */
        public boolean f12641h0;

        /* renamed from: i, reason: collision with root package name */
        public int f12642i;

        /* renamed from: i0, reason: collision with root package name */
        public boolean f12643i0;

        /* renamed from: j, reason: collision with root package name */
        public int f12644j;

        /* renamed from: j0, reason: collision with root package name */
        public boolean f12645j0;

        /* renamed from: k, reason: collision with root package name */
        public int f12646k;

        /* renamed from: k0, reason: collision with root package name */
        public boolean f12647k0;

        /* renamed from: l, reason: collision with root package name */
        public int f12648l;

        /* renamed from: l0, reason: collision with root package name */
        public int f12649l0;

        /* renamed from: m, reason: collision with root package name */
        public int f12650m;

        /* renamed from: m0, reason: collision with root package name */
        public int f12651m0;

        /* renamed from: n, reason: collision with root package name */
        public int f12652n;

        /* renamed from: n0, reason: collision with root package name */
        public int f12653n0;

        /* renamed from: o, reason: collision with root package name */
        public int f12654o;

        /* renamed from: o0, reason: collision with root package name */
        public int f12655o0;

        /* renamed from: p, reason: collision with root package name */
        public int f12656p;

        /* renamed from: p0, reason: collision with root package name */
        public int f12657p0;

        /* renamed from: q, reason: collision with root package name */
        public int f12658q;

        /* renamed from: q0, reason: collision with root package name */
        public int f12659q0;

        /* renamed from: r, reason: collision with root package name */
        public float f12660r;

        /* renamed from: r0, reason: collision with root package name */
        public float f12661r0;

        /* renamed from: s, reason: collision with root package name */
        public int f12662s;

        /* renamed from: s0, reason: collision with root package name */
        public int f12663s0;

        /* renamed from: t, reason: collision with root package name */
        public int f12664t;

        /* renamed from: t0, reason: collision with root package name */
        public int f12665t0;

        /* renamed from: u, reason: collision with root package name */
        public int f12666u;

        /* renamed from: u0, reason: collision with root package name */
        public float f12667u0;

        /* renamed from: v, reason: collision with root package name */
        public int f12668v;

        /* renamed from: v0, reason: collision with root package name */
        public ConstraintWidget f12669v0;

        /* renamed from: w, reason: collision with root package name */
        public int f12670w;

        /* renamed from: w0, reason: collision with root package name */
        public boolean f12671w0;

        /* renamed from: x, reason: collision with root package name */
        public int f12672x;

        /* renamed from: y, reason: collision with root package name */
        public int f12673y;

        /* renamed from: z, reason: collision with root package name */
        public int f12674z;

        public static class a {

            /* renamed from: a, reason: collision with root package name */
            public static final SparseIntArray f12675a;

            static {
                SparseIntArray sparseIntArray = new SparseIntArray();
                f12675a = sparseIntArray;
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintWidth, 64);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintHeight, 65);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintLeft_toLeftOf, 8);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintLeft_toRightOf, 9);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintRight_toLeftOf, 10);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintRight_toRightOf, 11);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintTop_toTopOf, 12);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintTop_toBottomOf, 13);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintBottom_toTopOf, 14);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintBottom_toBottomOf, 15);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintBaseline_toBaselineOf, 16);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintBaseline_toTopOf, 52);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintBaseline_toBottomOf, 53);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintCircle, 2);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintCircleRadius, 3);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintCircleAngle, 4);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_editor_absoluteX, 49);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_editor_absoluteY, 50);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintGuide_begin, 5);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintGuide_end, 6);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintGuide_percent, 7);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_guidelineUseRtl, 67);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_android_orientation, 1);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintStart_toEndOf, 17);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintStart_toStartOf, 18);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintEnd_toStartOf, 19);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintEnd_toEndOf, 20);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_goneMarginLeft, 21);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_goneMarginTop, 22);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_goneMarginRight, 23);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_goneMarginBottom, 24);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_goneMarginStart, 25);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_goneMarginEnd, 26);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_goneMarginBaseline, 55);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_marginBaseline, 54);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintHorizontal_bias, 29);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintVertical_bias, 30);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintDimensionRatio, 44);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintHorizontal_weight, 45);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintVertical_weight, 46);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintHorizontal_chainStyle, 47);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintVertical_chainStyle, 48);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constrainedWidth, 27);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constrainedHeight, 28);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintWidth_default, 31);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintHeight_default, 32);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintWidth_min, 33);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintWidth_max, 34);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintWidth_percent, 35);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintHeight_min, 36);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintHeight_max, 37);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintHeight_percent, 38);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintLeft_creator, 39);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintTop_creator, 40);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintRight_creator, 41);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintBottom_creator, 42);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintBaseline_creator, 43);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintTag, 51);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_wrapBehaviorInParent, 66);
            }
        }

        @SuppressLint({"ClassVerificationFailure"})
        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f12626a = -1;
            this.f12628b = -1;
            this.f12630c = -1.0f;
            this.f12632d = true;
            this.f12634e = -1;
            this.f12636f = -1;
            this.f12638g = -1;
            this.f12640h = -1;
            this.f12642i = -1;
            this.f12644j = -1;
            this.f12646k = -1;
            this.f12648l = -1;
            this.f12650m = -1;
            this.f12652n = -1;
            this.f12654o = -1;
            this.f12656p = -1;
            this.f12658q = 0;
            this.f12660r = 0.0f;
            this.f12662s = -1;
            this.f12664t = -1;
            this.f12666u = -1;
            this.f12668v = -1;
            this.f12670w = Integer.MIN_VALUE;
            this.f12672x = Integer.MIN_VALUE;
            this.f12673y = Integer.MIN_VALUE;
            this.f12674z = Integer.MIN_VALUE;
            this.f12600A = Integer.MIN_VALUE;
            this.f12601B = Integer.MIN_VALUE;
            this.f12602C = Integer.MIN_VALUE;
            this.f12603D = 0;
            this.f12604E = true;
            this.f12605F = true;
            this.f12606G = 0.5f;
            this.f12607H = 0.5f;
            this.f12608I = null;
            this.f12609J = 0.0f;
            this.f12610K = 1;
            this.f12611L = -1.0f;
            this.f12612M = -1.0f;
            this.f12613N = 0;
            this.f12614O = 0;
            this.f12615P = 0;
            this.f12616Q = 0;
            this.f12617R = 0;
            this.f12618S = 0;
            this.f12619T = 0;
            this.f12620U = 0;
            this.f12621V = 1.0f;
            this.f12622W = 1.0f;
            this.f12623X = -1;
            this.f12624Y = -1;
            this.f12625Z = -1;
            this.f12627a0 = false;
            this.f12629b0 = false;
            this.f12631c0 = null;
            this.f12633d0 = 0;
            this.f12635e0 = true;
            this.f12637f0 = true;
            this.f12639g0 = false;
            this.f12641h0 = false;
            this.f12643i0 = false;
            this.f12645j0 = false;
            this.f12647k0 = false;
            this.f12649l0 = -1;
            this.f12651m0 = -1;
            this.f12653n0 = -1;
            this.f12655o0 = -1;
            this.f12657p0 = Integer.MIN_VALUE;
            this.f12659q0 = Integer.MIN_VALUE;
            this.f12661r0 = 0.5f;
            this.f12669v0 = new ConstraintWidget();
            this.f12671w0 = false;
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                ((ViewGroup.MarginLayoutParams) this).leftMargin = marginLayoutParams.leftMargin;
                ((ViewGroup.MarginLayoutParams) this).rightMargin = marginLayoutParams.rightMargin;
                ((ViewGroup.MarginLayoutParams) this).topMargin = marginLayoutParams.topMargin;
                ((ViewGroup.MarginLayoutParams) this).bottomMargin = marginLayoutParams.bottomMargin;
                setMarginStart(marginLayoutParams.getMarginStart());
                setMarginEnd(marginLayoutParams.getMarginEnd());
            }
            if (layoutParams instanceof b) {
                b bVar = (b) layoutParams;
                this.f12626a = bVar.f12626a;
                this.f12628b = bVar.f12628b;
                this.f12630c = bVar.f12630c;
                this.f12632d = bVar.f12632d;
                this.f12634e = bVar.f12634e;
                this.f12636f = bVar.f12636f;
                this.f12638g = bVar.f12638g;
                this.f12640h = bVar.f12640h;
                this.f12642i = bVar.f12642i;
                this.f12644j = bVar.f12644j;
                this.f12646k = bVar.f12646k;
                this.f12648l = bVar.f12648l;
                this.f12650m = bVar.f12650m;
                this.f12652n = bVar.f12652n;
                this.f12654o = bVar.f12654o;
                this.f12656p = bVar.f12656p;
                this.f12658q = bVar.f12658q;
                this.f12660r = bVar.f12660r;
                this.f12662s = bVar.f12662s;
                this.f12664t = bVar.f12664t;
                this.f12666u = bVar.f12666u;
                this.f12668v = bVar.f12668v;
                this.f12670w = bVar.f12670w;
                this.f12672x = bVar.f12672x;
                this.f12673y = bVar.f12673y;
                this.f12674z = bVar.f12674z;
                this.f12600A = bVar.f12600A;
                this.f12601B = bVar.f12601B;
                this.f12602C = bVar.f12602C;
                this.f12603D = bVar.f12603D;
                this.f12606G = bVar.f12606G;
                this.f12607H = bVar.f12607H;
                this.f12608I = bVar.f12608I;
                this.f12609J = bVar.f12609J;
                this.f12610K = bVar.f12610K;
                this.f12611L = bVar.f12611L;
                this.f12612M = bVar.f12612M;
                this.f12613N = bVar.f12613N;
                this.f12614O = bVar.f12614O;
                this.f12627a0 = bVar.f12627a0;
                this.f12629b0 = bVar.f12629b0;
                this.f12615P = bVar.f12615P;
                this.f12616Q = bVar.f12616Q;
                this.f12617R = bVar.f12617R;
                this.f12619T = bVar.f12619T;
                this.f12618S = bVar.f12618S;
                this.f12620U = bVar.f12620U;
                this.f12621V = bVar.f12621V;
                this.f12622W = bVar.f12622W;
                this.f12623X = bVar.f12623X;
                this.f12624Y = bVar.f12624Y;
                this.f12625Z = bVar.f12625Z;
                this.f12635e0 = bVar.f12635e0;
                this.f12637f0 = bVar.f12637f0;
                this.f12639g0 = bVar.f12639g0;
                this.f12641h0 = bVar.f12641h0;
                this.f12649l0 = bVar.f12649l0;
                this.f12651m0 = bVar.f12651m0;
                this.f12653n0 = bVar.f12653n0;
                this.f12655o0 = bVar.f12655o0;
                this.f12657p0 = bVar.f12657p0;
                this.f12659q0 = bVar.f12659q0;
                this.f12661r0 = bVar.f12661r0;
                this.f12631c0 = bVar.f12631c0;
                this.f12633d0 = bVar.f12633d0;
                this.f12669v0 = bVar.f12669v0;
                this.f12604E = bVar.f12604E;
                this.f12605F = bVar.f12605F;
            }
        }

        public String a() {
            return this.f12631c0;
        }

        public void b() {
            this.f12641h0 = false;
            this.f12635e0 = true;
            this.f12637f0 = true;
            int i10 = ((ViewGroup.MarginLayoutParams) this).width;
            if (i10 == -2 && this.f12627a0) {
                this.f12635e0 = false;
                if (this.f12615P == 0) {
                    this.f12615P = 1;
                }
            }
            int i11 = ((ViewGroup.MarginLayoutParams) this).height;
            if (i11 == -2 && this.f12629b0) {
                this.f12637f0 = false;
                if (this.f12616Q == 0) {
                    this.f12616Q = 1;
                }
            }
            if (i10 == 0 || i10 == -1) {
                this.f12635e0 = false;
                if (i10 == 0 && this.f12615P == 1) {
                    ((ViewGroup.MarginLayoutParams) this).width = -2;
                    this.f12627a0 = true;
                }
            }
            if (i11 == 0 || i11 == -1) {
                this.f12637f0 = false;
                if (i11 == 0 && this.f12616Q == 1) {
                    ((ViewGroup.MarginLayoutParams) this).height = -2;
                    this.f12629b0 = true;
                }
            }
            if (this.f12630c == -1.0f && this.f12626a == -1 && this.f12628b == -1) {
                return;
            }
            this.f12641h0 = true;
            this.f12635e0 = true;
            this.f12637f0 = true;
            if (!(this.f12669v0 instanceof androidx.constraintlayout.core.widgets.f)) {
                this.f12669v0 = new androidx.constraintlayout.core.widgets.f();
            }
            ((androidx.constraintlayout.core.widgets.f) this.f12669v0).F1(this.f12625Z);
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x004a  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0051  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0058  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x005e  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0064  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x007a  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x0082  */
        @Override // android.view.ViewGroup.MarginLayoutParams, android.view.ViewGroup.LayoutParams
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void resolveLayoutDirection(int r11) {
            /*
                Method dump skipped, instructions count: 259
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.b.resolveLayoutDirection(int):void");
        }

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f12626a = -1;
            this.f12628b = -1;
            this.f12630c = -1.0f;
            this.f12632d = true;
            this.f12634e = -1;
            this.f12636f = -1;
            this.f12638g = -1;
            this.f12640h = -1;
            this.f12642i = -1;
            this.f12644j = -1;
            this.f12646k = -1;
            this.f12648l = -1;
            this.f12650m = -1;
            this.f12652n = -1;
            this.f12654o = -1;
            this.f12656p = -1;
            this.f12658q = 0;
            this.f12660r = 0.0f;
            this.f12662s = -1;
            this.f12664t = -1;
            this.f12666u = -1;
            this.f12668v = -1;
            this.f12670w = Integer.MIN_VALUE;
            this.f12672x = Integer.MIN_VALUE;
            this.f12673y = Integer.MIN_VALUE;
            this.f12674z = Integer.MIN_VALUE;
            this.f12600A = Integer.MIN_VALUE;
            this.f12601B = Integer.MIN_VALUE;
            this.f12602C = Integer.MIN_VALUE;
            this.f12603D = 0;
            this.f12604E = true;
            this.f12605F = true;
            this.f12606G = 0.5f;
            this.f12607H = 0.5f;
            this.f12608I = null;
            this.f12609J = 0.0f;
            this.f12610K = 1;
            this.f12611L = -1.0f;
            this.f12612M = -1.0f;
            this.f12613N = 0;
            this.f12614O = 0;
            this.f12615P = 0;
            this.f12616Q = 0;
            this.f12617R = 0;
            this.f12618S = 0;
            this.f12619T = 0;
            this.f12620U = 0;
            this.f12621V = 1.0f;
            this.f12622W = 1.0f;
            this.f12623X = -1;
            this.f12624Y = -1;
            this.f12625Z = -1;
            this.f12627a0 = false;
            this.f12629b0 = false;
            this.f12631c0 = null;
            this.f12633d0 = 0;
            this.f12635e0 = true;
            this.f12637f0 = true;
            this.f12639g0 = false;
            this.f12641h0 = false;
            this.f12643i0 = false;
            this.f12645j0 = false;
            this.f12647k0 = false;
            this.f12649l0 = -1;
            this.f12651m0 = -1;
            this.f12653n0 = -1;
            this.f12655o0 = -1;
            this.f12657p0 = Integer.MIN_VALUE;
            this.f12659q0 = Integer.MIN_VALUE;
            this.f12661r0 = 0.5f;
            this.f12669v0 = new ConstraintWidget();
            this.f12671w0 = false;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ConstraintLayout_Layout);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                int i11 = a.f12675a.get(index);
                switch (i11) {
                    case 1:
                        this.f12625Z = typedArrayObtainStyledAttributes.getInt(index, this.f12625Z);
                        break;
                    case 2:
                        int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, this.f12656p);
                        this.f12656p = resourceId;
                        if (resourceId == -1) {
                            this.f12656p = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        this.f12658q = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f12658q);
                        break;
                    case 4:
                        float f10 = typedArrayObtainStyledAttributes.getFloat(index, this.f12660r) % 360.0f;
                        this.f12660r = f10;
                        if (f10 < 0.0f) {
                            this.f12660r = (360.0f - f10) % 360.0f;
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        this.f12626a = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f12626a);
                        break;
                    case 6:
                        this.f12628b = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f12628b);
                        break;
                    case 7:
                        this.f12630c = typedArrayObtainStyledAttributes.getFloat(index, this.f12630c);
                        break;
                    case 8:
                        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(index, this.f12634e);
                        this.f12634e = resourceId2;
                        if (resourceId2 == -1) {
                            this.f12634e = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 9:
                        int resourceId3 = typedArrayObtainStyledAttributes.getResourceId(index, this.f12636f);
                        this.f12636f = resourceId3;
                        if (resourceId3 == -1) {
                            this.f12636f = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        int resourceId4 = typedArrayObtainStyledAttributes.getResourceId(index, this.f12638g);
                        this.f12638g = resourceId4;
                        if (resourceId4 == -1) {
                            this.f12638g = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        int resourceId5 = typedArrayObtainStyledAttributes.getResourceId(index, this.f12640h);
                        this.f12640h = resourceId5;
                        if (resourceId5 == -1) {
                            this.f12640h = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        int resourceId6 = typedArrayObtainStyledAttributes.getResourceId(index, this.f12642i);
                        this.f12642i = resourceId6;
                        if (resourceId6 == -1) {
                            this.f12642i = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        int resourceId7 = typedArrayObtainStyledAttributes.getResourceId(index, this.f12644j);
                        this.f12644j = resourceId7;
                        if (resourceId7 == -1) {
                            this.f12644j = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        int resourceId8 = typedArrayObtainStyledAttributes.getResourceId(index, this.f12646k);
                        this.f12646k = resourceId8;
                        if (resourceId8 == -1) {
                            this.f12646k = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        int resourceId9 = typedArrayObtainStyledAttributes.getResourceId(index, this.f12648l);
                        this.f12648l = resourceId9;
                        if (resourceId9 == -1) {
                            this.f12648l = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        int resourceId10 = typedArrayObtainStyledAttributes.getResourceId(index, this.f12650m);
                        this.f12650m = resourceId10;
                        if (resourceId10 == -1) {
                            this.f12650m = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        int resourceId11 = typedArrayObtainStyledAttributes.getResourceId(index, this.f12662s);
                        this.f12662s = resourceId11;
                        if (resourceId11 == -1) {
                            this.f12662s = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        int resourceId12 = typedArrayObtainStyledAttributes.getResourceId(index, this.f12664t);
                        this.f12664t = resourceId12;
                        if (resourceId12 == -1) {
                            this.f12664t = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 19:
                        int resourceId13 = typedArrayObtainStyledAttributes.getResourceId(index, this.f12666u);
                        this.f12666u = resourceId13;
                        if (resourceId13 == -1) {
                            this.f12666u = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 20:
                        int resourceId14 = typedArrayObtainStyledAttributes.getResourceId(index, this.f12668v);
                        this.f12668v = resourceId14;
                        if (resourceId14 == -1) {
                            this.f12668v = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 21:
                        this.f12670w = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f12670w);
                        break;
                    case 22:
                        this.f12672x = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f12672x);
                        break;
                    case 23:
                        this.f12673y = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f12673y);
                        break;
                    case 24:
                        this.f12674z = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f12674z);
                        break;
                    case 25:
                        this.f12600A = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f12600A);
                        break;
                    case 26:
                        this.f12601B = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f12601B);
                        break;
                    case 27:
                        this.f12627a0 = typedArrayObtainStyledAttributes.getBoolean(index, this.f12627a0);
                        break;
                    case 28:
                        this.f12629b0 = typedArrayObtainStyledAttributes.getBoolean(index, this.f12629b0);
                        break;
                    case 29:
                        this.f12606G = typedArrayObtainStyledAttributes.getFloat(index, this.f12606G);
                        break;
                    case 30:
                        this.f12607H = typedArrayObtainStyledAttributes.getFloat(index, this.f12607H);
                        break;
                    case 31:
                        int i12 = typedArrayObtainStyledAttributes.getInt(index, 0);
                        this.f12615P = i12;
                        if (i12 == 1) {
                            Log.e(ConstraintLayout.TAG, "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
                            break;
                        } else {
                            break;
                        }
                    case 32:
                        int i13 = typedArrayObtainStyledAttributes.getInt(index, 0);
                        this.f12616Q = i13;
                        if (i13 == 1) {
                            Log.e(ConstraintLayout.TAG, "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
                            break;
                        } else {
                            break;
                        }
                    case 33:
                        try {
                            this.f12617R = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f12617R);
                            break;
                        } catch (Exception unused) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.f12617R) == -2) {
                                this.f12617R = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 34:
                        try {
                            this.f12619T = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f12619T);
                            break;
                        } catch (Exception unused2) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.f12619T) == -2) {
                                this.f12619T = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 35:
                        this.f12621V = Math.max(0.0f, typedArrayObtainStyledAttributes.getFloat(index, this.f12621V));
                        this.f12615P = 2;
                        break;
                    case 36:
                        try {
                            this.f12618S = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f12618S);
                            break;
                        } catch (Exception unused3) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.f12618S) == -2) {
                                this.f12618S = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 37:
                        try {
                            this.f12620U = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f12620U);
                            break;
                        } catch (Exception unused4) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.f12620U) == -2) {
                                this.f12620U = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 38:
                        this.f12622W = Math.max(0.0f, typedArrayObtainStyledAttributes.getFloat(index, this.f12622W));
                        this.f12616Q = 2;
                        break;
                    default:
                        switch (i11) {
                            case 44:
                                androidx.constraintlayout.widget.c.O(this, typedArrayObtainStyledAttributes.getString(index));
                                break;
                            case 45:
                                this.f12611L = typedArrayObtainStyledAttributes.getFloat(index, this.f12611L);
                                break;
                            case 46:
                                this.f12612M = typedArrayObtainStyledAttributes.getFloat(index, this.f12612M);
                                break;
                            case 47:
                                this.f12613N = typedArrayObtainStyledAttributes.getInt(index, 0);
                                break;
                            case 48:
                                this.f12614O = typedArrayObtainStyledAttributes.getInt(index, 0);
                                break;
                            case 49:
                                this.f12623X = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f12623X);
                                break;
                            case 50:
                                this.f12624Y = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f12624Y);
                                break;
                            case 51:
                                this.f12631c0 = typedArrayObtainStyledAttributes.getString(index);
                                break;
                            case 52:
                                int resourceId15 = typedArrayObtainStyledAttributes.getResourceId(index, this.f12652n);
                                this.f12652n = resourceId15;
                                if (resourceId15 == -1) {
                                    this.f12652n = typedArrayObtainStyledAttributes.getInt(index, -1);
                                    break;
                                } else {
                                    break;
                                }
                            case 53:
                                int resourceId16 = typedArrayObtainStyledAttributes.getResourceId(index, this.f12654o);
                                this.f12654o = resourceId16;
                                if (resourceId16 == -1) {
                                    this.f12654o = typedArrayObtainStyledAttributes.getInt(index, -1);
                                    break;
                                } else {
                                    break;
                                }
                            case 54:
                                this.f12603D = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f12603D);
                                break;
                            case 55:
                                this.f12602C = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f12602C);
                                break;
                            default:
                                switch (i11) {
                                    case 64:
                                        androidx.constraintlayout.widget.c.M(this, typedArrayObtainStyledAttributes, index, 0);
                                        this.f12604E = true;
                                        break;
                                    case 65:
                                        androidx.constraintlayout.widget.c.M(this, typedArrayObtainStyledAttributes, index, 1);
                                        this.f12605F = true;
                                        break;
                                    case 66:
                                        this.f12633d0 = typedArrayObtainStyledAttributes.getInt(index, this.f12633d0);
                                        break;
                                    case 67:
                                        this.f12632d = typedArrayObtainStyledAttributes.getBoolean(index, this.f12632d);
                                        break;
                                }
                        }
                }
            }
            typedArrayObtainStyledAttributes.recycle();
            b();
        }

        public b(int i10, int i11) {
            super(i10, i11);
            this.f12626a = -1;
            this.f12628b = -1;
            this.f12630c = -1.0f;
            this.f12632d = true;
            this.f12634e = -1;
            this.f12636f = -1;
            this.f12638g = -1;
            this.f12640h = -1;
            this.f12642i = -1;
            this.f12644j = -1;
            this.f12646k = -1;
            this.f12648l = -1;
            this.f12650m = -1;
            this.f12652n = -1;
            this.f12654o = -1;
            this.f12656p = -1;
            this.f12658q = 0;
            this.f12660r = 0.0f;
            this.f12662s = -1;
            this.f12664t = -1;
            this.f12666u = -1;
            this.f12668v = -1;
            this.f12670w = Integer.MIN_VALUE;
            this.f12672x = Integer.MIN_VALUE;
            this.f12673y = Integer.MIN_VALUE;
            this.f12674z = Integer.MIN_VALUE;
            this.f12600A = Integer.MIN_VALUE;
            this.f12601B = Integer.MIN_VALUE;
            this.f12602C = Integer.MIN_VALUE;
            this.f12603D = 0;
            this.f12604E = true;
            this.f12605F = true;
            this.f12606G = 0.5f;
            this.f12607H = 0.5f;
            this.f12608I = null;
            this.f12609J = 0.0f;
            this.f12610K = 1;
            this.f12611L = -1.0f;
            this.f12612M = -1.0f;
            this.f12613N = 0;
            this.f12614O = 0;
            this.f12615P = 0;
            this.f12616Q = 0;
            this.f12617R = 0;
            this.f12618S = 0;
            this.f12619T = 0;
            this.f12620U = 0;
            this.f12621V = 1.0f;
            this.f12622W = 1.0f;
            this.f12623X = -1;
            this.f12624Y = -1;
            this.f12625Z = -1;
            this.f12627a0 = false;
            this.f12629b0 = false;
            this.f12631c0 = null;
            this.f12633d0 = 0;
            this.f12635e0 = true;
            this.f12637f0 = true;
            this.f12639g0 = false;
            this.f12641h0 = false;
            this.f12643i0 = false;
            this.f12645j0 = false;
            this.f12647k0 = false;
            this.f12649l0 = -1;
            this.f12651m0 = -1;
            this.f12653n0 = -1;
            this.f12655o0 = -1;
            this.f12657p0 = Integer.MIN_VALUE;
            this.f12659q0 = Integer.MIN_VALUE;
            this.f12661r0 = 0.5f;
            this.f12669v0 = new ConstraintWidget();
            this.f12671w0 = false;
        }
    }
}
