package org.bouncycastle.crypto.signers;

import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.Signer;
import org.bouncycastle.crypto.params.ECCSIPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECCSIPublicKeyParameters;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.BigIntegers;
import p7.r;

/* loaded from: classes.dex */
public class ECCSISigner implements Signer {
    private final r G;
    private final int N;
    private r Y;
    private final Digest digest;
    private boolean forSigning;
    private final byte[] id;

    /* renamed from: j, reason: collision with root package name */
    private BigInteger f4585j;
    private final r kpak;
    private CipherParameters param;

    /* renamed from: q, reason: collision with root package name */
    private final BigInteger f4586q;

    /* renamed from: r, reason: collision with root package name */
    private BigInteger f4587r;
    private ByteArrayOutputStream stream;

    public ECCSISigner(r rVar, X9ECParameters x9ECParameters, Digest digest, byte[] bArr) {
        this.kpak = rVar;
        this.id = bArr;
        this.f4586q = x9ECParameters.getCurve().d;
        this.G = x9ECParameters.getG();
        this.digest = digest;
        digest.reset();
        this.N = (x9ECParameters.getCurve().d.bitLength() + 7) >> 3;
    }

    @Override // org.bouncycastle.crypto.Signer
    public byte[] generateSignature() {
        byte[] bArr = new byte[this.digest.getDigestSize()];
        this.digest.doFinal(bArr, 0);
        ECCSIPrivateKeyParameters eCCSIPrivateKeyParameters = (ECCSIPrivateKeyParameters) ((ParametersWithRandom) this.param).getParameters();
        BigInteger bigIntegerMod = new BigInteger(1, bArr).add(this.f4587r.multiply(eCCSIPrivateKeyParameters.getSSK())).mod(this.f4586q);
        if (bigIntegerMod.equals(BigInteger.ZERO)) {
            throw new IllegalArgumentException("Invalid j, retry");
        }
        return Arrays.concatenate(BigIntegers.asUnsignedByteArray(this.N, this.f4587r), BigIntegers.asUnsignedByteArray(this.N, bigIntegerMod.modInverse(this.f4586q).multiply(this.f4585j).mod(this.f4586q)), eCCSIPrivateKeyParameters.getPublicKeyParameters().getPVT().g(false));
    }

    @Override // org.bouncycastle.crypto.Signer
    public void init(boolean z, CipherParameters cipherParameters) {
        this.forSigning = z;
        this.param = cipherParameters;
        reset();
    }

    @Override // org.bouncycastle.crypto.Signer
    public void reset() {
        SecureRandom random;
        r pvt;
        r rVarM;
        this.digest.reset();
        CipherParameters parameters = this.param;
        if (parameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) parameters;
            random = parametersWithRandom.getRandom();
            parameters = parametersWithRandom.getParameters();
        } else {
            random = null;
        }
        if (this.forSigning) {
            ECCSIPrivateKeyParameters eCCSIPrivateKeyParameters = (ECCSIPrivateKeyParameters) parameters;
            pvt = eCCSIPrivateKeyParameters.getPublicKeyParameters().getPVT();
            BigInteger bigIntegerCreateRandomBigInteger = BigIntegers.createRandomBigInteger(this.f4586q.bitLength(), random);
            this.f4585j = bigIntegerCreateRandomBigInteger;
            r rVarO = this.G.m(bigIntegerCreateRandomBigInteger).o();
            rVarO.b();
            this.f4587r = rVarO.f4818b.t().mod(this.f4586q);
            rVarM = this.G.m(eCCSIPrivateKeyParameters.getSSK());
        } else {
            r pvt2 = ((ECCSIPublicKeyParameters) parameters).getPVT();
            this.stream = new ByteArrayOutputStream();
            pvt = pvt2;
            rVarM = null;
        }
        byte[] bArrG = this.G.g(false);
        this.digest.update(bArrG, 0, bArrG.length);
        byte[] bArrG2 = this.kpak.g(false);
        this.digest.update(bArrG2, 0, bArrG2.length);
        Digest digest = this.digest;
        byte[] bArr = this.id;
        digest.update(bArr, 0, bArr.length);
        byte[] bArrG3 = pvt.g(false);
        this.digest.update(bArrG3, 0, bArrG3.length);
        int digestSize = this.digest.getDigestSize();
        byte[] bArr2 = new byte[digestSize];
        this.digest.doFinal(bArr2, 0);
        BigInteger bigIntegerMod = new BigInteger(1, bArr2).mod(this.f4586q);
        this.digest.update(bArr2, 0, digestSize);
        if (!this.forSigning) {
            this.Y = pvt.m(bigIntegerMod).a(this.kpak).o();
        } else {
            if (!rVarM.u(pvt.m(bigIntegerMod)).o().c(this.kpak)) {
                throw new IllegalArgumentException("Invalid KPAK");
            }
            byte[] bArrAsUnsignedByteArray = BigIntegers.asUnsignedByteArray(this.N, this.f4587r);
            this.digest.update(bArrAsUnsignedByteArray, 0, bArrAsUnsignedByteArray.length);
        }
    }

    @Override // org.bouncycastle.crypto.Signer
    public void update(byte b9) {
        if (this.forSigning) {
            this.digest.update(b9);
        } else {
            this.stream.write(b9);
        }
    }

    @Override // org.bouncycastle.crypto.Signer
    public boolean verifySignature(byte[] bArr) {
        byte[] bArrCopyOf = Arrays.copyOf(bArr, this.N);
        int i8 = this.N;
        BigInteger bigInteger = new BigInteger(1, Arrays.copyOfRange(bArr, i8, i8 << 1));
        this.f4587r = new BigInteger(1, bArrCopyOf).mod(this.f4586q);
        this.digest.update(bArrCopyOf, 0, this.N);
        byte[] byteArray = this.stream.toByteArray();
        this.digest.update(byteArray, 0, byteArray.length);
        byte[] bArr2 = new byte[this.digest.getDigestSize()];
        this.digest.doFinal(bArr2, 0);
        r rVarO = this.G.m(new BigInteger(1, bArr2).mod(this.f4586q)).o().a(this.Y.m(this.f4587r).o()).o().m(bigInteger).o();
        rVarO.b();
        return rVarO.f4818b.t().mod(this.f4586q).equals(this.f4587r.mod(this.f4586q));
    }

    @Override // org.bouncycastle.crypto.Signer
    public void update(byte[] bArr, int i8, int i9) {
        if (this.forSigning) {
            this.digest.update(bArr, i8, i9);
        } else {
            this.stream.write(bArr, i8, i9);
        }
    }
}
