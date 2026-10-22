package org.bouncycastle.crypto.prng.drbg;

import p7.r;

/* loaded from: classes.dex */
public class DualECPoints {
    private final int cofactor;

    /* renamed from: p, reason: collision with root package name */
    private final r f4583p;

    /* renamed from: q, reason: collision with root package name */
    private final r f4584q;
    private final int securityStrength;

    public DualECPoints(int i8, r rVar, r rVar2, int i9) {
        if (!rVar.f4817a.i(rVar2.f4817a)) {
            throw new IllegalArgumentException("points need to be on the same curve");
        }
        this.securityStrength = i8;
        this.f4583p = rVar;
        this.f4584q = rVar2;
        this.cofactor = i9;
    }

    private static int log2(int i8) {
        int i9 = 0;
        while (true) {
            i8 >>= 1;
            if (i8 == 0) {
                return i9;
            }
            i9++;
        }
    }

    public int getCofactor() {
        return this.cofactor;
    }

    public int getMaxOutlen() {
        return ((this.f4583p.f4817a.l() - (log2(this.cofactor) + 13)) / 8) * 8;
    }

    public r getP() {
        return this.f4583p;
    }

    public r getQ() {
        return this.f4584q;
    }

    public int getSecurityStrength() {
        return this.securityStrength;
    }

    public int getSeedLen() {
        return this.f4583p.f4817a.l();
    }
}
