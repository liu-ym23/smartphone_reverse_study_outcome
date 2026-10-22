package com.google.android.gms.internal.mlkit_vision_common;

import A2.InterfaceC0618h;

/* loaded from: classes2.dex */
public enum zzii implements InterfaceC0618h {
    UNKNOWN_FORMAT(0),
    NV16(1),
    NV21(2),
    YV12(3),
    YUV_420_888(7),
    JPEG(8),
    BITMAP(4),
    CM_SAMPLE_BUFFER_REF(5),
    UI_IMAGE(6),
    CV_PIXEL_BUFFER_REF(9);

    private final int zzl;

    zzii(int i10) {
        this.zzl = i10;
    }

    @Override // A2.InterfaceC0618h
    public final int zza() {
        return this.zzl;
    }
}
