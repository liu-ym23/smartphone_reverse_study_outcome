package com.google.android.material.behavior;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;

/* loaded from: classes.dex */
abstract class d {
    d() {
    }

    abstract <V extends View> int a(V v5, ViewGroup.MarginLayoutParams marginLayoutParams);

    abstract int b();

    abstract int c();

    abstract <V extends View> ViewPropertyAnimator d(V v5, int i5);

    abstract <V extends View> void e(V v5, int i5);
}
