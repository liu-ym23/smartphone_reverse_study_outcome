package com.bytedance.android.livesdk.interactivity.publicscreen.preview;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class b implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ZoomableControllerImp f139338a;

    public b(ZoomableControllerImp r100) {
        Intrinsics.checkNotNullParameter(r100, "zc");
        this.f139338a = r100;
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.preview.e
    public final float nextFactor(float r100) {
        ZoomableControllerImp r101 = this.f139338a;
        float r102 = r101.f139331d;
        r101.getClass();
        if (r100 < ((r102 + 1.0f) / 2)) goto L7;
        return 1.0f;
    L7:
        return r102;
    }
}
