package com.google.android.material.button;

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
import com.google.android.material.button.MaterialButton;
import com.google.android.material.internal.i;
import com.google.android.material.shape.StateListSizeChange;
import com.stepos.aiengine.R;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeMap;
import org.xmlpull.v1.XmlPullParserException;
import y4.j;
import y4.o;
import y4.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class c extends LinearLayout {

    /* renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f4763n = 0;

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f4764a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f4765b;

    /* renamed from: c, reason: collision with root package name */
    public final a f4766c;

    /* renamed from: d, reason: collision with root package name */
    public final b f4767d;

    /* renamed from: e, reason: collision with root package name */
    public Integer[] f4768e;
    public o h;

    /* renamed from: j, reason: collision with root package name */
    public p f4769j;

    /* renamed from: k, reason: collision with root package name */
    public int f4770k;

    /* renamed from: l, reason: collision with root package name */
    public StateListSizeChange f4771l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f4772m;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements MaterialButton.c {
        public a() {
        }
    }

    public c(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialButtonGroupStyle);
    }

    private int getFirstVisibleChildIndex() {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            if (c(i10)) {
                return i10;
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

    private void setGeneratedIdIfNeeded(MaterialButton materialButton) {
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
        for (int i10 = firstVisibleChildIndex + 1; i10 < getChildCount(); i10++) {
            MaterialButton materialButton = (MaterialButton) getChildAt(i10);
            MaterialButton materialButton2 = (MaterialButton) getChildAt(i10 - 1);
            if (this.f4770k <= 0) {
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
                layoutParams2.setMarginStart(this.f4770k - iMin);
                layoutParams2.topMargin = 0;
            } else {
                layoutParams2.bottomMargin = 0;
                layoutParams2.topMargin = this.f4770k - iMin;
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
    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof MaterialButton)) {
            Log.e("MButtonGroup", "Child views must be of type MaterialButton.");
            return;
        }
        d();
        this.f4772m = true;
        super.addView(view, i10, layoutParams);
        MaterialButton materialButton = (MaterialButton) view;
        setGeneratedIdIfNeeded(materialButton);
        materialButton.setOnPressedChangeListenerInternal(this.f4766c);
        this.f4764a.add(materialButton.getShapeAppearanceModel());
        this.f4765b.add(materialButton.getStateListShapeAppearanceModel());
        materialButton.setEnabled(isEnabled());
    }

    public final void b() {
        MaterialButton materialButton;
        MaterialButton materialButton2;
        float fMax;
        if (this.f4771l == null || getChildCount() == 0) {
            return;
        }
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        int lastVisibleChildIndex = getLastVisibleChildIndex();
        int iMin = Integer.MAX_VALUE;
        for (int i10 = firstVisibleChildIndex; i10 <= lastVisibleChildIndex; i10++) {
            if (c(i10)) {
                if (c(i10) && this.f4771l != null) {
                    MaterialButton materialButton3 = (MaterialButton) getChildAt(i10);
                    StateListSizeChange stateListSizeChange = this.f4771l;
                    int width = materialButton3.getWidth();
                    int i11 = -width;
                    for (int i12 = 0; i12 < stateListSizeChange.f5122a; i12++) {
                        StateListSizeChange.b bVar = stateListSizeChange.f5125d[i12].f5129a;
                        StateListSizeChange.SizeChangeType sizeChangeType = bVar.f5130a;
                        float f8 = bVar.f5131b;
                        if (sizeChangeType == StateListSizeChange.SizeChangeType.f5127b) {
                            fMax = Math.max(i11, f8);
                        } else if (sizeChangeType == StateListSizeChange.SizeChangeType.f5126a) {
                            fMax = Math.max(i11, width * f8);
                        }
                        i11 = (int) fMax;
                    }
                    int iMax = Math.max(0, i11);
                    int i13 = i10 - 1;
                    while (true) {
                        materialButton = null;
                        if (i13 < 0) {
                            materialButton2 = null;
                            break;
                        } else {
                            if (c(i13)) {
                                materialButton2 = (MaterialButton) getChildAt(i13);
                                break;
                            }
                            i13--;
                        }
                    }
                    int allowedWidthDecrease = materialButton2 == null ? 0 : materialButton2.getAllowedWidthDecrease();
                    int childCount = getChildCount();
                    int i14 = i10 + 1;
                    while (true) {
                        if (i14 >= childCount) {
                            break;
                        }
                        if (c(i14)) {
                            materialButton = (MaterialButton) getChildAt(i14);
                            break;
                        }
                        i14++;
                    }
                    iMin = Math.min(iMax, allowedWidthDecrease + (materialButton != null ? materialButton.getAllowedWidthDecrease() : 0));
                }
                if (i10 != firstVisibleChildIndex && i10 != lastVisibleChildIndex) {
                    iMin /= 2;
                }
                iMin = Math.min(iMin, iMin);
            }
        }
        int i15 = firstVisibleChildIndex;
        while (i15 <= lastVisibleChildIndex) {
            if (c(i15)) {
                ((MaterialButton) getChildAt(i15)).setSizeChange(this.f4771l);
                ((MaterialButton) getChildAt(i15)).setWidthChangeMax((i15 == firstVisibleChildIndex || i15 == lastVisibleChildIndex) ? iMin : iMin * 2);
            }
            i15++;
        }
    }

    public final boolean c(int i10) {
        return getChildAt(i10).getVisibility() != 8;
    }

    public final void d() {
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            MaterialButton materialButton = (MaterialButton) getChildAt(i10);
            LinearLayout.LayoutParams layoutParams = materialButton.f4753y;
            if (layoutParams != null) {
                materialButton.setLayoutParams(layoutParams);
                materialButton.f4753y = null;
                materialButton.f4750v = -1.0f;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        TreeMap treeMap = new TreeMap(this.f4767d);
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            treeMap.put((MaterialButton) getChildAt(i10), Integer.valueOf(i10));
        }
        this.f4768e = (Integer[]) treeMap.values().toArray(new Integer[0]);
        super.dispatchDraw(canvas);
    }

    public final void e() {
        p.a aVar;
        int i10;
        if (!(this.h == null && this.f4769j == null) && this.f4772m) {
            this.f4772m = false;
            int childCount = getChildCount();
            int firstVisibleChildIndex = getFirstVisibleChildIndex();
            int lastVisibleChildIndex = getLastVisibleChildIndex();
            int i11 = 0;
            while (i11 < childCount) {
                MaterialButton materialButton = (MaterialButton) getChildAt(i11);
                if (materialButton.getVisibility() != 8) {
                    boolean z = i11 == firstVisibleChildIndex;
                    boolean z3 = i11 == lastVisibleChildIndex;
                    p pVar = this.f4769j;
                    if (pVar == null || (!z && !z3)) {
                        pVar = (p) this.f4765b.get(i11);
                    }
                    if (pVar == null) {
                        aVar = new p.a((j) this.f4764a.get(i11));
                    } else {
                        p.a aVar2 = new p.a();
                        int i12 = pVar.f14119a;
                        aVar2.f14126a = i12;
                        aVar2.f14127b = pVar.f14120b;
                        int[][] iArr = pVar.f14121c;
                        int[][] iArr2 = new int[iArr.length][];
                        aVar2.f14128c = iArr2;
                        j[] jVarArr = pVar.f14122d;
                        aVar2.f14129d = new j[jVarArr.length];
                        System.arraycopy(iArr, 0, iArr2, 0, i12);
                        System.arraycopy(jVarArr, 0, aVar2.f14129d, 0, aVar2.f14126a);
                        aVar2.f14130e = pVar.f14123e;
                        aVar2.f14131f = pVar.f14124f;
                        aVar2.f14132g = pVar.f14125g;
                        aVar2.h = pVar.h;
                        aVar = aVar2;
                    }
                    boolean z10 = getOrientation() == 0;
                    boolean z11 = getLayoutDirection() == 1;
                    if (z10) {
                        i10 = z ? 5 : 0;
                        if (z3) {
                            i10 |= 10;
                        }
                        if (z11) {
                            i10 = ((i10 & 10) >> 1) | ((i10 & 5) << 1);
                        }
                    } else {
                        i10 = z ? 3 : 0;
                        if (z3) {
                            i10 |= 12;
                        }
                    }
                    int i13 = ~i10;
                    o oVar = this.h;
                    if ((i13 | 1) == i13) {
                        aVar.f14130e = oVar;
                    }
                    if ((i13 | 2) == i13) {
                        aVar.f14131f = oVar;
                    }
                    if ((i13 | 4) == i13) {
                        aVar.f14132g = oVar;
                    }
                    if ((i13 | 8) == i13) {
                        aVar.h = oVar;
                    }
                    p pVar2 = aVar.f14126a == 0 ? null : new p(aVar);
                    if (pVar2.d()) {
                        materialButton.setStateListShapeAppearanceModel(pVar2);
                    } else {
                        materialButton.setShapeAppearanceModel(pVar2.c());
                    }
                }
                i11++;
            }
        }
    }

    public StateListSizeChange getButtonSizeChange() {
        return this.f4771l;
    }

    @Override // android.view.ViewGroup
    public final int getChildDrawingOrder(int i10, int i11) {
        Integer[] numArr = this.f4768e;
        if (numArr != null && i11 < numArr.length) {
            return numArr[i11].intValue();
        }
        Log.w("MButtonGroup", "Child order wasn't updated");
        return i11;
    }

    public y4.d getInnerCornerSize() {
        return this.h.f14116b;
    }

    public o getInnerCornerSizeStateList() {
        return this.h;
    }

    public j getShapeAppearance() {
        p pVar = this.f4769j;
        if (pVar == null) {
            return null;
        }
        return pVar.c();
    }

    public int getSpacing() {
        return this.f4770k;
    }

    public p getStateListShapeAppearance() {
        return this.f4769j;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i10, int i11, int i12, int i13) {
        super.onLayout(z, i10, i11, i12, i13);
        if (z) {
            d();
            b();
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i10, int i11) {
        e();
        a();
        super.onMeasure(i10, i11);
    }

    @Override // android.view.ViewGroup
    public final void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if (view instanceof MaterialButton) {
            ((MaterialButton) view).setOnPressedChangeListenerInternal(null);
        }
        int iIndexOfChild = indexOfChild(view);
        if (iIndexOfChild >= 0) {
            this.f4764a.remove(iIndexOfChild);
            this.f4765b.remove(iIndexOfChild);
        }
        this.f4772m = true;
        e();
        d();
        a();
    }

    public void setButtonSizeChange(StateListSizeChange stateListSizeChange) {
        if (this.f4771l != stateListSizeChange) {
            this.f4771l = stateListSizeChange;
            b();
            requestLayout();
            invalidate();
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            ((MaterialButton) getChildAt(i10)).setEnabled(z);
        }
    }

    public void setInnerCornerSize(y4.d dVar) {
        this.h = o.b(dVar);
        this.f4772m = true;
        e();
        invalidate();
    }

    public void setInnerCornerSizeStateList(o oVar) {
        this.h = oVar;
        this.f4772m = true;
        e();
        invalidate();
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i10) {
        if (getOrientation() != i10) {
            this.f4772m = true;
        }
        super.setOrientation(i10);
    }

    public void setShapeAppearance(j jVar) {
        p.a aVar = new p.a(jVar);
        this.f4769j = aVar.f14126a == 0 ? null : new p(aVar);
        this.f4772m = true;
        e();
        invalidate();
    }

    public void setSpacing(int i10) {
        this.f4770k = i10;
        invalidate();
        requestLayout();
    }

    public void setStateListShapeAppearance(p pVar) {
        this.f4769j = pVar;
        this.f4772m = true;
        e();
        invalidate();
    }

    /* JADX WARN: Type inference failed for: r12v5, types: [com.google.android.material.button.b] */
    public c(Context context, AttributeSet attributeSet, int i10) throws Resources.NotFoundException {
        o oVarB;
        XmlResourceParser xml;
        int next;
        StateListSizeChange stateListSizeChange;
        AttributeSet attributeSetAsAttributeSet;
        int next2;
        super(b5.a.a(context, attributeSet, i10, R.style.Widget_Material3_MaterialButtonGroup), attributeSet, i10);
        this.f4764a = new ArrayList();
        this.f4765b = new ArrayList();
        this.f4766c = new a();
        this.f4767d = new Comparator() { // from class: com.google.android.material.button.b
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                MaterialButton materialButton = (MaterialButton) obj;
                MaterialButton materialButton2 = (MaterialButton) obj2;
                int i11 = c.f4763n;
                int iCompareTo = Boolean.valueOf(materialButton.r).compareTo(Boolean.valueOf(materialButton2.r));
                if (iCompareTo != 0) {
                    return iCompareTo;
                }
                int iCompareTo2 = Boolean.valueOf(materialButton.isPressed()).compareTo(Boolean.valueOf(materialButton2.isPressed()));
                if (iCompareTo2 != 0) {
                    return iCompareTo2;
                }
                c cVar = this.f4762a;
                return Integer.compare(cVar.indexOfChild(materialButton), cVar.indexOfChild(materialButton2));
            }
        };
        this.f4772m = true;
        Context context2 = getContext();
        TypedArray typedArrayD = i.d(context2, attributeSet, k4.a.f9910o, i10, R.style.Widget_Material3_MaterialButtonGroup, new int[0]);
        if (typedArrayD.hasValue(2)) {
            int resourceId = typedArrayD.getResourceId(2, 0);
            if (resourceId != 0 && context2.getResources().getResourceTypeName(resourceId).equals("xml")) {
                try {
                    xml = context2.getResources().getXml(resourceId);
                    try {
                        stateListSizeChange = new StateListSizeChange();
                        stateListSizeChange.f5124c = new int[10][];
                        stateListSizeChange.f5125d = new StateListSizeChange.a[10];
                        attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
                        do {
                            next2 = xml.next();
                            if (next2 == 2) {
                                break;
                            }
                        } while (next2 != 1);
                    } finally {
                    }
                } catch (Resources.NotFoundException | IOException | XmlPullParserException unused) {
                }
                if (next2 != 2) {
                    throw new XmlPullParserException("No start tag found");
                }
                if (xml.getName().equals("selector")) {
                    stateListSizeChange.a(context2, xml, attributeSetAsAttributeSet, context2.getTheme());
                }
                xml.close();
                this.f4771l = stateListSizeChange;
            } else {
                stateListSizeChange = null;
                this.f4771l = stateListSizeChange;
            }
        }
        if (typedArrayD.hasValue(4)) {
            p pVarB = p.b(context2, typedArrayD, 4);
            this.f4769j = pVarB;
            if (pVarB == null) {
                p.a aVar = new p.a(j.a(context2, typedArrayD.getResourceId(4, 0), typedArrayD.getResourceId(5, 0), new y4.a(0)).a());
                this.f4769j = aVar.f14126a != 0 ? new p(aVar) : null;
            }
        }
        if (typedArrayD.hasValue(3)) {
            y4.a aVar2 = new y4.a(0.0f);
            int resourceId2 = typedArrayD.getResourceId(3, 0);
            if (resourceId2 != 0 && context2.getResources().getResourceTypeName(resourceId2).equals("xml")) {
                try {
                    xml = context2.getResources().getXml(resourceId2);
                    try {
                        o oVar = new o();
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
                            oVar.d(context2, xml, attributeSetAsAttributeSet2, context2.getTheme());
                        }
                        xml.close();
                        oVarB = oVar;
                    } finally {
                    }
                } catch (Resources.NotFoundException | IOException | XmlPullParserException unused2) {
                    oVarB = o.b(aVar2);
                }
            } else {
                oVarB = o.b(j.c(typedArrayD, 3, aVar2));
            }
            this.h = oVarB;
        }
        this.f4770k = typedArrayD.getDimensionPixelSize(1, 0);
        setChildrenDrawingOrderEnabled(true);
        setEnabled(typedArrayD.getBoolean(0, true));
        typedArrayD.recycle();
    }
}
