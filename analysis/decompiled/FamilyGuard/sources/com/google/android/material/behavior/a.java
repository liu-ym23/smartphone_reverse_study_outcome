package com.google.android.material.behavior;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;

/* loaded from: classes.dex */
final class a extends d {
    a() {
    }

    @Override // com.google.android.material.behavior.d
    <V extends View> int a(V v5, ViewGroup.MarginLayoutParams marginLayoutParams) {
        return v5.getMeasuredHeight() + marginLayoutParams.bottomMargin;
    }

    @Override // com.google.android.material.behavior.d
    int b() {
        return 0;
    }

    @Override // com.google.android.material.behavior.d
    int c() {
        return 1;
    }

    @Override // com.google.android.material.behavior.d
    <V extends View> ViewPropertyAnimator d(V v5, int i5) {
        return v5.animate().translationY(i5);
    }

    @Override // com.google.android.material.behavior.d
    <V extends View> void e(V v5, int i5) {
        v5.setTranslationY(i5);
    }
}
