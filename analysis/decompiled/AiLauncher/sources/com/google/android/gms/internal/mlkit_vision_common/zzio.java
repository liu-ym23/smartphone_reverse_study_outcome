package com.google.android.gms.internal.mlkit_vision_common;

import A2.InterfaceC0618h;

/* loaded from: classes2.dex */
public enum zzio implements InterfaceC0618h {
    SOURCE_UNKNOWN(0),
    BITMAP(1),
    BYTEARRAY(2),
    BYTEBUFFER(3),
    FILEPATH(4),
    ANDROID_MEDIA_IMAGE(5);

    private final int zzh;

    zzio(int i10) {
        this.zzh = i10;
    }

    @Override // A2.InterfaceC0618h
    public final int zza() {
        return this.zzh;
    }
}
