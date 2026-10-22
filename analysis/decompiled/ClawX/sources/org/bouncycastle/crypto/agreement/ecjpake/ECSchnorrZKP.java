package org.bouncycastle.crypto.agreement.ecjpake;

import java.math.BigInteger;
import p7.r;

/* loaded from: classes.dex */
public class ECSchnorrZKP {
    private final r V;

    /* renamed from: r, reason: collision with root package name */
    private final BigInteger f4384r;

    public ECSchnorrZKP(r rVar, BigInteger bigInteger) {
        this.V = rVar;
        this.f4384r = bigInteger;
    }

    public r getV() {
        return this.V;
    }

    public BigInteger getr() {
        return this.f4384r;
    }
}
