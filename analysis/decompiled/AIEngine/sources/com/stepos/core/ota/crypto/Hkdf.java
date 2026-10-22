package com.stepos.core.ota.crypto;

import ai.onnxruntime.a;
import androidx.datastore.preferences.protobuf.b1;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class Hkdf {
    private static final int HASH_LEN = 32;
    private static final String HMAC_SHA256 = "HmacSHA256";
    public static final Hkdf INSTANCE = new Hkdf();

    private Hkdf() {
    }

    private final byte[] expand(byte[] bArr, byte[] bArr2, int i10) throws IllegalStateException, NoSuchAlgorithmException, InvalidKeyException {
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(new SecretKeySpec(bArr, "HmacSHA256"));
        byte[] bArr3 = new byte[i10];
        byte[] bArrDoFinal = new byte[0];
        int i11 = 0;
        int i12 = 1;
        while (i11 < i10) {
            mac.reset();
            mac.update(bArrDoFinal);
            mac.update(bArr2);
            mac.update((byte) i12);
            bArrDoFinal = mac.doFinal();
            int iMin = Math.min(bArrDoFinal.length, i10 - i11);
            b1.n(i11, 0, iMin, bArrDoFinal, bArr3);
            i11 += iMin;
            i12++;
        }
        b1.H(bArrDoFinal);
        return bArr3;
    }

    private final byte[] extract(byte[] bArr, byte[] bArr2) throws IllegalStateException, NoSuchAlgorithmException, InvalidKeyException {
        if (bArr2 == null || bArr2.length == 0) {
            bArr2 = new byte[32];
        }
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(new SecretKeySpec(bArr2, "HmacSHA256"));
        byte[] bArrDoFinal = mac.doFinal(bArr);
        g.e(bArrDoFinal, "doFinal(...)");
        return bArrDoFinal;
    }

    public final byte[] derive(byte[] ikm, byte[] bArr, byte[] info, int i10) {
        g.f(ikm, "ikm");
        g.f(info, "info");
        if (1 > i10 || i10 >= 8161) {
            throw new IllegalArgumentException(a.g(i10, "hkdf length ", " out of range").toString());
        }
        byte[] bArrExtract = extract(ikm, bArr);
        try {
            return expand(bArrExtract, info, i10);
        } finally {
            b1.H(bArrExtract);
        }
    }
}
