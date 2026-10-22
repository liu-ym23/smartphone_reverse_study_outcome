package com.google.crypto.tink.util;

import com.google.crypto.tink.SecretKeyAccess;
import com.google.crypto.tink.annotations.Alpha;
import g5.f;
import java.math.BigInteger;
import java.security.MessageDigest;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
@Alpha
/* loaded from: classes.dex */
public final class SecretBigInteger {
    private final BigInteger value;

    private SecretBigInteger(BigInteger bigInteger) {
        this.value = bigInteger;
    }

    public static SecretBigInteger fromBigInteger(BigInteger bigInteger, SecretKeyAccess secretKeyAccess) {
        if (secretKeyAccess != null) {
            return new SecretBigInteger(bigInteger);
        }
        f.g("SecretKeyAccess required");
        return null;
    }

    public boolean equalsSecretBigInteger(SecretBigInteger secretBigInteger) {
        return MessageDigest.isEqual(this.value.toByteArray(), secretBigInteger.value.toByteArray());
    }

    public BigInteger getBigInteger(SecretKeyAccess secretKeyAccess) {
        if (secretKeyAccess != null) {
            return this.value;
        }
        f.g("SecretKeyAccess required");
        return null;
    }
}
