package com.google.android.material.datepicker;

import android.view.View;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;

/* loaded from: classes3.dex */
public final class y implements OnApplyWindowInsetsListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2441a;
    public final /* synthetic */ View b;
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;
    public final /* synthetic */ int e;

    public y(View view, int i, int i6, int i10, int i11) {
        this.f2441a = i;
        this.b = view;
        this.c = i6;
        this.d = i10;
        this.e = i11;
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        Insets insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars());
        View view2 = this.b;
        int i = this.f2441a;
        if (i >= 0) {
            view2.getLayoutParams().height = i + insets.top;
            view2.setLayoutParams(view2.getLayoutParams());
        }
        view2.setPadding(this.c + insets.left, this.d + insets.top, this.e + insets.right, view2.getPaddingBottom());
        return windowInsetsCompat;
    }
}
