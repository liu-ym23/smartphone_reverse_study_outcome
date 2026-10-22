package com.stepos.core.ota.crypto;

import android.util.Base64;
import gc.q;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.collections.a;
import kotlin.jvm.internal.g;
import mb.m;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class DeviceProof {
    public static final String ALG = "HmacSHA256";
    public static final DeviceProof INSTANCE = new DeviceProof();
    private static final String SEPARATOR = "|";

    private DeviceProof() {
    }

    public final String compute(String secret, String appId, String deviceId, String challenge, String fingerprint) throws NoSuchAlgorithmException, InvalidKeyException {
        g.f(secret, "secret");
        g.f(appId, "appId");
        g.f(deviceId, "deviceId");
        g.f(challenge, "challenge");
        g.f(fingerprint, "fingerprint");
        if (q.t0(secret)) {
            throw new IllegalArgumentException("fallback proof key not configured");
        }
        String strZ0 = a.z0(m.b0(appId, deviceId, challenge, fingerprint), SEPARATOR, null, null, null, 62);
        Mac mac = Mac.getInstance(ALG);
        Charset charset = gc.a.f9106b;
        byte[] bytes = secret.getBytes(charset);
        g.e(bytes, "getBytes(...)");
        mac.init(new SecretKeySpec(bytes, ALG));
        byte[] bytes2 = strZ0.getBytes(charset);
        g.e(bytes2, "getBytes(...)");
        String strEncodeToString = Base64.encodeToString(mac.doFinal(bytes2), 11);
        g.e(strEncodeToString, "encodeToString(...)");
        return strEncodeToString;
    }
}
