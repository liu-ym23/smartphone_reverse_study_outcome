package com.google.crypto.tink.util;

import com.google.crypto.tink.SecretKeyAccess;
import com.google.crypto.tink.annotations.Alpha;
import com.google.crypto.tink.subtle.Random;
import g5.f;
import java.security.MessageDigest;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
@Alpha
/* loaded from: classes.dex */
public final class SecretBytes {
    private final Bytes bytes;

    private SecretBytes(Bytes bytes) {
        this.bytes = bytes;
    }

    public static SecretBytes copyFrom(byte[] bArr, SecretKeyAccess secretKeyAccess) {
        if (secretKeyAccess != null) {
            return new SecretBytes(Bytes.copyFrom(bArr));
        }
        f.g("SecretKeyAccess required");
        return null;
    }

    public static SecretBytes randomBytes(int i) {
        return new SecretBytes(Bytes.copyFrom(Random.randBytes(i)));
    }

    public boolean equalsSecretBytes(SecretBytes secretBytes) {
        return MessageDigest.isEqual(this.bytes.toByteArray(), secretBytes.bytes.toByteArray());
    }

    public int size() {
        return this.bytes.size();
    }

    public byte[] toByteArray(SecretKeyAccess secretKeyAccess) {
        if (secretKeyAccess != null) {
            return this.bytes.toByteArray();
        }
        f.g("SecretKeyAccess required");
        return null;
    }
}
