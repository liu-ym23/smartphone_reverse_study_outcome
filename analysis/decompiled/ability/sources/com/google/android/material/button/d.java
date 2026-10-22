package com.google.android.material.button;

import F9.x;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import com.google.android.material.internal.k;
import com.google.android.material.shape.StateListSizeChange$SizeChangeType;
import com.stepos.ability.R;
import e3.C1408B;
import e3.C1409C;
import e3.C1410D;
import e3.C1411E;
import e3.C1412a;
import e3.InterfaceC1415d;
import e3.p;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;
import org.xmlpull.v1.XmlPullParserException;
import u1.C2031a;

/* loaded from: classes3.dex */
public abstract class d extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f2366a;
    public final ArrayList b;
    public final C2031a c;
    public final F7.a d;
    public Integer[] e;
    public C1408B f;
    public C1409C g;
    public int h;
    public C1411E i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f2367j;

    public d(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        C1408B c1408bB;
        XmlResourceParser xml;
        int next;
        C1411E c1411e;
        int next2;
        super(i3.a.a(context, attributeSet, R.attr.materialButtonToggleGroupStyle, R.style.Widget_Material3_MaterialButtonGroup), attributeSet, R.attr.materialButtonToggleGroupStyle);
        this.f2366a = new ArrayList();
        this.b = new ArrayList();
        MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) this;
        this.c = new C2031a(materialButtonToggleGroup);
        this.d = new F7.a(materialButtonToggleGroup, 1);
        this.f2367j = true;
        Context context2 = getContext();
        TypedArray typedArrayD = k.d(context2, attributeSet, P2.a.o, R.attr.materialButtonToggleGroupStyle, R.style.Widget_Material3_MaterialButtonGroup, new int[0]);
        if (typedArrayD.hasValue(2)) {
            int resourceId = typedArrayD.getResourceId(2, 0);
            if (resourceId != 0 && context2.getResources().getResourceTypeName(resourceId).equals("xml")) {
                try {
                    xml = context2.getResources().getXml(resourceId);
                } catch (Resources.NotFoundException | IOException | XmlPullParserException unused) {
                }
                try {
                    c1411e = new C1411E();
                    c1411e.c = new int[10][];
                    c1411e.d = new B1.c[10];
                    AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
                    do {
                        next2 = xml.next();
                        if (next2 == 2) {
                            break;
                        }
                    } while (next2 != 1);
                    if (next2 != 2) {
                        throw new XmlPullParserException("No start tag found");
                    }
                    if (xml.getName().equals("selector")) {
                        c1411e.a(context2, xml, attributeSetAsAttributeSet, context2.getTheme());
                    }
                    xml.close();
                    this.i = c1411e;
                } finally {
                }
            } else {
                c1411e = null;
                this.i = c1411e;
            }
        }
        if (typedArrayD.hasValue(4)) {
            C1409C c1409cB = C1409C.b(context2, typedArrayD, 4);
            this.g = c1409cB;
            if (c1409cB == null) {
                x xVar = new x(p.a(context2, typedArrayD.getResourceId(4, 0), typedArrayD.getResourceId(5, 0), new C1412a(0)).a());
                this.g = xVar.b != 0 ? new C1409C(xVar) : null;
            }
        }
        if (typedArrayD.hasValue(3)) {
            C1412a c1412a = new C1412a(0.0f);
            int resourceId2 = typedArrayD.getResourceId(3, 0);
            if (resourceId2 != 0 && context2.getResources().getResourceTypeName(resourceId2).equals("xml")) {
                try {
                    xml = context2.getResources().getXml(resourceId2);
                    try {
                        c1408bB = new C1408B();
                        AttributeSet attributeSetAsAttributeSet2 = Xml.asAttributeSet(xml);
                        do {
                            next = xml.next();
                            if (next == 2) {
                                break;
                            }
                        } while (next != 1);
                        if (next != 2) {
                            throw new XmlPullParserException("No start tag found");
                        }
                        if (xml.getName().equals("selector")) {
                            c1408bB.d(context2, xml, attributeSetAsAttributeSet2, context2.getTheme());
                        }
                        xml.close();
                    } finally {
                    }
                } catch (Resources.NotFoundException | IOException | XmlPullParserException unused2) {
                    c1408bB = C1408B.b(c1412a);
                }
            } else {
                c1408bB = C1408B.b(p.c(typedArrayD, 3, c1412a));
            }
            this.f = c1408bB;
        }
        this.h = typedArrayD.getDimensionPixelSize(1, 0);
        setChildrenDrawingOrderEnabled(true);
        setEnabled(typedArrayD.getBoolean(0, true));
        typedArrayD.recycle();
    }

    private int getFirstVisibleChildIndex() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (c(i)) {
                return i;
            }
        }
        return -1;
    }

    private int getLastVisibleChildIndex() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            if (c(childCount)) {
                return childCount;
            }
        }
        return -1;
    }

    private void setGeneratedIdIfNeeded(@NonNull MaterialButton materialButton) {
        if (materialButton.getId() == -1) {
            materialButton.setId(View.generateViewId());
        }
    }

    public final void a() {
        int iMin;
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        if (firstVisibleChildIndex == -1) {
            return;
        }
        for (int i = firstVisibleChildIndex + 1; i < getChildCount(); i++) {
            MaterialButton materialButton = (MaterialButton) getChildAt(i);
            MaterialButton materialButton2 = (MaterialButton) getChildAt(i - 1);
            if (this.h <= 0) {
                iMin = Math.min(materialButton.getStrokeWidth(), materialButton2.getStrokeWidth());
                materialButton.setShouldDrawSurfaceColorStroke(true);
                materialButton2.setShouldDrawSurfaceColorStroke(true);
            } else {
                materialButton.setShouldDrawSurfaceColorStroke(false);
                materialButton2.setShouldDrawSurfaceColorStroke(false);
                iMin = 0;
            }
            ViewGroup.LayoutParams layoutParams = materialButton.getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : new LinearLayout.LayoutParams(layoutParams.width, layoutParams.height);
            if (getOrientation() == 0) {
                layoutParams2.setMarginEnd(0);
                layoutParams2.setMarginStart(this.h - iMin);
                layoutParams2.topMargin = 0;
            } else {
                layoutParams2.bottomMargin = 0;
                layoutParams2.topMargin = this.h - iMin;
                layoutParams2.setMarginStart(0);
            }
            materialButton.setLayoutParams(layoutParams2);
        }
        if (getChildCount() == 0 || firstVisibleChildIndex == -1) {
            return;
        }
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) ((MaterialButton) getChildAt(firstVisibleChildIndex)).getLayoutParams();
        if (getOrientation() == 1) {
            layoutParams3.topMargin = 0;
            layoutParams3.bottomMargin = 0;
        } else {
            layoutParams3.setMarginEnd(0);
            layoutParams3.setMarginStart(0);
            layoutParams3.leftMargin = 0;
            layoutParams3.rightMargin = 0;
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof MaterialButton)) {
            Log.e("MButtonGroup", "Child views must be of type MaterialButton.");
            return;
        }
        d();
        this.f2367j = true;
        super.addView(view, i, layoutParams);
        MaterialButton materialButton = (MaterialButton) view;
        setGeneratedIdIfNeeded(materialButton);
        materialButton.setOnPressedChangeListenerInternal(this.c);
        this.f2366a.add(materialButton.getShapeAppearanceModel());
        this.b.add(materialButton.getStateListShapeAppearanceModel());
        materialButton.setEnabled(isEnabled());
    }

    public final void b() {
        MaterialButton materialButton;
        MaterialButton materialButton2;
        float fMax;
        if (this.i == null || getChildCount() == 0) {
            return;
        }
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        int lastVisibleChildIndex = getLastVisibleChildIndex();
        int iMin = Integer.MAX_VALUE;
        for (int i = firstVisibleChildIndex; i <= lastVisibleChildIndex; i++) {
            if (c(i)) {
                if (c(i) && this.i != null) {
                    MaterialButton materialButton3 = (MaterialButton) getChildAt(i);
                    C1411E c1411e = this.i;
                    int width = materialButton3.getWidth();
                    int i6 = -width;
                    for (int i10 = 0; i10 < c1411e.f4340a; i10++) {
                        C1410D c1410d = (C1410D) c1411e.d[i10].f180a;
                        StateListSizeChange$SizeChangeType stateListSizeChange$SizeChangeType = c1410d.f4339a;
                        float f = c1410d.b;
                        if (stateListSizeChange$SizeChangeType == StateListSizeChange$SizeChangeType.b) {
                            fMax = Math.max(i6, f);
                        } else if (stateListSizeChange$SizeChangeType == StateListSizeChange$SizeChangeType.f2508a) {
                            fMax = Math.max(i6, width * f);
                        }
                        i6 = (int) fMax;
                    }
                    int iMax = Math.max(0, i6);
                    int i11 = i - 1;
                    while (true) {
                        materialButton = null;
                        if (i11 < 0) {
                            materialButton2 = null;
                            break;
                        } else {
                            if (c(i11)) {
                                materialButton2 = (MaterialButton) getChildAt(i11);
                                break;
                            }
                            i11--;
                        }
                    }
                    int allowedWidthDecrease = materialButton2 == null ? 0 : materialButton2.getAllowedWidthDecrease();
                    int childCount = getChildCount();
                    int i12 = i + 1;
                    while (true) {
                        if (i12 >= childCount) {
                            break;
                        }
                        if (c(i12)) {
                            materialButton = (MaterialButton) getChildAt(i12);
                            break;
                        }
                        i12++;
                    }
                    iMin = Math.min(iMax, allowedWidthDecrease + (materialButton != null ? materialButton.getAllowedWidthDecrease() : 0));
                }
                if (i != firstVisibleChildIndex && i != lastVisibleChildIndex) {
                    iMin /= 2;
                }
                iMin = Math.min(iMin, iMin);
            }
        }
        int i13 = firstVisibleChildIndex;
        while (i13 <= lastVisibleChildIndex) {
            if (c(i13)) {
                ((MaterialButton) getChildAt(i13)).setSizeChange(this.i);
                ((MaterialButton) getChildAt(i13)).setWidthChangeMax((i13 == firstVisibleChildIndex || i13 == lastVisibleChildIndex) ? iMin : iMin * 2);
            }
            i13++;
        }
    }

    public final boolean c(int i) {
        return getChildAt(i).getVisibility() != 8;
    }

    public final void d() {
        for (int i = 0; i < getChildCount(); i++) {
            MaterialButton materialButton = (MaterialButton) getChildAt(i);
            LinearLayout.LayoutParams layoutParams = materialButton.f2358s;
            if (layoutParams != null) {
                materialButton.setLayoutParams(layoutParams);
                materialButton.f2358s = null;
                materialButton.p = -1.0f;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        TreeMap treeMap = new TreeMap(this.d);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            treeMap.put((MaterialButton) getChildAt(i), Integer.valueOf(i));
        }
        this.e = (Integer[]) treeMap.values().toArray(new Integer[0]);
        super.dispatchDraw(canvas);
    }

    public final void e() {
        x xVar;
        int i;
        if (!(this.f == null && this.g == null) && this.f2367j) {
            this.f2367j = false;
            int childCount = getChildCount();
            int firstVisibleChildIndex = getFirstVisibleChildIndex();
            int lastVisibleChildIndex = getLastVisibleChildIndex();
            int i6 = 0;
            while (i6 < childCount) {
                MaterialButton materialButton = (MaterialButton) getChildAt(i6);
                if (materialButton.getVisibility() != 8) {
                    boolean z10 = i6 == firstVisibleChildIndex;
                    boolean z11 = i6 == lastVisibleChildIndex;
                    C1409C c1409c = this.g;
                    if (c1409c == null || (!z10 && !z11)) {
                        c1409c = (C1409C) this.b.get(i6);
                    }
                    if (c1409c == null) {
                        xVar = new x((p) this.f2366a.get(i6));
                    } else {
                        x xVar2 = new x(2);
                        int i10 = c1409c.f4338a;
                        xVar2.b = i10;
                        xVar2.d = c1409c.b;
                        int[][] iArr = c1409c.c;
                        int[][] iArr2 = new int[iArr.length][];
                        xVar2.e = iArr2;
                        p[] pVarArr = c1409c.d;
                        xVar2.f = new p[pVarArr.length];
                        System.arraycopy(iArr, 0, iArr2, 0, i10);
                        System.arraycopy(pVarArr, 0, (p[]) xVar2.f, 0, xVar2.b);
                        xVar2.g = c1409c.e;
                        xVar2.h = c1409c.f;
                        xVar2.c = c1409c.g;
                        xVar2.i = c1409c.h;
                        xVar = xVar2;
                    }
                    boolean z12 = getOrientation() == 0;
                    boolean z13 = getLayoutDirection() == 1;
                    if (z12) {
                        i = z10 ? 5 : 0;
                        if (z11) {
                            i |= 10;
                        }
                        if (z13) {
                            i = ((i & 10) >> 1) | ((i & 5) << 1);
                        }
                    } else {
                        i = z10 ? 3 : 0;
                        if (z11) {
                            i |= 12;
                        }
                    }
                    int i11 = ~i;
                    C1408B c1408b = this.f;
                    if ((i11 | 1) == i11) {
                        xVar.g = c1408b;
                    }
                    if ((i11 | 2) == i11) {
                        xVar.h = c1408b;
                    }
                    if ((i11 | 4) == i11) {
                        xVar.c = c1408b;
                    }
                    if ((i11 | 8) == i11) {
                        xVar.i = c1408b;
                    }
                    C1409C c1409c2 = xVar.b == 0 ? null : new C1409C(xVar);
                    if (c1409c2.d()) {
                        materialButton.setStateListShapeAppearanceModel(c1409c2);
                    } else {
                        materialButton.setShapeAppearanceModel(c1409c2.c());
                    }
                }
                i6++;
            }
        }
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public C1411E getButtonSizeChange() {
        return this.i;
    }

    @Override // android.view.ViewGroup
    public final int getChildDrawingOrder(int i, int i6) {
        Integer[] numArr = this.e;
        if (numArr != null && i6 < numArr.length) {
            return numArr[i6].intValue();
        }
        Log.w("MButtonGroup", "Child order wasn't updated");
        return i6;
    }

    @NonNull
    public InterfaceC1415d getInnerCornerSize() {
        return this.f.b;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public C1408B getInnerCornerSizeStateList() {
        return this.f;
    }

    @Nullable
    public p getShapeAppearance() {
        C1409C c1409c = this.g;
        if (c1409c == null) {
            return null;
        }
        return c1409c.c();
    }

    @Px
    public int getSpacing() {
        return this.h;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public C1409C getStateListShapeAppearance() {
        return this.g;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z10, int i, int i6, int i10, int i11) {
        super.onLayout(z10, i, i6, i10, i11);
        if (z10) {
            d();
            b();
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i, int i6) {
        e();
        a();
        super.onMeasure(i, i6);
    }

    @Override // android.view.ViewGroup
    public final void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if (view instanceof MaterialButton) {
            ((MaterialButton) view).setOnPressedChangeListenerInternal(null);
        }
        int iIndexOfChild = indexOfChild(view);
        if (iIndexOfChild >= 0) {
            this.f2366a.remove(iIndexOfChild);
            this.b.remove(iIndexOfChild);
        }
        this.f2367j = true;
        e();
        d();
        a();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setButtonSizeChange(@NonNull C1411E c1411e) {
        if (this.i != c1411e) {
            this.i = c1411e;
            b();
            requestLayout();
            invalidate();
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        for (int i = 0; i < getChildCount(); i++) {
            ((MaterialButton) getChildAt(i)).setEnabled(z10);
        }
    }

    public void setInnerCornerSize(@NonNull InterfaceC1415d interfaceC1415d) {
        this.f = C1408B.b(interfaceC1415d);
        this.f2367j = true;
        e();
        invalidate();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setInnerCornerSizeStateList(@NonNull C1408B c1408b) {
        this.f = c1408b;
        this.f2367j = true;
        e();
        invalidate();
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i) {
        if (getOrientation() != i) {
            this.f2367j = true;
        }
        super.setOrientation(i);
    }

    public void setShapeAppearance(@Nullable p pVar) {
        x xVar = new x(pVar);
        this.g = xVar.b == 0 ? null : new C1409C(xVar);
        this.f2367j = true;
        e();
        invalidate();
    }

    public void setSpacing(@Px int i) {
        this.h = i;
        invalidate();
        requestLayout();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setStateListShapeAppearance(@Nullable C1409C c1409c) {
        this.g = c1409c;
        this.f2367j = true;
        e();
        invalidate();
    }
}
