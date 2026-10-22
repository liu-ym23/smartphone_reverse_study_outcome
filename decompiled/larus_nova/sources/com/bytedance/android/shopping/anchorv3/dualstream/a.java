package com.bytedance.android.shopping.anchorv3.dualstream;

import android.view.View;

/* JADX INFO: loaded from: classes12.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AnchorV3DualStreamActivity f165077a;

    public a(AnchorV3DualStreamActivity r100) {
        this.f165077a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f165077a.finish();
    }
}
