package org.bouncycastle.crypto.params;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.KeyGenerationParameters;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.BigIntegers;
import p7.r;

/* loaded from: classes.dex */
public class ECCSIKeyGenerationParameters extends KeyGenerationParameters {
    private final r G;
    private final Digest digest;
    private final byte[] id;
    private final r kpak;
    private final BigInteger ksak;

    /* renamed from: n, reason: collision with root package name */
    private final int f4553n;

    /* renamed from: q, reason: collision with root package name */
    private final BigInteger f4554q;

    public ECCSIKeyGenerationParameters(SecureRandom secureRandom, X9ECParameters x9ECParameters, Digest digest, byte[] bArr) {
        super(secureRandom, x9ECParameters.getCurve().f4798b.c());
        BigInteger bigInteger = x9ECParameters.getCurve().d;
        this.f4554q = bigInteger;
        r g6 = x9ECParameters.getG();
        this.G = g6;
        this.digest = digest;
        this.id = Arrays.clone(bArr);
        int iC = x9ECParameters.getCurve().f4798b.c();
        this.f4553n = iC;
        BigInteger bigIntegerMod = BigIntegers.createRandomBigInteger(iC, secureRandom).mod(bigInteger);
        this.ksak = bigIntegerMod;
        this.kpak = g6.m(bigIntegerMod).o();
    }

    public BigInteger computeSSK(BigInteger bigInteger) {
        return this.ksak.add(bigInteger).mod(this.f4554q);
    }

    public Digest getDigest() {
        return this.digest;
    }

    public r getG() {
        return this.G;
    }

    public byte[] getId() {
        return Arrays.clone(this.id);
    }

    public r getKPAK() {
        return this.kpak;
    }

    public int getN() {
        return this.f4553n;
    }

    public BigInteger getQ() {
        return this.f4554q;
    }
}
