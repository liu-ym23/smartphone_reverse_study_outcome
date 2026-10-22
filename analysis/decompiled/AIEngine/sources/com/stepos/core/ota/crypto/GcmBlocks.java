package com.stepos.core.ota.crypto;

import ai.onnxruntime.providers.a;
import androidx.datastore.preferences.protobuf.b1;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class GcmBlocks {
    private static final int AAD_LEN = 9;
    public static final GcmBlocks INSTANCE = new GcmBlocks();
    private static final int NONCE_LEN = 12;
    private static final int NONCE_PREFIX_LEN = 8;
    private static final int TAG_BITS = 128;

    private GcmBlocks() {
    }

    public final byte[] aad(int i10, int i11) {
        byte[] bArrArray = ByteBuffer.allocate(9).order(ByteOrder.BIG_ENDIAN).putInt(CryptoHeaderParser.MAGIC_ENCRYPTED).put((byte) i10).putInt(i11).array();
        g.e(bArrArray, "array(...)");
        return bArrArray;
    }

    public final byte[] decrypt(SecretKeySpec key, byte[] iv, int i10, int i11, byte[] cipherBlock) {
        g.f(key, "key");
        g.f(iv, "iv");
        g.f(cipherBlock, "cipherBlock");
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(2, key, new GCMParameterSpec(128, nonce(iv, i11)));
        cipher.updateAAD(aad(i10, i11));
        byte[] bArrDoFinal = cipher.doFinal(cipherBlock);
        g.e(bArrDoFinal, "doFinal(...)");
        return bArrDoFinal;
    }

    public final byte[] encrypt(SecretKeySpec key, byte[] iv, int i10, int i11, byte[] plainBlock) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        g.f(key, "key");
        g.f(iv, "iv");
        g.f(plainBlock, "plainBlock");
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(1, key, new GCMParameterSpec(128, nonce(iv, i11)));
        cipher.updateAAD(aad(i10, i11));
        byte[] bArrDoFinal = cipher.doFinal(plainBlock);
        g.e(bArrDoFinal, "doFinal(...)");
        return bArrDoFinal;
    }

    public final byte[] nonce(byte[] iv, int i10) {
        g.f(iv, "iv");
        if (iv.length < 8) {
            throw new IllegalArgumentException(a.a(iv.length, "iv too short: ").toString());
        }
        byte[] bArr = new byte[12];
        b1.n(0, 0, 8, iv, bArr);
        ByteBuffer.wrap(bArr, 8, 4).order(ByteOrder.BIG_ENDIAN).putInt(i10);
        return bArr;
    }
}
