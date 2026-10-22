package com.stepos.architecture.ui.stepos;

import android.view.View;
import android.view.WindowInsets;

/* loaded from: classes.dex */
public final class a implements View.OnApplyWindowInsetsListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f11217a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f11218b;

    public a(View view, View view2) {
        this.f11217a = view;
        this.f11218b = view2;
    }

    @Override // android.view.View.OnApplyWindowInsetsListener
    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        this.f11217a.setPadding(0, windowInsets.getSystemWindowInsetTop(), 0, 0);
        View view2 = this.f11218b;
        if (view2 != null) {
            view2.setPadding(0, 0, 0, 0);
        }
        return windowInsets;
    }
}
