package org.bouncycastle.crypto.prng.drbg;

import java.math.BigInteger;
import org.bouncycastle.asn1.BERTags;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.ec.CustomNamedCurves;
import org.bouncycastle.crypto.prng.EntropySource;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.BigIntegers;
import p7.d;
import p7.d0;
import p7.n;
import p7.r;

/* loaded from: classes.dex */
public class DualECSP800DRBG implements SP80090DRBG {
    private static final int MAX_ADDITIONAL_INPUT = 4096;
    private static final int MAX_ENTROPY_LENGTH = 4096;
    private static final int MAX_PERSONALIZATION_STRING = 4096;
    private static final long RESEED_MAX = 2147483648L;
    private static final DualECPoints[] nistPoints;
    private static final BigInteger p256_Px;
    private static final BigInteger p256_Py;
    private static final BigInteger p256_Qx;
    private static final BigInteger p256_Qy;
    private static final BigInteger p384_Px;
    private static final BigInteger p384_Py;
    private static final BigInteger p384_Qx;
    private static final BigInteger p384_Qy;
    private static final BigInteger p521_Px;
    private static final BigInteger p521_Py;
    private static final BigInteger p521_Qx;
    private static final BigInteger p521_Qy;
    private r _P;
    private r _Q;
    private Digest _digest;
    private EntropySource _entropySource;
    private n _fixedPointMultiplier;
    private int _outlen;
    private long _reseedCounter;
    private byte[] _s;
    private int _sLength;
    private int _securityStrength;
    private int _seedlen;

    static {
        BigInteger bigInteger = new BigInteger("6b17d1f2e12c4247f8bce6e563a440f277037d812deb33a0f4a13945d898c296", 16);
        p256_Px = bigInteger;
        BigInteger bigInteger2 = new BigInteger("4fe342e2fe1a7f9b8ee7eb4a7c0f9e162bce33576b315ececbb6406837bf51f5", 16);
        p256_Py = bigInteger2;
        BigInteger bigInteger3 = new BigInteger("c97445f45cdef9f0d3e05e1e585fc297235b82b5be8ff3efca67c59852018192", 16);
        p256_Qx = bigInteger3;
        BigInteger bigInteger4 = new BigInteger("b28ef557ba31dfcbdd21ac46e2a91e3c304f44cb87058ada2cb815151e610046", 16);
        p256_Qy = bigInteger4;
        BigInteger bigInteger5 = new BigInteger("aa87ca22be8b05378eb1c71ef320ad746e1d3b628ba79b9859f741e082542a385502f25dbf55296c3a545e3872760ab7", 16);
        p384_Px = bigInteger5;
        BigInteger bigInteger6 = new BigInteger("3617de4a96262c6f5d9e98bf9292dc29f8f41dbd289a147ce9da3113b5f0b8c00a60b1ce1d7e819d7a431d7c90ea0e5f", 16);
        p384_Py = bigInteger6;
        BigInteger bigInteger7 = new BigInteger("8e722de3125bddb05580164bfe20b8b432216a62926c57502ceede31c47816edd1e89769124179d0b695106428815065", 16);
        p384_Qx = bigInteger7;
        BigInteger bigInteger8 = new BigInteger("023b1660dd701d0839fd45eec36f9ee7b32e13b315dc02610aa1b636e346df671f790f84c5e09b05674dbb7e45c803dd", 16);
        p384_Qy = bigInteger8;
        BigInteger bigInteger9 = new BigInteger("c6858e06b70404e9cd9e3ecb662395b4429c648139053fb521f828af606b4d3dbaa14b5e77efe75928fe1dc127a2ffa8de3348b3c1856a429bf97e7e31c2e5bd66", 16);
        p521_Px = bigInteger9;
        BigInteger bigInteger10 = new BigInteger("11839296a789a3bc0045c8a5fb42c7d1bd998f54449579b446817afbd17273e662c97ee72995ef42640c550b9013fad0761353c7086a272c24088be94769fd16650", 16);
        p521_Py = bigInteger10;
        BigInteger bigInteger11 = new BigInteger("1b9fa3e518d683c6b65763694ac8efbaec6fab44f2276171a42726507dd08add4c3b3f4c1ebc5b1222ddba077f722943b24c3edfa0f85fe24d0c8c01591f0be6f63", 16);
        p521_Qx = bigInteger11;
        BigInteger bigInteger12 = new BigInteger("1f3bdba585295d9a1110d1df1f9430ef8442c5018976ff3437ef91b81dc0b8132c8d5c39c32d0e004a3092b7d327c0e7a4d26d2c7b69b58f9066652911e457779de", 16);
        p521_Qy = bigInteger12;
        nistPoints = new DualECPoints[]{createDualECPoints("P-256", 128, bigInteger, bigInteger2, bigInteger3, bigInteger4, 1), createDualECPoints("P-384", BERTags.PRIVATE, bigInteger5, bigInteger6, bigInteger7, bigInteger8, 1), createDualECPoints("P-521", 256, bigInteger9, bigInteger10, bigInteger11, bigInteger12, 1)};
    }

    public DualECSP800DRBG(Digest digest, int i8, EntropySource entropySource, byte[] bArr, byte[] bArr2) {
        this(nistPoints, digest, i8, entropySource, bArr, bArr2);
    }

    private static DualECPoints createDualECPoints(String str, int i8, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, int i9) {
        d dVar = (d) CustomNamedCurves.getByNameLazy(str).getCurve();
        return new DualECPoints(i8, dVar.d(bigInteger, bigInteger2), dVar.d(bigInteger3, bigInteger4), i9);
    }

    private byte[] getEntropy() {
        byte[] entropy = this._entropySource.getEntropy();
        if (entropy.length >= (this._securityStrength + 7) / 8) {
            return entropy;
        }
        throw new IllegalStateException("Insufficient entropy provided by entropy source");
    }

    private BigInteger getScalarMultipleXCoord(r rVar, BigInteger bigInteger) {
        r rVarO = ((d0) this._fixedPointMultiplier).m(rVar, bigInteger).o();
        rVarO.b();
        return rVarO.f4818b.t();
    }

    private byte[] pad8(byte[] bArr, int i8) {
        int i9 = i8 % 8;
        if (i9 == 0) {
            return bArr;
        }
        int i10 = 8 - i9;
        int length = bArr.length - 1;
        int i11 = 0;
        while (length >= 0) {
            int i12 = bArr[length] & 255;
            bArr[length] = (byte) ((i11 >> (8 - i10)) | (i12 << i10));
            length--;
            i11 = i12;
        }
        return bArr;
    }

    private byte[] xor(byte[] bArr, byte[] bArr2) {
        if (bArr2 == null) {
            return bArr;
        }
        int length = bArr.length;
        byte[] bArr3 = new byte[length];
        for (int i8 = 0; i8 != length; i8++) {
            bArr3[i8] = (byte) (bArr[i8] ^ bArr2[i8]);
        }
        return bArr3;
    }

    @Override // org.bouncycastle.crypto.prng.drbg.SP80090DRBG
    public int generate(byte[] bArr, byte[] bArr2, boolean z) {
        int length = bArr.length * 8;
        int length2 = bArr.length / this._outlen;
        if (Utils.isTooLarge(bArr2, 512)) {
            throw new IllegalArgumentException("Additional input too large");
        }
        if (this._reseedCounter + length2 > RESEED_MAX) {
            return -1;
        }
        if (z) {
            reseed(bArr2);
            bArr2 = null;
        }
        BigInteger bigInteger = bArr2 != null ? new BigInteger(1, xor(this._s, Utils.hash_df(this._digest, bArr2, this._seedlen))) : new BigInteger(1, this._s);
        int length3 = 0;
        Arrays.fill(bArr, (byte) 0);
        int i8 = 0;
        for (int i9 = 0; i9 < length2; i9++) {
            bigInteger = getScalarMultipleXCoord(this._P, bigInteger);
            byte[] byteArray = getScalarMultipleXCoord(this._Q, bigInteger).toByteArray();
            int length4 = byteArray.length;
            int i10 = this._outlen;
            if (length4 >= i10) {
                System.arraycopy(byteArray, byteArray.length - i10, bArr, i8, i10);
            } else {
                System.arraycopy(byteArray, 0, bArr, (i10 - byteArray.length) + i8, byteArray.length);
            }
            i8 += this._outlen;
            this._reseedCounter++;
        }
        if (i8 < bArr.length) {
            bigInteger = getScalarMultipleXCoord(this._P, bigInteger);
            byte[] byteArray2 = getScalarMultipleXCoord(this._Q, bigInteger).toByteArray();
            int length5 = bArr.length - i8;
            int length6 = byteArray2.length;
            int i11 = this._outlen;
            if (length6 >= i11) {
                length3 = byteArray2.length - i11;
            } else {
                int length7 = i11 - byteArray2.length;
                if (length7 < length5) {
                    i8 += length7;
                    length5 -= length7;
                }
                this._reseedCounter++;
            }
            System.arraycopy(byteArray2, length3, bArr, i8, length5);
            this._reseedCounter++;
        }
        this._s = BigIntegers.asUnsignedByteArray(this._sLength, getScalarMultipleXCoord(this._P, bigInteger));
        return length;
    }

    @Override // org.bouncycastle.crypto.prng.drbg.SP80090DRBG
    public int getBlockSize() {
        return this._outlen * 8;
    }

    @Override // org.bouncycastle.crypto.prng.drbg.SP80090DRBG
    public void reseed(byte[] bArr) {
        if (Utils.isTooLarge(bArr, 512)) {
            throw new IllegalArgumentException("Additional input string too large");
        }
        this._s = Utils.hash_df(this._digest, Arrays.concatenate(pad8(this._s, this._seedlen), getEntropy(), bArr), this._seedlen);
        this._reseedCounter = 0L;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0077, code lost:
    
        if (r2._P == null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0079, code lost:
    
        r3 = org.bouncycastle.crypto.prng.drbg.Utils.hash_df(r2._digest, r6, r2._seedlen);
        r2._s = r3;
        r2._sLength = r3.length;
        r2._reseedCounter = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x008a, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0092, code lost:
    
        throw new java.lang.IllegalArgumentException("security strength cannot be greater than 256 bits");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public DualECSP800DRBG(org.bouncycastle.crypto.prng.drbg.DualECPoints[] r3, org.bouncycastle.crypto.Digest r4, int r5, org.bouncycastle.crypto.prng.EntropySource r6, byte[] r7, byte[] r8) {
        /*
            r2 = this;
            r2.<init>()
            p7.s r0 = new p7.s
            r1 = 0
            r0.<init>(r1)
            r2._fixedPointMultiplier = r0
            r2._digest = r4
            r2._entropySource = r6
            r2._securityStrength = r5
            r0 = 512(0x200, float:7.17E-43)
            boolean r0 = org.bouncycastle.crypto.prng.drbg.Utils.isTooLarge(r7, r0)
            if (r0 != 0) goto La1
            int r0 = r6.entropySize()
            if (r0 < r5) goto L93
            int r6 = r6.entropySize()
            r0 = 4096(0x1000, float:5.74E-42)
            if (r6 > r0) goto L93
            byte[] r6 = r2.getEntropy()
            byte[] r6 = org.bouncycastle.util.Arrays.concatenate(r6, r8, r7)
            r7 = 0
        L30:
            int r8 = r3.length
            if (r7 == r8) goto L75
            r8 = r3[r7]
            int r8 = r8.getSecurityStrength()
            if (r5 > r8) goto L72
            int r4 = org.bouncycastle.crypto.prng.drbg.Utils.getMaxSecurityStrength(r4)
            r5 = r3[r7]
            int r5 = r5.getSecurityStrength()
            if (r4 < r5) goto L6a
            r4 = r3[r7]
            int r4 = r4.getSeedLen()
            r2._seedlen = r4
            r4 = r3[r7]
            int r4 = r4.getMaxOutlen()
            int r4 = r4 / 8
            r2._outlen = r4
            r4 = r3[r7]
            p7.r r4 = r4.getP()
            r2._P = r4
            r3 = r3[r7]
            p7.r r3 = r3.getQ()
            r2._Q = r3
            goto L75
        L6a:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "Requested security strength is not supported by digest"
            r2.<init>(r3)
            throw r2
        L72:
            int r7 = r7 + 1
            goto L30
        L75:
            p7.r r3 = r2._P
            if (r3 == 0) goto L8b
            org.bouncycastle.crypto.Digest r3 = r2._digest
            int r4 = r2._seedlen
            byte[] r3 = org.bouncycastle.crypto.prng.drbg.Utils.hash_df(r3, r6, r4)
            r2._s = r3
            int r3 = r3.length
            r2._sLength = r3
            r3 = 0
            r2._reseedCounter = r3
            return
        L8b:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "security strength cannot be greater than 256 bits"
            r2.<init>(r3)
            throw r2
        L93:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "EntropySource must provide between "
            java.lang.String r4 = " and 4096 bits"
            java.lang.String r3 = a8.b.k(r5, r3, r4)
            r2.<init>(r3)
            throw r2
        La1:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "Personalization string too large"
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.crypto.prng.drbg.DualECSP800DRBG.<init>(org.bouncycastle.crypto.prng.drbg.DualECPoints[], org.bouncycastle.crypto.Digest, int, org.bouncycastle.crypto.prng.EntropySource, byte[], byte[]):void");
    }
}
