package org.bouncycastle.crypto.params;

import p7.r;

/* loaded from: classes.dex */
public class ECCSIPublicKeyParameters extends AsymmetricKeyParameter {
    private final r pvt;

    public ECCSIPublicKeyParameters(r rVar) {
        super(false);
        this.pvt = rVar;
    }

    public final r getPVT() {
        return this.pvt;
    }
}
