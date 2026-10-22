package com.google.crypto.tink.aead.subtle;

import androidx.activity.b;
import com.google.crypto.tink.Aead;
import com.google.crypto.tink.subtle.AesGcmJce;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class AesGcmFactory implements AeadFactory {
    private final int keySizeInBytes;

    public AesGcmFactory(int i) {
        this.keySizeInBytes = validateAesKeySize(i);
    }

    private static int validateAesKeySize(int i) throws InvalidAlgorithmParameterException {
        if (i == 16 || i == 32) {
            return i;
        }
        throw new InvalidAlgorithmParameterException(String.format("Invalid AES key size, expected 16 or 32, but got %d", Integer.valueOf(i)));
    }

    @Override // com.google.crypto.tink.aead.subtle.AeadFactory
    public Aead createAead(byte[] bArr) throws GeneralSecurityException {
        if (bArr.length == getKeySizeInBytes()) {
            return new AesGcmJce(bArr);
        }
        throw new GeneralSecurityException(b.i("Symmetric key has incorrect length; expected ", getKeySizeInBytes(), ", but got ", bArr.length));
    }

    @Override // com.google.crypto.tink.aead.subtle.AeadFactory
    public int getKeySizeInBytes() {
        return this.keySizeInBytes;
    }
}
