package org.bouncycastle.crypto.hpke;

import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;

/* loaded from: classes.dex */
public abstract class KEM {
    public abstract byte[] AuthDecap(byte[] bArr, AsymmetricCipherKeyPair asymmetricCipherKeyPair, AsymmetricKeyParameter asymmetricKeyParameter);

    public abstract byte[][] AuthEncap(AsymmetricKeyParameter asymmetricKeyParameter, AsymmetricCipherKeyPair asymmetricCipherKeyPair);

    public abstract byte[] Decap(byte[] bArr, AsymmetricCipherKeyPair asymmetricCipherKeyPair);

    public abstract AsymmetricCipherKeyPair DeriveKeyPair(byte[] bArr);

    public abstract AsymmetricCipherKeyPair DeserializePrivateKey(byte[] bArr, byte[] bArr2);

    public abstract AsymmetricKeyParameter DeserializePublicKey(byte[] bArr);

    public abstract byte[][] Encap(AsymmetricKeyParameter asymmetricKeyParameter);

    public abstract byte[][] Encap(AsymmetricKeyParameter asymmetricKeyParameter, AsymmetricCipherKeyPair asymmetricCipherKeyPair);

    public abstract AsymmetricCipherKeyPair GeneratePrivateKey();

    public abstract byte[] SerializePrivateKey(AsymmetricKeyParameter asymmetricKeyParameter);

    public abstract byte[] SerializePublicKey(AsymmetricKeyParameter asymmetricKeyParameter);

    public abstract int getEncryptionSize();
}
