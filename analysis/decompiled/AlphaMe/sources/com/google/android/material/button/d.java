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
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import com.google.android.gms.common.api.internal.p;
import com.google.android.material.internal.l;
import com.stepos.alphame.R;
import com.stepos.alphame.utils.Property;
import e.EnumC0546d;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeMap;
import m1.AbstractC0769a;
import org.xmlpull.v1.XmlPullParserException;
import y1.B;
import y1.C;
import y1.C0986A;
import y1.C0987a;
import y1.D;
import y1.InterfaceC0990d;
import y1.n;
import y1.z;

/* loaded from: classes.dex */
public abstract class d extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f10508a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f10509b;

    /* renamed from: c, reason: collision with root package name */
    public final p f10510c;

    /* renamed from: d, reason: collision with root package name */
    public final c f10511d;

    /* renamed from: e, reason: collision with root package name */
    public Integer[] f10512e;

    /* renamed from: f, reason: collision with root package name */
    public z f10513f;

    /* renamed from: g, reason: collision with root package name */
    public B f10514g;

    /* renamed from: h, reason: collision with root package name */
    public int f10515h;

    /* renamed from: i, reason: collision with root package name */
    public D f10516i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f10517j;

    /* JADX WARN: Type inference failed for: r12v5, types: [com.google.android.material.button.c] */
    public d(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        z zVarB;
        XmlResourceParser xml;
        int next;
        int next2;
        super(C1.a.b(context, attributeSet, R.attr.materialButtonToggleGroupStyle, R.style.Widget_Material3_MaterialButtonGroup), attributeSet, R.attr.materialButtonToggleGroupStyle);
        this.f10508a = new ArrayList();
        this.f10509b = new ArrayList();
        final MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) this;
        this.f10510c = new p(materialButtonToggleGroup);
        this.f10511d = new Comparator() { // from class: com.google.android.material.button.c
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                MaterialButton materialButton = (MaterialButton) obj;
                MaterialButton materialButton2 = (MaterialButton) obj2;
                d dVar = materialButtonToggleGroup;
                dVar.getClass();
                int iCompareTo = Boolean.valueOf(materialButton.f10487o).compareTo(Boolean.valueOf(materialButton2.f10487o));
                if (iCompareTo != 0) {
                    return iCompareTo;
                }
                int iCompareTo2 = Boolean.valueOf(materialButton.isPressed()).compareTo(Boolean.valueOf(materialButton2.isPressed()));
                return iCompareTo2 != 0 ? iCompareTo2 : Integer.compare(dVar.indexOfChild(materialButton), dVar.indexOfChild(materialButton2));
            }
        };
        this.f10517j = true;
        Context context2 = getContext();
        TypedArray typedArrayE = l.e(context2, attributeSet, AbstractC0769a.f13549o, R.attr.materialButtonToggleGroupStyle, R.style.Widget_Material3_MaterialButtonGroup, new int[0]);
        if (typedArrayE.hasValue(2)) {
            int resourceId = typedArrayE.getResourceId(2, 0);
            D d4 = null;
            if (resourceId != 0 && context2.getResources().getResourceTypeName(resourceId).equals("xml")) {
                try {
                    xml = context2.getResources().getXml(resourceId);
                    try {
                        D d5 = new D();
                        d5.f16194c = new int[10][];
                        d5.f16195d = new p[10];
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
                            d5.a(context2, xml, attributeSetAsAttributeSet, context2.getTheme());
                        }
                        xml.close();
                        d4 = d5;
                    } finally {
                    }
                } catch (Resources.NotFoundException | IOException | XmlPullParserException unused) {
                }
            }
            this.f10516i = d4;
        }
        if (typedArrayE.hasValue(4)) {
            B b4 = B.b(context2, typedArrayE, 4);
            this.f10514g = b4;
            if (b4 == null) {
                this.f10514g = new C0986A(n.a(context2, typedArrayE.getResourceId(4, 0), typedArrayE.getResourceId(5, 0), new C0987a(0)).a()).b();
            }
        }
        if (typedArrayE.hasValue(3)) {
            C0987a c0987a = new C0987a(Property.DEFAULT_FLOAT_VALUE);
            int resourceId2 = typedArrayE.getResourceId(3, 0);
            if (resourceId2 != 0 && context2.getResources().getResourceTypeName(resourceId2).equals("xml")) {
                try {
                    xml = context2.getResources().getXml(resourceId2);
                    try {
                        z zVar = new z();
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
                            zVar.d(context2, xml, attributeSetAsAttributeSet2, context2.getTheme());
                        }
                        xml.close();
                        zVarB = zVar;
                    } finally {
                    }
                } catch (Resources.NotFoundException | IOException | XmlPullParserException unused2) {
                    zVarB = z.b(c0987a);
                }
            } else {
                zVarB = z.b(n.c(typedArrayE, 3, c0987a));
            }
            this.f10513f = zVarB;
        }
        this.f10515h = typedArrayE.getDimensionPixelSize(1, 0);
        setChildrenDrawingOrderEnabled(true);
        setEnabled(typedArrayE.getBoolean(0, true));
        typedArrayE.recycle();
    }

    private int getFirstVisibleChildIndex() {
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            if (c(i4)) {
                return i4;
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
        for (int i4 = firstVisibleChildIndex + 1; i4 < getChildCount(); i4++) {
            MaterialButton materialButton = (MaterialButton) getChildAt(i4);
            MaterialButton materialButton2 = (MaterialButton) getChildAt(i4 - 1);
            if (this.f10515h <= 0) {
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
                layoutParams2.setMarginStart(this.f10515h - iMin);
                layoutParams2.topMargin = 0;
            } else {
                layoutParams2.bottomMargin = 0;
                layoutParams2.topMargin = this.f10515h - iMin;
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
    public void addView(View view, int i4, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof MaterialButton)) {
            Log.e("MButtonGroup", "Child views must be of type MaterialButton.");
            return;
        }
        d();
        this.f10517j = true;
        super.addView(view, i4, layoutParams);
        MaterialButton materialButton = (MaterialButton) view;
        setGeneratedIdIfNeeded(materialButton);
        materialButton.setOnPressedChangeListenerInternal(this.f10510c);
        this.f10508a.add(materialButton.getShapeAppearanceModel());
        this.f10509b.add(materialButton.getStateListShapeAppearanceModel());
        materialButton.setEnabled(isEnabled());
    }

    public final void b() {
        MaterialButton materialButton;
        MaterialButton materialButton2;
        float fMax;
        if (this.f10516i == null || getChildCount() == 0) {
            return;
        }
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        int lastVisibleChildIndex = getLastVisibleChildIndex();
        int iMin = Integer.MAX_VALUE;
        for (int i4 = firstVisibleChildIndex; i4 <= lastVisibleChildIndex; i4++) {
            if (c(i4)) {
                if (c(i4) && this.f10516i != null) {
                    MaterialButton materialButton3 = (MaterialButton) getChildAt(i4);
                    D d4 = this.f10516i;
                    int width = materialButton3.getWidth();
                    int i5 = -width;
                    for (int i6 = 0; i6 < d4.f16192a; i6++) {
                        C c4 = (C) d4.f16195d[i6].f9664b;
                        int i7 = c4.f16190a;
                        float f4 = c4.f16191b;
                        if (i7 == 2) {
                            fMax = Math.max(i5, f4);
                        } else if (i7 == 1) {
                            fMax = Math.max(i5, width * f4);
                        }
                        i5 = (int) fMax;
                    }
                    int iMax = Math.max(0, i5);
                    int i8 = i4 - 1;
                    while (true) {
                        materialButton = null;
                        if (i8 < 0) {
                            materialButton2 = null;
                            break;
                        } else {
                            if (c(i8)) {
                                materialButton2 = (MaterialButton) getChildAt(i8);
                                break;
                            }
                            i8--;
                        }
                    }
                    int allowedWidthDecrease = materialButton2 == null ? 0 : materialButton2.getAllowedWidthDecrease();
                    int childCount = getChildCount();
                    int i9 = i4 + 1;
                    while (true) {
                        if (i9 >= childCount) {
                            break;
                        }
                        if (c(i9)) {
                            materialButton = (MaterialButton) getChildAt(i9);
                            break;
                        }
                        i9++;
                    }
                    iMin = Math.min(iMax, allowedWidthDecrease + (materialButton != null ? materialButton.getAllowedWidthDecrease() : 0));
                }
                if (i4 != firstVisibleChildIndex && i4 != lastVisibleChildIndex) {
                    iMin /= 2;
                }
                iMin = Math.min(iMin, iMin);
            }
        }
        int i10 = firstVisibleChildIndex;
        while (i10 <= lastVisibleChildIndex) {
            if (c(i10)) {
                ((MaterialButton) getChildAt(i10)).setSizeChange(this.f10516i);
                ((MaterialButton) getChildAt(i10)).setWidthChangeMax((i10 == firstVisibleChildIndex || i10 == lastVisibleChildIndex) ? iMin : iMin * 2);
            }
            i10++;
        }
    }

    public final boolean c(int i4) {
        return getChildAt(i4).getVisibility() != 8;
    }

    public final void d() {
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            MaterialButton materialButton = (MaterialButton) getChildAt(i4);
            LinearLayout.LayoutParams layoutParams = materialButton.f10494v;
            if (layoutParams != null) {
                materialButton.setLayoutParams(layoutParams);
                materialButton.f10494v = null;
                materialButton.f10491s = -1.0f;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        TreeMap treeMap = new TreeMap(this.f10511d);
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            treeMap.put((MaterialButton) getChildAt(i4), Integer.valueOf(i4));
        }
        this.f10512e = (Integer[]) treeMap.values().toArray(new Integer[0]);
        super.dispatchDraw(canvas);
    }

    public final void e() {
        C0986A c0986a;
        int i4;
        if (!(this.f10513f == null && this.f10514g == null) && this.f10517j) {
            this.f10517j = false;
            int childCount = getChildCount();
            int firstVisibleChildIndex = getFirstVisibleChildIndex();
            int lastVisibleChildIndex = getLastVisibleChildIndex();
            int i5 = 0;
            while (i5 < childCount) {
                MaterialButton materialButton = (MaterialButton) getChildAt(i5);
                if (materialButton.getVisibility() != 8) {
                    boolean z4 = i5 == firstVisibleChildIndex;
                    boolean z5 = i5 == lastVisibleChildIndex;
                    B b4 = this.f10514g;
                    if (b4 == null || (!z4 && !z5)) {
                        b4 = (B) this.f10509b.get(i5);
                    }
                    if (b4 == null) {
                        c0986a = new C0986A((n) this.f10508a.get(i5));
                    } else {
                        C0986A c0986a2 = new C0986A();
                        int i6 = b4.f16182a;
                        c0986a2.f16174a = i6;
                        c0986a2.f16175b = b4.f16183b;
                        int[][] iArr = b4.f16184c;
                        int[][] iArr2 = new int[iArr.length][];
                        c0986a2.f16176c = iArr2;
                        n[] nVarArr = b4.f16185d;
                        c0986a2.f16177d = new n[nVarArr.length];
                        System.arraycopy(iArr, 0, iArr2, 0, i6);
                        System.arraycopy(nVarArr, 0, c0986a2.f16177d, 0, c0986a2.f16174a);
                        c0986a2.f16178e = b4.f16186e;
                        c0986a2.f16179f = b4.f16187f;
                        c0986a2.f16180g = b4.f16188g;
                        c0986a2.f16181h = b4.f16189h;
                        c0986a = c0986a2;
                    }
                    boolean z6 = getOrientation() == 0;
                    boolean z7 = getLayoutDirection() == 1;
                    if (z6) {
                        i4 = z4 ? 5 : 0;
                        if (z5) {
                            i4 |= 10;
                        }
                        if (z7) {
                            i4 = ((i4 & 10) >> 1) | ((i4 & 5) << 1);
                        }
                    } else {
                        i4 = z4 ? 3 : 0;
                        if (z5) {
                            i4 |= 12;
                        }
                    }
                    int i7 = ~i4;
                    z zVar = this.f10513f;
                    if ((i7 | 1) == i7) {
                        c0986a.f16178e = zVar;
                    }
                    if ((i7 | 2) == i7) {
                        c0986a.f16179f = zVar;
                    }
                    if ((i7 | 4) == i7) {
                        c0986a.f16180g = zVar;
                    }
                    if ((i7 | 8) == i7) {
                        c0986a.f16181h = zVar;
                    }
                    B b5 = c0986a.b();
                    if (b5.d()) {
                        materialButton.setStateListShapeAppearanceModel(b5);
                    } else {
                        materialButton.setShapeAppearanceModel(b5.c());
                    }
                }
                i5++;
            }
        }
    }

    @Nullable
    @RestrictTo({EnumC0546d.f12493b})
    public D getButtonSizeChange() {
        return this.f10516i;
    }

    @Override // android.view.ViewGroup
    public final int getChildDrawingOrder(int i4, int i5) {
        Integer[] numArr = this.f10512e;
        if (numArr != null && i5 < numArr.length) {
            return numArr[i5].intValue();
        }
        Log.w("MButtonGroup", "Child order wasn't updated");
        return i5;
    }

    @NonNull
    public InterfaceC0990d getInnerCornerSize() {
        return this.f10513f.f16324b;
    }

    @NonNull
    @RestrictTo({EnumC0546d.f12493b})
    public z getInnerCornerSizeStateList() {
        return this.f10513f;
    }

    @Nullable
    public n getShapeAppearance() {
        B b4 = this.f10514g;
        if (b4 == null) {
            return null;
        }
        return b4.c();
    }

    @Px
    public int getSpacing() {
        return this.f10515h;
    }

    @Nullable
    @RestrictTo({EnumC0546d.f12493b})
    public B getStateListShapeAppearance() {
        return this.f10514g;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        super.onLayout(z4, i4, i5, i6, i7);
        if (z4) {
            d();
            b();
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i4, int i5) {
        e();
        a();
        super.onMeasure(i4, i5);
    }

    @Override // android.view.ViewGroup
    public final void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if (view instanceof MaterialButton) {
            ((MaterialButton) view).setOnPressedChangeListenerInternal(null);
        }
        int iIndexOfChild = indexOfChild(view);
        if (iIndexOfChild >= 0) {
            this.f10508a.remove(iIndexOfChild);
            this.f10509b.remove(iIndexOfChild);
        }
        this.f10517j = true;
        e();
        d();
        a();
    }

    @RestrictTo({EnumC0546d.f12493b})
    public void setButtonSizeChange(@NonNull D d4) {
        if (this.f10516i != d4) {
            this.f10516i = d4;
            b();
            requestLayout();
            invalidate();
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z4) {
        super.setEnabled(z4);
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            ((MaterialButton) getChildAt(i4)).setEnabled(z4);
        }
    }

    public void setInnerCornerSize(@NonNull InterfaceC0990d interfaceC0990d) {
        this.f10513f = z.b(interfaceC0990d);
        this.f10517j = true;
        e();
        invalidate();
    }

    @RestrictTo({EnumC0546d.f12493b})
    public void setInnerCornerSizeStateList(@NonNull z zVar) {
        this.f10513f = zVar;
        this.f10517j = true;
        e();
        invalidate();
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i4) {
        if (getOrientation() != i4) {
            this.f10517j = true;
        }
        super.setOrientation(i4);
    }

    public void setShapeAppearance(@Nullable n nVar) {
        this.f10514g = new C0986A(nVar).b();
        this.f10517j = true;
        e();
        invalidate();
    }

    public void setSpacing(@Px int i4) {
        this.f10515h = i4;
        invalidate();
        requestLayout();
    }

    @RestrictTo({EnumC0546d.f12493b})
    public void setStateListShapeAppearance(@Nullable B b4) {
        this.f10514g = b4;
        this.f10517j = true;
        e();
        invalidate();
    }
}
