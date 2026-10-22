package com.google.android.material.slider;

import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.SeekBar;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import com.stepos.ability.R;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;

/* loaded from: classes3.dex */
public final class d extends ExploreByTouchHelper {

    /* renamed from: a, reason: collision with root package name */
    public final Slider f2522a;
    public final Rect b;

    public d(Slider slider) {
        super(slider);
        this.b = new Rect();
        this.f2522a = slider;
    }

    @Override // androidx.customview.widget.ExploreByTouchHelper
    public final int getVirtualViewAt(float f, float f7) {
        int i = 0;
        while (true) {
            Slider slider = this.f2522a;
            if (i >= slider.getValues().size()) {
                return -1;
            }
            Rect rect = this.b;
            slider.A(i, rect);
            if (rect.contains((int) f, (int) f7)) {
                return i;
            }
            i++;
        }
    }

    @Override // androidx.customview.widget.ExploreByTouchHelper
    public final void getVisibleVirtualViews(List list) {
        for (int i = 0; i < this.f2522a.getValues().size(); i++) {
            list.add(Integer.valueOf(i));
        }
    }

    @Override // androidx.customview.widget.ExploreByTouchHelper
    public final boolean onPerformActionForVirtualView(int i, int i6, Bundle bundle) {
        Slider slider = this.f2522a;
        if (!slider.isEnabled()) {
            return false;
        }
        if (i6 != 4096 && i6 != 8192) {
            if (i6 != 16908349 || bundle == null || !bundle.containsKey(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_PROGRESS_VALUE) || !slider.y(bundle.getFloat(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_PROGRESS_VALUE), i)) {
                return false;
            }
            slider.B();
            slider.postInvalidate();
            invalidateVirtualView(i);
            return true;
        }
        float fRound = slider.s0;
        if (fRound == 0.0f) {
            fRound = 1.0f;
        }
        if ((slider.f2580o0 - slider.f2579n0) / fRound > 20) {
            fRound *= Math.round(r1 / r4);
        }
        if (i6 == 8192) {
            fRound = -fRound;
        }
        if (slider.q()) {
            fRound = -fRound;
        }
        if (!slider.y(MathUtils.clamp(slider.getValues().get(i).floatValue() + fRound, slider.getValueFrom(), slider.getValueTo()), i)) {
            return false;
        }
        slider.setActiveThumbIndex(i);
        D6.b bVar = slider.f2563W0;
        slider.removeCallbacks(bVar);
        slider.postDelayed(bVar, slider.f2557T0);
        slider.B();
        slider.postInvalidate();
        invalidateVirtualView(i);
        return true;
    }

    @Override // androidx.customview.widget.ExploreByTouchHelper
    public final void onPopulateNodeForVirtualView(int i, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SET_PROGRESS);
        Slider slider = this.f2522a;
        List<Float> values = slider.getValues();
        Float f = values.get(i);
        float fFloatValue = f.floatValue();
        float valueFrom = slider.getValueFrom();
        float valueTo = slider.getValueTo();
        if (slider.isEnabled()) {
            if (fFloatValue > valueFrom) {
                accessibilityNodeInfoCompat.addAction(8192);
            }
            if (fFloatValue < valueTo) {
                accessibilityNodeInfoCompat.addAction(4096);
            }
        }
        NumberFormat numberInstance = NumberFormat.getNumberInstance();
        numberInstance.setMaximumFractionDigits(2);
        try {
            valueFrom = numberInstance.parse(numberInstance.format(valueFrom)).floatValue();
            valueTo = numberInstance.parse(numberInstance.format(valueTo)).floatValue();
            fFloatValue = numberInstance.parse(numberInstance.format(fFloatValue)).floatValue();
        } catch (ParseException unused) {
            int i6 = f.f2524Y0;
            Log.w("f", "Error parsing value(" + f + "), valueFrom(" + valueFrom + "), and valueTo(" + valueTo + ") into a float.");
        }
        accessibilityNodeInfoCompat.setRangeInfo(AccessibilityNodeInfoCompat.RangeInfoCompat.obtain(1, valueFrom, valueTo, fFloatValue));
        accessibilityNodeInfoCompat.setClassName(SeekBar.class.getName());
        StringBuilder sb = new StringBuilder();
        if (slider.getContentDescription() != null) {
            sb.append(slider.getContentDescription());
            sb.append(",");
        }
        String str = String.format(((float) ((int) fFloatValue)) == fFloatValue ? "%.0f" : "%.2f", Float.valueOf(fFloatValue));
        String string = slider.getContext().getString(R.string.material_slider_value);
        if (values.size() > 1) {
            string = i == slider.getValues().size() - 1 ? slider.getContext().getString(R.string.material_slider_range_end) : i == 0 ? slider.getContext().getString(R.string.material_slider_range_start) : "";
        }
        CharSequence stateDescription = ViewCompat.getStateDescription(slider);
        if (TextUtils.isEmpty(stateDescription)) {
            Locale.getDefault();
            sb.append(string + ", " + str);
        } else {
            accessibilityNodeInfoCompat.setStateDescription(stateDescription);
        }
        accessibilityNodeInfoCompat.setContentDescription(sb.toString());
        Rect rect = this.b;
        slider.A(i, rect);
        accessibilityNodeInfoCompat.setBoundsInParent(rect);
    }
}
