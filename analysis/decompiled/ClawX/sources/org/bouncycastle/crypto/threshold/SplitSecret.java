package org.bouncycastle.crypto.threshold;

/* loaded from: classes.dex */
public interface SplitSecret {
    byte[] getSecret();

    SecretShare[] getSecretShares();
}
