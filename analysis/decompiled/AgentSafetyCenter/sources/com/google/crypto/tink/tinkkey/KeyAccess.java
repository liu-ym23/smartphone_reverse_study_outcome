package com.google.crypto.tink.tinkkey;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
@Deprecated
/* loaded from: classes.dex */
public final class KeyAccess {
    private final boolean canAccessSecret;

    private KeyAccess(boolean z10) {
        this.canAccessSecret = z10;
    }

    public static KeyAccess publicAccess() {
        return new KeyAccess(false);
    }

    public static KeyAccess secretAccess() {
        return new KeyAccess(true);
    }

    public boolean canAccessSecret() {
        return this.canAccessSecret;
    }
}
