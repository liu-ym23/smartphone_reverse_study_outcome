package com.google.android.material.internal;

import android.annotation.SuppressLint;
import android.widget.ImageButton;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes.dex */
public class n extends ImageButton {

    /* renamed from: a, reason: collision with root package name */
    public int f5112a;

    public final int getUserSetVisibility() {
        return this.f5112a;
    }

    @Override // android.widget.ImageView, android.view.View
    public void setVisibility(int i10) {
        super.setVisibility(i10);
        this.f5112a = i10;
    }
}
