package androidx.constraintlayout.widget;

import android.annotation.SuppressLint;
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
import androidx.constraintlayout.core.widgets.g;
import androidx.constraintlayout.core.widgets.h;
import com.stepos.core.ability.speech.VadSessionManager;
import com.stepos.core.data.base.Content;
import com.stepos.deepbinder.core.exception.ErrorCodes;
import h0.b;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class ConstraintLayout extends ViewGroup {

    /* renamed from: s, reason: collision with root package name */
    public static j0.e f1267s;

    /* renamed from: a, reason: collision with root package name */
    public final SparseArray<View> f1268a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList<androidx.constraintlayout.widget.b> f1269b;

    /* renamed from: c, reason: collision with root package name */
    public final androidx.constraintlayout.core.widgets.d f1270c;

    /* renamed from: d, reason: collision with root package name */
    public int f1271d;

    /* renamed from: e, reason: collision with root package name */
    public int f1272e;
    public int h;

    /* renamed from: j, reason: collision with root package name */
    public int f1273j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f1274k;

    /* renamed from: l, reason: collision with root package name */
    public int f1275l;

    /* renamed from: m, reason: collision with root package name */
    public c f1276m;

    /* renamed from: n, reason: collision with root package name */
    public j0.a f1277n;

    /* renamed from: o, reason: collision with root package name */
    public int f1278o;

    /* renamed from: p, reason: collision with root package name */
    public HashMap<String, Integer> f1279p;

    /* renamed from: q, reason: collision with root package name */
    public final SparseArray<ConstraintWidget> f1280q;
    public final b r;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class b implements b.InterfaceC0086b {

        /* renamed from: a, reason: collision with root package name */
        public final ConstraintLayout f1319a;

        /* renamed from: b, reason: collision with root package name */
        public int f1320b;

        /* renamed from: c, reason: collision with root package name */
        public int f1321c;

        /* renamed from: d, reason: collision with root package name */
        public int f1322d;

        /* renamed from: e, reason: collision with root package name */
        public int f1323e;

        /* renamed from: f, reason: collision with root package name */
        public int f1324f;

        /* renamed from: g, reason: collision with root package name */
        public int f1325g;

        public b(ConstraintLayout constraintLayout) {
            this.f1319a = constraintLayout;
        }

        public static boolean a(int i10, int i11, int i12) {
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

        @SuppressLint({"WrongCall"})
        public final void b(ConstraintWidget constraintWidget, b.a aVar) {
            int iMakeMeasureSpec;
            int iMakeMeasureSpec2;
            int iMax;
            int iMax2;
            boolean z;
            int baseline;
            int i10;
            if (constraintWidget == null) {
                return;
            }
            ConstraintAnchor constraintAnchor = constraintWidget.L;
            ConstraintAnchor constraintAnchor2 = constraintWidget.J;
            if (constraintWidget.f1113i0 == 8 && !constraintWidget.F) {
                aVar.f9182e = 0;
                aVar.f9183f = 0;
                aVar.f9184g = 0;
                return;
            }
            if (constraintWidget.V == null) {
                return;
            }
            j0.e eVar = ConstraintLayout.f1267s;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = aVar.f9178a;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = aVar.f9179b;
            int i11 = aVar.f9180c;
            int i12 = aVar.f9181d;
            int i13 = this.f1320b + this.f1321c;
            int i14 = this.f1322d;
            View view = constraintWidget.f1111h0;
            int iOrdinal = dimensionBehaviour.ordinal();
            if (iOrdinal == 0) {
                iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i11, 1073741824);
            } else if (iOrdinal == 1) {
                iMakeMeasureSpec = ViewGroup.getChildMeasureSpec(this.f1324f, i14, -2);
            } else if (iOrdinal == 2) {
                iMakeMeasureSpec = ViewGroup.getChildMeasureSpec(this.f1324f, i14, -2);
                boolean z3 = constraintWidget.r == 1;
                int i15 = aVar.f9186j;
                if (i15 == 1 || i15 == 2) {
                    boolean z10 = view.getMeasuredHeight() == constraintWidget.k();
                    if (aVar.f9186j == 2 || !z3 || ((z3 && z10) || (view instanceof f) || constraintWidget.A())) {
                        iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(constraintWidget.q(), 1073741824);
                    }
                }
            } else if (iOrdinal != 3) {
                iMakeMeasureSpec = 0;
            } else {
                int i16 = this.f1324f;
                int i17 = constraintAnchor2 != null ? constraintAnchor2.f1089g : 0;
                if (constraintAnchor != null) {
                    i17 += constraintAnchor.f1089g;
                }
                iMakeMeasureSpec = ViewGroup.getChildMeasureSpec(i16, i14 + i17, -1);
            }
            int iOrdinal2 = dimensionBehaviour2.ordinal();
            if (iOrdinal2 == 0) {
                iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i12, 1073741824);
            } else if (iOrdinal2 == 1) {
                iMakeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.f1325g, i13, -2);
            } else if (iOrdinal2 == 2) {
                iMakeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.f1325g, i13, -2);
                boolean z11 = constraintWidget.f1129s == 1;
                int i18 = aVar.f9186j;
                if (i18 == 1 || i18 == 2) {
                    boolean z12 = view.getMeasuredWidth() == constraintWidget.q();
                    if (aVar.f9186j == 2 || !z11 || ((z11 && z12) || (view instanceof f) || constraintWidget.B())) {
                        iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(constraintWidget.k(), 1073741824);
                    }
                }
            } else if (iOrdinal2 != 3) {
                iMakeMeasureSpec2 = 0;
            } else {
                int i19 = this.f1325g;
                int i20 = constraintAnchor2 != null ? constraintWidget.K.f1089g : 0;
                if (constraintAnchor != null) {
                    i20 += constraintWidget.M.f1089g;
                }
                iMakeMeasureSpec2 = ViewGroup.getChildMeasureSpec(i19, i13 + i20, -1);
            }
            androidx.constraintlayout.core.widgets.d dVar = (androidx.constraintlayout.core.widgets.d) constraintWidget.V;
            ConstraintLayout constraintLayout = ConstraintLayout.this;
            if (dVar != null && g.b(constraintLayout.f1275l, 256) && view.getMeasuredWidth() == constraintWidget.q() && view.getMeasuredWidth() < dVar.q() && view.getMeasuredHeight() == constraintWidget.k() && view.getMeasuredHeight() < dVar.k() && view.getBaseline() == constraintWidget.c0 && !constraintWidget.z() && a(constraintWidget.H, iMakeMeasureSpec, constraintWidget.q()) && a(constraintWidget.I, iMakeMeasureSpec2, constraintWidget.k())) {
                aVar.f9182e = constraintWidget.q();
                aVar.f9183f = constraintWidget.k();
                aVar.f9184g = constraintWidget.c0;
                return;
            }
            ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.f1138c;
            boolean z13 = dimensionBehaviour == dimensionBehaviour3;
            boolean z14 = dimensionBehaviour2 == dimensionBehaviour3;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.f1136a;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = ConstraintWidget.DimensionBehaviour.f1139d;
            boolean z15 = dimensionBehaviour2 == dimensionBehaviour5 || dimensionBehaviour2 == dimensionBehaviour4;
            boolean z16 = dimensionBehaviour == dimensionBehaviour5 || dimensionBehaviour == dimensionBehaviour4;
            boolean z17 = z13 && constraintWidget.Y > 0.0f;
            boolean z18 = z14 && constraintWidget.Y > 0.0f;
            if (view == null) {
                return;
            }
            a aVar2 = (a) view.getLayoutParams();
            int i21 = aVar.f9186j;
            if (i21 != 1 && i21 != 2 && z13 && constraintWidget.r == 0 && z14 && constraintWidget.f1129s == 0) {
                i10 = -1;
                z = false;
                baseline = 0;
                iMax = 0;
                iMax2 = 0;
            } else {
                if ((view instanceof j0.f) && (constraintWidget instanceof h)) {
                    ((j0.f) view).j((h) constraintWidget, iMakeMeasureSpec, iMakeMeasureSpec2);
                } else {
                    view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                }
                constraintWidget.H = iMakeMeasureSpec;
                constraintWidget.I = iMakeMeasureSpec2;
                constraintWidget.f1109g = false;
                int measuredWidth = view.getMeasuredWidth();
                int measuredHeight = view.getMeasuredHeight();
                int baseline2 = view.getBaseline();
                int i22 = constraintWidget.f1131u;
                iMax = i22 > 0 ? Math.max(i22, measuredWidth) : measuredWidth;
                int i23 = constraintWidget.f1132v;
                if (i23 > 0) {
                    iMax = Math.min(i23, iMax);
                }
                int i24 = constraintWidget.f1134x;
                iMax2 = i24 > 0 ? Math.max(i24, measuredHeight) : measuredHeight;
                int i25 = iMakeMeasureSpec2;
                int i26 = constraintWidget.f1135y;
                if (i26 > 0) {
                    iMax2 = Math.min(i26, iMax2);
                }
                if (!g.b(constraintLayout.f1275l, 1)) {
                    if (z17 && z15) {
                        iMax = (int) ((iMax2 * constraintWidget.Y) + 0.5f);
                    } else if (z18 && z16) {
                        iMax2 = (int) ((iMax / constraintWidget.Y) + 0.5f);
                    }
                }
                if (measuredWidth == iMax && measuredHeight == iMax2) {
                    baseline = baseline2;
                    i10 = -1;
                    z = false;
                } else {
                    if (measuredWidth != iMax) {
                        iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iMax, 1073741824);
                    }
                    int iMakeMeasureSpec3 = measuredHeight != iMax2 ? View.MeasureSpec.makeMeasureSpec(iMax2, 1073741824) : i25;
                    view.measure(iMakeMeasureSpec, iMakeMeasureSpec3);
                    constraintWidget.H = iMakeMeasureSpec;
                    constraintWidget.I = iMakeMeasureSpec3;
                    z = false;
                    constraintWidget.f1109g = false;
                    int measuredWidth2 = view.getMeasuredWidth();
                    int measuredHeight2 = view.getMeasuredHeight();
                    baseline = view.getBaseline();
                    iMax = measuredWidth2;
                    iMax2 = measuredHeight2;
                    i10 = -1;
                }
            }
            boolean z19 = baseline != i10 ? true : z;
            aVar.f9185i = (iMax == aVar.f9180c && iMax2 == aVar.f9181d) ? z : true;
            boolean z20 = aVar2.c0 ? true : z19;
            if (z20 && baseline != -1 && constraintWidget.c0 != baseline) {
                aVar.f9185i = true;
            }
            aVar.f9182e = iMax;
            aVar.f9183f = iMax2;
            aVar.h = z20;
            aVar.f9184g = baseline;
        }
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1268a = new SparseArray<>();
        this.f1269b = new ArrayList<>(4);
        this.f1270c = new androidx.constraintlayout.core.widgets.d();
        this.f1271d = 0;
        this.f1272e = 0;
        this.h = Integer.MAX_VALUE;
        this.f1273j = Integer.MAX_VALUE;
        this.f1274k = true;
        this.f1275l = 257;
        this.f1276m = null;
        this.f1277n = null;
        this.f1278o = -1;
        this.f1279p = new HashMap<>();
        this.f1280q = new SparseArray<>();
        this.r = new b(this);
        c(attributeSet, 0);
    }

    private int getPaddingWidth() {
        int iMax = Math.max(0, getPaddingRight()) + Math.max(0, getPaddingLeft());
        int iMax2 = Math.max(0, getPaddingEnd()) + Math.max(0, getPaddingStart());
        return iMax2 > 0 ? iMax2 : iMax;
    }

    public static j0.e getSharedValues() {
        if (f1267s == null) {
            j0.e eVar = new j0.e();
            new SparseIntArray();
            new HashMap();
            f1267s = eVar;
        }
        return f1267s;
    }

    public final ConstraintWidget b(View view) {
        if (view == this) {
            return this.f1270c;
        }
        if (view == null) {
            return null;
        }
        if (view.getLayoutParams() instanceof a) {
            return ((a) view.getLayoutParams()).q0;
        }
        view.setLayoutParams(new a(view.getLayoutParams()));
        if (view.getLayoutParams() instanceof a) {
            return ((a) view.getLayoutParams()).q0;
        }
        return null;
    }

    public final void c(AttributeSet attributeSet, int i10) {
        androidx.constraintlayout.core.widgets.d dVar = this.f1270c;
        dVar.f1111h0 = this;
        b bVar = this.r;
        dVar.f1199v0 = bVar;
        dVar.f1197t0.f9194f = bVar;
        this.f1268a.put(getId(), this);
        this.f1276m = null;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, j0.d.f9640b, i10, 0);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i11);
                if (index == 16) {
                    this.f1271d = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f1271d);
                } else if (index == 17) {
                    this.f1272e = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f1272e);
                } else if (index == 14) {
                    this.h = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.h);
                } else if (index == 15) {
                    this.f1273j = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f1273j);
                } else if (index == 113) {
                    this.f1275l = typedArrayObtainStyledAttributes.getInt(index, this.f1275l);
                } else if (index == 56) {
                    int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, 0);
                    if (resourceId != 0) {
                        try {
                            e(resourceId);
                        } catch (Resources.NotFoundException unused) {
                            this.f1277n = null;
                        }
                    }
                } else if (index == 34) {
                    int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(index, 0);
                    try {
                        c cVar = new c();
                        this.f1276m = cVar;
                        cVar.e(resourceId2, getContext());
                    } catch (Resources.NotFoundException unused2) {
                        this.f1276m = null;
                    }
                    this.f1278o = resourceId2;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        dVar.E0 = this.f1275l;
        androidx.constraintlayout.core.c.f1062q = dVar.W(VadSessionManager.FRAME_BYTES);
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    public final boolean d() {
        return (getContext().getApplicationInfo().flags & 4194304) != 0 && 1 == getLayoutDirection();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) throws NumberFormatException {
        Object tag;
        int size;
        ArrayList<androidx.constraintlayout.widget.b> arrayList = this.f1269b;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            for (int i10 = 0; i10 < size; i10++) {
                arrayList.get(i10).getClass();
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
                    String[] strArrSplit = ((String) tag).split(",");
                    if (strArrSplit.length == 4) {
                        int i12 = Integer.parseInt(strArrSplit[0]);
                        int i13 = Integer.parseInt(strArrSplit[1]);
                        int i14 = Integer.parseInt(strArrSplit[2]);
                        int i15 = (int) ((i12 / 1080.0f) * width);
                        int i16 = (int) ((i13 / 1920.0f) * height);
                        Paint paint = new Paint();
                        paint.setColor(-65536);
                        float f8 = i15;
                        float f9 = i16;
                        float f10 = i15 + ((int) ((i14 / 1080.0f) * width));
                        canvas.drawLine(f8, f9, f10, f9, paint);
                        float f11 = i16 + ((int) ((Integer.parseInt(strArrSplit[3]) / 1920.0f) * height));
                        canvas.drawLine(f10, f9, f10, f11, paint);
                        canvas.drawLine(f10, f11, f8, f11, paint);
                        canvas.drawLine(f8, f11, f8, f9, paint);
                        paint.setColor(-16711936);
                        canvas.drawLine(f8, f9, f10, f11, paint);
                        canvas.drawLine(f8, f11, f10, f9, paint);
                    }
                }
            }
        }
    }

    public void e(int i10) {
        this.f1277n = new j0.a(getContext(), this, i10);
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x01dc A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01de A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0475  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x0485  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x048e  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x05a2  */
    /* JADX WARN: Removed duplicated region for block: B:310:0x05a7  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:399:0x0764  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01d5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(androidx.constraintlayout.core.widgets.d r29, int r30, int r31, int r32) {
        /*
            Method dump skipped, instructions count: 1904
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.f(androidx.constraintlayout.core.widgets.d, int, int, int):void");
    }

    @Override // android.view.View
    public final void forceLayout() {
        this.f1274k = true;
        super.forceLayout();
    }

    public final void g(ConstraintWidget constraintWidget, a aVar, SparseArray<ConstraintWidget> sparseArray, int i10, ConstraintAnchor.Type type) {
        View view = this.f1268a.get(i10);
        ConstraintWidget constraintWidget2 = sparseArray.get(i10);
        if (constraintWidget2 == null || view == null || !(view.getLayoutParams() instanceof a)) {
            return;
        }
        aVar.c0 = true;
        ConstraintAnchor.Type type2 = ConstraintAnchor.Type.f1095e;
        if (type == type2) {
            a aVar2 = (a) view.getLayoutParams();
            aVar2.c0 = true;
            aVar2.q0.E = true;
        }
        constraintWidget.i(type2).b(constraintWidget2.i(type), aVar.D, aVar.C, true);
        constraintWidget.E = true;
        constraintWidget.i(ConstraintAnchor.Type.f1092b).j();
        constraintWidget.i(ConstraintAnchor.Type.f1094d).j();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new a();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    public int getMaxHeight() {
        return this.f1273j;
    }

    public int getMaxWidth() {
        return this.h;
    }

    public int getMinHeight() {
        return this.f1272e;
    }

    public int getMinWidth() {
        return this.f1271d;
    }

    public int getOptimizationLevel() {
        return this.f1270c.E0;
    }

    public String getSceneString() {
        int id2;
        StringBuilder sb2 = new StringBuilder();
        androidx.constraintlayout.core.widgets.d dVar = this.f1270c;
        if (dVar.f1114j == null) {
            int id3 = getId();
            if (id3 != -1) {
                dVar.f1114j = getContext().getResources().getResourceEntryName(id3);
            } else {
                dVar.f1114j = "parent";
            }
        }
        if (dVar.f1115j0 == null) {
            dVar.f1115j0 = dVar.f1114j;
            Log.v("ConstraintLayout", " setDebugName " + dVar.f1115j0);
        }
        ArrayList<ConstraintWidget> arrayList = dVar.f8946r0;
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            ConstraintWidget constraintWidget = arrayList.get(i10);
            i10++;
            ConstraintWidget constraintWidget2 = constraintWidget;
            View view = constraintWidget2.f1111h0;
            if (view != null) {
                if (constraintWidget2.f1114j == null && (id2 = view.getId()) != -1) {
                    constraintWidget2.f1114j = getContext().getResources().getResourceEntryName(id2);
                }
                if (constraintWidget2.f1115j0 == null) {
                    constraintWidget2.f1115j0 = constraintWidget2.f1114j;
                    Log.v("ConstraintLayout", " setDebugName " + constraintWidget2.f1115j0);
                }
            }
        }
        dVar.n(sb2);
        return sb2.toString();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i10, int i11, int i12, int i13) {
        View content;
        int childCount = getChildCount();
        boolean zIsInEditMode = isInEditMode();
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt = getChildAt(i14);
            a aVar = (a) childAt.getLayoutParams();
            ConstraintWidget constraintWidget = aVar.q0;
            if ((childAt.getVisibility() != 8 || aVar.f1286d0 || aVar.f1288e0 || zIsInEditMode) && !aVar.f1290f0) {
                int iR = constraintWidget.r();
                int iS = constraintWidget.s();
                int iQ = constraintWidget.q() + iR;
                int iK = constraintWidget.k() + iS;
                childAt.layout(iR, iS, iQ, iK);
                if ((childAt instanceof f) && (content = ((f) childAt).getContent()) != null) {
                    content.setVisibility(0);
                    content.layout(iR, iS, iQ, iK);
                }
            }
        }
        ArrayList<androidx.constraintlayout.widget.b> arrayList = this.f1269b;
        int size = arrayList.size();
        if (size > 0) {
            for (int i15 = 0; i15 < size; i15++) {
                arrayList.get(i15).getClass();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0385  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x039d  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x03bb  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x03dd  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0408  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x0425  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x0447  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x0453  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x0471  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x0479  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x05a8  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x05ae  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onMeasure(int r35, int r36) throws android.content.res.Resources.NotFoundException, java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 1661
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        ConstraintWidget constraintWidgetB = b(view);
        if ((view instanceof e) && !(constraintWidgetB instanceof androidx.constraintlayout.core.widgets.f)) {
            a aVar = (a) view.getLayoutParams();
            androidx.constraintlayout.core.widgets.f fVar = new androidx.constraintlayout.core.widgets.f();
            aVar.q0 = fVar;
            aVar.f1286d0 = true;
            fVar.S(aVar.V);
        }
        if (view instanceof androidx.constraintlayout.widget.b) {
            androidx.constraintlayout.widget.b bVar = (androidx.constraintlayout.widget.b) view;
            bVar.i();
            ((a) view.getLayoutParams()).f1288e0 = true;
            ArrayList<androidx.constraintlayout.widget.b> arrayList = this.f1269b;
            if (!arrayList.contains(bVar)) {
                arrayList.add(bVar);
            }
        }
        this.f1268a.put(view.getId(), view);
        this.f1274k = true;
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        this.f1268a.remove(view.getId());
        ConstraintWidget constraintWidgetB = b(view);
        this.f1270c.f8946r0.remove(constraintWidgetB);
        constraintWidgetB.C();
        this.f1269b.remove(view);
        this.f1274k = true;
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        this.f1274k = true;
        super.requestLayout();
    }

    public void setConstraintSet(c cVar) {
        this.f1276m = cVar;
    }

    @Override // android.view.View
    public void setId(int i10) {
        int id2 = getId();
        SparseArray<View> sparseArray = this.f1268a;
        sparseArray.remove(id2);
        super.setId(i10);
        sparseArray.put(getId(), this);
    }

    public void setMaxHeight(int i10) {
        if (i10 == this.f1273j) {
            return;
        }
        this.f1273j = i10;
        requestLayout();
    }

    public void setMaxWidth(int i10) {
        if (i10 == this.h) {
            return;
        }
        this.h = i10;
        requestLayout();
    }

    public void setMinHeight(int i10) {
        if (i10 == this.f1272e) {
            return;
        }
        this.f1272e = i10;
        requestLayout();
    }

    public void setMinWidth(int i10) {
        if (i10 == this.f1271d) {
            return;
        }
        this.f1271d = i10;
        requestLayout();
    }

    public void setOnConstraintsChanged(j0.b bVar) {
        j0.a aVar = this.f1277n;
        if (aVar != null) {
            aVar.getClass();
        }
    }

    public void setOptimizationLevel(int i10) {
        this.f1275l = i10;
        androidx.constraintlayout.core.widgets.d dVar = this.f1270c;
        dVar.E0 = i10;
        androidx.constraintlayout.core.c.f1062q = dVar.W(VadSessionManager.FRAME_BYTES);
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new a(layoutParams);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f1268a = new SparseArray<>();
        this.f1269b = new ArrayList<>(4);
        this.f1270c = new androidx.constraintlayout.core.widgets.d();
        this.f1271d = 0;
        this.f1272e = 0;
        this.h = Integer.MAX_VALUE;
        this.f1273j = Integer.MAX_VALUE;
        this.f1274k = true;
        this.f1275l = 257;
        this.f1276m = null;
        this.f1277n = null;
        this.f1278o = -1;
        this.f1279p = new HashMap<>();
        this.f1280q = new SparseArray<>();
        this.r = new b(this);
        c(attributeSet, i10);
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a extends ViewGroup.MarginLayoutParams {
        public int A;
        public int B;
        public final int C;
        public final int D;
        public float E;
        public float F;
        public String G;
        public float H;
        public float I;
        public int J;
        public int K;
        public int L;
        public int M;
        public int N;
        public int O;
        public int P;
        public int Q;
        public float R;
        public float S;
        public int T;
        public int U;
        public int V;
        public boolean W;
        public boolean X;
        public String Y;
        public int Z;

        /* renamed from: a, reason: collision with root package name */
        public int f1281a;

        /* renamed from: a0, reason: collision with root package name */
        public boolean f1282a0;

        /* renamed from: b, reason: collision with root package name */
        public int f1283b;
        public boolean b0;

        /* renamed from: c, reason: collision with root package name */
        public float f1284c;
        public boolean c0;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f1285d;

        /* renamed from: d0, reason: collision with root package name */
        public boolean f1286d0;

        /* renamed from: e, reason: collision with root package name */
        public int f1287e;

        /* renamed from: e0, reason: collision with root package name */
        public boolean f1288e0;

        /* renamed from: f, reason: collision with root package name */
        public int f1289f;

        /* renamed from: f0, reason: collision with root package name */
        public boolean f1290f0;

        /* renamed from: g, reason: collision with root package name */
        public int f1291g;

        /* renamed from: g0, reason: collision with root package name */
        public int f1292g0;
        public int h;

        /* renamed from: h0, reason: collision with root package name */
        public int f1293h0;

        /* renamed from: i, reason: collision with root package name */
        public int f1294i;

        /* renamed from: i0, reason: collision with root package name */
        public int f1295i0;

        /* renamed from: j, reason: collision with root package name */
        public int f1296j;

        /* renamed from: j0, reason: collision with root package name */
        public int f1297j0;

        /* renamed from: k, reason: collision with root package name */
        public int f1298k;

        /* renamed from: k0, reason: collision with root package name */
        public int f1299k0;

        /* renamed from: l, reason: collision with root package name */
        public int f1300l;

        /* renamed from: l0, reason: collision with root package name */
        public int f1301l0;

        /* renamed from: m, reason: collision with root package name */
        public int f1302m;

        /* renamed from: m0, reason: collision with root package name */
        public float f1303m0;

        /* renamed from: n, reason: collision with root package name */
        public int f1304n;

        /* renamed from: n0, reason: collision with root package name */
        public int f1305n0;

        /* renamed from: o, reason: collision with root package name */
        public int f1306o;

        /* renamed from: o0, reason: collision with root package name */
        public int f1307o0;

        /* renamed from: p, reason: collision with root package name */
        public int f1308p;

        /* renamed from: p0, reason: collision with root package name */
        public float f1309p0;

        /* renamed from: q, reason: collision with root package name */
        public int f1310q;
        public ConstraintWidget q0;
        public float r;

        /* renamed from: s, reason: collision with root package name */
        public int f1311s;

        /* renamed from: t, reason: collision with root package name */
        public int f1312t;

        /* renamed from: u, reason: collision with root package name */
        public int f1313u;

        /* renamed from: v, reason: collision with root package name */
        public int f1314v;

        /* renamed from: w, reason: collision with root package name */
        public final int f1315w;

        /* renamed from: x, reason: collision with root package name */
        public int f1316x;

        /* renamed from: y, reason: collision with root package name */
        public final int f1317y;
        public int z;

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        /* renamed from: androidx.constraintlayout.widget.ConstraintLayout$a$a, reason: collision with other inner class name */
        public static class C0005a {

            /* renamed from: a, reason: collision with root package name */
            public static final SparseIntArray f1318a;

            static {
                SparseIntArray sparseIntArray = new SparseIntArray();
                f1318a = sparseIntArray;
                sparseIntArray.append(98, 64);
                sparseIntArray.append(75, 65);
                sparseIntArray.append(84, 8);
                sparseIntArray.append(85, 9);
                sparseIntArray.append(87, 10);
                sparseIntArray.append(88, 11);
                sparseIntArray.append(94, 12);
                sparseIntArray.append(93, 13);
                sparseIntArray.append(65, 14);
                sparseIntArray.append(64, 15);
                sparseIntArray.append(60, 16);
                sparseIntArray.append(62, 52);
                sparseIntArray.append(61, 53);
                sparseIntArray.append(66, 2);
                sparseIntArray.append(68, 3);
                sparseIntArray.append(67, 4);
                sparseIntArray.append(Content.Types.TYPE_DOUBLE, 49);
                sparseIntArray.append(Content.Types.TYPE_BOOLEAN, 50);
                sparseIntArray.append(72, 5);
                sparseIntArray.append(73, 6);
                sparseIntArray.append(74, 7);
                sparseIntArray.append(55, 67);
                sparseIntArray.append(0, 1);
                sparseIntArray.append(89, 17);
                sparseIntArray.append(90, 18);
                sparseIntArray.append(71, 19);
                sparseIntArray.append(70, 20);
                sparseIntArray.append(Content.Types.TYPE_DOUBLE_ARRAY, 21);
                sparseIntArray.append(111, 22);
                sparseIntArray.append(109, 23);
                sparseIntArray.append(Content.Types.TYPE_FLOAT_ARRAY, 24);
                sparseIntArray.append(110, 25);
                sparseIntArray.append(Content.Types.TYPE_INT_ARRAY, 26);
                sparseIntArray.append(Content.Types.TYPE_STRING, 55);
                sparseIntArray.append(112, 54);
                sparseIntArray.append(80, 29);
                sparseIntArray.append(95, 30);
                sparseIntArray.append(69, 44);
                sparseIntArray.append(82, 45);
                sparseIntArray.append(97, 46);
                sparseIntArray.append(81, 47);
                sparseIntArray.append(96, 48);
                sparseIntArray.append(58, 27);
                sparseIntArray.append(57, 28);
                sparseIntArray.append(99, 31);
                sparseIntArray.append(76, 32);
                sparseIntArray.append(101, 33);
                sparseIntArray.append(100, 34);
                sparseIntArray.append(102, 35);
                sparseIntArray.append(78, 36);
                sparseIntArray.append(77, 37);
                sparseIntArray.append(79, 38);
                sparseIntArray.append(83, 39);
                sparseIntArray.append(92, 40);
                sparseIntArray.append(86, 41);
                sparseIntArray.append(63, 42);
                sparseIntArray.append(59, 43);
                sparseIntArray.append(91, 51);
                sparseIntArray.append(114, 66);
            }
        }

        @SuppressLint({"ClassVerificationFailure"})
        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f1281a = -1;
            this.f1283b = -1;
            this.f1284c = -1.0f;
            this.f1285d = true;
            this.f1287e = -1;
            this.f1289f = -1;
            this.f1291g = -1;
            this.h = -1;
            this.f1294i = -1;
            this.f1296j = -1;
            this.f1298k = -1;
            this.f1300l = -1;
            this.f1302m = -1;
            this.f1304n = -1;
            this.f1306o = -1;
            this.f1308p = -1;
            this.f1310q = 0;
            this.r = 0.0f;
            this.f1311s = -1;
            this.f1312t = -1;
            this.f1313u = -1;
            this.f1314v = -1;
            this.f1315w = Integer.MIN_VALUE;
            this.f1316x = Integer.MIN_VALUE;
            this.f1317y = Integer.MIN_VALUE;
            this.z = Integer.MIN_VALUE;
            this.A = Integer.MIN_VALUE;
            this.B = Integer.MIN_VALUE;
            this.C = Integer.MIN_VALUE;
            this.D = 0;
            this.E = 0.5f;
            this.F = 0.5f;
            this.G = null;
            this.H = -1.0f;
            this.I = -1.0f;
            this.J = 0;
            this.K = 0;
            this.L = 0;
            this.M = 0;
            this.N = 0;
            this.O = 0;
            this.P = 0;
            this.Q = 0;
            this.R = 1.0f;
            this.S = 1.0f;
            this.T = -1;
            this.U = -1;
            this.V = -1;
            this.W = false;
            this.X = false;
            this.Y = null;
            this.Z = 0;
            this.f1282a0 = true;
            this.b0 = true;
            this.c0 = false;
            this.f1286d0 = false;
            this.f1288e0 = false;
            this.f1290f0 = false;
            this.f1292g0 = -1;
            this.f1293h0 = -1;
            this.f1295i0 = -1;
            this.f1297j0 = -1;
            this.f1299k0 = Integer.MIN_VALUE;
            this.f1301l0 = Integer.MIN_VALUE;
            this.f1303m0 = 0.5f;
            this.q0 = new ConstraintWidget();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                ((ViewGroup.MarginLayoutParams) this).leftMargin = marginLayoutParams.leftMargin;
                ((ViewGroup.MarginLayoutParams) this).rightMargin = marginLayoutParams.rightMargin;
                ((ViewGroup.MarginLayoutParams) this).topMargin = marginLayoutParams.topMargin;
                ((ViewGroup.MarginLayoutParams) this).bottomMargin = marginLayoutParams.bottomMargin;
                setMarginStart(marginLayoutParams.getMarginStart());
                setMarginEnd(marginLayoutParams.getMarginEnd());
            }
            if (layoutParams instanceof a) {
                a aVar = (a) layoutParams;
                this.f1281a = aVar.f1281a;
                this.f1283b = aVar.f1283b;
                this.f1284c = aVar.f1284c;
                this.f1285d = aVar.f1285d;
                this.f1287e = aVar.f1287e;
                this.f1289f = aVar.f1289f;
                this.f1291g = aVar.f1291g;
                this.h = aVar.h;
                this.f1294i = aVar.f1294i;
                this.f1296j = aVar.f1296j;
                this.f1298k = aVar.f1298k;
                this.f1300l = aVar.f1300l;
                this.f1302m = aVar.f1302m;
                this.f1304n = aVar.f1304n;
                this.f1306o = aVar.f1306o;
                this.f1308p = aVar.f1308p;
                this.f1310q = aVar.f1310q;
                this.r = aVar.r;
                this.f1311s = aVar.f1311s;
                this.f1312t = aVar.f1312t;
                this.f1313u = aVar.f1313u;
                this.f1314v = aVar.f1314v;
                this.f1315w = aVar.f1315w;
                this.f1316x = aVar.f1316x;
                this.f1317y = aVar.f1317y;
                this.z = aVar.z;
                this.A = aVar.A;
                this.B = aVar.B;
                this.C = aVar.C;
                this.D = aVar.D;
                this.E = aVar.E;
                this.F = aVar.F;
                this.G = aVar.G;
                this.H = aVar.H;
                this.I = aVar.I;
                this.J = aVar.J;
                this.K = aVar.K;
                this.W = aVar.W;
                this.X = aVar.X;
                this.L = aVar.L;
                this.M = aVar.M;
                this.N = aVar.N;
                this.P = aVar.P;
                this.O = aVar.O;
                this.Q = aVar.Q;
                this.R = aVar.R;
                this.S = aVar.S;
                this.T = aVar.T;
                this.U = aVar.U;
                this.V = aVar.V;
                this.f1282a0 = aVar.f1282a0;
                this.b0 = aVar.b0;
                this.c0 = aVar.c0;
                this.f1286d0 = aVar.f1286d0;
                this.f1292g0 = aVar.f1292g0;
                this.f1293h0 = aVar.f1293h0;
                this.f1295i0 = aVar.f1295i0;
                this.f1297j0 = aVar.f1297j0;
                this.f1299k0 = aVar.f1299k0;
                this.f1301l0 = aVar.f1301l0;
                this.f1303m0 = aVar.f1303m0;
                this.Y = aVar.Y;
                this.Z = aVar.Z;
                this.q0 = aVar.q0;
            }
        }

        public final void a() {
            this.f1286d0 = false;
            this.f1282a0 = true;
            this.b0 = true;
            int i10 = ((ViewGroup.MarginLayoutParams) this).width;
            if (i10 == -2 && this.W) {
                this.f1282a0 = false;
                if (this.L == 0) {
                    this.L = 1;
                }
            }
            int i11 = ((ViewGroup.MarginLayoutParams) this).height;
            if (i11 == -2 && this.X) {
                this.b0 = false;
                if (this.M == 0) {
                    this.M = 1;
                }
            }
            if (i10 == 0 || i10 == -1) {
                this.f1282a0 = false;
                if (i10 == 0 && this.L == 1) {
                    ((ViewGroup.MarginLayoutParams) this).width = -2;
                    this.W = true;
                }
            }
            if (i11 == 0 || i11 == -1) {
                this.b0 = false;
                if (i11 == 0 && this.M == 1) {
                    ((ViewGroup.MarginLayoutParams) this).height = -2;
                    this.X = true;
                }
            }
            if (this.f1284c == -1.0f && this.f1281a == -1 && this.f1283b == -1) {
                return;
            }
            this.f1286d0 = true;
            this.f1282a0 = true;
            this.b0 = true;
            if (!(this.q0 instanceof androidx.constraintlayout.core.widgets.f)) {
                this.q0 = new androidx.constraintlayout.core.widgets.f();
            }
            ((androidx.constraintlayout.core.widgets.f) this.q0).S(this.V);
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
        public final void resolveLayoutDirection(int r11) {
            /*
                Method dump skipped, instructions count: 259
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.a.resolveLayoutDirection(int):void");
        }

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1281a = -1;
            this.f1283b = -1;
            this.f1284c = -1.0f;
            this.f1285d = true;
            this.f1287e = -1;
            this.f1289f = -1;
            this.f1291g = -1;
            this.h = -1;
            this.f1294i = -1;
            this.f1296j = -1;
            this.f1298k = -1;
            this.f1300l = -1;
            this.f1302m = -1;
            this.f1304n = -1;
            this.f1306o = -1;
            this.f1308p = -1;
            this.f1310q = 0;
            this.r = 0.0f;
            this.f1311s = -1;
            this.f1312t = -1;
            this.f1313u = -1;
            this.f1314v = -1;
            this.f1315w = Integer.MIN_VALUE;
            this.f1316x = Integer.MIN_VALUE;
            this.f1317y = Integer.MIN_VALUE;
            this.z = Integer.MIN_VALUE;
            this.A = Integer.MIN_VALUE;
            this.B = Integer.MIN_VALUE;
            this.C = Integer.MIN_VALUE;
            this.D = 0;
            this.E = 0.5f;
            this.F = 0.5f;
            this.G = null;
            this.H = -1.0f;
            this.I = -1.0f;
            this.J = 0;
            this.K = 0;
            this.L = 0;
            this.M = 0;
            this.N = 0;
            this.O = 0;
            this.P = 0;
            this.Q = 0;
            this.R = 1.0f;
            this.S = 1.0f;
            this.T = -1;
            this.U = -1;
            this.V = -1;
            this.W = false;
            this.X = false;
            this.Y = null;
            this.Z = 0;
            this.f1282a0 = true;
            this.b0 = true;
            this.c0 = false;
            this.f1286d0 = false;
            this.f1288e0 = false;
            this.f1290f0 = false;
            this.f1292g0 = -1;
            this.f1293h0 = -1;
            this.f1295i0 = -1;
            this.f1297j0 = -1;
            this.f1299k0 = Integer.MIN_VALUE;
            this.f1301l0 = Integer.MIN_VALUE;
            this.f1303m0 = 0.5f;
            this.q0 = new ConstraintWidget();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j0.d.f9640b);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                int i11 = C0005a.f1318a.get(index);
                switch (i11) {
                    case 1:
                        this.V = typedArrayObtainStyledAttributes.getInt(index, this.V);
                        break;
                    case 2:
                        int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, this.f1308p);
                        this.f1308p = resourceId;
                        if (resourceId == -1) {
                            this.f1308p = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        this.f1310q = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f1310q);
                        break;
                    case 4:
                        float f8 = typedArrayObtainStyledAttributes.getFloat(index, this.r) % 360.0f;
                        this.r = f8;
                        if (f8 < 0.0f) {
                            this.r = (360.0f - f8) % 360.0f;
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        this.f1281a = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f1281a);
                        break;
                    case 6:
                        this.f1283b = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f1283b);
                        break;
                    case 7:
                        this.f1284c = typedArrayObtainStyledAttributes.getFloat(index, this.f1284c);
                        break;
                    case 8:
                        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(index, this.f1287e);
                        this.f1287e = resourceId2;
                        if (resourceId2 == -1) {
                            this.f1287e = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 9:
                        int resourceId3 = typedArrayObtainStyledAttributes.getResourceId(index, this.f1289f);
                        this.f1289f = resourceId3;
                        if (resourceId3 == -1) {
                            this.f1289f = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        int resourceId4 = typedArrayObtainStyledAttributes.getResourceId(index, this.f1291g);
                        this.f1291g = resourceId4;
                        if (resourceId4 == -1) {
                            this.f1291g = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        int resourceId5 = typedArrayObtainStyledAttributes.getResourceId(index, this.h);
                        this.h = resourceId5;
                        if (resourceId5 == -1) {
                            this.h = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        int resourceId6 = typedArrayObtainStyledAttributes.getResourceId(index, this.f1294i);
                        this.f1294i = resourceId6;
                        if (resourceId6 == -1) {
                            this.f1294i = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        int resourceId7 = typedArrayObtainStyledAttributes.getResourceId(index, this.f1296j);
                        this.f1296j = resourceId7;
                        if (resourceId7 == -1) {
                            this.f1296j = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        int resourceId8 = typedArrayObtainStyledAttributes.getResourceId(index, this.f1298k);
                        this.f1298k = resourceId8;
                        if (resourceId8 == -1) {
                            this.f1298k = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        int resourceId9 = typedArrayObtainStyledAttributes.getResourceId(index, this.f1300l);
                        this.f1300l = resourceId9;
                        if (resourceId9 == -1) {
                            this.f1300l = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        int resourceId10 = typedArrayObtainStyledAttributes.getResourceId(index, this.f1302m);
                        this.f1302m = resourceId10;
                        if (resourceId10 == -1) {
                            this.f1302m = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        int resourceId11 = typedArrayObtainStyledAttributes.getResourceId(index, this.f1311s);
                        this.f1311s = resourceId11;
                        if (resourceId11 == -1) {
                            this.f1311s = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        int resourceId12 = typedArrayObtainStyledAttributes.getResourceId(index, this.f1312t);
                        this.f1312t = resourceId12;
                        if (resourceId12 == -1) {
                            this.f1312t = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 19:
                        int resourceId13 = typedArrayObtainStyledAttributes.getResourceId(index, this.f1313u);
                        this.f1313u = resourceId13;
                        if (resourceId13 == -1) {
                            this.f1313u = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 20:
                        int resourceId14 = typedArrayObtainStyledAttributes.getResourceId(index, this.f1314v);
                        this.f1314v = resourceId14;
                        if (resourceId14 == -1) {
                            this.f1314v = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 21:
                        this.f1315w = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f1315w);
                        break;
                    case 22:
                        this.f1316x = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f1316x);
                        break;
                    case 23:
                        this.f1317y = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f1317y);
                        break;
                    case ErrorCodes.GET_INSTANCE_METHOD_INVOCATION_ERROR /* 24 */:
                        this.z = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.z);
                        break;
                    case 25:
                        this.A = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.A);
                        break;
                    case 26:
                        this.B = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.B);
                        break;
                    case 27:
                        this.W = typedArrayObtainStyledAttributes.getBoolean(index, this.W);
                        break;
                    case ErrorCodes.GET_CONTENT_URI_ERROR /* 28 */:
                        this.X = typedArrayObtainStyledAttributes.getBoolean(index, this.X);
                        break;
                    case ErrorCodes.GET_PACKAGE_INFO_ERROR /* 29 */:
                        this.E = typedArrayObtainStyledAttributes.getFloat(index, this.E);
                        break;
                    case 30:
                        this.F = typedArrayObtainStyledAttributes.getFloat(index, this.F);
                        break;
                    case 31:
                        int i12 = typedArrayObtainStyledAttributes.getInt(index, 0);
                        this.L = i12;
                        if (i12 == 1) {
                            Log.e("ConstraintLayout", "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
                            break;
                        } else {
                            break;
                        }
                    case 32:
                        int i13 = typedArrayObtainStyledAttributes.getInt(index, 0);
                        this.M = i13;
                        if (i13 == 1) {
                            Log.e("ConstraintLayout", "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
                            break;
                        } else {
                            break;
                        }
                    case 33:
                        try {
                            this.N = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.N);
                            break;
                        } catch (Exception unused) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.N) == -2) {
                                this.N = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 34:
                        try {
                            this.P = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.P);
                            break;
                        } catch (Exception unused2) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.P) == -2) {
                                this.P = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 35:
                        this.R = Math.max(0.0f, typedArrayObtainStyledAttributes.getFloat(index, this.R));
                        this.L = 2;
                        break;
                    case 36:
                        try {
                            this.O = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.O);
                            break;
                        } catch (Exception unused3) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.O) == -2) {
                                this.O = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 37:
                        try {
                            this.Q = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.Q);
                            break;
                        } catch (Exception unused4) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.Q) == -2) {
                                this.Q = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 38:
                        this.S = Math.max(0.0f, typedArrayObtainStyledAttributes.getFloat(index, this.S));
                        this.M = 2;
                        break;
                    default:
                        switch (i11) {
                            case ErrorCodes.NOT_SET_VERSION_CODE_ERROR /* 44 */:
                                c.h(this, typedArrayObtainStyledAttributes.getString(index));
                                break;
                            case ErrorCodes.CALLER_NOT_IN_METHOD_WHITE_LIST_ERROR /* 45 */:
                                this.H = typedArrayObtainStyledAttributes.getFloat(index, this.H);
                                break;
                            case ErrorCodes.CALLER_IN_METHOD_BLACK_LIST_ERROR /* 46 */:
                                this.I = typedArrayObtainStyledAttributes.getFloat(index, this.I);
                                break;
                            case ErrorCodes.CALLER_NOT_IN_SERVICE_WHITE_LIST_ERROR /* 47 */:
                                this.J = typedArrayObtainStyledAttributes.getInt(index, 0);
                                break;
                            case ErrorCodes.CALLER_IN_SERVICE_BLACK_LIST_ERROR /* 48 */:
                                this.K = typedArrayObtainStyledAttributes.getInt(index, 0);
                                break;
                            case ErrorCodes.PRE_SERVICE_METHOD_INTERCEPT_ERROR /* 49 */:
                                this.T = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.T);
                                break;
                            case ErrorCodes.AFTER_SERVICE_METHOD_INTERCEPT_ERROR /* 50 */:
                                this.U = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.U);
                                break;
                            case ErrorCodes.SERVICE_RECYCLE_ERROR /* 51 */:
                                this.Y = typedArrayObtainStyledAttributes.getString(index);
                                break;
                            case ErrorCodes.CALLER_PROTOCOL_VERSION_TOO_HIGH /* 52 */:
                                int resourceId15 = typedArrayObtainStyledAttributes.getResourceId(index, this.f1304n);
                                this.f1304n = resourceId15;
                                if (resourceId15 == -1) {
                                    this.f1304n = typedArrayObtainStyledAttributes.getInt(index, -1);
                                    break;
                                } else {
                                    break;
                                }
                            case ErrorCodes.CALLBACK_RECYCLE_ERROR /* 53 */:
                                int resourceId16 = typedArrayObtainStyledAttributes.getResourceId(index, this.f1306o);
                                this.f1306o = resourceId16;
                                if (resourceId16 == -1) {
                                    this.f1306o = typedArrayObtainStyledAttributes.getInt(index, -1);
                                    break;
                                } else {
                                    break;
                                }
                            case 54:
                                this.D = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.D);
                                break;
                            case 55:
                                this.C = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.C);
                                break;
                            default:
                                switch (i11) {
                                    case 64:
                                        c.g(this, typedArrayObtainStyledAttributes, index, 0);
                                        break;
                                    case 65:
                                        c.g(this, typedArrayObtainStyledAttributes, index, 1);
                                        break;
                                    case 66:
                                        this.Z = typedArrayObtainStyledAttributes.getInt(index, this.Z);
                                        break;
                                    case 67:
                                        this.f1285d = typedArrayObtainStyledAttributes.getBoolean(index, this.f1285d);
                                        break;
                                }
                        }
                }
            }
            typedArrayObtainStyledAttributes.recycle();
            a();
        }

        public a() {
            super(-2, -2);
            this.f1281a = -1;
            this.f1283b = -1;
            this.f1284c = -1.0f;
            this.f1285d = true;
            this.f1287e = -1;
            this.f1289f = -1;
            this.f1291g = -1;
            this.h = -1;
            this.f1294i = -1;
            this.f1296j = -1;
            this.f1298k = -1;
            this.f1300l = -1;
            this.f1302m = -1;
            this.f1304n = -1;
            this.f1306o = -1;
            this.f1308p = -1;
            this.f1310q = 0;
            this.r = 0.0f;
            this.f1311s = -1;
            this.f1312t = -1;
            this.f1313u = -1;
            this.f1314v = -1;
            this.f1315w = Integer.MIN_VALUE;
            this.f1316x = Integer.MIN_VALUE;
            this.f1317y = Integer.MIN_VALUE;
            this.z = Integer.MIN_VALUE;
            this.A = Integer.MIN_VALUE;
            this.B = Integer.MIN_VALUE;
            this.C = Integer.MIN_VALUE;
            this.D = 0;
            this.E = 0.5f;
            this.F = 0.5f;
            this.G = null;
            this.H = -1.0f;
            this.I = -1.0f;
            this.J = 0;
            this.K = 0;
            this.L = 0;
            this.M = 0;
            this.N = 0;
            this.O = 0;
            this.P = 0;
            this.Q = 0;
            this.R = 1.0f;
            this.S = 1.0f;
            this.T = -1;
            this.U = -1;
            this.V = -1;
            this.W = false;
            this.X = false;
            this.Y = null;
            this.Z = 0;
            this.f1282a0 = true;
            this.b0 = true;
            this.c0 = false;
            this.f1286d0 = false;
            this.f1288e0 = false;
            this.f1290f0 = false;
            this.f1292g0 = -1;
            this.f1293h0 = -1;
            this.f1295i0 = -1;
            this.f1297j0 = -1;
            this.f1299k0 = Integer.MIN_VALUE;
            this.f1301l0 = Integer.MIN_VALUE;
            this.f1303m0 = 0.5f;
            this.q0 = new ConstraintWidget();
        }
    }
}
