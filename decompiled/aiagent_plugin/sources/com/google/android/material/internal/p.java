package com.google.android.material.internal;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;

/* JADX INFO: compiled from: ViewOverlayApi18.java */
/* JADX INFO: loaded from: classes2.dex */
class p implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ViewOverlay f13480a;

    p(View r1) {
        this.f13480a = r1.getOverlay();
    }

    @Override // com.google.android.material.internal.q
    public void a(Drawable r1) {
        this.f13480a.add(r1);
    }

    @Override // com.google.android.material.internal.q
    public void b(Drawable r1) {
        this.f13480a.remove(r1);
    }
}
