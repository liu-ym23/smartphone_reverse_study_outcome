package com.google.android.material.timepicker;

import K.S;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.stepos.alphame.R;
import com.stepos.alphame.utils.Property;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import m1.AbstractC0769a;
import y.n;

/* loaded from: classes.dex */
class ClockFaceView extends h implements f {

    /* renamed from: A, reason: collision with root package name */
    public final c f11126A;

    /* renamed from: B, reason: collision with root package name */
    public final int[] f11127B;

    /* renamed from: C, reason: collision with root package name */
    public final float[] f11128C;

    /* renamed from: D, reason: collision with root package name */
    public final int f11129D;

    /* renamed from: E, reason: collision with root package name */
    public final int f11130E;

    /* renamed from: F, reason: collision with root package name */
    public final int f11131F;

    /* renamed from: G, reason: collision with root package name */
    public final int f11132G;

    /* renamed from: H, reason: collision with root package name */
    public final String[] f11133H;

    /* renamed from: I, reason: collision with root package name */
    public float f11134I;

    /* renamed from: J, reason: collision with root package name */
    public final ColorStateList f11135J;

    /* renamed from: v, reason: collision with root package name */
    public final ClockHandView f11136v;

    /* renamed from: w, reason: collision with root package name */
    public final Rect f11137w;

    /* renamed from: x, reason: collision with root package name */
    public final RectF f11138x;

    /* renamed from: y, reason: collision with root package name */
    public final Rect f11139y;

    /* renamed from: z, reason: collision with root package name */
    public final SparseArray f11140z;

    public ClockFaceView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11137w = new Rect();
        this.f11138x = new RectF();
        this.f11139y = new Rect();
        SparseArray sparseArray = new SparseArray();
        this.f11140z = sparseArray;
        this.f11128C = new float[]{Property.DEFAULT_FLOAT_VALUE, 0.9f, 1.0f};
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0769a.f13540f, R.attr.materialClockStyle, R.style.Widget_MaterialComponents_TimePicker_Clock);
        Resources resources = getResources();
        ColorStateList colorStateListY = B0.f.y(context, typedArrayObtainStyledAttributes, 1);
        this.f11135J = colorStateListY;
        LayoutInflater.from(context).inflate(R.layout.material_clockface_view, (ViewGroup) this, true);
        ClockHandView clockHandView = (ClockHandView) findViewById(R.id.material_clock_hand);
        this.f11136v = clockHandView;
        this.f11129D = resources.getDimensionPixelSize(R.dimen.material_clock_hand_padding);
        int colorForState = colorStateListY.getColorForState(new int[]{android.R.attr.state_selected}, colorStateListY.getDefaultColor());
        this.f11127B = new int[]{colorForState, colorForState, colorStateListY.getDefaultColor()};
        clockHandView.f11144c.add(this);
        int defaultColor = B0.f.x(R.color.material_timepicker_clockface, context).getDefaultColor();
        ColorStateList colorStateListY2 = B0.f.y(context, typedArrayObtainStyledAttributes, 0);
        setBackgroundColor(colorStateListY2 != null ? colorStateListY2.getDefaultColor() : defaultColor);
        getViewTreeObserver().addOnPreDrawListener(new b(this));
        setFocusable(false);
        typedArrayObtainStyledAttributes.recycle();
        this.f11126A = new c(this);
        String[] strArr = new String[12];
        Arrays.fill(strArr, "");
        this.f11133H = strArr;
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        int size = sparseArray.size();
        boolean z4 = false;
        for (int i4 = 0; i4 < Math.max(this.f11133H.length, size); i4++) {
            TextView textView = (TextView) sparseArray.get(i4);
            if (i4 >= this.f11133H.length) {
                removeView(textView);
                sparseArray.remove(i4);
            } else {
                if (textView == null) {
                    textView = (TextView) layoutInflaterFrom.inflate(R.layout.material_clockface_textview, (ViewGroup) this, false);
                    sparseArray.put(i4, textView);
                    addView(textView);
                }
                textView.setText(this.f11133H[i4]);
                textView.setTag(R.id.material_value_index, Integer.valueOf(i4));
                int i5 = (i4 / 12) + 1;
                textView.setTag(R.id.material_clock_level, Integer.valueOf(i5));
                z4 = i5 > 1 ? true : z4;
                S.h(textView, this.f11126A);
                textView.setTextColor(this.f11135J);
            }
        }
        ClockHandView clockHandView2 = this.f11136v;
        if (clockHandView2.f11143b && !z4) {
            clockHandView2.f11154m = 1;
        }
        clockHandView2.f11143b = z4;
        clockHandView2.invalidate();
        this.f11130E = resources.getDimensionPixelSize(R.dimen.material_time_picker_minimum_screen_height);
        this.f11131F = resources.getDimensionPixelSize(R.dimen.material_time_picker_minimum_screen_width);
        this.f11132G = resources.getDimensionPixelSize(R.dimen.material_clock_size);
    }

    @Override // com.google.android.material.timepicker.h
    public final void h() throws IllegalAccessException, Resources.NotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        n nVar = new n();
        nVar.b(this);
        HashMap map = new HashMap();
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            View childAt = getChildAt(i4);
            if (childAt.getId() != R.id.circle_center && !"skip".equals(childAt.getTag())) {
                int i5 = (Integer) childAt.getTag(R.id.material_clock_level);
                if (i5 == null) {
                    i5 = 1;
                }
                if (!map.containsKey(i5)) {
                    map.put(i5, new ArrayList());
                }
                ((List) map.get(i5)).add(childAt);
            }
        }
        for (Map.Entry entry : map.entrySet()) {
            List list = (List) entry.getValue();
            int iRound = ((Integer) entry.getKey()).intValue() == 2 ? Math.round(this.f11167t * 0.66f) : this.f11167t;
            Iterator it = list.iterator();
            float size = Property.DEFAULT_FLOAT_VALUE;
            while (it.hasNext()) {
                int id = ((View) it.next()).getId();
                HashMap map2 = nVar.f16149c;
                if (!map2.containsKey(Integer.valueOf(id))) {
                    map2.put(Integer.valueOf(id), new y.i());
                }
                y.j jVar = ((y.i) map2.get(Integer.valueOf(id))).f16046d;
                jVar.f16115z = R.id.circle_center;
                jVar.f16050A = iRound;
                jVar.f16051B = size;
                size += 360.0f / list.size();
            }
        }
        nVar.a(this);
        setConstraintSet(null);
        requestLayout();
        int i6 = 0;
        while (true) {
            SparseArray sparseArray = this.f11140z;
            if (i6 >= sparseArray.size()) {
                return;
            }
            ((TextView) sparseArray.get(i6)).setVisibility(0);
            i6++;
        }
    }

    public final void j() {
        SparseArray sparseArray;
        RectF rectF;
        Rect rect;
        RectF rectF2 = this.f11136v.f11148g;
        float f4 = Float.MAX_VALUE;
        TextView textView = null;
        int i4 = 0;
        while (true) {
            sparseArray = this.f11140z;
            int size = sparseArray.size();
            rectF = this.f11138x;
            rect = this.f11137w;
            if (i4 >= size) {
                break;
            }
            TextView textView2 = (TextView) sparseArray.get(i4);
            if (textView2 != null) {
                textView2.getHitRect(rect);
                rectF.set(rect);
                rectF.union(rectF2);
                float fHeight = rectF.height() * rectF.width();
                if (fHeight < f4) {
                    textView = textView2;
                    f4 = fHeight;
                }
            }
            i4++;
        }
        for (int i5 = 0; i5 < sparseArray.size(); i5++) {
            TextView textView3 = (TextView) sparseArray.get(i5);
            if (textView3 != null) {
                textView3.setSelected(textView3 == textView);
                textView3.getHitRect(rect);
                rectF.set(rect);
                textView3.getLineBounds(0, this.f11139y);
                rectF.inset(r8.left, r8.top);
                textView3.getPaint().setShader(!RectF.intersects(rectF2, rectF) ? null : new RadialGradient(rectF2.centerX() - rectF.left, rectF2.centerY() - rectF.top, 0.5f * rectF2.width(), this.f11127B, this.f11128C, Shader.TileMode.CLAMP));
                textView3.invalidate();
            }
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(1, this.f11133H.length, false, 1));
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        super.onLayout(z4, i4, i5, i6, i7);
        j();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public final void onMeasure(int i4, int i5) throws IllegalAccessException, Resources.NotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int iMax = (int) (this.f11132G / Math.max(Math.max(this.f11130E / displayMetrics.heightPixels, this.f11131F / displayMetrics.widthPixels), 1.0f));
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iMax, 1073741824);
        setMeasuredDimension(iMax, iMax);
        super.onMeasure(iMakeMeasureSpec, iMakeMeasureSpec);
    }
}
