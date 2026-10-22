package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* loaded from: classes2.dex */
public final class zzgr extends RuntimeException {
    public zzgr(InterfaceC1720h1 interfaceC1720h1) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
    }

    public final zzer a() {
        return new zzer(getMessage());
    }
}
