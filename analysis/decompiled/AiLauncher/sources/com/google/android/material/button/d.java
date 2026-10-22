package com.google.android.material.button;

import Z2.l;
import Z2.r;
import Z2.s;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.internal.u;
import com.google.android.material.shape.StateListSizeChange;
import d3.C3953a;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

/* loaded from: classes2.dex */
public class d extends LinearLayout {

    /* renamed from: k, reason: collision with root package name */
    public static final int f20496k = R$style.Widget_Material3_MaterialButtonGroup;

    /* renamed from: a, reason: collision with root package name */
    public final List<l> f20497a;

    /* renamed from: b, reason: collision with root package name */
    public final List<s> f20498b;

    /* renamed from: c, reason: collision with root package name */
    public final b f20499c;

    /* renamed from: d, reason: collision with root package name */
    public final Comparator<MaterialButton> f20500d;

    /* renamed from: e, reason: collision with root package name */
    public Integer[] f20501e;

    /* renamed from: f, reason: collision with root package name */
    public r f20502f;

    /* renamed from: g, reason: collision with root package name */
    public s f20503g;

    /* renamed from: h, reason: collision with root package name */
    public int f20504h;

    /* renamed from: i, reason: collision with root package name */
    public StateListSizeChange f20505i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f20506j;

    public class b implements MaterialButton.c {
        public b() {
        }

        @Override // com.google.android.material.button.MaterialButton.c
        public void a(MaterialButton materialButton, boolean z10) {
            d.this.invalidate();
        }
    }

    public d(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.materialButtonGroupStyle);
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

    private int getFirstVisibleChildIndex() {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            if (j(i10)) {
                return i10;
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

    private boolean j(int i10) {
        return getChildAt(i10).getVisibility() != 8;
    }

    private void setGeneratedIdIfNeeded(MaterialButton materialButton) {
        if (materialButton.getId() == -1) {
            materialButton.setId(View.generateViewId());
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof MaterialButton)) {
            Log.e("MButtonGroup", "Child views must be of type MaterialButton.");
            return;
        }
        l();
        this.f20506j = true;
        super.addView(view, i10, layoutParams);
        MaterialButton materialButton = (MaterialButton) view;
        setGeneratedIdIfNeeded(materialButton);
        materialButton.setOnPressedChangeListenerInternal(this.f20499c);
        this.f20497a.add(materialButton.getShapeAppearanceModel());
        this.f20498b.add(materialButton.getStateListShapeAppearanceModel());
        materialButton.setEnabled(isEnabled());
    }

    public final void b() {
        int iMin;
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        if (firstVisibleChildIndex == -1) {
            return;
        }
        for (int i10 = firstVisibleChildIndex + 1; i10 < getChildCount(); i10++) {
            MaterialButton materialButtonF = f(i10);
            MaterialButton materialButtonF2 = f(i10 - 1);
            if (this.f20504h <= 0) {
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
                layoutParamsD.setMarginStart(this.f20504h - iMin);
                layoutParamsD.topMargin = 0;
            } else {
                layoutParamsD.bottomMargin = 0;
                layoutParamsD.topMargin = this.f20504h - iMin;
                layoutParamsD.setMarginStart(0);
            }
            materialButtonF.setLayoutParams(layoutParamsD);
        }
        m(firstVisibleChildIndex);
    }

    public final void c() {
        if (this.f20505i == null || getChildCount() == 0) {
            return;
        }
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        int lastVisibleChildIndex = getLastVisibleChildIndex();
        int iMin = Integer.MAX_VALUE;
        for (int i10 = firstVisibleChildIndex; i10 <= lastVisibleChildIndex; i10++) {
            if (j(i10)) {
                int iE = e(i10);
                if (i10 != firstVisibleChildIndex && i10 != lastVisibleChildIndex) {
                    iE /= 2;
                }
                iMin = Math.min(iMin, iE);
            }
        }
        int i11 = firstVisibleChildIndex;
        while (i11 <= lastVisibleChildIndex) {
            if (j(i11)) {
                f(i11).setSizeChange(this.f20505i);
                f(i11).setWidthChangeMax((i11 == firstVisibleChildIndex || i11 == lastVisibleChildIndex) ? iMin : iMin * 2);
            }
            i11++;
        }
    }

    public LinearLayout.LayoutParams d(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        return layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : new LinearLayout.LayoutParams(layoutParams.width, layoutParams.height);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        n();
        super.dispatchDraw(canvas);
    }

    public final int e(int i10) {
        if (!j(i10) || this.f20505i == null) {
            return 0;
        }
        int iMax = Math.max(0, this.f20505i.c(f(i10).getWidth()));
        MaterialButton materialButtonI = i(i10);
        int allowedWidthDecrease = materialButtonI == null ? 0 : materialButtonI.getAllowedWidthDecrease();
        MaterialButton materialButtonG = g(i10);
        return Math.min(iMax, allowedWidthDecrease + (materialButtonG != null ? materialButtonG.getAllowedWidthDecrease() : 0));
    }

    public MaterialButton f(int i10) {
        return (MaterialButton) getChildAt(i10);
    }

    public final MaterialButton g(int i10) {
        int childCount = getChildCount();
        do {
            i10++;
            if (i10 >= childCount) {
                return null;
            }
        } while (!j(i10));
        return f(i10);
    }

    public StateListSizeChange getButtonSizeChange() {
        return this.f20505i;
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i10, int i11) {
        Integer[] numArr = this.f20501e;
        if (numArr != null && i11 < numArr.length) {
            return numArr[i11].intValue();
        }
        Log.w("MButtonGroup", "Child order wasn't updated");
        return i11;
    }

    public Z2.d getInnerCornerSize() {
        return this.f20502f.e();
    }

    public r getInnerCornerSizeStateList() {
        return this.f20502f;
    }

    public l getShapeAppearance() {
        s sVar = this.f20503g;
        if (sVar == null) {
            return null;
        }
        return sVar.c(true);
    }

    public int getSpacing() {
        return this.f20504h;
    }

    public s getStateListShapeAppearance() {
        return this.f20503g;
    }

    public final s.b h(boolean z10, boolean z11, int i10) {
        s sVar = this.f20503g;
        if (sVar == null || (!z10 && !z11)) {
            sVar = this.f20498b.get(i10);
        }
        return sVar == null ? new s.b(this.f20497a.get(i10)) : sVar.i();
    }

    public final MaterialButton i(int i10) {
        for (int i11 = i10 - 1; i11 >= 0; i11--) {
            if (j(i11)) {
                return f(i11);
            }
        }
        return null;
    }

    public void k(MaterialButton materialButton, int i10) {
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
            materialButtonG.setDisplayedWidthDecrease(i10);
        }
        if (materialButtonG == null) {
            materialButtonI.setDisplayedWidthDecrease(i10);
        }
        if (materialButtonI == null || materialButtonG == null) {
            return;
        }
        materialButtonI.setDisplayedWidthDecrease(i10 / 2);
        materialButtonG.setDisplayedWidthDecrease((i10 + 1) / 2);
    }

    public final void l() {
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            f(i10).o();
        }
    }

    public final void m(int i10) {
        if (getChildCount() == 0 || i10 == -1) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) f(i10).getLayoutParams();
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

    public final void n() {
        TreeMap treeMap = new TreeMap(this.f20500d);
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            treeMap.put(f(i10), Integer.valueOf(i10));
        }
        this.f20501e = (Integer[]) treeMap.values().toArray(new Integer[0]);
    }

    public void o() {
        int iH;
        if (!(this.f20502f == null && this.f20503g == null) && this.f20506j) {
            this.f20506j = false;
            int childCount = getChildCount();
            int firstVisibleChildIndex = getFirstVisibleChildIndex();
            int lastVisibleChildIndex = getLastVisibleChildIndex();
            int i10 = 0;
            while (i10 < childCount) {
                MaterialButton materialButtonF = f(i10);
                if (materialButtonF.getVisibility() != 8) {
                    boolean z10 = i10 == firstVisibleChildIndex;
                    boolean z11 = i10 == lastVisibleChildIndex;
                    s.b bVarH = h(z10, z11, i10);
                    boolean z12 = getOrientation() == 0;
                    boolean zH = u.h(this);
                    if (z12) {
                        iH = z10 ? 5 : 0;
                        if (z11) {
                            iH |= 10;
                        }
                        if (zH) {
                            iH = s.h(iH);
                        }
                    } else {
                        iH = z10 ? 3 : 0;
                        if (z11) {
                            iH |= 12;
                        }
                    }
                    s sVarJ = bVarH.n(this.f20502f, ~iH).j();
                    if (sVarJ.f()) {
                        materialButtonF.setStateListShapeAppearanceModel(sVarJ);
                    } else {
                        materialButtonF.setShapeAppearanceModel(sVarJ.c(true));
                    }
                }
                i10++;
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        if (z10) {
            l();
            c();
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        o();
        b();
        super.onMeasure(i10, i11);
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if (view instanceof MaterialButton) {
            ((MaterialButton) view).setOnPressedChangeListenerInternal(null);
        }
        int iIndexOfChild = indexOfChild(view);
        if (iIndexOfChild >= 0) {
            this.f20497a.remove(iIndexOfChild);
            this.f20498b.remove(iIndexOfChild);
        }
        this.f20506j = true;
        o();
        l();
        b();
    }

    public void setButtonSizeChange(StateListSizeChange stateListSizeChange) {
        if (this.f20505i != stateListSizeChange) {
            this.f20505i = stateListSizeChange;
            c();
            requestLayout();
            invalidate();
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            f(i10).setEnabled(z10);
        }
    }

    public void setInnerCornerSize(Z2.d dVar) {
        this.f20502f = r.b(dVar);
        this.f20506j = true;
        o();
        invalidate();
    }

    public void setInnerCornerSizeStateList(r rVar) {
        this.f20502f = rVar;
        this.f20506j = true;
        o();
        invalidate();
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i10) {
        if (getOrientation() != i10) {
            this.f20506j = true;
        }
        super.setOrientation(i10);
    }

    public void setShapeAppearance(l lVar) {
        this.f20503g = new s.b(lVar).j();
        this.f20506j = true;
        o();
        invalidate();
    }

    public void setSpacing(int i10) {
        this.f20504h = i10;
        invalidate();
        requestLayout();
    }

    public void setStateListShapeAppearance(s sVar) {
        this.f20503g = sVar;
        this.f20506j = true;
        o();
        invalidate();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public d(Context context, AttributeSet attributeSet, int i10) {
        int i11 = f20496k;
        super(C3953a.d(context, attributeSet, i10, i11), attributeSet, i10);
        this.f20497a = new ArrayList();
        this.f20498b = new ArrayList();
        this.f20499c = new b();
        this.f20500d = new Comparator() { // from class: com.google.android.material.button.c
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return d.a(this.f20495a, (MaterialButton) obj, (MaterialButton) obj2);
            }
        };
        this.f20506j = true;
        Context context2 = getContext();
        TypedArray typedArrayI = com.google.android.material.internal.r.i(context2, attributeSet, R$styleable.MaterialButtonGroup, i10, i11, new int[0]);
        int i12 = R$styleable.MaterialButtonGroup_buttonSizeChange;
        if (typedArrayI.hasValue(i12)) {
            this.f20505i = StateListSizeChange.b(context2, typedArrayI, i12);
        }
        int i13 = R$styleable.MaterialButtonGroup_shapeAppearance;
        if (typedArrayI.hasValue(i13)) {
            s sVarB = s.b(context2, typedArrayI, i13);
            this.f20503g = sVarB;
            if (sVarB == null) {
                this.f20503g = new s.b(l.b(context2, typedArrayI.getResourceId(i13, 0), typedArrayI.getResourceId(R$styleable.MaterialButtonGroup_shapeAppearanceOverlay, 0)).m()).j();
            }
        }
        int i14 = R$styleable.MaterialButtonGroup_innerCornerSize;
        if (typedArrayI.hasValue(i14)) {
            this.f20502f = r.c(context2, typedArrayI, i14, new Z2.a(0.0f));
        }
        this.f20504h = typedArrayI.getDimensionPixelSize(R$styleable.MaterialButtonGroup_android_spacing, 0);
        setChildrenDrawingOrderEnabled(true);
        setEnabled(typedArrayI.getBoolean(R$styleable.MaterialButtonGroup_android_enabled, true));
        typedArrayI.recycle();
    }
}
