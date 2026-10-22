package com.google.crypto.tink.aead.internal;

import com.google.crypto.tink.subtle.Bytes;
import g5.f;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
abstract class InsecureNonceChaCha20Base {
    private final int initialCounter;
    int[] key;

    public InsecureNonceChaCha20Base(byte[] bArr, int i) throws InvalidKeyException {
        if (bArr.length != 32) {
            throw new InvalidKeyException("The key length in bytes must be 32.");
        }
        this.key = ChaCha20Util.toIntArray(bArr);
        this.initialCounter = i;
    }

    private void process(byte[] bArr, ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws GeneralSecurityException {
        if (bArr.length != nonceSizeInBytes()) {
            throw new GeneralSecurityException("The nonce length (in bytes) must be " + nonceSizeInBytes());
        }
        int iRemaining = byteBuffer2.remaining();
        int i = iRemaining / 64;
        int i3 = i + 1;
        for (int i10 = 0; i10 < i3; i10++) {
            ByteBuffer byteBufferChacha20Block = chacha20Block(bArr, this.initialCounter + i10);
            if (i10 == i) {
                Bytes.xor(byteBuffer, byteBuffer2, byteBufferChacha20Block, iRemaining % 64);
            } else {
                Bytes.xor(byteBuffer, byteBuffer2, byteBufferChacha20Block, 64);
            }
        }
    }

    public ByteBuffer chacha20Block(byte[] bArr, int i) {
        int[] iArrCreateInitialState = createInitialState(ChaCha20Util.toIntArray(bArr), i);
        int[] iArr = (int[]) iArrCreateInitialState.clone();
        ChaCha20Util.shuffleState(iArr);
        for (int i3 = 0; i3 < iArrCreateInitialState.length; i3++) {
            iArrCreateInitialState[i3] = iArrCreateInitialState[i3] + iArr[i3];
        }
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(64).order(ByteOrder.LITTLE_ENDIAN);
        byteBufferOrder.asIntBuffer().put(iArrCreateInitialState, 0, 16);
        return byteBufferOrder;
    }

    public abstract int[] createInitialState(int[] iArr, int i);

    public byte[] decrypt(byte[] bArr, ByteBuffer byteBuffer) throws GeneralSecurityException {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(byteBuffer.remaining());
        process(bArr, byteBufferAllocate, byteBuffer);
        return byteBufferAllocate.array();
    }

    public void encrypt(ByteBuffer byteBuffer, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (byteBuffer.remaining() >= bArr2.length) {
            process(bArr, byteBuffer, ByteBuffer.wrap(bArr2));
        } else {
            f.s("Given ByteBuffer output is too small");
        }
    }

    public abstract int nonceSizeInBytes();

    public byte[] decrypt(byte[] bArr, byte[] bArr2) {
        return decrypt(bArr, ByteBuffer.wrap(bArr2));
    }

    public byte[] encrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bArr2.length);
        encrypt(byteBufferAllocate, bArr, bArr2);
        return byteBufferAllocate.array();
    }
}
