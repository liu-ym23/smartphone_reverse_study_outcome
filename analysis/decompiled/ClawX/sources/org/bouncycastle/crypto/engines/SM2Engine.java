package org.bouncycastle.crypto.engines;

import a8.b;
import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.constraints.ConstraintUtils;
import org.bouncycastle.crypto.constraints.DefaultServiceProperties;
import org.bouncycastle.crypto.digests.SM3Digest;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECKeyParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.BigIntegers;
import org.bouncycastle.util.Bytes;
import org.bouncycastle.util.Memoable;
import org.bouncycastle.util.Pack;
import p7.d0;
import p7.m;
import p7.n;
import p7.r;
import p7.s;

/* loaded from: classes.dex */
public class SM2Engine {
    private int curveLength;
    private final Digest digest;
    private ECKeyParameters ecKey;
    private ECDomainParameters ecParams;
    private boolean forEncryption;
    private final Mode mode;
    private SecureRandom random;

    public enum Mode {
        C1C2C3,
        C1C3C2
    }

    public SM2Engine() {
        this(new SM3Digest());
    }

    private void addFieldElement(Digest digest, m mVar) {
        byte[] bArrAsUnsignedByteArray = BigIntegers.asUnsignedByteArray(this.curveLength, mVar.t());
        digest.update(bArrAsUnsignedByteArray, 0, bArrAsUnsignedByteArray.length);
    }

    private byte[] decrypt(byte[] bArr, int i8, int i9) throws InvalidCipherTextException {
        int i10;
        int i11 = (this.curveLength * 2) + 1;
        byte[] bArr2 = new byte[i11];
        System.arraycopy(bArr, i8, bArr2, 0, i11);
        r rVarG = this.ecParams.getCurve().g(bArr2);
        if (rVarG.m(this.ecParams.getH()).k()) {
            throw new InvalidCipherTextException("[h]C1 at infinity");
        }
        r rVarO = rVarG.m(((ECPrivateKeyParameters) this.ecKey).getD()).o();
        int digestSize = this.digest.getDigestSize();
        int i12 = (i9 - i11) - digestSize;
        byte[] bArr3 = new byte[i12];
        Mode mode = this.mode;
        Mode mode2 = Mode.C1C3C2;
        if (mode == mode2) {
            System.arraycopy(bArr, i8 + i11 + digestSize, bArr3, 0, i12);
        } else {
            System.arraycopy(bArr, i8 + i11, bArr3, 0, i12);
        }
        kdf(this.digest, rVarO, bArr3);
        int digestSize2 = this.digest.getDigestSize();
        byte[] bArr4 = new byte[digestSize2];
        Digest digest = this.digest;
        rVarO.b();
        addFieldElement(digest, rVarO.f4818b);
        this.digest.update(bArr3, 0, i12);
        addFieldElement(this.digest, rVarO.d());
        this.digest.doFinal(bArr4, 0);
        if (this.mode == mode2) {
            i10 = 0;
            for (int i13 = 0; i13 != digestSize2; i13++) {
                i10 |= bArr4[i13] ^ bArr[(i8 + i11) + i13];
            }
        } else {
            int i14 = 0;
            for (int i15 = 0; i15 != digestSize2; i15++) {
                i14 |= bArr4[i15] ^ bArr[b.D(i8, i11, i12, i15)];
            }
            i10 = i14;
        }
        Arrays.fill(bArr2, (byte) 0);
        Arrays.fill(bArr4, (byte) 0);
        if (i10 == 0) {
            return bArr3;
        }
        Arrays.fill(bArr3, (byte) 0);
        throw new InvalidCipherTextException("invalid cipher text");
    }

    private byte[] encrypt(byte[] bArr, int i8, int i9) {
        byte[] bArrG;
        r rVarO;
        byte[] bArr2 = new byte[i9];
        System.arraycopy(bArr, i8, bArr2, 0, i9);
        n nVarCreateBasePointMultiplier = createBasePointMultiplier();
        do {
            BigInteger bigIntegerNextK = nextK();
            bArrG = ((d0) nVarCreateBasePointMultiplier).m(this.ecParams.getG(), bigIntegerNextK).o().g(false);
            rVarO = ((ECPublicKeyParameters) this.ecKey).getQ().m(bigIntegerNextK).o();
            kdf(this.digest, rVarO, bArr2);
        } while (notEncrypted(bArr2, bArr, i8));
        byte[] bArr3 = new byte[this.digest.getDigestSize()];
        Digest digest = this.digest;
        rVarO.b();
        addFieldElement(digest, rVarO.f4818b);
        this.digest.update(bArr, i8, i9);
        addFieldElement(this.digest, rVarO.d());
        this.digest.doFinal(bArr3, 0);
        return this.mode.ordinal() != 1 ? Arrays.concatenate(bArrG, bArr2, bArr3) : Arrays.concatenate(bArrG, bArr3, bArr2);
    }

    private void kdf(Digest digest, r rVar, byte[] bArr) {
        Memoable memoable;
        Memoable memoableCopy;
        int digestSize = digest.getDigestSize();
        byte[] bArr2 = new byte[Math.max(4, digestSize)];
        if (digest instanceof Memoable) {
            rVar.b();
            addFieldElement(digest, rVar.f4818b);
            addFieldElement(digest, rVar.d());
            memoable = (Memoable) digest;
            memoableCopy = memoable.copy();
        } else {
            memoable = null;
            memoableCopy = null;
        }
        int i8 = 0;
        int i9 = 0;
        while (i8 < bArr.length) {
            if (memoable != null) {
                memoable.reset(memoableCopy);
            } else {
                rVar.b();
                addFieldElement(digest, rVar.f4818b);
                addFieldElement(digest, rVar.d());
            }
            i9++;
            Pack.intToBigEndian(i9, bArr2, 0);
            digest.update(bArr2, 0, 4);
            digest.doFinal(bArr2, 0);
            int iMin = Math.min(digestSize, bArr.length - i8);
            Bytes.xorTo(iMin, bArr2, 0, bArr, i8);
            i8 += iMin;
        }
    }

    private BigInteger nextK() {
        int iBitLength = this.ecParams.getN().bitLength();
        while (true) {
            BigInteger bigIntegerCreateRandomBigInteger = BigIntegers.createRandomBigInteger(iBitLength, this.random);
            if (!bigIntegerCreateRandomBigInteger.equals(BigIntegers.ZERO) && bigIntegerCreateRandomBigInteger.compareTo(this.ecParams.getN()) < 0) {
                return bigIntegerCreateRandomBigInteger;
            }
        }
    }

    private boolean notEncrypted(byte[] bArr, byte[] bArr2, int i8) {
        for (int i9 = 0; i9 != bArr.length; i9++) {
            if (bArr[i9] != bArr2[i8 + i9]) {
                return false;
            }
        }
        return true;
    }

    public n createBasePointMultiplier() {
        return new s(0);
    }

    public int getOutputSize(int i8) {
        return this.digest.getDigestSize() + (this.curveLength * 2) + 1 + i8;
    }

    public void init(boolean z, CipherParameters cipherParameters) {
        this.forEncryption = z;
        if (z) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            ECKeyParameters eCKeyParameters = (ECKeyParameters) parametersWithRandom.getParameters();
            this.ecKey = eCKeyParameters;
            this.ecParams = eCKeyParameters.getParameters();
            if (((ECPublicKeyParameters) this.ecKey).getQ().m(this.ecParams.getH()).k()) {
                throw new IllegalArgumentException("invalid key: [h]Q at infinity");
            }
            this.random = parametersWithRandom.getRandom();
        } else {
            ECKeyParameters eCKeyParameters2 = (ECKeyParameters) cipherParameters;
            this.ecKey = eCKeyParameters2;
            this.ecParams = eCKeyParameters2.getParameters();
        }
        this.curveLength = this.ecParams.getCurve().k();
        CryptoServicesRegistrar.checkConstraints(new DefaultServiceProperties("SM2", ConstraintUtils.bitsOfSecurityFor(this.ecParams.getCurve()), this.ecKey, Utils.getPurpose(z)));
    }

    public byte[] processBlock(byte[] bArr, int i8, int i9) {
        if (i8 + i9 > bArr.length || i9 == 0) {
            throw new DataLengthException("input buffer too short");
        }
        return this.forEncryption ? encrypt(bArr, i8, i9) : decrypt(bArr, i8, i9);
    }

    public SM2Engine(Digest digest) {
        this(digest, Mode.C1C2C3);
    }

    public SM2Engine(Digest digest, Mode mode) {
        if (mode == null) {
            throw new IllegalArgumentException("mode cannot be NULL");
        }
        this.digest = digest;
        this.mode = mode;
    }

    public SM2Engine(Mode mode) {
        this(new SM3Digest(), mode);
    }
}
