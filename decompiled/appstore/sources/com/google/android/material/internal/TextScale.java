package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.transition.Transition;
import androidx.transition.s;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class TextScale extends Transition {
    private static final String PROPNAME_SCALE = "android:textscale:scale";

    public TextScale() {
    }

    private void captureValues(@NonNull s r10) {
        View r11 = r10.f5086b;
        if ((r11 instanceof TextView) == false) goto L6;
        r10.f5085a.put(PROPNAME_SCALE, Float.valueOf(((TextView) r11).getScaleX()));
        return;
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(@NonNull s r10) {
        captureValues(r10);
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(@NonNull s r10) {
        captureValues(r10);
    }

    @Override // androidx.transition.Transition
    public Animator createAnimator(@NonNull ViewGroup r10, @Nullable s r11, @Nullable s r12) {
        if (r11 == null) goto L22;
        if (r12 != null) goto L6;
        return null;
    L6:
        if ((r11.f5086b instanceof TextView) == false) goto L24;
        View r13 = r12.f5086b;
        if ((r13 instanceof TextView) == false) goto L25;
        final TextView r14 = (TextView) r13;
        Map r15 = r11.f5085a;
        Map r16 = r12.f5085a;
        float r17 = 1.0f;
        if (r15.get(PROPNAME_SCALE) == null) goto L13;
        float r18 = ((Float) r15.get(PROPNAME_SCALE)).floatValue();
    L15:
        if (r16.get(PROPNAME_SCALE) == null) goto L18;
        r17 = ((Float) r16.get(PROPNAME_SCALE)).floatValue();
    L18:
        if (r18 != r17) goto L20;
        return null;
    L20:
        ValueAnimator r19 = ValueAnimator.ofFloat(new float[]{r18, r17});
        r19.addUpdateListener(new AnonymousClass1(this, r14));
        return r19;
    L13:
        r18 = 1.0f;
        goto L15
    L25:
        return null;
    L24:
        return null;
    L22:
        return null;
    }
}
