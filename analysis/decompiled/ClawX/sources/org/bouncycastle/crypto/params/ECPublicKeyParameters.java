package org.bouncycastle.crypto.params;

import p7.r;

/* loaded from: classes.dex */
public class ECPublicKeyParameters extends ECKeyParameters {

    /* renamed from: q, reason: collision with root package name */
    private final r f4557q;

    public ECPublicKeyParameters(r rVar, ECDomainParameters eCDomainParameters) {
        super(false, eCDomainParameters);
        this.f4557q = eCDomainParameters.validatePublicPoint(rVar);
    }

    public r getQ() {
        return this.f4557q;
    }
}
