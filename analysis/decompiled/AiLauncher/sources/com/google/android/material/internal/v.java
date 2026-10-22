package com.google.android.material.internal;

import android.annotation.SuppressLint;
import android.widget.ImageButton;

@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes2.dex */
public class v extends ImageButton {

    /* renamed from: a, reason: collision with root package name */
    public int f21158a;

    public final void b(int i10, boolean z10) {
        super.setVisibility(i10);
        if (z10) {
            this.f21158a = i10;
        }
    }

    public final int getUserSetVisibility() {
        return this.f21158a;
    }

    @Override // android.widget.ImageView, android.view.View
    public void setVisibility(int i10) {
        b(i10, true);
    }
}
