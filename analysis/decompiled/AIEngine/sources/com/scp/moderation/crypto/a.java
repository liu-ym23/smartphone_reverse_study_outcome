package com.scp.moderation.crypto;

import com.stepos.core.common.util.TraceIdKeys;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f5547a = {83, 67, 80, 45, 109, 111, 100, 101, 114, 97, 116, 105, 111, 110, 45, 119, 111, 114, 100, 115, 45, 107, 101, 121, 45, 118, 49, 46, 48, 46, 48, 33};

    public static byte[] a(byte[] bArr) throws WordCipherException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        try {
            if (byteBufferWrap.getInt() != 1396920386) {
                throw new WordCipherException("bad package magic");
            }
            int i10 = byteBufferWrap.getShort() & 65535;
            if (i10 != 2) {
                throw new WordCipherException("unsupported package version: " + i10);
            }
            int i11 = byteBufferWrap.get() & 255;
            if (i11 != 12) {
                throw new WordCipherException("bad nonce length: " + i11);
            }
            byte[] bArr2 = new byte[i11];
            byteBufferWrap.get(bArr2);
            int iRemaining = byteBufferWrap.remaining();
            byte[] bArr3 = new byte[iRemaining];
            byteBufferWrap.get(bArr3);
            if (iRemaining == 0) {
                throw new WordCipherException("empty ciphertext");
            }
            try {
                Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
                cipher.init(2, new SecretKeySpec(f5547a, "AES"), new GCMParameterSpec(TraceIdKeys.MAX_LENGTH, bArr2));
                return cipher.doFinal(bArr3);
            } catch (Exception e10) {
                throw new WordCipherException("AES-GCM decrypt failed", e10);
            }
        } catch (BufferUnderflowException e11) {
            throw new WordCipherException("truncated package", e11);
        }
    }
}
