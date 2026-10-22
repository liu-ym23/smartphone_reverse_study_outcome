package com.stepos.core.ota.crypto;

import ai.onnxruntime.providers.a;
import androidx.datastore.preferences.protobuf.b1;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class DekEnvelope {
    private static final int GCM_TAG_BITS = 128;
    public static final DekEnvelope INSTANCE = new DekEnvelope();
    private static final int IV_LEN = 12;

    private DekEnvelope() {
    }

    public final byte[] unwrap(SecretKey kek, byte[] wrapped) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        g.f(kek, "kek");
        g.f(wrapped, "wrapped");
        if (wrapped.length <= 12) {
            throw new IllegalArgumentException(a.a(wrapped.length, "wrapped too short: ").toString());
        }
        byte[] bArrU = b1.u(wrapped, 0, 12);
        byte[] bArrU2 = b1.u(wrapped, 12, wrapped.length);
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(2, kek, new GCMParameterSpec(128, bArrU));
        byte[] bArrDoFinal = cipher.doFinal(bArrU2);
        g.e(bArrDoFinal, "doFinal(...)");
        return bArrDoFinal;
    }

    public final byte[] wrap(SecretKey kek, byte[] dek) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException {
        g.f(kek, "kek");
        g.f(dek, "dek");
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(1, kek);
        byte[] bArrDoFinal = cipher.doFinal(dek);
        byte[] iv = cipher.getIV();
        g.e(iv, "getIV(...)");
        g.c(bArrDoFinal);
        int length = iv.length;
        int length2 = bArrDoFinal.length;
        byte[] bArrCopyOf = Arrays.copyOf(iv, length + length2);
        System.arraycopy(bArrDoFinal, 0, bArrCopyOf, length, length2);
        g.c(bArrCopyOf);
        return bArrCopyOf;
    }
}
