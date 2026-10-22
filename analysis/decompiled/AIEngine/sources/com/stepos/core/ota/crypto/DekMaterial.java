package com.stepos.core.ota.crypto;

import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class DekMaterial {
    private final byte[] dek;
    private final byte[] wrapped;

    public DekMaterial(byte[] dek, byte[] wrapped) {
        g.f(dek, "dek");
        g.f(wrapped, "wrapped");
        this.dek = dek;
        this.wrapped = wrapped;
    }

    public final byte[] getDek() {
        return this.dek;
    }

    public final byte[] getWrapped() {
        return this.wrapped;
    }
}
