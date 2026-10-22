package com.google.crypto.tink.aead.internal;

import b8.z;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import g5.f;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.GeneralSecurityException;
import javax.crypto.AEADBadTagException;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
abstract class InsecureNonceChaCha20Poly1305Base {
    public static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_NOT_FIPS;
    private final InsecureNonceChaCha20Base chacha20;
    private final InsecureNonceChaCha20Base macKeyChaCha20;

    public InsecureNonceChaCha20Poly1305Base(byte[] bArr) throws GeneralSecurityException {
        if (!FIPS.isCompatible()) {
            z.l("Can not use ChaCha20Poly1305 in FIPS-mode.");
            throw null;
        }
        this.chacha20 = newChaCha20Instance(bArr, 1);
        this.macKeyChaCha20 = newChaCha20Instance(bArr, 0);
    }

    private byte[] getMacKey(byte[] bArr) {
        ByteBuffer byteBufferChacha20Block = this.macKeyChaCha20.chacha20Block(bArr, 0);
        byte[] bArr2 = new byte[32];
        byteBufferChacha20Block.get(bArr2);
        return bArr2;
    }

    private static byte[] macDataRfc8439(byte[] bArr, ByteBuffer byteBuffer) {
        int length = bArr.length % 16 == 0 ? bArr.length : (bArr.length + 16) - (bArr.length % 16);
        int iRemaining = byteBuffer.remaining();
        int i = iRemaining % 16;
        int i3 = (i == 0 ? iRemaining : (iRemaining + 16) - i) + length;
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(i3 + 16).order(ByteOrder.LITTLE_ENDIAN);
        byteBufferOrder.put(bArr);
        byteBufferOrder.position(length);
        byteBufferOrder.put(byteBuffer);
        byteBufferOrder.position(i3);
        byteBufferOrder.putLong(bArr.length);
        byteBufferOrder.putLong(iRemaining);
        return byteBufferOrder.array();
    }

    public byte[] decrypt(ByteBuffer byteBuffer, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (byteBuffer.remaining() < 16) {
            z.l("ciphertext too short");
            return null;
        }
        int iPosition = byteBuffer.position();
        byte[] bArr3 = new byte[16];
        byteBuffer.position(byteBuffer.limit() - 16);
        byteBuffer.get(bArr3);
        byteBuffer.position(iPosition);
        byteBuffer.limit(byteBuffer.limit() - 16);
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        try {
            Poly1305.verifyMac(getMacKey(bArr), macDataRfc8439(bArr2, byteBuffer), bArr3);
            byteBuffer.position(iPosition);
            return this.chacha20.decrypt(bArr, byteBuffer);
        } catch (GeneralSecurityException e10) {
            throw new AEADBadTagException(e10.toString());
        }
    }

    public void encrypt(ByteBuffer byteBuffer, byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        if (byteBuffer.remaining() < bArr2.length + 16) {
            f.s("Given ByteBuffer output is too small");
            return;
        }
        int iPosition = byteBuffer.position();
        this.chacha20.encrypt(byteBuffer, bArr, bArr2);
        byteBuffer.position(iPosition);
        byteBuffer.limit(byteBuffer.limit() - 16);
        if (bArr3 == null) {
            bArr3 = new byte[0];
        }
        byte[] bArrComputeMac = Poly1305.computeMac(getMacKey(bArr), macDataRfc8439(bArr3, byteBuffer));
        byteBuffer.limit(byteBuffer.limit() + 16);
        byteBuffer.put(bArrComputeMac);
    }

    public abstract InsecureNonceChaCha20Base newChaCha20Instance(byte[] bArr, int i);

    public byte[] encrypt(byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        if (bArr2.length <= 2147483631) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bArr2.length + 16);
            encrypt(byteBufferAllocate, bArr, bArr2, bArr3);
            return byteBufferAllocate.array();
        }
        z.l("plaintext too long");
        return null;
    }

    public byte[] decrypt(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return decrypt(ByteBuffer.wrap(bArr2), bArr, bArr3);
    }
}
