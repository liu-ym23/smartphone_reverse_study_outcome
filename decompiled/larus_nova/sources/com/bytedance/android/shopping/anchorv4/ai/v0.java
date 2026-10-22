package com.bytedance.android.shopping.anchorv4.ai;

import android.view.View;

/* JADX INFO: loaded from: classes12.dex */
public final class v0 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t0 f165696a;

    public v0(t0 r100) {
        this.f165696a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        s0.a("mock overlay clicked, collapse to initial state");
        this.f165696a.D3();
    }
}
