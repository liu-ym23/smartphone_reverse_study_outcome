package com.google.crypto.tink;

import b8.z;
import com.google.crypto.tink.annotations.Alpha;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
@Alpha
/* loaded from: classes.dex */
public final class SecretKeyAccess {
    private static final SecretKeyAccess INSTANCE = new SecretKeyAccess();

    private SecretKeyAccess() {
    }

    public static SecretKeyAccess instance() {
        return INSTANCE;
    }

    public static SecretKeyAccess requireAccess(@Nullable SecretKeyAccess secretKeyAccess) throws GeneralSecurityException {
        if (secretKeyAccess != null) {
            return secretKeyAccess;
        }
        z.l("SecretKeyAccess is required");
        return null;
    }
}
