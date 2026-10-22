package com.stepos.policy.sdk.util;

import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0012\u0004\u0012\u00020\u00070\u00042\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Lcom/stepos/policy/sdk/util/PolicySdkSafeCertEncryptor;", "", "()V", "encryptorByPublicKey", "Lkotlin/Pair;", "", "", "Ljavax/crypto/Cipher;", "fis", "Ljava/io/InputStream;", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PolicySdkSafeCertEncryptor {

    @NotNull
    public static final PolicySdkSafeCertEncryptor INSTANCE = new PolicySdkSafeCertEncryptor();

    private PolicySdkSafeCertEncryptor() {
    }

    @NotNull
    public final Pair<Pair<Integer, String>, Cipher> encryptorByPublicKey(@NotNull InputStream fis) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, CertificateException {
        Intrinsics.checkNotNullParameter(fis, "fis");
        Certificate certificateGenerateCertificate = CertificateFactory.getInstance("X.509").generateCertificate(fis);
        Intrinsics.checkNotNull(certificateGenerateCertificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
        X509Certificate x509Certificate = (X509Certificate) certificateGenerateCertificate;
        byte[] byteArray = x509Certificate.getSerialNumber().toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "loadedCert.serialNumber.toByteArray()");
        StringBuilder sb = new StringBuilder();
        for (byte b4 : byteArray) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format("%02X", Arrays.copyOf(new Object[]{Byte.valueOf(b4)}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
            sb.append(str);
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "serialNumber.toString()");
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(1, x509Certificate.getPublicKey());
        return TuplesKt.to(TuplesKt.to(Integer.valueOf(x509Certificate.getVersion()), string), cipher);
    }
}
