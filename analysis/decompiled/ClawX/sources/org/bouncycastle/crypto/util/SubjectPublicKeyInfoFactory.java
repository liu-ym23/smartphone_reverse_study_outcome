package org.bouncycastle.crypto.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;
import n7.a;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Null;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.asn1.cryptopro.GOST3410PublicKeyAlgParameters;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.RSAPublicKey;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.DSAParameter;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.asn1.x9.X962Parameters;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.asn1.x9.X9ECPoint;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.DSAParameters;
import org.bouncycastle.crypto.params.DSAPublicKeyParameters;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECGOST3410Parameters;
import org.bouncycastle.crypto.params.ECNamedDomainParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.crypto.params.Ed25519PublicKeyParameters;
import org.bouncycastle.crypto.params.Ed448PublicKeyParameters;
import org.bouncycastle.crypto.params.RSAKeyParameters;
import org.bouncycastle.crypto.params.X25519PublicKeyParameters;
import org.bouncycastle.crypto.params.X448PublicKeyParameters;
import org.bouncycastle.util.Arrays;
import p7.r;
import y7.c;

/* loaded from: classes.dex */
public class SubjectPublicKeyInfoFactory {
    private static Set cryptoProOids = null;
    private static final byte tag_OctetString = 4;

    static {
        HashSet hashSet = new HashSet(5);
        cryptoProOids = hashSet;
        hashSet.add(CryptoProObjectIdentifiers.gostR3410_2001_CryptoPro_A);
        cryptoProOids.add(CryptoProObjectIdentifiers.gostR3410_2001_CryptoPro_B);
        cryptoProOids.add(CryptoProObjectIdentifiers.gostR3410_2001_CryptoPro_C);
        cryptoProOids.add(CryptoProObjectIdentifiers.gostR3410_2001_CryptoPro_XchA);
        cryptoProOids.add(CryptoProObjectIdentifiers.gostR3410_2001_CryptoPro_XchB);
    }

    private SubjectPublicKeyInfoFactory() {
    }

    public static SubjectPublicKeyInfo createSubjectPublicKeyInfo(AsymmetricKeyParameter asymmetricKeyParameter) throws IOException {
        X962Parameters x962Parameters;
        ASN1ObjectIdentifier aSN1ObjectIdentifier;
        if (asymmetricKeyParameter instanceof RSAKeyParameters) {
            RSAKeyParameters rSAKeyParameters = (RSAKeyParameters) asymmetricKeyParameter;
            return new SubjectPublicKeyInfo(new AlgorithmIdentifier(PKCSObjectIdentifiers.rsaEncryption, DERNull.INSTANCE), new RSAPublicKey(rSAKeyParameters.getModulus(), rSAKeyParameters.getExponent()));
        }
        if (asymmetricKeyParameter instanceof DSAPublicKeyParameters) {
            DSAPublicKeyParameters dSAPublicKeyParameters = (DSAPublicKeyParameters) asymmetricKeyParameter;
            DSAParameters parameters = dSAPublicKeyParameters.getParameters();
            return new SubjectPublicKeyInfo(new AlgorithmIdentifier(X9ObjectIdentifiers.id_dsa, parameters != null ? new DSAParameter(parameters.getP(), parameters.getQ(), parameters.getG()) : null), new ASN1Integer(dSAPublicKeyParameters.getY()));
        }
        if (asymmetricKeyParameter instanceof ECPublicKeyParameters) {
            ECPublicKeyParameters eCPublicKeyParameters = (ECPublicKeyParameters) asymmetricKeyParameter;
            ECDomainParameters parameters2 = eCPublicKeyParameters.getParameters();
            if (parameters2 == null) {
                x962Parameters = new X962Parameters((ASN1Null) DERNull.INSTANCE);
            } else {
                if (parameters2 instanceof ECGOST3410Parameters) {
                    ECGOST3410Parameters eCGOST3410Parameters = (ECGOST3410Parameters) parameters2;
                    r q8 = eCPublicKeyParameters.getQ();
                    q8.b();
                    BigInteger bigIntegerT = q8.f4818b.t();
                    BigInteger bigIntegerT2 = eCPublicKeyParameters.getQ().d().t();
                    GOST3410PublicKeyAlgParameters gOST3410PublicKeyAlgParameters = new GOST3410PublicKeyAlgParameters(eCGOST3410Parameters.getPublicKeyParamSet(), eCGOST3410Parameters.getDigestParamSet());
                    int i8 = 32;
                    int i9 = 64;
                    if (cryptoProOids.contains(eCGOST3410Parameters.getPublicKeyParamSet())) {
                        aSN1ObjectIdentifier = CryptoProObjectIdentifiers.gostR3410_2001;
                    } else if (bigIntegerT.bitLength() > 256) {
                        aSN1ObjectIdentifier = a.d;
                        i9 = 128;
                        i8 = 64;
                    } else {
                        aSN1ObjectIdentifier = a.f4176c;
                    }
                    byte[] bArr = new byte[i9];
                    int i10 = i9 / 2;
                    extractBytes(bArr, i10, 0, bigIntegerT);
                    extractBytes(bArr, i10, i8, bigIntegerT2);
                    try {
                        return new SubjectPublicKeyInfo(new AlgorithmIdentifier(aSN1ObjectIdentifier, gOST3410PublicKeyAlgParameters), new DEROctetString(bArr));
                    } catch (IOException unused) {
                        return null;
                    }
                }
                x962Parameters = parameters2 instanceof ECNamedDomainParameters ? new X962Parameters(((ECNamedDomainParameters) parameters2).getName()) : new X962Parameters(new X9ECParameters(parameters2.getCurve(), new X9ECPoint(parameters2.getG(), false), parameters2.getN(), parameters2.getH(), parameters2.getSeed()));
            }
            return new SubjectPublicKeyInfo(new AlgorithmIdentifier(X9ObjectIdentifiers.id_ecPublicKey, x962Parameters), eCPublicKeyParameters.getQ().g(false));
        }
        if (asymmetricKeyParameter instanceof X448PublicKeyParameters) {
            return new SubjectPublicKeyInfo(new AlgorithmIdentifier(i7.a.f3171b), ((X448PublicKeyParameters) asymmetricKeyParameter).getEncoded());
        }
        if (asymmetricKeyParameter instanceof X25519PublicKeyParameters) {
            return new SubjectPublicKeyInfo(new AlgorithmIdentifier(i7.a.f3170a), ((X25519PublicKeyParameters) asymmetricKeyParameter).getEncoded());
        }
        if (asymmetricKeyParameter instanceof Ed448PublicKeyParameters) {
            return new SubjectPublicKeyInfo(new AlgorithmIdentifier(i7.a.d), ((Ed448PublicKeyParameters) asymmetricKeyParameter).getEncoded());
        }
        if (asymmetricKeyParameter instanceof Ed25519PublicKeyParameters) {
            return new SubjectPublicKeyInfo(new AlgorithmIdentifier(i7.a.f3172c), ((Ed25519PublicKeyParameters) asymmetricKeyParameter).getEncoded());
        }
        if (asymmetricKeyParameter instanceof y7.a) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write((byte) (0 >>> 24));
            byteArrayOutputStream.write((byte) (0 >>> 16));
            byteArrayOutputStream.write((byte) (0 >>> 8));
            byteArrayOutputStream.write((byte) 0);
            try {
                throw null;
            } catch (Exception e9) {
                throw new RuntimeException(e9.getMessage(), e9);
            }
        }
        if (!(asymmetricKeyParameter instanceof c)) {
            throw new IOException("key parameters not recognized");
        }
        c cVar = (c) asymmetricKeyParameter;
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
        byteArrayOutputStream2.write((byte) (1 >>> 24));
        byteArrayOutputStream2.write((byte) (1 >>> 16));
        byteArrayOutputStream2.write((byte) (1 >>> 8));
        byteArrayOutputStream2.write((byte) 1);
        try {
            byteArrayOutputStream2.write(cVar.getEncoded());
            byte[] byteArray = byteArrayOutputStream2.toByteArray();
            return new SubjectPublicKeyInfo(new AlgorithmIdentifier(PKCSObjectIdentifiers.id_alg_hss_lms_hashsig), Arrays.concatenate(new byte[]{4, (byte) byteArray.length}, byteArray));
        } catch (Exception e10) {
            throw new RuntimeException(e10.getMessage(), e10);
        }
    }

    private static void extractBytes(byte[] bArr, int i8, int i9, BigInteger bigInteger) {
        byte[] byteArray = bigInteger.toByteArray();
        if (byteArray.length < i8) {
            byte[] bArr2 = new byte[i8];
            System.arraycopy(byteArray, 0, bArr2, i8 - byteArray.length, byteArray.length);
            byteArray = bArr2;
        }
        for (int i10 = 0; i10 != i8; i10++) {
            bArr[i9 + i10] = byteArray[(byteArray.length - 1) - i10];
        }
    }
}
