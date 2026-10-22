package com.bytedance.android.livesdk.lottie;

import android.graphics.Bitmap;
import vl2.m;

/* JADX INFO: loaded from: classes10.dex */
public final class d extends rg2.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f153470a;

    public d(m r100) {
        this.f153470a = r100;
    }

    @Override // com.airbnb.lottie.d
    public final Bitmap q(com.airbnb.lottie.h r100) {
        Bitmap r101 = this.f153470a.f555669d.get(r100.f24781d);
        if (r101 != null) goto L5;
        return null;
    L5:
        if (r101.isRecycled() == true) goto L9;
        return r101;
    L9:
        return null;
    }
}
