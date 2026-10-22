package j1;

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
import androidx.emoji2.text.m;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.stepos.stepclaw.R;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeMap;
import n6.l;
import org.xmlpull.v1.XmlPullParserException;
import p1.k;
import r6.x;
import t1.a0;
import t1.b0;
import t1.n;
import t1.y;
import t1.z;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class f extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f3476a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f3477b;

    /* renamed from: c, reason: collision with root package name */
    public final m f3478c;
    public final e d;

    /* renamed from: e, reason: collision with root package name */
    public Integer[] f3479e;

    /* renamed from: f, reason: collision with root package name */
    public y f3480f;

    /* renamed from: g, reason: collision with root package name */
    public z f3481g;

    /* renamed from: h, reason: collision with root package name */
    public int f3482h;

    /* renamed from: j, reason: collision with root package name */
    public b0 f3483j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f3484k;

    /* JADX WARN: Type inference failed for: r13v5, types: [j1.e] */
    public f(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        y yVarB;
        XmlResourceParser xml;
        int next;
        b0 b0Var;
        int next2;
        super(x1.a.a(context, attributeSet, R.attr.materialButtonToggleGroupStyle, R.style.Widget_Material3_MaterialButtonGroup), attributeSet, R.attr.materialButtonToggleGroupStyle);
        this.f3476a = new ArrayList();
        this.f3477b = new ArrayList();
        final MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) this;
        this.f3478c = new m(materialButtonToggleGroup);
        this.d = new Comparator() { // from class: j1.e
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                MaterialButton materialButton = (MaterialButton) obj;
                MaterialButton materialButton2 = (MaterialButton) obj2;
                int iCompareTo = Boolean.valueOf(materialButton.f1271p).compareTo(Boolean.valueOf(materialButton2.f1271p));
                if (iCompareTo != 0) {
                    return iCompareTo;
                }
                int iCompareTo2 = Boolean.valueOf(materialButton.isPressed()).compareTo(Boolean.valueOf(materialButton2.isPressed()));
                if (iCompareTo2 != 0) {
                    return iCompareTo2;
                }
                MaterialButtonToggleGroup materialButtonToggleGroup2 = materialButtonToggleGroup;
                return Integer.compare(materialButtonToggleGroup2.indexOfChild(materialButton), materialButtonToggleGroup2.indexOfChild(materialButton2));
            }
        };
        this.f3484k = true;
        Context context2 = getContext();
        TypedArray typedArrayE = k.e(context2, attributeSet, d1.a.f1768j, R.attr.materialButtonToggleGroupStyle, R.style.Widget_Material3_MaterialButtonGroup, new int[0]);
        if (typedArrayE.hasValue(2)) {
            int resourceId = typedArrayE.getResourceId(2, 0);
            if (resourceId != 0 && context2.getResources().getResourceTypeName(resourceId).equals("xml")) {
                try {
                    xml = context2.getResources().getXml(resourceId);
                } catch (Resources.NotFoundException | IOException | XmlPullParserException unused) {
                }
                try {
                    b0Var = new b0();
                    b0Var.f5452c = new int[10][];
                    b0Var.d = new x[10];
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
                        b0Var.a(context2, xml, attributeSetAsAttributeSet, context2.getTheme());
                    }
                    xml.close();
                    this.f3483j = b0Var;
                } finally {
                }
            } else {
                b0Var = null;
                this.f3483j = b0Var;
            }
        }
        if (typedArrayE.hasValue(4)) {
            z zVarB = z.b(context2, typedArrayE, 4);
            this.f3481g = zVarB;
            if (zVarB == null) {
                l lVar = new l(n.a(context2, typedArrayE.getResourceId(4, 0), typedArrayE.getResourceId(5, 0), new t1.a(0)).a());
                this.f3481g = lVar.f4056b != 0 ? new z(lVar) : null;
            }
        }
        if (typedArrayE.hasValue(3)) {
            t1.a aVar = new t1.a(0.0f);
            int resourceId2 = typedArrayE.getResourceId(3, 0);
            if (resourceId2 != 0 && context2.getResources().getResourceTypeName(resourceId2).equals("xml")) {
                try {
                    xml = context2.getResources().getXml(resourceId2);
                    try {
                        yVarB = new y();
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
                            yVarB.d(context2, xml, attributeSetAsAttributeSet2, context2.getTheme());
                        }
                        xml.close();
                    } finally {
                    }
                } catch (Resources.NotFoundException | IOException | XmlPullParserException unused2) {
                    yVarB = y.b(aVar);
                }
            } else {
                yVarB = y.b(n.c(typedArrayE, 3, aVar));
            }
            this.f3480f = yVarB;
        }
        this.f3482h = typedArrayE.getDimensionPixelSize(1, 0);
        setChildrenDrawingOrderEnabled(true);
        setEnabled(typedArrayE.getBoolean(0, true));
        typedArrayE.recycle();
    }

    private int getFirstVisibleChildIndex() {
        int childCount = getChildCount();
        for (int i8 = 0; i8 < childCount; i8++) {
            if (c(i8)) {
                return i8;
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
        for (int i8 = firstVisibleChildIndex + 1; i8 < getChildCount(); i8++) {
            MaterialButton materialButton = (MaterialButton) getChildAt(i8);
            MaterialButton materialButton2 = (MaterialButton) getChildAt(i8 - 1);
            if (this.f3482h <= 0) {
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
                layoutParams2.setMarginStart(this.f3482h - iMin);
                layoutParams2.topMargin = 0;
            } else {
                layoutParams2.bottomMargin = 0;
                layoutParams2.topMargin = this.f3482h - iMin;
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
    public void addView(View view, int i8, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof MaterialButton)) {
            Log.e("MButtonGroup", "Child views must be of type MaterialButton.");
            return;
        }
        d();
        this.f3484k = true;
        super.addView(view, i8, layoutParams);
        MaterialButton materialButton = (MaterialButton) view;
        setGeneratedIdIfNeeded(materialButton);
        materialButton.setOnPressedChangeListenerInternal(this.f3478c);
        this.f3476a.add(materialButton.getShapeAppearanceModel());
        this.f3477b.add(materialButton.getStateListShapeAppearanceModel());
        materialButton.setEnabled(isEnabled());
    }

    public final void b() {
        MaterialButton materialButton;
        MaterialButton materialButton2;
        float fMax;
        if (this.f3483j == null || getChildCount() == 0) {
            return;
        }
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        int lastVisibleChildIndex = getLastVisibleChildIndex();
        int iMin = Integer.MAX_VALUE;
        for (int i8 = firstVisibleChildIndex; i8 <= lastVisibleChildIndex; i8++) {
            if (c(i8)) {
                if (c(i8) && this.f3483j != null) {
                    MaterialButton materialButton3 = (MaterialButton) getChildAt(i8);
                    b0 b0Var = this.f3483j;
                    int width = materialButton3.getWidth();
                    int i9 = -width;
                    for (int i10 = 0; i10 < b0Var.f5450a; i10++) {
                        a0 a0Var = (a0) b0Var.d[i10].f5220a;
                        int i11 = a0Var.f5446a;
                        float f3 = a0Var.f5447b;
                        if (i11 == 2) {
                            fMax = Math.max(i9, f3);
                        } else if (i11 == 1) {
                            fMax = Math.max(i9, width * f3);
                        }
                        i9 = (int) fMax;
                    }
                    int iMax = Math.max(0, i9);
                    int i12 = i8 - 1;
                    while (true) {
                        materialButton = null;
                        if (i12 < 0) {
                            materialButton2 = null;
                            break;
                        } else {
                            if (c(i12)) {
                                materialButton2 = (MaterialButton) getChildAt(i12);
                                break;
                            }
                            i12--;
                        }
                    }
                    int allowedWidthDecrease = materialButton2 == null ? 0 : materialButton2.getAllowedWidthDecrease();
                    int childCount = getChildCount();
                    int i13 = i8 + 1;
                    while (true) {
                        if (i13 >= childCount) {
                            break;
                        }
                        if (c(i13)) {
                            materialButton = (MaterialButton) getChildAt(i13);
                            break;
                        }
                        i13++;
                    }
                    iMin = Math.min(iMax, allowedWidthDecrease + (materialButton != null ? materialButton.getAllowedWidthDecrease() : 0));
                }
                if (i8 != firstVisibleChildIndex && i8 != lastVisibleChildIndex) {
                    iMin /= 2;
                }
                iMin = Math.min(iMin, iMin);
            }
        }
        int i14 = firstVisibleChildIndex;
        while (i14 <= lastVisibleChildIndex) {
            if (c(i14)) {
                ((MaterialButton) getChildAt(i14)).setSizeChange(this.f3483j);
                ((MaterialButton) getChildAt(i14)).setWidthChangeMax((i14 == firstVisibleChildIndex || i14 == lastVisibleChildIndex) ? iMin : iMin * 2);
            }
            i14++;
        }
    }

    public final boolean c(int i8) {
        return getChildAt(i8).getVisibility() != 8;
    }

    public final void d() {
        for (int i8 = 0; i8 < getChildCount(); i8++) {
            MaterialButton materialButton = (MaterialButton) getChildAt(i8);
            LinearLayout.LayoutParams layoutParams = materialButton.f1278w;
            if (layoutParams != null) {
                materialButton.setLayoutParams(layoutParams);
                materialButton.f1278w = null;
                materialButton.f1275t = -1.0f;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        TreeMap treeMap = new TreeMap(this.d);
        int childCount = getChildCount();
        for (int i8 = 0; i8 < childCount; i8++) {
            treeMap.put((MaterialButton) getChildAt(i8), Integer.valueOf(i8));
        }
        this.f3479e = (Integer[]) treeMap.values().toArray(new Integer[0]);
        super.dispatchDraw(canvas);
    }

    /* JADX WARN: Type inference failed for: r14v1, types: [int[][], java.io.Serializable, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.io.Serializable, t1.n[]] */
    public final void e() {
        l lVar;
        int i8;
        if (!(this.f3480f == null && this.f3481g == null) && this.f3484k) {
            this.f3484k = false;
            int childCount = getChildCount();
            int firstVisibleChildIndex = getFirstVisibleChildIndex();
            int lastVisibleChildIndex = getLastVisibleChildIndex();
            int i9 = 0;
            while (i9 < childCount) {
                MaterialButton materialButton = (MaterialButton) getChildAt(i9);
                if (materialButton.getVisibility() != 8) {
                    boolean z = i9 == firstVisibleChildIndex;
                    boolean z2 = i9 == lastVisibleChildIndex;
                    z zVar = this.f3481g;
                    if (zVar == null || (!z && !z2)) {
                        zVar = (z) this.f3477b.get(i9);
                    }
                    if (zVar == null) {
                        lVar = new l((n) this.f3476a.get(i9));
                    } else {
                        l lVar2 = new l(1);
                        int i10 = zVar.f5552a;
                        lVar2.f4056b = i10;
                        lVar2.f4057c = zVar.f5553b;
                        int[][] iArr = zVar.f5554c;
                        ?? r14 = new int[iArr.length][];
                        lVar2.d = r14;
                        n[] nVarArr = zVar.d;
                        lVar2.f4058e = new n[nVarArr.length];
                        System.arraycopy(iArr, 0, r14, 0, i10);
                        System.arraycopy(nVarArr, 0, (n[]) lVar2.f4058e, 0, lVar2.f4056b);
                        lVar2.f4059f = zVar.f5555e;
                        lVar2.f4060g = zVar.f5556f;
                        lVar2.f4061h = zVar.f5557g;
                        lVar2.f4062i = zVar.f5558h;
                        lVar = lVar2;
                    }
                    boolean z8 = getOrientation() == 0;
                    boolean z9 = getLayoutDirection() == 1;
                    if (z8) {
                        i8 = z ? 5 : 0;
                        if (z2) {
                            i8 |= 10;
                        }
                        if (z9) {
                            i8 = ((i8 & 10) >> 1) | ((i8 & 5) << 1);
                        }
                    } else {
                        i8 = z ? 3 : 0;
                        if (z2) {
                            i8 |= 12;
                        }
                    }
                    int i11 = ~i8;
                    y yVar = this.f3480f;
                    if ((i11 | 1) == i11) {
                        lVar.f4059f = yVar;
                    }
                    if ((i11 | 2) == i11) {
                        lVar.f4060g = yVar;
                    }
                    if ((i11 | 4) == i11) {
                        lVar.f4061h = yVar;
                    }
                    if ((i11 | 8) == i11) {
                        lVar.f4062i = yVar;
                    }
                    z zVar2 = lVar.f4056b == 0 ? null : new z(lVar);
                    if (zVar2.d()) {
                        materialButton.setStateListShapeAppearanceModel(zVar2);
                    } else {
                        materialButton.setShapeAppearanceModel(zVar2.c());
                    }
                }
                i9++;
            }
        }
    }

    public b0 getButtonSizeChange() {
        return this.f3483j;
    }

    @Override // android.view.ViewGroup
    public final int getChildDrawingOrder(int i8, int i9) {
        Integer[] numArr = this.f3479e;
        if (numArr != null && i9 < numArr.length) {
            return numArr[i9].intValue();
        }
        Log.w("MButtonGroup", "Child order wasn't updated");
        return i9;
    }

    public t1.d getInnerCornerSize() {
        return this.f3480f.f5550b;
    }

    public y getInnerCornerSizeStateList() {
        return this.f3480f;
    }

    public n getShapeAppearance() {
        z zVar = this.f3481g;
        if (zVar == null) {
            return null;
        }
        return zVar.c();
    }

    public int getSpacing() {
        return this.f3482h;
    }

    public z getStateListShapeAppearance() {
        return this.f3481g;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i8, int i9, int i10, int i11) {
        super.onLayout(z, i8, i9, i10, i11);
        if (z) {
            d();
            b();
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i8, int i9) {
        e();
        a();
        super.onMeasure(i8, i9);
    }

    @Override // android.view.ViewGroup
    public final void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if (view instanceof MaterialButton) {
            ((MaterialButton) view).setOnPressedChangeListenerInternal(null);
        }
        int iIndexOfChild = indexOfChild(view);
        if (iIndexOfChild >= 0) {
            this.f3476a.remove(iIndexOfChild);
            this.f3477b.remove(iIndexOfChild);
        }
        this.f3484k = true;
        e();
        d();
        a();
    }

    public void setButtonSizeChange(b0 b0Var) {
        if (this.f3483j != b0Var) {
            this.f3483j = b0Var;
            b();
            requestLayout();
            invalidate();
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        for (int i8 = 0; i8 < getChildCount(); i8++) {
            ((MaterialButton) getChildAt(i8)).setEnabled(z);
        }
    }

    public void setInnerCornerSize(t1.d dVar) {
        this.f3480f = y.b(dVar);
        this.f3484k = true;
        e();
        invalidate();
    }

    public void setInnerCornerSizeStateList(y yVar) {
        this.f3480f = yVar;
        this.f3484k = true;
        e();
        invalidate();
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i8) {
        if (getOrientation() != i8) {
            this.f3484k = true;
        }
        super.setOrientation(i8);
    }

    public void setShapeAppearance(n nVar) {
        l lVar = new l(nVar);
        this.f3481g = lVar.f4056b == 0 ? null : new z(lVar);
        this.f3484k = true;
        e();
        invalidate();
    }

    public void setSpacing(int i8) {
        this.f3482h = i8;
        invalidate();
        requestLayout();
    }

    public void setStateListShapeAppearance(z zVar) {
        this.f3481g = zVar;
        this.f3484k = true;
        e();
        invalidate();
    }
}
