package androidx.constraintlayout.widget;

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
import com.stepos.policy.sdk.bean.PolicyBasicListVO;
import java.util.ArrayList;
import java.util.HashMap;
import v.d;
import v.e;
import v.l;
import w.C1196b;

/* loaded from: classes.dex */
public class ConstraintLayout extends ViewGroup {

    /* renamed from: x, reason: collision with root package name */
    private static j f8775x;

    /* renamed from: a, reason: collision with root package name */
    SparseArray<View> f8776a;

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<androidx.constraintlayout.widget.b> f8777b;

    /* renamed from: c, reason: collision with root package name */
    protected v.f f8778c;

    /* renamed from: d, reason: collision with root package name */
    private int f8779d;

    /* renamed from: e, reason: collision with root package name */
    private int f8780e;

    /* renamed from: f, reason: collision with root package name */
    private int f8781f;

    /* renamed from: g, reason: collision with root package name */
    private int f8782g;

    /* renamed from: h, reason: collision with root package name */
    protected boolean f8783h;

    /* renamed from: i, reason: collision with root package name */
    private int f8784i;

    /* renamed from: j, reason: collision with root package name */
    private d f8785j;

    /* renamed from: k, reason: collision with root package name */
    protected androidx.constraintlayout.widget.c f8786k;

    /* renamed from: l, reason: collision with root package name */
    private int f8787l;

    /* renamed from: m, reason: collision with root package name */
    private HashMap<String, Integer> f8788m;

    /* renamed from: n, reason: collision with root package name */
    private int f8789n;

    /* renamed from: o, reason: collision with root package name */
    private int f8790o;

    /* renamed from: p, reason: collision with root package name */
    int f8791p;

    /* renamed from: q, reason: collision with root package name */
    int f8792q;

    /* renamed from: r, reason: collision with root package name */
    int f8793r;

    /* renamed from: s, reason: collision with root package name */
    int f8794s;

    /* renamed from: t, reason: collision with root package name */
    private SparseArray<v.e> f8795t;

    /* renamed from: u, reason: collision with root package name */
    c f8796u;

    /* renamed from: v, reason: collision with root package name */
    private int f8797v;

    /* renamed from: w, reason: collision with root package name */
    private int f8798w;

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f8799a;

        static {
            int[] iArr = new int[e.b.values().length];
            f8799a = iArr;
            try {
                iArr[e.b.FIXED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8799a[e.b.WRAP_CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8799a[e.b.MATCH_PARENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f8799a[e.b.MATCH_CONSTRAINT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    class c implements C1196b.InterfaceC0254b {

        /* renamed from: a, reason: collision with root package name */
        ConstraintLayout f8876a;

        /* renamed from: b, reason: collision with root package name */
        int f8877b;

        /* renamed from: c, reason: collision with root package name */
        int f8878c;

        /* renamed from: d, reason: collision with root package name */
        int f8879d;

        /* renamed from: e, reason: collision with root package name */
        int f8880e;

        /* renamed from: f, reason: collision with root package name */
        int f8881f;

        /* renamed from: g, reason: collision with root package name */
        int f8882g;

        public c(ConstraintLayout constraintLayout) {
            this.f8876a = constraintLayout;
        }

        private boolean d(int i5, int i6, int i7) {
            if (i5 == i6) {
                return true;
            }
            int mode = View.MeasureSpec.getMode(i5);
            View.MeasureSpec.getSize(i5);
            int mode2 = View.MeasureSpec.getMode(i6);
            int size = View.MeasureSpec.getSize(i6);
            if (mode2 == 1073741824) {
                return (mode == Integer.MIN_VALUE || mode == 0) && i7 == size;
            }
            return false;
        }

        @Override // w.C1196b.InterfaceC0254b
        public final void a() {
            int childCount = this.f8876a.getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = this.f8876a.getChildAt(i5);
                if (childAt instanceof g) {
                    ((g) childAt).a(this.f8876a);
                }
            }
            int size = this.f8876a.f8777b.size();
            if (size > 0) {
                for (int i6 = 0; i6 < size; i6++) {
                    ((androidx.constraintlayout.widget.b) this.f8876a.f8777b.get(i6)).p(this.f8876a);
                }
            }
        }

        @Override // w.C1196b.InterfaceC0254b
        public final void b(v.e eVar, C1196b.a aVar) {
            int iMakeMeasureSpec;
            int iMakeMeasureSpec2;
            int baseline;
            int iMax;
            int iMax2;
            int i5;
            if (eVar == null) {
                return;
            }
            if (eVar.V() == 8 && !eVar.j0()) {
                aVar.f23399e = 0;
                aVar.f23400f = 0;
                aVar.f23401g = 0;
                return;
            }
            if (eVar.K() == null) {
                return;
            }
            e.b bVar = aVar.f23395a;
            e.b bVar2 = aVar.f23396b;
            int i6 = aVar.f23397c;
            int i7 = aVar.f23398d;
            int i8 = this.f8877b + this.f8878c;
            int i9 = this.f8879d;
            View view = (View) eVar.s();
            int[] iArr = a.f8799a;
            int i10 = iArr[bVar.ordinal()];
            if (i10 == 1) {
                iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i6, 1073741824);
            } else if (i10 == 2) {
                iMakeMeasureSpec = ViewGroup.getChildMeasureSpec(this.f8881f, i9, -2);
            } else if (i10 == 3) {
                iMakeMeasureSpec = ViewGroup.getChildMeasureSpec(this.f8881f, i9 + eVar.B(), -1);
            } else if (i10 != 4) {
                iMakeMeasureSpec = 0;
            } else {
                iMakeMeasureSpec = ViewGroup.getChildMeasureSpec(this.f8881f, i9, -2);
                boolean z5 = eVar.f23100w == 1;
                int i11 = aVar.f23404j;
                if (i11 == C1196b.a.f23393l || i11 == C1196b.a.f23394m) {
                    boolean z6 = view.getMeasuredHeight() == eVar.x();
                    if (aVar.f23404j == C1196b.a.f23394m || !z5 || ((z5 && z6) || (view instanceof g) || eVar.n0())) {
                        iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(eVar.W(), 1073741824);
                    }
                }
            }
            int i12 = iArr[bVar2.ordinal()];
            if (i12 == 1) {
                iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i7, 1073741824);
            } else if (i12 == 2) {
                iMakeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.f8882g, i8, -2);
            } else if (i12 == 3) {
                iMakeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.f8882g, i8 + eVar.U(), -1);
            } else if (i12 != 4) {
                iMakeMeasureSpec2 = 0;
            } else {
                iMakeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.f8882g, i8, -2);
                boolean z7 = eVar.f23102x == 1;
                int i13 = aVar.f23404j;
                if (i13 == C1196b.a.f23393l || i13 == C1196b.a.f23394m) {
                    boolean z8 = view.getMeasuredWidth() == eVar.W();
                    if (aVar.f23404j == C1196b.a.f23394m || !z7 || ((z7 && z8) || (view instanceof g) || eVar.o0())) {
                        iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(eVar.x(), 1073741824);
                    }
                }
            }
            v.f fVar = (v.f) eVar.K();
            if (fVar != null && v.k.b(ConstraintLayout.this.f8784i, 256) && view.getMeasuredWidth() == eVar.W() && view.getMeasuredWidth() < fVar.W() && view.getMeasuredHeight() == eVar.x() && view.getMeasuredHeight() < fVar.x() && view.getBaseline() == eVar.p() && !eVar.m0() && d(eVar.C(), iMakeMeasureSpec, eVar.W()) && d(eVar.D(), iMakeMeasureSpec2, eVar.x())) {
                aVar.f23399e = eVar.W();
                aVar.f23400f = eVar.x();
                aVar.f23401g = eVar.p();
                return;
            }
            e.b bVar3 = e.b.MATCH_CONSTRAINT;
            boolean z9 = bVar == bVar3;
            boolean z10 = bVar2 == bVar3;
            e.b bVar4 = e.b.MATCH_PARENT;
            boolean z11 = bVar2 == bVar4 || bVar2 == e.b.FIXED;
            boolean z12 = bVar == bVar4 || bVar == e.b.FIXED;
            boolean z13 = z9 && eVar.f23063d0 > 0.0f;
            boolean z14 = z10 && eVar.f23063d0 > 0.0f;
            if (view == null) {
                return;
            }
            b bVar5 = (b) view.getLayoutParams();
            int i14 = aVar.f23404j;
            if (i14 != C1196b.a.f23393l && i14 != C1196b.a.f23394m && z9 && eVar.f23100w == 0 && z10 && eVar.f23102x == 0) {
                i5 = -1;
                iMax2 = 0;
                baseline = 0;
                iMax = 0;
            } else {
                if ((view instanceof k) && (eVar instanceof l)) {
                    ((k) view).t((l) eVar, iMakeMeasureSpec, iMakeMeasureSpec2);
                } else {
                    view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                }
                eVar.V0(iMakeMeasureSpec, iMakeMeasureSpec2);
                int measuredWidth = view.getMeasuredWidth();
                int measuredHeight = view.getMeasuredHeight();
                baseline = view.getBaseline();
                int i15 = eVar.f23106z;
                iMax = i15 > 0 ? Math.max(i15, measuredWidth) : measuredWidth;
                int i16 = eVar.f23020A;
                if (i16 > 0) {
                    iMax = Math.min(i16, iMax);
                }
                int i17 = eVar.f23024C;
                iMax2 = i17 > 0 ? Math.max(i17, measuredHeight) : measuredHeight;
                boolean z15 = z12;
                int i18 = eVar.f23026D;
                if (i18 > 0) {
                    iMax2 = Math.min(i18, iMax2);
                }
                if (!v.k.b(ConstraintLayout.this.f8784i, 1)) {
                    if (z13 && z11) {
                        iMax = (int) ((iMax2 * eVar.f23063d0) + 0.5f);
                    } else if (z14 && z15) {
                        iMax2 = (int) ((iMax / eVar.f23063d0) + 0.5f);
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
                    eVar.V0(iMakeMeasureSpec, iMakeMeasureSpec2);
                    iMax = view.getMeasuredWidth();
                    iMax2 = view.getMeasuredHeight();
                    baseline = view.getBaseline();
                }
                i5 = -1;
            }
            boolean z16 = baseline != i5;
            aVar.f23403i = (iMax == aVar.f23397c && iMax2 == aVar.f23398d) ? false : true;
            if (bVar5.f8839g0) {
                z16 = true;
            }
            if (z16 && baseline != -1 && eVar.p() != baseline) {
                aVar.f23403i = true;
            }
            aVar.f23399e = iMax;
            aVar.f23400f = iMax2;
            aVar.f23402h = z16;
            aVar.f23401g = baseline;
        }

        public void c(int i5, int i6, int i7, int i8, int i9, int i10) {
            this.f8877b = i7;
            this.f8878c = i8;
            this.f8879d = i9;
            this.f8880e = i10;
            this.f8881f = i5;
            this.f8882g = i6;
        }
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8776a = new SparseArray<>();
        this.f8777b = new ArrayList<>(4);
        this.f8778c = new v.f();
        this.f8779d = 0;
        this.f8780e = 0;
        this.f8781f = Integer.MAX_VALUE;
        this.f8782g = Integer.MAX_VALUE;
        this.f8783h = true;
        this.f8784i = 257;
        this.f8785j = null;
        this.f8786k = null;
        this.f8787l = -1;
        this.f8788m = new HashMap<>();
        this.f8789n = -1;
        this.f8790o = -1;
        this.f8791p = -1;
        this.f8792q = -1;
        this.f8793r = 0;
        this.f8794s = 0;
        this.f8795t = new SparseArray<>();
        this.f8796u = new c(this);
        this.f8797v = 0;
        this.f8798w = 0;
        q(attributeSet, 0, 0);
    }

    private boolean A() throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        int childCount = getChildCount();
        boolean z5 = false;
        int i5 = 0;
        while (true) {
            if (i5 >= childCount) {
                break;
            }
            if (getChildAt(i5).isLayoutRequested()) {
                z5 = true;
                break;
            }
            i5++;
        }
        if (z5) {
            w();
        }
        return z5;
    }

    private int getPaddingWidth() {
        int iMax = Math.max(0, getPaddingLeft()) + Math.max(0, getPaddingRight());
        int iMax2 = Math.max(0, getPaddingStart()) + Math.max(0, getPaddingEnd());
        return iMax2 > 0 ? iMax2 : iMax;
    }

    public static j getSharedValues() {
        if (f8775x == null) {
            f8775x = new j();
        }
        return f8775x;
    }

    private final v.e h(int i5) {
        if (i5 == 0) {
            return this.f8778c;
        }
        View viewFindViewById = this.f8776a.get(i5);
        if (viewFindViewById == null && (viewFindViewById = findViewById(i5)) != null && viewFindViewById != this && viewFindViewById.getParent() == this) {
            onViewAdded(viewFindViewById);
        }
        if (viewFindViewById == this) {
            return this.f8778c;
        }
        if (viewFindViewById == null) {
            return null;
        }
        return ((b) viewFindViewById.getLayoutParams()).f8869v0;
    }

    private void q(AttributeSet attributeSet, int i5, int i6) {
        this.f8778c.B0(this);
        this.f8778c.V1(this.f8796u);
        this.f8776a.put(getId(), this);
        this.f8785j = null;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, i.f9319n1, i5, i6);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i7 = 0; i7 < indexCount; i7++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i7);
                if (index == i.f9379x1) {
                    this.f8779d = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f8779d);
                } else if (index == i.f9385y1) {
                    this.f8780e = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f8780e);
                } else if (index == i.f9367v1) {
                    this.f8781f = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f8781f);
                } else if (index == i.f9373w1) {
                    this.f8782g = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f8782g);
                } else if (index == i.f9279g3) {
                    this.f8784i = typedArrayObtainStyledAttributes.getInt(index, this.f8784i);
                } else if (index == i.f9244b2) {
                    int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, 0);
                    if (resourceId != 0) {
                        try {
                            t(resourceId);
                        } catch (Resources.NotFoundException unused) {
                            this.f8786k = null;
                        }
                    }
                } else if (index == i.f9110F1) {
                    int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(index, 0);
                    try {
                        d dVar = new d();
                        this.f8785j = dVar;
                        dVar.s(getContext(), resourceId2);
                    } catch (Resources.NotFoundException unused2) {
                        this.f8785j = null;
                    }
                    this.f8787l = resourceId2;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        this.f8778c.W1(this.f8784i);
    }

    private void s() {
        this.f8783h = true;
        this.f8789n = -1;
        this.f8790o = -1;
        this.f8791p = -1;
        this.f8792q = -1;
        this.f8793r = 0;
        this.f8794s = 0;
    }

    private void w() throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        ConstraintLayout constraintLayout;
        boolean zIsInEditMode = isInEditMode();
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            v.e eVarP = p(getChildAt(i5));
            if (eVarP != null) {
                eVarP.t0();
            }
        }
        if (zIsInEditMode) {
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = getChildAt(i6);
                try {
                    String resourceName = getResources().getResourceName(childAt.getId());
                    x(0, resourceName, Integer.valueOf(childAt.getId()));
                    int iIndexOf = resourceName.indexOf(47);
                    if (iIndexOf != -1) {
                        resourceName = resourceName.substring(iIndexOf + 1);
                    }
                    h(childAt.getId()).C0(resourceName);
                } catch (Resources.NotFoundException unused) {
                }
            }
        }
        if (this.f8787l != -1) {
            for (int i7 = 0; i7 < childCount; i7++) {
                View childAt2 = getChildAt(i7);
                if (childAt2.getId() == this.f8787l && (childAt2 instanceof e)) {
                    this.f8785j = ((e) childAt2).getConstraintSet();
                }
            }
        }
        d dVar = this.f8785j;
        if (dVar != null) {
            dVar.d(this, true);
        }
        this.f8778c.u1();
        int size = this.f8777b.size();
        if (size > 0) {
            for (int i8 = 0; i8 < size; i8++) {
                this.f8777b.get(i8).r(this);
            }
        }
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt3 = getChildAt(i9);
            if (childAt3 instanceof g) {
                ((g) childAt3).b(this);
            }
        }
        this.f8795t.clear();
        this.f8795t.put(0, this.f8778c);
        this.f8795t.put(getId(), this.f8778c);
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt4 = getChildAt(i10);
            this.f8795t.put(childAt4.getId(), p(childAt4));
        }
        int i11 = 0;
        while (i11 < childCount) {
            View childAt5 = this.getChildAt(i11);
            v.e eVarP2 = this.p(childAt5);
            if (eVarP2 == null) {
                constraintLayout = this;
            } else {
                b bVar = (b) childAt5.getLayoutParams();
                this.f8778c.b(eVarP2);
                constraintLayout = this;
                constraintLayout.d(zIsInEditMode, childAt5, eVarP2, bVar, this.f8795t);
            }
            i11++;
            this = constraintLayout;
        }
    }

    private void z(v.e eVar, b bVar, SparseArray<v.e> sparseArray, int i5, d.b bVar2) {
        View view = this.f8776a.get(i5);
        v.e eVar2 = sparseArray.get(i5);
        if (eVar2 == null || view == null || !(view.getLayoutParams() instanceof b)) {
            return;
        }
        bVar.f8839g0 = true;
        d.b bVar3 = d.b.BASELINE;
        if (bVar2 == bVar3) {
            b bVar4 = (b) view.getLayoutParams();
            bVar4.f8839g0 = true;
            bVar4.f8869v0.K0(true);
        }
        eVar.o(bVar3).b(eVar2.o(bVar2), bVar.f8803D, bVar.f8802C, true);
        eVar.K0(true);
        eVar.o(d.b.TOP).q();
        eVar.o(d.b.BOTTOM).q();
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof b;
    }

    /* JADX WARN: Removed duplicated region for block: B:75:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x017d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void d(boolean r15, android.view.View r16, v.e r17, androidx.constraintlayout.widget.ConstraintLayout.b r18, android.util.SparseArray<v.e> r19) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 597
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.d(boolean, android.view.View, v.e, androidx.constraintlayout.widget.ConstraintLayout$b, android.util.SparseArray):void");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) throws NumberFormatException {
        Object tag;
        int size;
        ArrayList<androidx.constraintlayout.widget.b> arrayList = this.f8777b;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            for (int i5 = 0; i5 < size; i5++) {
                this.f8777b.get(i5).q(this);
            }
        }
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            float width = getWidth();
            float height = getHeight();
            int childCount = getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = getChildAt(i6);
                if (childAt.getVisibility() != 8 && (tag = childAt.getTag()) != null && (tag instanceof String)) {
                    String[] strArrSplit = ((String) tag).split(",");
                    if (strArrSplit.length == 4) {
                        int i7 = Integer.parseInt(strArrSplit[0]);
                        int i8 = Integer.parseInt(strArrSplit[1]);
                        int i9 = Integer.parseInt(strArrSplit[2]);
                        int i10 = (int) ((i7 / 1080.0f) * width);
                        int i11 = (int) ((i8 / 1920.0f) * height);
                        Paint paint = new Paint();
                        paint.setColor(-65536);
                        float f5 = i10;
                        float f6 = i11;
                        float f7 = i10 + ((int) ((i9 / 1080.0f) * width));
                        canvas.drawLine(f5, f6, f7, f6, paint);
                        float f8 = i11 + ((int) ((Integer.parseInt(strArrSplit[3]) / 1920.0f) * height));
                        canvas.drawLine(f7, f6, f7, f8, paint);
                        canvas.drawLine(f7, f8, f5, f8, paint);
                        canvas.drawLine(f5, f8, f5, f6, paint);
                        paint.setColor(-16711936);
                        canvas.drawLine(f5, f6, f7, f8, paint);
                        canvas.drawLine(f5, f8, f7, f6, paint);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public b generateDefaultLayoutParams() {
        return new b(-2, -2);
    }

    @Override // android.view.ViewGroup
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public b generateLayoutParams(AttributeSet attributeSet) {
        return new b(getContext(), attributeSet);
    }

    @Override // android.view.View
    public void forceLayout() {
        s();
        super.forceLayout();
    }

    public Object g(int i5, Object obj) {
        if (i5 != 0 || !(obj instanceof String)) {
            return null;
        }
        String str = (String) obj;
        HashMap<String, Integer> map = this.f8788m;
        if (map == null || !map.containsKey(str)) {
            return null;
        }
        return this.f8788m.get(str);
    }

    public int getMaxHeight() {
        return this.f8782g;
    }

    public int getMaxWidth() {
        return this.f8781f;
    }

    public int getMinHeight() {
        return this.f8780e;
    }

    public int getMinWidth() {
        return this.f8779d;
    }

    public int getOptimizationLevel() {
        return this.f8778c.J1();
    }

    public String getSceneString() {
        int id;
        StringBuilder sb = new StringBuilder();
        if (this.f8778c.f23084o == null) {
            int id2 = getId();
            if (id2 != -1) {
                this.f8778c.f23084o = getContext().getResources().getResourceEntryName(id2);
            } else {
                this.f8778c.f23084o = "parent";
            }
        }
        if (this.f8778c.t() == null) {
            v.f fVar = this.f8778c;
            fVar.C0(fVar.f23084o);
            Log.v("ConstraintLayout", " setDebugName " + this.f8778c.t());
        }
        ArrayList<v.e> arrayListR1 = this.f8778c.r1();
        int size = arrayListR1.size();
        int i5 = 0;
        while (i5 < size) {
            v.e eVar = arrayListR1.get(i5);
            i5++;
            v.e eVar2 = eVar;
            View view = (View) eVar2.s();
            if (view != null) {
                if (eVar2.f23084o == null && (id = view.getId()) != -1) {
                    eVar2.f23084o = getContext().getResources().getResourceEntryName(id);
                }
                if (eVar2.t() == null) {
                    eVar2.C0(eVar2.f23084o);
                    Log.v("ConstraintLayout", " setDebugName " + eVar2.t());
                }
            }
        }
        this.f8778c.O(sb);
        return sb.toString();
    }

    public View i(int i5) {
        return this.f8776a.get(i5);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z5, int i5, int i6, int i7, int i8) {
        View content;
        int childCount = getChildCount();
        boolean zIsInEditMode = isInEditMode();
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            b bVar = (b) childAt.getLayoutParams();
            v.e eVar = bVar.f8869v0;
            if ((childAt.getVisibility() != 8 || bVar.f8841h0 || bVar.f8843i0 || bVar.f8847k0 || zIsInEditMode) && !bVar.f8845j0) {
                int iX = eVar.X();
                int iY = eVar.Y();
                int iW = eVar.W() + iX;
                int iX2 = eVar.x() + iY;
                childAt.layout(iX, iY, iW, iX2);
                if ((childAt instanceof g) && (content = ((g) childAt).getContent()) != null) {
                    content.setVisibility(0);
                    content.layout(iX, iY, iW, iX2);
                }
            }
        }
        int size = this.f8777b.size();
        if (size > 0) {
            for (int i10 = 0; i10 < size; i10++) {
                this.f8777b.get(i10).o(this);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i5, int i6) {
        if (this.f8797v == i5) {
            int i7 = this.f8798w;
        }
        if (!this.f8783h) {
            int childCount = getChildCount();
            int i8 = 0;
            while (true) {
                if (i8 >= childCount) {
                    break;
                }
                if (getChildAt(i8).isLayoutRequested()) {
                    this.f8783h = true;
                    break;
                }
                i8++;
            }
        }
        this.f8797v = i5;
        this.f8798w = i6;
        this.f8778c.Y1(r());
        if (this.f8783h) {
            this.f8783h = false;
            if (A()) {
                this.f8778c.a2();
            }
        }
        v(this.f8778c, this.f8784i, i5, i6);
        u(i5, i6, this.f8778c.W(), this.f8778c.x(), this.f8778c.Q1(), this.f8778c.O1());
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        v.e eVarP = p(view);
        if ((view instanceof Guideline) && !(eVarP instanceof v.h)) {
            b bVar = (b) view.getLayoutParams();
            v.h hVar = new v.h();
            bVar.f8869v0 = hVar;
            bVar.f8841h0 = true;
            hVar.A1(bVar.f8825Z);
        }
        if (view instanceof androidx.constraintlayout.widget.b) {
            androidx.constraintlayout.widget.b bVar2 = (androidx.constraintlayout.widget.b) view;
            bVar2.s();
            ((b) view.getLayoutParams()).f8843i0 = true;
            if (!this.f8777b.contains(bVar2)) {
                this.f8777b.add(bVar2);
            }
        }
        this.f8776a.put(view.getId(), view);
        this.f8783h = true;
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        this.f8776a.remove(view.getId());
        this.f8778c.t1(p(view));
        this.f8777b.remove(view);
        this.f8783h = true;
    }

    public final v.e p(View view) {
        if (view == this) {
            return this.f8778c;
        }
        if (view == null) {
            return null;
        }
        if (view.getLayoutParams() instanceof b) {
            return ((b) view.getLayoutParams()).f8869v0;
        }
        view.setLayoutParams(generateLayoutParams(view.getLayoutParams()));
        if (view.getLayoutParams() instanceof b) {
            return ((b) view.getLayoutParams()).f8869v0;
        }
        return null;
    }

    protected boolean r() {
        return (getContext().getApplicationInfo().flags & 4194304) != 0 && 1 == getLayoutDirection();
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        s();
        super.requestLayout();
    }

    public void setConstraintSet(d dVar) {
        this.f8785j = dVar;
    }

    @Override // android.view.View
    public void setId(int i5) {
        this.f8776a.remove(getId());
        super.setId(i5);
        this.f8776a.put(getId(), this);
    }

    public void setMaxHeight(int i5) {
        if (i5 == this.f8782g) {
            return;
        }
        this.f8782g = i5;
        requestLayout();
    }

    public void setMaxWidth(int i5) {
        if (i5 == this.f8781f) {
            return;
        }
        this.f8781f = i5;
        requestLayout();
    }

    public void setMinHeight(int i5) {
        if (i5 == this.f8780e) {
            return;
        }
        this.f8780e = i5;
        requestLayout();
    }

    public void setMinWidth(int i5) {
        if (i5 == this.f8779d) {
            return;
        }
        this.f8779d = i5;
        requestLayout();
    }

    public void setOnConstraintsChanged(f fVar) {
        androidx.constraintlayout.widget.c cVar = this.f8786k;
        if (cVar != null) {
            cVar.c(fVar);
        }
    }

    public void setOptimizationLevel(int i5) {
        this.f8784i = i5;
        this.f8778c.W1(i5);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    protected void t(int i5) {
        this.f8786k = new androidx.constraintlayout.widget.c(getContext(), this, i5);
    }

    protected void u(int i5, int i6, int i7, int i8, boolean z5, boolean z6) {
        c cVar = this.f8796u;
        int i9 = cVar.f8880e;
        int iResolveSizeAndState = View.resolveSizeAndState(i7 + cVar.f8879d, i5, 0);
        int iResolveSizeAndState2 = View.resolveSizeAndState(i8 + i9, i6, 0) & 16777215;
        int iMin = Math.min(this.f8781f, iResolveSizeAndState & 16777215);
        int iMin2 = Math.min(this.f8782g, iResolveSizeAndState2);
        if (z5) {
            iMin |= 16777216;
        }
        if (z6) {
            iMin2 |= 16777216;
        }
        setMeasuredDimension(iMin, iMin2);
        this.f8789n = iMin;
        this.f8790o = iMin2;
    }

    protected void v(v.f fVar, int i5, int i6, int i7) {
        int i8;
        int mode = View.MeasureSpec.getMode(i6);
        int size = View.MeasureSpec.getSize(i6);
        int mode2 = View.MeasureSpec.getMode(i7);
        int size2 = View.MeasureSpec.getSize(i7);
        int iMax = Math.max(0, getPaddingTop());
        int iMax2 = Math.max(0, getPaddingBottom());
        int i9 = iMax + iMax2;
        int paddingWidth = getPaddingWidth();
        this.f8796u.c(i6, i7, iMax, iMax2, paddingWidth, i9);
        int iMax3 = Math.max(0, getPaddingStart());
        int iMax4 = Math.max(0, getPaddingEnd());
        if (iMax3 > 0 || iMax4 > 0) {
            if (r()) {
                i8 = iMax4;
            }
            int i10 = size - paddingWidth;
            int i11 = size2 - i9;
            y(fVar, mode, i10, mode2, i11);
            fVar.R1(i5, mode, i10, mode2, i11, this.f8789n, this.f8790o, i8, iMax);
        }
        iMax3 = Math.max(0, getPaddingLeft());
        i8 = iMax3;
        int i102 = size - paddingWidth;
        int i112 = size2 - i9;
        y(fVar, mode, i102, mode2, i112);
        fVar.R1(i5, mode, i102, mode2, i112, this.f8789n, this.f8790o, i8, iMax);
    }

    public void x(int i5, Object obj, Object obj2) {
        if (i5 == 0 && (obj instanceof String) && (obj2 instanceof Integer)) {
            if (this.f8788m == null) {
                this.f8788m = new HashMap<>();
            }
            String strSubstring = (String) obj;
            int iIndexOf = strSubstring.indexOf("/");
            if (iIndexOf != -1) {
                strSubstring = strSubstring.substring(iIndexOf + 1);
            }
            Integer num = (Integer) obj2;
            num.intValue();
            this.f8788m.put(strSubstring, num);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003e A[PHI: r2
      0x003e: PHI (r2v4 v.e$b) = (r2v3 v.e$b), (r2v0 v.e$b) binds: [B:21:0x004a, B:17:0x003c] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void y(v.f r8, int r9, int r10, int r11, int r12) {
        /*
            r7 = this;
            androidx.constraintlayout.widget.ConstraintLayout$c r0 = r7.f8796u
            int r1 = r0.f8880e
            int r0 = r0.f8879d
            v.e$b r2 = v.e.b.FIXED
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
            int r9 = r7.f8781f
            int r9 = r9 - r0
            int r10 = java.lang.Math.min(r9, r10)
            r9 = r2
            goto L38
        L23:
            v.e$b r9 = v.e.b.WRAP_CONTENT
            if (r3 != 0) goto L18
            int r10 = r7.f8779d
            int r10 = java.lang.Math.max(r5, r10)
            goto L38
        L2e:
            v.e$b r9 = v.e.b.WRAP_CONTENT
            if (r3 != 0) goto L38
            int r10 = r7.f8779d
            int r10 = java.lang.Math.max(r5, r10)
        L38:
            if (r11 == r6) goto L53
            if (r11 == 0) goto L48
            if (r11 == r4) goto L40
        L3e:
            r12 = r5
            goto L5d
        L40:
            int r11 = r7.f8782g
            int r11 = r11 - r1
            int r12 = java.lang.Math.min(r11, r12)
            goto L5d
        L48:
            v.e$b r2 = v.e.b.WRAP_CONTENT
            if (r3 != 0) goto L3e
            int r11 = r7.f8780e
            int r12 = java.lang.Math.max(r5, r11)
            goto L5d
        L53:
            v.e$b r2 = v.e.b.WRAP_CONTENT
            if (r3 != 0) goto L5d
            int r11 = r7.f8780e
            int r12 = java.lang.Math.max(r5, r11)
        L5d:
            int r11 = r8.W()
            if (r10 != r11) goto L69
            int r11 = r8.x()
            if (r12 == r11) goto L6c
        L69:
            r8.N1()
        L6c:
            r8.m1(r5)
            r8.n1(r5)
            int r11 = r7.f8781f
            int r11 = r11 - r0
            r8.X0(r11)
            int r11 = r7.f8782g
            int r11 = r11 - r1
            r8.W0(r11)
            r8.a1(r5)
            r8.Z0(r5)
            r8.P0(r9)
            r8.k1(r10)
            r8.g1(r2)
            r8.L0(r12)
            int r9 = r7.f8779d
            int r9 = r9 - r0
            r8.a1(r9)
            int r7 = r7.f8780e
            int r7 = r7 - r1
            r8.Z0(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.y(v.f, int, int, int, int):void");
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new b(layoutParams);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.f8776a = new SparseArray<>();
        this.f8777b = new ArrayList<>(4);
        this.f8778c = new v.f();
        this.f8779d = 0;
        this.f8780e = 0;
        this.f8781f = Integer.MAX_VALUE;
        this.f8782g = Integer.MAX_VALUE;
        this.f8783h = true;
        this.f8784i = 257;
        this.f8785j = null;
        this.f8786k = null;
        this.f8787l = -1;
        this.f8788m = new HashMap<>();
        this.f8789n = -1;
        this.f8790o = -1;
        this.f8791p = -1;
        this.f8792q = -1;
        this.f8793r = 0;
        this.f8794s = 0;
        this.f8795t = new SparseArray<>();
        this.f8796u = new c(this);
        this.f8797v = 0;
        this.f8798w = 0;
        q(attributeSet, i5, 0);
    }

    public static class b extends ViewGroup.MarginLayoutParams {

        /* renamed from: A, reason: collision with root package name */
        public int f8800A;

        /* renamed from: B, reason: collision with root package name */
        public int f8801B;

        /* renamed from: C, reason: collision with root package name */
        public int f8802C;

        /* renamed from: D, reason: collision with root package name */
        public int f8803D;

        /* renamed from: E, reason: collision with root package name */
        boolean f8804E;

        /* renamed from: F, reason: collision with root package name */
        boolean f8805F;

        /* renamed from: G, reason: collision with root package name */
        public float f8806G;

        /* renamed from: H, reason: collision with root package name */
        public float f8807H;

        /* renamed from: I, reason: collision with root package name */
        public String f8808I;

        /* renamed from: J, reason: collision with root package name */
        float f8809J;

        /* renamed from: K, reason: collision with root package name */
        int f8810K;

        /* renamed from: L, reason: collision with root package name */
        public float f8811L;

        /* renamed from: M, reason: collision with root package name */
        public float f8812M;

        /* renamed from: N, reason: collision with root package name */
        public int f8813N;

        /* renamed from: O, reason: collision with root package name */
        public int f8814O;

        /* renamed from: P, reason: collision with root package name */
        public int f8815P;

        /* renamed from: Q, reason: collision with root package name */
        public int f8816Q;

        /* renamed from: R, reason: collision with root package name */
        public int f8817R;

        /* renamed from: S, reason: collision with root package name */
        public int f8818S;

        /* renamed from: T, reason: collision with root package name */
        public int f8819T;

        /* renamed from: U, reason: collision with root package name */
        public int f8820U;

        /* renamed from: V, reason: collision with root package name */
        public float f8821V;

        /* renamed from: W, reason: collision with root package name */
        public float f8822W;

        /* renamed from: X, reason: collision with root package name */
        public int f8823X;

        /* renamed from: Y, reason: collision with root package name */
        public int f8824Y;

        /* renamed from: Z, reason: collision with root package name */
        public int f8825Z;

        /* renamed from: a, reason: collision with root package name */
        public int f8826a;

        /* renamed from: a0, reason: collision with root package name */
        public boolean f8827a0;

        /* renamed from: b, reason: collision with root package name */
        public int f8828b;

        /* renamed from: b0, reason: collision with root package name */
        public boolean f8829b0;

        /* renamed from: c, reason: collision with root package name */
        public float f8830c;

        /* renamed from: c0, reason: collision with root package name */
        public String f8831c0;

        /* renamed from: d, reason: collision with root package name */
        public boolean f8832d;

        /* renamed from: d0, reason: collision with root package name */
        public int f8833d0;

        /* renamed from: e, reason: collision with root package name */
        public int f8834e;

        /* renamed from: e0, reason: collision with root package name */
        boolean f8835e0;

        /* renamed from: f, reason: collision with root package name */
        public int f8836f;

        /* renamed from: f0, reason: collision with root package name */
        boolean f8837f0;

        /* renamed from: g, reason: collision with root package name */
        public int f8838g;

        /* renamed from: g0, reason: collision with root package name */
        boolean f8839g0;

        /* renamed from: h, reason: collision with root package name */
        public int f8840h;

        /* renamed from: h0, reason: collision with root package name */
        boolean f8841h0;

        /* renamed from: i, reason: collision with root package name */
        public int f8842i;

        /* renamed from: i0, reason: collision with root package name */
        boolean f8843i0;

        /* renamed from: j, reason: collision with root package name */
        public int f8844j;

        /* renamed from: j0, reason: collision with root package name */
        boolean f8845j0;

        /* renamed from: k, reason: collision with root package name */
        public int f8846k;

        /* renamed from: k0, reason: collision with root package name */
        boolean f8847k0;

        /* renamed from: l, reason: collision with root package name */
        public int f8848l;

        /* renamed from: l0, reason: collision with root package name */
        int f8849l0;

        /* renamed from: m, reason: collision with root package name */
        public int f8850m;

        /* renamed from: m0, reason: collision with root package name */
        int f8851m0;

        /* renamed from: n, reason: collision with root package name */
        public int f8852n;

        /* renamed from: n0, reason: collision with root package name */
        int f8853n0;

        /* renamed from: o, reason: collision with root package name */
        public int f8854o;

        /* renamed from: o0, reason: collision with root package name */
        int f8855o0;

        /* renamed from: p, reason: collision with root package name */
        public int f8856p;

        /* renamed from: p0, reason: collision with root package name */
        int f8857p0;

        /* renamed from: q, reason: collision with root package name */
        public int f8858q;

        /* renamed from: q0, reason: collision with root package name */
        int f8859q0;

        /* renamed from: r, reason: collision with root package name */
        public float f8860r;

        /* renamed from: r0, reason: collision with root package name */
        float f8861r0;

        /* renamed from: s, reason: collision with root package name */
        public int f8862s;

        /* renamed from: s0, reason: collision with root package name */
        int f8863s0;

        /* renamed from: t, reason: collision with root package name */
        public int f8864t;

        /* renamed from: t0, reason: collision with root package name */
        int f8865t0;

        /* renamed from: u, reason: collision with root package name */
        public int f8866u;

        /* renamed from: u0, reason: collision with root package name */
        float f8867u0;

        /* renamed from: v, reason: collision with root package name */
        public int f8868v;

        /* renamed from: v0, reason: collision with root package name */
        v.e f8869v0;

        /* renamed from: w, reason: collision with root package name */
        public int f8870w;

        /* renamed from: w0, reason: collision with root package name */
        public boolean f8871w0;

        /* renamed from: x, reason: collision with root package name */
        public int f8872x;

        /* renamed from: y, reason: collision with root package name */
        public int f8873y;

        /* renamed from: z, reason: collision with root package name */
        public int f8874z;

        private static class a {

            /* renamed from: a, reason: collision with root package name */
            public static final SparseIntArray f8875a;

            static {
                SparseIntArray sparseIntArray = new SparseIntArray();
                f8875a = sparseIntArray;
                sparseIntArray.append(i.f9183R2, 64);
                sparseIntArray.append(i.f9362u2, 65);
                sparseIntArray.append(i.f9099D2, 8);
                sparseIntArray.append(i.f9105E2, 9);
                sparseIntArray.append(i.f9117G2, 10);
                sparseIntArray.append(i.f9123H2, 11);
                sparseIntArray.append(i.f9159N2, 12);
                sparseIntArray.append(i.f9153M2, 13);
                sparseIntArray.append(i.f9302k2, 14);
                sparseIntArray.append(i.f9296j2, 15);
                sparseIntArray.append(i.f9272f2, 16);
                sparseIntArray.append(i.f9284h2, 52);
                sparseIntArray.append(i.f9278g2, 53);
                sparseIntArray.append(i.f9308l2, 2);
                sparseIntArray.append(i.f9320n2, 3);
                sparseIntArray.append(i.f9314m2, 4);
                sparseIntArray.append(i.f9213W2, 49);
                sparseIntArray.append(i.f9219X2, 50);
                sparseIntArray.append(i.f9344r2, 5);
                sparseIntArray.append(i.f9350s2, 6);
                sparseIntArray.append(i.f9356t2, 7);
                sparseIntArray.append(i.f9237a2, 67);
                sparseIntArray.append(i.f9325o1, 1);
                sparseIntArray.append(i.f9129I2, 17);
                sparseIntArray.append(i.f9135J2, 18);
                sparseIntArray.append(i.f9338q2, 19);
                sparseIntArray.append(i.f9332p2, 20);
                sparseIntArray.append(i.f9245b3, 21);
                sparseIntArray.append(i.f9266e3, 22);
                sparseIntArray.append(i.f9252c3, 23);
                sparseIntArray.append(i.f9231Z2, 24);
                sparseIntArray.append(i.f9259d3, 25);
                sparseIntArray.append(i.f9238a3, 26);
                sparseIntArray.append(i.f9225Y2, 55);
                sparseIntArray.append(i.f9273f3, 54);
                sparseIntArray.append(i.f9392z2, 29);
                sparseIntArray.append(i.f9165O2, 30);
                sparseIntArray.append(i.f9326o2, 44);
                sparseIntArray.append(i.f9087B2, 45);
                sparseIntArray.append(i.f9177Q2, 46);
                sparseIntArray.append(i.f9081A2, 47);
                sparseIntArray.append(i.f9171P2, 48);
                sparseIntArray.append(i.f9258d2, 27);
                sparseIntArray.append(i.f9251c2, 28);
                sparseIntArray.append(i.f9189S2, 31);
                sparseIntArray.append(i.f9368v2, 32);
                sparseIntArray.append(i.f9201U2, 33);
                sparseIntArray.append(i.f9195T2, 34);
                sparseIntArray.append(i.f9207V2, 35);
                sparseIntArray.append(i.f9380x2, 36);
                sparseIntArray.append(i.f9374w2, 37);
                sparseIntArray.append(i.f9386y2, 38);
                sparseIntArray.append(i.f9093C2, 39);
                sparseIntArray.append(i.f9147L2, 40);
                sparseIntArray.append(i.f9111F2, 41);
                sparseIntArray.append(i.f9290i2, 42);
                sparseIntArray.append(i.f9265e2, 43);
                sparseIntArray.append(i.f9141K2, 51);
                sparseIntArray.append(i.f9285h3, 66);
            }
        }

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f8826a = -1;
            this.f8828b = -1;
            this.f8830c = -1.0f;
            this.f8832d = true;
            this.f8834e = -1;
            this.f8836f = -1;
            this.f8838g = -1;
            this.f8840h = -1;
            this.f8842i = -1;
            this.f8844j = -1;
            this.f8846k = -1;
            this.f8848l = -1;
            this.f8850m = -1;
            this.f8852n = -1;
            this.f8854o = -1;
            this.f8856p = -1;
            this.f8858q = 0;
            this.f8860r = 0.0f;
            this.f8862s = -1;
            this.f8864t = -1;
            this.f8866u = -1;
            this.f8868v = -1;
            this.f8870w = Integer.MIN_VALUE;
            this.f8872x = Integer.MIN_VALUE;
            this.f8873y = Integer.MIN_VALUE;
            this.f8874z = Integer.MIN_VALUE;
            this.f8800A = Integer.MIN_VALUE;
            this.f8801B = Integer.MIN_VALUE;
            this.f8802C = Integer.MIN_VALUE;
            this.f8803D = 0;
            this.f8804E = true;
            this.f8805F = true;
            this.f8806G = 0.5f;
            this.f8807H = 0.5f;
            this.f8808I = null;
            this.f8809J = 0.0f;
            this.f8810K = 1;
            this.f8811L = -1.0f;
            this.f8812M = -1.0f;
            this.f8813N = 0;
            this.f8814O = 0;
            this.f8815P = 0;
            this.f8816Q = 0;
            this.f8817R = 0;
            this.f8818S = 0;
            this.f8819T = 0;
            this.f8820U = 0;
            this.f8821V = 1.0f;
            this.f8822W = 1.0f;
            this.f8823X = -1;
            this.f8824Y = -1;
            this.f8825Z = -1;
            this.f8827a0 = false;
            this.f8829b0 = false;
            this.f8831c0 = null;
            this.f8833d0 = 0;
            this.f8835e0 = true;
            this.f8837f0 = true;
            this.f8839g0 = false;
            this.f8841h0 = false;
            this.f8843i0 = false;
            this.f8845j0 = false;
            this.f8847k0 = false;
            this.f8849l0 = -1;
            this.f8851m0 = -1;
            this.f8853n0 = -1;
            this.f8855o0 = -1;
            this.f8857p0 = Integer.MIN_VALUE;
            this.f8859q0 = Integer.MIN_VALUE;
            this.f8861r0 = 0.5f;
            this.f8869v0 = new v.e();
            this.f8871w0 = false;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.f9319n1);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i5 = 0; i5 < indexCount; i5++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i5);
                int i6 = a.f8875a.get(index);
                switch (i6) {
                    case 1:
                        this.f8825Z = typedArrayObtainStyledAttributes.getInt(index, this.f8825Z);
                        break;
                    case 2:
                        int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, this.f8856p);
                        this.f8856p = resourceId;
                        if (resourceId == -1) {
                            this.f8856p = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        this.f8858q = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f8858q);
                        break;
                    case 4:
                        float f5 = typedArrayObtainStyledAttributes.getFloat(index, this.f8860r) % 360.0f;
                        this.f8860r = f5;
                        if (f5 < 0.0f) {
                            this.f8860r = (360.0f - f5) % 360.0f;
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        this.f8826a = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f8826a);
                        break;
                    case 6:
                        this.f8828b = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f8828b);
                        break;
                    case 7:
                        this.f8830c = typedArrayObtainStyledAttributes.getFloat(index, this.f8830c);
                        break;
                    case 8:
                        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(index, this.f8834e);
                        this.f8834e = resourceId2;
                        if (resourceId2 == -1) {
                            this.f8834e = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_BUTTON /* 9 */:
                        int resourceId3 = typedArrayObtainStyledAttributes.getResourceId(index, this.f8836f);
                        this.f8836f = resourceId3;
                        if (resourceId3 == -1) {
                            this.f8836f = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_LINK /* 10 */:
                        int resourceId4 = typedArrayObtainStyledAttributes.getResourceId(index, this.f8838g);
                        this.f8838g = resourceId4;
                        if (resourceId4 == -1) {
                            this.f8838g = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_POINT /* 11 */:
                        int resourceId5 = typedArrayObtainStyledAttributes.getResourceId(index, this.f8840h);
                        this.f8840h = resourceId5;
                        if (resourceId5 == -1) {
                            this.f8840h = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_NUMBER /* 12 */:
                        int resourceId6 = typedArrayObtainStyledAttributes.getResourceId(index, this.f8842i);
                        this.f8842i = resourceId6;
                        if (resourceId6 == -1) {
                            this.f8842i = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_POINT_WITH_ARROW /* 13 */:
                        int resourceId7 = typedArrayObtainStyledAttributes.getResourceId(index, this.f8844j);
                        this.f8844j = resourceId7;
                        if (resourceId7 == -1) {
                            this.f8844j = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_NUMBER_WITH_ARROW /* 14 */:
                        int resourceId8 = typedArrayObtainStyledAttributes.getResourceId(index, this.f8846k);
                        this.f8846k = resourceId8;
                        if (resourceId8 == -1) {
                            this.f8846k = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        int resourceId9 = typedArrayObtainStyledAttributes.getResourceId(index, this.f8848l);
                        this.f8848l = resourceId9;
                        if (resourceId9 == -1) {
                            this.f8848l = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        int resourceId10 = typedArrayObtainStyledAttributes.getResourceId(index, this.f8850m);
                        this.f8850m = resourceId10;
                        if (resourceId10 == -1) {
                            this.f8850m = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        int resourceId11 = typedArrayObtainStyledAttributes.getResourceId(index, this.f8862s);
                        this.f8862s = resourceId11;
                        if (resourceId11 == -1) {
                            this.f8862s = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case PolicyBasicListVO.TYPE_ID_LIST_BASCI_MULTI_LINE /* 18 */:
                        int resourceId12 = typedArrayObtainStyledAttributes.getResourceId(index, this.f8864t);
                        this.f8864t = resourceId12;
                        if (resourceId12 == -1) {
                            this.f8864t = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case PolicyBasicListVO.TYPE_ID_LIST_BASCI_MULTI_LINE_LONG /* 19 */:
                        int resourceId13 = typedArrayObtainStyledAttributes.getResourceId(index, this.f8866u);
                        this.f8866u = resourceId13;
                        if (resourceId13 == -1) {
                            this.f8866u = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL /* 20 */:
                        int resourceId14 = typedArrayObtainStyledAttributes.getResourceId(index, this.f8868v);
                        this.f8868v = resourceId14;
                        if (resourceId14 == -1) {
                            this.f8868v = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL_WITH_SUBTITLE /* 21 */:
                        this.f8870w = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f8870w);
                        break;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_MIDDLE /* 22 */:
                        this.f8872x = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f8872x);
                        break;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_LARGE /* 23 */:
                        this.f8873y = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f8873y);
                        break;
                    case 24:
                        this.f8874z = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f8874z);
                        break;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR /* 25 */:
                        this.f8800A = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f8800A);
                        break;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_SUBTITLE /* 26 */:
                        this.f8801B = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f8801B);
                        break;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_DESC /* 27 */:
                        this.f8827a0 = typedArrayObtainStyledAttributes.getBoolean(index, this.f8827a0);
                        break;
                    case 28:
                        this.f8829b0 = typedArrayObtainStyledAttributes.getBoolean(index, this.f8829b0);
                        break;
                    case 29:
                        this.f8806G = typedArrayObtainStyledAttributes.getFloat(index, this.f8806G);
                        break;
                    case PolicyBasicListVO.TYPE_ID_HEAD_LIST /* 30 */:
                        this.f8807H = typedArrayObtainStyledAttributes.getFloat(index, this.f8807H);
                        break;
                    case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_ARROW_WITH_NUMBER /* 31 */:
                        int i7 = typedArrayObtainStyledAttributes.getInt(index, 0);
                        this.f8815P = i7;
                        if (i7 == 1) {
                            Log.e("ConstraintLayout", "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
                            break;
                        } else {
                            break;
                        }
                    case 32:
                        int i8 = typedArrayObtainStyledAttributes.getInt(index, 0);
                        this.f8816Q = i8;
                        if (i8 == 1) {
                            Log.e("ConstraintLayout", "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
                            break;
                        } else {
                            break;
                        }
                    case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_ARROW_WITH_HIGHLIGHT_TEXT /* 33 */:
                        try {
                            this.f8817R = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f8817R);
                            break;
                        } catch (Exception unused) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.f8817R) == -2) {
                                this.f8817R = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_ARROW_WITH_CHECKBOX_OFF /* 34 */:
                        try {
                            this.f8819T = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f8819T);
                            break;
                        } catch (Exception unused2) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.f8819T) == -2) {
                                this.f8819T = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_ARROW_WITH_CHECKBOX_ON /* 35 */:
                        this.f8821V = Math.max(0.0f, typedArrayObtainStyledAttributes.getFloat(index, this.f8821V));
                        this.f8815P = 2;
                        break;
                    case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_LARGE /* 36 */:
                        try {
                            this.f8818S = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f8818S);
                            break;
                        } catch (Exception unused3) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.f8818S) == -2) {
                                this.f8818S = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case PolicyBasicListVO.TYPE_ID_LIST_BASCI_DOUBLE_LINE_LARGE_TITLE /* 37 */:
                        try {
                            this.f8820U = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f8820U);
                            break;
                        } catch (Exception unused4) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.f8820U) == -2) {
                                this.f8820U = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case PolicyBasicListVO.TYPE_ID_LIST_BASCI_MULTI_LINE_LONG_LARGE /* 38 */:
                        this.f8822W = Math.max(0.0f, typedArrayObtainStyledAttributes.getFloat(index, this.f8822W));
                        this.f8816Q = 2;
                        break;
                    default:
                        switch (i6) {
                            case 44:
                                d.x(this, typedArrayObtainStyledAttributes.getString(index));
                                break;
                            case 45:
                                this.f8811L = typedArrayObtainStyledAttributes.getFloat(index, this.f8811L);
                                break;
                            case 46:
                                this.f8812M = typedArrayObtainStyledAttributes.getFloat(index, this.f8812M);
                                break;
                            case 47:
                                this.f8813N = typedArrayObtainStyledAttributes.getInt(index, 0);
                                break;
                            case 48:
                                this.f8814O = typedArrayObtainStyledAttributes.getInt(index, 0);
                                break;
                            case 49:
                                this.f8823X = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f8823X);
                                break;
                            case 50:
                                this.f8824Y = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f8824Y);
                                break;
                            case 51:
                                this.f8831c0 = typedArrayObtainStyledAttributes.getString(index);
                                break;
                            case 52:
                                int resourceId15 = typedArrayObtainStyledAttributes.getResourceId(index, this.f8852n);
                                this.f8852n = resourceId15;
                                if (resourceId15 == -1) {
                                    this.f8852n = typedArrayObtainStyledAttributes.getInt(index, -1);
                                    break;
                                } else {
                                    break;
                                }
                            case 53:
                                int resourceId16 = typedArrayObtainStyledAttributes.getResourceId(index, this.f8854o);
                                this.f8854o = resourceId16;
                                if (resourceId16 == -1) {
                                    this.f8854o = typedArrayObtainStyledAttributes.getInt(index, -1);
                                    break;
                                } else {
                                    break;
                                }
                            case 54:
                                this.f8803D = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f8803D);
                                break;
                            case 55:
                                this.f8802C = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f8802C);
                                break;
                            default:
                                switch (i6) {
                                    case 64:
                                        d.v(this, typedArrayObtainStyledAttributes, index, 0);
                                        this.f8804E = true;
                                        break;
                                    case 65:
                                        d.v(this, typedArrayObtainStyledAttributes, index, 1);
                                        this.f8805F = true;
                                        break;
                                    case 66:
                                        this.f8833d0 = typedArrayObtainStyledAttributes.getInt(index, this.f8833d0);
                                        break;
                                    case 67:
                                        this.f8832d = typedArrayObtainStyledAttributes.getBoolean(index, this.f8832d);
                                        break;
                                }
                        }
                }
            }
            typedArrayObtainStyledAttributes.recycle();
            a();
        }

        public void a() {
            this.f8841h0 = false;
            this.f8835e0 = true;
            this.f8837f0 = true;
            int i5 = ((ViewGroup.MarginLayoutParams) this).width;
            if (i5 == -2 && this.f8827a0) {
                this.f8835e0 = false;
                if (this.f8815P == 0) {
                    this.f8815P = 1;
                }
            }
            int i6 = ((ViewGroup.MarginLayoutParams) this).height;
            if (i6 == -2 && this.f8829b0) {
                this.f8837f0 = false;
                if (this.f8816Q == 0) {
                    this.f8816Q = 1;
                }
            }
            if (i5 == 0 || i5 == -1) {
                this.f8835e0 = false;
                if (i5 == 0 && this.f8815P == 1) {
                    ((ViewGroup.MarginLayoutParams) this).width = -2;
                    this.f8827a0 = true;
                }
            }
            if (i6 == 0 || i6 == -1) {
                this.f8837f0 = false;
                if (i6 == 0 && this.f8816Q == 1) {
                    ((ViewGroup.MarginLayoutParams) this).height = -2;
                    this.f8829b0 = true;
                }
            }
            if (this.f8830c == -1.0f && this.f8826a == -1 && this.f8828b == -1) {
                return;
            }
            this.f8841h0 = true;
            this.f8835e0 = true;
            this.f8837f0 = true;
            if (!(this.f8869v0 instanceof v.h)) {
                this.f8869v0 = new v.h();
            }
            ((v.h) this.f8869v0).A1(this.f8825Z);
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

        public b(int i5, int i6) {
            super(i5, i6);
            this.f8826a = -1;
            this.f8828b = -1;
            this.f8830c = -1.0f;
            this.f8832d = true;
            this.f8834e = -1;
            this.f8836f = -1;
            this.f8838g = -1;
            this.f8840h = -1;
            this.f8842i = -1;
            this.f8844j = -1;
            this.f8846k = -1;
            this.f8848l = -1;
            this.f8850m = -1;
            this.f8852n = -1;
            this.f8854o = -1;
            this.f8856p = -1;
            this.f8858q = 0;
            this.f8860r = 0.0f;
            this.f8862s = -1;
            this.f8864t = -1;
            this.f8866u = -1;
            this.f8868v = -1;
            this.f8870w = Integer.MIN_VALUE;
            this.f8872x = Integer.MIN_VALUE;
            this.f8873y = Integer.MIN_VALUE;
            this.f8874z = Integer.MIN_VALUE;
            this.f8800A = Integer.MIN_VALUE;
            this.f8801B = Integer.MIN_VALUE;
            this.f8802C = Integer.MIN_VALUE;
            this.f8803D = 0;
            this.f8804E = true;
            this.f8805F = true;
            this.f8806G = 0.5f;
            this.f8807H = 0.5f;
            this.f8808I = null;
            this.f8809J = 0.0f;
            this.f8810K = 1;
            this.f8811L = -1.0f;
            this.f8812M = -1.0f;
            this.f8813N = 0;
            this.f8814O = 0;
            this.f8815P = 0;
            this.f8816Q = 0;
            this.f8817R = 0;
            this.f8818S = 0;
            this.f8819T = 0;
            this.f8820U = 0;
            this.f8821V = 1.0f;
            this.f8822W = 1.0f;
            this.f8823X = -1;
            this.f8824Y = -1;
            this.f8825Z = -1;
            this.f8827a0 = false;
            this.f8829b0 = false;
            this.f8831c0 = null;
            this.f8833d0 = 0;
            this.f8835e0 = true;
            this.f8837f0 = true;
            this.f8839g0 = false;
            this.f8841h0 = false;
            this.f8843i0 = false;
            this.f8845j0 = false;
            this.f8847k0 = false;
            this.f8849l0 = -1;
            this.f8851m0 = -1;
            this.f8853n0 = -1;
            this.f8855o0 = -1;
            this.f8857p0 = Integer.MIN_VALUE;
            this.f8859q0 = Integer.MIN_VALUE;
            this.f8861r0 = 0.5f;
            this.f8869v0 = new v.e();
            this.f8871w0 = false;
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f8826a = -1;
            this.f8828b = -1;
            this.f8830c = -1.0f;
            this.f8832d = true;
            this.f8834e = -1;
            this.f8836f = -1;
            this.f8838g = -1;
            this.f8840h = -1;
            this.f8842i = -1;
            this.f8844j = -1;
            this.f8846k = -1;
            this.f8848l = -1;
            this.f8850m = -1;
            this.f8852n = -1;
            this.f8854o = -1;
            this.f8856p = -1;
            this.f8858q = 0;
            this.f8860r = 0.0f;
            this.f8862s = -1;
            this.f8864t = -1;
            this.f8866u = -1;
            this.f8868v = -1;
            this.f8870w = Integer.MIN_VALUE;
            this.f8872x = Integer.MIN_VALUE;
            this.f8873y = Integer.MIN_VALUE;
            this.f8874z = Integer.MIN_VALUE;
            this.f8800A = Integer.MIN_VALUE;
            this.f8801B = Integer.MIN_VALUE;
            this.f8802C = Integer.MIN_VALUE;
            this.f8803D = 0;
            this.f8804E = true;
            this.f8805F = true;
            this.f8806G = 0.5f;
            this.f8807H = 0.5f;
            this.f8808I = null;
            this.f8809J = 0.0f;
            this.f8810K = 1;
            this.f8811L = -1.0f;
            this.f8812M = -1.0f;
            this.f8813N = 0;
            this.f8814O = 0;
            this.f8815P = 0;
            this.f8816Q = 0;
            this.f8817R = 0;
            this.f8818S = 0;
            this.f8819T = 0;
            this.f8820U = 0;
            this.f8821V = 1.0f;
            this.f8822W = 1.0f;
            this.f8823X = -1;
            this.f8824Y = -1;
            this.f8825Z = -1;
            this.f8827a0 = false;
            this.f8829b0 = false;
            this.f8831c0 = null;
            this.f8833d0 = 0;
            this.f8835e0 = true;
            this.f8837f0 = true;
            this.f8839g0 = false;
            this.f8841h0 = false;
            this.f8843i0 = false;
            this.f8845j0 = false;
            this.f8847k0 = false;
            this.f8849l0 = -1;
            this.f8851m0 = -1;
            this.f8853n0 = -1;
            this.f8855o0 = -1;
            this.f8857p0 = Integer.MIN_VALUE;
            this.f8859q0 = Integer.MIN_VALUE;
            this.f8861r0 = 0.5f;
            this.f8869v0 = new v.e();
            this.f8871w0 = false;
        }
    }
}
