package io.ktor.network.tls;

import fb.v;
import fb.x;
import io.ktor.network.tls.extensions.HashAndSign;
import io.ktor.network.tls.extensions.NamedCurve;
import io.ktor.network.tls.extensions.SignatureAlgorithmKt;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import javax.security.auth.x500.X500Principal;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\n\u001a\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0000¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Ljava/security/SecureRandom;", "", "generateClientSeed", "(Ljava/security/SecureRandom;)[B", "Lio/ktor/network/tls/extensions/NamedCurve;", "curve", "Ljava/security/spec/ECPoint;", "serverPoint", "Lio/ktor/network/tls/EncryptionInfo;", "generateECKeys", "(Lio/ktor/network/tls/extensions/NamedCurve;Ljava/security/spec/ECPoint;)Lio/ktor/network/tls/EncryptionInfo;", "Lfb/v;", "packet", "Lio/ktor/network/tls/CertificateInfo;", "readClientCertificateRequest", "(Lfb/v;)Lio/ktor/network/tls/CertificateInfo;", "ktor-network-tls"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class TLSClientHandshakeKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final byte[] generateClientSeed(SecureRandom secureRandom) {
        byte[] bArr = new byte[32];
        secureRandom.nextBytes(bArr);
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        bArr[0] = (byte) (jCurrentTimeMillis >> 24);
        bArr[1] = (byte) (jCurrentTimeMillis >> 16);
        bArr[2] = (byte) (jCurrentTimeMillis >> 8);
        bArr[3] = (byte) jCurrentTimeMillis;
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EncryptionInfo generateECKeys(NamedCurve namedCurve, ECPoint eCPoint) throws InvalidKeySpecException, NoSuchAlgorithmException, InvalidAlgorithmParameterException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("EC");
        p.f(keyPairGenerator);
        keyPairGenerator.initialize(new ECGenParameterSpec(namedCurve.name()));
        KeyPair keyPairGenerateKeyPair = keyPairGenerator.generateKeyPair();
        p.f(keyPairGenerateKeyPair);
        PublicKey publicKey = keyPairGenerateKeyPair.getPublic();
        p.g(publicKey, "null cannot be cast to non-null type java.security.interfaces.ECPublicKey");
        KeyFactory keyFactory = KeyFactory.getInstance("EC");
        p.f(keyFactory);
        ECParameterSpec params = ((ECPublicKey) publicKey).getParams();
        p.f(params);
        PublicKey publicKeyGeneratePublic = keyFactory.generatePublic(new ECPublicKeySpec(eCPoint, params));
        p.f(publicKeyGeneratePublic);
        PublicKey publicKey2 = keyPairGenerateKeyPair.getPublic();
        p.h(publicKey2, "getPublic(...)");
        PrivateKey privateKey = keyPairGenerateKeyPair.getPrivate();
        p.h(privateKey, "getPrivate(...)");
        return new EncryptionInfo(publicKeyGeneratePublic, publicKey2, privateKey);
    }

    public static final CertificateInfo readClientCertificateRequest(v packet) {
        p.i(packet, "packet");
        byte[] bArrD = x.d(packet, packet.readByte() & 255);
        int i10 = packet.readShort() & 65535;
        ArrayList arrayList = new ArrayList();
        int i11 = i10 / 2;
        for (int i12 = 0; i12 < i11; i12++) {
            HashAndSign hashAndSignByCode = SignatureAlgorithmKt.byCode(HashAndSign.INSTANCE, packet.readByte(), packet.readByte());
            if (hashAndSignByCode != null) {
                arrayList.add(hashAndSignByCode);
            }
        }
        int i13 = packet.readShort() & 65535;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int i14 = 0;
        while (i14 < i13) {
            int i15 = packet.readShort() & 65535;
            i14 += i15 + 2;
            linkedHashSet.add(new X500Principal(x.d(packet, i15)));
        }
        CertificateInfo certificateInfo = new CertificateInfo(bArrD, (HashAndSign[]) arrayList.toArray(new HashAndSign[0]), linkedHashSet);
        if (packet.k()) {
            return certificateInfo;
        }
        throw new IllegalStateException("Check failed.");
    }
}
