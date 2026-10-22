package com.stepos.core.ota.crypto;

import ai.onnxruntime.providers.a;
import androidx.datastore.preferences.protobuf.b1;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class FekEnvelope {
    public static final String ALG = "ECDH-ES+HKDF-SHA256+A256GCM";
    public static final int EXPECTED_CIPHERTEXT_CHARS = 64;
    public static final int EXPECTED_EPK_CHARS = 122;
    public static final int EXPECTED_IV_CHARS = 16;
    private static final int GCM_TAG_BITS = 128;
    private static final String INFO_PREFIX = "zyql-model-fek-v1";
    public static final FekEnvelope INSTANCE = new FekEnvelope();
    private static final int KEK_BYTES = 32;
    private static final byte SEPARATOR = 0;

    private FekEnvelope() {
    }

    public final byte[] buildInfo(String deviceAppId, String deviceId, String fingerprint, int i10) {
        g.f(deviceAppId, "deviceAppId");
        g.f(deviceId, "deviceId");
        g.f(fingerprint, "fingerprint");
        if (fingerprint.length() != 64) {
            throw new IllegalArgumentException(a.a(fingerprint.length(), "fingerprint must be 64 hex chars, got ").toString());
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Charset charset = gc.a.f9106b;
        byte[] bytes = INFO_PREFIX.getBytes(charset);
        g.e(bytes, "getBytes(...)");
        byteArrayOutputStream.write(bytes);
        byteArrayOutputStream.write(0);
        byte[] bytes2 = deviceAppId.getBytes(charset);
        g.e(bytes2, "getBytes(...)");
        byteArrayOutputStream.write(bytes2);
        byteArrayOutputStream.write(0);
        byte[] bytes3 = deviceId.getBytes(charset);
        g.e(bytes3, "getBytes(...)");
        byteArrayOutputStream.write(bytes3);
        byteArrayOutputStream.write(0);
        byte[] bytes4 = fingerprint.getBytes(gc.a.f9109e);
        g.e(bytes4, "getBytes(...)");
        byteArrayOutputStream.write(bytes4);
        byteArrayOutputStream.write(0);
        byteArrayOutputStream.write(ByteBuffer.allocate(4).order(ByteOrder.BIG_ENDIAN).putInt(i10).array());
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        g.e(byteArray, "toByteArray(...)");
        return byteArray;
    }

    public final byte[] open(PrivateKey privateKey, byte[] epkSpki, byte[] iv, byte[] ciphertext, byte[] info) throws IllegalStateException, InvalidKeySpecException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException {
        g.f(privateKey, "privateKey");
        g.f(epkSpki, "epkSpki");
        g.f(iv, "iv");
        g.f(ciphertext, "ciphertext");
        g.f(info, "info");
        PublicKey publicKeyGeneratePublic = KeyFactory.getInstance("EC").generatePublic(new X509EncodedKeySpec(epkSpki));
        KeyAgreement keyAgreement = KeyAgreement.getInstance("ECDH", "AndroidKeyStore");
        keyAgreement.init(privateKey);
        keyAgreement.doPhase(publicKeyGeneratePublic, true);
        byte[] bArrGenerateSecret = keyAgreement.generateSecret();
        try {
            Hkdf hkdf = Hkdf.INSTANCE;
            g.c(bArrGenerateSecret);
            byte[] bArrDerive = hkdf.derive(bArrGenerateSecret, new byte[0], info, 32);
            b1.H(bArrGenerateSecret);
            try {
                Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
                cipher.init(2, new SecretKeySpec(bArrDerive, "AES"), new GCMParameterSpec(128, iv));
                cipher.updateAAD(info);
                return cipher.doFinal(ciphertext);
            } finally {
                b1.H(bArrDerive);
            }
        } catch (Throwable th) {
            g.c(bArrGenerateSecret);
            b1.H(bArrGenerateSecret);
            throw th;
        }
    }
}
