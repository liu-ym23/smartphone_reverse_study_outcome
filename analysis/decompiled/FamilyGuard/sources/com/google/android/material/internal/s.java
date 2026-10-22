package com.google.android.material.internal;

import android.widget.ImageButton;

/* loaded from: classes.dex */
public class s extends ImageButton {

    /* renamed from: a, reason: collision with root package name */
    private int f13051a;

    public final void b(int i5, boolean z5) {
        super.setVisibility(i5);
        if (z5) {
            this.f13051a = i5;
        }
    }

    public final int getUserSetVisibility() {
        return this.f13051a;
    }

    @Override // android.widget.ImageView, android.view.View
    public void setVisibility(int i5) {
        b(i5, true);
    }
}
