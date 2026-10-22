package io.ktor.network.tls;

import Z8.C1173v;
import com.stepos.ailauncher.chat.wake.circle.F;
import io.ktor.network.tls.extensions.HashAlgorithm;
import io.ktor.network.tls.extensions.SignatureAlgorithm;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010 \n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\bR\u0017\u0010\u000b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\bR\u0017\u0010\r\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\bR\u0017\u0010\u000f\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0006\u001a\u0004\b\u0010\u0010\bR\u0017\u0010\u0011\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u0012\u0010\bR\u0017\u0010\u0013\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0014\u0010\bR\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u00158\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lio/ktor/network/tls/CIOCipherSuites;", "", "<init>", "()V", "Lio/ktor/network/tls/CipherSuite;", "TLS_RSA_WITH_AES_128_GCM_SHA256", "Lio/ktor/network/tls/CipherSuite;", "getTLS_RSA_WITH_AES_128_GCM_SHA256", "()Lio/ktor/network/tls/CipherSuite;", "ECDHE_ECDSA_AES256_SHA384", "getECDHE_ECDSA_AES256_SHA384", "ECDHE_ECDSA_AES128_SHA256", "getECDHE_ECDSA_AES128_SHA256", "ECDHE_RSA_AES256_SHA384", "getECDHE_RSA_AES256_SHA384", "ECDHE_RSA_AES128_SHA256", "getECDHE_RSA_AES128_SHA256", "TLS_RSA_WITH_AES256_CBC_SHA", "getTLS_RSA_WITH_AES256_CBC_SHA", "TLS_RSA_WITH_AES128_CBC_SHA", "getTLS_RSA_WITH_AES128_CBC_SHA", "", "SupportedSuites", "Ljava/util/List;", "getSupportedSuites", "()Ljava/util/List;", "ktor-network-tls"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CIOCipherSuites {
    private static final CipherSuite ECDHE_ECDSA_AES128_SHA256;
    private static final CipherSuite ECDHE_ECDSA_AES256_SHA384;
    private static final CipherSuite ECDHE_RSA_AES128_SHA256;
    private static final CipherSuite ECDHE_RSA_AES256_SHA384;
    public static final CIOCipherSuites INSTANCE = new CIOCipherSuites();
    private static final List<CipherSuite> SupportedSuites;
    private static final CipherSuite TLS_RSA_WITH_AES128_CBC_SHA;
    private static final CipherSuite TLS_RSA_WITH_AES256_CBC_SHA;
    private static final CipherSuite TLS_RSA_WITH_AES_128_GCM_SHA256;

    static {
        SecretExchangeType secretExchangeType = SecretExchangeType.RSA;
        HashAlgorithm hashAlgorithm = HashAlgorithm.SHA256;
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.RSA;
        CipherSuite cipherSuite = new CipherSuite((short) 156, "TLS_RSA_WITH_AES_128_GCM_SHA256", "AES128-GCM-SHA256", secretExchangeType, "AES/GCM/NoPadding", 128, 4, 12, 16, "AEAD", 0, hashAlgorithm, signatureAlgorithm, null, com.stepos.agentframework.chatui.longtext.b.THRESHOLD, null);
        TLS_RSA_WITH_AES_128_GCM_SHA256 = cipherSuite;
        SecretExchangeType secretExchangeType2 = SecretExchangeType.ECDHE;
        HashAlgorithm hashAlgorithm2 = HashAlgorithm.SHA384;
        SignatureAlgorithm signatureAlgorithm2 = SignatureAlgorithm.ECDSA;
        CipherSuite cipherSuite2 = new CipherSuite((short) -16340, "TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", "ECDHE-ECDSA-AES256-GCM-SHA384", secretExchangeType2, "AES/GCM/NoPadding", 256, 4, 12, 16, "AEAD", 0, hashAlgorithm2, signatureAlgorithm2, null, com.stepos.agentframework.chatui.longtext.b.THRESHOLD, null);
        ECDHE_ECDSA_AES256_SHA384 = cipherSuite2;
        CipherSuite cipherSuite3 = new CipherSuite((short) -16341, "TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", "ECDHE-ECDSA-AES128-GCM-SHA256", secretExchangeType2, "AES/GCM/NoPadding", 128, 4, 12, 16, "AEAD", 0, hashAlgorithm, signatureAlgorithm2, null, com.stepos.agentframework.chatui.longtext.b.THRESHOLD, null);
        ECDHE_ECDSA_AES128_SHA256 = cipherSuite3;
        CipherSuite cipherSuite4 = new CipherSuite((short) -16336, "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", "ECDHE-RSA-AES256-GCM-SHA384", secretExchangeType2, "AES/GCM/NoPadding", 256, 4, 12, 16, "AEAD", 0, hashAlgorithm2, signatureAlgorithm, null, com.stepos.agentframework.chatui.longtext.b.THRESHOLD, null);
        ECDHE_RSA_AES256_SHA384 = cipherSuite4;
        CipherSuite cipherSuite5 = new CipherSuite((short) -16337, "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", "ECDHE-RSA-AES128-GCM-SHA256", secretExchangeType2, "AES/GCM/NoPadding", 128, 4, 12, 16, "AEAD", 0, hashAlgorithm, signatureAlgorithm, null, com.stepos.agentframework.chatui.longtext.b.THRESHOLD, null);
        ECDHE_RSA_AES128_SHA256 = cipherSuite5;
        CipherType cipherType = CipherType.CBC;
        CipherSuite cipherSuite6 = new CipherSuite((short) 53, "TLS_RSA_WITH_AES_256_CBC_SHA", "AES-256-CBC-SHA", secretExchangeType, "AES/CBC/NoPadding", 256, 16, 48, 20, "HmacSHA1", F.LOOP_END_FRAME, hashAlgorithm, signatureAlgorithm, cipherType);
        TLS_RSA_WITH_AES256_CBC_SHA = cipherSuite6;
        CipherSuite cipherSuite7 = new CipherSuite((short) 47, "TLS_RSA_WITH_AES_128_CBC_SHA", "AES-128-CBC-SHA", secretExchangeType, "AES/CBC/NoPadding", 128, 16, 48, 20, "HmacSHA1", F.LOOP_END_FRAME, hashAlgorithm, signatureAlgorithm, cipherType);
        TLS_RSA_WITH_AES128_CBC_SHA = cipherSuite7;
        List listP = C1173v.p(cipherSuite2, cipherSuite4, cipherSuite3, cipherSuite5, cipherSuite, cipherSuite6, cipherSuite7);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listP) {
            if (CipherSuitesJvmKt.isSupported((CipherSuite) obj)) {
                arrayList.add(obj);
            }
        }
        SupportedSuites = arrayList;
    }

    private CIOCipherSuites() {
    }

    public final CipherSuite getECDHE_ECDSA_AES128_SHA256() {
        return ECDHE_ECDSA_AES128_SHA256;
    }

    public final CipherSuite getECDHE_ECDSA_AES256_SHA384() {
        return ECDHE_ECDSA_AES256_SHA384;
    }

    public final CipherSuite getECDHE_RSA_AES128_SHA256() {
        return ECDHE_RSA_AES128_SHA256;
    }

    public final CipherSuite getECDHE_RSA_AES256_SHA384() {
        return ECDHE_RSA_AES256_SHA384;
    }

    public final List<CipherSuite> getSupportedSuites() {
        return SupportedSuites;
    }

    public final CipherSuite getTLS_RSA_WITH_AES128_CBC_SHA() {
        return TLS_RSA_WITH_AES128_CBC_SHA;
    }

    public final CipherSuite getTLS_RSA_WITH_AES256_CBC_SHA() {
        return TLS_RSA_WITH_AES256_CBC_SHA;
    }

    public final CipherSuite getTLS_RSA_WITH_AES_128_GCM_SHA256() {
        return TLS_RSA_WITH_AES_128_GCM_SHA256;
    }
}
