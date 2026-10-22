package com.google.android.material.timepicker;

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
import com.stepos.stepclaw.R;
import com.stepos.stepclaw.SecurePrefs;
import e0.a0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import k4.v;
import k4.z;
import r.n;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
class ClockFaceView extends h implements f {
    public final SparseArray A;
    public final c B;
    public final int[] C;
    public final float[] D;
    public final int E;
    public final int F;
    public final int G;
    public final int H;
    public final String[] I;
    public float J;
    public final ColorStateList K;

    /* renamed from: w, reason: collision with root package name */
    public final ClockHandView f1401w;

    /* renamed from: x, reason: collision with root package name */
    public final Rect f1402x;
    public final RectF y;
    public final Rect z;

    public ClockFaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1402x = new Rect();
        this.y = new RectF();
        this.z = new Rect();
        SparseArray sparseArray = new SparseArray();
        this.A = sparseArray;
        this.D = new float[]{0.0f, 0.9f, 1.0f};
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d1.a.d, R.attr.materialClockStyle, R.style.Widget_MaterialComponents_TimePicker_Clock);
        Resources resources = getResources();
        ColorStateList colorStateListD = v.D(context, typedArrayObtainStyledAttributes, 1);
        this.K = colorStateListD;
        LayoutInflater.from(context).inflate(R.layout.material_clockface_view, (ViewGroup) this, true);
        ClockHandView clockHandView = (ClockHandView) findViewById(R.id.material_clock_hand);
        this.f1401w = clockHandView;
        this.E = resources.getDimensionPixelSize(R.dimen.material_clock_hand_padding);
        int colorForState = colorStateListD.getColorForState(new int[]{android.R.attr.state_selected}, colorStateListD.getDefaultColor());
        this.C = new int[]{colorForState, colorForState, colorStateListD.getDefaultColor()};
        clockHandView.f1406c.add(this);
        int defaultColor = z.t(context, R.color.material_timepicker_clockface).getDefaultColor();
        ColorStateList colorStateListD2 = v.D(context, typedArrayObtainStyledAttributes, 0);
        setBackgroundColor(colorStateListD2 != null ? colorStateListD2.getDefaultColor() : defaultColor);
        getViewTreeObserver().addOnPreDrawListener(new b(this));
        setFocusable(false);
        typedArrayObtainStyledAttributes.recycle();
        this.B = new c(this);
        String[] strArr = new String[12];
        Arrays.fill(strArr, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID);
        this.I = strArr;
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        int size = sparseArray.size();
        boolean z = false;
        for (int i8 = 0; i8 < Math.max(this.I.length, size); i8++) {
            TextView textView = (TextView) sparseArray.get(i8);
            if (i8 >= this.I.length) {
                removeView(textView);
                sparseArray.remove(i8);
            } else {
                if (textView == null) {
                    textView = (TextView) layoutInflaterFrom.inflate(R.layout.material_clockface_textview, (ViewGroup) this, false);
                    sparseArray.put(i8, textView);
                    addView(textView);
                }
                textView.setText(this.I[i8]);
                textView.setTag(R.id.material_value_index, Integer.valueOf(i8));
                int i9 = (i8 / 12) + 1;
                textView.setTag(R.id.material_clock_level, Integer.valueOf(i9));
                z = i9 > 1 ? true : z;
                a0.e(textView, this.B);
                textView.setTextColor(this.K);
            }
        }
        ClockHandView clockHandView2 = this.f1401w;
        if (clockHandView2.f1405b && !z) {
            clockHandView2.f1415n = 1;
        }
        clockHandView2.f1405b = z;
        clockHandView2.invalidate();
        this.F = resources.getDimensionPixelSize(R.dimen.material_time_picker_minimum_screen_height);
        this.G = resources.getDimensionPixelSize(R.dimen.material_time_picker_minimum_screen_width);
        this.H = resources.getDimensionPixelSize(R.dimen.material_clock_size);
    }

    @Override // com.google.android.material.timepicker.h
    public final void m() {
        n nVar = new n();
        nVar.b(this);
        HashMap map = new HashMap();
        for (int i8 = 0; i8 < getChildCount(); i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getId() != R.id.circle_center && !"skip".equals(childAt.getTag())) {
                int i9 = (Integer) childAt.getTag(R.id.material_clock_level);
                if (i9 == null) {
                    i9 = 1;
                }
                if (!map.containsKey(i9)) {
                    map.put(i9, new ArrayList());
                }
                ((List) map.get(i9)).add(childAt);
            }
        }
        for (Map.Entry entry : map.entrySet()) {
            List list = (List) entry.getValue();
            int iRound = ((Integer) entry.getKey()).intValue() == 2 ? Math.round(this.f1423u * 0.66f) : this.f1423u;
            Iterator it = list.iterator();
            float size = 0.0f;
            while (it.hasNext()) {
                int id = ((View) it.next()).getId();
                Integer numValueOf = Integer.valueOf(id);
                HashMap map2 = nVar.f5049c;
                if (!map2.containsKey(numValueOf)) {
                    map2.put(Integer.valueOf(id), new r.i());
                }
                r.j jVar = ((r.i) map2.get(Integer.valueOf(id))).d;
                jVar.y = R.id.circle_center;
                jVar.z = iRound;
                jVar.A = size;
                size += 360.0f / list.size();
            }
        }
        nVar.a(this);
        setConstraintSet(null);
        requestLayout();
        int i10 = 0;
        while (true) {
            SparseArray sparseArray = this.A;
            if (i10 >= sparseArray.size()) {
                return;
            }
            ((TextView) sparseArray.get(i10)).setVisibility(0);
            i10++;
        }
    }

    public final void n() {
        SparseArray sparseArray;
        Rect rect;
        RectF rectF;
        RectF rectF2 = this.f1401w.f1409g;
        float f3 = Float.MAX_VALUE;
        TextView textView = null;
        int i8 = 0;
        while (true) {
            sparseArray = this.A;
            int size = sparseArray.size();
            rect = this.f1402x;
            rectF = this.y;
            if (i8 >= size) {
                break;
            }
            TextView textView2 = (TextView) sparseArray.get(i8);
            if (textView2 != null) {
                textView2.getHitRect(rect);
                rectF.set(rect);
                rectF.union(rectF2);
                float fHeight = rectF.height() * rectF.width();
                if (fHeight < f3) {
                    textView = textView2;
                    f3 = fHeight;
                }
            }
            i8++;
        }
        for (int i9 = 0; i9 < sparseArray.size(); i9++) {
            TextView textView3 = (TextView) sparseArray.get(i9);
            if (textView3 != null) {
                textView3.setSelected(textView3 == textView);
                textView3.getHitRect(rect);
                rectF.set(rect);
                textView3.getLineBounds(0, this.z);
                rectF.inset(r8.left, r8.top);
                textView3.getPaint().setShader(!RectF.intersects(rectF2, rectF) ? null : new RadialGradient(rectF2.centerX() - rectF.left, rectF2.centerY() - rectF.top, 0.5f * rectF2.width(), this.C, this.D, Shader.TileMode.CLAMP));
                textView3.invalidate();
            }
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(1, this.I.length, false, 1));
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i8, int i9, int i10, int i11) {
        super.onLayout(z, i8, i9, i10, i11);
        n();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public final void onMeasure(int i8, int i9) throws Resources.NotFoundException, NumberFormatException {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int iMax = (int) (this.H / Math.max(Math.max(this.F / displayMetrics.heightPixels, this.G / displayMetrics.widthPixels), 1.0f));
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iMax, 1073741824);
        setMeasuredDimension(iMax, iMax);
        super.onMeasure(iMakeMeasureSpec, iMakeMeasureSpec);
    }
}
