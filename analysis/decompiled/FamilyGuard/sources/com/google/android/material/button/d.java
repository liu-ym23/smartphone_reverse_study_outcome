package com.google.android.material.button;

import a1.C0409b;
import a1.C0417j;
import a1.C0418k;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.internal.o;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;
import t1.C1108a;
import t1.InterfaceC1111d;
import t1.l;
import t1.p;
import t1.q;
import t1.r;
import x1.C1282a;

/* loaded from: classes.dex */
public class d extends LinearLayout {

    /* renamed from: k, reason: collision with root package name */
    private static final int f12433k = C0417j.f6918i;

    /* renamed from: a, reason: collision with root package name */
    private final List<l> f12434a;

    /* renamed from: b, reason: collision with root package name */
    private final List<q> f12435b;

    /* renamed from: c, reason: collision with root package name */
    private final b f12436c;

    /* renamed from: d, reason: collision with root package name */
    private final Comparator<MaterialButton> f12437d;

    /* renamed from: e, reason: collision with root package name */
    private Integer[] f12438e;

    /* renamed from: f, reason: collision with root package name */
    p f12439f;

    /* renamed from: g, reason: collision with root package name */
    private q f12440g;

    /* renamed from: h, reason: collision with root package name */
    private int f12441h;

    /* renamed from: i, reason: collision with root package name */
    private r f12442i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f12443j;

    private class b implements MaterialButton.c {
        private b() {
        }

        @Override // com.google.android.material.button.MaterialButton.c
        public void a(MaterialButton materialButton, boolean z5) {
            d.this.invalidate();
        }
    }

    public d(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0409b.f6727n);
    }

    public static /* synthetic */ int a(d dVar, MaterialButton materialButton, MaterialButton materialButton2) {
        dVar.getClass();
        int iCompareTo = Boolean.valueOf(materialButton.isChecked()).compareTo(Boolean.valueOf(materialButton2.isChecked()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        int iCompareTo2 = Boolean.valueOf(materialButton.isPressed()).compareTo(Boolean.valueOf(materialButton2.isPressed()));
        return iCompareTo2 != 0 ? iCompareTo2 : Integer.compare(dVar.indexOfChild(materialButton), dVar.indexOfChild(materialButton2));
    }

    private void b() {
        int iMin;
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        if (firstVisibleChildIndex == -1) {
            return;
        }
        for (int i5 = firstVisibleChildIndex + 1; i5 < getChildCount(); i5++) {
            MaterialButton materialButtonF = f(i5);
            MaterialButton materialButtonF2 = f(i5 - 1);
            if (this.f12441h <= 0) {
                iMin = Math.min(materialButtonF.getStrokeWidth(), materialButtonF2.getStrokeWidth());
                materialButtonF.setShouldDrawSurfaceColorStroke(true);
                materialButtonF2.setShouldDrawSurfaceColorStroke(true);
            } else {
                materialButtonF.setShouldDrawSurfaceColorStroke(false);
                materialButtonF2.setShouldDrawSurfaceColorStroke(false);
                iMin = 0;
            }
            LinearLayout.LayoutParams layoutParamsD = d(materialButtonF);
            if (getOrientation() == 0) {
                layoutParamsD.setMarginEnd(0);
                layoutParamsD.setMarginStart(this.f12441h - iMin);
                layoutParamsD.topMargin = 0;
            } else {
                layoutParamsD.bottomMargin = 0;
                layoutParamsD.topMargin = this.f12441h - iMin;
                layoutParamsD.setMarginStart(0);
            }
            materialButtonF.setLayoutParams(layoutParamsD);
        }
        m(firstVisibleChildIndex);
    }

    private void c() {
        if (this.f12442i == null || getChildCount() == 0) {
            return;
        }
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        int lastVisibleChildIndex = getLastVisibleChildIndex();
        int iMin = Integer.MAX_VALUE;
        for (int i5 = firstVisibleChildIndex; i5 <= lastVisibleChildIndex; i5++) {
            if (j(i5)) {
                int iE = e(i5);
                if (i5 != firstVisibleChildIndex && i5 != lastVisibleChildIndex) {
                    iE /= 2;
                }
                iMin = Math.min(iMin, iE);
            }
        }
        int i6 = firstVisibleChildIndex;
        while (i6 <= lastVisibleChildIndex) {
            if (j(i6)) {
                f(i6).setSizeChange(this.f12442i);
                f(i6).setWidthChangeMax((i6 == firstVisibleChildIndex || i6 == lastVisibleChildIndex) ? iMin : iMin * 2);
            }
            i6++;
        }
    }

    private int e(int i5) {
        if (!j(i5) || this.f12442i == null) {
            return 0;
        }
        int iMax = Math.max(0, this.f12442i.c(f(i5).getWidth()));
        MaterialButton materialButtonI = i(i5);
        int allowedWidthDecrease = materialButtonI == null ? 0 : materialButtonI.getAllowedWidthDecrease();
        MaterialButton materialButtonG = g(i5);
        return Math.min(iMax, allowedWidthDecrease + (materialButtonG != null ? materialButtonG.getAllowedWidthDecrease() : 0));
    }

    private MaterialButton g(int i5) {
        int childCount = getChildCount();
        do {
            i5++;
            if (i5 >= childCount) {
                return null;
            }
        } while (!j(i5));
        return f(i5);
    }

    private int getFirstVisibleChildIndex() {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            if (j(i5)) {
                return i5;
            }
        }
        return -1;
    }

    private int getLastVisibleChildIndex() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            if (j(childCount)) {
                return childCount;
            }
        }
        return -1;
    }

    private q.b h(boolean z5, boolean z6, int i5) {
        q qVar = this.f12440g;
        if (qVar == null || (!z5 && !z6)) {
            qVar = this.f12435b.get(i5);
        }
        return qVar == null ? new q.b(this.f12434a.get(i5)) : qVar.i();
    }

    private MaterialButton i(int i5) {
        for (int i6 = i5 - 1; i6 >= 0; i6--) {
            if (j(i6)) {
                return f(i6);
            }
        }
        return null;
    }

    private boolean j(int i5) {
        return getChildAt(i5).getVisibility() != 8;
    }

    private void l() {
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            f(i5).o();
        }
    }

    private void m(int i5) {
        if (getChildCount() == 0 || i5 == -1) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) f(i5).getLayoutParams();
        if (getOrientation() == 1) {
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
        } else {
            layoutParams.setMarginEnd(0);
            layoutParams.setMarginStart(0);
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
        }
    }

    private void n() {
        TreeMap treeMap = new TreeMap(this.f12437d);
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            treeMap.put(f(i5), Integer.valueOf(i5));
        }
        this.f12438e = (Integer[]) treeMap.values().toArray(new Integer[0]);
    }

    private void setGeneratedIdIfNeeded(MaterialButton materialButton) {
        if (materialButton.getId() == -1) {
            materialButton.setId(View.generateViewId());
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i5, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof MaterialButton)) {
            Log.e("MButtonGroup", "Child views must be of type MaterialButton.");
            return;
        }
        l();
        this.f12443j = true;
        super.addView(view, i5, layoutParams);
        MaterialButton materialButton = (MaterialButton) view;
        setGeneratedIdIfNeeded(materialButton);
        materialButton.setOnPressedChangeListenerInternal(this.f12436c);
        this.f12434a.add(materialButton.getShapeAppearanceModel());
        this.f12435b.add(materialButton.getStateListShapeAppearanceModel());
        materialButton.setEnabled(isEnabled());
    }

    LinearLayout.LayoutParams d(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        return layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : new LinearLayout.LayoutParams(layoutParams.width, layoutParams.height);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        n();
        super.dispatchDraw(canvas);
    }

    MaterialButton f(int i5) {
        return (MaterialButton) getChildAt(i5);
    }

    public r getButtonSizeChange() {
        return this.f12442i;
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i5, int i6) {
        Integer[] numArr = this.f12438e;
        if (numArr != null && i6 < numArr.length) {
            return numArr[i6].intValue();
        }
        Log.w("MButtonGroup", "Child order wasn't updated");
        return i6;
    }

    public InterfaceC1111d getInnerCornerSize() {
        return this.f12439f.e();
    }

    public p getInnerCornerSizeStateList() {
        return this.f12439f;
    }

    public l getShapeAppearance() {
        q qVar = this.f12440g;
        if (qVar == null) {
            return null;
        }
        return qVar.c(true);
    }

    public int getSpacing() {
        return this.f12441h;
    }

    public q getStateListShapeAppearance() {
        return this.f12440g;
    }

    void k(MaterialButton materialButton, int i5) {
        int iIndexOfChild = indexOfChild(materialButton);
        if (iIndexOfChild < 0) {
            return;
        }
        MaterialButton materialButtonI = i(iIndexOfChild);
        MaterialButton materialButtonG = g(iIndexOfChild);
        if (materialButtonI == null && materialButtonG == null) {
            return;
        }
        if (materialButtonI == null) {
            materialButtonG.setDisplayedWidthDecrease(i5);
        }
        if (materialButtonG == null) {
            materialButtonI.setDisplayedWidthDecrease(i5);
        }
        if (materialButtonI == null || materialButtonG == null) {
            return;
        }
        materialButtonI.setDisplayedWidthDecrease(i5 / 2);
        materialButtonG.setDisplayedWidthDecrease((i5 + 1) / 2);
    }

    void o() {
        int iH;
        if (!(this.f12439f == null && this.f12440g == null) && this.f12443j) {
            this.f12443j = false;
            int childCount = getChildCount();
            int firstVisibleChildIndex = getFirstVisibleChildIndex();
            int lastVisibleChildIndex = getLastVisibleChildIndex();
            int i5 = 0;
            while (i5 < childCount) {
                MaterialButton materialButtonF = f(i5);
                if (materialButtonF.getVisibility() != 8) {
                    boolean z5 = i5 == firstVisibleChildIndex;
                    boolean z6 = i5 == lastVisibleChildIndex;
                    q.b bVarH = h(z5, z6, i5);
                    boolean z7 = getOrientation() == 0;
                    boolean zG = com.google.android.material.internal.r.g(this);
                    if (z7) {
                        iH = z5 ? 5 : 0;
                        if (z6) {
                            iH |= 10;
                        }
                        if (zG) {
                            iH = q.h(iH);
                        }
                    } else {
                        iH = z5 ? 3 : 0;
                        if (z6) {
                            iH |= 12;
                        }
                    }
                    q qVarJ = bVarH.n(this.f12439f, ~iH).j();
                    if (qVarJ.f()) {
                        materialButtonF.setStateListShapeAppearanceModel(qVarJ);
                    } else {
                        materialButtonF.setShapeAppearanceModel(qVarJ.c(true));
                    }
                }
                i5++;
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z5, int i5, int i6, int i7, int i8) {
        super.onLayout(z5, i5, i6, i7, i8);
        if (z5) {
            l();
            c();
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i5, int i6) {
        o();
        b();
        super.onMeasure(i5, i6);
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if (view instanceof MaterialButton) {
            ((MaterialButton) view).setOnPressedChangeListenerInternal(null);
        }
        int iIndexOfChild = indexOfChild(view);
        if (iIndexOfChild >= 0) {
            this.f12434a.remove(iIndexOfChild);
            this.f12435b.remove(iIndexOfChild);
        }
        this.f12443j = true;
        o();
        l();
        b();
    }

    public void setButtonSizeChange(r rVar) {
        if (this.f12442i != rVar) {
            this.f12442i = rVar;
            c();
            requestLayout();
            invalidate();
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z5) {
        super.setEnabled(z5);
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            f(i5).setEnabled(z5);
        }
    }

    public void setInnerCornerSize(InterfaceC1111d interfaceC1111d) {
        this.f12439f = p.c(interfaceC1111d);
        this.f12443j = true;
        o();
        invalidate();
    }

    public void setInnerCornerSizeStateList(p pVar) {
        this.f12439f = pVar;
        this.f12443j = true;
        o();
        invalidate();
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i5) {
        if (getOrientation() != i5) {
            this.f12443j = true;
        }
        super.setOrientation(i5);
    }

    public void setShapeAppearance(l lVar) {
        this.f12440g = new q.b(lVar).j();
        this.f12443j = true;
        o();
        invalidate();
    }

    public void setSpacing(int i5) {
        this.f12441h = i5;
        invalidate();
        requestLayout();
    }

    public void setStateListShapeAppearance(q qVar) {
        this.f12440g = qVar;
        this.f12443j = true;
        o();
        invalidate();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public d(Context context, AttributeSet attributeSet, int i5) {
        int i6 = f12433k;
        super(C1282a.d(context, attributeSet, i5, i6), attributeSet, i5);
        this.f12434a = new ArrayList();
        this.f12435b = new ArrayList();
        this.f12436c = new b();
        this.f12437d = new Comparator() { // from class: com.google.android.material.button.c
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return d.a(this.f12432a, (MaterialButton) obj, (MaterialButton) obj2);
            }
        };
        this.f12443j = true;
        Context context2 = getContext();
        TypedArray typedArrayI = o.i(context2, attributeSet, C0418k.f7165l2, i5, i6, new int[0]);
        int i7 = C0418k.f7183o2;
        if (typedArrayI.hasValue(i7)) {
            this.f12442i = r.b(context2, typedArrayI, i7);
        }
        int i8 = C0418k.f7195q2;
        if (typedArrayI.hasValue(i8)) {
            q qVarB = q.b(context2, typedArrayI, i8);
            this.f12440g = qVarB;
            if (qVarB == null) {
                this.f12440g = new q.b(l.b(context2, typedArrayI.getResourceId(i8, 0), typedArrayI.getResourceId(C0418k.f7201r2, 0)).m()).j();
            }
        }
        int i9 = C0418k.f7189p2;
        if (typedArrayI.hasValue(i9)) {
            this.f12439f = p.b(context2, typedArrayI, i9, new C1108a(0.0f));
        }
        this.f12441h = typedArrayI.getDimensionPixelSize(C0418k.f7177n2, 0);
        setChildrenDrawingOrderEnabled(true);
        setEnabled(typedArrayI.getBoolean(C0418k.f7171m2, true));
        typedArrayI.recycle();
    }
}
