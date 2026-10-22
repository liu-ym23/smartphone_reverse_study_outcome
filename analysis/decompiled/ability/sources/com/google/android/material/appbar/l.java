package com.google.android.material.appbar;

import android.view.View;
import androidx.core.view.ViewCompat;

/* loaded from: classes3.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public final View f2295a;
    public int b;
    public int c;
    public int d;
    public int e;
    public boolean f = true;
    public boolean g = true;

    public l(View view) {
        this.f2295a = view;
    }

    public final void a() {
        int i = this.d;
        View view = this.f2295a;
        ViewCompat.offsetTopAndBottom(view, i - (view.getTop() - this.b));
        ViewCompat.offsetLeftAndRight(view, this.e - (view.getLeft() - this.c));
    }
}
