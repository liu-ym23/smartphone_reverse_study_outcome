package org.bouncycastle.crypto.hpke;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.asn1.BERTags;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.RawAgreement;
import org.bouncycastle.crypto.agreement.BasicRawAgreement;
import org.bouncycastle.crypto.agreement.ECDHCBasicAgreement;
import org.bouncycastle.crypto.agreement.X25519Agreement;
import org.bouncycastle.crypto.agreement.X448Agreement;
import org.bouncycastle.crypto.ec.CustomNamedCurves;
import org.bouncycastle.crypto.generators.ECKeyPairGenerator;
import org.bouncycastle.crypto.generators.X25519KeyPairGenerator;
import org.bouncycastle.crypto.generators.X448KeyPairGenerator;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECKeyGenerationParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.crypto.params.X25519KeyGenerationParameters;
import org.bouncycastle.crypto.params.X25519PrivateKeyParameters;
import org.bouncycastle.crypto.params.X25519PublicKeyParameters;
import org.bouncycastle.crypto.params.X448KeyGenerationParameters;
import org.bouncycastle.crypto.params.X448PrivateKeyParameters;
import org.bouncycastle.crypto.params.X448PublicKeyParameters;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.BigIntegers;
import org.bouncycastle.util.Pack;
import org.bouncycastle.util.Strings;
import p7.d0;
import p7.s;
import u7.a;

/* loaded from: classes.dex */
class DHKEM extends KEM {
    private int Nenc;
    private int Nsecret;
    private int Nsk;
    private byte bitmask;
    ECDomainParameters domainParams;
    private HKDF hkdf;
    private final short kemId;
    private AsymmetricCipherKeyPairGenerator kpGen;
    private RawAgreement rawAgreement;

    public DHKEM(short s8) {
        this.kemId = s8;
        if (s8 == 32) {
            this.hkdf = new HKDF((short) 1);
            this.rawAgreement = new X25519Agreement();
            this.Nsecret = 32;
            this.Nsk = 32;
            this.Nenc = 32;
            X25519KeyPairGenerator x25519KeyPairGenerator = new X25519KeyPairGenerator();
            this.kpGen = x25519KeyPairGenerator;
            x25519KeyPairGenerator.init(new X25519KeyGenerationParameters(getSecureRandom()));
            return;
        }
        if (s8 == 33) {
            this.hkdf = new HKDF((short) 3);
            this.rawAgreement = new X448Agreement();
            this.Nsecret = 64;
            this.Nsk = 56;
            this.Nenc = 56;
            X448KeyPairGenerator x448KeyPairGenerator = new X448KeyPairGenerator();
            this.kpGen = x448KeyPairGenerator;
            x448KeyPairGenerator.init(new X448KeyGenerationParameters(getSecureRandom()));
            return;
        }
        switch (s8) {
            case 16:
                this.hkdf = new HKDF((short) 1);
                this.domainParams = getDomainParameters("P-256");
                this.rawAgreement = new BasicRawAgreement(new ECDHCBasicAgreement());
                this.bitmask = (byte) -1;
                this.Nsk = 32;
                this.Nsecret = 32;
                this.Nenc = 65;
                ECKeyPairGenerator eCKeyPairGenerator = new ECKeyPairGenerator();
                this.kpGen = eCKeyPairGenerator;
                eCKeyPairGenerator.init(new ECKeyGenerationParameters(this.domainParams, getSecureRandom()));
                return;
            case 17:
                this.hkdf = new HKDF((short) 2);
                this.domainParams = getDomainParameters("P-384");
                this.rawAgreement = new BasicRawAgreement(new ECDHCBasicAgreement());
                this.bitmask = (byte) -1;
                this.Nsk = 48;
                this.Nsecret = 48;
                this.Nenc = 97;
                ECKeyPairGenerator eCKeyPairGenerator2 = new ECKeyPairGenerator();
                this.kpGen = eCKeyPairGenerator2;
                eCKeyPairGenerator2.init(new ECKeyGenerationParameters(this.domainParams, getSecureRandom()));
                return;
            case BERTags.NUMERIC_STRING /* 18 */:
                this.hkdf = new HKDF((short) 3);
                this.domainParams = getDomainParameters("P-521");
                this.rawAgreement = new BasicRawAgreement(new ECDHCBasicAgreement());
                this.bitmask = (byte) 1;
                this.Nsk = 66;
                this.Nsecret = 64;
                this.Nenc = 133;
                ECKeyPairGenerator eCKeyPairGenerator3 = new ECKeyPairGenerator();
                this.kpGen = eCKeyPairGenerator3;
                eCKeyPairGenerator3.init(new ECKeyGenerationParameters(this.domainParams, getSecureRandom()));
                return;
            default:
                throw new IllegalArgumentException("invalid kem id");
        }
    }

    private byte[] ExtractAndExpand(byte[] bArr, byte[] bArr2) {
        byte[] bArrConcatenate = Arrays.concatenate(Strings.toByteArray("KEM"), Pack.shortToBigEndian(this.kemId));
        return this.hkdf.LabeledExpand(this.hkdf.LabeledExtract(null, bArrConcatenate, "eae_prk", bArr), bArrConcatenate, "shared_secret", bArr2, this.Nsecret);
    }

    private static byte[] calculateRawAgreement(RawAgreement rawAgreement, AsymmetricKeyParameter asymmetricKeyParameter, AsymmetricKeyParameter asymmetricKeyParameter2) {
        rawAgreement.init(asymmetricKeyParameter);
        byte[] bArr = new byte[rawAgreement.getAgreementSize()];
        rawAgreement.calculateAgreement(asymmetricKeyParameter2, bArr, 0);
        return bArr;
    }

    private static ECDomainParameters getDomainParameters(String str) {
        return new ECDomainParameters(CustomNamedCurves.getByName(str));
    }

    private static SecureRandom getSecureRandom() {
        return CryptoServicesRegistrar.getSecureRandom();
    }

    private boolean validateSk(BigInteger bigInteger) {
        BigInteger n3 = this.domainParams.getN();
        return bigInteger.compareTo(BigInteger.valueOf(1L)) >= 0 && bigInteger.compareTo(n3) < 0 && d0.e(bigInteger) >= (n3.bitLength() >>> 2);
    }

    @Override // org.bouncycastle.crypto.hpke.KEM
    public byte[] AuthDecap(byte[] bArr, AsymmetricCipherKeyPair asymmetricCipherKeyPair, AsymmetricKeyParameter asymmetricKeyParameter) {
        AsymmetricKeyParameter asymmetricKeyParameterDeserializePublicKey = DeserializePublicKey(bArr);
        this.rawAgreement.init(asymmetricCipherKeyPair.getPrivate());
        int agreementSize = this.rawAgreement.getAgreementSize();
        byte[] bArr2 = new byte[agreementSize * 2];
        this.rawAgreement.calculateAgreement(asymmetricKeyParameterDeserializePublicKey, bArr2, 0);
        this.rawAgreement.calculateAgreement(asymmetricKeyParameter, bArr2, agreementSize);
        return ExtractAndExpand(bArr2, Arrays.concatenate(bArr, SerializePublicKey(asymmetricCipherKeyPair.getPublic()), SerializePublicKey(asymmetricKeyParameter)));
    }

    @Override // org.bouncycastle.crypto.hpke.KEM
    public byte[][] AuthEncap(AsymmetricKeyParameter asymmetricKeyParameter, AsymmetricCipherKeyPair asymmetricCipherKeyPair) {
        AsymmetricCipherKeyPair asymmetricCipherKeyPairGenerateKeyPair = this.kpGen.generateKeyPair();
        this.rawAgreement.init(asymmetricCipherKeyPairGenerateKeyPair.getPrivate());
        int agreementSize = this.rawAgreement.getAgreementSize();
        byte[] bArr = new byte[agreementSize * 2];
        this.rawAgreement.calculateAgreement(asymmetricKeyParameter, bArr, 0);
        this.rawAgreement.init(asymmetricCipherKeyPair.getPrivate());
        if (agreementSize != this.rawAgreement.getAgreementSize()) {
            throw new IllegalStateException();
        }
        this.rawAgreement.calculateAgreement(asymmetricKeyParameter, bArr, agreementSize);
        byte[] bArrSerializePublicKey = SerializePublicKey(asymmetricCipherKeyPairGenerateKeyPair.getPublic());
        return new byte[][]{ExtractAndExpand(bArr, Arrays.concatenate(bArrSerializePublicKey, SerializePublicKey(asymmetricKeyParameter), SerializePublicKey(asymmetricCipherKeyPair.getPublic()))), bArrSerializePublicKey};
    }

    @Override // org.bouncycastle.crypto.hpke.KEM
    public byte[] Decap(byte[] bArr, AsymmetricCipherKeyPair asymmetricCipherKeyPair) {
        return ExtractAndExpand(calculateRawAgreement(this.rawAgreement, asymmetricCipherKeyPair.getPrivate(), DeserializePublicKey(bArr)), Arrays.concatenate(bArr, SerializePublicKey(asymmetricCipherKeyPair.getPublic())));
    }

    @Override // org.bouncycastle.crypto.hpke.KEM
    public AsymmetricCipherKeyPair DeriveKeyPair(byte[] bArr) {
        byte[] bArrConcatenate = Arrays.concatenate(Strings.toByteArray("KEM"), Pack.shortToBigEndian(this.kemId));
        short s8 = this.kemId;
        if (s8 == 32) {
            X25519PrivateKeyParameters x25519PrivateKeyParameters = new X25519PrivateKeyParameters(this.hkdf.LabeledExpand(this.hkdf.LabeledExtract(null, bArrConcatenate, "dkp_prk", bArr), bArrConcatenate, "sk", null, this.Nsk));
            return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) x25519PrivateKeyParameters.generatePublicKey(), (AsymmetricKeyParameter) x25519PrivateKeyParameters);
        }
        if (s8 == 33) {
            X448PrivateKeyParameters x448PrivateKeyParameters = new X448PrivateKeyParameters(this.hkdf.LabeledExpand(this.hkdf.LabeledExtract(null, bArrConcatenate, "dkp_prk", bArr), bArrConcatenate, "sk", null, this.Nsk));
            return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) x448PrivateKeyParameters.generatePublicKey(), (AsymmetricKeyParameter) x448PrivateKeyParameters);
        }
        switch (s8) {
            case 16:
            case 17:
            case BERTags.NUMERIC_STRING /* 18 */:
                byte[] bArrLabeledExtract = this.hkdf.LabeledExtract(null, bArrConcatenate, "dkp_prk", bArr);
                for (int i8 = 0; i8 < 256; i8++) {
                    byte[] bArrLabeledExpand = this.hkdf.LabeledExpand(bArrLabeledExtract, bArrConcatenate, "candidate", new byte[]{(byte) i8}, this.Nsk);
                    bArrLabeledExpand[0] = (byte) (bArrLabeledExpand[0] & this.bitmask);
                    BigInteger bigInteger = new BigInteger(1, bArrLabeledExpand);
                    if (validateSk(bigInteger)) {
                        return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) new ECPublicKeyParameters(new s(0).m(this.domainParams.getG(), bigInteger), this.domainParams), (AsymmetricKeyParameter) new ECPrivateKeyParameters(bigInteger, this.domainParams));
                    }
                }
                throw new IllegalStateException("DeriveKeyPairError");
            default:
                throw new IllegalStateException("invalid kem id");
        }
    }

    @Override // org.bouncycastle.crypto.hpke.KEM
    public AsymmetricCipherKeyPair DeserializePrivateKey(byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            throw new NullPointerException("'skEncoded' cannot be null");
        }
        if (bArr.length != this.Nsk) {
            throw new IllegalArgumentException("'skEncoded' has invalid length");
        }
        AsymmetricKeyParameter asymmetricKeyParameterDeserializePublicKey = bArr2 != null ? DeserializePublicKey(bArr2) : null;
        short s8 = this.kemId;
        if (s8 == 32) {
            X25519PrivateKeyParameters x25519PrivateKeyParameters = new X25519PrivateKeyParameters(bArr);
            if (asymmetricKeyParameterDeserializePublicKey == null) {
                asymmetricKeyParameterDeserializePublicKey = x25519PrivateKeyParameters.generatePublicKey();
            }
            return new AsymmetricCipherKeyPair(asymmetricKeyParameterDeserializePublicKey, (AsymmetricKeyParameter) x25519PrivateKeyParameters);
        }
        if (s8 == 33) {
            X448PrivateKeyParameters x448PrivateKeyParameters = new X448PrivateKeyParameters(bArr);
            if (asymmetricKeyParameterDeserializePublicKey == null) {
                asymmetricKeyParameterDeserializePublicKey = x448PrivateKeyParameters.generatePublicKey();
            }
            return new AsymmetricCipherKeyPair(asymmetricKeyParameterDeserializePublicKey, (AsymmetricKeyParameter) x448PrivateKeyParameters);
        }
        switch (s8) {
            case 16:
            case 17:
            case BERTags.NUMERIC_STRING /* 18 */:
                ECPrivateKeyParameters eCPrivateKeyParameters = new ECPrivateKeyParameters(new BigInteger(1, bArr), this.domainParams);
                if (asymmetricKeyParameterDeserializePublicKey == null) {
                    asymmetricKeyParameterDeserializePublicKey = new ECPublicKeyParameters(new s(0).m(this.domainParams.getG(), eCPrivateKeyParameters.getD()), this.domainParams);
                }
                return new AsymmetricCipherKeyPair(asymmetricKeyParameterDeserializePublicKey, (AsymmetricKeyParameter) eCPrivateKeyParameters);
            default:
                throw new IllegalStateException("invalid kem id");
        }
    }

    @Override // org.bouncycastle.crypto.hpke.KEM
    public AsymmetricKeyParameter DeserializePublicKey(byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException("'pkEncoded' cannot be null");
        }
        if (bArr.length != this.Nenc) {
            throw new IllegalArgumentException("'pkEncoded' has invalid length");
        }
        short s8 = this.kemId;
        if (s8 == 32) {
            return new X25519PublicKeyParameters(bArr);
        }
        if (s8 == 33) {
            return new X448PublicKeyParameters(bArr);
        }
        switch (s8) {
            case 16:
            case 17:
            case BERTags.NUMERIC_STRING /* 18 */:
                if (bArr[0] == 4) {
                    return new ECPublicKeyParameters(this.domainParams.getCurve().g(bArr), this.domainParams);
                }
                throw new IllegalArgumentException("'pkEncoded' has invalid format");
            default:
                throw new IllegalStateException("invalid kem id");
        }
    }

    @Override // org.bouncycastle.crypto.hpke.KEM
    public byte[][] Encap(AsymmetricKeyParameter asymmetricKeyParameter) {
        return Encap(asymmetricKeyParameter, this.kpGen.generateKeyPair());
    }

    @Override // org.bouncycastle.crypto.hpke.KEM
    public AsymmetricCipherKeyPair GeneratePrivateKey() {
        return this.kpGen.generateKeyPair();
    }

    @Override // org.bouncycastle.crypto.hpke.KEM
    public byte[] SerializePrivateKey(AsymmetricKeyParameter asymmetricKeyParameter) {
        short s8 = this.kemId;
        if (s8 == 32) {
            byte[] encoded = ((X25519PrivateKeyParameters) asymmetricKeyParameter).getEncoded();
            a.e(encoded);
            return encoded;
        }
        if (s8 != 33) {
            switch (s8) {
                case 16:
                case 17:
                case BERTags.NUMERIC_STRING /* 18 */:
                    return BigIntegers.asUnsignedByteArray(this.Nsk, ((ECPrivateKeyParameters) asymmetricKeyParameter).getD());
                default:
                    throw new IllegalStateException("invalid kem id");
            }
        }
        byte[] encoded2 = ((X448PrivateKeyParameters) asymmetricKeyParameter).getEncoded();
        a.f(encoded2);
        return encoded2;
    }

    @Override // org.bouncycastle.crypto.hpke.KEM
    public byte[] SerializePublicKey(AsymmetricKeyParameter asymmetricKeyParameter) {
        short s8 = this.kemId;
        if (s8 == 32) {
            return ((X25519PublicKeyParameters) asymmetricKeyParameter).getEncoded();
        }
        if (s8 == 33) {
            return ((X448PublicKeyParameters) asymmetricKeyParameter).getEncoded();
        }
        switch (s8) {
            case 16:
            case 17:
            case BERTags.NUMERIC_STRING /* 18 */:
                return ((ECPublicKeyParameters) asymmetricKeyParameter).getQ().g(false);
            default:
                throw new IllegalStateException("invalid kem id");
        }
    }

    @Override // org.bouncycastle.crypto.hpke.KEM
    public int getEncryptionSize() {
        return this.Nenc;
    }

    @Override // org.bouncycastle.crypto.hpke.KEM
    public byte[][] Encap(AsymmetricKeyParameter asymmetricKeyParameter, AsymmetricCipherKeyPair asymmetricCipherKeyPair) {
        byte[] bArrCalculateRawAgreement = calculateRawAgreement(this.rawAgreement, asymmetricCipherKeyPair.getPrivate(), asymmetricKeyParameter);
        byte[] bArrSerializePublicKey = SerializePublicKey(asymmetricCipherKeyPair.getPublic());
        return new byte[][]{ExtractAndExpand(bArrCalculateRawAgreement, Arrays.concatenate(bArrSerializePublicKey, SerializePublicKey(asymmetricKeyParameter))), bArrSerializePublicKey};
    }
}
